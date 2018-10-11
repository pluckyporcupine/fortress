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
 * Class ArrayComprehension, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ArrayComprehension extends BigOpApp {
    private final List<ArrayComprehensionClause> _clauses;

    /**
     * Constructs a ArrayComprehension.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ArrayComprehension(ExprInfo in_info, List<StaticArg> in_staticArgs, List<ArrayComprehensionClause> in_clauses) {
        super(in_info, in_staticArgs);
        if (in_clauses == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'clauses' to the ArrayComprehension constructor was null");
        }
        _clauses = in_clauses;
    }

    final public List<ArrayComprehensionClause> getClauses() { return _clauses; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forArrayComprehension(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forArrayComprehension(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forArrayComprehension(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forArrayComprehension(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forArrayComprehension(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forArrayComprehension(this);
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
            ArrayComprehension casted = (ArrayComprehension) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<StaticArg> temp_staticArgs = getStaticArgs();
            List<StaticArg> casted_staticArgs = casted.getStaticArgs();
            if (!(temp_staticArgs == casted_staticArgs || temp_staticArgs.equals(casted_staticArgs))) return false;
            List<ArrayComprehensionClause> temp_clauses = getClauses();
            List<ArrayComprehensionClause> casted_clauses = casted.getClauses();
            if (!(temp_clauses == casted_clauses || temp_clauses.equals(casted_clauses))) return false;
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
        List<ArrayComprehensionClause> temp_clauses = getClauses();
        code ^= temp_clauses.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ArrayComprehension() {
        _clauses = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ArrayComprehension(ExprInfo info) {
        super(info);
        _clauses = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ArrayComprehension", 3)) {
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
            List<ArrayComprehensionClause> temp_clauses = getClauses();
            if (w.visitNodeField("clauses", temp_clauses)) {
                if (w.visitIterated(temp_clauses)) {
                    int i_temp_clauses = 0;
                    for (ArrayComprehensionClause elt_temp_clauses : temp_clauses) {
                        if (w.visitIteratedElement(i_temp_clauses, elt_temp_clauses)) {
                            if (elt_temp_clauses == null) w.visitNull();
                            else {
                                elt_temp_clauses.walk(w);
                            }
                        }
                        i_temp_clauses++;
                    }
                    w.endIterated(temp_clauses, i_temp_clauses);
                }
                w.endNodeField("clauses", temp_clauses);
            }
            w.endNode(this, "ArrayComprehension", 3);
        }
    }

}
