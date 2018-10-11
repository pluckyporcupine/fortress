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
 * Class FnDecl, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class FnDecl extends Decl implements Applicable, Generic {
    private final FnHeader _header;
    private final IdOrOp _unambiguousName;
    private final Option<Expr> _body;
    private final Option<IdOrOp> _implementsUnambiguousName;

    /**
     * Constructs a FnDecl.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public FnDecl(ASTNodeInfo in_info, FnHeader in_header, IdOrOp in_unambiguousName, Option<Expr> in_body, Option<IdOrOp> in_implementsUnambiguousName) {
        super(in_info);
        if (in_header == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'header' to the FnDecl constructor was null");
        }
        _header = in_header;
        if (in_unambiguousName == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'unambiguousName' to the FnDecl constructor was null");
        }
        _unambiguousName = in_unambiguousName;
        if (in_body == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'body' to the FnDecl constructor was null");
        }
        _body = in_body;
        if (in_implementsUnambiguousName == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'implementsUnambiguousName' to the FnDecl constructor was null");
        }
        _implementsUnambiguousName = in_implementsUnambiguousName;
    }

    final public FnHeader getHeader() { return _header; }
    final public IdOrOp getUnambiguousName() { return _unambiguousName; }
    final public Option<Expr> getBody() { return _body; }
    final public Option<IdOrOp> getImplementsUnambiguousName() { return _implementsUnambiguousName; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forFnDecl(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forFnDecl(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forFnDecl(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forFnDecl(this);
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
            FnDecl casted = (FnDecl) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            FnHeader temp_header = getHeader();
            FnHeader casted_header = casted.getHeader();
            if (!(temp_header == casted_header || temp_header.equals(casted_header))) return false;
            IdOrOp temp_unambiguousName = getUnambiguousName();
            IdOrOp casted_unambiguousName = casted.getUnambiguousName();
            if (!(temp_unambiguousName == casted_unambiguousName || temp_unambiguousName.equals(casted_unambiguousName))) return false;
            Option<Expr> temp_body = getBody();
            Option<Expr> casted_body = casted.getBody();
            if (!(temp_body == casted_body || temp_body.equals(casted_body))) return false;
            Option<IdOrOp> temp_implementsUnambiguousName = getImplementsUnambiguousName();
            Option<IdOrOp> casted_implementsUnambiguousName = casted.getImplementsUnambiguousName();
            if (!(temp_implementsUnambiguousName == casted_implementsUnambiguousName || temp_implementsUnambiguousName.equals(casted_implementsUnambiguousName))) return false;
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
        FnHeader temp_header = getHeader();
        code ^= temp_header.hashCode();
        IdOrOp temp_unambiguousName = getUnambiguousName();
        code ^= temp_unambiguousName.hashCode();
        Option<Expr> temp_body = getBody();
        code ^= temp_body.hashCode();
        Option<IdOrOp> temp_implementsUnambiguousName = getImplementsUnambiguousName();
        code ^= temp_implementsUnambiguousName.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected FnDecl() {
        _header = null;
        _unambiguousName = null;
        _body = null;
        _implementsUnambiguousName = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected FnDecl(ASTNodeInfo info) {
        super(info);
        _header = null;
        _unambiguousName = null;
        _body = null;
        _implementsUnambiguousName = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "FnDecl", 5)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            FnHeader temp_header = getHeader();
            if (w.visitNodeField("header", temp_header)) {
                temp_header.walk(w);
                w.endNodeField("header", temp_header);
            }
            IdOrOp temp_unambiguousName = getUnambiguousName();
            if (w.visitNodeField("unambiguousName", temp_unambiguousName)) {
                temp_unambiguousName.walk(w);
                w.endNodeField("unambiguousName", temp_unambiguousName);
            }
            Option<Expr> temp_body = getBody();
            if (w.visitNodeField("body", temp_body)) {
                if (temp_body.isNone()) {
                    w.visitEmptyOption(temp_body);
                }
                else if (w.visitNonEmptyOption(temp_body)) {
                    Expr elt_temp_body = temp_body.unwrap();
                    if (elt_temp_body == null) w.visitNull();
                    else {
                        elt_temp_body.walk(w);
                    }
                    w.endNonEmptyOption(temp_body);
                }
                w.endNodeField("body", temp_body);
            }
            Option<IdOrOp> temp_implementsUnambiguousName = getImplementsUnambiguousName();
            if (w.visitNodeField("implementsUnambiguousName", temp_implementsUnambiguousName)) {
                if (temp_implementsUnambiguousName.isNone()) {
                    w.visitEmptyOption(temp_implementsUnambiguousName);
                }
                else if (w.visitNonEmptyOption(temp_implementsUnambiguousName)) {
                    IdOrOp elt_temp_implementsUnambiguousName = temp_implementsUnambiguousName.unwrap();
                    if (elt_temp_implementsUnambiguousName == null) w.visitNull();
                    else {
                        elt_temp_implementsUnambiguousName.walk(w);
                    }
                    w.endNonEmptyOption(temp_implementsUnambiguousName);
                }
                w.endNodeField("implementsUnambiguousName", temp_implementsUnambiguousName);
            }
            w.endNode(this, "FnDecl", 5);
        }
    }

}
