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

/** An abstract implementation of a visitor over Expr that does not return a value.
 ** This visitor implements the visitor interface with methods that each 
 ** delegate to a case representing their superclass.  At the top of this
 ** delegation tree is the method defaultCase(), which (unless overridden)
 ** is a no-op.
 **/
@SuppressWarnings("unused")
public class ExprAbstractVisitor_void extends ExprVisitorRunnable1 {
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, it is a no-op; subclasses may override this behavior.
    **/
    public void defaultCase(Expr that) {}

    /* Methods to visit an item. */
    public void forExpr(Expr that) {
        defaultCase(that);
    }

    public void forDummyExpr(DummyExpr that) {
        forExpr(that);
    }

    public void forTypeAnnotatedExpr(TypeAnnotatedExpr that) {
        forExpr(that);
    }

    public void forAsExpr(AsExpr that) {
        forTypeAnnotatedExpr(that);
    }

    public void forAsIfExpr(AsIfExpr that) {
        forTypeAnnotatedExpr(that);
    }

    public void forAssignment(Assignment that) {
        forExpr(that);
    }

    public void forBlock(Block that) {
        forExpr(that);
    }

    public void forDo(Do that) {
        forExpr(that);
    }

    public void forCaseExpr(CaseExpr that) {
        forExpr(that);
    }

    public void forIf(If that) {
        forExpr(that);
    }

    public void forLabel(Label that) {
        forExpr(that);
    }

    public void forAbstractObjectExpr(AbstractObjectExpr that) {
        forExpr(that);
    }

    public void forObjectExpr(ObjectExpr that) {
        forAbstractObjectExpr(that);
    }

    public void for_RewriteObjectExpr(_RewriteObjectExpr that) {
        forAbstractObjectExpr(that);
    }

    public void forTry(Try that) {
        forExpr(that);
    }

    public void forTupleExpr(TupleExpr that) {
        forExpr(that);
    }

    public void forTypecase(Typecase that) {
        forExpr(that);
    }

    public void forWhile(While that) {
        forExpr(that);
    }

    public void forFor(For that) {
        forExpr(that);
    }

    public void forBigOpApp(BigOpApp that) {
        forExpr(that);
    }

    public void forAccumulator(Accumulator that) {
        forBigOpApp(that);
    }

    public void forArrayComprehension(ArrayComprehension that) {
        forBigOpApp(that);
    }

    public void forAtomicExpr(AtomicExpr that) {
        forExpr(that);
    }

    public void forExit(Exit that) {
        forExpr(that);
    }

    public void forSpawn(Spawn that) {
        forExpr(that);
    }

    public void forThrow(Throw that) {
        forExpr(that);
    }

    public void forTryAtomicExpr(TryAtomicExpr that) {
        forExpr(that);
    }

    public void forFnExpr(FnExpr that) {
        forExpr(that);
    }

    public void forLetExpr(LetExpr that) {
        forExpr(that);
    }

    public void forLetFn(LetFn that) {
        forLetExpr(that);
    }

    public void forLocalVarDecl(LocalVarDecl that) {
        forLetExpr(that);
    }

    public void forSimpleExpr(SimpleExpr that) {
        forExpr(that);
    }

    public void forSubscriptExpr(SubscriptExpr that) {
        forSimpleExpr(that);
    }

    public void forPrimary(Primary that) {
        forSimpleExpr(that);
    }

    public void forLiteralExpr(LiteralExpr that) {
        forPrimary(that);
    }

    public void forNumberLiteralExpr(NumberLiteralExpr that) {
        forLiteralExpr(that);
    }

    public void forFloatLiteralExpr(FloatLiteralExpr that) {
        forNumberLiteralExpr(that);
    }

    public void forIntLiteralExpr(IntLiteralExpr that) {
        forNumberLiteralExpr(that);
    }

    public void forCharLiteralExpr(CharLiteralExpr that) {
        forLiteralExpr(that);
    }

