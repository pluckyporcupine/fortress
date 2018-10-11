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
 * Class AmbiguousMultifixOpExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class AmbiguousMultifixOpExpr extends Primary implements OutAfterTypeChecking {
    private final FunctionalRef _infix_op;
    private final FunctionalRef _multifix_op;
    private final List<Expr> _args;

    /**
     * Constructs a AmbiguousMultifixOpExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public AmbiguousMultifixOpExpr(ExprInfo in_info, FunctionalRef in_infix_op, FunctionalRef in_multifix_op, List<Expr> in_args) {
        super(in_info);
        if (in_infix_op == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'infix_op' to the AmbiguousMultifixOpExpr constructor was null");
        }
        _infix_op = in_infix_op;
        if (in_multifix_op == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'multifix_op' to the AmbiguousMultifixOpExpr constructor was null");
        }
        _multifix_op = in_multifix_op;
        if (in_args == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'args' to the AmbiguousMultifixOpExpr constructor was null");
        }
        _args = in_args;
    }

    final public FunctionalRef getInfix_op() { return _infix_op; }
    final public FunctionalRef getMultifix_op() { return _multifix_op; }
    final public List<Expr> getArgs() { return _args; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forAmbiguousMultifixOpExpr(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forAmbiguousMultifixOpExpr(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forAmbiguousMultifixOpExpr(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forAmbiguousMultifixOpExpr(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forAmbiguousMultifixOpExpr(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forAmbiguousMultifixOpExpr(this);
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
            AmbiguousMultifixOpExpr casted = (AmbiguousMultifixOpExpr) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            FunctionalRef temp_infix_op = getInfix_op();
            FunctionalRef casted_infix_op = casted.getInfix_op();
            if (!(temp_infix_op == casted_infix_op || temp_infix_op.equals(casted_infix_op))) return false;
            FunctionalRef temp_multifix_op = getMultifix_op();
            FunctionalRef casted_multifix_op = casted.getMultifix_op();
            if (!(temp_multifix_op == casted_multifix_op || temp_multifix_op.equals(casted_multifix_op))) return false;
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
        FunctionalRef temp_infix_op = getInfix_op();
        code ^= temp_infix_op.hashCode();
        FunctionalRef temp_multifix_op = getMultifix_op();
        code ^= temp_multifix_op.hashCode();
        List<Expr> temp_args = getArgs();
        code ^= temp_args.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected AmbiguousMultifixOpExpr() {
        _infix_op = null;
        _multifix_op = null;
        _args = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected AmbiguousMultifixOpExpr(ExprInfo info) {
        super(info);
        _infix_op = null;
        _multifix_op = null;
        _args = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "AmbiguousMultifixOpExpr", 4)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            FunctionalRef temp_infix_op = getInfix_op();
            if (w.visitNodeField("infix_op", temp_infix_op)) {
                temp_infix_op.walk(w);
                w.endNodeField("infix_op", temp_infix_op);
            }
            FunctionalRef temp_multifix_op = getMultifix_op();
            if (w.visitNodeField("multifix_op", temp_multifix_op)) {
                temp_multifix_op.walk(w);
                w.endNodeField("multifix_op", temp_multifix_op);
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
            w.endNode(this, "AmbiguousMultifixOpExpr", 4);
        }
    }

}
