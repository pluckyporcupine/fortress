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

/** A visitor over Type that combined recursive results.
 ** This visitor implements the visitor interface with methods that
 ** first visit children, and then call forCASEOnly(), passing in
 ** the values of the visits of the children. (CASE is replaced by the case name.)
 ** By default, each forCASEOnly combines its results together using the method
 **    combine(node, values...)
 ** All recursion should go via recur(...); this allows overrides to insert
 ** hooks into the recursion path (eg to record incremental results)
 **/
@SuppressWarnings({"unused", "unchecked"})
public abstract class TypeCollectingVisitor<RetType> extends TypeDepthFirstVisitor<RetType> {
    /* Methods to handle a node after recursion. */
    public RetType forTypeOnly(Type that) {
        return combine(that);
    }

    public RetType forBaseTypeOnly(BaseType that) {
        return combine(that);
    }

    public RetType forAnyTypeOnly(AnyType that) {
        return combine(that);
    }

    public RetType forBottomTypeOnly(BottomType that) {
        return combine(that);
    }

    public RetType forUnknownTypeOnly(UnknownType that) {
        return combine(that);
    }

    public RetType forSelfTypeOnly(SelfType that) {
        return combine(that);
    }

    public RetType forTraitSelfTypeOnly(TraitSelfType that, RetType named_result, List<RetType> comprised_result) {
        return combine(that, named_result, combine(comprised_result));
    }

    public RetType forObjectExprTypeOnly(ObjectExprType that, List<RetType> extended_result) {
        return combine(that, combine(extended_result));
    }

    public RetType forNamedTypeOnly(NamedType that) {
        return combine(that);
    }

    public RetType for_InferenceVarTypeOnly(_InferenceVarType that) {
        return combine(that);
    }

    public RetType forVarTypeOnly(VarType that) {
        return combine(that);
    }

    public RetType forTraitTypeOnly(TraitType that) {
        return combine(that);
    }

    public RetType forAbbreviatedTypeOnly(AbbreviatedType that, RetType elemType_result) {
        return combine(that, elemType_result);
    }

    public RetType forArrayTypeOnly(ArrayType that, RetType elemType_result) {
        return combine(that, elemType_result);
    }

    public RetType forMatrixTypeOnly(MatrixType that, RetType elemType_result) {
        return combine(that, elemType_result);
    }

    public RetType forTaggedDimTypeOnly(TaggedDimType that, RetType elemType_result, RetType dimExpr_result) {
        return combine(that, elemType_result, dimExpr_result);
    }

    public RetType forTaggedUnitTypeOnly(TaggedUnitType that, RetType elemType_result) {
        return combine(that, elemType_result);
    }

    public RetType forTupleTypeOnly(TupleType that, List<RetType> elements_result, Option<RetType> varargs_result) {
        return combine(that, combine(elements_result), combine(varargs_result));
    }

    public RetType forArrowTypeOnly(ArrowType that, RetType domain_result, RetType range_result) {
        return combine(that, domain_result, range_result);
    }

    public RetType forBoundTypeOnly(BoundType that, List<RetType> elements_result) {
        return combine(that, combine(elements_result));
    }

    public RetType forIntersectionTypeOnly(IntersectionType that, List<RetType> elements_result) {
        return combine(that, combine(elements_result));
    }

    public RetType forUnionTypeOnly(UnionType that, List<RetType> elements_result) {
        return combine(that, combine(elements_result));
    }

    public RetType forFixedPointTypeOnly(FixedPointType that, RetType name_result, RetType body_result) {
        return combine(that, name_result, body_result);
    }

    public RetType forLabelTypeOnly(LabelType that) {
        return combine(that);
    }

    public RetType forDimExprOnly(DimExpr that) {
        return combine(that);
    }

    public RetType forDimBaseOnly(DimBase that) {
        return combine(that);
    }

    public RetType forDimRefOnly(DimRef that) {
        return combine(that);
    }

    public RetType forDimExponentOnly(DimExponent that, RetType base_result) {
        return combine(that, base_result);
    }

    public RetType forDimUnaryOpOnly(DimUnaryOp that, RetType dimVal_result) {
        return combine(that, dimVal_result);
    }

    public RetType forDimBinaryOpOnly(DimBinaryOp that, RetType left_result, RetType right_result) {
        return combine(that, left_result, right_result);
    }

