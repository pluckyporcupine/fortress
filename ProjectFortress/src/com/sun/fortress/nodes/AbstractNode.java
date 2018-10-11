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
 * Class AbstractNode, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class AbstractNode extends UIDObject implements ASTNode {
    private final ASTNodeInfo _info;

    /**
     * Constructs a AbstractNode.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public AbstractNode(ASTNodeInfo in_info) {
        super();
        if (in_info == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'info' to the AbstractNode constructor was null");
        }
        _info = in_info;
    }

    public ASTNodeInfo getInfo() { return _info; }

    public abstract <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor);
    public abstract <RetType> RetType accept(NodeVisitor<RetType> visitor);

    public abstract void accept(AbstractNodeVisitor_void visitor);
    public abstract void accept(NodeVisitor_void visitor);

    private int _hashCode;
    private boolean _hasHashCode = false;

    public final int hashCode() {
        if (! _hasHashCode) { _hashCode = generateHashCode(); _hasHashCode = true; }
        return _hashCode;
    }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected AbstractNode() {
        _info = null;
    }

    /** Generate a human-readable representation that can be deserialized. */
    public java.lang.String serialize() {
        java.io.StringWriter w = new java.io.StringWriter();
        walk(new LosslessStringWalker(w, 2));
        return w.toString();
    }
    /** Generate a human-readable representation that can be deserialized. */
    public void serialize(java.io.Writer writer) {
        walk(new LosslessStringWalker(writer, 2));
    }

    public abstract void walk(TreeWalker w);
}
