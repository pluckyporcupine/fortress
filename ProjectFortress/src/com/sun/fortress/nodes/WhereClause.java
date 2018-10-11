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
 * Class WhereClause, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class WhereClause extends AbstractNode {
    private final List<WhereBinding> _bindings;
    private final List<WhereConstraint> _constraints;

    /**
     * Constructs a WhereClause.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public WhereClause(ASTNodeInfo in_info, List<WhereBinding> in_bindings, List<WhereConstraint> in_constraints) {
        super(in_info);
        if (in_bindings == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'bindings' to the WhereClause constructor was null");
        }
        _bindings = in_bindings;
        if (in_constraints == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'constraints' to the WhereClause constructor was null");
        }
        _constraints = in_constraints;
    }

    final public List<WhereBinding> getBindings() { return _bindings; }
    final public List<WhereConstraint> getConstraints() { return _constraints; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forWhereClause(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forWhereClause(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forWhereClause(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forWhereClause(this);
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
            WhereClause casted = (WhereClause) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<WhereBinding> temp_bindings = getBindings();
            List<WhereBinding> casted_bindings = casted.getBindings();
            if (!(temp_bindings == casted_bindings || temp_bindings.equals(casted_bindings))) return false;
            List<WhereConstraint> temp_constraints = getConstraints();
            List<WhereConstraint> casted_constraints = casted.getConstraints();
            if (!(temp_constraints == casted_constraints || temp_constraints.equals(casted_constraints))) return false;
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
        List<WhereBinding> temp_bindings = getBindings();
        code ^= temp_bindings.hashCode();
        List<WhereConstraint> temp_constraints = getConstraints();
        code ^= temp_constraints.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected WhereClause() {
        _bindings = null;
        _constraints = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected WhereClause(ASTNodeInfo info) {
        super(info);
        _bindings = null;
        _constraints = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "WhereClause", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<WhereBinding> temp_bindings = getBindings();
            if (w.visitNodeField("bindings", temp_bindings)) {
                if (w.visitIterated(temp_bindings)) {
                    int i_temp_bindings = 0;
                    for (WhereBinding elt_temp_bindings : temp_bindings) {
                        if (w.visitIteratedElement(i_temp_bindings, elt_temp_bindings)) {
                            if (elt_temp_bindings == null) w.visitNull();
                            else {
                                elt_temp_bindings.walk(w);
                            }
                        }
                        i_temp_bindings++;
                    }
                    w.endIterated(temp_bindings, i_temp_bindings);
                }
                w.endNodeField("bindings", temp_bindings);
            }
            List<WhereConstraint> temp_constraints = getConstraints();
            if (w.visitNodeField("constraints", temp_constraints)) {
                if (w.visitIterated(temp_constraints)) {
                    int i_temp_constraints = 0;
                    for (WhereConstraint elt_temp_constraints : temp_constraints) {
                        if (w.visitIteratedElement(i_temp_constraints, elt_temp_constraints)) {
                            if (elt_temp_constraints == null) w.visitNull();
                            else {
                                elt_temp_constraints.walk(w);
                            }
                        }
                        i_temp_constraints++;
                    }
                    w.endIterated(temp_constraints, i_temp_constraints);
                }
                w.endNodeField("constraints", temp_constraints);
            }
            w.endNode(this, "WhereClause", 3);
        }
    }

}
