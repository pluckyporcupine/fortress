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
 * Class TraitTypeHeader, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class TraitTypeHeader extends DeclHeader {
    private final List<TraitTypeWhere> _extendsClause;
    private final Option<List<Param>> _params;
    private final List<Decl> _decls;

    /**
     * Constructs a TraitTypeHeader.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TraitTypeHeader(List<StaticParam> in_staticParams, Modifiers in_mods, IdOrOpOrAnonymousName in_name, Option<WhereClause> in_whereClause, Option<List<Type>> in_throwsClause, Option<Contract> in_contract, List<TraitTypeWhere> in_extendsClause, Option<List<Param>> in_params, List<Decl> in_decls) {
        super(in_staticParams, in_mods, in_name, in_whereClause, in_throwsClause, in_contract);
        if (in_extendsClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'extendsClause' to the TraitTypeHeader constructor was null");
        }
        _extendsClause = in_extendsClause;
        if (in_params == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'params' to the TraitTypeHeader constructor was null");
        }
        _params = in_params;
        if (in_decls == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'decls' to the TraitTypeHeader constructor was null");
        }
        _decls = in_decls;
    }

    final public List<TraitTypeWhere> getExtendsClause() { return _extendsClause; }
    final public Option<List<Param>> getParams() { return _params; }
    final public List<Decl> getDecls() { return _decls; }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTraitTypeHeader(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTraitTypeHeader(this);
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
            TraitTypeHeader casted = (TraitTypeHeader) obj;
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
            List<TraitTypeWhere> temp_extendsClause = getExtendsClause();
            List<TraitTypeWhere> casted_extendsClause = casted.getExtendsClause();
            if (!(temp_extendsClause == casted_extendsClause || temp_extendsClause.equals(casted_extendsClause))) return false;
            Option<List<Param>> temp_params = getParams();
            Option<List<Param>> casted_params = casted.getParams();
            if (!(temp_params == casted_params || temp_params.equals(casted_params))) return false;
            List<Decl> temp_decls = getDecls();
            List<Decl> casted_decls = casted.getDecls();
            if (!(temp_decls == casted_decls || temp_decls.equals(casted_decls))) return false;
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
        List<TraitTypeWhere> temp_extendsClause = getExtendsClause();
        code ^= temp_extendsClause.hashCode();
        Option<List<Param>> temp_params = getParams();
        code ^= temp_params.hashCode();
        List<Decl> temp_decls = getDecls();
        code ^= temp_decls.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TraitTypeHeader() {
        _extendsClause = null;
        _params = null;
        _decls = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TraitTypeHeader", 9)) {
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
            List<TraitTypeWhere> temp_extendsClause = getExtendsClause();
            if (w.visitNodeField("extendsClause", temp_extendsClause)) {
                if (w.visitIterated(temp_extendsClause)) {
                    int i_temp_extendsClause = 0;
                    for (TraitTypeWhere elt_temp_extendsClause : temp_extendsClause) {
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
            Option<List<Param>> temp_params = getParams();
            if (w.visitNodeField("params", temp_params)) {
                if (temp_params.isNone()) {
                    w.visitEmptyOption(temp_params);
                }
                else if (w.visitNonEmptyOption(temp_params)) {
                    List<Param> elt_temp_params = temp_params.unwrap();
                    if (elt_temp_params == null) w.visitNull();
                    else {
                        if (w.visitIterated(elt_temp_params)) {
                            int i_elt_temp_params = 0;
                            for (Param elt_elt_temp_params : elt_temp_params) {
                                if (w.visitIteratedElement(i_elt_temp_params, elt_elt_temp_params)) {
                                    if (elt_elt_temp_params == null) w.visitNull();
                                    else {
                                        elt_elt_temp_params.walk(w);
                                    }
                                }
                                i_elt_temp_params++;
                            }
                            w.endIterated(elt_temp_params, i_elt_temp_params);
                        }
                    }
                    w.endNonEmptyOption(temp_params);
                }
                w.endNodeField("params", temp_params);
            }
            List<Decl> temp_decls = getDecls();
            if (w.visitNodeField("decls", temp_decls)) {
                if (w.visitIterated(temp_decls)) {
                    int i_temp_decls = 0;
                    for (Decl elt_temp_decls : temp_decls) {
                        if (w.visitIteratedElement(i_temp_decls, elt_temp_decls)) {
                            if (elt_temp_decls == null) w.visitNull();
                            else {
                                elt_temp_decls.walk(w);
                            }
                        }
                        i_temp_decls++;
                    }
                    w.endIterated(temp_decls, i_temp_decls);
                }
                w.endNodeField("decls", temp_decls);
            }
            w.endNode(this, "TraitTypeHeader", 9);
        }
    }

}
