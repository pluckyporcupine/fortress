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
 * Class CharacterInterval, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class CharacterInterval extends CharacterSymbol {
    private final String _beginSymbol;
    private final String _endSymbol;

    /**
     * Constructs a CharacterInterval.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public CharacterInterval(ASTNodeInfo in_info, String in_beginSymbol, String in_endSymbol) {
        super(in_info);
        if (in_beginSymbol == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'beginSymbol' to the CharacterInterval constructor was null");
        }
        _beginSymbol = in_beginSymbol.intern();
        if (in_endSymbol == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'endSymbol' to the CharacterInterval constructor was null");
        }
        _endSymbol = in_endSymbol.intern();
    }

    final public String getBeginSymbol() { return _beginSymbol; }
    final public String getEndSymbol() { return _endSymbol; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forCharacterInterval(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forCharacterInterval(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forCharacterInterval(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forCharacterInterval(this);
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
            CharacterInterval casted = (CharacterInterval) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            String temp_beginSymbol = getBeginSymbol();
            String casted_beginSymbol = casted.getBeginSymbol();
            if (!(temp_beginSymbol == casted_beginSymbol)) return false;
            String temp_endSymbol = getEndSymbol();
            String casted_endSymbol = casted.getEndSymbol();
            if (!(temp_endSymbol == casted_endSymbol)) return false;
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
        String temp_beginSymbol = getBeginSymbol();
        code ^= temp_beginSymbol.hashCode();
        String temp_endSymbol = getEndSymbol();
        code ^= temp_endSymbol.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected CharacterInterval() {
        _beginSymbol = null;
        _endSymbol = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected CharacterInterval(ASTNodeInfo info) {
        super(info);
        _beginSymbol = null;
        _endSymbol = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "CharacterInterval", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            String temp_beginSymbol = getBeginSymbol();
            if (w.visitNodeField("beginSymbol", temp_beginSymbol)) {
                w.visitString(temp_beginSymbol);
                w.endNodeField("beginSymbol", temp_beginSymbol);
            }
            String temp_endSymbol = getEndSymbol();
            if (w.visitNodeField("endSymbol", temp_endSymbol)) {
                w.visitString(temp_endSymbol);
                w.endNodeField("endSymbol", temp_endSymbol);
            }
            w.endNode(this, "CharacterInterval", 3);
        }
    }

}
