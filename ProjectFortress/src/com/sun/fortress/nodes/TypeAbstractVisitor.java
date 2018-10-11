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

/** A parametric abstract implementation of a visitor over Type that return a value.
 ** This visitor implements the visitor interface with methods that each 
 ** delegate to a case representing their superclass.  At the top of this
 ** delegation tree is the method defaultCase(), which (unless overridden)
 ** throws an exception.
 **/
@SuppressWarnings("unused")
public abstract class TypeAbstractVisitor<RetType>  extends TypeVisitorLambda<RetType> {
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, an exception is thrown; subclasses may override this behavior.
     * @throws IllegalArgumentException
    **/
    public RetType defaultCase(Type that) {
        throw new IllegalArgumentException("Visitor " + getClass().getName() + " does not support visiting values of type " + that.getClass().getName());
    }

    /* Methods to visit an item. */
    public RetType forType(Type that) {
        return defaultCase(that);
    }

    public RetType forBaseType(BaseType that) {
        return forType(that);
    }

    public RetType forAnyType(AnyType that) {
        return forBaseType(that);
    }

    public RetType forBottomType(BottomType that) {
        return forBaseType(that);
    }

    public RetType forUnknownType(UnknownType that) {
        return forBaseType(that);
    }

    public RetType forSelfType(SelfType that) {
        return forBaseType(that);
    }

    public RetType forTraitSelfType(TraitSelfType that) {
        return forSelfType(that);
    }

    public RetType forObjectExprType(ObjectExprType that) {
        return forSelfType(that);
    }

    public RetType forNamedType(NamedType that) {
        return forBaseType(that);
    }

    public RetType for_InferenceVarType(_InferenceVarType that) {
        return forNamedType(that);
    }

    public RetType forVarType(VarType that) {
        return forNamedType(that);
    }

    public RetType forTraitType(TraitType that) {
        return forNamedType(that);
    }

    public RetType forAbbreviatedType(AbbreviatedType that) {
        return forBaseType(that);
    }

    public RetType forArrayType(ArrayType that) {
        return forAbbreviatedType(that);
    }

    public RetType forMatrixType(MatrixType that) {
        return forAbbreviatedType(that);
    }

    public RetType forTaggedDimType(TaggedDimType that) {
        return forAbbreviatedType(that);
    }

    public RetType forTaggedUnitType(TaggedUnitType that) {
        return forAbbreviatedType(that);
    }

    public RetType forTupleType(TupleType that) {
        return forType(that);
    }

    public RetType forArrowType(ArrowType that) {
        return forType(that);
    }

    public RetType forBoundType(BoundType that) {
        return forType(that);
    }

    public RetType forIntersectionType(IntersectionType that) {
        return forBoundType(that);
    }

    public RetType forUnionType(UnionType that) {
        return forBoundType(that);
    }

    public RetType forFixedPointType(FixedPointType that) {
        return forType(that);
    }

    public RetType forLabelType(LabelType that) {
        return forType(that);
    }

    public RetType forDimExpr(DimExpr that) {
        return forType(that);
    }

    public RetType forDimBase(DimBase that) {
        return forDimExpr(that);
    }

    public RetType forDimRef(DimRef that) {
        return forDimExpr(that);
    }

    public RetType forDimExponent(DimExponent that) {
        return forDimExpr(that);
    }

    public RetType forDimUnaryOp(DimUnaryOp that) {
        return forDimExpr(that);
    }

    public RetType forDimBinaryOp(DimBinaryOp that) {
        return forDimExpr(that);
    }

    public RetType for_SyntaxTransformationType(_SyntaxTransformationType that) {
        return forType(that);
    }

    public RetType for_SyntaxTransformationBaseType(_SyntaxTransformationBaseType that) {
        return forBaseType(that);
    }

    public RetType for_SyntaxTransformationAnyType(_SyntaxTransformationAnyType that) {
        return forAnyType(that);
    }

    public RetType for_SyntaxTransformationBottomType(_SyntaxTransformationBottomType that) {
        return forBottomType(that);
    }

    public RetType for_SyntaxTransformationUnknownType(_SyntaxTransformationUnknownType that) {
        return forUnknownType(that);
    }

    public RetType for_SyntaxTransformationSelfType(_SyntaxTransformationSelfType that) {
        return forSelfType(that);
    }

    public RetType for_SyntaxTransformationTraitSelfType(_SyntaxTransformationTraitSelfType that) {
        return forTraitSelfType(that);
    }

    public RetType for_SyntaxTransformationObjectExprType(_SyntaxTransformationObjectExprType that) {
        return forObjectExprType(that);
    }

