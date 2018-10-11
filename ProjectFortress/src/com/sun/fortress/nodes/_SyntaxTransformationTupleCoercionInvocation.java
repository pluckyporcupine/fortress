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
 * Class _SyntaxTransformationTupleCoercionInvocation, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationTupleCoercionInvocation extends TupleCoercionInvocation implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationTupleCoercionInvocation.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationTupleCoercionInvocation(Expr in_arg, TupleType in_toType, List<Option<CoercionInvocation>> in_subCoercions, Option<Option<CoercionInvocation>> in_varargCoercion, ExprInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_arg, in_toType, in_subCoercions, in_varargCoercion);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationTupleCoercionInvocation constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationTupleCoercionInvocation constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationTupleCoercionInvocation constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationTupleCoercionInvocation(Expr in_arg, TupleType in_toType, List<Option<CoercionInvocation>> in_subCoercions, Option<Option<CoercionInvocation>> in_varargCoercion, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_arg, in_toType, in_subCoercions, in_varargCoercion, NodeFactory.makeExprInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationTupleCoercionInvocation(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationTupleCoercionInvocation(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationTupleCoercionInvocation(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.for_SyntaxTransformationTupleCoercionInvocation(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationTupleCoercionInvocation(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationTupleCoercionInvocation(this);
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
            _SyntaxTransformationTupleCoercionInvocation casted = (_SyntaxTransformationTupleCoercionInvocation) obj;
            Expr temp_arg = getArg();
            Expr casted_arg = casted.getArg();
            if (!(temp_arg == casted_arg || temp_arg.equals(casted_arg))) return false;
            TupleType temp_toType = getToType();
            TupleType casted_toType = casted.getToType();
            if (!(temp_toType == casted_toType || temp_toType.equals(casted_toType))) return false;
            List<Option<CoercionInvocation>> temp_subCoercions = getSubCoercions();
            List<Option<CoercionInvocation>> casted_subCoercions = casted.getSubCoercions();
            if (!(temp_subCoercions == casted_subCoercions || temp_subCoercions.equals(casted_subCoercions))) return false;
            Option<Option<CoercionInvocation>> temp_varargCoercion = getVarargCoercion();
            Option<Option<CoercionInvocation>> casted_varargCoercion = casted.getVarargCoercion();
            if (!(temp_varargCoercion == casted_varargCoercion || temp_varargCoercion.equals(casted_varargCoercion))) return false;
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
        TupleType temp_toType = getToType();
        code ^= temp_toType.hashCode();
        List<Option<CoercionInvocation>> temp_subCoercions = getSubCoercions();
        code ^= temp_subCoercions.hashCode();
        Option<Option<CoercionInvocation>> temp_varargCoercion = getVarargCoercion();
        code ^= temp_varargCoercion.hashCode();
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
    protected _SyntaxTransformationTupleCoercionInvocation() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationTupleCoercionInvocation(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationTupleCoercionInvocation(ExprInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationTupleCoercionInvocation", 8)) {
            Expr temp_arg = getArg();
            if (w.visitNodeField("arg", temp_arg)) {
                temp_arg.walk(w);
                w.endNodeField("arg", temp_arg);
            }
            TupleType temp_toType = getToType();
            if (w.visitNodeField("toType", temp_toType)) {
                temp_toType.walk(w);
                w.endNodeField("toType", temp_toType);
            }
            List<Option<CoercionInvocation>> temp_subCoercions = getSubCoercions();
            if (w.visitNodeField("subCoercions", temp_subCoercions)) {
                if (w.visitIterated(temp_subCoercions)) {
                    int i_temp_subCoercions = 0;
                    for (Option<CoercionInvocation> elt_temp_subCoercions : temp_subCoercions) {
                        if (w.visitIteratedElement(i_temp_subCoercions, elt_temp_subCoercions)) {
                            if (elt_temp_subCoercions == null) w.visitNull();
                            else {
                                if (elt_temp_subCoercions.isNone()) {
                                    w.visitEmptyOption(elt_temp_subCoercions);
                                }
                                else if (w.visitNonEmptyOption(elt_temp_subCoercions)) {
                                    CoercionInvocation elt_elt_temp_subCoercions = elt_temp_subCoercions.unwrap();
                                    if (elt_elt_temp_subCoercions == null) w.visitNull();
                                    else {
                                        elt_elt_temp_subCoercions.walk(w);
                                    }
                                    w.endNonEmptyOption(elt_temp_subCoercions);
                                }
                            }
                        }
                        i_temp_subCoercions++;
                    }
                    w.endIterated(temp_subCoercions, i_temp_subCoercions);
                }
                w.endNodeField("subCoercions", temp_subCoercions);
            }
            Option<Option<CoercionInvocation>> temp_varargCoercion = getVarargCoercion();
            if (w.visitNodeField("varargCoercion", temp_varargCoercion)) {
                if (temp_varargCoercion.isNone()) {
                    w.visitEmptyOption(temp_varargCoercion);
                }
                else if (w.visitNonEmptyOption(temp_varargCoercion)) {
                    Option<CoercionInvocation> elt_temp_varargCoercion = temp_varargCoercion.unwrap();
                    if (elt_temp_varargCoercion == null) w.visitNull();
                    else {
                        if (elt_temp_varargCoercion.isNone()) {
                            w.visitEmptyOption(elt_temp_varargCoercion);
                        }
                        else if (w.visitNonEmptyOption(elt_temp_varargCoercion)) {
                            CoercionInvocation elt_elt_temp_varargCoercion = elt_temp_varargCoercion.unwrap();
                            if (elt_elt_temp_varargCoercion == null) w.visitNull();
                            else {
                                elt_elt_temp_varargCoercion.walk(w);
                            }
                            w.endNonEmptyOption(elt_temp_varargCoercion);
                        }
                    }
                    w.endNonEmptyOption(temp_varargCoercion);
                }
                w.endNodeField("varargCoercion", temp_varargCoercion);
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
            w.endNode(this, "_SyntaxTransformationTupleCoercionInvocation", 8);
        }
    }

}
