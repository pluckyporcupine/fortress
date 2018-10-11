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

/** A parametric abstract implementation of a visitor over AbstractNode that return a value.
 ** This visitor implements the visitor interface with methods that each 
 ** delegate to a case representing their superclass.  At the top of this
 ** delegation tree is the method defaultCase(), which (unless overridden)
 ** throws an exception.
 **/
@SuppressWarnings("unused")
public abstract class AbstractNodeAbstractVisitor<RetType>  extends AbstractNodeVisitorLambda<RetType> {
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, an exception is thrown; subclasses may override this behavior.
     * @throws IllegalArgumentException
    **/
    public RetType defaultCase(AbstractNode that) {
        throw new IllegalArgumentException("Visitor " + getClass().getName() + " does not support visiting values of type " + that.getClass().getName());
    }

    /* Methods to visit an item. */
    public RetType forAbstractNode(AbstractNode that) {
        return defaultCase(that);
    }

    public RetType forCompilationUnit(CompilationUnit that) {
        return forAbstractNode(that);
    }

    public RetType forComponent(Component that) {
        return forCompilationUnit(that);
    }

    public RetType forApi(Api that) {
        return forCompilationUnit(that);
    }

    public RetType forImport(Import that) {
        return forAbstractNode(that);
    }

    public RetType forImportedNames(ImportedNames that) {
        return forImport(that);
    }

    public RetType forImportStar(ImportStar that) {
        return forImportedNames(that);
    }

    public RetType forImportNames(ImportNames that) {
        return forImportedNames(that);
    }

    public RetType forImportApi(ImportApi that) {
        return forImport(that);
    }

    public RetType forAliasedSimpleName(AliasedSimpleName that) {
        return forAbstractNode(that);
    }

    public RetType forAliasedAPIName(AliasedAPIName that) {
        return forAbstractNode(that);
    }

    public RetType forDecl(Decl that) {
        return forAbstractNode(that);
    }

    public RetType forTraitObjectDecl(TraitObjectDecl that) {
        return forDecl(that);
    }

    public RetType forTraitDecl(TraitDecl that) {
        return forTraitObjectDecl(that);
    }

    public RetType forObjectDecl(ObjectDecl that) {
        return forTraitObjectDecl(that);
    }

    public RetType forVarDecl(VarDecl that) {
        return forDecl(that);
    }

    public RetType forFnDecl(FnDecl that) {
        return forDecl(that);
    }

    public RetType for_RewriteFnOverloadDecl(_RewriteFnOverloadDecl that) {
        return forDecl(that);
    }

    public RetType for_RewriteObjectExprDecl(_RewriteObjectExprDecl that) {
        return forDecl(that);
    }

    public RetType for_RewriteFunctionalMethodDecl(_RewriteFunctionalMethodDecl that) {
        return forDecl(that);
    }

    public RetType forDimUnitDecl(DimUnitDecl that) {
        return forDecl(that);
    }

    public RetType forDimDecl(DimDecl that) {
        return forDimUnitDecl(that);
    }

    public RetType forUnitDecl(UnitDecl that) {
        return forDimUnitDecl(that);
    }

    public RetType forTestDecl(TestDecl that) {
        return forDecl(that);
    }

    public RetType forPropertyDecl(PropertyDecl that) {
        return forDecl(that);
    }

    public RetType forTypeAlias(TypeAlias that) {
        return forDecl(that);
    }

    public RetType forGrammarDecl(GrammarDecl that) {
        return forDecl(that);
    }

    public RetType forGrammarMemberDecl(GrammarMemberDecl that) {
        return forDecl(that);
    }

    public RetType forNonterminalDecl(NonterminalDecl that) {
        return forGrammarMemberDecl(that);
    }

    public RetType forNonterminalDef(NonterminalDef that) {
        return forNonterminalDecl(that);
    }

    public RetType forNonterminalExtensionDef(NonterminalExtensionDef that) {
        return forNonterminalDecl(that);
    }

    public RetType forBinding(Binding that) {
        return forAbstractNode(that);
    }

    public RetType forLValue(LValue that) {
        return forBinding(that);
    }

    public RetType forParam(Param that) {
        return forBinding(that);
    }

