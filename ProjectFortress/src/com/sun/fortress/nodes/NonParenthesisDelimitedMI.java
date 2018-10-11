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
 * Class NonParenthesisDelimitedMI, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class NonParenthesisDelimitedMI extends ExprMI {

    /**
     * Constructs a NonParenthesisDelimitedMI.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public NonParenthesisDelimitedMI(ASTNodeInfo in_info, Expr in_expr) {
        super(in_info, in_expr);
    }


    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forNonParenthesisDelimitedMI(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forNonParenthesisDelimitedMI(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forNonParenthesisDelimitedMI(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forNonParenthesisDelimitedMI(this);
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
            NonParenthesisDelimitedMI casted = (NonParenthesisDelimitedMI) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Expr temp_expr = getExpr();
            Expr casted_expr = casted.getExpr();
            if (!(temp_expr == casted_expr || temp_expr.equals(casted_expr))) return false;
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
        Expr temp_expr = getExpr();
        code ^= temp_expr.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected NonParenthesisDelimitedMI() {
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected NonParenthesisDelimitedMI(ASTNodeInfo info) {
        super(info);
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "NonParenthesisDelimitedMI", 2)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Expr temp_expr = getExpr();
            if (w.visitNodeField("expr", temp_expr)) {
                temp_expr.walk(w);
                w.endNodeField("expr", temp_expr);
            }
            w.endNode(this, "NonParenthesisDelimitedMI", 2);
        }
    }

}
