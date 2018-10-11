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
 * Class _InferenceVarOp, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _InferenceVarOp extends Op {
    private final Object _id;

    /**
     * Constructs a _InferenceVarOp.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _InferenceVarOp(ASTNodeInfo in_info, Option<APIName> in_apiName, String in_text, Fixity in_fixity, boolean in_enclosing, Object in_id) {
        super(in_info, in_apiName, in_text, in_fixity, in_enclosing);
        if (in_id == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'id' to the _InferenceVarOp constructor was null");
        }
        _id = in_id;
    }

    final public Object getId() { return _id; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_InferenceVarOp(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_InferenceVarOp(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_InferenceVarOp(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_InferenceVarOp(this);
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
            _InferenceVarOp casted = (_InferenceVarOp) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<APIName> temp_apiName = getApiName();
            Option<APIName> casted_apiName = casted.getApiName();
            if (!(temp_apiName == casted_apiName || temp_apiName.equals(casted_apiName))) return false;
            String temp_text = getText();
            String casted_text = casted.getText();
            if (!(temp_text == casted_text)) return false;
            Fixity temp_fixity = getFixity();
            Fixity casted_fixity = casted.getFixity();
            if (!(temp_fixity == casted_fixity || temp_fixity.equals(casted_fixity))) return false;
            boolean temp_enclosing = isEnclosing();
            boolean casted_enclosing = casted.isEnclosing();
            if (!(temp_enclosing == casted_enclosing)) return false;
            Object temp_id = getId();
            Object casted_id = casted.getId();
            if (!(temp_id == casted_id || temp_id.equals(casted_id))) return false;
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
        String temp_text = getText();
        code ^= temp_text.hashCode();
        Fixity temp_fixity = getFixity();
        code ^= temp_fixity.hashCode();
        boolean temp_enclosing = isEnclosing();
        code ^= temp_enclosing ? 1231 : 1237;
        Object temp_id = getId();
        code ^= temp_id.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected _InferenceVarOp() {
        _id = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _InferenceVarOp(ASTNodeInfo info) {
        super(info);
        _id = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_InferenceVarOp", 6)) {
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
            String temp_text = getText();
            if (w.visitNodeField("text", temp_text)) {
                w.visitString(temp_text);
                w.endNodeField("text", temp_text);
            }
            Fixity temp_fixity = getFixity();
            if (w.visitNodeField("fixity", temp_fixity)) {
                temp_fixity.walk(w);
                w.endNodeField("fixity", temp_fixity);
            }
            boolean temp_enclosing = isEnclosing();
            if (w.visitNodeField("enclosing", temp_enclosing)) {
                w.visitBoolean(temp_enclosing);
                w.endNodeField("enclosing", temp_enclosing);
            }
            Object temp_id = getId();
            if (w.visitNodeField("id", temp_id)) {
                w.visitUnknownObject(temp_id);
                w.endNodeField("id", temp_id);
            }
            w.endNode(this, "_InferenceVarOp", 6);
        }
    }

}
