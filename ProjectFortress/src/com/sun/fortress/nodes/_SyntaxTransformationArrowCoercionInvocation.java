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
 * Class _SyntaxTransformationArrowCoercionInvocation, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationArrowCoercionInvocation extends ArrowCoercionInvocation implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationArrowCoercionInvocation.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationArrowCoercionInvocation(Expr in_arg, ArrowType in_toType, Option<CoercionInvocation> in_domainCoercion, Option<CoercionInvocation> in_rangeCoercion, ExprInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_arg, in_toType, in_domainCoercion, in_rangeCoercion);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationArrowCoercionInvocation constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationArrowCoercionInvocation constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationArrowCoercionInvocation constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationArrowCoercionInvocation(Expr in_arg, ArrowType in_toType, Option<CoercionInvocation> in_domainCoercion, Option<CoercionInvocation> in_rangeCoercion, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_arg, in_toType, in_domainCoercion, in_rangeCoercion, NodeFactory.makeExprInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationArrowCoercionInvocation(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationArrowCoercionInvocation(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationArrowCoercionInvocation(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.for_SyntaxTransformationArrowCoercionInvocation(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationArrowCoercionInvocation(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationArrowCoercionInvocation(this);
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
            _SyntaxTransformationArrowCoercionInvocation casted = (_SyntaxTransformationArrowCoercionInvocation) obj;
            Expr temp_arg = getArg();
            Expr casted_arg = casted.getArg();
            if (!(temp_arg == casted_arg || temp_arg.equals(casted_arg))) return false;
            ArrowType temp_toType = getToType();
            ArrowType casted_toType = casted.getToType();
            if (!(temp_toType == casted_toType || temp_toType.equals(casted_toType))) return false;
            Option<CoercionInvocation> temp_domainCoercion = getDomainCoercion();
            Option<CoercionInvocation> casted_domainCoercion = casted.getDomainCoercion();
            if (!(temp_domainCoercion == casted_domainCoercion || temp_domainCoercion.equals(casted_domainCoercion))) return false;
            Option<CoercionInvocation> temp_rangeCoercion = getRangeCoercion();
            Option<CoercionInvocation> casted_rangeCoercion = casted.getRangeCoercion();
            if (!(temp_rangeCoercion == casted_rangeCoercion || temp_rangeCoercion.equals(casted_rangeCoercion))) return false;
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
        Expr temp_arg = getArg();
        code ^= temp_arg.hashCode();
        ArrowType temp_toType = getToType();
        code ^= temp_toType.hashCode();
        Option<CoercionInvocation> temp_domainCoercion = getDomainCoercion();
        code ^= temp_domainCoercion.hashCode();
        Option<CoercionInvocation> temp_rangeCoercion = getRangeCoercion();
        code ^= temp_rangeCoercion.hashCode();
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
    protected _SyntaxTransformationArrowCoercionInvocation() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationArrowCoercionInvocation(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationArrowCoercionInvocation(ExprInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationArrowCoercionInvocation", 8)) {
            Expr temp_arg = getArg();
            if (w.visitNodeField("arg", temp_arg)) {
                temp_arg.walk(w);
                w.endNodeField("arg", temp_arg);
            }
            ArrowType temp_toType = getToType();
            if (w.visitNodeField("toType", temp_toType)) {
                temp_toType.walk(w);
                w.endNodeField("toType", temp_toType);
            }
            Option<CoercionInvocation> temp_domainCoercion = getDomainCoercion();
            if (w.visitNodeField("domainCoercion", temp_domainCoercion)) {
                if (temp_domainCoercion.isNone()) {
                    w.visitEmptyOption(temp_domainCoercion);
                }
                else if (w.visitNonEmptyOption(temp_domainCoercion)) {
                    CoercionInvocation elt_temp_domainCoercion = temp_domainCoercion.unwrap();
                    if (elt_temp_domainCoercion == null) w.visitNull();
                    else {
                        elt_temp_domainCoercion.walk(w);
                    }
                    w.endNonEmptyOption(temp_domainCoercion);
                }
                w.endNodeField("domainCoercion", temp_domainCoercion);
            }
            Option<CoercionInvocation> temp_rangeCoercion = getRangeCoercion();
            if (w.visitNodeField("rangeCoercion", temp_rangeCoercion)) {
                if (temp_rangeCoercion.isNone()) {
                    w.visitEmptyOption(temp_rangeCoercion);
                }
                else if (w.visitNonEmptyOption(temp_rangeCoercion)) {
                    CoercionInvocation elt_temp_rangeCoercion = temp_rangeCoercion.unwrap();
                    if (elt_temp_rangeCoercion == null) w.visitNull();
                    else {
                        elt_temp_rangeCoercion.walk(w);
                    }
                    w.endNonEmptyOption(temp_rangeCoercion);
                }
                w.endNodeField("rangeCoercion", temp_rangeCoercion);
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
            w.endNode(this, "_SyntaxTransformationArrowCoercionInvocation", 8);
        }
    }

}
