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
 * Class UnitDecl, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class UnitDecl extends DimUnitDecl {
    private final boolean _si_unit;
    private final List<Id> _units;
    private final Option<Type> _dimType;
    private final Option<Expr> _defExpr;

    /**
     * Constructs a UnitDecl.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public UnitDecl(ASTNodeInfo in_info, boolean in_si_unit, List<Id> in_units, Option<Type> in_dimType, Option<Expr> in_defExpr) {
        super(in_info);
        _si_unit = in_si_unit;
        if (in_units == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'units' to the UnitDecl constructor was null");
        }
        _units = in_units;
        if (in_dimType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'dimType' to the UnitDecl constructor was null");
        }
        _dimType = in_dimType;
        if (in_defExpr == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'defExpr' to the UnitDecl constructor was null");
        }
        _defExpr = in_defExpr;
    }

    final public boolean isSi_unit() { return _si_unit; }
    final public List<Id> getUnits() { return _units; }
    final public Option<Type> getDimType() { return _dimType; }
    final public Option<Expr> getDefExpr() { return _defExpr; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forUnitDecl(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forUnitDecl(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forUnitDecl(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forUnitDecl(this);
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
            UnitDecl casted = (UnitDecl) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
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
        ASTNodeInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        boolean temp_si_unit = isSi_unit();
        code ^= temp_si_unit ? 1231 : 1237;
        List<Id> temp_units = getUnits();
        code ^= temp_units.hashCode();
        Option<Type> temp_dimType = getDimType();
        code ^= temp_dimType.hashCode();
        Option<Expr> temp_defExpr = getDefExpr();
        code ^= temp_defExpr.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected UnitDecl() {
        _si_unit = false;
        _units = null;
        _dimType = null;
        _defExpr = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected UnitDecl(ASTNodeInfo info) {
        super(info);
        _si_unit = false;
        _units = null;
        _dimType = null;
        _defExpr = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "UnitDecl", 5)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
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
            w.endNode(this, "UnitDecl", 5);
        }
    }

}
