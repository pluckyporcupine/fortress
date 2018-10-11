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
 * Class CharLiteralExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class CharLiteralExpr extends LiteralExpr {
    private final int _charVal;

    /**
     * Constructs a CharLiteralExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public CharLiteralExpr(ExprInfo in_info, String in_text, int in_charVal) {
        super(in_info, in_text);
        _charVal = in_charVal;
    }

    final public int getCharVal() { return _charVal; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forCharLiteralExpr(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forCharLiteralExpr(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forCharLiteralExpr(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forCharLiteralExpr(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forCharLiteralExpr(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forCharLiteralExpr(this);
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
            CharLiteralExpr casted = (CharLiteralExpr) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            String temp_text = getText();
            String casted_text = casted.getText();
            if (!(temp_text == casted_text)) return false;
            int temp_charVal = getCharVal();
            int casted_charVal = casted.getCharVal();
            if (!(temp_charVal == casted_charVal)) return false;
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
        ExprInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        String temp_text = getText();
        code ^= temp_text.hashCode();
        int temp_charVal = getCharVal();
        code ^= temp_charVal;
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected CharLiteralExpr() {
        _charVal = 0;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected CharLiteralExpr(ExprInfo info) {
        super(info);
        _charVal = 0;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "CharLiteralExpr", 3)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            String temp_text = getText();
            if (w.visitNodeField("text", temp_text)) {
                w.visitString(temp_text);
                w.endNodeField("text", temp_text);
            }
            int temp_charVal = getCharVal();
            if (w.visitNodeField("charVal", temp_charVal)) {
                w.visitInt(temp_charVal);
                w.endNodeField("charVal", temp_charVal);
            }
            w.endNode(this, "CharLiteralExpr", 3);
        }
    }

}
