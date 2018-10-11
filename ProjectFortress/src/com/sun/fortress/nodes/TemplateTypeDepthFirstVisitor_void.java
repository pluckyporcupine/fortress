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

/** An abstract implementation of a visitor over Type including template gaps that does not return a value.
 ** This visitor implements the visitor interface with methods that 
 ** first call forCASEDoFirst(), second visit the children, and finally 
 ** call forCASEOnly().  (CASE is replaced by the case name.)
 ** By default, each of forCASEDoFirst and forCASEOnly delegates
 ** to a more general case.  At the top of this delegation tree are
 ** defaultDoFirst() and defaultCase(), respectively, which (unless
 ** overridden) are no-ops.
 **/
@SuppressWarnings(value={"unused"})
public class TemplateTypeDepthFirstVisitor_void extends TypeVisitorRunnable1 {
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, it is a no-op; subclasses may override this behavior.
    **/
    public void defaultCase(Type that) {}

    /**
     * This method is run for all DoFirst cases that are not handled elsewhere.
     * By default, it is a no-op; subclasses may override this behavior.
    **/
    public void defaultDoFirst(Type that) {}

    /* Methods to handle a node before recursion. */
    public void forTypeDoFirst(Type that) {
        defaultDoFirst(that);
    }

    public void forBaseTypeDoFirst(BaseType that) {
        forTypeDoFirst(that);
    }

    public void forAnyTypeDoFirst(AnyType that) {
        forBaseTypeDoFirst(that);
    }

    public void forBottomTypeDoFirst(BottomType that) {
        forBaseTypeDoFirst(that);
    }

    public void forUnknownTypeDoFirst(UnknownType that) {
        forBaseTypeDoFirst(that);
    }

    public void forSelfTypeDoFirst(SelfType that) {
        forBaseTypeDoFirst(that);
    }

    public void forTraitSelfTypeDoFirst(TraitSelfType that) {
        forSelfTypeDoFirst(that);
    }

    public void forObjectExprTypeDoFirst(ObjectExprType that) {
        forSelfTypeDoFirst(that);
    }

    public void forNamedTypeDoFirst(NamedType that) {
        forBaseTypeDoFirst(that);
    }

    public void for_InferenceVarTypeDoFirst(_InferenceVarType that) {
        forNamedTypeDoFirst(that);
    }

    public void forVarTypeDoFirst(VarType that) {
        forNamedTypeDoFirst(that);
    }

    public void forTraitTypeDoFirst(TraitType that) {
        forNamedTypeDoFirst(that);
    }

    public void forAbbreviatedTypeDoFirst(AbbreviatedType that) {
        forBaseTypeDoFirst(that);
    }

    public void forArrayTypeDoFirst(ArrayType that) {
        forAbbreviatedTypeDoFirst(that);
    }

    public void forMatrixTypeDoFirst(MatrixType that) {
        forAbbreviatedTypeDoFirst(that);
    }

    public void forTaggedDimTypeDoFirst(TaggedDimType that) {
        forAbbreviatedTypeDoFirst(that);
    }

    public void forTaggedUnitTypeDoFirst(TaggedUnitType that) {
        forAbbreviatedTypeDoFirst(that);
    }

    public void forTupleTypeDoFirst(TupleType that) {
        forTypeDoFirst(that);
    }

    public void forArrowTypeDoFirst(ArrowType that) {
        forTypeDoFirst(that);
    }

    public void forBoundTypeDoFirst(BoundType that) {
        forTypeDoFirst(that);
    }

    public void forIntersectionTypeDoFirst(IntersectionType that) {
        forBoundTypeDoFirst(that);
    }

    public void forUnionTypeDoFirst(UnionType that) {
        forBoundTypeDoFirst(that);
    }

    public void forFixedPointTypeDoFirst(FixedPointType that) {
        forTypeDoFirst(that);
    }

    public void forLabelTypeDoFirst(LabelType that) {
        forTypeDoFirst(that);
    }

    public void forDimExprDoFirst(DimExpr that) {
        forTypeDoFirst(that);
    }

    public void forDimBaseDoFirst(DimBase that) {
        forDimExprDoFirst(that);
    }

    public void forDimRefDoFirst(DimRef that) {
        forDimExprDoFirst(that);
    }

    public void forDimExponentDoFirst(DimExponent that) {
        forDimExprDoFirst(that);
    }

    public void forDimUnaryOpDoFirst(DimUnaryOp that) {
        forDimExprDoFirst(that);
    }

    public void forDimBinaryOpDoFirst(DimBinaryOp that) {
        forDimExprDoFirst(that);
    }

    public void for_SyntaxTransformationTypeDoFirst(_SyntaxTransformationType that) {
        forTypeDoFirst(that);
    }

    public void for_SyntaxTransformationBaseTypeDoFirst(_SyntaxTransformationBaseType that) {
        forBaseTypeDoFirst(that);
    }

    public void for_SyntaxTransformationAnyTypeDoFirst(_SyntaxTransformationAnyType that) {
        forAnyTypeDoFirst(that);
    }

    public void for_SyntaxTransformationBottomTypeDoFirst(_SyntaxTransformationBottomType that) {
        forBottomTypeDoFirst(that);
    }

    public void for_SyntaxTransformationUnknownTypeDoFirst(_SyntaxTransformationUnknownType that) {
        forUnknownTypeDoFirst(that);
    }

    public void for_SyntaxTransformationSelfTypeDoFirst(_SyntaxTransformationSelfType that) {
        forSelfTypeDoFirst(that);
    }

    public void for_SyntaxTransformationTraitSelfTypeDoFirst(_SyntaxTransformationTraitSelfType that) {
        forTraitSelfTypeDoFirst(that);
    }

    public void for_SyntaxTransformationObjectExprTypeDoFirst(_SyntaxTransformationObjectExprType that) {
        forObjectExprTypeDoFirst(that);
    }

    public void for_SyntaxTransformationNamedTypeDoFirst(_SyntaxTransformationNamedType that) {
        forNamedTypeDoFirst(that);
    }

    public void for_SyntaxTransformation_InferenceVarTypeDoFirst(_SyntaxTransformation_InferenceVarType that) {
        for_InferenceVarTypeDoFirst(that);
    }

    public void for_SyntaxTransformationVarTypeDoFirst(_SyntaxTransformationVarType that) {
        forVarTypeDoFirst(that);
    }

    public void for_SyntaxTransformationTraitTypeDoFirst(_SyntaxTransformationTraitType that) {
        forTraitTypeDoFirst(that);
    }

    public void for_SyntaxTransformationAbbreviatedTypeDoFirst(_SyntaxTransformationAbbreviatedType that) {
        forAbbreviatedTypeDoFirst(that);
    }

    public void for_SyntaxTransformationArrayTypeDoFirst(_SyntaxTransformationArrayType that) {
        forArrayTypeDoFirst(that);
    }

    public void for_SyntaxTransformationMatrixTypeDoFirst(_SyntaxTransformationMatrixType that) {
        forMatrixTypeDoFirst(that);
    }

    public void for_SyntaxTransformationTaggedDimTypeDoFirst(_SyntaxTransformationTaggedDimType that) {
        forTaggedDimTypeDoFirst(that);
    }

