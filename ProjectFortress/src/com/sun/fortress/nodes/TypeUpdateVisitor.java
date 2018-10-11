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

/** 
 * A depth-first visitor that makes an updated copy as it visits (by default).
 * The type of the result is generally the same as that of the argument; where
 * automatic recursion on a field of type T occurs, this must be true for T.
 * Where no changes are made to a node, a new copy is not allocated.
 * This visitor implements the visitor interface with methods that 
 * first update the children, and then call forCASEOnly(), passing in 
 * the values of the updated children. (CASE is replaced by the case name.)
 * Override forCASE or forCASEOnly if you want to transform an AST subtree.
 * There is no automatic delegation to more general cases, because each concrete
 * case has a default implementation.
 */
@SuppressWarnings("unused")
public abstract class TypeUpdateVisitor extends TypeVisitorLambda<Type> {

    /* Methods to handle a node after recursion. */

    public Type forAnyTypeOnly(AnyType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new AnyType(info_result);
    }

    public Type forBottomTypeOnly(BottomType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new BottomType(info_result);
    }

    public Type forUnknownTypeOnly(UnknownType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new UnknownType(info_result);
    }

    public Type forTraitSelfTypeOnly(TraitSelfType that, TypeInfo info_result, BaseType named_result, List<NamedType> comprised_result) {
        if (that.getInfo() == info_result && that.getNamed() == named_result && that.getComprised() == comprised_result) return that;
        else return new TraitSelfType(info_result, named_result, comprised_result);
    }

    public Type forObjectExprTypeOnly(ObjectExprType that, TypeInfo info_result, List<BaseType> extended_result) {
        if (that.getInfo() == info_result && that.getExtended() == extended_result) return that;
        else return new ObjectExprType(info_result, extended_result);
    }

    public Type for_InferenceVarTypeOnly(_InferenceVarType that, TypeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new _InferenceVarType(info_result, name_result, that.getId());
    }

    public Type forVarTypeOnly(VarType that, TypeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new VarType(info_result, name_result, that.getLexicalDepth());
    }

