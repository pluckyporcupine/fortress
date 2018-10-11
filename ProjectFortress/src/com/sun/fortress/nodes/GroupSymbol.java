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
 * Class GroupSymbol, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class GroupSymbol extends SyntaxSymbol {
    private final List<SyntaxSymbol> _symbols;

    /**
     * Constructs a GroupSymbol.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public GroupSymbol(ASTNodeInfo in_info, List<SyntaxSymbol> in_symbols) {
        super(in_info);
        if (in_symbols == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'symbols' to the GroupSymbol constructor was null");
        }
        _symbols = in_symbols;
    }

    final public List<SyntaxSymbol> getSymbols() { return _symbols; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forGroupSymbol(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forGroupSymbol(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forGroupSymbol(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forGroupSymbol(this);
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
            GroupSymbol casted = (GroupSymbol) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<SyntaxSymbol> temp_symbols = getSymbols();
            List<SyntaxSymbol> casted_symbols = casted.getSymbols();
            if (!(temp_symbols == casted_symbols || temp_symbols.equals(casted_symbols))) return false;
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
        List<SyntaxSymbol> temp_symbols = getSymbols();
        code ^= temp_symbols.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected GroupSymbol() {
        _symbols = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected GroupSymbol(ASTNodeInfo info) {
        super(info);
        _symbols = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "GroupSymbol", 2)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<SyntaxSymbol> temp_symbols = getSymbols();
            if (w.visitNodeField("symbols", temp_symbols)) {
                if (w.visitIterated(temp_symbols)) {
                    int i_temp_symbols = 0;
                    for (SyntaxSymbol elt_temp_symbols : temp_symbols) {
                        if (w.visitIteratedElement(i_temp_symbols, elt_temp_symbols)) {
                            if (elt_temp_symbols == null) w.visitNull();
                            else {
                                elt_temp_symbols.walk(w);
                            }
                        }
                        i_temp_symbols++;
                    }
                    w.endIterated(temp_symbols, i_temp_symbols);
                }
                w.endNodeField("symbols", temp_symbols);
            }
            w.endNode(this, "GroupSymbol", 2);
        }
    }

}
