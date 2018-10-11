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

/** An abstract implementation of a visitor over AbstractNode that does not return a value.
 ** This visitor implements the visitor interface with methods that each 
 ** delegate to a case representing their superclass.  At the top of this
 ** delegation tree is the method defaultCase(), which (unless overridden)
 ** is a no-op.
 **/
@SuppressWarnings("unused")
public class AbstractNodeAbstractVisitor_void extends AbstractNodeVisitorRunnable1 {
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, it is a no-op; subclasses may override this behavior.
    **/
    public void defaultCase(AbstractNode that) {}

    /* Methods to visit an item. */
    public void forAbstractNode(AbstractNode that) {
        defaultCase(that);
    }

    public void forCompilationUnit(CompilationUnit that) {
        forAbstractNode(that);
    }

    public void forComponent(Component that) {
        forCompilationUnit(that);
    }

    public void forApi(Api that) {
        forCompilationUnit(that);
    }

    public void forImport(Import that) {
        forAbstractNode(that);
    }

    public void forImportedNames(ImportedNames that) {
        forImport(that);
    }

    public void forImportStar(ImportStar that) {
        forImportedNames(that);
    }

    public void forImportNames(ImportNames that) {
        forImportedNames(that);
    }

    public void forImportApi(ImportApi that) {
        forImport(that);
    }

    public void forAliasedSimpleName(AliasedSimpleName that) {
        forAbstractNode(that);
    }

    public void forAliasedAPIName(AliasedAPIName that) {
        forAbstractNode(that);
    }

    public void forDecl(Decl that) {
        forAbstractNode(that);
    }

    public void forTraitObjectDecl(TraitObjectDecl that) {
        forDecl(that);
    }

    public void forTraitDecl(TraitDecl that) {
        forTraitObjectDecl(that);
    }

    public void forObjectDecl(ObjectDecl that) {
        forTraitObjectDecl(that);
    }

    public void forVarDecl(VarDecl that) {
        forDecl(that);
    }

    public void forFnDecl(FnDecl that) {
        forDecl(that);
    }

    public void for_RewriteFnOverloadDecl(_RewriteFnOverloadDecl that) {
        forDecl(that);
    }

    public void for_RewriteObjectExprDecl(_RewriteObjectExprDecl that) {
        forDecl(that);
    }

    public void for_RewriteFunctionalMethodDecl(_RewriteFunctionalMethodDecl that) {
        forDecl(that);
    }

    public void forDimUnitDecl(DimUnitDecl that) {
        forDecl(that);
    }

    public void forDimDecl(DimDecl that) {
        forDimUnitDecl(that);
    }

    public void forUnitDecl(UnitDecl that) {
        forDimUnitDecl(that);
    }

    public void forTestDecl(TestDecl that) {
        forDecl(that);
    }

    public void forPropertyDecl(PropertyDecl that) {
        forDecl(that);
    }

    public void forTypeAlias(TypeAlias that) {
        forDecl(that);
    }

    public void forGrammarDecl(GrammarDecl that) {
        forDecl(that);
    }

    public void forGrammarMemberDecl(GrammarMemberDecl that) {
        forDecl(that);
    }

    public void forNonterminalDecl(NonterminalDecl that) {
        forGrammarMemberDecl(that);
    }

    public void forNonterminalDef(NonterminalDef that) {
        forNonterminalDecl(that);
    }

    public void forNonterminalExtensionDef(NonterminalExtensionDef that) {
        forNonterminalDecl(that);
    }

    public void forBinding(Binding that) {
        forAbstractNode(that);
    }

    public void forLValue(LValue that) {
        forBinding(that);
    }

    public void forParam(Param that) {
        forBinding(that);
    }

