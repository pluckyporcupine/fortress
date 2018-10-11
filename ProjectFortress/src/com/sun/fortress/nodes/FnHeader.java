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
 * Class FnHeader, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class FnHeader extends DeclHeader {
    private final List<Param> _params;
    private final Option<Type> _returnType;

    /**
     * Constructs a FnHeader.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public FnHeader(List<StaticParam> in_staticParams, Modifiers in_mods, IdOrOpOrAnonymousName in_name, Option<WhereClause> in_whereClause, Option<List<Type>> in_throwsClause, Option<Contract> in_contract, List<Param> in_params, Option<Type> in_returnType) {
        super(in_staticParams, in_mods, in_name, in_whereClause, in_throwsClause, in_contract);
        if (in_params == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'params' to the FnHeader constructor was null");
        }
        _params = in_params;
        if (in_returnType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'returnType' to the FnHeader constructor was null");
        }
        _returnType = in_returnType;
    }

    final public List<Param> getParams() { return _params; }
    final public Option<Type> getReturnType() { return _returnType; }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forFnHeader(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forFnHeader(this);
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
            FnHeader casted = (FnHeader) obj;
            List<StaticParam> temp_staticParams = getStaticParams();
            List<StaticParam> casted_staticParams = casted.getStaticParams();
            if (!(temp_staticParams == casted_staticParams || temp_staticParams.equals(casted_staticParams))) return false;
            Modifiers temp_mods = getMods();
            Modifiers casted_mods = casted.getMods();
            if (!(temp_mods == casted_mods || temp_mods.equals(casted_mods))) return false;
            IdOrOpOrAnonymousName temp_name = getName();
            IdOrOpOrAnonymousName casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            Option<WhereClause> temp_whereClause = getWhereClause();
            Option<WhereClause> casted_whereClause = casted.getWhereClause();
            if (!(temp_whereClause == casted_whereClause || temp_whereClause.equals(casted_whereClause))) return false;
            Option<List<Type>> temp_throwsClause = getThrowsClause();
            Option<List<Type>> casted_throwsClause = casted.getThrowsClause();
            if (!(temp_throwsClause == casted_throwsClause || temp_throwsClause.equals(casted_throwsClause))) return false;
            Option<Contract> temp_contract = getContract();
            Option<Contract> casted_contract = casted.getContract();
            if (!(temp_contract == casted_contract || temp_contract.equals(casted_contract))) return false;
            List<Param> temp_params = getParams();
            List<Param> casted_params = casted.getParams();
            if (!(temp_params == casted_params || temp_params.equals(casted_params))) return false;
            Option<Type> temp_returnType = getReturnType();
            Option<Type> casted_returnType = casted.getReturnType();
            if (!(temp_returnType == casted_returnType || temp_returnType.equals(casted_returnType))) return false;
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
        List<StaticParam> temp_staticParams = getStaticParams();
        code ^= temp_staticParams.hashCode();
        Modifiers temp_mods = getMods();
        code ^= temp_mods.hashCode();
        IdOrOpOrAnonymousName temp_name = getName();
        code ^= temp_name.hashCode();
        Option<WhereClause> temp_whereClause = getWhereClause();
        code ^= temp_whereClause.hashCode();
        Option<List<Type>> temp_throwsClause = getThrowsClause();
        code ^= temp_throwsClause.hashCode();
        Option<Contract> temp_contract = getContract();
        code ^= temp_contract.hashCode();
        List<Param> temp_params = getParams();
        code ^= temp_params.hashCode();
        Option<Type> temp_returnType = getReturnType();
        code ^= temp_returnType.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected FnHeader() {
        _params = null;
        _returnType = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "FnHeader", 8)) {
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
            Modifiers temp_mods = getMods();
            if (w.visitNodeField("mods", temp_mods)) {
                w.visitUnknownObject(temp_mods);
                w.endNodeField("mods", temp_mods);
            }
            IdOrOpOrAnonymousName temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
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
            Option<List<Type>> temp_throwsClause = getThrowsClause();
            if (w.visitNodeField("throwsClause", temp_throwsClause)) {
                if (temp_throwsClause.isNone()) {
                    w.visitEmptyOption(temp_throwsClause);
                }
                else if (w.visitNonEmptyOption(temp_throwsClause)) {
                    List<Type> elt_temp_throwsClause = temp_throwsClause.unwrap();
                    if (elt_temp_throwsClause == null) w.visitNull();
                    else {
                        if (w.visitIterated(elt_temp_throwsClause)) {
                            int i_elt_temp_throwsClause = 0;
                            for (Type elt_elt_temp_throwsClause : elt_temp_throwsClause) {
                                if (w.visitIteratedElement(i_elt_temp_throwsClause, elt_elt_temp_throwsClause)) {
                                    if (elt_elt_temp_throwsClause == null) w.visitNull();
                                    else {
                                        elt_elt_temp_throwsClause.walk(w);
                                    }
                                }
                                i_elt_temp_throwsClause++;
                            }
                            w.endIterated(elt_temp_throwsClause, i_elt_temp_throwsClause);
                        }
                    }
                    w.endNonEmptyOption(temp_throwsClause);
                }
                w.endNodeField("throwsClause", temp_throwsClause);
            }
            Option<Contract> temp_contract = getContract();
            if (w.visitNodeField("contract", temp_contract)) {
                if (temp_contract.isNone()) {
                    w.visitEmptyOption(temp_contract);
                }
                else if (w.visitNonEmptyOption(temp_contract)) {
                    Contract elt_temp_contract = temp_contract.unwrap();
                    if (elt_temp_contract == null) w.visitNull();
                    else {
                        elt_temp_contract.walk(w);
                    }
                    w.endNonEmptyOption(temp_contract);
                }
                w.endNodeField("contract", temp_contract);
            }
            List<Param> temp_params = getParams();
            if (w.visitNodeField("params", temp_params)) {
                if (w.visitIterated(temp_params)) {
                    int i_temp_params = 0;
                    for (Param elt_temp_params : temp_params) {
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
            Option<Type> temp_returnType = getReturnType();
            if (w.visitNodeField("returnType", temp_returnType)) {
                if (temp_returnType.isNone()) {
                    w.visitEmptyOption(temp_returnType);
                }
                else if (w.visitNonEmptyOption(temp_returnType)) {
                    Type elt_temp_returnType = temp_returnType.unwrap();
                    if (elt_temp_returnType == null) w.visitNull();
                    else {
                        elt_temp_returnType.walk(w);
                    }
                    w.endNonEmptyOption(temp_returnType);
                }
                w.endNodeField("returnType", temp_returnType);
            }
            w.endNode(this, "FnHeader", 8);
        }
    }

}
