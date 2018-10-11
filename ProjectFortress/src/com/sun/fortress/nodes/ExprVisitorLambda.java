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

/** An abstract visitor over Expr that provides a lambda value method;
  * all visit methods are left unimplemented. */
@SuppressWarnings("unused")
public abstract class ExprVisitorLambda<RetType> implements edu.rice.cs.plt.lambda.Lambda<Expr, RetType>, ExprVisitor<RetType> {

    public RetType value(Expr that) {
        return that.accept(this);
    }


    /** Process an instance of DummyExpr. */
    public abstract RetType forDummyExpr(DummyExpr that);

    /** Process an instance of AsExpr. */
    public abstract RetType forAsExpr(AsExpr that);

    /** Process an instance of AsIfExpr. */
    public abstract RetType forAsIfExpr(AsIfExpr that);

    /** Process an instance of Assignment. */
    public abstract RetType forAssignment(Assignment that);

    /** Process an instance of Block. */
    public abstract RetType forBlock(Block that);

    /** Process an instance of Do. */
    public abstract RetType forDo(Do that);

    /** Process an instance of CaseExpr. */
    public abstract RetType forCaseExpr(CaseExpr that);

    /** Process an instance of If. */
    public abstract RetType forIf(If that);

    /** Process an instance of Label. */
    public abstract RetType forLabel(Label that);

    /** Process an instance of ObjectExpr. */
    public abstract RetType forObjectExpr(ObjectExpr that);

    /** Process an instance of _RewriteObjectExpr. */
    public abstract RetType for_RewriteObjectExpr(_RewriteObjectExpr that);

    /** Process an instance of Try. */
    public abstract RetType forTry(Try that);

    /** Process an instance of TupleExpr. */
    public abstract RetType forTupleExpr(TupleExpr that);

    /** Process an instance of Typecase. */
    public abstract RetType forTypecase(Typecase that);

    /** Process an instance of While. */
    public abstract RetType forWhile(While that);

    /** Process an instance of For. */
    public abstract RetType forFor(For that);

    /** Process an instance of Accumulator. */
    public abstract RetType forAccumulator(Accumulator that);

    /** Process an instance of ArrayComprehension. */
    public abstract RetType forArrayComprehension(ArrayComprehension that);

    /** Process an instance of AtomicExpr. */
    public abstract RetType forAtomicExpr(AtomicExpr that);

    /** Process an instance of Exit. */
    public abstract RetType forExit(Exit that);

    /** Process an instance of Spawn. */
    public abstract RetType forSpawn(Spawn that);

    /** Process an instance of Throw. */
    public abstract RetType forThrow(Throw that);

    /** Process an instance of TryAtomicExpr. */
    public abstract RetType forTryAtomicExpr(TryAtomicExpr that);

    /** Process an instance of FnExpr. */
    public abstract RetType forFnExpr(FnExpr that);

    /** Process an instance of LetFn. */
    public abstract RetType forLetFn(LetFn that);

    /** Process an instance of LocalVarDecl. */
    public abstract RetType forLocalVarDecl(LocalVarDecl that);

    /** Process an instance of SubscriptExpr. */
    public abstract RetType forSubscriptExpr(SubscriptExpr that);

    /** Process an instance of FloatLiteralExpr. */
    public abstract RetType forFloatLiteralExpr(FloatLiteralExpr that);

    /** Process an instance of IntLiteralExpr. */
    public abstract RetType forIntLiteralExpr(IntLiteralExpr that);

    /** Process an instance of CharLiteralExpr. */
    public abstract RetType forCharLiteralExpr(CharLiteralExpr that);

    /** Process an instance of StringLiteralExpr. */
    public abstract RetType forStringLiteralExpr(StringLiteralExpr that);

    /** Process an instance of VoidLiteralExpr. */
    public abstract RetType forVoidLiteralExpr(VoidLiteralExpr that);

    /** Process an instance of BooleanLiteralExpr. */
    public abstract RetType forBooleanLiteralExpr(BooleanLiteralExpr that);

    /** Process an instance of VarRef. */
    public abstract RetType forVarRef(VarRef that);

    /** Process an instance of FieldRef. */
    public abstract RetType forFieldRef(FieldRef that);

    /** Process an instance of FnRef. */
    public abstract RetType forFnRef(FnRef that);

    /** Process an instance of OpRef. */
    public abstract RetType forOpRef(OpRef that);

    /** Process an instance of _RewriteFnRef. */
    public abstract RetType for_RewriteFnRef(_RewriteFnRef that);

    /** Process an instance of _RewriteObjectExprRef. */
    public abstract RetType for_RewriteObjectExprRef(_RewriteObjectExprRef that);

    /** Process an instance of Juxt. */
    public abstract RetType forJuxt(Juxt that);

