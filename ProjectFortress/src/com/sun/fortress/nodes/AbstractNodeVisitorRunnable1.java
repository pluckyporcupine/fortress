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

/** An abstract void visitor over AbstractNode that provides a Runnable1 run method;
  * all visit methods are left unimplemented. */
@SuppressWarnings("unused")
public abstract class AbstractNodeVisitorRunnable1 implements edu.rice.cs.plt.lambda.Runnable1<AbstractNode>, AbstractNodeVisitor_void {

    public void run(AbstractNode that) {
        that.accept(this);
    }


    /** Process an instance of Component. */
    public abstract void forComponent(Component that);

    /** Process an instance of Api. */
    public abstract void forApi(Api that);

    /** Process an instance of ImportStar. */
    public abstract void forImportStar(ImportStar that);

    /** Process an instance of ImportNames. */
    public abstract void forImportNames(ImportNames that);

    /** Process an instance of ImportApi. */
    public abstract void forImportApi(ImportApi that);

    /** Process an instance of AliasedSimpleName. */
    public abstract void forAliasedSimpleName(AliasedSimpleName that);

    /** Process an instance of AliasedAPIName. */
    public abstract void forAliasedAPIName(AliasedAPIName that);

    /** Process an instance of TraitDecl. */
    public abstract void forTraitDecl(TraitDecl that);

    /** Process an instance of ObjectDecl. */
    public abstract void forObjectDecl(ObjectDecl that);

    /** Process an instance of VarDecl. */
    public abstract void forVarDecl(VarDecl that);

    /** Process an instance of FnDecl. */
    public abstract void forFnDecl(FnDecl that);

    /** Process an instance of _RewriteFnOverloadDecl. */
    public abstract void for_RewriteFnOverloadDecl(_RewriteFnOverloadDecl that);

    /** Process an instance of _RewriteObjectExprDecl. */
    public abstract void for_RewriteObjectExprDecl(_RewriteObjectExprDecl that);

    /** Process an instance of _RewriteFunctionalMethodDecl. */
    public abstract void for_RewriteFunctionalMethodDecl(_RewriteFunctionalMethodDecl that);

    /** Process an instance of DimDecl. */
    public abstract void forDimDecl(DimDecl that);

    /** Process an instance of UnitDecl. */
    public abstract void forUnitDecl(UnitDecl that);

    /** Process an instance of TestDecl. */
    public abstract void forTestDecl(TestDecl that);

    /** Process an instance of PropertyDecl. */
    public abstract void forPropertyDecl(PropertyDecl that);

    /** Process an instance of TypeAlias. */
    public abstract void forTypeAlias(TypeAlias that);

    /** Process an instance of GrammarDecl. */
    public abstract void forGrammarDecl(GrammarDecl that);

    /** Process an instance of NonterminalDef. */
    public abstract void forNonterminalDef(NonterminalDef that);

    /** Process an instance of NonterminalExtensionDef. */
    public abstract void forNonterminalExtensionDef(NonterminalExtensionDef that);

    /** Process an instance of LValue. */
    public abstract void forLValue(LValue that);

    /** Process an instance of Param. */
    public abstract void forParam(Param that);

    /** Process an instance of DummyExpr. */
    public abstract void forDummyExpr(DummyExpr that);

    /** Process an instance of AsExpr. */
    public abstract void forAsExpr(AsExpr that);

    /** Process an instance of AsIfExpr. */
    public abstract void forAsIfExpr(AsIfExpr that);

    /** Process an instance of Assignment. */
    public abstract void forAssignment(Assignment that);

    /** Process an instance of Block. */
    public abstract void forBlock(Block that);

    /** Process an instance of Do. */
    public abstract void forDo(Do that);

    /** Process an instance of CaseExpr. */
    public abstract void forCaseExpr(CaseExpr that);

    /** Process an instance of If. */
    public abstract void forIf(If that);

    /** Process an instance of Label. */
    public abstract void forLabel(Label that);

    /** Process an instance of ObjectExpr. */
    public abstract void forObjectExpr(ObjectExpr that);

    /** Process an instance of _RewriteObjectExpr. */
    public abstract void for_RewriteObjectExpr(_RewriteObjectExpr that);

    /** Process an instance of Try. */
    public abstract void forTry(Try that);

    /** Process an instance of TupleExpr. */
    public abstract void forTupleExpr(TupleExpr that);

    /** Process an instance of Typecase. */
    public abstract void forTypecase(Typecase that);

    /** Process an instance of While. */
    public abstract void forWhile(While that);

    /** Process an instance of For. */
    public abstract void forFor(For that);

    /** Process an instance of Accumulator. */
    public abstract void forAccumulator(Accumulator that);

    /** Process an instance of ArrayComprehension. */
    public abstract void forArrayComprehension(ArrayComprehension that);

    /** Process an instance of AtomicExpr. */
    public abstract void forAtomicExpr(AtomicExpr that);

    /** Process an instance of Exit. */
    public abstract void forExit(Exit that);

    /** Process an instance of Spawn. */
    public abstract void forSpawn(Spawn that);

    /** Process an instance of Throw. */
    public abstract void forThrow(Throw that);

    /** Process an instance of TryAtomicExpr. */
    public abstract void forTryAtomicExpr(TryAtomicExpr that);

    /** Process an instance of FnExpr. */
    public abstract void forFnExpr(FnExpr that);

    /** Process an instance of LetFn. */
    public abstract void forLetFn(LetFn that);

    /** Process an instance of LocalVarDecl. */
    public abstract void forLocalVarDecl(LocalVarDecl that);

    /** Process an instance of SubscriptExpr. */
    public abstract void forSubscriptExpr(SubscriptExpr that);

    /** Process an instance of FloatLiteralExpr. */
    public abstract void forFloatLiteralExpr(FloatLiteralExpr that);

    /** Process an instance of IntLiteralExpr. */
    public abstract void forIntLiteralExpr(IntLiteralExpr that);

    /** Process an instance of CharLiteralExpr. */
    public abstract void forCharLiteralExpr(CharLiteralExpr that);

    /** Process an instance of StringLiteralExpr. */
    public abstract void forStringLiteralExpr(StringLiteralExpr that);

    /** Process an instance of VoidLiteralExpr. */
    public abstract void forVoidLiteralExpr(VoidLiteralExpr that);

    /** Process an instance of BooleanLiteralExpr. */
    public abstract void forBooleanLiteralExpr(BooleanLiteralExpr that);

    /** Process an instance of VarRef. */
    public abstract void forVarRef(VarRef that);

    /** Process an instance of FieldRef. */
    public abstract void forFieldRef(FieldRef that);

    /** Process an instance of FnRef. */
    public abstract void forFnRef(FnRef that);

    /** Process an instance of OpRef. */
    public abstract void forOpRef(OpRef that);

    /** Process an instance of _RewriteFnRef. */
    public abstract void for_RewriteFnRef(_RewriteFnRef that);

    /** Process an instance of _RewriteObjectExprRef. */
    public abstract void for_RewriteObjectExprRef(_RewriteObjectExprRef that);

    /** Process an instance of Juxt. */
    public abstract void forJuxt(Juxt that);

    /** Process an instance of _RewriteFnApp. */
    public abstract void for_RewriteFnApp(_RewriteFnApp that);

    /** Process an instance of OpExpr. */
    public abstract void forOpExpr(OpExpr that);

    /** Process an instance of AmbiguousMultifixOpExpr. */
    public abstract void forAmbiguousMultifixOpExpr(AmbiguousMultifixOpExpr that);

    /** Process an instance of ChainExpr. */
    public abstract void forChainExpr(ChainExpr that);

    /** Process an instance of TraitCoercionInvocation. */
    public abstract void forTraitCoercionInvocation(TraitCoercionInvocation that);

    /** Process an instance of TupleCoercionInvocation. */
    public abstract void forTupleCoercionInvocation(TupleCoercionInvocation that);

    /** Process an instance of ArrowCoercionInvocation. */
    public abstract void forArrowCoercionInvocation(ArrowCoercionInvocation that);

    /** Process an instance of UnionCoercionInvocation. */
    public abstract void forUnionCoercionInvocation(UnionCoercionInvocation that);

    /** Process an instance of MethodInvocation. */
    public abstract void forMethodInvocation(MethodInvocation that);

    /** Process an instance of MathPrimary. */
    public abstract void forMathPrimary(MathPrimary that);

    /** Process an instance of ArrayElement. */
    public abstract void forArrayElement(ArrayElement that);

    /** Process an instance of ArrayElements. */
    public abstract void forArrayElements(ArrayElements that);

    /** Process an instance of AnyType. */
    public abstract void forAnyType(AnyType that);

    /** Process an instance of BottomType. */
    public abstract void forBottomType(BottomType that);

    /** Process an instance of UnknownType. */
    public abstract void forUnknownType(UnknownType that);

    /** Process an instance of TraitSelfType. */
    public abstract void forTraitSelfType(TraitSelfType that);

    /** Process an instance of ObjectExprType. */
    public abstract void forObjectExprType(ObjectExprType that);

    /** Process an instance of _InferenceVarType. */
    public abstract void for_InferenceVarType(_InferenceVarType that);

    /** Process an instance of VarType. */
    public abstract void forVarType(VarType that);

    /** Process an instance of TraitType. */
    public abstract void forTraitType(TraitType that);

    /** Process an instance of ArrayType. */
    public abstract void forArrayType(ArrayType that);

    /** Process an instance of MatrixType. */
    public abstract void forMatrixType(MatrixType that);

    /** Process an instance of TaggedDimType. */
    public abstract void forTaggedDimType(TaggedDimType that);

    /** Process an instance of TaggedUnitType. */
    public abstract void forTaggedUnitType(TaggedUnitType that);

    /** Process an instance of TupleType. */
    public abstract void forTupleType(TupleType that);

    /** Process an instance of ArrowType. */
    public abstract void forArrowType(ArrowType that);

    /** Process an instance of IntersectionType. */
    public abstract void forIntersectionType(IntersectionType that);

    /** Process an instance of UnionType. */
    public abstract void forUnionType(UnionType that);

    /** Process an instance of FixedPointType. */
    public abstract void forFixedPointType(FixedPointType that);

    /** Process an instance of LabelType. */
    public abstract void forLabelType(LabelType that);

    /** Process an instance of DimBase. */
    public abstract void forDimBase(DimBase that);

    /** Process an instance of DimRef. */
    public abstract void forDimRef(DimRef that);

    /** Process an instance of DimExponent. */
    public abstract void forDimExponent(DimExponent that);

    /** Process an instance of DimUnaryOp. */
    public abstract void forDimUnaryOp(DimUnaryOp that);

    /** Process an instance of DimBinaryOp. */
    public abstract void forDimBinaryOp(DimBinaryOp that);

    /** Process an instance of Pattern. */
    public abstract void forPattern(Pattern that);

    /** Process an instance of PatternArgs. */
    public abstract void forPatternArgs(PatternArgs that);

    /** Process an instance of PlainPattern. */
    public abstract void forPlainPattern(PlainPattern that);

    /** Process an instance of TypePattern. */
    public abstract void forTypePattern(TypePattern that);

    /** Process an instance of NestedPattern. */
    public abstract void forNestedPattern(NestedPattern that);

    /** Process an instance of TypeArg. */
    public abstract void forTypeArg(TypeArg that);

    /** Process an instance of IntArg. */
    public abstract void forIntArg(IntArg that);

    /** Process an instance of BoolArg. */
    public abstract void forBoolArg(BoolArg that);

    /** Process an instance of OpArg. */
    public abstract void forOpArg(OpArg that);

    /** Process an instance of DimArg. */
    public abstract void forDimArg(DimArg that);

    /** Process an instance of UnitArg. */
    public abstract void forUnitArg(UnitArg that);

    /** Process an instance of IntBase. */
    public abstract void forIntBase(IntBase that);

    /** Process an instance of IntRef. */
    public abstract void forIntRef(IntRef that);

    /** Process an instance of IntBinaryOp. */
    public abstract void forIntBinaryOp(IntBinaryOp that);

    /** Process an instance of BoolBase. */
    public abstract void forBoolBase(BoolBase that);

    /** Process an instance of BoolRef. */
    public abstract void forBoolRef(BoolRef that);

    /** Process an instance of BoolUnaryOp. */
    public abstract void forBoolUnaryOp(BoolUnaryOp that);

    /** Process an instance of BoolBinaryOp. */
    public abstract void forBoolBinaryOp(BoolBinaryOp that);

    /** Process an instance of UnitRef. */
    public abstract void forUnitRef(UnitRef that);

    /** Process an instance of UnitBinaryOp. */
    public abstract void forUnitBinaryOp(UnitBinaryOp that);

    /** Process an instance of Effect. */
    public abstract void forEffect(Effect that);

    /** Process an instance of WhereClause. */
    public abstract void forWhereClause(WhereClause that);

    /** Process an instance of WhereBinding. */
    public abstract void forWhereBinding(WhereBinding that);

    /** Process an instance of WhereExtends. */
    public abstract void forWhereExtends(WhereExtends that);

    /** Process an instance of WhereTypeAlias. */
    public abstract void forWhereTypeAlias(WhereTypeAlias that);

    /** Process an instance of WhereCoerces. */
    public abstract void forWhereCoerces(WhereCoerces that);

    /** Process an instance of WhereEquals. */
    public abstract void forWhereEquals(WhereEquals that);

    /** Process an instance of UnitConstraint. */
    public abstract void forUnitConstraint(UnitConstraint that);

    /** Process an instance of IntConstraint. */
    public abstract void forIntConstraint(IntConstraint that);

    /** Process an instance of BoolConstraintExpr. */
    public abstract void forBoolConstraintExpr(BoolConstraintExpr that);

    /** Process an instance of Contract. */
    public abstract void forContract(Contract that);

    /** Process an instance of EnsuresClause. */
    public abstract void forEnsuresClause(EnsuresClause that);

    /** Process an instance of StaticParam. */
    public abstract void forStaticParam(StaticParam that);

    /** Process an instance of APIName. */
    public abstract void forAPIName(APIName that);

    /** Process an instance of Id. */
    public abstract void forId(Id that);

    /** Process an instance of NamedOp. */
    public abstract void forNamedOp(NamedOp that);

    /** Process an instance of _InferenceVarOp. */
    public abstract void for_InferenceVarOp(_InferenceVarOp that);

    /** Process an instance of AnonymousFnName. */
    public abstract void forAnonymousFnName(AnonymousFnName that);

    /** Process an instance of ConstructorFnName. */
    public abstract void forConstructorFnName(ConstructorFnName that);

    /** Process an instance of ArrayComprehensionClause. */
    public abstract void forArrayComprehensionClause(ArrayComprehensionClause that);

    /** Process an instance of KeywordExpr. */
    public abstract void forKeywordExpr(KeywordExpr that);

    /** Process an instance of CaseClause. */
    public abstract void forCaseClause(CaseClause that);

    /** Process an instance of Catch. */
    public abstract void forCatch(Catch that);

    /** Process an instance of CatchClause. */
    public abstract void forCatchClause(CatchClause that);

    /** Process an instance of IfClause. */
    public abstract void forIfClause(IfClause that);

    /** Process an instance of TypecaseClause. */
    public abstract void forTypecaseClause(TypecaseClause that);

    /** Process an instance of ExtentRange. */
    public abstract void forExtentRange(ExtentRange that);

    /** Process an instance of GeneratorClause. */
    public abstract void forGeneratorClause(GeneratorClause that);

    /** Process an instance of KeywordType. */
    public abstract void forKeywordType(KeywordType that);

    /** Process an instance of TraitTypeWhere. */
    public abstract void forTraitTypeWhere(TraitTypeWhere that);

    /** Process an instance of Indices. */
    public abstract void forIndices(Indices that);

    /** Process an instance of ParenthesisDelimitedMI. */
    public abstract void forParenthesisDelimitedMI(ParenthesisDelimitedMI that);

    /** Process an instance of NonParenthesisDelimitedMI. */
    public abstract void forNonParenthesisDelimitedMI(NonParenthesisDelimitedMI that);

    /** Process an instance of ExponentiationMI. */
    public abstract void forExponentiationMI(ExponentiationMI that);

    /** Process an instance of SubscriptingMI. */
    public abstract void forSubscriptingMI(SubscriptingMI that);

    /** Process an instance of Overloading. */
    public abstract void forOverloading(Overloading that);

    /** Process an instance of NonterminalHeader. */
    public abstract void forNonterminalHeader(NonterminalHeader that);

