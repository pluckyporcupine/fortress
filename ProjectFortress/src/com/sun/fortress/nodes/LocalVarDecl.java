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
 * Class LocalVarDecl, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class LocalVarDecl extends LetExpr {
    private final List<LValue> _lhs;
    private final Option<Expr> _rhs;

    /**
     * Constructs a LocalVarDecl.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public LocalVarDecl(ExprInfo in_info, Block in_body, List<LValue> in_lhs, Option<Expr> in_rhs) {
        super(in_info, in_body);
        if (in_lhs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'lhs' to the LocalVarDecl constructor was null");
        }
        _lhs = in_lhs;
        if (in_rhs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'rhs' to the LocalVarDecl constructor was null");
        }
        _rhs = in_rhs;
    }

    final public List<LValue> getLhs() { return _lhs; }
    final public Option<Expr> getRhs() { return _rhs; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forLocalVarDecl(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forLocalVarDecl(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forLocalVarDecl(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forLocalVarDecl(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forLocalVarDecl(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forLocalVarDecl(this);
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
            LocalVarDecl casted = (LocalVarDecl) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Block temp_body = getBody();
            Block casted_body = casted.getBody();
            if (!(temp_body == casted_body || temp_body.equals(casted_body))) return false;
            List<LValue> temp_lhs = getLhs();
            List<LValue> casted_lhs = casted.getLhs();
            if (!(temp_lhs == casted_lhs || temp_lhs.equals(casted_lhs))) return false;
            Option<Expr> temp_rhs = getRhs();
            Option<Expr> casted_rhs = casted.getRhs();
            if (!(temp_rhs == casted_rhs || temp_rhs.equals(casted_rhs))) return false;
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
        List<LValue> temp_lhs = getLhs();
        code ^= temp_lhs.hashCode();
        Option<Expr> temp_rhs = getRhs();
        code ^= temp_rhs.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected LocalVarDecl() {
        _lhs = null;
        _rhs = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected LocalVarDecl(ExprInfo info) {
        super(info);
        _lhs = null;
        _rhs = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "LocalVarDecl", 4)) {
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
            List<LValue> temp_lhs = getLhs();
            if (w.visitNodeField("lhs", temp_lhs)) {
                if (w.visitIterated(temp_lhs)) {
                    int i_temp_lhs = 0;
                    for (LValue elt_temp_lhs : temp_lhs) {
                        if (w.visitIteratedElement(i_temp_lhs, elt_temp_lhs)) {
                            if (elt_temp_lhs == null) w.visitNull();
                            else {
                                elt_temp_lhs.walk(w);
                            }
                        }
                        i_temp_lhs++;
                    }
                    w.endIterated(temp_lhs, i_temp_lhs);
                }
                w.endNodeField("lhs", temp_lhs);
            }
            Option<Expr> temp_rhs = getRhs();
            if (w.visitNodeField("rhs", temp_rhs)) {
                if (temp_rhs.isNone()) {
                    w.visitEmptyOption(temp_rhs);
                }
                else if (w.visitNonEmptyOption(temp_rhs)) {
                    Expr elt_temp_rhs = temp_rhs.unwrap();
                    if (elt_temp_rhs == null) w.visitNull();
                    else {
                        elt_temp_rhs.walk(w);
                    }
                    w.endNonEmptyOption(temp_rhs);
                }
                w.endNodeField("rhs", temp_rhs);
            }
            w.endNode(this, "LocalVarDecl", 4);
        }
    }

}
