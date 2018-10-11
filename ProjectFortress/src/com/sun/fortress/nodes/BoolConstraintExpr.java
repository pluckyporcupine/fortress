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
 * Class BoolConstraintExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class BoolConstraintExpr extends WhereConstraint {
    private final BoolConstraint _constraint;

    /**
     * Constructs a BoolConstraintExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public BoolConstraintExpr(ASTNodeInfo in_info, BoolConstraint in_constraint) {
        super(in_info);
        if (in_constraint == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'constraint' to the BoolConstraintExpr constructor was null");
        }
        _constraint = in_constraint;
    }

    final public BoolConstraint getConstraint() { return _constraint; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forBoolConstraintExpr(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forBoolConstraintExpr(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forBoolConstraintExpr(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forBoolConstraintExpr(this);
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
            BoolConstraintExpr casted = (BoolConstraintExpr) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            BoolConstraint temp_constraint = getConstraint();
            BoolConstraint casted_constraint = casted.getConstraint();
            if (!(temp_constraint == casted_constraint || temp_constraint.equals(casted_constraint))) return false;
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
        BoolConstraint temp_constraint = getConstraint();
        code ^= temp_constraint.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected BoolConstraintExpr() {
        _constraint = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected BoolConstraintExpr(ASTNodeInfo info) {
        super(info);
        _constraint = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "BoolConstraintExpr", 2)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            BoolConstraint temp_constraint = getConstraint();
            if (w.visitNodeField("constraint", temp_constraint)) {
                temp_constraint.walk(w);
                w.endNodeField("constraint", temp_constraint);
            }
            w.endNode(this, "BoolConstraintExpr", 2);
        }
    }

}