    /** Process an instance of NonterminalParameter. */
    public abstract void forNonterminalParameter(NonterminalParameter that);

    /** Process an instance of SyntaxDef. */
    public abstract void forSyntaxDef(SyntaxDef that);

    /** Process an instance of SuperSyntaxDef. */
    public abstract void forSuperSyntaxDef(SuperSyntaxDef that);

    /** Process an instance of PreTransformerDef. */
    public abstract void forPreTransformerDef(PreTransformerDef that);

    /** Process an instance of NamedTransformerDef. */
    public abstract void forNamedTransformerDef(NamedTransformerDef that);

    /** Process an instance of UnparsedTransformer. */
    public abstract void forUnparsedTransformer(UnparsedTransformer that);

    /** Process an instance of NodeTransformer. */
    public abstract void forNodeTransformer(NodeTransformer that);

    /** Process an instance of CaseTransformer. */
    public abstract void forCaseTransformer(CaseTransformer that);

    /** Process an instance of CaseTransformerClause. */
    public abstract void forCaseTransformerClause(CaseTransformerClause that);

    /** Process an instance of PrefixedSymbol. */
    public abstract void forPrefixedSymbol(PrefixedSymbol that);

    /** Process an instance of OptionalSymbol. */
    public abstract void forOptionalSymbol(OptionalSymbol that);

    /** Process an instance of RepeatSymbol. */
    public abstract void forRepeatSymbol(RepeatSymbol that);

    /** Process an instance of RepeatOneOrMoreSymbol. */
    public abstract void forRepeatOneOrMoreSymbol(RepeatOneOrMoreSymbol that);

    /** Process an instance of NoWhitespaceSymbol. */
    public abstract void forNoWhitespaceSymbol(NoWhitespaceSymbol that);

    /** Process an instance of GroupSymbol. */
    public abstract void forGroupSymbol(GroupSymbol that);

    /** Process an instance of AnyCharacterSymbol. */
    public abstract void forAnyCharacterSymbol(AnyCharacterSymbol that);

    /** Process an instance of WhitespaceSymbol. */
    public abstract void forWhitespaceSymbol(WhitespaceSymbol that);

    /** Process an instance of TabSymbol. */
    public abstract void forTabSymbol(TabSymbol that);

    /** Process an instance of FormfeedSymbol. */
    public abstract void forFormfeedSymbol(FormfeedSymbol that);

    /** Process an instance of CarriageReturnSymbol. */
    public abstract void forCarriageReturnSymbol(CarriageReturnSymbol that);

    /** Process an instance of BackspaceSymbol. */
    public abstract void forBackspaceSymbol(BackspaceSymbol that);

    /** Process an instance of NewlineSymbol. */
    public abstract void forNewlineSymbol(NewlineSymbol that);

    /** Process an instance of BreaklineSymbol. */
    public abstract void forBreaklineSymbol(BreaklineSymbol that);

    /** Process an instance of ItemSymbol. */
    public abstract void forItemSymbol(ItemSymbol that);

    /** Process an instance of NonterminalSymbol. */
    public abstract void forNonterminalSymbol(NonterminalSymbol that);

    /** Process an instance of KeywordSymbol. */
    public abstract void forKeywordSymbol(KeywordSymbol that);

    /** Process an instance of TokenSymbol. */
    public abstract void forTokenSymbol(TokenSymbol that);

    /** Process an instance of NotPredicateSymbol. */
    public abstract void forNotPredicateSymbol(NotPredicateSymbol that);

    /** Process an instance of AndPredicateSymbol. */
    public abstract void forAndPredicateSymbol(AndPredicateSymbol that);

    /** Process an instance of CharacterClassSymbol. */
    public abstract void forCharacterClassSymbol(CharacterClassSymbol that);

    /** Process an instance of CharSymbol. */
    public abstract void forCharSymbol(CharSymbol that);

    /** Process an instance of CharacterInterval. */
    public abstract void forCharacterInterval(CharacterInterval that);

    /** Process an instance of Link. */
    public abstract void forLink(Link that);

    /** Process an instance of _SyntaxTransformationAbstractNode. */
    public abstract void for_SyntaxTransformationAbstractNode(_SyntaxTransformationAbstractNode that);

    /** Process an instance of _SyntaxTransformationCompilationUnit. */
    public abstract void for_SyntaxTransformationCompilationUnit(_SyntaxTransformationCompilationUnit that);

    /** Process an instance of _SyntaxTransformationComponent. */
    public abstract void for_SyntaxTransformationComponent(_SyntaxTransformationComponent that);

    /** Process an instance of _SyntaxTransformationApi. */
    public abstract void for_SyntaxTransformationApi(_SyntaxTransformationApi that);

    /** Process an instance of _SyntaxTransformationImport. */
    public abstract void for_SyntaxTransformationImport(_SyntaxTransformationImport that);

    /** Process an instance of _SyntaxTransformationImportedNames. */
    public abstract void for_SyntaxTransformationImportedNames(_SyntaxTransformationImportedNames that);

    /** Process an instance of _SyntaxTransformationImportStar. */
    public abstract void for_SyntaxTransformationImportStar(_SyntaxTransformationImportStar that);

    /** Process an instance of _SyntaxTransformationImportNames. */
    public abstract void for_SyntaxTransformationImportNames(_SyntaxTransformationImportNames that);

    /** Process an instance of _SyntaxTransformationImportApi. */
    public abstract void for_SyntaxTransformationImportApi(_SyntaxTransformationImportApi that);

    /** Process an instance of _SyntaxTransformationAliasedSimpleName. */
    public abstract void for_SyntaxTransformationAliasedSimpleName(_SyntaxTransformationAliasedSimpleName that);

    /** Process an instance of _SyntaxTransformationAliasedAPIName. */
    public abstract void for_SyntaxTransformationAliasedAPIName(_SyntaxTransformationAliasedAPIName that);

    /** Process an instance of _SyntaxTransformationDecl. */
    public abstract void for_SyntaxTransformationDecl(_SyntaxTransformationDecl that);

    /** Process an instance of _SyntaxTransformationTraitObjectDecl. */
    public abstract void for_SyntaxTransformationTraitObjectDecl(_SyntaxTransformationTraitObjectDecl that);

    /** Process an instance of _SyntaxTransformationTraitDecl. */
    public abstract void for_SyntaxTransformationTraitDecl(_SyntaxTransformationTraitDecl that);

    /** Process an instance of _SyntaxTransformationObjectDecl. */
    public abstract void for_SyntaxTransformationObjectDecl(_SyntaxTransformationObjectDecl that);

    /** Process an instance of _SyntaxTransformationVarDecl. */
    public abstract void for_SyntaxTransformationVarDecl(_SyntaxTransformationVarDecl that);

    /** Process an instance of _SyntaxTransformationFnDecl. */
    public abstract void for_SyntaxTransformationFnDecl(_SyntaxTransformationFnDecl that);

    /** Process an instance of _SyntaxTransformation_RewriteFnOverloadDecl. */
    public abstract void for_SyntaxTransformation_RewriteFnOverloadDecl(_SyntaxTransformation_RewriteFnOverloadDecl that);

    /** Process an instance of _SyntaxTransformation_RewriteObjectExprDecl. */
    public abstract void for_SyntaxTransformation_RewriteObjectExprDecl(_SyntaxTransformation_RewriteObjectExprDecl that);

    /** Process an instance of _SyntaxTransformation_RewriteFunctionalMethodDecl. */
    public abstract void for_SyntaxTransformation_RewriteFunctionalMethodDecl(_SyntaxTransformation_RewriteFunctionalMethodDecl that);

    /** Process an instance of _SyntaxTransformationDimUnitDecl. */
    public abstract void for_SyntaxTransformationDimUnitDecl(_SyntaxTransformationDimUnitDecl that);

    /** Process an instance of _SyntaxTransformationDimDecl. */
    public abstract void for_SyntaxTransformationDimDecl(_SyntaxTransformationDimDecl that);

    /** Process an instance of _SyntaxTransformationUnitDecl. */
    public abstract void for_SyntaxTransformationUnitDecl(_SyntaxTransformationUnitDecl that);

    /** Process an instance of _SyntaxTransformationTestDecl. */
    public abstract void for_SyntaxTransformationTestDecl(_SyntaxTransformationTestDecl that);

    /** Process an instance of _SyntaxTransformationPropertyDecl. */
    public abstract void for_SyntaxTransformationPropertyDecl(_SyntaxTransformationPropertyDecl that);

    /** Process an instance of _SyntaxTransformationTypeAlias. */
    public abstract void for_SyntaxTransformationTypeAlias(_SyntaxTransformationTypeAlias that);

    /** Process an instance of _SyntaxTransformationGrammarDecl. */
    public abstract void for_SyntaxTransformationGrammarDecl(_SyntaxTransformationGrammarDecl that);

    /** Process an instance of _SyntaxTransformationGrammarMemberDecl. */
    public abstract void for_SyntaxTransformationGrammarMemberDecl(_SyntaxTransformationGrammarMemberDecl that);

    /** Process an instance of _SyntaxTransformationNonterminalDecl. */
    public abstract void for_SyntaxTransformationNonterminalDecl(_SyntaxTransformationNonterminalDecl that);

    /** Process an instance of _SyntaxTransformationNonterminalDef. */
    public abstract void for_SyntaxTransformationNonterminalDef(_SyntaxTransformationNonterminalDef that);

    /** Process an instance of _SyntaxTransformationNonterminalExtensionDef. */
    public abstract void for_SyntaxTransformationNonterminalExtensionDef(_SyntaxTransformationNonterminalExtensionDef that);

    /** Process an instance of _SyntaxTransformationBinding. */
    public abstract void for_SyntaxTransformationBinding(_SyntaxTransformationBinding that);

    /** Process an instance of _SyntaxTransformationLValue. */
    public abstract void for_SyntaxTransformationLValue(_SyntaxTransformationLValue that);

    /** Process an instance of _SyntaxTransformationParam. */
    public abstract void for_SyntaxTransformationParam(_SyntaxTransformationParam that);

    /** Process an instance of _SyntaxTransformationExpr. */
    public abstract void for_SyntaxTransformationExpr(_SyntaxTransformationExpr that);

    /** Process an instance of _SyntaxTransformationDummyExpr. */
    public abstract void for_SyntaxTransformationDummyExpr(_SyntaxTransformationDummyExpr that);

    /** Process an instance of _SyntaxTransformationTypeAnnotatedExpr. */
    public abstract void for_SyntaxTransformationTypeAnnotatedExpr(_SyntaxTransformationTypeAnnotatedExpr that);

    /** Process an instance of _SyntaxTransformationAsExpr. */
    public abstract void for_SyntaxTransformationAsExpr(_SyntaxTransformationAsExpr that);

    /** Process an instance of _SyntaxTransformationAsIfExpr. */
    public abstract void for_SyntaxTransformationAsIfExpr(_SyntaxTransformationAsIfExpr that);

    /** Process an instance of _SyntaxTransformationAssignment. */
    public abstract void for_SyntaxTransformationAssignment(_SyntaxTransformationAssignment that);

    /** Process an instance of _SyntaxTransformationBlock. */
    public abstract void for_SyntaxTransformationBlock(_SyntaxTransformationBlock that);

    /** Process an instance of _SyntaxTransformationDo. */
    public abstract void for_SyntaxTransformationDo(_SyntaxTransformationDo that);

    /** Process an instance of _SyntaxTransformationCaseExpr. */
    public abstract void for_SyntaxTransformationCaseExpr(_SyntaxTransformationCaseExpr that);

    /** Process an instance of _SyntaxTransformationIf. */
    public abstract void for_SyntaxTransformationIf(_SyntaxTransformationIf that);

    /** Process an instance of _SyntaxTransformationLabel. */
    public abstract void for_SyntaxTransformationLabel(_SyntaxTransformationLabel that);

    /** Process an instance of _SyntaxTransformationAbstractObjectExpr. */
    public abstract void for_SyntaxTransformationAbstractObjectExpr(_SyntaxTransformationAbstractObjectExpr that);

    /** Process an instance of _SyntaxTransformationObjectExpr. */
    public abstract void for_SyntaxTransformationObjectExpr(_SyntaxTransformationObjectExpr that);

    /** Process an instance of _SyntaxTransformation_RewriteObjectExpr. */
    public abstract void for_SyntaxTransformation_RewriteObjectExpr(_SyntaxTransformation_RewriteObjectExpr that);

    /** Process an instance of _SyntaxTransformationTry. */
    public abstract void for_SyntaxTransformationTry(_SyntaxTransformationTry that);

    /** Process an instance of _SyntaxTransformationTupleExpr. */
    public abstract void for_SyntaxTransformationTupleExpr(_SyntaxTransformationTupleExpr that);

    /** Process an instance of _SyntaxTransformationTypecase. */
    public abstract void for_SyntaxTransformationTypecase(_SyntaxTransformationTypecase that);

    /** Process an instance of _SyntaxTransformationWhile. */
    public abstract void for_SyntaxTransformationWhile(_SyntaxTransformationWhile that);

    /** Process an instance of _SyntaxTransformationFor. */
    public abstract void for_SyntaxTransformationFor(_SyntaxTransformationFor that);

    /** Process an instance of _SyntaxTransformationBigOpApp. */
    public abstract void for_SyntaxTransformationBigOpApp(_SyntaxTransformationBigOpApp that);

    /** Process an instance of _SyntaxTransformationAccumulator. */
    public abstract void for_SyntaxTransformationAccumulator(_SyntaxTransformationAccumulator that);

    /** Process an instance of _SyntaxTransformationArrayComprehension. */
    public abstract void for_SyntaxTransformationArrayComprehension(_SyntaxTransformationArrayComprehension that);

    /** Process an instance of _SyntaxTransformationAtomicExpr. */
    public abstract void for_SyntaxTransformationAtomicExpr(_SyntaxTransformationAtomicExpr that);

    /** Process an instance of _SyntaxTransformationExit. */
    public abstract void for_SyntaxTransformationExit(_SyntaxTransformationExit that);

    /** Process an instance of _SyntaxTransformationSpawn. */
    public abstract void for_SyntaxTransformationSpawn(_SyntaxTransformationSpawn that);

    /** Process an instance of _SyntaxTransformationThrow. */
    public abstract void for_SyntaxTransformationThrow(_SyntaxTransformationThrow that);

    /** Process an instance of _SyntaxTransformationTryAtomicExpr. */
    public abstract void for_SyntaxTransformationTryAtomicExpr(_SyntaxTransformationTryAtomicExpr that);

    /** Process an instance of _SyntaxTransformationFnExpr. */
    public abstract void for_SyntaxTransformationFnExpr(_SyntaxTransformationFnExpr that);

    /** Process an instance of _SyntaxTransformationLetExpr. */
    public abstract void for_SyntaxTransformationLetExpr(_SyntaxTransformationLetExpr that);

    /** Process an instance of _SyntaxTransformationLetFn. */
    public abstract void for_SyntaxTransformationLetFn(_SyntaxTransformationLetFn that);

    /** Process an instance of _SyntaxTransformationLocalVarDecl. */
    public abstract void for_SyntaxTransformationLocalVarDecl(_SyntaxTransformationLocalVarDecl that);

    /** Process an instance of _SyntaxTransformationSimpleExpr. */
    public abstract void for_SyntaxTransformationSimpleExpr(_SyntaxTransformationSimpleExpr that);

    /** Process an instance of _SyntaxTransformationSubscriptExpr. */
    public abstract void for_SyntaxTransformationSubscriptExpr(_SyntaxTransformationSubscriptExpr that);

    /** Process an instance of _SyntaxTransformationPrimary. */
    public abstract void for_SyntaxTransformationPrimary(_SyntaxTransformationPrimary that);

    /** Process an instance of _SyntaxTransformationLiteralExpr. */
    public abstract void for_SyntaxTransformationLiteralExpr(_SyntaxTransformationLiteralExpr that);

    /** Process an instance of _SyntaxTransformationNumberLiteralExpr. */
    public abstract void for_SyntaxTransformationNumberLiteralExpr(_SyntaxTransformationNumberLiteralExpr that);

    /** Process an instance of _SyntaxTransformationFloatLiteralExpr. */
    public abstract void for_SyntaxTransformationFloatLiteralExpr(_SyntaxTransformationFloatLiteralExpr that);

    /** Process an instance of _SyntaxTransformationIntLiteralExpr. */
    public abstract void for_SyntaxTransformationIntLiteralExpr(_SyntaxTransformationIntLiteralExpr that);

