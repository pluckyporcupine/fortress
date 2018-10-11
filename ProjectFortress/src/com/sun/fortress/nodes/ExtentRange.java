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
 * Class ExtentRange, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ExtentRange extends AbstractNode {
    private final Option<StaticArg> _base;
    private final Option<StaticArg> _size;
    private final Option<Op> _op;

    /**
     * Constructs a ExtentRange.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ExtentRange(ASTNodeInfo in_info, Option<StaticArg> in_base, Option<StaticArg> in_size, Option<Op> in_op) {
        super(in_info);
        if (in_base == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'base' to the ExtentRange constructor was null");
        }
        _base = in_base;
        if (in_size == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'size' to the ExtentRange constructor was null");
        }
        _size = in_size;
        if (in_op == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'op' to the ExtentRange constructor was null");
        }
        _op = in_op;
    }

    final public Option<StaticArg> getBase() { return _base; }
    final public Option<StaticArg> getSize() { return _size; }
    final public Option<Op> getOp() { return _op; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forExtentRange(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forExtentRange(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forExtentRange(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forExtentRange(this);
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
            ExtentRange casted = (ExtentRange) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<StaticArg> temp_base = getBase();
            Option<StaticArg> casted_base = casted.getBase();
            if (!(temp_base == casted_base || temp_base.equals(casted_base))) return false;
            Option<StaticArg> temp_size = getSize();
            Option<StaticArg> casted_size = casted.getSize();
            if (!(temp_size == casted_size || temp_size.equals(casted_size))) return false;
            Option<Op> temp_op = getOp();
            Option<Op> casted_op = casted.getOp();
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
        Option<StaticArg> temp_base = getBase();
        code ^= temp_base.hashCode();
        Option<StaticArg> temp_size = getSize();
        code ^= temp_size.hashCode();
        Option<Op> temp_op = getOp();
        code ^= temp_op.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ExtentRange() {
        _base = null;
        _size = null;
        _op = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ExtentRange(ASTNodeInfo info) {
        super(info);
        _base = null;
        _size = null;
        _op = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ExtentRange", 4)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Option<StaticArg> temp_base = getBase();
            if (w.visitNodeField("base", temp_base)) {
                if (temp_base.isNone()) {
                    w.visitEmptyOption(temp_base);
                }
                else if (w.visitNonEmptyOption(temp_base)) {
                    StaticArg elt_temp_base = temp_base.unwrap();
                    if (elt_temp_base == null) w.visitNull();
                    else {
                        elt_temp_base.walk(w);
                    }
                    w.endNonEmptyOption(temp_base);
                }
                w.endNodeField("base", temp_base);
            }
            Option<StaticArg> temp_size = getSize();
            if (w.visitNodeField("size", temp_size)) {
                if (temp_size.isNone()) {
                    w.visitEmptyOption(temp_size);
                }
                else if (w.visitNonEmptyOption(temp_size)) {
                    StaticArg elt_temp_size = temp_size.unwrap();
                    if (elt_temp_size == null) w.visitNull();
                    else {
                        elt_temp_size.walk(w);
                    }
                    w.endNonEmptyOption(temp_size);
                }
                w.endNodeField("size", temp_size);
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
            w.endNode(this, "ExtentRange", 4);
        }
    }

}
