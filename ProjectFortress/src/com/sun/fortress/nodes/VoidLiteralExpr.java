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
 * Class VoidLiteralExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class VoidLiteralExpr extends LiteralExpr {

    /**
     * Constructs a VoidLiteralExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public VoidLiteralExpr(ExprInfo in_info, String in_text) {
        super(in_info, in_text);
    }


    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forVoidLiteralExpr(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forVoidLiteralExpr(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forVoidLiteralExpr(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forVoidLiteralExpr(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forVoidLiteralExpr(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forVoidLiteralExpr(this);
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
            VoidLiteralExpr casted = (VoidLiteralExpr) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            String temp_text = getText();
            String casted_text = casted.getText();
            if (!(temp_text == casted_text)) return false;
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
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected VoidLiteralExpr() {
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected VoidLiteralExpr(ExprInfo info) {
        super(info);
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "VoidLiteralExpr", 2)) {
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
            w.endNode(this, "VoidLiteralExpr", 2);
        }
    }

}
