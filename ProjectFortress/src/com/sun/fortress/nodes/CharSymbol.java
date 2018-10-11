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
 * Class CharSymbol, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class CharSymbol extends CharacterSymbol {
    private final String _string;

    /**
     * Constructs a CharSymbol.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public CharSymbol(ASTNodeInfo in_info, String in_string) {
        super(in_info);
        if (in_string == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'string' to the CharSymbol constructor was null");
        }
        _string = in_string.intern();
    }

    final public String getString() { return _string; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forCharSymbol(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forCharSymbol(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forCharSymbol(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forCharSymbol(this);
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
            CharSymbol casted = (CharSymbol) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            String temp_string = getString();
            String casted_string = casted.getString();
            if (!(temp_string == casted_string)) return false;
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
        String temp_string = getString();
        code ^= temp_string.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected CharSymbol() {
        _string = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected CharSymbol(ASTNodeInfo info) {
        super(info);
        _string = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "CharSymbol", 2)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            String temp_string = getString();
            if (w.visitNodeField("string", temp_string)) {
                w.visitString(temp_string);
                w.endNodeField("string", temp_string);
            }
            w.endNode(this, "CharSymbol", 2);
        }
    }

}
