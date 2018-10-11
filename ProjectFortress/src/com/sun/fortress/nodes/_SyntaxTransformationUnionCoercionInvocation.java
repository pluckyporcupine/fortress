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
 * Class _SyntaxTransformationUnionCoercionInvocation, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationUnionCoercionInvocation extends UnionCoercionInvocation implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationUnionCoercionInvocation.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationUnionCoercionInvocation(Type in_toType, Expr in_arg, List<Type> in_fromTypes, List<Option<CoercionInvocation>> in_fromCoercions, ExprInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_toType, in_arg, in_fromTypes, in_fromCoercions);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationUnionCoercionInvocation constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationUnionCoercionInvocation constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationUnionCoercionInvocation constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationUnionCoercionInvocation(Type in_toType, Expr in_arg, List<Type> in_fromTypes, List<Option<CoercionInvocation>> in_fromCoercions, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_toType, in_arg, in_fromTypes, in_fromCoercions, NodeFactory.makeExprInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationUnionCoercionInvocation(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationUnionCoercionInvocation(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationUnionCoercionInvocation(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.for_SyntaxTransformationUnionCoercionInvocation(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationUnionCoercionInvocation(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationUnionCoercionInvocation(this);
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
            _SyntaxTransformationUnionCoercionInvocation casted = (_SyntaxTransformationUnionCoercionInvocation) obj;
            Type temp_toType = getToType();
            Type casted_toType = casted.getToType();
            if (!(temp_toType == casted_toType || temp_toType.equals(casted_toType))) return false;
            Expr temp_arg = getArg();
            Expr casted_arg = casted.getArg();
            if (!(temp_arg == casted_arg || temp_arg.equals(casted_arg))) return false;
            List<Type> temp_fromTypes = getFromTypes();
            List<Type> casted_fromTypes = casted.getFromTypes();
            if (!(temp_fromTypes == casted_fromTypes || temp_fromTypes.equals(casted_fromTypes))) return false;
            List<Option<CoercionInvocation>> temp_fromCoercions = getFromCoercions();
            List<Option<CoercionInvocation>> casted_fromCoercions = casted.getFromCoercions();
            if (!(temp_fromCoercions == casted_fromCoercions || temp_fromCoercions.equals(casted_fromCoercions))) return false;
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
        Type temp_toType = getToType();
        code ^= temp_toType.hashCode();
        Expr temp_arg = getArg();
        code ^= temp_arg.hashCode();
        List<Type> temp_fromTypes = getFromTypes();
        code ^= temp_fromTypes.hashCode();
        List<Option<CoercionInvocation>> temp_fromCoercions = getFromCoercions();
        code ^= temp_fromCoercions.hashCode();
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
    protected _SyntaxTransformationUnionCoercionInvocation() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationUnionCoercionInvocation(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationUnionCoercionInvocation(ExprInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationUnionCoercionInvocation", 8)) {
            Type temp_toType = getToType();
            if (w.visitNodeField("toType", temp_toType)) {
                temp_toType.walk(w);
                w.endNodeField("toType", temp_toType);
            }
            Expr temp_arg = getArg();
            if (w.visitNodeField("arg", temp_arg)) {
                temp_arg.walk(w);
                w.endNodeField("arg", temp_arg);
            }
            List<Type> temp_fromTypes = getFromTypes();
            if (w.visitNodeField("fromTypes", temp_fromTypes)) {
                if (w.visitIterated(temp_fromTypes)) {
                    int i_temp_fromTypes = 0;
                    for (Type elt_temp_fromTypes : temp_fromTypes) {
                        if (w.visitIteratedElement(i_temp_fromTypes, elt_temp_fromTypes)) {
                            if (elt_temp_fromTypes == null) w.visitNull();
                            else {
                                elt_temp_fromTypes.walk(w);
                            }
                        }
                        i_temp_fromTypes++;
                    }
                    w.endIterated(temp_fromTypes, i_temp_fromTypes);
                }
                w.endNodeField("fromTypes", temp_fromTypes);
            }
            List<Option<CoercionInvocation>> temp_fromCoercions = getFromCoercions();
            if (w.visitNodeField("fromCoercions", temp_fromCoercions)) {
                if (w.visitIterated(temp_fromCoercions)) {
                    int i_temp_fromCoercions = 0;
                    for (Option<CoercionInvocation> elt_temp_fromCoercions : temp_fromCoercions) {
                        if (w.visitIteratedElement(i_temp_fromCoercions, elt_temp_fromCoercions)) {
                            if (elt_temp_fromCoercions == null) w.visitNull();
                            else {
                                if (elt_temp_fromCoercions.isNone()) {
                                    w.visitEmptyOption(elt_temp_fromCoercions);
                                }
                                else if (w.visitNonEmptyOption(elt_temp_fromCoercions)) {
                                    CoercionInvocation elt_elt_temp_fromCoercions = elt_temp_fromCoercions.unwrap();
                                    if (elt_elt_temp_fromCoercions == null) w.visitNull();
                                    else {
                                        elt_elt_temp_fromCoercions.walk(w);
                                    }
                                    w.endNonEmptyOption(elt_temp_fromCoercions);
                                }
                            }
                        }
                        i_temp_fromCoercions++;
                    }
                    w.endIterated(temp_fromCoercions, i_temp_fromCoercions);
                }
                w.endNodeField("fromCoercions", temp_fromCoercions);
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
            w.endNode(this, "_SyntaxTransformationUnionCoercionInvocation", 8);
        }
    }

}
