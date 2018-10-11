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

/** An abstract visitor over AbstractNode that provides a lambda value method;
  * all visit methods are left unimplemented. */
@SuppressWarnings("unused")
public abstract class AbstractNodeVisitorLambda<RetType> implements edu.rice.cs.plt.lambda.Lambda<AbstractNode, RetType>, AbstractNodeVisitor<RetType> {

    public RetType value(AbstractNode that) {
        return that.accept(this);
    }


    /** Process an instance of Component. */
    public abstract RetType forComponent(Component that);

    /** Process an instance of Api. */
    public abstract RetType forApi(Api that);

    /** Process an instance of ImportStar. */
    public abstract RetType forImportStar(ImportStar that);

    /** Process an instance of ImportNames. */
    public abstract RetType forImportNames(ImportNames that);

    /** Process an instance of ImportApi. */
    public abstract RetType forImportApi(ImportApi that);

    /** Process an instance of AliasedSimpleName. */
    public abstract RetType forAliasedSimpleName(AliasedSimpleName that);

    /** Process an instance of AliasedAPIName. */
    public abstract RetType forAliasedAPIName(AliasedAPIName that);

    /** Process an instance of TraitDecl. */
    public abstract RetType forTraitDecl(TraitDecl that);

    /** Process an instance of ObjectDecl. */
    public abstract RetType forObjectDecl(ObjectDecl that);

    /** Process an instance of VarDecl. */
    public abstract RetType forVarDecl(VarDecl that);

    /** Process an instance of FnDecl. */
    public abstract RetType forFnDecl(FnDecl that);

    /** Process an instance of _RewriteFnOverloadDecl. */
    public abstract RetType for_RewriteFnOverloadDecl(_RewriteFnOverloadDecl that);

    /** Process an instance of _RewriteObjectExprDecl. */
    public abstract RetType for_RewriteObjectExprDecl(_RewriteObjectExprDecl that);

    /** Process an instance of _RewriteFunctionalMethodDecl. */
    public abstract RetType for_RewriteFunctionalMethodDecl(_RewriteFunctionalMethodDecl that);

    /** Process an instance of DimDecl. */
    public abstract RetType forDimDecl(DimDecl that);

    /** Process an instance of UnitDecl. */
    public abstract RetType forUnitDecl(UnitDecl that);

    /** Process an instance of TestDecl. */
    public abstract RetType forTestDecl(TestDecl that);

    /** Process an instance of PropertyDecl. */
    public abstract RetType forPropertyDecl(PropertyDecl that);

    /** Process an instance of TypeAlias. */
    public abstract RetType forTypeAlias(TypeAlias that);

    /** Process an instance of GrammarDecl. */
    public abstract RetType forGrammarDecl(GrammarDecl that);

    /** Process an instance of NonterminalDef. */
    public abstract RetType forNonterminalDef(NonterminalDef that);

    /** Process an instance of NonterminalExtensionDef. */
    public abstract RetType forNonterminalExtensionDef(NonterminalExtensionDef that);

    /** Process an instance of LValue. */
    public abstract RetType forLValue(LValue that);

    /** Process an instance of Param. */
    public abstract RetType forParam(Param that);

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

    /** Process an instance of AnyType. */
    public abstract RetType forAnyType(AnyType that);

    /** Process an instance of BottomType. */
    public abstract RetType forBottomType(BottomType that);

    /** Process an instance of UnknownType. */
    public abstract RetType forUnknownType(UnknownType that);

    /** Process an instance of TraitSelfType. */
    public abstract RetType forTraitSelfType(TraitSelfType that);

    /** Process an instance of ObjectExprType. */
    public abstract RetType forObjectExprType(ObjectExprType that);

    /** Process an instance of _InferenceVarType. */
    public abstract RetType for_InferenceVarType(_InferenceVarType that);

    /** Process an instance of VarType. */
    public abstract RetType forVarType(VarType that);

    /** Process an instance of TraitType. */
    public abstract RetType forTraitType(TraitType that);

    /** Process an instance of ArrayType. */
    public abstract RetType forArrayType(ArrayType that);

    /** Process an instance of MatrixType. */
    public abstract RetType forMatrixType(MatrixType that);

    /** Process an instance of TaggedDimType. */
    public abstract RetType forTaggedDimType(TaggedDimType that);

    /** Process an instance of TaggedUnitType. */
    public abstract RetType forTaggedUnitType(TaggedUnitType that);

    /** Process an instance of TupleType. */
    public abstract RetType forTupleType(TupleType that);

    /** Process an instance of ArrowType. */
    public abstract RetType forArrowType(ArrowType that);

    /** Process an instance of IntersectionType. */
    public abstract RetType forIntersectionType(IntersectionType that);

    /** Process an instance of UnionType. */
    public abstract RetType forUnionType(UnionType that);

    /** Process an instance of FixedPointType. */
    public abstract RetType forFixedPointType(FixedPointType that);

    /** Process an instance of LabelType. */
    public abstract RetType forLabelType(LabelType that);

    /** Process an instance of DimBase. */
    public abstract RetType forDimBase(DimBase that);

    /** Process an instance of DimRef. */
    public abstract RetType forDimRef(DimRef that);

    /** Process an instance of DimExponent. */
    public abstract RetType forDimExponent(DimExponent that);

    /** Process an instance of DimUnaryOp. */
    public abstract RetType forDimUnaryOp(DimUnaryOp that);

    /** Process an instance of DimBinaryOp. */
    public abstract RetType forDimBinaryOp(DimBinaryOp that);

    /** Process an instance of Pattern. */
    public abstract RetType forPattern(Pattern that);

    /** Process an instance of PatternArgs. */
    public abstract RetType forPatternArgs(PatternArgs that);

    /** Process an instance of PlainPattern. */
    public abstract RetType forPlainPattern(PlainPattern that);

    /** Process an instance of TypePattern. */
    public abstract RetType forTypePattern(TypePattern that);

    /** Process an instance of NestedPattern. */
    public abstract RetType forNestedPattern(NestedPattern that);

    /** Process an instance of TypeArg. */
    public abstract RetType forTypeArg(TypeArg that);

    /** Process an instance of IntArg. */
    public abstract RetType forIntArg(IntArg that);

    /** Process an instance of BoolArg. */
    public abstract RetType forBoolArg(BoolArg that);

    /** Process an instance of OpArg. */
    public abstract RetType forOpArg(OpArg that);

    /** Process an instance of DimArg. */
    public abstract RetType forDimArg(DimArg that);

    /** Process an instance of UnitArg. */
    public abstract RetType forUnitArg(UnitArg that);

    /** Process an instance of IntBase. */
    public abstract RetType forIntBase(IntBase that);

    /** Process an instance of IntRef. */
    public abstract RetType forIntRef(IntRef that);

    /** Process an instance of IntBinaryOp. */
    public abstract RetType forIntBinaryOp(IntBinaryOp that);

    /** Process an instance of BoolBase. */
    public abstract RetType forBoolBase(BoolBase that);

    /** Process an instance of BoolRef. */
    public abstract RetType forBoolRef(BoolRef that);

    /** Process an instance of BoolUnaryOp. */
    public abstract RetType forBoolUnaryOp(BoolUnaryOp that);

    /** Process an instance of BoolBinaryOp. */
    public abstract RetType forBoolBinaryOp(BoolBinaryOp that);

    /** Process an instance of UnitRef. */
    public abstract RetType forUnitRef(UnitRef that);

    /** Process an instance of UnitBinaryOp. */
    public abstract RetType forUnitBinaryOp(UnitBinaryOp that);

    /** Process an instance of Effect. */
    public abstract RetType forEffect(Effect that);

    /** Process an instance of WhereClause. */
    public abstract RetType forWhereClause(WhereClause that);

    /** Process an instance of WhereBinding. */
    public abstract RetType forWhereBinding(WhereBinding that);

    /** Process an instance of WhereExtends. */
    public abstract RetType forWhereExtends(WhereExtends that);

    /** Process an instance of WhereTypeAlias. */
    public abstract RetType forWhereTypeAlias(WhereTypeAlias that);

    /** Process an instance of WhereCoerces. */
    public abstract RetType forWhereCoerces(WhereCoerces that);

    /** Process an instance of WhereEquals. */
    public abstract RetType forWhereEquals(WhereEquals that);

    /** Process an instance of UnitConstraint. */
    public abstract RetType forUnitConstraint(UnitConstraint that);

    /** Process an instance of IntConstraint. */
    public abstract RetType forIntConstraint(IntConstraint that);

    /** Process an instance of BoolConstraintExpr. */
    public abstract RetType forBoolConstraintExpr(BoolConstraintExpr that);

    /** Process an instance of Contract. */
    public abstract RetType forContract(Contract that);

    /** Process an instance of EnsuresClause. */
    public abstract RetType forEnsuresClause(EnsuresClause that);

    /** Process an instance of StaticParam. */
    public abstract RetType forStaticParam(StaticParam that);

    /** Process an instance of APIName. */
    public abstract RetType forAPIName(APIName that);

    /** Process an instance of Id. */
    public abstract RetType forId(Id that);

    /** Process an instance of NamedOp. */
    public abstract RetType forNamedOp(NamedOp that);

    /** Process an instance of _InferenceVarOp. */
    public abstract RetType for_InferenceVarOp(_InferenceVarOp that);

    /** Process an instance of AnonymousFnName. */
    public abstract RetType forAnonymousFnName(AnonymousFnName that);

    /** Process an instance of ConstructorFnName. */
    public abstract RetType forConstructorFnName(ConstructorFnName that);

    /** Process an instance of ArrayComprehensionClause. */
    public abstract RetType forArrayComprehensionClause(ArrayComprehensionClause that);

    /** Process an instance of KeywordExpr. */
    public abstract RetType forKeywordExpr(KeywordExpr that);

    /** Process an instance of CaseClause. */
    public abstract RetType forCaseClause(CaseClause that);

    /** Process an instance of Catch. */
    public abstract RetType forCatch(Catch that);

    /** Process an instance of CatchClause. */
    public abstract RetType forCatchClause(CatchClause that);

    /** Process an instance of IfClause. */
    public abstract RetType forIfClause(IfClause that);

    /** Process an instance of TypecaseClause. */
    public abstract RetType forTypecaseClause(TypecaseClause that);

    /** Process an instance of ExtentRange. */
    public abstract RetType forExtentRange(ExtentRange that);

    /** Process an instance of GeneratorClause. */
    public abstract RetType forGeneratorClause(GeneratorClause that);

    /** Process an instance of KeywordType. */
    public abstract RetType forKeywordType(KeywordType that);

    /** Process an instance of TraitTypeWhere. */
    public abstract RetType forTraitTypeWhere(TraitTypeWhere that);

    /** Process an instance of Indices. */
    public abstract RetType forIndices(Indices that);

    /** Process an instance of ParenthesisDelimitedMI. */
    public abstract RetType forParenthesisDelimitedMI(ParenthesisDelimitedMI that);

    /** Process an instance of NonParenthesisDelimitedMI. */
    public abstract RetType forNonParenthesisDelimitedMI(NonParenthesisDelimitedMI that);

    /** Process an instance of ExponentiationMI. */
    public abstract RetType forExponentiationMI(ExponentiationMI that);

    /** Process an instance of SubscriptingMI. */
    public abstract RetType forSubscriptingMI(SubscriptingMI that);

    /** Process an instance of Overloading. */
    public abstract RetType forOverloading(Overloading that);

    /** Process an instance of NonterminalHeader. */
    public abstract RetType forNonterminalHeader(NonterminalHeader that);

    /** Process an instance of NonterminalParameter. */
    public abstract RetType forNonterminalParameter(NonterminalParameter that);

    /** Process an instance of SyntaxDef. */
    public abstract RetType forSyntaxDef(SyntaxDef that);

    /** Process an instance of SuperSyntaxDef. */
    public abstract RetType forSuperSyntaxDef(SuperSyntaxDef that);

    /** Process an instance of PreTransformerDef. */
    public abstract RetType forPreTransformerDef(PreTransformerDef that);

    /** Process an instance of NamedTransformerDef. */
    public abstract RetType forNamedTransformerDef(NamedTransformerDef that);

    /** Process an instance of UnparsedTransformer. */
    public abstract RetType forUnparsedTransformer(UnparsedTransformer that);

    /** Process an instance of NodeTransformer. */
    public abstract RetType forNodeTransformer(NodeTransformer that);

    /** Process an instance of CaseTransformer. */
    public abstract RetType forCaseTransformer(CaseTransformer that);

