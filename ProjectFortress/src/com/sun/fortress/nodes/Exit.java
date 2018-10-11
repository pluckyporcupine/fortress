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
 * Class Exit, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class Exit extends Expr {
    private final Option<Id> _target;
    private final Option<Expr> _returnExpr;

    /**
     * Constructs a Exit.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Exit(ExprInfo in_info, Option<Id> in_target, Option<Expr> in_returnExpr) {
        super(in_info);
        if (in_target == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'target' to the Exit constructor was null");
        }
        _target = in_target;
        if (in_returnExpr == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'returnExpr' to the Exit constructor was null");
        }
        _returnExpr = in_returnExpr;
    }

    final public Option<Id> getTarget() { return _target; }
    final public Option<Expr> getReturnExpr() { return _returnExpr; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forExit(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forExit(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forExit(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forExit(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forExit(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forExit(this);
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
            Exit casted = (Exit) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<Id> temp_target = getTarget();
            Option<Id> casted_target = casted.getTarget();
            if (!(temp_target == casted_target || temp_target.equals(casted_target))) return false;
            Option<Expr> temp_returnExpr = getReturnExpr();
            Option<Expr> casted_returnExpr = casted.getReturnExpr();
            if (!(temp_returnExpr == casted_returnExpr || temp_returnExpr.equals(casted_returnExpr))) return false;
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
        Option<Id> temp_target = getTarget();
        code ^= temp_target.hashCode();
        Option<Expr> temp_returnExpr = getReturnExpr();
        code ^= temp_returnExpr.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Exit() {
        _target = null;
        _returnExpr = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Exit(ExprInfo info) {
        super(info);
        _target = null;
        _returnExpr = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "Exit", 3)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Option<Id> temp_target = getTarget();
            if (w.visitNodeField("target", temp_target)) {
                if (temp_target.isNone()) {
                    w.visitEmptyOption(temp_target);
                }
                else if (w.visitNonEmptyOption(temp_target)) {
                    Id elt_temp_target = temp_target.unwrap();
                    if (elt_temp_target == null) w.visitNull();
                    else {
                        elt_temp_target.walk(w);
                    }
                    w.endNonEmptyOption(temp_target);
                }
                w.endNodeField("target", temp_target);
            }
            Option<Expr> temp_returnExpr = getReturnExpr();
            if (w.visitNodeField("returnExpr", temp_returnExpr)) {
                if (temp_returnExpr.isNone()) {
                    w.visitEmptyOption(temp_returnExpr);
                }
                else if (w.visitNonEmptyOption(temp_returnExpr)) {
                    Expr elt_temp_returnExpr = temp_returnExpr.unwrap();
                    if (elt_temp_returnExpr == null) w.visitNull();
                    else {
                        elt_temp_returnExpr.walk(w);
                    }
                    w.endNonEmptyOption(temp_returnExpr);
                }
                w.endNodeField("returnExpr", temp_returnExpr);
            }
            w.endNode(this, "Exit", 3);
        }
    }

}
