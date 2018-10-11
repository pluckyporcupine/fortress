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

/** A visitor over Expr that combined recursive results.
 ** This visitor implements the visitor interface with methods that
 ** first visit children, and then call forCASEOnly(), passing in
 ** the values of the visits of the children. (CASE is replaced by the case name.)
 ** By default, each forCASEOnly combines its results together using the method
 **    combine(node, values...)
 ** All recursion should go via recur(...); this allows overrides to insert
 ** hooks into the recursion path (eg to record incremental results)
 **/
@SuppressWarnings({"unused", "unchecked"})
public abstract class ExprCollectingVisitor<RetType> extends ExprDepthFirstVisitor<RetType> {
    /* Methods to handle a node after recursion. */
    public RetType forExprOnly(Expr that) {
        return combine(that);
    }

    public RetType forDummyExprOnly(DummyExpr that) {
        return combine(that);
    }

    public RetType forTypeAnnotatedExprOnly(TypeAnnotatedExpr that, RetType expr_result) {
        return combine(that, expr_result);
    }

    public RetType forAsExprOnly(AsExpr that, RetType expr_result) {
        return combine(that, expr_result);
    }

    public RetType forAsIfExprOnly(AsIfExpr that, RetType expr_result) {
        return combine(that, expr_result);
    }

    public RetType forAssignmentOnly(Assignment that, Option<RetType> assignOp_result, RetType rhs_result) {
        return combine(that, combine(assignOp_result), rhs_result);
    }

    public RetType forBlockOnly(Block that, Option<RetType> loc_result, List<RetType> exprs_result) {
        return combine(that, combine(loc_result), combine(exprs_result));
    }

    public RetType forDoOnly(Do that, List<RetType> fronts_result) {
        return combine(that, combine(fronts_result));
    }

    public RetType forCaseExprOnly(CaseExpr that, Option<RetType> param_result, Option<RetType> compare_result, RetType equalsOp_result, RetType inOp_result, Option<RetType> elseClause_result) {
        return combine(that, combine(param_result), combine(compare_result), equalsOp_result, inOp_result, combine(elseClause_result));
    }

    public RetType forIfOnly(If that, Option<RetType> elseClause_result) {
        return combine(that, combine(elseClause_result));
    }

    public RetType forLabelOnly(Label that, RetType body_result) {
        return combine(that, body_result);
    }

    public RetType forAbstractObjectExprOnly(AbstractObjectExpr that) {
        return combine(that);
    }

    public RetType forObjectExprOnly(ObjectExpr that) {
        return combine(that);
    }

    public RetType for_RewriteObjectExprOnly(_RewriteObjectExpr that) {
        return combine(that);
    }

    public RetType forTryOnly(Try that, RetType body_result, Option<RetType> finallyClause_result) {
        return combine(that, body_result, combine(finallyClause_result));
    }

    public RetType forTupleExprOnly(TupleExpr that, List<RetType> exprs_result, Option<RetType> varargs_result) {
        return combine(that, combine(exprs_result), combine(varargs_result));
    }

    public RetType forTypecaseOnly(Typecase that, RetType bindExpr_result, Option<RetType> elseClause_result) {
        return combine(that, bindExpr_result, combine(elseClause_result));
    }

    public RetType forWhileOnly(While that, RetType body_result) {
        return combine(that, body_result);
    }

    public RetType forForOnly(For that, RetType body_result) {
        return combine(that, body_result);
    }

    public RetType forBigOpAppOnly(BigOpApp that) {
        return combine(that);
    }

    public RetType forAccumulatorOnly(Accumulator that, RetType body_result) {
        return combine(that, body_result);
    }

    public RetType forArrayComprehensionOnly(ArrayComprehension that) {
        return combine(that);
    }

    public RetType forAtomicExprOnly(AtomicExpr that, RetType expr_result) {
        return combine(that, expr_result);
    }

    public RetType forExitOnly(Exit that, Option<RetType> returnExpr_result) {
        return combine(that, combine(returnExpr_result));
    }

    public RetType forSpawnOnly(Spawn that, RetType body_result) {
        return combine(that, body_result);
    }