    public Type forTraitTypeOnly(TraitType that, TypeInfo info_result, Id name_result, List<StaticArg> args_result, List<StaticParam> traitStaticParams_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getArgs() == args_result && that.getTraitStaticParams() == traitStaticParams_result) return that;
        else return new TraitType(info_result, name_result, args_result, traitStaticParams_result);
    }

    public Type forArrayTypeOnly(ArrayType that, TypeInfo info_result, Type elemType_result, Indices indices_result) {
        if (that.getInfo() == info_result && that.getElemType() == elemType_result && that.getIndices() == indices_result) return that;
        else return new ArrayType(info_result, elemType_result, indices_result);
    }

    public Type forMatrixTypeOnly(MatrixType that, TypeInfo info_result, Type elemType_result, List<ExtentRange> dimensions_result) {
        if (that.getInfo() == info_result && that.getElemType() == elemType_result && that.getDimensions() == dimensions_result) return that;
        else return new MatrixType(info_result, elemType_result, dimensions_result);
    }

    public Type forTaggedDimTypeOnly(TaggedDimType that, TypeInfo info_result, Type elemType_result, DimExpr dimExpr_result, Option<Expr> unitExpr_result) {
        if (that.getInfo() == info_result && that.getElemType() == elemType_result && that.getDimExpr() == dimExpr_result && that.getUnitExpr() == unitExpr_result) return that;
        else return new TaggedDimType(info_result, elemType_result, dimExpr_result, unitExpr_result);
    }

    public Type forTaggedUnitTypeOnly(TaggedUnitType that, TypeInfo info_result, Type elemType_result, Expr unitExpr_result) {
        if (that.getInfo() == info_result && that.getElemType() == elemType_result && that.getUnitExpr() == unitExpr_result) return that;
        else return new TaggedUnitType(info_result, elemType_result, unitExpr_result);
    }

    public Type forTupleTypeOnly(TupleType that, TypeInfo info_result, List<Type> elements_result, Option<Type> varargs_result, List<KeywordType> keywords_result) {
        if (that.getInfo() == info_result && that.getElements() == elements_result && that.getVarargs() == varargs_result && that.getKeywords() == keywords_result) return that;
        else return new TupleType(info_result, elements_result, varargs_result, keywords_result);
    }

    public Type forArrowTypeOnly(ArrowType that, TypeInfo info_result, Type domain_result, Type range_result, Effect effect_result, Option<MethodInfo> methodInfo_result) {
        if (that.getInfo() == info_result && that.getDomain() == domain_result && that.getRange() == range_result && that.getEffect() == effect_result && that.getMethodInfo() == methodInfo_result) return that;
        else return new ArrowType(info_result, domain_result, range_result, effect_result, that.isIo(), methodInfo_result);
    }

    public Type forIntersectionTypeOnly(IntersectionType that, TypeInfo info_result, List<Type> elements_result) {
        if (that.getInfo() == info_result && that.getElements() == elements_result) return that;
        else return new IntersectionType(info_result, elements_result);
    }

    public Type forUnionTypeOnly(UnionType that, TypeInfo info_result, List<Type> elements_result) {
        if (that.getInfo() == info_result && that.getElements() == elements_result) return that;
        else return new UnionType(info_result, elements_result);
    }

    public Type forFixedPointTypeOnly(FixedPointType that, TypeInfo info_result, _InferenceVarType name_result, Type body_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getBody() == body_result) return that;
        else return new FixedPointType(info_result, name_result, body_result);
    }

    public Type forLabelTypeOnly(LabelType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new LabelType(info_result);
    }

    public Type forDimBaseOnly(DimBase that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new DimBase(info_result);
    }

    public Type forDimRefOnly(DimRef that, TypeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new DimRef(info_result, name_result);
    }

    public Type forDimExponentOnly(DimExponent that, TypeInfo info_result, Type base_result, IntExpr power_result) {
        if (that.getInfo() == info_result && that.getBase() == base_result && that.getPower() == power_result) return that;
        else return new DimExponent(info_result, base_result, power_result);
    }

    public Type forDimUnaryOpOnly(DimUnaryOp that, TypeInfo info_result, DimExpr dimVal_result, Op op_result) {
        if (that.getInfo() == info_result && that.getDimVal() == dimVal_result && that.getOp() == op_result) return that;
        else return new DimUnaryOp(info_result, dimVal_result, op_result);
    }

    public Type forDimBinaryOpOnly(DimBinaryOp that, TypeInfo info_result, DimExpr left_result, DimExpr right_result, Op op_result) {
        if (that.getInfo() == info_result && that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result) return that;
        else return new DimBinaryOp(info_result, left_result, right_result, op_result);
    }

    public Type for_SyntaxTransformationTypeOnly(_SyntaxTransformationType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationType(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationBaseTypeOnly(_SyntaxTransformationBaseType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBaseType(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationAnyTypeOnly(_SyntaxTransformationAnyType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAnyType(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationBottomTypeOnly(_SyntaxTransformationBottomType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBottomType(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationUnknownTypeOnly(_SyntaxTransformationUnknownType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationUnknownType(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationSelfTypeOnly(_SyntaxTransformationSelfType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationSelfType(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationTraitSelfTypeOnly(_SyntaxTransformationTraitSelfType that, BaseType named_result, List<NamedType> comprised_result, TypeInfo info_result) {
        if (that.getNamed() == named_result && that.getComprised() == comprised_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTraitSelfType(named_result, comprised_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationObjectExprTypeOnly(_SyntaxTransformationObjectExprType that, List<BaseType> extended_result, TypeInfo info_result) {
        if (that.getExtended() == extended_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationObjectExprType(extended_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationNamedTypeOnly(_SyntaxTransformationNamedType that, Id name_result, TypeInfo info_result) {
        if (that.getName() == name_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNamedType(name_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformation_InferenceVarTypeOnly(_SyntaxTransformation_InferenceVarType that, Id name_result, TypeInfo info_result) {
        if (that.getName() == name_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformation_InferenceVarType(name_result, that.getId(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationVarTypeOnly(_SyntaxTransformationVarType that, Id name_result, TypeInfo info_result) {
        if (that.getName() == name_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationVarType(name_result, that.getLexicalDepth(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationTraitTypeOnly(_SyntaxTransformationTraitType that, Id name_result, List<StaticArg> args_result, List<StaticParam> traitStaticParams_result, TypeInfo info_result) {
        if (that.getName() == name_result && that.getArgs() == args_result && that.getTraitStaticParams() == traitStaticParams_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTraitType(name_result, args_result, traitStaticParams_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationAbbreviatedTypeOnly(_SyntaxTransformationAbbreviatedType that, Type elemType_result, TypeInfo info_result) {
        if (that.getElemType() == elemType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAbbreviatedType(elemType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationArrayTypeOnly(_SyntaxTransformationArrayType that, Type elemType_result, Indices indices_result, TypeInfo info_result) {
        if (that.getElemType() == elemType_result && that.getIndices() == indices_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationArrayType(elemType_result, indices_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationMatrixTypeOnly(_SyntaxTransformationMatrixType that, Type elemType_result, List<ExtentRange> dimensions_result, TypeInfo info_result) {
        if (that.getElemType() == elemType_result && that.getDimensions() == dimensions_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationMatrixType(elemType_result, dimensions_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationTaggedDimTypeOnly(_SyntaxTransformationTaggedDimType that, Type elemType_result, DimExpr dimExpr_result, Option<Expr> unitExpr_result, TypeInfo info_result) {
        if (that.getElemType() == elemType_result && that.getDimExpr() == dimExpr_result && that.getUnitExpr() == unitExpr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTaggedDimType(elemType_result, dimExpr_result, unitExpr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationTaggedUnitTypeOnly(_SyntaxTransformationTaggedUnitType that, Type elemType_result, Expr unitExpr_result, TypeInfo info_result) {
        if (that.getElemType() == elemType_result && that.getUnitExpr() == unitExpr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTaggedUnitType(elemType_result, unitExpr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationTupleTypeOnly(_SyntaxTransformationTupleType that, List<Type> elements_result, Option<Type> varargs_result, List<KeywordType> keywords_result, TypeInfo info_result) {
        if (that.getElements() == elements_result && that.getVarargs() == varargs_result && that.getKeywords() == keywords_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTupleType(elements_result, varargs_result, keywords_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationArrowTypeOnly(_SyntaxTransformationArrowType that, Type domain_result, Type range_result, Effect effect_result, Option<MethodInfo> methodInfo_result, TypeInfo info_result) {
        if (that.getDomain() == domain_result && that.getRange() == range_result && that.getEffect() == effect_result && that.getMethodInfo() == methodInfo_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationArrowType(domain_result, range_result, effect_result, that.isIo(), methodInfo_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationBoundTypeOnly(_SyntaxTransformationBoundType that, List<Type> elements_result, TypeInfo info_result) {
        if (that.getElements() == elements_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBoundType(elements_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationIntersectionTypeOnly(_SyntaxTransformationIntersectionType that, List<Type> elements_result, TypeInfo info_result) {
        if (that.getElements() == elements_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIntersectionType(elements_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationUnionTypeOnly(_SyntaxTransformationUnionType that, List<Type> elements_result, TypeInfo info_result) {
        if (that.getElements() == elements_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationUnionType(elements_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationFixedPointTypeOnly(_SyntaxTransformationFixedPointType that, _InferenceVarType name_result, Type body_result, TypeInfo info_result) {
        if (that.getName() == name_result && that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationFixedPointType(name_result, body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationLabelTypeOnly(_SyntaxTransformationLabelType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationLabelType(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationDimExprOnly(_SyntaxTransformationDimExpr that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDimExpr(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationDimBaseOnly(_SyntaxTransformationDimBase that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDimBase(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationDimRefOnly(_SyntaxTransformationDimRef that, Id name_result, TypeInfo info_result) {
        if (that.getName() == name_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDimRef(name_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationDimExponentOnly(_SyntaxTransformationDimExponent that, Type base_result, IntExpr power_result, TypeInfo info_result) {
        if (that.getBase() == base_result && that.getPower() == power_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDimExponent(base_result, power_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationDimUnaryOpOnly(_SyntaxTransformationDimUnaryOp that, DimExpr dimVal_result, Op op_result, TypeInfo info_result) {
        if (that.getDimVal() == dimVal_result && that.getOp() == op_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDimUnaryOp(dimVal_result, op_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_SyntaxTransformationDimBinaryOpOnly(_SyntaxTransformationDimBinaryOp that, DimExpr left_result, DimExpr right_result, Op op_result, TypeInfo info_result) {
        if (that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDimBinaryOp(left_result, right_result, op_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Type for_EllipsesTypeOnly(_EllipsesType that) {
        return that;
    }

    public Type for_EllipsesBaseTypeOnly(_EllipsesBaseType that) {
        return that;
    }

    public Type for_EllipsesAnyTypeOnly(_EllipsesAnyType that) {
        return that;
    }

    public Type for_EllipsesBottomTypeOnly(_EllipsesBottomType that) {
        return that;
    }

    public Type for_EllipsesUnknownTypeOnly(_EllipsesUnknownType that) {
        return that;
    }

    public Type for_EllipsesSelfTypeOnly(_EllipsesSelfType that) {
        return that;
    }

    public Type for_EllipsesTraitSelfTypeOnly(_EllipsesTraitSelfType that) {
        return that;
    }

    public Type for_EllipsesObjectExprTypeOnly(_EllipsesObjectExprType that) {
        return that;
    }

    public Type for_EllipsesNamedTypeOnly(_EllipsesNamedType that) {
        return that;
    }

    public Type for_Ellipses_InferenceVarTypeOnly(_Ellipses_InferenceVarType that) {
        return that;
    }

    public Type for_EllipsesVarTypeOnly(_EllipsesVarType that) {
        return that;
    }

    public Type for_EllipsesTraitTypeOnly(_EllipsesTraitType that) {
        return that;
    }

    public Type for_EllipsesAbbreviatedTypeOnly(_EllipsesAbbreviatedType that) {
        return that;
    }

    public Type for_EllipsesArrayTypeOnly(_EllipsesArrayType that) {
        return that;
    }

    public Type for_EllipsesMatrixTypeOnly(_EllipsesMatrixType that) {
        return that;
    }

    public Type for_EllipsesTaggedDimTypeOnly(_EllipsesTaggedDimType that) {
        return that;
    }

    public Type for_EllipsesTaggedUnitTypeOnly(_EllipsesTaggedUnitType that) {
        return that;
    }

    public Type for_EllipsesTupleTypeOnly(_EllipsesTupleType that) {
        return that;
    }

    public Type for_EllipsesArrowTypeOnly(_EllipsesArrowType that) {
        return that;
    }

    public Type for_EllipsesBoundTypeOnly(_EllipsesBoundType that) {
        return that;
    }

    public Type for_EllipsesIntersectionTypeOnly(_EllipsesIntersectionType that) {
        return that;
    }

    public Type for_EllipsesUnionTypeOnly(_EllipsesUnionType that) {
        return that;
    }

    public Type for_EllipsesFixedPointTypeOnly(_EllipsesFixedPointType that) {
        return that;
    }

    public Type for_EllipsesLabelTypeOnly(_EllipsesLabelType that) {
        return that;
    }

    public Type for_EllipsesDimExprOnly(_EllipsesDimExpr that) {
        return that;
    }

    public Type for_EllipsesDimBaseOnly(_EllipsesDimBase that) {
        return that;
    }

    public Type for_EllipsesDimRefOnly(_EllipsesDimRef that) {
        return that;
    }

    public Type for_EllipsesDimExponentOnly(_EllipsesDimExponent that) {
        return that;
    }

    public Type for_EllipsesDimUnaryOpOnly(_EllipsesDimUnaryOp that) {
        return that;
    }

    public Type for_EllipsesDimBinaryOpOnly(_EllipsesDimBinaryOp that) {
        return that;
    }

    public Type forTemplateGapTypeOnly(TemplateGapType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapBaseTypeOnly(TemplateGapBaseType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBaseType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapAnyTypeOnly(TemplateGapAnyType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAnyType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapBottomTypeOnly(TemplateGapBottomType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBottomType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapUnknownTypeOnly(TemplateGapUnknownType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnknownType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapSelfTypeOnly(TemplateGapSelfType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSelfType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapTraitSelfTypeOnly(TemplateGapTraitSelfType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTraitSelfType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapObjectExprTypeOnly(TemplateGapObjectExprType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapObjectExprType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapNamedTypeOnly(TemplateGapNamedType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNamedType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGap_InferenceVarTypeOnly(TemplateGap_InferenceVarType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_InferenceVarType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapVarTypeOnly(TemplateGapVarType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapVarType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapTraitTypeOnly(TemplateGapTraitType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTraitType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapAbbreviatedTypeOnly(TemplateGapAbbreviatedType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAbbreviatedType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapArrayTypeOnly(TemplateGapArrayType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapMatrixTypeOnly(TemplateGapMatrixType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapMatrixType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapTaggedDimTypeOnly(TemplateGapTaggedDimType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTaggedDimType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapTaggedUnitTypeOnly(TemplateGapTaggedUnitType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTaggedUnitType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapTupleTypeOnly(TemplateGapTupleType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTupleType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapArrowTypeOnly(TemplateGapArrowType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrowType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapBoundTypeOnly(TemplateGapBoundType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoundType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapIntersectionTypeOnly(TemplateGapIntersectionType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntersectionType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapUnionTypeOnly(TemplateGapUnionType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnionType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapFixedPointTypeOnly(TemplateGapFixedPointType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFixedPointType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapLabelTypeOnly(TemplateGapLabelType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLabelType(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapDimExprOnly(TemplateGapDimExpr that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimExpr(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapDimBaseOnly(TemplateGapDimBase that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimBase(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapDimRefOnly(TemplateGapDimRef that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimRef(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapDimExponentOnly(TemplateGapDimExponent that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimExponent(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapDimUnaryOpOnly(TemplateGapDimUnaryOp that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimUnaryOp(info_result, gapId_result, templateParams_result);
    }

    public Type forTemplateGapDimBinaryOpOnly(TemplateGapDimBinaryOp that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimBinaryOp(info_result, gapId_result, templateParams_result);
    }

    /** Methods to recur on each child. */

    public Type forAnyType(AnyType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return forAnyTypeOnly(that, info_result);
    }


    public Type forBottomType(BottomType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return forBottomTypeOnly(that, info_result);
    }


    public Type forUnknownType(UnknownType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return forUnknownTypeOnly(that, info_result);
    }


    public Type forTraitSelfType(TraitSelfType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        BaseType named_result = (BaseType) recur(that.getNamed());
        List<NamedType> comprised_result = recurOnListOfNamedType(that.getComprised());
        return forTraitSelfTypeOnly(that, info_result, named_result, comprised_result);
    }


    public Type forObjectExprType(ObjectExprType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        List<BaseType> extended_result = recurOnListOfBaseType(that.getExtended());
        return forObjectExprTypeOnly(that, info_result, extended_result);
    }


    public Type for_InferenceVarType(_InferenceVarType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id name_result = recurOnId(that.getName());
        return for_InferenceVarTypeOnly(that, info_result, name_result);
    }


    public Type forVarType(VarType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id name_result = recurOnId(that.getName());
        return forVarTypeOnly(that, info_result, name_result);
    }


    public Type forTraitType(TraitType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id name_result = recurOnId(that.getName());
        List<StaticArg> args_result = recurOnListOfStaticArg(that.getArgs());
        List<StaticParam> traitStaticParams_result = recurOnListOfStaticParam(that.getTraitStaticParams());
        return forTraitTypeOnly(that, info_result, name_result, args_result, traitStaticParams_result);
    }


    public Type forArrayType(ArrayType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Type elemType_result = recur(that.getElemType());
        Indices indices_result = recurOnIndices(that.getIndices());
        return forArrayTypeOnly(that, info_result, elemType_result, indices_result);
    }


    public Type forMatrixType(MatrixType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Type elemType_result = recur(that.getElemType());
        List<ExtentRange> dimensions_result = recurOnListOfExtentRange(that.getDimensions());
        return forMatrixTypeOnly(that, info_result, elemType_result, dimensions_result);
    }


    public Type forTaggedDimType(TaggedDimType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Type elemType_result = recur(that.getElemType());
        DimExpr dimExpr_result = (DimExpr) recur(that.getDimExpr());
        Option<Expr> unitExpr_result = recurOnOptionOfExpr(that.getUnitExpr());
        return forTaggedDimTypeOnly(that, info_result, elemType_result, dimExpr_result, unitExpr_result);
    }


    public Type forTaggedUnitType(TaggedUnitType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Type elemType_result = recur(that.getElemType());
        Expr unitExpr_result = recurOnExpr(that.getUnitExpr());
        return forTaggedUnitTypeOnly(that, info_result, elemType_result, unitExpr_result);
    }


    public Type forTupleType(TupleType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        List<Type> elements_result = recurOnListOfType(that.getElements());
        Option<Type> varargs_result = recurOnOptionOfType(that.getVarargs());
        List<KeywordType> keywords_result = recurOnListOfKeywordType(that.getKeywords());
        return forTupleTypeOnly(that, info_result, elements_result, varargs_result, keywords_result);
    }


    public Type forArrowType(ArrowType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Type domain_result = recur(that.getDomain());
        Type range_result = recur(that.getRange());
        Effect effect_result = recurOnEffect(that.getEffect());
        Option<MethodInfo> methodInfo_result = recurOnOptionOfMethodInfo(that.getMethodInfo());
        return forArrowTypeOnly(that, info_result, domain_result, range_result, effect_result, methodInfo_result);
    }


    public Type forIntersectionType(IntersectionType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        List<Type> elements_result = recurOnListOfType(that.getElements());
        return forIntersectionTypeOnly(that, info_result, elements_result);
    }


    public Type forUnionType(UnionType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        List<Type> elements_result = recurOnListOfType(that.getElements());
        return forUnionTypeOnly(that, info_result, elements_result);
    }


    public Type forFixedPointType(FixedPointType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        _InferenceVarType name_result = (_InferenceVarType) recur(that.getName());
        Type body_result = recur(that.getBody());
        return forFixedPointTypeOnly(that, info_result, name_result, body_result);
    }


    public Type forLabelType(LabelType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return forLabelTypeOnly(that, info_result);
    }


    public Type forDimBase(DimBase that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return forDimBaseOnly(that, info_result);
    }


    public Type forDimRef(DimRef that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id name_result = recurOnId(that.getName());
        return forDimRefOnly(that, info_result, name_result);
    }


    public Type forDimExponent(DimExponent that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Type base_result = recur(that.getBase());
        IntExpr power_result = recurOnIntExpr(that.getPower());
        return forDimExponentOnly(that, info_result, base_result, power_result);
    }


    public Type forDimUnaryOp(DimUnaryOp that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        DimExpr dimVal_result = (DimExpr) recur(that.getDimVal());
        Op op_result = recurOnOp(that.getOp());
        return forDimUnaryOpOnly(that, info_result, dimVal_result, op_result);
    }


    public Type forDimBinaryOp(DimBinaryOp that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        DimExpr left_result = (DimExpr) recur(that.getLeft());
        DimExpr right_result = (DimExpr) recur(that.getRight());
        Op op_result = recurOnOp(that.getOp());
        return forDimBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }


    public Type for_SyntaxTransformationType(_SyntaxTransformationType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationTypeOnly(that, info_result);
    }


    public Type for_SyntaxTransformationBaseType(_SyntaxTransformationBaseType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationBaseTypeOnly(that, info_result);
    }


    public Type for_SyntaxTransformationAnyType(_SyntaxTransformationAnyType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationAnyTypeOnly(that, info_result);
    }


    public Type for_SyntaxTransformationBottomType(_SyntaxTransformationBottomType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationBottomTypeOnly(that, info_result);
    }


    public Type for_SyntaxTransformationUnknownType(_SyntaxTransformationUnknownType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationUnknownTypeOnly(that, info_result);
    }


    public Type for_SyntaxTransformationSelfType(_SyntaxTransformationSelfType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationSelfTypeOnly(that, info_result);
    }


    public Type for_SyntaxTransformationTraitSelfType(_SyntaxTransformationTraitSelfType that) {
        BaseType named_result = (BaseType) recur(that.getNamed());
        List<NamedType> comprised_result = recurOnListOfNamedType(that.getComprised());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationTraitSelfTypeOnly(that, named_result, comprised_result, info_result);
    }


    public Type for_SyntaxTransformationObjectExprType(_SyntaxTransformationObjectExprType that) {
        List<BaseType> extended_result = recurOnListOfBaseType(that.getExtended());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationObjectExprTypeOnly(that, extended_result, info_result);
    }


    public Type for_SyntaxTransformationNamedType(_SyntaxTransformationNamedType that) {
        Id name_result = recurOnId(that.getName());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationNamedTypeOnly(that, name_result, info_result);
    }


    public Type for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that) {
        Id name_result = recurOnId(that.getName());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformation_InferenceVarTypeOnly(that, name_result, info_result);
    }


    public Type for_SyntaxTransformationVarType(_SyntaxTransformationVarType that) {
        Id name_result = recurOnId(that.getName());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationVarTypeOnly(that, name_result, info_result);
    }


    public Type for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that) {
        Id name_result = recurOnId(that.getName());
        List<StaticArg> args_result = recurOnListOfStaticArg(that.getArgs());
        List<StaticParam> traitStaticParams_result = recurOnListOfStaticParam(that.getTraitStaticParams());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationTraitTypeOnly(that, name_result, args_result, traitStaticParams_result, info_result);
    }


    public Type for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that) {
        Type elemType_result = recur(that.getElemType());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationAbbreviatedTypeOnly(that, elemType_result, info_result);
    }


    public Type for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that) {
        Type elemType_result = recur(that.getElemType());
        Indices indices_result = recurOnIndices(that.getIndices());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationArrayTypeOnly(that, elemType_result, indices_result, info_result);
    }


    public Type for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that) {
        Type elemType_result = recur(that.getElemType());
        List<ExtentRange> dimensions_result = recurOnListOfExtentRange(that.getDimensions());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationMatrixTypeOnly(that, elemType_result, dimensions_result, info_result);
    }


    public Type for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that) {
        Type elemType_result = recur(that.getElemType());
        DimExpr dimExpr_result = (DimExpr) recur(that.getDimExpr());
        Option<Expr> unitExpr_result = recurOnOptionOfExpr(that.getUnitExpr());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationTaggedDimTypeOnly(that, elemType_result, dimExpr_result, unitExpr_result, info_result);
    }


    public Type for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that) {
        Type elemType_result = recur(that.getElemType());
        Expr unitExpr_result = recurOnExpr(that.getUnitExpr());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationTaggedUnitTypeOnly(that, elemType_result, unitExpr_result, info_result);
    }


    public Type for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that) {
        List<Type> elements_result = recurOnListOfType(that.getElements());
        Option<Type> varargs_result = recurOnOptionOfType(that.getVarargs());
        List<KeywordType> keywords_result = recurOnListOfKeywordType(that.getKeywords());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationTupleTypeOnly(that, elements_result, varargs_result, keywords_result, info_result);
    }


    public Type for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that) {
        Type domain_result = recur(that.getDomain());
        Type range_result = recur(that.getRange());
        Effect effect_result = recurOnEffect(that.getEffect());
        Option<MethodInfo> methodInfo_result = recurOnOptionOfMethodInfo(that.getMethodInfo());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationArrowTypeOnly(that, domain_result, range_result, effect_result, methodInfo_result, info_result);
    }


    public Type for_SyntaxTransformationBoundType(_SyntaxTransformationBoundType that) {
        List<Type> elements_result = recurOnListOfType(that.getElements());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationBoundTypeOnly(that, elements_result, info_result);
    }


    public Type for_SyntaxTransformationIntersectionType(_SyntaxTransformationIntersectionType that) {
        List<Type> elements_result = recurOnListOfType(that.getElements());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationIntersectionTypeOnly(that, elements_result, info_result);
    }


    public Type for_SyntaxTransformationUnionType(_SyntaxTransformationUnionType that) {
        List<Type> elements_result = recurOnListOfType(that.getElements());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationUnionTypeOnly(that, elements_result, info_result);
    }


    public Type for_SyntaxTransformationFixedPointType(_SyntaxTransformationFixedPointType that) {
        _InferenceVarType name_result = (_InferenceVarType) recur(that.getName());
        Type body_result = recur(that.getBody());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationFixedPointTypeOnly(that, name_result, body_result, info_result);
    }


    public Type for_SyntaxTransformationLabelType(_SyntaxTransformationLabelType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationLabelTypeOnly(that, info_result);
    }


    public Type for_SyntaxTransformationDimExpr(_SyntaxTransformationDimExpr that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationDimExprOnly(that, info_result);
    }


    public Type for_SyntaxTransformationDimBase(_SyntaxTransformationDimBase that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationDimBaseOnly(that, info_result);
    }


    public Type for_SyntaxTransformationDimRef(_SyntaxTransformationDimRef that) {
        Id name_result = recurOnId(that.getName());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationDimRefOnly(that, name_result, info_result);
    }


    public Type for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that) {
        Type base_result = recur(that.getBase());
        IntExpr power_result = recurOnIntExpr(that.getPower());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationDimExponentOnly(that, base_result, power_result, info_result);
    }


    public Type for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that) {
        DimExpr dimVal_result = (DimExpr) recur(that.getDimVal());
        Op op_result = recurOnOp(that.getOp());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationDimUnaryOpOnly(that, dimVal_result, op_result, info_result);
    }


    public Type for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that) {
        DimExpr left_result = (DimExpr) recur(that.getLeft());
        DimExpr right_result = (DimExpr) recur(that.getRight());
        Op op_result = recurOnOp(that.getOp());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationDimBinaryOpOnly(that, left_result, right_result, op_result, info_result);
    }


    public Type for_EllipsesType(_EllipsesType that) {
        return for_EllipsesTypeOnly(that);
    }


    public Type for_EllipsesBaseType(_EllipsesBaseType that) {
        return for_EllipsesBaseTypeOnly(that);
    }


    public Type for_EllipsesAnyType(_EllipsesAnyType that) {
        return for_EllipsesAnyTypeOnly(that);
    }


    public Type for_EllipsesBottomType(_EllipsesBottomType that) {
        return for_EllipsesBottomTypeOnly(that);
    }


    public Type for_EllipsesUnknownType(_EllipsesUnknownType that) {
        return for_EllipsesUnknownTypeOnly(that);
    }


    public Type for_EllipsesSelfType(_EllipsesSelfType that) {
        return for_EllipsesSelfTypeOnly(that);
    }


    public Type for_EllipsesTraitSelfType(_EllipsesTraitSelfType that) {
        return for_EllipsesTraitSelfTypeOnly(that);
    }


    public Type for_EllipsesObjectExprType(_EllipsesObjectExprType that) {
        return for_EllipsesObjectExprTypeOnly(that);
    }


    public Type for_EllipsesNamedType(_EllipsesNamedType that) {
        return for_EllipsesNamedTypeOnly(that);
    }


    public Type for_Ellipses_InferenceVarType(_Ellipses_InferenceVarType that) {
        return for_Ellipses_InferenceVarTypeOnly(that);
    }


    public Type for_EllipsesVarType(_EllipsesVarType that) {
        return for_EllipsesVarTypeOnly(that);
    }


    public Type for_EllipsesTraitType(_EllipsesTraitType that) {
        return for_EllipsesTraitTypeOnly(that);
    }


    public Type for_EllipsesAbbreviatedType(_EllipsesAbbreviatedType that) {
        return for_EllipsesAbbreviatedTypeOnly(that);
    }


    public Type for_EllipsesArrayType(_EllipsesArrayType that) {
        return for_EllipsesArrayTypeOnly(that);
    }


    public Type for_EllipsesMatrixType(_EllipsesMatrixType that) {
        return for_EllipsesMatrixTypeOnly(that);
    }


    public Type for_EllipsesTaggedDimType(_EllipsesTaggedDimType that) {
        return for_EllipsesTaggedDimTypeOnly(that);
    }


    public Type for_EllipsesTaggedUnitType(_EllipsesTaggedUnitType that) {
        return for_EllipsesTaggedUnitTypeOnly(that);
    }


    public Type for_EllipsesTupleType(_EllipsesTupleType that) {
        return for_EllipsesTupleTypeOnly(that);
    }


    public Type for_EllipsesArrowType(_EllipsesArrowType that) {
        return for_EllipsesArrowTypeOnly(that);
    }


    public Type for_EllipsesBoundType(_EllipsesBoundType that) {
        return for_EllipsesBoundTypeOnly(that);
    }


    public Type for_EllipsesIntersectionType(_EllipsesIntersectionType that) {
        return for_EllipsesIntersectionTypeOnly(that);
    }


    public Type for_EllipsesUnionType(_EllipsesUnionType that) {
        return for_EllipsesUnionTypeOnly(that);
    }


    public Type for_EllipsesFixedPointType(_EllipsesFixedPointType that) {
        return for_EllipsesFixedPointTypeOnly(that);
    }


    public Type for_EllipsesLabelType(_EllipsesLabelType that) {
        return for_EllipsesLabelTypeOnly(that);
    }


    public Type for_EllipsesDimExpr(_EllipsesDimExpr that) {
        return for_EllipsesDimExprOnly(that);
    }


    public Type for_EllipsesDimBase(_EllipsesDimBase that) {
        return for_EllipsesDimBaseOnly(that);
    }


    public Type for_EllipsesDimRef(_EllipsesDimRef that) {
        return for_EllipsesDimRefOnly(that);
    }


    public Type for_EllipsesDimExponent(_EllipsesDimExponent that) {
        return for_EllipsesDimExponentOnly(that);
    }


    public Type for_EllipsesDimUnaryOp(_EllipsesDimUnaryOp that) {
        return for_EllipsesDimUnaryOpOnly(that);
    }


    public Type for_EllipsesDimBinaryOp(_EllipsesDimBinaryOp that) {
        return for_EllipsesDimBinaryOpOnly(that);
    }


    public Type forTemplateGapType(TemplateGapType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapBaseType(TemplateGapBaseType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBaseTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapAnyType(TemplateGapAnyType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAnyTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapBottomType(TemplateGapBottomType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBottomTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapUnknownType(TemplateGapUnknownType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnknownTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapSelfType(TemplateGapSelfType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSelfTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapTraitSelfType(TemplateGapTraitSelfType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTraitSelfTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapObjectExprType(TemplateGapObjectExprType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapObjectExprTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapNamedType(TemplateGapNamedType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNamedTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_InferenceVarTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapVarType(TemplateGapVarType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapVarTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapTraitType(TemplateGapTraitType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTraitTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAbbreviatedTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapArrayType(TemplateGapArrayType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapMatrixType(TemplateGapMatrixType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapMatrixTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapTaggedDimType(TemplateGapTaggedDimType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTaggedDimTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTaggedUnitTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapTupleType(TemplateGapTupleType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTupleTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapArrowType(TemplateGapArrowType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrowTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapBoundType(TemplateGapBoundType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoundTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapIntersectionType(TemplateGapIntersectionType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntersectionTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapUnionType(TemplateGapUnionType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnionTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapFixedPointType(TemplateGapFixedPointType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFixedPointTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapLabelType(TemplateGapLabelType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLabelTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapDimExpr(TemplateGapDimExpr that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapDimBase(TemplateGapDimBase that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimBaseOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapDimRef(TemplateGapDimRef that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapDimExponent(TemplateGapDimExponent that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimExponentOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimUnaryOpOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimBinaryOpOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Type recur(Type that) {
        return that.accept(this);
    }

    public TypeInfo recurOnTypeInfo(TypeInfo that) {
        return that;
    }

    public List<NamedType> recurOnListOfNamedType(List<NamedType> that) {
        java.util.ArrayList<NamedType> accum = new java.util.ArrayList<NamedType>();
        boolean unchanged = true;
        for (NamedType elt : that) {
            NamedType update_elt = (NamedType) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<BaseType> recurOnListOfBaseType(List<BaseType> that) {
        java.util.ArrayList<BaseType> accum = new java.util.ArrayList<BaseType>();
        boolean unchanged = true;
        for (BaseType elt : that) {
            BaseType update_elt = (BaseType) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Id recurOnId(Id that) {
        return that;
    }

    public StaticArg recurOnStaticArg(StaticArg that) {
        return that;
    }

    public List<StaticArg> recurOnListOfStaticArg(List<StaticArg> that) {
        java.util.ArrayList<StaticArg> accum = new java.util.ArrayList<StaticArg>();
        boolean unchanged = true;
        for (StaticArg elt : that) {
            StaticArg update_elt = recurOnStaticArg(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public StaticParam recurOnStaticParam(StaticParam that) {
        return that;
    }

    public List<StaticParam> recurOnListOfStaticParam(List<StaticParam> that) {
        java.util.ArrayList<StaticParam> accum = new java.util.ArrayList<StaticParam>();
        boolean unchanged = true;
        for (StaticParam elt : that) {
            StaticParam update_elt = recurOnStaticParam(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Indices recurOnIndices(Indices that) {
        return that;
    }

    public ExtentRange recurOnExtentRange(ExtentRange that) {
        return that;
    }

    public List<ExtentRange> recurOnListOfExtentRange(List<ExtentRange> that) {
        java.util.ArrayList<ExtentRange> accum = new java.util.ArrayList<ExtentRange>();
        boolean unchanged = true;
        for (ExtentRange elt : that) {
            ExtentRange update_elt = recurOnExtentRange(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Expr recurOnExpr(Expr that) {
        return that;
    }

    public Option<Expr> recurOnOptionOfExpr(Option<Expr> that) {
        if (that.isNone()) { return that; }
        else {
            Expr original = that.unwrap();
            Expr updated = recurOnExpr(original);
            return (original == updated) ? that : Option.<Expr>some(updated);
        }
    }

    public List<Type> recurOnListOfType(List<Type> that) {
        java.util.ArrayList<Type> accum = new java.util.ArrayList<Type>();
        boolean unchanged = true;
        for (Type elt : that) {
            Type update_elt = recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<Type> recurOnOptionOfType(Option<Type> that) {
        if (that.isNone()) { return that; }
        else {
            Type original = that.unwrap();
            Type updated = recur(original);
            return (original == updated) ? that : Option.<Type>some(updated);
        }
    }

    public KeywordType recurOnKeywordType(KeywordType that) {
        return that;
    }

    public List<KeywordType> recurOnListOfKeywordType(List<KeywordType> that) {
        java.util.ArrayList<KeywordType> accum = new java.util.ArrayList<KeywordType>();
        boolean unchanged = true;
        for (KeywordType elt : that) {
            KeywordType update_elt = recurOnKeywordType(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Effect recurOnEffect(Effect that) {
        return that;
    }

    public MethodInfo recurOnMethodInfo(MethodInfo that) {
        return that;
    }

    public Option<MethodInfo> recurOnOptionOfMethodInfo(Option<MethodInfo> that) {
        if (that.isNone()) { return that; }
        else {
            MethodInfo original = that.unwrap();
            MethodInfo updated = recurOnMethodInfo(original);
            return (original == updated) ? that : Option.<MethodInfo>some(updated);
        }
    }

    public IntExpr recurOnIntExpr(IntExpr that) {
        return that;
    }

    public Op recurOnOp(Op that) {
        return that;
    }

    public List<Id> recurOnListOfId(List<Id> that) {
        java.util.ArrayList<Id> accum = new java.util.ArrayList<Id>();
        boolean unchanged = true;
        for (Id elt : that) {
            Id update_elt = recurOnId(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }
}
