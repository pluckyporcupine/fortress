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
 * Class MathPrimary, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class MathPrimary extends Primary implements OutAfterTypeChecking {
    private final FunctionalRef _multiJuxt;
    private final FunctionalRef _infixJuxt;
    private final Expr _front;
    private final List<MathItem> _rest;

    /**
     * Constructs a MathPrimary.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public MathPrimary(ExprInfo in_info, FunctionalRef in_multiJuxt, FunctionalRef in_infixJuxt, Expr in_front, List<MathItem> in_rest) {
        super(in_info);
        if (in_multiJuxt == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'multiJuxt' to the MathPrimary constructor was null");
        }
        _multiJuxt = in_multiJuxt;
        if (in_infixJuxt == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'infixJuxt' to the MathPrimary constructor was null");
        }
        _infixJuxt = in_infixJuxt;
        if (in_front == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'front' to the MathPrimary constructor was null");
        }
        _front = in_front;
        if (in_rest == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'rest' to the MathPrimary constructor was null");
        }
        _rest = in_rest;
    }

    final public FunctionalRef getMultiJuxt() { return _multiJuxt; }
    final public FunctionalRef getInfixJuxt() { return _infixJuxt; }
    final public Expr getFront() { return _front; }
    final public List<MathItem> getRest() { return _rest; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forMathPrimary(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forMathPrimary(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forMathPrimary(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forMathPrimary(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forMathPrimary(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forMathPrimary(this);
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
            MathPrimary casted = (MathPrimary) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            FunctionalRef temp_multiJuxt = getMultiJuxt();
            FunctionalRef casted_multiJuxt = casted.getMultiJuxt();
            if (!(temp_multiJuxt == casted_multiJuxt || temp_multiJuxt.equals(casted_multiJuxt))) return false;
            FunctionalRef temp_infixJuxt = getInfixJuxt();
            FunctionalRef casted_infixJuxt = casted.getInfixJuxt();
            if (!(temp_infixJuxt == casted_infixJuxt || temp_infixJuxt.equals(casted_infixJuxt))) return false;
            Expr temp_front = getFront();
            Expr casted_front = casted.getFront();
            if (!(temp_front == casted_front || temp_front.equals(casted_front))) return false;
            List<MathItem> temp_rest = getRest();
            List<MathItem> casted_rest = casted.getRest();
            if (!(temp_rest == casted_rest || temp_rest.equals(casted_rest))) return false;
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
        FunctionalRef temp_multiJuxt = getMultiJuxt();
        code ^= temp_multiJuxt.hashCode();
        FunctionalRef temp_infixJuxt = getInfixJuxt();
        code ^= temp_infixJuxt.hashCode();
        Expr temp_front = getFront();
        code ^= temp_front.hashCode();
        List<MathItem> temp_rest = getRest();
        code ^= temp_rest.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected MathPrimary() {
        _multiJuxt = null;
        _infixJuxt = null;
        _front = null;
        _rest = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected MathPrimary(ExprInfo info) {
        super(info);
        _multiJuxt = null;
        _infixJuxt = null;
        _front = null;
        _rest = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "MathPrimary", 5)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            FunctionalRef temp_multiJuxt = getMultiJuxt();
            if (w.visitNodeField("multiJuxt", temp_multiJuxt)) {
                temp_multiJuxt.walk(w);
                w.endNodeField("multiJuxt", temp_multiJuxt);
            }
            FunctionalRef temp_infixJuxt = getInfixJuxt();
            if (w.visitNodeField("infixJuxt", temp_infixJuxt)) {
                temp_infixJuxt.walk(w);
                w.endNodeField("infixJuxt", temp_infixJuxt);
            }
            Expr temp_front = getFront();
            if (w.visitNodeField("front", temp_front)) {
                temp_front.walk(w);
                w.endNodeField("front", temp_front);
            }
            List<MathItem> temp_rest = getRest();
            if (w.visitNodeField("rest", temp_rest)) {
                if (w.visitIterated(temp_rest)) {
                    int i_temp_rest = 0;
                    for (MathItem elt_temp_rest : temp_rest) {
                        if (w.visitIteratedElement(i_temp_rest, elt_temp_rest)) {
                            if (elt_temp_rest == null) w.visitNull();
                            else {
                                elt_temp_rest.walk(w);
                            }
                        }
                        i_temp_rest++;
                    }
                    w.endIterated(temp_rest, i_temp_rest);
                }
                w.endNodeField("rest", temp_rest);
            }
            w.endNode(this, "MathPrimary", 5);
        }
    }

}
