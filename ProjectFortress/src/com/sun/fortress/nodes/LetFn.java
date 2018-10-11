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
 * Class LetFn, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class LetFn extends LetExpr {
    private final List<FnDecl> _fns;

    /**
     * Constructs a LetFn.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public LetFn(ExprInfo in_info, Block in_body, List<FnDecl> in_fns) {
        super(in_info, in_body);
        if (in_fns == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'fns' to the LetFn constructor was null");
        }
        _fns = in_fns;
    }

    final public List<FnDecl> getFns() { return _fns; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forLetFn(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forLetFn(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forLetFn(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forLetFn(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forLetFn(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forLetFn(this);
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
            LetFn casted = (LetFn) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Block temp_body = getBody();
            Block casted_body = casted.getBody();
            if (!(temp_body == casted_body || temp_body.equals(casted_body))) return false;
            List<FnDecl> temp_fns = getFns();
            List<FnDecl> casted_fns = casted.getFns();
            if (!(temp_fns == casted_fns || temp_fns.equals(casted_fns))) return false;
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
        Block temp_body = getBody();
        code ^= temp_body.hashCode();
        List<FnDecl> temp_fns = getFns();
        code ^= temp_fns.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected LetFn() {
        _fns = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected LetFn(ExprInfo info) {
        super(info);
        _fns = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "LetFn", 3)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Block temp_body = getBody();
            if (w.visitNodeField("body", temp_body)) {
                temp_body.walk(w);
                w.endNodeField("body", temp_body);
            }
            List<FnDecl> temp_fns = getFns();
            if (w.visitNodeField("fns", temp_fns)) {
                if (w.visitIterated(temp_fns)) {
                    int i_temp_fns = 0;
                    for (FnDecl elt_temp_fns : temp_fns) {
                        if (w.visitIteratedElement(i_temp_fns, elt_temp_fns)) {
                            if (elt_temp_fns == null) w.visitNull();
                            else {
                                elt_temp_fns.walk(w);
                            }
                        }
                        i_temp_fns++;
                    }
                    w.endIterated(temp_fns, i_temp_fns);
                }
                w.endNodeField("fns", temp_fns);
            }
            w.endNode(this, "LetFn", 3);
        }
    }

}
