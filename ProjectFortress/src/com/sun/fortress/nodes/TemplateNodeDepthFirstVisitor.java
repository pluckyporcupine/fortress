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

/** A parametric abstract implementation of a visitor over Node that returns a value.
 ** This visitor implements the visitor interface with methods that 
 ** first visit children, and then call forCASEOnly(), passing in 
 ** the values of the visits of the children. (CASE is replaced by the case name.)
 ** By default, each of forCASEOnly delegates to a more general case; at the
 ** top of this delegation tree is defaultCase(), which (unless overridden)
 ** throws an exception.
 **/
@SuppressWarnings(value={"unused"})
public abstract class TemplateNodeDepthFirstVisitor<RetType> extends NodeVisitorLambda<RetType> {
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, an exception is thrown; subclasses may override this behavior.
     * @throws IllegalArgumentException
    **/
    public RetType defaultCase(Node that) {
        throw new IllegalArgumentException("Visitor " + getClass().getName() + " does not support visiting values of type " + that.getClass().getName());
    }

    /* Methods to handle a node after recursion. */
    public RetType forNodeOnly(Node that) {
        return defaultCase(that);
    }

    public RetType forASTNodeOnly(ASTNode that, RetType info_result) {
        return forNodeOnly(that);
    }

    public RetType forGenericOnly(Generic that, RetType info_result, RetType header_result) {
        return forASTNodeOnly(that, info_result);
    }

    public RetType forObjectConstructorOnly(ObjectConstructor that, RetType info_result, RetType header_result) {
        return forGenericOnly(that, info_result, header_result);
    }

    public RetType forAbstractNodeOnly(AbstractNode that, RetType info_result) {
        return forASTNodeOnly(that, info_result);
    }

