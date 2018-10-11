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
 * Class _SyntaxTransformationArrowType, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationArrowType extends ArrowType implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationArrowType.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationArrowType(Type in_domain, Type in_range, Effect in_effect, boolean in_io, Option<MethodInfo> in_methodInfo, TypeInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_domain, in_range, in_effect, in_io, in_methodInfo);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationArrowType constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationArrowType constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationArrowType constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationArrowType(Type in_domain, Type in_range, Effect in_effect, boolean in_io, Option<MethodInfo> in_methodInfo, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_domain, in_range, in_effect, in_io, in_methodInfo, NodeFactory.makeTypeInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationArrowType(Type in_domain, Type in_range, Effect in_effect, boolean in_io, TypeInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_domain, in_range, in_effect, in_io, Option.<MethodInfo>none(), in_info, in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationArrowType(Type in_domain, Type in_range, Effect in_effect, boolean in_io, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_domain, in_range, in_effect, in_io, Option.<MethodInfo>none(), NodeFactory.makeTypeInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(TypeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationArrowType(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationArrowType(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationArrowType(this);
    }

    public void accept(TypeVisitor_void visitor) {
        visitor.for_SyntaxTransformationArrowType(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationArrowType(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationArrowType(this);
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
            _SyntaxTransformationArrowType casted = (_SyntaxTransformationArrowType) obj;
            Type temp_domain = getDomain();
            Type casted_domain = casted.getDomain();
            if (!(temp_domain == casted_domain || temp_domain.equals(casted_domain))) return false;
            Type temp_range = getRange();
            Type casted_range = casted.getRange();
            if (!(temp_range == casted_range || temp_range.equals(casted_range))) return false;
            Effect temp_effect = getEffect();
            Effect casted_effect = casted.getEffect();
            if (!(temp_effect == casted_effect || temp_effect.equals(casted_effect))) return false;
            boolean temp_io = isIo();
            boolean casted_io = casted.isIo();
            if (!(temp_io == casted_io)) return false;
            Option<MethodInfo> temp_methodInfo = getMethodInfo();
            Option<MethodInfo> casted_methodInfo = casted.getMethodInfo();
            if (!(temp_methodInfo == casted_methodInfo || temp_methodInfo.equals(casted_methodInfo))) return false;
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
        Type temp_domain = getDomain();
        code ^= temp_domain.hashCode();
        Type temp_range = getRange();
        code ^= temp_range.hashCode();
        Effect temp_effect = getEffect();
        code ^= temp_effect.hashCode();
        boolean temp_io = isIo();
        code ^= temp_io ? 1231 : 1237;
        Option<MethodInfo> temp_methodInfo = getMethodInfo();
        code ^= temp_methodInfo.hashCode();
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
    protected _SyntaxTransformationArrowType() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationArrowType(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationArrowType(TypeInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationArrowType", 9)) {
            Type temp_domain = getDomain();
            if (w.visitNodeField("domain", temp_domain)) {
                temp_domain.walk(w);
                w.endNodeField("domain", temp_domain);
            }
            Type temp_range = getRange();
            if (w.visitNodeField("range", temp_range)) {
                temp_range.walk(w);
                w.endNodeField("range", temp_range);
            }
            Effect temp_effect = getEffect();
            if (w.visitNodeField("effect", temp_effect)) {
                temp_effect.walk(w);
                w.endNodeField("effect", temp_effect);
            }
            boolean temp_io = isIo();
            if (w.visitNodeField("io", temp_io)) {
                w.visitBoolean(temp_io);
                w.endNodeField("io", temp_io);
            }
            Option<MethodInfo> temp_methodInfo = getMethodInfo();
            if (w.visitNodeField("methodInfo", temp_methodInfo)) {
                if (temp_methodInfo.isNone()) {
                    w.visitEmptyOption(temp_methodInfo);
                }
                else if (w.visitNonEmptyOption(temp_methodInfo)) {
                    MethodInfo elt_temp_methodInfo = temp_methodInfo.unwrap();
                    if (elt_temp_methodInfo == null) w.visitNull();
                    else {
                        elt_temp_methodInfo.walk(w);
                    }
                    w.endNonEmptyOption(temp_methodInfo);
                }
                w.endNodeField("methodInfo", temp_methodInfo);
            }
            TypeInfo temp_info = getInfo();
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
            w.endNode(this, "_SyntaxTransformationArrowType", 9);
        }
    }

}
