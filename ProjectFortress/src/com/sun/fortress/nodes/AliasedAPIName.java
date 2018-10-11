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
 * Class AliasedAPIName, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class AliasedAPIName extends AbstractNode {
    private final APIName _apiName;
    private final Option<Id> _alias;

    /**
     * Constructs a AliasedAPIName.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public AliasedAPIName(ASTNodeInfo in_info, APIName in_apiName, Option<Id> in_alias) {
        super(in_info);
        if (in_apiName == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'apiName' to the AliasedAPIName constructor was null");
        }
        _apiName = in_apiName;
        if (in_alias == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'alias' to the AliasedAPIName constructor was null");
        }
        _alias = in_alias;
    }

    final public APIName getApiName() { return _apiName; }
    final public Option<Id> getAlias() { return _alias; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forAliasedAPIName(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forAliasedAPIName(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forAliasedAPIName(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forAliasedAPIName(this);
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
            AliasedAPIName casted = (AliasedAPIName) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            APIName temp_apiName = getApiName();
            APIName casted_apiName = casted.getApiName();
            if (!(temp_apiName == casted_apiName || temp_apiName.equals(casted_apiName))) return false;
            Option<Id> temp_alias = getAlias();
            Option<Id> casted_alias = casted.getAlias();
            if (!(temp_alias == casted_alias || temp_alias.equals(casted_alias))) return false;
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
        APIName temp_apiName = getApiName();
        code ^= temp_apiName.hashCode();
        Option<Id> temp_alias = getAlias();
        code ^= temp_alias.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected AliasedAPIName() {
        _apiName = null;
        _alias = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected AliasedAPIName(ASTNodeInfo info) {
        super(info);
        _apiName = null;
        _alias = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "AliasedAPIName", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            APIName temp_apiName = getApiName();
            if (w.visitNodeField("apiName", temp_apiName)) {
                temp_apiName.walk(w);
                w.endNodeField("apiName", temp_apiName);
            }
            Option<Id> temp_alias = getAlias();
            if (w.visitNodeField("alias", temp_alias)) {
                if (temp_alias.isNone()) {
                    w.visitEmptyOption(temp_alias);
                }
                else if (w.visitNonEmptyOption(temp_alias)) {
                    Id elt_temp_alias = temp_alias.unwrap();
                    if (elt_temp_alias == null) w.visitNull();
                    else {
                        elt_temp_alias.walk(w);
                    }
                    w.endNonEmptyOption(temp_alias);
                }
                w.endNodeField("alias", temp_alias);
            }
            w.endNode(this, "AliasedAPIName", 3);
        }
    }

}
