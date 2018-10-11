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

/**
 * Class TupleCoercionInvocation, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class TupleCoercionInvocation extends CoercionInvocation {
    private final List<Option<CoercionInvocation>> _subCoercions;
    private final Option<Option<CoercionInvocation>> _varargCoercion;

    /**
     * Constructs a TupleCoercionInvocation.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TupleCoercionInvocation(ExprInfo in_info, Expr in_arg, TupleType in_toType, List<Option<CoercionInvocation>> in_subCoercions, Option<Option<CoercionInvocation>> in_varargCoercion) {
        super(in_info, in_toType, in_arg);
        if (in_subCoercions == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'subCoercions' to the TupleCoercionInvocation constructor was null");
        }
        _subCoercions = in_subCoercions;
        if (in_varargCoercion == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'varargCoercion' to the TupleCoercionInvocation constructor was null");
        }
        _varargCoercion = in_varargCoercion;
    }

    final public List<Option<CoercionInvocation>> getSubCoercions() { return _subCoercions; }
    final public Option<Option<CoercionInvocation>> getVarargCoercion() { return _varargCoercion; }
    final public TupleType getToType() { return (TupleType) super.getToType(); }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forTupleCoercionInvocation(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTupleCoercionInvocation(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTupleCoercionInvocation(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forTupleCoercionInvocation(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTupleCoercionInvocation(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTupleCoercionInvocation(this);
    }

    /**
     * Implementation of equals that is based on the values of the fields of the
     * object. Thus, two objects created with identical parameters will be equal.
     */
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if ((obj.getClass() != this.getClass()) || (obj.hashCode() != this.hashCode())) {
            return false;
        }
        else {
            TupleCoercionInvocation casted = (TupleCoercionInvocation) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Expr temp_arg = getArg();
            Expr casted_arg = casted.getArg();
            if (!(temp_arg == casted_arg || temp_arg.equals(casted_arg))) return false;
            TupleType temp_toType = getToType();
            TupleType casted_toType = casted.getToType();
            if (!(temp_toType == casted_toType || temp_toType.equals(casted_toType))) return false;
            List<Option<CoercionInvocation>> temp_subCoercions = getSubCoercions();
            List<Option<CoercionInvocation>> casted_subCoercions = casted.getSubCoercions();
            if (!(temp_subCoercions == casted_subCoercions || temp_subCoercions.equals(casted_subCoercions))) return false;
            Option<Option<CoercionInvocation>> temp_varargCoercion = getVarargCoercion();
            Option<Option<CoercionInvocation>> casted_varargCoercion = casted.getVarargCoercion();
            if (!(temp_varargCoercion == casted_varargCoercion || temp_varargCoercion.equals(casted_varargCoercion))) return false;
            return true;
        }
    }


    /**
     * Implementation of hashCode that is consistent with equals.  The value of
     * the hashCode is formed by XORing the hashcode of the class object with
     * the hashcodes of all the fields of the object.
     */
    public int generateHashCode() {
        int code = getClass().hashCode();
        ExprInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        Expr temp_arg = getArg();
        code ^= temp_arg.hashCode();
        TupleType temp_toType = getToType();
        code ^= temp_toType.hashCode();
        List<Option<CoercionInvocation>> temp_subCoercions = getSubCoercions();
        code ^= temp_subCoercions.hashCode();
        Option<Option<CoercionInvocation>> temp_varargCoercion = getVarargCoercion();
        code ^= temp_varargCoercion.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TupleCoercionInvocation() {
        _subCoercions = null;
        _varargCoercion = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TupleCoercionInvocation(ExprInfo info) {
        super(info);
        _subCoercions = null;
        _varargCoercion = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TupleCoercionInvocation", 5)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Expr temp_arg = getArg();
            if (w.visitNodeField("arg", temp_arg)) {
                temp_arg.walk(w);
                w.endNodeField("arg", temp_arg);
            }
            TupleType temp_toType = getToType();
            if (w.visitNodeField("toType", temp_toType)) {
                temp_toType.walk(w);
                w.endNodeField("toType", temp_toType);
            }
            List<Option<CoercionInvocation>> temp_subCoercions = getSubCoercions();
            if (w.visitNodeField("subCoercions", temp_subCoercions)) {
                if (w.visitIterated(temp_subCoercions)) {
                    int i_temp_subCoercions = 0;
                    for (Option<CoercionInvocation> elt_temp_subCoercions : temp_subCoercions) {
                        if (w.visitIteratedElement(i_temp_subCoercions, elt_temp_subCoercions)) {
                            if (elt_temp_subCoercions == null) w.visitNull();
                            else {
                                if (elt_temp_subCoercions.isNone()) {
                                    w.visitEmptyOption(elt_temp_subCoercions);
                                }
                                else if (w.visitNonEmptyOption(elt_temp_subCoercions)) {
                                    CoercionInvocation elt_elt_temp_subCoercions = elt_temp_subCoercions.unwrap();
                                    if (elt_elt_temp_subCoercions == null) w.visitNull();
                                    else {
                                        elt_elt_temp_subCoercions.walk(w);
                                    }
                                    w.endNonEmptyOption(elt_temp_subCoercions);
                                }
                            }
                        }
                        i_temp_subCoercions++;
                    }
                    w.endIterated(temp_subCoercions, i_temp_subCoercions);
                }
                w.endNodeField("subCoercions", temp_subCoercions);
            }
            Option<Option<CoercionInvocation>> temp_varargCoercion = getVarargCoercion();
            if (w.visitNodeField("varargCoercion", temp_varargCoercion)) {
                if (temp_varargCoercion.isNone()) {
                    w.visitEmptyOption(temp_varargCoercion);
                }
                else if (w.visitNonEmptyOption(temp_varargCoercion)) {
                    Option<CoercionInvocation> elt_temp_varargCoercion = temp_varargCoercion.unwrap();
                    if (elt_temp_varargCoercion == null) w.visitNull();
                    else {
                        if (elt_temp_varargCoercion.isNone()) {
                            w.visitEmptyOption(elt_temp_varargCoercion);
                        }
                        else if (w.visitNonEmptyOption(elt_temp_varargCoercion)) {
                            CoercionInvocation elt_elt_temp_varargCoercion = elt_temp_varargCoercion.unwrap();
                            if (elt_elt_temp_varargCoercion == null) w.visitNull();
                            else {
                                elt_elt_temp_varargCoercion.walk(w);
                            }
                            w.endNonEmptyOption(elt_temp_varargCoercion);
                        }
                    }
                    w.endNonEmptyOption(temp_varargCoercion);
                }
                w.endNodeField("varargCoercion", temp_varargCoercion);
            }
            w.endNode(this, "TupleCoercionInvocation", 5);
        }
    }

}
