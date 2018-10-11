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
 * Class WhereCoerces, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class WhereCoerces extends WhereConstraint {
    private final Type _left;
    private final Type _right;
    private final boolean _coerces;
    private final boolean _widens;

    /**
     * Constructs a WhereCoerces.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public WhereCoerces(ASTNodeInfo in_info, Type in_left, Type in_right, boolean in_coerces, boolean in_widens) {
        super(in_info);
        if (in_left == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'left' to the WhereCoerces constructor was null");
        }
        _left = in_left;
        if (in_right == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'right' to the WhereCoerces constructor was null");
        }
        _right = in_right;
        _coerces = in_coerces;
        _widens = in_widens;
    }

    final public Type getLeft() { return _left; }
    final public Type getRight() { return _right; }
    final public boolean isCoerces() { return _coerces; }
    final public boolean isWidens() { return _widens; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forWhereCoerces(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forWhereCoerces(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forWhereCoerces(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forWhereCoerces(this);
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
            WhereCoerces casted = (WhereCoerces) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Type temp_left = getLeft();
            Type casted_left = casted.getLeft();
            if (!(temp_left == casted_left || temp_left.equals(casted_left))) return false;
            Type temp_right = getRight();
            Type casted_right = casted.getRight();
            if (!(temp_right == casted_right || temp_right.equals(casted_right))) return false;
            boolean temp_coerces = isCoerces();
            boolean casted_coerces = casted.isCoerces();
            if (!(temp_coerces == casted_coerces)) return false;
            boolean temp_widens = isWidens();
            boolean casted_widens = casted.isWidens();
            if (!(temp_widens == casted_widens)) return false;
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
        Type temp_left = getLeft();
        code ^= temp_left.hashCode();
        Type temp_right = getRight();
        code ^= temp_right.hashCode();
        boolean temp_coerces = isCoerces();
        code ^= temp_coerces ? 1231 : 1237;
        boolean temp_widens = isWidens();
        code ^= temp_widens ? 1231 : 1237;
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected WhereCoerces() {
        _left = null;
        _right = null;
        _coerces = false;
        _widens = false;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected WhereCoerces(ASTNodeInfo info) {
        super(info);
        _left = null;
        _right = null;
        _coerces = false;
        _widens = false;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "WhereCoerces", 5)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Type temp_left = getLeft();
            if (w.visitNodeField("left", temp_left)) {
                temp_left.walk(w);
                w.endNodeField("left", temp_left);
            }
            Type temp_right = getRight();
            if (w.visitNodeField("right", temp_right)) {
                temp_right.walk(w);
                w.endNodeField("right", temp_right);
            }
            boolean temp_coerces = isCoerces();
            if (w.visitNodeField("coerces", temp_coerces)) {
                w.visitBoolean(temp_coerces);
                w.endNodeField("coerces", temp_coerces);
            }
            boolean temp_widens = isWidens();
            if (w.visitNodeField("widens", temp_widens)) {
                w.visitBoolean(temp_widens);
                w.endNodeField("widens", temp_widens);
            }
            w.endNode(this, "WhereCoerces", 5);
        }
    }

}
