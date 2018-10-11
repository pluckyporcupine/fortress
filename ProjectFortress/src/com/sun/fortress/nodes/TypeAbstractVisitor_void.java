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

/** An abstract implementation of a visitor over Type that does not return a value.
 ** This visitor implements the visitor interface with methods that each 
 ** delegate to a case representing their superclass.  At the top of this
 ** delegation tree is the method defaultCase(), which (unless overridden)
 ** is a no-op.
 **/
@SuppressWarnings("unused")
public class TypeAbstractVisitor_void extends TypeVisitorRunnable1 {
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, it is a no-op; subclasses may override this behavior.
    **/
    public void defaultCase(Type that) {}

    /* Methods to visit an item. */
    public void forType(Type that) {
        defaultCase(that);
    }

    public void forBaseType(BaseType that) {
        forType(that);
    }

    public void forAnyType(AnyType that) {
        forBaseType(that);
    }

    public void forBottomType(BottomType that) {
        forBaseType(that);
    }

    public void forUnknownType(UnknownType that) {
        forBaseType(that);
    }

    public void forSelfType(SelfType that) {
        forBaseType(that);
    }

    public void forTraitSelfType(TraitSelfType that) {
        forSelfType(that);
    }

    public void forObjectExprType(ObjectExprType that) {
        forSelfType(that);
    }

    public void forNamedType(NamedType that) {
        forBaseType(that);
    }

    public void for_InferenceVarType(_InferenceVarType that) {
        forNamedType(that);
    }

    public void forVarType(VarType that) {
        forNamedType(that);
    }

    public void forTraitType(TraitType that) {
        forNamedType(that);
    }

    public void forAbbreviatedType(AbbreviatedType that) {
        forBaseType(that);
    }

    public void forArrayType(ArrayType that) {
        forAbbreviatedType(that);
    }

    public void forMatrixType(MatrixType that) {
        forAbbreviatedType(that);
    }

    public void forTaggedDimType(TaggedDimType that) {
        forAbbreviatedType(that);
    }

    public void forTaggedUnitType(TaggedUnitType that) {
        forAbbreviatedType(that);
    }

    public void forTupleType(TupleType that) {
        forType(that);
    }

    public void forArrowType(ArrowType that) {
        forType(that);
    }

    public void forBoundType(BoundType that) {
        forType(that);
    }

    public void forIntersectionType(IntersectionType that) {
        forBoundType(that);
    }

    public void forUnionType(UnionType that) {
        forBoundType(that);
    }

    public void forFixedPointType(FixedPointType that) {
        forType(that);
    }

    public void forLabelType(LabelType that) {
        forType(that);
    }

    public void forDimExpr(DimExpr that) {
        forType(that);
    }

    public void forDimBase(DimBase that) {
        forDimExpr(that);
    }

    public void forDimRef(DimRef that) {
        forDimExpr(that);
    }

    public void forDimExponent(DimExponent that) {
        forDimExpr(that);
    }

    public void forDimUnaryOp(DimUnaryOp that) {
        forDimExpr(that);
    }

    public void forDimBinaryOp(DimBinaryOp that) {
        forDimExpr(that);
    }

    public void for_SyntaxTransformationType(_SyntaxTransformationType that) {
        forType(that);
    }

    public void for_SyntaxTransformationBaseType(_SyntaxTransformationBaseType that) {
        forBaseType(that);
    }

    public void for_SyntaxTransformationAnyType(_SyntaxTransformationAnyType that) {
        forAnyType(that);
    }

    public void for_SyntaxTransformationBottomType(_SyntaxTransformationBottomType that) {
        forBottomType(that);
    }

    public void for_SyntaxTransformationUnknownType(_SyntaxTransformationUnknownType that) {
        forUnknownType(that);
    }

    public void for_SyntaxTransformationSelfType(_SyntaxTransformationSelfType that) {
        forSelfType(that);
    }

    public void for_SyntaxTransformationTraitSelfType(_SyntaxTransformationTraitSelfType that) {
        forTraitSelfType(that);
    }

    public void for_SyntaxTransformationObjectExprType(_SyntaxTransformationObjectExprType that) {
        forObjectExprType(that);
    }

