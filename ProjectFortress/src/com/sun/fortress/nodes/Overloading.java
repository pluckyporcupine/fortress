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
 * Class Overloading, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class Overloading extends AbstractNode {
    private final IdOrOp _unambiguousName;
    private final IdOrOp _originalName;
    private final Option<ArrowType> _type;
    private final Option<ArrowType> _schema;

    /**
     * Constructs a Overloading.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Overloading(ASTNodeInfo in_info, IdOrOp in_unambiguousName, IdOrOp in_originalName, Option<ArrowType> in_type, Option<ArrowType> in_schema) {
        super(in_info);
        if (in_unambiguousName == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'unambiguousName' to the Overloading constructor was null");
        }
        _unambiguousName = in_unambiguousName;
        if (in_originalName == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'originalName' to the Overloading constructor was null");
        }
        _originalName = in_originalName;
        if (in_type == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'type' to the Overloading constructor was null");
        }
        _type = in_type;
        if (in_schema == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'schema' to the Overloading constructor was null");
        }
        _schema = in_schema;
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public Overloading(ASTNodeInfo in_info, IdOrOp in_unambiguousName, IdOrOp in_originalName, Option<ArrowType> in_type) {
        this(in_info, in_unambiguousName, in_originalName, in_type, Option.<ArrowType>none());
    }

    final public IdOrOp getUnambiguousName() { return _unambiguousName; }
    final public IdOrOp getOriginalName() { return _originalName; }
    final public Option<ArrowType> getType() { return _type; }
    final public Option<ArrowType> getSchema() { return _schema; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forOverloading(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forOverloading(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forOverloading(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forOverloading(this);
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
            Overloading casted = (Overloading) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            IdOrOp temp_unambiguousName = getUnambiguousName();
            IdOrOp casted_unambiguousName = casted.getUnambiguousName();
            if (!(temp_unambiguousName == casted_unambiguousName || temp_unambiguousName.equals(casted_unambiguousName))) return false;
            IdOrOp temp_originalName = getOriginalName();
            IdOrOp casted_originalName = casted.getOriginalName();
            if (!(temp_originalName == casted_originalName || temp_originalName.equals(casted_originalName))) return false;
            Option<ArrowType> temp_type = getType();
            Option<ArrowType> casted_type = casted.getType();
            if (!(temp_type == casted_type || temp_type.equals(casted_type))) return false;
            Option<ArrowType> temp_schema = getSchema();
            Option<ArrowType> casted_schema = casted.getSchema();
            if (!(temp_schema == casted_schema || temp_schema.equals(casted_schema))) return false;
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
        IdOrOp temp_unambiguousName = getUnambiguousName();
        code ^= temp_unambiguousName.hashCode();
        IdOrOp temp_originalName = getOriginalName();
        code ^= temp_originalName.hashCode();
        Option<ArrowType> temp_type = getType();
        code ^= temp_type.hashCode();
        Option<ArrowType> temp_schema = getSchema();
        code ^= temp_schema.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Overloading() {
        _unambiguousName = null;
        _originalName = null;
        _type = null;
        _schema = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Overloading(ASTNodeInfo info) {
        super(info);
        _unambiguousName = null;
        _originalName = null;
        _type = null;
        _schema = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "Overloading", 5)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            IdOrOp temp_unambiguousName = getUnambiguousName();
            if (w.visitNodeField("unambiguousName", temp_unambiguousName)) {
                temp_unambiguousName.walk(w);
                w.endNodeField("unambiguousName", temp_unambiguousName);
            }
            IdOrOp temp_originalName = getOriginalName();
            if (w.visitNodeField("originalName", temp_originalName)) {
                temp_originalName.walk(w);
                w.endNodeField("originalName", temp_originalName);
            }
            Option<ArrowType> temp_type = getType();
            if (w.visitNodeField("type", temp_type)) {
                if (temp_type.isNone()) {
                    w.visitEmptyOption(temp_type);
                }
                else if (w.visitNonEmptyOption(temp_type)) {
                    ArrowType elt_temp_type = temp_type.unwrap();
                    if (elt_temp_type == null) w.visitNull();
                    else {
                        elt_temp_type.walk(w);
                    }
                    w.endNonEmptyOption(temp_type);
                }
                w.endNodeField("type", temp_type);
            }
            Option<ArrowType> temp_schema = getSchema();
            if (w.visitNodeField("schema", temp_schema)) {
                if (temp_schema.isNone()) {
                    w.visitEmptyOption(temp_schema);
                }
                else if (w.visitNonEmptyOption(temp_schema)) {
                    ArrowType elt_temp_schema = temp_schema.unwrap();
                    if (elt_temp_schema == null) w.visitNull();
                    else {
                        elt_temp_schema.walk(w);
                    }
                    w.endNonEmptyOption(temp_schema);
                }
                w.endNodeField("schema", temp_schema);
            }
            w.endNode(this, "Overloading", 5);
        }
    }

}
