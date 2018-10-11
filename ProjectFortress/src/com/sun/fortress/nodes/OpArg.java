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
 * Class OpArg, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class OpArg extends StaticArg {
    private final Op _id;

    /**
     * Constructs a OpArg.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public OpArg(ASTNodeInfo in_info, boolean in_lifted, Op in_id) {
        super(in_info, in_lifted);
        if (in_id == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'id' to the OpArg constructor was null");
        }
        _id = in_id;
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public OpArg(ASTNodeInfo in_info, Op in_id) {
        this(in_info, false, in_id);
    }

    final public Op getId() { return _id; }

    public <RetType> RetType accept(StaticArgVisitor<RetType> visitor) {
        return visitor.forOpArg(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forOpArg(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forOpArg(this);
    }

    public void accept(StaticArgVisitor_void visitor) {
        visitor.forOpArg(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forOpArg(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forOpArg(this);
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
            OpArg casted = (OpArg) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Op temp_id = getId();
            Op casted_id = casted.getId();
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
        Op temp_id = getId();
        code ^= temp_id.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected OpArg() {
        _id = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected OpArg(ASTNodeInfo info) {
        super(info);
        _id = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "OpArg", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            boolean temp_lifted = isLifted();
            if (w.visitNodeField("lifted", temp_lifted)) {
                w.visitBoolean(temp_lifted);
                w.endNodeField("lifted", temp_lifted);
            }
            Op temp_id = getId();
            if (w.visitNodeField("id", temp_id)) {
                temp_id.walk(w);
                w.endNodeField("id", temp_id);
            }
            w.endNode(this, "OpArg", 3);
        }
    }

}
