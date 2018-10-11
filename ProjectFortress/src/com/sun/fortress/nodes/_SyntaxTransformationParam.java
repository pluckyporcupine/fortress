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
 * Class _SyntaxTransformationParam, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationParam extends Param implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationParam.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationParam(Id in_name, Modifiers in_mods, Option<TypeOrPattern> in_idType, Option<Expr> in_defaultExpr, Option<Type> in_varargsType, ASTNodeInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_name, in_mods, in_idType, in_defaultExpr, in_varargsType);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationParam constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationParam constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationParam constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationParam(Id in_name, Modifiers in_mods, Option<TypeOrPattern> in_idType, Option<Expr> in_defaultExpr, Option<Type> in_varargsType, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_name, in_mods, in_idType, in_defaultExpr, in_varargsType, NodeFactory.makeASTNodeInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationParam(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationParam(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationParam(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationParam(this);
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
            _SyntaxTransformationParam casted = (_SyntaxTransformationParam) obj;
            Id temp_name = getName();
            Id casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            Modifiers temp_mods = getMods();
            Modifiers casted_mods = casted.getMods();
            if (!(temp_mods == casted_mods || temp_mods.equals(casted_mods))) return false;
            Option<TypeOrPattern> temp_idType = getIdType();
            Option<TypeOrPattern> casted_idType = casted.getIdType();
            if (!(temp_idType == casted_idType || temp_idType.equals(casted_idType))) return false;
            Option<Expr> temp_defaultExpr = getDefaultExpr();
            Option<Expr> casted_defaultExpr = casted.getDefaultExpr();
            if (!(temp_defaultExpr == casted_defaultExpr || temp_defaultExpr.equals(casted_defaultExpr))) return false;
            Option<Type> temp_varargsType = getVarargsType();
            Option<Type> casted_varargsType = casted.getVarargsType();
            if (!(temp_varargsType == casted_varargsType || temp_varargsType.equals(casted_varargsType))) return false;
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
        Id temp_name = getName();
        code ^= temp_name.hashCode();
        Modifiers temp_mods = getMods();
        code ^= temp_mods.hashCode();
        Option<TypeOrPattern> temp_idType = getIdType();
        code ^= temp_idType.hashCode();
        Option<Expr> temp_defaultExpr = getDefaultExpr();
        code ^= temp_defaultExpr.hashCode();
        Option<Type> temp_varargsType = getVarargsType();
        code ^= temp_varargsType.hashCode();
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
    protected _SyntaxTransformationParam() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationParam(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationParam(ASTNodeInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationParam", 9)) {
            Id temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            Modifiers temp_mods = getMods();
            if (w.visitNodeField("mods", temp_mods)) {
                w.visitUnknownObject(temp_mods);
                w.endNodeField("mods", temp_mods);
            }
            Option<TypeOrPattern> temp_idType = getIdType();
            if (w.visitNodeField("idType", temp_idType)) {
                if (temp_idType.isNone()) {
                    w.visitEmptyOption(temp_idType);
                }
                else if (w.visitNonEmptyOption(temp_idType)) {
                    TypeOrPattern elt_temp_idType = temp_idType.unwrap();
                    if (elt_temp_idType == null) w.visitNull();
                    else {
                        elt_temp_idType.walk(w);
                    }
                    w.endNonEmptyOption(temp_idType);
                }
                w.endNodeField("idType", temp_idType);
            }
            Option<Expr> temp_defaultExpr = getDefaultExpr();
            if (w.visitNodeField("defaultExpr", temp_defaultExpr)) {
                if (temp_defaultExpr.isNone()) {
                    w.visitEmptyOption(temp_defaultExpr);
                }
                else if (w.visitNonEmptyOption(temp_defaultExpr)) {
                    Expr elt_temp_defaultExpr = temp_defaultExpr.unwrap();
                    if (elt_temp_defaultExpr == null) w.visitNull();
                    else {
                        elt_temp_defaultExpr.walk(w);
                    }
                    w.endNonEmptyOption(temp_defaultExpr);
                }
                w.endNodeField("defaultExpr", temp_defaultExpr);
            }
            Option<Type> temp_varargsType = getVarargsType();
            if (w.visitNodeField("varargsType", temp_varargsType)) {
                if (temp_varargsType.isNone()) {
                    w.visitEmptyOption(temp_varargsType);
                }
                else if (w.visitNonEmptyOption(temp_varargsType)) {
                    Type elt_temp_varargsType = temp_varargsType.unwrap();
                    if (elt_temp_varargsType == null) w.visitNull();
                    else {
                        elt_temp_varargsType.walk(w);
                    }
                    w.endNonEmptyOption(temp_varargsType);
                }
                w.endNodeField("varargsType", temp_varargsType);
            }
            ASTNodeInfo temp_info = getInfo();
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
            w.endNode(this, "_SyntaxTransformationParam", 9);
        }
    }

}
