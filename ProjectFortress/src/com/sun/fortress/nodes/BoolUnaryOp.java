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
 * Class BoolUnaryOp, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class BoolUnaryOp extends BoolConstraint {
    private final BoolExpr _boolVal;
    private final Op _op;

    /**
     * Constructs a BoolUnaryOp.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public BoolUnaryOp(ASTNodeInfo in_info, boolean in_parenthesized, BoolExpr in_boolVal, Op in_op) {
        super(in_info, in_parenthesized);
        if (in_boolVal == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'boolVal' to the BoolUnaryOp constructor was null");
        }
        _boolVal = in_boolVal;
        if (in_op == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'op' to the BoolUnaryOp constructor was null");
        }
        _op = in_op;
    }

    final public BoolExpr getBoolVal() { return _boolVal; }
    final public Op getOp() { return _op; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forBoolUnaryOp(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forBoolUnaryOp(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forBoolUnaryOp(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forBoolUnaryOp(this);
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
            BoolUnaryOp casted = (BoolUnaryOp) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            BoolExpr temp_boolVal = getBoolVal();
            BoolExpr casted_boolVal = casted.getBoolVal();
            if (!(temp_boolVal == casted_boolVal || temp_boolVal.equals(casted_boolVal))) return false;
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
        BoolExpr temp_boolVal = getBoolVal();
        code ^= temp_boolVal.hashCode();
        Op temp_op = getOp();
        code ^= temp_op.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected BoolUnaryOp() {
        _boolVal = null;
        _op = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected BoolUnaryOp(ASTNodeInfo info) {
        super(info);
        _boolVal = null;
        _op = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "BoolUnaryOp", 4)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            boolean temp_parenthesized = isParenthesized();
            if (w.visitNodeField("parenthesized", temp_parenthesized)) {
                w.visitBoolean(temp_parenthesized);
                w.endNodeField("parenthesized", temp_parenthesized);
            }
            BoolExpr temp_boolVal = getBoolVal();
            if (w.visitNodeField("boolVal", temp_boolVal)) {
                temp_boolVal.walk(w);
                w.endNodeField("boolVal", temp_boolVal);
            }
            Op temp_op = getOp();
            if (w.visitNodeField("op", temp_op)) {
                temp_op.walk(w);
                w.endNodeField("op", temp_op);
            }
            w.endNode(this, "BoolUnaryOp", 4);
        }
    }

}
