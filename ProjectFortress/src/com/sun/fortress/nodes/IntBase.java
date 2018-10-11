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
 * Class IntBase, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class IntBase extends IntExpr {
    private final IntLiteralExpr _intVal;

    /**
     * Constructs a IntBase.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public IntBase(ASTNodeInfo in_info, boolean in_parenthesized, IntLiteralExpr in_intVal) {
        super(in_info, in_parenthesized);
        if (in_intVal == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'intVal' to the IntBase constructor was null");
        }
        _intVal = in_intVal;
    }

    final public IntLiteralExpr getIntVal() { return _intVal; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forIntBase(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forIntBase(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forIntBase(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forIntBase(this);
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
            IntBase casted = (IntBase) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            IntLiteralExpr temp_intVal = getIntVal();
            IntLiteralExpr casted_intVal = casted.getIntVal();
            if (!(temp_intVal == casted_intVal || temp_intVal.equals(casted_intVal))) return false;
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
        IntLiteralExpr temp_intVal = getIntVal();
        code ^= temp_intVal.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected IntBase() {
        _intVal = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected IntBase(ASTNodeInfo info) {
        super(info);
        _intVal = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "IntBase", 3)) {
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
            IntLiteralExpr temp_intVal = getIntVal();
            if (w.visitNodeField("intVal", temp_intVal)) {
                temp_intVal.walk(w);
                w.endNodeField("intVal", temp_intVal);
            }
            w.endNode(this, "IntBase", 3);
        }
    }

}
