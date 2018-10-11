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
 * Class ChainExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ChainExpr extends Primary {
    private final Expr _first;
    private final List<Link> _links;

    /**
     * Constructs a ChainExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ChainExpr(ExprInfo in_info, Expr in_first, List<Link> in_links) {
        super(in_info);
        if (in_first == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'first' to the ChainExpr constructor was null");
        }
        _first = in_first;
        if (in_links == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'links' to the ChainExpr constructor was null");
        }
        _links = in_links;
    }

    final public Expr getFirst() { return _first; }
    final public List<Link> getLinks() { return _links; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forChainExpr(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forChainExpr(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forChainExpr(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forChainExpr(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forChainExpr(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forChainExpr(this);
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
            ChainExpr casted = (ChainExpr) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Expr temp_first = getFirst();
            Expr casted_first = casted.getFirst();
            if (!(temp_first == casted_first || temp_first.equals(casted_first))) return false;
            List<Link> temp_links = getLinks();
            List<Link> casted_links = casted.getLinks();
            if (!(temp_links == casted_links || temp_links.equals(casted_links))) return false;
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
        Expr temp_first = getFirst();
        code ^= temp_first.hashCode();
        List<Link> temp_links = getLinks();
        code ^= temp_links.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ChainExpr() {
        _first = null;
        _links = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ChainExpr(ExprInfo info) {
        super(info);
        _first = null;
        _links = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ChainExpr", 3)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Expr temp_first = getFirst();
            if (w.visitNodeField("first", temp_first)) {
                temp_first.walk(w);
                w.endNodeField("first", temp_first);
            }
            List<Link> temp_links = getLinks();
            if (w.visitNodeField("links", temp_links)) {
                if (w.visitIterated(temp_links)) {
                    int i_temp_links = 0;
                    for (Link elt_temp_links : temp_links) {
                        if (w.visitIteratedElement(i_temp_links, elt_temp_links)) {
                            if (elt_temp_links == null) w.visitNull();
                            else {
                                elt_temp_links.walk(w);
                            }
                        }
                        i_temp_links++;
                    }
                    w.endIterated(temp_links, i_temp_links);
                }
                w.endNodeField("links", temp_links);
            }
            w.endNode(this, "ChainExpr", 3);
        }
    }

}