    public RetType for_SyntaxTransformationNamedType(_SyntaxTransformationNamedType that) {
        return forNamedType(that);
    }

    public RetType for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that) {
        return for_InferenceVarType(that);
    }

    public RetType for_SyntaxTransformationVarType(_SyntaxTransformationVarType that) {
        return forVarType(that);
    }

    public RetType for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that) {
        return forTraitType(that);
    }

    public RetType for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that) {
        return forAbbreviatedType(that);
    }

    public RetType for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that) {
        return forArrayType(that);
    }

    public RetType for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that) {
        return forMatrixType(that);
    }

    public RetType for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that) {
        return forTaggedDimType(that);
    }

    public RetType for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that) {
        return forTaggedUnitType(that);
    }

    public RetType for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that) {
        return forTupleType(that);
    }

    public RetType for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that) {
        return forArrowType(that);
    }

    public RetType for_SyntaxTransformationBoundType(_SyntaxTransformationBoundType that) {
        return forBoundType(that);
    }

    public RetType for_SyntaxTransformationIntersectionType(_SyntaxTransformationIntersectionType that) {
        return forIntersectionType(that);
    }

    public RetType for_SyntaxTransformationUnionType(_SyntaxTransformationUnionType that) {
        return forUnionType(that);
    }

    public RetType for_SyntaxTransformationFixedPointType(_SyntaxTransformationFixedPointType that) {
        return forFixedPointType(that);
    }

    public RetType for_SyntaxTransformationLabelType(_SyntaxTransformationLabelType that) {
        return forLabelType(that);
    }

    public RetType for_SyntaxTransformationDimExpr(_SyntaxTransformationDimExpr that) {
        return forDimExpr(that);
    }

    public RetType for_SyntaxTransformationDimBase(_SyntaxTransformationDimBase that) {
        return forDimBase(that);
    }

    public RetType for_SyntaxTransformationDimRef(_SyntaxTransformationDimRef that) {
        return forDimRef(that);
    }

    public RetType for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that) {
        return forDimExponent(that);
    }

    public RetType for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that) {
        return forDimUnaryOp(that);
    }

    public RetType for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that) {
        return forDimBinaryOp(that);
    }

    public RetType for_EllipsesType(_EllipsesType that) {
        return forType(that);
    }

    public RetType for_EllipsesBaseType(_EllipsesBaseType that) {
        return forBaseType(that);
    }

    public RetType for_EllipsesAnyType(_EllipsesAnyType that) {
        return forAnyType(that);
    }

    public RetType for_EllipsesBottomType(_EllipsesBottomType that) {
        return forBottomType(that);
    }

    public RetType for_EllipsesUnknownType(_EllipsesUnknownType that) {
        return forUnknownType(that);
    }

    public RetType for_EllipsesSelfType(_EllipsesSelfType that) {
        return forSelfType(that);
    }

    public RetType for_EllipsesTraitSelfType(_EllipsesTraitSelfType that) {
        return forTraitSelfType(that);
    }

    public RetType for_EllipsesObjectExprType(_EllipsesObjectExprType that) {
        return forObjectExprType(that);
    }

    public RetType for_EllipsesNamedType(_EllipsesNamedType that) {
        return forNamedType(that);
    }

    public RetType for_Ellipses_InferenceVarType(_Ellipses_InferenceVarType that) {
        return for_InferenceVarType(that);
    }

    public RetType for_EllipsesVarType(_EllipsesVarType that) {
        return forVarType(that);
    }

    public RetType for_EllipsesTraitType(_EllipsesTraitType that) {
        return forTraitType(that);
    }

    public RetType for_EllipsesAbbreviatedType(_EllipsesAbbreviatedType that) {
        return forAbbreviatedType(that);
    }

    public RetType for_EllipsesArrayType(_EllipsesArrayType that) {
        return forArrayType(that);
    }

    public RetType for_EllipsesMatrixType(_EllipsesMatrixType that) {
        return forMatrixType(that);
    }

    public RetType for_EllipsesTaggedDimType(_EllipsesTaggedDimType that) {
        return forTaggedDimType(that);
    }

    public RetType for_EllipsesTaggedUnitType(_EllipsesTaggedUnitType that) {
        return forTaggedUnitType(that);
    }

    public RetType for_EllipsesTupleType(_EllipsesTupleType that) {
        return forTupleType(that);
    }

    public RetType for_EllipsesArrowType(_EllipsesArrowType that) {
        return forArrowType(that);
    }

    public RetType for_EllipsesBoundType(_EllipsesBoundType that) {
        return forBoundType(that);
    }

    public RetType for_EllipsesIntersectionType(_EllipsesIntersectionType that) {
        return forIntersectionType(that);
    }

    public RetType for_EllipsesUnionType(_EllipsesUnionType that) {
        return forUnionType(that);
    }

    public RetType for_EllipsesFixedPointType(_EllipsesFixedPointType that) {
        return forFixedPointType(that);
    }

    public RetType for_EllipsesLabelType(_EllipsesLabelType that) {
        return forLabelType(that);
    }

    public RetType for_EllipsesDimExpr(_EllipsesDimExpr that) {
        return forDimExpr(that);
    }

    public RetType for_EllipsesDimBase(_EllipsesDimBase that) {
        return forDimBase(that);
    }

    public RetType for_EllipsesDimRef(_EllipsesDimRef that) {
        return forDimRef(that);
    }

    public RetType for_EllipsesDimExponent(_EllipsesDimExponent that) {
        return forDimExponent(that);
    }

    public RetType for_EllipsesDimUnaryOp(_EllipsesDimUnaryOp that) {
        return forDimUnaryOp(that);
    }

    public RetType for_EllipsesDimBinaryOp(_EllipsesDimBinaryOp that) {
        return forDimBinaryOp(that);
    }

    public RetType forTemplateGapType(TemplateGapType that) {
        return forType(that);
    }

    public RetType forTemplateGapBaseType(TemplateGapBaseType that) {
        return forBaseType(that);
    }

    public RetType forTemplateGapAnyType(TemplateGapAnyType that) {
        return forAnyType(that);
    }

    public RetType forTemplateGapBottomType(TemplateGapBottomType that) {
        return forBottomType(that);
    }

    public RetType forTemplateGapUnknownType(TemplateGapUnknownType that) {
        return forUnknownType(that);
    }

    public RetType forTemplateGapSelfType(TemplateGapSelfType that) {
        return forSelfType(that);
    }

    public RetType forTemplateGapTraitSelfType(TemplateGapTraitSelfType that) {
        return forTraitSelfType(that);
    }

    public RetType forTemplateGapObjectExprType(TemplateGapObjectExprType that) {
        return forObjectExprType(that);
    }

    public RetType forTemplateGapNamedType(TemplateGapNamedType that) {
        return forNamedType(that);
    }

    public RetType forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that) {
        return for_InferenceVarType(that);
    }

    public RetType forTemplateGapVarType(TemplateGapVarType that) {
        return forVarType(that);
    }

    public RetType forTemplateGapTraitType(TemplateGapTraitType that) {
        return forTraitType(that);
    }

    public RetType forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that) {
        return forAbbreviatedType(that);
    }

    public RetType forTemplateGapArrayType(TemplateGapArrayType that) {
        return forArrayType(that);
    }

    public RetType forTemplateGapMatrixType(TemplateGapMatrixType that) {
        return forMatrixType(that);
    }

    public RetType forTemplateGapTaggedDimType(TemplateGapTaggedDimType that) {
        return forTaggedDimType(that);
    }

    public RetType forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that) {
        return forTaggedUnitType(that);
    }

    public RetType forTemplateGapTupleType(TemplateGapTupleType that) {
        return forTupleType(that);
    }

    public RetType forTemplateGapArrowType(TemplateGapArrowType that) {
        return forArrowType(that);
    }

    public RetType forTemplateGapBoundType(TemplateGapBoundType that) {
        return forBoundType(that);
    }

    public RetType forTemplateGapIntersectionType(TemplateGapIntersectionType that) {
        return forIntersectionType(that);
    }

    public RetType forTemplateGapUnionType(TemplateGapUnionType that) {
        return forUnionType(that);
    }

    public RetType forTemplateGapFixedPointType(TemplateGapFixedPointType that) {
        return forFixedPointType(that);
    }

    public RetType forTemplateGapLabelType(TemplateGapLabelType that) {
        return forLabelType(that);
    }

    public RetType forTemplateGapDimExpr(TemplateGapDimExpr that) {
        return forDimExpr(that);
    }

    public RetType forTemplateGapDimBase(TemplateGapDimBase that) {
        return forDimBase(that);
    }

    public RetType forTemplateGapDimRef(TemplateGapDimRef that) {
        return forDimRef(that);
    }

    public RetType forTemplateGapDimExponent(TemplateGapDimExponent that) {
        return forDimExponent(that);
    }

    public RetType forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that) {
        return forDimUnaryOp(that);
    }

    public RetType forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that) {
        return forDimBinaryOp(that);
    }


}
