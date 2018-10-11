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
 * Class AnonymousFnName, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class AnonymousFnName extends AnonymousName {

    /**
     * Constructs a AnonymousFnName.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public AnonymousFnName(ASTNodeInfo in_info, Option<APIName> in_apiName) {
        super(in_info, in_apiName);
    }


    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forAnonymousFnName(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forAnonymousFnName(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forAnonymousFnName(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forAnonymousFnName(this);
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
            AnonymousFnName casted = (AnonymousFnName) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<APIName> temp_apiName = getApiName();
            Option<APIName> casted_apiName = casted.getApiName();
            if (!(temp_apiName == casted_apiName || temp_apiName.equals(casted_apiName))) return false;
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
        Option<APIName> temp_apiName = getApiName();
        code ^= temp_apiName.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected AnonymousFnName() {
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected AnonymousFnName(ASTNodeInfo info) {
        super(info);
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "AnonymousFnName", 2)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Option<APIName> temp_apiName = getApiName();
            if (w.visitNodeField("apiName", temp_apiName)) {
                if (temp_apiName.isNone()) {
                    w.visitEmptyOption(temp_apiName);
                }
                else if (w.visitNonEmptyOption(temp_apiName)) {
                    APIName elt_temp_apiName = temp_apiName.unwrap();
                    if (elt_temp_apiName == null) w.visitNull();
                    else {
                        elt_temp_apiName.walk(w);
                    }
                    w.endNonEmptyOption(temp_apiName);
                }
                w.endNodeField("apiName", temp_apiName);
            }
            w.endNode(this, "AnonymousFnName", 2);
        }
    }

}
