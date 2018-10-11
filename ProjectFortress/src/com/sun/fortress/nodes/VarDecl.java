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
 * Class VarDecl, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class VarDecl extends Decl {
    private final List<LValue> _lhs;
    private final Option<Expr> _init;

    /**
     * Constructs a VarDecl.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public VarDecl(ASTNodeInfo in_info, List<LValue> in_lhs, Option<Expr> in_init) {
        super(in_info);
        if (in_lhs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'lhs' to the VarDecl constructor was null");
        }
        _lhs = in_lhs;
        if (in_init == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'init' to the VarDecl constructor was null");
        }
        _init = in_init;
    }

    final public List<LValue> getLhs() { return _lhs; }
    final public Option<Expr> getInit() { return _init; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forVarDecl(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forVarDecl(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forVarDecl(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forVarDecl(this);
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
            VarDecl casted = (VarDecl) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<LValue> temp_lhs = getLhs();
            List<LValue> casted_lhs = casted.getLhs();
            if (!(temp_lhs == casted_lhs || temp_lhs.equals(casted_lhs))) return false;
            Option<Expr> temp_init = getInit();
            Option<Expr> casted_init = casted.getInit();
            if (!(temp_init == casted_init || temp_init.equals(casted_init))) return false;
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
        List<LValue> temp_lhs = getLhs();
        code ^= temp_lhs.hashCode();
        Option<Expr> temp_init = getInit();
        code ^= temp_init.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected VarDecl() {
        _lhs = null;
        _init = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected VarDecl(ASTNodeInfo info) {
        super(info);
        _lhs = null;
        _init = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "VarDecl", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
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
            Option<Expr> temp_init = getInit();
            if (w.visitNodeField("init", temp_init)) {
                if (temp_init.isNone()) {
                    w.visitEmptyOption(temp_init);
                }
                else if (w.visitNonEmptyOption(temp_init)) {
                    Expr elt_temp_init = temp_init.unwrap();
                    if (elt_temp_init == null) w.visitNull();
                    else {
                        elt_temp_init.walk(w);
                    }
                    w.endNonEmptyOption(temp_init);
                }
                w.endNodeField("init", temp_init);
            }
            w.endNode(this, "VarDecl", 3);
        }
    }

}
