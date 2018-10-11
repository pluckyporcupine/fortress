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

/** A parametric interface for visitors over Node that return a value. */
@SuppressWarnings("unused")
public interface NodeVisitor<RetType> extends AbstractNodeVisitor<RetType>, ExprVisitor<RetType>, TypeVisitor<RetType>, StaticArgVisitor<RetType> {

    /** Process an instance of Component. */
    public RetType forComponent(Component that);

    /** Process an instance of Api. */
    public RetType forApi(Api that);

    /** Process an instance of ImportStar. */
    public RetType forImportStar(ImportStar that);

    /** Process an instance of ImportNames. */
    public RetType forImportNames(ImportNames that);

    /** Process an instance of ImportApi. */
    public RetType forImportApi(ImportApi that);

    /** Process an instance of AliasedSimpleName. */
    public RetType forAliasedSimpleName(AliasedSimpleName that);

    /** Process an instance of AliasedAPIName. */
    public RetType forAliasedAPIName(AliasedAPIName that);

    /** Process an instance of TraitDecl. */
    public RetType forTraitDecl(TraitDecl that);

    /** Process an instance of ObjectDecl. */
    public RetType forObjectDecl(ObjectDecl that);

    /** Process an instance of VarDecl. */
    public RetType forVarDecl(VarDecl that);

    /** Process an instance of FnDecl. */
    public RetType forFnDecl(FnDecl that);

    /** Process an instance of _RewriteFnOverloadDecl. */
    public RetType for_RewriteFnOverloadDecl(_RewriteFnOverloadDecl that);

    /** Process an instance of _RewriteObjectExprDecl. */
    public RetType for_RewriteObjectExprDecl(_RewriteObjectExprDecl that);

    /** Process an instance of _RewriteFunctionalMethodDecl. */
    public RetType for_RewriteFunctionalMethodDecl(_RewriteFunctionalMethodDecl that);

    /** Process an instance of DimDecl. */
    public RetType forDimDecl(DimDecl that);

    /** Process an instance of UnitDecl. */
    public RetType forUnitDecl(UnitDecl that);

    /** Process an instance of TestDecl. */
    public RetType forTestDecl(TestDecl that);

    /** Process an instance of PropertyDecl. */
    public RetType forPropertyDecl(PropertyDecl that);

    /** Process an instance of TypeAlias. */
    public RetType forTypeAlias(TypeAlias that);

    /** Process an instance of GrammarDecl. */
    public RetType forGrammarDecl(GrammarDecl that);

    /** Process an instance of NonterminalDef. */
    public RetType forNonterminalDef(NonterminalDef that);

    /** Process an instance of NonterminalExtensionDef. */
    public RetType forNonterminalExtensionDef(NonterminalExtensionDef that);

    /** Process an instance of LValue. */
    public RetType forLValue(LValue that);

    /** Process an instance of Param. */
    public RetType forParam(Param that);

    /** Process an instance of DummyExpr. */
    public RetType forDummyExpr(DummyExpr that);

    /** Process an instance of AsExpr. */
    public RetType forAsExpr(AsExpr that);

    /** Process an instance of AsIfExpr. */
    public RetType forAsIfExpr(AsIfExpr that);

    /** Process an instance of Assignment. */
    public RetType forAssignment(Assignment that);

    /** Process an instance of Block. */
    public RetType forBlock(Block that);

    /** Process an instance of Do. */
    public RetType forDo(Do that);

    /** Process an instance of CaseExpr. */
    public RetType forCaseExpr(CaseExpr that);

    /** Process an instance of If. */
    public RetType forIf(If that);

    /** Process an instance of Label. */
    public RetType forLabel(Label that);

    /** Process an instance of ObjectExpr. */
    public RetType forObjectExpr(ObjectExpr that);

    /** Process an instance of _RewriteObjectExpr. */
    public RetType for_RewriteObjectExpr(_RewriteObjectExpr that);

    /** Process an instance of Try. */
    public RetType forTry(Try that);

    /** Process an instance of TupleExpr. */
    public RetType forTupleExpr(TupleExpr that);

    /** Process an instance of Typecase. */
    public RetType forTypecase(Typecase that);

    /** Process an instance of While. */
    public RetType forWhile(While that);

    /** Process an instance of For. */
    public RetType forFor(For that);

    /** Process an instance of Accumulator. */
    public RetType forAccumulator(Accumulator that);

    /** Process an instance of ArrayComprehension. */
    public RetType forArrayComprehension(ArrayComprehension that);

    /** Process an instance of AtomicExpr. */
    public RetType forAtomicExpr(AtomicExpr that);

    /** Process an instance of Exit. */
    public RetType forExit(Exit that);

    /** Process an instance of Spawn. */
    public RetType forSpawn(Spawn that);

    /** Process an instance of Throw. */
    public RetType forThrow(Throw that);

    /** Process an instance of TryAtomicExpr. */
    public RetType forTryAtomicExpr(TryAtomicExpr that);

    /** Process an instance of FnExpr. */
    public RetType forFnExpr(FnExpr that);

    /** Process an instance of LetFn. */
    public RetType forLetFn(LetFn that);

    /** Process an instance of LocalVarDecl. */
    public RetType forLocalVarDecl(LocalVarDecl that);

    /** Process an instance of SubscriptExpr. */
    public RetType forSubscriptExpr(SubscriptExpr that);

    /** Process an instance of FloatLiteralExpr. */
    public RetType forFloatLiteralExpr(FloatLiteralExpr that);

    /** Process an instance of IntLiteralExpr. */
    public RetType forIntLiteralExpr(IntLiteralExpr that);

    /** Process an instance of CharLiteralExpr. */
    public RetType forCharLiteralExpr(CharLiteralExpr that);

    /** Process an instance of StringLiteralExpr. */
    public RetType forStringLiteralExpr(StringLiteralExpr that);

    /** Process an instance of VoidLiteralExpr. */
    public RetType forVoidLiteralExpr(VoidLiteralExpr that);

    /** Process an instance of BooleanLiteralExpr. */
    public RetType forBooleanLiteralExpr(BooleanLiteralExpr that);

    /** Process an instance of VarRef. */
    public RetType forVarRef(VarRef that);

    /** Process an instance of FieldRef. */
    public RetType forFieldRef(FieldRef that);

    /** Process an instance of FnRef. */
    public RetType forFnRef(FnRef that);

    /** Process an instance of OpRef. */
    public RetType forOpRef(OpRef that);

    /** Process an instance of _RewriteFnRef. */
    public RetType for_RewriteFnRef(_RewriteFnRef that);

    /** Process an instance of _RewriteObjectExprRef. */
    public RetType for_RewriteObjectExprRef(_RewriteObjectExprRef that);

    /** Process an instance of Juxt. */
    public RetType forJuxt(Juxt that);

    /** Process an instance of _RewriteFnApp. */
    public RetType for_RewriteFnApp(_RewriteFnApp that);

    /** Process an instance of OpExpr. */
    public RetType forOpExpr(OpExpr that);

    /** Process an instance of AmbiguousMultifixOpExpr. */
    public RetType forAmbiguousMultifixOpExpr(AmbiguousMultifixOpExpr that);

    /** Process an instance of ChainExpr. */
    public RetType forChainExpr(ChainExpr that);

    /** Process an instance of TraitCoercionInvocation. */
    public RetType forTraitCoercionInvocation(TraitCoercionInvocation that);

    /** Process an instance of TupleCoercionInvocation. */
    public RetType forTupleCoercionInvocation(TupleCoercionInvocation that);

    /** Process an instance of ArrowCoercionInvocation. */
    public RetType forArrowCoercionInvocation(ArrowCoercionInvocation that);

    /** Process an instance of UnionCoercionInvocation. */
    public RetType forUnionCoercionInvocation(UnionCoercionInvocation that);

    /** Process an instance of MethodInvocation. */
    public RetType forMethodInvocation(MethodInvocation that);

    /** Process an instance of MathPrimary. */
    public RetType forMathPrimary(MathPrimary that);

    /** Process an instance of ArrayElement. */
    public RetType forArrayElement(ArrayElement that);

    /** Process an instance of ArrayElements. */
    public RetType forArrayElements(ArrayElements that);

    /** Process an instance of AnyType. */
    public RetType forAnyType(AnyType that);

    /** Process an instance of BottomType. */
    public RetType forBottomType(BottomType that);

    /** Process an instance of UnknownType. */
    public RetType forUnknownType(UnknownType that);

    /** Process an instance of TraitSelfType. */
    public RetType forTraitSelfType(TraitSelfType that);

    /** Process an instance of ObjectExprType. */
    public RetType forObjectExprType(ObjectExprType that);

    /** Process an instance of _InferenceVarType. */
    public RetType for_InferenceVarType(_InferenceVarType that);

    /** Process an instance of VarType. */
    public RetType forVarType(VarType that);

    /** Process an instance of TraitType. */
    public RetType forTraitType(TraitType that);

    /** Process an instance of ArrayType. */
    public RetType forArrayType(ArrayType that);

    /** Process an instance of MatrixType. */
    public RetType forMatrixType(MatrixType that);

    /** Process an instance of TaggedDimType. */
    public RetType forTaggedDimType(TaggedDimType that);

    /** Process an instance of TaggedUnitType. */
    public RetType forTaggedUnitType(TaggedUnitType that);

    /** Process an instance of TupleType. */
    public RetType forTupleType(TupleType that);

    /** Process an instance of ArrowType. */
    public RetType forArrowType(ArrowType that);

    /** Process an instance of IntersectionType. */
    public RetType forIntersectionType(IntersectionType that);

    /** Process an instance of UnionType. */
    public RetType forUnionType(UnionType that);

    /** Process an instance of FixedPointType. */
    public RetType forFixedPointType(FixedPointType that);

    /** Process an instance of LabelType. */
    public RetType forLabelType(LabelType that);

    /** Process an instance of DimBase. */
    public RetType forDimBase(DimBase that);

    /** Process an instance of DimRef. */
    public RetType forDimRef(DimRef that);

    /** Process an instance of DimExponent. */
    public RetType forDimExponent(DimExponent that);

    /** Process an instance of DimUnaryOp. */
    public RetType forDimUnaryOp(DimUnaryOp that);

    /** Process an instance of DimBinaryOp. */
    public RetType forDimBinaryOp(DimBinaryOp that);

    /** Process an instance of Pattern. */
    public RetType forPattern(Pattern that);

    /** Process an instance of PatternArgs. */
    public RetType forPatternArgs(PatternArgs that);

    /** Process an instance of PlainPattern. */
    public RetType forPlainPattern(PlainPattern that);

    /** Process an instance of TypePattern. */
    public RetType forTypePattern(TypePattern that);

    /** Process an instance of NestedPattern. */
    public RetType forNestedPattern(NestedPattern that);

    /** Process an instance of TypeArg. */
    public RetType forTypeArg(TypeArg that);

    /** Process an instance of IntArg. */
    public RetType forIntArg(IntArg that);

    /** Process an instance of BoolArg. */
    public RetType forBoolArg(BoolArg that);

    /** Process an instance of OpArg. */
    public RetType forOpArg(OpArg that);

    /** Process an instance of DimArg. */
    public RetType forDimArg(DimArg that);

    /** Process an instance of UnitArg. */
    public RetType forUnitArg(UnitArg that);

    /** Process an instance of IntBase. */
    public RetType forIntBase(IntBase that);

    /** Process an instance of IntRef. */
    public RetType forIntRef(IntRef that);

    /** Process an instance of IntBinaryOp. */
    public RetType forIntBinaryOp(IntBinaryOp that);

    /** Process an instance of BoolBase. */
    public RetType forBoolBase(BoolBase that);

    /** Process an instance of BoolRef. */
    public RetType forBoolRef(BoolRef that);

    /** Process an instance of BoolUnaryOp. */
    public RetType forBoolUnaryOp(BoolUnaryOp that);

    /** Process an instance of BoolBinaryOp. */
    public RetType forBoolBinaryOp(BoolBinaryOp that);

    /** Process an instance of UnitRef. */
    public RetType forUnitRef(UnitRef that);

    /** Process an instance of UnitBinaryOp. */
    public RetType forUnitBinaryOp(UnitBinaryOp that);

    /** Process an instance of Effect. */
    public RetType forEffect(Effect that);

    /** Process an instance of WhereClause. */
    public RetType forWhereClause(WhereClause that);

    /** Process an instance of WhereBinding. */
    public RetType forWhereBinding(WhereBinding that);

    /** Process an instance of WhereExtends. */
    public RetType forWhereExtends(WhereExtends that);

    /** Process an instance of WhereTypeAlias. */
    public RetType forWhereTypeAlias(WhereTypeAlias that);

    /** Process an instance of WhereCoerces. */
    public RetType forWhereCoerces(WhereCoerces that);

    /** Process an instance of WhereEquals. */
    public RetType forWhereEquals(WhereEquals that);

    /** Process an instance of UnitConstraint. */
    public RetType forUnitConstraint(UnitConstraint that);

    /** Process an instance of IntConstraint. */
    public RetType forIntConstraint(IntConstraint that);

    /** Process an instance of BoolConstraintExpr. */
    public RetType forBoolConstraintExpr(BoolConstraintExpr that);

    /** Process an instance of Contract. */
    public RetType forContract(Contract that);

    /** Process an instance of EnsuresClause. */
    public RetType forEnsuresClause(EnsuresClause that);

    /** Process an instance of StaticParam. */
    public RetType forStaticParam(StaticParam that);

    /** Process an instance of APIName. */
    public RetType forAPIName(APIName that);

    /** Process an instance of Id. */
    public RetType forId(Id that);

    /** Process an instance of NamedOp. */
    public RetType forNamedOp(NamedOp that);

    /** Process an instance of _InferenceVarOp. */
    public RetType for_InferenceVarOp(_InferenceVarOp that);

    /** Process an instance of AnonymousFnName. */
    public RetType forAnonymousFnName(AnonymousFnName that);

    /** Process an instance of ConstructorFnName. */
    public RetType forConstructorFnName(ConstructorFnName that);

    /** Process an instance of ArrayComprehensionClause. */
    public RetType forArrayComprehensionClause(ArrayComprehensionClause that);

    /** Process an instance of KeywordExpr. */
    public RetType forKeywordExpr(KeywordExpr that);

    /** Process an instance of CaseClause. */
    public RetType forCaseClause(CaseClause that);

    /** Process an instance of Catch. */
    public RetType forCatch(Catch that);

    /** Process an instance of CatchClause. */
    public RetType forCatchClause(CatchClause that);

    /** Process an instance of IfClause. */
    public RetType forIfClause(IfClause that);

    /** Process an instance of TypecaseClause. */
    public RetType forTypecaseClause(TypecaseClause that);

    /** Process an instance of ExtentRange. */
    public RetType forExtentRange(ExtentRange that);

    /** Process an instance of GeneratorClause. */
    public RetType forGeneratorClause(GeneratorClause that);

    /** Process an instance of KeywordType. */
    public RetType forKeywordType(KeywordType that);

    /** Process an instance of TraitTypeWhere. */
    public RetType forTraitTypeWhere(TraitTypeWhere that);

    /** Process an instance of Indices. */
    public RetType forIndices(Indices that);

    /** Process an instance of ParenthesisDelimitedMI. */
    public RetType forParenthesisDelimitedMI(ParenthesisDelimitedMI that);

    /** Process an instance of NonParenthesisDelimitedMI. */
    public RetType forNonParenthesisDelimitedMI(NonParenthesisDelimitedMI that);

    /** Process an instance of ExponentiationMI. */
    public RetType forExponentiationMI(ExponentiationMI that);

    /** Process an instance of SubscriptingMI. */
    public RetType forSubscriptingMI(SubscriptingMI that);

    /** Process an instance of Overloading. */
    public RetType forOverloading(Overloading that);

    /** Process an instance of NonterminalHeader. */
    public RetType forNonterminalHeader(NonterminalHeader that);

    /** Process an instance of NonterminalParameter. */
    public RetType forNonterminalParameter(NonterminalParameter that);

    /** Process an instance of SyntaxDef. */
    public RetType forSyntaxDef(SyntaxDef that);

    /** Process an instance of SuperSyntaxDef. */
    public RetType forSuperSyntaxDef(SuperSyntaxDef that);

    /** Process an instance of PreTransformerDef. */
    public RetType forPreTransformerDef(PreTransformerDef that);

    /** Process an instance of NamedTransformerDef. */
    public RetType forNamedTransformerDef(NamedTransformerDef that);

