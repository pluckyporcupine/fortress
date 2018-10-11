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

/** An abstract void visitor over Type that provides a Runnable1 run method;
  * all visit methods are left unimplemented. */
@SuppressWarnings("unused")
public abstract class TypeVisitorRunnable1 implements edu.rice.cs.plt.lambda.Runnable1<Type>, TypeVisitor_void {

    public void run(Type that) {
        that.accept(this);
    }


    /** Process an instance of AnyType. */
    public abstract void forAnyType(AnyType that);

    /** Process an instance of BottomType. */
    public abstract void forBottomType(BottomType that);

    /** Process an instance of UnknownType. */
    public abstract void forUnknownType(UnknownType that);

    /** Process an instance of TraitSelfType. */
    public abstract void forTraitSelfType(TraitSelfType that);

    /** Process an instance of ObjectExprType. */
    public abstract void forObjectExprType(ObjectExprType that);

    /** Process an instance of _InferenceVarType. */
    public abstract void for_InferenceVarType(_InferenceVarType that);

    /** Process an instance of VarType. */
    public abstract void forVarType(VarType that);

    /** Process an instance of TraitType. */
    public abstract void forTraitType(TraitType that);

    /** Process an instance of ArrayType. */
    public abstract void forArrayType(ArrayType that);

    /** Process an instance of MatrixType. */
    public abstract void forMatrixType(MatrixType that);

    /** Process an instance of TaggedDimType. */
    public abstract void forTaggedDimType(TaggedDimType that);

    /** Process an instance of TaggedUnitType. */
    public abstract void forTaggedUnitType(TaggedUnitType that);

    /** Process an instance of TupleType. */
    public abstract void forTupleType(TupleType that);

    /** Process an instance of ArrowType. */
    public abstract void forArrowType(ArrowType that);

    /** Process an instance of IntersectionType. */
    public abstract void forIntersectionType(IntersectionType that);

    /** Process an instance of UnionType. */
    public abstract void forUnionType(UnionType that);

    /** Process an instance of FixedPointType. */
    public abstract void forFixedPointType(FixedPointType that);

    /** Process an instance of LabelType. */
    public abstract void forLabelType(LabelType that);

    /** Process an instance of DimBase. */
    public abstract void forDimBase(DimBase that);

    /** Process an instance of DimRef. */
    public abstract void forDimRef(DimRef that);

    /** Process an instance of DimExponent. */
    public abstract void forDimExponent(DimExponent that);

    /** Process an instance of DimUnaryOp. */
    public abstract void forDimUnaryOp(DimUnaryOp that);

    /** Process an instance of DimBinaryOp. */
    public abstract void forDimBinaryOp(DimBinaryOp that);

    /** Process an instance of _SyntaxTransformationType. */
    public abstract void for_SyntaxTransformationType(_SyntaxTransformationType that);

    /** Process an instance of _SyntaxTransformationBaseType. */
    public abstract void for_SyntaxTransformationBaseType(_SyntaxTransformationBaseType that);

    /** Process an instance of _SyntaxTransformationAnyType. */
    public abstract void for_SyntaxTransformationAnyType(_SyntaxTransformationAnyType that);

    /** Process an instance of _SyntaxTransformationBottomType. */
    public abstract void for_SyntaxTransformationBottomType(_SyntaxTransformationBottomType that);

    /** Process an instance of _SyntaxTransformationUnknownType. */
    public abstract void for_SyntaxTransformationUnknownType(_SyntaxTransformationUnknownType that);

    /** Process an instance of _SyntaxTransformationSelfType. */
    public abstract void for_SyntaxTransformationSelfType(_SyntaxTransformationSelfType that);

    /** Process an instance of _SyntaxTransformationTraitSelfType. */
    public abstract void for_SyntaxTransformationTraitSelfType(_SyntaxTransformationTraitSelfType that);

    /** Process an instance of _SyntaxTransformationObjectExprType. */
    public abstract void for_SyntaxTransformationObjectExprType(_SyntaxTransformationObjectExprType that);

    /** Process an instance of _SyntaxTransformationNamedType. */
    public abstract void for_SyntaxTransformationNamedType(_SyntaxTransformationNamedType that);

