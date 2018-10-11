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
 * Class OpExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class OpExpr extends Primary {
    private final FunctionalRef _op;
    private final List<Expr> _args;

    /**
     * Constructs a OpExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public OpExpr(ExprInfo in_info, FunctionalRef in_op, List<Expr> in_args) {
        super(in_info);
        if (in_op == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'op' to the OpExpr constructor was null");
        }
        _op = in_op;
        if (in_args == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'args' to the OpExpr constructor was null");
        }
        _args = in_args;
    }

    final public FunctionalRef getOp() { return _op; }
    final public List<Expr> getArgs() { return _args; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forOpExpr(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forOpExpr(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forOpExpr(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forOpExpr(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forOpExpr(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forOpExpr(this);
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
            OpExpr casted = (OpExpr) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            FunctionalRef temp_op = getOp();
            FunctionalRef casted_op = casted.getOp();
            if (!(temp_op == casted_op || temp_op.equals(casted_op))) return false;
            List<Expr> temp_args = getArgs();
            List<Expr> casted_args = casted.getArgs();
            if (!(temp_args == casted_args || temp_args.equals(casted_args))) return false;
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
        FunctionalRef temp_op = getOp();
        code ^= temp_op.hashCode();
        List<Expr> temp_args = getArgs();
        code ^= temp_args.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected OpExpr() {
        _op = null;
        _args = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected OpExpr(ExprInfo info) {
        super(info);
        _op = null;
        _args = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "OpExpr", 3)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            FunctionalRef temp_op = getOp();
            if (w.visitNodeField("op", temp_op)) {
                temp_op.walk(w);
                w.endNodeField("op", temp_op);
            }
            List<Expr> temp_args = getArgs();
            if (w.visitNodeField("args", temp_args)) {
                if (w.visitIterated(temp_args)) {
                    int i_temp_args = 0;
                    for (Expr elt_temp_args : temp_args) {
                        if (w.visitIteratedElement(i_temp_args, elt_temp_args)) {
                            if (elt_temp_args == null) w.visitNull();
                            else {
                                elt_temp_args.walk(w);
                            }
                        }
                        i_temp_args++;
                    }
                    w.endIterated(temp_args, i_temp_args);
                }
                w.endNodeField("args", temp_args);
            }
            w.endNode(this, "OpExpr", 3);
        }
    }

}
