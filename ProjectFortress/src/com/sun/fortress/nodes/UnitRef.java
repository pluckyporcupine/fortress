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
 * Class UnitRef, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class UnitRef extends UnitExpr {
    private final Id _name;

    /**
     * Constructs a UnitRef.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public UnitRef(ASTNodeInfo in_info, boolean in_parenthesized, Id in_name) {
        super(in_info, in_parenthesized);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the UnitRef constructor was null");
        }
        _name = in_name;
    }

    final public Id getName() { return _name; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forUnitRef(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forUnitRef(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forUnitRef(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forUnitRef(this);
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
            UnitRef casted = (UnitRef) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_name = getName();
            Id casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
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
        Id temp_name = getName();
        code ^= temp_name.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected UnitRef() {
        _name = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected UnitRef(ASTNodeInfo info) {
        super(info);
        _name = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "UnitRef", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            boolean temp_parenthesized = isParenthesized();
            if (w.visitNodeField("parenthesized", temp_parenthesized)) {
                w.visitBoolean(temp_parenthesized);
                w.endNodeField("parenthesized", temp_parenthesized);
            }
            Id temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            w.endNode(this, "UnitRef", 3);
        }
    }

}