    /** Process an instance of _RewriteFnApp. */
    public abstract RetType for_RewriteFnApp(_RewriteFnApp that);

    /** Process an instance of OpExpr. */
    public abstract RetType forOpExpr(OpExpr that);

    /** Process an instance of AmbiguousMultifixOpExpr. */
    public abstract RetType forAmbiguousMultifixOpExpr(AmbiguousMultifixOpExpr that);

    /** Process an instance of ChainExpr. */
    public abstract RetType forChainExpr(ChainExpr that);

    /** Process an instance of TraitCoercionInvocation. */
    public abstract RetType forTraitCoercionInvocation(TraitCoercionInvocation that);

    /** Process an instance of TupleCoercionInvocation. */
    public abstract RetType forTupleCoercionInvocation(TupleCoercionInvocation that);

    /** Process an instance of ArrowCoercionInvocation. */
    public abstract RetType forArrowCoercionInvocation(ArrowCoercionInvocation that);

    /** Process an instance of UnionCoercionInvocation. */
    public abstract RetType forUnionCoercionInvocation(UnionCoercionInvocation that);

    /** Process an instance of MethodInvocation. */
    public abstract RetType forMethodInvocation(MethodInvocation that);

    /** Process an instance of MathPrimary. */
    public abstract RetType forMathPrimary(MathPrimary that);

    /** Process an instance of ArrayElement. */
    public abstract RetType forArrayElement(ArrayElement that);

    /** Process an instance of ArrayElements. */
    public abstract RetType forArrayElements(ArrayElements that);

    /** Process an instance of _SyntaxTransformationExpr. */
    public abstract RetType for_SyntaxTransformationExpr(_SyntaxTransformationExpr that);

    /** Process an instance of _SyntaxTransformationDummyExpr. */
    public abstract RetType for_SyntaxTransformationDummyExpr(_SyntaxTransformationDummyExpr that);

    /** Process an instance of _SyntaxTransformationTypeAnnotatedExpr. */
    public abstract RetType for_SyntaxTransformationTypeAnnotatedExpr(_SyntaxTransformationTypeAnnotatedExpr that);

    /** Process an instance of _SyntaxTransformationAsExpr. */
    public abstract RetType for_SyntaxTransformationAsExpr(_SyntaxTransformationAsExpr that);

    /** Process an instance of _SyntaxTransformationAsIfExpr. */
    public abstract RetType for_SyntaxTransformationAsIfExpr(_SyntaxTransformationAsIfExpr that);

    /** Process an instance of _SyntaxTransformationAssignment. */
    public abstract RetType for_SyntaxTransformationAssignment(_SyntaxTransformationAssignment that);

    /** Process an instance of _SyntaxTransformationBlock. */
    public abstract RetType for_SyntaxTransformationBlock(_SyntaxTransformationBlock that);

    /** Process an instance of _SyntaxTransformationDo. */
    public abstract RetType for_SyntaxTransformationDo(_SyntaxTransformationDo that);

    /** Process an instance of _SyntaxTransformationCaseExpr. */
    public abstract RetType for_SyntaxTransformationCaseExpr(_SyntaxTransformationCaseExpr that);

    /** Process an instance of _SyntaxTransformationIf. */
    public abstract RetType for_SyntaxTransformationIf(_SyntaxTransformationIf that);

    /** Process an instance of _SyntaxTransformationLabel. */
    public abstract RetType for_SyntaxTransformationLabel(_SyntaxTransformationLabel that);

    /** Process an instance of _SyntaxTransformationAbstractObjectExpr. */
    public abstract RetType for_SyntaxTransformationAbstractObjectExpr(_SyntaxTransformationAbstractObjectExpr that);

    /** Process an instance of _SyntaxTransformationObjectExpr. */
    public abstract RetType for_SyntaxTransformationObjectExpr(_SyntaxTransformationObjectExpr that);

    /** Process an instance of _SyntaxTransformation_RewriteObjectExpr. */
    public abstract RetType for_SyntaxTransformation_RewriteObjectExpr(_SyntaxTransformation_RewriteObjectExpr that);

    /** Process an instance of _SyntaxTransformationTry. */
    public abstract RetType for_SyntaxTransformationTry(_SyntaxTransformationTry that);

    /** Process an instance of _SyntaxTransformationTupleExpr. */
    public abstract RetType for_SyntaxTransformationTupleExpr(_SyntaxTransformationTupleExpr that);

    /** Process an instance of _SyntaxTransformationTypecase. */
    public abstract RetType for_SyntaxTransformationTypecase(_SyntaxTransformationTypecase that);

    /** Process an instance of _SyntaxTransformationWhile. */
    public abstract RetType for_SyntaxTransformationWhile(_SyntaxTransformationWhile that);

