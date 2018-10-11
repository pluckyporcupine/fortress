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
 * Class PrefixedSymbol, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class PrefixedSymbol extends SyntaxSymbol {
    private final Id _id;
    private final SyntaxSymbol _symbol;

    /**
     * Constructs a PrefixedSymbol.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public PrefixedSymbol(ASTNodeInfo in_info, Id in_id, SyntaxSymbol in_symbol) {
        super(in_info);
        if (in_id == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'id' to the PrefixedSymbol constructor was null");
        }
        _id = in_id;
        if (in_symbol == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'symbol' to the PrefixedSymbol constructor was null");
        }
        _symbol = in_symbol;
    }

    final public Id getId() { return _id; }
    final public SyntaxSymbol getSymbol() { return _symbol; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forPrefixedSymbol(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forPrefixedSymbol(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forPrefixedSymbol(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forPrefixedSymbol(this);
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
            PrefixedSymbol casted = (PrefixedSymbol) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_id = getId();
            Id casted_id = casted.getId();
            if (!(temp_id == casted_id || temp_id.equals(casted_id))) return false;
            SyntaxSymbol temp_symbol = getSymbol();
            SyntaxSymbol casted_symbol = casted.getSymbol();
            if (!(temp_symbol == casted_symbol || temp_symbol.equals(casted_symbol))) return false;
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
        Id temp_id = getId();
        code ^= temp_id.hashCode();
        SyntaxSymbol temp_symbol = getSymbol();
        code ^= temp_symbol.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected PrefixedSymbol() {
        _id = null;
        _symbol = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected PrefixedSymbol(ASTNodeInfo info) {
        super(info);
        _id = null;
        _symbol = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "PrefixedSymbol", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Id temp_id = getId();
            if (w.visitNodeField("id", temp_id)) {
                temp_id.walk(w);
                w.endNodeField("id", temp_id);
            }
            SyntaxSymbol temp_symbol = getSymbol();
            if (w.visitNodeField("symbol", temp_symbol)) {
                temp_symbol.walk(w);
                w.endNodeField("symbol", temp_symbol);
            }
            w.endNode(this, "PrefixedSymbol", 3);
        }
    }

}
