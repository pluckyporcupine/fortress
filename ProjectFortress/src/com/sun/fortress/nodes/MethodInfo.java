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
 * Class MethodInfo, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class MethodInfo extends DataNode {
    private final Type _selfType;
    private final int _selfPosition;

    /**
     * Constructs a MethodInfo.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public MethodInfo(Type in_selfType, int in_selfPosition) {
        super();
        if (in_selfType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'selfType' to the MethodInfo constructor was null");
        }
        _selfType = in_selfType;
        _selfPosition = in_selfPosition;
    }

    final public Type getSelfType() { return _selfType; }
    final public int getSelfPosition() { return _selfPosition; }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forMethodInfo(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forMethodInfo(this);
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
            MethodInfo casted = (MethodInfo) obj;
            Type temp_selfType = getSelfType();
            Type casted_selfType = casted.getSelfType();
            if (!(temp_selfType == casted_selfType || temp_selfType.equals(casted_selfType))) return false;
            int temp_selfPosition = getSelfPosition();
            int casted_selfPosition = casted.getSelfPosition();
            if (!(temp_selfPosition == casted_selfPosition)) return false;
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
        Type temp_selfType = getSelfType();
        code ^= temp_selfType.hashCode();
        int temp_selfPosition = getSelfPosition();
        code ^= temp_selfPosition;
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected MethodInfo() {
        _selfType = null;
        _selfPosition = 0;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "MethodInfo", 2)) {
            Type temp_selfType = getSelfType();
            if (w.visitNodeField("selfType", temp_selfType)) {
                temp_selfType.walk(w);
                w.endNodeField("selfType", temp_selfType);
            }
            int temp_selfPosition = getSelfPosition();
            if (w.visitNodeField("selfPosition", temp_selfPosition)) {
                w.visitInt(temp_selfPosition);
                w.endNodeField("selfPosition", temp_selfPosition);
            }
            w.endNode(this, "MethodInfo", 2);
        }
    }

}
