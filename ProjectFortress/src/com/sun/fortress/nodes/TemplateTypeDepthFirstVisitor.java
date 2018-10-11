package com.sun.fortress.nodes;

import java.lang.String;
import java.math.BigInteger;
import java.io.Writer;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedList;
import com.sun.fortress.nodes_util.*;
import com.sun.fortress.parser_util.*;
import com.sun.fortress.parser_util.precedence_opexpr.*;
import com.sun.fortress.useful.*;
import edu.rice.cs.plt.tuple.Option;

/** A parametric abstract implementation of a visitor over Type that returns a value.
 ** This visitor implements the visitor interface with methods that 
 ** first visit children, and then call forCASEOnly(), passing in 
 ** the values of the visits of the children. (CASE is replaced by the case name.)
 ** By default, each of forCASEOnly delegates to a more general case; at the
 ** top of this delegation tree is defaultCase(), which (unless overridden)
 ** throws an exception.
 **/
@SuppressWarnings(value={"unused"})
public abstract class TemplateTypeDepthFirstVisitor<RetType> extends TypeVisitorLambda<RetType> {
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, an exception is thrown; subclasses may override this behavior.
     * @throws IllegalArgumentException
    **/
    public RetType defaultCase(Type that) {
        throw new IllegalArgumentException("Visitor " + getClass().getName() + " does not support visiting values of type " + that.getClass().getName());
    }

    /* Methods to handle a node after recursion. */
    public RetType forTypeOnly(Type that) {
        return defaultCase(that);
    }

    public RetType forBaseTypeOnly(BaseType that) {
        return forTypeOnly(that);
    }

    public RetType forAnyTypeOnly(AnyType that) {
        return forBaseTypeOnly(that);
    }

    public RetType forBottomTypeOnly(BottomType that) {
        return forBaseTypeOnly(that);
    }

    public RetType forUnknownTypeOnly(UnknownType that) {
        return forBaseTypeOnly(that);
    }

    public RetType forSelfTypeOnly(SelfType that) {
        return forBaseTypeOnly(that);
    }

    public RetType forTraitSelfTypeOnly(TraitSelfType that, RetType named_result, List<RetType> comprised_result) {
        return forSelfTypeOnly(that);
    }

    public RetType forObjectExprTypeOnly(ObjectExprType that, List<RetType> extended_result) {
        return forSelfTypeOnly(that);
    }

    public RetType forNamedTypeOnly(NamedType that) {
        return forBaseTypeOnly(that);
    }

    public RetType for_InferenceVarTypeOnly(_InferenceVarType that) {
        return forNamedTypeOnly(that);
    }

    public RetType forVarTypeOnly(VarType that) {
        return forNamedTypeOnly(that);
    }

    public RetType forTraitTypeOnly(TraitType that) {
        return forNamedTypeOnly(that);
    }

    public RetType forAbbreviatedTypeOnly(AbbreviatedType that, RetType elemType_result) {
        return forBaseTypeOnly(that);
    }

    public RetType forArrayTypeOnly(ArrayType that, RetType elemType_result) {
        return forAbbreviatedTypeOnly(that, elemType_result);
    }

    public RetType forMatrixTypeOnly(MatrixType that, RetType elemType_result) {
        return forAbbreviatedTypeOnly(that, elemType_result);
    }

    public RetType forTaggedDimTypeOnly(TaggedDimType that, RetType elemType_result, RetType dimExpr_result) {
        return forAbbreviatedTypeOnly(that, elemType_result);
    }

    public RetType forTaggedUnitTypeOnly(TaggedUnitType that, RetType elemType_result) {
        return forAbbreviatedTypeOnly(that, elemType_result);
    }

    public RetType forTupleTypeOnly(TupleType that, List<RetType> elements_result, Option<RetType> varargs_result) {
        return forTypeOnly(that);
    }

    public RetType forArrowTypeOnly(ArrowType that, RetType domain_result, RetType range_result) {
        return forTypeOnly(that);
    }

    public RetType forBoundTypeOnly(BoundType that, List<RetType> elements_result) {
        return forTypeOnly(that);
    }

    public RetType forIntersectionTypeOnly(IntersectionType that, List<RetType> elements_result) {
        return forBoundTypeOnly(that, elements_result);
    }