    public void forExpr(Expr that) {
        forAbstractNode(that);
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

    public void forType(Type that) {
        forAbstractNode(that);
    }

    public void forBaseType(BaseType that) {
        forType(that);
    }

    public void forAnyType(AnyType that) {
        forBaseType(that);
    }

    public void forBottomType(BottomType that) {
        forBaseType(that);
    }

    public void forUnknownType(UnknownType that) {
        forBaseType(that);
    }

    public void forSelfType(SelfType that) {
        forBaseType(that);
    }

    public void forTraitSelfType(TraitSelfType that) {
        forSelfType(that);
    }

    public void forObjectExprType(ObjectExprType that) {
        forSelfType(that);
    }

    public void forNamedType(NamedType that) {
        forBaseType(that);
    }

    public void for_InferenceVarType(_InferenceVarType that) {
        forNamedType(that);
    }

    public void forVarType(VarType that) {
        forNamedType(that);
    }

    public void forTraitType(TraitType that) {
        forNamedType(that);
    }

    public void forAbbreviatedType(AbbreviatedType that) {
        forBaseType(that);
    }

    public void forArrayType(ArrayType that) {
        forAbbreviatedType(that);
    }

    public void forMatrixType(MatrixType that) {
        forAbbreviatedType(that);
    }

    public void forTaggedDimType(TaggedDimType that) {
        forAbbreviatedType(that);
    }

    public void forTaggedUnitType(TaggedUnitType that) {
        forAbbreviatedType(that);
    }

    public void forTupleType(TupleType that) {
        forType(that);
    }

    public void forArrowType(ArrowType that) {
        forType(that);
    }

    public void forBoundType(BoundType that) {
        forType(that);
    }

    public void forIntersectionType(IntersectionType that) {
        forBoundType(that);
    }

    public void forUnionType(UnionType that) {
        forBoundType(that);
    }

    public void forFixedPointType(FixedPointType that) {
        forType(that);
    }

    public void forLabelType(LabelType that) {
        forType(that);
    }

    public void forDimExpr(DimExpr that) {
        forType(that);
    }

    public void forDimBase(DimBase that) {
        forDimExpr(that);
    }

    public void forDimRef(DimRef that) {
        forDimExpr(that);
    }

    public void forDimExponent(DimExponent that) {
        forDimExpr(that);
    }

    public void forDimUnaryOp(DimUnaryOp that) {
        forDimExpr(that);
    }

    public void forDimBinaryOp(DimBinaryOp that) {
        forDimExpr(that);
    }

    public void forPattern(Pattern that) {
        forAbstractNode(that);
    }

    public void forPatternArgs(PatternArgs that) {
        forAbstractNode(that);
    }

    public void forPatternBinding(PatternBinding that) {
        forAbstractNode(that);
    }

    public void forPlainPattern(PlainPattern that) {
        forPatternBinding(that);
    }

    public void forTypePattern(TypePattern that) {
        forPatternBinding(that);
    }

    public void forNestedPattern(NestedPattern that) {
        forPatternBinding(that);
    }

    public void forStaticArg(StaticArg that) {
        forAbstractNode(that);
    }

    public void forTypeArg(TypeArg that) {
        forStaticArg(that);
    }

    public void forIntArg(IntArg that) {
        forStaticArg(that);
    }

    public void forBoolArg(BoolArg that) {
        forStaticArg(that);
    }

    public void forOpArg(OpArg that) {
        forStaticArg(that);
    }

    public void forDimArg(DimArg that) {
        forStaticArg(that);
    }

    public void forUnitArg(UnitArg that) {
        forStaticArg(that);
    }

    public void forStaticExpr(StaticExpr that) {
        forAbstractNode(that);
    }

    public void forIntExpr(IntExpr that) {
        forStaticExpr(that);
    }

    public void forIntBase(IntBase that) {
        forIntExpr(that);
    }

    public void forIntRef(IntRef that) {
        forIntExpr(that);
    }

    public void forIntBinaryOp(IntBinaryOp that) {
        forIntExpr(that);
    }

    public void forBoolExpr(BoolExpr that) {
        forStaticExpr(that);
    }

    public void forBoolBase(BoolBase that) {
        forBoolExpr(that);
    }

    public void forBoolRef(BoolRef that) {
        forBoolExpr(that);
    }

    public void forBoolConstraint(BoolConstraint that) {
        forBoolExpr(that);
    }

    public void forBoolUnaryOp(BoolUnaryOp that) {
        forBoolConstraint(that);
    }

    public void forBoolBinaryOp(BoolBinaryOp that) {
        forBoolConstraint(that);
    }

    public void forUnitExpr(UnitExpr that) {
        forStaticExpr(that);
    }

    public void forUnitRef(UnitRef that) {
        forUnitExpr(that);
    }

    public void forUnitBinaryOp(UnitBinaryOp that) {
        forUnitExpr(that);
    }

    public void forEffect(Effect that) {
        forAbstractNode(that);
    }

    public void forWhereClause(WhereClause that) {
        forAbstractNode(that);
    }

    public void forWhereBinding(WhereBinding that) {
        forAbstractNode(that);
    }

    public void forWhereConstraint(WhereConstraint that) {
        forAbstractNode(that);
    }

    public void forWhereExtends(WhereExtends that) {
        forWhereConstraint(that);
    }

    public void forWhereTypeAlias(WhereTypeAlias that) {
        forWhereConstraint(that);
    }

    public void forWhereCoerces(WhereCoerces that) {
        forWhereConstraint(that);
    }

    public void forWhereEquals(WhereEquals that) {
        forWhereConstraint(that);
    }

    public void forUnitConstraint(UnitConstraint that) {
        forWhereConstraint(that);
    }

    public void forIntConstraint(IntConstraint that) {
        forWhereConstraint(that);
    }

    public void forBoolConstraintExpr(BoolConstraintExpr that) {
        forWhereConstraint(that);
    }

    public void forContract(Contract that) {
        forAbstractNode(that);
    }

    public void forEnsuresClause(EnsuresClause that) {
        forAbstractNode(that);
    }

    public void forStaticParam(StaticParam that) {
        forAbstractNode(that);
    }

    public void forName(Name that) {
        forAbstractNode(that);
    }

    public void forAPIName(APIName that) {
        forName(that);
    }

    public void forIdOrOpOrAnonymousName(IdOrOpOrAnonymousName that) {
        forName(that);
    }

    public void forIdOrOp(IdOrOp that) {
        forIdOrOpOrAnonymousName(that);
    }

    public void forId(Id that) {
        forIdOrOp(that);
    }

    public void forOp(Op that) {
        forIdOrOp(that);
    }

    public void forNamedOp(NamedOp that) {
        forOp(that);
    }

    public void for_InferenceVarOp(_InferenceVarOp that) {
        forOp(that);
    }

    public void forAnonymousName(AnonymousName that) {
        forIdOrOpOrAnonymousName(that);
    }

    public void forAnonymousFnName(AnonymousFnName that) {
        forAnonymousName(that);
    }

    public void forConstructorFnName(ConstructorFnName that) {
        forAnonymousName(that);
    }

    public void forArrayComprehensionClause(ArrayComprehensionClause that) {
        forAbstractNode(that);
    }

    public void forKeywordExpr(KeywordExpr that) {
        forAbstractNode(that);
    }

    public void forCaseClause(CaseClause that) {
        forAbstractNode(that);
    }

    public void forCatch(Catch that) {
        forAbstractNode(that);
    }

    public void forCatchClause(CatchClause that) {
        forAbstractNode(that);
    }

    public void forIfClause(IfClause that) {
        forAbstractNode(that);
    }

    public void forTypecaseClause(TypecaseClause that) {
        forAbstractNode(that);
    }

    public void forExtentRange(ExtentRange that) {
        forAbstractNode(that);
    }

    public void forGeneratorClause(GeneratorClause that) {
        forAbstractNode(that);
    }

    public void forKeywordType(KeywordType that) {
        forAbstractNode(that);
    }

    public void forTraitTypeWhere(TraitTypeWhere that) {
        forAbstractNode(that);
    }

    public void forIndices(Indices that) {
        forAbstractNode(that);
    }

    public void forMathItem(MathItem that) {
        forAbstractNode(that);
    }

    public void forExprMI(ExprMI that) {
        forMathItem(that);
    }

    public void forParenthesisDelimitedMI(ParenthesisDelimitedMI that) {
        forExprMI(that);
    }

    public void forNonParenthesisDelimitedMI(NonParenthesisDelimitedMI that) {
        forExprMI(that);
    }

    public void forNonExprMI(NonExprMI that) {
        forMathItem(that);
    }

    public void forExponentiationMI(ExponentiationMI that) {
        forNonExprMI(that);
    }

    public void forSubscriptingMI(SubscriptingMI that) {
        forNonExprMI(that);
    }

    public void forOverloading(Overloading that) {
        forAbstractNode(that);
    }

    public void forNonterminalHeader(NonterminalHeader that) {
        forAbstractNode(that);
    }

    public void forNonterminalParameter(NonterminalParameter that) {
        forAbstractNode(that);
    }

    public void forSyntaxDecl(SyntaxDecl that) {
        forAbstractNode(that);
    }

    public void forSyntaxDef(SyntaxDef that) {
        forSyntaxDecl(that);
    }

    public void forSuperSyntaxDef(SuperSyntaxDef that) {
        forSyntaxDecl(that);
    }

    public void forTransformerDecl(TransformerDecl that) {
        forAbstractNode(that);
    }

    public void forPreTransformerDef(PreTransformerDef that) {
        forTransformerDecl(that);
    }

    public void forNamedTransformerDef(NamedTransformerDef that) {
        forTransformerDecl(that);
    }

    public void forTransformer(Transformer that) {
        forAbstractNode(that);
    }

    public void forUnparsedTransformer(UnparsedTransformer that) {
        forTransformer(that);
    }

    public void forNodeTransformer(NodeTransformer that) {
        forTransformer(that);
    }

    public void forCaseTransformer(CaseTransformer that) {
        forTransformer(that);
    }

    public void forCaseTransformerClause(CaseTransformerClause that) {
        forAbstractNode(that);
    }

    public void forSyntaxSymbol(SyntaxSymbol that) {
        forAbstractNode(that);
    }

    public void forPrefixedSymbol(PrefixedSymbol that) {
        forSyntaxSymbol(that);
    }

    public void forOptionalSymbol(OptionalSymbol that) {
        forSyntaxSymbol(that);
    }

    public void forRepeatSymbol(RepeatSymbol that) {
        forSyntaxSymbol(that);
    }

    public void forRepeatOneOrMoreSymbol(RepeatOneOrMoreSymbol that) {
        forSyntaxSymbol(that);
    }

    public void forNoWhitespaceSymbol(NoWhitespaceSymbol that) {
        forSyntaxSymbol(that);
    }

    public void forGroupSymbol(GroupSymbol that) {
        forSyntaxSymbol(that);
    }

    public void forSpecialSymbol(SpecialSymbol that) {
        forSyntaxSymbol(that);
    }

    public void forAnyCharacterSymbol(AnyCharacterSymbol that) {
        forSpecialSymbol(that);
    }

    public void forWhitespaceSymbol(WhitespaceSymbol that) {
        forSpecialSymbol(that);
    }

    public void forTabSymbol(TabSymbol that) {
        forSpecialSymbol(that);
    }

    public void forFormfeedSymbol(FormfeedSymbol that) {
        forSpecialSymbol(that);
    }

    public void forCarriageReturnSymbol(CarriageReturnSymbol that) {
        forSpecialSymbol(that);
    }

    public void forBackspaceSymbol(BackspaceSymbol that) {
        forSpecialSymbol(that);
    }

    public void forNewlineSymbol(NewlineSymbol that) {
        forSpecialSymbol(that);
    }

    public void forBreaklineSymbol(BreaklineSymbol that) {
        forSpecialSymbol(that);
    }

    public void forItemSymbol(ItemSymbol that) {
        forSyntaxSymbol(that);
    }

    public void forNonterminalSymbol(NonterminalSymbol that) {
        forSyntaxSymbol(that);
    }

    public void forKeywordSymbol(KeywordSymbol that) {
        forSyntaxSymbol(that);
    }

    public void forTokenSymbol(TokenSymbol that) {
        forSyntaxSymbol(that);
    }

    public void forNotPredicateSymbol(NotPredicateSymbol that) {
        forSyntaxSymbol(that);
    }

    public void forAndPredicateSymbol(AndPredicateSymbol that) {
        forSyntaxSymbol(that);
    }

    public void forCharacterClassSymbol(CharacterClassSymbol that) {
        forSyntaxSymbol(that);
    }

    public void forCharacterSymbol(CharacterSymbol that) {
        forSyntaxSymbol(that);
    }

    public void forCharSymbol(CharSymbol that) {
        forCharacterSymbol(that);
    }

    public void forCharacterInterval(CharacterInterval that) {
        forCharacterSymbol(that);
    }

    public void forLink(Link that) {
        forAbstractNode(that);
    }

    public void for_SyntaxTransformationAbstractNode(_SyntaxTransformationAbstractNode that) {
        forAbstractNode(that);
    }

    public void for_SyntaxTransformationCompilationUnit(_SyntaxTransformationCompilationUnit that) {
        forCompilationUnit(that);
    }

    public void for_SyntaxTransformationComponent(_SyntaxTransformationComponent that) {
        forComponent(that);
    }

    public void for_SyntaxTransformationApi(_SyntaxTransformationApi that) {
        forApi(that);
    }

    public void for_SyntaxTransformationImport(_SyntaxTransformationImport that) {
        forImport(that);
    }

    public void for_SyntaxTransformationImportedNames(_SyntaxTransformationImportedNames that) {
        forImportedNames(that);
    }

    public void for_SyntaxTransformationImportStar(_SyntaxTransformationImportStar that) {
        forImportStar(that);
    }

    public void for_SyntaxTransformationImportNames(_SyntaxTransformationImportNames that) {
        forImportNames(that);
    }

    public void for_SyntaxTransformationImportApi(_SyntaxTransformationImportApi that) {
        forImportApi(that);
    }

    public void for_SyntaxTransformationAliasedSimpleName(_SyntaxTransformationAliasedSimpleName that) {
        forAliasedSimpleName(that);
    }

    public void for_SyntaxTransformationAliasedAPIName(_SyntaxTransformationAliasedAPIName that) {
        forAliasedAPIName(that);
    }

    public void for_SyntaxTransformationDecl(_SyntaxTransformationDecl that) {
        forDecl(that);
    }

    public void for_SyntaxTransformationTraitObjectDecl(_SyntaxTransformationTraitObjectDecl that) {
        forTraitObjectDecl(that);
    }

    public void for_SyntaxTransformationTraitDecl(_SyntaxTransformationTraitDecl that) {
        forTraitDecl(that);
    }

    public void for_SyntaxTransformationObjectDecl(_SyntaxTransformationObjectDecl that) {
        forObjectDecl(that);
    }

    public void for_SyntaxTransformationVarDecl(_SyntaxTransformationVarDecl that) {
        forVarDecl(that);
    }

    public void for_SyntaxTransformationFnDecl(_SyntaxTransformationFnDecl that) {
        forFnDecl(that);
    }

    public void for_SyntaxTransformation_RewriteFnOverloadDecl(_SyntaxTransformation_RewriteFnOverloadDecl that) {
        for_RewriteFnOverloadDecl(that);
    }

    public void for_SyntaxTransformation_RewriteObjectExprDecl(_SyntaxTransformation_RewriteObjectExprDecl that) {
        for_RewriteObjectExprDecl(that);
    }

    public void for_SyntaxTransformation_RewriteFunctionalMethodDecl(_SyntaxTransformation_RewriteFunctionalMethodDecl that) {
        for_RewriteFunctionalMethodDecl(that);
    }

    public void for_SyntaxTransformationDimUnitDecl(_SyntaxTransformationDimUnitDecl that) {
        forDimUnitDecl(that);
    }

    public void for_SyntaxTransformationDimDecl(_SyntaxTransformationDimDecl that) {
        forDimDecl(that);
    }

    public void for_SyntaxTransformationUnitDecl(_SyntaxTransformationUnitDecl that) {
        forUnitDecl(that);
    }

    public void for_SyntaxTransformationTestDecl(_SyntaxTransformationTestDecl that) {
        forTestDecl(that);
    }

    public void for_SyntaxTransformationPropertyDecl(_SyntaxTransformationPropertyDecl that) {
        forPropertyDecl(that);
    }

    public void for_SyntaxTransformationTypeAlias(_SyntaxTransformationTypeAlias that) {
        forTypeAlias(that);
    }

    public void for_SyntaxTransformationGrammarDecl(_SyntaxTransformationGrammarDecl that) {
        forGrammarDecl(that);
    }

    public void for_SyntaxTransformationGrammarMemberDecl(_SyntaxTransformationGrammarMemberDecl that) {
        forGrammarMemberDecl(that);
    }

    public void for_SyntaxTransformationNonterminalDecl(_SyntaxTransformationNonterminalDecl that) {
        forNonterminalDecl(that);
    }

    public void for_SyntaxTransformationNonterminalDef(_SyntaxTransformationNonterminalDef that) {
        forNonterminalDef(that);
    }

    public void for_SyntaxTransformationNonterminalExtensionDef(_SyntaxTransformationNonterminalExtensionDef that) {
        forNonterminalExtensionDef(that);
    }

    public void for_SyntaxTransformationBinding(_SyntaxTransformationBinding that) {
        forBinding(that);
    }

    public void for_SyntaxTransformationLValue(_SyntaxTransformationLValue that) {
        forLValue(that);
    }

    public void for_SyntaxTransformationParam(_SyntaxTransformationParam that) {
        forParam(that);
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

    public void for_SyntaxTransformationType(_SyntaxTransformationType that) {
        forType(that);
    }

    public void for_SyntaxTransformationBaseType(_SyntaxTransformationBaseType that) {
        forBaseType(that);
    }

    public void for_SyntaxTransformationAnyType(_SyntaxTransformationAnyType that) {
        forAnyType(that);
    }

    public void for_SyntaxTransformationBottomType(_SyntaxTransformationBottomType that) {
        forBottomType(that);
    }

    public void for_SyntaxTransformationUnknownType(_SyntaxTransformationUnknownType that) {
        forUnknownType(that);
    }

    public void for_SyntaxTransformationSelfType(_SyntaxTransformationSelfType that) {
        forSelfType(that);
    }

    public void for_SyntaxTransformationTraitSelfType(_SyntaxTransformationTraitSelfType that) {
        forTraitSelfType(that);
    }

    public void for_SyntaxTransformationObjectExprType(_SyntaxTransformationObjectExprType that) {
        forObjectExprType(that);
    }

    public void for_SyntaxTransformationNamedType(_SyntaxTransformationNamedType that) {
        forNamedType(that);
    }

    public void for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that) {
        for_InferenceVarType(that);
    }

    public void for_SyntaxTransformationVarType(_SyntaxTransformationVarType that) {
        forVarType(that);
    }

    public void for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that) {
        forTraitType(that);
    }

