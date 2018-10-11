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
 * Class _SyntaxTransformationNonterminalHeader, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationNonterminalHeader extends NonterminalHeader implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationNonterminalHeader.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationNonterminalHeader(Modifiers in_mods, Id in_name, List<NonterminalParameter> in_params, List<StaticParam> in_staticParams, Option<Type> in_paramType, Option<WhereClause> in_whereClause, ASTNodeInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_mods, in_name, in_params, in_staticParams, in_paramType, in_whereClause);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationNonterminalHeader constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationNonterminalHeader constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationNonterminalHeader constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationNonterminalHeader(Modifiers in_mods, Id in_name, List<NonterminalParameter> in_params, List<StaticParam> in_staticParams, Option<Type> in_paramType, Option<WhereClause> in_whereClause, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_mods, in_name, in_params, in_staticParams, in_paramType, in_whereClause, NodeFactory.makeASTNodeInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationNonterminalHeader(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationNonterminalHeader(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationNonterminalHeader(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationNonterminalHeader(this);
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
            _SyntaxTransformationNonterminalHeader casted = (_SyntaxTransformationNonterminalHeader) obj;
            Modifiers temp_mods = getMods();
            Modifiers casted_mods = casted.getMods();
            if (!(temp_mods == casted_mods || temp_mods.equals(casted_mods))) return false;
            Id temp_name = getName();
            Id casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            List<NonterminalParameter> temp_params = getParams();
            List<NonterminalParameter> casted_params = casted.getParams();
            if (!(temp_params == casted_params || temp_params.equals(casted_params))) return false;
            List<StaticParam> temp_staticParams = getStaticParams();
            List<StaticParam> casted_staticParams = casted.getStaticParams();
            if (!(temp_staticParams == casted_staticParams || temp_staticParams.equals(casted_staticParams))) return false;
            Option<Type> temp_paramType = getParamType();
            Option<Type> casted_paramType = casted.getParamType();
            if (!(temp_paramType == casted_paramType || temp_paramType.equals(casted_paramType))) return false;
            Option<WhereClause> temp_whereClause = getWhereClause();
            Option<WhereClause> casted_whereClause = casted.getWhereClause();
            if (!(temp_whereClause == casted_whereClause || temp_whereClause.equals(casted_whereClause))) return false;
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
        Modifiers temp_mods = getMods();
        code ^= temp_mods.hashCode();
        Id temp_name = getName();
        code ^= temp_name.hashCode();
        List<NonterminalParameter> temp_params = getParams();
        code ^= temp_params.hashCode();
        List<StaticParam> temp_staticParams = getStaticParams();
        code ^= temp_staticParams.hashCode();
        Option<Type> temp_paramType = getParamType();
        code ^= temp_paramType.hashCode();
        Option<WhereClause> temp_whereClause = getWhereClause();
        code ^= temp_whereClause.hashCode();
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
    protected _SyntaxTransformationNonterminalHeader() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationNonterminalHeader(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationNonterminalHeader(ASTNodeInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationNonterminalHeader", 10)) {
            Modifiers temp_mods = getMods();
            if (w.visitNodeField("mods", temp_mods)) {
                w.visitUnknownObject(temp_mods);
                w.endNodeField("mods", temp_mods);
            }
            Id temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            List<NonterminalParameter> temp_params = getParams();
            if (w.visitNodeField("params", temp_params)) {
                if (w.visitIterated(temp_params)) {
                    int i_temp_params = 0;
                    for (NonterminalParameter elt_temp_params : temp_params) {
                        if (w.visitIteratedElement(i_temp_params, elt_temp_params)) {
                            if (elt_temp_params == null) w.visitNull();
                            else {
                                elt_temp_params.walk(w);
                            }
                        }
                        i_temp_params++;
                    }
                    w.endIterated(temp_params, i_temp_params);
                }
                w.endNodeField("params", temp_params);
            }
            List<StaticParam> temp_staticParams = getStaticParams();
            if (w.visitNodeField("staticParams", temp_staticParams)) {
                if (w.visitIterated(temp_staticParams)) {
                    int i_temp_staticParams = 0;
                    for (StaticParam elt_temp_staticParams : temp_staticParams) {
                        if (w.visitIteratedElement(i_temp_staticParams, elt_temp_staticParams)) {
                            if (elt_temp_staticParams == null) w.visitNull();
                            else {
                                elt_temp_staticParams.walk(w);
                            }
                        }
                        i_temp_staticParams++;
                    }
                    w.endIterated(temp_staticParams, i_temp_staticParams);
                }
                w.endNodeField("staticParams", temp_staticParams);
            }
            Option<Type> temp_paramType = getParamType();
            if (w.visitNodeField("paramType", temp_paramType)) {
                if (temp_paramType.isNone()) {
                    w.visitEmptyOption(temp_paramType);
                }
                else if (w.visitNonEmptyOption(temp_paramType)) {
                    Type elt_temp_paramType = temp_paramType.unwrap();
                    if (elt_temp_paramType == null) w.visitNull();
                    else {
                        elt_temp_paramType.walk(w);
                    }
                    w.endNonEmptyOption(temp_paramType);
                }
                w.endNodeField("paramType", temp_paramType);
            }
            Option<WhereClause> temp_whereClause = getWhereClause();
            if (w.visitNodeField("whereClause", temp_whereClause)) {
                if (temp_whereClause.isNone()) {
                    w.visitEmptyOption(temp_whereClause);
                }
                else if (w.visitNonEmptyOption(temp_whereClause)) {
                    WhereClause elt_temp_whereClause = temp_whereClause.unwrap();
                    if (elt_temp_whereClause == null) w.visitNull();
                    else {
                        elt_temp_whereClause.walk(w);
                    }
                    w.endNonEmptyOption(temp_whereClause);
                }
                w.endNodeField("whereClause", temp_whereClause);
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
            w.endNode(this, "_SyntaxTransformationNonterminalHeader", 10);
        }
    }

}
