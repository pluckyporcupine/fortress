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

/** A parametric abstract implementation of a visitor over Expr that return a value.
 ** This visitor implements the visitor interface with methods that each 
 ** delegate to a case representing their superclass.  At the top of this
 ** delegation tree is the method defaultCase(), which (unless overridden)
 ** throws an exception.
 **/
@SuppressWarnings("unused")
public abstract class ExprAbstractVisitor<RetType>  extends ExprVisitorLambda<RetType> {
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, an exception is thrown; subclasses may override this behavior.
     * @throws IllegalArgumentException
    **/
    public RetType defaultCase(Expr that) {
        throw new IllegalArgumentException("Visitor " + getClass().getName() + " does not support visiting values of type " + that.getClass().getName());
    }

    /* Methods to visit an item. */
    public RetType forExpr(Expr that) {
        return defaultCase(that);
    }

    public RetType forDummyExpr(DummyExpr that) {
        return forExpr(that);
    }

    public RetType forTypeAnnotatedExpr(TypeAnnotatedExpr that) {
        return forExpr(that);
    }

    public RetType forAsExpr(AsExpr that) {
        return forTypeAnnotatedExpr(that);
    }

    public RetType forAsIfExpr(AsIfExpr that) {
        return forTypeAnnotatedExpr(that);
    }

    public RetType forAssignment(Assignment that) {
        return forExpr(that);
    }

    public RetType forBlock(Block that) {
        return forExpr(that);
    }

    public RetType forDo(Do that) {
        return forExpr(that);
    }

    public RetType forCaseExpr(CaseExpr that) {
        return forExpr(that);
    }

    public RetType forIf(If that) {
        return forExpr(that);
    }

    public RetType forLabel(Label that) {
        return forExpr(that);
    }

    public RetType forAbstractObjectExpr(AbstractObjectExpr that) {
        return forExpr(that);
    }

    public RetType forObjectExpr(ObjectExpr that) {
        return forAbstractObjectExpr(that);
    }

    public RetType for_RewriteObjectExpr(_RewriteObjectExpr that) {
        return forAbstractObjectExpr(that);
    }

    public RetType forTry(Try that) {
        return forExpr(that);
    }

    public RetType forTupleExpr(TupleExpr that) {
        return forExpr(that);
    }

    public RetType forTypecase(Typecase that) {
        return forExpr(that);
    }

    public RetType forWhile(While that) {
        return forExpr(that);
    }

    public RetType forFor(For that) {
        return forExpr(that);
    }

    public RetType forBigOpApp(BigOpApp that) {
        return forExpr(that);
    }

    public RetType forAccumulator(Accumulator that) {
        return forBigOpApp(that);
    }

    public RetType forArrayComprehension(ArrayComprehension that) {
        return forBigOpApp(that);
    }

    public RetType forAtomicExpr(AtomicExpr that) {
        return forExpr(that);
    }

    public RetType forExit(Exit that) {
        return forExpr(that);
    }

    public RetType forSpawn(Spawn that) {
        return forExpr(that);
    }

    public RetType forThrow(Throw that) {
        return forExpr(that);
    }

    public RetType forTryAtomicExpr(TryAtomicExpr that) {
        return forExpr(that);
    }

    public RetType forFnExpr(FnExpr that) {
        return forExpr(that);
    }

    public RetType forLetExpr(LetExpr that) {
        return forExpr(that);
    }

    public RetType forLetFn(LetFn that) {
        return forLetExpr(that);
    }

    public RetType forLocalVarDecl(LocalVarDecl that) {
        return forLetExpr(that);
    }

    public RetType forSimpleExpr(SimpleExpr that) {
        return forExpr(that);
    }

    public RetType forSubscriptExpr(SubscriptExpr that) {
        return forSimpleExpr(that);
    }

    public RetType forPrimary(Primary that) {
        return forSimpleExpr(that);
    }

    public RetType forLiteralExpr(LiteralExpr that) {
        return forPrimary(that);
    }

    public RetType forNumberLiteralExpr(NumberLiteralExpr that) {
        return forLiteralExpr(that);
    }

    public RetType forFloatLiteralExpr(FloatLiteralExpr that) {
        return forNumberLiteralExpr(that);
    }