    public RetType for_SyntaxTransformationTypeOnly(_SyntaxTransformationType that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationBaseTypeOnly(_SyntaxTransformationBaseType that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationAnyTypeOnly(_SyntaxTransformationAnyType that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationBottomTypeOnly(_SyntaxTransformationBottomType that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationUnknownTypeOnly(_SyntaxTransformationUnknownType that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationSelfTypeOnly(_SyntaxTransformationSelfType that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationTraitSelfTypeOnly(_SyntaxTransformationTraitSelfType that, RetType named_result, List<RetType> comprised_result) {
        return combine(that, named_result, combine(comprised_result));
    }

    public RetType for_SyntaxTransformationObjectExprTypeOnly(_SyntaxTransformationObjectExprType that, List<RetType> extended_result) {
        return combine(that, combine(extended_result));
    }

    public RetType for_SyntaxTransformationNamedTypeOnly(_SyntaxTransformationNamedType that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformation_InferenceVarTypeOnly(_SyntaxTransformation_InferenceVarType that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationVarTypeOnly(_SyntaxTransformationVarType that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationTraitTypeOnly(_SyntaxTransformationTraitType that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationAbbreviatedTypeOnly(_SyntaxTransformationAbbreviatedType that, RetType elemType_result) {
        return combine(that, elemType_result);
    }

    public RetType for_SyntaxTransformationArrayTypeOnly(_SyntaxTransformationArrayType that, RetType elemType_result) {
        return combine(that, elemType_result);
    }

    public RetType for_SyntaxTransformationMatrixTypeOnly(_SyntaxTransformationMatrixType that, RetType elemType_result) {
        return combine(that, elemType_result);
    }

    public RetType for_SyntaxTransformationTaggedDimTypeOnly(_SyntaxTransformationTaggedDimType that, RetType elemType_result, RetType dimExpr_result) {
        return combine(that, elemType_result, dimExpr_result);
    }

    public RetType for_SyntaxTransformationTaggedUnitTypeOnly(_SyntaxTransformationTaggedUnitType that, RetType elemType_result) {
        return combine(that, elemType_result);
    }

    public RetType for_SyntaxTransformationTupleTypeOnly(_SyntaxTransformationTupleType that, List<RetType> elements_result, Option<RetType> varargs_result) {
        return combine(that, combine(elements_result), combine(varargs_result));
    }

    public RetType for_SyntaxTransformationArrowTypeOnly(_SyntaxTransformationArrowType that, RetType domain_result, RetType range_result) {
        return combine(that, domain_result, range_result);
    }

    public RetType for_SyntaxTransformationBoundTypeOnly(_SyntaxTransformationBoundType that, List<RetType> elements_result) {
        return combine(that, combine(elements_result));
    }

    public RetType for_SyntaxTransformationIntersectionTypeOnly(_SyntaxTransformationIntersectionType that, List<RetType> elements_result) {
        return combine(that, combine(elements_result));
    }

    public RetType for_SyntaxTransformationUnionTypeOnly(_SyntaxTransformationUnionType that, List<RetType> elements_result) {
        return combine(that, combine(elements_result));
    }

    public RetType for_SyntaxTransformationFixedPointTypeOnly(_SyntaxTransformationFixedPointType that, RetType name_result, RetType body_result) {
        return combine(that, name_result, body_result);
    }

    public RetType for_SyntaxTransformationLabelTypeOnly(_SyntaxTransformationLabelType that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationDimExprOnly(_SyntaxTransformationDimExpr that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationDimBaseOnly(_SyntaxTransformationDimBase that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationDimRefOnly(_SyntaxTransformationDimRef that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationDimExponentOnly(_SyntaxTransformationDimExponent that, RetType base_result) {
        return combine(that, base_result);
    }

    public RetType for_SyntaxTransformationDimUnaryOpOnly(_SyntaxTransformationDimUnaryOp that, RetType dimVal_result) {
        return combine(that, dimVal_result);
    }

    public RetType for_SyntaxTransformationDimBinaryOpOnly(_SyntaxTransformationDimBinaryOp that, RetType left_result, RetType right_result) {
        return combine(that, left_result, right_result);
    }

    public abstract RetType combine(List<RetType> l);

    public RetType combine(Type that, RetType... vals) {
        return combine(vals);
    }

    public RetType combine(RetType... vals) {
        List<RetType> l = new java.util.ArrayList(vals.length);
        for (int i=0; i < vals.length; i++) l.add(vals[i]);
        return combine(l);
    }

    public RetType combineOptionList(Option<List<RetType>> v) {
        if (v.isSome()) return combine(v.unwrap());
        return combine();
    }

    public RetType combine(Option<RetType> v) {
        if (v.isSome()) return v.unwrap();
        return combine();
    }

    public RetType combineOptionOption(Option<Option<RetType>> v) {
        if (v.isSome()) return combine(v.unwrap());
        return combine();
    }

    public RetType combineListOption(List<Option<RetType>> v) {
        ArrayList<RetType> t = new ArrayList<RetType>();
        for (Option<RetType> e : v) t.add(combine(e));
        return combine(t);
    }

}
