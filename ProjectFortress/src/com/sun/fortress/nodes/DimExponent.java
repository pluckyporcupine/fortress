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
 * Class DimExponent, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class DimExponent extends DimExpr {
    private final Type _base;
    private final IntExpr _power;

    /**
     * Constructs a DimExponent.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public DimExponent(TypeInfo in_info, Type in_base, IntExpr in_power) {
        super(in_info);
        if (in_base == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'base' to the DimExponent constructor was null");
        }
        _base = in_base;
        if (in_power == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'power' to the DimExponent constructor was null");
        }
        _power = in_power;
    }

    final public Type getBase() { return _base; }
    final public IntExpr getPower() { return _power; }

    public <RetType> RetType accept(TypeVisitor<RetType> visitor) {
        return visitor.forDimExponent(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forDimExponent(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forDimExponent(this);
    }

    public void accept(TypeVisitor_void visitor) {
        visitor.forDimExponent(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forDimExponent(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forDimExponent(this);
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
            DimExponent casted = (DimExponent) obj;
            TypeInfo temp_info = getInfo();
            TypeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Type temp_base = getBase();
            Type casted_base = casted.getBase();
            if (!(temp_base == casted_base || temp_base.equals(casted_base))) return false;
            IntExpr temp_power = getPower();
            IntExpr casted_power = casted.getPower();
            if (!(temp_power == casted_power || temp_power.equals(casted_power))) return false;
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
        TypeInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        Type temp_base = getBase();
        code ^= temp_base.hashCode();
        IntExpr temp_power = getPower();
        code ^= temp_power.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected DimExponent() {
        _base = null;
        _power = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected DimExponent(TypeInfo info) {
        super(info);
        _base = null;
        _power = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "DimExponent", 3)) {
            TypeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Type temp_base = getBase();
            if (w.visitNodeField("base", temp_base)) {
                temp_base.walk(w);
                w.endNodeField("base", temp_base);
            }
            IntExpr temp_power = getPower();
            if (w.visitNodeField("power", temp_power)) {
                temp_power.walk(w);
                w.endNodeField("power", temp_power);
            }
            w.endNode(this, "DimExponent", 3);
        }
    }

}