    /** Process an instance of UnparsedTransformer. */
    public RetType forUnparsedTransformer(UnparsedTransformer that);

    /** Process an instance of NodeTransformer. */
    public RetType forNodeTransformer(NodeTransformer that);

    /** Process an instance of CaseTransformer. */
    public RetType forCaseTransformer(CaseTransformer that);

    /** Process an instance of CaseTransformerClause. */
    public RetType forCaseTransformerClause(CaseTransformerClause that);

    /** Process an instance of PrefixedSymbol. */
    public RetType forPrefixedSymbol(PrefixedSymbol that);

    /** Process an instance of OptionalSymbol. */
    public RetType forOptionalSymbol(OptionalSymbol that);

    /** Process an instance of RepeatSymbol. */
    public RetType forRepeatSymbol(RepeatSymbol that);

    /** Process an instance of RepeatOneOrMoreSymbol. */
    public RetType forRepeatOneOrMoreSymbol(RepeatOneOrMoreSymbol that);

    /** Process an instance of NoWhitespaceSymbol. */
    public RetType forNoWhitespaceSymbol(NoWhitespaceSymbol that);

    /** Process an instance of GroupSymbol. */
    public RetType forGroupSymbol(GroupSymbol that);

    /** Process an instance of AnyCharacterSymbol. */
    public RetType forAnyCharacterSymbol(AnyCharacterSymbol that);

    /** Process an instance of WhitespaceSymbol. */
    public RetType forWhitespaceSymbol(WhitespaceSymbol that);

    /** Process an instance of TabSymbol. */
    public RetType forTabSymbol(TabSymbol that);

    /** Process an instance of FormfeedSymbol. */
    public RetType forFormfeedSymbol(FormfeedSymbol that);

    /** Process an instance of CarriageReturnSymbol. */
    public RetType forCarriageReturnSymbol(CarriageReturnSymbol that);

    /** Process an instance of BackspaceSymbol. */
    public RetType forBackspaceSymbol(BackspaceSymbol that);

    /** Process an instance of NewlineSymbol. */
    public RetType forNewlineSymbol(NewlineSymbol that);

    /** Process an instance of BreaklineSymbol. */
    public RetType forBreaklineSymbol(BreaklineSymbol that);

    /** Process an instance of ItemSymbol. */
    public RetType forItemSymbol(ItemSymbol that);

    /** Process an instance of NonterminalSymbol. */
    public RetType forNonterminalSymbol(NonterminalSymbol that);

    /** Process an instance of KeywordSymbol. */
    public RetType forKeywordSymbol(KeywordSymbol that);

    /** Process an instance of TokenSymbol. */
    public RetType forTokenSymbol(TokenSymbol that);

    /** Process an instance of NotPredicateSymbol. */
    public RetType forNotPredicateSymbol(NotPredicateSymbol that);

    /** Process an instance of AndPredicateSymbol. */
    public RetType forAndPredicateSymbol(AndPredicateSymbol that);

    /** Process an instance of CharacterClassSymbol. */
    public RetType forCharacterClassSymbol(CharacterClassSymbol that);

    /** Process an instance of CharSymbol. */
    public RetType forCharSymbol(CharSymbol that);

    /** Process an instance of CharacterInterval. */
    public RetType forCharacterInterval(CharacterInterval that);

    /** Process an instance of Link. */
    public RetType forLink(Link that);

    /** Process an instance of TraitTypeHeader. */
    public RetType forTraitTypeHeader(TraitTypeHeader that);

    /** Process an instance of FnHeader. */
    public RetType forFnHeader(FnHeader that);

    /** Process an instance of SpanInfo. */
    public RetType forSpanInfo(SpanInfo that);

    /** Process an instance of ExprInfo. */
    public RetType forExprInfo(ExprInfo that);

    /** Process an instance of TypeInfo. */
    public RetType forTypeInfo(TypeInfo that);

    /** Process an instance of MethodInfo. */
    public RetType forMethodInfo(MethodInfo that);

    /** Process an instance of CompoundAssignmentInfo. */
    public RetType forCompoundAssignmentInfo(CompoundAssignmentInfo that);

    /** Process an instance of Level. */
    public RetType forLevel(Level that);

    /** Process an instance of InFixity. */
    public RetType forInFixity(InFixity that);

    /** Process an instance of PreFixity. */
    public RetType forPreFixity(PreFixity that);

    /** Process an instance of PostFixity. */
    public RetType forPostFixity(PostFixity that);

    /** Process an instance of NoFixity. */
    public RetType forNoFixity(NoFixity that);

    /** Process an instance of MultiFixity. */
    public RetType forMultiFixity(MultiFixity that);

    /** Process an instance of EnclosingFixity. */
    public RetType forEnclosingFixity(EnclosingFixity that);

    /** Process an instance of BigFixity. */
    public RetType forBigFixity(BigFixity that);

    /** Process an instance of UnknownFixity. */
    public RetType forUnknownFixity(UnknownFixity that);

    /** Process an instance of KindType. */
    public RetType forKindType(KindType that);

    /** Process an instance of KindInt. */
    public RetType forKindInt(KindInt that);

    /** Process an instance of KindNat. */
    public RetType forKindNat(KindNat that);

    /** Process an instance of KindBool. */
    public RetType forKindBool(KindBool that);

    /** Process an instance of KindDim. */
    public RetType forKindDim(KindDim that);

    /** Process an instance of KindUnit. */
    public RetType forKindUnit(KindUnit that);

    /** Process an instance of KindOp. */
    public RetType forKindOp(KindOp that);

    /** Process an instance of _SyntaxTransformationAbstractNode. */
    public RetType for_SyntaxTransformationAbstractNode(_SyntaxTransformationAbstractNode that);

    /** Process an instance of _SyntaxTransformationCompilationUnit. */
    public RetType for_SyntaxTransformationCompilationUnit(_SyntaxTransformationCompilationUnit that);

    /** Process an instance of _SyntaxTransformationComponent. */
    public RetType for_SyntaxTransformationComponent(_SyntaxTransformationComponent that);

    /** Process an instance of _SyntaxTransformationApi. */
    public RetType for_SyntaxTransformationApi(_SyntaxTransformationApi that);

    /** Process an instance of _SyntaxTransformationImport. */
    public RetType for_SyntaxTransformationImport(_SyntaxTransformationImport that);

    /** Process an instance of _SyntaxTransformationImportedNames. */
    public RetType for_SyntaxTransformationImportedNames(_SyntaxTransformationImportedNames that);

    /** Process an instance of _SyntaxTransformationImportStar. */
    public RetType for_SyntaxTransformationImportStar(_SyntaxTransformationImportStar that);

    /** Process an instance of _SyntaxTransformationImportNames. */
    public RetType for_SyntaxTransformationImportNames(_SyntaxTransformationImportNames that);

    /** Process an instance of _SyntaxTransformationImportApi. */
    public RetType for_SyntaxTransformationImportApi(_SyntaxTransformationImportApi that);

    /** Process an instance of _SyntaxTransformationAliasedSimpleName. */
    public RetType for_SyntaxTransformationAliasedSimpleName(_SyntaxTransformationAliasedSimpleName that);

    /** Process an instance of _SyntaxTransformationAliasedAPIName. */
    public RetType for_SyntaxTransformationAliasedAPIName(_SyntaxTransformationAliasedAPIName that);

    /** Process an instance of _SyntaxTransformationDecl. */
    public RetType for_SyntaxTransformationDecl(_SyntaxTransformationDecl that);

    /** Process an instance of _SyntaxTransformationTraitObjectDecl. */
    public RetType for_SyntaxTransformationTraitObjectDecl(_SyntaxTransformationTraitObjectDecl that);

    /** Process an instance of _SyntaxTransformationTraitDecl. */
    public RetType for_SyntaxTransformationTraitDecl(_SyntaxTransformationTraitDecl that);

    /** Process an instance of _SyntaxTransformationObjectDecl. */
    public RetType for_SyntaxTransformationObjectDecl(_SyntaxTransformationObjectDecl that);

    /** Process an instance of _SyntaxTransformationVarDecl. */
    public RetType for_SyntaxTransformationVarDecl(_SyntaxTransformationVarDecl that);

    /** Process an instance of _SyntaxTransformationFnDecl. */
    public RetType for_SyntaxTransformationFnDecl(_SyntaxTransformationFnDecl that);

    /** Process an instance of _SyntaxTransformation_RewriteFnOverloadDecl. */
    public RetType for_SyntaxTransformation_RewriteFnOverloadDecl(_SyntaxTransformation_RewriteFnOverloadDecl that);

    /** Process an instance of _SyntaxTransformation_RewriteObjectExprDecl. */
    public RetType for_SyntaxTransformation_RewriteObjectExprDecl(_SyntaxTransformation_RewriteObjectExprDecl that);

    /** Process an instance of _SyntaxTransformation_RewriteFunctionalMethodDecl. */
    public RetType for_SyntaxTransformation_RewriteFunctionalMethodDecl(_SyntaxTransformation_RewriteFunctionalMethodDecl that);

    /** Process an instance of _SyntaxTransformationDimUnitDecl. */
    public RetType for_SyntaxTransformationDimUnitDecl(_SyntaxTransformationDimUnitDecl that);

    /** Process an instance of _SyntaxTransformationDimDecl. */
    public RetType for_SyntaxTransformationDimDecl(_SyntaxTransformationDimDecl that);

    /** Process an instance of _SyntaxTransformationUnitDecl. */
    public RetType for_SyntaxTransformationUnitDecl(_SyntaxTransformationUnitDecl that);

    /** Process an instance of _SyntaxTransformationTestDecl. */
    public RetType for_SyntaxTransformationTestDecl(_SyntaxTransformationTestDecl that);

    /** Process an instance of _SyntaxTransformationPropertyDecl. */
    public RetType for_SyntaxTransformationPropertyDecl(_SyntaxTransformationPropertyDecl that);

    /** Process an instance of _SyntaxTransformationTypeAlias. */
    public RetType for_SyntaxTransformationTypeAlias(_SyntaxTransformationTypeAlias that);

    /** Process an instance of _SyntaxTransformationGrammarDecl. */
    public RetType for_SyntaxTransformationGrammarDecl(_SyntaxTransformationGrammarDecl that);

    /** Process an instance of _SyntaxTransformationGrammarMemberDecl. */
    public RetType for_SyntaxTransformationGrammarMemberDecl(_SyntaxTransformationGrammarMemberDecl that);

    /** Process an instance of _SyntaxTransformationNonterminalDecl. */
    public RetType for_SyntaxTransformationNonterminalDecl(_SyntaxTransformationNonterminalDecl that);

    /** Process an instance of _SyntaxTransformationNonterminalDef. */
    public RetType for_SyntaxTransformationNonterminalDef(_SyntaxTransformationNonterminalDef that);

    /** Process an instance of _SyntaxTransformationNonterminalExtensionDef. */
    public RetType for_SyntaxTransformationNonterminalExtensionDef(_SyntaxTransformationNonterminalExtensionDef that);

    /** Process an instance of _SyntaxTransformationBinding. */
    public RetType for_SyntaxTransformationBinding(_SyntaxTransformationBinding that);

    /** Process an instance of _SyntaxTransformationLValue. */
    public RetType for_SyntaxTransformationLValue(_SyntaxTransformationLValue that);

    /** Process an instance of _SyntaxTransformationParam. */
    public RetType for_SyntaxTransformationParam(_SyntaxTransformationParam that);

    /** Process an instance of _SyntaxTransformationExpr. */
    public RetType for_SyntaxTransformationExpr(_SyntaxTransformationExpr that);

    /** Process an instance of _SyntaxTransformationDummyExpr. */
    public RetType for_SyntaxTransformationDummyExpr(_SyntaxTransformationDummyExpr that);

    /** Process an instance of _SyntaxTransformationTypeAnnotatedExpr. */
    public RetType for_SyntaxTransformationTypeAnnotatedExpr(_SyntaxTransformationTypeAnnotatedExpr that);

    /** Process an instance of _SyntaxTransformationAsExpr. */
    public RetType for_SyntaxTransformationAsExpr(_SyntaxTransformationAsExpr that);

    /** Process an instance of _SyntaxTransformationAsIfExpr. */
    public RetType for_SyntaxTransformationAsIfExpr(_SyntaxTransformationAsIfExpr that);

    /** Process an instance of _SyntaxTransformationAssignment. */
    public RetType for_SyntaxTransformationAssignment(_SyntaxTransformationAssignment that);

    /** Process an instance of _SyntaxTransformationBlock. */
    public RetType for_SyntaxTransformationBlock(_SyntaxTransformationBlock that);

    /** Process an instance of _SyntaxTransformationDo. */
    public RetType for_SyntaxTransformationDo(_SyntaxTransformationDo that);

    /** Process an instance of _SyntaxTransformationCaseExpr. */
    public RetType for_SyntaxTransformationCaseExpr(_SyntaxTransformationCaseExpr that);

    /** Process an instance of _SyntaxTransformationIf. */
    public RetType for_SyntaxTransformationIf(_SyntaxTransformationIf that);

    /** Process an instance of _SyntaxTransformationLabel. */
    public RetType for_SyntaxTransformationLabel(_SyntaxTransformationLabel that);

    /** Process an instance of _SyntaxTransformationAbstractObjectExpr. */
    public RetType for_SyntaxTransformationAbstractObjectExpr(_SyntaxTransformationAbstractObjectExpr that);

    /** Process an instance of _SyntaxTransformationObjectExpr. */
    public RetType for_SyntaxTransformationObjectExpr(_SyntaxTransformationObjectExpr that);

    /** Process an instance of _SyntaxTransformation_RewriteObjectExpr. */
    public RetType for_SyntaxTransformation_RewriteObjectExpr(_SyntaxTransformation_RewriteObjectExpr that);

    /** Process an instance of _SyntaxTransformationTry. */
    public RetType for_SyntaxTransformationTry(_SyntaxTransformationTry that);

    /** Process an instance of _SyntaxTransformationTupleExpr. */
    public RetType for_SyntaxTransformationTupleExpr(_SyntaxTransformationTupleExpr that);

    /** Process an instance of _SyntaxTransformationTypecase. */
    public RetType for_SyntaxTransformationTypecase(_SyntaxTransformationTypecase that);

    /** Process an instance of _SyntaxTransformationWhile. */
    public RetType for_SyntaxTransformationWhile(_SyntaxTransformationWhile that);

    /** Process an instance of _SyntaxTransformationFor. */
    public RetType for_SyntaxTransformationFor(_SyntaxTransformationFor that);

    /** Process an instance of _SyntaxTransformationBigOpApp. */
    public RetType for_SyntaxTransformationBigOpApp(_SyntaxTransformationBigOpApp that);

    /** Process an instance of _SyntaxTransformationAccumulator. */
    public RetType for_SyntaxTransformationAccumulator(_SyntaxTransformationAccumulator that);

    /** Process an instance of _SyntaxTransformationArrayComprehension. */
    public RetType for_SyntaxTransformationArrayComprehension(_SyntaxTransformationArrayComprehension that);

    /** Process an instance of _SyntaxTransformationAtomicExpr. */
    public RetType for_SyntaxTransformationAtomicExpr(_SyntaxTransformationAtomicExpr that);

    /** Process an instance of _SyntaxTransformationExit. */
    public RetType for_SyntaxTransformationExit(_SyntaxTransformationExit that);

    /** Process an instance of _SyntaxTransformationSpawn. */
    public RetType for_SyntaxTransformationSpawn(_SyntaxTransformationSpawn that);

    /** Process an instance of _SyntaxTransformationThrow. */
    public RetType for_SyntaxTransformationThrow(_SyntaxTransformationThrow that);

    /** Process an instance of _SyntaxTransformationTryAtomicExpr. */
    public RetType for_SyntaxTransformationTryAtomicExpr(_SyntaxTransformationTryAtomicExpr that);

    /** Process an instance of _SyntaxTransformationFnExpr. */
    public RetType for_SyntaxTransformationFnExpr(_SyntaxTransformationFnExpr that);

    /** Process an instance of _SyntaxTransformationLetExpr. */
    public RetType for_SyntaxTransformationLetExpr(_SyntaxTransformationLetExpr that);

    /** Process an instance of _SyntaxTransformationLetFn. */
    public RetType for_SyntaxTransformationLetFn(_SyntaxTransformationLetFn that);

    /** Process an instance of _SyntaxTransformationLocalVarDecl. */
    public RetType for_SyntaxTransformationLocalVarDecl(_SyntaxTransformationLocalVarDecl that);