    /** Process an instance of _SyntaxTransformationFor. */
    public abstract RetType for_SyntaxTransformationFor(_SyntaxTransformationFor that);

    /** Process an instance of _SyntaxTransformationBigOpApp. */
    public abstract RetType for_SyntaxTransformationBigOpApp(_SyntaxTransformationBigOpApp that);

    /** Process an instance of _SyntaxTransformationAccumulator. */
    public abstract RetType for_SyntaxTransformationAccumulator(_SyntaxTransformationAccumulator that);

    /** Process an instance of _SyntaxTransformationArrayComprehension. */
    public abstract RetType for_SyntaxTransformationArrayComprehension(_SyntaxTransformationArrayComprehension that);

    /** Process an instance of _SyntaxTransformationAtomicExpr. */
    public abstract RetType for_SyntaxTransformationAtomicExpr(_SyntaxTransformationAtomicExpr that);

    /** Process an instance of _SyntaxTransformationExit. */
    public abstract RetType for_SyntaxTransformationExit(_SyntaxTransformationExit that);

    /** Process an instance of _SyntaxTransformationSpawn. */
    public abstract RetType for_SyntaxTransformationSpawn(_SyntaxTransformationSpawn that);

    /** Process an instance of _SyntaxTransformationThrow. */
    public abstract RetType for_SyntaxTransformationThrow(_SyntaxTransformationThrow that);

    /** Process an instance of _SyntaxTransformationTryAtomicExpr. */
    public abstract RetType for_SyntaxTransformationTryAtomicExpr(_SyntaxTransformationTryAtomicExpr that);

    /** Process an instance of _SyntaxTransformationFnExpr. */
    public abstract RetType for_SyntaxTransformationFnExpr(_SyntaxTransformationFnExpr that);

    /** Process an instance of _SyntaxTransformationLetExpr. */
    public abstract RetType for_SyntaxTransformationLetExpr(_SyntaxTransformationLetExpr that);

    /** Process an instance of _SyntaxTransformationLetFn. */
    public abstract RetType for_SyntaxTransformationLetFn(_SyntaxTransformationLetFn that);

    /** Process an instance of _SyntaxTransformationLocalVarDecl. */
    public abstract RetType for_SyntaxTransformationLocalVarDecl(_SyntaxTransformationLocalVarDecl that);

    /** Process an instance of _SyntaxTransformationSimpleExpr. */
    public abstract RetType for_SyntaxTransformationSimpleExpr(_SyntaxTransformationSimpleExpr that);

    /** Process an instance of _SyntaxTransformationSubscriptExpr. */
    public abstract RetType for_SyntaxTransformationSubscriptExpr(_SyntaxTransformationSubscriptExpr that);

    /** Process an instance of _SyntaxTransformationPrimary. */
    public abstract RetType for_SyntaxTransformationPrimary(_SyntaxTransformationPrimary that);

    /** Process an instance of _SyntaxTransformationLiteralExpr. */
    public abstract RetType for_SyntaxTransformationLiteralExpr(_SyntaxTransformationLiteralExpr that);

    /** Process an instance of _SyntaxTransformationNumberLiteralExpr. */
    public abstract RetType for_SyntaxTransformationNumberLiteralExpr(_SyntaxTransformationNumberLiteralExpr that);

    /** Process an instance of _SyntaxTransformationFloatLiteralExpr. */
    public abstract RetType for_SyntaxTransformationFloatLiteralExpr(_SyntaxTransformationFloatLiteralExpr that);

    /** Process an instance of _SyntaxTransformationIntLiteralExpr. */
    public abstract RetType for_SyntaxTransformationIntLiteralExpr(_SyntaxTransformationIntLiteralExpr that);

    /** Process an instance of _SyntaxTransformationCharLiteralExpr. */
    public abstract RetType for_SyntaxTransformationCharLiteralExpr(_SyntaxTransformationCharLiteralExpr that);

    /** Process an instance of _SyntaxTransformationStringLiteralExpr. */
    public abstract RetType for_SyntaxTransformationStringLiteralExpr(_SyntaxTransformationStringLiteralExpr that);

    /** Process an instance of _SyntaxTransformationVoidLiteralExpr. */
    public abstract RetType for_SyntaxTransformationVoidLiteralExpr(_SyntaxTransformationVoidLiteralExpr that);

    /** Process an instance of _SyntaxTransformationBooleanLiteralExpr. */
    public abstract RetType for_SyntaxTransformationBooleanLiteralExpr(_SyntaxTransformationBooleanLiteralExpr that);

    /** Process an instance of _SyntaxTransformationVarRef. */
    public abstract RetType for_SyntaxTransformationVarRef(_SyntaxTransformationVarRef that);

    /** Process an instance of _SyntaxTransformationFieldRef. */
    public abstract RetType for_SyntaxTransformationFieldRef(_SyntaxTransformationFieldRef that);

