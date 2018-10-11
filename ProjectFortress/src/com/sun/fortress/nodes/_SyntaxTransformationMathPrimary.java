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
 * Class _SyntaxTransformationMathPrimary, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationMathPrimary extends MathPrimary implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationMathPrimary.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationMathPrimary(FunctionalRef in_multiJuxt, FunctionalRef in_infixJuxt, Expr in_front, List<MathItem> in_rest, ExprInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_multiJuxt, in_infixJuxt, in_front, in_rest);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationMathPrimary constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationMathPrimary constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationMathPrimary constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationMathPrimary(FunctionalRef in_multiJuxt, FunctionalRef in_infixJuxt, Expr in_front, List<MathItem> in_rest, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_multiJuxt, in_infixJuxt, in_front, in_rest, NodeFactory.makeExprInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationMathPrimary(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationMathPrimary(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationMathPrimary(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.for_SyntaxTransformationMathPrimary(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationMathPrimary(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationMathPrimary(this);
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
            _SyntaxTransformationMathPrimary casted = (_SyntaxTransformationMathPrimary) obj;
            FunctionalRef temp_multiJuxt = getMultiJuxt();
            FunctionalRef casted_multiJuxt = casted.getMultiJuxt();
            if (!(temp_multiJuxt == casted_multiJuxt || temp_multiJuxt.equals(casted_multiJuxt))) return false;
            FunctionalRef temp_infixJuxt = getInfixJuxt();
            FunctionalRef casted_infixJuxt = casted.getInfixJuxt();
            if (!(temp_infixJuxt == casted_infixJuxt || temp_infixJuxt.equals(casted_infixJuxt))) return false;
            Expr temp_front = getFront();
            Expr casted_front = casted.getFront();
            if (!(temp_front == casted_front || temp_front.equals(casted_front))) return false;
            List<MathItem> temp_rest = getRest();
            List<MathItem> casted_rest = casted.getRest();
            if (!(temp_rest == casted_rest || temp_rest.equals(casted_rest))) return false;
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
        FunctionalRef temp_multiJuxt = getMultiJuxt();
        code ^= temp_multiJuxt.hashCode();
        FunctionalRef temp_infixJuxt = getInfixJuxt();
        code ^= temp_infixJuxt.hashCode();
        Expr temp_front = getFront();
        code ^= temp_front.hashCode();
        List<MathItem> temp_rest = getRest();
        code ^= temp_rest.hashCode();
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
    protected _SyntaxTransformationMathPrimary() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationMathPrimary(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationMathPrimary(ExprInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationMathPrimary", 8)) {
            FunctionalRef temp_multiJuxt = getMultiJuxt();
            if (w.visitNodeField("multiJuxt", temp_multiJuxt)) {
                temp_multiJuxt.walk(w);
                w.endNodeField("multiJuxt", temp_multiJuxt);
            }
            FunctionalRef temp_infixJuxt = getInfixJuxt();
            if (w.visitNodeField("infixJuxt", temp_infixJuxt)) {
                temp_infixJuxt.walk(w);
                w.endNodeField("infixJuxt", temp_infixJuxt);
            }
            Expr temp_front = getFront();
            if (w.visitNodeField("front", temp_front)) {
                temp_front.walk(w);
                w.endNodeField("front", temp_front);
            }
            List<MathItem> temp_rest = getRest();
            if (w.visitNodeField("rest", temp_rest)) {
                if (w.visitIterated(temp_rest)) {
                    int i_temp_rest = 0;
                    for (MathItem elt_temp_rest : temp_rest) {
                        if (w.visitIteratedElement(i_temp_rest, elt_temp_rest)) {
                            if (elt_temp_rest == null) w.visitNull();
                            else {
                                elt_temp_rest.walk(w);
                            }
                        }
                        i_temp_rest++;
                    }
                    w.endIterated(temp_rest, i_temp_rest);
                }
                w.endNodeField("rest", temp_rest);
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
            w.endNode(this, "_SyntaxTransformationMathPrimary", 8);
        }
    }

}
