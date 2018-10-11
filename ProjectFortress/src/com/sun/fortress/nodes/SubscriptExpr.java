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
 * Class SubscriptExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class SubscriptExpr extends SimpleExpr implements Lhs {
    private final Expr _obj;
    private final List<Expr> _subs;
    private final Option<Op> _op;
    private final List<StaticArg> _staticArgs;

    /**
     * Constructs a SubscriptExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public SubscriptExpr(ExprInfo in_info, Expr in_obj, List<Expr> in_subs, Option<Op> in_op, List<StaticArg> in_staticArgs) {
        super(in_info);
        if (in_obj == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'obj' to the SubscriptExpr constructor was null");
        }
        _obj = in_obj;
        if (in_subs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'subs' to the SubscriptExpr constructor was null");
        }
        _subs = in_subs;
        if (in_op == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'op' to the SubscriptExpr constructor was null");
        }
        _op = in_op;
        if (in_staticArgs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'staticArgs' to the SubscriptExpr constructor was null");
        }
        _staticArgs = in_staticArgs;
    }

    final public Expr getObj() { return _obj; }
    final public List<Expr> getSubs() { return _subs; }
    final public Option<Op> getOp() { return _op; }
    final public List<StaticArg> getStaticArgs() { return _staticArgs; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forSubscriptExpr(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forSubscriptExpr(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forSubscriptExpr(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forSubscriptExpr(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forSubscriptExpr(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forSubscriptExpr(this);
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
            SubscriptExpr casted = (SubscriptExpr) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Expr temp_obj = getObj();
            Expr casted_obj = casted.getObj();
            if (!(temp_obj == casted_obj || temp_obj.equals(casted_obj))) return false;
            List<Expr> temp_subs = getSubs();
            List<Expr> casted_subs = casted.getSubs();
            if (!(temp_subs == casted_subs || temp_subs.equals(casted_subs))) return false;
            Option<Op> temp_op = getOp();
            Option<Op> casted_op = casted.getOp();
            if (!(temp_op == casted_op || temp_op.equals(casted_op))) return false;
            List<StaticArg> temp_staticArgs = getStaticArgs();
            List<StaticArg> casted_staticArgs = casted.getStaticArgs();
            if (!(temp_staticArgs == casted_staticArgs || temp_staticArgs.equals(casted_staticArgs))) return false;
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
        Expr temp_obj = getObj();
        code ^= temp_obj.hashCode();
        List<Expr> temp_subs = getSubs();
        code ^= temp_subs.hashCode();
        Option<Op> temp_op = getOp();
        code ^= temp_op.hashCode();
        List<StaticArg> temp_staticArgs = getStaticArgs();
        code ^= temp_staticArgs.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected SubscriptExpr() {
        _obj = null;
        _subs = null;
        _op = null;
        _staticArgs = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected SubscriptExpr(ExprInfo info) {
        super(info);
        _obj = null;
        _subs = null;
        _op = null;
        _staticArgs = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "SubscriptExpr", 5)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Expr temp_obj = getObj();
            if (w.visitNodeField("obj", temp_obj)) {
                temp_obj.walk(w);
                w.endNodeField("obj", temp_obj);
            }
            List<Expr> temp_subs = getSubs();
            if (w.visitNodeField("subs", temp_subs)) {
                if (w.visitIterated(temp_subs)) {
                    int i_temp_subs = 0;
                    for (Expr elt_temp_subs : temp_subs) {
                        if (w.visitIteratedElement(i_temp_subs, elt_temp_subs)) {
                            if (elt_temp_subs == null) w.visitNull();
                            else {
                                elt_temp_subs.walk(w);
                            }
                        }
                        i_temp_subs++;
                    }
                    w.endIterated(temp_subs, i_temp_subs);
                }
                w.endNodeField("subs", temp_subs);
            }
            Option<Op> temp_op = getOp();
            if (w.visitNodeField("op", temp_op)) {
                if (temp_op.isNone()) {
                    w.visitEmptyOption(temp_op);
                }
                else if (w.visitNonEmptyOption(temp_op)) {
                    Op elt_temp_op = temp_op.unwrap();
                    if (elt_temp_op == null) w.visitNull();
                    else {
                        elt_temp_op.walk(w);
                    }
                    w.endNonEmptyOption(temp_op);
                }
                w.endNodeField("op", temp_op);
            }
            List<StaticArg> temp_staticArgs = getStaticArgs();
            if (w.visitNodeField("staticArgs", temp_staticArgs)) {
                if (w.visitIterated(temp_staticArgs)) {
                    int i_temp_staticArgs = 0;
                    for (StaticArg elt_temp_staticArgs : temp_staticArgs) {
                        if (w.visitIteratedElement(i_temp_staticArgs, elt_temp_staticArgs)) {
                            if (elt_temp_staticArgs == null) w.visitNull();
                            else {
                                elt_temp_staticArgs.walk(w);
                            }
                        }
                        i_temp_staticArgs++;
                    }
                    w.endIterated(temp_staticArgs, i_temp_staticArgs);
                }
                w.endNodeField("staticArgs", temp_staticArgs);
            }
            w.endNode(this, "SubscriptExpr", 5);
        }
    }

}