    /** Process an instance of _SyntaxTransformationCharLiteralExpr. */
    public abstract void for_SyntaxTransformationCharLiteralExpr(_SyntaxTransformationCharLiteralExpr that);

    /** Process an instance of _SyntaxTransformationStringLiteralExpr. */
    public abstract void for_SyntaxTransformationStringLiteralExpr(_SyntaxTransformationStringLiteralExpr that);

    /** Process an instance of _SyntaxTransformationVoidLiteralExpr. */
    public abstract void for_SyntaxTransformationVoidLiteralExpr(_SyntaxTransformationVoidLiteralExpr that);

    /** Process an instance of _SyntaxTransformationBooleanLiteralExpr. */
    public abstract void for_SyntaxTransformationBooleanLiteralExpr(_SyntaxTransformationBooleanLiteralExpr that);

    /** Process an instance of _SyntaxTransformationVarRef. */
    public abstract void for_SyntaxTransformationVarRef(_SyntaxTransformationVarRef that);

    /** Process an instance of _SyntaxTransformationFieldRef. */
    public abstract void for_SyntaxTransformationFieldRef(_SyntaxTransformationFieldRef that);

    /** Process an instance of _SyntaxTransformationFunctionalRef. */
    public abstract void for_SyntaxTransformationFunctionalRef(_SyntaxTransformationFunctionalRef that);

    /** Process an instance of _SyntaxTransformationFnRef. */
    public abstract void for_SyntaxTransformationFnRef(_SyntaxTransformationFnRef that);

    /** Process an instance of _SyntaxTransformationOpRef. */
    public abstract void for_SyntaxTransformationOpRef(_SyntaxTransformationOpRef that);

    /** Process an instance of _SyntaxTransformation_RewriteFnRef. */
    public abstract void for_SyntaxTransformation_RewriteFnRef(_SyntaxTransformation_RewriteFnRef that);

    /** Process an instance of _SyntaxTransformation_RewriteObjectExprRef. */
    public abstract void for_SyntaxTransformation_RewriteObjectExprRef(_SyntaxTransformation_RewriteObjectExprRef that);

    /** Process an instance of _SyntaxTransformationJuxt. */
    public abstract void for_SyntaxTransformationJuxt(_SyntaxTransformationJuxt that);

    /** Process an instance of _SyntaxTransformation_RewriteFnApp. */
    public abstract void for_SyntaxTransformation_RewriteFnApp(_SyntaxTransformation_RewriteFnApp that);

    /** Process an instance of _SyntaxTransformationOpExpr. */
    public abstract void for_SyntaxTransformationOpExpr(_SyntaxTransformationOpExpr that);

    /** Process an instance of _SyntaxTransformationAmbiguousMultifixOpExpr. */
    public abstract void for_SyntaxTransformationAmbiguousMultifixOpExpr(_SyntaxTransformationAmbiguousMultifixOpExpr that);

    /** Process an instance of _SyntaxTransformationChainExpr. */
    public abstract void for_SyntaxTransformationChainExpr(_SyntaxTransformationChainExpr that);

    /** Process an instance of _SyntaxTransformationCoercionInvocation. */
    public abstract void for_SyntaxTransformationCoercionInvocation(_SyntaxTransformationCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationTraitCoercionInvocation. */
    public abstract void for_SyntaxTransformationTraitCoercionInvocation(_SyntaxTransformationTraitCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationTupleCoercionInvocation. */
    public abstract void for_SyntaxTransformationTupleCoercionInvocation(_SyntaxTransformationTupleCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationArrowCoercionInvocation. */
    public abstract void for_SyntaxTransformationArrowCoercionInvocation(_SyntaxTransformationArrowCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationUnionCoercionInvocation. */
    public abstract void for_SyntaxTransformationUnionCoercionInvocation(_SyntaxTransformationUnionCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationMethodInvocation. */
    public abstract void for_SyntaxTransformationMethodInvocation(_SyntaxTransformationMethodInvocation that);

    /** Process an instance of _SyntaxTransformationMathPrimary. */
    public abstract void for_SyntaxTransformationMathPrimary(_SyntaxTransformationMathPrimary that);

    /** Process an instance of _SyntaxTransformationArrayExpr. */
    public abstract void for_SyntaxTransformationArrayExpr(_SyntaxTransformationArrayExpr that);

    /** Process an instance of _SyntaxTransformationArrayElement. */
    public abstract void for_SyntaxTransformationArrayElement(_SyntaxTransformationArrayElement that);

    /** Process an instance of _SyntaxTransformationArrayElements. */
    public abstract void for_SyntaxTransformationArrayElements(_SyntaxTransformationArrayElements that);

    /** Process an instance of _SyntaxTransformationType. */
    public abstract void for_SyntaxTransformationType(_SyntaxTransformationType that);

    /** Process an instance of _SyntaxTransformationBaseType. */
    public abstract void for_SyntaxTransformationBaseType(_SyntaxTransformationBaseType that);

    /** Process an instance of _SyntaxTransformationAnyType. */
    public abstract void for_SyntaxTransformationAnyType(_SyntaxTransformationAnyType that);

    /** Process an instance of _SyntaxTransformationBottomType. */
    public abstract void for_SyntaxTransformationBottomType(_SyntaxTransformationBottomType that);

    /** Process an instance of _SyntaxTransformationUnknownType. */
    public abstract void for_SyntaxTransformationUnknownType(_SyntaxTransformationUnknownType that);

    /** Process an instance of _SyntaxTransformationSelfType. */
    public abstract void for_SyntaxTransformationSelfType(_SyntaxTransformationSelfType that);

    /** Process an instance of _SyntaxTransformationTraitSelfType. */
    public abstract void for_SyntaxTransformationTraitSelfType(_SyntaxTransformationTraitSelfType that);

    /** Process an instance of _SyntaxTransformationObjectExprType. */
    public abstract void for_SyntaxTransformationObjectExprType(_SyntaxTransformationObjectExprType that);

    /** Process an instance of _SyntaxTransformationNamedType. */
    public abstract void for_SyntaxTransformationNamedType(_SyntaxTransformationNamedType that);

    /** Process an instance of _SyntaxTransformation_InferenceVarType. */
    public abstract void for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that);

    /** Process an instance of _SyntaxTransformationVarType. */
    public abstract void for_SyntaxTransformationVarType(_SyntaxTransformationVarType that);

    /** Process an instance of _SyntaxTransformationTraitType. */
    public abstract void for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that);

    /** Process an instance of _SyntaxTransformationAbbreviatedType. */
    public abstract void for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that);

    /** Process an instance of _SyntaxTransformationArrayType. */
    public abstract void for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that);

    /** Process an instance of _SyntaxTransformationMatrixType. */
    public abstract void for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that);

