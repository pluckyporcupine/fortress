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

/** An abstract implementation of a visitor over Expr including template gaps that does not return a value.
 ** This visitor implements the visitor interface with methods that 
 ** first call forCASEDoFirst(), second visit the children, and finally 
 ** call forCASEOnly().  (CASE is replaced by the case name.)
 ** By default, each of forCASEDoFirst and forCASEOnly delegates
 ** to a more general case.  At the top of this delegation tree are
 ** defaultDoFirst() and defaultCase(), respectively, which (unless
 ** overridden) are no-ops.
 **/
@SuppressWarnings(value={"unused"})
public class TemplateExprDepthFirstVisitor_void extends ExprVisitorRunnable1 {
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, it is a no-op; subclasses may override this behavior.
    **/
    public void defaultCase(Expr that) {}

    /**
     * This method is run for all DoFirst cases that are not handled elsewhere.
     * By default, it is a no-op; subclasses may override this behavior.
    **/
    public void defaultDoFirst(Expr that) {}

    /* Methods to handle a node before recursion. */
    public void forExprDoFirst(Expr that) {
        defaultDoFirst(that);
    }

    public void forDummyExprDoFirst(DummyExpr that) {
        forExprDoFirst(that);
    }

    public void forTypeAnnotatedExprDoFirst(TypeAnnotatedExpr that) {
        forExprDoFirst(that);
    }

    public void forAsExprDoFirst(AsExpr that) {
        forTypeAnnotatedExprDoFirst(that);
    }

    public void forAsIfExprDoFirst(AsIfExpr that) {
        forTypeAnnotatedExprDoFirst(that);
    }

    public void forAssignmentDoFirst(Assignment that) {
        forExprDoFirst(that);
    }

    public void forBlockDoFirst(Block that) {
        forExprDoFirst(that);
    }

    public void forDoDoFirst(Do that) {
        forExprDoFirst(that);
    }

    public void forCaseExprDoFirst(CaseExpr that) {
        forExprDoFirst(that);
    }

    public void forIfDoFirst(If that) {
        forExprDoFirst(that);
    }

    public void forLabelDoFirst(Label that) {
        forExprDoFirst(that);
    }

    public void forAbstractObjectExprDoFirst(AbstractObjectExpr that) {
        forExprDoFirst(that);
    }

    public void forObjectExprDoFirst(ObjectExpr that) {
        forAbstractObjectExprDoFirst(that);
    }

    public void for_RewriteObjectExprDoFirst(_RewriteObjectExpr that) {
        forAbstractObjectExprDoFirst(that);
    }

    public void forTryDoFirst(Try that) {
        forExprDoFirst(that);
    }

    public void forTupleExprDoFirst(TupleExpr that) {
        forExprDoFirst(that);
    }

    public void forTypecaseDoFirst(Typecase that) {
        forExprDoFirst(that);
    }

    public void forWhileDoFirst(While that) {
        forExprDoFirst(that);
    }

    public void forForDoFirst(For that) {
        forExprDoFirst(that);
    }

    public void forBigOpAppDoFirst(BigOpApp that) {
        forExprDoFirst(that);
    }

    public void forAccumulatorDoFirst(Accumulator that) {
        forBigOpAppDoFirst(that);
    }

    public void forArrayComprehensionDoFirst(ArrayComprehension that) {
        forBigOpAppDoFirst(that);
    }

    public void forAtomicExprDoFirst(AtomicExpr that) {
        forExprDoFirst(that);
    }

    public void forExitDoFirst(Exit that) {
        forExprDoFirst(that);
    }

    public void forSpawnDoFirst(Spawn that) {
        forExprDoFirst(that);
    }

    public void forThrowDoFirst(Throw that) {
        forExprDoFirst(that);
    }

    public void forTryAtomicExprDoFirst(TryAtomicExpr that) {
        forExprDoFirst(that);
    }

    public void forFnExprDoFirst(FnExpr that) {
        forExprDoFirst(that);
    }

    public void forLetExprDoFirst(LetExpr that) {
        forExprDoFirst(that);
    }

    public void forLetFnDoFirst(LetFn that) {
        forLetExprDoFirst(that);
    }

    public void forLocalVarDeclDoFirst(LocalVarDecl that) {
        forLetExprDoFirst(that);
    }

    public void forSimpleExprDoFirst(SimpleExpr that) {
        forExprDoFirst(that);
    }

    public void forSubscriptExprDoFirst(SubscriptExpr that) {
        forSimpleExprDoFirst(that);
    }

    public void forPrimaryDoFirst(Primary that) {
        forSimpleExprDoFirst(that);
    }

    public void forLiteralExprDoFirst(LiteralExpr that) {
        forPrimaryDoFirst(that);
    }

    public void forNumberLiteralExprDoFirst(NumberLiteralExpr that) {
        forLiteralExprDoFirst(that);
    }

    public void forFloatLiteralExprDoFirst(FloatLiteralExpr that) {
        forNumberLiteralExprDoFirst(that);
    }

    public void forIntLiteralExprDoFirst(IntLiteralExpr that) {
        forNumberLiteralExprDoFirst(that);
    }

    public void forCharLiteralExprDoFirst(CharLiteralExpr that) {
        forLiteralExprDoFirst(that);
    }

    public void forStringLiteralExprDoFirst(StringLiteralExpr that) {
        forLiteralExprDoFirst(that);
    }

    public void forVoidLiteralExprDoFirst(VoidLiteralExpr that) {
        forLiteralExprDoFirst(that);
    }

    public void forBooleanLiteralExprDoFirst(BooleanLiteralExpr that) {
        forLiteralExprDoFirst(that);
    }

    public void forVarRefDoFirst(VarRef that) {
        forPrimaryDoFirst(that);
    }

    public void forFieldRefDoFirst(FieldRef that) {
        forPrimaryDoFirst(that);
    }

    public void forFunctionalRefDoFirst(FunctionalRef that) {
        forPrimaryDoFirst(that);
    }

    public void forFnRefDoFirst(FnRef that) {
        forFunctionalRefDoFirst(that);
    }

    public void forOpRefDoFirst(OpRef that) {
        forFunctionalRefDoFirst(that);
    }

    public void for_RewriteFnRefDoFirst(_RewriteFnRef that) {
        forPrimaryDoFirst(that);
    }

    public void for_RewriteObjectExprRefDoFirst(_RewriteObjectExprRef that) {
        forPrimaryDoFirst(that);
    }

    public void forJuxtDoFirst(Juxt that) {
        forPrimaryDoFirst(that);
    }

    public void for_RewriteFnAppDoFirst(_RewriteFnApp that) {
        forPrimaryDoFirst(that);
    }

    public void forOpExprDoFirst(OpExpr that) {
        forPrimaryDoFirst(that);
    }

    public void forAmbiguousMultifixOpExprDoFirst(AmbiguousMultifixOpExpr that) {
        forPrimaryDoFirst(that);
    }

    public void forChainExprDoFirst(ChainExpr that) {
        forPrimaryDoFirst(that);
    }

    public void forCoercionInvocationDoFirst(CoercionInvocation that) {
        forPrimaryDoFirst(that);
    }

    public void forTraitCoercionInvocationDoFirst(TraitCoercionInvocation that) {
        forCoercionInvocationDoFirst(that);
    }

    public void forTupleCoercionInvocationDoFirst(TupleCoercionInvocation that) {
        forCoercionInvocationDoFirst(that);
    }

    public void forArrowCoercionInvocationDoFirst(ArrowCoercionInvocation that) {
        forCoercionInvocationDoFirst(that);
    }

    public void forUnionCoercionInvocationDoFirst(UnionCoercionInvocation that) {
        forCoercionInvocationDoFirst(that);
    }

    public void forMethodInvocationDoFirst(MethodInvocation that) {
        forPrimaryDoFirst(that);
    }

    public void forMathPrimaryDoFirst(MathPrimary that) {
        forPrimaryDoFirst(that);
    }

    public void forArrayExprDoFirst(ArrayExpr that) {
        forPrimaryDoFirst(that);
    }

    public void forArrayElementDoFirst(ArrayElement that) {
        forArrayExprDoFirst(that);
    }

    public void forArrayElementsDoFirst(ArrayElements that) {
        forArrayExprDoFirst(that);
    }

    public void for_SyntaxTransformationExprDoFirst(_SyntaxTransformationExpr that) {
        forExprDoFirst(that);
    }

    public void for_SyntaxTransformationDummyExprDoFirst(_SyntaxTransformationDummyExpr that) {
        forDummyExprDoFirst(that);
    }

    public void for_SyntaxTransformationTypeAnnotatedExprDoFirst(_SyntaxTransformationTypeAnnotatedExpr that) {
        forTypeAnnotatedExprDoFirst(that);
    }

    public void for_SyntaxTransformationAsExprDoFirst(_SyntaxTransformationAsExpr that) {
        forAsExprDoFirst(that);
    }

    public void for_SyntaxTransformationAsIfExprDoFirst(_SyntaxTransformationAsIfExpr that) {
        forAsIfExprDoFirst(that);
    }

    public void for_SyntaxTransformationAssignmentDoFirst(_SyntaxTransformationAssignment that) {
        forAssignmentDoFirst(that);
    }

    public void for_SyntaxTransformationBlockDoFirst(_SyntaxTransformationBlock that) {
        forBlockDoFirst(that);
    }

    public void for_SyntaxTransformationDoDoFirst(_SyntaxTransformationDo that) {
        forDoDoFirst(that);
    }

    public void for_SyntaxTransformationCaseExprDoFirst(_SyntaxTransformationCaseExpr that) {
        forCaseExprDoFirst(that);
    }

    public void for_SyntaxTransformationIfDoFirst(_SyntaxTransformationIf that) {
        forIfDoFirst(that);
    }

    public void for_SyntaxTransformationLabelDoFirst(_SyntaxTransformationLabel that) {
        forLabelDoFirst(that);
    }

    public void for_SyntaxTransformationAbstractObjectExprDoFirst(_SyntaxTransformationAbstractObjectExpr that) {
        forAbstractObjectExprDoFirst(that);
    }

    public void for_SyntaxTransformationObjectExprDoFirst(_SyntaxTransformationObjectExpr that) {
        forObjectExprDoFirst(that);
    }

    public void for_SyntaxTransformation_RewriteObjectExprDoFirst(_SyntaxTransformation_RewriteObjectExpr that) {
        for_RewriteObjectExprDoFirst(that);
    }

    public void for_SyntaxTransformationTryDoFirst(_SyntaxTransformationTry that) {
        forTryDoFirst(that);
    }

    public void for_SyntaxTransformationTupleExprDoFirst(_SyntaxTransformationTupleExpr that) {
        forTupleExprDoFirst(that);
    }

    public void for_SyntaxTransformationTypecaseDoFirst(_SyntaxTransformationTypecase that) {
        forTypecaseDoFirst(that);
    }

    public void for_SyntaxTransformationWhileDoFirst(_SyntaxTransformationWhile that) {
        forWhileDoFirst(that);
    }

    public void for_SyntaxTransformationForDoFirst(_SyntaxTransformationFor that) {
        forForDoFirst(that);
    }

    public void for_SyntaxTransformationBigOpAppDoFirst(_SyntaxTransformationBigOpApp that) {
        forBigOpAppDoFirst(that);
    }

    public void for_SyntaxTransformationAccumulatorDoFirst(_SyntaxTransformationAccumulator that) {
        forAccumulatorDoFirst(that);
    }

    public void for_SyntaxTransformationArrayComprehensionDoFirst(_SyntaxTransformationArrayComprehension that) {
        forArrayComprehensionDoFirst(that);
    }

    public void for_SyntaxTransformationAtomicExprDoFirst(_SyntaxTransformationAtomicExpr that) {
        forAtomicExprDoFirst(that);
    }

    public void for_SyntaxTransformationExitDoFirst(_SyntaxTransformationExit that) {
        forExitDoFirst(that);
    }

    public void for_SyntaxTransformationSpawnDoFirst(_SyntaxTransformationSpawn that) {
        forSpawnDoFirst(that);
    }

    public void for_SyntaxTransformationThrowDoFirst(_SyntaxTransformationThrow that) {
        forThrowDoFirst(that);
    }

    public void for_SyntaxTransformationTryAtomicExprDoFirst(_SyntaxTransformationTryAtomicExpr that) {
        forTryAtomicExprDoFirst(that);
    }

    public void for_SyntaxTransformationFnExprDoFirst(_SyntaxTransformationFnExpr that) {
        forFnExprDoFirst(that);
    }

    public void for_SyntaxTransformationLetExprDoFirst(_SyntaxTransformationLetExpr that) {
        forLetExprDoFirst(that);
    }

    public void for_SyntaxTransformationLetFnDoFirst(_SyntaxTransformationLetFn that) {
        forLetFnDoFirst(that);
    }

    public void for_SyntaxTransformationLocalVarDeclDoFirst(_SyntaxTransformationLocalVarDecl that) {
        forLocalVarDeclDoFirst(that);
    }

    public void for_SyntaxTransformationSimpleExprDoFirst(_SyntaxTransformationSimpleExpr that) {
        forSimpleExprDoFirst(that);
    }

    public void for_SyntaxTransformationSubscriptExprDoFirst(_SyntaxTransformationSubscriptExpr that) {
        forSubscriptExprDoFirst(that);
    }

    public void for_SyntaxTransformationPrimaryDoFirst(_SyntaxTransformationPrimary that) {
        forPrimaryDoFirst(that);
    }

    public void for_SyntaxTransformationLiteralExprDoFirst(_SyntaxTransformationLiteralExpr that) {
        forLiteralExprDoFirst(that);
    }

    public void for_SyntaxTransformationNumberLiteralExprDoFirst(_SyntaxTransformationNumberLiteralExpr that) {
        forNumberLiteralExprDoFirst(that);
    }

    public void for_SyntaxTransformationFloatLiteralExprDoFirst(_SyntaxTransformationFloatLiteralExpr that) {
        forFloatLiteralExprDoFirst(that);
    }

    public void for_SyntaxTransformationIntLiteralExprDoFirst(_SyntaxTransformationIntLiteralExpr that) {
        forIntLiteralExprDoFirst(that);
    }

    public void for_SyntaxTransformationCharLiteralExprDoFirst(_SyntaxTransformationCharLiteralExpr that) {
        forCharLiteralExprDoFirst(that);
    }

    public void for_SyntaxTransformationStringLiteralExprDoFirst(_SyntaxTransformationStringLiteralExpr that) {
        forStringLiteralExprDoFirst(that);
    }

    public void for_SyntaxTransformationVoidLiteralExprDoFirst(_SyntaxTransformationVoidLiteralExpr that) {
        forVoidLiteralExprDoFirst(that);
    }

    public void for_SyntaxTransformationBooleanLiteralExprDoFirst(_SyntaxTransformationBooleanLiteralExpr that) {
        forBooleanLiteralExprDoFirst(that);
    }

    public void for_SyntaxTransformationVarRefDoFirst(_SyntaxTransformationVarRef that) {
        forVarRefDoFirst(that);
    }

    public void for_SyntaxTransformationFieldRefDoFirst(_SyntaxTransformationFieldRef that) {
        forFieldRefDoFirst(that);
    }

    public void for_SyntaxTransformationFunctionalRefDoFirst(_SyntaxTransformationFunctionalRef that) {
        forFunctionalRefDoFirst(that);
    }

    public void for_SyntaxTransformationFnRefDoFirst(_SyntaxTransformationFnRef that) {
        forFnRefDoFirst(that);
    }

    public void for_SyntaxTransformationOpRefDoFirst(_SyntaxTransformationOpRef that) {
        forOpRefDoFirst(that);
    }

    public void for_SyntaxTransformation_RewriteFnRefDoFirst(_SyntaxTransformation_RewriteFnRef that) {
        for_RewriteFnRefDoFirst(that);
    }

    public void for_SyntaxTransformation_RewriteObjectExprRefDoFirst(_SyntaxTransformation_RewriteObjectExprRef that) {
        for_RewriteObjectExprRefDoFirst(that);
    }

    public void for_SyntaxTransformationJuxtDoFirst(_SyntaxTransformationJuxt that) {
        forJuxtDoFirst(that);
    }

    public void for_SyntaxTransformation_RewriteFnAppDoFirst(_SyntaxTransformation_RewriteFnApp that) {
        for_RewriteFnAppDoFirst(that);
    }

