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
@SuppressWarnings(value={"unused"})
public abstract class TemplateExprDepthFirstVisitor<RetType> extends ExprVisitorLambda<RetType> {
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, an exception is thrown; subclasses may override this behavior.
     * @throws IllegalArgumentException
    **/
    public RetType defaultCase(Expr that) {
        throw new IllegalArgumentException("Visitor " + getClass().getName() + " does not support visiting values of type " + that.getClass().getName());
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

    public RetType forTemplateGapExprOnly(TemplateGapExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDummyExprOnly(TemplateGapDummyExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTypeAnnotatedExprOnly(TemplateGapTypeAnnotatedExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAsExprOnly(TemplateGapAsExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAsIfExprOnly(TemplateGapAsIfExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAssignmentOnly(TemplateGapAssignment that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBlockOnly(TemplateGapBlock that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDoOnly(TemplateGapDo that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCaseExprOnly(TemplateGapCaseExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIfOnly(TemplateGapIf that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapLabelOnly(TemplateGapLabel that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAbstractObjectExprOnly(TemplateGapAbstractObjectExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapObjectExprOnly(TemplateGapObjectExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGap_RewriteObjectExprOnly(TemplateGap_RewriteObjectExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTryOnly(TemplateGapTry that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTupleExprOnly(TemplateGapTupleExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTypecaseOnly(TemplateGapTypecase that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapWhileOnly(TemplateGapWhile that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapForOnly(TemplateGapFor that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBigOpAppOnly(TemplateGapBigOpApp that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAccumulatorOnly(TemplateGapAccumulator that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapArrayComprehensionOnly(TemplateGapArrayComprehension that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAtomicExprOnly(TemplateGapAtomicExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapExitOnly(TemplateGapExit that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapSpawnOnly(TemplateGapSpawn that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapThrowOnly(TemplateGapThrow that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTryAtomicExprOnly(TemplateGapTryAtomicExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapFnExprOnly(TemplateGapFnExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapLetExprOnly(TemplateGapLetExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapLetFnOnly(TemplateGapLetFn that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapLocalVarDeclOnly(TemplateGapLocalVarDecl that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapSimpleExprOnly(TemplateGapSimpleExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapSubscriptExprOnly(TemplateGapSubscriptExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapPrimaryOnly(TemplateGapPrimary that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapLiteralExprOnly(TemplateGapLiteralExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapNumberLiteralExprOnly(TemplateGapNumberLiteralExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapFloatLiteralExprOnly(TemplateGapFloatLiteralExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIntLiteralExprOnly(TemplateGapIntLiteralExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCharLiteralExprOnly(TemplateGapCharLiteralExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapStringLiteralExprOnly(TemplateGapStringLiteralExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapVoidLiteralExprOnly(TemplateGapVoidLiteralExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBooleanLiteralExprOnly(TemplateGapBooleanLiteralExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapVarRefOnly(TemplateGapVarRef that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapFieldRefOnly(TemplateGapFieldRef that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapFunctionalRefOnly(TemplateGapFunctionalRef that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapFnRefOnly(TemplateGapFnRef that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapOpRefOnly(TemplateGapOpRef that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGap_RewriteFnRefOnly(TemplateGap_RewriteFnRef that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGap_RewriteObjectExprRefOnly(TemplateGap_RewriteObjectExprRef that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapJuxtOnly(TemplateGapJuxt that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGap_RewriteFnAppOnly(TemplateGap_RewriteFnApp that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapOpExprOnly(TemplateGapOpExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapAmbiguousMultifixOpExprOnly(TemplateGapAmbiguousMultifixOpExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapChainExprOnly(TemplateGapChainExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapCoercionInvocationOnly(TemplateGapCoercionInvocation that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTraitCoercionInvocationOnly(TemplateGapTraitCoercionInvocation that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTupleCoercionInvocationOnly(TemplateGapTupleCoercionInvocation that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapArrowCoercionInvocationOnly(TemplateGapArrowCoercionInvocation that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapUnionCoercionInvocationOnly(TemplateGapUnionCoercionInvocation that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapMethodInvocationOnly(TemplateGapMethodInvocation that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapMathPrimaryOnly(TemplateGapMathPrimary that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapArrayExprOnly(TemplateGapArrayExpr that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapArrayElementOnly(TemplateGapArrayElement that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapArrayElementsOnly(TemplateGapArrayElements that) {
        return defaultTemplateGapCase(that);
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

    public RetType forTemplateGapExpr(TemplateGapExpr that) {
        return forTemplateGapExprOnly(that);
    }

    public RetType forTemplateGapDummyExpr(TemplateGapDummyExpr that) {
        return forTemplateGapDummyExprOnly(that);
    }

    public RetType forTemplateGapTypeAnnotatedExpr(TemplateGapTypeAnnotatedExpr that) {
        return forTemplateGapTypeAnnotatedExprOnly(that);
    }

    public RetType forTemplateGapAsExpr(TemplateGapAsExpr that) {
        return forTemplateGapAsExprOnly(that);
    }

    public RetType forTemplateGapAsIfExpr(TemplateGapAsIfExpr that) {
        return forTemplateGapAsIfExprOnly(that);
    }

    public RetType forTemplateGapAssignment(TemplateGapAssignment that) {
        return forTemplateGapAssignmentOnly(that);
    }

    public RetType forTemplateGapBlock(TemplateGapBlock that) {
        return forTemplateGapBlockOnly(that);
    }

    public RetType forTemplateGapDo(TemplateGapDo that) {
        return forTemplateGapDoOnly(that);
    }

    public RetType forTemplateGapCaseExpr(TemplateGapCaseExpr that) {
        return forTemplateGapCaseExprOnly(that);
    }

    public RetType forTemplateGapIf(TemplateGapIf that) {
        return forTemplateGapIfOnly(that);
    }

    public RetType forTemplateGapLabel(TemplateGapLabel that) {
        return forTemplateGapLabelOnly(that);
    }

    public RetType forTemplateGapAbstractObjectExpr(TemplateGapAbstractObjectExpr that) {
        return forTemplateGapAbstractObjectExprOnly(that);
    }

    public RetType forTemplateGapObjectExpr(TemplateGapObjectExpr that) {
        return forTemplateGapObjectExprOnly(that);
    }

    public RetType forTemplateGap_RewriteObjectExpr(TemplateGap_RewriteObjectExpr that) {
        return forTemplateGap_RewriteObjectExprOnly(that);
    }

    public RetType forTemplateGapTry(TemplateGapTry that) {
        return forTemplateGapTryOnly(that);
    }

    public RetType forTemplateGapTupleExpr(TemplateGapTupleExpr that) {
        return forTemplateGapTupleExprOnly(that);
    }

    public RetType forTemplateGapTypecase(TemplateGapTypecase that) {
        return forTemplateGapTypecaseOnly(that);
    }

    public RetType forTemplateGapWhile(TemplateGapWhile that) {
        return forTemplateGapWhileOnly(that);
    }

    public RetType forTemplateGapFor(TemplateGapFor that) {
        return forTemplateGapForOnly(that);
    }

    public RetType forTemplateGapBigOpApp(TemplateGapBigOpApp that) {
        return forTemplateGapBigOpAppOnly(that);
    }

    public RetType forTemplateGapAccumulator(TemplateGapAccumulator that) {
        return forTemplateGapAccumulatorOnly(that);
    }

    public RetType forTemplateGapArrayComprehension(TemplateGapArrayComprehension that) {
        return forTemplateGapArrayComprehensionOnly(that);
    }

    public RetType forTemplateGapAtomicExpr(TemplateGapAtomicExpr that) {
        return forTemplateGapAtomicExprOnly(that);
    }

    public RetType forTemplateGapExit(TemplateGapExit that) {
        return forTemplateGapExitOnly(that);
    }

    public RetType forTemplateGapSpawn(TemplateGapSpawn that) {
        return forTemplateGapSpawnOnly(that);
    }

    public RetType forTemplateGapThrow(TemplateGapThrow that) {
        return forTemplateGapThrowOnly(that);
    }

    public RetType forTemplateGapTryAtomicExpr(TemplateGapTryAtomicExpr that) {
        return forTemplateGapTryAtomicExprOnly(that);
    }

    public RetType forTemplateGapFnExpr(TemplateGapFnExpr that) {
        return forTemplateGapFnExprOnly(that);
    }

    public RetType forTemplateGapLetExpr(TemplateGapLetExpr that) {
        return forTemplateGapLetExprOnly(that);
    }

    public RetType forTemplateGapLetFn(TemplateGapLetFn that) {
        return forTemplateGapLetFnOnly(that);
    }

    public RetType forTemplateGapLocalVarDecl(TemplateGapLocalVarDecl that) {
        return forTemplateGapLocalVarDeclOnly(that);
    }

    public RetType forTemplateGapSimpleExpr(TemplateGapSimpleExpr that) {
        return forTemplateGapSimpleExprOnly(that);
    }

    public RetType forTemplateGapSubscriptExpr(TemplateGapSubscriptExpr that) {
        return forTemplateGapSubscriptExprOnly(that);
    }

    public RetType forTemplateGapPrimary(TemplateGapPrimary that) {
        return forTemplateGapPrimaryOnly(that);
    }

    public RetType forTemplateGapLiteralExpr(TemplateGapLiteralExpr that) {
        return forTemplateGapLiteralExprOnly(that);
    }

    public RetType forTemplateGapNumberLiteralExpr(TemplateGapNumberLiteralExpr that) {
        return forTemplateGapNumberLiteralExprOnly(that);
    }

    public RetType forTemplateGapFloatLiteralExpr(TemplateGapFloatLiteralExpr that) {
        return forTemplateGapFloatLiteralExprOnly(that);
    }

    public RetType forTemplateGapIntLiteralExpr(TemplateGapIntLiteralExpr that) {
        return forTemplateGapIntLiteralExprOnly(that);
    }

    public RetType forTemplateGapCharLiteralExpr(TemplateGapCharLiteralExpr that) {
        return forTemplateGapCharLiteralExprOnly(that);
    }

    public RetType forTemplateGapStringLiteralExpr(TemplateGapStringLiteralExpr that) {
        return forTemplateGapStringLiteralExprOnly(that);
    }

    public RetType forTemplateGapVoidLiteralExpr(TemplateGapVoidLiteralExpr that) {
        return forTemplateGapVoidLiteralExprOnly(that);
    }

    public RetType forTemplateGapBooleanLiteralExpr(TemplateGapBooleanLiteralExpr that) {
        return forTemplateGapBooleanLiteralExprOnly(that);
    }

    public RetType forTemplateGapVarRef(TemplateGapVarRef that) {
        return forTemplateGapVarRefOnly(that);
    }

    public RetType forTemplateGapFieldRef(TemplateGapFieldRef that) {
        return forTemplateGapFieldRefOnly(that);
    }

    public RetType forTemplateGapFunctionalRef(TemplateGapFunctionalRef that) {
        return forTemplateGapFunctionalRefOnly(that);
    }

    public RetType forTemplateGapFnRef(TemplateGapFnRef that) {
        return forTemplateGapFnRefOnly(that);
    }

    public RetType forTemplateGapOpRef(TemplateGapOpRef that) {
        return forTemplateGapOpRefOnly(that);
    }

    public RetType forTemplateGap_RewriteFnRef(TemplateGap_RewriteFnRef that) {
        return forTemplateGap_RewriteFnRefOnly(that);
    }

    public RetType forTemplateGap_RewriteObjectExprRef(TemplateGap_RewriteObjectExprRef that) {
        return forTemplateGap_RewriteObjectExprRefOnly(that);
    }

    public RetType forTemplateGapJuxt(TemplateGapJuxt that) {
        return forTemplateGapJuxtOnly(that);
    }

    public RetType forTemplateGap_RewriteFnApp(TemplateGap_RewriteFnApp that) {
        return forTemplateGap_RewriteFnAppOnly(that);
    }

    public RetType forTemplateGapOpExpr(TemplateGapOpExpr that) {
        return forTemplateGapOpExprOnly(that);
    }

    public RetType forTemplateGapAmbiguousMultifixOpExpr(TemplateGapAmbiguousMultifixOpExpr that) {
        return forTemplateGapAmbiguousMultifixOpExprOnly(that);
    }

    public RetType forTemplateGapChainExpr(TemplateGapChainExpr that) {
        return forTemplateGapChainExprOnly(that);
    }

    public RetType forTemplateGapCoercionInvocation(TemplateGapCoercionInvocation that) {
        return forTemplateGapCoercionInvocationOnly(that);
    }

    public RetType forTemplateGapTraitCoercionInvocation(TemplateGapTraitCoercionInvocation that) {
        return forTemplateGapTraitCoercionInvocationOnly(that);
    }

    public RetType forTemplateGapTupleCoercionInvocation(TemplateGapTupleCoercionInvocation that) {
        return forTemplateGapTupleCoercionInvocationOnly(that);
    }

    public RetType forTemplateGapArrowCoercionInvocation(TemplateGapArrowCoercionInvocation that) {
        return forTemplateGapArrowCoercionInvocationOnly(that);
    }

    public RetType forTemplateGapUnionCoercionInvocation(TemplateGapUnionCoercionInvocation that) {
        return forTemplateGapUnionCoercionInvocationOnly(that);
    }

    public RetType forTemplateGapMethodInvocation(TemplateGapMethodInvocation that) {
        return forTemplateGapMethodInvocationOnly(that);
    }

    public RetType forTemplateGapMathPrimary(TemplateGapMathPrimary that) {
        return forTemplateGapMathPrimaryOnly(that);
    }

    public RetType forTemplateGapArrayExpr(TemplateGapArrayExpr that) {
        return forTemplateGapArrayExprOnly(that);
    }

    public RetType forTemplateGapArrayElement(TemplateGapArrayElement that) {
        return forTemplateGapArrayElementOnly(that);
    }

    public RetType forTemplateGapArrayElements(TemplateGapArrayElements that) {
        return forTemplateGapArrayElementsOnly(that);
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