    public void forStringLiteralExpr(StringLiteralExpr that) {
        forLiteralExpr(that);
    }

    public void forVoidLiteralExpr(VoidLiteralExpr that) {
        forLiteralExpr(that);
    }

    public void forBooleanLiteralExpr(BooleanLiteralExpr that) {
        forLiteralExpr(that);
    }

    public void forVarRef(VarRef that) {
        forPrimary(that);
    }

    public void forFieldRef(FieldRef that) {
        forPrimary(that);
    }

    public void forFunctionalRef(FunctionalRef that) {
        forPrimary(that);
    }

    public void forFnRef(FnRef that) {
        forFunctionalRef(that);
    }

    public void forOpRef(OpRef that) {
        forFunctionalRef(that);
    }

    public void for_RewriteFnRef(_RewriteFnRef that) {
        forPrimary(that);
    }

    public void for_RewriteObjectExprRef(_RewriteObjectExprRef that) {
        forPrimary(that);
    }

    public void forJuxt(Juxt that) {
        forPrimary(that);
    }

    public void for_RewriteFnApp(_RewriteFnApp that) {
        forPrimary(that);
    }

    public void forOpExpr(OpExpr that) {
        forPrimary(that);
    }

    public void forAmbiguousMultifixOpExpr(AmbiguousMultifixOpExpr that) {
        forPrimary(that);
    }

    public void forChainExpr(ChainExpr that) {
        forPrimary(that);
    }

    public void forCoercionInvocation(CoercionInvocation that) {
        forPrimary(that);
    }

    public void forTraitCoercionInvocation(TraitCoercionInvocation that) {
        forCoercionInvocation(that);
    }

    public void forTupleCoercionInvocation(TupleCoercionInvocation that) {
        forCoercionInvocation(that);
    }

    public void forArrowCoercionInvocation(ArrowCoercionInvocation that) {
        forCoercionInvocation(that);
    }

    public void forUnionCoercionInvocation(UnionCoercionInvocation that) {
        forCoercionInvocation(that);
    }

    public void forMethodInvocation(MethodInvocation that) {
        forPrimary(that);
    }

    public void forMathPrimary(MathPrimary that) {
        forPrimary(that);
    }

    public void forArrayExpr(ArrayExpr that) {
        forPrimary(that);
    }

    public void forArrayElement(ArrayElement that) {
        forArrayExpr(that);
    }

    public void forArrayElements(ArrayElements that) {
        forArrayExpr(that);
    }

    public void for_SyntaxTransformationExpr(_SyntaxTransformationExpr that) {
        forExpr(that);
    }

    public void for_SyntaxTransformationDummyExpr(_SyntaxTransformationDummyExpr that) {
        forDummyExpr(that);
    }

    public void for_SyntaxTransformationTypeAnnotatedExpr(_SyntaxTransformationTypeAnnotatedExpr that) {
        forTypeAnnotatedExpr(that);
    }

    public void for_SyntaxTransformationAsExpr(_SyntaxTransformationAsExpr that) {
        forAsExpr(that);
    }

    public void for_SyntaxTransformationAsIfExpr(_SyntaxTransformationAsIfExpr that) {
        forAsIfExpr(that);
    }

    public void for_SyntaxTransformationAssignment(_SyntaxTransformationAssignment that) {
        forAssignment(that);
    }

    public void for_SyntaxTransformationBlock(_SyntaxTransformationBlock that) {
        forBlock(that);
    }

    public void for_SyntaxTransformationDo(_SyntaxTransformationDo that) {
        forDo(that);
    }

    public void for_SyntaxTransformationCaseExpr(_SyntaxTransformationCaseExpr that) {
        forCaseExpr(that);
    }

    public void for_SyntaxTransformationIf(_SyntaxTransformationIf that) {
        forIf(that);
    }

    public void for_SyntaxTransformationLabel(_SyntaxTransformationLabel that) {
        forLabel(that);
    }

    public void for_SyntaxTransformationAbstractObjectExpr(_SyntaxTransformationAbstractObjectExpr that) {
        forAbstractObjectExpr(that);
    }