    public void for_SyntaxTransformationOpExprDoFirst(_SyntaxTransformationOpExpr that) {
        forOpExprDoFirst(that);
    }

    public void for_SyntaxTransformationAmbiguousMultifixOpExprDoFirst(_SyntaxTransformationAmbiguousMultifixOpExpr that) {
        forAmbiguousMultifixOpExprDoFirst(that);
    }

    public void for_SyntaxTransformationChainExprDoFirst(_SyntaxTransformationChainExpr that) {
        forChainExprDoFirst(that);
    }

    public void for_SyntaxTransformationCoercionInvocationDoFirst(_SyntaxTransformationCoercionInvocation that) {
        forCoercionInvocationDoFirst(that);
    }

    public void for_SyntaxTransformationTraitCoercionInvocationDoFirst(_SyntaxTransformationTraitCoercionInvocation that) {
        forTraitCoercionInvocationDoFirst(that);
    }

    public void for_SyntaxTransformationTupleCoercionInvocationDoFirst(_SyntaxTransformationTupleCoercionInvocation that) {
        forTupleCoercionInvocationDoFirst(that);
    }

    public void for_SyntaxTransformationArrowCoercionInvocationDoFirst(_SyntaxTransformationArrowCoercionInvocation that) {
        forArrowCoercionInvocationDoFirst(that);
    }

    public void for_SyntaxTransformationUnionCoercionInvocationDoFirst(_SyntaxTransformationUnionCoercionInvocation that) {
        forUnionCoercionInvocationDoFirst(that);
    }

    public void for_SyntaxTransformationMethodInvocationDoFirst(_SyntaxTransformationMethodInvocation that) {
        forMethodInvocationDoFirst(that);
    }

    public void for_SyntaxTransformationMathPrimaryDoFirst(_SyntaxTransformationMathPrimary that) {
        forMathPrimaryDoFirst(that);
    }

    public void for_SyntaxTransformationArrayExprDoFirst(_SyntaxTransformationArrayExpr that) {
        forArrayExprDoFirst(that);
    }

    public void for_SyntaxTransformationArrayElementDoFirst(_SyntaxTransformationArrayElement that) {
        forArrayElementDoFirst(that);
    }

    public void for_SyntaxTransformationArrayElementsDoFirst(_SyntaxTransformationArrayElements that) {
        forArrayElementsDoFirst(that);
    }

    public void for_EllipsesExprDoFirst(_EllipsesExpr that) {
        forExprDoFirst(that);
    }

    public void for_EllipsesDummyExprDoFirst(_EllipsesDummyExpr that) {
        forDummyExprDoFirst(that);
    }

    public void for_EllipsesTypeAnnotatedExprDoFirst(_EllipsesTypeAnnotatedExpr that) {
        forTypeAnnotatedExprDoFirst(that);
    }

    public void for_EllipsesAsExprDoFirst(_EllipsesAsExpr that) {
        forAsExprDoFirst(that);
    }

    public void for_EllipsesAsIfExprDoFirst(_EllipsesAsIfExpr that) {
        forAsIfExprDoFirst(that);
    }

    public void for_EllipsesAssignmentDoFirst(_EllipsesAssignment that) {
        forAssignmentDoFirst(that);
    }

    public void for_EllipsesBlockDoFirst(_EllipsesBlock that) {
        forBlockDoFirst(that);
    }

    public void for_EllipsesDoDoFirst(_EllipsesDo that) {
        forDoDoFirst(that);
    }

    public void for_EllipsesCaseExprDoFirst(_EllipsesCaseExpr that) {
        forCaseExprDoFirst(that);
    }

    public void for_EllipsesIfDoFirst(_EllipsesIf that) {
        forIfDoFirst(that);
    }

    public void for_EllipsesLabelDoFirst(_EllipsesLabel that) {
        forLabelDoFirst(that);
    }

    public void for_EllipsesAbstractObjectExprDoFirst(_EllipsesAbstractObjectExpr that) {
        forAbstractObjectExprDoFirst(that);
    }

    public void for_EllipsesObjectExprDoFirst(_EllipsesObjectExpr that) {
        forObjectExprDoFirst(that);
    }

    public void for_Ellipses_RewriteObjectExprDoFirst(_Ellipses_RewriteObjectExpr that) {
        for_RewriteObjectExprDoFirst(that);
    }

    public void for_EllipsesTryDoFirst(_EllipsesTry that) {
        forTryDoFirst(that);
    }

    public void for_EllipsesTupleExprDoFirst(_EllipsesTupleExpr that) {
        forTupleExprDoFirst(that);
    }

    public void for_EllipsesTypecaseDoFirst(_EllipsesTypecase that) {
        forTypecaseDoFirst(that);
    }

    public void for_EllipsesWhileDoFirst(_EllipsesWhile that) {
        forWhileDoFirst(that);
    }

    public void for_EllipsesForDoFirst(_EllipsesFor that) {
        forForDoFirst(that);
    }

    public void for_EllipsesBigOpAppDoFirst(_EllipsesBigOpApp that) {
        forBigOpAppDoFirst(that);
    }

    public void for_EllipsesAccumulatorDoFirst(_EllipsesAccumulator that) {
        forAccumulatorDoFirst(that);
    }

    public void for_EllipsesArrayComprehensionDoFirst(_EllipsesArrayComprehension that) {
        forArrayComprehensionDoFirst(that);
    }

    public void for_EllipsesAtomicExprDoFirst(_EllipsesAtomicExpr that) {
        forAtomicExprDoFirst(that);
    }

    public void for_EllipsesExitDoFirst(_EllipsesExit that) {
        forExitDoFirst(that);
    }

    public void for_EllipsesSpawnDoFirst(_EllipsesSpawn that) {
        forSpawnDoFirst(that);
    }

    public void for_EllipsesThrowDoFirst(_EllipsesThrow that) {
        forThrowDoFirst(that);
    }

    public void for_EllipsesTryAtomicExprDoFirst(_EllipsesTryAtomicExpr that) {
        forTryAtomicExprDoFirst(that);
    }

    public void for_EllipsesFnExprDoFirst(_EllipsesFnExpr that) {
        forFnExprDoFirst(that);
    }

    public void for_EllipsesLetExprDoFirst(_EllipsesLetExpr that) {
        forLetExprDoFirst(that);
    }

    public void for_EllipsesLetFnDoFirst(_EllipsesLetFn that) {
        forLetFnDoFirst(that);
    }

    public void for_EllipsesLocalVarDeclDoFirst(_EllipsesLocalVarDecl that) {
        forLocalVarDeclDoFirst(that);
    }

    public void for_EllipsesSimpleExprDoFirst(_EllipsesSimpleExpr that) {
        forSimpleExprDoFirst(that);
    }

    public void for_EllipsesSubscriptExprDoFirst(_EllipsesSubscriptExpr that) {
        forSubscriptExprDoFirst(that);
    }

    public void for_EllipsesPrimaryDoFirst(_EllipsesPrimary that) {
        forPrimaryDoFirst(that);
    }

    public void for_EllipsesLiteralExprDoFirst(_EllipsesLiteralExpr that) {
        forLiteralExprDoFirst(that);
    }

    public void for_EllipsesNumberLiteralExprDoFirst(_EllipsesNumberLiteralExpr that) {
        forNumberLiteralExprDoFirst(that);
    }

    public void for_EllipsesFloatLiteralExprDoFirst(_EllipsesFloatLiteralExpr that) {
        forFloatLiteralExprDoFirst(that);
    }

    public void for_EllipsesIntLiteralExprDoFirst(_EllipsesIntLiteralExpr that) {
        forIntLiteralExprDoFirst(that);
    }

    public void for_EllipsesCharLiteralExprDoFirst(_EllipsesCharLiteralExpr that) {
        forCharLiteralExprDoFirst(that);
    }

    public void for_EllipsesStringLiteralExprDoFirst(_EllipsesStringLiteralExpr that) {
        forStringLiteralExprDoFirst(that);
    }

    public void for_EllipsesVoidLiteralExprDoFirst(_EllipsesVoidLiteralExpr that) {
        forVoidLiteralExprDoFirst(that);
    }

    public void for_EllipsesBooleanLiteralExprDoFirst(_EllipsesBooleanLiteralExpr that) {
        forBooleanLiteralExprDoFirst(that);
    }

    public void for_EllipsesVarRefDoFirst(_EllipsesVarRef that) {
        forVarRefDoFirst(that);
    }

    public void for_EllipsesFieldRefDoFirst(_EllipsesFieldRef that) {
        forFieldRefDoFirst(that);
    }

    public void for_EllipsesFunctionalRefDoFirst(_EllipsesFunctionalRef that) {
        forFunctionalRefDoFirst(that);
    }

    public void for_EllipsesFnRefDoFirst(_EllipsesFnRef that) {
        forFnRefDoFirst(that);
    }

    public void for_EllipsesOpRefDoFirst(_EllipsesOpRef that) {
        forOpRefDoFirst(that);
    }

    public void for_Ellipses_RewriteFnRefDoFirst(_Ellipses_RewriteFnRef that) {
        for_RewriteFnRefDoFirst(that);
    }

    public void for_Ellipses_RewriteObjectExprRefDoFirst(_Ellipses_RewriteObjectExprRef that) {
        for_RewriteObjectExprRefDoFirst(that);
    }

    public void for_EllipsesJuxtDoFirst(_EllipsesJuxt that) {
        forJuxtDoFirst(that);
    }

    public void for_Ellipses_RewriteFnAppDoFirst(_Ellipses_RewriteFnApp that) {
        for_RewriteFnAppDoFirst(that);
    }

    public void for_EllipsesOpExprDoFirst(_EllipsesOpExpr that) {
        forOpExprDoFirst(that);
    }

    public void for_EllipsesAmbiguousMultifixOpExprDoFirst(_EllipsesAmbiguousMultifixOpExpr that) {
        forAmbiguousMultifixOpExprDoFirst(that);
    }

    public void for_EllipsesChainExprDoFirst(_EllipsesChainExpr that) {
        forChainExprDoFirst(that);
    }

    public void for_EllipsesCoercionInvocationDoFirst(_EllipsesCoercionInvocation that) {
        forCoercionInvocationDoFirst(that);
    }

    public void for_EllipsesTraitCoercionInvocationDoFirst(_EllipsesTraitCoercionInvocation that) {
        forTraitCoercionInvocationDoFirst(that);
    }

    public void for_EllipsesTupleCoercionInvocationDoFirst(_EllipsesTupleCoercionInvocation that) {
        forTupleCoercionInvocationDoFirst(that);
    }

    public void for_EllipsesArrowCoercionInvocationDoFirst(_EllipsesArrowCoercionInvocation that) {
        forArrowCoercionInvocationDoFirst(that);
    }

    public void for_EllipsesUnionCoercionInvocationDoFirst(_EllipsesUnionCoercionInvocation that) {
        forUnionCoercionInvocationDoFirst(that);
    }

    public void for_EllipsesMethodInvocationDoFirst(_EllipsesMethodInvocation that) {
        forMethodInvocationDoFirst(that);
    }

    public void for_EllipsesMathPrimaryDoFirst(_EllipsesMathPrimary that) {
        forMathPrimaryDoFirst(that);
    }

    public void for_EllipsesArrayExprDoFirst(_EllipsesArrayExpr that) {
        forArrayExprDoFirst(that);
    }

    public void for_EllipsesArrayElementDoFirst(_EllipsesArrayElement that) {
        forArrayElementDoFirst(that);
    }

    public void for_EllipsesArrayElementsDoFirst(_EllipsesArrayElements that) {
        forArrayElementsDoFirst(that);
    }

    public void forTemplateGapExprDoFirst(TemplateGapExpr that) {
        forExprDoFirst(that);
    }

    public void forTemplateGapDummyExprDoFirst(TemplateGapDummyExpr that) {
        forDummyExprDoFirst(that);
    }

    public void forTemplateGapTypeAnnotatedExprDoFirst(TemplateGapTypeAnnotatedExpr that) {
        forTypeAnnotatedExprDoFirst(that);
    }

    public void forTemplateGapAsExprDoFirst(TemplateGapAsExpr that) {
        forAsExprDoFirst(that);
    }

    public void forTemplateGapAsIfExprDoFirst(TemplateGapAsIfExpr that) {
        forAsIfExprDoFirst(that);
    }

    public void forTemplateGapAssignmentDoFirst(TemplateGapAssignment that) {
        forAssignmentDoFirst(that);
    }

    public void forTemplateGapBlockDoFirst(TemplateGapBlock that) {
        forBlockDoFirst(that);
    }

    public void forTemplateGapDoDoFirst(TemplateGapDo that) {
        forDoDoFirst(that);
    }

    public void forTemplateGapCaseExprDoFirst(TemplateGapCaseExpr that) {
        forCaseExprDoFirst(that);
    }

    public void forTemplateGapIfDoFirst(TemplateGapIf that) {
        forIfDoFirst(that);
    }

    public void forTemplateGapLabelDoFirst(TemplateGapLabel that) {
        forLabelDoFirst(that);
    }

    public void forTemplateGapAbstractObjectExprDoFirst(TemplateGapAbstractObjectExpr that) {
        forAbstractObjectExprDoFirst(that);
    }

    public void forTemplateGapObjectExprDoFirst(TemplateGapObjectExpr that) {
        forObjectExprDoFirst(that);
    }

    public void forTemplateGap_RewriteObjectExprDoFirst(TemplateGap_RewriteObjectExpr that) {
        for_RewriteObjectExprDoFirst(that);
    }

    public void forTemplateGapTryDoFirst(TemplateGapTry that) {
        forTryDoFirst(that);
    }

    public void forTemplateGapTupleExprDoFirst(TemplateGapTupleExpr that) {
        forTupleExprDoFirst(that);
    }

    public void forTemplateGapTypecaseDoFirst(TemplateGapTypecase that) {
        forTypecaseDoFirst(that);
    }

    public void forTemplateGapWhileDoFirst(TemplateGapWhile that) {
        forWhileDoFirst(that);
    }

    public void forTemplateGapForDoFirst(TemplateGapFor that) {
        forForDoFirst(that);
    }

    public void forTemplateGapBigOpAppDoFirst(TemplateGapBigOpApp that) {
        forBigOpAppDoFirst(that);
    }

    public void forTemplateGapAccumulatorDoFirst(TemplateGapAccumulator that) {
        forAccumulatorDoFirst(that);
    }

    public void forTemplateGapArrayComprehensionDoFirst(TemplateGapArrayComprehension that) {
        forArrayComprehensionDoFirst(that);
    }

    public void forTemplateGapAtomicExprDoFirst(TemplateGapAtomicExpr that) {
        forAtomicExprDoFirst(that);
    }

    public void forTemplateGapExitDoFirst(TemplateGapExit that) {
        forExitDoFirst(that);
    }

    public void forTemplateGapSpawnDoFirst(TemplateGapSpawn that) {
        forSpawnDoFirst(that);
    }

    public void forTemplateGapThrowDoFirst(TemplateGapThrow that) {
        forThrowDoFirst(that);
    }

    public void forTemplateGapTryAtomicExprDoFirst(TemplateGapTryAtomicExpr that) {
        forTryAtomicExprDoFirst(that);
    }

    public void forTemplateGapFnExprDoFirst(TemplateGapFnExpr that) {
        forFnExprDoFirst(that);
    }

    public void forTemplateGapLetExprDoFirst(TemplateGapLetExpr that) {
        forLetExprDoFirst(that);
    }

    public void forTemplateGapLetFnDoFirst(TemplateGapLetFn that) {
        forLetFnDoFirst(that);
    }

    public void forTemplateGapLocalVarDeclDoFirst(TemplateGapLocalVarDecl that) {
        forLocalVarDeclDoFirst(that);
    }

    public void forTemplateGapSimpleExprDoFirst(TemplateGapSimpleExpr that) {
        forSimpleExprDoFirst(that);
    }

    public void forTemplateGapSubscriptExprDoFirst(TemplateGapSubscriptExpr that) {
        forSubscriptExprDoFirst(that);
    }

    public void forTemplateGapPrimaryDoFirst(TemplateGapPrimary that) {
        forPrimaryDoFirst(that);
    }

    public void forTemplateGapLiteralExprDoFirst(TemplateGapLiteralExpr that) {
        forLiteralExprDoFirst(that);
    }

