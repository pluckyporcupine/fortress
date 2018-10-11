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
 * Class ExponentiationMI, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ExponentiationMI extends NonExprMI {
    private final FunctionalRef _op;
    private final Option<Expr> _expr;

    /**
     * Constructs a ExponentiationMI.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ExponentiationMI(ASTNodeInfo in_info, FunctionalRef in_op, Option<Expr> in_expr) {
        super(in_info);
        if (in_op == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'op' to the ExponentiationMI constructor was null");
        }
        _op = in_op;
        if (in_expr == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'expr' to the ExponentiationMI constructor was null");
        }
        _expr = in_expr;
    }

    final public FunctionalRef getOp() { return _op; }
    final public Option<Expr> getExpr() { return _expr; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forExponentiationMI(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forExponentiationMI(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forExponentiationMI(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forExponentiationMI(this);
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
            ExponentiationMI casted = (ExponentiationMI) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            FunctionalRef temp_op = getOp();
            FunctionalRef casted_op = casted.getOp();
            if (!(temp_op == casted_op || temp_op.equals(casted_op))) return false;
            Option<Expr> temp_expr = getExpr();
            Option<Expr> casted_expr = casted.getExpr();
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
        ASTNodeInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        FunctionalRef temp_op = getOp();
        code ^= temp_op.hashCode();
        Option<Expr> temp_expr = getExpr();
        code ^= temp_expr.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ExponentiationMI() {
        _op = null;
        _expr = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ExponentiationMI(ASTNodeInfo info) {
        super(info);
        _op = null;
        _expr = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ExponentiationMI", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            FunctionalRef temp_op = getOp();
            if (w.visitNodeField("op", temp_op)) {
                temp_op.walk(w);
                w.endNodeField("op", temp_op);
            }
            Option<Expr> temp_expr = getExpr();
            if (w.visitNodeField("expr", temp_expr)) {
                if (temp_expr.isNone()) {
                    w.visitEmptyOption(temp_expr);
                }
                else if (w.visitNonEmptyOption(temp_expr)) {
                    Expr elt_temp_expr = temp_expr.unwrap();
                    if (elt_temp_expr == null) w.visitNull();
                    else {
                        elt_temp_expr.walk(w);
                    }
                    w.endNonEmptyOption(temp_expr);
                }
                w.endNodeField("expr", temp_expr);
            }
            w.endNode(this, "ExponentiationMI", 3);
        }
    }

}