    public void for_SyntaxTransformationTaggedUnitTypeDoFirst(_SyntaxTransformationTaggedUnitType that) {
        forTaggedUnitTypeDoFirst(that);
    }

    public void for_SyntaxTransformationTupleTypeDoFirst(_SyntaxTransformationTupleType that) {
        forTupleTypeDoFirst(that);
    }

    public void for_SyntaxTransformationArrowTypeDoFirst(_SyntaxTransformationArrowType that) {
        forArrowTypeDoFirst(that);
    }

    public void for_SyntaxTransformationBoundTypeDoFirst(_SyntaxTransformationBoundType that) {
        forBoundTypeDoFirst(that);
    }

    public void for_SyntaxTransformationIntersectionTypeDoFirst(_SyntaxTransformationIntersectionType that) {
        forIntersectionTypeDoFirst(that);
    }

    public void for_SyntaxTransformationUnionTypeDoFirst(_SyntaxTransformationUnionType that) {
        forUnionTypeDoFirst(that);
    }

    public void for_SyntaxTransformationFixedPointTypeDoFirst(_SyntaxTransformationFixedPointType that) {
        forFixedPointTypeDoFirst(that);
    }

    public void for_SyntaxTransformationLabelTypeDoFirst(_SyntaxTransformationLabelType that) {
        forLabelTypeDoFirst(that);
    }

    public void for_SyntaxTransformationDimExprDoFirst(_SyntaxTransformationDimExpr that) {
        forDimExprDoFirst(that);
    }

    public void for_SyntaxTransformationDimBaseDoFirst(_SyntaxTransformationDimBase that) {
        forDimBaseDoFirst(that);
    }

    public void for_SyntaxTransformationDimRefDoFirst(_SyntaxTransformationDimRef that) {
        forDimRefDoFirst(that);
    }

    public void for_SyntaxTransformationDimExponentDoFirst(_SyntaxTransformationDimExponent that) {
        forDimExponentDoFirst(that);
    }

    public void for_SyntaxTransformationDimUnaryOpDoFirst(_SyntaxTransformationDimUnaryOp that) {
        forDimUnaryOpDoFirst(that);
    }

    public void for_SyntaxTransformationDimBinaryOpDoFirst(_SyntaxTransformationDimBinaryOp that) {
        forDimBinaryOpDoFirst(that);
    }

    public void for_EllipsesTypeDoFirst(_EllipsesType that) {
        forTypeDoFirst(that);
    }

    public void for_EllipsesBaseTypeDoFirst(_EllipsesBaseType that) {
        forBaseTypeDoFirst(that);
    }

    public void for_EllipsesAnyTypeDoFirst(_EllipsesAnyType that) {
        forAnyTypeDoFirst(that);
    }

    public void for_EllipsesBottomTypeDoFirst(_EllipsesBottomType that) {
        forBottomTypeDoFirst(that);
    }

    public void for_EllipsesUnknownTypeDoFirst(_EllipsesUnknownType that) {
        forUnknownTypeDoFirst(that);
    }

    public void for_EllipsesSelfTypeDoFirst(_EllipsesSelfType that) {
        forSelfTypeDoFirst(that);
    }

    public void for_EllipsesTraitSelfTypeDoFirst(_EllipsesTraitSelfType that) {
        forTraitSelfTypeDoFirst(that);
    }

    public void for_EllipsesObjectExprTypeDoFirst(_EllipsesObjectExprType that) {
        forObjectExprTypeDoFirst(that);
    }

    public void for_EllipsesNamedTypeDoFirst(_EllipsesNamedType that) {
        forNamedTypeDoFirst(that);
    }

    public void for_Ellipses_InferenceVarTypeDoFirst(_Ellipses_InferenceVarType that) {
        for_InferenceVarTypeDoFirst(that);
    }

    public void for_EllipsesVarTypeDoFirst(_EllipsesVarType that) {
        forVarTypeDoFirst(that);
    }

    public void for_EllipsesTraitTypeDoFirst(_EllipsesTraitType that) {
        forTraitTypeDoFirst(that);
    }

    public void for_EllipsesAbbreviatedTypeDoFirst(_EllipsesAbbreviatedType that) {
        forAbbreviatedTypeDoFirst(that);
    }

    public void for_EllipsesArrayTypeDoFirst(_EllipsesArrayType that) {
        forArrayTypeDoFirst(that);
    }

    public void for_EllipsesMatrixTypeDoFirst(_EllipsesMatrixType that) {
        forMatrixTypeDoFirst(that);
    }

    public void for_EllipsesTaggedDimTypeDoFirst(_EllipsesTaggedDimType that) {
        forTaggedDimTypeDoFirst(that);
    }

    public void for_EllipsesTaggedUnitTypeDoFirst(_EllipsesTaggedUnitType that) {
        forTaggedUnitTypeDoFirst(that);
    }

    public void for_EllipsesTupleTypeDoFirst(_EllipsesTupleType that) {
        forTupleTypeDoFirst(that);
    }

    public void for_EllipsesArrowTypeDoFirst(_EllipsesArrowType that) {
        forArrowTypeDoFirst(that);
    }

    public void for_EllipsesBoundTypeDoFirst(_EllipsesBoundType that) {
        forBoundTypeDoFirst(that);
    }

    public void for_EllipsesIntersectionTypeDoFirst(_EllipsesIntersectionType that) {
        forIntersectionTypeDoFirst(that);
    }

    public void for_EllipsesUnionTypeDoFirst(_EllipsesUnionType that) {
        forUnionTypeDoFirst(that);
    }

    public void for_EllipsesFixedPointTypeDoFirst(_EllipsesFixedPointType that) {
        forFixedPointTypeDoFirst(that);
    }

    public void for_EllipsesLabelTypeDoFirst(_EllipsesLabelType that) {
        forLabelTypeDoFirst(that);
    }

    public void for_EllipsesDimExprDoFirst(_EllipsesDimExpr that) {
        forDimExprDoFirst(that);
    }

    public void for_EllipsesDimBaseDoFirst(_EllipsesDimBase that) {
        forDimBaseDoFirst(that);
    }

    public void for_EllipsesDimRefDoFirst(_EllipsesDimRef that) {
        forDimRefDoFirst(that);
    }

    public void for_EllipsesDimExponentDoFirst(_EllipsesDimExponent that) {
        forDimExponentDoFirst(that);
    }

    public void for_EllipsesDimUnaryOpDoFirst(_EllipsesDimUnaryOp that) {
        forDimUnaryOpDoFirst(that);
    }

    public void for_EllipsesDimBinaryOpDoFirst(_EllipsesDimBinaryOp that) {
        forDimBinaryOpDoFirst(that);
    }

    public void forTemplateGapTypeDoFirst(TemplateGapType that) {
        forTypeDoFirst(that);
    }

    public void forTemplateGapBaseTypeDoFirst(TemplateGapBaseType that) {
        forBaseTypeDoFirst(that);
    }

    public void forTemplateGapAnyTypeDoFirst(TemplateGapAnyType that) {
        forAnyTypeDoFirst(that);
    }

