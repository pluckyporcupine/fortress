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
 * Class UnionCoercionInvocation, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class UnionCoercionInvocation extends CoercionInvocation {
    private final List<Type> _fromTypes;
    private final List<Option<CoercionInvocation>> _fromCoercions;

    /**
     * Constructs a UnionCoercionInvocation.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public UnionCoercionInvocation(ExprInfo in_info, Type in_toType, Expr in_arg, List<Type> in_fromTypes, List<Option<CoercionInvocation>> in_fromCoercions) {
        super(in_info, in_toType, in_arg);
        if (in_fromTypes == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'fromTypes' to the UnionCoercionInvocation constructor was null");
        }
        _fromTypes = in_fromTypes;
        if (in_fromCoercions == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'fromCoercions' to the UnionCoercionInvocation constructor was null");
        }
        _fromCoercions = in_fromCoercions;
    }

    final public List<Type> getFromTypes() { return _fromTypes; }
    final public List<Option<CoercionInvocation>> getFromCoercions() { return _fromCoercions; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forUnionCoercionInvocation(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forUnionCoercionInvocation(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forUnionCoercionInvocation(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forUnionCoercionInvocation(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forUnionCoercionInvocation(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forUnionCoercionInvocation(this);
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
            UnionCoercionInvocation casted = (UnionCoercionInvocation) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Type temp_toType = getToType();
            Type casted_toType = casted.getToType();
            if (!(temp_toType == casted_toType || temp_toType.equals(casted_toType))) return false;
            Expr temp_arg = getArg();
            Expr casted_arg = casted.getArg();
            if (!(temp_arg == casted_arg || temp_arg.equals(casted_arg))) return false;
            List<Type> temp_fromTypes = getFromTypes();
            List<Type> casted_fromTypes = casted.getFromTypes();
            if (!(temp_fromTypes == casted_fromTypes || temp_fromTypes.equals(casted_fromTypes))) return false;
            List<Option<CoercionInvocation>> temp_fromCoercions = getFromCoercions();
            List<Option<CoercionInvocation>> casted_fromCoercions = casted.getFromCoercions();
            if (!(temp_fromCoercions == casted_fromCoercions || temp_fromCoercions.equals(casted_fromCoercions))) return false;
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
        Type temp_toType = getToType();
        code ^= temp_toType.hashCode();
        Expr temp_arg = getArg();
        code ^= temp_arg.hashCode();
        List<Type> temp_fromTypes = getFromTypes();
        code ^= temp_fromTypes.hashCode();
        List<Option<CoercionInvocation>> temp_fromCoercions = getFromCoercions();
        code ^= temp_fromCoercions.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected UnionCoercionInvocation() {
        _fromTypes = null;
        _fromCoercions = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected UnionCoercionInvocation(ExprInfo info) {
        super(info);
        _fromTypes = null;
        _fromCoercions = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "UnionCoercionInvocation", 5)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Type temp_toType = getToType();
            if (w.visitNodeField("toType", temp_toType)) {
                temp_toType.walk(w);
                w.endNodeField("toType", temp_toType);
            }
            Expr temp_arg = getArg();
            if (w.visitNodeField("arg", temp_arg)) {
                temp_arg.walk(w);
                w.endNodeField("arg", temp_arg);
            }
            List<Type> temp_fromTypes = getFromTypes();
            if (w.visitNodeField("fromTypes", temp_fromTypes)) {
                if (w.visitIterated(temp_fromTypes)) {
                    int i_temp_fromTypes = 0;
                    for (Type elt_temp_fromTypes : temp_fromTypes) {
                        if (w.visitIteratedElement(i_temp_fromTypes, elt_temp_fromTypes)) {
                            if (elt_temp_fromTypes == null) w.visitNull();
                            else {
                                elt_temp_fromTypes.walk(w);
                            }
                        }
                        i_temp_fromTypes++;
                    }
                    w.endIterated(temp_fromTypes, i_temp_fromTypes);
                }
                w.endNodeField("fromTypes", temp_fromTypes);
            }
            List<Option<CoercionInvocation>> temp_fromCoercions = getFromCoercions();
            if (w.visitNodeField("fromCoercions", temp_fromCoercions)) {
                if (w.visitIterated(temp_fromCoercions)) {
                    int i_temp_fromCoercions = 0;
                    for (Option<CoercionInvocation> elt_temp_fromCoercions : temp_fromCoercions) {
                        if (w.visitIteratedElement(i_temp_fromCoercions, elt_temp_fromCoercions)) {
                            if (elt_temp_fromCoercions == null) w.visitNull();
                            else {
                                if (elt_temp_fromCoercions.isNone()) {
                                    w.visitEmptyOption(elt_temp_fromCoercions);
                                }
                                else if (w.visitNonEmptyOption(elt_temp_fromCoercions)) {
                                    CoercionInvocation elt_elt_temp_fromCoercions = elt_temp_fromCoercions.unwrap();
                                    if (elt_elt_temp_fromCoercions == null) w.visitNull();
                                    else {
                                        elt_elt_temp_fromCoercions.walk(w);
                                    }
                                    w.endNonEmptyOption(elt_temp_fromCoercions);
                                }
                            }
                        }
                        i_temp_fromCoercions++;
                    }
                    w.endIterated(temp_fromCoercions, i_temp_fromCoercions);
                }
                w.endNodeField("fromCoercions", temp_fromCoercions);
            }
            w.endNode(this, "UnionCoercionInvocation", 5);
        }
    }

}
