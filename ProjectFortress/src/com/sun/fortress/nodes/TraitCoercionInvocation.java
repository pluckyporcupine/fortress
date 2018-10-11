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
 * Class TraitCoercionInvocation, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class TraitCoercionInvocation extends CoercionInvocation {
    private final FnRef _coercionFn;

    /**
     * Constructs a TraitCoercionInvocation.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TraitCoercionInvocation(ExprInfo in_info, Expr in_arg, TraitType in_toType, FnRef in_coercionFn) {
        super(in_info, in_toType, in_arg);
        if (in_coercionFn == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'coercionFn' to the TraitCoercionInvocation constructor was null");
        }
        _coercionFn = in_coercionFn;
    }

    final public FnRef getCoercionFn() { return _coercionFn; }
    final public TraitType getToType() { return (TraitType) super.getToType(); }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forTraitCoercionInvocation(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTraitCoercionInvocation(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTraitCoercionInvocation(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forTraitCoercionInvocation(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTraitCoercionInvocation(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTraitCoercionInvocation(this);
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
            TraitCoercionInvocation casted = (TraitCoercionInvocation) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Expr temp_arg = getArg();
            Expr casted_arg = casted.getArg();
            if (!(temp_arg == casted_arg || temp_arg.equals(casted_arg))) return false;
            TraitType temp_toType = getToType();
            TraitType casted_toType = casted.getToType();
            if (!(temp_toType == casted_toType || temp_toType.equals(casted_toType))) return false;
            FnRef temp_coercionFn = getCoercionFn();
            FnRef casted_coercionFn = casted.getCoercionFn();
            if (!(temp_coercionFn == casted_coercionFn || temp_coercionFn.equals(casted_coercionFn))) return false;
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
        TraitType temp_toType = getToType();
        code ^= temp_toType.hashCode();
        FnRef temp_coercionFn = getCoercionFn();
        code ^= temp_coercionFn.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TraitCoercionInvocation() {
        _coercionFn = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TraitCoercionInvocation(ExprInfo info) {
        super(info);
        _coercionFn = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TraitCoercionInvocation", 4)) {
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
            TraitType temp_toType = getToType();
            if (w.visitNodeField("toType", temp_toType)) {
                temp_toType.walk(w);
                w.endNodeField("toType", temp_toType);
            }
            FnRef temp_coercionFn = getCoercionFn();
            if (w.visitNodeField("coercionFn", temp_coercionFn)) {
                temp_coercionFn.walk(w);
                w.endNodeField("coercionFn", temp_coercionFn);
            }
            w.endNode(this, "TraitCoercionInvocation", 4);
        }
    }

}
