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
 * Class _SyntaxTransformationNamedOp, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationNamedOp extends NamedOp implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationNamedOp.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationNamedOp(Option<APIName> in_apiName, String in_text, Fixity in_fixity, boolean in_enclosing, ASTNodeInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_apiName, in_text, in_fixity, in_enclosing);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationNamedOp constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationNamedOp constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationNamedOp constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationNamedOp(Option<APIName> in_apiName, String in_text, Fixity in_fixity, boolean in_enclosing, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_apiName, in_text, in_fixity, in_enclosing, NodeFactory.makeASTNodeInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationNamedOp(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationNamedOp(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationNamedOp(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationNamedOp(this);
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
            _SyntaxTransformationNamedOp casted = (_SyntaxTransformationNamedOp) obj;
            Option<APIName> temp_apiName = getApiName();
            Option<APIName> casted_apiName = casted.getApiName();
            if (!(temp_apiName == casted_apiName || temp_apiName.equals(casted_apiName))) return false;
            String temp_text = getText();
            String casted_text = casted.getText();
            if (!(temp_text == casted_text)) return false;
            Fixity temp_fixity = getFixity();
            Fixity casted_fixity = casted.getFixity();
            if (!(temp_fixity == casted_fixity || temp_fixity.equals(casted_fixity))) return false;
            boolean temp_enclosing = isEnclosing();
            boolean casted_enclosing = casted.isEnclosing();
            if (!(temp_enclosing == casted_enclosing)) return false;
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
        Option<APIName> temp_apiName = getApiName();
        code ^= temp_apiName.hashCode();
        String temp_text = getText();
        code ^= temp_text.hashCode();
        Fixity temp_fixity = getFixity();
        code ^= temp_fixity.hashCode();
        boolean temp_enclosing = isEnclosing();
        code ^= temp_enclosing ? 1231 : 1237;
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
    protected _SyntaxTransformationNamedOp() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationNamedOp(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationNamedOp(ASTNodeInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationNamedOp", 8)) {
            Option<APIName> temp_apiName = getApiName();
            if (w.visitNodeField("apiName", temp_apiName)) {
                if (temp_apiName.isNone()) {
                    w.visitEmptyOption(temp_apiName);
                }
                else if (w.visitNonEmptyOption(temp_apiName)) {
                    APIName elt_temp_apiName = temp_apiName.unwrap();
                    if (elt_temp_apiName == null) w.visitNull();
                    else {
                        elt_temp_apiName.walk(w);
                    }
                    w.endNonEmptyOption(temp_apiName);
                }
                w.endNodeField("apiName", temp_apiName);
            }
            String temp_text = getText();
            if (w.visitNodeField("text", temp_text)) {
                w.visitString(temp_text);
                w.endNodeField("text", temp_text);
            }
            Fixity temp_fixity = getFixity();
            if (w.visitNodeField("fixity", temp_fixity)) {
                temp_fixity.walk(w);
                w.endNodeField("fixity", temp_fixity);
            }
            boolean temp_enclosing = isEnclosing();
            if (w.visitNodeField("enclosing", temp_enclosing)) {
                w.visitBoolean(temp_enclosing);
                w.endNodeField("enclosing", temp_enclosing);
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
            w.endNode(this, "_SyntaxTransformationNamedOp", 8);
        }
    }

}
