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
 * Class ItemSymbol, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ItemSymbol extends SyntaxSymbol {
    private final String _item;

    /**
     * Constructs a ItemSymbol.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ItemSymbol(ASTNodeInfo in_info, String in_item) {
        super(in_info);
        if (in_item == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'item' to the ItemSymbol constructor was null");
        }
        _item = in_item.intern();
    }

    final public String getItem() { return _item; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forItemSymbol(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forItemSymbol(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forItemSymbol(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forItemSymbol(this);
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
            ItemSymbol casted = (ItemSymbol) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            String temp_item = getItem();
            String casted_item = casted.getItem();
            if (!(temp_item == casted_item)) return false;
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
        String temp_item = getItem();
        code ^= temp_item.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ItemSymbol() {
        _item = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ItemSymbol(ASTNodeInfo info) {
        super(info);
        _item = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ItemSymbol", 2)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            String temp_item = getItem();
            if (w.visitNodeField("item", temp_item)) {
                w.visitString(temp_item);
                w.endNodeField("item", temp_item);
            }
            w.endNode(this, "ItemSymbol", 2);
        }
    }

}
