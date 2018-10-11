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
 * Class ObjectExprType, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ObjectExprType extends SelfType {
    private final List<BaseType> _extended;

    /**
     * Constructs a ObjectExprType.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ObjectExprType(TypeInfo in_info, List<BaseType> in_extended) {
        super(in_info);
        if (in_extended == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'extended' to the ObjectExprType constructor was null");
        }
        _extended = in_extended;
    }

    final public List<BaseType> getExtended() { return _extended; }

    public <RetType> RetType accept(TypeVisitor<RetType> visitor) {
        return visitor.forObjectExprType(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forObjectExprType(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forObjectExprType(this);
    }

    public void accept(TypeVisitor_void visitor) {
        visitor.forObjectExprType(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forObjectExprType(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forObjectExprType(this);
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
            ObjectExprType casted = (ObjectExprType) obj;
            TypeInfo temp_info = getInfo();
            TypeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<BaseType> temp_extended = getExtended();
            List<BaseType> casted_extended = casted.getExtended();
            if (!(temp_extended == casted_extended || temp_extended.equals(casted_extended))) return false;
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
        List<BaseType> temp_extended = getExtended();
        code ^= temp_extended.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ObjectExprType() {
        _extended = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ObjectExprType(TypeInfo info) {
        super(info);
        _extended = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ObjectExprType", 2)) {
            TypeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<BaseType> temp_extended = getExtended();
            if (w.visitNodeField("extended", temp_extended)) {
                if (w.visitIterated(temp_extended)) {
                    int i_temp_extended = 0;
                    for (BaseType elt_temp_extended : temp_extended) {
                        if (w.visitIteratedElement(i_temp_extended, elt_temp_extended)) {
                            if (elt_temp_extended == null) w.visitNull();
                            else {
                                elt_temp_extended.walk(w);
                            }
                        }
                        i_temp_extended++;
                    }
                    w.endIterated(temp_extended, i_temp_extended);
                }
                w.endNodeField("extended", temp_extended);
            }
            w.endNode(this, "ObjectExprType", 2);
        }
    }

}
