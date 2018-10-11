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
 * Class If, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class If extends Expr {
    private final List<IfClause> _clauses;
    private final Option<Block> _elseClause;

    /**
     * Constructs a If.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public If(ExprInfo in_info, List<IfClause> in_clauses, Option<Block> in_elseClause) {
        super(in_info);
        if (in_clauses == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'clauses' to the If constructor was null");
        }
        _clauses = in_clauses;
        if (in_elseClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'elseClause' to the If constructor was null");
        }
        _elseClause = in_elseClause;
    }

    final public List<IfClause> getClauses() { return _clauses; }
    final public Option<Block> getElseClause() { return _elseClause; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forIf(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forIf(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forIf(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forIf(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forIf(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forIf(this);
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
            If casted = (If) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<IfClause> temp_clauses = getClauses();
            List<IfClause> casted_clauses = casted.getClauses();
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
        List<IfClause> temp_clauses = getClauses();
        code ^= temp_clauses.hashCode();
        Option<Block> temp_elseClause = getElseClause();
        code ^= temp_elseClause.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected If() {
        _clauses = null;
        _elseClause = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected If(ExprInfo info) {
        super(info);
        _clauses = null;
        _elseClause = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "If", 3)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<IfClause> temp_clauses = getClauses();
            if (w.visitNodeField("clauses", temp_clauses)) {
                if (w.visitIterated(temp_clauses)) {
                    int i_temp_clauses = 0;
                    for (IfClause elt_temp_clauses : temp_clauses) {
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
            w.endNode(this, "If", 3);
        }
    }

}
