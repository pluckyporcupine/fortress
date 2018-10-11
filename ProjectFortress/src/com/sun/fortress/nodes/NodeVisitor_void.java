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

/** An interface for visitors over Node that do not return a value. */
@SuppressWarnings("unused")
public interface NodeVisitor_void extends AbstractNodeVisitor_void, ExprVisitor_void, TypeVisitor_void, StaticArgVisitor_void {

    /** Process an instance of Component. */
    public void forComponent(Component that);

    /** Process an instance of Api. */
    public void forApi(Api that);

    /** Process an instance of ImportStar. */
    public void forImportStar(ImportStar that);

    /** Process an instance of ImportNames. */
    public void forImportNames(ImportNames that);

    /** Process an instance of ImportApi. */
    public void forImportApi(ImportApi that);

    /** Process an instance of AliasedSimpleName. */
    public void forAliasedSimpleName(AliasedSimpleName that);

    /** Process an instance of AliasedAPIName. */
    public void forAliasedAPIName(AliasedAPIName that);

    /** Process an instance of TraitDecl. */
    public void forTraitDecl(TraitDecl that);

    /** Process an instance of ObjectDecl. */
    public void forObjectDecl(ObjectDecl that);

    /** Process an instance of VarDecl. */
    public void forVarDecl(VarDecl that);

    /** Process an instance of FnDecl. */
    public void forFnDecl(FnDecl that);

    /** Process an instance of _RewriteFnOverloadDecl. */
    public void for_RewriteFnOverloadDecl(_RewriteFnOverloadDecl that);

    /** Process an instance of _RewriteObjectExprDecl. */
    public void for_RewriteObjectExprDecl(_RewriteObjectExprDecl that);

    /** Process an instance of _RewriteFunctionalMethodDecl. */
    public void for_RewriteFunctionalMethodDecl(_RewriteFunctionalMethodDecl that);

    /** Process an instance of DimDecl. */
    public void forDimDecl(DimDecl that);

    /** Process an instance of UnitDecl. */
    public void forUnitDecl(UnitDecl that);

    /** Process an instance of TestDecl. */
    public void forTestDecl(TestDecl that);

    /** Process an instance of PropertyDecl. */
    public void forPropertyDecl(PropertyDecl that);

    /** Process an instance of TypeAlias. */
    public void forTypeAlias(TypeAlias that);

    /** Process an instance of GrammarDecl. */
    public void forGrammarDecl(GrammarDecl that);

    /** Process an instance of NonterminalDef. */
    public void forNonterminalDef(NonterminalDef that);

    /** Process an instance of NonterminalExtensionDef. */
    public void forNonterminalExtensionDef(NonterminalExtensionDef that);

    /** Process an instance of LValue. */
    public void forLValue(LValue that);

    /** Process an instance of Param. */
    public void forParam(Param that);

    /** Process an instance of DummyExpr. */
    public void forDummyExpr(DummyExpr that);

    /** Process an instance of AsExpr. */
    public void forAsExpr(AsExpr that);

    /** Process an instance of AsIfExpr. */
    public void forAsIfExpr(AsIfExpr that);

    /** Process an instance of Assignment. */
    public void forAssignment(Assignment that);

    /** Process an instance of Block. */
    public void forBlock(Block that);

    /** Process an instance of Do. */
    public void forDo(Do that);

    /** Process an instance of CaseExpr. */
    public void forCaseExpr(CaseExpr that);

    /** Process an instance of If. */
    public void forIf(If that);

    /** Process an instance of Label. */
    public void forLabel(Label that);

    /** Process an instance of ObjectExpr. */
    public void forObjectExpr(ObjectExpr that);

    /** Process an instance of _RewriteObjectExpr. */
    public void for_RewriteObjectExpr(_RewriteObjectExpr that);

    /** Process an instance of Try. */
    public void forTry(Try that);

    /** Process an instance of TupleExpr. */
    public void forTupleExpr(TupleExpr that);

    /** Process an instance of Typecase. */
    public void forTypecase(Typecase that);

    /** Process an instance of While. */
    public void forWhile(While that);

    /** Process an instance of For. */
    public void forFor(For that);

    /** Process an instance of Accumulator. */
    public void forAccumulator(Accumulator that);

    /** Process an instance of ArrayComprehension. */
    public void forArrayComprehension(ArrayComprehension that);

    /** Process an instance of AtomicExpr. */
    public void forAtomicExpr(AtomicExpr that);

    /** Process an instance of Exit. */
    public void forExit(Exit that);

    /** Process an instance of Spawn. */
    public void forSpawn(Spawn that);

    /** Process an instance of Throw. */
    public void forThrow(Throw that);

    /** Process an instance of TryAtomicExpr. */
    public void forTryAtomicExpr(TryAtomicExpr that);

    /** Process an instance of FnExpr. */
    public void forFnExpr(FnExpr that);

    /** Process an instance of LetFn. */
    public void forLetFn(LetFn that);

    /** Process an instance of LocalVarDecl. */
    public void forLocalVarDecl(LocalVarDecl that);

    /** Process an instance of SubscriptExpr. */
    public void forSubscriptExpr(SubscriptExpr that);

    /** Process an instance of FloatLiteralExpr. */
    public void forFloatLiteralExpr(FloatLiteralExpr that);

    /** Process an instance of IntLiteralExpr. */
    public void forIntLiteralExpr(IntLiteralExpr that);

    /** Process an instance of CharLiteralExpr. */
    public void forCharLiteralExpr(CharLiteralExpr that);

    /** Process an instance of StringLiteralExpr. */
    public void forStringLiteralExpr(StringLiteralExpr that);

    /** Process an instance of VoidLiteralExpr. */
    public void forVoidLiteralExpr(VoidLiteralExpr that);

    /** Process an instance of BooleanLiteralExpr. */
    public void forBooleanLiteralExpr(BooleanLiteralExpr that);

    /** Process an instance of VarRef. */
    public void forVarRef(VarRef that);

    /** Process an instance of FieldRef. */
    public void forFieldRef(FieldRef that);

    /** Process an instance of FnRef. */
    public void forFnRef(FnRef that);

    /** Process an instance of OpRef. */
    public void forOpRef(OpRef that);

    /** Process an instance of _RewriteFnRef. */
    public void for_RewriteFnRef(_RewriteFnRef that);

    /** Process an instance of _RewriteObjectExprRef. */
    public void for_RewriteObjectExprRef(_RewriteObjectExprRef that);

    /** Process an instance of Juxt. */
    public void forJuxt(Juxt that);

    /** Process an instance of _RewriteFnApp. */
    public void for_RewriteFnApp(_RewriteFnApp that);

    /** Process an instance of OpExpr. */
    public void forOpExpr(OpExpr that);

    /** Process an instance of AmbiguousMultifixOpExpr. */
    public void forAmbiguousMultifixOpExpr(AmbiguousMultifixOpExpr that);

    /** Process an instance of ChainExpr. */
    public void forChainExpr(ChainExpr that);

    /** Process an instance of TraitCoercionInvocation. */
    public void forTraitCoercionInvocation(TraitCoercionInvocation that);

    /** Process an instance of TupleCoercionInvocation. */
    public void forTupleCoercionInvocation(TupleCoercionInvocation that);

    /** Process an instance of ArrowCoercionInvocation. */
    public void forArrowCoercionInvocation(ArrowCoercionInvocation that);

    /** Process an instance of UnionCoercionInvocation. */
    public void forUnionCoercionInvocation(UnionCoercionInvocation that);

    /** Process an instance of MethodInvocation. */
    public void forMethodInvocation(MethodInvocation that);

    /** Process an instance of MathPrimary. */
    public void forMathPrimary(MathPrimary that);

    /** Process an instance of ArrayElement. */
    public void forArrayElement(ArrayElement that);

    /** Process an instance of ArrayElements. */
    public void forArrayElements(ArrayElements that);

    /** Process an instance of AnyType. */
    public void forAnyType(AnyType that);

    /** Process an instance of BottomType. */
    public void forBottomType(BottomType that);

    /** Process an instance of UnknownType. */
    public void forUnknownType(UnknownType that);

    /** Process an instance of TraitSelfType. */
    public void forTraitSelfType(TraitSelfType that);

    /** Process an instance of ObjectExprType. */
    public void forObjectExprType(ObjectExprType that);

    /** Process an instance of _InferenceVarType. */
    public void for_InferenceVarType(_InferenceVarType that);

    /** Process an instance of VarType. */
    public void forVarType(VarType that);

    /** Process an instance of TraitType. */
    public void forTraitType(TraitType that);

    /** Process an instance of ArrayType. */
    public void forArrayType(ArrayType that);

    /** Process an instance of MatrixType. */
    public void forMatrixType(MatrixType that);

    /** Process an instance of TaggedDimType. */
    public void forTaggedDimType(TaggedDimType that);

    /** Process an instance of TaggedUnitType. */
    public void forTaggedUnitType(TaggedUnitType that);

    /** Process an instance of TupleType. */
    public void forTupleType(TupleType that);

    /** Process an instance of ArrowType. */
    public void forArrowType(ArrowType that);

    /** Process an instance of IntersectionType. */
    public void forIntersectionType(IntersectionType that);

    /** Process an instance of UnionType. */
    public void forUnionType(UnionType that);

    /** Process an instance of FixedPointType. */
    public void forFixedPointType(FixedPointType that);

    /** Process an instance of LabelType. */
    public void forLabelType(LabelType that);

    /** Process an instance of DimBase. */
    public void forDimBase(DimBase that);

    /** Process an instance of DimRef. */
    public void forDimRef(DimRef that);

    /** Process an instance of DimExponent. */
    public void forDimExponent(DimExponent that);

    /** Process an instance of DimUnaryOp. */
    public void forDimUnaryOp(DimUnaryOp that);

    /** Process an instance of DimBinaryOp. */
    public void forDimBinaryOp(DimBinaryOp that);

    /** Process an instance of Pattern. */
    public void forPattern(Pattern that);

    /** Process an instance of PatternArgs. */
    public void forPatternArgs(PatternArgs that);

    /** Process an instance of PlainPattern. */
    public void forPlainPattern(PlainPattern that);

    /** Process an instance of TypePattern. */
    public void forTypePattern(TypePattern that);

    /** Process an instance of NestedPattern. */
    public void forNestedPattern(NestedPattern that);

    /** Process an instance of TypeArg. */
    public void forTypeArg(TypeArg that);

    /** Process an instance of IntArg. */
    public void forIntArg(IntArg that);

    /** Process an instance of BoolArg. */
    public void forBoolArg(BoolArg that);

    /** Process an instance of OpArg. */
    public void forOpArg(OpArg that);

    /** Process an instance of DimArg. */
    public void forDimArg(DimArg that);

    /** Process an instance of UnitArg. */
    public void forUnitArg(UnitArg that);

    /** Process an instance of IntBase. */
    public void forIntBase(IntBase that);

    /** Process an instance of IntRef. */
    public void forIntRef(IntRef that);

    /** Process an instance of IntBinaryOp. */
    public void forIntBinaryOp(IntBinaryOp that);

    /** Process an instance of BoolBase. */
    public void forBoolBase(BoolBase that);

    /** Process an instance of BoolRef. */
    public void forBoolRef(BoolRef that);

    /** Process an instance of BoolUnaryOp. */
    public void forBoolUnaryOp(BoolUnaryOp that);

    /** Process an instance of BoolBinaryOp. */
    public void forBoolBinaryOp(BoolBinaryOp that);

    /** Process an instance of UnitRef. */
    public void forUnitRef(UnitRef that);

    /** Process an instance of UnitBinaryOp. */
    public void forUnitBinaryOp(UnitBinaryOp that);

    /** Process an instance of Effect. */
    public void forEffect(Effect that);

    /** Process an instance of WhereClause. */
    public void forWhereClause(WhereClause that);

    /** Process an instance of WhereBinding. */
    public void forWhereBinding(WhereBinding that);

    /** Process an instance of WhereExtends. */
    public void forWhereExtends(WhereExtends that);

    /** Process an instance of WhereTypeAlias. */
    public void forWhereTypeAlias(WhereTypeAlias that);

    /** Process an instance of WhereCoerces. */
    public void forWhereCoerces(WhereCoerces that);

    /** Process an instance of WhereEquals. */
    public void forWhereEquals(WhereEquals that);

    /** Process an instance of UnitConstraint. */
    public void forUnitConstraint(UnitConstraint that);

    /** Process an instance of IntConstraint. */
    public void forIntConstraint(IntConstraint that);

    /** Process an instance of BoolConstraintExpr. */
    public void forBoolConstraintExpr(BoolConstraintExpr that);

    /** Process an instance of Contract. */
    public void forContract(Contract that);

    /** Process an instance of EnsuresClause. */
    public void forEnsuresClause(EnsuresClause that);

    /** Process an instance of StaticParam. */
    public void forStaticParam(StaticParam that);

    /** Process an instance of APIName. */
    public void forAPIName(APIName that);

    /** Process an instance of Id. */
    public void forId(Id that);

    /** Process an instance of NamedOp. */
    public void forNamedOp(NamedOp that);

    /** Process an instance of _InferenceVarOp. */
    public void for_InferenceVarOp(_InferenceVarOp that);

    /** Process an instance of AnonymousFnName. */
    public void forAnonymousFnName(AnonymousFnName that);

    /** Process an instance of ConstructorFnName. */
    public void forConstructorFnName(ConstructorFnName that);

    /** Process an instance of ArrayComprehensionClause. */
    public void forArrayComprehensionClause(ArrayComprehensionClause that);

    /** Process an instance of KeywordExpr. */
    public void forKeywordExpr(KeywordExpr that);

    /** Process an instance of CaseClause. */
    public void forCaseClause(CaseClause that);

    /** Process an instance of Catch. */
    public void forCatch(Catch that);

    /** Process an instance of CatchClause. */
    public void forCatchClause(CatchClause that);

    /** Process an instance of IfClause. */
    public void forIfClause(IfClause that);

    /** Process an instance of TypecaseClause. */
    public void forTypecaseClause(TypecaseClause that);

    /** Process an instance of ExtentRange. */
    public void forExtentRange(ExtentRange that);

    /** Process an instance of GeneratorClause. */
    public void forGeneratorClause(GeneratorClause that);

    /** Process an instance of KeywordType. */
    public void forKeywordType(KeywordType that);

    /** Process an instance of TraitTypeWhere. */
    public void forTraitTypeWhere(TraitTypeWhere that);

    /** Process an instance of Indices. */
    public void forIndices(Indices that);

    /** Process an instance of ParenthesisDelimitedMI. */
    public void forParenthesisDelimitedMI(ParenthesisDelimitedMI that);

    /** Process an instance of NonParenthesisDelimitedMI. */
    public void forNonParenthesisDelimitedMI(NonParenthesisDelimitedMI that);

    /** Process an instance of ExponentiationMI. */
    public void forExponentiationMI(ExponentiationMI that);

    /** Process an instance of SubscriptingMI. */
    public void forSubscriptingMI(SubscriptingMI that);

    /** Process an instance of Overloading. */
    public void forOverloading(Overloading that);

    /** Process an instance of NonterminalHeader. */
    public void forNonterminalHeader(NonterminalHeader that);

    /** Process an instance of NonterminalParameter. */
    public void forNonterminalParameter(NonterminalParameter that);

    /** Process an instance of SyntaxDef. */
    public void forSyntaxDef(SyntaxDef that);

    /** Process an instance of SuperSyntaxDef. */
    public void forSuperSyntaxDef(SuperSyntaxDef that);

    /** Process an instance of PreTransformerDef. */
    public void forPreTransformerDef(PreTransformerDef that);

    /** Process an instance of NamedTransformerDef. */
    public void forNamedTransformerDef(NamedTransformerDef that);

    /** Process an instance of UnparsedTransformer. */
    public void forUnparsedTransformer(UnparsedTransformer that);

    /** Process an instance of NodeTransformer. */
    public void forNodeTransformer(NodeTransformer that);

