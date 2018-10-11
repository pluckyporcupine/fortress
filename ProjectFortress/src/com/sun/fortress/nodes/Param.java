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
 * Class Param, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class Param extends Binding {
    private final Option<Expr> _defaultExpr;
    private final Option<Type> _varargsType;

    /**
     * Constructs a Param.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Param(ASTNodeInfo in_info, Id in_name, Modifiers in_mods, Option<TypeOrPattern> in_idType, Option<Expr> in_defaultExpr, Option<Type> in_varargsType) {
        super(in_info, in_name, in_mods, in_idType);
        if (in_defaultExpr == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'defaultExpr' to the Param constructor was null");
        }
        _defaultExpr = in_defaultExpr;
        if (in_varargsType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'varargsType' to the Param constructor was null");
        }
        _varargsType = in_varargsType;
    }

    final public Option<Expr> getDefaultExpr() { return _defaultExpr; }
    final public Option<Type> getVarargsType() { return _varargsType; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forParam(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forParam(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forParam(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forParam(this);
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
            Param casted = (Param) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_name = getName();
            Id casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            Modifiers temp_mods = getMods();
            Modifiers casted_mods = casted.getMods();
            if (!(temp_mods == casted_mods || temp_mods.equals(casted_mods))) return false;
            Option<TypeOrPattern> temp_idType = getIdType();
            Option<TypeOrPattern> casted_idType = casted.getIdType();
            if (!(temp_idType == casted_idType || temp_idType.equals(casted_idType))) return false;
            Option<Expr> temp_defaultExpr = getDefaultExpr();
            Option<Expr> casted_defaultExpr = casted.getDefaultExpr();
            if (!(temp_defaultExpr == casted_defaultExpr || temp_defaultExpr.equals(casted_defaultExpr))) return false;
            Option<Type> temp_varargsType = getVarargsType();
            Option<Type> casted_varargsType = casted.getVarargsType();
            if (!(temp_varargsType == casted_varargsType || temp_varargsType.equals(casted_varargsType))) return false;
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
        ASTNodeInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        Id temp_name = getName();
        code ^= temp_name.hashCode();
        Modifiers temp_mods = getMods();
        code ^= temp_mods.hashCode();
        Option<TypeOrPattern> temp_idType = getIdType();
        code ^= temp_idType.hashCode();
        Option<Expr> temp_defaultExpr = getDefaultExpr();
        code ^= temp_defaultExpr.hashCode();
        Option<Type> temp_varargsType = getVarargsType();
        code ^= temp_varargsType.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Param() {
        _defaultExpr = null;
        _varargsType = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Param(ASTNodeInfo info) {
        super(info);
        _defaultExpr = null;
        _varargsType = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "Param", 6)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Id temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            Modifiers temp_mods = getMods();
            if (w.visitNodeField("mods", temp_mods)) {
                w.visitUnknownObject(temp_mods);
                w.endNodeField("mods", temp_mods);
            }
            Option<TypeOrPattern> temp_idType = getIdType();
            if (w.visitNodeField("idType", temp_idType)) {
                if (temp_idType.isNone()) {
                    w.visitEmptyOption(temp_idType);
                }
                else if (w.visitNonEmptyOption(temp_idType)) {
                    TypeOrPattern elt_temp_idType = temp_idType.unwrap();
                    if (elt_temp_idType == null) w.visitNull();
                    else {
                        elt_temp_idType.walk(w);
                    }
                    w.endNonEmptyOption(temp_idType);
                }
                w.endNodeField("idType", temp_idType);
            }
            Option<Expr> temp_defaultExpr = getDefaultExpr();
            if (w.visitNodeField("defaultExpr", temp_defaultExpr)) {
                if (temp_defaultExpr.isNone()) {
                    w.visitEmptyOption(temp_defaultExpr);
                }
                else if (w.visitNonEmptyOption(temp_defaultExpr)) {
                    Expr elt_temp_defaultExpr = temp_defaultExpr.unwrap();
                    if (elt_temp_defaultExpr == null) w.visitNull();
                    else {
                        elt_temp_defaultExpr.walk(w);
                    }
                    w.endNonEmptyOption(temp_defaultExpr);
                }
                w.endNodeField("defaultExpr", temp_defaultExpr);
            }
            Option<Type> temp_varargsType = getVarargsType();
            if (w.visitNodeField("varargsType", temp_varargsType)) {
                if (temp_varargsType.isNone()) {
                    w.visitEmptyOption(temp_varargsType);
                }
                else if (w.visitNonEmptyOption(temp_varargsType)) {
                    Type elt_temp_varargsType = temp_varargsType.unwrap();
                    if (elt_temp_varargsType == null) w.visitNull();
                    else {
                        elt_temp_varargsType.walk(w);
                    }
                    w.endNonEmptyOption(temp_varargsType);
                }
                w.endNodeField("varargsType", temp_varargsType);
            }
            w.endNode(this, "Param", 6);
        }
    }

}
