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
 * Class _SyntaxTransformationUnitDecl, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationUnitDecl extends UnitDecl implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationUnitDecl.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationUnitDecl(boolean in_si_unit, List<Id> in_units, Option<Type> in_dimType, Option<Expr> in_defExpr, ASTNodeInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_si_unit, in_units, in_dimType, in_defExpr);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationUnitDecl constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationUnitDecl constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationUnitDecl constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationUnitDecl(boolean in_si_unit, List<Id> in_units, Option<Type> in_dimType, Option<Expr> in_defExpr, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_si_unit, in_units, in_dimType, in_defExpr, NodeFactory.makeASTNodeInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationUnitDecl(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationUnitDecl(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationUnitDecl(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationUnitDecl(this);
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
            _SyntaxTransformationUnitDecl casted = (_SyntaxTransformationUnitDecl) obj;
            boolean temp_si_unit = isSi_unit();
            boolean casted_si_unit = casted.isSi_unit();
            if (!(temp_si_unit == casted_si_unit)) return false;
            List<Id> temp_units = getUnits();
            List<Id> casted_units = casted.getUnits();
            if (!(temp_units == casted_units || temp_units.equals(casted_units))) return false;
            Option<Type> temp_dimType = getDimType();
            Option<Type> casted_dimType = casted.getDimType();
            if (!(temp_dimType == casted_dimType || temp_dimType.equals(casted_dimType))) return false;
            Option<Expr> temp_defExpr = getDefExpr();
            Option<Expr> casted_defExpr = casted.getDefExpr();
            if (!(temp_defExpr == casted_defExpr || temp_defExpr.equals(casted_defExpr))) return false;
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
        boolean temp_si_unit = isSi_unit();
        code ^= temp_si_unit ? 1231 : 1237;
        List<Id> temp_units = getUnits();
        code ^= temp_units.hashCode();
        Option<Type> temp_dimType = getDimType();
        code ^= temp_dimType.hashCode();
        Option<Expr> temp_defExpr = getDefExpr();
        code ^= temp_defExpr.hashCode();
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
    protected _SyntaxTransformationUnitDecl() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationUnitDecl(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationUnitDecl(ASTNodeInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationUnitDecl", 8)) {
            boolean temp_si_unit = isSi_unit();
            if (w.visitNodeField("si_unit", temp_si_unit)) {
                w.visitBoolean(temp_si_unit);
                w.endNodeField("si_unit", temp_si_unit);
            }
            List<Id> temp_units = getUnits();
            if (w.visitNodeField("units", temp_units)) {
                if (w.visitIterated(temp_units)) {
                    int i_temp_units = 0;
                    for (Id elt_temp_units : temp_units) {
                        if (w.visitIteratedElement(i_temp_units, elt_temp_units)) {
                            if (elt_temp_units == null) w.visitNull();
                            else {
                                elt_temp_units.walk(w);
                            }
                        }
                        i_temp_units++;
                    }
                    w.endIterated(temp_units, i_temp_units);
                }
                w.endNodeField("units", temp_units);
            }
            Option<Type> temp_dimType = getDimType();
            if (w.visitNodeField("dimType", temp_dimType)) {
                if (temp_dimType.isNone()) {
                    w.visitEmptyOption(temp_dimType);
                }
                else if (w.visitNonEmptyOption(temp_dimType)) {
                    Type elt_temp_dimType = temp_dimType.unwrap();
                    if (elt_temp_dimType == null) w.visitNull();
                    else {
                        elt_temp_dimType.walk(w);
                    }
                    w.endNonEmptyOption(temp_dimType);
                }
                w.endNodeField("dimType", temp_dimType);
            }
            Option<Expr> temp_defExpr = getDefExpr();
            if (w.visitNodeField("defExpr", temp_defExpr)) {
                if (temp_defExpr.isNone()) {
                    w.visitEmptyOption(temp_defExpr);
                }
                else if (w.visitNonEmptyOption(temp_defExpr)) {
                    Expr elt_temp_defExpr = temp_defExpr.unwrap();
                    if (elt_temp_defExpr == null) w.visitNull();
                    else {
                        elt_temp_defExpr.walk(w);
                    }
                    w.endNonEmptyOption(temp_defExpr);
                }
                w.endNodeField("defExpr", temp_defExpr);
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
            w.endNode(this, "_SyntaxTransformationUnitDecl", 8);
        }
    }

}
