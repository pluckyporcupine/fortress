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
 * Class NodeTransformer, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class NodeTransformer extends Transformer {
    private final AbstractNode _node;

    /**
     * Constructs a NodeTransformer.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public NodeTransformer(ASTNodeInfo in_info, AbstractNode in_node) {
        super(in_info);
        if (in_node == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'node' to the NodeTransformer constructor was null");
        }
        _node = in_node;
    }

    final public AbstractNode getNode() { return _node; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forNodeTransformer(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forNodeTransformer(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forNodeTransformer(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forNodeTransformer(this);
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
            NodeTransformer casted = (NodeTransformer) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            AbstractNode temp_node = getNode();
            AbstractNode casted_node = casted.getNode();
            if (!(temp_node == casted_node || temp_node.equals(casted_node))) return false;
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
        AbstractNode temp_node = getNode();
        code ^= temp_node.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected NodeTransformer() {
        _node = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected NodeTransformer(ASTNodeInfo info) {
        super(info);
        _node = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "NodeTransformer", 2)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            AbstractNode temp_node = getNode();
            if (w.visitNodeField("node", temp_node)) {
                temp_node.walk(w);
                w.endNodeField("node", temp_node);
            }
            w.endNode(this, "NodeTransformer", 2);
        }
    }

}
