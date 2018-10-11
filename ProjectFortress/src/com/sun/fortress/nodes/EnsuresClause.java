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
 * Class EnsuresClause, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class EnsuresClause extends AbstractNode {
    private final Expr _post;
    private final Option<Expr> _pre;

    /**
     * Constructs a EnsuresClause.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public EnsuresClause(ASTNodeInfo in_info, Expr in_post, Option<Expr> in_pre) {
        super(in_info);
        if (in_post == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'post' to the EnsuresClause constructor was null");
        }
        _post = in_post;
        if (in_pre == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'pre' to the EnsuresClause constructor was null");
        }
        _pre = in_pre;
    }

    final public Expr getPost() { return _post; }
    final public Option<Expr> getPre() { return _pre; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forEnsuresClause(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forEnsuresClause(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forEnsuresClause(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forEnsuresClause(this);
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
            EnsuresClause casted = (EnsuresClause) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Expr temp_post = getPost();
            Expr casted_post = casted.getPost();
            if (!(temp_post == casted_post || temp_post.equals(casted_post))) return false;
            Option<Expr> temp_pre = getPre();
            Option<Expr> casted_pre = casted.getPre();
            if (!(temp_pre == casted_pre || temp_pre.equals(casted_pre))) return false;
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
        Expr temp_post = getPost();
        code ^= temp_post.hashCode();
        Option<Expr> temp_pre = getPre();
        code ^= temp_pre.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected EnsuresClause() {
        _post = null;
        _pre = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected EnsuresClause(ASTNodeInfo info) {
        super(info);
        _post = null;
        _pre = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "EnsuresClause", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Expr temp_post = getPost();
            if (w.visitNodeField("post", temp_post)) {
                temp_post.walk(w);
                w.endNodeField("post", temp_post);
            }
            Option<Expr> temp_pre = getPre();
            if (w.visitNodeField("pre", temp_pre)) {
                if (temp_pre.isNone()) {
                    w.visitEmptyOption(temp_pre);
                }
                else if (w.visitNonEmptyOption(temp_pre)) {
                    Expr elt_temp_pre = temp_pre.unwrap();
                    if (elt_temp_pre == null) w.visitNull();
                    else {
                        elt_temp_pre.walk(w);
                    }
                    w.endNonEmptyOption(temp_pre);
                }
                w.endNodeField("pre", temp_pre);
            }
            w.endNode(this, "EnsuresClause", 3);
        }
    }

}
