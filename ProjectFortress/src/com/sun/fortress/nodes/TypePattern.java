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
 * Class TypePattern, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class TypePattern extends PatternBinding {
    private final Type _typ;

    /**
     * Constructs a TypePattern.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TypePattern(ASTNodeInfo in_info, Option<Id> in_field, Type in_typ) {
        super(in_info, in_field);
        if (in_typ == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'typ' to the TypePattern constructor was null");
        }
        _typ = in_typ;
    }

    final public Type getTyp() { return _typ; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTypePattern(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTypePattern(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTypePattern(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTypePattern(this);
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
            TypePattern casted = (TypePattern) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<Id> temp_field = getField();
            Option<Id> casted_field = casted.getField();
            if (!(temp_field == casted_field || temp_field.equals(casted_field))) return false;
            Type temp_typ = getTyp();
            Type casted_typ = casted.getTyp();
            if (!(temp_typ == casted_typ || temp_typ.equals(casted_typ))) return false;
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
        Type temp_typ = getTyp();
        code ^= temp_typ.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TypePattern() {
        _typ = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TypePattern(ASTNodeInfo info) {
        super(info);
        _typ = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TypePattern", 3)) {
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
            Type temp_typ = getTyp();
            if (w.visitNodeField("typ", temp_typ)) {
                temp_typ.walk(w);
                w.endNodeField("typ", temp_typ);
            }
            w.endNode(this, "TypePattern", 3);
        }
    }

}
