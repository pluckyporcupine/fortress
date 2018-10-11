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
 * Class _RewriteObjectExprDecl, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _RewriteObjectExprDecl extends Decl {
    private final List<_RewriteObjectExpr> _objectExprs;

    /**
     * Constructs a _RewriteObjectExprDecl.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _RewriteObjectExprDecl(ASTNodeInfo in_info, List<_RewriteObjectExpr> in_objectExprs) {
        super(in_info);
        if (in_objectExprs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'objectExprs' to the _RewriteObjectExprDecl constructor was null");
        }
        _objectExprs = in_objectExprs;
    }

    final public List<_RewriteObjectExpr> getObjectExprs() { return _objectExprs; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_RewriteObjectExprDecl(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_RewriteObjectExprDecl(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_RewriteObjectExprDecl(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_RewriteObjectExprDecl(this);
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
            _RewriteObjectExprDecl casted = (_RewriteObjectExprDecl) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<_RewriteObjectExpr> temp_objectExprs = getObjectExprs();
            List<_RewriteObjectExpr> casted_objectExprs = casted.getObjectExprs();
            if (!(temp_objectExprs == casted_objectExprs || temp_objectExprs.equals(casted_objectExprs))) return false;
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
        List<_RewriteObjectExpr> temp_objectExprs = getObjectExprs();
        code ^= temp_objectExprs.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected _RewriteObjectExprDecl() {
        _objectExprs = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _RewriteObjectExprDecl(ASTNodeInfo info) {
        super(info);
        _objectExprs = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_RewriteObjectExprDecl", 2)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<_RewriteObjectExpr> temp_objectExprs = getObjectExprs();
            if (w.visitNodeField("objectExprs", temp_objectExprs)) {
                if (w.visitIterated(temp_objectExprs)) {
                    int i_temp_objectExprs = 0;
                    for (_RewriteObjectExpr elt_temp_objectExprs : temp_objectExprs) {
                        if (w.visitIteratedElement(i_temp_objectExprs, elt_temp_objectExprs)) {
                            if (elt_temp_objectExprs == null) w.visitNull();
                            else {
                                elt_temp_objectExprs.walk(w);
                            }
                        }
                        i_temp_objectExprs++;
                    }
                    w.endIterated(temp_objectExprs, i_temp_objectExprs);
                }
                w.endNodeField("objectExprs", temp_objectExprs);
            }
            w.endNode(this, "_RewriteObjectExprDecl", 2);
        }
    }

}
