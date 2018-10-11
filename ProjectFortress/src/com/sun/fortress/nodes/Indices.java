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
 * Class Indices, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class Indices extends AbstractNode {
    private final List<ExtentRange> _extents;

    /**
     * Constructs a Indices.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Indices(ASTNodeInfo in_info, List<ExtentRange> in_extents) {
        super(in_info);
        if (in_extents == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'extents' to the Indices constructor was null");
        }
        _extents = in_extents;
    }

    final public List<ExtentRange> getExtents() { return _extents; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forIndices(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forIndices(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forIndices(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forIndices(this);
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
            Indices casted = (Indices) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<ExtentRange> temp_extents = getExtents();
            List<ExtentRange> casted_extents = casted.getExtents();
            if (!(temp_extents == casted_extents || temp_extents.equals(casted_extents))) return false;
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
        List<ExtentRange> temp_extents = getExtents();
        code ^= temp_extents.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Indices() {
        _extents = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Indices(ASTNodeInfo info) {
        super(info);
        _extents = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "Indices", 2)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<ExtentRange> temp_extents = getExtents();
            if (w.visitNodeField("extents", temp_extents)) {
                if (w.visitIterated(temp_extents)) {
                    int i_temp_extents = 0;
                    for (ExtentRange elt_temp_extents : temp_extents) {
                        if (w.visitIteratedElement(i_temp_extents, elt_temp_extents)) {
                            if (elt_temp_extents == null) w.visitNull();
                            else {
                                elt_temp_extents.walk(w);
                            }
                        }
                        i_temp_extents++;
                    }
                    w.endIterated(temp_extents, i_temp_extents);
                }
                w.endNodeField("extents", temp_extents);
            }
            w.endNode(this, "Indices", 2);
        }
    }

}
