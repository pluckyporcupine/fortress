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
public abstract class AbstractNodeUpdateVisitor extends AbstractNodeVisitorLambda<AbstractNode> {

    /* Methods to handle a node after recursion. */

    public AbstractNode forComponentOnly(Component that, ASTNodeInfo info_result, APIName name_result, List<Import> imports_result, List<Decl> decls_result, List<APIName> comprises_result, List<APIName> exports_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getImports() == imports_result && that.getDecls() == decls_result && that.getComprises() == comprises_result && that.getExports() == exports_result) return that;
        else return new Component(info_result, name_result, imports_result, decls_result, comprises_result, that.is_native(), exports_result);
    }

    public AbstractNode forApiOnly(Api that, ASTNodeInfo info_result, APIName name_result, List<Import> imports_result, List<Decl> decls_result, List<APIName> comprises_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getImports() == imports_result && that.getDecls() == decls_result && that.getComprises() == comprises_result) return that;
        else return new Api(info_result, name_result, imports_result, decls_result, comprises_result);
    }

    public AbstractNode forImportStarOnly(ImportStar that, ASTNodeInfo info_result, APIName apiName_result, List<IdOrOpOrAnonymousName> exceptNames_result) {
        if (that.getInfo() == info_result && that.getApiName() == apiName_result && that.getExceptNames() == exceptNames_result) return that;
        else return new ImportStar(info_result, that.getForeignLanguage(), apiName_result, exceptNames_result);
    }

    public AbstractNode forImportNamesOnly(ImportNames that, ASTNodeInfo info_result, APIName apiName_result, List<AliasedSimpleName> aliasedNames_result) {
        if (that.getInfo() == info_result && that.getApiName() == apiName_result && that.getAliasedNames() == aliasedNames_result) return that;
        else return new ImportNames(info_result, that.getForeignLanguage(), apiName_result, aliasedNames_result);
    }

    public AbstractNode forImportApiOnly(ImportApi that, ASTNodeInfo info_result, List<AliasedAPIName> apis_result) {
        if (that.getInfo() == info_result && that.getApis() == apis_result) return that;
        else return new ImportApi(info_result, that.getForeignLanguage(), apis_result);
    }

    public AbstractNode forAliasedSimpleNameOnly(AliasedSimpleName that, ASTNodeInfo info_result, IdOrOpOrAnonymousName name_result, Option<IdOrOpOrAnonymousName> alias_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getAlias() == alias_result) return that;
        else return new AliasedSimpleName(info_result, name_result, alias_result);
    }

    public AbstractNode forAliasedAPINameOnly(AliasedAPIName that, ASTNodeInfo info_result, APIName apiName_result, Option<Id> alias_result) {
        if (that.getInfo() == info_result && that.getApiName() == apiName_result && that.getAlias() == alias_result) return that;
        else return new AliasedAPIName(info_result, apiName_result, alias_result);
    }

    public AbstractNode forTraitDeclOnly(TraitDecl that, ASTNodeInfo info_result, TraitTypeHeader header_result, Option<SelfType> selfType_result, List<BaseType> excludesClause_result, Option<List<NamedType>> comprisesClause_result) {
        if (that.getInfo() == info_result && that.getHeader() == header_result && that.getSelfType() == selfType_result && that.getExcludesClause() == excludesClause_result && that.getComprisesClause() == comprisesClause_result) return that;
        else return new TraitDecl(info_result, header_result, selfType_result, excludesClause_result, comprisesClause_result, that.isComprisesEllipses());
    }

    public AbstractNode forObjectDeclOnly(ObjectDecl that, ASTNodeInfo info_result, TraitTypeHeader header_result, Option<SelfType> selfType_result) {
        if (that.getInfo() == info_result && that.getHeader() == header_result && that.getSelfType() == selfType_result) return that;
        else return new ObjectDecl(info_result, header_result, selfType_result);
    }

    public AbstractNode forVarDeclOnly(VarDecl that, ASTNodeInfo info_result, List<LValue> lhs_result, Option<Expr> init_result) {
        if (that.getInfo() == info_result && that.getLhs() == lhs_result && that.getInit() == init_result) return that;
        else return new VarDecl(info_result, lhs_result, init_result);
    }

    public AbstractNode forFnDeclOnly(FnDecl that, ASTNodeInfo info_result, FnHeader header_result, IdOrOp unambiguousName_result, Option<Expr> body_result, Option<IdOrOp> implementsUnambiguousName_result) {
        if (that.getInfo() == info_result && that.getHeader() == header_result && that.getUnambiguousName() == unambiguousName_result && that.getBody() == body_result && that.getImplementsUnambiguousName() == implementsUnambiguousName_result) return that;
        else return new FnDecl(info_result, header_result, unambiguousName_result, body_result, implementsUnambiguousName_result);
    }

    public AbstractNode for_RewriteFnOverloadDeclOnly(_RewriteFnOverloadDecl that, ASTNodeInfo info_result, IdOrOp name_result, List<IdOrOp> fns_result, Option<Type> type_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getFns() == fns_result && that.getType() == type_result) return that;
        else return new _RewriteFnOverloadDecl(info_result, name_result, fns_result, type_result);
    }

    public AbstractNode for_RewriteObjectExprDeclOnly(_RewriteObjectExprDecl that, ASTNodeInfo info_result, List<_RewriteObjectExpr> objectExprs_result) {
        if (that.getInfo() == info_result && that.getObjectExprs() == objectExprs_result) return that;
        else return new _RewriteObjectExprDecl(info_result, objectExprs_result);
    }

    public AbstractNode for_RewriteFunctionalMethodDeclOnly(_RewriteFunctionalMethodDecl that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _RewriteFunctionalMethodDecl(info_result, that.getFunctionalMethodNames());
    }

    public AbstractNode forDimDeclOnly(DimDecl that, ASTNodeInfo info_result, Id dimId_result, Option<Type> derived_result, Option<Id> defaultId_result) {
        if (that.getInfo() == info_result && that.getDimId() == dimId_result && that.getDerived() == derived_result && that.getDefaultId() == defaultId_result) return that;
        else return new DimDecl(info_result, dimId_result, derived_result, defaultId_result);
    }

    public AbstractNode forUnitDeclOnly(UnitDecl that, ASTNodeInfo info_result, List<Id> units_result, Option<Type> dimType_result, Option<Expr> defExpr_result) {
        if (that.getInfo() == info_result && that.getUnits() == units_result && that.getDimType() == dimType_result && that.getDefExpr() == defExpr_result) return that;
        else return new UnitDecl(info_result, that.isSi_unit(), units_result, dimType_result, defExpr_result);
    }

    public AbstractNode forTestDeclOnly(TestDecl that, ASTNodeInfo info_result, Id name_result, List<GeneratorClause> gens_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getGens() == gens_result && that.getExpr() == expr_result) return that;
        else return new TestDecl(info_result, name_result, gens_result, expr_result);
    }

    public AbstractNode forPropertyDeclOnly(PropertyDecl that, ASTNodeInfo info_result, Option<Id> name_result, List<Param> params_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getParams() == params_result && that.getExpr() == expr_result) return that;
        else return new PropertyDecl(info_result, name_result, params_result, expr_result);
    }

    public AbstractNode forTypeAliasOnly(TypeAlias that, ASTNodeInfo info_result, Id name_result, List<StaticParam> staticParams_result, Type typeDef_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getStaticParams() == staticParams_result && that.getTypeDef() == typeDef_result) return that;
        else return new TypeAlias(info_result, name_result, staticParams_result, typeDef_result);
    }

    public AbstractNode forGrammarDeclOnly(GrammarDecl that, ASTNodeInfo info_result, Id name_result, List<Id> extendsClause_result, List<GrammarMemberDecl> members_result, List<TransformerDecl> transformers_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getExtendsClause() == extendsClause_result && that.getMembers() == members_result && that.getTransformers() == transformers_result) return that;
        else return new GrammarDecl(info_result, name_result, extendsClause_result, members_result, transformers_result, that.isNativeDef());
    }

    public AbstractNode forNonterminalDefOnly(NonterminalDef that, ASTNodeInfo info_result, Id name_result, List<SyntaxDecl> syntaxDecls_result, NonterminalHeader header_result, Option<BaseType> astType_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getSyntaxDecls() == syntaxDecls_result && that.getHeader() == header_result && that.getAstType() == astType_result) return that;
        else return new NonterminalDef(info_result, name_result, syntaxDecls_result, header_result, astType_result);
    }

    public AbstractNode forNonterminalExtensionDefOnly(NonterminalExtensionDef that, ASTNodeInfo info_result, Id name_result, List<SyntaxDecl> syntaxDecls_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getSyntaxDecls() == syntaxDecls_result) return that;
        else return new NonterminalExtensionDef(info_result, name_result, syntaxDecls_result);
    }

    public AbstractNode forLValueOnly(LValue that, ASTNodeInfo info_result, Id name_result, Option<TypeOrPattern> idType_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getIdType() == idType_result) return that;
        else return new LValue(info_result, name_result, that.getMods(), idType_result, that.isMutable());
    }

    public AbstractNode forParamOnly(Param that, ASTNodeInfo info_result, Id name_result, Option<TypeOrPattern> idType_result, Option<Expr> defaultExpr_result, Option<Type> varargsType_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getIdType() == idType_result && that.getDefaultExpr() == defaultExpr_result && that.getVarargsType() == varargsType_result) return that;
        else return new Param(info_result, name_result, that.getMods(), idType_result, defaultExpr_result, varargsType_result);
    }

    public AbstractNode forDummyExprOnly(DummyExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new DummyExpr(info_result);
    }

    public AbstractNode forAsExprOnly(AsExpr that, ExprInfo info_result, Expr expr_result, Type annType_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result && that.getAnnType() == annType_result) return that;
        else return new AsExpr(info_result, expr_result, annType_result);
    }

    public AbstractNode forAsIfExprOnly(AsIfExpr that, ExprInfo info_result, Expr expr_result, Type annType_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result && that.getAnnType() == annType_result) return that;
        else return new AsIfExpr(info_result, expr_result, annType_result);
    }

    public AbstractNode forAssignmentOnly(Assignment that, ExprInfo info_result, List<Lhs> lhs_result, Option<FunctionalRef> assignOp_result, Expr rhs_result, List<CompoundAssignmentInfo> assignmentInfos_result) {
        if (that.getInfo() == info_result && that.getLhs() == lhs_result && that.getAssignOp() == assignOp_result && that.getRhs() == rhs_result && that.getAssignmentInfos() == assignmentInfos_result) return that;
        else return new Assignment(info_result, lhs_result, assignOp_result, rhs_result, assignmentInfos_result);
    }

    public AbstractNode forBlockOnly(Block that, ExprInfo info_result, Option<Expr> loc_result, List<Expr> exprs_result) {
        if (that.getInfo() == info_result && that.getLoc() == loc_result && that.getExprs() == exprs_result) return that;
        else return new Block(info_result, loc_result, that.isAtomicBlock(), that.isWithinDo(), exprs_result);
    }

    public AbstractNode forDoOnly(Do that, ExprInfo info_result, List<Block> fronts_result) {
        if (that.getInfo() == info_result && that.getFronts() == fronts_result) return that;
        else return new Do(info_result, fronts_result);
    }

    public AbstractNode forCaseExprOnly(CaseExpr that, ExprInfo info_result, Option<Expr> param_result, Option<FunctionalRef> compare_result, FunctionalRef equalsOp_result, FunctionalRef inOp_result, List<CaseClause> clauses_result, Option<Block> elseClause_result) {
        if (that.getInfo() == info_result && that.getParam() == param_result && that.getCompare() == compare_result && that.getEqualsOp() == equalsOp_result && that.getInOp() == inOp_result && that.getClauses() == clauses_result && that.getElseClause() == elseClause_result) return that;
        else return new CaseExpr(info_result, param_result, compare_result, equalsOp_result, inOp_result, clauses_result, elseClause_result);
    }

    public AbstractNode forIfOnly(If that, ExprInfo info_result, List<IfClause> clauses_result, Option<Block> elseClause_result) {
        if (that.getInfo() == info_result && that.getClauses() == clauses_result && that.getElseClause() == elseClause_result) return that;
        else return new If(info_result, clauses_result, elseClause_result);
    }

    public AbstractNode forLabelOnly(Label that, ExprInfo info_result, Id name_result, Block body_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getBody() == body_result) return that;
        else return new Label(info_result, name_result, body_result);
    }

    public AbstractNode forObjectExprOnly(ObjectExpr that, ExprInfo info_result, TraitTypeHeader header_result, Option<SelfType> selfType_result) {
        if (that.getInfo() == info_result && that.getHeader() == header_result && that.getSelfType() == selfType_result) return that;
        else return new ObjectExpr(info_result, header_result, selfType_result);
    }

    public AbstractNode for_RewriteObjectExprOnly(_RewriteObjectExpr that, ExprInfo info_result, TraitTypeHeader header_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getHeader() == header_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new _RewriteObjectExpr(info_result, header_result, that.getImplicitTypeParameters(), that.getGenSymName(), staticArgs_result);
    }

    public AbstractNode forTryOnly(Try that, ExprInfo info_result, Block body_result, Option<Catch> catchClause_result, List<BaseType> forbidClause_result, Option<Block> finallyClause_result) {
        if (that.getInfo() == info_result && that.getBody() == body_result && that.getCatchClause() == catchClause_result && that.getForbidClause() == forbidClause_result && that.getFinallyClause() == finallyClause_result) return that;
        else return new Try(info_result, body_result, catchClause_result, forbidClause_result, finallyClause_result);
    }

    public AbstractNode forTupleExprOnly(TupleExpr that, ExprInfo info_result, List<Expr> exprs_result, Option<Expr> varargs_result, List<KeywordExpr> keywords_result) {
        if (that.getInfo() == info_result && that.getExprs() == exprs_result && that.getVarargs() == varargs_result && that.getKeywords() == keywords_result) return that;
        else return new TupleExpr(info_result, exprs_result, varargs_result, keywords_result, that.isInApp());
    }

    public AbstractNode forTypecaseOnly(Typecase that, ExprInfo info_result, Expr bindExpr_result, List<TypecaseClause> clauses_result, Option<Block> elseClause_result) {
        if (that.getInfo() == info_result && that.getBindExpr() == bindExpr_result && that.getClauses() == clauses_result && that.getElseClause() == elseClause_result) return that;
        else return new Typecase(info_result, bindExpr_result, clauses_result, elseClause_result);
    }

    public AbstractNode forWhileOnly(While that, ExprInfo info_result, GeneratorClause testExpr_result, Do body_result) {
        if (that.getInfo() == info_result && that.getTestExpr() == testExpr_result && that.getBody() == body_result) return that;
        else return new While(info_result, testExpr_result, body_result);
    }

    public AbstractNode forForOnly(For that, ExprInfo info_result, List<GeneratorClause> gens_result, Block body_result) {
        if (that.getInfo() == info_result && that.getGens() == gens_result && that.getBody() == body_result) return that;
        else return new For(info_result, gens_result, body_result);
    }

    public AbstractNode forAccumulatorOnly(Accumulator that, ExprInfo info_result, List<StaticArg> staticArgs_result, Op accOp_result, List<GeneratorClause> gens_result, Expr body_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getAccOp() == accOp_result && that.getGens() == gens_result && that.getBody() == body_result) return that;
        else return new Accumulator(info_result, staticArgs_result, accOp_result, gens_result, body_result);
    }

    public AbstractNode forArrayComprehensionOnly(ArrayComprehension that, ExprInfo info_result, List<StaticArg> staticArgs_result, List<ArrayComprehensionClause> clauses_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getClauses() == clauses_result) return that;
        else return new ArrayComprehension(info_result, staticArgs_result, clauses_result);
    }

    public AbstractNode forAtomicExprOnly(AtomicExpr that, ExprInfo info_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result) return that;
        else return new AtomicExpr(info_result, expr_result);
    }

    public AbstractNode forExitOnly(Exit that, ExprInfo info_result, Option<Id> target_result, Option<Expr> returnExpr_result) {
        if (that.getInfo() == info_result && that.getTarget() == target_result && that.getReturnExpr() == returnExpr_result) return that;
        else return new Exit(info_result, target_result, returnExpr_result);
    }

    public AbstractNode forSpawnOnly(Spawn that, ExprInfo info_result, Expr body_result) {
        if (that.getInfo() == info_result && that.getBody() == body_result) return that;
        else return new Spawn(info_result, body_result);
    }

    public AbstractNode forThrowOnly(Throw that, ExprInfo info_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result) return that;
        else return new Throw(info_result, expr_result);
    }

    public AbstractNode forTryAtomicExprOnly(TryAtomicExpr that, ExprInfo info_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result) return that;
        else return new TryAtomicExpr(info_result, expr_result);
    }

    public AbstractNode forFnExprOnly(FnExpr that, ExprInfo info_result, FnHeader header_result, Expr body_result) {
        if (that.getInfo() == info_result && that.getHeader() == header_result && that.getBody() == body_result) return that;
        else return new FnExpr(info_result, header_result, body_result);
    }

    public AbstractNode forLetFnOnly(LetFn that, ExprInfo info_result, Block body_result, List<FnDecl> fns_result) {
        if (that.getInfo() == info_result && that.getBody() == body_result && that.getFns() == fns_result) return that;
        else return new LetFn(info_result, body_result, fns_result);
    }

    public AbstractNode forLocalVarDeclOnly(LocalVarDecl that, ExprInfo info_result, Block body_result, List<LValue> lhs_result, Option<Expr> rhs_result) {
        if (that.getInfo() == info_result && that.getBody() == body_result && that.getLhs() == lhs_result && that.getRhs() == rhs_result) return that;
        else return new LocalVarDecl(info_result, body_result, lhs_result, rhs_result);
    }

    public AbstractNode forSubscriptExprOnly(SubscriptExpr that, ExprInfo info_result, Expr obj_result, List<Expr> subs_result, Option<Op> op_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getObj() == obj_result && that.getSubs() == subs_result && that.getOp() == op_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new SubscriptExpr(info_result, obj_result, subs_result, op_result, staticArgs_result);
    }

    public AbstractNode forFloatLiteralExprOnly(FloatLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new FloatLiteralExpr(info_result, that.getText(), that.getIntPart(), that.getNumerator(), that.getDenomBase(), that.getDenomPower());
    }

    public AbstractNode forIntLiteralExprOnly(IntLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new IntLiteralExpr(info_result, that.getText(), that.getIntVal());
    }

    public AbstractNode forCharLiteralExprOnly(CharLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new CharLiteralExpr(info_result, that.getText(), that.getCharVal());
    }

    public AbstractNode forStringLiteralExprOnly(StringLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new StringLiteralExpr(info_result, that.getText());
    }

    public AbstractNode forVoidLiteralExprOnly(VoidLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new VoidLiteralExpr(info_result, that.getText());
    }

    public AbstractNode forBooleanLiteralExprOnly(BooleanLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new BooleanLiteralExpr(info_result, that.getText(), that.getBooleanVal());
    }

    public AbstractNode forVarRefOnly(VarRef that, ExprInfo info_result, Id varId_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getVarId() == varId_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new VarRef(info_result, varId_result, staticArgs_result, that.getLexicalDepth());
    }

    public AbstractNode forFieldRefOnly(FieldRef that, ExprInfo info_result, Expr obj_result, Id field_result) {
        if (that.getInfo() == info_result && that.getObj() == obj_result && that.getField() == field_result) return that;
        else return new FieldRef(info_result, obj_result, field_result);
    }

    public AbstractNode forFnRefOnly(FnRef that, ExprInfo info_result, List<StaticArg> staticArgs_result, IdOrOp originalName_result, List<IdOrOp> names_result, List<Overloading> interpOverloadings_result, List<Overloading> newOverloadings_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getOriginalName() == originalName_result && that.getNames() == names_result && that.getInterpOverloadings() == interpOverloadings_result && that.getNewOverloadings() == newOverloadings_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result) return that;
        else return new FnRef(info_result, staticArgs_result, that.getLexicalDepth(), originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public AbstractNode forOpRefOnly(OpRef that, ExprInfo info_result, List<StaticArg> staticArgs_result, IdOrOp originalName_result, List<IdOrOp> names_result, List<Overloading> interpOverloadings_result, List<Overloading> newOverloadings_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getOriginalName() == originalName_result && that.getNames() == names_result && that.getInterpOverloadings() == interpOverloadings_result && that.getNewOverloadings() == newOverloadings_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result) return that;
        else return new OpRef(info_result, staticArgs_result, that.getLexicalDepth(), originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public AbstractNode for_RewriteFnRefOnly(_RewriteFnRef that, ExprInfo info_result, Expr fnExpr_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getFnExpr() == fnExpr_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new _RewriteFnRef(info_result, fnExpr_result, staticArgs_result);
    }

    public AbstractNode for_RewriteObjectExprRefOnly(_RewriteObjectExprRef that, ExprInfo info_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new _RewriteObjectExprRef(info_result, that.getGenSymName(), staticArgs_result);
    }

    public AbstractNode forJuxtOnly(Juxt that, ExprInfo info_result, FunctionalRef multiJuxt_result, FunctionalRef infixJuxt_result, List<Expr> exprs_result) {
        if (that.getInfo() == info_result && that.getMultiJuxt() == multiJuxt_result && that.getInfixJuxt() == infixJuxt_result && that.getExprs() == exprs_result) return that;
        else return new Juxt(info_result, multiJuxt_result, infixJuxt_result, exprs_result, that.isFnApp(), that.isTight());
    }

    public AbstractNode for_RewriteFnAppOnly(_RewriteFnApp that, ExprInfo info_result, Expr function_result, Expr argument_result) {
        if (that.getInfo() == info_result && that.getFunction() == function_result && that.getArgument() == argument_result) return that;
        else return new _RewriteFnApp(info_result, function_result, argument_result);
    }

    public AbstractNode forOpExprOnly(OpExpr that, ExprInfo info_result, FunctionalRef op_result, List<Expr> args_result) {
        if (that.getInfo() == info_result && that.getOp() == op_result && that.getArgs() == args_result) return that;
        else return new OpExpr(info_result, op_result, args_result);
    }

    public AbstractNode forAmbiguousMultifixOpExprOnly(AmbiguousMultifixOpExpr that, ExprInfo info_result, FunctionalRef infix_op_result, FunctionalRef multifix_op_result, List<Expr> args_result) {
        if (that.getInfo() == info_result && that.getInfix_op() == infix_op_result && that.getMultifix_op() == multifix_op_result && that.getArgs() == args_result) return that;
        else return new AmbiguousMultifixOpExpr(info_result, infix_op_result, multifix_op_result, args_result);
    }

    public AbstractNode forChainExprOnly(ChainExpr that, ExprInfo info_result, Expr first_result, List<Link> links_result) {
        if (that.getInfo() == info_result && that.getFirst() == first_result && that.getLinks() == links_result) return that;
        else return new ChainExpr(info_result, first_result, links_result);
    }

    public AbstractNode forTraitCoercionInvocationOnly(TraitCoercionInvocation that, ExprInfo info_result, Expr arg_result, TraitType toType_result, FnRef coercionFn_result) {
        if (that.getInfo() == info_result && that.getArg() == arg_result && that.getToType() == toType_result && that.getCoercionFn() == coercionFn_result) return that;
        else return new TraitCoercionInvocation(info_result, arg_result, toType_result, coercionFn_result);
    }

    public AbstractNode forTupleCoercionInvocationOnly(TupleCoercionInvocation that, ExprInfo info_result, Expr arg_result, TupleType toType_result, List<Option<CoercionInvocation>> subCoercions_result, Option<Option<CoercionInvocation>> varargCoercion_result) {
        if (that.getInfo() == info_result && that.getArg() == arg_result && that.getToType() == toType_result && that.getSubCoercions() == subCoercions_result && that.getVarargCoercion() == varargCoercion_result) return that;
        else return new TupleCoercionInvocation(info_result, arg_result, toType_result, subCoercions_result, varargCoercion_result);
    }

    public AbstractNode forArrowCoercionInvocationOnly(ArrowCoercionInvocation that, ExprInfo info_result, Expr arg_result, ArrowType toType_result, Option<CoercionInvocation> domainCoercion_result, Option<CoercionInvocation> rangeCoercion_result) {
        if (that.getInfo() == info_result && that.getArg() == arg_result && that.getToType() == toType_result && that.getDomainCoercion() == domainCoercion_result && that.getRangeCoercion() == rangeCoercion_result) return that;
        else return new ArrowCoercionInvocation(info_result, arg_result, toType_result, domainCoercion_result, rangeCoercion_result);
    }

    public AbstractNode forUnionCoercionInvocationOnly(UnionCoercionInvocation that, ExprInfo info_result, Type toType_result, Expr arg_result, List<Type> fromTypes_result, List<Option<CoercionInvocation>> fromCoercions_result) {
        if (that.getInfo() == info_result && that.getToType() == toType_result && that.getArg() == arg_result && that.getFromTypes() == fromTypes_result && that.getFromCoercions() == fromCoercions_result) return that;
        else return new UnionCoercionInvocation(info_result, toType_result, arg_result, fromTypes_result, fromCoercions_result);
    }

    public AbstractNode forMethodInvocationOnly(MethodInvocation that, ExprInfo info_result, Expr obj_result, IdOrOp method_result, List<StaticArg> staticArgs_result, Expr arg_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result) {
        if (that.getInfo() == info_result && that.getObj() == obj_result && that.getMethod() == method_result && that.getStaticArgs() == staticArgs_result && that.getArg() == arg_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result) return that;
        else return new MethodInvocation(info_result, obj_result, method_result, staticArgs_result, arg_result, overloadingType_result, overloadingSchema_result);
    }

    public AbstractNode forMathPrimaryOnly(MathPrimary that, ExprInfo info_result, FunctionalRef multiJuxt_result, FunctionalRef infixJuxt_result, Expr front_result, List<MathItem> rest_result) {
        if (that.getInfo() == info_result && that.getMultiJuxt() == multiJuxt_result && that.getInfixJuxt() == infixJuxt_result && that.getFront() == front_result && that.getRest() == rest_result) return that;
        else return new MathPrimary(info_result, multiJuxt_result, infixJuxt_result, front_result, rest_result);
    }

    public AbstractNode forArrayElementOnly(ArrayElement that, ExprInfo info_result, List<StaticArg> staticArgs_result, Expr element_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getElement() == element_result) return that;
        else return new ArrayElement(info_result, staticArgs_result, element_result);
    }

    public AbstractNode forArrayElementsOnly(ArrayElements that, ExprInfo info_result, List<StaticArg> staticArgs_result, List<ArrayExpr> elements_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getElements() == elements_result) return that;
        else return new ArrayElements(info_result, staticArgs_result, that.getDimension(), elements_result, that.isOutermost());
    }

    public AbstractNode forAnyTypeOnly(AnyType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new AnyType(info_result);
    }

    public AbstractNode forBottomTypeOnly(BottomType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new BottomType(info_result);
    }

    public AbstractNode forUnknownTypeOnly(UnknownType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new UnknownType(info_result);
    }

    public AbstractNode forTraitSelfTypeOnly(TraitSelfType that, TypeInfo info_result, BaseType named_result, List<NamedType> comprised_result) {
        if (that.getInfo() == info_result && that.getNamed() == named_result && that.getComprised() == comprised_result) return that;
        else return new TraitSelfType(info_result, named_result, comprised_result);
    }

    public AbstractNode forObjectExprTypeOnly(ObjectExprType that, TypeInfo info_result, List<BaseType> extended_result) {
        if (that.getInfo() == info_result && that.getExtended() == extended_result) return that;
        else return new ObjectExprType(info_result, extended_result);
    }

    public AbstractNode for_InferenceVarTypeOnly(_InferenceVarType that, TypeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new _InferenceVarType(info_result, name_result, that.getId());
    }

    public AbstractNode forVarTypeOnly(VarType that, TypeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new VarType(info_result, name_result, that.getLexicalDepth());
    }

    public AbstractNode forTraitTypeOnly(TraitType that, TypeInfo info_result, Id name_result, List<StaticArg> args_result, List<StaticParam> traitStaticParams_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getArgs() == args_result && that.getTraitStaticParams() == traitStaticParams_result) return that;
        else return new TraitType(info_result, name_result, args_result, traitStaticParams_result);
    }

    public AbstractNode forArrayTypeOnly(ArrayType that, TypeInfo info_result, Type elemType_result, Indices indices_result) {
        if (that.getInfo() == info_result && that.getElemType() == elemType_result && that.getIndices() == indices_result) return that;
        else return new ArrayType(info_result, elemType_result, indices_result);
    }

    public AbstractNode forMatrixTypeOnly(MatrixType that, TypeInfo info_result, Type elemType_result, List<ExtentRange> dimensions_result) {
        if (that.getInfo() == info_result && that.getElemType() == elemType_result && that.getDimensions() == dimensions_result) return that;
        else return new MatrixType(info_result, elemType_result, dimensions_result);
    }

    public AbstractNode forTaggedDimTypeOnly(TaggedDimType that, TypeInfo info_result, Type elemType_result, DimExpr dimExpr_result, Option<Expr> unitExpr_result) {
        if (that.getInfo() == info_result && that.getElemType() == elemType_result && that.getDimExpr() == dimExpr_result && that.getUnitExpr() == unitExpr_result) return that;
        else return new TaggedDimType(info_result, elemType_result, dimExpr_result, unitExpr_result);
    }

    public AbstractNode forTaggedUnitTypeOnly(TaggedUnitType that, TypeInfo info_result, Type elemType_result, Expr unitExpr_result) {
        if (that.getInfo() == info_result && that.getElemType() == elemType_result && that.getUnitExpr() == unitExpr_result) return that;
        else return new TaggedUnitType(info_result, elemType_result, unitExpr_result);
    }

    public AbstractNode forTupleTypeOnly(TupleType that, TypeInfo info_result, List<Type> elements_result, Option<Type> varargs_result, List<KeywordType> keywords_result) {
        if (that.getInfo() == info_result && that.getElements() == elements_result && that.getVarargs() == varargs_result && that.getKeywords() == keywords_result) return that;
        else return new TupleType(info_result, elements_result, varargs_result, keywords_result);
    }

    public AbstractNode forArrowTypeOnly(ArrowType that, TypeInfo info_result, Type domain_result, Type range_result, Effect effect_result, Option<MethodInfo> methodInfo_result) {
        if (that.getInfo() == info_result && that.getDomain() == domain_result && that.getRange() == range_result && that.getEffect() == effect_result && that.getMethodInfo() == methodInfo_result) return that;
        else return new ArrowType(info_result, domain_result, range_result, effect_result, that.isIo(), methodInfo_result);
    }

    public AbstractNode forIntersectionTypeOnly(IntersectionType that, TypeInfo info_result, List<Type> elements_result) {
        if (that.getInfo() == info_result && that.getElements() == elements_result) return that;
        else return new IntersectionType(info_result, elements_result);
    }

    public AbstractNode forUnionTypeOnly(UnionType that, TypeInfo info_result, List<Type> elements_result) {
        if (that.getInfo() == info_result && that.getElements() == elements_result) return that;
        else return new UnionType(info_result, elements_result);
    }

    public AbstractNode forFixedPointTypeOnly(FixedPointType that, TypeInfo info_result, _InferenceVarType name_result, Type body_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getBody() == body_result) return that;
        else return new FixedPointType(info_result, name_result, body_result);
    }

    public AbstractNode forLabelTypeOnly(LabelType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new LabelType(info_result);
    }

    public AbstractNode forDimBaseOnly(DimBase that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new DimBase(info_result);
    }

    public AbstractNode forDimRefOnly(DimRef that, TypeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new DimRef(info_result, name_result);
    }

    public AbstractNode forDimExponentOnly(DimExponent that, TypeInfo info_result, Type base_result, IntExpr power_result) {
        if (that.getInfo() == info_result && that.getBase() == base_result && that.getPower() == power_result) return that;
        else return new DimExponent(info_result, base_result, power_result);
    }

    public AbstractNode forDimUnaryOpOnly(DimUnaryOp that, TypeInfo info_result, DimExpr dimVal_result, Op op_result) {
        if (that.getInfo() == info_result && that.getDimVal() == dimVal_result && that.getOp() == op_result) return that;
        else return new DimUnaryOp(info_result, dimVal_result, op_result);
    }

    public AbstractNode forDimBinaryOpOnly(DimBinaryOp that, TypeInfo info_result, DimExpr left_result, DimExpr right_result, Op op_result) {
        if (that.getInfo() == info_result && that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result) return that;
        else return new DimBinaryOp(info_result, left_result, right_result, op_result);
    }

    public AbstractNode forPatternOnly(Pattern that, ASTNodeInfo info_result, Option<Type> name_result, PatternArgs patterns_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getPatterns() == patterns_result) return that;
        else return new Pattern(info_result, name_result, patterns_result);
    }

    public AbstractNode forPatternArgsOnly(PatternArgs that, ASTNodeInfo info_result, List<PatternBinding> patterns_result) {
        if (that.getInfo() == info_result && that.getPatterns() == patterns_result) return that;
        else return new PatternArgs(info_result, patterns_result);
    }

    public AbstractNode forPlainPatternOnly(PlainPattern that, ASTNodeInfo info_result, Option<Id> field_result, Id name_result, Option<TypeOrPattern> idType_result) {
        if (that.getInfo() == info_result && that.getField() == field_result && that.getName() == name_result && that.getIdType() == idType_result) return that;
        else return new PlainPattern(info_result, field_result, name_result, that.getMods(), idType_result);
    }

    public AbstractNode forTypePatternOnly(TypePattern that, ASTNodeInfo info_result, Option<Id> field_result, Type typ_result) {
        if (that.getInfo() == info_result && that.getField() == field_result && that.getTyp() == typ_result) return that;
        else return new TypePattern(info_result, field_result, typ_result);
    }

    public AbstractNode forNestedPatternOnly(NestedPattern that, ASTNodeInfo info_result, Option<Id> field_result, Pattern pat_result) {
        if (that.getInfo() == info_result && that.getField() == field_result && that.getPat() == pat_result) return that;
        else return new NestedPattern(info_result, field_result, pat_result);
    }

    public AbstractNode forTypeArgOnly(TypeArg that, ASTNodeInfo info_result, Type typeArg_result) {
        if (that.getInfo() == info_result && that.getTypeArg() == typeArg_result) return that;
        else return new TypeArg(info_result, that.isLifted(), typeArg_result);
    }

    public AbstractNode forIntArgOnly(IntArg that, ASTNodeInfo info_result, IntExpr intVal_result) {
        if (that.getInfo() == info_result && that.getIntVal() == intVal_result) return that;
        else return new IntArg(info_result, that.isLifted(), intVal_result);
    }

    public AbstractNode forBoolArgOnly(BoolArg that, ASTNodeInfo info_result, BoolExpr boolArg_result) {
        if (that.getInfo() == info_result && that.getBoolArg() == boolArg_result) return that;
        else return new BoolArg(info_result, that.isLifted(), boolArg_result);
    }

    public AbstractNode forOpArgOnly(OpArg that, ASTNodeInfo info_result, Op id_result) {
        if (that.getInfo() == info_result && that.getId() == id_result) return that;
        else return new OpArg(info_result, that.isLifted(), id_result);
    }

    public AbstractNode forDimArgOnly(DimArg that, ASTNodeInfo info_result, DimExpr dimArg_result) {
        if (that.getInfo() == info_result && that.getDimArg() == dimArg_result) return that;
        else return new DimArg(info_result, that.isLifted(), dimArg_result);
    }

    public AbstractNode forUnitArgOnly(UnitArg that, ASTNodeInfo info_result, UnitExpr unitArg_result) {
        if (that.getInfo() == info_result && that.getUnitArg() == unitArg_result) return that;
        else return new UnitArg(info_result, that.isLifted(), unitArg_result);
    }

    public AbstractNode forIntBaseOnly(IntBase that, ASTNodeInfo info_result, IntLiteralExpr intVal_result) {
        if (that.getInfo() == info_result && that.getIntVal() == intVal_result) return that;
        else return new IntBase(info_result, that.isParenthesized(), intVal_result);
    }

    public AbstractNode forIntRefOnly(IntRef that, ASTNodeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new IntRef(info_result, that.isParenthesized(), name_result, that.getLexicalDepth());
    }

    public AbstractNode forIntBinaryOpOnly(IntBinaryOp that, ASTNodeInfo info_result, IntExpr left_result, IntExpr right_result, Op op_result) {
        if (that.getInfo() == info_result && that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result) return that;
        else return new IntBinaryOp(info_result, that.isParenthesized(), left_result, right_result, op_result);
    }

    public AbstractNode forBoolBaseOnly(BoolBase that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new BoolBase(info_result, that.isParenthesized(), that.isBoolVal());
    }

    public AbstractNode forBoolRefOnly(BoolRef that, ASTNodeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new BoolRef(info_result, that.isParenthesized(), name_result, that.getLexicalDepth());
    }

    public AbstractNode forBoolUnaryOpOnly(BoolUnaryOp that, ASTNodeInfo info_result, BoolExpr boolVal_result, Op op_result) {
        if (that.getInfo() == info_result && that.getBoolVal() == boolVal_result && that.getOp() == op_result) return that;
        else return new BoolUnaryOp(info_result, that.isParenthesized(), boolVal_result, op_result);
    }

    public AbstractNode forBoolBinaryOpOnly(BoolBinaryOp that, ASTNodeInfo info_result, BoolExpr left_result, BoolExpr right_result, Op op_result) {
        if (that.getInfo() == info_result && that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result) return that;
        else return new BoolBinaryOp(info_result, that.isParenthesized(), left_result, right_result, op_result);
    }

    public AbstractNode forUnitRefOnly(UnitRef that, ASTNodeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new UnitRef(info_result, that.isParenthesized(), name_result);
    }

    public AbstractNode forUnitBinaryOpOnly(UnitBinaryOp that, ASTNodeInfo info_result, UnitExpr left_result, UnitExpr right_result, Op op_result) {
        if (that.getInfo() == info_result && that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result) return that;
        else return new UnitBinaryOp(info_result, that.isParenthesized(), left_result, right_result, op_result);
    }

    public AbstractNode forEffectOnly(Effect that, ASTNodeInfo info_result, Option<List<Type>> throwsClause_result) {
        if (that.getInfo() == info_result && that.getThrowsClause() == throwsClause_result) return that;
        else return new Effect(info_result, throwsClause_result, that.isIoEffect());
    }

    public AbstractNode forWhereClauseOnly(WhereClause that, ASTNodeInfo info_result, List<WhereBinding> bindings_result, List<WhereConstraint> constraints_result) {
        if (that.getInfo() == info_result && that.getBindings() == bindings_result && that.getConstraints() == constraints_result) return that;
        else return new WhereClause(info_result, bindings_result, constraints_result);
    }

    public AbstractNode forWhereBindingOnly(WhereBinding that, ASTNodeInfo info_result, Id name_result, List<BaseType> supers_result, StaticParamKind kind_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getSupers() == supers_result && that.getKind() == kind_result) return that;
        else return new WhereBinding(info_result, name_result, supers_result, kind_result);
    }

    public AbstractNode forWhereExtendsOnly(WhereExtends that, ASTNodeInfo info_result, Id name_result, List<BaseType> supers_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getSupers() == supers_result) return that;
        else return new WhereExtends(info_result, name_result, supers_result);
    }

    public AbstractNode forWhereTypeAliasOnly(WhereTypeAlias that, ASTNodeInfo info_result, TypeAlias alias_result) {
        if (that.getInfo() == info_result && that.getAlias() == alias_result) return that;
        else return new WhereTypeAlias(info_result, alias_result);
    }

    public AbstractNode forWhereCoercesOnly(WhereCoerces that, ASTNodeInfo info_result, Type left_result, Type right_result) {
        if (that.getInfo() == info_result && that.getLeft() == left_result && that.getRight() == right_result) return that;
        else return new WhereCoerces(info_result, left_result, right_result, that.isCoerces(), that.isWidens());
    }

    public AbstractNode forWhereEqualsOnly(WhereEquals that, ASTNodeInfo info_result, Id left_result, Id right_result) {
        if (that.getInfo() == info_result && that.getLeft() == left_result && that.getRight() == right_result) return that;
        else return new WhereEquals(info_result, left_result, right_result);
    }

    public AbstractNode forUnitConstraintOnly(UnitConstraint that, ASTNodeInfo info_result, Id name_result) {
        if (that.getInfo() == info_result && that.getName() == name_result) return that;
        else return new UnitConstraint(info_result, name_result);
    }

    public AbstractNode forIntConstraintOnly(IntConstraint that, ASTNodeInfo info_result, IntExpr left_result, IntExpr right_result, Op op_result) {
        if (that.getInfo() == info_result && that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result) return that;
        else return new IntConstraint(info_result, left_result, right_result, op_result);
    }

    public AbstractNode forBoolConstraintExprOnly(BoolConstraintExpr that, ASTNodeInfo info_result, BoolConstraint constraint_result) {
        if (that.getInfo() == info_result && that.getConstraint() == constraint_result) return that;
        else return new BoolConstraintExpr(info_result, constraint_result);
    }

    public AbstractNode forContractOnly(Contract that, ASTNodeInfo info_result, Option<List<Expr>> requiresClause_result, Option<List<EnsuresClause>> ensuresClause_result, Option<List<Expr>> invariantsClause_result) {
        if (that.getInfo() == info_result && that.getRequiresClause() == requiresClause_result && that.getEnsuresClause() == ensuresClause_result && that.getInvariantsClause() == invariantsClause_result) return that;
        else return new Contract(info_result, requiresClause_result, ensuresClause_result, invariantsClause_result);
    }

    public AbstractNode forEnsuresClauseOnly(EnsuresClause that, ASTNodeInfo info_result, Expr post_result, Option<Expr> pre_result) {
        if (that.getInfo() == info_result && that.getPost() == post_result && that.getPre() == pre_result) return that;
        else return new EnsuresClause(info_result, post_result, pre_result);
    }

    public AbstractNode forStaticParamOnly(StaticParam that, ASTNodeInfo info_result, IdOrOp name_result, List<BaseType> extendsClause_result, List<BaseType> dominatesClause_result, Option<Type> dimParam_result, StaticParamKind kind_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getExtendsClause() == extendsClause_result && that.getDominatesClause() == dominatesClause_result && that.getDimParam() == dimParam_result && that.getKind() == kind_result) return that;
        else return new StaticParam(info_result, that.getVariance(), name_result, extendsClause_result, dominatesClause_result, dimParam_result, that.isAbsorbsParam(), kind_result, that.isLifted());
    }

    public AbstractNode forAPINameOnly(APIName that, ASTNodeInfo info_result, List<Id> ids_result) {
        if (that.getInfo() == info_result && that.getIds() == ids_result) return that;
        else return new APIName(info_result, ids_result, that.getText());
    }

    public AbstractNode forIdOnly(Id that, ASTNodeInfo info_result, Option<APIName> apiName_result) {
        if (that.getInfo() == info_result && that.getApiName() == apiName_result) return that;
        else return new Id(info_result, apiName_result, that.getText());
    }

    public AbstractNode forNamedOpOnly(NamedOp that, ASTNodeInfo info_result, Option<APIName> apiName_result, Fixity fixity_result) {
        if (that.getInfo() == info_result && that.getApiName() == apiName_result && that.getFixity() == fixity_result) return that;
        else return new NamedOp(info_result, apiName_result, that.getText(), fixity_result, that.isEnclosing());
    }

    public AbstractNode for_InferenceVarOpOnly(_InferenceVarOp that, ASTNodeInfo info_result, Option<APIName> apiName_result, Fixity fixity_result) {
        if (that.getInfo() == info_result && that.getApiName() == apiName_result && that.getFixity() == fixity_result) return that;
        else return new _InferenceVarOp(info_result, apiName_result, that.getText(), fixity_result, that.isEnclosing(), that.getId());
    }

    public AbstractNode forAnonymousFnNameOnly(AnonymousFnName that, ASTNodeInfo info_result, Option<APIName> apiName_result) {
        if (that.getInfo() == info_result && that.getApiName() == apiName_result) return that;
        else return new AnonymousFnName(info_result, apiName_result);
    }

    public AbstractNode forConstructorFnNameOnly(ConstructorFnName that, ASTNodeInfo info_result, Option<APIName> apiName_result, ObjectConstructor constructor_result) {
        if (that.getInfo() == info_result && that.getApiName() == apiName_result && that.getConstructor() == constructor_result) return that;
        else return new ConstructorFnName(info_result, apiName_result, constructor_result);
    }

    public AbstractNode forArrayComprehensionClauseOnly(ArrayComprehensionClause that, ASTNodeInfo info_result, List<Expr> bind_result, Expr init_result, List<GeneratorClause> gens_result) {
        if (that.getInfo() == info_result && that.getBind() == bind_result && that.getInit() == init_result && that.getGens() == gens_result) return that;
        else return new ArrayComprehensionClause(info_result, bind_result, init_result, gens_result);
    }

    public AbstractNode forKeywordExprOnly(KeywordExpr that, ASTNodeInfo info_result, Id name_result, Expr init_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getInit() == init_result) return that;
        else return new KeywordExpr(info_result, name_result, init_result);
    }

    public AbstractNode forCaseClauseOnly(CaseClause that, ASTNodeInfo info_result, Expr matchClause_result, Block body_result, Option<FunctionalRef> op_result) {
        if (that.getInfo() == info_result && that.getMatchClause() == matchClause_result && that.getBody() == body_result && that.getOp() == op_result) return that;
        else return new CaseClause(info_result, matchClause_result, body_result, op_result);
    }

    public AbstractNode forCatchOnly(Catch that, ASTNodeInfo info_result, Id name_result, List<CatchClause> clauses_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getClauses() == clauses_result) return that;
        else return new Catch(info_result, name_result, clauses_result);
    }

    public AbstractNode forCatchClauseOnly(CatchClause that, ASTNodeInfo info_result, BaseType matchType_result, Block body_result) {
        if (that.getInfo() == info_result && that.getMatchType() == matchType_result && that.getBody() == body_result) return that;
        else return new CatchClause(info_result, matchType_result, body_result);
    }

    public AbstractNode forIfClauseOnly(IfClause that, ASTNodeInfo info_result, GeneratorClause testClause_result, Block body_result) {
        if (that.getInfo() == info_result && that.getTestClause() == testClause_result && that.getBody() == body_result) return that;
        else return new IfClause(info_result, testClause_result, body_result);
    }

    public AbstractNode forTypecaseClauseOnly(TypecaseClause that, ASTNodeInfo info_result, Option<Id> name_result, TypeOrPattern matchType_result, Block body_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getMatchType() == matchType_result && that.getBody() == body_result) return that;
        else return new TypecaseClause(info_result, name_result, matchType_result, body_result);
    }

    public AbstractNode forExtentRangeOnly(ExtentRange that, ASTNodeInfo info_result, Option<StaticArg> base_result, Option<StaticArg> size_result, Option<Op> op_result) {
        if (that.getInfo() == info_result && that.getBase() == base_result && that.getSize() == size_result && that.getOp() == op_result) return that;
        else return new ExtentRange(info_result, base_result, size_result, op_result);
    }

    public AbstractNode forGeneratorClauseOnly(GeneratorClause that, ASTNodeInfo info_result, List<Id> bind_result, Expr init_result) {
        if (that.getInfo() == info_result && that.getBind() == bind_result && that.getInit() == init_result) return that;
        else return new GeneratorClause(info_result, bind_result, init_result);
    }

    public AbstractNode forKeywordTypeOnly(KeywordType that, ASTNodeInfo info_result, Id name_result, Type keywordType_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getKeywordType() == keywordType_result) return that;
        else return new KeywordType(info_result, name_result, keywordType_result);
    }

    public AbstractNode forTraitTypeWhereOnly(TraitTypeWhere that, ASTNodeInfo info_result, BaseType baseType_result, Option<WhereClause> whereClause_result) {
        if (that.getInfo() == info_result && that.getBaseType() == baseType_result && that.getWhereClause() == whereClause_result) return that;
        else return new TraitTypeWhere(info_result, baseType_result, whereClause_result);
    }

    public AbstractNode forIndicesOnly(Indices that, ASTNodeInfo info_result, List<ExtentRange> extents_result) {
        if (that.getInfo() == info_result && that.getExtents() == extents_result) return that;
        else return new Indices(info_result, extents_result);
    }

    public AbstractNode forParenthesisDelimitedMIOnly(ParenthesisDelimitedMI that, ASTNodeInfo info_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result) return that;
        else return new ParenthesisDelimitedMI(info_result, expr_result);
    }

    public AbstractNode forNonParenthesisDelimitedMIOnly(NonParenthesisDelimitedMI that, ASTNodeInfo info_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result) return that;
        else return new NonParenthesisDelimitedMI(info_result, expr_result);
    }

    public AbstractNode forExponentiationMIOnly(ExponentiationMI that, ASTNodeInfo info_result, FunctionalRef op_result, Option<Expr> expr_result) {
        if (that.getInfo() == info_result && that.getOp() == op_result && that.getExpr() == expr_result) return that;
        else return new ExponentiationMI(info_result, op_result, expr_result);
    }

    public AbstractNode forSubscriptingMIOnly(SubscriptingMI that, ASTNodeInfo info_result, Op op_result, List<Expr> exprs_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getOp() == op_result && that.getExprs() == exprs_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new SubscriptingMI(info_result, op_result, exprs_result, staticArgs_result);
    }

    public AbstractNode forOverloadingOnly(Overloading that, ASTNodeInfo info_result, IdOrOp unambiguousName_result, IdOrOp originalName_result, Option<ArrowType> type_result, Option<ArrowType> schema_result) {
        if (that.getInfo() == info_result && that.getUnambiguousName() == unambiguousName_result && that.getOriginalName() == originalName_result && that.getType() == type_result && that.getSchema() == schema_result) return that;
        else return new Overloading(info_result, unambiguousName_result, originalName_result, type_result, schema_result);
    }

    public AbstractNode forNonterminalHeaderOnly(NonterminalHeader that, ASTNodeInfo info_result, Id name_result, List<NonterminalParameter> params_result, List<StaticParam> staticParams_result, Option<Type> paramType_result, Option<WhereClause> whereClause_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getParams() == params_result && that.getStaticParams() == staticParams_result && that.getParamType() == paramType_result && that.getWhereClause() == whereClause_result) return that;
        else return new NonterminalHeader(info_result, that.getMods(), name_result, params_result, staticParams_result, paramType_result, whereClause_result);
    }

    public AbstractNode forNonterminalParameterOnly(NonterminalParameter that, ASTNodeInfo info_result, Id name_result, BaseType paramType_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getParamType() == paramType_result) return that;
        else return new NonterminalParameter(info_result, name_result, paramType_result);
    }

    public AbstractNode forSyntaxDefOnly(SyntaxDef that, ASTNodeInfo info_result, List<SyntaxSymbol> syntaxSymbols_result, TransformerDecl transformer_result) {
        if (that.getInfo() == info_result && that.getSyntaxSymbols() == syntaxSymbols_result && that.getTransformer() == transformer_result) return that;
        else return new SyntaxDef(info_result, that.getModifier(), syntaxSymbols_result, transformer_result);
    }

    public AbstractNode forSuperSyntaxDefOnly(SuperSyntaxDef that, ASTNodeInfo info_result, Id nonterminal_result, Id grammarId_result) {
        if (that.getInfo() == info_result && that.getNonterminal() == nonterminal_result && that.getGrammarId() == grammarId_result) return that;
        else return new SuperSyntaxDef(info_result, that.getModifier(), nonterminal_result, grammarId_result);
    }

    public AbstractNode forPreTransformerDefOnly(PreTransformerDef that, ASTNodeInfo info_result, Transformer transformer_result) {
        if (that.getInfo() == info_result && that.getTransformer() == transformer_result) return that;
        else return new PreTransformerDef(info_result, transformer_result);
    }

    public AbstractNode forNamedTransformerDefOnly(NamedTransformerDef that, ASTNodeInfo info_result, List<NonterminalParameter> parameters_result, Transformer transformer_result) {
        if (that.getInfo() == info_result && that.getParameters() == parameters_result && that.getTransformer() == transformer_result) return that;
        else return new NamedTransformerDef(info_result, that.getName(), parameters_result, transformer_result);
    }

    public AbstractNode forUnparsedTransformerOnly(UnparsedTransformer that, ASTNodeInfo info_result, Id nonterminal_result) {
        if (that.getInfo() == info_result && that.getNonterminal() == nonterminal_result) return that;
        else return new UnparsedTransformer(info_result, that.getTransformer(), nonterminal_result);
    }

    public AbstractNode forNodeTransformerOnly(NodeTransformer that, ASTNodeInfo info_result, AbstractNode node_result) {
        if (that.getInfo() == info_result && that.getNode() == node_result) return that;
        else return new NodeTransformer(info_result, node_result);
    }

    public AbstractNode forCaseTransformerOnly(CaseTransformer that, ASTNodeInfo info_result, Id gapName_result, List<CaseTransformerClause> clauses_result) {
        if (that.getInfo() == info_result && that.getGapName() == gapName_result && that.getClauses() == clauses_result) return that;
        else return new CaseTransformer(info_result, gapName_result, clauses_result);
    }

    public AbstractNode forCaseTransformerClauseOnly(CaseTransformerClause that, ASTNodeInfo info_result, Id constructor_result, List<Id> parameters_result, Transformer body_result) {
        if (that.getInfo() == info_result && that.getConstructor() == constructor_result && that.getParameters() == parameters_result && that.getBody() == body_result) return that;
        else return new CaseTransformerClause(info_result, constructor_result, parameters_result, body_result);
    }

    public AbstractNode forPrefixedSymbolOnly(PrefixedSymbol that, ASTNodeInfo info_result, Id id_result, SyntaxSymbol symbol_result) {
        if (that.getInfo() == info_result && that.getId() == id_result && that.getSymbol() == symbol_result) return that;
        else return new PrefixedSymbol(info_result, id_result, symbol_result);
    }

    public AbstractNode forOptionalSymbolOnly(OptionalSymbol that, ASTNodeInfo info_result, SyntaxSymbol symbol_result) {
        if (that.getInfo() == info_result && that.getSymbol() == symbol_result) return that;
        else return new OptionalSymbol(info_result, symbol_result);
    }

    public AbstractNode forRepeatSymbolOnly(RepeatSymbol that, ASTNodeInfo info_result, SyntaxSymbol symbol_result) {
        if (that.getInfo() == info_result && that.getSymbol() == symbol_result) return that;
        else return new RepeatSymbol(info_result, symbol_result);
    }

    public AbstractNode forRepeatOneOrMoreSymbolOnly(RepeatOneOrMoreSymbol that, ASTNodeInfo info_result, SyntaxSymbol symbol_result) {
        if (that.getInfo() == info_result && that.getSymbol() == symbol_result) return that;
        else return new RepeatOneOrMoreSymbol(info_result, symbol_result);
    }

    public AbstractNode forNoWhitespaceSymbolOnly(NoWhitespaceSymbol that, ASTNodeInfo info_result, SyntaxSymbol symbol_result) {
        if (that.getInfo() == info_result && that.getSymbol() == symbol_result) return that;
        else return new NoWhitespaceSymbol(info_result, symbol_result);
    }

    public AbstractNode forGroupSymbolOnly(GroupSymbol that, ASTNodeInfo info_result, List<SyntaxSymbol> symbols_result) {
        if (that.getInfo() == info_result && that.getSymbols() == symbols_result) return that;
        else return new GroupSymbol(info_result, symbols_result);
    }

    public AbstractNode forAnyCharacterSymbolOnly(AnyCharacterSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new AnyCharacterSymbol(info_result);
    }

    public AbstractNode forWhitespaceSymbolOnly(WhitespaceSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new WhitespaceSymbol(info_result, that.getS());
    }

    public AbstractNode forTabSymbolOnly(TabSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new TabSymbol(info_result);
    }

    public AbstractNode forFormfeedSymbolOnly(FormfeedSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new FormfeedSymbol(info_result);
    }

    public AbstractNode forCarriageReturnSymbolOnly(CarriageReturnSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new CarriageReturnSymbol(info_result);
    }

    public AbstractNode forBackspaceSymbolOnly(BackspaceSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new BackspaceSymbol(info_result);
    }

    public AbstractNode forNewlineSymbolOnly(NewlineSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new NewlineSymbol(info_result);
    }

    public AbstractNode forBreaklineSymbolOnly(BreaklineSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new BreaklineSymbol(info_result, that.getS());
    }

    public AbstractNode forItemSymbolOnly(ItemSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new ItemSymbol(info_result, that.getItem());
    }

    public AbstractNode forNonterminalSymbolOnly(NonterminalSymbol that, ASTNodeInfo info_result, Id nonterminal_result) {
        if (that.getInfo() == info_result && that.getNonterminal() == nonterminal_result) return that;
        else return new NonterminalSymbol(info_result, nonterminal_result);
    }

    public AbstractNode forKeywordSymbolOnly(KeywordSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new KeywordSymbol(info_result, that.getToken());
    }

    public AbstractNode forTokenSymbolOnly(TokenSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new TokenSymbol(info_result, that.getToken());
    }

    public AbstractNode forNotPredicateSymbolOnly(NotPredicateSymbol that, ASTNodeInfo info_result, SyntaxSymbol symbol_result) {
        if (that.getInfo() == info_result && that.getSymbol() == symbol_result) return that;
        else return new NotPredicateSymbol(info_result, symbol_result);
    }

    public AbstractNode forAndPredicateSymbolOnly(AndPredicateSymbol that, ASTNodeInfo info_result, SyntaxSymbol symbol_result) {
        if (that.getInfo() == info_result && that.getSymbol() == symbol_result) return that;
        else return new AndPredicateSymbol(info_result, symbol_result);
    }

    public AbstractNode forCharacterClassSymbolOnly(CharacterClassSymbol that, ASTNodeInfo info_result, List<CharacterSymbol> characters_result) {
        if (that.getInfo() == info_result && that.getCharacters() == characters_result) return that;
        else return new CharacterClassSymbol(info_result, characters_result);
    }

    public AbstractNode forCharSymbolOnly(CharSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new CharSymbol(info_result, that.getString());
    }

    public AbstractNode forCharacterIntervalOnly(CharacterInterval that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new CharacterInterval(info_result, that.getBeginSymbol(), that.getEndSymbol());
    }

    public AbstractNode forLinkOnly(Link that, ASTNodeInfo info_result, FunctionalRef op_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getOp() == op_result && that.getExpr() == expr_result) return that;
        else return new Link(info_result, op_result, expr_result);
    }

    public AbstractNode for_SyntaxTransformationAbstractNodeOnly(_SyntaxTransformationAbstractNode that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAbstractNode(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationCompilationUnitOnly(_SyntaxTransformationCompilationUnit that, APIName name_result, List<Import> imports_result, List<Decl> decls_result, List<APIName> comprises_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getImports() == imports_result && that.getDecls() == decls_result && that.getComprises() == comprises_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCompilationUnit(name_result, imports_result, decls_result, comprises_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationComponentOnly(_SyntaxTransformationComponent that, APIName name_result, List<Import> imports_result, List<Decl> decls_result, List<APIName> comprises_result, List<APIName> exports_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getImports() == imports_result && that.getDecls() == decls_result && that.getComprises() == comprises_result && that.getExports() == exports_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationComponent(name_result, imports_result, decls_result, comprises_result, that.is_native(), exports_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationApiOnly(_SyntaxTransformationApi that, APIName name_result, List<Import> imports_result, List<Decl> decls_result, List<APIName> comprises_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getImports() == imports_result && that.getDecls() == decls_result && that.getComprises() == comprises_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationApi(name_result, imports_result, decls_result, comprises_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationImportOnly(_SyntaxTransformationImport that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationImport(that.getForeignLanguage(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationImportedNamesOnly(_SyntaxTransformationImportedNames that, APIName apiName_result, ASTNodeInfo info_result) {
        if (that.getApiName() == apiName_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationImportedNames(that.getForeignLanguage(), apiName_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationImportStarOnly(_SyntaxTransformationImportStar that, APIName apiName_result, List<IdOrOpOrAnonymousName> exceptNames_result, ASTNodeInfo info_result) {
        if (that.getApiName() == apiName_result && that.getExceptNames() == exceptNames_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationImportStar(that.getForeignLanguage(), apiName_result, exceptNames_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationImportNamesOnly(_SyntaxTransformationImportNames that, APIName apiName_result, List<AliasedSimpleName> aliasedNames_result, ASTNodeInfo info_result) {
        if (that.getApiName() == apiName_result && that.getAliasedNames() == aliasedNames_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationImportNames(that.getForeignLanguage(), apiName_result, aliasedNames_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationImportApiOnly(_SyntaxTransformationImportApi that, List<AliasedAPIName> apis_result, ASTNodeInfo info_result) {
        if (that.getApis() == apis_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationImportApi(that.getForeignLanguage(), apis_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationAliasedSimpleNameOnly(_SyntaxTransformationAliasedSimpleName that, IdOrOpOrAnonymousName name_result, Option<IdOrOpOrAnonymousName> alias_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getAlias() == alias_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAliasedSimpleName(name_result, alias_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationAliasedAPINameOnly(_SyntaxTransformationAliasedAPIName that, APIName apiName_result, Option<Id> alias_result, ASTNodeInfo info_result) {
        if (that.getApiName() == apiName_result && that.getAlias() == alias_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAliasedAPIName(apiName_result, alias_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationDeclOnly(_SyntaxTransformationDecl that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDecl(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTraitObjectDeclOnly(_SyntaxTransformationTraitObjectDecl that, TraitTypeHeader header_result, Option<SelfType> selfType_result, ASTNodeInfo info_result) {
        if (that.getHeader() == header_result && that.getSelfType() == selfType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTraitObjectDecl(header_result, selfType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTraitDeclOnly(_SyntaxTransformationTraitDecl that, TraitTypeHeader header_result, Option<SelfType> selfType_result, List<BaseType> excludesClause_result, Option<List<NamedType>> comprisesClause_result, ASTNodeInfo info_result) {
        if (that.getHeader() == header_result && that.getSelfType() == selfType_result && that.getExcludesClause() == excludesClause_result && that.getComprisesClause() == comprisesClause_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTraitDecl(header_result, selfType_result, excludesClause_result, comprisesClause_result, that.isComprisesEllipses(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationObjectDeclOnly(_SyntaxTransformationObjectDecl that, TraitTypeHeader header_result, Option<SelfType> selfType_result, ASTNodeInfo info_result) {
        if (that.getHeader() == header_result && that.getSelfType() == selfType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationObjectDecl(header_result, selfType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationVarDeclOnly(_SyntaxTransformationVarDecl that, List<LValue> lhs_result, Option<Expr> init_result, ASTNodeInfo info_result) {
        if (that.getLhs() == lhs_result && that.getInit() == init_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationVarDecl(lhs_result, init_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationFnDeclOnly(_SyntaxTransformationFnDecl that, FnHeader header_result, IdOrOp unambiguousName_result, Option<Expr> body_result, Option<IdOrOp> implementsUnambiguousName_result, ASTNodeInfo info_result) {
        if (that.getHeader() == header_result && that.getUnambiguousName() == unambiguousName_result && that.getBody() == body_result && that.getImplementsUnambiguousName() == implementsUnambiguousName_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationFnDecl(header_result, unambiguousName_result, body_result, implementsUnambiguousName_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformation_RewriteFnOverloadDeclOnly(_SyntaxTransformation_RewriteFnOverloadDecl that, IdOrOp name_result, List<IdOrOp> fns_result, Option<Type> type_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getFns() == fns_result && that.getType() == type_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformation_RewriteFnOverloadDecl(name_result, fns_result, type_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformation_RewriteObjectExprDeclOnly(_SyntaxTransformation_RewriteObjectExprDecl that, List<_RewriteObjectExpr> objectExprs_result, ASTNodeInfo info_result) {
        if (that.getObjectExprs() == objectExprs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformation_RewriteObjectExprDecl(objectExprs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformation_RewriteFunctionalMethodDeclOnly(_SyntaxTransformation_RewriteFunctionalMethodDecl that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformation_RewriteFunctionalMethodDecl(that.getFunctionalMethodNames(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationDimUnitDeclOnly(_SyntaxTransformationDimUnitDecl that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDimUnitDecl(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationDimDeclOnly(_SyntaxTransformationDimDecl that, Id dimId_result, Option<Type> derived_result, Option<Id> defaultId_result, ASTNodeInfo info_result) {
        if (that.getDimId() == dimId_result && that.getDerived() == derived_result && that.getDefaultId() == defaultId_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDimDecl(dimId_result, derived_result, defaultId_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationUnitDeclOnly(_SyntaxTransformationUnitDecl that, List<Id> units_result, Option<Type> dimType_result, Option<Expr> defExpr_result, ASTNodeInfo info_result) {
        if (that.getUnits() == units_result && that.getDimType() == dimType_result && that.getDefExpr() == defExpr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationUnitDecl(that.isSi_unit(), units_result, dimType_result, defExpr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTestDeclOnly(_SyntaxTransformationTestDecl that, Id name_result, List<GeneratorClause> gens_result, Expr expr_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getGens() == gens_result && that.getExpr() == expr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTestDecl(name_result, gens_result, expr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationPropertyDeclOnly(_SyntaxTransformationPropertyDecl that, Option<Id> name_result, List<Param> params_result, Expr expr_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getParams() == params_result && that.getExpr() == expr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationPropertyDecl(name_result, params_result, expr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTypeAliasOnly(_SyntaxTransformationTypeAlias that, Id name_result, List<StaticParam> staticParams_result, Type typeDef_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getStaticParams() == staticParams_result && that.getTypeDef() == typeDef_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTypeAlias(name_result, staticParams_result, typeDef_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationGrammarDeclOnly(_SyntaxTransformationGrammarDecl that, Id name_result, List<Id> extendsClause_result, List<GrammarMemberDecl> members_result, List<TransformerDecl> transformers_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getExtendsClause() == extendsClause_result && that.getMembers() == members_result && that.getTransformers() == transformers_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationGrammarDecl(name_result, extendsClause_result, members_result, transformers_result, that.isNativeDef(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationGrammarMemberDeclOnly(_SyntaxTransformationGrammarMemberDecl that, Id name_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationGrammarMemberDecl(name_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNonterminalDeclOnly(_SyntaxTransformationNonterminalDecl that, Id name_result, List<SyntaxDecl> syntaxDecls_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getSyntaxDecls() == syntaxDecls_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNonterminalDecl(name_result, syntaxDecls_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNonterminalDefOnly(_SyntaxTransformationNonterminalDef that, Id name_result, List<SyntaxDecl> syntaxDecls_result, NonterminalHeader header_result, Option<BaseType> astType_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getSyntaxDecls() == syntaxDecls_result && that.getHeader() == header_result && that.getAstType() == astType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNonterminalDef(name_result, syntaxDecls_result, header_result, astType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNonterminalExtensionDefOnly(_SyntaxTransformationNonterminalExtensionDef that, Id name_result, List<SyntaxDecl> syntaxDecls_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getSyntaxDecls() == syntaxDecls_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNonterminalExtensionDef(name_result, syntaxDecls_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBindingOnly(_SyntaxTransformationBinding that, Id name_result, Option<TypeOrPattern> idType_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getIdType() == idType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBinding(name_result, that.getMods(), idType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationLValueOnly(_SyntaxTransformationLValue that, Id name_result, Option<TypeOrPattern> idType_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getIdType() == idType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationLValue(name_result, that.getMods(), idType_result, that.isMutable(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationParamOnly(_SyntaxTransformationParam that, Id name_result, Option<TypeOrPattern> idType_result, Option<Expr> defaultExpr_result, Option<Type> varargsType_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getIdType() == idType_result && that.getDefaultExpr() == defaultExpr_result && that.getVarargsType() == varargsType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationParam(name_result, that.getMods(), idType_result, defaultExpr_result, varargsType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationExprOnly(_SyntaxTransformationExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationExpr(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationDummyExprOnly(_SyntaxTransformationDummyExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDummyExpr(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTypeAnnotatedExprOnly(_SyntaxTransformationTypeAnnotatedExpr that, Expr expr_result, Type annType_result, ExprInfo info_result) {
        if (that.getExpr() == expr_result && that.getAnnType() == annType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTypeAnnotatedExpr(expr_result, annType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationAsExprOnly(_SyntaxTransformationAsExpr that, Expr expr_result, Type annType_result, ExprInfo info_result) {
        if (that.getExpr() == expr_result && that.getAnnType() == annType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAsExpr(expr_result, annType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationAsIfExprOnly(_SyntaxTransformationAsIfExpr that, Expr expr_result, Type annType_result, ExprInfo info_result) {
        if (that.getExpr() == expr_result && that.getAnnType() == annType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAsIfExpr(expr_result, annType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationAssignmentOnly(_SyntaxTransformationAssignment that, List<Lhs> lhs_result, Option<FunctionalRef> assignOp_result, Expr rhs_result, List<CompoundAssignmentInfo> assignmentInfos_result, ExprInfo info_result) {
        if (that.getLhs() == lhs_result && that.getAssignOp() == assignOp_result && that.getRhs() == rhs_result && that.getAssignmentInfos() == assignmentInfos_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAssignment(lhs_result, assignOp_result, rhs_result, assignmentInfos_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBlockOnly(_SyntaxTransformationBlock that, Option<Expr> loc_result, List<Expr> exprs_result, ExprInfo info_result) {
        if (that.getLoc() == loc_result && that.getExprs() == exprs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBlock(loc_result, that.isAtomicBlock(), that.isWithinDo(), exprs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationDoOnly(_SyntaxTransformationDo that, List<Block> fronts_result, ExprInfo info_result) {
        if (that.getFronts() == fronts_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDo(fronts_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationCaseExprOnly(_SyntaxTransformationCaseExpr that, Option<Expr> param_result, Option<FunctionalRef> compare_result, FunctionalRef equalsOp_result, FunctionalRef inOp_result, List<CaseClause> clauses_result, Option<Block> elseClause_result, ExprInfo info_result) {
        if (that.getParam() == param_result && that.getCompare() == compare_result && that.getEqualsOp() == equalsOp_result && that.getInOp() == inOp_result && that.getClauses() == clauses_result && that.getElseClause() == elseClause_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCaseExpr(param_result, compare_result, equalsOp_result, inOp_result, clauses_result, elseClause_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationIfOnly(_SyntaxTransformationIf that, List<IfClause> clauses_result, Option<Block> elseClause_result, ExprInfo info_result) {
        if (that.getClauses() == clauses_result && that.getElseClause() == elseClause_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIf(clauses_result, elseClause_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationLabelOnly(_SyntaxTransformationLabel that, Id name_result, Block body_result, ExprInfo info_result) {
        if (that.getName() == name_result && that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationLabel(name_result, body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationAbstractObjectExprOnly(_SyntaxTransformationAbstractObjectExpr that, TraitTypeHeader header_result, ExprInfo info_result) {
        if (that.getHeader() == header_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAbstractObjectExpr(header_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationObjectExprOnly(_SyntaxTransformationObjectExpr that, TraitTypeHeader header_result, Option<SelfType> selfType_result, ExprInfo info_result) {
        if (that.getHeader() == header_result && that.getSelfType() == selfType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationObjectExpr(header_result, selfType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformation_RewriteObjectExprOnly(_SyntaxTransformation_RewriteObjectExpr that, TraitTypeHeader header_result, List<StaticArg> staticArgs_result, ExprInfo info_result) {
        if (that.getHeader() == header_result && that.getStaticArgs() == staticArgs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformation_RewriteObjectExpr(header_result, that.getImplicitTypeParameters(), that.getGenSymName(), staticArgs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTryOnly(_SyntaxTransformationTry that, Block body_result, Option<Catch> catchClause_result, List<BaseType> forbidClause_result, Option<Block> finallyClause_result, ExprInfo info_result) {
        if (that.getBody() == body_result && that.getCatchClause() == catchClause_result && that.getForbidClause() == forbidClause_result && that.getFinallyClause() == finallyClause_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTry(body_result, catchClause_result, forbidClause_result, finallyClause_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTupleExprOnly(_SyntaxTransformationTupleExpr that, List<Expr> exprs_result, Option<Expr> varargs_result, List<KeywordExpr> keywords_result, ExprInfo info_result) {
        if (that.getExprs() == exprs_result && that.getVarargs() == varargs_result && that.getKeywords() == keywords_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTupleExpr(exprs_result, varargs_result, keywords_result, that.isInApp(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTypecaseOnly(_SyntaxTransformationTypecase that, Expr bindExpr_result, List<TypecaseClause> clauses_result, Option<Block> elseClause_result, ExprInfo info_result) {
        if (that.getBindExpr() == bindExpr_result && that.getClauses() == clauses_result && that.getElseClause() == elseClause_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTypecase(bindExpr_result, clauses_result, elseClause_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationWhileOnly(_SyntaxTransformationWhile that, GeneratorClause testExpr_result, Do body_result, ExprInfo info_result) {
        if (that.getTestExpr() == testExpr_result && that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationWhile(testExpr_result, body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationForOnly(_SyntaxTransformationFor that, List<GeneratorClause> gens_result, Block body_result, ExprInfo info_result) {
        if (that.getGens() == gens_result && that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationFor(gens_result, body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBigOpAppOnly(_SyntaxTransformationBigOpApp that, List<StaticArg> staticArgs_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBigOpApp(staticArgs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationAccumulatorOnly(_SyntaxTransformationAccumulator that, List<StaticArg> staticArgs_result, Op accOp_result, List<GeneratorClause> gens_result, Expr body_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getAccOp() == accOp_result && that.getGens() == gens_result && that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAccumulator(staticArgs_result, accOp_result, gens_result, body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationArrayComprehensionOnly(_SyntaxTransformationArrayComprehension that, List<StaticArg> staticArgs_result, List<ArrayComprehensionClause> clauses_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getClauses() == clauses_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationArrayComprehension(staticArgs_result, clauses_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationAtomicExprOnly(_SyntaxTransformationAtomicExpr that, Expr expr_result, ExprInfo info_result) {
        if (that.getExpr() == expr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAtomicExpr(expr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationExitOnly(_SyntaxTransformationExit that, Option<Id> target_result, Option<Expr> returnExpr_result, ExprInfo info_result) {
        if (that.getTarget() == target_result && that.getReturnExpr() == returnExpr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationExit(target_result, returnExpr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationSpawnOnly(_SyntaxTransformationSpawn that, Expr body_result, ExprInfo info_result) {
        if (that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationSpawn(body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationThrowOnly(_SyntaxTransformationThrow that, Expr expr_result, ExprInfo info_result) {
        if (that.getExpr() == expr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationThrow(expr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTryAtomicExprOnly(_SyntaxTransformationTryAtomicExpr that, Expr expr_result, ExprInfo info_result) {
        if (that.getExpr() == expr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTryAtomicExpr(expr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationFnExprOnly(_SyntaxTransformationFnExpr that, FnHeader header_result, Expr body_result, ExprInfo info_result) {
        if (that.getHeader() == header_result && that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationFnExpr(header_result, body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationLetExprOnly(_SyntaxTransformationLetExpr that, Block body_result, ExprInfo info_result) {
        if (that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationLetExpr(body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationLetFnOnly(_SyntaxTransformationLetFn that, Block body_result, List<FnDecl> fns_result, ExprInfo info_result) {
        if (that.getBody() == body_result && that.getFns() == fns_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationLetFn(body_result, fns_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationLocalVarDeclOnly(_SyntaxTransformationLocalVarDecl that, Block body_result, List<LValue> lhs_result, Option<Expr> rhs_result, ExprInfo info_result) {
        if (that.getBody() == body_result && that.getLhs() == lhs_result && that.getRhs() == rhs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationLocalVarDecl(body_result, lhs_result, rhs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationSimpleExprOnly(_SyntaxTransformationSimpleExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationSimpleExpr(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationSubscriptExprOnly(_SyntaxTransformationSubscriptExpr that, Expr obj_result, List<Expr> subs_result, Option<Op> op_result, List<StaticArg> staticArgs_result, ExprInfo info_result) {
        if (that.getObj() == obj_result && that.getSubs() == subs_result && that.getOp() == op_result && that.getStaticArgs() == staticArgs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationSubscriptExpr(obj_result, subs_result, op_result, staticArgs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationPrimaryOnly(_SyntaxTransformationPrimary that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationPrimary(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationLiteralExprOnly(_SyntaxTransformationLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationLiteralExpr(that.getText(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNumberLiteralExprOnly(_SyntaxTransformationNumberLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNumberLiteralExpr(that.getText(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationFloatLiteralExprOnly(_SyntaxTransformationFloatLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationFloatLiteralExpr(that.getText(), that.getIntPart(), that.getNumerator(), that.getDenomBase(), that.getDenomPower(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationIntLiteralExprOnly(_SyntaxTransformationIntLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIntLiteralExpr(that.getText(), that.getIntVal(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationCharLiteralExprOnly(_SyntaxTransformationCharLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCharLiteralExpr(that.getText(), that.getCharVal(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationStringLiteralExprOnly(_SyntaxTransformationStringLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationStringLiteralExpr(that.getText(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationVoidLiteralExprOnly(_SyntaxTransformationVoidLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationVoidLiteralExpr(that.getText(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBooleanLiteralExprOnly(_SyntaxTransformationBooleanLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBooleanLiteralExpr(that.getText(), that.getBooleanVal(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationVarRefOnly(_SyntaxTransformationVarRef that, Id varId_result, List<StaticArg> staticArgs_result, ExprInfo info_result) {
        if (that.getVarId() == varId_result && that.getStaticArgs() == staticArgs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationVarRef(varId_result, staticArgs_result, that.getLexicalDepth(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationFieldRefOnly(_SyntaxTransformationFieldRef that, Expr obj_result, Id field_result, ExprInfo info_result) {
        if (that.getObj() == obj_result && that.getField() == field_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationFieldRef(obj_result, field_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationFunctionalRefOnly(_SyntaxTransformationFunctionalRef that, List<StaticArg> staticArgs_result, IdOrOp originalName_result, List<IdOrOp> names_result, List<Overloading> interpOverloadings_result, List<Overloading> newOverloadings_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getOriginalName() == originalName_result && that.getNames() == names_result && that.getInterpOverloadings() == interpOverloadings_result && that.getNewOverloadings() == newOverloadings_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationFunctionalRef(staticArgs_result, that.getLexicalDepth(), originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationFnRefOnly(_SyntaxTransformationFnRef that, List<StaticArg> staticArgs_result, IdOrOp originalName_result, List<IdOrOp> names_result, List<Overloading> interpOverloadings_result, List<Overloading> newOverloadings_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getOriginalName() == originalName_result && that.getNames() == names_result && that.getInterpOverloadings() == interpOverloadings_result && that.getNewOverloadings() == newOverloadings_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationFnRef(staticArgs_result, that.getLexicalDepth(), originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationOpRefOnly(_SyntaxTransformationOpRef that, List<StaticArg> staticArgs_result, IdOrOp originalName_result, List<IdOrOp> names_result, List<Overloading> interpOverloadings_result, List<Overloading> newOverloadings_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getOriginalName() == originalName_result && that.getNames() == names_result && that.getInterpOverloadings() == interpOverloadings_result && that.getNewOverloadings() == newOverloadings_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationOpRef(staticArgs_result, that.getLexicalDepth(), originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformation_RewriteFnRefOnly(_SyntaxTransformation_RewriteFnRef that, Expr fnExpr_result, List<StaticArg> staticArgs_result, ExprInfo info_result) {
        if (that.getFnExpr() == fnExpr_result && that.getStaticArgs() == staticArgs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformation_RewriteFnRef(fnExpr_result, staticArgs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformation_RewriteObjectExprRefOnly(_SyntaxTransformation_RewriteObjectExprRef that, List<StaticArg> staticArgs_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformation_RewriteObjectExprRef(that.getGenSymName(), staticArgs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationJuxtOnly(_SyntaxTransformationJuxt that, FunctionalRef multiJuxt_result, FunctionalRef infixJuxt_result, List<Expr> exprs_result, ExprInfo info_result) {
        if (that.getMultiJuxt() == multiJuxt_result && that.getInfixJuxt() == infixJuxt_result && that.getExprs() == exprs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationJuxt(multiJuxt_result, infixJuxt_result, exprs_result, that.isFnApp(), that.isTight(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformation_RewriteFnAppOnly(_SyntaxTransformation_RewriteFnApp that, Expr function_result, Expr argument_result, ExprInfo info_result) {
        if (that.getFunction() == function_result && that.getArgument() == argument_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformation_RewriteFnApp(function_result, argument_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationOpExprOnly(_SyntaxTransformationOpExpr that, FunctionalRef op_result, List<Expr> args_result, ExprInfo info_result) {
        if (that.getOp() == op_result && that.getArgs() == args_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationOpExpr(op_result, args_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationAmbiguousMultifixOpExprOnly(_SyntaxTransformationAmbiguousMultifixOpExpr that, FunctionalRef infix_op_result, FunctionalRef multifix_op_result, List<Expr> args_result, ExprInfo info_result) {
        if (that.getInfix_op() == infix_op_result && that.getMultifix_op() == multifix_op_result && that.getArgs() == args_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAmbiguousMultifixOpExpr(infix_op_result, multifix_op_result, args_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationChainExprOnly(_SyntaxTransformationChainExpr that, Expr first_result, List<Link> links_result, ExprInfo info_result) {
        if (that.getFirst() == first_result && that.getLinks() == links_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationChainExpr(first_result, links_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationCoercionInvocationOnly(_SyntaxTransformationCoercionInvocation that, Type toType_result, Expr arg_result, ExprInfo info_result) {
        if (that.getToType() == toType_result && that.getArg() == arg_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCoercionInvocation(toType_result, arg_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTraitCoercionInvocationOnly(_SyntaxTransformationTraitCoercionInvocation that, Expr arg_result, TraitType toType_result, FnRef coercionFn_result, ExprInfo info_result) {
        if (that.getArg() == arg_result && that.getToType() == toType_result && that.getCoercionFn() == coercionFn_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTraitCoercionInvocation(arg_result, toType_result, coercionFn_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTupleCoercionInvocationOnly(_SyntaxTransformationTupleCoercionInvocation that, Expr arg_result, TupleType toType_result, List<Option<CoercionInvocation>> subCoercions_result, Option<Option<CoercionInvocation>> varargCoercion_result, ExprInfo info_result) {
        if (that.getArg() == arg_result && that.getToType() == toType_result && that.getSubCoercions() == subCoercions_result && that.getVarargCoercion() == varargCoercion_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTupleCoercionInvocation(arg_result, toType_result, subCoercions_result, varargCoercion_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationArrowCoercionInvocationOnly(_SyntaxTransformationArrowCoercionInvocation that, Expr arg_result, ArrowType toType_result, Option<CoercionInvocation> domainCoercion_result, Option<CoercionInvocation> rangeCoercion_result, ExprInfo info_result) {
        if (that.getArg() == arg_result && that.getToType() == toType_result && that.getDomainCoercion() == domainCoercion_result && that.getRangeCoercion() == rangeCoercion_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationArrowCoercionInvocation(arg_result, toType_result, domainCoercion_result, rangeCoercion_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationUnionCoercionInvocationOnly(_SyntaxTransformationUnionCoercionInvocation that, Type toType_result, Expr arg_result, List<Type> fromTypes_result, List<Option<CoercionInvocation>> fromCoercions_result, ExprInfo info_result) {
        if (that.getToType() == toType_result && that.getArg() == arg_result && that.getFromTypes() == fromTypes_result && that.getFromCoercions() == fromCoercions_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationUnionCoercionInvocation(toType_result, arg_result, fromTypes_result, fromCoercions_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationMethodInvocationOnly(_SyntaxTransformationMethodInvocation that, Expr obj_result, IdOrOp method_result, List<StaticArg> staticArgs_result, Expr arg_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result, ExprInfo info_result) {
        if (that.getObj() == obj_result && that.getMethod() == method_result && that.getStaticArgs() == staticArgs_result && that.getArg() == arg_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationMethodInvocation(obj_result, method_result, staticArgs_result, arg_result, overloadingType_result, overloadingSchema_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationMathPrimaryOnly(_SyntaxTransformationMathPrimary that, FunctionalRef multiJuxt_result, FunctionalRef infixJuxt_result, Expr front_result, List<MathItem> rest_result, ExprInfo info_result) {
        if (that.getMultiJuxt() == multiJuxt_result && that.getInfixJuxt() == infixJuxt_result && that.getFront() == front_result && that.getRest() == rest_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationMathPrimary(multiJuxt_result, infixJuxt_result, front_result, rest_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationArrayExprOnly(_SyntaxTransformationArrayExpr that, List<StaticArg> staticArgs_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationArrayExpr(staticArgs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationArrayElementOnly(_SyntaxTransformationArrayElement that, List<StaticArg> staticArgs_result, Expr element_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getElement() == element_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationArrayElement(staticArgs_result, element_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationArrayElementsOnly(_SyntaxTransformationArrayElements that, List<StaticArg> staticArgs_result, List<ArrayExpr> elements_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getElements() == elements_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationArrayElements(staticArgs_result, that.getDimension(), elements_result, that.isOutermost(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTypeOnly(_SyntaxTransformationType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationType(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBaseTypeOnly(_SyntaxTransformationBaseType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBaseType(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationAnyTypeOnly(_SyntaxTransformationAnyType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAnyType(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBottomTypeOnly(_SyntaxTransformationBottomType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBottomType(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationUnknownTypeOnly(_SyntaxTransformationUnknownType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationUnknownType(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationSelfTypeOnly(_SyntaxTransformationSelfType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationSelfType(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTraitSelfTypeOnly(_SyntaxTransformationTraitSelfType that, BaseType named_result, List<NamedType> comprised_result, TypeInfo info_result) {
        if (that.getNamed() == named_result && that.getComprised() == comprised_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTraitSelfType(named_result, comprised_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationObjectExprTypeOnly(_SyntaxTransformationObjectExprType that, List<BaseType> extended_result, TypeInfo info_result) {
        if (that.getExtended() == extended_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationObjectExprType(extended_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNamedTypeOnly(_SyntaxTransformationNamedType that, Id name_result, TypeInfo info_result) {
        if (that.getName() == name_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNamedType(name_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformation_InferenceVarTypeOnly(_SyntaxTransformation_InferenceVarType that, Id name_result, TypeInfo info_result) {
        if (that.getName() == name_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformation_InferenceVarType(name_result, that.getId(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationVarTypeOnly(_SyntaxTransformationVarType that, Id name_result, TypeInfo info_result) {
        if (that.getName() == name_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationVarType(name_result, that.getLexicalDepth(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTraitTypeOnly(_SyntaxTransformationTraitType that, Id name_result, List<StaticArg> args_result, List<StaticParam> traitStaticParams_result, TypeInfo info_result) {
        if (that.getName() == name_result && that.getArgs() == args_result && that.getTraitStaticParams() == traitStaticParams_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTraitType(name_result, args_result, traitStaticParams_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationAbbreviatedTypeOnly(_SyntaxTransformationAbbreviatedType that, Type elemType_result, TypeInfo info_result) {
        if (that.getElemType() == elemType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAbbreviatedType(elemType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationArrayTypeOnly(_SyntaxTransformationArrayType that, Type elemType_result, Indices indices_result, TypeInfo info_result) {
        if (that.getElemType() == elemType_result && that.getIndices() == indices_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationArrayType(elemType_result, indices_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationMatrixTypeOnly(_SyntaxTransformationMatrixType that, Type elemType_result, List<ExtentRange> dimensions_result, TypeInfo info_result) {
        if (that.getElemType() == elemType_result && that.getDimensions() == dimensions_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationMatrixType(elemType_result, dimensions_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTaggedDimTypeOnly(_SyntaxTransformationTaggedDimType that, Type elemType_result, DimExpr dimExpr_result, Option<Expr> unitExpr_result, TypeInfo info_result) {
        if (that.getElemType() == elemType_result && that.getDimExpr() == dimExpr_result && that.getUnitExpr() == unitExpr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTaggedDimType(elemType_result, dimExpr_result, unitExpr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTaggedUnitTypeOnly(_SyntaxTransformationTaggedUnitType that, Type elemType_result, Expr unitExpr_result, TypeInfo info_result) {
        if (that.getElemType() == elemType_result && that.getUnitExpr() == unitExpr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTaggedUnitType(elemType_result, unitExpr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTupleTypeOnly(_SyntaxTransformationTupleType that, List<Type> elements_result, Option<Type> varargs_result, List<KeywordType> keywords_result, TypeInfo info_result) {
        if (that.getElements() == elements_result && that.getVarargs() == varargs_result && that.getKeywords() == keywords_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTupleType(elements_result, varargs_result, keywords_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationArrowTypeOnly(_SyntaxTransformationArrowType that, Type domain_result, Type range_result, Effect effect_result, Option<MethodInfo> methodInfo_result, TypeInfo info_result) {
        if (that.getDomain() == domain_result && that.getRange() == range_result && that.getEffect() == effect_result && that.getMethodInfo() == methodInfo_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationArrowType(domain_result, range_result, effect_result, that.isIo(), methodInfo_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBoundTypeOnly(_SyntaxTransformationBoundType that, List<Type> elements_result, TypeInfo info_result) {
        if (that.getElements() == elements_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBoundType(elements_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationIntersectionTypeOnly(_SyntaxTransformationIntersectionType that, List<Type> elements_result, TypeInfo info_result) {
        if (that.getElements() == elements_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIntersectionType(elements_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationUnionTypeOnly(_SyntaxTransformationUnionType that, List<Type> elements_result, TypeInfo info_result) {
        if (that.getElements() == elements_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationUnionType(elements_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationFixedPointTypeOnly(_SyntaxTransformationFixedPointType that, _InferenceVarType name_result, Type body_result, TypeInfo info_result) {
        if (that.getName() == name_result && that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationFixedPointType(name_result, body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationLabelTypeOnly(_SyntaxTransformationLabelType that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationLabelType(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationDimExprOnly(_SyntaxTransformationDimExpr that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDimExpr(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationDimBaseOnly(_SyntaxTransformationDimBase that, TypeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDimBase(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationDimRefOnly(_SyntaxTransformationDimRef that, Id name_result, TypeInfo info_result) {
        if (that.getName() == name_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDimRef(name_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationDimExponentOnly(_SyntaxTransformationDimExponent that, Type base_result, IntExpr power_result, TypeInfo info_result) {
        if (that.getBase() == base_result && that.getPower() == power_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDimExponent(base_result, power_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationDimUnaryOpOnly(_SyntaxTransformationDimUnaryOp that, DimExpr dimVal_result, Op op_result, TypeInfo info_result) {
        if (that.getDimVal() == dimVal_result && that.getOp() == op_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDimUnaryOp(dimVal_result, op_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationDimBinaryOpOnly(_SyntaxTransformationDimBinaryOp that, DimExpr left_result, DimExpr right_result, Op op_result, TypeInfo info_result) {
        if (that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDimBinaryOp(left_result, right_result, op_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationPatternOnly(_SyntaxTransformationPattern that, Option<Type> name_result, PatternArgs patterns_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getPatterns() == patterns_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationPattern(name_result, patterns_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationPatternArgsOnly(_SyntaxTransformationPatternArgs that, List<PatternBinding> patterns_result, ASTNodeInfo info_result) {
        if (that.getPatterns() == patterns_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationPatternArgs(patterns_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationPatternBindingOnly(_SyntaxTransformationPatternBinding that, Option<Id> field_result, ASTNodeInfo info_result) {
        if (that.getField() == field_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationPatternBinding(field_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationPlainPatternOnly(_SyntaxTransformationPlainPattern that, Option<Id> field_result, Id name_result, Option<TypeOrPattern> idType_result, ASTNodeInfo info_result) {
        if (that.getField() == field_result && that.getName() == name_result && that.getIdType() == idType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationPlainPattern(field_result, name_result, that.getMods(), idType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTypePatternOnly(_SyntaxTransformationTypePattern that, Option<Id> field_result, Type typ_result, ASTNodeInfo info_result) {
        if (that.getField() == field_result && that.getTyp() == typ_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTypePattern(field_result, typ_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNestedPatternOnly(_SyntaxTransformationNestedPattern that, Option<Id> field_result, Pattern pat_result, ASTNodeInfo info_result) {
        if (that.getField() == field_result && that.getPat() == pat_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNestedPattern(field_result, pat_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationStaticArgOnly(_SyntaxTransformationStaticArg that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationStaticArg(that.isLifted(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTypeArgOnly(_SyntaxTransformationTypeArg that, Type typeArg_result, ASTNodeInfo info_result) {
        if (that.getTypeArg() == typeArg_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTypeArg(that.isLifted(), typeArg_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationIntArgOnly(_SyntaxTransformationIntArg that, IntExpr intVal_result, ASTNodeInfo info_result) {
        if (that.getIntVal() == intVal_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIntArg(that.isLifted(), intVal_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBoolArgOnly(_SyntaxTransformationBoolArg that, BoolExpr boolArg_result, ASTNodeInfo info_result) {
        if (that.getBoolArg() == boolArg_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBoolArg(that.isLifted(), boolArg_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationOpArgOnly(_SyntaxTransformationOpArg that, Op id_result, ASTNodeInfo info_result) {
        if (that.getId() == id_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationOpArg(that.isLifted(), id_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationDimArgOnly(_SyntaxTransformationDimArg that, DimExpr dimArg_result, ASTNodeInfo info_result) {
        if (that.getDimArg() == dimArg_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDimArg(that.isLifted(), dimArg_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationUnitArgOnly(_SyntaxTransformationUnitArg that, UnitExpr unitArg_result, ASTNodeInfo info_result) {
        if (that.getUnitArg() == unitArg_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationUnitArg(that.isLifted(), unitArg_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationStaticExprOnly(_SyntaxTransformationStaticExpr that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationStaticExpr(that.isParenthesized(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationIntExprOnly(_SyntaxTransformationIntExpr that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIntExpr(that.isParenthesized(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationIntBaseOnly(_SyntaxTransformationIntBase that, IntLiteralExpr intVal_result, ASTNodeInfo info_result) {
        if (that.getIntVal() == intVal_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIntBase(that.isParenthesized(), intVal_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationIntRefOnly(_SyntaxTransformationIntRef that, Id name_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIntRef(that.isParenthesized(), name_result, that.getLexicalDepth(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationIntBinaryOpOnly(_SyntaxTransformationIntBinaryOp that, IntExpr left_result, IntExpr right_result, Op op_result, ASTNodeInfo info_result) {
        if (that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIntBinaryOp(that.isParenthesized(), left_result, right_result, op_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBoolExprOnly(_SyntaxTransformationBoolExpr that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBoolExpr(that.isParenthesized(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBoolBaseOnly(_SyntaxTransformationBoolBase that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBoolBase(that.isParenthesized(), that.isBoolVal(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBoolRefOnly(_SyntaxTransformationBoolRef that, Id name_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBoolRef(that.isParenthesized(), name_result, that.getLexicalDepth(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBoolConstraintOnly(_SyntaxTransformationBoolConstraint that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBoolConstraint(that.isParenthesized(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBoolUnaryOpOnly(_SyntaxTransformationBoolUnaryOp that, BoolExpr boolVal_result, Op op_result, ASTNodeInfo info_result) {
        if (that.getBoolVal() == boolVal_result && that.getOp() == op_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBoolUnaryOp(that.isParenthesized(), boolVal_result, op_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBoolBinaryOpOnly(_SyntaxTransformationBoolBinaryOp that, BoolExpr left_result, BoolExpr right_result, Op op_result, ASTNodeInfo info_result) {
        if (that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBoolBinaryOp(that.isParenthesized(), left_result, right_result, op_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationUnitExprOnly(_SyntaxTransformationUnitExpr that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationUnitExpr(that.isParenthesized(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationUnitRefOnly(_SyntaxTransformationUnitRef that, Id name_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationUnitRef(that.isParenthesized(), name_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationUnitBinaryOpOnly(_SyntaxTransformationUnitBinaryOp that, UnitExpr left_result, UnitExpr right_result, Op op_result, ASTNodeInfo info_result) {
        if (that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationUnitBinaryOp(that.isParenthesized(), left_result, right_result, op_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationEffectOnly(_SyntaxTransformationEffect that, Option<List<Type>> throwsClause_result, ASTNodeInfo info_result) {
        if (that.getThrowsClause() == throwsClause_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationEffect(throwsClause_result, that.isIoEffect(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationWhereClauseOnly(_SyntaxTransformationWhereClause that, List<WhereBinding> bindings_result, List<WhereConstraint> constraints_result, ASTNodeInfo info_result) {
        if (that.getBindings() == bindings_result && that.getConstraints() == constraints_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationWhereClause(bindings_result, constraints_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationWhereBindingOnly(_SyntaxTransformationWhereBinding that, Id name_result, List<BaseType> supers_result, StaticParamKind kind_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getSupers() == supers_result && that.getKind() == kind_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationWhereBinding(name_result, supers_result, kind_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationWhereConstraintOnly(_SyntaxTransformationWhereConstraint that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationWhereConstraint(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationWhereExtendsOnly(_SyntaxTransformationWhereExtends that, Id name_result, List<BaseType> supers_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getSupers() == supers_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationWhereExtends(name_result, supers_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationWhereTypeAliasOnly(_SyntaxTransformationWhereTypeAlias that, TypeAlias alias_result, ASTNodeInfo info_result) {
        if (that.getAlias() == alias_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationWhereTypeAlias(alias_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationWhereCoercesOnly(_SyntaxTransformationWhereCoerces that, Type left_result, Type right_result, ASTNodeInfo info_result) {
        if (that.getLeft() == left_result && that.getRight() == right_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationWhereCoerces(left_result, right_result, that.isCoerces(), that.isWidens(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationWhereEqualsOnly(_SyntaxTransformationWhereEquals that, Id left_result, Id right_result, ASTNodeInfo info_result) {
        if (that.getLeft() == left_result && that.getRight() == right_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationWhereEquals(left_result, right_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationUnitConstraintOnly(_SyntaxTransformationUnitConstraint that, Id name_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationUnitConstraint(name_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationIntConstraintOnly(_SyntaxTransformationIntConstraint that, IntExpr left_result, IntExpr right_result, Op op_result, ASTNodeInfo info_result) {
        if (that.getLeft() == left_result && that.getRight() == right_result && that.getOp() == op_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIntConstraint(left_result, right_result, op_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBoolConstraintExprOnly(_SyntaxTransformationBoolConstraintExpr that, BoolConstraint constraint_result, ASTNodeInfo info_result) {
        if (that.getConstraint() == constraint_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBoolConstraintExpr(constraint_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationContractOnly(_SyntaxTransformationContract that, Option<List<Expr>> requiresClause_result, Option<List<EnsuresClause>> ensuresClause_result, Option<List<Expr>> invariantsClause_result, ASTNodeInfo info_result) {
        if (that.getRequiresClause() == requiresClause_result && that.getEnsuresClause() == ensuresClause_result && that.getInvariantsClause() == invariantsClause_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationContract(requiresClause_result, ensuresClause_result, invariantsClause_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationEnsuresClauseOnly(_SyntaxTransformationEnsuresClause that, Expr post_result, Option<Expr> pre_result, ASTNodeInfo info_result) {
        if (that.getPost() == post_result && that.getPre() == pre_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationEnsuresClause(post_result, pre_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationStaticParamOnly(_SyntaxTransformationStaticParam that, IdOrOp name_result, List<BaseType> extendsClause_result, List<BaseType> dominatesClause_result, Option<Type> dimParam_result, StaticParamKind kind_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getExtendsClause() == extendsClause_result && that.getDominatesClause() == dominatesClause_result && that.getDimParam() == dimParam_result && that.getKind() == kind_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationStaticParam(that.getVariance(), name_result, extendsClause_result, dominatesClause_result, dimParam_result, that.isAbsorbsParam(), kind_result, that.isLifted(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNameOnly(_SyntaxTransformationName that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationName(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationAPINameOnly(_SyntaxTransformationAPIName that, List<Id> ids_result, ASTNodeInfo info_result) {
        if (that.getIds() == ids_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAPIName(ids_result, that.getText(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationIdOrOpOrAnonymousNameOnly(_SyntaxTransformationIdOrOpOrAnonymousName that, Option<APIName> apiName_result, ASTNodeInfo info_result) {
        if (that.getApiName() == apiName_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIdOrOpOrAnonymousName(apiName_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationIdOrOpOnly(_SyntaxTransformationIdOrOp that, Option<APIName> apiName_result, ASTNodeInfo info_result) {
        if (that.getApiName() == apiName_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIdOrOp(apiName_result, that.getText(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationIdOnly(_SyntaxTransformationId that, Option<APIName> apiName_result, ASTNodeInfo info_result) {
        if (that.getApiName() == apiName_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationId(apiName_result, that.getText(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationOpOnly(_SyntaxTransformationOp that, Option<APIName> apiName_result, Fixity fixity_result, ASTNodeInfo info_result) {
        if (that.getApiName() == apiName_result && that.getFixity() == fixity_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationOp(apiName_result, that.getText(), fixity_result, that.isEnclosing(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNamedOpOnly(_SyntaxTransformationNamedOp that, Option<APIName> apiName_result, Fixity fixity_result, ASTNodeInfo info_result) {
        if (that.getApiName() == apiName_result && that.getFixity() == fixity_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNamedOp(apiName_result, that.getText(), fixity_result, that.isEnclosing(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformation_InferenceVarOpOnly(_SyntaxTransformation_InferenceVarOp that, Option<APIName> apiName_result, Fixity fixity_result, ASTNodeInfo info_result) {
        if (that.getApiName() == apiName_result && that.getFixity() == fixity_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformation_InferenceVarOp(apiName_result, that.getText(), fixity_result, that.isEnclosing(), that.getId(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationAnonymousNameOnly(_SyntaxTransformationAnonymousName that, Option<APIName> apiName_result, ASTNodeInfo info_result) {
        if (that.getApiName() == apiName_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAnonymousName(apiName_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationAnonymousFnNameOnly(_SyntaxTransformationAnonymousFnName that, Option<APIName> apiName_result, ASTNodeInfo info_result) {
        if (that.getApiName() == apiName_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAnonymousFnName(apiName_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationConstructorFnNameOnly(_SyntaxTransformationConstructorFnName that, Option<APIName> apiName_result, ObjectConstructor constructor_result, ASTNodeInfo info_result) {
        if (that.getApiName() == apiName_result && that.getConstructor() == constructor_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationConstructorFnName(apiName_result, constructor_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationArrayComprehensionClauseOnly(_SyntaxTransformationArrayComprehensionClause that, List<Expr> bind_result, Expr init_result, List<GeneratorClause> gens_result, ASTNodeInfo info_result) {
        if (that.getBind() == bind_result && that.getInit() == init_result && that.getGens() == gens_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationArrayComprehensionClause(bind_result, init_result, gens_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationKeywordExprOnly(_SyntaxTransformationKeywordExpr that, Id name_result, Expr init_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getInit() == init_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationKeywordExpr(name_result, init_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationCaseClauseOnly(_SyntaxTransformationCaseClause that, Expr matchClause_result, Block body_result, Option<FunctionalRef> op_result, ASTNodeInfo info_result) {
        if (that.getMatchClause() == matchClause_result && that.getBody() == body_result && that.getOp() == op_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCaseClause(matchClause_result, body_result, op_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationCatchOnly(_SyntaxTransformationCatch that, Id name_result, List<CatchClause> clauses_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getClauses() == clauses_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCatch(name_result, clauses_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationCatchClauseOnly(_SyntaxTransformationCatchClause that, BaseType matchType_result, Block body_result, ASTNodeInfo info_result) {
        if (that.getMatchType() == matchType_result && that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCatchClause(matchType_result, body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationIfClauseOnly(_SyntaxTransformationIfClause that, GeneratorClause testClause_result, Block body_result, ASTNodeInfo info_result) {
        if (that.getTestClause() == testClause_result && that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIfClause(testClause_result, body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTypecaseClauseOnly(_SyntaxTransformationTypecaseClause that, Option<Id> name_result, TypeOrPattern matchType_result, Block body_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getMatchType() == matchType_result && that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTypecaseClause(name_result, matchType_result, body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationExtentRangeOnly(_SyntaxTransformationExtentRange that, Option<StaticArg> base_result, Option<StaticArg> size_result, Option<Op> op_result, ASTNodeInfo info_result) {
        if (that.getBase() == base_result && that.getSize() == size_result && that.getOp() == op_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationExtentRange(base_result, size_result, op_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationGeneratorClauseOnly(_SyntaxTransformationGeneratorClause that, List<Id> bind_result, Expr init_result, ASTNodeInfo info_result) {
        if (that.getBind() == bind_result && that.getInit() == init_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationGeneratorClause(bind_result, init_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationKeywordTypeOnly(_SyntaxTransformationKeywordType that, Id name_result, Type keywordType_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getKeywordType() == keywordType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationKeywordType(name_result, keywordType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTraitTypeWhereOnly(_SyntaxTransformationTraitTypeWhere that, BaseType baseType_result, Option<WhereClause> whereClause_result, ASTNodeInfo info_result) {
        if (that.getBaseType() == baseType_result && that.getWhereClause() == whereClause_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTraitTypeWhere(baseType_result, whereClause_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationIndicesOnly(_SyntaxTransformationIndices that, List<ExtentRange> extents_result, ASTNodeInfo info_result) {
        if (that.getExtents() == extents_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIndices(extents_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationMathItemOnly(_SyntaxTransformationMathItem that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationMathItem(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationExprMIOnly(_SyntaxTransformationExprMI that, Expr expr_result, ASTNodeInfo info_result) {
        if (that.getExpr() == expr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationExprMI(expr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationParenthesisDelimitedMIOnly(_SyntaxTransformationParenthesisDelimitedMI that, Expr expr_result, ASTNodeInfo info_result) {
        if (that.getExpr() == expr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationParenthesisDelimitedMI(expr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNonParenthesisDelimitedMIOnly(_SyntaxTransformationNonParenthesisDelimitedMI that, Expr expr_result, ASTNodeInfo info_result) {
        if (that.getExpr() == expr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNonParenthesisDelimitedMI(expr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNonExprMIOnly(_SyntaxTransformationNonExprMI that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNonExprMI(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationExponentiationMIOnly(_SyntaxTransformationExponentiationMI that, FunctionalRef op_result, Option<Expr> expr_result, ASTNodeInfo info_result) {
        if (that.getOp() == op_result && that.getExpr() == expr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationExponentiationMI(op_result, expr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationSubscriptingMIOnly(_SyntaxTransformationSubscriptingMI that, Op op_result, List<Expr> exprs_result, List<StaticArg> staticArgs_result, ASTNodeInfo info_result) {
        if (that.getOp() == op_result && that.getExprs() == exprs_result && that.getStaticArgs() == staticArgs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationSubscriptingMI(op_result, exprs_result, staticArgs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationOverloadingOnly(_SyntaxTransformationOverloading that, IdOrOp unambiguousName_result, IdOrOp originalName_result, Option<ArrowType> type_result, Option<ArrowType> schema_result, ASTNodeInfo info_result) {
        if (that.getUnambiguousName() == unambiguousName_result && that.getOriginalName() == originalName_result && that.getType() == type_result && that.getSchema() == schema_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationOverloading(unambiguousName_result, originalName_result, type_result, schema_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNonterminalHeaderOnly(_SyntaxTransformationNonterminalHeader that, Id name_result, List<NonterminalParameter> params_result, List<StaticParam> staticParams_result, Option<Type> paramType_result, Option<WhereClause> whereClause_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getParams() == params_result && that.getStaticParams() == staticParams_result && that.getParamType() == paramType_result && that.getWhereClause() == whereClause_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNonterminalHeader(that.getMods(), name_result, params_result, staticParams_result, paramType_result, whereClause_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNonterminalParameterOnly(_SyntaxTransformationNonterminalParameter that, Id name_result, BaseType paramType_result, ASTNodeInfo info_result) {
        if (that.getName() == name_result && that.getParamType() == paramType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNonterminalParameter(name_result, paramType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationSyntaxDeclOnly(_SyntaxTransformationSyntaxDecl that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationSyntaxDecl(that.getModifier(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationSyntaxDefOnly(_SyntaxTransformationSyntaxDef that, List<SyntaxSymbol> syntaxSymbols_result, TransformerDecl transformer_result, ASTNodeInfo info_result) {
        if (that.getSyntaxSymbols() == syntaxSymbols_result && that.getTransformer() == transformer_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationSyntaxDef(that.getModifier(), syntaxSymbols_result, transformer_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationSuperSyntaxDefOnly(_SyntaxTransformationSuperSyntaxDef that, Id nonterminal_result, Id grammarId_result, ASTNodeInfo info_result) {
        if (that.getNonterminal() == nonterminal_result && that.getGrammarId() == grammarId_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationSuperSyntaxDef(that.getModifier(), nonterminal_result, grammarId_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTransformerDeclOnly(_SyntaxTransformationTransformerDecl that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTransformerDecl(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationPreTransformerDefOnly(_SyntaxTransformationPreTransformerDef that, Transformer transformer_result, ASTNodeInfo info_result) {
        if (that.getTransformer() == transformer_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationPreTransformerDef(transformer_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNamedTransformerDefOnly(_SyntaxTransformationNamedTransformerDef that, List<NonterminalParameter> parameters_result, Transformer transformer_result, ASTNodeInfo info_result) {
        if (that.getParameters() == parameters_result && that.getTransformer() == transformer_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNamedTransformerDef(that.getName(), parameters_result, transformer_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTransformerOnly(_SyntaxTransformationTransformer that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTransformer(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationUnparsedTransformerOnly(_SyntaxTransformationUnparsedTransformer that, Id nonterminal_result, ASTNodeInfo info_result) {
        if (that.getNonterminal() == nonterminal_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationUnparsedTransformer(that.getTransformer(), nonterminal_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNodeTransformerOnly(_SyntaxTransformationNodeTransformer that, AbstractNode node_result, ASTNodeInfo info_result) {
        if (that.getNode() == node_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNodeTransformer(node_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationCaseTransformerOnly(_SyntaxTransformationCaseTransformer that, Id gapName_result, List<CaseTransformerClause> clauses_result, ASTNodeInfo info_result) {
        if (that.getGapName() == gapName_result && that.getClauses() == clauses_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCaseTransformer(gapName_result, clauses_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationCaseTransformerClauseOnly(_SyntaxTransformationCaseTransformerClause that, Id constructor_result, List<Id> parameters_result, Transformer body_result, ASTNodeInfo info_result) {
        if (that.getConstructor() == constructor_result && that.getParameters() == parameters_result && that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCaseTransformerClause(constructor_result, parameters_result, body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationSyntaxSymbolOnly(_SyntaxTransformationSyntaxSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationSyntaxSymbol(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationPrefixedSymbolOnly(_SyntaxTransformationPrefixedSymbol that, Id id_result, SyntaxSymbol symbol_result, ASTNodeInfo info_result) {
        if (that.getId() == id_result && that.getSymbol() == symbol_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationPrefixedSymbol(id_result, symbol_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationOptionalSymbolOnly(_SyntaxTransformationOptionalSymbol that, SyntaxSymbol symbol_result, ASTNodeInfo info_result) {
        if (that.getSymbol() == symbol_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationOptionalSymbol(symbol_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationRepeatSymbolOnly(_SyntaxTransformationRepeatSymbol that, SyntaxSymbol symbol_result, ASTNodeInfo info_result) {
        if (that.getSymbol() == symbol_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationRepeatSymbol(symbol_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationRepeatOneOrMoreSymbolOnly(_SyntaxTransformationRepeatOneOrMoreSymbol that, SyntaxSymbol symbol_result, ASTNodeInfo info_result) {
        if (that.getSymbol() == symbol_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationRepeatOneOrMoreSymbol(symbol_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNoWhitespaceSymbolOnly(_SyntaxTransformationNoWhitespaceSymbol that, SyntaxSymbol symbol_result, ASTNodeInfo info_result) {
        if (that.getSymbol() == symbol_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNoWhitespaceSymbol(symbol_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationGroupSymbolOnly(_SyntaxTransformationGroupSymbol that, List<SyntaxSymbol> symbols_result, ASTNodeInfo info_result) {
        if (that.getSymbols() == symbols_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationGroupSymbol(symbols_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationSpecialSymbolOnly(_SyntaxTransformationSpecialSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationSpecialSymbol(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationAnyCharacterSymbolOnly(_SyntaxTransformationAnyCharacterSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAnyCharacterSymbol(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationWhitespaceSymbolOnly(_SyntaxTransformationWhitespaceSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationWhitespaceSymbol(that.getS(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTabSymbolOnly(_SyntaxTransformationTabSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTabSymbol(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationFormfeedSymbolOnly(_SyntaxTransformationFormfeedSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationFormfeedSymbol(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationCarriageReturnSymbolOnly(_SyntaxTransformationCarriageReturnSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCarriageReturnSymbol(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBackspaceSymbolOnly(_SyntaxTransformationBackspaceSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBackspaceSymbol(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNewlineSymbolOnly(_SyntaxTransformationNewlineSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNewlineSymbol(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationBreaklineSymbolOnly(_SyntaxTransformationBreaklineSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBreaklineSymbol(that.getS(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationItemSymbolOnly(_SyntaxTransformationItemSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationItemSymbol(that.getItem(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNonterminalSymbolOnly(_SyntaxTransformationNonterminalSymbol that, Id nonterminal_result, ASTNodeInfo info_result) {
        if (that.getNonterminal() == nonterminal_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNonterminalSymbol(nonterminal_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationKeywordSymbolOnly(_SyntaxTransformationKeywordSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationKeywordSymbol(that.getToken(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationTokenSymbolOnly(_SyntaxTransformationTokenSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTokenSymbol(that.getToken(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationNotPredicateSymbolOnly(_SyntaxTransformationNotPredicateSymbol that, SyntaxSymbol symbol_result, ASTNodeInfo info_result) {
        if (that.getSymbol() == symbol_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNotPredicateSymbol(symbol_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationAndPredicateSymbolOnly(_SyntaxTransformationAndPredicateSymbol that, SyntaxSymbol symbol_result, ASTNodeInfo info_result) {
        if (that.getSymbol() == symbol_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAndPredicateSymbol(symbol_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationCharacterClassSymbolOnly(_SyntaxTransformationCharacterClassSymbol that, List<CharacterSymbol> characters_result, ASTNodeInfo info_result) {
        if (that.getCharacters() == characters_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCharacterClassSymbol(characters_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationCharacterSymbolOnly(_SyntaxTransformationCharacterSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCharacterSymbol(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationCharSymbolOnly(_SyntaxTransformationCharSymbol that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCharSymbol(that.getString(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationCharacterIntervalOnly(_SyntaxTransformationCharacterInterval that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCharacterInterval(that.getBeginSymbol(), that.getEndSymbol(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_SyntaxTransformationLinkOnly(_SyntaxTransformationLink that, FunctionalRef op_result, Expr expr_result, ASTNodeInfo info_result) {
        if (that.getOp() == op_result && that.getExpr() == expr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationLink(op_result, expr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public AbstractNode for_EllipsesAbstractNodeOnly(_EllipsesAbstractNode that) {
        return that;
    }

    public AbstractNode for_EllipsesCompilationUnitOnly(_EllipsesCompilationUnit that) {
        return that;
    }

    public AbstractNode for_EllipsesComponentOnly(_EllipsesComponent that) {
        return that;
    }

    public AbstractNode for_EllipsesApiOnly(_EllipsesApi that) {
        return that;
    }

    public AbstractNode for_EllipsesImportOnly(_EllipsesImport that) {
        return that;
    }

    public AbstractNode for_EllipsesImportedNamesOnly(_EllipsesImportedNames that) {
        return that;
    }

    public AbstractNode for_EllipsesImportStarOnly(_EllipsesImportStar that) {
        return that;
    }

    public AbstractNode for_EllipsesImportNamesOnly(_EllipsesImportNames that) {
        return that;
    }

    public AbstractNode for_EllipsesImportApiOnly(_EllipsesImportApi that) {
        return that;
    }

    public AbstractNode for_EllipsesAliasedSimpleNameOnly(_EllipsesAliasedSimpleName that) {
        return that;
    }

    public AbstractNode for_EllipsesAliasedAPINameOnly(_EllipsesAliasedAPIName that) {
        return that;
    }

    public AbstractNode for_EllipsesDeclOnly(_EllipsesDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesTraitObjectDeclOnly(_EllipsesTraitObjectDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesTraitDeclOnly(_EllipsesTraitDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesObjectDeclOnly(_EllipsesObjectDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesVarDeclOnly(_EllipsesVarDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesFnDeclOnly(_EllipsesFnDecl that) {
        return that;
    }

    public AbstractNode for_Ellipses_RewriteFnOverloadDeclOnly(_Ellipses_RewriteFnOverloadDecl that) {
        return that;
    }

    public AbstractNode for_Ellipses_RewriteObjectExprDeclOnly(_Ellipses_RewriteObjectExprDecl that) {
        return that;
    }

    public AbstractNode for_Ellipses_RewriteFunctionalMethodDeclOnly(_Ellipses_RewriteFunctionalMethodDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesDimUnitDeclOnly(_EllipsesDimUnitDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesDimDeclOnly(_EllipsesDimDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesUnitDeclOnly(_EllipsesUnitDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesTestDeclOnly(_EllipsesTestDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesPropertyDeclOnly(_EllipsesPropertyDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesTypeAliasOnly(_EllipsesTypeAlias that) {
        return that;
    }

    public AbstractNode for_EllipsesGrammarDeclOnly(_EllipsesGrammarDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesGrammarMemberDeclOnly(_EllipsesGrammarMemberDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesNonterminalDeclOnly(_EllipsesNonterminalDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesNonterminalDefOnly(_EllipsesNonterminalDef that) {
        return that;
    }

    public AbstractNode for_EllipsesNonterminalExtensionDefOnly(_EllipsesNonterminalExtensionDef that) {
        return that;
    }

    public AbstractNode for_EllipsesBindingOnly(_EllipsesBinding that) {
        return that;
    }

    public AbstractNode for_EllipsesLValueOnly(_EllipsesLValue that) {
        return that;
    }

    public AbstractNode for_EllipsesParamOnly(_EllipsesParam that) {
        return that;
    }

    public AbstractNode for_EllipsesExprOnly(_EllipsesExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesDummyExprOnly(_EllipsesDummyExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesTypeAnnotatedExprOnly(_EllipsesTypeAnnotatedExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesAsExprOnly(_EllipsesAsExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesAsIfExprOnly(_EllipsesAsIfExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesAssignmentOnly(_EllipsesAssignment that) {
        return that;
    }

    public AbstractNode for_EllipsesBlockOnly(_EllipsesBlock that) {
        return that;
    }

    public AbstractNode for_EllipsesDoOnly(_EllipsesDo that) {
        return that;
    }

    public AbstractNode for_EllipsesCaseExprOnly(_EllipsesCaseExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesIfOnly(_EllipsesIf that) {
        return that;
    }

    public AbstractNode for_EllipsesLabelOnly(_EllipsesLabel that) {
        return that;
    }

    public AbstractNode for_EllipsesAbstractObjectExprOnly(_EllipsesAbstractObjectExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesObjectExprOnly(_EllipsesObjectExpr that) {
        return that;
    }

    public AbstractNode for_Ellipses_RewriteObjectExprOnly(_Ellipses_RewriteObjectExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesTryOnly(_EllipsesTry that) {
        return that;
    }

    public AbstractNode for_EllipsesTupleExprOnly(_EllipsesTupleExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesTypecaseOnly(_EllipsesTypecase that) {
        return that;
    }

    public AbstractNode for_EllipsesWhileOnly(_EllipsesWhile that) {
        return that;
    }

    public AbstractNode for_EllipsesForOnly(_EllipsesFor that) {
        return that;
    }

    public AbstractNode for_EllipsesBigOpAppOnly(_EllipsesBigOpApp that) {
        return that;
    }

    public AbstractNode for_EllipsesAccumulatorOnly(_EllipsesAccumulator that) {
        return that;
    }

    public AbstractNode for_EllipsesArrayComprehensionOnly(_EllipsesArrayComprehension that) {
        return that;
    }

    public AbstractNode for_EllipsesAtomicExprOnly(_EllipsesAtomicExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesExitOnly(_EllipsesExit that) {
        return that;
    }

    public AbstractNode for_EllipsesSpawnOnly(_EllipsesSpawn that) {
        return that;
    }

    public AbstractNode for_EllipsesThrowOnly(_EllipsesThrow that) {
        return that;
    }

    public AbstractNode for_EllipsesTryAtomicExprOnly(_EllipsesTryAtomicExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesFnExprOnly(_EllipsesFnExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesLetExprOnly(_EllipsesLetExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesLetFnOnly(_EllipsesLetFn that) {
        return that;
    }

    public AbstractNode for_EllipsesLocalVarDeclOnly(_EllipsesLocalVarDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesSimpleExprOnly(_EllipsesSimpleExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesSubscriptExprOnly(_EllipsesSubscriptExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesPrimaryOnly(_EllipsesPrimary that) {
        return that;
    }

    public AbstractNode for_EllipsesLiteralExprOnly(_EllipsesLiteralExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesNumberLiteralExprOnly(_EllipsesNumberLiteralExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesFloatLiteralExprOnly(_EllipsesFloatLiteralExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesIntLiteralExprOnly(_EllipsesIntLiteralExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesCharLiteralExprOnly(_EllipsesCharLiteralExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesStringLiteralExprOnly(_EllipsesStringLiteralExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesVoidLiteralExprOnly(_EllipsesVoidLiteralExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesBooleanLiteralExprOnly(_EllipsesBooleanLiteralExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesVarRefOnly(_EllipsesVarRef that) {
        return that;
    }

    public AbstractNode for_EllipsesFieldRefOnly(_EllipsesFieldRef that) {
        return that;
    }

    public AbstractNode for_EllipsesFunctionalRefOnly(_EllipsesFunctionalRef that) {
        return that;
    }

    public AbstractNode for_EllipsesFnRefOnly(_EllipsesFnRef that) {
        return that;
    }

    public AbstractNode for_EllipsesOpRefOnly(_EllipsesOpRef that) {
        return that;
    }

    public AbstractNode for_Ellipses_RewriteFnRefOnly(_Ellipses_RewriteFnRef that) {
        return that;
    }

    public AbstractNode for_Ellipses_RewriteObjectExprRefOnly(_Ellipses_RewriteObjectExprRef that) {
        return that;
    }

    public AbstractNode for_EllipsesJuxtOnly(_EllipsesJuxt that) {
        return that;
    }

    public AbstractNode for_Ellipses_RewriteFnAppOnly(_Ellipses_RewriteFnApp that) {
        return that;
    }

    public AbstractNode for_EllipsesOpExprOnly(_EllipsesOpExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesAmbiguousMultifixOpExprOnly(_EllipsesAmbiguousMultifixOpExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesChainExprOnly(_EllipsesChainExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesCoercionInvocationOnly(_EllipsesCoercionInvocation that) {
        return that;
    }

    public AbstractNode for_EllipsesTraitCoercionInvocationOnly(_EllipsesTraitCoercionInvocation that) {
        return that;
    }

    public AbstractNode for_EllipsesTupleCoercionInvocationOnly(_EllipsesTupleCoercionInvocation that) {
        return that;
    }

    public AbstractNode for_EllipsesArrowCoercionInvocationOnly(_EllipsesArrowCoercionInvocation that) {
        return that;
    }

    public AbstractNode for_EllipsesUnionCoercionInvocationOnly(_EllipsesUnionCoercionInvocation that) {
        return that;
    }

    public AbstractNode for_EllipsesMethodInvocationOnly(_EllipsesMethodInvocation that) {
        return that;
    }

    public AbstractNode for_EllipsesMathPrimaryOnly(_EllipsesMathPrimary that) {
        return that;
    }

    public AbstractNode for_EllipsesArrayExprOnly(_EllipsesArrayExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesArrayElementOnly(_EllipsesArrayElement that) {
        return that;
    }

    public AbstractNode for_EllipsesArrayElementsOnly(_EllipsesArrayElements that) {
        return that;
    }

    public AbstractNode for_EllipsesTypeOnly(_EllipsesType that) {
        return that;
    }

    public AbstractNode for_EllipsesBaseTypeOnly(_EllipsesBaseType that) {
        return that;
    }

    public AbstractNode for_EllipsesAnyTypeOnly(_EllipsesAnyType that) {
        return that;
    }

    public AbstractNode for_EllipsesBottomTypeOnly(_EllipsesBottomType that) {
        return that;
    }

    public AbstractNode for_EllipsesUnknownTypeOnly(_EllipsesUnknownType that) {
        return that;
    }

    public AbstractNode for_EllipsesSelfTypeOnly(_EllipsesSelfType that) {
        return that;
    }

    public AbstractNode for_EllipsesTraitSelfTypeOnly(_EllipsesTraitSelfType that) {
        return that;
    }

    public AbstractNode for_EllipsesObjectExprTypeOnly(_EllipsesObjectExprType that) {
        return that;
    }

    public AbstractNode for_EllipsesNamedTypeOnly(_EllipsesNamedType that) {
        return that;
    }

    public AbstractNode for_Ellipses_InferenceVarTypeOnly(_Ellipses_InferenceVarType that) {
        return that;
    }

    public AbstractNode for_EllipsesVarTypeOnly(_EllipsesVarType that) {
        return that;
    }

    public AbstractNode for_EllipsesTraitTypeOnly(_EllipsesTraitType that) {
        return that;
    }

    public AbstractNode for_EllipsesAbbreviatedTypeOnly(_EllipsesAbbreviatedType that) {
        return that;
    }

    public AbstractNode for_EllipsesArrayTypeOnly(_EllipsesArrayType that) {
        return that;
    }

    public AbstractNode for_EllipsesMatrixTypeOnly(_EllipsesMatrixType that) {
        return that;
    }

    public AbstractNode for_EllipsesTaggedDimTypeOnly(_EllipsesTaggedDimType that) {
        return that;
    }

    public AbstractNode for_EllipsesTaggedUnitTypeOnly(_EllipsesTaggedUnitType that) {
        return that;
    }

    public AbstractNode for_EllipsesTupleTypeOnly(_EllipsesTupleType that) {
        return that;
    }

    public AbstractNode for_EllipsesArrowTypeOnly(_EllipsesArrowType that) {
        return that;
    }

    public AbstractNode for_EllipsesBoundTypeOnly(_EllipsesBoundType that) {
        return that;
    }

    public AbstractNode for_EllipsesIntersectionTypeOnly(_EllipsesIntersectionType that) {
        return that;
    }

    public AbstractNode for_EllipsesUnionTypeOnly(_EllipsesUnionType that) {
        return that;
    }

    public AbstractNode for_EllipsesFixedPointTypeOnly(_EllipsesFixedPointType that) {
        return that;
    }

    public AbstractNode for_EllipsesLabelTypeOnly(_EllipsesLabelType that) {
        return that;
    }

    public AbstractNode for_EllipsesDimExprOnly(_EllipsesDimExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesDimBaseOnly(_EllipsesDimBase that) {
        return that;
    }

    public AbstractNode for_EllipsesDimRefOnly(_EllipsesDimRef that) {
        return that;
    }

    public AbstractNode for_EllipsesDimExponentOnly(_EllipsesDimExponent that) {
        return that;
    }

    public AbstractNode for_EllipsesDimUnaryOpOnly(_EllipsesDimUnaryOp that) {
        return that;
    }

    public AbstractNode for_EllipsesDimBinaryOpOnly(_EllipsesDimBinaryOp that) {
        return that;
    }

    public AbstractNode for_EllipsesPatternOnly(_EllipsesPattern that) {
        return that;
    }

    public AbstractNode for_EllipsesPatternArgsOnly(_EllipsesPatternArgs that) {
        return that;
    }

    public AbstractNode for_EllipsesPatternBindingOnly(_EllipsesPatternBinding that) {
        return that;
    }

    public AbstractNode for_EllipsesPlainPatternOnly(_EllipsesPlainPattern that) {
        return that;
    }

    public AbstractNode for_EllipsesTypePatternOnly(_EllipsesTypePattern that) {
        return that;
    }

    public AbstractNode for_EllipsesNestedPatternOnly(_EllipsesNestedPattern that) {
        return that;
    }

    public AbstractNode for_EllipsesStaticArgOnly(_EllipsesStaticArg that) {
        return that;
    }

    public AbstractNode for_EllipsesTypeArgOnly(_EllipsesTypeArg that) {
        return that;
    }

    public AbstractNode for_EllipsesIntArgOnly(_EllipsesIntArg that) {
        return that;
    }

    public AbstractNode for_EllipsesBoolArgOnly(_EllipsesBoolArg that) {
        return that;
    }

    public AbstractNode for_EllipsesOpArgOnly(_EllipsesOpArg that) {
        return that;
    }

    public AbstractNode for_EllipsesDimArgOnly(_EllipsesDimArg that) {
        return that;
    }

    public AbstractNode for_EllipsesUnitArgOnly(_EllipsesUnitArg that) {
        return that;
    }

    public AbstractNode for_EllipsesStaticExprOnly(_EllipsesStaticExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesIntExprOnly(_EllipsesIntExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesIntBaseOnly(_EllipsesIntBase that) {
        return that;
    }

    public AbstractNode for_EllipsesIntRefOnly(_EllipsesIntRef that) {
        return that;
    }

    public AbstractNode for_EllipsesIntBinaryOpOnly(_EllipsesIntBinaryOp that) {
        return that;
    }

    public AbstractNode for_EllipsesBoolExprOnly(_EllipsesBoolExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesBoolBaseOnly(_EllipsesBoolBase that) {
        return that;
    }

    public AbstractNode for_EllipsesBoolRefOnly(_EllipsesBoolRef that) {
        return that;
    }

    public AbstractNode for_EllipsesBoolConstraintOnly(_EllipsesBoolConstraint that) {
        return that;
    }

    public AbstractNode for_EllipsesBoolUnaryOpOnly(_EllipsesBoolUnaryOp that) {
        return that;
    }

    public AbstractNode for_EllipsesBoolBinaryOpOnly(_EllipsesBoolBinaryOp that) {
        return that;
    }

    public AbstractNode for_EllipsesUnitExprOnly(_EllipsesUnitExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesUnitRefOnly(_EllipsesUnitRef that) {
        return that;
    }

    public AbstractNode for_EllipsesUnitBinaryOpOnly(_EllipsesUnitBinaryOp that) {
        return that;
    }

    public AbstractNode for_EllipsesEffectOnly(_EllipsesEffect that) {
        return that;
    }

    public AbstractNode for_EllipsesWhereClauseOnly(_EllipsesWhereClause that) {
        return that;
    }

    public AbstractNode for_EllipsesWhereBindingOnly(_EllipsesWhereBinding that) {
        return that;
    }

    public AbstractNode for_EllipsesWhereConstraintOnly(_EllipsesWhereConstraint that) {
        return that;
    }

    public AbstractNode for_EllipsesWhereExtendsOnly(_EllipsesWhereExtends that) {
        return that;
    }

    public AbstractNode for_EllipsesWhereTypeAliasOnly(_EllipsesWhereTypeAlias that) {
        return that;
    }

    public AbstractNode for_EllipsesWhereCoercesOnly(_EllipsesWhereCoerces that) {
        return that;
    }

    public AbstractNode for_EllipsesWhereEqualsOnly(_EllipsesWhereEquals that) {
        return that;
    }

    public AbstractNode for_EllipsesUnitConstraintOnly(_EllipsesUnitConstraint that) {
        return that;
    }

    public AbstractNode for_EllipsesIntConstraintOnly(_EllipsesIntConstraint that) {
        return that;
    }

    public AbstractNode for_EllipsesBoolConstraintExprOnly(_EllipsesBoolConstraintExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesContractOnly(_EllipsesContract that) {
        return that;
    }

    public AbstractNode for_EllipsesEnsuresClauseOnly(_EllipsesEnsuresClause that) {
        return that;
    }

    public AbstractNode for_EllipsesStaticParamOnly(_EllipsesStaticParam that) {
        return that;
    }

    public AbstractNode for_EllipsesNameOnly(_EllipsesName that) {
        return that;
    }

    public AbstractNode for_EllipsesAPINameOnly(_EllipsesAPIName that) {
        return that;
    }

    public AbstractNode for_EllipsesIdOrOpOrAnonymousNameOnly(_EllipsesIdOrOpOrAnonymousName that) {
        return that;
    }

    public AbstractNode for_EllipsesIdOrOpOnly(_EllipsesIdOrOp that) {
        return that;
    }

    public AbstractNode for_EllipsesIdOnly(_EllipsesId that) {
        return that;
    }

    public AbstractNode for_EllipsesOpOnly(_EllipsesOp that) {
        return that;
    }

    public AbstractNode for_EllipsesNamedOpOnly(_EllipsesNamedOp that) {
        return that;
    }

    public AbstractNode for_Ellipses_InferenceVarOpOnly(_Ellipses_InferenceVarOp that) {
        return that;
    }

    public AbstractNode for_EllipsesAnonymousNameOnly(_EllipsesAnonymousName that) {
        return that;
    }

    public AbstractNode for_EllipsesAnonymousFnNameOnly(_EllipsesAnonymousFnName that) {
        return that;
    }

    public AbstractNode for_EllipsesConstructorFnNameOnly(_EllipsesConstructorFnName that) {
        return that;
    }

    public AbstractNode for_EllipsesArrayComprehensionClauseOnly(_EllipsesArrayComprehensionClause that) {
        return that;
    }

    public AbstractNode for_EllipsesKeywordExprOnly(_EllipsesKeywordExpr that) {
        return that;
    }

    public AbstractNode for_EllipsesCaseClauseOnly(_EllipsesCaseClause that) {
        return that;
    }

    public AbstractNode for_EllipsesCatchOnly(_EllipsesCatch that) {
        return that;
    }

    public AbstractNode for_EllipsesCatchClauseOnly(_EllipsesCatchClause that) {
        return that;
    }

    public AbstractNode for_EllipsesIfClauseOnly(_EllipsesIfClause that) {
        return that;
    }

    public AbstractNode for_EllipsesTypecaseClauseOnly(_EllipsesTypecaseClause that) {
        return that;
    }

    public AbstractNode for_EllipsesExtentRangeOnly(_EllipsesExtentRange that) {
        return that;
    }

    public AbstractNode for_EllipsesGeneratorClauseOnly(_EllipsesGeneratorClause that) {
        return that;
    }

    public AbstractNode for_EllipsesKeywordTypeOnly(_EllipsesKeywordType that) {
        return that;
    }

    public AbstractNode for_EllipsesTraitTypeWhereOnly(_EllipsesTraitTypeWhere that) {
        return that;
    }

    public AbstractNode for_EllipsesIndicesOnly(_EllipsesIndices that) {
        return that;
    }

    public AbstractNode for_EllipsesMathItemOnly(_EllipsesMathItem that) {
        return that;
    }

    public AbstractNode for_EllipsesExprMIOnly(_EllipsesExprMI that) {
        return that;
    }

    public AbstractNode for_EllipsesParenthesisDelimitedMIOnly(_EllipsesParenthesisDelimitedMI that) {
        return that;
    }

    public AbstractNode for_EllipsesNonParenthesisDelimitedMIOnly(_EllipsesNonParenthesisDelimitedMI that) {
        return that;
    }

    public AbstractNode for_EllipsesNonExprMIOnly(_EllipsesNonExprMI that) {
        return that;
    }

    public AbstractNode for_EllipsesExponentiationMIOnly(_EllipsesExponentiationMI that) {
        return that;
    }

    public AbstractNode for_EllipsesSubscriptingMIOnly(_EllipsesSubscriptingMI that) {
        return that;
    }

    public AbstractNode for_EllipsesOverloadingOnly(_EllipsesOverloading that) {
        return that;
    }

    public AbstractNode for_EllipsesNonterminalHeaderOnly(_EllipsesNonterminalHeader that) {
        return that;
    }

    public AbstractNode for_EllipsesNonterminalParameterOnly(_EllipsesNonterminalParameter that) {
        return that;
    }

    public AbstractNode for_EllipsesSyntaxDeclOnly(_EllipsesSyntaxDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesSyntaxDefOnly(_EllipsesSyntaxDef that) {
        return that;
    }

    public AbstractNode for_EllipsesSuperSyntaxDefOnly(_EllipsesSuperSyntaxDef that) {
        return that;
    }

    public AbstractNode for_EllipsesTransformerDeclOnly(_EllipsesTransformerDecl that) {
        return that;
    }

    public AbstractNode for_EllipsesPreTransformerDefOnly(_EllipsesPreTransformerDef that) {
        return that;
    }

    public AbstractNode for_EllipsesNamedTransformerDefOnly(_EllipsesNamedTransformerDef that) {
        return that;
    }

    public AbstractNode for_EllipsesTransformerOnly(_EllipsesTransformer that) {
        return that;
    }

    public AbstractNode for_EllipsesUnparsedTransformerOnly(_EllipsesUnparsedTransformer that) {
        return that;
    }

    public AbstractNode for_EllipsesNodeTransformerOnly(_EllipsesNodeTransformer that) {
        return that;
    }

    public AbstractNode for_EllipsesCaseTransformerOnly(_EllipsesCaseTransformer that) {
        return that;
    }

    public AbstractNode for_EllipsesCaseTransformerClauseOnly(_EllipsesCaseTransformerClause that) {
        return that;
    }

    public AbstractNode for_EllipsesSyntaxSymbolOnly(_EllipsesSyntaxSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesPrefixedSymbolOnly(_EllipsesPrefixedSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesOptionalSymbolOnly(_EllipsesOptionalSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesRepeatSymbolOnly(_EllipsesRepeatSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesRepeatOneOrMoreSymbolOnly(_EllipsesRepeatOneOrMoreSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesNoWhitespaceSymbolOnly(_EllipsesNoWhitespaceSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesGroupSymbolOnly(_EllipsesGroupSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesSpecialSymbolOnly(_EllipsesSpecialSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesAnyCharacterSymbolOnly(_EllipsesAnyCharacterSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesWhitespaceSymbolOnly(_EllipsesWhitespaceSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesTabSymbolOnly(_EllipsesTabSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesFormfeedSymbolOnly(_EllipsesFormfeedSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesCarriageReturnSymbolOnly(_EllipsesCarriageReturnSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesBackspaceSymbolOnly(_EllipsesBackspaceSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesNewlineSymbolOnly(_EllipsesNewlineSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesBreaklineSymbolOnly(_EllipsesBreaklineSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesItemSymbolOnly(_EllipsesItemSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesNonterminalSymbolOnly(_EllipsesNonterminalSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesKeywordSymbolOnly(_EllipsesKeywordSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesTokenSymbolOnly(_EllipsesTokenSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesNotPredicateSymbolOnly(_EllipsesNotPredicateSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesAndPredicateSymbolOnly(_EllipsesAndPredicateSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesCharacterClassSymbolOnly(_EllipsesCharacterClassSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesCharacterSymbolOnly(_EllipsesCharacterSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesCharSymbolOnly(_EllipsesCharSymbol that) {
        return that;
    }

    public AbstractNode for_EllipsesCharacterIntervalOnly(_EllipsesCharacterInterval that) {
        return that;
    }

    public AbstractNode for_EllipsesLinkOnly(_EllipsesLink that) {
        return that;
    }

    public AbstractNode forTemplateGapAbstractNodeOnly(TemplateGapAbstractNode that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAbstractNode(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapCompilationUnitOnly(TemplateGapCompilationUnit that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCompilationUnit(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapComponentOnly(TemplateGapComponent that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapComponent(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapApiOnly(TemplateGapApi that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapApi(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapImportOnly(TemplateGapImport that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapImport(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapImportedNamesOnly(TemplateGapImportedNames that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapImportedNames(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapImportStarOnly(TemplateGapImportStar that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapImportStar(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapImportNamesOnly(TemplateGapImportNames that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapImportNames(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapImportApiOnly(TemplateGapImportApi that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapImportApi(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapAliasedSimpleNameOnly(TemplateGapAliasedSimpleName that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAliasedSimpleName(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapAliasedAPINameOnly(TemplateGapAliasedAPIName that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAliasedAPIName(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapDeclOnly(TemplateGapDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTraitObjectDeclOnly(TemplateGapTraitObjectDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTraitObjectDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTraitDeclOnly(TemplateGapTraitDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTraitDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapObjectDeclOnly(TemplateGapObjectDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapObjectDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapVarDeclOnly(TemplateGapVarDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapVarDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapFnDeclOnly(TemplateGapFnDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFnDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGap_RewriteFnOverloadDeclOnly(TemplateGap_RewriteFnOverloadDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteFnOverloadDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGap_RewriteObjectExprDeclOnly(TemplateGap_RewriteObjectExprDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteObjectExprDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGap_RewriteFunctionalMethodDeclOnly(TemplateGap_RewriteFunctionalMethodDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteFunctionalMethodDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapDimUnitDeclOnly(TemplateGapDimUnitDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimUnitDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapDimDeclOnly(TemplateGapDimDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapUnitDeclOnly(TemplateGapUnitDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnitDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTestDeclOnly(TemplateGapTestDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTestDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapPropertyDeclOnly(TemplateGapPropertyDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPropertyDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTypeAliasOnly(TemplateGapTypeAlias that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTypeAlias(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapGrammarDeclOnly(TemplateGapGrammarDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapGrammarDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapGrammarMemberDeclOnly(TemplateGapGrammarMemberDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapGrammarMemberDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNonterminalDeclOnly(TemplateGapNonterminalDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNonterminalDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNonterminalDefOnly(TemplateGapNonterminalDef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNonterminalDef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNonterminalExtensionDefOnly(TemplateGapNonterminalExtensionDef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNonterminalExtensionDef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBindingOnly(TemplateGapBinding that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBinding(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapLValueOnly(TemplateGapLValue that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLValue(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapParamOnly(TemplateGapParam that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapParam(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapExprOnly(TemplateGapExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapDummyExprOnly(TemplateGapDummyExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDummyExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTypeAnnotatedExprOnly(TemplateGapTypeAnnotatedExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTypeAnnotatedExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapAsExprOnly(TemplateGapAsExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAsExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapAsIfExprOnly(TemplateGapAsIfExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAsIfExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapAssignmentOnly(TemplateGapAssignment that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAssignment(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBlockOnly(TemplateGapBlock that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBlock(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapDoOnly(TemplateGapDo that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDo(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapCaseExprOnly(TemplateGapCaseExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCaseExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapIfOnly(TemplateGapIf that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIf(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapLabelOnly(TemplateGapLabel that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLabel(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapAbstractObjectExprOnly(TemplateGapAbstractObjectExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAbstractObjectExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapObjectExprOnly(TemplateGapObjectExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapObjectExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGap_RewriteObjectExprOnly(TemplateGap_RewriteObjectExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteObjectExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTryOnly(TemplateGapTry that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTry(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTupleExprOnly(TemplateGapTupleExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTupleExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTypecaseOnly(TemplateGapTypecase that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTypecase(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapWhileOnly(TemplateGapWhile that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhile(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapForOnly(TemplateGapFor that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFor(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBigOpAppOnly(TemplateGapBigOpApp that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBigOpApp(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapAccumulatorOnly(TemplateGapAccumulator that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAccumulator(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapArrayComprehensionOnly(TemplateGapArrayComprehension that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayComprehension(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapAtomicExprOnly(TemplateGapAtomicExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAtomicExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapExitOnly(TemplateGapExit that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapExit(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapSpawnOnly(TemplateGapSpawn that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSpawn(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapThrowOnly(TemplateGapThrow that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapThrow(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTryAtomicExprOnly(TemplateGapTryAtomicExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTryAtomicExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapFnExprOnly(TemplateGapFnExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFnExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapLetExprOnly(TemplateGapLetExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLetExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapLetFnOnly(TemplateGapLetFn that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLetFn(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapLocalVarDeclOnly(TemplateGapLocalVarDecl that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLocalVarDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapSimpleExprOnly(TemplateGapSimpleExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSimpleExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapSubscriptExprOnly(TemplateGapSubscriptExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSubscriptExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapPrimaryOnly(TemplateGapPrimary that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPrimary(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapLiteralExprOnly(TemplateGapLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNumberLiteralExprOnly(TemplateGapNumberLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNumberLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapFloatLiteralExprOnly(TemplateGapFloatLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFloatLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapIntLiteralExprOnly(TemplateGapIntLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapCharLiteralExprOnly(TemplateGapCharLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCharLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapStringLiteralExprOnly(TemplateGapStringLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapStringLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapVoidLiteralExprOnly(TemplateGapVoidLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapVoidLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBooleanLiteralExprOnly(TemplateGapBooleanLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBooleanLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapVarRefOnly(TemplateGapVarRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapVarRef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapFieldRefOnly(TemplateGapFieldRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFieldRef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapFunctionalRefOnly(TemplateGapFunctionalRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFunctionalRef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapFnRefOnly(TemplateGapFnRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFnRef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapOpRefOnly(TemplateGapOpRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapOpRef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGap_RewriteFnRefOnly(TemplateGap_RewriteFnRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteFnRef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGap_RewriteObjectExprRefOnly(TemplateGap_RewriteObjectExprRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteObjectExprRef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapJuxtOnly(TemplateGapJuxt that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapJuxt(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGap_RewriteFnAppOnly(TemplateGap_RewriteFnApp that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteFnApp(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapOpExprOnly(TemplateGapOpExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapOpExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapAmbiguousMultifixOpExprOnly(TemplateGapAmbiguousMultifixOpExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAmbiguousMultifixOpExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapChainExprOnly(TemplateGapChainExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapChainExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapCoercionInvocationOnly(TemplateGapCoercionInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCoercionInvocation(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTraitCoercionInvocationOnly(TemplateGapTraitCoercionInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTraitCoercionInvocation(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTupleCoercionInvocationOnly(TemplateGapTupleCoercionInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTupleCoercionInvocation(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapArrowCoercionInvocationOnly(TemplateGapArrowCoercionInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrowCoercionInvocation(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapUnionCoercionInvocationOnly(TemplateGapUnionCoercionInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnionCoercionInvocation(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapMethodInvocationOnly(TemplateGapMethodInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapMethodInvocation(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapMathPrimaryOnly(TemplateGapMathPrimary that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapMathPrimary(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapArrayExprOnly(TemplateGapArrayExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapArrayElementOnly(TemplateGapArrayElement that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayElement(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapArrayElementsOnly(TemplateGapArrayElements that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayElements(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTypeOnly(TemplateGapType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBaseTypeOnly(TemplateGapBaseType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBaseType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapAnyTypeOnly(TemplateGapAnyType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAnyType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBottomTypeOnly(TemplateGapBottomType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBottomType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapUnknownTypeOnly(TemplateGapUnknownType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnknownType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapSelfTypeOnly(TemplateGapSelfType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSelfType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTraitSelfTypeOnly(TemplateGapTraitSelfType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTraitSelfType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapObjectExprTypeOnly(TemplateGapObjectExprType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapObjectExprType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNamedTypeOnly(TemplateGapNamedType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNamedType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGap_InferenceVarTypeOnly(TemplateGap_InferenceVarType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_InferenceVarType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapVarTypeOnly(TemplateGapVarType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapVarType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTraitTypeOnly(TemplateGapTraitType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTraitType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapAbbreviatedTypeOnly(TemplateGapAbbreviatedType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAbbreviatedType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapArrayTypeOnly(TemplateGapArrayType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapMatrixTypeOnly(TemplateGapMatrixType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapMatrixType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTaggedDimTypeOnly(TemplateGapTaggedDimType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTaggedDimType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTaggedUnitTypeOnly(TemplateGapTaggedUnitType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTaggedUnitType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTupleTypeOnly(TemplateGapTupleType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTupleType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapArrowTypeOnly(TemplateGapArrowType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrowType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBoundTypeOnly(TemplateGapBoundType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoundType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapIntersectionTypeOnly(TemplateGapIntersectionType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntersectionType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapUnionTypeOnly(TemplateGapUnionType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnionType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapFixedPointTypeOnly(TemplateGapFixedPointType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFixedPointType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapLabelTypeOnly(TemplateGapLabelType that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLabelType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapDimExprOnly(TemplateGapDimExpr that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapDimBaseOnly(TemplateGapDimBase that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimBase(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapDimRefOnly(TemplateGapDimRef that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimRef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapDimExponentOnly(TemplateGapDimExponent that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimExponent(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapDimUnaryOpOnly(TemplateGapDimUnaryOp that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimUnaryOp(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapDimBinaryOpOnly(TemplateGapDimBinaryOp that, TypeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimBinaryOp(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapPatternOnly(TemplateGapPattern that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPattern(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapPatternArgsOnly(TemplateGapPatternArgs that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPatternArgs(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapPatternBindingOnly(TemplateGapPatternBinding that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPatternBinding(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapPlainPatternOnly(TemplateGapPlainPattern that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPlainPattern(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTypePatternOnly(TemplateGapTypePattern that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTypePattern(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNestedPatternOnly(TemplateGapNestedPattern that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNestedPattern(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapStaticArgOnly(TemplateGapStaticArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapStaticArg(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTypeArgOnly(TemplateGapTypeArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTypeArg(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapIntArgOnly(TemplateGapIntArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntArg(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBoolArgOnly(TemplateGapBoolArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolArg(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapOpArgOnly(TemplateGapOpArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapOpArg(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapDimArgOnly(TemplateGapDimArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimArg(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapUnitArgOnly(TemplateGapUnitArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnitArg(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapStaticExprOnly(TemplateGapStaticExpr that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapStaticExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapIntExprOnly(TemplateGapIntExpr that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapIntBaseOnly(TemplateGapIntBase that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntBase(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapIntRefOnly(TemplateGapIntRef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntRef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapIntBinaryOpOnly(TemplateGapIntBinaryOp that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntBinaryOp(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBoolExprOnly(TemplateGapBoolExpr that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBoolBaseOnly(TemplateGapBoolBase that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolBase(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBoolRefOnly(TemplateGapBoolRef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolRef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBoolConstraintOnly(TemplateGapBoolConstraint that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolConstraint(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBoolUnaryOpOnly(TemplateGapBoolUnaryOp that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolUnaryOp(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBoolBinaryOpOnly(TemplateGapBoolBinaryOp that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolBinaryOp(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapUnitExprOnly(TemplateGapUnitExpr that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnitExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapUnitRefOnly(TemplateGapUnitRef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnitRef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapUnitBinaryOpOnly(TemplateGapUnitBinaryOp that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnitBinaryOp(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapEffectOnly(TemplateGapEffect that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapEffect(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapWhereClauseOnly(TemplateGapWhereClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhereClause(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapWhereBindingOnly(TemplateGapWhereBinding that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhereBinding(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapWhereConstraintOnly(TemplateGapWhereConstraint that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhereConstraint(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapWhereExtendsOnly(TemplateGapWhereExtends that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhereExtends(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapWhereTypeAliasOnly(TemplateGapWhereTypeAlias that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhereTypeAlias(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapWhereCoercesOnly(TemplateGapWhereCoerces that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhereCoerces(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapWhereEqualsOnly(TemplateGapWhereEquals that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhereEquals(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapUnitConstraintOnly(TemplateGapUnitConstraint that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnitConstraint(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapIntConstraintOnly(TemplateGapIntConstraint that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntConstraint(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBoolConstraintExprOnly(TemplateGapBoolConstraintExpr that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolConstraintExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapContractOnly(TemplateGapContract that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapContract(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapEnsuresClauseOnly(TemplateGapEnsuresClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapEnsuresClause(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapStaticParamOnly(TemplateGapStaticParam that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapStaticParam(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNameOnly(TemplateGapName that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapName(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapAPINameOnly(TemplateGapAPIName that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAPIName(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapIdOrOpOrAnonymousNameOnly(TemplateGapIdOrOpOrAnonymousName that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIdOrOpOrAnonymousName(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapIdOrOpOnly(TemplateGapIdOrOp that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIdOrOp(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapIdOnly(TemplateGapId that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapId(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapOpOnly(TemplateGapOp that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapOp(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNamedOpOnly(TemplateGapNamedOp that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNamedOp(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGap_InferenceVarOpOnly(TemplateGap_InferenceVarOp that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_InferenceVarOp(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapAnonymousNameOnly(TemplateGapAnonymousName that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAnonymousName(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapAnonymousFnNameOnly(TemplateGapAnonymousFnName that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAnonymousFnName(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapConstructorFnNameOnly(TemplateGapConstructorFnName that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapConstructorFnName(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapArrayComprehensionClauseOnly(TemplateGapArrayComprehensionClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayComprehensionClause(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapKeywordExprOnly(TemplateGapKeywordExpr that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapKeywordExpr(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapCaseClauseOnly(TemplateGapCaseClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCaseClause(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapCatchOnly(TemplateGapCatch that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCatch(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapCatchClauseOnly(TemplateGapCatchClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCatchClause(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapIfClauseOnly(TemplateGapIfClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIfClause(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTypecaseClauseOnly(TemplateGapTypecaseClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTypecaseClause(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapExtentRangeOnly(TemplateGapExtentRange that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapExtentRange(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapGeneratorClauseOnly(TemplateGapGeneratorClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapGeneratorClause(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapKeywordTypeOnly(TemplateGapKeywordType that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapKeywordType(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTraitTypeWhereOnly(TemplateGapTraitTypeWhere that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTraitTypeWhere(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapIndicesOnly(TemplateGapIndices that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIndices(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapMathItemOnly(TemplateGapMathItem that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapMathItem(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapExprMIOnly(TemplateGapExprMI that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapExprMI(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapParenthesisDelimitedMIOnly(TemplateGapParenthesisDelimitedMI that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapParenthesisDelimitedMI(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNonParenthesisDelimitedMIOnly(TemplateGapNonParenthesisDelimitedMI that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNonParenthesisDelimitedMI(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNonExprMIOnly(TemplateGapNonExprMI that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNonExprMI(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapExponentiationMIOnly(TemplateGapExponentiationMI that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapExponentiationMI(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapSubscriptingMIOnly(TemplateGapSubscriptingMI that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSubscriptingMI(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapOverloadingOnly(TemplateGapOverloading that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapOverloading(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNonterminalHeaderOnly(TemplateGapNonterminalHeader that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNonterminalHeader(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNonterminalParameterOnly(TemplateGapNonterminalParameter that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNonterminalParameter(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapSyntaxDeclOnly(TemplateGapSyntaxDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSyntaxDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapSyntaxDefOnly(TemplateGapSyntaxDef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSyntaxDef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapSuperSyntaxDefOnly(TemplateGapSuperSyntaxDef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSuperSyntaxDef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTransformerDeclOnly(TemplateGapTransformerDecl that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTransformerDecl(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapPreTransformerDefOnly(TemplateGapPreTransformerDef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPreTransformerDef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNamedTransformerDefOnly(TemplateGapNamedTransformerDef that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNamedTransformerDef(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTransformerOnly(TemplateGapTransformer that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTransformer(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapUnparsedTransformerOnly(TemplateGapUnparsedTransformer that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnparsedTransformer(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNodeTransformerOnly(TemplateGapNodeTransformer that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNodeTransformer(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapCaseTransformerOnly(TemplateGapCaseTransformer that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCaseTransformer(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapCaseTransformerClauseOnly(TemplateGapCaseTransformerClause that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCaseTransformerClause(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapSyntaxSymbolOnly(TemplateGapSyntaxSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSyntaxSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapPrefixedSymbolOnly(TemplateGapPrefixedSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPrefixedSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapOptionalSymbolOnly(TemplateGapOptionalSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapOptionalSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapRepeatSymbolOnly(TemplateGapRepeatSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapRepeatSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapRepeatOneOrMoreSymbolOnly(TemplateGapRepeatOneOrMoreSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapRepeatOneOrMoreSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNoWhitespaceSymbolOnly(TemplateGapNoWhitespaceSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNoWhitespaceSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapGroupSymbolOnly(TemplateGapGroupSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapGroupSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapSpecialSymbolOnly(TemplateGapSpecialSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSpecialSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapAnyCharacterSymbolOnly(TemplateGapAnyCharacterSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAnyCharacterSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapWhitespaceSymbolOnly(TemplateGapWhitespaceSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhitespaceSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTabSymbolOnly(TemplateGapTabSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTabSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapFormfeedSymbolOnly(TemplateGapFormfeedSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFormfeedSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapCarriageReturnSymbolOnly(TemplateGapCarriageReturnSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCarriageReturnSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBackspaceSymbolOnly(TemplateGapBackspaceSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBackspaceSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNewlineSymbolOnly(TemplateGapNewlineSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNewlineSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapBreaklineSymbolOnly(TemplateGapBreaklineSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBreaklineSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapItemSymbolOnly(TemplateGapItemSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapItemSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNonterminalSymbolOnly(TemplateGapNonterminalSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNonterminalSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapKeywordSymbolOnly(TemplateGapKeywordSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapKeywordSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapTokenSymbolOnly(TemplateGapTokenSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTokenSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapNotPredicateSymbolOnly(TemplateGapNotPredicateSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNotPredicateSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapAndPredicateSymbolOnly(TemplateGapAndPredicateSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAndPredicateSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapCharacterClassSymbolOnly(TemplateGapCharacterClassSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCharacterClassSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapCharacterSymbolOnly(TemplateGapCharacterSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCharacterSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapCharSymbolOnly(TemplateGapCharSymbol that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCharSymbol(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapCharacterIntervalOnly(TemplateGapCharacterInterval that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCharacterInterval(info_result, gapId_result, templateParams_result);
    }

    public AbstractNode forTemplateGapLinkOnly(TemplateGapLink that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLink(info_result, gapId_result, templateParams_result);
    }

    /** Methods to recur on each child. */

    public AbstractNode forComponent(Component that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        APIName name_result = (APIName) recur(that.getName());
        List<Import> imports_result = recurOnListOfImport(that.getImports());
        List<Decl> decls_result = recurOnListOfDecl(that.getDecls());
        List<APIName> comprises_result = recurOnListOfAPIName(that.getComprises());
        List<APIName> exports_result = recurOnListOfAPIName(that.getExports());
        return forComponentOnly(that, info_result, name_result, imports_result, decls_result, comprises_result, exports_result);
    }


    public AbstractNode forApi(Api that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        APIName name_result = (APIName) recur(that.getName());
        List<Import> imports_result = recurOnListOfImport(that.getImports());
        List<Decl> decls_result = recurOnListOfDecl(that.getDecls());
        List<APIName> comprises_result = recurOnListOfAPIName(that.getComprises());
        return forApiOnly(that, info_result, name_result, imports_result, decls_result, comprises_result);
    }


    public AbstractNode forImportStar(ImportStar that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        APIName apiName_result = (APIName) recur(that.getApiName());
        List<IdOrOpOrAnonymousName> exceptNames_result = recurOnListOfIdOrOpOrAnonymousName(that.getExceptNames());
        return forImportStarOnly(that, info_result, apiName_result, exceptNames_result);
    }


    public AbstractNode forImportNames(ImportNames that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        APIName apiName_result = (APIName) recur(that.getApiName());
        List<AliasedSimpleName> aliasedNames_result = recurOnListOfAliasedSimpleName(that.getAliasedNames());
        return forImportNamesOnly(that, info_result, apiName_result, aliasedNames_result);
    }


    public AbstractNode forImportApi(ImportApi that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        List<AliasedAPIName> apis_result = recurOnListOfAliasedAPIName(that.getApis());
        return forImportApiOnly(that, info_result, apis_result);
    }


    public AbstractNode forAliasedSimpleName(AliasedSimpleName that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        IdOrOpOrAnonymousName name_result = (IdOrOpOrAnonymousName) recur(that.getName());
        Option<IdOrOpOrAnonymousName> alias_result = recurOnOptionOfIdOrOpOrAnonymousName(that.getAlias());
        return forAliasedSimpleNameOnly(that, info_result, name_result, alias_result);
    }


    public AbstractNode forAliasedAPIName(AliasedAPIName that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        APIName apiName_result = (APIName) recur(that.getApiName());
        Option<Id> alias_result = recurOnOptionOfId(that.getAlias());
        return forAliasedAPINameOnly(that, info_result, apiName_result, alias_result);
    }


    public AbstractNode forTraitDecl(TraitDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        TraitTypeHeader header_result = recurOnTraitTypeHeader(that.getHeader());
        Option<SelfType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        List<BaseType> excludesClause_result = recurOnListOfBaseType(that.getExcludesClause());
        Option<List<NamedType>> comprisesClause_result = recurOnOptionOfListOfNamedType(that.getComprisesClause());
        return forTraitDeclOnly(that, info_result, header_result, selfType_result, excludesClause_result, comprisesClause_result);
    }


    public AbstractNode forObjectDecl(ObjectDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        TraitTypeHeader header_result = recurOnTraitTypeHeader(that.getHeader());
        Option<SelfType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        return forObjectDeclOnly(that, info_result, header_result, selfType_result);
    }


    public AbstractNode forVarDecl(VarDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        List<LValue> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<Expr> init_result = recurOnOptionOfExpr(that.getInit());
        return forVarDeclOnly(that, info_result, lhs_result, init_result);
    }


    public AbstractNode forFnDecl(FnDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        FnHeader header_result = recurOnFnHeader(that.getHeader());
        IdOrOp unambiguousName_result = (IdOrOp) recur(that.getUnambiguousName());
        Option<Expr> body_result = recurOnOptionOfExpr(that.getBody());
        Option<IdOrOp> implementsUnambiguousName_result = recurOnOptionOfIdOrOp(that.getImplementsUnambiguousName());
        return forFnDeclOnly(that, info_result, header_result, unambiguousName_result, body_result, implementsUnambiguousName_result);
    }


    public AbstractNode for_RewriteFnOverloadDecl(_RewriteFnOverloadDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        IdOrOp name_result = (IdOrOp) recur(that.getName());
        List<IdOrOp> fns_result = recurOnListOfIdOrOp(that.getFns());
        Option<Type> type_result = recurOnOptionOfType(that.getType());
        return for_RewriteFnOverloadDeclOnly(that, info_result, name_result, fns_result, type_result);
    }


    public AbstractNode for_RewriteObjectExprDecl(_RewriteObjectExprDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        List<_RewriteObjectExpr> objectExprs_result = recurOnListOf_RewriteObjectExpr(that.getObjectExprs());
        return for_RewriteObjectExprDeclOnly(that, info_result, objectExprs_result);
    }


    public AbstractNode for_RewriteFunctionalMethodDecl(_RewriteFunctionalMethodDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_RewriteFunctionalMethodDeclOnly(that, info_result);
    }


    public AbstractNode forDimDecl(DimDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id dimId_result = (Id) recur(that.getDimId());
        Option<Type> derived_result = recurOnOptionOfType(that.getDerived());
        Option<Id> defaultId_result = recurOnOptionOfId(that.getDefaultId());
        return forDimDeclOnly(that, info_result, dimId_result, derived_result, defaultId_result);
    }


    public AbstractNode forUnitDecl(UnitDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        List<Id> units_result = recurOnListOfId(that.getUnits());
        Option<Type> dimType_result = recurOnOptionOfType(that.getDimType());
        Option<Expr> defExpr_result = recurOnOptionOfExpr(that.getDefExpr());
        return forUnitDeclOnly(that, info_result, units_result, dimType_result, defExpr_result);
    }


    public AbstractNode forTestDecl(TestDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        Expr expr_result = (Expr) recur(that.getExpr());
        return forTestDeclOnly(that, info_result, name_result, gens_result, expr_result);
    }


    public AbstractNode forPropertyDecl(PropertyDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Option<Id> name_result = recurOnOptionOfId(that.getName());
        List<Param> params_result = recurOnListOfParam(that.getParams());
        Expr expr_result = (Expr) recur(that.getExpr());
        return forPropertyDeclOnly(that, info_result, name_result, params_result, expr_result);
    }


    public AbstractNode forTypeAlias(TypeAlias that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<StaticParam> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        Type typeDef_result = (Type) recur(that.getTypeDef());
        return forTypeAliasOnly(that, info_result, name_result, staticParams_result, typeDef_result);
    }


    public AbstractNode forGrammarDecl(GrammarDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<Id> extendsClause_result = recurOnListOfId(that.getExtendsClause());
        List<GrammarMemberDecl> members_result = recurOnListOfGrammarMemberDecl(that.getMembers());
        List<TransformerDecl> transformers_result = recurOnListOfTransformerDecl(that.getTransformers());
        return forGrammarDeclOnly(that, info_result, name_result, extendsClause_result, members_result, transformers_result);
    }


    public AbstractNode forNonterminalDef(NonterminalDef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<SyntaxDecl> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        NonterminalHeader header_result = (NonterminalHeader) recur(that.getHeader());
        Option<BaseType> astType_result = recurOnOptionOfBaseType(that.getAstType());
        return forNonterminalDefOnly(that, info_result, name_result, syntaxDecls_result, header_result, astType_result);
    }


    public AbstractNode forNonterminalExtensionDef(NonterminalExtensionDef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<SyntaxDecl> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        return forNonterminalExtensionDefOnly(that, info_result, name_result, syntaxDecls_result);
    }


    public AbstractNode forLValue(LValue that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        Option<TypeOrPattern> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        return forLValueOnly(that, info_result, name_result, idType_result);
    }


    public AbstractNode forParam(Param that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        Option<TypeOrPattern> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        Option<Expr> defaultExpr_result = recurOnOptionOfExpr(that.getDefaultExpr());
        Option<Type> varargsType_result = recurOnOptionOfType(that.getVarargsType());
        return forParamOnly(that, info_result, name_result, idType_result, defaultExpr_result, varargsType_result);
    }


    public AbstractNode forDummyExpr(DummyExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return forDummyExprOnly(that, info_result);
    }


    public AbstractNode forAsExpr(AsExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr expr_result = (Expr) recur(that.getExpr());
        Type annType_result = (Type) recur(that.getAnnType());
        return forAsExprOnly(that, info_result, expr_result, annType_result);
    }


    public AbstractNode forAsIfExpr(AsIfExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr expr_result = (Expr) recur(that.getExpr());
        Type annType_result = (Type) recur(that.getAnnType());
        return forAsIfExprOnly(that, info_result, expr_result, annType_result);
    }


    public AbstractNode forAssignment(Assignment that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<Lhs> lhs_result = recurOnListOfLhs(that.getLhs());
        Option<FunctionalRef> assignOp_result = recurOnOptionOfFunctionalRef(that.getAssignOp());
        Expr rhs_result = (Expr) recur(that.getRhs());
        List<CompoundAssignmentInfo> assignmentInfos_result = recurOnListOfCompoundAssignmentInfo(that.getAssignmentInfos());
        return forAssignmentOnly(that, info_result, lhs_result, assignOp_result, rhs_result, assignmentInfos_result);
    }


    public AbstractNode forBlock(Block that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Option<Expr> loc_result = recurOnOptionOfExpr(that.getLoc());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        return forBlockOnly(that, info_result, loc_result, exprs_result);
    }


    public AbstractNode forDo(Do that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<Block> fronts_result = recurOnListOfBlock(that.getFronts());
        return forDoOnly(that, info_result, fronts_result);
    }


    public AbstractNode forCaseExpr(CaseExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Option<Expr> param_result = recurOnOptionOfExpr(that.getParam());
        Option<FunctionalRef> compare_result = recurOnOptionOfFunctionalRef(that.getCompare());
        FunctionalRef equalsOp_result = (FunctionalRef) recur(that.getEqualsOp());
        FunctionalRef inOp_result = (FunctionalRef) recur(that.getInOp());
        List<CaseClause> clauses_result = recurOnListOfCaseClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forCaseExprOnly(that, info_result, param_result, compare_result, equalsOp_result, inOp_result, clauses_result, elseClause_result);
    }


    public AbstractNode forIf(If that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<IfClause> clauses_result = recurOnListOfIfClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forIfOnly(that, info_result, clauses_result, elseClause_result);
    }


    public AbstractNode forLabel(Label that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        Block body_result = (Block) recur(that.getBody());
        return forLabelOnly(that, info_result, name_result, body_result);
    }


    public AbstractNode forObjectExpr(ObjectExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        TraitTypeHeader header_result = recurOnTraitTypeHeader(that.getHeader());
        Option<SelfType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        return forObjectExprOnly(that, info_result, header_result, selfType_result);
    }


    public AbstractNode for_RewriteObjectExpr(_RewriteObjectExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        TraitTypeHeader header_result = recurOnTraitTypeHeader(that.getHeader());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_RewriteObjectExprOnly(that, info_result, header_result, staticArgs_result);
    }


    public AbstractNode forTry(Try that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Block body_result = (Block) recur(that.getBody());
        Option<Catch> catchClause_result = recurOnOptionOfCatch(that.getCatchClause());
        List<BaseType> forbidClause_result = recurOnListOfBaseType(that.getForbidClause());
        Option<Block> finallyClause_result = recurOnOptionOfBlock(that.getFinallyClause());
        return forTryOnly(that, info_result, body_result, catchClause_result, forbidClause_result, finallyClause_result);
    }


    public AbstractNode forTupleExpr(TupleExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        Option<Expr> varargs_result = recurOnOptionOfExpr(that.getVarargs());
        List<KeywordExpr> keywords_result = recurOnListOfKeywordExpr(that.getKeywords());
        return forTupleExprOnly(that, info_result, exprs_result, varargs_result, keywords_result);
    }


    public AbstractNode forTypecase(Typecase that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr bindExpr_result = (Expr) recur(that.getBindExpr());
        List<TypecaseClause> clauses_result = recurOnListOfTypecaseClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forTypecaseOnly(that, info_result, bindExpr_result, clauses_result, elseClause_result);
    }


    public AbstractNode forWhile(While that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        GeneratorClause testExpr_result = (GeneratorClause) recur(that.getTestExpr());
        Do body_result = (Do) recur(that.getBody());
        return forWhileOnly(that, info_result, testExpr_result, body_result);
    }


    public AbstractNode forFor(For that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        Block body_result = (Block) recur(that.getBody());
        return forForOnly(that, info_result, gens_result, body_result);
    }


    public AbstractNode forAccumulator(Accumulator that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Op accOp_result = (Op) recur(that.getAccOp());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        Expr body_result = (Expr) recur(that.getBody());
        return forAccumulatorOnly(that, info_result, staticArgs_result, accOp_result, gens_result, body_result);
    }


    public AbstractNode forArrayComprehension(ArrayComprehension that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<ArrayComprehensionClause> clauses_result = recurOnListOfArrayComprehensionClause(that.getClauses());
        return forArrayComprehensionOnly(that, info_result, staticArgs_result, clauses_result);
    }


    public AbstractNode forAtomicExpr(AtomicExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr expr_result = (Expr) recur(that.getExpr());
        return forAtomicExprOnly(that, info_result, expr_result);
    }


    public AbstractNode forExit(Exit that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Option<Id> target_result = recurOnOptionOfId(that.getTarget());
        Option<Expr> returnExpr_result = recurOnOptionOfExpr(that.getReturnExpr());
        return forExitOnly(that, info_result, target_result, returnExpr_result);
    }


    public AbstractNode forSpawn(Spawn that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr body_result = (Expr) recur(that.getBody());
        return forSpawnOnly(that, info_result, body_result);
    }


    public AbstractNode forThrow(Throw that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr expr_result = (Expr) recur(that.getExpr());
        return forThrowOnly(that, info_result, expr_result);
    }


    public AbstractNode forTryAtomicExpr(TryAtomicExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr expr_result = (Expr) recur(that.getExpr());
        return forTryAtomicExprOnly(that, info_result, expr_result);
    }


    public AbstractNode forFnExpr(FnExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        FnHeader header_result = recurOnFnHeader(that.getHeader());
        Expr body_result = (Expr) recur(that.getBody());
        return forFnExprOnly(that, info_result, header_result, body_result);
    }


    public AbstractNode forLetFn(LetFn that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Block body_result = (Block) recur(that.getBody());
        List<FnDecl> fns_result = recurOnListOfFnDecl(that.getFns());
        return forLetFnOnly(that, info_result, body_result, fns_result);
    }


    public AbstractNode forLocalVarDecl(LocalVarDecl that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Block body_result = (Block) recur(that.getBody());
        List<LValue> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<Expr> rhs_result = recurOnOptionOfExpr(that.getRhs());
        return forLocalVarDeclOnly(that, info_result, body_result, lhs_result, rhs_result);
    }


    public AbstractNode forSubscriptExpr(SubscriptExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr obj_result = (Expr) recur(that.getObj());
        List<Expr> subs_result = recurOnListOfExpr(that.getSubs());
        Option<Op> op_result = recurOnOptionOfOp(that.getOp());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return forSubscriptExprOnly(that, info_result, obj_result, subs_result, op_result, staticArgs_result);
    }


    public AbstractNode forFloatLiteralExpr(FloatLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return forFloatLiteralExprOnly(that, info_result);
    }


    public AbstractNode forIntLiteralExpr(IntLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return forIntLiteralExprOnly(that, info_result);
    }


    public AbstractNode forCharLiteralExpr(CharLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return forCharLiteralExprOnly(that, info_result);
    }


    public AbstractNode forStringLiteralExpr(StringLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return forStringLiteralExprOnly(that, info_result);
    }


    public AbstractNode forVoidLiteralExpr(VoidLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return forVoidLiteralExprOnly(that, info_result);
    }


    public AbstractNode forBooleanLiteralExpr(BooleanLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return forBooleanLiteralExprOnly(that, info_result);
    }


    public AbstractNode forVarRef(VarRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id varId_result = (Id) recur(that.getVarId());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return forVarRefOnly(that, info_result, varId_result, staticArgs_result);
    }


    public AbstractNode forFieldRef(FieldRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr obj_result = (Expr) recur(that.getObj());
        Id field_result = (Id) recur(that.getField());
        return forFieldRefOnly(that, info_result, obj_result, field_result);
    }


    public AbstractNode forFnRef(FnRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        IdOrOp originalName_result = (IdOrOp) recur(that.getOriginalName());
        List<IdOrOp> names_result = recurOnListOfIdOrOp(that.getNames());
        List<Overloading> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<Overloading> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return forFnRefOnly(that, info_result, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }


    public AbstractNode forOpRef(OpRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        IdOrOp originalName_result = (IdOrOp) recur(that.getOriginalName());
        List<IdOrOp> names_result = recurOnListOfIdOrOp(that.getNames());
        List<Overloading> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<Overloading> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return forOpRefOnly(that, info_result, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }


    public AbstractNode for_RewriteFnRef(_RewriteFnRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr fnExpr_result = (Expr) recur(that.getFnExpr());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_RewriteFnRefOnly(that, info_result, fnExpr_result, staticArgs_result);
    }


    public AbstractNode for_RewriteObjectExprRef(_RewriteObjectExprRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_RewriteObjectExprRefOnly(that, info_result, staticArgs_result);
    }


    public AbstractNode forJuxt(Juxt that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        FunctionalRef multiJuxt_result = (FunctionalRef) recur(that.getMultiJuxt());
        FunctionalRef infixJuxt_result = (FunctionalRef) recur(that.getInfixJuxt());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        return forJuxtOnly(that, info_result, multiJuxt_result, infixJuxt_result, exprs_result);
    }


    public AbstractNode for_RewriteFnApp(_RewriteFnApp that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr function_result = (Expr) recur(that.getFunction());
        Expr argument_result = (Expr) recur(that.getArgument());
        return for_RewriteFnAppOnly(that, info_result, function_result, argument_result);
    }


    public AbstractNode forOpExpr(OpExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        FunctionalRef op_result = (FunctionalRef) recur(that.getOp());
        List<Expr> args_result = recurOnListOfExpr(that.getArgs());
        return forOpExprOnly(that, info_result, op_result, args_result);
    }


    public AbstractNode forAmbiguousMultifixOpExpr(AmbiguousMultifixOpExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        FunctionalRef infix_op_result = (FunctionalRef) recur(that.getInfix_op());
        FunctionalRef multifix_op_result = (FunctionalRef) recur(that.getMultifix_op());
        List<Expr> args_result = recurOnListOfExpr(that.getArgs());
        return forAmbiguousMultifixOpExprOnly(that, info_result, infix_op_result, multifix_op_result, args_result);
    }


    public AbstractNode forChainExpr(ChainExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr first_result = (Expr) recur(that.getFirst());
        List<Link> links_result = recurOnListOfLink(that.getLinks());
        return forChainExprOnly(that, info_result, first_result, links_result);
    }


    public AbstractNode forTraitCoercionInvocation(TraitCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr arg_result = (Expr) recur(that.getArg());
        TraitType toType_result = (TraitType) recur(that.getToType());
        FnRef coercionFn_result = (FnRef) recur(that.getCoercionFn());
        return forTraitCoercionInvocationOnly(that, info_result, arg_result, toType_result, coercionFn_result);
    }


    public AbstractNode forTupleCoercionInvocation(TupleCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr arg_result = (Expr) recur(that.getArg());
        TupleType toType_result = (TupleType) recur(that.getToType());
        List<Option<CoercionInvocation>> subCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getSubCoercions());
        Option<Option<CoercionInvocation>> varargCoercion_result = recurOnOptionOfOptionOfCoercionInvocation(that.getVarargCoercion());
        return forTupleCoercionInvocationOnly(that, info_result, arg_result, toType_result, subCoercions_result, varargCoercion_result);
    }


    public AbstractNode forArrowCoercionInvocation(ArrowCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr arg_result = (Expr) recur(that.getArg());
        ArrowType toType_result = (ArrowType) recur(that.getToType());
        Option<CoercionInvocation> domainCoercion_result = recurOnOptionOfCoercionInvocation(that.getDomainCoercion());
        Option<CoercionInvocation> rangeCoercion_result = recurOnOptionOfCoercionInvocation(that.getRangeCoercion());
        return forArrowCoercionInvocationOnly(that, info_result, arg_result, toType_result, domainCoercion_result, rangeCoercion_result);
    }


    public AbstractNode forUnionCoercionInvocation(UnionCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Type toType_result = (Type) recur(that.getToType());
        Expr arg_result = (Expr) recur(that.getArg());
        List<Type> fromTypes_result = recurOnListOfType(that.getFromTypes());
        List<Option<CoercionInvocation>> fromCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getFromCoercions());
        return forUnionCoercionInvocationOnly(that, info_result, toType_result, arg_result, fromTypes_result, fromCoercions_result);
    }


    public AbstractNode forMethodInvocation(MethodInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr obj_result = (Expr) recur(that.getObj());
        IdOrOp method_result = (IdOrOp) recur(that.getMethod());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Expr arg_result = (Expr) recur(that.getArg());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return forMethodInvocationOnly(that, info_result, obj_result, method_result, staticArgs_result, arg_result, overloadingType_result, overloadingSchema_result);
    }


    public AbstractNode forMathPrimary(MathPrimary that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        FunctionalRef multiJuxt_result = (FunctionalRef) recur(that.getMultiJuxt());
        FunctionalRef infixJuxt_result = (FunctionalRef) recur(that.getInfixJuxt());
        Expr front_result = (Expr) recur(that.getFront());
        List<MathItem> rest_result = recurOnListOfMathItem(that.getRest());
        return forMathPrimaryOnly(that, info_result, multiJuxt_result, infixJuxt_result, front_result, rest_result);
    }


    public AbstractNode forArrayElement(ArrayElement that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Expr element_result = (Expr) recur(that.getElement());
        return forArrayElementOnly(that, info_result, staticArgs_result, element_result);
    }


    public AbstractNode forArrayElements(ArrayElements that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<ArrayExpr> elements_result = recurOnListOfArrayExpr(that.getElements());
        return forArrayElementsOnly(that, info_result, staticArgs_result, elements_result);
    }


    public AbstractNode forAnyType(AnyType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return forAnyTypeOnly(that, info_result);
    }


    public AbstractNode forBottomType(BottomType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return forBottomTypeOnly(that, info_result);
    }


    public AbstractNode forUnknownType(UnknownType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return forUnknownTypeOnly(that, info_result);
    }


    public AbstractNode forTraitSelfType(TraitSelfType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        BaseType named_result = (BaseType) recur(that.getNamed());
        List<NamedType> comprised_result = recurOnListOfNamedType(that.getComprised());
        return forTraitSelfTypeOnly(that, info_result, named_result, comprised_result);
    }


    public AbstractNode forObjectExprType(ObjectExprType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        List<BaseType> extended_result = recurOnListOfBaseType(that.getExtended());
        return forObjectExprTypeOnly(that, info_result, extended_result);
    }


    public AbstractNode for_InferenceVarType(_InferenceVarType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        return for_InferenceVarTypeOnly(that, info_result, name_result);
    }


    public AbstractNode forVarType(VarType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        return forVarTypeOnly(that, info_result, name_result);
    }


    public AbstractNode forTraitType(TraitType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<StaticArg> args_result = recurOnListOfStaticArg(that.getArgs());
        List<StaticParam> traitStaticParams_result = recurOnListOfStaticParam(that.getTraitStaticParams());
        return forTraitTypeOnly(that, info_result, name_result, args_result, traitStaticParams_result);
    }


    public AbstractNode forArrayType(ArrayType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Type elemType_result = (Type) recur(that.getElemType());
        Indices indices_result = (Indices) recur(that.getIndices());
        return forArrayTypeOnly(that, info_result, elemType_result, indices_result);
    }


    public AbstractNode forMatrixType(MatrixType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Type elemType_result = (Type) recur(that.getElemType());
        List<ExtentRange> dimensions_result = recurOnListOfExtentRange(that.getDimensions());
        return forMatrixTypeOnly(that, info_result, elemType_result, dimensions_result);
    }


    public AbstractNode forTaggedDimType(TaggedDimType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Type elemType_result = (Type) recur(that.getElemType());
        DimExpr dimExpr_result = (DimExpr) recur(that.getDimExpr());
        Option<Expr> unitExpr_result = recurOnOptionOfExpr(that.getUnitExpr());
        return forTaggedDimTypeOnly(that, info_result, elemType_result, dimExpr_result, unitExpr_result);
    }


    public AbstractNode forTaggedUnitType(TaggedUnitType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Type elemType_result = (Type) recur(that.getElemType());
        Expr unitExpr_result = (Expr) recur(that.getUnitExpr());
        return forTaggedUnitTypeOnly(that, info_result, elemType_result, unitExpr_result);
    }


    public AbstractNode forTupleType(TupleType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        List<Type> elements_result = recurOnListOfType(that.getElements());
        Option<Type> varargs_result = recurOnOptionOfType(that.getVarargs());
        List<KeywordType> keywords_result = recurOnListOfKeywordType(that.getKeywords());
        return forTupleTypeOnly(that, info_result, elements_result, varargs_result, keywords_result);
    }


    public AbstractNode forArrowType(ArrowType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Type domain_result = (Type) recur(that.getDomain());
        Type range_result = (Type) recur(that.getRange());
        Effect effect_result = (Effect) recur(that.getEffect());
        Option<MethodInfo> methodInfo_result = recurOnOptionOfMethodInfo(that.getMethodInfo());
        return forArrowTypeOnly(that, info_result, domain_result, range_result, effect_result, methodInfo_result);
    }


    public AbstractNode forIntersectionType(IntersectionType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        List<Type> elements_result = recurOnListOfType(that.getElements());
        return forIntersectionTypeOnly(that, info_result, elements_result);
    }


    public AbstractNode forUnionType(UnionType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        List<Type> elements_result = recurOnListOfType(that.getElements());
        return forUnionTypeOnly(that, info_result, elements_result);
    }


    public AbstractNode forFixedPointType(FixedPointType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        _InferenceVarType name_result = (_InferenceVarType) recur(that.getName());
        Type body_result = (Type) recur(that.getBody());
        return forFixedPointTypeOnly(that, info_result, name_result, body_result);
    }


    public AbstractNode forLabelType(LabelType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return forLabelTypeOnly(that, info_result);
    }


    public AbstractNode forDimBase(DimBase that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return forDimBaseOnly(that, info_result);
    }


    public AbstractNode forDimRef(DimRef that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        return forDimRefOnly(that, info_result, name_result);
    }


    public AbstractNode forDimExponent(DimExponent that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Type base_result = (Type) recur(that.getBase());
        IntExpr power_result = (IntExpr) recur(that.getPower());
        return forDimExponentOnly(that, info_result, base_result, power_result);
    }


    public AbstractNode forDimUnaryOp(DimUnaryOp that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        DimExpr dimVal_result = (DimExpr) recur(that.getDimVal());
        Op op_result = (Op) recur(that.getOp());
        return forDimUnaryOpOnly(that, info_result, dimVal_result, op_result);
    }


    public AbstractNode forDimBinaryOp(DimBinaryOp that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        DimExpr left_result = (DimExpr) recur(that.getLeft());
        DimExpr right_result = (DimExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        return forDimBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }


    public AbstractNode forPattern(Pattern that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Option<Type> name_result = recurOnOptionOfType(that.getName());
        PatternArgs patterns_result = (PatternArgs) recur(that.getPatterns());
        return forPatternOnly(that, info_result, name_result, patterns_result);
    }


    public AbstractNode forPatternArgs(PatternArgs that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        List<PatternBinding> patterns_result = recurOnListOfPatternBinding(that.getPatterns());
        return forPatternArgsOnly(that, info_result, patterns_result);
    }


    public AbstractNode forPlainPattern(PlainPattern that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Option<Id> field_result = recurOnOptionOfId(that.getField());
        Id name_result = (Id) recur(that.getName());
        Option<TypeOrPattern> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        return forPlainPatternOnly(that, info_result, field_result, name_result, idType_result);
    }


    public AbstractNode forTypePattern(TypePattern that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Option<Id> field_result = recurOnOptionOfId(that.getField());
        Type typ_result = (Type) recur(that.getTyp());
        return forTypePatternOnly(that, info_result, field_result, typ_result);
    }


    public AbstractNode forNestedPattern(NestedPattern that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Option<Id> field_result = recurOnOptionOfId(that.getField());
        Pattern pat_result = (Pattern) recur(that.getPat());
        return forNestedPatternOnly(that, info_result, field_result, pat_result);
    }


    public AbstractNode forTypeArg(TypeArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Type typeArg_result = (Type) recur(that.getTypeArg());
        return forTypeArgOnly(that, info_result, typeArg_result);
    }


    public AbstractNode forIntArg(IntArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        IntExpr intVal_result = (IntExpr) recur(that.getIntVal());
        return forIntArgOnly(that, info_result, intVal_result);
    }


    public AbstractNode forBoolArg(BoolArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        BoolExpr boolArg_result = (BoolExpr) recur(that.getBoolArg());
        return forBoolArgOnly(that, info_result, boolArg_result);
    }


    public AbstractNode forOpArg(OpArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Op id_result = (Op) recur(that.getId());
        return forOpArgOnly(that, info_result, id_result);
    }


    public AbstractNode forDimArg(DimArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        DimExpr dimArg_result = (DimExpr) recur(that.getDimArg());
        return forDimArgOnly(that, info_result, dimArg_result);
    }


    public AbstractNode forUnitArg(UnitArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        UnitExpr unitArg_result = (UnitExpr) recur(that.getUnitArg());
        return forUnitArgOnly(that, info_result, unitArg_result);
    }


    public AbstractNode forIntBase(IntBase that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        IntLiteralExpr intVal_result = (IntLiteralExpr) recur(that.getIntVal());
        return forIntBaseOnly(that, info_result, intVal_result);
    }


    public AbstractNode forIntRef(IntRef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        return forIntRefOnly(that, info_result, name_result);
    }


    public AbstractNode forIntBinaryOp(IntBinaryOp that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        IntExpr left_result = (IntExpr) recur(that.getLeft());
        IntExpr right_result = (IntExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        return forIntBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }


    public AbstractNode forBoolBase(BoolBase that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return forBoolBaseOnly(that, info_result);
    }


    public AbstractNode forBoolRef(BoolRef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        return forBoolRefOnly(that, info_result, name_result);
    }


    public AbstractNode forBoolUnaryOp(BoolUnaryOp that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        BoolExpr boolVal_result = (BoolExpr) recur(that.getBoolVal());
        Op op_result = (Op) recur(that.getOp());
        return forBoolUnaryOpOnly(that, info_result, boolVal_result, op_result);
    }


    public AbstractNode forBoolBinaryOp(BoolBinaryOp that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        BoolExpr left_result = (BoolExpr) recur(that.getLeft());
        BoolExpr right_result = (BoolExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        return forBoolBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }


    public AbstractNode forUnitRef(UnitRef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        return forUnitRefOnly(that, info_result, name_result);
    }


    public AbstractNode forUnitBinaryOp(UnitBinaryOp that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        UnitExpr left_result = (UnitExpr) recur(that.getLeft());
        UnitExpr right_result = (UnitExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        return forUnitBinaryOpOnly(that, info_result, left_result, right_result, op_result);
    }


    public AbstractNode forEffect(Effect that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Option<List<Type>> throwsClause_result = recurOnOptionOfListOfType(that.getThrowsClause());
        return forEffectOnly(that, info_result, throwsClause_result);
    }


    public AbstractNode forWhereClause(WhereClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        List<WhereBinding> bindings_result = recurOnListOfWhereBinding(that.getBindings());
        List<WhereConstraint> constraints_result = recurOnListOfWhereConstraint(that.getConstraints());
        return forWhereClauseOnly(that, info_result, bindings_result, constraints_result);
    }


    public AbstractNode forWhereBinding(WhereBinding that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<BaseType> supers_result = recurOnListOfBaseType(that.getSupers());
        StaticParamKind kind_result = recurOnStaticParamKind(that.getKind());
        return forWhereBindingOnly(that, info_result, name_result, supers_result, kind_result);
    }


    public AbstractNode forWhereExtends(WhereExtends that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<BaseType> supers_result = recurOnListOfBaseType(that.getSupers());
        return forWhereExtendsOnly(that, info_result, name_result, supers_result);
    }


    public AbstractNode forWhereTypeAlias(WhereTypeAlias that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        TypeAlias alias_result = (TypeAlias) recur(that.getAlias());
        return forWhereTypeAliasOnly(that, info_result, alias_result);
    }


    public AbstractNode forWhereCoerces(WhereCoerces that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Type left_result = (Type) recur(that.getLeft());
        Type right_result = (Type) recur(that.getRight());
        return forWhereCoercesOnly(that, info_result, left_result, right_result);
    }


    public AbstractNode forWhereEquals(WhereEquals that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id left_result = (Id) recur(that.getLeft());
        Id right_result = (Id) recur(that.getRight());
        return forWhereEqualsOnly(that, info_result, left_result, right_result);
    }


    public AbstractNode forUnitConstraint(UnitConstraint that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        return forUnitConstraintOnly(that, info_result, name_result);
    }


    public AbstractNode forIntConstraint(IntConstraint that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        IntExpr left_result = (IntExpr) recur(that.getLeft());
        IntExpr right_result = (IntExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        return forIntConstraintOnly(that, info_result, left_result, right_result, op_result);
    }


    public AbstractNode forBoolConstraintExpr(BoolConstraintExpr that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        BoolConstraint constraint_result = (BoolConstraint) recur(that.getConstraint());
        return forBoolConstraintExprOnly(that, info_result, constraint_result);
    }


    public AbstractNode forContract(Contract that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Option<List<Expr>> requiresClause_result = recurOnOptionOfListOfExpr(that.getRequiresClause());
        Option<List<EnsuresClause>> ensuresClause_result = recurOnOptionOfListOfEnsuresClause(that.getEnsuresClause());
        Option<List<Expr>> invariantsClause_result = recurOnOptionOfListOfExpr(that.getInvariantsClause());
        return forContractOnly(that, info_result, requiresClause_result, ensuresClause_result, invariantsClause_result);
    }


    public AbstractNode forEnsuresClause(EnsuresClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Expr post_result = (Expr) recur(that.getPost());
        Option<Expr> pre_result = recurOnOptionOfExpr(that.getPre());
        return forEnsuresClauseOnly(that, info_result, post_result, pre_result);
    }


    public AbstractNode forStaticParam(StaticParam that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        IdOrOp name_result = (IdOrOp) recur(that.getName());
        List<BaseType> extendsClause_result = recurOnListOfBaseType(that.getExtendsClause());
        List<BaseType> dominatesClause_result = recurOnListOfBaseType(that.getDominatesClause());
        Option<Type> dimParam_result = recurOnOptionOfType(that.getDimParam());
        StaticParamKind kind_result = recurOnStaticParamKind(that.getKind());
        return forStaticParamOnly(that, info_result, name_result, extendsClause_result, dominatesClause_result, dimParam_result, kind_result);
    }


    public AbstractNode forAPIName(APIName that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        List<Id> ids_result = recurOnListOfId(that.getIds());
        return forAPINameOnly(that, info_result, ids_result);
    }


    public AbstractNode forId(Id that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return forIdOnly(that, info_result, apiName_result);
    }


    public AbstractNode forNamedOp(NamedOp that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        Fixity fixity_result = recurOnFixity(that.getFixity());
        return forNamedOpOnly(that, info_result, apiName_result, fixity_result);
    }


    public AbstractNode for_InferenceVarOp(_InferenceVarOp that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        Fixity fixity_result = recurOnFixity(that.getFixity());
        return for_InferenceVarOpOnly(that, info_result, apiName_result, fixity_result);
    }


    public AbstractNode forAnonymousFnName(AnonymousFnName that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        return forAnonymousFnNameOnly(that, info_result, apiName_result);
    }


    public AbstractNode forConstructorFnName(ConstructorFnName that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        ObjectConstructor constructor_result = recurOnObjectConstructor(that.getConstructor());
        return forConstructorFnNameOnly(that, info_result, apiName_result, constructor_result);
    }


    public AbstractNode forArrayComprehensionClause(ArrayComprehensionClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        List<Expr> bind_result = recurOnListOfExpr(that.getBind());
        Expr init_result = (Expr) recur(that.getInit());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        return forArrayComprehensionClauseOnly(that, info_result, bind_result, init_result, gens_result);
    }


    public AbstractNode forKeywordExpr(KeywordExpr that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        Expr init_result = (Expr) recur(that.getInit());
        return forKeywordExprOnly(that, info_result, name_result, init_result);
    }


    public AbstractNode forCaseClause(CaseClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Expr matchClause_result = (Expr) recur(that.getMatchClause());
        Block body_result = (Block) recur(that.getBody());
        Option<FunctionalRef> op_result = recurOnOptionOfFunctionalRef(that.getOp());
        return forCaseClauseOnly(that, info_result, matchClause_result, body_result, op_result);
    }


    public AbstractNode forCatch(Catch that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<CatchClause> clauses_result = recurOnListOfCatchClause(that.getClauses());
        return forCatchOnly(that, info_result, name_result, clauses_result);
    }


    public AbstractNode forCatchClause(CatchClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        BaseType matchType_result = (BaseType) recur(that.getMatchType());
        Block body_result = (Block) recur(that.getBody());
        return forCatchClauseOnly(that, info_result, matchType_result, body_result);
    }


    public AbstractNode forIfClause(IfClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        GeneratorClause testClause_result = (GeneratorClause) recur(that.getTestClause());
        Block body_result = (Block) recur(that.getBody());
        return forIfClauseOnly(that, info_result, testClause_result, body_result);
    }


    public AbstractNode forTypecaseClause(TypecaseClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Option<Id> name_result = recurOnOptionOfId(that.getName());
        TypeOrPattern matchType_result = recurOnTypeOrPattern(that.getMatchType());
        Block body_result = (Block) recur(that.getBody());
        return forTypecaseClauseOnly(that, info_result, name_result, matchType_result, body_result);
    }


    public AbstractNode forExtentRange(ExtentRange that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Option<StaticArg> base_result = recurOnOptionOfStaticArg(that.getBase());
        Option<StaticArg> size_result = recurOnOptionOfStaticArg(that.getSize());
        Option<Op> op_result = recurOnOptionOfOp(that.getOp());
        return forExtentRangeOnly(that, info_result, base_result, size_result, op_result);
    }


    public AbstractNode forGeneratorClause(GeneratorClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        List<Id> bind_result = recurOnListOfId(that.getBind());
        Expr init_result = (Expr) recur(that.getInit());
        return forGeneratorClauseOnly(that, info_result, bind_result, init_result);
    }


    public AbstractNode forKeywordType(KeywordType that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        Type keywordType_result = (Type) recur(that.getKeywordType());
        return forKeywordTypeOnly(that, info_result, name_result, keywordType_result);
    }


    public AbstractNode forTraitTypeWhere(TraitTypeWhere that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        BaseType baseType_result = (BaseType) recur(that.getBaseType());
        Option<WhereClause> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        return forTraitTypeWhereOnly(that, info_result, baseType_result, whereClause_result);
    }


    public AbstractNode forIndices(Indices that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        List<ExtentRange> extents_result = recurOnListOfExtentRange(that.getExtents());
        return forIndicesOnly(that, info_result, extents_result);
    }


    public AbstractNode forParenthesisDelimitedMI(ParenthesisDelimitedMI that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Expr expr_result = (Expr) recur(that.getExpr());
        return forParenthesisDelimitedMIOnly(that, info_result, expr_result);
    }


    public AbstractNode forNonParenthesisDelimitedMI(NonParenthesisDelimitedMI that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Expr expr_result = (Expr) recur(that.getExpr());
        return forNonParenthesisDelimitedMIOnly(that, info_result, expr_result);
    }


    public AbstractNode forExponentiationMI(ExponentiationMI that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        FunctionalRef op_result = (FunctionalRef) recur(that.getOp());
        Option<Expr> expr_result = recurOnOptionOfExpr(that.getExpr());
        return forExponentiationMIOnly(that, info_result, op_result, expr_result);
    }


    public AbstractNode forSubscriptingMI(SubscriptingMI that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Op op_result = (Op) recur(that.getOp());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return forSubscriptingMIOnly(that, info_result, op_result, exprs_result, staticArgs_result);
    }


    public AbstractNode forOverloading(Overloading that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        IdOrOp unambiguousName_result = (IdOrOp) recur(that.getUnambiguousName());
        IdOrOp originalName_result = (IdOrOp) recur(that.getOriginalName());
        Option<ArrowType> type_result = recurOnOptionOfArrowType(that.getType());
        Option<ArrowType> schema_result = recurOnOptionOfArrowType(that.getSchema());
        return forOverloadingOnly(that, info_result, unambiguousName_result, originalName_result, type_result, schema_result);
    }


    public AbstractNode forNonterminalHeader(NonterminalHeader that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        List<NonterminalParameter> params_result = recurOnListOfNonterminalParameter(that.getParams());
        List<StaticParam> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        Option<Type> paramType_result = recurOnOptionOfType(that.getParamType());
        Option<WhereClause> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        return forNonterminalHeaderOnly(that, info_result, name_result, params_result, staticParams_result, paramType_result, whereClause_result);
    }


    public AbstractNode forNonterminalParameter(NonterminalParameter that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id name_result = (Id) recur(that.getName());
        BaseType paramType_result = (BaseType) recur(that.getParamType());
        return forNonterminalParameterOnly(that, info_result, name_result, paramType_result);
    }


    public AbstractNode forSyntaxDef(SyntaxDef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        List<SyntaxSymbol> syntaxSymbols_result = recurOnListOfSyntaxSymbol(that.getSyntaxSymbols());
        TransformerDecl transformer_result = (TransformerDecl) recur(that.getTransformer());
        return forSyntaxDefOnly(that, info_result, syntaxSymbols_result, transformer_result);
    }


    public AbstractNode forSuperSyntaxDef(SuperSyntaxDef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id nonterminal_result = (Id) recur(that.getNonterminal());
        Id grammarId_result = (Id) recur(that.getGrammarId());
        return forSuperSyntaxDefOnly(that, info_result, nonterminal_result, grammarId_result);
    }


    public AbstractNode forPreTransformerDef(PreTransformerDef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Transformer transformer_result = (Transformer) recur(that.getTransformer());
        return forPreTransformerDefOnly(that, info_result, transformer_result);
    }


    public AbstractNode forNamedTransformerDef(NamedTransformerDef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        List<NonterminalParameter> parameters_result = recurOnListOfNonterminalParameter(that.getParameters());
        Transformer transformer_result = (Transformer) recur(that.getTransformer());
        return forNamedTransformerDefOnly(that, info_result, parameters_result, transformer_result);
    }


    public AbstractNode forUnparsedTransformer(UnparsedTransformer that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id nonterminal_result = (Id) recur(that.getNonterminal());
        return forUnparsedTransformerOnly(that, info_result, nonterminal_result);
    }


    public AbstractNode forNodeTransformer(NodeTransformer that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        AbstractNode node_result = recur(that.getNode());
        return forNodeTransformerOnly(that, info_result, node_result);
    }


    public AbstractNode forCaseTransformer(CaseTransformer that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapName_result = (Id) recur(that.getGapName());
        List<CaseTransformerClause> clauses_result = recurOnListOfCaseTransformerClause(that.getClauses());
        return forCaseTransformerOnly(that, info_result, gapName_result, clauses_result);
    }


    public AbstractNode forCaseTransformerClause(CaseTransformerClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id constructor_result = (Id) recur(that.getConstructor());
        List<Id> parameters_result = recurOnListOfId(that.getParameters());
        Transformer body_result = (Transformer) recur(that.getBody());
        return forCaseTransformerClauseOnly(that, info_result, constructor_result, parameters_result, body_result);
    }


    public AbstractNode forPrefixedSymbol(PrefixedSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id id_result = (Id) recur(that.getId());
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        return forPrefixedSymbolOnly(that, info_result, id_result, symbol_result);
    }


    public AbstractNode forOptionalSymbol(OptionalSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        return forOptionalSymbolOnly(that, info_result, symbol_result);
    }


    public AbstractNode forRepeatSymbol(RepeatSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        return forRepeatSymbolOnly(that, info_result, symbol_result);
    }


    public AbstractNode forRepeatOneOrMoreSymbol(RepeatOneOrMoreSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        return forRepeatOneOrMoreSymbolOnly(that, info_result, symbol_result);
    }


    public AbstractNode forNoWhitespaceSymbol(NoWhitespaceSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        return forNoWhitespaceSymbolOnly(that, info_result, symbol_result);
    }


    public AbstractNode forGroupSymbol(GroupSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        List<SyntaxSymbol> symbols_result = recurOnListOfSyntaxSymbol(that.getSymbols());
        return forGroupSymbolOnly(that, info_result, symbols_result);
    }


    public AbstractNode forAnyCharacterSymbol(AnyCharacterSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return forAnyCharacterSymbolOnly(that, info_result);
    }


    public AbstractNode forWhitespaceSymbol(WhitespaceSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return forWhitespaceSymbolOnly(that, info_result);
    }


    public AbstractNode forTabSymbol(TabSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return forTabSymbolOnly(that, info_result);
    }


    public AbstractNode forFormfeedSymbol(FormfeedSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return forFormfeedSymbolOnly(that, info_result);
    }


    public AbstractNode forCarriageReturnSymbol(CarriageReturnSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return forCarriageReturnSymbolOnly(that, info_result);
    }


    public AbstractNode forBackspaceSymbol(BackspaceSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return forBackspaceSymbolOnly(that, info_result);
    }


    public AbstractNode forNewlineSymbol(NewlineSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return forNewlineSymbolOnly(that, info_result);
    }


    public AbstractNode forBreaklineSymbol(BreaklineSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return forBreaklineSymbolOnly(that, info_result);
    }


    public AbstractNode forItemSymbol(ItemSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return forItemSymbolOnly(that, info_result);
    }


    public AbstractNode forNonterminalSymbol(NonterminalSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id nonterminal_result = (Id) recur(that.getNonterminal());
        return forNonterminalSymbolOnly(that, info_result, nonterminal_result);
    }


    public AbstractNode forKeywordSymbol(KeywordSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return forKeywordSymbolOnly(that, info_result);
    }


    public AbstractNode forTokenSymbol(TokenSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return forTokenSymbolOnly(that, info_result);
    }


    public AbstractNode forNotPredicateSymbol(NotPredicateSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        return forNotPredicateSymbolOnly(that, info_result, symbol_result);
    }


    public AbstractNode forAndPredicateSymbol(AndPredicateSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        return forAndPredicateSymbolOnly(that, info_result, symbol_result);
    }


    public AbstractNode forCharacterClassSymbol(CharacterClassSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        List<CharacterSymbol> characters_result = recurOnListOfCharacterSymbol(that.getCharacters());
        return forCharacterClassSymbolOnly(that, info_result, characters_result);
    }


    public AbstractNode forCharSymbol(CharSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return forCharSymbolOnly(that, info_result);
    }


    public AbstractNode forCharacterInterval(CharacterInterval that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return forCharacterIntervalOnly(that, info_result);
    }


    public AbstractNode forLink(Link that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        FunctionalRef op_result = (FunctionalRef) recur(that.getOp());
        Expr expr_result = (Expr) recur(that.getExpr());
        return forLinkOnly(that, info_result, op_result, expr_result);
    }


    public AbstractNode for_SyntaxTransformationAbstractNode(_SyntaxTransformationAbstractNode that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationAbstractNodeOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationCompilationUnit(_SyntaxTransformationCompilationUnit that) {
        APIName name_result = (APIName) recur(that.getName());
        List<Import> imports_result = recurOnListOfImport(that.getImports());
        List<Decl> decls_result = recurOnListOfDecl(that.getDecls());
        List<APIName> comprises_result = recurOnListOfAPIName(that.getComprises());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationCompilationUnitOnly(that, name_result, imports_result, decls_result, comprises_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationComponent(_SyntaxTransformationComponent that) {
        APIName name_result = (APIName) recur(that.getName());
        List<Import> imports_result = recurOnListOfImport(that.getImports());
        List<Decl> decls_result = recurOnListOfDecl(that.getDecls());
        List<APIName> comprises_result = recurOnListOfAPIName(that.getComprises());
        List<APIName> exports_result = recurOnListOfAPIName(that.getExports());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationComponentOnly(that, name_result, imports_result, decls_result, comprises_result, exports_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationApi(_SyntaxTransformationApi that) {
        APIName name_result = (APIName) recur(that.getName());
        List<Import> imports_result = recurOnListOfImport(that.getImports());
        List<Decl> decls_result = recurOnListOfDecl(that.getDecls());
        List<APIName> comprises_result = recurOnListOfAPIName(that.getComprises());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationApiOnly(that, name_result, imports_result, decls_result, comprises_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationImport(_SyntaxTransformationImport that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationImportOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationImportedNames(_SyntaxTransformationImportedNames that) {
        APIName apiName_result = (APIName) recur(that.getApiName());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationImportedNamesOnly(that, apiName_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationImportStar(_SyntaxTransformationImportStar that) {
        APIName apiName_result = (APIName) recur(that.getApiName());
        List<IdOrOpOrAnonymousName> exceptNames_result = recurOnListOfIdOrOpOrAnonymousName(that.getExceptNames());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationImportStarOnly(that, apiName_result, exceptNames_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationImportNames(_SyntaxTransformationImportNames that) {
        APIName apiName_result = (APIName) recur(that.getApiName());
        List<AliasedSimpleName> aliasedNames_result = recurOnListOfAliasedSimpleName(that.getAliasedNames());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationImportNamesOnly(that, apiName_result, aliasedNames_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationImportApi(_SyntaxTransformationImportApi that) {
        List<AliasedAPIName> apis_result = recurOnListOfAliasedAPIName(that.getApis());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationImportApiOnly(that, apis_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationAliasedSimpleName(_SyntaxTransformationAliasedSimpleName that) {
        IdOrOpOrAnonymousName name_result = (IdOrOpOrAnonymousName) recur(that.getName());
        Option<IdOrOpOrAnonymousName> alias_result = recurOnOptionOfIdOrOpOrAnonymousName(that.getAlias());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationAliasedSimpleNameOnly(that, name_result, alias_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationAliasedAPIName(_SyntaxTransformationAliasedAPIName that) {
        APIName apiName_result = (APIName) recur(that.getApiName());
        Option<Id> alias_result = recurOnOptionOfId(that.getAlias());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationAliasedAPINameOnly(that, apiName_result, alias_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationDecl(_SyntaxTransformationDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationDeclOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationTraitObjectDecl(_SyntaxTransformationTraitObjectDecl that) {
        TraitTypeHeader header_result = recurOnTraitTypeHeader(that.getHeader());
        Option<SelfType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationTraitObjectDeclOnly(that, header_result, selfType_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTraitDecl(_SyntaxTransformationTraitDecl that) {
        TraitTypeHeader header_result = recurOnTraitTypeHeader(that.getHeader());
        Option<SelfType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        List<BaseType> excludesClause_result = recurOnListOfBaseType(that.getExcludesClause());
        Option<List<NamedType>> comprisesClause_result = recurOnOptionOfListOfNamedType(that.getComprisesClause());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationTraitDeclOnly(that, header_result, selfType_result, excludesClause_result, comprisesClause_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationObjectDecl(_SyntaxTransformationObjectDecl that) {
        TraitTypeHeader header_result = recurOnTraitTypeHeader(that.getHeader());
        Option<SelfType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationObjectDeclOnly(that, header_result, selfType_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationVarDecl(_SyntaxTransformationVarDecl that) {
        List<LValue> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<Expr> init_result = recurOnOptionOfExpr(that.getInit());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationVarDeclOnly(that, lhs_result, init_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationFnDecl(_SyntaxTransformationFnDecl that) {
        FnHeader header_result = recurOnFnHeader(that.getHeader());
        IdOrOp unambiguousName_result = (IdOrOp) recur(that.getUnambiguousName());
        Option<Expr> body_result = recurOnOptionOfExpr(that.getBody());
        Option<IdOrOp> implementsUnambiguousName_result = recurOnOptionOfIdOrOp(that.getImplementsUnambiguousName());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationFnDeclOnly(that, header_result, unambiguousName_result, body_result, implementsUnambiguousName_result, info_result);
    }


    public AbstractNode for_SyntaxTransformation_RewriteFnOverloadDecl(_SyntaxTransformation_RewriteFnOverloadDecl that) {
        IdOrOp name_result = (IdOrOp) recur(that.getName());
        List<IdOrOp> fns_result = recurOnListOfIdOrOp(that.getFns());
        Option<Type> type_result = recurOnOptionOfType(that.getType());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformation_RewriteFnOverloadDeclOnly(that, name_result, fns_result, type_result, info_result);
    }


    public AbstractNode for_SyntaxTransformation_RewriteObjectExprDecl(_SyntaxTransformation_RewriteObjectExprDecl that) {
        List<_RewriteObjectExpr> objectExprs_result = recurOnListOf_RewriteObjectExpr(that.getObjectExprs());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformation_RewriteObjectExprDeclOnly(that, objectExprs_result, info_result);
    }


    public AbstractNode for_SyntaxTransformation_RewriteFunctionalMethodDecl(_SyntaxTransformation_RewriteFunctionalMethodDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformation_RewriteFunctionalMethodDeclOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationDimUnitDecl(_SyntaxTransformationDimUnitDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationDimUnitDeclOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationDimDecl(_SyntaxTransformationDimDecl that) {
        Id dimId_result = (Id) recur(that.getDimId());
        Option<Type> derived_result = recurOnOptionOfType(that.getDerived());
        Option<Id> defaultId_result = recurOnOptionOfId(that.getDefaultId());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationDimDeclOnly(that, dimId_result, derived_result, defaultId_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationUnitDecl(_SyntaxTransformationUnitDecl that) {
        List<Id> units_result = recurOnListOfId(that.getUnits());
        Option<Type> dimType_result = recurOnOptionOfType(that.getDimType());
        Option<Expr> defExpr_result = recurOnOptionOfExpr(that.getDefExpr());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationUnitDeclOnly(that, units_result, dimType_result, defExpr_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTestDecl(_SyntaxTransformationTestDecl that) {
        Id name_result = (Id) recur(that.getName());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        Expr expr_result = (Expr) recur(that.getExpr());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationTestDeclOnly(that, name_result, gens_result, expr_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationPropertyDecl(_SyntaxTransformationPropertyDecl that) {
        Option<Id> name_result = recurOnOptionOfId(that.getName());
        List<Param> params_result = recurOnListOfParam(that.getParams());
        Expr expr_result = (Expr) recur(that.getExpr());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationPropertyDeclOnly(that, name_result, params_result, expr_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTypeAlias(_SyntaxTransformationTypeAlias that) {
        Id name_result = (Id) recur(that.getName());
        List<StaticParam> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        Type typeDef_result = (Type) recur(that.getTypeDef());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationTypeAliasOnly(that, name_result, staticParams_result, typeDef_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationGrammarDecl(_SyntaxTransformationGrammarDecl that) {
        Id name_result = (Id) recur(that.getName());
        List<Id> extendsClause_result = recurOnListOfId(that.getExtendsClause());
        List<GrammarMemberDecl> members_result = recurOnListOfGrammarMemberDecl(that.getMembers());
        List<TransformerDecl> transformers_result = recurOnListOfTransformerDecl(that.getTransformers());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationGrammarDeclOnly(that, name_result, extendsClause_result, members_result, transformers_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationGrammarMemberDecl(_SyntaxTransformationGrammarMemberDecl that) {
        Id name_result = (Id) recur(that.getName());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationGrammarMemberDeclOnly(that, name_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationNonterminalDecl(_SyntaxTransformationNonterminalDecl that) {
        Id name_result = (Id) recur(that.getName());
        List<SyntaxDecl> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationNonterminalDeclOnly(that, name_result, syntaxDecls_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationNonterminalDef(_SyntaxTransformationNonterminalDef that) {
        Id name_result = (Id) recur(that.getName());
        List<SyntaxDecl> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        NonterminalHeader header_result = (NonterminalHeader) recur(that.getHeader());
        Option<BaseType> astType_result = recurOnOptionOfBaseType(that.getAstType());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationNonterminalDefOnly(that, name_result, syntaxDecls_result, header_result, astType_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationNonterminalExtensionDef(_SyntaxTransformationNonterminalExtensionDef that) {
        Id name_result = (Id) recur(that.getName());
        List<SyntaxDecl> syntaxDecls_result = recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationNonterminalExtensionDefOnly(that, name_result, syntaxDecls_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationBinding(_SyntaxTransformationBinding that) {
        Id name_result = (Id) recur(that.getName());
        Option<TypeOrPattern> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationBindingOnly(that, name_result, idType_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationLValue(_SyntaxTransformationLValue that) {
        Id name_result = (Id) recur(that.getName());
        Option<TypeOrPattern> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationLValueOnly(that, name_result, idType_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationParam(_SyntaxTransformationParam that) {
        Id name_result = (Id) recur(that.getName());
        Option<TypeOrPattern> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        Option<Expr> defaultExpr_result = recurOnOptionOfExpr(that.getDefaultExpr());
        Option<Type> varargsType_result = recurOnOptionOfType(that.getVarargsType());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationParamOnly(that, name_result, idType_result, defaultExpr_result, varargsType_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationExpr(_SyntaxTransformationExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationExprOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationDummyExpr(_SyntaxTransformationDummyExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationDummyExprOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationTypeAnnotatedExpr(_SyntaxTransformationTypeAnnotatedExpr that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        Type annType_result = (Type) recur(that.getAnnType());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationTypeAnnotatedExprOnly(that, expr_result, annType_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationAsExpr(_SyntaxTransformationAsExpr that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        Type annType_result = (Type) recur(that.getAnnType());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationAsExprOnly(that, expr_result, annType_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationAsIfExpr(_SyntaxTransformationAsIfExpr that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        Type annType_result = (Type) recur(that.getAnnType());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationAsIfExprOnly(that, expr_result, annType_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationAssignment(_SyntaxTransformationAssignment that) {
        List<Lhs> lhs_result = recurOnListOfLhs(that.getLhs());
        Option<FunctionalRef> assignOp_result = recurOnOptionOfFunctionalRef(that.getAssignOp());
        Expr rhs_result = (Expr) recur(that.getRhs());
        List<CompoundAssignmentInfo> assignmentInfos_result = recurOnListOfCompoundAssignmentInfo(that.getAssignmentInfos());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationAssignmentOnly(that, lhs_result, assignOp_result, rhs_result, assignmentInfos_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationBlock(_SyntaxTransformationBlock that) {
        Option<Expr> loc_result = recurOnOptionOfExpr(that.getLoc());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationBlockOnly(that, loc_result, exprs_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationDo(_SyntaxTransformationDo that) {
        List<Block> fronts_result = recurOnListOfBlock(that.getFronts());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationDoOnly(that, fronts_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationCaseExpr(_SyntaxTransformationCaseExpr that) {
        Option<Expr> param_result = recurOnOptionOfExpr(that.getParam());
        Option<FunctionalRef> compare_result = recurOnOptionOfFunctionalRef(that.getCompare());
        FunctionalRef equalsOp_result = (FunctionalRef) recur(that.getEqualsOp());
        FunctionalRef inOp_result = (FunctionalRef) recur(that.getInOp());
        List<CaseClause> clauses_result = recurOnListOfCaseClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationCaseExprOnly(that, param_result, compare_result, equalsOp_result, inOp_result, clauses_result, elseClause_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationIf(_SyntaxTransformationIf that) {
        List<IfClause> clauses_result = recurOnListOfIfClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationIfOnly(that, clauses_result, elseClause_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationLabel(_SyntaxTransformationLabel that) {
        Id name_result = (Id) recur(that.getName());
        Block body_result = (Block) recur(that.getBody());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationLabelOnly(that, name_result, body_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationAbstractObjectExpr(_SyntaxTransformationAbstractObjectExpr that) {
        TraitTypeHeader header_result = recurOnTraitTypeHeader(that.getHeader());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationAbstractObjectExprOnly(that, header_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationObjectExpr(_SyntaxTransformationObjectExpr that) {
        TraitTypeHeader header_result = recurOnTraitTypeHeader(that.getHeader());
        Option<SelfType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationObjectExprOnly(that, header_result, selfType_result, info_result);
    }


    public AbstractNode for_SyntaxTransformation_RewriteObjectExpr(_SyntaxTransformation_RewriteObjectExpr that) {
        TraitTypeHeader header_result = recurOnTraitTypeHeader(that.getHeader());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformation_RewriteObjectExprOnly(that, header_result, staticArgs_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTry(_SyntaxTransformationTry that) {
        Block body_result = (Block) recur(that.getBody());
        Option<Catch> catchClause_result = recurOnOptionOfCatch(that.getCatchClause());
        List<BaseType> forbidClause_result = recurOnListOfBaseType(that.getForbidClause());
        Option<Block> finallyClause_result = recurOnOptionOfBlock(that.getFinallyClause());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationTryOnly(that, body_result, catchClause_result, forbidClause_result, finallyClause_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTupleExpr(_SyntaxTransformationTupleExpr that) {
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        Option<Expr> varargs_result = recurOnOptionOfExpr(that.getVarargs());
        List<KeywordExpr> keywords_result = recurOnListOfKeywordExpr(that.getKeywords());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationTupleExprOnly(that, exprs_result, varargs_result, keywords_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTypecase(_SyntaxTransformationTypecase that) {
        Expr bindExpr_result = (Expr) recur(that.getBindExpr());
        List<TypecaseClause> clauses_result = recurOnListOfTypecaseClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationTypecaseOnly(that, bindExpr_result, clauses_result, elseClause_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationWhile(_SyntaxTransformationWhile that) {
        GeneratorClause testExpr_result = (GeneratorClause) recur(that.getTestExpr());
        Do body_result = (Do) recur(that.getBody());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationWhileOnly(that, testExpr_result, body_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationFor(_SyntaxTransformationFor that) {
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        Block body_result = (Block) recur(that.getBody());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationForOnly(that, gens_result, body_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationBigOpApp(_SyntaxTransformationBigOpApp that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationBigOpAppOnly(that, staticArgs_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationAccumulator(_SyntaxTransformationAccumulator that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Op accOp_result = (Op) recur(that.getAccOp());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        Expr body_result = (Expr) recur(that.getBody());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationAccumulatorOnly(that, staticArgs_result, accOp_result, gens_result, body_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationArrayComprehension(_SyntaxTransformationArrayComprehension that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<ArrayComprehensionClause> clauses_result = recurOnListOfArrayComprehensionClause(that.getClauses());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationArrayComprehensionOnly(that, staticArgs_result, clauses_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationAtomicExpr(_SyntaxTransformationAtomicExpr that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationAtomicExprOnly(that, expr_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationExit(_SyntaxTransformationExit that) {
        Option<Id> target_result = recurOnOptionOfId(that.getTarget());
        Option<Expr> returnExpr_result = recurOnOptionOfExpr(that.getReturnExpr());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationExitOnly(that, target_result, returnExpr_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationSpawn(_SyntaxTransformationSpawn that) {
        Expr body_result = (Expr) recur(that.getBody());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationSpawnOnly(that, body_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationThrow(_SyntaxTransformationThrow that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationThrowOnly(that, expr_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTryAtomicExpr(_SyntaxTransformationTryAtomicExpr that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationTryAtomicExprOnly(that, expr_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationFnExpr(_SyntaxTransformationFnExpr that) {
        FnHeader header_result = recurOnFnHeader(that.getHeader());
        Expr body_result = (Expr) recur(that.getBody());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationFnExprOnly(that, header_result, body_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationLetExpr(_SyntaxTransformationLetExpr that) {
        Block body_result = (Block) recur(that.getBody());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationLetExprOnly(that, body_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationLetFn(_SyntaxTransformationLetFn that) {
        Block body_result = (Block) recur(that.getBody());
        List<FnDecl> fns_result = recurOnListOfFnDecl(that.getFns());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationLetFnOnly(that, body_result, fns_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationLocalVarDecl(_SyntaxTransformationLocalVarDecl that) {
        Block body_result = (Block) recur(that.getBody());
        List<LValue> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<Expr> rhs_result = recurOnOptionOfExpr(that.getRhs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationLocalVarDeclOnly(that, body_result, lhs_result, rhs_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationSimpleExpr(_SyntaxTransformationSimpleExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationSimpleExprOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationSubscriptExpr(_SyntaxTransformationSubscriptExpr that) {
        Expr obj_result = (Expr) recur(that.getObj());
        List<Expr> subs_result = recurOnListOfExpr(that.getSubs());
        Option<Op> op_result = recurOnOptionOfOp(that.getOp());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationSubscriptExprOnly(that, obj_result, subs_result, op_result, staticArgs_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationPrimary(_SyntaxTransformationPrimary that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationPrimaryOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationLiteralExpr(_SyntaxTransformationLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationLiteralExprOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationNumberLiteralExpr(_SyntaxTransformationNumberLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationNumberLiteralExprOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationFloatLiteralExpr(_SyntaxTransformationFloatLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationFloatLiteralExprOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationIntLiteralExpr(_SyntaxTransformationIntLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationIntLiteralExprOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationCharLiteralExpr(_SyntaxTransformationCharLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationCharLiteralExprOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationStringLiteralExpr(_SyntaxTransformationStringLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationStringLiteralExprOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationVoidLiteralExpr(_SyntaxTransformationVoidLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationVoidLiteralExprOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationBooleanLiteralExpr(_SyntaxTransformationBooleanLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationBooleanLiteralExprOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationVarRef(_SyntaxTransformationVarRef that) {
        Id varId_result = (Id) recur(that.getVarId());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationVarRefOnly(that, varId_result, staticArgs_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationFieldRef(_SyntaxTransformationFieldRef that) {
        Expr obj_result = (Expr) recur(that.getObj());
        Id field_result = (Id) recur(that.getField());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationFieldRefOnly(that, obj_result, field_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationFunctionalRef(_SyntaxTransformationFunctionalRef that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        IdOrOp originalName_result = (IdOrOp) recur(that.getOriginalName());
        List<IdOrOp> names_result = recurOnListOfIdOrOp(that.getNames());
        List<Overloading> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<Overloading> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationFunctionalRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationFnRef(_SyntaxTransformationFnRef that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        IdOrOp originalName_result = (IdOrOp) recur(that.getOriginalName());
        List<IdOrOp> names_result = recurOnListOfIdOrOp(that.getNames());
        List<Overloading> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<Overloading> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationFnRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationOpRef(_SyntaxTransformationOpRef that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        IdOrOp originalName_result = (IdOrOp) recur(that.getOriginalName());
        List<IdOrOp> names_result = recurOnListOfIdOrOp(that.getNames());
        List<Overloading> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<Overloading> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationOpRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result, info_result);
    }


    public AbstractNode for_SyntaxTransformation_RewriteFnRef(_SyntaxTransformation_RewriteFnRef that) {
        Expr fnExpr_result = (Expr) recur(that.getFnExpr());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformation_RewriteFnRefOnly(that, fnExpr_result, staticArgs_result, info_result);
    }


    public AbstractNode for_SyntaxTransformation_RewriteObjectExprRef(_SyntaxTransformation_RewriteObjectExprRef that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformation_RewriteObjectExprRefOnly(that, staticArgs_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationJuxt(_SyntaxTransformationJuxt that) {
        FunctionalRef multiJuxt_result = (FunctionalRef) recur(that.getMultiJuxt());
        FunctionalRef infixJuxt_result = (FunctionalRef) recur(that.getInfixJuxt());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationJuxtOnly(that, multiJuxt_result, infixJuxt_result, exprs_result, info_result);
    }


    public AbstractNode for_SyntaxTransformation_RewriteFnApp(_SyntaxTransformation_RewriteFnApp that) {
        Expr function_result = (Expr) recur(that.getFunction());
        Expr argument_result = (Expr) recur(that.getArgument());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformation_RewriteFnAppOnly(that, function_result, argument_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationOpExpr(_SyntaxTransformationOpExpr that) {
        FunctionalRef op_result = (FunctionalRef) recur(that.getOp());
        List<Expr> args_result = recurOnListOfExpr(that.getArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationOpExprOnly(that, op_result, args_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationAmbiguousMultifixOpExpr(_SyntaxTransformationAmbiguousMultifixOpExpr that) {
        FunctionalRef infix_op_result = (FunctionalRef) recur(that.getInfix_op());
        FunctionalRef multifix_op_result = (FunctionalRef) recur(that.getMultifix_op());
        List<Expr> args_result = recurOnListOfExpr(that.getArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationAmbiguousMultifixOpExprOnly(that, infix_op_result, multifix_op_result, args_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationChainExpr(_SyntaxTransformationChainExpr that) {
        Expr first_result = (Expr) recur(that.getFirst());
        List<Link> links_result = recurOnListOfLink(that.getLinks());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationChainExprOnly(that, first_result, links_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationCoercionInvocation(_SyntaxTransformationCoercionInvocation that) {
        Type toType_result = (Type) recur(that.getToType());
        Expr arg_result = (Expr) recur(that.getArg());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationCoercionInvocationOnly(that, toType_result, arg_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTraitCoercionInvocation(_SyntaxTransformationTraitCoercionInvocation that) {
        Expr arg_result = (Expr) recur(that.getArg());
        TraitType toType_result = (TraitType) recur(that.getToType());
        FnRef coercionFn_result = (FnRef) recur(that.getCoercionFn());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationTraitCoercionInvocationOnly(that, arg_result, toType_result, coercionFn_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTupleCoercionInvocation(_SyntaxTransformationTupleCoercionInvocation that) {
        Expr arg_result = (Expr) recur(that.getArg());
        TupleType toType_result = (TupleType) recur(that.getToType());
        List<Option<CoercionInvocation>> subCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getSubCoercions());
        Option<Option<CoercionInvocation>> varargCoercion_result = recurOnOptionOfOptionOfCoercionInvocation(that.getVarargCoercion());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationTupleCoercionInvocationOnly(that, arg_result, toType_result, subCoercions_result, varargCoercion_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationArrowCoercionInvocation(_SyntaxTransformationArrowCoercionInvocation that) {
        Expr arg_result = (Expr) recur(that.getArg());
        ArrowType toType_result = (ArrowType) recur(that.getToType());
        Option<CoercionInvocation> domainCoercion_result = recurOnOptionOfCoercionInvocation(that.getDomainCoercion());
        Option<CoercionInvocation> rangeCoercion_result = recurOnOptionOfCoercionInvocation(that.getRangeCoercion());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationArrowCoercionInvocationOnly(that, arg_result, toType_result, domainCoercion_result, rangeCoercion_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationUnionCoercionInvocation(_SyntaxTransformationUnionCoercionInvocation that) {
        Type toType_result = (Type) recur(that.getToType());
        Expr arg_result = (Expr) recur(that.getArg());
        List<Type> fromTypes_result = recurOnListOfType(that.getFromTypes());
        List<Option<CoercionInvocation>> fromCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getFromCoercions());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationUnionCoercionInvocationOnly(that, toType_result, arg_result, fromTypes_result, fromCoercions_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationMethodInvocation(_SyntaxTransformationMethodInvocation that) {
        Expr obj_result = (Expr) recur(that.getObj());
        IdOrOp method_result = (IdOrOp) recur(that.getMethod());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Expr arg_result = (Expr) recur(that.getArg());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationMethodInvocationOnly(that, obj_result, method_result, staticArgs_result, arg_result, overloadingType_result, overloadingSchema_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationMathPrimary(_SyntaxTransformationMathPrimary that) {
        FunctionalRef multiJuxt_result = (FunctionalRef) recur(that.getMultiJuxt());
        FunctionalRef infixJuxt_result = (FunctionalRef) recur(that.getInfixJuxt());
        Expr front_result = (Expr) recur(that.getFront());
        List<MathItem> rest_result = recurOnListOfMathItem(that.getRest());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationMathPrimaryOnly(that, multiJuxt_result, infixJuxt_result, front_result, rest_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationArrayExpr(_SyntaxTransformationArrayExpr that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationArrayExprOnly(that, staticArgs_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationArrayElement(_SyntaxTransformationArrayElement that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Expr element_result = (Expr) recur(that.getElement());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationArrayElementOnly(that, staticArgs_result, element_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationArrayElements(_SyntaxTransformationArrayElements that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<ArrayExpr> elements_result = recurOnListOfArrayExpr(that.getElements());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationArrayElementsOnly(that, staticArgs_result, elements_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationType(_SyntaxTransformationType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationTypeOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationBaseType(_SyntaxTransformationBaseType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationBaseTypeOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationAnyType(_SyntaxTransformationAnyType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationAnyTypeOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationBottomType(_SyntaxTransformationBottomType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationBottomTypeOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationUnknownType(_SyntaxTransformationUnknownType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationUnknownTypeOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationSelfType(_SyntaxTransformationSelfType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationSelfTypeOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationTraitSelfType(_SyntaxTransformationTraitSelfType that) {
        BaseType named_result = (BaseType) recur(that.getNamed());
        List<NamedType> comprised_result = recurOnListOfNamedType(that.getComprised());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationTraitSelfTypeOnly(that, named_result, comprised_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationObjectExprType(_SyntaxTransformationObjectExprType that) {
        List<BaseType> extended_result = recurOnListOfBaseType(that.getExtended());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationObjectExprTypeOnly(that, extended_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationNamedType(_SyntaxTransformationNamedType that) {
        Id name_result = (Id) recur(that.getName());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationNamedTypeOnly(that, name_result, info_result);
    }


    public AbstractNode for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that) {
        Id name_result = (Id) recur(that.getName());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformation_InferenceVarTypeOnly(that, name_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationVarType(_SyntaxTransformationVarType that) {
        Id name_result = (Id) recur(that.getName());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationVarTypeOnly(that, name_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that) {
        Id name_result = (Id) recur(that.getName());
        List<StaticArg> args_result = recurOnListOfStaticArg(that.getArgs());
        List<StaticParam> traitStaticParams_result = recurOnListOfStaticParam(that.getTraitStaticParams());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationTraitTypeOnly(that, name_result, args_result, traitStaticParams_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that) {
        Type elemType_result = (Type) recur(that.getElemType());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationAbbreviatedTypeOnly(that, elemType_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that) {
        Type elemType_result = (Type) recur(that.getElemType());
        Indices indices_result = (Indices) recur(that.getIndices());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationArrayTypeOnly(that, elemType_result, indices_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that) {
        Type elemType_result = (Type) recur(that.getElemType());
        List<ExtentRange> dimensions_result = recurOnListOfExtentRange(that.getDimensions());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationMatrixTypeOnly(that, elemType_result, dimensions_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that) {
        Type elemType_result = (Type) recur(that.getElemType());
        DimExpr dimExpr_result = (DimExpr) recur(that.getDimExpr());
        Option<Expr> unitExpr_result = recurOnOptionOfExpr(that.getUnitExpr());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationTaggedDimTypeOnly(that, elemType_result, dimExpr_result, unitExpr_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that) {
        Type elemType_result = (Type) recur(that.getElemType());
        Expr unitExpr_result = (Expr) recur(that.getUnitExpr());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationTaggedUnitTypeOnly(that, elemType_result, unitExpr_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that) {
        List<Type> elements_result = recurOnListOfType(that.getElements());
        Option<Type> varargs_result = recurOnOptionOfType(that.getVarargs());
        List<KeywordType> keywords_result = recurOnListOfKeywordType(that.getKeywords());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationTupleTypeOnly(that, elements_result, varargs_result, keywords_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that) {
        Type domain_result = (Type) recur(that.getDomain());
        Type range_result = (Type) recur(that.getRange());
        Effect effect_result = (Effect) recur(that.getEffect());
        Option<MethodInfo> methodInfo_result = recurOnOptionOfMethodInfo(that.getMethodInfo());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationArrowTypeOnly(that, domain_result, range_result, effect_result, methodInfo_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationBoundType(_SyntaxTransformationBoundType that) {
        List<Type> elements_result = recurOnListOfType(that.getElements());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationBoundTypeOnly(that, elements_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationIntersectionType(_SyntaxTransformationIntersectionType that) {
        List<Type> elements_result = recurOnListOfType(that.getElements());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationIntersectionTypeOnly(that, elements_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationUnionType(_SyntaxTransformationUnionType that) {
        List<Type> elements_result = recurOnListOfType(that.getElements());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationUnionTypeOnly(that, elements_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationFixedPointType(_SyntaxTransformationFixedPointType that) {
        _InferenceVarType name_result = (_InferenceVarType) recur(that.getName());
        Type body_result = (Type) recur(that.getBody());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationFixedPointTypeOnly(that, name_result, body_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationLabelType(_SyntaxTransformationLabelType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationLabelTypeOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationDimExpr(_SyntaxTransformationDimExpr that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationDimExprOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationDimBase(_SyntaxTransformationDimBase that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationDimBaseOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationDimRef(_SyntaxTransformationDimRef that) {
        Id name_result = (Id) recur(that.getName());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationDimRefOnly(that, name_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that) {
        Type base_result = (Type) recur(that.getBase());
        IntExpr power_result = (IntExpr) recur(that.getPower());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationDimExponentOnly(that, base_result, power_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that) {
        DimExpr dimVal_result = (DimExpr) recur(that.getDimVal());
        Op op_result = (Op) recur(that.getOp());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationDimUnaryOpOnly(that, dimVal_result, op_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that) {
        DimExpr left_result = (DimExpr) recur(that.getLeft());
        DimExpr right_result = (DimExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        return for_SyntaxTransformationDimBinaryOpOnly(that, left_result, right_result, op_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationPattern(_SyntaxTransformationPattern that) {
        Option<Type> name_result = recurOnOptionOfType(that.getName());
        PatternArgs patterns_result = (PatternArgs) recur(that.getPatterns());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationPatternOnly(that, name_result, patterns_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationPatternArgs(_SyntaxTransformationPatternArgs that) {
        List<PatternBinding> patterns_result = recurOnListOfPatternBinding(that.getPatterns());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationPatternArgsOnly(that, patterns_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationPatternBinding(_SyntaxTransformationPatternBinding that) {
        Option<Id> field_result = recurOnOptionOfId(that.getField());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationPatternBindingOnly(that, field_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationPlainPattern(_SyntaxTransformationPlainPattern that) {
        Option<Id> field_result = recurOnOptionOfId(that.getField());
        Id name_result = (Id) recur(that.getName());
        Option<TypeOrPattern> idType_result = recurOnOptionOfTypeOrPattern(that.getIdType());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationPlainPatternOnly(that, field_result, name_result, idType_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTypePattern(_SyntaxTransformationTypePattern that) {
        Option<Id> field_result = recurOnOptionOfId(that.getField());
        Type typ_result = (Type) recur(that.getTyp());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationTypePatternOnly(that, field_result, typ_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationNestedPattern(_SyntaxTransformationNestedPattern that) {
        Option<Id> field_result = recurOnOptionOfId(that.getField());
        Pattern pat_result = (Pattern) recur(that.getPat());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationNestedPatternOnly(that, field_result, pat_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationStaticArgOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that) {
        Type typeArg_result = (Type) recur(that.getTypeArg());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationTypeArgOnly(that, typeArg_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that) {
        IntExpr intVal_result = (IntExpr) recur(that.getIntVal());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationIntArgOnly(that, intVal_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that) {
        BoolExpr boolArg_result = (BoolExpr) recur(that.getBoolArg());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationBoolArgOnly(that, boolArg_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that) {
        Op id_result = (Op) recur(that.getId());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationOpArgOnly(that, id_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that) {
        DimExpr dimArg_result = (DimExpr) recur(that.getDimArg());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationDimArgOnly(that, dimArg_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that) {
        UnitExpr unitArg_result = (UnitExpr) recur(that.getUnitArg());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationUnitArgOnly(that, unitArg_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationStaticExpr(_SyntaxTransformationStaticExpr that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationStaticExprOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationIntExpr(_SyntaxTransformationIntExpr that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationIntExprOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationIntBase(_SyntaxTransformationIntBase that) {
        IntLiteralExpr intVal_result = (IntLiteralExpr) recur(that.getIntVal());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationIntBaseOnly(that, intVal_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationIntRef(_SyntaxTransformationIntRef that) {
        Id name_result = (Id) recur(that.getName());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationIntRefOnly(that, name_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationIntBinaryOp(_SyntaxTransformationIntBinaryOp that) {
        IntExpr left_result = (IntExpr) recur(that.getLeft());
        IntExpr right_result = (IntExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationIntBinaryOpOnly(that, left_result, right_result, op_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationBoolExpr(_SyntaxTransformationBoolExpr that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationBoolExprOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationBoolBase(_SyntaxTransformationBoolBase that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationBoolBaseOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationBoolRef(_SyntaxTransformationBoolRef that) {
        Id name_result = (Id) recur(that.getName());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationBoolRefOnly(that, name_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationBoolConstraint(_SyntaxTransformationBoolConstraint that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationBoolConstraintOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationBoolUnaryOp(_SyntaxTransformationBoolUnaryOp that) {
        BoolExpr boolVal_result = (BoolExpr) recur(that.getBoolVal());
        Op op_result = (Op) recur(that.getOp());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationBoolUnaryOpOnly(that, boolVal_result, op_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationBoolBinaryOp(_SyntaxTransformationBoolBinaryOp that) {
        BoolExpr left_result = (BoolExpr) recur(that.getLeft());
        BoolExpr right_result = (BoolExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationBoolBinaryOpOnly(that, left_result, right_result, op_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationUnitExpr(_SyntaxTransformationUnitExpr that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationUnitExprOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationUnitRef(_SyntaxTransformationUnitRef that) {
        Id name_result = (Id) recur(that.getName());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationUnitRefOnly(that, name_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationUnitBinaryOp(_SyntaxTransformationUnitBinaryOp that) {
        UnitExpr left_result = (UnitExpr) recur(that.getLeft());
        UnitExpr right_result = (UnitExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationUnitBinaryOpOnly(that, left_result, right_result, op_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationEffect(_SyntaxTransformationEffect that) {
        Option<List<Type>> throwsClause_result = recurOnOptionOfListOfType(that.getThrowsClause());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationEffectOnly(that, throwsClause_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationWhereClause(_SyntaxTransformationWhereClause that) {
        List<WhereBinding> bindings_result = recurOnListOfWhereBinding(that.getBindings());
        List<WhereConstraint> constraints_result = recurOnListOfWhereConstraint(that.getConstraints());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationWhereClauseOnly(that, bindings_result, constraints_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationWhereBinding(_SyntaxTransformationWhereBinding that) {
        Id name_result = (Id) recur(that.getName());
        List<BaseType> supers_result = recurOnListOfBaseType(that.getSupers());
        StaticParamKind kind_result = recurOnStaticParamKind(that.getKind());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationWhereBindingOnly(that, name_result, supers_result, kind_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationWhereConstraint(_SyntaxTransformationWhereConstraint that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationWhereConstraintOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationWhereExtends(_SyntaxTransformationWhereExtends that) {
        Id name_result = (Id) recur(that.getName());
        List<BaseType> supers_result = recurOnListOfBaseType(that.getSupers());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationWhereExtendsOnly(that, name_result, supers_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationWhereTypeAlias(_SyntaxTransformationWhereTypeAlias that) {
        TypeAlias alias_result = (TypeAlias) recur(that.getAlias());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationWhereTypeAliasOnly(that, alias_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationWhereCoerces(_SyntaxTransformationWhereCoerces that) {
        Type left_result = (Type) recur(that.getLeft());
        Type right_result = (Type) recur(that.getRight());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationWhereCoercesOnly(that, left_result, right_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationWhereEquals(_SyntaxTransformationWhereEquals that) {
        Id left_result = (Id) recur(that.getLeft());
        Id right_result = (Id) recur(that.getRight());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationWhereEqualsOnly(that, left_result, right_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationUnitConstraint(_SyntaxTransformationUnitConstraint that) {
        Id name_result = (Id) recur(that.getName());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationUnitConstraintOnly(that, name_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationIntConstraint(_SyntaxTransformationIntConstraint that) {
        IntExpr left_result = (IntExpr) recur(that.getLeft());
        IntExpr right_result = (IntExpr) recur(that.getRight());
        Op op_result = (Op) recur(that.getOp());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationIntConstraintOnly(that, left_result, right_result, op_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationBoolConstraintExpr(_SyntaxTransformationBoolConstraintExpr that) {
        BoolConstraint constraint_result = (BoolConstraint) recur(that.getConstraint());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationBoolConstraintExprOnly(that, constraint_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationContract(_SyntaxTransformationContract that) {
        Option<List<Expr>> requiresClause_result = recurOnOptionOfListOfExpr(that.getRequiresClause());
        Option<List<EnsuresClause>> ensuresClause_result = recurOnOptionOfListOfEnsuresClause(that.getEnsuresClause());
        Option<List<Expr>> invariantsClause_result = recurOnOptionOfListOfExpr(that.getInvariantsClause());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationContractOnly(that, requiresClause_result, ensuresClause_result, invariantsClause_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationEnsuresClause(_SyntaxTransformationEnsuresClause that) {
        Expr post_result = (Expr) recur(that.getPost());
        Option<Expr> pre_result = recurOnOptionOfExpr(that.getPre());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationEnsuresClauseOnly(that, post_result, pre_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationStaticParam(_SyntaxTransformationStaticParam that) {
        IdOrOp name_result = (IdOrOp) recur(that.getName());
        List<BaseType> extendsClause_result = recurOnListOfBaseType(that.getExtendsClause());
        List<BaseType> dominatesClause_result = recurOnListOfBaseType(that.getDominatesClause());
        Option<Type> dimParam_result = recurOnOptionOfType(that.getDimParam());
        StaticParamKind kind_result = recurOnStaticParamKind(that.getKind());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationStaticParamOnly(that, name_result, extendsClause_result, dominatesClause_result, dimParam_result, kind_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationName(_SyntaxTransformationName that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationNameOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationAPIName(_SyntaxTransformationAPIName that) {
        List<Id> ids_result = recurOnListOfId(that.getIds());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationAPINameOnly(that, ids_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationIdOrOpOrAnonymousName(_SyntaxTransformationIdOrOpOrAnonymousName that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationIdOrOpOrAnonymousNameOnly(that, apiName_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationIdOrOp(_SyntaxTransformationIdOrOp that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationIdOrOpOnly(that, apiName_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationId(_SyntaxTransformationId that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationIdOnly(that, apiName_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationOp(_SyntaxTransformationOp that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        Fixity fixity_result = recurOnFixity(that.getFixity());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationOpOnly(that, apiName_result, fixity_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationNamedOp(_SyntaxTransformationNamedOp that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        Fixity fixity_result = recurOnFixity(that.getFixity());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationNamedOpOnly(that, apiName_result, fixity_result, info_result);
    }


    public AbstractNode for_SyntaxTransformation_InferenceVarOp(_SyntaxTransformation_InferenceVarOp that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        Fixity fixity_result = recurOnFixity(that.getFixity());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformation_InferenceVarOpOnly(that, apiName_result, fixity_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationAnonymousName(_SyntaxTransformationAnonymousName that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationAnonymousNameOnly(that, apiName_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationAnonymousFnName(_SyntaxTransformationAnonymousFnName that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationAnonymousFnNameOnly(that, apiName_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationConstructorFnName(_SyntaxTransformationConstructorFnName that) {
        Option<APIName> apiName_result = recurOnOptionOfAPIName(that.getApiName());
        ObjectConstructor constructor_result = recurOnObjectConstructor(that.getConstructor());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationConstructorFnNameOnly(that, apiName_result, constructor_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationArrayComprehensionClause(_SyntaxTransformationArrayComprehensionClause that) {
        List<Expr> bind_result = recurOnListOfExpr(that.getBind());
        Expr init_result = (Expr) recur(that.getInit());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationArrayComprehensionClauseOnly(that, bind_result, init_result, gens_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationKeywordExpr(_SyntaxTransformationKeywordExpr that) {
        Id name_result = (Id) recur(that.getName());
        Expr init_result = (Expr) recur(that.getInit());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationKeywordExprOnly(that, name_result, init_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationCaseClause(_SyntaxTransformationCaseClause that) {
        Expr matchClause_result = (Expr) recur(that.getMatchClause());
        Block body_result = (Block) recur(that.getBody());
        Option<FunctionalRef> op_result = recurOnOptionOfFunctionalRef(that.getOp());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationCaseClauseOnly(that, matchClause_result, body_result, op_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationCatch(_SyntaxTransformationCatch that) {
        Id name_result = (Id) recur(that.getName());
        List<CatchClause> clauses_result = recurOnListOfCatchClause(that.getClauses());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationCatchOnly(that, name_result, clauses_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationCatchClause(_SyntaxTransformationCatchClause that) {
        BaseType matchType_result = (BaseType) recur(that.getMatchType());
        Block body_result = (Block) recur(that.getBody());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationCatchClauseOnly(that, matchType_result, body_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationIfClause(_SyntaxTransformationIfClause that) {
        GeneratorClause testClause_result = (GeneratorClause) recur(that.getTestClause());
        Block body_result = (Block) recur(that.getBody());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationIfClauseOnly(that, testClause_result, body_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTypecaseClause(_SyntaxTransformationTypecaseClause that) {
        Option<Id> name_result = recurOnOptionOfId(that.getName());
        TypeOrPattern matchType_result = recurOnTypeOrPattern(that.getMatchType());
        Block body_result = (Block) recur(that.getBody());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationTypecaseClauseOnly(that, name_result, matchType_result, body_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationExtentRange(_SyntaxTransformationExtentRange that) {
        Option<StaticArg> base_result = recurOnOptionOfStaticArg(that.getBase());
        Option<StaticArg> size_result = recurOnOptionOfStaticArg(that.getSize());
        Option<Op> op_result = recurOnOptionOfOp(that.getOp());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationExtentRangeOnly(that, base_result, size_result, op_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationGeneratorClause(_SyntaxTransformationGeneratorClause that) {
        List<Id> bind_result = recurOnListOfId(that.getBind());
        Expr init_result = (Expr) recur(that.getInit());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationGeneratorClauseOnly(that, bind_result, init_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationKeywordType(_SyntaxTransformationKeywordType that) {
        Id name_result = (Id) recur(that.getName());
        Type keywordType_result = (Type) recur(that.getKeywordType());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationKeywordTypeOnly(that, name_result, keywordType_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTraitTypeWhere(_SyntaxTransformationTraitTypeWhere that) {
        BaseType baseType_result = (BaseType) recur(that.getBaseType());
        Option<WhereClause> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationTraitTypeWhereOnly(that, baseType_result, whereClause_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationIndices(_SyntaxTransformationIndices that) {
        List<ExtentRange> extents_result = recurOnListOfExtentRange(that.getExtents());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationIndicesOnly(that, extents_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationMathItem(_SyntaxTransformationMathItem that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationMathItemOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationExprMI(_SyntaxTransformationExprMI that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationExprMIOnly(that, expr_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationParenthesisDelimitedMI(_SyntaxTransformationParenthesisDelimitedMI that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationParenthesisDelimitedMIOnly(that, expr_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationNonParenthesisDelimitedMI(_SyntaxTransformationNonParenthesisDelimitedMI that) {
        Expr expr_result = (Expr) recur(that.getExpr());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationNonParenthesisDelimitedMIOnly(that, expr_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationNonExprMI(_SyntaxTransformationNonExprMI that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationNonExprMIOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationExponentiationMI(_SyntaxTransformationExponentiationMI that) {
        FunctionalRef op_result = (FunctionalRef) recur(that.getOp());
        Option<Expr> expr_result = recurOnOptionOfExpr(that.getExpr());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationExponentiationMIOnly(that, op_result, expr_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationSubscriptingMI(_SyntaxTransformationSubscriptingMI that) {
        Op op_result = (Op) recur(that.getOp());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationSubscriptingMIOnly(that, op_result, exprs_result, staticArgs_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationOverloading(_SyntaxTransformationOverloading that) {
        IdOrOp unambiguousName_result = (IdOrOp) recur(that.getUnambiguousName());
        IdOrOp originalName_result = (IdOrOp) recur(that.getOriginalName());
        Option<ArrowType> type_result = recurOnOptionOfArrowType(that.getType());
        Option<ArrowType> schema_result = recurOnOptionOfArrowType(that.getSchema());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationOverloadingOnly(that, unambiguousName_result, originalName_result, type_result, schema_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationNonterminalHeader(_SyntaxTransformationNonterminalHeader that) {
        Id name_result = (Id) recur(that.getName());
        List<NonterminalParameter> params_result = recurOnListOfNonterminalParameter(that.getParams());
        List<StaticParam> staticParams_result = recurOnListOfStaticParam(that.getStaticParams());
        Option<Type> paramType_result = recurOnOptionOfType(that.getParamType());
        Option<WhereClause> whereClause_result = recurOnOptionOfWhereClause(that.getWhereClause());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationNonterminalHeaderOnly(that, name_result, params_result, staticParams_result, paramType_result, whereClause_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationNonterminalParameter(_SyntaxTransformationNonterminalParameter that) {
        Id name_result = (Id) recur(that.getName());
        BaseType paramType_result = (BaseType) recur(that.getParamType());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationNonterminalParameterOnly(that, name_result, paramType_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationSyntaxDecl(_SyntaxTransformationSyntaxDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationSyntaxDeclOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationSyntaxDef(_SyntaxTransformationSyntaxDef that) {
        List<SyntaxSymbol> syntaxSymbols_result = recurOnListOfSyntaxSymbol(that.getSyntaxSymbols());
        TransformerDecl transformer_result = (TransformerDecl) recur(that.getTransformer());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationSyntaxDefOnly(that, syntaxSymbols_result, transformer_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationSuperSyntaxDef(_SyntaxTransformationSuperSyntaxDef that) {
        Id nonterminal_result = (Id) recur(that.getNonterminal());
        Id grammarId_result = (Id) recur(that.getGrammarId());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationSuperSyntaxDefOnly(that, nonterminal_result, grammarId_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTransformerDecl(_SyntaxTransformationTransformerDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationTransformerDeclOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationPreTransformerDef(_SyntaxTransformationPreTransformerDef that) {
        Transformer transformer_result = (Transformer) recur(that.getTransformer());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationPreTransformerDefOnly(that, transformer_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationNamedTransformerDef(_SyntaxTransformationNamedTransformerDef that) {
        List<NonterminalParameter> parameters_result = recurOnListOfNonterminalParameter(that.getParameters());
        Transformer transformer_result = (Transformer) recur(that.getTransformer());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationNamedTransformerDefOnly(that, parameters_result, transformer_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationTransformer(_SyntaxTransformationTransformer that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationTransformerOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationUnparsedTransformer(_SyntaxTransformationUnparsedTransformer that) {
        Id nonterminal_result = (Id) recur(that.getNonterminal());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationUnparsedTransformerOnly(that, nonterminal_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationNodeTransformer(_SyntaxTransformationNodeTransformer that) {
        AbstractNode node_result = recur(that.getNode());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationNodeTransformerOnly(that, node_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationCaseTransformer(_SyntaxTransformationCaseTransformer that) {
        Id gapName_result = (Id) recur(that.getGapName());
        List<CaseTransformerClause> clauses_result = recurOnListOfCaseTransformerClause(that.getClauses());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationCaseTransformerOnly(that, gapName_result, clauses_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationCaseTransformerClause(_SyntaxTransformationCaseTransformerClause that) {
        Id constructor_result = (Id) recur(that.getConstructor());
        List<Id> parameters_result = recurOnListOfId(that.getParameters());
        Transformer body_result = (Transformer) recur(that.getBody());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationCaseTransformerClauseOnly(that, constructor_result, parameters_result, body_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationSyntaxSymbol(_SyntaxTransformationSyntaxSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationSyntaxSymbolOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationPrefixedSymbol(_SyntaxTransformationPrefixedSymbol that) {
        Id id_result = (Id) recur(that.getId());
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationPrefixedSymbolOnly(that, id_result, symbol_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationOptionalSymbol(_SyntaxTransformationOptionalSymbol that) {
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationOptionalSymbolOnly(that, symbol_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationRepeatSymbol(_SyntaxTransformationRepeatSymbol that) {
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationRepeatSymbolOnly(that, symbol_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationRepeatOneOrMoreSymbol(_SyntaxTransformationRepeatOneOrMoreSymbol that) {
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationRepeatOneOrMoreSymbolOnly(that, symbol_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationNoWhitespaceSymbol(_SyntaxTransformationNoWhitespaceSymbol that) {
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationNoWhitespaceSymbolOnly(that, symbol_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationGroupSymbol(_SyntaxTransformationGroupSymbol that) {
        List<SyntaxSymbol> symbols_result = recurOnListOfSyntaxSymbol(that.getSymbols());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationGroupSymbolOnly(that, symbols_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationSpecialSymbol(_SyntaxTransformationSpecialSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationSpecialSymbolOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationAnyCharacterSymbol(_SyntaxTransformationAnyCharacterSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationAnyCharacterSymbolOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationWhitespaceSymbol(_SyntaxTransformationWhitespaceSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationWhitespaceSymbolOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationTabSymbol(_SyntaxTransformationTabSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationTabSymbolOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationFormfeedSymbol(_SyntaxTransformationFormfeedSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationFormfeedSymbolOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationCarriageReturnSymbol(_SyntaxTransformationCarriageReturnSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationCarriageReturnSymbolOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationBackspaceSymbol(_SyntaxTransformationBackspaceSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationBackspaceSymbolOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationNewlineSymbol(_SyntaxTransformationNewlineSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationNewlineSymbolOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationBreaklineSymbol(_SyntaxTransformationBreaklineSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationBreaklineSymbolOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationItemSymbol(_SyntaxTransformationItemSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationItemSymbolOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationNonterminalSymbol(_SyntaxTransformationNonterminalSymbol that) {
        Id nonterminal_result = (Id) recur(that.getNonterminal());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationNonterminalSymbolOnly(that, nonterminal_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationKeywordSymbol(_SyntaxTransformationKeywordSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationKeywordSymbolOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationTokenSymbol(_SyntaxTransformationTokenSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationTokenSymbolOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationNotPredicateSymbol(_SyntaxTransformationNotPredicateSymbol that) {
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationNotPredicateSymbolOnly(that, symbol_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationAndPredicateSymbol(_SyntaxTransformationAndPredicateSymbol that) {
        SyntaxSymbol symbol_result = (SyntaxSymbol) recur(that.getSymbol());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationAndPredicateSymbolOnly(that, symbol_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationCharacterClassSymbol(_SyntaxTransformationCharacterClassSymbol that) {
        List<CharacterSymbol> characters_result = recurOnListOfCharacterSymbol(that.getCharacters());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationCharacterClassSymbolOnly(that, characters_result, info_result);
    }


    public AbstractNode for_SyntaxTransformationCharacterSymbol(_SyntaxTransformationCharacterSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationCharacterSymbolOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationCharSymbol(_SyntaxTransformationCharSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationCharSymbolOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationCharacterInterval(_SyntaxTransformationCharacterInterval that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationCharacterIntervalOnly(that, info_result);
    }


    public AbstractNode for_SyntaxTransformationLink(_SyntaxTransformationLink that) {
        FunctionalRef op_result = (FunctionalRef) recur(that.getOp());
        Expr expr_result = (Expr) recur(that.getExpr());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationLinkOnly(that, op_result, expr_result, info_result);
    }


    public AbstractNode for_EllipsesAbstractNode(_EllipsesAbstractNode that) {
        return for_EllipsesAbstractNodeOnly(that);
    }


    public AbstractNode for_EllipsesCompilationUnit(_EllipsesCompilationUnit that) {
        return for_EllipsesCompilationUnitOnly(that);
    }


    public AbstractNode for_EllipsesComponent(_EllipsesComponent that) {
        return for_EllipsesComponentOnly(that);
    }


    public AbstractNode for_EllipsesApi(_EllipsesApi that) {
        return for_EllipsesApiOnly(that);
    }


    public AbstractNode for_EllipsesImport(_EllipsesImport that) {
        return for_EllipsesImportOnly(that);
    }


    public AbstractNode for_EllipsesImportedNames(_EllipsesImportedNames that) {
        return for_EllipsesImportedNamesOnly(that);
    }


    public AbstractNode for_EllipsesImportStar(_EllipsesImportStar that) {
        return for_EllipsesImportStarOnly(that);
    }


    public AbstractNode for_EllipsesImportNames(_EllipsesImportNames that) {
        return for_EllipsesImportNamesOnly(that);
    }


    public AbstractNode for_EllipsesImportApi(_EllipsesImportApi that) {
        return for_EllipsesImportApiOnly(that);
    }


    public AbstractNode for_EllipsesAliasedSimpleName(_EllipsesAliasedSimpleName that) {
        return for_EllipsesAliasedSimpleNameOnly(that);
    }


    public AbstractNode for_EllipsesAliasedAPIName(_EllipsesAliasedAPIName that) {
        return for_EllipsesAliasedAPINameOnly(that);
    }


    public AbstractNode for_EllipsesDecl(_EllipsesDecl that) {
        return for_EllipsesDeclOnly(that);
    }


    public AbstractNode for_EllipsesTraitObjectDecl(_EllipsesTraitObjectDecl that) {
        return for_EllipsesTraitObjectDeclOnly(that);
    }


    public AbstractNode for_EllipsesTraitDecl(_EllipsesTraitDecl that) {
        return for_EllipsesTraitDeclOnly(that);
    }


    public AbstractNode for_EllipsesObjectDecl(_EllipsesObjectDecl that) {
        return for_EllipsesObjectDeclOnly(that);
    }


    public AbstractNode for_EllipsesVarDecl(_EllipsesVarDecl that) {
        return for_EllipsesVarDeclOnly(that);
    }


    public AbstractNode for_EllipsesFnDecl(_EllipsesFnDecl that) {
        return for_EllipsesFnDeclOnly(that);
    }


    public AbstractNode for_Ellipses_RewriteFnOverloadDecl(_Ellipses_RewriteFnOverloadDecl that) {
        return for_Ellipses_RewriteFnOverloadDeclOnly(that);
    }


    public AbstractNode for_Ellipses_RewriteObjectExprDecl(_Ellipses_RewriteObjectExprDecl that) {
        return for_Ellipses_RewriteObjectExprDeclOnly(that);
    }


    public AbstractNode for_Ellipses_RewriteFunctionalMethodDecl(_Ellipses_RewriteFunctionalMethodDecl that) {
        return for_Ellipses_RewriteFunctionalMethodDeclOnly(that);
    }


    public AbstractNode for_EllipsesDimUnitDecl(_EllipsesDimUnitDecl that) {
        return for_EllipsesDimUnitDeclOnly(that);
    }


    public AbstractNode for_EllipsesDimDecl(_EllipsesDimDecl that) {
        return for_EllipsesDimDeclOnly(that);
    }


    public AbstractNode for_EllipsesUnitDecl(_EllipsesUnitDecl that) {
        return for_EllipsesUnitDeclOnly(that);
    }


    public AbstractNode for_EllipsesTestDecl(_EllipsesTestDecl that) {
        return for_EllipsesTestDeclOnly(that);
    }


    public AbstractNode for_EllipsesPropertyDecl(_EllipsesPropertyDecl that) {
        return for_EllipsesPropertyDeclOnly(that);
    }


    public AbstractNode for_EllipsesTypeAlias(_EllipsesTypeAlias that) {
        return for_EllipsesTypeAliasOnly(that);
    }


    public AbstractNode for_EllipsesGrammarDecl(_EllipsesGrammarDecl that) {
        return for_EllipsesGrammarDeclOnly(that);
    }


    public AbstractNode for_EllipsesGrammarMemberDecl(_EllipsesGrammarMemberDecl that) {
        return for_EllipsesGrammarMemberDeclOnly(that);
    }


    public AbstractNode for_EllipsesNonterminalDecl(_EllipsesNonterminalDecl that) {
        return for_EllipsesNonterminalDeclOnly(that);
    }


    public AbstractNode for_EllipsesNonterminalDef(_EllipsesNonterminalDef that) {
        return for_EllipsesNonterminalDefOnly(that);
    }


    public AbstractNode for_EllipsesNonterminalExtensionDef(_EllipsesNonterminalExtensionDef that) {
        return for_EllipsesNonterminalExtensionDefOnly(that);
    }


    public AbstractNode for_EllipsesBinding(_EllipsesBinding that) {
        return for_EllipsesBindingOnly(that);
    }


    public AbstractNode for_EllipsesLValue(_EllipsesLValue that) {
        return for_EllipsesLValueOnly(that);
    }


    public AbstractNode for_EllipsesParam(_EllipsesParam that) {
        return for_EllipsesParamOnly(that);
    }


    public AbstractNode for_EllipsesExpr(_EllipsesExpr that) {
        return for_EllipsesExprOnly(that);
    }


    public AbstractNode for_EllipsesDummyExpr(_EllipsesDummyExpr that) {
        return for_EllipsesDummyExprOnly(that);
    }


    public AbstractNode for_EllipsesTypeAnnotatedExpr(_EllipsesTypeAnnotatedExpr that) {
        return for_EllipsesTypeAnnotatedExprOnly(that);
    }


    public AbstractNode for_EllipsesAsExpr(_EllipsesAsExpr that) {
        return for_EllipsesAsExprOnly(that);
    }


    public AbstractNode for_EllipsesAsIfExpr(_EllipsesAsIfExpr that) {
        return for_EllipsesAsIfExprOnly(that);
    }


    public AbstractNode for_EllipsesAssignment(_EllipsesAssignment that) {
        return for_EllipsesAssignmentOnly(that);
    }


    public AbstractNode for_EllipsesBlock(_EllipsesBlock that) {
        return for_EllipsesBlockOnly(that);
    }


    public AbstractNode for_EllipsesDo(_EllipsesDo that) {
        return for_EllipsesDoOnly(that);
    }


    public AbstractNode for_EllipsesCaseExpr(_EllipsesCaseExpr that) {
        return for_EllipsesCaseExprOnly(that);
    }


    public AbstractNode for_EllipsesIf(_EllipsesIf that) {
        return for_EllipsesIfOnly(that);
    }


    public AbstractNode for_EllipsesLabel(_EllipsesLabel that) {
        return for_EllipsesLabelOnly(that);
    }


    public AbstractNode for_EllipsesAbstractObjectExpr(_EllipsesAbstractObjectExpr that) {
        return for_EllipsesAbstractObjectExprOnly(that);
    }


    public AbstractNode for_EllipsesObjectExpr(_EllipsesObjectExpr that) {
        return for_EllipsesObjectExprOnly(that);
    }


    public AbstractNode for_Ellipses_RewriteObjectExpr(_Ellipses_RewriteObjectExpr that) {
        return for_Ellipses_RewriteObjectExprOnly(that);
    }


    public AbstractNode for_EllipsesTry(_EllipsesTry that) {
        return for_EllipsesTryOnly(that);
    }


    public AbstractNode for_EllipsesTupleExpr(_EllipsesTupleExpr that) {
        return for_EllipsesTupleExprOnly(that);
    }


    public AbstractNode for_EllipsesTypecase(_EllipsesTypecase that) {
        return for_EllipsesTypecaseOnly(that);
    }


    public AbstractNode for_EllipsesWhile(_EllipsesWhile that) {
        return for_EllipsesWhileOnly(that);
    }


    public AbstractNode for_EllipsesFor(_EllipsesFor that) {
        return for_EllipsesForOnly(that);
    }


    public AbstractNode for_EllipsesBigOpApp(_EllipsesBigOpApp that) {
        return for_EllipsesBigOpAppOnly(that);
    }


    public AbstractNode for_EllipsesAccumulator(_EllipsesAccumulator that) {
        return for_EllipsesAccumulatorOnly(that);
    }


    public AbstractNode for_EllipsesArrayComprehension(_EllipsesArrayComprehension that) {
        return for_EllipsesArrayComprehensionOnly(that);
    }


    public AbstractNode for_EllipsesAtomicExpr(_EllipsesAtomicExpr that) {
        return for_EllipsesAtomicExprOnly(that);
    }


    public AbstractNode for_EllipsesExit(_EllipsesExit that) {
        return for_EllipsesExitOnly(that);
    }


    public AbstractNode for_EllipsesSpawn(_EllipsesSpawn that) {
        return for_EllipsesSpawnOnly(that);
    }


    public AbstractNode for_EllipsesThrow(_EllipsesThrow that) {
        return for_EllipsesThrowOnly(that);
    }


    public AbstractNode for_EllipsesTryAtomicExpr(_EllipsesTryAtomicExpr that) {
        return for_EllipsesTryAtomicExprOnly(that);
    }


    public AbstractNode for_EllipsesFnExpr(_EllipsesFnExpr that) {
        return for_EllipsesFnExprOnly(that);
    }


    public AbstractNode for_EllipsesLetExpr(_EllipsesLetExpr that) {
        return for_EllipsesLetExprOnly(that);
    }


    public AbstractNode for_EllipsesLetFn(_EllipsesLetFn that) {
        return for_EllipsesLetFnOnly(that);
    }


    public AbstractNode for_EllipsesLocalVarDecl(_EllipsesLocalVarDecl that) {
        return for_EllipsesLocalVarDeclOnly(that);
    }


    public AbstractNode for_EllipsesSimpleExpr(_EllipsesSimpleExpr that) {
        return for_EllipsesSimpleExprOnly(that);
    }


    public AbstractNode for_EllipsesSubscriptExpr(_EllipsesSubscriptExpr that) {
        return for_EllipsesSubscriptExprOnly(that);
    }


    public AbstractNode for_EllipsesPrimary(_EllipsesPrimary that) {
        return for_EllipsesPrimaryOnly(that);
    }


    public AbstractNode for_EllipsesLiteralExpr(_EllipsesLiteralExpr that) {
        return for_EllipsesLiteralExprOnly(that);
    }


    public AbstractNode for_EllipsesNumberLiteralExpr(_EllipsesNumberLiteralExpr that) {
        return for_EllipsesNumberLiteralExprOnly(that);
    }


    public AbstractNode for_EllipsesFloatLiteralExpr(_EllipsesFloatLiteralExpr that) {
        return for_EllipsesFloatLiteralExprOnly(that);
    }


    public AbstractNode for_EllipsesIntLiteralExpr(_EllipsesIntLiteralExpr that) {
        return for_EllipsesIntLiteralExprOnly(that);
    }


    public AbstractNode for_EllipsesCharLiteralExpr(_EllipsesCharLiteralExpr that) {
        return for_EllipsesCharLiteralExprOnly(that);
    }


    public AbstractNode for_EllipsesStringLiteralExpr(_EllipsesStringLiteralExpr that) {
        return for_EllipsesStringLiteralExprOnly(that);
    }


    public AbstractNode for_EllipsesVoidLiteralExpr(_EllipsesVoidLiteralExpr that) {
        return for_EllipsesVoidLiteralExprOnly(that);
    }


    public AbstractNode for_EllipsesBooleanLiteralExpr(_EllipsesBooleanLiteralExpr that) {
        return for_EllipsesBooleanLiteralExprOnly(that);
    }


    public AbstractNode for_EllipsesVarRef(_EllipsesVarRef that) {
        return for_EllipsesVarRefOnly(that);
    }


    public AbstractNode for_EllipsesFieldRef(_EllipsesFieldRef that) {
        return for_EllipsesFieldRefOnly(that);
    }


    public AbstractNode for_EllipsesFunctionalRef(_EllipsesFunctionalRef that) {
        return for_EllipsesFunctionalRefOnly(that);
    }


    public AbstractNode for_EllipsesFnRef(_EllipsesFnRef that) {
        return for_EllipsesFnRefOnly(that);
    }


    public AbstractNode for_EllipsesOpRef(_EllipsesOpRef that) {
        return for_EllipsesOpRefOnly(that);
    }


    public AbstractNode for_Ellipses_RewriteFnRef(_Ellipses_RewriteFnRef that) {
        return for_Ellipses_RewriteFnRefOnly(that);
    }


    public AbstractNode for_Ellipses_RewriteObjectExprRef(_Ellipses_RewriteObjectExprRef that) {
        return for_Ellipses_RewriteObjectExprRefOnly(that);
    }


    public AbstractNode for_EllipsesJuxt(_EllipsesJuxt that) {
        return for_EllipsesJuxtOnly(that);
    }


    public AbstractNode for_Ellipses_RewriteFnApp(_Ellipses_RewriteFnApp that) {
        return for_Ellipses_RewriteFnAppOnly(that);
    }


    public AbstractNode for_EllipsesOpExpr(_EllipsesOpExpr that) {
        return for_EllipsesOpExprOnly(that);
    }


    public AbstractNode for_EllipsesAmbiguousMultifixOpExpr(_EllipsesAmbiguousMultifixOpExpr that) {
        return for_EllipsesAmbiguousMultifixOpExprOnly(that);
    }


    public AbstractNode for_EllipsesChainExpr(_EllipsesChainExpr that) {
        return for_EllipsesChainExprOnly(that);
    }


    public AbstractNode for_EllipsesCoercionInvocation(_EllipsesCoercionInvocation that) {
        return for_EllipsesCoercionInvocationOnly(that);
    }


    public AbstractNode for_EllipsesTraitCoercionInvocation(_EllipsesTraitCoercionInvocation that) {
        return for_EllipsesTraitCoercionInvocationOnly(that);
    }


    public AbstractNode for_EllipsesTupleCoercionInvocation(_EllipsesTupleCoercionInvocation that) {
        return for_EllipsesTupleCoercionInvocationOnly(that);
    }


    public AbstractNode for_EllipsesArrowCoercionInvocation(_EllipsesArrowCoercionInvocation that) {
        return for_EllipsesArrowCoercionInvocationOnly(that);
    }


    public AbstractNode for_EllipsesUnionCoercionInvocation(_EllipsesUnionCoercionInvocation that) {
        return for_EllipsesUnionCoercionInvocationOnly(that);
    }


    public AbstractNode for_EllipsesMethodInvocation(_EllipsesMethodInvocation that) {
        return for_EllipsesMethodInvocationOnly(that);
    }


    public AbstractNode for_EllipsesMathPrimary(_EllipsesMathPrimary that) {
        return for_EllipsesMathPrimaryOnly(that);
    }


    public AbstractNode for_EllipsesArrayExpr(_EllipsesArrayExpr that) {
        return for_EllipsesArrayExprOnly(that);
    }


    public AbstractNode for_EllipsesArrayElement(_EllipsesArrayElement that) {
        return for_EllipsesArrayElementOnly(that);
    }


    public AbstractNode for_EllipsesArrayElements(_EllipsesArrayElements that) {
        return for_EllipsesArrayElementsOnly(that);
    }


    public AbstractNode for_EllipsesType(_EllipsesType that) {
        return for_EllipsesTypeOnly(that);
    }


    public AbstractNode for_EllipsesBaseType(_EllipsesBaseType that) {
        return for_EllipsesBaseTypeOnly(that);
    }


    public AbstractNode for_EllipsesAnyType(_EllipsesAnyType that) {
        return for_EllipsesAnyTypeOnly(that);
    }


    public AbstractNode for_EllipsesBottomType(_EllipsesBottomType that) {
        return for_EllipsesBottomTypeOnly(that);
    }


    public AbstractNode for_EllipsesUnknownType(_EllipsesUnknownType that) {
        return for_EllipsesUnknownTypeOnly(that);
    }


    public AbstractNode for_EllipsesSelfType(_EllipsesSelfType that) {
        return for_EllipsesSelfTypeOnly(that);
    }


    public AbstractNode for_EllipsesTraitSelfType(_EllipsesTraitSelfType that) {
        return for_EllipsesTraitSelfTypeOnly(that);
    }


    public AbstractNode for_EllipsesObjectExprType(_EllipsesObjectExprType that) {
        return for_EllipsesObjectExprTypeOnly(that);
    }


    public AbstractNode for_EllipsesNamedType(_EllipsesNamedType that) {
        return for_EllipsesNamedTypeOnly(that);
    }


    public AbstractNode for_Ellipses_InferenceVarType(_Ellipses_InferenceVarType that) {
        return for_Ellipses_InferenceVarTypeOnly(that);
    }


    public AbstractNode for_EllipsesVarType(_EllipsesVarType that) {
        return for_EllipsesVarTypeOnly(that);
    }


    public AbstractNode for_EllipsesTraitType(_EllipsesTraitType that) {
        return for_EllipsesTraitTypeOnly(that);
    }


    public AbstractNode for_EllipsesAbbreviatedType(_EllipsesAbbreviatedType that) {
        return for_EllipsesAbbreviatedTypeOnly(that);
    }


    public AbstractNode for_EllipsesArrayType(_EllipsesArrayType that) {
        return for_EllipsesArrayTypeOnly(that);
    }


    public AbstractNode for_EllipsesMatrixType(_EllipsesMatrixType that) {
        return for_EllipsesMatrixTypeOnly(that);
    }


    public AbstractNode for_EllipsesTaggedDimType(_EllipsesTaggedDimType that) {
        return for_EllipsesTaggedDimTypeOnly(that);
    }


    public AbstractNode for_EllipsesTaggedUnitType(_EllipsesTaggedUnitType that) {
        return for_EllipsesTaggedUnitTypeOnly(that);
    }


    public AbstractNode for_EllipsesTupleType(_EllipsesTupleType that) {
        return for_EllipsesTupleTypeOnly(that);
    }


    public AbstractNode for_EllipsesArrowType(_EllipsesArrowType that) {
        return for_EllipsesArrowTypeOnly(that);
    }


    public AbstractNode for_EllipsesBoundType(_EllipsesBoundType that) {
        return for_EllipsesBoundTypeOnly(that);
    }


    public AbstractNode for_EllipsesIntersectionType(_EllipsesIntersectionType that) {
        return for_EllipsesIntersectionTypeOnly(that);
    }


    public AbstractNode for_EllipsesUnionType(_EllipsesUnionType that) {
        return for_EllipsesUnionTypeOnly(that);
    }


    public AbstractNode for_EllipsesFixedPointType(_EllipsesFixedPointType that) {
        return for_EllipsesFixedPointTypeOnly(that);
    }


    public AbstractNode for_EllipsesLabelType(_EllipsesLabelType that) {
        return for_EllipsesLabelTypeOnly(that);
    }


    public AbstractNode for_EllipsesDimExpr(_EllipsesDimExpr that) {
        return for_EllipsesDimExprOnly(that);
    }


    public AbstractNode for_EllipsesDimBase(_EllipsesDimBase that) {
        return for_EllipsesDimBaseOnly(that);
    }


    public AbstractNode for_EllipsesDimRef(_EllipsesDimRef that) {
        return for_EllipsesDimRefOnly(that);
    }


    public AbstractNode for_EllipsesDimExponent(_EllipsesDimExponent that) {
        return for_EllipsesDimExponentOnly(that);
    }


    public AbstractNode for_EllipsesDimUnaryOp(_EllipsesDimUnaryOp that) {
        return for_EllipsesDimUnaryOpOnly(that);
    }


    public AbstractNode for_EllipsesDimBinaryOp(_EllipsesDimBinaryOp that) {
        return for_EllipsesDimBinaryOpOnly(that);
    }


    public AbstractNode for_EllipsesPattern(_EllipsesPattern that) {
        return for_EllipsesPatternOnly(that);
    }


    public AbstractNode for_EllipsesPatternArgs(_EllipsesPatternArgs that) {
        return for_EllipsesPatternArgsOnly(that);
    }


    public AbstractNode for_EllipsesPatternBinding(_EllipsesPatternBinding that) {
        return for_EllipsesPatternBindingOnly(that);
    }


    public AbstractNode for_EllipsesPlainPattern(_EllipsesPlainPattern that) {
        return for_EllipsesPlainPatternOnly(that);
    }


    public AbstractNode for_EllipsesTypePattern(_EllipsesTypePattern that) {
        return for_EllipsesTypePatternOnly(that);
    }


    public AbstractNode for_EllipsesNestedPattern(_EllipsesNestedPattern that) {
        return for_EllipsesNestedPatternOnly(that);
    }


    public AbstractNode for_EllipsesStaticArg(_EllipsesStaticArg that) {
        return for_EllipsesStaticArgOnly(that);
    }


    public AbstractNode for_EllipsesTypeArg(_EllipsesTypeArg that) {
        return for_EllipsesTypeArgOnly(that);
    }


    public AbstractNode for_EllipsesIntArg(_EllipsesIntArg that) {
        return for_EllipsesIntArgOnly(that);
    }


    public AbstractNode for_EllipsesBoolArg(_EllipsesBoolArg that) {
        return for_EllipsesBoolArgOnly(that);
    }


    public AbstractNode for_EllipsesOpArg(_EllipsesOpArg that) {
        return for_EllipsesOpArgOnly(that);
    }


    public AbstractNode for_EllipsesDimArg(_EllipsesDimArg that) {
        return for_EllipsesDimArgOnly(that);
    }


    public AbstractNode for_EllipsesUnitArg(_EllipsesUnitArg that) {
        return for_EllipsesUnitArgOnly(that);
    }


    public AbstractNode for_EllipsesStaticExpr(_EllipsesStaticExpr that) {
        return for_EllipsesStaticExprOnly(that);
    }


    public AbstractNode for_EllipsesIntExpr(_EllipsesIntExpr that) {
        return for_EllipsesIntExprOnly(that);
    }


    public AbstractNode for_EllipsesIntBase(_EllipsesIntBase that) {
        return for_EllipsesIntBaseOnly(that);
    }


    public AbstractNode for_EllipsesIntRef(_EllipsesIntRef that) {
        return for_EllipsesIntRefOnly(that);
    }


    public AbstractNode for_EllipsesIntBinaryOp(_EllipsesIntBinaryOp that) {
        return for_EllipsesIntBinaryOpOnly(that);
    }


    public AbstractNode for_EllipsesBoolExpr(_EllipsesBoolExpr that) {
        return for_EllipsesBoolExprOnly(that);
    }


    public AbstractNode for_EllipsesBoolBase(_EllipsesBoolBase that) {
        return for_EllipsesBoolBaseOnly(that);
    }


    public AbstractNode for_EllipsesBoolRef(_EllipsesBoolRef that) {
        return for_EllipsesBoolRefOnly(that);
    }


    public AbstractNode for_EllipsesBoolConstraint(_EllipsesBoolConstraint that) {
        return for_EllipsesBoolConstraintOnly(that);
    }


    public AbstractNode for_EllipsesBoolUnaryOp(_EllipsesBoolUnaryOp that) {
        return for_EllipsesBoolUnaryOpOnly(that);
    }


    public AbstractNode for_EllipsesBoolBinaryOp(_EllipsesBoolBinaryOp that) {
        return for_EllipsesBoolBinaryOpOnly(that);
    }


    public AbstractNode for_EllipsesUnitExpr(_EllipsesUnitExpr that) {
        return for_EllipsesUnitExprOnly(that);
    }


    public AbstractNode for_EllipsesUnitRef(_EllipsesUnitRef that) {
        return for_EllipsesUnitRefOnly(that);
    }


    public AbstractNode for_EllipsesUnitBinaryOp(_EllipsesUnitBinaryOp that) {
        return for_EllipsesUnitBinaryOpOnly(that);
    }


    public AbstractNode for_EllipsesEffect(_EllipsesEffect that) {
        return for_EllipsesEffectOnly(that);
    }


    public AbstractNode for_EllipsesWhereClause(_EllipsesWhereClause that) {
        return for_EllipsesWhereClauseOnly(that);
    }


    public AbstractNode for_EllipsesWhereBinding(_EllipsesWhereBinding that) {
        return for_EllipsesWhereBindingOnly(that);
    }


    public AbstractNode for_EllipsesWhereConstraint(_EllipsesWhereConstraint that) {
        return for_EllipsesWhereConstraintOnly(that);
    }


    public AbstractNode for_EllipsesWhereExtends(_EllipsesWhereExtends that) {
        return for_EllipsesWhereExtendsOnly(that);
    }


    public AbstractNode for_EllipsesWhereTypeAlias(_EllipsesWhereTypeAlias that) {
        return for_EllipsesWhereTypeAliasOnly(that);
    }


    public AbstractNode for_EllipsesWhereCoerces(_EllipsesWhereCoerces that) {
        return for_EllipsesWhereCoercesOnly(that);
    }


    public AbstractNode for_EllipsesWhereEquals(_EllipsesWhereEquals that) {
        return for_EllipsesWhereEqualsOnly(that);
    }


    public AbstractNode for_EllipsesUnitConstraint(_EllipsesUnitConstraint that) {
        return for_EllipsesUnitConstraintOnly(that);
    }


    public AbstractNode for_EllipsesIntConstraint(_EllipsesIntConstraint that) {
        return for_EllipsesIntConstraintOnly(that);
    }


    public AbstractNode for_EllipsesBoolConstraintExpr(_EllipsesBoolConstraintExpr that) {
        return for_EllipsesBoolConstraintExprOnly(that);
    }


    public AbstractNode for_EllipsesContract(_EllipsesContract that) {
        return for_EllipsesContractOnly(that);
    }


    public AbstractNode for_EllipsesEnsuresClause(_EllipsesEnsuresClause that) {
        return for_EllipsesEnsuresClauseOnly(that);
    }


    public AbstractNode for_EllipsesStaticParam(_EllipsesStaticParam that) {
        return for_EllipsesStaticParamOnly(that);
    }


    public AbstractNode for_EllipsesName(_EllipsesName that) {
        return for_EllipsesNameOnly(that);
    }


    public AbstractNode for_EllipsesAPIName(_EllipsesAPIName that) {
        return for_EllipsesAPINameOnly(that);
    }


    public AbstractNode for_EllipsesIdOrOpOrAnonymousName(_EllipsesIdOrOpOrAnonymousName that) {
        return for_EllipsesIdOrOpOrAnonymousNameOnly(that);
    }


    public AbstractNode for_EllipsesIdOrOp(_EllipsesIdOrOp that) {
        return for_EllipsesIdOrOpOnly(that);
    }


    public AbstractNode for_EllipsesId(_EllipsesId that) {
        return for_EllipsesIdOnly(that);
    }


    public AbstractNode for_EllipsesOp(_EllipsesOp that) {
        return for_EllipsesOpOnly(that);
    }


    public AbstractNode for_EllipsesNamedOp(_EllipsesNamedOp that) {
        return for_EllipsesNamedOpOnly(that);
    }


    public AbstractNode for_Ellipses_InferenceVarOp(_Ellipses_InferenceVarOp that) {
        return for_Ellipses_InferenceVarOpOnly(that);
    }


    public AbstractNode for_EllipsesAnonymousName(_EllipsesAnonymousName that) {
        return for_EllipsesAnonymousNameOnly(that);
    }


    public AbstractNode for_EllipsesAnonymousFnName(_EllipsesAnonymousFnName that) {
        return for_EllipsesAnonymousFnNameOnly(that);
    }


    public AbstractNode for_EllipsesConstructorFnName(_EllipsesConstructorFnName that) {
        return for_EllipsesConstructorFnNameOnly(that);
    }


    public AbstractNode for_EllipsesArrayComprehensionClause(_EllipsesArrayComprehensionClause that) {
        return for_EllipsesArrayComprehensionClauseOnly(that);
    }


    public AbstractNode for_EllipsesKeywordExpr(_EllipsesKeywordExpr that) {
        return for_EllipsesKeywordExprOnly(that);
    }


    public AbstractNode for_EllipsesCaseClause(_EllipsesCaseClause that) {
        return for_EllipsesCaseClauseOnly(that);
    }


    public AbstractNode for_EllipsesCatch(_EllipsesCatch that) {
        return for_EllipsesCatchOnly(that);
    }


    public AbstractNode for_EllipsesCatchClause(_EllipsesCatchClause that) {
        return for_EllipsesCatchClauseOnly(that);
    }


    public AbstractNode for_EllipsesIfClause(_EllipsesIfClause that) {
        return for_EllipsesIfClauseOnly(that);
    }


    public AbstractNode for_EllipsesTypecaseClause(_EllipsesTypecaseClause that) {
        return for_EllipsesTypecaseClauseOnly(that);
    }


    public AbstractNode for_EllipsesExtentRange(_EllipsesExtentRange that) {
        return for_EllipsesExtentRangeOnly(that);
    }


    public AbstractNode for_EllipsesGeneratorClause(_EllipsesGeneratorClause that) {
        return for_EllipsesGeneratorClauseOnly(that);
    }


    public AbstractNode for_EllipsesKeywordType(_EllipsesKeywordType that) {
        return for_EllipsesKeywordTypeOnly(that);
    }


    public AbstractNode for_EllipsesTraitTypeWhere(_EllipsesTraitTypeWhere that) {
        return for_EllipsesTraitTypeWhereOnly(that);
    }


    public AbstractNode for_EllipsesIndices(_EllipsesIndices that) {
        return for_EllipsesIndicesOnly(that);
    }


    public AbstractNode for_EllipsesMathItem(_EllipsesMathItem that) {
        return for_EllipsesMathItemOnly(that);
    }


    public AbstractNode for_EllipsesExprMI(_EllipsesExprMI that) {
        return for_EllipsesExprMIOnly(that);
    }


    public AbstractNode for_EllipsesParenthesisDelimitedMI(_EllipsesParenthesisDelimitedMI that) {
        return for_EllipsesParenthesisDelimitedMIOnly(that);
    }


    public AbstractNode for_EllipsesNonParenthesisDelimitedMI(_EllipsesNonParenthesisDelimitedMI that) {
        return for_EllipsesNonParenthesisDelimitedMIOnly(that);
    }


    public AbstractNode for_EllipsesNonExprMI(_EllipsesNonExprMI that) {
        return for_EllipsesNonExprMIOnly(that);
    }


    public AbstractNode for_EllipsesExponentiationMI(_EllipsesExponentiationMI that) {
        return for_EllipsesExponentiationMIOnly(that);
    }


    public AbstractNode for_EllipsesSubscriptingMI(_EllipsesSubscriptingMI that) {
        return for_EllipsesSubscriptingMIOnly(that);
    }


    public AbstractNode for_EllipsesOverloading(_EllipsesOverloading that) {
        return for_EllipsesOverloadingOnly(that);
    }


    public AbstractNode for_EllipsesNonterminalHeader(_EllipsesNonterminalHeader that) {
        return for_EllipsesNonterminalHeaderOnly(that);
    }


    public AbstractNode for_EllipsesNonterminalParameter(_EllipsesNonterminalParameter that) {
        return for_EllipsesNonterminalParameterOnly(that);
    }


    public AbstractNode for_EllipsesSyntaxDecl(_EllipsesSyntaxDecl that) {
        return for_EllipsesSyntaxDeclOnly(that);
    }


    public AbstractNode for_EllipsesSyntaxDef(_EllipsesSyntaxDef that) {
        return for_EllipsesSyntaxDefOnly(that);
    }


    public AbstractNode for_EllipsesSuperSyntaxDef(_EllipsesSuperSyntaxDef that) {
        return for_EllipsesSuperSyntaxDefOnly(that);
    }


    public AbstractNode for_EllipsesTransformerDecl(_EllipsesTransformerDecl that) {
        return for_EllipsesTransformerDeclOnly(that);
    }


    public AbstractNode for_EllipsesPreTransformerDef(_EllipsesPreTransformerDef that) {
        return for_EllipsesPreTransformerDefOnly(that);
    }


    public AbstractNode for_EllipsesNamedTransformerDef(_EllipsesNamedTransformerDef that) {
        return for_EllipsesNamedTransformerDefOnly(that);
    }


    public AbstractNode for_EllipsesTransformer(_EllipsesTransformer that) {
        return for_EllipsesTransformerOnly(that);
    }


    public AbstractNode for_EllipsesUnparsedTransformer(_EllipsesUnparsedTransformer that) {
        return for_EllipsesUnparsedTransformerOnly(that);
    }


    public AbstractNode for_EllipsesNodeTransformer(_EllipsesNodeTransformer that) {
        return for_EllipsesNodeTransformerOnly(that);
    }


    public AbstractNode for_EllipsesCaseTransformer(_EllipsesCaseTransformer that) {
        return for_EllipsesCaseTransformerOnly(that);
    }


    public AbstractNode for_EllipsesCaseTransformerClause(_EllipsesCaseTransformerClause that) {
        return for_EllipsesCaseTransformerClauseOnly(that);
    }


    public AbstractNode for_EllipsesSyntaxSymbol(_EllipsesSyntaxSymbol that) {
        return for_EllipsesSyntaxSymbolOnly(that);
    }


    public AbstractNode for_EllipsesPrefixedSymbol(_EllipsesPrefixedSymbol that) {
        return for_EllipsesPrefixedSymbolOnly(that);
    }


    public AbstractNode for_EllipsesOptionalSymbol(_EllipsesOptionalSymbol that) {
        return for_EllipsesOptionalSymbolOnly(that);
    }


    public AbstractNode for_EllipsesRepeatSymbol(_EllipsesRepeatSymbol that) {
        return for_EllipsesRepeatSymbolOnly(that);
    }


    public AbstractNode for_EllipsesRepeatOneOrMoreSymbol(_EllipsesRepeatOneOrMoreSymbol that) {
        return for_EllipsesRepeatOneOrMoreSymbolOnly(that);
    }


    public AbstractNode for_EllipsesNoWhitespaceSymbol(_EllipsesNoWhitespaceSymbol that) {
        return for_EllipsesNoWhitespaceSymbolOnly(that);
    }


    public AbstractNode for_EllipsesGroupSymbol(_EllipsesGroupSymbol that) {
        return for_EllipsesGroupSymbolOnly(that);
    }


    public AbstractNode for_EllipsesSpecialSymbol(_EllipsesSpecialSymbol that) {
        return for_EllipsesSpecialSymbolOnly(that);
    }


    public AbstractNode for_EllipsesAnyCharacterSymbol(_EllipsesAnyCharacterSymbol that) {
        return for_EllipsesAnyCharacterSymbolOnly(that);
    }


    public AbstractNode for_EllipsesWhitespaceSymbol(_EllipsesWhitespaceSymbol that) {
        return for_EllipsesWhitespaceSymbolOnly(that);
    }


    public AbstractNode for_EllipsesTabSymbol(_EllipsesTabSymbol that) {
        return for_EllipsesTabSymbolOnly(that);
    }


    public AbstractNode for_EllipsesFormfeedSymbol(_EllipsesFormfeedSymbol that) {
        return for_EllipsesFormfeedSymbolOnly(that);
    }


    public AbstractNode for_EllipsesCarriageReturnSymbol(_EllipsesCarriageReturnSymbol that) {
        return for_EllipsesCarriageReturnSymbolOnly(that);
    }


    public AbstractNode for_EllipsesBackspaceSymbol(_EllipsesBackspaceSymbol that) {
        return for_EllipsesBackspaceSymbolOnly(that);
    }


    public AbstractNode for_EllipsesNewlineSymbol(_EllipsesNewlineSymbol that) {
        return for_EllipsesNewlineSymbolOnly(that);
    }


    public AbstractNode for_EllipsesBreaklineSymbol(_EllipsesBreaklineSymbol that) {
        return for_EllipsesBreaklineSymbolOnly(that);
    }


    public AbstractNode for_EllipsesItemSymbol(_EllipsesItemSymbol that) {
        return for_EllipsesItemSymbolOnly(that);
    }


    public AbstractNode for_EllipsesNonterminalSymbol(_EllipsesNonterminalSymbol that) {
        return for_EllipsesNonterminalSymbolOnly(that);
    }


    public AbstractNode for_EllipsesKeywordSymbol(_EllipsesKeywordSymbol that) {
        return for_EllipsesKeywordSymbolOnly(that);
    }


    public AbstractNode for_EllipsesTokenSymbol(_EllipsesTokenSymbol that) {
        return for_EllipsesTokenSymbolOnly(that);
    }


    public AbstractNode for_EllipsesNotPredicateSymbol(_EllipsesNotPredicateSymbol that) {
        return for_EllipsesNotPredicateSymbolOnly(that);
    }


    public AbstractNode for_EllipsesAndPredicateSymbol(_EllipsesAndPredicateSymbol that) {
        return for_EllipsesAndPredicateSymbolOnly(that);
    }


    public AbstractNode for_EllipsesCharacterClassSymbol(_EllipsesCharacterClassSymbol that) {
        return for_EllipsesCharacterClassSymbolOnly(that);
    }


    public AbstractNode for_EllipsesCharacterSymbol(_EllipsesCharacterSymbol that) {
        return for_EllipsesCharacterSymbolOnly(that);
    }


    public AbstractNode for_EllipsesCharSymbol(_EllipsesCharSymbol that) {
        return for_EllipsesCharSymbolOnly(that);
    }


    public AbstractNode for_EllipsesCharacterInterval(_EllipsesCharacterInterval that) {
        return for_EllipsesCharacterIntervalOnly(that);
    }


    public AbstractNode for_EllipsesLink(_EllipsesLink that) {
        return for_EllipsesLinkOnly(that);
    }


    public AbstractNode forTemplateGapAbstractNode(TemplateGapAbstractNode that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAbstractNodeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapCompilationUnit(TemplateGapCompilationUnit that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCompilationUnitOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapComponent(TemplateGapComponent that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapComponentOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapApi(TemplateGapApi that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapApiOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapImport(TemplateGapImport that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapImportOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapImportedNames(TemplateGapImportedNames that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapImportedNamesOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapImportStar(TemplateGapImportStar that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapImportStarOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapImportNames(TemplateGapImportNames that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapImportNamesOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapImportApi(TemplateGapImportApi that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapImportApiOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapAliasedSimpleName(TemplateGapAliasedSimpleName that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAliasedSimpleNameOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapAliasedAPIName(TemplateGapAliasedAPIName that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAliasedAPINameOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapDecl(TemplateGapDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTraitObjectDecl(TemplateGapTraitObjectDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTraitObjectDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTraitDecl(TemplateGapTraitDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTraitDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapObjectDecl(TemplateGapObjectDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapObjectDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapVarDecl(TemplateGapVarDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapVarDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapFnDecl(TemplateGapFnDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFnDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGap_RewriteFnOverloadDecl(TemplateGap_RewriteFnOverloadDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteFnOverloadDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGap_RewriteObjectExprDecl(TemplateGap_RewriteObjectExprDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteObjectExprDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGap_RewriteFunctionalMethodDecl(TemplateGap_RewriteFunctionalMethodDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteFunctionalMethodDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapDimUnitDecl(TemplateGapDimUnitDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimUnitDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapDimDecl(TemplateGapDimDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapUnitDecl(TemplateGapUnitDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnitDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTestDecl(TemplateGapTestDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTestDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapPropertyDecl(TemplateGapPropertyDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPropertyDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTypeAlias(TemplateGapTypeAlias that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypeAliasOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapGrammarDecl(TemplateGapGrammarDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapGrammarDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapGrammarMemberDecl(TemplateGapGrammarMemberDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapGrammarMemberDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNonterminalDecl(TemplateGapNonterminalDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNonterminalDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNonterminalDef(TemplateGapNonterminalDef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNonterminalDefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNonterminalExtensionDef(TemplateGapNonterminalExtensionDef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNonterminalExtensionDefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBinding(TemplateGapBinding that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBindingOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapLValue(TemplateGapLValue that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLValueOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapParam(TemplateGapParam that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapParamOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapExpr(TemplateGapExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapDummyExpr(TemplateGapDummyExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDummyExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTypeAnnotatedExpr(TemplateGapTypeAnnotatedExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypeAnnotatedExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapAsExpr(TemplateGapAsExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAsExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapAsIfExpr(TemplateGapAsIfExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAsIfExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapAssignment(TemplateGapAssignment that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAssignmentOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBlock(TemplateGapBlock that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBlockOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapDo(TemplateGapDo that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDoOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapCaseExpr(TemplateGapCaseExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCaseExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapIf(TemplateGapIf that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIfOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapLabel(TemplateGapLabel that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLabelOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapAbstractObjectExpr(TemplateGapAbstractObjectExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAbstractObjectExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapObjectExpr(TemplateGapObjectExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapObjectExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGap_RewriteObjectExpr(TemplateGap_RewriteObjectExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteObjectExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTry(TemplateGapTry that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTryOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTupleExpr(TemplateGapTupleExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTupleExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTypecase(TemplateGapTypecase that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypecaseOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapWhile(TemplateGapWhile that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhileOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapFor(TemplateGapFor that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapForOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBigOpApp(TemplateGapBigOpApp that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBigOpAppOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapAccumulator(TemplateGapAccumulator that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAccumulatorOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapArrayComprehension(TemplateGapArrayComprehension that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayComprehensionOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapAtomicExpr(TemplateGapAtomicExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAtomicExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapExit(TemplateGapExit that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapExitOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapSpawn(TemplateGapSpawn that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSpawnOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapThrow(TemplateGapThrow that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapThrowOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTryAtomicExpr(TemplateGapTryAtomicExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTryAtomicExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapFnExpr(TemplateGapFnExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFnExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapLetExpr(TemplateGapLetExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLetExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapLetFn(TemplateGapLetFn that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLetFnOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapLocalVarDecl(TemplateGapLocalVarDecl that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLocalVarDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapSimpleExpr(TemplateGapSimpleExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSimpleExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapSubscriptExpr(TemplateGapSubscriptExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSubscriptExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapPrimary(TemplateGapPrimary that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPrimaryOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapLiteralExpr(TemplateGapLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNumberLiteralExpr(TemplateGapNumberLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNumberLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapFloatLiteralExpr(TemplateGapFloatLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFloatLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapIntLiteralExpr(TemplateGapIntLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapCharLiteralExpr(TemplateGapCharLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCharLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapStringLiteralExpr(TemplateGapStringLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapStringLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapVoidLiteralExpr(TemplateGapVoidLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapVoidLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBooleanLiteralExpr(TemplateGapBooleanLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBooleanLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapVarRef(TemplateGapVarRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapVarRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapFieldRef(TemplateGapFieldRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFieldRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapFunctionalRef(TemplateGapFunctionalRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFunctionalRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapFnRef(TemplateGapFnRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFnRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapOpRef(TemplateGapOpRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOpRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGap_RewriteFnRef(TemplateGap_RewriteFnRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteFnRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGap_RewriteObjectExprRef(TemplateGap_RewriteObjectExprRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteObjectExprRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapJuxt(TemplateGapJuxt that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapJuxtOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGap_RewriteFnApp(TemplateGap_RewriteFnApp that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteFnAppOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapOpExpr(TemplateGapOpExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOpExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapAmbiguousMultifixOpExpr(TemplateGapAmbiguousMultifixOpExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAmbiguousMultifixOpExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapChainExpr(TemplateGapChainExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapChainExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapCoercionInvocation(TemplateGapCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCoercionInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTraitCoercionInvocation(TemplateGapTraitCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTraitCoercionInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTupleCoercionInvocation(TemplateGapTupleCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTupleCoercionInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapArrowCoercionInvocation(TemplateGapArrowCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrowCoercionInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapUnionCoercionInvocation(TemplateGapUnionCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnionCoercionInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapMethodInvocation(TemplateGapMethodInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapMethodInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapMathPrimary(TemplateGapMathPrimary that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapMathPrimaryOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapArrayExpr(TemplateGapArrayExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapArrayElement(TemplateGapArrayElement that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayElementOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapArrayElements(TemplateGapArrayElements that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayElementsOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapType(TemplateGapType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBaseType(TemplateGapBaseType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBaseTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapAnyType(TemplateGapAnyType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAnyTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBottomType(TemplateGapBottomType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBottomTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapUnknownType(TemplateGapUnknownType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnknownTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapSelfType(TemplateGapSelfType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSelfTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTraitSelfType(TemplateGapTraitSelfType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTraitSelfTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapObjectExprType(TemplateGapObjectExprType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapObjectExprTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNamedType(TemplateGapNamedType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNamedTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_InferenceVarTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapVarType(TemplateGapVarType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapVarTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTraitType(TemplateGapTraitType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTraitTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAbbreviatedTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapArrayType(TemplateGapArrayType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapMatrixType(TemplateGapMatrixType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapMatrixTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTaggedDimType(TemplateGapTaggedDimType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTaggedDimTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTaggedUnitTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTupleType(TemplateGapTupleType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTupleTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapArrowType(TemplateGapArrowType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrowTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBoundType(TemplateGapBoundType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoundTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapIntersectionType(TemplateGapIntersectionType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntersectionTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapUnionType(TemplateGapUnionType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnionTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapFixedPointType(TemplateGapFixedPointType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFixedPointTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapLabelType(TemplateGapLabelType that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLabelTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapDimExpr(TemplateGapDimExpr that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapDimBase(TemplateGapDimBase that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimBaseOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapDimRef(TemplateGapDimRef that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapDimExponent(TemplateGapDimExponent that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimExponentOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimUnaryOpOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that) {
        TypeInfo info_result = recurOnTypeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimBinaryOpOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapPattern(TemplateGapPattern that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPatternOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapPatternArgs(TemplateGapPatternArgs that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPatternArgsOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapPatternBinding(TemplateGapPatternBinding that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPatternBindingOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapPlainPattern(TemplateGapPlainPattern that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPlainPatternOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTypePattern(TemplateGapTypePattern that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypePatternOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNestedPattern(TemplateGapNestedPattern that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNestedPatternOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapStaticArg(TemplateGapStaticArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapStaticArgOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTypeArg(TemplateGapTypeArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypeArgOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapIntArg(TemplateGapIntArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntArgOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBoolArg(TemplateGapBoolArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolArgOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapOpArg(TemplateGapOpArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOpArgOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapDimArg(TemplateGapDimArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimArgOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapUnitArg(TemplateGapUnitArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnitArgOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapStaticExpr(TemplateGapStaticExpr that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapStaticExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapIntExpr(TemplateGapIntExpr that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapIntBase(TemplateGapIntBase that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntBaseOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapIntRef(TemplateGapIntRef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapIntBinaryOp(TemplateGapIntBinaryOp that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntBinaryOpOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBoolExpr(TemplateGapBoolExpr that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBoolBase(TemplateGapBoolBase that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolBaseOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBoolRef(TemplateGapBoolRef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBoolConstraint(TemplateGapBoolConstraint that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolConstraintOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBoolUnaryOp(TemplateGapBoolUnaryOp that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolUnaryOpOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBoolBinaryOp(TemplateGapBoolBinaryOp that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolBinaryOpOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapUnitExpr(TemplateGapUnitExpr that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnitExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapUnitRef(TemplateGapUnitRef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnitRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapUnitBinaryOp(TemplateGapUnitBinaryOp that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnitBinaryOpOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapEffect(TemplateGapEffect that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapEffectOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapWhereClause(TemplateGapWhereClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhereClauseOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapWhereBinding(TemplateGapWhereBinding that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhereBindingOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapWhereConstraint(TemplateGapWhereConstraint that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhereConstraintOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapWhereExtends(TemplateGapWhereExtends that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhereExtendsOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapWhereTypeAlias(TemplateGapWhereTypeAlias that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhereTypeAliasOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapWhereCoerces(TemplateGapWhereCoerces that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhereCoercesOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapWhereEquals(TemplateGapWhereEquals that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhereEqualsOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapUnitConstraint(TemplateGapUnitConstraint that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnitConstraintOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapIntConstraint(TemplateGapIntConstraint that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntConstraintOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBoolConstraintExpr(TemplateGapBoolConstraintExpr that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolConstraintExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapContract(TemplateGapContract that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapContractOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapEnsuresClause(TemplateGapEnsuresClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapEnsuresClauseOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapStaticParam(TemplateGapStaticParam that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapStaticParamOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapName(TemplateGapName that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNameOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapAPIName(TemplateGapAPIName that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAPINameOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapIdOrOpOrAnonymousName(TemplateGapIdOrOpOrAnonymousName that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIdOrOpOrAnonymousNameOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapIdOrOp(TemplateGapIdOrOp that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIdOrOpOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapId(TemplateGapId that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIdOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapOp(TemplateGapOp that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOpOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNamedOp(TemplateGapNamedOp that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNamedOpOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGap_InferenceVarOp(TemplateGap_InferenceVarOp that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_InferenceVarOpOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapAnonymousName(TemplateGapAnonymousName that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAnonymousNameOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapAnonymousFnName(TemplateGapAnonymousFnName that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAnonymousFnNameOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapConstructorFnName(TemplateGapConstructorFnName that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapConstructorFnNameOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapArrayComprehensionClause(TemplateGapArrayComprehensionClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayComprehensionClauseOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapKeywordExpr(TemplateGapKeywordExpr that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapKeywordExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapCaseClause(TemplateGapCaseClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCaseClauseOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapCatch(TemplateGapCatch that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCatchOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapCatchClause(TemplateGapCatchClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCatchClauseOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapIfClause(TemplateGapIfClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIfClauseOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTypecaseClause(TemplateGapTypecaseClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypecaseClauseOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapExtentRange(TemplateGapExtentRange that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapExtentRangeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapGeneratorClause(TemplateGapGeneratorClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapGeneratorClauseOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapKeywordType(TemplateGapKeywordType that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapKeywordTypeOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTraitTypeWhere(TemplateGapTraitTypeWhere that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTraitTypeWhereOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapIndices(TemplateGapIndices that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIndicesOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapMathItem(TemplateGapMathItem that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapMathItemOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapExprMI(TemplateGapExprMI that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapExprMIOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapParenthesisDelimitedMI(TemplateGapParenthesisDelimitedMI that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapParenthesisDelimitedMIOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNonParenthesisDelimitedMI(TemplateGapNonParenthesisDelimitedMI that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNonParenthesisDelimitedMIOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNonExprMI(TemplateGapNonExprMI that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNonExprMIOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapExponentiationMI(TemplateGapExponentiationMI that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapExponentiationMIOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapSubscriptingMI(TemplateGapSubscriptingMI that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSubscriptingMIOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapOverloading(TemplateGapOverloading that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOverloadingOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNonterminalHeader(TemplateGapNonterminalHeader that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNonterminalHeaderOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNonterminalParameter(TemplateGapNonterminalParameter that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNonterminalParameterOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapSyntaxDecl(TemplateGapSyntaxDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSyntaxDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapSyntaxDef(TemplateGapSyntaxDef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSyntaxDefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapSuperSyntaxDef(TemplateGapSuperSyntaxDef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSuperSyntaxDefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTransformerDecl(TemplateGapTransformerDecl that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTransformerDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapPreTransformerDef(TemplateGapPreTransformerDef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPreTransformerDefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNamedTransformerDef(TemplateGapNamedTransformerDef that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNamedTransformerDefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTransformer(TemplateGapTransformer that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTransformerOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapUnparsedTransformer(TemplateGapUnparsedTransformer that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnparsedTransformerOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNodeTransformer(TemplateGapNodeTransformer that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNodeTransformerOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapCaseTransformer(TemplateGapCaseTransformer that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCaseTransformerOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapCaseTransformerClause(TemplateGapCaseTransformerClause that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCaseTransformerClauseOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapSyntaxSymbol(TemplateGapSyntaxSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSyntaxSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapPrefixedSymbol(TemplateGapPrefixedSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPrefixedSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapOptionalSymbol(TemplateGapOptionalSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOptionalSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapRepeatSymbol(TemplateGapRepeatSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapRepeatSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapRepeatOneOrMoreSymbol(TemplateGapRepeatOneOrMoreSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapRepeatOneOrMoreSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNoWhitespaceSymbol(TemplateGapNoWhitespaceSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNoWhitespaceSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapGroupSymbol(TemplateGapGroupSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapGroupSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapSpecialSymbol(TemplateGapSpecialSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSpecialSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapAnyCharacterSymbol(TemplateGapAnyCharacterSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAnyCharacterSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapWhitespaceSymbol(TemplateGapWhitespaceSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhitespaceSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTabSymbol(TemplateGapTabSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTabSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapFormfeedSymbol(TemplateGapFormfeedSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFormfeedSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapCarriageReturnSymbol(TemplateGapCarriageReturnSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCarriageReturnSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBackspaceSymbol(TemplateGapBackspaceSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBackspaceSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNewlineSymbol(TemplateGapNewlineSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNewlineSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapBreaklineSymbol(TemplateGapBreaklineSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBreaklineSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapItemSymbol(TemplateGapItemSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapItemSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNonterminalSymbol(TemplateGapNonterminalSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNonterminalSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapKeywordSymbol(TemplateGapKeywordSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapKeywordSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapTokenSymbol(TemplateGapTokenSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTokenSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapNotPredicateSymbol(TemplateGapNotPredicateSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNotPredicateSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapAndPredicateSymbol(TemplateGapAndPredicateSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAndPredicateSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapCharacterClassSymbol(TemplateGapCharacterClassSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCharacterClassSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapCharacterSymbol(TemplateGapCharacterSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCharacterSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapCharSymbol(TemplateGapCharSymbol that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCharSymbolOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapCharacterInterval(TemplateGapCharacterInterval that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCharacterIntervalOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode forTemplateGapLink(TemplateGapLink that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = (Id) recur(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLinkOnly(that, info_result, gapId_result, templateParams_result);
    }


    public AbstractNode recur(AbstractNode that) {
        return that.accept(this);
    }

    public ASTNodeInfo recurOnASTNodeInfo(ASTNodeInfo that) {
        return that;
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

    public TraitTypeHeader recurOnTraitTypeHeader(TraitTypeHeader that) {
        return that;
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

    public FnHeader recurOnFnHeader(FnHeader that) {
        return that;
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

    public TypeOrPattern recurOnTypeOrPattern(TypeOrPattern that) {
        return that;
    }

    public Option<TypeOrPattern> recurOnOptionOfTypeOrPattern(Option<TypeOrPattern> that) {
        if (that.isNone()) { return that; }
        else {
            TypeOrPattern original = that.unwrap();
            TypeOrPattern updated = recurOnTypeOrPattern(original);
            return (original == updated) ? that : Option.<TypeOrPattern>some(updated);
        }
    }

    public ExprInfo recurOnExprInfo(ExprInfo that) {
        return that;
    }

    public Lhs recurOnLhs(Lhs that) {
        return that;
    }

    public List<Lhs> recurOnListOfLhs(List<Lhs> that) {
        java.util.ArrayList<Lhs> accum = new java.util.ArrayList<Lhs>();
        boolean unchanged = true;
        for (Lhs elt : that) {
            Lhs update_elt = recurOnLhs(elt);
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

    public CompoundAssignmentInfo recurOnCompoundAssignmentInfo(CompoundAssignmentInfo that) {
        return that;
    }

    public List<CompoundAssignmentInfo> recurOnListOfCompoundAssignmentInfo(List<CompoundAssignmentInfo> that) {
        java.util.ArrayList<CompoundAssignmentInfo> accum = new java.util.ArrayList<CompoundAssignmentInfo>();
        boolean unchanged = true;
        for (CompoundAssignmentInfo elt : that) {
            CompoundAssignmentInfo update_elt = recurOnCompoundAssignmentInfo(elt);
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

    public TypeInfo recurOnTypeInfo(TypeInfo that) {
        return that;
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

    public StaticParamKind recurOnStaticParamKind(StaticParamKind that) {
        return that;
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

    public Fixity recurOnFixity(Fixity that) {
        return that;
    }

    public ObjectConstructor recurOnObjectConstructor(ObjectConstructor that) {
        return that;
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
}