    public RetType forUnionTypeOnly(UnionType that, List<RetType> elements_result) {
        return forBoundTypeOnly(that, elements_result);
    }

    public RetType forFixedPointTypeOnly(FixedPointType that, RetType name_result, RetType body_result) {
        return forTypeOnly(that);
    }

    public RetType forLabelTypeOnly(LabelType that) {
        return forTypeOnly(that);
    }

    public RetType forDimExprOnly(DimExpr that) {
        return forTypeOnly(that);
    }

    public RetType forDimBaseOnly(DimBase that) {
        return forDimExprOnly(that);
    }

    public RetType forDimRefOnly(DimRef that) {
        return forDimExprOnly(that);
    }

    public RetType forDimExponentOnly(DimExponent that, RetType base_result) {
        return forDimExprOnly(that);
    }

    public RetType forDimUnaryOpOnly(DimUnaryOp that, RetType dimVal_result) {
        return forDimExprOnly(that);
    }

    public RetType forDimBinaryOpOnly(DimBinaryOp that, RetType left_result, RetType right_result) {
        return forDimExprOnly(that);
    }

    public RetType for_SyntaxTransformationTypeOnly(_SyntaxTransformationType that) {
        return forTypeOnly(that);
    }

    public RetType for_SyntaxTransformationBaseTypeOnly(_SyntaxTransformationBaseType that) {
        return forBaseTypeOnly(that);
    }

    public RetType for_SyntaxTransformationAnyTypeOnly(_SyntaxTransformationAnyType that) {
        return forAnyTypeOnly(that);
    }

    public RetType for_SyntaxTransformationBottomTypeOnly(_SyntaxTransformationBottomType that) {
        return forBottomTypeOnly(that);
    }

    public RetType for_SyntaxTransformationUnknownTypeOnly(_SyntaxTransformationUnknownType that) {
        return forUnknownTypeOnly(that);
    }

    public RetType for_SyntaxTransformationSelfTypeOnly(_SyntaxTransformationSelfType that) {
        return forSelfTypeOnly(that);
    }

    public RetType for_SyntaxTransformationTraitSelfTypeOnly(_SyntaxTransformationTraitSelfType that, RetType named_result, List<RetType> comprised_result) {
        return forTraitSelfTypeOnly(that, named_result, comprised_result);
    }

    public RetType for_SyntaxTransformationObjectExprTypeOnly(_SyntaxTransformationObjectExprType that, List<RetType> extended_result) {
        return forObjectExprTypeOnly(that, extended_result);
    }

    public RetType for_SyntaxTransformationNamedTypeOnly(_SyntaxTransformationNamedType that) {
        return forNamedTypeOnly(that);
    }

    public RetType for_SyntaxTransformation_InferenceVarTypeOnly(_SyntaxTransformation_InferenceVarType that) {
        return for_InferenceVarTypeOnly(that);
    }

    public RetType for_SyntaxTransformationVarTypeOnly(_SyntaxTransformationVarType that) {
        return forVarTypeOnly(that);
    }

    public RetType for_SyntaxTransformationTraitTypeOnly(_SyntaxTransformationTraitType that) {
        return forTraitTypeOnly(that);
    }

    public RetType for_SyntaxTransformationAbbreviatedTypeOnly(_SyntaxTransformationAbbreviatedType that, RetType elemType_result) {
        return forAbbreviatedTypeOnly(that, elemType_result);
    }

    public RetType for_SyntaxTransformationArrayTypeOnly(_SyntaxTransformationArrayType that, RetType elemType_result) {
        return forArrayTypeOnly(that, elemType_result);
    }

    public RetType for_SyntaxTransformationMatrixTypeOnly(_SyntaxTransformationMatrixType that, RetType elemType_result) {
        return forMatrixTypeOnly(that, elemType_result);
    }

    public RetType for_SyntaxTransformationTaggedDimTypeOnly(_SyntaxTransformationTaggedDimType that, RetType elemType_result, RetType dimExpr_result) {
        return forTaggedDimTypeOnly(that, elemType_result, dimExpr_result);
    }

    public RetType for_SyntaxTransformationTaggedUnitTypeOnly(_SyntaxTransformationTaggedUnitType that, RetType elemType_result) {
        return forTaggedUnitTypeOnly(that, elemType_result);
    }

