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
 * Class Assignment, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class Assignment extends Expr {
    private final List<Lhs> _lhs;
    private final Option<FunctionalRef> _assignOp;
    private final Expr _rhs;
    private final List<CompoundAssignmentInfo> _assignmentInfos;

    /**
     * Constructs a Assignment.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Assignment(ExprInfo in_info, List<Lhs> in_lhs, Option<FunctionalRef> in_assignOp, Expr in_rhs, List<CompoundAssignmentInfo> in_assignmentInfos) {
        super(in_info);
        if (in_lhs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'lhs' to the Assignment constructor was null");
        }
        _lhs = in_lhs;
        if (in_assignOp == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'assignOp' to the Assignment constructor was null");
        }
        _assignOp = in_assignOp;
        if (in_rhs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'rhs' to the Assignment constructor was null");
        }
        _rhs = in_rhs;
        if (in_assignmentInfos == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'assignmentInfos' to the Assignment constructor was null");
        }
        _assignmentInfos = in_assignmentInfos;
    }

    final public List<Lhs> getLhs() { return _lhs; }
    final public Option<FunctionalRef> getAssignOp() { return _assignOp; }
    final public Expr getRhs() { return _rhs; }
    final public List<CompoundAssignmentInfo> getAssignmentInfos() { return _assignmentInfos; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forAssignment(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forAssignment(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forAssignment(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forAssignment(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forAssignment(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forAssignment(this);
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
            Assignment casted = (Assignment) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<Lhs> temp_lhs = getLhs();
            List<Lhs> casted_lhs = casted.getLhs();
            if (!(temp_lhs == casted_lhs || temp_lhs.equals(casted_lhs))) return false;
            Option<FunctionalRef> temp_assignOp = getAssignOp();
            Option<FunctionalRef> casted_assignOp = casted.getAssignOp();
            if (!(temp_assignOp == casted_assignOp || temp_assignOp.equals(casted_assignOp))) return false;
            Expr temp_rhs = getRhs();
            Expr casted_rhs = casted.getRhs();
            if (!(temp_rhs == casted_rhs || temp_rhs.equals(casted_rhs))) return false;
            List<CompoundAssignmentInfo> temp_assignmentInfos = getAssignmentInfos();
            List<CompoundAssignmentInfo> casted_assignmentInfos = casted.getAssignmentInfos();
            if (!(temp_assignmentInfos == casted_assignmentInfos || temp_assignmentInfos.equals(casted_assignmentInfos))) return false;
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
        List<Lhs> temp_lhs = getLhs();
        code ^= temp_lhs.hashCode();
        Option<FunctionalRef> temp_assignOp = getAssignOp();
        code ^= temp_assignOp.hashCode();
        Expr temp_rhs = getRhs();
        code ^= temp_rhs.hashCode();
        List<CompoundAssignmentInfo> temp_assignmentInfos = getAssignmentInfos();
        code ^= temp_assignmentInfos.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Assignment() {
        _lhs = null;
        _assignOp = null;
        _rhs = null;
        _assignmentInfos = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Assignment(ExprInfo info) {
        super(info);
        _lhs = null;
        _assignOp = null;
        _rhs = null;
        _assignmentInfos = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "Assignment", 5)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<Lhs> temp_lhs = getLhs();
            if (w.visitNodeField("lhs", temp_lhs)) {
                if (w.visitIterated(temp_lhs)) {
                    int i_temp_lhs = 0;
                    for (Lhs elt_temp_lhs : temp_lhs) {
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
            Option<FunctionalRef> temp_assignOp = getAssignOp();
            if (w.visitNodeField("assignOp", temp_assignOp)) {
                if (temp_assignOp.isNone()) {
                    w.visitEmptyOption(temp_assignOp);
                }
                else if (w.visitNonEmptyOption(temp_assignOp)) {
                    FunctionalRef elt_temp_assignOp = temp_assignOp.unwrap();
                    if (elt_temp_assignOp == null) w.visitNull();
                    else {
                        elt_temp_assignOp.walk(w);
                    }
                    w.endNonEmptyOption(temp_assignOp);
                }
                w.endNodeField("assignOp", temp_assignOp);
            }
            Expr temp_rhs = getRhs();
            if (w.visitNodeField("rhs", temp_rhs)) {
                temp_rhs.walk(w);
                w.endNodeField("rhs", temp_rhs);
            }
            List<CompoundAssignmentInfo> temp_assignmentInfos = getAssignmentInfos();
            if (w.visitNodeField("assignmentInfos", temp_assignmentInfos)) {
                if (w.visitIterated(temp_assignmentInfos)) {
                    int i_temp_assignmentInfos = 0;
                    for (CompoundAssignmentInfo elt_temp_assignmentInfos : temp_assignmentInfos) {
                        if (w.visitIteratedElement(i_temp_assignmentInfos, elt_temp_assignmentInfos)) {
                            if (elt_temp_assignmentInfos == null) w.visitNull();
                            else {
                                elt_temp_assignmentInfos.walk(w);
                            }
                        }
                        i_temp_assignmentInfos++;
                    }
                    w.endIterated(temp_assignmentInfos, i_temp_assignmentInfos);
                }
                w.endNodeField("assignmentInfos", temp_assignmentInfos);
            }
            w.endNode(this, "Assignment", 5);
        }
    }

}