    /** Process an instance of CaseTransformerClause. */
    public abstract RetType forCaseTransformerClause(CaseTransformerClause that);

    /** Process an instance of PrefixedSymbol. */
    public abstract RetType forPrefixedSymbol(PrefixedSymbol that);

    /** Process an instance of OptionalSymbol. */
    public abstract RetType forOptionalSymbol(OptionalSymbol that);

    /** Process an instance of RepeatSymbol. */
    public abstract RetType forRepeatSymbol(RepeatSymbol that);

    /** Process an instance of RepeatOneOrMoreSymbol. */
    public abstract RetType forRepeatOneOrMoreSymbol(RepeatOneOrMoreSymbol that);

    /** Process an instance of NoWhitespaceSymbol. */
    public abstract RetType forNoWhitespaceSymbol(NoWhitespaceSymbol that);

    /** Process an instance of GroupSymbol. */
    public abstract RetType forGroupSymbol(GroupSymbol that);

    /** Process an instance of AnyCharacterSymbol. */
    public abstract RetType forAnyCharacterSymbol(AnyCharacterSymbol that);

    /** Process an instance of WhitespaceSymbol. */
    public abstract RetType forWhitespaceSymbol(WhitespaceSymbol that);

    /** Process an instance of TabSymbol. */
    public abstract RetType forTabSymbol(TabSymbol that);

    /** Process an instance of FormfeedSymbol. */
    public abstract RetType forFormfeedSymbol(FormfeedSymbol that);

    /** Process an instance of CarriageReturnSymbol. */
    public abstract RetType forCarriageReturnSymbol(CarriageReturnSymbol that);

    /** Process an instance of BackspaceSymbol. */
    public abstract RetType forBackspaceSymbol(BackspaceSymbol that);

    /** Process an instance of NewlineSymbol. */
    public abstract RetType forNewlineSymbol(NewlineSymbol that);

    /** Process an instance of BreaklineSymbol. */
    public abstract RetType forBreaklineSymbol(BreaklineSymbol that);

    /** Process an instance of ItemSymbol. */
    public abstract RetType forItemSymbol(ItemSymbol that);

    /** Process an instance of NonterminalSymbol. */
    public abstract RetType forNonterminalSymbol(NonterminalSymbol that);

    /** Process an instance of KeywordSymbol. */
    public abstract RetType forKeywordSymbol(KeywordSymbol that);

    /** Process an instance of TokenSymbol. */
    public abstract RetType forTokenSymbol(TokenSymbol that);

    /** Process an instance of NotPredicateSymbol. */
    public abstract RetType forNotPredicateSymbol(NotPredicateSymbol that);

    /** Process an instance of AndPredicateSymbol. */
    public abstract RetType forAndPredicateSymbol(AndPredicateSymbol that);

    /** Process an instance of CharacterClassSymbol. */
    public abstract RetType forCharacterClassSymbol(CharacterClassSymbol that);

    /** Process an instance of CharSymbol. */
    public abstract RetType forCharSymbol(CharSymbol that);

    /** Process an instance of CharacterInterval. */
    public abstract RetType forCharacterInterval(CharacterInterval that);

    /** Process an instance of Link. */
    public abstract RetType forLink(Link that);

    /** Process an instance of _SyntaxTransformationAbstractNode. */
    public abstract RetType for_SyntaxTransformationAbstractNode(_SyntaxTransformationAbstractNode that);

    /** Process an instance of _SyntaxTransformationCompilationUnit. */
    public abstract RetType for_SyntaxTransformationCompilationUnit(_SyntaxTransformationCompilationUnit that);

    /** Process an instance of _SyntaxTransformationComponent. */
    public abstract RetType for_SyntaxTransformationComponent(_SyntaxTransformationComponent that);

    /** Process an instance of _SyntaxTransformationApi. */
    public abstract RetType for_SyntaxTransformationApi(_SyntaxTransformationApi that);

    /** Process an instance of _SyntaxTransformationImport. */
    public abstract RetType for_SyntaxTransformationImport(_SyntaxTransformationImport that);

    /** Process an instance of _SyntaxTransformationImportedNames. */
    public abstract RetType for_SyntaxTransformationImportedNames(_SyntaxTransformationImportedNames that);

    /** Process an instance of _SyntaxTransformationImportStar. */
    public abstract RetType for_SyntaxTransformationImportStar(_SyntaxTransformationImportStar that);

    /** Process an instance of _SyntaxTransformationImportNames. */
    public abstract RetType for_SyntaxTransformationImportNames(_SyntaxTransformationImportNames that);

    /** Process an instance of _SyntaxTransformationImportApi. */
    public abstract RetType for_SyntaxTransformationImportApi(_SyntaxTransformationImportApi that);

    /** Process an instance of _SyntaxTransformationAliasedSimpleName. */
    public abstract RetType for_SyntaxTransformationAliasedSimpleName(_SyntaxTransformationAliasedSimpleName that);

    /** Process an instance of _SyntaxTransformationAliasedAPIName. */
    public abstract RetType for_SyntaxTransformationAliasedAPIName(_SyntaxTransformationAliasedAPIName that);

    /** Process an instance of _SyntaxTransformationDecl. */
    public abstract RetType for_SyntaxTransformationDecl(_SyntaxTransformationDecl that);

    /** Process an instance of _SyntaxTransformationTraitObjectDecl. */
    public abstract RetType for_SyntaxTransformationTraitObjectDecl(_SyntaxTransformationTraitObjectDecl that);

    /** Process an instance of _SyntaxTransformationTraitDecl. */
    public abstract RetType for_SyntaxTransformationTraitDecl(_SyntaxTransformationTraitDecl that);

    /** Process an instance of _SyntaxTransformationObjectDecl. */
    public abstract RetType for_SyntaxTransformationObjectDecl(_SyntaxTransformationObjectDecl that);

    /** Process an instance of _SyntaxTransformationVarDecl. */
    public abstract RetType for_SyntaxTransformationVarDecl(_SyntaxTransformationVarDecl that);

    /** Process an instance of _SyntaxTransformationFnDecl. */
    public abstract RetType for_SyntaxTransformationFnDecl(_SyntaxTransformationFnDecl that);

    /** Process an instance of _SyntaxTransformation_RewriteFnOverloadDecl. */
    public abstract RetType for_SyntaxTransformation_RewriteFnOverloadDecl(_SyntaxTransformation_RewriteFnOverloadDecl that);

    /** Process an instance of _SyntaxTransformation_RewriteObjectExprDecl. */
    public abstract RetType for_SyntaxTransformation_RewriteObjectExprDecl(_SyntaxTransformation_RewriteObjectExprDecl that);

    /** Process an instance of _SyntaxTransformation_RewriteFunctionalMethodDecl. */
    public abstract RetType for_SyntaxTransformation_RewriteFunctionalMethodDecl(_SyntaxTransformation_RewriteFunctionalMethodDecl that);

    /** Process an instance of _SyntaxTransformationDimUnitDecl. */
    public abstract RetType for_SyntaxTransformationDimUnitDecl(_SyntaxTransformationDimUnitDecl that);

    /** Process an instance of _SyntaxTransformationDimDecl. */
    public abstract RetType for_SyntaxTransformationDimDecl(_SyntaxTransformationDimDecl that);

    /** Process an instance of _SyntaxTransformationUnitDecl. */
    public abstract RetType for_SyntaxTransformationUnitDecl(_SyntaxTransformationUnitDecl that);

    /** Process an instance of _SyntaxTransformationTestDecl. */
    public abstract RetType for_SyntaxTransformationTestDecl(_SyntaxTransformationTestDecl that);

    /** Process an instance of _SyntaxTransformationPropertyDecl. */
    public abstract RetType for_SyntaxTransformationPropertyDecl(_SyntaxTransformationPropertyDecl that);

    /** Process an instance of _SyntaxTransformationTypeAlias. */
    public abstract RetType for_SyntaxTransformationTypeAlias(_SyntaxTransformationTypeAlias that);

    /** Process an instance of _SyntaxTransformationGrammarDecl. */
    public abstract RetType for_SyntaxTransformationGrammarDecl(_SyntaxTransformationGrammarDecl that);

    /** Process an instance of _SyntaxTransformationGrammarMemberDecl. */
    public abstract RetType for_SyntaxTransformationGrammarMemberDecl(_SyntaxTransformationGrammarMemberDecl that);

    /** Process an instance of _SyntaxTransformationNonterminalDecl. */
    public abstract RetType for_SyntaxTransformationNonterminalDecl(_SyntaxTransformationNonterminalDecl that);

    /** Process an instance of _SyntaxTransformationNonterminalDef. */
    public abstract RetType for_SyntaxTransformationNonterminalDef(_SyntaxTransformationNonterminalDef that);

    /** Process an instance of _SyntaxTransformationNonterminalExtensionDef. */
    public abstract RetType for_SyntaxTransformationNonterminalExtensionDef(_SyntaxTransformationNonterminalExtensionDef that);

    /** Process an instance of _SyntaxTransformationBinding. */
    public abstract RetType for_SyntaxTransformationBinding(_SyntaxTransformationBinding that);

    /** Process an instance of _SyntaxTransformationLValue. */
    public abstract RetType for_SyntaxTransformationLValue(_SyntaxTransformationLValue that);

    /** Process an instance of _SyntaxTransformationParam. */
    public abstract RetType for_SyntaxTransformationParam(_SyntaxTransformationParam that);

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

    /** Process an instance of _SyntaxTransformationType. */
    public abstract RetType for_SyntaxTransformationType(_SyntaxTransformationType that);

    /** Process an instance of _SyntaxTransformationBaseType. */
    public abstract RetType for_SyntaxTransformationBaseType(_SyntaxTransformationBaseType that);

    /** Process an instance of _SyntaxTransformationAnyType. */
    public abstract RetType for_SyntaxTransformationAnyType(_SyntaxTransformationAnyType that);

    /** Process an instance of _SyntaxTransformationBottomType. */
    public abstract RetType for_SyntaxTransformationBottomType(_SyntaxTransformationBottomType that);

    /** Process an instance of _SyntaxTransformationUnknownType. */
    public abstract RetType for_SyntaxTransformationUnknownType(_SyntaxTransformationUnknownType that);

    /** Process an instance of _SyntaxTransformationSelfType. */
    public abstract RetType for_SyntaxTransformationSelfType(_SyntaxTransformationSelfType that);

    /** Process an instance of _SyntaxTransformationTraitSelfType. */
    public abstract RetType for_SyntaxTransformationTraitSelfType(_SyntaxTransformationTraitSelfType that);

    /** Process an instance of _SyntaxTransformationObjectExprType. */
    public abstract RetType for_SyntaxTransformationObjectExprType(_SyntaxTransformationObjectExprType that);

    /** Process an instance of _SyntaxTransformationNamedType. */
    public abstract RetType for_SyntaxTransformationNamedType(_SyntaxTransformationNamedType that);

