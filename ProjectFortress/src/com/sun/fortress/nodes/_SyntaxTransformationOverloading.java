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
 * Class _SyntaxTransformationOverloading, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationOverloading extends Overloading implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationOverloading.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationOverloading(IdOrOp in_unambiguousName, IdOrOp in_originalName, Option<ArrowType> in_type, Option<ArrowType> in_schema, ASTNodeInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_unambiguousName, in_originalName, in_type, in_schema);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationOverloading constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationOverloading constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationOverloading constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationOverloading(IdOrOp in_unambiguousName, IdOrOp in_originalName, Option<ArrowType> in_type, Option<ArrowType> in_schema, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_unambiguousName, in_originalName, in_type, in_schema, NodeFactory.makeASTNodeInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationOverloading(IdOrOp in_unambiguousName, IdOrOp in_originalName, Option<ArrowType> in_type, ASTNodeInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_unambiguousName, in_originalName, in_type, Option.<ArrowType>none(), in_info, in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationOverloading(IdOrOp in_unambiguousName, IdOrOp in_originalName, Option<ArrowType> in_type, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_unambiguousName, in_originalName, in_type, Option.<ArrowType>none(), NodeFactory.makeASTNodeInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationOverloading(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationOverloading(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationOverloading(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationOverloading(this);
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
            _SyntaxTransformationOverloading casted = (_SyntaxTransformationOverloading) obj;
            IdOrOp temp_unambiguousName = getUnambiguousName();
            IdOrOp casted_unambiguousName = casted.getUnambiguousName();
            if (!(temp_unambiguousName == casted_unambiguousName || temp_unambiguousName.equals(casted_unambiguousName))) return false;
            IdOrOp temp_originalName = getOriginalName();
            IdOrOp casted_originalName = casted.getOriginalName();
            if (!(temp_originalName == casted_originalName || temp_originalName.equals(casted_originalName))) return false;
            Option<ArrowType> temp_type = getType();
            Option<ArrowType> casted_type = casted.getType();
            if (!(temp_type == casted_type || temp_type.equals(casted_type))) return false;
            Option<ArrowType> temp_schema = getSchema();
            Option<ArrowType> casted_schema = casted.getSchema();
            if (!(temp_schema == casted_schema || temp_schema.equals(casted_schema))) return false;
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
        IdOrOp temp_unambiguousName = getUnambiguousName();
        code ^= temp_unambiguousName.hashCode();
        IdOrOp temp_originalName = getOriginalName();
        code ^= temp_originalName.hashCode();
        Option<ArrowType> temp_type = getType();
        code ^= temp_type.hashCode();
        Option<ArrowType> temp_schema = getSchema();
        code ^= temp_schema.hashCode();
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
    protected _SyntaxTransformationOverloading() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationOverloading(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationOverloading(ASTNodeInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationOverloading", 8)) {
            IdOrOp temp_unambiguousName = getUnambiguousName();
            if (w.visitNodeField("unambiguousName", temp_unambiguousName)) {
                temp_unambiguousName.walk(w);
                w.endNodeField("unambiguousName", temp_unambiguousName);
            }
            IdOrOp temp_originalName = getOriginalName();
            if (w.visitNodeField("originalName", temp_originalName)) {
                temp_originalName.walk(w);
                w.endNodeField("originalName", temp_originalName);
            }
            Option<ArrowType> temp_type = getType();
            if (w.visitNodeField("type", temp_type)) {
                if (temp_type.isNone()) {
                    w.visitEmptyOption(temp_type);
                }
                else if (w.visitNonEmptyOption(temp_type)) {
                    ArrowType elt_temp_type = temp_type.unwrap();
                    if (elt_temp_type == null) w.visitNull();
                    else {
                        elt_temp_type.walk(w);
                    }
                    w.endNonEmptyOption(temp_type);
                }
                w.endNodeField("type", temp_type);
            }
            Option<ArrowType> temp_schema = getSchema();
            if (w.visitNodeField("schema", temp_schema)) {
                if (temp_schema.isNone()) {
                    w.visitEmptyOption(temp_schema);
                }
                else if (w.visitNonEmptyOption(temp_schema)) {
                    ArrowType elt_temp_schema = temp_schema.unwrap();
                    if (elt_temp_schema == null) w.visitNull();
                    else {
                        elt_temp_schema.walk(w);
                    }
                    w.endNonEmptyOption(temp_schema);
                }
                w.endNodeField("schema", temp_schema);
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
            w.endNode(this, "_SyntaxTransformationOverloading", 8);
        }
    }

}
