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
 * Class ArrayElements, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ArrayElements extends ArrayExpr {
    private final int _dimension;
    private final List<ArrayExpr> _elements;
    private final boolean _outermost;

    /**
     * Constructs a ArrayElements.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ArrayElements(ExprInfo in_info, List<StaticArg> in_staticArgs, int in_dimension, List<ArrayExpr> in_elements, boolean in_outermost) {
        super(in_info, in_staticArgs);
        _dimension = in_dimension;
        if (in_elements == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'elements' to the ArrayElements constructor was null");
        }
        _elements = in_elements;
        _outermost = in_outermost;
    }

    final public int getDimension() { return _dimension; }
    final public List<ArrayExpr> getElements() { return _elements; }
    final public boolean isOutermost() { return _outermost; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forArrayElements(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forArrayElements(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forArrayElements(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forArrayElements(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forArrayElements(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forArrayElements(this);
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
            ArrayElements casted = (ArrayElements) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<StaticArg> temp_staticArgs = getStaticArgs();
            List<StaticArg> casted_staticArgs = casted.getStaticArgs();
            if (!(temp_staticArgs == casted_staticArgs || temp_staticArgs.equals(casted_staticArgs))) return false;
            int temp_dimension = getDimension();
            int casted_dimension = casted.getDimension();
            if (!(temp_dimension == casted_dimension)) return false;
            List<ArrayExpr> temp_elements = getElements();
            List<ArrayExpr> casted_elements = casted.getElements();
            if (!(temp_elements == casted_elements || temp_elements.equals(casted_elements))) return false;
            boolean temp_outermost = isOutermost();
            boolean casted_outermost = casted.isOutermost();
            if (!(temp_outermost == casted_outermost)) return false;
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
        ExprInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        List<StaticArg> temp_staticArgs = getStaticArgs();
        code ^= temp_staticArgs.hashCode();
        int temp_dimension = getDimension();
        code ^= temp_dimension;
        List<ArrayExpr> temp_elements = getElements();
        code ^= temp_elements.hashCode();
        boolean temp_outermost = isOutermost();
        code ^= temp_outermost ? 1231 : 1237;
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ArrayElements() {
        _dimension = 0;
        _elements = null;
        _outermost = false;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ArrayElements(ExprInfo info) {
        super(info);
        _dimension = 0;
        _elements = null;
        _outermost = false;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ArrayElements", 5)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<StaticArg> temp_staticArgs = getStaticArgs();
            if (w.visitNodeField("staticArgs", temp_staticArgs)) {
                if (w.visitIterated(temp_staticArgs)) {
                    int i_temp_staticArgs = 0;
                    for (StaticArg elt_temp_staticArgs : temp_staticArgs) {
                        if (w.visitIteratedElement(i_temp_staticArgs, elt_temp_staticArgs)) {
                            if (elt_temp_staticArgs == null) w.visitNull();
                            else {
                                elt_temp_staticArgs.walk(w);
                            }
                        }
                        i_temp_staticArgs++;
                    }
                    w.endIterated(temp_staticArgs, i_temp_staticArgs);
                }
                w.endNodeField("staticArgs", temp_staticArgs);
            }
            int temp_dimension = getDimension();
            if (w.visitNodeField("dimension", temp_dimension)) {
                w.visitInt(temp_dimension);
                w.endNodeField("dimension", temp_dimension);
            }
            List<ArrayExpr> temp_elements = getElements();
            if (w.visitNodeField("elements", temp_elements)) {
                if (w.visitIterated(temp_elements)) {
                    int i_temp_elements = 0;
                    for (ArrayExpr elt_temp_elements : temp_elements) {
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
            boolean temp_outermost = isOutermost();
            if (w.visitNodeField("outermost", temp_outermost)) {
                w.visitBoolean(temp_outermost);
                w.endNodeField("outermost", temp_outermost);
            }
            w.endNode(this, "ArrayElements", 5);
        }
    }

}