    /** Process an instance of _SyntaxTransformation_InferenceVarType. */
    public abstract void for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that);

    /** Process an instance of _SyntaxTransformationVarType. */
    public abstract void for_SyntaxTransformationVarType(_SyntaxTransformationVarType that);

    /** Process an instance of _SyntaxTransformationTraitType. */
    public abstract void for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that);

    /** Process an instance of _SyntaxTransformationAbbreviatedType. */
    public abstract void for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that);

    /** Process an instance of _SyntaxTransformationArrayType. */
    public abstract void for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that);

    /** Process an instance of _SyntaxTransformationMatrixType. */
    public abstract void for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that);

    /** Process an instance of _SyntaxTransformationTaggedDimType. */
    public abstract void for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that);

    /** Process an instance of _SyntaxTransformationTaggedUnitType. */
    public abstract void for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that);

    /** Process an instance of _SyntaxTransformationTupleType. */
    public abstract void for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that);

    /** Process an instance of _SyntaxTransformationArrowType. */
    public abstract void for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that);

    /** Process an instance of _SyntaxTransformationBoundType. */
    public abstract void for_SyntaxTransformationBoundType(_SyntaxTransformationBoundType that);

    /** Process an instance of _SyntaxTransformationIntersectionType. */
    public abstract void for_SyntaxTransformationIntersectionType(_SyntaxTransformationIntersectionType that);

    /** Process an instance of _SyntaxTransformationUnionType. */
    public abstract void for_SyntaxTransformationUnionType(_SyntaxTransformationUnionType that);

    /** Process an instance of _SyntaxTransformationFixedPointType. */
    public abstract void for_SyntaxTransformationFixedPointType(_SyntaxTransformationFixedPointType that);

    /** Process an instance of _SyntaxTransformationLabelType. */
    public abstract void for_SyntaxTransformationLabelType(_SyntaxTransformationLabelType that);

    /** Process an instance of _SyntaxTransformationDimExpr. */
    public abstract void for_SyntaxTransformationDimExpr(_SyntaxTransformationDimExpr that);

    /** Process an instance of _SyntaxTransformationDimBase. */
    public abstract void for_SyntaxTransformationDimBase(_SyntaxTransformationDimBase that);

    /** Process an instance of _SyntaxTransformationDimRef. */
    public abstract void for_SyntaxTransformationDimRef(_SyntaxTransformationDimRef that);

    /** Process an instance of _SyntaxTransformationDimExponent. */
    public abstract void for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that);

    /** Process an instance of _SyntaxTransformationDimUnaryOp. */
    public abstract void for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that);

    /** Process an instance of _SyntaxTransformationDimBinaryOp. */
    public abstract void for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that);

    /** Process an instance of _EllipsesType. */
    public abstract void for_EllipsesType(_EllipsesType that);

    /** Process an instance of _EllipsesBaseType. */
    public abstract void for_EllipsesBaseType(_EllipsesBaseType that);

    /** Process an instance of _EllipsesAnyType. */
    public abstract void for_EllipsesAnyType(_EllipsesAnyType that);

    /** Process an instance of _EllipsesBottomType. */
    public abstract void for_EllipsesBottomType(_EllipsesBottomType that);

    /** Process an instance of _EllipsesUnknownType. */
    public abstract void for_EllipsesUnknownType(_EllipsesUnknownType that);

    /** Process an instance of _EllipsesSelfType. */
    public abstract void for_EllipsesSelfType(_EllipsesSelfType that);

    /** Process an instance of _EllipsesTraitSelfType. */
    public abstract void for_EllipsesTraitSelfType(_EllipsesTraitSelfType that);

    /** Process an instance of _EllipsesObjectExprType. */
    public abstract void for_EllipsesObjectExprType(_EllipsesObjectExprType that);

    /** Process an instance of _EllipsesNamedType. */
    public abstract void for_EllipsesNamedType(_EllipsesNamedType that);

    /** Process an instance of _Ellipses_InferenceVarType. */
    public abstract void for_Ellipses_InferenceVarType(_Ellipses_InferenceVarType that);

    /** Process an instance of _EllipsesVarType. */
    public abstract void for_EllipsesVarType(_EllipsesVarType that);

    /** Process an instance of _EllipsesTraitType. */
    public abstract void for_EllipsesTraitType(_EllipsesTraitType that);

    /** Process an instance of _EllipsesAbbreviatedType. */
    public abstract void for_EllipsesAbbreviatedType(_EllipsesAbbreviatedType that);

    /** Process an instance of _EllipsesArrayType. */
    public abstract void for_EllipsesArrayType(_EllipsesArrayType that);

    /** Process an instance of _EllipsesMatrixType. */
    public abstract void for_EllipsesMatrixType(_EllipsesMatrixType that);

    /** Process an instance of _EllipsesTaggedDimType. */
    public abstract void for_EllipsesTaggedDimType(_EllipsesTaggedDimType that);

    /** Process an instance of _EllipsesTaggedUnitType. */
    public abstract void for_EllipsesTaggedUnitType(_EllipsesTaggedUnitType that);

    /** Process an instance of _EllipsesTupleType. */
    public abstract void for_EllipsesTupleType(_EllipsesTupleType that);

    /** Process an instance of _EllipsesArrowType. */
    public abstract void for_EllipsesArrowType(_EllipsesArrowType that);

    /** Process an instance of _EllipsesBoundType. */
    public abstract void for_EllipsesBoundType(_EllipsesBoundType that);

    /** Process an instance of _EllipsesIntersectionType. */
    public abstract void for_EllipsesIntersectionType(_EllipsesIntersectionType that);

    /** Process an instance of _EllipsesUnionType. */
    public abstract void for_EllipsesUnionType(_EllipsesUnionType that);

    /** Process an instance of _EllipsesFixedPointType. */
    public abstract void for_EllipsesFixedPointType(_EllipsesFixedPointType that);

    /** Process an instance of _EllipsesLabelType. */
    public abstract void for_EllipsesLabelType(_EllipsesLabelType that);

    /** Process an instance of _EllipsesDimExpr. */
    public abstract void for_EllipsesDimExpr(_EllipsesDimExpr that);

    /** Process an instance of _EllipsesDimBase. */
    public abstract void for_EllipsesDimBase(_EllipsesDimBase that);

    /** Process an instance of _EllipsesDimRef. */
    public abstract void for_EllipsesDimRef(_EllipsesDimRef that);

    /** Process an instance of _EllipsesDimExponent. */
    public abstract void for_EllipsesDimExponent(_EllipsesDimExponent that);

    /** Process an instance of _EllipsesDimUnaryOp. */
    public abstract void for_EllipsesDimUnaryOp(_EllipsesDimUnaryOp that);

    /** Process an instance of _EllipsesDimBinaryOp. */
    public abstract void for_EllipsesDimBinaryOp(_EllipsesDimBinaryOp that);

    /** Process an instance of TemplateGapType. */
    public abstract void forTemplateGapType(TemplateGapType that);

    /** Process an instance of TemplateGapBaseType. */
    public abstract void forTemplateGapBaseType(TemplateGapBaseType that);

    /** Process an instance of TemplateGapAnyType. */
    public abstract void forTemplateGapAnyType(TemplateGapAnyType that);

    /** Process an instance of TemplateGapBottomType. */
    public abstract void forTemplateGapBottomType(TemplateGapBottomType that);

    /** Process an instance of TemplateGapUnknownType. */
    public abstract void forTemplateGapUnknownType(TemplateGapUnknownType that);

    /** Process an instance of TemplateGapSelfType. */
    public abstract void forTemplateGapSelfType(TemplateGapSelfType that);

    /** Process an instance of TemplateGapTraitSelfType. */
    public abstract void forTemplateGapTraitSelfType(TemplateGapTraitSelfType that);

    /** Process an instance of TemplateGapObjectExprType. */
    public abstract void forTemplateGapObjectExprType(TemplateGapObjectExprType that);

    /** Process an instance of TemplateGapNamedType. */
    public abstract void forTemplateGapNamedType(TemplateGapNamedType that);

    /** Process an instance of TemplateGap_InferenceVarType. */
    public abstract void forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that);

    /** Process an instance of TemplateGapVarType. */
    public abstract void forTemplateGapVarType(TemplateGapVarType that);

    /** Process an instance of TemplateGapTraitType. */
    public abstract void forTemplateGapTraitType(TemplateGapTraitType that);

    /** Process an instance of TemplateGapAbbreviatedType. */
    public abstract void forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that);

    /** Process an instance of TemplateGapArrayType. */
    public abstract void forTemplateGapArrayType(TemplateGapArrayType that);

    /** Process an instance of TemplateGapMatrixType. */
    public abstract void forTemplateGapMatrixType(TemplateGapMatrixType that);

    /** Process an instance of TemplateGapTaggedDimType. */
    public abstract void forTemplateGapTaggedDimType(TemplateGapTaggedDimType that);

    /** Process an instance of TemplateGapTaggedUnitType. */
    public abstract void forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that);

    /** Process an instance of TemplateGapTupleType. */
    public abstract void forTemplateGapTupleType(TemplateGapTupleType that);

    /** Process an instance of TemplateGapArrowType. */
    public abstract void forTemplateGapArrowType(TemplateGapArrowType that);

    /** Process an instance of TemplateGapBoundType. */
    public abstract void forTemplateGapBoundType(TemplateGapBoundType that);

    /** Process an instance of TemplateGapIntersectionType. */
    public abstract void forTemplateGapIntersectionType(TemplateGapIntersectionType that);

    /** Process an instance of TemplateGapUnionType. */
    public abstract void forTemplateGapUnionType(TemplateGapUnionType that);

    /** Process an instance of TemplateGapFixedPointType. */
    public abstract void forTemplateGapFixedPointType(TemplateGapFixedPointType that);

    /** Process an instance of TemplateGapLabelType. */
    public abstract void forTemplateGapLabelType(TemplateGapLabelType that);

    /** Process an instance of TemplateGapDimExpr. */
    public abstract void forTemplateGapDimExpr(TemplateGapDimExpr that);

    /** Process an instance of TemplateGapDimBase. */
    public abstract void forTemplateGapDimBase(TemplateGapDimBase that);

    /** Process an instance of TemplateGapDimRef. */
    public abstract void forTemplateGapDimRef(TemplateGapDimRef that);

    /** Process an instance of TemplateGapDimExponent. */
    public abstract void forTemplateGapDimExponent(TemplateGapDimExponent that);

    /** Process an instance of TemplateGapDimUnaryOp. */
    public abstract void forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that);

    /** Process an instance of TemplateGapDimBinaryOp. */
    public abstract void forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that);
}