    public RetType for_SyntaxTransformationTupleTypeOnly(_SyntaxTransformationTupleType that, List<RetType> elements_result, Option<RetType> varargs_result) {
        return forTupleTypeOnly(that, elements_result, varargs_result);
    }

    public RetType for_SyntaxTransformationArrowTypeOnly(_SyntaxTransformationArrowType that, RetType domain_result, RetType range_result) {
        return forArrowTypeOnly(that, domain_result, range_result);
    }

    public RetType for_SyntaxTransformationBoundTypeOnly(_SyntaxTransformationBoundType that, List<RetType> elements_result) {
        return forBoundTypeOnly(that, elements_result);
    }

    public RetType for_SyntaxTransformationIntersectionTypeOnly(_SyntaxTransformationIntersectionType that, List<RetType> elements_result) {
        return forIntersectionTypeOnly(that, elements_result);
    }

    public RetType for_SyntaxTransformationUnionTypeOnly(_SyntaxTransformationUnionType that, List<RetType> elements_result) {
        return forUnionTypeOnly(that, elements_result);
    }

    public RetType for_SyntaxTransformationFixedPointTypeOnly(_SyntaxTransformationFixedPointType that, RetType name_result, RetType body_result) {
        return forFixedPointTypeOnly(that, name_result, body_result);
    }

    public RetType for_SyntaxTransformationLabelTypeOnly(_SyntaxTransformationLabelType that) {
        return forLabelTypeOnly(that);
    }

    public RetType for_SyntaxTransformationDimExprOnly(_SyntaxTransformationDimExpr that) {
        return forDimExprOnly(that);
    }

    public RetType for_SyntaxTransformationDimBaseOnly(_SyntaxTransformationDimBase that) {
        return forDimBaseOnly(that);
    }

    public RetType for_SyntaxTransformationDimRefOnly(_SyntaxTransformationDimRef that) {
        return forDimRefOnly(that);
    }

    public RetType for_SyntaxTransformationDimExponentOnly(_SyntaxTransformationDimExponent that, RetType base_result) {
        return forDimExponentOnly(that, base_result);
    }

    public RetType for_SyntaxTransformationDimUnaryOpOnly(_SyntaxTransformationDimUnaryOp that, RetType dimVal_result) {
        return forDimUnaryOpOnly(that, dimVal_result);
    }

    public RetType for_SyntaxTransformationDimBinaryOpOnly(_SyntaxTransformationDimBinaryOp that, RetType left_result, RetType right_result) {
        return forDimBinaryOpOnly(that, left_result, right_result);
    }

