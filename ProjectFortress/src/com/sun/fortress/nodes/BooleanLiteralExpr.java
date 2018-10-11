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
 * Class BooleanLiteralExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class BooleanLiteralExpr extends LiteralExpr {
    private final int _booleanVal;

    /**
     * Constructs a BooleanLiteralExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public BooleanLiteralExpr(ExprInfo in_info, String in_text, int in_booleanVal) {
        super(in_info, in_text);
        _booleanVal = in_booleanVal;
    }

    final public int getBooleanVal() { return _booleanVal; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forBooleanLiteralExpr(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forBooleanLiteralExpr(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forBooleanLiteralExpr(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forBooleanLiteralExpr(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forBooleanLiteralExpr(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forBooleanLiteralExpr(this);
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
            BooleanLiteralExpr casted = (BooleanLiteralExpr) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            String temp_text = getText();
            String casted_text = casted.getText();
            if (!(temp_text == casted_text)) return false;
            int temp_booleanVal = getBooleanVal();
            int casted_booleanVal = casted.getBooleanVal();
            if (!(temp_booleanVal == casted_booleanVal)) return false;
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
        int temp_booleanVal = getBooleanVal();
        code ^= temp_booleanVal;
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected BooleanLiteralExpr() {
        _booleanVal = 0;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected BooleanLiteralExpr(ExprInfo info) {
        super(info);
        _booleanVal = 0;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "BooleanLiteralExpr", 3)) {
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
            int temp_booleanVal = getBooleanVal();
            if (w.visitNodeField("booleanVal", temp_booleanVal)) {
                w.visitInt(temp_booleanVal);
                w.endNodeField("booleanVal", temp_booleanVal);
            }
            w.endNode(this, "BooleanLiteralExpr", 3);
        }
    }

}
