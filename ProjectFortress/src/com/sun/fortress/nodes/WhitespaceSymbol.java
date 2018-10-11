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
 * Class WhitespaceSymbol, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class WhitespaceSymbol extends SpecialSymbol {
    private final String _s;

    /**
     * Constructs a WhitespaceSymbol.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public WhitespaceSymbol(ASTNodeInfo in_info, String in_s) {
        super(in_info);
        if (in_s == null) {
            throw new java.lang.IllegalArgumentException("Parameter 's' to the WhitespaceSymbol constructor was null");
        }
        _s = in_s.intern();
    }

    final public String getS() { return _s; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forWhitespaceSymbol(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forWhitespaceSymbol(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forWhitespaceSymbol(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forWhitespaceSymbol(this);
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
            WhitespaceSymbol casted = (WhitespaceSymbol) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            String temp_s = getS();
            String casted_s = casted.getS();
            if (!(temp_s == casted_s)) return false;
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
        String temp_s = getS();
        code ^= temp_s.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected WhitespaceSymbol() {
        _s = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected WhitespaceSymbol(ASTNodeInfo info) {
        super(info);
        _s = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "WhitespaceSymbol", 2)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            String temp_s = getS();
            if (w.visitNodeField("s", temp_s)) {
                w.visitString(temp_s);
                w.endNodeField("s", temp_s);
            }
            w.endNode(this, "WhitespaceSymbol", 2);
        }
    }

}