    public void for_SyntaxTransformationObjectExpr(_SyntaxTransformationObjectExpr that) {
        forObjectExpr(that);
    }

    public void for_SyntaxTransformation_RewriteObjectExpr(_SyntaxTransformation_RewriteObjectExpr that) {
        for_RewriteObjectExpr(that);
    }

    public void for_SyntaxTransformationTry(_SyntaxTransformationTry that) {
        forTry(that);
    }

    public void for_SyntaxTransformationTupleExpr(_SyntaxTransformationTupleExpr that) {
        forTupleExpr(that);
    }

    public void for_SyntaxTransformationTypecase(_SyntaxTransformationTypecase that) {
        forTypecase(that);
    }

    public void for_SyntaxTransformationWhile(_SyntaxTransformationWhile that) {
        forWhile(that);
    }

    public void for_SyntaxTransformationFor(_SyntaxTransformationFor that) {
        forFor(that);
    }

    public void for_SyntaxTransformationBigOpApp(_SyntaxTransformationBigOpApp that) {
        forBigOpApp(that);
    }

    public void for_SyntaxTransformationAccumulator(_SyntaxTransformationAccumulator that) {
        forAccumulator(that);
    }

    public void for_SyntaxTransformationArrayComprehension(_SyntaxTransformationArrayComprehension that) {
        forArrayComprehension(that);
    }

    public void for_SyntaxTransformationAtomicExpr(_SyntaxTransformationAtomicExpr that) {
        forAtomicExpr(that);
    }

    public void for_SyntaxTransformationExit(_SyntaxTransformationExit that) {
        forExit(that);
    }

    public void for_SyntaxTransformationSpawn(_SyntaxTransformationSpawn that) {
        forSpawn(that);
    }

    public void for_SyntaxTransformationThrow(_SyntaxTransformationThrow that) {
        forThrow(that);
    }

    public void for_SyntaxTransformationTryAtomicExpr(_SyntaxTransformationTryAtomicExpr that) {
        forTryAtomicExpr(that);
    }

    public void for_SyntaxTransformationFnExpr(_SyntaxTransformationFnExpr that) {
        forFnExpr(that);
    }

    public void for_SyntaxTransformationLetExpr(_SyntaxTransformationLetExpr that) {
        forLetExpr(that);
    }

    public void for_SyntaxTransformationLetFn(_SyntaxTransformationLetFn that) {
        forLetFn(that);
    }

    public void for_SyntaxTransformationLocalVarDecl(_SyntaxTransformationLocalVarDecl that) {
        forLocalVarDecl(that);
    }

    public void for_SyntaxTransformationSimpleExpr(_SyntaxTransformationSimpleExpr that) {
        forSimpleExpr(that);
    }

    public void for_SyntaxTransformationSubscriptExpr(_SyntaxTransformationSubscriptExpr that) {
        forSubscriptExpr(that);
    }

    public void for_SyntaxTransformationPrimary(_SyntaxTransformationPrimary that) {
        forPrimary(that);
    }

    public void for_SyntaxTransformationLiteralExpr(_SyntaxTransformationLiteralExpr that) {
        forLiteralExpr(that);
    }

    public void for_SyntaxTransformationNumberLiteralExpr(_SyntaxTransformationNumberLiteralExpr that) {
        forNumberLiteralExpr(that);
    }

    public void for_SyntaxTransformationFloatLiteralExpr(_SyntaxTransformationFloatLiteralExpr that) {
        forFloatLiteralExpr(that);
    }

    public void for_SyntaxTransformationIntLiteralExpr(_SyntaxTransformationIntLiteralExpr that) {
        forIntLiteralExpr(that);
    }

    public void for_SyntaxTransformationCharLiteralExpr(_SyntaxTransformationCharLiteralExpr that) {
        forCharLiteralExpr(that);
    }