    public RetType forThrowOnly(Throw that, RetType expr_result) {
        return combine(that, expr_result);
    }

    public RetType forTryAtomicExprOnly(TryAtomicExpr that, RetType expr_result) {
        return combine(that, expr_result);
    }

    public RetType forFnExprOnly(FnExpr that, RetType body_result) {
        return combine(that, body_result);
    }

    public RetType forLetExprOnly(LetExpr that, RetType body_result) {
        return combine(that, body_result);
    }

    public RetType forLetFnOnly(LetFn that, RetType body_result) {
        return combine(that, body_result);
    }

    public RetType forLocalVarDeclOnly(LocalVarDecl that, RetType body_result, Option<RetType> rhs_result) {
        return combine(that, body_result, combine(rhs_result));
    }

    public RetType forSimpleExprOnly(SimpleExpr that) {
        return combine(that);
    }

    public RetType forSubscriptExprOnly(SubscriptExpr that, RetType obj_result, List<RetType> subs_result) {
        return combine(that, obj_result, combine(subs_result));
    }

    public RetType forPrimaryOnly(Primary that) {
        return combine(that);
    }

    public RetType forLiteralExprOnly(LiteralExpr that) {
        return combine(that);
    }

    public RetType forNumberLiteralExprOnly(NumberLiteralExpr that) {
        return combine(that);
    }

    public RetType forFloatLiteralExprOnly(FloatLiteralExpr that) {
        return combine(that);
    }

    public RetType forIntLiteralExprOnly(IntLiteralExpr that) {
        return combine(that);
    }

    public RetType forCharLiteralExprOnly(CharLiteralExpr that) {
        return combine(that);
    }

    public RetType forStringLiteralExprOnly(StringLiteralExpr that) {
        return combine(that);
    }

    public RetType forVoidLiteralExprOnly(VoidLiteralExpr that) {
        return combine(that);
    }

    public RetType forBooleanLiteralExprOnly(BooleanLiteralExpr that) {
        return combine(that);
    }

    public RetType forVarRefOnly(VarRef that) {
        return combine(that);
    }

    public RetType forFieldRefOnly(FieldRef that, RetType obj_result) {
        return combine(that, obj_result);
    }

    public RetType forFunctionalRefOnly(FunctionalRef that) {
        return combine(that);
    }

    public RetType forFnRefOnly(FnRef that) {
        return combine(that);
    }

    public RetType forOpRefOnly(OpRef that) {
        return combine(that);
    }

    public RetType for_RewriteFnRefOnly(_RewriteFnRef that, RetType fnExpr_result) {
        return combine(that, fnExpr_result);
    }

    public RetType for_RewriteObjectExprRefOnly(_RewriteObjectExprRef that) {
        return combine(that);
    }

    public RetType forJuxtOnly(Juxt that, RetType multiJuxt_result, RetType infixJuxt_result, List<RetType> exprs_result) {
        return combine(that, multiJuxt_result, infixJuxt_result, combine(exprs_result));
    }

    public RetType for_RewriteFnAppOnly(_RewriteFnApp that, RetType function_result, RetType argument_result) {
        return combine(that, function_result, argument_result);
    }

    public RetType forOpExprOnly(OpExpr that, RetType op_result, List<RetType> args_result) {
        return combine(that, op_result, combine(args_result));
    }

    public RetType forAmbiguousMultifixOpExprOnly(AmbiguousMultifixOpExpr that, RetType infix_op_result, RetType multifix_op_result, List<RetType> args_result) {
        return combine(that, infix_op_result, multifix_op_result, combine(args_result));
    }

    public RetType forChainExprOnly(ChainExpr that, RetType first_result) {
        return combine(that, first_result);
    }

    public RetType forCoercionInvocationOnly(CoercionInvocation that, RetType arg_result) {
        return combine(that, arg_result);
    }

    public RetType forTraitCoercionInvocationOnly(TraitCoercionInvocation that, RetType arg_result, RetType coercionFn_result) {
        return combine(that, arg_result, coercionFn_result);
    }