    /** Process an instance of _SyntaxTransformation_InferenceVarType. */
    public abstract RetType for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that);

    /** Process an instance of _SyntaxTransformationVarType. */
    public abstract RetType for_SyntaxTransformationVarType(_SyntaxTransformationVarType that);

    /** Process an instance of _SyntaxTransformationTraitType. */
    public abstract RetType for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that);

    /** Process an instance of _SyntaxTransformationAbbreviatedType. */
    public abstract RetType for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that);

    /** Process an instance of _SyntaxTransformationArrayType. */
    public abstract RetType for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that);

    /** Process an instance of _SyntaxTransformationMatrixType. */
    public abstract RetType for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that);

    /** Process an instance of _SyntaxTransformationTaggedDimType. */
    public abstract RetType for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that);

    /** Process an instance of _SyntaxTransformationTaggedUnitType. */
    public abstract RetType for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that);

    /** Process an instance of _SyntaxTransformationTupleType. */
    public abstract RetType for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that);

    /** Process an instance of _SyntaxTransformationArrowType. */
    public abstract RetType for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that);

    /** Process an instance of _SyntaxTransformationBoundType. */
    public abstract RetType for_SyntaxTransformationBoundType(_SyntaxTransformationBoundType that);

    /** Process an instance of _SyntaxTransformationIntersectionType. */
    public abstract RetType for_SyntaxTransformationIntersectionType(_SyntaxTransformationIntersectionType that);

    /** Process an instance of _SyntaxTransformationUnionType. */
    public abstract RetType for_SyntaxTransformationUnionType(_SyntaxTransformationUnionType that);

    /** Process an instance of _SyntaxTransformationFixedPointType. */
    public abstract RetType for_SyntaxTransformationFixedPointType(_SyntaxTransformationFixedPointType that);

    /** Process an instance of _SyntaxTransformationLabelType. */
    public abstract RetType for_SyntaxTransformationLabelType(_SyntaxTransformationLabelType that);

    /** Process an instance of _SyntaxTransformationDimExpr. */
    public abstract RetType for_SyntaxTransformationDimExpr(_SyntaxTransformationDimExpr that);

    /** Process an instance of _SyntaxTransformationDimBase. */
    public abstract RetType for_SyntaxTransformationDimBase(_SyntaxTransformationDimBase that);

    /** Process an instance of _SyntaxTransformationDimRef. */
    public abstract RetType for_SyntaxTransformationDimRef(_SyntaxTransformationDimRef that);

    /** Process an instance of _SyntaxTransformationDimExponent. */
    public abstract RetType for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that);

    /** Process an instance of _SyntaxTransformationDimUnaryOp. */
    public abstract RetType for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that);

    /** Process an instance of _SyntaxTransformationDimBinaryOp. */
    public abstract RetType for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that);

    /** Process an instance of _SyntaxTransformationPattern. */
    public abstract RetType for_SyntaxTransformationPattern(_SyntaxTransformationPattern that);

    /** Process an instance of _SyntaxTransformationPatternArgs. */
    public abstract RetType for_SyntaxTransformationPatternArgs(_SyntaxTransformationPatternArgs that);

    /** Process an instance of _SyntaxTransformationPatternBinding. */
    public abstract RetType for_SyntaxTransformationPatternBinding(_SyntaxTransformationPatternBinding that);

    /** Process an instance of _SyntaxTransformationPlainPattern. */
    public abstract RetType for_SyntaxTransformationPlainPattern(_SyntaxTransformationPlainPattern that);

    /** Process an instance of _SyntaxTransformationTypePattern. */
    public abstract RetType for_SyntaxTransformationTypePattern(_SyntaxTransformationTypePattern that);

    /** Process an instance of _SyntaxTransformationNestedPattern. */
    public abstract RetType for_SyntaxTransformationNestedPattern(_SyntaxTransformationNestedPattern that);

    /** Process an instance of _SyntaxTransformationStaticArg. */
    public abstract RetType for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that);

    /** Process an instance of _SyntaxTransformationTypeArg. */
    public abstract RetType for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that);

    /** Process an instance of _SyntaxTransformationIntArg. */
    public abstract RetType for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that);

    /** Process an instance of _SyntaxTransformationBoolArg. */
    public abstract RetType for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that);

    /** Process an instance of _SyntaxTransformationOpArg. */
    public abstract RetType for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that);

    /** Process an instance of _SyntaxTransformationDimArg. */
    public abstract RetType for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that);

    /** Process an instance of _SyntaxTransformationUnitArg. */
    public abstract RetType for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that);

    /** Process an instance of _SyntaxTransformationStaticExpr. */
    public abstract RetType for_SyntaxTransformationStaticExpr(_SyntaxTransformationStaticExpr that);

    /** Process an instance of _SyntaxTransformationIntExpr. */
    public abstract RetType for_SyntaxTransformationIntExpr(_SyntaxTransformationIntExpr that);

    /** Process an instance of _SyntaxTransformationIntBase. */
    public abstract RetType for_SyntaxTransformationIntBase(_SyntaxTransformationIntBase that);

    /** Process an instance of _SyntaxTransformationIntRef. */
    public abstract RetType for_SyntaxTransformationIntRef(_SyntaxTransformationIntRef that);

    /** Process an instance of _SyntaxTransformationIntBinaryOp. */
    public abstract RetType for_SyntaxTransformationIntBinaryOp(_SyntaxTransformationIntBinaryOp that);

    /** Process an instance of _SyntaxTransformationBoolExpr. */
    public abstract RetType for_SyntaxTransformationBoolExpr(_SyntaxTransformationBoolExpr that);

    /** Process an instance of _SyntaxTransformationBoolBase. */
    public abstract RetType for_SyntaxTransformationBoolBase(_SyntaxTransformationBoolBase that);

    /** Process an instance of _SyntaxTransformationBoolRef. */
    public abstract RetType for_SyntaxTransformationBoolRef(_SyntaxTransformationBoolRef that);

    /** Process an instance of _SyntaxTransformationBoolConstraint. */
    public abstract RetType for_SyntaxTransformationBoolConstraint(_SyntaxTransformationBoolConstraint that);

    /** Process an instance of _SyntaxTransformationBoolUnaryOp. */
    public abstract RetType for_SyntaxTransformationBoolUnaryOp(_SyntaxTransformationBoolUnaryOp that);

    /** Process an instance of _SyntaxTransformationBoolBinaryOp. */
    public abstract RetType for_SyntaxTransformationBoolBinaryOp(_SyntaxTransformationBoolBinaryOp that);

    /** Process an instance of _SyntaxTransformationUnitExpr. */
    public abstract RetType for_SyntaxTransformationUnitExpr(_SyntaxTransformationUnitExpr that);

    /** Process an instance of _SyntaxTransformationUnitRef. */
    public abstract RetType for_SyntaxTransformationUnitRef(_SyntaxTransformationUnitRef that);

    /** Process an instance of _SyntaxTransformationUnitBinaryOp. */
    public abstract RetType for_SyntaxTransformationUnitBinaryOp(_SyntaxTransformationUnitBinaryOp that);

    /** Process an instance of _SyntaxTransformationEffect. */
    public abstract RetType for_SyntaxTransformationEffect(_SyntaxTransformationEffect that);

    /** Process an instance of _SyntaxTransformationWhereClause. */
    public abstract RetType for_SyntaxTransformationWhereClause(_SyntaxTransformationWhereClause that);

    /** Process an instance of _SyntaxTransformationWhereBinding. */
    public abstract RetType for_SyntaxTransformationWhereBinding(_SyntaxTransformationWhereBinding that);

    /** Process an instance of _SyntaxTransformationWhereConstraint. */
    public abstract RetType for_SyntaxTransformationWhereConstraint(_SyntaxTransformationWhereConstraint that);

    /** Process an instance of _SyntaxTransformationWhereExtends. */
    public abstract RetType for_SyntaxTransformationWhereExtends(_SyntaxTransformationWhereExtends that);

    /** Process an instance of _SyntaxTransformationWhereTypeAlias. */
    public abstract RetType for_SyntaxTransformationWhereTypeAlias(_SyntaxTransformationWhereTypeAlias that);

    /** Process an instance of _SyntaxTransformationWhereCoerces. */
    public abstract RetType for_SyntaxTransformationWhereCoerces(_SyntaxTransformationWhereCoerces that);

    /** Process an instance of _SyntaxTransformationWhereEquals. */
    public abstract RetType for_SyntaxTransformationWhereEquals(_SyntaxTransformationWhereEquals that);

    /** Process an instance of _SyntaxTransformationUnitConstraint. */
    public abstract RetType for_SyntaxTransformationUnitConstraint(_SyntaxTransformationUnitConstraint that);

    /** Process an instance of _SyntaxTransformationIntConstraint. */
    public abstract RetType for_SyntaxTransformationIntConstraint(_SyntaxTransformationIntConstraint that);

    /** Process an instance of _SyntaxTransformationBoolConstraintExpr. */
    public abstract RetType for_SyntaxTransformationBoolConstraintExpr(_SyntaxTransformationBoolConstraintExpr that);

    /** Process an instance of _SyntaxTransformationContract. */
    public abstract RetType for_SyntaxTransformationContract(_SyntaxTransformationContract that);

    /** Process an instance of _SyntaxTransformationEnsuresClause. */
    public abstract RetType for_SyntaxTransformationEnsuresClause(_SyntaxTransformationEnsuresClause that);

    /** Process an instance of _SyntaxTransformationStaticParam. */
    public abstract RetType for_SyntaxTransformationStaticParam(_SyntaxTransformationStaticParam that);

    /** Process an instance of _SyntaxTransformationName. */
    public abstract RetType for_SyntaxTransformationName(_SyntaxTransformationName that);

    /** Process an instance of _SyntaxTransformationAPIName. */
    public abstract RetType for_SyntaxTransformationAPIName(_SyntaxTransformationAPIName that);

    /** Process an instance of _SyntaxTransformationIdOrOpOrAnonymousName. */
    public abstract RetType for_SyntaxTransformationIdOrOpOrAnonymousName(_SyntaxTransformationIdOrOpOrAnonymousName that);

    /** Process an instance of _SyntaxTransformationIdOrOp. */
    public abstract RetType for_SyntaxTransformationIdOrOp(_SyntaxTransformationIdOrOp that);

    /** Process an instance of _SyntaxTransformationId. */
    public abstract RetType for_SyntaxTransformationId(_SyntaxTransformationId that);

    /** Process an instance of _SyntaxTransformationOp. */
    public abstract RetType for_SyntaxTransformationOp(_SyntaxTransformationOp that);

    /** Process an instance of _SyntaxTransformationNamedOp. */
    public abstract RetType for_SyntaxTransformationNamedOp(_SyntaxTransformationNamedOp that);

    /** Process an instance of _SyntaxTransformation_InferenceVarOp. */
    public abstract RetType for_SyntaxTransformation_InferenceVarOp(_SyntaxTransformation_InferenceVarOp that);

    /** Process an instance of _SyntaxTransformationAnonymousName. */
    public abstract RetType for_SyntaxTransformationAnonymousName(_SyntaxTransformationAnonymousName that);

    /** Process an instance of _SyntaxTransformationAnonymousFnName. */
    public abstract RetType for_SyntaxTransformationAnonymousFnName(_SyntaxTransformationAnonymousFnName that);

    /** Process an instance of _SyntaxTransformationConstructorFnName. */
    public abstract RetType for_SyntaxTransformationConstructorFnName(_SyntaxTransformationConstructorFnName that);

    /** Process an instance of _SyntaxTransformationArrayComprehensionClause. */
    public abstract RetType for_SyntaxTransformationArrayComprehensionClause(_SyntaxTransformationArrayComprehensionClause that);

    /** Process an instance of _SyntaxTransformationKeywordExpr. */
    public abstract RetType for_SyntaxTransformationKeywordExpr(_SyntaxTransformationKeywordExpr that);

    /** Process an instance of _SyntaxTransformationCaseClause. */
    public abstract RetType for_SyntaxTransformationCaseClause(_SyntaxTransformationCaseClause that);

    /** Process an instance of _SyntaxTransformationCatch. */
    public abstract RetType for_SyntaxTransformationCatch(_SyntaxTransformationCatch that);

    /** Process an instance of _SyntaxTransformationCatchClause. */
    public abstract RetType for_SyntaxTransformationCatchClause(_SyntaxTransformationCatchClause that);

    /** Process an instance of _SyntaxTransformationIfClause. */
    public abstract RetType for_SyntaxTransformationIfClause(_SyntaxTransformationIfClause that);

    /** Process an instance of _SyntaxTransformationTypecaseClause. */
    public abstract RetType for_SyntaxTransformationTypecaseClause(_SyntaxTransformationTypecaseClause that);

    /** Process an instance of _SyntaxTransformationExtentRange. */
    public abstract RetType for_SyntaxTransformationExtentRange(_SyntaxTransformationExtentRange that);

    /** Process an instance of _SyntaxTransformationGeneratorClause. */
    public abstract RetType for_SyntaxTransformationGeneratorClause(_SyntaxTransformationGeneratorClause that);

    /** Process an instance of _SyntaxTransformationKeywordType. */
    public abstract RetType for_SyntaxTransformationKeywordType(_SyntaxTransformationKeywordType that);

    /** Process an instance of _SyntaxTransformationTraitTypeWhere. */
    public abstract RetType for_SyntaxTransformationTraitTypeWhere(_SyntaxTransformationTraitTypeWhere that);

    /** Process an instance of _SyntaxTransformationIndices. */
    public abstract RetType for_SyntaxTransformationIndices(_SyntaxTransformationIndices that);

    /** Process an instance of _SyntaxTransformationMathItem. */
    public abstract RetType for_SyntaxTransformationMathItem(_SyntaxTransformationMathItem that);

    /** Process an instance of _SyntaxTransformationExprMI. */
    public abstract RetType for_SyntaxTransformationExprMI(_SyntaxTransformationExprMI that);

    /** Process an instance of _SyntaxTransformationParenthesisDelimitedMI. */
    public abstract RetType for_SyntaxTransformationParenthesisDelimitedMI(_SyntaxTransformationParenthesisDelimitedMI that);

    /** Process an instance of _SyntaxTransformationNonParenthesisDelimitedMI. */
    public abstract RetType for_SyntaxTransformationNonParenthesisDelimitedMI(_SyntaxTransformationNonParenthesisDelimitedMI that);

    /** Process an instance of _SyntaxTransformationNonExprMI. */
    public abstract RetType for_SyntaxTransformationNonExprMI(_SyntaxTransformationNonExprMI that);

    /** Process an instance of _SyntaxTransformationExponentiationMI. */
    public abstract RetType for_SyntaxTransformationExponentiationMI(_SyntaxTransformationExponentiationMI that);

    /** Process an instance of _SyntaxTransformationSubscriptingMI. */
    public abstract RetType for_SyntaxTransformationSubscriptingMI(_SyntaxTransformationSubscriptingMI that);

    /** Process an instance of _SyntaxTransformationOverloading. */
    public abstract RetType for_SyntaxTransformationOverloading(_SyntaxTransformationOverloading that);

    /** Process an instance of _SyntaxTransformationNonterminalHeader. */
    public abstract RetType for_SyntaxTransformationNonterminalHeader(_SyntaxTransformationNonterminalHeader that);

    /** Process an instance of _SyntaxTransformationNonterminalParameter. */
    public abstract RetType for_SyntaxTransformationNonterminalParameter(_SyntaxTransformationNonterminalParameter that);

    /** Process an instance of _SyntaxTransformationSyntaxDecl. */
    public abstract RetType for_SyntaxTransformationSyntaxDecl(_SyntaxTransformationSyntaxDecl that);

    /** Process an instance of _SyntaxTransformationSyntaxDef. */
    public abstract RetType for_SyntaxTransformationSyntaxDef(_SyntaxTransformationSyntaxDef that);

    /** Process an instance of _SyntaxTransformationSuperSyntaxDef. */
    public abstract RetType for_SyntaxTransformationSuperSyntaxDef(_SyntaxTransformationSuperSyntaxDef that);

    /** Process an instance of _SyntaxTransformationTransformerDecl. */
    public abstract RetType for_SyntaxTransformationTransformerDecl(_SyntaxTransformationTransformerDecl that);

    /** Process an instance of _SyntaxTransformationPreTransformerDef. */
    public abstract RetType for_SyntaxTransformationPreTransformerDef(_SyntaxTransformationPreTransformerDef that);

    /** Process an instance of _SyntaxTransformationNamedTransformerDef. */
    public abstract RetType for_SyntaxTransformationNamedTransformerDef(_SyntaxTransformationNamedTransformerDef that);

    /** Process an instance of _SyntaxTransformationTransformer. */
    public abstract RetType for_SyntaxTransformationTransformer(_SyntaxTransformationTransformer that);

    /** Process an instance of _SyntaxTransformationUnparsedTransformer. */
    public abstract RetType for_SyntaxTransformationUnparsedTransformer(_SyntaxTransformationUnparsedTransformer that);

    /** Process an instance of _SyntaxTransformationNodeTransformer. */
    public abstract RetType for_SyntaxTransformationNodeTransformer(_SyntaxTransformationNodeTransformer that);

    /** Process an instance of _SyntaxTransformationCaseTransformer. */
    public abstract RetType for_SyntaxTransformationCaseTransformer(_SyntaxTransformationCaseTransformer that);

    /** Process an instance of _SyntaxTransformationCaseTransformerClause. */
    public abstract RetType for_SyntaxTransformationCaseTransformerClause(_SyntaxTransformationCaseTransformerClause that);

    /** Process an instance of _SyntaxTransformationSyntaxSymbol. */
    public abstract RetType for_SyntaxTransformationSyntaxSymbol(_SyntaxTransformationSyntaxSymbol that);

    /** Process an instance of _SyntaxTransformationPrefixedSymbol. */
    public abstract RetType for_SyntaxTransformationPrefixedSymbol(_SyntaxTransformationPrefixedSymbol that);

    /** Process an instance of _SyntaxTransformationOptionalSymbol. */
    public abstract RetType for_SyntaxTransformationOptionalSymbol(_SyntaxTransformationOptionalSymbol that);

    /** Process an instance of _SyntaxTransformationRepeatSymbol. */
    public abstract RetType for_SyntaxTransformationRepeatSymbol(_SyntaxTransformationRepeatSymbol that);

    /** Process an instance of _SyntaxTransformationRepeatOneOrMoreSymbol. */
    public abstract RetType for_SyntaxTransformationRepeatOneOrMoreSymbol(_SyntaxTransformationRepeatOneOrMoreSymbol that);

    /** Process an instance of _SyntaxTransformationNoWhitespaceSymbol. */
    public abstract RetType for_SyntaxTransformationNoWhitespaceSymbol(_SyntaxTransformationNoWhitespaceSymbol that);

    /** Process an instance of _SyntaxTransformationGroupSymbol. */
    public abstract RetType for_SyntaxTransformationGroupSymbol(_SyntaxTransformationGroupSymbol that);

    /** Process an instance of _SyntaxTransformationSpecialSymbol. */
    public abstract RetType for_SyntaxTransformationSpecialSymbol(_SyntaxTransformationSpecialSymbol that);

    /** Process an instance of _SyntaxTransformationAnyCharacterSymbol. */
    public abstract RetType for_SyntaxTransformationAnyCharacterSymbol(_SyntaxTransformationAnyCharacterSymbol that);

    /** Process an instance of _SyntaxTransformationWhitespaceSymbol. */
    public abstract RetType for_SyntaxTransformationWhitespaceSymbol(_SyntaxTransformationWhitespaceSymbol that);

    /** Process an instance of _SyntaxTransformationTabSymbol. */
    public abstract RetType for_SyntaxTransformationTabSymbol(_SyntaxTransformationTabSymbol that);

    /** Process an instance of _SyntaxTransformationFormfeedSymbol. */
    public abstract RetType for_SyntaxTransformationFormfeedSymbol(_SyntaxTransformationFormfeedSymbol that);

    /** Process an instance of _SyntaxTransformationCarriageReturnSymbol. */
    public abstract RetType for_SyntaxTransformationCarriageReturnSymbol(_SyntaxTransformationCarriageReturnSymbol that);

    /** Process an instance of _SyntaxTransformationBackspaceSymbol. */
    public abstract RetType for_SyntaxTransformationBackspaceSymbol(_SyntaxTransformationBackspaceSymbol that);

    /** Process an instance of _SyntaxTransformationNewlineSymbol. */
    public abstract RetType for_SyntaxTransformationNewlineSymbol(_SyntaxTransformationNewlineSymbol that);

    /** Process an instance of _SyntaxTransformationBreaklineSymbol. */
    public abstract RetType for_SyntaxTransformationBreaklineSymbol(_SyntaxTransformationBreaklineSymbol that);

    /** Process an instance of _SyntaxTransformationItemSymbol. */
    public abstract RetType for_SyntaxTransformationItemSymbol(_SyntaxTransformationItemSymbol that);

    /** Process an instance of _SyntaxTransformationNonterminalSymbol. */
    public abstract RetType for_SyntaxTransformationNonterminalSymbol(_SyntaxTransformationNonterminalSymbol that);

    /** Process an instance of _SyntaxTransformationKeywordSymbol. */
    public abstract RetType for_SyntaxTransformationKeywordSymbol(_SyntaxTransformationKeywordSymbol that);

    /** Process an instance of _SyntaxTransformationTokenSymbol. */
    public abstract RetType for_SyntaxTransformationTokenSymbol(_SyntaxTransformationTokenSymbol that);

    /** Process an instance of _SyntaxTransformationNotPredicateSymbol. */
    public abstract RetType for_SyntaxTransformationNotPredicateSymbol(_SyntaxTransformationNotPredicateSymbol that);

    /** Process an instance of _SyntaxTransformationAndPredicateSymbol. */
    public abstract RetType for_SyntaxTransformationAndPredicateSymbol(_SyntaxTransformationAndPredicateSymbol that);

    /** Process an instance of _SyntaxTransformationCharacterClassSymbol. */
    public abstract RetType for_SyntaxTransformationCharacterClassSymbol(_SyntaxTransformationCharacterClassSymbol that);

    /** Process an instance of _SyntaxTransformationCharacterSymbol. */
    public abstract RetType for_SyntaxTransformationCharacterSymbol(_SyntaxTransformationCharacterSymbol that);

    /** Process an instance of _SyntaxTransformationCharSymbol. */
    public abstract RetType for_SyntaxTransformationCharSymbol(_SyntaxTransformationCharSymbol that);

    /** Process an instance of _SyntaxTransformationCharacterInterval. */
    public abstract RetType for_SyntaxTransformationCharacterInterval(_SyntaxTransformationCharacterInterval that);

    /** Process an instance of _SyntaxTransformationLink. */
    public abstract RetType for_SyntaxTransformationLink(_SyntaxTransformationLink that);

    /** Process an instance of _EllipsesAbstractNode. */
    public abstract RetType for_EllipsesAbstractNode(_EllipsesAbstractNode that);

    /** Process an instance of _EllipsesCompilationUnit. */
    public abstract RetType for_EllipsesCompilationUnit(_EllipsesCompilationUnit that);

    /** Process an instance of _EllipsesComponent. */
    public abstract RetType for_EllipsesComponent(_EllipsesComponent that);

    /** Process an instance of _EllipsesApi. */
    public abstract RetType for_EllipsesApi(_EllipsesApi that);

    /** Process an instance of _EllipsesImport. */
    public abstract RetType for_EllipsesImport(_EllipsesImport that);

    /** Process an instance of _EllipsesImportedNames. */
    public abstract RetType for_EllipsesImportedNames(_EllipsesImportedNames that);

    /** Process an instance of _EllipsesImportStar. */
    public abstract RetType for_EllipsesImportStar(_EllipsesImportStar that);

    /** Process an instance of _EllipsesImportNames. */
    public abstract RetType for_EllipsesImportNames(_EllipsesImportNames that);

    /** Process an instance of _EllipsesImportApi. */
    public abstract RetType for_EllipsesImportApi(_EllipsesImportApi that);

    /** Process an instance of _EllipsesAliasedSimpleName. */
    public abstract RetType for_EllipsesAliasedSimpleName(_EllipsesAliasedSimpleName that);

    /** Process an instance of _EllipsesAliasedAPIName. */
    public abstract RetType for_EllipsesAliasedAPIName(_EllipsesAliasedAPIName that);

    /** Process an instance of _EllipsesDecl. */
    public abstract RetType for_EllipsesDecl(_EllipsesDecl that);

    /** Process an instance of _EllipsesTraitObjectDecl. */
    public abstract RetType for_EllipsesTraitObjectDecl(_EllipsesTraitObjectDecl that);

    /** Process an instance of _EllipsesTraitDecl. */
    public abstract RetType for_EllipsesTraitDecl(_EllipsesTraitDecl that);

    /** Process an instance of _EllipsesObjectDecl. */
    public abstract RetType for_EllipsesObjectDecl(_EllipsesObjectDecl that);

    /** Process an instance of _EllipsesVarDecl. */
    public abstract RetType for_EllipsesVarDecl(_EllipsesVarDecl that);

    /** Process an instance of _EllipsesFnDecl. */
    public abstract RetType for_EllipsesFnDecl(_EllipsesFnDecl that);

    /** Process an instance of _Ellipses_RewriteFnOverloadDecl. */
    public abstract RetType for_Ellipses_RewriteFnOverloadDecl(_Ellipses_RewriteFnOverloadDecl that);

    /** Process an instance of _Ellipses_RewriteObjectExprDecl. */
    public abstract RetType for_Ellipses_RewriteObjectExprDecl(_Ellipses_RewriteObjectExprDecl that);

    /** Process an instance of _Ellipses_RewriteFunctionalMethodDecl. */
    public abstract RetType for_Ellipses_RewriteFunctionalMethodDecl(_Ellipses_RewriteFunctionalMethodDecl that);

    /** Process an instance of _EllipsesDimUnitDecl. */
    public abstract RetType for_EllipsesDimUnitDecl(_EllipsesDimUnitDecl that);

    /** Process an instance of _EllipsesDimDecl. */
    public abstract RetType for_EllipsesDimDecl(_EllipsesDimDecl that);

    /** Process an instance of _EllipsesUnitDecl. */
    public abstract RetType for_EllipsesUnitDecl(_EllipsesUnitDecl that);

    /** Process an instance of _EllipsesTestDecl. */
    public abstract RetType for_EllipsesTestDecl(_EllipsesTestDecl that);

    /** Process an instance of _EllipsesPropertyDecl. */
    public abstract RetType for_EllipsesPropertyDecl(_EllipsesPropertyDecl that);

    /** Process an instance of _EllipsesTypeAlias. */
    public abstract RetType for_EllipsesTypeAlias(_EllipsesTypeAlias that);

    /** Process an instance of _EllipsesGrammarDecl. */
    public abstract RetType for_EllipsesGrammarDecl(_EllipsesGrammarDecl that);

    /** Process an instance of _EllipsesGrammarMemberDecl. */
    public abstract RetType for_EllipsesGrammarMemberDecl(_EllipsesGrammarMemberDecl that);

    /** Process an instance of _EllipsesNonterminalDecl. */
    public abstract RetType for_EllipsesNonterminalDecl(_EllipsesNonterminalDecl that);

    /** Process an instance of _EllipsesNonterminalDef. */
    public abstract RetType for_EllipsesNonterminalDef(_EllipsesNonterminalDef that);

    /** Process an instance of _EllipsesNonterminalExtensionDef. */
    public abstract RetType for_EllipsesNonterminalExtensionDef(_EllipsesNonterminalExtensionDef that);

    /** Process an instance of _EllipsesBinding. */
    public abstract RetType for_EllipsesBinding(_EllipsesBinding that);

    /** Process an instance of _EllipsesLValue. */
    public abstract RetType for_EllipsesLValue(_EllipsesLValue that);

    /** Process an instance of _EllipsesParam. */
    public abstract RetType for_EllipsesParam(_EllipsesParam that);

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

    /** Process an instance of _EllipsesType. */
    public abstract RetType for_EllipsesType(_EllipsesType that);

    /** Process an instance of _EllipsesBaseType. */
    public abstract RetType for_EllipsesBaseType(_EllipsesBaseType that);

    /** Process an instance of _EllipsesAnyType. */
    public abstract RetType for_EllipsesAnyType(_EllipsesAnyType that);

    /** Process an instance of _EllipsesBottomType. */
    public abstract RetType for_EllipsesBottomType(_EllipsesBottomType that);

    /** Process an instance of _EllipsesUnknownType. */
    public abstract RetType for_EllipsesUnknownType(_EllipsesUnknownType that);

    /** Process an instance of _EllipsesSelfType. */
    public abstract RetType for_EllipsesSelfType(_EllipsesSelfType that);

    /** Process an instance of _EllipsesTraitSelfType. */
    public abstract RetType for_EllipsesTraitSelfType(_EllipsesTraitSelfType that);

    /** Process an instance of _EllipsesObjectExprType. */
    public abstract RetType for_EllipsesObjectExprType(_EllipsesObjectExprType that);

    /** Process an instance of _EllipsesNamedType. */
    public abstract RetType for_EllipsesNamedType(_EllipsesNamedType that);

    /** Process an instance of _Ellipses_InferenceVarType. */
    public abstract RetType for_Ellipses_InferenceVarType(_Ellipses_InferenceVarType that);

    /** Process an instance of _EllipsesVarType. */
    public abstract RetType for_EllipsesVarType(_EllipsesVarType that);

    /** Process an instance of _EllipsesTraitType. */
    public abstract RetType for_EllipsesTraitType(_EllipsesTraitType that);

    /** Process an instance of _EllipsesAbbreviatedType. */
    public abstract RetType for_EllipsesAbbreviatedType(_EllipsesAbbreviatedType that);

    /** Process an instance of _EllipsesArrayType. */
    public abstract RetType for_EllipsesArrayType(_EllipsesArrayType that);

    /** Process an instance of _EllipsesMatrixType. */
    public abstract RetType for_EllipsesMatrixType(_EllipsesMatrixType that);

    /** Process an instance of _EllipsesTaggedDimType. */
    public abstract RetType for_EllipsesTaggedDimType(_EllipsesTaggedDimType that);

    /** Process an instance of _EllipsesTaggedUnitType. */
    public abstract RetType for_EllipsesTaggedUnitType(_EllipsesTaggedUnitType that);

    /** Process an instance of _EllipsesTupleType. */
    public abstract RetType for_EllipsesTupleType(_EllipsesTupleType that);

    /** Process an instance of _EllipsesArrowType. */
    public abstract RetType for_EllipsesArrowType(_EllipsesArrowType that);

    /** Process an instance of _EllipsesBoundType. */
    public abstract RetType for_EllipsesBoundType(_EllipsesBoundType that);

    /** Process an instance of _EllipsesIntersectionType. */
    public abstract RetType for_EllipsesIntersectionType(_EllipsesIntersectionType that);

    /** Process an instance of _EllipsesUnionType. */
    public abstract RetType for_EllipsesUnionType(_EllipsesUnionType that);

    /** Process an instance of _EllipsesFixedPointType. */
    public abstract RetType for_EllipsesFixedPointType(_EllipsesFixedPointType that);

    /** Process an instance of _EllipsesLabelType. */
    public abstract RetType for_EllipsesLabelType(_EllipsesLabelType that);

    /** Process an instance of _EllipsesDimExpr. */
    public abstract RetType for_EllipsesDimExpr(_EllipsesDimExpr that);

    /** Process an instance of _EllipsesDimBase. */
    public abstract RetType for_EllipsesDimBase(_EllipsesDimBase that);

    /** Process an instance of _EllipsesDimRef. */
    public abstract RetType for_EllipsesDimRef(_EllipsesDimRef that);

    /** Process an instance of _EllipsesDimExponent. */
    public abstract RetType for_EllipsesDimExponent(_EllipsesDimExponent that);

    /** Process an instance of _EllipsesDimUnaryOp. */
    public abstract RetType for_EllipsesDimUnaryOp(_EllipsesDimUnaryOp that);

    /** Process an instance of _EllipsesDimBinaryOp. */
    public abstract RetType for_EllipsesDimBinaryOp(_EllipsesDimBinaryOp that);

    /** Process an instance of _EllipsesPattern. */
    public abstract RetType for_EllipsesPattern(_EllipsesPattern that);

    /** Process an instance of _EllipsesPatternArgs. */
    public abstract RetType for_EllipsesPatternArgs(_EllipsesPatternArgs that);

    /** Process an instance of _EllipsesPatternBinding. */
    public abstract RetType for_EllipsesPatternBinding(_EllipsesPatternBinding that);

    /** Process an instance of _EllipsesPlainPattern. */
    public abstract RetType for_EllipsesPlainPattern(_EllipsesPlainPattern that);

    /** Process an instance of _EllipsesTypePattern. */
    public abstract RetType for_EllipsesTypePattern(_EllipsesTypePattern that);

    /** Process an instance of _EllipsesNestedPattern. */
    public abstract RetType for_EllipsesNestedPattern(_EllipsesNestedPattern that);

    /** Process an instance of _EllipsesStaticArg. */
    public abstract RetType for_EllipsesStaticArg(_EllipsesStaticArg that);

    /** Process an instance of _EllipsesTypeArg. */
    public abstract RetType for_EllipsesTypeArg(_EllipsesTypeArg that);

    /** Process an instance of _EllipsesIntArg. */
    public abstract RetType for_EllipsesIntArg(_EllipsesIntArg that);

    /** Process an instance of _EllipsesBoolArg. */
    public abstract RetType for_EllipsesBoolArg(_EllipsesBoolArg that);

    /** Process an instance of _EllipsesOpArg. */
    public abstract RetType for_EllipsesOpArg(_EllipsesOpArg that);

    /** Process an instance of _EllipsesDimArg. */
    public abstract RetType for_EllipsesDimArg(_EllipsesDimArg that);

    /** Process an instance of _EllipsesUnitArg. */
    public abstract RetType for_EllipsesUnitArg(_EllipsesUnitArg that);

    /** Process an instance of _EllipsesStaticExpr. */
    public abstract RetType for_EllipsesStaticExpr(_EllipsesStaticExpr that);

    /** Process an instance of _EllipsesIntExpr. */
    public abstract RetType for_EllipsesIntExpr(_EllipsesIntExpr that);

    /** Process an instance of _EllipsesIntBase. */
    public abstract RetType for_EllipsesIntBase(_EllipsesIntBase that);

    /** Process an instance of _EllipsesIntRef. */
    public abstract RetType for_EllipsesIntRef(_EllipsesIntRef that);

    /** Process an instance of _EllipsesIntBinaryOp. */
    public abstract RetType for_EllipsesIntBinaryOp(_EllipsesIntBinaryOp that);

    /** Process an instance of _EllipsesBoolExpr. */
    public abstract RetType for_EllipsesBoolExpr(_EllipsesBoolExpr that);

    /** Process an instance of _EllipsesBoolBase. */
    public abstract RetType for_EllipsesBoolBase(_EllipsesBoolBase that);

    /** Process an instance of _EllipsesBoolRef. */
    public abstract RetType for_EllipsesBoolRef(_EllipsesBoolRef that);

    /** Process an instance of _EllipsesBoolConstraint. */
    public abstract RetType for_EllipsesBoolConstraint(_EllipsesBoolConstraint that);

    /** Process an instance of _EllipsesBoolUnaryOp. */
    public abstract RetType for_EllipsesBoolUnaryOp(_EllipsesBoolUnaryOp that);

    /** Process an instance of _EllipsesBoolBinaryOp. */
    public abstract RetType for_EllipsesBoolBinaryOp(_EllipsesBoolBinaryOp that);

    /** Process an instance of _EllipsesUnitExpr. */
    public abstract RetType for_EllipsesUnitExpr(_EllipsesUnitExpr that);

    /** Process an instance of _EllipsesUnitRef. */
    public abstract RetType for_EllipsesUnitRef(_EllipsesUnitRef that);

    /** Process an instance of _EllipsesUnitBinaryOp. */
    public abstract RetType for_EllipsesUnitBinaryOp(_EllipsesUnitBinaryOp that);

    /** Process an instance of _EllipsesEffect. */
    public abstract RetType for_EllipsesEffect(_EllipsesEffect that);

    /** Process an instance of _EllipsesWhereClause. */
    public abstract RetType for_EllipsesWhereClause(_EllipsesWhereClause that);

    /** Process an instance of _EllipsesWhereBinding. */
    public abstract RetType for_EllipsesWhereBinding(_EllipsesWhereBinding that);

    /** Process an instance of _EllipsesWhereConstraint. */
    public abstract RetType for_EllipsesWhereConstraint(_EllipsesWhereConstraint that);

    /** Process an instance of _EllipsesWhereExtends. */
    public abstract RetType for_EllipsesWhereExtends(_EllipsesWhereExtends that);

    /** Process an instance of _EllipsesWhereTypeAlias. */
    public abstract RetType for_EllipsesWhereTypeAlias(_EllipsesWhereTypeAlias that);

    /** Process an instance of _EllipsesWhereCoerces. */
    public abstract RetType for_EllipsesWhereCoerces(_EllipsesWhereCoerces that);

    /** Process an instance of _EllipsesWhereEquals. */
    public abstract RetType for_EllipsesWhereEquals(_EllipsesWhereEquals that);

    /** Process an instance of _EllipsesUnitConstraint. */
    public abstract RetType for_EllipsesUnitConstraint(_EllipsesUnitConstraint that);

    /** Process an instance of _EllipsesIntConstraint. */
    public abstract RetType for_EllipsesIntConstraint(_EllipsesIntConstraint that);

    /** Process an instance of _EllipsesBoolConstraintExpr. */
    public abstract RetType for_EllipsesBoolConstraintExpr(_EllipsesBoolConstraintExpr that);

    /** Process an instance of _EllipsesContract. */
    public abstract RetType for_EllipsesContract(_EllipsesContract that);

    /** Process an instance of _EllipsesEnsuresClause. */
    public abstract RetType for_EllipsesEnsuresClause(_EllipsesEnsuresClause that);

    /** Process an instance of _EllipsesStaticParam. */
    public abstract RetType for_EllipsesStaticParam(_EllipsesStaticParam that);

    /** Process an instance of _EllipsesName. */
    public abstract RetType for_EllipsesName(_EllipsesName that);

    /** Process an instance of _EllipsesAPIName. */
    public abstract RetType for_EllipsesAPIName(_EllipsesAPIName that);

    /** Process an instance of _EllipsesIdOrOpOrAnonymousName. */
    public abstract RetType for_EllipsesIdOrOpOrAnonymousName(_EllipsesIdOrOpOrAnonymousName that);

    /** Process an instance of _EllipsesIdOrOp. */
    public abstract RetType for_EllipsesIdOrOp(_EllipsesIdOrOp that);

    /** Process an instance of _EllipsesId. */
    public abstract RetType for_EllipsesId(_EllipsesId that);

    /** Process an instance of _EllipsesOp. */
    public abstract RetType for_EllipsesOp(_EllipsesOp that);

    /** Process an instance of _EllipsesNamedOp. */
    public abstract RetType for_EllipsesNamedOp(_EllipsesNamedOp that);

    /** Process an instance of _Ellipses_InferenceVarOp. */
    public abstract RetType for_Ellipses_InferenceVarOp(_Ellipses_InferenceVarOp that);

    /** Process an instance of _EllipsesAnonymousName. */
    public abstract RetType for_EllipsesAnonymousName(_EllipsesAnonymousName that);

    /** Process an instance of _EllipsesAnonymousFnName. */
    public abstract RetType for_EllipsesAnonymousFnName(_EllipsesAnonymousFnName that);

    /** Process an instance of _EllipsesConstructorFnName. */
    public abstract RetType for_EllipsesConstructorFnName(_EllipsesConstructorFnName that);

    /** Process an instance of _EllipsesArrayComprehensionClause. */
    public abstract RetType for_EllipsesArrayComprehensionClause(_EllipsesArrayComprehensionClause that);

    /** Process an instance of _EllipsesKeywordExpr. */
    public abstract RetType for_EllipsesKeywordExpr(_EllipsesKeywordExpr that);

    /** Process an instance of _EllipsesCaseClause. */
    public abstract RetType for_EllipsesCaseClause(_EllipsesCaseClause that);

    /** Process an instance of _EllipsesCatch. */
    public abstract RetType for_EllipsesCatch(_EllipsesCatch that);

    /** Process an instance of _EllipsesCatchClause. */
    public abstract RetType for_EllipsesCatchClause(_EllipsesCatchClause that);

    /** Process an instance of _EllipsesIfClause. */
    public abstract RetType for_EllipsesIfClause(_EllipsesIfClause that);

    /** Process an instance of _EllipsesTypecaseClause. */
    public abstract RetType for_EllipsesTypecaseClause(_EllipsesTypecaseClause that);

    /** Process an instance of _EllipsesExtentRange. */
    public abstract RetType for_EllipsesExtentRange(_EllipsesExtentRange that);

    /** Process an instance of _EllipsesGeneratorClause. */
    public abstract RetType for_EllipsesGeneratorClause(_EllipsesGeneratorClause that);

    /** Process an instance of _EllipsesKeywordType. */
    public abstract RetType for_EllipsesKeywordType(_EllipsesKeywordType that);

    /** Process an instance of _EllipsesTraitTypeWhere. */
    public abstract RetType for_EllipsesTraitTypeWhere(_EllipsesTraitTypeWhere that);

    /** Process an instance of _EllipsesIndices. */
    public abstract RetType for_EllipsesIndices(_EllipsesIndices that);

    /** Process an instance of _EllipsesMathItem. */
    public abstract RetType for_EllipsesMathItem(_EllipsesMathItem that);

    /** Process an instance of _EllipsesExprMI. */
    public abstract RetType for_EllipsesExprMI(_EllipsesExprMI that);

    /** Process an instance of _EllipsesParenthesisDelimitedMI. */
    public abstract RetType for_EllipsesParenthesisDelimitedMI(_EllipsesParenthesisDelimitedMI that);

    /** Process an instance of _EllipsesNonParenthesisDelimitedMI. */
    public abstract RetType for_EllipsesNonParenthesisDelimitedMI(_EllipsesNonParenthesisDelimitedMI that);

    /** Process an instance of _EllipsesNonExprMI. */
    public abstract RetType for_EllipsesNonExprMI(_EllipsesNonExprMI that);

    /** Process an instance of _EllipsesExponentiationMI. */
    public abstract RetType for_EllipsesExponentiationMI(_EllipsesExponentiationMI that);

    /** Process an instance of _EllipsesSubscriptingMI. */
    public abstract RetType for_EllipsesSubscriptingMI(_EllipsesSubscriptingMI that);

    /** Process an instance of _EllipsesOverloading. */
    public abstract RetType for_EllipsesOverloading(_EllipsesOverloading that);

    /** Process an instance of _EllipsesNonterminalHeader. */
    public abstract RetType for_EllipsesNonterminalHeader(_EllipsesNonterminalHeader that);

    /** Process an instance of _EllipsesNonterminalParameter. */
    public abstract RetType for_EllipsesNonterminalParameter(_EllipsesNonterminalParameter that);

    /** Process an instance of _EllipsesSyntaxDecl. */
    public abstract RetType for_EllipsesSyntaxDecl(_EllipsesSyntaxDecl that);

    /** Process an instance of _EllipsesSyntaxDef. */
    public abstract RetType for_EllipsesSyntaxDef(_EllipsesSyntaxDef that);

    /** Process an instance of _EllipsesSuperSyntaxDef. */
    public abstract RetType for_EllipsesSuperSyntaxDef(_EllipsesSuperSyntaxDef that);

    /** Process an instance of _EllipsesTransformerDecl. */
    public abstract RetType for_EllipsesTransformerDecl(_EllipsesTransformerDecl that);

    /** Process an instance of _EllipsesPreTransformerDef. */
    public abstract RetType for_EllipsesPreTransformerDef(_EllipsesPreTransformerDef that);

    /** Process an instance of _EllipsesNamedTransformerDef. */
    public abstract RetType for_EllipsesNamedTransformerDef(_EllipsesNamedTransformerDef that);

    /** Process an instance of _EllipsesTransformer. */
    public abstract RetType for_EllipsesTransformer(_EllipsesTransformer that);

    /** Process an instance of _EllipsesUnparsedTransformer. */
    public abstract RetType for_EllipsesUnparsedTransformer(_EllipsesUnparsedTransformer that);

    /** Process an instance of _EllipsesNodeTransformer. */
    public abstract RetType for_EllipsesNodeTransformer(_EllipsesNodeTransformer that);

    /** Process an instance of _EllipsesCaseTransformer. */
    public abstract RetType for_EllipsesCaseTransformer(_EllipsesCaseTransformer that);

    /** Process an instance of _EllipsesCaseTransformerClause. */
    public abstract RetType for_EllipsesCaseTransformerClause(_EllipsesCaseTransformerClause that);

    /** Process an instance of _EllipsesSyntaxSymbol. */
    public abstract RetType for_EllipsesSyntaxSymbol(_EllipsesSyntaxSymbol that);

    /** Process an instance of _EllipsesPrefixedSymbol. */
    public abstract RetType for_EllipsesPrefixedSymbol(_EllipsesPrefixedSymbol that);

    /** Process an instance of _EllipsesOptionalSymbol. */
    public abstract RetType for_EllipsesOptionalSymbol(_EllipsesOptionalSymbol that);

    /** Process an instance of _EllipsesRepeatSymbol. */
    public abstract RetType for_EllipsesRepeatSymbol(_EllipsesRepeatSymbol that);

    /** Process an instance of _EllipsesRepeatOneOrMoreSymbol. */
    public abstract RetType for_EllipsesRepeatOneOrMoreSymbol(_EllipsesRepeatOneOrMoreSymbol that);

    /** Process an instance of _EllipsesNoWhitespaceSymbol. */
    public abstract RetType for_EllipsesNoWhitespaceSymbol(_EllipsesNoWhitespaceSymbol that);

    /** Process an instance of _EllipsesGroupSymbol. */
    public abstract RetType for_EllipsesGroupSymbol(_EllipsesGroupSymbol that);

    /** Process an instance of _EllipsesSpecialSymbol. */
    public abstract RetType for_EllipsesSpecialSymbol(_EllipsesSpecialSymbol that);

    /** Process an instance of _EllipsesAnyCharacterSymbol. */
    public abstract RetType for_EllipsesAnyCharacterSymbol(_EllipsesAnyCharacterSymbol that);

    /** Process an instance of _EllipsesWhitespaceSymbol. */
    public abstract RetType for_EllipsesWhitespaceSymbol(_EllipsesWhitespaceSymbol that);

    /** Process an instance of _EllipsesTabSymbol. */
    public abstract RetType for_EllipsesTabSymbol(_EllipsesTabSymbol that);

    /** Process an instance of _EllipsesFormfeedSymbol. */
    public abstract RetType for_EllipsesFormfeedSymbol(_EllipsesFormfeedSymbol that);

    /** Process an instance of _EllipsesCarriageReturnSymbol. */
    public abstract RetType for_EllipsesCarriageReturnSymbol(_EllipsesCarriageReturnSymbol that);

    /** Process an instance of _EllipsesBackspaceSymbol. */
    public abstract RetType for_EllipsesBackspaceSymbol(_EllipsesBackspaceSymbol that);

    /** Process an instance of _EllipsesNewlineSymbol. */
    public abstract RetType for_EllipsesNewlineSymbol(_EllipsesNewlineSymbol that);

    /** Process an instance of _EllipsesBreaklineSymbol. */
    public abstract RetType for_EllipsesBreaklineSymbol(_EllipsesBreaklineSymbol that);

    /** Process an instance of _EllipsesItemSymbol. */
    public abstract RetType for_EllipsesItemSymbol(_EllipsesItemSymbol that);

    /** Process an instance of _EllipsesNonterminalSymbol. */
    public abstract RetType for_EllipsesNonterminalSymbol(_EllipsesNonterminalSymbol that);

    /** Process an instance of _EllipsesKeywordSymbol. */
    public abstract RetType for_EllipsesKeywordSymbol(_EllipsesKeywordSymbol that);

    /** Process an instance of _EllipsesTokenSymbol. */
    public abstract RetType for_EllipsesTokenSymbol(_EllipsesTokenSymbol that);

    /** Process an instance of _EllipsesNotPredicateSymbol. */
    public abstract RetType for_EllipsesNotPredicateSymbol(_EllipsesNotPredicateSymbol that);

    /** Process an instance of _EllipsesAndPredicateSymbol. */
    public abstract RetType for_EllipsesAndPredicateSymbol(_EllipsesAndPredicateSymbol that);

    /** Process an instance of _EllipsesCharacterClassSymbol. */
    public abstract RetType for_EllipsesCharacterClassSymbol(_EllipsesCharacterClassSymbol that);

    /** Process an instance of _EllipsesCharacterSymbol. */
    public abstract RetType for_EllipsesCharacterSymbol(_EllipsesCharacterSymbol that);

    /** Process an instance of _EllipsesCharSymbol. */
    public abstract RetType for_EllipsesCharSymbol(_EllipsesCharSymbol that);

    /** Process an instance of _EllipsesCharacterInterval. */
    public abstract RetType for_EllipsesCharacterInterval(_EllipsesCharacterInterval that);

    /** Process an instance of _EllipsesLink. */
    public abstract RetType for_EllipsesLink(_EllipsesLink that);

    /** Process an instance of TemplateGapAbstractNode. */
    public abstract RetType forTemplateGapAbstractNode(TemplateGapAbstractNode that);

    /** Process an instance of TemplateGapCompilationUnit. */
    public abstract RetType forTemplateGapCompilationUnit(TemplateGapCompilationUnit that);

    /** Process an instance of TemplateGapComponent. */
    public abstract RetType forTemplateGapComponent(TemplateGapComponent that);

    /** Process an instance of TemplateGapApi. */
    public abstract RetType forTemplateGapApi(TemplateGapApi that);

    /** Process an instance of TemplateGapImport. */
    public abstract RetType forTemplateGapImport(TemplateGapImport that);

    /** Process an instance of TemplateGapImportedNames. */
    public abstract RetType forTemplateGapImportedNames(TemplateGapImportedNames that);

    /** Process an instance of TemplateGapImportStar. */
    public abstract RetType forTemplateGapImportStar(TemplateGapImportStar that);

    /** Process an instance of TemplateGapImportNames. */
    public abstract RetType forTemplateGapImportNames(TemplateGapImportNames that);

    /** Process an instance of TemplateGapImportApi. */
    public abstract RetType forTemplateGapImportApi(TemplateGapImportApi that);

    /** Process an instance of TemplateGapAliasedSimpleName. */
    public abstract RetType forTemplateGapAliasedSimpleName(TemplateGapAliasedSimpleName that);

    /** Process an instance of TemplateGapAliasedAPIName. */
    public abstract RetType forTemplateGapAliasedAPIName(TemplateGapAliasedAPIName that);

    /** Process an instance of TemplateGapDecl. */
    public abstract RetType forTemplateGapDecl(TemplateGapDecl that);

    /** Process an instance of TemplateGapTraitObjectDecl. */
    public abstract RetType forTemplateGapTraitObjectDecl(TemplateGapTraitObjectDecl that);

    /** Process an instance of TemplateGapTraitDecl. */
    public abstract RetType forTemplateGapTraitDecl(TemplateGapTraitDecl that);

    /** Process an instance of TemplateGapObjectDecl. */
    public abstract RetType forTemplateGapObjectDecl(TemplateGapObjectDecl that);

    /** Process an instance of TemplateGapVarDecl. */
    public abstract RetType forTemplateGapVarDecl(TemplateGapVarDecl that);

    /** Process an instance of TemplateGapFnDecl. */
    public abstract RetType forTemplateGapFnDecl(TemplateGapFnDecl that);

    /** Process an instance of TemplateGap_RewriteFnOverloadDecl. */
    public abstract RetType forTemplateGap_RewriteFnOverloadDecl(TemplateGap_RewriteFnOverloadDecl that);

    /** Process an instance of TemplateGap_RewriteObjectExprDecl. */
    public abstract RetType forTemplateGap_RewriteObjectExprDecl(TemplateGap_RewriteObjectExprDecl that);

    /** Process an instance of TemplateGap_RewriteFunctionalMethodDecl. */
    public abstract RetType forTemplateGap_RewriteFunctionalMethodDecl(TemplateGap_RewriteFunctionalMethodDecl that);

    /** Process an instance of TemplateGapDimUnitDecl. */
    public abstract RetType forTemplateGapDimUnitDecl(TemplateGapDimUnitDecl that);

    /** Process an instance of TemplateGapDimDecl. */
    public abstract RetType forTemplateGapDimDecl(TemplateGapDimDecl that);

    /** Process an instance of TemplateGapUnitDecl. */
    public abstract RetType forTemplateGapUnitDecl(TemplateGapUnitDecl that);

    /** Process an instance of TemplateGapTestDecl. */
    public abstract RetType forTemplateGapTestDecl(TemplateGapTestDecl that);

    /** Process an instance of TemplateGapPropertyDecl. */
    public abstract RetType forTemplateGapPropertyDecl(TemplateGapPropertyDecl that);

    /** Process an instance of TemplateGapTypeAlias. */
    public abstract RetType forTemplateGapTypeAlias(TemplateGapTypeAlias that);

    /** Process an instance of TemplateGapGrammarDecl. */
    public abstract RetType forTemplateGapGrammarDecl(TemplateGapGrammarDecl that);

    /** Process an instance of TemplateGapGrammarMemberDecl. */
    public abstract RetType forTemplateGapGrammarMemberDecl(TemplateGapGrammarMemberDecl that);

    /** Process an instance of TemplateGapNonterminalDecl. */
    public abstract RetType forTemplateGapNonterminalDecl(TemplateGapNonterminalDecl that);

    /** Process an instance of TemplateGapNonterminalDef. */
    public abstract RetType forTemplateGapNonterminalDef(TemplateGapNonterminalDef that);

    /** Process an instance of TemplateGapNonterminalExtensionDef. */
    public abstract RetType forTemplateGapNonterminalExtensionDef(TemplateGapNonterminalExtensionDef that);

    /** Process an instance of TemplateGapBinding. */
    public abstract RetType forTemplateGapBinding(TemplateGapBinding that);

    /** Process an instance of TemplateGapLValue. */
    public abstract RetType forTemplateGapLValue(TemplateGapLValue that);

    /** Process an instance of TemplateGapParam. */
    public abstract RetType forTemplateGapParam(TemplateGapParam that);

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

    /** Process an instance of TemplateGapType. */
    public abstract RetType forTemplateGapType(TemplateGapType that);

    /** Process an instance of TemplateGapBaseType. */
    public abstract RetType forTemplateGapBaseType(TemplateGapBaseType that);

    /** Process an instance of TemplateGapAnyType. */
    public abstract RetType forTemplateGapAnyType(TemplateGapAnyType that);

    /** Process an instance of TemplateGapBottomType. */
    public abstract RetType forTemplateGapBottomType(TemplateGapBottomType that);

    /** Process an instance of TemplateGapUnknownType. */
    public abstract RetType forTemplateGapUnknownType(TemplateGapUnknownType that);

    /** Process an instance of TemplateGapSelfType. */
    public abstract RetType forTemplateGapSelfType(TemplateGapSelfType that);

    /** Process an instance of TemplateGapTraitSelfType. */
    public abstract RetType forTemplateGapTraitSelfType(TemplateGapTraitSelfType that);

    /** Process an instance of TemplateGapObjectExprType. */
    public abstract RetType forTemplateGapObjectExprType(TemplateGapObjectExprType that);

    /** Process an instance of TemplateGapNamedType. */
    public abstract RetType forTemplateGapNamedType(TemplateGapNamedType that);

    /** Process an instance of TemplateGap_InferenceVarType. */
    public abstract RetType forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that);

    /** Process an instance of TemplateGapVarType. */
    public abstract RetType forTemplateGapVarType(TemplateGapVarType that);

    /** Process an instance of TemplateGapTraitType. */
    public abstract RetType forTemplateGapTraitType(TemplateGapTraitType that);

    /** Process an instance of TemplateGapAbbreviatedType. */
    public abstract RetType forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that);

    /** Process an instance of TemplateGapArrayType. */
    public abstract RetType forTemplateGapArrayType(TemplateGapArrayType that);

    /** Process an instance of TemplateGapMatrixType. */
    public abstract RetType forTemplateGapMatrixType(TemplateGapMatrixType that);

    /** Process an instance of TemplateGapTaggedDimType. */
    public abstract RetType forTemplateGapTaggedDimType(TemplateGapTaggedDimType that);

    /** Process an instance of TemplateGapTaggedUnitType. */
    public abstract RetType forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that);

    /** Process an instance of TemplateGapTupleType. */
    public abstract RetType forTemplateGapTupleType(TemplateGapTupleType that);

    /** Process an instance of TemplateGapArrowType. */
    public abstract RetType forTemplateGapArrowType(TemplateGapArrowType that);

    /** Process an instance of TemplateGapBoundType. */
    public abstract RetType forTemplateGapBoundType(TemplateGapBoundType that);

    /** Process an instance of TemplateGapIntersectionType. */
    public abstract RetType forTemplateGapIntersectionType(TemplateGapIntersectionType that);

    /** Process an instance of TemplateGapUnionType. */
    public abstract RetType forTemplateGapUnionType(TemplateGapUnionType that);

    /** Process an instance of TemplateGapFixedPointType. */
    public abstract RetType forTemplateGapFixedPointType(TemplateGapFixedPointType that);

    /** Process an instance of TemplateGapLabelType. */
    public abstract RetType forTemplateGapLabelType(TemplateGapLabelType that);

    /** Process an instance of TemplateGapDimExpr. */
    public abstract RetType forTemplateGapDimExpr(TemplateGapDimExpr that);

    /** Process an instance of TemplateGapDimBase. */
    public abstract RetType forTemplateGapDimBase(TemplateGapDimBase that);

    /** Process an instance of TemplateGapDimRef. */
    public abstract RetType forTemplateGapDimRef(TemplateGapDimRef that);

    /** Process an instance of TemplateGapDimExponent. */
    public abstract RetType forTemplateGapDimExponent(TemplateGapDimExponent that);

    /** Process an instance of TemplateGapDimUnaryOp. */
    public abstract RetType forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that);

    /** Process an instance of TemplateGapDimBinaryOp. */
    public abstract RetType forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that);

    /** Process an instance of TemplateGapPattern. */
    public abstract RetType forTemplateGapPattern(TemplateGapPattern that);

    /** Process an instance of TemplateGapPatternArgs. */
    public abstract RetType forTemplateGapPatternArgs(TemplateGapPatternArgs that);

    /** Process an instance of TemplateGapPatternBinding. */
    public abstract RetType forTemplateGapPatternBinding(TemplateGapPatternBinding that);

    /** Process an instance of TemplateGapPlainPattern. */
    public abstract RetType forTemplateGapPlainPattern(TemplateGapPlainPattern that);

    /** Process an instance of TemplateGapTypePattern. */
    public abstract RetType forTemplateGapTypePattern(TemplateGapTypePattern that);

    /** Process an instance of TemplateGapNestedPattern. */
    public abstract RetType forTemplateGapNestedPattern(TemplateGapNestedPattern that);

    /** Process an instance of TemplateGapStaticArg. */
    public abstract RetType forTemplateGapStaticArg(TemplateGapStaticArg that);

    /** Process an instance of TemplateGapTypeArg. */
    public abstract RetType forTemplateGapTypeArg(TemplateGapTypeArg that);

    /** Process an instance of TemplateGapIntArg. */
    public abstract RetType forTemplateGapIntArg(TemplateGapIntArg that);

    /** Process an instance of TemplateGapBoolArg. */
    public abstract RetType forTemplateGapBoolArg(TemplateGapBoolArg that);

    /** Process an instance of TemplateGapOpArg. */
    public abstract RetType forTemplateGapOpArg(TemplateGapOpArg that);

    /** Process an instance of TemplateGapDimArg. */
    public abstract RetType forTemplateGapDimArg(TemplateGapDimArg that);

    /** Process an instance of TemplateGapUnitArg. */
    public abstract RetType forTemplateGapUnitArg(TemplateGapUnitArg that);

    /** Process an instance of TemplateGapStaticExpr. */
    public abstract RetType forTemplateGapStaticExpr(TemplateGapStaticExpr that);

    /** Process an instance of TemplateGapIntExpr. */
    public abstract RetType forTemplateGapIntExpr(TemplateGapIntExpr that);

    /** Process an instance of TemplateGapIntBase. */
    public abstract RetType forTemplateGapIntBase(TemplateGapIntBase that);

    /** Process an instance of TemplateGapIntRef. */
    public abstract RetType forTemplateGapIntRef(TemplateGapIntRef that);

    /** Process an instance of TemplateGapIntBinaryOp. */
    public abstract RetType forTemplateGapIntBinaryOp(TemplateGapIntBinaryOp that);

    /** Process an instance of TemplateGapBoolExpr. */
    public abstract RetType forTemplateGapBoolExpr(TemplateGapBoolExpr that);

    /** Process an instance of TemplateGapBoolBase. */
    public abstract RetType forTemplateGapBoolBase(TemplateGapBoolBase that);

    /** Process an instance of TemplateGapBoolRef. */
    public abstract RetType forTemplateGapBoolRef(TemplateGapBoolRef that);

    /** Process an instance of TemplateGapBoolConstraint. */
    public abstract RetType forTemplateGapBoolConstraint(TemplateGapBoolConstraint that);

    /** Process an instance of TemplateGapBoolUnaryOp. */
    public abstract RetType forTemplateGapBoolUnaryOp(TemplateGapBoolUnaryOp that);

    /** Process an instance of TemplateGapBoolBinaryOp. */
    public abstract RetType forTemplateGapBoolBinaryOp(TemplateGapBoolBinaryOp that);

    /** Process an instance of TemplateGapUnitExpr. */
    public abstract RetType forTemplateGapUnitExpr(TemplateGapUnitExpr that);

    /** Process an instance of TemplateGapUnitRef. */
    public abstract RetType forTemplateGapUnitRef(TemplateGapUnitRef that);

    /** Process an instance of TemplateGapUnitBinaryOp. */
    public abstract RetType forTemplateGapUnitBinaryOp(TemplateGapUnitBinaryOp that);

    /** Process an instance of TemplateGapEffect. */
    public abstract RetType forTemplateGapEffect(TemplateGapEffect that);

    /** Process an instance of TemplateGapWhereClause. */
    public abstract RetType forTemplateGapWhereClause(TemplateGapWhereClause that);

    /** Process an instance of TemplateGapWhereBinding. */
    public abstract RetType forTemplateGapWhereBinding(TemplateGapWhereBinding that);

    /** Process an instance of TemplateGapWhereConstraint. */
    public abstract RetType forTemplateGapWhereConstraint(TemplateGapWhereConstraint that);

    /** Process an instance of TemplateGapWhereExtends. */
    public abstract RetType forTemplateGapWhereExtends(TemplateGapWhereExtends that);

    /** Process an instance of TemplateGapWhereTypeAlias. */
    public abstract RetType forTemplateGapWhereTypeAlias(TemplateGapWhereTypeAlias that);

    /** Process an instance of TemplateGapWhereCoerces. */
    public abstract RetType forTemplateGapWhereCoerces(TemplateGapWhereCoerces that);

    /** Process an instance of TemplateGapWhereEquals. */
    public abstract RetType forTemplateGapWhereEquals(TemplateGapWhereEquals that);

    /** Process an instance of TemplateGapUnitConstraint. */
    public abstract RetType forTemplateGapUnitConstraint(TemplateGapUnitConstraint that);

    /** Process an instance of TemplateGapIntConstraint. */
    public abstract RetType forTemplateGapIntConstraint(TemplateGapIntConstraint that);

    /** Process an instance of TemplateGapBoolConstraintExpr. */
    public abstract RetType forTemplateGapBoolConstraintExpr(TemplateGapBoolConstraintExpr that);

    /** Process an instance of TemplateGapContract. */
    public abstract RetType forTemplateGapContract(TemplateGapContract that);

    /** Process an instance of TemplateGapEnsuresClause. */
    public abstract RetType forTemplateGapEnsuresClause(TemplateGapEnsuresClause that);

    /** Process an instance of TemplateGapStaticParam. */
    public abstract RetType forTemplateGapStaticParam(TemplateGapStaticParam that);

    /** Process an instance of TemplateGapName. */
    public abstract RetType forTemplateGapName(TemplateGapName that);

    /** Process an instance of TemplateGapAPIName. */
    public abstract RetType forTemplateGapAPIName(TemplateGapAPIName that);

    /** Process an instance of TemplateGapIdOrOpOrAnonymousName. */
    public abstract RetType forTemplateGapIdOrOpOrAnonymousName(TemplateGapIdOrOpOrAnonymousName that);

    /** Process an instance of TemplateGapIdOrOp. */
    public abstract RetType forTemplateGapIdOrOp(TemplateGapIdOrOp that);

    /** Process an instance of TemplateGapId. */
    public abstract RetType forTemplateGapId(TemplateGapId that);

    /** Process an instance of TemplateGapOp. */
    public abstract RetType forTemplateGapOp(TemplateGapOp that);

    /** Process an instance of TemplateGapNamedOp. */
    public abstract RetType forTemplateGapNamedOp(TemplateGapNamedOp that);

    /** Process an instance of TemplateGap_InferenceVarOp. */
    public abstract RetType forTemplateGap_InferenceVarOp(TemplateGap_InferenceVarOp that);

    /** Process an instance of TemplateGapAnonymousName. */
    public abstract RetType forTemplateGapAnonymousName(TemplateGapAnonymousName that);

    /** Process an instance of TemplateGapAnonymousFnName. */
    public abstract RetType forTemplateGapAnonymousFnName(TemplateGapAnonymousFnName that);

    /** Process an instance of TemplateGapConstructorFnName. */
    public abstract RetType forTemplateGapConstructorFnName(TemplateGapConstructorFnName that);

    /** Process an instance of TemplateGapArrayComprehensionClause. */
    public abstract RetType forTemplateGapArrayComprehensionClause(TemplateGapArrayComprehensionClause that);

    /** Process an instance of TemplateGapKeywordExpr. */
    public abstract RetType forTemplateGapKeywordExpr(TemplateGapKeywordExpr that);

    /** Process an instance of TemplateGapCaseClause. */
    public abstract RetType forTemplateGapCaseClause(TemplateGapCaseClause that);

    /** Process an instance of TemplateGapCatch. */
    public abstract RetType forTemplateGapCatch(TemplateGapCatch that);

    /** Process an instance of TemplateGapCatchClause. */
    public abstract RetType forTemplateGapCatchClause(TemplateGapCatchClause that);

    /** Process an instance of TemplateGapIfClause. */
    public abstract RetType forTemplateGapIfClause(TemplateGapIfClause that);

    /** Process an instance of TemplateGapTypecaseClause. */
    public abstract RetType forTemplateGapTypecaseClause(TemplateGapTypecaseClause that);

    /** Process an instance of TemplateGapExtentRange. */
    public abstract RetType forTemplateGapExtentRange(TemplateGapExtentRange that);

    /** Process an instance of TemplateGapGeneratorClause. */
    public abstract RetType forTemplateGapGeneratorClause(TemplateGapGeneratorClause that);

    /** Process an instance of TemplateGapKeywordType. */
    public abstract RetType forTemplateGapKeywordType(TemplateGapKeywordType that);

    /** Process an instance of TemplateGapTraitTypeWhere. */
    public abstract RetType forTemplateGapTraitTypeWhere(TemplateGapTraitTypeWhere that);

    /** Process an instance of TemplateGapIndices. */
    public abstract RetType forTemplateGapIndices(TemplateGapIndices that);

    /** Process an instance of TemplateGapMathItem. */
    public abstract RetType forTemplateGapMathItem(TemplateGapMathItem that);

    /** Process an instance of TemplateGapExprMI. */
    public abstract RetType forTemplateGapExprMI(TemplateGapExprMI that);

    /** Process an instance of TemplateGapParenthesisDelimitedMI. */
    public abstract RetType forTemplateGapParenthesisDelimitedMI(TemplateGapParenthesisDelimitedMI that);

    /** Process an instance of TemplateGapNonParenthesisDelimitedMI. */
    public abstract RetType forTemplateGapNonParenthesisDelimitedMI(TemplateGapNonParenthesisDelimitedMI that);

    /** Process an instance of TemplateGapNonExprMI. */
    public abstract RetType forTemplateGapNonExprMI(TemplateGapNonExprMI that);

    /** Process an instance of TemplateGapExponentiationMI. */
    public abstract RetType forTemplateGapExponentiationMI(TemplateGapExponentiationMI that);

    /** Process an instance of TemplateGapSubscriptingMI. */
    public abstract RetType forTemplateGapSubscriptingMI(TemplateGapSubscriptingMI that);

    /** Process an instance of TemplateGapOverloading. */
    public abstract RetType forTemplateGapOverloading(TemplateGapOverloading that);

    /** Process an instance of TemplateGapNonterminalHeader. */
    public abstract RetType forTemplateGapNonterminalHeader(TemplateGapNonterminalHeader that);

    /** Process an instance of TemplateGapNonterminalParameter. */
    public abstract RetType forTemplateGapNonterminalParameter(TemplateGapNonterminalParameter that);

    /** Process an instance of TemplateGapSyntaxDecl. */
    public abstract RetType forTemplateGapSyntaxDecl(TemplateGapSyntaxDecl that);

    /** Process an instance of TemplateGapSyntaxDef. */
    public abstract RetType forTemplateGapSyntaxDef(TemplateGapSyntaxDef that);

    /** Process an instance of TemplateGapSuperSyntaxDef. */
    public abstract RetType forTemplateGapSuperSyntaxDef(TemplateGapSuperSyntaxDef that);

    /** Process an instance of TemplateGapTransformerDecl. */
    public abstract RetType forTemplateGapTransformerDecl(TemplateGapTransformerDecl that);

    /** Process an instance of TemplateGapPreTransformerDef. */
    public abstract RetType forTemplateGapPreTransformerDef(TemplateGapPreTransformerDef that);

    /** Process an instance of TemplateGapNamedTransformerDef. */
    public abstract RetType forTemplateGapNamedTransformerDef(TemplateGapNamedTransformerDef that);

    /** Process an instance of TemplateGapTransformer. */
    public abstract RetType forTemplateGapTransformer(TemplateGapTransformer that);

    /** Process an instance of TemplateGapUnparsedTransformer. */
    public abstract RetType forTemplateGapUnparsedTransformer(TemplateGapUnparsedTransformer that);

    /** Process an instance of TemplateGapNodeTransformer. */
    public abstract RetType forTemplateGapNodeTransformer(TemplateGapNodeTransformer that);

    /** Process an instance of TemplateGapCaseTransformer. */
    public abstract RetType forTemplateGapCaseTransformer(TemplateGapCaseTransformer that);

    /** Process an instance of TemplateGapCaseTransformerClause. */
    public abstract RetType forTemplateGapCaseTransformerClause(TemplateGapCaseTransformerClause that);

    /** Process an instance of TemplateGapSyntaxSymbol. */
    public abstract RetType forTemplateGapSyntaxSymbol(TemplateGapSyntaxSymbol that);

    /** Process an instance of TemplateGapPrefixedSymbol. */
    public abstract RetType forTemplateGapPrefixedSymbol(TemplateGapPrefixedSymbol that);

    /** Process an instance of TemplateGapOptionalSymbol. */
    public abstract RetType forTemplateGapOptionalSymbol(TemplateGapOptionalSymbol that);

    /** Process an instance of TemplateGapRepeatSymbol. */
    public abstract RetType forTemplateGapRepeatSymbol(TemplateGapRepeatSymbol that);

    /** Process an instance of TemplateGapRepeatOneOrMoreSymbol. */
    public abstract RetType forTemplateGapRepeatOneOrMoreSymbol(TemplateGapRepeatOneOrMoreSymbol that);

    /** Process an instance of TemplateGapNoWhitespaceSymbol. */
    public abstract RetType forTemplateGapNoWhitespaceSymbol(TemplateGapNoWhitespaceSymbol that);

    /** Process an instance of TemplateGapGroupSymbol. */
    public abstract RetType forTemplateGapGroupSymbol(TemplateGapGroupSymbol that);

    /** Process an instance of TemplateGapSpecialSymbol. */
    public abstract RetType forTemplateGapSpecialSymbol(TemplateGapSpecialSymbol that);

    /** Process an instance of TemplateGapAnyCharacterSymbol. */
    public abstract RetType forTemplateGapAnyCharacterSymbol(TemplateGapAnyCharacterSymbol that);

    /** Process an instance of TemplateGapWhitespaceSymbol. */
    public abstract RetType forTemplateGapWhitespaceSymbol(TemplateGapWhitespaceSymbol that);

    /** Process an instance of TemplateGapTabSymbol. */
    public abstract RetType forTemplateGapTabSymbol(TemplateGapTabSymbol that);

    /** Process an instance of TemplateGapFormfeedSymbol. */
    public abstract RetType forTemplateGapFormfeedSymbol(TemplateGapFormfeedSymbol that);

    /** Process an instance of TemplateGapCarriageReturnSymbol. */
    public abstract RetType forTemplateGapCarriageReturnSymbol(TemplateGapCarriageReturnSymbol that);

    /** Process an instance of TemplateGapBackspaceSymbol. */
    public abstract RetType forTemplateGapBackspaceSymbol(TemplateGapBackspaceSymbol that);

    /** Process an instance of TemplateGapNewlineSymbol. */
    public abstract RetType forTemplateGapNewlineSymbol(TemplateGapNewlineSymbol that);

    /** Process an instance of TemplateGapBreaklineSymbol. */
    public abstract RetType forTemplateGapBreaklineSymbol(TemplateGapBreaklineSymbol that);

    /** Process an instance of TemplateGapItemSymbol. */
    public abstract RetType forTemplateGapItemSymbol(TemplateGapItemSymbol that);

    /** Process an instance of TemplateGapNonterminalSymbol. */
    public abstract RetType forTemplateGapNonterminalSymbol(TemplateGapNonterminalSymbol that);

    /** Process an instance of TemplateGapKeywordSymbol. */
    public abstract RetType forTemplateGapKeywordSymbol(TemplateGapKeywordSymbol that);

    /** Process an instance of TemplateGapTokenSymbol. */
    public abstract RetType forTemplateGapTokenSymbol(TemplateGapTokenSymbol that);

    /** Process an instance of TemplateGapNotPredicateSymbol. */
    public abstract RetType forTemplateGapNotPredicateSymbol(TemplateGapNotPredicateSymbol that);

    /** Process an instance of TemplateGapAndPredicateSymbol. */
    public abstract RetType forTemplateGapAndPredicateSymbol(TemplateGapAndPredicateSymbol that);

    /** Process an instance of TemplateGapCharacterClassSymbol. */
    public abstract RetType forTemplateGapCharacterClassSymbol(TemplateGapCharacterClassSymbol that);

    /** Process an instance of TemplateGapCharacterSymbol. */
    public abstract RetType forTemplateGapCharacterSymbol(TemplateGapCharacterSymbol that);

    /** Process an instance of TemplateGapCharSymbol. */
    public abstract RetType forTemplateGapCharSymbol(TemplateGapCharSymbol that);

    /** Process an instance of TemplateGapCharacterInterval. */
    public abstract RetType forTemplateGapCharacterInterval(TemplateGapCharacterInterval that);

    /** Process an instance of TemplateGapLink. */
    public abstract RetType forTemplateGapLink(TemplateGapLink that);
}