    public void for_SyntaxTransformationStringLiteralExpr(_SyntaxTransformationStringLiteralExpr that) {
        forStringLiteralExpr(that);
    }

    public void for_SyntaxTransformationVoidLiteralExpr(_SyntaxTransformationVoidLiteralExpr that) {
        forVoidLiteralExpr(that);
    }

    public void for_SyntaxTransformationBooleanLiteralExpr(_SyntaxTransformationBooleanLiteralExpr that) {
        forBooleanLiteralExpr(that);
    }

    public void for_SyntaxTransformationVarRef(_SyntaxTransformationVarRef that) {
        forVarRef(that);
    }

    public void for_SyntaxTransformationFieldRef(_SyntaxTransformationFieldRef that) {
        forFieldRef(that);
    }

    public void for_SyntaxTransformationFunctionalRef(_SyntaxTransformationFunctionalRef that) {
        forFunctionalRef(that);
    }

    public void for_SyntaxTransformationFnRef(_SyntaxTransformationFnRef that) {
        forFnRef(that);
    }

    public void for_SyntaxTransformationOpRef(_SyntaxTransformationOpRef that) {
        forOpRef(that);
    }

    public void for_SyntaxTransformation_RewriteFnRef(_SyntaxTransformation_RewriteFnRef that) {
        for_RewriteFnRef(that);
    }

    public void for_SyntaxTransformation_RewriteObjectExprRef(_SyntaxTransformation_RewriteObjectExprRef that) {
        for_RewriteObjectExprRef(that);
    }

    public void for_SyntaxTransformationJuxt(_SyntaxTransformationJuxt that) {
        forJuxt(that);
    }

    public void for_SyntaxTransformation_RewriteFnApp(_SyntaxTransformation_RewriteFnApp that) {
        for_RewriteFnApp(that);
    }

    public void for_SyntaxTransformationOpExpr(_SyntaxTransformationOpExpr that) {
        forOpExpr(that);
    }

    public void for_SyntaxTransformationAmbiguousMultifixOpExpr(_SyntaxTransformationAmbiguousMultifixOpExpr that) {
        forAmbiguousMultifixOpExpr(that);
    }

    public void for_SyntaxTransformationChainExpr(_SyntaxTransformationChainExpr that) {
        forChainExpr(that);
    }

    public void for_SyntaxTransformationCoercionInvocation(_SyntaxTransformationCoercionInvocation that) {
        forCoercionInvocation(that);
    }

    public void for_SyntaxTransformationTraitCoercionInvocation(_SyntaxTransformationTraitCoercionInvocation that) {
        forTraitCoercionInvocation(that);
    }

    public void for_SyntaxTransformationTupleCoercionInvocation(_SyntaxTransformationTupleCoercionInvocation that) {
        forTupleCoercionInvocation(that);
    }

    public void for_SyntaxTransformationArrowCoercionInvocation(_SyntaxTransformationArrowCoercionInvocation that) {
        forArrowCoercionInvocation(that);
    }

    public void for_SyntaxTransformationUnionCoercionInvocation(_SyntaxTransformationUnionCoercionInvocation that) {
        forUnionCoercionInvocation(that);
    }

    public void for_SyntaxTransformationMethodInvocation(_SyntaxTransformationMethodInvocation that) {
        forMethodInvocation(that);
    }

    public void for_SyntaxTransformationMathPrimary(_SyntaxTransformationMathPrimary that) {
        forMathPrimary(that);
    }

    public void for_SyntaxTransformationArrayExpr(_SyntaxTransformationArrayExpr that) {
        forArrayExpr(that);
    }

    public void for_SyntaxTransformationArrayElement(_SyntaxTransformationArrayElement that) {
        forArrayElement(that);
    }

    public void for_SyntaxTransformationArrayElements(_SyntaxTransformationArrayElements that) {
        forArrayElements(that);
    }

    public void for_EllipsesExpr(_EllipsesExpr that) {
        forExpr(that);
    }

    public void for_EllipsesDummyExpr(_EllipsesDummyExpr that) {
        forDummyExpr(that);
    }

