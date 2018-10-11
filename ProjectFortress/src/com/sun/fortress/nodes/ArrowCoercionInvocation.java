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
 * Class ArrowCoercionInvocation, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ArrowCoercionInvocation extends CoercionInvocation {
    private final Option<CoercionInvocation> _domainCoercion;
    private final Option<CoercionInvocation> _rangeCoercion;

    /**
     * Constructs a ArrowCoercionInvocation.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ArrowCoercionInvocation(ExprInfo in_info, Expr in_arg, ArrowType in_toType, Option<CoercionInvocation> in_domainCoercion, Option<CoercionInvocation> in_rangeCoercion) {
        super(in_info, in_toType, in_arg);
        if (in_domainCoercion == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'domainCoercion' to the ArrowCoercionInvocation constructor was null");
        }
        _domainCoercion = in_domainCoercion;
        if (in_rangeCoercion == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'rangeCoercion' to the ArrowCoercionInvocation constructor was null");
        }
        _rangeCoercion = in_rangeCoercion;
    }

    final public Option<CoercionInvocation> getDomainCoercion() { return _domainCoercion; }
    final public Option<CoercionInvocation> getRangeCoercion() { return _rangeCoercion; }
    final public ArrowType getToType() { return (ArrowType) super.getToType(); }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forArrowCoercionInvocation(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forArrowCoercionInvocation(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forArrowCoercionInvocation(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forArrowCoercionInvocation(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forArrowCoercionInvocation(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forArrowCoercionInvocation(this);
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
            ArrowCoercionInvocation casted = (ArrowCoercionInvocation) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Expr temp_arg = getArg();
            Expr casted_arg = casted.getArg();
            if (!(temp_arg == casted_arg || temp_arg.equals(casted_arg))) return false;
            ArrowType temp_toType = getToType();
            ArrowType casted_toType = casted.getToType();
            if (!(temp_toType == casted_toType || temp_toType.equals(casted_toType))) return false;
            Option<CoercionInvocation> temp_domainCoercion = getDomainCoercion();
            Option<CoercionInvocation> casted_domainCoercion = casted.getDomainCoercion();
            if (!(temp_domainCoercion == casted_domainCoercion || temp_domainCoercion.equals(casted_domainCoercion))) return false;
            Option<CoercionInvocation> temp_rangeCoercion = getRangeCoercion();
            Option<CoercionInvocation> casted_rangeCoercion = casted.getRangeCoercion();
            if (!(temp_rangeCoercion == casted_rangeCoercion || temp_rangeCoercion.equals(casted_rangeCoercion))) return false;
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
        ArrowType temp_toType = getToType();
        code ^= temp_toType.hashCode();
        Option<CoercionInvocation> temp_domainCoercion = getDomainCoercion();
        code ^= temp_domainCoercion.hashCode();
        Option<CoercionInvocation> temp_rangeCoercion = getRangeCoercion();
        code ^= temp_rangeCoercion.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ArrowCoercionInvocation() {
        _domainCoercion = null;
        _rangeCoercion = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ArrowCoercionInvocation(ExprInfo info) {
        super(info);
        _domainCoercion = null;
        _rangeCoercion = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ArrowCoercionInvocation", 5)) {
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
            ArrowType temp_toType = getToType();
            if (w.visitNodeField("toType", temp_toType)) {
                temp_toType.walk(w);
                w.endNodeField("toType", temp_toType);
            }
            Option<CoercionInvocation> temp_domainCoercion = getDomainCoercion();
            if (w.visitNodeField("domainCoercion", temp_domainCoercion)) {
                if (temp_domainCoercion.isNone()) {
                    w.visitEmptyOption(temp_domainCoercion);
                }
                else if (w.visitNonEmptyOption(temp_domainCoercion)) {
                    CoercionInvocation elt_temp_domainCoercion = temp_domainCoercion.unwrap();
                    if (elt_temp_domainCoercion == null) w.visitNull();
                    else {
                        elt_temp_domainCoercion.walk(w);
                    }
                    w.endNonEmptyOption(temp_domainCoercion);
                }
                w.endNodeField("domainCoercion", temp_domainCoercion);
            }
            Option<CoercionInvocation> temp_rangeCoercion = getRangeCoercion();
            if (w.visitNodeField("rangeCoercion", temp_rangeCoercion)) {
                if (temp_rangeCoercion.isNone()) {
                    w.visitEmptyOption(temp_rangeCoercion);
                }
                else if (w.visitNonEmptyOption(temp_rangeCoercion)) {
                    CoercionInvocation elt_temp_rangeCoercion = temp_rangeCoercion.unwrap();
                    if (elt_temp_rangeCoercion == null) w.visitNull();
                    else {
                        elt_temp_rangeCoercion.walk(w);
                    }
                    w.endNonEmptyOption(temp_rangeCoercion);
                }
                w.endNodeField("rangeCoercion", temp_rangeCoercion);
            }
            w.endNode(this, "ArrowCoercionInvocation", 5);
        }
    }

}
