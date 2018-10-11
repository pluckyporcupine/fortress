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
 * Ellipses class _EllipsesWhereConstraint.ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings(value={"unused"})
public class _EllipsesWhereConstraint extends WhereConstraint implements _Ellipses {

    private final AbstractNode _repeatedNode;

    public _EllipsesWhereConstraint() {
        super(NodeFactory.makeASTNodeInfo(NodeFactory.macroSpan));
        this._repeatedNode = null;
    }

    public _EllipsesWhereConstraint(ASTNodeInfo info, AbstractNode repeatedNode){
        super(info);
        this._repeatedNode = repeatedNode;
    }

    final public AbstractNode getRepeatedNode(){ return _repeatedNode; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_EllipsesWhereConstraint(this);
    }
    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_EllipsesWhereConstraint(this);
    }
    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_EllipsesWhereConstraint(this);
    }
    public void accept(NodeVisitor_void visitor) {
        visitor.for_EllipsesWhereConstraint(this);
    }
    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_EllipsesWhereConstraint(this);
    }

    public boolean equals(Object obj) {
    if (obj == null) return false;
        if ((obj.getClass() != this.getClass()) || (obj.hashCode() != this.hashCode())) {
            return false;
        }
         else {
            return false;
        }
    }


    /**
     * Implementation of hashCode that is consistent with equals.  The value of
     * the hashCode is formed by XORing the hashcode of the class object with
     * the hashcodes of all the fields of the object.
     */
    public int generateHashCode() {
        int code = getClass().hashCode();
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
        if (w.visitNode(this, "_EllipsesWhereConstraint", 1)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                w.visitUnknownObject(temp_info);
                w.endNodeField("info", temp_info);
            }
            w.endNode(this, "_EllipsesWhereConstraint", 1);
        }
    }
}
