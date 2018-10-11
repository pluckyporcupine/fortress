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

/** A visitor over Node that combined recursive results.
 ** This visitor implements the visitor interface with methods that
 ** first visit children, and then call forCASEOnly(), passing in
 ** the values of the visits of the children. (CASE is replaced by the case name.)
 ** By default, each forCASEOnly combines its results together using the method
 **    combine(node, values...)
 ** All recursion should go via recur(...); this allows overrides to insert
 ** hooks into the recursion path (eg to record incremental results)
 **/
@SuppressWarnings({"unused", "unchecked"})
public abstract class NodeCollectingVisitor<RetType> extends NodeDepthFirstVisitor<RetType> {
    /* Methods to handle a node after recursion. */
    public RetType forNodeOnly(Node that) {
        return combine(that);
    }

    public RetType forASTNodeOnly(ASTNode that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forGenericOnly(Generic that, RetType info_result, RetType header_result) {
        return combine(that, info_result, header_result);
    }

    public RetType forObjectConstructorOnly(ObjectConstructor that, RetType info_result, RetType header_result) {
        return combine(that, info_result, header_result);
    }

    public RetType forAbstractNodeOnly(AbstractNode that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forCompilationUnitOnly(CompilationUnit that, RetType info_result, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result) {
        return combine(that, info_result, name_result, combine(imports_result), combine(decls_result), combine(comprises_result));
    }

    public RetType forComponentOnly(Component that, RetType info_result, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result, List<RetType> exports_result) {
        return combine(that, info_result, name_result, combine(imports_result), combine(decls_result), combine(comprises_result), combine(exports_result));
    }

    public RetType forApiOnly(Api that, RetType info_result, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result) {
        return combine(that, info_result, name_result, combine(imports_result), combine(decls_result), combine(comprises_result));
    }

    public RetType forImportOnly(Import that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forImportedNamesOnly(ImportedNames that, RetType info_result, RetType apiName_result) {
        return combine(that, info_result, apiName_result);
    }

    public RetType forImportStarOnly(ImportStar that, RetType info_result, RetType apiName_result, List<RetType> exceptNames_result) {
        return combine(that, info_result, apiName_result, combine(exceptNames_result));
    }

    public RetType forImportNamesOnly(ImportNames that, RetType info_result, RetType apiName_result, List<RetType> aliasedNames_result) {
        return combine(that, info_result, apiName_result, combine(aliasedNames_result));
    }

    public RetType forImportApiOnly(ImportApi that, RetType info_result, List<RetType> apis_result) {
        return combine(that, info_result, combine(apis_result));
    }

    public RetType forAliasedSimpleNameOnly(AliasedSimpleName that, RetType info_result, RetType name_result, Option<RetType> alias_result) {
        return combine(that, info_result, name_result, combine(alias_result));
    }

    public RetType forAliasedAPINameOnly(AliasedAPIName that, RetType info_result, RetType apiName_result, Option<RetType> alias_result) {
        return combine(that, info_result, apiName_result, combine(alias_result));
    }

    public RetType forDeclOnly(Decl that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forTraitObjectDeclOnly(TraitObjectDecl that, RetType info_result, RetType header_result, Option<RetType> selfType_result) {
        return combine(that, info_result, header_result, combine(selfType_result));
    }

    public RetType forTraitDeclOnly(TraitDecl that, RetType info_result, RetType header_result, Option<RetType> selfType_result, List<RetType> excludesClause_result, Option<List<RetType>> comprisesClause_result) {
        return combine(that, info_result, header_result, combine(selfType_result), combine(excludesClause_result), combineOptionList(comprisesClause_result));
    }

    public RetType forObjectDeclOnly(ObjectDecl that, RetType info_result, RetType header_result, Option<RetType> selfType_result) {
        return combine(that, info_result, header_result, combine(selfType_result));
    }

    public RetType forVarDeclOnly(VarDecl that, RetType info_result, List<RetType> lhs_result, Option<RetType> init_result) {
        return combine(that, info_result, combine(lhs_result), combine(init_result));
    }

    public RetType forFnDeclOnly(FnDecl that, RetType info_result, RetType header_result, RetType unambiguousName_result, Option<RetType> body_result, Option<RetType> implementsUnambiguousName_result) {
        return combine(that, info_result, header_result, unambiguousName_result, combine(body_result), combine(implementsUnambiguousName_result));
    }

    public RetType for_RewriteFnOverloadDeclOnly(_RewriteFnOverloadDecl that, RetType info_result, RetType name_result, List<RetType> fns_result, Option<RetType> type_result) {
        return combine(that, info_result, name_result, combine(fns_result), combine(type_result));
    }

    public RetType for_RewriteObjectExprDeclOnly(_RewriteObjectExprDecl that, RetType info_result, List<RetType> objectExprs_result) {
        return combine(that, info_result, combine(objectExprs_result));
    }

    public RetType for_RewriteFunctionalMethodDeclOnly(_RewriteFunctionalMethodDecl that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forDimUnitDeclOnly(DimUnitDecl that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forDimDeclOnly(DimDecl that, RetType info_result, RetType dimId_result, Option<RetType> derived_result, Option<RetType> defaultId_result) {
        return combine(that, info_result, dimId_result, combine(derived_result), combine(defaultId_result));
    }

    public RetType forUnitDeclOnly(UnitDecl that, RetType info_result, List<RetType> units_result, Option<RetType> dimType_result, Option<RetType> defExpr_result) {
        return combine(that, info_result, combine(units_result), combine(dimType_result), combine(defExpr_result));
    }

    public RetType forTestDeclOnly(TestDecl that, RetType info_result, RetType name_result, List<RetType> gens_result, RetType expr_result) {
        return combine(that, info_result, name_result, combine(gens_result), expr_result);
    }

    public RetType forPropertyDeclOnly(PropertyDecl that, RetType info_result, Option<RetType> name_result, List<RetType> params_result, RetType expr_result) {
        return combine(that, info_result, combine(name_result), combine(params_result), expr_result);
    }

    public RetType forTypeAliasOnly(TypeAlias that, RetType info_result, RetType name_result, List<RetType> staticParams_result, RetType typeDef_result) {
        return combine(that, info_result, name_result, combine(staticParams_result), typeDef_result);
    }

    public RetType forGrammarDeclOnly(GrammarDecl that, RetType info_result, RetType name_result, List<RetType> extendsClause_result, List<RetType> members_result, List<RetType> transformers_result) {
        return combine(that, info_result, name_result, combine(extendsClause_result), combine(members_result), combine(transformers_result));
    }

    public RetType forGrammarMemberDeclOnly(GrammarMemberDecl that, RetType info_result, RetType name_result) {
        return combine(that, info_result, name_result);
    }

    public RetType forNonterminalDeclOnly(NonterminalDecl that, RetType info_result, RetType name_result, List<RetType> syntaxDecls_result) {
        return combine(that, info_result, name_result, combine(syntaxDecls_result));
    }

    public RetType forNonterminalDefOnly(NonterminalDef that, RetType info_result, RetType name_result, List<RetType> syntaxDecls_result, RetType header_result, Option<RetType> astType_result) {
        return combine(that, info_result, name_result, combine(syntaxDecls_result), header_result, combine(astType_result));
    }

    public RetType forNonterminalExtensionDefOnly(NonterminalExtensionDef that, RetType info_result, RetType name_result, List<RetType> syntaxDecls_result) {
        return combine(that, info_result, name_result, combine(syntaxDecls_result));
    }

    public RetType forBindingOnly(Binding that, RetType info_result, RetType name_result, Option<RetType> idType_result) {
        return combine(that, info_result, name_result, combine(idType_result));
    }

    public RetType forLValueOnly(LValue that, RetType info_result, RetType name_result, Option<RetType> idType_result) {
        return combine(that, info_result, name_result, combine(idType_result));
    }

    public RetType forParamOnly(Param that, RetType info_result, RetType name_result, Option<RetType> idType_result, Option<RetType> defaultExpr_result, Option<RetType> varargsType_result) {
        return combine(that, info_result, name_result, combine(idType_result), combine(defaultExpr_result), combine(varargsType_result));
    }

    public RetType forExprOnly(Expr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forDummyExprOnly(DummyExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forTypeAnnotatedExprOnly(TypeAnnotatedExpr that, RetType info_result, RetType expr_result, RetType annType_result) {
        return combine(that, info_result, expr_result, annType_result);
    }

    public RetType forAsExprOnly(AsExpr that, RetType info_result, RetType expr_result, RetType annType_result) {
        return combine(that, info_result, expr_result, annType_result);
    }

    public RetType forAsIfExprOnly(AsIfExpr that, RetType info_result, RetType expr_result, RetType annType_result) {
        return combine(that, info_result, expr_result, annType_result);
    }

    public RetType forAssignmentOnly(Assignment that, RetType info_result, List<RetType> lhs_result, Option<RetType> assignOp_result, RetType rhs_result, List<RetType> assignmentInfos_result) {
        return combine(that, info_result, combine(lhs_result), combine(assignOp_result), rhs_result, combine(assignmentInfos_result));
    }

    public RetType forBlockOnly(Block that, RetType info_result, Option<RetType> loc_result, List<RetType> exprs_result) {
        return combine(that, info_result, combine(loc_result), combine(exprs_result));
    }

    public RetType forDoOnly(Do that, RetType info_result, List<RetType> fronts_result) {
        return combine(that, info_result, combine(fronts_result));
    }

    public RetType forCaseExprOnly(CaseExpr that, RetType info_result, Option<RetType> param_result, Option<RetType> compare_result, RetType equalsOp_result, RetType inOp_result, List<RetType> clauses_result, Option<RetType> elseClause_result) {
        return combine(that, info_result, combine(param_result), combine(compare_result), equalsOp_result, inOp_result, combine(clauses_result), combine(elseClause_result));
    }

    public RetType forIfOnly(If that, RetType info_result, List<RetType> clauses_result, Option<RetType> elseClause_result) {
        return combine(that, info_result, combine(clauses_result), combine(elseClause_result));
    }

    public RetType forLabelOnly(Label that, RetType info_result, RetType name_result, RetType body_result) {
        return combine(that, info_result, name_result, body_result);
    }

    public RetType forAbstractObjectExprOnly(AbstractObjectExpr that, RetType info_result, RetType header_result) {
        return combine(that, info_result, header_result);
    }

    public RetType forObjectExprOnly(ObjectExpr that, RetType info_result, RetType header_result, Option<RetType> selfType_result) {
        return combine(that, info_result, header_result, combine(selfType_result));
    }

    public RetType for_RewriteObjectExprOnly(_RewriteObjectExpr that, RetType info_result, RetType header_result, List<RetType> staticArgs_result) {
        return combine(that, info_result, header_result, combine(staticArgs_result));
    }

    public RetType forTryOnly(Try that, RetType info_result, RetType body_result, Option<RetType> catchClause_result, List<RetType> forbidClause_result, Option<RetType> finallyClause_result) {
        return combine(that, info_result, body_result, combine(catchClause_result), combine(forbidClause_result), combine(finallyClause_result));
    }

    public RetType forTupleExprOnly(TupleExpr that, RetType info_result, List<RetType> exprs_result, Option<RetType> varargs_result, List<RetType> keywords_result) {
        return combine(that, info_result, combine(exprs_result), combine(varargs_result), combine(keywords_result));
    }

    public RetType forTypecaseOnly(Typecase that, RetType info_result, RetType bindExpr_result, List<RetType> clauses_result, Option<RetType> elseClause_result) {
        return combine(that, info_result, bindExpr_result, combine(clauses_result), combine(elseClause_result));
    }

    public RetType forWhileOnly(While that, RetType info_result, RetType testExpr_result, RetType body_result) {
        return combine(that, info_result, testExpr_result, body_result);
    }

    public RetType forForOnly(For that, RetType info_result, List<RetType> gens_result, RetType body_result) {
        return combine(that, info_result, combine(gens_result), body_result);
    }

    public RetType forBigOpAppOnly(BigOpApp that, RetType info_result, List<RetType> staticArgs_result) {
        return combine(that, info_result, combine(staticArgs_result));
    }

    public RetType forAccumulatorOnly(Accumulator that, RetType info_result, List<RetType> staticArgs_result, RetType accOp_result, List<RetType> gens_result, RetType body_result) {
        return combine(that, info_result, combine(staticArgs_result), accOp_result, combine(gens_result), body_result);
    }

    public RetType forArrayComprehensionOnly(ArrayComprehension that, RetType info_result, List<RetType> staticArgs_result, List<RetType> clauses_result) {
        return combine(that, info_result, combine(staticArgs_result), combine(clauses_result));
    }

    public RetType forAtomicExprOnly(AtomicExpr that, RetType info_result, RetType expr_result) {
        return combine(that, info_result, expr_result);
    }

    public RetType forExitOnly(Exit that, RetType info_result, Option<RetType> target_result, Option<RetType> returnExpr_result) {
        return combine(that, info_result, combine(target_result), combine(returnExpr_result));
    }

    public RetType forSpawnOnly(Spawn that, RetType info_result, RetType body_result) {
        return combine(that, info_result, body_result);
    }

    public RetType forThrowOnly(Throw that, RetType info_result, RetType expr_result) {
        return combine(that, info_result, expr_result);
    }

    public RetType forTryAtomicExprOnly(TryAtomicExpr that, RetType info_result, RetType expr_result) {
        return combine(that, info_result, expr_result);
    }

    public RetType forFnExprOnly(FnExpr that, RetType info_result, RetType header_result, RetType body_result) {
        return combine(that, info_result, header_result, body_result);
    }

    public RetType forLetExprOnly(LetExpr that, RetType info_result, RetType body_result) {
        return combine(that, info_result, body_result);
    }

    public RetType forLetFnOnly(LetFn that, RetType info_result, RetType body_result, List<RetType> fns_result) {
        return combine(that, info_result, body_result, combine(fns_result));
    }

    public RetType forLocalVarDeclOnly(LocalVarDecl that, RetType info_result, RetType body_result, List<RetType> lhs_result, Option<RetType> rhs_result) {
        return combine(that, info_result, body_result, combine(lhs_result), combine(rhs_result));
    }

    public RetType forSimpleExprOnly(SimpleExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forSubscriptExprOnly(SubscriptExpr that, RetType info_result, RetType obj_result, List<RetType> subs_result, Option<RetType> op_result, List<RetType> staticArgs_result) {
        return combine(that, info_result, obj_result, combine(subs_result), combine(op_result), combine(staticArgs_result));
    }

    public RetType forPrimaryOnly(Primary that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forLiteralExprOnly(LiteralExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forNumberLiteralExprOnly(NumberLiteralExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forFloatLiteralExprOnly(FloatLiteralExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forIntLiteralExprOnly(IntLiteralExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forCharLiteralExprOnly(CharLiteralExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forStringLiteralExprOnly(StringLiteralExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forVoidLiteralExprOnly(VoidLiteralExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forBooleanLiteralExprOnly(BooleanLiteralExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forVarRefOnly(VarRef that, RetType info_result, RetType varId_result, List<RetType> staticArgs_result) {
        return combine(that, info_result, varId_result, combine(staticArgs_result));
    }

    public RetType forFieldRefOnly(FieldRef that, RetType info_result, RetType obj_result, RetType field_result) {
        return combine(that, info_result, obj_result, field_result);
    }

    public RetType forFunctionalRefOnly(FunctionalRef that, RetType info_result, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result) {
        return combine(that, info_result, combine(staticArgs_result), originalName_result, combine(names_result), combine(interpOverloadings_result), combine(newOverloadings_result), combine(overloadingType_result), combine(overloadingSchema_result));
    }

    public RetType forFnRefOnly(FnRef that, RetType info_result, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result) {
        return combine(that, info_result, combine(staticArgs_result), originalName_result, combine(names_result), combine(interpOverloadings_result), combine(newOverloadings_result), combine(overloadingType_result), combine(overloadingSchema_result));
    }

    public RetType forOpRefOnly(OpRef that, RetType info_result, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result) {
        return combine(that, info_result, combine(staticArgs_result), originalName_result, combine(names_result), combine(interpOverloadings_result), combine(newOverloadings_result), combine(overloadingType_result), combine(overloadingSchema_result));
    }

    public RetType for_RewriteFnRefOnly(_RewriteFnRef that, RetType info_result, RetType fnExpr_result, List<RetType> staticArgs_result) {
        return combine(that, info_result, fnExpr_result, combine(staticArgs_result));
    }

    public RetType for_RewriteObjectExprRefOnly(_RewriteObjectExprRef that, RetType info_result, List<RetType> staticArgs_result) {
        return combine(that, info_result, combine(staticArgs_result));
    }

    public RetType forJuxtOnly(Juxt that, RetType info_result, RetType multiJuxt_result, RetType infixJuxt_result, List<RetType> exprs_result) {
        return combine(that, info_result, multiJuxt_result, infixJuxt_result, combine(exprs_result));
    }

    public RetType for_RewriteFnAppOnly(_RewriteFnApp that, RetType info_result, RetType function_result, RetType argument_result) {
        return combine(that, info_result, function_result, argument_result);
    }

    public RetType forOpExprOnly(OpExpr that, RetType info_result, RetType op_result, List<RetType> args_result) {
        return combine(that, info_result, op_result, combine(args_result));
    }

    public RetType forAmbiguousMultifixOpExprOnly(AmbiguousMultifixOpExpr that, RetType info_result, RetType infix_op_result, RetType multifix_op_result, List<RetType> args_result) {
        return combine(that, info_result, infix_op_result, multifix_op_result, combine(args_result));
    }

    public RetType forChainExprOnly(ChainExpr that, RetType info_result, RetType first_result, List<RetType> links_result) {
        return combine(that, info_result, first_result, combine(links_result));
    }

    public RetType forCoercionInvocationOnly(CoercionInvocation that, RetType info_result, RetType toType_result, RetType arg_result) {
        return combine(that, info_result, toType_result, arg_result);
    }

    public RetType forTraitCoercionInvocationOnly(TraitCoercionInvocation that, RetType info_result, RetType arg_result, RetType toType_result, RetType coercionFn_result) {
        return combine(that, info_result, arg_result, toType_result, coercionFn_result);
    }

    public RetType forTupleCoercionInvocationOnly(TupleCoercionInvocation that, RetType info_result, RetType arg_result, RetType toType_result, List<Option<RetType>> subCoercions_result, Option<Option<RetType>> varargCoercion_result) {
        return combine(that, info_result, arg_result, toType_result, combineListOption(subCoercions_result), combineOptionOption(varargCoercion_result));
    }

    public RetType forArrowCoercionInvocationOnly(ArrowCoercionInvocation that, RetType info_result, RetType arg_result, RetType toType_result, Option<RetType> domainCoercion_result, Option<RetType> rangeCoercion_result) {
        return combine(that, info_result, arg_result, toType_result, combine(domainCoercion_result), combine(rangeCoercion_result));
    }

    public RetType forUnionCoercionInvocationOnly(UnionCoercionInvocation that, RetType info_result, RetType toType_result, RetType arg_result, List<RetType> fromTypes_result, List<Option<RetType>> fromCoercions_result) {
        return combine(that, info_result, toType_result, arg_result, combine(fromTypes_result), combineListOption(fromCoercions_result));
    }

    public RetType forMethodInvocationOnly(MethodInvocation that, RetType info_result, RetType obj_result, RetType method_result, List<RetType> staticArgs_result, RetType arg_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result) {
        return combine(that, info_result, obj_result, method_result, combine(staticArgs_result), arg_result, combine(overloadingType_result), combine(overloadingSchema_result));
    }

    public RetType forMathPrimaryOnly(MathPrimary that, RetType info_result, RetType multiJuxt_result, RetType infixJuxt_result, RetType front_result, List<RetType> rest_result) {
        return combine(that, info_result, multiJuxt_result, infixJuxt_result, front_result, combine(rest_result));
    }

    public RetType forArrayExprOnly(ArrayExpr that, RetType info_result, List<RetType> staticArgs_result) {
        return combine(that, info_result, combine(staticArgs_result));
    }

    public RetType forArrayElementOnly(ArrayElement that, RetType info_result, List<RetType> staticArgs_result, RetType element_result) {
        return combine(that, info_result, combine(staticArgs_result), element_result);
    }

    public RetType forArrayElementsOnly(ArrayElements that, RetType info_result, List<RetType> staticArgs_result, List<RetType> elements_result) {
        return combine(that, info_result, combine(staticArgs_result), combine(elements_result));
    }

    public RetType forTypeOnly(Type that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forBaseTypeOnly(BaseType that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forAnyTypeOnly(AnyType that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forBottomTypeOnly(BottomType that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forUnknownTypeOnly(UnknownType that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forSelfTypeOnly(SelfType that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forTraitSelfTypeOnly(TraitSelfType that, RetType info_result, RetType named_result, List<RetType> comprised_result) {
        return combine(that, info_result, named_result, combine(comprised_result));
    }

    public RetType forObjectExprTypeOnly(ObjectExprType that, RetType info_result, List<RetType> extended_result) {
        return combine(that, info_result, combine(extended_result));
    }

    public RetType forNamedTypeOnly(NamedType that, RetType info_result, RetType name_result) {
        return combine(that, info_result, name_result);
    }

    public RetType for_InferenceVarTypeOnly(_InferenceVarType that, RetType info_result, RetType name_result) {
        return combine(that, info_result, name_result);
    }

    public RetType forVarTypeOnly(VarType that, RetType info_result, RetType name_result) {
        return combine(that, info_result, name_result);
    }

    public RetType forTraitTypeOnly(TraitType that, RetType info_result, RetType name_result, List<RetType> args_result, List<RetType> traitStaticParams_result) {
        return combine(that, info_result, name_result, combine(args_result), combine(traitStaticParams_result));
    }

    public RetType forAbbreviatedTypeOnly(AbbreviatedType that, RetType info_result, RetType elemType_result) {
        return combine(that, info_result, elemType_result);
    }

    public RetType forArrayTypeOnly(ArrayType that, RetType info_result, RetType elemType_result, RetType indices_result) {
        return combine(that, info_result, elemType_result, indices_result);
    }

    public RetType forMatrixTypeOnly(MatrixType that, RetType info_result, RetType elemType_result, List<RetType> dimensions_result) {
        return combine(that, info_result, elemType_result, combine(dimensions_result));
    }

    public RetType forTaggedDimTypeOnly(TaggedDimType that, RetType info_result, RetType elemType_result, RetType dimExpr_result, Option<RetType> unitExpr_result) {
        return combine(that, info_result, elemType_result, dimExpr_result, combine(unitExpr_result));
    }

    public RetType forTaggedUnitTypeOnly(TaggedUnitType that, RetType info_result, RetType elemType_result, RetType unitExpr_result) {
        return combine(that, info_result, elemType_result, unitExpr_result);
    }

    public RetType forTupleTypeOnly(TupleType that, RetType info_result, List<RetType> elements_result, Option<RetType> varargs_result, List<RetType> keywords_result) {
        return combine(that, info_result, combine(elements_result), combine(varargs_result), combine(keywords_result));
    }

    public RetType forArrowTypeOnly(ArrowType that, RetType info_result, RetType domain_result, RetType range_result, RetType effect_result, Option<RetType> methodInfo_result) {
        return combine(that, info_result, domain_result, range_result, effect_result, combine(methodInfo_result));
    }

    public RetType forBoundTypeOnly(BoundType that, RetType info_result, List<RetType> elements_result) {
        return combine(that, info_result, combine(elements_result));
    }

    public RetType forIntersectionTypeOnly(IntersectionType that, RetType info_result, List<RetType> elements_result) {
        return combine(that, info_result, combine(elements_result));
    }

    public RetType forUnionTypeOnly(UnionType that, RetType info_result, List<RetType> elements_result) {
        return combine(that, info_result, combine(elements_result));
    }

    public RetType forFixedPointTypeOnly(FixedPointType that, RetType info_result, RetType name_result, RetType body_result) {
        return combine(that, info_result, name_result, body_result);
    }

    public RetType forLabelTypeOnly(LabelType that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forDimExprOnly(DimExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forDimBaseOnly(DimBase that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forDimRefOnly(DimRef that, RetType info_result, RetType name_result) {
        return combine(that, info_result, name_result);
    }

    public RetType forDimExponentOnly(DimExponent that, RetType info_result, RetType base_result, RetType power_result) {
        return combine(that, info_result, base_result, power_result);
    }

    public RetType forDimUnaryOpOnly(DimUnaryOp that, RetType info_result, RetType dimVal_result, RetType op_result) {
        return combine(that, info_result, dimVal_result, op_result);
    }

    public RetType forDimBinaryOpOnly(DimBinaryOp that, RetType info_result, RetType left_result, RetType right_result, RetType op_result) {
        return combine(that, info_result, left_result, right_result, op_result);
    }

    public RetType forPatternOnly(Pattern that, RetType info_result, Option<RetType> name_result, RetType patterns_result) {
        return combine(that, info_result, combine(name_result), patterns_result);
    }

    public RetType forPatternArgsOnly(PatternArgs that, RetType info_result, List<RetType> patterns_result) {
        return combine(that, info_result, combine(patterns_result));
    }

    public RetType forPatternBindingOnly(PatternBinding that, RetType info_result, Option<RetType> field_result) {
        return combine(that, info_result, combine(field_result));
    }

    public RetType forPlainPatternOnly(PlainPattern that, RetType info_result, Option<RetType> field_result, RetType name_result, Option<RetType> idType_result) {
        return combine(that, info_result, combine(field_result), name_result, combine(idType_result));
    }

    public RetType forTypePatternOnly(TypePattern that, RetType info_result, Option<RetType> field_result, RetType typ_result) {
        return combine(that, info_result, combine(field_result), typ_result);
    }

    public RetType forNestedPatternOnly(NestedPattern that, RetType info_result, Option<RetType> field_result, RetType pat_result) {
        return combine(that, info_result, combine(field_result), pat_result);
    }

    public RetType forStaticArgOnly(StaticArg that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forTypeArgOnly(TypeArg that, RetType info_result, RetType typeArg_result) {
        return combine(that, info_result, typeArg_result);
    }

    public RetType forIntArgOnly(IntArg that, RetType info_result, RetType intVal_result) {
        return combine(that, info_result, intVal_result);
    }

    public RetType forBoolArgOnly(BoolArg that, RetType info_result, RetType boolArg_result) {
        return combine(that, info_result, boolArg_result);
    }

    public RetType forOpArgOnly(OpArg that, RetType info_result, RetType id_result) {
        return combine(that, info_result, id_result);
    }

    public RetType forDimArgOnly(DimArg that, RetType info_result, RetType dimArg_result) {
        return combine(that, info_result, dimArg_result);
    }

    public RetType forUnitArgOnly(UnitArg that, RetType info_result, RetType unitArg_result) {
        return combine(that, info_result, unitArg_result);
    }

    public RetType forStaticExprOnly(StaticExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forIntExprOnly(IntExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forIntBaseOnly(IntBase that, RetType info_result, RetType intVal_result) {
        return combine(that, info_result, intVal_result);
    }

    public RetType forIntRefOnly(IntRef that, RetType info_result, RetType name_result) {
        return combine(that, info_result, name_result);
    }

    public RetType forIntBinaryOpOnly(IntBinaryOp that, RetType info_result, RetType left_result, RetType right_result, RetType op_result) {
        return combine(that, info_result, left_result, right_result, op_result);
    }

    public RetType forBoolExprOnly(BoolExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forBoolBaseOnly(BoolBase that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forBoolRefOnly(BoolRef that, RetType info_result, RetType name_result) {
        return combine(that, info_result, name_result);
    }

    public RetType forBoolConstraintOnly(BoolConstraint that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forBoolUnaryOpOnly(BoolUnaryOp that, RetType info_result, RetType boolVal_result, RetType op_result) {
        return combine(that, info_result, boolVal_result, op_result);
    }

    public RetType forBoolBinaryOpOnly(BoolBinaryOp that, RetType info_result, RetType left_result, RetType right_result, RetType op_result) {
        return combine(that, info_result, left_result, right_result, op_result);
    }

    public RetType forUnitExprOnly(UnitExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forUnitRefOnly(UnitRef that, RetType info_result, RetType name_result) {
        return combine(that, info_result, name_result);
    }

    public RetType forUnitBinaryOpOnly(UnitBinaryOp that, RetType info_result, RetType left_result, RetType right_result, RetType op_result) {
        return combine(that, info_result, left_result, right_result, op_result);
    }

    public RetType forEffectOnly(Effect that, RetType info_result, Option<List<RetType>> throwsClause_result) {
        return combine(that, info_result, combineOptionList(throwsClause_result));
    }

    public RetType forWhereClauseOnly(WhereClause that, RetType info_result, List<RetType> bindings_result, List<RetType> constraints_result) {
        return combine(that, info_result, combine(bindings_result), combine(constraints_result));
    }

    public RetType forWhereBindingOnly(WhereBinding that, RetType info_result, RetType name_result, List<RetType> supers_result, RetType kind_result) {
        return combine(that, info_result, name_result, combine(supers_result), kind_result);
    }

    public RetType forWhereConstraintOnly(WhereConstraint that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forWhereExtendsOnly(WhereExtends that, RetType info_result, RetType name_result, List<RetType> supers_result) {
        return combine(that, info_result, name_result, combine(supers_result));
    }

    public RetType forWhereTypeAliasOnly(WhereTypeAlias that, RetType info_result, RetType alias_result) {
        return combine(that, info_result, alias_result);
    }

    public RetType forWhereCoercesOnly(WhereCoerces that, RetType info_result, RetType left_result, RetType right_result) {
        return combine(that, info_result, left_result, right_result);
    }

    public RetType forWhereEqualsOnly(WhereEquals that, RetType info_result, RetType left_result, RetType right_result) {
        return combine(that, info_result, left_result, right_result);
    }

    public RetType forUnitConstraintOnly(UnitConstraint that, RetType info_result, RetType name_result) {
        return combine(that, info_result, name_result);
    }

    public RetType forIntConstraintOnly(IntConstraint that, RetType info_result, RetType left_result, RetType right_result, RetType op_result) {
        return combine(that, info_result, left_result, right_result, op_result);
    }

    public RetType forBoolConstraintExprOnly(BoolConstraintExpr that, RetType info_result, RetType constraint_result) {
        return combine(that, info_result, constraint_result);
    }

    public RetType forContractOnly(Contract that, RetType info_result, Option<List<RetType>> requiresClause_result, Option<List<RetType>> ensuresClause_result, Option<List<RetType>> invariantsClause_result) {
        return combine(that, info_result, combineOptionList(requiresClause_result), combineOptionList(ensuresClause_result), combineOptionList(invariantsClause_result));
    }

    public RetType forEnsuresClauseOnly(EnsuresClause that, RetType info_result, RetType post_result, Option<RetType> pre_result) {
        return combine(that, info_result, post_result, combine(pre_result));
    }

    public RetType forStaticParamOnly(StaticParam that, RetType info_result, RetType name_result, List<RetType> extendsClause_result, List<RetType> dominatesClause_result, Option<RetType> dimParam_result, RetType kind_result) {
        return combine(that, info_result, name_result, combine(extendsClause_result), combine(dominatesClause_result), combine(dimParam_result), kind_result);
    }

    public RetType forNameOnly(Name that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forAPINameOnly(APIName that, RetType info_result, List<RetType> ids_result) {
        return combine(that, info_result, combine(ids_result));
    }

    public RetType forIdOrOpOrAnonymousNameOnly(IdOrOpOrAnonymousName that, RetType info_result, Option<RetType> apiName_result) {
        return combine(that, info_result, combine(apiName_result));
    }

    public RetType forIdOrOpOnly(IdOrOp that, RetType info_result, Option<RetType> apiName_result) {
        return combine(that, info_result, combine(apiName_result));
    }

    public RetType forIdOnly(Id that, RetType info_result, Option<RetType> apiName_result) {
        return combine(that, info_result, combine(apiName_result));
    }

    public RetType forOpOnly(Op that, RetType info_result, Option<RetType> apiName_result, RetType fixity_result) {
        return combine(that, info_result, combine(apiName_result), fixity_result);
    }

    public RetType forNamedOpOnly(NamedOp that, RetType info_result, Option<RetType> apiName_result, RetType fixity_result) {
        return combine(that, info_result, combine(apiName_result), fixity_result);
    }

    public RetType for_InferenceVarOpOnly(_InferenceVarOp that, RetType info_result, Option<RetType> apiName_result, RetType fixity_result) {
        return combine(that, info_result, combine(apiName_result), fixity_result);
    }

    public RetType forAnonymousNameOnly(AnonymousName that, RetType info_result, Option<RetType> apiName_result) {
        return combine(that, info_result, combine(apiName_result));
    }

    public RetType forAnonymousFnNameOnly(AnonymousFnName that, RetType info_result, Option<RetType> apiName_result) {
        return combine(that, info_result, combine(apiName_result));
    }

    public RetType forConstructorFnNameOnly(ConstructorFnName that, RetType info_result, Option<RetType> apiName_result, RetType constructor_result) {
        return combine(that, info_result, combine(apiName_result), constructor_result);
    }

    public RetType forArrayComprehensionClauseOnly(ArrayComprehensionClause that, RetType info_result, List<RetType> bind_result, RetType init_result, List<RetType> gens_result) {
        return combine(that, info_result, combine(bind_result), init_result, combine(gens_result));
    }

    public RetType forKeywordExprOnly(KeywordExpr that, RetType info_result, RetType name_result, RetType init_result) {
        return combine(that, info_result, name_result, init_result);
    }

    public RetType forCaseClauseOnly(CaseClause that, RetType info_result, RetType matchClause_result, RetType body_result, Option<RetType> op_result) {
        return combine(that, info_result, matchClause_result, body_result, combine(op_result));
    }

    public RetType forCatchOnly(Catch that, RetType info_result, RetType name_result, List<RetType> clauses_result) {
        return combine(that, info_result, name_result, combine(clauses_result));
    }

    public RetType forCatchClauseOnly(CatchClause that, RetType info_result, RetType matchType_result, RetType body_result) {
        return combine(that, info_result, matchType_result, body_result);
    }

    public RetType forIfClauseOnly(IfClause that, RetType info_result, RetType testClause_result, RetType body_result) {
        return combine(that, info_result, testClause_result, body_result);
    }

    public RetType forTypecaseClauseOnly(TypecaseClause that, RetType info_result, Option<RetType> name_result, RetType matchType_result, RetType body_result) {
        return combine(that, info_result, combine(name_result), matchType_result, body_result);
    }

    public RetType forExtentRangeOnly(ExtentRange that, RetType info_result, Option<RetType> base_result, Option<RetType> size_result, Option<RetType> op_result) {
        return combine(that, info_result, combine(base_result), combine(size_result), combine(op_result));
    }

    public RetType forGeneratorClauseOnly(GeneratorClause that, RetType info_result, List<RetType> bind_result, RetType init_result) {
        return combine(that, info_result, combine(bind_result), init_result);
    }

    public RetType forKeywordTypeOnly(KeywordType that, RetType info_result, RetType name_result, RetType keywordType_result) {
        return combine(that, info_result, name_result, keywordType_result);
    }

    public RetType forTraitTypeWhereOnly(TraitTypeWhere that, RetType info_result, RetType baseType_result, Option<RetType> whereClause_result) {
        return combine(that, info_result, baseType_result, combine(whereClause_result));
    }

    public RetType forIndicesOnly(Indices that, RetType info_result, List<RetType> extents_result) {
        return combine(that, info_result, combine(extents_result));
    }

    public RetType forMathItemOnly(MathItem that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forExprMIOnly(ExprMI that, RetType info_result, RetType expr_result) {
        return combine(that, info_result, expr_result);
    }

    public RetType forParenthesisDelimitedMIOnly(ParenthesisDelimitedMI that, RetType info_result, RetType expr_result) {
        return combine(that, info_result, expr_result);
    }

    public RetType forNonParenthesisDelimitedMIOnly(NonParenthesisDelimitedMI that, RetType info_result, RetType expr_result) {
        return combine(that, info_result, expr_result);
    }

    public RetType forNonExprMIOnly(NonExprMI that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forExponentiationMIOnly(ExponentiationMI that, RetType info_result, RetType op_result, Option<RetType> expr_result) {
        return combine(that, info_result, op_result, combine(expr_result));
    }

    public RetType forSubscriptingMIOnly(SubscriptingMI that, RetType info_result, RetType op_result, List<RetType> exprs_result, List<RetType> staticArgs_result) {
        return combine(that, info_result, op_result, combine(exprs_result), combine(staticArgs_result));
    }

    public RetType forOverloadingOnly(Overloading that, RetType info_result, RetType unambiguousName_result, RetType originalName_result, Option<RetType> type_result, Option<RetType> schema_result) {
        return combine(that, info_result, unambiguousName_result, originalName_result, combine(type_result), combine(schema_result));
    }

    public RetType forNonterminalHeaderOnly(NonterminalHeader that, RetType info_result, RetType name_result, List<RetType> params_result, List<RetType> staticParams_result, Option<RetType> paramType_result, Option<RetType> whereClause_result) {
        return combine(that, info_result, name_result, combine(params_result), combine(staticParams_result), combine(paramType_result), combine(whereClause_result));
    }

    public RetType forNonterminalParameterOnly(NonterminalParameter that, RetType info_result, RetType name_result, RetType paramType_result) {
        return combine(that, info_result, name_result, paramType_result);
    }

    public RetType forSyntaxDeclOnly(SyntaxDecl that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forSyntaxDefOnly(SyntaxDef that, RetType info_result, List<RetType> syntaxSymbols_result, RetType transformer_result) {
        return combine(that, info_result, combine(syntaxSymbols_result), transformer_result);
    }

    public RetType forSuperSyntaxDefOnly(SuperSyntaxDef that, RetType info_result, RetType nonterminal_result, RetType grammarId_result) {
        return combine(that, info_result, nonterminal_result, grammarId_result);
    }

    public RetType forTransformerDeclOnly(TransformerDecl that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forPreTransformerDefOnly(PreTransformerDef that, RetType info_result, RetType transformer_result) {
        return combine(that, info_result, transformer_result);
    }

    public RetType forNamedTransformerDefOnly(NamedTransformerDef that, RetType info_result, List<RetType> parameters_result, RetType transformer_result) {
        return combine(that, info_result, combine(parameters_result), transformer_result);
    }

    public RetType forTransformerOnly(Transformer that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forUnparsedTransformerOnly(UnparsedTransformer that, RetType info_result, RetType nonterminal_result) {
        return combine(that, info_result, nonterminal_result);
    }

    public RetType forNodeTransformerOnly(NodeTransformer that, RetType info_result, RetType node_result) {
        return combine(that, info_result, node_result);
    }

    public RetType forCaseTransformerOnly(CaseTransformer that, RetType info_result, RetType gapName_result, List<RetType> clauses_result) {
        return combine(that, info_result, gapName_result, combine(clauses_result));
    }

    public RetType forCaseTransformerClauseOnly(CaseTransformerClause that, RetType info_result, RetType constructor_result, List<RetType> parameters_result, RetType body_result) {
        return combine(that, info_result, constructor_result, combine(parameters_result), body_result);
    }

    public RetType forSyntaxSymbolOnly(SyntaxSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forPrefixedSymbolOnly(PrefixedSymbol that, RetType info_result, RetType id_result, RetType symbol_result) {
        return combine(that, info_result, id_result, symbol_result);
    }

    public RetType forOptionalSymbolOnly(OptionalSymbol that, RetType info_result, RetType symbol_result) {
        return combine(that, info_result, symbol_result);
    }

    public RetType forRepeatSymbolOnly(RepeatSymbol that, RetType info_result, RetType symbol_result) {
        return combine(that, info_result, symbol_result);
    }

    public RetType forRepeatOneOrMoreSymbolOnly(RepeatOneOrMoreSymbol that, RetType info_result, RetType symbol_result) {
        return combine(that, info_result, symbol_result);
    }

    public RetType forNoWhitespaceSymbolOnly(NoWhitespaceSymbol that, RetType info_result, RetType symbol_result) {
        return combine(that, info_result, symbol_result);
    }

    public RetType forGroupSymbolOnly(GroupSymbol that, RetType info_result, List<RetType> symbols_result) {
        return combine(that, info_result, combine(symbols_result));
    }

    public RetType forSpecialSymbolOnly(SpecialSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forAnyCharacterSymbolOnly(AnyCharacterSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forWhitespaceSymbolOnly(WhitespaceSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forTabSymbolOnly(TabSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forFormfeedSymbolOnly(FormfeedSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forCarriageReturnSymbolOnly(CarriageReturnSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forBackspaceSymbolOnly(BackspaceSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forNewlineSymbolOnly(NewlineSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forBreaklineSymbolOnly(BreaklineSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forItemSymbolOnly(ItemSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forNonterminalSymbolOnly(NonterminalSymbol that, RetType info_result, RetType nonterminal_result) {
        return combine(that, info_result, nonterminal_result);
    }

    public RetType forKeywordSymbolOnly(KeywordSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forTokenSymbolOnly(TokenSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forNotPredicateSymbolOnly(NotPredicateSymbol that, RetType info_result, RetType symbol_result) {
        return combine(that, info_result, symbol_result);
    }

    public RetType forAndPredicateSymbolOnly(AndPredicateSymbol that, RetType info_result, RetType symbol_result) {
        return combine(that, info_result, symbol_result);
    }

    public RetType forCharacterClassSymbolOnly(CharacterClassSymbol that, RetType info_result, List<RetType> characters_result) {
        return combine(that, info_result, combine(characters_result));
    }

    public RetType forCharacterSymbolOnly(CharacterSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forCharSymbolOnly(CharSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forCharacterIntervalOnly(CharacterInterval that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType forLinkOnly(Link that, RetType info_result, RetType op_result, RetType expr_result) {
        return combine(that, info_result, op_result, expr_result);
    }

    public RetType forInfoOnly(Info that) {
        return combine(that);
    }

    public RetType forInOutPhasesOnly(InOutPhases that) {
        return combine(that);
    }

    public RetType forInAfterTypeCheckingOnly(InAfterTypeChecking that) {
        return combine(that);
    }

    public RetType forOutAfterTypeCheckingOnly(OutAfterTypeChecking that) {
        return combine(that);
    }

    public RetType forLhsOnly(Lhs that) {
        return combine(that);
    }

    public RetType forTypeOrPatternOnly(TypeOrPattern that) {
        return combine(that);
    }

    public RetType forApplicableOnly(Applicable that, RetType header_result) {
        return combine(that, header_result);
    }

    public RetType forTypeVariableOnly(TypeVariable that) {
        return combine(that);
    }

    public RetType forTemplateGapOnly(TemplateGap that, RetType gapId_result, List<RetType> templateParams_result) {
        return combine(that, gapId_result, combine(templateParams_result));
    }

    public RetType for_SyntaxTransformationOnly(_SyntaxTransformation that) {
        return combine(that);
    }

    public RetType for_EllipsesOnly(_Ellipses that, RetType repeatedNode_result) {
        return combine(that, repeatedNode_result);
    }

    public RetType forInfoNodeOnly(InfoNode that) {
        return combine(that);
    }

    public RetType forDataNodeOnly(DataNode that) {
        return combine(that);
    }

    public RetType forGenericHeaderOnly(GenericHeader that, List<RetType> staticParams_result) {
        return combine(that, combine(staticParams_result));
    }

    public RetType forDeclHeaderOnly(DeclHeader that, List<RetType> staticParams_result, RetType name_result, Option<RetType> whereClause_result, Option<List<RetType>> throwsClause_result, Option<RetType> contract_result) {
        return combine(that, combine(staticParams_result), name_result, combine(whereClause_result), combineOptionList(throwsClause_result), combine(contract_result));
    }

    public RetType forTraitTypeHeaderOnly(TraitTypeHeader that, List<RetType> staticParams_result, RetType name_result, Option<RetType> whereClause_result, Option<List<RetType>> throwsClause_result, Option<RetType> contract_result, List<RetType> extendsClause_result, Option<List<RetType>> params_result, List<RetType> decls_result) {
        return combine(that, combine(staticParams_result), name_result, combine(whereClause_result), combineOptionList(throwsClause_result), combine(contract_result), combine(extendsClause_result), combineOptionList(params_result), combine(decls_result));
    }

    public RetType forFnHeaderOnly(FnHeader that, List<RetType> staticParams_result, RetType name_result, Option<RetType> whereClause_result, Option<List<RetType>> throwsClause_result, Option<RetType> contract_result, List<RetType> params_result, Option<RetType> returnType_result) {
        return combine(that, combine(staticParams_result), name_result, combine(whereClause_result), combineOptionList(throwsClause_result), combine(contract_result), combine(params_result), combine(returnType_result));
    }

    public RetType forASTNodeInfoOnly(ASTNodeInfo that) {
        return combine(that);
    }

    public RetType forSpanInfoOnly(SpanInfo that) {
        return combine(that);
    }

    public RetType forParenthesizedInfoOnly(ParenthesizedInfo that) {
        return combine(that);
    }

    public RetType forExprInfoOnly(ExprInfo that, Option<RetType> exprType_result) {
        return combine(that, combine(exprType_result));
    }

    public RetType forTypeInfoOnly(TypeInfo that, List<RetType> staticParams_result, Option<RetType> whereClause_result) {
        return combine(that, combine(staticParams_result), combine(whereClause_result));
    }

    public RetType forMethodInfoOnly(MethodInfo that, RetType selfType_result) {
        return combine(that, selfType_result);
    }

    public RetType forCompoundAssignmentInfoOnly(CompoundAssignmentInfo that, RetType opForLhs_result, Option<RetType> compoundCoercionOuter_result, Option<RetType> compoundCoercionInner_result) {
        return combine(that, opForLhs_result, combine(compoundCoercionOuter_result), combine(compoundCoercionInner_result));
    }

    public RetType forLevelOnly(Level that) {
        return combine(that);
    }

    public RetType forFixityOnly(Fixity that) {
        return combine(that);
    }

    public RetType forInFixityOnly(InFixity that) {
        return combine(that);
    }

    public RetType forPreFixityOnly(PreFixity that) {
        return combine(that);
    }

    public RetType forPostFixityOnly(PostFixity that) {
        return combine(that);
    }

    public RetType forNoFixityOnly(NoFixity that) {
        return combine(that);
    }

    public RetType forMultiFixityOnly(MultiFixity that) {
        return combine(that);
    }

    public RetType forEnclosingFixityOnly(EnclosingFixity that) {
        return combine(that);
    }

    public RetType forBigFixityOnly(BigFixity that) {
        return combine(that);
    }

    public RetType forUnknownFixityOnly(UnknownFixity that) {
        return combine(that);
    }

    public RetType forStaticParamKindOnly(StaticParamKind that) {
        return combine(that);
    }

    public RetType forKindTypeOnly(KindType that) {
        return combine(that);
    }

    public RetType forKindIntOnly(KindInt that) {
        return combine(that);
    }

    public RetType forKindNatOnly(KindNat that) {
        return combine(that);
    }

    public RetType forKindBoolOnly(KindBool that) {
        return combine(that);
    }

    public RetType forKindDimOnly(KindDim that) {
        return combine(that);
    }

    public RetType forKindUnitOnly(KindUnit that) {
        return combine(that);
    }

    public RetType forKindOpOnly(KindOp that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationAbstractNodeOnly(_SyntaxTransformationAbstractNode that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationCompilationUnitOnly(_SyntaxTransformationCompilationUnit that, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result, RetType info_result) {
        return combine(that, name_result, combine(imports_result), combine(decls_result), combine(comprises_result), info_result);
    }

    public RetType for_SyntaxTransformationComponentOnly(_SyntaxTransformationComponent that, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result, List<RetType> exports_result, RetType info_result) {
        return combine(that, name_result, combine(imports_result), combine(decls_result), combine(comprises_result), combine(exports_result), info_result);
    }

    public RetType for_SyntaxTransformationApiOnly(_SyntaxTransformationApi that, RetType name_result, List<RetType> imports_result, List<RetType> decls_result, List<RetType> comprises_result, RetType info_result) {
        return combine(that, name_result, combine(imports_result), combine(decls_result), combine(comprises_result), info_result);
    }

    public RetType for_SyntaxTransformationImportOnly(_SyntaxTransformationImport that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationImportedNamesOnly(_SyntaxTransformationImportedNames that, RetType apiName_result, RetType info_result) {
        return combine(that, apiName_result, info_result);
    }

    public RetType for_SyntaxTransformationImportStarOnly(_SyntaxTransformationImportStar that, RetType apiName_result, List<RetType> exceptNames_result, RetType info_result) {
        return combine(that, apiName_result, combine(exceptNames_result), info_result);
    }

    public RetType for_SyntaxTransformationImportNamesOnly(_SyntaxTransformationImportNames that, RetType apiName_result, List<RetType> aliasedNames_result, RetType info_result) {
        return combine(that, apiName_result, combine(aliasedNames_result), info_result);
    }

    public RetType for_SyntaxTransformationImportApiOnly(_SyntaxTransformationImportApi that, List<RetType> apis_result, RetType info_result) {
        return combine(that, combine(apis_result), info_result);
    }

    public RetType for_SyntaxTransformationAliasedSimpleNameOnly(_SyntaxTransformationAliasedSimpleName that, RetType name_result, Option<RetType> alias_result, RetType info_result) {
        return combine(that, name_result, combine(alias_result), info_result);
    }

    public RetType for_SyntaxTransformationAliasedAPINameOnly(_SyntaxTransformationAliasedAPIName that, RetType apiName_result, Option<RetType> alias_result, RetType info_result) {
        return combine(that, apiName_result, combine(alias_result), info_result);
    }

    public RetType for_SyntaxTransformationDeclOnly(_SyntaxTransformationDecl that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationTraitObjectDeclOnly(_SyntaxTransformationTraitObjectDecl that, RetType header_result, Option<RetType> selfType_result, RetType info_result) {
        return combine(that, header_result, combine(selfType_result), info_result);
    }

    public RetType for_SyntaxTransformationTraitDeclOnly(_SyntaxTransformationTraitDecl that, RetType header_result, Option<RetType> selfType_result, List<RetType> excludesClause_result, Option<List<RetType>> comprisesClause_result, RetType info_result) {
        return combine(that, header_result, combine(selfType_result), combine(excludesClause_result), combineOptionList(comprisesClause_result), info_result);
    }

    public RetType for_SyntaxTransformationObjectDeclOnly(_SyntaxTransformationObjectDecl that, RetType header_result, Option<RetType> selfType_result, RetType info_result) {
        return combine(that, header_result, combine(selfType_result), info_result);
    }

    public RetType for_SyntaxTransformationVarDeclOnly(_SyntaxTransformationVarDecl that, List<RetType> lhs_result, Option<RetType> init_result, RetType info_result) {
        return combine(that, combine(lhs_result), combine(init_result), info_result);
    }

    public RetType for_SyntaxTransformationFnDeclOnly(_SyntaxTransformationFnDecl that, RetType header_result, RetType unambiguousName_result, Option<RetType> body_result, Option<RetType> implementsUnambiguousName_result, RetType info_result) {
        return combine(that, header_result, unambiguousName_result, combine(body_result), combine(implementsUnambiguousName_result), info_result);
    }

    public RetType for_SyntaxTransformation_RewriteFnOverloadDeclOnly(_SyntaxTransformation_RewriteFnOverloadDecl that, RetType name_result, List<RetType> fns_result, Option<RetType> type_result, RetType info_result) {
        return combine(that, name_result, combine(fns_result), combine(type_result), info_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprDeclOnly(_SyntaxTransformation_RewriteObjectExprDecl that, List<RetType> objectExprs_result, RetType info_result) {
        return combine(that, combine(objectExprs_result), info_result);
    }

    public RetType for_SyntaxTransformation_RewriteFunctionalMethodDeclOnly(_SyntaxTransformation_RewriteFunctionalMethodDecl that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationDimUnitDeclOnly(_SyntaxTransformationDimUnitDecl that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationDimDeclOnly(_SyntaxTransformationDimDecl that, RetType dimId_result, Option<RetType> derived_result, Option<RetType> defaultId_result, RetType info_result) {
        return combine(that, dimId_result, combine(derived_result), combine(defaultId_result), info_result);
    }

    public RetType for_SyntaxTransformationUnitDeclOnly(_SyntaxTransformationUnitDecl that, List<RetType> units_result, Option<RetType> dimType_result, Option<RetType> defExpr_result, RetType info_result) {
        return combine(that, combine(units_result), combine(dimType_result), combine(defExpr_result), info_result);
    }

    public RetType for_SyntaxTransformationTestDeclOnly(_SyntaxTransformationTestDecl that, RetType name_result, List<RetType> gens_result, RetType expr_result, RetType info_result) {
        return combine(that, name_result, combine(gens_result), expr_result, info_result);
    }

    public RetType for_SyntaxTransformationPropertyDeclOnly(_SyntaxTransformationPropertyDecl that, Option<RetType> name_result, List<RetType> params_result, RetType expr_result, RetType info_result) {
        return combine(that, combine(name_result), combine(params_result), expr_result, info_result);
    }

    public RetType for_SyntaxTransformationTypeAliasOnly(_SyntaxTransformationTypeAlias that, RetType name_result, List<RetType> staticParams_result, RetType typeDef_result, RetType info_result) {
        return combine(that, name_result, combine(staticParams_result), typeDef_result, info_result);
    }

    public RetType for_SyntaxTransformationGrammarDeclOnly(_SyntaxTransformationGrammarDecl that, RetType name_result, List<RetType> extendsClause_result, List<RetType> members_result, List<RetType> transformers_result, RetType info_result) {
        return combine(that, name_result, combine(extendsClause_result), combine(members_result), combine(transformers_result), info_result);
    }

    public RetType for_SyntaxTransformationGrammarMemberDeclOnly(_SyntaxTransformationGrammarMemberDecl that, RetType name_result, RetType info_result) {
        return combine(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformationNonterminalDeclOnly(_SyntaxTransformationNonterminalDecl that, RetType name_result, List<RetType> syntaxDecls_result, RetType info_result) {
        return combine(that, name_result, combine(syntaxDecls_result), info_result);
    }

    public RetType for_SyntaxTransformationNonterminalDefOnly(_SyntaxTransformationNonterminalDef that, RetType name_result, List<RetType> syntaxDecls_result, RetType header_result, Option<RetType> astType_result, RetType info_result) {
        return combine(that, name_result, combine(syntaxDecls_result), header_result, combine(astType_result), info_result);
    }

    public RetType for_SyntaxTransformationNonterminalExtensionDefOnly(_SyntaxTransformationNonterminalExtensionDef that, RetType name_result, List<RetType> syntaxDecls_result, RetType info_result) {
        return combine(that, name_result, combine(syntaxDecls_result), info_result);
    }

    public RetType for_SyntaxTransformationBindingOnly(_SyntaxTransformationBinding that, RetType name_result, Option<RetType> idType_result, RetType info_result) {
        return combine(that, name_result, combine(idType_result), info_result);
    }

    public RetType for_SyntaxTransformationLValueOnly(_SyntaxTransformationLValue that, RetType name_result, Option<RetType> idType_result, RetType info_result) {
        return combine(that, name_result, combine(idType_result), info_result);
    }

    public RetType for_SyntaxTransformationParamOnly(_SyntaxTransformationParam that, RetType name_result, Option<RetType> idType_result, Option<RetType> defaultExpr_result, Option<RetType> varargsType_result, RetType info_result) {
        return combine(that, name_result, combine(idType_result), combine(defaultExpr_result), combine(varargsType_result), info_result);
    }

    public RetType for_SyntaxTransformationExprOnly(_SyntaxTransformationExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationDummyExprOnly(_SyntaxTransformationDummyExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationTypeAnnotatedExprOnly(_SyntaxTransformationTypeAnnotatedExpr that, RetType expr_result, RetType annType_result, RetType info_result) {
        return combine(that, expr_result, annType_result, info_result);
    }

    public RetType for_SyntaxTransformationAsExprOnly(_SyntaxTransformationAsExpr that, RetType expr_result, RetType annType_result, RetType info_result) {
        return combine(that, expr_result, annType_result, info_result);
    }

    public RetType for_SyntaxTransformationAsIfExprOnly(_SyntaxTransformationAsIfExpr that, RetType expr_result, RetType annType_result, RetType info_result) {
        return combine(that, expr_result, annType_result, info_result);
    }

    public RetType for_SyntaxTransformationAssignmentOnly(_SyntaxTransformationAssignment that, List<RetType> lhs_result, Option<RetType> assignOp_result, RetType rhs_result, List<RetType> assignmentInfos_result, RetType info_result) {
        return combine(that, combine(lhs_result), combine(assignOp_result), rhs_result, combine(assignmentInfos_result), info_result);
    }

    public RetType for_SyntaxTransformationBlockOnly(_SyntaxTransformationBlock that, Option<RetType> loc_result, List<RetType> exprs_result, RetType info_result) {
        return combine(that, combine(loc_result), combine(exprs_result), info_result);
    }

    public RetType for_SyntaxTransformationDoOnly(_SyntaxTransformationDo that, List<RetType> fronts_result, RetType info_result) {
        return combine(that, combine(fronts_result), info_result);
    }

    public RetType for_SyntaxTransformationCaseExprOnly(_SyntaxTransformationCaseExpr that, Option<RetType> param_result, Option<RetType> compare_result, RetType equalsOp_result, RetType inOp_result, List<RetType> clauses_result, Option<RetType> elseClause_result, RetType info_result) {
        return combine(that, combine(param_result), combine(compare_result), equalsOp_result, inOp_result, combine(clauses_result), combine(elseClause_result), info_result);
    }

    public RetType for_SyntaxTransformationIfOnly(_SyntaxTransformationIf that, List<RetType> clauses_result, Option<RetType> elseClause_result, RetType info_result) {
        return combine(that, combine(clauses_result), combine(elseClause_result), info_result);
    }

    public RetType for_SyntaxTransformationLabelOnly(_SyntaxTransformationLabel that, RetType name_result, RetType body_result, RetType info_result) {
        return combine(that, name_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationAbstractObjectExprOnly(_SyntaxTransformationAbstractObjectExpr that, RetType header_result, RetType info_result) {
        return combine(that, header_result, info_result);
    }

    public RetType for_SyntaxTransformationObjectExprOnly(_SyntaxTransformationObjectExpr that, RetType header_result, Option<RetType> selfType_result, RetType info_result) {
        return combine(that, header_result, combine(selfType_result), info_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprOnly(_SyntaxTransformation_RewriteObjectExpr that, RetType header_result, List<RetType> staticArgs_result, RetType info_result) {
        return combine(that, header_result, combine(staticArgs_result), info_result);
    }

    public RetType for_SyntaxTransformationTryOnly(_SyntaxTransformationTry that, RetType body_result, Option<RetType> catchClause_result, List<RetType> forbidClause_result, Option<RetType> finallyClause_result, RetType info_result) {
        return combine(that, body_result, combine(catchClause_result), combine(forbidClause_result), combine(finallyClause_result), info_result);
    }

    public RetType for_SyntaxTransformationTupleExprOnly(_SyntaxTransformationTupleExpr that, List<RetType> exprs_result, Option<RetType> varargs_result, List<RetType> keywords_result, RetType info_result) {
        return combine(that, combine(exprs_result), combine(varargs_result), combine(keywords_result), info_result);
    }

    public RetType for_SyntaxTransformationTypecaseOnly(_SyntaxTransformationTypecase that, RetType bindExpr_result, List<RetType> clauses_result, Option<RetType> elseClause_result, RetType info_result) {
        return combine(that, bindExpr_result, combine(clauses_result), combine(elseClause_result), info_result);
    }

    public RetType for_SyntaxTransformationWhileOnly(_SyntaxTransformationWhile that, RetType testExpr_result, RetType body_result, RetType info_result) {
        return combine(that, testExpr_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationForOnly(_SyntaxTransformationFor that, List<RetType> gens_result, RetType body_result, RetType info_result) {
        return combine(that, combine(gens_result), body_result, info_result);
    }

    public RetType for_SyntaxTransformationBigOpAppOnly(_SyntaxTransformationBigOpApp that, List<RetType> staticArgs_result, RetType info_result) {
        return combine(that, combine(staticArgs_result), info_result);
    }

    public RetType for_SyntaxTransformationAccumulatorOnly(_SyntaxTransformationAccumulator that, List<RetType> staticArgs_result, RetType accOp_result, List<RetType> gens_result, RetType body_result, RetType info_result) {
        return combine(that, combine(staticArgs_result), accOp_result, combine(gens_result), body_result, info_result);
    }

    public RetType for_SyntaxTransformationArrayComprehensionOnly(_SyntaxTransformationArrayComprehension that, List<RetType> staticArgs_result, List<RetType> clauses_result, RetType info_result) {
        return combine(that, combine(staticArgs_result), combine(clauses_result), info_result);
    }

    public RetType for_SyntaxTransformationAtomicExprOnly(_SyntaxTransformationAtomicExpr that, RetType expr_result, RetType info_result) {
        return combine(that, expr_result, info_result);
    }

    public RetType for_SyntaxTransformationExitOnly(_SyntaxTransformationExit that, Option<RetType> target_result, Option<RetType> returnExpr_result, RetType info_result) {
        return combine(that, combine(target_result), combine(returnExpr_result), info_result);
    }

    public RetType for_SyntaxTransformationSpawnOnly(_SyntaxTransformationSpawn that, RetType body_result, RetType info_result) {
        return combine(that, body_result, info_result);
    }

    public RetType for_SyntaxTransformationThrowOnly(_SyntaxTransformationThrow that, RetType expr_result, RetType info_result) {
        return combine(that, expr_result, info_result);
    }

    public RetType for_SyntaxTransformationTryAtomicExprOnly(_SyntaxTransformationTryAtomicExpr that, RetType expr_result, RetType info_result) {
        return combine(that, expr_result, info_result);
    }

    public RetType for_SyntaxTransformationFnExprOnly(_SyntaxTransformationFnExpr that, RetType header_result, RetType body_result, RetType info_result) {
        return combine(that, header_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationLetExprOnly(_SyntaxTransformationLetExpr that, RetType body_result, RetType info_result) {
        return combine(that, body_result, info_result);
    }

    public RetType for_SyntaxTransformationLetFnOnly(_SyntaxTransformationLetFn that, RetType body_result, List<RetType> fns_result, RetType info_result) {
        return combine(that, body_result, combine(fns_result), info_result);
    }

    public RetType for_SyntaxTransformationLocalVarDeclOnly(_SyntaxTransformationLocalVarDecl that, RetType body_result, List<RetType> lhs_result, Option<RetType> rhs_result, RetType info_result) {
        return combine(that, body_result, combine(lhs_result), combine(rhs_result), info_result);
    }

    public RetType for_SyntaxTransformationSimpleExprOnly(_SyntaxTransformationSimpleExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationSubscriptExprOnly(_SyntaxTransformationSubscriptExpr that, RetType obj_result, List<RetType> subs_result, Option<RetType> op_result, List<RetType> staticArgs_result, RetType info_result) {
        return combine(that, obj_result, combine(subs_result), combine(op_result), combine(staticArgs_result), info_result);
    }

    public RetType for_SyntaxTransformationPrimaryOnly(_SyntaxTransformationPrimary that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationLiteralExprOnly(_SyntaxTransformationLiteralExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationNumberLiteralExprOnly(_SyntaxTransformationNumberLiteralExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationFloatLiteralExprOnly(_SyntaxTransformationFloatLiteralExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationIntLiteralExprOnly(_SyntaxTransformationIntLiteralExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationCharLiteralExprOnly(_SyntaxTransformationCharLiteralExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationStringLiteralExprOnly(_SyntaxTransformationStringLiteralExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationVoidLiteralExprOnly(_SyntaxTransformationVoidLiteralExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationBooleanLiteralExprOnly(_SyntaxTransformationBooleanLiteralExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationVarRefOnly(_SyntaxTransformationVarRef that, RetType varId_result, List<RetType> staticArgs_result, RetType info_result) {
        return combine(that, varId_result, combine(staticArgs_result), info_result);
    }

    public RetType for_SyntaxTransformationFieldRefOnly(_SyntaxTransformationFieldRef that, RetType obj_result, RetType field_result, RetType info_result) {
        return combine(that, obj_result, field_result, info_result);
    }

    public RetType for_SyntaxTransformationFunctionalRefOnly(_SyntaxTransformationFunctionalRef that, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result, RetType info_result) {
        return combine(that, combine(staticArgs_result), originalName_result, combine(names_result), combine(interpOverloadings_result), combine(newOverloadings_result), combine(overloadingType_result), combine(overloadingSchema_result), info_result);
    }

    public RetType for_SyntaxTransformationFnRefOnly(_SyntaxTransformationFnRef that, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result, RetType info_result) {
        return combine(that, combine(staticArgs_result), originalName_result, combine(names_result), combine(interpOverloadings_result), combine(newOverloadings_result), combine(overloadingType_result), combine(overloadingSchema_result), info_result);
    }

    public RetType for_SyntaxTransformationOpRefOnly(_SyntaxTransformationOpRef that, List<RetType> staticArgs_result, RetType originalName_result, List<RetType> names_result, List<RetType> interpOverloadings_result, List<RetType> newOverloadings_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result, RetType info_result) {
        return combine(that, combine(staticArgs_result), originalName_result, combine(names_result), combine(interpOverloadings_result), combine(newOverloadings_result), combine(overloadingType_result), combine(overloadingSchema_result), info_result);
    }

    public RetType for_SyntaxTransformation_RewriteFnRefOnly(_SyntaxTransformation_RewriteFnRef that, RetType fnExpr_result, List<RetType> staticArgs_result, RetType info_result) {
        return combine(that, fnExpr_result, combine(staticArgs_result), info_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprRefOnly(_SyntaxTransformation_RewriteObjectExprRef that, List<RetType> staticArgs_result, RetType info_result) {
        return combine(that, combine(staticArgs_result), info_result);
    }

    public RetType for_SyntaxTransformationJuxtOnly(_SyntaxTransformationJuxt that, RetType multiJuxt_result, RetType infixJuxt_result, List<RetType> exprs_result, RetType info_result) {
        return combine(that, multiJuxt_result, infixJuxt_result, combine(exprs_result), info_result);
    }

    public RetType for_SyntaxTransformation_RewriteFnAppOnly(_SyntaxTransformation_RewriteFnApp that, RetType function_result, RetType argument_result, RetType info_result) {
        return combine(that, function_result, argument_result, info_result);
    }

    public RetType for_SyntaxTransformationOpExprOnly(_SyntaxTransformationOpExpr that, RetType op_result, List<RetType> args_result, RetType info_result) {
        return combine(that, op_result, combine(args_result), info_result);
    }

    public RetType for_SyntaxTransformationAmbiguousMultifixOpExprOnly(_SyntaxTransformationAmbiguousMultifixOpExpr that, RetType infix_op_result, RetType multifix_op_result, List<RetType> args_result, RetType info_result) {
        return combine(that, infix_op_result, multifix_op_result, combine(args_result), info_result);
    }

    public RetType for_SyntaxTransformationChainExprOnly(_SyntaxTransformationChainExpr that, RetType first_result, List<RetType> links_result, RetType info_result) {
        return combine(that, first_result, combine(links_result), info_result);
    }

    public RetType for_SyntaxTransformationCoercionInvocationOnly(_SyntaxTransformationCoercionInvocation that, RetType toType_result, RetType arg_result, RetType info_result) {
        return combine(that, toType_result, arg_result, info_result);
    }

    public RetType for_SyntaxTransformationTraitCoercionInvocationOnly(_SyntaxTransformationTraitCoercionInvocation that, RetType arg_result, RetType toType_result, RetType coercionFn_result, RetType info_result) {
        return combine(that, arg_result, toType_result, coercionFn_result, info_result);
    }

    public RetType for_SyntaxTransformationTupleCoercionInvocationOnly(_SyntaxTransformationTupleCoercionInvocation that, RetType arg_result, RetType toType_result, List<Option<RetType>> subCoercions_result, Option<Option<RetType>> varargCoercion_result, RetType info_result) {
        return combine(that, arg_result, toType_result, combineListOption(subCoercions_result), combineOptionOption(varargCoercion_result), info_result);
    }

    public RetType for_SyntaxTransformationArrowCoercionInvocationOnly(_SyntaxTransformationArrowCoercionInvocation that, RetType arg_result, RetType toType_result, Option<RetType> domainCoercion_result, Option<RetType> rangeCoercion_result, RetType info_result) {
        return combine(that, arg_result, toType_result, combine(domainCoercion_result), combine(rangeCoercion_result), info_result);
    }

    public RetType for_SyntaxTransformationUnionCoercionInvocationOnly(_SyntaxTransformationUnionCoercionInvocation that, RetType toType_result, RetType arg_result, List<RetType> fromTypes_result, List<Option<RetType>> fromCoercions_result, RetType info_result) {
        return combine(that, toType_result, arg_result, combine(fromTypes_result), combineListOption(fromCoercions_result), info_result);
    }

    public RetType for_SyntaxTransformationMethodInvocationOnly(_SyntaxTransformationMethodInvocation that, RetType obj_result, RetType method_result, List<RetType> staticArgs_result, RetType arg_result, Option<RetType> overloadingType_result, Option<RetType> overloadingSchema_result, RetType info_result) {
        return combine(that, obj_result, method_result, combine(staticArgs_result), arg_result, combine(overloadingType_result), combine(overloadingSchema_result), info_result);
    }

    public RetType for_SyntaxTransformationMathPrimaryOnly(_SyntaxTransformationMathPrimary that, RetType multiJuxt_result, RetType infixJuxt_result, RetType front_result, List<RetType> rest_result, RetType info_result) {
        return combine(that, multiJuxt_result, infixJuxt_result, front_result, combine(rest_result), info_result);
    }

    public RetType for_SyntaxTransformationArrayExprOnly(_SyntaxTransformationArrayExpr that, List<RetType> staticArgs_result, RetType info_result) {
        return combine(that, combine(staticArgs_result), info_result);
    }

    public RetType for_SyntaxTransformationArrayElementOnly(_SyntaxTransformationArrayElement that, List<RetType> staticArgs_result, RetType element_result, RetType info_result) {
        return combine(that, combine(staticArgs_result), element_result, info_result);
    }

    public RetType for_SyntaxTransformationArrayElementsOnly(_SyntaxTransformationArrayElements that, List<RetType> staticArgs_result, List<RetType> elements_result, RetType info_result) {
        return combine(that, combine(staticArgs_result), combine(elements_result), info_result);
    }

    public RetType for_SyntaxTransformationTypeOnly(_SyntaxTransformationType that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationBaseTypeOnly(_SyntaxTransformationBaseType that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationAnyTypeOnly(_SyntaxTransformationAnyType that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationBottomTypeOnly(_SyntaxTransformationBottomType that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationUnknownTypeOnly(_SyntaxTransformationUnknownType that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationSelfTypeOnly(_SyntaxTransformationSelfType that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationTraitSelfTypeOnly(_SyntaxTransformationTraitSelfType that, RetType named_result, List<RetType> comprised_result, RetType info_result) {
        return combine(that, named_result, combine(comprised_result), info_result);
    }

    public RetType for_SyntaxTransformationObjectExprTypeOnly(_SyntaxTransformationObjectExprType that, List<RetType> extended_result, RetType info_result) {
        return combine(that, combine(extended_result), info_result);
    }

    public RetType for_SyntaxTransformationNamedTypeOnly(_SyntaxTransformationNamedType that, RetType name_result, RetType info_result) {
        return combine(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformation_InferenceVarTypeOnly(_SyntaxTransformation_InferenceVarType that, RetType name_result, RetType info_result) {
        return combine(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformationVarTypeOnly(_SyntaxTransformationVarType that, RetType name_result, RetType info_result) {
        return combine(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformationTraitTypeOnly(_SyntaxTransformationTraitType that, RetType name_result, List<RetType> args_result, List<RetType> traitStaticParams_result, RetType info_result) {
        return combine(that, name_result, combine(args_result), combine(traitStaticParams_result), info_result);
    }

    public RetType for_SyntaxTransformationAbbreviatedTypeOnly(_SyntaxTransformationAbbreviatedType that, RetType elemType_result, RetType info_result) {
        return combine(that, elemType_result, info_result);
    }

    public RetType for_SyntaxTransformationArrayTypeOnly(_SyntaxTransformationArrayType that, RetType elemType_result, RetType indices_result, RetType info_result) {
        return combine(that, elemType_result, indices_result, info_result);
    }

    public RetType for_SyntaxTransformationMatrixTypeOnly(_SyntaxTransformationMatrixType that, RetType elemType_result, List<RetType> dimensions_result, RetType info_result) {
        return combine(that, elemType_result, combine(dimensions_result), info_result);
    }

    public RetType for_SyntaxTransformationTaggedDimTypeOnly(_SyntaxTransformationTaggedDimType that, RetType elemType_result, RetType dimExpr_result, Option<RetType> unitExpr_result, RetType info_result) {
        return combine(that, elemType_result, dimExpr_result, combine(unitExpr_result), info_result);
    }

    public RetType for_SyntaxTransformationTaggedUnitTypeOnly(_SyntaxTransformationTaggedUnitType that, RetType elemType_result, RetType unitExpr_result, RetType info_result) {
        return combine(that, elemType_result, unitExpr_result, info_result);
    }

    public RetType for_SyntaxTransformationTupleTypeOnly(_SyntaxTransformationTupleType that, List<RetType> elements_result, Option<RetType> varargs_result, List<RetType> keywords_result, RetType info_result) {
        return combine(that, combine(elements_result), combine(varargs_result), combine(keywords_result), info_result);
    }

    public RetType for_SyntaxTransformationArrowTypeOnly(_SyntaxTransformationArrowType that, RetType domain_result, RetType range_result, RetType effect_result, Option<RetType> methodInfo_result, RetType info_result) {
        return combine(that, domain_result, range_result, effect_result, combine(methodInfo_result), info_result);
    }

    public RetType for_SyntaxTransformationBoundTypeOnly(_SyntaxTransformationBoundType that, List<RetType> elements_result, RetType info_result) {
        return combine(that, combine(elements_result), info_result);
    }

    public RetType for_SyntaxTransformationIntersectionTypeOnly(_SyntaxTransformationIntersectionType that, List<RetType> elements_result, RetType info_result) {
        return combine(that, combine(elements_result), info_result);
    }

    public RetType for_SyntaxTransformationUnionTypeOnly(_SyntaxTransformationUnionType that, List<RetType> elements_result, RetType info_result) {
        return combine(that, combine(elements_result), info_result);
    }

    public RetType for_SyntaxTransformationFixedPointTypeOnly(_SyntaxTransformationFixedPointType that, RetType name_result, RetType body_result, RetType info_result) {
        return combine(that, name_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationLabelTypeOnly(_SyntaxTransformationLabelType that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationDimExprOnly(_SyntaxTransformationDimExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationDimBaseOnly(_SyntaxTransformationDimBase that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationDimRefOnly(_SyntaxTransformationDimRef that, RetType name_result, RetType info_result) {
        return combine(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformationDimExponentOnly(_SyntaxTransformationDimExponent that, RetType base_result, RetType power_result, RetType info_result) {
        return combine(that, base_result, power_result, info_result);
    }

    public RetType for_SyntaxTransformationDimUnaryOpOnly(_SyntaxTransformationDimUnaryOp that, RetType dimVal_result, RetType op_result, RetType info_result) {
        return combine(that, dimVal_result, op_result, info_result);
    }

    public RetType for_SyntaxTransformationDimBinaryOpOnly(_SyntaxTransformationDimBinaryOp that, RetType left_result, RetType right_result, RetType op_result, RetType info_result) {
        return combine(that, left_result, right_result, op_result, info_result);
    }

    public RetType for_SyntaxTransformationPatternOnly(_SyntaxTransformationPattern that, Option<RetType> name_result, RetType patterns_result, RetType info_result) {
        return combine(that, combine(name_result), patterns_result, info_result);
    }

    public RetType for_SyntaxTransformationPatternArgsOnly(_SyntaxTransformationPatternArgs that, List<RetType> patterns_result, RetType info_result) {
        return combine(that, combine(patterns_result), info_result);
    }

    public RetType for_SyntaxTransformationPatternBindingOnly(_SyntaxTransformationPatternBinding that, Option<RetType> field_result, RetType info_result) {
        return combine(that, combine(field_result), info_result);
    }

    public RetType for_SyntaxTransformationPlainPatternOnly(_SyntaxTransformationPlainPattern that, Option<RetType> field_result, RetType name_result, Option<RetType> idType_result, RetType info_result) {
        return combine(that, combine(field_result), name_result, combine(idType_result), info_result);
    }

    public RetType for_SyntaxTransformationTypePatternOnly(_SyntaxTransformationTypePattern that, Option<RetType> field_result, RetType typ_result, RetType info_result) {
        return combine(that, combine(field_result), typ_result, info_result);
    }

    public RetType for_SyntaxTransformationNestedPatternOnly(_SyntaxTransformationNestedPattern that, Option<RetType> field_result, RetType pat_result, RetType info_result) {
        return combine(that, combine(field_result), pat_result, info_result);
    }

    public RetType for_SyntaxTransformationStaticArgOnly(_SyntaxTransformationStaticArg that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationTypeArgOnly(_SyntaxTransformationTypeArg that, RetType typeArg_result, RetType info_result) {
        return combine(that, typeArg_result, info_result);
    }

    public RetType for_SyntaxTransformationIntArgOnly(_SyntaxTransformationIntArg that, RetType intVal_result, RetType info_result) {
        return combine(that, intVal_result, info_result);
    }

    public RetType for_SyntaxTransformationBoolArgOnly(_SyntaxTransformationBoolArg that, RetType boolArg_result, RetType info_result) {
        return combine(that, boolArg_result, info_result);
    }

    public RetType for_SyntaxTransformationOpArgOnly(_SyntaxTransformationOpArg that, RetType id_result, RetType info_result) {
        return combine(that, id_result, info_result);
    }

    public RetType for_SyntaxTransformationDimArgOnly(_SyntaxTransformationDimArg that, RetType dimArg_result, RetType info_result) {
        return combine(that, dimArg_result, info_result);
    }

    public RetType for_SyntaxTransformationUnitArgOnly(_SyntaxTransformationUnitArg that, RetType unitArg_result, RetType info_result) {
        return combine(that, unitArg_result, info_result);
    }

    public RetType for_SyntaxTransformationStaticExprOnly(_SyntaxTransformationStaticExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationIntExprOnly(_SyntaxTransformationIntExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationIntBaseOnly(_SyntaxTransformationIntBase that, RetType intVal_result, RetType info_result) {
        return combine(that, intVal_result, info_result);
    }

    public RetType for_SyntaxTransformationIntRefOnly(_SyntaxTransformationIntRef that, RetType name_result, RetType info_result) {
        return combine(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformationIntBinaryOpOnly(_SyntaxTransformationIntBinaryOp that, RetType left_result, RetType right_result, RetType op_result, RetType info_result) {
        return combine(that, left_result, right_result, op_result, info_result);
    }

    public RetType for_SyntaxTransformationBoolExprOnly(_SyntaxTransformationBoolExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationBoolBaseOnly(_SyntaxTransformationBoolBase that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationBoolRefOnly(_SyntaxTransformationBoolRef that, RetType name_result, RetType info_result) {
        return combine(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformationBoolConstraintOnly(_SyntaxTransformationBoolConstraint that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationBoolUnaryOpOnly(_SyntaxTransformationBoolUnaryOp that, RetType boolVal_result, RetType op_result, RetType info_result) {
        return combine(that, boolVal_result, op_result, info_result);
    }

    public RetType for_SyntaxTransformationBoolBinaryOpOnly(_SyntaxTransformationBoolBinaryOp that, RetType left_result, RetType right_result, RetType op_result, RetType info_result) {
        return combine(that, left_result, right_result, op_result, info_result);
    }

    public RetType for_SyntaxTransformationUnitExprOnly(_SyntaxTransformationUnitExpr that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationUnitRefOnly(_SyntaxTransformationUnitRef that, RetType name_result, RetType info_result) {
        return combine(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformationUnitBinaryOpOnly(_SyntaxTransformationUnitBinaryOp that, RetType left_result, RetType right_result, RetType op_result, RetType info_result) {
        return combine(that, left_result, right_result, op_result, info_result);
    }

    public RetType for_SyntaxTransformationEffectOnly(_SyntaxTransformationEffect that, Option<List<RetType>> throwsClause_result, RetType info_result) {
        return combine(that, combineOptionList(throwsClause_result), info_result);
    }

    public RetType for_SyntaxTransformationWhereClauseOnly(_SyntaxTransformationWhereClause that, List<RetType> bindings_result, List<RetType> constraints_result, RetType info_result) {
        return combine(that, combine(bindings_result), combine(constraints_result), info_result);
    }

    public RetType for_SyntaxTransformationWhereBindingOnly(_SyntaxTransformationWhereBinding that, RetType name_result, List<RetType> supers_result, RetType kind_result, RetType info_result) {
        return combine(that, name_result, combine(supers_result), kind_result, info_result);
    }

    public RetType for_SyntaxTransformationWhereConstraintOnly(_SyntaxTransformationWhereConstraint that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationWhereExtendsOnly(_SyntaxTransformationWhereExtends that, RetType name_result, List<RetType> supers_result, RetType info_result) {
        return combine(that, name_result, combine(supers_result), info_result);
    }

    public RetType for_SyntaxTransformationWhereTypeAliasOnly(_SyntaxTransformationWhereTypeAlias that, RetType alias_result, RetType info_result) {
        return combine(that, alias_result, info_result);
    }

    public RetType for_SyntaxTransformationWhereCoercesOnly(_SyntaxTransformationWhereCoerces that, RetType left_result, RetType right_result, RetType info_result) {
        return combine(that, left_result, right_result, info_result);
    }

    public RetType for_SyntaxTransformationWhereEqualsOnly(_SyntaxTransformationWhereEquals that, RetType left_result, RetType right_result, RetType info_result) {
        return combine(that, left_result, right_result, info_result);
    }

    public RetType for_SyntaxTransformationUnitConstraintOnly(_SyntaxTransformationUnitConstraint that, RetType name_result, RetType info_result) {
        return combine(that, name_result, info_result);
    }

    public RetType for_SyntaxTransformationIntConstraintOnly(_SyntaxTransformationIntConstraint that, RetType left_result, RetType right_result, RetType op_result, RetType info_result) {
        return combine(that, left_result, right_result, op_result, info_result);
    }

    public RetType for_SyntaxTransformationBoolConstraintExprOnly(_SyntaxTransformationBoolConstraintExpr that, RetType constraint_result, RetType info_result) {
        return combine(that, constraint_result, info_result);
    }

    public RetType for_SyntaxTransformationContractOnly(_SyntaxTransformationContract that, Option<List<RetType>> requiresClause_result, Option<List<RetType>> ensuresClause_result, Option<List<RetType>> invariantsClause_result, RetType info_result) {
        return combine(that, combineOptionList(requiresClause_result), combineOptionList(ensuresClause_result), combineOptionList(invariantsClause_result), info_result);
    }

    public RetType for_SyntaxTransformationEnsuresClauseOnly(_SyntaxTransformationEnsuresClause that, RetType post_result, Option<RetType> pre_result, RetType info_result) {
        return combine(that, post_result, combine(pre_result), info_result);
    }

    public RetType for_SyntaxTransformationStaticParamOnly(_SyntaxTransformationStaticParam that, RetType name_result, List<RetType> extendsClause_result, List<RetType> dominatesClause_result, Option<RetType> dimParam_result, RetType kind_result, RetType info_result) {
        return combine(that, name_result, combine(extendsClause_result), combine(dominatesClause_result), combine(dimParam_result), kind_result, info_result);
    }

    public RetType for_SyntaxTransformationNameOnly(_SyntaxTransformationName that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationAPINameOnly(_SyntaxTransformationAPIName that, List<RetType> ids_result, RetType info_result) {
        return combine(that, combine(ids_result), info_result);
    }

    public RetType for_SyntaxTransformationIdOrOpOrAnonymousNameOnly(_SyntaxTransformationIdOrOpOrAnonymousName that, Option<RetType> apiName_result, RetType info_result) {
        return combine(that, combine(apiName_result), info_result);
    }

    public RetType for_SyntaxTransformationIdOrOpOnly(_SyntaxTransformationIdOrOp that, Option<RetType> apiName_result, RetType info_result) {
        return combine(that, combine(apiName_result), info_result);
    }

    public RetType for_SyntaxTransformationIdOnly(_SyntaxTransformationId that, Option<RetType> apiName_result, RetType info_result) {
        return combine(that, combine(apiName_result), info_result);
    }

    public RetType for_SyntaxTransformationOpOnly(_SyntaxTransformationOp that, Option<RetType> apiName_result, RetType fixity_result, RetType info_result) {
        return combine(that, combine(apiName_result), fixity_result, info_result);
    }

    public RetType for_SyntaxTransformationNamedOpOnly(_SyntaxTransformationNamedOp that, Option<RetType> apiName_result, RetType fixity_result, RetType info_result) {
        return combine(that, combine(apiName_result), fixity_result, info_result);
    }

    public RetType for_SyntaxTransformation_InferenceVarOpOnly(_SyntaxTransformation_InferenceVarOp that, Option<RetType> apiName_result, RetType fixity_result, RetType info_result) {
        return combine(that, combine(apiName_result), fixity_result, info_result);
    }

    public RetType for_SyntaxTransformationAnonymousNameOnly(_SyntaxTransformationAnonymousName that, Option<RetType> apiName_result, RetType info_result) {
        return combine(that, combine(apiName_result), info_result);
    }

    public RetType for_SyntaxTransformationAnonymousFnNameOnly(_SyntaxTransformationAnonymousFnName that, Option<RetType> apiName_result, RetType info_result) {
        return combine(that, combine(apiName_result), info_result);
    }

    public RetType for_SyntaxTransformationConstructorFnNameOnly(_SyntaxTransformationConstructorFnName that, Option<RetType> apiName_result, RetType constructor_result, RetType info_result) {
        return combine(that, combine(apiName_result), constructor_result, info_result);
    }

    public RetType for_SyntaxTransformationArrayComprehensionClauseOnly(_SyntaxTransformationArrayComprehensionClause that, List<RetType> bind_result, RetType init_result, List<RetType> gens_result, RetType info_result) {
        return combine(that, combine(bind_result), init_result, combine(gens_result), info_result);
    }

    public RetType for_SyntaxTransformationKeywordExprOnly(_SyntaxTransformationKeywordExpr that, RetType name_result, RetType init_result, RetType info_result) {
        return combine(that, name_result, init_result, info_result);
    }

    public RetType for_SyntaxTransformationCaseClauseOnly(_SyntaxTransformationCaseClause that, RetType matchClause_result, RetType body_result, Option<RetType> op_result, RetType info_result) {
        return combine(that, matchClause_result, body_result, combine(op_result), info_result);
    }

    public RetType for_SyntaxTransformationCatchOnly(_SyntaxTransformationCatch that, RetType name_result, List<RetType> clauses_result, RetType info_result) {
        return combine(that, name_result, combine(clauses_result), info_result);
    }

    public RetType for_SyntaxTransformationCatchClauseOnly(_SyntaxTransformationCatchClause that, RetType matchType_result, RetType body_result, RetType info_result) {
        return combine(that, matchType_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationIfClauseOnly(_SyntaxTransformationIfClause that, RetType testClause_result, RetType body_result, RetType info_result) {
        return combine(that, testClause_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationTypecaseClauseOnly(_SyntaxTransformationTypecaseClause that, Option<RetType> name_result, RetType matchType_result, RetType body_result, RetType info_result) {
        return combine(that, combine(name_result), matchType_result, body_result, info_result);
    }

    public RetType for_SyntaxTransformationExtentRangeOnly(_SyntaxTransformationExtentRange that, Option<RetType> base_result, Option<RetType> size_result, Option<RetType> op_result, RetType info_result) {
        return combine(that, combine(base_result), combine(size_result), combine(op_result), info_result);
    }

    public RetType for_SyntaxTransformationGeneratorClauseOnly(_SyntaxTransformationGeneratorClause that, List<RetType> bind_result, RetType init_result, RetType info_result) {
        return combine(that, combine(bind_result), init_result, info_result);
    }

    public RetType for_SyntaxTransformationKeywordTypeOnly(_SyntaxTransformationKeywordType that, RetType name_result, RetType keywordType_result, RetType info_result) {
        return combine(that, name_result, keywordType_result, info_result);
    }

    public RetType for_SyntaxTransformationTraitTypeWhereOnly(_SyntaxTransformationTraitTypeWhere that, RetType baseType_result, Option<RetType> whereClause_result, RetType info_result) {
        return combine(that, baseType_result, combine(whereClause_result), info_result);
    }

    public RetType for_SyntaxTransformationIndicesOnly(_SyntaxTransformationIndices that, List<RetType> extents_result, RetType info_result) {
        return combine(that, combine(extents_result), info_result);
    }

    public RetType for_SyntaxTransformationMathItemOnly(_SyntaxTransformationMathItem that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationExprMIOnly(_SyntaxTransformationExprMI that, RetType expr_result, RetType info_result) {
        return combine(that, expr_result, info_result);
    }

    public RetType for_SyntaxTransformationParenthesisDelimitedMIOnly(_SyntaxTransformationParenthesisDelimitedMI that, RetType expr_result, RetType info_result) {
        return combine(that, expr_result, info_result);
    }

    public RetType for_SyntaxTransformationNonParenthesisDelimitedMIOnly(_SyntaxTransformationNonParenthesisDelimitedMI that, RetType expr_result, RetType info_result) {
        return combine(that, expr_result, info_result);
    }

    public RetType for_SyntaxTransformationNonExprMIOnly(_SyntaxTransformationNonExprMI that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationExponentiationMIOnly(_SyntaxTransformationExponentiationMI that, RetType op_result, Option<RetType> expr_result, RetType info_result) {
        return combine(that, op_result, combine(expr_result), info_result);
    }

    public RetType for_SyntaxTransformationSubscriptingMIOnly(_SyntaxTransformationSubscriptingMI that, RetType op_result, List<RetType> exprs_result, List<RetType> staticArgs_result, RetType info_result) {
        return combine(that, op_result, combine(exprs_result), combine(staticArgs_result), info_result);
    }

    public RetType for_SyntaxTransformationOverloadingOnly(_SyntaxTransformationOverloading that, RetType unambiguousName_result, RetType originalName_result, Option<RetType> type_result, Option<RetType> schema_result, RetType info_result) {
        return combine(that, unambiguousName_result, originalName_result, combine(type_result), combine(schema_result), info_result);
    }

    public RetType for_SyntaxTransformationNonterminalHeaderOnly(_SyntaxTransformationNonterminalHeader that, RetType name_result, List<RetType> params_result, List<RetType> staticParams_result, Option<RetType> paramType_result, Option<RetType> whereClause_result, RetType info_result) {
        return combine(that, name_result, combine(params_result), combine(staticParams_result), combine(paramType_result), combine(whereClause_result), info_result);
    }

    public RetType for_SyntaxTransformationNonterminalParameterOnly(_SyntaxTransformationNonterminalParameter that, RetType name_result, RetType paramType_result, RetType info_result) {
        return combine(that, name_result, paramType_result, info_result);
    }

    public RetType for_SyntaxTransformationSyntaxDeclOnly(_SyntaxTransformationSyntaxDecl that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationSyntaxDefOnly(_SyntaxTransformationSyntaxDef that, List<RetType> syntaxSymbols_result, RetType transformer_result, RetType info_result) {
        return combine(that, combine(syntaxSymbols_result), transformer_result, info_result);
    }

    public RetType for_SyntaxTransformationSuperSyntaxDefOnly(_SyntaxTransformationSuperSyntaxDef that, RetType nonterminal_result, RetType grammarId_result, RetType info_result) {
        return combine(that, nonterminal_result, grammarId_result, info_result);
    }

    public RetType for_SyntaxTransformationTransformerDeclOnly(_SyntaxTransformationTransformerDecl that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationPreTransformerDefOnly(_SyntaxTransformationPreTransformerDef that, RetType transformer_result, RetType info_result) {
        return combine(that, transformer_result, info_result);
    }

    public RetType for_SyntaxTransformationNamedTransformerDefOnly(_SyntaxTransformationNamedTransformerDef that, List<RetType> parameters_result, RetType transformer_result, RetType info_result) {
        return combine(that, combine(parameters_result), transformer_result, info_result);
    }

    public RetType for_SyntaxTransformationTransformerOnly(_SyntaxTransformationTransformer that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationUnparsedTransformerOnly(_SyntaxTransformationUnparsedTransformer that, RetType nonterminal_result, RetType info_result) {
        return combine(that, nonterminal_result, info_result);
    }

    public RetType for_SyntaxTransformationNodeTransformerOnly(_SyntaxTransformationNodeTransformer that, RetType node_result, RetType info_result) {
        return combine(that, node_result, info_result);
    }

    public RetType for_SyntaxTransformationCaseTransformerOnly(_SyntaxTransformationCaseTransformer that, RetType gapName_result, List<RetType> clauses_result, RetType info_result) {
        return combine(that, gapName_result, combine(clauses_result), info_result);
    }

    public RetType for_SyntaxTransformationCaseTransformerClauseOnly(_SyntaxTransformationCaseTransformerClause that, RetType constructor_result, List<RetType> parameters_result, RetType body_result, RetType info_result) {
        return combine(that, constructor_result, combine(parameters_result), body_result, info_result);
    }

    public RetType for_SyntaxTransformationSyntaxSymbolOnly(_SyntaxTransformationSyntaxSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationPrefixedSymbolOnly(_SyntaxTransformationPrefixedSymbol that, RetType id_result, RetType symbol_result, RetType info_result) {
        return combine(that, id_result, symbol_result, info_result);
    }

    public RetType for_SyntaxTransformationOptionalSymbolOnly(_SyntaxTransformationOptionalSymbol that, RetType symbol_result, RetType info_result) {
        return combine(that, symbol_result, info_result);
    }

    public RetType for_SyntaxTransformationRepeatSymbolOnly(_SyntaxTransformationRepeatSymbol that, RetType symbol_result, RetType info_result) {
        return combine(that, symbol_result, info_result);
    }

    public RetType for_SyntaxTransformationRepeatOneOrMoreSymbolOnly(_SyntaxTransformationRepeatOneOrMoreSymbol that, RetType symbol_result, RetType info_result) {
        return combine(that, symbol_result, info_result);
    }

    public RetType for_SyntaxTransformationNoWhitespaceSymbolOnly(_SyntaxTransformationNoWhitespaceSymbol that, RetType symbol_result, RetType info_result) {
        return combine(that, symbol_result, info_result);
    }

    public RetType for_SyntaxTransformationGroupSymbolOnly(_SyntaxTransformationGroupSymbol that, List<RetType> symbols_result, RetType info_result) {
        return combine(that, combine(symbols_result), info_result);
    }

    public RetType for_SyntaxTransformationSpecialSymbolOnly(_SyntaxTransformationSpecialSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationAnyCharacterSymbolOnly(_SyntaxTransformationAnyCharacterSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationWhitespaceSymbolOnly(_SyntaxTransformationWhitespaceSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationTabSymbolOnly(_SyntaxTransformationTabSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationFormfeedSymbolOnly(_SyntaxTransformationFormfeedSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationCarriageReturnSymbolOnly(_SyntaxTransformationCarriageReturnSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationBackspaceSymbolOnly(_SyntaxTransformationBackspaceSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationNewlineSymbolOnly(_SyntaxTransformationNewlineSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationBreaklineSymbolOnly(_SyntaxTransformationBreaklineSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationItemSymbolOnly(_SyntaxTransformationItemSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationNonterminalSymbolOnly(_SyntaxTransformationNonterminalSymbol that, RetType nonterminal_result, RetType info_result) {
        return combine(that, nonterminal_result, info_result);
    }

    public RetType for_SyntaxTransformationKeywordSymbolOnly(_SyntaxTransformationKeywordSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationTokenSymbolOnly(_SyntaxTransformationTokenSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationNotPredicateSymbolOnly(_SyntaxTransformationNotPredicateSymbol that, RetType symbol_result, RetType info_result) {
        return combine(that, symbol_result, info_result);
    }

    public RetType for_SyntaxTransformationAndPredicateSymbolOnly(_SyntaxTransformationAndPredicateSymbol that, RetType symbol_result, RetType info_result) {
        return combine(that, symbol_result, info_result);
    }

    public RetType for_SyntaxTransformationCharacterClassSymbolOnly(_SyntaxTransformationCharacterClassSymbol that, List<RetType> characters_result, RetType info_result) {
        return combine(that, combine(characters_result), info_result);
    }

    public RetType for_SyntaxTransformationCharacterSymbolOnly(_SyntaxTransformationCharacterSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationCharSymbolOnly(_SyntaxTransformationCharSymbol that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationCharacterIntervalOnly(_SyntaxTransformationCharacterInterval that, RetType info_result) {
        return combine(that, info_result);
    }

    public RetType for_SyntaxTransformationLinkOnly(_SyntaxTransformationLink that, RetType op_result, RetType expr_result, RetType info_result) {
        return combine(that, op_result, expr_result, info_result);
    }

    public abstract RetType combine(List<RetType> l);

    public RetType combine(Node that, RetType... vals) {
        return combine(vals);
    }

    public RetType combine(RetType... vals) {
        List<RetType> l = new java.util.ArrayList(vals.length);
        for (int i=0; i < vals.length; i++) l.add(vals[i]);
        return combine(l);
    }

    public RetType combineOptionList(Option<List<RetType>> v) {
        if (v.isSome()) return combine(v.unwrap());
        return combine();
    }

    public RetType combine(Option<RetType> v) {
        if (v.isSome()) return v.unwrap();
        return combine();
    }

    public RetType combineOptionOption(Option<Option<RetType>> v) {
        if (v.isSome()) return combine(v.unwrap());
        return combine();
    }

    public RetType combineListOption(List<Option<RetType>> v) {
        ArrayList<RetType> t = new ArrayList<RetType>();
        for (Option<RetType> e : v) t.add(combine(e));
        return combine(t);
    }

}