    public void for_EllipsesTypeAnnotatedExpr(_EllipsesTypeAnnotatedExpr that) {
        forTypeAnnotatedExpr(that);
    }

    public void for_EllipsesAsExpr(_EllipsesAsExpr that) {
        forAsExpr(that);
    }

    public void for_EllipsesAsIfExpr(_EllipsesAsIfExpr that) {
        forAsIfExpr(that);
    }

    public void for_EllipsesAssignment(_EllipsesAssignment that) {
        forAssignment(that);
    }

    public void for_EllipsesBlock(_EllipsesBlock that) {
        forBlock(that);
    }

    public void for_EllipsesDo(_EllipsesDo that) {
        forDo(that);
    }

    public void for_EllipsesCaseExpr(_EllipsesCaseExpr that) {
        forCaseExpr(that);
    }

    public void for_EllipsesIf(_EllipsesIf that) {
        forIf(that);
    }

    public void for_EllipsesLabel(_EllipsesLabel that) {
        forLabel(that);
    }

    public void for_EllipsesAbstractObjectExpr(_EllipsesAbstractObjectExpr that) {
        forAbstractObjectExpr(that);
    }

    public void for_EllipsesObjectExpr(_EllipsesObjectExpr that) {
        forObjectExpr(that);
    }

    public void for_Ellipses_RewriteObjectExpr(_Ellipses_RewriteObjectExpr that) {
        for_RewriteObjectExpr(that);
    }

    public void for_EllipsesTry(_EllipsesTry that) {
        forTry(that);
    }

    public void for_EllipsesTupleExpr(_EllipsesTupleExpr that) {
        forTupleExpr(that);
    }

    public void for_EllipsesTypecase(_EllipsesTypecase that) {
        forTypecase(that);
    }

    public void for_EllipsesWhile(_EllipsesWhile that) {
        forWhile(that);
    }

    public void for_EllipsesFor(_EllipsesFor that) {
        forFor(that);
    }

    public void for_EllipsesBigOpApp(_EllipsesBigOpApp that) {
        forBigOpApp(that);
    }

    public void for_EllipsesAccumulator(_EllipsesAccumulator that) {
        forAccumulator(that);
    }

    public void for_EllipsesArrayComprehension(_EllipsesArrayComprehension that) {
        forArrayComprehension(that);
    }

    public void for_EllipsesAtomicExpr(_EllipsesAtomicExpr that) {
        forAtomicExpr(that);
    }

    public void for_EllipsesExit(_EllipsesExit that) {
        forExit(that);
    }

    public void for_EllipsesSpawn(_EllipsesSpawn that) {
        forSpawn(that);
    }

    public void for_EllipsesThrow(_EllipsesThrow that) {
        forThrow(that);
    }

    public void for_EllipsesTryAtomicExpr(_EllipsesTryAtomicExpr that) {
        forTryAtomicExpr(that);
    }

    public void for_EllipsesFnExpr(_EllipsesFnExpr that) {
        forFnExpr(that);
    }

    public void for_EllipsesLetExpr(_EllipsesLetExpr that) {
        forLetExpr(that);
    }

    public void for_EllipsesLetFn(_EllipsesLetFn that) {
        forLetFn(that);
    }

    public void for_EllipsesLocalVarDecl(_EllipsesLocalVarDecl that) {
        forLocalVarDecl(that);
    }

    public void for_EllipsesSimpleExpr(_EllipsesSimpleExpr that) {
        forSimpleExpr(that);
    }

    public void for_EllipsesSubscriptExpr(_EllipsesSubscriptExpr that) {
        forSubscriptExpr(that);
    }

    public void for_EllipsesPrimary(_EllipsesPrimary that) {
        forPrimary(that);
    }

    public void for_EllipsesLiteralExpr(_EllipsesLiteralExpr that) {
        forLiteralExpr(that);
    }