    public RetType forCompilationUnitOnly(CompilationUnit that, RetType info_result, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forComponentOnly(Component that, RetType info_result, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result, List<RetType> exports_result) {
        return forCompilationUnitOnly(that, info_result, name_result, imports_result, decls_result, comprises_result);
    }

    public RetType forApiOnly(Api that, RetType info_result, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result) {
        return forCompilationUnitOnly(that, info_result, name_result, imports_result, decls_result, comprises_result);
    }

    public RetType forImportOnly(Import that, RetType info_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forImportedNamesOnly(ImportedNames that, RetType info_result, RetType apiName_result) {
        return forImportOnly(that, info_result);
    }

    public RetType forImportStarOnly(ImportStar that, RetType info_result, RetType apiName_result, List<RetType> exceptNames_result) {
        return forImportedNamesOnly(that, info_result, apiName_result);
    }

    public RetType forImportNamesOnly(ImportNames that, RetType info_result, RetType apiName_result, List<RetType> aliasedNames_result) {
        return forImportedNamesOnly(that, info_result, apiName_result);
    }

    public RetType forImportApiOnly(ImportApi that, RetType info_result, List<RetType> apis_result) {
        return forImportOnly(that, info_result);
    }

    public RetType forAliasedSimpleNameOnly(AliasedSimpleName that, RetType info_result, RetType name_result, Option<RetType> alias_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forAliasedAPINameOnly(AliasedAPIName that, RetType info_result, RetType apiName_result, Option<RetType> alias_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forDeclOnly(Decl that, RetType info_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forTraitObjectDeclOnly(TraitObjectDecl that, RetType info_result, RetType header_result, Option<RetType> selfType_result) {
        return forDeclOnly(that, info_result);
    }

    public RetType forTraitDeclOnly(TraitDecl that, RetType info_result, RetType header_result, Option<RetType> selfType_result, List<RetType> excludesClause_result, Option<List<RetType>> comprisesClause_result) {
        return forTraitObjectDeclOnly(that, info_result, header_result, selfType_result);
    }

    public RetType forObjectDeclOnly(ObjectDecl that, RetType info_result, RetType header_result, Option<RetType> selfType_result) {
        return forTraitObjectDeclOnly(that, info_result, header_result, selfType_result);
    }

    public RetType forVarDeclOnly(VarDecl that, RetType info_result, List<RetType> lhs_result, Option<RetType> init_result) {
        return forDeclOnly(that, info_result);
    }

    public RetType forFnDeclOnly(FnDecl that, RetType info_result, RetType header_result, RetType unambiguousName_result, Option<RetType> body_result, Option<RetType> implementsUnambiguousName_result) {
        return forDeclOnly(that, info_result);
    }

    public RetType for_RewriteFnOverloadDeclOnly(_RewriteFnOverloadDecl that, RetType info_result, RetType name_result, List<RetType> fns_result, Option<RetType> type_result) {
        return forDeclOnly(that, info_result);
    }

    public RetType for_RewriteObjectExprDeclOnly(_RewriteObjectExprDecl that, RetType info_result, List<RetType> objectExprs_result) {
        return forDeclOnly(that, info_result);
    }

    public RetType for_RewriteFunctionalMethodDeclOnly(_RewriteFunctionalMethodDecl that, RetType info_result) {
        return forDeclOnly(that, info_result);
    }

    public RetType forDimUnitDeclOnly(DimUnitDecl that, RetType info_result) {
        return forDeclOnly(that, info_result);
    }

    public RetType forDimDeclOnly(DimDecl that, RetType info_result, RetType dimId_result, Option<RetType> derived_result, Option<RetType> defaultId_result) {
        return forDimUnitDeclOnly(that, info_result);
    }

    public RetType forUnitDeclOnly(UnitDecl that, RetType info_result, List<RetType> units_result, Option<RetType> dimType_result, Option<RetType> defExpr_result) {
        return forDimUnitDeclOnly(that, info_result);
    }

    public RetType forTestDeclOnly(TestDecl that, RetType info_result, RetType name_result, List<RetType> gens_result, RetType expr_result) {
        return forDeclOnly(that, info_result);
    }

    public RetType forPropertyDeclOnly(PropertyDecl that, RetType info_result, Option<RetType> name_result, List<RetType> params_result, RetType expr_result) {
        return forDeclOnly(that, info_result);
    }

    public RetType forTypeAliasOnly(TypeAlias that, RetType info_result, RetType name_result, List<RetType> staticParams_result, RetType typeDef_result) {
        return forDeclOnly(that, info_result);
    }

    public RetType forGrammarDeclOnly(GrammarDecl that, RetType info_result, RetType name_result, List<RetType> extendsClause_result, List<RetType> members_result, List<RetType> transformers_result) {
        return forDeclOnly(that, info_result);
    }

    public RetType forGrammarMemberDeclOnly(GrammarMemberDecl that, RetType info_result, RetType name_result) {
        return forDeclOnly(that, info_result);
    }

    public RetType forNonterminalDeclOnly(NonterminalDecl that, RetType info_result, RetType name_result, List<RetType> syntaxDecls_result) {
        return forGrammarMemberDeclOnly(that, info_result, name_result);
    }

    public RetType forNonterminalDefOnly(NonterminalDef that, RetType info_result, RetType name_result, List<RetType> syntaxDecls_result, RetType header_result, Option<RetType> astType_result) {
        return forNonterminalDeclOnly(that, info_result, name_result, syntaxDecls_result);
    }

    public RetType forNonterminalExtensionDefOnly(NonterminalExtensionDef that, RetType info_result, RetType name_result, List<RetType> syntaxDecls_result) {
        return forNonterminalDeclOnly(that, info_result, name_result, syntaxDecls_result);
    }

    public RetType forBindingOnly(Binding that, RetType info_result, RetType name_result, Option<RetType> idType_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forLValueOnly(LValue that, RetType info_result, RetType name_result, Option<RetType> idType_result) {
        return forBindingOnly(that, info_result, name_result, idType_result);
    }

    public RetType forParamOnly(Param that, RetType info_result, RetType name_result, Option<RetType> idType_result, Option<RetType> defaultExpr_result, Option<RetType> varargsType_result) {
        return forBindingOnly(that, info_result, name_result, idType_result);
    }

    public RetType forExprOnly(Expr that, RetType info_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forDummyExprOnly(DummyExpr that, RetType info_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forTypeAnnotatedExprOnly(TypeAnnotatedExpr that, RetType info_result, RetType expr_result, RetType annType_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forAsExprOnly(AsExpr that, RetType info_result, RetType expr_result, RetType annType_result) {
        return forTypeAnnotatedExprOnly(that, info_result, expr_result, annType_result);
    }

    public RetType forAsIfExprOnly(AsIfExpr that, RetType info_result, RetType expr_result, RetType annType_result) {
        return forTypeAnnotatedExprOnly(that, info_result, expr_result, annType_result);
    }

    public RetType forAssignmentOnly(Assignment that, RetType info_result, List<RetType> lhs_result, Option<RetType> assignOp_result, RetType rhs_result, List<RetType> assignmentInfos_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forBlockOnly(Block that, RetType info_result, Option<RetType> loc_result, List<RetType> exprs_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forDoOnly(Do that, RetType info_result, List<RetType> fronts_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forCaseExprOnly(CaseExpr that, RetType info_result, Option<RetType> param_result, Option<RetType> compare_result, RetType equalsOp_result, RetType inOp_result, List<RetType> clauses_result, Option<RetType> elseClause_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forIfOnly(If that, RetType info_result, List<RetType> clauses_result, Option<RetType> elseClause_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forLabelOnly(Label that, RetType info_result, RetType name_result, RetType body_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forAbstractObjectExprOnly(AbstractObjectExpr that, RetType info_result, RetType header_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forObjectExprOnly(ObjectExpr that, RetType info_result, RetType header_result, Option<RetType> selfType_result) {
        return forAbstractObjectExprOnly(that, info_result, header_result);
    }

    public RetType for_RewriteObjectExprOnly(_RewriteObjectExpr that, RetType info_result, RetType header_result, List<RetType> staticArgs_result) {
        return forAbstractObjectExprOnly(that, info_result, header_result);
    }

    public RetType forTryOnly(Try that, RetType info_result, RetType body_result, Option<RetType> catchClause_result, List<RetType> forbidClause_result, Option<RetType> finallyClause_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forTupleExprOnly(TupleExpr that, RetType info_result, List<RetType> exprs_result, Option<RetType> varargs_result, List<RetType> keywords_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forTypecaseOnly(Typecase that, RetType info_result, RetType bindExpr_result, List<RetType> clauses_result, Option<RetType> elseClause_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forWhileOnly(While that, RetType info_result, RetType testExpr_result, RetType body_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forForOnly(For that, RetType info_result, List<RetType> gens_result, RetType body_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forBigOpAppOnly(BigOpApp that, RetType info_result, List<RetType> staticArgs_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forAccumulatorOnly(Accumulator that, RetType info_result, List<RetType> staticArgs_result, RetType accOp_result, List<RetType> gens_result, RetType body_result) {
        return forBigOpAppOnly(that, info_result, staticArgs_result);
    }

    public RetType forArrayComprehensionOnly(ArrayComprehension that, RetType info_result, List<RetType> staticArgs_result, List<RetType> clauses_result) {
        return forBigOpAppOnly(that, info_result, staticArgs_result);
    }

    public RetType forAtomicExprOnly(AtomicExpr that, RetType info_result, RetType expr_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forExitOnly(Exit that, RetType info_result, Option<RetType> target_result, Option<RetType> returnExpr_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forSpawnOnly(Spawn that, RetType info_result, RetType body_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forThrowOnly(Throw that, RetType info_result, RetType expr_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forTryAtomicExprOnly(TryAtomicExpr that, RetType info_result, RetType expr_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forFnExprOnly(FnExpr that, RetType info_result, RetType header_result, RetType body_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forLetExprOnly(LetExpr that, RetType info_result, RetType body_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forLetFnOnly(LetFn that, RetType info_result, RetType body_result, List<RetType> fns_result) {
        return forLetExprOnly(that, info_result, body_result);
    }

    public RetType forLocalVarDeclOnly(LocalVarDecl that, RetType info_result, RetType body_result, List<RetType> lhs_result, Option<RetType> rhs_result) {
        return forLetExprOnly(that, info_result, body_result);
    }

    public RetType forSimpleExprOnly(SimpleExpr that, RetType info_result) {
        return forExprOnly(that, info_result);
    }

    public RetType forSubscriptExprOnly(SubscriptExpr that, RetType info_result, RetType obj_result, List<RetType> subs_result, Option<RetType> op_result, List<RetType> staticArgs_result) {
        return forSimpleExprOnly(that, info_result);
    }

    public RetType forPrimaryOnly(Primary that, RetType info_result) {
        return forSimpleExprOnly(that, info_result);
    }

    public RetType forLiteralExprOnly(LiteralExpr that, RetType info_result) {
        return forPrimaryOnly(that, info_result);
    }

    public RetType forNumberLiteralExprOnly(NumberLiteralExpr that, RetType info_result) {
        return forLiteralExprOnly(that, info_result);
    }

    public RetType forFloatLiteralExprOnly(FloatLiteralExpr that, RetType info_result) {
        return forNumberLiteralExprOnly(that, info_result);
    }

    public RetType forIntLiteralExprOnly(IntLiteralExpr that, RetType info_result) {
        return forNumberLiteralExprOnly(that, info_result);
    }

    public RetType forCharLiteralExprOnly(CharLiteralExpr that, RetType info_result) {
        return forLiteralExprOnly(that, info_result);
    }

    public RetType forStringLiteralExprOnly(StringLiteralExpr that, RetType info_result) {
        return forLiteralExprOnly(that, info_result);
    }

    public RetType forVoidLiteralExprOnly(VoidLiteralExpr that, RetType info_result) {
        return forLiteralExprOnly(that, info_result);
    }

    public RetType forBooleanLiteralExprOnly(BooleanLiteralExpr that, RetType info_result) {
        return forLiteralExprOnly(that, info_result);
    }

    public RetType forVarRefOnly(VarRef that, RetType info_result, RetType varId_result, List<RetType> staticArgs_result) {
        return forPrimaryOnly(that, info_result);
    }

    public RetType forFieldRefOnly(FieldRef that, RetType info_result, RetType obj_result, RetType field_result) {
        return forPrimaryOnly(that, info_result);
    }

    public RetType forFunctionalRefOnly(FunctionalRef that, RetType info_result, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result) {
        return forPrimaryOnly(that, info_result);
    }

    public RetType forFnRefOnly(FnRef that, RetType info_result, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result) {
        return forFunctionalRefOnly(that, info_result, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType forOpRefOnly(OpRef that, RetType info_result, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result) {
        return forFunctionalRefOnly(that, info_result, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType for_RewriteFnRefOnly(_RewriteFnRef that, RetType info_result, RetType fnExpr_result, List<RetType> staticArgs_result) {
        return forPrimaryOnly(that, info_result);
    }

    public RetType for_RewriteObjectExprRefOnly(_RewriteObjectExprRef that, RetType info_result, List<RetType> staticArgs_result) {
        return forPrimaryOnly(that, info_result);
    }

    public RetType forJuxtOnly(Juxt that, RetType info_result, RetType multiJuxt_result, RetType infixJuxt_result, List<RetType> exprs_result) {
        return forPrimaryOnly(that, info_result);
    }

    public RetType for_RewriteFnAppOnly(_RewriteFnApp that, RetType info_result, RetType function_result, RetType argument_result) {
        return forPrimaryOnly(that, info_result);
    }

    public RetType forOpExprOnly(OpExpr that, RetType info_result, RetType op_result, List<RetType> args_result) {
        return forPrimaryOnly(that, info_result);
    }

    public RetType forAmbiguousMultifixOpExprOnly(AmbiguousMultifixOpExpr that, RetType info_result, RetType infix_op_result, RetType multifix_op_result, List<RetType> args_result) {
        return forPrimaryOnly(that, info_result);
    }

    public RetType forChainExprOnly(ChainExpr that, RetType info_result, RetType first_result, List<RetType> links_result) {
        return forPrimaryOnly(that, info_result);
    }

    public RetType forCoercionInvocationOnly(CoercionInvocation that, RetType info_result, RetType toType_result, RetType arg_result) {
        return forPrimaryOnly(that, info_result);
    }

    public RetType forTraitCoercionInvocationOnly(TraitCoercionInvocation that, RetType info_result, RetType arg_result, RetType toType_result, RetType coercionFn_result) {
        return forCoercionInvocationOnly(that, info_result, toType_result, arg_result);
    }

    public RetType forTupleCoercionInvocationOnly(TupleCoercionInvocation that, RetType info_result, RetType arg_result, RetType toType_result, List<Option<RetType>> subCoercions_result, Option<Option<RetType>> varargCoercion_result) {
        return forCoercionInvocationOnly(that, info_result, toType_result, arg_result);
    }

    public RetType forArrowCoercionInvocationOnly(ArrowCoercionInvocation that, RetType info_result, RetType arg_result, RetType toType_result, Option<RetType> domainCoercion_result, Option<RetType> rangeCoercion_result) {
        return forCoercionInvocationOnly(that, info_result, toType_result, arg_result);
    }

    public RetType forUnionCoercionInvocationOnly(UnionCoercionInvocation that, RetType info_result, RetType toType_result, RetType arg_result, List<RetType> fromTypes_result, List<Option<RetType>> fromCoercions_result) {
        return forCoercionInvocationOnly(that, info_result, toType_result, arg_result);
    }

    public RetType forMethodInvocationOnly(MethodInvocation that, RetType info_result, RetType obj_result, RetType method_result, List<RetType> staticArgs_result, RetType arg_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result) {
        return forPrimaryOnly(that, info_result);
    }

    public RetType forMathPrimaryOnly(MathPrimary that, RetType info_result, RetType multiJuxt_result, RetType infixJuxt_result, RetType front_result, List<RetType> rest_result) {
        return forPrimaryOnly(that, info_result);
    }

    public RetType forArrayExprOnly(ArrayExpr that, RetType info_result, List<RetType> staticArgs_result) {
        return forPrimaryOnly(that, info_result);
    }

    public RetType forArrayElementOnly(ArrayElement that, RetType info_result, List<RetType> staticArgs_result, RetType element_result) {
        return forArrayExprOnly(that, info_result, staticArgs_result);
    }

    public RetType forArrayElementsOnly(ArrayElements that, RetType info_result, List<RetType> staticArgs_result, List<RetType> elements_result) {
        return forArrayExprOnly(that, info_result, staticArgs_result);
    }

    public RetType forTypeOnly(Type that, RetType info_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forBaseTypeOnly(BaseType that, RetType info_result) {
        return forTypeOnly(that, info_result);
    }

    public RetType forAnyTypeOnly(AnyType that, RetType info_result) {
        return forBaseTypeOnly(that, info_result);
    }

    public RetType forBottomTypeOnly(BottomType that, RetType info_result) {
        return forBaseTypeOnly(that, info_result);
    }

    public RetType forUnknownTypeOnly(UnknownType that, RetType info_result) {
        return forBaseTypeOnly(that, info_result);
    }

    public RetType forSelfTypeOnly(SelfType that, RetType info_result) {
        return forBaseTypeOnly(that, info_result);
    }

    public RetType forTraitSelfTypeOnly(TraitSelfType that, RetType info_result, RetType named_result, List<RetType> comprised_result) {
        return forSelfTypeOnly(that, info_result);
    }

    public RetType forObjectExprTypeOnly(ObjectExprType that, RetType info_result, List<RetType> extended_result) {
        return forSelfTypeOnly(that, info_result);
    }

    public RetType forNamedTypeOnly(NamedType that, RetType info_result, RetType name_result) {
        return forBaseTypeOnly(that, info_result);
    }

    public RetType for_InferenceVarTypeOnly(_InferenceVarType that, RetType info_result, RetType name_result) {
        return forNamedTypeOnly(that, info_result, name_result);
    }

    public RetType forVarTypeOnly(VarType that, RetType info_result, RetType name_result) {
        return forNamedTypeOnly(that, info_result, name_result);
    }

    public RetType forTraitTypeOnly(TraitType that, RetType info_result, RetType name_result, List<RetType> args_result, List<RetType> traitStaticParams_result) {
        return forNamedTypeOnly(that, info_result, name_result);
    }

    public RetType forAbbreviatedTypeOnly(AbbreviatedType that, RetType info_result, RetType elemType_result) {
        return forBaseTypeOnly(that, info_result);
    }

    public RetType forArrayTypeOnly(ArrayType that, RetType info_result, RetType elemType_result, RetType indices_result) {
        return forAbbreviatedTypeOnly(that, info_result, elemType_result);
    }

    public RetType forMatrixTypeOnly(MatrixType that, RetType info_result, RetType elemType_result, List<RetType> dimensions_result) {
        return forAbbreviatedTypeOnly(that, info_result, elemType_result);
    }

    public RetType forTaggedDimTypeOnly(TaggedDimType that, RetType info_result, RetType elemType_result, RetType dimExpr_result, Option<RetType> unitExpr_result) {
        return forAbbreviatedTypeOnly(that, info_result, elemType_result);
    }

    public RetType forTaggedUnitTypeOnly(TaggedUnitType that, RetType info_result, RetType elemType_result, RetType unitExpr_result) {
        return forAbbreviatedTypeOnly(that, info_result, elemType_result);
    }

    public RetType forTupleTypeOnly(TupleType that, RetType info_result, List<RetType> elements_result, Option<RetType> varargs_result, List<RetType> keywords_result) {
        return forTypeOnly(that, info_result);
    }

    public RetType forArrowTypeOnly(ArrowType that, RetType info_result, RetType domain_result, RetType range_result, RetType effect_result, Option<RetType> methodInfo_result) {
        return forTypeOnly(that, info_result);
    }

    public RetType forBoundTypeOnly(BoundType that, RetType info_result, List<RetType> elements_result) {
        return forTypeOnly(that, info_result);
    }

    public RetType forIntersectionTypeOnly(IntersectionType that, RetType info_result, List<RetType> elements_result) {
        return forBoundTypeOnly(that, info_result, elements_result);
    }

    public RetType forUnionTypeOnly(UnionType that, RetType info_result, List<RetType> elements_result) {
        return forBoundTypeOnly(that, info_result, elements_result);
    }

    public RetType forFixedPointTypeOnly(FixedPointType that, RetType info_result, RetType name_result, RetType body_result) {
        return forTypeOnly(that, info_result);
    }

    public RetType forLabelTypeOnly(LabelType that, RetType info_result) {
        return forTypeOnly(that, info_result);
    }

    public RetType forDimExprOnly(DimExpr that, RetType info_result) {
        return forTypeOnly(that, info_result);
    }

    public RetType forDimBaseOnly(DimBase that, RetType info_result) {
        return forDimExprOnly(that, info_result);
    }

    public RetType forDimRefOnly(DimRef that, RetType info_result, RetType name_result) {
        return forDimExprOnly(that, info_result);
    }

    public RetType forDimExponentOnly(DimExponent that, RetType info_result, RetType base_result, RetType power_result) {
        return forDimExprOnly(that, info_result);
    }

    public RetType forDimUnaryOpOnly(DimUnaryOp that, RetType info_result, RetType dimVal_result, RetType op_result) {
        return forDimExprOnly(that, info_result);
    }

    public RetType forDimBinaryOpOnly(DimBinaryOp that, RetType info_result, RetType left_result, RetType right_result, RetType op_result) {
        return forDimExprOnly(that, info_result);
    }

    public RetType forPatternOnly(Pattern that, RetType info_result, Option<RetType> name_result, RetType patterns_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forPatternArgsOnly(PatternArgs that, RetType info_result, List<RetType> patterns_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forPatternBindingOnly(PatternBinding that, RetType info_result, Option<RetType> field_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forPlainPatternOnly(PlainPattern that, RetType info_result, Option<RetType> field_result, RetType name_result, Option<RetType> idType_result) {
        return forPatternBindingOnly(that, info_result, field_result);
    }

    public RetType forTypePatternOnly(TypePattern that, RetType info_result, Option<RetType> field_result, RetType typ_result) {
        return forPatternBindingOnly(that, info_result, field_result);
    }

    public RetType forNestedPatternOnly(NestedPattern that, RetType info_result, Option<RetType> field_result, RetType pat_result) {
        return forPatternBindingOnly(that, info_result, field_result);
    }

    public RetType forStaticArgOnly(StaticArg that, RetType info_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forTypeArgOnly(TypeArg that, RetType info_result, RetType typeArg_result) {
        return forStaticArgOnly(that, info_result);
    }

    public RetType forIntArgOnly(IntArg that, RetType info_result, RetType intVal_result) {
        return forStaticArgOnly(that, info_result);
    }

    public RetType forBoolArgOnly(BoolArg that, RetType info_result, RetType boolArg_result) {
        return forStaticArgOnly(that, info_result);
    }

    public RetType forOpArgOnly(OpArg that, RetType info_result, RetType id_result) {
        return forStaticArgOnly(that, info_result);
    }

    public RetType forDimArgOnly(DimArg that, RetType info_result, RetType dimArg_result) {
        return forStaticArgOnly(that, info_result);
    }

    public RetType forUnitArgOnly(UnitArg that, RetType info_result, RetType unitArg_result) {
        return forStaticArgOnly(that, info_result);
    }

    public RetType forStaticExprOnly(StaticExpr that, RetType info_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forIntExprOnly(IntExpr that, RetType info_result) {
        return forStaticExprOnly(that, info_result);
    }

    public RetType forIntBaseOnly(IntBase that, RetType info_result, RetType intVal_result) {
        return forIntExprOnly(that, info_result);
    }

    public RetType forIntRefOnly(IntRef that, RetType info_result, RetType name_result) {
        return forIntExprOnly(that, info_result);
    }

    public RetType forIntBinaryOpOnly(IntBinaryOp that, RetType info_result, RetType left_result, RetType right_result, RetType op_result) {
        return forIntExprOnly(that, info_result);
    }

    public RetType forBoolExprOnly(BoolExpr that, RetType info_result) {
        return forStaticExprOnly(that, info_result);
    }

    public RetType forBoolBaseOnly(BoolBase that, RetType info_result) {
        return forBoolExprOnly(that, info_result);
    }

    public RetType forBoolRefOnly(BoolRef that, RetType info_result, RetType name_result) {
        return forBoolExprOnly(that, info_result);
    }

    public RetType forBoolConstraintOnly(BoolConstraint that, RetType info_result) {
        return forBoolExprOnly(that, info_result);
    }

    public RetType forBoolUnaryOpOnly(BoolUnaryOp that, RetType info_result, RetType boolVal_result, RetType op_result) {
        return forBoolConstraintOnly(that, info_result);
    }

    public RetType forBoolBinaryOpOnly(BoolBinaryOp that, RetType info_result, RetType left_result, RetType right_result, RetType op_result) {
        return forBoolConstraintOnly(that, info_result);
    }

    public RetType forUnitExprOnly(UnitExpr that, RetType info_result) {
        return forStaticExprOnly(that, info_result);
    }

    public RetType forUnitRefOnly(UnitRef that, RetType info_result, RetType name_result) {
        return forUnitExprOnly(that, info_result);
    }

    public RetType forUnitBinaryOpOnly(UnitBinaryOp that, RetType info_result, RetType left_result, RetType right_result, RetType op_result) {
        return forUnitExprOnly(that, info_result);
    }

    public RetType forEffectOnly(Effect that, RetType info_result, Option<List<RetType>> throwsClause_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forWhereClauseOnly(WhereClause that, RetType info_result, List<RetType> bindings_result, List<RetType> constraints_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forWhereBindingOnly(WhereBinding that, RetType info_result, RetType name_result, List<RetType> supers_result, RetType kind_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forWhereConstraintOnly(WhereConstraint that, RetType info_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forWhereExtendsOnly(WhereExtends that, RetType info_result, RetType name_result, List<RetType> supers_result) {
        return forWhereConstraintOnly(that, info_result);
    }

    public RetType forWhereTypeAliasOnly(WhereTypeAlias that, RetType info_result, RetType alias_result) {
        return forWhereConstraintOnly(that, info_result);
    }

    public RetType forWhereCoercesOnly(WhereCoerces that, RetType info_result, RetType left_result, RetType right_result) {
        return forWhereConstraintOnly(that, info_result);
    }

    public RetType forWhereEqualsOnly(WhereEquals that, RetType info_result, RetType left_result, RetType right_result) {
        return forWhereConstraintOnly(that, info_result);
    }

    public RetType forUnitConstraintOnly(UnitConstraint that, RetType info_result, RetType name_result) {
        return forWhereConstraintOnly(that, info_result);
    }

    public RetType forIntConstraintOnly(IntConstraint that, RetType info_result, RetType left_result, RetType right_result, RetType op_result) {
        return forWhereConstraintOnly(that, info_result);
    }

    public RetType forBoolConstraintExprOnly(BoolConstraintExpr that, RetType info_result, RetType constraint_result) {
        return forWhereConstraintOnly(that, info_result);
    }

    public RetType forContractOnly(Contract that, RetType info_result, Option<List<RetType>> requiresClause_result, Option<List<RetType>> ensuresClause_result, Option<List<RetType>> invariantsClause_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forEnsuresClauseOnly(EnsuresClause that, RetType info_result, RetType post_result, Option<RetType> pre_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forStaticParamOnly(StaticParam that, RetType info_result, RetType name_result, List<RetType> extendsClause_result, List<RetType> dominatesClause_result, Option<RetType> dimParam_result, RetType kind_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forNameOnly(Name that, RetType info_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forAPINameOnly(APIName that, RetType info_result, List<RetType> ids_result) {
        return forNameOnly(that, info_result);
    }

    public RetType forIdOrOpOrAnonymousNameOnly(IdOrOpOrAnonymousName that, RetType info_result, Option<RetType> apiName_result) {
        return forNameOnly(that, info_result);
    }

    public RetType forIdOrOpOnly(IdOrOp that, RetType info_result, Option<RetType> apiName_result) {
        return forIdOrOpOrAnonymousNameOnly(that, info_result, apiName_result);
    }

    public RetType forIdOnly(Id that, RetType info_result, Option<RetType> apiName_result) {
        return forIdOrOpOnly(that, info_result, apiName_result);
    }

    public RetType forOpOnly(Op that, RetType info_result, Option<RetType> apiName_result, RetType fixity_result) {
        return forIdOrOpOnly(that, info_result, apiName_result);
    }

    public RetType forNamedOpOnly(NamedOp that, RetType info_result, Option<RetType> apiName_result, RetType fixity_result) {
        return forOpOnly(that, info_result, apiName_result, fixity_result);
    }

    public RetType for_InferenceVarOpOnly(_InferenceVarOp that, RetType info_result, Option<RetType> apiName_result, RetType fixity_result) {
        return forOpOnly(that, info_result, apiName_result, fixity_result);
    }

    public RetType forAnonymousNameOnly(AnonymousName that, RetType info_result, Option<RetType> apiName_result) {
        return forIdOrOpOrAnonymousNameOnly(that, info_result, apiName_result);
    }

    public RetType forAnonymousFnNameOnly(AnonymousFnName that, RetType info_result, Option<RetType> apiName_result) {
        return forAnonymousNameOnly(that, info_result, apiName_result);
    }

    public RetType forConstructorFnNameOnly(ConstructorFnName that, RetType info_result, Option<RetType> apiName_result, RetType constructor_result) {
        return forAnonymousNameOnly(that, info_result, apiName_result);
    }

    public RetType forArrayComprehensionClauseOnly(ArrayComprehensionClause that, RetType info_result, List<RetType> bind_result, RetType init_result, List<RetType> gens_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forKeywordExprOnly(KeywordExpr that, RetType info_result, RetType name_result, RetType init_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forCaseClauseOnly(CaseClause that, RetType info_result, RetType matchClause_result, RetType body_result, Option<RetType> op_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forCatchOnly(Catch that, RetType info_result, RetType name_result, List<RetType> clauses_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forCatchClauseOnly(CatchClause that, RetType info_result, RetType matchType_result, RetType body_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forIfClauseOnly(IfClause that, RetType info_result, RetType testClause_result, RetType body_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forTypecaseClauseOnly(TypecaseClause that, RetType info_result, Option<RetType> name_result, RetType matchType_result, RetType body_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forExtentRangeOnly(ExtentRange that, RetType info_result, Option<RetType> base_result, Option<RetType> size_result, Option<RetType> op_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forGeneratorClauseOnly(GeneratorClause that, RetType info_result, List<RetType> bind_result, RetType init_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forKeywordTypeOnly(KeywordType that, RetType info_result, RetType name_result, RetType keywordType_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forTraitTypeWhereOnly(TraitTypeWhere that, RetType info_result, RetType baseType_result, Option<RetType> whereClause_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forIndicesOnly(Indices that, RetType info_result, List<RetType> extents_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forMathItemOnly(MathItem that, RetType info_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forExprMIOnly(ExprMI that, RetType info_result, RetType expr_result) {
        return forMathItemOnly(that, info_result);
    }

    public RetType forParenthesisDelimitedMIOnly(ParenthesisDelimitedMI that, RetType info_result, RetType expr_result) {
        return forExprMIOnly(that, info_result, expr_result);
    }

    public RetType forNonParenthesisDelimitedMIOnly(NonParenthesisDelimitedMI that, RetType info_result, RetType expr_result) {
        return forExprMIOnly(that, info_result, expr_result);
    }

    public RetType forNonExprMIOnly(NonExprMI that, RetType info_result) {
        return forMathItemOnly(that, info_result);
    }

    public RetType forExponentiationMIOnly(ExponentiationMI that, RetType info_result, RetType op_result, Option<RetType> expr_result) {
        return forNonExprMIOnly(that, info_result);
    }

    public RetType forSubscriptingMIOnly(SubscriptingMI that, RetType info_result, RetType op_result, List<RetType> exprs_result, List<RetType> staticArgs_result) {
        return forNonExprMIOnly(that, info_result);
    }

    public RetType forOverloadingOnly(Overloading that, RetType info_result, RetType unambiguousName_result, RetType originalName_result, Option<RetType> type_result, Option<RetType> schema_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forNonterminalHeaderOnly(NonterminalHeader that, RetType info_result, RetType name_result, List<RetType> params_result, List<RetType> staticParams_result, Option<RetType> paramType_result, Option<RetType> whereClause_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forNonterminalParameterOnly(NonterminalParameter that, RetType info_result, RetType name_result, RetType paramType_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forSyntaxDeclOnly(SyntaxDecl that, RetType info_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forSyntaxDefOnly(SyntaxDef that, RetType info_result, List<RetType> syntaxSymbols_result, RetType transformer_result) {
        return forSyntaxDeclOnly(that, info_result);
    }

    public RetType forSuperSyntaxDefOnly(SuperSyntaxDef that, RetType info_result, RetType nonterminal_result, RetType grammarId_result) {
        return forSyntaxDeclOnly(that, info_result);
    }

    public RetType forTransformerDeclOnly(TransformerDecl that, RetType info_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forPreTransformerDefOnly(PreTransformerDef that, RetType info_result, RetType transformer_result) {
        return forTransformerDeclOnly(that, info_result);
    }

    public RetType forNamedTransformerDefOnly(NamedTransformerDef that, RetType info_result, List<RetType> parameters_result, RetType transformer_result) {
        return forTransformerDeclOnly(that, info_result);
    }

    public RetType forTransformerOnly(Transformer that, RetType info_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forUnparsedTransformerOnly(UnparsedTransformer that, RetType info_result, RetType nonterminal_result) {
        return forTransformerOnly(that, info_result);
    }

    public RetType forNodeTransformerOnly(NodeTransformer that, RetType info_result, RetType node_result) {
        return forTransformerOnly(that, info_result);
    }

    public RetType forCaseTransformerOnly(CaseTransformer that, RetType info_result, RetType gapName_result, List<RetType> clauses_result) {
        return forTransformerOnly(that, info_result);
    }

    public RetType forCaseTransformerClauseOnly(CaseTransformerClause that, RetType info_result, RetType constructor_result, List<RetType> parameters_result, RetType body_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forSyntaxSymbolOnly(SyntaxSymbol that, RetType info_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forPrefixedSymbolOnly(PrefixedSymbol that, RetType info_result, RetType id_result, RetType symbol_result) {
        return forSyntaxSymbolOnly(that, info_result);
    }

    public RetType forOptionalSymbolOnly(OptionalSymbol that, RetType info_result, RetType symbol_result) {
        return forSyntaxSymbolOnly(that, info_result);
    }

    public RetType forRepeatSymbolOnly(RepeatSymbol that, RetType info_result, RetType symbol_result) {
        return forSyntaxSymbolOnly(that, info_result);
    }

    public RetType forRepeatOneOrMoreSymbolOnly(RepeatOneOrMoreSymbol that, RetType info_result, RetType symbol_result) {
        return forSyntaxSymbolOnly(that, info_result);
    }

    public RetType forNoWhitespaceSymbolOnly(NoWhitespaceSymbol that, RetType info_result, RetType symbol_result) {
        return forSyntaxSymbolOnly(that, info_result);
    }

    public RetType forGroupSymbolOnly(GroupSymbol that, RetType info_result, List<RetType> symbols_result) {
        return forSyntaxSymbolOnly(that, info_result);
    }

    public RetType forSpecialSymbolOnly(SpecialSymbol that, RetType info_result) {
        return forSyntaxSymbolOnly(that, info_result);
    }

    public RetType forAnyCharacterSymbolOnly(AnyCharacterSymbol that, RetType info_result) {
        return forSpecialSymbolOnly(that, info_result);
    }

    public RetType forWhitespaceSymbolOnly(WhitespaceSymbol that, RetType info_result) {
        return forSpecialSymbolOnly(that, info_result);
    }

    public RetType forTabSymbolOnly(TabSymbol that, RetType info_result) {
        return forSpecialSymbolOnly(that, info_result);
    }

    public RetType forFormfeedSymbolOnly(FormfeedSymbol that, RetType info_result) {
        return forSpecialSymbolOnly(that, info_result);
    }

    public RetType forCarriageReturnSymbolOnly(CarriageReturnSymbol that, RetType info_result) {
        return forSpecialSymbolOnly(that, info_result);
    }

    public RetType forBackspaceSymbolOnly(BackspaceSymbol that, RetType info_result) {
        return forSpecialSymbolOnly(that, info_result);
    }

    public RetType forNewlineSymbolOnly(NewlineSymbol that, RetType info_result) {
        return forSpecialSymbolOnly(that, info_result);
    }

    public RetType forBreaklineSymbolOnly(BreaklineSymbol that, RetType info_result) {
        return forSpecialSymbolOnly(that, info_result);
    }

    public RetType forItemSymbolOnly(ItemSymbol that, RetType info_result) {
        return forSyntaxSymbolOnly(that, info_result);
    }

    public RetType forNonterminalSymbolOnly(NonterminalSymbol that, RetType info_result, RetType nonterminal_result) {
        return forSyntaxSymbolOnly(that, info_result);
    }

    public RetType forKeywordSymbolOnly(KeywordSymbol that, RetType info_result) {
        return forSyntaxSymbolOnly(that, info_result);
    }

    public RetType forTokenSymbolOnly(TokenSymbol that, RetType info_result) {
        return forSyntaxSymbolOnly(that, info_result);
    }

    public RetType forNotPredicateSymbolOnly(NotPredicateSymbol that, RetType info_result, RetType symbol_result) {
        return forSyntaxSymbolOnly(that, info_result);
    }

    public RetType forAndPredicateSymbolOnly(AndPredicateSymbol that, RetType info_result, RetType symbol_result) {
        return forSyntaxSymbolOnly(that, info_result);
    }

    public RetType forCharacterClassSymbolOnly(CharacterClassSymbol that, RetType info_result, List<RetType> characters_result) {
        return forSyntaxSymbolOnly(that, info_result);
    }

    public RetType forCharacterSymbolOnly(CharacterSymbol that, RetType info_result) {
        return forSyntaxSymbolOnly(that, info_result);
    }

    public RetType forCharSymbolOnly(CharSymbol that, RetType info_result) {
        return forCharacterSymbolOnly(that, info_result);
    }

    public RetType forCharacterIntervalOnly(CharacterInterval that, RetType info_result) {
        return forCharacterSymbolOnly(that, info_result);
    }

    public RetType forLinkOnly(Link that, RetType info_result, RetType op_result, RetType expr_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType forInfoOnly(Info that) {
        return forNodeOnly(that);
    }

    public RetType forInOutPhasesOnly(InOutPhases that) {
        return forInfoOnly(that);
    }

    public RetType forInAfterTypeCheckingOnly(InAfterTypeChecking that) {
        return forInOutPhasesOnly(that);
    }

    public RetType forOutAfterTypeCheckingOnly(OutAfterTypeChecking that) {
        return forInOutPhasesOnly(that);
    }

    public RetType forLhsOnly(Lhs that) {
        return forInfoOnly(that);
    }

    public RetType forTypeOrPatternOnly(TypeOrPattern that) {
        return forInfoOnly(that);
    }

    public RetType forApplicableOnly(Applicable that, RetType header_result) {
        return forInfoOnly(that);
    }

    public RetType forTypeVariableOnly(TypeVariable that) {
        return forInfoOnly(that);
    }

    public RetType forTemplateGapOnly(TemplateGap that, RetType gapId_result, List<RetType> templateParams_result) {
        return forInfoOnly(that);
    }

    public RetType for_SyntaxTransformationOnly(_SyntaxTransformation that) {
        return forInfoOnly(that);
    }

    public RetType for_EllipsesOnly(_Ellipses that, RetType repeatedNode_result) {
        return forInfoOnly(that);
    }

    public RetType forInfoNodeOnly(InfoNode that) {
        return forInfoOnly(that);
    }

    public RetType forDataNodeOnly(DataNode that) {
        return forInfoNodeOnly(that);
    }

    public RetType forGenericHeaderOnly(GenericHeader that, List<RetType> staticParams_result) {
        return forDataNodeOnly(that);
    }

    public RetType forDeclHeaderOnly(DeclHeader that, List<RetType> staticParams_result, RetType name_result, Option<RetType> whereClause_result, Option<List<RetType>> throwsClause_result, Option<RetType> contract_result) {
        return forGenericHeaderOnly(that, staticParams_result);
    }

    public RetType forTraitTypeHeaderOnly(TraitTypeHeader that, List<RetType> staticParams_result, RetType name_result, Option<RetType> whereClause_result, Option<List<RetType>> throwsClause_result, Option<RetType> contract_result, List<RetType> extendsClause_result, Option<List<RetType>> params_result, List<RetType> decls_result) {
        return forDeclHeaderOnly(that, staticParams_result, name_result, whereClause_result, throwsClause_result, contract_result);
    }

    public RetType forFnHeaderOnly(FnHeader that, List<RetType> staticParams_result, RetType name_result, Option<RetType> whereClause_result, Option<List<RetType>> throwsClause_result, Option<RetType> contract_result, List<RetType> params_result, Option<RetType> returnType_result) {
        return forDeclHeaderOnly(that, staticParams_result, name_result, whereClause_result, throwsClause_result, contract_result);
    }

    public RetType forASTNodeInfoOnly(ASTNodeInfo that) {
        return forDataNodeOnly(that);
    }

    public RetType forSpanInfoOnly(SpanInfo that) {
        return forASTNodeInfoOnly(that);
    }

    public RetType forParenthesizedInfoOnly(ParenthesizedInfo that) {
        return forASTNodeInfoOnly(that);
    }

    public RetType forExprInfoOnly(ExprInfo that, Option<RetType> exprType_result) {
        return forParenthesizedInfoOnly(that);
    }

    public RetType forTypeInfoOnly(TypeInfo that, List<RetType> staticParams_result, Option<RetType> whereClause_result) {
        return forParenthesizedInfoOnly(that);
    }

    public RetType forMethodInfoOnly(MethodInfo that, RetType selfType_result) {
        return forDataNodeOnly(that);
    }

    public RetType forCompoundAssignmentInfoOnly(CompoundAssignmentInfo that, RetType opForLhs_result, Option<RetType> compoundCoercionOuter_result, Option<RetType> compoundCoercionInner_result) {
        return forDataNodeOnly(that);
    }

    public RetType forLevelOnly(Level that) {
        return forInfoNodeOnly(that);
    }

    public RetType forFixityOnly(Fixity that) {
        return forInfoNodeOnly(that);
    }

    public RetType forInFixityOnly(InFixity that) {
        return forFixityOnly(that);
    }

    public RetType forPreFixityOnly(PreFixity that) {
        return forFixityOnly(that);
    }

    public RetType forPostFixityOnly(PostFixity that) {
        return forFixityOnly(that);
    }

    public RetType forNoFixityOnly(NoFixity that) {
        return forFixityOnly(that);
    }

    public RetType forMultiFixityOnly(MultiFixity that) {
        return forFixityOnly(that);
    }

    public RetType forEnclosingFixityOnly(EnclosingFixity that) {
        return forFixityOnly(that);
    }

    public RetType forBigFixityOnly(BigFixity that) {
        return forFixityOnly(that);
    }

    public RetType forUnknownFixityOnly(UnknownFixity that) {
        return forFixityOnly(that);
    }

    public RetType forStaticParamKindOnly(StaticParamKind that) {
        return forInfoNodeOnly(that);
    }

    public RetType forKindTypeOnly(KindType that) {
        return forStaticParamKindOnly(that);
    }

    public RetType forKindIntOnly(KindInt that) {
        return forStaticParamKindOnly(that);
    }

    public RetType forKindNatOnly(KindNat that) {
        return forStaticParamKindOnly(that);
    }

    public RetType forKindBoolOnly(KindBool that) {
        return forStaticParamKindOnly(that);
    }

    public RetType forKindDimOnly(KindDim that) {
        return forStaticParamKindOnly(that);
    }

    public RetType forKindUnitOnly(KindUnit that) {
        return forStaticParamKindOnly(that);
    }

    public RetType forKindOpOnly(KindOp that) {
        return forStaticParamKindOnly(that);
    }

    public RetType for_SyntaxTransformationAbstractNodeOnly(_SyntaxTransformationAbstractNode that, RetType info_result) {
        return forAbstractNodeOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationCompilationUnitOnly(_SyntaxTransformationCompilationUnit that, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result, RetType info_result) {
        return forCompilationUnitOnly(that, info_result, name_result, imports_result, decls_result, comprises_result);
    }

    public RetType for_SyntaxTransformationComponentOnly(_SyntaxTransformationComponent that, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result, List<RetType> exports_result, RetType info_result) {
        return forComponentOnly(that, info_result, name_result, imports_result, decls_result, comprises_result, exports_result);
    }

    public RetType for_SyntaxTransformationApiOnly(_SyntaxTransformationApi that, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result, RetType info_result) {
        return forApiOnly(that, info_result, name_result, imports_result, decls_result, comprises_result);
    }

    public RetType for_SyntaxTransformationImportOnly(_SyntaxTransformationImport that, RetType info_result) {
        return forImportOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationImportedNamesOnly(_SyntaxTransformationImportedNames that, RetType apiName_result, RetType info_result) {
        return forImportedNamesOnly(that, info_result, apiName_result);
    }

    public RetType for_SyntaxTransformationImportStarOnly(_SyntaxTransformationImportStar that, RetType apiName_result, List<RetType> exceptNames_result, RetType info_result) {
        return forImportStarOnly(that, info_result, apiName_result, exceptNames_result);
    }

    public RetType for_SyntaxTransformationImportNamesOnly(_SyntaxTransformationImportNames that, RetType apiName_result, List<RetType> aliasedNames_result, RetType info_result) {
        return forImportNamesOnly(that, info_result, apiName_result, aliasedNames_result);
    }

    public RetType for_SyntaxTransformationImportApiOnly(_SyntaxTransformationImportApi that, List<RetType> apis_result, RetType info_result) {
        return forImportApiOnly(that, info_result, apis_result);
    }

    public RetType for_SyntaxTransformationAliasedSimpleNameOnly(_SyntaxTransformationAliasedSimpleName that, RetType name_result, Option<RetType> alias_result, RetType info_result) {
        return forAliasedSimpleNameOnly(that, info_result, name_result, alias_result);
    }

    public RetType for_SyntaxTransformationAliasedAPINameOnly(_SyntaxTransformationAliasedAPIName that, RetType apiName_result, Option<RetType> alias_result, RetType info_result) {
        return forAliasedAPINameOnly(that, info_result, apiName_result, alias_result);
    }

    public RetType for_SyntaxTransformationDeclOnly(_SyntaxTransformationDecl that, RetType info_result) {
        return forDeclOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationTraitObjectDeclOnly(_SyntaxTransformationTraitObjectDecl that, RetType header_result, Option<RetType> selfType_result, RetType info_result) {
        return forTraitObjectDeclOnly(that, info_result, header_result, selfType_result);
    }

    public RetType for_SyntaxTransformationTraitDeclOnly(_SyntaxTransformationTraitDecl that, RetType header_result, Option<RetType> selfType_result, List<RetType> excludesClause_result, Option<List<RetType>> comprisesClause_result, RetType info_result) {
        return forTraitDeclOnly(that, info_result, header_result, selfType_result, excludesClause_result, comprisesClause_result);
    }

    public RetType for_SyntaxTransformationObjectDeclOnly(_SyntaxTransformationObjectDecl that, RetType header_result, Option<RetType> selfType_result, RetType info_result) {
        return forObjectDeclOnly(that, info_result, header_result, selfType_result);
    }

    public RetType for_SyntaxTransformationVarDeclOnly(_SyntaxTransformationVarDecl that, List<RetType> lhs_result, Option<RetType> init_result, RetType info_result) {
        return forVarDeclOnly(that, info_result, lhs_result, init_result);
    }

    public RetType for_SyntaxTransformationFnDeclOnly(_SyntaxTransformationFnDecl that, RetType header_result, RetType unambiguousName_result, Option<RetType> body_result, Option<RetType> implementsUnambiguousName_result, RetType info_result) {
        return forFnDeclOnly(that, info_result, header_result, unambiguousName_result, body_result, implementsUnambiguousName_result);
    }

    public RetType for_SyntaxTransformation_RewriteFnOverloadDeclOnly(_SyntaxTransformation_RewriteFnOverloadDecl that, RetType name_result, List<RetType> fns_result, Option<RetType> type_result, RetType info_result) {
        return for_RewriteFnOverloadDeclOnly(that, info_result, name_result, fns_result, type_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprDeclOnly(_SyntaxTransformation_RewriteObjectExprDecl that, List<RetType> objectExprs_result, RetType info_result) {
        return for_RewriteObjectExprDeclOnly(that, info_result, objectExprs_result);
    }

    public RetType for_SyntaxTransformation_RewriteFunctionalMethodDeclOnly(_SyntaxTransformation_RewriteFunctionalMethodDecl that, RetType info_result) {
        return for_RewriteFunctionalMethodDeclOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationDimUnitDeclOnly(_SyntaxTransformationDimUnitDecl that, RetType info_result) {
        return forDimUnitDeclOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationDimDeclOnly(_SyntaxTransformationDimDecl that, RetType dimId_result, Option<RetType> derived_result, Option<RetType> defaultId_result, RetType info_result) {
        return forDimDeclOnly(that, info_result, dimId_result, derived_result, defaultId_result);
    }

    public RetType for_SyntaxTransformationUnitDeclOnly(_SyntaxTransformationUnitDecl that, List<RetType> units_result, Option<RetType> dimType_result, Option<RetType> defExpr_result, RetType info_result) {
        return forUnitDeclOnly(that, info_result, units_result, dimType_result, defExpr_result);
    }

    public RetType for_SyntaxTransformationTestDeclOnly(_SyntaxTransformationTestDecl that, RetType name_result, List<RetType> gens_result, RetType expr_result, RetType info_result) {
        return forTestDeclOnly(that, info_result, name_result, gens_result, expr_result);
    }

    public RetType for_SyntaxTransformationPropertyDeclOnly(_SyntaxTransformationPropertyDecl that, Option<RetType> name_result, List<RetType> params_result, RetType expr_result, RetType info_result) {
        return forPropertyDeclOnly(that, info_result, name_result, params_result, expr_result);
    }

    public RetType for_SyntaxTransformationTypeAliasOnly(_SyntaxTransformationTypeAlias that, RetType name_result, List<RetType> staticParams_result, RetType typeDef_result, RetType info_result) {
        return forTypeAliasOnly(that, info_result, name_result, staticParams_result, typeDef_result);
    }

    public RetType for_SyntaxTransformationGrammarDeclOnly(_SyntaxTransformationGrammarDecl that, RetType name_result, List<RetType> extendsClause_result, List<RetType> members_result, List<RetType> transformers_result, RetType info_result) {
        return forGrammarDeclOnly(that, info_result, name_result, extendsClause_result, members_result, transformers_result);
    }

    public RetType for_SyntaxTransformationGrammarMemberDeclOnly(_SyntaxTransformationGrammarMemberDecl that, RetType name_result, RetType info_result) {
        return forGrammarMemberDeclOnly(that, info_result, name_result);
    }

    public RetType for_SyntaxTransformationNonterminalDeclOnly(_SyntaxTransformationNonterminalDecl that, RetType name_result, List<RetType> syntaxDecls_result, RetType info_result) {
        return forNonterminalDeclOnly(that, info_result, name_result, syntaxDecls_result);
    }

    public RetType for_SyntaxTransformationNonterminalDefOnly(_SyntaxTransformationNonterminalDef that, RetType name_result, List<RetType> syntaxDecls_result, RetType header_result, Option<RetType> astType_result, RetType info_result) {
        return forNonterminalDefOnly(that, info_result, name_result, syntaxDecls_result, header_result, astType_result);
    }

    public RetType for_SyntaxTransformationNonterminalExtensionDefOnly(_SyntaxTransformationNonterminalExtensionDef that, RetType name_result, List<RetType> syntaxDecls_result, RetType info_result) {
        return forNonterminalExtensionDefOnly(that, info_result, name_result, syntaxDecls_result);
    }

    public RetType for_SyntaxTransformationBindingOnly(_SyntaxTransformationBinding that, RetType name_result, Option<RetType> idType_result, RetType info_result) {
        return forBindingOnly(that, info_result, name_result, idType_result);
    }

    public RetType for_SyntaxTransformationLValueOnly(_SyntaxTransformationLValue that, RetType name_result, Option<RetType> idType_result, RetType info_result) {
        return forLValueOnly(that, info_result, name_result, idType_result);
    }

    public RetType for_SyntaxTransformationParamOnly(_SyntaxTransformationParam that, RetType name_result, Option<RetType> idType_result, Option<RetType> defaultExpr_result, Option<RetType> varargsType_result, RetType info_result) {
        return forParamOnly(that, info_result, name_result, idType_result, defaultExpr_result, varargsType_result);
    }

    public RetType for_SyntaxTransformationExprOnly(_SyntaxTransformationExpr that, RetType info_result) {
        return forExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationDummyExprOnly(_SyntaxTransformationDummyExpr that, RetType info_result) {
        return forDummyExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationTypeAnnotatedExprOnly(_SyntaxTransformationTypeAnnotatedExpr that, RetType expr_result, RetType annType_result, RetType info_result) {
        return forTypeAnnotatedExprOnly(that, info_result, expr_result, annType_result);
    }

    public RetType for_SyntaxTransformationAsExprOnly(_SyntaxTransformationAsExpr that, RetType expr_result, RetType annType_result, RetType info_result) {
        return forAsExprOnly(that, info_result, expr_result, annType_result);
    }

    public RetType for_SyntaxTransformationAsIfExprOnly(_SyntaxTransformationAsIfExpr that, RetType expr_result, RetType annType_result, RetType info_result) {
        return forAsIfExprOnly(that, info_result, expr_result, annType_result);
    }

    public RetType for_SyntaxTransformationAssignmentOnly(_SyntaxTransformationAssignment that, List<RetType> lhs_result, Option<RetType> assignOp_result, RetType rhs_result, List<RetType> assignmentInfos_result, RetType info_result) {
        return forAssignmentOnly(that, info_result, lhs_result, assignOp_result, rhs_result, assignmentInfos_result);
    }

    public RetType for_SyntaxTransformationBlockOnly(_SyntaxTransformationBlock that, Option<RetType> loc_result, List<RetType> exprs_result, RetType info_result) {
        return forBlockOnly(that, info_result, loc_result, exprs_result);
    }

    public RetType for_SyntaxTransformationDoOnly(_SyntaxTransformationDo that, List<RetType> fronts_result, RetType info_result) {
        return forDoOnly(that, info_result, fronts_result);
    }

    public RetType for_SyntaxTransformationCaseExprOnly(_SyntaxTransformationCaseExpr that, Option<RetType> param_result, Option<RetType> compare_result, RetType equalsOp_result, RetType inOp_result, List<RetType> clauses_result, Option<RetType> elseClause_result, RetType info_result) {
        return forCaseExprOnly(that, info_result, param_result, compare_result, equalsOp_result, inOp_result, clauses_result, elseClause_result);
    }

    public RetType for_SyntaxTransformationIfOnly(_SyntaxTransformationIf that, List<RetType> clauses_result, Option<RetType> elseClause_result, RetType info_result) {
        return forIfOnly(that, info_result, clauses_result, elseClause_result);
    }

    public RetType for_SyntaxTransformationLabelOnly(_SyntaxTransformationLabel that, RetType name_result, RetType body_result, RetType info_result) {
        return forLabelOnly(that, info_result, name_result, body_result);
    }

    public RetType for_SyntaxTransformationAbstractObjectExprOnly(_SyntaxTransformationAbstractObjectExpr that, RetType header_result, RetType info_result) {
        return forAbstractObjectExprOnly(that, info_result, header_result);
    }

    public RetType for_SyntaxTransformationObjectExprOnly(_SyntaxTransformationObjectExpr that, RetType header_result, Option<RetType> selfType_result, RetType info_result) {
        return forObjectExprOnly(that, info_result, header_result, selfType_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprOnly(_SyntaxTransformation_RewriteObjectExpr that, RetType header_result, List<RetType> staticArgs_result, RetType info_result) {
        return for_RewriteObjectExprOnly(that, info_result, header_result, staticArgs_result);
    }

    public RetType for_SyntaxTransformationTryOnly(_SyntaxTransformationTry that, RetType body_result, Option<RetType> catchClause_result, List<RetType> forbidClause_result, Option<RetType> finallyClause_result, RetType info_result) {
        return forTryOnly(that, info_result, body_result, catchClause_result, forbidClause_result, finallyClause_result);
    }

    public RetType for_SyntaxTransformationTupleExprOnly(_SyntaxTransformationTupleExpr that, List<RetType> exprs_result, Option<RetType> varargs_result, List<RetType> keywords_result, RetType info_result) {
        return forTupleExprOnly(that, info_result, exprs_result, varargs_result, keywords_result);
    }

    public RetType for_SyntaxTransformationTypecaseOnly(_SyntaxTransformationTypecase that, RetType bindExpr_result, List<RetType> clauses_result, Option<RetType> elseClause_result, RetType info_result) {
        return forTypecaseOnly(that, info_result, bindExpr_result, clauses_result, elseClause_result);
    }

    public RetType for_SyntaxTransformationWhileOnly(_SyntaxTransformationWhile that, RetType testExpr_result, RetType body_result, RetType info_result) {
        return forWhileOnly(that, info_result, testExpr_result, body_result);
    }

    public RetType for_SyntaxTransformationForOnly(_SyntaxTransformationFor that, List<RetType> gens_result, RetType body_result, RetType info_result) {
        return forForOnly(that, info_result, gens_result, body_result);
    }

    public RetType for_SyntaxTransformationBigOpAppOnly(_SyntaxTransformationBigOpApp that, List<RetType> staticArgs_result, RetType info_result) {
        return forBigOpAppOnly(that, info_result, staticArgs_result);
    }

    public RetType for_SyntaxTransformationAccumulatorOnly(_SyntaxTransformationAccumulator that, List<RetType> staticArgs_result, RetType accOp_result, List<RetType> gens_result, RetType body_result, RetType info_result) {
        return forAccumulatorOnly(that, info_result, staticArgs_result, accOp_result, gens_result, body_result);
    }

    public RetType for_SyntaxTransformationArrayComprehensionOnly(_SyntaxTransformationArrayComprehension that, List<RetType> staticArgs_result, List<RetType> clauses_result, RetType info_result) {
        return forArrayComprehensionOnly(that, info_result, staticArgs_result, clauses_result);
    }

    public RetType for_SyntaxTransformationAtomicExprOnly(_SyntaxTransformationAtomicExpr that, RetType expr_result, RetType info_result) {
        return forAtomicExprOnly(that, info_result, expr_result);
    }

    public RetType for_SyntaxTransformationExitOnly(_SyntaxTransformationExit that, Option<RetType> target_result, Option<RetType> returnExpr_result, RetType info_result) {
        return forExitOnly(that, info_result, target_result, returnExpr_result);
    }

    public RetType for_SyntaxTransformationSpawnOnly(_SyntaxTransformationSpawn that, RetType body_result, RetType info_result) {
        return forSpawnOnly(that, info_result, body_result);
    }

    public RetType for_SyntaxTransformationThrowOnly(_SyntaxTransformationThrow that, RetType expr_result, RetType info_result) {
        return forThrowOnly(that, info_result, expr_result);
    }

    public RetType for_SyntaxTransformationTryAtomicExprOnly(_SyntaxTransformationTryAtomicExpr that, RetType expr_result, RetType info_result) {
        return forTryAtomicExprOnly(that, info_result, expr_result);
    }

    public RetType for_SyntaxTransformationFnExprOnly(_SyntaxTransformationFnExpr that, RetType header_result, RetType body_result, RetType info_result) {
        return forFnExprOnly(that, info_result, header_result, body_result);
    }

    public RetType for_SyntaxTransformationLetExprOnly(_SyntaxTransformationLetExpr that, RetType body_result, RetType info_result) {
        return forLetExprOnly(that, info_result, body_result);
    }

    public RetType for_SyntaxTransformationLetFnOnly(_SyntaxTransformationLetFn that, RetType body_result, List<RetType> fns_result, RetType info_result) {
        return forLetFnOnly(that, info_result, body_result, fns_result);
    }

    public RetType for_SyntaxTransformationLocalVarDeclOnly(_SyntaxTransformationLocalVarDecl that, RetType body_result, List<RetType> lhs_result, Option<RetType> rhs_result, RetType info_result) {
        return forLocalVarDeclOnly(that, info_result, body_result, lhs_result, rhs_result);
    }

    public RetType for_SyntaxTransformationSimpleExprOnly(_SyntaxTransformationSimpleExpr that, RetType info_result) {
        return forSimpleExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationSubscriptExprOnly(_SyntaxTransformationSubscriptExpr that, RetType obj_result, List<RetType> subs_result, Option<RetType> op_result, List<RetType> staticArgs_result, RetType info_result) {
        return forSubscriptExprOnly(that, info_result, obj_result, subs_result, op_result, staticArgs_result);
    }

    public RetType for_SyntaxTransformationPrimaryOnly(_SyntaxTransformationPrimary that, RetType info_result) {
        return forPrimaryOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationLiteralExprOnly(_SyntaxTransformationLiteralExpr that, RetType info_result) {
        return forLiteralExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationNumberLiteralExprOnly(_SyntaxTransformationNumberLiteralExpr that, RetType info_result) {
        return forNumberLiteralExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationFloatLiteralExprOnly(_SyntaxTransformationFloatLiteralExpr that, RetType info_result) {
        return forFloatLiteralExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationIntLiteralExprOnly(_SyntaxTransformationIntLiteralExpr that, RetType info_result) {
        return forIntLiteralExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationCharLiteralExprOnly(_SyntaxTransformationCharLiteralExpr that, RetType info_result) {
        return forCharLiteralExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationStringLiteralExprOnly(_SyntaxTransformationStringLiteralExpr that, RetType info_result) {
        return forStringLiteralExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationVoidLiteralExprOnly(_SyntaxTransformationVoidLiteralExpr that, RetType info_result) {
        return forVoidLiteralExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationBooleanLiteralExprOnly(_SyntaxTransformationBooleanLiteralExpr that, RetType info_result) {
        return forBooleanLiteralExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationVarRefOnly(_SyntaxTransformationVarRef that, RetType varId_result, List<RetType> staticArgs_result, RetType info_result) {
        return forVarRefOnly(that, info_result, varId_result, staticArgs_result);
    }

    public RetType for_SyntaxTransformationFieldRefOnly(_SyntaxTransformationFieldRef that, RetType obj_result, RetType field_result, RetType info_result) {
        return forFieldRefOnly(that, info_result, obj_result, field_result);
    }

    public RetType for_SyntaxTransformationFunctionalRefOnly(_SyntaxTransformationFunctionalRef that, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result, RetType info_result) {
        return forFunctionalRefOnly(that, info_result, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType for_SyntaxTransformationFnRefOnly(_SyntaxTransformationFnRef that, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result, RetType info_result) {
        return forFnRefOnly(that, info_result, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType for_SyntaxTransformationOpRefOnly(_SyntaxTransformationOpRef that, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result, RetType info_result) {
        return forOpRefOnly(that, info_result, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType for_SyntaxTransformation_RewriteFnRefOnly(_SyntaxTransformation_RewriteFnRef that, RetType fnExpr_result, List<RetType> staticArgs_result, RetType info_result) {
        return for_RewriteFnRefOnly(that, info_result, fnExpr_result, staticArgs_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprRefOnly(_SyntaxTransformation_RewriteObjectExprRef that, List<RetType> staticArgs_result, RetType info_result) {
        return for_RewriteObjectExprRefOnly(that, info_result, staticArgs_result);
    }

    public RetType for_SyntaxTransformationJuxtOnly(_SyntaxTransformationJuxt that, RetType multiJuxt_result, RetType infixJuxt_result, List<RetType> exprs_result, RetType info_result) {
        return forJuxtOnly(that, info_result, multiJuxt_result, infixJuxt_result, exprs_result);
    }

    public RetType for_SyntaxTransformation_RewriteFnAppOnly(_SyntaxTransformation_RewriteFnApp that, RetType function_result, RetType argument_result, RetType info_result) {
        return for_RewriteFnAppOnly(that, info_result, function_result, argument_result);
    }

    public RetType for_SyntaxTransformationOpExprOnly(_SyntaxTransformationOpExpr that, RetType op_result, List<RetType> args_result, RetType info_result) {
        return forOpExprOnly(that, info_result, op_result, args_result);
    }

    public RetType for_SyntaxTransformationAmbiguousMultifixOpExprOnly(_SyntaxTransformationAmbiguousMultifixOpExpr that, RetType infix_op_result, RetType multifix_op_result, List<RetType> args_result, RetType info_result) {
        return forAmbiguousMultifixOpExprOnly(that, info_result, infix_op_result, multifix_op_result, args_result);
    }

    public RetType for_SyntaxTransformationChainExprOnly(_SyntaxTransformationChainExpr that, RetType first_result, List<RetType> links_result, RetType info_result) {
        return forChainExprOnly(that, info_result, first_result, links_result);
    }

    public RetType for_SyntaxTransformationCoercionInvocationOnly(_SyntaxTransformationCoercionInvocation that, RetType toType_result, RetType arg_result, RetType info_result) {
        return forCoercionInvocationOnly(that, info_result, toType_result, arg_result);
    }

    public RetType for_SyntaxTransformationTraitCoercionInvocationOnly(_SyntaxTransformationTraitCoercionInvocation that, RetType arg_result, RetType toType_result, RetType coercionFn_result, RetType info_result) {
        return forTraitCoercionInvocationOnly(that, info_result, arg_result, toType_result, coercionFn_result);
    }

    public RetType for_SyntaxTransformationTupleCoercionInvocationOnly(_SyntaxTransformationTupleCoercionInvocation that, RetType arg_result, RetType toType_result, List<Option<RetType>> subCoercions_result, Option<Option<RetType>> varargCoercion_result, RetType info_result) {
        return forTupleCoercionInvocationOnly(that, info_result, arg_result, toType_result, subCoercions_result, varargCoercion_result);
    }

    public RetType for_SyntaxTransformationArrowCoercionInvocationOnly(_SyntaxTransformationArrowCoercionInvocation that, RetType arg_result, RetType toType_result, Option<RetType> domainCoercion_result, Option<RetType> rangeCoercion_result, RetType info_result) {
        return forArrowCoercionInvocationOnly(that, info_result, arg_result, toType_result, domainCoercion_result, rangeCoercion_result);
    }

    public RetType for_SyntaxTransformationUnionCoercionInvocationOnly(_SyntaxTransformationUnionCoercionInvocation that, RetType toType_result, RetType arg_result, List<RetType> fromTypes_result, List<Option<RetType>> fromCoercions_result, RetType info_result) {
        return forUnionCoercionInvocationOnly(that, info_result, toType_result, arg_result, fromTypes_result, fromCoercions_result);
    }

    public RetType for_SyntaxTransformationMethodInvocationOnly(_SyntaxTransformationMethodInvocation that, RetType obj_result, RetType method_result, List<RetType> staticArgs_result, RetType arg_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result, RetType info_result) {
        return forMethodInvocationOnly(that, info_result, obj_result, method_result, staticArgs_result, arg_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType for_SyntaxTransformationMathPrimaryOnly(_SyntaxTransformationMathPrimary that, RetType multiJuxt_result, RetType infixJuxt_result, RetType front_result, List<RetType> rest_result, RetType info_result) {
        return forMathPrimaryOnly(that, info_result, multiJuxt_result, infixJuxt_result, front_result, rest_result);
    }

    public RetType for_SyntaxTransformationArrayExprOnly(_SyntaxTransformationArrayExpr that, List<RetType> staticArgs_result, RetType info_result) {
        return forArrayExprOnly(that, info_result, staticArgs_result);
    }

    public RetType for_SyntaxTransformationArrayElementOnly(_SyntaxTransformationArrayElement that, List<RetType> staticArgs_result, RetType element_result, RetType info_result) {
        return forArrayElementOnly(that, info_result, staticArgs_result, element_result);
    }

    public RetType for_SyntaxTransformationArrayElementsOnly(_SyntaxTransformationArrayElements that, List<RetType> staticArgs_result, List<RetType> elements_result, RetType info_result) {
        return forArrayElementsOnly(that, info_result, staticArgs_result, elements_result);
    }

    public RetType for_SyntaxTransformationTypeOnly(_SyntaxTransformationType that, RetType info_result) {
        return forTypeOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationBaseTypeOnly(_SyntaxTransformationBaseType that, RetType info_result) {
        return forBaseTypeOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationAnyTypeOnly(_SyntaxTransformationAnyType that, RetType info_result) {
        return forAnyTypeOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationBottomTypeOnly(_SyntaxTransformationBottomType that, RetType info_result) {
        return forBottomTypeOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationUnknownTypeOnly(_SyntaxTransformationUnknownType that, RetType info_result) {
        return forUnknownTypeOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationSelfTypeOnly(_SyntaxTransformationSelfType that, RetType info_result) {
        return forSelfTypeOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationTraitSelfTypeOnly(_SyntaxTransformationTraitSelfType that, RetType named_result, List<RetType> comprised_result, RetType info_result) {
        return forTraitSelfTypeOnly(that, info_result, named_result, comprised_result);
    }

    public RetType for_SyntaxTransformationObjectExprTypeOnly(_SyntaxTransformationObjectExprType that, List<RetType> extended_result, RetType info_result) {
        return forObjectExprTypeOnly(that, info_result, extended_result);
    }

    public RetType for_SyntaxTransformationNamedTypeOnly(_SyntaxTransformationNamedType that, RetType name_result, RetType info_result) {
        return forNamedTypeOnly(that, info_result, name_result);
    }

    public RetType for_SyntaxTransformation_InferenceVarTypeOnly(_SyntaxTransformation_InferenceVarType that, RetType name_result, RetType info_result) {
        return for_InferenceVarTypeOnly(that, info_result, name_result);
    }

    public RetType for_SyntaxTransformationVarTypeOnly(_SyntaxTransformationVarType that, RetType name_result, RetType info_result) {
        return forVarTypeOnly(that, info_result, name_result);
    }

    public RetType for_SyntaxTransformationTraitTypeOnly(_SyntaxTransformationTraitType that, RetType name_result, List<RetType> args_result, List<RetType> traitStaticParams_result, RetType info_result) {
        return forTraitTypeOnly(that, info_result, name_result, args_result, traitStaticParams_result);
    }

    public RetType for_SyntaxTransformationAbbreviatedTypeOnly(_SyntaxTransformationAbbreviatedType that, RetType elemType_result, RetType info_result) {
        return forAbbreviatedTypeOnly(that, info_result, elemType_result);
    }

    public RetType for_SyntaxTransformationArrayTypeOnly(_SyntaxTransformationArrayType that, RetType elemType_result, RetType indices_result, RetType info_result) {
        return forArrayTypeOnly(that, info_result, elemType_result, indices_result);
    }

    public RetType for_SyntaxTransformationMatrixTypeOnly(_SyntaxTransformationMatrixType that, RetType elemType_result, List<RetType> dimensions_result, RetType info_result) {
        return forMatrixTypeOnly(that, info_result, elemType_result, dimensions_result);
    }

    public RetType for_SyntaxTransformationTaggedDimTypeOnly(_SyntaxTransformationTaggedDimType that, RetType elemType_result, RetType dimExpr_result, Option<RetType> unitExpr_result, RetType info_result) {
        return forTaggedDimTypeOnly(that, info_result, elemType_result, dimExpr_result, unitExpr_result);
    }

    public RetType for_SyntaxTransformationTaggedUnitTypeOnly(_SyntaxTransformationTaggedUnitType that, RetType elemType_result, RetType unitExpr_result, RetType info_result) {
        return forTaggedUnitTypeOnly(that, info_result, elemType_result, unitExpr_result);
    }

    public RetType for_SyntaxTransformationTupleTypeOnly(_SyntaxTransformationTupleType that, List<RetType> elements_result, Option<RetType> varargs_result, List<RetType> keywords_result, RetType info_result) {
        return forTupleTypeOnly(that, info_result, elements_result, varargs_result, keywords_result);
    }

    public RetType for_SyntaxTransformationArrowTypeOnly(_SyntaxTransformationArrowType that, RetType domain_result, RetType range_result, RetType effect_result, Option<RetType> methodInfo_result, RetType info_result) {
        return forArrowTypeOnly(that, info_result, domain_result, range_result, effect_result, methodInfo_result);
    }

    public RetType for_SyntaxTransformationBoundTypeOnly(_SyntaxTransformationBoundType that, List<RetType> elements_result, RetType info_result) {
        return forBoundTypeOnly(that, info_result, elements_result);
    }

    public RetType for_SyntaxTransformationIntersectionTypeOnly(_SyntaxTransformationIntersectionType that, List<RetType> elements_result, RetType info_result) {
        return forIntersectionTypeOnly(that, info_result, elements_result);
    }

    public RetType for_SyntaxTransformationUnionTypeOnly(_SyntaxTransformationUnionType that, List<RetType> elements_result, RetType info_result) {
        return forUnionTypeOnly(that, info_result, elements_result);
    }

    public RetType for_SyntaxTransformationFixedPointTypeOnly(_SyntaxTransformationFixedPointType that, RetType name_result, RetType body_result, RetType info_result) {
        return forFixedPointTypeOnly(that, info_result, name_result, body_result);
    }

    public RetType for_SyntaxTransformationLabelTypeOnly(_SyntaxTransformationLabelType that, RetType info_result) {
        return forLabelTypeOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationDimExprOnly(_SyntaxTransformationDimExpr that, RetType info_result) {
        return forDimExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationDimBaseOnly(_SyntaxTransformationDimBase that, RetType info_result) {
        return forDimBaseOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationDimRefOnly(_SyntaxTransformationDimRef that, RetType name_result, RetType info_result) {
        return forDimRefOnly(that, info_result, name_result);
    }

    public RetType for_SyntaxTransformationDimExponentOnly(_SyntaxTransformationDimExponent that, RetType base_result, RetType power_result, RetType info_result) {
        return forDimExponentOnly(that, info_result, base_result, power_result);
    }

    public RetType for_SyntaxTransformationDimUnaryOpOnly(_SyntaxTransformationDimUnaryOp that, RetType dimVal_result, RetType op_result, RetType info_result) {
        return forDimUnaryOpOnly(that, info_result, dimVal_result, op_result);
    }

    public RetType for_SyntaxTransformationDimBinaryOpOnly(_SyntaxTransformationDimBinaryOp that, RetType left_result, RetType right_result, RetType op_result, RetType info_result) {
        return forDimBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }

    public RetType for_SyntaxTransformationPatternOnly(_SyntaxTransformationPattern that, Option<RetType> name_result, RetType patterns_result, RetType info_result) {
        return forPatternOnly(that, info_result, name_result, patterns_result);
    }

    public RetType for_SyntaxTransformationPatternArgsOnly(_SyntaxTransformationPatternArgs that, List<RetType> patterns_result, RetType info_result) {
        return forPatternArgsOnly(that, info_result, patterns_result);
    }

    public RetType for_SyntaxTransformationPatternBindingOnly(_SyntaxTransformationPatternBinding that, Option<RetType> field_result, RetType info_result) {
        return forPatternBindingOnly(that, info_result, field_result);
    }

    public RetType for_SyntaxTransformationPlainPatternOnly(_SyntaxTransformationPlainPattern that, Option<RetType> field_result, RetType name_result, Option<RetType> idType_result, RetType info_result) {
        return forPlainPatternOnly(that, info_result, field_result, name_result, idType_result);
    }

    public RetType for_SyntaxTransformationTypePatternOnly(_SyntaxTransformationTypePattern that, Option<RetType> field_result, RetType typ_result, RetType info_result) {
        return forTypePatternOnly(that, info_result, field_result, typ_result);
    }

    public RetType for_SyntaxTransformationNestedPatternOnly(_SyntaxTransformationNestedPattern that, Option<RetType> field_result, RetType pat_result, RetType info_result) {
        return forNestedPatternOnly(that, info_result, field_result, pat_result);
    }

    public RetType for_SyntaxTransformationStaticArgOnly(_SyntaxTransformationStaticArg that, RetType info_result) {
        return forStaticArgOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationTypeArgOnly(_SyntaxTransformationTypeArg that, RetType typeArg_result, RetType info_result) {
        return forTypeArgOnly(that, info_result, typeArg_result);
    }

    public RetType for_SyntaxTransformationIntArgOnly(_SyntaxTransformationIntArg that, RetType intVal_result, RetType info_result) {
        return forIntArgOnly(that, info_result, intVal_result);
    }

    public RetType for_SyntaxTransformationBoolArgOnly(_SyntaxTransformationBoolArg that, RetType boolArg_result, RetType info_result) {
        return forBoolArgOnly(that, info_result, boolArg_result);
    }

    public RetType for_SyntaxTransformationOpArgOnly(_SyntaxTransformationOpArg that, RetType id_result, RetType info_result) {
        return forOpArgOnly(that, info_result, id_result);
    }

    public RetType for_SyntaxTransformationDimArgOnly(_SyntaxTransformationDimArg that, RetType dimArg_result, RetType info_result) {
        return forDimArgOnly(that, info_result, dimArg_result);
    }

    public RetType for_SyntaxTransformationUnitArgOnly(_SyntaxTransformationUnitArg that, RetType unitArg_result, RetType info_result) {
        return forUnitArgOnly(that, info_result, unitArg_result);
    }

    public RetType for_SyntaxTransformationStaticExprOnly(_SyntaxTransformationStaticExpr that, RetType info_result) {
        return forStaticExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationIntExprOnly(_SyntaxTransformationIntExpr that, RetType info_result) {
        return forIntExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationIntBaseOnly(_SyntaxTransformationIntBase that, RetType intVal_result, RetType info_result) {
        return forIntBaseOnly(that, info_result, intVal_result);
    }

    public RetType for_SyntaxTransformationIntRefOnly(_SyntaxTransformationIntRef that, RetType name_result, RetType info_result) {
        return forIntRefOnly(that, info_result, name_result);
    }

    public RetType for_SyntaxTransformationIntBinaryOpOnly(_SyntaxTransformationIntBinaryOp that, RetType left_result, RetType right_result, RetType op_result, RetType info_result) {
        return forIntBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }

    public RetType for_SyntaxTransformationBoolExprOnly(_SyntaxTransformationBoolExpr that, RetType info_result) {
        return forBoolExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationBoolBaseOnly(_SyntaxTransformationBoolBase that, RetType info_result) {
        return forBoolBaseOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationBoolRefOnly(_SyntaxTransformationBoolRef that, RetType name_result, RetType info_result) {
        return forBoolRefOnly(that, info_result, name_result);
    }

    public RetType for_SyntaxTransformationBoolConstraintOnly(_SyntaxTransformationBoolConstraint that, RetType info_result) {
        return forBoolConstraintOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationBoolUnaryOpOnly(_SyntaxTransformationBoolUnaryOp that, RetType boolVal_result, RetType op_result, RetType info_result) {
        return forBoolUnaryOpOnly(that, info_result, boolVal_result, op_result);
    }

    public RetType for_SyntaxTransformationBoolBinaryOpOnly(_SyntaxTransformationBoolBinaryOp that, RetType left_result, RetType right_result, RetType op_result, RetType info_result) {
        return forBoolBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }

    public RetType for_SyntaxTransformationUnitExprOnly(_SyntaxTransformationUnitExpr that, RetType info_result) {
        return forUnitExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationUnitRefOnly(_SyntaxTransformationUnitRef that, RetType name_result, RetType info_result) {
        return forUnitRefOnly(that, info_result, name_result);
    }

    public RetType for_SyntaxTransformationUnitBinaryOpOnly(_SyntaxTransformationUnitBinaryOp that, RetType left_result, RetType right_result, RetType op_result, RetType info_result) {
        return forUnitBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }

    public RetType for_SyntaxTransformationEffectOnly(_SyntaxTransformationEffect that, Option<List<RetType>> throwsClause_result, RetType info_result) {
        return forEffectOnly(that, info_result, throwsClause_result);
    }

    public RetType for_SyntaxTransformationWhereClauseOnly(_SyntaxTransformationWhereClause that, List<RetType> bindings_result, List<RetType> constraints_result, RetType info_result) {
        return forWhereClauseOnly(that, info_result, bindings_result, constraints_result);
    }

    public RetType for_SyntaxTransformationWhereBindingOnly(_SyntaxTransformationWhereBinding that, RetType name_result, List<RetType> supers_result, RetType kind_result, RetType info_result) {
        return forWhereBindingOnly(that, info_result, name_result, supers_result, kind_result);
    }

    public RetType for_SyntaxTransformationWhereConstraintOnly(_SyntaxTransformationWhereConstraint that, RetType info_result) {
        return forWhereConstraintOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationWhereExtendsOnly(_SyntaxTransformationWhereExtends that, RetType name_result, List<RetType> supers_result, RetType info_result) {
        return forWhereExtendsOnly(that, info_result, name_result, supers_result);
    }

    public RetType for_SyntaxTransformationWhereTypeAliasOnly(_SyntaxTransformationWhereTypeAlias that, RetType alias_result, RetType info_result) {
        return forWhereTypeAliasOnly(that, info_result, alias_result);
    }

    public RetType for_SyntaxTransformationWhereCoercesOnly(_SyntaxTransformationWhereCoerces that, RetType left_result, RetType right_result, RetType info_result) {
        return forWhereCoercesOnly(that, info_result, left_result, right_result);
    }

    public RetType for_SyntaxTransformationWhereEqualsOnly(_SyntaxTransformationWhereEquals that, RetType left_result, RetType right_result, RetType info_result) {
        return forWhereEqualsOnly(that, info_result, left_result, right_result);
    }

    public RetType for_SyntaxTransformationUnitConstraintOnly(_SyntaxTransformationUnitConstraint that, RetType name_result, RetType info_result) {
        return forUnitConstraintOnly(that, info_result, name_result);
    }

    public RetType for_SyntaxTransformationIntConstraintOnly(_SyntaxTransformationIntConstraint that, RetType left_result, RetType right_result, RetType op_result, RetType info_result) {
        return forIntConstraintOnly(that, info_result, left_result, right_result, op_result);
    }

    public RetType for_SyntaxTransformationBoolConstraintExprOnly(_SyntaxTransformationBoolConstraintExpr that, RetType constraint_result, RetType info_result) {
        return forBoolConstraintExprOnly(that, info_result, constraint_result);
    }

    public RetType for_SyntaxTransformationContractOnly(_SyntaxTransformationContract that, Option<List<RetType>> requiresClause_result, Option<List<RetType>> ensuresClause_result, Option<List<RetType>> invariantsClause_result, RetType info_result) {
        return forContractOnly(that, info_result, requiresClause_result, ensuresClause_result, invariantsClause_result);
    }

    public RetType for_SyntaxTransformationEnsuresClauseOnly(_SyntaxTransformationEnsuresClause that, RetType post_result, Option<RetType> pre_result, RetType info_result) {
        return forEnsuresClauseOnly(that, info_result, post_result, pre_result);
    }

    public RetType for_SyntaxTransformationStaticParamOnly(_SyntaxTransformationStaticParam that, RetType name_result, List<RetType> extendsClause_result, List<RetType> dominatesClause_result, Option<RetType> dimParam_result, RetType kind_result, RetType info_result) {
        return forStaticParamOnly(that, info_result, name_result, extendsClause_result, dominatesClause_result, dimParam_result, kind_result);
    }

    public RetType for_SyntaxTransformationNameOnly(_SyntaxTransformationName that, RetType info_result) {
        return forNameOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationAPINameOnly(_SyntaxTransformationAPIName that, List<RetType> ids_result, RetType info_result) {
        return forAPINameOnly(that, info_result, ids_result);
    }

    public RetType for_SyntaxTransformationIdOrOpOrAnonymousNameOnly(_SyntaxTransformationIdOrOpOrAnonymousName that, Option<RetType> apiName_result, RetType info_result) {
        return forIdOrOpOrAnonymousNameOnly(that, info_result, apiName_result);
    }

    public RetType for_SyntaxTransformationIdOrOpOnly(_SyntaxTransformationIdOrOp that, Option<RetType> apiName_result, RetType info_result) {
        return forIdOrOpOnly(that, info_result, apiName_result);
    }

    public RetType for_SyntaxTransformationIdOnly(_SyntaxTransformationId that, Option<RetType> apiName_result, RetType info_result) {
        return forIdOnly(that, info_result, apiName_result);
    }

    public RetType for_SyntaxTransformationOpOnly(_SyntaxTransformationOp that, Option<RetType> apiName_result, RetType fixity_result, RetType info_result) {
        return forOpOnly(that, info_result, apiName_result, fixity_result);
    }

    public RetType for_SyntaxTransformationNamedOpOnly(_SyntaxTransformationNamedOp that, Option<RetType> apiName_result, RetType fixity_result, RetType info_result) {
        return forNamedOpOnly(that, info_result, apiName_result, fixity_result);
    }

    public RetType for_SyntaxTransformation_InferenceVarOpOnly(_SyntaxTransformation_InferenceVarOp that, Option<RetType> apiName_result, RetType fixity_result, RetType info_result) {
        return for_InferenceVarOpOnly(that, info_result, apiName_result, fixity_result);
    }

    public RetType for_SyntaxTransformationAnonymousNameOnly(_SyntaxTransformationAnonymousName that, Option<RetType> apiName_result, RetType info_result) {
        return forAnonymousNameOnly(that, info_result, apiName_result);
    }

    public RetType for_SyntaxTransformationAnonymousFnNameOnly(_SyntaxTransformationAnonymousFnName that, Option<RetType> apiName_result, RetType info_result) {
        return forAnonymousFnNameOnly(that, info_result, apiName_result);
    }

    public RetType for_SyntaxTransformationConstructorFnNameOnly(_SyntaxTransformationConstructorFnName that, Option<RetType> apiName_result, RetType constructor_result, RetType info_result) {
        return forConstructorFnNameOnly(that, info_result, apiName_result, constructor_result);
    }

    public RetType for_SyntaxTransformationArrayComprehensionClauseOnly(_SyntaxTransformationArrayComprehensionClause that, List<RetType> bind_result, RetType init_result, List<RetType> gens_result, RetType info_result) {
        return forArrayComprehensionClauseOnly(that, info_result, bind_result, init_result, gens_result);
    }

    public RetType for_SyntaxTransformationKeywordExprOnly(_SyntaxTransformationKeywordExpr that, RetType name_result, RetType init_result, RetType info_result) {
        return forKeywordExprOnly(that, info_result, name_result, init_result);
    }

    public RetType for_SyntaxTransformationCaseClauseOnly(_SyntaxTransformationCaseClause that, RetType matchClause_result, RetType body_result, Option<RetType> op_result, RetType info_result) {
        return forCaseClauseOnly(that, info_result, matchClause_result, body_result, op_result);
    }

    public RetType for_SyntaxTransformationCatchOnly(_SyntaxTransformationCatch that, RetType name_result, List<RetType> clauses_result, RetType info_result) {
        return forCatchOnly(that, info_result, name_result, clauses_result);
    }

    public RetType for_SyntaxTransformationCatchClauseOnly(_SyntaxTransformationCatchClause that, RetType matchType_result, RetType body_result, RetType info_result) {
        return forCatchClauseOnly(that, info_result, matchType_result, body_result);
    }

    public RetType for_SyntaxTransformationIfClauseOnly(_SyntaxTransformationIfClause that, RetType testClause_result, RetType body_result, RetType info_result) {
        return forIfClauseOnly(that, info_result, testClause_result, body_result);
    }

    public RetType for_SyntaxTransformationTypecaseClauseOnly(_SyntaxTransformationTypecaseClause that, Option<RetType> name_result, RetType matchType_result, RetType body_result, RetType info_result) {
        return forTypecaseClauseOnly(that, info_result, name_result, matchType_result, body_result);
    }

    public RetType for_SyntaxTransformationExtentRangeOnly(_SyntaxTransformationExtentRange that, Option<RetType> base_result, Option<RetType> size_result, Option<RetType> op_result, RetType info_result) {
        return forExtentRangeOnly(that, info_result, base_result, size_result, op_result);
    }

    public RetType for_SyntaxTransformationGeneratorClauseOnly(_SyntaxTransformationGeneratorClause that, List<RetType> bind_result, RetType init_result, RetType info_result) {
        return forGeneratorClauseOnly(that, info_result, bind_result, init_result);
    }

    public RetType for_SyntaxTransformationKeywordTypeOnly(_SyntaxTransformationKeywordType that, RetType name_result, RetType keywordType_result, RetType info_result) {
        return forKeywordTypeOnly(that, info_result, name_result, keywordType_result);
    }

    public RetType for_SyntaxTransformationTraitTypeWhereOnly(_SyntaxTransformationTraitTypeWhere that, RetType baseType_result, Option<RetType> whereClause_result, RetType info_result) {
        return forTraitTypeWhereOnly(that, info_result, baseType_result, whereClause_result);
    }

    public RetType for_SyntaxTransformationIndicesOnly(_SyntaxTransformationIndices that, List<RetType> extents_result, RetType info_result) {
        return forIndicesOnly(that, info_result, extents_result);
    }

    public RetType for_SyntaxTransformationMathItemOnly(_SyntaxTransformationMathItem that, RetType info_result) {
        return forMathItemOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationExprMIOnly(_SyntaxTransformationExprMI that, RetType expr_result, RetType info_result) {
        return forExprMIOnly(that, info_result, expr_result);
    }

    public RetType for_SyntaxTransformationParenthesisDelimitedMIOnly(_SyntaxTransformationParenthesisDelimitedMI that, RetType expr_result, RetType info_result) {
        return forParenthesisDelimitedMIOnly(that, info_result, expr_result);
    }

    public RetType for_SyntaxTransformationNonParenthesisDelimitedMIOnly(_SyntaxTransformationNonParenthesisDelimitedMI that, RetType expr_result, RetType info_result) {
        return forNonParenthesisDelimitedMIOnly(that, info_result, expr_result);
    }

    public RetType for_SyntaxTransformationNonExprMIOnly(_SyntaxTransformationNonExprMI that, RetType info_result) {
        return forNonExprMIOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationExponentiationMIOnly(_SyntaxTransformationExponentiationMI that, RetType op_result, Option<RetType> expr_result, RetType info_result) {
        return forExponentiationMIOnly(that, info_result, op_result, expr_result);
    }

    public RetType for_SyntaxTransformationSubscriptingMIOnly(_SyntaxTransformationSubscriptingMI that, RetType op_result, List<RetType> exprs_result, List<RetType> staticArgs_result, RetType info_result) {
        return forSubscriptingMIOnly(that, info_result, op_result, exprs_result, staticArgs_result);
    }

    public RetType for_SyntaxTransformationOverloadingOnly(_SyntaxTransformationOverloading that, RetType unambiguousName_result, RetType originalName_result, Option<RetType> type_result, Option<RetType> schema_result, RetType info_result) {
        return forOverloadingOnly(that, info_result, unambiguousName_result, originalName_result, type_result, schema_result);
    }

    public RetType for_SyntaxTransformationNonterminalHeaderOnly(_SyntaxTransformationNonterminalHeader that, RetType name_result, List<RetType> params_result, List<RetType> staticParams_result, Option<RetType> paramType_result, Option<RetType> whereClause_result, RetType info_result) {
        return forNonterminalHeaderOnly(that, info_result, name_result, params_result, staticParams_result, paramType_result, whereClause_result);
    }

    public RetType for_SyntaxTransformationNonterminalParameterOnly(_SyntaxTransformationNonterminalParameter that, RetType name_result, RetType paramType_result, RetType info_result) {
        return forNonterminalParameterOnly(that, info_result, name_result, paramType_result);
    }

    public RetType for_SyntaxTransformationSyntaxDeclOnly(_SyntaxTransformationSyntaxDecl that, RetType info_result) {
        return forSyntaxDeclOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationSyntaxDefOnly(_SyntaxTransformationSyntaxDef that, List<RetType> syntaxSymbols_result, RetType transformer_result, RetType info_result) {
        return forSyntaxDefOnly(that, info_result, syntaxSymbols_result, transformer_result);
    }

    public RetType for_SyntaxTransformationSuperSyntaxDefOnly(_SyntaxTransformationSuperSyntaxDef that, RetType nonterminal_result, RetType grammarId_result, RetType info_result) {
        return forSuperSyntaxDefOnly(that, info_result, nonterminal_result, grammarId_result);
    }

    public RetType for_SyntaxTransformationTransformerDeclOnly(_SyntaxTransformationTransformerDecl that, RetType info_result) {
        return forTransformerDeclOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationPreTransformerDefOnly(_SyntaxTransformationPreTransformerDef that, RetType transformer_result, RetType info_result) {
        return forPreTransformerDefOnly(that, info_result, transformer_result);
    }

    public RetType for_SyntaxTransformationNamedTransformerDefOnly(_SyntaxTransformationNamedTransformerDef that, List<RetType> parameters_result, RetType transformer_result, RetType info_result) {
        return forNamedTransformerDefOnly(that, info_result, parameters_result, transformer_result);
    }

    public RetType for_SyntaxTransformationTransformerOnly(_SyntaxTransformationTransformer that, RetType info_result) {
        return forTransformerOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationUnparsedTransformerOnly(_SyntaxTransformationUnparsedTransformer that, RetType nonterminal_result, RetType info_result) {
        return forUnparsedTransformerOnly(that, info_result, nonterminal_result);
    }

    public RetType for_SyntaxTransformationNodeTransformerOnly(_SyntaxTransformationNodeTransformer that, RetType node_result, RetType info_result) {
        return forNodeTransformerOnly(that, info_result, node_result);
    }

    public RetType for_SyntaxTransformationCaseTransformerOnly(_SyntaxTransformationCaseTransformer that, RetType gapName_result, List<RetType> clauses_result, RetType info_result) {
        return forCaseTransformerOnly(that, info_result, gapName_result, clauses_result);
    }

    public RetType for_SyntaxTransformationCaseTransformerClauseOnly(_SyntaxTransformationCaseTransformerClause that, RetType constructor_result, List<RetType> parameters_result, RetType body_result, RetType info_result) {
        return forCaseTransformerClauseOnly(that, info_result, constructor_result, parameters_result, body_result);
    }

    public RetType for_SyntaxTransformationSyntaxSymbolOnly(_SyntaxTransformationSyntaxSymbol that, RetType info_result) {
        return forSyntaxSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationPrefixedSymbolOnly(_SyntaxTransformationPrefixedSymbol that, RetType id_result, RetType symbol_result, RetType info_result) {
        return forPrefixedSymbolOnly(that, info_result, id_result, symbol_result);
    }

    public RetType for_SyntaxTransformationOptionalSymbolOnly(_SyntaxTransformationOptionalSymbol that, RetType symbol_result, RetType info_result) {
        return forOptionalSymbolOnly(that, info_result, symbol_result);
    }

    public RetType for_SyntaxTransformationRepeatSymbolOnly(_SyntaxTransformationRepeatSymbol that, RetType symbol_result, RetType info_result) {
        return forRepeatSymbolOnly(that, info_result, symbol_result);
    }

    public RetType for_SyntaxTransformationRepeatOneOrMoreSymbolOnly(_SyntaxTransformationRepeatOneOrMoreSymbol that, RetType symbol_result, RetType info_result) {
        return forRepeatOneOrMoreSymbolOnly(that, info_result, symbol_result);
    }

    public RetType for_SyntaxTransformationNoWhitespaceSymbolOnly(_SyntaxTransformationNoWhitespaceSymbol that, RetType symbol_result, RetType info_result) {
        return forNoWhitespaceSymbolOnly(that, info_result, symbol_result);
    }

    public RetType for_SyntaxTransformationGroupSymbolOnly(_SyntaxTransformationGroupSymbol that, List<RetType> symbols_result, RetType info_result) {
        return forGroupSymbolOnly(that, info_result, symbols_result);
    }

    public RetType for_SyntaxTransformationSpecialSymbolOnly(_SyntaxTransformationSpecialSymbol that, RetType info_result) {
        return forSpecialSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationAnyCharacterSymbolOnly(_SyntaxTransformationAnyCharacterSymbol that, RetType info_result) {
        return forAnyCharacterSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationWhitespaceSymbolOnly(_SyntaxTransformationWhitespaceSymbol that, RetType info_result) {
        return forWhitespaceSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationTabSymbolOnly(_SyntaxTransformationTabSymbol that, RetType info_result) {
        return forTabSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationFormfeedSymbolOnly(_SyntaxTransformationFormfeedSymbol that, RetType info_result) {
        return forFormfeedSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationCarriageReturnSymbolOnly(_SyntaxTransformationCarriageReturnSymbol that, RetType info_result) {
        return forCarriageReturnSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationBackspaceSymbolOnly(_SyntaxTransformationBackspaceSymbol that, RetType info_result) {
        return forBackspaceSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationNewlineSymbolOnly(_SyntaxTransformationNewlineSymbol that, RetType info_result) {
        return forNewlineSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationBreaklineSymbolOnly(_SyntaxTransformationBreaklineSymbol that, RetType info_result) {
        return forBreaklineSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationItemSymbolOnly(_SyntaxTransformationItemSymbol that, RetType info_result) {
        return forItemSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationNonterminalSymbolOnly(_SyntaxTransformationNonterminalSymbol that, RetType nonterminal_result, RetType info_result) {
        return forNonterminalSymbolOnly(that, info_result, nonterminal_result);
    }

    public RetType for_SyntaxTransformationKeywordSymbolOnly(_SyntaxTransformationKeywordSymbol that, RetType info_result) {
        return forKeywordSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationTokenSymbolOnly(_SyntaxTransformationTokenSymbol that, RetType info_result) {
        return forTokenSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationNotPredicateSymbolOnly(_SyntaxTransformationNotPredicateSymbol that, RetType symbol_result, RetType info_result) {
        return forNotPredicateSymbolOnly(that, info_result, symbol_result);
    }

    public RetType for_SyntaxTransformationAndPredicateSymbolOnly(_SyntaxTransformationAndPredicateSymbol that, RetType symbol_result, RetType info_result) {
        return forAndPredicateSymbolOnly(that, info_result, symbol_result);
    }

    public RetType for_SyntaxTransformationCharacterClassSymbolOnly(_SyntaxTransformationCharacterClassSymbol that, List<RetType> characters_result, RetType info_result) {
        return forCharacterClassSymbolOnly(that, info_result, characters_result);
    }

    public RetType for_SyntaxTransformationCharacterSymbolOnly(_SyntaxTransformationCharacterSymbol that, RetType info_result) {
        return forCharacterSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationCharSymbolOnly(_SyntaxTransformationCharSymbol that, RetType info_result) {
        return forCharSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationCharacterIntervalOnly(_SyntaxTransformationCharacterInterval that, RetType info_result) {
        return forCharacterIntervalOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationLinkOnly(_SyntaxTransformationLink that, RetType op_result, RetType expr_result, RetType info_result) {
        return forLinkOnly(that, info_result, op_result, expr_result);
    }

    public RetType for_EllipsesAbstractNodeOnly(_EllipsesAbstractNode that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesCompilationUnitOnly(_EllipsesCompilationUnit that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesComponentOnly(_EllipsesComponent that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesApiOnly(_EllipsesApi that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesImportOnly(_EllipsesImport that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesImportedNamesOnly(_EllipsesImportedNames that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesImportStarOnly(_EllipsesImportStar that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesImportNamesOnly(_EllipsesImportNames that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesImportApiOnly(_EllipsesImportApi that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesAliasedSimpleNameOnly(_EllipsesAliasedSimpleName that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesAliasedAPINameOnly(_EllipsesAliasedAPIName that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesDeclOnly(_EllipsesDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTraitObjectDeclOnly(_EllipsesTraitObjectDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTraitDeclOnly(_EllipsesTraitDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesObjectDeclOnly(_EllipsesObjectDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesVarDeclOnly(_EllipsesVarDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesFnDeclOnly(_EllipsesFnDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_Ellipses_RewriteFnOverloadDeclOnly(_Ellipses_RewriteFnOverloadDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_Ellipses_RewriteObjectExprDeclOnly(_Ellipses_RewriteObjectExprDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_Ellipses_RewriteFunctionalMethodDeclOnly(_Ellipses_RewriteFunctionalMethodDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesDimUnitDeclOnly(_EllipsesDimUnitDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesDimDeclOnly(_EllipsesDimDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesUnitDeclOnly(_EllipsesUnitDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTestDeclOnly(_EllipsesTestDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesPropertyDeclOnly(_EllipsesPropertyDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTypeAliasOnly(_EllipsesTypeAlias that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesGrammarDeclOnly(_EllipsesGrammarDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesGrammarMemberDeclOnly(_EllipsesGrammarMemberDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNonterminalDeclOnly(_EllipsesNonterminalDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNonterminalDefOnly(_EllipsesNonterminalDef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNonterminalExtensionDefOnly(_EllipsesNonterminalExtensionDef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBindingOnly(_EllipsesBinding that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesLValueOnly(_EllipsesLValue that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesParamOnly(_EllipsesParam that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesExprOnly(_EllipsesExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesDummyExprOnly(_EllipsesDummyExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTypeAnnotatedExprOnly(_EllipsesTypeAnnotatedExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesAsExprOnly(_EllipsesAsExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesAsIfExprOnly(_EllipsesAsIfExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesAssignmentOnly(_EllipsesAssignment that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBlockOnly(_EllipsesBlock that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesDoOnly(_EllipsesDo that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesCaseExprOnly(_EllipsesCaseExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesIfOnly(_EllipsesIf that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesLabelOnly(_EllipsesLabel that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesAbstractObjectExprOnly(_EllipsesAbstractObjectExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesObjectExprOnly(_EllipsesObjectExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_Ellipses_RewriteObjectExprOnly(_Ellipses_RewriteObjectExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTryOnly(_EllipsesTry that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTupleExprOnly(_EllipsesTupleExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTypecaseOnly(_EllipsesTypecase that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesWhileOnly(_EllipsesWhile that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesForOnly(_EllipsesFor that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBigOpAppOnly(_EllipsesBigOpApp that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesAccumulatorOnly(_EllipsesAccumulator that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesArrayComprehensionOnly(_EllipsesArrayComprehension that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesAtomicExprOnly(_EllipsesAtomicExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesExitOnly(_EllipsesExit that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesSpawnOnly(_EllipsesSpawn that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesThrowOnly(_EllipsesThrow that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTryAtomicExprOnly(_EllipsesTryAtomicExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesFnExprOnly(_EllipsesFnExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesLetExprOnly(_EllipsesLetExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesLetFnOnly(_EllipsesLetFn that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesLocalVarDeclOnly(_EllipsesLocalVarDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesSimpleExprOnly(_EllipsesSimpleExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesSubscriptExprOnly(_EllipsesSubscriptExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesPrimaryOnly(_EllipsesPrimary that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesLiteralExprOnly(_EllipsesLiteralExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNumberLiteralExprOnly(_EllipsesNumberLiteralExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesFloatLiteralExprOnly(_EllipsesFloatLiteralExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesIntLiteralExprOnly(_EllipsesIntLiteralExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesCharLiteralExprOnly(_EllipsesCharLiteralExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesStringLiteralExprOnly(_EllipsesStringLiteralExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesVoidLiteralExprOnly(_EllipsesVoidLiteralExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBooleanLiteralExprOnly(_EllipsesBooleanLiteralExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesVarRefOnly(_EllipsesVarRef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesFieldRefOnly(_EllipsesFieldRef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesFunctionalRefOnly(_EllipsesFunctionalRef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesFnRefOnly(_EllipsesFnRef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesOpRefOnly(_EllipsesOpRef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_Ellipses_RewriteFnRefOnly(_Ellipses_RewriteFnRef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_Ellipses_RewriteObjectExprRefOnly(_Ellipses_RewriteObjectExprRef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesJuxtOnly(_EllipsesJuxt that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_Ellipses_RewriteFnAppOnly(_Ellipses_RewriteFnApp that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesOpExprOnly(_EllipsesOpExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesAmbiguousMultifixOpExprOnly(_EllipsesAmbiguousMultifixOpExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesChainExprOnly(_EllipsesChainExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesCoercionInvocationOnly(_EllipsesCoercionInvocation that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTraitCoercionInvocationOnly(_EllipsesTraitCoercionInvocation that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTupleCoercionInvocationOnly(_EllipsesTupleCoercionInvocation that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesArrowCoercionInvocationOnly(_EllipsesArrowCoercionInvocation that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesUnionCoercionInvocationOnly(_EllipsesUnionCoercionInvocation that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesMethodInvocationOnly(_EllipsesMethodInvocation that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesMathPrimaryOnly(_EllipsesMathPrimary that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesArrayExprOnly(_EllipsesArrayExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesArrayElementOnly(_EllipsesArrayElement that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesArrayElementsOnly(_EllipsesArrayElements that) {
        return defaultEllipsesNodeCase(that);
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

    public RetType for_EllipsesPatternOnly(_EllipsesPattern that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesPatternArgsOnly(_EllipsesPatternArgs that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesPatternBindingOnly(_EllipsesPatternBinding that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesPlainPatternOnly(_EllipsesPlainPattern that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTypePatternOnly(_EllipsesTypePattern that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNestedPatternOnly(_EllipsesNestedPattern that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesStaticArgOnly(_EllipsesStaticArg that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTypeArgOnly(_EllipsesTypeArg that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesIntArgOnly(_EllipsesIntArg that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBoolArgOnly(_EllipsesBoolArg that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesOpArgOnly(_EllipsesOpArg that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesDimArgOnly(_EllipsesDimArg that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesUnitArgOnly(_EllipsesUnitArg that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesStaticExprOnly(_EllipsesStaticExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesIntExprOnly(_EllipsesIntExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesIntBaseOnly(_EllipsesIntBase that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesIntRefOnly(_EllipsesIntRef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesIntBinaryOpOnly(_EllipsesIntBinaryOp that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBoolExprOnly(_EllipsesBoolExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBoolBaseOnly(_EllipsesBoolBase that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBoolRefOnly(_EllipsesBoolRef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBoolConstraintOnly(_EllipsesBoolConstraint that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBoolUnaryOpOnly(_EllipsesBoolUnaryOp that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBoolBinaryOpOnly(_EllipsesBoolBinaryOp that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesUnitExprOnly(_EllipsesUnitExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesUnitRefOnly(_EllipsesUnitRef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesUnitBinaryOpOnly(_EllipsesUnitBinaryOp that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesEffectOnly(_EllipsesEffect that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesWhereClauseOnly(_EllipsesWhereClause that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesWhereBindingOnly(_EllipsesWhereBinding that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesWhereConstraintOnly(_EllipsesWhereConstraint that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesWhereExtendsOnly(_EllipsesWhereExtends that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesWhereTypeAliasOnly(_EllipsesWhereTypeAlias that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesWhereCoercesOnly(_EllipsesWhereCoerces that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesWhereEqualsOnly(_EllipsesWhereEquals that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesUnitConstraintOnly(_EllipsesUnitConstraint that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesIntConstraintOnly(_EllipsesIntConstraint that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBoolConstraintExprOnly(_EllipsesBoolConstraintExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesContractOnly(_EllipsesContract that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesEnsuresClauseOnly(_EllipsesEnsuresClause that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesStaticParamOnly(_EllipsesStaticParam that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNameOnly(_EllipsesName that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesAPINameOnly(_EllipsesAPIName that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesIdOrOpOrAnonymousNameOnly(_EllipsesIdOrOpOrAnonymousName that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesIdOrOpOnly(_EllipsesIdOrOp that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesIdOnly(_EllipsesId that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesOpOnly(_EllipsesOp that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNamedOpOnly(_EllipsesNamedOp that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_Ellipses_InferenceVarOpOnly(_Ellipses_InferenceVarOp that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesAnonymousNameOnly(_EllipsesAnonymousName that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesAnonymousFnNameOnly(_EllipsesAnonymousFnName that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesConstructorFnNameOnly(_EllipsesConstructorFnName that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesArrayComprehensionClauseOnly(_EllipsesArrayComprehensionClause that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesKeywordExprOnly(_EllipsesKeywordExpr that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesCaseClauseOnly(_EllipsesCaseClause that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesCatchOnly(_EllipsesCatch that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesCatchClauseOnly(_EllipsesCatchClause that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesIfClauseOnly(_EllipsesIfClause that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTypecaseClauseOnly(_EllipsesTypecaseClause that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesExtentRangeOnly(_EllipsesExtentRange that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesGeneratorClauseOnly(_EllipsesGeneratorClause that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesKeywordTypeOnly(_EllipsesKeywordType that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTraitTypeWhereOnly(_EllipsesTraitTypeWhere that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesIndicesOnly(_EllipsesIndices that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesMathItemOnly(_EllipsesMathItem that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesExprMIOnly(_EllipsesExprMI that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesParenthesisDelimitedMIOnly(_EllipsesParenthesisDelimitedMI that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNonParenthesisDelimitedMIOnly(_EllipsesNonParenthesisDelimitedMI that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNonExprMIOnly(_EllipsesNonExprMI that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesExponentiationMIOnly(_EllipsesExponentiationMI that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesSubscriptingMIOnly(_EllipsesSubscriptingMI that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesOverloadingOnly(_EllipsesOverloading that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNonterminalHeaderOnly(_EllipsesNonterminalHeader that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNonterminalParameterOnly(_EllipsesNonterminalParameter that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesSyntaxDeclOnly(_EllipsesSyntaxDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesSyntaxDefOnly(_EllipsesSyntaxDef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesSuperSyntaxDefOnly(_EllipsesSuperSyntaxDef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTransformerDeclOnly(_EllipsesTransformerDecl that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesPreTransformerDefOnly(_EllipsesPreTransformerDef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNamedTransformerDefOnly(_EllipsesNamedTransformerDef that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTransformerOnly(_EllipsesTransformer that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesUnparsedTransformerOnly(_EllipsesUnparsedTransformer that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNodeTransformerOnly(_EllipsesNodeTransformer that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesCaseTransformerOnly(_EllipsesCaseTransformer that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesCaseTransformerClauseOnly(_EllipsesCaseTransformerClause that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesSyntaxSymbolOnly(_EllipsesSyntaxSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesPrefixedSymbolOnly(_EllipsesPrefixedSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesOptionalSymbolOnly(_EllipsesOptionalSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesRepeatSymbolOnly(_EllipsesRepeatSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesRepeatOneOrMoreSymbolOnly(_EllipsesRepeatOneOrMoreSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNoWhitespaceSymbolOnly(_EllipsesNoWhitespaceSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesGroupSymbolOnly(_EllipsesGroupSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesSpecialSymbolOnly(_EllipsesSpecialSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesAnyCharacterSymbolOnly(_EllipsesAnyCharacterSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesWhitespaceSymbolOnly(_EllipsesWhitespaceSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTabSymbolOnly(_EllipsesTabSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesFormfeedSymbolOnly(_EllipsesFormfeedSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesCarriageReturnSymbolOnly(_EllipsesCarriageReturnSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBackspaceSymbolOnly(_EllipsesBackspaceSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNewlineSymbolOnly(_EllipsesNewlineSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBreaklineSymbolOnly(_EllipsesBreaklineSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesItemSymbolOnly(_EllipsesItemSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNonterminalSymbolOnly(_EllipsesNonterminalSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesKeywordSymbolOnly(_EllipsesKeywordSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTokenSymbolOnly(_EllipsesTokenSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesNotPredicateSymbolOnly(_EllipsesNotPredicateSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesAndPredicateSymbolOnly(_EllipsesAndPredicateSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesCharacterClassSymbolOnly(_EllipsesCharacterClassSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesCharacterSymbolOnly(_EllipsesCharacterSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesCharSymbolOnly(_EllipsesCharSymbol that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesCharacterIntervalOnly(_EllipsesCharacterInterval that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesLinkOnly(_EllipsesLink that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType forTemplateGapAbstractNodeOnly(TemplateGapAbstractNode that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCompilationUnitOnly(TemplateGapCompilationUnit that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapComponentOnly(TemplateGapComponent that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapApiOnly(TemplateGapApi that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapImportOnly(TemplateGapImport that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapImportedNamesOnly(TemplateGapImportedNames that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapImportStarOnly(TemplateGapImportStar that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapImportNamesOnly(TemplateGapImportNames that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapImportApiOnly(TemplateGapImportApi that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAliasedSimpleNameOnly(TemplateGapAliasedSimpleName that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAliasedAPINameOnly(TemplateGapAliasedAPIName that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDeclOnly(TemplateGapDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTraitObjectDeclOnly(TemplateGapTraitObjectDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTraitDeclOnly(TemplateGapTraitDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapObjectDeclOnly(TemplateGapObjectDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapVarDeclOnly(TemplateGapVarDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapFnDeclOnly(TemplateGapFnDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGap_RewriteFnOverloadDeclOnly(TemplateGap_RewriteFnOverloadDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGap_RewriteObjectExprDeclOnly(TemplateGap_RewriteObjectExprDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGap_RewriteFunctionalMethodDeclOnly(TemplateGap_RewriteFunctionalMethodDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDimUnitDeclOnly(TemplateGapDimUnitDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDimDeclOnly(TemplateGapDimDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapUnitDeclOnly(TemplateGapUnitDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTestDeclOnly(TemplateGapTestDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapPropertyDeclOnly(TemplateGapPropertyDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTypeAliasOnly(TemplateGapTypeAlias that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapGrammarDeclOnly(TemplateGapGrammarDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapGrammarMemberDeclOnly(TemplateGapGrammarMemberDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNonterminalDeclOnly(TemplateGapNonterminalDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNonterminalDefOnly(TemplateGapNonterminalDef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNonterminalExtensionDefOnly(TemplateGapNonterminalExtensionDef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBindingOnly(TemplateGapBinding that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapLValueOnly(TemplateGapLValue that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapParamOnly(TemplateGapParam that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapExprOnly(TemplateGapExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDummyExprOnly(TemplateGapDummyExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTypeAnnotatedExprOnly(TemplateGapTypeAnnotatedExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAsExprOnly(TemplateGapAsExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAsIfExprOnly(TemplateGapAsIfExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAssignmentOnly(TemplateGapAssignment that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBlockOnly(TemplateGapBlock that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDoOnly(TemplateGapDo that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCaseExprOnly(TemplateGapCaseExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIfOnly(TemplateGapIf that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapLabelOnly(TemplateGapLabel that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAbstractObjectExprOnly(TemplateGapAbstractObjectExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapObjectExprOnly(TemplateGapObjectExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGap_RewriteObjectExprOnly(TemplateGap_RewriteObjectExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTryOnly(TemplateGapTry that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTupleExprOnly(TemplateGapTupleExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTypecaseOnly(TemplateGapTypecase that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapWhileOnly(TemplateGapWhile that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapForOnly(TemplateGapFor that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBigOpAppOnly(TemplateGapBigOpApp that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAccumulatorOnly(TemplateGapAccumulator that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapArrayComprehensionOnly(TemplateGapArrayComprehension that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAtomicExprOnly(TemplateGapAtomicExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapExitOnly(TemplateGapExit that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapSpawnOnly(TemplateGapSpawn that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapThrowOnly(TemplateGapThrow that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTryAtomicExprOnly(TemplateGapTryAtomicExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapFnExprOnly(TemplateGapFnExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapLetExprOnly(TemplateGapLetExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapLetFnOnly(TemplateGapLetFn that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapLocalVarDeclOnly(TemplateGapLocalVarDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapSimpleExprOnly(TemplateGapSimpleExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapSubscriptExprOnly(TemplateGapSubscriptExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapPrimaryOnly(TemplateGapPrimary that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapLiteralExprOnly(TemplateGapLiteralExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNumberLiteralExprOnly(TemplateGapNumberLiteralExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapFloatLiteralExprOnly(TemplateGapFloatLiteralExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIntLiteralExprOnly(TemplateGapIntLiteralExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCharLiteralExprOnly(TemplateGapCharLiteralExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapStringLiteralExprOnly(TemplateGapStringLiteralExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapVoidLiteralExprOnly(TemplateGapVoidLiteralExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBooleanLiteralExprOnly(TemplateGapBooleanLiteralExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapVarRefOnly(TemplateGapVarRef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapFieldRefOnly(TemplateGapFieldRef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapFunctionalRefOnly(TemplateGapFunctionalRef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapFnRefOnly(TemplateGapFnRef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapOpRefOnly(TemplateGapOpRef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGap_RewriteFnRefOnly(TemplateGap_RewriteFnRef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGap_RewriteObjectExprRefOnly(TemplateGap_RewriteObjectExprRef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapJuxtOnly(TemplateGapJuxt that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGap_RewriteFnAppOnly(TemplateGap_RewriteFnApp that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapOpExprOnly(TemplateGapOpExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAmbiguousMultifixOpExprOnly(TemplateGapAmbiguousMultifixOpExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapChainExprOnly(TemplateGapChainExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCoercionInvocationOnly(TemplateGapCoercionInvocation that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTraitCoercionInvocationOnly(TemplateGapTraitCoercionInvocation that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTupleCoercionInvocationOnly(TemplateGapTupleCoercionInvocation that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapArrowCoercionInvocationOnly(TemplateGapArrowCoercionInvocation that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapUnionCoercionInvocationOnly(TemplateGapUnionCoercionInvocation that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapMethodInvocationOnly(TemplateGapMethodInvocation that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapMathPrimaryOnly(TemplateGapMathPrimary that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapArrayExprOnly(TemplateGapArrayExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapArrayElementOnly(TemplateGapArrayElement that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapArrayElementsOnly(TemplateGapArrayElements that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTypeOnly(TemplateGapType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBaseTypeOnly(TemplateGapBaseType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAnyTypeOnly(TemplateGapAnyType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBottomTypeOnly(TemplateGapBottomType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapUnknownTypeOnly(TemplateGapUnknownType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapSelfTypeOnly(TemplateGapSelfType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTraitSelfTypeOnly(TemplateGapTraitSelfType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapObjectExprTypeOnly(TemplateGapObjectExprType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNamedTypeOnly(TemplateGapNamedType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGap_InferenceVarTypeOnly(TemplateGap_InferenceVarType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapVarTypeOnly(TemplateGapVarType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTraitTypeOnly(TemplateGapTraitType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAbbreviatedTypeOnly(TemplateGapAbbreviatedType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapArrayTypeOnly(TemplateGapArrayType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapMatrixTypeOnly(TemplateGapMatrixType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTaggedDimTypeOnly(TemplateGapTaggedDimType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTaggedUnitTypeOnly(TemplateGapTaggedUnitType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTupleTypeOnly(TemplateGapTupleType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapArrowTypeOnly(TemplateGapArrowType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBoundTypeOnly(TemplateGapBoundType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIntersectionTypeOnly(TemplateGapIntersectionType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapUnionTypeOnly(TemplateGapUnionType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapFixedPointTypeOnly(TemplateGapFixedPointType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapLabelTypeOnly(TemplateGapLabelType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDimExprOnly(TemplateGapDimExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDimBaseOnly(TemplateGapDimBase that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDimRefOnly(TemplateGapDimRef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDimExponentOnly(TemplateGapDimExponent that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDimUnaryOpOnly(TemplateGapDimUnaryOp that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDimBinaryOpOnly(TemplateGapDimBinaryOp that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapPatternOnly(TemplateGapPattern that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapPatternArgsOnly(TemplateGapPatternArgs that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapPatternBindingOnly(TemplateGapPatternBinding that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapPlainPatternOnly(TemplateGapPlainPattern that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTypePatternOnly(TemplateGapTypePattern that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNestedPatternOnly(TemplateGapNestedPattern that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapStaticArgOnly(TemplateGapStaticArg that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTypeArgOnly(TemplateGapTypeArg that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIntArgOnly(TemplateGapIntArg that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBoolArgOnly(TemplateGapBoolArg that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapOpArgOnly(TemplateGapOpArg that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDimArgOnly(TemplateGapDimArg that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapUnitArgOnly(TemplateGapUnitArg that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapStaticExprOnly(TemplateGapStaticExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIntExprOnly(TemplateGapIntExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIntBaseOnly(TemplateGapIntBase that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIntRefOnly(TemplateGapIntRef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIntBinaryOpOnly(TemplateGapIntBinaryOp that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBoolExprOnly(TemplateGapBoolExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBoolBaseOnly(TemplateGapBoolBase that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBoolRefOnly(TemplateGapBoolRef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBoolConstraintOnly(TemplateGapBoolConstraint that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBoolUnaryOpOnly(TemplateGapBoolUnaryOp that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBoolBinaryOpOnly(TemplateGapBoolBinaryOp that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapUnitExprOnly(TemplateGapUnitExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapUnitRefOnly(TemplateGapUnitRef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapUnitBinaryOpOnly(TemplateGapUnitBinaryOp that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapEffectOnly(TemplateGapEffect that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapWhereClauseOnly(TemplateGapWhereClause that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapWhereBindingOnly(TemplateGapWhereBinding that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapWhereConstraintOnly(TemplateGapWhereConstraint that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapWhereExtendsOnly(TemplateGapWhereExtends that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapWhereTypeAliasOnly(TemplateGapWhereTypeAlias that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapWhereCoercesOnly(TemplateGapWhereCoerces that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapWhereEqualsOnly(TemplateGapWhereEquals that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapUnitConstraintOnly(TemplateGapUnitConstraint that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIntConstraintOnly(TemplateGapIntConstraint that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBoolConstraintExprOnly(TemplateGapBoolConstraintExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapContractOnly(TemplateGapContract that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapEnsuresClauseOnly(TemplateGapEnsuresClause that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapStaticParamOnly(TemplateGapStaticParam that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNameOnly(TemplateGapName that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAPINameOnly(TemplateGapAPIName that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIdOrOpOrAnonymousNameOnly(TemplateGapIdOrOpOrAnonymousName that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIdOrOpOnly(TemplateGapIdOrOp that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIdOnly(TemplateGapId that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapOpOnly(TemplateGapOp that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNamedOpOnly(TemplateGapNamedOp that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGap_InferenceVarOpOnly(TemplateGap_InferenceVarOp that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAnonymousNameOnly(TemplateGapAnonymousName that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAnonymousFnNameOnly(TemplateGapAnonymousFnName that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapConstructorFnNameOnly(TemplateGapConstructorFnName that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapArrayComprehensionClauseOnly(TemplateGapArrayComprehensionClause that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapKeywordExprOnly(TemplateGapKeywordExpr that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCaseClauseOnly(TemplateGapCaseClause that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCatchOnly(TemplateGapCatch that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCatchClauseOnly(TemplateGapCatchClause that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIfClauseOnly(TemplateGapIfClause that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTypecaseClauseOnly(TemplateGapTypecaseClause that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapExtentRangeOnly(TemplateGapExtentRange that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapGeneratorClauseOnly(TemplateGapGeneratorClause that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapKeywordTypeOnly(TemplateGapKeywordType that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTraitTypeWhereOnly(TemplateGapTraitTypeWhere that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIndicesOnly(TemplateGapIndices that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapMathItemOnly(TemplateGapMathItem that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapExprMIOnly(TemplateGapExprMI that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapParenthesisDelimitedMIOnly(TemplateGapParenthesisDelimitedMI that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNonParenthesisDelimitedMIOnly(TemplateGapNonParenthesisDelimitedMI that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNonExprMIOnly(TemplateGapNonExprMI that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapExponentiationMIOnly(TemplateGapExponentiationMI that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapSubscriptingMIOnly(TemplateGapSubscriptingMI that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapOverloadingOnly(TemplateGapOverloading that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNonterminalHeaderOnly(TemplateGapNonterminalHeader that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNonterminalParameterOnly(TemplateGapNonterminalParameter that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapSyntaxDeclOnly(TemplateGapSyntaxDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapSyntaxDefOnly(TemplateGapSyntaxDef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapSuperSyntaxDefOnly(TemplateGapSuperSyntaxDef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTransformerDeclOnly(TemplateGapTransformerDecl that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapPreTransformerDefOnly(TemplateGapPreTransformerDef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNamedTransformerDefOnly(TemplateGapNamedTransformerDef that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTransformerOnly(TemplateGapTransformer that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapUnparsedTransformerOnly(TemplateGapUnparsedTransformer that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNodeTransformerOnly(TemplateGapNodeTransformer that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCaseTransformerOnly(TemplateGapCaseTransformer that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCaseTransformerClauseOnly(TemplateGapCaseTransformerClause that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapSyntaxSymbolOnly(TemplateGapSyntaxSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapPrefixedSymbolOnly(TemplateGapPrefixedSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapOptionalSymbolOnly(TemplateGapOptionalSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapRepeatSymbolOnly(TemplateGapRepeatSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapRepeatOneOrMoreSymbolOnly(TemplateGapRepeatOneOrMoreSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNoWhitespaceSymbolOnly(TemplateGapNoWhitespaceSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapGroupSymbolOnly(TemplateGapGroupSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapSpecialSymbolOnly(TemplateGapSpecialSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAnyCharacterSymbolOnly(TemplateGapAnyCharacterSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapWhitespaceSymbolOnly(TemplateGapWhitespaceSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTabSymbolOnly(TemplateGapTabSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapFormfeedSymbolOnly(TemplateGapFormfeedSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCarriageReturnSymbolOnly(TemplateGapCarriageReturnSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBackspaceSymbolOnly(TemplateGapBackspaceSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNewlineSymbolOnly(TemplateGapNewlineSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBreaklineSymbolOnly(TemplateGapBreaklineSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapItemSymbolOnly(TemplateGapItemSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNonterminalSymbolOnly(TemplateGapNonterminalSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapKeywordSymbolOnly(TemplateGapKeywordSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTokenSymbolOnly(TemplateGapTokenSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNotPredicateSymbolOnly(TemplateGapNotPredicateSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAndPredicateSymbolOnly(TemplateGapAndPredicateSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCharacterClassSymbolOnly(TemplateGapCharacterClassSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCharacterSymbolOnly(TemplateGapCharacterSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCharSymbolOnly(TemplateGapCharSymbol that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCharacterIntervalOnly(TemplateGapCharacterInterval that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapLinkOnly(TemplateGapLink that, RetType info_result, RetType gapId_result, List<RetType> templateParams_result) {
        return defaultTemplateGapCase(that);
    }


    /** Methods to recur on each child. */
    public RetType forComponent(Component that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        List<RetType> imports_result = recurOnListOfImport(that.getImports());
        List<RetType> decls_result = recurOnListOfDecl(that.getDecls());
        List<RetType> comprises_result = recurOnListOfAPIName(that.getComprises());
        List<RetType> exports_result = recurOnListOfAPIName(that.getExports());
        return forComponentOnly(that, info_result, name_result, imports_result, decls_result, comprises_result, exports_result);
    }

    public RetType forApi(Api that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        List<RetType> imports_result = recurOnListOfImport(that.getImports());
        List<RetType> decls_result = recurOnListOfDecl(that.getDecls());
        List<RetType> comprises_result = recurOnListOfAPIName(that.getComprises());
        return forApiOnly(that, info_result, name_result, imports_result, decls_result, comprises_result);
    }

    public RetType forImportStar(ImportStar that) {
        RetType info_result = recur(that.getInfo());
        RetType apiName_result = recur(that.getApiName());
        List<RetType> exceptNames_result = recurOnListOfIdOrOpOrAnonymousName(that.getExceptNames());
        return forImportStarOnly(that, info_result, apiName_result, exceptNames_result);
    }

    public RetType forImportNames(ImportNames that) {
        RetType info_result = recur(that.getInfo());
        RetType apiName_result = recur(that.getApiName());
        List<RetType> aliasedNames_result = recurOnListOfAliasedSimpleName(that.getAliasedNames());
        return forImportNamesOnly(that, info_result, apiName_result, aliasedNames_result);
    }

    public RetType forImportApi(ImportApi that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> apis_result = recurOnListOfAliasedAPIName(that.getApis());
        return forImportApiOnly(that, info_result, apis_result);
    }

    public RetType forAliasedSimpleName(AliasedSimpleName that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        Option<RetType> alias_result = recurOnOptionOfIdOrOpOrAnonymousName(that.getAlias());
        return forAliasedSimpleNameOnly(that, info_result, name_result, alias_result);
    }

    public RetType forAliasedAPIName(AliasedAPIName that) {
        RetType info_result = recur(that.getInfo());
        RetType apiName_result = recur(that.getApiName());
        Option<RetType> alias_result = recurOnOptionOfId(that.getAlias());
        return forAliasedAPINameOnly(that, info_result, apiName_result, alias_result);
    }

    public RetType forTraitDecl(TraitDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType header_result = recur(that.getHeader());
        Option<RetType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        List<RetType> excludesClause_result = recurOnListOfBaseType(that.getExcludesClause());
        Option<List<RetType>> comprisesClause_result = recurOnOptionOfListOfNamedType(that.getComprisesClause());
        return forTraitDeclOnly(that, info_result, header_result, selfType_result, excludesClause_result, comprisesClause_result);
    }

    public RetType forObjectDecl(ObjectDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType header_result = recur(that.getHeader());
        Option<RetType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        return forObjectDeclOnly(that, info_result, header_result, selfType_result);
    }

    public RetType forVarDecl(VarDecl that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<RetType> init_result = recurOnOptionOfExpr(that.getInit());
        return forVarDeclOnly(that, info_result, lhs_result, init_result);
    }

    public RetType forFnDecl(FnDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType header_result = recur(that.getHeader());
        RetType unambiguousName_result = recur(that.getUnambiguousName());
        Option<RetType> body_result = recurOnOptionOfExpr(that.getBody());
        Option<RetType> implementsUnambiguousName_result = recurOnOptionOfIdOrOp(that.getImplementsUnambiguousName());
        return forFnDeclOnly(that, info_result, header_result, unambiguousName_result, body_result, implementsUnambiguousName_result);
    }

    public RetType for_RewriteFnOverloadDecl(_RewriteFnOverloadDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        List<RetType> fns_result = recurOnListOfIdOrOp(that.getFns());
        Option<RetType> type_result = recurOnOptionOfType(that.getType());
        return for_RewriteFnOverloadDeclOnly(that, info_result, name_result, fns_result, type_result);
    }

    public RetType for_RewriteObjectExprDecl(_RewriteObjectExprDecl that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> objectExprs_result = recurOnListOf_RewriteObjectExpr(that.getObjectExprs());
        return for_RewriteObjectExprDeclOnly(that, info_result, objectExprs_result);
    }

    public RetType for_RewriteFunctionalMethodDecl(_RewriteFunctionalMethodDecl that) {
        RetType info_result = recur(that.getInfo());
        return for_RewriteFunctionalMethodDeclOnly(that, info_result);
    }

    public RetType forDimDecl(DimDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType dimId_result = recur(that.getDimId());
        Option<RetType> derived_result = recurOnOptionOfType(that.getDerived());
        Option<RetType> defaultId_result = recurOnOptionOfId(that.getDefaultId());
        return forDimDeclOnly(that, info_result, dimId_result, derived_result, defaultId_result);
    }

    public RetType forUnitDecl(UnitDecl that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> units_result = recurOnListOfId(that.getUnits());
        Option<RetType> dimType_result = recurOnOptionOfType(that.getDimType());
        Option<RetType> defExpr_result = recurOnOptionOfExpr(that.getDefExpr());
        return forUnitDeclOnly(that, info_result, units_result, dimType_result, defExpr_result);
    }

    public RetType forTestDecl(TestDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        List<RetType> gens_result = recurOnListOfGeneratorClause(that.getGens());
        RetType expr_result = recur(that.getExpr());
        return forTestDeclOnly(that, info_result, name_result, gens_result, expr_result);
    }

    public RetType forPropertyDecl(PropertyDecl that) {
        RetType info_result = recur(that.getInfo());
        Option<RetType> name_result = recurOnOptionOfId(that.getName());
        List<RetType> params_result = recurOnListOfParam(that.getParams());
        RetType expr_result = recur(that.getExpr());
        return forPropertyDeclOnly(that, info_result, name_result, params_result, expr_result);
    }

    public RetType forTypeAlias(TypeAlias that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        List<RetType> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        RetType typeDef_result = recur(that.getTypeDef());
        return forTypeAliasOnly(that, info_result, name_result, staticParams_result, typeDef_result);
    }

    public RetType forGrammarDecl(GrammarDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        List<RetType> extendsClause_result = recurOnListOfId(that.getExtendsClause());
        List<RetType> members_result = recurOnListOfGrammarMemberDecl(that.getMembers());
        List<RetType> transformers_result = recurOnListOfTransformerDecl(that.getTransformers());
        return forGrammarDeclOnly(that, info_result, name_result, extendsClause_result, members_result, transformers_result);
    }

    public RetType forNonterminalDef(NonterminalDef that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        List<RetType> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        RetType header_result = recur(that.getHeader());
        Option<RetType> astType_result = recurOnOptionOfBaseType(that.getAstType());
        return forNonterminalDefOnly(that, info_result, name_result, syntaxDecls_result, header_result, astType_result);
    }

    public RetType forNonterminalExtensionDef(NonterminalExtensionDef that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        List<RetType> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        return forNonterminalExtensionDefOnly(that, info_result, name_result, syntaxDecls_result);
    }

    public RetType forLValue(LValue that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        Option<RetType> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        return forLValueOnly(that, info_result, name_result, idType_result);
    }

    public RetType forParam(Param that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        Option<RetType> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        Option<RetType> defaultExpr_result = recurOnOptionOfExpr(that.getDefaultExpr());
        Option<RetType> varargsType_result = recurOnOptionOfType(that.getVarargsType());
        return forParamOnly(that, info_result, name_result, idType_result, defaultExpr_result, varargsType_result);
    }

    public RetType forDummyExpr(DummyExpr that) {
        RetType info_result = recur(that.getInfo());
        return forDummyExprOnly(that, info_result);
    }

    public RetType forAsExpr(AsExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType expr_result = recur(that.getExpr());
        RetType annType_result = recur(that.getAnnType());
        return forAsExprOnly(that, info_result, expr_result, annType_result);
    }

    public RetType forAsIfExpr(AsIfExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType expr_result = recur(that.getExpr());
        RetType annType_result = recur(that.getAnnType());
        return forAsIfExprOnly(that, info_result, expr_result, annType_result);
    }

    public RetType forAssignment(Assignment that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> lhs_result = recurOnListOfLhs(that.getLhs());
        Option<RetType> assignOp_result = recurOnOptionOfFunctionalRef(that.getAssignOp());
        RetType rhs_result = recur(that.getRhs());
        List<RetType> assignmentInfos_result = recurOnListOfCompoundAssignmentInfo(that.getAssignmentInfos());
        return forAssignmentOnly(that, info_result, lhs_result, assignOp_result, rhs_result, assignmentInfos_result);
    }

    public RetType forBlock(Block that) {
        RetType info_result = recur(that.getInfo());
        Option<RetType> loc_result = recurOnOptionOfExpr(that.getLoc());
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        return forBlockOnly(that, info_result, loc_result, exprs_result);
    }

    public RetType forDo(Do that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> fronts_result = recurOnListOfBlock(that.getFronts());
        return forDoOnly(that, info_result, fronts_result);
    }

    public RetType forCaseExpr(CaseExpr that) {
        RetType info_result = recur(that.getInfo());
        Option<RetType> param_result = recurOnOptionOfExpr(that.getParam());
        Option<RetType> compare_result = recurOnOptionOfFunctionalRef(that.getCompare());
        RetType equalsOp_result = recur(that.getEqualsOp());
        RetType inOp_result = recur(that.getInOp());
        List<RetType> clauses_result = recurOnListOfCaseClause(that.getClauses());
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forCaseExprOnly(that, info_result, param_result, compare_result, equalsOp_result, inOp_result, clauses_result, elseClause_result);
    }

    public RetType forIf(If that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> clauses_result = recurOnListOfIfClause(that.getClauses());
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forIfOnly(that, info_result, clauses_result, elseClause_result);
    }

    public RetType forLabel(Label that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        RetType body_result = recur(that.getBody());
        return forLabelOnly(that, info_result, name_result, body_result);
    }

    public RetType forObjectExpr(ObjectExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType header_result = recur(that.getHeader());
        Option<RetType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        return forObjectExprOnly(that, info_result, header_result, selfType_result);
    }

    public RetType for_RewriteObjectExpr(_RewriteObjectExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType header_result = recur(that.getHeader());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_RewriteObjectExprOnly(that, info_result, header_result, staticArgs_result);
    }

    public RetType forTry(Try that) {
        RetType info_result = recur(that.getInfo());
        RetType body_result = recur(that.getBody());
        Option<RetType> catchClause_result = recurOnOptionOfCatch(that.getCatchClause());
        List<RetType> forbidClause_result = recurOnListOfBaseType(that.getForbidClause());
        Option<RetType> finallyClause_result = recurOnOptionOfBlock(that.getFinallyClause());
        return forTryOnly(that, info_result, body_result, catchClause_result, forbidClause_result, finallyClause_result);
    }

    public RetType forTupleExpr(TupleExpr that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        Option<RetType> varargs_result = recurOnOptionOfExpr(that.getVarargs());
        List<RetType> keywords_result = recurOnListOfKeywordExpr(that.getKeywords());
        return forTupleExprOnly(that, info_result, exprs_result, varargs_result, keywords_result);
    }

    public RetType forTypecase(Typecase that) {
        RetType info_result = recur(that.getInfo());
        RetType bindExpr_result = recur(that.getBindExpr());
        List<RetType> clauses_result = recurOnListOfTypecaseClause(that.getClauses());
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forTypecaseOnly(that, info_result, bindExpr_result, clauses_result, elseClause_result);
    }

    public RetType forWhile(While that) {
        RetType info_result = recur(that.getInfo());
        RetType testExpr_result = recur(that.getTestExpr());
        RetType body_result = recur(that.getBody());
        return forWhileOnly(that, info_result, testExpr_result, body_result);
    }

    public RetType forFor(For that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> gens_result = recurOnListOfGeneratorClause(that.getGens());
        RetType body_result = recur(that.getBody());
        return forForOnly(that, info_result, gens_result, body_result);
    }

    public RetType forAccumulator(Accumulator that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType accOp_result = recur(that.getAccOp());
        List<RetType> gens_result = recurOnListOfGeneratorClause(that.getGens());
        RetType body_result = recur(that.getBody());
        return forAccumulatorOnly(that, info_result, staticArgs_result, accOp_result, gens_result, body_result);
    }

    public RetType forArrayComprehension(ArrayComprehension that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<RetType> clauses_result = recurOnListOfArrayComprehensionClause(that.getClauses());
        return forArrayComprehensionOnly(that, info_result, staticArgs_result, clauses_result);
    }

    public RetType forAtomicExpr(AtomicExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType expr_result = recur(that.getExpr());
        return forAtomicExprOnly(that, info_result, expr_result);
    }

    public RetType forExit(Exit that) {
        RetType info_result = recur(that.getInfo());
        Option<RetType> target_result = recurOnOptionOfId(that.getTarget());
        Option<RetType> returnExpr_result = recurOnOptionOfExpr(that.getReturnExpr());
        return forExitOnly(that, info_result, target_result, returnExpr_result);
    }

    public RetType forSpawn(Spawn that) {
        RetType info_result = recur(that.getInfo());
        RetType body_result = recur(that.getBody());
        return forSpawnOnly(that, info_result, body_result);
    }

    public RetType forThrow(Throw that) {
        RetType info_result = recur(that.getInfo());
        RetType expr_result = recur(that.getExpr());
        return forThrowOnly(that, info_result, expr_result);
    }

    public RetType forTryAtomicExpr(TryAtomicExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType expr_result = recur(that.getExpr());
        return forTryAtomicExprOnly(that, info_result, expr_result);
    }

    public RetType forFnExpr(FnExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType header_result = recur(that.getHeader());
        RetType body_result = recur(that.getBody());
        return forFnExprOnly(that, info_result, header_result, body_result);
    }

    public RetType forLetFn(LetFn that) {
        RetType info_result = recur(that.getInfo());
        RetType body_result = recur(that.getBody());
        List<RetType> fns_result = recurOnListOfFnDecl(that.getFns());
        return forLetFnOnly(that, info_result, body_result, fns_result);
    }

    public RetType forLocalVarDecl(LocalVarDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType body_result = recur(that.getBody());
        List<RetType> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<RetType> rhs_result = recurOnOptionOfExpr(that.getRhs());
        return forLocalVarDeclOnly(that, info_result, body_result, lhs_result, rhs_result);
    }

    public RetType forSubscriptExpr(SubscriptExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType obj_result = recur(that.getObj());
        List<RetType> subs_result = recurOnListOfExpr(that.getSubs());
        Option<RetType> op_result = recurOnOptionOfOp(that.getOp());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return forSubscriptExprOnly(that, info_result, obj_result, subs_result, op_result, staticArgs_result);
    }

    public RetType forFloatLiteralExpr(FloatLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        return forFloatLiteralExprOnly(that, info_result);
    }

    public RetType forIntLiteralExpr(IntLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        return forIntLiteralExprOnly(that, info_result);
    }

    public RetType forCharLiteralExpr(CharLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        return forCharLiteralExprOnly(that, info_result);
    }

    public RetType forStringLiteralExpr(StringLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        return forStringLiteralExprOnly(that, info_result);
    }

    public RetType forVoidLiteralExpr(VoidLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        return forVoidLiteralExprOnly(that, info_result);
    }

    public RetType forBooleanLiteralExpr(BooleanLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        return forBooleanLiteralExprOnly(that, info_result);
    }

    public RetType forVarRef(VarRef that) {
        RetType info_result = recur(that.getInfo());
        RetType varId_result = recur(that.getVarId());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return forVarRefOnly(that, info_result, varId_result, staticArgs_result);
    }

    public RetType forFieldRef(FieldRef that) {
        RetType info_result = recur(that.getInfo());
        RetType obj_result = recur(that.getObj());
        RetType field_result = recur(that.getField());
        return forFieldRefOnly(that, info_result, obj_result, field_result);
    }

    public RetType forFnRef(FnRef that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType originalName_result = recur(that.getOriginalName());
        List<RetType> names_result = recurOnListOfIdOrOp(that.getNames());
        List<RetType> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<RetType> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<RetType> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<RetType> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return forFnRefOnly(that, info_result, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType forOpRef(OpRef that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType originalName_result = recur(that.getOriginalName());
        List<RetType> names_result = recurOnListOfIdOrOp(that.getNames());
        List<RetType> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<RetType> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<RetType> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<RetType> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return forOpRefOnly(that, info_result, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType for_RewriteFnRef(_RewriteFnRef that) {
        RetType info_result = recur(that.getInfo());
        RetType fnExpr_result = recur(that.getFnExpr());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_RewriteFnRefOnly(that, info_result, fnExpr_result, staticArgs_result);
    }

    public RetType for_RewriteObjectExprRef(_RewriteObjectExprRef that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_RewriteObjectExprRefOnly(that, info_result, staticArgs_result);
    }

    public RetType forJuxt(Juxt that) {
        RetType info_result = recur(that.getInfo());
        RetType multiJuxt_result = recur(that.getMultiJuxt());
        RetType infixJuxt_result = recur(that.getInfixJuxt());
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        return forJuxtOnly(that, info_result, multiJuxt_result, infixJuxt_result, exprs_result);
    }

    public RetType for_RewriteFnApp(_RewriteFnApp that) {
        RetType info_result = recur(that.getInfo());
        RetType function_result = recur(that.getFunction());
        RetType argument_result = recur(that.getArgument());
        return for_RewriteFnAppOnly(that, info_result, function_result, argument_result);
    }

    public RetType forOpExpr(OpExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType op_result = recur(that.getOp());
        List<RetType> args_result = recurOnListOfExpr(that.getArgs());
        return forOpExprOnly(that, info_result, op_result, args_result);
    }

    public RetType forAmbiguousMultifixOpExpr(AmbiguousMultifixOpExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType infix_op_result = recur(that.getInfix_op());
        RetType multifix_op_result = recur(that.getMultifix_op());
        List<RetType> args_result = recurOnListOfExpr(that.getArgs());
        return forAmbiguousMultifixOpExprOnly(that, info_result, infix_op_result, multifix_op_result, args_result);
    }

    public RetType forChainExpr(ChainExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType first_result = recur(that.getFirst());
        List<RetType> links_result = recurOnListOfLink(that.getLinks());
        return forChainExprOnly(that, info_result, first_result, links_result);
    }

    public RetType forTraitCoercionInvocation(TraitCoercionInvocation that) {
        RetType info_result = recur(that.getInfo());
        RetType arg_result = recur(that.getArg());
        RetType toType_result = recur(that.getToType());
        RetType coercionFn_result = recur(that.getCoercionFn());
        return forTraitCoercionInvocationOnly(that, info_result, arg_result, toType_result, coercionFn_result);
    }

    public RetType forTupleCoercionInvocation(TupleCoercionInvocation that) {
        RetType info_result = recur(that.getInfo());
        RetType arg_result = recur(that.getArg());
        RetType toType_result = recur(that.getToType());
        List<Option<RetType>> subCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getSubCoercions());
        Option<Option<RetType>> varargCoercion_result = recurOnOptionOfOptionOfCoercionInvocation(that.getVarargCoercion());
        return forTupleCoercionInvocationOnly(that, info_result, arg_result, toType_result, subCoercions_result, varargCoercion_result);
    }

    public RetType forArrowCoercionInvocation(ArrowCoercionInvocation that) {
        RetType info_result = recur(that.getInfo());
        RetType arg_result = recur(that.getArg());
        RetType toType_result = recur(that.getToType());
        Option<RetType> domainCoercion_result = recurOnOptionOfCoercionInvocation(that.getDomainCoercion());
        Option<RetType> rangeCoercion_result = recurOnOptionOfCoercionInvocation(that.getRangeCoercion());
        return forArrowCoercionInvocationOnly(that, info_result, arg_result, toType_result, domainCoercion_result, rangeCoercion_result);
    }

    public RetType forUnionCoercionInvocation(UnionCoercionInvocation that) {
        RetType info_result = recur(that.getInfo());
        RetType toType_result = recur(that.getToType());
        RetType arg_result = recur(that.getArg());
        List<RetType> fromTypes_result = recurOnListOfType(that.getFromTypes());
        List<Option<RetType>> fromCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getFromCoercions());
        return forUnionCoercionInvocationOnly(that, info_result, toType_result, arg_result, fromTypes_result, fromCoercions_result);
    }

    public RetType forMethodInvocation(MethodInvocation that) {
        RetType info_result = recur(that.getInfo());
        RetType obj_result = recur(that.getObj());
        RetType method_result = recur(that.getMethod());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType arg_result = recur(that.getArg());
        Option<RetType> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<RetType> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return forMethodInvocationOnly(that, info_result, obj_result, method_result, staticArgs_result, arg_result, overloadingType_result, overloadingSchema_result);
    }

    public RetType forMathPrimary(MathPrimary that) {
        RetType info_result = recur(that.getInfo());
        RetType multiJuxt_result = recur(that.getMultiJuxt());
        RetType infixJuxt_result = recur(that.getInfixJuxt());
        RetType front_result = recur(that.getFront());
        List<RetType> rest_result = recurOnListOfMathItem(that.getRest());
        return forMathPrimaryOnly(that, info_result, multiJuxt_result, infixJuxt_result, front_result, rest_result);
    }

    public RetType forArrayElement(ArrayElement that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType element_result = recur(that.getElement());
        return forArrayElementOnly(that, info_result, staticArgs_result, element_result);
    }

    public RetType forArrayElements(ArrayElements that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<RetType> elements_result = recurOnListOfArrayExpr(that.getElements());
        return forArrayElementsOnly(that, info_result, staticArgs_result, elements_result);
    }

    public RetType forAnyType(AnyType that) {
        RetType info_result = recur(that.getInfo());
        return forAnyTypeOnly(that, info_result);
    }

    public RetType forBottomType(BottomType that) {
        RetType info_result = recur(that.getInfo());
        return forBottomTypeOnly(that, info_result);
    }

    public RetType forUnknownType(UnknownType that) {
        RetType info_result = recur(that.getInfo());
        return forUnknownTypeOnly(that, info_result);
    }

    public RetType forTraitSelfType(TraitSelfType that) {
        RetType info_result = recur(that.getInfo());
        RetType named_result = recur(that.getNamed());
        List<RetType> comprised_result = recurOnListOfNamedType(that.getComprised());
        return forTraitSelfTypeOnly(that, info_result, named_result, comprised_result);
    }

    public RetType forObjectExprType(ObjectExprType that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> extended_result = recurOnListOfBaseType(that.getExtended());
        return forObjectExprTypeOnly(that, info_result, extended_result);
    }

    public RetType for_InferenceVarType(_InferenceVarType that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        return for_InferenceVarTypeOnly(that, info_result, name_result);
    }

    public RetType forVarType(VarType that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        return forVarTypeOnly(that, info_result, name_result);
    }

    public RetType forTraitType(TraitType that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        List<RetType> args_result = recurOnListOfStaticArg(that.getArgs());
        List<RetType> traitStaticParams_result = recurOnListOfStaticParam(that.getTraitStaticParams());
        return forTraitTypeOnly(that, info_result, name_result, args_result, traitStaticParams_result);
    }

    public RetType forArrayType(ArrayType that) {
        RetType info_result = recur(that.getInfo());
        RetType elemType_result = recur(that.getElemType());
        RetType indices_result = recur(that.getIndices());
        return forArrayTypeOnly(that, info_result, elemType_result, indices_result);
    }

    public RetType forMatrixType(MatrixType that) {
        RetType info_result = recur(that.getInfo());
        RetType elemType_result = recur(that.getElemType());
        List<RetType> dimensions_result = recurOnListOfExtentRange(that.getDimensions());
        return forMatrixTypeOnly(that, info_result, elemType_result, dimensions_result);
    }

    public RetType forTaggedDimType(TaggedDimType that) {
        RetType info_result = recur(that.getInfo());
        RetType elemType_result = recur(that.getElemType());
        RetType dimExpr_result = recur(that.getDimExpr());
        Option<RetType> unitExpr_result = recurOnOptionOfExpr(that.getUnitExpr());
        return forTaggedDimTypeOnly(that, info_result, elemType_result, dimExpr_result, unitExpr_result);
    }

    public RetType forTaggedUnitType(TaggedUnitType that) {
        RetType info_result = recur(that.getInfo());
        RetType elemType_result = recur(that.getElemType());
        RetType unitExpr_result = recur(that.getUnitExpr());
        return forTaggedUnitTypeOnly(that, info_result, elemType_result, unitExpr_result);
    }

    public RetType forTupleType(TupleType that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> elements_result = recurOnListOfType(that.getElements());
        Option<RetType> varargs_result = recurOnOptionOfType(that.getVarargs());
        List<RetType> keywords_result = recurOnListOfKeywordType(that.getKeywords());
        return forTupleTypeOnly(that, info_result, elements_result, varargs_result, keywords_result);
    }

    public RetType forArrowType(ArrowType that) {
        RetType info_result = recur(that.getInfo());
        RetType domain_result = recur(that.getDomain());
        RetType range_result = recur(that.getRange());
        RetType effect_result = recur(that.getEffect());
        Option<RetType> methodInfo_result = recurOnOptionOfMethodInfo(that.getMethodInfo());
        return forArrowTypeOnly(that, info_result, domain_result, range_result, effect_result, methodInfo_result);
    }

    public RetType forIntersectionType(IntersectionType that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> elements_result = recurOnListOfType(that.getElements());
        return forIntersectionTypeOnly(that, info_result, elements_result);
    }

    public RetType forUnionType(UnionType that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> elements_result = recurOnListOfType(that.getElements());
        return forUnionTypeOnly(that, info_result, elements_result);
    }

    public RetType forFixedPointType(FixedPointType that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        RetType body_result = recur(that.getBody());
        return forFixedPointTypeOnly(that, info_result, name_result, body_result);
    }

    public RetType forLabelType(LabelType that) {
        RetType info_result = recur(that.getInfo());
        return forLabelTypeOnly(that, info_result);
    }

    public RetType forDimBase(DimBase that) {
        RetType info_result = recur(that.getInfo());
        return forDimBaseOnly(that, info_result);
    }

    public RetType forDimRef(DimRef that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        return forDimRefOnly(that, info_result, name_result);
    }

    public RetType forDimExponent(DimExponent that) {
        RetType info_result = recur(that.getInfo());
        RetType base_result = recur(that.getBase());
        RetType power_result = recur(that.getPower());
        return forDimExponentOnly(that, info_result, base_result, power_result);
    }

    public RetType forDimUnaryOp(DimUnaryOp that) {
        RetType info_result = recur(that.getInfo());
        RetType dimVal_result = recur(that.getDimVal());
        RetType op_result = recur(that.getOp());
        return forDimUnaryOpOnly(that, info_result, dimVal_result, op_result);
    }

    public RetType forDimBinaryOp(DimBinaryOp that) {
        RetType info_result = recur(that.getInfo());
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        return forDimBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }

    public RetType forPattern(Pattern that) {
        RetType info_result = recur(that.getInfo());
        Option<RetType> name_result = recurOnOptionOfType(that.getName());
        RetType patterns_result = recur(that.getPatterns());
        return forPatternOnly(that, info_result, name_result, patterns_result);
    }

    public RetType forPatternArgs(PatternArgs that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> patterns_result = recurOnListOfPatternBinding(that.getPatterns());
        return forPatternArgsOnly(that, info_result, patterns_result);
    }

    public RetType forPlainPattern(PlainPattern that) {
        RetType info_result = recur(that.getInfo());
        Option<RetType> field_result = recurOnOptionOfId(that.getField());
        RetType name_result = recur(that.getName());
        Option<RetType> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        return forPlainPatternOnly(that, info_result, field_result, name_result, idType_result);
    }

    public RetType forTypePattern(TypePattern that) {
        RetType info_result = recur(that.getInfo());
        Option<RetType> field_result = recurOnOptionOfId(that.getField());
        RetType typ_result = recur(that.getTyp());
        return forTypePatternOnly(that, info_result, field_result, typ_result);
    }

    public RetType forNestedPattern(NestedPattern that) {
        RetType info_result = recur(that.getInfo());
        Option<RetType> field_result = recurOnOptionOfId(that.getField());
        RetType pat_result = recur(that.getPat());
        return forNestedPatternOnly(that, info_result, field_result, pat_result);
    }

    public RetType forTypeArg(TypeArg that) {
        RetType info_result = recur(that.getInfo());
        RetType typeArg_result = recur(that.getTypeArg());
        return forTypeArgOnly(that, info_result, typeArg_result);
    }

    public RetType forIntArg(IntArg that) {
        RetType info_result = recur(that.getInfo());
        RetType intVal_result = recur(that.getIntVal());
        return forIntArgOnly(that, info_result, intVal_result);
    }

    public RetType forBoolArg(BoolArg that) {
        RetType info_result = recur(that.getInfo());
        RetType boolArg_result = recur(that.getBoolArg());
        return forBoolArgOnly(that, info_result, boolArg_result);
    }

    public RetType forOpArg(OpArg that) {
        RetType info_result = recur(that.getInfo());
        RetType id_result = recur(that.getId());
        return forOpArgOnly(that, info_result, id_result);
    }

    public RetType forDimArg(DimArg that) {
        RetType info_result = recur(that.getInfo());
        RetType dimArg_result = recur(that.getDimArg());
        return forDimArgOnly(that, info_result, dimArg_result);
    }

    public RetType forUnitArg(UnitArg that) {
        RetType info_result = recur(that.getInfo());
        RetType unitArg_result = recur(that.getUnitArg());
        return forUnitArgOnly(that, info_result, unitArg_result);
    }

    public RetType forIntBase(IntBase that) {
        RetType info_result = recur(that.getInfo());
        RetType intVal_result = recur(that.getIntVal());
        return forIntBaseOnly(that, info_result, intVal_result);
    }

    public RetType forIntRef(IntRef that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        return forIntRefOnly(that, info_result, name_result);
    }

    public RetType forIntBinaryOp(IntBinaryOp that) {
        RetType info_result = recur(that.getInfo());
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        return forIntBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }

    public RetType forBoolBase(BoolBase that) {
        RetType info_result = recur(that.getInfo());
        return forBoolBaseOnly(that, info_result);
    }

    public RetType forBoolRef(BoolRef that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        return forBoolRefOnly(that, info_result, name_result);
    }

    public RetType forBoolUnaryOp(BoolUnaryOp that) {
        RetType info_result = recur(that.getInfo());
        RetType boolVal_result = recur(that.getBoolVal());
        RetType op_result = recur(that.getOp());
        return forBoolUnaryOpOnly(that, info_result, boolVal_result, op_result);
    }

    public RetType forBoolBinaryOp(BoolBinaryOp that) {
        RetType info_result = recur(that.getInfo());
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        return forBoolBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }

    public RetType forUnitRef(UnitRef that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        return forUnitRefOnly(that, info_result, name_result);
    }

    public RetType forUnitBinaryOp(UnitBinaryOp that) {
        RetType info_result = recur(that.getInfo());
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        return forUnitBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }

    public RetType forEffect(Effect that) {
        RetType info_result = recur(that.getInfo());
        Option<List<RetType>> throwsClause_result = recurOnOptionOfListOfType(that.getThrowsClause());
        return forEffectOnly(that, info_result, throwsClause_result);
    }

    public RetType forWhereClause(WhereClause that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> bindings_result = recurOnListOfWhereBinding(that.getBindings());
        List<RetType> constraints_result = recurOnListOfWhereConstraint(that.getConstraints());
        return forWhereClauseOnly(that, info_result, bindings_result, constraints_result);
    }

    public RetType forWhereBinding(WhereBinding that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        List<RetType> supers_result = recurOnListOfBaseType(that.getSupers());
        RetType kind_result = recur(that.getKind());
        return forWhereBindingOnly(that, info_result, name_result, supers_result, kind_result);
    }

    public RetType forWhereExtends(WhereExtends that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        List<RetType> supers_result = recurOnListOfBaseType(that.getSupers());
        return forWhereExtendsOnly(that, info_result, name_result, supers_result);
    }

    public RetType forWhereTypeAlias(WhereTypeAlias that) {
        RetType info_result = recur(that.getInfo());
        RetType alias_result = recur(that.getAlias());
        return forWhereTypeAliasOnly(that, info_result, alias_result);
    }

    public RetType forWhereCoerces(WhereCoerces that) {
        RetType info_result = recur(that.getInfo());
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        return forWhereCoercesOnly(that, info_result, left_result, right_result);
    }

    public RetType forWhereEquals(WhereEquals that) {
        RetType info_result = recur(that.getInfo());
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        return forWhereEqualsOnly(that, info_result, left_result, right_result);
    }

    public RetType forUnitConstraint(UnitConstraint that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        return forUnitConstraintOnly(that, info_result, name_result);
    }

    public RetType forIntConstraint(IntConstraint that) {
        RetType info_result = recur(that.getInfo());
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        return forIntConstraintOnly(that, info_result, left_result, right_result, op_result);
    }

    public RetType forBoolConstraintExpr(BoolConstraintExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType constraint_result = recur(that.getConstraint());
        return forBoolConstraintExprOnly(that, info_result, constraint_result);
    }

    public RetType forContract(Contract that) {
        RetType info_result = recur(that.getInfo());
        Option<List<RetType>> requiresClause_result = recurOnOptionOfListOfExpr(that.getRequiresClause());
        Option<List<RetType>> ensuresClause_result = recurOnOptionOfListOfEnsuresClause(that.getEnsuresClause());
        Option<List<RetType>> invariantsClause_result = recurOnOptionOfListOfExpr(that.getInvariantsClause());
        return forContractOnly(that, info_result, requiresClause_result, ensuresClause_result, invariantsClause_result);
    }

    public RetType forEnsuresClause(EnsuresClause that) {
        RetType info_result = recur(that.getInfo());
        RetType post_result = recur(that.getPost());
        Option<RetType> pre_result = recurOnOptionOfExpr(that.getPre());
        return forEnsuresClauseOnly(that, info_result, post_result, pre_result);
    }

    public RetType forStaticParam(StaticParam that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        List<RetType> extendsClause_result = recurOnListOfBaseType(that.getExtendsClause());
        List<RetType> dominatesClause_result = recurOnListOfBaseType(that.getDominatesClause());
        Option<RetType> dimParam_result = recurOnOptionOfType(that.getDimParam());
        RetType kind_result = recur(that.getKind());
        return forStaticParamOnly(that, info_result, name_result, extendsClause_result, dominatesClause_result, dimParam_result, kind_result);
    }

    public RetType forAPIName(APIName that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> ids_result = recurOnListOfId(that.getIds());
        return forAPINameOnly(that, info_result, ids_result);
    }

    public RetType forId(Id that) {
        RetType info_result = recur(that.getInfo());
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return forIdOnly(that, info_result, apiName_result);
    }

    public RetType forNamedOp(NamedOp that) {
        RetType info_result = recur(that.getInfo());
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        RetType fixity_result = recur(that.getFixity());
        return forNamedOpOnly(that, info_result, apiName_result, fixity_result);
    }

    public RetType for_InferenceVarOp(_InferenceVarOp that) {
        RetType info_result = recur(that.getInfo());
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        RetType fixity_result = recur(that.getFixity());
        return for_InferenceVarOpOnly(that, info_result, apiName_result, fixity_result);
    }

    public RetType forAnonymousFnName(AnonymousFnName that) {
        RetType info_result = recur(that.getInfo());
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return forAnonymousFnNameOnly(that, info_result, apiName_result);
    }

    public RetType forConstructorFnName(ConstructorFnName that) {
        RetType info_result = recur(that.getInfo());
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        RetType constructor_result = recur(that.getConstructor());
        return forConstructorFnNameOnly(that, info_result, apiName_result, constructor_result);
    }

    public RetType forArrayComprehensionClause(ArrayComprehensionClause that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> bind_result = recurOnListOfExpr(that.getBind());
        RetType init_result = recur(that.getInit());
        List<RetType> gens_result = recurOnListOfGeneratorClause(that.getGens());
        return forArrayComprehensionClauseOnly(that, info_result, bind_result, init_result, gens_result);
    }

    public RetType forKeywordExpr(KeywordExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        RetType init_result = recur(that.getInit());
        return forKeywordExprOnly(that, info_result, name_result, init_result);
    }

    public RetType forCaseClause(CaseClause that) {
        RetType info_result = recur(that.getInfo());
        RetType matchClause_result = recur(that.getMatchClause());
        RetType body_result = recur(that.getBody());
        Option<RetType> op_result = recurOnOptionOfFunctionalRef(that.getOp());
        return forCaseClauseOnly(that, info_result, matchClause_result, body_result, op_result);
    }

    public RetType forCatch(Catch that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        List<RetType> clauses_result = recurOnListOfCatchClause(that.getClauses());
        return forCatchOnly(that, info_result, name_result, clauses_result);
    }

    public RetType forCatchClause(CatchClause that) {
        RetType info_result = recur(that.getInfo());
        RetType matchType_result = recur(that.getMatchType());
        RetType body_result = recur(that.getBody());
        return forCatchClauseOnly(that, info_result, matchType_result, body_result);
    }

    public RetType forIfClause(IfClause that) {
        RetType info_result = recur(that.getInfo());
        RetType testClause_result = recur(that.getTestClause());
        RetType body_result = recur(that.getBody());
        return forIfClauseOnly(that, info_result, testClause_result, body_result);
    }

    public RetType forTypecaseClause(TypecaseClause that) {
        RetType info_result = recur(that.getInfo());
        Option<RetType> name_result = recurOnOptionOfId(that.getName());
        RetType matchType_result = recur(that.getMatchType());
        RetType body_result = recur(that.getBody());
        return forTypecaseClauseOnly(that, info_result, name_result, matchType_result, body_result);
    }

    public RetType forExtentRange(ExtentRange that) {
        RetType info_result = recur(that.getInfo());
        Option<RetType> base_result = recurOnOptionOfStaticArg(that.getBase());
        Option<RetType> size_result = recurOnOptionOfStaticArg(that.getSize());
        Option<RetType> op_result = recurOnOptionOfOp(that.getOp());
        return forExtentRangeOnly(that, info_result, base_result, size_result, op_result);
    }

    public RetType forGeneratorClause(GeneratorClause that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> bind_result = recurOnListOfId(that.getBind());
        RetType init_result = recur(that.getInit());
        return forGeneratorClauseOnly(that, info_result, bind_result, init_result);
    }

    public RetType forKeywordType(KeywordType that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        RetType keywordType_result = recur(that.getKeywordType());
        return forKeywordTypeOnly(that, info_result, name_result, keywordType_result);
    }

    public RetType forTraitTypeWhere(TraitTypeWhere that) {
        RetType info_result = recur(that.getInfo());
        RetType baseType_result = recur(that.getBaseType());
        Option<RetType> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        return forTraitTypeWhereOnly(that, info_result, baseType_result, whereClause_result);
    }

    public RetType forIndices(Indices that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> extents_result = recurOnListOfExtentRange(that.getExtents());
        return forIndicesOnly(that, info_result, extents_result);
    }

    public RetType forParenthesisDelimitedMI(ParenthesisDelimitedMI that) {
        RetType info_result = recur(that.getInfo());
        RetType expr_result = recur(that.getExpr());
        return forParenthesisDelimitedMIOnly(that, info_result, expr_result);
    }

    public RetType forNonParenthesisDelimitedMI(NonParenthesisDelimitedMI that) {
        RetType info_result = recur(that.getInfo());
        RetType expr_result = recur(that.getExpr());
        return forNonParenthesisDelimitedMIOnly(that, info_result, expr_result);
    }

    public RetType forExponentiationMI(ExponentiationMI that) {
        RetType info_result = recur(that.getInfo());
        RetType op_result = recur(that.getOp());
        Option<RetType> expr_result = recurOnOptionOfExpr(that.getExpr());
        return forExponentiationMIOnly(that, info_result, op_result, expr_result);
    }

    public RetType forSubscriptingMI(SubscriptingMI that) {
        RetType info_result = recur(that.getInfo());
        RetType op_result = recur(that.getOp());
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return forSubscriptingMIOnly(that, info_result, op_result, exprs_result, staticArgs_result);
    }

    public RetType forOverloading(Overloading that) {
        RetType info_result = recur(that.getInfo());
        RetType unambiguousName_result = recur(that.getUnambiguousName());
        RetType originalName_result = recur(that.getOriginalName());
        Option<RetType> type_result = recurOnOptionOfArrowType(that.getType());
        Option<RetType> schema_result = recurOnOptionOfArrowType(that.getSchema());
        return forOverloadingOnly(that, info_result, unambiguousName_result, originalName_result, type_result, schema_result);
    }

    public RetType forNonterminalHeader(NonterminalHeader that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        List<RetType> params_result = recurOnListOfNonterminalParameter(that.getParams());
        List<RetType> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        Option<RetType> paramType_result = recurOnOptionOfType(that.getParamType());
        Option<RetType> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        return forNonterminalHeaderOnly(that, info_result, name_result, params_result, staticParams_result, paramType_result, whereClause_result);
    }

    public RetType forNonterminalParameter(NonterminalParameter that) {
        RetType info_result = recur(that.getInfo());
        RetType name_result = recur(that.getName());
        RetType paramType_result = recur(that.getParamType());
        return forNonterminalParameterOnly(that, info_result, name_result, paramType_result);
    }

    public RetType forSyntaxDef(SyntaxDef that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> syntaxSymbols_result = recurOnListOfSyntaxSymbol(that.getSyntaxSymbols());
        RetType transformer_result = recur(that.getTransformer());
        return forSyntaxDefOnly(that, info_result, syntaxSymbols_result, transformer_result);
    }

    public RetType forSuperSyntaxDef(SuperSyntaxDef that) {
        RetType info_result = recur(that.getInfo());
        RetType nonterminal_result = recur(that.getNonterminal());
        RetType grammarId_result = recur(that.getGrammarId());
        return forSuperSyntaxDefOnly(that, info_result, nonterminal_result, grammarId_result);
    }

    public RetType forPreTransformerDef(PreTransformerDef that) {
        RetType info_result = recur(that.getInfo());
        RetType transformer_result = recur(that.getTransformer());
        return forPreTransformerDefOnly(that, info_result, transformer_result);
    }

    public RetType forNamedTransformerDef(NamedTransformerDef that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> parameters_result = recurOnListOfNonterminalParameter(that.getParameters());
        RetType transformer_result = recur(that.getTransformer());
        return forNamedTransformerDefOnly(that, info_result, parameters_result, transformer_result);
    }

    public RetType forUnparsedTransformer(UnparsedTransformer that) {
        RetType info_result = recur(that.getInfo());
        RetType nonterminal_result = recur(that.getNonterminal());
        return forUnparsedTransformerOnly(that, info_result, nonterminal_result);
    }

    public RetType forNodeTransformer(NodeTransformer that) {
        RetType info_result = recur(that.getInfo());
        RetType node_result = recur(that.getNode());
        return forNodeTransformerOnly(that, info_result, node_result);
    }

    public RetType forCaseTransformer(CaseTransformer that) {
        RetType info_result = recur(that.getInfo());
        RetType gapName_result = recur(that.getGapName());
        List<RetType> clauses_result = recurOnListOfCaseTransformerClause(that.getClauses());
        return forCaseTransformerOnly(that, info_result, gapName_result, clauses_result);
    }

    public RetType forCaseTransformerClause(CaseTransformerClause that) {
        RetType info_result = recur(that.getInfo());
        RetType constructor_result = recur(that.getConstructor());
        List<RetType> parameters_result = recurOnListOfId(that.getParameters());
        RetType body_result = recur(that.getBody());
        return forCaseTransformerClauseOnly(that, info_result, constructor_result, parameters_result, body_result);
    }

    public RetType forPrefixedSymbol(PrefixedSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType id_result = recur(that.getId());
        RetType symbol_result = recur(that.getSymbol());
        return forPrefixedSymbolOnly(that, info_result, id_result, symbol_result);
    }

    public RetType forOptionalSymbol(OptionalSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType symbol_result = recur(that.getSymbol());
        return forOptionalSymbolOnly(that, info_result, symbol_result);
    }

    public RetType forRepeatSymbol(RepeatSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType symbol_result = recur(that.getSymbol());
        return forRepeatSymbolOnly(that, info_result, symbol_result);
    }

    public RetType forRepeatOneOrMoreSymbol(RepeatOneOrMoreSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType symbol_result = recur(that.getSymbol());
        return forRepeatOneOrMoreSymbolOnly(that, info_result, symbol_result);
    }

    public RetType forNoWhitespaceSymbol(NoWhitespaceSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType symbol_result = recur(that.getSymbol());
        return forNoWhitespaceSymbolOnly(that, info_result, symbol_result);
    }

    public RetType forGroupSymbol(GroupSymbol that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> symbols_result = recurOnListOfSyntaxSymbol(that.getSymbols());
        return forGroupSymbolOnly(that, info_result, symbols_result);
    }

    public RetType forAnyCharacterSymbol(AnyCharacterSymbol that) {
        RetType info_result = recur(that.getInfo());
        return forAnyCharacterSymbolOnly(that, info_result);
    }

    public RetType forWhitespaceSymbol(WhitespaceSymbol that) {
        RetType info_result = recur(that.getInfo());
        return forWhitespaceSymbolOnly(that, info_result);
    }

    public RetType forTabSymbol(TabSymbol that) {
        RetType info_result = recur(that.getInfo());
        return forTabSymbolOnly(that, info_result);
    }

    public RetType forFormfeedSymbol(FormfeedSymbol that) {
        RetType info_result = recur(that.getInfo());
        return forFormfeedSymbolOnly(that, info_result);
    }

    public RetType forCarriageReturnSymbol(CarriageReturnSymbol that) {
        RetType info_result = recur(that.getInfo());
        return forCarriageReturnSymbolOnly(that, info_result);
    }

    public RetType forBackspaceSymbol(BackspaceSymbol that) {
        RetType info_result = recur(that.getInfo());
        return forBackspaceSymbolOnly(that, info_result);
    }

    public RetType forNewlineSymbol(NewlineSymbol that) {
        RetType info_result = recur(that.getInfo());
        return forNewlineSymbolOnly(that, info_result);
    }

    public RetType forBreaklineSymbol(BreaklineSymbol that) {
        RetType info_result = recur(that.getInfo());
        return forBreaklineSymbolOnly(that, info_result);
    }

    public RetType forItemSymbol(ItemSymbol that) {
        RetType info_result = recur(that.getInfo());
        return forItemSymbolOnly(that, info_result);
    }

    public RetType forNonterminalSymbol(NonterminalSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType nonterminal_result = recur(that.getNonterminal());
        return forNonterminalSymbolOnly(that, info_result, nonterminal_result);
    }

    public RetType forKeywordSymbol(KeywordSymbol that) {
        RetType info_result = recur(that.getInfo());
        return forKeywordSymbolOnly(that, info_result);
    }

    public RetType forTokenSymbol(TokenSymbol that) {
        RetType info_result = recur(that.getInfo());
        return forTokenSymbolOnly(that, info_result);
    }

    public RetType forNotPredicateSymbol(NotPredicateSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType symbol_result = recur(that.getSymbol());
        return forNotPredicateSymbolOnly(that, info_result, symbol_result);
    }

    public RetType forAndPredicateSymbol(AndPredicateSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType symbol_result = recur(that.getSymbol());
        return forAndPredicateSymbolOnly(that, info_result, symbol_result);
    }

    public RetType forCharacterClassSymbol(CharacterClassSymbol that) {
        RetType info_result = recur(that.getInfo());
        List<RetType> characters_result = recurOnListOfCharacterSymbol(that.getCharacters());
        return forCharacterClassSymbolOnly(that, info_result, characters_result);
    }

    public RetType forCharSymbol(CharSymbol that) {
        RetType info_result = recur(that.getInfo());
        return forCharSymbolOnly(that, info_result);
    }

    public RetType forCharacterInterval(CharacterInterval that) {
        RetType info_result = recur(that.getInfo());
        return forCharacterIntervalOnly(that, info_result);
    }

    public RetType forLink(Link that) {
        RetType info_result = recur(that.getInfo());
        RetType op_result = recur(that.getOp());
        RetType expr_result = recur(that.getExpr());
        return forLinkOnly(that, info_result, op_result, expr_result);
    }

    public RetType forTraitTypeHeader(TraitTypeHeader that) {
        List<RetType> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        RetType name_result = recur(that.getName());
        Option<RetType> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        Option<List<RetType>> throwsClause_result = recurOnOptionOfListOfType(that.getThrowsClause());
        Option<RetType> contract_result = recurOnOptionOfContract(that.getContract());
        List<RetType> extendsClause_result = recurOnListOfTraitTypeWhere(that.getExtendsClause());
        Option<List<RetType>> params_result = recurOnOptionOfListOfParam(that.getParams());
        List<RetType> decls_result = recurOnListOfDecl(that.getDecls());
        return forTraitTypeHeaderOnly(that, staticParams_result, name_result, whereClause_result, throwsClause_result, contract_result, extendsClause_result, params_result, decls_result);
    }

    public RetType forFnHeader(FnHeader that) {
        List<RetType> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        RetType name_result = recur(that.getName());
        Option<RetType> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        Option<List<RetType>> throwsClause_result = recurOnOptionOfListOfType(that.getThrowsClause());
        Option<RetType> contract_result = recurOnOptionOfContract(that.getContract());
        List<RetType> params_result = recurOnListOfParam(that.getParams());
        Option<RetType> returnType_result = recurOnOptionOfType(that.getReturnType());
        return forFnHeaderOnly(that, staticParams_result, name_result, whereClause_result, throwsClause_result, contract_result, params_result, returnType_result);
    }

    public RetType forSpanInfo(SpanInfo that) {
        return forSpanInfoOnly(that);
    }

    public RetType forExprInfo(ExprInfo that) {
        Option<RetType> exprType_result = recurOnOptionOfType(that.getExprType());
        return forExprInfoOnly(that, exprType_result);
    }

    public RetType forTypeInfo(TypeInfo that) {
        List<RetType> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        Option<RetType> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        return forTypeInfoOnly(that, staticParams_result, whereClause_result);
    }

    public RetType forMethodInfo(MethodInfo that) {
        RetType selfType_result = recur(that.getSelfType());
        return forMethodInfoOnly(that, selfType_result);
    }

    public RetType forCompoundAssignmentInfo(CompoundAssignmentInfo that) {
        RetType opForLhs_result = recur(that.getOpForLhs());
        Option<RetType> compoundCoercionOuter_result = recurOnOptionOfCoercionInvocation(that.getCompoundCoercionOuter());
        Option<RetType> compoundCoercionInner_result = recurOnOptionOfCoercionInvocation(that.getCompoundCoercionInner());
        return forCompoundAssignmentInfoOnly(that, opForLhs_result, compoundCoercionOuter_result, compoundCoercionInner_result);
    }

    public RetType forLevel(Level that) {
        return forLevelOnly(that);
    }

    public RetType forInFixity(InFixity that) {
        return forInFixityOnly(that);
    }

    public RetType forPreFixity(PreFixity that) {
        return forPreFixityOnly(that);
    }

    public RetType forPostFixity(PostFixity that) {
        return forPostFixityOnly(that);
    }

    public RetType forNoFixity(NoFixity that) {
        return forNoFixityOnly(that);
    }

    public RetType forMultiFixity(MultiFixity that) {
        return forMultiFixityOnly(that);
    }

    public RetType forEnclosingFixity(EnclosingFixity that) {
        return forEnclosingFixityOnly(that);
    }

    public RetType forBigFixity(BigFixity that) {
        return forBigFixityOnly(that);
    }

    public RetType forUnknownFixity(UnknownFixity that) {
        return forUnknownFixityOnly(that);
    }

    public RetType forKindType(KindType that) {
        return forKindTypeOnly(that);
    }

    public RetType forKindInt(KindInt that) {
        return forKindIntOnly(that);
    }

    public RetType forKindNat(KindNat that) {
        return forKindNatOnly(that);
    }

    public RetType forKindBool(KindBool that) {
        return forKindBoolOnly(that);
    }

    public RetType forKindDim(KindDim that) {
        return forKindDimOnly(that);
    }

    public RetType forKindUnit(KindUnit that) {
        return forKindUnitOnly(that);
    }

    public RetType forKindOp(KindOp that) {
        return forKindOpOnly(that);
    }

    public RetType for_SyntaxTransformationAbstractNode(_SyntaxTransformationAbstractNode that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAbstractNodeOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationCompilationUnit(_SyntaxTransformationCompilationUnit that) {
        RetType name_result = recur(that.getName());
        List<RetType> imports_result = recurOnListOfImport(that.getImports());
        List<RetType> decls_result = recurOnListOfDecl(that.getDecls());
        List<RetType> comprises_result = recurOnListOfAPIName(that.getComprises());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationCompilationUnitOnly(that, name_result, imports_result, decls_result, comprises_result, info_result);
    }

    public RetType for_SyntaxTransformationComponent(_SyntaxTransformationComponent that) {
        RetType name_result = recur(that.getName());
        List<RetType> imports_result = recurOnListOfImport(that.getImports());
        List<RetType> decls_result = recurOnListOfDecl(that.getDecls());
        List<RetType> comprises_result = recurOnListOfAPIName(that.getComprises());
        List<RetType> exports_result = recurOnListOfAPIName(that.getExports());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationComponentOnly(that, name_result, imports_result, decls_result, comprises_result, exports_result, info_result);
    }

    public RetType for_SyntaxTransformationApi(_SyntaxTransformationApi that) {
        RetType name_result = recur(that.getName());
        List<RetType> imports_result = recurOnListOfImport(that.getImports());
        List<RetType> decls_result = recurOnListOfDecl(that.getDecls());
        List<RetType> comprises_result = recurOnListOfAPIName(that.getComprises());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationApiOnly(that, name_result, imports_result, decls_result, comprises_result, info_result);
    }

    public RetType for_SyntaxTransformationImport(_SyntaxTransformationImport that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationImportOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationImportedNames(_SyntaxTransformationImportedNames that) {
        RetType apiName_result = recur(that.getApiName());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationImportedNamesOnly(that, apiName_result, info_result);
    }

    public RetType for_SyntaxTransformationImportStar(_SyntaxTransformationImportStar that) {
        RetType apiName_result = recur(that.getApiName());
        List<RetType> exceptNames_result = recurOnListOfIdOrOpOrAnonymousName(that.getExceptNames());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationImportStarOnly(that, apiName_result, exceptNames_result, info_result);
    }

    public RetType for_SyntaxTransformationImportNames(_SyntaxTransformationImportNames that) {
        RetType apiName_result = recur(that.getApiName());
        List<RetType> aliasedNames_result = recurOnListOfAliasedSimpleName(that.getAliasedNames());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationImportNamesOnly(that, apiName_result, aliasedNames_result, info_result);
    }

    public RetType for_SyntaxTransformationImportApi(_SyntaxTransformationImportApi that) {
        List<RetType> apis_result = recurOnListOfAliasedAPIName(that.getApis());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationImportApiOnly(that, apis_result, info_result);
    }

    public RetType for_SyntaxTransformationAliasedSimpleName(_SyntaxTransformationAliasedSimpleName that) {
        RetType name_result = recur(that.getName());
        Option<RetType> alias_result = recurOnOptionOfIdOrOpOrAnonymousName(that.getAlias());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAliasedSimpleNameOnly(that, name_result, alias_result, info_result);
    }

    public RetType for_SyntaxTransformationAliasedAPIName(_SyntaxTransformationAliasedAPIName that) {
        RetType apiName_result = recur(that.getApiName());
        Option<RetType> alias_result = recurOnOptionOfId(that.getAlias());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAliasedAPINameOnly(that, apiName_result, alias_result, info_result);
    }

    public RetType for_SyntaxTransformationDecl(_SyntaxTransformationDecl that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationDeclOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationTraitObjectDecl(_SyntaxTransformationTraitObjectDecl that) {
        RetType header_result = recur(that.getHeader());
        Option<RetType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTraitObjectDeclOnly(that, header_result, selfType_result, info_result);
    }

    public RetType for_SyntaxTransformationTraitDecl(_SyntaxTransformationTraitDecl that) {
        RetType header_result = recur(that.getHeader());
        Option<RetType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        List<RetType> excludesClause_result = recurOnListOfBaseType(that.getExcludesClause());
        Option<List<RetType>> comprisesClause_result = recurOnOptionOfListOfNamedType(that.getComprisesClause());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTraitDeclOnly(that, header_result, selfType_result, excludesClause_result, comprisesClause_result, info_result);
    }

    public RetType for_SyntaxTransformationObjectDecl(_SyntaxTransformationObjectDecl that) {
        RetType header_result = recur(that.getHeader());
        Option<RetType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationObjectDeclOnly(that, header_result, selfType_result, info_result);
    }

    public RetType for_SyntaxTransformationVarDecl(_SyntaxTransformationVarDecl that) {
        List<RetType> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<RetType> init_result = recurOnOptionOfExpr(that.getInit());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationVarDeclOnly(that, lhs_result, init_result, info_result);
    }

    public RetType for_SyntaxTransformationFnDecl(_SyntaxTransformationFnDecl that) {
        RetType header_result = recur(that.getHeader());
        RetType unambiguousName_result = recur(that.getUnambiguousName());
        Option<RetType> body_result = recurOnOptionOfExpr(that.getBody());
        Option<RetType> implementsUnambiguousName_result = recurOnOptionOfIdOrOp(that.getImplementsUnambiguousName());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationFnDeclOnly(that, header_result, unambiguousName_result, body_result, implementsUnambiguousName_result, info_result);
    }

    public RetType for_SyntaxTransformation_RewriteFnOverloadDecl(_SyntaxTransformation_RewriteFnOverloadDecl that) {
        RetType name_result = recur(that.getName());
        List<RetType> fns_result = recurOnListOfIdOrOp(that.getFns());
        Option<RetType> type_result = recurOnOptionOfType(that.getType());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformation_RewriteFnOverloadDeclOnly(that, name_result, fns_result, type_result, info_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprDecl(_SyntaxTransformation_RewriteObjectExprDecl that) {
        List<RetType> objectExprs_result = recurOnListOf_RewriteObjectExpr(that.getObjectExprs());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformation_RewriteObjectExprDeclOnly(that, objectExprs_result, info_result);
    }

    public RetType for_SyntaxTransformation_RewriteFunctionalMethodDecl(_SyntaxTransformation_RewriteFunctionalMethodDecl that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformation_RewriteFunctionalMethodDeclOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationDimUnitDecl(_SyntaxTransformationDimUnitDecl that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationDimUnitDeclOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationDimDecl(_SyntaxTransformationDimDecl that) {
        RetType dimId_result = recur(that.getDimId());
        Option<RetType> derived_result = recurOnOptionOfType(that.getDerived());
        Option<RetType> defaultId_result = recurOnOptionOfId(that.getDefaultId());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationDimDeclOnly(that, dimId_result, derived_result, defaultId_result, info_result);
    }

    public RetType for_SyntaxTransformationUnitDecl(_SyntaxTransformationUnitDecl that) {
        List<RetType> units_result = recurOnListOfId(that.getUnits());
        Option<RetType> dimType_result = recurOnOptionOfType(that.getDimType());
        Option<RetType> defExpr_result = recurOnOptionOfExpr(that.getDefExpr());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationUnitDeclOnly(that, units_result, dimType_result, defExpr_result, info_result);
    }

    public RetType for_SyntaxTransformationTestDecl(_SyntaxTransformationTestDecl that) {
        RetType name_result = recur(that.getName());
        List<RetType> gens_result = recurOnListOfGeneratorClause(that.getGens());
        RetType expr_result = recur(that.getExpr());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTestDeclOnly(that, name_result, gens_result, expr_result, info_result);
    }

    public RetType for_SyntaxTransformationPropertyDecl(_SyntaxTransformationPropertyDecl that) {
        Option<RetType> name_result = recurOnOptionOfId(that.getName());
        List<RetType> params_result = recurOnListOfParam(that.getParams());
        RetType expr_result = recur(that.getExpr());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationPropertyDeclOnly(that, name_result, params_result, expr_result, info_result);
    }

    public RetType for_SyntaxTransformationTypeAlias(_SyntaxTransformationTypeAlias that) {
        RetType name_result = recur(that.getName());
        List<RetType> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        RetType typeDef_result = recur(that.getTypeDef());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTypeAliasOnly(that, name_result, staticParams_result, typeDef_result, info_result);
    }

    public RetType for_SyntaxTransformationGrammarDecl(_SyntaxTransformationGrammarDecl that) {
        RetType name_result = recur(that.getName());
        List<RetType> extendsClause_result = recurOnListOfId(that.getExtendsClause());
        List<RetType> members_result = recurOnListOfGrammarMemberDecl(that.getMembers());
        List<RetType> transformers_result = recurOnListOfTransformerDecl(that.getTransformers());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationGrammarDeclOnly(that, name_result, extendsClause_result, members_result, transformers_result, info_result);
    }

    public RetType for_SyntaxTransformationGrammarMemberDecl(_SyntaxTransformationGrammarMemberDecl that) {
        RetType name_result = recur(that.getName());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationGrammarMemberDeclOnly(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformationNonterminalDecl(_SyntaxTransformationNonterminalDecl that) {
        RetType name_result = recur(that.getName());
        List<RetType> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNonterminalDeclOnly(that, name_result, syntaxDecls_result, info_result);
    }

    public RetType for_SyntaxTransformationNonterminalDef(_SyntaxTransformationNonterminalDef that) {
        RetType name_result = recur(that.getName());
        List<RetType> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        RetType header_result = recur(that.getHeader());
        Option<RetType> astType_result = recurOnOptionOfBaseType(that.getAstType());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNonterminalDefOnly(that, name_result, syntaxDecls_result, header_result, astType_result, info_result);
    }

    public RetType for_SyntaxTransformationNonterminalExtensionDef(_SyntaxTransformationNonterminalExtensionDef that) {
        RetType name_result = recur(that.getName());
        List<RetType> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNonterminalExtensionDefOnly(that, name_result, syntaxDecls_result, info_result);
    }

    public RetType for_SyntaxTransformationBinding(_SyntaxTransformationBinding that) {
        RetType name_result = recur(that.getName());
        Option<RetType> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBindingOnly(that, name_result, idType_result, info_result);
    }

    public RetType for_SyntaxTransformationLValue(_SyntaxTransformationLValue that) {
        RetType name_result = recur(that.getName());
        Option<RetType> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationLValueOnly(that, name_result, idType_result, info_result);
    }

    public RetType for_SyntaxTransformationParam(_SyntaxTransformationParam that) {
        RetType name_result = recur(that.getName());
        Option<RetType> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        Option<RetType> defaultExpr_result = recurOnOptionOfExpr(that.getDefaultExpr());
        Option<RetType> varargsType_result = recurOnOptionOfType(that.getVarargsType());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationParamOnly(that, name_result, idType_result, defaultExpr_result, varargsType_result, info_result);
    }

    public RetType for_SyntaxTransformationExpr(_SyntaxTransformationExpr that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationDummyExpr(_SyntaxTransformationDummyExpr that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationDummyExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationTypeAnnotatedExpr(_SyntaxTransformationTypeAnnotatedExpr that) {
        RetType expr_result = recur(that.getExpr());
        RetType annType_result = recur(that.getAnnType());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTypeAnnotatedExprOnly(that, expr_result, annType_result, info_result);
    }

    public RetType for_SyntaxTransformationAsExpr(_SyntaxTransformationAsExpr that) {
        RetType expr_result = recur(that.getExpr());
        RetType annType_result = recur(that.getAnnType());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAsExprOnly(that, expr_result, annType_result, info_result);
    }

    public RetType for_SyntaxTransformationAsIfExpr(_SyntaxTransformationAsIfExpr that) {
        RetType expr_result = recur(that.getExpr());
        RetType annType_result = recur(that.getAnnType());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAsIfExprOnly(that, expr_result, annType_result, info_result);
    }

    public RetType for_SyntaxTransformationAssignment(_SyntaxTransformationAssignment that) {
        List<RetType> lhs_result = recurOnListOfLhs(that.getLhs());
        Option<RetType> assignOp_result = recurOnOptionOfFunctionalRef(that.getAssignOp());
        RetType rhs_result = recur(that.getRhs());
        List<RetType> assignmentInfos_result = recurOnListOfCompoundAssignmentInfo(that.getAssignmentInfos());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAssignmentOnly(that, lhs_result, assignOp_result, rhs_result, assignmentInfos_result, info_result);
    }

    public RetType for_SyntaxTransformationBlock(_SyntaxTransformationBlock that) {
        Option<RetType> loc_result = recurOnOptionOfExpr(that.getLoc());
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBlockOnly(that, loc_result, exprs_result, info_result);
    }

    public RetType for_SyntaxTransformationDo(_SyntaxTransformationDo that) {
        List<RetType> fronts_result = recurOnListOfBlock(that.getFronts());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationDoOnly(that, fronts_result, info_result);
    }

    public RetType for_SyntaxTransformationCaseExpr(_SyntaxTransformationCaseExpr that) {
        Option<RetType> param_result = recurOnOptionOfExpr(that.getParam());
        Option<RetType> compare_result = recurOnOptionOfFunctionalRef(that.getCompare());
        RetType equalsOp_result = recur(that.getEqualsOp());
        RetType inOp_result = recur(that.getInOp());
        List<RetType> clauses_result = recurOnListOfCaseClause(that.getClauses());
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationCaseExprOnly(that, param_result, compare_result, equalsOp_result, inOp_result, clauses_result, elseClause_result, info_result);
    }

    public RetType for_SyntaxTransformationIf(_SyntaxTransformationIf that) {
        List<RetType> clauses_result = recurOnListOfIfClause(that.getClauses());
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationIfOnly(that, clauses_result, elseClause_result, info_result);
    }

    public RetType for_SyntaxTransformationLabel(_SyntaxTransformationLabel that) {
        RetType name_result = recur(that.getName());
        RetType body_result = recur(that.getBody());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationLabelOnly(that, name_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationAbstractObjectExpr(_SyntaxTransformationAbstractObjectExpr that) {
        RetType header_result = recur(that.getHeader());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAbstractObjectExprOnly(that, header_result, info_result);
    }

    public RetType for_SyntaxTransformationObjectExpr(_SyntaxTransformationObjectExpr that) {
        RetType header_result = recur(that.getHeader());
        Option<RetType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationObjectExprOnly(that, header_result, selfType_result, info_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExpr(_SyntaxTransformation_RewriteObjectExpr that) {
        RetType header_result = recur(that.getHeader());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformation_RewriteObjectExprOnly(that, header_result, staticArgs_result, info_result);
    }

    public RetType for_SyntaxTransformationTry(_SyntaxTransformationTry that) {
        RetType body_result = recur(that.getBody());
        Option<RetType> catchClause_result = recurOnOptionOfCatch(that.getCatchClause());
        List<RetType> forbidClause_result = recurOnListOfBaseType(that.getForbidClause());
        Option<RetType> finallyClause_result = recurOnOptionOfBlock(that.getFinallyClause());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTryOnly(that, body_result, catchClause_result, forbidClause_result, finallyClause_result, info_result);
    }

    public RetType for_SyntaxTransformationTupleExpr(_SyntaxTransformationTupleExpr that) {
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        Option<RetType> varargs_result = recurOnOptionOfExpr(that.getVarargs());
        List<RetType> keywords_result = recurOnListOfKeywordExpr(that.getKeywords());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTupleExprOnly(that, exprs_result, varargs_result, keywords_result, info_result);
    }

    public RetType for_SyntaxTransformationTypecase(_SyntaxTransformationTypecase that) {
        RetType bindExpr_result = recur(that.getBindExpr());
        List<RetType> clauses_result = recurOnListOfTypecaseClause(that.getClauses());
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTypecaseOnly(that, bindExpr_result, clauses_result, elseClause_result, info_result);
    }

    public RetType for_SyntaxTransformationWhile(_SyntaxTransformationWhile that) {
        RetType testExpr_result = recur(that.getTestExpr());
        RetType body_result = recur(that.getBody());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationWhileOnly(that, testExpr_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationFor(_SyntaxTransformationFor that) {
        List<RetType> gens_result = recurOnListOfGeneratorClause(that.getGens());
        RetType body_result = recur(that.getBody());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationForOnly(that, gens_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationBigOpApp(_SyntaxTransformationBigOpApp that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBigOpAppOnly(that, staticArgs_result, info_result);
    }

    public RetType for_SyntaxTransformationAccumulator(_SyntaxTransformationAccumulator that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType accOp_result = recur(that.getAccOp());
        List<RetType> gens_result = recurOnListOfGeneratorClause(that.getGens());
        RetType body_result = recur(that.getBody());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAccumulatorOnly(that, staticArgs_result, accOp_result, gens_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationArrayComprehension(_SyntaxTransformationArrayComprehension that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<RetType> clauses_result = recurOnListOfArrayComprehensionClause(that.getClauses());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationArrayComprehensionOnly(that, staticArgs_result, clauses_result, info_result);
    }

    public RetType for_SyntaxTransformationAtomicExpr(_SyntaxTransformationAtomicExpr that) {
        RetType expr_result = recur(that.getExpr());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAtomicExprOnly(that, expr_result, info_result);
    }

    public RetType for_SyntaxTransformationExit(_SyntaxTransformationExit that) {
        Option<RetType> target_result = recurOnOptionOfId(that.getTarget());
        Option<RetType> returnExpr_result = recurOnOptionOfExpr(that.getReturnExpr());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationExitOnly(that, target_result, returnExpr_result, info_result);
    }

    public RetType for_SyntaxTransformationSpawn(_SyntaxTransformationSpawn that) {
        RetType body_result = recur(that.getBody());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationSpawnOnly(that, body_result, info_result);
    }

    public RetType for_SyntaxTransformationThrow(_SyntaxTransformationThrow that) {
        RetType expr_result = recur(that.getExpr());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationThrowOnly(that, expr_result, info_result);
    }

    public RetType for_SyntaxTransformationTryAtomicExpr(_SyntaxTransformationTryAtomicExpr that) {
        RetType expr_result = recur(that.getExpr());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTryAtomicExprOnly(that, expr_result, info_result);
    }

    public RetType for_SyntaxTransformationFnExpr(_SyntaxTransformationFnExpr that) {
        RetType header_result = recur(that.getHeader());
        RetType body_result = recur(that.getBody());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationFnExprOnly(that, header_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationLetExpr(_SyntaxTransformationLetExpr that) {
        RetType body_result = recur(that.getBody());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationLetExprOnly(that, body_result, info_result);
    }

    public RetType for_SyntaxTransformationLetFn(_SyntaxTransformationLetFn that) {
        RetType body_result = recur(that.getBody());
        List<RetType> fns_result = recurOnListOfFnDecl(that.getFns());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationLetFnOnly(that, body_result, fns_result, info_result);
    }

    public RetType for_SyntaxTransformationLocalVarDecl(_SyntaxTransformationLocalVarDecl that) {
        RetType body_result = recur(that.getBody());
        List<RetType> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<RetType> rhs_result = recurOnOptionOfExpr(that.getRhs());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationLocalVarDeclOnly(that, body_result, lhs_result, rhs_result, info_result);
    }

    public RetType for_SyntaxTransformationSimpleExpr(_SyntaxTransformationSimpleExpr that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationSimpleExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationSubscriptExpr(_SyntaxTransformationSubscriptExpr that) {
        RetType obj_result = recur(that.getObj());
        List<RetType> subs_result = recurOnListOfExpr(that.getSubs());
        Option<RetType> op_result = recurOnOptionOfOp(that.getOp());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationSubscriptExprOnly(that, obj_result, subs_result, op_result, staticArgs_result, info_result);
    }

    public RetType for_SyntaxTransformationPrimary(_SyntaxTransformationPrimary that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationPrimaryOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationLiteralExpr(_SyntaxTransformationLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationLiteralExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationNumberLiteralExpr(_SyntaxTransformationNumberLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNumberLiteralExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationFloatLiteralExpr(_SyntaxTransformationFloatLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationFloatLiteralExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationIntLiteralExpr(_SyntaxTransformationIntLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationIntLiteralExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationCharLiteralExpr(_SyntaxTransformationCharLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationCharLiteralExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationStringLiteralExpr(_SyntaxTransformationStringLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationStringLiteralExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationVoidLiteralExpr(_SyntaxTransformationVoidLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationVoidLiteralExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationBooleanLiteralExpr(_SyntaxTransformationBooleanLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBooleanLiteralExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationVarRef(_SyntaxTransformationVarRef that) {
        RetType varId_result = recur(that.getVarId());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationVarRefOnly(that, varId_result, staticArgs_result, info_result);
    }

    public RetType for_SyntaxTransformationFieldRef(_SyntaxTransformationFieldRef that) {
        RetType obj_result = recur(that.getObj());
        RetType field_result = recur(that.getField());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationFieldRefOnly(that, obj_result, field_result, info_result);
    }

    public RetType for_SyntaxTransformationFunctionalRef(_SyntaxTransformationFunctionalRef that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType originalName_result = recur(that.getOriginalName());
        List<RetType> names_result = recurOnListOfIdOrOp(that.getNames());
        List<RetType> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<RetType> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<RetType> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<RetType> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationFunctionalRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result, info_result);
    }

    public RetType for_SyntaxTransformationFnRef(_SyntaxTransformationFnRef that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType originalName_result = recur(that.getOriginalName());
        List<RetType> names_result = recurOnListOfIdOrOp(that.getNames());
        List<RetType> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<RetType> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<RetType> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<RetType> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationFnRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result, info_result);
    }

    public RetType for_SyntaxTransformationOpRef(_SyntaxTransformationOpRef that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType originalName_result = recur(that.getOriginalName());
        List<RetType> names_result = recurOnListOfIdOrOp(that.getNames());
        List<RetType> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<RetType> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<RetType> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<RetType> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationOpRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result, info_result);
    }

    public RetType for_SyntaxTransformation_RewriteFnRef(_SyntaxTransformation_RewriteFnRef that) {
        RetType fnExpr_result = recur(that.getFnExpr());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformation_RewriteFnRefOnly(that, fnExpr_result, staticArgs_result, info_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprRef(_SyntaxTransformation_RewriteObjectExprRef that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformation_RewriteObjectExprRefOnly(that, staticArgs_result, info_result);
    }

    public RetType for_SyntaxTransformationJuxt(_SyntaxTransformationJuxt that) {
        RetType multiJuxt_result = recur(that.getMultiJuxt());
        RetType infixJuxt_result = recur(that.getInfixJuxt());
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationJuxtOnly(that, multiJuxt_result, infixJuxt_result, exprs_result, info_result);
    }

    public RetType for_SyntaxTransformation_RewriteFnApp(_SyntaxTransformation_RewriteFnApp that) {
        RetType function_result = recur(that.getFunction());
        RetType argument_result = recur(that.getArgument());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformation_RewriteFnAppOnly(that, function_result, argument_result, info_result);
    }

    public RetType for_SyntaxTransformationOpExpr(_SyntaxTransformationOpExpr that) {
        RetType op_result = recur(that.getOp());
        List<RetType> args_result = recurOnListOfExpr(that.getArgs());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationOpExprOnly(that, op_result, args_result, info_result);
    }

    public RetType for_SyntaxTransformationAmbiguousMultifixOpExpr(_SyntaxTransformationAmbiguousMultifixOpExpr that) {
        RetType infix_op_result = recur(that.getInfix_op());
        RetType multifix_op_result = recur(that.getMultifix_op());
        List<RetType> args_result = recurOnListOfExpr(that.getArgs());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAmbiguousMultifixOpExprOnly(that, infix_op_result, multifix_op_result, args_result, info_result);
    }

    public RetType for_SyntaxTransformationChainExpr(_SyntaxTransformationChainExpr that) {
        RetType first_result = recur(that.getFirst());
        List<RetType> links_result = recurOnListOfLink(that.getLinks());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationChainExprOnly(that, first_result, links_result, info_result);
    }

    public RetType for_SyntaxTransformationCoercionInvocation(_SyntaxTransformationCoercionInvocation that) {
        RetType toType_result = recur(that.getToType());
        RetType arg_result = recur(that.getArg());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationCoercionInvocationOnly(that, toType_result, arg_result, info_result);
    }

    public RetType for_SyntaxTransformationTraitCoercionInvocation(_SyntaxTransformationTraitCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        RetType toType_result = recur(that.getToType());
        RetType coercionFn_result = recur(that.getCoercionFn());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTraitCoercionInvocationOnly(that, arg_result, toType_result, coercionFn_result, info_result);
    }

    public RetType for_SyntaxTransformationTupleCoercionInvocation(_SyntaxTransformationTupleCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        RetType toType_result = recur(that.getToType());
        List<Option<RetType>> subCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getSubCoercions());
        Option<Option<RetType>> varargCoercion_result = recurOnOptionOfOptionOfCoercionInvocation(that.getVarargCoercion());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTupleCoercionInvocationOnly(that, arg_result, toType_result, subCoercions_result, varargCoercion_result, info_result);
    }

    public RetType for_SyntaxTransformationArrowCoercionInvocation(_SyntaxTransformationArrowCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        RetType toType_result = recur(that.getToType());
        Option<RetType> domainCoercion_result = recurOnOptionOfCoercionInvocation(that.getDomainCoercion());
        Option<RetType> rangeCoercion_result = recurOnOptionOfCoercionInvocation(that.getRangeCoercion());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationArrowCoercionInvocationOnly(that, arg_result, toType_result, domainCoercion_result, rangeCoercion_result, info_result);
    }

    public RetType for_SyntaxTransformationUnionCoercionInvocation(_SyntaxTransformationUnionCoercionInvocation that) {
        RetType toType_result = recur(that.getToType());
        RetType arg_result = recur(that.getArg());
        List<RetType> fromTypes_result = recurOnListOfType(that.getFromTypes());
        List<Option<RetType>> fromCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getFromCoercions());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationUnionCoercionInvocationOnly(that, toType_result, arg_result, fromTypes_result, fromCoercions_result, info_result);
    }

    public RetType for_SyntaxTransformationMethodInvocation(_SyntaxTransformationMethodInvocation that) {
        RetType obj_result = recur(that.getObj());
        RetType method_result = recur(that.getMethod());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType arg_result = recur(that.getArg());
        Option<RetType> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<RetType> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationMethodInvocationOnly(that, obj_result, method_result, staticArgs_result, arg_result, overloadingType_result, overloadingSchema_result, info_result);
    }

    public RetType for_SyntaxTransformationMathPrimary(_SyntaxTransformationMathPrimary that) {
        RetType multiJuxt_result = recur(that.getMultiJuxt());
        RetType infixJuxt_result = recur(that.getInfixJuxt());
        RetType front_result = recur(that.getFront());
        List<RetType> rest_result = recurOnListOfMathItem(that.getRest());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationMathPrimaryOnly(that, multiJuxt_result, infixJuxt_result, front_result, rest_result, info_result);
    }

    public RetType for_SyntaxTransformationArrayExpr(_SyntaxTransformationArrayExpr that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationArrayExprOnly(that, staticArgs_result, info_result);
    }

    public RetType for_SyntaxTransformationArrayElement(_SyntaxTransformationArrayElement that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType element_result = recur(that.getElement());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationArrayElementOnly(that, staticArgs_result, element_result, info_result);
    }

    public RetType for_SyntaxTransformationArrayElements(_SyntaxTransformationArrayElements that) {
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<RetType> elements_result = recurOnListOfArrayExpr(that.getElements());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationArrayElementsOnly(that, staticArgs_result, elements_result, info_result);
    }

    public RetType for_SyntaxTransformationType(_SyntaxTransformationType that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTypeOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationBaseType(_SyntaxTransformationBaseType that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBaseTypeOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationAnyType(_SyntaxTransformationAnyType that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAnyTypeOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationBottomType(_SyntaxTransformationBottomType that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBottomTypeOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationUnknownType(_SyntaxTransformationUnknownType that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationUnknownTypeOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationSelfType(_SyntaxTransformationSelfType that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationSelfTypeOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationTraitSelfType(_SyntaxTransformationTraitSelfType that) {
        RetType named_result = recur(that.getNamed());
        List<RetType> comprised_result = recurOnListOfNamedType(that.getComprised());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTraitSelfTypeOnly(that, named_result, comprised_result, info_result);
    }

    public RetType for_SyntaxTransformationObjectExprType(_SyntaxTransformationObjectExprType that) {
        List<RetType> extended_result = recurOnListOfBaseType(that.getExtended());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationObjectExprTypeOnly(that, extended_result, info_result);
    }

    public RetType for_SyntaxTransformationNamedType(_SyntaxTransformationNamedType that) {
        RetType name_result = recur(that.getName());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNamedTypeOnly(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that) {
        RetType name_result = recur(that.getName());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformation_InferenceVarTypeOnly(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformationVarType(_SyntaxTransformationVarType that) {
        RetType name_result = recur(that.getName());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationVarTypeOnly(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that) {
        RetType name_result = recur(that.getName());
        List<RetType> args_result = recurOnListOfStaticArg(that.getArgs());
        List<RetType> traitStaticParams_result = recurOnListOfStaticParam(that.getTraitStaticParams());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTraitTypeOnly(that, name_result, args_result, traitStaticParams_result, info_result);
    }

    public RetType for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that) {
        RetType elemType_result = recur(that.getElemType());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAbbreviatedTypeOnly(that, elemType_result, info_result);
    }

    public RetType for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that) {
        RetType elemType_result = recur(that.getElemType());
        RetType indices_result = recur(that.getIndices());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationArrayTypeOnly(that, elemType_result, indices_result, info_result);
    }

    public RetType for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that) {
        RetType elemType_result = recur(that.getElemType());
        List<RetType> dimensions_result = recurOnListOfExtentRange(that.getDimensions());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationMatrixTypeOnly(that, elemType_result, dimensions_result, info_result);
    }

    public RetType for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that) {
        RetType elemType_result = recur(that.getElemType());
        RetType dimExpr_result = recur(that.getDimExpr());
        Option<RetType> unitExpr_result = recurOnOptionOfExpr(that.getUnitExpr());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTaggedDimTypeOnly(that, elemType_result, dimExpr_result, unitExpr_result, info_result);
    }

    public RetType for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that) {
        RetType elemType_result = recur(that.getElemType());
        RetType unitExpr_result = recur(that.getUnitExpr());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTaggedUnitTypeOnly(that, elemType_result, unitExpr_result, info_result);
    }

    public RetType for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that) {
        List<RetType> elements_result = recurOnListOfType(that.getElements());
        Option<RetType> varargs_result = recurOnOptionOfType(that.getVarargs());
        List<RetType> keywords_result = recurOnListOfKeywordType(that.getKeywords());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTupleTypeOnly(that, elements_result, varargs_result, keywords_result, info_result);
    }

    public RetType for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that) {
        RetType domain_result = recur(that.getDomain());
        RetType range_result = recur(that.getRange());
        RetType effect_result = recur(that.getEffect());
        Option<RetType> methodInfo_result = recurOnOptionOfMethodInfo(that.getMethodInfo());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationArrowTypeOnly(that, domain_result, range_result, effect_result, methodInfo_result, info_result);
    }

    public RetType for_SyntaxTransformationBoundType(_SyntaxTransformationBoundType that) {
        List<RetType> elements_result = recurOnListOfType(that.getElements());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBoundTypeOnly(that, elements_result, info_result);
    }

    public RetType for_SyntaxTransformationIntersectionType(_SyntaxTransformationIntersectionType that) {
        List<RetType> elements_result = recurOnListOfType(that.getElements());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationIntersectionTypeOnly(that, elements_result, info_result);
    }

    public RetType for_SyntaxTransformationUnionType(_SyntaxTransformationUnionType that) {
        List<RetType> elements_result = recurOnListOfType(that.getElements());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationUnionTypeOnly(that, elements_result, info_result);
    }

    public RetType for_SyntaxTransformationFixedPointType(_SyntaxTransformationFixedPointType that) {
        RetType name_result = recur(that.getName());
        RetType body_result = recur(that.getBody());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationFixedPointTypeOnly(that, name_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationLabelType(_SyntaxTransformationLabelType that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationLabelTypeOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationDimExpr(_SyntaxTransformationDimExpr that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationDimExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationDimBase(_SyntaxTransformationDimBase that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationDimBaseOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationDimRef(_SyntaxTransformationDimRef that) {
        RetType name_result = recur(that.getName());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationDimRefOnly(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that) {
        RetType base_result = recur(that.getBase());
        RetType power_result = recur(that.getPower());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationDimExponentOnly(that, base_result, power_result, info_result);
    }

    public RetType for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that) {
        RetType dimVal_result = recur(that.getDimVal());
        RetType op_result = recur(that.getOp());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationDimUnaryOpOnly(that, dimVal_result, op_result, info_result);
    }

    public RetType for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationDimBinaryOpOnly(that, left_result, right_result, op_result, info_result);
    }

    public RetType for_SyntaxTransformationPattern(_SyntaxTransformationPattern that) {
        Option<RetType> name_result = recurOnOptionOfType(that.getName());
        RetType patterns_result = recur(that.getPatterns());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationPatternOnly(that, name_result, patterns_result, info_result);
    }

    public RetType for_SyntaxTransformationPatternArgs(_SyntaxTransformationPatternArgs that) {
        List<RetType> patterns_result = recurOnListOfPatternBinding(that.getPatterns());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationPatternArgsOnly(that, patterns_result, info_result);
    }

    public RetType for_SyntaxTransformationPatternBinding(_SyntaxTransformationPatternBinding that) {
        Option<RetType> field_result = recurOnOptionOfId(that.getField());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationPatternBindingOnly(that, field_result, info_result);
    }

    public RetType for_SyntaxTransformationPlainPattern(_SyntaxTransformationPlainPattern that) {
        Option<RetType> field_result = recurOnOptionOfId(that.getField());
        RetType name_result = recur(that.getName());
        Option<RetType> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationPlainPatternOnly(that, field_result, name_result, idType_result, info_result);
    }

    public RetType for_SyntaxTransformationTypePattern(_SyntaxTransformationTypePattern that) {
        Option<RetType> field_result = recurOnOptionOfId(that.getField());
        RetType typ_result = recur(that.getTyp());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTypePatternOnly(that, field_result, typ_result, info_result);
    }

    public RetType for_SyntaxTransformationNestedPattern(_SyntaxTransformationNestedPattern that) {
        Option<RetType> field_result = recurOnOptionOfId(that.getField());
        RetType pat_result = recur(that.getPat());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNestedPatternOnly(that, field_result, pat_result, info_result);
    }

    public RetType for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationStaticArgOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that) {
        RetType typeArg_result = recur(that.getTypeArg());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTypeArgOnly(that, typeArg_result, info_result);
    }

    public RetType for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that) {
        RetType intVal_result = recur(that.getIntVal());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationIntArgOnly(that, intVal_result, info_result);
    }

    public RetType for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that) {
        RetType boolArg_result = recur(that.getBoolArg());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBoolArgOnly(that, boolArg_result, info_result);
    }

    public RetType for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that) {
        RetType id_result = recur(that.getId());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationOpArgOnly(that, id_result, info_result);
    }

    public RetType for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that) {
        RetType dimArg_result = recur(that.getDimArg());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationDimArgOnly(that, dimArg_result, info_result);
    }

    public RetType for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that) {
        RetType unitArg_result = recur(that.getUnitArg());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationUnitArgOnly(that, unitArg_result, info_result);
    }

    public RetType for_SyntaxTransformationStaticExpr(_SyntaxTransformationStaticExpr that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationStaticExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationIntExpr(_SyntaxTransformationIntExpr that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationIntExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationIntBase(_SyntaxTransformationIntBase that) {
        RetType intVal_result = recur(that.getIntVal());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationIntBaseOnly(that, intVal_result, info_result);
    }

    public RetType for_SyntaxTransformationIntRef(_SyntaxTransformationIntRef that) {
        RetType name_result = recur(that.getName());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationIntRefOnly(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformationIntBinaryOp(_SyntaxTransformationIntBinaryOp that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationIntBinaryOpOnly(that, left_result, right_result, op_result, info_result);
    }

    public RetType for_SyntaxTransformationBoolExpr(_SyntaxTransformationBoolExpr that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBoolExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationBoolBase(_SyntaxTransformationBoolBase that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBoolBaseOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationBoolRef(_SyntaxTransformationBoolRef that) {
        RetType name_result = recur(that.getName());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBoolRefOnly(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformationBoolConstraint(_SyntaxTransformationBoolConstraint that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBoolConstraintOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationBoolUnaryOp(_SyntaxTransformationBoolUnaryOp that) {
        RetType boolVal_result = recur(that.getBoolVal());
        RetType op_result = recur(that.getOp());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBoolUnaryOpOnly(that, boolVal_result, op_result, info_result);
    }

    public RetType for_SyntaxTransformationBoolBinaryOp(_SyntaxTransformationBoolBinaryOp that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBoolBinaryOpOnly(that, left_result, right_result, op_result, info_result);
    }

    public RetType for_SyntaxTransformationUnitExpr(_SyntaxTransformationUnitExpr that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationUnitExprOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationUnitRef(_SyntaxTransformationUnitRef that) {
        RetType name_result = recur(that.getName());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationUnitRefOnly(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformationUnitBinaryOp(_SyntaxTransformationUnitBinaryOp that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationUnitBinaryOpOnly(that, left_result, right_result, op_result, info_result);
    }

    public RetType for_SyntaxTransformationEffect(_SyntaxTransformationEffect that) {
        Option<List<RetType>> throwsClause_result = recurOnOptionOfListOfType(that.getThrowsClause());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationEffectOnly(that, throwsClause_result, info_result);
    }

    public RetType for_SyntaxTransformationWhereClause(_SyntaxTransformationWhereClause that) {
        List<RetType> bindings_result = recurOnListOfWhereBinding(that.getBindings());
        List<RetType> constraints_result = recurOnListOfWhereConstraint(that.getConstraints());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationWhereClauseOnly(that, bindings_result, constraints_result, info_result);
    }

    public RetType for_SyntaxTransformationWhereBinding(_SyntaxTransformationWhereBinding that) {
        RetType name_result = recur(that.getName());
        List<RetType> supers_result = recurOnListOfBaseType(that.getSupers());
        RetType kind_result = recur(that.getKind());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationWhereBindingOnly(that, name_result, supers_result, kind_result, info_result);
    }

    public RetType for_SyntaxTransformationWhereConstraint(_SyntaxTransformationWhereConstraint that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationWhereConstraintOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationWhereExtends(_SyntaxTransformationWhereExtends that) {
        RetType name_result = recur(that.getName());
        List<RetType> supers_result = recurOnListOfBaseType(that.getSupers());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationWhereExtendsOnly(that, name_result, supers_result, info_result);
    }

    public RetType for_SyntaxTransformationWhereTypeAlias(_SyntaxTransformationWhereTypeAlias that) {
        RetType alias_result = recur(that.getAlias());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationWhereTypeAliasOnly(that, alias_result, info_result);
    }

    public RetType for_SyntaxTransformationWhereCoerces(_SyntaxTransformationWhereCoerces that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationWhereCoercesOnly(that, left_result, right_result, info_result);
    }

    public RetType for_SyntaxTransformationWhereEquals(_SyntaxTransformationWhereEquals that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationWhereEqualsOnly(that, left_result, right_result, info_result);
    }

    public RetType for_SyntaxTransformationUnitConstraint(_SyntaxTransformationUnitConstraint that) {
        RetType name_result = recur(that.getName());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationUnitConstraintOnly(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformationIntConstraint(_SyntaxTransformationIntConstraint that) {
        RetType left_result = recur(that.getLeft());
        RetType right_result = recur(that.getRight());
        RetType op_result = recur(that.getOp());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationIntConstraintOnly(that, left_result, right_result, op_result, info_result);
    }

    public RetType for_SyntaxTransformationBoolConstraintExpr(_SyntaxTransformationBoolConstraintExpr that) {
        RetType constraint_result = recur(that.getConstraint());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBoolConstraintExprOnly(that, constraint_result, info_result);
    }

    public RetType for_SyntaxTransformationContract(_SyntaxTransformationContract that) {
        Option<List<RetType>> requiresClause_result = recurOnOptionOfListOfExpr(that.getRequiresClause());
        Option<List<RetType>> ensuresClause_result = recurOnOptionOfListOfEnsuresClause(that.getEnsuresClause());
        Option<List<RetType>> invariantsClause_result = recurOnOptionOfListOfExpr(that.getInvariantsClause());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationContractOnly(that, requiresClause_result, ensuresClause_result, invariantsClause_result, info_result);
    }

    public RetType for_SyntaxTransformationEnsuresClause(_SyntaxTransformationEnsuresClause that) {
        RetType post_result = recur(that.getPost());
        Option<RetType> pre_result = recurOnOptionOfExpr(that.getPre());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationEnsuresClauseOnly(that, post_result, pre_result, info_result);
    }

    public RetType for_SyntaxTransformationStaticParam(_SyntaxTransformationStaticParam that) {
        RetType name_result = recur(that.getName());
        List<RetType> extendsClause_result = recurOnListOfBaseType(that.getExtendsClause());
        List<RetType> dominatesClause_result = recurOnListOfBaseType(that.getDominatesClause());
        Option<RetType> dimParam_result = recurOnOptionOfType(that.getDimParam());
        RetType kind_result = recur(that.getKind());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationStaticParamOnly(that, name_result, extendsClause_result, dominatesClause_result, dimParam_result, kind_result, info_result);
    }

    public RetType for_SyntaxTransformationName(_SyntaxTransformationName that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNameOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationAPIName(_SyntaxTransformationAPIName that) {
        List<RetType> ids_result = recurOnListOfId(that.getIds());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAPINameOnly(that, ids_result, info_result);
    }

    public RetType for_SyntaxTransformationIdOrOpOrAnonymousName(_SyntaxTransformationIdOrOpOrAnonymousName that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationIdOrOpOrAnonymousNameOnly(that, apiName_result, info_result);
    }

    public RetType for_SyntaxTransformationIdOrOp(_SyntaxTransformationIdOrOp that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationIdOrOpOnly(that, apiName_result, info_result);
    }

    public RetType for_SyntaxTransformationId(_SyntaxTransformationId that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationIdOnly(that, apiName_result, info_result);
    }

    public RetType for_SyntaxTransformationOp(_SyntaxTransformationOp that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        RetType fixity_result = recur(that.getFixity());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationOpOnly(that, apiName_result, fixity_result, info_result);
    }

    public RetType for_SyntaxTransformationNamedOp(_SyntaxTransformationNamedOp that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        RetType fixity_result = recur(that.getFixity());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNamedOpOnly(that, apiName_result, fixity_result, info_result);
    }

    public RetType for_SyntaxTransformation_InferenceVarOp(_SyntaxTransformation_InferenceVarOp that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        RetType fixity_result = recur(that.getFixity());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformation_InferenceVarOpOnly(that, apiName_result, fixity_result, info_result);
    }

    public RetType for_SyntaxTransformationAnonymousName(_SyntaxTransformationAnonymousName that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAnonymousNameOnly(that, apiName_result, info_result);
    }

    public RetType for_SyntaxTransformationAnonymousFnName(_SyntaxTransformationAnonymousFnName that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAnonymousFnNameOnly(that, apiName_result, info_result);
    }

    public RetType for_SyntaxTransformationConstructorFnName(_SyntaxTransformationConstructorFnName that) {
        Option<RetType> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        RetType constructor_result = recur(that.getConstructor());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationConstructorFnNameOnly(that, apiName_result, constructor_result, info_result);
    }

    public RetType for_SyntaxTransformationArrayComprehensionClause(_SyntaxTransformationArrayComprehensionClause that) {
        List<RetType> bind_result = recurOnListOfExpr(that.getBind());
        RetType init_result = recur(that.getInit());
        List<RetType> gens_result = recurOnListOfGeneratorClause(that.getGens());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationArrayComprehensionClauseOnly(that, bind_result, init_result, gens_result, info_result);
    }

    public RetType for_SyntaxTransformationKeywordExpr(_SyntaxTransformationKeywordExpr that) {
        RetType name_result = recur(that.getName());
        RetType init_result = recur(that.getInit());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationKeywordExprOnly(that, name_result, init_result, info_result);
    }

    public RetType for_SyntaxTransformationCaseClause(_SyntaxTransformationCaseClause that) {
        RetType matchClause_result = recur(that.getMatchClause());
        RetType body_result = recur(that.getBody());
        Option<RetType> op_result = recurOnOptionOfFunctionalRef(that.getOp());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationCaseClauseOnly(that, matchClause_result, body_result, op_result, info_result);
    }

    public RetType for_SyntaxTransformationCatch(_SyntaxTransformationCatch that) {
        RetType name_result = recur(that.getName());
        List<RetType> clauses_result = recurOnListOfCatchClause(that.getClauses());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationCatchOnly(that, name_result, clauses_result, info_result);
    }

    public RetType for_SyntaxTransformationCatchClause(_SyntaxTransformationCatchClause that) {
        RetType matchType_result = recur(that.getMatchType());
        RetType body_result = recur(that.getBody());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationCatchClauseOnly(that, matchType_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationIfClause(_SyntaxTransformationIfClause that) {
        RetType testClause_result = recur(that.getTestClause());
        RetType body_result = recur(that.getBody());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationIfClauseOnly(that, testClause_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationTypecaseClause(_SyntaxTransformationTypecaseClause that) {
        Option<RetType> name_result = recurOnOptionOfId(that.getName());
        RetType matchType_result = recur(that.getMatchType());
        RetType body_result = recur(that.getBody());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTypecaseClauseOnly(that, name_result, matchType_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationExtentRange(_SyntaxTransformationExtentRange that) {
        Option<RetType> base_result = recurOnOptionOfStaticArg(that.getBase());
        Option<RetType> size_result = recurOnOptionOfStaticArg(that.getSize());
        Option<RetType> op_result = recurOnOptionOfOp(that.getOp());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationExtentRangeOnly(that, base_result, size_result, op_result, info_result);
    }

    public RetType for_SyntaxTransformationGeneratorClause(_SyntaxTransformationGeneratorClause that) {
        List<RetType> bind_result = recurOnListOfId(that.getBind());
        RetType init_result = recur(that.getInit());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationGeneratorClauseOnly(that, bind_result, init_result, info_result);
    }

    public RetType for_SyntaxTransformationKeywordType(_SyntaxTransformationKeywordType that) {
        RetType name_result = recur(that.getName());
        RetType keywordType_result = recur(that.getKeywordType());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationKeywordTypeOnly(that, name_result, keywordType_result, info_result);
    }

    public RetType for_SyntaxTransformationTraitTypeWhere(_SyntaxTransformationTraitTypeWhere that) {
        RetType baseType_result = recur(that.getBaseType());
        Option<RetType> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTraitTypeWhereOnly(that, baseType_result, whereClause_result, info_result);
    }

    public RetType for_SyntaxTransformationIndices(_SyntaxTransformationIndices that) {
        List<RetType> extents_result = recurOnListOfExtentRange(that.getExtents());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationIndicesOnly(that, extents_result, info_result);
    }

    public RetType for_SyntaxTransformationMathItem(_SyntaxTransformationMathItem that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationMathItemOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationExprMI(_SyntaxTransformationExprMI that) {
        RetType expr_result = recur(that.getExpr());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationExprMIOnly(that, expr_result, info_result);
    }

    public RetType for_SyntaxTransformationParenthesisDelimitedMI(_SyntaxTransformationParenthesisDelimitedMI that) {
        RetType expr_result = recur(that.getExpr());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationParenthesisDelimitedMIOnly(that, expr_result, info_result);
    }

    public RetType for_SyntaxTransformationNonParenthesisDelimitedMI(_SyntaxTransformationNonParenthesisDelimitedMI that) {
        RetType expr_result = recur(that.getExpr());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNonParenthesisDelimitedMIOnly(that, expr_result, info_result);
    }

    public RetType for_SyntaxTransformationNonExprMI(_SyntaxTransformationNonExprMI that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNonExprMIOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationExponentiationMI(_SyntaxTransformationExponentiationMI that) {
        RetType op_result = recur(that.getOp());
        Option<RetType> expr_result = recurOnOptionOfExpr(that.getExpr());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationExponentiationMIOnly(that, op_result, expr_result, info_result);
    }

    public RetType for_SyntaxTransformationSubscriptingMI(_SyntaxTransformationSubscriptingMI that) {
        RetType op_result = recur(that.getOp());
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        List<RetType> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationSubscriptingMIOnly(that, op_result, exprs_result, staticArgs_result, info_result);
    }

    public RetType for_SyntaxTransformationOverloading(_SyntaxTransformationOverloading that) {
        RetType unambiguousName_result = recur(that.getUnambiguousName());
        RetType originalName_result = recur(that.getOriginalName());
        Option<RetType> type_result = recurOnOptionOfArrowType(that.getType());
        Option<RetType> schema_result = recurOnOptionOfArrowType(that.getSchema());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationOverloadingOnly(that, unambiguousName_result, originalName_result, type_result, schema_result, info_result);
    }

    public RetType for_SyntaxTransformationNonterminalHeader(_SyntaxTransformationNonterminalHeader that) {
        RetType name_result = recur(that.getName());
        List<RetType> params_result = recurOnListOfNonterminalParameter(that.getParams());
        List<RetType> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        Option<RetType> paramType_result = recurOnOptionOfType(that.getParamType());
        Option<RetType> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNonterminalHeaderOnly(that, name_result, params_result, staticParams_result, paramType_result, whereClause_result, info_result);
    }

    public RetType for_SyntaxTransformationNonterminalParameter(_SyntaxTransformationNonterminalParameter that) {
        RetType name_result = recur(that.getName());
        RetType paramType_result = recur(that.getParamType());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNonterminalParameterOnly(that, name_result, paramType_result, info_result);
    }

    public RetType for_SyntaxTransformationSyntaxDecl(_SyntaxTransformationSyntaxDecl that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationSyntaxDeclOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationSyntaxDef(_SyntaxTransformationSyntaxDef that) {
        List<RetType> syntaxSymbols_result = recurOnListOfSyntaxSymbol(that.getSyntaxSymbols());
        RetType transformer_result = recur(that.getTransformer());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationSyntaxDefOnly(that, syntaxSymbols_result, transformer_result, info_result);
    }

    public RetType for_SyntaxTransformationSuperSyntaxDef(_SyntaxTransformationSuperSyntaxDef that) {
        RetType nonterminal_result = recur(that.getNonterminal());
        RetType grammarId_result = recur(that.getGrammarId());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationSuperSyntaxDefOnly(that, nonterminal_result, grammarId_result, info_result);
    }

    public RetType for_SyntaxTransformationTransformerDecl(_SyntaxTransformationTransformerDecl that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTransformerDeclOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationPreTransformerDef(_SyntaxTransformationPreTransformerDef that) {
        RetType transformer_result = recur(that.getTransformer());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationPreTransformerDefOnly(that, transformer_result, info_result);
    }

    public RetType for_SyntaxTransformationNamedTransformerDef(_SyntaxTransformationNamedTransformerDef that) {
        List<RetType> parameters_result = recurOnListOfNonterminalParameter(that.getParameters());
        RetType transformer_result = recur(that.getTransformer());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNamedTransformerDefOnly(that, parameters_result, transformer_result, info_result);
    }

    public RetType for_SyntaxTransformationTransformer(_SyntaxTransformationTransformer that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTransformerOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationUnparsedTransformer(_SyntaxTransformationUnparsedTransformer that) {
        RetType nonterminal_result = recur(that.getNonterminal());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationUnparsedTransformerOnly(that, nonterminal_result, info_result);
    }

    public RetType for_SyntaxTransformationNodeTransformer(_SyntaxTransformationNodeTransformer that) {
        RetType node_result = recur(that.getNode());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNodeTransformerOnly(that, node_result, info_result);
    }

    public RetType for_SyntaxTransformationCaseTransformer(_SyntaxTransformationCaseTransformer that) {
        RetType gapName_result = recur(that.getGapName());
        List<RetType> clauses_result = recurOnListOfCaseTransformerClause(that.getClauses());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationCaseTransformerOnly(that, gapName_result, clauses_result, info_result);
    }

    public RetType for_SyntaxTransformationCaseTransformerClause(_SyntaxTransformationCaseTransformerClause that) {
        RetType constructor_result = recur(that.getConstructor());
        List<RetType> parameters_result = recurOnListOfId(that.getParameters());
        RetType body_result = recur(that.getBody());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationCaseTransformerClauseOnly(that, constructor_result, parameters_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationSyntaxSymbol(_SyntaxTransformationSyntaxSymbol that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationSyntaxSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationPrefixedSymbol(_SyntaxTransformationPrefixedSymbol that) {
        RetType id_result = recur(that.getId());
        RetType symbol_result = recur(that.getSymbol());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationPrefixedSymbolOnly(that, id_result, symbol_result, info_result);
    }

    public RetType for_SyntaxTransformationOptionalSymbol(_SyntaxTransformationOptionalSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationOptionalSymbolOnly(that, symbol_result, info_result);
    }

    public RetType for_SyntaxTransformationRepeatSymbol(_SyntaxTransformationRepeatSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationRepeatSymbolOnly(that, symbol_result, info_result);
    }

    public RetType for_SyntaxTransformationRepeatOneOrMoreSymbol(_SyntaxTransformationRepeatOneOrMoreSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationRepeatOneOrMoreSymbolOnly(that, symbol_result, info_result);
    }

    public RetType for_SyntaxTransformationNoWhitespaceSymbol(_SyntaxTransformationNoWhitespaceSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNoWhitespaceSymbolOnly(that, symbol_result, info_result);
    }

    public RetType for_SyntaxTransformationGroupSymbol(_SyntaxTransformationGroupSymbol that) {
        List<RetType> symbols_result = recurOnListOfSyntaxSymbol(that.getSymbols());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationGroupSymbolOnly(that, symbols_result, info_result);
    }

    public RetType for_SyntaxTransformationSpecialSymbol(_SyntaxTransformationSpecialSymbol that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationSpecialSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationAnyCharacterSymbol(_SyntaxTransformationAnyCharacterSymbol that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAnyCharacterSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationWhitespaceSymbol(_SyntaxTransformationWhitespaceSymbol that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationWhitespaceSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationTabSymbol(_SyntaxTransformationTabSymbol that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTabSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationFormfeedSymbol(_SyntaxTransformationFormfeedSymbol that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationFormfeedSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationCarriageReturnSymbol(_SyntaxTransformationCarriageReturnSymbol that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationCarriageReturnSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationBackspaceSymbol(_SyntaxTransformationBackspaceSymbol that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBackspaceSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationNewlineSymbol(_SyntaxTransformationNewlineSymbol that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNewlineSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationBreaklineSymbol(_SyntaxTransformationBreaklineSymbol that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationBreaklineSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationItemSymbol(_SyntaxTransformationItemSymbol that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationItemSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationNonterminalSymbol(_SyntaxTransformationNonterminalSymbol that) {
        RetType nonterminal_result = recur(that.getNonterminal());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNonterminalSymbolOnly(that, nonterminal_result, info_result);
    }

    public RetType for_SyntaxTransformationKeywordSymbol(_SyntaxTransformationKeywordSymbol that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationKeywordSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationTokenSymbol(_SyntaxTransformationTokenSymbol that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationTokenSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationNotPredicateSymbol(_SyntaxTransformationNotPredicateSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationNotPredicateSymbolOnly(that, symbol_result, info_result);
    }

    public RetType for_SyntaxTransformationAndPredicateSymbol(_SyntaxTransformationAndPredicateSymbol that) {
        RetType symbol_result = recur(that.getSymbol());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationAndPredicateSymbolOnly(that, symbol_result, info_result);
    }

    public RetType for_SyntaxTransformationCharacterClassSymbol(_SyntaxTransformationCharacterClassSymbol that) {
        List<RetType> characters_result = recurOnListOfCharacterSymbol(that.getCharacters());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationCharacterClassSymbolOnly(that, characters_result, info_result);
    }

    public RetType for_SyntaxTransformationCharacterSymbol(_SyntaxTransformationCharacterSymbol that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationCharacterSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationCharSymbol(_SyntaxTransformationCharSymbol that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationCharSymbolOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationCharacterInterval(_SyntaxTransformationCharacterInterval that) {
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationCharacterIntervalOnly(that, info_result);
    }

    public RetType for_SyntaxTransformationLink(_SyntaxTransformationLink that) {
        RetType op_result = recur(that.getOp());
        RetType expr_result = recur(that.getExpr());
        RetType info_result = recur(that.getInfo());
        return for_SyntaxTransformationLinkOnly(that, op_result, expr_result, info_result);
    }

    public RetType for_EllipsesAbstractNode(_EllipsesAbstractNode that) {
        return for_EllipsesAbstractNodeOnly(that);
    }

    public RetType for_EllipsesCompilationUnit(_EllipsesCompilationUnit that) {
        return for_EllipsesCompilationUnitOnly(that);
    }

    public RetType for_EllipsesComponent(_EllipsesComponent that) {
        return for_EllipsesComponentOnly(that);
    }

    public RetType for_EllipsesApi(_EllipsesApi that) {
        return for_EllipsesApiOnly(that);
    }

    public RetType for_EllipsesImport(_EllipsesImport that) {
        return for_EllipsesImportOnly(that);
    }

    public RetType for_EllipsesImportedNames(_EllipsesImportedNames that) {
        return for_EllipsesImportedNamesOnly(that);
    }

    public RetType for_EllipsesImportStar(_EllipsesImportStar that) {
        return for_EllipsesImportStarOnly(that);
    }

    public RetType for_EllipsesImportNames(_EllipsesImportNames that) {
        return for_EllipsesImportNamesOnly(that);
    }

    public RetType for_EllipsesImportApi(_EllipsesImportApi that) {
        return for_EllipsesImportApiOnly(that);
    }

    public RetType for_EllipsesAliasedSimpleName(_EllipsesAliasedSimpleName that) {
        return for_EllipsesAliasedSimpleNameOnly(that);
    }

    public RetType for_EllipsesAliasedAPIName(_EllipsesAliasedAPIName that) {
        return for_EllipsesAliasedAPINameOnly(that);
    }

    public RetType for_EllipsesDecl(_EllipsesDecl that) {
        return for_EllipsesDeclOnly(that);
    }

    public RetType for_EllipsesTraitObjectDecl(_EllipsesTraitObjectDecl that) {
        return for_EllipsesTraitObjectDeclOnly(that);
    }

    public RetType for_EllipsesTraitDecl(_EllipsesTraitDecl that) {
        return for_EllipsesTraitDeclOnly(that);
    }

    public RetType for_EllipsesObjectDecl(_EllipsesObjectDecl that) {
        return for_EllipsesObjectDeclOnly(that);
    }

    public RetType for_EllipsesVarDecl(_EllipsesVarDecl that) {
        return for_EllipsesVarDeclOnly(that);
    }

    public RetType for_EllipsesFnDecl(_EllipsesFnDecl that) {
        return for_EllipsesFnDeclOnly(that);
    }

    public RetType for_Ellipses_RewriteFnOverloadDecl(_Ellipses_RewriteFnOverloadDecl that) {
        return for_Ellipses_RewriteFnOverloadDeclOnly(that);
    }

    public RetType for_Ellipses_RewriteObjectExprDecl(_Ellipses_RewriteObjectExprDecl that) {
        return for_Ellipses_RewriteObjectExprDeclOnly(that);
    }

    public RetType for_Ellipses_RewriteFunctionalMethodDecl(_Ellipses_RewriteFunctionalMethodDecl that) {
        return for_Ellipses_RewriteFunctionalMethodDeclOnly(that);
    }

    public RetType for_EllipsesDimUnitDecl(_EllipsesDimUnitDecl that) {
        return for_EllipsesDimUnitDeclOnly(that);
    }

    public RetType for_EllipsesDimDecl(_EllipsesDimDecl that) {
        return for_EllipsesDimDeclOnly(that);
    }

    public RetType for_EllipsesUnitDecl(_EllipsesUnitDecl that) {
        return for_EllipsesUnitDeclOnly(that);
    }

    public RetType for_EllipsesTestDecl(_EllipsesTestDecl that) {
        return for_EllipsesTestDeclOnly(that);
    }

    public RetType for_EllipsesPropertyDecl(_EllipsesPropertyDecl that) {
        return for_EllipsesPropertyDeclOnly(that);
    }

    public RetType for_EllipsesTypeAlias(_EllipsesTypeAlias that) {
        return for_EllipsesTypeAliasOnly(that);
    }

    public RetType for_EllipsesGrammarDecl(_EllipsesGrammarDecl that) {
        return for_EllipsesGrammarDeclOnly(that);
    }

    public RetType for_EllipsesGrammarMemberDecl(_EllipsesGrammarMemberDecl that) {
        return for_EllipsesGrammarMemberDeclOnly(that);
    }

    public RetType for_EllipsesNonterminalDecl(_EllipsesNonterminalDecl that) {
        return for_EllipsesNonterminalDeclOnly(that);
    }

    public RetType for_EllipsesNonterminalDef(_EllipsesNonterminalDef that) {
        return for_EllipsesNonterminalDefOnly(that);
    }

    public RetType for_EllipsesNonterminalExtensionDef(_EllipsesNonterminalExtensionDef that) {
        return for_EllipsesNonterminalExtensionDefOnly(that);
    }

    public RetType for_EllipsesBinding(_EllipsesBinding that) {
        return for_EllipsesBindingOnly(that);
    }

    public RetType for_EllipsesLValue(_EllipsesLValue that) {
        return for_EllipsesLValueOnly(that);
    }

    public RetType for_EllipsesParam(_EllipsesParam that) {
        return for_EllipsesParamOnly(that);
    }

    public RetType for_EllipsesExpr(_EllipsesExpr that) {
        return for_EllipsesExprOnly(that);
    }

    public RetType for_EllipsesDummyExpr(_EllipsesDummyExpr that) {
        return for_EllipsesDummyExprOnly(that);
    }

    public RetType for_EllipsesTypeAnnotatedExpr(_EllipsesTypeAnnotatedExpr that) {
        return for_EllipsesTypeAnnotatedExprOnly(that);
    }

    public RetType for_EllipsesAsExpr(_EllipsesAsExpr that) {
        return for_EllipsesAsExprOnly(that);
    }

    public RetType for_EllipsesAsIfExpr(_EllipsesAsIfExpr that) {
        return for_EllipsesAsIfExprOnly(that);
    }

    public RetType for_EllipsesAssignment(_EllipsesAssignment that) {
        return for_EllipsesAssignmentOnly(that);
    }

    public RetType for_EllipsesBlock(_EllipsesBlock that) {
        return for_EllipsesBlockOnly(that);
    }

    public RetType for_EllipsesDo(_EllipsesDo that) {
        return for_EllipsesDoOnly(that);
    }

    public RetType for_EllipsesCaseExpr(_EllipsesCaseExpr that) {
        return for_EllipsesCaseExprOnly(that);
    }

    public RetType for_EllipsesIf(_EllipsesIf that) {
        return for_EllipsesIfOnly(that);
    }

    public RetType for_EllipsesLabel(_EllipsesLabel that) {
        return for_EllipsesLabelOnly(that);
    }

    public RetType for_EllipsesAbstractObjectExpr(_EllipsesAbstractObjectExpr that) {
        return for_EllipsesAbstractObjectExprOnly(that);
    }

    public RetType for_EllipsesObjectExpr(_EllipsesObjectExpr that) {
        return for_EllipsesObjectExprOnly(that);
    }

    public RetType for_Ellipses_RewriteObjectExpr(_Ellipses_RewriteObjectExpr that) {
        return for_Ellipses_RewriteObjectExprOnly(that);
    }

    public RetType for_EllipsesTry(_EllipsesTry that) {
        return for_EllipsesTryOnly(that);
    }

    public RetType for_EllipsesTupleExpr(_EllipsesTupleExpr that) {
        return for_EllipsesTupleExprOnly(that);
    }

    public RetType for_EllipsesTypecase(_EllipsesTypecase that) {
        return for_EllipsesTypecaseOnly(that);
    }

    public RetType for_EllipsesWhile(_EllipsesWhile that) {
        return for_EllipsesWhileOnly(that);
    }

    public RetType for_EllipsesFor(_EllipsesFor that) {
        return for_EllipsesForOnly(that);
    }

    public RetType for_EllipsesBigOpApp(_EllipsesBigOpApp that) {
        return for_EllipsesBigOpAppOnly(that);
    }

    public RetType for_EllipsesAccumulator(_EllipsesAccumulator that) {
        return for_EllipsesAccumulatorOnly(that);
    }

    public RetType for_EllipsesArrayComprehension(_EllipsesArrayComprehension that) {
        return for_EllipsesArrayComprehensionOnly(that);
    }

    public RetType for_EllipsesAtomicExpr(_EllipsesAtomicExpr that) {
        return for_EllipsesAtomicExprOnly(that);
    }

    public RetType for_EllipsesExit(_EllipsesExit that) {
        return for_EllipsesExitOnly(that);
    }

    public RetType for_EllipsesSpawn(_EllipsesSpawn that) {
        return for_EllipsesSpawnOnly(that);
    }

    public RetType for_EllipsesThrow(_EllipsesThrow that) {
        return for_EllipsesThrowOnly(that);
    }

    public RetType for_EllipsesTryAtomicExpr(_EllipsesTryAtomicExpr that) {
        return for_EllipsesTryAtomicExprOnly(that);
    }

    public RetType for_EllipsesFnExpr(_EllipsesFnExpr that) {
        return for_EllipsesFnExprOnly(that);
    }

    public RetType for_EllipsesLetExpr(_EllipsesLetExpr that) {
        return for_EllipsesLetExprOnly(that);
    }

    public RetType for_EllipsesLetFn(_EllipsesLetFn that) {
        return for_EllipsesLetFnOnly(that);
    }

    public RetType for_EllipsesLocalVarDecl(_EllipsesLocalVarDecl that) {
        return for_EllipsesLocalVarDeclOnly(that);
    }

    public RetType for_EllipsesSimpleExpr(_EllipsesSimpleExpr that) {
        return for_EllipsesSimpleExprOnly(that);
    }

    public RetType for_EllipsesSubscriptExpr(_EllipsesSubscriptExpr that) {
        return for_EllipsesSubscriptExprOnly(that);
    }

    public RetType for_EllipsesPrimary(_EllipsesPrimary that) {
        return for_EllipsesPrimaryOnly(that);
    }

    public RetType for_EllipsesLiteralExpr(_EllipsesLiteralExpr that) {
        return for_EllipsesLiteralExprOnly(that);
    }

    public RetType for_EllipsesNumberLiteralExpr(_EllipsesNumberLiteralExpr that) {
        return for_EllipsesNumberLiteralExprOnly(that);
    }

    public RetType for_EllipsesFloatLiteralExpr(_EllipsesFloatLiteralExpr that) {
        return for_EllipsesFloatLiteralExprOnly(that);
    }

    public RetType for_EllipsesIntLiteralExpr(_EllipsesIntLiteralExpr that) {
        return for_EllipsesIntLiteralExprOnly(that);
    }

    public RetType for_EllipsesCharLiteralExpr(_EllipsesCharLiteralExpr that) {
        return for_EllipsesCharLiteralExprOnly(that);
    }

    public RetType for_EllipsesStringLiteralExpr(_EllipsesStringLiteralExpr that) {
        return for_EllipsesStringLiteralExprOnly(that);
    }

    public RetType for_EllipsesVoidLiteralExpr(_EllipsesVoidLiteralExpr that) {
        return for_EllipsesVoidLiteralExprOnly(that);
    }

    public RetType for_EllipsesBooleanLiteralExpr(_EllipsesBooleanLiteralExpr that) {
        return for_EllipsesBooleanLiteralExprOnly(that);
    }

    public RetType for_EllipsesVarRef(_EllipsesVarRef that) {
        return for_EllipsesVarRefOnly(that);
    }

    public RetType for_EllipsesFieldRef(_EllipsesFieldRef that) {
        return for_EllipsesFieldRefOnly(that);
    }

    public RetType for_EllipsesFunctionalRef(_EllipsesFunctionalRef that) {
        return for_EllipsesFunctionalRefOnly(that);
    }

    public RetType for_EllipsesFnRef(_EllipsesFnRef that) {
        return for_EllipsesFnRefOnly(that);
    }

    public RetType for_EllipsesOpRef(_EllipsesOpRef that) {
        return for_EllipsesOpRefOnly(that);
    }

    public RetType for_Ellipses_RewriteFnRef(_Ellipses_RewriteFnRef that) {
        return for_Ellipses_RewriteFnRefOnly(that);
    }

    public RetType for_Ellipses_RewriteObjectExprRef(_Ellipses_RewriteObjectExprRef that) {
        return for_Ellipses_RewriteObjectExprRefOnly(that);
    }

    public RetType for_EllipsesJuxt(_EllipsesJuxt that) {
        return for_EllipsesJuxtOnly(that);
    }

    public RetType for_Ellipses_RewriteFnApp(_Ellipses_RewriteFnApp that) {
        return for_Ellipses_RewriteFnAppOnly(that);
    }

    public RetType for_EllipsesOpExpr(_EllipsesOpExpr that) {
        return for_EllipsesOpExprOnly(that);
    }

    public RetType for_EllipsesAmbiguousMultifixOpExpr(_EllipsesAmbiguousMultifixOpExpr that) {
        return for_EllipsesAmbiguousMultifixOpExprOnly(that);
    }

    public RetType for_EllipsesChainExpr(_EllipsesChainExpr that) {
        return for_EllipsesChainExprOnly(that);
    }

    public RetType for_EllipsesCoercionInvocation(_EllipsesCoercionInvocation that) {
        return for_EllipsesCoercionInvocationOnly(that);
    }

    public RetType for_EllipsesTraitCoercionInvocation(_EllipsesTraitCoercionInvocation that) {
        return for_EllipsesTraitCoercionInvocationOnly(that);
    }

    public RetType for_EllipsesTupleCoercionInvocation(_EllipsesTupleCoercionInvocation that) {
        return for_EllipsesTupleCoercionInvocationOnly(that);
    }

    public RetType for_EllipsesArrowCoercionInvocation(_EllipsesArrowCoercionInvocation that) {
        return for_EllipsesArrowCoercionInvocationOnly(that);
    }

    public RetType for_EllipsesUnionCoercionInvocation(_EllipsesUnionCoercionInvocation that) {
        return for_EllipsesUnionCoercionInvocationOnly(that);
    }

    public RetType for_EllipsesMethodInvocation(_EllipsesMethodInvocation that) {
        return for_EllipsesMethodInvocationOnly(that);
    }

    public RetType for_EllipsesMathPrimary(_EllipsesMathPrimary that) {
        return for_EllipsesMathPrimaryOnly(that);
    }

    public RetType for_EllipsesArrayExpr(_EllipsesArrayExpr that) {
        return for_EllipsesArrayExprOnly(that);
    }

    public RetType for_EllipsesArrayElement(_EllipsesArrayElement that) {
        return for_EllipsesArrayElementOnly(that);
    }

    public RetType for_EllipsesArrayElements(_EllipsesArrayElements that) {
        return for_EllipsesArrayElementsOnly(that);
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

    public RetType for_EllipsesPattern(_EllipsesPattern that) {
        return for_EllipsesPatternOnly(that);
    }

    public RetType for_EllipsesPatternArgs(_EllipsesPatternArgs that) {
        return for_EllipsesPatternArgsOnly(that);
    }

    public RetType for_EllipsesPatternBinding(_EllipsesPatternBinding that) {
        return for_EllipsesPatternBindingOnly(that);
    }

    public RetType for_EllipsesPlainPattern(_EllipsesPlainPattern that) {
        return for_EllipsesPlainPatternOnly(that);
    }

    public RetType for_EllipsesTypePattern(_EllipsesTypePattern that) {
        return for_EllipsesTypePatternOnly(that);
    }

    public RetType for_EllipsesNestedPattern(_EllipsesNestedPattern that) {
        return for_EllipsesNestedPatternOnly(that);
    }

    public RetType for_EllipsesStaticArg(_EllipsesStaticArg that) {
        return for_EllipsesStaticArgOnly(that);
    }

    public RetType for_EllipsesTypeArg(_EllipsesTypeArg that) {
        return for_EllipsesTypeArgOnly(that);
    }

    public RetType for_EllipsesIntArg(_EllipsesIntArg that) {
        return for_EllipsesIntArgOnly(that);
    }

    public RetType for_EllipsesBoolArg(_EllipsesBoolArg that) {
        return for_EllipsesBoolArgOnly(that);
    }

    public RetType for_EllipsesOpArg(_EllipsesOpArg that) {
        return for_EllipsesOpArgOnly(that);
    }

    public RetType for_EllipsesDimArg(_EllipsesDimArg that) {
        return for_EllipsesDimArgOnly(that);
    }

    public RetType for_EllipsesUnitArg(_EllipsesUnitArg that) {
        return for_EllipsesUnitArgOnly(that);
    }

    public RetType for_EllipsesStaticExpr(_EllipsesStaticExpr that) {
        return for_EllipsesStaticExprOnly(that);
    }

    public RetType for_EllipsesIntExpr(_EllipsesIntExpr that) {
        return for_EllipsesIntExprOnly(that);
    }

    public RetType for_EllipsesIntBase(_EllipsesIntBase that) {
        return for_EllipsesIntBaseOnly(that);
    }

    public RetType for_EllipsesIntRef(_EllipsesIntRef that) {
        return for_EllipsesIntRefOnly(that);
    }

    public RetType for_EllipsesIntBinaryOp(_EllipsesIntBinaryOp that) {
        return for_EllipsesIntBinaryOpOnly(that);
    }

    public RetType for_EllipsesBoolExpr(_EllipsesBoolExpr that) {
        return for_EllipsesBoolExprOnly(that);
    }

    public RetType for_EllipsesBoolBase(_EllipsesBoolBase that) {
        return for_EllipsesBoolBaseOnly(that);
    }

    public RetType for_EllipsesBoolRef(_EllipsesBoolRef that) {
        return for_EllipsesBoolRefOnly(that);
    }

    public RetType for_EllipsesBoolConstraint(_EllipsesBoolConstraint that) {
        return for_EllipsesBoolConstraintOnly(that);
    }

    public RetType for_EllipsesBoolUnaryOp(_EllipsesBoolUnaryOp that) {
        return for_EllipsesBoolUnaryOpOnly(that);
    }

    public RetType for_EllipsesBoolBinaryOp(_EllipsesBoolBinaryOp that) {
        return for_EllipsesBoolBinaryOpOnly(that);
    }

    public RetType for_EllipsesUnitExpr(_EllipsesUnitExpr that) {
        return for_EllipsesUnitExprOnly(that);
    }

    public RetType for_EllipsesUnitRef(_EllipsesUnitRef that) {
        return for_EllipsesUnitRefOnly(that);
    }

    public RetType for_EllipsesUnitBinaryOp(_EllipsesUnitBinaryOp that) {
        return for_EllipsesUnitBinaryOpOnly(that);
    }

    public RetType for_EllipsesEffect(_EllipsesEffect that) {
        return for_EllipsesEffectOnly(that);
    }

    public RetType for_EllipsesWhereClause(_EllipsesWhereClause that) {
        return for_EllipsesWhereClauseOnly(that);
    }

    public RetType for_EllipsesWhereBinding(_EllipsesWhereBinding that) {
        return for_EllipsesWhereBindingOnly(that);
    }

    public RetType for_EllipsesWhereConstraint(_EllipsesWhereConstraint that) {
        return for_EllipsesWhereConstraintOnly(that);
    }

    public RetType for_EllipsesWhereExtends(_EllipsesWhereExtends that) {
        return for_EllipsesWhereExtendsOnly(that);
    }

    public RetType for_EllipsesWhereTypeAlias(_EllipsesWhereTypeAlias that) {
        return for_EllipsesWhereTypeAliasOnly(that);
    }

    public RetType for_EllipsesWhereCoerces(_EllipsesWhereCoerces that) {
        return for_EllipsesWhereCoercesOnly(that);
    }

    public RetType for_EllipsesWhereEquals(_EllipsesWhereEquals that) {
        return for_EllipsesWhereEqualsOnly(that);
    }

    public RetType for_EllipsesUnitConstraint(_EllipsesUnitConstraint that) {
        return for_EllipsesUnitConstraintOnly(that);
    }

    public RetType for_EllipsesIntConstraint(_EllipsesIntConstraint that) {
        return for_EllipsesIntConstraintOnly(that);
    }

    public RetType for_EllipsesBoolConstraintExpr(_EllipsesBoolConstraintExpr that) {
        return for_EllipsesBoolConstraintExprOnly(that);
    }

    public RetType for_EllipsesContract(_EllipsesContract that) {
        return for_EllipsesContractOnly(that);
    }

    public RetType for_EllipsesEnsuresClause(_EllipsesEnsuresClause that) {
        return for_EllipsesEnsuresClauseOnly(that);
    }

    public RetType for_EllipsesStaticParam(_EllipsesStaticParam that) {
        return for_EllipsesStaticParamOnly(that);
    }

    public RetType for_EllipsesName(_EllipsesName that) {
        return for_EllipsesNameOnly(that);
    }

    public RetType for_EllipsesAPIName(_EllipsesAPIName that) {
        return for_EllipsesAPINameOnly(that);
    }

    public RetType for_EllipsesIdOrOpOrAnonymousName(_EllipsesIdOrOpOrAnonymousName that) {
        return for_EllipsesIdOrOpOrAnonymousNameOnly(that);
    }

    public RetType for_EllipsesIdOrOp(_EllipsesIdOrOp that) {
        return for_EllipsesIdOrOpOnly(that);
    }

    public RetType for_EllipsesId(_EllipsesId that) {
        return for_EllipsesIdOnly(that);
    }

    public RetType for_EllipsesOp(_EllipsesOp that) {
        return for_EllipsesOpOnly(that);
    }

    public RetType for_EllipsesNamedOp(_EllipsesNamedOp that) {
        return for_EllipsesNamedOpOnly(that);
    }

    public RetType for_Ellipses_InferenceVarOp(_Ellipses_InferenceVarOp that) {
        return for_Ellipses_InferenceVarOpOnly(that);
    }

    public RetType for_EllipsesAnonymousName(_EllipsesAnonymousName that) {
        return for_EllipsesAnonymousNameOnly(that);
    }

    public RetType for_EllipsesAnonymousFnName(_EllipsesAnonymousFnName that) {
        return for_EllipsesAnonymousFnNameOnly(that);
    }

    public RetType for_EllipsesConstructorFnName(_EllipsesConstructorFnName that) {
        return for_EllipsesConstructorFnNameOnly(that);
    }

    public RetType for_EllipsesArrayComprehensionClause(_EllipsesArrayComprehensionClause that) {
        return for_EllipsesArrayComprehensionClauseOnly(that);
    }

    public RetType for_EllipsesKeywordExpr(_EllipsesKeywordExpr that) {
        return for_EllipsesKeywordExprOnly(that);
    }

    public RetType for_EllipsesCaseClause(_EllipsesCaseClause that) {
        return for_EllipsesCaseClauseOnly(that);
    }

    public RetType for_EllipsesCatch(_EllipsesCatch that) {
        return for_EllipsesCatchOnly(that);
    }

    public RetType for_EllipsesCatchClause(_EllipsesCatchClause that) {
        return for_EllipsesCatchClauseOnly(that);
    }

    public RetType for_EllipsesIfClause(_EllipsesIfClause that) {
        return for_EllipsesIfClauseOnly(that);
    }

    public RetType for_EllipsesTypecaseClause(_EllipsesTypecaseClause that) {
        return for_EllipsesTypecaseClauseOnly(that);
    }

    public RetType for_EllipsesExtentRange(_EllipsesExtentRange that) {
        return for_EllipsesExtentRangeOnly(that);
    }

    public RetType for_EllipsesGeneratorClause(_EllipsesGeneratorClause that) {
        return for_EllipsesGeneratorClauseOnly(that);
    }

    public RetType for_EllipsesKeywordType(_EllipsesKeywordType that) {
        return for_EllipsesKeywordTypeOnly(that);
    }

    public RetType for_EllipsesTraitTypeWhere(_EllipsesTraitTypeWhere that) {
        return for_EllipsesTraitTypeWhereOnly(that);
    }

    public RetType for_EllipsesIndices(_EllipsesIndices that) {
        return for_EllipsesIndicesOnly(that);
    }

    public RetType for_EllipsesMathItem(_EllipsesMathItem that) {
        return for_EllipsesMathItemOnly(that);
    }

    public RetType for_EllipsesExprMI(_EllipsesExprMI that) {
        return for_EllipsesExprMIOnly(that);
    }

    public RetType for_EllipsesParenthesisDelimitedMI(_EllipsesParenthesisDelimitedMI that) {
        return for_EllipsesParenthesisDelimitedMIOnly(that);
    }

    public RetType for_EllipsesNonParenthesisDelimitedMI(_EllipsesNonParenthesisDelimitedMI that) {
        return for_EllipsesNonParenthesisDelimitedMIOnly(that);
    }

    public RetType for_EllipsesNonExprMI(_EllipsesNonExprMI that) {
        return for_EllipsesNonExprMIOnly(that);
    }

    public RetType for_EllipsesExponentiationMI(_EllipsesExponentiationMI that) {
        return for_EllipsesExponentiationMIOnly(that);
    }

    public RetType for_EllipsesSubscriptingMI(_EllipsesSubscriptingMI that) {
        return for_EllipsesSubscriptingMIOnly(that);
    }

    public RetType for_EllipsesOverloading(_EllipsesOverloading that) {
        return for_EllipsesOverloadingOnly(that);
    }

    public RetType for_EllipsesNonterminalHeader(_EllipsesNonterminalHeader that) {
        return for_EllipsesNonterminalHeaderOnly(that);
    }

    public RetType for_EllipsesNonterminalParameter(_EllipsesNonterminalParameter that) {
        return for_EllipsesNonterminalParameterOnly(that);
    }

    public RetType for_EllipsesSyntaxDecl(_EllipsesSyntaxDecl that) {
        return for_EllipsesSyntaxDeclOnly(that);
    }

    public RetType for_EllipsesSyntaxDef(_EllipsesSyntaxDef that) {
        return for_EllipsesSyntaxDefOnly(that);
    }

    public RetType for_EllipsesSuperSyntaxDef(_EllipsesSuperSyntaxDef that) {
        return for_EllipsesSuperSyntaxDefOnly(that);
    }

    public RetType for_EllipsesTransformerDecl(_EllipsesTransformerDecl that) {
        return for_EllipsesTransformerDeclOnly(that);
    }

    public RetType for_EllipsesPreTransformerDef(_EllipsesPreTransformerDef that) {
        return for_EllipsesPreTransformerDefOnly(that);
    }

    public RetType for_EllipsesNamedTransformerDef(_EllipsesNamedTransformerDef that) {
        return for_EllipsesNamedTransformerDefOnly(that);
    }

    public RetType for_EllipsesTransformer(_EllipsesTransformer that) {
        return for_EllipsesTransformerOnly(that);
    }

    public RetType for_EllipsesUnparsedTransformer(_EllipsesUnparsedTransformer that) {
        return for_EllipsesUnparsedTransformerOnly(that);
    }

    public RetType for_EllipsesNodeTransformer(_EllipsesNodeTransformer that) {
        return for_EllipsesNodeTransformerOnly(that);
    }

    public RetType for_EllipsesCaseTransformer(_EllipsesCaseTransformer that) {
        return for_EllipsesCaseTransformerOnly(that);
    }

    public RetType for_EllipsesCaseTransformerClause(_EllipsesCaseTransformerClause that) {
        return for_EllipsesCaseTransformerClauseOnly(that);
    }

    public RetType for_EllipsesSyntaxSymbol(_EllipsesSyntaxSymbol that) {
        return for_EllipsesSyntaxSymbolOnly(that);
    }

    public RetType for_EllipsesPrefixedSymbol(_EllipsesPrefixedSymbol that) {
        return for_EllipsesPrefixedSymbolOnly(that);
    }

    public RetType for_EllipsesOptionalSymbol(_EllipsesOptionalSymbol that) {
        return for_EllipsesOptionalSymbolOnly(that);
    }

    public RetType for_EllipsesRepeatSymbol(_EllipsesRepeatSymbol that) {
        return for_EllipsesRepeatSymbolOnly(that);
    }

    public RetType for_EllipsesRepeatOneOrMoreSymbol(_EllipsesRepeatOneOrMoreSymbol that) {
        return for_EllipsesRepeatOneOrMoreSymbolOnly(that);
    }

    public RetType for_EllipsesNoWhitespaceSymbol(_EllipsesNoWhitespaceSymbol that) {
        return for_EllipsesNoWhitespaceSymbolOnly(that);
    }

    public RetType for_EllipsesGroupSymbol(_EllipsesGroupSymbol that) {
        return for_EllipsesGroupSymbolOnly(that);
    }

    public RetType for_EllipsesSpecialSymbol(_EllipsesSpecialSymbol that) {
        return for_EllipsesSpecialSymbolOnly(that);
    }

    public RetType for_EllipsesAnyCharacterSymbol(_EllipsesAnyCharacterSymbol that) {
        return for_EllipsesAnyCharacterSymbolOnly(that);
    }

    public RetType for_EllipsesWhitespaceSymbol(_EllipsesWhitespaceSymbol that) {
        return for_EllipsesWhitespaceSymbolOnly(that);
    }

    public RetType for_EllipsesTabSymbol(_EllipsesTabSymbol that) {
        return for_EllipsesTabSymbolOnly(that);
    }

    public RetType for_EllipsesFormfeedSymbol(_EllipsesFormfeedSymbol that) {
        return for_EllipsesFormfeedSymbolOnly(that);
    }

    public RetType for_EllipsesCarriageReturnSymbol(_EllipsesCarriageReturnSymbol that) {
        return for_EllipsesCarriageReturnSymbolOnly(that);
    }

    public RetType for_EllipsesBackspaceSymbol(_EllipsesBackspaceSymbol that) {
        return for_EllipsesBackspaceSymbolOnly(that);
    }

    public RetType for_EllipsesNewlineSymbol(_EllipsesNewlineSymbol that) {
        return for_EllipsesNewlineSymbolOnly(that);
    }

    public RetType for_EllipsesBreaklineSymbol(_EllipsesBreaklineSymbol that) {
        return for_EllipsesBreaklineSymbolOnly(that);
    }

    public RetType for_EllipsesItemSymbol(_EllipsesItemSymbol that) {
        return for_EllipsesItemSymbolOnly(that);
    }

    public RetType for_EllipsesNonterminalSymbol(_EllipsesNonterminalSymbol that) {
        return for_EllipsesNonterminalSymbolOnly(that);
    }

    public RetType for_EllipsesKeywordSymbol(_EllipsesKeywordSymbol that) {
        return for_EllipsesKeywordSymbolOnly(that);
    }

    public RetType for_EllipsesTokenSymbol(_EllipsesTokenSymbol that) {
        return for_EllipsesTokenSymbolOnly(that);
    }

    public RetType for_EllipsesNotPredicateSymbol(_EllipsesNotPredicateSymbol that) {
        return for_EllipsesNotPredicateSymbolOnly(that);
    }

    public RetType for_EllipsesAndPredicateSymbol(_EllipsesAndPredicateSymbol that) {
        return for_EllipsesAndPredicateSymbolOnly(that);
    }

    public RetType for_EllipsesCharacterClassSymbol(_EllipsesCharacterClassSymbol that) {
        return for_EllipsesCharacterClassSymbolOnly(that);
    }

    public RetType for_EllipsesCharacterSymbol(_EllipsesCharacterSymbol that) {
        return for_EllipsesCharacterSymbolOnly(that);
    }

    public RetType for_EllipsesCharSymbol(_EllipsesCharSymbol that) {
        return for_EllipsesCharSymbolOnly(that);
    }

    public RetType for_EllipsesCharacterInterval(_EllipsesCharacterInterval that) {
        return for_EllipsesCharacterIntervalOnly(that);
    }

    public RetType for_EllipsesLink(_EllipsesLink that) {
        return for_EllipsesLinkOnly(that);
    }

    public RetType forTemplateGapAbstractNode(TemplateGapAbstractNode that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAbstractNodeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapCompilationUnit(TemplateGapCompilationUnit that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCompilationUnitOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapComponent(TemplateGapComponent that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapComponentOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapApi(TemplateGapApi that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapApiOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapImport(TemplateGapImport that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapImportOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapImportedNames(TemplateGapImportedNames that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapImportedNamesOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapImportStar(TemplateGapImportStar that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapImportStarOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapImportNames(TemplateGapImportNames that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapImportNamesOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapImportApi(TemplateGapImportApi that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapImportApiOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapAliasedSimpleName(TemplateGapAliasedSimpleName that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAliasedSimpleNameOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapAliasedAPIName(TemplateGapAliasedAPIName that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAliasedAPINameOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapDecl(TemplateGapDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTraitObjectDecl(TemplateGapTraitObjectDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTraitObjectDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTraitDecl(TemplateGapTraitDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTraitDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapObjectDecl(TemplateGapObjectDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapObjectDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapVarDecl(TemplateGapVarDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapVarDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapFnDecl(TemplateGapFnDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFnDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGap_RewriteFnOverloadDecl(TemplateGap_RewriteFnOverloadDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteFnOverloadDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGap_RewriteObjectExprDecl(TemplateGap_RewriteObjectExprDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteObjectExprDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGap_RewriteFunctionalMethodDecl(TemplateGap_RewriteFunctionalMethodDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteFunctionalMethodDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapDimUnitDecl(TemplateGapDimUnitDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimUnitDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapDimDecl(TemplateGapDimDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapUnitDecl(TemplateGapUnitDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnitDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTestDecl(TemplateGapTestDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTestDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapPropertyDecl(TemplateGapPropertyDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPropertyDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTypeAlias(TemplateGapTypeAlias that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypeAliasOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapGrammarDecl(TemplateGapGrammarDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapGrammarDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapGrammarMemberDecl(TemplateGapGrammarMemberDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapGrammarMemberDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNonterminalDecl(TemplateGapNonterminalDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNonterminalDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNonterminalDef(TemplateGapNonterminalDef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNonterminalDefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNonterminalExtensionDef(TemplateGapNonterminalExtensionDef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNonterminalExtensionDefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBinding(TemplateGapBinding that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBindingOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapLValue(TemplateGapLValue that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLValueOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapParam(TemplateGapParam that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapParamOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapExpr(TemplateGapExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapDummyExpr(TemplateGapDummyExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDummyExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTypeAnnotatedExpr(TemplateGapTypeAnnotatedExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypeAnnotatedExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapAsExpr(TemplateGapAsExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAsExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapAsIfExpr(TemplateGapAsIfExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAsIfExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapAssignment(TemplateGapAssignment that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAssignmentOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBlock(TemplateGapBlock that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBlockOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapDo(TemplateGapDo that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDoOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapCaseExpr(TemplateGapCaseExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCaseExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapIf(TemplateGapIf that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIfOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapLabel(TemplateGapLabel that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLabelOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapAbstractObjectExpr(TemplateGapAbstractObjectExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAbstractObjectExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapObjectExpr(TemplateGapObjectExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapObjectExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGap_RewriteObjectExpr(TemplateGap_RewriteObjectExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteObjectExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTry(TemplateGapTry that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTryOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTupleExpr(TemplateGapTupleExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTupleExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTypecase(TemplateGapTypecase that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypecaseOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapWhile(TemplateGapWhile that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhileOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapFor(TemplateGapFor that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapForOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBigOpApp(TemplateGapBigOpApp that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBigOpAppOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapAccumulator(TemplateGapAccumulator that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAccumulatorOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapArrayComprehension(TemplateGapArrayComprehension that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayComprehensionOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapAtomicExpr(TemplateGapAtomicExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAtomicExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapExit(TemplateGapExit that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapExitOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapSpawn(TemplateGapSpawn that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSpawnOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapThrow(TemplateGapThrow that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapThrowOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTryAtomicExpr(TemplateGapTryAtomicExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTryAtomicExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapFnExpr(TemplateGapFnExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFnExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapLetExpr(TemplateGapLetExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLetExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapLetFn(TemplateGapLetFn that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLetFnOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapLocalVarDecl(TemplateGapLocalVarDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLocalVarDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapSimpleExpr(TemplateGapSimpleExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSimpleExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapSubscriptExpr(TemplateGapSubscriptExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSubscriptExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapPrimary(TemplateGapPrimary that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPrimaryOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapLiteralExpr(TemplateGapLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNumberLiteralExpr(TemplateGapNumberLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNumberLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapFloatLiteralExpr(TemplateGapFloatLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFloatLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapIntLiteralExpr(TemplateGapIntLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapCharLiteralExpr(TemplateGapCharLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCharLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapStringLiteralExpr(TemplateGapStringLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapStringLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapVoidLiteralExpr(TemplateGapVoidLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapVoidLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBooleanLiteralExpr(TemplateGapBooleanLiteralExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBooleanLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapVarRef(TemplateGapVarRef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapVarRefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapFieldRef(TemplateGapFieldRef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFieldRefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapFunctionalRef(TemplateGapFunctionalRef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFunctionalRefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapFnRef(TemplateGapFnRef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFnRefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapOpRef(TemplateGapOpRef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOpRefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGap_RewriteFnRef(TemplateGap_RewriteFnRef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteFnRefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGap_RewriteObjectExprRef(TemplateGap_RewriteObjectExprRef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteObjectExprRefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapJuxt(TemplateGapJuxt that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapJuxtOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGap_RewriteFnApp(TemplateGap_RewriteFnApp that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteFnAppOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapOpExpr(TemplateGapOpExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOpExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapAmbiguousMultifixOpExpr(TemplateGapAmbiguousMultifixOpExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAmbiguousMultifixOpExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapChainExpr(TemplateGapChainExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapChainExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapCoercionInvocation(TemplateGapCoercionInvocation that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCoercionInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTraitCoercionInvocation(TemplateGapTraitCoercionInvocation that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTraitCoercionInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTupleCoercionInvocation(TemplateGapTupleCoercionInvocation that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTupleCoercionInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapArrowCoercionInvocation(TemplateGapArrowCoercionInvocation that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrowCoercionInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapUnionCoercionInvocation(TemplateGapUnionCoercionInvocation that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnionCoercionInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapMethodInvocation(TemplateGapMethodInvocation that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapMethodInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapMathPrimary(TemplateGapMathPrimary that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapMathPrimaryOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapArrayExpr(TemplateGapArrayExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapArrayElement(TemplateGapArrayElement that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayElementOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapArrayElements(TemplateGapArrayElements that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayElementsOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapType(TemplateGapType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBaseType(TemplateGapBaseType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBaseTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapAnyType(TemplateGapAnyType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAnyTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBottomType(TemplateGapBottomType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBottomTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapUnknownType(TemplateGapUnknownType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnknownTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapSelfType(TemplateGapSelfType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSelfTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTraitSelfType(TemplateGapTraitSelfType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTraitSelfTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapObjectExprType(TemplateGapObjectExprType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapObjectExprTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNamedType(TemplateGapNamedType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNamedTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_InferenceVarTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapVarType(TemplateGapVarType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapVarTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTraitType(TemplateGapTraitType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTraitTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAbbreviatedTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapArrayType(TemplateGapArrayType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapMatrixType(TemplateGapMatrixType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapMatrixTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTaggedDimType(TemplateGapTaggedDimType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTaggedDimTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTaggedUnitTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTupleType(TemplateGapTupleType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTupleTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapArrowType(TemplateGapArrowType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrowTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBoundType(TemplateGapBoundType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoundTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapIntersectionType(TemplateGapIntersectionType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntersectionTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapUnionType(TemplateGapUnionType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnionTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapFixedPointType(TemplateGapFixedPointType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFixedPointTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapLabelType(TemplateGapLabelType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLabelTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapDimExpr(TemplateGapDimExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapDimBase(TemplateGapDimBase that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimBaseOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapDimRef(TemplateGapDimRef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimRefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapDimExponent(TemplateGapDimExponent that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimExponentOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimUnaryOpOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimBinaryOpOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapPattern(TemplateGapPattern that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPatternOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapPatternArgs(TemplateGapPatternArgs that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPatternArgsOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapPatternBinding(TemplateGapPatternBinding that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPatternBindingOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapPlainPattern(TemplateGapPlainPattern that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPlainPatternOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTypePattern(TemplateGapTypePattern that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypePatternOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNestedPattern(TemplateGapNestedPattern that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNestedPatternOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapStaticArg(TemplateGapStaticArg that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapStaticArgOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTypeArg(TemplateGapTypeArg that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypeArgOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapIntArg(TemplateGapIntArg that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntArgOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBoolArg(TemplateGapBoolArg that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolArgOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapOpArg(TemplateGapOpArg that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOpArgOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapDimArg(TemplateGapDimArg that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimArgOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapUnitArg(TemplateGapUnitArg that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnitArgOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapStaticExpr(TemplateGapStaticExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapStaticExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapIntExpr(TemplateGapIntExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapIntBase(TemplateGapIntBase that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntBaseOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapIntRef(TemplateGapIntRef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntRefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapIntBinaryOp(TemplateGapIntBinaryOp that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntBinaryOpOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBoolExpr(TemplateGapBoolExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBoolBase(TemplateGapBoolBase that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolBaseOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBoolRef(TemplateGapBoolRef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolRefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBoolConstraint(TemplateGapBoolConstraint that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolConstraintOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBoolUnaryOp(TemplateGapBoolUnaryOp that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolUnaryOpOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBoolBinaryOp(TemplateGapBoolBinaryOp that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolBinaryOpOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapUnitExpr(TemplateGapUnitExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnitExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapUnitRef(TemplateGapUnitRef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnitRefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapUnitBinaryOp(TemplateGapUnitBinaryOp that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnitBinaryOpOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapEffect(TemplateGapEffect that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapEffectOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapWhereClause(TemplateGapWhereClause that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhereClauseOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapWhereBinding(TemplateGapWhereBinding that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhereBindingOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapWhereConstraint(TemplateGapWhereConstraint that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhereConstraintOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapWhereExtends(TemplateGapWhereExtends that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhereExtendsOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapWhereTypeAlias(TemplateGapWhereTypeAlias that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhereTypeAliasOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapWhereCoerces(TemplateGapWhereCoerces that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhereCoercesOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapWhereEquals(TemplateGapWhereEquals that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhereEqualsOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapUnitConstraint(TemplateGapUnitConstraint that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnitConstraintOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapIntConstraint(TemplateGapIntConstraint that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntConstraintOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBoolConstraintExpr(TemplateGapBoolConstraintExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolConstraintExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapContract(TemplateGapContract that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapContractOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapEnsuresClause(TemplateGapEnsuresClause that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapEnsuresClauseOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapStaticParam(TemplateGapStaticParam that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapStaticParamOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapName(TemplateGapName that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNameOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapAPIName(TemplateGapAPIName that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAPINameOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapIdOrOpOrAnonymousName(TemplateGapIdOrOpOrAnonymousName that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIdOrOpOrAnonymousNameOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapIdOrOp(TemplateGapIdOrOp that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIdOrOpOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapId(TemplateGapId that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIdOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapOp(TemplateGapOp that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOpOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNamedOp(TemplateGapNamedOp that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNamedOpOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGap_InferenceVarOp(TemplateGap_InferenceVarOp that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_InferenceVarOpOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapAnonymousName(TemplateGapAnonymousName that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAnonymousNameOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapAnonymousFnName(TemplateGapAnonymousFnName that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAnonymousFnNameOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapConstructorFnName(TemplateGapConstructorFnName that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapConstructorFnNameOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapArrayComprehensionClause(TemplateGapArrayComprehensionClause that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayComprehensionClauseOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapKeywordExpr(TemplateGapKeywordExpr that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapKeywordExprOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapCaseClause(TemplateGapCaseClause that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCaseClauseOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapCatch(TemplateGapCatch that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCatchOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapCatchClause(TemplateGapCatchClause that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCatchClauseOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapIfClause(TemplateGapIfClause that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIfClauseOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTypecaseClause(TemplateGapTypecaseClause that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypecaseClauseOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapExtentRange(TemplateGapExtentRange that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapExtentRangeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapGeneratorClause(TemplateGapGeneratorClause that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapGeneratorClauseOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapKeywordType(TemplateGapKeywordType that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapKeywordTypeOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTraitTypeWhere(TemplateGapTraitTypeWhere that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTraitTypeWhereOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapIndices(TemplateGapIndices that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIndicesOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapMathItem(TemplateGapMathItem that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapMathItemOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapExprMI(TemplateGapExprMI that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapExprMIOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapParenthesisDelimitedMI(TemplateGapParenthesisDelimitedMI that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapParenthesisDelimitedMIOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNonParenthesisDelimitedMI(TemplateGapNonParenthesisDelimitedMI that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNonParenthesisDelimitedMIOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNonExprMI(TemplateGapNonExprMI that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNonExprMIOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapExponentiationMI(TemplateGapExponentiationMI that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapExponentiationMIOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapSubscriptingMI(TemplateGapSubscriptingMI that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSubscriptingMIOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapOverloading(TemplateGapOverloading that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOverloadingOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNonterminalHeader(TemplateGapNonterminalHeader that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNonterminalHeaderOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNonterminalParameter(TemplateGapNonterminalParameter that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNonterminalParameterOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapSyntaxDecl(TemplateGapSyntaxDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSyntaxDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapSyntaxDef(TemplateGapSyntaxDef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSyntaxDefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapSuperSyntaxDef(TemplateGapSuperSyntaxDef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSuperSyntaxDefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTransformerDecl(TemplateGapTransformerDecl that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTransformerDeclOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapPreTransformerDef(TemplateGapPreTransformerDef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPreTransformerDefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNamedTransformerDef(TemplateGapNamedTransformerDef that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNamedTransformerDefOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTransformer(TemplateGapTransformer that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTransformerOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapUnparsedTransformer(TemplateGapUnparsedTransformer that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnparsedTransformerOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNodeTransformer(TemplateGapNodeTransformer that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNodeTransformerOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapCaseTransformer(TemplateGapCaseTransformer that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCaseTransformerOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapCaseTransformerClause(TemplateGapCaseTransformerClause that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCaseTransformerClauseOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapSyntaxSymbol(TemplateGapSyntaxSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSyntaxSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapPrefixedSymbol(TemplateGapPrefixedSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPrefixedSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapOptionalSymbol(TemplateGapOptionalSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOptionalSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapRepeatSymbol(TemplateGapRepeatSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapRepeatSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapRepeatOneOrMoreSymbol(TemplateGapRepeatOneOrMoreSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapRepeatOneOrMoreSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNoWhitespaceSymbol(TemplateGapNoWhitespaceSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNoWhitespaceSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapGroupSymbol(TemplateGapGroupSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapGroupSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapSpecialSymbol(TemplateGapSpecialSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSpecialSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapAnyCharacterSymbol(TemplateGapAnyCharacterSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAnyCharacterSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapWhitespaceSymbol(TemplateGapWhitespaceSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhitespaceSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTabSymbol(TemplateGapTabSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTabSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapFormfeedSymbol(TemplateGapFormfeedSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFormfeedSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapCarriageReturnSymbol(TemplateGapCarriageReturnSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCarriageReturnSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBackspaceSymbol(TemplateGapBackspaceSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBackspaceSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNewlineSymbol(TemplateGapNewlineSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNewlineSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapBreaklineSymbol(TemplateGapBreaklineSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBreaklineSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapItemSymbol(TemplateGapItemSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapItemSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNonterminalSymbol(TemplateGapNonterminalSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNonterminalSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapKeywordSymbol(TemplateGapKeywordSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapKeywordSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapTokenSymbol(TemplateGapTokenSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTokenSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapNotPredicateSymbol(TemplateGapNotPredicateSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNotPredicateSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapAndPredicateSymbol(TemplateGapAndPredicateSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAndPredicateSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapCharacterClassSymbol(TemplateGapCharacterClassSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCharacterClassSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapCharacterSymbol(TemplateGapCharacterSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCharacterSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapCharSymbol(TemplateGapCharSymbol that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCharSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapCharacterInterval(TemplateGapCharacterInterval that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCharacterIntervalOnly(that, info_result, gapId_result, templateParams_result);
    }

    public RetType forTemplateGapLink(TemplateGapLink that) {
        RetType info_result = recur(that.getInfo());
        RetType gapId_result = recur(that.getGapId());
        List<RetType> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLinkOnly(that, info_result, gapId_result, templateParams_result);
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

    public RetType recur(Node that) {
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

    public Option<RetType> recurOnOptionOfTypeOrPattern(Option<TypeOrPattern> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public List<RetType> recurOnListOfLhs(List<Lhs> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (Lhs elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public Option<RetType> recurOnOptionOfFunctionalRef(Option<FunctionalRef> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public List<RetType> recurOnListOfCompoundAssignmentInfo(List<CompoundAssignmentInfo> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (CompoundAssignmentInfo elt : that) {
            accum.add(recur(elt));
        }
        return accum;
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

    public Option<RetType> recurOnOptionOfMethodInfo(Option<MethodInfo> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
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

    public Option<RetType> recurOnOptionOfContract(Option<Contract> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public List<RetType> recurOnListOfTraitTypeWhere(List<TraitTypeWhere> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (TraitTypeWhere elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }

    public Option<List<RetType>> recurOnOptionOfListOfParam(Option<List<Param>> that) {
        if (that.isNone()) return Option.<List<RetType>>none();
        else return Option.<List<RetType>>some(recurOnListOfParam(that.unwrap()));
    }
}