    public RetType forIntLiteralExpr(IntLiteralExpr that) {
        return forNumberLiteralExpr(that);
    }

    public RetType forCharLiteralExpr(CharLiteralExpr that) {
        return forLiteralExpr(that);
    }

    public RetType forStringLiteralExpr(StringLiteralExpr that) {
        return forLiteralExpr(that);
    }

    public RetType forVoidLiteralExpr(VoidLiteralExpr that) {
        return forLiteralExpr(that);
    }

    public RetType forBooleanLiteralExpr(BooleanLiteralExpr that) {
        return forLiteralExpr(that);
    }

    public RetType forVarRef(VarRef that) {
        return forPrimary(that);
    }

    public RetType forFieldRef(FieldRef that) {
        return forPrimary(that);
    }

    public RetType forFunctionalRef(FunctionalRef that) {
        return forPrimary(that);
    }

    public RetType forFnRef(FnRef that) {
        return forFunctionalRef(that);
    }

    public RetType forOpRef(OpRef that) {
        return forFunctionalRef(that);
    }

    public RetType for_RewriteFnRef(_RewriteFnRef that) {
        return forPrimary(that);
    }

    public RetType for_RewriteObjectExprRef(_RewriteObjectExprRef that) {
        return forPrimary(that);
    }

    public RetType forJuxt(Juxt that) {
        return forPrimary(that);
    }

    public RetType for_RewriteFnApp(_RewriteFnApp that) {
        return forPrimary(that);
    }

    public RetType forOpExpr(OpExpr that) {
        return forPrimary(that);
    }

    public RetType forAmbiguousMultifixOpExpr(AmbiguousMultifixOpExpr that) {
        return forPrimary(that);
    }

    public RetType forChainExpr(ChainExpr that) {
        return forPrimary(that);
    }

    public RetType forCoercionInvocation(CoercionInvocation that) {
        return forPrimary(that);
    }

    public RetType forTraitCoercionInvocation(TraitCoercionInvocation that) {
        return forCoercionInvocation(that);
    }

    public RetType forTupleCoercionInvocation(TupleCoercionInvocation that) {
        return forCoercionInvocation(that);
    }

    public RetType forArrowCoercionInvocation(ArrowCoercionInvocation that) {
        return forCoercionInvocation(that);
    }

    public RetType forUnionCoercionInvocation(UnionCoercionInvocation that) {
        return forCoercionInvocation(that);
    }

    public RetType forMethodInvocation(MethodInvocation that) {
        return forPrimary(that);
    }

    public RetType forMathPrimary(MathPrimary that) {
        return forPrimary(that);
    }

    public RetType forArrayExpr(ArrayExpr that) {
        return forPrimary(that);
    }

    public RetType forArrayElement(ArrayElement that) {
        return forArrayExpr(that);
    }

    public RetType forArrayElements(ArrayElements that) {
        return forArrayExpr(that);
    }

    public RetType for_SyntaxTransformationExpr(_SyntaxTransformationExpr that) {
        return forExpr(that);
    }

    public RetType for_SyntaxTransformationDummyExpr(_SyntaxTransformationDummyExpr that) {
        return forDummyExpr(that);
    }

    public RetType for_SyntaxTransformationTypeAnnotatedExpr(_SyntaxTransformationTypeAnnotatedExpr that) {
        return forTypeAnnotatedExpr(that);
    }

    public RetType for_SyntaxTransformationAsExpr(_SyntaxTransformationAsExpr that) {
        return forAsExpr(that);
    }

    public RetType for_SyntaxTransformationAsIfExpr(_SyntaxTransformationAsIfExpr that) {
        return forAsIfExpr(that);
    }

    public RetType for_SyntaxTransformationAssignment(_SyntaxTransformationAssignment that) {
        return forAssignment(that);
    }

    public RetType for_SyntaxTransformationBlock(_SyntaxTransformationBlock that) {
        return forBlock(that);
    }

    public RetType for_SyntaxTransformationDo(_SyntaxTransformationDo that) {
        return forDo(that);
    }

    public RetType for_SyntaxTransformationCaseExpr(_SyntaxTransformationCaseExpr that) {
        return forCaseExpr(that);
    }

