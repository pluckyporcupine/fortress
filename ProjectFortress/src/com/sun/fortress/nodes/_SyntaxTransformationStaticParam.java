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
 * Class _SyntaxTransformationStaticParam, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationStaticParam extends StaticParam implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationStaticParam.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationStaticParam(int in_variance, IdOrOp in_name, List<BaseType> in_extendsClause, List<BaseType> in_dominatesClause, Option<Type> in_dimParam, boolean in_absorbsParam, StaticParamKind in_kind, boolean in_lifted, ASTNodeInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_variance, in_name, in_extendsClause, in_dominatesClause, in_dimParam, in_absorbsParam, in_kind, in_lifted);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationStaticParam constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationStaticParam constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationStaticParam constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationStaticParam(int in_variance, IdOrOp in_name, List<BaseType> in_extendsClause, List<BaseType> in_dominatesClause, Option<Type> in_dimParam, boolean in_absorbsParam, StaticParamKind in_kind, boolean in_lifted, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_variance, in_name, in_extendsClause, in_dominatesClause, in_dimParam, in_absorbsParam, in_kind, in_lifted, NodeFactory.makeASTNodeInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationStaticParam(int in_variance, IdOrOp in_name, List<BaseType> in_extendsClause, List<BaseType> in_dominatesClause, Option<Type> in_dimParam, boolean in_absorbsParam, StaticParamKind in_kind, ASTNodeInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_variance, in_name, in_extendsClause, in_dominatesClause, in_dimParam, in_absorbsParam, in_kind, false, in_info, in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationStaticParam(int in_variance, IdOrOp in_name, List<BaseType> in_extendsClause, List<BaseType> in_dominatesClause, Option<Type> in_dimParam, boolean in_absorbsParam, StaticParamKind in_kind, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_variance, in_name, in_extendsClause, in_dominatesClause, in_dimParam, in_absorbsParam, in_kind, false, NodeFactory.makeASTNodeInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationStaticParam(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationStaticParam(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationStaticParam(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationStaticParam(this);
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
            _SyntaxTransformationStaticParam casted = (_SyntaxTransformationStaticParam) obj;
            int temp_variance = getVariance();
            int casted_variance = casted.getVariance();
            if (!(temp_variance == casted_variance)) return false;
            IdOrOp temp_name = getName();
            IdOrOp casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            List<BaseType> temp_extendsClause = getExtendsClause();
            List<BaseType> casted_extendsClause = casted.getExtendsClause();
            if (!(temp_extendsClause == casted_extendsClause || temp_extendsClause.equals(casted_extendsClause))) return false;
            List<BaseType> temp_dominatesClause = getDominatesClause();
            List<BaseType> casted_dominatesClause = casted.getDominatesClause();
            if (!(temp_dominatesClause == casted_dominatesClause || temp_dominatesClause.equals(casted_dominatesClause))) return false;
            Option<Type> temp_dimParam = getDimParam();
            Option<Type> casted_dimParam = casted.getDimParam();
            if (!(temp_dimParam == casted_dimParam || temp_dimParam.equals(casted_dimParam))) return false;
            boolean temp_absorbsParam = isAbsorbsParam();
            boolean casted_absorbsParam = casted.isAbsorbsParam();
            if (!(temp_absorbsParam == casted_absorbsParam)) return false;
            StaticParamKind temp_kind = getKind();
            StaticParamKind casted_kind = casted.getKind();
            if (!(temp_kind == casted_kind || temp_kind.equals(casted_kind))) return false;
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
        int temp_variance = getVariance();
        code ^= temp_variance;
        IdOrOp temp_name = getName();
        code ^= temp_name.hashCode();
        List<BaseType> temp_extendsClause = getExtendsClause();
        code ^= temp_extendsClause.hashCode();
        List<BaseType> temp_dominatesClause = getDominatesClause();
        code ^= temp_dominatesClause.hashCode();
        Option<Type> temp_dimParam = getDimParam();
        code ^= temp_dimParam.hashCode();
        boolean temp_absorbsParam = isAbsorbsParam();
        code ^= temp_absorbsParam ? 1231 : 1237;
        StaticParamKind temp_kind = getKind();
        code ^= temp_kind.hashCode();
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
    protected _SyntaxTransformationStaticParam() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationStaticParam(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationStaticParam(ASTNodeInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationStaticParam", 12)) {
            int temp_variance = getVariance();
            if (w.visitNodeField("variance", temp_variance)) {
                w.visitInt(temp_variance);
                w.endNodeField("variance", temp_variance);
            }
            IdOrOp temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            List<BaseType> temp_extendsClause = getExtendsClause();
            if (w.visitNodeField("extendsClause", temp_extendsClause)) {
                if (w.visitIterated(temp_extendsClause)) {
                    int i_temp_extendsClause = 0;
                    for (BaseType elt_temp_extendsClause : temp_extendsClause) {
                        if (w.visitIteratedElement(i_temp_extendsClause, elt_temp_extendsClause)) {
                            if (elt_temp_extendsClause == null) w.visitNull();
                            else {
                                elt_temp_extendsClause.walk(w);
                            }
                        }
                        i_temp_extendsClause++;
                    }
                    w.endIterated(temp_extendsClause, i_temp_extendsClause);
                }
                w.endNodeField("extendsClause", temp_extendsClause);
            }
            List<BaseType> temp_dominatesClause = getDominatesClause();
            if (w.visitNodeField("dominatesClause", temp_dominatesClause)) {
                if (w.visitIterated(temp_dominatesClause)) {
                    int i_temp_dominatesClause = 0;
                    for (BaseType elt_temp_dominatesClause : temp_dominatesClause) {
                        if (w.visitIteratedElement(i_temp_dominatesClause, elt_temp_dominatesClause)) {
                            if (elt_temp_dominatesClause == null) w.visitNull();
                            else {
                                elt_temp_dominatesClause.walk(w);
                            }
                        }
                        i_temp_dominatesClause++;
                    }
                    w.endIterated(temp_dominatesClause, i_temp_dominatesClause);
                }
                w.endNodeField("dominatesClause", temp_dominatesClause);
            }
            Option<Type> temp_dimParam = getDimParam();
            if (w.visitNodeField("dimParam", temp_dimParam)) {
                if (temp_dimParam.isNone()) {
                    w.visitEmptyOption(temp_dimParam);
                }
                else if (w.visitNonEmptyOption(temp_dimParam)) {
                    Type elt_temp_dimParam = temp_dimParam.unwrap();
                    if (elt_temp_dimParam == null) w.visitNull();
                    else {
                        elt_temp_dimParam.walk(w);
                    }
                    w.endNonEmptyOption(temp_dimParam);
                }
                w.endNodeField("dimParam", temp_dimParam);
            }
            boolean temp_absorbsParam = isAbsorbsParam();
            if (w.visitNodeField("absorbsParam", temp_absorbsParam)) {
                w.visitBoolean(temp_absorbsParam);
                w.endNodeField("absorbsParam", temp_absorbsParam);
            }
            StaticParamKind temp_kind = getKind();
            if (w.visitNodeField("kind", temp_kind)) {
                temp_kind.walk(w);
                w.endNodeField("kind", temp_kind);
            }
            boolean temp_lifted = isLifted();
            if (w.visitNodeField("lifted", temp_lifted)) {
                w.visitBoolean(temp_lifted);
                w.endNodeField("lifted", temp_lifted);
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
            w.endNode(this, "_SyntaxTransformationStaticParam", 12);
        }
    }

}