    /** Process an instance of _SyntaxTransformationTaggedDimType. */
    public abstract void for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that);

    /** Process an instance of _SyntaxTransformationTaggedUnitType. */
    public abstract void for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that);

    /** Process an instance of _SyntaxTransformationTupleType. */
    public abstract void for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that);

    /** Process an instance of _SyntaxTransformationArrowType. */
    public abstract void for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that);

    /** Process an instance of _SyntaxTransformationBoundType. */
    public abstract void for_SyntaxTransformationBoundType(_SyntaxTransformationBoundType that);

    /** Process an instance of _SyntaxTransformationIntersectionType. */
    public abstract void for_SyntaxTransformationIntersectionType(_SyntaxTransformationIntersectionType that);

    /** Process an instance of _SyntaxTransformationUnionType. */
    public abstract void for_SyntaxTransformationUnionType(_SyntaxTransformationUnionType that);

    /** Process an instance of _SyntaxTransformationFixedPointType. */
    public abstract void for_SyntaxTransformationFixedPointType(_SyntaxTransformationFixedPointType that);

    /** Process an instance of _SyntaxTransformationLabelType. */
    public abstract void for_SyntaxTransformationLabelType(_SyntaxTransformationLabelType that);

    /** Process an instance of _SyntaxTransformationDimExpr. */
    public abstract void for_SyntaxTransformationDimExpr(_SyntaxTransformationDimExpr that);

    /** Process an instance of _SyntaxTransformationDimBase. */
    public abstract void for_SyntaxTransformationDimBase(_SyntaxTransformationDimBase that);

    /** Process an instance of _SyntaxTransformationDimRef. */
    public abstract void for_SyntaxTransformationDimRef(_SyntaxTransformationDimRef that);

    /** Process an instance of _SyntaxTransformationDimExponent. */
    public abstract void for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that);

    /** Process an instance of _SyntaxTransformationDimUnaryOp. */
    public abstract void for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that);

    /** Process an instance of _SyntaxTransformationDimBinaryOp. */
    public abstract void for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that);

    /** Process an instance of _SyntaxTransformationPattern. */
    public abstract void for_SyntaxTransformationPattern(_SyntaxTransformationPattern that);

    /** Process an instance of _SyntaxTransformationPatternArgs. */
    public abstract void for_SyntaxTransformationPatternArgs(_SyntaxTransformationPatternArgs that);

    /** Process an instance of _SyntaxTransformationPatternBinding. */
    public abstract void for_SyntaxTransformationPatternBinding(_SyntaxTransformationPatternBinding that);

    /** Process an instance of _SyntaxTransformationPlainPattern. */
    public abstract void for_SyntaxTransformationPlainPattern(_SyntaxTransformationPlainPattern that);

    /** Process an instance of _SyntaxTransformationTypePattern. */
    public abstract void for_SyntaxTransformationTypePattern(_SyntaxTransformationTypePattern that);

    /** Process an instance of _SyntaxTransformationNestedPattern. */
    public abstract void for_SyntaxTransformationNestedPattern(_SyntaxTransformationNestedPattern that);

    /** Process an instance of _SyntaxTransformationStaticArg. */
    public abstract void for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that);

    /** Process an instance of _SyntaxTransformationTypeArg. */
    public abstract void for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that);

    /** Process an instance of _SyntaxTransformationIntArg. */
    public abstract void for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that);

    /** Process an instance of _SyntaxTransformationBoolArg. */
    public abstract void for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that);

    /** Process an instance of _SyntaxTransformationOpArg. */
    public abstract void for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that);

    /** Process an instance of _SyntaxTransformationDimArg. */
    public abstract void for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that);

    /** Process an instance of _SyntaxTransformationUnitArg. */
    public abstract void for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that);

    /** Process an instance of _SyntaxTransformationStaticExpr. */
    public abstract void for_SyntaxTransformationStaticExpr(_SyntaxTransformationStaticExpr that);

    /** Process an instance of _SyntaxTransformationIntExpr. */
    public abstract void for_SyntaxTransformationIntExpr(_SyntaxTransformationIntExpr that);

    /** Process an instance of _SyntaxTransformationIntBase. */
    public abstract void for_SyntaxTransformationIntBase(_SyntaxTransformationIntBase that);

    /** Process an instance of _SyntaxTransformationIntRef. */
    public abstract void for_SyntaxTransformationIntRef(_SyntaxTransformationIntRef that);

    /** Process an instance of _SyntaxTransformationIntBinaryOp. */
    public abstract void for_SyntaxTransformationIntBinaryOp(_SyntaxTransformationIntBinaryOp that);

    /** Process an instance of _SyntaxTransformationBoolExpr. */
    public abstract void for_SyntaxTransformationBoolExpr(_SyntaxTransformationBoolExpr that);

    /** Process an instance of _SyntaxTransformationBoolBase. */
    public abstract void for_SyntaxTransformationBoolBase(_SyntaxTransformationBoolBase that);

    /** Process an instance of _SyntaxTransformationBoolRef. */
    public abstract void for_SyntaxTransformationBoolRef(_SyntaxTransformationBoolRef that);

    /** Process an instance of _SyntaxTransformationBoolConstraint. */
    public abstract void for_SyntaxTransformationBoolConstraint(_SyntaxTransformationBoolConstraint that);

    /** Process an instance of _SyntaxTransformationBoolUnaryOp. */
    public abstract void for_SyntaxTransformationBoolUnaryOp(_SyntaxTransformationBoolUnaryOp that);

    /** Process an instance of _SyntaxTransformationBoolBinaryOp. */
    public abstract void for_SyntaxTransformationBoolBinaryOp(_SyntaxTransformationBoolBinaryOp that);

    /** Process an instance of _SyntaxTransformationUnitExpr. */
    public abstract void for_SyntaxTransformationUnitExpr(_SyntaxTransformationUnitExpr that);

    /** Process an instance of _SyntaxTransformationUnitRef. */
    public abstract void for_SyntaxTransformationUnitRef(_SyntaxTransformationUnitRef that);

    /** Process an instance of _SyntaxTransformationUnitBinaryOp. */
    public abstract void for_SyntaxTransformationUnitBinaryOp(_SyntaxTransformationUnitBinaryOp that);

    /** Process an instance of _SyntaxTransformationEffect. */
    public abstract void for_SyntaxTransformationEffect(_SyntaxTransformationEffect that);

    /** Process an instance of _SyntaxTransformationWhereClause. */
    public abstract void for_SyntaxTransformationWhereClause(_SyntaxTransformationWhereClause that);

    /** Process an instance of _SyntaxTransformationWhereBinding. */
    public abstract void for_SyntaxTransformationWhereBinding(_SyntaxTransformationWhereBinding that);

    /** Process an instance of _SyntaxTransformationWhereConstraint. */
    public abstract void for_SyntaxTransformationWhereConstraint(_SyntaxTransformationWhereConstraint that);

    /** Process an instance of _SyntaxTransformationWhereExtends. */
    public abstract void for_SyntaxTransformationWhereExtends(_SyntaxTransformationWhereExtends that);

    /** Process an instance of _SyntaxTransformationWhereTypeAlias. */
    public abstract void for_SyntaxTransformationWhereTypeAlias(_SyntaxTransformationWhereTypeAlias that);

    /** Process an instance of _SyntaxTransformationWhereCoerces. */
    public abstract void for_SyntaxTransformationWhereCoerces(_SyntaxTransformationWhereCoerces that);

    /** Process an instance of _SyntaxTransformationWhereEquals. */
    public abstract void for_SyntaxTransformationWhereEquals(_SyntaxTransformationWhereEquals that);

    /** Process an instance of _SyntaxTransformationUnitConstraint. */
    public abstract void for_SyntaxTransformationUnitConstraint(_SyntaxTransformationUnitConstraint that);

    /** Process an instance of _SyntaxTransformationIntConstraint. */
    public abstract void for_SyntaxTransformationIntConstraint(_SyntaxTransformationIntConstraint that);

    /** Process an instance of _SyntaxTransformationBoolConstraintExpr. */
    public abstract void for_SyntaxTransformationBoolConstraintExpr(_SyntaxTransformationBoolConstraintExpr that);

    /** Process an instance of _SyntaxTransformationContract. */
    public abstract void for_SyntaxTransformationContract(_SyntaxTransformationContract that);

    /** Process an instance of _SyntaxTransformationEnsuresClause. */
    public abstract void for_SyntaxTransformationEnsuresClause(_SyntaxTransformationEnsuresClause that);

    /** Process an instance of _SyntaxTransformationStaticParam. */
    public abstract void for_SyntaxTransformationStaticParam(_SyntaxTransformationStaticParam that);

    /** Process an instance of _SyntaxTransformationName. */
    public abstract void for_SyntaxTransformationName(_SyntaxTransformationName that);

    /** Process an instance of _SyntaxTransformationAPIName. */
    public abstract void for_SyntaxTransformationAPIName(_SyntaxTransformationAPIName that);

    /** Process an instance of _SyntaxTransformationIdOrOpOrAnonymousName. */
    public abstract void for_SyntaxTransformationIdOrOpOrAnonymousName(_SyntaxTransformationIdOrOpOrAnonymousName that);

    /** Process an instance of _SyntaxTransformationIdOrOp. */
    public abstract void for_SyntaxTransformationIdOrOp(_SyntaxTransformationIdOrOp that);

    /** Process an instance of _SyntaxTransformationId. */
    public abstract void for_SyntaxTransformationId(_SyntaxTransformationId that);

    /** Process an instance of _SyntaxTransformationOp. */
    public abstract void for_SyntaxTransformationOp(_SyntaxTransformationOp that);

    /** Process an instance of _SyntaxTransformationNamedOp. */
    public abstract void for_SyntaxTransformationNamedOp(_SyntaxTransformationNamedOp that);

    /** Process an instance of _SyntaxTransformation_InferenceVarOp. */
    public abstract void for_SyntaxTransformation_InferenceVarOp(_SyntaxTransformation_InferenceVarOp that);

    /** Process an instance of _SyntaxTransformationAnonymousName. */
    public abstract void for_SyntaxTransformationAnonymousName(_SyntaxTransformationAnonymousName that);

    /** Process an instance of _SyntaxTransformationAnonymousFnName. */
    public abstract void for_SyntaxTransformationAnonymousFnName(_SyntaxTransformationAnonymousFnName that);

    /** Process an instance of _SyntaxTransformationConstructorFnName. */
    public abstract void for_SyntaxTransformationConstructorFnName(_SyntaxTransformationConstructorFnName that);

    /** Process an instance of _SyntaxTransformationArrayComprehensionClause. */
    public abstract void for_SyntaxTransformationArrayComprehensionClause(_SyntaxTransformationArrayComprehensionClause that);

    /** Process an instance of _SyntaxTransformationKeywordExpr. */
    public abstract void for_SyntaxTransformationKeywordExpr(_SyntaxTransformationKeywordExpr that);

    /** Process an instance of _SyntaxTransformationCaseClause. */
    public abstract void for_SyntaxTransformationCaseClause(_SyntaxTransformationCaseClause that);

    /** Process an instance of _SyntaxTransformationCatch. */
    public abstract void for_SyntaxTransformationCatch(_SyntaxTransformationCatch that);

    /** Process an instance of _SyntaxTransformationCatchClause. */
    public abstract void for_SyntaxTransformationCatchClause(_SyntaxTransformationCatchClause that);

    /** Process an instance of _SyntaxTransformationIfClause. */
    public abstract void for_SyntaxTransformationIfClause(_SyntaxTransformationIfClause that);

    /** Process an instance of _SyntaxTransformationTypecaseClause. */
    public abstract void for_SyntaxTransformationTypecaseClause(_SyntaxTransformationTypecaseClause that);

    /** Process an instance of _SyntaxTransformationExtentRange. */
    public abstract void for_SyntaxTransformationExtentRange(_SyntaxTransformationExtentRange that);

    /** Process an instance of _SyntaxTransformationGeneratorClause. */
    public abstract void for_SyntaxTransformationGeneratorClause(_SyntaxTransformationGeneratorClause that);

    /** Process an instance of _SyntaxTransformationKeywordType. */
    public abstract void for_SyntaxTransformationKeywordType(_SyntaxTransformationKeywordType that);

    /** Process an instance of _SyntaxTransformationTraitTypeWhere. */
    public abstract void for_SyntaxTransformationTraitTypeWhere(_SyntaxTransformationTraitTypeWhere that);

    /** Process an instance of _SyntaxTransformationIndices. */
    public abstract void for_SyntaxTransformationIndices(_SyntaxTransformationIndices that);

    /** Process an instance of _SyntaxTransformationMathItem. */
    public abstract void for_SyntaxTransformationMathItem(_SyntaxTransformationMathItem that);

    /** Process an instance of _SyntaxTransformationExprMI. */
    public abstract void for_SyntaxTransformationExprMI(_SyntaxTransformationExprMI that);

    /** Process an instance of _SyntaxTransformationParenthesisDelimitedMI. */
    public abstract void for_SyntaxTransformationParenthesisDelimitedMI(_SyntaxTransformationParenthesisDelimitedMI that);

    /** Process an instance of _SyntaxTransformationNonParenthesisDelimitedMI. */
    public abstract void for_SyntaxTransformationNonParenthesisDelimitedMI(_SyntaxTransformationNonParenthesisDelimitedMI that);

    /** Process an instance of _SyntaxTransformationNonExprMI. */
    public abstract void for_SyntaxTransformationNonExprMI(_SyntaxTransformationNonExprMI that);

    /** Process an instance of _SyntaxTransformationExponentiationMI. */
    public abstract void for_SyntaxTransformationExponentiationMI(_SyntaxTransformationExponentiationMI that);

    /** Process an instance of _SyntaxTransformationSubscriptingMI. */
    public abstract void for_SyntaxTransformationSubscriptingMI(_SyntaxTransformationSubscriptingMI that);

    /** Process an instance of _SyntaxTransformationOverloading. */
    public abstract void for_SyntaxTransformationOverloading(_SyntaxTransformationOverloading that);

    /** Process an instance of _SyntaxTransformationNonterminalHeader. */
    public abstract void for_SyntaxTransformationNonterminalHeader(_SyntaxTransformationNonterminalHeader that);

    /** Process an instance of _SyntaxTransformationNonterminalParameter. */
    public abstract void for_SyntaxTransformationNonterminalParameter(_SyntaxTransformationNonterminalParameter that);

    /** Process an instance of _SyntaxTransformationSyntaxDecl. */
    public abstract void for_SyntaxTransformationSyntaxDecl(_SyntaxTransformationSyntaxDecl that);

    /** Process an instance of _SyntaxTransformationSyntaxDef. */
    public abstract void for_SyntaxTransformationSyntaxDef(_SyntaxTransformationSyntaxDef that);

    /** Process an instance of _SyntaxTransformationSuperSyntaxDef. */
    public abstract void for_SyntaxTransformationSuperSyntaxDef(_SyntaxTransformationSuperSyntaxDef that);

    /** Process an instance of _SyntaxTransformationTransformerDecl. */
    public abstract void for_SyntaxTransformationTransformerDecl(_SyntaxTransformationTransformerDecl that);

    /** Process an instance of _SyntaxTransformationPreTransformerDef. */
    public abstract void for_SyntaxTransformationPreTransformerDef(_SyntaxTransformationPreTransformerDef that);

    /** Process an instance of _SyntaxTransformationNamedTransformerDef. */
    public abstract void for_SyntaxTransformationNamedTransformerDef(_SyntaxTransformationNamedTransformerDef that);

    /** Process an instance of _SyntaxTransformationTransformer. */
    public abstract void for_SyntaxTransformationTransformer(_SyntaxTransformationTransformer that);

    /** Process an instance of _SyntaxTransformationUnparsedTransformer. */
    public abstract void for_SyntaxTransformationUnparsedTransformer(_SyntaxTransformationUnparsedTransformer that);

    /** Process an instance of _SyntaxTransformationNodeTransformer. */
    public abstract void for_SyntaxTransformationNodeTransformer(_SyntaxTransformationNodeTransformer that);

    /** Process an instance of _SyntaxTransformationCaseTransformer. */
    public abstract void for_SyntaxTransformationCaseTransformer(_SyntaxTransformationCaseTransformer that);

    /** Process an instance of _SyntaxTransformationCaseTransformerClause. */
    public abstract void for_SyntaxTransformationCaseTransformerClause(_SyntaxTransformationCaseTransformerClause that);

    /** Process an instance of _SyntaxTransformationSyntaxSymbol. */
    public abstract void for_SyntaxTransformationSyntaxSymbol(_SyntaxTransformationSyntaxSymbol that);

    /** Process an instance of _SyntaxTransformationPrefixedSymbol. */
    public abstract void for_SyntaxTransformationPrefixedSymbol(_SyntaxTransformationPrefixedSymbol that);

    /** Process an instance of _SyntaxTransformationOptionalSymbol. */
    public abstract void for_SyntaxTransformationOptionalSymbol(_SyntaxTransformationOptionalSymbol that);

    /** Process an instance of _SyntaxTransformationRepeatSymbol. */
    public abstract void for_SyntaxTransformationRepeatSymbol(_SyntaxTransformationRepeatSymbol that);

    /** Process an instance of _SyntaxTransformationRepeatOneOrMoreSymbol. */
    public abstract void for_SyntaxTransformationRepeatOneOrMoreSymbol(_SyntaxTransformationRepeatOneOrMoreSymbol that);

    /** Process an instance of _SyntaxTransformationNoWhitespaceSymbol. */
    public abstract void for_SyntaxTransformationNoWhitespaceSymbol(_SyntaxTransformationNoWhitespaceSymbol that);

    /** Process an instance of _SyntaxTransformationGroupSymbol. */
    public abstract void for_SyntaxTransformationGroupSymbol(_SyntaxTransformationGroupSymbol that);

    /** Process an instance of _SyntaxTransformationSpecialSymbol. */
    public abstract void for_SyntaxTransformationSpecialSymbol(_SyntaxTransformationSpecialSymbol that);

    /** Process an instance of _SyntaxTransformationAnyCharacterSymbol. */
    public abstract void for_SyntaxTransformationAnyCharacterSymbol(_SyntaxTransformationAnyCharacterSymbol that);

    /** Process an instance of _SyntaxTransformationWhitespaceSymbol. */
    public abstract void for_SyntaxTransformationWhitespaceSymbol(_SyntaxTransformationWhitespaceSymbol that);

    /** Process an instance of _SyntaxTransformationTabSymbol. */
    public abstract void for_SyntaxTransformationTabSymbol(_SyntaxTransformationTabSymbol that);

    /** Process an instance of _SyntaxTransformationFormfeedSymbol. */
    public abstract void for_SyntaxTransformationFormfeedSymbol(_SyntaxTransformationFormfeedSymbol that);

    /** Process an instance of _SyntaxTransformationCarriageReturnSymbol. */
    public abstract void for_SyntaxTransformationCarriageReturnSymbol(_SyntaxTransformationCarriageReturnSymbol that);

    /** Process an instance of _SyntaxTransformationBackspaceSymbol. */
    public abstract void for_SyntaxTransformationBackspaceSymbol(_SyntaxTransformationBackspaceSymbol that);

    /** Process an instance of _SyntaxTransformationNewlineSymbol. */
    public abstract void for_SyntaxTransformationNewlineSymbol(_SyntaxTransformationNewlineSymbol that);

    /** Process an instance of _SyntaxTransformationBreaklineSymbol. */
    public abstract void for_SyntaxTransformationBreaklineSymbol(_SyntaxTransformationBreaklineSymbol that);

    /** Process an instance of _SyntaxTransformationItemSymbol. */
    public abstract void for_SyntaxTransformationItemSymbol(_SyntaxTransformationItemSymbol that);

    /** Process an instance of _SyntaxTransformationNonterminalSymbol. */
    public abstract void for_SyntaxTransformationNonterminalSymbol(_SyntaxTransformationNonterminalSymbol that);

    /** Process an instance of _SyntaxTransformationKeywordSymbol. */
    public abstract void for_SyntaxTransformationKeywordSymbol(_SyntaxTransformationKeywordSymbol that);

    /** Process an instance of _SyntaxTransformationTokenSymbol. */
    public abstract void for_SyntaxTransformationTokenSymbol(_SyntaxTransformationTokenSymbol that);

    /** Process an instance of _SyntaxTransformationNotPredicateSymbol. */
    public abstract void for_SyntaxTransformationNotPredicateSymbol(_SyntaxTransformationNotPredicateSymbol that);

    /** Process an instance of _SyntaxTransformationAndPredicateSymbol. */
    public abstract void for_SyntaxTransformationAndPredicateSymbol(_SyntaxTransformationAndPredicateSymbol that);

    /** Process an instance of _SyntaxTransformationCharacterClassSymbol. */
    public abstract void for_SyntaxTransformationCharacterClassSymbol(_SyntaxTransformationCharacterClassSymbol that);

    /** Process an instance of _SyntaxTransformationCharacterSymbol. */
    public abstract void for_SyntaxTransformationCharacterSymbol(_SyntaxTransformationCharacterSymbol that);

    /** Process an instance of _SyntaxTransformationCharSymbol. */
    public abstract void for_SyntaxTransformationCharSymbol(_SyntaxTransformationCharSymbol that);

    /** Process an instance of _SyntaxTransformationCharacterInterval. */
    public abstract void for_SyntaxTransformationCharacterInterval(_SyntaxTransformationCharacterInterval that);

    /** Process an instance of _SyntaxTransformationLink. */
    public abstract void for_SyntaxTransformationLink(_SyntaxTransformationLink that);

    /** Process an instance of _EllipsesAbstractNode. */
    public abstract void for_EllipsesAbstractNode(_EllipsesAbstractNode that);

    /** Process an instance of _EllipsesCompilationUnit. */
    public abstract void for_EllipsesCompilationUnit(_EllipsesCompilationUnit that);

    /** Process an instance of _EllipsesComponent. */
    public abstract void for_EllipsesComponent(_EllipsesComponent that);

    /** Process an instance of _EllipsesApi. */
    public abstract void for_EllipsesApi(_EllipsesApi that);

    /** Process an instance of _EllipsesImport. */
    public abstract void for_EllipsesImport(_EllipsesImport that);

    /** Process an instance of _EllipsesImportedNames. */
    public abstract void for_EllipsesImportedNames(_EllipsesImportedNames that);

    /** Process an instance of _EllipsesImportStar. */
    public abstract void for_EllipsesImportStar(_EllipsesImportStar that);

    /** Process an instance of _EllipsesImportNames. */
    public abstract void for_EllipsesImportNames(_EllipsesImportNames that);

    /** Process an instance of _EllipsesImportApi. */
    public abstract void for_EllipsesImportApi(_EllipsesImportApi that);

    /** Process an instance of _EllipsesAliasedSimpleName. */
    public abstract void for_EllipsesAliasedSimpleName(_EllipsesAliasedSimpleName that);

    /** Process an instance of _EllipsesAliasedAPIName. */
    public abstract void for_EllipsesAliasedAPIName(_EllipsesAliasedAPIName that);

    /** Process an instance of _EllipsesDecl. */
    public abstract void for_EllipsesDecl(_EllipsesDecl that);

    /** Process an instance of _EllipsesTraitObjectDecl. */
    public abstract void for_EllipsesTraitObjectDecl(_EllipsesTraitObjectDecl that);

    /** Process an instance of _EllipsesTraitDecl. */
    public abstract void for_EllipsesTraitDecl(_EllipsesTraitDecl that);

    /** Process an instance of _EllipsesObjectDecl. */
    public abstract void for_EllipsesObjectDecl(_EllipsesObjectDecl that);

    /** Process an instance of _EllipsesVarDecl. */
    public abstract void for_EllipsesVarDecl(_EllipsesVarDecl that);

    /** Process an instance of _EllipsesFnDecl. */
    public abstract void for_EllipsesFnDecl(_EllipsesFnDecl that);

    /** Process an instance of _Ellipses_RewriteFnOverloadDecl. */
    public abstract void for_Ellipses_RewriteFnOverloadDecl(_Ellipses_RewriteFnOverloadDecl that);

    /** Process an instance of _Ellipses_RewriteObjectExprDecl. */
    public abstract void for_Ellipses_RewriteObjectExprDecl(_Ellipses_RewriteObjectExprDecl that);

    /** Process an instance of _Ellipses_RewriteFunctionalMethodDecl. */
    public abstract void for_Ellipses_RewriteFunctionalMethodDecl(_Ellipses_RewriteFunctionalMethodDecl that);

    /** Process an instance of _EllipsesDimUnitDecl. */
    public abstract void for_EllipsesDimUnitDecl(_EllipsesDimUnitDecl that);

    /** Process an instance of _EllipsesDimDecl. */
    public abstract void for_EllipsesDimDecl(_EllipsesDimDecl that);

    /** Process an instance of _EllipsesUnitDecl. */
    public abstract void for_EllipsesUnitDecl(_EllipsesUnitDecl that);

    /** Process an instance of _EllipsesTestDecl. */
    public abstract void for_EllipsesTestDecl(_EllipsesTestDecl that);

    /** Process an instance of _EllipsesPropertyDecl. */
    public abstract void for_EllipsesPropertyDecl(_EllipsesPropertyDecl that);

    /** Process an instance of _EllipsesTypeAlias. */
    public abstract void for_EllipsesTypeAlias(_EllipsesTypeAlias that);

    /** Process an instance of _EllipsesGrammarDecl. */
    public abstract void for_EllipsesGrammarDecl(_EllipsesGrammarDecl that);

    /** Process an instance of _EllipsesGrammarMemberDecl. */
    public abstract void for_EllipsesGrammarMemberDecl(_EllipsesGrammarMemberDecl that);

    /** Process an instance of _EllipsesNonterminalDecl. */
    public abstract void for_EllipsesNonterminalDecl(_EllipsesNonterminalDecl that);

    /** Process an instance of _EllipsesNonterminalDef. */
    public abstract void for_EllipsesNonterminalDef(_EllipsesNonterminalDef that);

    /** Process an instance of _EllipsesNonterminalExtensionDef. */
    public abstract void for_EllipsesNonterminalExtensionDef(_EllipsesNonterminalExtensionDef that);

    /** Process an instance of _EllipsesBinding. */
    public abstract void for_EllipsesBinding(_EllipsesBinding that);

    /** Process an instance of _EllipsesLValue. */
    public abstract void for_EllipsesLValue(_EllipsesLValue that);

    /** Process an instance of _EllipsesParam. */
    public abstract void for_EllipsesParam(_EllipsesParam that);

    /** Process an instance of _EllipsesExpr. */
    public abstract void for_EllipsesExpr(_EllipsesExpr that);

    /** Process an instance of _EllipsesDummyExpr. */
    public abstract void for_EllipsesDummyExpr(_EllipsesDummyExpr that);

    /** Process an instance of _EllipsesTypeAnnotatedExpr. */
    public abstract void for_EllipsesTypeAnnotatedExpr(_EllipsesTypeAnnotatedExpr that);

    /** Process an instance of _EllipsesAsExpr. */
    public abstract void for_EllipsesAsExpr(_EllipsesAsExpr that);

    /** Process an instance of _EllipsesAsIfExpr. */
    public abstract void for_EllipsesAsIfExpr(_EllipsesAsIfExpr that);

    /** Process an instance of _EllipsesAssignment. */
    public abstract void for_EllipsesAssignment(_EllipsesAssignment that);

    /** Process an instance of _EllipsesBlock. */
    public abstract void for_EllipsesBlock(_EllipsesBlock that);

    /** Process an instance of _EllipsesDo. */
    public abstract void for_EllipsesDo(_EllipsesDo that);

    /** Process an instance of _EllipsesCaseExpr. */
    public abstract void for_EllipsesCaseExpr(_EllipsesCaseExpr that);

    /** Process an instance of _EllipsesIf. */
    public abstract void for_EllipsesIf(_EllipsesIf that);

    /** Process an instance of _EllipsesLabel. */
    public abstract void for_EllipsesLabel(_EllipsesLabel that);

    /** Process an instance of _EllipsesAbstractObjectExpr. */
    public abstract void for_EllipsesAbstractObjectExpr(_EllipsesAbstractObjectExpr that);

    /** Process an instance of _EllipsesObjectExpr. */
    public abstract void for_EllipsesObjectExpr(_EllipsesObjectExpr that);

    /** Process an instance of _Ellipses_RewriteObjectExpr. */
    public abstract void for_Ellipses_RewriteObjectExpr(_Ellipses_RewriteObjectExpr that);

    /** Process an instance of _EllipsesTry. */
    public abstract void for_EllipsesTry(_EllipsesTry that);

    /** Process an instance of _EllipsesTupleExpr. */
    public abstract void for_EllipsesTupleExpr(_EllipsesTupleExpr that);

    /** Process an instance of _EllipsesTypecase. */
    public abstract void for_EllipsesTypecase(_EllipsesTypecase that);

    /** Process an instance of _EllipsesWhile. */
    public abstract void for_EllipsesWhile(_EllipsesWhile that);

    /** Process an instance of _EllipsesFor. */
    public abstract void for_EllipsesFor(_EllipsesFor that);

    /** Process an instance of _EllipsesBigOpApp. */
    public abstract void for_EllipsesBigOpApp(_EllipsesBigOpApp that);

    /** Process an instance of _EllipsesAccumulator. */
    public abstract void for_EllipsesAccumulator(_EllipsesAccumulator that);

    /** Process an instance of _EllipsesArrayComprehension. */
    public abstract void for_EllipsesArrayComprehension(_EllipsesArrayComprehension that);

    /** Process an instance of _EllipsesAtomicExpr. */
    public abstract void for_EllipsesAtomicExpr(_EllipsesAtomicExpr that);

    /** Process an instance of _EllipsesExit. */
    public abstract void for_EllipsesExit(_EllipsesExit that);

    /** Process an instance of _EllipsesSpawn. */
    public abstract void for_EllipsesSpawn(_EllipsesSpawn that);

    /** Process an instance of _EllipsesThrow. */
    public abstract void for_EllipsesThrow(_EllipsesThrow that);

    /** Process an instance of _EllipsesTryAtomicExpr. */
    public abstract void for_EllipsesTryAtomicExpr(_EllipsesTryAtomicExpr that);

    /** Process an instance of _EllipsesFnExpr. */
    public abstract void for_EllipsesFnExpr(_EllipsesFnExpr that);

    /** Process an instance of _EllipsesLetExpr. */
    public abstract void for_EllipsesLetExpr(_EllipsesLetExpr that);

    /** Process an instance of _EllipsesLetFn. */
    public abstract void for_EllipsesLetFn(_EllipsesLetFn that);

    /** Process an instance of _EllipsesLocalVarDecl. */
    public abstract void for_EllipsesLocalVarDecl(_EllipsesLocalVarDecl that);

    /** Process an instance of _EllipsesSimpleExpr. */
    public abstract void for_EllipsesSimpleExpr(_EllipsesSimpleExpr that);

    /** Process an instance of _EllipsesSubscriptExpr. */
    public abstract void for_EllipsesSubscriptExpr(_EllipsesSubscriptExpr that);

    /** Process an instance of _EllipsesPrimary. */
    public abstract void for_EllipsesPrimary(_EllipsesPrimary that);

    /** Process an instance of _EllipsesLiteralExpr. */
    public abstract void for_EllipsesLiteralExpr(_EllipsesLiteralExpr that);

    /** Process an instance of _EllipsesNumberLiteralExpr. */
    public abstract void for_EllipsesNumberLiteralExpr(_EllipsesNumberLiteralExpr that);

    /** Process an instance of _EllipsesFloatLiteralExpr. */
    public abstract void for_EllipsesFloatLiteralExpr(_EllipsesFloatLiteralExpr that);

    /** Process an instance of _EllipsesIntLiteralExpr. */
    public abstract void for_EllipsesIntLiteralExpr(_EllipsesIntLiteralExpr that);

    /** Process an instance of _EllipsesCharLiteralExpr. */
    public abstract void for_EllipsesCharLiteralExpr(_EllipsesCharLiteralExpr that);

    /** Process an instance of _EllipsesStringLiteralExpr. */
    public abstract void for_EllipsesStringLiteralExpr(_EllipsesStringLiteralExpr that);

    /** Process an instance of _EllipsesVoidLiteralExpr. */
    public abstract void for_EllipsesVoidLiteralExpr(_EllipsesVoidLiteralExpr that);

    /** Process an instance of _EllipsesBooleanLiteralExpr. */
    public abstract void for_EllipsesBooleanLiteralExpr(_EllipsesBooleanLiteralExpr that);

    /** Process an instance of _EllipsesVarRef. */
    public abstract void for_EllipsesVarRef(_EllipsesVarRef that);

    /** Process an instance of _EllipsesFieldRef. */
    public abstract void for_EllipsesFieldRef(_EllipsesFieldRef that);

    /** Process an instance of _EllipsesFunctionalRef. */
    public abstract void for_EllipsesFunctionalRef(_EllipsesFunctionalRef that);

    /** Process an instance of _EllipsesFnRef. */
    public abstract void for_EllipsesFnRef(_EllipsesFnRef that);

    /** Process an instance of _EllipsesOpRef. */
    public abstract void for_EllipsesOpRef(_EllipsesOpRef that);

    /** Process an instance of _Ellipses_RewriteFnRef. */
    public abstract void for_Ellipses_RewriteFnRef(_Ellipses_RewriteFnRef that);

    /** Process an instance of _Ellipses_RewriteObjectExprRef. */
    public abstract void for_Ellipses_RewriteObjectExprRef(_Ellipses_RewriteObjectExprRef that);

    /** Process an instance of _EllipsesJuxt. */
    public abstract void for_EllipsesJuxt(_EllipsesJuxt that);

    /** Process an instance of _Ellipses_RewriteFnApp. */
    public abstract void for_Ellipses_RewriteFnApp(_Ellipses_RewriteFnApp that);

    /** Process an instance of _EllipsesOpExpr. */
    public abstract void for_EllipsesOpExpr(_EllipsesOpExpr that);

    /** Process an instance of _EllipsesAmbiguousMultifixOpExpr. */
    public abstract void for_EllipsesAmbiguousMultifixOpExpr(_EllipsesAmbiguousMultifixOpExpr that);

    /** Process an instance of _EllipsesChainExpr. */
    public abstract void for_EllipsesChainExpr(_EllipsesChainExpr that);

    /** Process an instance of _EllipsesCoercionInvocation. */
    public abstract void for_EllipsesCoercionInvocation(_EllipsesCoercionInvocation that);

    /** Process an instance of _EllipsesTraitCoercionInvocation. */
    public abstract void for_EllipsesTraitCoercionInvocation(_EllipsesTraitCoercionInvocation that);

    /** Process an instance of _EllipsesTupleCoercionInvocation. */
    public abstract void for_EllipsesTupleCoercionInvocation(_EllipsesTupleCoercionInvocation that);

    /** Process an instance of _EllipsesArrowCoercionInvocation. */
    public abstract void for_EllipsesArrowCoercionInvocation(_EllipsesArrowCoercionInvocation that);

    /** Process an instance of _EllipsesUnionCoercionInvocation. */
    public abstract void for_EllipsesUnionCoercionInvocation(_EllipsesUnionCoercionInvocation that);

    /** Process an instance of _EllipsesMethodInvocation. */
    public abstract void for_EllipsesMethodInvocation(_EllipsesMethodInvocation that);

    /** Process an instance of _EllipsesMathPrimary. */
    public abstract void for_EllipsesMathPrimary(_EllipsesMathPrimary that);

    /** Process an instance of _EllipsesArrayExpr. */
    public abstract void for_EllipsesArrayExpr(_EllipsesArrayExpr that);

    /** Process an instance of _EllipsesArrayElement. */
    public abstract void for_EllipsesArrayElement(_EllipsesArrayElement that);

    /** Process an instance of _EllipsesArrayElements. */
    public abstract void for_EllipsesArrayElements(_EllipsesArrayElements that);

    /** Process an instance of _EllipsesType. */
    public abstract void for_EllipsesType(_EllipsesType that);

    /** Process an instance of _EllipsesBaseType. */
    public abstract void for_EllipsesBaseType(_EllipsesBaseType that);

    /** Process an instance of _EllipsesAnyType. */
    public abstract void for_EllipsesAnyType(_EllipsesAnyType that);

    /** Process an instance of _EllipsesBottomType. */
    public abstract void for_EllipsesBottomType(_EllipsesBottomType that);

    /** Process an instance of _EllipsesUnknownType. */
    public abstract void for_EllipsesUnknownType(_EllipsesUnknownType that);

    /** Process an instance of _EllipsesSelfType. */
    public abstract void for_EllipsesSelfType(_EllipsesSelfType that);

    /** Process an instance of _EllipsesTraitSelfType. */
    public abstract void for_EllipsesTraitSelfType(_EllipsesTraitSelfType that);

    /** Process an instance of _EllipsesObjectExprType. */
    public abstract void for_EllipsesObjectExprType(_EllipsesObjectExprType that);

    /** Process an instance of _EllipsesNamedType. */
    public abstract void for_EllipsesNamedType(_EllipsesNamedType that);

    /** Process an instance of _Ellipses_InferenceVarType. */
    public abstract void for_Ellipses_InferenceVarType(_Ellipses_InferenceVarType that);

    /** Process an instance of _EllipsesVarType. */
    public abstract void for_EllipsesVarType(_EllipsesVarType that);

    /** Process an instance of _EllipsesTraitType. */
    public abstract void for_EllipsesTraitType(_EllipsesTraitType that);

    /** Process an instance of _EllipsesAbbreviatedType. */
    public abstract void for_EllipsesAbbreviatedType(_EllipsesAbbreviatedType that);

    /** Process an instance of _EllipsesArrayType. */
    public abstract void for_EllipsesArrayType(_EllipsesArrayType that);

    /** Process an instance of _EllipsesMatrixType. */
    public abstract void for_EllipsesMatrixType(_EllipsesMatrixType that);

    /** Process an instance of _EllipsesTaggedDimType. */
    public abstract void for_EllipsesTaggedDimType(_EllipsesTaggedDimType that);

    /** Process an instance of _EllipsesTaggedUnitType. */
    public abstract void for_EllipsesTaggedUnitType(_EllipsesTaggedUnitType that);

    /** Process an instance of _EllipsesTupleType. */
    public abstract void for_EllipsesTupleType(_EllipsesTupleType that);

    /** Process an instance of _EllipsesArrowType. */
    public abstract void for_EllipsesArrowType(_EllipsesArrowType that);

    /** Process an instance of _EllipsesBoundType. */
    public abstract void for_EllipsesBoundType(_EllipsesBoundType that);

    /** Process an instance of _EllipsesIntersectionType. */
    public abstract void for_EllipsesIntersectionType(_EllipsesIntersectionType that);

    /** Process an instance of _EllipsesUnionType. */
    public abstract void for_EllipsesUnionType(_EllipsesUnionType that);

    /** Process an instance of _EllipsesFixedPointType. */
    public abstract void for_EllipsesFixedPointType(_EllipsesFixedPointType that);

    /** Process an instance of _EllipsesLabelType. */
    public abstract void for_EllipsesLabelType(_EllipsesLabelType that);

    /** Process an instance of _EllipsesDimExpr. */
    public abstract void for_EllipsesDimExpr(_EllipsesDimExpr that);

    /** Process an instance of _EllipsesDimBase. */
    public abstract void for_EllipsesDimBase(_EllipsesDimBase that);

    /** Process an instance of _EllipsesDimRef. */
    public abstract void for_EllipsesDimRef(_EllipsesDimRef that);

    /** Process an instance of _EllipsesDimExponent. */
    public abstract void for_EllipsesDimExponent(_EllipsesDimExponent that);

    /** Process an instance of _EllipsesDimUnaryOp. */
    public abstract void for_EllipsesDimUnaryOp(_EllipsesDimUnaryOp that);

    /** Process an instance of _EllipsesDimBinaryOp. */
    public abstract void for_EllipsesDimBinaryOp(_EllipsesDimBinaryOp that);

    /** Process an instance of _EllipsesPattern. */
    public abstract void for_EllipsesPattern(_EllipsesPattern that);

    /** Process an instance of _EllipsesPatternArgs. */
    public abstract void for_EllipsesPatternArgs(_EllipsesPatternArgs that);

    /** Process an instance of _EllipsesPatternBinding. */
    public abstract void for_EllipsesPatternBinding(_EllipsesPatternBinding that);

    /** Process an instance of _EllipsesPlainPattern. */
    public abstract void for_EllipsesPlainPattern(_EllipsesPlainPattern that);

    /** Process an instance of _EllipsesTypePattern. */
    public abstract void for_EllipsesTypePattern(_EllipsesTypePattern that);

    /** Process an instance of _EllipsesNestedPattern. */
    public abstract void for_EllipsesNestedPattern(_EllipsesNestedPattern that);

    /** Process an instance of _EllipsesStaticArg. */
    public abstract void for_EllipsesStaticArg(_EllipsesStaticArg that);

    /** Process an instance of _EllipsesTypeArg. */
    public abstract void for_EllipsesTypeArg(_EllipsesTypeArg that);

    /** Process an instance of _EllipsesIntArg. */
    public abstract void for_EllipsesIntArg(_EllipsesIntArg that);

    /** Process an instance of _EllipsesBoolArg. */
    public abstract void for_EllipsesBoolArg(_EllipsesBoolArg that);

    /** Process an instance of _EllipsesOpArg. */
    public abstract void for_EllipsesOpArg(_EllipsesOpArg that);

    /** Process an instance of _EllipsesDimArg. */
    public abstract void for_EllipsesDimArg(_EllipsesDimArg that);

    /** Process an instance of _EllipsesUnitArg. */
    public abstract void for_EllipsesUnitArg(_EllipsesUnitArg that);

    /** Process an instance of _EllipsesStaticExpr. */
    public abstract void for_EllipsesStaticExpr(_EllipsesStaticExpr that);

    /** Process an instance of _EllipsesIntExpr. */
    public abstract void for_EllipsesIntExpr(_EllipsesIntExpr that);

    /** Process an instance of _EllipsesIntBase. */
    public abstract void for_EllipsesIntBase(_EllipsesIntBase that);

    /** Process an instance of _EllipsesIntRef. */
    public abstract void for_EllipsesIntRef(_EllipsesIntRef that);

    /** Process an instance of _EllipsesIntBinaryOp. */
    public abstract void for_EllipsesIntBinaryOp(_EllipsesIntBinaryOp that);

    /** Process an instance of _EllipsesBoolExpr. */
    public abstract void for_EllipsesBoolExpr(_EllipsesBoolExpr that);

    /** Process an instance of _EllipsesBoolBase. */
    public abstract void for_EllipsesBoolBase(_EllipsesBoolBase that);

    /** Process an instance of _EllipsesBoolRef. */
    public abstract void for_EllipsesBoolRef(_EllipsesBoolRef that);

    /** Process an instance of _EllipsesBoolConstraint. */
    public abstract void for_EllipsesBoolConstraint(_EllipsesBoolConstraint that);

    /** Process an instance of _EllipsesBoolUnaryOp. */
    public abstract void for_EllipsesBoolUnaryOp(_EllipsesBoolUnaryOp that);

    /** Process an instance of _EllipsesBoolBinaryOp. */
    public abstract void for_EllipsesBoolBinaryOp(_EllipsesBoolBinaryOp that);

    /** Process an instance of _EllipsesUnitExpr. */
    public abstract void for_EllipsesUnitExpr(_EllipsesUnitExpr that);

    /** Process an instance of _EllipsesUnitRef. */
    public abstract void for_EllipsesUnitRef(_EllipsesUnitRef that);

    /** Process an instance of _EllipsesUnitBinaryOp. */
    public abstract void for_EllipsesUnitBinaryOp(_EllipsesUnitBinaryOp that);

    /** Process an instance of _EllipsesEffect. */
    public abstract void for_EllipsesEffect(_EllipsesEffect that);

    /** Process an instance of _EllipsesWhereClause. */
    public abstract void for_EllipsesWhereClause(_EllipsesWhereClause that);

    /** Process an instance of _EllipsesWhereBinding. */
    public abstract void for_EllipsesWhereBinding(_EllipsesWhereBinding that);

    /** Process an instance of _EllipsesWhereConstraint. */
    public abstract void for_EllipsesWhereConstraint(_EllipsesWhereConstraint that);

    /** Process an instance of _EllipsesWhereExtends. */
    public abstract void for_EllipsesWhereExtends(_EllipsesWhereExtends that);

    /** Process an instance of _EllipsesWhereTypeAlias. */
    public abstract void for_EllipsesWhereTypeAlias(_EllipsesWhereTypeAlias that);

    /** Process an instance of _EllipsesWhereCoerces. */
    public abstract void for_EllipsesWhereCoerces(_EllipsesWhereCoerces that);

    /** Process an instance of _EllipsesWhereEquals. */
    public abstract void for_EllipsesWhereEquals(_EllipsesWhereEquals that);

    /** Process an instance of _EllipsesUnitConstraint. */
    public abstract void for_EllipsesUnitConstraint(_EllipsesUnitConstraint that);

    /** Process an instance of _EllipsesIntConstraint. */
    public abstract void for_EllipsesIntConstraint(_EllipsesIntConstraint that);

    /** Process an instance of _EllipsesBoolConstraintExpr. */
    public abstract void for_EllipsesBoolConstraintExpr(_EllipsesBoolConstraintExpr that);

    /** Process an instance of _EllipsesContract. */
    public abstract void for_EllipsesContract(_EllipsesContract that);

    /** Process an instance of _EllipsesEnsuresClause. */
    public abstract void for_EllipsesEnsuresClause(_EllipsesEnsuresClause that);

    /** Process an instance of _EllipsesStaticParam. */
    public abstract void for_EllipsesStaticParam(_EllipsesStaticParam that);

    /** Process an instance of _EllipsesName. */
    public abstract void for_EllipsesName(_EllipsesName that);

    /** Process an instance of _EllipsesAPIName. */
    public abstract void for_EllipsesAPIName(_EllipsesAPIName that);

    /** Process an instance of _EllipsesIdOrOpOrAnonymousName. */
    public abstract void for_EllipsesIdOrOpOrAnonymousName(_EllipsesIdOrOpOrAnonymousName that);

    /** Process an instance of _EllipsesIdOrOp. */
    public abstract void for_EllipsesIdOrOp(_EllipsesIdOrOp that);

    /** Process an instance of _EllipsesId. */
    public abstract void for_EllipsesId(_EllipsesId that);

    /** Process an instance of _EllipsesOp. */
    public abstract void for_EllipsesOp(_EllipsesOp that);

    /** Process an instance of _EllipsesNamedOp. */
    public abstract void for_EllipsesNamedOp(_EllipsesNamedOp that);

    /** Process an instance of _Ellipses_InferenceVarOp. */
    public abstract void for_Ellipses_InferenceVarOp(_Ellipses_InferenceVarOp that);

    /** Process an instance of _EllipsesAnonymousName. */
    public abstract void for_EllipsesAnonymousName(_EllipsesAnonymousName that);

    /** Process an instance of _EllipsesAnonymousFnName. */
    public abstract void for_EllipsesAnonymousFnName(_EllipsesAnonymousFnName that);

    /** Process an instance of _EllipsesConstructorFnName. */
    public abstract void for_EllipsesConstructorFnName(_EllipsesConstructorFnName that);

    /** Process an instance of _EllipsesArrayComprehensionClause. */
    public abstract void for_EllipsesArrayComprehensionClause(_EllipsesArrayComprehensionClause that);

    /** Process an instance of _EllipsesKeywordExpr. */
    public abstract void for_EllipsesKeywordExpr(_EllipsesKeywordExpr that);

    /** Process an instance of _EllipsesCaseClause. */
    public abstract void for_EllipsesCaseClause(_EllipsesCaseClause that);

    /** Process an instance of _EllipsesCatch. */
    public abstract void for_EllipsesCatch(_EllipsesCatch that);

    /** Process an instance of _EllipsesCatchClause. */
    public abstract void for_EllipsesCatchClause(_EllipsesCatchClause that);

    /** Process an instance of _EllipsesIfClause. */
    public abstract void for_EllipsesIfClause(_EllipsesIfClause that);

    /** Process an instance of _EllipsesTypecaseClause. */
    public abstract void for_EllipsesTypecaseClause(_EllipsesTypecaseClause that);

    /** Process an instance of _EllipsesExtentRange. */
    public abstract void for_EllipsesExtentRange(_EllipsesExtentRange that);

    /** Process an instance of _EllipsesGeneratorClause. */
    public abstract void for_EllipsesGeneratorClause(_EllipsesGeneratorClause that);

    /** Process an instance of _EllipsesKeywordType. */
    public abstract void for_EllipsesKeywordType(_EllipsesKeywordType that);

    /** Process an instance of _EllipsesTraitTypeWhere. */
    public abstract void for_EllipsesTraitTypeWhere(_EllipsesTraitTypeWhere that);

    /** Process an instance of _EllipsesIndices. */
    public abstract void for_EllipsesIndices(_EllipsesIndices that);

    /** Process an instance of _EllipsesMathItem. */
    public abstract void for_EllipsesMathItem(_EllipsesMathItem that);

    /** Process an instance of _EllipsesExprMI. */
    public abstract void for_EllipsesExprMI(_EllipsesExprMI that);

    /** Process an instance of _EllipsesParenthesisDelimitedMI. */
    public abstract void for_EllipsesParenthesisDelimitedMI(_EllipsesParenthesisDelimitedMI that);

    /** Process an instance of _EllipsesNonParenthesisDelimitedMI. */
    public abstract void for_EllipsesNonParenthesisDelimitedMI(_EllipsesNonParenthesisDelimitedMI that);

    /** Process an instance of _EllipsesNonExprMI. */
    public abstract void for_EllipsesNonExprMI(_EllipsesNonExprMI that);

    /** Process an instance of _EllipsesExponentiationMI. */
    public abstract void for_EllipsesExponentiationMI(_EllipsesExponentiationMI that);

    /** Process an instance of _EllipsesSubscriptingMI. */
    public abstract void for_EllipsesSubscriptingMI(_EllipsesSubscriptingMI that);

    /** Process an instance of _EllipsesOverloading. */
    public abstract void for_EllipsesOverloading(_EllipsesOverloading that);

    /** Process an instance of _EllipsesNonterminalHeader. */
    public abstract void for_EllipsesNonterminalHeader(_EllipsesNonterminalHeader that);

    /** Process an instance of _EllipsesNonterminalParameter. */
    public abstract void for_EllipsesNonterminalParameter(_EllipsesNonterminalParameter that);

    /** Process an instance of _EllipsesSyntaxDecl. */
    public abstract void for_EllipsesSyntaxDecl(_EllipsesSyntaxDecl that);

    /** Process an instance of _EllipsesSyntaxDef. */
    public abstract void for_EllipsesSyntaxDef(_EllipsesSyntaxDef that);

    /** Process an instance of _EllipsesSuperSyntaxDef. */
    public abstract void for_EllipsesSuperSyntaxDef(_EllipsesSuperSyntaxDef that);

    /** Process an instance of _EllipsesTransformerDecl. */
    public abstract void for_EllipsesTransformerDecl(_EllipsesTransformerDecl that);

    /** Process an instance of _EllipsesPreTransformerDef. */
    public abstract void for_EllipsesPreTransformerDef(_EllipsesPreTransformerDef that);

    /** Process an instance of _EllipsesNamedTransformerDef. */
    public abstract void for_EllipsesNamedTransformerDef(_EllipsesNamedTransformerDef that);

    /** Process an instance of _EllipsesTransformer. */
    public abstract void for_EllipsesTransformer(_EllipsesTransformer that);

    /** Process an instance of _EllipsesUnparsedTransformer. */
    public abstract void for_EllipsesUnparsedTransformer(_EllipsesUnparsedTransformer that);

    /** Process an instance of _EllipsesNodeTransformer. */
    public abstract void for_EllipsesNodeTransformer(_EllipsesNodeTransformer that);

    /** Process an instance of _EllipsesCaseTransformer. */
    public abstract void for_EllipsesCaseTransformer(_EllipsesCaseTransformer that);

    /** Process an instance of _EllipsesCaseTransformerClause. */
    public abstract void for_EllipsesCaseTransformerClause(_EllipsesCaseTransformerClause that);

    /** Process an instance of _EllipsesSyntaxSymbol. */
    public abstract void for_EllipsesSyntaxSymbol(_EllipsesSyntaxSymbol that);

    /** Process an instance of _EllipsesPrefixedSymbol. */
    public abstract void for_EllipsesPrefixedSymbol(_EllipsesPrefixedSymbol that);

    /** Process an instance of _EllipsesOptionalSymbol. */
    public abstract void for_EllipsesOptionalSymbol(_EllipsesOptionalSymbol that);

    /** Process an instance of _EllipsesRepeatSymbol. */
    public abstract void for_EllipsesRepeatSymbol(_EllipsesRepeatSymbol that);

    /** Process an instance of _EllipsesRepeatOneOrMoreSymbol. */
    public abstract void for_EllipsesRepeatOneOrMoreSymbol(_EllipsesRepeatOneOrMoreSymbol that);

    /** Process an instance of _EllipsesNoWhitespaceSymbol. */
    public abstract void for_EllipsesNoWhitespaceSymbol(_EllipsesNoWhitespaceSymbol that);

    /** Process an instance of _EllipsesGroupSymbol. */
    public abstract void for_EllipsesGroupSymbol(_EllipsesGroupSymbol that);

    /** Process an instance of _EllipsesSpecialSymbol. */
    public abstract void for_EllipsesSpecialSymbol(_EllipsesSpecialSymbol that);

    /** Process an instance of _EllipsesAnyCharacterSymbol. */
    public abstract void for_EllipsesAnyCharacterSymbol(_EllipsesAnyCharacterSymbol that);

    /** Process an instance of _EllipsesWhitespaceSymbol. */
    public abstract void for_EllipsesWhitespaceSymbol(_EllipsesWhitespaceSymbol that);

    /** Process an instance of _EllipsesTabSymbol. */
    public abstract void for_EllipsesTabSymbol(_EllipsesTabSymbol that);

    /** Process an instance of _EllipsesFormfeedSymbol. */
    public abstract void for_EllipsesFormfeedSymbol(_EllipsesFormfeedSymbol that);

    /** Process an instance of _EllipsesCarriageReturnSymbol. */
    public abstract void for_EllipsesCarriageReturnSymbol(_EllipsesCarriageReturnSymbol that);

    /** Process an instance of _EllipsesBackspaceSymbol. */
    public abstract void for_EllipsesBackspaceSymbol(_EllipsesBackspaceSymbol that);

    /** Process an instance of _EllipsesNewlineSymbol. */
    public abstract void for_EllipsesNewlineSymbol(_EllipsesNewlineSymbol that);

    /** Process an instance of _EllipsesBreaklineSymbol. */
    public abstract void for_EllipsesBreaklineSymbol(_EllipsesBreaklineSymbol that);

    /** Process an instance of _EllipsesItemSymbol. */
    public abstract void for_EllipsesItemSymbol(_EllipsesItemSymbol that);

    /** Process an instance of _EllipsesNonterminalSymbol. */
    public abstract void for_EllipsesNonterminalSymbol(_EllipsesNonterminalSymbol that);

    /** Process an instance of _EllipsesKeywordSymbol. */
    public abstract void for_EllipsesKeywordSymbol(_EllipsesKeywordSymbol that);

    /** Process an instance of _EllipsesTokenSymbol. */
    public abstract void for_EllipsesTokenSymbol(_EllipsesTokenSymbol that);

    /** Process an instance of _EllipsesNotPredicateSymbol. */
    public abstract void for_EllipsesNotPredicateSymbol(_EllipsesNotPredicateSymbol that);

    /** Process an instance of _EllipsesAndPredicateSymbol. */
    public abstract void for_EllipsesAndPredicateSymbol(_EllipsesAndPredicateSymbol that);

    /** Process an instance of _EllipsesCharacterClassSymbol. */
    public abstract void for_EllipsesCharacterClassSymbol(_EllipsesCharacterClassSymbol that);

    /** Process an instance of _EllipsesCharacterSymbol. */
    public abstract void for_EllipsesCharacterSymbol(_EllipsesCharacterSymbol that);

    /** Process an instance of _EllipsesCharSymbol. */
    public abstract void for_EllipsesCharSymbol(_EllipsesCharSymbol that);

    /** Process an instance of _EllipsesCharacterInterval. */
    public abstract void for_EllipsesCharacterInterval(_EllipsesCharacterInterval that);

    /** Process an instance of _EllipsesLink. */
    public abstract void for_EllipsesLink(_EllipsesLink that);

    /** Process an instance of TemplateGapAbstractNode. */
    public abstract void forTemplateGapAbstractNode(TemplateGapAbstractNode that);

    /** Process an instance of TemplateGapCompilationUnit. */
    public abstract void forTemplateGapCompilationUnit(TemplateGapCompilationUnit that);

    /** Process an instance of TemplateGapComponent. */
    public abstract void forTemplateGapComponent(TemplateGapComponent that);

    /** Process an instance of TemplateGapApi. */
    public abstract void forTemplateGapApi(TemplateGapApi that);

    /** Process an instance of TemplateGapImport. */
    public abstract void forTemplateGapImport(TemplateGapImport that);

    /** Process an instance of TemplateGapImportedNames. */
    public abstract void forTemplateGapImportedNames(TemplateGapImportedNames that);

    /** Process an instance of TemplateGapImportStar. */
    public abstract void forTemplateGapImportStar(TemplateGapImportStar that);

    /** Process an instance of TemplateGapImportNames. */
    public abstract void forTemplateGapImportNames(TemplateGapImportNames that);

    /** Process an instance of TemplateGapImportApi. */
    public abstract void forTemplateGapImportApi(TemplateGapImportApi that);

    /** Process an instance of TemplateGapAliasedSimpleName. */
    public abstract void forTemplateGapAliasedSimpleName(TemplateGapAliasedSimpleName that);

    /** Process an instance of TemplateGapAliasedAPIName. */
    public abstract void forTemplateGapAliasedAPIName(TemplateGapAliasedAPIName that);

    /** Process an instance of TemplateGapDecl. */
    public abstract void forTemplateGapDecl(TemplateGapDecl that);

    /** Process an instance of TemplateGapTraitObjectDecl. */
    public abstract void forTemplateGapTraitObjectDecl(TemplateGapTraitObjectDecl that);

    /** Process an instance of TemplateGapTraitDecl. */
    public abstract void forTemplateGapTraitDecl(TemplateGapTraitDecl that);

    /** Process an instance of TemplateGapObjectDecl. */
    public abstract void forTemplateGapObjectDecl(TemplateGapObjectDecl that);

    /** Process an instance of TemplateGapVarDecl. */
    public abstract void forTemplateGapVarDecl(TemplateGapVarDecl that);

    /** Process an instance of TemplateGapFnDecl. */
    public abstract void forTemplateGapFnDecl(TemplateGapFnDecl that);

    /** Process an instance of TemplateGap_RewriteFnOverloadDecl. */
    public abstract void forTemplateGap_RewriteFnOverloadDecl(TemplateGap_RewriteFnOverloadDecl that);

    /** Process an instance of TemplateGap_RewriteObjectExprDecl. */
    public abstract void forTemplateGap_RewriteObjectExprDecl(TemplateGap_RewriteObjectExprDecl that);

    /** Process an instance of TemplateGap_RewriteFunctionalMethodDecl. */
    public abstract void forTemplateGap_RewriteFunctionalMethodDecl(TemplateGap_RewriteFunctionalMethodDecl that);

    /** Process an instance of TemplateGapDimUnitDecl. */
    public abstract void forTemplateGapDimUnitDecl(TemplateGapDimUnitDecl that);

    /** Process an instance of TemplateGapDimDecl. */
    public abstract void forTemplateGapDimDecl(TemplateGapDimDecl that);

    /** Process an instance of TemplateGapUnitDecl. */
    public abstract void forTemplateGapUnitDecl(TemplateGapUnitDecl that);

    /** Process an instance of TemplateGapTestDecl. */
    public abstract void forTemplateGapTestDecl(TemplateGapTestDecl that);

    /** Process an instance of TemplateGapPropertyDecl. */
    public abstract void forTemplateGapPropertyDecl(TemplateGapPropertyDecl that);

    /** Process an instance of TemplateGapTypeAlias. */
    public abstract void forTemplateGapTypeAlias(TemplateGapTypeAlias that);

    /** Process an instance of TemplateGapGrammarDecl. */
    public abstract void forTemplateGapGrammarDecl(TemplateGapGrammarDecl that);

    /** Process an instance of TemplateGapGrammarMemberDecl. */
    public abstract void forTemplateGapGrammarMemberDecl(TemplateGapGrammarMemberDecl that);

    /** Process an instance of TemplateGapNonterminalDecl. */
    public abstract void forTemplateGapNonterminalDecl(TemplateGapNonterminalDecl that);

    /** Process an instance of TemplateGapNonterminalDef. */
    public abstract void forTemplateGapNonterminalDef(TemplateGapNonterminalDef that);

    /** Process an instance of TemplateGapNonterminalExtensionDef. */
    public abstract void forTemplateGapNonterminalExtensionDef(TemplateGapNonterminalExtensionDef that);

    /** Process an instance of TemplateGapBinding. */
    public abstract void forTemplateGapBinding(TemplateGapBinding that);

    /** Process an instance of TemplateGapLValue. */
    public abstract void forTemplateGapLValue(TemplateGapLValue that);

    /** Process an instance of TemplateGapParam. */
    public abstract void forTemplateGapParam(TemplateGapParam that);

    /** Process an instance of TemplateGapExpr. */
    public abstract void forTemplateGapExpr(TemplateGapExpr that);

    /** Process an instance of TemplateGapDummyExpr. */
    public abstract void forTemplateGapDummyExpr(TemplateGapDummyExpr that);

    /** Process an instance of TemplateGapTypeAnnotatedExpr. */
    public abstract void forTemplateGapTypeAnnotatedExpr(TemplateGapTypeAnnotatedExpr that);

    /** Process an instance of TemplateGapAsExpr. */
    public abstract void forTemplateGapAsExpr(TemplateGapAsExpr that);

    /** Process an instance of TemplateGapAsIfExpr. */
    public abstract void forTemplateGapAsIfExpr(TemplateGapAsIfExpr that);

    /** Process an instance of TemplateGapAssignment. */
    public abstract void forTemplateGapAssignment(TemplateGapAssignment that);

    /** Process an instance of TemplateGapBlock. */
    public abstract void forTemplateGapBlock(TemplateGapBlock that);

    /** Process an instance of TemplateGapDo. */
    public abstract void forTemplateGapDo(TemplateGapDo that);

    /** Process an instance of TemplateGapCaseExpr. */
    public abstract void forTemplateGapCaseExpr(TemplateGapCaseExpr that);

    /** Process an instance of TemplateGapIf. */
    public abstract void forTemplateGapIf(TemplateGapIf that);

    /** Process an instance of TemplateGapLabel. */
    public abstract void forTemplateGapLabel(TemplateGapLabel that);

    /** Process an instance of TemplateGapAbstractObjectExpr. */
    public abstract void forTemplateGapAbstractObjectExpr(TemplateGapAbstractObjectExpr that);

    /** Process an instance of TemplateGapObjectExpr. */
    public abstract void forTemplateGapObjectExpr(TemplateGapObjectExpr that);

    /** Process an instance of TemplateGap_RewriteObjectExpr. */
    public abstract void forTemplateGap_RewriteObjectExpr(TemplateGap_RewriteObjectExpr that);

    /** Process an instance of TemplateGapTry. */
    public abstract void forTemplateGapTry(TemplateGapTry that);

    /** Process an instance of TemplateGapTupleExpr. */
    public abstract void forTemplateGapTupleExpr(TemplateGapTupleExpr that);

    /** Process an instance of TemplateGapTypecase. */
    public abstract void forTemplateGapTypecase(TemplateGapTypecase that);

    /** Process an instance of TemplateGapWhile. */
    public abstract void forTemplateGapWhile(TemplateGapWhile that);

    /** Process an instance of TemplateGapFor. */
    public abstract void forTemplateGapFor(TemplateGapFor that);

    /** Process an instance of TemplateGapBigOpApp. */
    public abstract void forTemplateGapBigOpApp(TemplateGapBigOpApp that);

    /** Process an instance of TemplateGapAccumulator. */
    public abstract void forTemplateGapAccumulator(TemplateGapAccumulator that);

    /** Process an instance of TemplateGapArrayComprehension. */
    public abstract void forTemplateGapArrayComprehension(TemplateGapArrayComprehension that);

    /** Process an instance of TemplateGapAtomicExpr. */
    public abstract void forTemplateGapAtomicExpr(TemplateGapAtomicExpr that);

    /** Process an instance of TemplateGapExit. */
    public abstract void forTemplateGapExit(TemplateGapExit that);

    /** Process an instance of TemplateGapSpawn. */
    public abstract void forTemplateGapSpawn(TemplateGapSpawn that);

    /** Process an instance of TemplateGapThrow. */
    public abstract void forTemplateGapThrow(TemplateGapThrow that);

    /** Process an instance of TemplateGapTryAtomicExpr. */
    public abstract void forTemplateGapTryAtomicExpr(TemplateGapTryAtomicExpr that);

    /** Process an instance of TemplateGapFnExpr. */
    public abstract void forTemplateGapFnExpr(TemplateGapFnExpr that);

    /** Process an instance of TemplateGapLetExpr. */
    public abstract void forTemplateGapLetExpr(TemplateGapLetExpr that);

    /** Process an instance of TemplateGapLetFn. */
    public abstract void forTemplateGapLetFn(TemplateGapLetFn that);

    /** Process an instance of TemplateGapLocalVarDecl. */
    public abstract void forTemplateGapLocalVarDecl(TemplateGapLocalVarDecl that);

    /** Process an instance of TemplateGapSimpleExpr. */
    public abstract void forTemplateGapSimpleExpr(TemplateGapSimpleExpr that);

    /** Process an instance of TemplateGapSubscriptExpr. */
    public abstract void forTemplateGapSubscriptExpr(TemplateGapSubscriptExpr that);

    /** Process an instance of TemplateGapPrimary. */
    public abstract void forTemplateGapPrimary(TemplateGapPrimary that);

    /** Process an instance of TemplateGapLiteralExpr. */
    public abstract void forTemplateGapLiteralExpr(TemplateGapLiteralExpr that);

    /** Process an instance of TemplateGapNumberLiteralExpr. */
    public abstract void forTemplateGapNumberLiteralExpr(TemplateGapNumberLiteralExpr that);

    /** Process an instance of TemplateGapFloatLiteralExpr. */
    public abstract void forTemplateGapFloatLiteralExpr(TemplateGapFloatLiteralExpr that);

    /** Process an instance of TemplateGapIntLiteralExpr. */
    public abstract void forTemplateGapIntLiteralExpr(TemplateGapIntLiteralExpr that);

    /** Process an instance of TemplateGapCharLiteralExpr. */
    public abstract void forTemplateGapCharLiteralExpr(TemplateGapCharLiteralExpr that);

    /** Process an instance of TemplateGapStringLiteralExpr. */
    public abstract void forTemplateGapStringLiteralExpr(TemplateGapStringLiteralExpr that);

    /** Process an instance of TemplateGapVoidLiteralExpr. */
    public abstract void forTemplateGapVoidLiteralExpr(TemplateGapVoidLiteralExpr that);

    /** Process an instance of TemplateGapBooleanLiteralExpr. */
    public abstract void forTemplateGapBooleanLiteralExpr(TemplateGapBooleanLiteralExpr that);

    /** Process an instance of TemplateGapVarRef. */
    public abstract void forTemplateGapVarRef(TemplateGapVarRef that);

    /** Process an instance of TemplateGapFieldRef. */
    public abstract void forTemplateGapFieldRef(TemplateGapFieldRef that);

    /** Process an instance of TemplateGapFunctionalRef. */
    public abstract void forTemplateGapFunctionalRef(TemplateGapFunctionalRef that);

    /** Process an instance of TemplateGapFnRef. */
    public abstract void forTemplateGapFnRef(TemplateGapFnRef that);

    /** Process an instance of TemplateGapOpRef. */
    public abstract void forTemplateGapOpRef(TemplateGapOpRef that);

    /** Process an instance of TemplateGap_RewriteFnRef. */
    public abstract void forTemplateGap_RewriteFnRef(TemplateGap_RewriteFnRef that);

    /** Process an instance of TemplateGap_RewriteObjectExprRef. */
    public abstract void forTemplateGap_RewriteObjectExprRef(TemplateGap_RewriteObjectExprRef that);

    /** Process an instance of TemplateGapJuxt. */
    public abstract void forTemplateGapJuxt(TemplateGapJuxt that);

    /** Process an instance of TemplateGap_RewriteFnApp. */
    public abstract void forTemplateGap_RewriteFnApp(TemplateGap_RewriteFnApp that);

    /** Process an instance of TemplateGapOpExpr. */
    public abstract void forTemplateGapOpExpr(TemplateGapOpExpr that);

    /** Process an instance of TemplateGapAmbiguousMultifixOpExpr. */
    public abstract void forTemplateGapAmbiguousMultifixOpExpr(TemplateGapAmbiguousMultifixOpExpr that);

    /** Process an instance of TemplateGapChainExpr. */
    public abstract void forTemplateGapChainExpr(TemplateGapChainExpr that);

    /** Process an instance of TemplateGapCoercionInvocation. */
    public abstract void forTemplateGapCoercionInvocation(TemplateGapCoercionInvocation that);

    /** Process an instance of TemplateGapTraitCoercionInvocation. */
    public abstract void forTemplateGapTraitCoercionInvocation(TemplateGapTraitCoercionInvocation that);

    /** Process an instance of TemplateGapTupleCoercionInvocation. */
    public abstract void forTemplateGapTupleCoercionInvocation(TemplateGapTupleCoercionInvocation that);

    /** Process an instance of TemplateGapArrowCoercionInvocation. */
    public abstract void forTemplateGapArrowCoercionInvocation(TemplateGapArrowCoercionInvocation that);

    /** Process an instance of TemplateGapUnionCoercionInvocation. */
    public abstract void forTemplateGapUnionCoercionInvocation(TemplateGapUnionCoercionInvocation that);

    /** Process an instance of TemplateGapMethodInvocation. */
    public abstract void forTemplateGapMethodInvocation(TemplateGapMethodInvocation that);

    /** Process an instance of TemplateGapMathPrimary. */
    public abstract void forTemplateGapMathPrimary(TemplateGapMathPrimary that);

    /** Process an instance of TemplateGapArrayExpr. */
    public abstract void forTemplateGapArrayExpr(TemplateGapArrayExpr that);

    /** Process an instance of TemplateGapArrayElement. */
    public abstract void forTemplateGapArrayElement(TemplateGapArrayElement that);

    /** Process an instance of TemplateGapArrayElements. */
    public abstract void forTemplateGapArrayElements(TemplateGapArrayElements that);

    /** Process an instance of TemplateGapType. */
    public abstract void forTemplateGapType(TemplateGapType that);

    /** Process an instance of TemplateGapBaseType. */
    public abstract void forTemplateGapBaseType(TemplateGapBaseType that);

    /** Process an instance of TemplateGapAnyType. */
    public abstract void forTemplateGapAnyType(TemplateGapAnyType that);

    /** Process an instance of TemplateGapBottomType. */
    public abstract void forTemplateGapBottomType(TemplateGapBottomType that);

    /** Process an instance of TemplateGapUnknownType. */
    public abstract void forTemplateGapUnknownType(TemplateGapUnknownType that);

    /** Process an instance of TemplateGapSelfType. */
    public abstract void forTemplateGapSelfType(TemplateGapSelfType that);

    /** Process an instance of TemplateGapTraitSelfType. */
    public abstract void forTemplateGapTraitSelfType(TemplateGapTraitSelfType that);

    /** Process an instance of TemplateGapObjectExprType. */
    public abstract void forTemplateGapObjectExprType(TemplateGapObjectExprType that);

    /** Process an instance of TemplateGapNamedType. */
    public abstract void forTemplateGapNamedType(TemplateGapNamedType that);

    /** Process an instance of TemplateGap_InferenceVarType. */
    public abstract void forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that);

    /** Process an instance of TemplateGapVarType. */
    public abstract void forTemplateGapVarType(TemplateGapVarType that);

    /** Process an instance of TemplateGapTraitType. */
    public abstract void forTemplateGapTraitType(TemplateGapTraitType that);

    /** Process an instance of TemplateGapAbbreviatedType. */
    public abstract void forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that);

    /** Process an instance of TemplateGapArrayType. */
    public abstract void forTemplateGapArrayType(TemplateGapArrayType that);

    /** Process an instance of TemplateGapMatrixType. */
    public abstract void forTemplateGapMatrixType(TemplateGapMatrixType that);

    /** Process an instance of TemplateGapTaggedDimType. */
    public abstract void forTemplateGapTaggedDimType(TemplateGapTaggedDimType that);

    /** Process an instance of TemplateGapTaggedUnitType. */
    public abstract void forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that);

    /** Process an instance of TemplateGapTupleType. */
    public abstract void forTemplateGapTupleType(TemplateGapTupleType that);

    /** Process an instance of TemplateGapArrowType. */
    public abstract void forTemplateGapArrowType(TemplateGapArrowType that);

    /** Process an instance of TemplateGapBoundType. */
    public abstract void forTemplateGapBoundType(TemplateGapBoundType that);

    /** Process an instance of TemplateGapIntersectionType. */
    public abstract void forTemplateGapIntersectionType(TemplateGapIntersectionType that);

    /** Process an instance of TemplateGapUnionType. */
    public abstract void forTemplateGapUnionType(TemplateGapUnionType that);

    /** Process an instance of TemplateGapFixedPointType. */
    public abstract void forTemplateGapFixedPointType(TemplateGapFixedPointType that);

    /** Process an instance of TemplateGapLabelType. */
    public abstract void forTemplateGapLabelType(TemplateGapLabelType that);

    /** Process an instance of TemplateGapDimExpr. */
    public abstract void forTemplateGapDimExpr(TemplateGapDimExpr that);

    /** Process an instance of TemplateGapDimBase. */
    public abstract void forTemplateGapDimBase(TemplateGapDimBase that);

    /** Process an instance of TemplateGapDimRef. */
    public abstract void forTemplateGapDimRef(TemplateGapDimRef that);

    /** Process an instance of TemplateGapDimExponent. */
    public abstract void forTemplateGapDimExponent(TemplateGapDimExponent that);

    /** Process an instance of TemplateGapDimUnaryOp. */
    public abstract void forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that);

    /** Process an instance of TemplateGapDimBinaryOp. */
    public abstract void forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that);

    /** Process an instance of TemplateGapPattern. */
    public abstract void forTemplateGapPattern(TemplateGapPattern that);

    /** Process an instance of TemplateGapPatternArgs. */
    public abstract void forTemplateGapPatternArgs(TemplateGapPatternArgs that);

    /** Process an instance of TemplateGapPatternBinding. */
    public abstract void forTemplateGapPatternBinding(TemplateGapPatternBinding that);

    /** Process an instance of TemplateGapPlainPattern. */
    public abstract void forTemplateGapPlainPattern(TemplateGapPlainPattern that);

    /** Process an instance of TemplateGapTypePattern. */
    public abstract void forTemplateGapTypePattern(TemplateGapTypePattern that);

    /** Process an instance of TemplateGapNestedPattern. */
    public abstract void forTemplateGapNestedPattern(TemplateGapNestedPattern that);

    /** Process an instance of TemplateGapStaticArg. */
    public abstract void forTemplateGapStaticArg(TemplateGapStaticArg that);

    /** Process an instance of TemplateGapTypeArg. */
    public abstract void forTemplateGapTypeArg(TemplateGapTypeArg that);

    /** Process an instance of TemplateGapIntArg. */
    public abstract void forTemplateGapIntArg(TemplateGapIntArg that);

    /** Process an instance of TemplateGapBoolArg. */
    public abstract void forTemplateGapBoolArg(TemplateGapBoolArg that);

    /** Process an instance of TemplateGapOpArg. */
    public abstract void forTemplateGapOpArg(TemplateGapOpArg that);

    /** Process an instance of TemplateGapDimArg. */
    public abstract void forTemplateGapDimArg(TemplateGapDimArg that);

    /** Process an instance of TemplateGapUnitArg. */
    public abstract void forTemplateGapUnitArg(TemplateGapUnitArg that);

    /** Process an instance of TemplateGapStaticExpr. */
    public abstract void forTemplateGapStaticExpr(TemplateGapStaticExpr that);

    /** Process an instance of TemplateGapIntExpr. */
    public abstract void forTemplateGapIntExpr(TemplateGapIntExpr that);

    /** Process an instance of TemplateGapIntBase. */
    public abstract void forTemplateGapIntBase(TemplateGapIntBase that);

    /** Process an instance of TemplateGapIntRef. */
    public abstract void forTemplateGapIntRef(TemplateGapIntRef that);

    /** Process an instance of TemplateGapIntBinaryOp. */
    public abstract void forTemplateGapIntBinaryOp(TemplateGapIntBinaryOp that);

    /** Process an instance of TemplateGapBoolExpr. */
    public abstract void forTemplateGapBoolExpr(TemplateGapBoolExpr that);

    /** Process an instance of TemplateGapBoolBase. */
    public abstract void forTemplateGapBoolBase(TemplateGapBoolBase that);

    /** Process an instance of TemplateGapBoolRef. */
    public abstract void forTemplateGapBoolRef(TemplateGapBoolRef that);

    /** Process an instance of TemplateGapBoolConstraint. */
    public abstract void forTemplateGapBoolConstraint(TemplateGapBoolConstraint that);

    /** Process an instance of TemplateGapBoolUnaryOp. */
    public abstract void forTemplateGapBoolUnaryOp(TemplateGapBoolUnaryOp that);

    /** Process an instance of TemplateGapBoolBinaryOp. */
    public abstract void forTemplateGapBoolBinaryOp(TemplateGapBoolBinaryOp that);

    /** Process an instance of TemplateGapUnitExpr. */
    public abstract void forTemplateGapUnitExpr(TemplateGapUnitExpr that);

    /** Process an instance of TemplateGapUnitRef. */
    public abstract void forTemplateGapUnitRef(TemplateGapUnitRef that);

    /** Process an instance of TemplateGapUnitBinaryOp. */
    public abstract void forTemplateGapUnitBinaryOp(TemplateGapUnitBinaryOp that);

    /** Process an instance of TemplateGapEffect. */
    public abstract void forTemplateGapEffect(TemplateGapEffect that);

    /** Process an instance of TemplateGapWhereClause. */
    public abstract void forTemplateGapWhereClause(TemplateGapWhereClause that);

    /** Process an instance of TemplateGapWhereBinding. */
    public abstract void forTemplateGapWhereBinding(TemplateGapWhereBinding that);

    /** Process an instance of TemplateGapWhereConstraint. */
    public abstract void forTemplateGapWhereConstraint(TemplateGapWhereConstraint that);

    /** Process an instance of TemplateGapWhereExtends. */
    public abstract void forTemplateGapWhereExtends(TemplateGapWhereExtends that);

    /** Process an instance of TemplateGapWhereTypeAlias. */
    public abstract void forTemplateGapWhereTypeAlias(TemplateGapWhereTypeAlias that);

    /** Process an instance of TemplateGapWhereCoerces. */
    public abstract void forTemplateGapWhereCoerces(TemplateGapWhereCoerces that);

    /** Process an instance of TemplateGapWhereEquals. */
    public abstract void forTemplateGapWhereEquals(TemplateGapWhereEquals that);

    /** Process an instance of TemplateGapUnitConstraint. */
    public abstract void forTemplateGapUnitConstraint(TemplateGapUnitConstraint that);

    /** Process an instance of TemplateGapIntConstraint. */
    public abstract void forTemplateGapIntConstraint(TemplateGapIntConstraint that);

    /** Process an instance of TemplateGapBoolConstraintExpr. */
    public abstract void forTemplateGapBoolConstraintExpr(TemplateGapBoolConstraintExpr that);

    /** Process an instance of TemplateGapContract. */
    public abstract void forTemplateGapContract(TemplateGapContract that);

    /** Process an instance of TemplateGapEnsuresClause. */
    public abstract void forTemplateGapEnsuresClause(TemplateGapEnsuresClause that);

    /** Process an instance of TemplateGapStaticParam. */
    public abstract void forTemplateGapStaticParam(TemplateGapStaticParam that);

    /** Process an instance of TemplateGapName. */
    public abstract void forTemplateGapName(TemplateGapName that);

    /** Process an instance of TemplateGapAPIName. */
    public abstract void forTemplateGapAPIName(TemplateGapAPIName that);

    /** Process an instance of TemplateGapIdOrOpOrAnonymousName. */
    public abstract void forTemplateGapIdOrOpOrAnonymousName(TemplateGapIdOrOpOrAnonymousName that);

    /** Process an instance of TemplateGapIdOrOp. */
    public abstract void forTemplateGapIdOrOp(TemplateGapIdOrOp that);

    /** Process an instance of TemplateGapId. */
    public abstract void forTemplateGapId(TemplateGapId that);

    /** Process an instance of TemplateGapOp. */
    public abstract void forTemplateGapOp(TemplateGapOp that);

    /** Process an instance of TemplateGapNamedOp. */
    public abstract void forTemplateGapNamedOp(TemplateGapNamedOp that);

    /** Process an instance of TemplateGap_InferenceVarOp. */
    public abstract void forTemplateGap_InferenceVarOp(TemplateGap_InferenceVarOp that);

    /** Process an instance of TemplateGapAnonymousName. */
    public abstract void forTemplateGapAnonymousName(TemplateGapAnonymousName that);

    /** Process an instance of TemplateGapAnonymousFnName. */
    public abstract void forTemplateGapAnonymousFnName(TemplateGapAnonymousFnName that);

    /** Process an instance of TemplateGapConstructorFnName. */
    public abstract void forTemplateGapConstructorFnName(TemplateGapConstructorFnName that);

    /** Process an instance of TemplateGapArrayComprehensionClause. */
    public abstract void forTemplateGapArrayComprehensionClause(TemplateGapArrayComprehensionClause that);

    /** Process an instance of TemplateGapKeywordExpr. */
    public abstract void forTemplateGapKeywordExpr(TemplateGapKeywordExpr that);

    /** Process an instance of TemplateGapCaseClause. */
    public abstract void forTemplateGapCaseClause(TemplateGapCaseClause that);

    /** Process an instance of TemplateGapCatch. */
    public abstract void forTemplateGapCatch(TemplateGapCatch that);

    /** Process an instance of TemplateGapCatchClause. */
    public abstract void forTemplateGapCatchClause(TemplateGapCatchClause that);

    /** Process an instance of TemplateGapIfClause. */
    public abstract void forTemplateGapIfClause(TemplateGapIfClause that);

    /** Process an instance of TemplateGapTypecaseClause. */
    public abstract void forTemplateGapTypecaseClause(TemplateGapTypecaseClause that);

    /** Process an instance of TemplateGapExtentRange. */
    public abstract void forTemplateGapExtentRange(TemplateGapExtentRange that);

    /** Process an instance of TemplateGapGeneratorClause. */
    public abstract void forTemplateGapGeneratorClause(TemplateGapGeneratorClause that);

    /** Process an instance of TemplateGapKeywordType. */
    public abstract void forTemplateGapKeywordType(TemplateGapKeywordType that);

    /** Process an instance of TemplateGapTraitTypeWhere. */
    public abstract void forTemplateGapTraitTypeWhere(TemplateGapTraitTypeWhere that);

    /** Process an instance of TemplateGapIndices. */
    public abstract void forTemplateGapIndices(TemplateGapIndices that);

    /** Process an instance of TemplateGapMathItem. */
    public abstract void forTemplateGapMathItem(TemplateGapMathItem that);

    /** Process an instance of TemplateGapExprMI. */
    public abstract void forTemplateGapExprMI(TemplateGapExprMI that);

    /** Process an instance of TemplateGapParenthesisDelimitedMI. */
    public abstract void forTemplateGapParenthesisDelimitedMI(TemplateGapParenthesisDelimitedMI that);

    /** Process an instance of TemplateGapNonParenthesisDelimitedMI. */
    public abstract void forTemplateGapNonParenthesisDelimitedMI(TemplateGapNonParenthesisDelimitedMI that);

    /** Process an instance of TemplateGapNonExprMI. */
    public abstract void forTemplateGapNonExprMI(TemplateGapNonExprMI that);

    /** Process an instance of TemplateGapExponentiationMI. */
    public abstract void forTemplateGapExponentiationMI(TemplateGapExponentiationMI that);

    /** Process an instance of TemplateGapSubscriptingMI. */
    public abstract void forTemplateGapSubscriptingMI(TemplateGapSubscriptingMI that);

    /** Process an instance of TemplateGapOverloading. */
    public abstract void forTemplateGapOverloading(TemplateGapOverloading that);

    /** Process an instance of TemplateGapNonterminalHeader. */
    public abstract void forTemplateGapNonterminalHeader(TemplateGapNonterminalHeader that);

    /** Process an instance of TemplateGapNonterminalParameter. */
    public abstract void forTemplateGapNonterminalParameter(TemplateGapNonterminalParameter that);

    /** Process an instance of TemplateGapSyntaxDecl. */
    public abstract void forTemplateGapSyntaxDecl(TemplateGapSyntaxDecl that);

    /** Process an instance of TemplateGapSyntaxDef. */
    public abstract void forTemplateGapSyntaxDef(TemplateGapSyntaxDef that);

    /** Process an instance of TemplateGapSuperSyntaxDef. */
    public abstract void forTemplateGapSuperSyntaxDef(TemplateGapSuperSyntaxDef that);

    /** Process an instance of TemplateGapTransformerDecl. */
    public abstract void forTemplateGapTransformerDecl(TemplateGapTransformerDecl that);

    /** Process an instance of TemplateGapPreTransformerDef. */
    public abstract void forTemplateGapPreTransformerDef(TemplateGapPreTransformerDef that);

    /** Process an instance of TemplateGapNamedTransformerDef. */
    public abstract void forTemplateGapNamedTransformerDef(TemplateGapNamedTransformerDef that);

    /** Process an instance of TemplateGapTransformer. */
    public abstract void forTemplateGapTransformer(TemplateGapTransformer that);

    /** Process an instance of TemplateGapUnparsedTransformer. */
    public abstract void forTemplateGapUnparsedTransformer(TemplateGapUnparsedTransformer that);

    /** Process an instance of TemplateGapNodeTransformer. */
    public abstract void forTemplateGapNodeTransformer(TemplateGapNodeTransformer that);

    /** Process an instance of TemplateGapCaseTransformer. */
    public abstract void forTemplateGapCaseTransformer(TemplateGapCaseTransformer that);

    /** Process an instance of TemplateGapCaseTransformerClause. */
    public abstract void forTemplateGapCaseTransformerClause(TemplateGapCaseTransformerClause that);

    /** Process an instance of TemplateGapSyntaxSymbol. */
    public abstract void forTemplateGapSyntaxSymbol(TemplateGapSyntaxSymbol that);

    /** Process an instance of TemplateGapPrefixedSymbol. */
    public abstract void forTemplateGapPrefixedSymbol(TemplateGapPrefixedSymbol that);

    /** Process an instance of TemplateGapOptionalSymbol. */
    public abstract void forTemplateGapOptionalSymbol(TemplateGapOptionalSymbol that);

    /** Process an instance of TemplateGapRepeatSymbol. */
    public abstract void forTemplateGapRepeatSymbol(TemplateGapRepeatSymbol that);

    /** Process an instance of TemplateGapRepeatOneOrMoreSymbol. */
    public abstract void forTemplateGapRepeatOneOrMoreSymbol(TemplateGapRepeatOneOrMoreSymbol that);

    /** Process an instance of TemplateGapNoWhitespaceSymbol. */
    public abstract void forTemplateGapNoWhitespaceSymbol(TemplateGapNoWhitespaceSymbol that);

    /** Process an instance of TemplateGapGroupSymbol. */
    public abstract void forTemplateGapGroupSymbol(TemplateGapGroupSymbol that);

    /** Process an instance of TemplateGapSpecialSymbol. */
    public abstract void forTemplateGapSpecialSymbol(TemplateGapSpecialSymbol that);

    /** Process an instance of TemplateGapAnyCharacterSymbol. */
    public abstract void forTemplateGapAnyCharacterSymbol(TemplateGapAnyCharacterSymbol that);

    /** Process an instance of TemplateGapWhitespaceSymbol. */
    public abstract void forTemplateGapWhitespaceSymbol(TemplateGapWhitespaceSymbol that);

    /** Process an instance of TemplateGapTabSymbol. */
    public abstract void forTemplateGapTabSymbol(TemplateGapTabSymbol that);

    /** Process an instance of TemplateGapFormfeedSymbol. */
    public abstract void forTemplateGapFormfeedSymbol(TemplateGapFormfeedSymbol that);

    /** Process an instance of TemplateGapCarriageReturnSymbol. */
    public abstract void forTemplateGapCarriageReturnSymbol(TemplateGapCarriageReturnSymbol that);

    /** Process an instance of TemplateGapBackspaceSymbol. */
    public abstract void forTemplateGapBackspaceSymbol(TemplateGapBackspaceSymbol that);

    /** Process an instance of TemplateGapNewlineSymbol. */
    public abstract void forTemplateGapNewlineSymbol(TemplateGapNewlineSymbol that);

    /** Process an instance of TemplateGapBreaklineSymbol. */
    public abstract void forTemplateGapBreaklineSymbol(TemplateGapBreaklineSymbol that);

    /** Process an instance of TemplateGapItemSymbol. */
    public abstract void forTemplateGapItemSymbol(TemplateGapItemSymbol that);

    /** Process an instance of TemplateGapNonterminalSymbol. */
    public abstract void forTemplateGapNonterminalSymbol(TemplateGapNonterminalSymbol that);

    /** Process an instance of TemplateGapKeywordSymbol. */
    public abstract void forTemplateGapKeywordSymbol(TemplateGapKeywordSymbol that);

    /** Process an instance of TemplateGapTokenSymbol. */
    public abstract void forTemplateGapTokenSymbol(TemplateGapTokenSymbol that);

    /** Process an instance of TemplateGapNotPredicateSymbol. */
    public abstract void forTemplateGapNotPredicateSymbol(TemplateGapNotPredicateSymbol that);

    /** Process an instance of TemplateGapAndPredicateSymbol. */
    public abstract void forTemplateGapAndPredicateSymbol(TemplateGapAndPredicateSymbol that);

    /** Process an instance of TemplateGapCharacterClassSymbol. */
    public abstract void forTemplateGapCharacterClassSymbol(TemplateGapCharacterClassSymbol that);

    /** Process an instance of TemplateGapCharacterSymbol. */
    public abstract void forTemplateGapCharacterSymbol(TemplateGapCharacterSymbol that);

    /** Process an instance of TemplateGapCharSymbol. */
    public abstract void forTemplateGapCharSymbol(TemplateGapCharSymbol that);

    /** Process an instance of TemplateGapCharacterInterval. */
    public abstract void forTemplateGapCharacterInterval(TemplateGapCharacterInterval that);

    /** Process an instance of TemplateGapLink. */
    public abstract void forTemplateGapLink(TemplateGapLink that);
}
