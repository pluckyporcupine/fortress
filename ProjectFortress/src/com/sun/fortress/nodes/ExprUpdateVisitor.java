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
public abstract class ExprUpdateVisitor extends ExprVisitorLambda<Expr> {

    /* Methods to handle a node after recursion. */

    public Expr forDummyExprOnly(DummyExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new DummyExpr(info_result);
    }

    public Expr forAsExprOnly(AsExpr that, ExprInfo info_result, Expr expr_result, Type annType_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result && that.getAnnType() == annType_result) return that;
        else return new AsExpr(info_result, expr_result, annType_result);
    }

    public Expr forAsIfExprOnly(AsIfExpr that, ExprInfo info_result, Expr expr_result, Type annType_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result && that.getAnnType() == annType_result) return that;
        else return new AsIfExpr(info_result, expr_result, annType_result);
    }

    public Expr forAssignmentOnly(Assignment that, ExprInfo info_result, List<Lhs> lhs_result, Option<FunctionalRef> assignOp_result, Expr rhs_result, List<CompoundAssignmentInfo> assignmentInfos_result) {
        if (that.getInfo() == info_result && that.getLhs() == lhs_result && that.getAssignOp() == assignOp_result && that.getRhs() == rhs_result && that.getAssignmentInfos() == assignmentInfos_result) return that;
        else return new Assignment(info_result, lhs_result, assignOp_result, rhs_result, assignmentInfos_result);
    }

    public Expr forBlockOnly(Block that, ExprInfo info_result, Option<Expr> loc_result, List<Expr> exprs_result) {
        if (that.getInfo() == info_result && that.getLoc() == loc_result && that.getExprs() == exprs_result) return that;
        else return new Block(info_result, loc_result, that.isAtomicBlock(), that.isWithinDo(), exprs_result);
    }

    public Expr forDoOnly(Do that, ExprInfo info_result, List<Block> fronts_result) {
        if (that.getInfo() == info_result && that.getFronts() == fronts_result) return that;
        else return new Do(info_result, fronts_result);
    }

    public Expr forCaseExprOnly(CaseExpr that, ExprInfo info_result, Option<Expr> param_result, Option<FunctionalRef> compare_result, FunctionalRef equalsOp_result, FunctionalRef inOp_result, List<CaseClause> clauses_result, Option<Block> elseClause_result) {
        if (that.getInfo() == info_result && that.getParam() == param_result && that.getCompare() == compare_result && that.getEqualsOp() == equalsOp_result && that.getInOp() == inOp_result && that.getClauses() == clauses_result && that.getElseClause() == elseClause_result) return that;
        else return new CaseExpr(info_result, param_result, compare_result, equalsOp_result, inOp_result, clauses_result, elseClause_result);
    }

    public Expr forIfOnly(If that, ExprInfo info_result, List<IfClause> clauses_result, Option<Block> elseClause_result) {
        if (that.getInfo() == info_result && that.getClauses() == clauses_result && that.getElseClause() == elseClause_result) return that;
        else return new If(info_result, clauses_result, elseClause_result);
    }

    public Expr forLabelOnly(Label that, ExprInfo info_result, Id name_result, Block body_result) {
        if (that.getInfo() == info_result && that.getName() == name_result && that.getBody() == body_result) return that;
        else return new Label(info_result, name_result, body_result);
    }

    public Expr forObjectExprOnly(ObjectExpr that, ExprInfo info_result, TraitTypeHeader header_result, Option<SelfType> selfType_result) {
        if (that.getInfo() == info_result && that.getHeader() == header_result && that.getSelfType() == selfType_result) return that;
        else return new ObjectExpr(info_result, header_result, selfType_result);
    }

    public Expr for_RewriteObjectExprOnly(_RewriteObjectExpr that, ExprInfo info_result, TraitTypeHeader header_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getHeader() == header_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new _RewriteObjectExpr(info_result, header_result, that.getImplicitTypeParameters(), that.getGenSymName(), staticArgs_result);
    }

    public Expr forTryOnly(Try that, ExprInfo info_result, Block body_result, Option<Catch> catchClause_result, List<BaseType> forbidClause_result, Option<Block> finallyClause_result) {
        if (that.getInfo() == info_result && that.getBody() == body_result && that.getCatchClause() == catchClause_result && that.getForbidClause() == forbidClause_result && that.getFinallyClause() == finallyClause_result) return that;
        else return new Try(info_result, body_result, catchClause_result, forbidClause_result, finallyClause_result);
    }

    public Expr forTupleExprOnly(TupleExpr that, ExprInfo info_result, List<Expr> exprs_result, Option<Expr> varargs_result, List<KeywordExpr> keywords_result) {
        if (that.getInfo() == info_result && that.getExprs() == exprs_result && that.getVarargs() == varargs_result && that.getKeywords() == keywords_result) return that;
        else return new TupleExpr(info_result, exprs_result, varargs_result, keywords_result, that.isInApp());
    }

    public Expr forTypecaseOnly(Typecase that, ExprInfo info_result, Expr bindExpr_result, List<TypecaseClause> clauses_result, Option<Block> elseClause_result) {
        if (that.getInfo() == info_result && that.getBindExpr() == bindExpr_result && that.getClauses() == clauses_result && that.getElseClause() == elseClause_result) return that;
        else return new Typecase(info_result, bindExpr_result, clauses_result, elseClause_result);
    }

    public Expr forWhileOnly(While that, ExprInfo info_result, GeneratorClause testExpr_result, Do body_result) {
        if (that.getInfo() == info_result && that.getTestExpr() == testExpr_result && that.getBody() == body_result) return that;
        else return new While(info_result, testExpr_result, body_result);
    }

    public Expr forForOnly(For that, ExprInfo info_result, List<GeneratorClause> gens_result, Block body_result) {
        if (that.getInfo() == info_result && that.getGens() == gens_result && that.getBody() == body_result) return that;
        else return new For(info_result, gens_result, body_result);
    }

    public Expr forAccumulatorOnly(Accumulator that, ExprInfo info_result, List<StaticArg> staticArgs_result, Op accOp_result, List<GeneratorClause> gens_result, Expr body_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getAccOp() == accOp_result && that.getGens() == gens_result && that.getBody() == body_result) return that;
        else return new Accumulator(info_result, staticArgs_result, accOp_result, gens_result, body_result);
    }

    public Expr forArrayComprehensionOnly(ArrayComprehension that, ExprInfo info_result, List<StaticArg> staticArgs_result, List<ArrayComprehensionClause> clauses_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getClauses() == clauses_result) return that;
        else return new ArrayComprehension(info_result, staticArgs_result, clauses_result);
    }

    public Expr forAtomicExprOnly(AtomicExpr that, ExprInfo info_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result) return that;
        else return new AtomicExpr(info_result, expr_result);
    }

    public Expr forExitOnly(Exit that, ExprInfo info_result, Option<Id> target_result, Option<Expr> returnExpr_result) {
        if (that.getInfo() == info_result && that.getTarget() == target_result && that.getReturnExpr() == returnExpr_result) return that;
        else return new Exit(info_result, target_result, returnExpr_result);
    }

    public Expr forSpawnOnly(Spawn that, ExprInfo info_result, Expr body_result) {
        if (that.getInfo() == info_result && that.getBody() == body_result) return that;
        else return new Spawn(info_result, body_result);
    }

    public Expr forThrowOnly(Throw that, ExprInfo info_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result) return that;
        else return new Throw(info_result, expr_result);
    }

    public Expr forTryAtomicExprOnly(TryAtomicExpr that, ExprInfo info_result, Expr expr_result) {
        if (that.getInfo() == info_result && that.getExpr() == expr_result) return that;
        else return new TryAtomicExpr(info_result, expr_result);
    }

    public Expr forFnExprOnly(FnExpr that, ExprInfo info_result, FnHeader header_result, Expr body_result) {
        if (that.getInfo() == info_result && that.getHeader() == header_result && that.getBody() == body_result) return that;
        else return new FnExpr(info_result, header_result, body_result);
    }

    public Expr forLetFnOnly(LetFn that, ExprInfo info_result, Block body_result, List<FnDecl> fns_result) {
        if (that.getInfo() == info_result && that.getBody() == body_result && that.getFns() == fns_result) return that;
        else return new LetFn(info_result, body_result, fns_result);
    }

    public Expr forLocalVarDeclOnly(LocalVarDecl that, ExprInfo info_result, Block body_result, List<LValue> lhs_result, Option<Expr> rhs_result) {
        if (that.getInfo() == info_result && that.getBody() == body_result && that.getLhs() == lhs_result && that.getRhs() == rhs_result) return that;
        else return new LocalVarDecl(info_result, body_result, lhs_result, rhs_result);
    }

    public Expr forSubscriptExprOnly(SubscriptExpr that, ExprInfo info_result, Expr obj_result, List<Expr> subs_result, Option<Op> op_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getObj() == obj_result && that.getSubs() == subs_result && that.getOp() == op_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new SubscriptExpr(info_result, obj_result, subs_result, op_result, staticArgs_result);
    }

    public Expr forFloatLiteralExprOnly(FloatLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new FloatLiteralExpr(info_result, that.getText(), that.getIntPart(), that.getNumerator(), that.getDenomBase(), that.getDenomPower());
    }

    public Expr forIntLiteralExprOnly(IntLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new IntLiteralExpr(info_result, that.getText(), that.getIntVal());
    }

    public Expr forCharLiteralExprOnly(CharLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new CharLiteralExpr(info_result, that.getText(), that.getCharVal());
    }

    public Expr forStringLiteralExprOnly(StringLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new StringLiteralExpr(info_result, that.getText());
    }

    public Expr forVoidLiteralExprOnly(VoidLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new VoidLiteralExpr(info_result, that.getText());
    }

    public Expr forBooleanLiteralExprOnly(BooleanLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new BooleanLiteralExpr(info_result, that.getText(), that.getBooleanVal());
    }

    public Expr forVarRefOnly(VarRef that, ExprInfo info_result, Id varId_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getVarId() == varId_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new VarRef(info_result, varId_result, staticArgs_result, that.getLexicalDepth());
    }

    public Expr forFieldRefOnly(FieldRef that, ExprInfo info_result, Expr obj_result, Id field_result) {
        if (that.getInfo() == info_result && that.getObj() == obj_result && that.getField() == field_result) return that;
        else return new FieldRef(info_result, obj_result, field_result);
    }

    public Expr forFnRefOnly(FnRef that, ExprInfo info_result, List<StaticArg> staticArgs_result, IdOrOp originalName_result, List<IdOrOp> names_result, List<Overloading> interpOverloadings_result, List<Overloading> newOverloadings_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getOriginalName() == originalName_result && that.getNames() == names_result && that.getInterpOverloadings() == interpOverloadings_result && that.getNewOverloadings() == newOverloadings_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result) return that;
        else return new FnRef(info_result, staticArgs_result, that.getLexicalDepth(), originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public Expr forOpRefOnly(OpRef that, ExprInfo info_result, List<StaticArg> staticArgs_result, IdOrOp originalName_result, List<IdOrOp> names_result, List<Overloading> interpOverloadings_result, List<Overloading> newOverloadings_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getOriginalName() == originalName_result && that.getNames() == names_result && that.getInterpOverloadings() == interpOverloadings_result && that.getNewOverloadings() == newOverloadings_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result) return that;
        else return new OpRef(info_result, staticArgs_result, that.getLexicalDepth(), originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }

    public Expr for_RewriteFnRefOnly(_RewriteFnRef that, ExprInfo info_result, Expr fnExpr_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getFnExpr() == fnExpr_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new _RewriteFnRef(info_result, fnExpr_result, staticArgs_result);
    }

    public Expr for_RewriteObjectExprRefOnly(_RewriteObjectExprRef that, ExprInfo info_result, List<StaticArg> staticArgs_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result) return that;
        else return new _RewriteObjectExprRef(info_result, that.getGenSymName(), staticArgs_result);
    }

    public Expr forJuxtOnly(Juxt that, ExprInfo info_result, FunctionalRef multiJuxt_result, FunctionalRef infixJuxt_result, List<Expr> exprs_result) {
        if (that.getInfo() == info_result && that.getMultiJuxt() == multiJuxt_result && that.getInfixJuxt() == infixJuxt_result && that.getExprs() == exprs_result) return that;
        else return new Juxt(info_result, multiJuxt_result, infixJuxt_result, exprs_result, that.isFnApp(), that.isTight());
    }

    public Expr for_RewriteFnAppOnly(_RewriteFnApp that, ExprInfo info_result, Expr function_result, Expr argument_result) {
        if (that.getInfo() == info_result && that.getFunction() == function_result && that.getArgument() == argument_result) return that;
        else return new _RewriteFnApp(info_result, function_result, argument_result);
    }

    public Expr forOpExprOnly(OpExpr that, ExprInfo info_result, FunctionalRef op_result, List<Expr> args_result) {
        if (that.getInfo() == info_result && that.getOp() == op_result && that.getArgs() == args_result) return that;
        else return new OpExpr(info_result, op_result, args_result);
    }

    public Expr forAmbiguousMultifixOpExprOnly(AmbiguousMultifixOpExpr that, ExprInfo info_result, FunctionalRef infix_op_result, FunctionalRef multifix_op_result, List<Expr> args_result) {
        if (that.getInfo() == info_result && that.getInfix_op() == infix_op_result && that.getMultifix_op() == multifix_op_result && that.getArgs() == args_result) return that;
        else return new AmbiguousMultifixOpExpr(info_result, infix_op_result, multifix_op_result, args_result);
    }

    public Expr forChainExprOnly(ChainExpr that, ExprInfo info_result, Expr first_result, List<Link> links_result) {
        if (that.getInfo() == info_result && that.getFirst() == first_result && that.getLinks() == links_result) return that;
        else return new ChainExpr(info_result, first_result, links_result);
    }

    public Expr forTraitCoercionInvocationOnly(TraitCoercionInvocation that, ExprInfo info_result, Expr arg_result, TraitType toType_result, FnRef coercionFn_result) {
        if (that.getInfo() == info_result && that.getArg() == arg_result && that.getToType() == toType_result && that.getCoercionFn() == coercionFn_result) return that;
        else return new TraitCoercionInvocation(info_result, arg_result, toType_result, coercionFn_result);
    }

    public Expr forTupleCoercionInvocationOnly(TupleCoercionInvocation that, ExprInfo info_result, Expr arg_result, TupleType toType_result, List<Option<CoercionInvocation>> subCoercions_result, Option<Option<CoercionInvocation>> varargCoercion_result) {
        if (that.getInfo() == info_result && that.getArg() == arg_result && that.getToType() == toType_result && that.getSubCoercions() == subCoercions_result && that.getVarargCoercion() == varargCoercion_result) return that;
        else return new TupleCoercionInvocation(info_result, arg_result, toType_result, subCoercions_result, varargCoercion_result);
    }

    public Expr forArrowCoercionInvocationOnly(ArrowCoercionInvocation that, ExprInfo info_result, Expr arg_result, ArrowType toType_result, Option<CoercionInvocation> domainCoercion_result, Option<CoercionInvocation> rangeCoercion_result) {
        if (that.getInfo() == info_result && that.getArg() == arg_result && that.getToType() == toType_result && that.getDomainCoercion() == domainCoercion_result && that.getRangeCoercion() == rangeCoercion_result) return that;
        else return new ArrowCoercionInvocation(info_result, arg_result, toType_result, domainCoercion_result, rangeCoercion_result);
    }

    public Expr forUnionCoercionInvocationOnly(UnionCoercionInvocation that, ExprInfo info_result, Type toType_result, Expr arg_result, List<Type> fromTypes_result, List<Option<CoercionInvocation>> fromCoercions_result) {
        if (that.getInfo() == info_result && that.getToType() == toType_result && that.getArg() == arg_result && that.getFromTypes() == fromTypes_result && that.getFromCoercions() == fromCoercions_result) return that;
        else return new UnionCoercionInvocation(info_result, toType_result, arg_result, fromTypes_result, fromCoercions_result);
    }

    public Expr forMethodInvocationOnly(MethodInvocation that, ExprInfo info_result, Expr obj_result, IdOrOp method_result, List<StaticArg> staticArgs_result, Expr arg_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result) {
        if (that.getInfo() == info_result && that.getObj() == obj_result && that.getMethod() == method_result && that.getStaticArgs() == staticArgs_result && that.getArg() == arg_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result) return that;
        else return new MethodInvocation(info_result, obj_result, method_result, staticArgs_result, arg_result, overloadingType_result, overloadingSchema_result);
    }

    public Expr forMathPrimaryOnly(MathPrimary that, ExprInfo info_result, FunctionalRef multiJuxt_result, FunctionalRef infixJuxt_result, Expr front_result, List<MathItem> rest_result) {
        if (that.getInfo() == info_result && that.getMultiJuxt() == multiJuxt_result && that.getInfixJuxt() == infixJuxt_result && that.getFront() == front_result && that.getRest() == rest_result) return that;
        else return new MathPrimary(info_result, multiJuxt_result, infixJuxt_result, front_result, rest_result);
    }

    public Expr forArrayElementOnly(ArrayElement that, ExprInfo info_result, List<StaticArg> staticArgs_result, Expr element_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getElement() == element_result) return that;
        else return new ArrayElement(info_result, staticArgs_result, element_result);
    }

    public Expr forArrayElementsOnly(ArrayElements that, ExprInfo info_result, List<StaticArg> staticArgs_result, List<ArrayExpr> elements_result) {
        if (that.getInfo() == info_result && that.getStaticArgs() == staticArgs_result && that.getElements() == elements_result) return that;
        else return new ArrayElements(info_result, staticArgs_result, that.getDimension(), elements_result, that.isOutermost());
    }

    public Expr for_SyntaxTransformationExprOnly(_SyntaxTransformationExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationExpr(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationDummyExprOnly(_SyntaxTransformationDummyExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDummyExpr(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationTypeAnnotatedExprOnly(_SyntaxTransformationTypeAnnotatedExpr that, Expr expr_result, Type annType_result, ExprInfo info_result) {
        if (that.getExpr() == expr_result && that.getAnnType() == annType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTypeAnnotatedExpr(expr_result, annType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationAsExprOnly(_SyntaxTransformationAsExpr that, Expr expr_result, Type annType_result, ExprInfo info_result) {
        if (that.getExpr() == expr_result && that.getAnnType() == annType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAsExpr(expr_result, annType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationAsIfExprOnly(_SyntaxTransformationAsIfExpr that, Expr expr_result, Type annType_result, ExprInfo info_result) {
        if (that.getExpr() == expr_result && that.getAnnType() == annType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAsIfExpr(expr_result, annType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationAssignmentOnly(_SyntaxTransformationAssignment that, List<Lhs> lhs_result, Option<FunctionalRef> assignOp_result, Expr rhs_result, List<CompoundAssignmentInfo> assignmentInfos_result, ExprInfo info_result) {
        if (that.getLhs() == lhs_result && that.getAssignOp() == assignOp_result && that.getRhs() == rhs_result && that.getAssignmentInfos() == assignmentInfos_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAssignment(lhs_result, assignOp_result, rhs_result, assignmentInfos_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationBlockOnly(_SyntaxTransformationBlock that, Option<Expr> loc_result, List<Expr> exprs_result, ExprInfo info_result) {
        if (that.getLoc() == loc_result && that.getExprs() == exprs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBlock(loc_result, that.isAtomicBlock(), that.isWithinDo(), exprs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationDoOnly(_SyntaxTransformationDo that, List<Block> fronts_result, ExprInfo info_result) {
        if (that.getFronts() == fronts_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDo(fronts_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationCaseExprOnly(_SyntaxTransformationCaseExpr that, Option<Expr> param_result, Option<FunctionalRef> compare_result, FunctionalRef equalsOp_result, FunctionalRef inOp_result, List<CaseClause> clauses_result, Option<Block> elseClause_result, ExprInfo info_result) {
        if (that.getParam() == param_result && that.getCompare() == compare_result && that.getEqualsOp() == equalsOp_result && that.getInOp() == inOp_result && that.getClauses() == clauses_result && that.getElseClause() == elseClause_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCaseExpr(param_result, compare_result, equalsOp_result, inOp_result, clauses_result, elseClause_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationIfOnly(_SyntaxTransformationIf that, List<IfClause> clauses_result, Option<Block> elseClause_result, ExprInfo info_result) {
        if (that.getClauses() == clauses_result && that.getElseClause() == elseClause_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIf(clauses_result, elseClause_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationLabelOnly(_SyntaxTransformationLabel that, Id name_result, Block body_result, ExprInfo info_result) {
        if (that.getName() == name_result && that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationLabel(name_result, body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationAbstractObjectExprOnly(_SyntaxTransformationAbstractObjectExpr that, TraitTypeHeader header_result, ExprInfo info_result) {
        if (that.getHeader() == header_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAbstractObjectExpr(header_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationObjectExprOnly(_SyntaxTransformationObjectExpr that, TraitTypeHeader header_result, Option<SelfType> selfType_result, ExprInfo info_result) {
        if (that.getHeader() == header_result && that.getSelfType() == selfType_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationObjectExpr(header_result, selfType_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformation_RewriteObjectExprOnly(_SyntaxTransformation_RewriteObjectExpr that, TraitTypeHeader header_result, List<StaticArg> staticArgs_result, ExprInfo info_result) {
        if (that.getHeader() == header_result && that.getStaticArgs() == staticArgs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformation_RewriteObjectExpr(header_result, that.getImplicitTypeParameters(), that.getGenSymName(), staticArgs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationTryOnly(_SyntaxTransformationTry that, Block body_result, Option<Catch> catchClause_result, List<BaseType> forbidClause_result, Option<Block> finallyClause_result, ExprInfo info_result) {
        if (that.getBody() == body_result && that.getCatchClause() == catchClause_result && that.getForbidClause() == forbidClause_result && that.getFinallyClause() == finallyClause_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTry(body_result, catchClause_result, forbidClause_result, finallyClause_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationTupleExprOnly(_SyntaxTransformationTupleExpr that, List<Expr> exprs_result, Option<Expr> varargs_result, List<KeywordExpr> keywords_result, ExprInfo info_result) {
        if (that.getExprs() == exprs_result && that.getVarargs() == varargs_result && that.getKeywords() == keywords_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTupleExpr(exprs_result, varargs_result, keywords_result, that.isInApp(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationTypecaseOnly(_SyntaxTransformationTypecase that, Expr bindExpr_result, List<TypecaseClause> clauses_result, Option<Block> elseClause_result, ExprInfo info_result) {
        if (that.getBindExpr() == bindExpr_result && that.getClauses() == clauses_result && that.getElseClause() == elseClause_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTypecase(bindExpr_result, clauses_result, elseClause_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationWhileOnly(_SyntaxTransformationWhile that, GeneratorClause testExpr_result, Do body_result, ExprInfo info_result) {
        if (that.getTestExpr() == testExpr_result && that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationWhile(testExpr_result, body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationForOnly(_SyntaxTransformationFor that, List<GeneratorClause> gens_result, Block body_result, ExprInfo info_result) {
        if (that.getGens() == gens_result && that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationFor(gens_result, body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationBigOpAppOnly(_SyntaxTransformationBigOpApp that, List<StaticArg> staticArgs_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBigOpApp(staticArgs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationAccumulatorOnly(_SyntaxTransformationAccumulator that, List<StaticArg> staticArgs_result, Op accOp_result, List<GeneratorClause> gens_result, Expr body_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getAccOp() == accOp_result && that.getGens() == gens_result && that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAccumulator(staticArgs_result, accOp_result, gens_result, body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationArrayComprehensionOnly(_SyntaxTransformationArrayComprehension that, List<StaticArg> staticArgs_result, List<ArrayComprehensionClause> clauses_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getClauses() == clauses_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationArrayComprehension(staticArgs_result, clauses_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationAtomicExprOnly(_SyntaxTransformationAtomicExpr that, Expr expr_result, ExprInfo info_result) {
        if (that.getExpr() == expr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAtomicExpr(expr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationExitOnly(_SyntaxTransformationExit that, Option<Id> target_result, Option<Expr> returnExpr_result, ExprInfo info_result) {
        if (that.getTarget() == target_result && that.getReturnExpr() == returnExpr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationExit(target_result, returnExpr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationSpawnOnly(_SyntaxTransformationSpawn that, Expr body_result, ExprInfo info_result) {
        if (that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationSpawn(body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationThrowOnly(_SyntaxTransformationThrow that, Expr expr_result, ExprInfo info_result) {
        if (that.getExpr() == expr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationThrow(expr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationTryAtomicExprOnly(_SyntaxTransformationTryAtomicExpr that, Expr expr_result, ExprInfo info_result) {
        if (that.getExpr() == expr_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTryAtomicExpr(expr_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationFnExprOnly(_SyntaxTransformationFnExpr that, FnHeader header_result, Expr body_result, ExprInfo info_result) {
        if (that.getHeader() == header_result && that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationFnExpr(header_result, body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationLetExprOnly(_SyntaxTransformationLetExpr that, Block body_result, ExprInfo info_result) {
        if (that.getBody() == body_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationLetExpr(body_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationLetFnOnly(_SyntaxTransformationLetFn that, Block body_result, List<FnDecl> fns_result, ExprInfo info_result) {
        if (that.getBody() == body_result && that.getFns() == fns_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationLetFn(body_result, fns_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationLocalVarDeclOnly(_SyntaxTransformationLocalVarDecl that, Block body_result, List<LValue> lhs_result, Option<Expr> rhs_result, ExprInfo info_result) {
        if (that.getBody() == body_result && that.getLhs() == lhs_result && that.getRhs() == rhs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationLocalVarDecl(body_result, lhs_result, rhs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationSimpleExprOnly(_SyntaxTransformationSimpleExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationSimpleExpr(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationSubscriptExprOnly(_SyntaxTransformationSubscriptExpr that, Expr obj_result, List<Expr> subs_result, Option<Op> op_result, List<StaticArg> staticArgs_result, ExprInfo info_result) {
        if (that.getObj() == obj_result && that.getSubs() == subs_result && that.getOp() == op_result && that.getStaticArgs() == staticArgs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationSubscriptExpr(obj_result, subs_result, op_result, staticArgs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationPrimaryOnly(_SyntaxTransformationPrimary that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationPrimary(info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationLiteralExprOnly(_SyntaxTransformationLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationLiteralExpr(that.getText(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationNumberLiteralExprOnly(_SyntaxTransformationNumberLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationNumberLiteralExpr(that.getText(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationFloatLiteralExprOnly(_SyntaxTransformationFloatLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationFloatLiteralExpr(that.getText(), that.getIntPart(), that.getNumerator(), that.getDenomBase(), that.getDenomPower(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationIntLiteralExprOnly(_SyntaxTransformationIntLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIntLiteralExpr(that.getText(), that.getIntVal(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationCharLiteralExprOnly(_SyntaxTransformationCharLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCharLiteralExpr(that.getText(), that.getCharVal(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationStringLiteralExprOnly(_SyntaxTransformationStringLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationStringLiteralExpr(that.getText(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationVoidLiteralExprOnly(_SyntaxTransformationVoidLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationVoidLiteralExpr(that.getText(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationBooleanLiteralExprOnly(_SyntaxTransformationBooleanLiteralExpr that, ExprInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBooleanLiteralExpr(that.getText(), that.getBooleanVal(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationVarRefOnly(_SyntaxTransformationVarRef that, Id varId_result, List<StaticArg> staticArgs_result, ExprInfo info_result) {
        if (that.getVarId() == varId_result && that.getStaticArgs() == staticArgs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationVarRef(varId_result, staticArgs_result, that.getLexicalDepth(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationFieldRefOnly(_SyntaxTransformationFieldRef that, Expr obj_result, Id field_result, ExprInfo info_result) {
        if (that.getObj() == obj_result && that.getField() == field_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationFieldRef(obj_result, field_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationFunctionalRefOnly(_SyntaxTransformationFunctionalRef that, List<StaticArg> staticArgs_result, IdOrOp originalName_result, List<IdOrOp> names_result, List<Overloading> interpOverloadings_result, List<Overloading> newOverloadings_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getOriginalName() == originalName_result && that.getNames() == names_result && that.getInterpOverloadings() == interpOverloadings_result && that.getNewOverloadings() == newOverloadings_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationFunctionalRef(staticArgs_result, that.getLexicalDepth(), originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationFnRefOnly(_SyntaxTransformationFnRef that, List<StaticArg> staticArgs_result, IdOrOp originalName_result, List<IdOrOp> names_result, List<Overloading> interpOverloadings_result, List<Overloading> newOverloadings_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getOriginalName() == originalName_result && that.getNames() == names_result && that.getInterpOverloadings() == interpOverloadings_result && that.getNewOverloadings() == newOverloadings_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationFnRef(staticArgs_result, that.getLexicalDepth(), originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationOpRefOnly(_SyntaxTransformationOpRef that, List<StaticArg> staticArgs_result, IdOrOp originalName_result, List<IdOrOp> names_result, List<Overloading> interpOverloadings_result, List<Overloading> newOverloadings_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getOriginalName() == originalName_result && that.getNames() == names_result && that.getInterpOverloadings() == interpOverloadings_result && that.getNewOverloadings() == newOverloadings_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationOpRef(staticArgs_result, that.getLexicalDepth(), originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformation_RewriteFnRefOnly(_SyntaxTransformation_RewriteFnRef that, Expr fnExpr_result, List<StaticArg> staticArgs_result, ExprInfo info_result) {
        if (that.getFnExpr() == fnExpr_result && that.getStaticArgs() == staticArgs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformation_RewriteFnRef(fnExpr_result, staticArgs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformation_RewriteObjectExprRefOnly(_SyntaxTransformation_RewriteObjectExprRef that, List<StaticArg> staticArgs_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformation_RewriteObjectExprRef(that.getGenSymName(), staticArgs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationJuxtOnly(_SyntaxTransformationJuxt that, FunctionalRef multiJuxt_result, FunctionalRef infixJuxt_result, List<Expr> exprs_result, ExprInfo info_result) {
        if (that.getMultiJuxt() == multiJuxt_result && that.getInfixJuxt() == infixJuxt_result && that.getExprs() == exprs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationJuxt(multiJuxt_result, infixJuxt_result, exprs_result, that.isFnApp(), that.isTight(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformation_RewriteFnAppOnly(_SyntaxTransformation_RewriteFnApp that, Expr function_result, Expr argument_result, ExprInfo info_result) {
        if (that.getFunction() == function_result && that.getArgument() == argument_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformation_RewriteFnApp(function_result, argument_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationOpExprOnly(_SyntaxTransformationOpExpr that, FunctionalRef op_result, List<Expr> args_result, ExprInfo info_result) {
        if (that.getOp() == op_result && that.getArgs() == args_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationOpExpr(op_result, args_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationAmbiguousMultifixOpExprOnly(_SyntaxTransformationAmbiguousMultifixOpExpr that, FunctionalRef infix_op_result, FunctionalRef multifix_op_result, List<Expr> args_result, ExprInfo info_result) {
        if (that.getInfix_op() == infix_op_result && that.getMultifix_op() == multifix_op_result && that.getArgs() == args_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationAmbiguousMultifixOpExpr(infix_op_result, multifix_op_result, args_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationChainExprOnly(_SyntaxTransformationChainExpr that, Expr first_result, List<Link> links_result, ExprInfo info_result) {
        if (that.getFirst() == first_result && that.getLinks() == links_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationChainExpr(first_result, links_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationCoercionInvocationOnly(_SyntaxTransformationCoercionInvocation that, Type toType_result, Expr arg_result, ExprInfo info_result) {
        if (that.getToType() == toType_result && that.getArg() == arg_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationCoercionInvocation(toType_result, arg_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationTraitCoercionInvocationOnly(_SyntaxTransformationTraitCoercionInvocation that, Expr arg_result, TraitType toType_result, FnRef coercionFn_result, ExprInfo info_result) {
        if (that.getArg() == arg_result && that.getToType() == toType_result && that.getCoercionFn() == coercionFn_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTraitCoercionInvocation(arg_result, toType_result, coercionFn_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationTupleCoercionInvocationOnly(_SyntaxTransformationTupleCoercionInvocation that, Expr arg_result, TupleType toType_result, List<Option<CoercionInvocation>> subCoercions_result, Option<Option<CoercionInvocation>> varargCoercion_result, ExprInfo info_result) {
        if (that.getArg() == arg_result && that.getToType() == toType_result && that.getSubCoercions() == subCoercions_result && that.getVarargCoercion() == varargCoercion_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTupleCoercionInvocation(arg_result, toType_result, subCoercions_result, varargCoercion_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationArrowCoercionInvocationOnly(_SyntaxTransformationArrowCoercionInvocation that, Expr arg_result, ArrowType toType_result, Option<CoercionInvocation> domainCoercion_result, Option<CoercionInvocation> rangeCoercion_result, ExprInfo info_result) {
        if (that.getArg() == arg_result && that.getToType() == toType_result && that.getDomainCoercion() == domainCoercion_result && that.getRangeCoercion() == rangeCoercion_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationArrowCoercionInvocation(arg_result, toType_result, domainCoercion_result, rangeCoercion_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationUnionCoercionInvocationOnly(_SyntaxTransformationUnionCoercionInvocation that, Type toType_result, Expr arg_result, List<Type> fromTypes_result, List<Option<CoercionInvocation>> fromCoercions_result, ExprInfo info_result) {
        if (that.getToType() == toType_result && that.getArg() == arg_result && that.getFromTypes() == fromTypes_result && that.getFromCoercions() == fromCoercions_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationUnionCoercionInvocation(toType_result, arg_result, fromTypes_result, fromCoercions_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationMethodInvocationOnly(_SyntaxTransformationMethodInvocation that, Expr obj_result, IdOrOp method_result, List<StaticArg> staticArgs_result, Expr arg_result, Option<Type> overloadingType_result, Option<Type> overloadingSchema_result, ExprInfo info_result) {
        if (that.getObj() == obj_result && that.getMethod() == method_result && that.getStaticArgs() == staticArgs_result && that.getArg() == arg_result && that.getOverloadingType() == overloadingType_result && that.getOverloadingSchema() == overloadingSchema_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationMethodInvocation(obj_result, method_result, staticArgs_result, arg_result, overloadingType_result, overloadingSchema_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationMathPrimaryOnly(_SyntaxTransformationMathPrimary that, FunctionalRef multiJuxt_result, FunctionalRef infixJuxt_result, Expr front_result, List<MathItem> rest_result, ExprInfo info_result) {
        if (that.getMultiJuxt() == multiJuxt_result && that.getInfixJuxt() == infixJuxt_result && that.getFront() == front_result && that.getRest() == rest_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationMathPrimary(multiJuxt_result, infixJuxt_result, front_result, rest_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationArrayExprOnly(_SyntaxTransformationArrayExpr that, List<StaticArg> staticArgs_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationArrayExpr(staticArgs_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationArrayElementOnly(_SyntaxTransformationArrayElement that, List<StaticArg> staticArgs_result, Expr element_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getElement() == element_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationArrayElement(staticArgs_result, element_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_SyntaxTransformationArrayElementsOnly(_SyntaxTransformationArrayElements that, List<StaticArg> staticArgs_result, List<ArrayExpr> elements_result, ExprInfo info_result) {
        if (that.getStaticArgs() == staticArgs_result && that.getElements() == elements_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationArrayElements(staticArgs_result, that.getDimension(), elements_result, that.isOutermost(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public Expr for_EllipsesExprOnly(_EllipsesExpr that) {
        return that;
    }

    public Expr for_EllipsesDummyExprOnly(_EllipsesDummyExpr that) {
        return that;
    }

    public Expr for_EllipsesTypeAnnotatedExprOnly(_EllipsesTypeAnnotatedExpr that) {
        return that;
    }

    public Expr for_EllipsesAsExprOnly(_EllipsesAsExpr that) {
        return that;
    }

    public Expr for_EllipsesAsIfExprOnly(_EllipsesAsIfExpr that) {
        return that;
    }

    public Expr for_EllipsesAssignmentOnly(_EllipsesAssignment that) {
        return that;
    }

    public Expr for_EllipsesBlockOnly(_EllipsesBlock that) {
        return that;
    }

    public Expr for_EllipsesDoOnly(_EllipsesDo that) {
        return that;
    }

    public Expr for_EllipsesCaseExprOnly(_EllipsesCaseExpr that) {
        return that;
    }

    public Expr for_EllipsesIfOnly(_EllipsesIf that) {
        return that;
    }

    public Expr for_EllipsesLabelOnly(_EllipsesLabel that) {
        return that;
    }

    public Expr for_EllipsesAbstractObjectExprOnly(_EllipsesAbstractObjectExpr that) {
        return that;
    }

    public Expr for_EllipsesObjectExprOnly(_EllipsesObjectExpr that) {
        return that;
    }

    public Expr for_Ellipses_RewriteObjectExprOnly(_Ellipses_RewriteObjectExpr that) {
        return that;
    }

    public Expr for_EllipsesTryOnly(_EllipsesTry that) {
        return that;
    }

    public Expr for_EllipsesTupleExprOnly(_EllipsesTupleExpr that) {
        return that;
    }

    public Expr for_EllipsesTypecaseOnly(_EllipsesTypecase that) {
        return that;
    }

    public Expr for_EllipsesWhileOnly(_EllipsesWhile that) {
        return that;
    }

    public Expr for_EllipsesForOnly(_EllipsesFor that) {
        return that;
    }

    public Expr for_EllipsesBigOpAppOnly(_EllipsesBigOpApp that) {
        return that;
    }

    public Expr for_EllipsesAccumulatorOnly(_EllipsesAccumulator that) {
        return that;
    }

    public Expr for_EllipsesArrayComprehensionOnly(_EllipsesArrayComprehension that) {
        return that;
    }

    public Expr for_EllipsesAtomicExprOnly(_EllipsesAtomicExpr that) {
        return that;
    }

    public Expr for_EllipsesExitOnly(_EllipsesExit that) {
        return that;
    }

    public Expr for_EllipsesSpawnOnly(_EllipsesSpawn that) {
        return that;
    }

    public Expr for_EllipsesThrowOnly(_EllipsesThrow that) {
        return that;
    }

    public Expr for_EllipsesTryAtomicExprOnly(_EllipsesTryAtomicExpr that) {
        return that;
    }

    public Expr for_EllipsesFnExprOnly(_EllipsesFnExpr that) {
        return that;
    }

    public Expr for_EllipsesLetExprOnly(_EllipsesLetExpr that) {
        return that;
    }

    public Expr for_EllipsesLetFnOnly(_EllipsesLetFn that) {
        return that;
    }

    public Expr for_EllipsesLocalVarDeclOnly(_EllipsesLocalVarDecl that) {
        return that;
    }

    public Expr for_EllipsesSimpleExprOnly(_EllipsesSimpleExpr that) {
        return that;
    }

    public Expr for_EllipsesSubscriptExprOnly(_EllipsesSubscriptExpr that) {
        return that;
    }

    public Expr for_EllipsesPrimaryOnly(_EllipsesPrimary that) {
        return that;
    }

    public Expr for_EllipsesLiteralExprOnly(_EllipsesLiteralExpr that) {
        return that;
    }

    public Expr for_EllipsesNumberLiteralExprOnly(_EllipsesNumberLiteralExpr that) {
        return that;
    }

    public Expr for_EllipsesFloatLiteralExprOnly(_EllipsesFloatLiteralExpr that) {
        return that;
    }

    public Expr for_EllipsesIntLiteralExprOnly(_EllipsesIntLiteralExpr that) {
        return that;
    }

    public Expr for_EllipsesCharLiteralExprOnly(_EllipsesCharLiteralExpr that) {
        return that;
    }

    public Expr for_EllipsesStringLiteralExprOnly(_EllipsesStringLiteralExpr that) {
        return that;
    }

    public Expr for_EllipsesVoidLiteralExprOnly(_EllipsesVoidLiteralExpr that) {
        return that;
    }

    public Expr for_EllipsesBooleanLiteralExprOnly(_EllipsesBooleanLiteralExpr that) {
        return that;
    }

    public Expr for_EllipsesVarRefOnly(_EllipsesVarRef that) {
        return that;
    }

    public Expr for_EllipsesFieldRefOnly(_EllipsesFieldRef that) {
        return that;
    }

    public Expr for_EllipsesFunctionalRefOnly(_EllipsesFunctionalRef that) {
        return that;
    }

    public Expr for_EllipsesFnRefOnly(_EllipsesFnRef that) {
        return that;
    }

    public Expr for_EllipsesOpRefOnly(_EllipsesOpRef that) {
        return that;
    }

    public Expr for_Ellipses_RewriteFnRefOnly(_Ellipses_RewriteFnRef that) {
        return that;
    }

    public Expr for_Ellipses_RewriteObjectExprRefOnly(_Ellipses_RewriteObjectExprRef that) {
        return that;
    }

    public Expr for_EllipsesJuxtOnly(_EllipsesJuxt that) {
        return that;
    }

    public Expr for_Ellipses_RewriteFnAppOnly(_Ellipses_RewriteFnApp that) {
        return that;
    }

    public Expr for_EllipsesOpExprOnly(_EllipsesOpExpr that) {
        return that;
    }

    public Expr for_EllipsesAmbiguousMultifixOpExprOnly(_EllipsesAmbiguousMultifixOpExpr that) {
        return that;
    }

    public Expr for_EllipsesChainExprOnly(_EllipsesChainExpr that) {
        return that;
    }

    public Expr for_EllipsesCoercionInvocationOnly(_EllipsesCoercionInvocation that) {
        return that;
    }

    public Expr for_EllipsesTraitCoercionInvocationOnly(_EllipsesTraitCoercionInvocation that) {
        return that;
    }

    public Expr for_EllipsesTupleCoercionInvocationOnly(_EllipsesTupleCoercionInvocation that) {
        return that;
    }

    public Expr for_EllipsesArrowCoercionInvocationOnly(_EllipsesArrowCoercionInvocation that) {
        return that;
    }

    public Expr for_EllipsesUnionCoercionInvocationOnly(_EllipsesUnionCoercionInvocation that) {
        return that;
    }

    public Expr for_EllipsesMethodInvocationOnly(_EllipsesMethodInvocation that) {
        return that;
    }

    public Expr for_EllipsesMathPrimaryOnly(_EllipsesMathPrimary that) {
        return that;
    }

    public Expr for_EllipsesArrayExprOnly(_EllipsesArrayExpr that) {
        return that;
    }

    public Expr for_EllipsesArrayElementOnly(_EllipsesArrayElement that) {
        return that;
    }

    public Expr for_EllipsesArrayElementsOnly(_EllipsesArrayElements that) {
        return that;
    }

    public Expr forTemplateGapExprOnly(TemplateGapExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapDummyExprOnly(TemplateGapDummyExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDummyExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapTypeAnnotatedExprOnly(TemplateGapTypeAnnotatedExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTypeAnnotatedExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapAsExprOnly(TemplateGapAsExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAsExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapAsIfExprOnly(TemplateGapAsIfExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAsIfExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapAssignmentOnly(TemplateGapAssignment that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAssignment(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapBlockOnly(TemplateGapBlock that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBlock(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapDoOnly(TemplateGapDo that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDo(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapCaseExprOnly(TemplateGapCaseExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCaseExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapIfOnly(TemplateGapIf that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIf(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapLabelOnly(TemplateGapLabel that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLabel(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapAbstractObjectExprOnly(TemplateGapAbstractObjectExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAbstractObjectExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapObjectExprOnly(TemplateGapObjectExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapObjectExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGap_RewriteObjectExprOnly(TemplateGap_RewriteObjectExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteObjectExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapTryOnly(TemplateGapTry that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTry(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapTupleExprOnly(TemplateGapTupleExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTupleExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapTypecaseOnly(TemplateGapTypecase that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTypecase(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapWhileOnly(TemplateGapWhile that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapWhile(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapForOnly(TemplateGapFor that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFor(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapBigOpAppOnly(TemplateGapBigOpApp that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBigOpApp(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapAccumulatorOnly(TemplateGapAccumulator that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAccumulator(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapArrayComprehensionOnly(TemplateGapArrayComprehension that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayComprehension(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapAtomicExprOnly(TemplateGapAtomicExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAtomicExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapExitOnly(TemplateGapExit that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapExit(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapSpawnOnly(TemplateGapSpawn that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSpawn(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapThrowOnly(TemplateGapThrow that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapThrow(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapTryAtomicExprOnly(TemplateGapTryAtomicExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTryAtomicExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapFnExprOnly(TemplateGapFnExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFnExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapLetExprOnly(TemplateGapLetExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLetExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapLetFnOnly(TemplateGapLetFn that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLetFn(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapLocalVarDeclOnly(TemplateGapLocalVarDecl that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLocalVarDecl(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapSimpleExprOnly(TemplateGapSimpleExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSimpleExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapSubscriptExprOnly(TemplateGapSubscriptExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapSubscriptExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapPrimaryOnly(TemplateGapPrimary that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapPrimary(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapLiteralExprOnly(TemplateGapLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapNumberLiteralExprOnly(TemplateGapNumberLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapNumberLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapFloatLiteralExprOnly(TemplateGapFloatLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFloatLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapIntLiteralExprOnly(TemplateGapIntLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapCharLiteralExprOnly(TemplateGapCharLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCharLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapStringLiteralExprOnly(TemplateGapStringLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapStringLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapVoidLiteralExprOnly(TemplateGapVoidLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapVoidLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapBooleanLiteralExprOnly(TemplateGapBooleanLiteralExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBooleanLiteralExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapVarRefOnly(TemplateGapVarRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapVarRef(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapFieldRefOnly(TemplateGapFieldRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFieldRef(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapFunctionalRefOnly(TemplateGapFunctionalRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFunctionalRef(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapFnRefOnly(TemplateGapFnRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapFnRef(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapOpRefOnly(TemplateGapOpRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapOpRef(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGap_RewriteFnRefOnly(TemplateGap_RewriteFnRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteFnRef(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGap_RewriteObjectExprRefOnly(TemplateGap_RewriteObjectExprRef that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteObjectExprRef(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapJuxtOnly(TemplateGapJuxt that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapJuxt(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGap_RewriteFnAppOnly(TemplateGap_RewriteFnApp that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGap_RewriteFnApp(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapOpExprOnly(TemplateGapOpExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapOpExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapAmbiguousMultifixOpExprOnly(TemplateGapAmbiguousMultifixOpExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapAmbiguousMultifixOpExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapChainExprOnly(TemplateGapChainExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapChainExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapCoercionInvocationOnly(TemplateGapCoercionInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapCoercionInvocation(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapTraitCoercionInvocationOnly(TemplateGapTraitCoercionInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTraitCoercionInvocation(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapTupleCoercionInvocationOnly(TemplateGapTupleCoercionInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTupleCoercionInvocation(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapArrowCoercionInvocationOnly(TemplateGapArrowCoercionInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrowCoercionInvocation(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapUnionCoercionInvocationOnly(TemplateGapUnionCoercionInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnionCoercionInvocation(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapMethodInvocationOnly(TemplateGapMethodInvocation that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapMethodInvocation(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapMathPrimaryOnly(TemplateGapMathPrimary that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapMathPrimary(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapArrayExprOnly(TemplateGapArrayExpr that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayExpr(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapArrayElementOnly(TemplateGapArrayElement that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayElement(info_result, gapId_result, templateParams_result);
    }

    public Expr forTemplateGapArrayElementsOnly(TemplateGapArrayElements that, ExprInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapArrayElements(info_result, gapId_result, templateParams_result);
    }

    /** Methods to recur on each child. */

    public Expr forDummyExpr(DummyExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return forDummyExprOnly(that, info_result);
    }


    public Expr forAsExpr(AsExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr expr_result = recur(that.getExpr());
        Type annType_result = recurOnType(that.getAnnType());
        return forAsExprOnly(that, info_result, expr_result, annType_result);
    }


    public Expr forAsIfExpr(AsIfExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr expr_result = recur(that.getExpr());
        Type annType_result = recurOnType(that.getAnnType());
        return forAsIfExprOnly(that, info_result, expr_result, annType_result);
    }


    public Expr forAssignment(Assignment that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<Lhs> lhs_result = recurOnListOfLhs(that.getLhs());
        Option<FunctionalRef> assignOp_result = recurOnOptionOfFunctionalRef(that.getAssignOp());
        Expr rhs_result = recur(that.getRhs());
        List<CompoundAssignmentInfo> assignmentInfos_result = recurOnListOfCompoundAssignmentInfo(that.getAssignmentInfos());
        return forAssignmentOnly(that, info_result, lhs_result, assignOp_result, rhs_result, assignmentInfos_result);
    }


    public Expr forBlock(Block that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Option<Expr> loc_result = recurOnOptionOfExpr(that.getLoc());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        return forBlockOnly(that, info_result, loc_result, exprs_result);
    }


    public Expr forDo(Do that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<Block> fronts_result = recurOnListOfBlock(that.getFronts());
        return forDoOnly(that, info_result, fronts_result);
    }


    public Expr forCaseExpr(CaseExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Option<Expr> param_result = recurOnOptionOfExpr(that.getParam());
        Option<FunctionalRef> compare_result = recurOnOptionOfFunctionalRef(that.getCompare());
        FunctionalRef equalsOp_result = (FunctionalRef) recur(that.getEqualsOp());
        FunctionalRef inOp_result = (FunctionalRef) recur(that.getInOp());
        List<CaseClause> clauses_result = recurOnListOfCaseClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forCaseExprOnly(that, info_result, param_result, compare_result, equalsOp_result, inOp_result, clauses_result, elseClause_result);
    }


    public Expr forIf(If that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<IfClause> clauses_result = recurOnListOfIfClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forIfOnly(that, info_result, clauses_result, elseClause_result);
    }


    public Expr forLabel(Label that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id name_result = recurOnId(that.getName());
        Block body_result = (Block) recur(that.getBody());
        return forLabelOnly(that, info_result, name_result, body_result);
    }


    public Expr forObjectExpr(ObjectExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        TraitTypeHeader header_result = recurOnTraitTypeHeader(that.getHeader());
        Option<SelfType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        return forObjectExprOnly(that, info_result, header_result, selfType_result);
    }


    public Expr for_RewriteObjectExpr(_RewriteObjectExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        TraitTypeHeader header_result = recurOnTraitTypeHeader(that.getHeader());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_RewriteObjectExprOnly(that, info_result, header_result, staticArgs_result);
    }


    public Expr forTry(Try that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Block body_result = (Block) recur(that.getBody());
        Option<Catch> catchClause_result = recurOnOptionOfCatch(that.getCatchClause());
        List<BaseType> forbidClause_result = recurOnListOfBaseType(that.getForbidClause());
        Option<Block> finallyClause_result = recurOnOptionOfBlock(that.getFinallyClause());
        return forTryOnly(that, info_result, body_result, catchClause_result, forbidClause_result, finallyClause_result);
    }


    public Expr forTupleExpr(TupleExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        Option<Expr> varargs_result = recurOnOptionOfExpr(that.getVarargs());
        List<KeywordExpr> keywords_result = recurOnListOfKeywordExpr(that.getKeywords());
        return forTupleExprOnly(that, info_result, exprs_result, varargs_result, keywords_result);
    }


    public Expr forTypecase(Typecase that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr bindExpr_result = recur(that.getBindExpr());
        List<TypecaseClause> clauses_result = recurOnListOfTypecaseClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forTypecaseOnly(that, info_result, bindExpr_result, clauses_result, elseClause_result);
    }


    public Expr forWhile(While that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        GeneratorClause testExpr_result = recurOnGeneratorClause(that.getTestExpr());
        Do body_result = (Do) recur(that.getBody());
        return forWhileOnly(that, info_result, testExpr_result, body_result);
    }


    public Expr forFor(For that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        Block body_result = (Block) recur(that.getBody());
        return forForOnly(that, info_result, gens_result, body_result);
    }


    public Expr forAccumulator(Accumulator that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Op accOp_result = recurOnOp(that.getAccOp());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        Expr body_result = recur(that.getBody());
        return forAccumulatorOnly(that, info_result, staticArgs_result, accOp_result, gens_result, body_result);
    }


    public Expr forArrayComprehension(ArrayComprehension that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<ArrayComprehensionClause> clauses_result = recurOnListOfArrayComprehensionClause(that.getClauses());
        return forArrayComprehensionOnly(that, info_result, staticArgs_result, clauses_result);
    }


    public Expr forAtomicExpr(AtomicExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr expr_result = recur(that.getExpr());
        return forAtomicExprOnly(that, info_result, expr_result);
    }


    public Expr forExit(Exit that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Option<Id> target_result = recurOnOptionOfId(that.getTarget());
        Option<Expr> returnExpr_result = recurOnOptionOfExpr(that.getReturnExpr());
        return forExitOnly(that, info_result, target_result, returnExpr_result);
    }


    public Expr forSpawn(Spawn that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr body_result = recur(that.getBody());
        return forSpawnOnly(that, info_result, body_result);
    }


    public Expr forThrow(Throw that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr expr_result = recur(that.getExpr());
        return forThrowOnly(that, info_result, expr_result);
    }


    public Expr forTryAtomicExpr(TryAtomicExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr expr_result = recur(that.getExpr());
        return forTryAtomicExprOnly(that, info_result, expr_result);
    }


    public Expr forFnExpr(FnExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        FnHeader header_result = recurOnFnHeader(that.getHeader());
        Expr body_result = recur(that.getBody());
        return forFnExprOnly(that, info_result, header_result, body_result);
    }


    public Expr forLetFn(LetFn that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Block body_result = (Block) recur(that.getBody());
        List<FnDecl> fns_result = recurOnListOfFnDecl(that.getFns());
        return forLetFnOnly(that, info_result, body_result, fns_result);
    }


    public Expr forLocalVarDecl(LocalVarDecl that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Block body_result = (Block) recur(that.getBody());
        List<LValue> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<Expr> rhs_result = recurOnOptionOfExpr(that.getRhs());
        return forLocalVarDeclOnly(that, info_result, body_result, lhs_result, rhs_result);
    }


    public Expr forSubscriptExpr(SubscriptExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr obj_result = recur(that.getObj());
        List<Expr> subs_result = recurOnListOfExpr(that.getSubs());
        Option<Op> op_result = recurOnOptionOfOp(that.getOp());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return forSubscriptExprOnly(that, info_result, obj_result, subs_result, op_result, staticArgs_result);
    }


    public Expr forFloatLiteralExpr(FloatLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return forFloatLiteralExprOnly(that, info_result);
    }


    public Expr forIntLiteralExpr(IntLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return forIntLiteralExprOnly(that, info_result);
    }


    public Expr forCharLiteralExpr(CharLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return forCharLiteralExprOnly(that, info_result);
    }


    public Expr forStringLiteralExpr(StringLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return forStringLiteralExprOnly(that, info_result);
    }


    public Expr forVoidLiteralExpr(VoidLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return forVoidLiteralExprOnly(that, info_result);
    }


    public Expr forBooleanLiteralExpr(BooleanLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return forBooleanLiteralExprOnly(that, info_result);
    }


    public Expr forVarRef(VarRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id varId_result = recurOnId(that.getVarId());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return forVarRefOnly(that, info_result, varId_result, staticArgs_result);
    }


    public Expr forFieldRef(FieldRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr obj_result = recur(that.getObj());
        Id field_result = recurOnId(that.getField());
        return forFieldRefOnly(that, info_result, obj_result, field_result);
    }


    public Expr forFnRef(FnRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        IdOrOp originalName_result = recurOnIdOrOp(that.getOriginalName());
        List<IdOrOp> names_result = recurOnListOfIdOrOp(that.getNames());
        List<Overloading> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<Overloading> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return forFnRefOnly(that, info_result, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }


    public Expr forOpRef(OpRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        IdOrOp originalName_result = recurOnIdOrOp(that.getOriginalName());
        List<IdOrOp> names_result = recurOnListOfIdOrOp(that.getNames());
        List<Overloading> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<Overloading> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return forOpRefOnly(that, info_result, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result);
    }


    public Expr for_RewriteFnRef(_RewriteFnRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr fnExpr_result = recur(that.getFnExpr());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_RewriteFnRefOnly(that, info_result, fnExpr_result, staticArgs_result);
    }


    public Expr for_RewriteObjectExprRef(_RewriteObjectExprRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        return for_RewriteObjectExprRefOnly(that, info_result, staticArgs_result);
    }


    public Expr forJuxt(Juxt that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        FunctionalRef multiJuxt_result = (FunctionalRef) recur(that.getMultiJuxt());
        FunctionalRef infixJuxt_result = (FunctionalRef) recur(that.getInfixJuxt());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        return forJuxtOnly(that, info_result, multiJuxt_result, infixJuxt_result, exprs_result);
    }


    public Expr for_RewriteFnApp(_RewriteFnApp that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr function_result = recur(that.getFunction());
        Expr argument_result = recur(that.getArgument());
        return for_RewriteFnAppOnly(that, info_result, function_result, argument_result);
    }


    public Expr forOpExpr(OpExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        FunctionalRef op_result = (FunctionalRef) recur(that.getOp());
        List<Expr> args_result = recurOnListOfExpr(that.getArgs());
        return forOpExprOnly(that, info_result, op_result, args_result);
    }


    public Expr forAmbiguousMultifixOpExpr(AmbiguousMultifixOpExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        FunctionalRef infix_op_result = (FunctionalRef) recur(that.getInfix_op());
        FunctionalRef multifix_op_result = (FunctionalRef) recur(that.getMultifix_op());
        List<Expr> args_result = recurOnListOfExpr(that.getArgs());
        return forAmbiguousMultifixOpExprOnly(that, info_result, infix_op_result, multifix_op_result, args_result);
    }


    public Expr forChainExpr(ChainExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr first_result = recur(that.getFirst());
        List<Link> links_result = recurOnListOfLink(that.getLinks());
        return forChainExprOnly(that, info_result, first_result, links_result);
    }


    public Expr forTraitCoercionInvocation(TraitCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr arg_result = recur(that.getArg());
        TraitType toType_result = recurOnTraitType(that.getToType());
        FnRef coercionFn_result = (FnRef) recur(that.getCoercionFn());
        return forTraitCoercionInvocationOnly(that, info_result, arg_result, toType_result, coercionFn_result);
    }


    public Expr forTupleCoercionInvocation(TupleCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr arg_result = recur(that.getArg());
        TupleType toType_result = recurOnTupleType(that.getToType());
        List<Option<CoercionInvocation>> subCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getSubCoercions());
        Option<Option<CoercionInvocation>> varargCoercion_result = recurOnOptionOfOptionOfCoercionInvocation(that.getVarargCoercion());
        return forTupleCoercionInvocationOnly(that, info_result, arg_result, toType_result, subCoercions_result, varargCoercion_result);
    }


    public Expr forArrowCoercionInvocation(ArrowCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr arg_result = recur(that.getArg());
        ArrowType toType_result = recurOnArrowType(that.getToType());
        Option<CoercionInvocation> domainCoercion_result = recurOnOptionOfCoercionInvocation(that.getDomainCoercion());
        Option<CoercionInvocation> rangeCoercion_result = recurOnOptionOfCoercionInvocation(that.getRangeCoercion());
        return forArrowCoercionInvocationOnly(that, info_result, arg_result, toType_result, domainCoercion_result, rangeCoercion_result);
    }


    public Expr forUnionCoercionInvocation(UnionCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Type toType_result = recurOnType(that.getToType());
        Expr arg_result = recur(that.getArg());
        List<Type> fromTypes_result = recurOnListOfType(that.getFromTypes());
        List<Option<CoercionInvocation>> fromCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getFromCoercions());
        return forUnionCoercionInvocationOnly(that, info_result, toType_result, arg_result, fromTypes_result, fromCoercions_result);
    }


    public Expr forMethodInvocation(MethodInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Expr obj_result = recur(that.getObj());
        IdOrOp method_result = recurOnIdOrOp(that.getMethod());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Expr arg_result = recur(that.getArg());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        return forMethodInvocationOnly(that, info_result, obj_result, method_result, staticArgs_result, arg_result, overloadingType_result, overloadingSchema_result);
    }


    public Expr forMathPrimary(MathPrimary that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        FunctionalRef multiJuxt_result = (FunctionalRef) recur(that.getMultiJuxt());
        FunctionalRef infixJuxt_result = (FunctionalRef) recur(that.getInfixJuxt());
        Expr front_result = recur(that.getFront());
        List<MathItem> rest_result = recurOnListOfMathItem(that.getRest());
        return forMathPrimaryOnly(that, info_result, multiJuxt_result, infixJuxt_result, front_result, rest_result);
    }


    public Expr forArrayElement(ArrayElement that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Expr element_result = recur(that.getElement());
        return forArrayElementOnly(that, info_result, staticArgs_result, element_result);
    }


    public Expr forArrayElements(ArrayElements that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<ArrayExpr> elements_result = recurOnListOfArrayExpr(that.getElements());
        return forArrayElementsOnly(that, info_result, staticArgs_result, elements_result);
    }


    public Expr for_SyntaxTransformationExpr(_SyntaxTransformationExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationExprOnly(that, info_result);
    }


    public Expr for_SyntaxTransformationDummyExpr(_SyntaxTransformationDummyExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationDummyExprOnly(that, info_result);
    }


    public Expr for_SyntaxTransformationTypeAnnotatedExpr(_SyntaxTransformationTypeAnnotatedExpr that) {
        Expr expr_result = recur(that.getExpr());
        Type annType_result = recurOnType(that.getAnnType());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationTypeAnnotatedExprOnly(that, expr_result, annType_result, info_result);
    }


    public Expr for_SyntaxTransformationAsExpr(_SyntaxTransformationAsExpr that) {
        Expr expr_result = recur(that.getExpr());
        Type annType_result = recurOnType(that.getAnnType());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationAsExprOnly(that, expr_result, annType_result, info_result);
    }


    public Expr for_SyntaxTransformationAsIfExpr(_SyntaxTransformationAsIfExpr that) {
        Expr expr_result = recur(that.getExpr());
        Type annType_result = recurOnType(that.getAnnType());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationAsIfExprOnly(that, expr_result, annType_result, info_result);
    }


    public Expr for_SyntaxTransformationAssignment(_SyntaxTransformationAssignment that) {
        List<Lhs> lhs_result = recurOnListOfLhs(that.getLhs());
        Option<FunctionalRef> assignOp_result = recurOnOptionOfFunctionalRef(that.getAssignOp());
        Expr rhs_result = recur(that.getRhs());
        List<CompoundAssignmentInfo> assignmentInfos_result = recurOnListOfCompoundAssignmentInfo(that.getAssignmentInfos());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationAssignmentOnly(that, lhs_result, assignOp_result, rhs_result, assignmentInfos_result, info_result);
    }


    public Expr for_SyntaxTransformationBlock(_SyntaxTransformationBlock that) {
        Option<Expr> loc_result = recurOnOptionOfExpr(that.getLoc());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationBlockOnly(that, loc_result, exprs_result, info_result);
    }


    public Expr for_SyntaxTransformationDo(_SyntaxTransformationDo that) {
        List<Block> fronts_result = recurOnListOfBlock(that.getFronts());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationDoOnly(that, fronts_result, info_result);
    }


    public Expr for_SyntaxTransformationCaseExpr(_SyntaxTransformationCaseExpr that) {
        Option<Expr> param_result = recurOnOptionOfExpr(that.getParam());
        Option<FunctionalRef> compare_result = recurOnOptionOfFunctionalRef(that.getCompare());
        FunctionalRef equalsOp_result = (FunctionalRef) recur(that.getEqualsOp());
        FunctionalRef inOp_result = (FunctionalRef) recur(that.getInOp());
        List<CaseClause> clauses_result = recurOnListOfCaseClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationCaseExprOnly(that, param_result, compare_result, equalsOp_result, inOp_result, clauses_result, elseClause_result, info_result);
    }


    public Expr for_SyntaxTransformationIf(_SyntaxTransformationIf that) {
        List<IfClause> clauses_result = recurOnListOfIfClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationIfOnly(that, clauses_result, elseClause_result, info_result);
    }


    public Expr for_SyntaxTransformationLabel(_SyntaxTransformationLabel that) {
        Id name_result = recurOnId(that.getName());
        Block body_result = (Block) recur(that.getBody());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationLabelOnly(that, name_result, body_result, info_result);
    }


    public Expr for_SyntaxTransformationAbstractObjectExpr(_SyntaxTransformationAbstractObjectExpr that) {
        TraitTypeHeader header_result = recurOnTraitTypeHeader(that.getHeader());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationAbstractObjectExprOnly(that, header_result, info_result);
    }


    public Expr for_SyntaxTransformationObjectExpr(_SyntaxTransformationObjectExpr that) {
        TraitTypeHeader header_result = recurOnTraitTypeHeader(that.getHeader());
        Option<SelfType> selfType_result = recurOnOptionOfSelfType(that.getSelfType());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationObjectExprOnly(that, header_result, selfType_result, info_result);
    }


    public Expr for_SyntaxTransformation_RewriteObjectExpr(_SyntaxTransformation_RewriteObjectExpr that) {
        TraitTypeHeader header_result = recurOnTraitTypeHeader(that.getHeader());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformation_RewriteObjectExprOnly(that, header_result, staticArgs_result, info_result);
    }


    public Expr for_SyntaxTransformationTry(_SyntaxTransformationTry that) {
        Block body_result = (Block) recur(that.getBody());
        Option<Catch> catchClause_result = recurOnOptionOfCatch(that.getCatchClause());
        List<BaseType> forbidClause_result = recurOnListOfBaseType(that.getForbidClause());
        Option<Block> finallyClause_result = recurOnOptionOfBlock(that.getFinallyClause());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationTryOnly(that, body_result, catchClause_result, forbidClause_result, finallyClause_result, info_result);
    }


    public Expr for_SyntaxTransformationTupleExpr(_SyntaxTransformationTupleExpr that) {
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        Option<Expr> varargs_result = recurOnOptionOfExpr(that.getVarargs());
        List<KeywordExpr> keywords_result = recurOnListOfKeywordExpr(that.getKeywords());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationTupleExprOnly(that, exprs_result, varargs_result, keywords_result, info_result);
    }


    public Expr for_SyntaxTransformationTypecase(_SyntaxTransformationTypecase that) {
        Expr bindExpr_result = recur(that.getBindExpr());
        List<TypecaseClause> clauses_result = recurOnListOfTypecaseClause(that.getClauses());
        Option<Block> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationTypecaseOnly(that, bindExpr_result, clauses_result, elseClause_result, info_result);
    }


    public Expr for_SyntaxTransformationWhile(_SyntaxTransformationWhile that) {
        GeneratorClause testExpr_result = recurOnGeneratorClause(that.getTestExpr());
        Do body_result = (Do) recur(that.getBody());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationWhileOnly(that, testExpr_result, body_result, info_result);
    }


    public Expr for_SyntaxTransformationFor(_SyntaxTransformationFor that) {
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        Block body_result = (Block) recur(that.getBody());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationForOnly(that, gens_result, body_result, info_result);
    }


    public Expr for_SyntaxTransformationBigOpApp(_SyntaxTransformationBigOpApp that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationBigOpAppOnly(that, staticArgs_result, info_result);
    }


    public Expr for_SyntaxTransformationAccumulator(_SyntaxTransformationAccumulator that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Op accOp_result = recurOnOp(that.getAccOp());
        List<GeneratorClause> gens_result = recurOnListOfGeneratorClause(that.getGens());
        Expr body_result = recur(that.getBody());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationAccumulatorOnly(that, staticArgs_result, accOp_result, gens_result, body_result, info_result);
    }


    public Expr for_SyntaxTransformationArrayComprehension(_SyntaxTransformationArrayComprehension that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<ArrayComprehensionClause> clauses_result = recurOnListOfArrayComprehensionClause(that.getClauses());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationArrayComprehensionOnly(that, staticArgs_result, clauses_result, info_result);
    }


    public Expr for_SyntaxTransformationAtomicExpr(_SyntaxTransformationAtomicExpr that) {
        Expr expr_result = recur(that.getExpr());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationAtomicExprOnly(that, expr_result, info_result);
    }


    public Expr for_SyntaxTransformationExit(_SyntaxTransformationExit that) {
        Option<Id> target_result = recurOnOptionOfId(that.getTarget());
        Option<Expr> returnExpr_result = recurOnOptionOfExpr(that.getReturnExpr());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationExitOnly(that, target_result, returnExpr_result, info_result);
    }


    public Expr for_SyntaxTransformationSpawn(_SyntaxTransformationSpawn that) {
        Expr body_result = recur(that.getBody());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationSpawnOnly(that, body_result, info_result);
    }


    public Expr for_SyntaxTransformationThrow(_SyntaxTransformationThrow that) {
        Expr expr_result = recur(that.getExpr());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationThrowOnly(that, expr_result, info_result);
    }


    public Expr for_SyntaxTransformationTryAtomicExpr(_SyntaxTransformationTryAtomicExpr that) {
        Expr expr_result = recur(that.getExpr());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationTryAtomicExprOnly(that, expr_result, info_result);
    }


    public Expr for_SyntaxTransformationFnExpr(_SyntaxTransformationFnExpr that) {
        FnHeader header_result = recurOnFnHeader(that.getHeader());
        Expr body_result = recur(that.getBody());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationFnExprOnly(that, header_result, body_result, info_result);
    }


    public Expr for_SyntaxTransformationLetExpr(_SyntaxTransformationLetExpr that) {
        Block body_result = (Block) recur(that.getBody());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationLetExprOnly(that, body_result, info_result);
    }


    public Expr for_SyntaxTransformationLetFn(_SyntaxTransformationLetFn that) {
        Block body_result = (Block) recur(that.getBody());
        List<FnDecl> fns_result = recurOnListOfFnDecl(that.getFns());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationLetFnOnly(that, body_result, fns_result, info_result);
    }


    public Expr for_SyntaxTransformationLocalVarDecl(_SyntaxTransformationLocalVarDecl that) {
        Block body_result = (Block) recur(that.getBody());
        List<LValue> lhs_result = recurOnListOfLValue(that.getLhs());
        Option<Expr> rhs_result = recurOnOptionOfExpr(that.getRhs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationLocalVarDeclOnly(that, body_result, lhs_result, rhs_result, info_result);
    }


    public Expr for_SyntaxTransformationSimpleExpr(_SyntaxTransformationSimpleExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationSimpleExprOnly(that, info_result);
    }


    public Expr for_SyntaxTransformationSubscriptExpr(_SyntaxTransformationSubscriptExpr that) {
        Expr obj_result = recur(that.getObj());
        List<Expr> subs_result = recurOnListOfExpr(that.getSubs());
        Option<Op> op_result = recurOnOptionOfOp(that.getOp());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationSubscriptExprOnly(that, obj_result, subs_result, op_result, staticArgs_result, info_result);
    }


    public Expr for_SyntaxTransformationPrimary(_SyntaxTransformationPrimary that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationPrimaryOnly(that, info_result);
    }


    public Expr for_SyntaxTransformationLiteralExpr(_SyntaxTransformationLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationLiteralExprOnly(that, info_result);
    }


    public Expr for_SyntaxTransformationNumberLiteralExpr(_SyntaxTransformationNumberLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationNumberLiteralExprOnly(that, info_result);
    }


    public Expr for_SyntaxTransformationFloatLiteralExpr(_SyntaxTransformationFloatLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationFloatLiteralExprOnly(that, info_result);
    }


    public Expr for_SyntaxTransformationIntLiteralExpr(_SyntaxTransformationIntLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationIntLiteralExprOnly(that, info_result);
    }


    public Expr for_SyntaxTransformationCharLiteralExpr(_SyntaxTransformationCharLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationCharLiteralExprOnly(that, info_result);
    }


    public Expr for_SyntaxTransformationStringLiteralExpr(_SyntaxTransformationStringLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationStringLiteralExprOnly(that, info_result);
    }


    public Expr for_SyntaxTransformationVoidLiteralExpr(_SyntaxTransformationVoidLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationVoidLiteralExprOnly(that, info_result);
    }


    public Expr for_SyntaxTransformationBooleanLiteralExpr(_SyntaxTransformationBooleanLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationBooleanLiteralExprOnly(that, info_result);
    }


    public Expr for_SyntaxTransformationVarRef(_SyntaxTransformationVarRef that) {
        Id varId_result = recurOnId(that.getVarId());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationVarRefOnly(that, varId_result, staticArgs_result, info_result);
    }


    public Expr for_SyntaxTransformationFieldRef(_SyntaxTransformationFieldRef that) {
        Expr obj_result = recur(that.getObj());
        Id field_result = recurOnId(that.getField());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationFieldRefOnly(that, obj_result, field_result, info_result);
    }


    public Expr for_SyntaxTransformationFunctionalRef(_SyntaxTransformationFunctionalRef that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        IdOrOp originalName_result = recurOnIdOrOp(that.getOriginalName());
        List<IdOrOp> names_result = recurOnListOfIdOrOp(that.getNames());
        List<Overloading> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<Overloading> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationFunctionalRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result, info_result);
    }


    public Expr for_SyntaxTransformationFnRef(_SyntaxTransformationFnRef that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        IdOrOp originalName_result = recurOnIdOrOp(that.getOriginalName());
        List<IdOrOp> names_result = recurOnListOfIdOrOp(that.getNames());
        List<Overloading> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<Overloading> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationFnRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result, info_result);
    }


    public Expr for_SyntaxTransformationOpRef(_SyntaxTransformationOpRef that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        IdOrOp originalName_result = recurOnIdOrOp(that.getOriginalName());
        List<IdOrOp> names_result = recurOnListOfIdOrOp(that.getNames());
        List<Overloading> interpOverloadings_result = recurOnListOfOverloading(that.getInterpOverloadings());
        List<Overloading> newOverloadings_result = recurOnListOfOverloading(that.getNewOverloadings());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationOpRefOnly(that, staticArgs_result, originalName_result, names_result, interpOverloadings_result, newOverloadings_result, overloadingType_result, overloadingSchema_result, info_result);
    }


    public Expr for_SyntaxTransformation_RewriteFnRef(_SyntaxTransformation_RewriteFnRef that) {
        Expr fnExpr_result = recur(that.getFnExpr());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformation_RewriteFnRefOnly(that, fnExpr_result, staticArgs_result, info_result);
    }


    public Expr for_SyntaxTransformation_RewriteObjectExprRef(_SyntaxTransformation_RewriteObjectExprRef that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformation_RewriteObjectExprRefOnly(that, staticArgs_result, info_result);
    }


    public Expr for_SyntaxTransformationJuxt(_SyntaxTransformationJuxt that) {
        FunctionalRef multiJuxt_result = (FunctionalRef) recur(that.getMultiJuxt());
        FunctionalRef infixJuxt_result = (FunctionalRef) recur(that.getInfixJuxt());
        List<Expr> exprs_result = recurOnListOfExpr(that.getExprs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationJuxtOnly(that, multiJuxt_result, infixJuxt_result, exprs_result, info_result);
    }


    public Expr for_SyntaxTransformation_RewriteFnApp(_SyntaxTransformation_RewriteFnApp that) {
        Expr function_result = recur(that.getFunction());
        Expr argument_result = recur(that.getArgument());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformation_RewriteFnAppOnly(that, function_result, argument_result, info_result);
    }


    public Expr for_SyntaxTransformationOpExpr(_SyntaxTransformationOpExpr that) {
        FunctionalRef op_result = (FunctionalRef) recur(that.getOp());
        List<Expr> args_result = recurOnListOfExpr(that.getArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationOpExprOnly(that, op_result, args_result, info_result);
    }


    public Expr for_SyntaxTransformationAmbiguousMultifixOpExpr(_SyntaxTransformationAmbiguousMultifixOpExpr that) {
        FunctionalRef infix_op_result = (FunctionalRef) recur(that.getInfix_op());
        FunctionalRef multifix_op_result = (FunctionalRef) recur(that.getMultifix_op());
        List<Expr> args_result = recurOnListOfExpr(that.getArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationAmbiguousMultifixOpExprOnly(that, infix_op_result, multifix_op_result, args_result, info_result);
    }


    public Expr for_SyntaxTransformationChainExpr(_SyntaxTransformationChainExpr that) {
        Expr first_result = recur(that.getFirst());
        List<Link> links_result = recurOnListOfLink(that.getLinks());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationChainExprOnly(that, first_result, links_result, info_result);
    }


    public Expr for_SyntaxTransformationCoercionInvocation(_SyntaxTransformationCoercionInvocation that) {
        Type toType_result = recurOnType(that.getToType());
        Expr arg_result = recur(that.getArg());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationCoercionInvocationOnly(that, toType_result, arg_result, info_result);
    }


    public Expr for_SyntaxTransformationTraitCoercionInvocation(_SyntaxTransformationTraitCoercionInvocation that) {
        Expr arg_result = recur(that.getArg());
        TraitType toType_result = recurOnTraitType(that.getToType());
        FnRef coercionFn_result = (FnRef) recur(that.getCoercionFn());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationTraitCoercionInvocationOnly(that, arg_result, toType_result, coercionFn_result, info_result);
    }


    public Expr for_SyntaxTransformationTupleCoercionInvocation(_SyntaxTransformationTupleCoercionInvocation that) {
        Expr arg_result = recur(that.getArg());
        TupleType toType_result = recurOnTupleType(that.getToType());
        List<Option<CoercionInvocation>> subCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getSubCoercions());
        Option<Option<CoercionInvocation>> varargCoercion_result = recurOnOptionOfOptionOfCoercionInvocation(that.getVarargCoercion());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationTupleCoercionInvocationOnly(that, arg_result, toType_result, subCoercions_result, varargCoercion_result, info_result);
    }


    public Expr for_SyntaxTransformationArrowCoercionInvocation(_SyntaxTransformationArrowCoercionInvocation that) {
        Expr arg_result = recur(that.getArg());
        ArrowType toType_result = recurOnArrowType(that.getToType());
        Option<CoercionInvocation> domainCoercion_result = recurOnOptionOfCoercionInvocation(that.getDomainCoercion());
        Option<CoercionInvocation> rangeCoercion_result = recurOnOptionOfCoercionInvocation(that.getRangeCoercion());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationArrowCoercionInvocationOnly(that, arg_result, toType_result, domainCoercion_result, rangeCoercion_result, info_result);
    }


    public Expr for_SyntaxTransformationUnionCoercionInvocation(_SyntaxTransformationUnionCoercionInvocation that) {
        Type toType_result = recurOnType(that.getToType());
        Expr arg_result = recur(that.getArg());
        List<Type> fromTypes_result = recurOnListOfType(that.getFromTypes());
        List<Option<CoercionInvocation>> fromCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getFromCoercions());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationUnionCoercionInvocationOnly(that, toType_result, arg_result, fromTypes_result, fromCoercions_result, info_result);
    }


    public Expr for_SyntaxTransformationMethodInvocation(_SyntaxTransformationMethodInvocation that) {
        Expr obj_result = recur(that.getObj());
        IdOrOp method_result = recurOnIdOrOp(that.getMethod());
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Expr arg_result = recur(that.getArg());
        Option<Type> overloadingType_result = recurOnOptionOfType(that.getOverloadingType());
        Option<Type> overloadingSchema_result = recurOnOptionOfType(that.getOverloadingSchema());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationMethodInvocationOnly(that, obj_result, method_result, staticArgs_result, arg_result, overloadingType_result, overloadingSchema_result, info_result);
    }


    public Expr for_SyntaxTransformationMathPrimary(_SyntaxTransformationMathPrimary that) {
        FunctionalRef multiJuxt_result = (FunctionalRef) recur(that.getMultiJuxt());
        FunctionalRef infixJuxt_result = (FunctionalRef) recur(that.getInfixJuxt());
        Expr front_result = recur(that.getFront());
        List<MathItem> rest_result = recurOnListOfMathItem(that.getRest());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationMathPrimaryOnly(that, multiJuxt_result, infixJuxt_result, front_result, rest_result, info_result);
    }


    public Expr for_SyntaxTransformationArrayExpr(_SyntaxTransformationArrayExpr that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationArrayExprOnly(that, staticArgs_result, info_result);
    }


    public Expr for_SyntaxTransformationArrayElement(_SyntaxTransformationArrayElement that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        Expr element_result = recur(that.getElement());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationArrayElementOnly(that, staticArgs_result, element_result, info_result);
    }


    public Expr for_SyntaxTransformationArrayElements(_SyntaxTransformationArrayElements that) {
        List<StaticArg> staticArgs_result = recurOnListOfStaticArg(that.getStaticArgs());
        List<ArrayExpr> elements_result = recurOnListOfArrayExpr(that.getElements());
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        return for_SyntaxTransformationArrayElementsOnly(that, staticArgs_result, elements_result, info_result);
    }


    public Expr for_EllipsesExpr(_EllipsesExpr that) {
        return for_EllipsesExprOnly(that);
    }


    public Expr for_EllipsesDummyExpr(_EllipsesDummyExpr that) {
        return for_EllipsesDummyExprOnly(that);
    }


    public Expr for_EllipsesTypeAnnotatedExpr(_EllipsesTypeAnnotatedExpr that) {
        return for_EllipsesTypeAnnotatedExprOnly(that);
    }


    public Expr for_EllipsesAsExpr(_EllipsesAsExpr that) {
        return for_EllipsesAsExprOnly(that);
    }


    public Expr for_EllipsesAsIfExpr(_EllipsesAsIfExpr that) {
        return for_EllipsesAsIfExprOnly(that);
    }


    public Expr for_EllipsesAssignment(_EllipsesAssignment that) {
        return for_EllipsesAssignmentOnly(that);
    }


    public Expr for_EllipsesBlock(_EllipsesBlock that) {
        return for_EllipsesBlockOnly(that);
    }


    public Expr for_EllipsesDo(_EllipsesDo that) {
        return for_EllipsesDoOnly(that);
    }


    public Expr for_EllipsesCaseExpr(_EllipsesCaseExpr that) {
        return for_EllipsesCaseExprOnly(that);
    }


    public Expr for_EllipsesIf(_EllipsesIf that) {
        return for_EllipsesIfOnly(that);
    }


    public Expr for_EllipsesLabel(_EllipsesLabel that) {
        return for_EllipsesLabelOnly(that);
    }


    public Expr for_EllipsesAbstractObjectExpr(_EllipsesAbstractObjectExpr that) {
        return for_EllipsesAbstractObjectExprOnly(that);
    }


    public Expr for_EllipsesObjectExpr(_EllipsesObjectExpr that) {
        return for_EllipsesObjectExprOnly(that);
    }


    public Expr for_Ellipses_RewriteObjectExpr(_Ellipses_RewriteObjectExpr that) {
        return for_Ellipses_RewriteObjectExprOnly(that);
    }


    public Expr for_EllipsesTry(_EllipsesTry that) {
        return for_EllipsesTryOnly(that);
    }


    public Expr for_EllipsesTupleExpr(_EllipsesTupleExpr that) {
        return for_EllipsesTupleExprOnly(that);
    }


    public Expr for_EllipsesTypecase(_EllipsesTypecase that) {
        return for_EllipsesTypecaseOnly(that);
    }


    public Expr for_EllipsesWhile(_EllipsesWhile that) {
        return for_EllipsesWhileOnly(that);
    }


    public Expr for_EllipsesFor(_EllipsesFor that) {
        return for_EllipsesForOnly(that);
    }


    public Expr for_EllipsesBigOpApp(_EllipsesBigOpApp that) {
        return for_EllipsesBigOpAppOnly(that);
    }


    public Expr for_EllipsesAccumulator(_EllipsesAccumulator that) {
        return for_EllipsesAccumulatorOnly(that);
    }


    public Expr for_EllipsesArrayComprehension(_EllipsesArrayComprehension that) {
        return for_EllipsesArrayComprehensionOnly(that);
    }


    public Expr for_EllipsesAtomicExpr(_EllipsesAtomicExpr that) {
        return for_EllipsesAtomicExprOnly(that);
    }


    public Expr for_EllipsesExit(_EllipsesExit that) {
        return for_EllipsesExitOnly(that);
    }


    public Expr for_EllipsesSpawn(_EllipsesSpawn that) {
        return for_EllipsesSpawnOnly(that);
    }


    public Expr for_EllipsesThrow(_EllipsesThrow that) {
        return for_EllipsesThrowOnly(that);
    }


    public Expr for_EllipsesTryAtomicExpr(_EllipsesTryAtomicExpr that) {
        return for_EllipsesTryAtomicExprOnly(that);
    }


    public Expr for_EllipsesFnExpr(_EllipsesFnExpr that) {
        return for_EllipsesFnExprOnly(that);
    }


    public Expr for_EllipsesLetExpr(_EllipsesLetExpr that) {
        return for_EllipsesLetExprOnly(that);
    }


    public Expr for_EllipsesLetFn(_EllipsesLetFn that) {
        return for_EllipsesLetFnOnly(that);
    }


    public Expr for_EllipsesLocalVarDecl(_EllipsesLocalVarDecl that) {
        return for_EllipsesLocalVarDeclOnly(that);
    }


    public Expr for_EllipsesSimpleExpr(_EllipsesSimpleExpr that) {
        return for_EllipsesSimpleExprOnly(that);
    }


    public Expr for_EllipsesSubscriptExpr(_EllipsesSubscriptExpr that) {
        return for_EllipsesSubscriptExprOnly(that);
    }


    public Expr for_EllipsesPrimary(_EllipsesPrimary that) {
        return for_EllipsesPrimaryOnly(that);
    }


    public Expr for_EllipsesLiteralExpr(_EllipsesLiteralExpr that) {
        return for_EllipsesLiteralExprOnly(that);
    }


    public Expr for_EllipsesNumberLiteralExpr(_EllipsesNumberLiteralExpr that) {
        return for_EllipsesNumberLiteralExprOnly(that);
    }


    public Expr for_EllipsesFloatLiteralExpr(_EllipsesFloatLiteralExpr that) {
        return for_EllipsesFloatLiteralExprOnly(that);
    }


    public Expr for_EllipsesIntLiteralExpr(_EllipsesIntLiteralExpr that) {
        return for_EllipsesIntLiteralExprOnly(that);
    }


    public Expr for_EllipsesCharLiteralExpr(_EllipsesCharLiteralExpr that) {
        return for_EllipsesCharLiteralExprOnly(that);
    }


    public Expr for_EllipsesStringLiteralExpr(_EllipsesStringLiteralExpr that) {
        return for_EllipsesStringLiteralExprOnly(that);
    }


    public Expr for_EllipsesVoidLiteralExpr(_EllipsesVoidLiteralExpr that) {
        return for_EllipsesVoidLiteralExprOnly(that);
    }


    public Expr for_EllipsesBooleanLiteralExpr(_EllipsesBooleanLiteralExpr that) {
        return for_EllipsesBooleanLiteralExprOnly(that);
    }


    public Expr for_EllipsesVarRef(_EllipsesVarRef that) {
        return for_EllipsesVarRefOnly(that);
    }


    public Expr for_EllipsesFieldRef(_EllipsesFieldRef that) {
        return for_EllipsesFieldRefOnly(that);
    }


    public Expr for_EllipsesFunctionalRef(_EllipsesFunctionalRef that) {
        return for_EllipsesFunctionalRefOnly(that);
    }


    public Expr for_EllipsesFnRef(_EllipsesFnRef that) {
        return for_EllipsesFnRefOnly(that);
    }


    public Expr for_EllipsesOpRef(_EllipsesOpRef that) {
        return for_EllipsesOpRefOnly(that);
    }


    public Expr for_Ellipses_RewriteFnRef(_Ellipses_RewriteFnRef that) {
        return for_Ellipses_RewriteFnRefOnly(that);
    }


    public Expr for_Ellipses_RewriteObjectExprRef(_Ellipses_RewriteObjectExprRef that) {
        return for_Ellipses_RewriteObjectExprRefOnly(that);
    }


    public Expr for_EllipsesJuxt(_EllipsesJuxt that) {
        return for_EllipsesJuxtOnly(that);
    }


    public Expr for_Ellipses_RewriteFnApp(_Ellipses_RewriteFnApp that) {
        return for_Ellipses_RewriteFnAppOnly(that);
    }


    public Expr for_EllipsesOpExpr(_EllipsesOpExpr that) {
        return for_EllipsesOpExprOnly(that);
    }


    public Expr for_EllipsesAmbiguousMultifixOpExpr(_EllipsesAmbiguousMultifixOpExpr that) {
        return for_EllipsesAmbiguousMultifixOpExprOnly(that);
    }


    public Expr for_EllipsesChainExpr(_EllipsesChainExpr that) {
        return for_EllipsesChainExprOnly(that);
    }


    public Expr for_EllipsesCoercionInvocation(_EllipsesCoercionInvocation that) {
        return for_EllipsesCoercionInvocationOnly(that);
    }


    public Expr for_EllipsesTraitCoercionInvocation(_EllipsesTraitCoercionInvocation that) {
        return for_EllipsesTraitCoercionInvocationOnly(that);
    }


    public Expr for_EllipsesTupleCoercionInvocation(_EllipsesTupleCoercionInvocation that) {
        return for_EllipsesTupleCoercionInvocationOnly(that);
    }


    public Expr for_EllipsesArrowCoercionInvocation(_EllipsesArrowCoercionInvocation that) {
        return for_EllipsesArrowCoercionInvocationOnly(that);
    }


    public Expr for_EllipsesUnionCoercionInvocation(_EllipsesUnionCoercionInvocation that) {
        return for_EllipsesUnionCoercionInvocationOnly(that);
    }


    public Expr for_EllipsesMethodInvocation(_EllipsesMethodInvocation that) {
        return for_EllipsesMethodInvocationOnly(that);
    }


    public Expr for_EllipsesMathPrimary(_EllipsesMathPrimary that) {
        return for_EllipsesMathPrimaryOnly(that);
    }


    public Expr for_EllipsesArrayExpr(_EllipsesArrayExpr that) {
        return for_EllipsesArrayExprOnly(that);
    }


    public Expr for_EllipsesArrayElement(_EllipsesArrayElement that) {
        return for_EllipsesArrayElementOnly(that);
    }


    public Expr for_EllipsesArrayElements(_EllipsesArrayElements that) {
        return for_EllipsesArrayElementsOnly(that);
    }


    public Expr forTemplateGapExpr(TemplateGapExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapDummyExpr(TemplateGapDummyExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDummyExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapTypeAnnotatedExpr(TemplateGapTypeAnnotatedExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypeAnnotatedExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapAsExpr(TemplateGapAsExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAsExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapAsIfExpr(TemplateGapAsIfExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAsIfExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapAssignment(TemplateGapAssignment that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAssignmentOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapBlock(TemplateGapBlock that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBlockOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapDo(TemplateGapDo that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDoOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapCaseExpr(TemplateGapCaseExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCaseExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapIf(TemplateGapIf that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIfOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapLabel(TemplateGapLabel that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLabelOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapAbstractObjectExpr(TemplateGapAbstractObjectExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAbstractObjectExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapObjectExpr(TemplateGapObjectExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapObjectExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGap_RewriteObjectExpr(TemplateGap_RewriteObjectExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteObjectExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapTry(TemplateGapTry that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTryOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapTupleExpr(TemplateGapTupleExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTupleExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapTypecase(TemplateGapTypecase that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypecaseOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapWhile(TemplateGapWhile that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapWhileOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapFor(TemplateGapFor that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapForOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapBigOpApp(TemplateGapBigOpApp that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBigOpAppOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapAccumulator(TemplateGapAccumulator that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAccumulatorOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapArrayComprehension(TemplateGapArrayComprehension that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayComprehensionOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapAtomicExpr(TemplateGapAtomicExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAtomicExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapExit(TemplateGapExit that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapExitOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapSpawn(TemplateGapSpawn that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSpawnOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapThrow(TemplateGapThrow that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapThrowOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapTryAtomicExpr(TemplateGapTryAtomicExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTryAtomicExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapFnExpr(TemplateGapFnExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFnExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapLetExpr(TemplateGapLetExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLetExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapLetFn(TemplateGapLetFn that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLetFnOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapLocalVarDecl(TemplateGapLocalVarDecl that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLocalVarDeclOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapSimpleExpr(TemplateGapSimpleExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSimpleExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapSubscriptExpr(TemplateGapSubscriptExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapSubscriptExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapPrimary(TemplateGapPrimary that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapPrimaryOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapLiteralExpr(TemplateGapLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapNumberLiteralExpr(TemplateGapNumberLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapNumberLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapFloatLiteralExpr(TemplateGapFloatLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFloatLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapIntLiteralExpr(TemplateGapIntLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapCharLiteralExpr(TemplateGapCharLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCharLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapStringLiteralExpr(TemplateGapStringLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapStringLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapVoidLiteralExpr(TemplateGapVoidLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapVoidLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapBooleanLiteralExpr(TemplateGapBooleanLiteralExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBooleanLiteralExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapVarRef(TemplateGapVarRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapVarRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapFieldRef(TemplateGapFieldRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFieldRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapFunctionalRef(TemplateGapFunctionalRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFunctionalRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapFnRef(TemplateGapFnRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapFnRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapOpRef(TemplateGapOpRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOpRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGap_RewriteFnRef(TemplateGap_RewriteFnRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteFnRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGap_RewriteObjectExprRef(TemplateGap_RewriteObjectExprRef that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteObjectExprRefOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapJuxt(TemplateGapJuxt that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapJuxtOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGap_RewriteFnApp(TemplateGap_RewriteFnApp that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGap_RewriteFnAppOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapOpExpr(TemplateGapOpExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOpExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapAmbiguousMultifixOpExpr(TemplateGapAmbiguousMultifixOpExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapAmbiguousMultifixOpExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapChainExpr(TemplateGapChainExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapChainExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapCoercionInvocation(TemplateGapCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapCoercionInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapTraitCoercionInvocation(TemplateGapTraitCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTraitCoercionInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapTupleCoercionInvocation(TemplateGapTupleCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTupleCoercionInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapArrowCoercionInvocation(TemplateGapArrowCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrowCoercionInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapUnionCoercionInvocation(TemplateGapUnionCoercionInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnionCoercionInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapMethodInvocation(TemplateGapMethodInvocation that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapMethodInvocationOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapMathPrimary(TemplateGapMathPrimary that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapMathPrimaryOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapArrayExpr(TemplateGapArrayExpr that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayExprOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapArrayElement(TemplateGapArrayElement that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayElementOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr forTemplateGapArrayElements(TemplateGapArrayElements that) {
        ExprInfo info_result = recurOnExprInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapArrayElementsOnly(that, info_result, gapId_result, templateParams_result);
    }


    public Expr recur(Expr that) {
        return that.accept(this);
    }

    public ExprInfo recurOnExprInfo(ExprInfo that) {
        return that;
    }

    public Type recurOnType(Type that) {
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

    public Option<Expr> recurOnOptionOfExpr(Option<Expr> that) {
        if (that.isNone()) { return that; }
        else {
            Expr original = that.unwrap();
            Expr updated = recur(original);
            return (original == updated) ? that : Option.<Expr>some(updated);
        }
    }

    public List<Expr> recurOnListOfExpr(List<Expr> that) {
        java.util.ArrayList<Expr> accum = new java.util.ArrayList<Expr>();
        boolean unchanged = true;
        for (Expr elt : that) {
            Expr update_elt = recur(elt);
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

    public CaseClause recurOnCaseClause(CaseClause that) {
        return that;
    }

    public List<CaseClause> recurOnListOfCaseClause(List<CaseClause> that) {
        java.util.ArrayList<CaseClause> accum = new java.util.ArrayList<CaseClause>();
        boolean unchanged = true;
        for (CaseClause elt : that) {
            CaseClause update_elt = recurOnCaseClause(elt);
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

    public IfClause recurOnIfClause(IfClause that) {
        return that;
    }

    public List<IfClause> recurOnListOfIfClause(List<IfClause> that) {
        java.util.ArrayList<IfClause> accum = new java.util.ArrayList<IfClause>();
        boolean unchanged = true;
        for (IfClause elt : that) {
            IfClause update_elt = recurOnIfClause(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Id recurOnId(Id that) {
        return that;
    }

    public TraitTypeHeader recurOnTraitTypeHeader(TraitTypeHeader that) {
        return that;
    }

    public SelfType recurOnSelfType(SelfType that) {
        return that;
    }

    public Option<SelfType> recurOnOptionOfSelfType(Option<SelfType> that) {
        if (that.isNone()) { return that; }
        else {
            SelfType original = that.unwrap();
            SelfType updated = recurOnSelfType(original);
            return (original == updated) ? that : Option.<SelfType>some(updated);
        }
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

    public Catch recurOnCatch(Catch that) {
        return that;
    }

    public Option<Catch> recurOnOptionOfCatch(Option<Catch> that) {
        if (that.isNone()) { return that; }
        else {
            Catch original = that.unwrap();
            Catch updated = recurOnCatch(original);
            return (original == updated) ? that : Option.<Catch>some(updated);
        }
    }

    public BaseType recurOnBaseType(BaseType that) {
        return that;
    }

    public List<BaseType> recurOnListOfBaseType(List<BaseType> that) {
        java.util.ArrayList<BaseType> accum = new java.util.ArrayList<BaseType>();
        boolean unchanged = true;
        for (BaseType elt : that) {
            BaseType update_elt = recurOnBaseType(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public KeywordExpr recurOnKeywordExpr(KeywordExpr that) {
        return that;
    }

    public List<KeywordExpr> recurOnListOfKeywordExpr(List<KeywordExpr> that) {
        java.util.ArrayList<KeywordExpr> accum = new java.util.ArrayList<KeywordExpr>();
        boolean unchanged = true;
        for (KeywordExpr elt : that) {
            KeywordExpr update_elt = recurOnKeywordExpr(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public TypecaseClause recurOnTypecaseClause(TypecaseClause that) {
        return that;
    }

    public List<TypecaseClause> recurOnListOfTypecaseClause(List<TypecaseClause> that) {
        java.util.ArrayList<TypecaseClause> accum = new java.util.ArrayList<TypecaseClause>();
        boolean unchanged = true;
        for (TypecaseClause elt : that) {
            TypecaseClause update_elt = recurOnTypecaseClause(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public GeneratorClause recurOnGeneratorClause(GeneratorClause that) {
        return that;
    }

    public List<GeneratorClause> recurOnListOfGeneratorClause(List<GeneratorClause> that) {
        java.util.ArrayList<GeneratorClause> accum = new java.util.ArrayList<GeneratorClause>();
        boolean unchanged = true;
        for (GeneratorClause elt : that) {
            GeneratorClause update_elt = recurOnGeneratorClause(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Op recurOnOp(Op that) {
        return that;
    }

    public ArrayComprehensionClause recurOnArrayComprehensionClause(ArrayComprehensionClause that) {
        return that;
    }

    public List<ArrayComprehensionClause> recurOnListOfArrayComprehensionClause(List<ArrayComprehensionClause> that) {
        java.util.ArrayList<ArrayComprehensionClause> accum = new java.util.ArrayList<ArrayComprehensionClause>();
        boolean unchanged = true;
        for (ArrayComprehensionClause elt : that) {
            ArrayComprehensionClause update_elt = recurOnArrayComprehensionClause(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<Id> recurOnOptionOfId(Option<Id> that) {
        if (that.isNone()) { return that; }
        else {
            Id original = that.unwrap();
            Id updated = recurOnId(original);
            return (original == updated) ? that : Option.<Id>some(updated);
        }
    }

    public FnHeader recurOnFnHeader(FnHeader that) {
        return that;
    }

    public FnDecl recurOnFnDecl(FnDecl that) {
        return that;
    }

    public List<FnDecl> recurOnListOfFnDecl(List<FnDecl> that) {
        java.util.ArrayList<FnDecl> accum = new java.util.ArrayList<FnDecl>();
        boolean unchanged = true;
        for (FnDecl elt : that) {
            FnDecl update_elt = recurOnFnDecl(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public LValue recurOnLValue(LValue that) {
        return that;
    }

    public List<LValue> recurOnListOfLValue(List<LValue> that) {
        java.util.ArrayList<LValue> accum = new java.util.ArrayList<LValue>();
        boolean unchanged = true;
        for (LValue elt : that) {
            LValue update_elt = recurOnLValue(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<Op> recurOnOptionOfOp(Option<Op> that) {
        if (that.isNone()) { return that; }
        else {
            Op original = that.unwrap();
            Op updated = recurOnOp(original);
            return (original == updated) ? that : Option.<Op>some(updated);
        }
    }

    public IdOrOp recurOnIdOrOp(IdOrOp that) {
        return that;
    }

    public List<IdOrOp> recurOnListOfIdOrOp(List<IdOrOp> that) {
        java.util.ArrayList<IdOrOp> accum = new java.util.ArrayList<IdOrOp>();
        boolean unchanged = true;
        for (IdOrOp elt : that) {
            IdOrOp update_elt = recurOnIdOrOp(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Overloading recurOnOverloading(Overloading that) {
        return that;
    }

    public List<Overloading> recurOnListOfOverloading(List<Overloading> that) {
        java.util.ArrayList<Overloading> accum = new java.util.ArrayList<Overloading>();
        boolean unchanged = true;
        for (Overloading elt : that) {
            Overloading update_elt = recurOnOverloading(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public Option<Type> recurOnOptionOfType(Option<Type> that) {
        if (that.isNone()) { return that; }
        else {
            Type original = that.unwrap();
            Type updated = recurOnType(original);
            return (original == updated) ? that : Option.<Type>some(updated);
        }
    }

    public Link recurOnLink(Link that) {
        return that;
    }

    public List<Link> recurOnListOfLink(List<Link> that) {
        java.util.ArrayList<Link> accum = new java.util.ArrayList<Link>();
        boolean unchanged = true;
        for (Link elt : that) {
            Link update_elt = recurOnLink(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public TraitType recurOnTraitType(TraitType that) {
        return that;
    }

    public TupleType recurOnTupleType(TupleType that) {
        return that;
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

    public ArrowType recurOnArrowType(ArrowType that) {
        return that;
    }

    public List<Type> recurOnListOfType(List<Type> that) {
        java.util.ArrayList<Type> accum = new java.util.ArrayList<Type>();
        boolean unchanged = true;
        for (Type elt : that) {
            Type update_elt = recurOnType(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }

    public MathItem recurOnMathItem(MathItem that) {
        return that;
    }

    public List<MathItem> recurOnListOfMathItem(List<MathItem> that) {
        java.util.ArrayList<MathItem> accum = new java.util.ArrayList<MathItem>();
        boolean unchanged = true;
        for (MathItem elt : that) {
            MathItem update_elt = recurOnMathItem(elt);
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