    public void forTemplateGapBottomTypeDoFirst(TemplateGapBottomType that) {
        forBottomTypeDoFirst(that);
    }

    public void forTemplateGapUnknownTypeDoFirst(TemplateGapUnknownType that) {
        forUnknownTypeDoFirst(that);
    }

    public void forTemplateGapSelfTypeDoFirst(TemplateGapSelfType that) {
        forSelfTypeDoFirst(that);
    }

    public void forTemplateGapTraitSelfTypeDoFirst(TemplateGapTraitSelfType that) {
        forTraitSelfTypeDoFirst(that);
    }

    public void forTemplateGapObjectExprTypeDoFirst(TemplateGapObjectExprType that) {
        forObjectExprTypeDoFirst(that);
    }

    public void forTemplateGapNamedTypeDoFirst(TemplateGapNamedType that) {
        forNamedTypeDoFirst(that);
    }

    public void forTemplateGap_InferenceVarTypeDoFirst(TemplateGap_InferenceVarType that) {
        for_InferenceVarTypeDoFirst(that);
    }

    public void forTemplateGapVarTypeDoFirst(TemplateGapVarType that) {
        forVarTypeDoFirst(that);
    }

    public void forTemplateGapTraitTypeDoFirst(TemplateGapTraitType that) {
        forTraitTypeDoFirst(that);
    }

    public void forTemplateGapAbbreviatedTypeDoFirst(TemplateGapAbbreviatedType that) {
        forAbbreviatedTypeDoFirst(that);
    }

    public void forTemplateGapArrayTypeDoFirst(TemplateGapArrayType that) {
        forArrayTypeDoFirst(that);
    }

    public void forTemplateGapMatrixTypeDoFirst(TemplateGapMatrixType that) {
        forMatrixTypeDoFirst(that);
    }

    public void forTemplateGapTaggedDimTypeDoFirst(TemplateGapTaggedDimType that) {
        forTaggedDimTypeDoFirst(that);
    }

    public void forTemplateGapTaggedUnitTypeDoFirst(TemplateGapTaggedUnitType that) {
        forTaggedUnitTypeDoFirst(that);
    }

    public void forTemplateGapTupleTypeDoFirst(TemplateGapTupleType that) {
        forTupleTypeDoFirst(that);
    }

    public void forTemplateGapArrowTypeDoFirst(TemplateGapArrowType that) {
        forArrowTypeDoFirst(that);
    }

    public void forTemplateGapBoundTypeDoFirst(TemplateGapBoundType that) {
        forBoundTypeDoFirst(that);
    }

    public void forTemplateGapIntersectionTypeDoFirst(TemplateGapIntersectionType that) {
        forIntersectionTypeDoFirst(that);
    }

    public void forTemplateGapUnionTypeDoFirst(TemplateGapUnionType that) {
        forUnionTypeDoFirst(that);
    }

    public void forTemplateGapFixedPointTypeDoFirst(TemplateGapFixedPointType that) {
        forFixedPointTypeDoFirst(that);
    }

    public void forTemplateGapLabelTypeDoFirst(TemplateGapLabelType that) {
        forLabelTypeDoFirst(that);
    }

    public void forTemplateGapDimExprDoFirst(TemplateGapDimExpr that) {
        forDimExprDoFirst(that);
    }

    public void forTemplateGapDimBaseDoFirst(TemplateGapDimBase that) {
        forDimBaseDoFirst(that);
    }

    public void forTemplateGapDimRefDoFirst(TemplateGapDimRef that) {
        forDimRefDoFirst(that);
    }

    public void forTemplateGapDimExponentDoFirst(TemplateGapDimExponent that) {
        forDimExponentDoFirst(that);
    }

    public void forTemplateGapDimUnaryOpDoFirst(TemplateGapDimUnaryOp that) {
        forDimUnaryOpDoFirst(that);
    }

    public void forTemplateGapDimBinaryOpDoFirst(TemplateGapDimBinaryOp that) {
        forDimBinaryOpDoFirst(that);
    }

    /* Methods to handle a node after recursion. */
    public void forTypeOnly(Type that) {
        defaultCase(that);
    }

    public void forBaseTypeOnly(BaseType that) {
        forTypeOnly(that);
    }

    public void forAnyTypeOnly(AnyType that) {
        forBaseTypeOnly(that);
    }

    public void forBottomTypeOnly(BottomType that) {
        forBaseTypeOnly(that);
    }

    public void forUnknownTypeOnly(UnknownType that) {
        forBaseTypeOnly(that);
    }

    public void forSelfTypeOnly(SelfType that) {
        forBaseTypeOnly(that);
    }

    public void forTraitSelfTypeOnly(TraitSelfType that) {
        forSelfTypeOnly(that);
    }

    public void forObjectExprTypeOnly(ObjectExprType that) {
        forSelfTypeOnly(that);
    }

    public void forNamedTypeOnly(NamedType that) {
        forBaseTypeOnly(that);
    }

    public void for_InferenceVarTypeOnly(_InferenceVarType that) {
        forNamedTypeOnly(that);
    }

    public void forVarTypeOnly(VarType that) {
        forNamedTypeOnly(that);
    }

    public void forTraitTypeOnly(TraitType that) {
        forNamedTypeOnly(that);
    }

    public void forAbbreviatedTypeOnly(AbbreviatedType that) {
        forBaseTypeOnly(that);
    }

    public void forArrayTypeOnly(ArrayType that) {
        forAbbreviatedTypeOnly(that);
    }

    public void forMatrixTypeOnly(MatrixType that) {
        forAbbreviatedTypeOnly(that);
    }

    public void forTaggedDimTypeOnly(TaggedDimType that) {
        forAbbreviatedTypeOnly(that);
    }

    public void forTaggedUnitTypeOnly(TaggedUnitType that) {
        forAbbreviatedTypeOnly(that);
    }

    public void forTupleTypeOnly(TupleType that) {
        forTypeOnly(that);
    }

    public void forArrowTypeOnly(ArrowType that) {
        forTypeOnly(that);
    }

    public void forBoundTypeOnly(BoundType that) {
        forTypeOnly(that);
    }

    public void forIntersectionTypeOnly(IntersectionType that) {
        forBoundTypeOnly(that);
    }

    public void forUnionTypeOnly(UnionType that) {
        forBoundTypeOnly(that);
    }

    public void forFixedPointTypeOnly(FixedPointType that) {
        forTypeOnly(that);
    }

    public void forLabelTypeOnly(LabelType that) {
        forTypeOnly(that);
    }

    public void forDimExprOnly(DimExpr that) {
        forTypeOnly(that);
    }

    public void forDimBaseOnly(DimBase that) {
        forDimExprOnly(that);
    }

    public void forDimRefOnly(DimRef that) {
        forDimExprOnly(that);
    }

    public void forDimExponentOnly(DimExponent that) {
        forDimExprOnly(that);
    }

    public void forDimUnaryOpOnly(DimUnaryOp that) {
        forDimExprOnly(that);
    }

    public void forDimBinaryOpOnly(DimBinaryOp that) {
        forDimExprOnly(that);
    }

    public void for_SyntaxTransformationTypeOnly(_SyntaxTransformationType that) {
        forTypeOnly(that);
    }

