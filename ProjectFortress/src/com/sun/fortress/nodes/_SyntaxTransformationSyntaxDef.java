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
 * Class _SyntaxTransformationSyntaxDef, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationSyntaxDef extends SyntaxDef implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationSyntaxDef.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationSyntaxDef(Option<String> in_modifier, List<SyntaxSymbol> in_syntaxSymbols, TransformerDecl in_transformer, ASTNodeInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_modifier, in_syntaxSymbols, in_transformer);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationSyntaxDef constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationSyntaxDef constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationSyntaxDef constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationSyntaxDef(Option<String> in_modifier, List<SyntaxSymbol> in_syntaxSymbols, TransformerDecl in_transformer, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_modifier, in_syntaxSymbols, in_transformer, NodeFactory.makeASTNodeInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationSyntaxDef(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationSyntaxDef(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationSyntaxDef(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationSyntaxDef(this);
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
            _SyntaxTransformationSyntaxDef casted = (_SyntaxTransformationSyntaxDef) obj;
            Option<String> temp_modifier = getModifier();
            Option<String> casted_modifier = casted.getModifier();
            if (!(temp_modifier == casted_modifier || temp_modifier.equals(casted_modifier))) return false;
            List<SyntaxSymbol> temp_syntaxSymbols = getSyntaxSymbols();
            List<SyntaxSymbol> casted_syntaxSymbols = casted.getSyntaxSymbols();
            if (!(temp_syntaxSymbols == casted_syntaxSymbols || temp_syntaxSymbols.equals(casted_syntaxSymbols))) return false;
            TransformerDecl temp_transformer = getTransformer();
            TransformerDecl casted_transformer = casted.getTransformer();
            if (!(temp_transformer == casted_transformer || temp_transformer.equals(casted_transformer))) return false;
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
        Option<String> temp_modifier = getModifier();
        code ^= temp_modifier.hashCode();
        List<SyntaxSymbol> temp_syntaxSymbols = getSyntaxSymbols();
        code ^= temp_syntaxSymbols.hashCode();
        TransformerDecl temp_transformer = getTransformer();
        code ^= temp_transformer.hashCode();
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
    protected _SyntaxTransformationSyntaxDef() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationSyntaxDef(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationSyntaxDef(ASTNodeInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationSyntaxDef", 7)) {
            Option<String> temp_modifier = getModifier();
            if (w.visitNodeField("modifier", temp_modifier)) {
                if (temp_modifier.isNone()) {
                    w.visitEmptyOption(temp_modifier);
                }
                else if (w.visitNonEmptyOption(temp_modifier)) {
                    String elt_temp_modifier = temp_modifier.unwrap();
                    if (elt_temp_modifier == null) w.visitNull();
                    else {
                        w.visitString(elt_temp_modifier);
                    }
                    w.endNonEmptyOption(temp_modifier);
                }
                w.endNodeField("modifier", temp_modifier);
            }
            List<SyntaxSymbol> temp_syntaxSymbols = getSyntaxSymbols();
            if (w.visitNodeField("syntaxSymbols", temp_syntaxSymbols)) {
                if (w.visitIterated(temp_syntaxSymbols)) {
                    int i_temp_syntaxSymbols = 0;
                    for (SyntaxSymbol elt_temp_syntaxSymbols : temp_syntaxSymbols) {
                        if (w.visitIteratedElement(i_temp_syntaxSymbols, elt_temp_syntaxSymbols)) {
                            if (elt_temp_syntaxSymbols == null) w.visitNull();
                            else {
                                elt_temp_syntaxSymbols.walk(w);
                            }
                        }
                        i_temp_syntaxSymbols++;
                    }
                    w.endIterated(temp_syntaxSymbols, i_temp_syntaxSymbols);
                }
                w.endNodeField("syntaxSymbols", temp_syntaxSymbols);
            }
            TransformerDecl temp_transformer = getTransformer();
            if (w.visitNodeField("transformer", temp_transformer)) {
                temp_transformer.walk(w);
                w.endNodeField("transformer", temp_transformer);
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
            w.endNode(this, "_SyntaxTransformationSyntaxDef", 7);
        }
    }

}