    /** Process an instance of _SyntaxTransformationFunctionalRef. */
    public abstract RetType for_SyntaxTransformationFunctionalRef(_SyntaxTransformationFunctionalRef that);

    /** Process an instance of _SyntaxTransformationFnRef. */
    public abstract RetType for_SyntaxTransformationFnRef(_SyntaxTransformationFnRef that);

    /** Process an instance of _SyntaxTransformationOpRef. */
    public abstract RetType for_SyntaxTransformationOpRef(_SyntaxTransformationOpRef that);

    /** Process an instance of _SyntaxTransformation_RewriteFnRef. */
    public abstract RetType for_SyntaxTransformation_RewriteFnRef(_SyntaxTransformation_RewriteFnRef that);

    /** Process an instance of _SyntaxTransformation_RewriteObjectExprRef. */
    public abstract RetType for_SyntaxTransformation_RewriteObjectExprRef(_SyntaxTransformation_RewriteObjectExprRef that);

    /** Process an instance of _SyntaxTransformationJuxt. */
    public abstract RetType for_SyntaxTransformationJuxt(_SyntaxTransformationJuxt that);

    /** Process an instance of _SyntaxTransformation_RewriteFnApp. */
    public abstract RetType for_SyntaxTransformation_RewriteFnApp(_SyntaxTransformation_RewriteFnApp that);

    /** Process an instance of _SyntaxTransformationOpExpr. */
    public abstract RetType for_SyntaxTransformationOpExpr(_SyntaxTransformationOpExpr that);

    /** Process an instance of _SyntaxTransformationAmbiguousMultifixOpExpr. */
    public abstract RetType for_SyntaxTransformationAmbiguousMultifixOpExpr(_SyntaxTransformationAmbiguousMultifixOpExpr that);

    /** Process an instance of _SyntaxTransformationChainExpr. */
    public abstract RetType for_SyntaxTransformationChainExpr(_SyntaxTransformationChainExpr that);

