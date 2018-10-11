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
 * Class BoolBase, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class BoolBase extends BoolExpr {
    private final boolean _boolVal;

    /**
     * Constructs a BoolBase.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public BoolBase(ASTNodeInfo in_info, boolean in_parenthesized, boolean in_boolVal) {
        super(in_info, in_parenthesized);
        _boolVal = in_boolVal;
    }

    final public boolean isBoolVal() { return _boolVal; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forBoolBase(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forBoolBase(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forBoolBase(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forBoolBase(this);
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
            BoolBase casted = (BoolBase) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            boolean temp_boolVal = isBoolVal();
            boolean casted_boolVal = casted.isBoolVal();
            if (!(temp_boolVal == casted_boolVal)) return false;
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
        boolean temp_boolVal = isBoolVal();
        code ^= temp_boolVal ? 1231 : 1237;
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected BoolBase() {
        _boolVal = false;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected BoolBase(ASTNodeInfo info) {
        super(info);
        _boolVal = false;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "BoolBase", 3)) {
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
            boolean temp_boolVal = isBoolVal();
            if (w.visitNodeField("boolVal", temp_boolVal)) {
                w.visitBoolean(temp_boolVal);
                w.endNodeField("boolVal", temp_boolVal);
            }
            w.endNode(this, "BoolBase", 3);
        }
    }

}
