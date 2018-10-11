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
 * Class _SyntaxTransformationTry, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationTry extends Try implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationTry.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationTry(Block in_body, Option<Catch> in_catchClause, List<BaseType> in_forbidClause, Option<Block> in_finallyClause, ExprInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_body, in_catchClause, in_forbidClause, in_finallyClause);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationTry constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationTry constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationTry constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationTry(Block in_body, Option<Catch> in_catchClause, List<BaseType> in_forbidClause, Option<Block> in_finallyClause, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_body, in_catchClause, in_forbidClause, in_finallyClause, NodeFactory.makeExprInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationTry(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationTry(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationTry(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.for_SyntaxTransformationTry(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationTry(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationTry(this);
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
            _SyntaxTransformationTry casted = (_SyntaxTransformationTry) obj;
            Block temp_body = getBody();
            Block casted_body = casted.getBody();
            if (!(temp_body == casted_body || temp_body.equals(casted_body))) return false;
            Option<Catch> temp_catchClause = getCatchClause();
            Option<Catch> casted_catchClause = casted.getCatchClause();
            if (!(temp_catchClause == casted_catchClause || temp_catchClause.equals(casted_catchClause))) return false;
            List<BaseType> temp_forbidClause = getForbidClause();
            List<BaseType> casted_forbidClause = casted.getForbidClause();
            if (!(temp_forbidClause == casted_forbidClause || temp_forbidClause.equals(casted_forbidClause))) return false;
            Option<Block> temp_finallyClause = getFinallyClause();
            Option<Block> casted_finallyClause = casted.getFinallyClause();
            if (!(temp_finallyClause == casted_finallyClause || temp_finallyClause.equals(casted_finallyClause))) return false;
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
        Block temp_body = getBody();
        code ^= temp_body.hashCode();
        Option<Catch> temp_catchClause = getCatchClause();
        code ^= temp_catchClause.hashCode();
        List<BaseType> temp_forbidClause = getForbidClause();
        code ^= temp_forbidClause.hashCode();
        Option<Block> temp_finallyClause = getFinallyClause();
        code ^= temp_finallyClause.hashCode();
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
    protected _SyntaxTransformationTry() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationTry(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationTry(ExprInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationTry", 8)) {
            Block temp_body = getBody();
            if (w.visitNodeField("body", temp_body)) {
                temp_body.walk(w);
                w.endNodeField("body", temp_body);
            }
            Option<Catch> temp_catchClause = getCatchClause();
            if (w.visitNodeField("catchClause", temp_catchClause)) {
                if (temp_catchClause.isNone()) {
                    w.visitEmptyOption(temp_catchClause);
                }
                else if (w.visitNonEmptyOption(temp_catchClause)) {
                    Catch elt_temp_catchClause = temp_catchClause.unwrap();
                    if (elt_temp_catchClause == null) w.visitNull();
                    else {
                        elt_temp_catchClause.walk(w);
                    }
                    w.endNonEmptyOption(temp_catchClause);
                }
                w.endNodeField("catchClause", temp_catchClause);
            }
            List<BaseType> temp_forbidClause = getForbidClause();
            if (w.visitNodeField("forbidClause", temp_forbidClause)) {
                if (w.visitIterated(temp_forbidClause)) {
                    int i_temp_forbidClause = 0;
                    for (BaseType elt_temp_forbidClause : temp_forbidClause) {
                        if (w.visitIteratedElement(i_temp_forbidClause, elt_temp_forbidClause)) {
                            if (elt_temp_forbidClause == null) w.visitNull();
                            else {
                                elt_temp_forbidClause.walk(w);
                            }
                        }
                        i_temp_forbidClause++;
                    }
                    w.endIterated(temp_forbidClause, i_temp_forbidClause);
                }
                w.endNodeField("forbidClause", temp_forbidClause);
            }
            Option<Block> temp_finallyClause = getFinallyClause();
            if (w.visitNodeField("finallyClause", temp_finallyClause)) {
                if (temp_finallyClause.isNone()) {
                    w.visitEmptyOption(temp_finallyClause);
                }
                else if (w.visitNonEmptyOption(temp_finallyClause)) {
                    Block elt_temp_finallyClause = temp_finallyClause.unwrap();
                    if (elt_temp_finallyClause == null) w.visitNull();
                    else {
                        elt_temp_finallyClause.walk(w);
                    }
                    w.endNonEmptyOption(temp_finallyClause);
                }
                w.endNodeField("finallyClause", temp_finallyClause);
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
            w.endNode(this, "_SyntaxTransformationTry", 8);
        }
    }

}