    /** Process an instance of _SyntaxTransformationCoercionInvocation. */
    public abstract RetType for_SyntaxTransformationCoercionInvocation(_SyntaxTransformationCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationTraitCoercionInvocation. */
    public abstract RetType for_SyntaxTransformationTraitCoercionInvocation(_SyntaxTransformationTraitCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationTupleCoercionInvocation. */
    public abstract RetType for_SyntaxTransformationTupleCoercionInvocation(_SyntaxTransformationTupleCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationArrowCoercionInvocation. */
    public abstract RetType for_SyntaxTransformationArrowCoercionInvocation(_SyntaxTransformationArrowCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationUnionCoercionInvocation. */
    public abstract RetType for_SyntaxTransformationUnionCoercionInvocation(_SyntaxTransformationUnionCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationMethodInvocation. */
    public abstract RetType for_SyntaxTransformationMethodInvocation(_SyntaxTransformationMethodInvocation that);

    /** Process an instance of _SyntaxTransformationMathPrimary. */
    public abstract RetType for_SyntaxTransformationMathPrimary(_SyntaxTransformationMathPrimary that);

    /** Process an instance of _SyntaxTransformationArrayExpr. */
    public abstract RetType for_SyntaxTransformationArrayExpr(_SyntaxTransformationArrayExpr that);

    /** Process an instance of _SyntaxTransformationArrayElement. */
    public abstract RetType for_SyntaxTransformationArrayElement(_SyntaxTransformationArrayElement that);

    /** Process an instance of _SyntaxTransformationArrayElements. */
    public abstract RetType for_SyntaxTransformationArrayElements(_SyntaxTransformationArrayElements that);

    /** Process an instance of _EllipsesExpr. */
    public abstract RetType for_EllipsesExpr(_EllipsesExpr that);

    /** Process an instance of _EllipsesDummyExpr. */
    public abstract RetType for_EllipsesDummyExpr(_EllipsesDummyExpr that);

    /** Process an instance of _EllipsesTypeAnnotatedExpr. */
    public abstract RetType for_EllipsesTypeAnnotatedExpr(_EllipsesTypeAnnotatedExpr that);

    /** Process an instance of _EllipsesAsExpr. */
    public abstract RetType for_EllipsesAsExpr(_EllipsesAsExpr that);

    /** Process an instance of _EllipsesAsIfExpr. */
    public abstract RetType for_EllipsesAsIfExpr(_EllipsesAsIfExpr that);

    /** Process an instance of _EllipsesAssignment. */
    public abstract RetType for_EllipsesAssignment(_EllipsesAssignment that);

    /** Process an instance of _EllipsesBlock. */
    public abstract RetType for_EllipsesBlock(_EllipsesBlock that);

    /** Process an instance of _EllipsesDo. */
    public abstract RetType for_EllipsesDo(_EllipsesDo that);

    /** Process an instance of _EllipsesCaseExpr. */
    public abstract RetType for_EllipsesCaseExpr(_EllipsesCaseExpr that);

    /** Process an instance of _EllipsesIf. */
    public abstract RetType for_EllipsesIf(_EllipsesIf that);

    /** Process an instance of _EllipsesLabel. */
    public abstract RetType for_EllipsesLabel(_EllipsesLabel that);

    /** Process an instance of _EllipsesAbstractObjectExpr. */
    public abstract RetType for_EllipsesAbstractObjectExpr(_EllipsesAbstractObjectExpr that);

    /** Process an instance of _EllipsesObjectExpr. */
    public abstract RetType for_EllipsesObjectExpr(_EllipsesObjectExpr that);

    /** Process an instance of _Ellipses_RewriteObjectExpr. */
    public abstract RetType for_Ellipses_RewriteObjectExpr(_Ellipses_RewriteObjectExpr that);

    /** Process an instance of _EllipsesTry. */
    public abstract RetType for_EllipsesTry(_EllipsesTry that);

    /** Process an instance of _EllipsesTupleExpr. */
    public abstract RetType for_EllipsesTupleExpr(_EllipsesTupleExpr that);

    /** Process an instance of _EllipsesTypecase. */
    public abstract RetType for_EllipsesTypecase(_EllipsesTypecase that);

    /** Process an instance of _EllipsesWhile. */
    public abstract RetType for_EllipsesWhile(_EllipsesWhile that);

    /** Process an instance of _EllipsesFor. */
    public abstract RetType for_EllipsesFor(_EllipsesFor that);

    /** Process an instance of _EllipsesBigOpApp. */
    public abstract RetType for_EllipsesBigOpApp(_EllipsesBigOpApp that);

    /** Process an instance of _EllipsesAccumulator. */
    public abstract RetType for_EllipsesAccumulator(_EllipsesAccumulator that);

    /** Process an instance of _EllipsesArrayComprehension. */
    public abstract RetType for_EllipsesArrayComprehension(_EllipsesArrayComprehension that);

    /** Process an instance of _EllipsesAtomicExpr. */
    public abstract RetType for_EllipsesAtomicExpr(_EllipsesAtomicExpr that);

    /** Process an instance of _EllipsesExit. */
    public abstract RetType for_EllipsesExit(_EllipsesExit that);

    /** Process an instance of _EllipsesSpawn. */
    public abstract RetType for_EllipsesSpawn(_EllipsesSpawn that);

    /** Process an instance of _EllipsesThrow. */
    public abstract RetType for_EllipsesThrow(_EllipsesThrow that);

    /** Process an instance of _EllipsesTryAtomicExpr. */
    public abstract RetType for_EllipsesTryAtomicExpr(_EllipsesTryAtomicExpr that);

    /** Process an instance of _EllipsesFnExpr. */
    public abstract RetType for_EllipsesFnExpr(_EllipsesFnExpr that);

    /** Process an instance of _EllipsesLetExpr. */
    public abstract RetType for_EllipsesLetExpr(_EllipsesLetExpr that);

    /** Process an instance of _EllipsesLetFn. */
    public abstract RetType for_EllipsesLetFn(_EllipsesLetFn that);

    /** Process an instance of _EllipsesLocalVarDecl. */
    public abstract RetType for_EllipsesLocalVarDecl(_EllipsesLocalVarDecl that);

    /** Process an instance of _EllipsesSimpleExpr. */
    public abstract RetType for_EllipsesSimpleExpr(_EllipsesSimpleExpr that);

    /** Process an instance of _EllipsesSubscriptExpr. */
    public abstract RetType for_EllipsesSubscriptExpr(_EllipsesSubscriptExpr that);

    /** Process an instance of _EllipsesPrimary. */
    public abstract RetType for_EllipsesPrimary(_EllipsesPrimary that);

    /** Process an instance of _EllipsesLiteralExpr. */
    public abstract RetType for_EllipsesLiteralExpr(_EllipsesLiteralExpr that);

    /** Process an instance of _EllipsesNumberLiteralExpr. */
    public abstract RetType for_EllipsesNumberLiteralExpr(_EllipsesNumberLiteralExpr that);

    /** Process an instance of _EllipsesFloatLiteralExpr. */
    public abstract RetType for_EllipsesFloatLiteralExpr(_EllipsesFloatLiteralExpr that);

    /** Process an instance of _EllipsesIntLiteralExpr. */
    public abstract RetType for_EllipsesIntLiteralExpr(_EllipsesIntLiteralExpr that);

    /** Process an instance of _EllipsesCharLiteralExpr. */
    public abstract RetType for_EllipsesCharLiteralExpr(_EllipsesCharLiteralExpr that);

    /** Process an instance of _EllipsesStringLiteralExpr. */
    public abstract RetType for_EllipsesStringLiteralExpr(_EllipsesStringLiteralExpr that);

    /** Process an instance of _EllipsesVoidLiteralExpr. */
    public abstract RetType for_EllipsesVoidLiteralExpr(_EllipsesVoidLiteralExpr that);

    /** Process an instance of _EllipsesBooleanLiteralExpr. */
    public abstract RetType for_EllipsesBooleanLiteralExpr(_EllipsesBooleanLiteralExpr that);

    /** Process an instance of _EllipsesVarRef. */
    public abstract RetType for_EllipsesVarRef(_EllipsesVarRef that);

    /** Process an instance of _EllipsesFieldRef. */
    public abstract RetType for_EllipsesFieldRef(_EllipsesFieldRef that);

    /** Process an instance of _EllipsesFunctionalRef. */
    public abstract RetType for_EllipsesFunctionalRef(_EllipsesFunctionalRef that);

    /** Process an instance of _EllipsesFnRef. */
    public abstract RetType for_EllipsesFnRef(_EllipsesFnRef that);

    /** Process an instance of _EllipsesOpRef. */
    public abstract RetType for_EllipsesOpRef(_EllipsesOpRef that);

    /** Process an instance of _Ellipses_RewriteFnRef. */
    public abstract RetType for_Ellipses_RewriteFnRef(_Ellipses_RewriteFnRef that);

    /** Process an instance of _Ellipses_RewriteObjectExprRef. */
    public abstract RetType for_Ellipses_RewriteObjectExprRef(_Ellipses_RewriteObjectExprRef that);

    /** Process an instance of _EllipsesJuxt. */
    public abstract RetType for_EllipsesJuxt(_EllipsesJuxt that);

    /** Process an instance of _Ellipses_RewriteFnApp. */
    public abstract RetType for_Ellipses_RewriteFnApp(_Ellipses_RewriteFnApp that);

    /** Process an instance of _EllipsesOpExpr. */
    public abstract RetType for_EllipsesOpExpr(_EllipsesOpExpr that);

    /** Process an instance of _EllipsesAmbiguousMultifixOpExpr. */
    public abstract RetType for_EllipsesAmbiguousMultifixOpExpr(_EllipsesAmbiguousMultifixOpExpr that);

    /** Process an instance of _EllipsesChainExpr. */
    public abstract RetType for_EllipsesChainExpr(_EllipsesChainExpr that);

    /** Process an instance of _EllipsesCoercionInvocation. */
    public abstract RetType for_EllipsesCoercionInvocation(_EllipsesCoercionInvocation that);

    /** Process an instance of _EllipsesTraitCoercionInvocation. */
    public abstract RetType for_EllipsesTraitCoercionInvocation(_EllipsesTraitCoercionInvocation that);

    /** Process an instance of _EllipsesTupleCoercionInvocation. */
    public abstract RetType for_EllipsesTupleCoercionInvocation(_EllipsesTupleCoercionInvocation that);

    /** Process an instance of _EllipsesArrowCoercionInvocation. */
    public abstract RetType for_EllipsesArrowCoercionInvocation(_EllipsesArrowCoercionInvocation that);

    /** Process an instance of _EllipsesUnionCoercionInvocation. */
    public abstract RetType for_EllipsesUnionCoercionInvocation(_EllipsesUnionCoercionInvocation that);

    /** Process an instance of _EllipsesMethodInvocation. */
    public abstract RetType for_EllipsesMethodInvocation(_EllipsesMethodInvocation that);

    /** Process an instance of _EllipsesMathPrimary. */
    public abstract RetType for_EllipsesMathPrimary(_EllipsesMathPrimary that);

    /** Process an instance of _EllipsesArrayExpr. */
    public abstract RetType for_EllipsesArrayExpr(_EllipsesArrayExpr that);

    /** Process an instance of _EllipsesArrayElement. */
    public abstract RetType for_EllipsesArrayElement(_EllipsesArrayElement that);

    /** Process an instance of _EllipsesArrayElements. */
    public abstract RetType for_EllipsesArrayElements(_EllipsesArrayElements that);

    /** Process an instance of TemplateGapExpr. */
    public abstract RetType forTemplateGapExpr(TemplateGapExpr that);

    /** Process an instance of TemplateGapDummyExpr. */
    public abstract RetType forTemplateGapDummyExpr(TemplateGapDummyExpr that);

    /** Process an instance of TemplateGapTypeAnnotatedExpr. */
    public abstract RetType forTemplateGapTypeAnnotatedExpr(TemplateGapTypeAnnotatedExpr that);

    /** Process an instance of TemplateGapAsExpr. */
    public abstract RetType forTemplateGapAsExpr(TemplateGapAsExpr that);

    /** Process an instance of TemplateGapAsIfExpr. */
    public abstract RetType forTemplateGapAsIfExpr(TemplateGapAsIfExpr that);

    /** Process an instance of TemplateGapAssignment. */
    public abstract RetType forTemplateGapAssignment(TemplateGapAssignment that);

    /** Process an instance of TemplateGapBlock. */
    public abstract RetType forTemplateGapBlock(TemplateGapBlock that);

    /** Process an instance of TemplateGapDo. */
    public abstract RetType forTemplateGapDo(TemplateGapDo that);

    /** Process an instance of TemplateGapCaseExpr. */
    public abstract RetType forTemplateGapCaseExpr(TemplateGapCaseExpr that);

    /** Process an instance of TemplateGapIf. */
    public abstract RetType forTemplateGapIf(TemplateGapIf that);

    /** Process an instance of TemplateGapLabel. */
    public abstract RetType forTemplateGapLabel(TemplateGapLabel that);

    /** Process an instance of TemplateGapAbstractObjectExpr. */
    public abstract RetType forTemplateGapAbstractObjectExpr(TemplateGapAbstractObjectExpr that);

    /** Process an instance of TemplateGapObjectExpr. */
    public abstract RetType forTemplateGapObjectExpr(TemplateGapObjectExpr that);

    /** Process an instance of TemplateGap_RewriteObjectExpr. */
    public abstract RetType forTemplateGap_RewriteObjectExpr(TemplateGap_RewriteObjectExpr that);

    /** Process an instance of TemplateGapTry. */
    public abstract RetType forTemplateGapTry(TemplateGapTry that);

    /** Process an instance of TemplateGapTupleExpr. */
    public abstract RetType forTemplateGapTupleExpr(TemplateGapTupleExpr that);

    /** Process an instance of TemplateGapTypecase. */
    public abstract RetType forTemplateGapTypecase(TemplateGapTypecase that);

    /** Process an instance of TemplateGapWhile. */
    public abstract RetType forTemplateGapWhile(TemplateGapWhile that);

    /** Process an instance of TemplateGapFor. */
    public abstract RetType forTemplateGapFor(TemplateGapFor that);

    /** Process an instance of TemplateGapBigOpApp. */
    public abstract RetType forTemplateGapBigOpApp(TemplateGapBigOpApp that);

    /** Process an instance of TemplateGapAccumulator. */
    public abstract RetType forTemplateGapAccumulator(TemplateGapAccumulator that);

    /** Process an instance of TemplateGapArrayComprehension. */
    public abstract RetType forTemplateGapArrayComprehension(TemplateGapArrayComprehension that);

    /** Process an instance of TemplateGapAtomicExpr. */
    public abstract RetType forTemplateGapAtomicExpr(TemplateGapAtomicExpr that);

    /** Process an instance of TemplateGapExit. */
    public abstract RetType forTemplateGapExit(TemplateGapExit that);

    /** Process an instance of TemplateGapSpawn. */
    public abstract RetType forTemplateGapSpawn(TemplateGapSpawn that);

    /** Process an instance of TemplateGapThrow. */
    public abstract RetType forTemplateGapThrow(TemplateGapThrow that);

    /** Process an instance of TemplateGapTryAtomicExpr. */
    public abstract RetType forTemplateGapTryAtomicExpr(TemplateGapTryAtomicExpr that);

    /** Process an instance of TemplateGapFnExpr. */
    public abstract RetType forTemplateGapFnExpr(TemplateGapFnExpr that);

    /** Process an instance of TemplateGapLetExpr. */
    public abstract RetType forTemplateGapLetExpr(TemplateGapLetExpr that);

    /** Process an instance of TemplateGapLetFn. */
    public abstract RetType forTemplateGapLetFn(TemplateGapLetFn that);

    /** Process an instance of TemplateGapLocalVarDecl. */
    public abstract RetType forTemplateGapLocalVarDecl(TemplateGapLocalVarDecl that);

    /** Process an instance of TemplateGapSimpleExpr. */
    public abstract RetType forTemplateGapSimpleExpr(TemplateGapSimpleExpr that);

    /** Process an instance of TemplateGapSubscriptExpr. */
    public abstract RetType forTemplateGapSubscriptExpr(TemplateGapSubscriptExpr that);

    /** Process an instance of TemplateGapPrimary. */
    public abstract RetType forTemplateGapPrimary(TemplateGapPrimary that);

    /** Process an instance of TemplateGapLiteralExpr. */
    public abstract RetType forTemplateGapLiteralExpr(TemplateGapLiteralExpr that);

    /** Process an instance of TemplateGapNumberLiteralExpr. */
    public abstract RetType forTemplateGapNumberLiteralExpr(TemplateGapNumberLiteralExpr that);

    /** Process an instance of TemplateGapFloatLiteralExpr. */
    public abstract RetType forTemplateGapFloatLiteralExpr(TemplateGapFloatLiteralExpr that);

    /** Process an instance of TemplateGapIntLiteralExpr. */
    public abstract RetType forTemplateGapIntLiteralExpr(TemplateGapIntLiteralExpr that);

    /** Process an instance of TemplateGapCharLiteralExpr. */
    public abstract RetType forTemplateGapCharLiteralExpr(TemplateGapCharLiteralExpr that);

    /** Process an instance of TemplateGapStringLiteralExpr. */
    public abstract RetType forTemplateGapStringLiteralExpr(TemplateGapStringLiteralExpr that);

    /** Process an instance of TemplateGapVoidLiteralExpr. */
    public abstract RetType forTemplateGapVoidLiteralExpr(TemplateGapVoidLiteralExpr that);

    /** Process an instance of TemplateGapBooleanLiteralExpr. */
    public abstract RetType forTemplateGapBooleanLiteralExpr(TemplateGapBooleanLiteralExpr that);

    /** Process an instance of TemplateGapVarRef. */
    public abstract RetType forTemplateGapVarRef(TemplateGapVarRef that);

    /** Process an instance of TemplateGapFieldRef. */
    public abstract RetType forTemplateGapFieldRef(TemplateGapFieldRef that);

    /** Process an instance of TemplateGapFunctionalRef. */
    public abstract RetType forTemplateGapFunctionalRef(TemplateGapFunctionalRef that);

    /** Process an instance of TemplateGapFnRef. */
    public abstract RetType forTemplateGapFnRef(TemplateGapFnRef that);

    /** Process an instance of TemplateGapOpRef. */
    public abstract RetType forTemplateGapOpRef(TemplateGapOpRef that);

    /** Process an instance of TemplateGap_RewriteFnRef. */
    public abstract RetType forTemplateGap_RewriteFnRef(TemplateGap_RewriteFnRef that);

    /** Process an instance of TemplateGap_RewriteObjectExprRef. */
    public abstract RetType forTemplateGap_RewriteObjectExprRef(TemplateGap_RewriteObjectExprRef that);

    /** Process an instance of TemplateGapJuxt. */
    public abstract RetType forTemplateGapJuxt(TemplateGapJuxt that);

    /** Process an instance of TemplateGap_RewriteFnApp. */
    public abstract RetType forTemplateGap_RewriteFnApp(TemplateGap_RewriteFnApp that);

    /** Process an instance of TemplateGapOpExpr. */
    public abstract RetType forTemplateGapOpExpr(TemplateGapOpExpr that);

    /** Process an instance of TemplateGapAmbiguousMultifixOpExpr. */
    public abstract RetType forTemplateGapAmbiguousMultifixOpExpr(TemplateGapAmbiguousMultifixOpExpr that);

    /** Process an instance of TemplateGapChainExpr. */
    public abstract RetType forTemplateGapChainExpr(TemplateGapChainExpr that);

    /** Process an instance of TemplateGapCoercionInvocation. */
    public abstract RetType forTemplateGapCoercionInvocation(TemplateGapCoercionInvocation that);

    /** Process an instance of TemplateGapTraitCoercionInvocation. */
    public abstract RetType forTemplateGapTraitCoercionInvocation(TemplateGapTraitCoercionInvocation that);

    /** Process an instance of TemplateGapTupleCoercionInvocation. */
    public abstract RetType forTemplateGapTupleCoercionInvocation(TemplateGapTupleCoercionInvocation that);

    /** Process an instance of TemplateGapArrowCoercionInvocation. */
    public abstract RetType forTemplateGapArrowCoercionInvocation(TemplateGapArrowCoercionInvocation that);

    /** Process an instance of TemplateGapUnionCoercionInvocation. */
    public abstract RetType forTemplateGapUnionCoercionInvocation(TemplateGapUnionCoercionInvocation that);

    /** Process an instance of TemplateGapMethodInvocation. */
    public abstract RetType forTemplateGapMethodInvocation(TemplateGapMethodInvocation that);

    /** Process an instance of TemplateGapMathPrimary. */
    public abstract RetType forTemplateGapMathPrimary(TemplateGapMathPrimary that);

    /** Process an instance of TemplateGapArrayExpr. */
    public abstract RetType forTemplateGapArrayExpr(TemplateGapArrayExpr that);

    /** Process an instance of TemplateGapArrayElement. */
    public abstract RetType forTemplateGapArrayElement(TemplateGapArrayElement that);

    /** Process an instance of TemplateGapArrayElements. */
    public abstract RetType forTemplateGapArrayElements(TemplateGapArrayElements that);
}