    public void for_SyntaxTransformationBaseTypeOnly(_SyntaxTransformationBaseType that) {
        forBaseTypeOnly(that);
    }

    public void for_SyntaxTransformationAnyTypeOnly(_SyntaxTransformationAnyType that) {
        forAnyTypeOnly(that);
    }

    public void for_SyntaxTransformationBottomTypeOnly(_SyntaxTransformationBottomType that) {
        forBottomTypeOnly(that);
    }

    public void for_SyntaxTransformationUnknownTypeOnly(_SyntaxTransformationUnknownType that) {
        forUnknownTypeOnly(that);
    }

    public void for_SyntaxTransformationSelfTypeOnly(_SyntaxTransformationSelfType that) {
        forSelfTypeOnly(that);
    }

    public void for_SyntaxTransformationTraitSelfTypeOnly(_SyntaxTransformationTraitSelfType that) {
        forTraitSelfTypeOnly(that);
    }

    public void for_SyntaxTransformationObjectExprTypeOnly(_SyntaxTransformationObjectExprType that) {
        forObjectExprTypeOnly(that);
    }

    public void for_SyntaxTransformationNamedTypeOnly(_SyntaxTransformationNamedType that) {
        forNamedTypeOnly(that);
    }

    public void for_SyntaxTransformation_InferenceVarTypeOnly(_SyntaxTransformation_InferenceVarType that) {
        for_InferenceVarTypeOnly(that);
    }

    public void for_SyntaxTransformationVarTypeOnly(_SyntaxTransformationVarType that) {
        forVarTypeOnly(that);
    }

    public void for_SyntaxTransformationTraitTypeOnly(_SyntaxTransformationTraitType that) {
        forTraitTypeOnly(that);
    }

    public void for_SyntaxTransformationAbbreviatedTypeOnly(_SyntaxTransformationAbbreviatedType that) {
        forAbbreviatedTypeOnly(that);
    }

    public void for_SyntaxTransformationArrayTypeOnly(_SyntaxTransformationArrayType that) {
        forArrayTypeOnly(that);
    }

    public void for_SyntaxTransformationMatrixTypeOnly(_SyntaxTransformationMatrixType that) {
        forMatrixTypeOnly(that);
    }

    public void for_SyntaxTransformationTaggedDimTypeOnly(_SyntaxTransformationTaggedDimType that) {
        forTaggedDimTypeOnly(that);
    }

    public void for_SyntaxTransformationTaggedUnitTypeOnly(_SyntaxTransformationTaggedUnitType that) {
        forTaggedUnitTypeOnly(that);
    }

    public void for_SyntaxTransformationTupleTypeOnly(_SyntaxTransformationTupleType that) {
        forTupleTypeOnly(that);
    }

    public void for_SyntaxTransformationArrowTypeOnly(_SyntaxTransformationArrowType that) {
        forArrowTypeOnly(that);
    }

    public void for_SyntaxTransformationBoundTypeOnly(_SyntaxTransformationBoundType that) {
        forBoundTypeOnly(that);
    }

    public void for_SyntaxTransformationIntersectionTypeOnly(_SyntaxTransformationIntersectionType that) {
        forIntersectionTypeOnly(that);
    }

    public void for_SyntaxTransformationUnionTypeOnly(_SyntaxTransformationUnionType that) {
        forUnionTypeOnly(that);
    }

    public void for_SyntaxTransformationFixedPointTypeOnly(_SyntaxTransformationFixedPointType that) {
        forFixedPointTypeOnly(that);
    }

    public void for_SyntaxTransformationLabelTypeOnly(_SyntaxTransformationLabelType that) {
        forLabelTypeOnly(that);
    }

    public void for_SyntaxTransformationDimExprOnly(_SyntaxTransformationDimExpr that) {
        forDimExprOnly(that);
    }

    public void for_SyntaxTransformationDimBaseOnly(_SyntaxTransformationDimBase that) {
        forDimBaseOnly(that);
    }

    public void for_SyntaxTransformationDimRefOnly(_SyntaxTransformationDimRef that) {
        forDimRefOnly(that);
    }

    public void for_SyntaxTransformationDimExponentOnly(_SyntaxTransformationDimExponent that) {
        forDimExponentOnly(that);
    }

    public void for_SyntaxTransformationDimUnaryOpOnly(_SyntaxTransformationDimUnaryOp that) {
        forDimUnaryOpOnly(that);
    }

    public void for_SyntaxTransformationDimBinaryOpOnly(_SyntaxTransformationDimBinaryOp that) {
        forDimBinaryOpOnly(that);
    }

    public void for_EllipsesTypeOnly(_EllipsesType that) {
        forTypeOnly(that);
    }

    public void for_EllipsesBaseTypeOnly(_EllipsesBaseType that) {
        forBaseTypeOnly(that);
    }

    public void for_EllipsesAnyTypeOnly(_EllipsesAnyType that) {
        forAnyTypeOnly(that);
    }

    public void for_EllipsesBottomTypeOnly(_EllipsesBottomType that) {
        forBottomTypeOnly(that);
    }

    public void for_EllipsesUnknownTypeOnly(_EllipsesUnknownType that) {
        forUnknownTypeOnly(that);
    }

    public void for_EllipsesSelfTypeOnly(_EllipsesSelfType that) {
        forSelfTypeOnly(that);
    }

    public void for_EllipsesTraitSelfTypeOnly(_EllipsesTraitSelfType that) {
        forTraitSelfTypeOnly(that);
    }

    public void for_EllipsesObjectExprTypeOnly(_EllipsesObjectExprType that) {
        forObjectExprTypeOnly(that);
    }

    public void for_EllipsesNamedTypeOnly(_EllipsesNamedType that) {
        forNamedTypeOnly(that);
    }

    public void for_Ellipses_InferenceVarTypeOnly(_Ellipses_InferenceVarType that) {
        for_InferenceVarTypeOnly(that);
    }

    public void for_EllipsesVarTypeOnly(_EllipsesVarType that) {
        forVarTypeOnly(that);
    }

    public void for_EllipsesTraitTypeOnly(_EllipsesTraitType that) {
        forTraitTypeOnly(that);
    }

    public void for_EllipsesAbbreviatedTypeOnly(_EllipsesAbbreviatedType that) {
        forAbbreviatedTypeOnly(that);
    }

    public void for_EllipsesArrayTypeOnly(_EllipsesArrayType that) {
        forArrayTypeOnly(that);
    }

    public void for_EllipsesMatrixTypeOnly(_EllipsesMatrixType that) {
        forMatrixTypeOnly(that);
    }

    public void for_EllipsesTaggedDimTypeOnly(_EllipsesTaggedDimType that) {
        forTaggedDimTypeOnly(that);
    }

    public void for_EllipsesTaggedUnitTypeOnly(_EllipsesTaggedUnitType that) {
        forTaggedUnitTypeOnly(that);
    }

    public void for_EllipsesTupleTypeOnly(_EllipsesTupleType that) {
        forTupleTypeOnly(that);
    }

    public void for_EllipsesArrowTypeOnly(_EllipsesArrowType that) {
        forArrowTypeOnly(that);
    }

