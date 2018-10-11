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
 ** This visitor implements the visitor interface with methods that 
 ** first call forCASEDoFirst(), second visit the children, and finally 
 ** call forCASEOnly().  (CASE is replaced by the case name.)
 ** By default, each of forCASEDoFirst and forCASEOnly delegates
 ** to a more general case.  At the top of this delegation tree are
 ** defaultDoFirst() and defaultCase(), respectively, which (unless
 ** overridden) are no-ops.
 **/
@SuppressWarnings("unused")
public class AbstractNodeDepthFirstVisitor_void extends AbstractNodeVisitorRunnable1 {
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, it is a no-op; subclasses may override this behavior.
    **/
    public void defaultCase(AbstractNode that) {}

    public void defaultTemplateGap(TemplateGap t){
        throw new RuntimeException("Please use TemplateDepthFirstVoidVisitor if you intend to visit template gaps, if not then a template gap survived longer than its expected life time.");
    }

    /**
     * This method is run for all DoFirst cases that are not handled elsewhere.
     * By default, it is a no-op; subclasses may override this behavior.
    **/
    public void defaultDoFirst(AbstractNode that) {}

    /* Methods to handle a node before recursion. */
    public void forAbstractNodeDoFirst(AbstractNode that) {
        defaultDoFirst(that);
    }

    public void forCompilationUnitDoFirst(CompilationUnit that) {
        forAbstractNodeDoFirst(that);
    }

    public void forComponentDoFirst(Component that) {
        forCompilationUnitDoFirst(that);
    }

    public void forApiDoFirst(Api that) {
        forCompilationUnitDoFirst(that);
    }

    public void forImportDoFirst(Import that) {
        forAbstractNodeDoFirst(that);
    }

    public void forImportedNamesDoFirst(ImportedNames that) {
        forImportDoFirst(that);
    }

    public void forImportStarDoFirst(ImportStar that) {
        forImportedNamesDoFirst(that);
    }

    public void forImportNamesDoFirst(ImportNames that) {
        forImportedNamesDoFirst(that);
    }

    public void forImportApiDoFirst(ImportApi that) {
        forImportDoFirst(that);
    }

    public void forAliasedSimpleNameDoFirst(AliasedSimpleName that) {
        forAbstractNodeDoFirst(that);
    }

    public void forAliasedAPINameDoFirst(AliasedAPIName that) {
        forAbstractNodeDoFirst(that);
    }

    public void forDeclDoFirst(Decl that) {
        forAbstractNodeDoFirst(that);
    }

    public void forTraitObjectDeclDoFirst(TraitObjectDecl that) {
        forDeclDoFirst(that);
    }

    public void forTraitDeclDoFirst(TraitDecl that) {
        forTraitObjectDeclDoFirst(that);
    }

    public void forObjectDeclDoFirst(ObjectDecl that) {
        forTraitObjectDeclDoFirst(that);
    }

    public void forVarDeclDoFirst(VarDecl that) {
        forDeclDoFirst(that);
    }

    public void forFnDeclDoFirst(FnDecl that) {
        forDeclDoFirst(that);
    }

    public void for_RewriteFnOverloadDeclDoFirst(_RewriteFnOverloadDecl that) {
        forDeclDoFirst(that);
    }

    public void for_RewriteObjectExprDeclDoFirst(_RewriteObjectExprDecl that) {
        forDeclDoFirst(that);
    }

    public void for_RewriteFunctionalMethodDeclDoFirst(_RewriteFunctionalMethodDecl that) {
        forDeclDoFirst(that);
    }

    public void forDimUnitDeclDoFirst(DimUnitDecl that) {
        forDeclDoFirst(that);
    }

    public void forDimDeclDoFirst(DimDecl that) {
        forDimUnitDeclDoFirst(that);
    }

    public void forUnitDeclDoFirst(UnitDecl that) {
        forDimUnitDeclDoFirst(that);
    }

    public void forTestDeclDoFirst(TestDecl that) {
        forDeclDoFirst(that);
    }

    public void forPropertyDeclDoFirst(PropertyDecl that) {
        forDeclDoFirst(that);
    }

    public void forTypeAliasDoFirst(TypeAlias that) {
        forDeclDoFirst(that);
    }

    public void forGrammarDeclDoFirst(GrammarDecl that) {
        forDeclDoFirst(that);
    }

    public void forGrammarMemberDeclDoFirst(GrammarMemberDecl that) {
        forDeclDoFirst(that);
    }

    public void forNonterminalDeclDoFirst(NonterminalDecl that) {
        forGrammarMemberDeclDoFirst(that);
    }

    public void forNonterminalDefDoFirst(NonterminalDef that) {
        forNonterminalDeclDoFirst(that);
    }

    public void forNonterminalExtensionDefDoFirst(NonterminalExtensionDef that) {
        forNonterminalDeclDoFirst(that);
    }

    public void forBindingDoFirst(Binding that) {
        forAbstractNodeDoFirst(that);
    }

    public void forLValueDoFirst(LValue that) {
        forBindingDoFirst(that);
    }

    public void forParamDoFirst(Param that) {
        forBindingDoFirst(that);
    }