    public void for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that) {
        forAbbreviatedType(that);
    }

    public void for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that) {
        forArrayType(that);
    }

    public void for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that) {
        forMatrixType(that);
    }

    public void for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that) {
        forTaggedDimType(that);
    }

    public void for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that) {
        forTaggedUnitType(that);
    }

    public void for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that) {
        forTupleType(that);
    }

    public void for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that) {
        forArrowType(that);
    }

    public void for_SyntaxTransformationBoundType(_SyntaxTransformationBoundType that) {
        forBoundType(that);
    }

    public void for_SyntaxTransformationIntersectionType(_SyntaxTransformationIntersectionType that) {
        forIntersectionType(that);
    }

    public void for_SyntaxTransformationUnionType(_SyntaxTransformationUnionType that) {
        forUnionType(that);
    }

    public void for_SyntaxTransformationFixedPointType(_SyntaxTransformationFixedPointType that) {
        forFixedPointType(that);
    }

    public void for_SyntaxTransformationLabelType(_SyntaxTransformationLabelType that) {
        forLabelType(that);
    }

    public void for_SyntaxTransformationDimExpr(_SyntaxTransformationDimExpr that) {
        forDimExpr(that);
    }

    public void for_SyntaxTransformationDimBase(_SyntaxTransformationDimBase that) {
        forDimBase(that);
    }

    public void for_SyntaxTransformationDimRef(_SyntaxTransformationDimRef that) {
        forDimRef(that);
    }

    public void for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that) {
        forDimExponent(that);
    }

    public void for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that) {
        forDimUnaryOp(that);
    }

    public void for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that) {
        forDimBinaryOp(that);
    }

    public void for_SyntaxTransformationPattern(_SyntaxTransformationPattern that) {
        forPattern(that);
    }

    public void for_SyntaxTransformationPatternArgs(_SyntaxTransformationPatternArgs that) {
        forPatternArgs(that);
    }

    public void for_SyntaxTransformationPatternBinding(_SyntaxTransformationPatternBinding that) {
        forPatternBinding(that);
    }

    public void for_SyntaxTransformationPlainPattern(_SyntaxTransformationPlainPattern that) {
        forPlainPattern(that);
    }

    public void for_SyntaxTransformationTypePattern(_SyntaxTransformationTypePattern that) {
        forTypePattern(that);
    }

    public void for_SyntaxTransformationNestedPattern(_SyntaxTransformationNestedPattern that) {
        forNestedPattern(that);
    }

    public void for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that) {
        forStaticArg(that);
    }

    public void for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that) {
        forTypeArg(that);
    }

    public void for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that) {
        forIntArg(that);
    }

    public void for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that) {
        forBoolArg(that);
    }

    public void for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that) {
        forOpArg(that);
    }

    public void for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that) {
        forDimArg(that);
    }

    public void for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that) {
        forUnitArg(that);
    }

    public void for_SyntaxTransformationStaticExpr(_SyntaxTransformationStaticExpr that) {
        forStaticExpr(that);
    }

    public void for_SyntaxTransformationIntExpr(_SyntaxTransformationIntExpr that) {
        forIntExpr(that);
    }

    public void for_SyntaxTransformationIntBase(_SyntaxTransformationIntBase that) {
        forIntBase(that);
    }

    public void for_SyntaxTransformationIntRef(_SyntaxTransformationIntRef that) {
        forIntRef(that);
    }

    public void for_SyntaxTransformationIntBinaryOp(_SyntaxTransformationIntBinaryOp that) {
        forIntBinaryOp(that);
    }

    public void for_SyntaxTransformationBoolExpr(_SyntaxTransformationBoolExpr that) {
        forBoolExpr(that);
    }

    public void for_SyntaxTransformationBoolBase(_SyntaxTransformationBoolBase that) {
        forBoolBase(that);
    }

    public void for_SyntaxTransformationBoolRef(_SyntaxTransformationBoolRef that) {
        forBoolRef(that);
    }

    public void for_SyntaxTransformationBoolConstraint(_SyntaxTransformationBoolConstraint that) {
        forBoolConstraint(that);
    }

    public void for_SyntaxTransformationBoolUnaryOp(_SyntaxTransformationBoolUnaryOp that) {
        forBoolUnaryOp(that);
    }

    public void for_SyntaxTransformationBoolBinaryOp(_SyntaxTransformationBoolBinaryOp that) {
        forBoolBinaryOp(that);
    }

    public void for_SyntaxTransformationUnitExpr(_SyntaxTransformationUnitExpr that) {
        forUnitExpr(that);
    }

    public void for_SyntaxTransformationUnitRef(_SyntaxTransformationUnitRef that) {
        forUnitRef(that);
    }

    public void for_SyntaxTransformationUnitBinaryOp(_SyntaxTransformationUnitBinaryOp that) {
        forUnitBinaryOp(that);
    }

    public void for_SyntaxTransformationEffect(_SyntaxTransformationEffect that) {
        forEffect(that);
    }

    public void for_SyntaxTransformationWhereClause(_SyntaxTransformationWhereClause that) {
        forWhereClause(that);
    }

    public void for_SyntaxTransformationWhereBinding(_SyntaxTransformationWhereBinding that) {
        forWhereBinding(that);
    }

    public void for_SyntaxTransformationWhereConstraint(_SyntaxTransformationWhereConstraint that) {
        forWhereConstraint(that);
    }

    public void for_SyntaxTransformationWhereExtends(_SyntaxTransformationWhereExtends that) {
        forWhereExtends(that);
    }

    public void for_SyntaxTransformationWhereTypeAlias(_SyntaxTransformationWhereTypeAlias that) {
        forWhereTypeAlias(that);
    }

    public void for_SyntaxTransformationWhereCoerces(_SyntaxTransformationWhereCoerces that) {
        forWhereCoerces(that);
    }

    public void for_SyntaxTransformationWhereEquals(_SyntaxTransformationWhereEquals that) {
        forWhereEquals(that);
    }

    public void for_SyntaxTransformationUnitConstraint(_SyntaxTransformationUnitConstraint that) {
        forUnitConstraint(that);
    }

    public void for_SyntaxTransformationIntConstraint(_SyntaxTransformationIntConstraint that) {
        forIntConstraint(that);
    }

    public void for_SyntaxTransformationBoolConstraintExpr(_SyntaxTransformationBoolConstraintExpr that) {
        forBoolConstraintExpr(that);
    }

    public void for_SyntaxTransformationContract(_SyntaxTransformationContract that) {
        forContract(that);
    }

    public void for_SyntaxTransformationEnsuresClause(_SyntaxTransformationEnsuresClause that) {
        forEnsuresClause(that);
    }

    public void for_SyntaxTransformationStaticParam(_SyntaxTransformationStaticParam that) {
        forStaticParam(that);
    }

    public void for_SyntaxTransformationName(_SyntaxTransformationName that) {
        forName(that);
    }

    public void for_SyntaxTransformationAPIName(_SyntaxTransformationAPIName that) {
        forAPIName(that);
    }

    public void for_SyntaxTransformationIdOrOpOrAnonymousName(_SyntaxTransformationIdOrOpOrAnonymousName that) {
        forIdOrOpOrAnonymousName(that);
    }

    public void for_SyntaxTransformationIdOrOp(_SyntaxTransformationIdOrOp that) {
        forIdOrOp(that);
    }

    public void for_SyntaxTransformationId(_SyntaxTransformationId that) {
        forId(that);
    }

    public void for_SyntaxTransformationOp(_SyntaxTransformationOp that) {
        forOp(that);
    }

    public void for_SyntaxTransformationNamedOp(_SyntaxTransformationNamedOp that) {
        forNamedOp(that);
    }

    public void for_SyntaxTransformation_InferenceVarOp(_SyntaxTransformation_InferenceVarOp that) {
        for_InferenceVarOp(that);
    }

    public void for_SyntaxTransformationAnonymousName(_SyntaxTransformationAnonymousName that) {
        forAnonymousName(that);
    }

    public void for_SyntaxTransformationAnonymousFnName(_SyntaxTransformationAnonymousFnName that) {
        forAnonymousFnName(that);
    }

    public void for_SyntaxTransformationConstructorFnName(_SyntaxTransformationConstructorFnName that) {
        forConstructorFnName(that);
    }

    public void for_SyntaxTransformationArrayComprehensionClause(_SyntaxTransformationArrayComprehensionClause that) {
        forArrayComprehensionClause(that);
    }

    public void for_SyntaxTransformationKeywordExpr(_SyntaxTransformationKeywordExpr that) {
        forKeywordExpr(that);
    }

    public void for_SyntaxTransformationCaseClause(_SyntaxTransformationCaseClause that) {
        forCaseClause(that);
    }

    public void for_SyntaxTransformationCatch(_SyntaxTransformationCatch that) {
        forCatch(that);
    }

    public void for_SyntaxTransformationCatchClause(_SyntaxTransformationCatchClause that) {
        forCatchClause(that);
    }

    public void for_SyntaxTransformationIfClause(_SyntaxTransformationIfClause that) {
        forIfClause(that);
    }

    public void for_SyntaxTransformationTypecaseClause(_SyntaxTransformationTypecaseClause that) {
        forTypecaseClause(that);
    }

    public void for_SyntaxTransformationExtentRange(_SyntaxTransformationExtentRange that) {
        forExtentRange(that);
    }

    public void for_SyntaxTransformationGeneratorClause(_SyntaxTransformationGeneratorClause that) {
        forGeneratorClause(that);
    }

    public void for_SyntaxTransformationKeywordType(_SyntaxTransformationKeywordType that) {
        forKeywordType(that);
    }

    public void for_SyntaxTransformationTraitTypeWhere(_SyntaxTransformationTraitTypeWhere that) {
        forTraitTypeWhere(that);
    }

    public void for_SyntaxTransformationIndices(_SyntaxTransformationIndices that) {
        forIndices(that);
    }

    public void for_SyntaxTransformationMathItem(_SyntaxTransformationMathItem that) {
        forMathItem(that);
    }

    public void for_SyntaxTransformationExprMI(_SyntaxTransformationExprMI that) {
        forExprMI(that);
    }

    public void for_SyntaxTransformationParenthesisDelimitedMI(_SyntaxTransformationParenthesisDelimitedMI that) {
        forParenthesisDelimitedMI(that);
    }

    public void for_SyntaxTransformationNonParenthesisDelimitedMI(_SyntaxTransformationNonParenthesisDelimitedMI that) {
        forNonParenthesisDelimitedMI(that);
    }

    public void for_SyntaxTransformationNonExprMI(_SyntaxTransformationNonExprMI that) {
        forNonExprMI(that);
    }

    public void for_SyntaxTransformationExponentiationMI(_SyntaxTransformationExponentiationMI that) {
        forExponentiationMI(that);
    }

    public void for_SyntaxTransformationSubscriptingMI(_SyntaxTransformationSubscriptingMI that) {
        forSubscriptingMI(that);
    }

    public void for_SyntaxTransformationOverloading(_SyntaxTransformationOverloading that) {
        forOverloading(that);
    }

    public void for_SyntaxTransformationNonterminalHeader(_SyntaxTransformationNonterminalHeader that) {
        forNonterminalHeader(that);
    }

    public void for_SyntaxTransformationNonterminalParameter(_SyntaxTransformationNonterminalParameter that) {
        forNonterminalParameter(that);
    }

    public void for_SyntaxTransformationSyntaxDecl(_SyntaxTransformationSyntaxDecl that) {
        forSyntaxDecl(that);
    }

    public void for_SyntaxTransformationSyntaxDef(_SyntaxTransformationSyntaxDef that) {
        forSyntaxDef(that);
    }

    public void for_SyntaxTransformationSuperSyntaxDef(_SyntaxTransformationSuperSyntaxDef that) {
        forSuperSyntaxDef(that);
    }

    public void for_SyntaxTransformationTransformerDecl(_SyntaxTransformationTransformerDecl that) {
        forTransformerDecl(that);
    }

    public void for_SyntaxTransformationPreTransformerDef(_SyntaxTransformationPreTransformerDef that) {
        forPreTransformerDef(that);
    }

    public void for_SyntaxTransformationNamedTransformerDef(_SyntaxTransformationNamedTransformerDef that) {
        forNamedTransformerDef(that);
    }

    public void for_SyntaxTransformationTransformer(_SyntaxTransformationTransformer that) {
        forTransformer(that);
    }

    public void for_SyntaxTransformationUnparsedTransformer(_SyntaxTransformationUnparsedTransformer that) {
        forUnparsedTransformer(that);
    }

    public void for_SyntaxTransformationNodeTransformer(_SyntaxTransformationNodeTransformer that) {
        forNodeTransformer(that);
    }

    public void for_SyntaxTransformationCaseTransformer(_SyntaxTransformationCaseTransformer that) {
        forCaseTransformer(that);
    }

    public void for_SyntaxTransformationCaseTransformerClause(_SyntaxTransformationCaseTransformerClause that) {
        forCaseTransformerClause(that);
    }

    public void for_SyntaxTransformationSyntaxSymbol(_SyntaxTransformationSyntaxSymbol that) {
        forSyntaxSymbol(that);
    }

    public void for_SyntaxTransformationPrefixedSymbol(_SyntaxTransformationPrefixedSymbol that) {
        forPrefixedSymbol(that);
    }

    public void for_SyntaxTransformationOptionalSymbol(_SyntaxTransformationOptionalSymbol that) {
        forOptionalSymbol(that);
    }

    public void for_SyntaxTransformationRepeatSymbol(_SyntaxTransformationRepeatSymbol that) {
        forRepeatSymbol(that);
    }

    public void for_SyntaxTransformationRepeatOneOrMoreSymbol(_SyntaxTransformationRepeatOneOrMoreSymbol that) {
        forRepeatOneOrMoreSymbol(that);
    }

    public void for_SyntaxTransformationNoWhitespaceSymbol(_SyntaxTransformationNoWhitespaceSymbol that) {
        forNoWhitespaceSymbol(that);
    }

    public void for_SyntaxTransformationGroupSymbol(_SyntaxTransformationGroupSymbol that) {
        forGroupSymbol(that);
    }

    public void for_SyntaxTransformationSpecialSymbol(_SyntaxTransformationSpecialSymbol that) {
        forSpecialSymbol(that);
    }

    public void for_SyntaxTransformationAnyCharacterSymbol(_SyntaxTransformationAnyCharacterSymbol that) {
        forAnyCharacterSymbol(that);
    }

    public void for_SyntaxTransformationWhitespaceSymbol(_SyntaxTransformationWhitespaceSymbol that) {
        forWhitespaceSymbol(that);
    }

    public void for_SyntaxTransformationTabSymbol(_SyntaxTransformationTabSymbol that) {
        forTabSymbol(that);
    }

    public void for_SyntaxTransformationFormfeedSymbol(_SyntaxTransformationFormfeedSymbol that) {
        forFormfeedSymbol(that);
    }

    public void for_SyntaxTransformationCarriageReturnSymbol(_SyntaxTransformationCarriageReturnSymbol that) {
        forCarriageReturnSymbol(that);
    }

    public void for_SyntaxTransformationBackspaceSymbol(_SyntaxTransformationBackspaceSymbol that) {
        forBackspaceSymbol(that);
    }

    public void for_SyntaxTransformationNewlineSymbol(_SyntaxTransformationNewlineSymbol that) {
        forNewlineSymbol(that);
    }

    public void for_SyntaxTransformationBreaklineSymbol(_SyntaxTransformationBreaklineSymbol that) {
        forBreaklineSymbol(that);
    }

    public void for_SyntaxTransformationItemSymbol(_SyntaxTransformationItemSymbol that) {
        forItemSymbol(that);
    }

    public void for_SyntaxTransformationNonterminalSymbol(_SyntaxTransformationNonterminalSymbol that) {
        forNonterminalSymbol(that);
    }

    public void for_SyntaxTransformationKeywordSymbol(_SyntaxTransformationKeywordSymbol that) {
        forKeywordSymbol(that);
    }

    public void for_SyntaxTransformationTokenSymbol(_SyntaxTransformationTokenSymbol that) {
        forTokenSymbol(that);
    }

    public void for_SyntaxTransformationNotPredicateSymbol(_SyntaxTransformationNotPredicateSymbol that) {
        forNotPredicateSymbol(that);
    }

    public void for_SyntaxTransformationAndPredicateSymbol(_SyntaxTransformationAndPredicateSymbol that) {
        forAndPredicateSymbol(that);
    }

    public void for_SyntaxTransformationCharacterClassSymbol(_SyntaxTransformationCharacterClassSymbol that) {
        forCharacterClassSymbol(that);
    }

    public void for_SyntaxTransformationCharacterSymbol(_SyntaxTransformationCharacterSymbol that) {
        forCharacterSymbol(that);
    }

    public void for_SyntaxTransformationCharSymbol(_SyntaxTransformationCharSymbol that) {
        forCharSymbol(that);
    }

    public void for_SyntaxTransformationCharacterInterval(_SyntaxTransformationCharacterInterval that) {
        forCharacterInterval(that);
    }

    public void for_SyntaxTransformationLink(_SyntaxTransformationLink that) {
        forLink(that);
    }

    public void for_EllipsesAbstractNode(_EllipsesAbstractNode that) {
        forAbstractNode(that);
    }

    public void for_EllipsesCompilationUnit(_EllipsesCompilationUnit that) {
        forCompilationUnit(that);
    }

    public void for_EllipsesComponent(_EllipsesComponent that) {
        forComponent(that);
    }

    public void for_EllipsesApi(_EllipsesApi that) {
        forApi(that);
    }

    public void for_EllipsesImport(_EllipsesImport that) {
        forImport(that);
    }

    public void for_EllipsesImportedNames(_EllipsesImportedNames that) {
        forImportedNames(that);
    }

    public void for_EllipsesImportStar(_EllipsesImportStar that) {
        forImportStar(that);
    }

    public void for_EllipsesImportNames(_EllipsesImportNames that) {
        forImportNames(that);
    }

    public void for_EllipsesImportApi(_EllipsesImportApi that) {
        forImportApi(that);
    }

    public void for_EllipsesAliasedSimpleName(_EllipsesAliasedSimpleName that) {
        forAliasedSimpleName(that);
    }

    public void for_EllipsesAliasedAPIName(_EllipsesAliasedAPIName that) {
        forAliasedAPIName(that);
    }

    public void for_EllipsesDecl(_EllipsesDecl that) {
        forDecl(that);
    }

    public void for_EllipsesTraitObjectDecl(_EllipsesTraitObjectDecl that) {
        forTraitObjectDecl(that);
    }

    public void for_EllipsesTraitDecl(_EllipsesTraitDecl that) {
        forTraitDecl(that);
    }

    public void for_EllipsesObjectDecl(_EllipsesObjectDecl that) {
        forObjectDecl(that);
    }

    public void for_EllipsesVarDecl(_EllipsesVarDecl that) {
        forVarDecl(that);
    }

    public void for_EllipsesFnDecl(_EllipsesFnDecl that) {
        forFnDecl(that);
    }

    public void for_Ellipses_RewriteFnOverloadDecl(_Ellipses_RewriteFnOverloadDecl that) {
        for_RewriteFnOverloadDecl(that);
    }

    public void for_Ellipses_RewriteObjectExprDecl(_Ellipses_RewriteObjectExprDecl that) {
        for_RewriteObjectExprDecl(that);
    }

    public void for_Ellipses_RewriteFunctionalMethodDecl(_Ellipses_RewriteFunctionalMethodDecl that) {
        for_RewriteFunctionalMethodDecl(that);
    }

    public void for_EllipsesDimUnitDecl(_EllipsesDimUnitDecl that) {
        forDimUnitDecl(that);
    }

    public void for_EllipsesDimDecl(_EllipsesDimDecl that) {
        forDimDecl(that);
    }

    public void for_EllipsesUnitDecl(_EllipsesUnitDecl that) {
        forUnitDecl(that);
    }

    public void for_EllipsesTestDecl(_EllipsesTestDecl that) {
        forTestDecl(that);
    }

    public void for_EllipsesPropertyDecl(_EllipsesPropertyDecl that) {
        forPropertyDecl(that);
    }

    public void for_EllipsesTypeAlias(_EllipsesTypeAlias that) {
        forTypeAlias(that);
    }

    public void for_EllipsesGrammarDecl(_EllipsesGrammarDecl that) {
        forGrammarDecl(that);
    }

    public void for_EllipsesGrammarMemberDecl(_EllipsesGrammarMemberDecl that) {
        forGrammarMemberDecl(that);
    }

    public void for_EllipsesNonterminalDecl(_EllipsesNonterminalDecl that) {
        forNonterminalDecl(that);
    }

    public void for_EllipsesNonterminalDef(_EllipsesNonterminalDef that) {
        forNonterminalDef(that);
    }

    public void for_EllipsesNonterminalExtensionDef(_EllipsesNonterminalExtensionDef that) {
        forNonterminalExtensionDef(that);
    }

    public void for_EllipsesBinding(_EllipsesBinding that) {
        forBinding(that);
    }

    public void for_EllipsesLValue(_EllipsesLValue that) {
        forLValue(that);
    }

    public void for_EllipsesParam(_EllipsesParam that) {
        forParam(that);
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

    public void for_EllipsesType(_EllipsesType that) {
        forType(that);
    }

    public void for_EllipsesBaseType(_EllipsesBaseType that) {
        forBaseType(that);
    }

    public void for_EllipsesAnyType(_EllipsesAnyType that) {
        forAnyType(that);
    }

    public void for_EllipsesBottomType(_EllipsesBottomType that) {
        forBottomType(that);
    }

    public void for_EllipsesUnknownType(_EllipsesUnknownType that) {
        forUnknownType(that);
    }

    public void for_EllipsesSelfType(_EllipsesSelfType that) {
        forSelfType(that);
    }

    public void for_EllipsesTraitSelfType(_EllipsesTraitSelfType that) {
        forTraitSelfType(that);
    }

    public void for_EllipsesObjectExprType(_EllipsesObjectExprType that) {
        forObjectExprType(that);
    }

    public void for_EllipsesNamedType(_EllipsesNamedType that) {
        forNamedType(that);
    }

    public void for_Ellipses_InferenceVarType(_Ellipses_InferenceVarType that) {
        for_InferenceVarType(that);
    }

    public void for_EllipsesVarType(_EllipsesVarType that) {
        forVarType(that);
    }

    public void for_EllipsesTraitType(_EllipsesTraitType that) {
        forTraitType(that);
    }

    public void for_EllipsesAbbreviatedType(_EllipsesAbbreviatedType that) {
        forAbbreviatedType(that);
    }

    public void for_EllipsesArrayType(_EllipsesArrayType that) {
        forArrayType(that);
    }

    public void for_EllipsesMatrixType(_EllipsesMatrixType that) {
        forMatrixType(that);
    }

    public void for_EllipsesTaggedDimType(_EllipsesTaggedDimType that) {
        forTaggedDimType(that);
    }

    public void for_EllipsesTaggedUnitType(_EllipsesTaggedUnitType that) {
        forTaggedUnitType(that);
    }

    public void for_EllipsesTupleType(_EllipsesTupleType that) {
        forTupleType(that);
    }

    public void for_EllipsesArrowType(_EllipsesArrowType that) {
        forArrowType(that);
    }

    public void for_EllipsesBoundType(_EllipsesBoundType that) {
        forBoundType(that);
    }

    public void for_EllipsesIntersectionType(_EllipsesIntersectionType that) {
        forIntersectionType(that);
    }

    public void for_EllipsesUnionType(_EllipsesUnionType that) {
        forUnionType(that);
    }

    public void for_EllipsesFixedPointType(_EllipsesFixedPointType that) {
        forFixedPointType(that);
    }

    public void for_EllipsesLabelType(_EllipsesLabelType that) {
        forLabelType(that);
    }

    public void for_EllipsesDimExpr(_EllipsesDimExpr that) {
        forDimExpr(that);
    }

    public void for_EllipsesDimBase(_EllipsesDimBase that) {
        forDimBase(that);
    }

    public void for_EllipsesDimRef(_EllipsesDimRef that) {
        forDimRef(that);
    }

    public void for_EllipsesDimExponent(_EllipsesDimExponent that) {
        forDimExponent(that);
    }

    public void for_EllipsesDimUnaryOp(_EllipsesDimUnaryOp that) {
        forDimUnaryOp(that);
    }

    public void for_EllipsesDimBinaryOp(_EllipsesDimBinaryOp that) {
        forDimBinaryOp(that);
    }

    public void for_EllipsesPattern(_EllipsesPattern that) {
        forPattern(that);
    }

    public void for_EllipsesPatternArgs(_EllipsesPatternArgs that) {
        forPatternArgs(that);
    }

    public void for_EllipsesPatternBinding(_EllipsesPatternBinding that) {
        forPatternBinding(that);
    }

    public void for_EllipsesPlainPattern(_EllipsesPlainPattern that) {
        forPlainPattern(that);
    }

    public void for_EllipsesTypePattern(_EllipsesTypePattern that) {
        forTypePattern(that);
    }

    public void for_EllipsesNestedPattern(_EllipsesNestedPattern that) {
        forNestedPattern(that);
    }

    public void for_EllipsesStaticArg(_EllipsesStaticArg that) {
        forStaticArg(that);
    }

    public void for_EllipsesTypeArg(_EllipsesTypeArg that) {
        forTypeArg(that);
    }

    public void for_EllipsesIntArg(_EllipsesIntArg that) {
        forIntArg(that);
    }

    public void for_EllipsesBoolArg(_EllipsesBoolArg that) {
        forBoolArg(that);
    }

    public void for_EllipsesOpArg(_EllipsesOpArg that) {
        forOpArg(that);
    }

    public void for_EllipsesDimArg(_EllipsesDimArg that) {
        forDimArg(that);
    }

    public void for_EllipsesUnitArg(_EllipsesUnitArg that) {
        forUnitArg(that);
    }

    public void for_EllipsesStaticExpr(_EllipsesStaticExpr that) {
        forStaticExpr(that);
    }

    public void for_EllipsesIntExpr(_EllipsesIntExpr that) {
        forIntExpr(that);
    }

    public void for_EllipsesIntBase(_EllipsesIntBase that) {
        forIntBase(that);
    }

    public void for_EllipsesIntRef(_EllipsesIntRef that) {
        forIntRef(that);
    }

    public void for_EllipsesIntBinaryOp(_EllipsesIntBinaryOp that) {
        forIntBinaryOp(that);
    }

    public void for_EllipsesBoolExpr(_EllipsesBoolExpr that) {
        forBoolExpr(that);
    }

    public void for_EllipsesBoolBase(_EllipsesBoolBase that) {
        forBoolBase(that);
    }

    public void for_EllipsesBoolRef(_EllipsesBoolRef that) {
        forBoolRef(that);
    }

    public void for_EllipsesBoolConstraint(_EllipsesBoolConstraint that) {
        forBoolConstraint(that);
    }

    public void for_EllipsesBoolUnaryOp(_EllipsesBoolUnaryOp that) {
        forBoolUnaryOp(that);
    }

    public void for_EllipsesBoolBinaryOp(_EllipsesBoolBinaryOp that) {
        forBoolBinaryOp(that);
    }

    public void for_EllipsesUnitExpr(_EllipsesUnitExpr that) {
        forUnitExpr(that);
    }

    public void for_EllipsesUnitRef(_EllipsesUnitRef that) {
        forUnitRef(that);
    }

    public void for_EllipsesUnitBinaryOp(_EllipsesUnitBinaryOp that) {
        forUnitBinaryOp(that);
    }

    public void for_EllipsesEffect(_EllipsesEffect that) {
        forEffect(that);
    }

    public void for_EllipsesWhereClause(_EllipsesWhereClause that) {
        forWhereClause(that);
    }

    public void for_EllipsesWhereBinding(_EllipsesWhereBinding that) {
        forWhereBinding(that);
    }

    public void for_EllipsesWhereConstraint(_EllipsesWhereConstraint that) {
        forWhereConstraint(that);
    }

    public void for_EllipsesWhereExtends(_EllipsesWhereExtends that) {
        forWhereExtends(that);
    }

    public void for_EllipsesWhereTypeAlias(_EllipsesWhereTypeAlias that) {
        forWhereTypeAlias(that);
    }

    public void for_EllipsesWhereCoerces(_EllipsesWhereCoerces that) {
        forWhereCoerces(that);
    }

    public void for_EllipsesWhereEquals(_EllipsesWhereEquals that) {
        forWhereEquals(that);
    }

    public void for_EllipsesUnitConstraint(_EllipsesUnitConstraint that) {
        forUnitConstraint(that);
    }

    public void for_EllipsesIntConstraint(_EllipsesIntConstraint that) {
        forIntConstraint(that);
    }

    public void for_EllipsesBoolConstraintExpr(_EllipsesBoolConstraintExpr that) {
        forBoolConstraintExpr(that);
    }

    public void for_EllipsesContract(_EllipsesContract that) {
        forContract(that);
    }

    public void for_EllipsesEnsuresClause(_EllipsesEnsuresClause that) {
        forEnsuresClause(that);
    }

    public void for_EllipsesStaticParam(_EllipsesStaticParam that) {
        forStaticParam(that);
    }

    public void for_EllipsesName(_EllipsesName that) {
        forName(that);
    }

    public void for_EllipsesAPIName(_EllipsesAPIName that) {
        forAPIName(that);
    }

    public void for_EllipsesIdOrOpOrAnonymousName(_EllipsesIdOrOpOrAnonymousName that) {
        forIdOrOpOrAnonymousName(that);
    }

    public void for_EllipsesIdOrOp(_EllipsesIdOrOp that) {
        forIdOrOp(that);
    }

    public void for_EllipsesId(_EllipsesId that) {
        forId(that);
    }

    public void for_EllipsesOp(_EllipsesOp that) {
        forOp(that);
    }

    public void for_EllipsesNamedOp(_EllipsesNamedOp that) {
        forNamedOp(that);
    }

    public void for_Ellipses_InferenceVarOp(_Ellipses_InferenceVarOp that) {
        for_InferenceVarOp(that);
    }

    public void for_EllipsesAnonymousName(_EllipsesAnonymousName that) {
        forAnonymousName(that);
    }

    public void for_EllipsesAnonymousFnName(_EllipsesAnonymousFnName that) {
        forAnonymousFnName(that);
    }

    public void for_EllipsesConstructorFnName(_EllipsesConstructorFnName that) {
        forConstructorFnName(that);
    }

    public void for_EllipsesArrayComprehensionClause(_EllipsesArrayComprehensionClause that) {
        forArrayComprehensionClause(that);
    }

    public void for_EllipsesKeywordExpr(_EllipsesKeywordExpr that) {
        forKeywordExpr(that);
    }

    public void for_EllipsesCaseClause(_EllipsesCaseClause that) {
        forCaseClause(that);
    }

    public void for_EllipsesCatch(_EllipsesCatch that) {
        forCatch(that);
    }

    public void for_EllipsesCatchClause(_EllipsesCatchClause that) {
        forCatchClause(that);
    }

    public void for_EllipsesIfClause(_EllipsesIfClause that) {
        forIfClause(that);
    }

    public void for_EllipsesTypecaseClause(_EllipsesTypecaseClause that) {
        forTypecaseClause(that);
    }

    public void for_EllipsesExtentRange(_EllipsesExtentRange that) {
        forExtentRange(that);
    }

    public void for_EllipsesGeneratorClause(_EllipsesGeneratorClause that) {
        forGeneratorClause(that);
    }

    public void for_EllipsesKeywordType(_EllipsesKeywordType that) {
        forKeywordType(that);
    }

    public void for_EllipsesTraitTypeWhere(_EllipsesTraitTypeWhere that) {
        forTraitTypeWhere(that);
    }

    public void for_EllipsesIndices(_EllipsesIndices that) {
        forIndices(that);
    }

    public void for_EllipsesMathItem(_EllipsesMathItem that) {
        forMathItem(that);
    }

    public void for_EllipsesExprMI(_EllipsesExprMI that) {
        forExprMI(that);
    }

    public void for_EllipsesParenthesisDelimitedMI(_EllipsesParenthesisDelimitedMI that) {
        forParenthesisDelimitedMI(that);
    }

    public void for_EllipsesNonParenthesisDelimitedMI(_EllipsesNonParenthesisDelimitedMI that) {
        forNonParenthesisDelimitedMI(that);
    }

    public void for_EllipsesNonExprMI(_EllipsesNonExprMI that) {
        forNonExprMI(that);
    }

    public void for_EllipsesExponentiationMI(_EllipsesExponentiationMI that) {
        forExponentiationMI(that);
    }

    public void for_EllipsesSubscriptingMI(_EllipsesSubscriptingMI that) {
        forSubscriptingMI(that);
    }

    public void for_EllipsesOverloading(_EllipsesOverloading that) {
        forOverloading(that);
    }

    public void for_EllipsesNonterminalHeader(_EllipsesNonterminalHeader that) {
        forNonterminalHeader(that);
    }

    public void for_EllipsesNonterminalParameter(_EllipsesNonterminalParameter that) {
        forNonterminalParameter(that);
    }

    public void for_EllipsesSyntaxDecl(_EllipsesSyntaxDecl that) {
        forSyntaxDecl(that);
    }

    public void for_EllipsesSyntaxDef(_EllipsesSyntaxDef that) {
        forSyntaxDef(that);
    }

    public void for_EllipsesSuperSyntaxDef(_EllipsesSuperSyntaxDef that) {
        forSuperSyntaxDef(that);
    }

    public void for_EllipsesTransformerDecl(_EllipsesTransformerDecl that) {
        forTransformerDecl(that);
    }

    public void for_EllipsesPreTransformerDef(_EllipsesPreTransformerDef that) {
        forPreTransformerDef(that);
    }

    public void for_EllipsesNamedTransformerDef(_EllipsesNamedTransformerDef that) {
        forNamedTransformerDef(that);
    }

    public void for_EllipsesTransformer(_EllipsesTransformer that) {
        forTransformer(that);
    }

    public void for_EllipsesUnparsedTransformer(_EllipsesUnparsedTransformer that) {
        forUnparsedTransformer(that);
    }

    public void for_EllipsesNodeTransformer(_EllipsesNodeTransformer that) {
        forNodeTransformer(that);
    }

    public void for_EllipsesCaseTransformer(_EllipsesCaseTransformer that) {
        forCaseTransformer(that);
    }

    public void for_EllipsesCaseTransformerClause(_EllipsesCaseTransformerClause that) {
        forCaseTransformerClause(that);
    }

    public void for_EllipsesSyntaxSymbol(_EllipsesSyntaxSymbol that) {
        forSyntaxSymbol(that);
    }

    public void for_EllipsesPrefixedSymbol(_EllipsesPrefixedSymbol that) {
        forPrefixedSymbol(that);
    }

    public void for_EllipsesOptionalSymbol(_EllipsesOptionalSymbol that) {
        forOptionalSymbol(that);
    }

    public void for_EllipsesRepeatSymbol(_EllipsesRepeatSymbol that) {
        forRepeatSymbol(that);
    }

    public void for_EllipsesRepeatOneOrMoreSymbol(_EllipsesRepeatOneOrMoreSymbol that) {
        forRepeatOneOrMoreSymbol(that);
    }

    public void for_EllipsesNoWhitespaceSymbol(_EllipsesNoWhitespaceSymbol that) {
        forNoWhitespaceSymbol(that);
    }

    public void for_EllipsesGroupSymbol(_EllipsesGroupSymbol that) {
        forGroupSymbol(that);
    }

    public void for_EllipsesSpecialSymbol(_EllipsesSpecialSymbol that) {
        forSpecialSymbol(that);
    }

    public void for_EllipsesAnyCharacterSymbol(_EllipsesAnyCharacterSymbol that) {
        forAnyCharacterSymbol(that);
    }

    public void for_EllipsesWhitespaceSymbol(_EllipsesWhitespaceSymbol that) {
        forWhitespaceSymbol(that);
    }

    public void for_EllipsesTabSymbol(_EllipsesTabSymbol that) {
        forTabSymbol(that);
    }

    public void for_EllipsesFormfeedSymbol(_EllipsesFormfeedSymbol that) {
        forFormfeedSymbol(that);
    }

    public void for_EllipsesCarriageReturnSymbol(_EllipsesCarriageReturnSymbol that) {
        forCarriageReturnSymbol(that);
    }

    public void for_EllipsesBackspaceSymbol(_EllipsesBackspaceSymbol that) {
        forBackspaceSymbol(that);
    }

    public void for_EllipsesNewlineSymbol(_EllipsesNewlineSymbol that) {
        forNewlineSymbol(that);
    }

    public void for_EllipsesBreaklineSymbol(_EllipsesBreaklineSymbol that) {
        forBreaklineSymbol(that);
    }

    public void for_EllipsesItemSymbol(_EllipsesItemSymbol that) {
        forItemSymbol(that);
    }

    public void for_EllipsesNonterminalSymbol(_EllipsesNonterminalSymbol that) {
        forNonterminalSymbol(that);
    }

    public void for_EllipsesKeywordSymbol(_EllipsesKeywordSymbol that) {
        forKeywordSymbol(that);
    }

    public void for_EllipsesTokenSymbol(_EllipsesTokenSymbol that) {
        forTokenSymbol(that);
    }

    public void for_EllipsesNotPredicateSymbol(_EllipsesNotPredicateSymbol that) {
        forNotPredicateSymbol(that);
    }

    public void for_EllipsesAndPredicateSymbol(_EllipsesAndPredicateSymbol that) {
        forAndPredicateSymbol(that);
    }

    public void for_EllipsesCharacterClassSymbol(_EllipsesCharacterClassSymbol that) {
        forCharacterClassSymbol(that);
    }

    public void for_EllipsesCharacterSymbol(_EllipsesCharacterSymbol that) {
        forCharacterSymbol(that);
    }

    public void for_EllipsesCharSymbol(_EllipsesCharSymbol that) {
        forCharSymbol(that);
    }

    public void for_EllipsesCharacterInterval(_EllipsesCharacterInterval that) {
        forCharacterInterval(that);
    }

    public void for_EllipsesLink(_EllipsesLink that) {
        forLink(that);
    }

    public void forTemplateGapAbstractNode(TemplateGapAbstractNode that) {
        forAbstractNode(that);
    }

    public void forTemplateGapCompilationUnit(TemplateGapCompilationUnit that) {
        forCompilationUnit(that);
    }

    public void forTemplateGapComponent(TemplateGapComponent that) {
        forComponent(that);
    }

    public void forTemplateGapApi(TemplateGapApi that) {
        forApi(that);
    }

    public void forTemplateGapImport(TemplateGapImport that) {
        forImport(that);
    }

    public void forTemplateGapImportedNames(TemplateGapImportedNames that) {
        forImportedNames(that);
    }

    public void forTemplateGapImportStar(TemplateGapImportStar that) {
        forImportStar(that);
    }

    public void forTemplateGapImportNames(TemplateGapImportNames that) {
        forImportNames(that);
    }

    public void forTemplateGapImportApi(TemplateGapImportApi that) {
        forImportApi(that);
    }

    public void forTemplateGapAliasedSimpleName(TemplateGapAliasedSimpleName that) {
        forAliasedSimpleName(that);
    }

    public void forTemplateGapAliasedAPIName(TemplateGapAliasedAPIName that) {
        forAliasedAPIName(that);
    }

    public void forTemplateGapDecl(TemplateGapDecl that) {
        forDecl(that);
    }

    public void forTemplateGapTraitObjectDecl(TemplateGapTraitObjectDecl that) {
        forTraitObjectDecl(that);
    }

    public void forTemplateGapTraitDecl(TemplateGapTraitDecl that) {
        forTraitDecl(that);
    }

    public void forTemplateGapObjectDecl(TemplateGapObjectDecl that) {
        forObjectDecl(that);
    }

    public void forTemplateGapVarDecl(TemplateGapVarDecl that) {
        forVarDecl(that);
    }

    public void forTemplateGapFnDecl(TemplateGapFnDecl that) {
        forFnDecl(that);
    }

    public void forTemplateGap_RewriteFnOverloadDecl(TemplateGap_RewriteFnOverloadDecl that) {
        for_RewriteFnOverloadDecl(that);
    }

    public void forTemplateGap_RewriteObjectExprDecl(TemplateGap_RewriteObjectExprDecl that) {
        for_RewriteObjectExprDecl(that);
    }

    public void forTemplateGap_RewriteFunctionalMethodDecl(TemplateGap_RewriteFunctionalMethodDecl that) {
        for_RewriteFunctionalMethodDecl(that);
    }

    public void forTemplateGapDimUnitDecl(TemplateGapDimUnitDecl that) {
        forDimUnitDecl(that);
    }

    public void forTemplateGapDimDecl(TemplateGapDimDecl that) {
        forDimDecl(that);
    }

    public void forTemplateGapUnitDecl(TemplateGapUnitDecl that) {
        forUnitDecl(that);
    }

    public void forTemplateGapTestDecl(TemplateGapTestDecl that) {
        forTestDecl(that);
    }

    public void forTemplateGapPropertyDecl(TemplateGapPropertyDecl that) {
        forPropertyDecl(that);
    }

    public void forTemplateGapTypeAlias(TemplateGapTypeAlias that) {
        forTypeAlias(that);
    }

    public void forTemplateGapGrammarDecl(TemplateGapGrammarDecl that) {
        forGrammarDecl(that);
    }

    public void forTemplateGapGrammarMemberDecl(TemplateGapGrammarMemberDecl that) {
        forGrammarMemberDecl(that);
    }

    public void forTemplateGapNonterminalDecl(TemplateGapNonterminalDecl that) {
        forNonterminalDecl(that);
    }

    public void forTemplateGapNonterminalDef(TemplateGapNonterminalDef that) {
        forNonterminalDef(that);
    }

    public void forTemplateGapNonterminalExtensionDef(TemplateGapNonterminalExtensionDef that) {
        forNonterminalExtensionDef(that);
    }

    public void forTemplateGapBinding(TemplateGapBinding that) {
        forBinding(that);
    }

    public void forTemplateGapLValue(TemplateGapLValue that) {
        forLValue(that);
    }

    public void forTemplateGapParam(TemplateGapParam that) {
        forParam(that);
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

    public void forTemplateGapType(TemplateGapType that) {
        forType(that);
    }

    public void forTemplateGapBaseType(TemplateGapBaseType that) {
        forBaseType(that);
    }

    public void forTemplateGapAnyType(TemplateGapAnyType that) {
        forAnyType(that);
    }

    public void forTemplateGapBottomType(TemplateGapBottomType that) {
        forBottomType(that);
    }

    public void forTemplateGapUnknownType(TemplateGapUnknownType that) {
        forUnknownType(that);
    }

    public void forTemplateGapSelfType(TemplateGapSelfType that) {
        forSelfType(that);
    }

    public void forTemplateGapTraitSelfType(TemplateGapTraitSelfType that) {
        forTraitSelfType(that);
    }

    public void forTemplateGapObjectExprType(TemplateGapObjectExprType that) {
        forObjectExprType(that);
    }

    public void forTemplateGapNamedType(TemplateGapNamedType that) {
        forNamedType(that);
    }

    public void forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that) {
        for_InferenceVarType(that);
    }

    public void forTemplateGapVarType(TemplateGapVarType that) {
        forVarType(that);
    }

    public void forTemplateGapTraitType(TemplateGapTraitType that) {
        forTraitType(that);
    }

    public void forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that) {
        forAbbreviatedType(that);
    }

    public void forTemplateGapArrayType(TemplateGapArrayType that) {
        forArrayType(that);
    }

    public void forTemplateGapMatrixType(TemplateGapMatrixType that) {
        forMatrixType(that);
    }

    public void forTemplateGapTaggedDimType(TemplateGapTaggedDimType that) {
        forTaggedDimType(that);
    }

    public void forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that) {
        forTaggedUnitType(that);
    }

    public void forTemplateGapTupleType(TemplateGapTupleType that) {
        forTupleType(that);
    }

    public void forTemplateGapArrowType(TemplateGapArrowType that) {
        forArrowType(that);
    }

    public void forTemplateGapBoundType(TemplateGapBoundType that) {
        forBoundType(that);
    }

    public void forTemplateGapIntersectionType(TemplateGapIntersectionType that) {
        forIntersectionType(that);
    }

    public void forTemplateGapUnionType(TemplateGapUnionType that) {
        forUnionType(that);
    }

    public void forTemplateGapFixedPointType(TemplateGapFixedPointType that) {
        forFixedPointType(that);
    }

    public void forTemplateGapLabelType(TemplateGapLabelType that) {
        forLabelType(that);
    }

    public void forTemplateGapDimExpr(TemplateGapDimExpr that) {
        forDimExpr(that);
    }

    public void forTemplateGapDimBase(TemplateGapDimBase that) {
        forDimBase(that);
    }

    public void forTemplateGapDimRef(TemplateGapDimRef that) {
        forDimRef(that);
    }

    public void forTemplateGapDimExponent(TemplateGapDimExponent that) {
        forDimExponent(that);
    }

    public void forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that) {
        forDimUnaryOp(that);
    }

    public void forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that) {
        forDimBinaryOp(that);
    }

    public void forTemplateGapPattern(TemplateGapPattern that) {
        forPattern(that);
    }

    public void forTemplateGapPatternArgs(TemplateGapPatternArgs that) {
        forPatternArgs(that);
    }

    public void forTemplateGapPatternBinding(TemplateGapPatternBinding that) {
        forPatternBinding(that);
    }

    public void forTemplateGapPlainPattern(TemplateGapPlainPattern that) {
        forPlainPattern(that);
    }

    public void forTemplateGapTypePattern(TemplateGapTypePattern that) {
        forTypePattern(that);
    }

    public void forTemplateGapNestedPattern(TemplateGapNestedPattern that) {
        forNestedPattern(that);
    }

    public void forTemplateGapStaticArg(TemplateGapStaticArg that) {
        forStaticArg(that);
    }

    public void forTemplateGapTypeArg(TemplateGapTypeArg that) {
        forTypeArg(that);
    }

    public void forTemplateGapIntArg(TemplateGapIntArg that) {
        forIntArg(that);
    }

    public void forTemplateGapBoolArg(TemplateGapBoolArg that) {
        forBoolArg(that);
    }

    public void forTemplateGapOpArg(TemplateGapOpArg that) {
        forOpArg(that);
    }

    public void forTemplateGapDimArg(TemplateGapDimArg that) {
        forDimArg(that);
    }

    public void forTemplateGapUnitArg(TemplateGapUnitArg that) {
        forUnitArg(that);
    }

    public void forTemplateGapStaticExpr(TemplateGapStaticExpr that) {
        forStaticExpr(that);
    }

    public void forTemplateGapIntExpr(TemplateGapIntExpr that) {
        forIntExpr(that);
    }

    public void forTemplateGapIntBase(TemplateGapIntBase that) {
        forIntBase(that);
    }

    public void forTemplateGapIntRef(TemplateGapIntRef that) {
        forIntRef(that);
    }

    public void forTemplateGapIntBinaryOp(TemplateGapIntBinaryOp that) {
        forIntBinaryOp(that);
    }

    public void forTemplateGapBoolExpr(TemplateGapBoolExpr that) {
        forBoolExpr(that);
    }

    public void forTemplateGapBoolBase(TemplateGapBoolBase that) {
        forBoolBase(that);
    }

    public void forTemplateGapBoolRef(TemplateGapBoolRef that) {
        forBoolRef(that);
    }

    public void forTemplateGapBoolConstraint(TemplateGapBoolConstraint that) {
        forBoolConstraint(that);
    }

    public void forTemplateGapBoolUnaryOp(TemplateGapBoolUnaryOp that) {
        forBoolUnaryOp(that);
    }

    public void forTemplateGapBoolBinaryOp(TemplateGapBoolBinaryOp that) {
        forBoolBinaryOp(that);
    }

    public void forTemplateGapUnitExpr(TemplateGapUnitExpr that) {
        forUnitExpr(that);
    }

    public void forTemplateGapUnitRef(TemplateGapUnitRef that) {
        forUnitRef(that);
    }

    public void forTemplateGapUnitBinaryOp(TemplateGapUnitBinaryOp that) {
        forUnitBinaryOp(that);
    }

    public void forTemplateGapEffect(TemplateGapEffect that) {
        forEffect(that);
    }

    public void forTemplateGapWhereClause(TemplateGapWhereClause that) {
        forWhereClause(that);
    }

    public void forTemplateGapWhereBinding(TemplateGapWhereBinding that) {
        forWhereBinding(that);
    }

    public void forTemplateGapWhereConstraint(TemplateGapWhereConstraint that) {
        forWhereConstraint(that);
    }

    public void forTemplateGapWhereExtends(TemplateGapWhereExtends that) {
        forWhereExtends(that);
    }

    public void forTemplateGapWhereTypeAlias(TemplateGapWhereTypeAlias that) {
        forWhereTypeAlias(that);
    }

    public void forTemplateGapWhereCoerces(TemplateGapWhereCoerces that) {
        forWhereCoerces(that);
    }

    public void forTemplateGapWhereEquals(TemplateGapWhereEquals that) {
        forWhereEquals(that);
    }

    public void forTemplateGapUnitConstraint(TemplateGapUnitConstraint that) {
        forUnitConstraint(that);
    }

    public void forTemplateGapIntConstraint(TemplateGapIntConstraint that) {
        forIntConstraint(that);
    }

    public void forTemplateGapBoolConstraintExpr(TemplateGapBoolConstraintExpr that) {
        forBoolConstraintExpr(that);
    }

    public void forTemplateGapContract(TemplateGapContract that) {
        forContract(that);
    }

    public void forTemplateGapEnsuresClause(TemplateGapEnsuresClause that) {
        forEnsuresClause(that);
    }

    public void forTemplateGapStaticParam(TemplateGapStaticParam that) {
        forStaticParam(that);
    }

    public void forTemplateGapName(TemplateGapName that) {
        forName(that);
    }

    public void forTemplateGapAPIName(TemplateGapAPIName that) {
        forAPIName(that);
    }

    public void forTemplateGapIdOrOpOrAnonymousName(TemplateGapIdOrOpOrAnonymousName that) {
        forIdOrOpOrAnonymousName(that);
    }

    public void forTemplateGapIdOrOp(TemplateGapIdOrOp that) {
        forIdOrOp(that);
    }

    public void forTemplateGapId(TemplateGapId that) {
        forId(that);
    }

    public void forTemplateGapOp(TemplateGapOp that) {
        forOp(that);
    }

    public void forTemplateGapNamedOp(TemplateGapNamedOp that) {
        forNamedOp(that);
    }

    public void forTemplateGap_InferenceVarOp(TemplateGap_InferenceVarOp that) {
        for_InferenceVarOp(that);
    }

    public void forTemplateGapAnonymousName(TemplateGapAnonymousName that) {
        forAnonymousName(that);
    }

    public void forTemplateGapAnonymousFnName(TemplateGapAnonymousFnName that) {
        forAnonymousFnName(that);
    }

    public void forTemplateGapConstructorFnName(TemplateGapConstructorFnName that) {
        forConstructorFnName(that);
    }

    public void forTemplateGapArrayComprehensionClause(TemplateGapArrayComprehensionClause that) {
        forArrayComprehensionClause(that);
    }

    public void forTemplateGapKeywordExpr(TemplateGapKeywordExpr that) {
        forKeywordExpr(that);
    }

    public void forTemplateGapCaseClause(TemplateGapCaseClause that) {
        forCaseClause(that);
    }

    public void forTemplateGapCatch(TemplateGapCatch that) {
        forCatch(that);
    }

    public void forTemplateGapCatchClause(TemplateGapCatchClause that) {
        forCatchClause(that);
    }

    public void forTemplateGapIfClause(TemplateGapIfClause that) {
        forIfClause(that);
    }

    public void forTemplateGapTypecaseClause(TemplateGapTypecaseClause that) {
        forTypecaseClause(that);
    }

    public void forTemplateGapExtentRange(TemplateGapExtentRange that) {
        forExtentRange(that);
    }

    public void forTemplateGapGeneratorClause(TemplateGapGeneratorClause that) {
        forGeneratorClause(that);
    }

    public void forTemplateGapKeywordType(TemplateGapKeywordType that) {
        forKeywordType(that);
    }

    public void forTemplateGapTraitTypeWhere(TemplateGapTraitTypeWhere that) {
        forTraitTypeWhere(that);
    }

    public void forTemplateGapIndices(TemplateGapIndices that) {
        forIndices(that);
    }

    public void forTemplateGapMathItem(TemplateGapMathItem that) {
        forMathItem(that);
    }

    public void forTemplateGapExprMI(TemplateGapExprMI that) {
        forExprMI(that);
    }

    public void forTemplateGapParenthesisDelimitedMI(TemplateGapParenthesisDelimitedMI that) {
        forParenthesisDelimitedMI(that);
    }

    public void forTemplateGapNonParenthesisDelimitedMI(TemplateGapNonParenthesisDelimitedMI that) {
        forNonParenthesisDelimitedMI(that);
    }

    public void forTemplateGapNonExprMI(TemplateGapNonExprMI that) {
        forNonExprMI(that);
    }

    public void forTemplateGapExponentiationMI(TemplateGapExponentiationMI that) {
        forExponentiationMI(that);
    }

    public void forTemplateGapSubscriptingMI(TemplateGapSubscriptingMI that) {
        forSubscriptingMI(that);
    }

    public void forTemplateGapOverloading(TemplateGapOverloading that) {
        forOverloading(that);
    }

    public void forTemplateGapNonterminalHeader(TemplateGapNonterminalHeader that) {
        forNonterminalHeader(that);
    }

    public void forTemplateGapNonterminalParameter(TemplateGapNonterminalParameter that) {
        forNonterminalParameter(that);
    }

    public void forTemplateGapSyntaxDecl(TemplateGapSyntaxDecl that) {
        forSyntaxDecl(that);
    }

    public void forTemplateGapSyntaxDef(TemplateGapSyntaxDef that) {
        forSyntaxDef(that);
    }

    public void forTemplateGapSuperSyntaxDef(TemplateGapSuperSyntaxDef that) {
        forSuperSyntaxDef(that);
    }

    public void forTemplateGapTransformerDecl(TemplateGapTransformerDecl that) {
        forTransformerDecl(that);
    }

    public void forTemplateGapPreTransformerDef(TemplateGapPreTransformerDef that) {
        forPreTransformerDef(that);
    }

    public void forTemplateGapNamedTransformerDef(TemplateGapNamedTransformerDef that) {
        forNamedTransformerDef(that);
    }

    public void forTemplateGapTransformer(TemplateGapTransformer that) {
        forTransformer(that);
    }

    public void forTemplateGapUnparsedTransformer(TemplateGapUnparsedTransformer that) {
        forUnparsedTransformer(that);
    }

    public void forTemplateGapNodeTransformer(TemplateGapNodeTransformer that) {
        forNodeTransformer(that);
    }

    public void forTemplateGapCaseTransformer(TemplateGapCaseTransformer that) {
        forCaseTransformer(that);
    }

    public void forTemplateGapCaseTransformerClause(TemplateGapCaseTransformerClause that) {
        forCaseTransformerClause(that);
    }

    public void forTemplateGapSyntaxSymbol(TemplateGapSyntaxSymbol that) {
        forSyntaxSymbol(that);
    }

    public void forTemplateGapPrefixedSymbol(TemplateGapPrefixedSymbol that) {
        forPrefixedSymbol(that);
    }

    public void forTemplateGapOptionalSymbol(TemplateGapOptionalSymbol that) {
        forOptionalSymbol(that);
    }

    public void forTemplateGapRepeatSymbol(TemplateGapRepeatSymbol that) {
        forRepeatSymbol(that);
    }

    public void forTemplateGapRepeatOneOrMoreSymbol(TemplateGapRepeatOneOrMoreSymbol that) {
        forRepeatOneOrMoreSymbol(that);
    }

    public void forTemplateGapNoWhitespaceSymbol(TemplateGapNoWhitespaceSymbol that) {
        forNoWhitespaceSymbol(that);
    }

    public void forTemplateGapGroupSymbol(TemplateGapGroupSymbol that) {
        forGroupSymbol(that);
    }

    public void forTemplateGapSpecialSymbol(TemplateGapSpecialSymbol that) {
        forSpecialSymbol(that);
    }

    public void forTemplateGapAnyCharacterSymbol(TemplateGapAnyCharacterSymbol that) {
        forAnyCharacterSymbol(that);
    }

    public void forTemplateGapWhitespaceSymbol(TemplateGapWhitespaceSymbol that) {
        forWhitespaceSymbol(that);
    }

    public void forTemplateGapTabSymbol(TemplateGapTabSymbol that) {
        forTabSymbol(that);
    }

    public void forTemplateGapFormfeedSymbol(TemplateGapFormfeedSymbol that) {
        forFormfeedSymbol(that);
    }

    public void forTemplateGapCarriageReturnSymbol(TemplateGapCarriageReturnSymbol that) {
        forCarriageReturnSymbol(that);
    }

    public void forTemplateGapBackspaceSymbol(TemplateGapBackspaceSymbol that) {
        forBackspaceSymbol(that);
    }

    public void forTemplateGapNewlineSymbol(TemplateGapNewlineSymbol that) {
        forNewlineSymbol(that);
    }

    public void forTemplateGapBreaklineSymbol(TemplateGapBreaklineSymbol that) {
        forBreaklineSymbol(that);
    }

    public void forTemplateGapItemSymbol(TemplateGapItemSymbol that) {
        forItemSymbol(that);
    }

    public void forTemplateGapNonterminalSymbol(TemplateGapNonterminalSymbol that) {
        forNonterminalSymbol(that);
    }

    public void forTemplateGapKeywordSymbol(TemplateGapKeywordSymbol that) {
        forKeywordSymbol(that);
    }

    public void forTemplateGapTokenSymbol(TemplateGapTokenSymbol that) {
        forTokenSymbol(that);
    }

    public void forTemplateGapNotPredicateSymbol(TemplateGapNotPredicateSymbol that) {
        forNotPredicateSymbol(that);
    }

    public void forTemplateGapAndPredicateSymbol(TemplateGapAndPredicateSymbol that) {
        forAndPredicateSymbol(that);
    }

    public void forTemplateGapCharacterClassSymbol(TemplateGapCharacterClassSymbol that) {
        forCharacterClassSymbol(that);
    }

    public void forTemplateGapCharacterSymbol(TemplateGapCharacterSymbol that) {
        forCharacterSymbol(that);
    }

    public void forTemplateGapCharSymbol(TemplateGapCharSymbol that) {
        forCharSymbol(that);
    }

    public void forTemplateGapCharacterInterval(TemplateGapCharacterInterval that) {
        forCharacterInterval(that);
    }

    public void forTemplateGapLink(TemplateGapLink that) {
        forLink(that);
    }

}
