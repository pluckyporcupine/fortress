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
 * Class FnExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class FnExpr extends Expr implements Applicable {
    private final FnHeader _header;
    private final Expr _body;

    /**
     * Constructs a FnExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public FnExpr(ExprInfo in_info, FnHeader in_header, Expr in_body) {
        super(in_info);
        if (in_header == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'header' to the FnExpr constructor was null");
        }
        _header = in_header;
        if (in_body == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'body' to the FnExpr constructor was null");
        }
        _body = in_body;
    }

    final public FnHeader getHeader() { return _header; }
    final public Expr getBody() { return _body; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forFnExpr(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forFnExpr(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forFnExpr(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forFnExpr(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forFnExpr(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forFnExpr(this);
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
            FnExpr casted = (FnExpr) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            FnHeader temp_header = getHeader();
            FnHeader casted_header = casted.getHeader();
            if (!(temp_header == casted_header || temp_header.equals(casted_header))) return false;
            Expr temp_body = getBody();
            Expr casted_body = casted.getBody();
            if (!(temp_body == casted_body || temp_body.equals(casted_body))) return false;
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
        FnHeader temp_header = getHeader();
        code ^= temp_header.hashCode();
        Expr temp_body = getBody();
        code ^= temp_body.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected FnExpr() {
        _header = null;
        _body = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected FnExpr(ExprInfo info) {
        super(info);
        _header = null;
        _body = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "FnExpr", 3)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            FnHeader temp_header = getHeader();
            if (w.visitNodeField("header", temp_header)) {
                temp_header.walk(w);
                w.endNodeField("header", temp_header);
            }
            Expr temp_body = getBody();
            if (w.visitNodeField("body", temp_body)) {
                temp_body.walk(w);
                w.endNodeField("body", temp_body);
            }
            w.endNode(this, "FnExpr", 3);
        }
    }

}
