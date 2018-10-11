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
 * Template gap classTemplateGapContract, a template gap of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings(value={"unused"})
public class TemplateGapContract extends Contract implements TemplateGap {

    private final Id _id;
    private final List<Id> _templateParams;

    public TemplateGapContract() {
        super(NodeFactory.makeASTNodeInfo(NodeFactory.macroSpan));
        this._id = null;
        this._templateParams = null;
    }

    public TemplateGapContract(ASTNodeInfo info, Id id, List<Id> templateParams) {
        super(info);
        this._id = id;
        this._templateParams = templateParams;
    }

    final public Id getGapId() { return _id; }
    final public List<Id> getTemplateParams() { return _templateParams; }


    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTemplateGapContract(this);
    }
    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTemplateGapContract(this);
    }
    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTemplateGapContract(this);
    }
    public void accept(NodeVisitor_void visitor) {
        visitor.forTemplateGapContract(this);
    }
    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.forTemplateGapContract(this);
    }

    public boolean equals(Object obj) {
    if (obj == null) return false;
        if ((obj.getClass() != this.getClass()) || (obj.hashCode() != this.hashCode())) {
            return false;
        }
         else {
            TemplateGap casted = (TemplateGap) obj;
            Id temp_id = getGapId();
            Id casted_id = casted.getGapId();
            if (!(temp_id == casted_id || temp_id.equals(casted_id))) return false;
            List<Id> temp_templateParams = getTemplateParams();
            List<Id> casted_templateParams = casted.getTemplateParams();
            if (!(temp_templateParams == casted_templateParams || temp_templateParams.equals(casted_templateParams))) return false;
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
        Id temp_id = getGapId();
        code ^= temp_id.hashCode();
        List<Id> temp_templateParams = getTemplateParams();
        code ^= temp_templateParams.hashCode();
        return code;
    }

    /** Generate a human-readable representation that can be deserialized. */
    public java.lang.String serialize() {
        java.io.StringWriter w = new java.io.StringWriter();
        serialize(w);
        return w.toString();
    }
    /** Generate a human-readable representation that can be deserialized. */
    public void serialize(java.io.Writer writer) {
        walk(new LosslessStringWalker(writer, 2));
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TemplateGapContract", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Id temp_id = getGapId();
            if (w.visitNodeField("gapId", temp_id)) {
                temp_id.walk(w);
                w.endNodeField("gapId", temp_id);
            }
            List<Id> temp_templateParams = getTemplateParams();
            if (w.visitNodeField("templateParams", temp_templateParams)) {
                if (w.visitIterated(temp_templateParams)) {
                    int i_temp_templateParams = 0;
                    for (Id elt_temp_templateParams : temp_templateParams) {
                        if (w.visitIteratedElement(i_temp_templateParams, elt_temp_templateParams)) {
                            if (elt_temp_templateParams == null) w.visitNull();
                            else elt_temp_templateParams.walk(w);
                            w.endIteratedElement(i_temp_templateParams, elt_temp_templateParams);
                        }
                        i_temp_templateParams++;
                    }
                    w.endIterated(temp_templateParams, i_temp_templateParams);
                }
                w.endNodeField("templateParams", temp_templateParams);
            }
            w.endNode(this, "TemplateGapContract", 3);
        }
    }
}