    /** Process an instance of _SyntaxTransformationSimpleExpr. */
    public RetType for_SyntaxTransformationSimpleExpr(_SyntaxTransformationSimpleExpr that);

    /** Process an instance of _SyntaxTransformationSubscriptExpr. */
    public RetType for_SyntaxTransformationSubscriptExpr(_SyntaxTransformationSubscriptExpr that);

    /** Process an instance of _SyntaxTransformationPrimary. */
    public RetType for_SyntaxTransformationPrimary(_SyntaxTransformationPrimary that);

    /** Process an instance of _SyntaxTransformationLiteralExpr. */
    public RetType for_SyntaxTransformationLiteralExpr(_SyntaxTransformationLiteralExpr that);

    /** Process an instance of _SyntaxTransformationNumberLiteralExpr. */
    public RetType for_SyntaxTransformationNumberLiteralExpr(_SyntaxTransformationNumberLiteralExpr that);

    /** Process an instance of _SyntaxTransformationFloatLiteralExpr. */
    public RetType for_SyntaxTransformationFloatLiteralExpr(_SyntaxTransformationFloatLiteralExpr that);

    /** Process an instance of _SyntaxTransformationIntLiteralExpr. */
    public RetType for_SyntaxTransformationIntLiteralExpr(_SyntaxTransformationIntLiteralExpr that);

    /** Process an instance of _SyntaxTransformationCharLiteralExpr. */
    public RetType for_SyntaxTransformationCharLiteralExpr(_SyntaxTransformationCharLiteralExpr that);

    /** Process an instance of _SyntaxTransformationStringLiteralExpr. */
    public RetType for_SyntaxTransformationStringLiteralExpr(_SyntaxTransformationStringLiteralExpr that);

    /** Process an instance of _SyntaxTransformationVoidLiteralExpr. */
    public RetType for_SyntaxTransformationVoidLiteralExpr(_SyntaxTransformationVoidLiteralExpr that);

    /** Process an instance of _SyntaxTransformationBooleanLiteralExpr. */
    public RetType for_SyntaxTransformationBooleanLiteralExpr(_SyntaxTransformationBooleanLiteralExpr that);

    /** Process an instance of _SyntaxTransformationVarRef. */
    public RetType for_SyntaxTransformationVarRef(_SyntaxTransformationVarRef that);

    /** Process an instance of _SyntaxTransformationFieldRef. */
    public RetType for_SyntaxTransformationFieldRef(_SyntaxTransformationFieldRef that);

    /** Process an instance of _SyntaxTransformationFunctionalRef. */
    public RetType for_SyntaxTransformationFunctionalRef(_SyntaxTransformationFunctionalRef that);

    /** Process an instance of _SyntaxTransformationFnRef. */
    public RetType for_SyntaxTransformationFnRef(_SyntaxTransformationFnRef that);

    /** Process an instance of _SyntaxTransformationOpRef. */
    public RetType for_SyntaxTransformationOpRef(_SyntaxTransformationOpRef that);

    /** Process an instance of _SyntaxTransformation_RewriteFnRef. */
    public RetType for_SyntaxTransformation_RewriteFnRef(_SyntaxTransformation_RewriteFnRef that);

    /** Process an instance of _SyntaxTransformation_RewriteObjectExprRef. */
    public RetType for_SyntaxTransformation_RewriteObjectExprRef(_SyntaxTransformation_RewriteObjectExprRef that);

    /** Process an instance of _SyntaxTransformationJuxt. */
    public RetType for_SyntaxTransformationJuxt(_SyntaxTransformationJuxt that);

    /** Process an instance of _SyntaxTransformation_RewriteFnApp. */
    public RetType for_SyntaxTransformation_RewriteFnApp(_SyntaxTransformation_RewriteFnApp that);

    /** Process an instance of _SyntaxTransformationOpExpr. */
    public RetType for_SyntaxTransformationOpExpr(_SyntaxTransformationOpExpr that);

    /** Process an instance of _SyntaxTransformationAmbiguousMultifixOpExpr. */
    public RetType for_SyntaxTransformationAmbiguousMultifixOpExpr(_SyntaxTransformationAmbiguousMultifixOpExpr that);

    /** Process an instance of _SyntaxTransformationChainExpr. */
    public RetType for_SyntaxTransformationChainExpr(_SyntaxTransformationChainExpr that);

    /** Process an instance of _SyntaxTransformationCoercionInvocation. */
    public RetType for_SyntaxTransformationCoercionInvocation(_SyntaxTransformationCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationTraitCoercionInvocation. */
    public RetType for_SyntaxTransformationTraitCoercionInvocation(_SyntaxTransformationTraitCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationTupleCoercionInvocation. */
    public RetType for_SyntaxTransformationTupleCoercionInvocation(_SyntaxTransformationTupleCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationArrowCoercionInvocation. */
    public RetType for_SyntaxTransformationArrowCoercionInvocation(_SyntaxTransformationArrowCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationUnionCoercionInvocation. */
    public RetType for_SyntaxTransformationUnionCoercionInvocation(_SyntaxTransformationUnionCoercionInvocation that);

    /** Process an instance of _SyntaxTransformationMethodInvocation. */
    public RetType for_SyntaxTransformationMethodInvocation(_SyntaxTransformationMethodInvocation that);

    /** Process an instance of _SyntaxTransformationMathPrimary. */
    public RetType for_SyntaxTransformationMathPrimary(_SyntaxTransformationMathPrimary that);

    /** Process an instance of _SyntaxTransformationArrayExpr. */
    public RetType for_SyntaxTransformationArrayExpr(_SyntaxTransformationArrayExpr that);

    /** Process an instance of _SyntaxTransformationArrayElement. */
    public RetType for_SyntaxTransformationArrayElement(_SyntaxTransformationArrayElement that);

    /** Process an instance of _SyntaxTransformationArrayElements. */
    public RetType for_SyntaxTransformationArrayElements(_SyntaxTransformationArrayElements that);

    /** Process an instance of _SyntaxTransformationType. */
    public RetType for_SyntaxTransformationType(_SyntaxTransformationType that);

    /** Process an instance of _SyntaxTransformationBaseType. */
    public RetType for_SyntaxTransformationBaseType(_SyntaxTransformationBaseType that);

    /** Process an instance of _SyntaxTransformationAnyType. */
    public RetType for_SyntaxTransformationAnyType(_SyntaxTransformationAnyType that);

    /** Process an instance of _SyntaxTransformationBottomType. */
    public RetType for_SyntaxTransformationBottomType(_SyntaxTransformationBottomType that);

    /** Process an instance of _SyntaxTransformationUnknownType. */
    public RetType for_SyntaxTransformationUnknownType(_SyntaxTransformationUnknownType that);

    /** Process an instance of _SyntaxTransformationSelfType. */
    public RetType for_SyntaxTransformationSelfType(_SyntaxTransformationSelfType that);

    /** Process an instance of _SyntaxTransformationTraitSelfType. */
    public RetType for_SyntaxTransformationTraitSelfType(_SyntaxTransformationTraitSelfType that);

    /** Process an instance of _SyntaxTransformationObjectExprType. */
    public RetType for_SyntaxTransformationObjectExprType(_SyntaxTransformationObjectExprType that);

    /** Process an instance of _SyntaxTransformationNamedType. */
    public RetType for_SyntaxTransformationNamedType(_SyntaxTransformationNamedType that);

    /** Process an instance of _SyntaxTransformation_InferenceVarType. */
    public RetType for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that);

    /** Process an instance of _SyntaxTransformationVarType. */
    public RetType for_SyntaxTransformationVarType(_SyntaxTransformationVarType that);

    /** Process an instance of _SyntaxTransformationTraitType. */
    public RetType for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that);

    /** Process an instance of _SyntaxTransformationAbbreviatedType. */
    public RetType for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that);

    /** Process an instance of _SyntaxTransformationArrayType. */
    public RetType for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that);