    /** Process an instance of CaseTransformer. */
    public void forCaseTransformer(CaseTransformer that);

    /** Process an instance of CaseTransformerClause. */
    public void forCaseTransformerClause(CaseTransformerClause that);

    /** Process an instance of PrefixedSymbol. */
    public void forPrefixedSymbol(PrefixedSymbol that);

    /** Process an instance of OptionalSymbol. */
    public void forOptionalSymbol(OptionalSymbol that);

    /** Process an instance of RepeatSymbol. */
    public void forRepeatSymbol(RepeatSymbol that);

    /** Process an instance of RepeatOneOrMoreSymbol. */
    public void forRepeatOneOrMoreSymbol(RepeatOneOrMoreSymbol that);

    /** Process an instance of NoWhitespaceSymbol. */
    public void forNoWhitespaceSymbol(NoWhitespaceSymbol that);

    /** Process an instance of GroupSymbol. */
    public void forGroupSymbol(GroupSymbol that);

    /** Process an instance of AnyCharacterSymbol. */
    public void forAnyCharacterSymbol(AnyCharacterSymbol that);

    /** Process an instance of WhitespaceSymbol. */
    public void forWhitespaceSymbol(WhitespaceSymbol that);

    /** Process an instance of TabSymbol. */
    public void forTabSymbol(TabSymbol that);

    /** Process an instance of FormfeedSymbol. */
    public void forFormfeedSymbol(FormfeedSymbol that);

    /** Process an instance of CarriageReturnSymbol. */
    public void forCarriageReturnSymbol(CarriageReturnSymbol that);

    /** Process an instance of BackspaceSymbol. */
    public void forBackspaceSymbol(BackspaceSymbol that);

    /** Process an instance of NewlineSymbol. */
    public void forNewlineSymbol(NewlineSymbol that);

    /** Process an instance of BreaklineSymbol. */
    public void forBreaklineSymbol(BreaklineSymbol that);

    /** Process an instance of ItemSymbol. */
    public void forItemSymbol(ItemSymbol that);

    /** Process an instance of NonterminalSymbol. */
    public void forNonterminalSymbol(NonterminalSymbol that);

    /** Process an instance of KeywordSymbol. */
    public void forKeywordSymbol(KeywordSymbol that);

    /** Process an instance of TokenSymbol. */
    public void forTokenSymbol(TokenSymbol that);

    /** Process an instance of NotPredicateSymbol. */
    public void forNotPredicateSymbol(NotPredicateSymbol that);

    /** Process an instance of AndPredicateSymbol. */
    public void forAndPredicateSymbol(AndPredicateSymbol that);

    /** Process an instance of CharacterClassSymbol. */
    public void forCharacterClassSymbol(CharacterClassSymbol that);

    /** Process an instance of CharSymbol. */
    public void forCharSymbol(CharSymbol that);

    /** Process an instance of CharacterInterval. */
    public void forCharacterInterval(CharacterInterval that);

    /** Process an instance of Link. */
    public void forLink(Link that);

    /** Process an instance of TraitTypeHeader. */
    public void forTraitTypeHeader(TraitTypeHeader that);

    /** Process an instance of FnHeader. */
    public void forFnHeader(FnHeader that);

    /** Process an instance of SpanInfo. */
    public void forSpanInfo(SpanInfo that);

    /** Process an instance of ExprInfo. */
    public void forExprInfo(ExprInfo that);

    /** Process an instance of TypeInfo. */
    public void forTypeInfo(TypeInfo that);

    /** Process an instance of MethodInfo. */
    public void forMethodInfo(MethodInfo that);

    /** Process an instance of CompoundAssignmentInfo. */
    public void forCompoundAssignmentInfo(CompoundAssignmentInfo that);

    /** Process an instance of Level. */
    public void forLevel(Level that);

    /** Process an instance of InFixity. */
    public void forInFixity(InFixity that);

    /** Process an instance of PreFixity. */
    public void forPreFixity(PreFixity that);

    /** Process an instance of PostFixity. */
    public void forPostFixity(PostFixity that);

    /** Process an instance of NoFixity. */
    public void forNoFixity(NoFixity that);

    /** Process an instance of MultiFixity. */
    public void forMultiFixity(MultiFixity that);

    /** Process an instance of EnclosingFixity. */
    public void forEnclosingFixity(EnclosingFixity that);

    /** Process an instance of BigFixity. */
    public void forBigFixity(BigFixity that);

    /** Process an instance of UnknownFixity. */
    public void forUnknownFixity(UnknownFixity that);

    /** Process an instance of KindType. */
    public void forKindType(KindType that);

    /** Process an instance of KindInt. */
    public void forKindInt(KindInt that);

    /** Process an instance of KindNat. */
    public void forKindNat(KindNat that);

    /** Process an instance of KindBool. */
    public void forKindBool(KindBool that);

    /** Process an instance of KindDim. */
    public void forKindDim(KindDim that);

    /** Process an instance of KindUnit. */
    public void forKindUnit(KindUnit that);

    /** Process an instance of KindOp. */
    public void forKindOp(KindOp that);

    /** Process an instance of _SyntaxTransformationAbstractNode. */
    public void for_SyntaxTransformationAbstractNode(_SyntaxTransformationAbstractNode that);

    /** Process an instance of _SyntaxTransformationCompilationUnit. */
    public void for_SyntaxTransformationCompilationUnit(_SyntaxTransformationCompilationUnit that);

    /** Process an instance of _SyntaxTransformationComponent. */
    public void for_SyntaxTransformationComponent(_SyntaxTransformationComponent that);

    /** Process an instance of _SyntaxTransformationApi. */
    public void for_SyntaxTransformationApi(_SyntaxTransformationApi that);

    /** Process an instance of _SyntaxTransformationImport. */
    public void for_SyntaxTransformationImport(_SyntaxTransformationImport that);

    /** Process an instance of _SyntaxTransformationImportedNames. */
    public void for_SyntaxTransformationImportedNames(_SyntaxTransformationImportedNames that);

    /** Process an instance of _SyntaxTransformationImportStar. */
    public void for_SyntaxTransformationImportStar(_SyntaxTransformationImportStar that);

    /** Process an instance of _SyntaxTransformationImportNames. */
    public void for_SyntaxTransformationImportNames(_SyntaxTransformationImportNames that);

    /** Process an instance of _SyntaxTransformationImportApi. */
    public void for_SyntaxTransformationImportApi(_SyntaxTransformationImportApi that);

    /** Process an instance of _SyntaxTransformationAliasedSimpleName. */
    public void for_SyntaxTransformationAliasedSimpleName(_SyntaxTransformationAliasedSimpleName that);

    /** Process an instance of _SyntaxTransformationAliasedAPIName. */
    public void for_SyntaxTransformationAliasedAPIName(_SyntaxTransformationAliasedAPIName that);

    /** Process an instance of _SyntaxTransformationDecl. */
    public void for_SyntaxTransformationDecl(_SyntaxTransformationDecl that);

    /** Process an instance of _SyntaxTransformationTraitObjectDecl. */
    public void for_SyntaxTransformationTraitObjectDecl(_SyntaxTransformationTraitObjectDecl that);

    /** Process an instance of _SyntaxTransformationTraitDecl. */
    public void for_SyntaxTransformationTraitDecl(_SyntaxTransformationTraitDecl that);

    /** Process an instance of _SyntaxTransformationObjectDecl. */
    public void for_SyntaxTransformationObjectDecl(_SyntaxTransformationObjectDecl that);

    /** Process an instance of _SyntaxTransformationVarDecl. */
    public void for_SyntaxTransformationVarDecl(_SyntaxTransformationVarDecl that);

    /** Process an instance of _SyntaxTransformationFnDecl. */
    public void for_SyntaxTransformationFnDecl(_SyntaxTransformationFnDecl that);

    /** Process an instance of _SyntaxTransformation_RewriteFnOverloadDecl. */
    public void for_SyntaxTransformation_RewriteFnOverloadDecl(_SyntaxTransformation_RewriteFnOverloadDecl that);

    /** Process an instance of _SyntaxTransformation_RewriteObjectExprDecl. */
    public void for_SyntaxTransformation_RewriteObjectExprDecl(_SyntaxTransformation_RewriteObjectExprDecl that);

    /** Process an instance of _SyntaxTransformation_RewriteFunctionalMethodDecl. */
    public void for_SyntaxTransformation_RewriteFunctionalMethodDecl(_SyntaxTransformation_RewriteFunctionalMethodDecl that);

    /** Process an instance of _SyntaxTransformationDimUnitDecl. */
    public void for_SyntaxTransformationDimUnitDecl(_SyntaxTransformationDimUnitDecl that);

    /** Process an instance of _SyntaxTransformationDimDecl. */
    public void for_SyntaxTransformationDimDecl(_SyntaxTransformationDimDecl that);

    /** Process an instance of _SyntaxTransformationUnitDecl. */
    public void for_SyntaxTransformationUnitDecl(_SyntaxTransformationUnitDecl that);

    /** Process an instance of _SyntaxTransformationTestDecl. */
    public void for_SyntaxTransformationTestDecl(_SyntaxTransformationTestDecl that);

    /** Process an instance of _SyntaxTransformationPropertyDecl. */
    public void for_SyntaxTransformationPropertyDecl(_SyntaxTransformationPropertyDecl that);

    /** Process an instance of _SyntaxTransformationTypeAlias. */
    public void for_SyntaxTransformationTypeAlias(_SyntaxTransformationTypeAlias that);

    /** Process an instance of _SyntaxTransformationGrammarDecl. */
    public void for_SyntaxTransformationGrammarDecl(_SyntaxTransformationGrammarDecl that);

    /** Process an instance of _SyntaxTransformationGrammarMemberDecl. */
    public void for_SyntaxTransformationGrammarMemberDecl(_SyntaxTransformationGrammarMemberDecl that);

    /** Process an instance of _SyntaxTransformationNonterminalDecl. */
    public void for_SyntaxTransformationNonterminalDecl(_SyntaxTransformationNonterminalDecl that);

    /** Process an instance of _SyntaxTransformationNonterminalDef. */
    public void for_SyntaxTransformationNonterminalDef(_SyntaxTransformationNonterminalDef that);

    /** Process an instance of _SyntaxTransformationNonterminalExtensionDef. */
    public void for_SyntaxTransformationNonterminalExtensionDef(_SyntaxTransformationNonterminalExtensionDef that);

    /** Process an instance of _SyntaxTransformationBinding. */
    public void for_SyntaxTransformationBinding(_SyntaxTransformationBinding that);

    /** Process an instance of _SyntaxTransformationLValue. */
    public void for_SyntaxTransformationLValue(_SyntaxTransformationLValue that);

    /** Process an instance of _SyntaxTransformationParam. */
    public void for_SyntaxTransformationParam(_SyntaxTransformationParam that);

    /** Process an instance of _SyntaxTransformationExpr. */
    public void for_SyntaxTransformationExpr(_SyntaxTransformationExpr that);

    /** Process an instance of _SyntaxTransformationDummyExpr. */
    public void for_SyntaxTransformationDummyExpr(_SyntaxTransformationDummyExpr that);

    /** Process an instance of _SyntaxTransformationTypeAnnotatedExpr. */
    public void for_SyntaxTransformationTypeAnnotatedExpr(_SyntaxTransformationTypeAnnotatedExpr that);

    /** Process an instance of _SyntaxTransformationAsExpr. */
    public void for_SyntaxTransformationAsExpr(_SyntaxTransformationAsExpr that);

    /** Process an instance of _SyntaxTransformationAsIfExpr. */
    public void for_SyntaxTransformationAsIfExpr(_SyntaxTransformationAsIfExpr that);

    /** Process an instance of _SyntaxTransformationAssignment. */
    public void for_SyntaxTransformationAssignment(_SyntaxTransformationAssignment that);

    /** Process an instance of _SyntaxTransformationBlock. */
    public void for_SyntaxTransformationBlock(_SyntaxTransformationBlock that);

    /** Process an instance of _SyntaxTransformationDo. */
    public void for_SyntaxTransformationDo(_SyntaxTransformationDo that);

    /** Process an instance of _SyntaxTransformationCaseExpr. */
    public void for_SyntaxTransformationCaseExpr(_SyntaxTransformationCaseExpr that);

    /** Process an instance of _SyntaxTransformationIf. */
    public void for_SyntaxTransformationIf(_SyntaxTransformationIf that);

    /** Process an instance of _SyntaxTransformationLabel. */
    public void for_SyntaxTransformationLabel(_SyntaxTransformationLabel that);

    /** Process an instance of _SyntaxTransformationAbstractObjectExpr. */
    public void for_SyntaxTransformationAbstractObjectExpr(_SyntaxTransformationAbstractObjectExpr that);

    /** Process an instance of _SyntaxTransformationObjectExpr. */
    public void for_SyntaxTransformationObjectExpr(_SyntaxTransformationObjectExpr that);

    /** Process an instance of _SyntaxTransformation_RewriteObjectExpr. */
    public void for_SyntaxTransformation_RewriteObjectExpr(_SyntaxTransformation_RewriteObjectExpr that);

    /** Process an instance of _SyntaxTransformationTry. */
    public void for_SyntaxTransformationTry(_SyntaxTransformationTry that);

    /** Process an instance of _SyntaxTransformationTupleExpr. */
    public void for_SyntaxTransformationTupleExpr(_SyntaxTransformationTupleExpr that);

    /** Process an instance of _SyntaxTransformationTypecase. */
    public void for_SyntaxTransformationTypecase(_SyntaxTransformationTypecase that);

    /** Process an instance of _SyntaxTransformationWhile. */
    public void for_SyntaxTransformationWhile(_SyntaxTransformationWhile that);

    /** Process an instance of _SyntaxTransformationFor. */
    public void for_SyntaxTransformationFor(_SyntaxTransformationFor that);

    /** Process an instance of _SyntaxTransformationBigOpApp. */
    public void for_SyntaxTransformationBigOpApp(_SyntaxTransformationBigOpApp that);

    /** Process an instance of _SyntaxTransformationAccumulator. */
    public void for_SyntaxTransformationAccumulator(_SyntaxTransformationAccumulator that);

    /** Process an instance of _SyntaxTransformationArrayComprehension. */
    public void for_SyntaxTransformationArrayComprehension(_SyntaxTransformationArrayComprehension that);

    /** Process an instance of _SyntaxTransformationAtomicExpr. */
    public void for_SyntaxTransformationAtomicExpr(_SyntaxTransformationAtomicExpr that);

    /** Process an instance of _SyntaxTransformationExit. */
    public void for_SyntaxTransformationExit(_SyntaxTransformationExit that);

    /** Process an instance of _SyntaxTransformationSpawn. */
    public void for_SyntaxTransformationSpawn(_SyntaxTransformationSpawn that);

    /** Process an instance of _SyntaxTransformationThrow. */
    public void for_SyntaxTransformationThrow(_SyntaxTransformationThrow that);

    /** Process an instance of _SyntaxTransformationTryAtomicExpr. */
    public void for_SyntaxTransformationTryAtomicExpr(_SyntaxTransformationTryAtomicExpr that);

    /** Process an instance of _SyntaxTransformationFnExpr. */
    public void for_SyntaxTransformationFnExpr(_SyntaxTransformationFnExpr that);

    /** Process an instance of _SyntaxTransformationLetExpr. */
    public void for_SyntaxTransformationLetExpr(_SyntaxTransformationLetExpr that);

    /** Process an instance of _SyntaxTransformationLetFn. */
    public void for_SyntaxTransformationLetFn(_SyntaxTransformationLetFn that);

    /** Process an instance of _SyntaxTransformationLocalVarDecl. */
    public void for_SyntaxTransformationLocalVarDecl(_SyntaxTransformationLocalVarDecl that);

    /** Process an instance of _SyntaxTransformationSimpleExpr. */
    public void for_SyntaxTransformationSimpleExpr(_SyntaxTransformationSimpleExpr that);