    public RetType forExpr(Expr that) {
        return forAbstractNode(that);
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

    public RetType forType(Type that) {
        return forAbstractNode(that);
    }

    public RetType forBaseType(BaseType that) {
        return forType(that);
    }

    public RetType forAnyType(AnyType that) {
        return forBaseType(that);
    }

    public RetType forBottomType(BottomType that) {
        return forBaseType(that);
    }

    public RetType forUnknownType(UnknownType that) {
        return forBaseType(that);
    }

    public RetType forSelfType(SelfType that) {
        return forBaseType(that);
    }

    public RetType forTraitSelfType(TraitSelfType that) {
        return forSelfType(that);
    }

    public RetType forObjectExprType(ObjectExprType that) {
        return forSelfType(that);
    }

    public RetType forNamedType(NamedType that) {
        return forBaseType(that);
    }

    public RetType for_InferenceVarType(_InferenceVarType that) {
        return forNamedType(that);
    }

    public RetType forVarType(VarType that) {
        return forNamedType(that);
    }

    public RetType forTraitType(TraitType that) {
        return forNamedType(that);
    }

    public RetType forAbbreviatedType(AbbreviatedType that) {
        return forBaseType(that);
    }

    public RetType forArrayType(ArrayType that) {
        return forAbbreviatedType(that);
    }

    public RetType forMatrixType(MatrixType that) {
        return forAbbreviatedType(that);
    }

    public RetType forTaggedDimType(TaggedDimType that) {
        return forAbbreviatedType(that);
    }

    public RetType forTaggedUnitType(TaggedUnitType that) {
        return forAbbreviatedType(that);
    }

    public RetType forTupleType(TupleType that) {
        return forType(that);
    }

    public RetType forArrowType(ArrowType that) {
        return forType(that);
    }

    public RetType forBoundType(BoundType that) {
        return forType(that);
    }

    public RetType forIntersectionType(IntersectionType that) {
        return forBoundType(that);
    }

    public RetType forUnionType(UnionType that) {
        return forBoundType(that);
    }

    public RetType forFixedPointType(FixedPointType that) {
        return forType(that);
    }

    public RetType forLabelType(LabelType that) {
        return forType(that);
    }

    public RetType forDimExpr(DimExpr that) {
        return forType(that);
    }

    public RetType forDimBase(DimBase that) {
        return forDimExpr(that);
    }

    public RetType forDimRef(DimRef that) {
        return forDimExpr(that);
    }

    public RetType forDimExponent(DimExponent that) {
        return forDimExpr(that);
    }

    public RetType forDimUnaryOp(DimUnaryOp that) {
        return forDimExpr(that);
    }

    public RetType forDimBinaryOp(DimBinaryOp that) {
        return forDimExpr(that);
    }

    public RetType forPattern(Pattern that) {
        return forAbstractNode(that);
    }

    public RetType forPatternArgs(PatternArgs that) {
        return forAbstractNode(that);
    }

    public RetType forPatternBinding(PatternBinding that) {
        return forAbstractNode(that);
    }

    public RetType forPlainPattern(PlainPattern that) {
        return forPatternBinding(that);
    }

    public RetType forTypePattern(TypePattern that) {
        return forPatternBinding(that);
    }

    public RetType forNestedPattern(NestedPattern that) {
        return forPatternBinding(that);
    }

    public RetType forStaticArg(StaticArg that) {
        return forAbstractNode(that);
    }

    public RetType forTypeArg(TypeArg that) {
        return forStaticArg(that);
    }

    public RetType forIntArg(IntArg that) {
        return forStaticArg(that);
    }

    public RetType forBoolArg(BoolArg that) {
        return forStaticArg(that);
    }

    public RetType forOpArg(OpArg that) {
        return forStaticArg(that);
    }

    public RetType forDimArg(DimArg that) {
        return forStaticArg(that);
    }

    public RetType forUnitArg(UnitArg that) {
        return forStaticArg(that);
    }

    public RetType forStaticExpr(StaticExpr that) {
        return forAbstractNode(that);
    }

    public RetType forIntExpr(IntExpr that) {
        return forStaticExpr(that);
    }

    public RetType forIntBase(IntBase that) {
        return forIntExpr(that);
    }

    public RetType forIntRef(IntRef that) {
        return forIntExpr(that);
    }

    public RetType forIntBinaryOp(IntBinaryOp that) {
        return forIntExpr(that);
    }

    public RetType forBoolExpr(BoolExpr that) {
        return forStaticExpr(that);
    }

    public RetType forBoolBase(BoolBase that) {
        return forBoolExpr(that);
    }

    public RetType forBoolRef(BoolRef that) {
        return forBoolExpr(that);
    }

    public RetType forBoolConstraint(BoolConstraint that) {
        return forBoolExpr(that);
    }

    public RetType forBoolUnaryOp(BoolUnaryOp that) {
        return forBoolConstraint(that);
    }

    public RetType forBoolBinaryOp(BoolBinaryOp that) {
        return forBoolConstraint(that);
    }

    public RetType forUnitExpr(UnitExpr that) {
        return forStaticExpr(that);
    }

    public RetType forUnitRef(UnitRef that) {
        return forUnitExpr(that);
    }

    public RetType forUnitBinaryOp(UnitBinaryOp that) {
        return forUnitExpr(that);
    }

    public RetType forEffect(Effect that) {
        return forAbstractNode(that);
    }

    public RetType forWhereClause(WhereClause that) {
        return forAbstractNode(that);
    }

    public RetType forWhereBinding(WhereBinding that) {
        return forAbstractNode(that);
    }

    public RetType forWhereConstraint(WhereConstraint that) {
        return forAbstractNode(that);
    }

    public RetType forWhereExtends(WhereExtends that) {
        return forWhereConstraint(that);
    }

    public RetType forWhereTypeAlias(WhereTypeAlias that) {
        return forWhereConstraint(that);
    }

    public RetType forWhereCoerces(WhereCoerces that) {
        return forWhereConstraint(that);
    }

    public RetType forWhereEquals(WhereEquals that) {
        return forWhereConstraint(that);
    }

    public RetType forUnitConstraint(UnitConstraint that) {
        return forWhereConstraint(that);
    }

    public RetType forIntConstraint(IntConstraint that) {
        return forWhereConstraint(that);
    }

    public RetType forBoolConstraintExpr(BoolConstraintExpr that) {
        return forWhereConstraint(that);
    }

    public RetType forContract(Contract that) {
        return forAbstractNode(that);
    }

    public RetType forEnsuresClause(EnsuresClause that) {
        return forAbstractNode(that);
    }

    public RetType forStaticParam(StaticParam that) {
        return forAbstractNode(that);
    }

    public RetType forName(Name that) {
        return forAbstractNode(that);
    }

    public RetType forAPIName(APIName that) {
        return forName(that);
    }

    public RetType forIdOrOpOrAnonymousName(IdOrOpOrAnonymousName that) {
        return forName(that);
    }

    public RetType forIdOrOp(IdOrOp that) {
        return forIdOrOpOrAnonymousName(that);
    }

    public RetType forId(Id that) {
        return forIdOrOp(that);
    }

    public RetType forOp(Op that) {
        return forIdOrOp(that);
    }

    public RetType forNamedOp(NamedOp that) {
        return forOp(that);
    }

    public RetType for_InferenceVarOp(_InferenceVarOp that) {
        return forOp(that);
    }

    public RetType forAnonymousName(AnonymousName that) {
        return forIdOrOpOrAnonymousName(that);
    }

    public RetType forAnonymousFnName(AnonymousFnName that) {
        return forAnonymousName(that);
    }

    public RetType forConstructorFnName(ConstructorFnName that) {
        return forAnonymousName(that);
    }

    public RetType forArrayComprehensionClause(ArrayComprehensionClause that) {
        return forAbstractNode(that);
    }

    public RetType forKeywordExpr(KeywordExpr that) {
        return forAbstractNode(that);
    }

    public RetType forCaseClause(CaseClause that) {
        return forAbstractNode(that);
    }

    public RetType forCatch(Catch that) {
        return forAbstractNode(that);
    }

    public RetType forCatchClause(CatchClause that) {
        return forAbstractNode(that);
    }

    public RetType forIfClause(IfClause that) {
        return forAbstractNode(that);
    }

    public RetType forTypecaseClause(TypecaseClause that) {
        return forAbstractNode(that);
    }

    public RetType forExtentRange(ExtentRange that) {
        return forAbstractNode(that);
    }

    public RetType forGeneratorClause(GeneratorClause that) {
        return forAbstractNode(that);
    }

    public RetType forKeywordType(KeywordType that) {
        return forAbstractNode(that);
    }

    public RetType forTraitTypeWhere(TraitTypeWhere that) {
        return forAbstractNode(that);
    }

    public RetType forIndices(Indices that) {
        return forAbstractNode(that);
    }

    public RetType forMathItem(MathItem that) {
        return forAbstractNode(that);
    }

    public RetType forExprMI(ExprMI that) {
        return forMathItem(that);
    }

    public RetType forParenthesisDelimitedMI(ParenthesisDelimitedMI that) {
        return forExprMI(that);
    }

    public RetType forNonParenthesisDelimitedMI(NonParenthesisDelimitedMI that) {
        return forExprMI(that);
    }

    public RetType forNonExprMI(NonExprMI that) {
        return forMathItem(that);
    }

    public RetType forExponentiationMI(ExponentiationMI that) {
        return forNonExprMI(that);
    }

    public RetType forSubscriptingMI(SubscriptingMI that) {
        return forNonExprMI(that);
    }

    public RetType forOverloading(Overloading that) {
        return forAbstractNode(that);
    }

    public RetType forNonterminalHeader(NonterminalHeader that) {
        return forAbstractNode(that);
    }

    public RetType forNonterminalParameter(NonterminalParameter that) {
        return forAbstractNode(that);
    }

    public RetType forSyntaxDecl(SyntaxDecl that) {
        return forAbstractNode(that);
    }

    public RetType forSyntaxDef(SyntaxDef that) {
        return forSyntaxDecl(that);
    }

    public RetType forSuperSyntaxDef(SuperSyntaxDef that) {
        return forSyntaxDecl(that);
    }

    public RetType forTransformerDecl(TransformerDecl that) {
        return forAbstractNode(that);
    }

    public RetType forPreTransformerDef(PreTransformerDef that) {
        return forTransformerDecl(that);
    }

    public RetType forNamedTransformerDef(NamedTransformerDef that) {
        return forTransformerDecl(that);
    }

    public RetType forTransformer(Transformer that) {
        return forAbstractNode(that);
    }

    public RetType forUnparsedTransformer(UnparsedTransformer that) {
        return forTransformer(that);
    }

    public RetType forNodeTransformer(NodeTransformer that) {
        return forTransformer(that);
    }

    public RetType forCaseTransformer(CaseTransformer that) {
        return forTransformer(that);
    }

    public RetType forCaseTransformerClause(CaseTransformerClause that) {
        return forAbstractNode(that);
    }

    public RetType forSyntaxSymbol(SyntaxSymbol that) {
        return forAbstractNode(that);
    }

    public RetType forPrefixedSymbol(PrefixedSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType forOptionalSymbol(OptionalSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType forRepeatSymbol(RepeatSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType forRepeatOneOrMoreSymbol(RepeatOneOrMoreSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType forNoWhitespaceSymbol(NoWhitespaceSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType forGroupSymbol(GroupSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType forSpecialSymbol(SpecialSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType forAnyCharacterSymbol(AnyCharacterSymbol that) {
        return forSpecialSymbol(that);
    }

    public RetType forWhitespaceSymbol(WhitespaceSymbol that) {
        return forSpecialSymbol(that);
    }

    public RetType forTabSymbol(TabSymbol that) {
        return forSpecialSymbol(that);
    }

    public RetType forFormfeedSymbol(FormfeedSymbol that) {
        return forSpecialSymbol(that);
    }

    public RetType forCarriageReturnSymbol(CarriageReturnSymbol that) {
        return forSpecialSymbol(that);
    }

    public RetType forBackspaceSymbol(BackspaceSymbol that) {
        return forSpecialSymbol(that);
    }

    public RetType forNewlineSymbol(NewlineSymbol that) {
        return forSpecialSymbol(that);
    }

    public RetType forBreaklineSymbol(BreaklineSymbol that) {
        return forSpecialSymbol(that);
    }

    public RetType forItemSymbol(ItemSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType forNonterminalSymbol(NonterminalSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType forKeywordSymbol(KeywordSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType forTokenSymbol(TokenSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType forNotPredicateSymbol(NotPredicateSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType forAndPredicateSymbol(AndPredicateSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType forCharacterClassSymbol(CharacterClassSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType forCharacterSymbol(CharacterSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType forCharSymbol(CharSymbol that) {
        return forCharacterSymbol(that);
    }

    public RetType forCharacterInterval(CharacterInterval that) {
        return forCharacterSymbol(that);
    }

    public RetType forLink(Link that) {
        return forAbstractNode(that);
    }

    public RetType for_SyntaxTransformationAbstractNode(_SyntaxTransformationAbstractNode that) {
        return forAbstractNode(that);
    }

    public RetType for_SyntaxTransformationCompilationUnit(_SyntaxTransformationCompilationUnit that) {
        return forCompilationUnit(that);
    }

    public RetType for_SyntaxTransformationComponent(_SyntaxTransformationComponent that) {
        return forComponent(that);
    }

    public RetType for_SyntaxTransformationApi(_SyntaxTransformationApi that) {
        return forApi(that);
    }

    public RetType for_SyntaxTransformationImport(_SyntaxTransformationImport that) {
        return forImport(that);
    }

    public RetType for_SyntaxTransformationImportedNames(_SyntaxTransformationImportedNames that) {
        return forImportedNames(that);
    }

    public RetType for_SyntaxTransformationImportStar(_SyntaxTransformationImportStar that) {
        return forImportStar(that);
    }

    public RetType for_SyntaxTransformationImportNames(_SyntaxTransformationImportNames that) {
        return forImportNames(that);
    }

    public RetType for_SyntaxTransformationImportApi(_SyntaxTransformationImportApi that) {
        return forImportApi(that);
    }

    public RetType for_SyntaxTransformationAliasedSimpleName(_SyntaxTransformationAliasedSimpleName that) {
        return forAliasedSimpleName(that);
    }

    public RetType for_SyntaxTransformationAliasedAPIName(_SyntaxTransformationAliasedAPIName that) {
        return forAliasedAPIName(that);
    }

    public RetType for_SyntaxTransformationDecl(_SyntaxTransformationDecl that) {
        return forDecl(that);
    }

    public RetType for_SyntaxTransformationTraitObjectDecl(_SyntaxTransformationTraitObjectDecl that) {
        return forTraitObjectDecl(that);
    }

    public RetType for_SyntaxTransformationTraitDecl(_SyntaxTransformationTraitDecl that) {
        return forTraitDecl(that);
    }

    public RetType for_SyntaxTransformationObjectDecl(_SyntaxTransformationObjectDecl that) {
        return forObjectDecl(that);
    }

    public RetType for_SyntaxTransformationVarDecl(_SyntaxTransformationVarDecl that) {
        return forVarDecl(that);
    }

    public RetType for_SyntaxTransformationFnDecl(_SyntaxTransformationFnDecl that) {
        return forFnDecl(that);
    }

    public RetType for_SyntaxTransformation_RewriteFnOverloadDecl(_SyntaxTransformation_RewriteFnOverloadDecl that) {
        return for_RewriteFnOverloadDecl(that);
    }

    public RetType for_SyntaxTransformation_RewriteObjectExprDecl(_SyntaxTransformation_RewriteObjectExprDecl that) {
        return for_RewriteObjectExprDecl(that);
    }

    public RetType for_SyntaxTransformation_RewriteFunctionalMethodDecl(_SyntaxTransformation_RewriteFunctionalMethodDecl that) {
        return for_RewriteFunctionalMethodDecl(that);
    }

    public RetType for_SyntaxTransformationDimUnitDecl(_SyntaxTransformationDimUnitDecl that) {
        return forDimUnitDecl(that);
    }

    public RetType for_SyntaxTransformationDimDecl(_SyntaxTransformationDimDecl that) {
        return forDimDecl(that);
    }

    public RetType for_SyntaxTransformationUnitDecl(_SyntaxTransformationUnitDecl that) {
        return forUnitDecl(that);
    }

    public RetType for_SyntaxTransformationTestDecl(_SyntaxTransformationTestDecl that) {
        return forTestDecl(that);
    }

    public RetType for_SyntaxTransformationPropertyDecl(_SyntaxTransformationPropertyDecl that) {
        return forPropertyDecl(that);
    }

    public RetType for_SyntaxTransformationTypeAlias(_SyntaxTransformationTypeAlias that) {
        return forTypeAlias(that);
    }

    public RetType for_SyntaxTransformationGrammarDecl(_SyntaxTransformationGrammarDecl that) {
        return forGrammarDecl(that);
    }

    public RetType for_SyntaxTransformationGrammarMemberDecl(_SyntaxTransformationGrammarMemberDecl that) {
        return forGrammarMemberDecl(that);
    }

    public RetType for_SyntaxTransformationNonterminalDecl(_SyntaxTransformationNonterminalDecl that) {
        return forNonterminalDecl(that);
    }

    public RetType for_SyntaxTransformationNonterminalDef(_SyntaxTransformationNonterminalDef that) {
        return forNonterminalDef(that);
    }

    public RetType for_SyntaxTransformationNonterminalExtensionDef(_SyntaxTransformationNonterminalExtensionDef that) {
        return forNonterminalExtensionDef(that);
    }

    public RetType for_SyntaxTransformationBinding(_SyntaxTransformationBinding that) {
        return forBinding(that);
    }

    public RetType for_SyntaxTransformationLValue(_SyntaxTransformationLValue that) {
        return forLValue(that);
    }

    public RetType for_SyntaxTransformationParam(_SyntaxTransformationParam that) {
        return forParam(that);
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

    public RetType for_SyntaxTransformationType(_SyntaxTransformationType that) {
        return forType(that);
    }

    public RetType for_SyntaxTransformationBaseType(_SyntaxTransformationBaseType that) {
        return forBaseType(that);
    }

    public RetType for_SyntaxTransformationAnyType(_SyntaxTransformationAnyType that) {
        return forAnyType(that);
    }

    public RetType for_SyntaxTransformationBottomType(_SyntaxTransformationBottomType that) {
        return forBottomType(that);
    }

    public RetType for_SyntaxTransformationUnknownType(_SyntaxTransformationUnknownType that) {
        return forUnknownType(that);
    }

    public RetType for_SyntaxTransformationSelfType(_SyntaxTransformationSelfType that) {
        return forSelfType(that);
    }

    public RetType for_SyntaxTransformationTraitSelfType(_SyntaxTransformationTraitSelfType that) {
        return forTraitSelfType(that);
    }

    public RetType for_SyntaxTransformationObjectExprType(_SyntaxTransformationObjectExprType that) {
        return forObjectExprType(that);
    }

    public RetType for_SyntaxTransformationNamedType(_SyntaxTransformationNamedType that) {
        return forNamedType(that);
    }

    public RetType for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that) {
        return for_InferenceVarType(that);
    }

    public RetType for_SyntaxTransformationVarType(_SyntaxTransformationVarType that) {
        return forVarType(that);
    }

    public RetType for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that) {
        return forTraitType(that);
    }

    public RetType for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that) {
        return forAbbreviatedType(that);
    }

    public RetType for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that) {
        return forArrayType(that);
    }

    public RetType for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that) {
        return forMatrixType(that);
    }

    public RetType for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that) {
        return forTaggedDimType(that);
    }

    public RetType for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that) {
        return forTaggedUnitType(that);
    }

    public RetType for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that) {
        return forTupleType(that);
    }

    public RetType for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that) {
        return forArrowType(that);
    }

    public RetType for_SyntaxTransformationBoundType(_SyntaxTransformationBoundType that) {
        return forBoundType(that);
    }

    public RetType for_SyntaxTransformationIntersectionType(_SyntaxTransformationIntersectionType that) {
        return forIntersectionType(that);
    }

    public RetType for_SyntaxTransformationUnionType(_SyntaxTransformationUnionType that) {
        return forUnionType(that);
    }

    public RetType for_SyntaxTransformationFixedPointType(_SyntaxTransformationFixedPointType that) {
        return forFixedPointType(that);
    }

    public RetType for_SyntaxTransformationLabelType(_SyntaxTransformationLabelType that) {
        return forLabelType(that);
    }

    public RetType for_SyntaxTransformationDimExpr(_SyntaxTransformationDimExpr that) {
        return forDimExpr(that);
    }

    public RetType for_SyntaxTransformationDimBase(_SyntaxTransformationDimBase that) {
        return forDimBase(that);
    }

    public RetType for_SyntaxTransformationDimRef(_SyntaxTransformationDimRef that) {
        return forDimRef(that);
    }

    public RetType for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that) {
        return forDimExponent(that);
    }

    public RetType for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that) {
        return forDimUnaryOp(that);
    }

    public RetType for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that) {
        return forDimBinaryOp(that);
    }

    public RetType for_SyntaxTransformationPattern(_SyntaxTransformationPattern that) {
        return forPattern(that);
    }

    public RetType for_SyntaxTransformationPatternArgs(_SyntaxTransformationPatternArgs that) {
        return forPatternArgs(that);
    }

    public RetType for_SyntaxTransformationPatternBinding(_SyntaxTransformationPatternBinding that) {
        return forPatternBinding(that);
    }

    public RetType for_SyntaxTransformationPlainPattern(_SyntaxTransformationPlainPattern that) {
        return forPlainPattern(that);
    }

    public RetType for_SyntaxTransformationTypePattern(_SyntaxTransformationTypePattern that) {
        return forTypePattern(that);
    }

    public RetType for_SyntaxTransformationNestedPattern(_SyntaxTransformationNestedPattern that) {
        return forNestedPattern(that);
    }

    public RetType for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that) {
        return forStaticArg(that);
    }

    public RetType for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that) {
        return forTypeArg(that);
    }

    public RetType for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that) {
        return forIntArg(that);
    }

    public RetType for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that) {
        return forBoolArg(that);
    }

    public RetType for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that) {
        return forOpArg(that);
    }