    public void for_EllipsesNumberLiteralExpr(_EllipsesNumberLiteralExpr that) {
        forNumberLiteralExpr(that);
    }

    public void for_EllipsesFloatLiteralExpr(_EllipsesFloatLiteralExpr that) {
        forFloatLiteralExpr(that);
    }

    public void for_EllipsesIntLiteralExpr(_EllipsesIntLiteralExpr that) {
        forIntLiteralExpr(that);
    }

    public void for_EllipsesCharLiteralExpr(_EllipsesCharLiteralExpr that) {
        forCharLiteralExpr(that);
    }

    public void for_EllipsesStringLiteralExpr(_EllipsesStringLiteralExpr that) {
        forStringLiteralExpr(that);
    }

    public void for_EllipsesVoidLiteralExpr(_EllipsesVoidLiteralExpr that) {
        forVoidLiteralExpr(that);
    }

    public void for_EllipsesBooleanLiteralExpr(_EllipsesBooleanLiteralExpr that) {
        forBooleanLiteralExpr(that);
    }

    public void for_EllipsesVarRef(_EllipsesVarRef that) {
        forVarRef(that);
    }

    public void for_EllipsesFieldRef(_EllipsesFieldRef that) {
        forFieldRef(that);
    }

    public void for_EllipsesFunctionalRef(_EllipsesFunctionalRef that) {
        forFunctionalRef(that);
    }

    public void for_EllipsesFnRef(_EllipsesFnRef that) {
        forFnRef(that);
    }

    public void for_EllipsesOpRef(_EllipsesOpRef that) {
        forOpRef(that);
    }

    public void for_Ellipses_RewriteFnRef(_Ellipses_RewriteFnRef that) {
        for_RewriteFnRef(that);
    }

    public void for_Ellipses_RewriteObjectExprRef(_Ellipses_RewriteObjectExprRef that) {
        for_RewriteObjectExprRef(that);
    }

    public void for_EllipsesJuxt(_EllipsesJuxt that) {
        forJuxt(that);
    }

    public void for_Ellipses_RewriteFnApp(_Ellipses_RewriteFnApp that) {
        for_RewriteFnApp(that);
    }

    public void for_EllipsesOpExpr(_EllipsesOpExpr that) {
        forOpExpr(that);
    }

    public void for_EllipsesAmbiguousMultifixOpExpr(_EllipsesAmbiguousMultifixOpExpr that) {
        forAmbiguousMultifixOpExpr(that);
    }

    public void for_EllipsesChainExpr(_EllipsesChainExpr that) {
        forChainExpr(that);
    }

    public void for_EllipsesCoercionInvocation(_EllipsesCoercionInvocation that) {
        forCoercionInvocation(that);
    }

    public void for_EllipsesTraitCoercionInvocation(_EllipsesTraitCoercionInvocation that) {
        forTraitCoercionInvocation(that);
    }

    public void for_EllipsesTupleCoercionInvocation(_EllipsesTupleCoercionInvocation that) {
        forTupleCoercionInvocation(that);
    }

    public void for_EllipsesArrowCoercionInvocation(_EllipsesArrowCoercionInvocation that) {
        forArrowCoercionInvocation(that);
    }

    public void for_EllipsesUnionCoercionInvocation(_EllipsesUnionCoercionInvocation that) {
        forUnionCoercionInvocation(that);
    }

    public void for_EllipsesMethodInvocation(_EllipsesMethodInvocation that) {
        forMethodInvocation(that);
    }

    public void for_EllipsesMathPrimary(_EllipsesMathPrimary that) {
        forMathPrimary(that);
    }

    public void for_EllipsesArrayExpr(_EllipsesArrayExpr that) {
        forArrayExpr(that);
    }

    public void for_EllipsesArrayElement(_EllipsesArrayElement that) {
        forArrayElement(that);
    }

    public void for_EllipsesArrayElements(_EllipsesArrayElements that) {
        forArrayElements(that);
    }

    public void forTemplateGapExpr(TemplateGapExpr that) {
        forExpr(that);
    }