    public void for_EllipsesBoundTypeOnly(_EllipsesBoundType that) {
        forBoundTypeOnly(that);
    }

    public void for_EllipsesIntersectionTypeOnly(_EllipsesIntersectionType that) {
        forIntersectionTypeOnly(that);
    }

    public void for_EllipsesUnionTypeOnly(_EllipsesUnionType that) {
        forUnionTypeOnly(that);
    }

    public void for_EllipsesFixedPointTypeOnly(_EllipsesFixedPointType that) {
        forFixedPointTypeOnly(that);
    }

    public void for_EllipsesLabelTypeOnly(_EllipsesLabelType that) {
        forLabelTypeOnly(that);
    }

    public void for_EllipsesDimExprOnly(_EllipsesDimExpr that) {
        forDimExprOnly(that);
    }

    public void for_EllipsesDimBaseOnly(_EllipsesDimBase that) {
        forDimBaseOnly(that);
    }

    public void for_EllipsesDimRefOnly(_EllipsesDimRef that) {
        forDimRefOnly(that);
    }

    public void for_EllipsesDimExponentOnly(_EllipsesDimExponent that) {
        forDimExponentOnly(that);
    }

    public void for_EllipsesDimUnaryOpOnly(_EllipsesDimUnaryOp that) {
        forDimUnaryOpOnly(that);
    }

    public void for_EllipsesDimBinaryOpOnly(_EllipsesDimBinaryOp that) {
        forDimBinaryOpOnly(that);
    }

    public void forTemplateGapTypeOnly(TemplateGapType that) {
        forTypeOnly(that);
    }

    public void forTemplateGapBaseTypeOnly(TemplateGapBaseType that) {
        forBaseTypeOnly(that);
    }

    public void forTemplateGapAnyTypeOnly(TemplateGapAnyType that) {
        forAnyTypeOnly(that);
    }

    public void forTemplateGapBottomTypeOnly(TemplateGapBottomType that) {
        forBottomTypeOnly(that);
    }

    public void forTemplateGapUnknownTypeOnly(TemplateGapUnknownType that) {
        forUnknownTypeOnly(that);
    }

    public void forTemplateGapSelfTypeOnly(TemplateGapSelfType that) {
        forSelfTypeOnly(that);
    }

    public void forTemplateGapTraitSelfTypeOnly(TemplateGapTraitSelfType that) {
        forTraitSelfTypeOnly(that);
    }

    public void forTemplateGapObjectExprTypeOnly(TemplateGapObjectExprType that) {
        forObjectExprTypeOnly(that);
    }

    public void forTemplateGapNamedTypeOnly(TemplateGapNamedType that) {
        forNamedTypeOnly(that);
    }

    public void forTemplateGap_InferenceVarTypeOnly(TemplateGap_InferenceVarType that) {
        for_InferenceVarTypeOnly(that);
    }

    public void forTemplateGapVarTypeOnly(TemplateGapVarType that) {
        forVarTypeOnly(that);
    }

    public void forTemplateGapTraitTypeOnly(TemplateGapTraitType that) {
        forTraitTypeOnly(that);
    }

    public void forTemplateGapAbbreviatedTypeOnly(TemplateGapAbbreviatedType that) {
        forAbbreviatedTypeOnly(that);
    }

    public void forTemplateGapArrayTypeOnly(TemplateGapArrayType that) {
        forArrayTypeOnly(that);
    }

    public void forTemplateGapMatrixTypeOnly(TemplateGapMatrixType that) {
        forMatrixTypeOnly(that);
    }

    public void forTemplateGapTaggedDimTypeOnly(TemplateGapTaggedDimType that) {
        forTaggedDimTypeOnly(that);
    }

    public void forTemplateGapTaggedUnitTypeOnly(TemplateGapTaggedUnitType that) {
        forTaggedUnitTypeOnly(that);
    }

    public void forTemplateGapTupleTypeOnly(TemplateGapTupleType that) {
        forTupleTypeOnly(that);
    }

    public void forTemplateGapArrowTypeOnly(TemplateGapArrowType that) {
        forArrowTypeOnly(that);
    }

    public void forTemplateGapBoundTypeOnly(TemplateGapBoundType that) {
        forBoundTypeOnly(that);
    }

    public void forTemplateGapIntersectionTypeOnly(TemplateGapIntersectionType that) {
        forIntersectionTypeOnly(that);
    }

    public void forTemplateGapUnionTypeOnly(TemplateGapUnionType that) {
        forUnionTypeOnly(that);
    }

    public void forTemplateGapFixedPointTypeOnly(TemplateGapFixedPointType that) {
        forFixedPointTypeOnly(that);
    }

    public void forTemplateGapLabelTypeOnly(TemplateGapLabelType that) {
        forLabelTypeOnly(that);
    }

    public void forTemplateGapDimExprOnly(TemplateGapDimExpr that) {
        forDimExprOnly(that);
    }

    public void forTemplateGapDimBaseOnly(TemplateGapDimBase that) {
        forDimBaseOnly(that);
    }

    public void forTemplateGapDimRefOnly(TemplateGapDimRef that) {
        forDimRefOnly(that);
    }

    public void forTemplateGapDimExponentOnly(TemplateGapDimExponent that) {
        forDimExponentOnly(that);
    }

    public void forTemplateGapDimUnaryOpOnly(TemplateGapDimUnaryOp that) {
        forDimUnaryOpOnly(that);
    }

    public void forTemplateGapDimBinaryOpOnly(TemplateGapDimBinaryOp that) {
        forDimBinaryOpOnly(that);
    }

    /* Methods to recur on each child. */
    public void forAnyType(AnyType that) {
        forAnyTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        forAnyTypeOnly(that);
    }

    public void forBottomType(BottomType that) {
        forBottomTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        forBottomTypeOnly(that);
    }

    public void forUnknownType(UnknownType that) {
        forUnknownTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        forUnknownTypeOnly(that);
    }

