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
 * Class DimUnaryOp, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class DimUnaryOp extends DimExpr {
    private final DimExpr _dimVal;
    private final Op _op;

    /**
     * Constructs a DimUnaryOp.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public DimUnaryOp(TypeInfo in_info, DimExpr in_dimVal, Op in_op) {
        super(in_info);
        if (in_dimVal == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'dimVal' to the DimUnaryOp constructor was null");
        }
        _dimVal = in_dimVal;
        if (in_op == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'op' to the DimUnaryOp constructor was null");
        }
        _op = in_op;
    }

    final public DimExpr getDimVal() { return _dimVal; }
    final public Op getOp() { return _op; }

    public <RetType> RetType accept(TypeVisitor<RetType> visitor) {
        return visitor.forDimUnaryOp(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forDimUnaryOp(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forDimUnaryOp(this);
    }

    public void accept(TypeVisitor_void visitor) {
        visitor.forDimUnaryOp(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forDimUnaryOp(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forDimUnaryOp(this);
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
            DimUnaryOp casted = (DimUnaryOp) obj;
            TypeInfo temp_info = getInfo();
            TypeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            DimExpr temp_dimVal = getDimVal();
            DimExpr casted_dimVal = casted.getDimVal();
            if (!(temp_dimVal == casted_dimVal || temp_dimVal.equals(casted_dimVal))) return false;
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
        TypeInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        DimExpr temp_dimVal = getDimVal();
        code ^= temp_dimVal.hashCode();
        Op temp_op = getOp();
        code ^= temp_op.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected DimUnaryOp() {
        _dimVal = null;
        _op = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected DimUnaryOp(TypeInfo info) {
        super(info);
        _dimVal = null;
        _op = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "DimUnaryOp", 3)) {
            TypeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            DimExpr temp_dimVal = getDimVal();
            if (w.visitNodeField("dimVal", temp_dimVal)) {
                temp_dimVal.walk(w);
                w.endNodeField("dimVal", temp_dimVal);
            }
            Op temp_op = getOp();
            if (w.visitNodeField("op", temp_op)) {
                temp_op.walk(w);
                w.endNodeField("op", temp_op);
            }
            w.endNode(this, "DimUnaryOp", 3);
        }
    }

}