    public void forTemplateGapNumberLiteralExprDoFirst(TemplateGapNumberLiteralExpr that) {
        forNumberLiteralExprDoFirst(that);
    }

    public void forTemplateGapFloatLiteralExprDoFirst(TemplateGapFloatLiteralExpr that) {
        forFloatLiteralExprDoFirst(that);
    }

    public void forTemplateGapIntLiteralExprDoFirst(TemplateGapIntLiteralExpr that) {
        forIntLiteralExprDoFirst(that);
    }

    public void forTemplateGapCharLiteralExprDoFirst(TemplateGapCharLiteralExpr that) {
        forCharLiteralExprDoFirst(that);
    }

    public void forTemplateGapStringLiteralExprDoFirst(TemplateGapStringLiteralExpr that) {
        forStringLiteralExprDoFirst(that);
    }

    public void forTemplateGapVoidLiteralExprDoFirst(TemplateGapVoidLiteralExpr that) {
        forVoidLiteralExprDoFirst(that);
    }

    public void forTemplateGapBooleanLiteralExprDoFirst(TemplateGapBooleanLiteralExpr that) {
        forBooleanLiteralExprDoFirst(that);
    }

    public void forTemplateGapVarRefDoFirst(TemplateGapVarRef that) {
        forVarRefDoFirst(that);
    }

    public void forTemplateGapFieldRefDoFirst(TemplateGapFieldRef that) {
        forFieldRefDoFirst(that);
    }

    public void forTemplateGapFunctionalRefDoFirst(TemplateGapFunctionalRef that) {
        forFunctionalRefDoFirst(that);
    }

    public void forTemplateGapFnRefDoFirst(TemplateGapFnRef that) {
        forFnRefDoFirst(that);
    }

    public void forTemplateGapOpRefDoFirst(TemplateGapOpRef that) {
        forOpRefDoFirst(that);
    }

    public void forTemplateGap_RewriteFnRefDoFirst(TemplateGap_RewriteFnRef that) {
        for_RewriteFnRefDoFirst(that);
    }

    public void forTemplateGap_RewriteObjectExprRefDoFirst(TemplateGap_RewriteObjectExprRef that) {
        for_RewriteObjectExprRefDoFirst(that);
    }

    public void forTemplateGapJuxtDoFirst(TemplateGapJuxt that) {
        forJuxtDoFirst(that);
    }

    public void forTemplateGap_RewriteFnAppDoFirst(TemplateGap_RewriteFnApp that) {
        for_RewriteFnAppDoFirst(that);
    }

    public void forTemplateGapOpExprDoFirst(TemplateGapOpExpr that) {
        forOpExprDoFirst(that);
    }

    public void forTemplateGapAmbiguousMultifixOpExprDoFirst(TemplateGapAmbiguousMultifixOpExpr that) {
        forAmbiguousMultifixOpExprDoFirst(that);
    }

    public void forTemplateGapChainExprDoFirst(TemplateGapChainExpr that) {
        forChainExprDoFirst(that);
    }

    public void forTemplateGapCoercionInvocationDoFirst(TemplateGapCoercionInvocation that) {
        forCoercionInvocationDoFirst(that);
    }

    public void forTemplateGapTraitCoercionInvocationDoFirst(TemplateGapTraitCoercionInvocation that) {
        forTraitCoercionInvocationDoFirst(that);
    }

    public void forTemplateGapTupleCoercionInvocationDoFirst(TemplateGapTupleCoercionInvocation that) {
        forTupleCoercionInvocationDoFirst(that);
    }

    public void forTemplateGapArrowCoercionInvocationDoFirst(TemplateGapArrowCoercionInvocation that) {
        forArrowCoercionInvocationDoFirst(that);
    }

    public void forTemplateGapUnionCoercionInvocationDoFirst(TemplateGapUnionCoercionInvocation that) {
        forUnionCoercionInvocationDoFirst(that);
    }

    public void forTemplateGapMethodInvocationDoFirst(TemplateGapMethodInvocation that) {
        forMethodInvocationDoFirst(that);
    }

    public void forTemplateGapMathPrimaryDoFirst(TemplateGapMathPrimary that) {
        forMathPrimaryDoFirst(that);
    }

    public void forTemplateGapArrayExprDoFirst(TemplateGapArrayExpr that) {
        forArrayExprDoFirst(that);
    }

    public void forTemplateGapArrayElementDoFirst(TemplateGapArrayElement that) {
        forArrayElementDoFirst(that);
    }

    public void forTemplateGapArrayElementsDoFirst(TemplateGapArrayElements that) {
        forArrayElementsDoFirst(that);
    }

    /* Methods to handle a node after recursion. */
    public void forExprOnly(Expr that) {
        defaultCase(that);
    }

    public void forDummyExprOnly(DummyExpr that) {
        forExprOnly(that);
    }

    public void forTypeAnnotatedExprOnly(TypeAnnotatedExpr that) {
        forExprOnly(that);
    }

    public void forAsExprOnly(AsExpr that) {
        forTypeAnnotatedExprOnly(that);
    }

    public void forAsIfExprOnly(AsIfExpr that) {
        forTypeAnnotatedExprOnly(that);
    }

    public void forAssignmentOnly(Assignment that) {
        forExprOnly(that);
    }

    public void forBlockOnly(Block that) {
        forExprOnly(that);
    }

    public void forDoOnly(Do that) {
        forExprOnly(that);
    }

    public void forCaseExprOnly(CaseExpr that) {
        forExprOnly(that);
    }

    public void forIfOnly(If that) {
        forExprOnly(that);
    }

    public void forLabelOnly(Label that) {
        forExprOnly(that);
    }

    public void forAbstractObjectExprOnly(AbstractObjectExpr that) {
        forExprOnly(that);
    }

    public void forObjectExprOnly(ObjectExpr that) {
        forAbstractObjectExprOnly(that);
    }

    public void for_RewriteObjectExprOnly(_RewriteObjectExpr that) {
        forAbstractObjectExprOnly(that);
    }

    public void forTryOnly(Try that) {
        forExprOnly(that);
    }

    public void forTupleExprOnly(TupleExpr that) {
        forExprOnly(that);
    }

    public void forTypecaseOnly(Typecase that) {
        forExprOnly(that);
    }

    public void forWhileOnly(While that) {
        forExprOnly(that);
    }

    public void forForOnly(For that) {
        forExprOnly(that);
    }

    public void forBigOpAppOnly(BigOpApp that) {
        forExprOnly(that);
    }

    public void forAccumulatorOnly(Accumulator that) {
        forBigOpAppOnly(that);
    }

    public void forArrayComprehensionOnly(ArrayComprehension that) {
        forBigOpAppOnly(that);
    }

    public void forAtomicExprOnly(AtomicExpr that) {
        forExprOnly(that);
    }

    public void forExitOnly(Exit that) {
        forExprOnly(that);
    }

    public void forSpawnOnly(Spawn that) {
        forExprOnly(that);
    }

    public void forThrowOnly(Throw that) {
        forExprOnly(that);
    }

    public void forTryAtomicExprOnly(TryAtomicExpr that) {
        forExprOnly(that);
    }

    public void forFnExprOnly(FnExpr that) {
        forExprOnly(that);
    }

    public void forLetExprOnly(LetExpr that) {
        forExprOnly(that);
    }

    public void forLetFnOnly(LetFn that) {
        forLetExprOnly(that);
    }

    public void forLocalVarDeclOnly(LocalVarDecl that) {
        forLetExprOnly(that);
    }

    public void forSimpleExprOnly(SimpleExpr that) {
        forExprOnly(that);
    }

    public void forSubscriptExprOnly(SubscriptExpr that) {
        forSimpleExprOnly(that);
    }

    public void forPrimaryOnly(Primary that) {
        forSimpleExprOnly(that);
    }

    public void forLiteralExprOnly(LiteralExpr that) {
        forPrimaryOnly(that);
    }

    public void forNumberLiteralExprOnly(NumberLiteralExpr that) {
        forLiteralExprOnly(that);
    }

    public void forFloatLiteralExprOnly(FloatLiteralExpr that) {
        forNumberLiteralExprOnly(that);
    }

    public void forIntLiteralExprOnly(IntLiteralExpr that) {
        forNumberLiteralExprOnly(that);
    }

    public void forCharLiteralExprOnly(CharLiteralExpr that) {
        forLiteralExprOnly(that);
    }

    public void forStringLiteralExprOnly(StringLiteralExpr that) {
        forLiteralExprOnly(that);
    }

    public void forVoidLiteralExprOnly(VoidLiteralExpr that) {
        forLiteralExprOnly(that);
    }

    public void forBooleanLiteralExprOnly(BooleanLiteralExpr that) {
        forLiteralExprOnly(that);
    }

    public void forVarRefOnly(VarRef that) {
        forPrimaryOnly(that);
    }

    public void forFieldRefOnly(FieldRef that) {
        forPrimaryOnly(that);
    }

    public void forFunctionalRefOnly(FunctionalRef that) {
        forPrimaryOnly(that);
    }

    public void forFnRefOnly(FnRef that) {
        forFunctionalRefOnly(that);
    }

    public void forOpRefOnly(OpRef that) {
        forFunctionalRefOnly(that);
    }

    public void for_RewriteFnRefOnly(_RewriteFnRef that) {
        forPrimaryOnly(that);
    }

    public void for_RewriteObjectExprRefOnly(_RewriteObjectExprRef that) {
        forPrimaryOnly(that);
    }

    public void forJuxtOnly(Juxt that) {
        forPrimaryOnly(that);
    }

    public void for_RewriteFnAppOnly(_RewriteFnApp that) {
        forPrimaryOnly(that);
    }

    public void forOpExprOnly(OpExpr that) {
        forPrimaryOnly(that);
    }

    public void forAmbiguousMultifixOpExprOnly(AmbiguousMultifixOpExpr that) {
        forPrimaryOnly(that);
    }

    public void forChainExprOnly(ChainExpr that) {
        forPrimaryOnly(that);
    }

    public void forCoercionInvocationOnly(CoercionInvocation that) {
        forPrimaryOnly(that);
    }

    public void forTraitCoercionInvocationOnly(TraitCoercionInvocation that) {
        forCoercionInvocationOnly(that);
    }

    public void forTupleCoercionInvocationOnly(TupleCoercionInvocation that) {
        forCoercionInvocationOnly(that);
    }

    public void forArrowCoercionInvocationOnly(ArrowCoercionInvocation that) {
        forCoercionInvocationOnly(that);
    }

    public void forUnionCoercionInvocationOnly(UnionCoercionInvocation that) {
        forCoercionInvocationOnly(that);
    }

    public void forMethodInvocationOnly(MethodInvocation that) {
        forPrimaryOnly(that);
    }

    public void forMathPrimaryOnly(MathPrimary that) {
        forPrimaryOnly(that);
    }

    public void forArrayExprOnly(ArrayExpr that) {
        forPrimaryOnly(that);
    }

    public void forArrayElementOnly(ArrayElement that) {
        forArrayExprOnly(that);
    }

    public void forArrayElementsOnly(ArrayElements that) {
        forArrayExprOnly(that);
    }

    public void for_SyntaxTransformationExprOnly(_SyntaxTransformationExpr that) {
        forExprOnly(that);
    }

    public void for_SyntaxTransformationDummyExprOnly(_SyntaxTransformationDummyExpr that) {
        forDummyExprOnly(that);
    }

    public void for_SyntaxTransformationTypeAnnotatedExprOnly(_SyntaxTransformationTypeAnnotatedExpr that) {
        forTypeAnnotatedExprOnly(that);
    }

    public void for_SyntaxTransformationAsExprOnly(_SyntaxTransformationAsExpr that) {
        forAsExprOnly(that);
    }

    public void for_SyntaxTransformationAsIfExprOnly(_SyntaxTransformationAsIfExpr that) {
        forAsIfExprOnly(that);
    }

    public void for_SyntaxTransformationAssignmentOnly(_SyntaxTransformationAssignment that) {
        forAssignmentOnly(that);
    }

    public void for_SyntaxTransformationBlockOnly(_SyntaxTransformationBlock that) {
        forBlockOnly(that);
    }

    public void for_SyntaxTransformationDoOnly(_SyntaxTransformationDo that) {
        forDoOnly(that);
    }

    public void for_SyntaxTransformationCaseExprOnly(_SyntaxTransformationCaseExpr that) {
        forCaseExprOnly(that);
    }

    public void for_SyntaxTransformationIfOnly(_SyntaxTransformationIf that) {
        forIfOnly(that);
    }

    public void for_SyntaxTransformationLabelOnly(_SyntaxTransformationLabel that) {
        forLabelOnly(that);
    }

    public void for_SyntaxTransformationAbstractObjectExprOnly(_SyntaxTransformationAbstractObjectExpr that) {
        forAbstractObjectExprOnly(that);
    }

    public void for_SyntaxTransformationObjectExprOnly(_SyntaxTransformationObjectExpr that) {
        forObjectExprOnly(that);
    }

    public void for_SyntaxTransformation_RewriteObjectExprOnly(_SyntaxTransformation_RewriteObjectExpr that) {
        for_RewriteObjectExprOnly(that);
    }

    public void for_SyntaxTransformationTryOnly(_SyntaxTransformationTry that) {
        forTryOnly(that);
    }

    public void for_SyntaxTransformationTupleExprOnly(_SyntaxTransformationTupleExpr that) {
        forTupleExprOnly(that);
    }

    public void for_SyntaxTransformationTypecaseOnly(_SyntaxTransformationTypecase that) {
        forTypecaseOnly(that);
    }

    public void for_SyntaxTransformationWhileOnly(_SyntaxTransformationWhile that) {
        forWhileOnly(that);
    }

    public void for_SyntaxTransformationForOnly(_SyntaxTransformationFor that) {
        forForOnly(that);
    }

    public void for_SyntaxTransformationBigOpAppOnly(_SyntaxTransformationBigOpApp that) {
        forBigOpAppOnly(that);
    }

    public void for_SyntaxTransformationAccumulatorOnly(_SyntaxTransformationAccumulator that) {
        forAccumulatorOnly(that);
    }

    public void for_SyntaxTransformationArrayComprehensionOnly(_SyntaxTransformationArrayComprehension that) {
        forArrayComprehensionOnly(that);
    }

    public void for_SyntaxTransformationAtomicExprOnly(_SyntaxTransformationAtomicExpr that) {
        forAtomicExprOnly(that);
    }

    public void for_SyntaxTransformationExitOnly(_SyntaxTransformationExit that) {
        forExitOnly(that);
    }

    public void for_SyntaxTransformationSpawnOnly(_SyntaxTransformationSpawn that) {
        forSpawnOnly(that);
    }

    public void for_SyntaxTransformationThrowOnly(_SyntaxTransformationThrow that) {
        forThrowOnly(that);
    }

    public void for_SyntaxTransformationTryAtomicExprOnly(_SyntaxTransformationTryAtomicExpr that) {
        forTryAtomicExprOnly(that);
    }

    public void for_SyntaxTransformationFnExprOnly(_SyntaxTransformationFnExpr that) {
        forFnExprOnly(that);
    }

    public void for_SyntaxTransformationLetExprOnly(_SyntaxTransformationLetExpr that) {
        forLetExprOnly(that);
    }

    public void for_SyntaxTransformationLetFnOnly(_SyntaxTransformationLetFn that) {
        forLetFnOnly(that);
    }

    public void for_SyntaxTransformationLocalVarDeclOnly(_SyntaxTransformationLocalVarDecl that) {
        forLocalVarDeclOnly(that);
    }

    public void for_SyntaxTransformationSimpleExprOnly(_SyntaxTransformationSimpleExpr that) {
        forSimpleExprOnly(that);
    }

    public void for_SyntaxTransformationSubscriptExprOnly(_SyntaxTransformationSubscriptExpr that) {
        forSubscriptExprOnly(that);
    }

    public void for_SyntaxTransformationPrimaryOnly(_SyntaxTransformationPrimary that) {
        forPrimaryOnly(that);
    }

    public void for_SyntaxTransformationLiteralExprOnly(_SyntaxTransformationLiteralExpr that) {
        forLiteralExprOnly(that);
    }

    public void for_SyntaxTransformationNumberLiteralExprOnly(_SyntaxTransformationNumberLiteralExpr that) {
        forNumberLiteralExprOnly(that);
    }