    public void forTraitSelfType(TraitSelfType that) {
        forTraitSelfTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getNamed());
        recurOnListOfNamedType(that.getComprised());
        forTraitSelfTypeOnly(that);
    }

    public void forObjectExprType(ObjectExprType that) {
        forObjectExprTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnListOfBaseType(that.getExtended());
        forObjectExprTypeOnly(that);
    }

    public void for_InferenceVarType(_InferenceVarType that) {
        for_InferenceVarTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getName());
        for_InferenceVarTypeOnly(that);
    }

    public void forVarType(VarType that) {
        forVarTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getName());
        forVarTypeOnly(that);
    }

    public void forTraitType(TraitType that) {
        forTraitTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getName());
        recurOnListOfStaticArg(that.getArgs());
        recurOnListOfStaticParam(that.getTraitStaticParams());
        forTraitTypeOnly(that);
    }

    public void forArrayType(ArrayType that) {
        forArrayTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getElemType());
        recurOnIndices(that.getIndices());
        forArrayTypeOnly(that);
    }

    public void forMatrixType(MatrixType that) {
        forMatrixTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getElemType());
        recurOnListOfExtentRange(that.getDimensions());
        forMatrixTypeOnly(that);
    }

    public void forTaggedDimType(TaggedDimType that) {
        forTaggedDimTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getElemType());
        recur(that.getDimExpr());
        recurOnOptionOfExpr(that.getUnitExpr());
        forTaggedDimTypeOnly(that);
    }

    public void forTaggedUnitType(TaggedUnitType that) {
        forTaggedUnitTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getElemType());
        recurOnExpr(that.getUnitExpr());
        forTaggedUnitTypeOnly(that);
    }

    public void forTupleType(TupleType that) {
        forTupleTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnListOfType(that.getElements());
        recurOnOptionOfType(that.getVarargs());
        recurOnListOfKeywordType(that.getKeywords());
        forTupleTypeOnly(that);
    }

    public void forArrowType(ArrowType that) {
        forArrowTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getDomain());
        recur(that.getRange());
        recurOnEffect(that.getEffect());
        recurOnOptionOfMethodInfo(that.getMethodInfo());
        forArrowTypeOnly(that);
    }

    public void forIntersectionType(IntersectionType that) {
        forIntersectionTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnListOfType(that.getElements());
        forIntersectionTypeOnly(that);
    }

    public void forUnionType(UnionType that) {
        forUnionTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnListOfType(that.getElements());
        forUnionTypeOnly(that);
    }

    public void forFixedPointType(FixedPointType that) {
        forFixedPointTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getName());
        recur(that.getBody());
        forFixedPointTypeOnly(that);
    }

    public void forLabelType(LabelType that) {
        forLabelTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        forLabelTypeOnly(that);
    }

    public void forDimBase(DimBase that) {
        forDimBaseDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        forDimBaseOnly(that);
    }

    public void forDimRef(DimRef that) {
        forDimRefDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getName());
        forDimRefOnly(that);
    }

    public void forDimExponent(DimExponent that) {
        forDimExponentDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getBase());
        recurOnIntExpr(that.getPower());
        forDimExponentOnly(that);
    }

    public void forDimUnaryOp(DimUnaryOp that) {
        forDimUnaryOpDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getDimVal());
        recurOnOp(that.getOp());
        forDimUnaryOpOnly(that);
    }

    public void forDimBinaryOp(DimBinaryOp that) {
        forDimBinaryOpDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getLeft());
        recur(that.getRight());
        recurOnOp(that.getOp());
        forDimBinaryOpOnly(that);
    }

    public void for_SyntaxTransformationType(_SyntaxTransformationType that) {
        for_SyntaxTransformationTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationTypeOnly(that);
    }

    public void for_SyntaxTransformationBaseType(_SyntaxTransformationBaseType that) {
        for_SyntaxTransformationBaseTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationBaseTypeOnly(that);
    }

    public void for_SyntaxTransformationAnyType(_SyntaxTransformationAnyType that) {
        for_SyntaxTransformationAnyTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationAnyTypeOnly(that);
    }

    public void for_SyntaxTransformationBottomType(_SyntaxTransformationBottomType that) {
        for_SyntaxTransformationBottomTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationBottomTypeOnly(that);
    }

    public void for_SyntaxTransformationUnknownType(_SyntaxTransformationUnknownType that) {
        for_SyntaxTransformationUnknownTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationUnknownTypeOnly(that);
    }

    public void for_SyntaxTransformationSelfType(_SyntaxTransformationSelfType that) {
        for_SyntaxTransformationSelfTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationSelfTypeOnly(that);
    }

    public void for_SyntaxTransformationTraitSelfType(_SyntaxTransformationTraitSelfType that) {
        for_SyntaxTransformationTraitSelfTypeDoFirst(that);
        recur(that.getNamed());
        recurOnListOfNamedType(that.getComprised());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationTraitSelfTypeOnly(that);
    }

    public void for_SyntaxTransformationObjectExprType(_SyntaxTransformationObjectExprType that) {
        for_SyntaxTransformationObjectExprTypeDoFirst(that);
        recurOnListOfBaseType(that.getExtended());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationObjectExprTypeOnly(that);
    }

    public void for_SyntaxTransformationNamedType(_SyntaxTransformationNamedType that) {
        for_SyntaxTransformationNamedTypeDoFirst(that);
        recurOnId(that.getName());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationNamedTypeOnly(that);
    }

    public void for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that) {
        for_SyntaxTransformation_InferenceVarTypeDoFirst(that);
        recurOnId(that.getName());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformation_InferenceVarTypeOnly(that);
    }

    public void for_SyntaxTransformationVarType(_SyntaxTransformationVarType that) {
        for_SyntaxTransformationVarTypeDoFirst(that);
        recurOnId(that.getName());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationVarTypeOnly(that);
    }

    public void for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that) {
        for_SyntaxTransformationTraitTypeDoFirst(that);
        recurOnId(that.getName());
        recurOnListOfStaticArg(that.getArgs());
        recurOnListOfStaticParam(that.getTraitStaticParams());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationTraitTypeOnly(that);
    }

    public void for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that) {
        for_SyntaxTransformationAbbreviatedTypeDoFirst(that);
        recur(that.getElemType());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationAbbreviatedTypeOnly(that);
    }

    public void for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that) {
        for_SyntaxTransformationArrayTypeDoFirst(that);
        recur(that.getElemType());
        recurOnIndices(that.getIndices());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationArrayTypeOnly(that);
    }

    public void for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that) {
        for_SyntaxTransformationMatrixTypeDoFirst(that);
        recur(that.getElemType());
        recurOnListOfExtentRange(that.getDimensions());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationMatrixTypeOnly(that);
    }

    public void for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that) {
        for_SyntaxTransformationTaggedDimTypeDoFirst(that);
        recur(that.getElemType());
        recur(that.getDimExpr());
        recurOnOptionOfExpr(that.getUnitExpr());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationTaggedDimTypeOnly(that);
    }

    public void for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that) {
        for_SyntaxTransformationTaggedUnitTypeDoFirst(that);
        recur(that.getElemType());
        recurOnExpr(that.getUnitExpr());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationTaggedUnitTypeOnly(that);
    }

    public void for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that) {
        for_SyntaxTransformationTupleTypeDoFirst(that);
        recurOnListOfType(that.getElements());
        recurOnOptionOfType(that.getVarargs());
        recurOnListOfKeywordType(that.getKeywords());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationTupleTypeOnly(that);
    }

    public void for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that) {
        for_SyntaxTransformationArrowTypeDoFirst(that);
        recur(that.getDomain());
        recur(that.getRange());
        recurOnEffect(that.getEffect());
        recurOnOptionOfMethodInfo(that.getMethodInfo());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationArrowTypeOnly(that);
    }

    public void for_SyntaxTransformationBoundType(_SyntaxTransformationBoundType that) {
        for_SyntaxTransformationBoundTypeDoFirst(that);
        recurOnListOfType(that.getElements());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationBoundTypeOnly(that);
    }

    public void for_SyntaxTransformationIntersectionType(_SyntaxTransformationIntersectionType that) {
        for_SyntaxTransformationIntersectionTypeDoFirst(that);
        recurOnListOfType(that.getElements());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationIntersectionTypeOnly(that);
    }

    public void for_SyntaxTransformationUnionType(_SyntaxTransformationUnionType that) {
        for_SyntaxTransformationUnionTypeDoFirst(that);
        recurOnListOfType(that.getElements());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationUnionTypeOnly(that);
    }

    public void for_SyntaxTransformationFixedPointType(_SyntaxTransformationFixedPointType that) {
        for_SyntaxTransformationFixedPointTypeDoFirst(that);
        recur(that.getName());
        recur(that.getBody());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationFixedPointTypeOnly(that);
    }

    public void for_SyntaxTransformationLabelType(_SyntaxTransformationLabelType that) {
        for_SyntaxTransformationLabelTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationLabelTypeOnly(that);
    }

    public void for_SyntaxTransformationDimExpr(_SyntaxTransformationDimExpr that) {
        for_SyntaxTransformationDimExprDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationDimExprOnly(that);
    }

    public void for_SyntaxTransformationDimBase(_SyntaxTransformationDimBase that) {
        for_SyntaxTransformationDimBaseDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationDimBaseOnly(that);
    }

    public void for_SyntaxTransformationDimRef(_SyntaxTransformationDimRef that) {
        for_SyntaxTransformationDimRefDoFirst(that);
        recurOnId(that.getName());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationDimRefOnly(that);
    }

    public void for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that) {
        for_SyntaxTransformationDimExponentDoFirst(that);
        recur(that.getBase());
        recurOnIntExpr(that.getPower());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationDimExponentOnly(that);
    }

    public void for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that) {
        for_SyntaxTransformationDimUnaryOpDoFirst(that);
        recur(that.getDimVal());
        recurOnOp(that.getOp());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationDimUnaryOpOnly(that);
    }

    public void for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that) {
        for_SyntaxTransformationDimBinaryOpDoFirst(that);
        recur(that.getLeft());
        recur(that.getRight());
        recurOnOp(that.getOp());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationDimBinaryOpOnly(that);
    }

    public void for_EllipsesType(_EllipsesType that) {
        for_EllipsesTypeDoFirst(that);
        for_EllipsesTypeOnly(that);
    }

    public void for_EllipsesBaseType(_EllipsesBaseType that) {
        for_EllipsesBaseTypeDoFirst(that);
        for_EllipsesBaseTypeOnly(that);
    }

    public void for_EllipsesAnyType(_EllipsesAnyType that) {
        for_EllipsesAnyTypeDoFirst(that);
        for_EllipsesAnyTypeOnly(that);
    }

    public void for_EllipsesBottomType(_EllipsesBottomType that) {
        for_EllipsesBottomTypeDoFirst(that);
        for_EllipsesBottomTypeOnly(that);
    }

    public void for_EllipsesUnknownType(_EllipsesUnknownType that) {
        for_EllipsesUnknownTypeDoFirst(that);
        for_EllipsesUnknownTypeOnly(that);
    }

    public void for_EllipsesSelfType(_EllipsesSelfType that) {
        for_EllipsesSelfTypeDoFirst(that);
        for_EllipsesSelfTypeOnly(that);
    }

    public void for_EllipsesTraitSelfType(_EllipsesTraitSelfType that) {
        for_EllipsesTraitSelfTypeDoFirst(that);
        for_EllipsesTraitSelfTypeOnly(that);
    }

    public void for_EllipsesObjectExprType(_EllipsesObjectExprType that) {
        for_EllipsesObjectExprTypeDoFirst(that);
        for_EllipsesObjectExprTypeOnly(that);
    }

    public void for_EllipsesNamedType(_EllipsesNamedType that) {
        for_EllipsesNamedTypeDoFirst(that);
        for_EllipsesNamedTypeOnly(that);
    }

    public void for_Ellipses_InferenceVarType(_Ellipses_InferenceVarType that) {
        for_Ellipses_InferenceVarTypeDoFirst(that);
        for_Ellipses_InferenceVarTypeOnly(that);
    }

    public void for_EllipsesVarType(_EllipsesVarType that) {
        for_EllipsesVarTypeDoFirst(that);
        for_EllipsesVarTypeOnly(that);
    }

    public void for_EllipsesTraitType(_EllipsesTraitType that) {
        for_EllipsesTraitTypeDoFirst(that);
        for_EllipsesTraitTypeOnly(that);
    }

    public void for_EllipsesAbbreviatedType(_EllipsesAbbreviatedType that) {
        for_EllipsesAbbreviatedTypeDoFirst(that);
        for_EllipsesAbbreviatedTypeOnly(that);
    }

    public void for_EllipsesArrayType(_EllipsesArrayType that) {
        for_EllipsesArrayTypeDoFirst(that);
        for_EllipsesArrayTypeOnly(that);
    }

    public void for_EllipsesMatrixType(_EllipsesMatrixType that) {
        for_EllipsesMatrixTypeDoFirst(that);
        for_EllipsesMatrixTypeOnly(that);
    }

    public void for_EllipsesTaggedDimType(_EllipsesTaggedDimType that) {
        for_EllipsesTaggedDimTypeDoFirst(that);
        for_EllipsesTaggedDimTypeOnly(that);
    }

    public void for_EllipsesTaggedUnitType(_EllipsesTaggedUnitType that) {
        for_EllipsesTaggedUnitTypeDoFirst(that);
        for_EllipsesTaggedUnitTypeOnly(that);
    }

    public void for_EllipsesTupleType(_EllipsesTupleType that) {
        for_EllipsesTupleTypeDoFirst(that);
        for_EllipsesTupleTypeOnly(that);
    }

    public void for_EllipsesArrowType(_EllipsesArrowType that) {
        for_EllipsesArrowTypeDoFirst(that);
        for_EllipsesArrowTypeOnly(that);
    }

    public void for_EllipsesBoundType(_EllipsesBoundType that) {
        for_EllipsesBoundTypeDoFirst(that);
        for_EllipsesBoundTypeOnly(that);
    }

    public void for_EllipsesIntersectionType(_EllipsesIntersectionType that) {
        for_EllipsesIntersectionTypeDoFirst(that);
        for_EllipsesIntersectionTypeOnly(that);
    }

    public void for_EllipsesUnionType(_EllipsesUnionType that) {
        for_EllipsesUnionTypeDoFirst(that);
        for_EllipsesUnionTypeOnly(that);
    }

    public void for_EllipsesFixedPointType(_EllipsesFixedPointType that) {
        for_EllipsesFixedPointTypeDoFirst(that);
        for_EllipsesFixedPointTypeOnly(that);
    }

    public void for_EllipsesLabelType(_EllipsesLabelType that) {
        for_EllipsesLabelTypeDoFirst(that);
        for_EllipsesLabelTypeOnly(that);
    }

    public void for_EllipsesDimExpr(_EllipsesDimExpr that) {
        for_EllipsesDimExprDoFirst(that);
        for_EllipsesDimExprOnly(that);
    }

    public void for_EllipsesDimBase(_EllipsesDimBase that) {
        for_EllipsesDimBaseDoFirst(that);
        for_EllipsesDimBaseOnly(that);
    }

    public void for_EllipsesDimRef(_EllipsesDimRef that) {
        for_EllipsesDimRefDoFirst(that);
        for_EllipsesDimRefOnly(that);
    }

    public void for_EllipsesDimExponent(_EllipsesDimExponent that) {
        for_EllipsesDimExponentDoFirst(that);
        for_EllipsesDimExponentOnly(that);
    }

    public void for_EllipsesDimUnaryOp(_EllipsesDimUnaryOp that) {
        for_EllipsesDimUnaryOpDoFirst(that);
        for_EllipsesDimUnaryOpOnly(that);
    }

    public void for_EllipsesDimBinaryOp(_EllipsesDimBinaryOp that) {
        for_EllipsesDimBinaryOpDoFirst(that);
        for_EllipsesDimBinaryOpOnly(that);
    }

    public void forTemplateGapType(TemplateGapType that) {
        forTemplateGapTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapTypeOnly(that);
    }

    public void forTemplateGapBaseType(TemplateGapBaseType that) {
        forTemplateGapBaseTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapBaseTypeOnly(that);
    }

    public void forTemplateGapAnyType(TemplateGapAnyType that) {
        forTemplateGapAnyTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapAnyTypeOnly(that);
    }

    public void forTemplateGapBottomType(TemplateGapBottomType that) {
        forTemplateGapBottomTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapBottomTypeOnly(that);
    }

    public void forTemplateGapUnknownType(TemplateGapUnknownType that) {
        forTemplateGapUnknownTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapUnknownTypeOnly(that);
    }

    public void forTemplateGapSelfType(TemplateGapSelfType that) {
        forTemplateGapSelfTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapSelfTypeOnly(that);
    }

    public void forTemplateGapTraitSelfType(TemplateGapTraitSelfType that) {
        forTemplateGapTraitSelfTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapTraitSelfTypeOnly(that);
    }

    public void forTemplateGapObjectExprType(TemplateGapObjectExprType that) {
        forTemplateGapObjectExprTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapObjectExprTypeOnly(that);
    }

    public void forTemplateGapNamedType(TemplateGapNamedType that) {
        forTemplateGapNamedTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapNamedTypeOnly(that);
    }

    public void forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that) {
        forTemplateGap_InferenceVarTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGap_InferenceVarTypeOnly(that);
    }

    public void forTemplateGapVarType(TemplateGapVarType that) {
        forTemplateGapVarTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapVarTypeOnly(that);
    }

    public void forTemplateGapTraitType(TemplateGapTraitType that) {
        forTemplateGapTraitTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapTraitTypeOnly(that);
    }

    public void forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that) {
        forTemplateGapAbbreviatedTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapAbbreviatedTypeOnly(that);
    }

    public void forTemplateGapArrayType(TemplateGapArrayType that) {
        forTemplateGapArrayTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapArrayTypeOnly(that);
    }

    public void forTemplateGapMatrixType(TemplateGapMatrixType that) {
        forTemplateGapMatrixTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapMatrixTypeOnly(that);
    }

    public void forTemplateGapTaggedDimType(TemplateGapTaggedDimType that) {
        forTemplateGapTaggedDimTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapTaggedDimTypeOnly(that);
    }

    public void forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that) {
        forTemplateGapTaggedUnitTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapTaggedUnitTypeOnly(that);
    }

    public void forTemplateGapTupleType(TemplateGapTupleType that) {
        forTemplateGapTupleTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapTupleTypeOnly(that);
    }

    public void forTemplateGapArrowType(TemplateGapArrowType that) {
        forTemplateGapArrowTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapArrowTypeOnly(that);
    }

    public void forTemplateGapBoundType(TemplateGapBoundType that) {
        forTemplateGapBoundTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapBoundTypeOnly(that);
    }

    public void forTemplateGapIntersectionType(TemplateGapIntersectionType that) {
        forTemplateGapIntersectionTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapIntersectionTypeOnly(that);
    }

    public void forTemplateGapUnionType(TemplateGapUnionType that) {
        forTemplateGapUnionTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapUnionTypeOnly(that);
    }

    public void forTemplateGapFixedPointType(TemplateGapFixedPointType that) {
        forTemplateGapFixedPointTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapFixedPointTypeOnly(that);
    }

    public void forTemplateGapLabelType(TemplateGapLabelType that) {
        forTemplateGapLabelTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapLabelTypeOnly(that);
    }

    public void forTemplateGapDimExpr(TemplateGapDimExpr that) {
        forTemplateGapDimExprDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapDimExprOnly(that);
    }

    public void forTemplateGapDimBase(TemplateGapDimBase that) {
        forTemplateGapDimBaseDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapDimBaseOnly(that);
    }

    public void forTemplateGapDimRef(TemplateGapDimRef that) {
        forTemplateGapDimRefDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapDimRefOnly(that);
    }

    public void forTemplateGapDimExponent(TemplateGapDimExponent that) {
        forTemplateGapDimExponentDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapDimExponentOnly(that);
    }

    public void forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that) {
        forTemplateGapDimUnaryOpDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapDimUnaryOpOnly(that);
    }

    public void forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that) {
        forTemplateGapDimBinaryOpDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapDimBinaryOpOnly(that);
    }


    public void recur(Type that) {
        that.accept(this);
    }

    public void recurOnTypeInfo(TypeInfo that) {
    }

    public void recurOnListOfNamedType(List<NamedType> that) {
        for (NamedType elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfBaseType(List<BaseType> that) {
        for (BaseType elt : that) {
            recur(elt);
        }
    }

    public void recurOnId(Id that) {
    }

    public void recurOnStaticArg(StaticArg that) {
    }

    public void recurOnListOfStaticArg(List<StaticArg> that) {
        for (StaticArg elt : that) {
            recurOnStaticArg(elt);
        }
    }

    public void recurOnStaticParam(StaticParam that) {
    }

    public void recurOnListOfStaticParam(List<StaticParam> that) {
        for (StaticParam elt : that) {
            recurOnStaticParam(elt);
        }
    }

    public void recurOnIndices(Indices that) {
    }

    public void recurOnExtentRange(ExtentRange that) {
    }

    public void recurOnListOfExtentRange(List<ExtentRange> that) {
        for (ExtentRange elt : that) {
            recurOnExtentRange(elt);
        }
    }

    public void recurOnExpr(Expr that) {
    }

    public void recurOnOptionOfExpr(Option<Expr> that) {
        if (!that.isNone()) recurOnExpr(that.unwrap());
    }

    public void recurOnListOfType(List<Type> that) {
        for (Type elt : that) {
            recur(elt);
        }
    }

    public void recurOnOptionOfType(Option<Type> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnKeywordType(KeywordType that) {
    }

    public void recurOnListOfKeywordType(List<KeywordType> that) {
        for (KeywordType elt : that) {
            recurOnKeywordType(elt);
        }
    }

    public void recurOnEffect(Effect that) {
    }

    public void recurOnMethodInfo(MethodInfo that) {
    }

    public void recurOnOptionOfMethodInfo(Option<MethodInfo> that) {
        if (!that.isNone()) recurOnMethodInfo(that.unwrap());
    }

    public void recurOnIntExpr(IntExpr that) {
    }

    public void recurOnOp(Op that) {
    }

    public void recurOnListOfId(List<Id> that) {
        for (Id elt : that) {
            recurOnId(elt);
        }
    }
}
