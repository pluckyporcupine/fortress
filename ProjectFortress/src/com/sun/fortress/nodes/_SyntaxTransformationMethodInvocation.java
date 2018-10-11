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
 * Class _SyntaxTransformationMethodInvocation, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationMethodInvocation extends MethodInvocation implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationMethodInvocation.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationMethodInvocation(Expr in_obj, IdOrOp in_method, List<StaticArg> in_staticArgs, Expr in_arg, Option<Type> in_overloadingType, Option<Type> in_overloadingSchema, ExprInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_obj, in_method, in_staticArgs, in_arg, in_overloadingType, in_overloadingSchema);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationMethodInvocation constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationMethodInvocation constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationMethodInvocation constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationMethodInvocation(Expr in_obj, IdOrOp in_method, List<StaticArg> in_staticArgs, Expr in_arg, Option<Type> in_overloadingType, Option<Type> in_overloadingSchema, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_obj, in_method, in_staticArgs, in_arg, in_overloadingType, in_overloadingSchema, NodeFactory.makeExprInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationMethodInvocation(Expr in_obj, IdOrOp in_method, List<StaticArg> in_staticArgs, Expr in_arg, Option<Type> in_overloadingType, ExprInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_obj, in_method, in_staticArgs, in_arg, in_overloadingType, Option.<Type>none(), in_info, in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationMethodInvocation(Expr in_obj, IdOrOp in_method, List<StaticArg> in_staticArgs, Expr in_arg, Option<Type> in_overloadingType, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_obj, in_method, in_staticArgs, in_arg, in_overloadingType, Option.<Type>none(), NodeFactory.makeExprInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationMethodInvocation(Expr in_obj, IdOrOp in_method, List<StaticArg> in_staticArgs, Expr in_arg, ExprInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_obj, in_method, in_staticArgs, in_arg, Option.<Type>none(), Option.<Type>none(), in_info, in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationMethodInvocation(Expr in_obj, IdOrOp in_method, List<StaticArg> in_staticArgs, Expr in_arg, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_obj, in_method, in_staticArgs, in_arg, Option.<Type>none(), Option.<Type>none(), NodeFactory.makeExprInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationMethodInvocation(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationMethodInvocation(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationMethodInvocation(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.for_SyntaxTransformationMethodInvocation(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationMethodInvocation(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationMethodInvocation(this);
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
            _SyntaxTransformationMethodInvocation casted = (_SyntaxTransformationMethodInvocation) obj;
            Expr temp_obj = getObj();
            Expr casted_obj = casted.getObj();
            if (!(temp_obj == casted_obj || temp_obj.equals(casted_obj))) return false;
            IdOrOp temp_method = getMethod();
            IdOrOp casted_method = casted.getMethod();
            if (!(temp_method == casted_method || temp_method.equals(casted_method))) return false;
            List<StaticArg> temp_staticArgs = getStaticArgs();
            List<StaticArg> casted_staticArgs = casted.getStaticArgs();
            if (!(temp_staticArgs == casted_staticArgs || temp_staticArgs.equals(casted_staticArgs))) return false;
            Expr temp_arg = getArg();
            Expr casted_arg = casted.getArg();
            if (!(temp_arg == casted_arg || temp_arg.equals(casted_arg))) return false;
            Option<Type> temp_overloadingType = getOverloadingType();
            Option<Type> casted_overloadingType = casted.getOverloadingType();
            if (!(temp_overloadingType == casted_overloadingType || temp_overloadingType.equals(casted_overloadingType))) return false;
            Option<Type> temp_overloadingSchema = getOverloadingSchema();
            Option<Type> casted_overloadingSchema = casted.getOverloadingSchema();
            if (!(temp_overloadingSchema == casted_overloadingSchema || temp_overloadingSchema.equals(casted_overloadingSchema))) return false;
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
        Expr temp_obj = getObj();
        code ^= temp_obj.hashCode();
        IdOrOp temp_method = getMethod();
        code ^= temp_method.hashCode();
        List<StaticArg> temp_staticArgs = getStaticArgs();
        code ^= temp_staticArgs.hashCode();
        Expr temp_arg = getArg();
        code ^= temp_arg.hashCode();
        Option<Type> temp_overloadingType = getOverloadingType();
        code ^= temp_overloadingType.hashCode();
        Option<Type> temp_overloadingSchema = getOverloadingSchema();
        code ^= temp_overloadingSchema.hashCode();
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
    protected _SyntaxTransformationMethodInvocation() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationMethodInvocation(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationMethodInvocation(ExprInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationMethodInvocation", 10)) {
            Expr temp_obj = getObj();
            if (w.visitNodeField("obj", temp_obj)) {
                temp_obj.walk(w);
                w.endNodeField("obj", temp_obj);
            }
            IdOrOp temp_method = getMethod();
            if (w.visitNodeField("method", temp_method)) {
                temp_method.walk(w);
                w.endNodeField("method", temp_method);
            }
            List<StaticArg> temp_staticArgs = getStaticArgs();
            if (w.visitNodeField("staticArgs", temp_staticArgs)) {
                if (w.visitIterated(temp_staticArgs)) {
                    int i_temp_staticArgs = 0;
                    for (StaticArg elt_temp_staticArgs : temp_staticArgs) {
                        if (w.visitIteratedElement(i_temp_staticArgs, elt_temp_staticArgs)) {
                            if (elt_temp_staticArgs == null) w.visitNull();
                            else {
                                elt_temp_staticArgs.walk(w);
                            }
                        }
                        i_temp_staticArgs++;
                    }
                    w.endIterated(temp_staticArgs, i_temp_staticArgs);
                }
                w.endNodeField("staticArgs", temp_staticArgs);
            }
            Expr temp_arg = getArg();
            if (w.visitNodeField("arg", temp_arg)) {
                temp_arg.walk(w);
                w.endNodeField("arg", temp_arg);
            }
            Option<Type> temp_overloadingType = getOverloadingType();
            if (w.visitNodeField("overloadingType", temp_overloadingType)) {
                if (temp_overloadingType.isNone()) {
                    w.visitEmptyOption(temp_overloadingType);
                }
                else if (w.visitNonEmptyOption(temp_overloadingType)) {
                    Type elt_temp_overloadingType = temp_overloadingType.unwrap();
                    if (elt_temp_overloadingType == null) w.visitNull();
                    else {
                        elt_temp_overloadingType.walk(w);
                    }
                    w.endNonEmptyOption(temp_overloadingType);
                }
                w.endNodeField("overloadingType", temp_overloadingType);
            }
            Option<Type> temp_overloadingSchema = getOverloadingSchema();
            if (w.visitNodeField("overloadingSchema", temp_overloadingSchema)) {
                if (temp_overloadingSchema.isNone()) {
                    w.visitEmptyOption(temp_overloadingSchema);
                }
                else if (w.visitNonEmptyOption(temp_overloadingSchema)) {
                    Type elt_temp_overloadingSchema = temp_overloadingSchema.unwrap();
                    if (elt_temp_overloadingSchema == null) w.visitNull();
                    else {
                        elt_temp_overloadingSchema.walk(w);
                    }
                    w.endNonEmptyOption(temp_overloadingSchema);
                }
                w.endNodeField("overloadingSchema", temp_overloadingSchema);
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
            w.endNode(this, "_SyntaxTransformationMethodInvocation", 10);
        }
    }

}