    public void for_SyntaxTransformationFloatLiteralExprOnly(_SyntaxTransformationFloatLiteralExpr that) {
        forFloatLiteralExprOnly(that);
    }

    public void for_SyntaxTransformationIntLiteralExprOnly(_SyntaxTransformationIntLiteralExpr that) {
        forIntLiteralExprOnly(that);
    }

    public void for_SyntaxTransformationCharLiteralExprOnly(_SyntaxTransformationCharLiteralExpr that) {
        forCharLiteralExprOnly(that);
    }

    public void for_SyntaxTransformationStringLiteralExprOnly(_SyntaxTransformationStringLiteralExpr that) {
        forStringLiteralExprOnly(that);
    }

    public void for_SyntaxTransformationVoidLiteralExprOnly(_SyntaxTransformationVoidLiteralExpr that) {
        forVoidLiteralExprOnly(that);
    }

    public void for_SyntaxTransformationBooleanLiteralExprOnly(_SyntaxTransformationBooleanLiteralExpr that) {
        forBooleanLiteralExprOnly(that);
    }

    public void for_SyntaxTransformationVarRefOnly(_SyntaxTransformationVarRef that) {
        forVarRefOnly(that);
    }

    public void for_SyntaxTransformationFieldRefOnly(_SyntaxTransformationFieldRef that) {
        forFieldRefOnly(that);
    }

    public void for_SyntaxTransformationFunctionalRefOnly(_SyntaxTransformationFunctionalRef that) {
        forFunctionalRefOnly(that);
    }

    public void for_SyntaxTransformationFnRefOnly(_SyntaxTransformationFnRef that) {
        forFnRefOnly(that);
    }

    public void for_SyntaxTransformationOpRefOnly(_SyntaxTransformationOpRef that) {
        forOpRefOnly(that);
    }

    public void for_SyntaxTransformation_RewriteFnRefOnly(_SyntaxTransformation_RewriteFnRef that) {
        for_RewriteFnRefOnly(that);
    }

    public void for_SyntaxTransformation_RewriteObjectExprRefOnly(_SyntaxTransformation_RewriteObjectExprRef that) {
        for_RewriteObjectExprRefOnly(that);
    }

    public void for_SyntaxTransformationJuxtOnly(_SyntaxTransformationJuxt that) {
        forJuxtOnly(that);
    }

    public void for_SyntaxTransformation_RewriteFnAppOnly(_SyntaxTransformation_RewriteFnApp that) {
        for_RewriteFnAppOnly(that);
    }

    public void for_SyntaxTransformationOpExprOnly(_SyntaxTransformationOpExpr that) {
        forOpExprOnly(that);
    }

    public void for_SyntaxTransformationAmbiguousMultifixOpExprOnly(_SyntaxTransformationAmbiguousMultifixOpExpr that) {
        forAmbiguousMultifixOpExprOnly(that);
    }

    public void for_SyntaxTransformationChainExprOnly(_SyntaxTransformationChainExpr that) {
        forChainExprOnly(that);
    }

    public void for_SyntaxTransformationCoercionInvocationOnly(_SyntaxTransformationCoercionInvocation that) {
        forCoercionInvocationOnly(that);
    }

    public void for_SyntaxTransformationTraitCoercionInvocationOnly(_SyntaxTransformationTraitCoercionInvocation that) {
        forTraitCoercionInvocationOnly(that);
    }

    public void for_SyntaxTransformationTupleCoercionInvocationOnly(_SyntaxTransformationTupleCoercionInvocation that) {
        forTupleCoercionInvocationOnly(that);
    }

    public void for_SyntaxTransformationArrowCoercionInvocationOnly(_SyntaxTransformationArrowCoercionInvocation that) {
        forArrowCoercionInvocationOnly(that);
    }

    public void for_SyntaxTransformationUnionCoercionInvocationOnly(_SyntaxTransformationUnionCoercionInvocation that) {
        forUnionCoercionInvocationOnly(that);
    }

    public void for_SyntaxTransformationMethodInvocationOnly(_SyntaxTransformationMethodInvocation that) {
        forMethodInvocationOnly(that);
    }

    public void for_SyntaxTransformationMathPrimaryOnly(_SyntaxTransformationMathPrimary that) {
        forMathPrimaryOnly(that);
    }

    public void for_SyntaxTransformationArrayExprOnly(_SyntaxTransformationArrayExpr that) {
        forArrayExprOnly(that);
    }

    public void for_SyntaxTransformationArrayElementOnly(_SyntaxTransformationArrayElement that) {
        forArrayElementOnly(that);
    }

    public void for_SyntaxTransformationArrayElementsOnly(_SyntaxTransformationArrayElements that) {
        forArrayElementsOnly(that);
    }

    public void for_EllipsesExprOnly(_EllipsesExpr that) {
        forExprOnly(that);
    }

    public void for_EllipsesDummyExprOnly(_EllipsesDummyExpr that) {
        forDummyExprOnly(that);
    }

    public void for_EllipsesTypeAnnotatedExprOnly(_EllipsesTypeAnnotatedExpr that) {
        forTypeAnnotatedExprOnly(that);
    }

    public void for_EllipsesAsExprOnly(_EllipsesAsExpr that) {
        forAsExprOnly(that);
    }

    public void for_EllipsesAsIfExprOnly(_EllipsesAsIfExpr that) {
        forAsIfExprOnly(that);
    }

    public void for_EllipsesAssignmentOnly(_EllipsesAssignment that) {
        forAssignmentOnly(that);
    }

    public void for_EllipsesBlockOnly(_EllipsesBlock that) {
        forBlockOnly(that);
    }

    public void for_EllipsesDoOnly(_EllipsesDo that) {
        forDoOnly(that);
    }

    public void for_EllipsesCaseExprOnly(_EllipsesCaseExpr that) {
        forCaseExprOnly(that);
    }

    public void for_EllipsesIfOnly(_EllipsesIf that) {
        forIfOnly(that);
    }

    public void for_EllipsesLabelOnly(_EllipsesLabel that) {
        forLabelOnly(that);
    }

    public void for_EllipsesAbstractObjectExprOnly(_EllipsesAbstractObjectExpr that) {
        forAbstractObjectExprOnly(that);
    }

    public void for_EllipsesObjectExprOnly(_EllipsesObjectExpr that) {
        forObjectExprOnly(that);
    }

    public void for_Ellipses_RewriteObjectExprOnly(_Ellipses_RewriteObjectExpr that) {
        for_RewriteObjectExprOnly(that);
    }

    public void for_EllipsesTryOnly(_EllipsesTry that) {
        forTryOnly(that);
    }

    public void for_EllipsesTupleExprOnly(_EllipsesTupleExpr that) {
        forTupleExprOnly(that);
    }

    public void for_EllipsesTypecaseOnly(_EllipsesTypecase that) {
        forTypecaseOnly(that);
    }

    public void for_EllipsesWhileOnly(_EllipsesWhile that) {
        forWhileOnly(that);
    }

    public void for_EllipsesForOnly(_EllipsesFor that) {
        forForOnly(that);
    }

    public void for_EllipsesBigOpAppOnly(_EllipsesBigOpApp that) {
        forBigOpAppOnly(that);
    }

    public void for_EllipsesAccumulatorOnly(_EllipsesAccumulator that) {
        forAccumulatorOnly(that);
    }

    public void for_EllipsesArrayComprehensionOnly(_EllipsesArrayComprehension that) {
        forArrayComprehensionOnly(that);
    }

    public void for_EllipsesAtomicExprOnly(_EllipsesAtomicExpr that) {
        forAtomicExprOnly(that);
    }

    public void for_EllipsesExitOnly(_EllipsesExit that) {
        forExitOnly(that);
    }

    public void for_EllipsesSpawnOnly(_EllipsesSpawn that) {
        forSpawnOnly(that);
    }

    public void for_EllipsesThrowOnly(_EllipsesThrow that) {
        forThrowOnly(that);
    }

    public void for_EllipsesTryAtomicExprOnly(_EllipsesTryAtomicExpr that) {
        forTryAtomicExprOnly(that);
    }

    public void for_EllipsesFnExprOnly(_EllipsesFnExpr that) {
        forFnExprOnly(that);
    }

    public void for_EllipsesLetExprOnly(_EllipsesLetExpr that) {
        forLetExprOnly(that);
    }

    public void for_EllipsesLetFnOnly(_EllipsesLetFn that) {
        forLetFnOnly(that);
    }

    public void for_EllipsesLocalVarDeclOnly(_EllipsesLocalVarDecl that) {
        forLocalVarDeclOnly(that);
    }

    public void for_EllipsesSimpleExprOnly(_EllipsesSimpleExpr that) {
        forSimpleExprOnly(that);
    }

    public void for_EllipsesSubscriptExprOnly(_EllipsesSubscriptExpr that) {
        forSubscriptExprOnly(that);
    }

    public void for_EllipsesPrimaryOnly(_EllipsesPrimary that) {
        forPrimaryOnly(that);
    }

    public void for_EllipsesLiteralExprOnly(_EllipsesLiteralExpr that) {
        forLiteralExprOnly(that);
    }

    public void for_EllipsesNumberLiteralExprOnly(_EllipsesNumberLiteralExpr that) {
        forNumberLiteralExprOnly(that);
    }

    public void for_EllipsesFloatLiteralExprOnly(_EllipsesFloatLiteralExpr that) {
        forFloatLiteralExprOnly(that);
    }

    public void for_EllipsesIntLiteralExprOnly(_EllipsesIntLiteralExpr that) {
        forIntLiteralExprOnly(that);
    }

    public void for_EllipsesCharLiteralExprOnly(_EllipsesCharLiteralExpr that) {
        forCharLiteralExprOnly(that);
    }

    public void for_EllipsesStringLiteralExprOnly(_EllipsesStringLiteralExpr that) {
        forStringLiteralExprOnly(that);
    }

    public void for_EllipsesVoidLiteralExprOnly(_EllipsesVoidLiteralExpr that) {
        forVoidLiteralExprOnly(that);
    }

    public void for_EllipsesBooleanLiteralExprOnly(_EllipsesBooleanLiteralExpr that) {
        forBooleanLiteralExprOnly(that);
    }

    public void for_EllipsesVarRefOnly(_EllipsesVarRef that) {
        forVarRefOnly(that);
    }

    public void for_EllipsesFieldRefOnly(_EllipsesFieldRef that) {
        forFieldRefOnly(that);
    }

    public void for_EllipsesFunctionalRefOnly(_EllipsesFunctionalRef that) {
        forFunctionalRefOnly(that);
    }

    public void for_EllipsesFnRefOnly(_EllipsesFnRef that) {
        forFnRefOnly(that);
    }

    public void for_EllipsesOpRefOnly(_EllipsesOpRef that) {
        forOpRefOnly(that);
    }

    public void for_Ellipses_RewriteFnRefOnly(_Ellipses_RewriteFnRef that) {
        for_RewriteFnRefOnly(that);
    }

    public void for_Ellipses_RewriteObjectExprRefOnly(_Ellipses_RewriteObjectExprRef that) {
        for_RewriteObjectExprRefOnly(that);
    }

    public void for_EllipsesJuxtOnly(_EllipsesJuxt that) {
        forJuxtOnly(that);
    }

    public void for_Ellipses_RewriteFnAppOnly(_Ellipses_RewriteFnApp that) {
        for_RewriteFnAppOnly(that);
    }

    public void for_EllipsesOpExprOnly(_EllipsesOpExpr that) {
        forOpExprOnly(that);
    }

    public void for_EllipsesAmbiguousMultifixOpExprOnly(_EllipsesAmbiguousMultifixOpExpr that) {
        forAmbiguousMultifixOpExprOnly(that);
    }

    public void for_EllipsesChainExprOnly(_EllipsesChainExpr that) {
        forChainExprOnly(that);
    }

    public void for_EllipsesCoercionInvocationOnly(_EllipsesCoercionInvocation that) {
        forCoercionInvocationOnly(that);
    }

    public void for_EllipsesTraitCoercionInvocationOnly(_EllipsesTraitCoercionInvocation that) {
        forTraitCoercionInvocationOnly(that);
    }

    public void for_EllipsesTupleCoercionInvocationOnly(_EllipsesTupleCoercionInvocation that) {
        forTupleCoercionInvocationOnly(that);
    }

    public void for_EllipsesArrowCoercionInvocationOnly(_EllipsesArrowCoercionInvocation that) {
        forArrowCoercionInvocationOnly(that);
    }

    public void for_EllipsesUnionCoercionInvocationOnly(_EllipsesUnionCoercionInvocation that) {
        forUnionCoercionInvocationOnly(that);
    }

    public void for_EllipsesMethodInvocationOnly(_EllipsesMethodInvocation that) {
        forMethodInvocationOnly(that);
    }

    public void for_EllipsesMathPrimaryOnly(_EllipsesMathPrimary that) {
        forMathPrimaryOnly(that);
    }

    public void for_EllipsesArrayExprOnly(_EllipsesArrayExpr that) {
        forArrayExprOnly(that);
    }

    public void for_EllipsesArrayElementOnly(_EllipsesArrayElement that) {
        forArrayElementOnly(that);
    }

    public void for_EllipsesArrayElementsOnly(_EllipsesArrayElements that) {
        forArrayElementsOnly(that);
    }

    public void forTemplateGapExprOnly(TemplateGapExpr that) {
        forExprOnly(that);
    }

    public void forTemplateGapDummyExprOnly(TemplateGapDummyExpr that) {
        forDummyExprOnly(that);
    }

    public void forTemplateGapTypeAnnotatedExprOnly(TemplateGapTypeAnnotatedExpr that) {
        forTypeAnnotatedExprOnly(that);
    }

    public void forTemplateGapAsExprOnly(TemplateGapAsExpr that) {
        forAsExprOnly(that);
    }

    public void forTemplateGapAsIfExprOnly(TemplateGapAsIfExpr that) {
        forAsIfExprOnly(that);
    }

    public void forTemplateGapAssignmentOnly(TemplateGapAssignment that) {
        forAssignmentOnly(that);
    }

    public void forTemplateGapBlockOnly(TemplateGapBlock that) {
        forBlockOnly(that);
    }

    public void forTemplateGapDoOnly(TemplateGapDo that) {
        forDoOnly(that);
    }

    public void forTemplateGapCaseExprOnly(TemplateGapCaseExpr that) {
        forCaseExprOnly(that);
    }

    public void forTemplateGapIfOnly(TemplateGapIf that) {
        forIfOnly(that);
    }

    public void forTemplateGapLabelOnly(TemplateGapLabel that) {
        forLabelOnly(that);
    }

    public void forTemplateGapAbstractObjectExprOnly(TemplateGapAbstractObjectExpr that) {
        forAbstractObjectExprOnly(that);
    }

    public void forTemplateGapObjectExprOnly(TemplateGapObjectExpr that) {
        forObjectExprOnly(that);
    }

    public void forTemplateGap_RewriteObjectExprOnly(TemplateGap_RewriteObjectExpr that) {
        for_RewriteObjectExprOnly(that);
    }

    public void forTemplateGapTryOnly(TemplateGapTry that) {
        forTryOnly(that);
    }

    public void forTemplateGapTupleExprOnly(TemplateGapTupleExpr that) {
        forTupleExprOnly(that);
    }

    public void forTemplateGapTypecaseOnly(TemplateGapTypecase that) {
        forTypecaseOnly(that);
    }

    public void forTemplateGapWhileOnly(TemplateGapWhile that) {
        forWhileOnly(that);
    }

    public void forTemplateGapForOnly(TemplateGapFor that) {
        forForOnly(that);
    }

    public void forTemplateGapBigOpAppOnly(TemplateGapBigOpApp that) {
        forBigOpAppOnly(that);
    }

    public void forTemplateGapAccumulatorOnly(TemplateGapAccumulator that) {
        forAccumulatorOnly(that);
    }

    public void forTemplateGapArrayComprehensionOnly(TemplateGapArrayComprehension that) {
        forArrayComprehensionOnly(that);
    }

    public void forTemplateGapAtomicExprOnly(TemplateGapAtomicExpr that) {
        forAtomicExprOnly(that);
    }

    public void forTemplateGapExitOnly(TemplateGapExit that) {
        forExitOnly(that);
    }

    public void forTemplateGapSpawnOnly(TemplateGapSpawn that) {
        forSpawnOnly(that);
    }

    public void forTemplateGapThrowOnly(TemplateGapThrow that) {
        forThrowOnly(that);
    }

