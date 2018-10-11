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
 * Class FieldRef, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class FieldRef extends Primary implements Lhs {
    private final Expr _obj;
    private final Id _field;

    /**
     * Constructs a FieldRef.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public FieldRef(ExprInfo in_info, Expr in_obj, Id in_field) {
        super(in_info);
        if (in_obj == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'obj' to the FieldRef constructor was null");
        }
        _obj = in_obj;
        if (in_field == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'field' to the FieldRef constructor was null");
        }
        _field = in_field;
    }

    final public Expr getObj() { return _obj; }
    final public Id getField() { return _field; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forFieldRef(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forFieldRef(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forFieldRef(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forFieldRef(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forFieldRef(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forFieldRef(this);
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
            FieldRef casted = (FieldRef) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Expr temp_obj = getObj();
            Expr casted_obj = casted.getObj();
            if (!(temp_obj == casted_obj || temp_obj.equals(casted_obj))) return false;
            Id temp_field = getField();
            Id casted_field = casted.getField();
            if (!(temp_field == casted_field || temp_field.equals(casted_field))) return false;
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
        Expr temp_obj = getObj();
        code ^= temp_obj.hashCode();
        Id temp_field = getField();
        code ^= temp_field.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected FieldRef() {
        _obj = null;
        _field = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected FieldRef(ExprInfo info) {
        super(info);
        _obj = null;
        _field = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "FieldRef", 3)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Expr temp_obj = getObj();
            if (w.visitNodeField("obj", temp_obj)) {
                temp_obj.walk(w);
                w.endNodeField("obj", temp_obj);
            }
            Id temp_field = getField();
            if (w.visitNodeField("field", temp_field)) {
                temp_field.walk(w);
                w.endNodeField("field", temp_field);
            }
            w.endNode(this, "FieldRef", 3);
        }
    }

}