    /** Process an instance of _SyntaxTransformationSubscriptExpr. */
    public void for_SyntaxTransformationSubscriptExpr(_SyntaxTransformationSubscriptExpr that);

    /** Process an instance of _SyntaxTransformationPrimary. */
    public void for_SyntaxTransformationPrimary(_SyntaxTransformationPrimary that);

    /** Process an instance of _SyntaxTransformationLiteralExpr. */
    public void for_SyntaxTransformationLiteralExpr(_SyntaxTransformationLiteralExpr that);

    /** Process an instance of _SyntaxTransformationNumberLiteralExpr. */
    public void for_SyntaxTransformationNumberLiteralExpr(_SyntaxTransformationNumberLiteralExpr that);

    /** Process an instance of _SyntaxTransformationFloatLiteralExpr. */
    public void for_SyntaxTransformationFloatLiteralExpr(_SyntaxTransformationFloatLiteralExpr that);

    /** Process an instance of _SyntaxTransformationIntLiteralExpr. */
    public void for_SyntaxTransformationIntLiteralExpr(_SyntaxTransformationIntLiteralExpr that);

    /** Process an instance of _SyntaxTransformationCharLiteralExpr. */
    public void for_SyntaxTransformationCharLiteralExpr(_SyntaxTransformationCharLiteralExpr that);

    /** Process an instance of _SyntaxTransformationStringLiteralExpr. */
    public void for_SyntaxTransformationStringLiteralExpr(_SyntaxTransformationStringLiteralExpr that);

    /** Process an instance of _SyntaxTransformationVoidLiteralExpr. */
    public void for_SyntaxTransformationVoidLiteralExpr(_SyntaxTransformationVoidLiteralExpr that);

    /** Process an instance of _SyntaxTransformationBooleanLiteralExpr. */
    public void for_SyntaxTransformationBooleanLiteralExpr(_SyntaxTransformationBooleanLiteralExpr that);

    /** Process an instance of _SyntaxTransformationVarRef. */
    public void for_SyntaxTransformationVarRef(_SyntaxTransformationVarRef that);

    /** Process an instance of _SyntaxTransformationFieldRef. */
    public void for_SyntaxTransformationFieldRef(_SyntaxTransformationFieldRef that);

    /** Process an instance of _SyntaxTransformationFunctionalRef. */
    public void for_SyntaxTransformationFunctionalRef(_SyntaxTransformationFunctionalRef that);

    /** Process an instance of _SyntaxTransformationFnRef. */
    public void for_SyntaxTransformationFnRef(_SyntaxTransformationFnRef that);

    /** Process an instance of _SyntaxTransformationOpRef. */
    public void for_SyntaxTransformationOpRef(_SyntaxTransformationOpRef that);

    /** Process an instance of _SyntaxTransformation_RewriteFnRef. */
    public void for_SyntaxTransformation_RewriteFnRef(_SyntaxTransformation_RewriteFnRef that);

    /** Process an instance of _SyntaxTransformation_RewriteObjectExprRef. */
    public void for_SyntaxTransformation_RewriteObjectExprRef(_SyntaxTransformation_RewriteObjectExprRef that);

    /** Process an instance of _SyntaxTransformationJuxt. */
    public void for_SyntaxTransformationJuxt(_SyntaxTransformationJuxt that);

    /** Process an instance of _SyntaxTransformation_RewriteFnApp. */
    public void for_SyntaxTransformation_RewriteFnApp(_SyntaxTransformation_RewriteFnApp that);

    /** Process an instance of _SyntaxTransformationOpExpr. */
    public void for_SyntaxTransformationOpExpr(_SyntaxTransformationOpExpr that);

    /** Process an instance of _SyntaxTransformationAmbiguousMultifixOpExpr. */
    public void for_SyntaxTransformationAmbiguousMultifixOpExpr(_SyntaxTransformationAmbiguousMultifixOpExpr that);

    /** Process an instance of _SyntaxTransformationChainExpr. */
    public void for_SyntaxTransformationChainExpr(_SyntaxTransformationChainExpr that);

    /** Process an instance of _SyntaxTransformationCoercionInvocation. */
    public void for_SyntaxTransformationCoercionInvocation(_SyntaxTransformationCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationTraitCoercionInvocation. */
    public void for_SyntaxTransformationTraitCoercionInvocation(_SyntaxTransformationTraitCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationTupleCoercionInvocation. */
    public void for_SyntaxTransformationTupleCoercionInvocation(_SyntaxTransformationTupleCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationArrowCoercionInvocation. */
    public void for_SyntaxTransformationArrowCoercionInvocation(_SyntaxTransformationArrowCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationUnionCoercionInvocation. */
    public void for_SyntaxTransformationUnionCoercionInvocation(_SyntaxTransformationUnionCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationMethodInvocation. */
    public void for_SyntaxTransformationMethodInvocation(_SyntaxTransformationMethodInvocation that);

    /** Process an instance of _SyntaxTransformationMathPrimary. */
    public void for_SyntaxTransformationMathPrimary(_SyntaxTransformationMathPrimary that);

    /** Process an instance of _SyntaxTransformationArrayExpr. */
    public void for_SyntaxTransformationArrayExpr(_SyntaxTransformationArrayExpr that);

    /** Process an instance of _SyntaxTransformationArrayElement. */
    public void for_SyntaxTransformationArrayElement(_SyntaxTransformationArrayElement that);

    /** Process an instance of _SyntaxTransformationArrayElements. */
    public void for_SyntaxTransformationArrayElements(_SyntaxTransformationArrayElements that);

    /** Process an instance of _SyntaxTransformationType. */
    public void for_SyntaxTransformationType(_SyntaxTransformationType that);

    /** Process an instance of _SyntaxTransformationBaseType. */
    public void for_SyntaxTransformationBaseType(_SyntaxTransformationBaseType that);

    /** Process an instance of _SyntaxTransformationAnyType. */
    public void for_SyntaxTransformationAnyType(_SyntaxTransformationAnyType that);

    /** Process an instance of _SyntaxTransformationBottomType. */
    public void for_SyntaxTransformationBottomType(_SyntaxTransformationBottomType that);

    /** Process an instance of _SyntaxTransformationUnknownType. */
    public void for_SyntaxTransformationUnknownType(_SyntaxTransformationUnknownType that);

    /** Process an instance of _SyntaxTransformationSelfType. */
    public void for_SyntaxTransformationSelfType(_SyntaxTransformationSelfType that);

    /** Process an instance of _SyntaxTransformationTraitSelfType. */
    public void for_SyntaxTransformationTraitSelfType(_SyntaxTransformationTraitSelfType that);

    /** Process an instance of _SyntaxTransformationObjectExprType. */
    public void for_SyntaxTransformationObjectExprType(_SyntaxTransformationObjectExprType that);

    /** Process an instance of _SyntaxTransformationNamedType. */
    public void for_SyntaxTransformationNamedType(_SyntaxTransformationNamedType that);

    /** Process an instance of _SyntaxTransformation_InferenceVarType. */
    public void for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that);

    /** Process an instance of _SyntaxTransformationVarType. */
    public void for_SyntaxTransformationVarType(_SyntaxTransformationVarType that);

    /** Process an instance of _SyntaxTransformationTraitType. */
    public void for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that);

    /** Process an instance of _SyntaxTransformationAbbreviatedType. */
    public void for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that);

    /** Process an instance of _SyntaxTransformationArrayType. */
    public void for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that);

    /** Process an instance of _SyntaxTransformationMatrixType. */
    public void for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that);