    public void forTemplateGapTryAtomicExprOnly(TemplateGapTryAtomicExpr that) {
        forTryAtomicExprOnly(that);
    }

    public void forTemplateGapFnExprOnly(TemplateGapFnExpr that) {
        forFnExprOnly(that);
    }

    public void forTemplateGapLetExprOnly(TemplateGapLetExpr that) {
        forLetExprOnly(that);
    }

    public void forTemplateGapLetFnOnly(TemplateGapLetFn that) {
        forLetFnOnly(that);
    }

    public void forTemplateGapLocalVarDeclOnly(TemplateGapLocalVarDecl that) {
        forLocalVarDeclOnly(that);
    }

    public void forTemplateGapSimpleExprOnly(TemplateGapSimpleExpr that) {
        forSimpleExprOnly(that);
    }

    public void forTemplateGapSubscriptExprOnly(TemplateGapSubscriptExpr that) {
        forSubscriptExprOnly(that);
    }

    public void forTemplateGapPrimaryOnly(TemplateGapPrimary that) {
        forPrimaryOnly(that);
    }

    public void forTemplateGapLiteralExprOnly(TemplateGapLiteralExpr that) {
        forLiteralExprOnly(that);
    }

    public void forTemplateGapNumberLiteralExprOnly(TemplateGapNumberLiteralExpr that) {
        forNumberLiteralExprOnly(that);
    }

    public void forTemplateGapFloatLiteralExprOnly(TemplateGapFloatLiteralExpr that) {
        forFloatLiteralExprOnly(that);
    }

    public void forTemplateGapIntLiteralExprOnly(TemplateGapIntLiteralExpr that) {
        forIntLiteralExprOnly(that);
    }

    public void forTemplateGapCharLiteralExprOnly(TemplateGapCharLiteralExpr that) {
        forCharLiteralExprOnly(that);
    }

    public void forTemplateGapStringLiteralExprOnly(TemplateGapStringLiteralExpr that) {
        forStringLiteralExprOnly(that);
    }

    public void forTemplateGapVoidLiteralExprOnly(TemplateGapVoidLiteralExpr that) {
        forVoidLiteralExprOnly(that);
    }

    public void forTemplateGapBooleanLiteralExprOnly(TemplateGapBooleanLiteralExpr that) {
        forBooleanLiteralExprOnly(that);
    }

    public void forTemplateGapVarRefOnly(TemplateGapVarRef that) {
        forVarRefOnly(that);
    }

    public void forTemplateGapFieldRefOnly(TemplateGapFieldRef that) {
        forFieldRefOnly(that);
    }

    public void forTemplateGapFunctionalRefOnly(TemplateGapFunctionalRef that) {
        forFunctionalRefOnly(that);
    }

    public void forTemplateGapFnRefOnly(TemplateGapFnRef that) {
        forFnRefOnly(that);
    }

    public void forTemplateGapOpRefOnly(TemplateGapOpRef that) {
        forOpRefOnly(that);
    }

    public void forTemplateGap_RewriteFnRefOnly(TemplateGap_RewriteFnRef that) {
        for_RewriteFnRefOnly(that);
    }

    public void forTemplateGap_RewriteObjectExprRefOnly(TemplateGap_RewriteObjectExprRef that) {
        for_RewriteObjectExprRefOnly(that);
    }

    public void forTemplateGapJuxtOnly(TemplateGapJuxt that) {
        forJuxtOnly(that);
    }

    public void forTemplateGap_RewriteFnAppOnly(TemplateGap_RewriteFnApp that) {
        for_RewriteFnAppOnly(that);
    }

    public void forTemplateGapOpExprOnly(TemplateGapOpExpr that) {
        forOpExprOnly(that);
    }

    public void forTemplateGapAmbiguousMultifixOpExprOnly(TemplateGapAmbiguousMultifixOpExpr that) {
        forAmbiguousMultifixOpExprOnly(that);
    }

    public void forTemplateGapChainExprOnly(TemplateGapChainExpr that) {
        forChainExprOnly(that);
    }

    public void forTemplateGapCoercionInvocationOnly(TemplateGapCoercionInvocation that) {
        forCoercionInvocationOnly(that);
    }

    public void forTemplateGapTraitCoercionInvocationOnly(TemplateGapTraitCoercionInvocation that) {
        forTraitCoercionInvocationOnly(that);
    }

    public void forTemplateGapTupleCoercionInvocationOnly(TemplateGapTupleCoercionInvocation that) {
        forTupleCoercionInvocationOnly(that);
    }

    public void forTemplateGapArrowCoercionInvocationOnly(TemplateGapArrowCoercionInvocation that) {
        forArrowCoercionInvocationOnly(that);
    }

    public void forTemplateGapUnionCoercionInvocationOnly(TemplateGapUnionCoercionInvocation that) {
        forUnionCoercionInvocationOnly(that);
    }

    public void forTemplateGapMethodInvocationOnly(TemplateGapMethodInvocation that) {
        forMethodInvocationOnly(that);
    }

    public void forTemplateGapMathPrimaryOnly(TemplateGapMathPrimary that) {
        forMathPrimaryOnly(that);
    }

    public void forTemplateGapArrayExprOnly(TemplateGapArrayExpr that) {
        forArrayExprOnly(that);
    }

    public void forTemplateGapArrayElementOnly(TemplateGapArrayElement that) {
        forArrayElementOnly(that);
    }

    public void forTemplateGapArrayElementsOnly(TemplateGapArrayElements that) {
        forArrayElementsOnly(that);
    }

    /* Methods to recur on each child. */
    public void forDummyExpr(DummyExpr that) {
        forDummyExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        forDummyExprOnly(that);
    }

