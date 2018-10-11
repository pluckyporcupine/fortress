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

/** A parametric abstract implementation of a visitor over AbstractNode that returns a value.
 ** This visitor implements the visitor interface with methods that
 ** first visit children, and then call forCASEOnly(), passing in
 ** the values of the visits of the children. (CASE is replaced by the case name.)
 ** By default, each of forCASEOnly delegates to a more general case; at the
 ** top of this delegation tree is defaultCase(), which (unless overridden)
 ** throws an exception.
 **/
@SuppressWarnings({"unused", "unchecked"})
public abstract class AbstractNodeDepthFirstVisitor<RetType> extends AbstractNodeVisitorLambda<RetType> {
    private String templateErrorMessage = "Please use TemplateDepthFirstVisitor if you intend to visit template gaps, if not then a template gap survived longer than its expected life time.";
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, an exception is thrown; subclasses may override this behavior.
     * @throws IllegalArgumentException
    **/
    public RetType defaultCase(AbstractNode that) {
        throw new IllegalArgumentException("Visitor " + getClass().getName() + " does not support visiting values of type " + that.getClass().getName());
    }

    public RetType defaultTemplateGap(TemplateGap t){
        throw new RuntimeException(this.templateErrorMessage);
    }

    public RetType defaultTransformationNode(_SyntaxTransformation that){
        throw new RuntimeException("Override defaultTransformationNode to support syntax transformations");
    }

    public RetType defaultEllipsesNode(_Ellipses that){
        throw new RuntimeException("Override defaultEllipsesNode to support ellipses");
    }

    /* Methods to handle a node after recursion. */
    public RetType forAbstractNodeOnly(AbstractNode that) {
        return defaultCase(that);
    }

