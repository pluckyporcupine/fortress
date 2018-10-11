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
 * Class _SyntaxTransformationContract, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationContract extends Contract implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationContract.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationContract(Option<List<Expr>> in_requiresClause, Option<List<EnsuresClause>> in_ensuresClause, Option<List<Expr>> in_invariantsClause, ASTNodeInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_requiresClause, in_ensuresClause, in_invariantsClause);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationContract constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationContract constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationContract constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationContract(Option<List<Expr>> in_requiresClause, Option<List<EnsuresClause>> in_ensuresClause, Option<List<Expr>> in_invariantsClause, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_requiresClause, in_ensuresClause, in_invariantsClause, NodeFactory.makeASTNodeInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationContract(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationContract(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationContract(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationContract(this);
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
            _SyntaxTransformationContract casted = (_SyntaxTransformationContract) obj;
            Option<List<Expr>> temp_requiresClause = getRequiresClause();
            Option<List<Expr>> casted_requiresClause = casted.getRequiresClause();
            if (!(temp_requiresClause == casted_requiresClause || temp_requiresClause.equals(casted_requiresClause))) return false;
            Option<List<EnsuresClause>> temp_ensuresClause = getEnsuresClause();
            Option<List<EnsuresClause>> casted_ensuresClause = casted.getEnsuresClause();
            if (!(temp_ensuresClause == casted_ensuresClause || temp_ensuresClause.equals(casted_ensuresClause))) return false;
            Option<List<Expr>> temp_invariantsClause = getInvariantsClause();
            Option<List<Expr>> casted_invariantsClause = casted.getInvariantsClause();
            if (!(temp_invariantsClause == casted_invariantsClause || temp_invariantsClause.equals(casted_invariantsClause))) return false;
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
        Option<List<Expr>> temp_requiresClause = getRequiresClause();
        code ^= temp_requiresClause.hashCode();
        Option<List<EnsuresClause>> temp_ensuresClause = getEnsuresClause();
        code ^= temp_ensuresClause.hashCode();
        Option<List<Expr>> temp_invariantsClause = getInvariantsClause();
        code ^= temp_invariantsClause.hashCode();
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
    protected _SyntaxTransformationContract() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationContract(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationContract(ASTNodeInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationContract", 7)) {
            Option<List<Expr>> temp_requiresClause = getRequiresClause();
            if (w.visitNodeField("requiresClause", temp_requiresClause)) {
                if (temp_requiresClause.isNone()) {
                    w.visitEmptyOption(temp_requiresClause);
                }
                else if (w.visitNonEmptyOption(temp_requiresClause)) {
                    List<Expr> elt_temp_requiresClause = temp_requiresClause.unwrap();
                    if (elt_temp_requiresClause == null) w.visitNull();
                    else {
                        if (w.visitIterated(elt_temp_requiresClause)) {
                            int i_elt_temp_requiresClause = 0;
                            for (Expr elt_elt_temp_requiresClause : elt_temp_requiresClause) {
                                if (w.visitIteratedElement(i_elt_temp_requiresClause, elt_elt_temp_requiresClause)) {
                                    if (elt_elt_temp_requiresClause == null) w.visitNull();
                                    else {
                                        elt_elt_temp_requiresClause.walk(w);
                                    }
                                }
                                i_elt_temp_requiresClause++;
                            }
                            w.endIterated(elt_temp_requiresClause, i_elt_temp_requiresClause);
                        }
                    }
                    w.endNonEmptyOption(temp_requiresClause);
                }
                w.endNodeField("requiresClause", temp_requiresClause);
            }
            Option<List<EnsuresClause>> temp_ensuresClause = getEnsuresClause();
            if (w.visitNodeField("ensuresClause", temp_ensuresClause)) {
                if (temp_ensuresClause.isNone()) {
                    w.visitEmptyOption(temp_ensuresClause);
                }
                else if (w.visitNonEmptyOption(temp_ensuresClause)) {
                    List<EnsuresClause> elt_temp_ensuresClause = temp_ensuresClause.unwrap();
                    if (elt_temp_ensuresClause == null) w.visitNull();
                    else {
                        if (w.visitIterated(elt_temp_ensuresClause)) {
                            int i_elt_temp_ensuresClause = 0;
                            for (EnsuresClause elt_elt_temp_ensuresClause : elt_temp_ensuresClause) {
                                if (w.visitIteratedElement(i_elt_temp_ensuresClause, elt_elt_temp_ensuresClause)) {
                                    if (elt_elt_temp_ensuresClause == null) w.visitNull();
                                    else {
                                        elt_elt_temp_ensuresClause.walk(w);
                                    }
                                }
                                i_elt_temp_ensuresClause++;
                            }
                            w.endIterated(elt_temp_ensuresClause, i_elt_temp_ensuresClause);
                        }
                    }
                    w.endNonEmptyOption(temp_ensuresClause);
                }
                w.endNodeField("ensuresClause", temp_ensuresClause);
            }
            Option<List<Expr>> temp_invariantsClause = getInvariantsClause();
            if (w.visitNodeField("invariantsClause", temp_invariantsClause)) {
                if (temp_invariantsClause.isNone()) {
                    w.visitEmptyOption(temp_invariantsClause);
                }
                else if (w.visitNonEmptyOption(temp_invariantsClause)) {
                    List<Expr> elt_temp_invariantsClause = temp_invariantsClause.unwrap();
                    if (elt_temp_invariantsClause == null) w.visitNull();
                    else {
                        if (w.visitIterated(elt_temp_invariantsClause)) {
                            int i_elt_temp_invariantsClause = 0;
                            for (Expr elt_elt_temp_invariantsClause : elt_temp_invariantsClause) {
                                if (w.visitIteratedElement(i_elt_temp_invariantsClause, elt_elt_temp_invariantsClause)) {
                                    if (elt_elt_temp_invariantsClause == null) w.visitNull();
                                    else {
                                        elt_elt_temp_invariantsClause.walk(w);
                                    }
                                }
                                i_elt_temp_invariantsClause++;
                            }
                            w.endIterated(elt_temp_invariantsClause, i_elt_temp_invariantsClause);
                        }
                    }
                    w.endNonEmptyOption(temp_invariantsClause);
                }
                w.endNodeField("invariantsClause", temp_invariantsClause);
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
            w.endNode(this, "_SyntaxTransformationContract", 7);
        }
    }

}
