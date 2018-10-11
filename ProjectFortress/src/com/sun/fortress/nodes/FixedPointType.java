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
 * Class FixedPointType, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class FixedPointType extends Type {
    private final _InferenceVarType _name;
    private final Type _body;

    /**
     * Constructs a FixedPointType.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public FixedPointType(TypeInfo in_info, _InferenceVarType in_name, Type in_body) {
        super(in_info);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the FixedPointType constructor was null");
        }
        _name = in_name;
        if (in_body == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'body' to the FixedPointType constructor was null");
        }
        _body = in_body;
    }

    final public _InferenceVarType getName() { return _name; }
    final public Type getBody() { return _body; }

    public <RetType> RetType accept(TypeVisitor<RetType> visitor) {
        return visitor.forFixedPointType(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forFixedPointType(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forFixedPointType(this);
    }

    public void accept(TypeVisitor_void visitor) {
        visitor.forFixedPointType(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forFixedPointType(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forFixedPointType(this);
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
            FixedPointType casted = (FixedPointType) obj;
            TypeInfo temp_info = getInfo();
            TypeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            _InferenceVarType temp_name = getName();
            _InferenceVarType casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            Type temp_body = getBody();
            Type casted_body = casted.getBody();
            if (!(temp_body == casted_body || temp_body.equals(casted_body))) return false;
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
        _InferenceVarType temp_name = getName();
        code ^= temp_name.hashCode();
        Type temp_body = getBody();
        code ^= temp_body.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected FixedPointType() {
        _name = null;
        _body = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected FixedPointType(TypeInfo info) {
        super(info);
        _name = null;
        _body = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "FixedPointType", 3)) {
            TypeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            _InferenceVarType temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            Type temp_body = getBody();
            if (w.visitNodeField("body", temp_body)) {
                temp_body.walk(w);
                w.endNodeField("body", temp_body);
            }
            w.endNode(this, "FixedPointType", 3);
        }
    }

}
