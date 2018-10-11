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
 * Class AtomicExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class AtomicExpr extends Expr {
    private final Expr _expr;

    /**
     * Constructs a AtomicExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public AtomicExpr(ExprInfo in_info, Expr in_expr) {
        super(in_info);
        if (in_expr == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'expr' to the AtomicExpr constructor was null");
        }
        _expr = in_expr;
    }

    final public Expr getExpr() { return _expr; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forAtomicExpr(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forAtomicExpr(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forAtomicExpr(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forAtomicExpr(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forAtomicExpr(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forAtomicExpr(this);
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
            AtomicExpr casted = (AtomicExpr) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Expr temp_expr = getExpr();
            Expr casted_expr = casted.getExpr();
            if (!(temp_expr == casted_expr || temp_expr.equals(casted_expr))) return false;
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
        Expr temp_expr = getExpr();
        code ^= temp_expr.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected AtomicExpr() {
        _expr = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected AtomicExpr(ExprInfo info) {
        super(info);
        _expr = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "AtomicExpr", 2)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Expr temp_expr = getExpr();
            if (w.visitNodeField("expr", temp_expr)) {
                temp_expr.walk(w);
                w.endNodeField("expr", temp_expr);
            }
            w.endNode(this, "AtomicExpr", 2);
        }
    }

}
