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
 * Class _SyntaxTransformationTupleExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationTupleExpr extends TupleExpr implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationTupleExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationTupleExpr(List<Expr> in_exprs, Option<Expr> in_varargs, List<KeywordExpr> in_keywords, boolean in_inApp, ExprInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_exprs, in_varargs, in_keywords, in_inApp);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationTupleExpr constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationTupleExpr constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationTupleExpr constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationTupleExpr(List<Expr> in_exprs, Option<Expr> in_varargs, List<KeywordExpr> in_keywords, boolean in_inApp, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_exprs, in_varargs, in_keywords, in_inApp, NodeFactory.makeExprInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationTupleExpr(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationTupleExpr(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationTupleExpr(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.for_SyntaxTransformationTupleExpr(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationTupleExpr(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationTupleExpr(this);
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
            _SyntaxTransformationTupleExpr casted = (_SyntaxTransformationTupleExpr) obj;
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
        List<Expr> temp_exprs = getExprs();
        code ^= temp_exprs.hashCode();
        Option<Expr> temp_varargs = getVarargs();
        code ^= temp_varargs.hashCode();
        List<KeywordExpr> temp_keywords = getKeywords();
        code ^= temp_keywords.hashCode();
        boolean temp_inApp = isInApp();
        code ^= temp_inApp ? 1231 : 1237;
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
    protected _SyntaxTransformationTupleExpr() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationTupleExpr(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationTupleExpr(ExprInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationTupleExpr", 8)) {
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
            w.endNode(this, "_SyntaxTransformationTupleExpr", 8);
        }
    }

}