    /** Process an instance of _SyntaxTransformationMatrixType. */
    public RetType for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that);

    /** Process an instance of _SyntaxTransformationTaggedDimType. */
    public RetType for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that);

    /** Process an instance of _SyntaxTransformationTaggedUnitType. */
    public RetType for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that);

    /** Process an instance of _SyntaxTransformationTupleType. */
    public RetType for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that);

    /** Process an instance of _SyntaxTransformationArrowType. */
    public RetType for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that);

    /** Process an instance of _SyntaxTransformationBoundType. */
    public RetType for_SyntaxTransformationBoundType(_SyntaxTransformationBoundType that);

    /** Process an instance of _SyntaxTransformationIntersectionType. */
    public RetType for_SyntaxTransformationIntersectionType(_SyntaxTransformationIntersectionType that);

    /** Process an instance of _SyntaxTransformationUnionType. */
    public RetType for_SyntaxTransformationUnionType(_SyntaxTransformationUnionType that);

    /** Process an instance of _SyntaxTransformationFixedPointType. */
    public RetType for_SyntaxTransformationFixedPointType(_SyntaxTransformationFixedPointType that);

    /** Process an instance of _SyntaxTransformationLabelType. */
    public RetType for_SyntaxTransformationLabelType(_SyntaxTransformationLabelType that);

    /** Process an instance of _SyntaxTransformationDimExpr. */
    public RetType for_SyntaxTransformationDimExpr(_SyntaxTransformationDimExpr that);

    /** Process an instance of _SyntaxTransformationDimBase. */
    public RetType for_SyntaxTransformationDimBase(_SyntaxTransformationDimBase that);

    /** Process an instance of _SyntaxTransformationDimRef. */
    public RetType for_SyntaxTransformationDimRef(_SyntaxTransformationDimRef that);

    /** Process an instance of _SyntaxTransformationDimExponent. */
    public RetType for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that);

    /** Process an instance of _SyntaxTransformationDimUnaryOp. */
    public RetType for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that);

    /** Process an instance of _SyntaxTransformationDimBinaryOp. */
    public RetType for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that);

    /** Process an instance of _SyntaxTransformationPattern. */
    public RetType for_SyntaxTransformationPattern(_SyntaxTransformationPattern that);

    /** Process an instance of _SyntaxTransformationPatternArgs. */
    public RetType for_SyntaxTransformationPatternArgs(_SyntaxTransformationPatternArgs that);

    /** Process an instance of _SyntaxTransformationPatternBinding. */
    public RetType for_SyntaxTransformationPatternBinding(_SyntaxTransformationPatternBinding that);

    /** Process an instance of _SyntaxTransformationPlainPattern. */
    public RetType for_SyntaxTransformationPlainPattern(_SyntaxTransformationPlainPattern that);

    /** Process an instance of _SyntaxTransformationTypePattern. */
    public RetType for_SyntaxTransformationTypePattern(_SyntaxTransformationTypePattern that);

    /** Process an instance of _SyntaxTransformationNestedPattern. */
    public RetType for_SyntaxTransformationNestedPattern(_SyntaxTransformationNestedPattern that);

    /** Process an instance of _SyntaxTransformationStaticArg. */
    public RetType for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that);

    /** Process an instance of _SyntaxTransformationTypeArg. */
    public RetType for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that);

    /** Process an instance of _SyntaxTransformationIntArg. */
    public RetType for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that);

    /** Process an instance of _SyntaxTransformationBoolArg. */
    public RetType for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that);

    /** Process an instance of _SyntaxTransformationOpArg. */
    public RetType for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that);

    /** Process an instance of _SyntaxTransformationDimArg. */
    public RetType for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that);

    /** Process an instance of _SyntaxTransformationUnitArg. */
    public RetType for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that);

    /** Process an instance of _SyntaxTransformationStaticExpr. */
    public RetType for_SyntaxTransformationStaticExpr(_SyntaxTransformationStaticExpr that);

    /** Process an instance of _SyntaxTransformationIntExpr. */
    public RetType for_SyntaxTransformationIntExpr(_SyntaxTransformationIntExpr that);

    /** Process an instance of _SyntaxTransformationIntBase. */
    public RetType for_SyntaxTransformationIntBase(_SyntaxTransformationIntBase that);

    /** Process an instance of _SyntaxTransformationIntRef. */
    public RetType for_SyntaxTransformationIntRef(_SyntaxTransformationIntRef that);

    /** Process an instance of _SyntaxTransformationIntBinaryOp. */
    public RetType for_SyntaxTransformationIntBinaryOp(_SyntaxTransformationIntBinaryOp that);

    /** Process an instance of _SyntaxTransformationBoolExpr. */
    public RetType for_SyntaxTransformationBoolExpr(_SyntaxTransformationBoolExpr that);

    /** Process an instance of _SyntaxTransformationBoolBase. */
    public RetType for_SyntaxTransformationBoolBase(_SyntaxTransformationBoolBase that);

    /** Process an instance of _SyntaxTransformationBoolRef. */
    public RetType for_SyntaxTransformationBoolRef(_SyntaxTransformationBoolRef that);

    /** Process an instance of _SyntaxTransformationBoolConstraint. */
    public RetType for_SyntaxTransformationBoolConstraint(_SyntaxTransformationBoolConstraint that);

    /** Process an instance of _SyntaxTransformationBoolUnaryOp. */
    public RetType for_SyntaxTransformationBoolUnaryOp(_SyntaxTransformationBoolUnaryOp that);

    /** Process an instance of _SyntaxTransformationBoolBinaryOp. */
    public RetType for_SyntaxTransformationBoolBinaryOp(_SyntaxTransformationBoolBinaryOp that);

    /** Process an instance of _SyntaxTransformationUnitExpr. */
    public RetType for_SyntaxTransformationUnitExpr(_SyntaxTransformationUnitExpr that);

    /** Process an instance of _SyntaxTransformationUnitRef. */
    public RetType for_SyntaxTransformationUnitRef(_SyntaxTransformationUnitRef that);

    /** Process an instance of _SyntaxTransformationUnitBinaryOp. */
    public RetType for_SyntaxTransformationUnitBinaryOp(_SyntaxTransformationUnitBinaryOp that);

    /** Process an instance of _SyntaxTransformationEffect. */
    public RetType for_SyntaxTransformationEffect(_SyntaxTransformationEffect that);

    /** Process an instance of _SyntaxTransformationWhereClause. */
    public RetType for_SyntaxTransformationWhereClause(_SyntaxTransformationWhereClause that);

    /** Process an instance of _SyntaxTransformationWhereBinding. */
    public RetType for_SyntaxTransformationWhereBinding(_SyntaxTransformationWhereBinding that);

    /** Process an instance of _SyntaxTransformationWhereConstraint. */
    public RetType for_SyntaxTransformationWhereConstraint(_SyntaxTransformationWhereConstraint that);

    /** Process an instance of _SyntaxTransformationWhereExtends. */
    public RetType for_SyntaxTransformationWhereExtends(_SyntaxTransformationWhereExtends that);

    /** Process an instance of _SyntaxTransformationWhereTypeAlias. */
    public RetType for_SyntaxTransformationWhereTypeAlias(_SyntaxTransformationWhereTypeAlias that);

    /** Process an instance of _SyntaxTransformationWhereCoerces. */
    public RetType for_SyntaxTransformationWhereCoerces(_SyntaxTransformationWhereCoerces that);

    /** Process an instance of _SyntaxTransformationWhereEquals. */
    public RetType for_SyntaxTransformationWhereEquals(_SyntaxTransformationWhereEquals that);

    /** Process an instance of _SyntaxTransformationUnitConstraint. */
    public RetType for_SyntaxTransformationUnitConstraint(_SyntaxTransformationUnitConstraint that);

    /** Process an instance of _SyntaxTransformationIntConstraint. */
    public RetType for_SyntaxTransformationIntConstraint(_SyntaxTransformationIntConstraint that);

    /** Process an instance of _SyntaxTransformationBoolConstraintExpr. */
    public RetType for_SyntaxTransformationBoolConstraintExpr(_SyntaxTransformationBoolConstraintExpr that);

    /** Process an instance of _SyntaxTransformationContract. */
    public RetType for_SyntaxTransformationContract(_SyntaxTransformationContract that);

    /** Process an instance of _SyntaxTransformationEnsuresClause. */
    public RetType for_SyntaxTransformationEnsuresClause(_SyntaxTransformationEnsuresClause that);

    /** Process an instance of _SyntaxTransformationStaticParam. */
    public RetType for_SyntaxTransformationStaticParam(_SyntaxTransformationStaticParam that);

    /** Process an instance of _SyntaxTransformationName. */
    public RetType for_SyntaxTransformationName(_SyntaxTransformationName that);

    /** Process an instance of _SyntaxTransformationAPIName. */
    public RetType for_SyntaxTransformationAPIName(_SyntaxTransformationAPIName that);

    /** Process an instance of _SyntaxTransformationIdOrOpOrAnonymousName. */
    public RetType for_SyntaxTransformationIdOrOpOrAnonymousName(_SyntaxTransformationIdOrOpOrAnonymousName that);

    /** Process an instance of _SyntaxTransformationIdOrOp. */
    public RetType for_SyntaxTransformationIdOrOp(_SyntaxTransformationIdOrOp that);

    /** Process an instance of _SyntaxTransformationId. */
    public RetType for_SyntaxTransformationId(_SyntaxTransformationId that);

    /** Process an instance of _SyntaxTransformationOp. */
    public RetType for_SyntaxTransformationOp(_SyntaxTransformationOp that);

    /** Process an instance of _SyntaxTransformationNamedOp. */
    public RetType for_SyntaxTransformationNamedOp(_SyntaxTransformationNamedOp that);

    /** Process an instance of _SyntaxTransformation_InferenceVarOp. */
    public RetType for_SyntaxTransformation_InferenceVarOp(_SyntaxTransformation_InferenceVarOp that);

    /** Process an instance of _SyntaxTransformationAnonymousName. */
    public RetType for_SyntaxTransformationAnonymousName(_SyntaxTransformationAnonymousName that);

    /** Process an instance of _SyntaxTransformationAnonymousFnName. */
    public RetType for_SyntaxTransformationAnonymousFnName(_SyntaxTransformationAnonymousFnName that);

    /** Process an instance of _SyntaxTransformationConstructorFnName. */
    public RetType for_SyntaxTransformationConstructorFnName(_SyntaxTransformationConstructorFnName that);

    /** Process an instance of _SyntaxTransformationArrayComprehensionClause. */
    public RetType for_SyntaxTransformationArrayComprehensionClause(_SyntaxTransformationArrayComprehensionClause that);

    /** Process an instance of _SyntaxTransformationKeywordExpr. */
    public RetType for_SyntaxTransformationKeywordExpr(_SyntaxTransformationKeywordExpr that);

    /** Process an instance of _SyntaxTransformationCaseClause. */
    public RetType for_SyntaxTransformationCaseClause(_SyntaxTransformationCaseClause that);

    /** Process an instance of _SyntaxTransformationCatch. */
    public RetType for_SyntaxTransformationCatch(_SyntaxTransformationCatch that);

    /** Process an instance of _SyntaxTransformationCatchClause. */
    public RetType for_SyntaxTransformationCatchClause(_SyntaxTransformationCatchClause that);

    /** Process an instance of _SyntaxTransformationIfClause. */
    public RetType for_SyntaxTransformationIfClause(_SyntaxTransformationIfClause that);

    /** Process an instance of _SyntaxTransformationTypecaseClause. */
    public RetType for_SyntaxTransformationTypecaseClause(_SyntaxTransformationTypecaseClause that);

    /** Process an instance of _SyntaxTransformationExtentRange. */
    public RetType for_SyntaxTransformationExtentRange(_SyntaxTransformationExtentRange that);

    /** Process an instance of _SyntaxTransformationGeneratorClause. */
    public RetType for_SyntaxTransformationGeneratorClause(_SyntaxTransformationGeneratorClause that);

    /** Process an instance of _SyntaxTransformationKeywordType. */
    public RetType for_SyntaxTransformationKeywordType(_SyntaxTransformationKeywordType that);

    /** Process an instance of _SyntaxTransformationTraitTypeWhere. */
    public RetType for_SyntaxTransformationTraitTypeWhere(_SyntaxTransformationTraitTypeWhere that);

    /** Process an instance of _SyntaxTransformationIndices. */
    public RetType for_SyntaxTransformationIndices(_SyntaxTransformationIndices that);

    /** Process an instance of _SyntaxTransformationMathItem. */
    public RetType for_SyntaxTransformationMathItem(_SyntaxTransformationMathItem that);

    /** Process an instance of _SyntaxTransformationExprMI. */
    public RetType for_SyntaxTransformationExprMI(_SyntaxTransformationExprMI that);

    /** Process an instance of _SyntaxTransformationParenthesisDelimitedMI. */
    public RetType for_SyntaxTransformationParenthesisDelimitedMI(_SyntaxTransformationParenthesisDelimitedMI that);

    /** Process an instance of _SyntaxTransformationNonParenthesisDelimitedMI. */
    public RetType for_SyntaxTransformationNonParenthesisDelimitedMI(_SyntaxTransformationNonParenthesisDelimitedMI that);

    /** Process an instance of _SyntaxTransformationNonExprMI. */
    public RetType for_SyntaxTransformationNonExprMI(_SyntaxTransformationNonExprMI that);

    /** Process an instance of _SyntaxTransformationExponentiationMI. */
    public RetType for_SyntaxTransformationExponentiationMI(_SyntaxTransformationExponentiationMI that);

    /** Process an instance of _SyntaxTransformationSubscriptingMI. */
    public RetType for_SyntaxTransformationSubscriptingMI(_SyntaxTransformationSubscriptingMI that);

    /** Process an instance of _SyntaxTransformationOverloading. */
    public RetType for_SyntaxTransformationOverloading(_SyntaxTransformationOverloading that);

    /** Process an instance of _SyntaxTransformationNonterminalHeader. */
    public RetType for_SyntaxTransformationNonterminalHeader(_SyntaxTransformationNonterminalHeader that);

    /** Process an instance of _SyntaxTransformationNonterminalParameter. */
    public RetType for_SyntaxTransformationNonterminalParameter(_SyntaxTransformationNonterminalParameter that);

    /** Process an instance of _SyntaxTransformationSyntaxDecl. */
    public RetType for_SyntaxTransformationSyntaxDecl(_SyntaxTransformationSyntaxDecl that);

    /** Process an instance of _SyntaxTransformationSyntaxDef. */
    public RetType for_SyntaxTransformationSyntaxDef(_SyntaxTransformationSyntaxDef that);

    /** Process an instance of _SyntaxTransformationSuperSyntaxDef. */
    public RetType for_SyntaxTransformationSuperSyntaxDef(_SyntaxTransformationSuperSyntaxDef that);

    /** Process an instance of _SyntaxTransformationTransformerDecl. */
    public RetType for_SyntaxTransformationTransformerDecl(_SyntaxTransformationTransformerDecl that);

    /** Process an instance of _SyntaxTransformationPreTransformerDef. */
    public RetType for_SyntaxTransformationPreTransformerDef(_SyntaxTransformationPreTransformerDef that);

    /** Process an instance of _SyntaxTransformationNamedTransformerDef. */
    public RetType for_SyntaxTransformationNamedTransformerDef(_SyntaxTransformationNamedTransformerDef that);

    /** Process an instance of _SyntaxTransformationTransformer. */
    public RetType for_SyntaxTransformationTransformer(_SyntaxTransformationTransformer that);

    /** Process an instance of _SyntaxTransformationUnparsedTransformer. */
    public RetType for_SyntaxTransformationUnparsedTransformer(_SyntaxTransformationUnparsedTransformer that);

    /** Process an instance of _SyntaxTransformationNodeTransformer. */
    public RetType for_SyntaxTransformationNodeTransformer(_SyntaxTransformationNodeTransformer that);

    /** Process an instance of _SyntaxTransformationCaseTransformer. */
    public RetType for_SyntaxTransformationCaseTransformer(_SyntaxTransformationCaseTransformer that);

    /** Process an instance of _SyntaxTransformationCaseTransformerClause. */
    public RetType for_SyntaxTransformationCaseTransformerClause(_SyntaxTransformationCaseTransformerClause that);

    /** Process an instance of _SyntaxTransformationSyntaxSymbol. */
    public RetType for_SyntaxTransformationSyntaxSymbol(_SyntaxTransformationSyntaxSymbol that);

    /** Process an instance of _SyntaxTransformationPrefixedSymbol. */
    public RetType for_SyntaxTransformationPrefixedSymbol(_SyntaxTransformationPrefixedSymbol that);

    /** Process an instance of _SyntaxTransformationOptionalSymbol. */
    public RetType for_SyntaxTransformationOptionalSymbol(_SyntaxTransformationOptionalSymbol that);

    /** Process an instance of _SyntaxTransformationRepeatSymbol. */
    public RetType for_SyntaxTransformationRepeatSymbol(_SyntaxTransformationRepeatSymbol that);

    /** Process an instance of _SyntaxTransformationRepeatOneOrMoreSymbol. */
    public RetType for_SyntaxTransformationRepeatOneOrMoreSymbol(_SyntaxTransformationRepeatOneOrMoreSymbol that);

    /** Process an instance of _SyntaxTransformationNoWhitespaceSymbol. */
    public RetType for_SyntaxTransformationNoWhitespaceSymbol(_SyntaxTransformationNoWhitespaceSymbol that);

    /** Process an instance of _SyntaxTransformationGroupSymbol. */
    public RetType for_SyntaxTransformationGroupSymbol(_SyntaxTransformationGroupSymbol that);

    /** Process an instance of _SyntaxTransformationSpecialSymbol. */
    public RetType for_SyntaxTransformationSpecialSymbol(_SyntaxTransformationSpecialSymbol that);

    /** Process an instance of _SyntaxTransformationAnyCharacterSymbol. */
    public RetType for_SyntaxTransformationAnyCharacterSymbol(_SyntaxTransformationAnyCharacterSymbol that);

    /** Process an instance of _SyntaxTransformationWhitespaceSymbol. */
    public RetType for_SyntaxTransformationWhitespaceSymbol(_SyntaxTransformationWhitespaceSymbol that);

    /** Process an instance of _SyntaxTransformationTabSymbol. */
    public RetType for_SyntaxTransformationTabSymbol(_SyntaxTransformationTabSymbol that);

    /** Process an instance of _SyntaxTransformationFormfeedSymbol. */
    public RetType for_SyntaxTransformationFormfeedSymbol(_SyntaxTransformationFormfeedSymbol that);

    /** Process an instance of _SyntaxTransformationCarriageReturnSymbol. */
    public RetType for_SyntaxTransformationCarriageReturnSymbol(_SyntaxTransformationCarriageReturnSymbol that);

    /** Process an instance of _SyntaxTransformationBackspaceSymbol. */
    public RetType for_SyntaxTransformationBackspaceSymbol(_SyntaxTransformationBackspaceSymbol that);

    /** Process an instance of _SyntaxTransformationNewlineSymbol. */
    public RetType for_SyntaxTransformationNewlineSymbol(_SyntaxTransformationNewlineSymbol that);

    /** Process an instance of _SyntaxTransformationBreaklineSymbol. */
    public RetType for_SyntaxTransformationBreaklineSymbol(_SyntaxTransformationBreaklineSymbol that);

    /** Process an instance of _SyntaxTransformationItemSymbol. */
    public RetType for_SyntaxTransformationItemSymbol(_SyntaxTransformationItemSymbol that);

    /** Process an instance of _SyntaxTransformationNonterminalSymbol. */
    public RetType for_SyntaxTransformationNonterminalSymbol(_SyntaxTransformationNonterminalSymbol that);

    /** Process an instance of _SyntaxTransformationKeywordSymbol. */
    public RetType for_SyntaxTransformationKeywordSymbol(_SyntaxTransformationKeywordSymbol that);

    /** Process an instance of _SyntaxTransformationTokenSymbol. */
    public RetType for_SyntaxTransformationTokenSymbol(_SyntaxTransformationTokenSymbol that);

    /** Process an instance of _SyntaxTransformationNotPredicateSymbol. */
    public RetType for_SyntaxTransformationNotPredicateSymbol(_SyntaxTransformationNotPredicateSymbol that);

    /** Process an instance of _SyntaxTransformationAndPredicateSymbol. */
    public RetType for_SyntaxTransformationAndPredicateSymbol(_SyntaxTransformationAndPredicateSymbol that);

    /** Process an instance of _SyntaxTransformationCharacterClassSymbol. */
    public RetType for_SyntaxTransformationCharacterClassSymbol(_SyntaxTransformationCharacterClassSymbol that);

    /** Process an instance of _SyntaxTransformationCharacterSymbol. */
    public RetType for_SyntaxTransformationCharacterSymbol(_SyntaxTransformationCharacterSymbol that);

    /** Process an instance of _SyntaxTransformationCharSymbol. */
    public RetType for_SyntaxTransformationCharSymbol(_SyntaxTransformationCharSymbol that);

    /** Process an instance of _SyntaxTransformationCharacterInterval. */
    public RetType for_SyntaxTransformationCharacterInterval(_SyntaxTransformationCharacterInterval that);

    /** Process an instance of _SyntaxTransformationLink. */
    public RetType for_SyntaxTransformationLink(_SyntaxTransformationLink that);

    /** Process an instance of _EllipsesAbstractNode. */
    public RetType for_EllipsesAbstractNode(_EllipsesAbstractNode that);

    /** Process an instance of _EllipsesCompilationUnit. */
    public RetType for_EllipsesCompilationUnit(_EllipsesCompilationUnit that);

    /** Process an instance of _EllipsesComponent. */
    public RetType for_EllipsesComponent(_EllipsesComponent that);

    /** Process an instance of _EllipsesApi. */
    public RetType for_EllipsesApi(_EllipsesApi that);

    /** Process an instance of _EllipsesImport. */
    public RetType for_EllipsesImport(_EllipsesImport that);

    /** Process an instance of _EllipsesImportedNames. */
    public RetType for_EllipsesImportedNames(_EllipsesImportedNames that);

    /** Process an instance of _EllipsesImportStar. */
    public RetType for_EllipsesImportStar(_EllipsesImportStar that);

    /** Process an instance of _EllipsesImportNames. */
    public RetType for_EllipsesImportNames(_EllipsesImportNames that);

    /** Process an instance of _EllipsesImportApi. */
    public RetType for_EllipsesImportApi(_EllipsesImportApi that);

    /** Process an instance of _EllipsesAliasedSimpleName. */
    public RetType for_EllipsesAliasedSimpleName(_EllipsesAliasedSimpleName that);

    /** Process an instance of _EllipsesAliasedAPIName. */
    public RetType for_EllipsesAliasedAPIName(_EllipsesAliasedAPIName that);

    /** Process an instance of _EllipsesDecl. */
    public RetType for_EllipsesDecl(_EllipsesDecl that);

    /** Process an instance of _EllipsesTraitObjectDecl. */
    public RetType for_EllipsesTraitObjectDecl(_EllipsesTraitObjectDecl that);

    /** Process an instance of _EllipsesTraitDecl. */
    public RetType for_EllipsesTraitDecl(_EllipsesTraitDecl that);

    /** Process an instance of _EllipsesObjectDecl. */
    public RetType for_EllipsesObjectDecl(_EllipsesObjectDecl that);

    /** Process an instance of _EllipsesVarDecl. */
    public RetType for_EllipsesVarDecl(_EllipsesVarDecl that);

    /** Process an instance of _EllipsesFnDecl. */
    public RetType for_EllipsesFnDecl(_EllipsesFnDecl that);

    /** Process an instance of _Ellipses_RewriteFnOverloadDecl. */
    public RetType for_Ellipses_RewriteFnOverloadDecl(_Ellipses_RewriteFnOverloadDecl that);

    /** Process an instance of _Ellipses_RewriteObjectExprDecl. */
    public RetType for_Ellipses_RewriteObjectExprDecl(_Ellipses_RewriteObjectExprDecl that);

    /** Process an instance of _Ellipses_RewriteFunctionalMethodDecl. */
    public RetType for_Ellipses_RewriteFunctionalMethodDecl(_Ellipses_RewriteFunctionalMethodDecl that);

    /** Process an instance of _EllipsesDimUnitDecl. */
    public RetType for_EllipsesDimUnitDecl(_EllipsesDimUnitDecl that);

    /** Process an instance of _EllipsesDimDecl. */
    public RetType for_EllipsesDimDecl(_EllipsesDimDecl that);

    /** Process an instance of _EllipsesUnitDecl. */
    public RetType for_EllipsesUnitDecl(_EllipsesUnitDecl that);

    /** Process an instance of _EllipsesTestDecl. */
    public RetType for_EllipsesTestDecl(_EllipsesTestDecl that);

    /** Process an instance of _EllipsesPropertyDecl. */
    public RetType for_EllipsesPropertyDecl(_EllipsesPropertyDecl that);

    /** Process an instance of _EllipsesTypeAlias. */
    public RetType for_EllipsesTypeAlias(_EllipsesTypeAlias that);

    /** Process an instance of _EllipsesGrammarDecl. */
    public RetType for_EllipsesGrammarDecl(_EllipsesGrammarDecl that);

    /** Process an instance of _EllipsesGrammarMemberDecl. */
    public RetType for_EllipsesGrammarMemberDecl(_EllipsesGrammarMemberDecl that);

    /** Process an instance of _EllipsesNonterminalDecl. */
    public RetType for_EllipsesNonterminalDecl(_EllipsesNonterminalDecl that);

    /** Process an instance of _EllipsesNonterminalDef. */
    public RetType for_EllipsesNonterminalDef(_EllipsesNonterminalDef that);

    /** Process an instance of _EllipsesNonterminalExtensionDef. */
    public RetType for_EllipsesNonterminalExtensionDef(_EllipsesNonterminalExtensionDef that);

    /** Process an instance of _EllipsesBinding. */
    public RetType for_EllipsesBinding(_EllipsesBinding that);

    /** Process an instance of _EllipsesLValue. */
    public RetType for_EllipsesLValue(_EllipsesLValue that);

    /** Process an instance of _EllipsesParam. */
    public RetType for_EllipsesParam(_EllipsesParam that);

    /** Process an instance of _EllipsesExpr. */
    public RetType for_EllipsesExpr(_EllipsesExpr that);

    /** Process an instance of _EllipsesDummyExpr. */
    public RetType for_EllipsesDummyExpr(_EllipsesDummyExpr that);

    /** Process an instance of _EllipsesTypeAnnotatedExpr. */
    public RetType for_EllipsesTypeAnnotatedExpr(_EllipsesTypeAnnotatedExpr that);

    /** Process an instance of _EllipsesAsExpr. */
    public RetType for_EllipsesAsExpr(_EllipsesAsExpr that);

    /** Process an instance of _EllipsesAsIfExpr. */
    public RetType for_EllipsesAsIfExpr(_EllipsesAsIfExpr that);

    /** Process an instance of _EllipsesAssignment. */
    public RetType for_EllipsesAssignment(_EllipsesAssignment that);

    /** Process an instance of _EllipsesBlock. */
    public RetType for_EllipsesBlock(_EllipsesBlock that);

    /** Process an instance of _EllipsesDo. */
    public RetType for_EllipsesDo(_EllipsesDo that);

    /** Process an instance of _EllipsesCaseExpr. */
    public RetType for_EllipsesCaseExpr(_EllipsesCaseExpr that);

    /** Process an instance of _EllipsesIf. */
    public RetType for_EllipsesIf(_EllipsesIf that);

    /** Process an instance of _EllipsesLabel. */
    public RetType for_EllipsesLabel(_EllipsesLabel that);

    /** Process an instance of _EllipsesAbstractObjectExpr. */
    public RetType for_EllipsesAbstractObjectExpr(_EllipsesAbstractObjectExpr that);

    /** Process an instance of _EllipsesObjectExpr. */
    public RetType for_EllipsesObjectExpr(_EllipsesObjectExpr that);

    /** Process an instance of _Ellipses_RewriteObjectExpr. */
    public RetType for_Ellipses_RewriteObjectExpr(_Ellipses_RewriteObjectExpr that);

    /** Process an instance of _EllipsesTry. */
    public RetType for_EllipsesTry(_EllipsesTry that);

    /** Process an instance of _EllipsesTupleExpr. */
    public RetType for_EllipsesTupleExpr(_EllipsesTupleExpr that);

    /** Process an instance of _EllipsesTypecase. */
    public RetType for_EllipsesTypecase(_EllipsesTypecase that);

    /** Process an instance of _EllipsesWhile. */
    public RetType for_EllipsesWhile(_EllipsesWhile that);

    /** Process an instance of _EllipsesFor. */
    public RetType for_EllipsesFor(_EllipsesFor that);

    /** Process an instance of _EllipsesBigOpApp. */
    public RetType for_EllipsesBigOpApp(_EllipsesBigOpApp that);

    /** Process an instance of _EllipsesAccumulator. */
    public RetType for_EllipsesAccumulator(_EllipsesAccumulator that);

    /** Process an instance of _EllipsesArrayComprehension. */
    public RetType for_EllipsesArrayComprehension(_EllipsesArrayComprehension that);

    /** Process an instance of _EllipsesAtomicExpr. */
    public RetType for_EllipsesAtomicExpr(_EllipsesAtomicExpr that);

    /** Process an instance of _EllipsesExit. */
    public RetType for_EllipsesExit(_EllipsesExit that);

    /** Process an instance of _EllipsesSpawn. */
    public RetType for_EllipsesSpawn(_EllipsesSpawn that);

    /** Process an instance of _EllipsesThrow. */
    public RetType for_EllipsesThrow(_EllipsesThrow that);

    /** Process an instance of _EllipsesTryAtomicExpr. */
    public RetType for_EllipsesTryAtomicExpr(_EllipsesTryAtomicExpr that);

    /** Process an instance of _EllipsesFnExpr. */
    public RetType for_EllipsesFnExpr(_EllipsesFnExpr that);

    /** Process an instance of _EllipsesLetExpr. */
    public RetType for_EllipsesLetExpr(_EllipsesLetExpr that);

    /** Process an instance of _EllipsesLetFn. */
    public RetType for_EllipsesLetFn(_EllipsesLetFn that);

    /** Process an instance of _EllipsesLocalVarDecl. */
    public RetType for_EllipsesLocalVarDecl(_EllipsesLocalVarDecl that);

    /** Process an instance of _EllipsesSimpleExpr. */
    public RetType for_EllipsesSimpleExpr(_EllipsesSimpleExpr that);

    /** Process an instance of _EllipsesSubscriptExpr. */
    public RetType for_EllipsesSubscriptExpr(_EllipsesSubscriptExpr that);

    /** Process an instance of _EllipsesPrimary. */
    public RetType for_EllipsesPrimary(_EllipsesPrimary that);

    /** Process an instance of _EllipsesLiteralExpr. */
    public RetType for_EllipsesLiteralExpr(_EllipsesLiteralExpr that);

    /** Process an instance of _EllipsesNumberLiteralExpr. */
    public RetType for_EllipsesNumberLiteralExpr(_EllipsesNumberLiteralExpr that);

    /** Process an instance of _EllipsesFloatLiteralExpr. */
    public RetType for_EllipsesFloatLiteralExpr(_EllipsesFloatLiteralExpr that);

    /** Process an instance of _EllipsesIntLiteralExpr. */
    public RetType for_EllipsesIntLiteralExpr(_EllipsesIntLiteralExpr that);

    /** Process an instance of _EllipsesCharLiteralExpr. */
    public RetType for_EllipsesCharLiteralExpr(_EllipsesCharLiteralExpr that);

    /** Process an instance of _EllipsesStringLiteralExpr. */
    public RetType for_EllipsesStringLiteralExpr(_EllipsesStringLiteralExpr that);

    /** Process an instance of _EllipsesVoidLiteralExpr. */
    public RetType for_EllipsesVoidLiteralExpr(_EllipsesVoidLiteralExpr that);

    /** Process an instance of _EllipsesBooleanLiteralExpr. */
    public RetType for_EllipsesBooleanLiteralExpr(_EllipsesBooleanLiteralExpr that);

    /** Process an instance of _EllipsesVarRef. */
    public RetType for_EllipsesVarRef(_EllipsesVarRef that);

    /** Process an instance of _EllipsesFieldRef. */
    public RetType for_EllipsesFieldRef(_EllipsesFieldRef that);

    /** Process an instance of _EllipsesFunctionalRef. */
    public RetType for_EllipsesFunctionalRef(_EllipsesFunctionalRef that);

    /** Process an instance of _EllipsesFnRef. */
    public RetType for_EllipsesFnRef(_EllipsesFnRef that);

    /** Process an instance of _EllipsesOpRef. */
    public RetType for_EllipsesOpRef(_EllipsesOpRef that);

    /** Process an instance of _Ellipses_RewriteFnRef. */
    public RetType for_Ellipses_RewriteFnRef(_Ellipses_RewriteFnRef that);

    /** Process an instance of _Ellipses_RewriteObjectExprRef. */
    public RetType for_Ellipses_RewriteObjectExprRef(_Ellipses_RewriteObjectExprRef that);

    /** Process an instance of _EllipsesJuxt. */
    public RetType for_EllipsesJuxt(_EllipsesJuxt that);

    /** Process an instance of _Ellipses_RewriteFnApp. */
    public RetType for_Ellipses_RewriteFnApp(_Ellipses_RewriteFnApp that);

    /** Process an instance of _EllipsesOpExpr. */
    public RetType for_EllipsesOpExpr(_EllipsesOpExpr that);

    /** Process an instance of _EllipsesAmbiguousMultifixOpExpr. */
    public RetType for_EllipsesAmbiguousMultifixOpExpr(_EllipsesAmbiguousMultifixOpExpr that);

    /** Process an instance of _EllipsesChainExpr. */
    public RetType for_EllipsesChainExpr(_EllipsesChainExpr that);

    /** Process an instance of _EllipsesCoercionInvocation. */
    public RetType for_EllipsesCoercionInvocation(_EllipsesCoercionInvocation that);

    /** Process an instance of _EllipsesTraitCoercionInvocation. */
    public RetType for_EllipsesTraitCoercionInvocation(_EllipsesTraitCoercionInvocation that);

    /** Process an instance of _EllipsesTupleCoercionInvocation. */
    public RetType for_EllipsesTupleCoercionInvocation(_EllipsesTupleCoercionInvocation that);

    /** Process an instance of _EllipsesArrowCoercionInvocation. */
    public RetType for_EllipsesArrowCoercionInvocation(_EllipsesArrowCoercionInvocation that);

    /** Process an instance of _EllipsesUnionCoercionInvocation. */
    public RetType for_EllipsesUnionCoercionInvocation(_EllipsesUnionCoercionInvocation that);

    /** Process an instance of _EllipsesMethodInvocation. */
    public RetType for_EllipsesMethodInvocation(_EllipsesMethodInvocation that);

    /** Process an instance of _EllipsesMathPrimary. */
    public RetType for_EllipsesMathPrimary(_EllipsesMathPrimary that);

    /** Process an instance of _EllipsesArrayExpr. */
    public RetType for_EllipsesArrayExpr(_EllipsesArrayExpr that);

    /** Process an instance of _EllipsesArrayElement. */
    public RetType for_EllipsesArrayElement(_EllipsesArrayElement that);

    /** Process an instance of _EllipsesArrayElements. */
    public RetType for_EllipsesArrayElements(_EllipsesArrayElements that);

    /** Process an instance of _EllipsesType. */
    public RetType for_EllipsesType(_EllipsesType that);

    /** Process an instance of _EllipsesBaseType. */
    public RetType for_EllipsesBaseType(_EllipsesBaseType that);

    /** Process an instance of _EllipsesAnyType. */
    public RetType for_EllipsesAnyType(_EllipsesAnyType that);

    /** Process an instance of _EllipsesBottomType. */
    public RetType for_EllipsesBottomType(_EllipsesBottomType that);

    /** Process an instance of _EllipsesUnknownType. */
    public RetType for_EllipsesUnknownType(_EllipsesUnknownType that);

    /** Process an instance of _EllipsesSelfType. */
    public RetType for_EllipsesSelfType(_EllipsesSelfType that);

    /** Process an instance of _EllipsesTraitSelfType. */
    public RetType for_EllipsesTraitSelfType(_EllipsesTraitSelfType that);

    /** Process an instance of _EllipsesObjectExprType. */
    public RetType for_EllipsesObjectExprType(_EllipsesObjectExprType that);

    /** Process an instance of _EllipsesNamedType. */
    public RetType for_EllipsesNamedType(_EllipsesNamedType that);

    /** Process an instance of _Ellipses_InferenceVarType. */
    public RetType for_Ellipses_InferenceVarType(_Ellipses_InferenceVarType that);

    /** Process an instance of _EllipsesVarType. */
    public RetType for_EllipsesVarType(_EllipsesVarType that);

    /** Process an instance of _EllipsesTraitType. */
    public RetType for_EllipsesTraitType(_EllipsesTraitType that);

    /** Process an instance of _EllipsesAbbreviatedType. */
    public RetType for_EllipsesAbbreviatedType(_EllipsesAbbreviatedType that);

    /** Process an instance of _EllipsesArrayType. */
    public RetType for_EllipsesArrayType(_EllipsesArrayType that);

    /** Process an instance of _EllipsesMatrixType. */
    public RetType for_EllipsesMatrixType(_EllipsesMatrixType that);

    /** Process an instance of _EllipsesTaggedDimType. */
    public RetType for_EllipsesTaggedDimType(_EllipsesTaggedDimType that);

    /** Process an instance of _EllipsesTaggedUnitType. */
    public RetType for_EllipsesTaggedUnitType(_EllipsesTaggedUnitType that);

    /** Process an instance of _EllipsesTupleType. */
    public RetType for_EllipsesTupleType(_EllipsesTupleType that);

    /** Process an instance of _EllipsesArrowType. */
    public RetType for_EllipsesArrowType(_EllipsesArrowType that);

    /** Process an instance of _EllipsesBoundType. */
    public RetType for_EllipsesBoundType(_EllipsesBoundType that);

    /** Process an instance of _EllipsesIntersectionType. */
    public RetType for_EllipsesIntersectionType(_EllipsesIntersectionType that);

    /** Process an instance of _EllipsesUnionType. */
    public RetType for_EllipsesUnionType(_EllipsesUnionType that);

    /** Process an instance of _EllipsesFixedPointType. */
    public RetType for_EllipsesFixedPointType(_EllipsesFixedPointType that);

    /** Process an instance of _EllipsesLabelType. */
    public RetType for_EllipsesLabelType(_EllipsesLabelType that);

    /** Process an instance of _EllipsesDimExpr. */
    public RetType for_EllipsesDimExpr(_EllipsesDimExpr that);

    /** Process an instance of _EllipsesDimBase. */
    public RetType for_EllipsesDimBase(_EllipsesDimBase that);

    /** Process an instance of _EllipsesDimRef. */
    public RetType for_EllipsesDimRef(_EllipsesDimRef that);

    /** Process an instance of _EllipsesDimExponent. */
    public RetType for_EllipsesDimExponent(_EllipsesDimExponent that);

    /** Process an instance of _EllipsesDimUnaryOp. */
    public RetType for_EllipsesDimUnaryOp(_EllipsesDimUnaryOp that);

    /** Process an instance of _EllipsesDimBinaryOp. */
    public RetType for_EllipsesDimBinaryOp(_EllipsesDimBinaryOp that);

    /** Process an instance of _EllipsesPattern. */
    public RetType for_EllipsesPattern(_EllipsesPattern that);

    /** Process an instance of _EllipsesPatternArgs. */
    public RetType for_EllipsesPatternArgs(_EllipsesPatternArgs that);

    /** Process an instance of _EllipsesPatternBinding. */
    public RetType for_EllipsesPatternBinding(_EllipsesPatternBinding that);

    /** Process an instance of _EllipsesPlainPattern. */
    public RetType for_EllipsesPlainPattern(_EllipsesPlainPattern that);

    /** Process an instance of _EllipsesTypePattern. */
    public RetType for_EllipsesTypePattern(_EllipsesTypePattern that);

    /** Process an instance of _EllipsesNestedPattern. */
    public RetType for_EllipsesNestedPattern(_EllipsesNestedPattern that);

    /** Process an instance of _EllipsesStaticArg. */
    public RetType for_EllipsesStaticArg(_EllipsesStaticArg that);

    /** Process an instance of _EllipsesTypeArg. */
    public RetType for_EllipsesTypeArg(_EllipsesTypeArg that);

    /** Process an instance of _EllipsesIntArg. */
    public RetType for_EllipsesIntArg(_EllipsesIntArg that);

    /** Process an instance of _EllipsesBoolArg. */
    public RetType for_EllipsesBoolArg(_EllipsesBoolArg that);

    /** Process an instance of _EllipsesOpArg. */
    public RetType for_EllipsesOpArg(_EllipsesOpArg that);

    /** Process an instance of _EllipsesDimArg. */
    public RetType for_EllipsesDimArg(_EllipsesDimArg that);

    /** Process an instance of _EllipsesUnitArg. */
    public RetType for_EllipsesUnitArg(_EllipsesUnitArg that);

    /** Process an instance of _EllipsesStaticExpr. */
    public RetType for_EllipsesStaticExpr(_EllipsesStaticExpr that);

    /** Process an instance of _EllipsesIntExpr. */
    public RetType for_EllipsesIntExpr(_EllipsesIntExpr that);

    /** Process an instance of _EllipsesIntBase. */
    public RetType for_EllipsesIntBase(_EllipsesIntBase that);

    /** Process an instance of _EllipsesIntRef. */
    public RetType for_EllipsesIntRef(_EllipsesIntRef that);

    /** Process an instance of _EllipsesIntBinaryOp. */
    public RetType for_EllipsesIntBinaryOp(_EllipsesIntBinaryOp that);

    /** Process an instance of _EllipsesBoolExpr. */
    public RetType for_EllipsesBoolExpr(_EllipsesBoolExpr that);

    /** Process an instance of _EllipsesBoolBase. */
    public RetType for_EllipsesBoolBase(_EllipsesBoolBase that);

    /** Process an instance of _EllipsesBoolRef. */
    public RetType for_EllipsesBoolRef(_EllipsesBoolRef that);

    /** Process an instance of _EllipsesBoolConstraint. */
    public RetType for_EllipsesBoolConstraint(_EllipsesBoolConstraint that);

    /** Process an instance of _EllipsesBoolUnaryOp. */
    public RetType for_EllipsesBoolUnaryOp(_EllipsesBoolUnaryOp that);

    /** Process an instance of _EllipsesBoolBinaryOp. */
    public RetType for_EllipsesBoolBinaryOp(_EllipsesBoolBinaryOp that);

    /** Process an instance of _EllipsesUnitExpr. */
    public RetType for_EllipsesUnitExpr(_EllipsesUnitExpr that);

    /** Process an instance of _EllipsesUnitRef. */
    public RetType for_EllipsesUnitRef(_EllipsesUnitRef that);

    /** Process an instance of _EllipsesUnitBinaryOp. */
    public RetType for_EllipsesUnitBinaryOp(_EllipsesUnitBinaryOp that);

    /** Process an instance of _EllipsesEffect. */
    public RetType for_EllipsesEffect(_EllipsesEffect that);

    /** Process an instance of _EllipsesWhereClause. */
    public RetType for_EllipsesWhereClause(_EllipsesWhereClause that);

    /** Process an instance of _EllipsesWhereBinding. */
    public RetType for_EllipsesWhereBinding(_EllipsesWhereBinding that);

    /** Process an instance of _EllipsesWhereConstraint. */
    public RetType for_EllipsesWhereConstraint(_EllipsesWhereConstraint that);

    /** Process an instance of _EllipsesWhereExtends. */
    public RetType for_EllipsesWhereExtends(_EllipsesWhereExtends that);

    /** Process an instance of _EllipsesWhereTypeAlias. */
    public RetType for_EllipsesWhereTypeAlias(_EllipsesWhereTypeAlias that);

    /** Process an instance of _EllipsesWhereCoerces. */
    public RetType for_EllipsesWhereCoerces(_EllipsesWhereCoerces that);

    /** Process an instance of _EllipsesWhereEquals. */
    public RetType for_EllipsesWhereEquals(_EllipsesWhereEquals that);

    /** Process an instance of _EllipsesUnitConstraint. */
    public RetType for_EllipsesUnitConstraint(_EllipsesUnitConstraint that);

    /** Process an instance of _EllipsesIntConstraint. */
    public RetType for_EllipsesIntConstraint(_EllipsesIntConstraint that);

    /** Process an instance of _EllipsesBoolConstraintExpr. */
    public RetType for_EllipsesBoolConstraintExpr(_EllipsesBoolConstraintExpr that);

    /** Process an instance of _EllipsesContract. */
    public RetType for_EllipsesContract(_EllipsesContract that);

    /** Process an instance of _EllipsesEnsuresClause. */
    public RetType for_EllipsesEnsuresClause(_EllipsesEnsuresClause that);

    /** Process an instance of _EllipsesStaticParam. */
    public RetType for_EllipsesStaticParam(_EllipsesStaticParam that);

    /** Process an instance of _EllipsesName. */
    public RetType for_EllipsesName(_EllipsesName that);

    /** Process an instance of _EllipsesAPIName. */
    public RetType for_EllipsesAPIName(_EllipsesAPIName that);

    /** Process an instance of _EllipsesIdOrOpOrAnonymousName. */
    public RetType for_EllipsesIdOrOpOrAnonymousName(_EllipsesIdOrOpOrAnonymousName that);

    /** Process an instance of _EllipsesIdOrOp. */
    public RetType for_EllipsesIdOrOp(_EllipsesIdOrOp that);

    /** Process an instance of _EllipsesId. */
    public RetType for_EllipsesId(_EllipsesId that);

    /** Process an instance of _EllipsesOp. */
    public RetType for_EllipsesOp(_EllipsesOp that);

    /** Process an instance of _EllipsesNamedOp. */
    public RetType for_EllipsesNamedOp(_EllipsesNamedOp that);

    /** Process an instance of _Ellipses_InferenceVarOp. */
    public RetType for_Ellipses_InferenceVarOp(_Ellipses_InferenceVarOp that);

    /** Process an instance of _EllipsesAnonymousName. */
    public RetType for_EllipsesAnonymousName(_EllipsesAnonymousName that);

    /** Process an instance of _EllipsesAnonymousFnName. */
    public RetType for_EllipsesAnonymousFnName(_EllipsesAnonymousFnName that);

    /** Process an instance of _EllipsesConstructorFnName. */
    public RetType for_EllipsesConstructorFnName(_EllipsesConstructorFnName that);

    /** Process an instance of _EllipsesArrayComprehensionClause. */
    public RetType for_EllipsesArrayComprehensionClause(_EllipsesArrayComprehensionClause that);

    /** Process an instance of _EllipsesKeywordExpr. */
    public RetType for_EllipsesKeywordExpr(_EllipsesKeywordExpr that);

    /** Process an instance of _EllipsesCaseClause. */
    public RetType for_EllipsesCaseClause(_EllipsesCaseClause that);

    /** Process an instance of _EllipsesCatch. */
    public RetType for_EllipsesCatch(_EllipsesCatch that);

    /** Process an instance of _EllipsesCatchClause. */
    public RetType for_EllipsesCatchClause(_EllipsesCatchClause that);

    /** Process an instance of _EllipsesIfClause. */
    public RetType for_EllipsesIfClause(_EllipsesIfClause that);

    /** Process an instance of _EllipsesTypecaseClause. */
    public RetType for_EllipsesTypecaseClause(_EllipsesTypecaseClause that);

    /** Process an instance of _EllipsesExtentRange. */
    public RetType for_EllipsesExtentRange(_EllipsesExtentRange that);

    /** Process an instance of _EllipsesGeneratorClause. */
    public RetType for_EllipsesGeneratorClause(_EllipsesGeneratorClause that);

    /** Process an instance of _EllipsesKeywordType. */
    public RetType for_EllipsesKeywordType(_EllipsesKeywordType that);

    /** Process an instance of _EllipsesTraitTypeWhere. */
    public RetType for_EllipsesTraitTypeWhere(_EllipsesTraitTypeWhere that);

    /** Process an instance of _EllipsesIndices. */
    public RetType for_EllipsesIndices(_EllipsesIndices that);

    /** Process an instance of _EllipsesMathItem. */
    public RetType for_EllipsesMathItem(_EllipsesMathItem that);

    /** Process an instance of _EllipsesExprMI. */
    public RetType for_EllipsesExprMI(_EllipsesExprMI that);

    /** Process an instance of _EllipsesParenthesisDelimitedMI. */
    public RetType for_EllipsesParenthesisDelimitedMI(_EllipsesParenthesisDelimitedMI that);

    /** Process an instance of _EllipsesNonParenthesisDelimitedMI. */
    public RetType for_EllipsesNonParenthesisDelimitedMI(_EllipsesNonParenthesisDelimitedMI that);

    /** Process an instance of _EllipsesNonExprMI. */
    public RetType for_EllipsesNonExprMI(_EllipsesNonExprMI that);

    /** Process an instance of _EllipsesExponentiationMI. */
    public RetType for_EllipsesExponentiationMI(_EllipsesExponentiationMI that);

    /** Process an instance of _EllipsesSubscriptingMI. */
    public RetType for_EllipsesSubscriptingMI(_EllipsesSubscriptingMI that);

    /** Process an instance of _EllipsesOverloading. */
    public RetType for_EllipsesOverloading(_EllipsesOverloading that);

    /** Process an instance of _EllipsesNonterminalHeader. */
    public RetType for_EllipsesNonterminalHeader(_EllipsesNonterminalHeader that);

    /** Process an instance of _EllipsesNonterminalParameter. */
    public RetType for_EllipsesNonterminalParameter(_EllipsesNonterminalParameter that);

    /** Process an instance of _EllipsesSyntaxDecl. */
    public RetType for_EllipsesSyntaxDecl(_EllipsesSyntaxDecl that);

    /** Process an instance of _EllipsesSyntaxDef. */
    public RetType for_EllipsesSyntaxDef(_EllipsesSyntaxDef that);

    /** Process an instance of _EllipsesSuperSyntaxDef. */
    public RetType for_EllipsesSuperSyntaxDef(_EllipsesSuperSyntaxDef that);

    /** Process an instance of _EllipsesTransformerDecl. */
    public RetType for_EllipsesTransformerDecl(_EllipsesTransformerDecl that);

    /** Process an instance of _EllipsesPreTransformerDef. */
    public RetType for_EllipsesPreTransformerDef(_EllipsesPreTransformerDef that);

    /** Process an instance of _EllipsesNamedTransformerDef. */
    public RetType for_EllipsesNamedTransformerDef(_EllipsesNamedTransformerDef that);

    /** Process an instance of _EllipsesTransformer. */
    public RetType for_EllipsesTransformer(_EllipsesTransformer that);

    /** Process an instance of _EllipsesUnparsedTransformer. */
    public RetType for_EllipsesUnparsedTransformer(_EllipsesUnparsedTransformer that);

    /** Process an instance of _EllipsesNodeTransformer. */
    public RetType for_EllipsesNodeTransformer(_EllipsesNodeTransformer that);

    /** Process an instance of _EllipsesCaseTransformer. */
    public RetType for_EllipsesCaseTransformer(_EllipsesCaseTransformer that);

    /** Process an instance of _EllipsesCaseTransformerClause. */
    public RetType for_EllipsesCaseTransformerClause(_EllipsesCaseTransformerClause that);

    /** Process an instance of _EllipsesSyntaxSymbol. */
    public RetType for_EllipsesSyntaxSymbol(_EllipsesSyntaxSymbol that);

    /** Process an instance of _EllipsesPrefixedSymbol. */
    public RetType for_EllipsesPrefixedSymbol(_EllipsesPrefixedSymbol that);

    /** Process an instance of _EllipsesOptionalSymbol. */
    public RetType for_EllipsesOptionalSymbol(_EllipsesOptionalSymbol that);

    /** Process an instance of _EllipsesRepeatSymbol. */
    public RetType for_EllipsesRepeatSymbol(_EllipsesRepeatSymbol that);

    /** Process an instance of _EllipsesRepeatOneOrMoreSymbol. */
    public RetType for_EllipsesRepeatOneOrMoreSymbol(_EllipsesRepeatOneOrMoreSymbol that);

    /** Process an instance of _EllipsesNoWhitespaceSymbol. */
    public RetType for_EllipsesNoWhitespaceSymbol(_EllipsesNoWhitespaceSymbol that);

    /** Process an instance of _EllipsesGroupSymbol. */
    public RetType for_EllipsesGroupSymbol(_EllipsesGroupSymbol that);

    /** Process an instance of _EllipsesSpecialSymbol. */
    public RetType for_EllipsesSpecialSymbol(_EllipsesSpecialSymbol that);

    /** Process an instance of _EllipsesAnyCharacterSymbol. */
    public RetType for_EllipsesAnyCharacterSymbol(_EllipsesAnyCharacterSymbol that);

    /** Process an instance of _EllipsesWhitespaceSymbol. */
    public RetType for_EllipsesWhitespaceSymbol(_EllipsesWhitespaceSymbol that);

    /** Process an instance of _EllipsesTabSymbol. */
    public RetType for_EllipsesTabSymbol(_EllipsesTabSymbol that);

    /** Process an instance of _EllipsesFormfeedSymbol. */
    public RetType for_EllipsesFormfeedSymbol(_EllipsesFormfeedSymbol that);

    /** Process an instance of _EllipsesCarriageReturnSymbol. */
    public RetType for_EllipsesCarriageReturnSymbol(_EllipsesCarriageReturnSymbol that);

    /** Process an instance of _EllipsesBackspaceSymbol. */
    public RetType for_EllipsesBackspaceSymbol(_EllipsesBackspaceSymbol that);

    /** Process an instance of _EllipsesNewlineSymbol. */
    public RetType for_EllipsesNewlineSymbol(_EllipsesNewlineSymbol that);

    /** Process an instance of _EllipsesBreaklineSymbol. */
    public RetType for_EllipsesBreaklineSymbol(_EllipsesBreaklineSymbol that);

    /** Process an instance of _EllipsesItemSymbol. */
    public RetType for_EllipsesItemSymbol(_EllipsesItemSymbol that);

    /** Process an instance of _EllipsesNonterminalSymbol. */
    public RetType for_EllipsesNonterminalSymbol(_EllipsesNonterminalSymbol that);

    /** Process an instance of _EllipsesKeywordSymbol. */
    public RetType for_EllipsesKeywordSymbol(_EllipsesKeywordSymbol that);

    /** Process an instance of _EllipsesTokenSymbol. */
    public RetType for_EllipsesTokenSymbol(_EllipsesTokenSymbol that);

    /** Process an instance of _EllipsesNotPredicateSymbol. */
    public RetType for_EllipsesNotPredicateSymbol(_EllipsesNotPredicateSymbol that);

    /** Process an instance of _EllipsesAndPredicateSymbol. */
    public RetType for_EllipsesAndPredicateSymbol(_EllipsesAndPredicateSymbol that);

    /** Process an instance of _EllipsesCharacterClassSymbol. */
    public RetType for_EllipsesCharacterClassSymbol(_EllipsesCharacterClassSymbol that);

    /** Process an instance of _EllipsesCharacterSymbol. */
    public RetType for_EllipsesCharacterSymbol(_EllipsesCharacterSymbol that);

    /** Process an instance of _EllipsesCharSymbol. */
    public RetType for_EllipsesCharSymbol(_EllipsesCharSymbol that);

    /** Process an instance of _EllipsesCharacterInterval. */
    public RetType for_EllipsesCharacterInterval(_EllipsesCharacterInterval that);

    /** Process an instance of _EllipsesLink. */
    public RetType for_EllipsesLink(_EllipsesLink that);

    /** Process an instance of TemplateGapAbstractNode. */
    public RetType forTemplateGapAbstractNode(TemplateGapAbstractNode that);

    /** Process an instance of TemplateGapCompilationUnit. */
    public RetType forTemplateGapCompilationUnit(TemplateGapCompilationUnit that);

    /** Process an instance of TemplateGapComponent. */
    public RetType forTemplateGapComponent(TemplateGapComponent that);

    /** Process an instance of TemplateGapApi. */
    public RetType forTemplateGapApi(TemplateGapApi that);

    /** Process an instance of TemplateGapImport. */
    public RetType forTemplateGapImport(TemplateGapImport that);

    /** Process an instance of TemplateGapImportedNames. */
    public RetType forTemplateGapImportedNames(TemplateGapImportedNames that);

    /** Process an instance of TemplateGapImportStar. */
    public RetType forTemplateGapImportStar(TemplateGapImportStar that);

    /** Process an instance of TemplateGapImportNames. */
    public RetType forTemplateGapImportNames(TemplateGapImportNames that);

    /** Process an instance of TemplateGapImportApi. */
    public RetType forTemplateGapImportApi(TemplateGapImportApi that);

    /** Process an instance of TemplateGapAliasedSimpleName. */
    public RetType forTemplateGapAliasedSimpleName(TemplateGapAliasedSimpleName that);

    /** Process an instance of TemplateGapAliasedAPIName. */
    public RetType forTemplateGapAliasedAPIName(TemplateGapAliasedAPIName that);

    /** Process an instance of TemplateGapDecl. */
    public RetType forTemplateGapDecl(TemplateGapDecl that);

    /** Process an instance of TemplateGapTraitObjectDecl. */
    public RetType forTemplateGapTraitObjectDecl(TemplateGapTraitObjectDecl that);

    /** Process an instance of TemplateGapTraitDecl. */
    public RetType forTemplateGapTraitDecl(TemplateGapTraitDecl that);

    /** Process an instance of TemplateGapObjectDecl. */
    public RetType forTemplateGapObjectDecl(TemplateGapObjectDecl that);

    /** Process an instance of TemplateGapVarDecl. */
    public RetType forTemplateGapVarDecl(TemplateGapVarDecl that);

    /** Process an instance of TemplateGapFnDecl. */
    public RetType forTemplateGapFnDecl(TemplateGapFnDecl that);

    /** Process an instance of TemplateGap_RewriteFnOverloadDecl. */
    public RetType forTemplateGap_RewriteFnOverloadDecl(TemplateGap_RewriteFnOverloadDecl that);

    /** Process an instance of TemplateGap_RewriteObjectExprDecl. */
    public RetType forTemplateGap_RewriteObjectExprDecl(TemplateGap_RewriteObjectExprDecl that);

    /** Process an instance of TemplateGap_RewriteFunctionalMethodDecl. */
    public RetType forTemplateGap_RewriteFunctionalMethodDecl(TemplateGap_RewriteFunctionalMethodDecl that);

    /** Process an instance of TemplateGapDimUnitDecl. */
    public RetType forTemplateGapDimUnitDecl(TemplateGapDimUnitDecl that);

    /** Process an instance of TemplateGapDimDecl. */
    public RetType forTemplateGapDimDecl(TemplateGapDimDecl that);

    /** Process an instance of TemplateGapUnitDecl. */
    public RetType forTemplateGapUnitDecl(TemplateGapUnitDecl that);

    /** Process an instance of TemplateGapTestDecl. */
    public RetType forTemplateGapTestDecl(TemplateGapTestDecl that);

    /** Process an instance of TemplateGapPropertyDecl. */
    public RetType forTemplateGapPropertyDecl(TemplateGapPropertyDecl that);

    /** Process an instance of TemplateGapTypeAlias. */
    public RetType forTemplateGapTypeAlias(TemplateGapTypeAlias that);

    /** Process an instance of TemplateGapGrammarDecl. */
    public RetType forTemplateGapGrammarDecl(TemplateGapGrammarDecl that);

    /** Process an instance of TemplateGapGrammarMemberDecl. */
    public RetType forTemplateGapGrammarMemberDecl(TemplateGapGrammarMemberDecl that);

    /** Process an instance of TemplateGapNonterminalDecl. */
    public RetType forTemplateGapNonterminalDecl(TemplateGapNonterminalDecl that);

    /** Process an instance of TemplateGapNonterminalDef. */
    public RetType forTemplateGapNonterminalDef(TemplateGapNonterminalDef that);

    /** Process an instance of TemplateGapNonterminalExtensionDef. */
    public RetType forTemplateGapNonterminalExtensionDef(TemplateGapNonterminalExtensionDef that);

    /** Process an instance of TemplateGapBinding. */
    public RetType forTemplateGapBinding(TemplateGapBinding that);

    /** Process an instance of TemplateGapLValue. */
    public RetType forTemplateGapLValue(TemplateGapLValue that);

    /** Process an instance of TemplateGapParam. */
    public RetType forTemplateGapParam(TemplateGapParam that);

    /** Process an instance of TemplateGapExpr. */
    public RetType forTemplateGapExpr(TemplateGapExpr that);

    /** Process an instance of TemplateGapDummyExpr. */
    public RetType forTemplateGapDummyExpr(TemplateGapDummyExpr that);

    /** Process an instance of TemplateGapTypeAnnotatedExpr. */
    public RetType forTemplateGapTypeAnnotatedExpr(TemplateGapTypeAnnotatedExpr that);

    /** Process an instance of TemplateGapAsExpr. */
    public RetType forTemplateGapAsExpr(TemplateGapAsExpr that);

    /** Process an instance of TemplateGapAsIfExpr. */
    public RetType forTemplateGapAsIfExpr(TemplateGapAsIfExpr that);

    /** Process an instance of TemplateGapAssignment. */
    public RetType forTemplateGapAssignment(TemplateGapAssignment that);

    /** Process an instance of TemplateGapBlock. */
    public RetType forTemplateGapBlock(TemplateGapBlock that);

    /** Process an instance of TemplateGapDo. */
    public RetType forTemplateGapDo(TemplateGapDo that);

    /** Process an instance of TemplateGapCaseExpr. */
    public RetType forTemplateGapCaseExpr(TemplateGapCaseExpr that);

    /** Process an instance of TemplateGapIf. */
    public RetType forTemplateGapIf(TemplateGapIf that);

    /** Process an instance of TemplateGapLabel. */
    public RetType forTemplateGapLabel(TemplateGapLabel that);

    /** Process an instance of TemplateGapAbstractObjectExpr. */
    public RetType forTemplateGapAbstractObjectExpr(TemplateGapAbstractObjectExpr that);

    /** Process an instance of TemplateGapObjectExpr. */
    public RetType forTemplateGapObjectExpr(TemplateGapObjectExpr that);

    /** Process an instance of TemplateGap_RewriteObjectExpr. */
    public RetType forTemplateGap_RewriteObjectExpr(TemplateGap_RewriteObjectExpr that);

    /** Process an instance of TemplateGapTry. */
    public RetType forTemplateGapTry(TemplateGapTry that);

    /** Process an instance of TemplateGapTupleExpr. */
    public RetType forTemplateGapTupleExpr(TemplateGapTupleExpr that);

    /** Process an instance of TemplateGapTypecase. */
    public RetType forTemplateGapTypecase(TemplateGapTypecase that);

    /** Process an instance of TemplateGapWhile. */
    public RetType forTemplateGapWhile(TemplateGapWhile that);

    /** Process an instance of TemplateGapFor. */
    public RetType forTemplateGapFor(TemplateGapFor that);

    /** Process an instance of TemplateGapBigOpApp. */
    public RetType forTemplateGapBigOpApp(TemplateGapBigOpApp that);

    /** Process an instance of TemplateGapAccumulator. */
    public RetType forTemplateGapAccumulator(TemplateGapAccumulator that);

    /** Process an instance of TemplateGapArrayComprehension. */
    public RetType forTemplateGapArrayComprehension(TemplateGapArrayComprehension that);

    /** Process an instance of TemplateGapAtomicExpr. */
    public RetType forTemplateGapAtomicExpr(TemplateGapAtomicExpr that);

    /** Process an instance of TemplateGapExit. */
    public RetType forTemplateGapExit(TemplateGapExit that);

    /** Process an instance of TemplateGapSpawn. */
    public RetType forTemplateGapSpawn(TemplateGapSpawn that);

    /** Process an instance of TemplateGapThrow. */
    public RetType forTemplateGapThrow(TemplateGapThrow that);

    /** Process an instance of TemplateGapTryAtomicExpr. */
    public RetType forTemplateGapTryAtomicExpr(TemplateGapTryAtomicExpr that);

    /** Process an instance of TemplateGapFnExpr. */
    public RetType forTemplateGapFnExpr(TemplateGapFnExpr that);

    /** Process an instance of TemplateGapLetExpr. */
    public RetType forTemplateGapLetExpr(TemplateGapLetExpr that);

    /** Process an instance of TemplateGapLetFn. */
    public RetType forTemplateGapLetFn(TemplateGapLetFn that);

    /** Process an instance of TemplateGapLocalVarDecl. */
    public RetType forTemplateGapLocalVarDecl(TemplateGapLocalVarDecl that);

    /** Process an instance of TemplateGapSimpleExpr. */
    public RetType forTemplateGapSimpleExpr(TemplateGapSimpleExpr that);

    /** Process an instance of TemplateGapSubscriptExpr. */
    public RetType forTemplateGapSubscriptExpr(TemplateGapSubscriptExpr that);

    /** Process an instance of TemplateGapPrimary. */
    public RetType forTemplateGapPrimary(TemplateGapPrimary that);

    /** Process an instance of TemplateGapLiteralExpr. */
    public RetType forTemplateGapLiteralExpr(TemplateGapLiteralExpr that);

    /** Process an instance of TemplateGapNumberLiteralExpr. */
    public RetType forTemplateGapNumberLiteralExpr(TemplateGapNumberLiteralExpr that);

    /** Process an instance of TemplateGapFloatLiteralExpr. */
    public RetType forTemplateGapFloatLiteralExpr(TemplateGapFloatLiteralExpr that);

    /** Process an instance of TemplateGapIntLiteralExpr. */
    public RetType forTemplateGapIntLiteralExpr(TemplateGapIntLiteralExpr that);

    /** Process an instance of TemplateGapCharLiteralExpr. */
    public RetType forTemplateGapCharLiteralExpr(TemplateGapCharLiteralExpr that);

    /** Process an instance of TemplateGapStringLiteralExpr. */
    public RetType forTemplateGapStringLiteralExpr(TemplateGapStringLiteralExpr that);

    /** Process an instance of TemplateGapVoidLiteralExpr. */
    public RetType forTemplateGapVoidLiteralExpr(TemplateGapVoidLiteralExpr that);

    /** Process an instance of TemplateGapBooleanLiteralExpr. */
    public RetType forTemplateGapBooleanLiteralExpr(TemplateGapBooleanLiteralExpr that);

    /** Process an instance of TemplateGapVarRef. */
    public RetType forTemplateGapVarRef(TemplateGapVarRef that);

    /** Process an instance of TemplateGapFieldRef. */
    public RetType forTemplateGapFieldRef(TemplateGapFieldRef that);

    /** Process an instance of TemplateGapFunctionalRef. */
    public RetType forTemplateGapFunctionalRef(TemplateGapFunctionalRef that);

    /** Process an instance of TemplateGapFnRef. */
    public RetType forTemplateGapFnRef(TemplateGapFnRef that);

    /** Process an instance of TemplateGapOpRef. */
    public RetType forTemplateGapOpRef(TemplateGapOpRef that);

    /** Process an instance of TemplateGap_RewriteFnRef. */
    public RetType forTemplateGap_RewriteFnRef(TemplateGap_RewriteFnRef that);

    /** Process an instance of TemplateGap_RewriteObjectExprRef. */
    public RetType forTemplateGap_RewriteObjectExprRef(TemplateGap_RewriteObjectExprRef that);

    /** Process an instance of TemplateGapJuxt. */
    public RetType forTemplateGapJuxt(TemplateGapJuxt that);

    /** Process an instance of TemplateGap_RewriteFnApp. */
    public RetType forTemplateGap_RewriteFnApp(TemplateGap_RewriteFnApp that);

    /** Process an instance of TemplateGapOpExpr. */
    public RetType forTemplateGapOpExpr(TemplateGapOpExpr that);

    /** Process an instance of TemplateGapAmbiguousMultifixOpExpr. */
    public RetType forTemplateGapAmbiguousMultifixOpExpr(TemplateGapAmbiguousMultifixOpExpr that);

    /** Process an instance of TemplateGapChainExpr. */
    public RetType forTemplateGapChainExpr(TemplateGapChainExpr that);

    /** Process an instance of TemplateGapCoercionInvocation. */
    public RetType forTemplateGapCoercionInvocation(TemplateGapCoercionInvocation that);

    /** Process an instance of TemplateGapTraitCoercionInvocation. */
    public RetType forTemplateGapTraitCoercionInvocation(TemplateGapTraitCoercionInvocation that);

    /** Process an instance of TemplateGapTupleCoercionInvocation. */
    public RetType forTemplateGapTupleCoercionInvocation(TemplateGapTupleCoercionInvocation that);

    /** Process an instance of TemplateGapArrowCoercionInvocation. */
    public RetType forTemplateGapArrowCoercionInvocation(TemplateGapArrowCoercionInvocation that);

    /** Process an instance of TemplateGapUnionCoercionInvocation. */
    public RetType forTemplateGapUnionCoercionInvocation(TemplateGapUnionCoercionInvocation that);

    /** Process an instance of TemplateGapMethodInvocation. */
    public RetType forTemplateGapMethodInvocation(TemplateGapMethodInvocation that);

    /** Process an instance of TemplateGapMathPrimary. */
    public RetType forTemplateGapMathPrimary(TemplateGapMathPrimary that);

    /** Process an instance of TemplateGapArrayExpr. */
    public RetType forTemplateGapArrayExpr(TemplateGapArrayExpr that);

    /** Process an instance of TemplateGapArrayElement. */
    public RetType forTemplateGapArrayElement(TemplateGapArrayElement that);

    /** Process an instance of TemplateGapArrayElements. */
    public RetType forTemplateGapArrayElements(TemplateGapArrayElements that);

    /** Process an instance of TemplateGapType. */
    public RetType forTemplateGapType(TemplateGapType that);

    /** Process an instance of TemplateGapBaseType. */
    public RetType forTemplateGapBaseType(TemplateGapBaseType that);

    /** Process an instance of TemplateGapAnyType. */
    public RetType forTemplateGapAnyType(TemplateGapAnyType that);

    /** Process an instance of TemplateGapBottomType. */
    public RetType forTemplateGapBottomType(TemplateGapBottomType that);

    /** Process an instance of TemplateGapUnknownType. */
    public RetType forTemplateGapUnknownType(TemplateGapUnknownType that);

    /** Process an instance of TemplateGapSelfType. */
    public RetType forTemplateGapSelfType(TemplateGapSelfType that);

    /** Process an instance of TemplateGapTraitSelfType. */
    public RetType forTemplateGapTraitSelfType(TemplateGapTraitSelfType that);

    /** Process an instance of TemplateGapObjectExprType. */
    public RetType forTemplateGapObjectExprType(TemplateGapObjectExprType that);

    /** Process an instance of TemplateGapNamedType. */
    public RetType forTemplateGapNamedType(TemplateGapNamedType that);

    /** Process an instance of TemplateGap_InferenceVarType. */
    public RetType forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that);

    /** Process an instance of TemplateGapVarType. */
    public RetType forTemplateGapVarType(TemplateGapVarType that);

    /** Process an instance of TemplateGapTraitType. */
    public RetType forTemplateGapTraitType(TemplateGapTraitType that);

    /** Process an instance of TemplateGapAbbreviatedType. */
    public RetType forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that);

    /** Process an instance of TemplateGapArrayType. */
    public RetType forTemplateGapArrayType(TemplateGapArrayType that);

    /** Process an instance of TemplateGapMatrixType. */
    public RetType forTemplateGapMatrixType(TemplateGapMatrixType that);

    /** Process an instance of TemplateGapTaggedDimType. */
    public RetType forTemplateGapTaggedDimType(TemplateGapTaggedDimType that);

    /** Process an instance of TemplateGapTaggedUnitType. */
    public RetType forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that);

    /** Process an instance of TemplateGapTupleType. */
    public RetType forTemplateGapTupleType(TemplateGapTupleType that);

    /** Process an instance of TemplateGapArrowType. */
    public RetType forTemplateGapArrowType(TemplateGapArrowType that);

    /** Process an instance of TemplateGapBoundType. */
    public RetType forTemplateGapBoundType(TemplateGapBoundType that);

    /** Process an instance of TemplateGapIntersectionType. */
    public RetType forTemplateGapIntersectionType(TemplateGapIntersectionType that);

    /** Process an instance of TemplateGapUnionType. */
    public RetType forTemplateGapUnionType(TemplateGapUnionType that);

    /** Process an instance of TemplateGapFixedPointType. */
    public RetType forTemplateGapFixedPointType(TemplateGapFixedPointType that);

    /** Process an instance of TemplateGapLabelType. */
    public RetType forTemplateGapLabelType(TemplateGapLabelType that);

    /** Process an instance of TemplateGapDimExpr. */
    public RetType forTemplateGapDimExpr(TemplateGapDimExpr that);

    /** Process an instance of TemplateGapDimBase. */
    public RetType forTemplateGapDimBase(TemplateGapDimBase that);

    /** Process an instance of TemplateGapDimRef. */
    public RetType forTemplateGapDimRef(TemplateGapDimRef that);

    /** Process an instance of TemplateGapDimExponent. */
    public RetType forTemplateGapDimExponent(TemplateGapDimExponent that);

    /** Process an instance of TemplateGapDimUnaryOp. */
    public RetType forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that);

    /** Process an instance of TemplateGapDimBinaryOp. */
    public RetType forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that);

    /** Process an instance of TemplateGapPattern. */
    public RetType forTemplateGapPattern(TemplateGapPattern that);

    /** Process an instance of TemplateGapPatternArgs. */
    public RetType forTemplateGapPatternArgs(TemplateGapPatternArgs that);

    /** Process an instance of TemplateGapPatternBinding. */
    public RetType forTemplateGapPatternBinding(TemplateGapPatternBinding that);

    /** Process an instance of TemplateGapPlainPattern. */
    public RetType forTemplateGapPlainPattern(TemplateGapPlainPattern that);

    /** Process an instance of TemplateGapTypePattern. */
    public RetType forTemplateGapTypePattern(TemplateGapTypePattern that);

    /** Process an instance of TemplateGapNestedPattern. */
    public RetType forTemplateGapNestedPattern(TemplateGapNestedPattern that);

    /** Process an instance of TemplateGapStaticArg. */
    public RetType forTemplateGapStaticArg(TemplateGapStaticArg that);

    /** Process an instance of TemplateGapTypeArg. */
    public RetType forTemplateGapTypeArg(TemplateGapTypeArg that);

    /** Process an instance of TemplateGapIntArg. */
    public RetType forTemplateGapIntArg(TemplateGapIntArg that);

    /** Process an instance of TemplateGapBoolArg. */
    public RetType forTemplateGapBoolArg(TemplateGapBoolArg that);

    /** Process an instance of TemplateGapOpArg. */
    public RetType forTemplateGapOpArg(TemplateGapOpArg that);

    /** Process an instance of TemplateGapDimArg. */
    public RetType forTemplateGapDimArg(TemplateGapDimArg that);

    /** Process an instance of TemplateGapUnitArg. */
    public RetType forTemplateGapUnitArg(TemplateGapUnitArg that);

    /** Process an instance of TemplateGapStaticExpr. */
    public RetType forTemplateGapStaticExpr(TemplateGapStaticExpr that);

    /** Process an instance of TemplateGapIntExpr. */
    public RetType forTemplateGapIntExpr(TemplateGapIntExpr that);

    /** Process an instance of TemplateGapIntBase. */
    public RetType forTemplateGapIntBase(TemplateGapIntBase that);

    /** Process an instance of TemplateGapIntRef. */
    public RetType forTemplateGapIntRef(TemplateGapIntRef that);

    /** Process an instance of TemplateGapIntBinaryOp. */
    public RetType forTemplateGapIntBinaryOp(TemplateGapIntBinaryOp that);

    /** Process an instance of TemplateGapBoolExpr. */
    public RetType forTemplateGapBoolExpr(TemplateGapBoolExpr that);

    /** Process an instance of TemplateGapBoolBase. */
    public RetType forTemplateGapBoolBase(TemplateGapBoolBase that);

    /** Process an instance of TemplateGapBoolRef. */
    public RetType forTemplateGapBoolRef(TemplateGapBoolRef that);

    /** Process an instance of TemplateGapBoolConstraint. */
    public RetType forTemplateGapBoolConstraint(TemplateGapBoolConstraint that);

    /** Process an instance of TemplateGapBoolUnaryOp. */
    public RetType forTemplateGapBoolUnaryOp(TemplateGapBoolUnaryOp that);

    /** Process an instance of TemplateGapBoolBinaryOp. */
    public RetType forTemplateGapBoolBinaryOp(TemplateGapBoolBinaryOp that);

    /** Process an instance of TemplateGapUnitExpr. */
    public RetType forTemplateGapUnitExpr(TemplateGapUnitExpr that);

    /** Process an instance of TemplateGapUnitRef. */
    public RetType forTemplateGapUnitRef(TemplateGapUnitRef that);

    /** Process an instance of TemplateGapUnitBinaryOp. */
    public RetType forTemplateGapUnitBinaryOp(TemplateGapUnitBinaryOp that);

    /** Process an instance of TemplateGapEffect. */
    public RetType forTemplateGapEffect(TemplateGapEffect that);

    /** Process an instance of TemplateGapWhereClause. */
    public RetType forTemplateGapWhereClause(TemplateGapWhereClause that);

    /** Process an instance of TemplateGapWhereBinding. */
    public RetType forTemplateGapWhereBinding(TemplateGapWhereBinding that);

    /** Process an instance of TemplateGapWhereConstraint. */
    public RetType forTemplateGapWhereConstraint(TemplateGapWhereConstraint that);

    /** Process an instance of TemplateGapWhereExtends. */
    public RetType forTemplateGapWhereExtends(TemplateGapWhereExtends that);

    /** Process an instance of TemplateGapWhereTypeAlias. */
    public RetType forTemplateGapWhereTypeAlias(TemplateGapWhereTypeAlias that);

    /** Process an instance of TemplateGapWhereCoerces. */
    public RetType forTemplateGapWhereCoerces(TemplateGapWhereCoerces that);

    /** Process an instance of TemplateGapWhereEquals. */
    public RetType forTemplateGapWhereEquals(TemplateGapWhereEquals that);

    /** Process an instance of TemplateGapUnitConstraint. */
    public RetType forTemplateGapUnitConstraint(TemplateGapUnitConstraint that);

    /** Process an instance of TemplateGapIntConstraint. */
    public RetType forTemplateGapIntConstraint(TemplateGapIntConstraint that);

    /** Process an instance of TemplateGapBoolConstraintExpr. */
    public RetType forTemplateGapBoolConstraintExpr(TemplateGapBoolConstraintExpr that);

    /** Process an instance of TemplateGapContract. */
    public RetType forTemplateGapContract(TemplateGapContract that);

    /** Process an instance of TemplateGapEnsuresClause. */
    public RetType forTemplateGapEnsuresClause(TemplateGapEnsuresClause that);

    /** Process an instance of TemplateGapStaticParam. */
    public RetType forTemplateGapStaticParam(TemplateGapStaticParam that);

    /** Process an instance of TemplateGapName. */
    public RetType forTemplateGapName(TemplateGapName that);

    /** Process an instance of TemplateGapAPIName. */
    public RetType forTemplateGapAPIName(TemplateGapAPIName that);

    /** Process an instance of TemplateGapIdOrOpOrAnonymousName. */
    public RetType forTemplateGapIdOrOpOrAnonymousName(TemplateGapIdOrOpOrAnonymousName that);

    /** Process an instance of TemplateGapIdOrOp. */
    public RetType forTemplateGapIdOrOp(TemplateGapIdOrOp that);

    /** Process an instance of TemplateGapId. */
    public RetType forTemplateGapId(TemplateGapId that);

    /** Process an instance of TemplateGapOp. */
    public RetType forTemplateGapOp(TemplateGapOp that);

    /** Process an instance of TemplateGapNamedOp. */
    public RetType forTemplateGapNamedOp(TemplateGapNamedOp that);

    /** Process an instance of TemplateGap_InferenceVarOp. */
    public RetType forTemplateGap_InferenceVarOp(TemplateGap_InferenceVarOp that);

    /** Process an instance of TemplateGapAnonymousName. */
    public RetType forTemplateGapAnonymousName(TemplateGapAnonymousName that);

    /** Process an instance of TemplateGapAnonymousFnName. */
    public RetType forTemplateGapAnonymousFnName(TemplateGapAnonymousFnName that);

    /** Process an instance of TemplateGapConstructorFnName. */
    public RetType forTemplateGapConstructorFnName(TemplateGapConstructorFnName that);

    /** Process an instance of TemplateGapArrayComprehensionClause. */
    public RetType forTemplateGapArrayComprehensionClause(TemplateGapArrayComprehensionClause that);

    /** Process an instance of TemplateGapKeywordExpr. */
    public RetType forTemplateGapKeywordExpr(TemplateGapKeywordExpr that);

    /** Process an instance of TemplateGapCaseClause. */
    public RetType forTemplateGapCaseClause(TemplateGapCaseClause that);

    /** Process an instance of TemplateGapCatch. */
    public RetType forTemplateGapCatch(TemplateGapCatch that);

    /** Process an instance of TemplateGapCatchClause. */
    public RetType forTemplateGapCatchClause(TemplateGapCatchClause that);

    /** Process an instance of TemplateGapIfClause. */
    public RetType forTemplateGapIfClause(TemplateGapIfClause that);

    /** Process an instance of TemplateGapTypecaseClause. */
    public RetType forTemplateGapTypecaseClause(TemplateGapTypecaseClause that);

    /** Process an instance of TemplateGapExtentRange. */
    public RetType forTemplateGapExtentRange(TemplateGapExtentRange that);

    /** Process an instance of TemplateGapGeneratorClause. */
    public RetType forTemplateGapGeneratorClause(TemplateGapGeneratorClause that);

    /** Process an instance of TemplateGapKeywordType. */
    public RetType forTemplateGapKeywordType(TemplateGapKeywordType that);

    /** Process an instance of TemplateGapTraitTypeWhere. */
    public RetType forTemplateGapTraitTypeWhere(TemplateGapTraitTypeWhere that);

    /** Process an instance of TemplateGapIndices. */
    public RetType forTemplateGapIndices(TemplateGapIndices that);

    /** Process an instance of TemplateGapMathItem. */
    public RetType forTemplateGapMathItem(TemplateGapMathItem that);

    /** Process an instance of TemplateGapExprMI. */
    public RetType forTemplateGapExprMI(TemplateGapExprMI that);

    /** Process an instance of TemplateGapParenthesisDelimitedMI. */
    public RetType forTemplateGapParenthesisDelimitedMI(TemplateGapParenthesisDelimitedMI that);

    /** Process an instance of TemplateGapNonParenthesisDelimitedMI. */
    public RetType forTemplateGapNonParenthesisDelimitedMI(TemplateGapNonParenthesisDelimitedMI that);

    /** Process an instance of TemplateGapNonExprMI. */
    public RetType forTemplateGapNonExprMI(TemplateGapNonExprMI that);

    /** Process an instance of TemplateGapExponentiationMI. */
    public RetType forTemplateGapExponentiationMI(TemplateGapExponentiationMI that);

    /** Process an instance of TemplateGapSubscriptingMI. */
    public RetType forTemplateGapSubscriptingMI(TemplateGapSubscriptingMI that);

    /** Process an instance of TemplateGapOverloading. */
    public RetType forTemplateGapOverloading(TemplateGapOverloading that);

    /** Process an instance of TemplateGapNonterminalHeader. */
    public RetType forTemplateGapNonterminalHeader(TemplateGapNonterminalHeader that);

    /** Process an instance of TemplateGapNonterminalParameter. */
    public RetType forTemplateGapNonterminalParameter(TemplateGapNonterminalParameter that);

    /** Process an instance of TemplateGapSyntaxDecl. */
    public RetType forTemplateGapSyntaxDecl(TemplateGapSyntaxDecl that);

    /** Process an instance of TemplateGapSyntaxDef. */
    public RetType forTemplateGapSyntaxDef(TemplateGapSyntaxDef that);

    /** Process an instance of TemplateGapSuperSyntaxDef. */
    public RetType forTemplateGapSuperSyntaxDef(TemplateGapSuperSyntaxDef that);

    /** Process an instance of TemplateGapTransformerDecl. */
    public RetType forTemplateGapTransformerDecl(TemplateGapTransformerDecl that);

    /** Process an instance of TemplateGapPreTransformerDef. */
    public RetType forTemplateGapPreTransformerDef(TemplateGapPreTransformerDef that);

    /** Process an instance of TemplateGapNamedTransformerDef. */
    public RetType forTemplateGapNamedTransformerDef(TemplateGapNamedTransformerDef that);

    /** Process an instance of TemplateGapTransformer. */
    public RetType forTemplateGapTransformer(TemplateGapTransformer that);

    /** Process an instance of TemplateGapUnparsedTransformer. */
    public RetType forTemplateGapUnparsedTransformer(TemplateGapUnparsedTransformer that);

    /** Process an instance of TemplateGapNodeTransformer. */
    public RetType forTemplateGapNodeTransformer(TemplateGapNodeTransformer that);

    /** Process an instance of TemplateGapCaseTransformer. */
    public RetType forTemplateGapCaseTransformer(TemplateGapCaseTransformer that);

    /** Process an instance of TemplateGapCaseTransformerClause. */
    public RetType forTemplateGapCaseTransformerClause(TemplateGapCaseTransformerClause that);

    /** Process an instance of TemplateGapSyntaxSymbol. */
    public RetType forTemplateGapSyntaxSymbol(TemplateGapSyntaxSymbol that);

    /** Process an instance of TemplateGapPrefixedSymbol. */
    public RetType forTemplateGapPrefixedSymbol(TemplateGapPrefixedSymbol that);

    /** Process an instance of TemplateGapOptionalSymbol. */
    public RetType forTemplateGapOptionalSymbol(TemplateGapOptionalSymbol that);

    /** Process an instance of TemplateGapRepeatSymbol. */
    public RetType forTemplateGapRepeatSymbol(TemplateGapRepeatSymbol that);

    /** Process an instance of TemplateGapRepeatOneOrMoreSymbol. */
    public RetType forTemplateGapRepeatOneOrMoreSymbol(TemplateGapRepeatOneOrMoreSymbol that);

    /** Process an instance of TemplateGapNoWhitespaceSymbol. */
    public RetType forTemplateGapNoWhitespaceSymbol(TemplateGapNoWhitespaceSymbol that);

    /** Process an instance of TemplateGapGroupSymbol. */
    public RetType forTemplateGapGroupSymbol(TemplateGapGroupSymbol that);

    /** Process an instance of TemplateGapSpecialSymbol. */
    public RetType forTemplateGapSpecialSymbol(TemplateGapSpecialSymbol that);

    /** Process an instance of TemplateGapAnyCharacterSymbol. */
    public RetType forTemplateGapAnyCharacterSymbol(TemplateGapAnyCharacterSymbol that);

    /** Process an instance of TemplateGapWhitespaceSymbol. */
    public RetType forTemplateGapWhitespaceSymbol(TemplateGapWhitespaceSymbol that);

    /** Process an instance of TemplateGapTabSymbol. */
    public RetType forTemplateGapTabSymbol(TemplateGapTabSymbol that);

    /** Process an instance of TemplateGapFormfeedSymbol. */
    public RetType forTemplateGapFormfeedSymbol(TemplateGapFormfeedSymbol that);

    /** Process an instance of TemplateGapCarriageReturnSymbol. */
    public RetType forTemplateGapCarriageReturnSymbol(TemplateGapCarriageReturnSymbol that);

    /** Process an instance of TemplateGapBackspaceSymbol. */
    public RetType forTemplateGapBackspaceSymbol(TemplateGapBackspaceSymbol that);

    /** Process an instance of TemplateGapNewlineSymbol. */
    public RetType forTemplateGapNewlineSymbol(TemplateGapNewlineSymbol that);

    /** Process an instance of TemplateGapBreaklineSymbol. */
    public RetType forTemplateGapBreaklineSymbol(TemplateGapBreaklineSymbol that);

    /** Process an instance of TemplateGapItemSymbol. */
    public RetType forTemplateGapItemSymbol(TemplateGapItemSymbol that);

    /** Process an instance of TemplateGapNonterminalSymbol. */
    public RetType forTemplateGapNonterminalSymbol(TemplateGapNonterminalSymbol that);

    /** Process an instance of TemplateGapKeywordSymbol. */
    public RetType forTemplateGapKeywordSymbol(TemplateGapKeywordSymbol that);

    /** Process an instance of TemplateGapTokenSymbol. */
    public RetType forTemplateGapTokenSymbol(TemplateGapTokenSymbol that);

    /** Process an instance of TemplateGapNotPredicateSymbol. */
    public RetType forTemplateGapNotPredicateSymbol(TemplateGapNotPredicateSymbol that);

    /** Process an instance of TemplateGapAndPredicateSymbol. */
    public RetType forTemplateGapAndPredicateSymbol(TemplateGapAndPredicateSymbol that);

    /** Process an instance of TemplateGapCharacterClassSymbol. */
    public RetType forTemplateGapCharacterClassSymbol(TemplateGapCharacterClassSymbol that);

    /** Process an instance of TemplateGapCharacterSymbol. */
    public RetType forTemplateGapCharacterSymbol(TemplateGapCharacterSymbol that);

    /** Process an instance of TemplateGapCharSymbol. */
    public RetType forTemplateGapCharSymbol(TemplateGapCharSymbol that);

    /** Process an instance of TemplateGapCharacterInterval. */
    public RetType forTemplateGapCharacterInterval(TemplateGapCharacterInterval that);

    /** Process an instance of TemplateGapLink. */
    public RetType forTemplateGapLink(TemplateGapLink that);
}