    /** Process an instance of _SyntaxTransformationTaggedDimType. */
    public void for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that);

    /** Process an instance of _SyntaxTransformationTaggedUnitType. */
    public void for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that);

    /** Process an instance of _SyntaxTransformationTupleType. */
    public void for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that);

    /** Process an instance of _SyntaxTransformationArrowType. */
    public void for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that);

    /** Process an instance of _SyntaxTransformationBoundType. */
    public void for_SyntaxTransformationBoundType(_SyntaxTransformationBoundType that);

    /** Process an instance of _SyntaxTransformationIntersectionType. */
    public void for_SyntaxTransformationIntersectionType(_SyntaxTransformationIntersectionType that);

    /** Process an instance of _SyntaxTransformationUnionType. */
    public void for_SyntaxTransformationUnionType(_SyntaxTransformationUnionType that);

    /** Process an instance of _SyntaxTransformationFixedPointType. */
    public void for_SyntaxTransformationFixedPointType(_SyntaxTransformationFixedPointType that);

    /** Process an instance of _SyntaxTransformationLabelType. */
    public void for_SyntaxTransformationLabelType(_SyntaxTransformationLabelType that);

    /** Process an instance of _SyntaxTransformationDimExpr. */
    public void for_SyntaxTransformationDimExpr(_SyntaxTransformationDimExpr that);

    /** Process an instance of _SyntaxTransformationDimBase. */
    public void for_SyntaxTransformationDimBase(_SyntaxTransformationDimBase that);

    /** Process an instance of _SyntaxTransformationDimRef. */
    public void for_SyntaxTransformationDimRef(_SyntaxTransformationDimRef that);

    /** Process an instance of _SyntaxTransformationDimExponent. */
    public void for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that);

    /** Process an instance of _SyntaxTransformationDimUnaryOp. */
    public void for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that);

    /** Process an instance of _SyntaxTransformationDimBinaryOp. */
    public void for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that);

    /** Process an instance of _SyntaxTransformationPattern. */
    public void for_SyntaxTransformationPattern(_SyntaxTransformationPattern that);

    /** Process an instance of _SyntaxTransformationPatternArgs. */
    public void for_SyntaxTransformationPatternArgs(_SyntaxTransformationPatternArgs that);

    /** Process an instance of _SyntaxTransformationPatternBinding. */
    public void for_SyntaxTransformationPatternBinding(_SyntaxTransformationPatternBinding that);

    /** Process an instance of _SyntaxTransformationPlainPattern. */
    public void for_SyntaxTransformationPlainPattern(_SyntaxTransformationPlainPattern that);

    /** Process an instance of _SyntaxTransformationTypePattern. */
    public void for_SyntaxTransformationTypePattern(_SyntaxTransformationTypePattern that);

    /** Process an instance of _SyntaxTransformationNestedPattern. */
    public void for_SyntaxTransformationNestedPattern(_SyntaxTransformationNestedPattern that);

    /** Process an instance of _SyntaxTransformationStaticArg. */
    public void for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that);

    /** Process an instance of _SyntaxTransformationTypeArg. */
    public void for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that);

    /** Process an instance of _SyntaxTransformationIntArg. */
    public void for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that);

    /** Process an instance of _SyntaxTransformationBoolArg. */
    public void for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that);

    /** Process an instance of _SyntaxTransformationOpArg. */
    public void for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that);

    /** Process an instance of _SyntaxTransformationDimArg. */
    public void for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that);

    /** Process an instance of _SyntaxTransformationUnitArg. */
    public void for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that);

    /** Process an instance of _SyntaxTransformationStaticExpr. */
    public void for_SyntaxTransformationStaticExpr(_SyntaxTransformationStaticExpr that);

    /** Process an instance of _SyntaxTransformationIntExpr. */
    public void for_SyntaxTransformationIntExpr(_SyntaxTransformationIntExpr that);

    /** Process an instance of _SyntaxTransformationIntBase. */
    public void for_SyntaxTransformationIntBase(_SyntaxTransformationIntBase that);

    /** Process an instance of _SyntaxTransformationIntRef. */
    public void for_SyntaxTransformationIntRef(_SyntaxTransformationIntRef that);

    /** Process an instance of _SyntaxTransformationIntBinaryOp. */
    public void for_SyntaxTransformationIntBinaryOp(_SyntaxTransformationIntBinaryOp that);

    /** Process an instance of _SyntaxTransformationBoolExpr. */
    public void for_SyntaxTransformationBoolExpr(_SyntaxTransformationBoolExpr that);

    /** Process an instance of _SyntaxTransformationBoolBase. */
    public void for_SyntaxTransformationBoolBase(_SyntaxTransformationBoolBase that);

    /** Process an instance of _SyntaxTransformationBoolRef. */
    public void for_SyntaxTransformationBoolRef(_SyntaxTransformationBoolRef that);

    /** Process an instance of _SyntaxTransformationBoolConstraint. */
    public void for_SyntaxTransformationBoolConstraint(_SyntaxTransformationBoolConstraint that);

    /** Process an instance of _SyntaxTransformationBoolUnaryOp. */
    public void for_SyntaxTransformationBoolUnaryOp(_SyntaxTransformationBoolUnaryOp that);

    /** Process an instance of _SyntaxTransformationBoolBinaryOp. */
    public void for_SyntaxTransformationBoolBinaryOp(_SyntaxTransformationBoolBinaryOp that);

    /** Process an instance of _SyntaxTransformationUnitExpr. */
    public void for_SyntaxTransformationUnitExpr(_SyntaxTransformationUnitExpr that);

    /** Process an instance of _SyntaxTransformationUnitRef. */
    public void for_SyntaxTransformationUnitRef(_SyntaxTransformationUnitRef that);

    /** Process an instance of _SyntaxTransformationUnitBinaryOp. */
    public void for_SyntaxTransformationUnitBinaryOp(_SyntaxTransformationUnitBinaryOp that);

    /** Process an instance of _SyntaxTransformationEffect. */
    public void for_SyntaxTransformationEffect(_SyntaxTransformationEffect that);

    /** Process an instance of _SyntaxTransformationWhereClause. */
    public void for_SyntaxTransformationWhereClause(_SyntaxTransformationWhereClause that);

    /** Process an instance of _SyntaxTransformationWhereBinding. */
    public void for_SyntaxTransformationWhereBinding(_SyntaxTransformationWhereBinding that);

    /** Process an instance of _SyntaxTransformationWhereConstraint. */
    public void for_SyntaxTransformationWhereConstraint(_SyntaxTransformationWhereConstraint that);

    /** Process an instance of _SyntaxTransformationWhereExtends. */
    public void for_SyntaxTransformationWhereExtends(_SyntaxTransformationWhereExtends that);

    /** Process an instance of _SyntaxTransformationWhereTypeAlias. */
    public void for_SyntaxTransformationWhereTypeAlias(_SyntaxTransformationWhereTypeAlias that);

    /** Process an instance of _SyntaxTransformationWhereCoerces. */
    public void for_SyntaxTransformationWhereCoerces(_SyntaxTransformationWhereCoerces that);

    /** Process an instance of _SyntaxTransformationWhereEquals. */
    public void for_SyntaxTransformationWhereEquals(_SyntaxTransformationWhereEquals that);

    /** Process an instance of _SyntaxTransformationUnitConstraint. */
    public void for_SyntaxTransformationUnitConstraint(_SyntaxTransformationUnitConstraint that);

    /** Process an instance of _SyntaxTransformationIntConstraint. */
    public void for_SyntaxTransformationIntConstraint(_SyntaxTransformationIntConstraint that);

    /** Process an instance of _SyntaxTransformationBoolConstraintExpr. */
    public void for_SyntaxTransformationBoolConstraintExpr(_SyntaxTransformationBoolConstraintExpr that);

    /** Process an instance of _SyntaxTransformationContract. */
    public void for_SyntaxTransformationContract(_SyntaxTransformationContract that);

    /** Process an instance of _SyntaxTransformationEnsuresClause. */
    public void for_SyntaxTransformationEnsuresClause(_SyntaxTransformationEnsuresClause that);

    /** Process an instance of _SyntaxTransformationStaticParam. */
    public void for_SyntaxTransformationStaticParam(_SyntaxTransformationStaticParam that);

    /** Process an instance of _SyntaxTransformationName. */
    public void for_SyntaxTransformationName(_SyntaxTransformationName that);

    /** Process an instance of _SyntaxTransformationAPIName. */
    public void for_SyntaxTransformationAPIName(_SyntaxTransformationAPIName that);

    /** Process an instance of _SyntaxTransformationIdOrOpOrAnonymousName. */
    public void for_SyntaxTransformationIdOrOpOrAnonymousName(_SyntaxTransformationIdOrOpOrAnonymousName that);

    /** Process an instance of _SyntaxTransformationIdOrOp. */
    public void for_SyntaxTransformationIdOrOp(_SyntaxTransformationIdOrOp that);

    /** Process an instance of _SyntaxTransformationId. */
    public void for_SyntaxTransformationId(_SyntaxTransformationId that);

    /** Process an instance of _SyntaxTransformationOp. */
    public void for_SyntaxTransformationOp(_SyntaxTransformationOp that);

    /** Process an instance of _SyntaxTransformationNamedOp. */
    public void for_SyntaxTransformationNamedOp(_SyntaxTransformationNamedOp that);

    /** Process an instance of _SyntaxTransformation_InferenceVarOp. */
    public void for_SyntaxTransformation_InferenceVarOp(_SyntaxTransformation_InferenceVarOp that);

    /** Process an instance of _SyntaxTransformationAnonymousName. */
    public void for_SyntaxTransformationAnonymousName(_SyntaxTransformationAnonymousName that);

    /** Process an instance of _SyntaxTransformationAnonymousFnName. */
    public void for_SyntaxTransformationAnonymousFnName(_SyntaxTransformationAnonymousFnName that);

    /** Process an instance of _SyntaxTransformationConstructorFnName. */
    public void for_SyntaxTransformationConstructorFnName(_SyntaxTransformationConstructorFnName that);

    /** Process an instance of _SyntaxTransformationArrayComprehensionClause. */
    public void for_SyntaxTransformationArrayComprehensionClause(_SyntaxTransformationArrayComprehensionClause that);

    /** Process an instance of _SyntaxTransformationKeywordExpr. */
    public void for_SyntaxTransformationKeywordExpr(_SyntaxTransformationKeywordExpr that);

    /** Process an instance of _SyntaxTransformationCaseClause. */
    public void for_SyntaxTransformationCaseClause(_SyntaxTransformationCaseClause that);

    /** Process an instance of _SyntaxTransformationCatch. */
    public void for_SyntaxTransformationCatch(_SyntaxTransformationCatch that);

    /** Process an instance of _SyntaxTransformationCatchClause. */
    public void for_SyntaxTransformationCatchClause(_SyntaxTransformationCatchClause that);

    /** Process an instance of _SyntaxTransformationIfClause. */
    public void for_SyntaxTransformationIfClause(_SyntaxTransformationIfClause that);

    /** Process an instance of _SyntaxTransformationTypecaseClause. */
    public void for_SyntaxTransformationTypecaseClause(_SyntaxTransformationTypecaseClause that);

    /** Process an instance of _SyntaxTransformationExtentRange. */
    public void for_SyntaxTransformationExtentRange(_SyntaxTransformationExtentRange that);

    /** Process an instance of _SyntaxTransformationGeneratorClause. */
    public void for_SyntaxTransformationGeneratorClause(_SyntaxTransformationGeneratorClause that);

    /** Process an instance of _SyntaxTransformationKeywordType. */
    public void for_SyntaxTransformationKeywordType(_SyntaxTransformationKeywordType that);

    /** Process an instance of _SyntaxTransformationTraitTypeWhere. */
    public void for_SyntaxTransformationTraitTypeWhere(_SyntaxTransformationTraitTypeWhere that);

    /** Process an instance of _SyntaxTransformationIndices. */
    public void for_SyntaxTransformationIndices(_SyntaxTransformationIndices that);

    /** Process an instance of _SyntaxTransformationMathItem. */
    public void for_SyntaxTransformationMathItem(_SyntaxTransformationMathItem that);

    /** Process an instance of _SyntaxTransformationExprMI. */
    public void for_SyntaxTransformationExprMI(_SyntaxTransformationExprMI that);

    /** Process an instance of _SyntaxTransformationParenthesisDelimitedMI. */
    public void for_SyntaxTransformationParenthesisDelimitedMI(_SyntaxTransformationParenthesisDelimitedMI that);

    /** Process an instance of _SyntaxTransformationNonParenthesisDelimitedMI. */
    public void for_SyntaxTransformationNonParenthesisDelimitedMI(_SyntaxTransformationNonParenthesisDelimitedMI that);

    /** Process an instance of _SyntaxTransformationNonExprMI. */
    public void for_SyntaxTransformationNonExprMI(_SyntaxTransformationNonExprMI that);

    /** Process an instance of _SyntaxTransformationExponentiationMI. */
    public void for_SyntaxTransformationExponentiationMI(_SyntaxTransformationExponentiationMI that);

    /** Process an instance of _SyntaxTransformationSubscriptingMI. */
    public void for_SyntaxTransformationSubscriptingMI(_SyntaxTransformationSubscriptingMI that);

    /** Process an instance of _SyntaxTransformationOverloading. */
    public void for_SyntaxTransformationOverloading(_SyntaxTransformationOverloading that);

    /** Process an instance of _SyntaxTransformationNonterminalHeader. */
    public void for_SyntaxTransformationNonterminalHeader(_SyntaxTransformationNonterminalHeader that);

    /** Process an instance of _SyntaxTransformationNonterminalParameter. */
    public void for_SyntaxTransformationNonterminalParameter(_SyntaxTransformationNonterminalParameter that);

    /** Process an instance of _SyntaxTransformationSyntaxDecl. */
    public void for_SyntaxTransformationSyntaxDecl(_SyntaxTransformationSyntaxDecl that);

    /** Process an instance of _SyntaxTransformationSyntaxDef. */
    public void for_SyntaxTransformationSyntaxDef(_SyntaxTransformationSyntaxDef that);

    /** Process an instance of _SyntaxTransformationSuperSyntaxDef. */
    public void for_SyntaxTransformationSuperSyntaxDef(_SyntaxTransformationSuperSyntaxDef that);

    /** Process an instance of _SyntaxTransformationTransformerDecl. */
    public void for_SyntaxTransformationTransformerDecl(_SyntaxTransformationTransformerDecl that);

    /** Process an instance of _SyntaxTransformationPreTransformerDef. */
    public void for_SyntaxTransformationPreTransformerDef(_SyntaxTransformationPreTransformerDef that);

    /** Process an instance of _SyntaxTransformationNamedTransformerDef. */
    public void for_SyntaxTransformationNamedTransformerDef(_SyntaxTransformationNamedTransformerDef that);

    /** Process an instance of _SyntaxTransformationTransformer. */
    public void for_SyntaxTransformationTransformer(_SyntaxTransformationTransformer that);

    /** Process an instance of _SyntaxTransformationUnparsedTransformer. */
    public void for_SyntaxTransformationUnparsedTransformer(_SyntaxTransformationUnparsedTransformer that);

    /** Process an instance of _SyntaxTransformationNodeTransformer. */
    public void for_SyntaxTransformationNodeTransformer(_SyntaxTransformationNodeTransformer that);

    /** Process an instance of _SyntaxTransformationCaseTransformer. */
    public void for_SyntaxTransformationCaseTransformer(_SyntaxTransformationCaseTransformer that);

    /** Process an instance of _SyntaxTransformationCaseTransformerClause. */
    public void for_SyntaxTransformationCaseTransformerClause(_SyntaxTransformationCaseTransformerClause that);

    /** Process an instance of _SyntaxTransformationSyntaxSymbol. */
    public void for_SyntaxTransformationSyntaxSymbol(_SyntaxTransformationSyntaxSymbol that);

    /** Process an instance of _SyntaxTransformationPrefixedSymbol. */
    public void for_SyntaxTransformationPrefixedSymbol(_SyntaxTransformationPrefixedSymbol that);

    /** Process an instance of _SyntaxTransformationOptionalSymbol. */
    public void for_SyntaxTransformationOptionalSymbol(_SyntaxTransformationOptionalSymbol that);

    /** Process an instance of _SyntaxTransformationRepeatSymbol. */
    public void for_SyntaxTransformationRepeatSymbol(_SyntaxTransformationRepeatSymbol that);

    /** Process an instance of _SyntaxTransformationRepeatOneOrMoreSymbol. */
    public void for_SyntaxTransformationRepeatOneOrMoreSymbol(_SyntaxTransformationRepeatOneOrMoreSymbol that);

    /** Process an instance of _SyntaxTransformationNoWhitespaceSymbol. */
    public void for_SyntaxTransformationNoWhitespaceSymbol(_SyntaxTransformationNoWhitespaceSymbol that);

    /** Process an instance of _SyntaxTransformationGroupSymbol. */
    public void for_SyntaxTransformationGroupSymbol(_SyntaxTransformationGroupSymbol that);

    /** Process an instance of _SyntaxTransformationSpecialSymbol. */
    public void for_SyntaxTransformationSpecialSymbol(_SyntaxTransformationSpecialSymbol that);

    /** Process an instance of _SyntaxTransformationAnyCharacterSymbol. */
    public void for_SyntaxTransformationAnyCharacterSymbol(_SyntaxTransformationAnyCharacterSymbol that);

    /** Process an instance of _SyntaxTransformationWhitespaceSymbol. */
    public void for_SyntaxTransformationWhitespaceSymbol(_SyntaxTransformationWhitespaceSymbol that);

    /** Process an instance of _SyntaxTransformationTabSymbol. */
    public void for_SyntaxTransformationTabSymbol(_SyntaxTransformationTabSymbol that);

    /** Process an instance of _SyntaxTransformationFormfeedSymbol. */
    public void for_SyntaxTransformationFormfeedSymbol(_SyntaxTransformationFormfeedSymbol that);

    /** Process an instance of _SyntaxTransformationCarriageReturnSymbol. */
    public void for_SyntaxTransformationCarriageReturnSymbol(_SyntaxTransformationCarriageReturnSymbol that);

    /** Process an instance of _SyntaxTransformationBackspaceSymbol. */
    public void for_SyntaxTransformationBackspaceSymbol(_SyntaxTransformationBackspaceSymbol that);

    /** Process an instance of _SyntaxTransformationNewlineSymbol. */
    public void for_SyntaxTransformationNewlineSymbol(_SyntaxTransformationNewlineSymbol that);

    /** Process an instance of _SyntaxTransformationBreaklineSymbol. */
    public void for_SyntaxTransformationBreaklineSymbol(_SyntaxTransformationBreaklineSymbol that);

    /** Process an instance of _SyntaxTransformationItemSymbol. */
    public void for_SyntaxTransformationItemSymbol(_SyntaxTransformationItemSymbol that);

    /** Process an instance of _SyntaxTransformationNonterminalSymbol. */
    public void for_SyntaxTransformationNonterminalSymbol(_SyntaxTransformationNonterminalSymbol that);

    /** Process an instance of _SyntaxTransformationKeywordSymbol. */
    public void for_SyntaxTransformationKeywordSymbol(_SyntaxTransformationKeywordSymbol that);

    /** Process an instance of _SyntaxTransformationTokenSymbol. */
    public void for_SyntaxTransformationTokenSymbol(_SyntaxTransformationTokenSymbol that);

    /** Process an instance of _SyntaxTransformationNotPredicateSymbol. */
    public void for_SyntaxTransformationNotPredicateSymbol(_SyntaxTransformationNotPredicateSymbol that);

    /** Process an instance of _SyntaxTransformationAndPredicateSymbol. */
    public void for_SyntaxTransformationAndPredicateSymbol(_SyntaxTransformationAndPredicateSymbol that);

    /** Process an instance of _SyntaxTransformationCharacterClassSymbol. */
    public void for_SyntaxTransformationCharacterClassSymbol(_SyntaxTransformationCharacterClassSymbol that);

    /** Process an instance of _SyntaxTransformationCharacterSymbol. */
    public void for_SyntaxTransformationCharacterSymbol(_SyntaxTransformationCharacterSymbol that);

    /** Process an instance of _SyntaxTransformationCharSymbol. */
    public void for_SyntaxTransformationCharSymbol(_SyntaxTransformationCharSymbol that);

    /** Process an instance of _SyntaxTransformationCharacterInterval. */
    public void for_SyntaxTransformationCharacterInterval(_SyntaxTransformationCharacterInterval that);

    /** Process an instance of _SyntaxTransformationLink. */
    public void for_SyntaxTransformationLink(_SyntaxTransformationLink that);

    /** Process an instance of _EllipsesAbstractNode. */
    public void for_EllipsesAbstractNode(_EllipsesAbstractNode that);

    /** Process an instance of _EllipsesCompilationUnit. */
    public void for_EllipsesCompilationUnit(_EllipsesCompilationUnit that);

    /** Process an instance of _EllipsesComponent. */
    public void for_EllipsesComponent(_EllipsesComponent that);

    /** Process an instance of _EllipsesApi. */
    public void for_EllipsesApi(_EllipsesApi that);

    /** Process an instance of _EllipsesImport. */
    public void for_EllipsesImport(_EllipsesImport that);

    /** Process an instance of _EllipsesImportedNames. */
    public void for_EllipsesImportedNames(_EllipsesImportedNames that);

    /** Process an instance of _EllipsesImportStar. */
    public void for_EllipsesImportStar(_EllipsesImportStar that);

    /** Process an instance of _EllipsesImportNames. */
    public void for_EllipsesImportNames(_EllipsesImportNames that);

    /** Process an instance of _EllipsesImportApi. */
    public void for_EllipsesImportApi(_EllipsesImportApi that);

    /** Process an instance of _EllipsesAliasedSimpleName. */
    public void for_EllipsesAliasedSimpleName(_EllipsesAliasedSimpleName that);

    /** Process an instance of _EllipsesAliasedAPIName. */
    public void for_EllipsesAliasedAPIName(_EllipsesAliasedAPIName that);

    /** Process an instance of _EllipsesDecl. */
    public void for_EllipsesDecl(_EllipsesDecl that);

    /** Process an instance of _EllipsesTraitObjectDecl. */
    public void for_EllipsesTraitObjectDecl(_EllipsesTraitObjectDecl that);

    /** Process an instance of _EllipsesTraitDecl. */
    public void for_EllipsesTraitDecl(_EllipsesTraitDecl that);

    /** Process an instance of _EllipsesObjectDecl. */
    public void for_EllipsesObjectDecl(_EllipsesObjectDecl that);

    /** Process an instance of _EllipsesVarDecl. */
    public void for_EllipsesVarDecl(_EllipsesVarDecl that);

    /** Process an instance of _EllipsesFnDecl. */
    public void for_EllipsesFnDecl(_EllipsesFnDecl that);

    /** Process an instance of _Ellipses_RewriteFnOverloadDecl. */
    public void for_Ellipses_RewriteFnOverloadDecl(_Ellipses_RewriteFnOverloadDecl that);

    /** Process an instance of _Ellipses_RewriteObjectExprDecl. */
    public void for_Ellipses_RewriteObjectExprDecl(_Ellipses_RewriteObjectExprDecl that);

    /** Process an instance of _Ellipses_RewriteFunctionalMethodDecl. */
    public void for_Ellipses_RewriteFunctionalMethodDecl(_Ellipses_RewriteFunctionalMethodDecl that);

    /** Process an instance of _EllipsesDimUnitDecl. */
    public void for_EllipsesDimUnitDecl(_EllipsesDimUnitDecl that);

    /** Process an instance of _EllipsesDimDecl. */
    public void for_EllipsesDimDecl(_EllipsesDimDecl that);

    /** Process an instance of _EllipsesUnitDecl. */
    public void for_EllipsesUnitDecl(_EllipsesUnitDecl that);

    /** Process an instance of _EllipsesTestDecl. */
    public void for_EllipsesTestDecl(_EllipsesTestDecl that);

    /** Process an instance of _EllipsesPropertyDecl. */
    public void for_EllipsesPropertyDecl(_EllipsesPropertyDecl that);

    /** Process an instance of _EllipsesTypeAlias. */
    public void for_EllipsesTypeAlias(_EllipsesTypeAlias that);

    /** Process an instance of _EllipsesGrammarDecl. */
    public void for_EllipsesGrammarDecl(_EllipsesGrammarDecl that);

    /** Process an instance of _EllipsesGrammarMemberDecl. */
    public void for_EllipsesGrammarMemberDecl(_EllipsesGrammarMemberDecl that);

    /** Process an instance of _EllipsesNonterminalDecl. */
    public void for_EllipsesNonterminalDecl(_EllipsesNonterminalDecl that);

    /** Process an instance of _EllipsesNonterminalDef. */
    public void for_EllipsesNonterminalDef(_EllipsesNonterminalDef that);

    /** Process an instance of _EllipsesNonterminalExtensionDef. */
    public void for_EllipsesNonterminalExtensionDef(_EllipsesNonterminalExtensionDef that);

    /** Process an instance of _EllipsesBinding. */
    public void for_EllipsesBinding(_EllipsesBinding that);

    /** Process an instance of _EllipsesLValue. */
    public void for_EllipsesLValue(_EllipsesLValue that);

    /** Process an instance of _EllipsesParam. */
    public void for_EllipsesParam(_EllipsesParam that);

    /** Process an instance of _EllipsesExpr. */
    public void for_EllipsesExpr(_EllipsesExpr that);

    /** Process an instance of _EllipsesDummyExpr. */
    public void for_EllipsesDummyExpr(_EllipsesDummyExpr that);

    /** Process an instance of _EllipsesTypeAnnotatedExpr. */
    public void for_EllipsesTypeAnnotatedExpr(_EllipsesTypeAnnotatedExpr that);

    /** Process an instance of _EllipsesAsExpr. */
    public void for_EllipsesAsExpr(_EllipsesAsExpr that);

    /** Process an instance of _EllipsesAsIfExpr. */
    public void for_EllipsesAsIfExpr(_EllipsesAsIfExpr that);

    /** Process an instance of _EllipsesAssignment. */
    public void for_EllipsesAssignment(_EllipsesAssignment that);

    /** Process an instance of _EllipsesBlock. */
    public void for_EllipsesBlock(_EllipsesBlock that);

    /** Process an instance of _EllipsesDo. */
    public void for_EllipsesDo(_EllipsesDo that);

    /** Process an instance of _EllipsesCaseExpr. */
    public void for_EllipsesCaseExpr(_EllipsesCaseExpr that);

    /** Process an instance of _EllipsesIf. */
    public void for_EllipsesIf(_EllipsesIf that);

    /** Process an instance of _EllipsesLabel. */
    public void for_EllipsesLabel(_EllipsesLabel that);

    /** Process an instance of _EllipsesAbstractObjectExpr. */
    public void for_EllipsesAbstractObjectExpr(_EllipsesAbstractObjectExpr that);

    /** Process an instance of _EllipsesObjectExpr. */
    public void for_EllipsesObjectExpr(_EllipsesObjectExpr that);

    /** Process an instance of _Ellipses_RewriteObjectExpr. */
    public void for_Ellipses_RewriteObjectExpr(_Ellipses_RewriteObjectExpr that);

    /** Process an instance of _EllipsesTry. */
    public void for_EllipsesTry(_EllipsesTry that);

    /** Process an instance of _EllipsesTupleExpr. */
    public void for_EllipsesTupleExpr(_EllipsesTupleExpr that);

    /** Process an instance of _EllipsesTypecase. */
    public void for_EllipsesTypecase(_EllipsesTypecase that);

    /** Process an instance of _EllipsesWhile. */
    public void for_EllipsesWhile(_EllipsesWhile that);

    /** Process an instance of _EllipsesFor. */
    public void for_EllipsesFor(_EllipsesFor that);

    /** Process an instance of _EllipsesBigOpApp. */
    public void for_EllipsesBigOpApp(_EllipsesBigOpApp that);

    /** Process an instance of _EllipsesAccumulator. */
    public void for_EllipsesAccumulator(_EllipsesAccumulator that);

    /** Process an instance of _EllipsesArrayComprehension. */
    public void for_EllipsesArrayComprehension(_EllipsesArrayComprehension that);

    /** Process an instance of _EllipsesAtomicExpr. */
    public void for_EllipsesAtomicExpr(_EllipsesAtomicExpr that);

    /** Process an instance of _EllipsesExit. */
    public void for_EllipsesExit(_EllipsesExit that);

    /** Process an instance of _EllipsesSpawn. */
    public void for_EllipsesSpawn(_EllipsesSpawn that);

    /** Process an instance of _EllipsesThrow. */
    public void for_EllipsesThrow(_EllipsesThrow that);

    /** Process an instance of _EllipsesTryAtomicExpr. */
    public void for_EllipsesTryAtomicExpr(_EllipsesTryAtomicExpr that);

    /** Process an instance of _EllipsesFnExpr. */
    public void for_EllipsesFnExpr(_EllipsesFnExpr that);

    /** Process an instance of _EllipsesLetExpr. */
    public void for_EllipsesLetExpr(_EllipsesLetExpr that);

    /** Process an instance of _EllipsesLetFn. */
    public void for_EllipsesLetFn(_EllipsesLetFn that);

    /** Process an instance of _EllipsesLocalVarDecl. */
    public void for_EllipsesLocalVarDecl(_EllipsesLocalVarDecl that);

    /** Process an instance of _EllipsesSimpleExpr. */
    public void for_EllipsesSimpleExpr(_EllipsesSimpleExpr that);

    /** Process an instance of _EllipsesSubscriptExpr. */
    public void for_EllipsesSubscriptExpr(_EllipsesSubscriptExpr that);

    /** Process an instance of _EllipsesPrimary. */
    public void for_EllipsesPrimary(_EllipsesPrimary that);

    /** Process an instance of _EllipsesLiteralExpr. */
    public void for_EllipsesLiteralExpr(_EllipsesLiteralExpr that);

    /** Process an instance of _EllipsesNumberLiteralExpr. */
    public void for_EllipsesNumberLiteralExpr(_EllipsesNumberLiteralExpr that);

    /** Process an instance of _EllipsesFloatLiteralExpr. */
    public void for_EllipsesFloatLiteralExpr(_EllipsesFloatLiteralExpr that);

    /** Process an instance of _EllipsesIntLiteralExpr. */
    public void for_EllipsesIntLiteralExpr(_EllipsesIntLiteralExpr that);

    /** Process an instance of _EllipsesCharLiteralExpr. */
    public void for_EllipsesCharLiteralExpr(_EllipsesCharLiteralExpr that);

    /** Process an instance of _EllipsesStringLiteralExpr. */
    public void for_EllipsesStringLiteralExpr(_EllipsesStringLiteralExpr that);

    /** Process an instance of _EllipsesVoidLiteralExpr. */
    public void for_EllipsesVoidLiteralExpr(_EllipsesVoidLiteralExpr that);

    /** Process an instance of _EllipsesBooleanLiteralExpr. */
    public void for_EllipsesBooleanLiteralExpr(_EllipsesBooleanLiteralExpr that);

    /** Process an instance of _EllipsesVarRef. */
    public void for_EllipsesVarRef(_EllipsesVarRef that);

    /** Process an instance of _EllipsesFieldRef. */
    public void for_EllipsesFieldRef(_EllipsesFieldRef that);

    /** Process an instance of _EllipsesFunctionalRef. */
    public void for_EllipsesFunctionalRef(_EllipsesFunctionalRef that);

    /** Process an instance of _EllipsesFnRef. */
    public void for_EllipsesFnRef(_EllipsesFnRef that);

    /** Process an instance of _EllipsesOpRef. */
    public void for_EllipsesOpRef(_EllipsesOpRef that);

    /** Process an instance of _Ellipses_RewriteFnRef. */
    public void for_Ellipses_RewriteFnRef(_Ellipses_RewriteFnRef that);

    /** Process an instance of _Ellipses_RewriteObjectExprRef. */
    public void for_Ellipses_RewriteObjectExprRef(_Ellipses_RewriteObjectExprRef that);

    /** Process an instance of _EllipsesJuxt. */
    public void for_EllipsesJuxt(_EllipsesJuxt that);

    /** Process an instance of _Ellipses_RewriteFnApp. */
    public void for_Ellipses_RewriteFnApp(_Ellipses_RewriteFnApp that);

    /** Process an instance of _EllipsesOpExpr. */
    public void for_EllipsesOpExpr(_EllipsesOpExpr that);

    /** Process an instance of _EllipsesAmbiguousMultifixOpExpr. */
    public void for_EllipsesAmbiguousMultifixOpExpr(_EllipsesAmbiguousMultifixOpExpr that);

    /** Process an instance of _EllipsesChainExpr. */
    public void for_EllipsesChainExpr(_EllipsesChainExpr that);

    /** Process an instance of _EllipsesCoercionInvocation. */
    public void for_EllipsesCoercionInvocation(_EllipsesCoercionInvocation that);

    /** Process an instance of _EllipsesTraitCoercionInvocation. */
    public void for_EllipsesTraitCoercionInvocation(_EllipsesTraitCoercionInvocation that);

    /** Process an instance of _EllipsesTupleCoercionInvocation. */
    public void for_EllipsesTupleCoercionInvocation(_EllipsesTupleCoercionInvocation that);

    /** Process an instance of _EllipsesArrowCoercionInvocation. */
    public void for_EllipsesArrowCoercionInvocation(_EllipsesArrowCoercionInvocation that);

    /** Process an instance of _EllipsesUnionCoercionInvocation. */
    public void for_EllipsesUnionCoercionInvocation(_EllipsesUnionCoercionInvocation that);

    /** Process an instance of _EllipsesMethodInvocation. */
    public void for_EllipsesMethodInvocation(_EllipsesMethodInvocation that);

    /** Process an instance of _EllipsesMathPrimary. */
    public void for_EllipsesMathPrimary(_EllipsesMathPrimary that);

    /** Process an instance of _EllipsesArrayExpr. */
    public void for_EllipsesArrayExpr(_EllipsesArrayExpr that);

    /** Process an instance of _EllipsesArrayElement. */
    public void for_EllipsesArrayElement(_EllipsesArrayElement that);

    /** Process an instance of _EllipsesArrayElements. */
    public void for_EllipsesArrayElements(_EllipsesArrayElements that);

    /** Process an instance of _EllipsesType. */
    public void for_EllipsesType(_EllipsesType that);

    /** Process an instance of _EllipsesBaseType. */
    public void for_EllipsesBaseType(_EllipsesBaseType that);

    /** Process an instance of _EllipsesAnyType. */
    public void for_EllipsesAnyType(_EllipsesAnyType that);

    /** Process an instance of _EllipsesBottomType. */
    public void for_EllipsesBottomType(_EllipsesBottomType that);

    /** Process an instance of _EllipsesUnknownType. */
    public void for_EllipsesUnknownType(_EllipsesUnknownType that);

    /** Process an instance of _EllipsesSelfType. */
    public void for_EllipsesSelfType(_EllipsesSelfType that);

    /** Process an instance of _EllipsesTraitSelfType. */
    public void for_EllipsesTraitSelfType(_EllipsesTraitSelfType that);

    /** Process an instance of _EllipsesObjectExprType. */
    public void for_EllipsesObjectExprType(_EllipsesObjectExprType that);

    /** Process an instance of _EllipsesNamedType. */
    public void for_EllipsesNamedType(_EllipsesNamedType that);

    /** Process an instance of _Ellipses_InferenceVarType. */
    public void for_Ellipses_InferenceVarType(_Ellipses_InferenceVarType that);

    /** Process an instance of _EllipsesVarType. */
    public void for_EllipsesVarType(_EllipsesVarType that);

    /** Process an instance of _EllipsesTraitType. */
    public void for_EllipsesTraitType(_EllipsesTraitType that);

    /** Process an instance of _EllipsesAbbreviatedType. */
    public void for_EllipsesAbbreviatedType(_EllipsesAbbreviatedType that);

    /** Process an instance of _EllipsesArrayType. */
    public void for_EllipsesArrayType(_EllipsesArrayType that);

    /** Process an instance of _EllipsesMatrixType. */
    public void for_EllipsesMatrixType(_EllipsesMatrixType that);

    /** Process an instance of _EllipsesTaggedDimType. */
    public void for_EllipsesTaggedDimType(_EllipsesTaggedDimType that);

    /** Process an instance of _EllipsesTaggedUnitType. */
    public void for_EllipsesTaggedUnitType(_EllipsesTaggedUnitType that);

    /** Process an instance of _EllipsesTupleType. */
    public void for_EllipsesTupleType(_EllipsesTupleType that);

    /** Process an instance of _EllipsesArrowType. */
    public void for_EllipsesArrowType(_EllipsesArrowType that);

    /** Process an instance of _EllipsesBoundType. */
    public void for_EllipsesBoundType(_EllipsesBoundType that);

    /** Process an instance of _EllipsesIntersectionType. */
    public void for_EllipsesIntersectionType(_EllipsesIntersectionType that);

    /** Process an instance of _EllipsesUnionType. */
    public void for_EllipsesUnionType(_EllipsesUnionType that);

    /** Process an instance of _EllipsesFixedPointType. */
    public void for_EllipsesFixedPointType(_EllipsesFixedPointType that);

    /** Process an instance of _EllipsesLabelType. */
    public void for_EllipsesLabelType(_EllipsesLabelType that);

    /** Process an instance of _EllipsesDimExpr. */
    public void for_EllipsesDimExpr(_EllipsesDimExpr that);

    /** Process an instance of _EllipsesDimBase. */
    public void for_EllipsesDimBase(_EllipsesDimBase that);

    /** Process an instance of _EllipsesDimRef. */
    public void for_EllipsesDimRef(_EllipsesDimRef that);

    /** Process an instance of _EllipsesDimExponent. */
    public void for_EllipsesDimExponent(_EllipsesDimExponent that);

    /** Process an instance of _EllipsesDimUnaryOp. */
    public void for_EllipsesDimUnaryOp(_EllipsesDimUnaryOp that);

    /** Process an instance of _EllipsesDimBinaryOp. */
    public void for_EllipsesDimBinaryOp(_EllipsesDimBinaryOp that);

    /** Process an instance of _EllipsesPattern. */
    public void for_EllipsesPattern(_EllipsesPattern that);

    /** Process an instance of _EllipsesPatternArgs. */
    public void for_EllipsesPatternArgs(_EllipsesPatternArgs that);

    /** Process an instance of _EllipsesPatternBinding. */
    public void for_EllipsesPatternBinding(_EllipsesPatternBinding that);

    /** Process an instance of _EllipsesPlainPattern. */
    public void for_EllipsesPlainPattern(_EllipsesPlainPattern that);

    /** Process an instance of _EllipsesTypePattern. */
    public void for_EllipsesTypePattern(_EllipsesTypePattern that);

    /** Process an instance of _EllipsesNestedPattern. */
    public void for_EllipsesNestedPattern(_EllipsesNestedPattern that);

    /** Process an instance of _EllipsesStaticArg. */
    public void for_EllipsesStaticArg(_EllipsesStaticArg that);

    /** Process an instance of _EllipsesTypeArg. */
    public void for_EllipsesTypeArg(_EllipsesTypeArg that);

    /** Process an instance of _EllipsesIntArg. */
    public void for_EllipsesIntArg(_EllipsesIntArg that);

    /** Process an instance of _EllipsesBoolArg. */
    public void for_EllipsesBoolArg(_EllipsesBoolArg that);

    /** Process an instance of _EllipsesOpArg. */
    public void for_EllipsesOpArg(_EllipsesOpArg that);

    /** Process an instance of _EllipsesDimArg. */
    public void for_EllipsesDimArg(_EllipsesDimArg that);

    /** Process an instance of _EllipsesUnitArg. */
    public void for_EllipsesUnitArg(_EllipsesUnitArg that);

    /** Process an instance of _EllipsesStaticExpr. */
    public void for_EllipsesStaticExpr(_EllipsesStaticExpr that);

    /** Process an instance of _EllipsesIntExpr. */
    public void for_EllipsesIntExpr(_EllipsesIntExpr that);

    /** Process an instance of _EllipsesIntBase. */
    public void for_EllipsesIntBase(_EllipsesIntBase that);

    /** Process an instance of _EllipsesIntRef. */
    public void for_EllipsesIntRef(_EllipsesIntRef that);

    /** Process an instance of _EllipsesIntBinaryOp. */
    public void for_EllipsesIntBinaryOp(_EllipsesIntBinaryOp that);

    /** Process an instance of _EllipsesBoolExpr. */
    public void for_EllipsesBoolExpr(_EllipsesBoolExpr that);

    /** Process an instance of _EllipsesBoolBase. */
    public void for_EllipsesBoolBase(_EllipsesBoolBase that);

    /** Process an instance of _EllipsesBoolRef. */
    public void for_EllipsesBoolRef(_EllipsesBoolRef that);

    /** Process an instance of _EllipsesBoolConstraint. */
    public void for_EllipsesBoolConstraint(_EllipsesBoolConstraint that);

    /** Process an instance of _EllipsesBoolUnaryOp. */
    public void for_EllipsesBoolUnaryOp(_EllipsesBoolUnaryOp that);

    /** Process an instance of _EllipsesBoolBinaryOp. */
    public void for_EllipsesBoolBinaryOp(_EllipsesBoolBinaryOp that);

    /** Process an instance of _EllipsesUnitExpr. */
    public void for_EllipsesUnitExpr(_EllipsesUnitExpr that);

    /** Process an instance of _EllipsesUnitRef. */
    public void for_EllipsesUnitRef(_EllipsesUnitRef that);

    /** Process an instance of _EllipsesUnitBinaryOp. */
    public void for_EllipsesUnitBinaryOp(_EllipsesUnitBinaryOp that);

    /** Process an instance of _EllipsesEffect. */
    public void for_EllipsesEffect(_EllipsesEffect that);

    /** Process an instance of _EllipsesWhereClause. */
    public void for_EllipsesWhereClause(_EllipsesWhereClause that);

    /** Process an instance of _EllipsesWhereBinding. */
    public void for_EllipsesWhereBinding(_EllipsesWhereBinding that);

    /** Process an instance of _EllipsesWhereConstraint. */
    public void for_EllipsesWhereConstraint(_EllipsesWhereConstraint that);

    /** Process an instance of _EllipsesWhereExtends. */
    public void for_EllipsesWhereExtends(_EllipsesWhereExtends that);

    /** Process an instance of _EllipsesWhereTypeAlias. */
    public void for_EllipsesWhereTypeAlias(_EllipsesWhereTypeAlias that);

    /** Process an instance of _EllipsesWhereCoerces. */
    public void for_EllipsesWhereCoerces(_EllipsesWhereCoerces that);

    /** Process an instance of _EllipsesWhereEquals. */
    public void for_EllipsesWhereEquals(_EllipsesWhereEquals that);

    /** Process an instance of _EllipsesUnitConstraint. */
    public void for_EllipsesUnitConstraint(_EllipsesUnitConstraint that);

    /** Process an instance of _EllipsesIntConstraint. */
    public void for_EllipsesIntConstraint(_EllipsesIntConstraint that);

    /** Process an instance of _EllipsesBoolConstraintExpr. */
    public void for_EllipsesBoolConstraintExpr(_EllipsesBoolConstraintExpr that);

    /** Process an instance of _EllipsesContract. */
    public void for_EllipsesContract(_EllipsesContract that);

    /** Process an instance of _EllipsesEnsuresClause. */
    public void for_EllipsesEnsuresClause(_EllipsesEnsuresClause that);

    /** Process an instance of _EllipsesStaticParam. */
    public void for_EllipsesStaticParam(_EllipsesStaticParam that);

    /** Process an instance of _EllipsesName. */
    public void for_EllipsesName(_EllipsesName that);

    /** Process an instance of _EllipsesAPIName. */
    public void for_EllipsesAPIName(_EllipsesAPIName that);

    /** Process an instance of _EllipsesIdOrOpOrAnonymousName. */
    public void for_EllipsesIdOrOpOrAnonymousName(_EllipsesIdOrOpOrAnonymousName that);

    /** Process an instance of _EllipsesIdOrOp. */
    public void for_EllipsesIdOrOp(_EllipsesIdOrOp that);

    /** Process an instance of _EllipsesId. */
    public void for_EllipsesId(_EllipsesId that);

    /** Process an instance of _EllipsesOp. */
    public void for_EllipsesOp(_EllipsesOp that);

    /** Process an instance of _EllipsesNamedOp. */
    public void for_EllipsesNamedOp(_EllipsesNamedOp that);

    /** Process an instance of _Ellipses_InferenceVarOp. */
    public void for_Ellipses_InferenceVarOp(_Ellipses_InferenceVarOp that);

    /** Process an instance of _EllipsesAnonymousName. */
    public void for_EllipsesAnonymousName(_EllipsesAnonymousName that);

    /** Process an instance of _EllipsesAnonymousFnName. */
    public void for_EllipsesAnonymousFnName(_EllipsesAnonymousFnName that);

    /** Process an instance of _EllipsesConstructorFnName. */
    public void for_EllipsesConstructorFnName(_EllipsesConstructorFnName that);

    /** Process an instance of _EllipsesArrayComprehensionClause. */
    public void for_EllipsesArrayComprehensionClause(_EllipsesArrayComprehensionClause that);

    /** Process an instance of _EllipsesKeywordExpr. */
    public void for_EllipsesKeywordExpr(_EllipsesKeywordExpr that);

    /** Process an instance of _EllipsesCaseClause. */
    public void for_EllipsesCaseClause(_EllipsesCaseClause that);

    /** Process an instance of _EllipsesCatch. */
    public void for_EllipsesCatch(_EllipsesCatch that);

    /** Process an instance of _EllipsesCatchClause. */
    public void for_EllipsesCatchClause(_EllipsesCatchClause that);

    /** Process an instance of _EllipsesIfClause. */
    public void for_EllipsesIfClause(_EllipsesIfClause that);

    /** Process an instance of _EllipsesTypecaseClause. */
    public void for_EllipsesTypecaseClause(_EllipsesTypecaseClause that);

    /** Process an instance of _EllipsesExtentRange. */
    public void for_EllipsesExtentRange(_EllipsesExtentRange that);

    /** Process an instance of _EllipsesGeneratorClause. */
    public void for_EllipsesGeneratorClause(_EllipsesGeneratorClause that);

    /** Process an instance of _EllipsesKeywordType. */
    public void for_EllipsesKeywordType(_EllipsesKeywordType that);

    /** Process an instance of _EllipsesTraitTypeWhere. */
    public void for_EllipsesTraitTypeWhere(_EllipsesTraitTypeWhere that);

    /** Process an instance of _EllipsesIndices. */
    public void for_EllipsesIndices(_EllipsesIndices that);

    /** Process an instance of _EllipsesMathItem. */
    public void for_EllipsesMathItem(_EllipsesMathItem that);

    /** Process an instance of _EllipsesExprMI. */
    public void for_EllipsesExprMI(_EllipsesExprMI that);

    /** Process an instance of _EllipsesParenthesisDelimitedMI. */
    public void for_EllipsesParenthesisDelimitedMI(_EllipsesParenthesisDelimitedMI that);

    /** Process an instance of _EllipsesNonParenthesisDelimitedMI. */
    public void for_EllipsesNonParenthesisDelimitedMI(_EllipsesNonParenthesisDelimitedMI that);

    /** Process an instance of _EllipsesNonExprMI. */
    public void for_EllipsesNonExprMI(_EllipsesNonExprMI that);

    /** Process an instance of _EllipsesExponentiationMI. */
    public void for_EllipsesExponentiationMI(_EllipsesExponentiationMI that);

    /** Process an instance of _EllipsesSubscriptingMI. */
    public void for_EllipsesSubscriptingMI(_EllipsesSubscriptingMI that);

    /** Process an instance of _EllipsesOverloading. */
    public void for_EllipsesOverloading(_EllipsesOverloading that);

    /** Process an instance of _EllipsesNonterminalHeader. */
    public void for_EllipsesNonterminalHeader(_EllipsesNonterminalHeader that);

    /** Process an instance of _EllipsesNonterminalParameter. */
    public void for_EllipsesNonterminalParameter(_EllipsesNonterminalParameter that);

    /** Process an instance of _EllipsesSyntaxDecl. */
    public void for_EllipsesSyntaxDecl(_EllipsesSyntaxDecl that);

    /** Process an instance of _EllipsesSyntaxDef. */
    public void for_EllipsesSyntaxDef(_EllipsesSyntaxDef that);

    /** Process an instance of _EllipsesSuperSyntaxDef. */
    public void for_EllipsesSuperSyntaxDef(_EllipsesSuperSyntaxDef that);

    /** Process an instance of _EllipsesTransformerDecl. */
    public void for_EllipsesTransformerDecl(_EllipsesTransformerDecl that);

    /** Process an instance of _EllipsesPreTransformerDef. */
    public void for_EllipsesPreTransformerDef(_EllipsesPreTransformerDef that);

    /** Process an instance of _EllipsesNamedTransformerDef. */
    public void for_EllipsesNamedTransformerDef(_EllipsesNamedTransformerDef that);

    /** Process an instance of _EllipsesTransformer. */
    public void for_EllipsesTransformer(_EllipsesTransformer that);

    /** Process an instance of _EllipsesUnparsedTransformer. */
    public void for_EllipsesUnparsedTransformer(_EllipsesUnparsedTransformer that);

    /** Process an instance of _EllipsesNodeTransformer. */
    public void for_EllipsesNodeTransformer(_EllipsesNodeTransformer that);

    /** Process an instance of _EllipsesCaseTransformer. */
    public void for_EllipsesCaseTransformer(_EllipsesCaseTransformer that);

    /** Process an instance of _EllipsesCaseTransformerClause. */
    public void for_EllipsesCaseTransformerClause(_EllipsesCaseTransformerClause that);

    /** Process an instance of _EllipsesSyntaxSymbol. */
    public void for_EllipsesSyntaxSymbol(_EllipsesSyntaxSymbol that);

    /** Process an instance of _EllipsesPrefixedSymbol. */
    public void for_EllipsesPrefixedSymbol(_EllipsesPrefixedSymbol that);

    /** Process an instance of _EllipsesOptionalSymbol. */
    public void for_EllipsesOptionalSymbol(_EllipsesOptionalSymbol that);

    /** Process an instance of _EllipsesRepeatSymbol. */
    public void for_EllipsesRepeatSymbol(_EllipsesRepeatSymbol that);

    /** Process an instance of _EllipsesRepeatOneOrMoreSymbol. */
    public void for_EllipsesRepeatOneOrMoreSymbol(_EllipsesRepeatOneOrMoreSymbol that);

    /** Process an instance of _EllipsesNoWhitespaceSymbol. */
    public void for_EllipsesNoWhitespaceSymbol(_EllipsesNoWhitespaceSymbol that);

    /** Process an instance of _EllipsesGroupSymbol. */
    public void for_EllipsesGroupSymbol(_EllipsesGroupSymbol that);

    /** Process an instance of _EllipsesSpecialSymbol. */
    public void for_EllipsesSpecialSymbol(_EllipsesSpecialSymbol that);

    /** Process an instance of _EllipsesAnyCharacterSymbol. */
    public void for_EllipsesAnyCharacterSymbol(_EllipsesAnyCharacterSymbol that);

    /** Process an instance of _EllipsesWhitespaceSymbol. */
    public void for_EllipsesWhitespaceSymbol(_EllipsesWhitespaceSymbol that);

    /** Process an instance of _EllipsesTabSymbol. */
    public void for_EllipsesTabSymbol(_EllipsesTabSymbol that);

    /** Process an instance of _EllipsesFormfeedSymbol. */
    public void for_EllipsesFormfeedSymbol(_EllipsesFormfeedSymbol that);

    /** Process an instance of _EllipsesCarriageReturnSymbol. */
    public void for_EllipsesCarriageReturnSymbol(_EllipsesCarriageReturnSymbol that);

    /** Process an instance of _EllipsesBackspaceSymbol. */
    public void for_EllipsesBackspaceSymbol(_EllipsesBackspaceSymbol that);

    /** Process an instance of _EllipsesNewlineSymbol. */
    public void for_EllipsesNewlineSymbol(_EllipsesNewlineSymbol that);

    /** Process an instance of _EllipsesBreaklineSymbol. */
    public void for_EllipsesBreaklineSymbol(_EllipsesBreaklineSymbol that);

    /** Process an instance of _EllipsesItemSymbol. */
    public void for_EllipsesItemSymbol(_EllipsesItemSymbol that);

    /** Process an instance of _EllipsesNonterminalSymbol. */
    public void for_EllipsesNonterminalSymbol(_EllipsesNonterminalSymbol that);

    /** Process an instance of _EllipsesKeywordSymbol. */
    public void for_EllipsesKeywordSymbol(_EllipsesKeywordSymbol that);

    /** Process an instance of _EllipsesTokenSymbol. */
    public void for_EllipsesTokenSymbol(_EllipsesTokenSymbol that);

    /** Process an instance of _EllipsesNotPredicateSymbol. */
    public void for_EllipsesNotPredicateSymbol(_EllipsesNotPredicateSymbol that);

    /** Process an instance of _EllipsesAndPredicateSymbol. */
    public void for_EllipsesAndPredicateSymbol(_EllipsesAndPredicateSymbol that);

    /** Process an instance of _EllipsesCharacterClassSymbol. */
    public void for_EllipsesCharacterClassSymbol(_EllipsesCharacterClassSymbol that);

    /** Process an instance of _EllipsesCharacterSymbol. */
    public void for_EllipsesCharacterSymbol(_EllipsesCharacterSymbol that);

    /** Process an instance of _EllipsesCharSymbol. */
    public void for_EllipsesCharSymbol(_EllipsesCharSymbol that);

    /** Process an instance of _EllipsesCharacterInterval. */
    public void for_EllipsesCharacterInterval(_EllipsesCharacterInterval that);

    /** Process an instance of _EllipsesLink. */
    public void for_EllipsesLink(_EllipsesLink that);

    /** Process an instance of TemplateGapAbstractNode. */
    public void forTemplateGapAbstractNode(TemplateGapAbstractNode that);

    /** Process an instance of TemplateGapCompilationUnit. */
    public void forTemplateGapCompilationUnit(TemplateGapCompilationUnit that);

    /** Process an instance of TemplateGapComponent. */
    public void forTemplateGapComponent(TemplateGapComponent that);

    /** Process an instance of TemplateGapApi. */
    public void forTemplateGapApi(TemplateGapApi that);

    /** Process an instance of TemplateGapImport. */
    public void forTemplateGapImport(TemplateGapImport that);

    /** Process an instance of TemplateGapImportedNames. */
    public void forTemplateGapImportedNames(TemplateGapImportedNames that);

    /** Process an instance of TemplateGapImportStar. */
    public void forTemplateGapImportStar(TemplateGapImportStar that);

    /** Process an instance of TemplateGapImportNames. */
    public void forTemplateGapImportNames(TemplateGapImportNames that);

    /** Process an instance of TemplateGapImportApi. */
    public void forTemplateGapImportApi(TemplateGapImportApi that);

    /** Process an instance of TemplateGapAliasedSimpleName. */
    public void forTemplateGapAliasedSimpleName(TemplateGapAliasedSimpleName that);

    /** Process an instance of TemplateGapAliasedAPIName. */
    public void forTemplateGapAliasedAPIName(TemplateGapAliasedAPIName that);

    /** Process an instance of TemplateGapDecl. */
    public void forTemplateGapDecl(TemplateGapDecl that);

    /** Process an instance of TemplateGapTraitObjectDecl. */
    public void forTemplateGapTraitObjectDecl(TemplateGapTraitObjectDecl that);

    /** Process an instance of TemplateGapTraitDecl. */
    public void forTemplateGapTraitDecl(TemplateGapTraitDecl that);

    /** Process an instance of TemplateGapObjectDecl. */
    public void forTemplateGapObjectDecl(TemplateGapObjectDecl that);

    /** Process an instance of TemplateGapVarDecl. */
    public void forTemplateGapVarDecl(TemplateGapVarDecl that);

    /** Process an instance of TemplateGapFnDecl. */
    public void forTemplateGapFnDecl(TemplateGapFnDecl that);

    /** Process an instance of TemplateGap_RewriteFnOverloadDecl. */
    public void forTemplateGap_RewriteFnOverloadDecl(TemplateGap_RewriteFnOverloadDecl that);

    /** Process an instance of TemplateGap_RewriteObjectExprDecl. */
    public void forTemplateGap_RewriteObjectExprDecl(TemplateGap_RewriteObjectExprDecl that);

    /** Process an instance of TemplateGap_RewriteFunctionalMethodDecl. */
    public void forTemplateGap_RewriteFunctionalMethodDecl(TemplateGap_RewriteFunctionalMethodDecl that);

    /** Process an instance of TemplateGapDimUnitDecl. */
    public void forTemplateGapDimUnitDecl(TemplateGapDimUnitDecl that);

    /** Process an instance of TemplateGapDimDecl. */
    public void forTemplateGapDimDecl(TemplateGapDimDecl that);

    /** Process an instance of TemplateGapUnitDecl. */
    public void forTemplateGapUnitDecl(TemplateGapUnitDecl that);

    /** Process an instance of TemplateGapTestDecl. */
    public void forTemplateGapTestDecl(TemplateGapTestDecl that);

    /** Process an instance of TemplateGapPropertyDecl. */
    public void forTemplateGapPropertyDecl(TemplateGapPropertyDecl that);

    /** Process an instance of TemplateGapTypeAlias. */
    public void forTemplateGapTypeAlias(TemplateGapTypeAlias that);

    /** Process an instance of TemplateGapGrammarDecl. */
    public void forTemplateGapGrammarDecl(TemplateGapGrammarDecl that);

    /** Process an instance of TemplateGapGrammarMemberDecl. */
    public void forTemplateGapGrammarMemberDecl(TemplateGapGrammarMemberDecl that);

    /** Process an instance of TemplateGapNonterminalDecl. */
    public void forTemplateGapNonterminalDecl(TemplateGapNonterminalDecl that);

    /** Process an instance of TemplateGapNonterminalDef. */
    public void forTemplateGapNonterminalDef(TemplateGapNonterminalDef that);

    /** Process an instance of TemplateGapNonterminalExtensionDef. */
    public void forTemplateGapNonterminalExtensionDef(TemplateGapNonterminalExtensionDef that);

    /** Process an instance of TemplateGapBinding. */
    public void forTemplateGapBinding(TemplateGapBinding that);

    /** Process an instance of TemplateGapLValue. */
    public void forTemplateGapLValue(TemplateGapLValue that);

    /** Process an instance of TemplateGapParam. */
    public void forTemplateGapParam(TemplateGapParam that);

    /** Process an instance of TemplateGapExpr. */
    public void forTemplateGapExpr(TemplateGapExpr that);

    /** Process an instance of TemplateGapDummyExpr. */
    public void forTemplateGapDummyExpr(TemplateGapDummyExpr that);

    /** Process an instance of TemplateGapTypeAnnotatedExpr. */
    public void forTemplateGapTypeAnnotatedExpr(TemplateGapTypeAnnotatedExpr that);

    /** Process an instance of TemplateGapAsExpr. */
    public void forTemplateGapAsExpr(TemplateGapAsExpr that);

    /** Process an instance of TemplateGapAsIfExpr. */
    public void forTemplateGapAsIfExpr(TemplateGapAsIfExpr that);

    /** Process an instance of TemplateGapAssignment. */
    public void forTemplateGapAssignment(TemplateGapAssignment that);

    /** Process an instance of TemplateGapBlock. */
    public void forTemplateGapBlock(TemplateGapBlock that);

    /** Process an instance of TemplateGapDo. */
    public void forTemplateGapDo(TemplateGapDo that);

    /** Process an instance of TemplateGapCaseExpr. */
    public void forTemplateGapCaseExpr(TemplateGapCaseExpr that);

    /** Process an instance of TemplateGapIf. */
    public void forTemplateGapIf(TemplateGapIf that);

    /** Process an instance of TemplateGapLabel. */
    public void forTemplateGapLabel(TemplateGapLabel that);

    /** Process an instance of TemplateGapAbstractObjectExpr. */
    public void forTemplateGapAbstractObjectExpr(TemplateGapAbstractObjectExpr that);

    /** Process an instance of TemplateGapObjectExpr. */
    public void forTemplateGapObjectExpr(TemplateGapObjectExpr that);

    /** Process an instance of TemplateGap_RewriteObjectExpr. */
    public void forTemplateGap_RewriteObjectExpr(TemplateGap_RewriteObjectExpr that);

    /** Process an instance of TemplateGapTry. */
    public void forTemplateGapTry(TemplateGapTry that);

    /** Process an instance of TemplateGapTupleExpr. */
    public void forTemplateGapTupleExpr(TemplateGapTupleExpr that);

    /** Process an instance of TemplateGapTypecase. */
    public void forTemplateGapTypecase(TemplateGapTypecase that);

    /** Process an instance of TemplateGapWhile. */
    public void forTemplateGapWhile(TemplateGapWhile that);

    /** Process an instance of TemplateGapFor. */
    public void forTemplateGapFor(TemplateGapFor that);

    /** Process an instance of TemplateGapBigOpApp. */
    public void forTemplateGapBigOpApp(TemplateGapBigOpApp that);

    /** Process an instance of TemplateGapAccumulator. */
    public void forTemplateGapAccumulator(TemplateGapAccumulator that);

    /** Process an instance of TemplateGapArrayComprehension. */
    public void forTemplateGapArrayComprehension(TemplateGapArrayComprehension that);

    /** Process an instance of TemplateGapAtomicExpr. */
    public void forTemplateGapAtomicExpr(TemplateGapAtomicExpr that);

    /** Process an instance of TemplateGapExit. */
    public void forTemplateGapExit(TemplateGapExit that);

    /** Process an instance of TemplateGapSpawn. */
    public void forTemplateGapSpawn(TemplateGapSpawn that);

    /** Process an instance of TemplateGapThrow. */
    public void forTemplateGapThrow(TemplateGapThrow that);

    /** Process an instance of TemplateGapTryAtomicExpr. */
    public void forTemplateGapTryAtomicExpr(TemplateGapTryAtomicExpr that);

    /** Process an instance of TemplateGapFnExpr. */
    public void forTemplateGapFnExpr(TemplateGapFnExpr that);

    /** Process an instance of TemplateGapLetExpr. */
    public void forTemplateGapLetExpr(TemplateGapLetExpr that);

    /** Process an instance of TemplateGapLetFn. */
    public void forTemplateGapLetFn(TemplateGapLetFn that);

    /** Process an instance of TemplateGapLocalVarDecl. */
    public void forTemplateGapLocalVarDecl(TemplateGapLocalVarDecl that);

    /** Process an instance of TemplateGapSimpleExpr. */
    public void forTemplateGapSimpleExpr(TemplateGapSimpleExpr that);

    /** Process an instance of TemplateGapSubscriptExpr. */
    public void forTemplateGapSubscriptExpr(TemplateGapSubscriptExpr that);

    /** Process an instance of TemplateGapPrimary. */
    public void forTemplateGapPrimary(TemplateGapPrimary that);

    /** Process an instance of TemplateGapLiteralExpr. */
    public void forTemplateGapLiteralExpr(TemplateGapLiteralExpr that);

    /** Process an instance of TemplateGapNumberLiteralExpr. */
    public void forTemplateGapNumberLiteralExpr(TemplateGapNumberLiteralExpr that);

    /** Process an instance of TemplateGapFloatLiteralExpr. */
    public void forTemplateGapFloatLiteralExpr(TemplateGapFloatLiteralExpr that);

    /** Process an instance of TemplateGapIntLiteralExpr. */
    public void forTemplateGapIntLiteralExpr(TemplateGapIntLiteralExpr that);

    /** Process an instance of TemplateGapCharLiteralExpr. */
    public void forTemplateGapCharLiteralExpr(TemplateGapCharLiteralExpr that);

    /** Process an instance of TemplateGapStringLiteralExpr. */
    public void forTemplateGapStringLiteralExpr(TemplateGapStringLiteralExpr that);

    /** Process an instance of TemplateGapVoidLiteralExpr. */
    public void forTemplateGapVoidLiteralExpr(TemplateGapVoidLiteralExpr that);

    /** Process an instance of TemplateGapBooleanLiteralExpr. */
    public void forTemplateGapBooleanLiteralExpr(TemplateGapBooleanLiteralExpr that);

    /** Process an instance of TemplateGapVarRef. */
    public void forTemplateGapVarRef(TemplateGapVarRef that);

    /** Process an instance of TemplateGapFieldRef. */
    public void forTemplateGapFieldRef(TemplateGapFieldRef that);

    /** Process an instance of TemplateGapFunctionalRef. */
    public void forTemplateGapFunctionalRef(TemplateGapFunctionalRef that);

    /** Process an instance of TemplateGapFnRef. */
    public void forTemplateGapFnRef(TemplateGapFnRef that);

    /** Process an instance of TemplateGapOpRef. */
    public void forTemplateGapOpRef(TemplateGapOpRef that);

    /** Process an instance of TemplateGap_RewriteFnRef. */
    public void forTemplateGap_RewriteFnRef(TemplateGap_RewriteFnRef that);

    /** Process an instance of TemplateGap_RewriteObjectExprRef. */
    public void forTemplateGap_RewriteObjectExprRef(TemplateGap_RewriteObjectExprRef that);

    /** Process an instance of TemplateGapJuxt. */
    public void forTemplateGapJuxt(TemplateGapJuxt that);

    /** Process an instance of TemplateGap_RewriteFnApp. */
    public void forTemplateGap_RewriteFnApp(TemplateGap_RewriteFnApp that);

    /** Process an instance of TemplateGapOpExpr. */
    public void forTemplateGapOpExpr(TemplateGapOpExpr that);

    /** Process an instance of TemplateGapAmbiguousMultifixOpExpr. */
    public void forTemplateGapAmbiguousMultifixOpExpr(TemplateGapAmbiguousMultifixOpExpr that);

    /** Process an instance of TemplateGapChainExpr. */
    public void forTemplateGapChainExpr(TemplateGapChainExpr that);

    /** Process an instance of TemplateGapCoercionInvocation. */
    public void forTemplateGapCoercionInvocation(TemplateGapCoercionInvocation that);

    /** Process an instance of TemplateGapTraitCoercionInvocation. */
    public void forTemplateGapTraitCoercionInvocation(TemplateGapTraitCoercionInvocation that);

    /** Process an instance of TemplateGapTupleCoercionInvocation. */
    public void forTemplateGapTupleCoercionInvocation(TemplateGapTupleCoercionInvocation that);

    /** Process an instance of TemplateGapArrowCoercionInvocation. */
    public void forTemplateGapArrowCoercionInvocation(TemplateGapArrowCoercionInvocation that);

    /** Process an instance of TemplateGapUnionCoercionInvocation. */
    public void forTemplateGapUnionCoercionInvocation(TemplateGapUnionCoercionInvocation that);

    /** Process an instance of TemplateGapMethodInvocation. */
    public void forTemplateGapMethodInvocation(TemplateGapMethodInvocation that);

    /** Process an instance of TemplateGapMathPrimary. */
    public void forTemplateGapMathPrimary(TemplateGapMathPrimary that);

    /** Process an instance of TemplateGapArrayExpr. */
    public void forTemplateGapArrayExpr(TemplateGapArrayExpr that);

    /** Process an instance of TemplateGapArrayElement. */
    public void forTemplateGapArrayElement(TemplateGapArrayElement that);

    /** Process an instance of TemplateGapArrayElements. */
    public void forTemplateGapArrayElements(TemplateGapArrayElements that);

    /** Process an instance of TemplateGapType. */
    public void forTemplateGapType(TemplateGapType that);

    /** Process an instance of TemplateGapBaseType. */
    public void forTemplateGapBaseType(TemplateGapBaseType that);

    /** Process an instance of TemplateGapAnyType. */
    public void forTemplateGapAnyType(TemplateGapAnyType that);

    /** Process an instance of TemplateGapBottomType. */
    public void forTemplateGapBottomType(TemplateGapBottomType that);

    /** Process an instance of TemplateGapUnknownType. */
    public void forTemplateGapUnknownType(TemplateGapUnknownType that);

    /** Process an instance of TemplateGapSelfType. */
    public void forTemplateGapSelfType(TemplateGapSelfType that);

    /** Process an instance of TemplateGapTraitSelfType. */
    public void forTemplateGapTraitSelfType(TemplateGapTraitSelfType that);

    /** Process an instance of TemplateGapObjectExprType. */
    public void forTemplateGapObjectExprType(TemplateGapObjectExprType that);

    /** Process an instance of TemplateGapNamedType. */
    public void forTemplateGapNamedType(TemplateGapNamedType that);

    /** Process an instance of TemplateGap_InferenceVarType. */
    public void forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that);

    /** Process an instance of TemplateGapVarType. */
    public void forTemplateGapVarType(TemplateGapVarType that);

    /** Process an instance of TemplateGapTraitType. */
    public void forTemplateGapTraitType(TemplateGapTraitType that);

    /** Process an instance of TemplateGapAbbreviatedType. */
    public void forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that);

    /** Process an instance of TemplateGapArrayType. */
    public void forTemplateGapArrayType(TemplateGapArrayType that);

    /** Process an instance of TemplateGapMatrixType. */
    public void forTemplateGapMatrixType(TemplateGapMatrixType that);

    /** Process an instance of TemplateGapTaggedDimType. */
    public void forTemplateGapTaggedDimType(TemplateGapTaggedDimType that);

    /** Process an instance of TemplateGapTaggedUnitType. */
    public void forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that);

    /** Process an instance of TemplateGapTupleType. */
    public void forTemplateGapTupleType(TemplateGapTupleType that);

    /** Process an instance of TemplateGapArrowType. */
    public void forTemplateGapArrowType(TemplateGapArrowType that);

    /** Process an instance of TemplateGapBoundType. */
    public void forTemplateGapBoundType(TemplateGapBoundType that);

    /** Process an instance of TemplateGapIntersectionType. */
    public void forTemplateGapIntersectionType(TemplateGapIntersectionType that);

    /** Process an instance of TemplateGapUnionType. */
    public void forTemplateGapUnionType(TemplateGapUnionType that);

    /** Process an instance of TemplateGapFixedPointType. */
    public void forTemplateGapFixedPointType(TemplateGapFixedPointType that);

    /** Process an instance of TemplateGapLabelType. */
    public void forTemplateGapLabelType(TemplateGapLabelType that);

    /** Process an instance of TemplateGapDimExpr. */
    public void forTemplateGapDimExpr(TemplateGapDimExpr that);

    /** Process an instance of TemplateGapDimBase. */
    public void forTemplateGapDimBase(TemplateGapDimBase that);

    /** Process an instance of TemplateGapDimRef. */
    public void forTemplateGapDimRef(TemplateGapDimRef that);

    /** Process an instance of TemplateGapDimExponent. */
    public void forTemplateGapDimExponent(TemplateGapDimExponent that);

    /** Process an instance of TemplateGapDimUnaryOp. */
    public void forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that);

    /** Process an instance of TemplateGapDimBinaryOp. */
    public void forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that);

    /** Process an instance of TemplateGapPattern. */
    public void forTemplateGapPattern(TemplateGapPattern that);

    /** Process an instance of TemplateGapPatternArgs. */
    public void forTemplateGapPatternArgs(TemplateGapPatternArgs that);

    /** Process an instance of TemplateGapPatternBinding. */
    public void forTemplateGapPatternBinding(TemplateGapPatternBinding that);

    /** Process an instance of TemplateGapPlainPattern. */
    public void forTemplateGapPlainPattern(TemplateGapPlainPattern that);

    /** Process an instance of TemplateGapTypePattern. */
    public void forTemplateGapTypePattern(TemplateGapTypePattern that);

    /** Process an instance of TemplateGapNestedPattern. */
    public void forTemplateGapNestedPattern(TemplateGapNestedPattern that);

    /** Process an instance of TemplateGapStaticArg. */
    public void forTemplateGapStaticArg(TemplateGapStaticArg that);

    /** Process an instance of TemplateGapTypeArg. */
    public void forTemplateGapTypeArg(TemplateGapTypeArg that);

    /** Process an instance of TemplateGapIntArg. */
    public void forTemplateGapIntArg(TemplateGapIntArg that);

    /** Process an instance of TemplateGapBoolArg. */
    public void forTemplateGapBoolArg(TemplateGapBoolArg that);

    /** Process an instance of TemplateGapOpArg. */
    public void forTemplateGapOpArg(TemplateGapOpArg that);

    /** Process an instance of TemplateGapDimArg. */
    public void forTemplateGapDimArg(TemplateGapDimArg that);

    /** Process an instance of TemplateGapUnitArg. */
    public void forTemplateGapUnitArg(TemplateGapUnitArg that);

    /** Process an instance of TemplateGapStaticExpr. */
    public void forTemplateGapStaticExpr(TemplateGapStaticExpr that);

    /** Process an instance of TemplateGapIntExpr. */
    public void forTemplateGapIntExpr(TemplateGapIntExpr that);

    /** Process an instance of TemplateGapIntBase. */
    public void forTemplateGapIntBase(TemplateGapIntBase that);

    /** Process an instance of TemplateGapIntRef. */
    public void forTemplateGapIntRef(TemplateGapIntRef that);

    /** Process an instance of TemplateGapIntBinaryOp. */
    public void forTemplateGapIntBinaryOp(TemplateGapIntBinaryOp that);

    /** Process an instance of TemplateGapBoolExpr. */
    public void forTemplateGapBoolExpr(TemplateGapBoolExpr that);

    /** Process an instance of TemplateGapBoolBase. */
    public void forTemplateGapBoolBase(TemplateGapBoolBase that);

    /** Process an instance of TemplateGapBoolRef. */
    public void forTemplateGapBoolRef(TemplateGapBoolRef that);

    /** Process an instance of TemplateGapBoolConstraint. */
    public void forTemplateGapBoolConstraint(TemplateGapBoolConstraint that);

    /** Process an instance of TemplateGapBoolUnaryOp. */
    public void forTemplateGapBoolUnaryOp(TemplateGapBoolUnaryOp that);

    /** Process an instance of TemplateGapBoolBinaryOp. */
    public void forTemplateGapBoolBinaryOp(TemplateGapBoolBinaryOp that);

    /** Process an instance of TemplateGapUnitExpr. */
    public void forTemplateGapUnitExpr(TemplateGapUnitExpr that);

    /** Process an instance of TemplateGapUnitRef. */
    public void forTemplateGapUnitRef(TemplateGapUnitRef that);

    /** Process an instance of TemplateGapUnitBinaryOp. */
    public void forTemplateGapUnitBinaryOp(TemplateGapUnitBinaryOp that);

    /** Process an instance of TemplateGapEffect. */
    public void forTemplateGapEffect(TemplateGapEffect that);

    /** Process an instance of TemplateGapWhereClause. */
    public void forTemplateGapWhereClause(TemplateGapWhereClause that);

    /** Process an instance of TemplateGapWhereBinding. */
    public void forTemplateGapWhereBinding(TemplateGapWhereBinding that);

    /** Process an instance of TemplateGapWhereConstraint. */
    public void forTemplateGapWhereConstraint(TemplateGapWhereConstraint that);

    /** Process an instance of TemplateGapWhereExtends. */
    public void forTemplateGapWhereExtends(TemplateGapWhereExtends that);

    /** Process an instance of TemplateGapWhereTypeAlias. */
    public void forTemplateGapWhereTypeAlias(TemplateGapWhereTypeAlias that);

    /** Process an instance of TemplateGapWhereCoerces. */
    public void forTemplateGapWhereCoerces(TemplateGapWhereCoerces that);

    /** Process an instance of TemplateGapWhereEquals. */
    public void forTemplateGapWhereEquals(TemplateGapWhereEquals that);

    /** Process an instance of TemplateGapUnitConstraint. */
    public void forTemplateGapUnitConstraint(TemplateGapUnitConstraint that);

    /** Process an instance of TemplateGapIntConstraint. */
    public void forTemplateGapIntConstraint(TemplateGapIntConstraint that);

    /** Process an instance of TemplateGapBoolConstraintExpr. */
    public void forTemplateGapBoolConstraintExpr(TemplateGapBoolConstraintExpr that);

    /** Process an instance of TemplateGapContract. */
    public void forTemplateGapContract(TemplateGapContract that);

    /** Process an instance of TemplateGapEnsuresClause. */
    public void forTemplateGapEnsuresClause(TemplateGapEnsuresClause that);

    /** Process an instance of TemplateGapStaticParam. */
    public void forTemplateGapStaticParam(TemplateGapStaticParam that);

    /** Process an instance of TemplateGapName. */
    public void forTemplateGapName(TemplateGapName that);

    /** Process an instance of TemplateGapAPIName. */
    public void forTemplateGapAPIName(TemplateGapAPIName that);

    /** Process an instance of TemplateGapIdOrOpOrAnonymousName. */
    public void forTemplateGapIdOrOpOrAnonymousName(TemplateGapIdOrOpOrAnonymousName that);

    /** Process an instance of TemplateGapIdOrOp. */
    public void forTemplateGapIdOrOp(TemplateGapIdOrOp that);

    /** Process an instance of TemplateGapId. */
    public void forTemplateGapId(TemplateGapId that);

    /** Process an instance of TemplateGapOp. */
    public void forTemplateGapOp(TemplateGapOp that);

    /** Process an instance of TemplateGapNamedOp. */
    public void forTemplateGapNamedOp(TemplateGapNamedOp that);

    /** Process an instance of TemplateGap_InferenceVarOp. */
    public void forTemplateGap_InferenceVarOp(TemplateGap_InferenceVarOp that);

    /** Process an instance of TemplateGapAnonymousName. */
    public void forTemplateGapAnonymousName(TemplateGapAnonymousName that);

    /** Process an instance of TemplateGapAnonymousFnName. */
    public void forTemplateGapAnonymousFnName(TemplateGapAnonymousFnName that);

    /** Process an instance of TemplateGapConstructorFnName. */
    public void forTemplateGapConstructorFnName(TemplateGapConstructorFnName that);

    /** Process an instance of TemplateGapArrayComprehensionClause. */
    public void forTemplateGapArrayComprehensionClause(TemplateGapArrayComprehensionClause that);

    /** Process an instance of TemplateGapKeywordExpr. */
    public void forTemplateGapKeywordExpr(TemplateGapKeywordExpr that);

    /** Process an instance of TemplateGapCaseClause. */
    public void forTemplateGapCaseClause(TemplateGapCaseClause that);

    /** Process an instance of TemplateGapCatch. */
    public void forTemplateGapCatch(TemplateGapCatch that);

    /** Process an instance of TemplateGapCatchClause. */
    public void forTemplateGapCatchClause(TemplateGapCatchClause that);

    /** Process an instance of TemplateGapIfClause. */
    public void forTemplateGapIfClause(TemplateGapIfClause that);

    /** Process an instance of TemplateGapTypecaseClause. */
    public void forTemplateGapTypecaseClause(TemplateGapTypecaseClause that);

    /** Process an instance of TemplateGapExtentRange. */
    public void forTemplateGapExtentRange(TemplateGapExtentRange that);

    /** Process an instance of TemplateGapGeneratorClause. */
    public void forTemplateGapGeneratorClause(TemplateGapGeneratorClause that);

    /** Process an instance of TemplateGapKeywordType. */
    public void forTemplateGapKeywordType(TemplateGapKeywordType that);

    /** Process an instance of TemplateGapTraitTypeWhere. */
    public void forTemplateGapTraitTypeWhere(TemplateGapTraitTypeWhere that);

    /** Process an instance of TemplateGapIndices. */
    public void forTemplateGapIndices(TemplateGapIndices that);

    /** Process an instance of TemplateGapMathItem. */
    public void forTemplateGapMathItem(TemplateGapMathItem that);

    /** Process an instance of TemplateGapExprMI. */
    public void forTemplateGapExprMI(TemplateGapExprMI that);

    /** Process an instance of TemplateGapParenthesisDelimitedMI. */
    public void forTemplateGapParenthesisDelimitedMI(TemplateGapParenthesisDelimitedMI that);

    /** Process an instance of TemplateGapNonParenthesisDelimitedMI. */
    public void forTemplateGapNonParenthesisDelimitedMI(TemplateGapNonParenthesisDelimitedMI that);

    /** Process an instance of TemplateGapNonExprMI. */
    public void forTemplateGapNonExprMI(TemplateGapNonExprMI that);

    /** Process an instance of TemplateGapExponentiationMI. */
    public void forTemplateGapExponentiationMI(TemplateGapExponentiationMI that);

    /** Process an instance of TemplateGapSubscriptingMI. */
    public void forTemplateGapSubscriptingMI(TemplateGapSubscriptingMI that);

    /** Process an instance of TemplateGapOverloading. */
    public void forTemplateGapOverloading(TemplateGapOverloading that);

    /** Process an instance of TemplateGapNonterminalHeader. */
    public void forTemplateGapNonterminalHeader(TemplateGapNonterminalHeader that);

    /** Process an instance of TemplateGapNonterminalParameter. */
    public void forTemplateGapNonterminalParameter(TemplateGapNonterminalParameter that);

    /** Process an instance of TemplateGapSyntaxDecl. */
    public void forTemplateGapSyntaxDecl(TemplateGapSyntaxDecl that);

    /** Process an instance of TemplateGapSyntaxDef. */
    public void forTemplateGapSyntaxDef(TemplateGapSyntaxDef that);

    /** Process an instance of TemplateGapSuperSyntaxDef. */
    public void forTemplateGapSuperSyntaxDef(TemplateGapSuperSyntaxDef that);

    /** Process an instance of TemplateGapTransformerDecl. */
    public void forTemplateGapTransformerDecl(TemplateGapTransformerDecl that);

    /** Process an instance of TemplateGapPreTransformerDef. */
    public void forTemplateGapPreTransformerDef(TemplateGapPreTransformerDef that);

    /** Process an instance of TemplateGapNamedTransformerDef. */
    public void forTemplateGapNamedTransformerDef(TemplateGapNamedTransformerDef that);

    /** Process an instance of TemplateGapTransformer. */
    public void forTemplateGapTransformer(TemplateGapTransformer that);

    /** Process an instance of TemplateGapUnparsedTransformer. */
    public void forTemplateGapUnparsedTransformer(TemplateGapUnparsedTransformer that);

    /** Process an instance of TemplateGapNodeTransformer. */
    public void forTemplateGapNodeTransformer(TemplateGapNodeTransformer that);

    /** Process an instance of TemplateGapCaseTransformer. */
    public void forTemplateGapCaseTransformer(TemplateGapCaseTransformer that);

    /** Process an instance of TemplateGapCaseTransformerClause. */
    public void forTemplateGapCaseTransformerClause(TemplateGapCaseTransformerClause that);

    /** Process an instance of TemplateGapSyntaxSymbol. */
    public void forTemplateGapSyntaxSymbol(TemplateGapSyntaxSymbol that);

    /** Process an instance of TemplateGapPrefixedSymbol. */
    public void forTemplateGapPrefixedSymbol(TemplateGapPrefixedSymbol that);

    /** Process an instance of TemplateGapOptionalSymbol. */
    public void forTemplateGapOptionalSymbol(TemplateGapOptionalSymbol that);

    /** Process an instance of TemplateGapRepeatSymbol. */
    public void forTemplateGapRepeatSymbol(TemplateGapRepeatSymbol that);

    /** Process an instance of TemplateGapRepeatOneOrMoreSymbol. */
    public void forTemplateGapRepeatOneOrMoreSymbol(TemplateGapRepeatOneOrMoreSymbol that);

    /** Process an instance of TemplateGapNoWhitespaceSymbol. */
    public void forTemplateGapNoWhitespaceSymbol(TemplateGapNoWhitespaceSymbol that);

    /** Process an instance of TemplateGapGroupSymbol. */
    public void forTemplateGapGroupSymbol(TemplateGapGroupSymbol that);

    /** Process an instance of TemplateGapSpecialSymbol. */
    public void forTemplateGapSpecialSymbol(TemplateGapSpecialSymbol that);

    /** Process an instance of TemplateGapAnyCharacterSymbol. */
    public void forTemplateGapAnyCharacterSymbol(TemplateGapAnyCharacterSymbol that);

    /** Process an instance of TemplateGapWhitespaceSymbol. */
    public void forTemplateGapWhitespaceSymbol(TemplateGapWhitespaceSymbol that);

    /** Process an instance of TemplateGapTabSymbol. */
    public void forTemplateGapTabSymbol(TemplateGapTabSymbol that);

    /** Process an instance of TemplateGapFormfeedSymbol. */
    public void forTemplateGapFormfeedSymbol(TemplateGapFormfeedSymbol that);

    /** Process an instance of TemplateGapCarriageReturnSymbol. */
    public void forTemplateGapCarriageReturnSymbol(TemplateGapCarriageReturnSymbol that);

    /** Process an instance of TemplateGapBackspaceSymbol. */
    public void forTemplateGapBackspaceSymbol(TemplateGapBackspaceSymbol that);

    /** Process an instance of TemplateGapNewlineSymbol. */
    public void forTemplateGapNewlineSymbol(TemplateGapNewlineSymbol that);

    /** Process an instance of TemplateGapBreaklineSymbol. */
    public void forTemplateGapBreaklineSymbol(TemplateGapBreaklineSymbol that);

    /** Process an instance of TemplateGapItemSymbol. */
    public void forTemplateGapItemSymbol(TemplateGapItemSymbol that);

    /** Process an instance of TemplateGapNonterminalSymbol. */
    public void forTemplateGapNonterminalSymbol(TemplateGapNonterminalSymbol that);

    /** Process an instance of TemplateGapKeywordSymbol. */
    public void forTemplateGapKeywordSymbol(TemplateGapKeywordSymbol that);

    /** Process an instance of TemplateGapTokenSymbol. */
    public void forTemplateGapTokenSymbol(TemplateGapTokenSymbol that);

    /** Process an instance of TemplateGapNotPredicateSymbol. */
    public void forTemplateGapNotPredicateSymbol(TemplateGapNotPredicateSymbol that);

    /** Process an instance of TemplateGapAndPredicateSymbol. */
    public void forTemplateGapAndPredicateSymbol(TemplateGapAndPredicateSymbol that);

    /** Process an instance of TemplateGapCharacterClassSymbol. */
    public void forTemplateGapCharacterClassSymbol(TemplateGapCharacterClassSymbol that);

    /** Process an instance of TemplateGapCharacterSymbol. */
    public void forTemplateGapCharacterSymbol(TemplateGapCharacterSymbol that);

    /** Process an instance of TemplateGapCharSymbol. */
    public void forTemplateGapCharSymbol(TemplateGapCharSymbol that);

    /** Process an instance of TemplateGapCharacterInterval. */
    public void forTemplateGapCharacterInterval(TemplateGapCharacterInterval that);

    /** Process an instance of TemplateGapLink. */
    public void forTemplateGapLink(TemplateGapLink that);
}