    public RetType for_EllipsesTypeOnly(_EllipsesType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBaseTypeOnly(_EllipsesBaseType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesAnyTypeOnly(_EllipsesAnyType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBottomTypeOnly(_EllipsesBottomType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesUnknownTypeOnly(_EllipsesUnknownType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesSelfTypeOnly(_EllipsesSelfType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTraitSelfTypeOnly(_EllipsesTraitSelfType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesObjectExprTypeOnly(_EllipsesObjectExprType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNamedTypeOnly(_EllipsesNamedType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_Ellipses_InferenceVarTypeOnly(_Ellipses_InferenceVarType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesVarTypeOnly(_EllipsesVarType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTraitTypeOnly(_EllipsesTraitType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesAbbreviatedTypeOnly(_EllipsesAbbreviatedType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesArrayTypeOnly(_EllipsesArrayType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesMatrixTypeOnly(_EllipsesMatrixType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTaggedDimTypeOnly(_EllipsesTaggedDimType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTaggedUnitTypeOnly(_EllipsesTaggedUnitType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTupleTypeOnly(_EllipsesTupleType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesArrowTypeOnly(_EllipsesArrowType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBoundTypeOnly(_EllipsesBoundType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesIntersectionTypeOnly(_EllipsesIntersectionType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesUnionTypeOnly(_EllipsesUnionType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesFixedPointTypeOnly(_EllipsesFixedPointType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesLabelTypeOnly(_EllipsesLabelType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesDimExprOnly(_EllipsesDimExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesDimBaseOnly(_EllipsesDimBase that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesDimRefOnly(_EllipsesDimRef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesDimExponentOnly(_EllipsesDimExponent that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesDimUnaryOpOnly(_EllipsesDimUnaryOp that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesDimBinaryOpOnly(_EllipsesDimBinaryOp that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType forTemplateGapTypeOnly(TemplateGapType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBaseTypeOnly(TemplateGapBaseType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAnyTypeOnly(TemplateGapAnyType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBottomTypeOnly(TemplateGapBottomType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapUnknownTypeOnly(TemplateGapUnknownType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapSelfTypeOnly(TemplateGapSelfType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTraitSelfTypeOnly(TemplateGapTraitSelfType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapObjectExprTypeOnly(TemplateGapObjectExprType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNamedTypeOnly(TemplateGapNamedType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGap_InferenceVarTypeOnly(TemplateGap_InferenceVarType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapVarTypeOnly(TemplateGapVarType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTraitTypeOnly(TemplateGapTraitType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAbbreviatedTypeOnly(TemplateGapAbbreviatedType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapArrayTypeOnly(TemplateGapArrayType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapMatrixTypeOnly(TemplateGapMatrixType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTaggedDimTypeOnly(TemplateGapTaggedDimType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTaggedUnitTypeOnly(TemplateGapTaggedUnitType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTupleTypeOnly(TemplateGapTupleType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapArrowTypeOnly(TemplateGapArrowType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBoundTypeOnly(TemplateGapBoundType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIntersectionTypeOnly(TemplateGapIntersectionType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapUnionTypeOnly(TemplateGapUnionType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapFixedPointTypeOnly(TemplateGapFixedPointType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapLabelTypeOnly(TemplateGapLabelType that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDimExprOnly(TemplateGapDimExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDimBaseOnly(TemplateGapDimBase that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDimRefOnly(TemplateGapDimRef that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDimExponentOnly(TemplateGapDimExponent that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDimUnaryOpOnly(TemplateGapDimUnaryOp that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDimBinaryOpOnly(TemplateGapDimBinaryOp that) {
        return defaultTemplateGapCase(that);
    }


    /** Methods to recur on each child. */
    public RetType forAnyType(AnyType that) {
        return forAnyTypeOnly(that);
    }

    public RetType forBottomType(BottomType that) {
        return forBottomTypeOnly(that);
    }

    public RetType forUnknownType(UnknownType that) {
        return forUnknownTypeOnly(that);
    }

    public RetType forTraitSelfType(TraitSelfType that) {
        RetType named_result = recur(that.getNamed());
        List<RetType> comprised_result = recurOnListOfNamedType(that.getComprised());
        return forTraitSelfTypeOnly(that, named_result, comprised_result);
    }

    public RetType forObjectExprType(ObjectExprType that) {
        List<RetType> extended_result = recurOnListOfBaseType(that.getExtended());
        return forObjectExprTypeOnly(that, extended_result);
    }

    public RetType for_InferenceVarType(_InferenceVarType that) {
        return for_InferenceVarTypeOnly(that);
    }

    public RetType forVarType(VarType that) {
        return forVarTypeOnly(that);
    }

    public RetType forTraitType(TraitType that) {
        return forTraitTypeOnly(that);
    }

    public RetType forArrayType(ArrayType that) {
        RetType elemType_result = recur(that.getElemType());
        return forArrayTypeOnly(that, elemType_result);
    }

    public RetType forMatrixType(MatrixType that) {
        RetType elemType_result = recur(that.getElemType());
        return forMatrixTypeOnly(that, elemType_result);
    }

    public RetType forTaggedDimType(TaggedDimType that) {
        RetType elemType_result = recur(that.getElemType());
        RetType dimExpr_result = recur(that.getDimExpr());
        return forTaggedDimTypeOnly(that, elemType_result, dimExpr_result);
    }

    public RetType forTaggedUnitType(TaggedUnitType that) {
        RetType elemType_result = recur(that.getElemType());
        return forTaggedUnitTypeOnly(that, elemType_result);
    }

    public RetType forTupleType(TupleType that) {
        List<RetType> elements_result = recurOnListOfType(that.getElements());
        Option<RetType> varargs_result = recurOnOptionOfType(that.getVarargs());
        return forTupleTypeOnly(that, elements_result, varargs_result);
    }

    public RetType forArrowType(ArrowType that) {
        RetType domain_result = recur(that.getDomain());
        RetType range_result = recur(that.getRange());
        return forArrowTypeOnly(that, domain_result, range_result);
    }

    public RetType forIntersectionType(IntersectionType that) {
        List<RetType> elements_result = recurOnListOfType(that.getElements());
        return forIntersectionTypeOnly(that, elements_result);
    }

    public RetType forUnionType(UnionType that) {
        List<RetType> elements_result = recurOnListOfType(that.getElements());
        return forUnionTypeOnly(that, elements_result);
    }

    public RetType forFixedPointType(FixedPointType that) {
        RetType name_result = recur(that.getName());
        RetType body_result = recur(that.getBody());
        return forFixedPointTypeOnly(that, name_result, body_result);
    }

    public RetType forLabelType(LabelType that) {
        return forLabelTypeOnly(that);
    }

    public RetType forDimBase(DimBase that) {
        return forDimBaseOnly(that);
    }

    public RetType forDimRef(DimRef that) {
        return forDimRefOnly(that);
    }

    public RetType forDimExponent(DimExponent that) {
        RetType base_result = recur(that.getBase());
        return forDimExponentOnly(that, base_result);
    }

    public RetType forDimUnaryOp(DimUnaryOp that) {
        RetType dimVal_result = recur(that.getDimVal());
        return forDimUnaryOpOnly(that, dimVal_result);
    }

    public RetType forDimBinaryOp(DimBinaryOp that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        return forDimBinaryOpOnly(that, left_result, right_result);
    }

    public RetType for_SyntaxTransformationType(_SyntaxTransformationType that) {
        return for_SyntaxTransformationTypeOnly(that);
    }

    public RetType for_SyntaxTransformationBaseType(_SyntaxTransformationBaseType that) {
        return for_SyntaxTransformationBaseTypeOnly(that);
    }

    public RetType for_SyntaxTransformationAnyType(_SyntaxTransformationAnyType that) {
        return for_SyntaxTransformationAnyTypeOnly(that);
    }

    public RetType for_SyntaxTransformationBottomType(_SyntaxTransformationBottomType that) {
        return for_SyntaxTransformationBottomTypeOnly(that);
    }

    public RetType for_SyntaxTransformationUnknownType(_SyntaxTransformationUnknownType that) {
        return for_SyntaxTransformationUnknownTypeOnly(that);
    }

    public RetType for_SyntaxTransformationSelfType(_SyntaxTransformationSelfType that) {
        return for_SyntaxTransformationSelfTypeOnly(that);
    }

    public RetType for_SyntaxTransformationTraitSelfType(_SyntaxTransformationTraitSelfType that) {
        RetType named_result = recur(that.getNamed());
        List<RetType> comprised_result = recurOnListOfNamedType(that.getComprised());
        return for_SyntaxTransformationTraitSelfTypeOnly(that, named_result, comprised_result);
    }

    public RetType for_SyntaxTransformationObjectExprType(_SyntaxTransformationObjectExprType that) {
        List<RetType> extended_result = recurOnListOfBaseType(that.getExtended());
        return for_SyntaxTransformationObjectExprTypeOnly(that, extended_result);
    }

    public RetType for_SyntaxTransformationNamedType(_SyntaxTransformationNamedType that) {
        return for_SyntaxTransformationNamedTypeOnly(that);
    }

    public RetType for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that) {
        return for_SyntaxTransformation_InferenceVarTypeOnly(that);
    }

    public RetType for_SyntaxTransformationVarType(_SyntaxTransformationVarType that) {
        return for_SyntaxTransformationVarTypeOnly(that);
    }

    public RetType for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that) {
        return for_SyntaxTransformationTraitTypeOnly(that);
    }

    public RetType for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that) {
        RetType elemType_result = recur(that.getElemType());
        return for_SyntaxTransformationAbbreviatedTypeOnly(that, elemType_result);
    }

    public RetType for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that) {
        RetType elemType_result = recur(that.getElemType());
        return for_SyntaxTransformationArrayTypeOnly(that, elemType_result);
    }

    public RetType for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that) {
        RetType elemType_result = recur(that.getElemType());
        return for_SyntaxTransformationMatrixTypeOnly(that, elemType_result);
    }

    public RetType for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that) {
        RetType elemType_result = recur(that.getElemType());
        RetType dimExpr_result = recur(that.getDimExpr());
        return for_SyntaxTransformationTaggedDimTypeOnly(that, elemType_result, dimExpr_result);
    }

    public RetType for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that) {
        RetType elemType_result = recur(that.getElemType());
        return for_SyntaxTransformationTaggedUnitTypeOnly(that, elemType_result);
    }

    public RetType for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that) {
        List<RetType> elements_result = recurOnListOfType(that.getElements());
        Option<RetType> varargs_result = recurOnOptionOfType(that.getVarargs());
        return for_SyntaxTransformationTupleTypeOnly(that, elements_result, varargs_result);
    }

    public RetType for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that) {
        RetType domain_result = recur(that.getDomain());
        RetType range_result = recur(that.getRange());
        return for_SyntaxTransformationArrowTypeOnly(that, domain_result, range_result);
    }

    public RetType for_SyntaxTransformationBoundType(_SyntaxTransformationBoundType that) {
        List<RetType> elements_result = recurOnListOfType(that.getElements());
        return for_SyntaxTransformationBoundTypeOnly(that, elements_result);
    }

    public RetType for_SyntaxTransformationIntersectionType(_SyntaxTransformationIntersectionType that) {
        List<RetType> elements_result = recurOnListOfType(that.getElements());
        return for_SyntaxTransformationIntersectionTypeOnly(that, elements_result);
    }

    public RetType for_SyntaxTransformationUnionType(_SyntaxTransformationUnionType that) {
        List<RetType> elements_result = recurOnListOfType(that.getElements());
        return for_SyntaxTransformationUnionTypeOnly(that, elements_result);
    }

    public RetType for_SyntaxTransformationFixedPointType(_SyntaxTransformationFixedPointType that) {
        RetType name_result = recur(that.getName());
        RetType body_result = recur(that.getBody());
        return for_SyntaxTransformationFixedPointTypeOnly(that, name_result, body_result);
    }

    public RetType for_SyntaxTransformationLabelType(_SyntaxTransformationLabelType that) {
        return for_SyntaxTransformationLabelTypeOnly(that);
    }

    public RetType for_SyntaxTransformationDimExpr(_SyntaxTransformationDimExpr that) {
        return for_SyntaxTransformationDimExprOnly(that);
    }

    public RetType for_SyntaxTransformationDimBase(_SyntaxTransformationDimBase that) {
        return for_SyntaxTransformationDimBaseOnly(that);
    }

    public RetType for_SyntaxTransformationDimRef(_SyntaxTransformationDimRef that) {
        return for_SyntaxTransformationDimRefOnly(that);
    }

    public RetType for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that) {
        RetType base_result = recur(that.getBase());
        return for_SyntaxTransformationDimExponentOnly(that, base_result);
    }

    public RetType for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that) {
        RetType dimVal_result = recur(that.getDimVal());
        return for_SyntaxTransformationDimUnaryOpOnly(that, dimVal_result);
    }

    public RetType for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        return for_SyntaxTransformationDimBinaryOpOnly(that, left_result, right_result);
    }

    public RetType for_EllipsesType(_EllipsesType that) {
        return for_EllipsesTypeOnly(that);
    }

    public RetType for_EllipsesBaseType(_EllipsesBaseType that) {
        return for_EllipsesBaseTypeOnly(that);
    }

    public RetType for_EllipsesAnyType(_EllipsesAnyType that) {
        return for_EllipsesAnyTypeOnly(that);
    }

    public RetType for_EllipsesBottomType(_EllipsesBottomType that) {
        return for_EllipsesBottomTypeOnly(that);
    }

    public RetType for_EllipsesUnknownType(_EllipsesUnknownType that) {
        return for_EllipsesUnknownTypeOnly(that);
    }

    public RetType for_EllipsesSelfType(_EllipsesSelfType that) {
        return for_EllipsesSelfTypeOnly(that);
    }

    public RetType for_EllipsesTraitSelfType(_EllipsesTraitSelfType that) {
        return for_EllipsesTraitSelfTypeOnly(that);
    }

    public RetType for_EllipsesObjectExprType(_EllipsesObjectExprType that) {
        return for_EllipsesObjectExprTypeOnly(that);
    }

    public RetType for_EllipsesNamedType(_EllipsesNamedType that) {
        return for_EllipsesNamedTypeOnly(that);
    }

    public RetType for_Ellipses_InferenceVarType(_Ellipses_InferenceVarType that) {
        return for_Ellipses_InferenceVarTypeOnly(that);
    }

    public RetType for_EllipsesVarType(_EllipsesVarType that) {
        return for_EllipsesVarTypeOnly(that);
    }

    public RetType for_EllipsesTraitType(_EllipsesTraitType that) {
        return for_EllipsesTraitTypeOnly(that);
    }

    public RetType for_EllipsesAbbreviatedType(_EllipsesAbbreviatedType that) {
        return for_EllipsesAbbreviatedTypeOnly(that);
    }

    public RetType for_EllipsesArrayType(_EllipsesArrayType that) {
        return for_EllipsesArrayTypeOnly(that);
    }

    public RetType for_EllipsesMatrixType(_EllipsesMatrixType that) {
        return for_EllipsesMatrixTypeOnly(that);
    }

    public RetType for_EllipsesTaggedDimType(_EllipsesTaggedDimType that) {
        return for_EllipsesTaggedDimTypeOnly(that);
    }

    public RetType for_EllipsesTaggedUnitType(_EllipsesTaggedUnitType that) {
        return for_EllipsesTaggedUnitTypeOnly(that);
    }

    public RetType for_EllipsesTupleType(_EllipsesTupleType that) {
        return for_EllipsesTupleTypeOnly(that);
    }

    public RetType for_EllipsesArrowType(_EllipsesArrowType that) {
        return for_EllipsesArrowTypeOnly(that);
    }

    public RetType for_EllipsesBoundType(_EllipsesBoundType that) {
        return for_EllipsesBoundTypeOnly(that);
    }

    public RetType for_EllipsesIntersectionType(_EllipsesIntersectionType that) {
        return for_EllipsesIntersectionTypeOnly(that);
    }

    public RetType for_EllipsesUnionType(_EllipsesUnionType that) {
        return for_EllipsesUnionTypeOnly(that);
    }

    public RetType for_EllipsesFixedPointType(_EllipsesFixedPointType that) {
        return for_EllipsesFixedPointTypeOnly(that);
    }

    public RetType for_EllipsesLabelType(_EllipsesLabelType that) {
        return for_EllipsesLabelTypeOnly(that);
    }

    public RetType for_EllipsesDimExpr(_EllipsesDimExpr that) {
        return for_EllipsesDimExprOnly(that);
    }

    public RetType for_EllipsesDimBase(_EllipsesDimBase that) {
        return for_EllipsesDimBaseOnly(that);
    }

    public RetType for_EllipsesDimRef(_EllipsesDimRef that) {
        return for_EllipsesDimRefOnly(that);
    }

    public RetType for_EllipsesDimExponent(_EllipsesDimExponent that) {
        return for_EllipsesDimExponentOnly(that);
    }

    public RetType for_EllipsesDimUnaryOp(_EllipsesDimUnaryOp that) {
        return for_EllipsesDimUnaryOpOnly(that);
    }

    public RetType for_EllipsesDimBinaryOp(_EllipsesDimBinaryOp that) {
        return for_EllipsesDimBinaryOpOnly(that);
    }

    public RetType forTemplateGapType(TemplateGapType that) {
        return forTemplateGapTypeOnly(that);
    }

    public RetType forTemplateGapBaseType(TemplateGapBaseType that) {
        return forTemplateGapBaseTypeOnly(that);
    }

    public RetType forTemplateGapAnyType(TemplateGapAnyType that) {
        return forTemplateGapAnyTypeOnly(that);
    }

    public RetType forTemplateGapBottomType(TemplateGapBottomType that) {
        return forTemplateGapBottomTypeOnly(that);
    }

    public RetType forTemplateGapUnknownType(TemplateGapUnknownType that) {
        return forTemplateGapUnknownTypeOnly(that);
    }

    public RetType forTemplateGapSelfType(TemplateGapSelfType that) {
        return forTemplateGapSelfTypeOnly(that);
    }

    public RetType forTemplateGapTraitSelfType(TemplateGapTraitSelfType that) {
        return forTemplateGapTraitSelfTypeOnly(that);
    }

    public RetType forTemplateGapObjectExprType(TemplateGapObjectExprType that) {
        return forTemplateGapObjectExprTypeOnly(that);
    }

    public RetType forTemplateGapNamedType(TemplateGapNamedType that) {
        return forTemplateGapNamedTypeOnly(that);
    }

    public RetType forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that) {
        return forTemplateGap_InferenceVarTypeOnly(that);
    }

    public RetType forTemplateGapVarType(TemplateGapVarType that) {
        return forTemplateGapVarTypeOnly(that);
    }

    public RetType forTemplateGapTraitType(TemplateGapTraitType that) {
        return forTemplateGapTraitTypeOnly(that);
    }

    public RetType forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that) {
        return forTemplateGapAbbreviatedTypeOnly(that);
    }

    public RetType forTemplateGapArrayType(TemplateGapArrayType that) {
        return forTemplateGapArrayTypeOnly(that);
    }

    public RetType forTemplateGapMatrixType(TemplateGapMatrixType that) {
        return forTemplateGapMatrixTypeOnly(that);
    }

    public RetType forTemplateGapTaggedDimType(TemplateGapTaggedDimType that) {
        return forTemplateGapTaggedDimTypeOnly(that);
    }

    public RetType forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that) {
        return forTemplateGapTaggedUnitTypeOnly(that);
    }

    public RetType forTemplateGapTupleType(TemplateGapTupleType that) {
        return forTemplateGapTupleTypeOnly(that);
    }

    public RetType forTemplateGapArrowType(TemplateGapArrowType that) {
        return forTemplateGapArrowTypeOnly(that);
    }

    public RetType forTemplateGapBoundType(TemplateGapBoundType that) {
        return forTemplateGapBoundTypeOnly(that);
    }

    public RetType forTemplateGapIntersectionType(TemplateGapIntersectionType that) {
        return forTemplateGapIntersectionTypeOnly(that);
    }

    public RetType forTemplateGapUnionType(TemplateGapUnionType that) {
        return forTemplateGapUnionTypeOnly(that);
    }

    public RetType forTemplateGapFixedPointType(TemplateGapFixedPointType that) {
        return forTemplateGapFixedPointTypeOnly(that);
    }

    public RetType forTemplateGapLabelType(TemplateGapLabelType that) {
        return forTemplateGapLabelTypeOnly(that);
    }

    public RetType forTemplateGapDimExpr(TemplateGapDimExpr that) {
        return forTemplateGapDimExprOnly(that);
    }

    public RetType forTemplateGapDimBase(TemplateGapDimBase that) {
        return forTemplateGapDimBaseOnly(that);
    }

    public RetType forTemplateGapDimRef(TemplateGapDimRef that) {
        return forTemplateGapDimRefOnly(that);
    }

    public RetType forTemplateGapDimExponent(TemplateGapDimExponent that) {
        return forTemplateGapDimExponentOnly(that);
    }

    public RetType forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that) {
        return forTemplateGapDimUnaryOpOnly(that);
    }

    public RetType forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that) {
        return forTemplateGapDimBinaryOpOnly(that);
    }

    /** Defaultcases for nonstandard classes. */
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, an exception is thrown; subclasses may override this behavior.
     * @throws IllegalArgumentException
    **/
    public RetType defaultTemplateGapCase(TemplateGap that) {
        throw new IllegalArgumentException("Visitor " + getClass().getName() + " does not support visiting values of type " + that.getClass().getName());
    }
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, an exception is thrown; subclasses may override this behavior.
     * @throws IllegalArgumentException
    **/
    public RetType defaultEllipsesNodeCase(_Ellipses that) {
        throw new IllegalArgumentException("Visitor " + getClass().getName() + " does not support visiting values of type " + that.getClass().getName());
    }

    public RetType recur(Type that) {
        return that.accept(this);
    }

    public List<RetType> recurOnListOfNamedType(List<NamedType> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (NamedType elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfBaseType(List<BaseType> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (BaseType elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfType(List<Type> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (Type elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public Option<RetType> recurOnOptionOfType(Option<Type> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }
}
