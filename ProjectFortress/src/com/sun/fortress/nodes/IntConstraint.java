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
 * Class IntConstraint, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class IntConstraint extends WhereConstraint {
    private final IntExpr _left;
    private final IntExpr _right;
    private final Op _op;

    /**
     * Constructs a IntConstraint.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public IntConstraint(ASTNodeInfo in_info, IntExpr in_left, IntExpr in_right, Op in_op) {
        super(in_info);
        if (in_left == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'left' to the IntConstraint constructor was null");
        }
        _left = in_left;
        if (in_right == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'right' to the IntConstraint constructor was null");
        }
        _right = in_right;
        if (in_op == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'op' to the IntConstraint constructor was null");
        }
        _op = in_op;
    }

    final public IntExpr getLeft() { return _left; }
    final public IntExpr getRight() { return _right; }
    final public Op getOp() { return _op; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forIntConstraint(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forIntConstraint(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forIntConstraint(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forIntConstraint(this);
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
            IntConstraint casted = (IntConstraint) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            IntExpr temp_left = getLeft();
            IntExpr casted_left = casted.getLeft();
            if (!(temp_left == casted_left || temp_left.equals(casted_left))) return false;
            IntExpr temp_right = getRight();
            IntExpr casted_right = casted.getRight();
            if (!(temp_right == casted_right || temp_right.equals(casted_right))) return false;
            Op temp_op = getOp();
            Op casted_op = casted.getOp();
            if (!(temp_op == casted_op || temp_op.equals(casted_op))) return false;
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
        IntExpr temp_left = getLeft();
        code ^= temp_left.hashCode();
        IntExpr temp_right = getRight();
        code ^= temp_right.hashCode();
        Op temp_op = getOp();
        code ^= temp_op.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected IntConstraint() {
        _left = null;
        _right = null;
        _op = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected IntConstraint(ASTNodeInfo info) {
        super(info);
        _left = null;
        _right = null;
        _op = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "IntConstraint", 4)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            IntExpr temp_left = getLeft();
            if (w.visitNodeField("left", temp_left)) {
                temp_left.walk(w);
                w.endNodeField("left", temp_left);
            }
            IntExpr temp_right = getRight();
            if (w.visitNodeField("right", temp_right)) {
                temp_right.walk(w);
                w.endNodeField("right", temp_right);
            }
            Op temp_op = getOp();
            if (w.visitNodeField("op", temp_op)) {
                temp_op.walk(w);
                w.endNodeField("op", temp_op);
            }
            w.endNode(this, "IntConstraint", 4);
        }
    }

}
