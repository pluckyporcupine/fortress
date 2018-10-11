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
 * Class _SyntaxTransformationOpRef, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationOpRef extends OpRef implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationOpRef.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationOpRef(List<StaticArg> in_staticArgs, int in_lexicalDepth, IdOrOp in_originalName, List<IdOrOp> in_names, List<Overloading> in_interpOverloadings, List<Overloading> in_newOverloadings, Option<Type> in_overloadingType, Option<Type> in_overloadingSchema, ExprInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_staticArgs, in_lexicalDepth, in_originalName, in_names, in_interpOverloadings, in_newOverloadings, in_overloadingType, in_overloadingSchema);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationOpRef constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationOpRef constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationOpRef constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationOpRef(List<StaticArg> in_staticArgs, int in_lexicalDepth, IdOrOp in_originalName, List<IdOrOp> in_names, List<Overloading> in_interpOverloadings, List<Overloading> in_newOverloadings, Option<Type> in_overloadingType, Option<Type> in_overloadingSchema, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_staticArgs, in_lexicalDepth, in_originalName, in_names, in_interpOverloadings, in_newOverloadings, in_overloadingType, in_overloadingSchema, NodeFactory.makeExprInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationOpRef(List<StaticArg> in_staticArgs, int in_lexicalDepth, IdOrOp in_originalName, List<IdOrOp> in_names, List<Overloading> in_interpOverloadings, List<Overloading> in_newOverloadings, Option<Type> in_overloadingType, ExprInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_staticArgs, in_lexicalDepth, in_originalName, in_names, in_interpOverloadings, in_newOverloadings, in_overloadingType, Option.<Type>none(), in_info, in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationOpRef(List<StaticArg> in_staticArgs, int in_lexicalDepth, IdOrOp in_originalName, List<IdOrOp> in_names, List<Overloading> in_interpOverloadings, List<Overloading> in_newOverloadings, Option<Type> in_overloadingType, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_staticArgs, in_lexicalDepth, in_originalName, in_names, in_interpOverloadings, in_newOverloadings, in_overloadingType, Option.<Type>none(), NodeFactory.makeExprInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationOpRef(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationOpRef(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationOpRef(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.for_SyntaxTransformationOpRef(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationOpRef(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationOpRef(this);
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
            _SyntaxTransformationOpRef casted = (_SyntaxTransformationOpRef) obj;
            List<StaticArg> temp_staticArgs = getStaticArgs();
            List<StaticArg> casted_staticArgs = casted.getStaticArgs();
            if (!(temp_staticArgs == casted_staticArgs || temp_staticArgs.equals(casted_staticArgs))) return false;
            int temp_lexicalDepth = getLexicalDepth();
            int casted_lexicalDepth = casted.getLexicalDepth();
            if (!(temp_lexicalDepth == casted_lexicalDepth)) return false;
            IdOrOp temp_originalName = getOriginalName();
            IdOrOp casted_originalName = casted.getOriginalName();
            if (!(temp_originalName == casted_originalName || temp_originalName.equals(casted_originalName))) return false;
            List<IdOrOp> temp_names = getNames();
            List<IdOrOp> casted_names = casted.getNames();
            if (!(temp_names == casted_names || temp_names.equals(casted_names))) return false;
            List<Overloading> temp_interpOverloadings = getInterpOverloadings();
            List<Overloading> casted_interpOverloadings = casted.getInterpOverloadings();
            if (!(temp_interpOverloadings == casted_interpOverloadings || temp_interpOverloadings.equals(casted_interpOverloadings))) return false;
            List<Overloading> temp_newOverloadings = getNewOverloadings();
            List<Overloading> casted_newOverloadings = casted.getNewOverloadings();
            if (!(temp_newOverloadings == casted_newOverloadings || temp_newOverloadings.equals(casted_newOverloadings))) return false;
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
        List<StaticArg> temp_staticArgs = getStaticArgs();
        code ^= temp_staticArgs.hashCode();
        int temp_lexicalDepth = getLexicalDepth();
        code ^= temp_lexicalDepth;
        IdOrOp temp_originalName = getOriginalName();
        code ^= temp_originalName.hashCode();
        List<IdOrOp> temp_names = getNames();
        code ^= temp_names.hashCode();
        List<Overloading> temp_interpOverloadings = getInterpOverloadings();
        code ^= temp_interpOverloadings.hashCode();
        List<Overloading> temp_newOverloadings = getNewOverloadings();
        code ^= temp_newOverloadings.hashCode();
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
    protected _SyntaxTransformationOpRef() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationOpRef(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationOpRef(ExprInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationOpRef", 12)) {
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
            int temp_lexicalDepth = getLexicalDepth();
            if (w.visitNodeField("lexicalDepth", temp_lexicalDepth)) {
                w.visitInt(temp_lexicalDepth);
                w.endNodeField("lexicalDepth", temp_lexicalDepth);
            }
            IdOrOp temp_originalName = getOriginalName();
            if (w.visitNodeField("originalName", temp_originalName)) {
                temp_originalName.walk(w);
                w.endNodeField("originalName", temp_originalName);
            }
            List<IdOrOp> temp_names = getNames();
            if (w.visitNodeField("names", temp_names)) {
                if (w.visitIterated(temp_names)) {
                    int i_temp_names = 0;
                    for (IdOrOp elt_temp_names : temp_names) {
                        if (w.visitIteratedElement(i_temp_names, elt_temp_names)) {
                            if (elt_temp_names == null) w.visitNull();
                            else {
                                elt_temp_names.walk(w);
                            }
                        }
                        i_temp_names++;
                    }
                    w.endIterated(temp_names, i_temp_names);
                }
                w.endNodeField("names", temp_names);
            }
            List<Overloading> temp_interpOverloadings = getInterpOverloadings();
            if (w.visitNodeField("interpOverloadings", temp_interpOverloadings)) {
                if (w.visitIterated(temp_interpOverloadings)) {
                    int i_temp_interpOverloadings = 0;
                    for (Overloading elt_temp_interpOverloadings : temp_interpOverloadings) {
                        if (w.visitIteratedElement(i_temp_interpOverloadings, elt_temp_interpOverloadings)) {
                            if (elt_temp_interpOverloadings == null) w.visitNull();
                            else {
                                elt_temp_interpOverloadings.walk(w);
                            }
                        }
                        i_temp_interpOverloadings++;
                    }
                    w.endIterated(temp_interpOverloadings, i_temp_interpOverloadings);
                }
                w.endNodeField("interpOverloadings", temp_interpOverloadings);
            }
            List<Overloading> temp_newOverloadings = getNewOverloadings();
            if (w.visitNodeField("newOverloadings", temp_newOverloadings)) {
                if (w.visitIterated(temp_newOverloadings)) {
                    int i_temp_newOverloadings = 0;
                    for (Overloading elt_temp_newOverloadings : temp_newOverloadings) {
                        if (w.visitIteratedElement(i_temp_newOverloadings, elt_temp_newOverloadings)) {
                            if (elt_temp_newOverloadings == null) w.visitNull();
                            else {
                                elt_temp_newOverloadings.walk(w);
                            }
                        }
                        i_temp_newOverloadings++;
                    }
                    w.endIterated(temp_newOverloadings, i_temp_newOverloadings);
                }
                w.endNodeField("newOverloadings", temp_newOverloadings);
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
            w.endNode(this, "_SyntaxTransformationOpRef", 12);
        }
    }

}
