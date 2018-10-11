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
 * Class Juxt, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class Juxt extends Primary implements OutAfterTypeChecking {
    private final FunctionalRef _multiJuxt;
    private final FunctionalRef _infixJuxt;
    private final List<Expr> _exprs;
    private final boolean _fnApp;
    private final boolean _tight;

    /**
     * Constructs a Juxt.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Juxt(ExprInfo in_info, FunctionalRef in_multiJuxt, FunctionalRef in_infixJuxt, List<Expr> in_exprs, boolean in_fnApp, boolean in_tight) {
        super(in_info);
        if (in_multiJuxt == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'multiJuxt' to the Juxt constructor was null");
        }
        _multiJuxt = in_multiJuxt;
        if (in_infixJuxt == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'infixJuxt' to the Juxt constructor was null");
        }
        _infixJuxt = in_infixJuxt;
        if (in_exprs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'exprs' to the Juxt constructor was null");
        }
        _exprs = in_exprs;
        _fnApp = in_fnApp;
        _tight = in_tight;
    }

    final public FunctionalRef getMultiJuxt() { return _multiJuxt; }
    final public FunctionalRef getInfixJuxt() { return _infixJuxt; }
    final public List<Expr> getExprs() { return _exprs; }
    final public boolean isFnApp() { return _fnApp; }
    final public boolean isTight() { return _tight; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forJuxt(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forJuxt(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forJuxt(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forJuxt(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forJuxt(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forJuxt(this);
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
            Juxt casted = (Juxt) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            FunctionalRef temp_multiJuxt = getMultiJuxt();
            FunctionalRef casted_multiJuxt = casted.getMultiJuxt();
            if (!(temp_multiJuxt == casted_multiJuxt || temp_multiJuxt.equals(casted_multiJuxt))) return false;
            FunctionalRef temp_infixJuxt = getInfixJuxt();
            FunctionalRef casted_infixJuxt = casted.getInfixJuxt();
            if (!(temp_infixJuxt == casted_infixJuxt || temp_infixJuxt.equals(casted_infixJuxt))) return false;
            List<Expr> temp_exprs = getExprs();
            List<Expr> casted_exprs = casted.getExprs();
            if (!(temp_exprs == casted_exprs || temp_exprs.equals(casted_exprs))) return false;
            boolean temp_fnApp = isFnApp();
            boolean casted_fnApp = casted.isFnApp();
            if (!(temp_fnApp == casted_fnApp)) return false;
            boolean temp_tight = isTight();
            boolean casted_tight = casted.isTight();
            if (!(temp_tight == casted_tight)) return false;
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
        List<Expr> temp_exprs = getExprs();
        code ^= temp_exprs.hashCode();
        boolean temp_fnApp = isFnApp();
        code ^= temp_fnApp ? 1231 : 1237;
        boolean temp_tight = isTight();
        code ^= temp_tight ? 1231 : 1237;
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Juxt() {
        _multiJuxt = null;
        _infixJuxt = null;
        _exprs = null;
        _fnApp = false;
        _tight = false;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Juxt(ExprInfo info) {
        super(info);
        _multiJuxt = null;
        _infixJuxt = null;
        _exprs = null;
        _fnApp = false;
        _tight = false;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "Juxt", 6)) {
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
            List<Expr> temp_exprs = getExprs();
            if (w.visitNodeField("exprs", temp_exprs)) {
                if (w.visitIterated(temp_exprs)) {
                    int i_temp_exprs = 0;
                    for (Expr elt_temp_exprs : temp_exprs) {
                        if (w.visitIteratedElement(i_temp_exprs, elt_temp_exprs)) {
                            if (elt_temp_exprs == null) w.visitNull();
                            else {
                                elt_temp_exprs.walk(w);
                            }
                        }
                        i_temp_exprs++;
                    }
                    w.endIterated(temp_exprs, i_temp_exprs);
                }
                w.endNodeField("exprs", temp_exprs);
            }
            boolean temp_fnApp = isFnApp();
            if (w.visitNodeField("fnApp", temp_fnApp)) {
                w.visitBoolean(temp_fnApp);
                w.endNodeField("fnApp", temp_fnApp);
            }
            boolean temp_tight = isTight();
            if (w.visitNodeField("tight", temp_tight)) {
                w.visitBoolean(temp_tight);
                w.endNodeField("tight", temp_tight);
            }
            w.endNode(this, "Juxt", 6);
        }
    }

}
