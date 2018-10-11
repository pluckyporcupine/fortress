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
 * Class PlainPattern, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class PlainPattern extends PatternBinding {
    private final Id _name;
    private final Modifiers _mods;
    private final Option<TypeOrPattern> _idType;

    /**
     * Constructs a PlainPattern.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public PlainPattern(ASTNodeInfo in_info, Option<Id> in_field, Id in_name, Modifiers in_mods, Option<TypeOrPattern> in_idType) {
        super(in_info, in_field);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the PlainPattern constructor was null");
        }
        _name = in_name;
        if (in_mods == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'mods' to the PlainPattern constructor was null");
        }
        _mods = in_mods;
        if (in_idType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'idType' to the PlainPattern constructor was null");
        }
        _idType = in_idType;
    }

    final public Id getName() { return _name; }
    final public Modifiers getMods() { return _mods; }
    final public Option<TypeOrPattern> getIdType() { return _idType; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forPlainPattern(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forPlainPattern(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forPlainPattern(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forPlainPattern(this);
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
            PlainPattern casted = (PlainPattern) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<Id> temp_field = getField();
            Option<Id> casted_field = casted.getField();
            if (!(temp_field == casted_field || temp_field.equals(casted_field))) return false;
            Id temp_name = getName();
            Id casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            Modifiers temp_mods = getMods();
            Modifiers casted_mods = casted.getMods();
            if (!(temp_mods == casted_mods || temp_mods.equals(casted_mods))) return false;
            Option<TypeOrPattern> temp_idType = getIdType();
            Option<TypeOrPattern> casted_idType = casted.getIdType();
            if (!(temp_idType == casted_idType || temp_idType.equals(casted_idType))) return false;
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
        Option<Id> temp_field = getField();
        code ^= temp_field.hashCode();
        Id temp_name = getName();
        code ^= temp_name.hashCode();
        Modifiers temp_mods = getMods();
        code ^= temp_mods.hashCode();
        Option<TypeOrPattern> temp_idType = getIdType();
        code ^= temp_idType.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected PlainPattern() {
        _name = null;
        _mods = null;
        _idType = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected PlainPattern(ASTNodeInfo info) {
        super(info);
        _name = null;
        _mods = null;
        _idType = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "PlainPattern", 5)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Option<Id> temp_field = getField();
            if (w.visitNodeField("field", temp_field)) {
                if (temp_field.isNone()) {
                    w.visitEmptyOption(temp_field);
                }
                else if (w.visitNonEmptyOption(temp_field)) {
                    Id elt_temp_field = temp_field.unwrap();
                    if (elt_temp_field == null) w.visitNull();
                    else {
                        elt_temp_field.walk(w);
                    }
                    w.endNonEmptyOption(temp_field);
                }
                w.endNodeField("field", temp_field);
            }
            Id temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            Modifiers temp_mods = getMods();
            if (w.visitNodeField("mods", temp_mods)) {
                w.visitUnknownObject(temp_mods);
                w.endNodeField("mods", temp_mods);
            }
            Option<TypeOrPattern> temp_idType = getIdType();
            if (w.visitNodeField("idType", temp_idType)) {
                if (temp_idType.isNone()) {
                    w.visitEmptyOption(temp_idType);
                }
                else if (w.visitNonEmptyOption(temp_idType)) {
                    TypeOrPattern elt_temp_idType = temp_idType.unwrap();
                    if (elt_temp_idType == null) w.visitNull();
                    else {
                        elt_temp_idType.walk(w);
                    }
                    w.endNonEmptyOption(temp_idType);
                }
                w.endNodeField("idType", temp_idType);
            }
            w.endNode(this, "PlainPattern", 5);
        }
    }

}
