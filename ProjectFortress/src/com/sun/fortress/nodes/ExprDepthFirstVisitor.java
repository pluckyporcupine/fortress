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

/** A parametric abstract implementation of a visitor over Expr that returns a value.
 ** This visitor implements the visitor interface with methods that
 ** first visit children, and then call forCASEOnly(), passing in
 ** the values of the visits of the children. (CASE is replaced by the case name.)
 ** By default, each of forCASEOnly delegates to a more general case; at the
 ** top of this delegation tree is defaultCase(), which (unless overridden)
 ** throws an exception.
 **/
@SuppressWarnings({"unused", "unchecked"})
public abstract class ExprDepthFirstVisitor<RetType> extends ExprVisitorLambda<RetType> {
    private String templateErrorMessage = "Please use TemplateDepthFirstVisitor if you intend to visit template gaps, if not then a template gap survived longer than its expected life time.";
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, an exception is thrown; subclasses may override this behavior.
     * @throws IllegalArgumentException
    **/
    public RetType defaultCase(Expr that) {
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
    public RetType forExprOnly(Expr that) {
        return defaultCase(that);
    }

    public RetType forDummyExprOnly(DummyExpr that) {
        return forExprOnly(that);
    }

    public RetType forTypeAnnotatedExprOnly(TypeAnnotatedExpr that, RetType expr_result) {
        return forExprOnly(that);
    }

    public RetType forAsExprOnly(AsExpr that, RetType expr_result) {
        return forTypeAnnotatedExprOnly(that, expr_result);
    }

    public RetType forAsIfExprOnly(AsIfExpr that, RetType expr_result) {
        return forTypeAnnotatedExprOnly(that, expr_result);
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

    public RetType forCaseExprOnly(CaseExpr that, Option<RetType> param_result, Option<RetType> compare_result, RetType equalsOp_result, RetType inOp_result, Option<RetType> elseClause_result) {
        return forExprOnly(that);
    }

    public RetType forIfOnly(If that, Option<RetType> elseClause_result) {
        return forExprOnly(that);
    }

    public RetType forLabelOnly(Label that, RetType body_result) {
        return forExprOnly(that);
    }

    public RetType forAbstractObjectExprOnly(AbstractObjectExpr that) {
        return forExprOnly(that);
    }

    public RetType forObjectExprOnly(ObjectExpr that) {
        return forAbstractObjectExprOnly(that);
    }

    public RetType for_RewriteObjectExprOnly(_RewriteObjectExpr that) {
        return forAbstractObjectExprOnly(that);
    }

    public RetType forTryOnly(Try that, RetType body_result, Option<RetType> finallyClause_result) {
        return forExprOnly(that);
    }

    public RetType forTupleExprOnly(TupleExpr that, List<RetType> exprs_result, Option<RetType> varargs_result) {
        return forExprOnly(that);
    }

    public RetType forTypecaseOnly(Typecase that, RetType bindExpr_result, Option<RetType> elseClause_result) {
        return forExprOnly(that);
    }

    public RetType forWhileOnly(While that, RetType body_result) {
        return forExprOnly(that);
    }

    public RetType forForOnly(For that, RetType body_result) {
        return forExprOnly(that);
    }

    public RetType forBigOpAppOnly(BigOpApp that) {
        return forExprOnly(that);
    }

    public RetType forAccumulatorOnly(Accumulator that, RetType body_result) {
        return forBigOpAppOnly(that);
    }

    public RetType forArrayComprehensionOnly(ArrayComprehension that) {
        return forBigOpAppOnly(that);
    }

    public RetType forAtomicExprOnly(AtomicExpr that, RetType expr_result) {
        return forExprOnly(that);
    }

    public RetType forExitOnly(Exit that, Option<RetType> returnExpr_result) {
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

    public RetType forLetFnOnly(LetFn that, RetType body_result) {
        return forLetExprOnly(that, body_result);
    }

    public RetType forLocalVarDeclOnly(LocalVarDecl that, RetType body_result, Option<RetType> rhs_result) {
        return forLetExprOnly(that, body_result);
    }

    public RetType forSimpleExprOnly(SimpleExpr that) {
        return forExprOnly(that);
    }

    public RetType forSubscriptExprOnly(SubscriptExpr that, RetType obj_result, List<RetType> subs_result) {
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

    public RetType forVarRefOnly(VarRef that) {
        return forPrimaryOnly(that);
    }

    public RetType forFieldRefOnly(FieldRef that, RetType obj_result) {
        return forPrimaryOnly(that);
    }

    public RetType forFunctionalRefOnly(FunctionalRef that) {
        return forPrimaryOnly(that);
    }

    public RetType forFnRefOnly(FnRef that) {
        return forFunctionalRefOnly(that);
    }

    public RetType forOpRefOnly(OpRef that) {
        return forFunctionalRefOnly(that);
    }

    public RetType for_RewriteFnRefOnly(_RewriteFnRef that, RetType fnExpr_result) {
        return forPrimaryOnly(that);
    }

    public RetType for_RewriteObjectExprRefOnly(_RewriteObjectExprRef that) {
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

    public RetType forChainExprOnly(ChainExpr that, RetType first_result) {
        return forPrimaryOnly(that);
    }

    public RetType forCoercionInvocationOnly(CoercionInvocation that, RetType arg_result) {
        return forPrimaryOnly(that);
    }

    public RetType forTraitCoercionInvocationOnly(TraitCoercionInvocation that, RetType arg_result, RetType coercionFn_result) {
        return forCoercionInvocationOnly(that, arg_result);
    }

    public RetType forTupleCoercionInvocationOnly(TupleCoercionInvocation that, RetType arg_result, List<Option<RetType>> subCoercions_result, Option<Option<RetType>> varargCoercion_result) {
        return forCoercionInvocationOnly(that, arg_result);
    }

    public RetType forArrowCoercionInvocationOnly(ArrowCoercionInvocation that, RetType arg_result, Option<RetType> domainCoercion_result, Option<RetType> rangeCoercion_result) {
        return forCoercionInvocationOnly(that, arg_result);
    }

    public RetType forUnionCoercionInvocationOnly(UnionCoercionInvocation that, RetType arg_result, List<Option<RetType>> fromCoercions_result) {
        return forCoercionInvocationOnly(that, arg_result);
    }

    public RetType forMethodInvocationOnly(MethodInvocation that, RetType obj_result, RetType arg_result) {
        return forPrimaryOnly(that);
    }

    public RetType forMathPrimaryOnly(MathPrimary that, RetType multiJuxt_result, RetType infixJuxt_result, RetType front_result) {
        return forPrimaryOnly(that);
    }

    public RetType forArrayExprOnly(ArrayExpr that) {
        return forPrimaryOnly(that);
    }

    public RetType forArrayElementOnly(ArrayElement that, RetType element_result) {
        return forArrayExprOnly(that);
    }

    public RetType forArrayElementsOnly(ArrayElements that, List<RetType> elements_result) {
        return forArrayExprOnly(that);
    }

    public RetType for_SyntaxTransformationExprOnly(_SyntaxTransformationExpr that) {
        return forExprOnly(that);
    }

    public RetType for_SyntaxTransformationDummyExprOnly(_SyntaxTransformationDummyExpr that) {
        return forDummyExprOnly(that);
    }

    public RetType for_SyntaxTransformationTypeAnnotatedExprOnly(_SyntaxTransformationTypeAnnotatedExpr that, RetType expr_result) {
        return forTypeAnnotatedExprOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationAsExprOnly(_SyntaxTransformationAsExpr that, RetType expr_result) {
        return forAsExprOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationAsIfExprOnly(_SyntaxTransformationAsIfExpr that, RetType expr_result) {
        return forAsIfExprOnly(that, expr_result);
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

    public RetType for_SyntaxTransformationCaseExprOnly(_SyntaxTransformationCaseExpr that, Option<RetType> param_result, Option<RetType> compare_result, RetType equalsOp_result, RetType inOp_result, Option<RetType> elseClause_result) {
        return forCaseExprOnly(that, param_result, compare_result, equalsOp_result, inOp_result, elseClause_result);
    }

    public RetType for_SyntaxTransformationIfOnly(_SyntaxTransformationIf that, Option<RetType> elseClause_result) {
        return forIfOnly(that, elseClause_result);
    }

    public RetType for_SyntaxTransformationLabelOnly(_SyntaxTransformationLabel that, RetType body_result) {
        return forLabelOnly(that, body_result);
    }

    public RetType for_SyntaxTransformationAbstractObjectExprOnly(_SyntaxTransformationAbstractObjectExpr that) {
        return forAbstractObjectExprOnly(that);
    }

    public RetType for_SyntaxTransformationObjectExprOnly(_SyntaxTransformationObjectExpr that) {
        return forObjectExprOnly(that);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprOnly(_SyntaxTransformation_RewriteObjectExpr that) {
        return for_RewriteObjectExprOnly(that);
    }

    public RetType for_SyntaxTransformationTryOnly(_SyntaxTransformationTry that, RetType body_result, Option<RetType> finallyClause_result) {
        return forTryOnly(that, body_result, finallyClause_result);
    }

    public RetType for_SyntaxTransformationTupleExprOnly(_SyntaxTransformationTupleExpr that, List<RetType> exprs_result, Option<RetType> varargs_result) {
        return forTupleExprOnly(that, exprs_result, varargs_result);
    }

    public RetType for_SyntaxTransformationTypecaseOnly(_SyntaxTransformationTypecase that, RetType bindExpr_result, Option<RetType> elseClause_result) {
        return forTypecaseOnly(that, bindExpr_result, elseClause_result);
    }

    public RetType for_SyntaxTransformationWhileOnly(_SyntaxTransformationWhile that, RetType body_result) {
        return forWhileOnly(that, body_result);
    }

    public RetType for_SyntaxTransformationForOnly(_SyntaxTransformationFor that, RetType body_result) {
        return forForOnly(that, body_result);
    }

    public RetType for_SyntaxTransformationBigOpAppOnly(_SyntaxTransformationBigOpApp that) {
        return forBigOpAppOnly(that);
    }

    public RetType for_SyntaxTransformationAccumulatorOnly(_SyntaxTransformationAccumulator that, RetType body_result) {
        return forAccumulatorOnly(that, body_result);
    }

    public RetType for_SyntaxTransformationArrayComprehensionOnly(_SyntaxTransformationArrayComprehension that) {
        return forArrayComprehensionOnly(that);
    }

    public RetType for_SyntaxTransformationAtomicExprOnly(_SyntaxTransformationAtomicExpr that, RetType expr_result) {
        return forAtomicExprOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationExitOnly(_SyntaxTransformationExit that, Option<RetType> returnExpr_result) {
        return forExitOnly(that, returnExpr_result);
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

    public RetType for_SyntaxTransformationLetFnOnly(_SyntaxTransformationLetFn that, RetType body_result) {
        return forLetFnOnly(that, body_result);
    }

    public RetType for_SyntaxTransformationLocalVarDeclOnly(_SyntaxTransformationLocalVarDecl that, RetType body_result, Option<RetType> rhs_result) {
        return forLocalVarDeclOnly(that, body_result, rhs_result);
    }

    public RetType for_SyntaxTransformationSimpleExprOnly(_SyntaxTransformationSimpleExpr that) {
        return forSimpleExprOnly(that);
    }

    public RetType for_SyntaxTransformationSubscriptExprOnly(_SyntaxTransformationSubscriptExpr that, RetType obj_result, List<RetType> subs_result) {
        return forSubscriptExprOnly(that, obj_result, subs_result);
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

    public RetType for_SyntaxTransformationVarRefOnly(_SyntaxTransformationVarRef that) {
        return forVarRefOnly(that);
    }

    public RetType for_SyntaxTransformationFieldRefOnly(_SyntaxTransformationFieldRef that, RetType obj_result) {
        return forFieldRefOnly(that, obj_result);
    }

    public RetType for_SyntaxTransformationFunctionalRefOnly(_SyntaxTransformationFunctionalRef that) {
        return forFunctionalRefOnly(that);
    }

    public RetType for_SyntaxTransformationFnRefOnly(_SyntaxTransformationFnRef that) {
        return forFnRefOnly(that);
    }

    public RetType for_SyntaxTransformationOpRefOnly(_SyntaxTransformationOpRef that) {
        return forOpRefOnly(that);
    }

    public RetType for_SyntaxTransformation_RewriteFnRefOnly(_SyntaxTransformation_RewriteFnRef that, RetType fnExpr_result) {
        return for_RewriteFnRefOnly(that, fnExpr_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprRefOnly(_SyntaxTransformation_RewriteObjectExprRef that) {
        return for_RewriteObjectExprRefOnly(that);
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

    public RetType for_SyntaxTransformationChainExprOnly(_SyntaxTransformationChainExpr that, RetType first_result) {
        return forChainExprOnly(that, first_result);
    }

    public RetType for_SyntaxTransformationCoercionInvocationOnly(_SyntaxTransformationCoercionInvocation that, RetType arg_result) {
        return forCoercionInvocationOnly(that, arg_result);
    }

    public RetType for_SyntaxTransformationTraitCoercionInvocationOnly(_SyntaxTransformationTraitCoercionInvocation that, RetType arg_result, RetType coercionFn_result) {
        return forTraitCoercionInvocationOnly(that, arg_result, coercionFn_result);
    }

    public RetType for_SyntaxTransformationTupleCoercionInvocationOnly(_SyntaxTransformationTupleCoercionInvocation that, RetType arg_result, List<Option<RetType>> subCoercions_result, Option<Option<RetType>> varargCoercion_result) {
        return forTupleCoercionInvocationOnly(that, arg_result, subCoercions_result, varargCoercion_result);
    }

    public RetType for_SyntaxTransformationArrowCoercionInvocationOnly(_SyntaxTransformationArrowCoercionInvocation that, RetType arg_result, Option<RetType> domainCoercion_result, Option<RetType> rangeCoercion_result) {
        return forArrowCoercionInvocationOnly(that, arg_result, domainCoercion_result, rangeCoercion_result);
    }

    public RetType for_SyntaxTransformationUnionCoercionInvocationOnly(_SyntaxTransformationUnionCoercionInvocation that, RetType arg_result, List<Option<RetType>> fromCoercions_result) {
        return forUnionCoercionInvocationOnly(that, arg_result, fromCoercions_result);
    }

    public RetType for_SyntaxTransformationMethodInvocationOnly(_SyntaxTransformationMethodInvocation that, RetType obj_result, RetType arg_result) {
        return forMethodInvocationOnly(that, obj_result, arg_result);
    }

    public RetType for_SyntaxTransformationMathPrimaryOnly(_SyntaxTransformationMathPrimary that, RetType multiJuxt_result, RetType infixJuxt_result, RetType front_result) {
        return forMathPrimaryOnly(that, multiJuxt_result, infixJuxt_result, front_result);
    }

    public RetType for_SyntaxTransformationArrayExprOnly(_SyntaxTransformationArrayExpr that) {
        return forArrayExprOnly(that);
    }

    public RetType for_SyntaxTransformationArrayElementOnly(_SyntaxTransformationArrayElement that, RetType element_result) {
        return forArrayElementOnly(that, element_result);
    }

    public RetType for_SyntaxTransformationArrayElementsOnly(_SyntaxTransformationArrayElements that, List<RetType> elements_result) {
        return forArrayElementsOnly(that, elements_result);
    }


    /** Methods to recur on each child. */
    public RetType forDummyExpr(DummyExpr that) {
        return forDummyExprOnly(that);
    }

    public RetType forAsExpr(AsExpr that) {
        RetType expr_result = recur(that.getExpr());
        return forAsExprOnly(that, expr_result);
    }

    public RetType forAsIfExpr(AsIfExpr that) {
        RetType expr_result = recur(that.getExpr());
        return forAsIfExprOnly(that, expr_result);
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
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forCaseExprOnly(that, param_result, compare_result, equalsOp_result, inOp_result, elseClause_result);
    }

    public RetType forIf(If that) {
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forIfOnly(that, elseClause_result);
    }

    public RetType forLabel(Label that) {
        RetType body_result = recur(that.getBody());
        return forLabelOnly(that, body_result);
    }

    public RetType forObjectExpr(ObjectExpr that) {
        return forObjectExprOnly(that);
    }

    public RetType for_RewriteObjectExpr(_RewriteObjectExpr that) {
        return for_RewriteObjectExprOnly(that);
    }

    public RetType forTry(Try that) {
        RetType body_result = recur(that.getBody());
        Option<RetType> finallyClause_result = recurOnOptionOfBlock(that.getFinallyClause());
        return forTryOnly(that, body_result, finallyClause_result);
    }

    public RetType forTupleExpr(TupleExpr that) {
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        Option<RetType> varargs_result = recurOnOptionOfExpr(that.getVarargs());
        return forTupleExprOnly(that, exprs_result, varargs_result);
    }

    public RetType forTypecase(Typecase that) {
        RetType bindExpr_result = recur(that.getBindExpr());
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return forTypecaseOnly(that, bindExpr_result, elseClause_result);
    }

    public RetType forWhile(While that) {
        RetType body_result = recur(that.getBody());
        return forWhileOnly(that, body_result);
    }

    public RetType forFor(For that) {
        RetType body_result = recur(that.getBody());
        return forForOnly(that, body_result);
    }

    public RetType forAccumulator(Accumulator that) {
        RetType body_result = recur(that.getBody());
        return forAccumulatorOnly(that, body_result);
    }

    public RetType forArrayComprehension(ArrayComprehension that) {
        return forArrayComprehensionOnly(that);
    }

    public RetType forAtomicExpr(AtomicExpr that) {
        RetType expr_result = recur(that.getExpr());
        return forAtomicExprOnly(that, expr_result);
    }

    public RetType forExit(Exit that) {
        Option<RetType> returnExpr_result = recurOnOptionOfExpr(that.getReturnExpr());
        return forExitOnly(that, returnExpr_result);
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
        return forLetFnOnly(that, body_result);
    }

    public RetType forLocalVarDecl(LocalVarDecl that) {
        RetType body_result = recur(that.getBody());
        Option<RetType> rhs_result = recurOnOptionOfExpr(that.getRhs());
        return forLocalVarDeclOnly(that, body_result, rhs_result);
    }

    public RetType forSubscriptExpr(SubscriptExpr that) {
        RetType obj_result = recur(that.getObj());
        List<RetType> subs_result = recurOnListOfExpr(that.getSubs());
        return forSubscriptExprOnly(that, obj_result, subs_result);
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
        return forVarRefOnly(that);
    }

    public RetType forFieldRef(FieldRef that) {
        RetType obj_result = recur(that.getObj());
        return forFieldRefOnly(that, obj_result);
    }

    public RetType forFnRef(FnRef that) {
        return forFnRefOnly(that);
    }

    public RetType forOpRef(OpRef that) {
        return forOpRefOnly(that);
    }

    public RetType for_RewriteFnRef(_RewriteFnRef that) {
        RetType fnExpr_result = recur(that.getFnExpr());
        return for_RewriteFnRefOnly(that, fnExpr_result);
    }

    public RetType for_RewriteObjectExprRef(_RewriteObjectExprRef that) {
        return for_RewriteObjectExprRefOnly(that);
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
        return forChainExprOnly(that, first_result);
    }

    public RetType forTraitCoercionInvocation(TraitCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        RetType coercionFn_result = recur(that.getCoercionFn());
        return forTraitCoercionInvocationOnly(that, arg_result, coercionFn_result);
    }

    public RetType forTupleCoercionInvocation(TupleCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        List<Option<RetType>> subCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getSubCoercions());
        Option<Option<RetType>> varargCoercion_result = recurOnOptionOfOptionOfCoercionInvocation(that.getVarargCoercion());
        return forTupleCoercionInvocationOnly(that, arg_result, subCoercions_result, varargCoercion_result);
    }

    public RetType forArrowCoercionInvocation(ArrowCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        Option<RetType> domainCoercion_result = recurOnOptionOfCoercionInvocation(that.getDomainCoercion());
        Option<RetType> rangeCoercion_result = recurOnOptionOfCoercionInvocation(that.getRangeCoercion());
        return forArrowCoercionInvocationOnly(that, arg_result, domainCoercion_result, rangeCoercion_result);
    }

    public RetType forUnionCoercionInvocation(UnionCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        List<Option<RetType>> fromCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getFromCoercions());
        return forUnionCoercionInvocationOnly(that, arg_result, fromCoercions_result);
    }

    public RetType forMethodInvocation(MethodInvocation that) {
        RetType obj_result = recur(that.getObj());
        RetType arg_result = recur(that.getArg());
        return forMethodInvocationOnly(that, obj_result, arg_result);
    }

    public RetType forMathPrimary(MathPrimary that) {
        RetType multiJuxt_result = recur(that.getMultiJuxt());
        RetType infixJuxt_result = recur(that.getInfixJuxt());
        RetType front_result = recur(that.getFront());
        return forMathPrimaryOnly(that, multiJuxt_result, infixJuxt_result, front_result);
    }

    public RetType forArrayElement(ArrayElement that) {
        RetType element_result = recur(that.getElement());
        return forArrayElementOnly(that, element_result);
    }

    public RetType forArrayElements(ArrayElements that) {
        List<RetType> elements_result = recurOnListOfArrayExpr(that.getElements());
        return forArrayElementsOnly(that, elements_result);
    }

    public RetType for_SyntaxTransformationExpr(_SyntaxTransformationExpr that) {
        return for_SyntaxTransformationExprOnly(that);
    }

    public RetType for_SyntaxTransformationDummyExpr(_SyntaxTransformationDummyExpr that) {
        return for_SyntaxTransformationDummyExprOnly(that);
    }

    public RetType for_SyntaxTransformationTypeAnnotatedExpr(_SyntaxTransformationTypeAnnotatedExpr that) {
        RetType expr_result = recur(that.getExpr());
        return for_SyntaxTransformationTypeAnnotatedExprOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationAsExpr(_SyntaxTransformationAsExpr that) {
        RetType expr_result = recur(that.getExpr());
        return for_SyntaxTransformationAsExprOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationAsIfExpr(_SyntaxTransformationAsIfExpr that) {
        RetType expr_result = recur(that.getExpr());
        return for_SyntaxTransformationAsIfExprOnly(that, expr_result);
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
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return for_SyntaxTransformationCaseExprOnly(that, param_result, compare_result, equalsOp_result, inOp_result, elseClause_result);
    }

    public RetType for_SyntaxTransformationIf(_SyntaxTransformationIf that) {
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return for_SyntaxTransformationIfOnly(that, elseClause_result);
    }

    public RetType for_SyntaxTransformationLabel(_SyntaxTransformationLabel that) {
        RetType body_result = recur(that.getBody());
        return for_SyntaxTransformationLabelOnly(that, body_result);
    }

    public RetType for_SyntaxTransformationAbstractObjectExpr(_SyntaxTransformationAbstractObjectExpr that) {
        return for_SyntaxTransformationAbstractObjectExprOnly(that);
    }

    public RetType for_SyntaxTransformationObjectExpr(_SyntaxTransformationObjectExpr that) {
        return for_SyntaxTransformationObjectExprOnly(that);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExpr(_SyntaxTransformation_RewriteObjectExpr that) {
        return for_SyntaxTransformation_RewriteObjectExprOnly(that);
    }

    public RetType for_SyntaxTransformationTry(_SyntaxTransformationTry that) {
        RetType body_result = recur(that.getBody());
        Option<RetType> finallyClause_result = recurOnOptionOfBlock(that.getFinallyClause());
        return for_SyntaxTransformationTryOnly(that, body_result, finallyClause_result);
    }

    public RetType for_SyntaxTransformationTupleExpr(_SyntaxTransformationTupleExpr that) {
        List<RetType> exprs_result = recurOnListOfExpr(that.getExprs());
        Option<RetType> varargs_result = recurOnOptionOfExpr(that.getVarargs());
        return for_SyntaxTransformationTupleExprOnly(that, exprs_result, varargs_result);
    }

    public RetType for_SyntaxTransformationTypecase(_SyntaxTransformationTypecase that) {
        RetType bindExpr_result = recur(that.getBindExpr());
        Option<RetType> elseClause_result = recurOnOptionOfBlock(that.getElseClause());
        return for_SyntaxTransformationTypecaseOnly(that, bindExpr_result, elseClause_result);
    }

    public RetType for_SyntaxTransformationWhile(_SyntaxTransformationWhile that) {
        RetType body_result = recur(that.getBody());
        return for_SyntaxTransformationWhileOnly(that, body_result);
    }

    public RetType for_SyntaxTransformationFor(_SyntaxTransformationFor that) {
        RetType body_result = recur(that.getBody());
        return for_SyntaxTransformationForOnly(that, body_result);
    }

    public RetType for_SyntaxTransformationBigOpApp(_SyntaxTransformationBigOpApp that) {
        return for_SyntaxTransformationBigOpAppOnly(that);
    }

    public RetType for_SyntaxTransformationAccumulator(_SyntaxTransformationAccumulator that) {
        RetType body_result = recur(that.getBody());
        return for_SyntaxTransformationAccumulatorOnly(that, body_result);
    }

    public RetType for_SyntaxTransformationArrayComprehension(_SyntaxTransformationArrayComprehension that) {
        return for_SyntaxTransformationArrayComprehensionOnly(that);
    }

    public RetType for_SyntaxTransformationAtomicExpr(_SyntaxTransformationAtomicExpr that) {
        RetType expr_result = recur(that.getExpr());
        return for_SyntaxTransformationAtomicExprOnly(that, expr_result);
    }

    public RetType for_SyntaxTransformationExit(_SyntaxTransformationExit that) {
        Option<RetType> returnExpr_result = recurOnOptionOfExpr(that.getReturnExpr());
        return for_SyntaxTransformationExitOnly(that, returnExpr_result);
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
        return for_SyntaxTransformationLetFnOnly(that, body_result);
    }

    public RetType for_SyntaxTransformationLocalVarDecl(_SyntaxTransformationLocalVarDecl that) {
        RetType body_result = recur(that.getBody());
        Option<RetType> rhs_result = recurOnOptionOfExpr(that.getRhs());
        return for_SyntaxTransformationLocalVarDeclOnly(that, body_result, rhs_result);
    }

    public RetType for_SyntaxTransformationSimpleExpr(_SyntaxTransformationSimpleExpr that) {
        return for_SyntaxTransformationSimpleExprOnly(that);
    }

    public RetType for_SyntaxTransformationSubscriptExpr(_SyntaxTransformationSubscriptExpr that) {
        RetType obj_result = recur(that.getObj());
        List<RetType> subs_result = recurOnListOfExpr(that.getSubs());
        return for_SyntaxTransformationSubscriptExprOnly(that, obj_result, subs_result);
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
        return for_SyntaxTransformationVarRefOnly(that);
    }

    public RetType for_SyntaxTransformationFieldRef(_SyntaxTransformationFieldRef that) {
        RetType obj_result = recur(that.getObj());
        return for_SyntaxTransformationFieldRefOnly(that, obj_result);
    }

    public RetType for_SyntaxTransformationFunctionalRef(_SyntaxTransformationFunctionalRef that) {
        return for_SyntaxTransformationFunctionalRefOnly(that);
    }

    public RetType for_SyntaxTransformationFnRef(_SyntaxTransformationFnRef that) {
        return for_SyntaxTransformationFnRefOnly(that);
    }

    public RetType for_SyntaxTransformationOpRef(_SyntaxTransformationOpRef that) {
        return for_SyntaxTransformationOpRefOnly(that);
    }

    public RetType for_SyntaxTransformation_RewriteFnRef(_SyntaxTransformation_RewriteFnRef that) {
        RetType fnExpr_result = recur(that.getFnExpr());
        return for_SyntaxTransformation_RewriteFnRefOnly(that, fnExpr_result);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprRef(_SyntaxTransformation_RewriteObjectExprRef that) {
        return for_SyntaxTransformation_RewriteObjectExprRefOnly(that);
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
        return for_SyntaxTransformationChainExprOnly(that, first_result);
    }

    public RetType for_SyntaxTransformationCoercionInvocation(_SyntaxTransformationCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        return for_SyntaxTransformationCoercionInvocationOnly(that, arg_result);
    }

    public RetType for_SyntaxTransformationTraitCoercionInvocation(_SyntaxTransformationTraitCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        RetType coercionFn_result = recur(that.getCoercionFn());
        return for_SyntaxTransformationTraitCoercionInvocationOnly(that, arg_result, coercionFn_result);
    }

    public RetType for_SyntaxTransformationTupleCoercionInvocation(_SyntaxTransformationTupleCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        List<Option<RetType>> subCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getSubCoercions());
        Option<Option<RetType>> varargCoercion_result = recurOnOptionOfOptionOfCoercionInvocation(that.getVarargCoercion());
        return for_SyntaxTransformationTupleCoercionInvocationOnly(that, arg_result, subCoercions_result, varargCoercion_result);
    }

    public RetType for_SyntaxTransformationArrowCoercionInvocation(_SyntaxTransformationArrowCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        Option<RetType> domainCoercion_result = recurOnOptionOfCoercionInvocation(that.getDomainCoercion());
        Option<RetType> rangeCoercion_result = recurOnOptionOfCoercionInvocation(that.getRangeCoercion());
        return for_SyntaxTransformationArrowCoercionInvocationOnly(that, arg_result, domainCoercion_result, rangeCoercion_result);
    }

    public RetType for_SyntaxTransformationUnionCoercionInvocation(_SyntaxTransformationUnionCoercionInvocation that) {
        RetType arg_result = recur(that.getArg());
        List<Option<RetType>> fromCoercions_result = recurOnListOfOptionOfCoercionInvocation(that.getFromCoercions());
        return for_SyntaxTransformationUnionCoercionInvocationOnly(that, arg_result, fromCoercions_result);
    }

    public RetType for_SyntaxTransformationMethodInvocation(_SyntaxTransformationMethodInvocation that) {
        RetType obj_result = recur(that.getObj());
        RetType arg_result = recur(that.getArg());
        return for_SyntaxTransformationMethodInvocationOnly(that, obj_result, arg_result);
    }

    public RetType for_SyntaxTransformationMathPrimary(_SyntaxTransformationMathPrimary that) {
        RetType multiJuxt_result = recur(that.getMultiJuxt());
        RetType infixJuxt_result = recur(that.getInfixJuxt());
        RetType front_result = recur(that.getFront());
        return for_SyntaxTransformationMathPrimaryOnly(that, multiJuxt_result, infixJuxt_result, front_result);
    }

    public RetType for_SyntaxTransformationArrayExpr(_SyntaxTransformationArrayExpr that) {
        return for_SyntaxTransformationArrayExprOnly(that);
    }

    public RetType for_SyntaxTransformationArrayElement(_SyntaxTransformationArrayElement that) {
        RetType element_result = recur(that.getElement());
        return for_SyntaxTransformationArrayElementOnly(that, element_result);
    }

    public RetType for_SyntaxTransformationArrayElements(_SyntaxTransformationArrayElements that) {
        List<RetType> elements_result = recurOnListOfArrayExpr(that.getElements());
        return for_SyntaxTransformationArrayElementsOnly(that, elements_result);
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


    public RetType recur(Expr that) {
        return that.accept(this);
    }


    public Option<RetType> recurOnOptionOfFunctionalRef(Option<FunctionalRef> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
    }

    public Option<RetType> recurOnOptionOfExpr(Option<Expr> that) {
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

    public Option<RetType> recurOnOptionOfBlock(Option<Block> that) {
        if (that.isNone()) return Option.<RetType>none();
        else return Option.<RetType>some(recur(that.unwrap()));
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

    public List<RetType> recurOnListOfArrayExpr(List<ArrayExpr> that) {
        java.util.ArrayList<RetType> accum = new java.util.ArrayList<RetType>(that.size());
        for (ArrayExpr elt : that) {
            accum.add(recur(elt));
        }
        return accum;
    }
}