    public void for_SyntaxTransformationNamedType(_SyntaxTransformationNamedType that) {
        forNamedType(that);
    }

    public void for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that) {
        for_InferenceVarType(that);
    }

    public void for_SyntaxTransformationVarType(_SyntaxTransformationVarType that) {
        forVarType(that);
    }

    public void for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that) {
        forTraitType(that);
    }

    public void for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that) {
        forAbbreviatedType(that);
    }

    public void for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that) {
        forArrayType(that);
    }

    public void for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that) {
        forMatrixType(that);
    }

    public void for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that) {
        forTaggedDimType(that);
    }

    public void for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that) {
        forTaggedUnitType(that);
    }

    public void for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that) {
        forTupleType(that);
    }

    public void for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that) {
        forArrowType(that);
    }

    public void for_SyntaxTransformationBoundType(_SyntaxTransformationBoundType that) {
        forBoundType(that);
    }

    public void for_SyntaxTransformationIntersectionType(_SyntaxTransformationIntersectionType that) {
        forIntersectionType(that);
    }

    public void for_SyntaxTransformationUnionType(_SyntaxTransformationUnionType that) {
        forUnionType(that);
    }

    public void for_SyntaxTransformationFixedPointType(_SyntaxTransformationFixedPointType that) {
        forFixedPointType(that);
    }

    public void for_SyntaxTransformationLabelType(_SyntaxTransformationLabelType that) {
        forLabelType(that);
    }

    public void for_SyntaxTransformationDimExpr(_SyntaxTransformationDimExpr that) {
        forDimExpr(that);
    }

    public void for_SyntaxTransformationDimBase(_SyntaxTransformationDimBase that) {
        forDimBase(that);
    }

    public void for_SyntaxTransformationDimRef(_SyntaxTransformationDimRef that) {
        forDimRef(that);
    }

    public void for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that) {
        forDimExponent(that);
    }

    public void for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that) {
        forDimUnaryOp(that);
    }

    public void for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that) {
        forDimBinaryOp(that);
    }

    public void for_EllipsesType(_EllipsesType that) {
        forType(that);
    }

    public void for_EllipsesBaseType(_EllipsesBaseType that) {
        forBaseType(that);
    }

    public void for_EllipsesAnyType(_EllipsesAnyType that) {
        forAnyType(that);
    }

    public void for_EllipsesBottomType(_EllipsesBottomType that) {
        forBottomType(that);
    }

    public void for_EllipsesUnknownType(_EllipsesUnknownType that) {
        forUnknownType(that);
    }

    public void for_EllipsesSelfType(_EllipsesSelfType that) {
        forSelfType(that);
    }

    public void for_EllipsesTraitSelfType(_EllipsesTraitSelfType that) {
        forTraitSelfType(that);
    }

    public void for_EllipsesObjectExprType(_EllipsesObjectExprType that) {
        forObjectExprType(that);
    }

    public void for_EllipsesNamedType(_EllipsesNamedType that) {
        forNamedType(that);
    }

    public void for_Ellipses_InferenceVarType(_Ellipses_InferenceVarType that) {
        for_InferenceVarType(that);
    }

    public void for_EllipsesVarType(_EllipsesVarType that) {
        forVarType(that);
    }

    public void for_EllipsesTraitType(_EllipsesTraitType that) {
        forTraitType(that);
    }

    public void for_EllipsesAbbreviatedType(_EllipsesAbbreviatedType that) {
        forAbbreviatedType(that);
    }

    public void for_EllipsesArrayType(_EllipsesArrayType that) {
        forArrayType(that);
    }

    public void for_EllipsesMatrixType(_EllipsesMatrixType that) {
        forMatrixType(that);
    }

    public void for_EllipsesTaggedDimType(_EllipsesTaggedDimType that) {
        forTaggedDimType(that);
    }

    public void for_EllipsesTaggedUnitType(_EllipsesTaggedUnitType that) {
        forTaggedUnitType(that);
    }

    public void for_EllipsesTupleType(_EllipsesTupleType that) {
        forTupleType(that);
    }

    public void for_EllipsesArrowType(_EllipsesArrowType that) {
        forArrowType(that);
    }

    public void for_EllipsesBoundType(_EllipsesBoundType that) {
        forBoundType(that);
    }

    public void for_EllipsesIntersectionType(_EllipsesIntersectionType that) {
        forIntersectionType(that);
    }

    public void for_EllipsesUnionType(_EllipsesUnionType that) {
        forUnionType(that);
    }

    public void for_EllipsesFixedPointType(_EllipsesFixedPointType that) {
        forFixedPointType(that);
    }

    public void for_EllipsesLabelType(_EllipsesLabelType that) {
        forLabelType(that);
    }

    public void for_EllipsesDimExpr(_EllipsesDimExpr that) {
        forDimExpr(that);
    }

    public void for_EllipsesDimBase(_EllipsesDimBase that) {
        forDimBase(that);
    }

    public void for_EllipsesDimRef(_EllipsesDimRef that) {
        forDimRef(that);
    }

    public void for_EllipsesDimExponent(_EllipsesDimExponent that) {
        forDimExponent(that);
    }

    public void for_EllipsesDimUnaryOp(_EllipsesDimUnaryOp that) {
        forDimUnaryOp(that);
    }

    public void for_EllipsesDimBinaryOp(_EllipsesDimBinaryOp that) {
        forDimBinaryOp(that);
    }

    public void forTemplateGapType(TemplateGapType that) {
        forType(that);
    }

    public void forTemplateGapBaseType(TemplateGapBaseType that) {
        forBaseType(that);
    }

    public void forTemplateGapAnyType(TemplateGapAnyType that) {
        forAnyType(that);
    }

    public void forTemplateGapBottomType(TemplateGapBottomType that) {
        forBottomType(that);
    }

    public void forTemplateGapUnknownType(TemplateGapUnknownType that) {
        forUnknownType(that);
    }

    public void forTemplateGapSelfType(TemplateGapSelfType that) {
        forSelfType(that);
    }

    public void forTemplateGapTraitSelfType(TemplateGapTraitSelfType that) {
        forTraitSelfType(that);
    }

    public void forTemplateGapObjectExprType(TemplateGapObjectExprType that) {
        forObjectExprType(that);
    }

    public void forTemplateGapNamedType(TemplateGapNamedType that) {
        forNamedType(that);
    }

    public void forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that) {
        for_InferenceVarType(that);
    }

    public void forTemplateGapVarType(TemplateGapVarType that) {
        forVarType(that);
    }

    public void forTemplateGapTraitType(TemplateGapTraitType that) {
        forTraitType(that);
    }

    public void forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that) {
        forAbbreviatedType(that);
    }

    public void forTemplateGapArrayType(TemplateGapArrayType that) {
        forArrayType(that);
    }

    public void forTemplateGapMatrixType(TemplateGapMatrixType that) {
        forMatrixType(that);
    }

    public void forTemplateGapTaggedDimType(TemplateGapTaggedDimType that) {
        forTaggedDimType(that);
    }

    public void forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that) {
        forTaggedUnitType(that);
    }

    public void forTemplateGapTupleType(TemplateGapTupleType that) {
        forTupleType(that);
    }

    public void forTemplateGapArrowType(TemplateGapArrowType that) {
        forArrowType(that);
    }

    public void forTemplateGapBoundType(TemplateGapBoundType that) {
        forBoundType(that);
    }

    public void forTemplateGapIntersectionType(TemplateGapIntersectionType that) {
        forIntersectionType(that);
    }

    public void forTemplateGapUnionType(TemplateGapUnionType that) {
        forUnionType(that);
    }

    public void forTemplateGapFixedPointType(TemplateGapFixedPointType that) {
        forFixedPointType(that);
    }

    public void forTemplateGapLabelType(TemplateGapLabelType that) {
        forLabelType(that);
    }

    public void forTemplateGapDimExpr(TemplateGapDimExpr that) {
        forDimExpr(that);
    }

    public void forTemplateGapDimBase(TemplateGapDimBase that) {
        forDimBase(that);
    }

    public void forTemplateGapDimRef(TemplateGapDimRef that) {
        forDimRef(that);
    }

    public void forTemplateGapDimExponent(TemplateGapDimExponent that) {
        forDimExponent(that);
    }

    public void forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that) {
        forDimUnaryOp(that);
    }

    public void forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that) {
        forDimBinaryOp(that);
    }

}