    public void forTemplateGapDummyExpr(TemplateGapDummyExpr that) {
        forDummyExpr(that);
    }

    public void forTemplateGapTypeAnnotatedExpr(TemplateGapTypeAnnotatedExpr that) {
        forTypeAnnotatedExpr(that);
    }

    public void forTemplateGapAsExpr(TemplateGapAsExpr that) {
        forAsExpr(that);
    }

    public void forTemplateGapAsIfExpr(TemplateGapAsIfExpr that) {
        forAsIfExpr(that);
    }

    public void forTemplateGapAssignment(TemplateGapAssignment that) {
        forAssignment(that);
    }

    public void forTemplateGapBlock(TemplateGapBlock that) {
        forBlock(that);
    }

    public void forTemplateGapDo(TemplateGapDo that) {
        forDo(that);
    }

    public void forTemplateGapCaseExpr(TemplateGapCaseExpr that) {
        forCaseExpr(that);
    }

    public void forTemplateGapIf(TemplateGapIf that) {
        forIf(that);
    }

    public void forTemplateGapLabel(TemplateGapLabel that) {
        forLabel(that);
    }

    public void forTemplateGapAbstractObjectExpr(TemplateGapAbstractObjectExpr that) {
        forAbstractObjectExpr(that);
    }

    public void forTemplateGapObjectExpr(TemplateGapObjectExpr that) {
        forObjectExpr(that);
    }

    public void forTemplateGap_RewriteObjectExpr(TemplateGap_RewriteObjectExpr that) {
        for_RewriteObjectExpr(that);
    }

    public void forTemplateGapTry(TemplateGapTry that) {
        forTry(that);
    }

    public void forTemplateGapTupleExpr(TemplateGapTupleExpr that) {
        forTupleExpr(that);
    }

    public void forTemplateGapTypecase(TemplateGapTypecase that) {
        forTypecase(that);
    }

    public void forTemplateGapWhile(TemplateGapWhile that) {
        forWhile(that);
    }

    public void forTemplateGapFor(TemplateGapFor that) {
        forFor(that);
    }

    public void forTemplateGapBigOpApp(TemplateGapBigOpApp that) {
        forBigOpApp(that);
    }

    public void forTemplateGapAccumulator(TemplateGapAccumulator that) {
        forAccumulator(that);
    }

    public void forTemplateGapArrayComprehension(TemplateGapArrayComprehension that) {
        forArrayComprehension(that);
    }

    public void forTemplateGapAtomicExpr(TemplateGapAtomicExpr that) {
        forAtomicExpr(that);
    }

    public void forTemplateGapExit(TemplateGapExit that) {
        forExit(that);
    }

    public void forTemplateGapSpawn(TemplateGapSpawn that) {
        forSpawn(that);
    }

    public void forTemplateGapThrow(TemplateGapThrow that) {
        forThrow(that);
    }

    public void forTemplateGapTryAtomicExpr(TemplateGapTryAtomicExpr that) {
        forTryAtomicExpr(that);
    }

    public void forTemplateGapFnExpr(TemplateGapFnExpr that) {
        forFnExpr(that);
    }

    public void forTemplateGapLetExpr(TemplateGapLetExpr that) {
        forLetExpr(that);
    }

    public void forTemplateGapLetFn(TemplateGapLetFn that) {
        forLetFn(that);
    }

    public void forTemplateGapLocalVarDecl(TemplateGapLocalVarDecl that) {
        forLocalVarDecl(that);
    }

    public void forTemplateGapSimpleExpr(TemplateGapSimpleExpr that) {
        forSimpleExpr(that);
    }

    public void forTemplateGapSubscriptExpr(TemplateGapSubscriptExpr that) {
        forSubscriptExpr(that);
    }

    public void forTemplateGapPrimary(TemplateGapPrimary that) {
        forPrimary(that);
    }

    public void forTemplateGapLiteralExpr(TemplateGapLiteralExpr that) {
        forLiteralExpr(that);
    }

