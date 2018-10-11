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

/** A visitor over StaticArg that combined recursive results.
 ** This visitor implements the visitor interface with methods that
 ** first visit children, and then call forCASEOnly(), passing in
 ** the values of the visits of the children. (CASE is replaced by the case name.)
 ** By default, each forCASEOnly combines its results together using the method
 **    combine(node, values...)
 ** All recursion should go via recur(...); this allows overrides to insert
 ** hooks into the recursion path (eg to record incremental results)
 **/
@SuppressWarnings({"unused", "unchecked"})
public abstract class StaticArgCollectingVisitor<RetType> extends StaticArgDepthFirstVisitor<RetType> {
    /* Methods to handle a node after recursion. */
    public RetType forStaticArgOnly(StaticArg that) {
        return combine(that);
    }

    public RetType forTypeArgOnly(TypeArg that) {
        return combine(that);
    }

    public RetType forIntArgOnly(IntArg that) {
        return combine(that);
    }

    public RetType forBoolArgOnly(BoolArg that) {
        return combine(that);
    }

    public RetType forOpArgOnly(OpArg that) {
        return combine(that);
    }

    public RetType forDimArgOnly(DimArg that) {
        return combine(that);
    }

    public RetType forUnitArgOnly(UnitArg that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationStaticArgOnly(_SyntaxTransformationStaticArg that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationTypeArgOnly(_SyntaxTransformationTypeArg that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationIntArgOnly(_SyntaxTransformationIntArg that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationBoolArgOnly(_SyntaxTransformationBoolArg that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationOpArgOnly(_SyntaxTransformationOpArg that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationDimArgOnly(_SyntaxTransformationDimArg that) {
        return combine(that);
    }

    public RetType for_SyntaxTransformationUnitArgOnly(_SyntaxTransformationUnitArg that) {
        return combine(that);
    }

    public abstract RetType combine(List<RetType> l);

    public RetType combine(StaticArg that, RetType... vals) {
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
