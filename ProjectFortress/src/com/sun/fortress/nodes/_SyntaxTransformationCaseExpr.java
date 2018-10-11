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
 * Class _SyntaxTransformationCaseExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationCaseExpr extends CaseExpr implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationCaseExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationCaseExpr(Option<Expr> in_param, Option<FunctionalRef> in_compare, FunctionalRef in_equalsOp, FunctionalRef in_inOp, List<CaseClause> in_clauses, Option<Block> in_elseClause, ExprInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_param, in_compare, in_equalsOp, in_inOp, in_clauses, in_elseClause);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationCaseExpr constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationCaseExpr constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationCaseExpr constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationCaseExpr(Option<Expr> in_param, Option<FunctionalRef> in_compare, FunctionalRef in_equalsOp, FunctionalRef in_inOp, List<CaseClause> in_clauses, Option<Block> in_elseClause, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_param, in_compare, in_equalsOp, in_inOp, in_clauses, in_elseClause, NodeFactory.makeExprInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationCaseExpr(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationCaseExpr(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationCaseExpr(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.for_SyntaxTransformationCaseExpr(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationCaseExpr(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationCaseExpr(this);
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
            _SyntaxTransformationCaseExpr casted = (_SyntaxTransformationCaseExpr) obj;
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
    protected _SyntaxTransformationCaseExpr() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationCaseExpr(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationCaseExpr(ExprInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationCaseExpr", 10)) {
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
            w.endNode(this, "_SyntaxTransformationCaseExpr", 10);
        }
    }

}