    public void forExprDoFirst(Expr that) {
        forAbstractNodeDoFirst(that);
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

    public void forTypeDoFirst(Type that) {
        forAbstractNodeDoFirst(that);
    }

    public void forBaseTypeDoFirst(BaseType that) {
        forTypeDoFirst(that);
    }

    public void forAnyTypeDoFirst(AnyType that) {
        forBaseTypeDoFirst(that);
    }

    public void forBottomTypeDoFirst(BottomType that) {
        forBaseTypeDoFirst(that);
    }

    public void forUnknownTypeDoFirst(UnknownType that) {
        forBaseTypeDoFirst(that);
    }

    public void forSelfTypeDoFirst(SelfType that) {
        forBaseTypeDoFirst(that);
    }

    public void forTraitSelfTypeDoFirst(TraitSelfType that) {
        forSelfTypeDoFirst(that);
    }

    public void forObjectExprTypeDoFirst(ObjectExprType that) {
        forSelfTypeDoFirst(that);
    }

    public void forNamedTypeDoFirst(NamedType that) {
        forBaseTypeDoFirst(that);
    }

    public void for_InferenceVarTypeDoFirst(_InferenceVarType that) {
        forNamedTypeDoFirst(that);
    }

    public void forVarTypeDoFirst(VarType that) {
        forNamedTypeDoFirst(that);
    }

    public void forTraitTypeDoFirst(TraitType that) {
        forNamedTypeDoFirst(that);
    }

    public void forAbbreviatedTypeDoFirst(AbbreviatedType that) {
        forBaseTypeDoFirst(that);
    }

    public void forArrayTypeDoFirst(ArrayType that) {
        forAbbreviatedTypeDoFirst(that);
    }

    public void forMatrixTypeDoFirst(MatrixType that) {
        forAbbreviatedTypeDoFirst(that);
    }

    public void forTaggedDimTypeDoFirst(TaggedDimType that) {
        forAbbreviatedTypeDoFirst(that);
    }

    public void forTaggedUnitTypeDoFirst(TaggedUnitType that) {
        forAbbreviatedTypeDoFirst(that);
    }

    public void forTupleTypeDoFirst(TupleType that) {
        forTypeDoFirst(that);
    }

    public void forArrowTypeDoFirst(ArrowType that) {
        forTypeDoFirst(that);
    }

    public void forBoundTypeDoFirst(BoundType that) {
        forTypeDoFirst(that);
    }

    public void forIntersectionTypeDoFirst(IntersectionType that) {
        forBoundTypeDoFirst(that);
    }

    public void forUnionTypeDoFirst(UnionType that) {
        forBoundTypeDoFirst(that);
    }

    public void forFixedPointTypeDoFirst(FixedPointType that) {
        forTypeDoFirst(that);
    }

    public void forLabelTypeDoFirst(LabelType that) {
        forTypeDoFirst(that);
    }

    public void forDimExprDoFirst(DimExpr that) {
        forTypeDoFirst(that);
    }

    public void forDimBaseDoFirst(DimBase that) {
        forDimExprDoFirst(that);
    }

    public void forDimRefDoFirst(DimRef that) {
        forDimExprDoFirst(that);
    }

    public void forDimExponentDoFirst(DimExponent that) {
        forDimExprDoFirst(that);
    }

    public void forDimUnaryOpDoFirst(DimUnaryOp that) {
        forDimExprDoFirst(that);
    }

    public void forDimBinaryOpDoFirst(DimBinaryOp that) {
        forDimExprDoFirst(that);
    }

    public void forPatternDoFirst(Pattern that) {
        forAbstractNodeDoFirst(that);
    }

    public void forPatternArgsDoFirst(PatternArgs that) {
        forAbstractNodeDoFirst(that);
    }

    public void forPatternBindingDoFirst(PatternBinding that) {
        forAbstractNodeDoFirst(that);
    }

    public void forPlainPatternDoFirst(PlainPattern that) {
        forPatternBindingDoFirst(that);
    }

    public void forTypePatternDoFirst(TypePattern that) {
        forPatternBindingDoFirst(that);
    }

    public void forNestedPatternDoFirst(NestedPattern that) {
        forPatternBindingDoFirst(that);
    }

    public void forStaticArgDoFirst(StaticArg that) {
        forAbstractNodeDoFirst(that);
    }

    public void forTypeArgDoFirst(TypeArg that) {
        forStaticArgDoFirst(that);
    }

    public void forIntArgDoFirst(IntArg that) {
        forStaticArgDoFirst(that);
    }

    public void forBoolArgDoFirst(BoolArg that) {
        forStaticArgDoFirst(that);
    }

    public void forOpArgDoFirst(OpArg that) {
        forStaticArgDoFirst(that);
    }

    public void forDimArgDoFirst(DimArg that) {
        forStaticArgDoFirst(that);
    }

    public void forUnitArgDoFirst(UnitArg that) {
        forStaticArgDoFirst(that);
    }

    public void forStaticExprDoFirst(StaticExpr that) {
        forAbstractNodeDoFirst(that);
    }

    public void forIntExprDoFirst(IntExpr that) {
        forStaticExprDoFirst(that);
    }

    public void forIntBaseDoFirst(IntBase that) {
        forIntExprDoFirst(that);
    }

    public void forIntRefDoFirst(IntRef that) {
        forIntExprDoFirst(that);
    }

    public void forIntBinaryOpDoFirst(IntBinaryOp that) {
        forIntExprDoFirst(that);
    }

    public void forBoolExprDoFirst(BoolExpr that) {
        forStaticExprDoFirst(that);
    }

    public void forBoolBaseDoFirst(BoolBase that) {
        forBoolExprDoFirst(that);
    }

    public void forBoolRefDoFirst(BoolRef that) {
        forBoolExprDoFirst(that);
    }

    public void forBoolConstraintDoFirst(BoolConstraint that) {
        forBoolExprDoFirst(that);
    }

    public void forBoolUnaryOpDoFirst(BoolUnaryOp that) {
        forBoolConstraintDoFirst(that);
    }

    public void forBoolBinaryOpDoFirst(BoolBinaryOp that) {
        forBoolConstraintDoFirst(that);
    }

    public void forUnitExprDoFirst(UnitExpr that) {
        forStaticExprDoFirst(that);
    }

    public void forUnitRefDoFirst(UnitRef that) {
        forUnitExprDoFirst(that);
    }

    public void forUnitBinaryOpDoFirst(UnitBinaryOp that) {
        forUnitExprDoFirst(that);
    }

    public void forEffectDoFirst(Effect that) {
        forAbstractNodeDoFirst(that);
    }

    public void forWhereClauseDoFirst(WhereClause that) {
        forAbstractNodeDoFirst(that);
    }

    public void forWhereBindingDoFirst(WhereBinding that) {
        forAbstractNodeDoFirst(that);
    }

    public void forWhereConstraintDoFirst(WhereConstraint that) {
        forAbstractNodeDoFirst(that);
    }

    public void forWhereExtendsDoFirst(WhereExtends that) {
        forWhereConstraintDoFirst(that);
    }

    public void forWhereTypeAliasDoFirst(WhereTypeAlias that) {
        forWhereConstraintDoFirst(that);
    }

    public void forWhereCoercesDoFirst(WhereCoerces that) {
        forWhereConstraintDoFirst(that);
    }

    public void forWhereEqualsDoFirst(WhereEquals that) {
        forWhereConstraintDoFirst(that);
    }

    public void forUnitConstraintDoFirst(UnitConstraint that) {
        forWhereConstraintDoFirst(that);
    }

    public void forIntConstraintDoFirst(IntConstraint that) {
        forWhereConstraintDoFirst(that);
    }

    public void forBoolConstraintExprDoFirst(BoolConstraintExpr that) {
        forWhereConstraintDoFirst(that);
    }

    public void forContractDoFirst(Contract that) {
        forAbstractNodeDoFirst(that);
    }

    public void forEnsuresClauseDoFirst(EnsuresClause that) {
        forAbstractNodeDoFirst(that);
    }

    public void forStaticParamDoFirst(StaticParam that) {
        forAbstractNodeDoFirst(that);
    }

    public void forNameDoFirst(Name that) {
        forAbstractNodeDoFirst(that);
    }

    public void forAPINameDoFirst(APIName that) {
        forNameDoFirst(that);
    }

    public void forIdOrOpOrAnonymousNameDoFirst(IdOrOpOrAnonymousName that) {
        forNameDoFirst(that);
    }

    public void forIdOrOpDoFirst(IdOrOp that) {
        forIdOrOpOrAnonymousNameDoFirst(that);
    }

    public void forIdDoFirst(Id that) {
        forIdOrOpDoFirst(that);
    }

    public void forOpDoFirst(Op that) {
        forIdOrOpDoFirst(that);
    }

    public void forNamedOpDoFirst(NamedOp that) {
        forOpDoFirst(that);
    }

    public void for_InferenceVarOpDoFirst(_InferenceVarOp that) {
        forOpDoFirst(that);
    }

    public void forAnonymousNameDoFirst(AnonymousName that) {
        forIdOrOpOrAnonymousNameDoFirst(that);
    }

    public void forAnonymousFnNameDoFirst(AnonymousFnName that) {
        forAnonymousNameDoFirst(that);
    }

    public void forConstructorFnNameDoFirst(ConstructorFnName that) {
        forAnonymousNameDoFirst(that);
    }

    public void forArrayComprehensionClauseDoFirst(ArrayComprehensionClause that) {
        forAbstractNodeDoFirst(that);
    }

    public void forKeywordExprDoFirst(KeywordExpr that) {
        forAbstractNodeDoFirst(that);
    }

    public void forCaseClauseDoFirst(CaseClause that) {
        forAbstractNodeDoFirst(that);
    }

    public void forCatchDoFirst(Catch that) {
        forAbstractNodeDoFirst(that);
    }

    public void forCatchClauseDoFirst(CatchClause that) {
        forAbstractNodeDoFirst(that);
    }

    public void forIfClauseDoFirst(IfClause that) {
        forAbstractNodeDoFirst(that);
    }

    public void forTypecaseClauseDoFirst(TypecaseClause that) {
        forAbstractNodeDoFirst(that);
    }

    public void forExtentRangeDoFirst(ExtentRange that) {
        forAbstractNodeDoFirst(that);
    }

    public void forGeneratorClauseDoFirst(GeneratorClause that) {
        forAbstractNodeDoFirst(that);
    }

    public void forKeywordTypeDoFirst(KeywordType that) {
        forAbstractNodeDoFirst(that);
    }

    public void forTraitTypeWhereDoFirst(TraitTypeWhere that) {
        forAbstractNodeDoFirst(that);
    }

    public void forIndicesDoFirst(Indices that) {
        forAbstractNodeDoFirst(that);
    }

    public void forMathItemDoFirst(MathItem that) {
        forAbstractNodeDoFirst(that);
    }

    public void forExprMIDoFirst(ExprMI that) {
        forMathItemDoFirst(that);
    }

    public void forParenthesisDelimitedMIDoFirst(ParenthesisDelimitedMI that) {
        forExprMIDoFirst(that);
    }

    public void forNonParenthesisDelimitedMIDoFirst(NonParenthesisDelimitedMI that) {
        forExprMIDoFirst(that);
    }

    public void forNonExprMIDoFirst(NonExprMI that) {
        forMathItemDoFirst(that);
    }

    public void forExponentiationMIDoFirst(ExponentiationMI that) {
        forNonExprMIDoFirst(that);
    }

    public void forSubscriptingMIDoFirst(SubscriptingMI that) {
        forNonExprMIDoFirst(that);
    }

    public void forOverloadingDoFirst(Overloading that) {
        forAbstractNodeDoFirst(that);
    }

    public void forNonterminalHeaderDoFirst(NonterminalHeader that) {
        forAbstractNodeDoFirst(that);
    }

    public void forNonterminalParameterDoFirst(NonterminalParameter that) {
        forAbstractNodeDoFirst(that);
    }

    public void forSyntaxDeclDoFirst(SyntaxDecl that) {
        forAbstractNodeDoFirst(that);
    }

    public void forSyntaxDefDoFirst(SyntaxDef that) {
        forSyntaxDeclDoFirst(that);
    }

    public void forSuperSyntaxDefDoFirst(SuperSyntaxDef that) {
        forSyntaxDeclDoFirst(that);
    }

    public void forTransformerDeclDoFirst(TransformerDecl that) {
        forAbstractNodeDoFirst(that);
    }

    public void forPreTransformerDefDoFirst(PreTransformerDef that) {
        forTransformerDeclDoFirst(that);
    }

    public void forNamedTransformerDefDoFirst(NamedTransformerDef that) {
        forTransformerDeclDoFirst(that);
    }

    public void forTransformerDoFirst(Transformer that) {
        forAbstractNodeDoFirst(that);
    }

    public void forUnparsedTransformerDoFirst(UnparsedTransformer that) {
        forTransformerDoFirst(that);
    }

    public void forNodeTransformerDoFirst(NodeTransformer that) {
        forTransformerDoFirst(that);
    }

    public void forCaseTransformerDoFirst(CaseTransformer that) {
        forTransformerDoFirst(that);
    }

    public void forCaseTransformerClauseDoFirst(CaseTransformerClause that) {
        forAbstractNodeDoFirst(that);
    }

    public void forSyntaxSymbolDoFirst(SyntaxSymbol that) {
        forAbstractNodeDoFirst(that);
    }

    public void forPrefixedSymbolDoFirst(PrefixedSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void forOptionalSymbolDoFirst(OptionalSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void forRepeatSymbolDoFirst(RepeatSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void forRepeatOneOrMoreSymbolDoFirst(RepeatOneOrMoreSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void forNoWhitespaceSymbolDoFirst(NoWhitespaceSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void forGroupSymbolDoFirst(GroupSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void forSpecialSymbolDoFirst(SpecialSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void forAnyCharacterSymbolDoFirst(AnyCharacterSymbol that) {
        forSpecialSymbolDoFirst(that);
    }

    public void forWhitespaceSymbolDoFirst(WhitespaceSymbol that) {
        forSpecialSymbolDoFirst(that);
    }

    public void forTabSymbolDoFirst(TabSymbol that) {
        forSpecialSymbolDoFirst(that);
    }

    public void forFormfeedSymbolDoFirst(FormfeedSymbol that) {
        forSpecialSymbolDoFirst(that);
    }

    public void forCarriageReturnSymbolDoFirst(CarriageReturnSymbol that) {
        forSpecialSymbolDoFirst(that);
    }

    public void forBackspaceSymbolDoFirst(BackspaceSymbol that) {
        forSpecialSymbolDoFirst(that);
    }

    public void forNewlineSymbolDoFirst(NewlineSymbol that) {
        forSpecialSymbolDoFirst(that);
    }

    public void forBreaklineSymbolDoFirst(BreaklineSymbol that) {
        forSpecialSymbolDoFirst(that);
    }

    public void forItemSymbolDoFirst(ItemSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void forNonterminalSymbolDoFirst(NonterminalSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void forKeywordSymbolDoFirst(KeywordSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void forTokenSymbolDoFirst(TokenSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void forNotPredicateSymbolDoFirst(NotPredicateSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void forAndPredicateSymbolDoFirst(AndPredicateSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void forCharacterClassSymbolDoFirst(CharacterClassSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void forCharacterSymbolDoFirst(CharacterSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void forCharSymbolDoFirst(CharSymbol that) {
        forCharacterSymbolDoFirst(that);
    }

    public void forCharacterIntervalDoFirst(CharacterInterval that) {
        forCharacterSymbolDoFirst(that);
    }

    public void forLinkDoFirst(Link that) {
        forAbstractNodeDoFirst(that);
    }

    public void for_SyntaxTransformationAbstractNodeDoFirst(_SyntaxTransformationAbstractNode that) {
        forAbstractNodeDoFirst(that);
    }

    public void for_SyntaxTransformationCompilationUnitDoFirst(_SyntaxTransformationCompilationUnit that) {
        forCompilationUnitDoFirst(that);
    }

    public void for_SyntaxTransformationComponentDoFirst(_SyntaxTransformationComponent that) {
        forComponentDoFirst(that);
    }

    public void for_SyntaxTransformationApiDoFirst(_SyntaxTransformationApi that) {
        forApiDoFirst(that);
    }

    public void for_SyntaxTransformationImportDoFirst(_SyntaxTransformationImport that) {
        forImportDoFirst(that);
    }

    public void for_SyntaxTransformationImportedNamesDoFirst(_SyntaxTransformationImportedNames that) {
        forImportedNamesDoFirst(that);
    }

    public void for_SyntaxTransformationImportStarDoFirst(_SyntaxTransformationImportStar that) {
        forImportStarDoFirst(that);
    }

    public void for_SyntaxTransformationImportNamesDoFirst(_SyntaxTransformationImportNames that) {
        forImportNamesDoFirst(that);
    }

    public void for_SyntaxTransformationImportApiDoFirst(_SyntaxTransformationImportApi that) {
        forImportApiDoFirst(that);
    }

    public void for_SyntaxTransformationAliasedSimpleNameDoFirst(_SyntaxTransformationAliasedSimpleName that) {
        forAliasedSimpleNameDoFirst(that);
    }

    public void for_SyntaxTransformationAliasedAPINameDoFirst(_SyntaxTransformationAliasedAPIName that) {
        forAliasedAPINameDoFirst(that);
    }

    public void for_SyntaxTransformationDeclDoFirst(_SyntaxTransformationDecl that) {
        forDeclDoFirst(that);
    }

    public void for_SyntaxTransformationTraitObjectDeclDoFirst(_SyntaxTransformationTraitObjectDecl that) {
        forTraitObjectDeclDoFirst(that);
    }

    public void for_SyntaxTransformationTraitDeclDoFirst(_SyntaxTransformationTraitDecl that) {
        forTraitDeclDoFirst(that);
    }

    public void for_SyntaxTransformationObjectDeclDoFirst(_SyntaxTransformationObjectDecl that) {
        forObjectDeclDoFirst(that);
    }

    public void for_SyntaxTransformationVarDeclDoFirst(_SyntaxTransformationVarDecl that) {
        forVarDeclDoFirst(that);
    }

    public void for_SyntaxTransformationFnDeclDoFirst(_SyntaxTransformationFnDecl that) {
        forFnDeclDoFirst(that);
    }

    public void for_SyntaxTransformation_RewriteFnOverloadDeclDoFirst(_SyntaxTransformation_RewriteFnOverloadDecl that) {
        for_RewriteFnOverloadDeclDoFirst(that);
    }

    public void for_SyntaxTransformation_RewriteObjectExprDeclDoFirst(_SyntaxTransformation_RewriteObjectExprDecl that) {
        for_RewriteObjectExprDeclDoFirst(that);
    }

    public void for_SyntaxTransformation_RewriteFunctionalMethodDeclDoFirst(_SyntaxTransformation_RewriteFunctionalMethodDecl that) {
        for_RewriteFunctionalMethodDeclDoFirst(that);
    }

    public void for_SyntaxTransformationDimUnitDeclDoFirst(_SyntaxTransformationDimUnitDecl that) {
        forDimUnitDeclDoFirst(that);
    }

    public void for_SyntaxTransformationDimDeclDoFirst(_SyntaxTransformationDimDecl that) {
        forDimDeclDoFirst(that);
    }

    public void for_SyntaxTransformationUnitDeclDoFirst(_SyntaxTransformationUnitDecl that) {
        forUnitDeclDoFirst(that);
    }

    public void for_SyntaxTransformationTestDeclDoFirst(_SyntaxTransformationTestDecl that) {
        forTestDeclDoFirst(that);
    }

    public void for_SyntaxTransformationPropertyDeclDoFirst(_SyntaxTransformationPropertyDecl that) {
        forPropertyDeclDoFirst(that);
    }

    public void for_SyntaxTransformationTypeAliasDoFirst(_SyntaxTransformationTypeAlias that) {
        forTypeAliasDoFirst(that);
    }

    public void for_SyntaxTransformationGrammarDeclDoFirst(_SyntaxTransformationGrammarDecl that) {
        forGrammarDeclDoFirst(that);
    }

    public void for_SyntaxTransformationGrammarMemberDeclDoFirst(_SyntaxTransformationGrammarMemberDecl that) {
        forGrammarMemberDeclDoFirst(that);
    }

    public void for_SyntaxTransformationNonterminalDeclDoFirst(_SyntaxTransformationNonterminalDecl that) {
        forNonterminalDeclDoFirst(that);
    }

    public void for_SyntaxTransformationNonterminalDefDoFirst(_SyntaxTransformationNonterminalDef that) {
        forNonterminalDefDoFirst(that);
    }

    public void for_SyntaxTransformationNonterminalExtensionDefDoFirst(_SyntaxTransformationNonterminalExtensionDef that) {
        forNonterminalExtensionDefDoFirst(that);
    }

    public void for_SyntaxTransformationBindingDoFirst(_SyntaxTransformationBinding that) {
        forBindingDoFirst(that);
    }

    public void for_SyntaxTransformationLValueDoFirst(_SyntaxTransformationLValue that) {
        forLValueDoFirst(that);
    }

    public void for_SyntaxTransformationParamDoFirst(_SyntaxTransformationParam that) {
        forParamDoFirst(that);
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

    public void for_SyntaxTransformationTypeDoFirst(_SyntaxTransformationType that) {
        forTypeDoFirst(that);
    }

    public void for_SyntaxTransformationBaseTypeDoFirst(_SyntaxTransformationBaseType that) {
        forBaseTypeDoFirst(that);
    }

    public void for_SyntaxTransformationAnyTypeDoFirst(_SyntaxTransformationAnyType that) {
        forAnyTypeDoFirst(that);
    }

    public void for_SyntaxTransformationBottomTypeDoFirst(_SyntaxTransformationBottomType that) {
        forBottomTypeDoFirst(that);
    }

    public void for_SyntaxTransformationUnknownTypeDoFirst(_SyntaxTransformationUnknownType that) {
        forUnknownTypeDoFirst(that);
    }

    public void for_SyntaxTransformationSelfTypeDoFirst(_SyntaxTransformationSelfType that) {
        forSelfTypeDoFirst(that);
    }

    public void for_SyntaxTransformationTraitSelfTypeDoFirst(_SyntaxTransformationTraitSelfType that) {
        forTraitSelfTypeDoFirst(that);
    }

    public void for_SyntaxTransformationObjectExprTypeDoFirst(_SyntaxTransformationObjectExprType that) {
        forObjectExprTypeDoFirst(that);
    }

    public void for_SyntaxTransformationNamedTypeDoFirst(_SyntaxTransformationNamedType that) {
        forNamedTypeDoFirst(that);
    }

    public void for_SyntaxTransformation_InferenceVarTypeDoFirst(_SyntaxTransformation_InferenceVarType that) {
        for_InferenceVarTypeDoFirst(that);
    }

    public void for_SyntaxTransformationVarTypeDoFirst(_SyntaxTransformationVarType that) {
        forVarTypeDoFirst(that);
    }

    public void for_SyntaxTransformationTraitTypeDoFirst(_SyntaxTransformationTraitType that) {
        forTraitTypeDoFirst(that);
    }

    public void for_SyntaxTransformationAbbreviatedTypeDoFirst(_SyntaxTransformationAbbreviatedType that) {
        forAbbreviatedTypeDoFirst(that);
    }

    public void for_SyntaxTransformationArrayTypeDoFirst(_SyntaxTransformationArrayType that) {
        forArrayTypeDoFirst(that);
    }

    public void for_SyntaxTransformationMatrixTypeDoFirst(_SyntaxTransformationMatrixType that) {
        forMatrixTypeDoFirst(that);
    }

    public void for_SyntaxTransformationTaggedDimTypeDoFirst(_SyntaxTransformationTaggedDimType that) {
        forTaggedDimTypeDoFirst(that);
    }

    public void for_SyntaxTransformationTaggedUnitTypeDoFirst(_SyntaxTransformationTaggedUnitType that) {
        forTaggedUnitTypeDoFirst(that);
    }

    public void for_SyntaxTransformationTupleTypeDoFirst(_SyntaxTransformationTupleType that) {
        forTupleTypeDoFirst(that);
    }

    public void for_SyntaxTransformationArrowTypeDoFirst(_SyntaxTransformationArrowType that) {
        forArrowTypeDoFirst(that);
    }

    public void for_SyntaxTransformationBoundTypeDoFirst(_SyntaxTransformationBoundType that) {
        forBoundTypeDoFirst(that);
    }

    public void for_SyntaxTransformationIntersectionTypeDoFirst(_SyntaxTransformationIntersectionType that) {
        forIntersectionTypeDoFirst(that);
    }

    public void for_SyntaxTransformationUnionTypeDoFirst(_SyntaxTransformationUnionType that) {
        forUnionTypeDoFirst(that);
    }

    public void for_SyntaxTransformationFixedPointTypeDoFirst(_SyntaxTransformationFixedPointType that) {
        forFixedPointTypeDoFirst(that);
    }

    public void for_SyntaxTransformationLabelTypeDoFirst(_SyntaxTransformationLabelType that) {
        forLabelTypeDoFirst(that);
    }

    public void for_SyntaxTransformationDimExprDoFirst(_SyntaxTransformationDimExpr that) {
        forDimExprDoFirst(that);
    }

    public void for_SyntaxTransformationDimBaseDoFirst(_SyntaxTransformationDimBase that) {
        forDimBaseDoFirst(that);
    }

    public void for_SyntaxTransformationDimRefDoFirst(_SyntaxTransformationDimRef that) {
        forDimRefDoFirst(that);
    }

    public void for_SyntaxTransformationDimExponentDoFirst(_SyntaxTransformationDimExponent that) {
        forDimExponentDoFirst(that);
    }

    public void for_SyntaxTransformationDimUnaryOpDoFirst(_SyntaxTransformationDimUnaryOp that) {
        forDimUnaryOpDoFirst(that);
    }

    public void for_SyntaxTransformationDimBinaryOpDoFirst(_SyntaxTransformationDimBinaryOp that) {
        forDimBinaryOpDoFirst(that);
    }

    public void for_SyntaxTransformationPatternDoFirst(_SyntaxTransformationPattern that) {
        forPatternDoFirst(that);
    }

    public void for_SyntaxTransformationPatternArgsDoFirst(_SyntaxTransformationPatternArgs that) {
        forPatternArgsDoFirst(that);
    }

    public void for_SyntaxTransformationPatternBindingDoFirst(_SyntaxTransformationPatternBinding that) {
        forPatternBindingDoFirst(that);
    }

    public void for_SyntaxTransformationPlainPatternDoFirst(_SyntaxTransformationPlainPattern that) {
        forPlainPatternDoFirst(that);
    }

    public void for_SyntaxTransformationTypePatternDoFirst(_SyntaxTransformationTypePattern that) {
        forTypePatternDoFirst(that);
    }

    public void for_SyntaxTransformationNestedPatternDoFirst(_SyntaxTransformationNestedPattern that) {
        forNestedPatternDoFirst(that);
    }

    public void for_SyntaxTransformationStaticArgDoFirst(_SyntaxTransformationStaticArg that) {
        forStaticArgDoFirst(that);
    }

    public void for_SyntaxTransformationTypeArgDoFirst(_SyntaxTransformationTypeArg that) {
        forTypeArgDoFirst(that);
    }

    public void for_SyntaxTransformationIntArgDoFirst(_SyntaxTransformationIntArg that) {
        forIntArgDoFirst(that);
    }

    public void for_SyntaxTransformationBoolArgDoFirst(_SyntaxTransformationBoolArg that) {
        forBoolArgDoFirst(that);
    }

    public void for_SyntaxTransformationOpArgDoFirst(_SyntaxTransformationOpArg that) {
        forOpArgDoFirst(that);
    }

    public void for_SyntaxTransformationDimArgDoFirst(_SyntaxTransformationDimArg that) {
        forDimArgDoFirst(that);
    }

    public void for_SyntaxTransformationUnitArgDoFirst(_SyntaxTransformationUnitArg that) {
        forUnitArgDoFirst(that);
    }

    public void for_SyntaxTransformationStaticExprDoFirst(_SyntaxTransformationStaticExpr that) {
        forStaticExprDoFirst(that);
    }

    public void for_SyntaxTransformationIntExprDoFirst(_SyntaxTransformationIntExpr that) {
        forIntExprDoFirst(that);
    }

    public void for_SyntaxTransformationIntBaseDoFirst(_SyntaxTransformationIntBase that) {
        forIntBaseDoFirst(that);
    }

    public void for_SyntaxTransformationIntRefDoFirst(_SyntaxTransformationIntRef that) {
        forIntRefDoFirst(that);
    }

    public void for_SyntaxTransformationIntBinaryOpDoFirst(_SyntaxTransformationIntBinaryOp that) {
        forIntBinaryOpDoFirst(that);
    }

    public void for_SyntaxTransformationBoolExprDoFirst(_SyntaxTransformationBoolExpr that) {
        forBoolExprDoFirst(that);
    }

    public void for_SyntaxTransformationBoolBaseDoFirst(_SyntaxTransformationBoolBase that) {
        forBoolBaseDoFirst(that);
    }

    public void for_SyntaxTransformationBoolRefDoFirst(_SyntaxTransformationBoolRef that) {
        forBoolRefDoFirst(that);
    }

    public void for_SyntaxTransformationBoolConstraintDoFirst(_SyntaxTransformationBoolConstraint that) {
        forBoolConstraintDoFirst(that);
    }

    public void for_SyntaxTransformationBoolUnaryOpDoFirst(_SyntaxTransformationBoolUnaryOp that) {
        forBoolUnaryOpDoFirst(that);
    }

    public void for_SyntaxTransformationBoolBinaryOpDoFirst(_SyntaxTransformationBoolBinaryOp that) {
        forBoolBinaryOpDoFirst(that);
    }

    public void for_SyntaxTransformationUnitExprDoFirst(_SyntaxTransformationUnitExpr that) {
        forUnitExprDoFirst(that);
    }

    public void for_SyntaxTransformationUnitRefDoFirst(_SyntaxTransformationUnitRef that) {
        forUnitRefDoFirst(that);
    }

    public void for_SyntaxTransformationUnitBinaryOpDoFirst(_SyntaxTransformationUnitBinaryOp that) {
        forUnitBinaryOpDoFirst(that);
    }

    public void for_SyntaxTransformationEffectDoFirst(_SyntaxTransformationEffect that) {
        forEffectDoFirst(that);
    }

    public void for_SyntaxTransformationWhereClauseDoFirst(_SyntaxTransformationWhereClause that) {
        forWhereClauseDoFirst(that);
    }

    public void for_SyntaxTransformationWhereBindingDoFirst(_SyntaxTransformationWhereBinding that) {
        forWhereBindingDoFirst(that);
    }

    public void for_SyntaxTransformationWhereConstraintDoFirst(_SyntaxTransformationWhereConstraint that) {
        forWhereConstraintDoFirst(that);
    }

    public void for_SyntaxTransformationWhereExtendsDoFirst(_SyntaxTransformationWhereExtends that) {
        forWhereExtendsDoFirst(that);
    }

    public void for_SyntaxTransformationWhereTypeAliasDoFirst(_SyntaxTransformationWhereTypeAlias that) {
        forWhereTypeAliasDoFirst(that);
    }

    public void for_SyntaxTransformationWhereCoercesDoFirst(_SyntaxTransformationWhereCoerces that) {
        forWhereCoercesDoFirst(that);
    }

    public void for_SyntaxTransformationWhereEqualsDoFirst(_SyntaxTransformationWhereEquals that) {
        forWhereEqualsDoFirst(that);
    }

    public void for_SyntaxTransformationUnitConstraintDoFirst(_SyntaxTransformationUnitConstraint that) {
        forUnitConstraintDoFirst(that);
    }

    public void for_SyntaxTransformationIntConstraintDoFirst(_SyntaxTransformationIntConstraint that) {
        forIntConstraintDoFirst(that);
    }

    public void for_SyntaxTransformationBoolConstraintExprDoFirst(_SyntaxTransformationBoolConstraintExpr that) {
        forBoolConstraintExprDoFirst(that);
    }

    public void for_SyntaxTransformationContractDoFirst(_SyntaxTransformationContract that) {
        forContractDoFirst(that);
    }

    public void for_SyntaxTransformationEnsuresClauseDoFirst(_SyntaxTransformationEnsuresClause that) {
        forEnsuresClauseDoFirst(that);
    }

    public void for_SyntaxTransformationStaticParamDoFirst(_SyntaxTransformationStaticParam that) {
        forStaticParamDoFirst(that);
    }

    public void for_SyntaxTransformationNameDoFirst(_SyntaxTransformationName that) {
        forNameDoFirst(that);
    }

    public void for_SyntaxTransformationAPINameDoFirst(_SyntaxTransformationAPIName that) {
        forAPINameDoFirst(that);
    }

    public void for_SyntaxTransformationIdOrOpOrAnonymousNameDoFirst(_SyntaxTransformationIdOrOpOrAnonymousName that) {
        forIdOrOpOrAnonymousNameDoFirst(that);
    }

    public void for_SyntaxTransformationIdOrOpDoFirst(_SyntaxTransformationIdOrOp that) {
        forIdOrOpDoFirst(that);
    }

    public void for_SyntaxTransformationIdDoFirst(_SyntaxTransformationId that) {
        forIdDoFirst(that);
    }

    public void for_SyntaxTransformationOpDoFirst(_SyntaxTransformationOp that) {
        forOpDoFirst(that);
    }

    public void for_SyntaxTransformationNamedOpDoFirst(_SyntaxTransformationNamedOp that) {
        forNamedOpDoFirst(that);
    }

    public void for_SyntaxTransformation_InferenceVarOpDoFirst(_SyntaxTransformation_InferenceVarOp that) {
        for_InferenceVarOpDoFirst(that);
    }

    public void for_SyntaxTransformationAnonymousNameDoFirst(_SyntaxTransformationAnonymousName that) {
        forAnonymousNameDoFirst(that);
    }

    public void for_SyntaxTransformationAnonymousFnNameDoFirst(_SyntaxTransformationAnonymousFnName that) {
        forAnonymousFnNameDoFirst(that);
    }

    public void for_SyntaxTransformationConstructorFnNameDoFirst(_SyntaxTransformationConstructorFnName that) {
        forConstructorFnNameDoFirst(that);
    }

    public void for_SyntaxTransformationArrayComprehensionClauseDoFirst(_SyntaxTransformationArrayComprehensionClause that) {
        forArrayComprehensionClauseDoFirst(that);
    }

    public void for_SyntaxTransformationKeywordExprDoFirst(_SyntaxTransformationKeywordExpr that) {
        forKeywordExprDoFirst(that);
    }

    public void for_SyntaxTransformationCaseClauseDoFirst(_SyntaxTransformationCaseClause that) {
        forCaseClauseDoFirst(that);
    }

    public void for_SyntaxTransformationCatchDoFirst(_SyntaxTransformationCatch that) {
        forCatchDoFirst(that);
    }

    public void for_SyntaxTransformationCatchClauseDoFirst(_SyntaxTransformationCatchClause that) {
        forCatchClauseDoFirst(that);
    }

    public void for_SyntaxTransformationIfClauseDoFirst(_SyntaxTransformationIfClause that) {
        forIfClauseDoFirst(that);
    }

    public void for_SyntaxTransformationTypecaseClauseDoFirst(_SyntaxTransformationTypecaseClause that) {
        forTypecaseClauseDoFirst(that);
    }

    public void for_SyntaxTransformationExtentRangeDoFirst(_SyntaxTransformationExtentRange that) {
        forExtentRangeDoFirst(that);
    }

    public void for_SyntaxTransformationGeneratorClauseDoFirst(_SyntaxTransformationGeneratorClause that) {
        forGeneratorClauseDoFirst(that);
    }

    public void for_SyntaxTransformationKeywordTypeDoFirst(_SyntaxTransformationKeywordType that) {
        forKeywordTypeDoFirst(that);
    }

    public void for_SyntaxTransformationTraitTypeWhereDoFirst(_SyntaxTransformationTraitTypeWhere that) {
        forTraitTypeWhereDoFirst(that);
    }

    public void for_SyntaxTransformationIndicesDoFirst(_SyntaxTransformationIndices that) {
        forIndicesDoFirst(that);
    }

    public void for_SyntaxTransformationMathItemDoFirst(_SyntaxTransformationMathItem that) {
        forMathItemDoFirst(that);
    }

    public void for_SyntaxTransformationExprMIDoFirst(_SyntaxTransformationExprMI that) {
        forExprMIDoFirst(that);
    }

    public void for_SyntaxTransformationParenthesisDelimitedMIDoFirst(_SyntaxTransformationParenthesisDelimitedMI that) {
        forParenthesisDelimitedMIDoFirst(that);
    }

    public void for_SyntaxTransformationNonParenthesisDelimitedMIDoFirst(_SyntaxTransformationNonParenthesisDelimitedMI that) {
        forNonParenthesisDelimitedMIDoFirst(that);
    }

    public void for_SyntaxTransformationNonExprMIDoFirst(_SyntaxTransformationNonExprMI that) {
        forNonExprMIDoFirst(that);
    }

    public void for_SyntaxTransformationExponentiationMIDoFirst(_SyntaxTransformationExponentiationMI that) {
        forExponentiationMIDoFirst(that);
    }

    public void for_SyntaxTransformationSubscriptingMIDoFirst(_SyntaxTransformationSubscriptingMI that) {
        forSubscriptingMIDoFirst(that);
    }

    public void for_SyntaxTransformationOverloadingDoFirst(_SyntaxTransformationOverloading that) {
        forOverloadingDoFirst(that);
    }

    public void for_SyntaxTransformationNonterminalHeaderDoFirst(_SyntaxTransformationNonterminalHeader that) {
        forNonterminalHeaderDoFirst(that);
    }

    public void for_SyntaxTransformationNonterminalParameterDoFirst(_SyntaxTransformationNonterminalParameter that) {
        forNonterminalParameterDoFirst(that);
    }

    public void for_SyntaxTransformationSyntaxDeclDoFirst(_SyntaxTransformationSyntaxDecl that) {
        forSyntaxDeclDoFirst(that);
    }

    public void for_SyntaxTransformationSyntaxDefDoFirst(_SyntaxTransformationSyntaxDef that) {
        forSyntaxDefDoFirst(that);
    }

    public void for_SyntaxTransformationSuperSyntaxDefDoFirst(_SyntaxTransformationSuperSyntaxDef that) {
        forSuperSyntaxDefDoFirst(that);
    }

    public void for_SyntaxTransformationTransformerDeclDoFirst(_SyntaxTransformationTransformerDecl that) {
        forTransformerDeclDoFirst(that);
    }

    public void for_SyntaxTransformationPreTransformerDefDoFirst(_SyntaxTransformationPreTransformerDef that) {
        forPreTransformerDefDoFirst(that);
    }

    public void for_SyntaxTransformationNamedTransformerDefDoFirst(_SyntaxTransformationNamedTransformerDef that) {
        forNamedTransformerDefDoFirst(that);
    }

    public void for_SyntaxTransformationTransformerDoFirst(_SyntaxTransformationTransformer that) {
        forTransformerDoFirst(that);
    }

    public void for_SyntaxTransformationUnparsedTransformerDoFirst(_SyntaxTransformationUnparsedTransformer that) {
        forUnparsedTransformerDoFirst(that);
    }

    public void for_SyntaxTransformationNodeTransformerDoFirst(_SyntaxTransformationNodeTransformer that) {
        forNodeTransformerDoFirst(that);
    }

    public void for_SyntaxTransformationCaseTransformerDoFirst(_SyntaxTransformationCaseTransformer that) {
        forCaseTransformerDoFirst(that);
    }

    public void for_SyntaxTransformationCaseTransformerClauseDoFirst(_SyntaxTransformationCaseTransformerClause that) {
        forCaseTransformerClauseDoFirst(that);
    }

    public void for_SyntaxTransformationSyntaxSymbolDoFirst(_SyntaxTransformationSyntaxSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationPrefixedSymbolDoFirst(_SyntaxTransformationPrefixedSymbol that) {
        forPrefixedSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationOptionalSymbolDoFirst(_SyntaxTransformationOptionalSymbol that) {
        forOptionalSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationRepeatSymbolDoFirst(_SyntaxTransformationRepeatSymbol that) {
        forRepeatSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationRepeatOneOrMoreSymbolDoFirst(_SyntaxTransformationRepeatOneOrMoreSymbol that) {
        forRepeatOneOrMoreSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationNoWhitespaceSymbolDoFirst(_SyntaxTransformationNoWhitespaceSymbol that) {
        forNoWhitespaceSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationGroupSymbolDoFirst(_SyntaxTransformationGroupSymbol that) {
        forGroupSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationSpecialSymbolDoFirst(_SyntaxTransformationSpecialSymbol that) {
        forSpecialSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationAnyCharacterSymbolDoFirst(_SyntaxTransformationAnyCharacterSymbol that) {
        forAnyCharacterSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationWhitespaceSymbolDoFirst(_SyntaxTransformationWhitespaceSymbol that) {
        forWhitespaceSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationTabSymbolDoFirst(_SyntaxTransformationTabSymbol that) {
        forTabSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationFormfeedSymbolDoFirst(_SyntaxTransformationFormfeedSymbol that) {
        forFormfeedSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationCarriageReturnSymbolDoFirst(_SyntaxTransformationCarriageReturnSymbol that) {
        forCarriageReturnSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationBackspaceSymbolDoFirst(_SyntaxTransformationBackspaceSymbol that) {
        forBackspaceSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationNewlineSymbolDoFirst(_SyntaxTransformationNewlineSymbol that) {
        forNewlineSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationBreaklineSymbolDoFirst(_SyntaxTransformationBreaklineSymbol that) {
        forBreaklineSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationItemSymbolDoFirst(_SyntaxTransformationItemSymbol that) {
        forItemSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationNonterminalSymbolDoFirst(_SyntaxTransformationNonterminalSymbol that) {
        forNonterminalSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationKeywordSymbolDoFirst(_SyntaxTransformationKeywordSymbol that) {
        forKeywordSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationTokenSymbolDoFirst(_SyntaxTransformationTokenSymbol that) {
        forTokenSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationNotPredicateSymbolDoFirst(_SyntaxTransformationNotPredicateSymbol that) {
        forNotPredicateSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationAndPredicateSymbolDoFirst(_SyntaxTransformationAndPredicateSymbol that) {
        forAndPredicateSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationCharacterClassSymbolDoFirst(_SyntaxTransformationCharacterClassSymbol that) {
        forCharacterClassSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationCharacterSymbolDoFirst(_SyntaxTransformationCharacterSymbol that) {
        forCharacterSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationCharSymbolDoFirst(_SyntaxTransformationCharSymbol that) {
        forCharSymbolDoFirst(that);
    }

    public void for_SyntaxTransformationCharacterIntervalDoFirst(_SyntaxTransformationCharacterInterval that) {
        forCharacterIntervalDoFirst(that);
    }

    public void for_SyntaxTransformationLinkDoFirst(_SyntaxTransformationLink that) {
        forLinkDoFirst(that);
    }

    public void for_EllipsesAbstractNodeDoFirst(_EllipsesAbstractNode that) {
        forAbstractNodeDoFirst(that);
    }

    public void for_EllipsesCompilationUnitDoFirst(_EllipsesCompilationUnit that) {
        forCompilationUnitDoFirst(that);
    }

    public void for_EllipsesComponentDoFirst(_EllipsesComponent that) {
        forComponentDoFirst(that);
    }

    public void for_EllipsesApiDoFirst(_EllipsesApi that) {
        forApiDoFirst(that);
    }

    public void for_EllipsesImportDoFirst(_EllipsesImport that) {
        forImportDoFirst(that);
    }

    public void for_EllipsesImportedNamesDoFirst(_EllipsesImportedNames that) {
        forImportedNamesDoFirst(that);
    }

    public void for_EllipsesImportStarDoFirst(_EllipsesImportStar that) {
        forImportStarDoFirst(that);
    }

    public void for_EllipsesImportNamesDoFirst(_EllipsesImportNames that) {
        forImportNamesDoFirst(that);
    }

    public void for_EllipsesImportApiDoFirst(_EllipsesImportApi that) {
        forImportApiDoFirst(that);
    }

    public void for_EllipsesAliasedSimpleNameDoFirst(_EllipsesAliasedSimpleName that) {
        forAliasedSimpleNameDoFirst(that);
    }

    public void for_EllipsesAliasedAPINameDoFirst(_EllipsesAliasedAPIName that) {
        forAliasedAPINameDoFirst(that);
    }

    public void for_EllipsesDeclDoFirst(_EllipsesDecl that) {
        forDeclDoFirst(that);
    }

    public void for_EllipsesTraitObjectDeclDoFirst(_EllipsesTraitObjectDecl that) {
        forTraitObjectDeclDoFirst(that);
    }

    public void for_EllipsesTraitDeclDoFirst(_EllipsesTraitDecl that) {
        forTraitDeclDoFirst(that);
    }

    public void for_EllipsesObjectDeclDoFirst(_EllipsesObjectDecl that) {
        forObjectDeclDoFirst(that);
    }

    public void for_EllipsesVarDeclDoFirst(_EllipsesVarDecl that) {
        forVarDeclDoFirst(that);
    }

    public void for_EllipsesFnDeclDoFirst(_EllipsesFnDecl that) {
        forFnDeclDoFirst(that);
    }

    public void for_Ellipses_RewriteFnOverloadDeclDoFirst(_Ellipses_RewriteFnOverloadDecl that) {
        for_RewriteFnOverloadDeclDoFirst(that);
    }

    public void for_Ellipses_RewriteObjectExprDeclDoFirst(_Ellipses_RewriteObjectExprDecl that) {
        for_RewriteObjectExprDeclDoFirst(that);
    }

    public void for_Ellipses_RewriteFunctionalMethodDeclDoFirst(_Ellipses_RewriteFunctionalMethodDecl that) {
        for_RewriteFunctionalMethodDeclDoFirst(that);
    }

    public void for_EllipsesDimUnitDeclDoFirst(_EllipsesDimUnitDecl that) {
        forDimUnitDeclDoFirst(that);
    }

    public void for_EllipsesDimDeclDoFirst(_EllipsesDimDecl that) {
        forDimDeclDoFirst(that);
    }

    public void for_EllipsesUnitDeclDoFirst(_EllipsesUnitDecl that) {
        forUnitDeclDoFirst(that);
    }

    public void for_EllipsesTestDeclDoFirst(_EllipsesTestDecl that) {
        forTestDeclDoFirst(that);
    }

    public void for_EllipsesPropertyDeclDoFirst(_EllipsesPropertyDecl that) {
        forPropertyDeclDoFirst(that);
    }

    public void for_EllipsesTypeAliasDoFirst(_EllipsesTypeAlias that) {
        forTypeAliasDoFirst(that);
    }

    public void for_EllipsesGrammarDeclDoFirst(_EllipsesGrammarDecl that) {
        forGrammarDeclDoFirst(that);
    }

    public void for_EllipsesGrammarMemberDeclDoFirst(_EllipsesGrammarMemberDecl that) {
        forGrammarMemberDeclDoFirst(that);
    }

    public void for_EllipsesNonterminalDeclDoFirst(_EllipsesNonterminalDecl that) {
        forNonterminalDeclDoFirst(that);
    }

    public void for_EllipsesNonterminalDefDoFirst(_EllipsesNonterminalDef that) {
        forNonterminalDefDoFirst(that);
    }

    public void for_EllipsesNonterminalExtensionDefDoFirst(_EllipsesNonterminalExtensionDef that) {
        forNonterminalExtensionDefDoFirst(that);
    }

    public void for_EllipsesBindingDoFirst(_EllipsesBinding that) {
        forBindingDoFirst(that);
    }

    public void for_EllipsesLValueDoFirst(_EllipsesLValue that) {
        forLValueDoFirst(that);
    }

    public void for_EllipsesParamDoFirst(_EllipsesParam that) {
        forParamDoFirst(that);
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

    public void for_EllipsesTypeDoFirst(_EllipsesType that) {
        forTypeDoFirst(that);
    }

    public void for_EllipsesBaseTypeDoFirst(_EllipsesBaseType that) {
        forBaseTypeDoFirst(that);
    }

    public void for_EllipsesAnyTypeDoFirst(_EllipsesAnyType that) {
        forAnyTypeDoFirst(that);
    }

    public void for_EllipsesBottomTypeDoFirst(_EllipsesBottomType that) {
        forBottomTypeDoFirst(that);
    }

    public void for_EllipsesUnknownTypeDoFirst(_EllipsesUnknownType that) {
        forUnknownTypeDoFirst(that);
    }

    public void for_EllipsesSelfTypeDoFirst(_EllipsesSelfType that) {
        forSelfTypeDoFirst(that);
    }

    public void for_EllipsesTraitSelfTypeDoFirst(_EllipsesTraitSelfType that) {
        forTraitSelfTypeDoFirst(that);
    }

    public void for_EllipsesObjectExprTypeDoFirst(_EllipsesObjectExprType that) {
        forObjectExprTypeDoFirst(that);
    }

    public void for_EllipsesNamedTypeDoFirst(_EllipsesNamedType that) {
        forNamedTypeDoFirst(that);
    }

    public void for_Ellipses_InferenceVarTypeDoFirst(_Ellipses_InferenceVarType that) {
        for_InferenceVarTypeDoFirst(that);
    }

    public void for_EllipsesVarTypeDoFirst(_EllipsesVarType that) {
        forVarTypeDoFirst(that);
    }

    public void for_EllipsesTraitTypeDoFirst(_EllipsesTraitType that) {
        forTraitTypeDoFirst(that);
    }

    public void for_EllipsesAbbreviatedTypeDoFirst(_EllipsesAbbreviatedType that) {
        forAbbreviatedTypeDoFirst(that);
    }

    public void for_EllipsesArrayTypeDoFirst(_EllipsesArrayType that) {
        forArrayTypeDoFirst(that);
    }

    public void for_EllipsesMatrixTypeDoFirst(_EllipsesMatrixType that) {
        forMatrixTypeDoFirst(that);
    }

    public void for_EllipsesTaggedDimTypeDoFirst(_EllipsesTaggedDimType that) {
        forTaggedDimTypeDoFirst(that);
    }

    public void for_EllipsesTaggedUnitTypeDoFirst(_EllipsesTaggedUnitType that) {
        forTaggedUnitTypeDoFirst(that);
    }

    public void for_EllipsesTupleTypeDoFirst(_EllipsesTupleType that) {
        forTupleTypeDoFirst(that);
    }

    public void for_EllipsesArrowTypeDoFirst(_EllipsesArrowType that) {
        forArrowTypeDoFirst(that);
    }

    public void for_EllipsesBoundTypeDoFirst(_EllipsesBoundType that) {
        forBoundTypeDoFirst(that);
    }

    public void for_EllipsesIntersectionTypeDoFirst(_EllipsesIntersectionType that) {
        forIntersectionTypeDoFirst(that);
    }

    public void for_EllipsesUnionTypeDoFirst(_EllipsesUnionType that) {
        forUnionTypeDoFirst(that);
    }

    public void for_EllipsesFixedPointTypeDoFirst(_EllipsesFixedPointType that) {
        forFixedPointTypeDoFirst(that);
    }

    public void for_EllipsesLabelTypeDoFirst(_EllipsesLabelType that) {
        forLabelTypeDoFirst(that);
    }

    public void for_EllipsesDimExprDoFirst(_EllipsesDimExpr that) {
        forDimExprDoFirst(that);
    }

    public void for_EllipsesDimBaseDoFirst(_EllipsesDimBase that) {
        forDimBaseDoFirst(that);
    }

    public void for_EllipsesDimRefDoFirst(_EllipsesDimRef that) {
        forDimRefDoFirst(that);
    }

    public void for_EllipsesDimExponentDoFirst(_EllipsesDimExponent that) {
        forDimExponentDoFirst(that);
    }

    public void for_EllipsesDimUnaryOpDoFirst(_EllipsesDimUnaryOp that) {
        forDimUnaryOpDoFirst(that);
    }

    public void for_EllipsesDimBinaryOpDoFirst(_EllipsesDimBinaryOp that) {
        forDimBinaryOpDoFirst(that);
    }

    public void for_EllipsesPatternDoFirst(_EllipsesPattern that) {
        forPatternDoFirst(that);
    }

    public void for_EllipsesPatternArgsDoFirst(_EllipsesPatternArgs that) {
        forPatternArgsDoFirst(that);
    }

    public void for_EllipsesPatternBindingDoFirst(_EllipsesPatternBinding that) {
        forPatternBindingDoFirst(that);
    }

    public void for_EllipsesPlainPatternDoFirst(_EllipsesPlainPattern that) {
        forPlainPatternDoFirst(that);
    }

    public void for_EllipsesTypePatternDoFirst(_EllipsesTypePattern that) {
        forTypePatternDoFirst(that);
    }

    public void for_EllipsesNestedPatternDoFirst(_EllipsesNestedPattern that) {
        forNestedPatternDoFirst(that);
    }

    public void for_EllipsesStaticArgDoFirst(_EllipsesStaticArg that) {
        forStaticArgDoFirst(that);
    }

    public void for_EllipsesTypeArgDoFirst(_EllipsesTypeArg that) {
        forTypeArgDoFirst(that);
    }

    public void for_EllipsesIntArgDoFirst(_EllipsesIntArg that) {
        forIntArgDoFirst(that);
    }

    public void for_EllipsesBoolArgDoFirst(_EllipsesBoolArg that) {
        forBoolArgDoFirst(that);
    }

    public void for_EllipsesOpArgDoFirst(_EllipsesOpArg that) {
        forOpArgDoFirst(that);
    }

    public void for_EllipsesDimArgDoFirst(_EllipsesDimArg that) {
        forDimArgDoFirst(that);
    }

    public void for_EllipsesUnitArgDoFirst(_EllipsesUnitArg that) {
        forUnitArgDoFirst(that);
    }

    public void for_EllipsesStaticExprDoFirst(_EllipsesStaticExpr that) {
        forStaticExprDoFirst(that);
    }

    public void for_EllipsesIntExprDoFirst(_EllipsesIntExpr that) {
        forIntExprDoFirst(that);
    }

    public void for_EllipsesIntBaseDoFirst(_EllipsesIntBase that) {
        forIntBaseDoFirst(that);
    }

    public void for_EllipsesIntRefDoFirst(_EllipsesIntRef that) {
        forIntRefDoFirst(that);
    }

    public void for_EllipsesIntBinaryOpDoFirst(_EllipsesIntBinaryOp that) {
        forIntBinaryOpDoFirst(that);
    }

    public void for_EllipsesBoolExprDoFirst(_EllipsesBoolExpr that) {
        forBoolExprDoFirst(that);
    }

    public void for_EllipsesBoolBaseDoFirst(_EllipsesBoolBase that) {
        forBoolBaseDoFirst(that);
    }

    public void for_EllipsesBoolRefDoFirst(_EllipsesBoolRef that) {
        forBoolRefDoFirst(that);
    }

    public void for_EllipsesBoolConstraintDoFirst(_EllipsesBoolConstraint that) {
        forBoolConstraintDoFirst(that);
    }

    public void for_EllipsesBoolUnaryOpDoFirst(_EllipsesBoolUnaryOp that) {
        forBoolUnaryOpDoFirst(that);
    }

    public void for_EllipsesBoolBinaryOpDoFirst(_EllipsesBoolBinaryOp that) {
        forBoolBinaryOpDoFirst(that);
    }

    public void for_EllipsesUnitExprDoFirst(_EllipsesUnitExpr that) {
        forUnitExprDoFirst(that);
    }

    public void for_EllipsesUnitRefDoFirst(_EllipsesUnitRef that) {
        forUnitRefDoFirst(that);
    }

    public void for_EllipsesUnitBinaryOpDoFirst(_EllipsesUnitBinaryOp that) {
        forUnitBinaryOpDoFirst(that);
    }

    public void for_EllipsesEffectDoFirst(_EllipsesEffect that) {
        forEffectDoFirst(that);
    }

    public void for_EllipsesWhereClauseDoFirst(_EllipsesWhereClause that) {
        forWhereClauseDoFirst(that);
    }

    public void for_EllipsesWhereBindingDoFirst(_EllipsesWhereBinding that) {
        forWhereBindingDoFirst(that);
    }

    public void for_EllipsesWhereConstraintDoFirst(_EllipsesWhereConstraint that) {
        forWhereConstraintDoFirst(that);
    }

    public void for_EllipsesWhereExtendsDoFirst(_EllipsesWhereExtends that) {
        forWhereExtendsDoFirst(that);
    }

    public void for_EllipsesWhereTypeAliasDoFirst(_EllipsesWhereTypeAlias that) {
        forWhereTypeAliasDoFirst(that);
    }

    public void for_EllipsesWhereCoercesDoFirst(_EllipsesWhereCoerces that) {
        forWhereCoercesDoFirst(that);
    }

    public void for_EllipsesWhereEqualsDoFirst(_EllipsesWhereEquals that) {
        forWhereEqualsDoFirst(that);
    }

    public void for_EllipsesUnitConstraintDoFirst(_EllipsesUnitConstraint that) {
        forUnitConstraintDoFirst(that);
    }

    public void for_EllipsesIntConstraintDoFirst(_EllipsesIntConstraint that) {
        forIntConstraintDoFirst(that);
    }

    public void for_EllipsesBoolConstraintExprDoFirst(_EllipsesBoolConstraintExpr that) {
        forBoolConstraintExprDoFirst(that);
    }

    public void for_EllipsesContractDoFirst(_EllipsesContract that) {
        forContractDoFirst(that);
    }

    public void for_EllipsesEnsuresClauseDoFirst(_EllipsesEnsuresClause that) {
        forEnsuresClauseDoFirst(that);
    }

    public void for_EllipsesStaticParamDoFirst(_EllipsesStaticParam that) {
        forStaticParamDoFirst(that);
    }

    public void for_EllipsesNameDoFirst(_EllipsesName that) {
        forNameDoFirst(that);
    }

    public void for_EllipsesAPINameDoFirst(_EllipsesAPIName that) {
        forAPINameDoFirst(that);
    }

    public void for_EllipsesIdOrOpOrAnonymousNameDoFirst(_EllipsesIdOrOpOrAnonymousName that) {
        forIdOrOpOrAnonymousNameDoFirst(that);
    }

    public void for_EllipsesIdOrOpDoFirst(_EllipsesIdOrOp that) {
        forIdOrOpDoFirst(that);
    }

    public void for_EllipsesIdDoFirst(_EllipsesId that) {
        forIdDoFirst(that);
    }

    public void for_EllipsesOpDoFirst(_EllipsesOp that) {
        forOpDoFirst(that);
    }

    public void for_EllipsesNamedOpDoFirst(_EllipsesNamedOp that) {
        forNamedOpDoFirst(that);
    }

    public void for_Ellipses_InferenceVarOpDoFirst(_Ellipses_InferenceVarOp that) {
        for_InferenceVarOpDoFirst(that);
    }

    public void for_EllipsesAnonymousNameDoFirst(_EllipsesAnonymousName that) {
        forAnonymousNameDoFirst(that);
    }

    public void for_EllipsesAnonymousFnNameDoFirst(_EllipsesAnonymousFnName that) {
        forAnonymousFnNameDoFirst(that);
    }

    public void for_EllipsesConstructorFnNameDoFirst(_EllipsesConstructorFnName that) {
        forConstructorFnNameDoFirst(that);
    }

    public void for_EllipsesArrayComprehensionClauseDoFirst(_EllipsesArrayComprehensionClause that) {
        forArrayComprehensionClauseDoFirst(that);
    }

    public void for_EllipsesKeywordExprDoFirst(_EllipsesKeywordExpr that) {
        forKeywordExprDoFirst(that);
    }

    public void for_EllipsesCaseClauseDoFirst(_EllipsesCaseClause that) {
        forCaseClauseDoFirst(that);
    }

    public void for_EllipsesCatchDoFirst(_EllipsesCatch that) {
        forCatchDoFirst(that);
    }

    public void for_EllipsesCatchClauseDoFirst(_EllipsesCatchClause that) {
        forCatchClauseDoFirst(that);
    }

    public void for_EllipsesIfClauseDoFirst(_EllipsesIfClause that) {
        forIfClauseDoFirst(that);
    }

    public void for_EllipsesTypecaseClauseDoFirst(_EllipsesTypecaseClause that) {
        forTypecaseClauseDoFirst(that);
    }

    public void for_EllipsesExtentRangeDoFirst(_EllipsesExtentRange that) {
        forExtentRangeDoFirst(that);
    }

    public void for_EllipsesGeneratorClauseDoFirst(_EllipsesGeneratorClause that) {
        forGeneratorClauseDoFirst(that);
    }

    public void for_EllipsesKeywordTypeDoFirst(_EllipsesKeywordType that) {
        forKeywordTypeDoFirst(that);
    }

    public void for_EllipsesTraitTypeWhereDoFirst(_EllipsesTraitTypeWhere that) {
        forTraitTypeWhereDoFirst(that);
    }

    public void for_EllipsesIndicesDoFirst(_EllipsesIndices that) {
        forIndicesDoFirst(that);
    }

    public void for_EllipsesMathItemDoFirst(_EllipsesMathItem that) {
        forMathItemDoFirst(that);
    }

    public void for_EllipsesExprMIDoFirst(_EllipsesExprMI that) {
        forExprMIDoFirst(that);
    }

    public void for_EllipsesParenthesisDelimitedMIDoFirst(_EllipsesParenthesisDelimitedMI that) {
        forParenthesisDelimitedMIDoFirst(that);
    }

    public void for_EllipsesNonParenthesisDelimitedMIDoFirst(_EllipsesNonParenthesisDelimitedMI that) {
        forNonParenthesisDelimitedMIDoFirst(that);
    }

    public void for_EllipsesNonExprMIDoFirst(_EllipsesNonExprMI that) {
        forNonExprMIDoFirst(that);
    }

    public void for_EllipsesExponentiationMIDoFirst(_EllipsesExponentiationMI that) {
        forExponentiationMIDoFirst(that);
    }

    public void for_EllipsesSubscriptingMIDoFirst(_EllipsesSubscriptingMI that) {
        forSubscriptingMIDoFirst(that);
    }

    public void for_EllipsesOverloadingDoFirst(_EllipsesOverloading that) {
        forOverloadingDoFirst(that);
    }

    public void for_EllipsesNonterminalHeaderDoFirst(_EllipsesNonterminalHeader that) {
        forNonterminalHeaderDoFirst(that);
    }

    public void for_EllipsesNonterminalParameterDoFirst(_EllipsesNonterminalParameter that) {
        forNonterminalParameterDoFirst(that);
    }

    public void for_EllipsesSyntaxDeclDoFirst(_EllipsesSyntaxDecl that) {
        forSyntaxDeclDoFirst(that);
    }

    public void for_EllipsesSyntaxDefDoFirst(_EllipsesSyntaxDef that) {
        forSyntaxDefDoFirst(that);
    }

    public void for_EllipsesSuperSyntaxDefDoFirst(_EllipsesSuperSyntaxDef that) {
        forSuperSyntaxDefDoFirst(that);
    }

    public void for_EllipsesTransformerDeclDoFirst(_EllipsesTransformerDecl that) {
        forTransformerDeclDoFirst(that);
    }

    public void for_EllipsesPreTransformerDefDoFirst(_EllipsesPreTransformerDef that) {
        forPreTransformerDefDoFirst(that);
    }

    public void for_EllipsesNamedTransformerDefDoFirst(_EllipsesNamedTransformerDef that) {
        forNamedTransformerDefDoFirst(that);
    }

    public void for_EllipsesTransformerDoFirst(_EllipsesTransformer that) {
        forTransformerDoFirst(that);
    }

    public void for_EllipsesUnparsedTransformerDoFirst(_EllipsesUnparsedTransformer that) {
        forUnparsedTransformerDoFirst(that);
    }

    public void for_EllipsesNodeTransformerDoFirst(_EllipsesNodeTransformer that) {
        forNodeTransformerDoFirst(that);
    }

    public void for_EllipsesCaseTransformerDoFirst(_EllipsesCaseTransformer that) {
        forCaseTransformerDoFirst(that);
    }

    public void for_EllipsesCaseTransformerClauseDoFirst(_EllipsesCaseTransformerClause that) {
        forCaseTransformerClauseDoFirst(that);
    }

    public void for_EllipsesSyntaxSymbolDoFirst(_EllipsesSyntaxSymbol that) {
        forSyntaxSymbolDoFirst(that);
    }

    public void for_EllipsesPrefixedSymbolDoFirst(_EllipsesPrefixedSymbol that) {
        forPrefixedSymbolDoFirst(that);
    }

    public void for_EllipsesOptionalSymbolDoFirst(_EllipsesOptionalSymbol that) {
        forOptionalSymbolDoFirst(that);
    }

    public void for_EllipsesRepeatSymbolDoFirst(_EllipsesRepeatSymbol that) {
        forRepeatSymbolDoFirst(that);
    }

    public void for_EllipsesRepeatOneOrMoreSymbolDoFirst(_EllipsesRepeatOneOrMoreSymbol that) {
        forRepeatOneOrMoreSymbolDoFirst(that);
    }

    public void for_EllipsesNoWhitespaceSymbolDoFirst(_EllipsesNoWhitespaceSymbol that) {
        forNoWhitespaceSymbolDoFirst(that);
    }

    public void for_EllipsesGroupSymbolDoFirst(_EllipsesGroupSymbol that) {
        forGroupSymbolDoFirst(that);
    }

    public void for_EllipsesSpecialSymbolDoFirst(_EllipsesSpecialSymbol that) {
        forSpecialSymbolDoFirst(that);
    }

    public void for_EllipsesAnyCharacterSymbolDoFirst(_EllipsesAnyCharacterSymbol that) {
        forAnyCharacterSymbolDoFirst(that);
    }

    public void for_EllipsesWhitespaceSymbolDoFirst(_EllipsesWhitespaceSymbol that) {
        forWhitespaceSymbolDoFirst(that);
    }

    public void for_EllipsesTabSymbolDoFirst(_EllipsesTabSymbol that) {
        forTabSymbolDoFirst(that);
    }

    public void for_EllipsesFormfeedSymbolDoFirst(_EllipsesFormfeedSymbol that) {
        forFormfeedSymbolDoFirst(that);
    }

    public void for_EllipsesCarriageReturnSymbolDoFirst(_EllipsesCarriageReturnSymbol that) {
        forCarriageReturnSymbolDoFirst(that);
    }

    public void for_EllipsesBackspaceSymbolDoFirst(_EllipsesBackspaceSymbol that) {
        forBackspaceSymbolDoFirst(that);
    }

    public void for_EllipsesNewlineSymbolDoFirst(_EllipsesNewlineSymbol that) {
        forNewlineSymbolDoFirst(that);
    }

    public void for_EllipsesBreaklineSymbolDoFirst(_EllipsesBreaklineSymbol that) {
        forBreaklineSymbolDoFirst(that);
    }

    public void for_EllipsesItemSymbolDoFirst(_EllipsesItemSymbol that) {
        forItemSymbolDoFirst(that);
    }

    public void for_EllipsesNonterminalSymbolDoFirst(_EllipsesNonterminalSymbol that) {
        forNonterminalSymbolDoFirst(that);
    }

    public void for_EllipsesKeywordSymbolDoFirst(_EllipsesKeywordSymbol that) {
        forKeywordSymbolDoFirst(that);
    }

    public void for_EllipsesTokenSymbolDoFirst(_EllipsesTokenSymbol that) {
        forTokenSymbolDoFirst(that);
    }

    public void for_EllipsesNotPredicateSymbolDoFirst(_EllipsesNotPredicateSymbol that) {
        forNotPredicateSymbolDoFirst(that);
    }

    public void for_EllipsesAndPredicateSymbolDoFirst(_EllipsesAndPredicateSymbol that) {
        forAndPredicateSymbolDoFirst(that);
    }

    public void for_EllipsesCharacterClassSymbolDoFirst(_EllipsesCharacterClassSymbol that) {
        forCharacterClassSymbolDoFirst(that);
    }

    public void for_EllipsesCharacterSymbolDoFirst(_EllipsesCharacterSymbol that) {
        forCharacterSymbolDoFirst(that);
    }

    public void for_EllipsesCharSymbolDoFirst(_EllipsesCharSymbol that) {
        forCharSymbolDoFirst(that);
    }

    public void for_EllipsesCharacterIntervalDoFirst(_EllipsesCharacterInterval that) {
        forCharacterIntervalDoFirst(that);
    }

    public void for_EllipsesLinkDoFirst(_EllipsesLink that) {
        forLinkDoFirst(that);
    }

    /* Methods to handle a node after recursion. */
    public void forAbstractNodeOnly(AbstractNode that) {
        defaultCase(that);
    }

    public void forCompilationUnitOnly(CompilationUnit that) {
        forAbstractNodeOnly(that);
    }

    public void forComponentOnly(Component that) {
        forCompilationUnitOnly(that);
    }

    public void forApiOnly(Api that) {
        forCompilationUnitOnly(that);
    }

    public void forImportOnly(Import that) {
        forAbstractNodeOnly(that);
    }

    public void forImportedNamesOnly(ImportedNames that) {
        forImportOnly(that);
    }

    public void forImportStarOnly(ImportStar that) {
        forImportedNamesOnly(that);
    }

    public void forImportNamesOnly(ImportNames that) {
        forImportedNamesOnly(that);
    }

    public void forImportApiOnly(ImportApi that) {
        forImportOnly(that);
    }

    public void forAliasedSimpleNameOnly(AliasedSimpleName that) {
        forAbstractNodeOnly(that);
    }

    public void forAliasedAPINameOnly(AliasedAPIName that) {
        forAbstractNodeOnly(that);
    }

    public void forDeclOnly(Decl that) {
        forAbstractNodeOnly(that);
    }

    public void forTraitObjectDeclOnly(TraitObjectDecl that) {
        forDeclOnly(that);
    }

    public void forTraitDeclOnly(TraitDecl that) {
        forTraitObjectDeclOnly(that);
    }

    public void forObjectDeclOnly(ObjectDecl that) {
        forTraitObjectDeclOnly(that);
    }

    public void forVarDeclOnly(VarDecl that) {
        forDeclOnly(that);
    }

    public void forFnDeclOnly(FnDecl that) {
        forDeclOnly(that);
    }

    public void for_RewriteFnOverloadDeclOnly(_RewriteFnOverloadDecl that) {
        forDeclOnly(that);
    }

    public void for_RewriteObjectExprDeclOnly(_RewriteObjectExprDecl that) {
        forDeclOnly(that);
    }

    public void for_RewriteFunctionalMethodDeclOnly(_RewriteFunctionalMethodDecl that) {
        forDeclOnly(that);
    }

    public void forDimUnitDeclOnly(DimUnitDecl that) {
        forDeclOnly(that);
    }

    public void forDimDeclOnly(DimDecl that) {
        forDimUnitDeclOnly(that);
    }

    public void forUnitDeclOnly(UnitDecl that) {
        forDimUnitDeclOnly(that);
    }

    public void forTestDeclOnly(TestDecl that) {
        forDeclOnly(that);
    }

    public void forPropertyDeclOnly(PropertyDecl that) {
        forDeclOnly(that);
    }

    public void forTypeAliasOnly(TypeAlias that) {
        forDeclOnly(that);
    }

    public void forGrammarDeclOnly(GrammarDecl that) {
        forDeclOnly(that);
    }

    public void forGrammarMemberDeclOnly(GrammarMemberDecl that) {
        forDeclOnly(that);
    }

    public void forNonterminalDeclOnly(NonterminalDecl that) {
        forGrammarMemberDeclOnly(that);
    }

    public void forNonterminalDefOnly(NonterminalDef that) {
        forNonterminalDeclOnly(that);
    }

    public void forNonterminalExtensionDefOnly(NonterminalExtensionDef that) {
        forNonterminalDeclOnly(that);
    }

    public void forBindingOnly(Binding that) {
        forAbstractNodeOnly(that);
    }

    public void forLValueOnly(LValue that) {
        forBindingOnly(that);
    }

    public void forParamOnly(Param that) {
        forBindingOnly(that);
    }

    public void forExprOnly(Expr that) {
        forAbstractNodeOnly(that);
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

    public void forTypeOnly(Type that) {
        forAbstractNodeOnly(that);
    }

    public void forBaseTypeOnly(BaseType that) {
        forTypeOnly(that);
    }

    public void forAnyTypeOnly(AnyType that) {
        forBaseTypeOnly(that);
    }

    public void forBottomTypeOnly(BottomType that) {
        forBaseTypeOnly(that);
    }

    public void forUnknownTypeOnly(UnknownType that) {
        forBaseTypeOnly(that);
    }

    public void forSelfTypeOnly(SelfType that) {
        forBaseTypeOnly(that);
    }

    public void forTraitSelfTypeOnly(TraitSelfType that) {
        forSelfTypeOnly(that);
    }

    public void forObjectExprTypeOnly(ObjectExprType that) {
        forSelfTypeOnly(that);
    }

    public void forNamedTypeOnly(NamedType that) {
        forBaseTypeOnly(that);
    }

    public void for_InferenceVarTypeOnly(_InferenceVarType that) {
        forNamedTypeOnly(that);
    }

    public void forVarTypeOnly(VarType that) {
        forNamedTypeOnly(that);
    }

    public void forTraitTypeOnly(TraitType that) {
        forNamedTypeOnly(that);
    }

    public void forAbbreviatedTypeOnly(AbbreviatedType that) {
        forBaseTypeOnly(that);
    }

    public void forArrayTypeOnly(ArrayType that) {
        forAbbreviatedTypeOnly(that);
    }

    public void forMatrixTypeOnly(MatrixType that) {
        forAbbreviatedTypeOnly(that);
    }

    public void forTaggedDimTypeOnly(TaggedDimType that) {
        forAbbreviatedTypeOnly(that);
    }

    public void forTaggedUnitTypeOnly(TaggedUnitType that) {
        forAbbreviatedTypeOnly(that);
    }

    public void forTupleTypeOnly(TupleType that) {
        forTypeOnly(that);
    }

    public void forArrowTypeOnly(ArrowType that) {
        forTypeOnly(that);
    }

    public void forBoundTypeOnly(BoundType that) {
        forTypeOnly(that);
    }

    public void forIntersectionTypeOnly(IntersectionType that) {
        forBoundTypeOnly(that);
    }

    public void forUnionTypeOnly(UnionType that) {
        forBoundTypeOnly(that);
    }

    public void forFixedPointTypeOnly(FixedPointType that) {
        forTypeOnly(that);
    }

    public void forLabelTypeOnly(LabelType that) {
        forTypeOnly(that);
    }

    public void forDimExprOnly(DimExpr that) {
        forTypeOnly(that);
    }

    public void forDimBaseOnly(DimBase that) {
        forDimExprOnly(that);
    }

    public void forDimRefOnly(DimRef that) {
        forDimExprOnly(that);
    }

    public void forDimExponentOnly(DimExponent that) {
        forDimExprOnly(that);
    }

    public void forDimUnaryOpOnly(DimUnaryOp that) {
        forDimExprOnly(that);
    }

    public void forDimBinaryOpOnly(DimBinaryOp that) {
        forDimExprOnly(that);
    }

    public void forPatternOnly(Pattern that) {
        forAbstractNodeOnly(that);
    }

    public void forPatternArgsOnly(PatternArgs that) {
        forAbstractNodeOnly(that);
    }

    public void forPatternBindingOnly(PatternBinding that) {
        forAbstractNodeOnly(that);
    }

    public void forPlainPatternOnly(PlainPattern that) {
        forPatternBindingOnly(that);
    }

    public void forTypePatternOnly(TypePattern that) {
        forPatternBindingOnly(that);
    }

    public void forNestedPatternOnly(NestedPattern that) {
        forPatternBindingOnly(that);
    }

    public void forStaticArgOnly(StaticArg that) {
        forAbstractNodeOnly(that);
    }

    public void forTypeArgOnly(TypeArg that) {
        forStaticArgOnly(that);
    }

    public void forIntArgOnly(IntArg that) {
        forStaticArgOnly(that);
    }

    public void forBoolArgOnly(BoolArg that) {
        forStaticArgOnly(that);
    }

    public void forOpArgOnly(OpArg that) {
        forStaticArgOnly(that);
    }

    public void forDimArgOnly(DimArg that) {
        forStaticArgOnly(that);
    }

    public void forUnitArgOnly(UnitArg that) {
        forStaticArgOnly(that);
    }

    public void forStaticExprOnly(StaticExpr that) {
        forAbstractNodeOnly(that);
    }

    public void forIntExprOnly(IntExpr that) {
        forStaticExprOnly(that);
    }

    public void forIntBaseOnly(IntBase that) {
        forIntExprOnly(that);
    }

    public void forIntRefOnly(IntRef that) {
        forIntExprOnly(that);
    }

    public void forIntBinaryOpOnly(IntBinaryOp that) {
        forIntExprOnly(that);
    }

    public void forBoolExprOnly(BoolExpr that) {
        forStaticExprOnly(that);
    }

    public void forBoolBaseOnly(BoolBase that) {
        forBoolExprOnly(that);
    }

    public void forBoolRefOnly(BoolRef that) {
        forBoolExprOnly(that);
    }

    public void forBoolConstraintOnly(BoolConstraint that) {
        forBoolExprOnly(that);
    }

    public void forBoolUnaryOpOnly(BoolUnaryOp that) {
        forBoolConstraintOnly(that);
    }

    public void forBoolBinaryOpOnly(BoolBinaryOp that) {
        forBoolConstraintOnly(that);
    }

    public void forUnitExprOnly(UnitExpr that) {
        forStaticExprOnly(that);
    }

    public void forUnitRefOnly(UnitRef that) {
        forUnitExprOnly(that);
    }

    public void forUnitBinaryOpOnly(UnitBinaryOp that) {
        forUnitExprOnly(that);
    }

    public void forEffectOnly(Effect that) {
        forAbstractNodeOnly(that);
    }

    public void forWhereClauseOnly(WhereClause that) {
        forAbstractNodeOnly(that);
    }

    public void forWhereBindingOnly(WhereBinding that) {
        forAbstractNodeOnly(that);
    }

    public void forWhereConstraintOnly(WhereConstraint that) {
        forAbstractNodeOnly(that);
    }

    public void forWhereExtendsOnly(WhereExtends that) {
        forWhereConstraintOnly(that);
    }

    public void forWhereTypeAliasOnly(WhereTypeAlias that) {
        forWhereConstraintOnly(that);
    }

    public void forWhereCoercesOnly(WhereCoerces that) {
        forWhereConstraintOnly(that);
    }

    public void forWhereEqualsOnly(WhereEquals that) {
        forWhereConstraintOnly(that);
    }

    public void forUnitConstraintOnly(UnitConstraint that) {
        forWhereConstraintOnly(that);
    }

    public void forIntConstraintOnly(IntConstraint that) {
        forWhereConstraintOnly(that);
    }

    public void forBoolConstraintExprOnly(BoolConstraintExpr that) {
        forWhereConstraintOnly(that);
    }

    public void forContractOnly(Contract that) {
        forAbstractNodeOnly(that);
    }

    public void forEnsuresClauseOnly(EnsuresClause that) {
        forAbstractNodeOnly(that);
    }

    public void forStaticParamOnly(StaticParam that) {
        forAbstractNodeOnly(that);
    }

    public void forNameOnly(Name that) {
        forAbstractNodeOnly(that);
    }

    public void forAPINameOnly(APIName that) {
        forNameOnly(that);
    }

    public void forIdOrOpOrAnonymousNameOnly(IdOrOpOrAnonymousName that) {
        forNameOnly(that);
    }

    public void forIdOrOpOnly(IdOrOp that) {
        forIdOrOpOrAnonymousNameOnly(that);
    }

    public void forIdOnly(Id that) {
        forIdOrOpOnly(that);
    }

    public void forOpOnly(Op that) {
        forIdOrOpOnly(that);
    }

    public void forNamedOpOnly(NamedOp that) {
        forOpOnly(that);
    }

    public void for_InferenceVarOpOnly(_InferenceVarOp that) {
        forOpOnly(that);
    }

    public void forAnonymousNameOnly(AnonymousName that) {
        forIdOrOpOrAnonymousNameOnly(that);
    }

    public void forAnonymousFnNameOnly(AnonymousFnName that) {
        forAnonymousNameOnly(that);
    }

    public void forConstructorFnNameOnly(ConstructorFnName that) {
        forAnonymousNameOnly(that);
    }

    public void forArrayComprehensionClauseOnly(ArrayComprehensionClause that) {
        forAbstractNodeOnly(that);
    }

    public void forKeywordExprOnly(KeywordExpr that) {
        forAbstractNodeOnly(that);
    }

    public void forCaseClauseOnly(CaseClause that) {
        forAbstractNodeOnly(that);
    }

    public void forCatchOnly(Catch that) {
        forAbstractNodeOnly(that);
    }

    public void forCatchClauseOnly(CatchClause that) {
        forAbstractNodeOnly(that);
    }

    public void forIfClauseOnly(IfClause that) {
        forAbstractNodeOnly(that);
    }

    public void forTypecaseClauseOnly(TypecaseClause that) {
        forAbstractNodeOnly(that);
    }

    public void forExtentRangeOnly(ExtentRange that) {
        forAbstractNodeOnly(that);
    }

    public void forGeneratorClauseOnly(GeneratorClause that) {
        forAbstractNodeOnly(that);
    }

    public void forKeywordTypeOnly(KeywordType that) {
        forAbstractNodeOnly(that);
    }

    public void forTraitTypeWhereOnly(TraitTypeWhere that) {
        forAbstractNodeOnly(that);
    }

    public void forIndicesOnly(Indices that) {
        forAbstractNodeOnly(that);
    }

    public void forMathItemOnly(MathItem that) {
        forAbstractNodeOnly(that);
    }

    public void forExprMIOnly(ExprMI that) {
        forMathItemOnly(that);
    }

    public void forParenthesisDelimitedMIOnly(ParenthesisDelimitedMI that) {
        forExprMIOnly(that);
    }

    public void forNonParenthesisDelimitedMIOnly(NonParenthesisDelimitedMI that) {
        forExprMIOnly(that);
    }

    public void forNonExprMIOnly(NonExprMI that) {
        forMathItemOnly(that);
    }

    public void forExponentiationMIOnly(ExponentiationMI that) {
        forNonExprMIOnly(that);
    }

    public void forSubscriptingMIOnly(SubscriptingMI that) {
        forNonExprMIOnly(that);
    }

    public void forOverloadingOnly(Overloading that) {
        forAbstractNodeOnly(that);
    }

    public void forNonterminalHeaderOnly(NonterminalHeader that) {
        forAbstractNodeOnly(that);
    }

    public void forNonterminalParameterOnly(NonterminalParameter that) {
        forAbstractNodeOnly(that);
    }

    public void forSyntaxDeclOnly(SyntaxDecl that) {
        forAbstractNodeOnly(that);
    }

    public void forSyntaxDefOnly(SyntaxDef that) {
        forSyntaxDeclOnly(that);
    }

    public void forSuperSyntaxDefOnly(SuperSyntaxDef that) {
        forSyntaxDeclOnly(that);
    }

    public void forTransformerDeclOnly(TransformerDecl that) {
        forAbstractNodeOnly(that);
    }

    public void forPreTransformerDefOnly(PreTransformerDef that) {
        forTransformerDeclOnly(that);
    }

    public void forNamedTransformerDefOnly(NamedTransformerDef that) {
        forTransformerDeclOnly(that);
    }

    public void forTransformerOnly(Transformer that) {
        forAbstractNodeOnly(that);
    }

    public void forUnparsedTransformerOnly(UnparsedTransformer that) {
        forTransformerOnly(that);
    }

    public void forNodeTransformerOnly(NodeTransformer that) {
        forTransformerOnly(that);
    }

    public void forCaseTransformerOnly(CaseTransformer that) {
        forTransformerOnly(that);
    }

    public void forCaseTransformerClauseOnly(CaseTransformerClause that) {
        forAbstractNodeOnly(that);
    }

    public void forSyntaxSymbolOnly(SyntaxSymbol that) {
        forAbstractNodeOnly(that);
    }

    public void forPrefixedSymbolOnly(PrefixedSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void forOptionalSymbolOnly(OptionalSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void forRepeatSymbolOnly(RepeatSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void forRepeatOneOrMoreSymbolOnly(RepeatOneOrMoreSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void forNoWhitespaceSymbolOnly(NoWhitespaceSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void forGroupSymbolOnly(GroupSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void forSpecialSymbolOnly(SpecialSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void forAnyCharacterSymbolOnly(AnyCharacterSymbol that) {
        forSpecialSymbolOnly(that);
    }

    public void forWhitespaceSymbolOnly(WhitespaceSymbol that) {
        forSpecialSymbolOnly(that);
    }

    public void forTabSymbolOnly(TabSymbol that) {
        forSpecialSymbolOnly(that);
    }

    public void forFormfeedSymbolOnly(FormfeedSymbol that) {
        forSpecialSymbolOnly(that);
    }

    public void forCarriageReturnSymbolOnly(CarriageReturnSymbol that) {
        forSpecialSymbolOnly(that);
    }

    public void forBackspaceSymbolOnly(BackspaceSymbol that) {
        forSpecialSymbolOnly(that);
    }

    public void forNewlineSymbolOnly(NewlineSymbol that) {
        forSpecialSymbolOnly(that);
    }

    public void forBreaklineSymbolOnly(BreaklineSymbol that) {
        forSpecialSymbolOnly(that);
    }

    public void forItemSymbolOnly(ItemSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void forNonterminalSymbolOnly(NonterminalSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void forKeywordSymbolOnly(KeywordSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void forTokenSymbolOnly(TokenSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void forNotPredicateSymbolOnly(NotPredicateSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void forAndPredicateSymbolOnly(AndPredicateSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void forCharacterClassSymbolOnly(CharacterClassSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void forCharacterSymbolOnly(CharacterSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void forCharSymbolOnly(CharSymbol that) {
        forCharacterSymbolOnly(that);
    }

    public void forCharacterIntervalOnly(CharacterInterval that) {
        forCharacterSymbolOnly(that);
    }

    public void forLinkOnly(Link that) {
        forAbstractNodeOnly(that);
    }

    public void for_SyntaxTransformationAbstractNodeOnly(_SyntaxTransformationAbstractNode that) {
        forAbstractNodeOnly(that);
    }

    public void for_SyntaxTransformationCompilationUnitOnly(_SyntaxTransformationCompilationUnit that) {
        forCompilationUnitOnly(that);
    }

    public void for_SyntaxTransformationComponentOnly(_SyntaxTransformationComponent that) {
        forComponentOnly(that);
    }

    public void for_SyntaxTransformationApiOnly(_SyntaxTransformationApi that) {
        forApiOnly(that);
    }

    public void for_SyntaxTransformationImportOnly(_SyntaxTransformationImport that) {
        forImportOnly(that);
    }

    public void for_SyntaxTransformationImportedNamesOnly(_SyntaxTransformationImportedNames that) {
        forImportedNamesOnly(that);
    }

    public void for_SyntaxTransformationImportStarOnly(_SyntaxTransformationImportStar that) {
        forImportStarOnly(that);
    }

    public void for_SyntaxTransformationImportNamesOnly(_SyntaxTransformationImportNames that) {
        forImportNamesOnly(that);
    }

    public void for_SyntaxTransformationImportApiOnly(_SyntaxTransformationImportApi that) {
        forImportApiOnly(that);
    }

    public void for_SyntaxTransformationAliasedSimpleNameOnly(_SyntaxTransformationAliasedSimpleName that) {
        forAliasedSimpleNameOnly(that);
    }

    public void for_SyntaxTransformationAliasedAPINameOnly(_SyntaxTransformationAliasedAPIName that) {
        forAliasedAPINameOnly(that);
    }

    public void for_SyntaxTransformationDeclOnly(_SyntaxTransformationDecl that) {
        forDeclOnly(that);
    }

    public void for_SyntaxTransformationTraitObjectDeclOnly(_SyntaxTransformationTraitObjectDecl that) {
        forTraitObjectDeclOnly(that);
    }

    public void for_SyntaxTransformationTraitDeclOnly(_SyntaxTransformationTraitDecl that) {
        forTraitDeclOnly(that);
    }

    public void for_SyntaxTransformationObjectDeclOnly(_SyntaxTransformationObjectDecl that) {
        forObjectDeclOnly(that);
    }

    public void for_SyntaxTransformationVarDeclOnly(_SyntaxTransformationVarDecl that) {
        forVarDeclOnly(that);
    }

    public void for_SyntaxTransformationFnDeclOnly(_SyntaxTransformationFnDecl that) {
        forFnDeclOnly(that);
    }

    public void for_SyntaxTransformation_RewriteFnOverloadDeclOnly(_SyntaxTransformation_RewriteFnOverloadDecl that) {
        for_RewriteFnOverloadDeclOnly(that);
    }

    public void for_SyntaxTransformation_RewriteObjectExprDeclOnly(_SyntaxTransformation_RewriteObjectExprDecl that) {
        for_RewriteObjectExprDeclOnly(that);
    }

    public void for_SyntaxTransformation_RewriteFunctionalMethodDeclOnly(_SyntaxTransformation_RewriteFunctionalMethodDecl that) {
        for_RewriteFunctionalMethodDeclOnly(that);
    }

    public void for_SyntaxTransformationDimUnitDeclOnly(_SyntaxTransformationDimUnitDecl that) {
        forDimUnitDeclOnly(that);
    }

    public void for_SyntaxTransformationDimDeclOnly(_SyntaxTransformationDimDecl that) {
        forDimDeclOnly(that);
    }

    public void for_SyntaxTransformationUnitDeclOnly(_SyntaxTransformationUnitDecl that) {
        forUnitDeclOnly(that);
    }

    public void for_SyntaxTransformationTestDeclOnly(_SyntaxTransformationTestDecl that) {
        forTestDeclOnly(that);
    }

    public void for_SyntaxTransformationPropertyDeclOnly(_SyntaxTransformationPropertyDecl that) {
        forPropertyDeclOnly(that);
    }

    public void for_SyntaxTransformationTypeAliasOnly(_SyntaxTransformationTypeAlias that) {
        forTypeAliasOnly(that);
    }

    public void for_SyntaxTransformationGrammarDeclOnly(_SyntaxTransformationGrammarDecl that) {
        forGrammarDeclOnly(that);
    }

    public void for_SyntaxTransformationGrammarMemberDeclOnly(_SyntaxTransformationGrammarMemberDecl that) {
        forGrammarMemberDeclOnly(that);
    }

    public void for_SyntaxTransformationNonterminalDeclOnly(_SyntaxTransformationNonterminalDecl that) {
        forNonterminalDeclOnly(that);
    }

    public void for_SyntaxTransformationNonterminalDefOnly(_SyntaxTransformationNonterminalDef that) {
        forNonterminalDefOnly(that);
    }

    public void for_SyntaxTransformationNonterminalExtensionDefOnly(_SyntaxTransformationNonterminalExtensionDef that) {
        forNonterminalExtensionDefOnly(that);
    }

    public void for_SyntaxTransformationBindingOnly(_SyntaxTransformationBinding that) {
        forBindingOnly(that);
    }

    public void for_SyntaxTransformationLValueOnly(_SyntaxTransformationLValue that) {
        forLValueOnly(that);
    }

    public void for_SyntaxTransformationParamOnly(_SyntaxTransformationParam that) {
        forParamOnly(that);
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

    public void for_SyntaxTransformationTypeOnly(_SyntaxTransformationType that) {
        forTypeOnly(that);
    }

    public void for_SyntaxTransformationBaseTypeOnly(_SyntaxTransformationBaseType that) {
        forBaseTypeOnly(that);
    }

    public void for_SyntaxTransformationAnyTypeOnly(_SyntaxTransformationAnyType that) {
        forAnyTypeOnly(that);
    }

    public void for_SyntaxTransformationBottomTypeOnly(_SyntaxTransformationBottomType that) {
        forBottomTypeOnly(that);
    }

    public void for_SyntaxTransformationUnknownTypeOnly(_SyntaxTransformationUnknownType that) {
        forUnknownTypeOnly(that);
    }

    public void for_SyntaxTransformationSelfTypeOnly(_SyntaxTransformationSelfType that) {
        forSelfTypeOnly(that);
    }

    public void for_SyntaxTransformationTraitSelfTypeOnly(_SyntaxTransformationTraitSelfType that) {
        forTraitSelfTypeOnly(that);
    }

    public void for_SyntaxTransformationObjectExprTypeOnly(_SyntaxTransformationObjectExprType that) {
        forObjectExprTypeOnly(that);
    }

    public void for_SyntaxTransformationNamedTypeOnly(_SyntaxTransformationNamedType that) {
        forNamedTypeOnly(that);
    }

    public void for_SyntaxTransformation_InferenceVarTypeOnly(_SyntaxTransformation_InferenceVarType that) {
        for_InferenceVarTypeOnly(that);
    }

    public void for_SyntaxTransformationVarTypeOnly(_SyntaxTransformationVarType that) {
        forVarTypeOnly(that);
    }

    public void for_SyntaxTransformationTraitTypeOnly(_SyntaxTransformationTraitType that) {
        forTraitTypeOnly(that);
    }

    public void for_SyntaxTransformationAbbreviatedTypeOnly(_SyntaxTransformationAbbreviatedType that) {
        forAbbreviatedTypeOnly(that);
    }

    public void for_SyntaxTransformationArrayTypeOnly(_SyntaxTransformationArrayType that) {
        forArrayTypeOnly(that);
    }

    public void for_SyntaxTransformationMatrixTypeOnly(_SyntaxTransformationMatrixType that) {
        forMatrixTypeOnly(that);
    }

    public void for_SyntaxTransformationTaggedDimTypeOnly(_SyntaxTransformationTaggedDimType that) {
        forTaggedDimTypeOnly(that);
    }

    public void for_SyntaxTransformationTaggedUnitTypeOnly(_SyntaxTransformationTaggedUnitType that) {
        forTaggedUnitTypeOnly(that);
    }

    public void for_SyntaxTransformationTupleTypeOnly(_SyntaxTransformationTupleType that) {
        forTupleTypeOnly(that);
    }

    public void for_SyntaxTransformationArrowTypeOnly(_SyntaxTransformationArrowType that) {
        forArrowTypeOnly(that);
    }

    public void for_SyntaxTransformationBoundTypeOnly(_SyntaxTransformationBoundType that) {
        forBoundTypeOnly(that);
    }

    public void for_SyntaxTransformationIntersectionTypeOnly(_SyntaxTransformationIntersectionType that) {
        forIntersectionTypeOnly(that);
    }

    public void for_SyntaxTransformationUnionTypeOnly(_SyntaxTransformationUnionType that) {
        forUnionTypeOnly(that);
    }

    public void for_SyntaxTransformationFixedPointTypeOnly(_SyntaxTransformationFixedPointType that) {
        forFixedPointTypeOnly(that);
    }

    public void for_SyntaxTransformationLabelTypeOnly(_SyntaxTransformationLabelType that) {
        forLabelTypeOnly(that);
    }

    public void for_SyntaxTransformationDimExprOnly(_SyntaxTransformationDimExpr that) {
        forDimExprOnly(that);
    }

    public void for_SyntaxTransformationDimBaseOnly(_SyntaxTransformationDimBase that) {
        forDimBaseOnly(that);
    }

    public void for_SyntaxTransformationDimRefOnly(_SyntaxTransformationDimRef that) {
        forDimRefOnly(that);
    }

    public void for_SyntaxTransformationDimExponentOnly(_SyntaxTransformationDimExponent that) {
        forDimExponentOnly(that);
    }

    public void for_SyntaxTransformationDimUnaryOpOnly(_SyntaxTransformationDimUnaryOp that) {
        forDimUnaryOpOnly(that);
    }

    public void for_SyntaxTransformationDimBinaryOpOnly(_SyntaxTransformationDimBinaryOp that) {
        forDimBinaryOpOnly(that);
    }

    public void for_SyntaxTransformationPatternOnly(_SyntaxTransformationPattern that) {
        forPatternOnly(that);
    }

    public void for_SyntaxTransformationPatternArgsOnly(_SyntaxTransformationPatternArgs that) {
        forPatternArgsOnly(that);
    }

    public void for_SyntaxTransformationPatternBindingOnly(_SyntaxTransformationPatternBinding that) {
        forPatternBindingOnly(that);
    }

    public void for_SyntaxTransformationPlainPatternOnly(_SyntaxTransformationPlainPattern that) {
        forPlainPatternOnly(that);
    }

    public void for_SyntaxTransformationTypePatternOnly(_SyntaxTransformationTypePattern that) {
        forTypePatternOnly(that);
    }

    public void for_SyntaxTransformationNestedPatternOnly(_SyntaxTransformationNestedPattern that) {
        forNestedPatternOnly(that);
    }

    public void for_SyntaxTransformationStaticArgOnly(_SyntaxTransformationStaticArg that) {
        forStaticArgOnly(that);
    }

    public void for_SyntaxTransformationTypeArgOnly(_SyntaxTransformationTypeArg that) {
        forTypeArgOnly(that);
    }

    public void for_SyntaxTransformationIntArgOnly(_SyntaxTransformationIntArg that) {
        forIntArgOnly(that);
    }

    public void for_SyntaxTransformationBoolArgOnly(_SyntaxTransformationBoolArg that) {
        forBoolArgOnly(that);
    }

    public void for_SyntaxTransformationOpArgOnly(_SyntaxTransformationOpArg that) {
        forOpArgOnly(that);
    }

    public void for_SyntaxTransformationDimArgOnly(_SyntaxTransformationDimArg that) {
        forDimArgOnly(that);
    }

    public void for_SyntaxTransformationUnitArgOnly(_SyntaxTransformationUnitArg that) {
        forUnitArgOnly(that);
    }

    public void for_SyntaxTransformationStaticExprOnly(_SyntaxTransformationStaticExpr that) {
        forStaticExprOnly(that);
    }

    public void for_SyntaxTransformationIntExprOnly(_SyntaxTransformationIntExpr that) {
        forIntExprOnly(that);
    }

    public void for_SyntaxTransformationIntBaseOnly(_SyntaxTransformationIntBase that) {
        forIntBaseOnly(that);
    }

    public void for_SyntaxTransformationIntRefOnly(_SyntaxTransformationIntRef that) {
        forIntRefOnly(that);
    }

    public void for_SyntaxTransformationIntBinaryOpOnly(_SyntaxTransformationIntBinaryOp that) {
        forIntBinaryOpOnly(that);
    }

    public void for_SyntaxTransformationBoolExprOnly(_SyntaxTransformationBoolExpr that) {
        forBoolExprOnly(that);
    }

    public void for_SyntaxTransformationBoolBaseOnly(_SyntaxTransformationBoolBase that) {
        forBoolBaseOnly(that);
    }

    public void for_SyntaxTransformationBoolRefOnly(_SyntaxTransformationBoolRef that) {
        forBoolRefOnly(that);
    }

    public void for_SyntaxTransformationBoolConstraintOnly(_SyntaxTransformationBoolConstraint that) {
        forBoolConstraintOnly(that);
    }

    public void for_SyntaxTransformationBoolUnaryOpOnly(_SyntaxTransformationBoolUnaryOp that) {
        forBoolUnaryOpOnly(that);
    }

    public void for_SyntaxTransformationBoolBinaryOpOnly(_SyntaxTransformationBoolBinaryOp that) {
        forBoolBinaryOpOnly(that);
    }

    public void for_SyntaxTransformationUnitExprOnly(_SyntaxTransformationUnitExpr that) {
        forUnitExprOnly(that);
    }

    public void for_SyntaxTransformationUnitRefOnly(_SyntaxTransformationUnitRef that) {
        forUnitRefOnly(that);
    }

    public void for_SyntaxTransformationUnitBinaryOpOnly(_SyntaxTransformationUnitBinaryOp that) {
        forUnitBinaryOpOnly(that);
    }

    public void for_SyntaxTransformationEffectOnly(_SyntaxTransformationEffect that) {
        forEffectOnly(that);
    }

    public void for_SyntaxTransformationWhereClauseOnly(_SyntaxTransformationWhereClause that) {
        forWhereClauseOnly(that);
    }

    public void for_SyntaxTransformationWhereBindingOnly(_SyntaxTransformationWhereBinding that) {
        forWhereBindingOnly(that);
    }

    public void for_SyntaxTransformationWhereConstraintOnly(_SyntaxTransformationWhereConstraint that) {
        forWhereConstraintOnly(that);
    }

    public void for_SyntaxTransformationWhereExtendsOnly(_SyntaxTransformationWhereExtends that) {
        forWhereExtendsOnly(that);
    }

    public void for_SyntaxTransformationWhereTypeAliasOnly(_SyntaxTransformationWhereTypeAlias that) {
        forWhereTypeAliasOnly(that);
    }

    public void for_SyntaxTransformationWhereCoercesOnly(_SyntaxTransformationWhereCoerces that) {
        forWhereCoercesOnly(that);
    }

    public void for_SyntaxTransformationWhereEqualsOnly(_SyntaxTransformationWhereEquals that) {
        forWhereEqualsOnly(that);
    }

    public void for_SyntaxTransformationUnitConstraintOnly(_SyntaxTransformationUnitConstraint that) {
        forUnitConstraintOnly(that);
    }

    public void for_SyntaxTransformationIntConstraintOnly(_SyntaxTransformationIntConstraint that) {
        forIntConstraintOnly(that);
    }

    public void for_SyntaxTransformationBoolConstraintExprOnly(_SyntaxTransformationBoolConstraintExpr that) {
        forBoolConstraintExprOnly(that);
    }

    public void for_SyntaxTransformationContractOnly(_SyntaxTransformationContract that) {
        forContractOnly(that);
    }

    public void for_SyntaxTransformationEnsuresClauseOnly(_SyntaxTransformationEnsuresClause that) {
        forEnsuresClauseOnly(that);
    }

    public void for_SyntaxTransformationStaticParamOnly(_SyntaxTransformationStaticParam that) {
        forStaticParamOnly(that);
    }

    public void for_SyntaxTransformationNameOnly(_SyntaxTransformationName that) {
        forNameOnly(that);
    }

    public void for_SyntaxTransformationAPINameOnly(_SyntaxTransformationAPIName that) {
        forAPINameOnly(that);
    }

    public void for_SyntaxTransformationIdOrOpOrAnonymousNameOnly(_SyntaxTransformationIdOrOpOrAnonymousName that) {
        forIdOrOpOrAnonymousNameOnly(that);
    }

    public void for_SyntaxTransformationIdOrOpOnly(_SyntaxTransformationIdOrOp that) {
        forIdOrOpOnly(that);
    }

    public void for_SyntaxTransformationIdOnly(_SyntaxTransformationId that) {
        forIdOnly(that);
    }

    public void for_SyntaxTransformationOpOnly(_SyntaxTransformationOp that) {
        forOpOnly(that);
    }

    public void for_SyntaxTransformationNamedOpOnly(_SyntaxTransformationNamedOp that) {
        forNamedOpOnly(that);
    }

    public void for_SyntaxTransformation_InferenceVarOpOnly(_SyntaxTransformation_InferenceVarOp that) {
        for_InferenceVarOpOnly(that);
    }

    public void for_SyntaxTransformationAnonymousNameOnly(_SyntaxTransformationAnonymousName that) {
        forAnonymousNameOnly(that);
    }

    public void for_SyntaxTransformationAnonymousFnNameOnly(_SyntaxTransformationAnonymousFnName that) {
        forAnonymousFnNameOnly(that);
    }

    public void for_SyntaxTransformationConstructorFnNameOnly(_SyntaxTransformationConstructorFnName that) {
        forConstructorFnNameOnly(that);
    }

    public void for_SyntaxTransformationArrayComprehensionClauseOnly(_SyntaxTransformationArrayComprehensionClause that) {
        forArrayComprehensionClauseOnly(that);
    }

    public void for_SyntaxTransformationKeywordExprOnly(_SyntaxTransformationKeywordExpr that) {
        forKeywordExprOnly(that);
    }

    public void for_SyntaxTransformationCaseClauseOnly(_SyntaxTransformationCaseClause that) {
        forCaseClauseOnly(that);
    }

    public void for_SyntaxTransformationCatchOnly(_SyntaxTransformationCatch that) {
        forCatchOnly(that);
    }

    public void for_SyntaxTransformationCatchClauseOnly(_SyntaxTransformationCatchClause that) {
        forCatchClauseOnly(that);
    }

    public void for_SyntaxTransformationIfClauseOnly(_SyntaxTransformationIfClause that) {
        forIfClauseOnly(that);
    }

    public void for_SyntaxTransformationTypecaseClauseOnly(_SyntaxTransformationTypecaseClause that) {
        forTypecaseClauseOnly(that);
    }

    public void for_SyntaxTransformationExtentRangeOnly(_SyntaxTransformationExtentRange that) {
        forExtentRangeOnly(that);
    }

    public void for_SyntaxTransformationGeneratorClauseOnly(_SyntaxTransformationGeneratorClause that) {
        forGeneratorClauseOnly(that);
    }

    public void for_SyntaxTransformationKeywordTypeOnly(_SyntaxTransformationKeywordType that) {
        forKeywordTypeOnly(that);
    }

    public void for_SyntaxTransformationTraitTypeWhereOnly(_SyntaxTransformationTraitTypeWhere that) {
        forTraitTypeWhereOnly(that);
    }

    public void for_SyntaxTransformationIndicesOnly(_SyntaxTransformationIndices that) {
        forIndicesOnly(that);
    }

    public void for_SyntaxTransformationMathItemOnly(_SyntaxTransformationMathItem that) {
        forMathItemOnly(that);
    }

    public void for_SyntaxTransformationExprMIOnly(_SyntaxTransformationExprMI that) {
        forExprMIOnly(that);
    }

    public void for_SyntaxTransformationParenthesisDelimitedMIOnly(_SyntaxTransformationParenthesisDelimitedMI that) {
        forParenthesisDelimitedMIOnly(that);
    }

    public void for_SyntaxTransformationNonParenthesisDelimitedMIOnly(_SyntaxTransformationNonParenthesisDelimitedMI that) {
        forNonParenthesisDelimitedMIOnly(that);
    }

    public void for_SyntaxTransformationNonExprMIOnly(_SyntaxTransformationNonExprMI that) {
        forNonExprMIOnly(that);
    }

    public void for_SyntaxTransformationExponentiationMIOnly(_SyntaxTransformationExponentiationMI that) {
        forExponentiationMIOnly(that);
    }

    public void for_SyntaxTransformationSubscriptingMIOnly(_SyntaxTransformationSubscriptingMI that) {
        forSubscriptingMIOnly(that);
    }

    public void for_SyntaxTransformationOverloadingOnly(_SyntaxTransformationOverloading that) {
        forOverloadingOnly(that);
    }

    public void for_SyntaxTransformationNonterminalHeaderOnly(_SyntaxTransformationNonterminalHeader that) {
        forNonterminalHeaderOnly(that);
    }

    public void for_SyntaxTransformationNonterminalParameterOnly(_SyntaxTransformationNonterminalParameter that) {
        forNonterminalParameterOnly(that);
    }

    public void for_SyntaxTransformationSyntaxDeclOnly(_SyntaxTransformationSyntaxDecl that) {
        forSyntaxDeclOnly(that);
    }

    public void for_SyntaxTransformationSyntaxDefOnly(_SyntaxTransformationSyntaxDef that) {
        forSyntaxDefOnly(that);
    }

    public void for_SyntaxTransformationSuperSyntaxDefOnly(_SyntaxTransformationSuperSyntaxDef that) {
        forSuperSyntaxDefOnly(that);
    }

    public void for_SyntaxTransformationTransformerDeclOnly(_SyntaxTransformationTransformerDecl that) {
        forTransformerDeclOnly(that);
    }

    public void for_SyntaxTransformationPreTransformerDefOnly(_SyntaxTransformationPreTransformerDef that) {
        forPreTransformerDefOnly(that);
    }

    public void for_SyntaxTransformationNamedTransformerDefOnly(_SyntaxTransformationNamedTransformerDef that) {
        forNamedTransformerDefOnly(that);
    }

    public void for_SyntaxTransformationTransformerOnly(_SyntaxTransformationTransformer that) {
        forTransformerOnly(that);
    }

    public void for_SyntaxTransformationUnparsedTransformerOnly(_SyntaxTransformationUnparsedTransformer that) {
        forUnparsedTransformerOnly(that);
    }

    public void for_SyntaxTransformationNodeTransformerOnly(_SyntaxTransformationNodeTransformer that) {
        forNodeTransformerOnly(that);
    }

    public void for_SyntaxTransformationCaseTransformerOnly(_SyntaxTransformationCaseTransformer that) {
        forCaseTransformerOnly(that);
    }

    public void for_SyntaxTransformationCaseTransformerClauseOnly(_SyntaxTransformationCaseTransformerClause that) {
        forCaseTransformerClauseOnly(that);
    }

    public void for_SyntaxTransformationSyntaxSymbolOnly(_SyntaxTransformationSyntaxSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void for_SyntaxTransformationPrefixedSymbolOnly(_SyntaxTransformationPrefixedSymbol that) {
        forPrefixedSymbolOnly(that);
    }

    public void for_SyntaxTransformationOptionalSymbolOnly(_SyntaxTransformationOptionalSymbol that) {
        forOptionalSymbolOnly(that);
    }

    public void for_SyntaxTransformationRepeatSymbolOnly(_SyntaxTransformationRepeatSymbol that) {
        forRepeatSymbolOnly(that);
    }

    public void for_SyntaxTransformationRepeatOneOrMoreSymbolOnly(_SyntaxTransformationRepeatOneOrMoreSymbol that) {
        forRepeatOneOrMoreSymbolOnly(that);
    }

    public void for_SyntaxTransformationNoWhitespaceSymbolOnly(_SyntaxTransformationNoWhitespaceSymbol that) {
        forNoWhitespaceSymbolOnly(that);
    }

    public void for_SyntaxTransformationGroupSymbolOnly(_SyntaxTransformationGroupSymbol that) {
        forGroupSymbolOnly(that);
    }

    public void for_SyntaxTransformationSpecialSymbolOnly(_SyntaxTransformationSpecialSymbol that) {
        forSpecialSymbolOnly(that);
    }

    public void for_SyntaxTransformationAnyCharacterSymbolOnly(_SyntaxTransformationAnyCharacterSymbol that) {
        forAnyCharacterSymbolOnly(that);
    }

    public void for_SyntaxTransformationWhitespaceSymbolOnly(_SyntaxTransformationWhitespaceSymbol that) {
        forWhitespaceSymbolOnly(that);
    }

    public void for_SyntaxTransformationTabSymbolOnly(_SyntaxTransformationTabSymbol that) {
        forTabSymbolOnly(that);
    }

    public void for_SyntaxTransformationFormfeedSymbolOnly(_SyntaxTransformationFormfeedSymbol that) {
        forFormfeedSymbolOnly(that);
    }

    public void for_SyntaxTransformationCarriageReturnSymbolOnly(_SyntaxTransformationCarriageReturnSymbol that) {
        forCarriageReturnSymbolOnly(that);
    }

    public void for_SyntaxTransformationBackspaceSymbolOnly(_SyntaxTransformationBackspaceSymbol that) {
        forBackspaceSymbolOnly(that);
    }

    public void for_SyntaxTransformationNewlineSymbolOnly(_SyntaxTransformationNewlineSymbol that) {
        forNewlineSymbolOnly(that);
    }

    public void for_SyntaxTransformationBreaklineSymbolOnly(_SyntaxTransformationBreaklineSymbol that) {
        forBreaklineSymbolOnly(that);
    }

    public void for_SyntaxTransformationItemSymbolOnly(_SyntaxTransformationItemSymbol that) {
        forItemSymbolOnly(that);
    }

    public void for_SyntaxTransformationNonterminalSymbolOnly(_SyntaxTransformationNonterminalSymbol that) {
        forNonterminalSymbolOnly(that);
    }

    public void for_SyntaxTransformationKeywordSymbolOnly(_SyntaxTransformationKeywordSymbol that) {
        forKeywordSymbolOnly(that);
    }

    public void for_SyntaxTransformationTokenSymbolOnly(_SyntaxTransformationTokenSymbol that) {
        forTokenSymbolOnly(that);
    }

    public void for_SyntaxTransformationNotPredicateSymbolOnly(_SyntaxTransformationNotPredicateSymbol that) {
        forNotPredicateSymbolOnly(that);
    }

    public void for_SyntaxTransformationAndPredicateSymbolOnly(_SyntaxTransformationAndPredicateSymbol that) {
        forAndPredicateSymbolOnly(that);
    }

    public void for_SyntaxTransformationCharacterClassSymbolOnly(_SyntaxTransformationCharacterClassSymbol that) {
        forCharacterClassSymbolOnly(that);
    }

    public void for_SyntaxTransformationCharacterSymbolOnly(_SyntaxTransformationCharacterSymbol that) {
        forCharacterSymbolOnly(that);
    }

    public void for_SyntaxTransformationCharSymbolOnly(_SyntaxTransformationCharSymbol that) {
        forCharSymbolOnly(that);
    }

    public void for_SyntaxTransformationCharacterIntervalOnly(_SyntaxTransformationCharacterInterval that) {
        forCharacterIntervalOnly(that);
    }

    public void for_SyntaxTransformationLinkOnly(_SyntaxTransformationLink that) {
        forLinkOnly(that);
    }

    public void for_EllipsesAbstractNodeOnly(_EllipsesAbstractNode that) {
        forAbstractNodeOnly(that);
    }

    public void for_EllipsesCompilationUnitOnly(_EllipsesCompilationUnit that) {
        forCompilationUnitOnly(that);
    }

    public void for_EllipsesComponentOnly(_EllipsesComponent that) {
        forComponentOnly(that);
    }

    public void for_EllipsesApiOnly(_EllipsesApi that) {
        forApiOnly(that);
    }

    public void for_EllipsesImportOnly(_EllipsesImport that) {
        forImportOnly(that);
    }

    public void for_EllipsesImportedNamesOnly(_EllipsesImportedNames that) {
        forImportedNamesOnly(that);
    }

    public void for_EllipsesImportStarOnly(_EllipsesImportStar that) {
        forImportStarOnly(that);
    }

    public void for_EllipsesImportNamesOnly(_EllipsesImportNames that) {
        forImportNamesOnly(that);
    }

    public void for_EllipsesImportApiOnly(_EllipsesImportApi that) {
        forImportApiOnly(that);
    }

    public void for_EllipsesAliasedSimpleNameOnly(_EllipsesAliasedSimpleName that) {
        forAliasedSimpleNameOnly(that);
    }

    public void for_EllipsesAliasedAPINameOnly(_EllipsesAliasedAPIName that) {
        forAliasedAPINameOnly(that);
    }

    public void for_EllipsesDeclOnly(_EllipsesDecl that) {
        forDeclOnly(that);
    }

    public void for_EllipsesTraitObjectDeclOnly(_EllipsesTraitObjectDecl that) {
        forTraitObjectDeclOnly(that);
    }

    public void for_EllipsesTraitDeclOnly(_EllipsesTraitDecl that) {
        forTraitDeclOnly(that);
    }

    public void for_EllipsesObjectDeclOnly(_EllipsesObjectDecl that) {
        forObjectDeclOnly(that);
    }

    public void for_EllipsesVarDeclOnly(_EllipsesVarDecl that) {
        forVarDeclOnly(that);
    }

    public void for_EllipsesFnDeclOnly(_EllipsesFnDecl that) {
        forFnDeclOnly(that);
    }

    public void for_Ellipses_RewriteFnOverloadDeclOnly(_Ellipses_RewriteFnOverloadDecl that) {
        for_RewriteFnOverloadDeclOnly(that);
    }

    public void for_Ellipses_RewriteObjectExprDeclOnly(_Ellipses_RewriteObjectExprDecl that) {
        for_RewriteObjectExprDeclOnly(that);
    }

    public void for_Ellipses_RewriteFunctionalMethodDeclOnly(_Ellipses_RewriteFunctionalMethodDecl that) {
        for_RewriteFunctionalMethodDeclOnly(that);
    }

    public void for_EllipsesDimUnitDeclOnly(_EllipsesDimUnitDecl that) {
        forDimUnitDeclOnly(that);
    }

    public void for_EllipsesDimDeclOnly(_EllipsesDimDecl that) {
        forDimDeclOnly(that);
    }

    public void for_EllipsesUnitDeclOnly(_EllipsesUnitDecl that) {
        forUnitDeclOnly(that);
    }

    public void for_EllipsesTestDeclOnly(_EllipsesTestDecl that) {
        forTestDeclOnly(that);
    }

    public void for_EllipsesPropertyDeclOnly(_EllipsesPropertyDecl that) {
        forPropertyDeclOnly(that);
    }

    public void for_EllipsesTypeAliasOnly(_EllipsesTypeAlias that) {
        forTypeAliasOnly(that);
    }

    public void for_EllipsesGrammarDeclOnly(_EllipsesGrammarDecl that) {
        forGrammarDeclOnly(that);
    }

    public void for_EllipsesGrammarMemberDeclOnly(_EllipsesGrammarMemberDecl that) {
        forGrammarMemberDeclOnly(that);
    }

    public void for_EllipsesNonterminalDeclOnly(_EllipsesNonterminalDecl that) {
        forNonterminalDeclOnly(that);
    }

    public void for_EllipsesNonterminalDefOnly(_EllipsesNonterminalDef that) {
        forNonterminalDefOnly(that);
    }

    public void for_EllipsesNonterminalExtensionDefOnly(_EllipsesNonterminalExtensionDef that) {
        forNonterminalExtensionDefOnly(that);
    }

    public void for_EllipsesBindingOnly(_EllipsesBinding that) {
        forBindingOnly(that);
    }

    public void for_EllipsesLValueOnly(_EllipsesLValue that) {
        forLValueOnly(that);
    }

    public void for_EllipsesParamOnly(_EllipsesParam that) {
        forParamOnly(that);
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

    public void for_EllipsesTypeOnly(_EllipsesType that) {
        forTypeOnly(that);
    }

    public void for_EllipsesBaseTypeOnly(_EllipsesBaseType that) {
        forBaseTypeOnly(that);
    }

    public void for_EllipsesAnyTypeOnly(_EllipsesAnyType that) {
        forAnyTypeOnly(that);
    }

    public void for_EllipsesBottomTypeOnly(_EllipsesBottomType that) {
        forBottomTypeOnly(that);
    }

    public void for_EllipsesUnknownTypeOnly(_EllipsesUnknownType that) {
        forUnknownTypeOnly(that);
    }

    public void for_EllipsesSelfTypeOnly(_EllipsesSelfType that) {
        forSelfTypeOnly(that);
    }

    public void for_EllipsesTraitSelfTypeOnly(_EllipsesTraitSelfType that) {
        forTraitSelfTypeOnly(that);
    }

    public void for_EllipsesObjectExprTypeOnly(_EllipsesObjectExprType that) {
        forObjectExprTypeOnly(that);
    }

    public void for_EllipsesNamedTypeOnly(_EllipsesNamedType that) {
        forNamedTypeOnly(that);
    }

    public void for_Ellipses_InferenceVarTypeOnly(_Ellipses_InferenceVarType that) {
        for_InferenceVarTypeOnly(that);
    }

    public void for_EllipsesVarTypeOnly(_EllipsesVarType that) {
        forVarTypeOnly(that);
    }

    public void for_EllipsesTraitTypeOnly(_EllipsesTraitType that) {
        forTraitTypeOnly(that);
    }

    public void for_EllipsesAbbreviatedTypeOnly(_EllipsesAbbreviatedType that) {
        forAbbreviatedTypeOnly(that);
    }

    public void for_EllipsesArrayTypeOnly(_EllipsesArrayType that) {
        forArrayTypeOnly(that);
    }

    public void for_EllipsesMatrixTypeOnly(_EllipsesMatrixType that) {
        forMatrixTypeOnly(that);
    }

    public void for_EllipsesTaggedDimTypeOnly(_EllipsesTaggedDimType that) {
        forTaggedDimTypeOnly(that);
    }

    public void for_EllipsesTaggedUnitTypeOnly(_EllipsesTaggedUnitType that) {
        forTaggedUnitTypeOnly(that);
    }

    public void for_EllipsesTupleTypeOnly(_EllipsesTupleType that) {
        forTupleTypeOnly(that);
    }

    public void for_EllipsesArrowTypeOnly(_EllipsesArrowType that) {
        forArrowTypeOnly(that);
    }

    public void for_EllipsesBoundTypeOnly(_EllipsesBoundType that) {
        forBoundTypeOnly(that);
    }

    public void for_EllipsesIntersectionTypeOnly(_EllipsesIntersectionType that) {
        forIntersectionTypeOnly(that);
    }

    public void for_EllipsesUnionTypeOnly(_EllipsesUnionType that) {
        forUnionTypeOnly(that);
    }

    public void for_EllipsesFixedPointTypeOnly(_EllipsesFixedPointType that) {
        forFixedPointTypeOnly(that);
    }

    public void for_EllipsesLabelTypeOnly(_EllipsesLabelType that) {
        forLabelTypeOnly(that);
    }

    public void for_EllipsesDimExprOnly(_EllipsesDimExpr that) {
        forDimExprOnly(that);
    }

    public void for_EllipsesDimBaseOnly(_EllipsesDimBase that) {
        forDimBaseOnly(that);
    }

    public void for_EllipsesDimRefOnly(_EllipsesDimRef that) {
        forDimRefOnly(that);
    }

    public void for_EllipsesDimExponentOnly(_EllipsesDimExponent that) {
        forDimExponentOnly(that);
    }

    public void for_EllipsesDimUnaryOpOnly(_EllipsesDimUnaryOp that) {
        forDimUnaryOpOnly(that);
    }

    public void for_EllipsesDimBinaryOpOnly(_EllipsesDimBinaryOp that) {
        forDimBinaryOpOnly(that);
    }

    public void for_EllipsesPatternOnly(_EllipsesPattern that) {
        forPatternOnly(that);
    }

    public void for_EllipsesPatternArgsOnly(_EllipsesPatternArgs that) {
        forPatternArgsOnly(that);
    }

    public void for_EllipsesPatternBindingOnly(_EllipsesPatternBinding that) {
        forPatternBindingOnly(that);
    }

    public void for_EllipsesPlainPatternOnly(_EllipsesPlainPattern that) {
        forPlainPatternOnly(that);
    }

    public void for_EllipsesTypePatternOnly(_EllipsesTypePattern that) {
        forTypePatternOnly(that);
    }

    public void for_EllipsesNestedPatternOnly(_EllipsesNestedPattern that) {
        forNestedPatternOnly(that);
    }

    public void for_EllipsesStaticArgOnly(_EllipsesStaticArg that) {
        forStaticArgOnly(that);
    }

    public void for_EllipsesTypeArgOnly(_EllipsesTypeArg that) {
        forTypeArgOnly(that);
    }

    public void for_EllipsesIntArgOnly(_EllipsesIntArg that) {
        forIntArgOnly(that);
    }

    public void for_EllipsesBoolArgOnly(_EllipsesBoolArg that) {
        forBoolArgOnly(that);
    }

    public void for_EllipsesOpArgOnly(_EllipsesOpArg that) {
        forOpArgOnly(that);
    }

    public void for_EllipsesDimArgOnly(_EllipsesDimArg that) {
        forDimArgOnly(that);
    }

    public void for_EllipsesUnitArgOnly(_EllipsesUnitArg that) {
        forUnitArgOnly(that);
    }

    public void for_EllipsesStaticExprOnly(_EllipsesStaticExpr that) {
        forStaticExprOnly(that);
    }

    public void for_EllipsesIntExprOnly(_EllipsesIntExpr that) {
        forIntExprOnly(that);
    }

    public void for_EllipsesIntBaseOnly(_EllipsesIntBase that) {
        forIntBaseOnly(that);
    }

    public void for_EllipsesIntRefOnly(_EllipsesIntRef that) {
        forIntRefOnly(that);
    }

    public void for_EllipsesIntBinaryOpOnly(_EllipsesIntBinaryOp that) {
        forIntBinaryOpOnly(that);
    }

    public void for_EllipsesBoolExprOnly(_EllipsesBoolExpr that) {
        forBoolExprOnly(that);
    }

    public void for_EllipsesBoolBaseOnly(_EllipsesBoolBase that) {
        forBoolBaseOnly(that);
    }

    public void for_EllipsesBoolRefOnly(_EllipsesBoolRef that) {
        forBoolRefOnly(that);
    }

    public void for_EllipsesBoolConstraintOnly(_EllipsesBoolConstraint that) {
        forBoolConstraintOnly(that);
    }

    public void for_EllipsesBoolUnaryOpOnly(_EllipsesBoolUnaryOp that) {
        forBoolUnaryOpOnly(that);
    }

    public void for_EllipsesBoolBinaryOpOnly(_EllipsesBoolBinaryOp that) {
        forBoolBinaryOpOnly(that);
    }

    public void for_EllipsesUnitExprOnly(_EllipsesUnitExpr that) {
        forUnitExprOnly(that);
    }

    public void for_EllipsesUnitRefOnly(_EllipsesUnitRef that) {
        forUnitRefOnly(that);
    }

    public void for_EllipsesUnitBinaryOpOnly(_EllipsesUnitBinaryOp that) {
        forUnitBinaryOpOnly(that);
    }

    public void for_EllipsesEffectOnly(_EllipsesEffect that) {
        forEffectOnly(that);
    }

    public void for_EllipsesWhereClauseOnly(_EllipsesWhereClause that) {
        forWhereClauseOnly(that);
    }

    public void for_EllipsesWhereBindingOnly(_EllipsesWhereBinding that) {
        forWhereBindingOnly(that);
    }

    public void for_EllipsesWhereConstraintOnly(_EllipsesWhereConstraint that) {
        forWhereConstraintOnly(that);
    }

    public void for_EllipsesWhereExtendsOnly(_EllipsesWhereExtends that) {
        forWhereExtendsOnly(that);
    }

    public void for_EllipsesWhereTypeAliasOnly(_EllipsesWhereTypeAlias that) {
        forWhereTypeAliasOnly(that);
    }

    public void for_EllipsesWhereCoercesOnly(_EllipsesWhereCoerces that) {
        forWhereCoercesOnly(that);
    }

    public void for_EllipsesWhereEqualsOnly(_EllipsesWhereEquals that) {
        forWhereEqualsOnly(that);
    }

    public void for_EllipsesUnitConstraintOnly(_EllipsesUnitConstraint that) {
        forUnitConstraintOnly(that);
    }

    public void for_EllipsesIntConstraintOnly(_EllipsesIntConstraint that) {
        forIntConstraintOnly(that);
    }

    public void for_EllipsesBoolConstraintExprOnly(_EllipsesBoolConstraintExpr that) {
        forBoolConstraintExprOnly(that);
    }

    public void for_EllipsesContractOnly(_EllipsesContract that) {
        forContractOnly(that);
    }

    public void for_EllipsesEnsuresClauseOnly(_EllipsesEnsuresClause that) {
        forEnsuresClauseOnly(that);
    }

    public void for_EllipsesStaticParamOnly(_EllipsesStaticParam that) {
        forStaticParamOnly(that);
    }

    public void for_EllipsesNameOnly(_EllipsesName that) {
        forNameOnly(that);
    }

    public void for_EllipsesAPINameOnly(_EllipsesAPIName that) {
        forAPINameOnly(that);
    }

    public void for_EllipsesIdOrOpOrAnonymousNameOnly(_EllipsesIdOrOpOrAnonymousName that) {
        forIdOrOpOrAnonymousNameOnly(that);
    }

    public void for_EllipsesIdOrOpOnly(_EllipsesIdOrOp that) {
        forIdOrOpOnly(that);
    }

    public void for_EllipsesIdOnly(_EllipsesId that) {
        forIdOnly(that);
    }

    public void for_EllipsesOpOnly(_EllipsesOp that) {
        forOpOnly(that);
    }

    public void for_EllipsesNamedOpOnly(_EllipsesNamedOp that) {
        forNamedOpOnly(that);
    }

    public void for_Ellipses_InferenceVarOpOnly(_Ellipses_InferenceVarOp that) {
        for_InferenceVarOpOnly(that);
    }

    public void for_EllipsesAnonymousNameOnly(_EllipsesAnonymousName that) {
        forAnonymousNameOnly(that);
    }

    public void for_EllipsesAnonymousFnNameOnly(_EllipsesAnonymousFnName that) {
        forAnonymousFnNameOnly(that);
    }

    public void for_EllipsesConstructorFnNameOnly(_EllipsesConstructorFnName that) {
        forConstructorFnNameOnly(that);
    }

    public void for_EllipsesArrayComprehensionClauseOnly(_EllipsesArrayComprehensionClause that) {
        forArrayComprehensionClauseOnly(that);
    }

    public void for_EllipsesKeywordExprOnly(_EllipsesKeywordExpr that) {
        forKeywordExprOnly(that);
    }

    public void for_EllipsesCaseClauseOnly(_EllipsesCaseClause that) {
        forCaseClauseOnly(that);
    }

    public void for_EllipsesCatchOnly(_EllipsesCatch that) {
        forCatchOnly(that);
    }

    public void for_EllipsesCatchClauseOnly(_EllipsesCatchClause that) {
        forCatchClauseOnly(that);
    }

    public void for_EllipsesIfClauseOnly(_EllipsesIfClause that) {
        forIfClauseOnly(that);
    }

    public void for_EllipsesTypecaseClauseOnly(_EllipsesTypecaseClause that) {
        forTypecaseClauseOnly(that);
    }

    public void for_EllipsesExtentRangeOnly(_EllipsesExtentRange that) {
        forExtentRangeOnly(that);
    }

    public void for_EllipsesGeneratorClauseOnly(_EllipsesGeneratorClause that) {
        forGeneratorClauseOnly(that);
    }

    public void for_EllipsesKeywordTypeOnly(_EllipsesKeywordType that) {
        forKeywordTypeOnly(that);
    }

    public void for_EllipsesTraitTypeWhereOnly(_EllipsesTraitTypeWhere that) {
        forTraitTypeWhereOnly(that);
    }

    public void for_EllipsesIndicesOnly(_EllipsesIndices that) {
        forIndicesOnly(that);
    }

    public void for_EllipsesMathItemOnly(_EllipsesMathItem that) {
        forMathItemOnly(that);
    }

    public void for_EllipsesExprMIOnly(_EllipsesExprMI that) {
        forExprMIOnly(that);
    }

    public void for_EllipsesParenthesisDelimitedMIOnly(_EllipsesParenthesisDelimitedMI that) {
        forParenthesisDelimitedMIOnly(that);
    }

    public void for_EllipsesNonParenthesisDelimitedMIOnly(_EllipsesNonParenthesisDelimitedMI that) {
        forNonParenthesisDelimitedMIOnly(that);
    }

    public void for_EllipsesNonExprMIOnly(_EllipsesNonExprMI that) {
        forNonExprMIOnly(that);
    }

    public void for_EllipsesExponentiationMIOnly(_EllipsesExponentiationMI that) {
        forExponentiationMIOnly(that);
    }

    public void for_EllipsesSubscriptingMIOnly(_EllipsesSubscriptingMI that) {
        forSubscriptingMIOnly(that);
    }

    public void for_EllipsesOverloadingOnly(_EllipsesOverloading that) {
        forOverloadingOnly(that);
    }

    public void for_EllipsesNonterminalHeaderOnly(_EllipsesNonterminalHeader that) {
        forNonterminalHeaderOnly(that);
    }

    public void for_EllipsesNonterminalParameterOnly(_EllipsesNonterminalParameter that) {
        forNonterminalParameterOnly(that);
    }

    public void for_EllipsesSyntaxDeclOnly(_EllipsesSyntaxDecl that) {
        forSyntaxDeclOnly(that);
    }

    public void for_EllipsesSyntaxDefOnly(_EllipsesSyntaxDef that) {
        forSyntaxDefOnly(that);
    }

    public void for_EllipsesSuperSyntaxDefOnly(_EllipsesSuperSyntaxDef that) {
        forSuperSyntaxDefOnly(that);
    }

    public void for_EllipsesTransformerDeclOnly(_EllipsesTransformerDecl that) {
        forTransformerDeclOnly(that);
    }

    public void for_EllipsesPreTransformerDefOnly(_EllipsesPreTransformerDef that) {
        forPreTransformerDefOnly(that);
    }

    public void for_EllipsesNamedTransformerDefOnly(_EllipsesNamedTransformerDef that) {
        forNamedTransformerDefOnly(that);
    }

    public void for_EllipsesTransformerOnly(_EllipsesTransformer that) {
        forTransformerOnly(that);
    }

    public void for_EllipsesUnparsedTransformerOnly(_EllipsesUnparsedTransformer that) {
        forUnparsedTransformerOnly(that);
    }

    public void for_EllipsesNodeTransformerOnly(_EllipsesNodeTransformer that) {
        forNodeTransformerOnly(that);
    }

    public void for_EllipsesCaseTransformerOnly(_EllipsesCaseTransformer that) {
        forCaseTransformerOnly(that);
    }

    public void for_EllipsesCaseTransformerClauseOnly(_EllipsesCaseTransformerClause that) {
        forCaseTransformerClauseOnly(that);
    }

    public void for_EllipsesSyntaxSymbolOnly(_EllipsesSyntaxSymbol that) {
        forSyntaxSymbolOnly(that);
    }

    public void for_EllipsesPrefixedSymbolOnly(_EllipsesPrefixedSymbol that) {
        forPrefixedSymbolOnly(that);
    }

    public void for_EllipsesOptionalSymbolOnly(_EllipsesOptionalSymbol that) {
        forOptionalSymbolOnly(that);
    }

    public void for_EllipsesRepeatSymbolOnly(_EllipsesRepeatSymbol that) {
        forRepeatSymbolOnly(that);
    }

    public void for_EllipsesRepeatOneOrMoreSymbolOnly(_EllipsesRepeatOneOrMoreSymbol that) {
        forRepeatOneOrMoreSymbolOnly(that);
    }

    public void for_EllipsesNoWhitespaceSymbolOnly(_EllipsesNoWhitespaceSymbol that) {
        forNoWhitespaceSymbolOnly(that);
    }

    public void for_EllipsesGroupSymbolOnly(_EllipsesGroupSymbol that) {
        forGroupSymbolOnly(that);
    }

    public void for_EllipsesSpecialSymbolOnly(_EllipsesSpecialSymbol that) {
        forSpecialSymbolOnly(that);
    }

    public void for_EllipsesAnyCharacterSymbolOnly(_EllipsesAnyCharacterSymbol that) {
        forAnyCharacterSymbolOnly(that);
    }

    public void for_EllipsesWhitespaceSymbolOnly(_EllipsesWhitespaceSymbol that) {
        forWhitespaceSymbolOnly(that);
    }

    public void for_EllipsesTabSymbolOnly(_EllipsesTabSymbol that) {
        forTabSymbolOnly(that);
    }

    public void for_EllipsesFormfeedSymbolOnly(_EllipsesFormfeedSymbol that) {
        forFormfeedSymbolOnly(that);
    }

    public void for_EllipsesCarriageReturnSymbolOnly(_EllipsesCarriageReturnSymbol that) {
        forCarriageReturnSymbolOnly(that);
    }

    public void for_EllipsesBackspaceSymbolOnly(_EllipsesBackspaceSymbol that) {
        forBackspaceSymbolOnly(that);
    }

    public void for_EllipsesNewlineSymbolOnly(_EllipsesNewlineSymbol that) {
        forNewlineSymbolOnly(that);
    }

    public void for_EllipsesBreaklineSymbolOnly(_EllipsesBreaklineSymbol that) {
        forBreaklineSymbolOnly(that);
    }

    public void for_EllipsesItemSymbolOnly(_EllipsesItemSymbol that) {
        forItemSymbolOnly(that);
    }

    public void for_EllipsesNonterminalSymbolOnly(_EllipsesNonterminalSymbol that) {
        forNonterminalSymbolOnly(that);
    }

    public void for_EllipsesKeywordSymbolOnly(_EllipsesKeywordSymbol that) {
        forKeywordSymbolOnly(that);
    }

    public void for_EllipsesTokenSymbolOnly(_EllipsesTokenSymbol that) {
        forTokenSymbolOnly(that);
    }

    public void for_EllipsesNotPredicateSymbolOnly(_EllipsesNotPredicateSymbol that) {
        forNotPredicateSymbolOnly(that);
    }

    public void for_EllipsesAndPredicateSymbolOnly(_EllipsesAndPredicateSymbol that) {
        forAndPredicateSymbolOnly(that);
    }

    public void for_EllipsesCharacterClassSymbolOnly(_EllipsesCharacterClassSymbol that) {
        forCharacterClassSymbolOnly(that);
    }

    public void for_EllipsesCharacterSymbolOnly(_EllipsesCharacterSymbol that) {
        forCharacterSymbolOnly(that);
    }

    public void for_EllipsesCharSymbolOnly(_EllipsesCharSymbol that) {
        forCharSymbolOnly(that);
    }

    public void for_EllipsesCharacterIntervalOnly(_EllipsesCharacterInterval that) {
        forCharacterIntervalOnly(that);
    }

    public void for_EllipsesLinkOnly(_EllipsesLink that) {
        forLinkOnly(that);
    }

    /* Methods to recur on each child. */
    public void forComponent(Component that) {
        forComponentDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recurOnListOfImport(that.getImports());
        recurOnListOfDecl(that.getDecls());
        recurOnListOfAPIName(that.getComprises());
        recurOnListOfAPIName(that.getExports());
        forComponentOnly(that);
    }

    public void forApi(Api that) {
        forApiDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recurOnListOfImport(that.getImports());
        recurOnListOfDecl(that.getDecls());
        recurOnListOfAPIName(that.getComprises());
        forApiOnly(that);
    }

    public void forImportStar(ImportStar that) {
        forImportStarDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getApiName());
        recurOnListOfIdOrOpOrAnonymousName(that.getExceptNames());
        forImportStarOnly(that);
    }

    public void forImportNames(ImportNames that) {
        forImportNamesDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getApiName());
        recurOnListOfAliasedSimpleName(that.getAliasedNames());
        forImportNamesOnly(that);
    }

    public void forImportApi(ImportApi that) {
        forImportApiDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnListOfAliasedAPIName(that.getApis());
        forImportApiOnly(that);
    }

    public void forAliasedSimpleName(AliasedSimpleName that) {
        forAliasedSimpleNameDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recurOnOptionOfIdOrOpOrAnonymousName(that.getAlias());
        forAliasedSimpleNameOnly(that);
    }

    public void forAliasedAPIName(AliasedAPIName that) {
        forAliasedAPINameDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getApiName());
        recurOnOptionOfId(that.getAlias());
        forAliasedAPINameOnly(that);
    }

    public void forTraitDecl(TraitDecl that) {
        forTraitDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnTraitTypeHeader(that.getHeader());
        recurOnOptionOfSelfType(that.getSelfType());
        recurOnListOfBaseType(that.getExcludesClause());
        recurOnOptionOfListOfNamedType(that.getComprisesClause());
        forTraitDeclOnly(that);
    }

    public void forObjectDecl(ObjectDecl that) {
        forObjectDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnTraitTypeHeader(that.getHeader());
        recurOnOptionOfSelfType(that.getSelfType());
        forObjectDeclOnly(that);
    }

    public void forVarDecl(VarDecl that) {
        forVarDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnListOfLValue(that.getLhs());
        recurOnOptionOfExpr(that.getInit());
        forVarDeclOnly(that);
    }

    public void forFnDecl(FnDecl that) {
        forFnDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnFnHeader(that.getHeader());
        recur(that.getUnambiguousName());
        recurOnOptionOfExpr(that.getBody());
        recurOnOptionOfIdOrOp(that.getImplementsUnambiguousName());
        forFnDeclOnly(that);
    }

    public void for_RewriteFnOverloadDecl(_RewriteFnOverloadDecl that) {
        for_RewriteFnOverloadDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recurOnListOfIdOrOp(that.getFns());
        recurOnOptionOfType(that.getType());
        for_RewriteFnOverloadDeclOnly(that);
    }

    public void for_RewriteObjectExprDecl(_RewriteObjectExprDecl that) {
        for_RewriteObjectExprDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnListOf_RewriteObjectExpr(that.getObjectExprs());
        for_RewriteObjectExprDeclOnly(that);
    }

    public void for_RewriteFunctionalMethodDecl(_RewriteFunctionalMethodDecl that) {
        for_RewriteFunctionalMethodDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_RewriteFunctionalMethodDeclOnly(that);
    }

    public void forDimDecl(DimDecl that) {
        forDimDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getDimId());
        recurOnOptionOfType(that.getDerived());
        recurOnOptionOfId(that.getDefaultId());
        forDimDeclOnly(that);
    }

    public void forUnitDecl(UnitDecl that) {
        forUnitDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnListOfId(that.getUnits());
        recurOnOptionOfType(that.getDimType());
        recurOnOptionOfExpr(that.getDefExpr());
        forUnitDeclOnly(that);
    }

    public void forTestDecl(TestDecl that) {
        forTestDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recurOnListOfGeneratorClause(that.getGens());
        recur(that.getExpr());
        forTestDeclOnly(that);
    }

    public void forPropertyDecl(PropertyDecl that) {
        forPropertyDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnOptionOfId(that.getName());
        recurOnListOfParam(that.getParams());
        recur(that.getExpr());
        forPropertyDeclOnly(that);
    }

    public void forTypeAlias(TypeAlias that) {
        forTypeAliasDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recurOnListOfStaticParam(that.getStaticParams());
        recur(that.getTypeDef());
        forTypeAliasOnly(that);
    }

    public void forGrammarDecl(GrammarDecl that) {
        forGrammarDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recurOnListOfId(that.getExtendsClause());
        recurOnListOfGrammarMemberDecl(that.getMembers());
        recurOnListOfTransformerDecl(that.getTransformers());
        forGrammarDeclOnly(that);
    }

    public void forNonterminalDef(NonterminalDef that) {
        forNonterminalDefDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        recur(that.getHeader());
        recurOnOptionOfBaseType(that.getAstType());
        forNonterminalDefOnly(that);
    }

    public void forNonterminalExtensionDef(NonterminalExtensionDef that) {
        forNonterminalExtensionDefDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        forNonterminalExtensionDefOnly(that);
    }

    public void forLValue(LValue that) {
        forLValueDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recurOnOptionOfTypeOrPattern(that.getIdType());
        forLValueOnly(that);
    }

    public void forParam(Param that) {
        forParamDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recurOnOptionOfTypeOrPattern(that.getIdType());
        recurOnOptionOfExpr(that.getDefaultExpr());
        recurOnOptionOfType(that.getVarargsType());
        forParamOnly(that);
    }

    public void forDummyExpr(DummyExpr that) {
        forDummyExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        forDummyExprOnly(that);
    }

    public void forAsExpr(AsExpr that) {
        forAsExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getExpr());
        recur(that.getAnnType());
        forAsExprOnly(that);
    }

    public void forAsIfExpr(AsIfExpr that) {
        forAsIfExprDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getExpr());
        recur(that.getAnnType());
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
        recur(that.getName());
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
        recur(that.getTestExpr());
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
        recur(that.getAccOp());
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
        recur(that.getVarId());
        recurOnListOfStaticArg(that.getStaticArgs());
        forVarRefOnly(that);
    }

    public void forFieldRef(FieldRef that) {
        forFieldRefDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getObj());
        recur(that.getField());
        forFieldRefOnly(that);
    }

    public void forFnRef(FnRef that) {
        forFnRefDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recurOnListOfStaticArg(that.getStaticArgs());
        recur(that.getOriginalName());
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
        recur(that.getOriginalName());
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
        recur(that.getToType());
        recur(that.getCoercionFn());
        forTraitCoercionInvocationOnly(that);
    }

    public void forTupleCoercionInvocation(TupleCoercionInvocation that) {
        forTupleCoercionInvocationDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getArg());
        recur(that.getToType());
        recurOnListOfOptionOfCoercionInvocation(that.getSubCoercions());
        recurOnOptionOfOptionOfCoercionInvocation(that.getVarargCoercion());
        forTupleCoercionInvocationOnly(that);
    }

    public void forArrowCoercionInvocation(ArrowCoercionInvocation that) {
        forArrowCoercionInvocationDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getArg());
        recur(that.getToType());
        recurOnOptionOfCoercionInvocation(that.getDomainCoercion());
        recurOnOptionOfCoercionInvocation(that.getRangeCoercion());
        forArrowCoercionInvocationOnly(that);
    }

    public void forUnionCoercionInvocation(UnionCoercionInvocation that) {
        forUnionCoercionInvocationDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getToType());
        recur(that.getArg());
        recurOnListOfType(that.getFromTypes());
        recurOnListOfOptionOfCoercionInvocation(that.getFromCoercions());
        forUnionCoercionInvocationOnly(that);
    }

    public void forMethodInvocation(MethodInvocation that) {
        forMethodInvocationDoFirst(that);
        recurOnExprInfo(that.getInfo());
        recur(that.getObj());
        recur(that.getMethod());
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

    public void forAnyType(AnyType that) {
        forAnyTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        forAnyTypeOnly(that);
    }

    public void forBottomType(BottomType that) {
        forBottomTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        forBottomTypeOnly(that);
    }

    public void forUnknownType(UnknownType that) {
        forUnknownTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        forUnknownTypeOnly(that);
    }

    public void forTraitSelfType(TraitSelfType that) {
        forTraitSelfTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getNamed());
        recurOnListOfNamedType(that.getComprised());
        forTraitSelfTypeOnly(that);
    }

    public void forObjectExprType(ObjectExprType that) {
        forObjectExprTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnListOfBaseType(that.getExtended());
        forObjectExprTypeOnly(that);
    }

    public void for_InferenceVarType(_InferenceVarType that) {
        for_InferenceVarTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getName());
        for_InferenceVarTypeOnly(that);
    }

    public void forVarType(VarType that) {
        forVarTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getName());
        forVarTypeOnly(that);
    }

    public void forTraitType(TraitType that) {
        forTraitTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getName());
        recurOnListOfStaticArg(that.getArgs());
        recurOnListOfStaticParam(that.getTraitStaticParams());
        forTraitTypeOnly(that);
    }

    public void forArrayType(ArrayType that) {
        forArrayTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getElemType());
        recur(that.getIndices());
        forArrayTypeOnly(that);
    }

    public void forMatrixType(MatrixType that) {
        forMatrixTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getElemType());
        recurOnListOfExtentRange(that.getDimensions());
        forMatrixTypeOnly(that);
    }

    public void forTaggedDimType(TaggedDimType that) {
        forTaggedDimTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getElemType());
        recur(that.getDimExpr());
        recurOnOptionOfExpr(that.getUnitExpr());
        forTaggedDimTypeOnly(that);
    }

    public void forTaggedUnitType(TaggedUnitType that) {
        forTaggedUnitTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getElemType());
        recur(that.getUnitExpr());
        forTaggedUnitTypeOnly(that);
    }

    public void forTupleType(TupleType that) {
        forTupleTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnListOfType(that.getElements());
        recurOnOptionOfType(that.getVarargs());
        recurOnListOfKeywordType(that.getKeywords());
        forTupleTypeOnly(that);
    }

    public void forArrowType(ArrowType that) {
        forArrowTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getDomain());
        recur(that.getRange());
        recur(that.getEffect());
        recurOnOptionOfMethodInfo(that.getMethodInfo());
        forArrowTypeOnly(that);
    }

    public void forIntersectionType(IntersectionType that) {
        forIntersectionTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnListOfType(that.getElements());
        forIntersectionTypeOnly(that);
    }

    public void forUnionType(UnionType that) {
        forUnionTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recurOnListOfType(that.getElements());
        forUnionTypeOnly(that);
    }

    public void forFixedPointType(FixedPointType that) {
        forFixedPointTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getName());
        recur(that.getBody());
        forFixedPointTypeOnly(that);
    }

    public void forLabelType(LabelType that) {
        forLabelTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        forLabelTypeOnly(that);
    }

    public void forDimBase(DimBase that) {
        forDimBaseDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        forDimBaseOnly(that);
    }

    public void forDimRef(DimRef that) {
        forDimRefDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getName());
        forDimRefOnly(that);
    }

    public void forDimExponent(DimExponent that) {
        forDimExponentDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getBase());
        recur(that.getPower());
        forDimExponentOnly(that);
    }

    public void forDimUnaryOp(DimUnaryOp that) {
        forDimUnaryOpDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getDimVal());
        recur(that.getOp());
        forDimUnaryOpOnly(that);
    }

    public void forDimBinaryOp(DimBinaryOp that) {
        forDimBinaryOpDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        recur(that.getLeft());
        recur(that.getRight());
        recur(that.getOp());
        forDimBinaryOpOnly(that);
    }

    public void forPattern(Pattern that) {
        forPatternDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnOptionOfType(that.getName());
        recur(that.getPatterns());
        forPatternOnly(that);
    }

    public void forPatternArgs(PatternArgs that) {
        forPatternArgsDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnListOfPatternBinding(that.getPatterns());
        forPatternArgsOnly(that);
    }

    public void forPlainPattern(PlainPattern that) {
        forPlainPatternDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnOptionOfId(that.getField());
        recur(that.getName());
        recurOnOptionOfTypeOrPattern(that.getIdType());
        forPlainPatternOnly(that);
    }

    public void forTypePattern(TypePattern that) {
        forTypePatternDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnOptionOfId(that.getField());
        recur(that.getTyp());
        forTypePatternOnly(that);
    }

    public void forNestedPattern(NestedPattern that) {
        forNestedPatternDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnOptionOfId(that.getField());
        recur(that.getPat());
        forNestedPatternOnly(that);
    }

    public void forTypeArg(TypeArg that) {
        forTypeArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getTypeArg());
        forTypeArgOnly(that);
    }

    public void forIntArg(IntArg that) {
        forIntArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getIntVal());
        forIntArgOnly(that);
    }

    public void forBoolArg(BoolArg that) {
        forBoolArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getBoolArg());
        forBoolArgOnly(that);
    }

    public void forOpArg(OpArg that) {
        forOpArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getId());
        forOpArgOnly(that);
    }

    public void forDimArg(DimArg that) {
        forDimArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getDimArg());
        forDimArgOnly(that);
    }

    public void forUnitArg(UnitArg that) {
        forUnitArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getUnitArg());
        forUnitArgOnly(that);
    }

    public void forIntBase(IntBase that) {
        forIntBaseDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getIntVal());
        forIntBaseOnly(that);
    }

    public void forIntRef(IntRef that) {
        forIntRefDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        forIntRefOnly(that);
    }

    public void forIntBinaryOp(IntBinaryOp that) {
        forIntBinaryOpDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getLeft());
        recur(that.getRight());
        recur(that.getOp());
        forIntBinaryOpOnly(that);
    }

    public void forBoolBase(BoolBase that) {
        forBoolBaseDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        forBoolBaseOnly(that);
    }

    public void forBoolRef(BoolRef that) {
        forBoolRefDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        forBoolRefOnly(that);
    }

    public void forBoolUnaryOp(BoolUnaryOp that) {
        forBoolUnaryOpDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getBoolVal());
        recur(that.getOp());
        forBoolUnaryOpOnly(that);
    }

    public void forBoolBinaryOp(BoolBinaryOp that) {
        forBoolBinaryOpDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getLeft());
        recur(that.getRight());
        recur(that.getOp());
        forBoolBinaryOpOnly(that);
    }

    public void forUnitRef(UnitRef that) {
        forUnitRefDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        forUnitRefOnly(that);
    }

    public void forUnitBinaryOp(UnitBinaryOp that) {
        forUnitBinaryOpDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getLeft());
        recur(that.getRight());
        recur(that.getOp());
        forUnitBinaryOpOnly(that);
    }

    public void forEffect(Effect that) {
        forEffectDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnOptionOfListOfType(that.getThrowsClause());
        forEffectOnly(that);
    }

    public void forWhereClause(WhereClause that) {
        forWhereClauseDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnListOfWhereBinding(that.getBindings());
        recurOnListOfWhereConstraint(that.getConstraints());
        forWhereClauseOnly(that);
    }

    public void forWhereBinding(WhereBinding that) {
        forWhereBindingDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recurOnListOfBaseType(that.getSupers());
        recurOnStaticParamKind(that.getKind());
        forWhereBindingOnly(that);
    }

    public void forWhereExtends(WhereExtends that) {
        forWhereExtendsDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recurOnListOfBaseType(that.getSupers());
        forWhereExtendsOnly(that);
    }

    public void forWhereTypeAlias(WhereTypeAlias that) {
        forWhereTypeAliasDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getAlias());
        forWhereTypeAliasOnly(that);
    }

    public void forWhereCoerces(WhereCoerces that) {
        forWhereCoercesDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getLeft());
        recur(that.getRight());
        forWhereCoercesOnly(that);
    }

    public void forWhereEquals(WhereEquals that) {
        forWhereEqualsDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getLeft());
        recur(that.getRight());
        forWhereEqualsOnly(that);
    }

    public void forUnitConstraint(UnitConstraint that) {
        forUnitConstraintDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        forUnitConstraintOnly(that);
    }

    public void forIntConstraint(IntConstraint that) {
        forIntConstraintDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getLeft());
        recur(that.getRight());
        recur(that.getOp());
        forIntConstraintOnly(that);
    }

    public void forBoolConstraintExpr(BoolConstraintExpr that) {
        forBoolConstraintExprDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getConstraint());
        forBoolConstraintExprOnly(that);
    }

    public void forContract(Contract that) {
        forContractDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnOptionOfListOfExpr(that.getRequiresClause());
        recurOnOptionOfListOfEnsuresClause(that.getEnsuresClause());
        recurOnOptionOfListOfExpr(that.getInvariantsClause());
        forContractOnly(that);
    }

    public void forEnsuresClause(EnsuresClause that) {
        forEnsuresClauseDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getPost());
        recurOnOptionOfExpr(that.getPre());
        forEnsuresClauseOnly(that);
    }

    public void forStaticParam(StaticParam that) {
        forStaticParamDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recurOnListOfBaseType(that.getExtendsClause());
        recurOnListOfBaseType(that.getDominatesClause());
        recurOnOptionOfType(that.getDimParam());
        recurOnStaticParamKind(that.getKind());
        forStaticParamOnly(that);
    }

    public void forAPIName(APIName that) {
        forAPINameDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnListOfId(that.getIds());
        forAPINameOnly(that);
    }

    public void forId(Id that) {
        forIdDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnOptionOfAPIName(that.getApiName());
        forIdOnly(that);
    }

    public void forNamedOp(NamedOp that) {
        forNamedOpDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnOptionOfAPIName(that.getApiName());
        recurOnFixity(that.getFixity());
        forNamedOpOnly(that);
    }

    public void for_InferenceVarOp(_InferenceVarOp that) {
        for_InferenceVarOpDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnOptionOfAPIName(that.getApiName());
        recurOnFixity(that.getFixity());
        for_InferenceVarOpOnly(that);
    }

    public void forAnonymousFnName(AnonymousFnName that) {
        forAnonymousFnNameDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnOptionOfAPIName(that.getApiName());
        forAnonymousFnNameOnly(that);
    }

    public void forConstructorFnName(ConstructorFnName that) {
        forConstructorFnNameDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnOptionOfAPIName(that.getApiName());
        recurOnObjectConstructor(that.getConstructor());
        forConstructorFnNameOnly(that);
    }

    public void forArrayComprehensionClause(ArrayComprehensionClause that) {
        forArrayComprehensionClauseDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnListOfExpr(that.getBind());
        recur(that.getInit());
        recurOnListOfGeneratorClause(that.getGens());
        forArrayComprehensionClauseOnly(that);
    }

    public void forKeywordExpr(KeywordExpr that) {
        forKeywordExprDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recur(that.getInit());
        forKeywordExprOnly(that);
    }

    public void forCaseClause(CaseClause that) {
        forCaseClauseDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getMatchClause());
        recur(that.getBody());
        recurOnOptionOfFunctionalRef(that.getOp());
        forCaseClauseOnly(that);
    }

    public void forCatch(Catch that) {
        forCatchDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recurOnListOfCatchClause(that.getClauses());
        forCatchOnly(that);
    }

    public void forCatchClause(CatchClause that) {
        forCatchClauseDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getMatchType());
        recur(that.getBody());
        forCatchClauseOnly(that);
    }

    public void forIfClause(IfClause that) {
        forIfClauseDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getTestClause());
        recur(that.getBody());
        forIfClauseOnly(that);
    }

    public void forTypecaseClause(TypecaseClause that) {
        forTypecaseClauseDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnOptionOfId(that.getName());
        recurOnTypeOrPattern(that.getMatchType());
        recur(that.getBody());
        forTypecaseClauseOnly(that);
    }

    public void forExtentRange(ExtentRange that) {
        forExtentRangeDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnOptionOfStaticArg(that.getBase());
        recurOnOptionOfStaticArg(that.getSize());
        recurOnOptionOfOp(that.getOp());
        forExtentRangeOnly(that);
    }

    public void forGeneratorClause(GeneratorClause that) {
        forGeneratorClauseDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnListOfId(that.getBind());
        recur(that.getInit());
        forGeneratorClauseOnly(that);
    }

    public void forKeywordType(KeywordType that) {
        forKeywordTypeDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recur(that.getKeywordType());
        forKeywordTypeOnly(that);
    }

    public void forTraitTypeWhere(TraitTypeWhere that) {
        forTraitTypeWhereDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getBaseType());
        recurOnOptionOfWhereClause(that.getWhereClause());
        forTraitTypeWhereOnly(that);
    }

    public void forIndices(Indices that) {
        forIndicesDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnListOfExtentRange(that.getExtents());
        forIndicesOnly(that);
    }

    public void forParenthesisDelimitedMI(ParenthesisDelimitedMI that) {
        forParenthesisDelimitedMIDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getExpr());
        forParenthesisDelimitedMIOnly(that);
    }

    public void forNonParenthesisDelimitedMI(NonParenthesisDelimitedMI that) {
        forNonParenthesisDelimitedMIDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getExpr());
        forNonParenthesisDelimitedMIOnly(that);
    }

    public void forExponentiationMI(ExponentiationMI that) {
        forExponentiationMIDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getOp());
        recurOnOptionOfExpr(that.getExpr());
        forExponentiationMIOnly(that);
    }

    public void forSubscriptingMI(SubscriptingMI that) {
        forSubscriptingMIDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getOp());
        recurOnListOfExpr(that.getExprs());
        recurOnListOfStaticArg(that.getStaticArgs());
        forSubscriptingMIOnly(that);
    }

    public void forOverloading(Overloading that) {
        forOverloadingDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getUnambiguousName());
        recur(that.getOriginalName());
        recurOnOptionOfArrowType(that.getType());
        recurOnOptionOfArrowType(that.getSchema());
        forOverloadingOnly(that);
    }

    public void forNonterminalHeader(NonterminalHeader that) {
        forNonterminalHeaderDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recurOnListOfNonterminalParameter(that.getParams());
        recurOnListOfStaticParam(that.getStaticParams());
        recurOnOptionOfType(that.getParamType());
        recurOnOptionOfWhereClause(that.getWhereClause());
        forNonterminalHeaderOnly(that);
    }

    public void forNonterminalParameter(NonterminalParameter that) {
        forNonterminalParameterDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getName());
        recur(that.getParamType());
        forNonterminalParameterOnly(that);
    }

    public void forSyntaxDef(SyntaxDef that) {
        forSyntaxDefDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnListOfSyntaxSymbol(that.getSyntaxSymbols());
        recur(that.getTransformer());
        forSyntaxDefOnly(that);
    }

    public void forSuperSyntaxDef(SuperSyntaxDef that) {
        forSuperSyntaxDefDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getNonterminal());
        recur(that.getGrammarId());
        forSuperSyntaxDefOnly(that);
    }

    public void forPreTransformerDef(PreTransformerDef that) {
        forPreTransformerDefDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getTransformer());
        forPreTransformerDefOnly(that);
    }

    public void forNamedTransformerDef(NamedTransformerDef that) {
        forNamedTransformerDefDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnListOfNonterminalParameter(that.getParameters());
        recur(that.getTransformer());
        forNamedTransformerDefOnly(that);
    }

    public void forUnparsedTransformer(UnparsedTransformer that) {
        forUnparsedTransformerDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getNonterminal());
        forUnparsedTransformerOnly(that);
    }

    public void forNodeTransformer(NodeTransformer that) {
        forNodeTransformerDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getNode());
        forNodeTransformerOnly(that);
    }

    public void forCaseTransformer(CaseTransformer that) {
        forCaseTransformerDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getGapName());
        recurOnListOfCaseTransformerClause(that.getClauses());
        forCaseTransformerOnly(that);
    }

    public void forCaseTransformerClause(CaseTransformerClause that) {
        forCaseTransformerClauseDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getConstructor());
        recurOnListOfId(that.getParameters());
        recur(that.getBody());
        forCaseTransformerClauseOnly(that);
    }

    public void forPrefixedSymbol(PrefixedSymbol that) {
        forPrefixedSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getId());
        recur(that.getSymbol());
        forPrefixedSymbolOnly(that);
    }

    public void forOptionalSymbol(OptionalSymbol that) {
        forOptionalSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getSymbol());
        forOptionalSymbolOnly(that);
    }

    public void forRepeatSymbol(RepeatSymbol that) {
        forRepeatSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getSymbol());
        forRepeatSymbolOnly(that);
    }

    public void forRepeatOneOrMoreSymbol(RepeatOneOrMoreSymbol that) {
        forRepeatOneOrMoreSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getSymbol());
        forRepeatOneOrMoreSymbolOnly(that);
    }

    public void forNoWhitespaceSymbol(NoWhitespaceSymbol that) {
        forNoWhitespaceSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getSymbol());
        forNoWhitespaceSymbolOnly(that);
    }

    public void forGroupSymbol(GroupSymbol that) {
        forGroupSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnListOfSyntaxSymbol(that.getSymbols());
        forGroupSymbolOnly(that);
    }

    public void forAnyCharacterSymbol(AnyCharacterSymbol that) {
        forAnyCharacterSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        forAnyCharacterSymbolOnly(that);
    }

    public void forWhitespaceSymbol(WhitespaceSymbol that) {
        forWhitespaceSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        forWhitespaceSymbolOnly(that);
    }

    public void forTabSymbol(TabSymbol that) {
        forTabSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        forTabSymbolOnly(that);
    }

    public void forFormfeedSymbol(FormfeedSymbol that) {
        forFormfeedSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        forFormfeedSymbolOnly(that);
    }

    public void forCarriageReturnSymbol(CarriageReturnSymbol that) {
        forCarriageReturnSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        forCarriageReturnSymbolOnly(that);
    }

    public void forBackspaceSymbol(BackspaceSymbol that) {
        forBackspaceSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        forBackspaceSymbolOnly(that);
    }

    public void forNewlineSymbol(NewlineSymbol that) {
        forNewlineSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        forNewlineSymbolOnly(that);
    }

    public void forBreaklineSymbol(BreaklineSymbol that) {
        forBreaklineSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        forBreaklineSymbolOnly(that);
    }

    public void forItemSymbol(ItemSymbol that) {
        forItemSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        forItemSymbolOnly(that);
    }

    public void forNonterminalSymbol(NonterminalSymbol that) {
        forNonterminalSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getNonterminal());
        forNonterminalSymbolOnly(that);
    }