    public RetType forTupleCoercionInvocationOnly(TupleCoercionInvocation that, RetType arg_result, List<Option<RetType>> subCoercions_result, Option<Option<RetType>> varargCoercion_result) {
        return combine(that, arg_result, combineListOption(subCoercions_result), combineOptionOption(varargCoercion_result));
    }

    public RetType forArrowCoercionInvocationOnly(ArrowCoercionInvocation that, RetType arg_result, Option<RetType> domainCoercion_result, Option<RetType> rangeCoercion_result) {
        return combine(that, arg_result, combine(domainCoercion_result), combine(rangeCoercion_result));
    }

    public RetType forUnionCoercionInvocationOnly(UnionCoercionInvocation that, RetType arg_result, List<Option<RetType>> fromCoercions_result) {
        return combine(that, arg_result, combineListOption(fromCoercions_result));
    }

    public RetType forMethodInvocationOnly(MethodInvocation that, RetType obj_result, RetType arg_result) {
        return combine(that, obj_result, arg_result);
    }

    public RetType forMathPrimaryOnly(MathPrimary that, RetType multiJuxt_result, RetType infixJuxt_result, RetType front_result) {
        return combine(that, multiJuxt_result, infixJuxt_result, front_result);
    }

    public RetType forArrayExprOnly(ArrayExpr that) {
        return combine(that);
    }

    public RetType forArrayElementOnly(ArrayElement that, RetType element_result) {
        return combine(that, element_result);
    }

    public RetType forArrayElementsOnly(ArrayElements that, List<RetType> elements_result) {
        return combine(that, combine(elements_result));
    }

