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
 * Class ArrayElement, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ArrayElement extends ArrayExpr {
    private final Expr _element;

    /**
     * Constructs a ArrayElement.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ArrayElement(ExprInfo in_info, List<StaticArg> in_staticArgs, Expr in_element) {
        super(in_info, in_staticArgs);
        if (in_element == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'element' to the ArrayElement constructor was null");
        }
        _element = in_element;
    }

    final public Expr getElement() { return _element; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forArrayElement(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forArrayElement(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forArrayElement(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forArrayElement(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forArrayElement(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forArrayElement(this);
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
            ArrayElement casted = (ArrayElement) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<StaticArg> temp_staticArgs = getStaticArgs();
            List<StaticArg> casted_staticArgs = casted.getStaticArgs();
            if (!(temp_staticArgs == casted_staticArgs || temp_staticArgs.equals(casted_staticArgs))) return false;
            Expr temp_element = getElement();
            Expr casted_element = casted.getElement();
            if (!(temp_element == casted_element || temp_element.equals(casted_element))) return false;
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
        Expr temp_element = getElement();
        code ^= temp_element.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ArrayElement() {
        _element = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ArrayElement(ExprInfo info) {
        super(info);
        _element = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ArrayElement", 3)) {
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
            Expr temp_element = getElement();
            if (w.visitNodeField("element", temp_element)) {
                temp_element.walk(w);
                w.endNodeField("element", temp_element);
            }
            w.endNode(this, "ArrayElement", 3);
        }
    }

}
