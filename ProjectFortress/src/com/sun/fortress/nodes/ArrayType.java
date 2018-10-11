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
 * Class ArrayType, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ArrayType extends AbbreviatedType implements OutAfterTypeChecking {
    private final Indices _indices;

    /**
     * Constructs a ArrayType.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ArrayType(TypeInfo in_info, Type in_elemType, Indices in_indices) {
        super(in_info, in_elemType);
        if (in_indices == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'indices' to the ArrayType constructor was null");
        }
        _indices = in_indices;
    }

    final public Indices getIndices() { return _indices; }

    public <RetType> RetType accept(TypeVisitor<RetType> visitor) {
        return visitor.forArrayType(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forArrayType(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forArrayType(this);
    }

    public void accept(TypeVisitor_void visitor) {
        visitor.forArrayType(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forArrayType(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forArrayType(this);
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
            ArrayType casted = (ArrayType) obj;
            TypeInfo temp_info = getInfo();
            TypeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Type temp_elemType = getElemType();
            Type casted_elemType = casted.getElemType();
            if (!(temp_elemType == casted_elemType || temp_elemType.equals(casted_elemType))) return false;
            Indices temp_indices = getIndices();
            Indices casted_indices = casted.getIndices();
            if (!(temp_indices == casted_indices || temp_indices.equals(casted_indices))) return false;
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
        Type temp_elemType = getElemType();
        code ^= temp_elemType.hashCode();
        Indices temp_indices = getIndices();
        code ^= temp_indices.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ArrayType() {
        _indices = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ArrayType(TypeInfo info) {
        super(info);
        _indices = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ArrayType", 3)) {
            TypeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Type temp_elemType = getElemType();
            if (w.visitNodeField("elemType", temp_elemType)) {
                temp_elemType.walk(w);
                w.endNodeField("elemType", temp_elemType);
            }
            Indices temp_indices = getIndices();
            if (w.visitNodeField("indices", temp_indices)) {
                temp_indices.walk(w);
                w.endNodeField("indices", temp_indices);
            }
            w.endNode(this, "ArrayType", 3);
        }
    }

}