    public void forKeywordSymbol(KeywordSymbol that) {
        forKeywordSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        forKeywordSymbolOnly(that);
    }

    public void forTokenSymbol(TokenSymbol that) {
        forTokenSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        forTokenSymbolOnly(that);
    }

    public void forNotPredicateSymbol(NotPredicateSymbol that) {
        forNotPredicateSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getSymbol());
        forNotPredicateSymbolOnly(that);
    }

    public void forAndPredicateSymbol(AndPredicateSymbol that) {
        forAndPredicateSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getSymbol());
        forAndPredicateSymbolOnly(that);
    }

    public void forCharacterClassSymbol(CharacterClassSymbol that) {
        forCharacterClassSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnListOfCharacterSymbol(that.getCharacters());
        forCharacterClassSymbolOnly(that);
    }

    public void forCharSymbol(CharSymbol that) {
        forCharSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        forCharSymbolOnly(that);
    }

    public void forCharacterInterval(CharacterInterval that) {
        forCharacterIntervalDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        forCharacterIntervalOnly(that);
    }

    public void forLink(Link that) {
        forLinkDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recur(that.getOp());
        recur(that.getExpr());
        forLinkOnly(that);
    }

    public void for_SyntaxTransformationAbstractNode(_SyntaxTransformationAbstractNode that) {
        for_SyntaxTransformationAbstractNodeDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationAbstractNodeOnly(that);
    }

    public void for_SyntaxTransformationCompilationUnit(_SyntaxTransformationCompilationUnit that) {
        for_SyntaxTransformationCompilationUnitDoFirst(that);
        recur(that.getName());
        recurOnListOfImport(that.getImports());
        recurOnListOfDecl(that.getDecls());
        recurOnListOfAPIName(that.getComprises());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationCompilationUnitOnly(that);
    }

    public void for_SyntaxTransformationComponent(_SyntaxTransformationComponent that) {
        for_SyntaxTransformationComponentDoFirst(that);
        recur(that.getName());
        recurOnListOfImport(that.getImports());
        recurOnListOfDecl(that.getDecls());
        recurOnListOfAPIName(that.getComprises());
        recurOnListOfAPIName(that.getExports());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationComponentOnly(that);
    }

    public void for_SyntaxTransformationApi(_SyntaxTransformationApi that) {
        for_SyntaxTransformationApiDoFirst(that);
        recur(that.getName());
        recurOnListOfImport(that.getImports());
        recurOnListOfDecl(that.getDecls());
        recurOnListOfAPIName(that.getComprises());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationApiOnly(that);
    }

    public void for_SyntaxTransformationImport(_SyntaxTransformationImport that) {
        for_SyntaxTransformationImportDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationImportOnly(that);
    }

    public void for_SyntaxTransformationImportedNames(_SyntaxTransformationImportedNames that) {
        for_SyntaxTransformationImportedNamesDoFirst(that);
        recur(that.getApiName());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationImportedNamesOnly(that);
    }

    public void for_SyntaxTransformationImportStar(_SyntaxTransformationImportStar that) {
        for_SyntaxTransformationImportStarDoFirst(that);
        recur(that.getApiName());
        recurOnListOfIdOrOpOrAnonymousName(that.getExceptNames());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationImportStarOnly(that);
    }

    public void for_SyntaxTransformationImportNames(_SyntaxTransformationImportNames that) {
        for_SyntaxTransformationImportNamesDoFirst(that);
        recur(that.getApiName());
        recurOnListOfAliasedSimpleName(that.getAliasedNames());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationImportNamesOnly(that);
    }

    public void for_SyntaxTransformationImportApi(_SyntaxTransformationImportApi that) {
        for_SyntaxTransformationImportApiDoFirst(that);
        recurOnListOfAliasedAPIName(that.getApis());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationImportApiOnly(that);
    }

    public void for_SyntaxTransformationAliasedSimpleName(_SyntaxTransformationAliasedSimpleName that) {
        for_SyntaxTransformationAliasedSimpleNameDoFirst(that);
        recur(that.getName());
        recurOnOptionOfIdOrOpOrAnonymousName(that.getAlias());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationAliasedSimpleNameOnly(that);
    }

    public void for_SyntaxTransformationAliasedAPIName(_SyntaxTransformationAliasedAPIName that) {
        for_SyntaxTransformationAliasedAPINameDoFirst(that);
        recur(that.getApiName());
        recurOnOptionOfId(that.getAlias());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationAliasedAPINameOnly(that);
    }

    public void for_SyntaxTransformationDecl(_SyntaxTransformationDecl that) {
        for_SyntaxTransformationDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationDeclOnly(that);
    }

    public void for_SyntaxTransformationTraitObjectDecl(_SyntaxTransformationTraitObjectDecl that) {
        for_SyntaxTransformationTraitObjectDeclDoFirst(that);
        recurOnTraitTypeHeader(that.getHeader());
        recurOnOptionOfSelfType(that.getSelfType());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationTraitObjectDeclOnly(that);
    }

    public void for_SyntaxTransformationTraitDecl(_SyntaxTransformationTraitDecl that) {
        for_SyntaxTransformationTraitDeclDoFirst(that);
        recurOnTraitTypeHeader(that.getHeader());
        recurOnOptionOfSelfType(that.getSelfType());
        recurOnListOfBaseType(that.getExcludesClause());
        recurOnOptionOfListOfNamedType(that.getComprisesClause());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationTraitDeclOnly(that);
    }

    public void for_SyntaxTransformationObjectDecl(_SyntaxTransformationObjectDecl that) {
        for_SyntaxTransformationObjectDeclDoFirst(that);
        recurOnTraitTypeHeader(that.getHeader());
        recurOnOptionOfSelfType(that.getSelfType());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationObjectDeclOnly(that);
    }

    public void for_SyntaxTransformationVarDecl(_SyntaxTransformationVarDecl that) {
        for_SyntaxTransformationVarDeclDoFirst(that);
        recurOnListOfLValue(that.getLhs());
        recurOnOptionOfExpr(that.getInit());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationVarDeclOnly(that);
    }

    public void for_SyntaxTransformationFnDecl(_SyntaxTransformationFnDecl that) {
        for_SyntaxTransformationFnDeclDoFirst(that);
        recurOnFnHeader(that.getHeader());
        recur(that.getUnambiguousName());
        recurOnOptionOfExpr(that.getBody());
        recurOnOptionOfIdOrOp(that.getImplementsUnambiguousName());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationFnDeclOnly(that);
    }

    public void for_SyntaxTransformation_RewriteFnOverloadDecl(_SyntaxTransformation_RewriteFnOverloadDecl that) {
        for_SyntaxTransformation_RewriteFnOverloadDeclDoFirst(that);
        recur(that.getName());
        recurOnListOfIdOrOp(that.getFns());
        recurOnOptionOfType(that.getType());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformation_RewriteFnOverloadDeclOnly(that);
    }

    public void for_SyntaxTransformation_RewriteObjectExprDecl(_SyntaxTransformation_RewriteObjectExprDecl that) {
        for_SyntaxTransformation_RewriteObjectExprDeclDoFirst(that);
        recurOnListOf_RewriteObjectExpr(that.getObjectExprs());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformation_RewriteObjectExprDeclOnly(that);
    }

    public void for_SyntaxTransformation_RewriteFunctionalMethodDecl(_SyntaxTransformation_RewriteFunctionalMethodDecl that) {
        for_SyntaxTransformation_RewriteFunctionalMethodDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformation_RewriteFunctionalMethodDeclOnly(that);
    }

    public void for_SyntaxTransformationDimUnitDecl(_SyntaxTransformationDimUnitDecl that) {
        for_SyntaxTransformationDimUnitDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationDimUnitDeclOnly(that);
    }

    public void for_SyntaxTransformationDimDecl(_SyntaxTransformationDimDecl that) {
        for_SyntaxTransformationDimDeclDoFirst(that);
        recur(that.getDimId());
        recurOnOptionOfType(that.getDerived());
        recurOnOptionOfId(that.getDefaultId());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationDimDeclOnly(that);
    }

    public void for_SyntaxTransformationUnitDecl(_SyntaxTransformationUnitDecl that) {
        for_SyntaxTransformationUnitDeclDoFirst(that);
        recurOnListOfId(that.getUnits());
        recurOnOptionOfType(that.getDimType());
        recurOnOptionOfExpr(that.getDefExpr());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationUnitDeclOnly(that);
    }

    public void for_SyntaxTransformationTestDecl(_SyntaxTransformationTestDecl that) {
        for_SyntaxTransformationTestDeclDoFirst(that);
        recur(that.getName());
        recurOnListOfGeneratorClause(that.getGens());
        recur(that.getExpr());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationTestDeclOnly(that);
    }

    public void for_SyntaxTransformationPropertyDecl(_SyntaxTransformationPropertyDecl that) {
        for_SyntaxTransformationPropertyDeclDoFirst(that);
        recurOnOptionOfId(that.getName());
        recurOnListOfParam(that.getParams());
        recur(that.getExpr());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationPropertyDeclOnly(that);
    }

    public void for_SyntaxTransformationTypeAlias(_SyntaxTransformationTypeAlias that) {
        for_SyntaxTransformationTypeAliasDoFirst(that);
        recur(that.getName());
        recurOnListOfStaticParam(that.getStaticParams());
        recur(that.getTypeDef());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationTypeAliasOnly(that);
    }

    public void for_SyntaxTransformationGrammarDecl(_SyntaxTransformationGrammarDecl that) {
        for_SyntaxTransformationGrammarDeclDoFirst(that);
        recur(that.getName());
        recurOnListOfId(that.getExtendsClause());
        recurOnListOfGrammarMemberDecl(that.getMembers());
        recurOnListOfTransformerDecl(that.getTransformers());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationGrammarDeclOnly(that);
    }

    public void for_SyntaxTransformationGrammarMemberDecl(_SyntaxTransformationGrammarMemberDecl that) {
        for_SyntaxTransformationGrammarMemberDeclDoFirst(that);
        recur(that.getName());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationGrammarMemberDeclOnly(that);
    }

    public void for_SyntaxTransformationNonterminalDecl(_SyntaxTransformationNonterminalDecl that) {
        for_SyntaxTransformationNonterminalDeclDoFirst(that);
        recur(that.getName());
        recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationNonterminalDeclOnly(that);
    }

    public void for_SyntaxTransformationNonterminalDef(_SyntaxTransformationNonterminalDef that) {
        for_SyntaxTransformationNonterminalDefDoFirst(that);
        recur(that.getName());
        recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        recur(that.getHeader());
        recurOnOptionOfBaseType(that.getAstType());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationNonterminalDefOnly(that);
    }

    public void for_SyntaxTransformationNonterminalExtensionDef(_SyntaxTransformationNonterminalExtensionDef that) {
        for_SyntaxTransformationNonterminalExtensionDefDoFirst(that);
        recur(that.getName());
        recurOnListOfSyntaxDecl(that.getSyntaxDecls());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationNonterminalExtensionDefOnly(that);
    }

    public void for_SyntaxTransformationBinding(_SyntaxTransformationBinding that) {
        for_SyntaxTransformationBindingDoFirst(that);
        recur(that.getName());
        recurOnOptionOfTypeOrPattern(that.getIdType());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationBindingOnly(that);
    }

    public void for_SyntaxTransformationLValue(_SyntaxTransformationLValue that) {
        for_SyntaxTransformationLValueDoFirst(that);
        recur(that.getName());
        recurOnOptionOfTypeOrPattern(that.getIdType());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationLValueOnly(that);
    }

    public void for_SyntaxTransformationParam(_SyntaxTransformationParam that) {
        for_SyntaxTransformationParamDoFirst(that);
        recur(that.getName());
        recurOnOptionOfTypeOrPattern(that.getIdType());
        recurOnOptionOfExpr(that.getDefaultExpr());
        recurOnOptionOfType(that.getVarargsType());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationParamOnly(that);
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
        recur(that.getAnnType());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationTypeAnnotatedExprOnly(that);
    }

    public void for_SyntaxTransformationAsExpr(_SyntaxTransformationAsExpr that) {
        for_SyntaxTransformationAsExprDoFirst(that);
        recur(that.getExpr());
        recur(that.getAnnType());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationAsExprOnly(that);
    }

    public void for_SyntaxTransformationAsIfExpr(_SyntaxTransformationAsIfExpr that) {
        for_SyntaxTransformationAsIfExprDoFirst(that);
        recur(that.getExpr());
        recur(that.getAnnType());
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
        recur(that.getName());
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
        recur(that.getTestExpr());
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
        recur(that.getAccOp());
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
        recur(that.getVarId());
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationVarRefOnly(that);
    }

    public void for_SyntaxTransformationFieldRef(_SyntaxTransformationFieldRef that) {
        for_SyntaxTransformationFieldRefDoFirst(that);
        recur(that.getObj());
        recur(that.getField());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationFieldRefOnly(that);
    }

    public void for_SyntaxTransformationFunctionalRef(_SyntaxTransformationFunctionalRef that) {
        for_SyntaxTransformationFunctionalRefDoFirst(that);
        recurOnListOfStaticArg(that.getStaticArgs());
        recur(that.getOriginalName());
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
        recur(that.getOriginalName());
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
        recur(that.getOriginalName());
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
        recur(that.getToType());
        recur(that.getArg());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationCoercionInvocationOnly(that);
    }

    public void for_SyntaxTransformationTraitCoercionInvocation(_SyntaxTransformationTraitCoercionInvocation that) {
        for_SyntaxTransformationTraitCoercionInvocationDoFirst(that);
        recur(that.getArg());
        recur(that.getToType());
        recur(that.getCoercionFn());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationTraitCoercionInvocationOnly(that);
    }

    public void for_SyntaxTransformationTupleCoercionInvocation(_SyntaxTransformationTupleCoercionInvocation that) {
        for_SyntaxTransformationTupleCoercionInvocationDoFirst(that);
        recur(that.getArg());
        recur(that.getToType());
        recurOnListOfOptionOfCoercionInvocation(that.getSubCoercions());
        recurOnOptionOfOptionOfCoercionInvocation(that.getVarargCoercion());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationTupleCoercionInvocationOnly(that);
    }

    public void for_SyntaxTransformationArrowCoercionInvocation(_SyntaxTransformationArrowCoercionInvocation that) {
        for_SyntaxTransformationArrowCoercionInvocationDoFirst(that);
        recur(that.getArg());
        recur(that.getToType());
        recurOnOptionOfCoercionInvocation(that.getDomainCoercion());
        recurOnOptionOfCoercionInvocation(that.getRangeCoercion());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationArrowCoercionInvocationOnly(that);
    }

    public void for_SyntaxTransformationUnionCoercionInvocation(_SyntaxTransformationUnionCoercionInvocation that) {
        for_SyntaxTransformationUnionCoercionInvocationDoFirst(that);
        recur(that.getToType());
        recur(that.getArg());
        recurOnListOfType(that.getFromTypes());
        recurOnListOfOptionOfCoercionInvocation(that.getFromCoercions());
        recurOnExprInfo(that.getInfo());
        for_SyntaxTransformationUnionCoercionInvocationOnly(that);
    }

    public void for_SyntaxTransformationMethodInvocation(_SyntaxTransformationMethodInvocation that) {
        for_SyntaxTransformationMethodInvocationDoFirst(that);
        recur(that.getObj());
        recur(that.getMethod());
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

    public void for_SyntaxTransformationType(_SyntaxTransformationType that) {
        for_SyntaxTransformationTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationTypeOnly(that);
    }

    public void for_SyntaxTransformationBaseType(_SyntaxTransformationBaseType that) {
        for_SyntaxTransformationBaseTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationBaseTypeOnly(that);
    }

    public void for_SyntaxTransformationAnyType(_SyntaxTransformationAnyType that) {
        for_SyntaxTransformationAnyTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationAnyTypeOnly(that);
    }

    public void for_SyntaxTransformationBottomType(_SyntaxTransformationBottomType that) {
        for_SyntaxTransformationBottomTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationBottomTypeOnly(that);
    }

    public void for_SyntaxTransformationUnknownType(_SyntaxTransformationUnknownType that) {
        for_SyntaxTransformationUnknownTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationUnknownTypeOnly(that);
    }

    public void for_SyntaxTransformationSelfType(_SyntaxTransformationSelfType that) {
        for_SyntaxTransformationSelfTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationSelfTypeOnly(that);
    }

    public void for_SyntaxTransformationTraitSelfType(_SyntaxTransformationTraitSelfType that) {
        for_SyntaxTransformationTraitSelfTypeDoFirst(that);
        recur(that.getNamed());
        recurOnListOfNamedType(that.getComprised());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationTraitSelfTypeOnly(that);
    }

    public void for_SyntaxTransformationObjectExprType(_SyntaxTransformationObjectExprType that) {
        for_SyntaxTransformationObjectExprTypeDoFirst(that);
        recurOnListOfBaseType(that.getExtended());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationObjectExprTypeOnly(that);
    }

    public void for_SyntaxTransformationNamedType(_SyntaxTransformationNamedType that) {
        for_SyntaxTransformationNamedTypeDoFirst(that);
        recur(that.getName());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationNamedTypeOnly(that);
    }

    public void for_SyntaxTransformation_InferenceVarType(_SyntaxTransformation_InferenceVarType that) {
        for_SyntaxTransformation_InferenceVarTypeDoFirst(that);
        recur(that.getName());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformation_InferenceVarTypeOnly(that);
    }

    public void for_SyntaxTransformationVarType(_SyntaxTransformationVarType that) {
        for_SyntaxTransformationVarTypeDoFirst(that);
        recur(that.getName());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationVarTypeOnly(that);
    }

    public void for_SyntaxTransformationTraitType(_SyntaxTransformationTraitType that) {
        for_SyntaxTransformationTraitTypeDoFirst(that);
        recur(that.getName());
        recurOnListOfStaticArg(that.getArgs());
        recurOnListOfStaticParam(that.getTraitStaticParams());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationTraitTypeOnly(that);
    }

    public void for_SyntaxTransformationAbbreviatedType(_SyntaxTransformationAbbreviatedType that) {
        for_SyntaxTransformationAbbreviatedTypeDoFirst(that);
        recur(that.getElemType());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationAbbreviatedTypeOnly(that);
    }

    public void for_SyntaxTransformationArrayType(_SyntaxTransformationArrayType that) {
        for_SyntaxTransformationArrayTypeDoFirst(that);
        recur(that.getElemType());
        recur(that.getIndices());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationArrayTypeOnly(that);
    }

    public void for_SyntaxTransformationMatrixType(_SyntaxTransformationMatrixType that) {
        for_SyntaxTransformationMatrixTypeDoFirst(that);
        recur(that.getElemType());
        recurOnListOfExtentRange(that.getDimensions());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationMatrixTypeOnly(that);
    }

    public void for_SyntaxTransformationTaggedDimType(_SyntaxTransformationTaggedDimType that) {
        for_SyntaxTransformationTaggedDimTypeDoFirst(that);
        recur(that.getElemType());
        recur(that.getDimExpr());
        recurOnOptionOfExpr(that.getUnitExpr());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationTaggedDimTypeOnly(that);
    }

    public void for_SyntaxTransformationTaggedUnitType(_SyntaxTransformationTaggedUnitType that) {
        for_SyntaxTransformationTaggedUnitTypeDoFirst(that);
        recur(that.getElemType());
        recur(that.getUnitExpr());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationTaggedUnitTypeOnly(that);
    }

    public void for_SyntaxTransformationTupleType(_SyntaxTransformationTupleType that) {
        for_SyntaxTransformationTupleTypeDoFirst(that);
        recurOnListOfType(that.getElements());
        recurOnOptionOfType(that.getVarargs());
        recurOnListOfKeywordType(that.getKeywords());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationTupleTypeOnly(that);
    }

    public void for_SyntaxTransformationArrowType(_SyntaxTransformationArrowType that) {
        for_SyntaxTransformationArrowTypeDoFirst(that);
        recur(that.getDomain());
        recur(that.getRange());
        recur(that.getEffect());
        recurOnOptionOfMethodInfo(that.getMethodInfo());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationArrowTypeOnly(that);
    }

    public void for_SyntaxTransformationBoundType(_SyntaxTransformationBoundType that) {
        for_SyntaxTransformationBoundTypeDoFirst(that);
        recurOnListOfType(that.getElements());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationBoundTypeOnly(that);
    }

    public void for_SyntaxTransformationIntersectionType(_SyntaxTransformationIntersectionType that) {
        for_SyntaxTransformationIntersectionTypeDoFirst(that);
        recurOnListOfType(that.getElements());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationIntersectionTypeOnly(that);
    }

    public void for_SyntaxTransformationUnionType(_SyntaxTransformationUnionType that) {
        for_SyntaxTransformationUnionTypeDoFirst(that);
        recurOnListOfType(that.getElements());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationUnionTypeOnly(that);
    }

    public void for_SyntaxTransformationFixedPointType(_SyntaxTransformationFixedPointType that) {
        for_SyntaxTransformationFixedPointTypeDoFirst(that);
        recur(that.getName());
        recur(that.getBody());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationFixedPointTypeOnly(that);
    }

    public void for_SyntaxTransformationLabelType(_SyntaxTransformationLabelType that) {
        for_SyntaxTransformationLabelTypeDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationLabelTypeOnly(that);
    }

    public void for_SyntaxTransformationDimExpr(_SyntaxTransformationDimExpr that) {
        for_SyntaxTransformationDimExprDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationDimExprOnly(that);
    }

    public void for_SyntaxTransformationDimBase(_SyntaxTransformationDimBase that) {
        for_SyntaxTransformationDimBaseDoFirst(that);
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationDimBaseOnly(that);
    }

    public void for_SyntaxTransformationDimRef(_SyntaxTransformationDimRef that) {
        for_SyntaxTransformationDimRefDoFirst(that);
        recur(that.getName());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationDimRefOnly(that);
    }

    public void for_SyntaxTransformationDimExponent(_SyntaxTransformationDimExponent that) {
        for_SyntaxTransformationDimExponentDoFirst(that);
        recur(that.getBase());
        recur(that.getPower());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationDimExponentOnly(that);
    }

    public void for_SyntaxTransformationDimUnaryOp(_SyntaxTransformationDimUnaryOp that) {
        for_SyntaxTransformationDimUnaryOpDoFirst(that);
        recur(that.getDimVal());
        recur(that.getOp());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationDimUnaryOpOnly(that);
    }

    public void for_SyntaxTransformationDimBinaryOp(_SyntaxTransformationDimBinaryOp that) {
        for_SyntaxTransformationDimBinaryOpDoFirst(that);
        recur(that.getLeft());
        recur(that.getRight());
        recur(that.getOp());
        recurOnTypeInfo(that.getInfo());
        for_SyntaxTransformationDimBinaryOpOnly(that);
    }

    public void for_SyntaxTransformationPattern(_SyntaxTransformationPattern that) {
        for_SyntaxTransformationPatternDoFirst(that);
        recurOnOptionOfType(that.getName());
        recur(that.getPatterns());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationPatternOnly(that);
    }

    public void for_SyntaxTransformationPatternArgs(_SyntaxTransformationPatternArgs that) {
        for_SyntaxTransformationPatternArgsDoFirst(that);
        recurOnListOfPatternBinding(that.getPatterns());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationPatternArgsOnly(that);
    }

    public void for_SyntaxTransformationPatternBinding(_SyntaxTransformationPatternBinding that) {
        for_SyntaxTransformationPatternBindingDoFirst(that);
        recurOnOptionOfId(that.getField());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationPatternBindingOnly(that);
    }

    public void for_SyntaxTransformationPlainPattern(_SyntaxTransformationPlainPattern that) {
        for_SyntaxTransformationPlainPatternDoFirst(that);
        recurOnOptionOfId(that.getField());
        recur(that.getName());
        recurOnOptionOfTypeOrPattern(that.getIdType());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationPlainPatternOnly(that);
    }

    public void for_SyntaxTransformationTypePattern(_SyntaxTransformationTypePattern that) {
        for_SyntaxTransformationTypePatternDoFirst(that);
        recurOnOptionOfId(that.getField());
        recur(that.getTyp());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationTypePatternOnly(that);
    }

    public void for_SyntaxTransformationNestedPattern(_SyntaxTransformationNestedPattern that) {
        for_SyntaxTransformationNestedPatternDoFirst(that);
        recurOnOptionOfId(that.getField());
        recur(that.getPat());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationNestedPatternOnly(that);
    }

    public void for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that) {
        for_SyntaxTransformationStaticArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationStaticArgOnly(that);
    }

    public void for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that) {
        for_SyntaxTransformationTypeArgDoFirst(that);
        recur(that.getTypeArg());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationTypeArgOnly(that);
    }

    public void for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that) {
        for_SyntaxTransformationIntArgDoFirst(that);
        recur(that.getIntVal());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationIntArgOnly(that);
    }

    public void for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that) {
        for_SyntaxTransformationBoolArgDoFirst(that);
        recur(that.getBoolArg());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationBoolArgOnly(that);
    }

    public void for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that) {
        for_SyntaxTransformationOpArgDoFirst(that);
        recur(that.getId());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationOpArgOnly(that);
    }

    public void for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that) {
        for_SyntaxTransformationDimArgDoFirst(that);
        recur(that.getDimArg());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationDimArgOnly(that);
    }

    public void for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that) {
        for_SyntaxTransformationUnitArgDoFirst(that);
        recur(that.getUnitArg());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationUnitArgOnly(that);
    }

    public void for_SyntaxTransformationStaticExpr(_SyntaxTransformationStaticExpr that) {
        for_SyntaxTransformationStaticExprDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationStaticExprOnly(that);
    }

    public void for_SyntaxTransformationIntExpr(_SyntaxTransformationIntExpr that) {
        for_SyntaxTransformationIntExprDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationIntExprOnly(that);
    }

    public void for_SyntaxTransformationIntBase(_SyntaxTransformationIntBase that) {
        for_SyntaxTransformationIntBaseDoFirst(that);
        recur(that.getIntVal());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationIntBaseOnly(that);
    }

    public void for_SyntaxTransformationIntRef(_SyntaxTransformationIntRef that) {
        for_SyntaxTransformationIntRefDoFirst(that);
        recur(that.getName());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationIntRefOnly(that);
    }

    public void for_SyntaxTransformationIntBinaryOp(_SyntaxTransformationIntBinaryOp that) {
        for_SyntaxTransformationIntBinaryOpDoFirst(that);
        recur(that.getLeft());
        recur(that.getRight());
        recur(that.getOp());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationIntBinaryOpOnly(that);
    }

    public void for_SyntaxTransformationBoolExpr(_SyntaxTransformationBoolExpr that) {
        for_SyntaxTransformationBoolExprDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationBoolExprOnly(that);
    }

    public void for_SyntaxTransformationBoolBase(_SyntaxTransformationBoolBase that) {
        for_SyntaxTransformationBoolBaseDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationBoolBaseOnly(that);
    }

    public void for_SyntaxTransformationBoolRef(_SyntaxTransformationBoolRef that) {
        for_SyntaxTransformationBoolRefDoFirst(that);
        recur(that.getName());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationBoolRefOnly(that);
    }

    public void for_SyntaxTransformationBoolConstraint(_SyntaxTransformationBoolConstraint that) {
        for_SyntaxTransformationBoolConstraintDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationBoolConstraintOnly(that);
    }

    public void for_SyntaxTransformationBoolUnaryOp(_SyntaxTransformationBoolUnaryOp that) {
        for_SyntaxTransformationBoolUnaryOpDoFirst(that);
        recur(that.getBoolVal());
        recur(that.getOp());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationBoolUnaryOpOnly(that);
    }

    public void for_SyntaxTransformationBoolBinaryOp(_SyntaxTransformationBoolBinaryOp that) {
        for_SyntaxTransformationBoolBinaryOpDoFirst(that);
        recur(that.getLeft());
        recur(that.getRight());
        recur(that.getOp());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationBoolBinaryOpOnly(that);
    }

    public void for_SyntaxTransformationUnitExpr(_SyntaxTransformationUnitExpr that) {
        for_SyntaxTransformationUnitExprDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationUnitExprOnly(that);
    }

    public void for_SyntaxTransformationUnitRef(_SyntaxTransformationUnitRef that) {
        for_SyntaxTransformationUnitRefDoFirst(that);
        recur(that.getName());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationUnitRefOnly(that);
    }

    public void for_SyntaxTransformationUnitBinaryOp(_SyntaxTransformationUnitBinaryOp that) {
        for_SyntaxTransformationUnitBinaryOpDoFirst(that);
        recur(that.getLeft());
        recur(that.getRight());
        recur(that.getOp());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationUnitBinaryOpOnly(that);
    }

    public void for_SyntaxTransformationEffect(_SyntaxTransformationEffect that) {
        for_SyntaxTransformationEffectDoFirst(that);
        recurOnOptionOfListOfType(that.getThrowsClause());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationEffectOnly(that);
    }

    public void for_SyntaxTransformationWhereClause(_SyntaxTransformationWhereClause that) {
        for_SyntaxTransformationWhereClauseDoFirst(that);
        recurOnListOfWhereBinding(that.getBindings());
        recurOnListOfWhereConstraint(that.getConstraints());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationWhereClauseOnly(that);
    }

    public void for_SyntaxTransformationWhereBinding(_SyntaxTransformationWhereBinding that) {
        for_SyntaxTransformationWhereBindingDoFirst(that);
        recur(that.getName());
        recurOnListOfBaseType(that.getSupers());
        recurOnStaticParamKind(that.getKind());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationWhereBindingOnly(that);
    }

    public void for_SyntaxTransformationWhereConstraint(_SyntaxTransformationWhereConstraint that) {
        for_SyntaxTransformationWhereConstraintDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationWhereConstraintOnly(that);
    }

    public void for_SyntaxTransformationWhereExtends(_SyntaxTransformationWhereExtends that) {
        for_SyntaxTransformationWhereExtendsDoFirst(that);
        recur(that.getName());
        recurOnListOfBaseType(that.getSupers());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationWhereExtendsOnly(that);
    }

    public void for_SyntaxTransformationWhereTypeAlias(_SyntaxTransformationWhereTypeAlias that) {
        for_SyntaxTransformationWhereTypeAliasDoFirst(that);
        recur(that.getAlias());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationWhereTypeAliasOnly(that);
    }

    public void for_SyntaxTransformationWhereCoerces(_SyntaxTransformationWhereCoerces that) {
        for_SyntaxTransformationWhereCoercesDoFirst(that);
        recur(that.getLeft());
        recur(that.getRight());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationWhereCoercesOnly(that);
    }

    public void for_SyntaxTransformationWhereEquals(_SyntaxTransformationWhereEquals that) {
        for_SyntaxTransformationWhereEqualsDoFirst(that);
        recur(that.getLeft());
        recur(that.getRight());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationWhereEqualsOnly(that);
    }

    public void for_SyntaxTransformationUnitConstraint(_SyntaxTransformationUnitConstraint that) {
        for_SyntaxTransformationUnitConstraintDoFirst(that);
        recur(that.getName());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationUnitConstraintOnly(that);
    }

    public void for_SyntaxTransformationIntConstraint(_SyntaxTransformationIntConstraint that) {
        for_SyntaxTransformationIntConstraintDoFirst(that);
        recur(that.getLeft());
        recur(that.getRight());
        recur(that.getOp());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationIntConstraintOnly(that);
    }

    public void for_SyntaxTransformationBoolConstraintExpr(_SyntaxTransformationBoolConstraintExpr that) {
        for_SyntaxTransformationBoolConstraintExprDoFirst(that);
        recur(that.getConstraint());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationBoolConstraintExprOnly(that);
    }

    public void for_SyntaxTransformationContract(_SyntaxTransformationContract that) {
        for_SyntaxTransformationContractDoFirst(that);
        recurOnOptionOfListOfExpr(that.getRequiresClause());
        recurOnOptionOfListOfEnsuresClause(that.getEnsuresClause());
        recurOnOptionOfListOfExpr(that.getInvariantsClause());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationContractOnly(that);
    }

    public void for_SyntaxTransformationEnsuresClause(_SyntaxTransformationEnsuresClause that) {
        for_SyntaxTransformationEnsuresClauseDoFirst(that);
        recur(that.getPost());
        recurOnOptionOfExpr(that.getPre());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationEnsuresClauseOnly(that);
    }

    public void for_SyntaxTransformationStaticParam(_SyntaxTransformationStaticParam that) {
        for_SyntaxTransformationStaticParamDoFirst(that);
        recur(that.getName());
        recurOnListOfBaseType(that.getExtendsClause());
        recurOnListOfBaseType(that.getDominatesClause());
        recurOnOptionOfType(that.getDimParam());
        recurOnStaticParamKind(that.getKind());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationStaticParamOnly(that);
    }

    public void for_SyntaxTransformationName(_SyntaxTransformationName that) {
        for_SyntaxTransformationNameDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationNameOnly(that);
    }

    public void for_SyntaxTransformationAPIName(_SyntaxTransformationAPIName that) {
        for_SyntaxTransformationAPINameDoFirst(that);
        recurOnListOfId(that.getIds());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationAPINameOnly(that);
    }

    public void for_SyntaxTransformationIdOrOpOrAnonymousName(_SyntaxTransformationIdOrOpOrAnonymousName that) {
        for_SyntaxTransformationIdOrOpOrAnonymousNameDoFirst(that);
        recurOnOptionOfAPIName(that.getApiName());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationIdOrOpOrAnonymousNameOnly(that);
    }

    public void for_SyntaxTransformationIdOrOp(_SyntaxTransformationIdOrOp that) {
        for_SyntaxTransformationIdOrOpDoFirst(that);
        recurOnOptionOfAPIName(that.getApiName());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationIdOrOpOnly(that);
    }

    public void for_SyntaxTransformationId(_SyntaxTransformationId that) {
        for_SyntaxTransformationIdDoFirst(that);
        recurOnOptionOfAPIName(that.getApiName());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationIdOnly(that);
    }

    public void for_SyntaxTransformationOp(_SyntaxTransformationOp that) {
        for_SyntaxTransformationOpDoFirst(that);
        recurOnOptionOfAPIName(that.getApiName());
        recurOnFixity(that.getFixity());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationOpOnly(that);
    }

    public void for_SyntaxTransformationNamedOp(_SyntaxTransformationNamedOp that) {
        for_SyntaxTransformationNamedOpDoFirst(that);
        recurOnOptionOfAPIName(that.getApiName());
        recurOnFixity(that.getFixity());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationNamedOpOnly(that);
    }

    public void for_SyntaxTransformation_InferenceVarOp(_SyntaxTransformation_InferenceVarOp that) {
        for_SyntaxTransformation_InferenceVarOpDoFirst(that);
        recurOnOptionOfAPIName(that.getApiName());
        recurOnFixity(that.getFixity());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformation_InferenceVarOpOnly(that);
    }

    public void for_SyntaxTransformationAnonymousName(_SyntaxTransformationAnonymousName that) {
        for_SyntaxTransformationAnonymousNameDoFirst(that);
        recurOnOptionOfAPIName(that.getApiName());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationAnonymousNameOnly(that);
    }

    public void for_SyntaxTransformationAnonymousFnName(_SyntaxTransformationAnonymousFnName that) {
        for_SyntaxTransformationAnonymousFnNameDoFirst(that);
        recurOnOptionOfAPIName(that.getApiName());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationAnonymousFnNameOnly(that);
    }

    public void for_SyntaxTransformationConstructorFnName(_SyntaxTransformationConstructorFnName that) {
        for_SyntaxTransformationConstructorFnNameDoFirst(that);
        recurOnOptionOfAPIName(that.getApiName());
        recurOnObjectConstructor(that.getConstructor());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationConstructorFnNameOnly(that);
    }

    public void for_SyntaxTransformationArrayComprehensionClause(_SyntaxTransformationArrayComprehensionClause that) {
        for_SyntaxTransformationArrayComprehensionClauseDoFirst(that);
        recurOnListOfExpr(that.getBind());
        recur(that.getInit());
        recurOnListOfGeneratorClause(that.getGens());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationArrayComprehensionClauseOnly(that);
    }

    public void for_SyntaxTransformationKeywordExpr(_SyntaxTransformationKeywordExpr that) {
        for_SyntaxTransformationKeywordExprDoFirst(that);
        recur(that.getName());
        recur(that.getInit());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationKeywordExprOnly(that);
    }

    public void for_SyntaxTransformationCaseClause(_SyntaxTransformationCaseClause that) {
        for_SyntaxTransformationCaseClauseDoFirst(that);
        recur(that.getMatchClause());
        recur(that.getBody());
        recurOnOptionOfFunctionalRef(that.getOp());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationCaseClauseOnly(that);
    }

    public void for_SyntaxTransformationCatch(_SyntaxTransformationCatch that) {
        for_SyntaxTransformationCatchDoFirst(that);
        recur(that.getName());
        recurOnListOfCatchClause(that.getClauses());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationCatchOnly(that);
    }

    public void for_SyntaxTransformationCatchClause(_SyntaxTransformationCatchClause that) {
        for_SyntaxTransformationCatchClauseDoFirst(that);
        recur(that.getMatchType());
        recur(that.getBody());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationCatchClauseOnly(that);
    }

    public void for_SyntaxTransformationIfClause(_SyntaxTransformationIfClause that) {
        for_SyntaxTransformationIfClauseDoFirst(that);
        recur(that.getTestClause());
        recur(that.getBody());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationIfClauseOnly(that);
    }

    public void for_SyntaxTransformationTypecaseClause(_SyntaxTransformationTypecaseClause that) {
        for_SyntaxTransformationTypecaseClauseDoFirst(that);
        recurOnOptionOfId(that.getName());
        recurOnTypeOrPattern(that.getMatchType());
        recur(that.getBody());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationTypecaseClauseOnly(that);
    }

    public void for_SyntaxTransformationExtentRange(_SyntaxTransformationExtentRange that) {
        for_SyntaxTransformationExtentRangeDoFirst(that);
        recurOnOptionOfStaticArg(that.getBase());
        recurOnOptionOfStaticArg(that.getSize());
        recurOnOptionOfOp(that.getOp());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationExtentRangeOnly(that);
    }

    public void for_SyntaxTransformationGeneratorClause(_SyntaxTransformationGeneratorClause that) {
        for_SyntaxTransformationGeneratorClauseDoFirst(that);
        recurOnListOfId(that.getBind());
        recur(that.getInit());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationGeneratorClauseOnly(that);
    }

    public void for_SyntaxTransformationKeywordType(_SyntaxTransformationKeywordType that) {
        for_SyntaxTransformationKeywordTypeDoFirst(that);
        recur(that.getName());
        recur(that.getKeywordType());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationKeywordTypeOnly(that);
    }

    public void for_SyntaxTransformationTraitTypeWhere(_SyntaxTransformationTraitTypeWhere that) {
        for_SyntaxTransformationTraitTypeWhereDoFirst(that);
        recur(that.getBaseType());
        recurOnOptionOfWhereClause(that.getWhereClause());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationTraitTypeWhereOnly(that);
    }

    public void for_SyntaxTransformationIndices(_SyntaxTransformationIndices that) {
        for_SyntaxTransformationIndicesDoFirst(that);
        recurOnListOfExtentRange(that.getExtents());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationIndicesOnly(that);
    }

    public void for_SyntaxTransformationMathItem(_SyntaxTransformationMathItem that) {
        for_SyntaxTransformationMathItemDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationMathItemOnly(that);
    }

    public void for_SyntaxTransformationExprMI(_SyntaxTransformationExprMI that) {
        for_SyntaxTransformationExprMIDoFirst(that);
        recur(that.getExpr());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationExprMIOnly(that);
    }

    public void for_SyntaxTransformationParenthesisDelimitedMI(_SyntaxTransformationParenthesisDelimitedMI that) {
        for_SyntaxTransformationParenthesisDelimitedMIDoFirst(that);
        recur(that.getExpr());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationParenthesisDelimitedMIOnly(that);
    }

    public void for_SyntaxTransformationNonParenthesisDelimitedMI(_SyntaxTransformationNonParenthesisDelimitedMI that) {
        for_SyntaxTransformationNonParenthesisDelimitedMIDoFirst(that);
        recur(that.getExpr());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationNonParenthesisDelimitedMIOnly(that);
    }

    public void for_SyntaxTransformationNonExprMI(_SyntaxTransformationNonExprMI that) {
        for_SyntaxTransformationNonExprMIDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationNonExprMIOnly(that);
    }

    public void for_SyntaxTransformationExponentiationMI(_SyntaxTransformationExponentiationMI that) {
        for_SyntaxTransformationExponentiationMIDoFirst(that);
        recur(that.getOp());
        recurOnOptionOfExpr(that.getExpr());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationExponentiationMIOnly(that);
    }

    public void for_SyntaxTransformationSubscriptingMI(_SyntaxTransformationSubscriptingMI that) {
        for_SyntaxTransformationSubscriptingMIDoFirst(that);
        recur(that.getOp());
        recurOnListOfExpr(that.getExprs());
        recurOnListOfStaticArg(that.getStaticArgs());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationSubscriptingMIOnly(that);
    }

    public void for_SyntaxTransformationOverloading(_SyntaxTransformationOverloading that) {
        for_SyntaxTransformationOverloadingDoFirst(that);
        recur(that.getUnambiguousName());
        recur(that.getOriginalName());
        recurOnOptionOfArrowType(that.getType());
        recurOnOptionOfArrowType(that.getSchema());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationOverloadingOnly(that);
    }

    public void for_SyntaxTransformationNonterminalHeader(_SyntaxTransformationNonterminalHeader that) {
        for_SyntaxTransformationNonterminalHeaderDoFirst(that);
        recur(that.getName());
        recurOnListOfNonterminalParameter(that.getParams());
        recurOnListOfStaticParam(that.getStaticParams());
        recurOnOptionOfType(that.getParamType());
        recurOnOptionOfWhereClause(that.getWhereClause());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationNonterminalHeaderOnly(that);
    }

    public void for_SyntaxTransformationNonterminalParameter(_SyntaxTransformationNonterminalParameter that) {
        for_SyntaxTransformationNonterminalParameterDoFirst(that);
        recur(that.getName());
        recur(that.getParamType());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationNonterminalParameterOnly(that);
    }

    public void for_SyntaxTransformationSyntaxDecl(_SyntaxTransformationSyntaxDecl that) {
        for_SyntaxTransformationSyntaxDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationSyntaxDeclOnly(that);
    }

    public void for_SyntaxTransformationSyntaxDef(_SyntaxTransformationSyntaxDef that) {
        for_SyntaxTransformationSyntaxDefDoFirst(that);
        recurOnListOfSyntaxSymbol(that.getSyntaxSymbols());
        recur(that.getTransformer());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationSyntaxDefOnly(that);
    }

    public void for_SyntaxTransformationSuperSyntaxDef(_SyntaxTransformationSuperSyntaxDef that) {
        for_SyntaxTransformationSuperSyntaxDefDoFirst(that);
        recur(that.getNonterminal());
        recur(that.getGrammarId());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationSuperSyntaxDefOnly(that);
    }

    public void for_SyntaxTransformationTransformerDecl(_SyntaxTransformationTransformerDecl that) {
        for_SyntaxTransformationTransformerDeclDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationTransformerDeclOnly(that);
    }

    public void for_SyntaxTransformationPreTransformerDef(_SyntaxTransformationPreTransformerDef that) {
        for_SyntaxTransformationPreTransformerDefDoFirst(that);
        recur(that.getTransformer());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationPreTransformerDefOnly(that);
    }

    public void for_SyntaxTransformationNamedTransformerDef(_SyntaxTransformationNamedTransformerDef that) {
        for_SyntaxTransformationNamedTransformerDefDoFirst(that);
        recurOnListOfNonterminalParameter(that.getParameters());
        recur(that.getTransformer());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationNamedTransformerDefOnly(that);
    }

    public void for_SyntaxTransformationTransformer(_SyntaxTransformationTransformer that) {
        for_SyntaxTransformationTransformerDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationTransformerOnly(that);
    }

    public void for_SyntaxTransformationUnparsedTransformer(_SyntaxTransformationUnparsedTransformer that) {
        for_SyntaxTransformationUnparsedTransformerDoFirst(that);
        recur(that.getNonterminal());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationUnparsedTransformerOnly(that);
    }

    public void for_SyntaxTransformationNodeTransformer(_SyntaxTransformationNodeTransformer that) {
        for_SyntaxTransformationNodeTransformerDoFirst(that);
        recur(that.getNode());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationNodeTransformerOnly(that);
    }

    public void for_SyntaxTransformationCaseTransformer(_SyntaxTransformationCaseTransformer that) {
        for_SyntaxTransformationCaseTransformerDoFirst(that);
        recur(that.getGapName());
        recurOnListOfCaseTransformerClause(that.getClauses());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationCaseTransformerOnly(that);
    }

    public void for_SyntaxTransformationCaseTransformerClause(_SyntaxTransformationCaseTransformerClause that) {
        for_SyntaxTransformationCaseTransformerClauseDoFirst(that);
        recur(that.getConstructor());
        recurOnListOfId(that.getParameters());
        recur(that.getBody());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationCaseTransformerClauseOnly(that);
    }

    public void for_SyntaxTransformationSyntaxSymbol(_SyntaxTransformationSyntaxSymbol that) {
        for_SyntaxTransformationSyntaxSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationSyntaxSymbolOnly(that);
    }

    public void for_SyntaxTransformationPrefixedSymbol(_SyntaxTransformationPrefixedSymbol that) {
        for_SyntaxTransformationPrefixedSymbolDoFirst(that);
        recur(that.getId());
        recur(that.getSymbol());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationPrefixedSymbolOnly(that);
    }

    public void for_SyntaxTransformationOptionalSymbol(_SyntaxTransformationOptionalSymbol that) {
        for_SyntaxTransformationOptionalSymbolDoFirst(that);
        recur(that.getSymbol());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationOptionalSymbolOnly(that);
    }

    public void for_SyntaxTransformationRepeatSymbol(_SyntaxTransformationRepeatSymbol that) {
        for_SyntaxTransformationRepeatSymbolDoFirst(that);
        recur(that.getSymbol());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationRepeatSymbolOnly(that);
    }

    public void for_SyntaxTransformationRepeatOneOrMoreSymbol(_SyntaxTransformationRepeatOneOrMoreSymbol that) {
        for_SyntaxTransformationRepeatOneOrMoreSymbolDoFirst(that);
        recur(that.getSymbol());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationRepeatOneOrMoreSymbolOnly(that);
    }

    public void for_SyntaxTransformationNoWhitespaceSymbol(_SyntaxTransformationNoWhitespaceSymbol that) {
        for_SyntaxTransformationNoWhitespaceSymbolDoFirst(that);
        recur(that.getSymbol());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationNoWhitespaceSymbolOnly(that);
    }

    public void for_SyntaxTransformationGroupSymbol(_SyntaxTransformationGroupSymbol that) {
        for_SyntaxTransformationGroupSymbolDoFirst(that);
        recurOnListOfSyntaxSymbol(that.getSymbols());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationGroupSymbolOnly(that);
    }

    public void for_SyntaxTransformationSpecialSymbol(_SyntaxTransformationSpecialSymbol that) {
        for_SyntaxTransformationSpecialSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationSpecialSymbolOnly(that);
    }

    public void for_SyntaxTransformationAnyCharacterSymbol(_SyntaxTransformationAnyCharacterSymbol that) {
        for_SyntaxTransformationAnyCharacterSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationAnyCharacterSymbolOnly(that);
    }

    public void for_SyntaxTransformationWhitespaceSymbol(_SyntaxTransformationWhitespaceSymbol that) {
        for_SyntaxTransformationWhitespaceSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationWhitespaceSymbolOnly(that);
    }

    public void for_SyntaxTransformationTabSymbol(_SyntaxTransformationTabSymbol that) {
        for_SyntaxTransformationTabSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationTabSymbolOnly(that);
    }

    public void for_SyntaxTransformationFormfeedSymbol(_SyntaxTransformationFormfeedSymbol that) {
        for_SyntaxTransformationFormfeedSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationFormfeedSymbolOnly(that);
    }

    public void for_SyntaxTransformationCarriageReturnSymbol(_SyntaxTransformationCarriageReturnSymbol that) {
        for_SyntaxTransformationCarriageReturnSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationCarriageReturnSymbolOnly(that);
    }

    public void for_SyntaxTransformationBackspaceSymbol(_SyntaxTransformationBackspaceSymbol that) {
        for_SyntaxTransformationBackspaceSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationBackspaceSymbolOnly(that);
    }

    public void for_SyntaxTransformationNewlineSymbol(_SyntaxTransformationNewlineSymbol that) {
        for_SyntaxTransformationNewlineSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationNewlineSymbolOnly(that);
    }

    public void for_SyntaxTransformationBreaklineSymbol(_SyntaxTransformationBreaklineSymbol that) {
        for_SyntaxTransformationBreaklineSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationBreaklineSymbolOnly(that);
    }

    public void for_SyntaxTransformationItemSymbol(_SyntaxTransformationItemSymbol that) {
        for_SyntaxTransformationItemSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationItemSymbolOnly(that);
    }

    public void for_SyntaxTransformationNonterminalSymbol(_SyntaxTransformationNonterminalSymbol that) {
        for_SyntaxTransformationNonterminalSymbolDoFirst(that);
        recur(that.getNonterminal());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationNonterminalSymbolOnly(that);
    }

    public void for_SyntaxTransformationKeywordSymbol(_SyntaxTransformationKeywordSymbol that) {
        for_SyntaxTransformationKeywordSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationKeywordSymbolOnly(that);
    }

    public void for_SyntaxTransformationTokenSymbol(_SyntaxTransformationTokenSymbol that) {
        for_SyntaxTransformationTokenSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationTokenSymbolOnly(that);
    }

    public void for_SyntaxTransformationNotPredicateSymbol(_SyntaxTransformationNotPredicateSymbol that) {
        for_SyntaxTransformationNotPredicateSymbolDoFirst(that);
        recur(that.getSymbol());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationNotPredicateSymbolOnly(that);
    }

    public void for_SyntaxTransformationAndPredicateSymbol(_SyntaxTransformationAndPredicateSymbol that) {
        for_SyntaxTransformationAndPredicateSymbolDoFirst(that);
        recur(that.getSymbol());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationAndPredicateSymbolOnly(that);
    }

    public void for_SyntaxTransformationCharacterClassSymbol(_SyntaxTransformationCharacterClassSymbol that) {
        for_SyntaxTransformationCharacterClassSymbolDoFirst(that);
        recurOnListOfCharacterSymbol(that.getCharacters());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationCharacterClassSymbolOnly(that);
    }

    public void for_SyntaxTransformationCharacterSymbol(_SyntaxTransformationCharacterSymbol that) {
        for_SyntaxTransformationCharacterSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationCharacterSymbolOnly(that);
    }

    public void for_SyntaxTransformationCharSymbol(_SyntaxTransformationCharSymbol that) {
        for_SyntaxTransformationCharSymbolDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationCharSymbolOnly(that);
    }

    public void for_SyntaxTransformationCharacterInterval(_SyntaxTransformationCharacterInterval that) {
        for_SyntaxTransformationCharacterIntervalDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationCharacterIntervalOnly(that);
    }

    public void for_SyntaxTransformationLink(_SyntaxTransformationLink that) {
        for_SyntaxTransformationLinkDoFirst(that);
        recur(that.getOp());
        recur(that.getExpr());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationLinkOnly(that);
    }

    public void for_EllipsesAbstractNode(_EllipsesAbstractNode that) {
        for_EllipsesAbstractNodeDoFirst(that);
        for_EllipsesAbstractNodeOnly(that);
    }

    public void for_EllipsesCompilationUnit(_EllipsesCompilationUnit that) {
        for_EllipsesCompilationUnitDoFirst(that);
        for_EllipsesCompilationUnitOnly(that);
    }

    public void for_EllipsesComponent(_EllipsesComponent that) {
        for_EllipsesComponentDoFirst(that);
        for_EllipsesComponentOnly(that);
    }

    public void for_EllipsesApi(_EllipsesApi that) {
        for_EllipsesApiDoFirst(that);
        for_EllipsesApiOnly(that);
    }

    public void for_EllipsesImport(_EllipsesImport that) {
        for_EllipsesImportDoFirst(that);
        for_EllipsesImportOnly(that);
    }

    public void for_EllipsesImportedNames(_EllipsesImportedNames that) {
        for_EllipsesImportedNamesDoFirst(that);
        for_EllipsesImportedNamesOnly(that);
    }

    public void for_EllipsesImportStar(_EllipsesImportStar that) {
        for_EllipsesImportStarDoFirst(that);
        for_EllipsesImportStarOnly(that);
    }

    public void for_EllipsesImportNames(_EllipsesImportNames that) {
        for_EllipsesImportNamesDoFirst(that);
        for_EllipsesImportNamesOnly(that);
    }

    public void for_EllipsesImportApi(_EllipsesImportApi that) {
        for_EllipsesImportApiDoFirst(that);
        for_EllipsesImportApiOnly(that);
    }

    public void for_EllipsesAliasedSimpleName(_EllipsesAliasedSimpleName that) {
        for_EllipsesAliasedSimpleNameDoFirst(that);
        for_EllipsesAliasedSimpleNameOnly(that);
    }

    public void for_EllipsesAliasedAPIName(_EllipsesAliasedAPIName that) {
        for_EllipsesAliasedAPINameDoFirst(that);
        for_EllipsesAliasedAPINameOnly(that);
    }

    public void for_EllipsesDecl(_EllipsesDecl that) {
        for_EllipsesDeclDoFirst(that);
        for_EllipsesDeclOnly(that);
    }

    public void for_EllipsesTraitObjectDecl(_EllipsesTraitObjectDecl that) {
        for_EllipsesTraitObjectDeclDoFirst(that);
        for_EllipsesTraitObjectDeclOnly(that);
    }

    public void for_EllipsesTraitDecl(_EllipsesTraitDecl that) {
        for_EllipsesTraitDeclDoFirst(that);
        for_EllipsesTraitDeclOnly(that);
    }

    public void for_EllipsesObjectDecl(_EllipsesObjectDecl that) {
        for_EllipsesObjectDeclDoFirst(that);
        for_EllipsesObjectDeclOnly(that);
    }

    public void for_EllipsesVarDecl(_EllipsesVarDecl that) {
        for_EllipsesVarDeclDoFirst(that);
        for_EllipsesVarDeclOnly(that);
    }

    public void for_EllipsesFnDecl(_EllipsesFnDecl that) {
        for_EllipsesFnDeclDoFirst(that);
        for_EllipsesFnDeclOnly(that);
    }

    public void for_Ellipses_RewriteFnOverloadDecl(_Ellipses_RewriteFnOverloadDecl that) {
        for_Ellipses_RewriteFnOverloadDeclDoFirst(that);
        for_Ellipses_RewriteFnOverloadDeclOnly(that);
    }

    public void for_Ellipses_RewriteObjectExprDecl(_Ellipses_RewriteObjectExprDecl that) {
        for_Ellipses_RewriteObjectExprDeclDoFirst(that);
        for_Ellipses_RewriteObjectExprDeclOnly(that);
    }

    public void for_Ellipses_RewriteFunctionalMethodDecl(_Ellipses_RewriteFunctionalMethodDecl that) {
        for_Ellipses_RewriteFunctionalMethodDeclDoFirst(that);
        for_Ellipses_RewriteFunctionalMethodDeclOnly(that);
    }

    public void for_EllipsesDimUnitDecl(_EllipsesDimUnitDecl that) {
        for_EllipsesDimUnitDeclDoFirst(that);
        for_EllipsesDimUnitDeclOnly(that);
    }

    public void for_EllipsesDimDecl(_EllipsesDimDecl that) {
        for_EllipsesDimDeclDoFirst(that);
        for_EllipsesDimDeclOnly(that);
    }

    public void for_EllipsesUnitDecl(_EllipsesUnitDecl that) {
        for_EllipsesUnitDeclDoFirst(that);
        for_EllipsesUnitDeclOnly(that);
    }

    public void for_EllipsesTestDecl(_EllipsesTestDecl that) {
        for_EllipsesTestDeclDoFirst(that);
        for_EllipsesTestDeclOnly(that);
    }

    public void for_EllipsesPropertyDecl(_EllipsesPropertyDecl that) {
        for_EllipsesPropertyDeclDoFirst(that);
        for_EllipsesPropertyDeclOnly(that);
    }

    public void for_EllipsesTypeAlias(_EllipsesTypeAlias that) {
        for_EllipsesTypeAliasDoFirst(that);
        for_EllipsesTypeAliasOnly(that);
    }

    public void for_EllipsesGrammarDecl(_EllipsesGrammarDecl that) {
        for_EllipsesGrammarDeclDoFirst(that);
        for_EllipsesGrammarDeclOnly(that);
    }

    public void for_EllipsesGrammarMemberDecl(_EllipsesGrammarMemberDecl that) {
        for_EllipsesGrammarMemberDeclDoFirst(that);
        for_EllipsesGrammarMemberDeclOnly(that);
    }

    public void for_EllipsesNonterminalDecl(_EllipsesNonterminalDecl that) {
        for_EllipsesNonterminalDeclDoFirst(that);
        for_EllipsesNonterminalDeclOnly(that);
    }

    public void for_EllipsesNonterminalDef(_EllipsesNonterminalDef that) {
        for_EllipsesNonterminalDefDoFirst(that);
        for_EllipsesNonterminalDefOnly(that);
    }

    public void for_EllipsesNonterminalExtensionDef(_EllipsesNonterminalExtensionDef that) {
        for_EllipsesNonterminalExtensionDefDoFirst(that);
        for_EllipsesNonterminalExtensionDefOnly(that);
    }

    public void for_EllipsesBinding(_EllipsesBinding that) {
        for_EllipsesBindingDoFirst(that);
        for_EllipsesBindingOnly(that);
    }

    public void for_EllipsesLValue(_EllipsesLValue that) {
        for_EllipsesLValueDoFirst(that);
        for_EllipsesLValueOnly(that);
    }

    public void for_EllipsesParam(_EllipsesParam that) {
        for_EllipsesParamDoFirst(that);
        for_EllipsesParamOnly(that);
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

    public void for_EllipsesType(_EllipsesType that) {
        for_EllipsesTypeDoFirst(that);
        for_EllipsesTypeOnly(that);
    }

    public void for_EllipsesBaseType(_EllipsesBaseType that) {
        for_EllipsesBaseTypeDoFirst(that);
        for_EllipsesBaseTypeOnly(that);
    }

    public void for_EllipsesAnyType(_EllipsesAnyType that) {
        for_EllipsesAnyTypeDoFirst(that);
        for_EllipsesAnyTypeOnly(that);
    }

    public void for_EllipsesBottomType(_EllipsesBottomType that) {
        for_EllipsesBottomTypeDoFirst(that);
        for_EllipsesBottomTypeOnly(that);
    }

    public void for_EllipsesUnknownType(_EllipsesUnknownType that) {
        for_EllipsesUnknownTypeDoFirst(that);
        for_EllipsesUnknownTypeOnly(that);
    }

    public void for_EllipsesSelfType(_EllipsesSelfType that) {
        for_EllipsesSelfTypeDoFirst(that);
        for_EllipsesSelfTypeOnly(that);
    }

    public void for_EllipsesTraitSelfType(_EllipsesTraitSelfType that) {
        for_EllipsesTraitSelfTypeDoFirst(that);
        for_EllipsesTraitSelfTypeOnly(that);
    }

    public void for_EllipsesObjectExprType(_EllipsesObjectExprType that) {
        for_EllipsesObjectExprTypeDoFirst(that);
        for_EllipsesObjectExprTypeOnly(that);
    }

    public void for_EllipsesNamedType(_EllipsesNamedType that) {
        for_EllipsesNamedTypeDoFirst(that);
        for_EllipsesNamedTypeOnly(that);
    }

    public void for_Ellipses_InferenceVarType(_Ellipses_InferenceVarType that) {
        for_Ellipses_InferenceVarTypeDoFirst(that);
        for_Ellipses_InferenceVarTypeOnly(that);
    }

    public void for_EllipsesVarType(_EllipsesVarType that) {
        for_EllipsesVarTypeDoFirst(that);
        for_EllipsesVarTypeOnly(that);
    }

    public void for_EllipsesTraitType(_EllipsesTraitType that) {
        for_EllipsesTraitTypeDoFirst(that);
        for_EllipsesTraitTypeOnly(that);
    }

    public void for_EllipsesAbbreviatedType(_EllipsesAbbreviatedType that) {
        for_EllipsesAbbreviatedTypeDoFirst(that);
        for_EllipsesAbbreviatedTypeOnly(that);
    }

    public void for_EllipsesArrayType(_EllipsesArrayType that) {
        for_EllipsesArrayTypeDoFirst(that);
        for_EllipsesArrayTypeOnly(that);
    }

    public void for_EllipsesMatrixType(_EllipsesMatrixType that) {
        for_EllipsesMatrixTypeDoFirst(that);
        for_EllipsesMatrixTypeOnly(that);
    }

    public void for_EllipsesTaggedDimType(_EllipsesTaggedDimType that) {
        for_EllipsesTaggedDimTypeDoFirst(that);
        for_EllipsesTaggedDimTypeOnly(that);
    }

    public void for_EllipsesTaggedUnitType(_EllipsesTaggedUnitType that) {
        for_EllipsesTaggedUnitTypeDoFirst(that);
        for_EllipsesTaggedUnitTypeOnly(that);
    }

    public void for_EllipsesTupleType(_EllipsesTupleType that) {
        for_EllipsesTupleTypeDoFirst(that);
        for_EllipsesTupleTypeOnly(that);
    }

    public void for_EllipsesArrowType(_EllipsesArrowType that) {
        for_EllipsesArrowTypeDoFirst(that);
        for_EllipsesArrowTypeOnly(that);
    }

    public void for_EllipsesBoundType(_EllipsesBoundType that) {
        for_EllipsesBoundTypeDoFirst(that);
        for_EllipsesBoundTypeOnly(that);
    }

    public void for_EllipsesIntersectionType(_EllipsesIntersectionType that) {
        for_EllipsesIntersectionTypeDoFirst(that);
        for_EllipsesIntersectionTypeOnly(that);
    }

    public void for_EllipsesUnionType(_EllipsesUnionType that) {
        for_EllipsesUnionTypeDoFirst(that);
        for_EllipsesUnionTypeOnly(that);
    }

    public void for_EllipsesFixedPointType(_EllipsesFixedPointType that) {
        for_EllipsesFixedPointTypeDoFirst(that);
        for_EllipsesFixedPointTypeOnly(that);
    }

    public void for_EllipsesLabelType(_EllipsesLabelType that) {
        for_EllipsesLabelTypeDoFirst(that);
        for_EllipsesLabelTypeOnly(that);
    }

    public void for_EllipsesDimExpr(_EllipsesDimExpr that) {
        for_EllipsesDimExprDoFirst(that);
        for_EllipsesDimExprOnly(that);
    }

    public void for_EllipsesDimBase(_EllipsesDimBase that) {
        for_EllipsesDimBaseDoFirst(that);
        for_EllipsesDimBaseOnly(that);
    }

    public void for_EllipsesDimRef(_EllipsesDimRef that) {
        for_EllipsesDimRefDoFirst(that);
        for_EllipsesDimRefOnly(that);
    }

    public void for_EllipsesDimExponent(_EllipsesDimExponent that) {
        for_EllipsesDimExponentDoFirst(that);
        for_EllipsesDimExponentOnly(that);
    }

    public void for_EllipsesDimUnaryOp(_EllipsesDimUnaryOp that) {
        for_EllipsesDimUnaryOpDoFirst(that);
        for_EllipsesDimUnaryOpOnly(that);
    }

    public void for_EllipsesDimBinaryOp(_EllipsesDimBinaryOp that) {
        for_EllipsesDimBinaryOpDoFirst(that);
        for_EllipsesDimBinaryOpOnly(that);
    }

    public void for_EllipsesPattern(_EllipsesPattern that) {
        for_EllipsesPatternDoFirst(that);
        for_EllipsesPatternOnly(that);
    }

    public void for_EllipsesPatternArgs(_EllipsesPatternArgs that) {
        for_EllipsesPatternArgsDoFirst(that);
        for_EllipsesPatternArgsOnly(that);
    }

    public void for_EllipsesPatternBinding(_EllipsesPatternBinding that) {
        for_EllipsesPatternBindingDoFirst(that);
        for_EllipsesPatternBindingOnly(that);
    }

    public void for_EllipsesPlainPattern(_EllipsesPlainPattern that) {
        for_EllipsesPlainPatternDoFirst(that);
        for_EllipsesPlainPatternOnly(that);
    }

    public void for_EllipsesTypePattern(_EllipsesTypePattern that) {
        for_EllipsesTypePatternDoFirst(that);
        for_EllipsesTypePatternOnly(that);
    }

    public void for_EllipsesNestedPattern(_EllipsesNestedPattern that) {
        for_EllipsesNestedPatternDoFirst(that);
        for_EllipsesNestedPatternOnly(that);
    }

    public void for_EllipsesStaticArg(_EllipsesStaticArg that) {
        for_EllipsesStaticArgDoFirst(that);
        for_EllipsesStaticArgOnly(that);
    }

    public void for_EllipsesTypeArg(_EllipsesTypeArg that) {
        for_EllipsesTypeArgDoFirst(that);
        for_EllipsesTypeArgOnly(that);
    }

    public void for_EllipsesIntArg(_EllipsesIntArg that) {
        for_EllipsesIntArgDoFirst(that);
        for_EllipsesIntArgOnly(that);
    }

    public void for_EllipsesBoolArg(_EllipsesBoolArg that) {
        for_EllipsesBoolArgDoFirst(that);
        for_EllipsesBoolArgOnly(that);
    }

    public void for_EllipsesOpArg(_EllipsesOpArg that) {
        for_EllipsesOpArgDoFirst(that);
        for_EllipsesOpArgOnly(that);
    }

    public void for_EllipsesDimArg(_EllipsesDimArg that) {
        for_EllipsesDimArgDoFirst(that);
        for_EllipsesDimArgOnly(that);
    }

    public void for_EllipsesUnitArg(_EllipsesUnitArg that) {
        for_EllipsesUnitArgDoFirst(that);
        for_EllipsesUnitArgOnly(that);
    }

    public void for_EllipsesStaticExpr(_EllipsesStaticExpr that) {
        for_EllipsesStaticExprDoFirst(that);
        for_EllipsesStaticExprOnly(that);
    }

    public void for_EllipsesIntExpr(_EllipsesIntExpr that) {
        for_EllipsesIntExprDoFirst(that);
        for_EllipsesIntExprOnly(that);
    }

    public void for_EllipsesIntBase(_EllipsesIntBase that) {
        for_EllipsesIntBaseDoFirst(that);
        for_EllipsesIntBaseOnly(that);
    }

    public void for_EllipsesIntRef(_EllipsesIntRef that) {
        for_EllipsesIntRefDoFirst(that);
        for_EllipsesIntRefOnly(that);
    }

    public void for_EllipsesIntBinaryOp(_EllipsesIntBinaryOp that) {
        for_EllipsesIntBinaryOpDoFirst(that);
        for_EllipsesIntBinaryOpOnly(that);
    }

    public void for_EllipsesBoolExpr(_EllipsesBoolExpr that) {
        for_EllipsesBoolExprDoFirst(that);
        for_EllipsesBoolExprOnly(that);
    }

    public void for_EllipsesBoolBase(_EllipsesBoolBase that) {
        for_EllipsesBoolBaseDoFirst(that);
        for_EllipsesBoolBaseOnly(that);
    }

    public void for_EllipsesBoolRef(_EllipsesBoolRef that) {
        for_EllipsesBoolRefDoFirst(that);
        for_EllipsesBoolRefOnly(that);
    }

    public void for_EllipsesBoolConstraint(_EllipsesBoolConstraint that) {
        for_EllipsesBoolConstraintDoFirst(that);
        for_EllipsesBoolConstraintOnly(that);
    }

    public void for_EllipsesBoolUnaryOp(_EllipsesBoolUnaryOp that) {
        for_EllipsesBoolUnaryOpDoFirst(that);
        for_EllipsesBoolUnaryOpOnly(that);
    }

    public void for_EllipsesBoolBinaryOp(_EllipsesBoolBinaryOp that) {
        for_EllipsesBoolBinaryOpDoFirst(that);
        for_EllipsesBoolBinaryOpOnly(that);
    }

    public void for_EllipsesUnitExpr(_EllipsesUnitExpr that) {
        for_EllipsesUnitExprDoFirst(that);
        for_EllipsesUnitExprOnly(that);
    }

    public void for_EllipsesUnitRef(_EllipsesUnitRef that) {
        for_EllipsesUnitRefDoFirst(that);
        for_EllipsesUnitRefOnly(that);
    }

    public void for_EllipsesUnitBinaryOp(_EllipsesUnitBinaryOp that) {
        for_EllipsesUnitBinaryOpDoFirst(that);
        for_EllipsesUnitBinaryOpOnly(that);
    }

    public void for_EllipsesEffect(_EllipsesEffect that) {
        for_EllipsesEffectDoFirst(that);
        for_EllipsesEffectOnly(that);
    }

    public void for_EllipsesWhereClause(_EllipsesWhereClause that) {
        for_EllipsesWhereClauseDoFirst(that);
        for_EllipsesWhereClauseOnly(that);
    }

    public void for_EllipsesWhereBinding(_EllipsesWhereBinding that) {
        for_EllipsesWhereBindingDoFirst(that);
        for_EllipsesWhereBindingOnly(that);
    }

    public void for_EllipsesWhereConstraint(_EllipsesWhereConstraint that) {
        for_EllipsesWhereConstraintDoFirst(that);
        for_EllipsesWhereConstraintOnly(that);
    }

    public void for_EllipsesWhereExtends(_EllipsesWhereExtends that) {
        for_EllipsesWhereExtendsDoFirst(that);
        for_EllipsesWhereExtendsOnly(that);
    }

    public void for_EllipsesWhereTypeAlias(_EllipsesWhereTypeAlias that) {
        for_EllipsesWhereTypeAliasDoFirst(that);
        for_EllipsesWhereTypeAliasOnly(that);
    }

    public void for_EllipsesWhereCoerces(_EllipsesWhereCoerces that) {
        for_EllipsesWhereCoercesDoFirst(that);
        for_EllipsesWhereCoercesOnly(that);
    }

    public void for_EllipsesWhereEquals(_EllipsesWhereEquals that) {
        for_EllipsesWhereEqualsDoFirst(that);
        for_EllipsesWhereEqualsOnly(that);
    }

    public void for_EllipsesUnitConstraint(_EllipsesUnitConstraint that) {
        for_EllipsesUnitConstraintDoFirst(that);
        for_EllipsesUnitConstraintOnly(that);
    }

    public void for_EllipsesIntConstraint(_EllipsesIntConstraint that) {
        for_EllipsesIntConstraintDoFirst(that);
        for_EllipsesIntConstraintOnly(that);
    }

    public void for_EllipsesBoolConstraintExpr(_EllipsesBoolConstraintExpr that) {
        for_EllipsesBoolConstraintExprDoFirst(that);
        for_EllipsesBoolConstraintExprOnly(that);
    }

    public void for_EllipsesContract(_EllipsesContract that) {
        for_EllipsesContractDoFirst(that);
        for_EllipsesContractOnly(that);
    }

    public void for_EllipsesEnsuresClause(_EllipsesEnsuresClause that) {
        for_EllipsesEnsuresClauseDoFirst(that);
        for_EllipsesEnsuresClauseOnly(that);
    }

    public void for_EllipsesStaticParam(_EllipsesStaticParam that) {
        for_EllipsesStaticParamDoFirst(that);
        for_EllipsesStaticParamOnly(that);
    }

    public void for_EllipsesName(_EllipsesName that) {
        for_EllipsesNameDoFirst(that);
        for_EllipsesNameOnly(that);
    }

    public void for_EllipsesAPIName(_EllipsesAPIName that) {
        for_EllipsesAPINameDoFirst(that);
        for_EllipsesAPINameOnly(that);
    }

    public void for_EllipsesIdOrOpOrAnonymousName(_EllipsesIdOrOpOrAnonymousName that) {
        for_EllipsesIdOrOpOrAnonymousNameDoFirst(that);
        for_EllipsesIdOrOpOrAnonymousNameOnly(that);
    }

    public void for_EllipsesIdOrOp(_EllipsesIdOrOp that) {
        for_EllipsesIdOrOpDoFirst(that);
        for_EllipsesIdOrOpOnly(that);
    }

    public void for_EllipsesId(_EllipsesId that) {
        for_EllipsesIdDoFirst(that);
        for_EllipsesIdOnly(that);
    }

    public void for_EllipsesOp(_EllipsesOp that) {
        for_EllipsesOpDoFirst(that);
        for_EllipsesOpOnly(that);
    }

    public void for_EllipsesNamedOp(_EllipsesNamedOp that) {
        for_EllipsesNamedOpDoFirst(that);
        for_EllipsesNamedOpOnly(that);
    }

    public void for_Ellipses_InferenceVarOp(_Ellipses_InferenceVarOp that) {
        for_Ellipses_InferenceVarOpDoFirst(that);
        for_Ellipses_InferenceVarOpOnly(that);
    }

    public void for_EllipsesAnonymousName(_EllipsesAnonymousName that) {
        for_EllipsesAnonymousNameDoFirst(that);
        for_EllipsesAnonymousNameOnly(that);
    }

    public void for_EllipsesAnonymousFnName(_EllipsesAnonymousFnName that) {
        for_EllipsesAnonymousFnNameDoFirst(that);
        for_EllipsesAnonymousFnNameOnly(that);
    }

    public void for_EllipsesConstructorFnName(_EllipsesConstructorFnName that) {
        for_EllipsesConstructorFnNameDoFirst(that);
        for_EllipsesConstructorFnNameOnly(that);
    }

    public void for_EllipsesArrayComprehensionClause(_EllipsesArrayComprehensionClause that) {
        for_EllipsesArrayComprehensionClauseDoFirst(that);
        for_EllipsesArrayComprehensionClauseOnly(that);
    }

    public void for_EllipsesKeywordExpr(_EllipsesKeywordExpr that) {
        for_EllipsesKeywordExprDoFirst(that);
        for_EllipsesKeywordExprOnly(that);
    }

    public void for_EllipsesCaseClause(_EllipsesCaseClause that) {
        for_EllipsesCaseClauseDoFirst(that);
        for_EllipsesCaseClauseOnly(that);
    }

    public void for_EllipsesCatch(_EllipsesCatch that) {
        for_EllipsesCatchDoFirst(that);
        for_EllipsesCatchOnly(that);
    }

    public void for_EllipsesCatchClause(_EllipsesCatchClause that) {
        for_EllipsesCatchClauseDoFirst(that);
        for_EllipsesCatchClauseOnly(that);
    }

    public void for_EllipsesIfClause(_EllipsesIfClause that) {
        for_EllipsesIfClauseDoFirst(that);
        for_EllipsesIfClauseOnly(that);
    }

    public void for_EllipsesTypecaseClause(_EllipsesTypecaseClause that) {
        for_EllipsesTypecaseClauseDoFirst(that);
        for_EllipsesTypecaseClauseOnly(that);
    }

    public void for_EllipsesExtentRange(_EllipsesExtentRange that) {
        for_EllipsesExtentRangeDoFirst(that);
        for_EllipsesExtentRangeOnly(that);
    }

    public void for_EllipsesGeneratorClause(_EllipsesGeneratorClause that) {
        for_EllipsesGeneratorClauseDoFirst(that);
        for_EllipsesGeneratorClauseOnly(that);
    }

    public void for_EllipsesKeywordType(_EllipsesKeywordType that) {
        for_EllipsesKeywordTypeDoFirst(that);
        for_EllipsesKeywordTypeOnly(that);
    }

    public void for_EllipsesTraitTypeWhere(_EllipsesTraitTypeWhere that) {
        for_EllipsesTraitTypeWhereDoFirst(that);
        for_EllipsesTraitTypeWhereOnly(that);
    }

    public void for_EllipsesIndices(_EllipsesIndices that) {
        for_EllipsesIndicesDoFirst(that);
        for_EllipsesIndicesOnly(that);
    }

    public void for_EllipsesMathItem(_EllipsesMathItem that) {
        for_EllipsesMathItemDoFirst(that);
        for_EllipsesMathItemOnly(that);
    }

    public void for_EllipsesExprMI(_EllipsesExprMI that) {
        for_EllipsesExprMIDoFirst(that);
        for_EllipsesExprMIOnly(that);
    }

    public void for_EllipsesParenthesisDelimitedMI(_EllipsesParenthesisDelimitedMI that) {
        for_EllipsesParenthesisDelimitedMIDoFirst(that);
        for_EllipsesParenthesisDelimitedMIOnly(that);
    }

    public void for_EllipsesNonParenthesisDelimitedMI(_EllipsesNonParenthesisDelimitedMI that) {
        for_EllipsesNonParenthesisDelimitedMIDoFirst(that);
        for_EllipsesNonParenthesisDelimitedMIOnly(that);
    }

    public void for_EllipsesNonExprMI(_EllipsesNonExprMI that) {
        for_EllipsesNonExprMIDoFirst(that);
        for_EllipsesNonExprMIOnly(that);
    }

    public void for_EllipsesExponentiationMI(_EllipsesExponentiationMI that) {
        for_EllipsesExponentiationMIDoFirst(that);
        for_EllipsesExponentiationMIOnly(that);
    }

    public void for_EllipsesSubscriptingMI(_EllipsesSubscriptingMI that) {
        for_EllipsesSubscriptingMIDoFirst(that);
        for_EllipsesSubscriptingMIOnly(that);
    }

    public void for_EllipsesOverloading(_EllipsesOverloading that) {
        for_EllipsesOverloadingDoFirst(that);
        for_EllipsesOverloadingOnly(that);
    }

    public void for_EllipsesNonterminalHeader(_EllipsesNonterminalHeader that) {
        for_EllipsesNonterminalHeaderDoFirst(that);
        for_EllipsesNonterminalHeaderOnly(that);
    }

    public void for_EllipsesNonterminalParameter(_EllipsesNonterminalParameter that) {
        for_EllipsesNonterminalParameterDoFirst(that);
        for_EllipsesNonterminalParameterOnly(that);
    }

    public void for_EllipsesSyntaxDecl(_EllipsesSyntaxDecl that) {
        for_EllipsesSyntaxDeclDoFirst(that);
        for_EllipsesSyntaxDeclOnly(that);
    }

    public void for_EllipsesSyntaxDef(_EllipsesSyntaxDef that) {
        for_EllipsesSyntaxDefDoFirst(that);
        for_EllipsesSyntaxDefOnly(that);
    }

    public void for_EllipsesSuperSyntaxDef(_EllipsesSuperSyntaxDef that) {
        for_EllipsesSuperSyntaxDefDoFirst(that);
        for_EllipsesSuperSyntaxDefOnly(that);
    }

    public void for_EllipsesTransformerDecl(_EllipsesTransformerDecl that) {
        for_EllipsesTransformerDeclDoFirst(that);
        for_EllipsesTransformerDeclOnly(that);
    }

    public void for_EllipsesPreTransformerDef(_EllipsesPreTransformerDef that) {
        for_EllipsesPreTransformerDefDoFirst(that);
        for_EllipsesPreTransformerDefOnly(that);
    }

    public void for_EllipsesNamedTransformerDef(_EllipsesNamedTransformerDef that) {
        for_EllipsesNamedTransformerDefDoFirst(that);
        for_EllipsesNamedTransformerDefOnly(that);
    }

    public void for_EllipsesTransformer(_EllipsesTransformer that) {
        for_EllipsesTransformerDoFirst(that);
        for_EllipsesTransformerOnly(that);
    }

    public void for_EllipsesUnparsedTransformer(_EllipsesUnparsedTransformer that) {
        for_EllipsesUnparsedTransformerDoFirst(that);
        for_EllipsesUnparsedTransformerOnly(that);
    }

    public void for_EllipsesNodeTransformer(_EllipsesNodeTransformer that) {
        for_EllipsesNodeTransformerDoFirst(that);
        for_EllipsesNodeTransformerOnly(that);
    }

    public void for_EllipsesCaseTransformer(_EllipsesCaseTransformer that) {
        for_EllipsesCaseTransformerDoFirst(that);
        for_EllipsesCaseTransformerOnly(that);
    }

    public void for_EllipsesCaseTransformerClause(_EllipsesCaseTransformerClause that) {
        for_EllipsesCaseTransformerClauseDoFirst(that);
        for_EllipsesCaseTransformerClauseOnly(that);
    }

    public void for_EllipsesSyntaxSymbol(_EllipsesSyntaxSymbol that) {
        for_EllipsesSyntaxSymbolDoFirst(that);
        for_EllipsesSyntaxSymbolOnly(that);
    }

    public void for_EllipsesPrefixedSymbol(_EllipsesPrefixedSymbol that) {
        for_EllipsesPrefixedSymbolDoFirst(that);
        for_EllipsesPrefixedSymbolOnly(that);
    }

    public void for_EllipsesOptionalSymbol(_EllipsesOptionalSymbol that) {
        for_EllipsesOptionalSymbolDoFirst(that);
        for_EllipsesOptionalSymbolOnly(that);
    }

    public void for_EllipsesRepeatSymbol(_EllipsesRepeatSymbol that) {
        for_EllipsesRepeatSymbolDoFirst(that);
        for_EllipsesRepeatSymbolOnly(that);
    }

    public void for_EllipsesRepeatOneOrMoreSymbol(_EllipsesRepeatOneOrMoreSymbol that) {
        for_EllipsesRepeatOneOrMoreSymbolDoFirst(that);
        for_EllipsesRepeatOneOrMoreSymbolOnly(that);
    }

    public void for_EllipsesNoWhitespaceSymbol(_EllipsesNoWhitespaceSymbol that) {
        for_EllipsesNoWhitespaceSymbolDoFirst(that);
        for_EllipsesNoWhitespaceSymbolOnly(that);
    }

    public void for_EllipsesGroupSymbol(_EllipsesGroupSymbol that) {
        for_EllipsesGroupSymbolDoFirst(that);
        for_EllipsesGroupSymbolOnly(that);
    }

    public void for_EllipsesSpecialSymbol(_EllipsesSpecialSymbol that) {
        for_EllipsesSpecialSymbolDoFirst(that);
        for_EllipsesSpecialSymbolOnly(that);
    }

    public void for_EllipsesAnyCharacterSymbol(_EllipsesAnyCharacterSymbol that) {
        for_EllipsesAnyCharacterSymbolDoFirst(that);
        for_EllipsesAnyCharacterSymbolOnly(that);
    }

    public void for_EllipsesWhitespaceSymbol(_EllipsesWhitespaceSymbol that) {
        for_EllipsesWhitespaceSymbolDoFirst(that);
        for_EllipsesWhitespaceSymbolOnly(that);
    }

    public void for_EllipsesTabSymbol(_EllipsesTabSymbol that) {
        for_EllipsesTabSymbolDoFirst(that);
        for_EllipsesTabSymbolOnly(that);
    }

    public void for_EllipsesFormfeedSymbol(_EllipsesFormfeedSymbol that) {
        for_EllipsesFormfeedSymbolDoFirst(that);
        for_EllipsesFormfeedSymbolOnly(that);
    }

    public void for_EllipsesCarriageReturnSymbol(_EllipsesCarriageReturnSymbol that) {
        for_EllipsesCarriageReturnSymbolDoFirst(that);
        for_EllipsesCarriageReturnSymbolOnly(that);
    }

    public void for_EllipsesBackspaceSymbol(_EllipsesBackspaceSymbol that) {
        for_EllipsesBackspaceSymbolDoFirst(that);
        for_EllipsesBackspaceSymbolOnly(that);
    }

    public void for_EllipsesNewlineSymbol(_EllipsesNewlineSymbol that) {
        for_EllipsesNewlineSymbolDoFirst(that);
        for_EllipsesNewlineSymbolOnly(that);
    }

    public void for_EllipsesBreaklineSymbol(_EllipsesBreaklineSymbol that) {
        for_EllipsesBreaklineSymbolDoFirst(that);
        for_EllipsesBreaklineSymbolOnly(that);
    }

    public void for_EllipsesItemSymbol(_EllipsesItemSymbol that) {
        for_EllipsesItemSymbolDoFirst(that);
        for_EllipsesItemSymbolOnly(that);
    }

    public void for_EllipsesNonterminalSymbol(_EllipsesNonterminalSymbol that) {
        for_EllipsesNonterminalSymbolDoFirst(that);
        for_EllipsesNonterminalSymbolOnly(that);
    }

    public void for_EllipsesKeywordSymbol(_EllipsesKeywordSymbol that) {
        for_EllipsesKeywordSymbolDoFirst(that);
        for_EllipsesKeywordSymbolOnly(that);
    }

    public void for_EllipsesTokenSymbol(_EllipsesTokenSymbol that) {
        for_EllipsesTokenSymbolDoFirst(that);
        for_EllipsesTokenSymbolOnly(that);
    }

    public void for_EllipsesNotPredicateSymbol(_EllipsesNotPredicateSymbol that) {
        for_EllipsesNotPredicateSymbolDoFirst(that);
        for_EllipsesNotPredicateSymbolOnly(that);
    }

    public void for_EllipsesAndPredicateSymbol(_EllipsesAndPredicateSymbol that) {
        for_EllipsesAndPredicateSymbolDoFirst(that);
        for_EllipsesAndPredicateSymbolOnly(that);
    }

    public void for_EllipsesCharacterClassSymbol(_EllipsesCharacterClassSymbol that) {
        for_EllipsesCharacterClassSymbolDoFirst(that);
        for_EllipsesCharacterClassSymbolOnly(that);
    }

    public void for_EllipsesCharacterSymbol(_EllipsesCharacterSymbol that) {
        for_EllipsesCharacterSymbolDoFirst(that);
        for_EllipsesCharacterSymbolOnly(that);
    }

    public void for_EllipsesCharSymbol(_EllipsesCharSymbol that) {
        for_EllipsesCharSymbolDoFirst(that);
        for_EllipsesCharSymbolOnly(that);
    }

    public void for_EllipsesCharacterInterval(_EllipsesCharacterInterval that) {
        for_EllipsesCharacterIntervalDoFirst(that);
        for_EllipsesCharacterIntervalOnly(that);
    }

    public void for_EllipsesLink(_EllipsesLink that) {
        for_EllipsesLinkDoFirst(that);
        for_EllipsesLinkOnly(that);
    }

    public void forTemplateGapAbstractNode(TemplateGapAbstractNode that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapCompilationUnit(TemplateGapCompilationUnit that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapComponent(TemplateGapComponent that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapApi(TemplateGapApi that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapImport(TemplateGapImport that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapImportedNames(TemplateGapImportedNames that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapImportStar(TemplateGapImportStar that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapImportNames(TemplateGapImportNames that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapImportApi(TemplateGapImportApi that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapAliasedSimpleName(TemplateGapAliasedSimpleName that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapAliasedAPIName(TemplateGapAliasedAPIName that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapDecl(TemplateGapDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTraitObjectDecl(TemplateGapTraitObjectDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTraitDecl(TemplateGapTraitDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapObjectDecl(TemplateGapObjectDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapVarDecl(TemplateGapVarDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapFnDecl(TemplateGapFnDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGap_RewriteFnOverloadDecl(TemplateGap_RewriteFnOverloadDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGap_RewriteObjectExprDecl(TemplateGap_RewriteObjectExprDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGap_RewriteFunctionalMethodDecl(TemplateGap_RewriteFunctionalMethodDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapDimUnitDecl(TemplateGapDimUnitDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapDimDecl(TemplateGapDimDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapUnitDecl(TemplateGapUnitDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTestDecl(TemplateGapTestDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapPropertyDecl(TemplateGapPropertyDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTypeAlias(TemplateGapTypeAlias that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapGrammarDecl(TemplateGapGrammarDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapGrammarMemberDecl(TemplateGapGrammarMemberDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNonterminalDecl(TemplateGapNonterminalDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNonterminalDef(TemplateGapNonterminalDef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNonterminalExtensionDef(TemplateGapNonterminalExtensionDef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBinding(TemplateGapBinding that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapLValue(TemplateGapLValue that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapParam(TemplateGapParam that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapExpr(TemplateGapExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapDummyExpr(TemplateGapDummyExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTypeAnnotatedExpr(TemplateGapTypeAnnotatedExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapAsExpr(TemplateGapAsExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapAsIfExpr(TemplateGapAsIfExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapAssignment(TemplateGapAssignment that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBlock(TemplateGapBlock that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapDo(TemplateGapDo that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapCaseExpr(TemplateGapCaseExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapIf(TemplateGapIf that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapLabel(TemplateGapLabel that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapAbstractObjectExpr(TemplateGapAbstractObjectExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapObjectExpr(TemplateGapObjectExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGap_RewriteObjectExpr(TemplateGap_RewriteObjectExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTry(TemplateGapTry that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTupleExpr(TemplateGapTupleExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTypecase(TemplateGapTypecase that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapWhile(TemplateGapWhile that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapFor(TemplateGapFor that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBigOpApp(TemplateGapBigOpApp that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapAccumulator(TemplateGapAccumulator that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapArrayComprehension(TemplateGapArrayComprehension that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapAtomicExpr(TemplateGapAtomicExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapExit(TemplateGapExit that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapSpawn(TemplateGapSpawn that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapThrow(TemplateGapThrow that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTryAtomicExpr(TemplateGapTryAtomicExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapFnExpr(TemplateGapFnExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapLetExpr(TemplateGapLetExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapLetFn(TemplateGapLetFn that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapLocalVarDecl(TemplateGapLocalVarDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapSimpleExpr(TemplateGapSimpleExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapSubscriptExpr(TemplateGapSubscriptExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapPrimary(TemplateGapPrimary that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapLiteralExpr(TemplateGapLiteralExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNumberLiteralExpr(TemplateGapNumberLiteralExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapFloatLiteralExpr(TemplateGapFloatLiteralExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapIntLiteralExpr(TemplateGapIntLiteralExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapCharLiteralExpr(TemplateGapCharLiteralExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapStringLiteralExpr(TemplateGapStringLiteralExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapVoidLiteralExpr(TemplateGapVoidLiteralExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBooleanLiteralExpr(TemplateGapBooleanLiteralExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapVarRef(TemplateGapVarRef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapFieldRef(TemplateGapFieldRef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapFunctionalRef(TemplateGapFunctionalRef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapFnRef(TemplateGapFnRef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapOpRef(TemplateGapOpRef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGap_RewriteFnRef(TemplateGap_RewriteFnRef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGap_RewriteObjectExprRef(TemplateGap_RewriteObjectExprRef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapJuxt(TemplateGapJuxt that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGap_RewriteFnApp(TemplateGap_RewriteFnApp that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapOpExpr(TemplateGapOpExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapAmbiguousMultifixOpExpr(TemplateGapAmbiguousMultifixOpExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapChainExpr(TemplateGapChainExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapCoercionInvocation(TemplateGapCoercionInvocation that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTraitCoercionInvocation(TemplateGapTraitCoercionInvocation that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTupleCoercionInvocation(TemplateGapTupleCoercionInvocation that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapArrowCoercionInvocation(TemplateGapArrowCoercionInvocation that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapUnionCoercionInvocation(TemplateGapUnionCoercionInvocation that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapMethodInvocation(TemplateGapMethodInvocation that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapMathPrimary(TemplateGapMathPrimary that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapArrayExpr(TemplateGapArrayExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapArrayElement(TemplateGapArrayElement that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapArrayElements(TemplateGapArrayElements that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapType(TemplateGapType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBaseType(TemplateGapBaseType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapAnyType(TemplateGapAnyType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBottomType(TemplateGapBottomType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapUnknownType(TemplateGapUnknownType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapSelfType(TemplateGapSelfType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTraitSelfType(TemplateGapTraitSelfType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapObjectExprType(TemplateGapObjectExprType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNamedType(TemplateGapNamedType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGap_InferenceVarType(TemplateGap_InferenceVarType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapVarType(TemplateGapVarType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTraitType(TemplateGapTraitType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapAbbreviatedType(TemplateGapAbbreviatedType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapArrayType(TemplateGapArrayType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapMatrixType(TemplateGapMatrixType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTaggedDimType(TemplateGapTaggedDimType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTaggedUnitType(TemplateGapTaggedUnitType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTupleType(TemplateGapTupleType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapArrowType(TemplateGapArrowType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBoundType(TemplateGapBoundType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapIntersectionType(TemplateGapIntersectionType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapUnionType(TemplateGapUnionType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapFixedPointType(TemplateGapFixedPointType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapLabelType(TemplateGapLabelType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapDimExpr(TemplateGapDimExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapDimBase(TemplateGapDimBase that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapDimRef(TemplateGapDimRef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapDimExponent(TemplateGapDimExponent that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapDimUnaryOp(TemplateGapDimUnaryOp that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapDimBinaryOp(TemplateGapDimBinaryOp that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapPattern(TemplateGapPattern that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapPatternArgs(TemplateGapPatternArgs that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapPatternBinding(TemplateGapPatternBinding that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapPlainPattern(TemplateGapPlainPattern that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTypePattern(TemplateGapTypePattern that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNestedPattern(TemplateGapNestedPattern that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapStaticArg(TemplateGapStaticArg that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTypeArg(TemplateGapTypeArg that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapIntArg(TemplateGapIntArg that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBoolArg(TemplateGapBoolArg that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapOpArg(TemplateGapOpArg that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapDimArg(TemplateGapDimArg that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapUnitArg(TemplateGapUnitArg that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapStaticExpr(TemplateGapStaticExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapIntExpr(TemplateGapIntExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapIntBase(TemplateGapIntBase that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapIntRef(TemplateGapIntRef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapIntBinaryOp(TemplateGapIntBinaryOp that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBoolExpr(TemplateGapBoolExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBoolBase(TemplateGapBoolBase that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBoolRef(TemplateGapBoolRef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBoolConstraint(TemplateGapBoolConstraint that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBoolUnaryOp(TemplateGapBoolUnaryOp that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBoolBinaryOp(TemplateGapBoolBinaryOp that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapUnitExpr(TemplateGapUnitExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapUnitRef(TemplateGapUnitRef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapUnitBinaryOp(TemplateGapUnitBinaryOp that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapEffect(TemplateGapEffect that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapWhereClause(TemplateGapWhereClause that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapWhereBinding(TemplateGapWhereBinding that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapWhereConstraint(TemplateGapWhereConstraint that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapWhereExtends(TemplateGapWhereExtends that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapWhereTypeAlias(TemplateGapWhereTypeAlias that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapWhereCoerces(TemplateGapWhereCoerces that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapWhereEquals(TemplateGapWhereEquals that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapUnitConstraint(TemplateGapUnitConstraint that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapIntConstraint(TemplateGapIntConstraint that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBoolConstraintExpr(TemplateGapBoolConstraintExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapContract(TemplateGapContract that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapEnsuresClause(TemplateGapEnsuresClause that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapStaticParam(TemplateGapStaticParam that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapName(TemplateGapName that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapAPIName(TemplateGapAPIName that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapIdOrOpOrAnonymousName(TemplateGapIdOrOpOrAnonymousName that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapIdOrOp(TemplateGapIdOrOp that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapId(TemplateGapId that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapOp(TemplateGapOp that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNamedOp(TemplateGapNamedOp that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGap_InferenceVarOp(TemplateGap_InferenceVarOp that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapAnonymousName(TemplateGapAnonymousName that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapAnonymousFnName(TemplateGapAnonymousFnName that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapConstructorFnName(TemplateGapConstructorFnName that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapArrayComprehensionClause(TemplateGapArrayComprehensionClause that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapKeywordExpr(TemplateGapKeywordExpr that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapCaseClause(TemplateGapCaseClause that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapCatch(TemplateGapCatch that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapCatchClause(TemplateGapCatchClause that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapIfClause(TemplateGapIfClause that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTypecaseClause(TemplateGapTypecaseClause that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapExtentRange(TemplateGapExtentRange that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapGeneratorClause(TemplateGapGeneratorClause that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapKeywordType(TemplateGapKeywordType that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTraitTypeWhere(TemplateGapTraitTypeWhere that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapIndices(TemplateGapIndices that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapMathItem(TemplateGapMathItem that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapExprMI(TemplateGapExprMI that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapParenthesisDelimitedMI(TemplateGapParenthesisDelimitedMI that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNonParenthesisDelimitedMI(TemplateGapNonParenthesisDelimitedMI that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNonExprMI(TemplateGapNonExprMI that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapExponentiationMI(TemplateGapExponentiationMI that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapSubscriptingMI(TemplateGapSubscriptingMI that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapOverloading(TemplateGapOverloading that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNonterminalHeader(TemplateGapNonterminalHeader that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNonterminalParameter(TemplateGapNonterminalParameter that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapSyntaxDecl(TemplateGapSyntaxDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapSyntaxDef(TemplateGapSyntaxDef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapSuperSyntaxDef(TemplateGapSuperSyntaxDef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTransformerDecl(TemplateGapTransformerDecl that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapPreTransformerDef(TemplateGapPreTransformerDef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNamedTransformerDef(TemplateGapNamedTransformerDef that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTransformer(TemplateGapTransformer that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapUnparsedTransformer(TemplateGapUnparsedTransformer that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNodeTransformer(TemplateGapNodeTransformer that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapCaseTransformer(TemplateGapCaseTransformer that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapCaseTransformerClause(TemplateGapCaseTransformerClause that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapSyntaxSymbol(TemplateGapSyntaxSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapPrefixedSymbol(TemplateGapPrefixedSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapOptionalSymbol(TemplateGapOptionalSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapRepeatSymbol(TemplateGapRepeatSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapRepeatOneOrMoreSymbol(TemplateGapRepeatOneOrMoreSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNoWhitespaceSymbol(TemplateGapNoWhitespaceSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapGroupSymbol(TemplateGapGroupSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapSpecialSymbol(TemplateGapSpecialSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapAnyCharacterSymbol(TemplateGapAnyCharacterSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapWhitespaceSymbol(TemplateGapWhitespaceSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTabSymbol(TemplateGapTabSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapFormfeedSymbol(TemplateGapFormfeedSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapCarriageReturnSymbol(TemplateGapCarriageReturnSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBackspaceSymbol(TemplateGapBackspaceSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNewlineSymbol(TemplateGapNewlineSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapBreaklineSymbol(TemplateGapBreaklineSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapItemSymbol(TemplateGapItemSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNonterminalSymbol(TemplateGapNonterminalSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapKeywordSymbol(TemplateGapKeywordSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapTokenSymbol(TemplateGapTokenSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapNotPredicateSymbol(TemplateGapNotPredicateSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapAndPredicateSymbol(TemplateGapAndPredicateSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapCharacterClassSymbol(TemplateGapCharacterClassSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapCharacterSymbol(TemplateGapCharacterSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapCharSymbol(TemplateGapCharSymbol that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapCharacterInterval(TemplateGapCharacterInterval that) {
        defaultTemplateGap(that);
    }

    public void forTemplateGapLink(TemplateGapLink that) {
        defaultTemplateGap(that);
    }


    public void recur(AbstractNode that) {
        that.accept(this);
    }

    public void recurOnASTNodeInfo(ASTNodeInfo that) {
    }

    public void recurOnListOfImport(List<Import> that) {
        for (Import elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfDecl(List<Decl> that) {
        for (Decl elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfAPIName(List<APIName> that) {
        for (APIName elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfIdOrOpOrAnonymousName(List<IdOrOpOrAnonymousName> that) {
        for (IdOrOpOrAnonymousName elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfAliasedSimpleName(List<AliasedSimpleName> that) {
        for (AliasedSimpleName elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfAliasedAPIName(List<AliasedAPIName> that) {
        for (AliasedAPIName elt : that) {
            recur(elt);
        }
    }

    public void recurOnOptionOfIdOrOpOrAnonymousName(Option<IdOrOpOrAnonymousName> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnOptionOfId(Option<Id> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnTraitTypeHeader(TraitTypeHeader that) {
    }

    public void recurOnOptionOfSelfType(Option<SelfType> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnListOfBaseType(List<BaseType> that) {
        for (BaseType elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfNamedType(List<NamedType> that) {
        for (NamedType elt : that) {
            recur(elt);
        }
    }

    public void recurOnOptionOfListOfNamedType(Option<List<NamedType>> that) {
        if (!that.isNone()) recurOnListOfNamedType(that.unwrap());
    }

    public void recurOnListOfLValue(List<LValue> that) {
        for (LValue elt : that) {
            recur(elt);
        }
    }

    public void recurOnOptionOfExpr(Option<Expr> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnFnHeader(FnHeader that) {
    }

    public void recurOnOptionOfIdOrOp(Option<IdOrOp> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnListOfIdOrOp(List<IdOrOp> that) {
        for (IdOrOp elt : that) {
            recur(elt);
        }
    }

    public void recurOnOptionOfType(Option<Type> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnListOf_RewriteObjectExpr(List<_RewriteObjectExpr> that) {
        for (_RewriteObjectExpr elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfId(List<Id> that) {
        for (Id elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfGeneratorClause(List<GeneratorClause> that) {
        for (GeneratorClause elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfParam(List<Param> that) {
        for (Param elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfStaticParam(List<StaticParam> that) {
        for (StaticParam elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfGrammarMemberDecl(List<GrammarMemberDecl> that) {
        for (GrammarMemberDecl elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfTransformerDecl(List<TransformerDecl> that) {
        for (TransformerDecl elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfSyntaxDecl(List<SyntaxDecl> that) {
        for (SyntaxDecl elt : that) {
            recur(elt);
        }
    }

    public void recurOnOptionOfBaseType(Option<BaseType> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnTypeOrPattern(TypeOrPattern that) {
    }

    public void recurOnOptionOfTypeOrPattern(Option<TypeOrPattern> that) {
        if (!that.isNone()) recurOnTypeOrPattern(that.unwrap());
    }

    public void recurOnExprInfo(ExprInfo that) {
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

    public void recurOnListOfCaseClause(List<CaseClause> that) {
        for (CaseClause elt : that) {
            recur(elt);
        }
    }

    public void recurOnOptionOfBlock(Option<Block> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnListOfIfClause(List<IfClause> that) {
        for (IfClause elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfStaticArg(List<StaticArg> that) {
        for (StaticArg elt : that) {
            recur(elt);
        }
    }

    public void recurOnOptionOfCatch(Option<Catch> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnListOfKeywordExpr(List<KeywordExpr> that) {
        for (KeywordExpr elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfTypecaseClause(List<TypecaseClause> that) {
        for (TypecaseClause elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfArrayComprehensionClause(List<ArrayComprehensionClause> that) {
        for (ArrayComprehensionClause elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfFnDecl(List<FnDecl> that) {
        for (FnDecl elt : that) {
            recur(elt);
        }
    }

    public void recurOnOptionOfOp(Option<Op> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnListOfOverloading(List<Overloading> that) {
        for (Overloading elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfLink(List<Link> that) {
        for (Link elt : that) {
            recur(elt);
        }
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

    public void recurOnListOfType(List<Type> that) {
        for (Type elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfMathItem(List<MathItem> that) {
        for (MathItem elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfArrayExpr(List<ArrayExpr> that) {
        for (ArrayExpr elt : that) {
            recur(elt);
        }
    }

    public void recurOnTypeInfo(TypeInfo that) {
    }

    public void recurOnListOfExtentRange(List<ExtentRange> that) {
        for (ExtentRange elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfKeywordType(List<KeywordType> that) {
        for (KeywordType elt : that) {
            recur(elt);
        }
    }

    public void recurOnMethodInfo(MethodInfo that) {
    }

    public void recurOnOptionOfMethodInfo(Option<MethodInfo> that) {
        if (!that.isNone()) recurOnMethodInfo(that.unwrap());
    }

    public void recurOnListOfPatternBinding(List<PatternBinding> that) {
        for (PatternBinding elt : that) {
            recur(elt);
        }
    }

    public void recurOnOptionOfListOfType(Option<List<Type>> that) {
        if (!that.isNone()) recurOnListOfType(that.unwrap());
    }

    public void recurOnListOfWhereBinding(List<WhereBinding> that) {
        for (WhereBinding elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfWhereConstraint(List<WhereConstraint> that) {
        for (WhereConstraint elt : that) {
            recur(elt);
        }
    }

    public void recurOnStaticParamKind(StaticParamKind that) {
    }

    public void recurOnOptionOfListOfExpr(Option<List<Expr>> that) {
        if (!that.isNone()) recurOnListOfExpr(that.unwrap());
    }

    public void recurOnListOfEnsuresClause(List<EnsuresClause> that) {
        for (EnsuresClause elt : that) {
            recur(elt);
        }
    }

    public void recurOnOptionOfListOfEnsuresClause(Option<List<EnsuresClause>> that) {
        if (!that.isNone()) recurOnListOfEnsuresClause(that.unwrap());
    }

    public void recurOnOptionOfAPIName(Option<APIName> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnFixity(Fixity that) {
    }

    public void recurOnObjectConstructor(ObjectConstructor that) {
    }

    public void recurOnListOfCatchClause(List<CatchClause> that) {
        for (CatchClause elt : that) {
            recur(elt);
        }
    }

    public void recurOnOptionOfStaticArg(Option<StaticArg> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnOptionOfWhereClause(Option<WhereClause> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnOptionOfArrowType(Option<ArrowType> that) {
        if (!that.isNone()) recur(that.unwrap());
    }

    public void recurOnListOfNonterminalParameter(List<NonterminalParameter> that) {
        for (NonterminalParameter elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfSyntaxSymbol(List<SyntaxSymbol> that) {
        for (SyntaxSymbol elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfCaseTransformerClause(List<CaseTransformerClause> that) {
        for (CaseTransformerClause elt : that) {
            recur(elt);
        }
    }

    public void recurOnListOfCharacterSymbol(List<CharacterSymbol> that) {
        for (CharacterSymbol elt : that) {
            recur(elt);
        }
    }
}
