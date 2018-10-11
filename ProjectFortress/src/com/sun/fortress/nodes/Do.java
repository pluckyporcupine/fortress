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
 * Class Do, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class Do extends Expr {
    private final List<Block> _fronts;

    /**
     * Constructs a Do.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Do(ExprInfo in_info, List<Block> in_fronts) {
        super(in_info);
        if (in_fronts == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'fronts' to the Do constructor was null");
        }
        _fronts = in_fronts;
    }

    final public List<Block> getFronts() { return _fronts; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forDo(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forDo(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forDo(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forDo(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forDo(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forDo(this);
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
            Do casted = (Do) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<Block> temp_fronts = getFronts();
            List<Block> casted_fronts = casted.getFronts();
            if (!(temp_fronts == casted_fronts || temp_fronts.equals(casted_fronts))) return false;
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
        List<Block> temp_fronts = getFronts();
        code ^= temp_fronts.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Do() {
        _fronts = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Do(ExprInfo info) {
        super(info);
        _fronts = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "Do", 2)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<Block> temp_fronts = getFronts();
            if (w.visitNodeField("fronts", temp_fronts)) {
                if (w.visitIterated(temp_fronts)) {
                    int i_temp_fronts = 0;
                    for (Block elt_temp_fronts : temp_fronts) {
                        if (w.visitIteratedElement(i_temp_fronts, elt_temp_fronts)) {
                            if (elt_temp_fronts == null) w.visitNull();
                            else {
                                elt_temp_fronts.walk(w);
                            }
                        }
                        i_temp_fronts++;
                    }
                    w.endIterated(temp_fronts, i_temp_fronts);
                }
                w.endNodeField("fronts", temp_fronts);
            }
            w.endNode(this, "Do", 2);
        }
    }

}