    public RetType for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that) {
        return forDimArg(that);
    }

    public RetType for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that) {
        return forUnitArg(that);
    }

    public RetType for_SyntaxTransformationStaticExpr(_SyntaxTransformationStaticExpr that) {
        return forStaticExpr(that);
    }

    public RetType for_SyntaxTransformationIntExpr(_SyntaxTransformationIntExpr that) {
        return forIntExpr(that);
    }

    public RetType for_SyntaxTransformationIntBase(_SyntaxTransformationIntBase that) {
        return forIntBase(that);
    }

    public RetType for_SyntaxTransformationIntRef(_SyntaxTransformationIntRef that) {
        return forIntRef(that);
    }

    public RetType for_SyntaxTransformationIntBinaryOp(_SyntaxTransformationIntBinaryOp that) {
        return forIntBinaryOp(that);
    }

    public RetType for_SyntaxTransformationBoolExpr(_SyntaxTransformationBoolExpr that) {
        return forBoolExpr(that);
    }

    public RetType for_SyntaxTransformationBoolBase(_SyntaxTransformationBoolBase that) {
        return forBoolBase(that);
    }

    public RetType for_SyntaxTransformationBoolRef(_SyntaxTransformationBoolRef that) {
        return forBoolRef(that);
    }

    public RetType for_SyntaxTransformationBoolConstraint(_SyntaxTransformationBoolConstraint that) {
        return forBoolConstraint(that);
    }

    public RetType for_SyntaxTransformationBoolUnaryOp(_SyntaxTransformationBoolUnaryOp that) {
        return forBoolUnaryOp(that);
    }

    public RetType for_SyntaxTransformationBoolBinaryOp(_SyntaxTransformationBoolBinaryOp that) {
        return forBoolBinaryOp(that);
    }

    public RetType for_SyntaxTransformationUnitExpr(_SyntaxTransformationUnitExpr that) {
        return forUnitExpr(that);
    }

    public RetType for_SyntaxTransformationUnitRef(_SyntaxTransformationUnitRef that) {
        return forUnitRef(that);
    }

    public RetType for_SyntaxTransformationUnitBinaryOp(_SyntaxTransformationUnitBinaryOp that) {
        return forUnitBinaryOp(that);
    }

    public RetType for_SyntaxTransformationEffect(_SyntaxTransformationEffect that) {
        return forEffect(that);
    }

    public RetType for_SyntaxTransformationWhereClause(_SyntaxTransformationWhereClause that) {
        return forWhereClause(that);
    }

    public RetType for_SyntaxTransformationWhereBinding(_SyntaxTransformationWhereBinding that) {
        return forWhereBinding(that);
    }

    public RetType for_SyntaxTransformationWhereConstraint(_SyntaxTransformationWhereConstraint that) {
        return forWhereConstraint(that);
    }

    public RetType for_SyntaxTransformationWhereExtends(_SyntaxTransformationWhereExtends that) {
        return forWhereExtends(that);
    }

    public RetType for_SyntaxTransformationWhereTypeAlias(_SyntaxTransformationWhereTypeAlias that) {
        return forWhereTypeAlias(that);
    }

    public RetType for_SyntaxTransformationWhereCoerces(_SyntaxTransformationWhereCoerces that) {
        return forWhereCoerces(that);
    }

    public RetType for_SyntaxTransformationWhereEquals(_SyntaxTransformationWhereEquals that) {
        return forWhereEquals(that);
    }

    public RetType for_SyntaxTransformationUnitConstraint(_SyntaxTransformationUnitConstraint that) {
        return forUnitConstraint(that);
    }

    public RetType for_SyntaxTransformationIntConstraint(_SyntaxTransformationIntConstraint that) {
        return forIntConstraint(that);
    }

    public RetType for_SyntaxTransformationBoolConstraintExpr(_SyntaxTransformationBoolConstraintExpr that) {
        return forBoolConstraintExpr(that);
    }

    public RetType for_SyntaxTransformationContract(_SyntaxTransformationContract that) {
        return forContract(that);
    }

    public RetType for_SyntaxTransformationEnsuresClause(_SyntaxTransformationEnsuresClause that) {
        return forEnsuresClause(that);
    }

    public RetType for_SyntaxTransformationStaticParam(_SyntaxTransformationStaticParam that) {
        return forStaticParam(that);
    }

    public RetType for_SyntaxTransformationName(_SyntaxTransformationName that) {
        return forName(that);
    }

    public RetType for_SyntaxTransformationAPIName(_SyntaxTransformationAPIName that) {
        return forAPIName(that);
    }

    public RetType for_SyntaxTransformationIdOrOpOrAnonymousName(_SyntaxTransformationIdOrOpOrAnonymousName that) {
        return forIdOrOpOrAnonymousName(that);
    }

    public RetType for_SyntaxTransformationIdOrOp(_SyntaxTransformationIdOrOp that) {
        return forIdOrOp(that);
    }

    public RetType for_SyntaxTransformationId(_SyntaxTransformationId that) {
        return forId(that);
    }

    public RetType for_SyntaxTransformationOp(_SyntaxTransformationOp that) {
        return forOp(that);
    }

    public RetType for_SyntaxTransformationNamedOp(_SyntaxTransformationNamedOp that) {
        return forNamedOp(that);
    }

    public RetType for_SyntaxTransformation_InferenceVarOp(_SyntaxTransformation_InferenceVarOp that) {
        return for_InferenceVarOp(that);
    }

    public RetType for_SyntaxTransformationAnonymousName(_SyntaxTransformationAnonymousName that) {
        return forAnonymousName(that);
    }

    public RetType for_SyntaxTransformationAnonymousFnName(_SyntaxTransformationAnonymousFnName that) {
        return forAnonymousFnName(that);
    }

    public RetType for_SyntaxTransformationConstructorFnName(_SyntaxTransformationConstructorFnName that) {
        return forConstructorFnName(that);
    }

    public RetType for_SyntaxTransformationArrayComprehensionClause(_SyntaxTransformationArrayComprehensionClause that) {
        return forArrayComprehensionClause(that);
    }

    public RetType for_SyntaxTransformationKeywordExpr(_SyntaxTransformationKeywordExpr that) {
        return forKeywordExpr(that);
    }

    public RetType for_SyntaxTransformationCaseClause(_SyntaxTransformationCaseClause that) {
        return forCaseClause(that);
    }

    public RetType for_SyntaxTransformationCatch(_SyntaxTransformationCatch that) {
        return forCatch(that);
    }

    public RetType for_SyntaxTransformationCatchClause(_SyntaxTransformationCatchClause that) {
        return forCatchClause(that);
    }

    public RetType for_SyntaxTransformationIfClause(_SyntaxTransformationIfClause that) {
        return forIfClause(that);
    }

    public RetType for_SyntaxTransformationTypecaseClause(_SyntaxTransformationTypecaseClause that) {
        return forTypecaseClause(that);
    }

    public RetType for_SyntaxTransformationExtentRange(_SyntaxTransformationExtentRange that) {
        return forExtentRange(that);
    }

    public RetType for_SyntaxTransformationGeneratorClause(_SyntaxTransformationGeneratorClause that) {
        return forGeneratorClause(that);
    }

    public RetType for_SyntaxTransformationKeywordType(_SyntaxTransformationKeywordType that) {
        return forKeywordType(that);
    }

    public RetType for_SyntaxTransformationTraitTypeWhere(_SyntaxTransformationTraitTypeWhere that) {
        return forTraitTypeWhere(that);
    }

    public RetType for_SyntaxTransformationIndices(_SyntaxTransformationIndices that) {
        return forIndices(that);
    }

    public RetType for_SyntaxTransformationMathItem(_SyntaxTransformationMathItem that) {
        return forMathItem(that);
    }

    public RetType for_SyntaxTransformationExprMI(_SyntaxTransformationExprMI that) {
        return forExprMI(that);
    }

    public RetType for_SyntaxTransformationParenthesisDelimitedMI(_SyntaxTransformationParenthesisDelimitedMI that) {
        return forParenthesisDelimitedMI(that);
    }

    public RetType for_SyntaxTransformationNonParenthesisDelimitedMI(_SyntaxTransformationNonParenthesisDelimitedMI that) {
        return forNonParenthesisDelimitedMI(that);
    }

    public RetType for_SyntaxTransformationNonExprMI(_SyntaxTransformationNonExprMI that) {
        return forNonExprMI(that);
    }

    public RetType for_SyntaxTransformationExponentiationMI(_SyntaxTransformationExponentiationMI that) {
        return forExponentiationMI(that);
    }

    public RetType for_SyntaxTransformationSubscriptingMI(_SyntaxTransformationSubscriptingMI that) {
        return forSubscriptingMI(that);
    }

    public RetType for_SyntaxTransformationOverloading(_SyntaxTransformationOverloading that) {
        return forOverloading(that);
    }

    public RetType for_SyntaxTransformationNonterminalHeader(_SyntaxTransformationNonterminalHeader that) {
        return forNonterminalHeader(that);
    }

    public RetType for_SyntaxTransformationNonterminalParameter(_SyntaxTransformationNonterminalParameter that) {
        return forNonterminalParameter(that);
    }

    public RetType for_SyntaxTransformationSyntaxDecl(_SyntaxTransformationSyntaxDecl that) {
        return forSyntaxDecl(that);
    }

    public RetType for_SyntaxTransformationSyntaxDef(_SyntaxTransformationSyntaxDef that) {
        return forSyntaxDef(that);
    }

    public RetType for_SyntaxTransformationSuperSyntaxDef(_SyntaxTransformationSuperSyntaxDef that) {
        return forSuperSyntaxDef(that);
    }

    public RetType for_SyntaxTransformationTransformerDecl(_SyntaxTransformationTransformerDecl that) {
        return forTransformerDecl(that);
    }

    public RetType for_SyntaxTransformationPreTransformerDef(_SyntaxTransformationPreTransformerDef that) {
        return forPreTransformerDef(that);
    }

    public RetType for_SyntaxTransformationNamedTransformerDef(_SyntaxTransformationNamedTransformerDef that) {
        return forNamedTransformerDef(that);
    }

    public RetType for_SyntaxTransformationTransformer(_SyntaxTransformationTransformer that) {
        return forTransformer(that);
    }

    public RetType for_SyntaxTransformationUnparsedTransformer(_SyntaxTransformationUnparsedTransformer that) {
        return forUnparsedTransformer(that);
    }

    public RetType for_SyntaxTransformationNodeTransformer(_SyntaxTransformationNodeTransformer that) {
        return forNodeTransformer(that);
    }

    public RetType for_SyntaxTransformationCaseTransformer(_SyntaxTransformationCaseTransformer that) {
        return forCaseTransformer(that);
    }

    public RetType for_SyntaxTransformationCaseTransformerClause(_SyntaxTransformationCaseTransformerClause that) {
        return forCaseTransformerClause(that);
    }

    public RetType for_SyntaxTransformationSyntaxSymbol(_SyntaxTransformationSyntaxSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType for_SyntaxTransformationPrefixedSymbol(_SyntaxTransformationPrefixedSymbol that) {
        return forPrefixedSymbol(that);
    }

    public RetType for_SyntaxTransformationOptionalSymbol(_SyntaxTransformationOptionalSymbol that) {
        return forOptionalSymbol(that);
    }

    public RetType for_SyntaxTransformationRepeatSymbol(_SyntaxTransformationRepeatSymbol that) {
        return forRepeatSymbol(that);
    }

    public RetType for_SyntaxTransformationRepeatOneOrMoreSymbol(_SyntaxTransformationRepeatOneOrMoreSymbol that) {
        return forRepeatOneOrMoreSymbol(that);
    }

    public RetType for_SyntaxTransformationNoWhitespaceSymbol(_SyntaxTransformationNoWhitespaceSymbol that) {
        return forNoWhitespaceSymbol(that);
    }

    public RetType for_SyntaxTransformationGroupSymbol(_SyntaxTransformationGroupSymbol that) {
        return forGroupSymbol(that);
    }

    public RetType for_SyntaxTransformationSpecialSymbol(_SyntaxTransformationSpecialSymbol that) {
        return forSpecialSymbol(that);
    }

    public RetType for_SyntaxTransformationAnyCharacterSymbol(_SyntaxTransformationAnyCharacterSymbol that) {
        return forAnyCharacterSymbol(that);
    }

    public RetType for_SyntaxTransformationWhitespaceSymbol(_SyntaxTransformationWhitespaceSymbol that) {
        return forWhitespaceSymbol(that);
    }

    public RetType for_SyntaxTransformationTabSymbol(_SyntaxTransformationTabSymbol that) {
        return forTabSymbol(that);
    }

    public RetType for_SyntaxTransformationFormfeedSymbol(_SyntaxTransformationFormfeedSymbol that) {
        return forFormfeedSymbol(that);
    }

    public RetType for_SyntaxTransformationCarriageReturnSymbol(_SyntaxTransformationCarriageReturnSymbol that) {
        return forCarriageReturnSymbol(that);
    }

    public RetType for_SyntaxTransformationBackspaceSymbol(_SyntaxTransformationBackspaceSymbol that) {
        return forBackspaceSymbol(that);
    }

    public RetType for_SyntaxTransformationNewlineSymbol(_SyntaxTransformationNewlineSymbol that) {
        return forNewlineSymbol(that);
    }

    public RetType for_SyntaxTransformationBreaklineSymbol(_SyntaxTransformationBreaklineSymbol that) {
        return forBreaklineSymbol(that);
    }

    public RetType for_SyntaxTransformationItemSymbol(_SyntaxTransformationItemSymbol that) {
        return forItemSymbol(that);
    }

    public RetType for_SyntaxTransformationNonterminalSymbol(_SyntaxTransformationNonterminalSymbol that) {
        return forNonterminalSymbol(that);
    }

    public RetType for_SyntaxTransformationKeywordSymbol(_SyntaxTransformationKeywordSymbol that) {
        return forKeywordSymbol(that);
    }

    public RetType for_SyntaxTransformationTokenSymbol(_SyntaxTransformationTokenSymbol that) {
        return forTokenSymbol(that);
    }

    public RetType for_SyntaxTransformationNotPredicateSymbol(_SyntaxTransformationNotPredicateSymbol that) {
        return forNotPredicateSymbol(that);
    }

    public RetType for_SyntaxTransformationAndPredicateSymbol(_SyntaxTransformationAndPredicateSymbol that) {
        return forAndPredicateSymbol(that);
    }

    public RetType for_SyntaxTransformationCharacterClassSymbol(_SyntaxTransformationCharacterClassSymbol that) {
        return forCharacterClassSymbol(that);
    }

    public RetType for_SyntaxTransformationCharacterSymbol(_SyntaxTransformationCharacterSymbol that) {
        return forCharacterSymbol(that);
    }

    public RetType for_SyntaxTransformationCharSymbol(_SyntaxTransformationCharSymbol that) {
        return forCharSymbol(that);
    }

    public RetType for_SyntaxTransformationCharacterInterval(_SyntaxTransformationCharacterInterval that) {
        return forCharacterInterval(that);
    }

    public RetType for_SyntaxTransformationLink(_SyntaxTransformationLink that) {
        return forLink(that);
    }

    public RetType for_EllipsesAbstractNode(_EllipsesAbstractNode that) {
        return forAbstractNode(that);
    }

    public RetType for_EllipsesCompilationUnit(_EllipsesCompilationUnit that) {
        return forCompilationUnit(that);
    }

    public RetType for_EllipsesComponent(_EllipsesComponent that) {
        return forComponent(that);
    }

    public RetType for_EllipsesApi(_EllipsesApi that) {
        return forApi(that);
    }

    public RetType for_EllipsesImport(_EllipsesImport that) {
        return forImport(that);
    }

    public RetType for_EllipsesImportedNames(_EllipsesImportedNames that) {
        return forImportedNames(that);
    }

    public RetType for_EllipsesImportStar(_EllipsesImportStar that) {
        return forImportStar(that);
    }

    public RetType for_EllipsesImportNames(_EllipsesImportNames that) {
        return forImportNames(that);
    }

    public RetType for_EllipsesImportApi(_EllipsesImportApi that) {
        return forImportApi(that);
    }

    public RetType for_EllipsesAliasedSimpleName(_EllipsesAliasedSimpleName that) {
        return forAliasedSimpleName(that);
    }

    public RetType for_EllipsesAliasedAPIName(_EllipsesAliasedAPIName that) {
        return forAliasedAPIName(that);
    }

    public RetType for_EllipsesDecl(_EllipsesDecl that) {
        return forDecl(that);
    }

    public RetType for_EllipsesTraitObjectDecl(_EllipsesTraitObjectDecl that) {
        return forTraitObjectDecl(that);
    }

    public RetType for_EllipsesTraitDecl(_EllipsesTraitDecl that) {
        return forTraitDecl(that);
    }

    public RetType for_EllipsesObjectDecl(_EllipsesObjectDecl that) {
        return forObjectDecl(that);
    }

    public RetType for_EllipsesVarDecl(_EllipsesVarDecl that) {
        return forVarDecl(that);
    }

    public RetType for_EllipsesFnDecl(_EllipsesFnDecl that) {
        return forFnDecl(that);
    }

    public RetType for_Ellipses_RewriteFnOverloadDecl(_Ellipses_RewriteFnOverloadDecl that) {
        return for_RewriteFnOverloadDecl(that);
    }

    public RetType for_Ellipses_RewriteObjectExprDecl(_Ellipses_RewriteObjectExprDecl that) {
        return for_RewriteObjectExprDecl(that);
    }

    public RetType for_Ellipses_RewriteFunctionalMethodDecl(_Ellipses_RewriteFunctionalMethodDecl that) {
        return for_RewriteFunctionalMethodDecl(that);
    }

    public RetType for_EllipsesDimUnitDecl(_EllipsesDimUnitDecl that) {
        return forDimUnitDecl(that);
    }

    public RetType for_EllipsesDimDecl(_EllipsesDimDecl that) {
        return forDimDecl(that);
    }

    public RetType for_EllipsesUnitDecl(_EllipsesUnitDecl that) {
        return forUnitDecl(that);
    }

    public RetType for_EllipsesTestDecl(_EllipsesTestDecl that) {
        return forTestDecl(that);
    }

    public RetType for_EllipsesPropertyDecl(_EllipsesPropertyDecl that) {
        return forPropertyDecl(that);
    }

    public RetType for_EllipsesTypeAlias(_EllipsesTypeAlias that) {
        return forTypeAlias(that);
    }

    public RetType for_EllipsesGrammarDecl(_EllipsesGrammarDecl that) {
        return forGrammarDecl(that);
    }

    public RetType for_EllipsesGrammarMemberDecl(_EllipsesGrammarMemberDecl that) {
        return forGrammarMemberDecl(that);
    }

    public RetType for_EllipsesNonterminalDecl(_EllipsesNonterminalDecl that) {
        return forNonterminalDecl(that);
    }

    public RetType for_EllipsesNonterminalDef(_EllipsesNonterminalDef that) {
        return forNonterminalDef(that);
    }

    public RetType for_EllipsesNonterminalExtensionDef(_EllipsesNonterminalExtensionDef that) {
        return forNonterminalExtensionDef(that);
    }

    public RetType for_EllipsesBinding(_EllipsesBinding that) {
        return forBinding(that);
    }

    public RetType for_EllipsesLValue(_EllipsesLValue that) {
        return forLValue(that);
    }

    public RetType for_EllipsesParam(_EllipsesParam that) {
        return forParam(that);
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

    public RetType for_EllipsesType(_EllipsesType that) {
        return forType(that);
    }

    public RetType for_EllipsesBaseType(_EllipsesBaseType that) {
        return forBaseType(that);
    }

    public RetType for_EllipsesAnyType(_EllipsesAnyType that) {
        return forAnyType(that);
    }

    public RetType for_EllipsesBottomType(_EllipsesBottomType that) {
        return forBottomType(that);
    }

    public RetType for_EllipsesUnknownType(_EllipsesUnknownType that) {
        return forUnknownType(that);
    }

    public RetType for_EllipsesSelfType(_EllipsesSelfType that) {
        return forSelfType(that);
    }

    public RetType for_EllipsesTraitSelfType(_EllipsesTraitSelfType that) {
        return forTraitSelfType(that);
    }

    public RetType for_EllipsesObjectExprType(_EllipsesObjectExprType that) {
        return forObjectExprType(that);
    }

    public RetType for_EllipsesNamedType(_EllipsesNamedType that) {
        return forNamedType(that);
    }

    public RetType for_Ellipses_InferenceVarType(_Ellipses_InferenceVarType that) {
        return for_InferenceVarType(that);
    }

    public RetType for_EllipsesVarType(_EllipsesVarType that) {
        return forVarType(that);
    }

    public RetType for_EllipsesTraitType(_EllipsesTraitType that) {
        return forTraitType(that);
    }

    public RetType for_EllipsesAbbreviatedType(_EllipsesAbbreviatedType that) {
        return forAbbreviatedType(that);
    }

    public RetType for_EllipsesArrayType(_EllipsesArrayType that) {
        return forArrayType(that);
    }

    public RetType for_EllipsesMatrixType(_EllipsesMatrixType that) {
        return forMatrixType(that);
    }

    public RetType for_EllipsesTaggedDimType(_EllipsesTaggedDimType that) {
        return forTaggedDimType(that);
    }

    public RetType for_EllipsesTaggedUnitType(_EllipsesTaggedUnitType that) {
        return forTaggedUnitType(that);
    }

    public RetType for_EllipsesTupleType(_EllipsesTupleType that) {
        return forTupleType(that);
    }

    public RetType for_EllipsesArrowType(_EllipsesArrowType that) {
        return forArrowType(that);
    }

    public RetType for_EllipsesBoundType(_EllipsesBoundType that) {
        return forBoundType(that);
    }

    public RetType for_EllipsesIntersectionType(_EllipsesIntersectionType that) {
        return forIntersectionType(that);
    }

    public RetType for_EllipsesUnionType(_EllipsesUnionType that) {
        return forUnionType(that);
    }

    public RetType for_EllipsesFixedPointType(_EllipsesFixedPointType that) {
        return forFixedPointType(that);
    }

    public RetType for_EllipsesLabelType(_EllipsesLabelType that) {
        return forLabelType(that);
    }

    public RetType for_EllipsesDimExpr(_EllipsesDimExpr that) {
        return forDimExpr(that);
    }

    public RetType for_EllipsesDimBase(_EllipsesDimBase that) {
        return forDimBase(that);
    }

    public RetType for_EllipsesDimRef(_EllipsesDimRef that) {
        return forDimRef(that);
    }

    public RetType for_EllipsesDimExponent(_EllipsesDimExponent that) {
        return forDimExponent(that);
    }

    public RetType for_EllipsesDimUnaryOp(_EllipsesDimUnaryOp that) {
        return forDimUnaryOp(that);
    }

    public RetType for_EllipsesDimBinaryOp(_EllipsesDimBinaryOp that) {
        return forDimBinaryOp(that);
    }

    public RetType for_EllipsesPattern(_EllipsesPattern that) {
        return forPattern(that);
    }

    public RetType for_EllipsesPatternArgs(_EllipsesPatternArgs that) {
        return forPatternArgs(that);
    }

    public RetType for_EllipsesPatternBinding(_EllipsesPatternBinding that) {
        return forPatternBinding(that);
    }

    public RetType for_EllipsesPlainPattern(_EllipsesPlainPattern that) {
        return forPlainPattern(that);
    }

    public RetType for_EllipsesTypePattern(_EllipsesTypePattern that) {
        return forTypePattern(that);
    }

    public RetType for_EllipsesNestedPattern(_EllipsesNestedPattern that) {
        return forNestedPattern(that);
    }

    public RetType for_EllipsesStaticArg(_EllipsesStaticArg that) {
        return forStaticArg(that);
    }

    public RetType for_EllipsesTypeArg(_EllipsesTypeArg that) {
        return forTypeArg(that);
    }

    public RetType for_EllipsesIntArg(_EllipsesIntArg that) {
        return forIntArg(that);
    }

    public RetType for_EllipsesBoolArg(_EllipsesBoolArg that) {
        return forBoolArg(that);
    }

    public RetType for_EllipsesOpArg(_EllipsesOpArg that) {
        return forOpArg(that);
    }

    public RetType for_EllipsesDimArg(_EllipsesDimArg that) {
        return forDimArg(that);
    }

    public RetType for_EllipsesUnitArg(_EllipsesUnitArg that) {
        return forUnitArg(that);
    }

    public RetType for_EllipsesStaticExpr(_EllipsesStaticExpr that) {
        return forStaticExpr(that);
    }

    public RetType for_EllipsesIntExpr(_EllipsesIntExpr that) {
        return forIntExpr(that);
    }

    public RetType for_EllipsesIntBase(_EllipsesIntBase that) {
        return forIntBase(that);
    }

    public RetType for_EllipsesIntRef(_EllipsesIntRef that) {
        return forIntRef(that);
    }

    public RetType for_EllipsesIntBinaryOp(_EllipsesIntBinaryOp that) {
        return forIntBinaryOp(that);
    }

    public RetType for_EllipsesBoolExpr(_EllipsesBoolExpr that) {
        return forBoolExpr(that);
    }

    public RetType for_EllipsesBoolBase(_EllipsesBoolBase that) {
        return forBoolBase(that);
    }

    public RetType for_EllipsesBoolRef(_EllipsesBoolRef that) {
        return forBoolRef(that);
    }

    public RetType for_EllipsesBoolConstraint(_EllipsesBoolConstraint that) {
        return forBoolConstraint(that);
    }

    public RetType for_EllipsesBoolUnaryOp(_EllipsesBoolUnaryOp that) {
        return forBoolUnaryOp(that);
    }

    public RetType for_EllipsesBoolBinaryOp(_EllipsesBoolBinaryOp that) {
        return forBoolBinaryOp(that);
    }

    public RetType for_EllipsesUnitExpr(_EllipsesUnitExpr that) {
        return forUnitExpr(that);
    }

    public RetType for_EllipsesUnitRef(_EllipsesUnitRef that) {
        return forUnitRef(that);
    }

    public RetType for_EllipsesUnitBinaryOp(_EllipsesUnitBinaryOp that) {
        return forUnitBinaryOp(that);
    }

    public RetType for_EllipsesEffect(_EllipsesEffect that) {
        return forEffect(that);
    }

    public RetType for_EllipsesWhereClause(_EllipsesWhereClause that) {
        return forWhereClause(that);
    }

    public RetType for_EllipsesWhereBinding(_EllipsesWhereBinding that) {
        return forWhereBinding(that);
    }

    public RetType for_EllipsesWhereConstraint(_EllipsesWhereConstraint that) {
        return forWhereConstraint(that);
    }

    public RetType for_EllipsesWhereExtends(_EllipsesWhereExtends that) {
        return forWhereExtends(that);
    }

    public RetType for_EllipsesWhereTypeAlias(_EllipsesWhereTypeAlias that) {
        return forWhereTypeAlias(that);
    }

    public RetType for_EllipsesWhereCoerces(_EllipsesWhereCoerces that) {
        return forWhereCoerces(that);
    }

    public RetType for_EllipsesWhereEquals(_EllipsesWhereEquals that) {
        return forWhereEquals(that);
    }

    public RetType for_EllipsesUnitConstraint(_EllipsesUnitConstraint that) {
        return forUnitConstraint(that);
    }

    public RetType for_EllipsesIntConstraint(_EllipsesIntConstraint that) {
        return forIntConstraint(that);
    }

    public RetType for_EllipsesBoolConstraintExpr(_EllipsesBoolConstraintExpr that) {
        return forBoolConstraintExpr(that);
    }

    public RetType for_EllipsesContract(_EllipsesContract that) {
        return forContract(that);
    }

    public RetType for_EllipsesEnsuresClause(_EllipsesEnsuresClause that) {
        return forEnsuresClause(that);
    }

    public RetType for_EllipsesStaticParam(_EllipsesStaticParam that) {
        return forStaticParam(that);
    }

    public RetType for_EllipsesName(_EllipsesName that) {
        return forName(that);
    }

    public RetType for_EllipsesAPIName(_EllipsesAPIName that) {
        return forAPIName(that);
    }

    public RetType for_EllipsesIdOrOpOrAnonymousName(_EllipsesIdOrOpOrAnonymousName that) {
        return forIdOrOpOrAnonymousName(that);
    }

    public RetType for_EllipsesIdOrOp(_EllipsesIdOrOp that) {
        return forIdOrOp(that);
    }

    public RetType for_EllipsesId(_EllipsesId that) {
        return forId(that);
    }

    public RetType for_EllipsesOp(_EllipsesOp that) {
        return forOp(that);
    }

    public RetType for_EllipsesNamedOp(_EllipsesNamedOp that) {
        return forNamedOp(that);
    }

    public RetType for_Ellipses_InferenceVarOp(_Ellipses_InferenceVarOp that) {
        return for_InferenceVarOp(that);
    }

    public RetType for_EllipsesAnonymousName(_EllipsesAnonymousName that) {
        return forAnonymousName(that);
    }

    public RetType for_EllipsesAnonymousFnName(_EllipsesAnonymousFnName that) {
        return forAnonymousFnName(that);
    }

    public RetType for_EllipsesConstructorFnName(_EllipsesConstructorFnName that) {
        return forConstructorFnName(that);
    }

    public RetType for_EllipsesArrayComprehensionClause(_EllipsesArrayComprehensionClause that) {
        return forArrayComprehensionClause(that);
    }

    public RetType for_EllipsesKeywordExpr(_EllipsesKeywordExpr that) {
        return forKeywordExpr(that);
    }

    public RetType for_EllipsesCaseClause(_EllipsesCaseClause that) {
        return forCaseClause(that);
    }

    public RetType for_EllipsesCatch(_EllipsesCatch that) {
        return forCatch(that);
    }

    public RetType for_EllipsesCatchClause(_EllipsesCatchClause that) {
        return forCatchClause(that);
    }

    public RetType for_EllipsesIfClause(_EllipsesIfClause that) {
        return forIfClause(that);
    }

    public RetType for_EllipsesTypecaseClause(_EllipsesTypecaseClause that) {
        return forTypecaseClause(that);
    }

    public RetType for_EllipsesExtentRange(_EllipsesExtentRange that) {
        return forExtentRange(that);
    }

    public RetType for_EllipsesGeneratorClause(_EllipsesGeneratorClause that) {
        return forGeneratorClause(that);
    }

    public RetType for_EllipsesKeywordType(_EllipsesKeywordType that) {
        return forKeywordType(that);
    }

    public RetType for_EllipsesTraitTypeWhere(_EllipsesTraitTypeWhere that) {
        return forTraitTypeWhere(that);
    }

    public RetType for_EllipsesIndices(_EllipsesIndices that) {
        return forIndices(that);
    }

    public RetType for_EllipsesMathItem(_EllipsesMathItem that) {
        return forMathItem(that);
    }

    public RetType for_EllipsesExprMI(_EllipsesExprMI that) {
        return forExprMI(that);
    }

    public RetType for_EllipsesParenthesisDelimitedMI(_EllipsesParenthesisDelimitedMI that) {
        return forParenthesisDelimitedMI(that);
    }

    public RetType for_EllipsesNonParenthesisDelimitedMI(_EllipsesNonParenthesisDelimitedMI that) {
        return forNonParenthesisDelimitedMI(that);
    }

    public RetType for_EllipsesNonExprMI(_EllipsesNonExprMI that) {
        return forNonExprMI(that);
    }

    public RetType for_EllipsesExponentiationMI(_EllipsesExponentiationMI that) {
        return forExponentiationMI(that);
    }

    public RetType for_EllipsesSubscriptingMI(_EllipsesSubscriptingMI that) {
        return forSubscriptingMI(that);
    }

    public RetType for_EllipsesOverloading(_EllipsesOverloading that) {
        return forOverloading(that);
    }

    public RetType for_EllipsesNonterminalHeader(_EllipsesNonterminalHeader that) {
        return forNonterminalHeader(that);
    }

    public RetType for_EllipsesNonterminalParameter(_EllipsesNonterminalParameter that) {
        return forNonterminalParameter(that);
    }

    public RetType for_EllipsesSyntaxDecl(_EllipsesSyntaxDecl that) {
        return forSyntaxDecl(that);
    }

    public RetType for_EllipsesSyntaxDef(_EllipsesSyntaxDef that) {
        return forSyntaxDef(that);
    }

    public RetType for_EllipsesSuperSyntaxDef(_EllipsesSuperSyntaxDef that) {
        return forSuperSyntaxDef(that);
    }

    public RetType for_EllipsesTransformerDecl(_EllipsesTransformerDecl that) {
        return forTransformerDecl(that);
    }

    public RetType for_EllipsesPreTransformerDef(_EllipsesPreTransformerDef that) {
        return forPreTransformerDef(that);
    }

    public RetType for_EllipsesNamedTransformerDef(_EllipsesNamedTransformerDef that) {
        return forNamedTransformerDef(that);
    }

    public RetType for_EllipsesTransformer(_EllipsesTransformer that) {
        return forTransformer(that);
    }

    public RetType for_EllipsesUnparsedTransformer(_EllipsesUnparsedTransformer that) {
        return forUnparsedTransformer(that);
    }

    public RetType for_EllipsesNodeTransformer(_EllipsesNodeTransformer that) {
        return forNodeTransformer(that);
    }

    public RetType for_EllipsesCaseTransformer(_EllipsesCaseTransformer that) {
        return forCaseTransformer(that);
    }

    public RetType for_EllipsesCaseTransformerClause(_EllipsesCaseTransformerClause that) {
        return forCaseTransformerClause(that);
    }

    public RetType for_EllipsesSyntaxSymbol(_EllipsesSyntaxSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType for_EllipsesPrefixedSymbol(_EllipsesPrefixedSymbol that) {
        return forPrefixedSymbol(that);
    }

    public RetType for_EllipsesOptionalSymbol(_EllipsesOptionalSymbol that) {
        return forOptionalSymbol(that);
    }

    public RetType for_EllipsesRepeatSymbol(_EllipsesRepeatSymbol that) {
        return forRepeatSymbol(that);
    }

    public RetType for_EllipsesRepeatOneOrMoreSymbol(_EllipsesRepeatOneOrMoreSymbol that) {
        return forRepeatOneOrMoreSymbol(that);
    }

    public RetType for_EllipsesNoWhitespaceSymbol(_EllipsesNoWhitespaceSymbol that) {
        return forNoWhitespaceSymbol(that);
    }

    public RetType for_EllipsesGroupSymbol(_EllipsesGroupSymbol that) {
        return forGroupSymbol(that);
    }

    public RetType for_EllipsesSpecialSymbol(_EllipsesSpecialSymbol that) {
        return forSpecialSymbol(that);
    }

    public RetType for_EllipsesAnyCharacterSymbol(_EllipsesAnyCharacterSymbol that) {
        return forAnyCharacterSymbol(that);
    }

    public RetType for_EllipsesWhitespaceSymbol(_EllipsesWhitespaceSymbol that) {
        return forWhitespaceSymbol(that);
    }

    public RetType for_EllipsesTabSymbol(_EllipsesTabSymbol that) {
        return forTabSymbol(that);
    }

    public RetType for_EllipsesFormfeedSymbol(_EllipsesFormfeedSymbol that) {
        return forFormfeedSymbol(that);
    }

    public RetType for_EllipsesCarriageReturnSymbol(_EllipsesCarriageReturnSymbol that) {
        return forCarriageReturnSymbol(that);
    }

    public RetType for_EllipsesBackspaceSymbol(_EllipsesBackspaceSymbol that) {
        return forBackspaceSymbol(that);
    }

    public RetType for_EllipsesNewlineSymbol(_EllipsesNewlineSymbol that) {
        return forNewlineSymbol(that);
    }

    public RetType for_EllipsesBreaklineSymbol(_EllipsesBreaklineSymbol that) {
        return forBreaklineSymbol(that);
    }

    public RetType for_EllipsesItemSymbol(_EllipsesItemSymbol that) {
        return forItemSymbol(that);
    }

    public RetType for_EllipsesNonterminalSymbol(_EllipsesNonterminalSymbol that) {
        return forNonterminalSymbol(that);
    }

    public RetType for_EllipsesKeywordSymbol(_EllipsesKeywordSymbol that) {
        return forKeywordSymbol(that);
    }

    public RetType for_EllipsesTokenSymbol(_EllipsesTokenSymbol that) {
        return forTokenSymbol(that);
    }

    public RetType for_EllipsesNotPredicateSymbol(_EllipsesNotPredicateSymbol that) {
        return forNotPredicateSymbol(that);
    }

    public RetType for_EllipsesAndPredicateSymbol(_EllipsesAndPredicateSymbol that) {
        return forAndPredicateSymbol(that);
    }

    public RetType for_EllipsesCharacterClassSymbol(_EllipsesCharacterClassSymbol that) {
        return forCharacterClassSymbol(that);
    }

    public RetType for_EllipsesCharacterSymbol(_EllipsesCharacterSymbol that) {
        return forCharacterSymbol(that);
    }

    public RetType for_EllipsesCharSymbol(_EllipsesCharSymbol that) {
        return forCharSymbol(that);
    }

    public RetType for_EllipsesCharacterInterval(_EllipsesCharacterInterval that) {
        return forCharacterInterval(that);
    }

    public RetType for_EllipsesLink(_EllipsesLink that) {
        return forLink(that);
    }

    public RetType forTemplateGapAbstractNode(TemplateGapAbstractNode that) {
        return forAbstractNode(that);
    }

    public RetType forTemplateGapCompilationUnit(TemplateGapCompilationUnit that) {
        return forCompilationUnit(that);
    }

    public RetType forTemplateGapComponent(TemplateGapComponent that) {
        return forComponent(that);
    }

    public RetType forTemplateGapApi(TemplateGapApi that) {
        return forApi(that);
    }

    public RetType forTemplateGapImport(TemplateGapImport that) {
        return forImport(that);
    }

    public RetType forTemplateGapImportedNames(TemplateGapImportedNames that) {
        return forImportedNames(that);
    }

    public RetType forTemplateGapImportStar(TemplateGapImportStar that) {
        return forImportStar(that);
    }

    public RetType forTemplateGapImportNames(TemplateGapImportNames that) {
        return forImportNames(that);
    }

    public RetType forTemplateGapImportApi(TemplateGapImportApi that) {
        return forImportApi(that);
    }

    public RetType forTemplateGapAliasedSimpleName(TemplateGapAliasedSimpleName that) {
        return forAliasedSimpleName(that);
    }

    public RetType forTemplateGapAliasedAPIName(TemplateGapAliasedAPIName that) {
        return forAliasedAPIName(that);
    }

    public RetType forTemplateGapDecl(TemplateGapDecl that) {
        return forDecl(that);
    }

    public RetType forTemplateGapTraitObjectDecl(TemplateGapTraitObjectDecl that) {
        return forTraitObjectDecl(that);
    }

    public RetType forTemplateGapTraitDecl(TemplateGapTraitDecl that) {
        return forTraitDecl(that);
    }

    public RetType forTemplateGapObjectDecl(TemplateGapObjectDecl that) {
        return forObjectDecl(that);
    }

    public RetType forTemplateGapVarDecl(TemplateGapVarDecl that) {
        return forVarDecl(that);
    }

    public RetType forTemplateGapFnDecl(TemplateGapFnDecl that) {
        return forFnDecl(that);
    }

    public RetType forTemplateGap_RewriteFnOverloadDecl(TemplateGap_RewriteFnOverloadDecl that) {
        return for_RewriteFnOverloadDecl(that);
    }

    public RetType forTemplateGap_RewriteObjectExprDecl(TemplateGap_RewriteObjectExprDecl that) {
        return for_RewriteObjectExprDecl(that);
    }

    public RetType forTemplateGap_RewriteFunctionalMethodDecl(TemplateGap_RewriteFunctionalMethodDecl that) {
        return for_RewriteFunctionalMethodDecl(that);
    }

    public RetType forTemplateGapDimUnitDecl(TemplateGapDimUnitDecl that) {
        return forDimUnitDecl(that);
    }

    public RetType forTemplateGapDimDecl(TemplateGapDimDecl that) {
        return forDimDecl(that);
    }

    public RetType forTemplateGapUnitDecl(TemplateGapUnitDecl that) {
        return forUnitDecl(that);
    }

    public RetType forTemplateGapTestDecl(TemplateGapTestDecl that) {
        return forTestDecl(that);
    }

    public RetType forTemplateGapPropertyDecl(TemplateGapPropertyDecl that) {
        return forPropertyDecl(that);
    }

    public RetType forTemplateGapTypeAlias(TemplateGapTypeAlias that) {
        return forTypeAlias(that);
    }

    public RetType forTemplateGapGrammarDecl(TemplateGapGrammarDecl that) {
        return forGrammarDecl(that);
    }

    public RetType forTemplateGapGrammarMemberDecl(TemplateGapGrammarMemberDecl that) {
        return forGrammarMemberDecl(that);
    }

    public RetType forTemplateGapNonterminalDecl(TemplateGapNonterminalDecl that) {
        return forNonterminalDecl(that);
    }

    public RetType forTemplateGapNonterminalDef(TemplateGapNonterminalDef that) {
        return forNonterminalDef(that);
    }

    public RetType forTemplateGapNonterminalExtensionDef(TemplateGapNonterminalExtensionDef that) {
        return forNonterminalExtensionDef(that);
    }

    public RetType forTemplateGapBinding(TemplateGapBinding that) {
        return forBinding(that);
    }

    public RetType forTemplateGapLValue(TemplateGapLValue that) {
        return forLValue(that);
    }

    public RetType forTemplateGapParam(TemplateGapParam that) {
        return forParam(that);
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

    public RetType forTemplateGapType(TemplateGapType that) {
        return forType(that);
    }

    public RetType forTemplateGapBaseType(TemplateGapBaseType that) {
        return forBaseType(that);
    }

    public RetType forTemplateGapAnyType(TemplateGapAnyType that) {
        return forAnyType(that);
    }

    public RetType forTemplateGapBottomType(TemplateGapBottomType that) {
        return forBottomType(that);
    }

    public RetType forTemplateGapUnknownType(TemplateGapUnknownType that) {
        return forUnknownType(that);
    }

    public RetType forTemplateGapSelfType(TemplateGapSelfType that) {
        return forSelfType(that);
    }

    public RetType forTemplateGapTraitSelfType(TemplateGapTraitSelfType that) {
        return forTraitSelfType(that);
    }

    public RetType forTemplateGapObjectExprType(TemplateGapObjectExprType that) {
        return forObjectExprType(that);
    }

    public RetType forTemplateGapNamedType(TemplateGapNamedType that) {
        return forNamedType(that);
    }

    public RetType forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that) {
        return for_InferenceVarType(that);
    }

    public RetType forTemplateGapVarType(TemplateGapVarType that) {
        return forVarType(that);
    }

    public RetType forTemplateGapTraitType(TemplateGapTraitType that) {
        return forTraitType(that);
    }

    public RetType forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that) {
        return forAbbreviatedType(that);
    }

    public RetType forTemplateGapArrayType(TemplateGapArrayType that) {
        return forArrayType(that);
    }

    public RetType forTemplateGapMatrixType(TemplateGapMatrixType that) {
        return forMatrixType(that);
    }

    public RetType forTemplateGapTaggedDimType(TemplateGapTaggedDimType that) {
        return forTaggedDimType(that);
    }

    public RetType forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that) {
        return forTaggedUnitType(that);
    }

    public RetType forTemplateGapTupleType(TemplateGapTupleType that) {
        return forTupleType(that);
    }

    public RetType forTemplateGapArrowType(TemplateGapArrowType that) {
        return forArrowType(that);
    }

    public RetType forTemplateGapBoundType(TemplateGapBoundType that) {
        return forBoundType(that);
    }

    public RetType forTemplateGapIntersectionType(TemplateGapIntersectionType that) {
        return forIntersectionType(that);
    }

    public RetType forTemplateGapUnionType(TemplateGapUnionType that) {
        return forUnionType(that);
    }

    public RetType forTemplateGapFixedPointType(TemplateGapFixedPointType that) {
        return forFixedPointType(that);
    }

    public RetType forTemplateGapLabelType(TemplateGapLabelType that) {
        return forLabelType(that);
    }

    public RetType forTemplateGapDimExpr(TemplateGapDimExpr that) {
        return forDimExpr(that);
    }

    public RetType forTemplateGapDimBase(TemplateGapDimBase that) {
        return forDimBase(that);
    }

    public RetType forTemplateGapDimRef(TemplateGapDimRef that) {
        return forDimRef(that);
    }

    public RetType forTemplateGapDimExponent(TemplateGapDimExponent that) {
        return forDimExponent(that);
    }

    public RetType forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that) {
        return forDimUnaryOp(that);
    }

    public RetType forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that) {
        return forDimBinaryOp(that);
    }

    public RetType forTemplateGapPattern(TemplateGapPattern that) {
        return forPattern(that);
    }

    public RetType forTemplateGapPatternArgs(TemplateGapPatternArgs that) {
        return forPatternArgs(that);
    }

    public RetType forTemplateGapPatternBinding(TemplateGapPatternBinding that) {
        return forPatternBinding(that);
    }

    public RetType forTemplateGapPlainPattern(TemplateGapPlainPattern that) {
        return forPlainPattern(that);
    }

    public RetType forTemplateGapTypePattern(TemplateGapTypePattern that) {
        return forTypePattern(that);
    }

    public RetType forTemplateGapNestedPattern(TemplateGapNestedPattern that) {
        return forNestedPattern(that);
    }

    public RetType forTemplateGapStaticArg(TemplateGapStaticArg that) {
        return forStaticArg(that);
    }

    public RetType forTemplateGapTypeArg(TemplateGapTypeArg that) {
        return forTypeArg(that);
    }

    public RetType forTemplateGapIntArg(TemplateGapIntArg that) {
        return forIntArg(that);
    }

    public RetType forTemplateGapBoolArg(TemplateGapBoolArg that) {
        return forBoolArg(that);
    }

    public RetType forTemplateGapOpArg(TemplateGapOpArg that) {
        return forOpArg(that);
    }

    public RetType forTemplateGapDimArg(TemplateGapDimArg that) {
        return forDimArg(that);
    }

    public RetType forTemplateGapUnitArg(TemplateGapUnitArg that) {
        return forUnitArg(that);
    }

    public RetType forTemplateGapStaticExpr(TemplateGapStaticExpr that) {
        return forStaticExpr(that);
    }

    public RetType forTemplateGapIntExpr(TemplateGapIntExpr that) {
        return forIntExpr(that);
    }

    public RetType forTemplateGapIntBase(TemplateGapIntBase that) {
        return forIntBase(that);
    }

    public RetType forTemplateGapIntRef(TemplateGapIntRef that) {
        return forIntRef(that);
    }

    public RetType forTemplateGapIntBinaryOp(TemplateGapIntBinaryOp that) {
        return forIntBinaryOp(that);
    }

    public RetType forTemplateGapBoolExpr(TemplateGapBoolExpr that) {
        return forBoolExpr(that);
    }

    public RetType forTemplateGapBoolBase(TemplateGapBoolBase that) {
        return forBoolBase(that);
    }

    public RetType forTemplateGapBoolRef(TemplateGapBoolRef that) {
        return forBoolRef(that);
    }

    public RetType forTemplateGapBoolConstraint(TemplateGapBoolConstraint that) {
        return forBoolConstraint(that);
    }

    public RetType forTemplateGapBoolUnaryOp(TemplateGapBoolUnaryOp that) {
        return forBoolUnaryOp(that);
    }

    public RetType forTemplateGapBoolBinaryOp(TemplateGapBoolBinaryOp that) {
        return forBoolBinaryOp(that);
    }

    public RetType forTemplateGapUnitExpr(TemplateGapUnitExpr that) {
        return forUnitExpr(that);
    }

    public RetType forTemplateGapUnitRef(TemplateGapUnitRef that) {
        return forUnitRef(that);
    }

    public RetType forTemplateGapUnitBinaryOp(TemplateGapUnitBinaryOp that) {
        return forUnitBinaryOp(that);
    }

    public RetType forTemplateGapEffect(TemplateGapEffect that) {
        return forEffect(that);
    }

    public RetType forTemplateGapWhereClause(TemplateGapWhereClause that) {
        return forWhereClause(that);
    }

    public RetType forTemplateGapWhereBinding(TemplateGapWhereBinding that) {
        return forWhereBinding(that);
    }

    public RetType forTemplateGapWhereConstraint(TemplateGapWhereConstraint that) {
        return forWhereConstraint(that);
    }

    public RetType forTemplateGapWhereExtends(TemplateGapWhereExtends that) {
        return forWhereExtends(that);
    }

    public RetType forTemplateGapWhereTypeAlias(TemplateGapWhereTypeAlias that) {
        return forWhereTypeAlias(that);
    }

    public RetType forTemplateGapWhereCoerces(TemplateGapWhereCoerces that) {
        return forWhereCoerces(that);
    }

    public RetType forTemplateGapWhereEquals(TemplateGapWhereEquals that) {
        return forWhereEquals(that);
    }

    public RetType forTemplateGapUnitConstraint(TemplateGapUnitConstraint that) {
        return forUnitConstraint(that);
    }

    public RetType forTemplateGapIntConstraint(TemplateGapIntConstraint that) {
        return forIntConstraint(that);
    }

    public RetType forTemplateGapBoolConstraintExpr(TemplateGapBoolConstraintExpr that) {
        return forBoolConstraintExpr(that);
    }

    public RetType forTemplateGapContract(TemplateGapContract that) {
        return forContract(that);
    }

    public RetType forTemplateGapEnsuresClause(TemplateGapEnsuresClause that) {
        return forEnsuresClause(that);
    }

    public RetType forTemplateGapStaticParam(TemplateGapStaticParam that) {
        return forStaticParam(that);
    }

    public RetType forTemplateGapName(TemplateGapName that) {
        return forName(that);
    }

    public RetType forTemplateGapAPIName(TemplateGapAPIName that) {
        return forAPIName(that);
    }

    public RetType forTemplateGapIdOrOpOrAnonymousName(TemplateGapIdOrOpOrAnonymousName that) {
        return forIdOrOpOrAnonymousName(that);
    }

    public RetType forTemplateGapIdOrOp(TemplateGapIdOrOp that) {
        return forIdOrOp(that);
    }

    public RetType forTemplateGapId(TemplateGapId that) {
        return forId(that);
    }

    public RetType forTemplateGapOp(TemplateGapOp that) {
        return forOp(that);
    }

    public RetType forTemplateGapNamedOp(TemplateGapNamedOp that) {
        return forNamedOp(that);
    }

    public RetType forTemplateGap_InferenceVarOp(TemplateGap_InferenceVarOp that) {
        return for_InferenceVarOp(that);
    }

    public RetType forTemplateGapAnonymousName(TemplateGapAnonymousName that) {
        return forAnonymousName(that);
    }

    public RetType forTemplateGapAnonymousFnName(TemplateGapAnonymousFnName that) {
        return forAnonymousFnName(that);
    }

    public RetType forTemplateGapConstructorFnName(TemplateGapConstructorFnName that) {
        return forConstructorFnName(that);
    }

    public RetType forTemplateGapArrayComprehensionClause(TemplateGapArrayComprehensionClause that) {
        return forArrayComprehensionClause(that);
    }

    public RetType forTemplateGapKeywordExpr(TemplateGapKeywordExpr that) {
        return forKeywordExpr(that);
    }

    public RetType forTemplateGapCaseClause(TemplateGapCaseClause that) {
        return forCaseClause(that);
    }

    public RetType forTemplateGapCatch(TemplateGapCatch that) {
        return forCatch(that);
    }

    public RetType forTemplateGapCatchClause(TemplateGapCatchClause that) {
        return forCatchClause(that);
    }

    public RetType forTemplateGapIfClause(TemplateGapIfClause that) {
        return forIfClause(that);
    }

    public RetType forTemplateGapTypecaseClause(TemplateGapTypecaseClause that) {
        return forTypecaseClause(that);
    }

    public RetType forTemplateGapExtentRange(TemplateGapExtentRange that) {
        return forExtentRange(that);
    }

    public RetType forTemplateGapGeneratorClause(TemplateGapGeneratorClause that) {
        return forGeneratorClause(that);
    }

    public RetType forTemplateGapKeywordType(TemplateGapKeywordType that) {
        return forKeywordType(that);
    }

    public RetType forTemplateGapTraitTypeWhere(TemplateGapTraitTypeWhere that) {
        return forTraitTypeWhere(that);
    }

    public RetType forTemplateGapIndices(TemplateGapIndices that) {
        return forIndices(that);
    }

    public RetType forTemplateGapMathItem(TemplateGapMathItem that) {
        return forMathItem(that);
    }

    public RetType forTemplateGapExprMI(TemplateGapExprMI that) {
        return forExprMI(that);
    }

    public RetType forTemplateGapParenthesisDelimitedMI(TemplateGapParenthesisDelimitedMI that) {
        return forParenthesisDelimitedMI(that);
    }

    public RetType forTemplateGapNonParenthesisDelimitedMI(TemplateGapNonParenthesisDelimitedMI that) {
        return forNonParenthesisDelimitedMI(that);
    }

    public RetType forTemplateGapNonExprMI(TemplateGapNonExprMI that) {
        return forNonExprMI(that);
    }

    public RetType forTemplateGapExponentiationMI(TemplateGapExponentiationMI that) {
        return forExponentiationMI(that);
    }

    public RetType forTemplateGapSubscriptingMI(TemplateGapSubscriptingMI that) {
        return forSubscriptingMI(that);
    }

    public RetType forTemplateGapOverloading(TemplateGapOverloading that) {
        return forOverloading(that);
    }

    public RetType forTemplateGapNonterminalHeader(TemplateGapNonterminalHeader that) {
        return forNonterminalHeader(that);
    }

    public RetType forTemplateGapNonterminalParameter(TemplateGapNonterminalParameter that) {
        return forNonterminalParameter(that);
    }

    public RetType forTemplateGapSyntaxDecl(TemplateGapSyntaxDecl that) {
        return forSyntaxDecl(that);
    }

    public RetType forTemplateGapSyntaxDef(TemplateGapSyntaxDef that) {
        return forSyntaxDef(that);
    }

    public RetType forTemplateGapSuperSyntaxDef(TemplateGapSuperSyntaxDef that) {
        return forSuperSyntaxDef(that);
    }

    public RetType forTemplateGapTransformerDecl(TemplateGapTransformerDecl that) {
        return forTransformerDecl(that);
    }

    public RetType forTemplateGapPreTransformerDef(TemplateGapPreTransformerDef that) {
        return forPreTransformerDef(that);
    }

    public RetType forTemplateGapNamedTransformerDef(TemplateGapNamedTransformerDef that) {
        return forNamedTransformerDef(that);
    }

    public RetType forTemplateGapTransformer(TemplateGapTransformer that) {
        return forTransformer(that);
    }

    public RetType forTemplateGapUnparsedTransformer(TemplateGapUnparsedTransformer that) {
        return forUnparsedTransformer(that);
    }

    public RetType forTemplateGapNodeTransformer(TemplateGapNodeTransformer that) {
        return forNodeTransformer(that);
    }

    public RetType forTemplateGapCaseTransformer(TemplateGapCaseTransformer that) {
        return forCaseTransformer(that);
    }

    public RetType forTemplateGapCaseTransformerClause(TemplateGapCaseTransformerClause that) {
        return forCaseTransformerClause(that);
    }

    public RetType forTemplateGapSyntaxSymbol(TemplateGapSyntaxSymbol that) {
        return forSyntaxSymbol(that);
    }

    public RetType forTemplateGapPrefixedSymbol(TemplateGapPrefixedSymbol that) {
        return forPrefixedSymbol(that);
    }

    public RetType forTemplateGapOptionalSymbol(TemplateGapOptionalSymbol that) {
        return forOptionalSymbol(that);
    }

    public RetType forTemplateGapRepeatSymbol(TemplateGapRepeatSymbol that) {
        return forRepeatSymbol(that);
    }

    public RetType forTemplateGapRepeatOneOrMoreSymbol(TemplateGapRepeatOneOrMoreSymbol that) {
        return forRepeatOneOrMoreSymbol(that);
    }

    public RetType forTemplateGapNoWhitespaceSymbol(TemplateGapNoWhitespaceSymbol that) {
        return forNoWhitespaceSymbol(that);
    }

    public RetType forTemplateGapGroupSymbol(TemplateGapGroupSymbol that) {
        return forGroupSymbol(that);
    }

    public RetType forTemplateGapSpecialSymbol(TemplateGapSpecialSymbol that) {
        return forSpecialSymbol(that);
    }

    public RetType forTemplateGapAnyCharacterSymbol(TemplateGapAnyCharacterSymbol that) {
        return forAnyCharacterSymbol(that);
    }

    public RetType forTemplateGapWhitespaceSymbol(TemplateGapWhitespaceSymbol that) {
        return forWhitespaceSymbol(that);
    }

    public RetType forTemplateGapTabSymbol(TemplateGapTabSymbol that) {
        return forTabSymbol(that);
    }

    public RetType forTemplateGapFormfeedSymbol(TemplateGapFormfeedSymbol that) {
        return forFormfeedSymbol(that);
    }

    public RetType forTemplateGapCarriageReturnSymbol(TemplateGapCarriageReturnSymbol that) {
        return forCarriageReturnSymbol(that);
    }

    public RetType forTemplateGapBackspaceSymbol(TemplateGapBackspaceSymbol that) {
        return forBackspaceSymbol(that);
    }

    public RetType forTemplateGapNewlineSymbol(TemplateGapNewlineSymbol that) {
        return forNewlineSymbol(that);
    }

    public RetType forTemplateGapBreaklineSymbol(TemplateGapBreaklineSymbol that) {
        return forBreaklineSymbol(that);
    }

    public RetType forTemplateGapItemSymbol(TemplateGapItemSymbol that) {
        return forItemSymbol(that);
    }

    public RetType forTemplateGapNonterminalSymbol(TemplateGapNonterminalSymbol that) {
        return forNonterminalSymbol(that);
    }

    public RetType forTemplateGapKeywordSymbol(TemplateGapKeywordSymbol that) {
        return forKeywordSymbol(that);
    }

    public RetType forTemplateGapTokenSymbol(TemplateGapTokenSymbol that) {
        return forTokenSymbol(that);
    }

    public RetType forTemplateGapNotPredicateSymbol(TemplateGapNotPredicateSymbol that) {
        return forNotPredicateSymbol(that);
    }

    public RetType forTemplateGapAndPredicateSymbol(TemplateGapAndPredicateSymbol that) {
        return forAndPredicateSymbol(that);
    }

    public RetType forTemplateGapCharacterClassSymbol(TemplateGapCharacterClassSymbol that) {
        return forCharacterClassSymbol(that);
    }

    public RetType forTemplateGapCharacterSymbol(TemplateGapCharacterSymbol that) {
        return forCharacterSymbol(that);
    }

    public RetType forTemplateGapCharSymbol(TemplateGapCharSymbol that) {
        return forCharSymbol(that);
    }

    public RetType forTemplateGapCharacterInterval(TemplateGapCharacterInterval that) {
        return forCharacterInterval(that);
    }

    public RetType forTemplateGapLink(TemplateGapLink that) {
        return forLink(that);
    }


}
