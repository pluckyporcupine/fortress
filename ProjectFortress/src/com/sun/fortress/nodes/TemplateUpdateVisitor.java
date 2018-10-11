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
 * If a template node is visited then the handleTemplate method is called as the first thing of a visit.
 * 
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
@SuppressWarnings(value={"unused"})
public abstract class TemplateUpdateVisitor extends NodeVisitorLambda<Node> {

    /* Methods to handle a node after recursion. */

    public Node forComponentOnly(Component that, ASTNodeInfo info_result, APIName name_result, List<Import> imports_result, List<Decl> decls_result, List<APIName> comprises_result, List<APIName> exports_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getImports() == imports_result && that.getDecls() == decls_result && that.getComprises() == comprises_result && that.getExports() == exports_result) return that;
        else return new Component(info_result, name_result, imports_result, decls_result, comprises_result, that.is_native(), exports_result);
    }

    public Node forApiOnly(Api that, ASTNodeInfo info_result, APIName name_result, List<Import> imports_result, List<Decl> decls_result, List<APIName> comprises_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getImports() == imports_result && that.getDecls() == decls_result && that.getComprises() == comprises_result) return that;
        else return new Api(info_result, name_result, imports_result, decls_result, comprises_result);
    }

    public Node forImportStarOnly(ImportStar that, ASTNodeInfo info_result, APIName apiName_result, List<IdOrOpOrAnonymousName> exceptNames_result) {
        if (that.getInfo() == info_result && that.getApiName() == apiName_result && that.getExceptNames() == exceptNames_result) return that;
        else return new ImportStar(info_result, that.getForeignLanguage(), apiName_result, exceptNames_result);
    }

    public Node forImportNamesOnly(ImportNames that, ASTNodeInfo info_result, APIName apiName_result, List<AliasedSimpleName> aliasedNames_result) {
        if (that.getInfo() == info_result && that.getApiName() == apiName_result && that.getAliasedNames() == aliasedNames_result) return that;
        else return new ImportNames(info_result, that.getForeignLanguage(), apiName_result, aliasedNames_result);
    }

    public Node forImportApiOnly(ImportApi that, ASTNodeInfo info_result, List<AliasedAPIName> apis_result) {
        if (that.getInfo() == info_result && that.getApis() == apis_result) return that;
        else return new ImportApi(info_result, that.getForeignLanguage(), apis_result);
    }

    public Node forAliasedSimpleNameOnly(AliasedSimpleName that, ASTNodeInfo info_result, IdOrOpOrAnonymousName name_result, Option<IdOrOpOrAnonymousName> alias_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getAlias() == alias_result) return that;
        else return new AliasedSimpleName(info_result, name_result, alias_result);
    }

    public Node forAliasedAPINameOnly(AliasedAPIName that, ASTNodeInfo info_result, APIName apiName_result, Option<Id> alias_result) {
        if (that.getInfo() == info_result && that.getApiName() == apiName_result && that.getAlias() == alias_result) return that;
        else return new AliasedAPIName(info_result, apiName_result, alias_result);
    }

    public Node forTraitDeclOnly(TraitDecl that, ASTNodeInfo info_result, TraitTypeHeader header_result, Option<SelfType> selfType_result, List<BaseType> excludesClause_result, Option<List<NamedType>> comprisesClause_result) {
        if (that.getInfo() == info_result && that.getHeader() == header_result && that.getSelfType() == selfType_result && that.getExcludesClause() == excludesClause_result && that.getComprisesClause() == comprisesClause_result) return that;
        else return new TraitDecl(info_result, header_result, selfType_result, excludesClause_result, comprisesClause_result, that.isComprisesEllipses());
    }

    public Node forObjectDeclOnly(ObjectDecl that, ASTNodeInfo info_result, TraitTypeHeader header_result, Option<SelfType> selfType_result) {
        if (that.getInfo() == info_result && that.getHeader() == header_result && that.getSelfType() == selfType_result) return that;
        else return new ObjectDecl(info_result, header_result, selfType_result);
    }

    public Node forVarDeclOnly(VarDecl that, ASTNodeInfo info_result, List<LValue> lhs_result, Option<Expr> init_result) {
        if (that.getInfo() == info_result && that.getLhs() == lhs_result && that.getInit() == init_result) return that;
        else return new VarDecl(info_result, lhs_result, init_result);
    }

    public Node forFnDeclOnly(FnDecl that, ASTNodeInfo info_result, FnHeader header_result, IdOrOp unambiguousName_result, Option<Expr> body_result, Option<IdOrOp> implementsUnambiguousName_result) {
        if (that.getInfo() == info_result && that.getHeader() == header_result && that.getUnambiguousName() == unambiguousName_result && that.getBody() == body_result && that.getImplementsUnambiguousName() == implementsUnambiguousName_result) return that;
        else return new FnDecl(info_result, header_result, unambiguousName_result, body_result, implementsUnambiguousName_result);
    }

    public Node for_RewriteFnOverloadDeclOnly(_RewriteFnOverloadDecl that, ASTNodeInfo info_result, IdOrOp name_result, List<IdOrOp> fns_result, Option<Type> type_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getFns() == fns_result && that.getType() == type_result) return that;
        else return new _RewriteFnOverloadDecl(info_result, name_result, fns_result, type_result);
    }

    public Node for_RewriteObjectExprDeclOnly(_RewriteObjectExprDecl that, ASTNodeInfo info_result, List<_RewriteObjectExpr> objectExprs_result) {
        if (that.getInfo() == info_result && that.getObjectExprs() == objectExprs_result) return that;
        else return new _RewriteObjectExprDecl(info_result, objectExprs_result);
    }

    public Node for_RewriteFunctionalMethodDeclOnly(_RewriteFunctionalMethodDecl that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _RewriteFunctionalMethodDecl(info_result, that.getFunctionalMethodNames());
    }

    public Node forDimDeclOnly(DimDecl that, ASTNodeInfo info_result, Id dimId_result, Option<Type> derived_result, Option<Id> defaultId_result) {
        if (that.getInfo() == info_result && that.getDimId() == dimId_result && that.getDerived() == derived_result && that.getDefaultId() == defaultId_result) return that;
        else return new DimDecl(info_result, dimId_result, derived_result, defaultId_result);
    }

    public Node forUnitDeclOnly(UnitDecl that, ASTNodeInfo info_result, List<Id> units_result, Option<Type> dimType_result, Option<Expr> defExpr_result) {
        if (that.getInfo() == info_result && that.getUnits() == units_result && that.getDimType() == dimType_result && that.getDefExpr() == defExpr_result) return that;
        else return new UnitDecl(info_result, that.isSi_unit(), units_result, dimType_result, defExpr_result);
    }

    public Node forTestDeclOnly(TestDecl that, ASTNodeInfo info_result, Id name_result, List<GeneratorClause> gens_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getGens() == gens_result && that.getExpr() == expr_result) return that;
        else return new TestDecl(info_result, name_result, gens_result, expr_result);
    }

    public Node forPropertyDeclOnly(PropertyDecl that, ASTNodeInfo info_result, Option<Id> name_result, List<Param> params_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getParams() == params_result && that.getExpr() == expr_result) return that;
        else return new PropertyDecl(info_result, name_result, params_result, expr_result);
    }

    public Node forTypeAliasOnly(TypeAlias that, ASTNodeInfo info_result, Id name_result, List<StaticParam> staticParams_result, Type typeDef_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getStaticParams() == staticParams_result && that.getTypeDef() == typeDef_result) return that;
        else return new TypeAlias(info_result, name_result, staticParams_result, typeDef_result);
    }

    public Node forGrammarDeclOnly(GrammarDecl that, ASTNodeInfo info_result, Id name_result, List<Id> extendsClause_result, List<GrammarMemberDecl> members_result, List<TransformerDecl> transformers_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getExtendsClause() == extendsClause_result && that.getMembers() == members_result && that.getTransformers() == transformers_result) return that;
        else return new GrammarDecl(info_result, name_result, extendsClause_result, members_result, transformers_result, that.isNativeDef());
    }

    public Node forNonterminalDefOnly(NonterminalDef that, ASTNodeInfo info_result, Id name_result, List<SyntaxDecl> syntaxDecls_result, NonterminalHeader header_result, Option<BaseType> astType_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getSyntaxDecls() == syntaxDecls_result && that.getHeader() == header_result && that.getAstType() == astType_result) return that;
        else return new NonterminalDef(info_result, name_result, syntaxDecls_result, header_result, astType_result);
    }

    public Node forNonterminalExtensionDefOnly(NonterminalExtensionDef that, ASTNodeInfo info_result, Id name_result, List<SyntaxDecl> syntaxDecls_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getSyntaxDecls() == syntaxDecls_result) return that;
        else return new NonterminalExtensionDef(info_result, name_result, syntaxDecls_result);
    }

    public Node forLValueOnly(LValue that, ASTNodeInfo info_result, Id name_result, Option<TypeOrPattern> idType_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getIdType() == idType_result) return that;
        else return new LValue(info_result, name_result, that.getMods(), idType_result, that.isMutable());
    }

    public Node forParamOnly(Param that, ASTNodeInfo info_result, Id name_result, Option<TypeOrPattern> idType_result, Option<Expr> defaultExpr_result, Option<Type> varargsType_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getIdType() == idType_result && that.getDefaultExpr() == defaultExpr_result && that.getVarargsType() == varargsType_result) return that;
        else return new Param(info_result, name_result, that.getMods(), idType_result, defaultExpr_result, varargsType_result);
    }

    public Node forDummyExprOnly(DummyExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new DummyExpr(info_result);
    }

    public Node forAsExprOnly(AsExpr that, ExprInfo info_result, Expr expr_result, Type annType_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result && that.getAnnType() == annType_result) return that;
        else return new AsExpr(info_result, expr_result, annType_result);
    }

    public Node forAsIfExprOnly(AsIfExpr that, ExprInfo info_result, Expr expr_result, Type annType_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result && that.getAnnType() == annType_result) return that;
        else return new AsIfExpr(info_result, expr_result, annType_result);
    }

    public Node forAssignmentOnly(Assignment that, ExprInfo info_result, List<Lhs> lhs_result, Option<FunctionalRef> assignOp_result, Expr rhs_result, List<CompoundAssignmentInfo> assignmentInfos_result) {
        if (that.getInfo() == info_result && that.getLhs() == lhs_result && that.getAssignOp() == assignOp_result && that.getRhs() == rhs_result && that.getAssignmentInfos() == assignmentInfos_result) return that;
        else return new Assignment(info_result, lhs_result, assignOp_result, rhs_result, assignmentInfos_result);
    }

    public Node forBlockOnly(Block that, ExprInfo info_result, Option<Expr> loc_result, List<Expr> exprs_result) {
        if (that.getInfo() == info_result && that.getLoc() == loc_result && that.getExprs() == exprs_result) return that;
        else return new Block(info_result, loc_result, that.isAtomicBlock(), that.isWithinDo(), exprs_result);
    }

    public Node forDoOnly(Do that, ExprInfo info_result, List<Block> fronts_result) {
        if (that.getInfo() == info_result && that.getFronts() == fronts_result) return that;
        else return new Do(info_result, fronts_result);
    }

    public Node forCaseExprOnly(CaseExpr that, ExprInfo info_result, Option<Expr> param_result, Option<FunctionalRef> compare_result, FunctionalRef equalsOp_result, FunctionalRef inOp_result, List<CaseClause> clauses_result, Option<Block> elseClause_result) {
        if (that.getInfo() == info_result && that.getParam() == param_result && that.getCompare() == compare_result && that.getEqualsOp() == equalsOp_result && that.getInOp() == inOp_result && that.getClauses() == clauses_result && that.getElseClause() == elseClause_result) return that;
        else return new CaseExpr(info_result, param_result, compare_result, equalsOp_result, inOp_result, clauses_result, elseClause_result);
    }

    public Node forIfOnly(If that, ExprInfo info_result, List<IfClause> clauses_result, Option<Block> elseClause_result) {
        if (that.getInfo() == info_result && that.getClauses() == clauses_result && that.getElseClause() == elseClause_result) return that;
        else return new If(info_result, clauses_result, elseClause_result);
    }

    public Node forLabelOnly(Label that, ExprInfo info_result, Id name_result, Block body_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getBody() == body_result) return that;
        else return new Label(info_result, name_result, body_result);
    }

    public Node forObjectExprOnly(ObjectExpr that, ExprInfo info_result, TraitTypeHeader header_result, Option<SelfType> selfType_result) {
        if (that.getInfo() == info_result && that.getHeader() == header_result && that.getSelfType() == selfType_result) return that;
        else return new ObjectExpr(info_result, header_result, selfType_result);
    }

    public Node for_RewriteObjectExprOnly(_RewriteObjectExpr that, ExprInfo info_result, TraitTypeHeader header_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getHeader() == header_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new _RewriteObjectExpr(info_result, header_result, that.getImplicitTypeParameters(), that.getGenSymName(), staticArgs_result);
    }

    public Node forTryOnly(Try that, ExprInfo info_result, Block body_result, Option<Catch> catchClause_result, List<BaseType> forbidClause_result, Option<Block> finallyClause_result) {
        if (that.getInfo() == info_result && that.getBody() == body_result && that.getCatchClause() == catchClause_result && that.getForbidClause() == forbidClause_result && that.getFinallyClause() == finallyClause_result) return that;
        else return new Try(info_result, body_result, catchClause_result, forbidClause_result, finallyClause_result);
    }

    public Node forTupleExprOnly(TupleExpr that, ExprInfo info_result, List<Expr> exprs_result, Option<Expr> varargs_result, List<KeywordExpr> keywords_result) {
        if (that.getInfo() == info_result && that.getExprs() == exprs_result && that.getVarargs() == varargs_result && that.getKeywords() == keywords_result) return that;
        else return new TupleExpr(info_result, exprs_result, varargs_result, keywords_result, that.isInApp());
    }

    public Node forTypecaseOnly(Typecase that, ExprInfo info_result, Expr bindExpr_result, List<TypecaseClause> clauses_result, Option<Block> elseClause_result) {
        if (that.getInfo() == info_result && that.getBindExpr() == bindExpr_result && that.getClauses() == clauses_result && that.getElseClause() == elseClause_result) return that;
        else return new Typecase(info_result, bindExpr_result, clauses_result, elseClause_result);
    }

    public Node forWhileOnly(While that, ExprInfo info_result, GeneratorClause testExpr_result, Do body_result) {
        if (that.getInfo() == info_result && that.getTestExpr() == testExpr_result && that.getBody() == body_result) return that;
        else return new While(info_result, testExpr_result, body_result);
    }

    public Node forForOnly(For that, ExprInfo info_result, List<GeneratorClause> gens_result, Block body_result) {
        if (that.getInfo() == info_result && that.getGens() == gens_result && that.getBody() == body_result) return that;
        else return new For(info_result, gens_result, body_result);
    }

    public Node forAccumulatorOnly(Accumulator that, ExprInfo info_result, List<StaticArg> staticArgs_result, Op accOp_result, List<GeneratorClause> gens_result, Expr body_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getAccOp() == accOp_result && that.getGens() == gens_result && that.getBody() == body_result) return that;
        else return new Accumulator(info_result, staticArgs_result, accOp_result, gens_result, body_result);
    }

    public Node forArrayComprehensionOnly(ArrayComprehension that, ExprInfo info_result, List<StaticArg> staticArgs_result, List<ArrayComprehensionClause> clauses_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getClauses() == clauses_result) return that;
        else return new ArrayComprehension(info_result, staticArgs_result, clauses_result);
    }

    public Node forAtomicExprOnly(AtomicExpr that, ExprInfo info_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result) return that;
        else return new AtomicExpr(info_result, expr_result);
    }

    public Node forExitOnly(Exit that, ExprInfo info_result, Option<Id> target_result, Option<Expr> returnExpr_result) {
        if (that.getInfo() == info_result && that.getTarget() == target_result && that.getReturnExpr() == returnExpr_result) return that;
        else return new Exit(info_result, target_result, returnExpr_result);
    }

    public Node forSpawnOnly(Spawn that, ExprInfo info_result, Expr body_result) {
        if (that.getInfo() == info_result && that.getBody() == body_result) return that;
        else return new Spawn(info_result, body_result);
    }

    public Node forThrowOnly(Throw that, ExprInfo info_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result) return that;
        else return new Throw(info_result, expr_result);
    }

    public Node forTryAtomicExprOnly(TryAtomicExpr that, ExprInfo info_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result) return that;
        else return new TryAtomicExpr(info_result, expr_result);
    }

    public Node forFnExprOnly(FnExpr that, ExprInfo info_result, FnHeader header_result, Expr body_result) {
        if (that.getInfo() == info_result && that.getHeader() == header_result && that.getBody() == body_result) return that;
        else return new FnExpr(info_result, header_result, body_result);
    }

    public Node forLetFnOnly(LetFn that, ExprInfo info_result, Block body_result, List<FnDecl> fns_result) {
        if (that.getInfo() == info_result && that.getBody() == body_result && that.getFns() == fns_result) return that;
        else return new LetFn(info_result, body_result, fns_result);
    }

    public Node forLocalVarDeclOnly(LocalVarDecl that, ExprInfo info_result, Block body_result, List<LValue> lhs_result, Option<Expr> rhs_result) {
        if (that.getInfo() == info_result && that.getBody() == body_result && that.getLhs() == lhs_result && that.getRhs() == rhs_result) return that;
        else return new LocalVarDecl(info_result, body_result, lhs_result, rhs_result);
    }

    public Node forSubscriptExprOnly(SubscriptExpr that, ExprInfo info_result, Expr obj_result, List<Expr> subs_result, Option<Op> op_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getObj() == obj_result && that.getSubs() == subs_result && that.getOp() == op_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new SubscriptExpr(info_result, obj_result, subs_result, op_result, staticArgs_result);
    }

    public Node forFloatLiteralExprOnly(FloatLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new FloatLiteralExpr(info_result, that.getText(), that.getIntPart(), that.getNumerator(), that.getDenomBase(), that.getDenomPower());
    }

    public Node forIntLiteralExprOnly(IntLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new IntLiteralExpr(info_result, that.getText(), that.getIntVal());
    }

    public Node forCharLiteralExprOnly(CharLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new CharLiteralExpr(info_result, that.getText(), that.getCharVal());
    }

    public Node forStringLiteralExprOnly(StringLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new StringLiteralExpr(info_result, that.getText());
    }

    public Node forVoidLiteralExprOnly(VoidLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new VoidLiteralExpr(info_result, that.getText());
    }

    public Node forBooleanLiteralExprOnly(BooleanLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new BooleanLiteralExpr(info_result, that.getText(), that.getBooleanVal());
    }

    public Node forVarRefOnly(VarRef that, ExprInfo info_result, Id varId_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getVarId() == varId_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new VarRef(info_result, varId_result, staticArgs_result, that.getLexicalDepth());
    }

    public Node forFieldRefOnly(FieldRef that, ExprInfo info_result, Expr obj_result, Id field_result) {
        if (that.getInfo() == info_result && that.getObj() == obj_result && that.getField() == field_result) return that;
        else return new FieldRef(info_result, obj_result, field_result);
    }

    public Node forFnRefOnly(FnRef that, ExprInfo info_result, List<StaticArg> staticArgs_result, IdOrOp originalName_result, List<IdOrOp> names_result, List<Overloading> interpOverloadings_result, List<Overloading> newOverloadings_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getOriginalName() == originalName_result && that.getNames() == names_result && that.getInterpOverloadings() == interpOverloadings_result && that.getNewOverloadings() == newOverloadings_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result) return that;
        else return new FnRef(info_result, staticArgs_result, that.getLexicalDepth(), originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public Node forOpRefOnly(OpRef that, ExprInfo info_result, List<StaticArg> staticArgs_result, IdOrOp originalName_result, List<IdOrOp> names_result, List<Overloading> interpOverloadings_result, List<Overloading> newOverloadings_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getOriginalName() == originalName_result && that.getNames() == names_result && that.getInterpOverloadings() == interpOverloadings_result && that.getNewOverloadings() == newOverloadings_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result) return that;
        else return new OpRef(info_result, staticArgs_result, that.getLexicalDepth(), originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public Node for_RewriteFnRefOnly(_RewriteFnRef that, ExprInfo info_result, Expr fnExpr_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getFnExpr() == fnExpr_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new _RewriteFnRef(info_result, fnExpr_result, staticArgs_result);
    }

    public Node for_RewriteObjectExprRefOnly(_RewriteObjectExprRef that, ExprInfo info_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new _RewriteObjectExprRef(info_result, that.getGenSymName(), staticArgs_result);
    }

    public Node forJuxtOnly(Juxt that, ExprInfo info_result, FunctionalRef multiJuxt_result, FunctionalRef infixJuxt_result, List<Expr> exprs_result) {
        if (that.getInfo() == info_result && that.getMultiJuxt() == multiJuxt_result && that.getInfixJuxt() == infixJuxt_result && that.getExprs() == exprs_result) return that;
        else return new Juxt(info_result, multiJuxt_result, infixJuxt_result, exprs_result, that.isFnApp(), that.isTight());
    }

    public Node for_RewriteFnAppOnly(_RewriteFnApp that, ExprInfo info_result, Expr function_result, Expr argument_result) {
        if (that.getInfo() == info_result && that.getFunction() == function_result && that.getArgument() == argument_result) return that;
        else return new _RewriteFnApp(info_result, function_result, argument_result);
    }

    public Node forOpExprOnly(OpExpr that, ExprInfo info_result, FunctionalRef op_result, List<Expr> args_result) {
        if (that.getInfo() == info_result && that.getOp() == op_result && that.getArgs() == args_result) return that;
        else return new OpExpr(info_result, op_result, args_result);
    }

    public Node forAmbiguousMultifixOpExprOnly(AmbiguousMultifixOpExpr that, ExprInfo info_result, FunctionalRef infix_op_result, FunctionalRef multifix_op_result, List<Expr> args_result) {
        if (that.getInfo() == info_result && that.getInfix_op() == infix_op_result && that.getMultifix_op() == multifix_op_result && that.getArgs() == args_result) return that;
        else return new AmbiguousMultifixOpExpr(info_result, infix_op_result, multifix_op_result, args_result);
    }

    public Node forChainExprOnly(ChainExpr that, ExprInfo info_result, Expr first_result, List<Link> links_result) {
        if (that.getInfo() == info_result && that.getFirst() == first_result && that.getLinks() == links_result) return that;
        else return new ChainExpr(info_result, first_result, links_result);
    }

    public Node forTraitCoercionInvocationOnly(TraitCoercionInvocation that, ExprInfo info_result, Expr arg_result, TraitType toType_result, FnRef coercionFn_result) {
        if (that.getInfo() == info_result && that.getArg() == arg_result && that.getToType() == toType_result && that.getCoercionFn() == coercionFn_result) return that;
        else return new TraitCoercionInvocation(info_result, arg_result, toType_result, coercionFn_result);
    }

    public Node forTupleCoercionInvocationOnly(TupleCoercionInvocation that, ExprInfo info_result, Expr arg_result, TupleType toType_result, List<Option<CoercionInvocation>> subCoercions_result, Option<Option<CoercionInvocation>> varargCoercion_result) {
        if (that.getInfo() == info_result && that.getArg() == arg_result && that.getToType() == toType_result && that.getSubCoercions() == subCoercions_result && that.getVarargCoercion() == varargCoercion_result) return that;
        else return new TupleCoercionInvocation(info_result, arg_result, toType_result, subCoercions_result, varargCoercion_result);
    }

    public Node forArrowCoercionInvocationOnly(ArrowCoercionInvocation that, ExprInfo info_result, Expr arg_result, ArrowType toType_result, Option<CoercionInvocation> domainCoercion_result, Option<CoercionInvocation> rangeCoercion_result) {
        if (that.getInfo() == info_result && that.getArg() == arg_result && that.getToType() == toType_result && that.getDomainCoercion() == domainCoercion_result && that.getRangeCoercion() == rangeCoercion_result) return that;
        else return new ArrowCoercionInvocation(info_result, arg_result, toType_result, domainCoercion_result, rangeCoercion_result);
    }

    public Node forUnionCoercionInvocationOnly(UnionCoercionInvocation that, ExprInfo info_result, Type toType_result, Expr arg_result, List<Type> fromTypes_result, List<Option<CoercionInvocation>> fromCoercions_result) {
        if (that.getInfo() == info_result && that.getToType() == toType_result && that.getArg() == arg_result && that.getFromTypes() == fromTypes_result && that.getFromCoercions() == fromCoercions_result) return that;
        else return new UnionCoercionInvocation(info_result, toType_result, arg_result, fromTypes_result, fromCoercions_result);
    }

    public Node forMethodInvocationOnly(MethodInvocation that, ExprInfo info_result, Expr obj_result, IdOrOp method_result, List<StaticArg> staticArgs_result, Expr arg_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result) {
        if (that.getInfo() == info_result && that.getObj() == obj_result && that.getMethod() == method_result && that.getStaticArgs() == staticArgs_result && that.getArg() == arg_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result) return that;
        else return new MethodInvocation(info_result, obj_result, method_result, staticArgs_result, arg_result, overloadingType_result, overloadingSchema_result);
    }

    public Node forMathPrimaryOnly(MathPrimary that, ExprInfo info_result, FunctionalRef multiJuxt_result, FunctionalRef infixJuxt_result, Expr front_result, List<MathItem> rest_result) {
        if (that.getInfo() == info_result && that.getMultiJuxt() == multiJuxt_result && that.getInfixJuxt() == infixJuxt_result && that.getFront() == front_result && that.getRest() == rest_result) return that;
        else return new MathPrimary(info_result, multiJuxt_result, infixJuxt_result, front_result, rest_result);
    }

    public Node forArrayElementOnly(ArrayElement that, ExprInfo info_result, List<StaticArg> staticArgs_result, Expr element_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getElement() == element_result) return that;
        else return new ArrayElement(info_result, staticArgs_result, element_result);
    }

    public Node forArrayElementsOnly(ArrayElements that, ExprInfo info_result, List<StaticArg> staticArgs_result, List<ArrayExpr> elements_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getElements() == elements_result) return that;
        else return new ArrayElements(info_result, staticArgs_result, that.getDimension(), elements_result, that.isOutermost());
    }

    public Node forAnyTypeOnly(AnyType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new AnyType(info_result);
    }

    public Node forBottomTypeOnly(BottomType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new BottomType(info_result);
    }

    public Node forUnknownTypeOnly(UnknownType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new UnknownType(info_result);
    }

    public Node forTraitSelfTypeOnly(TraitSelfType that, TypeInfo info_result, BaseType named_result, List<NamedType> comprised_result) {
        if (that.getInfo() == info_result && that.getNamed() == named_result && that.getComprised() == comprised_result) return that;
        else return new TraitSelfType(info_result, named_result, comprised_result);
    }

    public Node forObjectExprTypeOnly(ObjectExprType that, TypeInfo info_result, List<BaseType> extended_result) {
        if (that.getInfo() == info_result && that.getExtended() == extended_result) return that;
        else return new ObjectExprType(info_result, extended_result);
    }

    public Node for_InferenceVarTypeOnly(_InferenceVarType that, TypeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new _InferenceVarType(info_result, name_result, that.getId());
    }

    public Node forVarTypeOnly(VarType that, TypeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new VarType(info_result, name_result, that.getLexicalDepth());
    }

    public Node forTraitTypeOnly(TraitType that, TypeInfo info_result, Id name_result, List<StaticArg> args_result, List<StaticParam> traitStaticParams_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getArgs() == args_result && that.getTraitStaticParams() == traitStaticParams_result) return that;
        else return new TraitType(info_result, name_result, args_result, traitStaticParams_result);
    }

    public Node forArrayTypeOnly(ArrayType that, TypeInfo info_result, Type elemType_result, Indices indices_result) {
        if (that.getInfo() == info_result && that.getElemType() == elemType_result && that.getIndices() == indices_result) return that;
        else return new ArrayType(info_result, elemType_result, indices_result);
    }

    public Node forMatrixTypeOnly(MatrixType that, TypeInfo info_result, Type elemType_result, List<ExtentRange> dimensions_result) {
        if (that.getInfo() == info_result && that.getElemType() == elemType_result && that.getDimensions() == dimensions_result) return that;
        else return new MatrixType(info_result, elemType_result, dimensions_result);
    }

    public Node forTaggedDimTypeOnly(TaggedDimType that, TypeInfo info_result, Type elemType_result, DimExpr dimExpr_result, Option<Expr> unitExpr_result) {
        if (that.getInfo() == info_result && that.getElemType() == elemType_result && that.getDimExpr() == dimExpr_result && that.getUnitExpr() == unitExpr_result) return that;
        else return new TaggedDimType(info_result, elemType_result, dimExpr_result, unitExpr_result);
    }

    public Node forTaggedUnitTypeOnly(TaggedUnitType that, TypeInfo info_result, Type elemType_result, Expr unitExpr_result) {
        if (that.getInfo() == info_result && that.getElemType() == elemType_result && that.getUnitExpr() == unitExpr_result) return that;
        else return new TaggedUnitType(info_result, elemType_result, unitExpr_result);
    }

    public Node forTupleTypeOnly(TupleType that, TypeInfo info_result, List<Type> elements_result, Option<Type> varargs_result, List<KeywordType> keywords_result) {
        if (that.getInfo() == info_result && that.getElements() == elements_result && that.getVarargs() == varargs_result && that.getKeywords() == keywords_result) return that;
        else return new TupleType(info_result, elements_result, varargs_result, keywords_result);
    }

    public Node forArrowTypeOnly(ArrowType that, TypeInfo info_result, Type domain_result, Type range_result, Effect effect_result, Option<MethodInfo> methodInfo_result) {
        if (that.getInfo() == info_result && that.getDomain() == domain_result && that.getRange() == range_result && that.getEffect() == effect_result && that.getMethodInfo() == methodInfo_result) return that;
        else return new ArrowType(info_result, domain_result, range_result, effect_result, that.isIo(), methodInfo_result);
    }

    public Node forIntersectionTypeOnly(IntersectionType that, TypeInfo info_result, List<Type> elements_result) {
        if (that.getInfo() == info_result && that.getElements() == elements_result) return that;
        else return new IntersectionType(info_result, elements_result);
    }

    public Node forUnionTypeOnly(UnionType that, TypeInfo info_result, List<Type> elements_result) {
        if (that.getInfo() == info_result && that.getElements() == elements_result) return that;
        else return new UnionType(info_result, elements_result);
    }

    public Node forFixedPointTypeOnly(FixedPointType that, TypeInfo info_result, _InferenceVarType name_result, Type body_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getBody() == body_result) return that;
        else return new FixedPointType(info_result, name_result, body_result);
    }

    public Node forLabelTypeOnly(LabelType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new LabelType(info_result);
    }

    public Node forDimBaseOnly(DimBase that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new DimBase(info_result);
    }

    public Node forDimRefOnly(DimRef that, TypeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new DimRef(info_result, name_result);
    }

    public Node forDimExponentOnly(DimExponent that, TypeInfo info_result, Type base_result, IntExpr power_result) {
        if (that.getInfo() == info_result && that.getBase() == base_result && that.getPower() == power_result) return that;
        else return new DimExponent(info_result, base_result, power_result);
    }

    public Node forDimUnaryOpOnly(DimUnaryOp that, TypeInfo info_result, DimExpr dimVal_result, Op op_result) {
        if (that.getInfo() == info_result && that.getDimVal() == dimVal_result && that.getOp() == op_result) return that;
        else return new DimUnaryOp(info_result, dimVal_result, op_result);
    }

    public Node forDimBinaryOpOnly(DimBinaryOp that, TypeInfo info_result, DimExpr left_result, DimExpr right_result, Op op_result) {
        if (that.getInfo() == info_result && that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result) return that;
        else return new DimBinaryOp(info_result, left_result, right_result, op_result);
    }

    public Node forPatternOnly(Pattern that, ASTNodeInfo info_result, Option<Type> name_result, PatternArgs patterns_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getPatterns() == patterns_result) return that;
        else return new Pattern(info_result, name_result, patterns_result);
    }

    public Node forPatternArgsOnly(PatternArgs that, ASTNodeInfo info_result, List<PatternBinding> patterns_result) {
        if (that.getInfo() == info_result && that.getPatterns() == patterns_result) return that;
        else return new PatternArgs(info_result, patterns_result);
    }

    public Node forPlainPatternOnly(PlainPattern that, ASTNodeInfo info_result, Option<Id> field_result, Id name_result, Option<TypeOrPattern> idType_result) {
        if (that.getInfo() == info_result && that.getField() == field_result && that.getName() == name_result && that.getIdType() == idType_result) return that;
        else return new PlainPattern(info_result, field_result, name_result, that.getMods(), idType_result);
    }

    public Node forTypePatternOnly(TypePattern that, ASTNodeInfo info_result, Option<Id> field_result, Type typ_result) {
        if (that.getInfo() == info_result && that.getField() == field_result && that.getTyp() == typ_result) return that;
        else return new TypePattern(info_result, field_result, typ_result);
    }

    public Node forNestedPatternOnly(NestedPattern that, ASTNodeInfo info_result, Option<Id> field_result, Pattern pat_result) {
        if (that.getInfo() == info_result && that.getField() == field_result && that.getPat() == pat_result) return that;
        else return new NestedPattern(info_result, field_result, pat_result);
    }

    public Node forTypeArgOnly(TypeArg that, ASTNodeInfo info_result, Type typeArg_result) {
        if (that.getInfo() == info_result && that.getTypeArg() == typeArg_result) return that;
        else return new TypeArg(info_result, that.isLifted(), typeArg_result);
    }

    public Node forIntArgOnly(IntArg that, ASTNodeInfo info_result, IntExpr intVal_result) {
        if (that.getInfo() == info_result && that.getIntVal() == intVal_result) return that;
        else return new IntArg(info_result, that.isLifted(), intVal_result);
    }

    public Node forBoolArgOnly(BoolArg that, ASTNodeInfo info_result, BoolExpr boolArg_result) {
        if (that.getInfo() == info_result && that.getBoolArg() == boolArg_result) return that;
        else return new BoolArg(info_result, that.isLifted(), boolArg_result);
    }

    public Node forOpArgOnly(OpArg that, ASTNodeInfo info_result, Op id_result) {
        if (that.getInfo() == info_result && that.getId() == id_result) return that;
        else return new OpArg(info_result, that.isLifted(), id_result);
    }

    public Node forDimArgOnly(DimArg that, ASTNodeInfo info_result, DimExpr dimArg_result) {
        if (that.getInfo() == info_result && that.getDimArg() == dimArg_result) return that;
        else return new DimArg(info_result, that.isLifted(), dimArg_result);
    }

    public Node forUnitArgOnly(UnitArg that, ASTNodeInfo info_result, UnitExpr unitArg_result) {
        if (that.getInfo() == info_result && that.getUnitArg() == unitArg_result) return that;
        else return new UnitArg(info_result, that.isLifted(), unitArg_result);
    }

    public Node forIntBaseOnly(IntBase that, ASTNodeInfo info_result, IntLiteralExpr intVal_result) {
        if (that.getInfo() == info_result && that.getIntVal() == intVal_result) return that;
        else return new IntBase(info_result, that.isParenthesized(), intVal_result);
    }

    public Node forIntRefOnly(IntRef that, ASTNodeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new IntRef(info_result, that.isParenthesized(), name_result, that.getLexicalDepth());
    }

    public Node forIntBinaryOpOnly(IntBinaryOp that, ASTNodeInfo info_result, IntExpr left_result, IntExpr right_result, Op op_result) {
        if (that.getInfo() == info_result && that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result) return that;
        else return new IntBinaryOp(info_result, that.isParenthesized(), left_result, right_result, op_result);
    }

    public Node forBoolBaseOnly(BoolBase that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new BoolBase(info_result, that.isParenthesized(), that.isBoolVal());
    }

    public Node forBoolRefOnly(BoolRef that, ASTNodeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new BoolRef(info_result, that.isParenthesized(), name_result, that.getLexicalDepth());
    }

    public Node forBoolUnaryOpOnly(BoolUnaryOp that, ASTNodeInfo info_result, BoolExpr boolVal_result, Op op_result) {
        if (that.getInfo() == info_result && that.getBoolVal() == boolVal_result && that.getOp() == op_result) return that;
        else return new BoolUnaryOp(info_result, that.isParenthesized(), boolVal_result, op_result);
    }

    public Node forBoolBinaryOpOnly(BoolBinaryOp that, ASTNodeInfo info_result, BoolExpr left_result, BoolExpr right_result, Op op_result) {
        if (that.getInfo() == info_result && that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result) return that;
        else return new BoolBinaryOp(info_result, that.isParenthesized(), left_result, right_result, op_result);
    }

    public Node forUnitRefOnly(UnitRef that, ASTNodeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new UnitRef(info_result, that.isParenthesized(), name_result);
    }

    public Node forUnitBinaryOpOnly(UnitBinaryOp that, ASTNodeInfo info_result, UnitExpr left_result, UnitExpr right_result, Op op_result) {
        if (that.getInfo() == info_result && that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result) return that;
        else return new UnitBinaryOp(info_result, that.isParenthesized(), left_result, right_result, op_result);
    }

    public Node forEffectOnly(Effect that, ASTNodeInfo info_result, Option<List<Type>> throwsClause_result) {
        if (that.getInfo() == info_result && that.getThrowsClause() == throwsClause_result) return that;
        else return new Effect(info_result, throwsClause_result, that.isIoEffect());
    }

    public Node forWhereClauseOnly(WhereClause that, ASTNodeInfo info_result, List<WhereBinding> bindings_result, List<WhereConstraint> constraints_result) {
        if (that.getInfo() == info_result && that.getBindings() == bindings_result && that.getConstraints() == constraints_result) return that;
        else return new WhereClause(info_result, bindings_result, constraints_result);
    }

    public Node forWhereBindingOnly(WhereBinding that, ASTNodeInfo info_result, Id name_result, List<BaseType> supers_result, StaticParamKind kind_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getSupers() == supers_result && that.getKind() == kind_result) return that;
        else return new WhereBinding(info_result, name_result, supers_result, kind_result);
    }

    public Node forWhereExtendsOnly(WhereExtends that, ASTNodeInfo info_result, Id name_result, List<BaseType> supers_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getSupers() == supers_result) return that;
        else return new WhereExtends(info_result, name_result, supers_result);
    }

    public Node forWhereTypeAliasOnly(WhereTypeAlias that, ASTNodeInfo info_result, TypeAlias alias_result) {
        if (that.getInfo() == info_result && that.getAlias() == alias_result) return that;
        else return new WhereTypeAlias(info_result, alias_result);
    }

    public Node forWhereCoercesOnly(WhereCoerces that, ASTNodeInfo info_result, Type left_result, Type right_result) {
        if (that.getInfo() == info_result && that.getLeft() == left_result && that.getRight() == right_result) return that;
        else return new WhereCoerces(info_result, left_result, right_result, that.isCoerces(), that.isWidens());
    }

    public Node forWhereEqualsOnly(WhereEquals that, ASTNodeInfo info_result, Id left_result, Id right_result) {
        if (that.getInfo() == info_result && that.getLeft() == left_result && that.getRight() == right_result) return that;
        else return new WhereEquals(info_result, left_result, right_result);
    }

    public Node forUnitConstraintOnly(UnitConstraint that, ASTNodeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new UnitConstraint(info_result, name_result);
    }

    public Node forIntConstraintOnly(IntConstraint that, ASTNodeInfo info_result, IntExpr left_result, IntExpr right_result, Op op_result) {
        if (that.getInfo() == info_result && that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result) return that;
        else return new IntConstraint(info_result, left_result, right_result, op_result);
    }

    public Node forBoolConstraintExprOnly(BoolConstraintExpr that, ASTNodeInfo info_result, BoolConstraint constraint_result) {
        if (that.getInfo() == info_result && that.getConstraint() == constraint_result) return that;
        else return new BoolConstraintExpr(info_result, constraint_result);
    }

    public Node forContractOnly(Contract that, ASTNodeInfo info_result, Option<List<Expr>> requiresClause_result, Option<List<EnsuresClause>> ensuresClause_result, Option<List<Expr>> invariantsClause_result) {
        if (that.getInfo() == info_result && that.getRequiresClause() == requiresClause_result && that.getEnsuresClause() == ensuresClause_result && that.getInvariantsClause() == invariantsClause_result) return that;
        else return new Contract(info_result, requiresClause_result, ensuresClause_result, invariantsClause_result);
    }

    public Node forEnsuresClauseOnly(EnsuresClause that, ASTNodeInfo info_result, Expr post_result, Option<Expr> pre_result) {
        if (that.getInfo() == info_result && that.getPost() == post_result && that.getPre() == pre_result) return that;
        else return new EnsuresClause(info_result, post_result, pre_result);
    }

    public Node forStaticParamOnly(StaticParam that, ASTNodeInfo info_result, IdOrOp name_result, List<BaseType> extendsClause_result, List<BaseType> dominatesClause_result, Option<Type> dimParam_result, StaticParamKind kind_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getExtendsClause() == extendsClause_result && that.getDominatesClause() == dominatesClause_result && that.getDimParam() == dimParam_result && that.getKind() == kind_result) return that;
        else return new StaticParam(info_result, that.getVariance(), name_result, extendsClause_result, dominatesClause_result, dimParam_result, that.isAbsorbsParam(), kind_result, that.isLifted());
    }

    public Node forAPINameOnly(APIName that, ASTNodeInfo info_result, List<Id> ids_result) {
        if (that.getInfo() == info_result && that.getIds() == ids_result) return that;
        else return new APIName(info_result, ids_result, that.getText());
    }

    public Node forIdOnly(Id that, ASTNodeInfo info_result, Option<APIName> apiName_result) {
        if (that.getInfo() == info_result && that.getApiName() == apiName_result) return that;
        else return new Id(info_result, apiName_result, that.getText());
    }

    public Node forNamedOpOnly(NamedOp that, ASTNodeInfo info_result, Option<APIName> apiName_result, Fixity fixity_result) {
        if (that.getInfo() == info_result && that.getApiName() == apiName_result && that.getFixity() == fixity_result) return that;
        else return new NamedOp(info_result, apiName_result, that.getText(), fixity_result, that.isEnclosing());
    }

    public Node for_InferenceVarOpOnly(_InferenceVarOp that, ASTNodeInfo info_result, Option<APIName> apiName_result, Fixity fixity_result) {
        if (that.getInfo() == info_result && that.getApiName() == apiName_result && that.getFixity() == fixity_result) return that;
        else return new _InferenceVarOp(info_result, apiName_result, that.getText(), fixity_result, that.isEnclosing(), that.getId());
    }

    public Node forAnonymousFnNameOnly(AnonymousFnName that, ASTNodeInfo info_result, Option<APIName> apiName_result) {
        if (that.getInfo() == info_result && that.getApiName() == apiName_result) return that;
        else return new AnonymousFnName(info_result, apiName_result);
    }

    public Node forConstructorFnNameOnly(ConstructorFnName that, ASTNodeInfo info_result, Option<APIName> apiName_result, ObjectConstructor constructor_result) {
        if (that.getInfo() == info_result && that.getApiName() == apiName_result && that.getConstructor() == constructor_result) return that;
        else return new ConstructorFnName(info_result, apiName_result, constructor_result);
    }

    public Node forArrayComprehensionClauseOnly(ArrayComprehensionClause that, ASTNodeInfo info_result, List<Expr> bind_result, Expr init_result, List<GeneratorClause> gens_result) {
        if (that.getInfo() == info_result && that.getBind() == bind_result && that.getInit() == init_result && that.getGens() == gens_result) return that;
        else return new ArrayComprehensionClause(info_result, bind_result, init_result, gens_result);
    }

    public Node forKeywordExprOnly(KeywordExpr that, ASTNodeInfo info_result, Id name_result, Expr init_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getInit() == init_result) return that;
        else return new KeywordExpr(info_result, name_result, init_result);
    }

    public Node forCaseClauseOnly(CaseClause that, ASTNodeInfo info_result, Expr matchClause_result, Block body_result, Option<FunctionalRef> op_result) {
        if (that.getInfo() == info_result && that.getMatchClause() == matchClause_result && that.getBody() == body_result && that.getOp() == op_result) return that;
        else return new CaseClause(info_result, matchClause_result, body_result, op_result);
    }

    public Node forCatchOnly(Catch that, ASTNodeInfo info_result, Id name_result, List<CatchClause> clauses_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getClauses() == clauses_result) return that;
        else return new Catch(info_result, name_result, clauses_result);
    }

    public Node forCatchClauseOnly(CatchClause that, ASTNodeInfo info_result, BaseType matchType_result, Block body_result) {
        if (that.getInfo() == info_result && that.getMatchType() == matchType_result && that.getBody() == body_result) return that;
        else return new CatchClause(info_result, matchType_result, body_result);
    }

    public Node forIfClauseOnly(IfClause that, ASTNodeInfo info_result, GeneratorClause testClause_result, Block body_result) {
        if (that.getInfo() == info_result && that.getTestClause() == testClause_result && that.getBody() == body_result) return that;
        else return new IfClause(info_result, testClause_result, body_result);
    }

    public Node forTypecaseClauseOnly(TypecaseClause that, ASTNodeInfo info_result, Option<Id> name_result, TypeOrPattern matchType_result, Block body_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getMatchType() == matchType_result && that.getBody() == body_result) return that;
        else return new TypecaseClause(info_result, name_result, matchType_result, body_result);
    }

    public Node forExtentRangeOnly(ExtentRange that, ASTNodeInfo info_result, Option<StaticArg> base_result, Option<StaticArg> size_result, Option<Op> op_result) {
        if (that.getInfo() == info_result && that.getBase() == base_result && that.getSize() == size_result && that.getOp() == op_result) return that;
        else return new ExtentRange(info_result, base_result, size_result, op_result);
    }

    public Node forGeneratorClauseOnly(GeneratorClause that, ASTNodeInfo info_result, List<Id> bind_result, Expr init_result) {
        if (that.getInfo() == info_result && that.getBind() == bind_result && that.getInit() == init_result) return that;
        else return new GeneratorClause(info_result, bind_result, init_result);
    }

    public Node forKeywordTypeOnly(KeywordType that, ASTNodeInfo info_result, Id name_result, Type keywordType_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getKeywordType() == keywordType_result) return that;
        else return new KeywordType(info_result, name_result, keywordType_result);
    }

    public Node forTraitTypeWhereOnly(TraitTypeWhere that, ASTNodeInfo info_result, BaseType baseType_result, Option<WhereClause> whereClause_result) {
        if (that.getInfo() == info_result && that.getBaseType() == baseType_result && that.getWhereClause() == whereClause_result) return that;
        else return new TraitTypeWhere(info_result, baseType_result, whereClause_result);
    }

    public Node forIndicesOnly(Indices that, ASTNodeInfo info_result, List<ExtentRange> extents_result) {
        if (that.getInfo() == info_result && that.getExtents() == extents_result) return that;
        else return new Indices(info_result, extents_result);
    }

    public Node forParenthesisDelimitedMIOnly(ParenthesisDelimitedMI that, ASTNodeInfo info_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result) return that;
        else return new ParenthesisDelimitedMI(info_result, expr_result);
    }

    public Node forNonParenthesisDelimitedMIOnly(NonParenthesisDelimitedMI that, ASTNodeInfo info_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result) return that;
        else return new NonParenthesisDelimitedMI(info_result, expr_result);
    }

    public Node forExponentiationMIOnly(ExponentiationMI that, ASTNodeInfo info_result, FunctionalRef op_result, Option<Expr> expr_result) {
        if (that.getInfo() == info_result && that.getOp() == op_result && that.getExpr() == expr_result) return that;
        else return new ExponentiationMI(info_result, op_result, expr_result);
    }

    public Node forSubscriptingMIOnly(SubscriptingMI that, ASTNodeInfo info_result, Op op_result, List<Expr> exprs_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getOp() == op_result && that.getExprs() == exprs_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new SubscriptingMI(info_result, op_result, exprs_result, staticArgs_result);
    }

    public Node forOverloadingOnly(Overloading that, ASTNodeInfo info_result, IdOrOp unambiguousName_result, IdOrOp originalName_result, Option<ArrowType> type_result, Option<ArrowType> schema_result) {
        if (that.getInfo() == info_result && that.getUnambiguousName() == unambiguousName_result && that.getOriginalName() == originalName_result && that.getType() == type_result && that.getSchema() == schema_result) return that;
        else return new Overloading(info_result, unambiguousName_result, originalName_result, type_result, schema_result);
    }

    public Node forNonterminalHeaderOnly(NonterminalHeader that, ASTNodeInfo info_result, Id name_result, List<NonterminalParameter> params_result, List<StaticParam> staticParams_result, Option<Type> paramType_result, Option<WhereClause> whereClause_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getParams() == params_result && that.getStaticParams() == staticParams_result && that.getParamType() == paramType_result && that.getWhereClause() == whereClause_result) return that;
        else return new NonterminalHeader(info_result, that.getMods(), name_result, params_result, staticParams_result, paramType_result, whereClause_result);
    }

    public Node forNonterminalParameterOnly(NonterminalParameter that, ASTNodeInfo info_result, Id name_result, BaseType paramType_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getParamType() == paramType_result) return that;
        else return new NonterminalParameter(info_result, name_result, paramType_result);
    }

    public Node forSyntaxDefOnly(SyntaxDef that, ASTNodeInfo info_result, List<SyntaxSymbol> syntaxSymbols_result, TransformerDecl transformer_result) {
        if (that.getInfo() == info_result && that.getSyntaxSymbols() == syntaxSymbols_result && that.getTransformer() == transformer_result) return that;
        else return new SyntaxDef(info_result, that.getModifier(), syntaxSymbols_result, transformer_result);
    }

    public Node forSuperSyntaxDefOnly(SuperSyntaxDef that, ASTNodeInfo info_result, Id nonterminal_result, Id grammarId_result) {
        if (that.getInfo() == info_result && that.getNonterminal() == nonterminal_result && that.getGrammarId() == grammarId_result) return that;
        else return new SuperSyntaxDef(info_result, that.getModifier(), nonterminal_result, grammarId_result);
    }

    public Node forPreTransformerDefOnly(PreTransformerDef that, ASTNodeInfo info_result, Transformer transformer_result) {
        if (that.getInfo() == info_result && that.getTransformer() == transformer_result) return that;
        else return new PreTransformerDef(info_result, transformer_result);
    }

    public Node forNamedTransformerDefOnly(NamedTransformerDef that, ASTNodeInfo info_result, List<NonterminalParameter> parameters_result, Transformer transformer_result) {
        if (that.getInfo() == info_result && that.getParameters() == parameters_result && that.getTransformer() == transformer_result) return that;
        else return new NamedTransformerDef(info_result, that.getName(), parameters_result, transformer_result);
    }

    public Node forUnparsedTransformerOnly(UnparsedTransformer that, ASTNodeInfo info_result, Id nonterminal_result) {
        if (that.getInfo() == info_result && that.getNonterminal() == nonterminal_result) return that;
        else return new UnparsedTransformer(info_result, that.getTransformer(), nonterminal_result);
    }

    public Node forNodeTransformerOnly(NodeTransformer that, ASTNodeInfo info_result, AbstractNode node_result) {
        if (that.getInfo() == info_result && that.getNode() == node_result) return that;
        else return new NodeTransformer(info_result, node_result);
    }

    public Node forCaseTransformerOnly(CaseTransformer that, ASTNodeInfo info_result, Id gapName_result, List<CaseTransformerClause> clauses_result) {
        if (that.getInfo() == info_result && that.getGapName() == gapName_result && that.getClauses() == clauses_result) return that;
        else return new CaseTransformer(info_result, gapName_result, clauses_result);
    }

    public Node forCaseTransformerClauseOnly(CaseTransformerClause that, ASTNodeInfo info_result, Id constructor_result, List<Id> parameters_result, Transformer body_result) {
        if (that.getInfo() == info_result && that.getConstructor() == constructor_result && that.getParameters() == parameters_result && that.getBody() == body_result) return that;
        else return new CaseTransformerClause(info_result, constructor_result, parameters_result, body_result);
    }

    public Node forPrefixedSymbolOnly(PrefixedSymbol that, ASTNodeInfo info_result, Id id_result, SyntaxSymbol symbol_result) {
        if (that.getInfo() == info_result && that.getId() == id_result && that.getSymbol() == symbol_result) return that;
        else return new PrefixedSymbol(info_result, id_result, symbol_result);
    }

    public Node forOptionalSymbolOnly(OptionalSymbol that, ASTNodeInfo info_result, SyntaxSymbol symbol_result) {
        if (that.getInfo() == info_result && that.getSymbol() == symbol_result) return that;
        else return new OptionalSymbol(info_result, symbol_result);
    }

    public Node forRepeatSymbolOnly(RepeatSymbol that, ASTNodeInfo info_result, SyntaxSymbol symbol_result) {
        if (that.getInfo() == info_result && that.getSymbol() == symbol_result) return that;
        else return new RepeatSymbol(info_result, symbol_result);
    }

    public Node forRepeatOneOrMoreSymbolOnly(RepeatOneOrMoreSymbol that, ASTNodeInfo info_result, SyntaxSymbol symbol_result) {
        if (that.getInfo() == info_result && that.getSymbol() == symbol_result) return that;
        else return new RepeatOneOrMoreSymbol(info_result, symbol_result);
    }

    public Node forNoWhitespaceSymbolOnly(NoWhitespaceSymbol that, ASTNodeInfo info_result, SyntaxSymbol symbol_result) {
        if (that.getInfo() == info_result && that.getSymbol() == symbol_result) return that;
        else return new NoWhitespaceSymbol(info_result, symbol_result);
    }

    public Node forGroupSymbolOnly(GroupSymbol that, ASTNodeInfo info_result, List<SyntaxSymbol> symbols_result) {
        if (that.getInfo() == info_result && that.getSymbols() == symbols_result) return that;
        else return new GroupSymbol(info_result, symbols_result);
    }

    public Node forAnyCharacterSymbolOnly(AnyCharacterSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new AnyCharacterSymbol(info_result);
    }

    public Node forWhitespaceSymbolOnly(WhitespaceSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new WhitespaceSymbol(info_result, that.getS());
    }

    public Node forTabSymbolOnly(TabSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new TabSymbol(info_result);
    }

    public Node forFormfeedSymbolOnly(FormfeedSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new FormfeedSymbol(info_result);
    }

    public Node forCarriageReturnSymbolOnly(CarriageReturnSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new CarriageReturnSymbol(info_result);
    }

    public Node forBackspaceSymbolOnly(BackspaceSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new BackspaceSymbol(info_result);
    }

    public Node forNewlineSymbolOnly(NewlineSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new NewlineSymbol(info_result);
    }

    public Node forBreaklineSymbolOnly(BreaklineSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new BreaklineSymbol(info_result, that.getS());
    }

    public Node forItemSymbolOnly(ItemSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new ItemSymbol(info_result, that.getItem());
    }

    public Node forNonterminalSymbolOnly(NonterminalSymbol that, ASTNodeInfo info_result, Id nonterminal_result) {
        if (that.getInfo() == info_result && that.getNonterminal() == nonterminal_result) return that;
        else return new NonterminalSymbol(info_result, nonterminal_result);
    }

    public Node forKeywordSymbolOnly(KeywordSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new KeywordSymbol(info_result, that.getToken());
    }

    public Node forTokenSymbolOnly(TokenSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new TokenSymbol(info_result, that.getToken());
    }

    public Node forNotPredicateSymbolOnly(NotPredicateSymbol that, ASTNodeInfo info_result, SyntaxSymbol symbol_result) {
        if (that.getInfo() == info_result && that.getSymbol() == symbol_result) return that;
        else return new NotPredicateSymbol(info_result, symbol_result);
    }

    public Node forAndPredicateSymbolOnly(AndPredicateSymbol that, ASTNodeInfo info_result, SyntaxSymbol symbol_result) {
        if (that.getInfo() == info_result && that.getSymbol() == symbol_result) return that;
        else return new AndPredicateSymbol(info_result, symbol_result);
    }

    public Node forCharacterClassSymbolOnly(CharacterClassSymbol that, ASTNodeInfo info_result, List<CharacterSymbol> characters_result) {
        if (that.getInfo() == info_result && that.getCharacters() == characters_result) return that;
        else return new CharacterClassSymbol(info_result, characters_result);
    }

    public Node forCharSymbolOnly(CharSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new CharSymbol(info_result, that.getString());
    }

    public Node forCharacterIntervalOnly(CharacterInterval that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new CharacterInterval(info_result, that.getBeginSymbol(), that.getEndSymbol());
    }

    public Node forLinkOnly(Link that, ASTNodeInfo info_result, FunctionalRef op_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getOp() == op_result && that.getExpr() == expr_result) return that;
        else return new Link(info_result, op_result, expr_result);
    }

    public Node forTraitTypeHeaderOnly(TraitTypeHeader that, List<StaticParam> staticParams_result, IdOrOpOrAnonymousName name_result, Option<WhereClause> whereClause_result, Option<List<Type>> throwsClause_result, Option<Contract> contract_result, List<TraitTypeWhere> extendsClause_result, Option<List<Param>> params_result, List<Decl> decls_result) {
        if (that.getStaticParams() == staticParams_result && that.getName() == name_result && that.getWhereClause() == whereClause_result && that.getThrowsClause() == throwsClause_result && that.getContract() == contract_result && that.getExtendsClause() == extendsClause_result && that.getParams() == params_result && that.getDecls() == decls_result) return that;
        else return new TraitTypeHeader(staticParams_result, that.getMods(), name_result, whereClause_result, throwsClause_result, contract_result, extendsClause_result, params_result, decls_result);
    }

    public Node forFnHeaderOnly(FnHeader that, List<StaticParam> staticParams_result, IdOrOpOrAnonymousName name_result, Option<WhereClause> whereClause_result, Option<List<Type>> throwsClause_result, Option<Contract> contract_result, List<Param> params_result, Option<Type> returnType_result) {
        if (that.getStaticParams() == staticParams_result && that.getName() == name_result && that.getWhereClause() == whereClause_result && that.getThrowsClause() == throwsClause_result && that.getContract() == contract_result && that.getParams() == params_result && that.getReturnType() == returnType_result) return that;
        else return new FnHeader(staticParams_result, that.getMods(), name_result, whereClause_result, throwsClause_result, contract_result, params_result, returnType_result);
    }

    public Node forSpanInfoOnly(SpanInfo that) {
        return that;
    }

    public Node forExprInfoOnly(ExprInfo that, Option<Type> exprType_result) {
        if (that.getExprType() == exprType_result) return that;
        else return new ExprInfo(that.getSpan(), that.isParenthesized(), exprType_result);
    }

    public Node forTypeInfoOnly(TypeInfo that, List<StaticParam> staticParams_result, Option<WhereClause> whereClause_result) {
        if (that.getStaticParams() == staticParams_result && that.getWhereClause() == whereClause_result) return that;
        else return new TypeInfo(that.getSpan(), that.isParenthesized(), staticParams_result, whereClause_result);
    }

    public Node forMethodInfoOnly(MethodInfo that, Type selfType_result) {
        if (that.getSelfType() == selfType_result) return that;
        else return new MethodInfo(selfType_result, that.getSelfPosition());
    }

    public Node forCompoundAssignmentInfoOnly(CompoundAssignmentInfo that, FunctionalRef opForLhs_result, Option<CoercionInvocation> compoundCoercionOuter_result, Option<CoercionInvocation> compoundCoercionInner_result) {
        if (that.getOpForLhs() == opForLhs_result && that.getCompoundCoercionOuter() == compoundCoercionOuter_result && that.getCompoundCoercionInner() == compoundCoercionInner_result) return that;
        else return new CompoundAssignmentInfo(opForLhs_result, compoundCoercionOuter_result, compoundCoercionInner_result);
    }

    public Node forLevelOnly(Level that) {
        return that;
    }

    public Node forInFixityOnly(InFixity that) {
        return that;
    }

    public Node forPreFixityOnly(PreFixity that) {
        return that;
    }

    public Node forPostFixityOnly(PostFixity that) {
        return that;
    }

    public Node forNoFixityOnly(NoFixity that) {
        return that;
    }

    public Node forMultiFixityOnly(MultiFixity that) {
        return that;
    }

    public Node forEnclosingFixityOnly(EnclosingFixity that) {
        return that;
    }

    public Node forBigFixityOnly(BigFixity that) {
        return that;
    }

    public Node forUnknownFixityOnly(UnknownFixity that) {
        return that;
    }

    public Node forKindTypeOnly(KindType that) {
        return that;
    }

    public Node forKindIntOnly(KindInt that) {
        return that;
    }

    public Node forKindNatOnly(KindNat that) {
        return that;
    }

    public Node forKindBoolOnly(KindBool that) {
        return that;
    }

    public Node forKindDimOnly(KindDim that) {
        return that;
    }

    public Node forKindUnitOnly(KindUnit that) {
        return that;
    }

    public Node forKindOpOnly(KindOp that) {
        return that;
    }

    public Node for_SyntaxTransformationAbstractNodeOnly(_SyntaxTransformationAbstractNode that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationCompilationUnitOnly(_SyntaxTransformationCompilationUnit that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationComponentOnly(_SyntaxTransformationComponent that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationApiOnly(_SyntaxTransformationApi that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationImportOnly(_SyntaxTransformationImport that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationImportedNamesOnly(_SyntaxTransformationImportedNames that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationImportStarOnly(_SyntaxTransformationImportStar that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationImportNamesOnly(_SyntaxTransformationImportNames that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationImportApiOnly(_SyntaxTransformationImportApi that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationAliasedSimpleNameOnly(_SyntaxTransformationAliasedSimpleName that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationAliasedAPINameOnly(_SyntaxTransformationAliasedAPIName that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationDeclOnly(_SyntaxTransformationDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTraitObjectDeclOnly(_SyntaxTransformationTraitObjectDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTraitDeclOnly(_SyntaxTransformationTraitDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationObjectDeclOnly(_SyntaxTransformationObjectDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationVarDeclOnly(_SyntaxTransformationVarDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationFnDeclOnly(_SyntaxTransformationFnDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformation_RewriteFnOverloadDeclOnly(_SyntaxTransformation_RewriteFnOverloadDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformation_RewriteObjectExprDeclOnly(_SyntaxTransformation_RewriteObjectExprDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformation_RewriteFunctionalMethodDeclOnly(_SyntaxTransformation_RewriteFunctionalMethodDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationDimUnitDeclOnly(_SyntaxTransformationDimUnitDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationDimDeclOnly(_SyntaxTransformationDimDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationUnitDeclOnly(_SyntaxTransformationUnitDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTestDeclOnly(_SyntaxTransformationTestDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationPropertyDeclOnly(_SyntaxTransformationPropertyDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTypeAliasOnly(_SyntaxTransformationTypeAlias that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationGrammarDeclOnly(_SyntaxTransformationGrammarDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationGrammarMemberDeclOnly(_SyntaxTransformationGrammarMemberDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNonterminalDeclOnly(_SyntaxTransformationNonterminalDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNonterminalDefOnly(_SyntaxTransformationNonterminalDef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNonterminalExtensionDefOnly(_SyntaxTransformationNonterminalExtensionDef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBindingOnly(_SyntaxTransformationBinding that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationLValueOnly(_SyntaxTransformationLValue that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationParamOnly(_SyntaxTransformationParam that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationExprOnly(_SyntaxTransformationExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationDummyExprOnly(_SyntaxTransformationDummyExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTypeAnnotatedExprOnly(_SyntaxTransformationTypeAnnotatedExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationAsExprOnly(_SyntaxTransformationAsExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationAsIfExprOnly(_SyntaxTransformationAsIfExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationAssignmentOnly(_SyntaxTransformationAssignment that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBlockOnly(_SyntaxTransformationBlock that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationDoOnly(_SyntaxTransformationDo that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationCaseExprOnly(_SyntaxTransformationCaseExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationIfOnly(_SyntaxTransformationIf that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationLabelOnly(_SyntaxTransformationLabel that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationAbstractObjectExprOnly(_SyntaxTransformationAbstractObjectExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationObjectExprOnly(_SyntaxTransformationObjectExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformation_RewriteObjectExprOnly(_SyntaxTransformation_RewriteObjectExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTryOnly(_SyntaxTransformationTry that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTupleExprOnly(_SyntaxTransformationTupleExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTypecaseOnly(_SyntaxTransformationTypecase that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationWhileOnly(_SyntaxTransformationWhile that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationForOnly(_SyntaxTransformationFor that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBigOpAppOnly(_SyntaxTransformationBigOpApp that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationAccumulatorOnly(_SyntaxTransformationAccumulator that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationArrayComprehensionOnly(_SyntaxTransformationArrayComprehension that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationAtomicExprOnly(_SyntaxTransformationAtomicExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationExitOnly(_SyntaxTransformationExit that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationSpawnOnly(_SyntaxTransformationSpawn that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationThrowOnly(_SyntaxTransformationThrow that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTryAtomicExprOnly(_SyntaxTransformationTryAtomicExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationFnExprOnly(_SyntaxTransformationFnExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationLetExprOnly(_SyntaxTransformationLetExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationLetFnOnly(_SyntaxTransformationLetFn that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationLocalVarDeclOnly(_SyntaxTransformationLocalVarDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationSimpleExprOnly(_SyntaxTransformationSimpleExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationSubscriptExprOnly(_SyntaxTransformationSubscriptExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationPrimaryOnly(_SyntaxTransformationPrimary that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationLiteralExprOnly(_SyntaxTransformationLiteralExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNumberLiteralExprOnly(_SyntaxTransformationNumberLiteralExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationFloatLiteralExprOnly(_SyntaxTransformationFloatLiteralExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationIntLiteralExprOnly(_SyntaxTransformationIntLiteralExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationCharLiteralExprOnly(_SyntaxTransformationCharLiteralExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationStringLiteralExprOnly(_SyntaxTransformationStringLiteralExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationVoidLiteralExprOnly(_SyntaxTransformationVoidLiteralExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBooleanLiteralExprOnly(_SyntaxTransformationBooleanLiteralExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationVarRefOnly(_SyntaxTransformationVarRef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationFieldRefOnly(_SyntaxTransformationFieldRef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationFunctionalRefOnly(_SyntaxTransformationFunctionalRef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationFnRefOnly(_SyntaxTransformationFnRef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationOpRefOnly(_SyntaxTransformationOpRef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformation_RewriteFnRefOnly(_SyntaxTransformation_RewriteFnRef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformation_RewriteObjectExprRefOnly(_SyntaxTransformation_RewriteObjectExprRef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationJuxtOnly(_SyntaxTransformationJuxt that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformation_RewriteFnAppOnly(_SyntaxTransformation_RewriteFnApp that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationOpExprOnly(_SyntaxTransformationOpExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationAmbiguousMultifixOpExprOnly(_SyntaxTransformationAmbiguousMultifixOpExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationChainExprOnly(_SyntaxTransformationChainExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationCoercionInvocationOnly(_SyntaxTransformationCoercionInvocation that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTraitCoercionInvocationOnly(_SyntaxTransformationTraitCoercionInvocation that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTupleCoercionInvocationOnly(_SyntaxTransformationTupleCoercionInvocation that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationArrowCoercionInvocationOnly(_SyntaxTransformationArrowCoercionInvocation that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationUnionCoercionInvocationOnly(_SyntaxTransformationUnionCoercionInvocation that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationMethodInvocationOnly(_SyntaxTransformationMethodInvocation that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationMathPrimaryOnly(_SyntaxTransformationMathPrimary that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationArrayExprOnly(_SyntaxTransformationArrayExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationArrayElementOnly(_SyntaxTransformationArrayElement that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationArrayElementsOnly(_SyntaxTransformationArrayElements that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTypeOnly(_SyntaxTransformationType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBaseTypeOnly(_SyntaxTransformationBaseType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationAnyTypeOnly(_SyntaxTransformationAnyType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBottomTypeOnly(_SyntaxTransformationBottomType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationUnknownTypeOnly(_SyntaxTransformationUnknownType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationSelfTypeOnly(_SyntaxTransformationSelfType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTraitSelfTypeOnly(_SyntaxTransformationTraitSelfType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationObjectExprTypeOnly(_SyntaxTransformationObjectExprType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNamedTypeOnly(_SyntaxTransformationNamedType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformation_InferenceVarTypeOnly(_SyntaxTransformation_InferenceVarType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationVarTypeOnly(_SyntaxTransformationVarType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTraitTypeOnly(_SyntaxTransformationTraitType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationAbbreviatedTypeOnly(_SyntaxTransformationAbbreviatedType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationArrayTypeOnly(_SyntaxTransformationArrayType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationMatrixTypeOnly(_SyntaxTransformationMatrixType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTaggedDimTypeOnly(_SyntaxTransformationTaggedDimType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTaggedUnitTypeOnly(_SyntaxTransformationTaggedUnitType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTupleTypeOnly(_SyntaxTransformationTupleType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationArrowTypeOnly(_SyntaxTransformationArrowType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBoundTypeOnly(_SyntaxTransformationBoundType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationIntersectionTypeOnly(_SyntaxTransformationIntersectionType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationUnionTypeOnly(_SyntaxTransformationUnionType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationFixedPointTypeOnly(_SyntaxTransformationFixedPointType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationLabelTypeOnly(_SyntaxTransformationLabelType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationDimExprOnly(_SyntaxTransformationDimExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationDimBaseOnly(_SyntaxTransformationDimBase that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationDimRefOnly(_SyntaxTransformationDimRef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationDimExponentOnly(_SyntaxTransformationDimExponent that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationDimUnaryOpOnly(_SyntaxTransformationDimUnaryOp that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationDimBinaryOpOnly(_SyntaxTransformationDimBinaryOp that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationPatternOnly(_SyntaxTransformationPattern that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationPatternArgsOnly(_SyntaxTransformationPatternArgs that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationPatternBindingOnly(_SyntaxTransformationPatternBinding that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationPlainPatternOnly(_SyntaxTransformationPlainPattern that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTypePatternOnly(_SyntaxTransformationTypePattern that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNestedPatternOnly(_SyntaxTransformationNestedPattern that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationStaticArgOnly(_SyntaxTransformationStaticArg that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTypeArgOnly(_SyntaxTransformationTypeArg that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationIntArgOnly(_SyntaxTransformationIntArg that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBoolArgOnly(_SyntaxTransformationBoolArg that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationOpArgOnly(_SyntaxTransformationOpArg that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationDimArgOnly(_SyntaxTransformationDimArg that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationUnitArgOnly(_SyntaxTransformationUnitArg that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationStaticExprOnly(_SyntaxTransformationStaticExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationIntExprOnly(_SyntaxTransformationIntExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationIntBaseOnly(_SyntaxTransformationIntBase that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationIntRefOnly(_SyntaxTransformationIntRef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationIntBinaryOpOnly(_SyntaxTransformationIntBinaryOp that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBoolExprOnly(_SyntaxTransformationBoolExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBoolBaseOnly(_SyntaxTransformationBoolBase that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBoolRefOnly(_SyntaxTransformationBoolRef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBoolConstraintOnly(_SyntaxTransformationBoolConstraint that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBoolUnaryOpOnly(_SyntaxTransformationBoolUnaryOp that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBoolBinaryOpOnly(_SyntaxTransformationBoolBinaryOp that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationUnitExprOnly(_SyntaxTransformationUnitExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationUnitRefOnly(_SyntaxTransformationUnitRef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationUnitBinaryOpOnly(_SyntaxTransformationUnitBinaryOp that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationEffectOnly(_SyntaxTransformationEffect that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationWhereClauseOnly(_SyntaxTransformationWhereClause that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationWhereBindingOnly(_SyntaxTransformationWhereBinding that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationWhereConstraintOnly(_SyntaxTransformationWhereConstraint that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationWhereExtendsOnly(_SyntaxTransformationWhereExtends that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationWhereTypeAliasOnly(_SyntaxTransformationWhereTypeAlias that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationWhereCoercesOnly(_SyntaxTransformationWhereCoerces that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationWhereEqualsOnly(_SyntaxTransformationWhereEquals that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationUnitConstraintOnly(_SyntaxTransformationUnitConstraint that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationIntConstraintOnly(_SyntaxTransformationIntConstraint that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBoolConstraintExprOnly(_SyntaxTransformationBoolConstraintExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationContractOnly(_SyntaxTransformationContract that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationEnsuresClauseOnly(_SyntaxTransformationEnsuresClause that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationStaticParamOnly(_SyntaxTransformationStaticParam that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNameOnly(_SyntaxTransformationName that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationAPINameOnly(_SyntaxTransformationAPIName that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationIdOrOpOrAnonymousNameOnly(_SyntaxTransformationIdOrOpOrAnonymousName that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationIdOrOpOnly(_SyntaxTransformationIdOrOp that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationIdOnly(_SyntaxTransformationId that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationOpOnly(_SyntaxTransformationOp that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNamedOpOnly(_SyntaxTransformationNamedOp that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformation_InferenceVarOpOnly(_SyntaxTransformation_InferenceVarOp that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationAnonymousNameOnly(_SyntaxTransformationAnonymousName that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationAnonymousFnNameOnly(_SyntaxTransformationAnonymousFnName that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationConstructorFnNameOnly(_SyntaxTransformationConstructorFnName that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationArrayComprehensionClauseOnly(_SyntaxTransformationArrayComprehensionClause that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationKeywordExprOnly(_SyntaxTransformationKeywordExpr that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationCaseClauseOnly(_SyntaxTransformationCaseClause that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationCatchOnly(_SyntaxTransformationCatch that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationCatchClauseOnly(_SyntaxTransformationCatchClause that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationIfClauseOnly(_SyntaxTransformationIfClause that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTypecaseClauseOnly(_SyntaxTransformationTypecaseClause that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationExtentRangeOnly(_SyntaxTransformationExtentRange that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationGeneratorClauseOnly(_SyntaxTransformationGeneratorClause that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationKeywordTypeOnly(_SyntaxTransformationKeywordType that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTraitTypeWhereOnly(_SyntaxTransformationTraitTypeWhere that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationIndicesOnly(_SyntaxTransformationIndices that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationMathItemOnly(_SyntaxTransformationMathItem that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationExprMIOnly(_SyntaxTransformationExprMI that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationParenthesisDelimitedMIOnly(_SyntaxTransformationParenthesisDelimitedMI that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNonParenthesisDelimitedMIOnly(_SyntaxTransformationNonParenthesisDelimitedMI that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNonExprMIOnly(_SyntaxTransformationNonExprMI that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationExponentiationMIOnly(_SyntaxTransformationExponentiationMI that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationSubscriptingMIOnly(_SyntaxTransformationSubscriptingMI that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationOverloadingOnly(_SyntaxTransformationOverloading that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNonterminalHeaderOnly(_SyntaxTransformationNonterminalHeader that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNonterminalParameterOnly(_SyntaxTransformationNonterminalParameter that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationSyntaxDeclOnly(_SyntaxTransformationSyntaxDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationSyntaxDefOnly(_SyntaxTransformationSyntaxDef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationSuperSyntaxDefOnly(_SyntaxTransformationSuperSyntaxDef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTransformerDeclOnly(_SyntaxTransformationTransformerDecl that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationPreTransformerDefOnly(_SyntaxTransformationPreTransformerDef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNamedTransformerDefOnly(_SyntaxTransformationNamedTransformerDef that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTransformerOnly(_SyntaxTransformationTransformer that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationUnparsedTransformerOnly(_SyntaxTransformationUnparsedTransformer that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNodeTransformerOnly(_SyntaxTransformationNodeTransformer that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationCaseTransformerOnly(_SyntaxTransformationCaseTransformer that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationCaseTransformerClauseOnly(_SyntaxTransformationCaseTransformerClause that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationSyntaxSymbolOnly(_SyntaxTransformationSyntaxSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationPrefixedSymbolOnly(_SyntaxTransformationPrefixedSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationOptionalSymbolOnly(_SyntaxTransformationOptionalSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationRepeatSymbolOnly(_SyntaxTransformationRepeatSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationRepeatOneOrMoreSymbolOnly(_SyntaxTransformationRepeatOneOrMoreSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNoWhitespaceSymbolOnly(_SyntaxTransformationNoWhitespaceSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationGroupSymbolOnly(_SyntaxTransformationGroupSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationSpecialSymbolOnly(_SyntaxTransformationSpecialSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationAnyCharacterSymbolOnly(_SyntaxTransformationAnyCharacterSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationWhitespaceSymbolOnly(_SyntaxTransformationWhitespaceSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTabSymbolOnly(_SyntaxTransformationTabSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationFormfeedSymbolOnly(_SyntaxTransformationFormfeedSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationCarriageReturnSymbolOnly(_SyntaxTransformationCarriageReturnSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBackspaceSymbolOnly(_SyntaxTransformationBackspaceSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNewlineSymbolOnly(_SyntaxTransformationNewlineSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationBreaklineSymbolOnly(_SyntaxTransformationBreaklineSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationItemSymbolOnly(_SyntaxTransformationItemSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNonterminalSymbolOnly(_SyntaxTransformationNonterminalSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationKeywordSymbolOnly(_SyntaxTransformationKeywordSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationTokenSymbolOnly(_SyntaxTransformationTokenSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationNotPredicateSymbolOnly(_SyntaxTransformationNotPredicateSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationAndPredicateSymbolOnly(_SyntaxTransformationAndPredicateSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationCharacterClassSymbolOnly(_SyntaxTransformationCharacterClassSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationCharacterSymbolOnly(_SyntaxTransformationCharacterSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationCharSymbolOnly(_SyntaxTransformationCharSymbol that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationCharacterIntervalOnly(_SyntaxTransformationCharacterInterval that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_SyntaxTransformationLinkOnly(_SyntaxTransformationLink that) {
        return defaultTransformationNodeCase(that);
    }

    public Node for_EllipsesAbstractNodeOnly(_EllipsesAbstractNode that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesCompilationUnitOnly(_EllipsesCompilationUnit that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesComponentOnly(_EllipsesComponent that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesApiOnly(_EllipsesApi that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesImportOnly(_EllipsesImport that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesImportedNamesOnly(_EllipsesImportedNames that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesImportStarOnly(_EllipsesImportStar that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesImportNamesOnly(_EllipsesImportNames that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesImportApiOnly(_EllipsesImportApi that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesAliasedSimpleNameOnly(_EllipsesAliasedSimpleName that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesAliasedAPINameOnly(_EllipsesAliasedAPIName that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesDeclOnly(_EllipsesDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTraitObjectDeclOnly(_EllipsesTraitObjectDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTraitDeclOnly(_EllipsesTraitDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesObjectDeclOnly(_EllipsesObjectDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesVarDeclOnly(_EllipsesVarDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesFnDeclOnly(_EllipsesFnDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_Ellipses_RewriteFnOverloadDeclOnly(_Ellipses_RewriteFnOverloadDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_Ellipses_RewriteObjectExprDeclOnly(_Ellipses_RewriteObjectExprDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_Ellipses_RewriteFunctionalMethodDeclOnly(_Ellipses_RewriteFunctionalMethodDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesDimUnitDeclOnly(_EllipsesDimUnitDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesDimDeclOnly(_EllipsesDimDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesUnitDeclOnly(_EllipsesUnitDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTestDeclOnly(_EllipsesTestDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesPropertyDeclOnly(_EllipsesPropertyDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTypeAliasOnly(_EllipsesTypeAlias that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesGrammarDeclOnly(_EllipsesGrammarDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesGrammarMemberDeclOnly(_EllipsesGrammarMemberDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNonterminalDeclOnly(_EllipsesNonterminalDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNonterminalDefOnly(_EllipsesNonterminalDef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNonterminalExtensionDefOnly(_EllipsesNonterminalExtensionDef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBindingOnly(_EllipsesBinding that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesLValueOnly(_EllipsesLValue that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesParamOnly(_EllipsesParam that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesExprOnly(_EllipsesExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesDummyExprOnly(_EllipsesDummyExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTypeAnnotatedExprOnly(_EllipsesTypeAnnotatedExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesAsExprOnly(_EllipsesAsExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesAsIfExprOnly(_EllipsesAsIfExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesAssignmentOnly(_EllipsesAssignment that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBlockOnly(_EllipsesBlock that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesDoOnly(_EllipsesDo that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesCaseExprOnly(_EllipsesCaseExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesIfOnly(_EllipsesIf that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesLabelOnly(_EllipsesLabel that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesAbstractObjectExprOnly(_EllipsesAbstractObjectExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesObjectExprOnly(_EllipsesObjectExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_Ellipses_RewriteObjectExprOnly(_Ellipses_RewriteObjectExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTryOnly(_EllipsesTry that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTupleExprOnly(_EllipsesTupleExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTypecaseOnly(_EllipsesTypecase that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesWhileOnly(_EllipsesWhile that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesForOnly(_EllipsesFor that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBigOpAppOnly(_EllipsesBigOpApp that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesAccumulatorOnly(_EllipsesAccumulator that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesArrayComprehensionOnly(_EllipsesArrayComprehension that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesAtomicExprOnly(_EllipsesAtomicExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesExitOnly(_EllipsesExit that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesSpawnOnly(_EllipsesSpawn that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesThrowOnly(_EllipsesThrow that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTryAtomicExprOnly(_EllipsesTryAtomicExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesFnExprOnly(_EllipsesFnExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesLetExprOnly(_EllipsesLetExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesLetFnOnly(_EllipsesLetFn that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesLocalVarDeclOnly(_EllipsesLocalVarDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesSimpleExprOnly(_EllipsesSimpleExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesSubscriptExprOnly(_EllipsesSubscriptExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesPrimaryOnly(_EllipsesPrimary that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesLiteralExprOnly(_EllipsesLiteralExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNumberLiteralExprOnly(_EllipsesNumberLiteralExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesFloatLiteralExprOnly(_EllipsesFloatLiteralExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesIntLiteralExprOnly(_EllipsesIntLiteralExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesCharLiteralExprOnly(_EllipsesCharLiteralExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesStringLiteralExprOnly(_EllipsesStringLiteralExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesVoidLiteralExprOnly(_EllipsesVoidLiteralExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBooleanLiteralExprOnly(_EllipsesBooleanLiteralExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesVarRefOnly(_EllipsesVarRef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesFieldRefOnly(_EllipsesFieldRef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesFunctionalRefOnly(_EllipsesFunctionalRef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesFnRefOnly(_EllipsesFnRef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesOpRefOnly(_EllipsesOpRef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_Ellipses_RewriteFnRefOnly(_Ellipses_RewriteFnRef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_Ellipses_RewriteObjectExprRefOnly(_Ellipses_RewriteObjectExprRef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesJuxtOnly(_EllipsesJuxt that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_Ellipses_RewriteFnAppOnly(_Ellipses_RewriteFnApp that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesOpExprOnly(_EllipsesOpExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesAmbiguousMultifixOpExprOnly(_EllipsesAmbiguousMultifixOpExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesChainExprOnly(_EllipsesChainExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesCoercionInvocationOnly(_EllipsesCoercionInvocation that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTraitCoercionInvocationOnly(_EllipsesTraitCoercionInvocation that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTupleCoercionInvocationOnly(_EllipsesTupleCoercionInvocation that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesArrowCoercionInvocationOnly(_EllipsesArrowCoercionInvocation that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesUnionCoercionInvocationOnly(_EllipsesUnionCoercionInvocation that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesMethodInvocationOnly(_EllipsesMethodInvocation that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesMathPrimaryOnly(_EllipsesMathPrimary that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesArrayExprOnly(_EllipsesArrayExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesArrayElementOnly(_EllipsesArrayElement that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesArrayElementsOnly(_EllipsesArrayElements that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTypeOnly(_EllipsesType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBaseTypeOnly(_EllipsesBaseType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesAnyTypeOnly(_EllipsesAnyType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBottomTypeOnly(_EllipsesBottomType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesUnknownTypeOnly(_EllipsesUnknownType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesSelfTypeOnly(_EllipsesSelfType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTraitSelfTypeOnly(_EllipsesTraitSelfType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesObjectExprTypeOnly(_EllipsesObjectExprType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNamedTypeOnly(_EllipsesNamedType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_Ellipses_InferenceVarTypeOnly(_Ellipses_InferenceVarType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesVarTypeOnly(_EllipsesVarType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTraitTypeOnly(_EllipsesTraitType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesAbbreviatedTypeOnly(_EllipsesAbbreviatedType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesArrayTypeOnly(_EllipsesArrayType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesMatrixTypeOnly(_EllipsesMatrixType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTaggedDimTypeOnly(_EllipsesTaggedDimType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTaggedUnitTypeOnly(_EllipsesTaggedUnitType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTupleTypeOnly(_EllipsesTupleType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesArrowTypeOnly(_EllipsesArrowType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBoundTypeOnly(_EllipsesBoundType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesIntersectionTypeOnly(_EllipsesIntersectionType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesUnionTypeOnly(_EllipsesUnionType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesFixedPointTypeOnly(_EllipsesFixedPointType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesLabelTypeOnly(_EllipsesLabelType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesDimExprOnly(_EllipsesDimExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesDimBaseOnly(_EllipsesDimBase that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesDimRefOnly(_EllipsesDimRef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesDimExponentOnly(_EllipsesDimExponent that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesDimUnaryOpOnly(_EllipsesDimUnaryOp that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesDimBinaryOpOnly(_EllipsesDimBinaryOp that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesPatternOnly(_EllipsesPattern that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesPatternArgsOnly(_EllipsesPatternArgs that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesPatternBindingOnly(_EllipsesPatternBinding that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesPlainPatternOnly(_EllipsesPlainPattern that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTypePatternOnly(_EllipsesTypePattern that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNestedPatternOnly(_EllipsesNestedPattern that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesStaticArgOnly(_EllipsesStaticArg that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTypeArgOnly(_EllipsesTypeArg that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesIntArgOnly(_EllipsesIntArg that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBoolArgOnly(_EllipsesBoolArg that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesOpArgOnly(_EllipsesOpArg that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesDimArgOnly(_EllipsesDimArg that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesUnitArgOnly(_EllipsesUnitArg that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesStaticExprOnly(_EllipsesStaticExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesIntExprOnly(_EllipsesIntExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesIntBaseOnly(_EllipsesIntBase that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesIntRefOnly(_EllipsesIntRef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesIntBinaryOpOnly(_EllipsesIntBinaryOp that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBoolExprOnly(_EllipsesBoolExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBoolBaseOnly(_EllipsesBoolBase that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBoolRefOnly(_EllipsesBoolRef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBoolConstraintOnly(_EllipsesBoolConstraint that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBoolUnaryOpOnly(_EllipsesBoolUnaryOp that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBoolBinaryOpOnly(_EllipsesBoolBinaryOp that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesUnitExprOnly(_EllipsesUnitExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesUnitRefOnly(_EllipsesUnitRef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesUnitBinaryOpOnly(_EllipsesUnitBinaryOp that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesEffectOnly(_EllipsesEffect that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesWhereClauseOnly(_EllipsesWhereClause that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesWhereBindingOnly(_EllipsesWhereBinding that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesWhereConstraintOnly(_EllipsesWhereConstraint that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesWhereExtendsOnly(_EllipsesWhereExtends that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesWhereTypeAliasOnly(_EllipsesWhereTypeAlias that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesWhereCoercesOnly(_EllipsesWhereCoerces that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesWhereEqualsOnly(_EllipsesWhereEquals that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesUnitConstraintOnly(_EllipsesUnitConstraint that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesIntConstraintOnly(_EllipsesIntConstraint that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBoolConstraintExprOnly(_EllipsesBoolConstraintExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesContractOnly(_EllipsesContract that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesEnsuresClauseOnly(_EllipsesEnsuresClause that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesStaticParamOnly(_EllipsesStaticParam that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNameOnly(_EllipsesName that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesAPINameOnly(_EllipsesAPIName that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesIdOrOpOrAnonymousNameOnly(_EllipsesIdOrOpOrAnonymousName that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesIdOrOpOnly(_EllipsesIdOrOp that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesIdOnly(_EllipsesId that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesOpOnly(_EllipsesOp that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNamedOpOnly(_EllipsesNamedOp that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_Ellipses_InferenceVarOpOnly(_Ellipses_InferenceVarOp that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesAnonymousNameOnly(_EllipsesAnonymousName that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesAnonymousFnNameOnly(_EllipsesAnonymousFnName that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesConstructorFnNameOnly(_EllipsesConstructorFnName that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesArrayComprehensionClauseOnly(_EllipsesArrayComprehensionClause that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesKeywordExprOnly(_EllipsesKeywordExpr that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesCaseClauseOnly(_EllipsesCaseClause that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesCatchOnly(_EllipsesCatch that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesCatchClauseOnly(_EllipsesCatchClause that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesIfClauseOnly(_EllipsesIfClause that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTypecaseClauseOnly(_EllipsesTypecaseClause that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesExtentRangeOnly(_EllipsesExtentRange that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesGeneratorClauseOnly(_EllipsesGeneratorClause that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesKeywordTypeOnly(_EllipsesKeywordType that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTraitTypeWhereOnly(_EllipsesTraitTypeWhere that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesIndicesOnly(_EllipsesIndices that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesMathItemOnly(_EllipsesMathItem that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesExprMIOnly(_EllipsesExprMI that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesParenthesisDelimitedMIOnly(_EllipsesParenthesisDelimitedMI that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNonParenthesisDelimitedMIOnly(_EllipsesNonParenthesisDelimitedMI that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNonExprMIOnly(_EllipsesNonExprMI that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesExponentiationMIOnly(_EllipsesExponentiationMI that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesSubscriptingMIOnly(_EllipsesSubscriptingMI that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesOverloadingOnly(_EllipsesOverloading that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNonterminalHeaderOnly(_EllipsesNonterminalHeader that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNonterminalParameterOnly(_EllipsesNonterminalParameter that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesSyntaxDeclOnly(_EllipsesSyntaxDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesSyntaxDefOnly(_EllipsesSyntaxDef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesSuperSyntaxDefOnly(_EllipsesSuperSyntaxDef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTransformerDeclOnly(_EllipsesTransformerDecl that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesPreTransformerDefOnly(_EllipsesPreTransformerDef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNamedTransformerDefOnly(_EllipsesNamedTransformerDef that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTransformerOnly(_EllipsesTransformer that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesUnparsedTransformerOnly(_EllipsesUnparsedTransformer that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNodeTransformerOnly(_EllipsesNodeTransformer that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesCaseTransformerOnly(_EllipsesCaseTransformer that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesCaseTransformerClauseOnly(_EllipsesCaseTransformerClause that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesSyntaxSymbolOnly(_EllipsesSyntaxSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesPrefixedSymbolOnly(_EllipsesPrefixedSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesOptionalSymbolOnly(_EllipsesOptionalSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesRepeatSymbolOnly(_EllipsesRepeatSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesRepeatOneOrMoreSymbolOnly(_EllipsesRepeatOneOrMoreSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNoWhitespaceSymbolOnly(_EllipsesNoWhitespaceSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesGroupSymbolOnly(_EllipsesGroupSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesSpecialSymbolOnly(_EllipsesSpecialSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesAnyCharacterSymbolOnly(_EllipsesAnyCharacterSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesWhitespaceSymbolOnly(_EllipsesWhitespaceSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTabSymbolOnly(_EllipsesTabSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesFormfeedSymbolOnly(_EllipsesFormfeedSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesCarriageReturnSymbolOnly(_EllipsesCarriageReturnSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBackspaceSymbolOnly(_EllipsesBackspaceSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNewlineSymbolOnly(_EllipsesNewlineSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesBreaklineSymbolOnly(_EllipsesBreaklineSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesItemSymbolOnly(_EllipsesItemSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNonterminalSymbolOnly(_EllipsesNonterminalSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesKeywordSymbolOnly(_EllipsesKeywordSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesTokenSymbolOnly(_EllipsesTokenSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesNotPredicateSymbolOnly(_EllipsesNotPredicateSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesAndPredicateSymbolOnly(_EllipsesAndPredicateSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesCharacterClassSymbolOnly(_EllipsesCharacterClassSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesCharacterSymbolOnly(_EllipsesCharacterSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesCharSymbolOnly(_EllipsesCharSymbol that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesCharacterIntervalOnly(_EllipsesCharacterInterval that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node for_EllipsesLinkOnly(_EllipsesLink that) {
        return defaultEllipsesNodeOnly(that);
    }

    public Node forTemplateGapAbstractNodeOnly(TemplateGapAbstractNode that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAbstractNode(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapCompilationUnitOnly(TemplateGapCompilationUnit that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCompilationUnit(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapComponentOnly(TemplateGapComponent that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapComponent(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapApiOnly(TemplateGapApi that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapApi(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapImportOnly(TemplateGapImport that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapImport(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapImportedNamesOnly(TemplateGapImportedNames that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapImportedNames(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapImportStarOnly(TemplateGapImportStar that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapImportStar(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapImportNamesOnly(TemplateGapImportNames that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapImportNames(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapImportApiOnly(TemplateGapImportApi that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapImportApi(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapAliasedSimpleNameOnly(TemplateGapAliasedSimpleName that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAliasedSimpleName(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapAliasedAPINameOnly(TemplateGapAliasedAPIName that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAliasedAPIName(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapDeclOnly(TemplateGapDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTraitObjectDeclOnly(TemplateGapTraitObjectDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTraitObjectDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTraitDeclOnly(TemplateGapTraitDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTraitDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapObjectDeclOnly(TemplateGapObjectDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapObjectDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapVarDeclOnly(TemplateGapVarDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapVarDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapFnDeclOnly(TemplateGapFnDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFnDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGap_RewriteFnOverloadDeclOnly(TemplateGap_RewriteFnOverloadDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteFnOverloadDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGap_RewriteObjectExprDeclOnly(TemplateGap_RewriteObjectExprDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteObjectExprDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGap_RewriteFunctionalMethodDeclOnly(TemplateGap_RewriteFunctionalMethodDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteFunctionalMethodDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapDimUnitDeclOnly(TemplateGapDimUnitDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimUnitDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapDimDeclOnly(TemplateGapDimDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapUnitDeclOnly(TemplateGapUnitDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnitDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTestDeclOnly(TemplateGapTestDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTestDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapPropertyDeclOnly(TemplateGapPropertyDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPropertyDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTypeAliasOnly(TemplateGapTypeAlias that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTypeAlias(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapGrammarDeclOnly(TemplateGapGrammarDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapGrammarDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapGrammarMemberDeclOnly(TemplateGapGrammarMemberDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapGrammarMemberDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNonterminalDeclOnly(TemplateGapNonterminalDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNonterminalDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNonterminalDefOnly(TemplateGapNonterminalDef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNonterminalDef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNonterminalExtensionDefOnly(TemplateGapNonterminalExtensionDef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNonterminalExtensionDef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBindingOnly(TemplateGapBinding that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBinding(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapLValueOnly(TemplateGapLValue that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLValue(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapParamOnly(TemplateGapParam that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapParam(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapExprOnly(TemplateGapExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapDummyExprOnly(TemplateGapDummyExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDummyExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTypeAnnotatedExprOnly(TemplateGapTypeAnnotatedExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTypeAnnotatedExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapAsExprOnly(TemplateGapAsExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAsExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapAsIfExprOnly(TemplateGapAsIfExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAsIfExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapAssignmentOnly(TemplateGapAssignment that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAssignment(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBlockOnly(TemplateGapBlock that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBlock(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapDoOnly(TemplateGapDo that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDo(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapCaseExprOnly(TemplateGapCaseExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCaseExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapIfOnly(TemplateGapIf that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIf(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapLabelOnly(TemplateGapLabel that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLabel(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapAbstractObjectExprOnly(TemplateGapAbstractObjectExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAbstractObjectExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapObjectExprOnly(TemplateGapObjectExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapObjectExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGap_RewriteObjectExprOnly(TemplateGap_RewriteObjectExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteObjectExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTryOnly(TemplateGapTry that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTry(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTupleExprOnly(TemplateGapTupleExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTupleExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTypecaseOnly(TemplateGapTypecase that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTypecase(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapWhileOnly(TemplateGapWhile that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhile(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapForOnly(TemplateGapFor that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFor(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBigOpAppOnly(TemplateGapBigOpApp that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBigOpApp(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapAccumulatorOnly(TemplateGapAccumulator that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAccumulator(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapArrayComprehensionOnly(TemplateGapArrayComprehension that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayComprehension(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapAtomicExprOnly(TemplateGapAtomicExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAtomicExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapExitOnly(TemplateGapExit that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapExit(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapSpawnOnly(TemplateGapSpawn that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSpawn(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapThrowOnly(TemplateGapThrow that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapThrow(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTryAtomicExprOnly(TemplateGapTryAtomicExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTryAtomicExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapFnExprOnly(TemplateGapFnExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFnExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapLetExprOnly(TemplateGapLetExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLetExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapLetFnOnly(TemplateGapLetFn that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLetFn(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapLocalVarDeclOnly(TemplateGapLocalVarDecl that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLocalVarDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapSimpleExprOnly(TemplateGapSimpleExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSimpleExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapSubscriptExprOnly(TemplateGapSubscriptExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSubscriptExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapPrimaryOnly(TemplateGapPrimary that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPrimary(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapLiteralExprOnly(TemplateGapLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNumberLiteralExprOnly(TemplateGapNumberLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNumberLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapFloatLiteralExprOnly(TemplateGapFloatLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFloatLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapIntLiteralExprOnly(TemplateGapIntLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapCharLiteralExprOnly(TemplateGapCharLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCharLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapStringLiteralExprOnly(TemplateGapStringLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapStringLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapVoidLiteralExprOnly(TemplateGapVoidLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapVoidLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBooleanLiteralExprOnly(TemplateGapBooleanLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBooleanLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapVarRefOnly(TemplateGapVarRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapVarRef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapFieldRefOnly(TemplateGapFieldRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFieldRef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapFunctionalRefOnly(TemplateGapFunctionalRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFunctionalRef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapFnRefOnly(TemplateGapFnRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFnRef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapOpRefOnly(TemplateGapOpRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapOpRef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGap_RewriteFnRefOnly(TemplateGap_RewriteFnRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteFnRef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGap_RewriteObjectExprRefOnly(TemplateGap_RewriteObjectExprRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteObjectExprRef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapJuxtOnly(TemplateGapJuxt that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapJuxt(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGap_RewriteFnAppOnly(TemplateGap_RewriteFnApp that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteFnApp(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapOpExprOnly(TemplateGapOpExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapOpExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapAmbiguousMultifixOpExprOnly(TemplateGapAmbiguousMultifixOpExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAmbiguousMultifixOpExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapChainExprOnly(TemplateGapChainExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapChainExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapCoercionInvocationOnly(TemplateGapCoercionInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCoercionInvocation(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTraitCoercionInvocationOnly(TemplateGapTraitCoercionInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTraitCoercionInvocation(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTupleCoercionInvocationOnly(TemplateGapTupleCoercionInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTupleCoercionInvocation(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapArrowCoercionInvocationOnly(TemplateGapArrowCoercionInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrowCoercionInvocation(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapUnionCoercionInvocationOnly(TemplateGapUnionCoercionInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnionCoercionInvocation(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapMethodInvocationOnly(TemplateGapMethodInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapMethodInvocation(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapMathPrimaryOnly(TemplateGapMathPrimary that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapMathPrimary(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapArrayExprOnly(TemplateGapArrayExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapArrayElementOnly(TemplateGapArrayElement that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayElement(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapArrayElementsOnly(TemplateGapArrayElements that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayElements(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTypeOnly(TemplateGapType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBaseTypeOnly(TemplateGapBaseType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBaseType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapAnyTypeOnly(TemplateGapAnyType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAnyType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBottomTypeOnly(TemplateGapBottomType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBottomType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapUnknownTypeOnly(TemplateGapUnknownType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnknownType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapSelfTypeOnly(TemplateGapSelfType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSelfType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTraitSelfTypeOnly(TemplateGapTraitSelfType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTraitSelfType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapObjectExprTypeOnly(TemplateGapObjectExprType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapObjectExprType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNamedTypeOnly(TemplateGapNamedType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNamedType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGap_InferenceVarTypeOnly(TemplateGap_InferenceVarType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_InferenceVarType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapVarTypeOnly(TemplateGapVarType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapVarType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTraitTypeOnly(TemplateGapTraitType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTraitType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapAbbreviatedTypeOnly(TemplateGapAbbreviatedType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAbbreviatedType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapArrayTypeOnly(TemplateGapArrayType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapMatrixTypeOnly(TemplateGapMatrixType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapMatrixType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTaggedDimTypeOnly(TemplateGapTaggedDimType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTaggedDimType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTaggedUnitTypeOnly(TemplateGapTaggedUnitType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTaggedUnitType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTupleTypeOnly(TemplateGapTupleType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTupleType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapArrowTypeOnly(TemplateGapArrowType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrowType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBoundTypeOnly(TemplateGapBoundType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoundType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapIntersectionTypeOnly(TemplateGapIntersectionType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntersectionType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapUnionTypeOnly(TemplateGapUnionType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnionType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapFixedPointTypeOnly(TemplateGapFixedPointType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFixedPointType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapLabelTypeOnly(TemplateGapLabelType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLabelType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapDimExprOnly(TemplateGapDimExpr that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapDimBaseOnly(TemplateGapDimBase that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimBase(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapDimRefOnly(TemplateGapDimRef that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimRef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapDimExponentOnly(TemplateGapDimExponent that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimExponent(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapDimUnaryOpOnly(TemplateGapDimUnaryOp that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimUnaryOp(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapDimBinaryOpOnly(TemplateGapDimBinaryOp that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimBinaryOp(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapPatternOnly(TemplateGapPattern that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPattern(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapPatternArgsOnly(TemplateGapPatternArgs that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPatternArgs(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapPatternBindingOnly(TemplateGapPatternBinding that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPatternBinding(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapPlainPatternOnly(TemplateGapPlainPattern that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPlainPattern(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTypePatternOnly(TemplateGapTypePattern that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTypePattern(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNestedPatternOnly(TemplateGapNestedPattern that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNestedPattern(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapStaticArgOnly(TemplateGapStaticArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapStaticArg(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTypeArgOnly(TemplateGapTypeArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTypeArg(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapIntArgOnly(TemplateGapIntArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntArg(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBoolArgOnly(TemplateGapBoolArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolArg(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapOpArgOnly(TemplateGapOpArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapOpArg(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapDimArgOnly(TemplateGapDimArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimArg(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapUnitArgOnly(TemplateGapUnitArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnitArg(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapStaticExprOnly(TemplateGapStaticExpr that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapStaticExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapIntExprOnly(TemplateGapIntExpr that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapIntBaseOnly(TemplateGapIntBase that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntBase(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapIntRefOnly(TemplateGapIntRef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntRef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapIntBinaryOpOnly(TemplateGapIntBinaryOp that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntBinaryOp(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBoolExprOnly(TemplateGapBoolExpr that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBoolBaseOnly(TemplateGapBoolBase that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolBase(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBoolRefOnly(TemplateGapBoolRef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolRef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBoolConstraintOnly(TemplateGapBoolConstraint that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolConstraint(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBoolUnaryOpOnly(TemplateGapBoolUnaryOp that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolUnaryOp(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBoolBinaryOpOnly(TemplateGapBoolBinaryOp that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolBinaryOp(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapUnitExprOnly(TemplateGapUnitExpr that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnitExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapUnitRefOnly(TemplateGapUnitRef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnitRef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapUnitBinaryOpOnly(TemplateGapUnitBinaryOp that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnitBinaryOp(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapEffectOnly(TemplateGapEffect that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapEffect(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapWhereClauseOnly(TemplateGapWhereClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhereClause(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapWhereBindingOnly(TemplateGapWhereBinding that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhereBinding(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapWhereConstraintOnly(TemplateGapWhereConstraint that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhereConstraint(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapWhereExtendsOnly(TemplateGapWhereExtends that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhereExtends(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapWhereTypeAliasOnly(TemplateGapWhereTypeAlias that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhereTypeAlias(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapWhereCoercesOnly(TemplateGapWhereCoerces that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhereCoerces(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapWhereEqualsOnly(TemplateGapWhereEquals that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhereEquals(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapUnitConstraintOnly(TemplateGapUnitConstraint that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnitConstraint(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapIntConstraintOnly(TemplateGapIntConstraint that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntConstraint(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBoolConstraintExprOnly(TemplateGapBoolConstraintExpr that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolConstraintExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapContractOnly(TemplateGapContract that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapContract(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapEnsuresClauseOnly(TemplateGapEnsuresClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapEnsuresClause(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapStaticParamOnly(TemplateGapStaticParam that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapStaticParam(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNameOnly(TemplateGapName that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapName(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapAPINameOnly(TemplateGapAPIName that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAPIName(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapIdOrOpOrAnonymousNameOnly(TemplateGapIdOrOpOrAnonymousName that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIdOrOpOrAnonymousName(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapIdOrOpOnly(TemplateGapIdOrOp that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIdOrOp(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapIdOnly(TemplateGapId that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapId(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapOpOnly(TemplateGapOp that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapOp(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNamedOpOnly(TemplateGapNamedOp that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNamedOp(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGap_InferenceVarOpOnly(TemplateGap_InferenceVarOp that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_InferenceVarOp(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapAnonymousNameOnly(TemplateGapAnonymousName that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAnonymousName(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapAnonymousFnNameOnly(TemplateGapAnonymousFnName that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAnonymousFnName(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapConstructorFnNameOnly(TemplateGapConstructorFnName that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapConstructorFnName(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapArrayComprehensionClauseOnly(TemplateGapArrayComprehensionClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayComprehensionClause(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapKeywordExprOnly(TemplateGapKeywordExpr that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapKeywordExpr(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapCaseClauseOnly(TemplateGapCaseClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCaseClause(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapCatchOnly(TemplateGapCatch that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCatch(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapCatchClauseOnly(TemplateGapCatchClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCatchClause(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapIfClauseOnly(TemplateGapIfClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIfClause(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTypecaseClauseOnly(TemplateGapTypecaseClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTypecaseClause(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapExtentRangeOnly(TemplateGapExtentRange that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapExtentRange(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapGeneratorClauseOnly(TemplateGapGeneratorClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapGeneratorClause(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapKeywordTypeOnly(TemplateGapKeywordType that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapKeywordType(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTraitTypeWhereOnly(TemplateGapTraitTypeWhere that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTraitTypeWhere(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapIndicesOnly(TemplateGapIndices that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIndices(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapMathItemOnly(TemplateGapMathItem that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapMathItem(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapExprMIOnly(TemplateGapExprMI that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapExprMI(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapParenthesisDelimitedMIOnly(TemplateGapParenthesisDelimitedMI that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapParenthesisDelimitedMI(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNonParenthesisDelimitedMIOnly(TemplateGapNonParenthesisDelimitedMI that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNonParenthesisDelimitedMI(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNonExprMIOnly(TemplateGapNonExprMI that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNonExprMI(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapExponentiationMIOnly(TemplateGapExponentiationMI that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapExponentiationMI(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapSubscriptingMIOnly(TemplateGapSubscriptingMI that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSubscriptingMI(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapOverloadingOnly(TemplateGapOverloading that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapOverloading(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNonterminalHeaderOnly(TemplateGapNonterminalHeader that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNonterminalHeader(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNonterminalParameterOnly(TemplateGapNonterminalParameter that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNonterminalParameter(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapSyntaxDeclOnly(TemplateGapSyntaxDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSyntaxDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapSyntaxDefOnly(TemplateGapSyntaxDef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSyntaxDef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapSuperSyntaxDefOnly(TemplateGapSuperSyntaxDef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSuperSyntaxDef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTransformerDeclOnly(TemplateGapTransformerDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTransformerDecl(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapPreTransformerDefOnly(TemplateGapPreTransformerDef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPreTransformerDef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNamedTransformerDefOnly(TemplateGapNamedTransformerDef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNamedTransformerDef(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTransformerOnly(TemplateGapTransformer that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTransformer(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapUnparsedTransformerOnly(TemplateGapUnparsedTransformer that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnparsedTransformer(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNodeTransformerOnly(TemplateGapNodeTransformer that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNodeTransformer(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapCaseTransformerOnly(TemplateGapCaseTransformer that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCaseTransformer(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapCaseTransformerClauseOnly(TemplateGapCaseTransformerClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCaseTransformerClause(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapSyntaxSymbolOnly(TemplateGapSyntaxSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSyntaxSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapPrefixedSymbolOnly(TemplateGapPrefixedSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPrefixedSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapOptionalSymbolOnly(TemplateGapOptionalSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapOptionalSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapRepeatSymbolOnly(TemplateGapRepeatSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapRepeatSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapRepeatOneOrMoreSymbolOnly(TemplateGapRepeatOneOrMoreSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapRepeatOneOrMoreSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNoWhitespaceSymbolOnly(TemplateGapNoWhitespaceSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNoWhitespaceSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapGroupSymbolOnly(TemplateGapGroupSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapGroupSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapSpecialSymbolOnly(TemplateGapSpecialSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSpecialSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapAnyCharacterSymbolOnly(TemplateGapAnyCharacterSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAnyCharacterSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapWhitespaceSymbolOnly(TemplateGapWhitespaceSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhitespaceSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTabSymbolOnly(TemplateGapTabSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTabSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapFormfeedSymbolOnly(TemplateGapFormfeedSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFormfeedSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapCarriageReturnSymbolOnly(TemplateGapCarriageReturnSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCarriageReturnSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBackspaceSymbolOnly(TemplateGapBackspaceSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBackspaceSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNewlineSymbolOnly(TemplateGapNewlineSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNewlineSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapBreaklineSymbolOnly(TemplateGapBreaklineSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBreaklineSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapItemSymbolOnly(TemplateGapItemSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapItemSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNonterminalSymbolOnly(TemplateGapNonterminalSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNonterminalSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapKeywordSymbolOnly(TemplateGapKeywordSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapKeywordSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapTokenSymbolOnly(TemplateGapTokenSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTokenSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapNotPredicateSymbolOnly(TemplateGapNotPredicateSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNotPredicateSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapAndPredicateSymbolOnly(TemplateGapAndPredicateSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAndPredicateSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapCharacterClassSymbolOnly(TemplateGapCharacterClassSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCharacterClassSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapCharacterSymbolOnly(TemplateGapCharacterSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCharacterSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapCharSymbolOnly(TemplateGapCharSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCharSymbol(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapCharacterIntervalOnly(TemplateGapCharacterInterval that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCharacterInterval(info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapLinkOnly(TemplateGapLink that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLink(info_result, gapId_result, templateParams_result);
    }

    /** Methods to recur on each child. */

    public Node forComponent(Component that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        APIName name_result = (APIName) recur(that.getName());
        List<Import> imports_result = recurOnListOfImport(that.getImports());
        List<Decl> decls_result = recurOnListOfDecl(that.getDecls());
        List<APIName> comprises_result = recurOnListOfAPIName(that.getComprises());
        List<APIName> exports_result = recurOnListOfAPIName(that.getExports());
        return forComponentOnly(that, info_result, name_result, imports_result, decls_result, comprises_result, exports_result);
    }


    public Node forApi(Api that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        APIName name_result = (APIName) recur(that.getName());
        List<Import> imports_result = recurOnListOfImport(that.getImports());
        List<Decl> decls_result = recurOnListOfDecl(that.getDecls());
        List<APIName> comprises_result = recurOnListOfAPIName(that.getComprises());
        return forApiOnly(that, info_result, name_result, imports_result, decls_result, comprises_result);
    }


    public Node forImportStar(ImportStar that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        APIName apiName_result = (APIName) recur(that.getApiName());
        List<IdOrOpOrAnonymousName> exceptNames_result = recurOnListOfIdOrOpOrAnonymousName(that.getExceptNames());
        return forImportStarOnly(that, info_result, apiName_result, exceptNames_result);
    }


    public Node forImportNames(ImportNames that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        APIName apiName_result = (APIName) recur(that.getApiName());
        List<AliasedSimpleName> aliasedNames_result = recurOnListOfAliasedSimpleName(that.getAliasedNames());
        return forImportNamesOnly(that, info_result, apiName_result, aliasedNames_result);
    }


    public Node forImportApi(ImportApi that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        List<AliasedAPIName> apis_result = recurOnListOfAliasedAPIName(that.getApis());
        return forImportApiOnly(that, info_result, apis_result);
    }


    public Node forAliasedSimpleName(AliasedSimpleName that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        IdOrOpOrAnonymousName name_result = (IdOrOpOrAnonymousName) recur(that.getName());
        Option<IdOrOpOrAnonymousName> alias_result = recurOnOptionOfIdOrOpOrAnonymousName(that.getAlias());
        return forAliasedSimpleNameOnly(that, info_result, name_result, alias_result);
    }


    public Node forAliasedAPIName(AliasedAPIName that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        APIName apiName_result = (APIName) recur(that.getApiName());
        Option<Id> alias_result = recurOnOptionOfId(that.getAlias());
        return forAliasedAPINameOnly(that, info_result, apiName_result, alias_result);
    }


    public Node forTraitDecl(TraitDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        TraitTypeHeader header_result = (TraitTypeHeader) recur(that.getHeader());
        Option<SelfType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        List<BaseType> excludesClause_result = recurOnListOfBaseType(that.getExcludesClause());
        Option<List<NamedType>> comprisesClause_result = recurOnOptionOfListOfNamedType(that.getComprisesClause());
        return forTraitDeclOnly(that, info_result, header_result, selfType_result, excludesClause_result, comprisesClause_result);
    }


    public Node forObjectDecl(ObjectDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        TraitTypeHeader header_result = (TraitTypeHeader) recur(that.getHeader());
        Option<SelfType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        return forObjectDeclOnly(that, info_result, header_result, selfType_result);
    }


    public Node forVarDecl(VarDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        List<LValue> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<Expr> init_result = recurOnOptionOfExpr(that.getInit());
        return forVarDeclOnly(that, info_result, lhs_result, init_result);
    }


    public Node forFnDecl(FnDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        FnHeader header_result = (FnHeader) recur(that.getHeader());
        IdOrOp unambiguousName_result = (IdOrOp) recur(that.getUnambiguousName());
        Option<Expr> body_result = recurOnOptionOfExpr(that.getBody());
        Option<IdOrOp> implementsUnambiguousName_result = recurOnOptionOfIdOrOp(that.getImplementsUnambiguousName());
        return forFnDeclOnly(that, info_result, header_result, unambiguousName_result, body_result, implementsUnambiguousName_result);
    }


    public Node for_RewriteFnOverloadDecl(_RewriteFnOverloadDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        IdOrOp name_result = (IdOrOp) recur(that.getName());
        List<IdOrOp> fns_result = recurOnListOfIdOrOp(that.getFns());
        Option<Type> type_result = recurOnOptionOfType(that.getType());
        return for_RewriteFnOverloadDeclOnly(that, info_result, name_result, fns_result, type_result);
    }


    public Node for_RewriteObjectExprDecl(_RewriteObjectExprDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        List<_RewriteObjectExpr> objectExprs_result = recurOnListOf_RewriteObjectExpr(that.getObjectExprs());
        return for_RewriteObjectExprDeclOnly(that, info_result, objectExprs_result);
    }


    public Node for_RewriteFunctionalMethodDecl(_RewriteFunctionalMethodDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_RewriteFunctionalMethodDeclOnly(that, info_result);
    }


    public Node forDimDecl(DimDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id dimId_result = (Id) recur(that.getDimId());
        Option<Type> derived_result = recurOnOptionOfType(that.getDerived());
        Option<Id> defaultId_result = recurOnOptionOfId(that.getDefaultId());
        return forDimDeclOnly(that, info_result, dimId_result, derived_result, defaultId_result);
    }


    public Node forUnitDecl(UnitDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        List<Id> units_result = recurOnListOfId(that.getUnits());
        Option<Type> dimType_result = recurOnOptionOfType(that.getDimType());
        Option<Expr> defExpr_result = recurOnOptionOfExpr(that.getDefExpr());
        return forUnitDeclOnly(that, info_result, units_result, dimType_result, defExpr_result);
    }


    public Node forTestDecl(TestDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        Expr expr_result = (Expr) recur(that.getExpr());
        return forTestDeclOnly(that, info_result, name_result, gens_result, expr_result);
    }


    public Node forPropertyDecl(PropertyDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Option<Id> name_result = recurOnOptionOfId(that.getName());
        List<Param> params_result = recurOnListOfParam(that.getParams());
        Expr expr_result = (Expr) recur(that.getExpr());
        return forPropertyDeclOnly(that, info_result, name_result, params_result, expr_result);
    }


    public Node forTypeAlias(TypeAlias that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<StaticParam> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        Type typeDef_result = (Type) recur(that.getTypeDef());
        return forTypeAliasOnly(that, info_result, name_result, staticParams_result, typeDef_result);
    }


    public Node forGrammarDecl(GrammarDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<Id> extendsClause_result = recurOnListOfId(that.getExtendsClause());
        List<GrammarMemberDecl> members_result = recurOnListOfGrammarMemberDecl(that.getMembers());
        List<TransformerDecl> transformers_result = recurOnListOfTransformerDecl(that.getTransformers());
        return forGrammarDeclOnly(that, info_result, name_result, extendsClause_result, members_result, transformers_result);
    }


    public Node forNonterminalDef(NonterminalDef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<SyntaxDecl> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        NonterminalHeader header_result = (NonterminalHeader) recur(that.getHeader());
        Option<BaseType> astType_result = recurOnOptionOfBaseType(that.getAstType());
        return forNonterminalDefOnly(that, info_result, name_result, syntaxDecls_result, header_result, astType_result);
    }


    public Node forNonterminalExtensionDef(NonterminalExtensionDef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<SyntaxDecl> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        return forNonterminalExtensionDefOnly(that, info_result, name_result, syntaxDecls_result);
    }


    public Node forLValue(LValue that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        Option<TypeOrPattern> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        return forLValueOnly(that, info_result, name_result, idType_result);
    }


    public Node forParam(Param that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        Option<TypeOrPattern> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        Option<Expr> defaultExpr_result = recurOnOptionOfExpr(that.getDefaultExpr());
        Option<Type> varargsType_result = recurOnOptionOfType(that.getVarargsType());
        return forParamOnly(that, info_result, name_result, idType_result, defaultExpr_result, varargsType_result);
    }


    public Node forDummyExpr(DummyExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return forDummyExprOnly(that, info_result);
    }


    public Node forAsExpr(AsExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Expr expr_result = (Expr) recur(that.getExpr());
        Type annType_result = (Type) recur(that.getAnnType());
        return forAsExprOnly(that, info_result, expr_result, annType_result);
    }


    public Node forAsIfExpr(AsIfExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Expr expr_result = (Expr) recur(that.getExpr());
        Type annType_result = (Type) recur(that.getAnnType());
        return forAsIfExprOnly(that, info_result, expr_result, annType_result);
    }


    public Node forAssignment(Assignment that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        List<Lhs> lhs_result = recurOnListOfLhs(that.getLhs());
        Option<FunctionalRef> assignOp_result = recurOnOptionOfFunctionalRef(that.getAssignOp());
        Expr rhs_result = (Expr) recur(that.getRhs());
        List<CompoundAssignmentInfo> assignmentInfos_result = recurOnListOfCompoundAssignmentInfo(that.getAssignmentInfos());
        return forAssignmentOnly(that, info_result, lhs_result, assignOp_result, rhs_result, assignmentInfos_result);
    }


    public Node forBlock(Block that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Option<Expr> loc_result = recurOnOptionOfExpr(that.getLoc());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        return forBlockOnly(that, info_result, loc_result, exprs_result);
    }


    public Node forDo(Do that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        List<Block> fronts_result = recurOnListOfBlock(that.getFronts());
        return forDoOnly(that, info_result, fronts_result);
    }


    public Node forCaseExpr(CaseExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Option<Expr> param_result = recurOnOptionOfExpr(that.getParam());
        Option<FunctionalRef> compare_result = recurOnOptionOfFunctionalRef(that.getCompare());
        FunctionalRef equalsOp_result = (FunctionalRef) recur(that.getEqualsOp());
        FunctionalRef inOp_result = (FunctionalRef) recur(that.getInOp());
        List<CaseClause> clauses_result = recurOnListOfCaseClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forCaseExprOnly(that, info_result, param_result, compare_result, equalsOp_result, inOp_result, clauses_result, elseClause_result);
    }


    public Node forIf(If that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        List<IfClause> clauses_result = recurOnListOfIfClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forIfOnly(that, info_result, clauses_result, elseClause_result);
    }


    public Node forLabel(Label that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        Block body_result = (Block) recur(that.getBody());
        return forLabelOnly(that, info_result, name_result, body_result);
    }


    public Node forObjectExpr(ObjectExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        TraitTypeHeader header_result = (TraitTypeHeader) recur(that.getHeader());
        Option<SelfType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        return forObjectExprOnly(that, info_result, header_result, selfType_result);
    }


    public Node for_RewriteObjectExpr(_RewriteObjectExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        TraitTypeHeader header_result = (TraitTypeHeader) recur(that.getHeader());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_RewriteObjectExprOnly(that, info_result, header_result, staticArgs_result);
    }


    public Node forTry(Try that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Block body_result = (Block) recur(that.getBody());
        Option<Catch> catchClause_result = recurOnOptionOfCatch(that.getCatchClause());
        List<BaseType> forbidClause_result = recurOnListOfBaseType(that.getForbidClause());
        Option<Block> finallyClause_result = recurOnOptionOfBlock(that.getFinallyClause());
        return forTryOnly(that, info_result, body_result, catchClause_result, forbidClause_result, finallyClause_result);
    }


    public Node forTupleExpr(TupleExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        Option<Expr> varargs_result = recurOnOptionOfExpr(that.getVarargs());
        List<KeywordExpr> keywords_result = recurOnListOfKeywordExpr(that.getKeywords());
        return forTupleExprOnly(that, info_result, exprs_result, varargs_result, keywords_result);
    }


    public Node forTypecase(Typecase that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Expr bindExpr_result = (Expr) recur(that.getBindExpr());
        List<TypecaseClause> clauses_result = recurOnListOfTypecaseClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forTypecaseOnly(that, info_result, bindExpr_result, clauses_result, elseClause_result);
    }


    public Node forWhile(While that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        GeneratorClause testExpr_result = (GeneratorClause) recur(that.getTestExpr());
        Do body_result = (Do) recur(that.getBody());
        return forWhileOnly(that, info_result, testExpr_result, body_result);
    }


    public Node forFor(For that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        Block body_result = (Block) recur(that.getBody());
        return forForOnly(that, info_result, gens_result, body_result);
    }


    public Node forAccumulator(Accumulator that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Op accOp_result = (Op) recur(that.getAccOp());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        Expr body_result = (Expr) recur(that.getBody());
        return forAccumulatorOnly(that, info_result, staticArgs_result, accOp_result, gens_result, body_result);
    }


    public Node forArrayComprehension(ArrayComprehension that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<ArrayComprehensionClause> clauses_result = recurOnListOfArrayComprehensionClause(that.getClauses());
        return forArrayComprehensionOnly(that, info_result, staticArgs_result, clauses_result);
    }


    public Node forAtomicExpr(AtomicExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Expr expr_result = (Expr) recur(that.getExpr());
        return forAtomicExprOnly(that, info_result, expr_result);
    }


    public Node forExit(Exit that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Option<Id> target_result = recurOnOptionOfId(that.getTarget());
        Option<Expr> returnExpr_result = recurOnOptionOfExpr(that.getReturnExpr());
        return forExitOnly(that, info_result, target_result, returnExpr_result);
    }


    public Node forSpawn(Spawn that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Expr body_result = (Expr) recur(that.getBody());
        return forSpawnOnly(that, info_result, body_result);
    }


    public Node forThrow(Throw that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Expr expr_result = (Expr) recur(that.getExpr());
        return forThrowOnly(that, info_result, expr_result);
    }


    public Node forTryAtomicExpr(TryAtomicExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Expr expr_result = (Expr) recur(that.getExpr());
        return forTryAtomicExprOnly(that, info_result, expr_result);
    }


    public Node forFnExpr(FnExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        FnHeader header_result = (FnHeader) recur(that.getHeader());
        Expr body_result = (Expr) recur(that.getBody());
        return forFnExprOnly(that, info_result, header_result, body_result);
    }


    public Node forLetFn(LetFn that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Block body_result = (Block) recur(that.getBody());
        List<FnDecl> fns_result = recurOnListOfFnDecl(that.getFns());
        return forLetFnOnly(that, info_result, body_result, fns_result);
    }


    public Node forLocalVarDecl(LocalVarDecl that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Block body_result = (Block) recur(that.getBody());
        List<LValue> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<Expr> rhs_result = recurOnOptionOfExpr(that.getRhs());
        return forLocalVarDeclOnly(that, info_result, body_result, lhs_result, rhs_result);
    }


    public Node forSubscriptExpr(SubscriptExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Expr obj_result = (Expr) recur(that.getObj());
        List<Expr> subs_result = recurOnListOfExpr(that.getSubs());
        Option<Op> op_result = recurOnOptionOfOp(that.getOp());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return forSubscriptExprOnly(that, info_result, obj_result, subs_result, op_result, staticArgs_result);
    }


    public Node forFloatLiteralExpr(FloatLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return forFloatLiteralExprOnly(that, info_result);
    }


    public Node forIntLiteralExpr(IntLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return forIntLiteralExprOnly(that, info_result);
    }


    public Node forCharLiteralExpr(CharLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return forCharLiteralExprOnly(that, info_result);
    }


    public Node forStringLiteralExpr(StringLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return forStringLiteralExprOnly(that, info_result);
    }


    public Node forVoidLiteralExpr(VoidLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return forVoidLiteralExprOnly(that, info_result);
    }


    public Node forBooleanLiteralExpr(BooleanLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return forBooleanLiteralExprOnly(that, info_result);
    }


    public Node forVarRef(VarRef that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id varId_result = (Id) recur(that.getVarId());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return forVarRefOnly(that, info_result, varId_result, staticArgs_result);
    }


    public Node forFieldRef(FieldRef that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Expr obj_result = (Expr) recur(that.getObj());
        Id field_result = (Id) recur(that.getField());
        return forFieldRefOnly(that, info_result, obj_result, field_result);
    }


    public Node forFnRef(FnRef that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        IdOrOp originalName_result = (IdOrOp) recur(that.getOriginalName());
        List<IdOrOp> names_result = recurOnListOfIdOrOp(that.getNames());
        List<Overloading> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<Overloading> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return forFnRefOnly(that, info_result, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }


    public Node forOpRef(OpRef that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        IdOrOp originalName_result = (IdOrOp) recur(that.getOriginalName());
        List<IdOrOp> names_result = recurOnListOfIdOrOp(that.getNames());
        List<Overloading> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<Overloading> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return forOpRefOnly(that, info_result, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }


    public Node for_RewriteFnRef(_RewriteFnRef that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Expr fnExpr_result = (Expr) recur(that.getFnExpr());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_RewriteFnRefOnly(that, info_result, fnExpr_result, staticArgs_result);
    }


    public Node for_RewriteObjectExprRef(_RewriteObjectExprRef that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_RewriteObjectExprRefOnly(that, info_result, staticArgs_result);
    }


    public Node forJuxt(Juxt that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        FunctionalRef multiJuxt_result = (FunctionalRef) recur(that.getMultiJuxt());
        FunctionalRef infixJuxt_result = (FunctionalRef) recur(that.getInfixJuxt());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        return forJuxtOnly(that, info_result, multiJuxt_result, infixJuxt_result, exprs_result);
    }


    public Node for_RewriteFnApp(_RewriteFnApp that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Expr function_result = (Expr) recur(that.getFunction());
        Expr argument_result = (Expr) recur(that.getArgument());
        return for_RewriteFnAppOnly(that, info_result, function_result, argument_result);
    }


    public Node forOpExpr(OpExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        FunctionalRef op_result = (FunctionalRef) recur(that.getOp());
        List<Expr> args_result = recurOnListOfExpr(that.getArgs());
        return forOpExprOnly(that, info_result, op_result, args_result);
    }


    public Node forAmbiguousMultifixOpExpr(AmbiguousMultifixOpExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        FunctionalRef infix_op_result = (FunctionalRef) recur(that.getInfix_op());
        FunctionalRef multifix_op_result = (FunctionalRef) recur(that.getMultifix_op());
        List<Expr> args_result = recurOnListOfExpr(that.getArgs());
        return forAmbiguousMultifixOpExprOnly(that, info_result, infix_op_result, multifix_op_result, args_result);
    }


    public Node forChainExpr(ChainExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Expr first_result = (Expr) recur(that.getFirst());
        List<Link> links_result = recurOnListOfLink(that.getLinks());
        return forChainExprOnly(that, info_result, first_result, links_result);
    }


    public Node forTraitCoercionInvocation(TraitCoercionInvocation that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Expr arg_result = (Expr) recur(that.getArg());
        TraitType toType_result = (TraitType) recur(that.getToType());
        FnRef coercionFn_result = (FnRef) recur(that.getCoercionFn());
        return forTraitCoercionInvocationOnly(that, info_result, arg_result, toType_result, coercionFn_result);
    }


    public Node forTupleCoercionInvocation(TupleCoercionInvocation that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Expr arg_result = (Expr) recur(that.getArg());
        TupleType toType_result = (TupleType) recur(that.getToType());
        List<Option<CoercionInvocation>> subCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getSubCoercions());
        Option<Option<CoercionInvocation>> varargCoercion_result = recurOnOptionOfOptionOfCoercionInvocation(that.getVarargCoercion());
        return forTupleCoercionInvocationOnly(that, info_result, arg_result, toType_result, subCoercions_result, varargCoercion_result);
    }


    public Node forArrowCoercionInvocation(ArrowCoercionInvocation that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Expr arg_result = (Expr) recur(that.getArg());
        ArrowType toType_result = (ArrowType) recur(that.getToType());
        Option<CoercionInvocation> domainCoercion_result = recurOnOptionOfCoercionInvocation(that.getDomainCoercion());
        Option<CoercionInvocation> rangeCoercion_result = recurOnOptionOfCoercionInvocation(that.getRangeCoercion());
        return forArrowCoercionInvocationOnly(that, info_result, arg_result, toType_result, domainCoercion_result, rangeCoercion_result);
    }


    public Node forUnionCoercionInvocation(UnionCoercionInvocation that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Type toType_result = (Type) recur(that.getToType());
        Expr arg_result = (Expr) recur(that.getArg());
        List<Type> fromTypes_result = recurOnListOfType(that.getFromTypes());
        List<Option<CoercionInvocation>> fromCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getFromCoercions());
        return forUnionCoercionInvocationOnly(that, info_result, toType_result, arg_result, fromTypes_result, fromCoercions_result);
    }


    public Node forMethodInvocation(MethodInvocation that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Expr obj_result = (Expr) recur(that.getObj());
        IdOrOp method_result = (IdOrOp) recur(that.getMethod());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Expr arg_result = (Expr) recur(that.getArg());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return forMethodInvocationOnly(that, info_result, obj_result, method_result, staticArgs_result, arg_result, overloadingType_result, overloadingSchema_result);
    }


    public Node forMathPrimary(MathPrimary that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        FunctionalRef multiJuxt_result = (FunctionalRef) recur(that.getMultiJuxt());
        FunctionalRef infixJuxt_result = (FunctionalRef) recur(that.getInfixJuxt());
        Expr front_result = (Expr) recur(that.getFront());
        List<MathItem> rest_result = recurOnListOfMathItem(that.getRest());
        return forMathPrimaryOnly(that, info_result, multiJuxt_result, infixJuxt_result, front_result, rest_result);
    }


    public Node forArrayElement(ArrayElement that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Expr element_result = (Expr) recur(that.getElement());
        return forArrayElementOnly(that, info_result, staticArgs_result, element_result);
    }


    public Node forArrayElements(ArrayElements that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<ArrayExpr> elements_result = recurOnListOfArrayExpr(that.getElements());
        return forArrayElementsOnly(that, info_result, staticArgs_result, elements_result);
    }


    public Node forAnyType(AnyType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return forAnyTypeOnly(that, info_result);
    }


    public Node forBottomType(BottomType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return forBottomTypeOnly(that, info_result);
    }


    public Node forUnknownType(UnknownType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return forUnknownTypeOnly(that, info_result);
    }


    public Node forTraitSelfType(TraitSelfType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        BaseType named_result = (BaseType) recur(that.getNamed());
        List<NamedType> comprised_result = recurOnListOfNamedType(that.getComprised());
        return forTraitSelfTypeOnly(that, info_result, named_result, comprised_result);
    }


    public Node forObjectExprType(ObjectExprType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        List<BaseType> extended_result = recurOnListOfBaseType(that.getExtended());
        return forObjectExprTypeOnly(that, info_result, extended_result);
    }


    public Node for_InferenceVarType(_InferenceVarType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        return for_InferenceVarTypeOnly(that, info_result, name_result);
    }


    public Node forVarType(VarType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        return forVarTypeOnly(that, info_result, name_result);
    }


    public Node forTraitType(TraitType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<StaticArg> args_result = recurOnListOfStaticArg(that.getArgs());
        List<StaticParam> traitStaticParams_result = recurOnListOfStaticParam(that.getTraitStaticParams());
        return forTraitTypeOnly(that, info_result, name_result, args_result, traitStaticParams_result);
    }


    public Node forArrayType(ArrayType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Type elemType_result = (Type) recur(that.getElemType());
        Indices indices_result = (Indices) recur(that.getIndices());
        return forArrayTypeOnly(that, info_result, elemType_result, indices_result);
    }


    public Node forMatrixType(MatrixType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Type elemType_result = (Type) recur(that.getElemType());
        List<ExtentRange> dimensions_result = recurOnListOfExtentRange(that.getDimensions());
        return forMatrixTypeOnly(that, info_result, elemType_result, dimensions_result);
    }


    public Node forTaggedDimType(TaggedDimType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Type elemType_result = (Type) recur(that.getElemType());
        DimExpr dimExpr_result = (DimExpr) recur(that.getDimExpr());
        Option<Expr> unitExpr_result = recurOnOptionOfExpr(that.getUnitExpr());
        return forTaggedDimTypeOnly(that, info_result, elemType_result, dimExpr_result, unitExpr_result);
    }


    public Node forTaggedUnitType(TaggedUnitType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Type elemType_result = (Type) recur(that.getElemType());
        Expr unitExpr_result = (Expr) recur(that.getUnitExpr());
        return forTaggedUnitTypeOnly(that, info_result, elemType_result, unitExpr_result);
    }


    public Node forTupleType(TupleType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        List<Type> elements_result = recurOnListOfType(that.getElements());
        Option<Type> varargs_result = recurOnOptionOfType(that.getVarargs());
        List<KeywordType> keywords_result = recurOnListOfKeywordType(that.getKeywords());
        return forTupleTypeOnly(that, info_result, elements_result, varargs_result, keywords_result);
    }


    public Node forArrowType(ArrowType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Type domain_result = (Type) recur(that.getDomain());
        Type range_result = (Type) recur(that.getRange());
        Effect effect_result = (Effect) recur(that.getEffect());
        Option<MethodInfo> methodInfo_result = recurOnOptionOfMethodInfo(that.getMethodInfo());
        return forArrowTypeOnly(that, info_result, domain_result, range_result, effect_result, methodInfo_result);
    }


    public Node forIntersectionType(IntersectionType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        List<Type> elements_result = recurOnListOfType(that.getElements());
        return forIntersectionTypeOnly(that, info_result, elements_result);
    }


    public Node forUnionType(UnionType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        List<Type> elements_result = recurOnListOfType(that.getElements());
        return forUnionTypeOnly(that, info_result, elements_result);
    }


    public Node forFixedPointType(FixedPointType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        _InferenceVarType name_result = (_InferenceVarType) recur(that.getName());
        Type body_result = (Type) recur(that.getBody());
        return forFixedPointTypeOnly(that, info_result, name_result, body_result);
    }


    public Node forLabelType(LabelType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return forLabelTypeOnly(that, info_result);
    }


    public Node forDimBase(DimBase that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return forDimBaseOnly(that, info_result);
    }


    public Node forDimRef(DimRef that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        return forDimRefOnly(that, info_result, name_result);
    }


    public Node forDimExponent(DimExponent that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Type base_result = (Type) recur(that.getBase());
        IntExpr power_result = (IntExpr) recur(that.getPower());
        return forDimExponentOnly(that, info_result, base_result, power_result);
    }


    public Node forDimUnaryOp(DimUnaryOp that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        DimExpr dimVal_result = (DimExpr) recur(that.getDimVal());
        Op op_result = (Op) recur(that.getOp());
        return forDimUnaryOpOnly(that, info_result, dimVal_result, op_result);
    }


    public Node forDimBinaryOp(DimBinaryOp that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        DimExpr left_result = (DimExpr) recur(that.getLeft());
        DimExpr right_result = (DimExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        return forDimBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }


    public Node forPattern(Pattern that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Option<Type> name_result = recurOnOptionOfType(that.getName());
        PatternArgs patterns_result = (PatternArgs) recur(that.getPatterns());
        return forPatternOnly(that, info_result, name_result, patterns_result);
    }


    public Node forPatternArgs(PatternArgs that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        List<PatternBinding> patterns_result = recurOnListOfPatternBinding(that.getPatterns());
        return forPatternArgsOnly(that, info_result, patterns_result);
    }


    public Node forPlainPattern(PlainPattern that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Option<Id> field_result = recurOnOptionOfId(that.getField());
        Id name_result = (Id) recur(that.getName());
        Option<TypeOrPattern> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        return forPlainPatternOnly(that, info_result, field_result, name_result, idType_result);
    }


    public Node forTypePattern(TypePattern that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Option<Id> field_result = recurOnOptionOfId(that.getField());
        Type typ_result = (Type) recur(that.getTyp());
        return forTypePatternOnly(that, info_result, field_result, typ_result);
    }


    public Node forNestedPattern(NestedPattern that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Option<Id> field_result = recurOnOptionOfId(that.getField());
        Pattern pat_result = (Pattern) recur(that.getPat());
        return forNestedPatternOnly(that, info_result, field_result, pat_result);
    }


    public Node forTypeArg(TypeArg that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Type typeArg_result = (Type) recur(that.getTypeArg());
        return forTypeArgOnly(that, info_result, typeArg_result);
    }


    public Node forIntArg(IntArg that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        IntExpr intVal_result = (IntExpr) recur(that.getIntVal());
        return forIntArgOnly(that, info_result, intVal_result);
    }


    public Node forBoolArg(BoolArg that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        BoolExpr boolArg_result = (BoolExpr) recur(that.getBoolArg());
        return forBoolArgOnly(that, info_result, boolArg_result);
    }


    public Node forOpArg(OpArg that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Op id_result = (Op) recur(that.getId());
        return forOpArgOnly(that, info_result, id_result);
    }


    public Node forDimArg(DimArg that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        DimExpr dimArg_result = (DimExpr) recur(that.getDimArg());
        return forDimArgOnly(that, info_result, dimArg_result);
    }


    public Node forUnitArg(UnitArg that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        UnitExpr unitArg_result = (UnitExpr) recur(that.getUnitArg());
        return forUnitArgOnly(that, info_result, unitArg_result);
    }


    public Node forIntBase(IntBase that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        IntLiteralExpr intVal_result = (IntLiteralExpr) recur(that.getIntVal());
        return forIntBaseOnly(that, info_result, intVal_result);
    }


    public Node forIntRef(IntRef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        return forIntRefOnly(that, info_result, name_result);
    }


    public Node forIntBinaryOp(IntBinaryOp that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        IntExpr left_result = (IntExpr) recur(that.getLeft());
        IntExpr right_result = (IntExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        return forIntBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }


    public Node forBoolBase(BoolBase that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return forBoolBaseOnly(that, info_result);
    }


    public Node forBoolRef(BoolRef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        return forBoolRefOnly(that, info_result, name_result);
    }


    public Node forBoolUnaryOp(BoolUnaryOp that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        BoolExpr boolVal_result = (BoolExpr) recur(that.getBoolVal());
        Op op_result = (Op) recur(that.getOp());
        return forBoolUnaryOpOnly(that, info_result, boolVal_result, op_result);
    }


    public Node forBoolBinaryOp(BoolBinaryOp that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        BoolExpr left_result = (BoolExpr) recur(that.getLeft());
        BoolExpr right_result = (BoolExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        return forBoolBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }


    public Node forUnitRef(UnitRef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        return forUnitRefOnly(that, info_result, name_result);
    }


    public Node forUnitBinaryOp(UnitBinaryOp that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        UnitExpr left_result = (UnitExpr) recur(that.getLeft());
        UnitExpr right_result = (UnitExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        return forUnitBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }


    public Node forEffect(Effect that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Option<List<Type>> throwsClause_result = recurOnOptionOfListOfType(that.getThrowsClause());
        return forEffectOnly(that, info_result, throwsClause_result);
    }


    public Node forWhereClause(WhereClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        List<WhereBinding> bindings_result = recurOnListOfWhereBinding(that.getBindings());
        List<WhereConstraint> constraints_result = recurOnListOfWhereConstraint(that.getConstraints());
        return forWhereClauseOnly(that, info_result, bindings_result, constraints_result);
    }


    public Node forWhereBinding(WhereBinding that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<BaseType> supers_result = recurOnListOfBaseType(that.getSupers());
        StaticParamKind kind_result = (StaticParamKind) recur(that.getKind());
        return forWhereBindingOnly(that, info_result, name_result, supers_result, kind_result);
    }


    public Node forWhereExtends(WhereExtends that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<BaseType> supers_result = recurOnListOfBaseType(that.getSupers());
        return forWhereExtendsOnly(that, info_result, name_result, supers_result);
    }


    public Node forWhereTypeAlias(WhereTypeAlias that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        TypeAlias alias_result = (TypeAlias) recur(that.getAlias());
        return forWhereTypeAliasOnly(that, info_result, alias_result);
    }


    public Node forWhereCoerces(WhereCoerces that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Type left_result = (Type) recur(that.getLeft());
        Type right_result = (Type) recur(that.getRight());
        return forWhereCoercesOnly(that, info_result, left_result, right_result);
    }


    public Node forWhereEquals(WhereEquals that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id left_result = (Id) recur(that.getLeft());
        Id right_result = (Id) recur(that.getRight());
        return forWhereEqualsOnly(that, info_result, left_result, right_result);
    }


    public Node forUnitConstraint(UnitConstraint that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        return forUnitConstraintOnly(that, info_result, name_result);
    }


    public Node forIntConstraint(IntConstraint that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        IntExpr left_result = (IntExpr) recur(that.getLeft());
        IntExpr right_result = (IntExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        return forIntConstraintOnly(that, info_result, left_result, right_result, op_result);
    }


    public Node forBoolConstraintExpr(BoolConstraintExpr that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        BoolConstraint constraint_result = (BoolConstraint) recur(that.getConstraint());
        return forBoolConstraintExprOnly(that, info_result, constraint_result);
    }


    public Node forContract(Contract that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Option<List<Expr>> requiresClause_result = recurOnOptionOfListOfExpr(that.getRequiresClause());
        Option<List<EnsuresClause>> ensuresClause_result = recurOnOptionOfListOfEnsuresClause(that.getEnsuresClause());
        Option<List<Expr>> invariantsClause_result = recurOnOptionOfListOfExpr(that.getInvariantsClause());
        return forContractOnly(that, info_result, requiresClause_result, ensuresClause_result, invariantsClause_result);
    }


    public Node forEnsuresClause(EnsuresClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Expr post_result = (Expr) recur(that.getPost());
        Option<Expr> pre_result = recurOnOptionOfExpr(that.getPre());
        return forEnsuresClauseOnly(that, info_result, post_result, pre_result);
    }


    public Node forStaticParam(StaticParam that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        IdOrOp name_result = (IdOrOp) recur(that.getName());
        List<BaseType> extendsClause_result = recurOnListOfBaseType(that.getExtendsClause());
        List<BaseType> dominatesClause_result = recurOnListOfBaseType(that.getDominatesClause());
        Option<Type> dimParam_result = recurOnOptionOfType(that.getDimParam());
        StaticParamKind kind_result = (StaticParamKind) recur(that.getKind());
        return forStaticParamOnly(that, info_result, name_result, extendsClause_result, dominatesClause_result, dimParam_result, kind_result);
    }


    public Node forAPIName(APIName that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        List<Id> ids_result = recurOnListOfId(that.getIds());
        return forAPINameOnly(that, info_result, ids_result);
    }


    public Node forId(Id that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return forIdOnly(that, info_result, apiName_result);
    }


    public Node forNamedOp(NamedOp that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        Fixity fixity_result = (Fixity) recur(that.getFixity());
        return forNamedOpOnly(that, info_result, apiName_result, fixity_result);
    }


    public Node for_InferenceVarOp(_InferenceVarOp that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        Fixity fixity_result = (Fixity) recur(that.getFixity());
        return for_InferenceVarOpOnly(that, info_result, apiName_result, fixity_result);
    }


    public Node forAnonymousFnName(AnonymousFnName that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return forAnonymousFnNameOnly(that, info_result, apiName_result);
    }


    public Node forConstructorFnName(ConstructorFnName that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        ObjectConstructor constructor_result = (ObjectConstructor) recur(that.getConstructor());
        return forConstructorFnNameOnly(that, info_result, apiName_result, constructor_result);
    }


    public Node forArrayComprehensionClause(ArrayComprehensionClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        List<Expr> bind_result = recurOnListOfExpr(that.getBind());
        Expr init_result = (Expr) recur(that.getInit());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        return forArrayComprehensionClauseOnly(that, info_result, bind_result, init_result, gens_result);
    }


    public Node forKeywordExpr(KeywordExpr that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        Expr init_result = (Expr) recur(that.getInit());
        return forKeywordExprOnly(that, info_result, name_result, init_result);
    }


    public Node forCaseClause(CaseClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Expr matchClause_result = (Expr) recur(that.getMatchClause());
        Block body_result = (Block) recur(that.getBody());
        Option<FunctionalRef> op_result = recurOnOptionOfFunctionalRef(that.getOp());
        return forCaseClauseOnly(that, info_result, matchClause_result, body_result, op_result);
    }


    public Node forCatch(Catch that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<CatchClause> clauses_result = recurOnListOfCatchClause(that.getClauses());
        return forCatchOnly(that, info_result, name_result, clauses_result);
    }


    public Node forCatchClause(CatchClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        BaseType matchType_result = (BaseType) recur(that.getMatchType());
        Block body_result = (Block) recur(that.getBody());
        return forCatchClauseOnly(that, info_result, matchType_result, body_result);
    }


    public Node forIfClause(IfClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        GeneratorClause testClause_result = (GeneratorClause) recur(that.getTestClause());
        Block body_result = (Block) recur(that.getBody());
        return forIfClauseOnly(that, info_result, testClause_result, body_result);
    }


    public Node forTypecaseClause(TypecaseClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Option<Id> name_result = recurOnOptionOfId(that.getName());
        TypeOrPattern matchType_result = (TypeOrPattern) recur(that.getMatchType());
        Block body_result = (Block) recur(that.getBody());
        return forTypecaseClauseOnly(that, info_result, name_result, matchType_result, body_result);
    }


    public Node forExtentRange(ExtentRange that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Option<StaticArg> base_result = recurOnOptionOfStaticArg(that.getBase());
        Option<StaticArg> size_result = recurOnOptionOfStaticArg(that.getSize());
        Option<Op> op_result = recurOnOptionOfOp(that.getOp());
        return forExtentRangeOnly(that, info_result, base_result, size_result, op_result);
    }


    public Node forGeneratorClause(GeneratorClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        List<Id> bind_result = recurOnListOfId(that.getBind());
        Expr init_result = (Expr) recur(that.getInit());
        return forGeneratorClauseOnly(that, info_result, bind_result, init_result);
    }


    public Node forKeywordType(KeywordType that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        Type keywordType_result = (Type) recur(that.getKeywordType());
        return forKeywordTypeOnly(that, info_result, name_result, keywordType_result);
    }


    public Node forTraitTypeWhere(TraitTypeWhere that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        BaseType baseType_result = (BaseType) recur(that.getBaseType());
        Option<WhereClause> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        return forTraitTypeWhereOnly(that, info_result, baseType_result, whereClause_result);
    }


    public Node forIndices(Indices that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        List<ExtentRange> extents_result = recurOnListOfExtentRange(that.getExtents());
        return forIndicesOnly(that, info_result, extents_result);
    }


    public Node forParenthesisDelimitedMI(ParenthesisDelimitedMI that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Expr expr_result = (Expr) recur(that.getExpr());
        return forParenthesisDelimitedMIOnly(that, info_result, expr_result);
    }


    public Node forNonParenthesisDelimitedMI(NonParenthesisDelimitedMI that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Expr expr_result = (Expr) recur(that.getExpr());
        return forNonParenthesisDelimitedMIOnly(that, info_result, expr_result);
    }


    public Node forExponentiationMI(ExponentiationMI that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        FunctionalRef op_result = (FunctionalRef) recur(that.getOp());
        Option<Expr> expr_result = recurOnOptionOfExpr(that.getExpr());
        return forExponentiationMIOnly(that, info_result, op_result, expr_result);
    }


    public Node forSubscriptingMI(SubscriptingMI that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Op op_result = (Op) recur(that.getOp());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return forSubscriptingMIOnly(that, info_result, op_result, exprs_result, staticArgs_result);
    }


    public Node forOverloading(Overloading that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        IdOrOp unambiguousName_result = (IdOrOp) recur(that.getUnambiguousName());
        IdOrOp originalName_result = (IdOrOp) recur(that.getOriginalName());
        Option<ArrowType> type_result = recurOnOptionOfArrowType(that.getType());
        Option<ArrowType> schema_result = recurOnOptionOfArrowType(that.getSchema());
        return forOverloadingOnly(that, info_result, unambiguousName_result, originalName_result, type_result, schema_result);
    }


    public Node forNonterminalHeader(NonterminalHeader that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<NonterminalParameter> params_result = recurOnListOfNonterminalParameter(that.getParams());
        List<StaticParam> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        Option<Type> paramType_result = recurOnOptionOfType(that.getParamType());
        Option<WhereClause> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        return forNonterminalHeaderOnly(that, info_result, name_result, params_result, staticParams_result, paramType_result, whereClause_result);
    }


    public Node forNonterminalParameter(NonterminalParameter that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        BaseType paramType_result = (BaseType) recur(that.getParamType());
        return forNonterminalParameterOnly(that, info_result, name_result, paramType_result);
    }


    public Node forSyntaxDef(SyntaxDef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        List<SyntaxSymbol> syntaxSymbols_result = recurOnListOfSyntaxSymbol(that.getSyntaxSymbols());
        TransformerDecl transformer_result = (TransformerDecl) recur(that.getTransformer());
        return forSyntaxDefOnly(that, info_result, syntaxSymbols_result, transformer_result);
    }


    public Node forSuperSyntaxDef(SuperSyntaxDef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id nonterminal_result = (Id) recur(that.getNonterminal());
        Id grammarId_result = (Id) recur(that.getGrammarId());
        return forSuperSyntaxDefOnly(that, info_result, nonterminal_result, grammarId_result);
    }


    public Node forPreTransformerDef(PreTransformerDef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Transformer transformer_result = (Transformer) recur(that.getTransformer());
        return forPreTransformerDefOnly(that, info_result, transformer_result);
    }


    public Node forNamedTransformerDef(NamedTransformerDef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        List<NonterminalParameter> parameters_result = recurOnListOfNonterminalParameter(that.getParameters());
        Transformer transformer_result = (Transformer) recur(that.getTransformer());
        return forNamedTransformerDefOnly(that, info_result, parameters_result, transformer_result);
    }


    public Node forUnparsedTransformer(UnparsedTransformer that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id nonterminal_result = (Id) recur(that.getNonterminal());
        return forUnparsedTransformerOnly(that, info_result, nonterminal_result);
    }


    public Node forNodeTransformer(NodeTransformer that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        AbstractNode node_result = (AbstractNode) recur(that.getNode());
        return forNodeTransformerOnly(that, info_result, node_result);
    }


    public Node forCaseTransformer(CaseTransformer that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapName_result = (Id) recur(that.getGapName());
        List<CaseTransformerClause> clauses_result = recurOnListOfCaseTransformerClause(that.getClauses());
        return forCaseTransformerOnly(that, info_result, gapName_result, clauses_result);
    }


    public Node forCaseTransformerClause(CaseTransformerClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id constructor_result = (Id) recur(that.getConstructor());
        List<Id> parameters_result = recurOnListOfId(that.getParameters());
        Transformer body_result = (Transformer) recur(that.getBody());
        return forCaseTransformerClauseOnly(that, info_result, constructor_result, parameters_result, body_result);
    }


    public Node forPrefixedSymbol(PrefixedSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id id_result = (Id) recur(that.getId());
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        return forPrefixedSymbolOnly(that, info_result, id_result, symbol_result);
    }


    public Node forOptionalSymbol(OptionalSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        return forOptionalSymbolOnly(that, info_result, symbol_result);
    }


    public Node forRepeatSymbol(RepeatSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        return forRepeatSymbolOnly(that, info_result, symbol_result);
    }


    public Node forRepeatOneOrMoreSymbol(RepeatOneOrMoreSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        return forRepeatOneOrMoreSymbolOnly(that, info_result, symbol_result);
    }


    public Node forNoWhitespaceSymbol(NoWhitespaceSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        return forNoWhitespaceSymbolOnly(that, info_result, symbol_result);
    }


    public Node forGroupSymbol(GroupSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        List<SyntaxSymbol> symbols_result = recurOnListOfSyntaxSymbol(that.getSymbols());
        return forGroupSymbolOnly(that, info_result, symbols_result);
    }


    public Node forAnyCharacterSymbol(AnyCharacterSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return forAnyCharacterSymbolOnly(that, info_result);
    }


    public Node forWhitespaceSymbol(WhitespaceSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return forWhitespaceSymbolOnly(that, info_result);
    }


    public Node forTabSymbol(TabSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return forTabSymbolOnly(that, info_result);
    }


    public Node forFormfeedSymbol(FormfeedSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return forFormfeedSymbolOnly(that, info_result);
    }


    public Node forCarriageReturnSymbol(CarriageReturnSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return forCarriageReturnSymbolOnly(that, info_result);
    }


    public Node forBackspaceSymbol(BackspaceSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return forBackspaceSymbolOnly(that, info_result);
    }


    public Node forNewlineSymbol(NewlineSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return forNewlineSymbolOnly(that, info_result);
    }


    public Node forBreaklineSymbol(BreaklineSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return forBreaklineSymbolOnly(that, info_result);
    }


    public Node forItemSymbol(ItemSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return forItemSymbolOnly(that, info_result);
    }


    public Node forNonterminalSymbol(NonterminalSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id nonterminal_result = (Id) recur(that.getNonterminal());
        return forNonterminalSymbolOnly(that, info_result, nonterminal_result);
    }


    public Node forKeywordSymbol(KeywordSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return forKeywordSymbolOnly(that, info_result);
    }


    public Node forTokenSymbol(TokenSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return forTokenSymbolOnly(that, info_result);
    }


    public Node forNotPredicateSymbol(NotPredicateSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        return forNotPredicateSymbolOnly(that, info_result, symbol_result);
    }


    public Node forAndPredicateSymbol(AndPredicateSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        return forAndPredicateSymbolOnly(that, info_result, symbol_result);
    }


    public Node forCharacterClassSymbol(CharacterClassSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        List<CharacterSymbol> characters_result = recurOnListOfCharacterSymbol(that.getCharacters());
        return forCharacterClassSymbolOnly(that, info_result, characters_result);
    }


    public Node forCharSymbol(CharSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return forCharSymbolOnly(that, info_result);
    }


    public Node forCharacterInterval(CharacterInterval that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return forCharacterIntervalOnly(that, info_result);
    }


    public Node forLink(Link that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        FunctionalRef op_result = (FunctionalRef) recur(that.getOp());
        Expr expr_result = (Expr) recur(that.getExpr());
        return forLinkOnly(that, info_result, op_result, expr_result);
    }


    public Node forTraitTypeHeader(TraitTypeHeader that) {
        List<StaticParam> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        IdOrOpOrAnonymousName name_result = (IdOrOpOrAnonymousName) recur(that.getName());
        Option<WhereClause> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        Option<List<Type>> throwsClause_result = recurOnOptionOfListOfType(that.getThrowsClause());
        Option<Contract> contract_result = recurOnOptionOfContract(that.getContract());
        List<TraitTypeWhere> extendsClause_result = recurOnListOfTraitTypeWhere(that.getExtendsClause());
        Option<List<Param>> params_result = recurOnOptionOfListOfParam(that.getParams());
        List<Decl> decls_result = recurOnListOfDecl(that.getDecls());
        return forTraitTypeHeaderOnly(that, staticParams_result, name_result, whereClause_result, throwsClause_result, contract_result, extendsClause_result, params_result, decls_result);
    }


    public Node forFnHeader(FnHeader that) {
        List<StaticParam> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        IdOrOpOrAnonymousName name_result = (IdOrOpOrAnonymousName) recur(that.getName());
        Option<WhereClause> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        Option<List<Type>> throwsClause_result = recurOnOptionOfListOfType(that.getThrowsClause());
        Option<Contract> contract_result = recurOnOptionOfContract(that.getContract());
        List<Param> params_result = recurOnListOfParam(that.getParams());
        Option<Type> returnType_result = recurOnOptionOfType(that.getReturnType());
        return forFnHeaderOnly(that, staticParams_result, name_result, whereClause_result, throwsClause_result, contract_result, params_result, returnType_result);
    }


    public Node forSpanInfo(SpanInfo that) {
        return forSpanInfoOnly(that);
    }


    public Node forExprInfo(ExprInfo that) {
        Option<Type> exprType_result = recurOnOptionOfType(that.getExprType());
        return forExprInfoOnly(that, exprType_result);
    }


    public Node forTypeInfo(TypeInfo that) {
        List<StaticParam> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        Option<WhereClause> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        return forTypeInfoOnly(that, staticParams_result, whereClause_result);
    }


    public Node forMethodInfo(MethodInfo that) {
        Type selfType_result = (Type) recur(that.getSelfType());
        return forMethodInfoOnly(that, selfType_result);
    }


    public Node forCompoundAssignmentInfo(CompoundAssignmentInfo that) {
        FunctionalRef opForLhs_result = (FunctionalRef) recur(that.getOpForLhs());
        Option<CoercionInvocation> compoundCoercionOuter_result = recurOnOptionOfCoercionInvocation(that.getCompoundCoercionOuter());
        Option<CoercionInvocation> compoundCoercionInner_result = recurOnOptionOfCoercionInvocation(that.getCompoundCoercionInner());
        return forCompoundAssignmentInfoOnly(that, opForLhs_result, compoundCoercionOuter_result, compoundCoercionInner_result);
    }


    public Node forLevel(Level that) {
        return forLevelOnly(that);
    }


    public Node forInFixity(InFixity that) {
        return forInFixityOnly(that);
    }


    public Node forPreFixity(PreFixity that) {
        return forPreFixityOnly(that);
    }


    public Node forPostFixity(PostFixity that) {
        return forPostFixityOnly(that);
    }


    public Node forNoFixity(NoFixity that) {
        return forNoFixityOnly(that);
    }


    public Node forMultiFixity(MultiFixity that) {
        return forMultiFixityOnly(that);
    }


    public Node forEnclosingFixity(EnclosingFixity that) {
        return forEnclosingFixityOnly(that);
    }


    public Node forBigFixity(BigFixity that) {
        return forBigFixityOnly(that);
    }


    public Node forUnknownFixity(UnknownFixity that) {
        return forUnknownFixityOnly(that);
    }


    public Node forKindType(KindType that) {
        return forKindTypeOnly(that);
    }


    public Node forKindInt(KindInt that) {
        return forKindIntOnly(that);
    }


    public Node forKindNat(KindNat that) {
        return forKindNatOnly(that);
    }


    public Node forKindBool(KindBool that) {
        return forKindBoolOnly(that);
    }


    public Node forKindDim(KindDim that) {
        return forKindDimOnly(that);
    }


    public Node forKindUnit(KindUnit that) {
        return forKindUnitOnly(that);
    }


    public Node forKindOp(KindOp that) {
        return forKindOpOnly(that);
    }


    public Node for_SyntaxTransformationAbstractNode(_SyntaxTransformationAbstractNode that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationAbstractNodeOnly(that);
    }


    public Node for_SyntaxTransformationCompilationUnit(_SyntaxTransformationCompilationUnit that) {
        APIName name_result = (APIName) recur(that.getName());
        List<Import> imports_result = recurOnListOfImport(that.getImports());
        List<Decl> decls_result = recurOnListOfDecl(that.getDecls());
        List<APIName> comprises_result = recurOnListOfAPIName(that.getComprises());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationCompilationUnitOnly(that);
    }


    public Node for_SyntaxTransformationComponent(_SyntaxTransformationComponent that) {
        APIName name_result = (APIName) recur(that.getName());
        List<Import> imports_result = recurOnListOfImport(that.getImports());
        List<Decl> decls_result = recurOnListOfDecl(that.getDecls());
        List<APIName> comprises_result = recurOnListOfAPIName(that.getComprises());
        List<APIName> exports_result = recurOnListOfAPIName(that.getExports());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationComponentOnly(that);
    }


    public Node for_SyntaxTransformationApi(_SyntaxTransformationApi that) {
        APIName name_result = (APIName) recur(that.getName());
        List<Import> imports_result = recurOnListOfImport(that.getImports());
        List<Decl> decls_result = recurOnListOfDecl(that.getDecls());
        List<APIName> comprises_result = recurOnListOfAPIName(that.getComprises());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationApiOnly(that);
    }


    public Node for_SyntaxTransformationImport(_SyntaxTransformationImport that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationImportOnly(that);
    }


    public Node for_SyntaxTransformationImportedNames(_SyntaxTransformationImportedNames that) {
        APIName apiName_result = (APIName) recur(that.getApiName());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationImportedNamesOnly(that);
    }


    public Node for_SyntaxTransformationImportStar(_SyntaxTransformationImportStar that) {
        APIName apiName_result = (APIName) recur(that.getApiName());
        List<IdOrOpOrAnonymousName> exceptNames_result = recurOnListOfIdOrOpOrAnonymousName(that.getExceptNames());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationImportStarOnly(that);
    }


    public Node for_SyntaxTransformationImportNames(_SyntaxTransformationImportNames that) {
        APIName apiName_result = (APIName) recur(that.getApiName());
        List<AliasedSimpleName> aliasedNames_result = recurOnListOfAliasedSimpleName(that.getAliasedNames());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationImportNamesOnly(that);
    }


    public Node for_SyntaxTransformationImportApi(_SyntaxTransformationImportApi that) {
        List<AliasedAPIName> apis_result = recurOnListOfAliasedAPIName(that.getApis());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationImportApiOnly(that);
    }


    public Node for_SyntaxTransformationAliasedSimpleName(_SyntaxTransformationAliasedSimpleName that) {
        IdOrOpOrAnonymousName name_result = (IdOrOpOrAnonymousName) recur(that.getName());
        Option<IdOrOpOrAnonymousName> alias_result = recurOnOptionOfIdOrOpOrAnonymousName(that.getAlias());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationAliasedSimpleNameOnly(that);
    }


    public Node for_SyntaxTransformationAliasedAPIName(_SyntaxTransformationAliasedAPIName that) {
        APIName apiName_result = (APIName) recur(that.getApiName());
        Option<Id> alias_result = recurOnOptionOfId(that.getAlias());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationAliasedAPINameOnly(that);
    }


    public Node for_SyntaxTransformationDecl(_SyntaxTransformationDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationDeclOnly(that);
    }


    public Node for_SyntaxTransformationTraitObjectDecl(_SyntaxTransformationTraitObjectDecl that) {
        TraitTypeHeader header_result = (TraitTypeHeader) recur(that.getHeader());
        Option<SelfType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTraitObjectDeclOnly(that);
    }


    public Node for_SyntaxTransformationTraitDecl(_SyntaxTransformationTraitDecl that) {
        TraitTypeHeader header_result = (TraitTypeHeader) recur(that.getHeader());
        Option<SelfType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        List<BaseType> excludesClause_result = recurOnListOfBaseType(that.getExcludesClause());
        Option<List<NamedType>> comprisesClause_result = recurOnOptionOfListOfNamedType(that.getComprisesClause());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTraitDeclOnly(that);
    }


    public Node for_SyntaxTransformationObjectDecl(_SyntaxTransformationObjectDecl that) {
        TraitTypeHeader header_result = (TraitTypeHeader) recur(that.getHeader());
        Option<SelfType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationObjectDeclOnly(that);
    }


    public Node for_SyntaxTransformationVarDecl(_SyntaxTransformationVarDecl that) {
        List<LValue> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<Expr> init_result = recurOnOptionOfExpr(that.getInit());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationVarDeclOnly(that);
    }


    public Node for_SyntaxTransformationFnDecl(_SyntaxTransformationFnDecl that) {
        FnHeader header_result = (FnHeader) recur(that.getHeader());
        IdOrOp unambiguousName_result = (IdOrOp) recur(that.getUnambiguousName());
        Option<Expr> body_result = recurOnOptionOfExpr(that.getBody());
        Option<IdOrOp> implementsUnambiguousName_result = recurOnOptionOfIdOrOp(that.getImplementsUnambiguousName());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationFnDeclOnly(that);
    }


    public Node for_SyntaxTransformation_RewriteFnOverloadDecl(_SyntaxTransformation_RewriteFnOverloadDecl that) {
        IdOrOp name_result = (IdOrOp) recur(that.getName());
        List<IdOrOp> fns_result = recurOnListOfIdOrOp(that.getFns());
        Option<Type> type_result = recurOnOptionOfType(that.getType());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformation_RewriteFnOverloadDeclOnly(that);
    }


    public Node for_SyntaxTransformation_RewriteObjectExprDecl(_SyntaxTransformation_RewriteObjectExprDecl that) {
        List<_RewriteObjectExpr> objectExprs_result = recurOnListOf_RewriteObjectExpr(that.getObjectExprs());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformation_RewriteObjectExprDeclOnly(that);
    }


    public Node for_SyntaxTransformation_RewriteFunctionalMethodDecl(_SyntaxTransformation_RewriteFunctionalMethodDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformation_RewriteFunctionalMethodDeclOnly(that);
    }


    public Node for_SyntaxTransformationDimUnitDecl(_SyntaxTransformationDimUnitDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationDimUnitDeclOnly(that);
    }


    public Node for_SyntaxTransformationDimDecl(_SyntaxTransformationDimDecl that) {
        Id dimId_result = (Id) recur(that.getDimId());
        Option<Type> derived_result = recurOnOptionOfType(that.getDerived());
        Option<Id> defaultId_result = recurOnOptionOfId(that.getDefaultId());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationDimDeclOnly(that);
    }


    public Node for_SyntaxTransformationUnitDecl(_SyntaxTransformationUnitDecl that) {
        List<Id> units_result = recurOnListOfId(that.getUnits());
        Option<Type> dimType_result = recurOnOptionOfType(that.getDimType());
        Option<Expr> defExpr_result = recurOnOptionOfExpr(that.getDefExpr());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationUnitDeclOnly(that);
    }


    public Node for_SyntaxTransformationTestDecl(_SyntaxTransformationTestDecl that) {
        Id name_result = (Id) recur(that.getName());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        Expr expr_result = (Expr) recur(that.getExpr());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTestDeclOnly(that);
    }


    public Node for_SyntaxTransformationPropertyDecl(_SyntaxTransformationPropertyDecl that) {
        Option<Id> name_result = recurOnOptionOfId(that.getName());
        List<Param> params_result = recurOnListOfParam(that.getParams());
        Expr expr_result = (Expr) recur(that.getExpr());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationPropertyDeclOnly(that);
    }


    public Node for_SyntaxTransformationTypeAlias(_SyntaxTransformationTypeAlias that) {
        Id name_result = (Id) recur(that.getName());
        List<StaticParam> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        Type typeDef_result = (Type) recur(that.getTypeDef());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTypeAliasOnly(that);
    }


    public Node for_SyntaxTransformationGrammarDecl(_SyntaxTransformationGrammarDecl that) {
        Id name_result = (Id) recur(that.getName());
        List<Id> extendsClause_result = recurOnListOfId(that.getExtendsClause());
        List<GrammarMemberDecl> members_result = recurOnListOfGrammarMemberDecl(that.getMembers());
        List<TransformerDecl> transformers_result = recurOnListOfTransformerDecl(that.getTransformers());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationGrammarDeclOnly(that);
    }


    public Node for_SyntaxTransformationGrammarMemberDecl(_SyntaxTransformationGrammarMemberDecl that) {
        Id name_result = (Id) recur(that.getName());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationGrammarMemberDeclOnly(that);
    }


    public Node for_SyntaxTransformationNonterminalDecl(_SyntaxTransformationNonterminalDecl that) {
        Id name_result = (Id) recur(that.getName());
        List<SyntaxDecl> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNonterminalDeclOnly(that);
    }


    public Node for_SyntaxTransformationNonterminalDef(_SyntaxTransformationNonterminalDef that) {
        Id name_result = (Id) recur(that.getName());
        List<SyntaxDecl> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        NonterminalHeader header_result = (NonterminalHeader) recur(that.getHeader());
        Option<BaseType> astType_result = recurOnOptionOfBaseType(that.getAstType());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNonterminalDefOnly(that);
    }


    public Node for_SyntaxTransformationNonterminalExtensionDef(_SyntaxTransformationNonterminalExtensionDef that) {
        Id name_result = (Id) recur(that.getName());
        List<SyntaxDecl> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNonterminalExtensionDefOnly(that);
    }


    public Node for_SyntaxTransformationBinding(_SyntaxTransformationBinding that) {
        Id name_result = (Id) recur(that.getName());
        Option<TypeOrPattern> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationBindingOnly(that);
    }


    public Node for_SyntaxTransformationLValue(_SyntaxTransformationLValue that) {
        Id name_result = (Id) recur(that.getName());
        Option<TypeOrPattern> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationLValueOnly(that);
    }


    public Node for_SyntaxTransformationParam(_SyntaxTransformationParam that) {
        Id name_result = (Id) recur(that.getName());
        Option<TypeOrPattern> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        Option<Expr> defaultExpr_result = recurOnOptionOfExpr(that.getDefaultExpr());
        Option<Type> varargsType_result = recurOnOptionOfType(that.getVarargsType());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationParamOnly(that);
    }


    public Node for_SyntaxTransformationExpr(_SyntaxTransformationExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationExprOnly(that);
    }


    public Node for_SyntaxTransformationDummyExpr(_SyntaxTransformationDummyExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationDummyExprOnly(that);
    }


    public Node for_SyntaxTransformationTypeAnnotatedExpr(_SyntaxTransformationTypeAnnotatedExpr that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        Type annType_result = (Type) recur(that.getAnnType());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationTypeAnnotatedExprOnly(that);
    }


    public Node for_SyntaxTransformationAsExpr(_SyntaxTransformationAsExpr that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        Type annType_result = (Type) recur(that.getAnnType());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationAsExprOnly(that);
    }


    public Node for_SyntaxTransformationAsIfExpr(_SyntaxTransformationAsIfExpr that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        Type annType_result = (Type) recur(that.getAnnType());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationAsIfExprOnly(that);
    }


    public Node for_SyntaxTransformationAssignment(_SyntaxTransformationAssignment that) {
        List<Lhs> lhs_result = recurOnListOfLhs(that.getLhs());
        Option<FunctionalRef> assignOp_result = recurOnOptionOfFunctionalRef(that.getAssignOp());
        Expr rhs_result = (Expr) recur(that.getRhs());
        List<CompoundAssignmentInfo> assignmentInfos_result = recurOnListOfCompoundAssignmentInfo(that.getAssignmentInfos());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationAssignmentOnly(that);
    }


    public Node for_SyntaxTransformationBlock(_SyntaxTransformationBlock that) {
        Option<Expr> loc_result = recurOnOptionOfExpr(that.getLoc());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationBlockOnly(that);
    }


    public Node for_SyntaxTransformationDo(_SyntaxTransformationDo that) {
        List<Block> fronts_result = recurOnListOfBlock(that.getFronts());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationDoOnly(that);
    }


    public Node for_SyntaxTransformationCaseExpr(_SyntaxTransformationCaseExpr that) {
        Option<Expr> param_result = recurOnOptionOfExpr(that.getParam());
        Option<FunctionalRef> compare_result = recurOnOptionOfFunctionalRef(that.getCompare());
        FunctionalRef equalsOp_result = (FunctionalRef) recur(that.getEqualsOp());
        FunctionalRef inOp_result = (FunctionalRef) recur(that.getInOp());
        List<CaseClause> clauses_result = recurOnListOfCaseClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationCaseExprOnly(that);
    }


    public Node for_SyntaxTransformationIf(_SyntaxTransformationIf that) {
        List<IfClause> clauses_result = recurOnListOfIfClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationIfOnly(that);
    }


    public Node for_SyntaxTransformationLabel(_SyntaxTransformationLabel that) {
        Id name_result = (Id) recur(that.getName());
        Block body_result = (Block) recur(that.getBody());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationLabelOnly(that);
    }


    public Node for_SyntaxTransformationAbstractObjectExpr(_SyntaxTransformationAbstractObjectExpr that) {
        TraitTypeHeader header_result = (TraitTypeHeader) recur(that.getHeader());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationAbstractObjectExprOnly(that);
    }


    public Node for_SyntaxTransformationObjectExpr(_SyntaxTransformationObjectExpr that) {
        TraitTypeHeader header_result = (TraitTypeHeader) recur(that.getHeader());
        Option<SelfType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationObjectExprOnly(that);
    }


    public Node for_SyntaxTransformation_RewriteObjectExpr(_SyntaxTransformation_RewriteObjectExpr that) {
        TraitTypeHeader header_result = (TraitTypeHeader) recur(that.getHeader());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformation_RewriteObjectExprOnly(that);
    }


    public Node for_SyntaxTransformationTry(_SyntaxTransformationTry that) {
        Block body_result = (Block) recur(that.getBody());
        Option<Catch> catchClause_result = recurOnOptionOfCatch(that.getCatchClause());
        List<BaseType> forbidClause_result = recurOnListOfBaseType(that.getForbidClause());
        Option<Block> finallyClause_result = recurOnOptionOfBlock(that.getFinallyClause());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationTryOnly(that);
    }


    public Node for_SyntaxTransformationTupleExpr(_SyntaxTransformationTupleExpr that) {
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        Option<Expr> varargs_result = recurOnOptionOfExpr(that.getVarargs());
        List<KeywordExpr> keywords_result = recurOnListOfKeywordExpr(that.getKeywords());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationTupleExprOnly(that);
    }


    public Node for_SyntaxTransformationTypecase(_SyntaxTransformationTypecase that) {
        Expr bindExpr_result = (Expr) recur(that.getBindExpr());
        List<TypecaseClause> clauses_result = recurOnListOfTypecaseClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationTypecaseOnly(that);
    }


    public Node for_SyntaxTransformationWhile(_SyntaxTransformationWhile that) {
        GeneratorClause testExpr_result = (GeneratorClause) recur(that.getTestExpr());
        Do body_result = (Do) recur(that.getBody());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationWhileOnly(that);
    }


    public Node for_SyntaxTransformationFor(_SyntaxTransformationFor that) {
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        Block body_result = (Block) recur(that.getBody());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationForOnly(that);
    }


    public Node for_SyntaxTransformationBigOpApp(_SyntaxTransformationBigOpApp that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationBigOpAppOnly(that);
    }


    public Node for_SyntaxTransformationAccumulator(_SyntaxTransformationAccumulator that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Op accOp_result = (Op) recur(that.getAccOp());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        Expr body_result = (Expr) recur(that.getBody());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationAccumulatorOnly(that);
    }


    public Node for_SyntaxTransformationArrayComprehension(_SyntaxTransformationArrayComprehension that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<ArrayComprehensionClause> clauses_result = recurOnListOfArrayComprehensionClause(that.getClauses());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationArrayComprehensionOnly(that);
    }


    public Node for_SyntaxTransformationAtomicExpr(_SyntaxTransformationAtomicExpr that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationAtomicExprOnly(that);
    }


    public Node for_SyntaxTransformationExit(_SyntaxTransformationExit that) {
        Option<Id> target_result = recurOnOptionOfId(that.getTarget());
        Option<Expr> returnExpr_result = recurOnOptionOfExpr(that.getReturnExpr());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationExitOnly(that);
    }


    public Node for_SyntaxTransformationSpawn(_SyntaxTransformationSpawn that) {
        Expr body_result = (Expr) recur(that.getBody());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationSpawnOnly(that);
    }


    public Node for_SyntaxTransformationThrow(_SyntaxTransformationThrow that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationThrowOnly(that);
    }


    public Node for_SyntaxTransformationTryAtomicExpr(_SyntaxTransformationTryAtomicExpr that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationTryAtomicExprOnly(that);
    }


    public Node for_SyntaxTransformationFnExpr(_SyntaxTransformationFnExpr that) {
        FnHeader header_result = (FnHeader) recur(that.getHeader());
        Expr body_result = (Expr) recur(that.getBody());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationFnExprOnly(that);
    }


    public Node for_SyntaxTransformationLetExpr(_SyntaxTransformationLetExpr that) {
        Block body_result = (Block) recur(that.getBody());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationLetExprOnly(that);
    }


    public Node for_SyntaxTransformationLetFn(_SyntaxTransformationLetFn that) {
        Block body_result = (Block) recur(that.getBody());
        List<FnDecl> fns_result = recurOnListOfFnDecl(that.getFns());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationLetFnOnly(that);
    }


    public Node for_SyntaxTransformationLocalVarDecl(_SyntaxTransformationLocalVarDecl that) {
        Block body_result = (Block) recur(that.getBody());
        List<LValue> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<Expr> rhs_result = recurOnOptionOfExpr(that.getRhs());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationLocalVarDeclOnly(that);
    }


    public Node for_SyntaxTransformationSimpleExpr(_SyntaxTransformationSimpleExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationSimpleExprOnly(that);
    }


    public Node for_SyntaxTransformationSubscriptExpr(_SyntaxTransformationSubscriptExpr that) {
        Expr obj_result = (Expr) recur(that.getObj());
        List<Expr> subs_result = recurOnListOfExpr(that.getSubs());
        Option<Op> op_result = recurOnOptionOfOp(that.getOp());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationSubscriptExprOnly(that);
    }


    public Node for_SyntaxTransformationPrimary(_SyntaxTransformationPrimary that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationPrimaryOnly(that);
    }


    public Node for_SyntaxTransformationLiteralExpr(_SyntaxTransformationLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationLiteralExprOnly(that);
    }


    public Node for_SyntaxTransformationNumberLiteralExpr(_SyntaxTransformationNumberLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationNumberLiteralExprOnly(that);
    }


    public Node for_SyntaxTransformationFloatLiteralExpr(_SyntaxTransformationFloatLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationFloatLiteralExprOnly(that);
    }


    public Node for_SyntaxTransformationIntLiteralExpr(_SyntaxTransformationIntLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationIntLiteralExprOnly(that);
    }


    public Node for_SyntaxTransformationCharLiteralExpr(_SyntaxTransformationCharLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationCharLiteralExprOnly(that);
    }


    public Node for_SyntaxTransformationStringLiteralExpr(_SyntaxTransformationStringLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationStringLiteralExprOnly(that);
    }


    public Node for_SyntaxTransformationVoidLiteralExpr(_SyntaxTransformationVoidLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationVoidLiteralExprOnly(that);
    }


    public Node for_SyntaxTransformationBooleanLiteralExpr(_SyntaxTransformationBooleanLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationBooleanLiteralExprOnly(that);
    }


    public Node for_SyntaxTransformationVarRef(_SyntaxTransformationVarRef that) {
        Id varId_result = (Id) recur(that.getVarId());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationVarRefOnly(that);
    }


    public Node for_SyntaxTransformationFieldRef(_SyntaxTransformationFieldRef that) {
        Expr obj_result = (Expr) recur(that.getObj());
        Id field_result = (Id) recur(that.getField());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationFieldRefOnly(that);
    }


    public Node for_SyntaxTransformationFunctionalRef(_SyntaxTransformationFunctionalRef that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        IdOrOp originalName_result = (IdOrOp) recur(that.getOriginalName());
        List<IdOrOp> names_result = recurOnListOfIdOrOp(that.getNames());
        List<Overloading> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<Overloading> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationFunctionalRefOnly(that);
    }


    public Node for_SyntaxTransformationFnRef(_SyntaxTransformationFnRef that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        IdOrOp originalName_result = (IdOrOp) recur(that.getOriginalName());
        List<IdOrOp> names_result = recurOnListOfIdOrOp(that.getNames());
        List<Overloading> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<Overloading> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationFnRefOnly(that);
    }


    public Node for_SyntaxTransformationOpRef(_SyntaxTransformationOpRef that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        IdOrOp originalName_result = (IdOrOp) recur(that.getOriginalName());
        List<IdOrOp> names_result = recurOnListOfIdOrOp(that.getNames());
        List<Overloading> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<Overloading> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationOpRefOnly(that);
    }


    public Node for_SyntaxTransformation_RewriteFnRef(_SyntaxTransformation_RewriteFnRef that) {
        Expr fnExpr_result = (Expr) recur(that.getFnExpr());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformation_RewriteFnRefOnly(that);
    }


    public Node for_SyntaxTransformation_RewriteObjectExprRef(_SyntaxTransformation_RewriteObjectExprRef that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformation_RewriteObjectExprRefOnly(that);
    }


    public Node for_SyntaxTransformationJuxt(_SyntaxTransformationJuxt that) {
        FunctionalRef multiJuxt_result = (FunctionalRef) recur(that.getMultiJuxt());
        FunctionalRef infixJuxt_result = (FunctionalRef) recur(that.getInfixJuxt());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationJuxtOnly(that);
    }


    public Node for_SyntaxTransformation_RewriteFnApp(_SyntaxTransformation_RewriteFnApp that) {
        Expr function_result = (Expr) recur(that.getFunction());
        Expr argument_result = (Expr) recur(that.getArgument());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformation_RewriteFnAppOnly(that);
    }


    public Node for_SyntaxTransformationOpExpr(_SyntaxTransformationOpExpr that) {
        FunctionalRef op_result = (FunctionalRef) recur(that.getOp());
        List<Expr> args_result = recurOnListOfExpr(that.getArgs());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationOpExprOnly(that);
    }


    public Node for_SyntaxTransformationAmbiguousMultifixOpExpr(_SyntaxTransformationAmbiguousMultifixOpExpr that) {
        FunctionalRef infix_op_result = (FunctionalRef) recur(that.getInfix_op());
        FunctionalRef multifix_op_result = (FunctionalRef) recur(that.getMultifix_op());
        List<Expr> args_result = recurOnListOfExpr(that.getArgs());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationAmbiguousMultifixOpExprOnly(that);
    }


    public Node for_SyntaxTransformationChainExpr(_SyntaxTransformationChainExpr that) {
        Expr first_result = (Expr) recur(that.getFirst());
        List<Link> links_result = recurOnListOfLink(that.getLinks());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationChainExprOnly(that);
    }


    public Node for_SyntaxTransformationCoercionInvocation(_SyntaxTransformationCoercionInvocation that) {
        Type toType_result = (Type) recur(that.getToType());
        Expr arg_result = (Expr) recur(that.getArg());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationCoercionInvocationOnly(that);
    }


    public Node for_SyntaxTransformationTraitCoercionInvocation(_SyntaxTransformationTraitCoercionInvocation that) {
        Expr arg_result = (Expr) recur(that.getArg());
        TraitType toType_result = (TraitType) recur(that.getToType());
        FnRef coercionFn_result = (FnRef) recur(that.getCoercionFn());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationTraitCoercionInvocationOnly(that);
    }


    public Node for_SyntaxTransformationTupleCoercionInvocation(_SyntaxTransformationTupleCoercionInvocation that) {
        Expr arg_result = (Expr) recur(that.getArg());
        TupleType toType_result = (TupleType) recur(that.getToType());
        List<Option<CoercionInvocation>> subCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getSubCoercions());
        Option<Option<CoercionInvocation>> varargCoercion_result = recurOnOptionOfOptionOfCoercionInvocation(that.getVarargCoercion());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationTupleCoercionInvocationOnly(that);
    }


    public Node for_SyntaxTransformationArrowCoercionInvocation(_SyntaxTransformationArrowCoercionInvocation that) {
        Expr arg_result = (Expr) recur(that.getArg());
        ArrowType toType_result = (ArrowType) recur(that.getToType());
        Option<CoercionInvocation> domainCoercion_result = recurOnOptionOfCoercionInvocation(that.getDomainCoercion());
        Option<CoercionInvocation> rangeCoercion_result = recurOnOptionOfCoercionInvocation(that.getRangeCoercion());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationArrowCoercionInvocationOnly(that);
    }


    public Node for_SyntaxTransformationUnionCoercionInvocation(_SyntaxTransformationUnionCoercionInvocation that) {
        Type toType_result = (Type) recur(that.getToType());
        Expr arg_result = (Expr) recur(that.getArg());
        List<Type> fromTypes_result = recurOnListOfType(that.getFromTypes());
        List<Option<CoercionInvocation>> fromCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getFromCoercions());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationUnionCoercionInvocationOnly(that);
    }


    public Node for_SyntaxTransformationMethodInvocation(_SyntaxTransformationMethodInvocation that) {
        Expr obj_result = (Expr) recur(that.getObj());
        IdOrOp method_result = (IdOrOp) recur(that.getMethod());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Expr arg_result = (Expr) recur(that.getArg());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationMethodInvocationOnly(that);
    }


    public Node for_SyntaxTransformationMathPrimary(_SyntaxTransformationMathPrimary that) {
        FunctionalRef multiJuxt_result = (FunctionalRef) recur(that.getMultiJuxt());
        FunctionalRef infixJuxt_result = (FunctionalRef) recur(that.getInfixJuxt());
        Expr front_result = (Expr) recur(that.getFront());
        List<MathItem> rest_result = recurOnListOfMathItem(that.getRest());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationMathPrimaryOnly(that);
    }


    public Node for_SyntaxTransformationArrayExpr(_SyntaxTransformationArrayExpr that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationArrayExprOnly(that);
    }


    public Node for_SyntaxTransformationArrayElement(_SyntaxTransformationArrayElement that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Expr element_result = (Expr) recur(that.getElement());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationArrayElementOnly(that);
    }


    public Node for_SyntaxTransformationArrayElements(_SyntaxTransformationArrayElements that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<ArrayExpr> elements_result = recurOnListOfArrayExpr(that.getElements());
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        return for_SyntaxTransformationArrayElementsOnly(that);
    }


    public Node for_SyntaxTransformationType(_SyntaxTransformationType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTypeOnly(that);
    }


    public Node for_SyntaxTransformationBaseType(_SyntaxTransformationBaseType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationBaseTypeOnly(that);
    }


    public Node for_SyntaxTransformationAnyType(_SyntaxTransformationAnyType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationAnyTypeOnly(that);
    }


    public Node for_SyntaxTransformationBottomType(_SyntaxTransformationBottomType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationBottomTypeOnly(that);
    }


    public Node for_SyntaxTransformationUnknownType(_SyntaxTransformationUnknownType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationUnknownTypeOnly(that);
    }


    public Node for_SyntaxTransformationSelfType(_SyntaxTransformationSelfType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationSelfTypeOnly(that);
    }


    public Node for_SyntaxTransformationTraitSelfType(_SyntaxTransformationTraitSelfType that) {
        BaseType named_result = (BaseType) recur(that.getNamed());
        List<NamedType> comprised_result = recurOnListOfNamedType(that.getComprised());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTraitSelfTypeOnly(that);
    }


    public Node for_SyntaxTransformationObjectExprType(_SyntaxTransformationObjectExprType that) {
        List<BaseType> extended_result = recurOnListOfBaseType(that.getExtended());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationObjectExprTypeOnly(that);
    }


    public Node for_SyntaxTransformationNamedType(_SyntaxTransformationNamedType that) {
        Id name_result = (Id) recur(that.getName());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNamedTypeOnly(that);
    }


    public Node for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that) {
        Id name_result = (Id) recur(that.getName());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformation_InferenceVarTypeOnly(that);
    }


    public Node for_SyntaxTransformationVarType(_SyntaxTransformationVarType that) {
        Id name_result = (Id) recur(that.getName());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationVarTypeOnly(that);
    }


    public Node for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that) {
        Id name_result = (Id) recur(that.getName());
        List<StaticArg> args_result = recurOnListOfStaticArg(that.getArgs());
        List<StaticParam> traitStaticParams_result = recurOnListOfStaticParam(that.getTraitStaticParams());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTraitTypeOnly(that);
    }


    public Node for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that) {
        Type elemType_result = (Type) recur(that.getElemType());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationAbbreviatedTypeOnly(that);
    }


    public Node for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that) {
        Type elemType_result = (Type) recur(that.getElemType());
        Indices indices_result = (Indices) recur(that.getIndices());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationArrayTypeOnly(that);
    }


    public Node for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that) {
        Type elemType_result = (Type) recur(that.getElemType());
        List<ExtentRange> dimensions_result = recurOnListOfExtentRange(that.getDimensions());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationMatrixTypeOnly(that);
    }


    public Node for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that) {
        Type elemType_result = (Type) recur(that.getElemType());
        DimExpr dimExpr_result = (DimExpr) recur(that.getDimExpr());
        Option<Expr> unitExpr_result = recurOnOptionOfExpr(that.getUnitExpr());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTaggedDimTypeOnly(that);
    }


    public Node for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that) {
        Type elemType_result = (Type) recur(that.getElemType());
        Expr unitExpr_result = (Expr) recur(that.getUnitExpr());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTaggedUnitTypeOnly(that);
    }


    public Node for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that) {
        List<Type> elements_result = recurOnListOfType(that.getElements());
        Option<Type> varargs_result = recurOnOptionOfType(that.getVarargs());
        List<KeywordType> keywords_result = recurOnListOfKeywordType(that.getKeywords());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTupleTypeOnly(that);
    }


    public Node for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that) {
        Type domain_result = (Type) recur(that.getDomain());
        Type range_result = (Type) recur(that.getRange());
        Effect effect_result = (Effect) recur(that.getEffect());
        Option<MethodInfo> methodInfo_result = recurOnOptionOfMethodInfo(that.getMethodInfo());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationArrowTypeOnly(that);
    }


    public Node for_SyntaxTransformationBoundType(_SyntaxTransformationBoundType that) {
        List<Type> elements_result = recurOnListOfType(that.getElements());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationBoundTypeOnly(that);
    }


    public Node for_SyntaxTransformationIntersectionType(_SyntaxTransformationIntersectionType that) {
        List<Type> elements_result = recurOnListOfType(that.getElements());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationIntersectionTypeOnly(that);
    }


    public Node for_SyntaxTransformationUnionType(_SyntaxTransformationUnionType that) {
        List<Type> elements_result = recurOnListOfType(that.getElements());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationUnionTypeOnly(that);
    }


    public Node for_SyntaxTransformationFixedPointType(_SyntaxTransformationFixedPointType that) {
        _InferenceVarType name_result = (_InferenceVarType) recur(that.getName());
        Type body_result = (Type) recur(that.getBody());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationFixedPointTypeOnly(that);
    }


    public Node for_SyntaxTransformationLabelType(_SyntaxTransformationLabelType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationLabelTypeOnly(that);
    }


    public Node for_SyntaxTransformationDimExpr(_SyntaxTransformationDimExpr that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationDimExprOnly(that);
    }


    public Node for_SyntaxTransformationDimBase(_SyntaxTransformationDimBase that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationDimBaseOnly(that);
    }


    public Node for_SyntaxTransformationDimRef(_SyntaxTransformationDimRef that) {
        Id name_result = (Id) recur(that.getName());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationDimRefOnly(that);
    }


    public Node for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that) {
        Type base_result = (Type) recur(that.getBase());
        IntExpr power_result = (IntExpr) recur(that.getPower());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationDimExponentOnly(that);
    }


    public Node for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that) {
        DimExpr dimVal_result = (DimExpr) recur(that.getDimVal());
        Op op_result = (Op) recur(that.getOp());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationDimUnaryOpOnly(that);
    }


    public Node for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that) {
        DimExpr left_result = (DimExpr) recur(that.getLeft());
        DimExpr right_result = (DimExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        return for_SyntaxTransformationDimBinaryOpOnly(that);
    }


    public Node for_SyntaxTransformationPattern(_SyntaxTransformationPattern that) {
        Option<Type> name_result = recurOnOptionOfType(that.getName());
        PatternArgs patterns_result = (PatternArgs) recur(that.getPatterns());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationPatternOnly(that);
    }


    public Node for_SyntaxTransformationPatternArgs(_SyntaxTransformationPatternArgs that) {
        List<PatternBinding> patterns_result = recurOnListOfPatternBinding(that.getPatterns());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationPatternArgsOnly(that);
    }


    public Node for_SyntaxTransformationPatternBinding(_SyntaxTransformationPatternBinding that) {
        Option<Id> field_result = recurOnOptionOfId(that.getField());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationPatternBindingOnly(that);
    }


    public Node for_SyntaxTransformationPlainPattern(_SyntaxTransformationPlainPattern that) {
        Option<Id> field_result = recurOnOptionOfId(that.getField());
        Id name_result = (Id) recur(that.getName());
        Option<TypeOrPattern> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationPlainPatternOnly(that);
    }


    public Node for_SyntaxTransformationTypePattern(_SyntaxTransformationTypePattern that) {
        Option<Id> field_result = recurOnOptionOfId(that.getField());
        Type typ_result = (Type) recur(that.getTyp());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTypePatternOnly(that);
    }


    public Node for_SyntaxTransformationNestedPattern(_SyntaxTransformationNestedPattern that) {
        Option<Id> field_result = recurOnOptionOfId(that.getField());
        Pattern pat_result = (Pattern) recur(that.getPat());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNestedPatternOnly(that);
    }


    public Node for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationStaticArgOnly(that);
    }


    public Node for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that) {
        Type typeArg_result = (Type) recur(that.getTypeArg());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTypeArgOnly(that);
    }


    public Node for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that) {
        IntExpr intVal_result = (IntExpr) recur(that.getIntVal());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationIntArgOnly(that);
    }


    public Node for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that) {
        BoolExpr boolArg_result = (BoolExpr) recur(that.getBoolArg());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationBoolArgOnly(that);
    }


    public Node for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that) {
        Op id_result = (Op) recur(that.getId());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationOpArgOnly(that);
    }


    public Node for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that) {
        DimExpr dimArg_result = (DimExpr) recur(that.getDimArg());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationDimArgOnly(that);
    }


    public Node for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that) {
        UnitExpr unitArg_result = (UnitExpr) recur(that.getUnitArg());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationUnitArgOnly(that);
    }


    public Node for_SyntaxTransformationStaticExpr(_SyntaxTransformationStaticExpr that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationStaticExprOnly(that);
    }


    public Node for_SyntaxTransformationIntExpr(_SyntaxTransformationIntExpr that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationIntExprOnly(that);
    }


    public Node for_SyntaxTransformationIntBase(_SyntaxTransformationIntBase that) {
        IntLiteralExpr intVal_result = (IntLiteralExpr) recur(that.getIntVal());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationIntBaseOnly(that);
    }


    public Node for_SyntaxTransformationIntRef(_SyntaxTransformationIntRef that) {
        Id name_result = (Id) recur(that.getName());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationIntRefOnly(that);
    }


    public Node for_SyntaxTransformationIntBinaryOp(_SyntaxTransformationIntBinaryOp that) {
        IntExpr left_result = (IntExpr) recur(that.getLeft());
        IntExpr right_result = (IntExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationIntBinaryOpOnly(that);
    }


    public Node for_SyntaxTransformationBoolExpr(_SyntaxTransformationBoolExpr that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationBoolExprOnly(that);
    }


    public Node for_SyntaxTransformationBoolBase(_SyntaxTransformationBoolBase that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationBoolBaseOnly(that);
    }


    public Node for_SyntaxTransformationBoolRef(_SyntaxTransformationBoolRef that) {
        Id name_result = (Id) recur(that.getName());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationBoolRefOnly(that);
    }


    public Node for_SyntaxTransformationBoolConstraint(_SyntaxTransformationBoolConstraint that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationBoolConstraintOnly(that);
    }


    public Node for_SyntaxTransformationBoolUnaryOp(_SyntaxTransformationBoolUnaryOp that) {
        BoolExpr boolVal_result = (BoolExpr) recur(that.getBoolVal());
        Op op_result = (Op) recur(that.getOp());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationBoolUnaryOpOnly(that);
    }


    public Node for_SyntaxTransformationBoolBinaryOp(_SyntaxTransformationBoolBinaryOp that) {
        BoolExpr left_result = (BoolExpr) recur(that.getLeft());
        BoolExpr right_result = (BoolExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationBoolBinaryOpOnly(that);
    }


    public Node for_SyntaxTransformationUnitExpr(_SyntaxTransformationUnitExpr that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationUnitExprOnly(that);
    }


    public Node for_SyntaxTransformationUnitRef(_SyntaxTransformationUnitRef that) {
        Id name_result = (Id) recur(that.getName());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationUnitRefOnly(that);
    }


    public Node for_SyntaxTransformationUnitBinaryOp(_SyntaxTransformationUnitBinaryOp that) {
        UnitExpr left_result = (UnitExpr) recur(that.getLeft());
        UnitExpr right_result = (UnitExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationUnitBinaryOpOnly(that);
    }


    public Node for_SyntaxTransformationEffect(_SyntaxTransformationEffect that) {
        Option<List<Type>> throwsClause_result = recurOnOptionOfListOfType(that.getThrowsClause());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationEffectOnly(that);
    }


    public Node for_SyntaxTransformationWhereClause(_SyntaxTransformationWhereClause that) {
        List<WhereBinding> bindings_result = recurOnListOfWhereBinding(that.getBindings());
        List<WhereConstraint> constraints_result = recurOnListOfWhereConstraint(that.getConstraints());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationWhereClauseOnly(that);
    }


    public Node for_SyntaxTransformationWhereBinding(_SyntaxTransformationWhereBinding that) {
        Id name_result = (Id) recur(that.getName());
        List<BaseType> supers_result = recurOnListOfBaseType(that.getSupers());
        StaticParamKind kind_result = (StaticParamKind) recur(that.getKind());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationWhereBindingOnly(that);
    }


    public Node for_SyntaxTransformationWhereConstraint(_SyntaxTransformationWhereConstraint that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationWhereConstraintOnly(that);
    }


    public Node for_SyntaxTransformationWhereExtends(_SyntaxTransformationWhereExtends that) {
        Id name_result = (Id) recur(that.getName());
        List<BaseType> supers_result = recurOnListOfBaseType(that.getSupers());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationWhereExtendsOnly(that);
    }


    public Node for_SyntaxTransformationWhereTypeAlias(_SyntaxTransformationWhereTypeAlias that) {
        TypeAlias alias_result = (TypeAlias) recur(that.getAlias());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationWhereTypeAliasOnly(that);
    }


    public Node for_SyntaxTransformationWhereCoerces(_SyntaxTransformationWhereCoerces that) {
        Type left_result = (Type) recur(that.getLeft());
        Type right_result = (Type) recur(that.getRight());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationWhereCoercesOnly(that);
    }


    public Node for_SyntaxTransformationWhereEquals(_SyntaxTransformationWhereEquals that) {
        Id left_result = (Id) recur(that.getLeft());
        Id right_result = (Id) recur(that.getRight());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationWhereEqualsOnly(that);
    }


    public Node for_SyntaxTransformationUnitConstraint(_SyntaxTransformationUnitConstraint that) {
        Id name_result = (Id) recur(that.getName());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationUnitConstraintOnly(that);
    }


    public Node for_SyntaxTransformationIntConstraint(_SyntaxTransformationIntConstraint that) {
        IntExpr left_result = (IntExpr) recur(that.getLeft());
        IntExpr right_result = (IntExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationIntConstraintOnly(that);
    }


    public Node for_SyntaxTransformationBoolConstraintExpr(_SyntaxTransformationBoolConstraintExpr that) {
        BoolConstraint constraint_result = (BoolConstraint) recur(that.getConstraint());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationBoolConstraintExprOnly(that);
    }


    public Node for_SyntaxTransformationContract(_SyntaxTransformationContract that) {
        Option<List<Expr>> requiresClause_result = recurOnOptionOfListOfExpr(that.getRequiresClause());
        Option<List<EnsuresClause>> ensuresClause_result = recurOnOptionOfListOfEnsuresClause(that.getEnsuresClause());
        Option<List<Expr>> invariantsClause_result = recurOnOptionOfListOfExpr(that.getInvariantsClause());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationContractOnly(that);
    }


    public Node for_SyntaxTransformationEnsuresClause(_SyntaxTransformationEnsuresClause that) {
        Expr post_result = (Expr) recur(that.getPost());
        Option<Expr> pre_result = recurOnOptionOfExpr(that.getPre());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationEnsuresClauseOnly(that);
    }


    public Node for_SyntaxTransformationStaticParam(_SyntaxTransformationStaticParam that) {
        IdOrOp name_result = (IdOrOp) recur(that.getName());
        List<BaseType> extendsClause_result = recurOnListOfBaseType(that.getExtendsClause());
        List<BaseType> dominatesClause_result = recurOnListOfBaseType(that.getDominatesClause());
        Option<Type> dimParam_result = recurOnOptionOfType(that.getDimParam());
        StaticParamKind kind_result = (StaticParamKind) recur(that.getKind());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationStaticParamOnly(that);
    }


    public Node for_SyntaxTransformationName(_SyntaxTransformationName that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNameOnly(that);
    }


    public Node for_SyntaxTransformationAPIName(_SyntaxTransformationAPIName that) {
        List<Id> ids_result = recurOnListOfId(that.getIds());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationAPINameOnly(that);
    }


    public Node for_SyntaxTransformationIdOrOpOrAnonymousName(_SyntaxTransformationIdOrOpOrAnonymousName that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationIdOrOpOrAnonymousNameOnly(that);
    }


    public Node for_SyntaxTransformationIdOrOp(_SyntaxTransformationIdOrOp that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationIdOrOpOnly(that);
    }


    public Node for_SyntaxTransformationId(_SyntaxTransformationId that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationIdOnly(that);
    }


    public Node for_SyntaxTransformationOp(_SyntaxTransformationOp that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        Fixity fixity_result = (Fixity) recur(that.getFixity());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationOpOnly(that);
    }


    public Node for_SyntaxTransformationNamedOp(_SyntaxTransformationNamedOp that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        Fixity fixity_result = (Fixity) recur(that.getFixity());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNamedOpOnly(that);
    }


    public Node for_SyntaxTransformation_InferenceVarOp(_SyntaxTransformation_InferenceVarOp that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        Fixity fixity_result = (Fixity) recur(that.getFixity());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformation_InferenceVarOpOnly(that);
    }


    public Node for_SyntaxTransformationAnonymousName(_SyntaxTransformationAnonymousName that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationAnonymousNameOnly(that);
    }


    public Node for_SyntaxTransformationAnonymousFnName(_SyntaxTransformationAnonymousFnName that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationAnonymousFnNameOnly(that);
    }


    public Node for_SyntaxTransformationConstructorFnName(_SyntaxTransformationConstructorFnName that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        ObjectConstructor constructor_result = (ObjectConstructor) recur(that.getConstructor());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationConstructorFnNameOnly(that);
    }


    public Node for_SyntaxTransformationArrayComprehensionClause(_SyntaxTransformationArrayComprehensionClause that) {
        List<Expr> bind_result = recurOnListOfExpr(that.getBind());
        Expr init_result = (Expr) recur(that.getInit());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationArrayComprehensionClauseOnly(that);
    }


    public Node for_SyntaxTransformationKeywordExpr(_SyntaxTransformationKeywordExpr that) {
        Id name_result = (Id) recur(that.getName());
        Expr init_result = (Expr) recur(that.getInit());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationKeywordExprOnly(that);
    }


    public Node for_SyntaxTransformationCaseClause(_SyntaxTransformationCaseClause that) {
        Expr matchClause_result = (Expr) recur(that.getMatchClause());
        Block body_result = (Block) recur(that.getBody());
        Option<FunctionalRef> op_result = recurOnOptionOfFunctionalRef(that.getOp());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationCaseClauseOnly(that);
    }


    public Node for_SyntaxTransformationCatch(_SyntaxTransformationCatch that) {
        Id name_result = (Id) recur(that.getName());
        List<CatchClause> clauses_result = recurOnListOfCatchClause(that.getClauses());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationCatchOnly(that);
    }


    public Node for_SyntaxTransformationCatchClause(_SyntaxTransformationCatchClause that) {
        BaseType matchType_result = (BaseType) recur(that.getMatchType());
        Block body_result = (Block) recur(that.getBody());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationCatchClauseOnly(that);
    }


    public Node for_SyntaxTransformationIfClause(_SyntaxTransformationIfClause that) {
        GeneratorClause testClause_result = (GeneratorClause) recur(that.getTestClause());
        Block body_result = (Block) recur(that.getBody());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationIfClauseOnly(that);
    }


    public Node for_SyntaxTransformationTypecaseClause(_SyntaxTransformationTypecaseClause that) {
        Option<Id> name_result = recurOnOptionOfId(that.getName());
        TypeOrPattern matchType_result = (TypeOrPattern) recur(that.getMatchType());
        Block body_result = (Block) recur(that.getBody());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTypecaseClauseOnly(that);
    }


    public Node for_SyntaxTransformationExtentRange(_SyntaxTransformationExtentRange that) {
        Option<StaticArg> base_result = recurOnOptionOfStaticArg(that.getBase());
        Option<StaticArg> size_result = recurOnOptionOfStaticArg(that.getSize());
        Option<Op> op_result = recurOnOptionOfOp(that.getOp());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationExtentRangeOnly(that);
    }


    public Node for_SyntaxTransformationGeneratorClause(_SyntaxTransformationGeneratorClause that) {
        List<Id> bind_result = recurOnListOfId(that.getBind());
        Expr init_result = (Expr) recur(that.getInit());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationGeneratorClauseOnly(that);
    }


    public Node for_SyntaxTransformationKeywordType(_SyntaxTransformationKeywordType that) {
        Id name_result = (Id) recur(that.getName());
        Type keywordType_result = (Type) recur(that.getKeywordType());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationKeywordTypeOnly(that);
    }


    public Node for_SyntaxTransformationTraitTypeWhere(_SyntaxTransformationTraitTypeWhere that) {
        BaseType baseType_result = (BaseType) recur(that.getBaseType());
        Option<WhereClause> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTraitTypeWhereOnly(that);
    }


    public Node for_SyntaxTransformationIndices(_SyntaxTransformationIndices that) {
        List<ExtentRange> extents_result = recurOnListOfExtentRange(that.getExtents());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationIndicesOnly(that);
    }


    public Node for_SyntaxTransformationMathItem(_SyntaxTransformationMathItem that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationMathItemOnly(that);
    }


    public Node for_SyntaxTransformationExprMI(_SyntaxTransformationExprMI that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationExprMIOnly(that);
    }


    public Node for_SyntaxTransformationParenthesisDelimitedMI(_SyntaxTransformationParenthesisDelimitedMI that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationParenthesisDelimitedMIOnly(that);
    }


    public Node for_SyntaxTransformationNonParenthesisDelimitedMI(_SyntaxTransformationNonParenthesisDelimitedMI that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNonParenthesisDelimitedMIOnly(that);
    }


    public Node for_SyntaxTransformationNonExprMI(_SyntaxTransformationNonExprMI that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNonExprMIOnly(that);
    }


    public Node for_SyntaxTransformationExponentiationMI(_SyntaxTransformationExponentiationMI that) {
        FunctionalRef op_result = (FunctionalRef) recur(that.getOp());
        Option<Expr> expr_result = recurOnOptionOfExpr(that.getExpr());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationExponentiationMIOnly(that);
    }


    public Node for_SyntaxTransformationSubscriptingMI(_SyntaxTransformationSubscriptingMI that) {
        Op op_result = (Op) recur(that.getOp());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationSubscriptingMIOnly(that);
    }


    public Node for_SyntaxTransformationOverloading(_SyntaxTransformationOverloading that) {
        IdOrOp unambiguousName_result = (IdOrOp) recur(that.getUnambiguousName());
        IdOrOp originalName_result = (IdOrOp) recur(that.getOriginalName());
        Option<ArrowType> type_result = recurOnOptionOfArrowType(that.getType());
        Option<ArrowType> schema_result = recurOnOptionOfArrowType(that.getSchema());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationOverloadingOnly(that);
    }


    public Node for_SyntaxTransformationNonterminalHeader(_SyntaxTransformationNonterminalHeader that) {
        Id name_result = (Id) recur(that.getName());
        List<NonterminalParameter> params_result = recurOnListOfNonterminalParameter(that.getParams());
        List<StaticParam> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        Option<Type> paramType_result = recurOnOptionOfType(that.getParamType());
        Option<WhereClause> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNonterminalHeaderOnly(that);
    }


    public Node for_SyntaxTransformationNonterminalParameter(_SyntaxTransformationNonterminalParameter that) {
        Id name_result = (Id) recur(that.getName());
        BaseType paramType_result = (BaseType) recur(that.getParamType());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNonterminalParameterOnly(that);
    }


    public Node for_SyntaxTransformationSyntaxDecl(_SyntaxTransformationSyntaxDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationSyntaxDeclOnly(that);
    }


    public Node for_SyntaxTransformationSyntaxDef(_SyntaxTransformationSyntaxDef that) {
        List<SyntaxSymbol> syntaxSymbols_result = recurOnListOfSyntaxSymbol(that.getSyntaxSymbols());
        TransformerDecl transformer_result = (TransformerDecl) recur(that.getTransformer());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationSyntaxDefOnly(that);
    }


    public Node for_SyntaxTransformationSuperSyntaxDef(_SyntaxTransformationSuperSyntaxDef that) {
        Id nonterminal_result = (Id) recur(that.getNonterminal());
        Id grammarId_result = (Id) recur(that.getGrammarId());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationSuperSyntaxDefOnly(that);
    }


    public Node for_SyntaxTransformationTransformerDecl(_SyntaxTransformationTransformerDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTransformerDeclOnly(that);
    }


    public Node for_SyntaxTransformationPreTransformerDef(_SyntaxTransformationPreTransformerDef that) {
        Transformer transformer_result = (Transformer) recur(that.getTransformer());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationPreTransformerDefOnly(that);
    }


    public Node for_SyntaxTransformationNamedTransformerDef(_SyntaxTransformationNamedTransformerDef that) {
        List<NonterminalParameter> parameters_result = recurOnListOfNonterminalParameter(that.getParameters());
        Transformer transformer_result = (Transformer) recur(that.getTransformer());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNamedTransformerDefOnly(that);
    }


    public Node for_SyntaxTransformationTransformer(_SyntaxTransformationTransformer that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTransformerOnly(that);
    }


    public Node for_SyntaxTransformationUnparsedTransformer(_SyntaxTransformationUnparsedTransformer that) {
        Id nonterminal_result = (Id) recur(that.getNonterminal());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationUnparsedTransformerOnly(that);
    }


    public Node for_SyntaxTransformationNodeTransformer(_SyntaxTransformationNodeTransformer that) {
        AbstractNode node_result = (AbstractNode) recur(that.getNode());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNodeTransformerOnly(that);
    }


    public Node for_SyntaxTransformationCaseTransformer(_SyntaxTransformationCaseTransformer that) {
        Id gapName_result = (Id) recur(that.getGapName());
        List<CaseTransformerClause> clauses_result = recurOnListOfCaseTransformerClause(that.getClauses());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationCaseTransformerOnly(that);
    }


    public Node for_SyntaxTransformationCaseTransformerClause(_SyntaxTransformationCaseTransformerClause that) {
        Id constructor_result = (Id) recur(that.getConstructor());
        List<Id> parameters_result = recurOnListOfId(that.getParameters());
        Transformer body_result = (Transformer) recur(that.getBody());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationCaseTransformerClauseOnly(that);
    }


    public Node for_SyntaxTransformationSyntaxSymbol(_SyntaxTransformationSyntaxSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationSyntaxSymbolOnly(that);
    }


    public Node for_SyntaxTransformationPrefixedSymbol(_SyntaxTransformationPrefixedSymbol that) {
        Id id_result = (Id) recur(that.getId());
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationPrefixedSymbolOnly(that);
    }


    public Node for_SyntaxTransformationOptionalSymbol(_SyntaxTransformationOptionalSymbol that) {
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationOptionalSymbolOnly(that);
    }


    public Node for_SyntaxTransformationRepeatSymbol(_SyntaxTransformationRepeatSymbol that) {
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationRepeatSymbolOnly(that);
    }


    public Node for_SyntaxTransformationRepeatOneOrMoreSymbol(_SyntaxTransformationRepeatOneOrMoreSymbol that) {
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationRepeatOneOrMoreSymbolOnly(that);
    }


    public Node for_SyntaxTransformationNoWhitespaceSymbol(_SyntaxTransformationNoWhitespaceSymbol that) {
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNoWhitespaceSymbolOnly(that);
    }


    public Node for_SyntaxTransformationGroupSymbol(_SyntaxTransformationGroupSymbol that) {
        List<SyntaxSymbol> symbols_result = recurOnListOfSyntaxSymbol(that.getSymbols());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationGroupSymbolOnly(that);
    }


    public Node for_SyntaxTransformationSpecialSymbol(_SyntaxTransformationSpecialSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationSpecialSymbolOnly(that);
    }


    public Node for_SyntaxTransformationAnyCharacterSymbol(_SyntaxTransformationAnyCharacterSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationAnyCharacterSymbolOnly(that);
    }


    public Node for_SyntaxTransformationWhitespaceSymbol(_SyntaxTransformationWhitespaceSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationWhitespaceSymbolOnly(that);
    }


    public Node for_SyntaxTransformationTabSymbol(_SyntaxTransformationTabSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTabSymbolOnly(that);
    }


    public Node for_SyntaxTransformationFormfeedSymbol(_SyntaxTransformationFormfeedSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationFormfeedSymbolOnly(that);
    }


    public Node for_SyntaxTransformationCarriageReturnSymbol(_SyntaxTransformationCarriageReturnSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationCarriageReturnSymbolOnly(that);
    }


    public Node for_SyntaxTransformationBackspaceSymbol(_SyntaxTransformationBackspaceSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationBackspaceSymbolOnly(that);
    }


    public Node for_SyntaxTransformationNewlineSymbol(_SyntaxTransformationNewlineSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNewlineSymbolOnly(that);
    }


    public Node for_SyntaxTransformationBreaklineSymbol(_SyntaxTransformationBreaklineSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationBreaklineSymbolOnly(that);
    }


    public Node for_SyntaxTransformationItemSymbol(_SyntaxTransformationItemSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationItemSymbolOnly(that);
    }


    public Node for_SyntaxTransformationNonterminalSymbol(_SyntaxTransformationNonterminalSymbol that) {
        Id nonterminal_result = (Id) recur(that.getNonterminal());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNonterminalSymbolOnly(that);
    }


    public Node for_SyntaxTransformationKeywordSymbol(_SyntaxTransformationKeywordSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationKeywordSymbolOnly(that);
    }


    public Node for_SyntaxTransformationTokenSymbol(_SyntaxTransformationTokenSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationTokenSymbolOnly(that);
    }


    public Node for_SyntaxTransformationNotPredicateSymbol(_SyntaxTransformationNotPredicateSymbol that) {
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationNotPredicateSymbolOnly(that);
    }


    public Node for_SyntaxTransformationAndPredicateSymbol(_SyntaxTransformationAndPredicateSymbol that) {
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationAndPredicateSymbolOnly(that);
    }


    public Node for_SyntaxTransformationCharacterClassSymbol(_SyntaxTransformationCharacterClassSymbol that) {
        List<CharacterSymbol> characters_result = recurOnListOfCharacterSymbol(that.getCharacters());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationCharacterClassSymbolOnly(that);
    }


    public Node for_SyntaxTransformationCharacterSymbol(_SyntaxTransformationCharacterSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationCharacterSymbolOnly(that);
    }


    public Node for_SyntaxTransformationCharSymbol(_SyntaxTransformationCharSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationCharSymbolOnly(that);
    }


    public Node for_SyntaxTransformationCharacterInterval(_SyntaxTransformationCharacterInterval that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationCharacterIntervalOnly(that);
    }


    public Node for_SyntaxTransformationLink(_SyntaxTransformationLink that) {
        FunctionalRef op_result = (FunctionalRef) recur(that.getOp());
        Expr expr_result = (Expr) recur(that.getExpr());
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        return for_SyntaxTransformationLinkOnly(that);
    }


    public Node for_EllipsesAbstractNode(_EllipsesAbstractNode that) {
        return for_EllipsesAbstractNodeOnly(that);
    }


    public Node for_EllipsesCompilationUnit(_EllipsesCompilationUnit that) {
        return for_EllipsesCompilationUnitOnly(that);
    }


    public Node for_EllipsesComponent(_EllipsesComponent that) {
        return for_EllipsesComponentOnly(that);
    }


    public Node for_EllipsesApi(_EllipsesApi that) {
        return for_EllipsesApiOnly(that);
    }


    public Node for_EllipsesImport(_EllipsesImport that) {
        return for_EllipsesImportOnly(that);
    }


    public Node for_EllipsesImportedNames(_EllipsesImportedNames that) {
        return for_EllipsesImportedNamesOnly(that);
    }


    public Node for_EllipsesImportStar(_EllipsesImportStar that) {
        return for_EllipsesImportStarOnly(that);
    }


    public Node for_EllipsesImportNames(_EllipsesImportNames that) {
        return for_EllipsesImportNamesOnly(that);
    }


    public Node for_EllipsesImportApi(_EllipsesImportApi that) {
        return for_EllipsesImportApiOnly(that);
    }


    public Node for_EllipsesAliasedSimpleName(_EllipsesAliasedSimpleName that) {
        return for_EllipsesAliasedSimpleNameOnly(that);
    }


    public Node for_EllipsesAliasedAPIName(_EllipsesAliasedAPIName that) {
        return for_EllipsesAliasedAPINameOnly(that);
    }


    public Node for_EllipsesDecl(_EllipsesDecl that) {
        return for_EllipsesDeclOnly(that);
    }


    public Node for_EllipsesTraitObjectDecl(_EllipsesTraitObjectDecl that) {
        return for_EllipsesTraitObjectDeclOnly(that);
    }


    public Node for_EllipsesTraitDecl(_EllipsesTraitDecl that) {
        return for_EllipsesTraitDeclOnly(that);
    }


    public Node for_EllipsesObjectDecl(_EllipsesObjectDecl that) {
        return for_EllipsesObjectDeclOnly(that);
    }


    public Node for_EllipsesVarDecl(_EllipsesVarDecl that) {
        return for_EllipsesVarDeclOnly(that);
    }


    public Node for_EllipsesFnDecl(_EllipsesFnDecl that) {
        return for_EllipsesFnDeclOnly(that);
    }


    public Node for_Ellipses_RewriteFnOverloadDecl(_Ellipses_RewriteFnOverloadDecl that) {
        return for_Ellipses_RewriteFnOverloadDeclOnly(that);
    }


    public Node for_Ellipses_RewriteObjectExprDecl(_Ellipses_RewriteObjectExprDecl that) {
        return for_Ellipses_RewriteObjectExprDeclOnly(that);
    }


    public Node for_Ellipses_RewriteFunctionalMethodDecl(_Ellipses_RewriteFunctionalMethodDecl that) {
        return for_Ellipses_RewriteFunctionalMethodDeclOnly(that);
    }


    public Node for_EllipsesDimUnitDecl(_EllipsesDimUnitDecl that) {
        return for_EllipsesDimUnitDeclOnly(that);
    }


    public Node for_EllipsesDimDecl(_EllipsesDimDecl that) {
        return for_EllipsesDimDeclOnly(that);
    }


    public Node for_EllipsesUnitDecl(_EllipsesUnitDecl that) {
        return for_EllipsesUnitDeclOnly(that);
    }


    public Node for_EllipsesTestDecl(_EllipsesTestDecl that) {
        return for_EllipsesTestDeclOnly(that);
    }


    public Node for_EllipsesPropertyDecl(_EllipsesPropertyDecl that) {
        return for_EllipsesPropertyDeclOnly(that);
    }


    public Node for_EllipsesTypeAlias(_EllipsesTypeAlias that) {
        return for_EllipsesTypeAliasOnly(that);
    }


    public Node for_EllipsesGrammarDecl(_EllipsesGrammarDecl that) {
        return for_EllipsesGrammarDeclOnly(that);
    }


    public Node for_EllipsesGrammarMemberDecl(_EllipsesGrammarMemberDecl that) {
        return for_EllipsesGrammarMemberDeclOnly(that);
    }


    public Node for_EllipsesNonterminalDecl(_EllipsesNonterminalDecl that) {
        return for_EllipsesNonterminalDeclOnly(that);
    }


    public Node for_EllipsesNonterminalDef(_EllipsesNonterminalDef that) {
        return for_EllipsesNonterminalDefOnly(that);
    }


    public Node for_EllipsesNonterminalExtensionDef(_EllipsesNonterminalExtensionDef that) {
        return for_EllipsesNonterminalExtensionDefOnly(that);
    }


    public Node for_EllipsesBinding(_EllipsesBinding that) {
        return for_EllipsesBindingOnly(that);
    }


    public Node for_EllipsesLValue(_EllipsesLValue that) {
        return for_EllipsesLValueOnly(that);
    }


    public Node for_EllipsesParam(_EllipsesParam that) {
        return for_EllipsesParamOnly(that);
    }


    public Node for_EllipsesExpr(_EllipsesExpr that) {
        return for_EllipsesExprOnly(that);
    }


    public Node for_EllipsesDummyExpr(_EllipsesDummyExpr that) {
        return for_EllipsesDummyExprOnly(that);
    }


    public Node for_EllipsesTypeAnnotatedExpr(_EllipsesTypeAnnotatedExpr that) {
        return for_EllipsesTypeAnnotatedExprOnly(that);
    }


    public Node for_EllipsesAsExpr(_EllipsesAsExpr that) {
        return for_EllipsesAsExprOnly(that);
    }


    public Node for_EllipsesAsIfExpr(_EllipsesAsIfExpr that) {
        return for_EllipsesAsIfExprOnly(that);
    }


    public Node for_EllipsesAssignment(_EllipsesAssignment that) {
        return for_EllipsesAssignmentOnly(that);
    }


    public Node for_EllipsesBlock(_EllipsesBlock that) {
        return for_EllipsesBlockOnly(that);
    }


    public Node for_EllipsesDo(_EllipsesDo that) {
        return for_EllipsesDoOnly(that);
    }


    public Node for_EllipsesCaseExpr(_EllipsesCaseExpr that) {
        return for_EllipsesCaseExprOnly(that);
    }


    public Node for_EllipsesIf(_EllipsesIf that) {
        return for_EllipsesIfOnly(that);
    }


    public Node for_EllipsesLabel(_EllipsesLabel that) {
        return for_EllipsesLabelOnly(that);
    }


    public Node for_EllipsesAbstractObjectExpr(_EllipsesAbstractObjectExpr that) {
        return for_EllipsesAbstractObjectExprOnly(that);
    }


    public Node for_EllipsesObjectExpr(_EllipsesObjectExpr that) {
        return for_EllipsesObjectExprOnly(that);
    }


    public Node for_Ellipses_RewriteObjectExpr(_Ellipses_RewriteObjectExpr that) {
        return for_Ellipses_RewriteObjectExprOnly(that);
    }


    public Node for_EllipsesTry(_EllipsesTry that) {
        return for_EllipsesTryOnly(that);
    }


    public Node for_EllipsesTupleExpr(_EllipsesTupleExpr that) {
        return for_EllipsesTupleExprOnly(that);
    }


    public Node for_EllipsesTypecase(_EllipsesTypecase that) {
        return for_EllipsesTypecaseOnly(that);
    }


    public Node for_EllipsesWhile(_EllipsesWhile that) {
        return for_EllipsesWhileOnly(that);
    }


    public Node for_EllipsesFor(_EllipsesFor that) {
        return for_EllipsesForOnly(that);
    }


    public Node for_EllipsesBigOpApp(_EllipsesBigOpApp that) {
        return for_EllipsesBigOpAppOnly(that);
    }


    public Node for_EllipsesAccumulator(_EllipsesAccumulator that) {
        return for_EllipsesAccumulatorOnly(that);
    }


    public Node for_EllipsesArrayComprehension(_EllipsesArrayComprehension that) {
        return for_EllipsesArrayComprehensionOnly(that);
    }


    public Node for_EllipsesAtomicExpr(_EllipsesAtomicExpr that) {
        return for_EllipsesAtomicExprOnly(that);
    }


    public Node for_EllipsesExit(_EllipsesExit that) {
        return for_EllipsesExitOnly(that);
    }


    public Node for_EllipsesSpawn(_EllipsesSpawn that) {
        return for_EllipsesSpawnOnly(that);
    }


    public Node for_EllipsesThrow(_EllipsesThrow that) {
        return for_EllipsesThrowOnly(that);
    }


    public Node for_EllipsesTryAtomicExpr(_EllipsesTryAtomicExpr that) {
        return for_EllipsesTryAtomicExprOnly(that);
    }


    public Node for_EllipsesFnExpr(_EllipsesFnExpr that) {
        return for_EllipsesFnExprOnly(that);
    }


    public Node for_EllipsesLetExpr(_EllipsesLetExpr that) {
        return for_EllipsesLetExprOnly(that);
    }


    public Node for_EllipsesLetFn(_EllipsesLetFn that) {
        return for_EllipsesLetFnOnly(that);
    }


    public Node for_EllipsesLocalVarDecl(_EllipsesLocalVarDecl that) {
        return for_EllipsesLocalVarDeclOnly(that);
    }


    public Node for_EllipsesSimpleExpr(_EllipsesSimpleExpr that) {
        return for_EllipsesSimpleExprOnly(that);
    }


    public Node for_EllipsesSubscriptExpr(_EllipsesSubscriptExpr that) {
        return for_EllipsesSubscriptExprOnly(that);
    }


    public Node for_EllipsesPrimary(_EllipsesPrimary that) {
        return for_EllipsesPrimaryOnly(that);
    }


    public Node for_EllipsesLiteralExpr(_EllipsesLiteralExpr that) {
        return for_EllipsesLiteralExprOnly(that);
    }


    public Node for_EllipsesNumberLiteralExpr(_EllipsesNumberLiteralExpr that) {
        return for_EllipsesNumberLiteralExprOnly(that);
    }


    public Node for_EllipsesFloatLiteralExpr(_EllipsesFloatLiteralExpr that) {
        return for_EllipsesFloatLiteralExprOnly(that);
    }


    public Node for_EllipsesIntLiteralExpr(_EllipsesIntLiteralExpr that) {
        return for_EllipsesIntLiteralExprOnly(that);
    }


    public Node for_EllipsesCharLiteralExpr(_EllipsesCharLiteralExpr that) {
        return for_EllipsesCharLiteralExprOnly(that);
    }


    public Node for_EllipsesStringLiteralExpr(_EllipsesStringLiteralExpr that) {
        return for_EllipsesStringLiteralExprOnly(that);
    }


    public Node for_EllipsesVoidLiteralExpr(_EllipsesVoidLiteralExpr that) {
        return for_EllipsesVoidLiteralExprOnly(that);
    }


    public Node for_EllipsesBooleanLiteralExpr(_EllipsesBooleanLiteralExpr that) {
        return for_EllipsesBooleanLiteralExprOnly(that);
    }


    public Node for_EllipsesVarRef(_EllipsesVarRef that) {
        return for_EllipsesVarRefOnly(that);
    }


    public Node for_EllipsesFieldRef(_EllipsesFieldRef that) {
        return for_EllipsesFieldRefOnly(that);
    }


    public Node for_EllipsesFunctionalRef(_EllipsesFunctionalRef that) {
        return for_EllipsesFunctionalRefOnly(that);
    }


    public Node for_EllipsesFnRef(_EllipsesFnRef that) {
        return for_EllipsesFnRefOnly(that);
    }


    public Node for_EllipsesOpRef(_EllipsesOpRef that) {
        return for_EllipsesOpRefOnly(that);
    }


    public Node for_Ellipses_RewriteFnRef(_Ellipses_RewriteFnRef that) {
        return for_Ellipses_RewriteFnRefOnly(that);
    }


    public Node for_Ellipses_RewriteObjectExprRef(_Ellipses_RewriteObjectExprRef that) {
        return for_Ellipses_RewriteObjectExprRefOnly(that);
    }


    public Node for_EllipsesJuxt(_EllipsesJuxt that) {
        return for_EllipsesJuxtOnly(that);
    }


    public Node for_Ellipses_RewriteFnApp(_Ellipses_RewriteFnApp that) {
        return for_Ellipses_RewriteFnAppOnly(that);
    }


    public Node for_EllipsesOpExpr(_EllipsesOpExpr that) {
        return for_EllipsesOpExprOnly(that);
    }


    public Node for_EllipsesAmbiguousMultifixOpExpr(_EllipsesAmbiguousMultifixOpExpr that) {
        return for_EllipsesAmbiguousMultifixOpExprOnly(that);
    }


    public Node for_EllipsesChainExpr(_EllipsesChainExpr that) {
        return for_EllipsesChainExprOnly(that);
    }


    public Node for_EllipsesCoercionInvocation(_EllipsesCoercionInvocation that) {
        return for_EllipsesCoercionInvocationOnly(that);
    }


    public Node for_EllipsesTraitCoercionInvocation(_EllipsesTraitCoercionInvocation that) {
        return for_EllipsesTraitCoercionInvocationOnly(that);
    }


    public Node for_EllipsesTupleCoercionInvocation(_EllipsesTupleCoercionInvocation that) {
        return for_EllipsesTupleCoercionInvocationOnly(that);
    }


    public Node for_EllipsesArrowCoercionInvocation(_EllipsesArrowCoercionInvocation that) {
        return for_EllipsesArrowCoercionInvocationOnly(that);
    }


    public Node for_EllipsesUnionCoercionInvocation(_EllipsesUnionCoercionInvocation that) {
        return for_EllipsesUnionCoercionInvocationOnly(that);
    }


    public Node for_EllipsesMethodInvocation(_EllipsesMethodInvocation that) {
        return for_EllipsesMethodInvocationOnly(that);
    }


    public Node for_EllipsesMathPrimary(_EllipsesMathPrimary that) {
        return for_EllipsesMathPrimaryOnly(that);
    }


    public Node for_EllipsesArrayExpr(_EllipsesArrayExpr that) {
        return for_EllipsesArrayExprOnly(that);
    }


    public Node for_EllipsesArrayElement(_EllipsesArrayElement that) {
        return for_EllipsesArrayElementOnly(that);
    }


    public Node for_EllipsesArrayElements(_EllipsesArrayElements that) {
        return for_EllipsesArrayElementsOnly(that);
    }


    public Node for_EllipsesType(_EllipsesType that) {
        return for_EllipsesTypeOnly(that);
    }


    public Node for_EllipsesBaseType(_EllipsesBaseType that) {
        return for_EllipsesBaseTypeOnly(that);
    }


    public Node for_EllipsesAnyType(_EllipsesAnyType that) {
        return for_EllipsesAnyTypeOnly(that);
    }


    public Node for_EllipsesBottomType(_EllipsesBottomType that) {
        return for_EllipsesBottomTypeOnly(that);
    }


    public Node for_EllipsesUnknownType(_EllipsesUnknownType that) {
        return for_EllipsesUnknownTypeOnly(that);
    }


    public Node for_EllipsesSelfType(_EllipsesSelfType that) {
        return for_EllipsesSelfTypeOnly(that);
    }


    public Node for_EllipsesTraitSelfType(_EllipsesTraitSelfType that) {
        return for_EllipsesTraitSelfTypeOnly(that);
    }


    public Node for_EllipsesObjectExprType(_EllipsesObjectExprType that) {
        return for_EllipsesObjectExprTypeOnly(that);
    }


    public Node for_EllipsesNamedType(_EllipsesNamedType that) {
        return for_EllipsesNamedTypeOnly(that);
    }


    public Node for_Ellipses_InferenceVarType(_Ellipses_InferenceVarType that) {
        return for_Ellipses_InferenceVarTypeOnly(that);
    }


    public Node for_EllipsesVarType(_EllipsesVarType that) {
        return for_EllipsesVarTypeOnly(that);
    }


    public Node for_EllipsesTraitType(_EllipsesTraitType that) {
        return for_EllipsesTraitTypeOnly(that);
    }


    public Node for_EllipsesAbbreviatedType(_EllipsesAbbreviatedType that) {
        return for_EllipsesAbbreviatedTypeOnly(that);
    }


    public Node for_EllipsesArrayType(_EllipsesArrayType that) {
        return for_EllipsesArrayTypeOnly(that);
    }


    public Node for_EllipsesMatrixType(_EllipsesMatrixType that) {
        return for_EllipsesMatrixTypeOnly(that);
    }


    public Node for_EllipsesTaggedDimType(_EllipsesTaggedDimType that) {
        return for_EllipsesTaggedDimTypeOnly(that);
    }


    public Node for_EllipsesTaggedUnitType(_EllipsesTaggedUnitType that) {
        return for_EllipsesTaggedUnitTypeOnly(that);
    }


    public Node for_EllipsesTupleType(_EllipsesTupleType that) {
        return for_EllipsesTupleTypeOnly(that);
    }


    public Node for_EllipsesArrowType(_EllipsesArrowType that) {
        return for_EllipsesArrowTypeOnly(that);
    }


    public Node for_EllipsesBoundType(_EllipsesBoundType that) {
        return for_EllipsesBoundTypeOnly(that);
    }


    public Node for_EllipsesIntersectionType(_EllipsesIntersectionType that) {
        return for_EllipsesIntersectionTypeOnly(that);
    }


    public Node for_EllipsesUnionType(_EllipsesUnionType that) {
        return for_EllipsesUnionTypeOnly(that);
    }


    public Node for_EllipsesFixedPointType(_EllipsesFixedPointType that) {
        return for_EllipsesFixedPointTypeOnly(that);
    }


    public Node for_EllipsesLabelType(_EllipsesLabelType that) {
        return for_EllipsesLabelTypeOnly(that);
    }


    public Node for_EllipsesDimExpr(_EllipsesDimExpr that) {
        return for_EllipsesDimExprOnly(that);
    }


    public Node for_EllipsesDimBase(_EllipsesDimBase that) {
        return for_EllipsesDimBaseOnly(that);
    }


    public Node for_EllipsesDimRef(_EllipsesDimRef that) {
        return for_EllipsesDimRefOnly(that);
    }


    public Node for_EllipsesDimExponent(_EllipsesDimExponent that) {
        return for_EllipsesDimExponentOnly(that);
    }


    public Node for_EllipsesDimUnaryOp(_EllipsesDimUnaryOp that) {
        return for_EllipsesDimUnaryOpOnly(that);
    }


    public Node for_EllipsesDimBinaryOp(_EllipsesDimBinaryOp that) {
        return for_EllipsesDimBinaryOpOnly(that);
    }


    public Node for_EllipsesPattern(_EllipsesPattern that) {
        return for_EllipsesPatternOnly(that);
    }


    public Node for_EllipsesPatternArgs(_EllipsesPatternArgs that) {
        return for_EllipsesPatternArgsOnly(that);
    }


    public Node for_EllipsesPatternBinding(_EllipsesPatternBinding that) {
        return for_EllipsesPatternBindingOnly(that);
    }


    public Node for_EllipsesPlainPattern(_EllipsesPlainPattern that) {
        return for_EllipsesPlainPatternOnly(that);
    }


    public Node for_EllipsesTypePattern(_EllipsesTypePattern that) {
        return for_EllipsesTypePatternOnly(that);
    }


    public Node for_EllipsesNestedPattern(_EllipsesNestedPattern that) {
        return for_EllipsesNestedPatternOnly(that);
    }


    public Node for_EllipsesStaticArg(_EllipsesStaticArg that) {
        return for_EllipsesStaticArgOnly(that);
    }


    public Node for_EllipsesTypeArg(_EllipsesTypeArg that) {
        return for_EllipsesTypeArgOnly(that);
    }


    public Node for_EllipsesIntArg(_EllipsesIntArg that) {
        return for_EllipsesIntArgOnly(that);
    }


    public Node for_EllipsesBoolArg(_EllipsesBoolArg that) {
        return for_EllipsesBoolArgOnly(that);
    }


    public Node for_EllipsesOpArg(_EllipsesOpArg that) {
        return for_EllipsesOpArgOnly(that);
    }


    public Node for_EllipsesDimArg(_EllipsesDimArg that) {
        return for_EllipsesDimArgOnly(that);
    }


    public Node for_EllipsesUnitArg(_EllipsesUnitArg that) {
        return for_EllipsesUnitArgOnly(that);
    }


    public Node for_EllipsesStaticExpr(_EllipsesStaticExpr that) {
        return for_EllipsesStaticExprOnly(that);
    }


    public Node for_EllipsesIntExpr(_EllipsesIntExpr that) {
        return for_EllipsesIntExprOnly(that);
    }


    public Node for_EllipsesIntBase(_EllipsesIntBase that) {
        return for_EllipsesIntBaseOnly(that);
    }


    public Node for_EllipsesIntRef(_EllipsesIntRef that) {
        return for_EllipsesIntRefOnly(that);
    }


    public Node for_EllipsesIntBinaryOp(_EllipsesIntBinaryOp that) {
        return for_EllipsesIntBinaryOpOnly(that);
    }


    public Node for_EllipsesBoolExpr(_EllipsesBoolExpr that) {
        return for_EllipsesBoolExprOnly(that);
    }


    public Node for_EllipsesBoolBase(_EllipsesBoolBase that) {
        return for_EllipsesBoolBaseOnly(that);
    }


    public Node for_EllipsesBoolRef(_EllipsesBoolRef that) {
        return for_EllipsesBoolRefOnly(that);
    }


    public Node for_EllipsesBoolConstraint(_EllipsesBoolConstraint that) {
        return for_EllipsesBoolConstraintOnly(that);
    }


    public Node for_EllipsesBoolUnaryOp(_EllipsesBoolUnaryOp that) {
        return for_EllipsesBoolUnaryOpOnly(that);
    }


    public Node for_EllipsesBoolBinaryOp(_EllipsesBoolBinaryOp that) {
        return for_EllipsesBoolBinaryOpOnly(that);
    }


    public Node for_EllipsesUnitExpr(_EllipsesUnitExpr that) {
        return for_EllipsesUnitExprOnly(that);
    }


    public Node for_EllipsesUnitRef(_EllipsesUnitRef that) {
        return for_EllipsesUnitRefOnly(that);
    }


    public Node for_EllipsesUnitBinaryOp(_EllipsesUnitBinaryOp that) {
        return for_EllipsesUnitBinaryOpOnly(that);
    }


    public Node for_EllipsesEffect(_EllipsesEffect that) {
        return for_EllipsesEffectOnly(that);
    }


    public Node for_EllipsesWhereClause(_EllipsesWhereClause that) {
        return for_EllipsesWhereClauseOnly(that);
    }


    public Node for_EllipsesWhereBinding(_EllipsesWhereBinding that) {
        return for_EllipsesWhereBindingOnly(that);
    }


    public Node for_EllipsesWhereConstraint(_EllipsesWhereConstraint that) {
        return for_EllipsesWhereConstraintOnly(that);
    }


    public Node for_EllipsesWhereExtends(_EllipsesWhereExtends that) {
        return for_EllipsesWhereExtendsOnly(that);
    }


    public Node for_EllipsesWhereTypeAlias(_EllipsesWhereTypeAlias that) {
        return for_EllipsesWhereTypeAliasOnly(that);
    }


    public Node for_EllipsesWhereCoerces(_EllipsesWhereCoerces that) {
        return for_EllipsesWhereCoercesOnly(that);
    }


    public Node for_EllipsesWhereEquals(_EllipsesWhereEquals that) {
        return for_EllipsesWhereEqualsOnly(that);
    }


    public Node for_EllipsesUnitConstraint(_EllipsesUnitConstraint that) {
        return for_EllipsesUnitConstraintOnly(that);
    }


    public Node for_EllipsesIntConstraint(_EllipsesIntConstraint that) {
        return for_EllipsesIntConstraintOnly(that);
    }


    public Node for_EllipsesBoolConstraintExpr(_EllipsesBoolConstraintExpr that) {
        return for_EllipsesBoolConstraintExprOnly(that);
    }


    public Node for_EllipsesContract(_EllipsesContract that) {
        return for_EllipsesContractOnly(that);
    }


    public Node for_EllipsesEnsuresClause(_EllipsesEnsuresClause that) {
        return for_EllipsesEnsuresClauseOnly(that);
    }


    public Node for_EllipsesStaticParam(_EllipsesStaticParam that) {
        return for_EllipsesStaticParamOnly(that);
    }


    public Node for_EllipsesName(_EllipsesName that) {
        return for_EllipsesNameOnly(that);
    }


    public Node for_EllipsesAPIName(_EllipsesAPIName that) {
        return for_EllipsesAPINameOnly(that);
    }


    public Node for_EllipsesIdOrOpOrAnonymousName(_EllipsesIdOrOpOrAnonymousName that) {
        return for_EllipsesIdOrOpOrAnonymousNameOnly(that);
    }


    public Node for_EllipsesIdOrOp(_EllipsesIdOrOp that) {
        return for_EllipsesIdOrOpOnly(that);
    }


    public Node for_EllipsesId(_EllipsesId that) {
        return for_EllipsesIdOnly(that);
    }


    public Node for_EllipsesOp(_EllipsesOp that) {
        return for_EllipsesOpOnly(that);
    }


    public Node for_EllipsesNamedOp(_EllipsesNamedOp that) {
        return for_EllipsesNamedOpOnly(that);
    }


    public Node for_Ellipses_InferenceVarOp(_Ellipses_InferenceVarOp that) {
        return for_Ellipses_InferenceVarOpOnly(that);
    }


    public Node for_EllipsesAnonymousName(_EllipsesAnonymousName that) {
        return for_EllipsesAnonymousNameOnly(that);
    }


    public Node for_EllipsesAnonymousFnName(_EllipsesAnonymousFnName that) {
        return for_EllipsesAnonymousFnNameOnly(that);
    }


    public Node for_EllipsesConstructorFnName(_EllipsesConstructorFnName that) {
        return for_EllipsesConstructorFnNameOnly(that);
    }


    public Node for_EllipsesArrayComprehensionClause(_EllipsesArrayComprehensionClause that) {
        return for_EllipsesArrayComprehensionClauseOnly(that);
    }


    public Node for_EllipsesKeywordExpr(_EllipsesKeywordExpr that) {
        return for_EllipsesKeywordExprOnly(that);
    }


    public Node for_EllipsesCaseClause(_EllipsesCaseClause that) {
        return for_EllipsesCaseClauseOnly(that);
    }


    public Node for_EllipsesCatch(_EllipsesCatch that) {
        return for_EllipsesCatchOnly(that);
    }


    public Node for_EllipsesCatchClause(_EllipsesCatchClause that) {
        return for_EllipsesCatchClauseOnly(that);
    }


    public Node for_EllipsesIfClause(_EllipsesIfClause that) {
        return for_EllipsesIfClauseOnly(that);
    }


    public Node for_EllipsesTypecaseClause(_EllipsesTypecaseClause that) {
        return for_EllipsesTypecaseClauseOnly(that);
    }


    public Node for_EllipsesExtentRange(_EllipsesExtentRange that) {
        return for_EllipsesExtentRangeOnly(that);
    }


    public Node for_EllipsesGeneratorClause(_EllipsesGeneratorClause that) {
        return for_EllipsesGeneratorClauseOnly(that);
    }


    public Node for_EllipsesKeywordType(_EllipsesKeywordType that) {
        return for_EllipsesKeywordTypeOnly(that);
    }


    public Node for_EllipsesTraitTypeWhere(_EllipsesTraitTypeWhere that) {
        return for_EllipsesTraitTypeWhereOnly(that);
    }


    public Node for_EllipsesIndices(_EllipsesIndices that) {
        return for_EllipsesIndicesOnly(that);
    }


    public Node for_EllipsesMathItem(_EllipsesMathItem that) {
        return for_EllipsesMathItemOnly(that);
    }


    public Node for_EllipsesExprMI(_EllipsesExprMI that) {
        return for_EllipsesExprMIOnly(that);
    }


    public Node for_EllipsesParenthesisDelimitedMI(_EllipsesParenthesisDelimitedMI that) {
        return for_EllipsesParenthesisDelimitedMIOnly(that);
    }


    public Node for_EllipsesNonParenthesisDelimitedMI(_EllipsesNonParenthesisDelimitedMI that) {
        return for_EllipsesNonParenthesisDelimitedMIOnly(that);
    }


    public Node for_EllipsesNonExprMI(_EllipsesNonExprMI that) {
        return for_EllipsesNonExprMIOnly(that);
    }


    public Node for_EllipsesExponentiationMI(_EllipsesExponentiationMI that) {
        return for_EllipsesExponentiationMIOnly(that);
    }


    public Node for_EllipsesSubscriptingMI(_EllipsesSubscriptingMI that) {
        return for_EllipsesSubscriptingMIOnly(that);
    }


    public Node for_EllipsesOverloading(_EllipsesOverloading that) {
        return for_EllipsesOverloadingOnly(that);
    }


    public Node for_EllipsesNonterminalHeader(_EllipsesNonterminalHeader that) {
        return for_EllipsesNonterminalHeaderOnly(that);
    }


    public Node for_EllipsesNonterminalParameter(_EllipsesNonterminalParameter that) {
        return for_EllipsesNonterminalParameterOnly(that);
    }


    public Node for_EllipsesSyntaxDecl(_EllipsesSyntaxDecl that) {
        return for_EllipsesSyntaxDeclOnly(that);
    }


    public Node for_EllipsesSyntaxDef(_EllipsesSyntaxDef that) {
        return for_EllipsesSyntaxDefOnly(that);
    }


    public Node for_EllipsesSuperSyntaxDef(_EllipsesSuperSyntaxDef that) {
        return for_EllipsesSuperSyntaxDefOnly(that);
    }


    public Node for_EllipsesTransformerDecl(_EllipsesTransformerDecl that) {
        return for_EllipsesTransformerDeclOnly(that);
    }


    public Node for_EllipsesPreTransformerDef(_EllipsesPreTransformerDef that) {
        return for_EllipsesPreTransformerDefOnly(that);
    }


    public Node for_EllipsesNamedTransformerDef(_EllipsesNamedTransformerDef that) {
        return for_EllipsesNamedTransformerDefOnly(that);
    }


    public Node for_EllipsesTransformer(_EllipsesTransformer that) {
        return for_EllipsesTransformerOnly(that);
    }


    public Node for_EllipsesUnparsedTransformer(_EllipsesUnparsedTransformer that) {
        return for_EllipsesUnparsedTransformerOnly(that);
    }


    public Node for_EllipsesNodeTransformer(_EllipsesNodeTransformer that) {
        return for_EllipsesNodeTransformerOnly(that);
    }


    public Node for_EllipsesCaseTransformer(_EllipsesCaseTransformer that) {
        return for_EllipsesCaseTransformerOnly(that);
    }


    public Node for_EllipsesCaseTransformerClause(_EllipsesCaseTransformerClause that) {
        return for_EllipsesCaseTransformerClauseOnly(that);
    }


    public Node for_EllipsesSyntaxSymbol(_EllipsesSyntaxSymbol that) {
        return for_EllipsesSyntaxSymbolOnly(that);
    }


    public Node for_EllipsesPrefixedSymbol(_EllipsesPrefixedSymbol that) {
        return for_EllipsesPrefixedSymbolOnly(that);
    }


    public Node for_EllipsesOptionalSymbol(_EllipsesOptionalSymbol that) {
        return for_EllipsesOptionalSymbolOnly(that);
    }


    public Node for_EllipsesRepeatSymbol(_EllipsesRepeatSymbol that) {
        return for_EllipsesRepeatSymbolOnly(that);
    }


    public Node for_EllipsesRepeatOneOrMoreSymbol(_EllipsesRepeatOneOrMoreSymbol that) {
        return for_EllipsesRepeatOneOrMoreSymbolOnly(that);
    }


    public Node for_EllipsesNoWhitespaceSymbol(_EllipsesNoWhitespaceSymbol that) {
        return for_EllipsesNoWhitespaceSymbolOnly(that);
    }


    public Node for_EllipsesGroupSymbol(_EllipsesGroupSymbol that) {
        return for_EllipsesGroupSymbolOnly(that);
    }


    public Node for_EllipsesSpecialSymbol(_EllipsesSpecialSymbol that) {
        return for_EllipsesSpecialSymbolOnly(that);
    }


    public Node for_EllipsesAnyCharacterSymbol(_EllipsesAnyCharacterSymbol that) {
        return for_EllipsesAnyCharacterSymbolOnly(that);
    }


    public Node for_EllipsesWhitespaceSymbol(_EllipsesWhitespaceSymbol that) {
        return for_EllipsesWhitespaceSymbolOnly(that);
    }


    public Node for_EllipsesTabSymbol(_EllipsesTabSymbol that) {
        return for_EllipsesTabSymbolOnly(that);
    }


    public Node for_EllipsesFormfeedSymbol(_EllipsesFormfeedSymbol that) {
        return for_EllipsesFormfeedSymbolOnly(that);
    }


    public Node for_EllipsesCarriageReturnSymbol(_EllipsesCarriageReturnSymbol that) {
        return for_EllipsesCarriageReturnSymbolOnly(that);
    }


    public Node for_EllipsesBackspaceSymbol(_EllipsesBackspaceSymbol that) {
        return for_EllipsesBackspaceSymbolOnly(that);
    }


    public Node for_EllipsesNewlineSymbol(_EllipsesNewlineSymbol that) {
        return for_EllipsesNewlineSymbolOnly(that);
    }


    public Node for_EllipsesBreaklineSymbol(_EllipsesBreaklineSymbol that) {
        return for_EllipsesBreaklineSymbolOnly(that);
    }


    public Node for_EllipsesItemSymbol(_EllipsesItemSymbol that) {
        return for_EllipsesItemSymbolOnly(that);
    }


    public Node for_EllipsesNonterminalSymbol(_EllipsesNonterminalSymbol that) {
        return for_EllipsesNonterminalSymbolOnly(that);
    }


    public Node for_EllipsesKeywordSymbol(_EllipsesKeywordSymbol that) {
        return for_EllipsesKeywordSymbolOnly(that);
    }


    public Node for_EllipsesTokenSymbol(_EllipsesTokenSymbol that) {
        return for_EllipsesTokenSymbolOnly(that);
    }


    public Node for_EllipsesNotPredicateSymbol(_EllipsesNotPredicateSymbol that) {
        return for_EllipsesNotPredicateSymbolOnly(that);
    }


    public Node for_EllipsesAndPredicateSymbol(_EllipsesAndPredicateSymbol that) {
        return for_EllipsesAndPredicateSymbolOnly(that);
    }


    public Node for_EllipsesCharacterClassSymbol(_EllipsesCharacterClassSymbol that) {
        return for_EllipsesCharacterClassSymbolOnly(that);
    }


    public Node for_EllipsesCharacterSymbol(_EllipsesCharacterSymbol that) {
        return for_EllipsesCharacterSymbolOnly(that);
    }


    public Node for_EllipsesCharSymbol(_EllipsesCharSymbol that) {
        return for_EllipsesCharSymbolOnly(that);
    }


    public Node for_EllipsesCharacterInterval(_EllipsesCharacterInterval that) {
        return for_EllipsesCharacterIntervalOnly(that);
    }


    public Node for_EllipsesLink(_EllipsesLink that) {
        return for_EllipsesLinkOnly(that);
    }


    public Node forTemplateGapAbstractNode(TemplateGapAbstractNode that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapCompilationUnit(TemplateGapCompilationUnit that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapComponent(TemplateGapComponent that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapApi(TemplateGapApi that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapImport(TemplateGapImport that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapImportedNames(TemplateGapImportedNames that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapImportStar(TemplateGapImportStar that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapImportNames(TemplateGapImportNames that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapImportApi(TemplateGapImportApi that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapAliasedSimpleName(TemplateGapAliasedSimpleName that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapAliasedAPIName(TemplateGapAliasedAPIName that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapDecl(TemplateGapDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTraitObjectDecl(TemplateGapTraitObjectDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTraitDecl(TemplateGapTraitDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapObjectDecl(TemplateGapObjectDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapVarDecl(TemplateGapVarDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapFnDecl(TemplateGapFnDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGap_RewriteFnOverloadDecl(TemplateGap_RewriteFnOverloadDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGap_RewriteObjectExprDecl(TemplateGap_RewriteObjectExprDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGap_RewriteFunctionalMethodDecl(TemplateGap_RewriteFunctionalMethodDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapDimUnitDecl(TemplateGapDimUnitDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapDimDecl(TemplateGapDimDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapUnitDecl(TemplateGapUnitDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTestDecl(TemplateGapTestDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapPropertyDecl(TemplateGapPropertyDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTypeAlias(TemplateGapTypeAlias that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapGrammarDecl(TemplateGapGrammarDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapGrammarMemberDecl(TemplateGapGrammarMemberDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNonterminalDecl(TemplateGapNonterminalDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNonterminalDef(TemplateGapNonterminalDef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNonterminalExtensionDef(TemplateGapNonterminalExtensionDef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBinding(TemplateGapBinding that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapLValue(TemplateGapLValue that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapParam(TemplateGapParam that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapExpr(TemplateGapExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapDummyExpr(TemplateGapDummyExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTypeAnnotatedExpr(TemplateGapTypeAnnotatedExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapAsExpr(TemplateGapAsExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapAsIfExpr(TemplateGapAsIfExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapAssignment(TemplateGapAssignment that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBlock(TemplateGapBlock that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapDo(TemplateGapDo that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapCaseExpr(TemplateGapCaseExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapIf(TemplateGapIf that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapLabel(TemplateGapLabel that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapAbstractObjectExpr(TemplateGapAbstractObjectExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapObjectExpr(TemplateGapObjectExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGap_RewriteObjectExpr(TemplateGap_RewriteObjectExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTry(TemplateGapTry that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTupleExpr(TemplateGapTupleExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTypecase(TemplateGapTypecase that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapWhile(TemplateGapWhile that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapFor(TemplateGapFor that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBigOpApp(TemplateGapBigOpApp that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapAccumulator(TemplateGapAccumulator that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapArrayComprehension(TemplateGapArrayComprehension that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapAtomicExpr(TemplateGapAtomicExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapExit(TemplateGapExit that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapSpawn(TemplateGapSpawn that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapThrow(TemplateGapThrow that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTryAtomicExpr(TemplateGapTryAtomicExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapFnExpr(TemplateGapFnExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapLetExpr(TemplateGapLetExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapLetFn(TemplateGapLetFn that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapLocalVarDecl(TemplateGapLocalVarDecl that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapSimpleExpr(TemplateGapSimpleExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapSubscriptExpr(TemplateGapSubscriptExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapPrimary(TemplateGapPrimary that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapLiteralExpr(TemplateGapLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNumberLiteralExpr(TemplateGapNumberLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapFloatLiteralExpr(TemplateGapFloatLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapIntLiteralExpr(TemplateGapIntLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapCharLiteralExpr(TemplateGapCharLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapStringLiteralExpr(TemplateGapStringLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapVoidLiteralExpr(TemplateGapVoidLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBooleanLiteralExpr(TemplateGapBooleanLiteralExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapVarRef(TemplateGapVarRef that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapFieldRef(TemplateGapFieldRef that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapFunctionalRef(TemplateGapFunctionalRef that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapFnRef(TemplateGapFnRef that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapOpRef(TemplateGapOpRef that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGap_RewriteFnRef(TemplateGap_RewriteFnRef that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGap_RewriteObjectExprRef(TemplateGap_RewriteObjectExprRef that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapJuxt(TemplateGapJuxt that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGap_RewriteFnApp(TemplateGap_RewriteFnApp that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapOpExpr(TemplateGapOpExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapAmbiguousMultifixOpExpr(TemplateGapAmbiguousMultifixOpExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapChainExpr(TemplateGapChainExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapCoercionInvocation(TemplateGapCoercionInvocation that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTraitCoercionInvocation(TemplateGapTraitCoercionInvocation that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTupleCoercionInvocation(TemplateGapTupleCoercionInvocation that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapArrowCoercionInvocation(TemplateGapArrowCoercionInvocation that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapUnionCoercionInvocation(TemplateGapUnionCoercionInvocation that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapMethodInvocation(TemplateGapMethodInvocation that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapMathPrimary(TemplateGapMathPrimary that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapArrayExpr(TemplateGapArrayExpr that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapArrayElement(TemplateGapArrayElement that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapArrayElements(TemplateGapArrayElements that) {
        ExprInfo info_result = (ExprInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapType(TemplateGapType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBaseType(TemplateGapBaseType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapAnyType(TemplateGapAnyType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBottomType(TemplateGapBottomType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapUnknownType(TemplateGapUnknownType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapSelfType(TemplateGapSelfType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTraitSelfType(TemplateGapTraitSelfType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapObjectExprType(TemplateGapObjectExprType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNamedType(TemplateGapNamedType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapVarType(TemplateGapVarType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTraitType(TemplateGapTraitType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapArrayType(TemplateGapArrayType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapMatrixType(TemplateGapMatrixType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTaggedDimType(TemplateGapTaggedDimType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTupleType(TemplateGapTupleType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapArrowType(TemplateGapArrowType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBoundType(TemplateGapBoundType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapIntersectionType(TemplateGapIntersectionType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapUnionType(TemplateGapUnionType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapFixedPointType(TemplateGapFixedPointType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapLabelType(TemplateGapLabelType that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapDimExpr(TemplateGapDimExpr that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapDimBase(TemplateGapDimBase that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapDimRef(TemplateGapDimRef that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapDimExponent(TemplateGapDimExponent that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that) {
        TypeInfo info_result = (TypeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapPattern(TemplateGapPattern that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapPatternArgs(TemplateGapPatternArgs that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapPatternBinding(TemplateGapPatternBinding that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapPlainPattern(TemplateGapPlainPattern that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTypePattern(TemplateGapTypePattern that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNestedPattern(TemplateGapNestedPattern that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapStaticArg(TemplateGapStaticArg that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTypeArg(TemplateGapTypeArg that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapIntArg(TemplateGapIntArg that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBoolArg(TemplateGapBoolArg that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapOpArg(TemplateGapOpArg that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapDimArg(TemplateGapDimArg that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapUnitArg(TemplateGapUnitArg that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapStaticExpr(TemplateGapStaticExpr that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapIntExpr(TemplateGapIntExpr that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapIntBase(TemplateGapIntBase that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapIntRef(TemplateGapIntRef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapIntBinaryOp(TemplateGapIntBinaryOp that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBoolExpr(TemplateGapBoolExpr that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBoolBase(TemplateGapBoolBase that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBoolRef(TemplateGapBoolRef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBoolConstraint(TemplateGapBoolConstraint that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBoolUnaryOp(TemplateGapBoolUnaryOp that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBoolBinaryOp(TemplateGapBoolBinaryOp that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapUnitExpr(TemplateGapUnitExpr that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapUnitRef(TemplateGapUnitRef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapUnitBinaryOp(TemplateGapUnitBinaryOp that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapEffect(TemplateGapEffect that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapWhereClause(TemplateGapWhereClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapWhereBinding(TemplateGapWhereBinding that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapWhereConstraint(TemplateGapWhereConstraint that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapWhereExtends(TemplateGapWhereExtends that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapWhereTypeAlias(TemplateGapWhereTypeAlias that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapWhereCoerces(TemplateGapWhereCoerces that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapWhereEquals(TemplateGapWhereEquals that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapUnitConstraint(TemplateGapUnitConstraint that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapIntConstraint(TemplateGapIntConstraint that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBoolConstraintExpr(TemplateGapBoolConstraintExpr that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapContract(TemplateGapContract that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapEnsuresClause(TemplateGapEnsuresClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapStaticParam(TemplateGapStaticParam that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapName(TemplateGapName that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapAPIName(TemplateGapAPIName that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapIdOrOpOrAnonymousName(TemplateGapIdOrOpOrAnonymousName that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapIdOrOp(TemplateGapIdOrOp that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapId(TemplateGapId that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapOp(TemplateGapOp that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNamedOp(TemplateGapNamedOp that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGap_InferenceVarOp(TemplateGap_InferenceVarOp that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapAnonymousName(TemplateGapAnonymousName that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapAnonymousFnName(TemplateGapAnonymousFnName that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapConstructorFnName(TemplateGapConstructorFnName that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapArrayComprehensionClause(TemplateGapArrayComprehensionClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapKeywordExpr(TemplateGapKeywordExpr that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapCaseClause(TemplateGapCaseClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapCatch(TemplateGapCatch that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapCatchClause(TemplateGapCatchClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapIfClause(TemplateGapIfClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTypecaseClause(TemplateGapTypecaseClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapExtentRange(TemplateGapExtentRange that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapGeneratorClause(TemplateGapGeneratorClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapKeywordType(TemplateGapKeywordType that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTraitTypeWhere(TemplateGapTraitTypeWhere that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapIndices(TemplateGapIndices that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapMathItem(TemplateGapMathItem that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapExprMI(TemplateGapExprMI that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapParenthesisDelimitedMI(TemplateGapParenthesisDelimitedMI that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNonParenthesisDelimitedMI(TemplateGapNonParenthesisDelimitedMI that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNonExprMI(TemplateGapNonExprMI that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapExponentiationMI(TemplateGapExponentiationMI that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapSubscriptingMI(TemplateGapSubscriptingMI that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapOverloading(TemplateGapOverloading that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNonterminalHeader(TemplateGapNonterminalHeader that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNonterminalParameter(TemplateGapNonterminalParameter that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapSyntaxDecl(TemplateGapSyntaxDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapSyntaxDef(TemplateGapSyntaxDef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapSuperSyntaxDef(TemplateGapSuperSyntaxDef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTransformerDecl(TemplateGapTransformerDecl that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapPreTransformerDef(TemplateGapPreTransformerDef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNamedTransformerDef(TemplateGapNamedTransformerDef that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTransformer(TemplateGapTransformer that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapUnparsedTransformer(TemplateGapUnparsedTransformer that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNodeTransformer(TemplateGapNodeTransformer that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapCaseTransformer(TemplateGapCaseTransformer that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapCaseTransformerClause(TemplateGapCaseTransformerClause that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapSyntaxSymbol(TemplateGapSyntaxSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapPrefixedSymbol(TemplateGapPrefixedSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapOptionalSymbol(TemplateGapOptionalSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapRepeatSymbol(TemplateGapRepeatSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapRepeatOneOrMoreSymbol(TemplateGapRepeatOneOrMoreSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNoWhitespaceSymbol(TemplateGapNoWhitespaceSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapGroupSymbol(TemplateGapGroupSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapSpecialSymbol(TemplateGapSpecialSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapAnyCharacterSymbol(TemplateGapAnyCharacterSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapWhitespaceSymbol(TemplateGapWhitespaceSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTabSymbol(TemplateGapTabSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapFormfeedSymbol(TemplateGapFormfeedSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapCarriageReturnSymbol(TemplateGapCarriageReturnSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBackspaceSymbol(TemplateGapBackspaceSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNewlineSymbol(TemplateGapNewlineSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapBreaklineSymbol(TemplateGapBreaklineSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapItemSymbol(TemplateGapItemSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNonterminalSymbol(TemplateGapNonterminalSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapKeywordSymbol(TemplateGapKeywordSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapTokenSymbol(TemplateGapTokenSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapNotPredicateSymbol(TemplateGapNotPredicateSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapAndPredicateSymbol(TemplateGapAndPredicateSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapCharacterClassSymbol(TemplateGapCharacterClassSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapCharacterSymbol(TemplateGapCharacterSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapCharSymbol(TemplateGapCharSymbol that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapCharacterInterval(TemplateGapCharacterInterval that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }


    public Node forTemplateGapLink(TemplateGapLink that) {
        ASTNodeInfo info_result = (ASTNodeInfo) recur(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOnly((TemplateGap) that, info_result, gapId_result, templateParams_result);
    }

    public Node forTemplateGapOnly(TemplateGap that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        return that;
    }

    public Node recur(Node that) {
        return that.accept(this);
    }

    public Node defaultTransformationNodeCase( _SyntaxTransformation s ){
        return s;
    }

    public Node defaultEllipsesNodeOnly( _Ellipses s ){
        return s;
    }

    public List<Import> recurOnListOfImport(List<Import> that) {
        java.util.ArrayList<Import> accum = new java.util.ArrayList<Import>();
        boolean unchanged = true;
        for (Import elt : that) {
            Import update_elt = (Import) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<Decl> recurOnListOfDecl(List<Decl> that) {
        java.util.ArrayList<Decl> accum = new java.util.ArrayList<Decl>();
        boolean unchanged = true;
        for (Decl elt : that) {
            Decl update_elt = (Decl) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<APIName> recurOnListOfAPIName(List<APIName> that) {
        java.util.ArrayList<APIName> accum = new java.util.ArrayList<APIName>();
        boolean unchanged = true;
        for (APIName elt : that) {
            APIName update_elt = (APIName) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<IdOrOpOrAnonymousName> recurOnListOfIdOrOpOrAnonymousName(List<IdOrOpOrAnonymousName> that) {
        java.util.ArrayList<IdOrOpOrAnonymousName> accum = new java.util.ArrayList<IdOrOpOrAnonymousName>();
        boolean unchanged = true;
        for (IdOrOpOrAnonymousName elt : that) {
            IdOrOpOrAnonymousName update_elt = (IdOrOpOrAnonymousName) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<AliasedSimpleName> recurOnListOfAliasedSimpleName(List<AliasedSimpleName> that) {
        java.util.ArrayList<AliasedSimpleName> accum = new java.util.ArrayList<AliasedSimpleName>();
        boolean unchanged = true;
        for (AliasedSimpleName elt : that) {
            AliasedSimpleName update_elt = (AliasedSimpleName) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<AliasedAPIName> recurOnListOfAliasedAPIName(List<AliasedAPIName> that) {
        java.util.ArrayList<AliasedAPIName> accum = new java.util.ArrayList<AliasedAPIName>();
        boolean unchanged = true;
        for (AliasedAPIName elt : that) {
            AliasedAPIName update_elt = (AliasedAPIName) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<IdOrOpOrAnonymousName> recurOnOptionOfIdOrOpOrAnonymousName(Option<IdOrOpOrAnonymousName> that) {
        if (that.isNone()) { return that; }
        else {
            IdOrOpOrAnonymousName original = that.unwrap();
            IdOrOpOrAnonymousName updated = (IdOrOpOrAnonymousName) recur(original);
            return (original == updated) ? that : Option.<IdOrOpOrAnonymousName>some(updated);
        }
    }

    public Option<Id> recurOnOptionOfId(Option<Id> that) {
        if (that.isNone()) { return that; }
        else {
            Id original = that.unwrap();
            Id updated = (Id) recur(original);
            return (original == updated) ? that : Option.<Id>some(updated);
        }
    }

    public Option<SelfType> recurOnOptionOfSelfType(Option<SelfType> that) {
        if (that.isNone()) { return that; }
        else {
            SelfType original = that.unwrap();
            SelfType updated = (SelfType) recur(original);
            return (original == updated) ? that : Option.<SelfType>some(updated);
        }
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

    public Option<List<NamedType>> recurOnOptionOfListOfNamedType(Option<List<NamedType>> that) {
        if (that.isNone()) { return that; }
        else {
            List<NamedType> original = that.unwrap();
            List<NamedType> updated = recurOnListOfNamedType(original);
            return (original == updated) ? that : Option.<List<NamedType>>some(updated);
        }
    }

    public List<LValue> recurOnListOfLValue(List<LValue> that) {
        java.util.ArrayList<LValue> accum = new java.util.ArrayList<LValue>();
        boolean unchanged = true;
        for (LValue elt : that) {
            LValue update_elt = (LValue) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<Expr> recurOnOptionOfExpr(Option<Expr> that) {
        if (that.isNone()) { return that; }
        else {
            Expr original = that.unwrap();
            Expr updated = (Expr) recur(original);
            return (original == updated) ? that : Option.<Expr>some(updated);
        }
    }

    public Option<IdOrOp> recurOnOptionOfIdOrOp(Option<IdOrOp> that) {
        if (that.isNone()) { return that; }
        else {
            IdOrOp original = that.unwrap();
            IdOrOp updated = (IdOrOp) recur(original);
            return (original == updated) ? that : Option.<IdOrOp>some(updated);
        }
    }

    public List<IdOrOp> recurOnListOfIdOrOp(List<IdOrOp> that) {
        java.util.ArrayList<IdOrOp> accum = new java.util.ArrayList<IdOrOp>();
        boolean unchanged = true;
        for (IdOrOp elt : that) {
            IdOrOp update_elt = (IdOrOp) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<Type> recurOnOptionOfType(Option<Type> that) {
        if (that.isNone()) { return that; }
        else {
            Type original = that.unwrap();
            Type updated = (Type) recur(original);
            return (original == updated) ? that : Option.<Type>some(updated);
        }
    }

    public List<_RewriteObjectExpr> recurOnListOf_RewriteObjectExpr(List<_RewriteObjectExpr> that) {
        java.util.ArrayList<_RewriteObjectExpr> accum = new java.util.ArrayList<_RewriteObjectExpr>();
        boolean unchanged = true;
        for (_RewriteObjectExpr elt : that) {
            _RewriteObjectExpr update_elt = (_RewriteObjectExpr) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<Id> recurOnListOfId(List<Id> that) {
        java.util.ArrayList<Id> accum = new java.util.ArrayList<Id>();
        boolean unchanged = true;
        for (Id elt : that) {
            Id update_elt = (Id) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<GeneratorClause> recurOnListOfGeneratorClause(List<GeneratorClause> that) {
        java.util.ArrayList<GeneratorClause> accum = new java.util.ArrayList<GeneratorClause>();
        boolean unchanged = true;
        for (GeneratorClause elt : that) {
            GeneratorClause update_elt = (GeneratorClause) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<Param> recurOnListOfParam(List<Param> that) {
        java.util.ArrayList<Param> accum = new java.util.ArrayList<Param>();
        boolean unchanged = true;
        for (Param elt : that) {
            Param update_elt = (Param) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<StaticParam> recurOnListOfStaticParam(List<StaticParam> that) {
        java.util.ArrayList<StaticParam> accum = new java.util.ArrayList<StaticParam>();
        boolean unchanged = true;
        for (StaticParam elt : that) {
            StaticParam update_elt = (StaticParam) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<GrammarMemberDecl> recurOnListOfGrammarMemberDecl(List<GrammarMemberDecl> that) {
        java.util.ArrayList<GrammarMemberDecl> accum = new java.util.ArrayList<GrammarMemberDecl>();
        boolean unchanged = true;
        for (GrammarMemberDecl elt : that) {
            GrammarMemberDecl update_elt = (GrammarMemberDecl) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<TransformerDecl> recurOnListOfTransformerDecl(List<TransformerDecl> that) {
        java.util.ArrayList<TransformerDecl> accum = new java.util.ArrayList<TransformerDecl>();
        boolean unchanged = true;
        for (TransformerDecl elt : that) {
            TransformerDecl update_elt = (TransformerDecl) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<SyntaxDecl> recurOnListOfSyntaxDecl(List<SyntaxDecl> that) {
        java.util.ArrayList<SyntaxDecl> accum = new java.util.ArrayList<SyntaxDecl>();
        boolean unchanged = true;
        for (SyntaxDecl elt : that) {
            SyntaxDecl update_elt = (SyntaxDecl) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<BaseType> recurOnOptionOfBaseType(Option<BaseType> that) {
        if (that.isNone()) { return that; }
        else {
            BaseType original = that.unwrap();
            BaseType updated = (BaseType) recur(original);
            return (original == updated) ? that : Option.<BaseType>some(updated);
        }
    }

    public Option<TypeOrPattern> recurOnOptionOfTypeOrPattern(Option<TypeOrPattern> that) {
        if (that.isNone()) { return that; }
        else {
            TypeOrPattern original = that.unwrap();
            TypeOrPattern updated = (TypeOrPattern) recur(original);
            return (original == updated) ? that : Option.<TypeOrPattern>some(updated);
        }
    }

    public List<Lhs> recurOnListOfLhs(List<Lhs> that) {
        java.util.ArrayList<Lhs> accum = new java.util.ArrayList<Lhs>();
        boolean unchanged = true;
        for (Lhs elt : that) {
            Lhs update_elt = (Lhs) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<FunctionalRef> recurOnOptionOfFunctionalRef(Option<FunctionalRef> that) {
        if (that.isNone()) { return that; }
        else {
            FunctionalRef original = that.unwrap();
            FunctionalRef updated = (FunctionalRef) recur(original);
            return (original == updated) ? that : Option.<FunctionalRef>some(updated);
        }
    }

    public List<CompoundAssignmentInfo> recurOnListOfCompoundAssignmentInfo(List<CompoundAssignmentInfo> that) {
        java.util.ArrayList<CompoundAssignmentInfo> accum = new java.util.ArrayList<CompoundAssignmentInfo>();
        boolean unchanged = true;
        for (CompoundAssignmentInfo elt : that) {
            CompoundAssignmentInfo update_elt = (CompoundAssignmentInfo) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<Expr> recurOnListOfExpr(List<Expr> that) {
        java.util.ArrayList<Expr> accum = new java.util.ArrayList<Expr>();
        boolean unchanged = true;
        for (Expr elt : that) {
            Expr update_elt = (Expr) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<Block> recurOnListOfBlock(List<Block> that) {
        java.util.ArrayList<Block> accum = new java.util.ArrayList<Block>();
        boolean unchanged = true;
        for (Block elt : that) {
            Block update_elt = (Block) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<CaseClause> recurOnListOfCaseClause(List<CaseClause> that) {
        java.util.ArrayList<CaseClause> accum = new java.util.ArrayList<CaseClause>();
        boolean unchanged = true;
        for (CaseClause elt : that) {
            CaseClause update_elt = (CaseClause) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<Block> recurOnOptionOfBlock(Option<Block> that) {
        if (that.isNone()) { return that; }
        else {
            Block original = that.unwrap();
            Block updated = (Block) recur(original);
            return (original == updated) ? that : Option.<Block>some(updated);
        }
    }

    public List<IfClause> recurOnListOfIfClause(List<IfClause> that) {
        java.util.ArrayList<IfClause> accum = new java.util.ArrayList<IfClause>();
        boolean unchanged = true;
        for (IfClause elt : that) {
            IfClause update_elt = (IfClause) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<StaticArg> recurOnListOfStaticArg(List<StaticArg> that) {
        java.util.ArrayList<StaticArg> accum = new java.util.ArrayList<StaticArg>();
        boolean unchanged = true;
        for (StaticArg elt : that) {
            StaticArg update_elt = (StaticArg) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<Catch> recurOnOptionOfCatch(Option<Catch> that) {
        if (that.isNone()) { return that; }
        else {
            Catch original = that.unwrap();
            Catch updated = (Catch) recur(original);
            return (original == updated) ? that : Option.<Catch>some(updated);
        }
    }

    public List<KeywordExpr> recurOnListOfKeywordExpr(List<KeywordExpr> that) {
        java.util.ArrayList<KeywordExpr> accum = new java.util.ArrayList<KeywordExpr>();
        boolean unchanged = true;
        for (KeywordExpr elt : that) {
            KeywordExpr update_elt = (KeywordExpr) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<TypecaseClause> recurOnListOfTypecaseClause(List<TypecaseClause> that) {
        java.util.ArrayList<TypecaseClause> accum = new java.util.ArrayList<TypecaseClause>();
        boolean unchanged = true;
        for (TypecaseClause elt : that) {
            TypecaseClause update_elt = (TypecaseClause) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<ArrayComprehensionClause> recurOnListOfArrayComprehensionClause(List<ArrayComprehensionClause> that) {
        java.util.ArrayList<ArrayComprehensionClause> accum = new java.util.ArrayList<ArrayComprehensionClause>();
        boolean unchanged = true;
        for (ArrayComprehensionClause elt : that) {
            ArrayComprehensionClause update_elt = (ArrayComprehensionClause) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<FnDecl> recurOnListOfFnDecl(List<FnDecl> that) {
        java.util.ArrayList<FnDecl> accum = new java.util.ArrayList<FnDecl>();
        boolean unchanged = true;
        for (FnDecl elt : that) {
            FnDecl update_elt = (FnDecl) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<Op> recurOnOptionOfOp(Option<Op> that) {
        if (that.isNone()) { return that; }
        else {
            Op original = that.unwrap();
            Op updated = (Op) recur(original);
            return (original == updated) ? that : Option.<Op>some(updated);
        }
    }

    public List<Overloading> recurOnListOfOverloading(List<Overloading> that) {
        java.util.ArrayList<Overloading> accum = new java.util.ArrayList<Overloading>();
        boolean unchanged = true;
        for (Overloading elt : that) {
            Overloading update_elt = (Overloading) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<Link> recurOnListOfLink(List<Link> that) {
        java.util.ArrayList<Link> accum = new java.util.ArrayList<Link>();
        boolean unchanged = true;
        for (Link elt : that) {
            Link update_elt = (Link) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<CoercionInvocation> recurOnOptionOfCoercionInvocation(Option<CoercionInvocation> that) {
        if (that.isNone()) { return that; }
        else {
            CoercionInvocation original = that.unwrap();
            CoercionInvocation updated = (CoercionInvocation) recur(original);
            return (original == updated) ? that : Option.<CoercionInvocation>some(updated);
        }
    }

    public List<Option<CoercionInvocation>> recurOnListOfOptionOfCoercionInvocation(List<Option<CoercionInvocation>> that) {
        java.util.ArrayList<Option<CoercionInvocation>> accum = new java.util.ArrayList<Option<CoercionInvocation>>();
        boolean unchanged = true;
        for (Option<CoercionInvocation> elt : that) {
            Option<CoercionInvocation> update_elt = recurOnOptionOfCoercionInvocation(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<Option<CoercionInvocation>> recurOnOptionOfOptionOfCoercionInvocation(Option<Option<CoercionInvocation>> that) {
        if (that.isNone()) { return that; }
        else {
            Option<CoercionInvocation> original = that.unwrap();
            Option<CoercionInvocation> updated = recurOnOptionOfCoercionInvocation(original);
            return (original == updated) ? that : Option.<Option<CoercionInvocation>>some(updated);
        }
    }

    public List<Type> recurOnListOfType(List<Type> that) {
        java.util.ArrayList<Type> accum = new java.util.ArrayList<Type>();
        boolean unchanged = true;
        for (Type elt : that) {
            Type update_elt = (Type) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<MathItem> recurOnListOfMathItem(List<MathItem> that) {
        java.util.ArrayList<MathItem> accum = new java.util.ArrayList<MathItem>();
        boolean unchanged = true;
        for (MathItem elt : that) {
            MathItem update_elt = (MathItem) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<ArrayExpr> recurOnListOfArrayExpr(List<ArrayExpr> that) {
        java.util.ArrayList<ArrayExpr> accum = new java.util.ArrayList<ArrayExpr>();
        boolean unchanged = true;
        for (ArrayExpr elt : that) {
            ArrayExpr update_elt = (ArrayExpr) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<ExtentRange> recurOnListOfExtentRange(List<ExtentRange> that) {
        java.util.ArrayList<ExtentRange> accum = new java.util.ArrayList<ExtentRange>();
        boolean unchanged = true;
        for (ExtentRange elt : that) {
            ExtentRange update_elt = (ExtentRange) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<KeywordType> recurOnListOfKeywordType(List<KeywordType> that) {
        java.util.ArrayList<KeywordType> accum = new java.util.ArrayList<KeywordType>();
        boolean unchanged = true;
        for (KeywordType elt : that) {
            KeywordType update_elt = (KeywordType) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<MethodInfo> recurOnOptionOfMethodInfo(Option<MethodInfo> that) {
        if (that.isNone()) { return that; }
        else {
            MethodInfo original = that.unwrap();
            MethodInfo updated = (MethodInfo) recur(original);
            return (original == updated) ? that : Option.<MethodInfo>some(updated);
        }
    }

    public List<PatternBinding> recurOnListOfPatternBinding(List<PatternBinding> that) {
        java.util.ArrayList<PatternBinding> accum = new java.util.ArrayList<PatternBinding>();
        boolean unchanged = true;
        for (PatternBinding elt : that) {
            PatternBinding update_elt = (PatternBinding) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<List<Type>> recurOnOptionOfListOfType(Option<List<Type>> that) {
        if (that.isNone()) { return that; }
        else {
            List<Type> original = that.unwrap();
            List<Type> updated = recurOnListOfType(original);
            return (original == updated) ? that : Option.<List<Type>>some(updated);
        }
    }

    public List<WhereBinding> recurOnListOfWhereBinding(List<WhereBinding> that) {
        java.util.ArrayList<WhereBinding> accum = new java.util.ArrayList<WhereBinding>();
        boolean unchanged = true;
        for (WhereBinding elt : that) {
            WhereBinding update_elt = (WhereBinding) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<WhereConstraint> recurOnListOfWhereConstraint(List<WhereConstraint> that) {
        java.util.ArrayList<WhereConstraint> accum = new java.util.ArrayList<WhereConstraint>();
        boolean unchanged = true;
        for (WhereConstraint elt : that) {
            WhereConstraint update_elt = (WhereConstraint) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<List<Expr>> recurOnOptionOfListOfExpr(Option<List<Expr>> that) {
        if (that.isNone()) { return that; }
        else {
            List<Expr> original = that.unwrap();
            List<Expr> updated = recurOnListOfExpr(original);
            return (original == updated) ? that : Option.<List<Expr>>some(updated);
        }
    }

    public List<EnsuresClause> recurOnListOfEnsuresClause(List<EnsuresClause> that) {
        java.util.ArrayList<EnsuresClause> accum = new java.util.ArrayList<EnsuresClause>();
        boolean unchanged = true;
        for (EnsuresClause elt : that) {
            EnsuresClause update_elt = (EnsuresClause) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<List<EnsuresClause>> recurOnOptionOfListOfEnsuresClause(Option<List<EnsuresClause>> that) {
        if (that.isNone()) { return that; }
        else {
            List<EnsuresClause> original = that.unwrap();
            List<EnsuresClause> updated = recurOnListOfEnsuresClause(original);
            return (original == updated) ? that : Option.<List<EnsuresClause>>some(updated);
        }
    }

    public Option<APIName> recurOnOptionOfAPIName(Option<APIName> that) {
        if (that.isNone()) { return that; }
        else {
            APIName original = that.unwrap();
            APIName updated = (APIName) recur(original);
            return (original == updated) ? that : Option.<APIName>some(updated);
        }
    }

    public List<CatchClause> recurOnListOfCatchClause(List<CatchClause> that) {
        java.util.ArrayList<CatchClause> accum = new java.util.ArrayList<CatchClause>();
        boolean unchanged = true;
        for (CatchClause elt : that) {
            CatchClause update_elt = (CatchClause) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<StaticArg> recurOnOptionOfStaticArg(Option<StaticArg> that) {
        if (that.isNone()) { return that; }
        else {
            StaticArg original = that.unwrap();
            StaticArg updated = (StaticArg) recur(original);
            return (original == updated) ? that : Option.<StaticArg>some(updated);
        }
    }

    public Option<WhereClause> recurOnOptionOfWhereClause(Option<WhereClause> that) {
        if (that.isNone()) { return that; }
        else {
            WhereClause original = that.unwrap();
            WhereClause updated = (WhereClause) recur(original);
            return (original == updated) ? that : Option.<WhereClause>some(updated);
        }
    }

    public Option<ArrowType> recurOnOptionOfArrowType(Option<ArrowType> that) {
        if (that.isNone()) { return that; }
        else {
            ArrowType original = that.unwrap();
            ArrowType updated = (ArrowType) recur(original);
            return (original == updated) ? that : Option.<ArrowType>some(updated);
        }
    }

    public List<NonterminalParameter> recurOnListOfNonterminalParameter(List<NonterminalParameter> that) {
        java.util.ArrayList<NonterminalParameter> accum = new java.util.ArrayList<NonterminalParameter>();
        boolean unchanged = true;
        for (NonterminalParameter elt : that) {
            NonterminalParameter update_elt = (NonterminalParameter) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<SyntaxSymbol> recurOnListOfSyntaxSymbol(List<SyntaxSymbol> that) {
        java.util.ArrayList<SyntaxSymbol> accum = new java.util.ArrayList<SyntaxSymbol>();
        boolean unchanged = true;
        for (SyntaxSymbol elt : that) {
            SyntaxSymbol update_elt = (SyntaxSymbol) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<CaseTransformerClause> recurOnListOfCaseTransformerClause(List<CaseTransformerClause> that) {
        java.util.ArrayList<CaseTransformerClause> accum = new java.util.ArrayList<CaseTransformerClause>();
        boolean unchanged = true;
        for (CaseTransformerClause elt : that) {
            CaseTransformerClause update_elt = (CaseTransformerClause) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public List<CharacterSymbol> recurOnListOfCharacterSymbol(List<CharacterSymbol> that) {
        java.util.ArrayList<CharacterSymbol> accum = new java.util.ArrayList<CharacterSymbol>();
        boolean unchanged = true;
        for (CharacterSymbol elt : that) {
            CharacterSymbol update_elt = (CharacterSymbol) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<Contract> recurOnOptionOfContract(Option<Contract> that) {
        if (that.isNone()) { return that; }
        else {
            Contract original = that.unwrap();
            Contract updated = (Contract) recur(original);
            return (original == updated) ? that : Option.<Contract>some(updated);
        }
    }

    public List<TraitTypeWhere> recurOnListOfTraitTypeWhere(List<TraitTypeWhere> that) {
        java.util.ArrayList<TraitTypeWhere> accum = new java.util.ArrayList<TraitTypeWhere>();
        boolean unchanged = true;
        for (TraitTypeWhere elt : that) {
            TraitTypeWhere update_elt = (TraitTypeWhere) recur(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<List<Param>> recurOnOptionOfListOfParam(Option<List<Param>> that) {
        if (that.isNone()) { return that; }
        else {
            List<Param> original = that.unwrap();
            List<Param> updated = recurOnListOfParam(original);
            return (original == updated) ? that : Option.<List<Param>>some(updated);
        }
    }
}
