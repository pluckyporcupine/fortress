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
 * Class TupleExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class TupleExpr extends Expr {
    private final List<Expr> _exprs;
    private final Option<Expr> _varargs;
    private final List<KeywordExpr> _keywords;
    private final boolean _inApp;

    /**
     * Constructs a TupleExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TupleExpr(ExprInfo in_info, List<Expr> in_exprs, Option<Expr> in_varargs, List<KeywordExpr> in_keywords, boolean in_inApp) {
        super(in_info);
        if (in_exprs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'exprs' to the TupleExpr constructor was null");
        }
        _exprs = in_exprs;
        if (in_varargs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'varargs' to the TupleExpr constructor was null");
        }
        _varargs = in_varargs;
        if (in_keywords == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'keywords' to the TupleExpr constructor was null");
        }
        _keywords = in_keywords;
        _inApp = in_inApp;
    }

    final public List<Expr> getExprs() { return _exprs; }
    final public Option<Expr> getVarargs() { return _varargs; }
    final public List<KeywordExpr> getKeywords() { return _keywords; }
    final public boolean isInApp() { return _inApp; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forTupleExpr(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTupleExpr(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTupleExpr(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forTupleExpr(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTupleExpr(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTupleExpr(this);
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
            TupleExpr casted = (TupleExpr) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<Expr> temp_exprs = getExprs();
            List<Expr> casted_exprs = casted.getExprs();
            if (!(temp_exprs == casted_exprs || temp_exprs.equals(casted_exprs))) return false;
            Option<Expr> temp_varargs = getVarargs();
            Option<Expr> casted_varargs = casted.getVarargs();
            if (!(temp_varargs == casted_varargs || temp_varargs.equals(casted_varargs))) return false;
            List<KeywordExpr> temp_keywords = getKeywords();
            List<KeywordExpr> casted_keywords = casted.getKeywords();
            if (!(temp_keywords == casted_keywords || temp_keywords.equals(casted_keywords))) return false;
            boolean temp_inApp = isInApp();
            boolean casted_inApp = casted.isInApp();
            if (!(temp_inApp == casted_inApp)) return false;
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
        List<Expr> temp_exprs = getExprs();
        code ^= temp_exprs.hashCode();
        Option<Expr> temp_varargs = getVarargs();
        code ^= temp_varargs.hashCode();
        List<KeywordExpr> temp_keywords = getKeywords();
        code ^= temp_keywords.hashCode();
        boolean temp_inApp = isInApp();
        code ^= temp_inApp ? 1231 : 1237;
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TupleExpr() {
        _exprs = null;
        _varargs = null;
        _keywords = null;
        _inApp = false;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TupleExpr(ExprInfo info) {
        super(info);
        _exprs = null;
        _varargs = null;
        _keywords = null;
        _inApp = false;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TupleExpr", 5)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<Expr> temp_exprs = getExprs();
            if (w.visitNodeField("exprs", temp_exprs)) {
                if (w.visitIterated(temp_exprs)) {
                    int i_temp_exprs = 0;
                    for (Expr elt_temp_exprs : temp_exprs) {
                        if (w.visitIteratedElement(i_temp_exprs, elt_temp_exprs)) {
                            if (elt_temp_exprs == null) w.visitNull();
                            else {
                                elt_temp_exprs.walk(w);
                            }
                        }
                        i_temp_exprs++;
                    }
                    w.endIterated(temp_exprs, i_temp_exprs);
                }
                w.endNodeField("exprs", temp_exprs);
            }
            Option<Expr> temp_varargs = getVarargs();
            if (w.visitNodeField("varargs", temp_varargs)) {
                if (temp_varargs.isNone()) {
                    w.visitEmptyOption(temp_varargs);
                }
                else if (w.visitNonEmptyOption(temp_varargs)) {
                    Expr elt_temp_varargs = temp_varargs.unwrap();
                    if (elt_temp_varargs == null) w.visitNull();
                    else {
                        elt_temp_varargs.walk(w);
                    }
                    w.endNonEmptyOption(temp_varargs);
                }
                w.endNodeField("varargs", temp_varargs);
            }
            List<KeywordExpr> temp_keywords = getKeywords();
            if (w.visitNodeField("keywords", temp_keywords)) {
                if (w.visitIterated(temp_keywords)) {
                    int i_temp_keywords = 0;
                    for (KeywordExpr elt_temp_keywords : temp_keywords) {
                        if (w.visitIteratedElement(i_temp_keywords, elt_temp_keywords)) {
                            if (elt_temp_keywords == null) w.visitNull();
                            else {
                                elt_temp_keywords.walk(w);
                            }
                        }
                        i_temp_keywords++;
                    }
                    w.endIterated(temp_keywords, i_temp_keywords);
                }
                w.endNodeField("keywords", temp_keywords);
            }
            boolean temp_inApp = isInApp();
            if (w.visitNodeField("inApp", temp_inApp)) {
                w.visitBoolean(temp_inApp);
                w.endNodeField("inApp", temp_inApp);
            }
            w.endNode(this, "TupleExpr", 5);
        }
    }

}