    public RetType forCompilationUnitOnly(CompilationUnit that, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forComponentOnly(Component that, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result, List<RetType> exports_result) {
        return forCompilationUnitOnly(that, name_result, imports_result, decls_result, comprises_result);
    }

    public RetType forApiOnly(Api that, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result) {
        return forCompilationUnitOnly(that, name_result, imports_result, decls_result, comprises_result);
    }

    public RetType forImportOnly(Import that) {
        return forAbstractNodeOnly(that);
    }

    public RetType forImportedNamesOnly(ImportedNames that, RetType apiName_result) {
        return forImportOnly(that);
    }

    public RetType forImportStarOnly(ImportStar that, RetType apiName_result, List<RetType> exceptNames_result) {
        return forImportedNamesOnly(that, apiName_result);
    }

    public RetType forImportNamesOnly(ImportNames that, RetType apiName_result, List<RetType> aliasedNames_result) {
        return forImportedNamesOnly(that, apiName_result);
    }

    public RetType forImportApiOnly(ImportApi that, List<RetType> apis_result) {
        return forImportOnly(that);
    }

    public RetType forAliasedSimpleNameOnly(AliasedSimpleName that, RetType name_result, Option<RetType> alias_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forAliasedAPINameOnly(AliasedAPIName that, RetType apiName_result, Option<RetType> alias_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forDeclOnly(Decl that) {
        return forAbstractNodeOnly(that);
    }

    public RetType forTraitObjectDeclOnly(TraitObjectDecl that, Option<RetType> selfType_result) {
        return forDeclOnly(that);
    }

    public RetType forTraitDeclOnly(TraitDecl that, Option<RetType> selfType_result, List<RetType> excludesClause_result, Option<List<RetType>> comprisesClause_result) {
        return forTraitObjectDeclOnly(that, selfType_result);
    }

    public RetType forObjectDeclOnly(ObjectDecl that, Option<RetType> selfType_result) {
        return forTraitObjectDeclOnly(that, selfType_result);
    }

    public RetType forVarDeclOnly(VarDecl that, List<RetType> lhs_result, Option<RetType> init_result) {
        return forDeclOnly(that);
    }

    public RetType forFnDeclOnly(FnDecl that, RetType unambiguousName_result, Option<RetType> body_result, Option<RetType> implementsUnambiguousName_result) {
        return forDeclOnly(that);
    }

    public RetType for_RewriteFnOverloadDeclOnly(_RewriteFnOverloadDecl that, RetType name_result, List<RetType> fns_result, Option<RetType> type_result) {
        return forDeclOnly(that);
    }

    public RetType for_RewriteObjectExprDeclOnly(_RewriteObjectExprDecl that, List<RetType> objectExprs_result) {
        return forDeclOnly(that);
    }

    public RetType for_RewriteFunctionalMethodDeclOnly(_RewriteFunctionalMethodDecl that) {
        return forDeclOnly(that);
    }

    public RetType forDimUnitDeclOnly(DimUnitDecl that) {
        return forDeclOnly(that);
    }

    public RetType forDimDeclOnly(DimDecl that, RetType dimId_result, Option<RetType> derived_result, Option<RetType> defaultId_result) {
        return forDimUnitDeclOnly(that);
    }

    public RetType forUnitDeclOnly(UnitDecl that, List<RetType> units_result, Option<RetType> dimType_result, Option<RetType> defExpr_result) {
        return forDimUnitDeclOnly(that);
    }

    public RetType forTestDeclOnly(TestDecl that, RetType name_result, List<RetType> gens_result, RetType expr_result) {
        return forDeclOnly(that);
    }

    public RetType forPropertyDeclOnly(PropertyDecl that, Option<RetType> name_result, List<RetType> params_result, RetType expr_result) {
        return forDeclOnly(that);
    }

    public RetType forTypeAliasOnly(TypeAlias that, RetType name_result, List<RetType> staticParams_result, RetType typeDef_result) {
        return forDeclOnly(that);
    }

    public RetType forGrammarDeclOnly(GrammarDecl that, RetType name_result, List<RetType> extendsClause_result, List<RetType> members_result, List<RetType> transformers_result) {
        return forDeclOnly(that);
    }

    public RetType forGrammarMemberDeclOnly(GrammarMemberDecl that, RetType name_result) {
        return forDeclOnly(that);
    }

    public RetType forNonterminalDeclOnly(NonterminalDecl that, RetType name_result, List<RetType> syntaxDecls_result) {
        return forGrammarMemberDeclOnly(that, name_result);
    }

    public RetType forNonterminalDefOnly(NonterminalDef that, RetType name_result, List<RetType> syntaxDecls_result, RetType header_result, Option<RetType> astType_result) {
        return forNonterminalDeclOnly(that, name_result, syntaxDecls_result);
    }

    public RetType forNonterminalExtensionDefOnly(NonterminalExtensionDef that, RetType name_result, List<RetType> syntaxDecls_result) {
        return forNonterminalDeclOnly(that, name_result, syntaxDecls_result);
    }

    public RetType forBindingOnly(Binding that, RetType name_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forLValueOnly(LValue that, RetType name_result) {
        return forBindingOnly(that, name_result);
    }

    public RetType forParamOnly(Param that, RetType name_result, Option<RetType> defaultExpr_result, Option<RetType> varargsType_result) {
        return forBindingOnly(that, name_result);
    }

    public RetType forExprOnly(Expr that) {
        return forAbstractNodeOnly(that);
    }

    public RetType forDummyExprOnly(DummyExpr that) {
        return forExprOnly(that);
    }

    public RetType forTypeAnnotatedExprOnly(TypeAnnotatedExpr that, RetType expr_result, RetType annType_result) {
        return forExprOnly(that);
    }

    public RetType forAsExprOnly(AsExpr that, RetType expr_result, RetType annType_result) {
        return forTypeAnnotatedExprOnly(that, expr_result, annType_result);
    }

    public RetType forAsIfExprOnly(AsIfExpr that, RetType expr_result, RetType annType_result) {
        return forTypeAnnotatedExprOnly(that, expr_result, annType_result);
    }

    public RetType forAssignmentOnly(Assignment that, Option<RetType> assignOp_result, RetType rhs_result) {
        return forExprOnly(that);
    }

    public RetType forBlockOnly(Block that, Option<RetType> loc_result, List<RetType> exprs_result) {
        return forExprOnly(that);
    }

    public RetType forDoOnly(Do that, List<RetType> fronts_result) {
        return forExprOnly(that);
    }

    public RetType forCaseExprOnly(CaseExpr that, Option<RetType> param_result, Option<RetType> compare_result, RetType equalsOp_result, RetType inOp_result, List<RetType> clauses_result, Option<RetType> elseClause_result) {
        return forExprOnly(that);
    }

    public RetType forIfOnly(If that, List<RetType> clauses_result, Option<RetType> elseClause_result) {
        return forExprOnly(that);
    }

    public RetType forLabelOnly(Label that, RetType name_result, RetType body_result) {
        return forExprOnly(that);
    }

    public RetType forAbstractObjectExprOnly(AbstractObjectExpr that) {
        return forExprOnly(that);
    }

    public RetType forObjectExprOnly(ObjectExpr that, Option<RetType> selfType_result) {
        return forAbstractObjectExprOnly(that);
    }

    public RetType for_RewriteObjectExprOnly(_RewriteObjectExpr that, List<RetType> staticArgs_result) {
        return forAbstractObjectExprOnly(that);
    }

    public RetType forTryOnly(Try that, RetType body_result, Option<RetType> catchClause_result, List<RetType> forbidClause_result, Option<RetType> finallyClause_result) {
        return forExprOnly(that);
    }

    public RetType forTupleExprOnly(TupleExpr that, List<RetType> exprs_result, Option<RetType> varargs_result, List<RetType> keywords_result) {
        return forExprOnly(that);
    }

    public RetType forTypecaseOnly(Typecase that, RetType bindExpr_result, List<RetType> clauses_result, Option<RetType> elseClause_result) {
        return forExprOnly(that);
    }

    public RetType forWhileOnly(While that, RetType testExpr_result, RetType body_result) {
        return forExprOnly(that);
    }

    public RetType forForOnly(For that, List<RetType> gens_result, RetType body_result) {
        return forExprOnly(that);
    }

    public RetType forBigOpAppOnly(BigOpApp that, List<RetType> staticArgs_result) {
        return forExprOnly(that);
    }

    public RetType forAccumulatorOnly(Accumulator that, List<RetType> staticArgs_result, RetType accOp_result, List<RetType> gens_result, RetType body_result) {
        return forBigOpAppOnly(that, staticArgs_result);
    }

    public RetType forArrayComprehensionOnly(ArrayComprehension that, List<RetType> staticArgs_result, List<RetType> clauses_result) {
        return forBigOpAppOnly(that, staticArgs_result);
    }

    public RetType forAtomicExprOnly(AtomicExpr that, RetType expr_result) {
        return forExprOnly(that);
    }

    public RetType forExitOnly(Exit that, Option<RetType> target_result, Option<RetType> returnExpr_result) {
        return forExprOnly(that);
    }

    public RetType forSpawnOnly(Spawn that, RetType body_result) {
        return forExprOnly(that);
    }

    public RetType forThrowOnly(Throw that, RetType expr_result) {
        return forExprOnly(that);
    }

    public RetType forTryAtomicExprOnly(TryAtomicExpr that, RetType expr_result) {
        return forExprOnly(that);
    }

    public RetType forFnExprOnly(FnExpr that, RetType body_result) {
        return forExprOnly(that);
    }

    public RetType forLetExprOnly(LetExpr that, RetType body_result) {
        return forExprOnly(that);
    }

    public RetType forLetFnOnly(LetFn that, RetType body_result, List<RetType> fns_result) {
        return forLetExprOnly(that, body_result);
    }

    public RetType forLocalVarDeclOnly(LocalVarDecl that, RetType body_result, List<RetType> lhs_result, Option<RetType> rhs_result) {
        return forLetExprOnly(that, body_result);
    }

    public RetType forSimpleExprOnly(SimpleExpr that) {
        return forExprOnly(that);
    }

    public RetType forSubscriptExprOnly(SubscriptExpr that, RetType obj_result, List<RetType> subs_result, Option<RetType> op_result, List<RetType> staticArgs_result) {
        return forSimpleExprOnly(that);
    }

    public RetType forPrimaryOnly(Primary that) {
        return forSimpleExprOnly(that);
    }

    public RetType forLiteralExprOnly(LiteralExpr that) {
        return forPrimaryOnly(that);
    }

    public RetType forNumberLiteralExprOnly(NumberLiteralExpr that) {
        return forLiteralExprOnly(that);
    }

    public RetType forFloatLiteralExprOnly(FloatLiteralExpr that) {
        return forNumberLiteralExprOnly(that);
    }

    public RetType forIntLiteralExprOnly(IntLiteralExpr that) {
        return forNumberLiteralExprOnly(that);
    }

    public RetType forCharLiteralExprOnly(CharLiteralExpr that) {
        return forLiteralExprOnly(that);
    }

    public RetType forStringLiteralExprOnly(StringLiteralExpr that) {
        return forLiteralExprOnly(that);
    }

    public RetType forVoidLiteralExprOnly(VoidLiteralExpr that) {
        return forLiteralExprOnly(that);
    }

    public RetType forBooleanLiteralExprOnly(BooleanLiteralExpr that) {
        return forLiteralExprOnly(that);
    }

    public RetType forVarRefOnly(VarRef that, RetType varId_result, List<RetType> staticArgs_result) {
        return forPrimaryOnly(that);
    }

    public RetType forFieldRefOnly(FieldRef that, RetType obj_result, RetType field_result) {
        return forPrimaryOnly(that);
    }

    public RetType forFunctionalRefOnly(FunctionalRef that, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result) {
        return forPrimaryOnly(that);
    }

    public RetType forFnRefOnly(FnRef that, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result) {
        return forFunctionalRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType forOpRefOnly(OpRef that, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result) {
        return forFunctionalRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType for_RewriteFnRefOnly(_RewriteFnRef that, RetType fnExpr_result, List<RetType> staticArgs_result) {
        return forPrimaryOnly(that);
    }

    public RetType for_RewriteObjectExprRefOnly(_RewriteObjectExprRef that, List<RetType> staticArgs_result) {
        return forPrimaryOnly(that);
    }

    public RetType forJuxtOnly(Juxt that, RetType multiJuxt_result, RetType infixJuxt_result, List<RetType> exprs_result) {
        return forPrimaryOnly(that);
    }

    public RetType for_RewriteFnAppOnly(_RewriteFnApp that, RetType function_result, RetType argument_result) {
        return forPrimaryOnly(that);
    }

    public RetType forOpExprOnly(OpExpr that, RetType op_result, List<RetType> args_result) {
        return forPrimaryOnly(that);
    }

    public RetType forAmbiguousMultifixOpExprOnly(AmbiguousMultifixOpExpr that, RetType infix_op_result, RetType multifix_op_result, List<RetType> args_result) {
        return forPrimaryOnly(that);
    }

    public RetType forChainExprOnly(ChainExpr that, RetType first_result, List<RetType> links_result) {
        return forPrimaryOnly(that);
    }

    public RetType forCoercionInvocationOnly(CoercionInvocation that, RetType toType_result, RetType arg_result) {
        return forPrimaryOnly(that);
    }

    public RetType forTraitCoercionInvocationOnly(TraitCoercionInvocation that, RetType arg_result, RetType toType_result, RetType coercionFn_result) {
        return forCoercionInvocationOnly(that, toType_result, arg_result);
    }

    public RetType forTupleCoercionInvocationOnly(TupleCoercionInvocation that, RetType arg_result, RetType toType_result, List<Option<RetType>> subCoercions_result, Option<Option<RetType>> varargCoercion_result) {
        return forCoercionInvocationOnly(that, toType_result, arg_result);
    }

    public RetType forArrowCoercionInvocationOnly(ArrowCoercionInvocation that, RetType arg_result, RetType toType_result, Option<RetType> domainCoercion_result, Option<RetType> rangeCoercion_result) {
        return forCoercionInvocationOnly(that, toType_result, arg_result);
    }

    public RetType forUnionCoercionInvocationOnly(UnionCoercionInvocation that, RetType toType_result, RetType arg_result, List<RetType> fromTypes_result, List<Option<RetType>> fromCoercions_result) {
        return forCoercionInvocationOnly(that, toType_result, arg_result);
    }

    public RetType forMethodInvocationOnly(MethodInvocation that, RetType obj_result, RetType method_result, List<RetType> staticArgs_result, RetType arg_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result) {
        return forPrimaryOnly(that);
    }

    public RetType forMathPrimaryOnly(MathPrimary that, RetType multiJuxt_result, RetType infixJuxt_result, RetType front_result, List<RetType> rest_result) {
        return forPrimaryOnly(that);
    }

    public RetType forArrayExprOnly(ArrayExpr that, List<RetType> staticArgs_result) {
        return forPrimaryOnly(that);
    }

    public RetType forArrayElementOnly(ArrayElement that, List<RetType> staticArgs_result, RetType element_result) {
        return forArrayExprOnly(that, staticArgs_result);
    }

    public RetType forArrayElementsOnly(ArrayElements that, List<RetType> staticArgs_result, List<RetType> elements_result) {
        return forArrayExprOnly(that, staticArgs_result);
    }

    public RetType forTypeOnly(Type that) {
        return forAbstractNodeOnly(that);
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

    public RetType forNamedTypeOnly(NamedType that, RetType name_result) {
        return forBaseTypeOnly(that);
    }

    public RetType for_InferenceVarTypeOnly(_InferenceVarType that, RetType name_result) {
        return forNamedTypeOnly(that, name_result);
    }

    public RetType forVarTypeOnly(VarType that, RetType name_result) {
        return forNamedTypeOnly(that, name_result);
    }

    public RetType forTraitTypeOnly(TraitType that, RetType name_result, List<RetType> args_result, List<RetType> traitStaticParams_result) {
        return forNamedTypeOnly(that, name_result);
    }

    public RetType forAbbreviatedTypeOnly(AbbreviatedType that, RetType elemType_result) {
        return forBaseTypeOnly(that);
    }

    public RetType forArrayTypeOnly(ArrayType that, RetType elemType_result, RetType indices_result) {
        return forAbbreviatedTypeOnly(that, elemType_result);
    }

    public RetType forMatrixTypeOnly(MatrixType that, RetType elemType_result, List<RetType> dimensions_result) {
        return forAbbreviatedTypeOnly(that, elemType_result);
    }

    public RetType forTaggedDimTypeOnly(TaggedDimType that, RetType elemType_result, RetType dimExpr_result, Option<RetType> unitExpr_result) {
        return forAbbreviatedTypeOnly(that, elemType_result);
    }

    public RetType forTaggedUnitTypeOnly(TaggedUnitType that, RetType elemType_result, RetType unitExpr_result) {
        return forAbbreviatedTypeOnly(that, elemType_result);
    }

    public RetType forTupleTypeOnly(TupleType that, List<RetType> elements_result, Option<RetType> varargs_result, List<RetType> keywords_result) {
        return forTypeOnly(that);
    }

    public RetType forArrowTypeOnly(ArrowType that, RetType domain_result, RetType range_result, RetType effect_result) {
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

    public RetType forDimRefOnly(DimRef that, RetType name_result) {
        return forDimExprOnly(that);
    }

    public RetType forDimExponentOnly(DimExponent that, RetType base_result, RetType power_result) {
        return forDimExprOnly(that);
    }

    public RetType forDimUnaryOpOnly(DimUnaryOp that, RetType dimVal_result, RetType op_result) {
        return forDimExprOnly(that);
    }

    public RetType forDimBinaryOpOnly(DimBinaryOp that, RetType left_result, RetType right_result, RetType op_result) {
        return forDimExprOnly(that);
    }

    public RetType forPatternOnly(Pattern that, Option<RetType> name_result, RetType patterns_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forPatternArgsOnly(PatternArgs that, List<RetType> patterns_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forPatternBindingOnly(PatternBinding that, Option<RetType> field_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forPlainPatternOnly(PlainPattern that, Option<RetType> field_result, RetType name_result) {
        return forPatternBindingOnly(that, field_result);
    }

    public RetType forTypePatternOnly(TypePattern that, Option<RetType> field_result, RetType typ_result) {
        return forPatternBindingOnly(that, field_result);
    }

    public RetType forNestedPatternOnly(NestedPattern that, Option<RetType> field_result, RetType pat_result) {
        return forPatternBindingOnly(that, field_result);
    }

    public RetType forStaticArgOnly(StaticArg that) {
        return forAbstractNodeOnly(that);
    }

    public RetType forTypeArgOnly(TypeArg that, RetType typeArg_result) {
        return forStaticArgOnly(that);
    }

    public RetType forIntArgOnly(IntArg that, RetType intVal_result) {
        return forStaticArgOnly(that);
    }

    public RetType forBoolArgOnly(BoolArg that, RetType boolArg_result) {
        return forStaticArgOnly(that);
    }

    public RetType forOpArgOnly(OpArg that, RetType id_result) {
        return forStaticArgOnly(that);
    }

    public RetType forDimArgOnly(DimArg that, RetType dimArg_result) {
        return forStaticArgOnly(that);
    }

    public RetType forUnitArgOnly(UnitArg that, RetType unitArg_result) {
        return forStaticArgOnly(that);
    }

    public RetType forStaticExprOnly(StaticExpr that) {
        return forAbstractNodeOnly(that);
    }

    public RetType forIntExprOnly(IntExpr that) {
        return forStaticExprOnly(that);
    }

    public RetType forIntBaseOnly(IntBase that, RetType intVal_result) {
        return forIntExprOnly(that);
    }

    public RetType forIntRefOnly(IntRef that, RetType name_result) {
        return forIntExprOnly(that);
    }

    public RetType forIntBinaryOpOnly(IntBinaryOp that, RetType left_result, RetType right_result, RetType op_result) {
        return forIntExprOnly(that);
    }

    public RetType forBoolExprOnly(BoolExpr that) {
        return forStaticExprOnly(that);
    }

    public RetType forBoolBaseOnly(BoolBase that) {
        return forBoolExprOnly(that);
    }

    public RetType forBoolRefOnly(BoolRef that, RetType name_result) {
        return forBoolExprOnly(that);
    }

    public RetType forBoolConstraintOnly(BoolConstraint that) {
        return forBoolExprOnly(that);
    }

    public RetType forBoolUnaryOpOnly(BoolUnaryOp that, RetType boolVal_result, RetType op_result) {
        return forBoolConstraintOnly(that);
    }

    public RetType forBoolBinaryOpOnly(BoolBinaryOp that, RetType left_result, RetType right_result, RetType op_result) {
        return forBoolConstraintOnly(that);
    }

    public RetType forUnitExprOnly(UnitExpr that) {
        return forStaticExprOnly(that);
    }

    public RetType forUnitRefOnly(UnitRef that, RetType name_result) {
        return forUnitExprOnly(that);
    }

    public RetType forUnitBinaryOpOnly(UnitBinaryOp that, RetType left_result, RetType right_result, RetType op_result) {
        return forUnitExprOnly(that);
    }

    public RetType forEffectOnly(Effect that, Option<List<RetType>> throwsClause_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forWhereClauseOnly(WhereClause that, List<RetType> bindings_result, List<RetType> constraints_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forWhereBindingOnly(WhereBinding that, RetType name_result, List<RetType> supers_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forWhereConstraintOnly(WhereConstraint that) {
        return forAbstractNodeOnly(that);
    }

    public RetType forWhereExtendsOnly(WhereExtends that, RetType name_result, List<RetType> supers_result) {
        return forWhereConstraintOnly(that);
    }

    public RetType forWhereTypeAliasOnly(WhereTypeAlias that, RetType alias_result) {
        return forWhereConstraintOnly(that);
    }

    public RetType forWhereCoercesOnly(WhereCoerces that, RetType left_result, RetType right_result) {
        return forWhereConstraintOnly(that);
    }

    public RetType forWhereEqualsOnly(WhereEquals that, RetType left_result, RetType right_result) {
        return forWhereConstraintOnly(that);
    }

    public RetType forUnitConstraintOnly(UnitConstraint that, RetType name_result) {
        return forWhereConstraintOnly(that);
    }

    public RetType forIntConstraintOnly(IntConstraint that, RetType left_result, RetType right_result, RetType op_result) {
        return forWhereConstraintOnly(that);
    }

    public RetType forBoolConstraintExprOnly(BoolConstraintExpr that, RetType constraint_result) {
        return forWhereConstraintOnly(that);
    }

    public RetType forContractOnly(Contract that, Option<List<RetType>> requiresClause_result, Option<List<RetType>> ensuresClause_result, Option<List<RetType>> invariantsClause_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forEnsuresClauseOnly(EnsuresClause that, RetType post_result, Option<RetType> pre_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forStaticParamOnly(StaticParam that, RetType name_result, List<RetType> extendsClause_result, List<RetType> dominatesClause_result, Option<RetType> dimParam_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forNameOnly(Name that) {
        return forAbstractNodeOnly(that);
    }

    public RetType forAPINameOnly(APIName that, List<RetType> ids_result) {
        return forNameOnly(that);
    }

    public RetType forIdOrOpOrAnonymousNameOnly(IdOrOpOrAnonymousName that, Option<RetType> apiName_result) {
        return forNameOnly(that);
    }

    public RetType forIdOrOpOnly(IdOrOp that, Option<RetType> apiName_result) {
        return forIdOrOpOrAnonymousNameOnly(that, apiName_result);
    }

    public RetType forIdOnly(Id that, Option<RetType> apiName_result) {
        return forIdOrOpOnly(that, apiName_result);
    }

    public RetType forOpOnly(Op that, Option<RetType> apiName_result) {
        return forIdOrOpOnly(that, apiName_result);
    }

    public RetType forNamedOpOnly(NamedOp that, Option<RetType> apiName_result) {
        return forOpOnly(that, apiName_result);
    }

    public RetType for_InferenceVarOpOnly(_InferenceVarOp that, Option<RetType> apiName_result) {
        return forOpOnly(that, apiName_result);
    }

    public RetType forAnonymousNameOnly(AnonymousName that, Option<RetType> apiName_result) {
        return forIdOrOpOrAnonymousNameOnly(that, apiName_result);
    }

    public RetType forAnonymousFnNameOnly(AnonymousFnName that, Option<RetType> apiName_result) {
        return forAnonymousNameOnly(that, apiName_result);
    }

    public RetType forConstructorFnNameOnly(ConstructorFnName that, Option<RetType> apiName_result) {
        return forAnonymousNameOnly(that, apiName_result);
    }

    public RetType forArrayComprehensionClauseOnly(ArrayComprehensionClause that, List<RetType> bind_result, RetType init_result, List<RetType> gens_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forKeywordExprOnly(KeywordExpr that, RetType name_result, RetType init_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forCaseClauseOnly(CaseClause that, RetType matchClause_result, RetType body_result, Option<RetType> op_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forCatchOnly(Catch that, RetType name_result, List<RetType> clauses_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forCatchClauseOnly(CatchClause that, RetType matchType_result, RetType body_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forIfClauseOnly(IfClause that, RetType testClause_result, RetType body_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forTypecaseClauseOnly(TypecaseClause that, Option<RetType> name_result, RetType body_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forExtentRangeOnly(ExtentRange that, Option<RetType> base_result, Option<RetType> size_result, Option<RetType> op_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forGeneratorClauseOnly(GeneratorClause that, List<RetType> bind_result, RetType init_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forKeywordTypeOnly(KeywordType that, RetType name_result, RetType keywordType_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forTraitTypeWhereOnly(TraitTypeWhere that, RetType baseType_result, Option<RetType> whereClause_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forIndicesOnly(Indices that, List<RetType> extents_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forMathItemOnly(MathItem that) {
        return forAbstractNodeOnly(that);
    }

    public RetType forExprMIOnly(ExprMI that, RetType expr_result) {
        return forMathItemOnly(that);
    }

    public RetType forParenthesisDelimitedMIOnly(ParenthesisDelimitedMI that, RetType expr_result) {
        return forExprMIOnly(that, expr_result);
    }

    public RetType forNonParenthesisDelimitedMIOnly(NonParenthesisDelimitedMI that, RetType expr_result) {
        return forExprMIOnly(that, expr_result);
    }

    public RetType forNonExprMIOnly(NonExprMI that) {
        return forMathItemOnly(that);
    }

    public RetType forExponentiationMIOnly(ExponentiationMI that, RetType op_result, Option<RetType> expr_result) {
        return forNonExprMIOnly(that);
    }

    public RetType forSubscriptingMIOnly(SubscriptingMI that, RetType op_result, List<RetType> exprs_result, List<RetType> staticArgs_result) {
        return forNonExprMIOnly(that);
    }

    public RetType forOverloadingOnly(Overloading that, RetType unambiguousName_result, RetType originalName_result, Option<RetType> type_result, Option<RetType> schema_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forNonterminalHeaderOnly(NonterminalHeader that, RetType name_result, List<RetType> params_result, List<RetType> staticParams_result, Option<RetType> paramType_result, Option<RetType> whereClause_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forNonterminalParameterOnly(NonterminalParameter that, RetType name_result, RetType paramType_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forSyntaxDeclOnly(SyntaxDecl that) {
        return forAbstractNodeOnly(that);
    }

    public RetType forSyntaxDefOnly(SyntaxDef that, List<RetType> syntaxSymbols_result, RetType transformer_result) {
        return forSyntaxDeclOnly(that);
    }

    public RetType forSuperSyntaxDefOnly(SuperSyntaxDef that, RetType nonterminal_result, RetType grammarId_result) {
        return forSyntaxDeclOnly(that);
    }

    public RetType forTransformerDeclOnly(TransformerDecl that) {
        return forAbstractNodeOnly(that);
    }

    public RetType forPreTransformerDefOnly(PreTransformerDef that, RetType transformer_result) {
        return forTransformerDeclOnly(that);
    }

    public RetType forNamedTransformerDefOnly(NamedTransformerDef that, List<RetType> parameters_result, RetType transformer_result) {
        return forTransformerDeclOnly(that);
    }

    public RetType forTransformerOnly(Transformer that) {
        return forAbstractNodeOnly(that);
    }

    public RetType forUnparsedTransformerOnly(UnparsedTransformer that, RetType nonterminal_result) {
        return forTransformerOnly(that);
    }

    public RetType forNodeTransformerOnly(NodeTransformer that, RetType node_result) {
        return forTransformerOnly(that);
    }

    public RetType forCaseTransformerOnly(CaseTransformer that, RetType gapName_result, List<RetType> clauses_result) {
        return forTransformerOnly(that);
    }

    public RetType forCaseTransformerClauseOnly(CaseTransformerClause that, RetType constructor_result, List<RetType> parameters_result, RetType body_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType forSyntaxSymbolOnly(SyntaxSymbol that) {
        return forAbstractNodeOnly(that);
    }

    public RetType forPrefixedSymbolOnly(PrefixedSymbol that, RetType id_result, RetType symbol_result) {
        return forSyntaxSymbolOnly(that);
    }

    public RetType forOptionalSymbolOnly(OptionalSymbol that, RetType symbol_result) {
        return forSyntaxSymbolOnly(that);
    }

    public RetType forRepeatSymbolOnly(RepeatSymbol that, RetType symbol_result) {
        return forSyntaxSymbolOnly(that);
    }

    public RetType forRepeatOneOrMoreSymbolOnly(RepeatOneOrMoreSymbol that, RetType symbol_result) {
        return forSyntaxSymbolOnly(that);
    }

    public RetType forNoWhitespaceSymbolOnly(NoWhitespaceSymbol that, RetType symbol_result) {
        return forSyntaxSymbolOnly(that);
    }

    public RetType forGroupSymbolOnly(GroupSymbol that, List<RetType> symbols_result) {
        return forSyntaxSymbolOnly(that);
    }

    public RetType forSpecialSymbolOnly(SpecialSymbol that) {
        return forSyntaxSymbolOnly(that);
    }

    public RetType forAnyCharacterSymbolOnly(AnyCharacterSymbol that) {
        return forSpecialSymbolOnly(that);
    }

    public RetType forWhitespaceSymbolOnly(WhitespaceSymbol that) {
        return forSpecialSymbolOnly(that);
    }

    public RetType forTabSymbolOnly(TabSymbol that) {
        return forSpecialSymbolOnly(that);
    }

    public RetType forFormfeedSymbolOnly(FormfeedSymbol that) {
        return forSpecialSymbolOnly(that);
    }

    public RetType forCarriageReturnSymbolOnly(CarriageReturnSymbol that) {
        return forSpecialSymbolOnly(that);
    }

    public RetType forBackspaceSymbolOnly(BackspaceSymbol that) {
        return forSpecialSymbolOnly(that);
    }

    public RetType forNewlineSymbolOnly(NewlineSymbol that) {
        return forSpecialSymbolOnly(that);
    }

    public RetType forBreaklineSymbolOnly(BreaklineSymbol that) {
        return forSpecialSymbolOnly(that);
    }

    public RetType forItemSymbolOnly(ItemSymbol that) {
        return forSyntaxSymbolOnly(that);
    }

    public RetType forNonterminalSymbolOnly(NonterminalSymbol that, RetType nonterminal_result) {
        return forSyntaxSymbolOnly(that);
    }

    public RetType forKeywordSymbolOnly(KeywordSymbol that) {
        return forSyntaxSymbolOnly(that);
    }

    public RetType forTokenSymbolOnly(TokenSymbol that) {
        return forSyntaxSymbolOnly(that);
    }

    public RetType forNotPredicateSymbolOnly(NotPredicateSymbol that, RetType symbol_result) {
        return forSyntaxSymbolOnly(that);
    }

    public RetType forAndPredicateSymbolOnly(AndPredicateSymbol that, RetType symbol_result) {
        return forSyntaxSymbolOnly(that);
    }

    public RetType forCharacterClassSymbolOnly(CharacterClassSymbol that, List<RetType> characters_result) {
        return forSyntaxSymbolOnly(that);
    }

    public RetType forCharacterSymbolOnly(CharacterSymbol that) {
        return forSyntaxSymbolOnly(that);
    }

    public RetType forCharSymbolOnly(CharSymbol that) {
        return forCharacterSymbolOnly(that);
    }

    public RetType forCharacterIntervalOnly(CharacterInterval that) {
        return forCharacterSymbolOnly(that);
    }

    public RetType forLinkOnly(Link that, RetType op_result, RetType expr_result) {
        return forAbstractNodeOnly(that);
    }

    public RetType for_SyntaxTransformationAbstractNodeOnly(_SyntaxTransformationAbstractNode that) {
        return forAbstractNodeOnly(that);
    }

    public RetType for_SyntaxTransformationCompilationUnitOnly(_SyntaxTransformationCompilationUnit that, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result) {
        return forCompilationUnitOnly(that, name_result, imports_result, decls_result, comprises_result);
    }

    public RetType for_SyntaxTransformationComponentOnly(_SyntaxTransformationComponent that, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result, List<RetType> exports_result) {
        return forComponentOnly(that, name_result, imports_result, decls_result, comprises_result, exports_result);
    }

    public RetType for_SyntaxTransformationApiOnly(_SyntaxTransformationApi that, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result) {
        return forApiOnly(that, name_result, imports_result, decls_result, comprises_result);
    }

    public RetType for_SyntaxTransformationImportOnly(_SyntaxTransformationImport that) {
        return forImportOnly(that);
    }

    public RetType for_SyntaxTransformationImportedNamesOnly(_SyntaxTransformationImportedNames that, RetType apiName_result) {
        return forImportedNamesOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationImportStarOnly(_SyntaxTransformationImportStar that, RetType apiName_result, List<RetType> exceptNames_result) {
        return forImportStarOnly(that, apiName_result, exceptNames_result);
    }

    public RetType for_SyntaxTransformationImportNamesOnly(_SyntaxTransformationImportNames that, RetType apiName_result, List<RetType> aliasedNames_result) {
        return forImportNamesOnly(that, apiName_result, aliasedNames_result);
    }

    public RetType for_SyntaxTransformationImportApiOnly(_SyntaxTransformationImportApi that, List<RetType> apis_result) {
        return forImportApiOnly(that, apis_result);
    }

    public RetType for_SyntaxTransformationAliasedSimpleNameOnly(_SyntaxTransformationAliasedSimpleName that, RetType name_result, Option<RetType> alias_result) {
        return forAliasedSimpleNameOnly(that, name_result, alias_result);
    }

    public RetType for_SyntaxTransformationAliasedAPINameOnly(_SyntaxTransformationAliasedAPIName that, RetType apiName_result, Option<RetType> alias_result) {
        return forAliasedAPINameOnly(that, apiName_result, alias_result);
    }

    public RetType for_SyntaxTransformationDeclOnly(_SyntaxTransformationDecl that) {
        return forDeclOnly(that);
    }

    public RetType for_SyntaxTransformationTraitObjectDeclOnly(_SyntaxTransformationTraitObjectDecl that, Option<RetType> selfType_result) {
        return forTraitObjectDeclOnly(that, selfType_result);
    }

    public RetType for_SyntaxTransformationTraitDeclOnly(_SyntaxTransformationTraitDecl that, Option<RetType> selfType_result, List<RetType> excludesClause_result, Option<List<RetType>> comprisesClause_result) {
        return forTraitDeclOnly(that, selfType_result, excludesClause_result, comprisesClause_result);
    }

    public RetType for_SyntaxTransformationObjectDeclOnly(_SyntaxTransformationObjectDecl that, Option<RetType> selfType_result) {
        return forObjectDeclOnly(that, selfType_result);
    }

    public RetType for_SyntaxTransformationVarDeclOnly(_SyntaxTransformationVarDecl that, List<RetType> lhs_result, Option<RetType> init_result) {
        return forVarDeclOnly(that, lhs_result, init_result);
    }

    public RetType for_SyntaxTransformationFnDeclOnly(_SyntaxTransformationFnDecl that, RetType unambiguousName_result, Option<RetType> body_result, Option<RetType> implementsUnambiguousName_result) {
        return forFnDeclOnly(that, unambiguousName_result, body_result, implementsUnambiguousName_result);
    }

    public RetType for_SyntaxTransformation_RewriteFnOverloadDeclOnly(_SyntaxTransformation_RewriteFnOverloadDecl that, RetType name_result, List<RetType> fns_result, Option<RetType> type_result) {
        return for_RewriteFnOverloadDeclOnly(that, name_result, fns_result, type_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprDeclOnly(_SyntaxTransformation_RewriteObjectExprDecl that, List<RetType> objectExprs_result) {
        return for_RewriteObjectExprDeclOnly(that, objectExprs_result);
    }

    public RetType for_SyntaxTransformation_RewriteFunctionalMethodDeclOnly(_SyntaxTransformation_RewriteFunctionalMethodDecl that) {
        return for_RewriteFunctionalMethodDeclOnly(that);
    }

    public RetType for_SyntaxTransformationDimUnitDeclOnly(_SyntaxTransformationDimUnitDecl that) {
        return forDimUnitDeclOnly(that);
    }

    public RetType for_SyntaxTransformationDimDeclOnly(_SyntaxTransformationDimDecl that, RetType dimId_result, Option<RetType> derived_result, Option<RetType> defaultId_result) {
        return forDimDeclOnly(that, dimId_result, derived_result, defaultId_result);
    }

    public RetType for_SyntaxTransformationUnitDeclOnly(_SyntaxTransformationUnitDecl that, List<RetType> units_result, Option<RetType> dimType_result, Option<RetType> defExpr_result) {
        return forUnitDeclOnly(that, units_result, dimType_result, defExpr_result);
    }

    public RetType for_SyntaxTransformationTestDeclOnly(_SyntaxTransformationTestDecl that, RetType name_result, List<RetType> gens_result, RetType expr_result) {
        return forTestDeclOnly(that, name_result, gens_result, expr_result);
    }

    public RetType for_SyntaxTransformationPropertyDeclOnly(_SyntaxTransformationPropertyDecl that, Option<RetType> name_result, List<RetType> params_result, RetType expr_result) {
        return forPropertyDeclOnly(that, name_result, params_result, expr_result);
    }

    public RetType for_SyntaxTransformationTypeAliasOnly(_SyntaxTransformationTypeAlias that, RetType name_result, List<RetType> staticParams_result, RetType typeDef_result) {
        return forTypeAliasOnly(that, name_result, staticParams_result, typeDef_result);
    }

    public RetType for_SyntaxTransformationGrammarDeclOnly(_SyntaxTransformationGrammarDecl that, RetType name_result, List<RetType> extendsClause_result, List<RetType> members_result, List<RetType> transformers_result) {
        return forGrammarDeclOnly(that, name_result, extendsClause_result, members_result, transformers_result);
    }

    public RetType for_SyntaxTransformationGrammarMemberDeclOnly(_SyntaxTransformationGrammarMemberDecl that, RetType name_result) {
        return forGrammarMemberDeclOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationNonterminalDeclOnly(_SyntaxTransformationNonterminalDecl that, RetType name_result, List<RetType> syntaxDecls_result) {
        return forNonterminalDeclOnly(that, name_result, syntaxDecls_result);
    }

    public RetType for_SyntaxTransformationNonterminalDefOnly(_SyntaxTransformationNonterminalDef that, RetType name_result, List<RetType> syntaxDecls_result, RetType header_result, Option<RetType> astType_result) {
        return forNonterminalDefOnly(that, name_result, syntaxDecls_result, header_result, astType_result);
    }

    public RetType for_SyntaxTransformationNonterminalExtensionDefOnly(_SyntaxTransformationNonterminalExtensionDef that, RetType name_result, List<RetType> syntaxDecls_result) {
        return forNonterminalExtensionDefOnly(that, name_result, syntaxDecls_result);
    }

    public RetType for_SyntaxTransformationBindingOnly(_SyntaxTransformationBinding that, RetType name_result) {
        return forBindingOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationLValueOnly(_SyntaxTransformationLValue that, RetType name_result) {
        return forLValueOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationParamOnly(_SyntaxTransformationParam that, RetType name_result, Option<RetType> defaultExpr_result, Option<RetType> varargsType_result) {
        return forParamOnly(that, name_result, defaultExpr_result, varargsType_result);
    }

    public RetType for_SyntaxTransformationExprOnly(_SyntaxTransformationExpr that) {
        return forExprOnly(that);
    }

    public RetType for_SyntaxTransformationDummyExprOnly(_SyntaxTransformationDummyExpr that) {
        return forDummyExprOnly(that);
    }

    public RetType for_SyntaxTransformationTypeAnnotatedExprOnly(_SyntaxTransformationTypeAnnotatedExpr that, RetType expr_result, RetType annType_result) {
        return forTypeAnnotatedExprOnly(that, expr_result, annType_result);
    }

    public RetType for_SyntaxTransformationAsExprOnly(_SyntaxTransformationAsExpr that, RetType expr_result, RetType annType_result) {
        return forAsExprOnly(that, expr_result, annType_result);
    }

    public RetType for_SyntaxTransformationAsIfExprOnly(_SyntaxTransformationAsIfExpr that, RetType expr_result, RetType annType_result) {
        return forAsIfExprOnly(that, expr_result, annType_result);
    }

    public RetType for_SyntaxTransformationAssignmentOnly(_SyntaxTransformationAssignment that, Option<RetType> assignOp_result, RetType rhs_result) {
        return forAssignmentOnly(that, assignOp_result, rhs_result);
    }

    public RetType for_SyntaxTransformationBlockOnly(_SyntaxTransformationBlock that, Option<RetType> loc_result, List<RetType> exprs_result) {
        return forBlockOnly(that, loc_result, exprs_result);
    }

    public RetType for_SyntaxTransformationDoOnly(_SyntaxTransformationDo that, List<RetType> fronts_result) {
        return forDoOnly(that, fronts_result);
    }

    public RetType for_SyntaxTransformationCaseExprOnly(_SyntaxTransformationCaseExpr that, Option<RetType> param_result, Option<RetType> compare_result, RetType equalsOp_result, RetType inOp_result, List<RetType> clauses_result, Option<RetType> elseClause_result) {
        return forCaseExprOnly(that, param_result, compare_result, equalsOp_result, inOp_result, clauses_result, elseClause_result);
    }

    public RetType for_SyntaxTransformationIfOnly(_SyntaxTransformationIf that, List<RetType> clauses_result, Option<RetType> elseClause_result) {
        return forIfOnly(that, clauses_result, elseClause_result);
    }

    public RetType for_SyntaxTransformationLabelOnly(_SyntaxTransformationLabel that, RetType name_result, RetType body_result) {
        return forLabelOnly(that, name_result, body_result);
    }

    public RetType for_SyntaxTransformationAbstractObjectExprOnly(_SyntaxTransformationAbstractObjectExpr that) {
        return forAbstractObjectExprOnly(that);
    }

    public RetType for_SyntaxTransformationObjectExprOnly(_SyntaxTransformationObjectExpr that, Option<RetType> selfType_result) {
        return forObjectExprOnly(that, selfType_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprOnly(_SyntaxTransformation_RewriteObjectExpr that, List<RetType> staticArgs_result) {
        return for_RewriteObjectExprOnly(that, staticArgs_result);
    }

    public RetType for_SyntaxTransformationTryOnly(_SyntaxTransformationTry that, RetType body_result, Option<RetType> catchClause_result, List<RetType> forbidClause_result, Option<RetType> finallyClause_result) {
        return forTryOnly(that, body_result, catchClause_result, forbidClause_result, finallyClause_result);
    }

    public RetType for_SyntaxTransformationTupleExprOnly(_SyntaxTransformationTupleExpr that, List<RetType> exprs_result, Option<RetType> varargs_result, List<RetType> keywords_result) {
        return forTupleExprOnly(that, exprs_result, varargs_result, keywords_result);
    }

    public RetType for_SyntaxTransformationTypecaseOnly(_SyntaxTransformationTypecase that, RetType bindExpr_result, List<RetType> clauses_result, Option<RetType> elseClause_result) {
        return forTypecaseOnly(that, bindExpr_result, clauses_result, elseClause_result);
    }

    public RetType for_SyntaxTransformationWhileOnly(_SyntaxTransformationWhile that, RetType testExpr_result, RetType body_result) {
        return forWhileOnly(that, testExpr_result, body_result);
    }

    public RetType for_SyntaxTransformationForOnly(_SyntaxTransformationFor that, List<RetType> gens_result, RetType body_result) {
        return forForOnly(that, gens_result, body_result);
    }

    public RetType for_SyntaxTransformationBigOpAppOnly(_SyntaxTransformationBigOpApp that, List<RetType> staticArgs_result) {
        return forBigOpAppOnly(that, staticArgs_result);
    }

    public RetType for_SyntaxTransformationAccumulatorOnly(_SyntaxTransformationAccumulator that, List<RetType> staticArgs_result, RetType accOp_result, List<RetType> gens_result, RetType body_result) {
        return forAccumulatorOnly(that, staticArgs_result, accOp_result, gens_result, body_result);
    }

    public RetType for_SyntaxTransformationArrayComprehensionOnly(_SyntaxTransformationArrayComprehension that, List<RetType> staticArgs_result, List<RetType> clauses_result) {
        return forArrayComprehensionOnly(that, staticArgs_result, clauses_result);
    }

    public RetType for_SyntaxTransformationAtomicExprOnly(_SyntaxTransformationAtomicExpr that, RetType expr_result) {
        return forAtomicExprOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationExitOnly(_SyntaxTransformationExit that, Option<RetType> target_result, Option<RetType> returnExpr_result) {
        return forExitOnly(that, target_result, returnExpr_result);
    }

    public RetType for_SyntaxTransformationSpawnOnly(_SyntaxTransformationSpawn that, RetType body_result) {
        return forSpawnOnly(that, body_result);
    }

    public RetType for_SyntaxTransformationThrowOnly(_SyntaxTransformationThrow that, RetType expr_result) {
        return forThrowOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationTryAtomicExprOnly(_SyntaxTransformationTryAtomicExpr that, RetType expr_result) {
        return forTryAtomicExprOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationFnExprOnly(_SyntaxTransformationFnExpr that, RetType body_result) {
        return forFnExprOnly(that, body_result);
    }

    public RetType for_SyntaxTransformationLetExprOnly(_SyntaxTransformationLetExpr that, RetType body_result) {
        return forLetExprOnly(that, body_result);
    }

    public RetType for_SyntaxTransformationLetFnOnly(_SyntaxTransformationLetFn that, RetType body_result, List<RetType> fns_result) {
        return forLetFnOnly(that, body_result, fns_result);
    }

    public RetType for_SyntaxTransformationLocalVarDeclOnly(_SyntaxTransformationLocalVarDecl that, RetType body_result, List<RetType> lhs_result, Option<RetType> rhs_result) {
        return forLocalVarDeclOnly(that, body_result, lhs_result, rhs_result);
    }

    public RetType for_SyntaxTransformationSimpleExprOnly(_SyntaxTransformationSimpleExpr that) {
        return forSimpleExprOnly(that);
    }

    public RetType for_SyntaxTransformationSubscriptExprOnly(_SyntaxTransformationSubscriptExpr that, RetType obj_result, List<RetType> subs_result, Option<RetType> op_result, List<RetType> staticArgs_result) {
        return forSubscriptExprOnly(that, obj_result, subs_result, op_result, staticArgs_result);
    }

    public RetType for_SyntaxTransformationPrimaryOnly(_SyntaxTransformationPrimary that) {
        return forPrimaryOnly(that);
    }

    public RetType for_SyntaxTransformationLiteralExprOnly(_SyntaxTransformationLiteralExpr that) {
        return forLiteralExprOnly(that);
    }

    public RetType for_SyntaxTransformationNumberLiteralExprOnly(_SyntaxTransformationNumberLiteralExpr that) {
        return forNumberLiteralExprOnly(that);
    }

    public RetType for_SyntaxTransformationFloatLiteralExprOnly(_SyntaxTransformationFloatLiteralExpr that) {
        return forFloatLiteralExprOnly(that);
    }

    public RetType for_SyntaxTransformationIntLiteralExprOnly(_SyntaxTransformationIntLiteralExpr that) {
        return forIntLiteralExprOnly(that);
    }

    public RetType for_SyntaxTransformationCharLiteralExprOnly(_SyntaxTransformationCharLiteralExpr that) {
        return forCharLiteralExprOnly(that);
    }

    public RetType for_SyntaxTransformationStringLiteralExprOnly(_SyntaxTransformationStringLiteralExpr that) {
        return forStringLiteralExprOnly(that);
    }

    public RetType for_SyntaxTransformationVoidLiteralExprOnly(_SyntaxTransformationVoidLiteralExpr that) {
        return forVoidLiteralExprOnly(that);
    }

    public RetType for_SyntaxTransformationBooleanLiteralExprOnly(_SyntaxTransformationBooleanLiteralExpr that) {
        return forBooleanLiteralExprOnly(that);
    }

    public RetType for_SyntaxTransformationVarRefOnly(_SyntaxTransformationVarRef that, RetType varId_result, List<RetType> staticArgs_result) {
        return forVarRefOnly(that, varId_result, staticArgs_result);
    }

    public RetType for_SyntaxTransformationFieldRefOnly(_SyntaxTransformationFieldRef that, RetType obj_result, RetType field_result) {
        return forFieldRefOnly(that, obj_result, field_result);
    }

    public RetType for_SyntaxTransformationFunctionalRefOnly(_SyntaxTransformationFunctionalRef that, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result) {
        return forFunctionalRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType for_SyntaxTransformationFnRefOnly(_SyntaxTransformationFnRef that, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result) {
        return forFnRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType for_SyntaxTransformationOpRefOnly(_SyntaxTransformationOpRef that, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result) {
        return forOpRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType for_SyntaxTransformation_RewriteFnRefOnly(_SyntaxTransformation_RewriteFnRef that, RetType fnExpr_result, List<RetType> staticArgs_result) {
        return for_RewriteFnRefOnly(that, fnExpr_result, staticArgs_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprRefOnly(_SyntaxTransformation_RewriteObjectExprRef that, List<RetType> staticArgs_result) {
        return for_RewriteObjectExprRefOnly(that, staticArgs_result);
    }

    public RetType for_SyntaxTransformationJuxtOnly(_SyntaxTransformationJuxt that, RetType multiJuxt_result, RetType infixJuxt_result, List<RetType> exprs_result) {
        return forJuxtOnly(that, multiJuxt_result, infixJuxt_result, exprs_result);
    }

    public RetType for_SyntaxTransformation_RewriteFnAppOnly(_SyntaxTransformation_RewriteFnApp that, RetType function_result, RetType argument_result) {
        return for_RewriteFnAppOnly(that, function_result, argument_result);
    }

    public RetType for_SyntaxTransformationOpExprOnly(_SyntaxTransformationOpExpr that, RetType op_result, List<RetType> args_result) {
        return forOpExprOnly(that, op_result, args_result);
    }

    public RetType for_SyntaxTransformationAmbiguousMultifixOpExprOnly(_SyntaxTransformationAmbiguousMultifixOpExpr that, RetType infix_op_result, RetType multifix_op_result, List<RetType> args_result) {
        return forAmbiguousMultifixOpExprOnly(that, infix_op_result, multifix_op_result, args_result);
    }

    public RetType for_SyntaxTransformationChainExprOnly(_SyntaxTransformationChainExpr that, RetType first_result, List<RetType> links_result) {
        return forChainExprOnly(that, first_result, links_result);
    }

    public RetType for_SyntaxTransformationCoercionInvocationOnly(_SyntaxTransformationCoercionInvocation that, RetType toType_result, RetType arg_result) {
        return forCoercionInvocationOnly(that, toType_result, arg_result);
    }

    public RetType for_SyntaxTransformationTraitCoercionInvocationOnly(_SyntaxTransformationTraitCoercionInvocation that, RetType arg_result, RetType toType_result, RetType coercionFn_result) {
        return forTraitCoercionInvocationOnly(that, arg_result, toType_result, coercionFn_result);
    }

    public RetType for_SyntaxTransformationTupleCoercionInvocationOnly(_SyntaxTransformationTupleCoercionInvocation that, RetType arg_result, RetType toType_result, List<Option<RetType>> subCoercions_result, Option<Option<RetType>> varargCoercion_result) {
        return forTupleCoercionInvocationOnly(that, arg_result, toType_result, subCoercions_result, varargCoercion_result);
    }

    public RetType for_SyntaxTransformationArrowCoercionInvocationOnly(_SyntaxTransformationArrowCoercionInvocation that, RetType arg_result, RetType toType_result, Option<RetType> domainCoercion_result, Option<RetType> rangeCoercion_result) {
        return forArrowCoercionInvocationOnly(that, arg_result, toType_result, domainCoercion_result, rangeCoercion_result);
    }

    public RetType for_SyntaxTransformationUnionCoercionInvocationOnly(_SyntaxTransformationUnionCoercionInvocation that, RetType toType_result, RetType arg_result, List<RetType> fromTypes_result, List<Option<RetType>> fromCoercions_result) {
        return forUnionCoercionInvocationOnly(that, toType_result, arg_result, fromTypes_result, fromCoercions_result);
    }

    public RetType for_SyntaxTransformationMethodInvocationOnly(_SyntaxTransformationMethodInvocation that, RetType obj_result, RetType method_result, List<RetType> staticArgs_result, RetType arg_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result) {
        return forMethodInvocationOnly(that, obj_result, method_result, staticArgs_result, arg_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType for_SyntaxTransformationMathPrimaryOnly(_SyntaxTransformationMathPrimary that, RetType multiJuxt_result, RetType infixJuxt_result, RetType front_result, List<RetType> rest_result) {
        return forMathPrimaryOnly(that, multiJuxt_result, infixJuxt_result, front_result, rest_result);
    }

    public RetType for_SyntaxTransformationArrayExprOnly(_SyntaxTransformationArrayExpr that, List<RetType> staticArgs_result) {
        return forArrayExprOnly(that, staticArgs_result);
    }

    public RetType for_SyntaxTransformationArrayElementOnly(_SyntaxTransformationArrayElement that, List<RetType> staticArgs_result, RetType element_result) {
        return forArrayElementOnly(that, staticArgs_result, element_result);
    }

    public RetType for_SyntaxTransformationArrayElementsOnly(_SyntaxTransformationArrayElements that, List<RetType> staticArgs_result, List<RetType> elements_result) {
        return forArrayElementsOnly(that, staticArgs_result, elements_result);
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

    public RetType for_SyntaxTransformationNamedTypeOnly(_SyntaxTransformationNamedType that, RetType name_result) {
        return forNamedTypeOnly(that, name_result);
    }

    public RetType for_SyntaxTransformation_InferenceVarTypeOnly(_SyntaxTransformation_InferenceVarType that, RetType name_result) {
        return for_InferenceVarTypeOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationVarTypeOnly(_SyntaxTransformationVarType that, RetType name_result) {
        return forVarTypeOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationTraitTypeOnly(_SyntaxTransformationTraitType that, RetType name_result, List<RetType> args_result, List<RetType> traitStaticParams_result) {
        return forTraitTypeOnly(that, name_result, args_result, traitStaticParams_result);
    }

    public RetType for_SyntaxTransformationAbbreviatedTypeOnly(_SyntaxTransformationAbbreviatedType that, RetType elemType_result) {
        return forAbbreviatedTypeOnly(that, elemType_result);
    }

    public RetType for_SyntaxTransformationArrayTypeOnly(_SyntaxTransformationArrayType that, RetType elemType_result, RetType indices_result) {
        return forArrayTypeOnly(that, elemType_result, indices_result);
    }

    public RetType for_SyntaxTransformationMatrixTypeOnly(_SyntaxTransformationMatrixType that, RetType elemType_result, List<RetType> dimensions_result) {
        return forMatrixTypeOnly(that, elemType_result, dimensions_result);
    }

    public RetType for_SyntaxTransformationTaggedDimTypeOnly(_SyntaxTransformationTaggedDimType that, RetType elemType_result, RetType dimExpr_result, Option<RetType> unitExpr_result) {
        return forTaggedDimTypeOnly(that, elemType_result, dimExpr_result, unitExpr_result);
    }

    public RetType for_SyntaxTransformationTaggedUnitTypeOnly(_SyntaxTransformationTaggedUnitType that, RetType elemType_result, RetType unitExpr_result) {
        return forTaggedUnitTypeOnly(that, elemType_result, unitExpr_result);
    }

    public RetType for_SyntaxTransformationTupleTypeOnly(_SyntaxTransformationTupleType that, List<RetType> elements_result, Option<RetType> varargs_result, List<RetType> keywords_result) {
        return forTupleTypeOnly(that, elements_result, varargs_result, keywords_result);
    }

    public RetType for_SyntaxTransformationArrowTypeOnly(_SyntaxTransformationArrowType that, RetType domain_result, RetType range_result, RetType effect_result) {
        return forArrowTypeOnly(that, domain_result, range_result, effect_result);
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

    public RetType for_SyntaxTransformationDimRefOnly(_SyntaxTransformationDimRef that, RetType name_result) {
        return forDimRefOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationDimExponentOnly(_SyntaxTransformationDimExponent that, RetType base_result, RetType power_result) {
        return forDimExponentOnly(that, base_result, power_result);
    }

    public RetType for_SyntaxTransformationDimUnaryOpOnly(_SyntaxTransformationDimUnaryOp that, RetType dimVal_result, RetType op_result) {
        return forDimUnaryOpOnly(that, dimVal_result, op_result);
    }

    public RetType for_SyntaxTransformationDimBinaryOpOnly(_SyntaxTransformationDimBinaryOp that, RetType left_result, RetType right_result, RetType op_result) {
        return forDimBinaryOpOnly(that, left_result, right_result, op_result);
    }

    public RetType for_SyntaxTransformationPatternOnly(_SyntaxTransformationPattern that, Option<RetType> name_result, RetType patterns_result) {
        return forPatternOnly(that, name_result, patterns_result);
    }

    public RetType for_SyntaxTransformationPatternArgsOnly(_SyntaxTransformationPatternArgs that, List<RetType> patterns_result) {
        return forPatternArgsOnly(that, patterns_result);
    }

    public RetType for_SyntaxTransformationPatternBindingOnly(_SyntaxTransformationPatternBinding that, Option<RetType> field_result) {
        return forPatternBindingOnly(that, field_result);
    }

    public RetType for_SyntaxTransformationPlainPatternOnly(_SyntaxTransformationPlainPattern that, Option<RetType> field_result, RetType name_result) {
        return forPlainPatternOnly(that, field_result, name_result);
    }

    public RetType for_SyntaxTransformationTypePatternOnly(_SyntaxTransformationTypePattern that, Option<RetType> field_result, RetType typ_result) {
        return forTypePatternOnly(that, field_result, typ_result);
    }

    public RetType for_SyntaxTransformationNestedPatternOnly(_SyntaxTransformationNestedPattern that, Option<RetType> field_result, RetType pat_result) {
        return forNestedPatternOnly(that, field_result, pat_result);
    }

    public RetType for_SyntaxTransformationStaticArgOnly(_SyntaxTransformationStaticArg that) {
        return forStaticArgOnly(that);
    }

    public RetType for_SyntaxTransformationTypeArgOnly(_SyntaxTransformationTypeArg that, RetType typeArg_result) {
        return forTypeArgOnly(that, typeArg_result);
    }

    public RetType for_SyntaxTransformationIntArgOnly(_SyntaxTransformationIntArg that, RetType intVal_result) {
        return forIntArgOnly(that, intVal_result);
    }

    public RetType for_SyntaxTransformationBoolArgOnly(_SyntaxTransformationBoolArg that, RetType boolArg_result) {
        return forBoolArgOnly(that, boolArg_result);
    }

    public RetType for_SyntaxTransformationOpArgOnly(_SyntaxTransformationOpArg that, RetType id_result) {
        return forOpArgOnly(that, id_result);
    }

    public RetType for_SyntaxTransformationDimArgOnly(_SyntaxTransformationDimArg that, RetType dimArg_result) {
        return forDimArgOnly(that, dimArg_result);
    }

    public RetType for_SyntaxTransformationUnitArgOnly(_SyntaxTransformationUnitArg that, RetType unitArg_result) {
        return forUnitArgOnly(that, unitArg_result);
    }

    public RetType for_SyntaxTransformationStaticExprOnly(_SyntaxTransformationStaticExpr that) {
        return forStaticExprOnly(that);
    }

    public RetType for_SyntaxTransformationIntExprOnly(_SyntaxTransformationIntExpr that) {
        return forIntExprOnly(that);
    }

    public RetType for_SyntaxTransformationIntBaseOnly(_SyntaxTransformationIntBase that, RetType intVal_result) {
        return forIntBaseOnly(that, intVal_result);
    }

    public RetType for_SyntaxTransformationIntRefOnly(_SyntaxTransformationIntRef that, RetType name_result) {
        return forIntRefOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationIntBinaryOpOnly(_SyntaxTransformationIntBinaryOp that, RetType left_result, RetType right_result, RetType op_result) {
        return forIntBinaryOpOnly(that, left_result, right_result, op_result);
    }

    public RetType for_SyntaxTransformationBoolExprOnly(_SyntaxTransformationBoolExpr that) {
        return forBoolExprOnly(that);
    }

    public RetType for_SyntaxTransformationBoolBaseOnly(_SyntaxTransformationBoolBase that) {
        return forBoolBaseOnly(that);
    }

    public RetType for_SyntaxTransformationBoolRefOnly(_SyntaxTransformationBoolRef that, RetType name_result) {
        return forBoolRefOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationBoolConstraintOnly(_SyntaxTransformationBoolConstraint that) {
        return forBoolConstraintOnly(that);
    }

    public RetType for_SyntaxTransformationBoolUnaryOpOnly(_SyntaxTransformationBoolUnaryOp that, RetType boolVal_result, RetType op_result) {
        return forBoolUnaryOpOnly(that, boolVal_result, op_result);
    }

    public RetType for_SyntaxTransformationBoolBinaryOpOnly(_SyntaxTransformationBoolBinaryOp that, RetType left_result, RetType right_result, RetType op_result) {
        return forBoolBinaryOpOnly(that, left_result, right_result, op_result);
    }

    public RetType for_SyntaxTransformationUnitExprOnly(_SyntaxTransformationUnitExpr that) {
        return forUnitExprOnly(that);
    }

    public RetType for_SyntaxTransformationUnitRefOnly(_SyntaxTransformationUnitRef that, RetType name_result) {
        return forUnitRefOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationUnitBinaryOpOnly(_SyntaxTransformationUnitBinaryOp that, RetType left_result, RetType right_result, RetType op_result) {
        return forUnitBinaryOpOnly(that, left_result, right_result, op_result);
    }

    public RetType for_SyntaxTransformationEffectOnly(_SyntaxTransformationEffect that, Option<List<RetType>> throwsClause_result) {
        return forEffectOnly(that, throwsClause_result);
    }

    public RetType for_SyntaxTransformationWhereClauseOnly(_SyntaxTransformationWhereClause that, List<RetType> bindings_result, List<RetType> constraints_result) {
        return forWhereClauseOnly(that, bindings_result, constraints_result);
    }

    public RetType for_SyntaxTransformationWhereBindingOnly(_SyntaxTransformationWhereBinding that, RetType name_result, List<RetType> supers_result) {
        return forWhereBindingOnly(that, name_result, supers_result);
    }

    public RetType for_SyntaxTransformationWhereConstraintOnly(_SyntaxTransformationWhereConstraint that) {
        return forWhereConstraintOnly(that);
    }

    public RetType for_SyntaxTransformationWhereExtendsOnly(_SyntaxTransformationWhereExtends that, RetType name_result, List<RetType> supers_result) {
        return forWhereExtendsOnly(that, name_result, supers_result);
    }

    public RetType for_SyntaxTransformationWhereTypeAliasOnly(_SyntaxTransformationWhereTypeAlias that, RetType alias_result) {
        return forWhereTypeAliasOnly(that, alias_result);
    }

    public RetType for_SyntaxTransformationWhereCoercesOnly(_SyntaxTransformationWhereCoerces that, RetType left_result, RetType right_result) {
        return forWhereCoercesOnly(that, left_result, right_result);
    }

    public RetType for_SyntaxTransformationWhereEqualsOnly(_SyntaxTransformationWhereEquals that, RetType left_result, RetType right_result) {
        return forWhereEqualsOnly(that, left_result, right_result);
    }

    public RetType for_SyntaxTransformationUnitConstraintOnly(_SyntaxTransformationUnitConstraint that, RetType name_result) {
        return forUnitConstraintOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationIntConstraintOnly(_SyntaxTransformationIntConstraint that, RetType left_result, RetType right_result, RetType op_result) {
        return forIntConstraintOnly(that, left_result, right_result, op_result);
    }

    public RetType for_SyntaxTransformationBoolConstraintExprOnly(_SyntaxTransformationBoolConstraintExpr that, RetType constraint_result) {
        return forBoolConstraintExprOnly(that, constraint_result);
    }

    public RetType for_SyntaxTransformationContractOnly(_SyntaxTransformationContract that, Option<List<RetType>> requiresClause_result, Option<List<RetType>> ensuresClause_result, Option<List<RetType>> invariantsClause_result) {
        return forContractOnly(that, requiresClause_result, ensuresClause_result, invariantsClause_result);
    }

    public RetType for_SyntaxTransformationEnsuresClauseOnly(_SyntaxTransformationEnsuresClause that, RetType post_result, Option<RetType> pre_result) {
        return forEnsuresClauseOnly(that, post_result, pre_result);
    }

    public RetType for_SyntaxTransformationStaticParamOnly(_SyntaxTransformationStaticParam that, RetType name_result, List<RetType> extendsClause_result, List<RetType> dominatesClause_result, Option<RetType> dimParam_result) {
        return forStaticParamOnly(that, name_result, extendsClause_result, dominatesClause_result, dimParam_result);
    }

    public RetType for_SyntaxTransformationNameOnly(_SyntaxTransformationName that) {
        return forNameOnly(that);
    }

    public RetType for_SyntaxTransformationAPINameOnly(_SyntaxTransformationAPIName that, List<RetType> ids_result) {
        return forAPINameOnly(that, ids_result);
    }

    public RetType for_SyntaxTransformationIdOrOpOrAnonymousNameOnly(_SyntaxTransformationIdOrOpOrAnonymousName that, Option<RetType> apiName_result) {
        return forIdOrOpOrAnonymousNameOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationIdOrOpOnly(_SyntaxTransformationIdOrOp that, Option<RetType> apiName_result) {
        return forIdOrOpOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationIdOnly(_SyntaxTransformationId that, Option<RetType> apiName_result) {
        return forIdOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationOpOnly(_SyntaxTransformationOp that, Option<RetType> apiName_result) {
        return forOpOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationNamedOpOnly(_SyntaxTransformationNamedOp that, Option<RetType> apiName_result) {
        return forNamedOpOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformation_InferenceVarOpOnly(_SyntaxTransformation_InferenceVarOp that, Option<RetType> apiName_result) {
        return for_InferenceVarOpOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationAnonymousNameOnly(_SyntaxTransformationAnonymousName that, Option<RetType> apiName_result) {
        return forAnonymousNameOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationAnonymousFnNameOnly(_SyntaxTransformationAnonymousFnName that, Option<RetType> apiName_result) {
        return forAnonymousFnNameOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationConstructorFnNameOnly(_SyntaxTransformationConstructorFnName that, Option<RetType> apiName_result) {
        return forConstructorFnNameOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationArrayComprehensionClauseOnly(_SyntaxTransformationArrayComprehensionClause that, List<RetType> bind_result, RetType init_result, List<RetType> gens_result) {
        return forArrayComprehensionClauseOnly(that, bind_result, init_result, gens_result);
    }

    public RetType for_SyntaxTransformationKeywordExprOnly(_SyntaxTransformationKeywordExpr that, RetType name_result, RetType init_result) {
        return forKeywordExprOnly(that, name_result, init_result);
    }

    public RetType for_SyntaxTransformationCaseClauseOnly(_SyntaxTransformationCaseClause that, RetType matchClause_result, RetType body_result, Option<RetType> op_result) {
        return forCaseClauseOnly(that, matchClause_result, body_result, op_result);
    }

    public RetType for_SyntaxTransformationCatchOnly(_SyntaxTransformationCatch that, RetType name_result, List<RetType> clauses_result) {
        return forCatchOnly(that, name_result, clauses_result);
    }

    public RetType for_SyntaxTransformationCatchClauseOnly(_SyntaxTransformationCatchClause that, RetType matchType_result, RetType body_result) {
        return forCatchClauseOnly(that, matchType_result, body_result);
    }

    public RetType for_SyntaxTransformationIfClauseOnly(_SyntaxTransformationIfClause that, RetType testClause_result, RetType body_result) {
        return forIfClauseOnly(that, testClause_result, body_result);
    }

    public RetType for_SyntaxTransformationTypecaseClauseOnly(_SyntaxTransformationTypecaseClause that, Option<RetType> name_result, RetType body_result) {
        return forTypecaseClauseOnly(that, name_result, body_result);
    }

    public RetType for_SyntaxTransformationExtentRangeOnly(_SyntaxTransformationExtentRange that, Option<RetType> base_result, Option<RetType> size_result, Option<RetType> op_result) {
        return forExtentRangeOnly(that, base_result, size_result, op_result);
    }

    public RetType for_SyntaxTransformationGeneratorClauseOnly(_SyntaxTransformationGeneratorClause that, List<RetType> bind_result, RetType init_result) {
        return forGeneratorClauseOnly(that, bind_result, init_result);
    }

    public RetType for_SyntaxTransformationKeywordTypeOnly(_SyntaxTransformationKeywordType that, RetType name_result, RetType keywordType_result) {
        return forKeywordTypeOnly(that, name_result, keywordType_result);
    }

    public RetType for_SyntaxTransformationTraitTypeWhereOnly(_SyntaxTransformationTraitTypeWhere that, RetType baseType_result, Option<RetType> whereClause_result) {
        return forTraitTypeWhereOnly(that, baseType_result, whereClause_result);
    }

    public RetType for_SyntaxTransformationIndicesOnly(_SyntaxTransformationIndices that, List<RetType> extents_result) {
        return forIndicesOnly(that, extents_result);
    }

    public RetType for_SyntaxTransformationMathItemOnly(_SyntaxTransformationMathItem that) {
        return forMathItemOnly(that);
    }

    public RetType for_SyntaxTransformationExprMIOnly(_SyntaxTransformationExprMI that, RetType expr_result) {
        return forExprMIOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationParenthesisDelimitedMIOnly(_SyntaxTransformationParenthesisDelimitedMI that, RetType expr_result) {
        return forParenthesisDelimitedMIOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationNonParenthesisDelimitedMIOnly(_SyntaxTransformationNonParenthesisDelimitedMI that, RetType expr_result) {
        return forNonParenthesisDelimitedMIOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationNonExprMIOnly(_SyntaxTransformationNonExprMI that) {
        return forNonExprMIOnly(that);
    }

    public RetType for_SyntaxTransformationExponentiationMIOnly(_SyntaxTransformationExponentiationMI that, RetType op_result, Option<RetType> expr_result) {
        return forExponentiationMIOnly(that, op_result, expr_result);
    }

    public RetType for_SyntaxTransformationSubscriptingMIOnly(_SyntaxTransformationSubscriptingMI that, RetType op_result, List<RetType> exprs_result, List<RetType> staticArgs_result) {
        return forSubscriptingMIOnly(that, op_result, exprs_result, staticArgs_result);
    }

    public RetType for_SyntaxTransformationOverloadingOnly(_SyntaxTransformationOverloading that, RetType unambiguousName_result, RetType originalName_result, Option<RetType> type_result, Option<RetType> schema_result) {
        return forOverloadingOnly(that, unambiguousName_result, originalName_result, type_result, schema_result);
    }

    public RetType for_SyntaxTransformationNonterminalHeaderOnly(_SyntaxTransformationNonterminalHeader that, RetType name_result, List<RetType> params_result, List<RetType> staticParams_result, Option<RetType> paramType_result, Option<RetType> whereClause_result) {
        return forNonterminalHeaderOnly(that, name_result, params_result, staticParams_result, paramType_result, whereClause_result);
    }

    public RetType for_SyntaxTransformationNonterminalParameterOnly(_SyntaxTransformationNonterminalParameter that, RetType name_result, RetType paramType_result) {
        return forNonterminalParameterOnly(that, name_result, paramType_result);
    }

    public RetType for_SyntaxTransformationSyntaxDeclOnly(_SyntaxTransformationSyntaxDecl that) {
        return forSyntaxDeclOnly(that);
    }

    public RetType for_SyntaxTransformationSyntaxDefOnly(_SyntaxTransformationSyntaxDef that, List<RetType> syntaxSymbols_result, RetType transformer_result) {
        return forSyntaxDefOnly(that, syntaxSymbols_result, transformer_result);
    }

    public RetType for_SyntaxTransformationSuperSyntaxDefOnly(_SyntaxTransformationSuperSyntaxDef that, RetType nonterminal_result, RetType grammarId_result) {
        return forSuperSyntaxDefOnly(that, nonterminal_result, grammarId_result);
    }

    public RetType for_SyntaxTransformationTransformerDeclOnly(_SyntaxTransformationTransformerDecl that) {
        return forTransformerDeclOnly(that);
    }

    public RetType for_SyntaxTransformationPreTransformerDefOnly(_SyntaxTransformationPreTransformerDef that, RetType transformer_result) {
        return forPreTransformerDefOnly(that, transformer_result);
    }

    public RetType for_SyntaxTransformationNamedTransformerDefOnly(_SyntaxTransformationNamedTransformerDef that, List<RetType> parameters_result, RetType transformer_result) {
        return forNamedTransformerDefOnly(that, parameters_result, transformer_result);
    }

    public RetType for_SyntaxTransformationTransformerOnly(_SyntaxTransformationTransformer that) {
        return forTransformerOnly(that);
    }

    public RetType for_SyntaxTransformationUnparsedTransformerOnly(_SyntaxTransformationUnparsedTransformer that, RetType nonterminal_result) {
        return forUnparsedTransformerOnly(that, nonterminal_result);
    }

    public RetType for_SyntaxTransformationNodeTransformerOnly(_SyntaxTransformationNodeTransformer that, RetType node_result) {
        return forNodeTransformerOnly(that, node_result);
    }

    public RetType for_SyntaxTransformationCaseTransformerOnly(_SyntaxTransformationCaseTransformer that, RetType gapName_result, List<RetType> clauses_result) {
        return forCaseTransformerOnly(that, gapName_result, clauses_result);
    }

    public RetType for_SyntaxTransformationCaseTransformerClauseOnly(_SyntaxTransformationCaseTransformerClause that, RetType constructor_result, List<RetType> parameters_result, RetType body_result) {
        return forCaseTransformerClauseOnly(that, constructor_result, parameters_result, body_result);
    }

    public RetType for_SyntaxTransformationSyntaxSymbolOnly(_SyntaxTransformationSyntaxSymbol that) {
        return forSyntaxSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationPrefixedSymbolOnly(_SyntaxTransformationPrefixedSymbol that, RetType id_result, RetType symbol_result) {
        return forPrefixedSymbolOnly(that, id_result, symbol_result);
    }

    public RetType for_SyntaxTransformationOptionalSymbolOnly(_SyntaxTransformationOptionalSymbol that, RetType symbol_result) {
        return forOptionalSymbolOnly(that, symbol_result);
    }

    public RetType for_SyntaxTransformationRepeatSymbolOnly(_SyntaxTransformationRepeatSymbol that, RetType symbol_result) {
        return forRepeatSymbolOnly(that, symbol_result);
    }

    public RetType for_SyntaxTransformationRepeatOneOrMoreSymbolOnly(_SyntaxTransformationRepeatOneOrMoreSymbol that, RetType symbol_result) {
        return forRepeatOneOrMoreSymbolOnly(that, symbol_result);
    }

    public RetType for_SyntaxTransformationNoWhitespaceSymbolOnly(_SyntaxTransformationNoWhitespaceSymbol that, RetType symbol_result) {
        return forNoWhitespaceSymbolOnly(that, symbol_result);
    }

    public RetType for_SyntaxTransformationGroupSymbolOnly(_SyntaxTransformationGroupSymbol that, List<RetType> symbols_result) {
        return forGroupSymbolOnly(that, symbols_result);
    }

    public RetType for_SyntaxTransformationSpecialSymbolOnly(_SyntaxTransformationSpecialSymbol that) {
        return forSpecialSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationAnyCharacterSymbolOnly(_SyntaxTransformationAnyCharacterSymbol that) {
        return forAnyCharacterSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationWhitespaceSymbolOnly(_SyntaxTransformationWhitespaceSymbol that) {
        return forWhitespaceSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationTabSymbolOnly(_SyntaxTransformationTabSymbol that) {
        return forTabSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationFormfeedSymbolOnly(_SyntaxTransformationFormfeedSymbol that) {
        return forFormfeedSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationCarriageReturnSymbolOnly(_SyntaxTransformationCarriageReturnSymbol that) {
        return forCarriageReturnSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationBackspaceSymbolOnly(_SyntaxTransformationBackspaceSymbol that) {
        return forBackspaceSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationNewlineSymbolOnly(_SyntaxTransformationNewlineSymbol that) {
        return forNewlineSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationBreaklineSymbolOnly(_SyntaxTransformationBreaklineSymbol that) {
        return forBreaklineSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationItemSymbolOnly(_SyntaxTransformationItemSymbol that) {
        return forItemSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationNonterminalSymbolOnly(_SyntaxTransformationNonterminalSymbol that, RetType nonterminal_result) {
        return forNonterminalSymbolOnly(that, nonterminal_result);
    }

    public RetType for_SyntaxTransformationKeywordSymbolOnly(_SyntaxTransformationKeywordSymbol that) {
        return forKeywordSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationTokenSymbolOnly(_SyntaxTransformationTokenSymbol that) {
        return forTokenSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationNotPredicateSymbolOnly(_SyntaxTransformationNotPredicateSymbol that, RetType symbol_result) {
        return forNotPredicateSymbolOnly(that, symbol_result);
    }

    public RetType for_SyntaxTransformationAndPredicateSymbolOnly(_SyntaxTransformationAndPredicateSymbol that, RetType symbol_result) {
        return forAndPredicateSymbolOnly(that, symbol_result);
    }

    public RetType for_SyntaxTransformationCharacterClassSymbolOnly(_SyntaxTransformationCharacterClassSymbol that, List<RetType> characters_result) {
        return forCharacterClassSymbolOnly(that, characters_result);
    }

    public RetType for_SyntaxTransformationCharacterSymbolOnly(_SyntaxTransformationCharacterSymbol that) {
        return forCharacterSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationCharSymbolOnly(_SyntaxTransformationCharSymbol that) {
        return forCharSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationCharacterIntervalOnly(_SyntaxTransformationCharacterInterval that) {
        return forCharacterIntervalOnly(that);
    }

    public RetType for_SyntaxTransformationLinkOnly(_SyntaxTransformationLink that, RetType op_result, RetType expr_result) {
        return forLinkOnly(that, op_result, expr_result);
    }


    /** Methods to recur on each child. */
    public RetType forComponent(Component that) {
        RetType name_result = recur(that.getName());
        List<RetType> imports_result = recurOnListOfImport(that.getImports());
        List<RetType> decls_result = recurOnListOfDecl(that.getDecls());
        List<RetType> comprises_result = recurOnListOfAPIName(that.getComprises());
        List<RetType> exports_result = recurOnListOfAPIName(that.getExports());
        return forComponentOnly(that, name_result, imports_result, decls_result, comprises_result, exports_result);
    }

    public RetType forApi(Api that) {
        RetType name_result = recur(that.getName());
        List<RetType> imports_result = recurOnListOfImport(that.getImports());
        List<RetType> decls_result = recurOnListOfDecl(that.getDecls());
        List<RetType> comprises_result = recurOnListOfAPIName(that.getComprises());
        return forApiOnly(that, name_result, imports_result, decls_result, comprises_result);
    }

    public RetType forImportStar(ImportStar that) {
        RetType apiName_result = recur(that.getApiName());
        List<RetType> exceptNames_result = recurOnListOfIdOrOpOrAnonymousName(that.getExceptNames());
        return forImportStarOnly(that, apiName_result, exceptNames_result);
    }

    public RetType forImportNames(ImportNames that) {
        RetType apiName_result = recur(that.getApiName());
        List<RetType> aliasedNames_result = recurOnListOfAliasedSimpleName(that.getAliasedNames());
        return forImportNamesOnly(that, apiName_result, aliasedNames_result);
    }

    public RetType forImportApi(ImportApi that) {
        List<RetType> apis_result = recurOnListOfAliasedAPIName(that.getApis());
        return forImportApiOnly(that, apis_result);
    }

    public RetType forAliasedSimpleName(AliasedSimpleName that) {
        RetType name_result = recur(that.getName());
        Option<RetType> alias_result = recurOnOptionOfIdOrOpOrAnonymousName(that.getAlias());
        return forAliasedSimpleNameOnly(that, name_result, alias_result);
    }

    public RetType forAliasedAPIName(AliasedAPIName that) {
        RetType apiName_result = recur(that.getApiName());
        Option<RetType> alias_result = recurOnOptionOfId(that.getAlias());
        return forAliasedAPINameOnly(that, apiName_result, alias_result);
    }

    public RetType forTraitDecl(TraitDecl that) {
        Option<RetType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        List<RetType> excludesClause_result = recurOnListOfBaseType(that.getExcludesClause());
        Option<List<RetType>> comprisesClause_result = recurOnOptionOfListOfNamedType(that.getComprisesClause());
        return forTraitDeclOnly(that, selfType_result, excludesClause_result, comprisesClause_result);
    }

    public RetType forObjectDecl(ObjectDecl that) {
        Option<RetType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        return forObjectDeclOnly(that, selfType_result);
    }

    public RetType forVarDecl(VarDecl that) {
        List<RetType> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<RetType> init_result = recurOnOptionOfExpr(that.getInit());
        return forVarDeclOnly(that, lhs_result, init_result);
    }

    public RetType forFnDecl(FnDecl that) {
        RetType unambiguousName_result = recur(that.getUnambiguousName());
        Option<RetType> body_result = recurOnOptionOfExpr(that.getBody());
        Option<RetType> implementsUnambiguousName_result = recurOnOptionOfIdOrOp(that.getImplementsUnambiguousName());
        return forFnDeclOnly(that, unambiguousName_result, body_result, implementsUnambiguousName_result);
    }

    public RetType for_RewriteFnOverloadDecl(_RewriteFnOverloadDecl that) {
        RetType name_result = recur(that.getName());
        List<RetType> fns_result = recurOnListOfIdOrOp(that.getFns());
        Option<RetType> type_result = recurOnOptionOfType(that.getType());
        return for_RewriteFnOverloadDeclOnly(that, name_result, fns_result, type_result);
    }

    public RetType for_RewriteObjectExprDecl(_RewriteObjectExprDecl that) {
        List<RetType> objectExprs_result = recurOnListOf_RewriteObjectExpr(that.getObjectExprs());
        return for_RewriteObjectExprDeclOnly(that, objectExprs_result);
    }

    public RetType for_RewriteFunctionalMethodDecl(_RewriteFunctionalMethodDecl that) {
        return for_RewriteFunctionalMethodDeclOnly(that);
    }

    public RetType forDimDecl(DimDecl that) {
        RetType dimId_result = recur(that.getDimId());
        Option<RetType> derived_result = recurOnOptionOfType(that.getDerived());
        Option<RetType> defaultId_result = recurOnOptionOfId(that.getDefaultId());
        return forDimDeclOnly(that, dimId_result, derived_result, defaultId_result);
    }

    public RetType forUnitDecl(UnitDecl that) {
        List<RetType> units_result = recurOnListOfId(that.getUnits());
        Option<RetType> dimType_result = recurOnOptionOfType(that.getDimType());
        Option<RetType> defExpr_result = recurOnOptionOfExpr(that.getDefExpr());
        return forUnitDeclOnly(that, units_result, dimType_result, defExpr_result);
    }

    public RetType forTestDecl(TestDecl that) {
        RetType name_result = recur(that.getName());
        List<RetType> gens_result = recurOnListOfGeneratorClause(that.getGens());
        RetType expr_result = recur(that.getExpr());
        return forTestDeclOnly(that, name_result, gens_result, expr_result);
    }

    public RetType forPropertyDecl(PropertyDecl that) {
        Option<RetType> name_result = recurOnOptionOfId(that.getName());
        List<RetType> params_result = recurOnListOfParam(that.getParams());
        RetType expr_result = recur(that.getExpr());
        return forPropertyDeclOnly(that, name_result, params_result, expr_result);
    }

    public RetType forTypeAlias(TypeAlias that) {
        RetType name_result = recur(that.getName());
        List<RetType> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        RetType typeDef_result = recur(that.getTypeDef());
        return forTypeAliasOnly(that, name_result, staticParams_result, typeDef_result);
    }

    public RetType forGrammarDecl(GrammarDecl that) {
        RetType name_result = recur(that.getName());
        List<RetType> extendsClause_result = recurOnListOfId(that.getExtendsClause());
        List<RetType> members_result = recurOnListOfGrammarMemberDecl(that.getMembers());
        List<RetType> transformers_result = recurOnListOfTransformerDecl(that.getTransformers());
        return forGrammarDeclOnly(that, name_result, extendsClause_result, members_result, transformers_result);
    }

    public RetType forNonterminalDef(NonterminalDef that) {
        RetType name_result = recur(that.getName());
        List<RetType> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        RetType header_result = recur(that.getHeader());
        Option<RetType> astType_result = recurOnOptionOfBaseType(that.getAstType());
        return forNonterminalDefOnly(that, name_result, syntaxDecls_result, header_result, astType_result);
    }

    public RetType forNonterminalExtensionDef(NonterminalExtensionDef that) {
        RetType name_result = recur(that.getName());
        List<RetType> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        return forNonterminalExtensionDefOnly(that, name_result, syntaxDecls_result);
    }

    public RetType forLValue(LValue that) {
        RetType name_result = recur(that.getName());
        return forLValueOnly(that, name_result);
    }

    public RetType forParam(Param that) {
        RetType name_result = recur(that.getName());
        Option<RetType> defaultExpr_result = recurOnOptionOfExpr(that.getDefaultExpr());
        Option<RetType> varargsType_result = recurOnOptionOfType(that.getVarargsType());
        return forParamOnly(that, name_result, defaultExpr_result, varargsType_result);
    }

    public RetType forDummyExpr(DummyExpr that) {
        return forDummyExprOnly(that);
    }

    public RetType forAsExpr(AsExpr that) {
        RetType expr_result = recur(that.getExpr());
        RetType annType_result = recur(that.getAnnType());
        return forAsExprOnly(that, expr_result, annType_result);
    }

    public RetType forAsIfExpr(AsIfExpr that) {
        RetType expr_result = recur(that.getExpr());
        RetType annType_result = recur(that.getAnnType());
        return forAsIfExprOnly(that, expr_result, annType_result);
    }

    public RetType forAssignment(Assignment that) {
        Option<RetType> assignOp_result = recurOnOptionOfFunctionalRef(that.getAssignOp());
        RetType rhs_result = recur(that.getRhs());
        return forAssignmentOnly(that, assignOp_result, rhs_result);
    }

    public RetType forBlock(Block that) {
        Option<RetType> loc_result = recurOnOptionOfExpr(that.getLoc());
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        return forBlockOnly(that, loc_result, exprs_result);
    }

    public RetType forDo(Do that) {
        List<RetType> fronts_result = recurOnListOfBlock(that.getFronts());
        return forDoOnly(that, fronts_result);
    }

    public RetType forCaseExpr(CaseExpr that) {
        Option<RetType> param_result = recurOnOptionOfExpr(that.getParam());
        Option<RetType> compare_result = recurOnOptionOfFunctionalRef(that.getCompare());
        RetType equalsOp_result = recur(that.getEqualsOp());
        RetType inOp_result = recur(that.getInOp());
        List<RetType> clauses_result = recurOnListOfCaseClause(that.getClauses());
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forCaseExprOnly(that, param_result, compare_result, equalsOp_result, inOp_result, clauses_result, elseClause_result);
    }

    public RetType forIf(If that) {
        List<RetType> clauses_result = recurOnListOfIfClause(that.getClauses());
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forIfOnly(that, clauses_result, elseClause_result);
    }

    public RetType forLabel(Label that) {
        RetType name_result = recur(that.getName());
        RetType body_result = recur(that.getBody());
        return forLabelOnly(that, name_result, body_result);
    }

    public RetType forObjectExpr(ObjectExpr that) {
        Option<RetType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        return forObjectExprOnly(that, selfType_result);
    }

    public RetType for_RewriteObjectExpr(_RewriteObjectExpr that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_RewriteObjectExprOnly(that, staticArgs_result);
    }

    public RetType forTry(Try that) {
        RetType body_result = recur(that.getBody());
        Option<RetType> catchClause_result = recurOnOptionOfCatch(that.getCatchClause());
        List<RetType> forbidClause_result = recurOnListOfBaseType(that.getForbidClause());
        Option<RetType> finallyClause_result = recurOnOptionOfBlock(that.getFinallyClause());
        return forTryOnly(that, body_result, catchClause_result, forbidClause_result, finallyClause_result);
    }

    public RetType forTupleExpr(TupleExpr that) {
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        Option<RetType> varargs_result = recurOnOptionOfExpr(that.getVarargs());
        List<RetType> keywords_result = recurOnListOfKeywordExpr(that.getKeywords());
        return forTupleExprOnly(that, exprs_result, varargs_result, keywords_result);
    }

    public RetType forTypecase(Typecase that) {
        RetType bindExpr_result = recur(that.getBindExpr());
        List<RetType> clauses_result = recurOnListOfTypecaseClause(that.getClauses());
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forTypecaseOnly(that, bindExpr_result, clauses_result, elseClause_result);
    }

    public RetType forWhile(While that) {
        RetType testExpr_result = recur(that.getTestExpr());
        RetType body_result = recur(that.getBody());
        return forWhileOnly(that, testExpr_result, body_result);
    }

    public RetType forFor(For that) {
        List<RetType> gens_result = recurOnListOfGeneratorClause(that.getGens());
        RetType body_result = recur(that.getBody());
        return forForOnly(that, gens_result, body_result);
    }

    public RetType forAccumulator(Accumulator that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType accOp_result = recur(that.getAccOp());
        List<RetType> gens_result = recurOnListOfGeneratorClause(that.getGens());
        RetType body_result = recur(that.getBody());
        return forAccumulatorOnly(that, staticArgs_result, accOp_result, gens_result, body_result);
    }

    public RetType forArrayComprehension(ArrayComprehension that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<RetType> clauses_result = recurOnListOfArrayComprehensionClause(that.getClauses());
        return forArrayComprehensionOnly(that, staticArgs_result, clauses_result);
    }

    public RetType forAtomicExpr(AtomicExpr that) {
        RetType expr_result = recur(that.getExpr());
        return forAtomicExprOnly(that, expr_result);
    }

    public RetType forExit(Exit that) {
        Option<RetType> target_result = recurOnOptionOfId(that.getTarget());
        Option<RetType> returnExpr_result = recurOnOptionOfExpr(that.getReturnExpr());
        return forExitOnly(that, target_result, returnExpr_result);
    }

    public RetType forSpawn(Spawn that) {
        RetType body_result = recur(that.getBody());
        return forSpawnOnly(that, body_result);
    }

    public RetType forThrow(Throw that) {
        RetType expr_result = recur(that.getExpr());
        return forThrowOnly(that, expr_result);
    }

    public RetType forTryAtomicExpr(TryAtomicExpr that) {
        RetType expr_result = recur(that.getExpr());
        return forTryAtomicExprOnly(that, expr_result);
    }

    public RetType forFnExpr(FnExpr that) {
        RetType body_result = recur(that.getBody());
        return forFnExprOnly(that, body_result);
    }

    public RetType forLetFn(LetFn that) {
        RetType body_result = recur(that.getBody());
        List<RetType> fns_result = recurOnListOfFnDecl(that.getFns());
        return forLetFnOnly(that, body_result, fns_result);
    }

    public RetType forLocalVarDecl(LocalVarDecl that) {
        RetType body_result = recur(that.getBody());
        List<RetType> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<RetType> rhs_result = recurOnOptionOfExpr(that.getRhs());
        return forLocalVarDeclOnly(that, body_result, lhs_result, rhs_result);
    }

    public RetType forSubscriptExpr(SubscriptExpr that) {
        RetType obj_result = recur(that.getObj());
        List<RetType> subs_result = recurOnListOfExpr(that.getSubs());
        Option<RetType> op_result = recurOnOptionOfOp(that.getOp());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return forSubscriptExprOnly(that, obj_result, subs_result, op_result, staticArgs_result);
    }

    public RetType forFloatLiteralExpr(FloatLiteralExpr that) {
        return forFloatLiteralExprOnly(that);
    }

    public RetType forIntLiteralExpr(IntLiteralExpr that) {
        return forIntLiteralExprOnly(that);
    }

    public RetType forCharLiteralExpr(CharLiteralExpr that) {
        return forCharLiteralExprOnly(that);
    }

    public RetType forStringLiteralExpr(StringLiteralExpr that) {
        return forStringLiteralExprOnly(that);
    }

    public RetType forVoidLiteralExpr(VoidLiteralExpr that) {
        return forVoidLiteralExprOnly(that);
    }

    public RetType forBooleanLiteralExpr(BooleanLiteralExpr that) {
        return forBooleanLiteralExprOnly(that);
    }

    public RetType forVarRef(VarRef that) {
        RetType varId_result = recur(that.getVarId());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return forVarRefOnly(that, varId_result, staticArgs_result);
    }

    public RetType forFieldRef(FieldRef that) {
        RetType obj_result = recur(that.getObj());
        RetType field_result = recur(that.getField());
        return forFieldRefOnly(that, obj_result, field_result);
    }

    public RetType forFnRef(FnRef that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType originalName_result = recur(that.getOriginalName());
        List<RetType> names_result = recurOnListOfIdOrOp(that.getNames());
        List<RetType> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<RetType> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<RetType> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<RetType> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return forFnRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType forOpRef(OpRef that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType originalName_result = recur(that.getOriginalName());
        List<RetType> names_result = recurOnListOfIdOrOp(that.getNames());
        List<RetType> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<RetType> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<RetType> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<RetType> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return forOpRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType for_RewriteFnRef(_RewriteFnRef that) {
        RetType fnExpr_result = recur(that.getFnExpr());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_RewriteFnRefOnly(that, fnExpr_result, staticArgs_result);
    }

    public RetType for_RewriteObjectExprRef(_RewriteObjectExprRef that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_RewriteObjectExprRefOnly(that, staticArgs_result);
    }

    public RetType forJuxt(Juxt that) {
        RetType multiJuxt_result = recur(that.getMultiJuxt());
        RetType infixJuxt_result = recur(that.getInfixJuxt());
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        return forJuxtOnly(that, multiJuxt_result, infixJuxt_result, exprs_result);
    }

    public RetType for_RewriteFnApp(_RewriteFnApp that) {
        RetType function_result = recur(that.getFunction());
        RetType argument_result = recur(that.getArgument());
        return for_RewriteFnAppOnly(that, function_result, argument_result);
    }

    public RetType forOpExpr(OpExpr that) {
        RetType op_result = recur(that.getOp());
        List<RetType> args_result = recurOnListOfExpr(that.getArgs());
        return forOpExprOnly(that, op_result, args_result);
    }

    public RetType forAmbiguousMultifixOpExpr(AmbiguousMultifixOpExpr that) {
        RetType infix_op_result = recur(that.getInfix_op());
        RetType multifix_op_result = recur(that.getMultifix_op());
        List<RetType> args_result = recurOnListOfExpr(that.getArgs());
        return forAmbiguousMultifixOpExprOnly(that, infix_op_result, multifix_op_result, args_result);
    }

    public RetType forChainExpr(ChainExpr that) {
        RetType first_result = recur(that.getFirst());
        List<RetType> links_result = recurOnListOfLink(that.getLinks());
        return forChainExprOnly(that, first_result, links_result);
    }

    public RetType forTraitCoercionInvocation(TraitCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        RetType toType_result = recur(that.getToType());
        RetType coercionFn_result = recur(that.getCoercionFn());
        return forTraitCoercionInvocationOnly(that, arg_result, toType_result, coercionFn_result);
    }

    public RetType forTupleCoercionInvocation(TupleCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        RetType toType_result = recur(that.getToType());
        List<Option<RetType>> subCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getSubCoercions());
        Option<Option<RetType>> varargCoercion_result = recurOnOptionOfOptionOfCoercionInvocation(that.getVarargCoercion());
        return forTupleCoercionInvocationOnly(that, arg_result, toType_result, subCoercions_result, varargCoercion_result);
    }

    public RetType forArrowCoercionInvocation(ArrowCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        RetType toType_result = recur(that.getToType());
        Option<RetType> domainCoercion_result = recurOnOptionOfCoercionInvocation(that.getDomainCoercion());
        Option<RetType> rangeCoercion_result = recurOnOptionOfCoercionInvocation(that.getRangeCoercion());
        return forArrowCoercionInvocationOnly(that, arg_result, toType_result, domainCoercion_result, rangeCoercion_result);
    }

    public RetType forUnionCoercionInvocation(UnionCoercionInvocation that) {
        RetType toType_result = recur(that.getToType());
        RetType arg_result = recur(that.getArg());
        List<RetType> fromTypes_result = recurOnListOfType(that.getFromTypes());
        List<Option<RetType>> fromCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getFromCoercions());
        return forUnionCoercionInvocationOnly(that, toType_result, arg_result, fromTypes_result, fromCoercions_result);
    }

    public RetType forMethodInvocation(MethodInvocation that) {
        RetType obj_result = recur(that.getObj());
        RetType method_result = recur(that.getMethod());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType arg_result = recur(that.getArg());
        Option<RetType> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<RetType> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return forMethodInvocationOnly(that, obj_result, method_result, staticArgs_result, arg_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType forMathPrimary(MathPrimary that) {
        RetType multiJuxt_result = recur(that.getMultiJuxt());
        RetType infixJuxt_result = recur(that.getInfixJuxt());
        RetType front_result = recur(that.getFront());
        List<RetType> rest_result = recurOnListOfMathItem(that.getRest());
        return forMathPrimaryOnly(that, multiJuxt_result, infixJuxt_result, front_result, rest_result);
    }

    public RetType forArrayElement(ArrayElement that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType element_result = recur(that.getElement());
        return forArrayElementOnly(that, staticArgs_result, element_result);
    }

    public RetType forArrayElements(ArrayElements that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<RetType> elements_result = recurOnListOfArrayExpr(that.getElements());
        return forArrayElementsOnly(that, staticArgs_result, elements_result);
    }

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
        RetType name_result = recur(that.getName());
        return for_InferenceVarTypeOnly(that, name_result);
    }

    public RetType forVarType(VarType that) {
        RetType name_result = recur(that.getName());
        return forVarTypeOnly(that, name_result);
    }

    public RetType forTraitType(TraitType that) {
        RetType name_result = recur(that.getName());
        List<RetType> args_result = recurOnListOfStaticArg(that.getArgs());
        List<RetType> traitStaticParams_result = recurOnListOfStaticParam(that.getTraitStaticParams());
        return forTraitTypeOnly(that, name_result, args_result, traitStaticParams_result);
    }

    public RetType forArrayType(ArrayType that) {
        RetType elemType_result = recur(that.getElemType());
        RetType indices_result = recur(that.getIndices());
        return forArrayTypeOnly(that, elemType_result, indices_result);
    }

    public RetType forMatrixType(MatrixType that) {
        RetType elemType_result = recur(that.getElemType());
        List<RetType> dimensions_result = recurOnListOfExtentRange(that.getDimensions());
        return forMatrixTypeOnly(that, elemType_result, dimensions_result);
    }

    public RetType forTaggedDimType(TaggedDimType that) {
        RetType elemType_result = recur(that.getElemType());
        RetType dimExpr_result = recur(that.getDimExpr());
        Option<RetType> unitExpr_result = recurOnOptionOfExpr(that.getUnitExpr());
        return forTaggedDimTypeOnly(that, elemType_result, dimExpr_result, unitExpr_result);
    }

    public RetType forTaggedUnitType(TaggedUnitType that) {
        RetType elemType_result = recur(that.getElemType());
        RetType unitExpr_result = recur(that.getUnitExpr());
        return forTaggedUnitTypeOnly(that, elemType_result, unitExpr_result);
    }

    public RetType forTupleType(TupleType that) {
        List<RetType> elements_result = recurOnListOfType(that.getElements());
        Option<RetType> varargs_result = recurOnOptionOfType(that.getVarargs());
        List<RetType> keywords_result = recurOnListOfKeywordType(that.getKeywords());
        return forTupleTypeOnly(that, elements_result, varargs_result, keywords_result);
    }

    public RetType forArrowType(ArrowType that) {
        RetType domain_result = recur(that.getDomain());
        RetType range_result = recur(that.getRange());
        RetType effect_result = recur(that.getEffect());
        return forArrowTypeOnly(that, domain_result, range_result, effect_result);
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
        RetType name_result = recur(that.getName());
        return forDimRefOnly(that, name_result);
    }

    public RetType forDimExponent(DimExponent that) {
        RetType base_result = recur(that.getBase());
        RetType power_result = recur(that.getPower());
        return forDimExponentOnly(that, base_result, power_result);
    }

    public RetType forDimUnaryOp(DimUnaryOp that) {
        RetType dimVal_result = recur(that.getDimVal());
        RetType op_result = recur(that.getOp());
        return forDimUnaryOpOnly(that, dimVal_result, op_result);
    }

    public RetType forDimBinaryOp(DimBinaryOp that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        return forDimBinaryOpOnly(that, left_result, right_result, op_result);
    }

    public RetType forPattern(Pattern that) {
        Option<RetType> name_result = recurOnOptionOfType(that.getName());
        RetType patterns_result = recur(that.getPatterns());
        return forPatternOnly(that, name_result, patterns_result);
    }

    public RetType forPatternArgs(PatternArgs that) {
        List<RetType> patterns_result = recurOnListOfPatternBinding(that.getPatterns());
        return forPatternArgsOnly(that, patterns_result);
    }

    public RetType forPlainPattern(PlainPattern that) {
        Option<RetType> field_result = recurOnOptionOfId(that.getField());
        RetType name_result = recur(that.getName());
        return forPlainPatternOnly(that, field_result, name_result);
    }

    public RetType forTypePattern(TypePattern that) {
        Option<RetType> field_result = recurOnOptionOfId(that.getField());
        RetType typ_result = recur(that.getTyp());
        return forTypePatternOnly(that, field_result, typ_result);
    }

    public RetType forNestedPattern(NestedPattern that) {
        Option<RetType> field_result = recurOnOptionOfId(that.getField());
        RetType pat_result = recur(that.getPat());
        return forNestedPatternOnly(that, field_result, pat_result);
    }

    public RetType forTypeArg(TypeArg that) {
        RetType typeArg_result = recur(that.getTypeArg());
        return forTypeArgOnly(that, typeArg_result);
    }

    public RetType forIntArg(IntArg that) {
        RetType intVal_result = recur(that.getIntVal());
        return forIntArgOnly(that, intVal_result);
    }

    public RetType forBoolArg(BoolArg that) {
        RetType boolArg_result = recur(that.getBoolArg());
        return forBoolArgOnly(that, boolArg_result);
    }

    public RetType forOpArg(OpArg that) {
        RetType id_result = recur(that.getId());
        return forOpArgOnly(that, id_result);
    }

    public RetType forDimArg(DimArg that) {
        RetType dimArg_result = recur(that.getDimArg());
        return forDimArgOnly(that, dimArg_result);
    }

    public RetType forUnitArg(UnitArg that) {
        RetType unitArg_result = recur(that.getUnitArg());
        return forUnitArgOnly(that, unitArg_result);
    }

    public RetType forIntBase(IntBase that) {
        RetType intVal_result = recur(that.getIntVal());
        return forIntBaseOnly(that, intVal_result);
    }

    public RetType forIntRef(IntRef that) {
        RetType name_result = recur(that.getName());
        return forIntRefOnly(that, name_result);
    }

    public RetType forIntBinaryOp(IntBinaryOp that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        return forIntBinaryOpOnly(that, left_result, right_result, op_result);
    }

    public RetType forBoolBase(BoolBase that) {
        return forBoolBaseOnly(that);
    }

    public RetType forBoolRef(BoolRef that) {
        RetType name_result = recur(that.getName());
        return forBoolRefOnly(that, name_result);
    }

    public RetType forBoolUnaryOp(BoolUnaryOp that) {
        RetType boolVal_result = recur(that.getBoolVal());
        RetType op_result = recur(that.getOp());
        return forBoolUnaryOpOnly(that, boolVal_result, op_result);
    }

    public RetType forBoolBinaryOp(BoolBinaryOp that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        return forBoolBinaryOpOnly(that, left_result, right_result, op_result);
    }

    public RetType forUnitRef(UnitRef that) {
        RetType name_result = recur(that.getName());
        return forUnitRefOnly(that, name_result);
    }

    public RetType forUnitBinaryOp(UnitBinaryOp that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        return forUnitBinaryOpOnly(that, left_result, right_result, op_result);
    }

    public RetType forEffect(Effect that) {
        Option<List<RetType>> throwsClause_result = recurOnOptionOfListOfType(that.getThrowsClause());
        return forEffectOnly(that, throwsClause_result);
    }

    public RetType forWhereClause(WhereClause that) {
        List<RetType> bindings_result = recurOnListOfWhereBinding(that.getBindings());
        List<RetType> constraints_result = recurOnListOfWhereConstraint(that.getConstraints());
        return forWhereClauseOnly(that, bindings_result, constraints_result);
    }

    public RetType forWhereBinding(WhereBinding that) {
        RetType name_result = recur(that.getName());
        List<RetType> supers_result = recurOnListOfBaseType(that.getSupers());
        return forWhereBindingOnly(that, name_result, supers_result);
    }

    public RetType forWhereExtends(WhereExtends that) {
        RetType name_result = recur(that.getName());
        List<RetType> supers_result = recurOnListOfBaseType(that.getSupers());
        return forWhereExtendsOnly(that, name_result, supers_result);
    }

    public RetType forWhereTypeAlias(WhereTypeAlias that) {
        RetType alias_result = recur(that.getAlias());
        return forWhereTypeAliasOnly(that, alias_result);
    }

    public RetType forWhereCoerces(WhereCoerces that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        return forWhereCoercesOnly(that, left_result, right_result);
    }

    public RetType forWhereEquals(WhereEquals that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        return forWhereEqualsOnly(that, left_result, right_result);
    }

    public RetType forUnitConstraint(UnitConstraint that) {
        RetType name_result = recur(that.getName());
        return forUnitConstraintOnly(that, name_result);
    }

    public RetType forIntConstraint(IntConstraint that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        return forIntConstraintOnly(that, left_result, right_result, op_result);
    }

    public RetType forBoolConstraintExpr(BoolConstraintExpr that) {
        RetType constraint_result = recur(that.getConstraint());
        return forBoolConstraintExprOnly(that, constraint_result);
    }

    public RetType forContract(Contract that) {
        Option<List<RetType>> requiresClause_result = recurOnOptionOfListOfExpr(that.getRequiresClause());
        Option<List<RetType>> ensuresClause_result = recurOnOptionOfListOfEnsuresClause(that.getEnsuresClause());
        Option<List<RetType>> invariantsClause_result = recurOnOptionOfListOfExpr(that.getInvariantsClause());
        return forContractOnly(that, requiresClause_result, ensuresClause_result, invariantsClause_result);
    }

    public RetType forEnsuresClause(EnsuresClause that) {
        RetType post_result = recur(that.getPost());
        Option<RetType> pre_result = recurOnOptionOfExpr(that.getPre());
        return forEnsuresClauseOnly(that, post_result, pre_result);
    }

    public RetType forStaticParam(StaticParam that) {
        RetType name_result = recur(that.getName());
        List<RetType> extendsClause_result = recurOnListOfBaseType(that.getExtendsClause());
        List<RetType> dominatesClause_result = recurOnListOfBaseType(that.getDominatesClause());
        Option<RetType> dimParam_result = recurOnOptionOfType(that.getDimParam());
        return forStaticParamOnly(that, name_result, extendsClause_result, dominatesClause_result, dimParam_result);
    }

    public RetType forAPIName(APIName that) {
        List<RetType> ids_result = recurOnListOfId(that.getIds());
        return forAPINameOnly(that, ids_result);
    }

    public RetType forId(Id that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return forIdOnly(that, apiName_result);
    }

    public RetType forNamedOp(NamedOp that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return forNamedOpOnly(that, apiName_result);
    }

    public RetType for_InferenceVarOp(_InferenceVarOp that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return for_InferenceVarOpOnly(that, apiName_result);
    }

    public RetType forAnonymousFnName(AnonymousFnName that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return forAnonymousFnNameOnly(that, apiName_result);
    }

    public RetType forConstructorFnName(ConstructorFnName that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return forConstructorFnNameOnly(that, apiName_result);
    }

    public RetType forArrayComprehensionClause(ArrayComprehensionClause that) {
        List<RetType> bind_result = recurOnListOfExpr(that.getBind());
        RetType init_result = recur(that.getInit());
        List<RetType> gens_result = recurOnListOfGeneratorClause(that.getGens());
        return forArrayComprehensionClauseOnly(that, bind_result, init_result, gens_result);
    }

    public RetType forKeywordExpr(KeywordExpr that) {
        RetType name_result = recur(that.getName());
        RetType init_result = recur(that.getInit());
        return forKeywordExprOnly(that, name_result, init_result);
    }

    public RetType forCaseClause(CaseClause that) {
        RetType matchClause_result = recur(that.getMatchClause());
        RetType body_result = recur(that.getBody());
        Option<RetType> op_result = recurOnOptionOfFunctionalRef(that.getOp());
        return forCaseClauseOnly(that, matchClause_result, body_result, op_result);
    }

    public RetType forCatch(Catch that) {
        RetType name_result = recur(that.getName());
        List<RetType> clauses_result = recurOnListOfCatchClause(that.getClauses());
        return forCatchOnly(that, name_result, clauses_result);
    }

    public RetType forCatchClause(CatchClause that) {
        RetType matchType_result = recur(that.getMatchType());
        RetType body_result = recur(that.getBody());
        return forCatchClauseOnly(that, matchType_result, body_result);
    }

    public RetType forIfClause(IfClause that) {
        RetType testClause_result = recur(that.getTestClause());
        RetType body_result = recur(that.getBody());
        return forIfClauseOnly(that, testClause_result, body_result);
    }

    public RetType forTypecaseClause(TypecaseClause that) {
        Option<RetType> name_result = recurOnOptionOfId(that.getName());
        RetType body_result = recur(that.getBody());
        return forTypecaseClauseOnly(that, name_result, body_result);
    }

    public RetType forExtentRange(ExtentRange that) {
        Option<RetType> base_result = recurOnOptionOfStaticArg(that.getBase());
        Option<RetType> size_result = recurOnOptionOfStaticArg(that.getSize());
        Option<RetType> op_result = recurOnOptionOfOp(that.getOp());
        return forExtentRangeOnly(that, base_result, size_result, op_result);
    }

    public RetType forGeneratorClause(GeneratorClause that) {
        List<RetType> bind_result = recurOnListOfId(that.getBind());
        RetType init_result = recur(that.getInit());
        return forGeneratorClauseOnly(that, bind_result, init_result);
    }

    public RetType forKeywordType(KeywordType that) {
        RetType name_result = recur(that.getName());
        RetType keywordType_result = recur(that.getKeywordType());
        return forKeywordTypeOnly(that, name_result, keywordType_result);
    }

    public RetType forTraitTypeWhere(TraitTypeWhere that) {
        RetType baseType_result = recur(that.getBaseType());
        Option<RetType> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        return forTraitTypeWhereOnly(that, baseType_result, whereClause_result);
    }

    public RetType forIndices(Indices that) {
        List<RetType> extents_result = recurOnListOfExtentRange(that.getExtents());
        return forIndicesOnly(that, extents_result);
    }

    public RetType forParenthesisDelimitedMI(ParenthesisDelimitedMI that) {
        RetType expr_result = recur(that.getExpr());
        return forParenthesisDelimitedMIOnly(that, expr_result);
    }

    public RetType forNonParenthesisDelimitedMI(NonParenthesisDelimitedMI that) {
        RetType expr_result = recur(that.getExpr());
        return forNonParenthesisDelimitedMIOnly(that, expr_result);
    }

    public RetType forExponentiationMI(ExponentiationMI that) {
        RetType op_result = recur(that.getOp());
        Option<RetType> expr_result = recurOnOptionOfExpr(that.getExpr());
        return forExponentiationMIOnly(that, op_result, expr_result);
    }

    public RetType forSubscriptingMI(SubscriptingMI that) {
        RetType op_result = recur(that.getOp());
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return forSubscriptingMIOnly(that, op_result, exprs_result, staticArgs_result);
    }

    public RetType forOverloading(Overloading that) {
        RetType unambiguousName_result = recur(that.getUnambiguousName());
        RetType originalName_result = recur(that.getOriginalName());
        Option<RetType> type_result = recurOnOptionOfArrowType(that.getType());
        Option<RetType> schema_result = recurOnOptionOfArrowType(that.getSchema());
        return forOverloadingOnly(that, unambiguousName_result, originalName_result, type_result, schema_result);
    }

    public RetType forNonterminalHeader(NonterminalHeader that) {
        RetType name_result = recur(that.getName());
        List<RetType> params_result = recurOnListOfNonterminalParameter(that.getParams());
        List<RetType> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        Option<RetType> paramType_result = recurOnOptionOfType(that.getParamType());
        Option<RetType> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        return forNonterminalHeaderOnly(that, name_result, params_result, staticParams_result, paramType_result, whereClause_result);
    }

    public RetType forNonterminalParameter(NonterminalParameter that) {
        RetType name_result = recur(that.getName());
        RetType paramType_result = recur(that.getParamType());
        return forNonterminalParameterOnly(that, name_result, paramType_result);
    }

    public RetType forSyntaxDef(SyntaxDef that) {
        List<RetType> syntaxSymbols_result = recurOnListOfSyntaxSymbol(that.getSyntaxSymbols());
        RetType transformer_result = recur(that.getTransformer());
        return forSyntaxDefOnly(that, syntaxSymbols_result, transformer_result);
    }

    public RetType forSuperSyntaxDef(SuperSyntaxDef that) {
        RetType nonterminal_result = recur(that.getNonterminal());
        RetType grammarId_result = recur(that.getGrammarId());
        return forSuperSyntaxDefOnly(that, nonterminal_result, grammarId_result);
    }

    public RetType forPreTransformerDef(PreTransformerDef that) {
        RetType transformer_result = recur(that.getTransformer());
        return forPreTransformerDefOnly(that, transformer_result);
    }

    public RetType forNamedTransformerDef(NamedTransformerDef that) {
        List<RetType> parameters_result = recurOnListOfNonterminalParameter(that.getParameters());
        RetType transformer_result = recur(that.getTransformer());
        return forNamedTransformerDefOnly(that, parameters_result, transformer_result);
    }

    public RetType forUnparsedTransformer(UnparsedTransformer that) {
        RetType nonterminal_result = recur(that.getNonterminal());
        return forUnparsedTransformerOnly(that, nonterminal_result);
    }

    public RetType forNodeTransformer(NodeTransformer that) {
        RetType node_result = recur(that.getNode());
        return forNodeTransformerOnly(that, node_result);
    }

    public RetType forCaseTransformer(CaseTransformer that) {
        RetType gapName_result = recur(that.getGapName());
        List<RetType> clauses_result = recurOnListOfCaseTransformerClause(that.getClauses());
        return forCaseTransformerOnly(that, gapName_result, clauses_result);
    }

    public RetType forCaseTransformerClause(CaseTransformerClause that) {
        RetType constructor_result = recur(that.getConstructor());
        List<RetType> parameters_result = recurOnListOfId(that.getParameters());
        RetType body_result = recur(that.getBody());
        return forCaseTransformerClauseOnly(that, constructor_result, parameters_result, body_result);
    }

    public RetType forPrefixedSymbol(PrefixedSymbol that) {
        RetType id_result = recur(that.getId());
        RetType symbol_result = recur(that.getSymbol());
        return forPrefixedSymbolOnly(that, id_result, symbol_result);
    }

    public RetType forOptionalSymbol(OptionalSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        return forOptionalSymbolOnly(that, symbol_result);
    }

    public RetType forRepeatSymbol(RepeatSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        return forRepeatSymbolOnly(that, symbol_result);
    }

    public RetType forRepeatOneOrMoreSymbol(RepeatOneOrMoreSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        return forRepeatOneOrMoreSymbolOnly(that, symbol_result);
    }

    public RetType forNoWhitespaceSymbol(NoWhitespaceSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        return forNoWhitespaceSymbolOnly(that, symbol_result);
    }

    public RetType forGroupSymbol(GroupSymbol that) {
        List<RetType> symbols_result = recurOnListOfSyntaxSymbol(that.getSymbols());
        return forGroupSymbolOnly(that, symbols_result);
    }

    public RetType forAnyCharacterSymbol(AnyCharacterSymbol that) {
        return forAnyCharacterSymbolOnly(that);
    }

    public RetType forWhitespaceSymbol(WhitespaceSymbol that) {
        return forWhitespaceSymbolOnly(that);
    }

    public RetType forTabSymbol(TabSymbol that) {
        return forTabSymbolOnly(that);
    }

    public RetType forFormfeedSymbol(FormfeedSymbol that) {
        return forFormfeedSymbolOnly(that);
    }

    public RetType forCarriageReturnSymbol(CarriageReturnSymbol that) {
        return forCarriageReturnSymbolOnly(that);
    }

    public RetType forBackspaceSymbol(BackspaceSymbol that) {
        return forBackspaceSymbolOnly(that);
    }

    public RetType forNewlineSymbol(NewlineSymbol that) {
        return forNewlineSymbolOnly(that);
    }

    public RetType forBreaklineSymbol(BreaklineSymbol that) {
        return forBreaklineSymbolOnly(that);
    }

    public RetType forItemSymbol(ItemSymbol that) {
        return forItemSymbolOnly(that);
    }

    public RetType forNonterminalSymbol(NonterminalSymbol that) {
        RetType nonterminal_result = recur(that.getNonterminal());
        return forNonterminalSymbolOnly(that, nonterminal_result);
    }

    public RetType forKeywordSymbol(KeywordSymbol that) {
        return forKeywordSymbolOnly(that);
    }

    public RetType forTokenSymbol(TokenSymbol that) {
        return forTokenSymbolOnly(that);
    }

    public RetType forNotPredicateSymbol(NotPredicateSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        return forNotPredicateSymbolOnly(that, symbol_result);
    }

    public RetType forAndPredicateSymbol(AndPredicateSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        return forAndPredicateSymbolOnly(that, symbol_result);
    }

    public RetType forCharacterClassSymbol(CharacterClassSymbol that) {
        List<RetType> characters_result = recurOnListOfCharacterSymbol(that.getCharacters());
        return forCharacterClassSymbolOnly(that, characters_result);
    }

    public RetType forCharSymbol(CharSymbol that) {
        return forCharSymbolOnly(that);
    }

    public RetType forCharacterInterval(CharacterInterval that) {
        return forCharacterIntervalOnly(that);
    }

    public RetType forLink(Link that) {
        RetType op_result = recur(that.getOp());
        RetType expr_result = recur(that.getExpr());
        return forLinkOnly(that, op_result, expr_result);
    }

    public RetType for_SyntaxTransformationAbstractNode(_SyntaxTransformationAbstractNode that) {
        return for_SyntaxTransformationAbstractNodeOnly(that);
    }

    public RetType for_SyntaxTransformationCompilationUnit(_SyntaxTransformationCompilationUnit that) {
        RetType name_result = recur(that.getName());
        List<RetType> imports_result = recurOnListOfImport(that.getImports());
        List<RetType> decls_result = recurOnListOfDecl(that.getDecls());
        List<RetType> comprises_result = recurOnListOfAPIName(that.getComprises());
        return for_SyntaxTransformationCompilationUnitOnly(that, name_result, imports_result, decls_result, comprises_result);
    }

    public RetType for_SyntaxTransformationComponent(_SyntaxTransformationComponent that) {
        RetType name_result = recur(that.getName());
        List<RetType> imports_result = recurOnListOfImport(that.getImports());
        List<RetType> decls_result = recurOnListOfDecl(that.getDecls());
        List<RetType> comprises_result = recurOnListOfAPIName(that.getComprises());
        List<RetType> exports_result = recurOnListOfAPIName(that.getExports());
        return for_SyntaxTransformationComponentOnly(that, name_result, imports_result, decls_result, comprises_result, exports_result);
    }

    public RetType for_SyntaxTransformationApi(_SyntaxTransformationApi that) {
        RetType name_result = recur(that.getName());
        List<RetType> imports_result = recurOnListOfImport(that.getImports());
        List<RetType> decls_result = recurOnListOfDecl(that.getDecls());
        List<RetType> comprises_result = recurOnListOfAPIName(that.getComprises());
        return for_SyntaxTransformationApiOnly(that, name_result, imports_result, decls_result, comprises_result);
    }

    public RetType for_SyntaxTransformationImport(_SyntaxTransformationImport that) {
        return for_SyntaxTransformationImportOnly(that);
    }

    public RetType for_SyntaxTransformationImportedNames(_SyntaxTransformationImportedNames that) {
        RetType apiName_result = recur(that.getApiName());
        return for_SyntaxTransformationImportedNamesOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationImportStar(_SyntaxTransformationImportStar that) {
        RetType apiName_result = recur(that.getApiName());
        List<RetType> exceptNames_result = recurOnListOfIdOrOpOrAnonymousName(that.getExceptNames());
        return for_SyntaxTransformationImportStarOnly(that, apiName_result, exceptNames_result);
    }

    public RetType for_SyntaxTransformationImportNames(_SyntaxTransformationImportNames that) {
        RetType apiName_result = recur(that.getApiName());
        List<RetType> aliasedNames_result = recurOnListOfAliasedSimpleName(that.getAliasedNames());
        return for_SyntaxTransformationImportNamesOnly(that, apiName_result, aliasedNames_result);
    }

    public RetType for_SyntaxTransformationImportApi(_SyntaxTransformationImportApi that) {
        List<RetType> apis_result = recurOnListOfAliasedAPIName(that.getApis());
        return for_SyntaxTransformationImportApiOnly(that, apis_result);
    }

    public RetType for_SyntaxTransformationAliasedSimpleName(_SyntaxTransformationAliasedSimpleName that) {
        RetType name_result = recur(that.getName());
        Option<RetType> alias_result = recurOnOptionOfIdOrOpOrAnonymousName(that.getAlias());
        return for_SyntaxTransformationAliasedSimpleNameOnly(that, name_result, alias_result);
    }

    public RetType for_SyntaxTransformationAliasedAPIName(_SyntaxTransformationAliasedAPIName that) {
        RetType apiName_result = recur(that.getApiName());
        Option<RetType> alias_result = recurOnOptionOfId(that.getAlias());
        return for_SyntaxTransformationAliasedAPINameOnly(that, apiName_result, alias_result);
    }

    public RetType for_SyntaxTransformationDecl(_SyntaxTransformationDecl that) {
        return for_SyntaxTransformationDeclOnly(that);
    }

    public RetType for_SyntaxTransformationTraitObjectDecl(_SyntaxTransformationTraitObjectDecl that) {
        Option<RetType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        return for_SyntaxTransformationTraitObjectDeclOnly(that, selfType_result);
    }

    public RetType for_SyntaxTransformationTraitDecl(_SyntaxTransformationTraitDecl that) {
        Option<RetType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        List<RetType> excludesClause_result = recurOnListOfBaseType(that.getExcludesClause());
        Option<List<RetType>> comprisesClause_result = recurOnOptionOfListOfNamedType(that.getComprisesClause());
        return for_SyntaxTransformationTraitDeclOnly(that, selfType_result, excludesClause_result, comprisesClause_result);
    }

    public RetType for_SyntaxTransformationObjectDecl(_SyntaxTransformationObjectDecl that) {
        Option<RetType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        return for_SyntaxTransformationObjectDeclOnly(that, selfType_result);
    }

    public RetType for_SyntaxTransformationVarDecl(_SyntaxTransformationVarDecl that) {
        List<RetType> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<RetType> init_result = recurOnOptionOfExpr(that.getInit());
        return for_SyntaxTransformationVarDeclOnly(that, lhs_result, init_result);
    }

    public RetType for_SyntaxTransformationFnDecl(_SyntaxTransformationFnDecl that) {
        RetType unambiguousName_result = recur(that.getUnambiguousName());
        Option<RetType> body_result = recurOnOptionOfExpr(that.getBody());
        Option<RetType> implementsUnambiguousName_result = recurOnOptionOfIdOrOp(that.getImplementsUnambiguousName());
        return for_SyntaxTransformationFnDeclOnly(that, unambiguousName_result, body_result, implementsUnambiguousName_result);
    }

    public RetType for_SyntaxTransformation_RewriteFnOverloadDecl(_SyntaxTransformation_RewriteFnOverloadDecl that) {
        RetType name_result = recur(that.getName());
        List<RetType> fns_result = recurOnListOfIdOrOp(that.getFns());
        Option<RetType> type_result = recurOnOptionOfType(that.getType());
        return for_SyntaxTransformation_RewriteFnOverloadDeclOnly(that, name_result, fns_result, type_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprDecl(_SyntaxTransformation_RewriteObjectExprDecl that) {
        List<RetType> objectExprs_result = recurOnListOf_RewriteObjectExpr(that.getObjectExprs());
        return for_SyntaxTransformation_RewriteObjectExprDeclOnly(that, objectExprs_result);
    }

    public RetType for_SyntaxTransformation_RewriteFunctionalMethodDecl(_SyntaxTransformation_RewriteFunctionalMethodDecl that) {
        return for_SyntaxTransformation_RewriteFunctionalMethodDeclOnly(that);
    }

    public RetType for_SyntaxTransformationDimUnitDecl(_SyntaxTransformationDimUnitDecl that) {
        return for_SyntaxTransformationDimUnitDeclOnly(that);
    }

    public RetType for_SyntaxTransformationDimDecl(_SyntaxTransformationDimDecl that) {
        RetType dimId_result = recur(that.getDimId());
        Option<RetType> derived_result = recurOnOptionOfType(that.getDerived());
        Option<RetType> defaultId_result = recurOnOptionOfId(that.getDefaultId());
        return for_SyntaxTransformationDimDeclOnly(that, dimId_result, derived_result, defaultId_result);
    }

    public RetType for_SyntaxTransformationUnitDecl(_SyntaxTransformationUnitDecl that) {
        List<RetType> units_result = recurOnListOfId(that.getUnits());
        Option<RetType> dimType_result = recurOnOptionOfType(that.getDimType());
        Option<RetType> defExpr_result = recurOnOptionOfExpr(that.getDefExpr());
        return for_SyntaxTransformationUnitDeclOnly(that, units_result, dimType_result, defExpr_result);
    }

    public RetType for_SyntaxTransformationTestDecl(_SyntaxTransformationTestDecl that) {
        RetType name_result = recur(that.getName());
        List<RetType> gens_result = recurOnListOfGeneratorClause(that.getGens());
        RetType expr_result = recur(that.getExpr());
        return for_SyntaxTransformationTestDeclOnly(that, name_result, gens_result, expr_result);
    }

    public RetType for_SyntaxTransformationPropertyDecl(_SyntaxTransformationPropertyDecl that) {
        Option<RetType> name_result = recurOnOptionOfId(that.getName());
        List<RetType> params_result = recurOnListOfParam(that.getParams());
        RetType expr_result = recur(that.getExpr());
        return for_SyntaxTransformationPropertyDeclOnly(that, name_result, params_result, expr_result);
    }

    public RetType for_SyntaxTransformationTypeAlias(_SyntaxTransformationTypeAlias that) {
        RetType name_result = recur(that.getName());
        List<RetType> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        RetType typeDef_result = recur(that.getTypeDef());
        return for_SyntaxTransformationTypeAliasOnly(that, name_result, staticParams_result, typeDef_result);
    }

    public RetType for_SyntaxTransformationGrammarDecl(_SyntaxTransformationGrammarDecl that) {
        RetType name_result = recur(that.getName());
        List<RetType> extendsClause_result = recurOnListOfId(that.getExtendsClause());
        List<RetType> members_result = recurOnListOfGrammarMemberDecl(that.getMembers());
        List<RetType> transformers_result = recurOnListOfTransformerDecl(that.getTransformers());
        return for_SyntaxTransformationGrammarDeclOnly(that, name_result, extendsClause_result, members_result, transformers_result);
    }

    public RetType for_SyntaxTransformationGrammarMemberDecl(_SyntaxTransformationGrammarMemberDecl that) {
        RetType name_result = recur(that.getName());
        return for_SyntaxTransformationGrammarMemberDeclOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationNonterminalDecl(_SyntaxTransformationNonterminalDecl that) {
        RetType name_result = recur(that.getName());
        List<RetType> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        return for_SyntaxTransformationNonterminalDeclOnly(that, name_result, syntaxDecls_result);
    }

    public RetType for_SyntaxTransformationNonterminalDef(_SyntaxTransformationNonterminalDef that) {
        RetType name_result = recur(that.getName());
        List<RetType> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        RetType header_result = recur(that.getHeader());
        Option<RetType> astType_result = recurOnOptionOfBaseType(that.getAstType());
        return for_SyntaxTransformationNonterminalDefOnly(that, name_result, syntaxDecls_result, header_result, astType_result);
    }

    public RetType for_SyntaxTransformationNonterminalExtensionDef(_SyntaxTransformationNonterminalExtensionDef that) {
        RetType name_result = recur(that.getName());
        List<RetType> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        return for_SyntaxTransformationNonterminalExtensionDefOnly(that, name_result, syntaxDecls_result);
    }

    public RetType for_SyntaxTransformationBinding(_SyntaxTransformationBinding that) {
        RetType name_result = recur(that.getName());
        return for_SyntaxTransformationBindingOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationLValue(_SyntaxTransformationLValue that) {
        RetType name_result = recur(that.getName());
        return for_SyntaxTransformationLValueOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationParam(_SyntaxTransformationParam that) {
        RetType name_result = recur(that.getName());
        Option<RetType> defaultExpr_result = recurOnOptionOfExpr(that.getDefaultExpr());
        Option<RetType> varargsType_result = recurOnOptionOfType(that.getVarargsType());
        return for_SyntaxTransformationParamOnly(that, name_result, defaultExpr_result, varargsType_result);
    }

    public RetType for_SyntaxTransformationExpr(_SyntaxTransformationExpr that) {
        return for_SyntaxTransformationExprOnly(that);
    }

    public RetType for_SyntaxTransformationDummyExpr(_SyntaxTransformationDummyExpr that) {
        return for_SyntaxTransformationDummyExprOnly(that);
    }

    public RetType for_SyntaxTransformationTypeAnnotatedExpr(_SyntaxTransformationTypeAnnotatedExpr that) {
        RetType expr_result = recur(that.getExpr());
        RetType annType_result = recur(that.getAnnType());
        return for_SyntaxTransformationTypeAnnotatedExprOnly(that, expr_result, annType_result);
    }

    public RetType for_SyntaxTransformationAsExpr(_SyntaxTransformationAsExpr that) {
        RetType expr_result = recur(that.getExpr());
        RetType annType_result = recur(that.getAnnType());
        return for_SyntaxTransformationAsExprOnly(that, expr_result, annType_result);
    }

    public RetType for_SyntaxTransformationAsIfExpr(_SyntaxTransformationAsIfExpr that) {
        RetType expr_result = recur(that.getExpr());
        RetType annType_result = recur(that.getAnnType());
        return for_SyntaxTransformationAsIfExprOnly(that, expr_result, annType_result);
    }

    public RetType for_SyntaxTransformationAssignment(_SyntaxTransformationAssignment that) {
        Option<RetType> assignOp_result = recurOnOptionOfFunctionalRef(that.getAssignOp());
        RetType rhs_result = recur(that.getRhs());
        return for_SyntaxTransformationAssignmentOnly(that, assignOp_result, rhs_result);
    }

    public RetType for_SyntaxTransformationBlock(_SyntaxTransformationBlock that) {
        Option<RetType> loc_result = recurOnOptionOfExpr(that.getLoc());
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        return for_SyntaxTransformationBlockOnly(that, loc_result, exprs_result);
    }

    public RetType for_SyntaxTransformationDo(_SyntaxTransformationDo that) {
        List<RetType> fronts_result = recurOnListOfBlock(that.getFronts());
        return for_SyntaxTransformationDoOnly(that, fronts_result);
    }

    public RetType for_SyntaxTransformationCaseExpr(_SyntaxTransformationCaseExpr that) {
        Option<RetType> param_result = recurOnOptionOfExpr(that.getParam());
        Option<RetType> compare_result = recurOnOptionOfFunctionalRef(that.getCompare());
        RetType equalsOp_result = recur(that.getEqualsOp());
        RetType inOp_result = recur(that.getInOp());
        List<RetType> clauses_result = recurOnListOfCaseClause(that.getClauses());
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return for_SyntaxTransformationCaseExprOnly(that, param_result, compare_result, equalsOp_result, inOp_result, clauses_result, elseClause_result);
    }

    public RetType for_SyntaxTransformationIf(_SyntaxTransformationIf that) {
        List<RetType> clauses_result = recurOnListOfIfClause(that.getClauses());
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return for_SyntaxTransformationIfOnly(that, clauses_result, elseClause_result);
    }

    public RetType for_SyntaxTransformationLabel(_SyntaxTransformationLabel that) {
        RetType name_result = recur(that.getName());
        RetType body_result = recur(that.getBody());
        return for_SyntaxTransformationLabelOnly(that, name_result, body_result);
    }

    public RetType for_SyntaxTransformationAbstractObjectExpr(_SyntaxTransformationAbstractObjectExpr that) {
        return for_SyntaxTransformationAbstractObjectExprOnly(that);
    }

    public RetType for_SyntaxTransformationObjectExpr(_SyntaxTransformationObjectExpr that) {
        Option<RetType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        return for_SyntaxTransformationObjectExprOnly(that, selfType_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExpr(_SyntaxTransformation_RewriteObjectExpr that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_SyntaxTransformation_RewriteObjectExprOnly(that, staticArgs_result);
    }

    public RetType for_SyntaxTransformationTry(_SyntaxTransformationTry that) {
        RetType body_result = recur(that.getBody());
        Option<RetType> catchClause_result = recurOnOptionOfCatch(that.getCatchClause());
        List<RetType> forbidClause_result = recurOnListOfBaseType(that.getForbidClause());
        Option<RetType> finallyClause_result = recurOnOptionOfBlock(that.getFinallyClause());
        return for_SyntaxTransformationTryOnly(that, body_result, catchClause_result, forbidClause_result, finallyClause_result);
    }

    public RetType for_SyntaxTransformationTupleExpr(_SyntaxTransformationTupleExpr that) {
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        Option<RetType> varargs_result = recurOnOptionOfExpr(that.getVarargs());
        List<RetType> keywords_result = recurOnListOfKeywordExpr(that.getKeywords());
        return for_SyntaxTransformationTupleExprOnly(that, exprs_result, varargs_result, keywords_result);
    }

    public RetType for_SyntaxTransformationTypecase(_SyntaxTransformationTypecase that) {
        RetType bindExpr_result = recur(that.getBindExpr());
        List<RetType> clauses_result = recurOnListOfTypecaseClause(that.getClauses());
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return for_SyntaxTransformationTypecaseOnly(that, bindExpr_result, clauses_result, elseClause_result);
    }

    public RetType for_SyntaxTransformationWhile(_SyntaxTransformationWhile that) {
        RetType testExpr_result = recur(that.getTestExpr());
        RetType body_result = recur(that.getBody());
        return for_SyntaxTransformationWhileOnly(that, testExpr_result, body_result);
    }

    public RetType for_SyntaxTransformationFor(_SyntaxTransformationFor that) {
        List<RetType> gens_result = recurOnListOfGeneratorClause(that.getGens());
        RetType body_result = recur(that.getBody());
        return for_SyntaxTransformationForOnly(that, gens_result, body_result);
    }

    public RetType for_SyntaxTransformationBigOpApp(_SyntaxTransformationBigOpApp that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_SyntaxTransformationBigOpAppOnly(that, staticArgs_result);
    }

    public RetType for_SyntaxTransformationAccumulator(_SyntaxTransformationAccumulator that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType accOp_result = recur(that.getAccOp());
        List<RetType> gens_result = recurOnListOfGeneratorClause(that.getGens());
        RetType body_result = recur(that.getBody());
        return for_SyntaxTransformationAccumulatorOnly(that, staticArgs_result, accOp_result, gens_result, body_result);
    }

    public RetType for_SyntaxTransformationArrayComprehension(_SyntaxTransformationArrayComprehension that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<RetType> clauses_result = recurOnListOfArrayComprehensionClause(that.getClauses());
        return for_SyntaxTransformationArrayComprehensionOnly(that, staticArgs_result, clauses_result);
    }

    public RetType for_SyntaxTransformationAtomicExpr(_SyntaxTransformationAtomicExpr that) {
        RetType expr_result = recur(that.getExpr());
        return for_SyntaxTransformationAtomicExprOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationExit(_SyntaxTransformationExit that) {
        Option<RetType> target_result = recurOnOptionOfId(that.getTarget());
        Option<RetType> returnExpr_result = recurOnOptionOfExpr(that.getReturnExpr());
        return for_SyntaxTransformationExitOnly(that, target_result, returnExpr_result);
    }

    public RetType for_SyntaxTransformationSpawn(_SyntaxTransformationSpawn that) {
        RetType body_result = recur(that.getBody());
        return for_SyntaxTransformationSpawnOnly(that, body_result);
    }

    public RetType for_SyntaxTransformationThrow(_SyntaxTransformationThrow that) {
        RetType expr_result = recur(that.getExpr());
        return for_SyntaxTransformationThrowOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationTryAtomicExpr(_SyntaxTransformationTryAtomicExpr that) {
        RetType expr_result = recur(that.getExpr());
        return for_SyntaxTransformationTryAtomicExprOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationFnExpr(_SyntaxTransformationFnExpr that) {
        RetType body_result = recur(that.getBody());
        return for_SyntaxTransformationFnExprOnly(that, body_result);
    }

    public RetType for_SyntaxTransformationLetExpr(_SyntaxTransformationLetExpr that) {
        RetType body_result = recur(that.getBody());
        return for_SyntaxTransformationLetExprOnly(that, body_result);
    }

    public RetType for_SyntaxTransformationLetFn(_SyntaxTransformationLetFn that) {
        RetType body_result = recur(that.getBody());
        List<RetType> fns_result = recurOnListOfFnDecl(that.getFns());
        return for_SyntaxTransformationLetFnOnly(that, body_result, fns_result);
    }

    public RetType for_SyntaxTransformationLocalVarDecl(_SyntaxTransformationLocalVarDecl that) {
        RetType body_result = recur(that.getBody());
        List<RetType> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<RetType> rhs_result = recurOnOptionOfExpr(that.getRhs());
        return for_SyntaxTransformationLocalVarDeclOnly(that, body_result, lhs_result, rhs_result);
    }

    public RetType for_SyntaxTransformationSimpleExpr(_SyntaxTransformationSimpleExpr that) {
        return for_SyntaxTransformationSimpleExprOnly(that);
    }

    public RetType for_SyntaxTransformationSubscriptExpr(_SyntaxTransformationSubscriptExpr that) {
        RetType obj_result = recur(that.getObj());
        List<RetType> subs_result = recurOnListOfExpr(that.getSubs());
        Option<RetType> op_result = recurOnOptionOfOp(that.getOp());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_SyntaxTransformationSubscriptExprOnly(that, obj_result, subs_result, op_result, staticArgs_result);
    }

    public RetType for_SyntaxTransformationPrimary(_SyntaxTransformationPrimary that) {
        return for_SyntaxTransformationPrimaryOnly(that);
    }

    public RetType for_SyntaxTransformationLiteralExpr(_SyntaxTransformationLiteralExpr that) {
        return for_SyntaxTransformationLiteralExprOnly(that);
    }

    public RetType for_SyntaxTransformationNumberLiteralExpr(_SyntaxTransformationNumberLiteralExpr that) {
        return for_SyntaxTransformationNumberLiteralExprOnly(that);
    }

    public RetType for_SyntaxTransformationFloatLiteralExpr(_SyntaxTransformationFloatLiteralExpr that) {
        return for_SyntaxTransformationFloatLiteralExprOnly(that);
    }

    public RetType for_SyntaxTransformationIntLiteralExpr(_SyntaxTransformationIntLiteralExpr that) {
        return for_SyntaxTransformationIntLiteralExprOnly(that);
    }

    public RetType for_SyntaxTransformationCharLiteralExpr(_SyntaxTransformationCharLiteralExpr that) {
        return for_SyntaxTransformationCharLiteralExprOnly(that);
    }

    public RetType for_SyntaxTransformationStringLiteralExpr(_SyntaxTransformationStringLiteralExpr that) {
        return for_SyntaxTransformationStringLiteralExprOnly(that);
    }

    public RetType for_SyntaxTransformationVoidLiteralExpr(_SyntaxTransformationVoidLiteralExpr that) {
        return for_SyntaxTransformationVoidLiteralExprOnly(that);
    }

    public RetType for_SyntaxTransformationBooleanLiteralExpr(_SyntaxTransformationBooleanLiteralExpr that) {
        return for_SyntaxTransformationBooleanLiteralExprOnly(that);
    }

    public RetType for_SyntaxTransformationVarRef(_SyntaxTransformationVarRef that) {
        RetType varId_result = recur(that.getVarId());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_SyntaxTransformationVarRefOnly(that, varId_result, staticArgs_result);
    }

    public RetType for_SyntaxTransformationFieldRef(_SyntaxTransformationFieldRef that) {
        RetType obj_result = recur(that.getObj());
        RetType field_result = recur(that.getField());
        return for_SyntaxTransformationFieldRefOnly(that, obj_result, field_result);
    }

    public RetType for_SyntaxTransformationFunctionalRef(_SyntaxTransformationFunctionalRef that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType originalName_result = recur(that.getOriginalName());
        List<RetType> names_result = recurOnListOfIdOrOp(that.getNames());
        List<RetType> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<RetType> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<RetType> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<RetType> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return for_SyntaxTransformationFunctionalRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType for_SyntaxTransformationFnRef(_SyntaxTransformationFnRef that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType originalName_result = recur(that.getOriginalName());
        List<RetType> names_result = recurOnListOfIdOrOp(that.getNames());
        List<RetType> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<RetType> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<RetType> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<RetType> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return for_SyntaxTransformationFnRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType for_SyntaxTransformationOpRef(_SyntaxTransformationOpRef that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType originalName_result = recur(that.getOriginalName());
        List<RetType> names_result = recurOnListOfIdOrOp(that.getNames());
        List<RetType> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<RetType> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<RetType> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<RetType> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return for_SyntaxTransformationOpRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType for_SyntaxTransformation_RewriteFnRef(_SyntaxTransformation_RewriteFnRef that) {
        RetType fnExpr_result = recur(that.getFnExpr());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_SyntaxTransformation_RewriteFnRefOnly(that, fnExpr_result, staticArgs_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprRef(_SyntaxTransformation_RewriteObjectExprRef that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_SyntaxTransformation_RewriteObjectExprRefOnly(that, staticArgs_result);
    }

    public RetType for_SyntaxTransformationJuxt(_SyntaxTransformationJuxt that) {
        RetType multiJuxt_result = recur(that.getMultiJuxt());
        RetType infixJuxt_result = recur(that.getInfixJuxt());
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        return for_SyntaxTransformationJuxtOnly(that, multiJuxt_result, infixJuxt_result, exprs_result);
    }

    public RetType for_SyntaxTransformation_RewriteFnApp(_SyntaxTransformation_RewriteFnApp that) {
        RetType function_result = recur(that.getFunction());
        RetType argument_result = recur(that.getArgument());
        return for_SyntaxTransformation_RewriteFnAppOnly(that, function_result, argument_result);
    }

    public RetType for_SyntaxTransformationOpExpr(_SyntaxTransformationOpExpr that) {
        RetType op_result = recur(that.getOp());
        List<RetType> args_result = recurOnListOfExpr(that.getArgs());
        return for_SyntaxTransformationOpExprOnly(that, op_result, args_result);
    }

    public RetType for_SyntaxTransformationAmbiguousMultifixOpExpr(_SyntaxTransformationAmbiguousMultifixOpExpr that) {
        RetType infix_op_result = recur(that.getInfix_op());
        RetType multifix_op_result = recur(that.getMultifix_op());
        List<RetType> args_result = recurOnListOfExpr(that.getArgs());
        return for_SyntaxTransformationAmbiguousMultifixOpExprOnly(that, infix_op_result, multifix_op_result, args_result);
    }

    public RetType for_SyntaxTransformationChainExpr(_SyntaxTransformationChainExpr that) {
        RetType first_result = recur(that.getFirst());
        List<RetType> links_result = recurOnListOfLink(that.getLinks());
        return for_SyntaxTransformationChainExprOnly(that, first_result, links_result);
    }

    public RetType for_SyntaxTransformationCoercionInvocation(_SyntaxTransformationCoercionInvocation that) {
        RetType toType_result = recur(that.getToType());
        RetType arg_result = recur(that.getArg());
        return for_SyntaxTransformationCoercionInvocationOnly(that, toType_result, arg_result);
    }

    public RetType for_SyntaxTransformationTraitCoercionInvocation(_SyntaxTransformationTraitCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        RetType toType_result = recur(that.getToType());
        RetType coercionFn_result = recur(that.getCoercionFn());
        return for_SyntaxTransformationTraitCoercionInvocationOnly(that, arg_result, toType_result, coercionFn_result);
    }

    public RetType for_SyntaxTransformationTupleCoercionInvocation(_SyntaxTransformationTupleCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        RetType toType_result = recur(that.getToType());
        List<Option<RetType>> subCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getSubCoercions());
        Option<Option<RetType>> varargCoercion_result = recurOnOptionOfOptionOfCoercionInvocation(that.getVarargCoercion());
        return for_SyntaxTransformationTupleCoercionInvocationOnly(that, arg_result, toType_result, subCoercions_result, varargCoercion_result);
    }

    public RetType for_SyntaxTransformationArrowCoercionInvocation(_SyntaxTransformationArrowCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        RetType toType_result = recur(that.getToType());
        Option<RetType> domainCoercion_result = recurOnOptionOfCoercionInvocation(that.getDomainCoercion());
        Option<RetType> rangeCoercion_result = recurOnOptionOfCoercionInvocation(that.getRangeCoercion());
        return for_SyntaxTransformationArrowCoercionInvocationOnly(that, arg_result, toType_result, domainCoercion_result, rangeCoercion_result);
    }

    public RetType for_SyntaxTransformationUnionCoercionInvocation(_SyntaxTransformationUnionCoercionInvocation that) {
        RetType toType_result = recur(that.getToType());
        RetType arg_result = recur(that.getArg());
        List<RetType> fromTypes_result = recurOnListOfType(that.getFromTypes());
        List<Option<RetType>> fromCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getFromCoercions());
        return for_SyntaxTransformationUnionCoercionInvocationOnly(that, toType_result, arg_result, fromTypes_result, fromCoercions_result);
    }

    public RetType for_SyntaxTransformationMethodInvocation(_SyntaxTransformationMethodInvocation that) {
        RetType obj_result = recur(that.getObj());
        RetType method_result = recur(that.getMethod());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType arg_result = recur(that.getArg());
        Option<RetType> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<RetType> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return for_SyntaxTransformationMethodInvocationOnly(that, obj_result, method_result, staticArgs_result, arg_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType for_SyntaxTransformationMathPrimary(_SyntaxTransformationMathPrimary that) {
        RetType multiJuxt_result = recur(that.getMultiJuxt());
        RetType infixJuxt_result = recur(that.getInfixJuxt());
        RetType front_result = recur(that.getFront());
        List<RetType> rest_result = recurOnListOfMathItem(that.getRest());
        return for_SyntaxTransformationMathPrimaryOnly(that, multiJuxt_result, infixJuxt_result, front_result, rest_result);
    }

    public RetType for_SyntaxTransformationArrayExpr(_SyntaxTransformationArrayExpr that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_SyntaxTransformationArrayExprOnly(that, staticArgs_result);
    }

    public RetType for_SyntaxTransformationArrayElement(_SyntaxTransformationArrayElement that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType element_result = recur(that.getElement());
        return for_SyntaxTransformationArrayElementOnly(that, staticArgs_result, element_result);
    }

    public RetType for_SyntaxTransformationArrayElements(_SyntaxTransformationArrayElements that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<RetType> elements_result = recurOnListOfArrayExpr(that.getElements());
        return for_SyntaxTransformationArrayElementsOnly(that, staticArgs_result, elements_result);
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
        RetType name_result = recur(that.getName());
        return for_SyntaxTransformationNamedTypeOnly(that, name_result);
    }

    public RetType for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that) {
        RetType name_result = recur(that.getName());
        return for_SyntaxTransformation_InferenceVarTypeOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationVarType(_SyntaxTransformationVarType that) {
        RetType name_result = recur(that.getName());
        return for_SyntaxTransformationVarTypeOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that) {
        RetType name_result = recur(that.getName());
        List<RetType> args_result = recurOnListOfStaticArg(that.getArgs());
        List<RetType> traitStaticParams_result = recurOnListOfStaticParam(that.getTraitStaticParams());
        return for_SyntaxTransformationTraitTypeOnly(that, name_result, args_result, traitStaticParams_result);
    }

    public RetType for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that) {
        RetType elemType_result = recur(that.getElemType());
        return for_SyntaxTransformationAbbreviatedTypeOnly(that, elemType_result);
    }

    public RetType for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that) {
        RetType elemType_result = recur(that.getElemType());
        RetType indices_result = recur(that.getIndices());
        return for_SyntaxTransformationArrayTypeOnly(that, elemType_result, indices_result);
    }

    public RetType for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that) {
        RetType elemType_result = recur(that.getElemType());
        List<RetType> dimensions_result = recurOnListOfExtentRange(that.getDimensions());
        return for_SyntaxTransformationMatrixTypeOnly(that, elemType_result, dimensions_result);
    }

    public RetType for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that) {
        RetType elemType_result = recur(that.getElemType());
        RetType dimExpr_result = recur(that.getDimExpr());
        Option<RetType> unitExpr_result = recurOnOptionOfExpr(that.getUnitExpr());
        return for_SyntaxTransformationTaggedDimTypeOnly(that, elemType_result, dimExpr_result, unitExpr_result);
    }

    public RetType for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that) {
        RetType elemType_result = recur(that.getElemType());
        RetType unitExpr_result = recur(that.getUnitExpr());
        return for_SyntaxTransformationTaggedUnitTypeOnly(that, elemType_result, unitExpr_result);
    }

    public RetType for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that) {
        List<RetType> elements_result = recurOnListOfType(that.getElements());
        Option<RetType> varargs_result = recurOnOptionOfType(that.getVarargs());
        List<RetType> keywords_result = recurOnListOfKeywordType(that.getKeywords());
        return for_SyntaxTransformationTupleTypeOnly(that, elements_result, varargs_result, keywords_result);
    }

    public RetType for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that) {
        RetType domain_result = recur(that.getDomain());
        RetType range_result = recur(that.getRange());
        RetType effect_result = recur(that.getEffect());
        return for_SyntaxTransformationArrowTypeOnly(that, domain_result, range_result, effect_result);
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
        RetType name_result = recur(that.getName());
        return for_SyntaxTransformationDimRefOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that) {
        RetType base_result = recur(that.getBase());
        RetType power_result = recur(that.getPower());
        return for_SyntaxTransformationDimExponentOnly(that, base_result, power_result);
    }

    public RetType for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that) {
        RetType dimVal_result = recur(that.getDimVal());
        RetType op_result = recur(that.getOp());
        return for_SyntaxTransformationDimUnaryOpOnly(that, dimVal_result, op_result);
    }

    public RetType for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        return for_SyntaxTransformationDimBinaryOpOnly(that, left_result, right_result, op_result);
    }

    public RetType for_SyntaxTransformationPattern(_SyntaxTransformationPattern that) {
        Option<RetType> name_result = recurOnOptionOfType(that.getName());
        RetType patterns_result = recur(that.getPatterns());
        return for_SyntaxTransformationPatternOnly(that, name_result, patterns_result);
    }

    public RetType for_SyntaxTransformationPatternArgs(_SyntaxTransformationPatternArgs that) {
        List<RetType> patterns_result = recurOnListOfPatternBinding(that.getPatterns());
        return for_SyntaxTransformationPatternArgsOnly(that, patterns_result);
    }

    public RetType for_SyntaxTransformationPatternBinding(_SyntaxTransformationPatternBinding that) {
        Option<RetType> field_result = recurOnOptionOfId(that.getField());
        return for_SyntaxTransformationPatternBindingOnly(that, field_result);
    }

    public RetType for_SyntaxTransformationPlainPattern(_SyntaxTransformationPlainPattern that) {
        Option<RetType> field_result = recurOnOptionOfId(that.getField());
        RetType name_result = recur(that.getName());
        return for_SyntaxTransformationPlainPatternOnly(that, field_result, name_result);
    }

    public RetType for_SyntaxTransformationTypePattern(_SyntaxTransformationTypePattern that) {
        Option<RetType> field_result = recurOnOptionOfId(that.getField());
        RetType typ_result = recur(that.getTyp());
        return for_SyntaxTransformationTypePatternOnly(that, field_result, typ_result);
    }

    public RetType for_SyntaxTransformationNestedPattern(_SyntaxTransformationNestedPattern that) {
        Option<RetType> field_result = recurOnOptionOfId(that.getField());
        RetType pat_result = recur(that.getPat());
        return for_SyntaxTransformationNestedPatternOnly(that, field_result, pat_result);
    }

    public RetType for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that) {
        return for_SyntaxTransformationStaticArgOnly(that);
    }

    public RetType for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that) {
        RetType typeArg_result = recur(that.getTypeArg());
        return for_SyntaxTransformationTypeArgOnly(that, typeArg_result);
    }

    public RetType for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that) {
        RetType intVal_result = recur(that.getIntVal());
        return for_SyntaxTransformationIntArgOnly(that, intVal_result);
    }

    public RetType for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that) {
        RetType boolArg_result = recur(that.getBoolArg());
        return for_SyntaxTransformationBoolArgOnly(that, boolArg_result);
    }

    public RetType for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that) {
        RetType id_result = recur(that.getId());
        return for_SyntaxTransformationOpArgOnly(that, id_result);
    }

    public RetType for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that) {
        RetType dimArg_result = recur(that.getDimArg());
        return for_SyntaxTransformationDimArgOnly(that, dimArg_result);
    }

    public RetType for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that) {
        RetType unitArg_result = recur(that.getUnitArg());
        return for_SyntaxTransformationUnitArgOnly(that, unitArg_result);
    }

    public RetType for_SyntaxTransformationStaticExpr(_SyntaxTransformationStaticExpr that) {
        return for_SyntaxTransformationStaticExprOnly(that);
    }

    public RetType for_SyntaxTransformationIntExpr(_SyntaxTransformationIntExpr that) {
        return for_SyntaxTransformationIntExprOnly(that);
    }

    public RetType for_SyntaxTransformationIntBase(_SyntaxTransformationIntBase that) {
        RetType intVal_result = recur(that.getIntVal());
        return for_SyntaxTransformationIntBaseOnly(that, intVal_result);
    }

    public RetType for_SyntaxTransformationIntRef(_SyntaxTransformationIntRef that) {
        RetType name_result = recur(that.getName());
        return for_SyntaxTransformationIntRefOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationIntBinaryOp(_SyntaxTransformationIntBinaryOp that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        return for_SyntaxTransformationIntBinaryOpOnly(that, left_result, right_result, op_result);
    }

    public RetType for_SyntaxTransformationBoolExpr(_SyntaxTransformationBoolExpr that) {
        return for_SyntaxTransformationBoolExprOnly(that);
    }

    public RetType for_SyntaxTransformationBoolBase(_SyntaxTransformationBoolBase that) {
        return for_SyntaxTransformationBoolBaseOnly(that);
    }

    public RetType for_SyntaxTransformationBoolRef(_SyntaxTransformationBoolRef that) {
        RetType name_result = recur(that.getName());
        return for_SyntaxTransformationBoolRefOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationBoolConstraint(_SyntaxTransformationBoolConstraint that) {
        return for_SyntaxTransformationBoolConstraintOnly(that);
    }

    public RetType for_SyntaxTransformationBoolUnaryOp(_SyntaxTransformationBoolUnaryOp that) {
        RetType boolVal_result = recur(that.getBoolVal());
        RetType op_result = recur(that.getOp());
        return for_SyntaxTransformationBoolUnaryOpOnly(that, boolVal_result, op_result);
    }

    public RetType for_SyntaxTransformationBoolBinaryOp(_SyntaxTransformationBoolBinaryOp that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        return for_SyntaxTransformationBoolBinaryOpOnly(that, left_result, right_result, op_result);
    }

    public RetType for_SyntaxTransformationUnitExpr(_SyntaxTransformationUnitExpr that) {
        return for_SyntaxTransformationUnitExprOnly(that);
    }

    public RetType for_SyntaxTransformationUnitRef(_SyntaxTransformationUnitRef that) {
        RetType name_result = recur(that.getName());
        return for_SyntaxTransformationUnitRefOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationUnitBinaryOp(_SyntaxTransformationUnitBinaryOp that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        return for_SyntaxTransformationUnitBinaryOpOnly(that, left_result, right_result, op_result);
    }

    public RetType for_SyntaxTransformationEffect(_SyntaxTransformationEffect that) {
        Option<List<RetType>> throwsClause_result = recurOnOptionOfListOfType(that.getThrowsClause());
        return for_SyntaxTransformationEffectOnly(that, throwsClause_result);
    }

    public RetType for_SyntaxTransformationWhereClause(_SyntaxTransformationWhereClause that) {
        List<RetType> bindings_result = recurOnListOfWhereBinding(that.getBindings());
        List<RetType> constraints_result = recurOnListOfWhereConstraint(that.getConstraints());
        return for_SyntaxTransformationWhereClauseOnly(that, bindings_result, constraints_result);
    }

    public RetType for_SyntaxTransformationWhereBinding(_SyntaxTransformationWhereBinding that) {
        RetType name_result = recur(that.getName());
        List<RetType> supers_result = recurOnListOfBaseType(that.getSupers());
        return for_SyntaxTransformationWhereBindingOnly(that, name_result, supers_result);
    }

    public RetType for_SyntaxTransformationWhereConstraint(_SyntaxTransformationWhereConstraint that) {
        return for_SyntaxTransformationWhereConstraintOnly(that);
    }

    public RetType for_SyntaxTransformationWhereExtends(_SyntaxTransformationWhereExtends that) {
        RetType name_result = recur(that.getName());
        List<RetType> supers_result = recurOnListOfBaseType(that.getSupers());
        return for_SyntaxTransformationWhereExtendsOnly(that, name_result, supers_result);
    }

    public RetType for_SyntaxTransformationWhereTypeAlias(_SyntaxTransformationWhereTypeAlias that) {
        RetType alias_result = recur(that.getAlias());
        return for_SyntaxTransformationWhereTypeAliasOnly(that, alias_result);
    }

    public RetType for_SyntaxTransformationWhereCoerces(_SyntaxTransformationWhereCoerces that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        return for_SyntaxTransformationWhereCoercesOnly(that, left_result, right_result);
    }

    public RetType for_SyntaxTransformationWhereEquals(_SyntaxTransformationWhereEquals that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        return for_SyntaxTransformationWhereEqualsOnly(that, left_result, right_result);
    }

    public RetType for_SyntaxTransformationUnitConstraint(_SyntaxTransformationUnitConstraint that) {
        RetType name_result = recur(that.getName());
        return for_SyntaxTransformationUnitConstraintOnly(that, name_result);
    }

    public RetType for_SyntaxTransformationIntConstraint(_SyntaxTransformationIntConstraint that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        return for_SyntaxTransformationIntConstraintOnly(that, left_result, right_result, op_result);
    }

    public RetType for_SyntaxTransformationBoolConstraintExpr(_SyntaxTransformationBoolConstraintExpr that) {
        RetType constraint_result = recur(that.getConstraint());
        return for_SyntaxTransformationBoolConstraintExprOnly(that, constraint_result);
    }

    public RetType for_SyntaxTransformationContract(_SyntaxTransformationContract that) {
        Option<List<RetType>> requiresClause_result = recurOnOptionOfListOfExpr(that.getRequiresClause());
        Option<List<RetType>> ensuresClause_result = recurOnOptionOfListOfEnsuresClause(that.getEnsuresClause());
        Option<List<RetType>> invariantsClause_result = recurOnOptionOfListOfExpr(that.getInvariantsClause());
        return for_SyntaxTransformationContractOnly(that, requiresClause_result, ensuresClause_result, invariantsClause_result);
    }

    public RetType for_SyntaxTransformationEnsuresClause(_SyntaxTransformationEnsuresClause that) {
        RetType post_result = recur(that.getPost());
        Option<RetType> pre_result = recurOnOptionOfExpr(that.getPre());
        return for_SyntaxTransformationEnsuresClauseOnly(that, post_result, pre_result);
    }

    public RetType for_SyntaxTransformationStaticParam(_SyntaxTransformationStaticParam that) {
        RetType name_result = recur(that.getName());
        List<RetType> extendsClause_result = recurOnListOfBaseType(that.getExtendsClause());
        List<RetType> dominatesClause_result = recurOnListOfBaseType(that.getDominatesClause());
        Option<RetType> dimParam_result = recurOnOptionOfType(that.getDimParam());
        return for_SyntaxTransformationStaticParamOnly(that, name_result, extendsClause_result, dominatesClause_result, dimParam_result);
    }

    public RetType for_SyntaxTransformationName(_SyntaxTransformationName that) {
        return for_SyntaxTransformationNameOnly(that);
    }

    public RetType for_SyntaxTransformationAPIName(_SyntaxTransformationAPIName that) {
        List<RetType> ids_result = recurOnListOfId(that.getIds());
        return for_SyntaxTransformationAPINameOnly(that, ids_result);
    }

    public RetType for_SyntaxTransformationIdOrOpOrAnonymousName(_SyntaxTransformationIdOrOpOrAnonymousName that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return for_SyntaxTransformationIdOrOpOrAnonymousNameOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationIdOrOp(_SyntaxTransformationIdOrOp that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return for_SyntaxTransformationIdOrOpOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationId(_SyntaxTransformationId that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return for_SyntaxTransformationIdOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationOp(_SyntaxTransformationOp that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return for_SyntaxTransformationOpOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationNamedOp(_SyntaxTransformationNamedOp that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return for_SyntaxTransformationNamedOpOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformation_InferenceVarOp(_SyntaxTransformation_InferenceVarOp that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return for_SyntaxTransformation_InferenceVarOpOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationAnonymousName(_SyntaxTransformationAnonymousName that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return for_SyntaxTransformationAnonymousNameOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationAnonymousFnName(_SyntaxTransformationAnonymousFnName that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return for_SyntaxTransformationAnonymousFnNameOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationConstructorFnName(_SyntaxTransformationConstructorFnName that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return for_SyntaxTransformationConstructorFnNameOnly(that, apiName_result);
    }

    public RetType for_SyntaxTransformationArrayComprehensionClause(_SyntaxTransformationArrayComprehensionClause that) {
        List<RetType> bind_result = recurOnListOfExpr(that.getBind());
        RetType init_result = recur(that.getInit());
        List<RetType> gens_result = recurOnListOfGeneratorClause(that.getGens());
        return for_SyntaxTransformationArrayComprehensionClauseOnly(that, bind_result, init_result, gens_result);
    }

    public RetType for_SyntaxTransformationKeywordExpr(_SyntaxTransformationKeywordExpr that) {
        RetType name_result = recur(that.getName());
        RetType init_result = recur(that.getInit());
        return for_SyntaxTransformationKeywordExprOnly(that, name_result, init_result);
    }

    public RetType for_SyntaxTransformationCaseClause(_SyntaxTransformationCaseClause that) {
        RetType matchClause_result = recur(that.getMatchClause());
        RetType body_result = recur(that.getBody());
        Option<RetType> op_result = recurOnOptionOfFunctionalRef(that.getOp());
        return for_SyntaxTransformationCaseClauseOnly(that, matchClause_result, body_result, op_result);
    }

    public RetType for_SyntaxTransformationCatch(_SyntaxTransformationCatch that) {
        RetType name_result = recur(that.getName());
        List<RetType> clauses_result = recurOnListOfCatchClause(that.getClauses());
        return for_SyntaxTransformationCatchOnly(that, name_result, clauses_result);
    }

    public RetType for_SyntaxTransformationCatchClause(_SyntaxTransformationCatchClause that) {
        RetType matchType_result = recur(that.getMatchType());
        RetType body_result = recur(that.getBody());
        return for_SyntaxTransformationCatchClauseOnly(that, matchType_result, body_result);
    }

    public RetType for_SyntaxTransformationIfClause(_SyntaxTransformationIfClause that) {
        RetType testClause_result = recur(that.getTestClause());
        RetType body_result = recur(that.getBody());
        return for_SyntaxTransformationIfClauseOnly(that, testClause_result, body_result);
    }

    public RetType for_SyntaxTransformationTypecaseClause(_SyntaxTransformationTypecaseClause that) {
        Option<RetType> name_result = recurOnOptionOfId(that.getName());
        RetType body_result = recur(that.getBody());
        return for_SyntaxTransformationTypecaseClauseOnly(that, name_result, body_result);
    }

    public RetType for_SyntaxTransformationExtentRange(_SyntaxTransformationExtentRange that) {
        Option<RetType> base_result = recurOnOptionOfStaticArg(that.getBase());
        Option<RetType> size_result = recurOnOptionOfStaticArg(that.getSize());
        Option<RetType> op_result = recurOnOptionOfOp(that.getOp());
        return for_SyntaxTransformationExtentRangeOnly(that, base_result, size_result, op_result);
    }

    public RetType for_SyntaxTransformationGeneratorClause(_SyntaxTransformationGeneratorClause that) {
        List<RetType> bind_result = recurOnListOfId(that.getBind());
        RetType init_result = recur(that.getInit());
        return for_SyntaxTransformationGeneratorClauseOnly(that, bind_result, init_result);
    }

    public RetType for_SyntaxTransformationKeywordType(_SyntaxTransformationKeywordType that) {
        RetType name_result = recur(that.getName());
        RetType keywordType_result = recur(that.getKeywordType());
        return for_SyntaxTransformationKeywordTypeOnly(that, name_result, keywordType_result);
    }

    public RetType for_SyntaxTransformationTraitTypeWhere(_SyntaxTransformationTraitTypeWhere that) {
        RetType baseType_result = recur(that.getBaseType());
        Option<RetType> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        return for_SyntaxTransformationTraitTypeWhereOnly(that, baseType_result, whereClause_result);
    }

    public RetType for_SyntaxTransformationIndices(_SyntaxTransformationIndices that) {
        List<RetType> extents_result = recurOnListOfExtentRange(that.getExtents());
        return for_SyntaxTransformationIndicesOnly(that, extents_result);
    }

    public RetType for_SyntaxTransformationMathItem(_SyntaxTransformationMathItem that) {
        return for_SyntaxTransformationMathItemOnly(that);
    }

    public RetType for_SyntaxTransformationExprMI(_SyntaxTransformationExprMI that) {
        RetType expr_result = recur(that.getExpr());
        return for_SyntaxTransformationExprMIOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationParenthesisDelimitedMI(_SyntaxTransformationParenthesisDelimitedMI that) {
        RetType expr_result = recur(that.getExpr());
        return for_SyntaxTransformationParenthesisDelimitedMIOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationNonParenthesisDelimitedMI(_SyntaxTransformationNonParenthesisDelimitedMI that) {
        RetType expr_result = recur(that.getExpr());
        return for_SyntaxTransformationNonParenthesisDelimitedMIOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationNonExprMI(_SyntaxTransformationNonExprMI that) {
        return for_SyntaxTransformationNonExprMIOnly(that);
    }

    public RetType for_SyntaxTransformationExponentiationMI(_SyntaxTransformationExponentiationMI that) {
        RetType op_result = recur(that.getOp());
        Option<RetType> expr_result = recurOnOptionOfExpr(that.getExpr());
        return for_SyntaxTransformationExponentiationMIOnly(that, op_result, expr_result);
    }

    public RetType for_SyntaxTransformationSubscriptingMI(_SyntaxTransformationSubscriptingMI that) {
        RetType op_result = recur(that.getOp());
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_SyntaxTransformationSubscriptingMIOnly(that, op_result, exprs_result, staticArgs_result);
    }

    public RetType for_SyntaxTransformationOverloading(_SyntaxTransformationOverloading that) {
        RetType unambiguousName_result = recur(that.getUnambiguousName());
        RetType originalName_result = recur(that.getOriginalName());
        Option<RetType> type_result = recurOnOptionOfArrowType(that.getType());
        Option<RetType> schema_result = recurOnOptionOfArrowType(that.getSchema());
        return for_SyntaxTransformationOverloadingOnly(that, unambiguousName_result, originalName_result, type_result, schema_result);
    }

    public RetType for_SyntaxTransformationNonterminalHeader(_SyntaxTransformationNonterminalHeader that) {
        RetType name_result = recur(that.getName());
        List<RetType> params_result = recurOnListOfNonterminalParameter(that.getParams());
        List<RetType> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        Option<RetType> paramType_result = recurOnOptionOfType(that.getParamType());
        Option<RetType> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        return for_SyntaxTransformationNonterminalHeaderOnly(that, name_result, params_result, staticParams_result, paramType_result, whereClause_result);
    }

    public RetType for_SyntaxTransformationNonterminalParameter(_SyntaxTransformationNonterminalParameter that) {
        RetType name_result = recur(that.getName());
        RetType paramType_result = recur(that.getParamType());
        return for_SyntaxTransformationNonterminalParameterOnly(that, name_result, paramType_result);
    }

    public RetType for_SyntaxTransformationSyntaxDecl(_SyntaxTransformationSyntaxDecl that) {
        return for_SyntaxTransformationSyntaxDeclOnly(that);
    }

    public RetType for_SyntaxTransformationSyntaxDef(_SyntaxTransformationSyntaxDef that) {
        List<RetType> syntaxSymbols_result = recurOnListOfSyntaxSymbol(that.getSyntaxSymbols());
        RetType transformer_result = recur(that.getTransformer());
        return for_SyntaxTransformationSyntaxDefOnly(that, syntaxSymbols_result, transformer_result);
    }

    public RetType for_SyntaxTransformationSuperSyntaxDef(_SyntaxTransformationSuperSyntaxDef that) {
        RetType nonterminal_result = recur(that.getNonterminal());
        RetType grammarId_result = recur(that.getGrammarId());
        return for_SyntaxTransformationSuperSyntaxDefOnly(that, nonterminal_result, grammarId_result);
    }

    public RetType for_SyntaxTransformationTransformerDecl(_SyntaxTransformationTransformerDecl that) {
        return for_SyntaxTransformationTransformerDeclOnly(that);
    }

    public RetType for_SyntaxTransformationPreTransformerDef(_SyntaxTransformationPreTransformerDef that) {
        RetType transformer_result = recur(that.getTransformer());
        return for_SyntaxTransformationPreTransformerDefOnly(that, transformer_result);
    }

    public RetType for_SyntaxTransformationNamedTransformerDef(_SyntaxTransformationNamedTransformerDef that) {
        List<RetType> parameters_result = recurOnListOfNonterminalParameter(that.getParameters());
        RetType transformer_result = recur(that.getTransformer());
        return for_SyntaxTransformationNamedTransformerDefOnly(that, parameters_result, transformer_result);
    }

    public RetType for_SyntaxTransformationTransformer(_SyntaxTransformationTransformer that) {
        return for_SyntaxTransformationTransformerOnly(that);
    }

    public RetType for_SyntaxTransformationUnparsedTransformer(_SyntaxTransformationUnparsedTransformer that) {
        RetType nonterminal_result = recur(that.getNonterminal());
        return for_SyntaxTransformationUnparsedTransformerOnly(that, nonterminal_result);
    }

    public RetType for_SyntaxTransformationNodeTransformer(_SyntaxTransformationNodeTransformer that) {
        RetType node_result = recur(that.getNode());
        return for_SyntaxTransformationNodeTransformerOnly(that, node_result);
    }

    public RetType for_SyntaxTransformationCaseTransformer(_SyntaxTransformationCaseTransformer that) {
        RetType gapName_result = recur(that.getGapName());
        List<RetType> clauses_result = recurOnListOfCaseTransformerClause(that.getClauses());
        return for_SyntaxTransformationCaseTransformerOnly(that, gapName_result, clauses_result);
    }

    public RetType for_SyntaxTransformationCaseTransformerClause(_SyntaxTransformationCaseTransformerClause that) {
        RetType constructor_result = recur(that.getConstructor());
        List<RetType> parameters_result = recurOnListOfId(that.getParameters());
        RetType body_result = recur(that.getBody());
        return for_SyntaxTransformationCaseTransformerClauseOnly(that, constructor_result, parameters_result, body_result);
    }

    public RetType for_SyntaxTransformationSyntaxSymbol(_SyntaxTransformationSyntaxSymbol that) {
        return for_SyntaxTransformationSyntaxSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationPrefixedSymbol(_SyntaxTransformationPrefixedSymbol that) {
        RetType id_result = recur(that.getId());
        RetType symbol_result = recur(that.getSymbol());
        return for_SyntaxTransformationPrefixedSymbolOnly(that, id_result, symbol_result);
    }

    public RetType for_SyntaxTransformationOptionalSymbol(_SyntaxTransformationOptionalSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        return for_SyntaxTransformationOptionalSymbolOnly(that, symbol_result);
    }

    public RetType for_SyntaxTransformationRepeatSymbol(_SyntaxTransformationRepeatSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        return for_SyntaxTransformationRepeatSymbolOnly(that, symbol_result);
    }

    public RetType for_SyntaxTransformationRepeatOneOrMoreSymbol(_SyntaxTransformationRepeatOneOrMoreSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        return for_SyntaxTransformationRepeatOneOrMoreSymbolOnly(that, symbol_result);
    }

    public RetType for_SyntaxTransformationNoWhitespaceSymbol(_SyntaxTransformationNoWhitespaceSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        return for_SyntaxTransformationNoWhitespaceSymbolOnly(that, symbol_result);
    }

    public RetType for_SyntaxTransformationGroupSymbol(_SyntaxTransformationGroupSymbol that) {
        List<RetType> symbols_result = recurOnListOfSyntaxSymbol(that.getSymbols());
        return for_SyntaxTransformationGroupSymbolOnly(that, symbols_result);
    }

    public RetType for_SyntaxTransformationSpecialSymbol(_SyntaxTransformationSpecialSymbol that) {
        return for_SyntaxTransformationSpecialSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationAnyCharacterSymbol(_SyntaxTransformationAnyCharacterSymbol that) {
        return for_SyntaxTransformationAnyCharacterSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationWhitespaceSymbol(_SyntaxTransformationWhitespaceSymbol that) {
        return for_SyntaxTransformationWhitespaceSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationTabSymbol(_SyntaxTransformationTabSymbol that) {
        return for_SyntaxTransformationTabSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationFormfeedSymbol(_SyntaxTransformationFormfeedSymbol that) {
        return for_SyntaxTransformationFormfeedSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationCarriageReturnSymbol(_SyntaxTransformationCarriageReturnSymbol that) {
        return for_SyntaxTransformationCarriageReturnSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationBackspaceSymbol(_SyntaxTransformationBackspaceSymbol that) {
        return for_SyntaxTransformationBackspaceSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationNewlineSymbol(_SyntaxTransformationNewlineSymbol that) {
        return for_SyntaxTransformationNewlineSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationBreaklineSymbol(_SyntaxTransformationBreaklineSymbol that) {
        return for_SyntaxTransformationBreaklineSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationItemSymbol(_SyntaxTransformationItemSymbol that) {
        return for_SyntaxTransformationItemSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationNonterminalSymbol(_SyntaxTransformationNonterminalSymbol that) {
        RetType nonterminal_result = recur(that.getNonterminal());
        return for_SyntaxTransformationNonterminalSymbolOnly(that, nonterminal_result);
    }

    public RetType for_SyntaxTransformationKeywordSymbol(_SyntaxTransformationKeywordSymbol that) {
        return for_SyntaxTransformationKeywordSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationTokenSymbol(_SyntaxTransformationTokenSymbol that) {
        return for_SyntaxTransformationTokenSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationNotPredicateSymbol(_SyntaxTransformationNotPredicateSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        return for_SyntaxTransformationNotPredicateSymbolOnly(that, symbol_result);
    }

    public RetType for_SyntaxTransformationAndPredicateSymbol(_SyntaxTransformationAndPredicateSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        return for_SyntaxTransformationAndPredicateSymbolOnly(that, symbol_result);
    }

    public RetType for_SyntaxTransformationCharacterClassSymbol(_SyntaxTransformationCharacterClassSymbol that) {
        List<RetType> characters_result = recurOnListOfCharacterSymbol(that.getCharacters());
        return for_SyntaxTransformationCharacterClassSymbolOnly(that, characters_result);
    }

    public RetType for_SyntaxTransformationCharacterSymbol(_SyntaxTransformationCharacterSymbol that) {
        return for_SyntaxTransformationCharacterSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationCharSymbol(_SyntaxTransformationCharSymbol that) {
        return for_SyntaxTransformationCharSymbolOnly(that);
    }

    public RetType for_SyntaxTransformationCharacterInterval(_SyntaxTransformationCharacterInterval that) {
        return for_SyntaxTransformationCharacterIntervalOnly(that);
    }

    public RetType for_SyntaxTransformationLink(_SyntaxTransformationLink that) {
        RetType op_result = recur(that.getOp());
        RetType expr_result = recur(that.getExpr());
        return for_SyntaxTransformationLinkOnly(that, op_result, expr_result);
    }

    public RetType for_EllipsesAbstractNode(_EllipsesAbstractNode that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesCompilationUnit(_EllipsesCompilationUnit that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesComponent(_EllipsesComponent that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesApi(_EllipsesApi that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesImport(_EllipsesImport that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesImportedNames(_EllipsesImportedNames that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesImportStar(_EllipsesImportStar that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesImportNames(_EllipsesImportNames that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesImportApi(_EllipsesImportApi that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesAliasedSimpleName(_EllipsesAliasedSimpleName that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesAliasedAPIName(_EllipsesAliasedAPIName that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesDecl(_EllipsesDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTraitObjectDecl(_EllipsesTraitObjectDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTraitDecl(_EllipsesTraitDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesObjectDecl(_EllipsesObjectDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesVarDecl(_EllipsesVarDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesFnDecl(_EllipsesFnDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_Ellipses_RewriteFnOverloadDecl(_Ellipses_RewriteFnOverloadDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_Ellipses_RewriteObjectExprDecl(_Ellipses_RewriteObjectExprDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_Ellipses_RewriteFunctionalMethodDecl(_Ellipses_RewriteFunctionalMethodDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesDimUnitDecl(_EllipsesDimUnitDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesDimDecl(_EllipsesDimDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesUnitDecl(_EllipsesUnitDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTestDecl(_EllipsesTestDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesPropertyDecl(_EllipsesPropertyDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTypeAlias(_EllipsesTypeAlias that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesGrammarDecl(_EllipsesGrammarDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesGrammarMemberDecl(_EllipsesGrammarMemberDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNonterminalDecl(_EllipsesNonterminalDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNonterminalDef(_EllipsesNonterminalDef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNonterminalExtensionDef(_EllipsesNonterminalExtensionDef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBinding(_EllipsesBinding that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesLValue(_EllipsesLValue that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesParam(_EllipsesParam that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesExpr(_EllipsesExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesDummyExpr(_EllipsesDummyExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTypeAnnotatedExpr(_EllipsesTypeAnnotatedExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesAsExpr(_EllipsesAsExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesAsIfExpr(_EllipsesAsIfExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesAssignment(_EllipsesAssignment that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBlock(_EllipsesBlock that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesDo(_EllipsesDo that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesCaseExpr(_EllipsesCaseExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesIf(_EllipsesIf that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesLabel(_EllipsesLabel that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesAbstractObjectExpr(_EllipsesAbstractObjectExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesObjectExpr(_EllipsesObjectExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_Ellipses_RewriteObjectExpr(_Ellipses_RewriteObjectExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTry(_EllipsesTry that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTupleExpr(_EllipsesTupleExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTypecase(_EllipsesTypecase that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesWhile(_EllipsesWhile that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesFor(_EllipsesFor that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBigOpApp(_EllipsesBigOpApp that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesAccumulator(_EllipsesAccumulator that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesArrayComprehension(_EllipsesArrayComprehension that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesAtomicExpr(_EllipsesAtomicExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesExit(_EllipsesExit that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesSpawn(_EllipsesSpawn that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesThrow(_EllipsesThrow that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTryAtomicExpr(_EllipsesTryAtomicExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesFnExpr(_EllipsesFnExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesLetExpr(_EllipsesLetExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesLetFn(_EllipsesLetFn that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesLocalVarDecl(_EllipsesLocalVarDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesSimpleExpr(_EllipsesSimpleExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesSubscriptExpr(_EllipsesSubscriptExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesPrimary(_EllipsesPrimary that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesLiteralExpr(_EllipsesLiteralExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNumberLiteralExpr(_EllipsesNumberLiteralExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesFloatLiteralExpr(_EllipsesFloatLiteralExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesIntLiteralExpr(_EllipsesIntLiteralExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesCharLiteralExpr(_EllipsesCharLiteralExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesStringLiteralExpr(_EllipsesStringLiteralExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesVoidLiteralExpr(_EllipsesVoidLiteralExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBooleanLiteralExpr(_EllipsesBooleanLiteralExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesVarRef(_EllipsesVarRef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesFieldRef(_EllipsesFieldRef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesFunctionalRef(_EllipsesFunctionalRef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesFnRef(_EllipsesFnRef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesOpRef(_EllipsesOpRef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_Ellipses_RewriteFnRef(_Ellipses_RewriteFnRef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_Ellipses_RewriteObjectExprRef(_Ellipses_RewriteObjectExprRef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesJuxt(_EllipsesJuxt that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_Ellipses_RewriteFnApp(_Ellipses_RewriteFnApp that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesOpExpr(_EllipsesOpExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesAmbiguousMultifixOpExpr(_EllipsesAmbiguousMultifixOpExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesChainExpr(_EllipsesChainExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesCoercionInvocation(_EllipsesCoercionInvocation that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTraitCoercionInvocation(_EllipsesTraitCoercionInvocation that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTupleCoercionInvocation(_EllipsesTupleCoercionInvocation that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesArrowCoercionInvocation(_EllipsesArrowCoercionInvocation that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesUnionCoercionInvocation(_EllipsesUnionCoercionInvocation that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesMethodInvocation(_EllipsesMethodInvocation that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesMathPrimary(_EllipsesMathPrimary that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesArrayExpr(_EllipsesArrayExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesArrayElement(_EllipsesArrayElement that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesArrayElements(_EllipsesArrayElements that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesType(_EllipsesType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBaseType(_EllipsesBaseType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesAnyType(_EllipsesAnyType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBottomType(_EllipsesBottomType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesUnknownType(_EllipsesUnknownType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesSelfType(_EllipsesSelfType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTraitSelfType(_EllipsesTraitSelfType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesObjectExprType(_EllipsesObjectExprType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNamedType(_EllipsesNamedType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_Ellipses_InferenceVarType(_Ellipses_InferenceVarType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesVarType(_EllipsesVarType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTraitType(_EllipsesTraitType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesAbbreviatedType(_EllipsesAbbreviatedType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesArrayType(_EllipsesArrayType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesMatrixType(_EllipsesMatrixType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTaggedDimType(_EllipsesTaggedDimType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTaggedUnitType(_EllipsesTaggedUnitType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTupleType(_EllipsesTupleType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesArrowType(_EllipsesArrowType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBoundType(_EllipsesBoundType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesIntersectionType(_EllipsesIntersectionType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesUnionType(_EllipsesUnionType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesFixedPointType(_EllipsesFixedPointType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesLabelType(_EllipsesLabelType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesDimExpr(_EllipsesDimExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesDimBase(_EllipsesDimBase that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesDimRef(_EllipsesDimRef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesDimExponent(_EllipsesDimExponent that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesDimUnaryOp(_EllipsesDimUnaryOp that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesDimBinaryOp(_EllipsesDimBinaryOp that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesPattern(_EllipsesPattern that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesPatternArgs(_EllipsesPatternArgs that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesPatternBinding(_EllipsesPatternBinding that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesPlainPattern(_EllipsesPlainPattern that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTypePattern(_EllipsesTypePattern that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNestedPattern(_EllipsesNestedPattern that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesStaticArg(_EllipsesStaticArg that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTypeArg(_EllipsesTypeArg that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesIntArg(_EllipsesIntArg that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBoolArg(_EllipsesBoolArg that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesOpArg(_EllipsesOpArg that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesDimArg(_EllipsesDimArg that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesUnitArg(_EllipsesUnitArg that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesStaticExpr(_EllipsesStaticExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesIntExpr(_EllipsesIntExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesIntBase(_EllipsesIntBase that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesIntRef(_EllipsesIntRef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesIntBinaryOp(_EllipsesIntBinaryOp that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBoolExpr(_EllipsesBoolExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBoolBase(_EllipsesBoolBase that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBoolRef(_EllipsesBoolRef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBoolConstraint(_EllipsesBoolConstraint that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBoolUnaryOp(_EllipsesBoolUnaryOp that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBoolBinaryOp(_EllipsesBoolBinaryOp that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesUnitExpr(_EllipsesUnitExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesUnitRef(_EllipsesUnitRef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesUnitBinaryOp(_EllipsesUnitBinaryOp that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesEffect(_EllipsesEffect that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesWhereClause(_EllipsesWhereClause that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesWhereBinding(_EllipsesWhereBinding that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesWhereConstraint(_EllipsesWhereConstraint that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesWhereExtends(_EllipsesWhereExtends that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesWhereTypeAlias(_EllipsesWhereTypeAlias that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesWhereCoerces(_EllipsesWhereCoerces that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesWhereEquals(_EllipsesWhereEquals that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesUnitConstraint(_EllipsesUnitConstraint that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesIntConstraint(_EllipsesIntConstraint that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBoolConstraintExpr(_EllipsesBoolConstraintExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesContract(_EllipsesContract that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesEnsuresClause(_EllipsesEnsuresClause that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesStaticParam(_EllipsesStaticParam that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesName(_EllipsesName that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesAPIName(_EllipsesAPIName that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesIdOrOpOrAnonymousName(_EllipsesIdOrOpOrAnonymousName that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesIdOrOp(_EllipsesIdOrOp that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesId(_EllipsesId that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesOp(_EllipsesOp that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNamedOp(_EllipsesNamedOp that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_Ellipses_InferenceVarOp(_Ellipses_InferenceVarOp that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesAnonymousName(_EllipsesAnonymousName that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesAnonymousFnName(_EllipsesAnonymousFnName that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesConstructorFnName(_EllipsesConstructorFnName that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesArrayComprehensionClause(_EllipsesArrayComprehensionClause that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesKeywordExpr(_EllipsesKeywordExpr that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesCaseClause(_EllipsesCaseClause that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesCatch(_EllipsesCatch that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesCatchClause(_EllipsesCatchClause that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesIfClause(_EllipsesIfClause that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTypecaseClause(_EllipsesTypecaseClause that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesExtentRange(_EllipsesExtentRange that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesGeneratorClause(_EllipsesGeneratorClause that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesKeywordType(_EllipsesKeywordType that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTraitTypeWhere(_EllipsesTraitTypeWhere that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesIndices(_EllipsesIndices that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesMathItem(_EllipsesMathItem that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesExprMI(_EllipsesExprMI that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesParenthesisDelimitedMI(_EllipsesParenthesisDelimitedMI that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNonParenthesisDelimitedMI(_EllipsesNonParenthesisDelimitedMI that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNonExprMI(_EllipsesNonExprMI that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesExponentiationMI(_EllipsesExponentiationMI that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesSubscriptingMI(_EllipsesSubscriptingMI that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesOverloading(_EllipsesOverloading that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNonterminalHeader(_EllipsesNonterminalHeader that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNonterminalParameter(_EllipsesNonterminalParameter that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesSyntaxDecl(_EllipsesSyntaxDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesSyntaxDef(_EllipsesSyntaxDef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesSuperSyntaxDef(_EllipsesSuperSyntaxDef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTransformerDecl(_EllipsesTransformerDecl that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesPreTransformerDef(_EllipsesPreTransformerDef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNamedTransformerDef(_EllipsesNamedTransformerDef that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTransformer(_EllipsesTransformer that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesUnparsedTransformer(_EllipsesUnparsedTransformer that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNodeTransformer(_EllipsesNodeTransformer that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesCaseTransformer(_EllipsesCaseTransformer that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesCaseTransformerClause(_EllipsesCaseTransformerClause that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesSyntaxSymbol(_EllipsesSyntaxSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesPrefixedSymbol(_EllipsesPrefixedSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesOptionalSymbol(_EllipsesOptionalSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesRepeatSymbol(_EllipsesRepeatSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesRepeatOneOrMoreSymbol(_EllipsesRepeatOneOrMoreSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNoWhitespaceSymbol(_EllipsesNoWhitespaceSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesGroupSymbol(_EllipsesGroupSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesSpecialSymbol(_EllipsesSpecialSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesAnyCharacterSymbol(_EllipsesAnyCharacterSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesWhitespaceSymbol(_EllipsesWhitespaceSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTabSymbol(_EllipsesTabSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesFormfeedSymbol(_EllipsesFormfeedSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesCarriageReturnSymbol(_EllipsesCarriageReturnSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBackspaceSymbol(_EllipsesBackspaceSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNewlineSymbol(_EllipsesNewlineSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBreaklineSymbol(_EllipsesBreaklineSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesItemSymbol(_EllipsesItemSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNonterminalSymbol(_EllipsesNonterminalSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesKeywordSymbol(_EllipsesKeywordSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTokenSymbol(_EllipsesTokenSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesNotPredicateSymbol(_EllipsesNotPredicateSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesAndPredicateSymbol(_EllipsesAndPredicateSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesCharacterClassSymbol(_EllipsesCharacterClassSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesCharacterSymbol(_EllipsesCharacterSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesCharSymbol(_EllipsesCharSymbol that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesCharacterInterval(_EllipsesCharacterInterval that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesLink(_EllipsesLink that) {
        return defaultEllipsesNode(that);
    }

    public RetType forTemplateGapAbstractNode(TemplateGapAbstractNode that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapCompilationUnit(TemplateGapCompilationUnit that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapComponent(TemplateGapComponent that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapApi(TemplateGapApi that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapImport(TemplateGapImport that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapImportedNames(TemplateGapImportedNames that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapImportStar(TemplateGapImportStar that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapImportNames(TemplateGapImportNames that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapImportApi(TemplateGapImportApi that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapAliasedSimpleName(TemplateGapAliasedSimpleName that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapAliasedAPIName(TemplateGapAliasedAPIName that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapDecl(TemplateGapDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTraitObjectDecl(TemplateGapTraitObjectDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTraitDecl(TemplateGapTraitDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapObjectDecl(TemplateGapObjectDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapVarDecl(TemplateGapVarDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapFnDecl(TemplateGapFnDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGap_RewriteFnOverloadDecl(TemplateGap_RewriteFnOverloadDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGap_RewriteObjectExprDecl(TemplateGap_RewriteObjectExprDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGap_RewriteFunctionalMethodDecl(TemplateGap_RewriteFunctionalMethodDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapDimUnitDecl(TemplateGapDimUnitDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapDimDecl(TemplateGapDimDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapUnitDecl(TemplateGapUnitDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTestDecl(TemplateGapTestDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapPropertyDecl(TemplateGapPropertyDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTypeAlias(TemplateGapTypeAlias that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapGrammarDecl(TemplateGapGrammarDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapGrammarMemberDecl(TemplateGapGrammarMemberDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNonterminalDecl(TemplateGapNonterminalDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNonterminalDef(TemplateGapNonterminalDef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNonterminalExtensionDef(TemplateGapNonterminalExtensionDef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBinding(TemplateGapBinding that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapLValue(TemplateGapLValue that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapParam(TemplateGapParam that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapExpr(TemplateGapExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapDummyExpr(TemplateGapDummyExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTypeAnnotatedExpr(TemplateGapTypeAnnotatedExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapAsExpr(TemplateGapAsExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapAsIfExpr(TemplateGapAsIfExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapAssignment(TemplateGapAssignment that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBlock(TemplateGapBlock that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapDo(TemplateGapDo that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapCaseExpr(TemplateGapCaseExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapIf(TemplateGapIf that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapLabel(TemplateGapLabel that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapAbstractObjectExpr(TemplateGapAbstractObjectExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapObjectExpr(TemplateGapObjectExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGap_RewriteObjectExpr(TemplateGap_RewriteObjectExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTry(TemplateGapTry that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTupleExpr(TemplateGapTupleExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTypecase(TemplateGapTypecase that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapWhile(TemplateGapWhile that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapFor(TemplateGapFor that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBigOpApp(TemplateGapBigOpApp that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapAccumulator(TemplateGapAccumulator that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapArrayComprehension(TemplateGapArrayComprehension that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapAtomicExpr(TemplateGapAtomicExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapExit(TemplateGapExit that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapSpawn(TemplateGapSpawn that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapThrow(TemplateGapThrow that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTryAtomicExpr(TemplateGapTryAtomicExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapFnExpr(TemplateGapFnExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapLetExpr(TemplateGapLetExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapLetFn(TemplateGapLetFn that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapLocalVarDecl(TemplateGapLocalVarDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapSimpleExpr(TemplateGapSimpleExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapSubscriptExpr(TemplateGapSubscriptExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapPrimary(TemplateGapPrimary that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapLiteralExpr(TemplateGapLiteralExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNumberLiteralExpr(TemplateGapNumberLiteralExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapFloatLiteralExpr(TemplateGapFloatLiteralExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapIntLiteralExpr(TemplateGapIntLiteralExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapCharLiteralExpr(TemplateGapCharLiteralExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapStringLiteralExpr(TemplateGapStringLiteralExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapVoidLiteralExpr(TemplateGapVoidLiteralExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBooleanLiteralExpr(TemplateGapBooleanLiteralExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapVarRef(TemplateGapVarRef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapFieldRef(TemplateGapFieldRef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapFunctionalRef(TemplateGapFunctionalRef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapFnRef(TemplateGapFnRef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapOpRef(TemplateGapOpRef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGap_RewriteFnRef(TemplateGap_RewriteFnRef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGap_RewriteObjectExprRef(TemplateGap_RewriteObjectExprRef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapJuxt(TemplateGapJuxt that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGap_RewriteFnApp(TemplateGap_RewriteFnApp that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapOpExpr(TemplateGapOpExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapAmbiguousMultifixOpExpr(TemplateGapAmbiguousMultifixOpExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapChainExpr(TemplateGapChainExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapCoercionInvocation(TemplateGapCoercionInvocation that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTraitCoercionInvocation(TemplateGapTraitCoercionInvocation that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTupleCoercionInvocation(TemplateGapTupleCoercionInvocation that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapArrowCoercionInvocation(TemplateGapArrowCoercionInvocation that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapUnionCoercionInvocation(TemplateGapUnionCoercionInvocation that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapMethodInvocation(TemplateGapMethodInvocation that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapMathPrimary(TemplateGapMathPrimary that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapArrayExpr(TemplateGapArrayExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapArrayElement(TemplateGapArrayElement that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapArrayElements(TemplateGapArrayElements that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapType(TemplateGapType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBaseType(TemplateGapBaseType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapAnyType(TemplateGapAnyType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBottomType(TemplateGapBottomType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapUnknownType(TemplateGapUnknownType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapSelfType(TemplateGapSelfType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTraitSelfType(TemplateGapTraitSelfType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapObjectExprType(TemplateGapObjectExprType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNamedType(TemplateGapNamedType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapVarType(TemplateGapVarType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTraitType(TemplateGapTraitType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapArrayType(TemplateGapArrayType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapMatrixType(TemplateGapMatrixType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTaggedDimType(TemplateGapTaggedDimType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTupleType(TemplateGapTupleType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapArrowType(TemplateGapArrowType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBoundType(TemplateGapBoundType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapIntersectionType(TemplateGapIntersectionType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapUnionType(TemplateGapUnionType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapFixedPointType(TemplateGapFixedPointType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapLabelType(TemplateGapLabelType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapDimExpr(TemplateGapDimExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapDimBase(TemplateGapDimBase that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapDimRef(TemplateGapDimRef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapDimExponent(TemplateGapDimExponent that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapPattern(TemplateGapPattern that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapPatternArgs(TemplateGapPatternArgs that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapPatternBinding(TemplateGapPatternBinding that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapPlainPattern(TemplateGapPlainPattern that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTypePattern(TemplateGapTypePattern that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNestedPattern(TemplateGapNestedPattern that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapStaticArg(TemplateGapStaticArg that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTypeArg(TemplateGapTypeArg that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapIntArg(TemplateGapIntArg that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBoolArg(TemplateGapBoolArg that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapOpArg(TemplateGapOpArg that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapDimArg(TemplateGapDimArg that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapUnitArg(TemplateGapUnitArg that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapStaticExpr(TemplateGapStaticExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapIntExpr(TemplateGapIntExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapIntBase(TemplateGapIntBase that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapIntRef(TemplateGapIntRef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapIntBinaryOp(TemplateGapIntBinaryOp that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBoolExpr(TemplateGapBoolExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBoolBase(TemplateGapBoolBase that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBoolRef(TemplateGapBoolRef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBoolConstraint(TemplateGapBoolConstraint that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBoolUnaryOp(TemplateGapBoolUnaryOp that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBoolBinaryOp(TemplateGapBoolBinaryOp that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapUnitExpr(TemplateGapUnitExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapUnitRef(TemplateGapUnitRef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapUnitBinaryOp(TemplateGapUnitBinaryOp that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapEffect(TemplateGapEffect that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapWhereClause(TemplateGapWhereClause that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapWhereBinding(TemplateGapWhereBinding that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapWhereConstraint(TemplateGapWhereConstraint that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapWhereExtends(TemplateGapWhereExtends that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapWhereTypeAlias(TemplateGapWhereTypeAlias that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapWhereCoerces(TemplateGapWhereCoerces that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapWhereEquals(TemplateGapWhereEquals that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapUnitConstraint(TemplateGapUnitConstraint that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapIntConstraint(TemplateGapIntConstraint that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBoolConstraintExpr(TemplateGapBoolConstraintExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapContract(TemplateGapContract that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapEnsuresClause(TemplateGapEnsuresClause that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapStaticParam(TemplateGapStaticParam that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapName(TemplateGapName that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapAPIName(TemplateGapAPIName that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapIdOrOpOrAnonymousName(TemplateGapIdOrOpOrAnonymousName that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapIdOrOp(TemplateGapIdOrOp that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapId(TemplateGapId that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapOp(TemplateGapOp that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNamedOp(TemplateGapNamedOp that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGap_InferenceVarOp(TemplateGap_InferenceVarOp that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapAnonymousName(TemplateGapAnonymousName that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapAnonymousFnName(TemplateGapAnonymousFnName that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapConstructorFnName(TemplateGapConstructorFnName that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapArrayComprehensionClause(TemplateGapArrayComprehensionClause that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapKeywordExpr(TemplateGapKeywordExpr that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapCaseClause(TemplateGapCaseClause that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapCatch(TemplateGapCatch that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapCatchClause(TemplateGapCatchClause that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapIfClause(TemplateGapIfClause that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTypecaseClause(TemplateGapTypecaseClause that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapExtentRange(TemplateGapExtentRange that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapGeneratorClause(TemplateGapGeneratorClause that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapKeywordType(TemplateGapKeywordType that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTraitTypeWhere(TemplateGapTraitTypeWhere that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapIndices(TemplateGapIndices that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapMathItem(TemplateGapMathItem that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapExprMI(TemplateGapExprMI that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapParenthesisDelimitedMI(TemplateGapParenthesisDelimitedMI that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNonParenthesisDelimitedMI(TemplateGapNonParenthesisDelimitedMI that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNonExprMI(TemplateGapNonExprMI that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapExponentiationMI(TemplateGapExponentiationMI that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapSubscriptingMI(TemplateGapSubscriptingMI that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapOverloading(TemplateGapOverloading that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNonterminalHeader(TemplateGapNonterminalHeader that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNonterminalParameter(TemplateGapNonterminalParameter that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapSyntaxDecl(TemplateGapSyntaxDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapSyntaxDef(TemplateGapSyntaxDef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapSuperSyntaxDef(TemplateGapSuperSyntaxDef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTransformerDecl(TemplateGapTransformerDecl that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapPreTransformerDef(TemplateGapPreTransformerDef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNamedTransformerDef(TemplateGapNamedTransformerDef that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTransformer(TemplateGapTransformer that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapUnparsedTransformer(TemplateGapUnparsedTransformer that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNodeTransformer(TemplateGapNodeTransformer that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapCaseTransformer(TemplateGapCaseTransformer that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapCaseTransformerClause(TemplateGapCaseTransformerClause that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapSyntaxSymbol(TemplateGapSyntaxSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapPrefixedSymbol(TemplateGapPrefixedSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapOptionalSymbol(TemplateGapOptionalSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapRepeatSymbol(TemplateGapRepeatSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapRepeatOneOrMoreSymbol(TemplateGapRepeatOneOrMoreSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNoWhitespaceSymbol(TemplateGapNoWhitespaceSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapGroupSymbol(TemplateGapGroupSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapSpecialSymbol(TemplateGapSpecialSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapAnyCharacterSymbol(TemplateGapAnyCharacterSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapWhitespaceSymbol(TemplateGapWhitespaceSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTabSymbol(TemplateGapTabSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapFormfeedSymbol(TemplateGapFormfeedSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapCarriageReturnSymbol(TemplateGapCarriageReturnSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBackspaceSymbol(TemplateGapBackspaceSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNewlineSymbol(TemplateGapNewlineSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBreaklineSymbol(TemplateGapBreaklineSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapItemSymbol(TemplateGapItemSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNonterminalSymbol(TemplateGapNonterminalSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapKeywordSymbol(TemplateGapKeywordSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTokenSymbol(TemplateGapTokenSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapNotPredicateSymbol(TemplateGapNotPredicateSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapAndPredicateSymbol(TemplateGapAndPredicateSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapCharacterClassSymbol(TemplateGapCharacterClassSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapCharacterSymbol(TemplateGapCharacterSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapCharSymbol(TemplateGapCharSymbol that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapCharacterInterval(TemplateGapCharacterInterval that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapLink(TemplateGapLink that) {
        return defaultTemplateGap(that);
    }


    public RetType recur(AbstractNode that) {
        return that.accept(this);
    }


    public List<RetType> recurOnListOfImport(List<Import> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (Import elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfDecl(List<Decl> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (Decl elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfAPIName(List<APIName> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (APIName elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfIdOrOpOrAnonymousName(List<IdOrOpOrAnonymousName> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (IdOrOpOrAnonymousName elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfAliasedSimpleName(List<AliasedSimpleName> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (AliasedSimpleName elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfAliasedAPIName(List<AliasedAPIName> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (AliasedAPIName elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public Option<RetType> recurOnOptionOfIdOrOpOrAnonymousName(Option<IdOrOpOrAnonymousName> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public Option<RetType> recurOnOptionOfId(Option<Id> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public Option<RetType> recurOnOptionOfSelfType(Option<SelfType> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public List<RetType> recurOnListOfBaseType(List<BaseType> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (BaseType elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfNamedType(List<NamedType> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (NamedType elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public Option<List<RetType>> recurOnOptionOfListOfNamedType(Option<List<NamedType>> that) {
        if (that.isNone()) return Option.<List<RetType>>none();
        else return Option.<List<RetType>>some(recurOnListOfNamedType(that.unwrap()));
    }

    public List<RetType> recurOnListOfLValue(List<LValue> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (LValue elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public Option<RetType> recurOnOptionOfExpr(Option<Expr> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public Option<RetType> recurOnOptionOfIdOrOp(Option<IdOrOp> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public List<RetType> recurOnListOfIdOrOp(List<IdOrOp> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (IdOrOp elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public Option<RetType> recurOnOptionOfType(Option<Type> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public List<RetType> recurOnListOf_RewriteObjectExpr(List<_RewriteObjectExpr> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (_RewriteObjectExpr elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfId(List<Id> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (Id elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfGeneratorClause(List<GeneratorClause> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (GeneratorClause elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfParam(List<Param> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (Param elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfStaticParam(List<StaticParam> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (StaticParam elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfGrammarMemberDecl(List<GrammarMemberDecl> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (GrammarMemberDecl elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfTransformerDecl(List<TransformerDecl> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (TransformerDecl elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfSyntaxDecl(List<SyntaxDecl> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (SyntaxDecl elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public Option<RetType> recurOnOptionOfBaseType(Option<BaseType> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public Option<RetType> recurOnOptionOfFunctionalRef(Option<FunctionalRef> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public List<RetType> recurOnListOfExpr(List<Expr> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (Expr elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfBlock(List<Block> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (Block elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfCaseClause(List<CaseClause> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (CaseClause elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public Option<RetType> recurOnOptionOfBlock(Option<Block> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public List<RetType> recurOnListOfIfClause(List<IfClause> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (IfClause elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfStaticArg(List<StaticArg> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (StaticArg elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public Option<RetType> recurOnOptionOfCatch(Option<Catch> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public List<RetType> recurOnListOfKeywordExpr(List<KeywordExpr> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (KeywordExpr elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfTypecaseClause(List<TypecaseClause> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (TypecaseClause elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfArrayComprehensionClause(List<ArrayComprehensionClause> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (ArrayComprehensionClause elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfFnDecl(List<FnDecl> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (FnDecl elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public Option<RetType> recurOnOptionOfOp(Option<Op> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public List<RetType> recurOnListOfOverloading(List<Overloading> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (Overloading elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfLink(List<Link> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (Link elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public Option<RetType> recurOnOptionOfCoercionInvocation(Option<CoercionInvocation> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public List<Option<RetType>> recurOnListOfOptionOfCoercionInvocation(List<Option<CoercionInvocation>> that) {
        java.util.ArrayList<Option<RetType>> accum = new java.util.ArrayList<Option<RetType>>(that.size());
        for (Option<CoercionInvocation> elt : that) {
            accum.add(recurOnOptionOfCoercionInvocation(elt));
        }
        return accum;
    }

    public Option<Option<RetType>> recurOnOptionOfOptionOfCoercionInvocation(Option<Option<CoercionInvocation>> that) {
        if (that.isNone()) return Option.<Option<RetType>>none();
        else return Option.<Option<RetType>>some(recurOnOptionOfCoercionInvocation(that.unwrap()));
    }

    public List<RetType> recurOnListOfType(List<Type> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (Type elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfMathItem(List<MathItem> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (MathItem elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfArrayExpr(List<ArrayExpr> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (ArrayExpr elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfExtentRange(List<ExtentRange> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (ExtentRange elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfKeywordType(List<KeywordType> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (KeywordType elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfPatternBinding(List<PatternBinding> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (PatternBinding elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public Option<List<RetType>> recurOnOptionOfListOfType(Option<List<Type>> that) {
        if (that.isNone()) return Option.<List<RetType>>none();
        else return Option.<List<RetType>>some(recurOnListOfType(that.unwrap()));
    }

    public List<RetType> recurOnListOfWhereBinding(List<WhereBinding> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (WhereBinding elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfWhereConstraint(List<WhereConstraint> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (WhereConstraint elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public Option<List<RetType>> recurOnOptionOfListOfExpr(Option<List<Expr>> that) {
        if (that.isNone()) return Option.<List<RetType>>none();
        else return Option.<List<RetType>>some(recurOnListOfExpr(that.unwrap()));
    }

    public List<RetType> recurOnListOfEnsuresClause(List<EnsuresClause> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (EnsuresClause elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public Option<List<RetType>> recurOnOptionOfListOfEnsuresClause(Option<List<EnsuresClause>> that) {
        if (that.isNone()) return Option.<List<RetType>>none();
        else return Option.<List<RetType>>some(recurOnListOfEnsuresClause(that.unwrap()));
    }

    public Option<RetType> recurOnOptionOfAPIName(Option<APIName> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public List<RetType> recurOnListOfCatchClause(List<CatchClause> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (CatchClause elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public Option<RetType> recurOnOptionOfStaticArg(Option<StaticArg> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public Option<RetType> recurOnOptionOfWhereClause(Option<WhereClause> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public Option<RetType> recurOnOptionOfArrowType(Option<ArrowType> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public List<RetType> recurOnListOfNonterminalParameter(List<NonterminalParameter> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (NonterminalParameter elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfSyntaxSymbol(List<SyntaxSymbol> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (SyntaxSymbol elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfCaseTransformerClause(List<CaseTransformerClause> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (CaseTransformerClause elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public List<RetType> recurOnListOfCharacterSymbol(List<CharacterSymbol> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (CharacterSymbol elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }
}