    public void forTemplateGapNumberLiteralExpr(TemplateGapNumberLiteralExpr that) {
        forNumberLiteralExpr(that);
    }

    public void forTemplateGapFloatLiteralExpr(TemplateGapFloatLiteralExpr that) {
        forFloatLiteralExpr(that);
    }

    public void forTemplateGapIntLiteralExpr(TemplateGapIntLiteralExpr that) {
        forIntLiteralExpr(that);
    }

    public void forTemplateGapCharLiteralExpr(TemplateGapCharLiteralExpr that) {
        forCharLiteralExpr(that);
    }

    public void forTemplateGapStringLiteralExpr(TemplateGapStringLiteralExpr that) {
        forStringLiteralExpr(that);
    }

    public void forTemplateGapVoidLiteralExpr(TemplateGapVoidLiteralExpr that) {
        forVoidLiteralExpr(that);
    }

    public void forTemplateGapBooleanLiteralExpr(TemplateGapBooleanLiteralExpr that) {
        forBooleanLiteralExpr(that);
    }

    public void forTemplateGapVarRef(TemplateGapVarRef that) {
        forVarRef(that);
    }

    public void forTemplateGapFieldRef(TemplateGapFieldRef that) {
        forFieldRef(that);
    }

    public void forTemplateGapFunctionalRef(TemplateGapFunctionalRef that) {
        forFunctionalRef(that);
    }

    public void forTemplateGapFnRef(TemplateGapFnRef that) {
        forFnRef(that);
    }

    public void forTemplateGapOpRef(TemplateGapOpRef that) {
        forOpRef(that);
    }

    public void forTemplateGap_RewriteFnRef(TemplateGap_RewriteFnRef that) {
        for_RewriteFnRef(that);
    }

    public void forTemplateGap_RewriteObjectExprRef(TemplateGap_RewriteObjectExprRef that) {
        for_RewriteObjectExprRef(that);
    }

    public void forTemplateGapJuxt(TemplateGapJuxt that) {
        forJuxt(that);
    }

    public void forTemplateGap_RewriteFnApp(TemplateGap_RewriteFnApp that) {
        for_RewriteFnApp(that);
    }

    public void forTemplateGapOpExpr(TemplateGapOpExpr that) {
        forOpExpr(that);
    }

    public void forTemplateGapAmbiguousMultifixOpExpr(TemplateGapAmbiguousMultifixOpExpr that) {
        forAmbiguousMultifixOpExpr(that);
    }

    public void forTemplateGapChainExpr(TemplateGapChainExpr that) {
        forChainExpr(that);
    }

    public void forTemplateGapCoercionInvocation(TemplateGapCoercionInvocation that) {
        forCoercionInvocation(that);
    }

    public void forTemplateGapTraitCoercionInvocation(TemplateGapTraitCoercionInvocation that) {
        forTraitCoercionInvocation(that);
    }

    public void forTemplateGapTupleCoercionInvocation(TemplateGapTupleCoercionInvocation that) {
        forTupleCoercionInvocation(that);
    }

    public void forTemplateGapArrowCoercionInvocation(TemplateGapArrowCoercionInvocation that) {
        forArrowCoercionInvocation(that);
    }

    public void forTemplateGapUnionCoercionInvocation(TemplateGapUnionCoercionInvocation that) {
        forUnionCoercionInvocation(that);
    }

    public void forTemplateGapMethodInvocation(TemplateGapMethodInvocation that) {
        forMethodInvocation(that);
    }

    public void forTemplateGapMathPrimary(TemplateGapMathPrimary that) {
        forMathPrimary(that);
    }

    public void forTemplateGapArrayExpr(TemplateGapArrayExpr that) {
        forArrayExpr(that);
    }

    public void forTemplateGapArrayElement(TemplateGapArrayElement that) {
        forArrayElement(that);
    }

    public void forTemplateGapArrayElements(TemplateGapArrayElements that) {
        forArrayElements(that);
    }

}