    public RetType for_SyntaxTransformationExprOnly(_SyntaxTransformationExpr that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationDummyExprOnly(_SyntaxTransformationDummyExpr that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationTypeAnnotatedExprOnly(_SyntaxTransformationTypeAnnotatedExpr that, RetType expr_result) {
        return combine(that, expr_result);
    }

    public RetType for_SyntaxTransformationAsExprOnly(_SyntaxTransformationAsExpr that, RetType expr_result) {
        return combine(that, expr_result);
    }

    public RetType for_SyntaxTransformationAsIfExprOnly(_SyntaxTransformationAsIfExpr that, RetType expr_result) {
        return combine(that, expr_result);
    }

    public RetType for_SyntaxTransformationAssignmentOnly(_SyntaxTransformationAssignment that, Option<RetType> assignOp_result, RetType rhs_result) {
        return combine(that, combine(assignOp_result), rhs_result);
    }

    public RetType for_SyntaxTransformationBlockOnly(_SyntaxTransformationBlock that, Option<RetType> loc_result, List<RetType> exprs_result) {
        return combine(that, combine(loc_result), combine(exprs_result));
    }

    public RetType for_SyntaxTransformationDoOnly(_SyntaxTransformationDo that, List<RetType> fronts_result) {
        return combine(that, combine(fronts_result));
    }

    public RetType for_SyntaxTransformationCaseExprOnly(_SyntaxTransformationCaseExpr that, Option<RetType> param_result, Option<RetType> compare_result, RetType equalsOp_result, RetType inOp_result, Option<RetType> elseClause_result) {
        return combine(that, combine(param_result), combine(compare_result), equalsOp_result, inOp_result, combine(elseClause_result));
    }

    public RetType for_SyntaxTransformationIfOnly(_SyntaxTransformationIf that, Option<RetType> elseClause_result) {
        return combine(that, combine(elseClause_result));
    }

    public RetType for_SyntaxTransformationLabelOnly(_SyntaxTransformationLabel that, RetType body_result) {
        return combine(that, body_result);
    }

    public RetType for_SyntaxTransformationAbstractObjectExprOnly(_SyntaxTransformationAbstractObjectExpr that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationObjectExprOnly(_SyntaxTransformationObjectExpr that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprOnly(_SyntaxTransformation_RewriteObjectExpr that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationTryOnly(_SyntaxTransformationTry that, RetType body_result, Option<RetType> finallyClause_result) {
        return combine(that, body_result, combine(finallyClause_result));
    }

    public RetType for_SyntaxTransformationTupleExprOnly(_SyntaxTransformationTupleExpr that, List<RetType> exprs_result, Option<RetType> varargs_result) {
        return combine(that, combine(exprs_result), combine(varargs_result));
    }

    public RetType for_SyntaxTransformationTypecaseOnly(_SyntaxTransformationTypecase that, RetType bindExpr_result, Option<RetType> elseClause_result) {
        return combine(that, bindExpr_result, combine(elseClause_result));
    }

    public RetType for_SyntaxTransformationWhileOnly(_SyntaxTransformationWhile that, RetType body_result) {
        return combine(that, body_result);
    }

    public RetType for_SyntaxTransformationForOnly(_SyntaxTransformationFor that, RetType body_result) {
        return combine(that, body_result);
    }

    public RetType for_SyntaxTransformationBigOpAppOnly(_SyntaxTransformationBigOpApp that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationAccumulatorOnly(_SyntaxTransformationAccumulator that, RetType body_result) {
        return combine(that, body_result);
    }

    public RetType for_SyntaxTransformationArrayComprehensionOnly(_SyntaxTransformationArrayComprehension that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationAtomicExprOnly(_SyntaxTransformationAtomicExpr that, RetType expr_result) {
        return combine(that, expr_result);
    }

    public RetType for_SyntaxTransformationExitOnly(_SyntaxTransformationExit that, Option<RetType> returnExpr_result) {
        return combine(that, combine(returnExpr_result));
    }

    public RetType for_SyntaxTransformationSpawnOnly(_SyntaxTransformationSpawn that, RetType body_result) {
        return combine(that, body_result);
    }

    public RetType for_SyntaxTransformationThrowOnly(_SyntaxTransformationThrow that, RetType expr_result) {
        return combine(that, expr_result);
    }

    public RetType for_SyntaxTransformationTryAtomicExprOnly(_SyntaxTransformationTryAtomicExpr that, RetType expr_result) {
        return combine(that, expr_result);
    }

    public RetType for_SyntaxTransformationFnExprOnly(_SyntaxTransformationFnExpr that, RetType body_result) {
        return combine(that, body_result);
    }

    public RetType for_SyntaxTransformationLetExprOnly(_SyntaxTransformationLetExpr that, RetType body_result) {
        return combine(that, body_result);
    }

    public RetType for_SyntaxTransformationLetFnOnly(_SyntaxTransformationLetFn that, RetType body_result) {
        return combine(that, body_result);
    }

    public RetType for_SyntaxTransformationLocalVarDeclOnly(_SyntaxTransformationLocalVarDecl that, RetType body_result, Option<RetType> rhs_result) {
        return combine(that, body_result, combine(rhs_result));
    }

    public RetType for_SyntaxTransformationSimpleExprOnly(_SyntaxTransformationSimpleExpr that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationSubscriptExprOnly(_SyntaxTransformationSubscriptExpr that, RetType obj_result, List<RetType> subs_result) {
        return combine(that, obj_result, combine(subs_result));
    }

    public RetType for_SyntaxTransformationPrimaryOnly(_SyntaxTransformationPrimary that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationLiteralExprOnly(_SyntaxTransformationLiteralExpr that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationNumberLiteralExprOnly(_SyntaxTransformationNumberLiteralExpr that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationFloatLiteralExprOnly(_SyntaxTransformationFloatLiteralExpr that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationIntLiteralExprOnly(_SyntaxTransformationIntLiteralExpr that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationCharLiteralExprOnly(_SyntaxTransformationCharLiteralExpr that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationStringLiteralExprOnly(_SyntaxTransformationStringLiteralExpr that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationVoidLiteralExprOnly(_SyntaxTransformationVoidLiteralExpr that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationBooleanLiteralExprOnly(_SyntaxTransformationBooleanLiteralExpr that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationVarRefOnly(_SyntaxTransformationVarRef that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationFieldRefOnly(_SyntaxTransformationFieldRef that, RetType obj_result) {
        return combine(that, obj_result);
    }

    public RetType for_SyntaxTransformationFunctionalRefOnly(_SyntaxTransformationFunctionalRef that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationFnRefOnly(_SyntaxTransformationFnRef that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationOpRefOnly(_SyntaxTransformationOpRef that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformation_RewriteFnRefOnly(_SyntaxTransformation_RewriteFnRef that, RetType fnExpr_result) {
        return combine(that, fnExpr_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprRefOnly(_SyntaxTransformation_RewriteObjectExprRef that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationJuxtOnly(_SyntaxTransformationJuxt that, RetType multiJuxt_result, RetType infixJuxt_result, List<RetType> exprs_result) {
        return combine(that, multiJuxt_result, infixJuxt_result, combine(exprs_result));
    }

    public RetType for_SyntaxTransformation_RewriteFnAppOnly(_SyntaxTransformation_RewriteFnApp that, RetType function_result, RetType argument_result) {
        return combine(that, function_result, argument_result);
    }

    public RetType for_SyntaxTransformationOpExprOnly(_SyntaxTransformationOpExpr that, RetType op_result, List<RetType> args_result) {
        return combine(that, op_result, combine(args_result));
    }

    public RetType for_SyntaxTransformationAmbiguousMultifixOpExprOnly(_SyntaxTransformationAmbiguousMultifixOpExpr that, RetType infix_op_result, RetType multifix_op_result, List<RetType> args_result) {
        return combine(that, infix_op_result, multifix_op_result, combine(args_result));
    }

    public RetType for_SyntaxTransformationChainExprOnly(_SyntaxTransformationChainExpr that, RetType first_result) {
        return combine(that, first_result);
    }

    public RetType for_SyntaxTransformationCoercionInvocationOnly(_SyntaxTransformationCoercionInvocation that, RetType arg_result) {
        return combine(that, arg_result);
    }

    public RetType for_SyntaxTransformationTraitCoercionInvocationOnly(_SyntaxTransformationTraitCoercionInvocation that, RetType arg_result, RetType coercionFn_result) {
        return combine(that, arg_result, coercionFn_result);
    }

    public RetType for_SyntaxTransformationTupleCoercionInvocationOnly(_SyntaxTransformationTupleCoercionInvocation that, RetType arg_result, List<Option<RetType>> subCoercions_result, Option<Option<RetType>> varargCoercion_result) {
        return combine(that, arg_result, combineListOption(subCoercions_result), combineOptionOption(varargCoercion_result));
    }

    public RetType for_SyntaxTransformationArrowCoercionInvocationOnly(_SyntaxTransformationArrowCoercionInvocation that, RetType arg_result, Option<RetType> domainCoercion_result, Option<RetType> rangeCoercion_result) {
        return combine(that, arg_result, combine(domainCoercion_result), combine(rangeCoercion_result));
    }

    public RetType for_SyntaxTransformationUnionCoercionInvocationOnly(_SyntaxTransformationUnionCoercionInvocation that, RetType arg_result, List<Option<RetType>> fromCoercions_result) {
        return combine(that, arg_result, combineListOption(fromCoercions_result));
    }

    public RetType for_SyntaxTransformationMethodInvocationOnly(_SyntaxTransformationMethodInvocation that, RetType obj_result, RetType arg_result) {
        return combine(that, obj_result, arg_result);
    }

    public RetType for_SyntaxTransformationMathPrimaryOnly(_SyntaxTransformationMathPrimary that, RetType multiJuxt_result, RetType infixJuxt_result, RetType front_result) {
        return combine(that, multiJuxt_result, infixJuxt_result, front_result);
    }

    public RetType for_SyntaxTransformationArrayExprOnly(_SyntaxTransformationArrayExpr that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationArrayElementOnly(_SyntaxTransformationArrayElement that, RetType element_result) {
        return combine(that, element_result);
    }

    public RetType for_SyntaxTransformationArrayElementsOnly(_SyntaxTransformationArrayElements that, List<RetType> elements_result) {
        return combine(that, combine(elements_result));
    }

    public abstract RetType combine(List<RetType> l);

    public RetType combine(Expr that, RetType... vals) {
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
