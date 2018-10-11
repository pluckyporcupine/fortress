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
 * Class APIName, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class APIName extends Name {
    private final List<Id> _ids;
    private final String _text;

    /**
     * Constructs a APIName.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public APIName(ASTNodeInfo in_info, List<Id> in_ids, String in_text) {
        super(in_info);
        if (in_ids == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'ids' to the APIName constructor was null");
        }
        _ids = in_ids;
        if (in_text == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'text' to the APIName constructor was null");
        }
        _text = in_text.intern();
    }

    final public List<Id> getIds() { return _ids; }
    final public String getText() { return _text; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forAPIName(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forAPIName(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forAPIName(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forAPIName(this);
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
            APIName casted = (APIName) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<Id> temp_ids = getIds();
            List<Id> casted_ids = casted.getIds();
            if (!(temp_ids == casted_ids || temp_ids.equals(casted_ids))) return false;
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
        List<Id> temp_ids = getIds();
        code ^= temp_ids.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected APIName() {
        _ids = null;
        _text = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected APIName(ASTNodeInfo info) {
        super(info);
        _ids = null;
        _text = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "APIName", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<Id> temp_ids = getIds();
            if (w.visitNodeField("ids", temp_ids)) {
                if (w.visitIterated(temp_ids)) {
                    int i_temp_ids = 0;
                    for (Id elt_temp_ids : temp_ids) {
                        if (w.visitIteratedElement(i_temp_ids, elt_temp_ids)) {
                            if (elt_temp_ids == null) w.visitNull();
                            else {
                                elt_temp_ids.walk(w);
                            }
                        }
                        i_temp_ids++;
                    }
                    w.endIterated(temp_ids, i_temp_ids);
                }
                w.endNodeField("ids", temp_ids);
            }
            String temp_text = getText();
            if (w.visitNodeField("text", temp_text)) {
                w.visitString(temp_text);
                w.endNodeField("text", temp_text);
            }
            w.endNode(this, "APIName", 3);
        }
    }

}
