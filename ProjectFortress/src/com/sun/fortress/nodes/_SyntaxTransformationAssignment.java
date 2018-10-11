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
 * Class _SyntaxTransformationAssignment, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationAssignment extends Assignment implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationAssignment.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationAssignment(List<Lhs> in_lhs, Option<FunctionalRef> in_assignOp, Expr in_rhs, List<CompoundAssignmentInfo> in_assignmentInfos, ExprInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_lhs, in_assignOp, in_rhs, in_assignmentInfos);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationAssignment constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationAssignment constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationAssignment constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationAssignment(List<Lhs> in_lhs, Option<FunctionalRef> in_assignOp, Expr in_rhs, List<CompoundAssignmentInfo> in_assignmentInfos, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_lhs, in_assignOp, in_rhs, in_assignmentInfos, NodeFactory.makeExprInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationAssignment(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationAssignment(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationAssignment(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.for_SyntaxTransformationAssignment(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationAssignment(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationAssignment(this);
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
            _SyntaxTransformationAssignment casted = (_SyntaxTransformationAssignment) obj;
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
            java.util.Map<String, Level> temp_variables = getVariables();
            java.util.Map<String, Level> casted_variables = casted.getVariables();
            if (!(temp_variables == casted_variables || temp_variables.equals(casted_variables))) return false;
            java.util.List<String> temp_syntaxParameters = getSyntaxParameters();
            java.util.List<String> casted_syntaxParameters = casted.getSyntaxParameters();
            if (!(temp_syntaxParameters == casted_syntaxParameters || temp_syntaxParameters.equals(casted_syntaxParameters))) return false;
            String temp_syntaxTransformer = getSyntaxTransformer();
            String casted_syntaxTransformer = casted.getSyntaxTransformer();
            if (!(temp_syntaxTransformer == casted_syntaxTransformer)) return false;
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
        List<Lhs> temp_lhs = getLhs();
        code ^= temp_lhs.hashCode();
        Option<FunctionalRef> temp_assignOp = getAssignOp();
        code ^= temp_assignOp.hashCode();
        Expr temp_rhs = getRhs();
        code ^= temp_rhs.hashCode();
        List<CompoundAssignmentInfo> temp_assignmentInfos = getAssignmentInfos();
        code ^= temp_assignmentInfos.hashCode();
        java.util.Map<String, Level> temp_variables = getVariables();
        code ^= temp_variables.hashCode();
        java.util.List<String> temp_syntaxParameters = getSyntaxParameters();
        code ^= temp_syntaxParameters.hashCode();
        String temp_syntaxTransformer = getSyntaxTransformer();
        code ^= temp_syntaxTransformer.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected _SyntaxTransformationAssignment() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationAssignment(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationAssignment(ExprInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationAssignment", 8)) {
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
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            java.util.Map<String, Level> temp_variables = getVariables();
            if (w.visitNodeField("variables", temp_variables)) {
                w.visitUnknownObject(temp_variables);
                w.endNodeField("variables", temp_variables);
            }
            java.util.List<String> temp_syntaxParameters = getSyntaxParameters();
            if (w.visitNodeField("syntaxParameters", temp_syntaxParameters)) {
                if (w.visitIterated(temp_syntaxParameters)) {
                    int i_temp_syntaxParameters = 0;
                    for (String elt_temp_syntaxParameters : temp_syntaxParameters) {
                        if (w.visitIteratedElement(i_temp_syntaxParameters, elt_temp_syntaxParameters)) {
                            if (elt_temp_syntaxParameters == null) w.visitNull();
                            else {
                                w.visitString(elt_temp_syntaxParameters);
                            }
                        }
                        i_temp_syntaxParameters++;
                    }
                    w.endIterated(temp_syntaxParameters, i_temp_syntaxParameters);
                }
                w.endNodeField("syntaxParameters", temp_syntaxParameters);
            }
            String temp_syntaxTransformer = getSyntaxTransformer();
            if (w.visitNodeField("syntaxTransformer", temp_syntaxTransformer)) {
                w.visitString(temp_syntaxTransformer);
                w.endNodeField("syntaxTransformer", temp_syntaxTransformer);
            }
            w.endNode(this, "_SyntaxTransformationAssignment", 8);
        }
    }

}