    public RetType for_SyntaxTransformationIf(_SyntaxTransformationIf that) {
        return forIf(that);
    }

    public RetType for_SyntaxTransformationLabel(_SyntaxTransformationLabel that) {
        return forLabel(that);
    }

    public RetType for_SyntaxTransformationAbstractObjectExpr(_SyntaxTransformationAbstractObjectExpr that) {
        return forAbstractObjectExpr(that);
    }

    public RetType for_SyntaxTransformationObjectExpr(_SyntaxTransformationObjectExpr that) {
        return forObjectExpr(that);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExpr(_SyntaxTransformation_RewriteObjectExpr that) {
        return for_RewriteObjectExpr(that);
    }

    public RetType for_SyntaxTransformationTry(_SyntaxTransformationTry that) {
        return forTry(that);
    }

    public RetType for_SyntaxTransformationTupleExpr(_SyntaxTransformationTupleExpr that) {
        return forTupleExpr(that);
    }

    public RetType for_SyntaxTransformationTypecase(_SyntaxTransformationTypecase that) {
        return forTypecase(that);
    }

    public RetType for_SyntaxTransformationWhile(_SyntaxTransformationWhile that) {
        return forWhile(that);
    }

    public RetType for_SyntaxTransformationFor(_SyntaxTransformationFor that) {
        return forFor(that);
    }

    public RetType for_SyntaxTransformationBigOpApp(_SyntaxTransformationBigOpApp that) {
        return forBigOpApp(that);
    }

    public RetType for_SyntaxTransformationAccumulator(_SyntaxTransformationAccumulator that) {
        return forAccumulator(that);
    }

    public RetType for_SyntaxTransformationArrayComprehension(_SyntaxTransformationArrayComprehension that) {
        return forArrayComprehension(that);
    }

    public RetType for_SyntaxTransformationAtomicExpr(_SyntaxTransformationAtomicExpr that) {
        return forAtomicExpr(that);
    }

    public RetType for_SyntaxTransformationExit(_SyntaxTransformationExit that) {
        return forExit(that);
    }

    public RetType for_SyntaxTransformationSpawn(_SyntaxTransformationSpawn that) {
        return forSpawn(that);
    }

    public RetType for_SyntaxTransformationThrow(_SyntaxTransformationThrow that) {
        return forThrow(that);
    }

    public RetType for_SyntaxTransformationTryAtomicExpr(_SyntaxTransformationTryAtomicExpr that) {
        return forTryAtomicExpr(that);
    }

    public RetType for_SyntaxTransformationFnExpr(_SyntaxTransformationFnExpr that) {
        return forFnExpr(that);
    }

    public RetType for_SyntaxTransformationLetExpr(_SyntaxTransformationLetExpr that) {
        return forLetExpr(that);
    }

    public RetType for_SyntaxTransformationLetFn(_SyntaxTransformationLetFn that) {
        return forLetFn(that);
    }

    public RetType for_SyntaxTransformationLocalVarDecl(_SyntaxTransformationLocalVarDecl that) {
        return forLocalVarDecl(that);
    }

    public RetType for_SyntaxTransformationSimpleExpr(_SyntaxTransformationSimpleExpr that) {
        return forSimpleExpr(that);
    }

    public RetType for_SyntaxTransformationSubscriptExpr(_SyntaxTransformationSubscriptExpr that) {
        return forSubscriptExpr(that);
    }

    public RetType for_SyntaxTransformationPrimary(_SyntaxTransformationPrimary that) {
        return forPrimary(that);
    }

    public RetType for_SyntaxTransformationLiteralExpr(_SyntaxTransformationLiteralExpr that) {
        return forLiteralExpr(that);
    }

    public RetType for_SyntaxTransformationNumberLiteralExpr(_SyntaxTransformationNumberLiteralExpr that) {
        return forNumberLiteralExpr(that);
    }

    public RetType for_SyntaxTransformationFloatLiteralExpr(_SyntaxTransformationFloatLiteralExpr that) {
        return forFloatLiteralExpr(that);
    }

    public RetType for_SyntaxTransformationIntLiteralExpr(_SyntaxTransformationIntLiteralExpr that) {
        return forIntLiteralExpr(that);
    }

    public RetType for_SyntaxTransformationCharLiteralExpr(_SyntaxTransformationCharLiteralExpr that) {
        return forCharLiteralExpr(that);
    }

    public RetType for_SyntaxTransformationStringLiteralExpr(_SyntaxTransformationStringLiteralExpr that) {
        return forStringLiteralExpr(that);
    }

    public RetType for_SyntaxTransformationVoidLiteralExpr(_SyntaxTransformationVoidLiteralExpr that) {
        return forVoidLiteralExpr(that);
    }

    public RetType for_SyntaxTransformationBooleanLiteralExpr(_SyntaxTransformationBooleanLiteralExpr that) {
        return forBooleanLiteralExpr(that);
    }

    public RetType for_SyntaxTransformationVarRef(_SyntaxTransformationVarRef that) {
        return forVarRef(that);
    }

    public RetType for_SyntaxTransformationFieldRef(_SyntaxTransformationFieldRef that) {
        return forFieldRef(that);
    }

    public RetType for_SyntaxTransformationFunctionalRef(_SyntaxTransformationFunctionalRef that) {
        return forFunctionalRef(that);
    }

    public RetType for_SyntaxTransformationFnRef(_SyntaxTransformationFnRef that) {
        return forFnRef(that);
    }

    public RetType for_SyntaxTransformationOpRef(_SyntaxTransformationOpRef that) {
        return forOpRef(that);
    }

    public RetType for_SyntaxTransformation_RewriteFnRef(_SyntaxTransformation_RewriteFnRef that) {
        return for_RewriteFnRef(that);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprRef(_SyntaxTransformation_RewriteObjectExprRef that) {
        return for_RewriteObjectExprRef(that);
    }

    public RetType for_SyntaxTransformationJuxt(_SyntaxTransformationJuxt that) {
        return forJuxt(that);
    }

    public RetType for_SyntaxTransformation_RewriteFnApp(_SyntaxTransformation_RewriteFnApp that) {
        return for_RewriteFnApp(that);
    }

    public RetType for_SyntaxTransformationOpExpr(_SyntaxTransformationOpExpr that) {
        return forOpExpr(that);
    }

    public RetType for_SyntaxTransformationAmbiguousMultifixOpExpr(_SyntaxTransformationAmbiguousMultifixOpExpr that) {
        return forAmbiguousMultifixOpExpr(that);
    }

    public RetType for_SyntaxTransformationChainExpr(_SyntaxTransformationChainExpr that) {
        return forChainExpr(that);
    }

    public RetType for_SyntaxTransformationCoercionInvocation(_SyntaxTransformationCoercionInvocation that) {
        return forCoercionInvocation(that);
    }

    public RetType for_SyntaxTransformationTraitCoercionInvocation(_SyntaxTransformationTraitCoercionInvocation that) {
        return forTraitCoercionInvocation(that);
    }

    public RetType for_SyntaxTransformationTupleCoercionInvocation(_SyntaxTransformationTupleCoercionInvocation that) {
        return forTupleCoercionInvocation(that);
    }

    public RetType for_SyntaxTransformationArrowCoercionInvocation(_SyntaxTransformationArrowCoercionInvocation that) {
        return forArrowCoercionInvocation(that);
    }

    public RetType for_SyntaxTransformationUnionCoercionInvocation(_SyntaxTransformationUnionCoercionInvocation that) {
        return forUnionCoercionInvocation(that);
    }

    public RetType for_SyntaxTransformationMethodInvocation(_SyntaxTransformationMethodInvocation that) {
        return forMethodInvocation(that);
    }

    public RetType for_SyntaxTransformationMathPrimary(_SyntaxTransformationMathPrimary that) {
        return forMathPrimary(that);
    }

    public RetType for_SyntaxTransformationArrayExpr(_SyntaxTransformationArrayExpr that) {
        return forArrayExpr(that);
    }

    public RetType for_SyntaxTransformationArrayElement(_SyntaxTransformationArrayElement that) {
        return forArrayElement(that);
    }

    public RetType for_SyntaxTransformationArrayElements(_SyntaxTransformationArrayElements that) {
        return forArrayElements(that);
    }

    public RetType for_EllipsesExpr(_EllipsesExpr that) {
        return forExpr(that);
    }

    public RetType for_EllipsesDummyExpr(_EllipsesDummyExpr that) {
        return forDummyExpr(that);
    }

    public RetType for_EllipsesTypeAnnotatedExpr(_EllipsesTypeAnnotatedExpr that) {
        return forTypeAnnotatedExpr(that);
    }

    public RetType for_EllipsesAsExpr(_EllipsesAsExpr that) {
        return forAsExpr(that);
    }

    public RetType for_EllipsesAsIfExpr(_EllipsesAsIfExpr that) {
        return forAsIfExpr(that);
    }

    public RetType for_EllipsesAssignment(_EllipsesAssignment that) {
        return forAssignment(that);
    }

    public RetType for_EllipsesBlock(_EllipsesBlock that) {
        return forBlock(that);
    }

    public RetType for_EllipsesDo(_EllipsesDo that) {
        return forDo(that);
    }

    public RetType for_EllipsesCaseExpr(_EllipsesCaseExpr that) {
        return forCaseExpr(that);
    }

    public RetType for_EllipsesIf(_EllipsesIf that) {
        return forIf(that);
    }

    public RetType for_EllipsesLabel(_EllipsesLabel that) {
        return forLabel(that);
    }

    public RetType for_EllipsesAbstractObjectExpr(_EllipsesAbstractObjectExpr that) {
        return forAbstractObjectExpr(that);
    }

    public RetType for_EllipsesObjectExpr(_EllipsesObjectExpr that) {
        return forObjectExpr(that);
    }

    public RetType for_Ellipses_RewriteObjectExpr(_Ellipses_RewriteObjectExpr that) {
        return for_RewriteObjectExpr(that);
    }

    public RetType for_EllipsesTry(_EllipsesTry that) {
        return forTry(that);
    }

    public RetType for_EllipsesTupleExpr(_EllipsesTupleExpr that) {
        return forTupleExpr(that);
    }

    public RetType for_EllipsesTypecase(_EllipsesTypecase that) {
        return forTypecase(that);
    }

    public RetType for_EllipsesWhile(_EllipsesWhile that) {
        return forWhile(that);
    }

    public RetType for_EllipsesFor(_EllipsesFor that) {
        return forFor(that);
    }

    public RetType for_EllipsesBigOpApp(_EllipsesBigOpApp that) {
        return forBigOpApp(that);
    }

    public RetType for_EllipsesAccumulator(_EllipsesAccumulator that) {
        return forAccumulator(that);
    }

    public RetType for_EllipsesArrayComprehension(_EllipsesArrayComprehension that) {
        return forArrayComprehension(that);
    }

    public RetType for_EllipsesAtomicExpr(_EllipsesAtomicExpr that) {
        return forAtomicExpr(that);
    }

    public RetType for_EllipsesExit(_EllipsesExit that) {
        return forExit(that);
    }

    public RetType for_EllipsesSpawn(_EllipsesSpawn that) {
        return forSpawn(that);
    }

    public RetType for_EllipsesThrow(_EllipsesThrow that) {
        return forThrow(that);
    }

    public RetType for_EllipsesTryAtomicExpr(_EllipsesTryAtomicExpr that) {
        return forTryAtomicExpr(that);
    }

    public RetType for_EllipsesFnExpr(_EllipsesFnExpr that) {
        return forFnExpr(that);
    }

    public RetType for_EllipsesLetExpr(_EllipsesLetExpr that) {
        return forLetExpr(that);
    }

    public RetType for_EllipsesLetFn(_EllipsesLetFn that) {
        return forLetFn(that);
    }

    public RetType for_EllipsesLocalVarDecl(_EllipsesLocalVarDecl that) {
        return forLocalVarDecl(that);
    }

    public RetType for_EllipsesSimpleExpr(_EllipsesSimpleExpr that) {
        return forSimpleExpr(that);
    }

    public RetType for_EllipsesSubscriptExpr(_EllipsesSubscriptExpr that) {
        return forSubscriptExpr(that);
    }

    public RetType for_EllipsesPrimary(_EllipsesPrimary that) {
        return forPrimary(that);
    }

    public RetType for_EllipsesLiteralExpr(_EllipsesLiteralExpr that) {
        return forLiteralExpr(that);
    }

    public RetType for_EllipsesNumberLiteralExpr(_EllipsesNumberLiteralExpr that) {
        return forNumberLiteralExpr(that);
    }

    public RetType for_EllipsesFloatLiteralExpr(_EllipsesFloatLiteralExpr that) {
        return forFloatLiteralExpr(that);
    }

    public RetType for_EllipsesIntLiteralExpr(_EllipsesIntLiteralExpr that) {
        return forIntLiteralExpr(that);
    }

    public RetType for_EllipsesCharLiteralExpr(_EllipsesCharLiteralExpr that) {
        return forCharLiteralExpr(that);
    }

    public RetType for_EllipsesStringLiteralExpr(_EllipsesStringLiteralExpr that) {
        return forStringLiteralExpr(that);
    }

    public RetType for_EllipsesVoidLiteralExpr(_EllipsesVoidLiteralExpr that) {
        return forVoidLiteralExpr(that);
    }

    public RetType for_EllipsesBooleanLiteralExpr(_EllipsesBooleanLiteralExpr that) {
        return forBooleanLiteralExpr(that);
    }

    public RetType for_EllipsesVarRef(_EllipsesVarRef that) {
        return forVarRef(that);
    }

    public RetType for_EllipsesFieldRef(_EllipsesFieldRef that) {
        return forFieldRef(that);
    }

    public RetType for_EllipsesFunctionalRef(_EllipsesFunctionalRef that) {
        return forFunctionalRef(that);
    }

    public RetType for_EllipsesFnRef(_EllipsesFnRef that) {
        return forFnRef(that);
    }

    public RetType for_EllipsesOpRef(_EllipsesOpRef that) {
        return forOpRef(that);
    }

    public RetType for_Ellipses_RewriteFnRef(_Ellipses_RewriteFnRef that) {
        return for_RewriteFnRef(that);
    }

    public RetType for_Ellipses_RewriteObjectExprRef(_Ellipses_RewriteObjectExprRef that) {
        return for_RewriteObjectExprRef(that);
    }

    public RetType for_EllipsesJuxt(_EllipsesJuxt that) {
        return forJuxt(that);
    }

    public RetType for_Ellipses_RewriteFnApp(_Ellipses_RewriteFnApp that) {
        return for_RewriteFnApp(that);
    }

    public RetType for_EllipsesOpExpr(_EllipsesOpExpr that) {
        return forOpExpr(that);
    }

    public RetType for_EllipsesAmbiguousMultifixOpExpr(_EllipsesAmbiguousMultifixOpExpr that) {
        return forAmbiguousMultifixOpExpr(that);
    }

    public RetType for_EllipsesChainExpr(_EllipsesChainExpr that) {
        return forChainExpr(that);
    }

    public RetType for_EllipsesCoercionInvocation(_EllipsesCoercionInvocation that) {
        return forCoercionInvocation(that);
    }

    public RetType for_EllipsesTraitCoercionInvocation(_EllipsesTraitCoercionInvocation that) {
        return forTraitCoercionInvocation(that);
    }

    public RetType for_EllipsesTupleCoercionInvocation(_EllipsesTupleCoercionInvocation that) {
        return forTupleCoercionInvocation(that);
    }

    public RetType for_EllipsesArrowCoercionInvocation(_EllipsesArrowCoercionInvocation that) {
        return forArrowCoercionInvocation(that);
    }

    public RetType for_EllipsesUnionCoercionInvocation(_EllipsesUnionCoercionInvocation that) {
        return forUnionCoercionInvocation(that);
    }

    public RetType for_EllipsesMethodInvocation(_EllipsesMethodInvocation that) {
        return forMethodInvocation(that);
    }

    public RetType for_EllipsesMathPrimary(_EllipsesMathPrimary that) {
        return forMathPrimary(that);
    }

    public RetType for_EllipsesArrayExpr(_EllipsesArrayExpr that) {
        return forArrayExpr(that);
    }

    public RetType for_EllipsesArrayElement(_EllipsesArrayElement that) {
        return forArrayElement(that);
    }

    public RetType for_EllipsesArrayElements(_EllipsesArrayElements that) {
        return forArrayElements(that);
    }

    public RetType forTemplateGapExpr(TemplateGapExpr that) {
        return forExpr(that);
    }

    public RetType forTemplateGapDummyExpr(TemplateGapDummyExpr that) {
        return forDummyExpr(that);
    }

    public RetType forTemplateGapTypeAnnotatedExpr(TemplateGapTypeAnnotatedExpr that) {
        return forTypeAnnotatedExpr(that);
    }

    public RetType forTemplateGapAsExpr(TemplateGapAsExpr that) {
        return forAsExpr(that);
    }

    public RetType forTemplateGapAsIfExpr(TemplateGapAsIfExpr that) {
        return forAsIfExpr(that);
    }

    public RetType forTemplateGapAssignment(TemplateGapAssignment that) {
        return forAssignment(that);
    }

    public RetType forTemplateGapBlock(TemplateGapBlock that) {
        return forBlock(that);
    }

    public RetType forTemplateGapDo(TemplateGapDo that) {
        return forDo(that);
    }

    public RetType forTemplateGapCaseExpr(TemplateGapCaseExpr that) {
        return forCaseExpr(that);
    }

    public RetType forTemplateGapIf(TemplateGapIf that) {
        return forIf(that);
    }

    public RetType forTemplateGapLabel(TemplateGapLabel that) {
        return forLabel(that);
    }

    public RetType forTemplateGapAbstractObjectExpr(TemplateGapAbstractObjectExpr that) {
        return forAbstractObjectExpr(that);
    }

    public RetType forTemplateGapObjectExpr(TemplateGapObjectExpr that) {
        return forObjectExpr(that);
    }

    public RetType forTemplateGap_RewriteObjectExpr(TemplateGap_RewriteObjectExpr that) {
        return for_RewriteObjectExpr(that);
    }

    public RetType forTemplateGapTry(TemplateGapTry that) {
        return forTry(that);
    }

    public RetType forTemplateGapTupleExpr(TemplateGapTupleExpr that) {
        return forTupleExpr(that);
    }

    public RetType forTemplateGapTypecase(TemplateGapTypecase that) {
        return forTypecase(that);
    }

    public RetType forTemplateGapWhile(TemplateGapWhile that) {
        return forWhile(that);
    }

    public RetType forTemplateGapFor(TemplateGapFor that) {
        return forFor(that);
    }

    public RetType forTemplateGapBigOpApp(TemplateGapBigOpApp that) {
        return forBigOpApp(that);
    }

    public RetType forTemplateGapAccumulator(TemplateGapAccumulator that) {
        return forAccumulator(that);
    }

    public RetType forTemplateGapArrayComprehension(TemplateGapArrayComprehension that) {
        return forArrayComprehension(that);
    }

    public RetType forTemplateGapAtomicExpr(TemplateGapAtomicExpr that) {
        return forAtomicExpr(that);
    }

    public RetType forTemplateGapExit(TemplateGapExit that) {
        return forExit(that);
    }

    public RetType forTemplateGapSpawn(TemplateGapSpawn that) {
        return forSpawn(that);
    }

    public RetType forTemplateGapThrow(TemplateGapThrow that) {
        return forThrow(that);
    }

    public RetType forTemplateGapTryAtomicExpr(TemplateGapTryAtomicExpr that) {
        return forTryAtomicExpr(that);
    }

    public RetType forTemplateGapFnExpr(TemplateGapFnExpr that) {
        return forFnExpr(that);
    }

    public RetType forTemplateGapLetExpr(TemplateGapLetExpr that) {
        return forLetExpr(that);
    }

    public RetType forTemplateGapLetFn(TemplateGapLetFn that) {
        return forLetFn(that);
    }

    public RetType forTemplateGapLocalVarDecl(TemplateGapLocalVarDecl that) {
        return forLocalVarDecl(that);
    }

    public RetType forTemplateGapSimpleExpr(TemplateGapSimpleExpr that) {
        return forSimpleExpr(that);
    }

    public RetType forTemplateGapSubscriptExpr(TemplateGapSubscriptExpr that) {
        return forSubscriptExpr(that);
    }

    public RetType forTemplateGapPrimary(TemplateGapPrimary that) {
        return forPrimary(that);
    }

    public RetType forTemplateGapLiteralExpr(TemplateGapLiteralExpr that) {
        return forLiteralExpr(that);
    }

    public RetType forTemplateGapNumberLiteralExpr(TemplateGapNumberLiteralExpr that) {
        return forNumberLiteralExpr(that);
    }

    public RetType forTemplateGapFloatLiteralExpr(TemplateGapFloatLiteralExpr that) {
        return forFloatLiteralExpr(that);
    }

    public RetType forTemplateGapIntLiteralExpr(TemplateGapIntLiteralExpr that) {
        return forIntLiteralExpr(that);
    }

    public RetType forTemplateGapCharLiteralExpr(TemplateGapCharLiteralExpr that) {
        return forCharLiteralExpr(that);
    }

    public RetType forTemplateGapStringLiteralExpr(TemplateGapStringLiteralExpr that) {
        return forStringLiteralExpr(that);
    }

    public RetType forTemplateGapVoidLiteralExpr(TemplateGapVoidLiteralExpr that) {
        return forVoidLiteralExpr(that);
    }

    public RetType forTemplateGapBooleanLiteralExpr(TemplateGapBooleanLiteralExpr that) {
        return forBooleanLiteralExpr(that);
    }

    public RetType forTemplateGapVarRef(TemplateGapVarRef that) {
        return forVarRef(that);
    }

    public RetType forTemplateGapFieldRef(TemplateGapFieldRef that) {
        return forFieldRef(that);
    }

    public RetType forTemplateGapFunctionalRef(TemplateGapFunctionalRef that) {
        return forFunctionalRef(that);
    }

    public RetType forTemplateGapFnRef(TemplateGapFnRef that) {
        return forFnRef(that);
    }

    public RetType forTemplateGapOpRef(TemplateGapOpRef that) {
        return forOpRef(that);
    }

    public RetType forTemplateGap_RewriteFnRef(TemplateGap_RewriteFnRef that) {
        return for_RewriteFnRef(that);
    }

    public RetType forTemplateGap_RewriteObjectExprRef(TemplateGap_RewriteObjectExprRef that) {
        return for_RewriteObjectExprRef(that);
    }

    public RetType forTemplateGapJuxt(TemplateGapJuxt that) {
        return forJuxt(that);
    }

    public RetType forTemplateGap_RewriteFnApp(TemplateGap_RewriteFnApp that) {
        return for_RewriteFnApp(that);
    }

    public RetType forTemplateGapOpExpr(TemplateGapOpExpr that) {
        return forOpExpr(that);
    }

    public RetType forTemplateGapAmbiguousMultifixOpExpr(TemplateGapAmbiguousMultifixOpExpr that) {
        return forAmbiguousMultifixOpExpr(that);
    }

    public RetType forTemplateGapChainExpr(TemplateGapChainExpr that) {
        return forChainExpr(that);
    }

    public RetType forTemplateGapCoercionInvocation(TemplateGapCoercionInvocation that) {
        return forCoercionInvocation(that);
    }

    public RetType forTemplateGapTraitCoercionInvocation(TemplateGapTraitCoercionInvocation that) {
        return forTraitCoercionInvocation(that);
    }

    public RetType forTemplateGapTupleCoercionInvocation(TemplateGapTupleCoercionInvocation that) {
        return forTupleCoercionInvocation(that);
    }

    public RetType forTemplateGapArrowCoercionInvocation(TemplateGapArrowCoercionInvocation that) {
        return forArrowCoercionInvocation(that);
    }

    public RetType forTemplateGapUnionCoercionInvocation(TemplateGapUnionCoercionInvocation that) {
        return forUnionCoercionInvocation(that);
    }

    public RetType forTemplateGapMethodInvocation(TemplateGapMethodInvocation that) {
        return forMethodInvocation(that);
    }

    public RetType forTemplateGapMathPrimary(TemplateGapMathPrimary that) {
        return forMathPrimary(that);
    }

    public RetType forTemplateGapArrayExpr(TemplateGapArrayExpr that) {
        return forArrayExpr(that);
    }

    public RetType forTemplateGapArrayElement(TemplateGapArrayElement that) {
        return forArrayElement(that);
    }

    public RetType forTemplateGapArrayElements(TemplateGapArrayElements that) {
        return forArrayElements(that);
    }


}
