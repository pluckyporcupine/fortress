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
 * Class UnionType, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class UnionType extends BoundType {

    /**
     * Constructs a UnionType.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public UnionType(TypeInfo in_info, List<Type> in_elements) {
        super(in_info, in_elements);
    }


    public <RetType> RetType accept(TypeVisitor<RetType> visitor) {
        return visitor.forUnionType(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forUnionType(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forUnionType(this);
    }

    public void accept(TypeVisitor_void visitor) {
        visitor.forUnionType(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forUnionType(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forUnionType(this);
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
            UnionType casted = (UnionType) obj;
            TypeInfo temp_info = getInfo();
            TypeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<Type> temp_elements = getElements();
            List<Type> casted_elements = casted.getElements();
            if (!(temp_elements == casted_elements || temp_elements.equals(casted_elements))) return false;
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
        TypeInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        List<Type> temp_elements = getElements();
        code ^= temp_elements.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected UnionType() {
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected UnionType(TypeInfo info) {
        super(info);
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "UnionType", 2)) {
            TypeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<Type> temp_elements = getElements();
            if (w.visitNodeField("elements", temp_elements)) {
                if (w.visitIterated(temp_elements)) {
                    int i_temp_elements = 0;
                    for (Type elt_temp_elements : temp_elements) {
                        if (w.visitIteratedElement(i_temp_elements, elt_temp_elements)) {
                            if (elt_temp_elements == null) w.visitNull();
                            else {
                                elt_temp_elements.walk(w);
                            }
                        }
                        i_temp_elements++;
                    }
                    w.endIterated(temp_elements, i_temp_elements);
                }
                w.endNodeField("elements", temp_elements);
            }
            w.endNode(this, "UnionType", 2);
        }
    }

}
