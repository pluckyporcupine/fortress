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
 * Class CaseExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class CaseExpr extends Expr {
    private final Option<Expr> _param;
    private final Option<FunctionalRef> _compare;
    private final FunctionalRef _equalsOp;
    private final FunctionalRef _inOp;
    private final List<CaseClause> _clauses;
    private final Option<Block> _elseClause;

    /**
     * Constructs a CaseExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public CaseExpr(ExprInfo in_info, Option<Expr> in_param, Option<FunctionalRef> in_compare, FunctionalRef in_equalsOp, FunctionalRef in_inOp, List<CaseClause> in_clauses, Option<Block> in_elseClause) {
        super(in_info);
        if (in_param == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'param' to the CaseExpr constructor was null");
        }
        _param = in_param;
        if (in_compare == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'compare' to the CaseExpr constructor was null");
        }
        _compare = in_compare;
        if (in_equalsOp == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'equalsOp' to the CaseExpr constructor was null");
        }
        _equalsOp = in_equalsOp;
        if (in_inOp == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'inOp' to the CaseExpr constructor was null");
        }
        _inOp = in_inOp;
        if (in_clauses == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'clauses' to the CaseExpr constructor was null");
        }
        _clauses = in_clauses;
        if (in_elseClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'elseClause' to the CaseExpr constructor was null");
        }
        _elseClause = in_elseClause;
    }

    final public Option<Expr> getParam() { return _param; }
    final public Option<FunctionalRef> getCompare() { return _compare; }
    final public FunctionalRef getEqualsOp() { return _equalsOp; }
    final public FunctionalRef getInOp() { return _inOp; }
    final public List<CaseClause> getClauses() { return _clauses; }
    final public Option<Block> getElseClause() { return _elseClause; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forCaseExpr(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forCaseExpr(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forCaseExpr(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forCaseExpr(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forCaseExpr(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forCaseExpr(this);
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
            CaseExpr casted = (CaseExpr) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<Expr> temp_param = getParam();
            Option<Expr> casted_param = casted.getParam();
            if (!(temp_param == casted_param || temp_param.equals(casted_param))) return false;
            Option<FunctionalRef> temp_compare = getCompare();
            Option<FunctionalRef> casted_compare = casted.getCompare();
            if (!(temp_compare == casted_compare || temp_compare.equals(casted_compare))) return false;
            FunctionalRef temp_equalsOp = getEqualsOp();
            FunctionalRef casted_equalsOp = casted.getEqualsOp();
            if (!(temp_equalsOp == casted_equalsOp || temp_equalsOp.equals(casted_equalsOp))) return false;
            FunctionalRef temp_inOp = getInOp();
            FunctionalRef casted_inOp = casted.getInOp();
            if (!(temp_inOp == casted_inOp || temp_inOp.equals(casted_inOp))) return false;
            List<CaseClause> temp_clauses = getClauses();
            List<CaseClause> casted_clauses = casted.getClauses();
            if (!(temp_clauses == casted_clauses || temp_clauses.equals(casted_clauses))) return false;
            Option<Block> temp_elseClause = getElseClause();
            Option<Block> casted_elseClause = casted.getElseClause();
            if (!(temp_elseClause == casted_elseClause || temp_elseClause.equals(casted_elseClause))) return false;
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
        Option<Expr> temp_param = getParam();
        code ^= temp_param.hashCode();
        Option<FunctionalRef> temp_compare = getCompare();
        code ^= temp_compare.hashCode();
        FunctionalRef temp_equalsOp = getEqualsOp();
        code ^= temp_equalsOp.hashCode();
        FunctionalRef temp_inOp = getInOp();
        code ^= temp_inOp.hashCode();
        List<CaseClause> temp_clauses = getClauses();
        code ^= temp_clauses.hashCode();
        Option<Block> temp_elseClause = getElseClause();
        code ^= temp_elseClause.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected CaseExpr() {
        _param = null;
        _compare = null;
        _equalsOp = null;
        _inOp = null;
        _clauses = null;
        _elseClause = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected CaseExpr(ExprInfo info) {
        super(info);
        _param = null;
        _compare = null;
        _equalsOp = null;
        _inOp = null;
        _clauses = null;
        _elseClause = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "CaseExpr", 7)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Option<Expr> temp_param = getParam();
            if (w.visitNodeField("param", temp_param)) {
                if (temp_param.isNone()) {
                    w.visitEmptyOption(temp_param);
                }
                else if (w.visitNonEmptyOption(temp_param)) {
                    Expr elt_temp_param = temp_param.unwrap();
                    if (elt_temp_param == null) w.visitNull();
                    else {
                        elt_temp_param.walk(w);
                    }
                    w.endNonEmptyOption(temp_param);
                }
                w.endNodeField("param", temp_param);
            }
            Option<FunctionalRef> temp_compare = getCompare();
            if (w.visitNodeField("compare", temp_compare)) {
                if (temp_compare.isNone()) {
                    w.visitEmptyOption(temp_compare);
                }
                else if (w.visitNonEmptyOption(temp_compare)) {
                    FunctionalRef elt_temp_compare = temp_compare.unwrap();
                    if (elt_temp_compare == null) w.visitNull();
                    else {
                        elt_temp_compare.walk(w);
                    }
                    w.endNonEmptyOption(temp_compare);
                }
                w.endNodeField("compare", temp_compare);
            }
            FunctionalRef temp_equalsOp = getEqualsOp();
            if (w.visitNodeField("equalsOp", temp_equalsOp)) {
                temp_equalsOp.walk(w);
                w.endNodeField("equalsOp", temp_equalsOp);
            }
            FunctionalRef temp_inOp = getInOp();
            if (w.visitNodeField("inOp", temp_inOp)) {
                temp_inOp.walk(w);
                w.endNodeField("inOp", temp_inOp);
            }
            List<CaseClause> temp_clauses = getClauses();
            if (w.visitNodeField("clauses", temp_clauses)) {
                if (w.visitIterated(temp_clauses)) {
                    int i_temp_clauses = 0;
                    for (CaseClause elt_temp_clauses : temp_clauses) {
                        if (w.visitIteratedElement(i_temp_clauses, elt_temp_clauses)) {
                            if (elt_temp_clauses == null) w.visitNull();
                            else {
                                elt_temp_clauses.walk(w);
                            }
                        }
                        i_temp_clauses++;
                    }
                    w.endIterated(temp_clauses, i_temp_clauses);
                }
                w.endNodeField("clauses", temp_clauses);
            }
            Option<Block> temp_elseClause = getElseClause();
            if (w.visitNodeField("elseClause", temp_elseClause)) {
                if (temp_elseClause.isNone()) {
                    w.visitEmptyOption(temp_elseClause);
                }
                else if (w.visitNonEmptyOption(temp_elseClause)) {
                    Block elt_temp_elseClause = temp_elseClause.unwrap();
                    if (elt_temp_elseClause == null) w.visitNull();
                    else {
                        elt_temp_elseClause.walk(w);
                    }
                    w.endNonEmptyOption(temp_elseClause);
                }
                w.endNodeField("elseClause", temp_elseClause);
            }
            w.endNode(this, "CaseExpr", 7);
        }
    }

}
