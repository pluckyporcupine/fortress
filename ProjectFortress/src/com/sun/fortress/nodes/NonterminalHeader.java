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
 * Class NonterminalHeader, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class NonterminalHeader extends AbstractNode {
    private final Modifiers _mods;
    private final Id _name;
    private final List<NonterminalParameter> _params;
    private final List<StaticParam> _staticParams;
    private final Option<Type> _paramType;
    private final Option<WhereClause> _whereClause;

    /**
     * Constructs a NonterminalHeader.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public NonterminalHeader(ASTNodeInfo in_info, Modifiers in_mods, Id in_name, List<NonterminalParameter> in_params, List<StaticParam> in_staticParams, Option<Type> in_paramType, Option<WhereClause> in_whereClause) {
        super(in_info);
        if (in_mods == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'mods' to the NonterminalHeader constructor was null");
        }
        _mods = in_mods;
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the NonterminalHeader constructor was null");
        }
        _name = in_name;
        if (in_params == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'params' to the NonterminalHeader constructor was null");
        }
        _params = in_params;
        if (in_staticParams == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'staticParams' to the NonterminalHeader constructor was null");
        }
        _staticParams = in_staticParams;
        if (in_paramType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'paramType' to the NonterminalHeader constructor was null");
        }
        _paramType = in_paramType;
        if (in_whereClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'whereClause' to the NonterminalHeader constructor was null");
        }
        _whereClause = in_whereClause;
    }

    final public Modifiers getMods() { return _mods; }
    final public Id getName() { return _name; }
    final public List<NonterminalParameter> getParams() { return _params; }
    final public List<StaticParam> getStaticParams() { return _staticParams; }
    final public Option<Type> getParamType() { return _paramType; }
    final public Option<WhereClause> getWhereClause() { return _whereClause; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forNonterminalHeader(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forNonterminalHeader(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forNonterminalHeader(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forNonterminalHeader(this);
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
            NonterminalHeader casted = (NonterminalHeader) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Modifiers temp_mods = getMods();
            Modifiers casted_mods = casted.getMods();
            if (!(temp_mods == casted_mods || temp_mods.equals(casted_mods))) return false;
            Id temp_name = getName();
            Id casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            List<NonterminalParameter> temp_params = getParams();
            List<NonterminalParameter> casted_params = casted.getParams();
            if (!(temp_params == casted_params || temp_params.equals(casted_params))) return false;
            List<StaticParam> temp_staticParams = getStaticParams();
            List<StaticParam> casted_staticParams = casted.getStaticParams();
            if (!(temp_staticParams == casted_staticParams || temp_staticParams.equals(casted_staticParams))) return false;
            Option<Type> temp_paramType = getParamType();
            Option<Type> casted_paramType = casted.getParamType();
            if (!(temp_paramType == casted_paramType || temp_paramType.equals(casted_paramType))) return false;
            Option<WhereClause> temp_whereClause = getWhereClause();
            Option<WhereClause> casted_whereClause = casted.getWhereClause();
            if (!(temp_whereClause == casted_whereClause || temp_whereClause.equals(casted_whereClause))) return false;
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
        Modifiers temp_mods = getMods();
        code ^= temp_mods.hashCode();
        Id temp_name = getName();
        code ^= temp_name.hashCode();
        List<NonterminalParameter> temp_params = getParams();
        code ^= temp_params.hashCode();
        List<StaticParam> temp_staticParams = getStaticParams();
        code ^= temp_staticParams.hashCode();
        Option<Type> temp_paramType = getParamType();
        code ^= temp_paramType.hashCode();
        Option<WhereClause> temp_whereClause = getWhereClause();
        code ^= temp_whereClause.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected NonterminalHeader() {
        _mods = null;
        _name = null;
        _params = null;
        _staticParams = null;
        _paramType = null;
        _whereClause = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected NonterminalHeader(ASTNodeInfo info) {
        super(info);
        _mods = null;
        _name = null;
        _params = null;
        _staticParams = null;
        _paramType = null;
        _whereClause = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "NonterminalHeader", 7)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Modifiers temp_mods = getMods();
            if (w.visitNodeField("mods", temp_mods)) {
                w.visitUnknownObject(temp_mods);
                w.endNodeField("mods", temp_mods);
            }
            Id temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            List<NonterminalParameter> temp_params = getParams();
            if (w.visitNodeField("params", temp_params)) {
                if (w.visitIterated(temp_params)) {
                    int i_temp_params = 0;
                    for (NonterminalParameter elt_temp_params : temp_params) {
                        if (w.visitIteratedElement(i_temp_params, elt_temp_params)) {
                            if (elt_temp_params == null) w.visitNull();
                            else {
                                elt_temp_params.walk(w);
                            }
                        }
                        i_temp_params++;
                    }
                    w.endIterated(temp_params, i_temp_params);
                }
                w.endNodeField("params", temp_params);
            }
            List<StaticParam> temp_staticParams = getStaticParams();
            if (w.visitNodeField("staticParams", temp_staticParams)) {
                if (w.visitIterated(temp_staticParams)) {
                    int i_temp_staticParams = 0;
                    for (StaticParam elt_temp_staticParams : temp_staticParams) {
                        if (w.visitIteratedElement(i_temp_staticParams, elt_temp_staticParams)) {
                            if (elt_temp_staticParams == null) w.visitNull();
                            else {
                                elt_temp_staticParams.walk(w);
                            }
                        }
                        i_temp_staticParams++;
                    }
                    w.endIterated(temp_staticParams, i_temp_staticParams);
                }
                w.endNodeField("staticParams", temp_staticParams);
            }
            Option<Type> temp_paramType = getParamType();
            if (w.visitNodeField("paramType", temp_paramType)) {
                if (temp_paramType.isNone()) {
                    w.visitEmptyOption(temp_paramType);
                }
                else if (w.visitNonEmptyOption(temp_paramType)) {
                    Type elt_temp_paramType = temp_paramType.unwrap();
                    if (elt_temp_paramType == null) w.visitNull();
                    else {
                        elt_temp_paramType.walk(w);
                    }
                    w.endNonEmptyOption(temp_paramType);
                }
                w.endNodeField("paramType", temp_paramType);
            }
            Option<WhereClause> temp_whereClause = getWhereClause();
            if (w.visitNodeField("whereClause", temp_whereClause)) {
                if (temp_whereClause.isNone()) {
                    w.visitEmptyOption(temp_whereClause);
                }
                else if (w.visitNonEmptyOption(temp_whereClause)) {
                    WhereClause elt_temp_whereClause = temp_whereClause.unwrap();
                    if (elt_temp_whereClause == null) w.visitNull();
                    else {
                        elt_temp_whereClause.walk(w);
                    }
                    w.endNonEmptyOption(temp_whereClause);
                }
                w.endNodeField("whereClause", temp_whereClause);
            }
            w.endNode(this, "NonterminalHeader", 7);
        }
    }

}
