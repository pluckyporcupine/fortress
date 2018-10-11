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
 * Class ExprInfo, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ExprInfo extends ParenthesizedInfo {
    private final Option<Type> _exprType;

    /**
     * Constructs a ExprInfo.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ExprInfo(Span in_span, boolean in_parenthesized, Option<Type> in_exprType) {
        super(in_span, in_parenthesized);
        if (in_exprType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'exprType' to the ExprInfo constructor was null");
        }
        _exprType = in_exprType;
    }

    final public Option<Type> getExprType() { return _exprType; }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forExprInfo(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forExprInfo(this);
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
            ExprInfo casted = (ExprInfo) obj;
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
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ExprInfo() {
        _exprType = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ExprInfo", 3)) {
            Span temp_span = getSpan();
            if (w.visitNodeField("span", temp_span)) {
                w.visitUnknownObject(temp_span);
                w.endNodeField("span", temp_span);
            }
            boolean temp_parenthesized = isParenthesized();
            if (w.visitNodeField("parenthesized", temp_parenthesized)) {
                w.visitBoolean(temp_parenthesized);
                w.endNodeField("parenthesized", temp_parenthesized);
            }
            Option<Type> temp_exprType = getExprType();
            if (w.visitNodeField("exprType", temp_exprType)) {
                if (temp_exprType.isNone()) {
                    w.visitEmptyOption(temp_exprType);
                }
                else if (w.visitNonEmptyOption(temp_exprType)) {
                    Type elt_temp_exprType = temp_exprType.unwrap();
                    if (elt_temp_exprType == null) w.visitNull();
                    else {
                        elt_temp_exprType.walk(w);
                    }
                    w.endNonEmptyOption(temp_exprType);
                }
                w.endNodeField("exprType", temp_exprType);
            }
            w.endNode(this, "ExprInfo", 3);
        }
    }

}
