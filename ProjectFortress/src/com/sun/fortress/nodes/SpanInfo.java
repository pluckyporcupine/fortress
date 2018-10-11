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
 * Class SpanInfo, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class SpanInfo extends ASTNodeInfo {

    /**
     * Constructs a SpanInfo.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public SpanInfo(Span in_span) {
        super(in_span);
    }


    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forSpanInfo(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forSpanInfo(this);
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
            SpanInfo casted = (SpanInfo) obj;
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
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected SpanInfo() {
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "SpanInfo", 1)) {
            Span temp_span = getSpan();
            if (w.visitNodeField("span", temp_span)) {
                w.visitUnknownObject(temp_span);
                w.endNodeField("span", temp_span);
            }
            w.endNode(this, "SpanInfo", 1);
        }
    }

}