    public void forAsExpr(AsExpr that) {
        forAsExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getExpr());
        recurOnType(that.getAnnType());
        forAsExprOnly(that);
    }

    public void forAsIfExpr(AsIfExpr that) {
        forAsIfExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getExpr());
        recurOnType(that.getAnnType());
        forAsIfExprOnly(that);
    }

    public void forAssignment(Assignment that) {
        forAssignmentDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnListOfLhs(that.getLhs());
        recurOnOptionOfFunctionalRef(that.getAssignOp());
        recur(that.getRhs());
        recurOnListOfCompoundAssignmentInfo(that.getAssignmentInfos());
        forAssignmentOnly(that);
    }

    public void forBlock(Block that) {
        forBlockDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnOptionOfExpr(that.getLoc());
        recurOnListOfExpr(that.getExprs());
        forBlockOnly(that);
    }

    public void forDo(Do that) {
        forDoDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnListOfBlock(that.getFronts());
        forDoOnly(that);
    }

    public void forCaseExpr(CaseExpr that) {
        forCaseExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnOptionOfExpr(that.getParam());
        recurOnOptionOfFunctionalRef(that.getCompare());
        recur(that.getEqualsOp());
        recur(that.getInOp());
        recurOnListOfCaseClause(that.getClauses());
        recurOnOptionOfBlock(that.getElseClause());
        forCaseExprOnly(that);
    }

    public void forIf(If that) {
        forIfDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnListOfIfClause(that.getClauses());
        recurOnOptionOfBlock(that.getElseClause());
        forIfOnly(that);
    }

    public void forLabel(Label that) {
        forLabelDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getName());
        recur(that.getBody());
        forLabelOnly(that);
    }

    public void forObjectExpr(ObjectExpr that) {
        forObjectExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnTraitTypeHeader(that.getHeader());
        recurOnOptionOfSelfType(that.getSelfType());
        forObjectExprOnly(that);
    }

    public void for_RewriteObjectExpr(_RewriteObjectExpr that) {
        for_RewriteObjectExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnTraitTypeHeader(that.getHeader());
        recurOnListOfStaticArg(that.getStaticArgs());
        for_RewriteObjectExprOnly(that);
    }

    public void forTry(Try that) {
        forTryDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getBody());
        recurOnOptionOfCatch(that.getCatchClause());
        recurOnListOfBaseType(that.getForbidClause());
        recurOnOptionOfBlock(that.getFinallyClause());
        forTryOnly(that);
    }

    public void forTupleExpr(TupleExpr that) {
        forTupleExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnListOfExpr(that.getExprs());
        recurOnOptionOfExpr(that.getVarargs());
        recurOnListOfKeywordExpr(that.getKeywords());
        forTupleExprOnly(that);
    }

    public void forTypecase(Typecase that) {
        forTypecaseDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getBindExpr());
        recurOnListOfTypecaseClause(that.getClauses());
        recurOnOptionOfBlock(that.getElseClause());
        forTypecaseOnly(that);
    }

    public void forWhile(While that) {
        forWhileDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnGeneratorClause(that.getTestExpr());
        recur(that.getBody());
        forWhileOnly(that);
    }

    public void forFor(For that) {
        forForDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnListOfGeneratorClause(that.getGens());
        recur(that.getBody());
        forForOnly(that);
    }

    public void forAccumulator(Accumulator that) {
        forAccumulatorDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnOp(that.getAccOp());
        recurOnListOfGeneratorClause(that.getGens());
        recur(that.getBody());
        forAccumulatorOnly(that);
    }

    public void forArrayComprehension(ArrayComprehension that) {
        forArrayComprehensionDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnListOfArrayComprehensionClause(that.getClauses());
        forArrayComprehensionOnly(that);
    }

    public void forAtomicExpr(AtomicExpr that) {
        forAtomicExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getExpr());
        forAtomicExprOnly(that);
    }

    public void forExit(Exit that) {
        forExitDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnOptionOfId(that.getTarget());
        recurOnOptionOfExpr(that.getReturnExpr());
        forExitOnly(that);
    }

    public void forSpawn(Spawn that) {
        forSpawnDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getBody());
        forSpawnOnly(that);
    }

    public void forThrow(Throw that) {
        forThrowDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getExpr());
        forThrowOnly(that);
    }

    public void forTryAtomicExpr(TryAtomicExpr that) {
        forTryAtomicExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getExpr());
        forTryAtomicExprOnly(that);
    }

    public void forFnExpr(FnExpr that) {
        forFnExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnFnHeader(that.getHeader());
        recur(that.getBody());
        forFnExprOnly(that);
    }

    public void forLetFn(LetFn that) {
        forLetFnDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getBody());
        recurOnListOfFnDecl(that.getFns());
        forLetFnOnly(that);
    }

    public void forLocalVarDecl(LocalVarDecl that) {
        forLocalVarDeclDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getBody());
        recurOnListOfLValue(that.getLhs());
        recurOnOptionOfExpr(that.getRhs());
        forLocalVarDeclOnly(that);
    }

    public void forSubscriptExpr(SubscriptExpr that) {
        forSubscriptExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getObj());
        recurOnListOfExpr(that.getSubs());
        recurOnOptionOfOp(that.getOp());
        recurOnListOfStaticArg(that.getStaticArgs());
        forSubscriptExprOnly(that);
    }

    public void forFloatLiteralExpr(FloatLiteralExpr that) {
        forFloatLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        forFloatLiteralExprOnly(that);
    }

    public void forIntLiteralExpr(IntLiteralExpr that) {
        forIntLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        forIntLiteralExprOnly(that);
    }

    public void forCharLiteralExpr(CharLiteralExpr that) {
        forCharLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        forCharLiteralExprOnly(that);
    }

    public void forStringLiteralExpr(StringLiteralExpr that) {
        forStringLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        forStringLiteralExprOnly(that);
    }

    public void forVoidLiteralExpr(VoidLiteralExpr that) {
        forVoidLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        forVoidLiteralExprOnly(that);
    }

    public void forBooleanLiteralExpr(BooleanLiteralExpr that) {
        forBooleanLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        forBooleanLiteralExprOnly(that);
    }

    public void forVarRef(VarRef that) {
        forVarRefDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getVarId());
        recurOnListOfStaticArg(that.getStaticArgs());
        forVarRefOnly(that);
    }

    public void forFieldRef(FieldRef that) {
        forFieldRefDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getObj());
        recurOnId(that.getField());
        forFieldRefOnly(that);
    }

    public void forFnRef(FnRef that) {
        forFnRefDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnIdOrOp(that.getOriginalName());
        recurOnListOfIdOrOp(that.getNames());
        recurOnListOfOverloading(that.getInterpOverloadings());
        recurOnListOfOverloading(that.getNewOverloadings());
        recurOnOptionOfType(that.getOverloadingType());
        recurOnOptionOfType(that.getOverloadingSchema());
        forFnRefOnly(that);
    }

    public void forOpRef(OpRef that) {
        forOpRefDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnIdOrOp(that.getOriginalName());
        recurOnListOfIdOrOp(that.getNames());
        recurOnListOfOverloading(that.getInterpOverloadings());
        recurOnListOfOverloading(that.getNewOverloadings());
        recurOnOptionOfType(that.getOverloadingType());
        recurOnOptionOfType(that.getOverloadingSchema());
        forOpRefOnly(that);
    }

    public void for_RewriteFnRef(_RewriteFnRef that) {
        for_RewriteFnRefDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getFnExpr());
        recurOnListOfStaticArg(that.getStaticArgs());
        for_RewriteFnRefOnly(that);
    }

    public void for_RewriteObjectExprRef(_RewriteObjectExprRef that) {
        for_RewriteObjectExprRefDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnListOfStaticArg(that.getStaticArgs());
        for_RewriteObjectExprRefOnly(that);
    }

    public void forJuxt(Juxt that) {
        forJuxtDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getMultiJuxt());
        recur(that.getInfixJuxt());
        recurOnListOfExpr(that.getExprs());
        forJuxtOnly(that);
    }

    public void for_RewriteFnApp(_RewriteFnApp that) {
        for_RewriteFnAppDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getFunction());
        recur(that.getArgument());
        for_RewriteFnAppOnly(that);
    }

    public void forOpExpr(OpExpr that) {
        forOpExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getOp());
        recurOnListOfExpr(that.getArgs());
        forOpExprOnly(that);
    }

    public void forAmbiguousMultifixOpExpr(AmbiguousMultifixOpExpr that) {
        forAmbiguousMultifixOpExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getInfix_op());
        recur(that.getMultifix_op());
        recurOnListOfExpr(that.getArgs());
        forAmbiguousMultifixOpExprOnly(that);
    }

    public void forChainExpr(ChainExpr that) {
        forChainExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getFirst());
        recurOnListOfLink(that.getLinks());
        forChainExprOnly(that);
    }

    public void forTraitCoercionInvocation(TraitCoercionInvocation that) {
        forTraitCoercionInvocationDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getArg());
        recurOnTraitType(that.getToType());
        recur(that.getCoercionFn());
        forTraitCoercionInvocationOnly(that);
    }

    public void forTupleCoercionInvocation(TupleCoercionInvocation that) {
        forTupleCoercionInvocationDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getArg());
        recurOnTupleType(that.getToType());
        recurOnListOfOptionOfCoercionInvocation(that.getSubCoercions());
        recurOnOptionOfOptionOfCoercionInvocation(that.getVarargCoercion());
        forTupleCoercionInvocationOnly(that);
    }

    public void forArrowCoercionInvocation(ArrowCoercionInvocation that) {
        forArrowCoercionInvocationDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getArg());
        recurOnArrowType(that.getToType());
        recurOnOptionOfCoercionInvocation(that.getDomainCoercion());
        recurOnOptionOfCoercionInvocation(that.getRangeCoercion());
        forArrowCoercionInvocationOnly(that);
    }

    public void forUnionCoercionInvocation(UnionCoercionInvocation that) {
        forUnionCoercionInvocationDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnType(that.getToType());
        recur(that.getArg());
        recurOnListOfType(that.getFromTypes());
        recurOnListOfOptionOfCoercionInvocation(that.getFromCoercions());
        forUnionCoercionInvocationOnly(that);
    }

    public void forMethodInvocation(MethodInvocation that) {
        forMethodInvocationDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getObj());
        recurOnIdOrOp(that.getMethod());
        recurOnListOfStaticArg(that.getStaticArgs());
        recur(that.getArg());
        recurOnOptionOfType(that.getOverloadingType());
        recurOnOptionOfType(that.getOverloadingSchema());
        forMethodInvocationOnly(that);
    }

    public void forMathPrimary(MathPrimary that) {
        forMathPrimaryDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getMultiJuxt());
        recur(that.getInfixJuxt());
        recur(that.getFront());
        recurOnListOfMathItem(that.getRest());
        forMathPrimaryOnly(that);
    }

    public void forArrayElement(ArrayElement that) {
        forArrayElementDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnListOfStaticArg(that.getStaticArgs());
        recur(that.getElement());
        forArrayElementOnly(that);
    }

    public void forArrayElements(ArrayElements that) {
        forArrayElementsDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnListOfArrayExpr(that.getElements());
        forArrayElementsOnly(that);
    }

    public void for_SyntaxTransformationExpr(_SyntaxTransformationExpr that) {
        for_SyntaxTransformationExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationExprOnly(that);
    }

    public void for_SyntaxTransformationDummyExpr(_SyntaxTransformationDummyExpr that) {
        for_SyntaxTransformationDummyExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationDummyExprOnly(that);
    }

    public void for_SyntaxTransformationTypeAnnotatedExpr(_SyntaxTransformationTypeAnnotatedExpr that) {
        for_SyntaxTransformationTypeAnnotatedExprDoFirst(that);
        recur(that.getExpr());
        recurOnType(that.getAnnType());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationTypeAnnotatedExprOnly(that);
    }

    public void for_SyntaxTransformationAsExpr(_SyntaxTransformationAsExpr that) {
        for_SyntaxTransformationAsExprDoFirst(that);
        recur(that.getExpr());
        recurOnType(that.getAnnType());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationAsExprOnly(that);
    }

    public void for_SyntaxTransformationAsIfExpr(_SyntaxTransformationAsIfExpr that) {
        for_SyntaxTransformationAsIfExprDoFirst(that);
        recur(that.getExpr());
        recurOnType(that.getAnnType());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationAsIfExprOnly(that);
    }

    public void for_SyntaxTransformationAssignment(_SyntaxTransformationAssignment that) {
        for_SyntaxTransformationAssignmentDoFirst(that);
        recurOnListOfLhs(that.getLhs());
        recurOnOptionOfFunctionalRef(that.getAssignOp());
        recur(that.getRhs());
        recurOnListOfCompoundAssignmentInfo(that.getAssignmentInfos());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationAssignmentOnly(that);
    }

    public void for_SyntaxTransformationBlock(_SyntaxTransformationBlock that) {
        for_SyntaxTransformationBlockDoFirst(that);
        recurOnOptionOfExpr(that.getLoc());
        recurOnListOfExpr(that.getExprs());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationBlockOnly(that);
    }

    public void for_SyntaxTransformationDo(_SyntaxTransformationDo that) {
        for_SyntaxTransformationDoDoFirst(that);
        recurOnListOfBlock(that.getFronts());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationDoOnly(that);
    }

    public void for_SyntaxTransformationCaseExpr(_SyntaxTransformationCaseExpr that) {
        for_SyntaxTransformationCaseExprDoFirst(that);
        recurOnOptionOfExpr(that.getParam());
        recurOnOptionOfFunctionalRef(that.getCompare());
        recur(that.getEqualsOp());
        recur(that.getInOp());
        recurOnListOfCaseClause(that.getClauses());
        recurOnOptionOfBlock(that.getElseClause());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationCaseExprOnly(that);
    }

    public void for_SyntaxTransformationIf(_SyntaxTransformationIf that) {
        for_SyntaxTransformationIfDoFirst(that);
        recurOnListOfIfClause(that.getClauses());
        recurOnOptionOfBlock(that.getElseClause());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationIfOnly(that);
    }

    public void for_SyntaxTransformationLabel(_SyntaxTransformationLabel that) {
        for_SyntaxTransformationLabelDoFirst(that);
        recurOnId(that.getName());
        recur(that.getBody());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationLabelOnly(that);
    }

    public void for_SyntaxTransformationAbstractObjectExpr(_SyntaxTransformationAbstractObjectExpr that) {
        for_SyntaxTransformationAbstractObjectExprDoFirst(that);
        recurOnTraitTypeHeader(that.getHeader());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationAbstractObjectExprOnly(that);
    }

    public void for_SyntaxTransformationObjectExpr(_SyntaxTransformationObjectExpr that) {
        for_SyntaxTransformationObjectExprDoFirst(that);
        recurOnTraitTypeHeader(that.getHeader());
        recurOnOptionOfSelfType(that.getSelfType());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationObjectExprOnly(that);
    }

    public void for_SyntaxTransformation_RewriteObjectExpr(_SyntaxTransformation_RewriteObjectExpr that) {
        for_SyntaxTransformation_RewriteObjectExprDoFirst(that);
        recurOnTraitTypeHeader(that.getHeader());
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformation_RewriteObjectExprOnly(that);
    }

    public void for_SyntaxTransformationTry(_SyntaxTransformationTry that) {
        for_SyntaxTransformationTryDoFirst(that);
        recur(that.getBody());
        recurOnOptionOfCatch(that.getCatchClause());
        recurOnListOfBaseType(that.getForbidClause());
        recurOnOptionOfBlock(that.getFinallyClause());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationTryOnly(that);
    }

    public void for_SyntaxTransformationTupleExpr(_SyntaxTransformationTupleExpr that) {
        for_SyntaxTransformationTupleExprDoFirst(that);
        recurOnListOfExpr(that.getExprs());
        recurOnOptionOfExpr(that.getVarargs());
        recurOnListOfKeywordExpr(that.getKeywords());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationTupleExprOnly(that);
    }

    public void for_SyntaxTransformationTypecase(_SyntaxTransformationTypecase that) {
        for_SyntaxTransformationTypecaseDoFirst(that);
        recur(that.getBindExpr());
        recurOnListOfTypecaseClause(that.getClauses());
        recurOnOptionOfBlock(that.getElseClause());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationTypecaseOnly(that);
    }

    public void for_SyntaxTransformationWhile(_SyntaxTransformationWhile that) {
        for_SyntaxTransformationWhileDoFirst(that);
        recurOnGeneratorClause(that.getTestExpr());
        recur(that.getBody());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationWhileOnly(that);
    }

    public void for_SyntaxTransformationFor(_SyntaxTransformationFor that) {
        for_SyntaxTransformationForDoFirst(that);
        recurOnListOfGeneratorClause(that.getGens());
        recur(that.getBody());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationForOnly(that);
    }

    public void for_SyntaxTransformationBigOpApp(_SyntaxTransformationBigOpApp that) {
        for_SyntaxTransformationBigOpAppDoFirst(that);
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationBigOpAppOnly(that);
    }

    public void for_SyntaxTransformationAccumulator(_SyntaxTransformationAccumulator that) {
        for_SyntaxTransformationAccumulatorDoFirst(that);
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnOp(that.getAccOp());
        recurOnListOfGeneratorClause(that.getGens());
        recur(that.getBody());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationAccumulatorOnly(that);
    }

    public void for_SyntaxTransformationArrayComprehension(_SyntaxTransformationArrayComprehension that) {
        for_SyntaxTransformationArrayComprehensionDoFirst(that);
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnListOfArrayComprehensionClause(that.getClauses());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationArrayComprehensionOnly(that);
    }

    public void for_SyntaxTransformationAtomicExpr(_SyntaxTransformationAtomicExpr that) {
        for_SyntaxTransformationAtomicExprDoFirst(that);
        recur(that.getExpr());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationAtomicExprOnly(that);
    }

    public void for_SyntaxTransformationExit(_SyntaxTransformationExit that) {
        for_SyntaxTransformationExitDoFirst(that);
        recurOnOptionOfId(that.getTarget());
        recurOnOptionOfExpr(that.getReturnExpr());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationExitOnly(that);
    }

    public void for_SyntaxTransformationSpawn(_SyntaxTransformationSpawn that) {
        for_SyntaxTransformationSpawnDoFirst(that);
        recur(that.getBody());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationSpawnOnly(that);
    }

    public void for_SyntaxTransformationThrow(_SyntaxTransformationThrow that) {
        for_SyntaxTransformationThrowDoFirst(that);
        recur(that.getExpr());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationThrowOnly(that);
    }

    public void for_SyntaxTransformationTryAtomicExpr(_SyntaxTransformationTryAtomicExpr that) {
        for_SyntaxTransformationTryAtomicExprDoFirst(that);
        recur(that.getExpr());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationTryAtomicExprOnly(that);
    }

    public void for_SyntaxTransformationFnExpr(_SyntaxTransformationFnExpr that) {
        for_SyntaxTransformationFnExprDoFirst(that);
        recurOnFnHeader(that.getHeader());
        recur(that.getBody());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationFnExprOnly(that);
    }

    public void for_SyntaxTransformationLetExpr(_SyntaxTransformationLetExpr that) {
        for_SyntaxTransformationLetExprDoFirst(that);
        recur(that.getBody());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationLetExprOnly(that);
    }

    public void for_SyntaxTransformationLetFn(_SyntaxTransformationLetFn that) {
        for_SyntaxTransformationLetFnDoFirst(that);
        recur(that.getBody());
        recurOnListOfFnDecl(that.getFns());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationLetFnOnly(that);
    }

    public void for_SyntaxTransformationLocalVarDecl(_SyntaxTransformationLocalVarDecl that) {
        for_SyntaxTransformationLocalVarDeclDoFirst(that);
        recur(that.getBody());
        recurOnListOfLValue(that.getLhs());
        recurOnOptionOfExpr(that.getRhs());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationLocalVarDeclOnly(that);
    }

    public void for_SyntaxTransformationSimpleExpr(_SyntaxTransformationSimpleExpr that) {
        for_SyntaxTransformationSimpleExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationSimpleExprOnly(that);
    }

    public void for_SyntaxTransformationSubscriptExpr(_SyntaxTransformationSubscriptExpr that) {
        for_SyntaxTransformationSubscriptExprDoFirst(that);
        recur(that.getObj());
        recurOnListOfExpr(that.getSubs());
        recurOnOptionOfOp(that.getOp());
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationSubscriptExprOnly(that);
    }

    public void for_SyntaxTransformationPrimary(_SyntaxTransformationPrimary that) {
        for_SyntaxTransformationPrimaryDoFirst(that);
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationPrimaryOnly(that);
    }

    public void for_SyntaxTransformationLiteralExpr(_SyntaxTransformationLiteralExpr that) {
        for_SyntaxTransformationLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationLiteralExprOnly(that);
    }

    public void for_SyntaxTransformationNumberLiteralExpr(_SyntaxTransformationNumberLiteralExpr that) {
        for_SyntaxTransformationNumberLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationNumberLiteralExprOnly(that);
    }

    public void for_SyntaxTransformationFloatLiteralExpr(_SyntaxTransformationFloatLiteralExpr that) {
        for_SyntaxTransformationFloatLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationFloatLiteralExprOnly(that);
    }

    public void for_SyntaxTransformationIntLiteralExpr(_SyntaxTransformationIntLiteralExpr that) {
        for_SyntaxTransformationIntLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationIntLiteralExprOnly(that);
    }

    public void for_SyntaxTransformationCharLiteralExpr(_SyntaxTransformationCharLiteralExpr that) {
        for_SyntaxTransformationCharLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationCharLiteralExprOnly(that);
    }

    public void for_SyntaxTransformationStringLiteralExpr(_SyntaxTransformationStringLiteralExpr that) {
        for_SyntaxTransformationStringLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationStringLiteralExprOnly(that);
    }

    public void for_SyntaxTransformationVoidLiteralExpr(_SyntaxTransformationVoidLiteralExpr that) {
        for_SyntaxTransformationVoidLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationVoidLiteralExprOnly(that);
    }

    public void for_SyntaxTransformationBooleanLiteralExpr(_SyntaxTransformationBooleanLiteralExpr that) {
        for_SyntaxTransformationBooleanLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationBooleanLiteralExprOnly(that);
    }

    public void for_SyntaxTransformationVarRef(_SyntaxTransformationVarRef that) {
        for_SyntaxTransformationVarRefDoFirst(that);
        recurOnId(that.getVarId());
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationVarRefOnly(that);
    }

    public void for_SyntaxTransformationFieldRef(_SyntaxTransformationFieldRef that) {
        for_SyntaxTransformationFieldRefDoFirst(that);
        recur(that.getObj());
        recurOnId(that.getField());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationFieldRefOnly(that);
    }

    public void for_SyntaxTransformationFunctionalRef(_SyntaxTransformationFunctionalRef that) {
        for_SyntaxTransformationFunctionalRefDoFirst(that);
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnIdOrOp(that.getOriginalName());
        recurOnListOfIdOrOp(that.getNames());
        recurOnListOfOverloading(that.getInterpOverloadings());
        recurOnListOfOverloading(that.getNewOverloadings());
        recurOnOptionOfType(that.getOverloadingType());
        recurOnOptionOfType(that.getOverloadingSchema());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationFunctionalRefOnly(that);
    }

    public void for_SyntaxTransformationFnRef(_SyntaxTransformationFnRef that) {
        for_SyntaxTransformationFnRefDoFirst(that);
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnIdOrOp(that.getOriginalName());
        recurOnListOfIdOrOp(that.getNames());
        recurOnListOfOverloading(that.getInterpOverloadings());
        recurOnListOfOverloading(that.getNewOverloadings());
        recurOnOptionOfType(that.getOverloadingType());
        recurOnOptionOfType(that.getOverloadingSchema());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationFnRefOnly(that);
    }

    public void for_SyntaxTransformationOpRef(_SyntaxTransformationOpRef that) {
        for_SyntaxTransformationOpRefDoFirst(that);
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnIdOrOp(that.getOriginalName());
        recurOnListOfIdOrOp(that.getNames());
        recurOnListOfOverloading(that.getInterpOverloadings());
        recurOnListOfOverloading(that.getNewOverloadings());
        recurOnOptionOfType(that.getOverloadingType());
        recurOnOptionOfType(that.getOverloadingSchema());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationOpRefOnly(that);
    }

    public void for_SyntaxTransformation_RewriteFnRef(_SyntaxTransformation_RewriteFnRef that) {
        for_SyntaxTransformation_RewriteFnRefDoFirst(that);
        recur(that.getFnExpr());
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformation_RewriteFnRefOnly(that);
    }

    public void for_SyntaxTransformation_RewriteObjectExprRef(_SyntaxTransformation_RewriteObjectExprRef that) {
        for_SyntaxTransformation_RewriteObjectExprRefDoFirst(that);
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformation_RewriteObjectExprRefOnly(that);
    }

    public void for_SyntaxTransformationJuxt(_SyntaxTransformationJuxt that) {
        for_SyntaxTransformationJuxtDoFirst(that);
        recur(that.getMultiJuxt());
        recur(that.getInfixJuxt());
        recurOnListOfExpr(that.getExprs());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationJuxtOnly(that);
    }

    public void for_SyntaxTransformation_RewriteFnApp(_SyntaxTransformation_RewriteFnApp that) {
        for_SyntaxTransformation_RewriteFnAppDoFirst(that);
        recur(that.getFunction());
        recur(that.getArgument());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformation_RewriteFnAppOnly(that);
    }

    public void for_SyntaxTransformationOpExpr(_SyntaxTransformationOpExpr that) {
        for_SyntaxTransformationOpExprDoFirst(that);
        recur(that.getOp());
        recurOnListOfExpr(that.getArgs());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationOpExprOnly(that);
    }

    public void for_SyntaxTransformationAmbiguousMultifixOpExpr(_SyntaxTransformationAmbiguousMultifixOpExpr that) {
        for_SyntaxTransformationAmbiguousMultifixOpExprDoFirst(that);
        recur(that.getInfix_op());
        recur(that.getMultifix_op());
        recurOnListOfExpr(that.getArgs());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationAmbiguousMultifixOpExprOnly(that);
    }

    public void for_SyntaxTransformationChainExpr(_SyntaxTransformationChainExpr that) {
        for_SyntaxTransformationChainExprDoFirst(that);
        recur(that.getFirst());
        recurOnListOfLink(that.getLinks());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationChainExprOnly(that);
    }

    public void for_SyntaxTransformationCoercionInvocation(_SyntaxTransformationCoercionInvocation that) {
        for_SyntaxTransformationCoercionInvocationDoFirst(that);
        recurOnType(that.getToType());
        recur(that.getArg());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationCoercionInvocationOnly(that);
    }

    public void for_SyntaxTransformationTraitCoercionInvocation(_SyntaxTransformationTraitCoercionInvocation that) {
        for_SyntaxTransformationTraitCoercionInvocationDoFirst(that);
        recur(that.getArg());
        recurOnTraitType(that.getToType());
        recur(that.getCoercionFn());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationTraitCoercionInvocationOnly(that);
    }

    public void for_SyntaxTransformationTupleCoercionInvocation(_SyntaxTransformationTupleCoercionInvocation that) {
        for_SyntaxTransformationTupleCoercionInvocationDoFirst(that);
        recur(that.getArg());
        recurOnTupleType(that.getToType());
        recurOnListOfOptionOfCoercionInvocation(that.getSubCoercions());
        recurOnOptionOfOptionOfCoercionInvocation(that.getVarargCoercion());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationTupleCoercionInvocationOnly(that);
    }

    public void for_SyntaxTransformationArrowCoercionInvocation(_SyntaxTransformationArrowCoercionInvocation that) {
        for_SyntaxTransformationArrowCoercionInvocationDoFirst(that);
        recur(that.getArg());
        recurOnArrowType(that.getToType());
        recurOnOptionOfCoercionInvocation(that.getDomainCoercion());
        recurOnOptionOfCoercionInvocation(that.getRangeCoercion());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationArrowCoercionInvocationOnly(that);
    }

    public void for_SyntaxTransformationUnionCoercionInvocation(_SyntaxTransformationUnionCoercionInvocation that) {
        for_SyntaxTransformationUnionCoercionInvocationDoFirst(that);
        recurOnType(that.getToType());
        recur(that.getArg());
        recurOnListOfType(that.getFromTypes());
        recurOnListOfOptionOfCoercionInvocation(that.getFromCoercions());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationUnionCoercionInvocationOnly(that);
    }

    public void for_SyntaxTransformationMethodInvocation(_SyntaxTransformationMethodInvocation that) {
        for_SyntaxTransformationMethodInvocationDoFirst(that);
        recur(that.getObj());
        recurOnIdOrOp(that.getMethod());
        recurOnListOfStaticArg(that.getStaticArgs());
        recur(that.getArg());
        recurOnOptionOfType(that.getOverloadingType());
        recurOnOptionOfType(that.getOverloadingSchema());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationMethodInvocationOnly(that);
    }

    public void for_SyntaxTransformationMathPrimary(_SyntaxTransformationMathPrimary that) {
        for_SyntaxTransformationMathPrimaryDoFirst(that);
        recur(that.getMultiJuxt());
        recur(that.getInfixJuxt());
        recur(that.getFront());
        recurOnListOfMathItem(that.getRest());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationMathPrimaryOnly(that);
    }

    public void for_SyntaxTransformationArrayExpr(_SyntaxTransformationArrayExpr that) {
        for_SyntaxTransformationArrayExprDoFirst(that);
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationArrayExprOnly(that);
    }

    public void for_SyntaxTransformationArrayElement(_SyntaxTransformationArrayElement that) {
        for_SyntaxTransformationArrayElementDoFirst(that);
        recurOnListOfStaticArg(that.getStaticArgs());
        recur(that.getElement());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationArrayElementOnly(that);
    }

    public void for_SyntaxTransformationArrayElements(_SyntaxTransformationArrayElements that) {
        for_SyntaxTransformationArrayElementsDoFirst(that);
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnListOfArrayExpr(that.getElements());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationArrayElementsOnly(that);
    }

    public void for_EllipsesExpr(_EllipsesExpr that) {
        for_EllipsesExprDoFirst(that);
        for_EllipsesExprOnly(that);
    }

    public void for_EllipsesDummyExpr(_EllipsesDummyExpr that) {
        for_EllipsesDummyExprDoFirst(that);
        for_EllipsesDummyExprOnly(that);
    }

    public void for_EllipsesTypeAnnotatedExpr(_EllipsesTypeAnnotatedExpr that) {
        for_EllipsesTypeAnnotatedExprDoFirst(that);
        for_EllipsesTypeAnnotatedExprOnly(that);
    }

    public void for_EllipsesAsExpr(_EllipsesAsExpr that) {
        for_EllipsesAsExprDoFirst(that);
        for_EllipsesAsExprOnly(that);
    }

    public void for_EllipsesAsIfExpr(_EllipsesAsIfExpr that) {
        for_EllipsesAsIfExprDoFirst(that);
        for_EllipsesAsIfExprOnly(that);
    }

    public void for_EllipsesAssignment(_EllipsesAssignment that) {
        for_EllipsesAssignmentDoFirst(that);
        for_EllipsesAssignmentOnly(that);
    }

    public void for_EllipsesBlock(_EllipsesBlock that) {
        for_EllipsesBlockDoFirst(that);
        for_EllipsesBlockOnly(that);
    }

    public void for_EllipsesDo(_EllipsesDo that) {
        for_EllipsesDoDoFirst(that);
        for_EllipsesDoOnly(that);
    }

    public void for_EllipsesCaseExpr(_EllipsesCaseExpr that) {
        for_EllipsesCaseExprDoFirst(that);
        for_EllipsesCaseExprOnly(that);
    }

    public void for_EllipsesIf(_EllipsesIf that) {
        for_EllipsesIfDoFirst(that);
        for_EllipsesIfOnly(that);
    }

    public void for_EllipsesLabel(_EllipsesLabel that) {
        for_EllipsesLabelDoFirst(that);
        for_EllipsesLabelOnly(that);
    }

    public void for_EllipsesAbstractObjectExpr(_EllipsesAbstractObjectExpr that) {
        for_EllipsesAbstractObjectExprDoFirst(that);
        for_EllipsesAbstractObjectExprOnly(that);
    }

    public void for_EllipsesObjectExpr(_EllipsesObjectExpr that) {
        for_EllipsesObjectExprDoFirst(that);
        for_EllipsesObjectExprOnly(that);
    }

    public void for_Ellipses_RewriteObjectExpr(_Ellipses_RewriteObjectExpr that) {
        for_Ellipses_RewriteObjectExprDoFirst(that);
        for_Ellipses_RewriteObjectExprOnly(that);
    }

    public void for_EllipsesTry(_EllipsesTry that) {
        for_EllipsesTryDoFirst(that);
        for_EllipsesTryOnly(that);
    }

    public void for_EllipsesTupleExpr(_EllipsesTupleExpr that) {
        for_EllipsesTupleExprDoFirst(that);
        for_EllipsesTupleExprOnly(that);
    }

    public void for_EllipsesTypecase(_EllipsesTypecase that) {
        for_EllipsesTypecaseDoFirst(that);
        for_EllipsesTypecaseOnly(that);
    }

    public void for_EllipsesWhile(_EllipsesWhile that) {
        for_EllipsesWhileDoFirst(that);
        for_EllipsesWhileOnly(that);
    }

    public void for_EllipsesFor(_EllipsesFor that) {
        for_EllipsesForDoFirst(that);
        for_EllipsesForOnly(that);
    }

    public void for_EllipsesBigOpApp(_EllipsesBigOpApp that) {
        for_EllipsesBigOpAppDoFirst(that);
        for_EllipsesBigOpAppOnly(that);
    }

    public void for_EllipsesAccumulator(_EllipsesAccumulator that) {
        for_EllipsesAccumulatorDoFirst(that);
        for_EllipsesAccumulatorOnly(that);
    }

    public void for_EllipsesArrayComprehension(_EllipsesArrayComprehension that) {
        for_EllipsesArrayComprehensionDoFirst(that);
        for_EllipsesArrayComprehensionOnly(that);
    }

    public void for_EllipsesAtomicExpr(_EllipsesAtomicExpr that) {
        for_EllipsesAtomicExprDoFirst(that);
        for_EllipsesAtomicExprOnly(that);
    }

    public void for_EllipsesExit(_EllipsesExit that) {
        for_EllipsesExitDoFirst(that);
        for_EllipsesExitOnly(that);
    }

    public void for_EllipsesSpawn(_EllipsesSpawn that) {
        for_EllipsesSpawnDoFirst(that);
        for_EllipsesSpawnOnly(that);
    }

    public void for_EllipsesThrow(_EllipsesThrow that) {
        for_EllipsesThrowDoFirst(that);
        for_EllipsesThrowOnly(that);
    }

    public void for_EllipsesTryAtomicExpr(_EllipsesTryAtomicExpr that) {
        for_EllipsesTryAtomicExprDoFirst(that);
        for_EllipsesTryAtomicExprOnly(that);
    }

    public void for_EllipsesFnExpr(_EllipsesFnExpr that) {
        for_EllipsesFnExprDoFirst(that);
        for_EllipsesFnExprOnly(that);
    }

    public void for_EllipsesLetExpr(_EllipsesLetExpr that) {
        for_EllipsesLetExprDoFirst(that);
        for_EllipsesLetExprOnly(that);
    }

    public void for_EllipsesLetFn(_EllipsesLetFn that) {
        for_EllipsesLetFnDoFirst(that);
        for_EllipsesLetFnOnly(that);
    }

    public void for_EllipsesLocalVarDecl(_EllipsesLocalVarDecl that) {
        for_EllipsesLocalVarDeclDoFirst(that);
        for_EllipsesLocalVarDeclOnly(that);
    }

    public void for_EllipsesSimpleExpr(_EllipsesSimpleExpr that) {
        for_EllipsesSimpleExprDoFirst(that);
        for_EllipsesSimpleExprOnly(that);
    }

    public void for_EllipsesSubscriptExpr(_EllipsesSubscriptExpr that) {
        for_EllipsesSubscriptExprDoFirst(that);
        for_EllipsesSubscriptExprOnly(that);
    }

    public void for_EllipsesPrimary(_EllipsesPrimary that) {
        for_EllipsesPrimaryDoFirst(that);
        for_EllipsesPrimaryOnly(that);
    }

    public void for_EllipsesLiteralExpr(_EllipsesLiteralExpr that) {
        for_EllipsesLiteralExprDoFirst(that);
        for_EllipsesLiteralExprOnly(that);
    }

    public void for_EllipsesNumberLiteralExpr(_EllipsesNumberLiteralExpr that) {
        for_EllipsesNumberLiteralExprDoFirst(that);
        for_EllipsesNumberLiteralExprOnly(that);
    }

    public void for_EllipsesFloatLiteralExpr(_EllipsesFloatLiteralExpr that) {
        for_EllipsesFloatLiteralExprDoFirst(that);
        for_EllipsesFloatLiteralExprOnly(that);
    }

    public void for_EllipsesIntLiteralExpr(_EllipsesIntLiteralExpr that) {
        for_EllipsesIntLiteralExprDoFirst(that);
        for_EllipsesIntLiteralExprOnly(that);
    }

    public void for_EllipsesCharLiteralExpr(_EllipsesCharLiteralExpr that) {
        for_EllipsesCharLiteralExprDoFirst(that);
        for_EllipsesCharLiteralExprOnly(that);
    }

    public void for_EllipsesStringLiteralExpr(_EllipsesStringLiteralExpr that) {
        for_EllipsesStringLiteralExprDoFirst(that);
        for_EllipsesStringLiteralExprOnly(that);
    }

    public void for_EllipsesVoidLiteralExpr(_EllipsesVoidLiteralExpr that) {
        for_EllipsesVoidLiteralExprDoFirst(that);
        for_EllipsesVoidLiteralExprOnly(that);
    }

    public void for_EllipsesBooleanLiteralExpr(_EllipsesBooleanLiteralExpr that) {
        for_EllipsesBooleanLiteralExprDoFirst(that);
        for_EllipsesBooleanLiteralExprOnly(that);
    }

    public void for_EllipsesVarRef(_EllipsesVarRef that) {
        for_EllipsesVarRefDoFirst(that);
        for_EllipsesVarRefOnly(that);
    }

    public void for_EllipsesFieldRef(_EllipsesFieldRef that) {
        for_EllipsesFieldRefDoFirst(that);
        for_EllipsesFieldRefOnly(that);
    }

    public void for_EllipsesFunctionalRef(_EllipsesFunctionalRef that) {
        for_EllipsesFunctionalRefDoFirst(that);
        for_EllipsesFunctionalRefOnly(that);
    }

    public void for_EllipsesFnRef(_EllipsesFnRef that) {
        for_EllipsesFnRefDoFirst(that);
        for_EllipsesFnRefOnly(that);
    }

    public void for_EllipsesOpRef(_EllipsesOpRef that) {
        for_EllipsesOpRefDoFirst(that);
        for_EllipsesOpRefOnly(that);
    }

    public void for_Ellipses_RewriteFnRef(_Ellipses_RewriteFnRef that) {
        for_Ellipses_RewriteFnRefDoFirst(that);
        for_Ellipses_RewriteFnRefOnly(that);
    }

    public void for_Ellipses_RewriteObjectExprRef(_Ellipses_RewriteObjectExprRef that) {
        for_Ellipses_RewriteObjectExprRefDoFirst(that);
        for_Ellipses_RewriteObjectExprRefOnly(that);
    }

    public void for_EllipsesJuxt(_EllipsesJuxt that) {
        for_EllipsesJuxtDoFirst(that);
        for_EllipsesJuxtOnly(that);
    }

    public void for_Ellipses_RewriteFnApp(_Ellipses_RewriteFnApp that) {
        for_Ellipses_RewriteFnAppDoFirst(that);
        for_Ellipses_RewriteFnAppOnly(that);
    }

    public void for_EllipsesOpExpr(_EllipsesOpExpr that) {
        for_EllipsesOpExprDoFirst(that);
        for_EllipsesOpExprOnly(that);
    }

    public void for_EllipsesAmbiguousMultifixOpExpr(_EllipsesAmbiguousMultifixOpExpr that) {
        for_EllipsesAmbiguousMultifixOpExprDoFirst(that);
        for_EllipsesAmbiguousMultifixOpExprOnly(that);
    }

    public void for_EllipsesChainExpr(_EllipsesChainExpr that) {
        for_EllipsesChainExprDoFirst(that);
        for_EllipsesChainExprOnly(that);
    }

    public void for_EllipsesCoercionInvocation(_EllipsesCoercionInvocation that) {
        for_EllipsesCoercionInvocationDoFirst(that);
        for_EllipsesCoercionInvocationOnly(that);
    }

    public void for_EllipsesTraitCoercionInvocation(_EllipsesTraitCoercionInvocation that) {
        for_EllipsesTraitCoercionInvocationDoFirst(that);
        for_EllipsesTraitCoercionInvocationOnly(that);
    }

    public void for_EllipsesTupleCoercionInvocation(_EllipsesTupleCoercionInvocation that) {
        for_EllipsesTupleCoercionInvocationDoFirst(that);
        for_EllipsesTupleCoercionInvocationOnly(that);
    }

    public void for_EllipsesArrowCoercionInvocation(_EllipsesArrowCoercionInvocation that) {
        for_EllipsesArrowCoercionInvocationDoFirst(that);
        for_EllipsesArrowCoercionInvocationOnly(that);
    }

    public void for_EllipsesUnionCoercionInvocation(_EllipsesUnionCoercionInvocation that) {
        for_EllipsesUnionCoercionInvocationDoFirst(that);
        for_EllipsesUnionCoercionInvocationOnly(that);
    }

    public void for_EllipsesMethodInvocation(_EllipsesMethodInvocation that) {
        for_EllipsesMethodInvocationDoFirst(that);
        for_EllipsesMethodInvocationOnly(that);
    }

    public void for_EllipsesMathPrimary(_EllipsesMathPrimary that) {
        for_EllipsesMathPrimaryDoFirst(that);
        for_EllipsesMathPrimaryOnly(that);
    }

    public void for_EllipsesArrayExpr(_EllipsesArrayExpr that) {
        for_EllipsesArrayExprDoFirst(that);
        for_EllipsesArrayExprOnly(that);
    }

    public void for_EllipsesArrayElement(_EllipsesArrayElement that) {
        for_EllipsesArrayElementDoFirst(that);
        for_EllipsesArrayElementOnly(that);
    }

    public void for_EllipsesArrayElements(_EllipsesArrayElements that) {
        for_EllipsesArrayElementsDoFirst(that);
        for_EllipsesArrayElementsOnly(that);
    }

    public void forTemplateGapExpr(TemplateGapExpr that) {
        forTemplateGapExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapExprOnly(that);
    }

    public void forTemplateGapDummyExpr(TemplateGapDummyExpr that) {
        forTemplateGapDummyExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapDummyExprOnly(that);
    }

    public void forTemplateGapTypeAnnotatedExpr(TemplateGapTypeAnnotatedExpr that) {
        forTemplateGapTypeAnnotatedExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapTypeAnnotatedExprOnly(that);
    }

    public void forTemplateGapAsExpr(TemplateGapAsExpr that) {
        forTemplateGapAsExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapAsExprOnly(that);
    }

    public void forTemplateGapAsIfExpr(TemplateGapAsIfExpr that) {
        forTemplateGapAsIfExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapAsIfExprOnly(that);
    }

    public void forTemplateGapAssignment(TemplateGapAssignment that) {
        forTemplateGapAssignmentDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapAssignmentOnly(that);
    }

    public void forTemplateGapBlock(TemplateGapBlock that) {
        forTemplateGapBlockDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapBlockOnly(that);
    }

    public void forTemplateGapDo(TemplateGapDo that) {
        forTemplateGapDoDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapDoOnly(that);
    }

    public void forTemplateGapCaseExpr(TemplateGapCaseExpr that) {
        forTemplateGapCaseExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapCaseExprOnly(that);
    }

    public void forTemplateGapIf(TemplateGapIf that) {
        forTemplateGapIfDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapIfOnly(that);
    }

    public void forTemplateGapLabel(TemplateGapLabel that) {
        forTemplateGapLabelDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapLabelOnly(that);
    }

    public void forTemplateGapAbstractObjectExpr(TemplateGapAbstractObjectExpr that) {
        forTemplateGapAbstractObjectExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapAbstractObjectExprOnly(that);
    }

    public void forTemplateGapObjectExpr(TemplateGapObjectExpr that) {
        forTemplateGapObjectExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapObjectExprOnly(that);
    }

    public void forTemplateGap_RewriteObjectExpr(TemplateGap_RewriteObjectExpr that) {
        forTemplateGap_RewriteObjectExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGap_RewriteObjectExprOnly(that);
    }

    public void forTemplateGapTry(TemplateGapTry that) {
        forTemplateGapTryDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapTryOnly(that);
    }

    public void forTemplateGapTupleExpr(TemplateGapTupleExpr that) {
        forTemplateGapTupleExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapTupleExprOnly(that);
    }

    public void forTemplateGapTypecase(TemplateGapTypecase that) {
        forTemplateGapTypecaseDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapTypecaseOnly(that);
    }

    public void forTemplateGapWhile(TemplateGapWhile that) {
        forTemplateGapWhileDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapWhileOnly(that);
    }

    public void forTemplateGapFor(TemplateGapFor that) {
        forTemplateGapForDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapForOnly(that);
    }

    public void forTemplateGapBigOpApp(TemplateGapBigOpApp that) {
        forTemplateGapBigOpAppDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapBigOpAppOnly(that);
    }

    public void forTemplateGapAccumulator(TemplateGapAccumulator that) {
        forTemplateGapAccumulatorDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapAccumulatorOnly(that);
    }

    public void forTemplateGapArrayComprehension(TemplateGapArrayComprehension that) {
        forTemplateGapArrayComprehensionDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapArrayComprehensionOnly(that);
    }

    public void forTemplateGapAtomicExpr(TemplateGapAtomicExpr that) {
        forTemplateGapAtomicExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapAtomicExprOnly(that);
    }

    public void forTemplateGapExit(TemplateGapExit that) {
        forTemplateGapExitDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapExitOnly(that);
    }

    public void forTemplateGapSpawn(TemplateGapSpawn that) {
        forTemplateGapSpawnDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapSpawnOnly(that);
    }

    public void forTemplateGapThrow(TemplateGapThrow that) {
        forTemplateGapThrowDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapThrowOnly(that);
    }

    public void forTemplateGapTryAtomicExpr(TemplateGapTryAtomicExpr that) {
        forTemplateGapTryAtomicExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapTryAtomicExprOnly(that);
    }

    public void forTemplateGapFnExpr(TemplateGapFnExpr that) {
        forTemplateGapFnExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapFnExprOnly(that);
    }

    public void forTemplateGapLetExpr(TemplateGapLetExpr that) {
        forTemplateGapLetExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapLetExprOnly(that);
    }

    public void forTemplateGapLetFn(TemplateGapLetFn that) {
        forTemplateGapLetFnDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapLetFnOnly(that);
    }

    public void forTemplateGapLocalVarDecl(TemplateGapLocalVarDecl that) {
        forTemplateGapLocalVarDeclDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapLocalVarDeclOnly(that);
    }

    public void forTemplateGapSimpleExpr(TemplateGapSimpleExpr that) {
        forTemplateGapSimpleExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapSimpleExprOnly(that);
    }

    public void forTemplateGapSubscriptExpr(TemplateGapSubscriptExpr that) {
        forTemplateGapSubscriptExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapSubscriptExprOnly(that);
    }

    public void forTemplateGapPrimary(TemplateGapPrimary that) {
        forTemplateGapPrimaryDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapPrimaryOnly(that);
    }

    public void forTemplateGapLiteralExpr(TemplateGapLiteralExpr that) {
        forTemplateGapLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapLiteralExprOnly(that);
    }

    public void forTemplateGapNumberLiteralExpr(TemplateGapNumberLiteralExpr that) {
        forTemplateGapNumberLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapNumberLiteralExprOnly(that);
    }

    public void forTemplateGapFloatLiteralExpr(TemplateGapFloatLiteralExpr that) {
        forTemplateGapFloatLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapFloatLiteralExprOnly(that);
    }

    public void forTemplateGapIntLiteralExpr(TemplateGapIntLiteralExpr that) {
        forTemplateGapIntLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapIntLiteralExprOnly(that);
    }

    public void forTemplateGapCharLiteralExpr(TemplateGapCharLiteralExpr that) {
        forTemplateGapCharLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapCharLiteralExprOnly(that);
    }

    public void forTemplateGapStringLiteralExpr(TemplateGapStringLiteralExpr that) {
        forTemplateGapStringLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapStringLiteralExprOnly(that);
    }

    public void forTemplateGapVoidLiteralExpr(TemplateGapVoidLiteralExpr that) {
        forTemplateGapVoidLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapVoidLiteralExprOnly(that);
    }

    public void forTemplateGapBooleanLiteralExpr(TemplateGapBooleanLiteralExpr that) {
        forTemplateGapBooleanLiteralExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapBooleanLiteralExprOnly(that);
    }

    public void forTemplateGapVarRef(TemplateGapVarRef that) {
        forTemplateGapVarRefDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapVarRefOnly(that);
    }

    public void forTemplateGapFieldRef(TemplateGapFieldRef that) {
        forTemplateGapFieldRefDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapFieldRefOnly(that);
    }

    public void forTemplateGapFunctionalRef(TemplateGapFunctionalRef that) {
        forTemplateGapFunctionalRefDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapFunctionalRefOnly(that);
    }

    public void forTemplateGapFnRef(TemplateGapFnRef that) {
        forTemplateGapFnRefDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapFnRefOnly(that);
    }

    public void forTemplateGapOpRef(TemplateGapOpRef that) {
        forTemplateGapOpRefDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapOpRefOnly(that);
    }

    public void forTemplateGap_RewriteFnRef(TemplateGap_RewriteFnRef that) {
        forTemplateGap_RewriteFnRefDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGap_RewriteFnRefOnly(that);
    }

    public void forTemplateGap_RewriteObjectExprRef(TemplateGap_RewriteObjectExprRef that) {
        forTemplateGap_RewriteObjectExprRefDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGap_RewriteObjectExprRefOnly(that);
    }

    public void forTemplateGapJuxt(TemplateGapJuxt that) {
        forTemplateGapJuxtDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapJuxtOnly(that);
    }

    public void forTemplateGap_RewriteFnApp(TemplateGap_RewriteFnApp that) {
        forTemplateGap_RewriteFnAppDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGap_RewriteFnAppOnly(that);
    }

    public void forTemplateGapOpExpr(TemplateGapOpExpr that) {
        forTemplateGapOpExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapOpExprOnly(that);
    }

    public void forTemplateGapAmbiguousMultifixOpExpr(TemplateGapAmbiguousMultifixOpExpr that) {
        forTemplateGapAmbiguousMultifixOpExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapAmbiguousMultifixOpExprOnly(that);
    }

    public void forTemplateGapChainExpr(TemplateGapChainExpr that) {
        forTemplateGapChainExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapChainExprOnly(that);
    }

    public void forTemplateGapCoercionInvocation(TemplateGapCoercionInvocation that) {
        forTemplateGapCoercionInvocationDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapCoercionInvocationOnly(that);
    }

    public void forTemplateGapTraitCoercionInvocation(TemplateGapTraitCoercionInvocation that) {
        forTemplateGapTraitCoercionInvocationDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapTraitCoercionInvocationOnly(that);
    }

    public void forTemplateGapTupleCoercionInvocation(TemplateGapTupleCoercionInvocation that) {
        forTemplateGapTupleCoercionInvocationDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapTupleCoercionInvocationOnly(that);
    }

    public void forTemplateGapArrowCoercionInvocation(TemplateGapArrowCoercionInvocation that) {
        forTemplateGapArrowCoercionInvocationDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapArrowCoercionInvocationOnly(that);
    }

    public void forTemplateGapUnionCoercionInvocation(TemplateGapUnionCoercionInvocation that) {
        forTemplateGapUnionCoercionInvocationDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapUnionCoercionInvocationOnly(that);
    }

    public void forTemplateGapMethodInvocation(TemplateGapMethodInvocation that) {
        forTemplateGapMethodInvocationDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapMethodInvocationOnly(that);
    }

    public void forTemplateGapMathPrimary(TemplateGapMathPrimary that) {
        forTemplateGapMathPrimaryDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapMathPrimaryOnly(that);
    }

    public void forTemplateGapArrayExpr(TemplateGapArrayExpr that) {
        forTemplateGapArrayExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapArrayExprOnly(that);
    }

    public void forTemplateGapArrayElement(TemplateGapArrayElement that) {
        forTemplateGapArrayElementDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapArrayElementOnly(that);
    }

    public void forTemplateGapArrayElements(TemplateGapArrayElements that) {
        forTemplateGapArrayElementsDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapArrayElementsOnly(that);
    }


    public void recur(Expr that) {
        that.accept(this);
    }

    public void recurOnExprInfo(ExprInfo that) {
    }

    public void recurOnType(Type that) {
    }

    public void recurOnLhs(Lhs that) {
    }

    public void recurOnListOfLhs(List<Lhs> that) {
        for (Lhs elt : that) {
            recurOnLhs(elt);
        }
    }

    public void recurOnOptionOfFunctionalRef(Option<FunctionalRef> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnCompoundAssignmentInfo(CompoundAssignmentInfo that) {
    }

    public void recurOnListOfCompoundAssignmentInfo(List<CompoundAssignmentInfo> that) {
        for (CompoundAssignmentInfo elt : that) {
            recurOnCompoundAssignmentInfo(elt);
        }
    }

    public void recurOnOptionOfExpr(Option<Expr> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnListOfExpr(List<Expr> that) {
        for (Expr elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfBlock(List<Block> that) {
        for (Block elt : that) {
            recur(elt);
        }
    }

    public void recurOnCaseClause(CaseClause that) {
    }

    public void recurOnListOfCaseClause(List<CaseClause> that) {
        for (CaseClause elt : that) {
            recurOnCaseClause(elt);
        }
    }

    public void recurOnOptionOfBlock(Option<Block> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnIfClause(IfClause that) {
    }

    public void recurOnListOfIfClause(List<IfClause> that) {
        for (IfClause elt : that) {
            recurOnIfClause(elt);
        }
    }

    public void recurOnId(Id that) {
    }

    public void recurOnTraitTypeHeader(TraitTypeHeader that) {
    }

    public void recurOnSelfType(SelfType that) {
    }

    public void recurOnOptionOfSelfType(Option<SelfType> that) {
        if (!that.isNone()) recurOnSelfType(that.unwrap());
    }

    public void recurOnStaticArg(StaticArg that) {
    }

    public void recurOnListOfStaticArg(List<StaticArg> that) {
        for (StaticArg elt : that) {
            recurOnStaticArg(elt);
        }
    }

    public void recurOnCatch(Catch that) {
    }

    public void recurOnOptionOfCatch(Option<Catch> that) {
        if (!that.isNone()) recurOnCatch(that.unwrap());
    }

    public void recurOnBaseType(BaseType that) {
    }

    public void recurOnListOfBaseType(List<BaseType> that) {
        for (BaseType elt : that) {
            recurOnBaseType(elt);
        }
    }

    public void recurOnKeywordExpr(KeywordExpr that) {
    }

    public void recurOnListOfKeywordExpr(List<KeywordExpr> that) {
        for (KeywordExpr elt : that) {
            recurOnKeywordExpr(elt);
        }
    }

    public void recurOnTypecaseClause(TypecaseClause that) {
    }

    public void recurOnListOfTypecaseClause(List<TypecaseClause> that) {
        for (TypecaseClause elt : that) {
            recurOnTypecaseClause(elt);
        }
    }

    public void recurOnGeneratorClause(GeneratorClause that) {
    }

    public void recurOnListOfGeneratorClause(List<GeneratorClause> that) {
        for (GeneratorClause elt : that) {
            recurOnGeneratorClause(elt);
        }
    }

    public void recurOnOp(Op that) {
    }

    public void recurOnArrayComprehensionClause(ArrayComprehensionClause that) {
    }

    public void recurOnListOfArrayComprehensionClause(List<ArrayComprehensionClause> that) {
        for (ArrayComprehensionClause elt : that) {
            recurOnArrayComprehensionClause(elt);
        }
    }

    public void recurOnOptionOfId(Option<Id> that) {
        if (!that.isNone()) recurOnId(that.unwrap());
    }

    public void recurOnFnHeader(FnHeader that) {
    }

    public void recurOnFnDecl(FnDecl that) {
    }

    public void recurOnListOfFnDecl(List<FnDecl> that) {
        for (FnDecl elt : that) {
            recurOnFnDecl(elt);
        }
    }

    public void recurOnLValue(LValue that) {
    }

    public void recurOnListOfLValue(List<LValue> that) {
        for (LValue elt : that) {
            recurOnLValue(elt);
        }
    }

    public void recurOnOptionOfOp(Option<Op> that) {
        if (!that.isNone()) recurOnOp(that.unwrap());
    }

    public void recurOnIdOrOp(IdOrOp that) {
    }

    public void recurOnListOfIdOrOp(List<IdOrOp> that) {
        for (IdOrOp elt : that) {
            recurOnIdOrOp(elt);
        }
    }

    public void recurOnOverloading(Overloading that) {
    }

    public void recurOnListOfOverloading(List<Overloading> that) {
        for (Overloading elt : that) {
            recurOnOverloading(elt);
        }
    }

    public void recurOnOptionOfType(Option<Type> that) {
        if (!that.isNone()) recurOnType(that.unwrap());
    }

    public void recurOnLink(Link that) {
    }

    public void recurOnListOfLink(List<Link> that) {
        for (Link elt : that) {
            recurOnLink(elt);
        }
    }

    public void recurOnTraitType(TraitType that) {
    }

    public void recurOnTupleType(TupleType that) {
    }

    public void recurOnOptionOfCoercionInvocation(Option<CoercionInvocation> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnListOfOptionOfCoercionInvocation(List<Option<CoercionInvocation>> that) {
        for (Option<CoercionInvocation> elt : that) {
            recurOnOptionOfCoercionInvocation(elt);
        }
    }

    public void recurOnOptionOfOptionOfCoercionInvocation(Option<Option<CoercionInvocation>> that) {
        if (!that.isNone()) recurOnOptionOfCoercionInvocation(that.unwrap());
    }

    public void recurOnArrowType(ArrowType that) {
    }

    public void recurOnListOfType(List<Type> that) {
        for (Type elt : that) {
            recurOnType(elt);
        }
    }

    public void recurOnMathItem(MathItem that) {
    }

    public void recurOnListOfMathItem(List<MathItem> that) {
        for (MathItem elt : that) {
            recurOnMathItem(elt);
        }
    }

    public void recurOnListOfArrayExpr(List<ArrayExpr> that) {
        for (ArrayExpr elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfId(List<Id> that) {
        for (Id elt : that) {
            recurOnId(elt);
        }
    }
}
