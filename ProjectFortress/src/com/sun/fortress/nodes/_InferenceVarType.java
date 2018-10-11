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
 * Class _InferenceVarType, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _InferenceVarType extends NamedType implements OutAfterTypeChecking, TypeVariable {
    private final Object _id;

    /**
     * Constructs a _InferenceVarType.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _InferenceVarType(TypeInfo in_info, Id in_name, Object in_id) {
        super(in_info, in_name);
        if (in_id == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'id' to the _InferenceVarType constructor was null");
        }
        _id = in_id;
    }

    final public Object getId() { return _id; }

    public <RetType> RetType accept(TypeVisitor<RetType> visitor) {
        return visitor.for_InferenceVarType(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_InferenceVarType(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_InferenceVarType(this);
    }

    public void accept(TypeVisitor_void visitor) {
        visitor.for_InferenceVarType(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_InferenceVarType(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_InferenceVarType(this);
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
            _InferenceVarType casted = (_InferenceVarType) obj;
            TypeInfo temp_info = getInfo();
            TypeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_name = getName();
            Id casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            Object temp_id = getId();
            Object casted_id = casted.getId();
            if (!(temp_id == casted_id || temp_id.equals(casted_id))) return false;
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
        Id temp_name = getName();
        code ^= temp_name.hashCode();
        Object temp_id = getId();
        code ^= temp_id.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected _InferenceVarType() {
        _id = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _InferenceVarType(TypeInfo info) {
        super(info);
        _id = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_InferenceVarType", 3)) {
            TypeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Id temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            Object temp_id = getId();
            if (w.visitNodeField("id", temp_id)) {
                w.visitUnknownObject(temp_id);
                w.endNodeField("id", temp_id);
            }
            w.endNode(this, "_InferenceVarType", 3);
        }
    }

}
