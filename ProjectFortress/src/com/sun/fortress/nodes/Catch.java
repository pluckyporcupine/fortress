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
 * Class Catch, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class Catch extends AbstractNode {
    private final Id _name;
    private final List<CatchClause> _clauses;

    /**
     * Constructs a Catch.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Catch(ASTNodeInfo in_info, Id in_name, List<CatchClause> in_clauses) {
        super(in_info);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the Catch constructor was null");
        }
        _name = in_name;
        if (in_clauses == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'clauses' to the Catch constructor was null");
        }
        _clauses = in_clauses;
    }

    final public Id getName() { return _name; }
    final public List<CatchClause> getClauses() { return _clauses; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forCatch(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forCatch(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forCatch(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forCatch(this);
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
            Catch casted = (Catch) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_name = getName();
            Id casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            List<CatchClause> temp_clauses = getClauses();
            List<CatchClause> casted_clauses = casted.getClauses();
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
        ASTNodeInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        Id temp_name = getName();
        code ^= temp_name.hashCode();
        List<CatchClause> temp_clauses = getClauses();
        code ^= temp_clauses.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Catch() {
        _name = null;
        _clauses = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Catch(ASTNodeInfo info) {
        super(info);
        _name = null;
        _clauses = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "Catch", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Id temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            List<CatchClause> temp_clauses = getClauses();
            if (w.visitNodeField("clauses", temp_clauses)) {
                if (w.visitIterated(temp_clauses)) {
                    int i_temp_clauses = 0;
                    for (CatchClause elt_temp_clauses : temp_clauses) {
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
            w.endNode(this, "Catch", 3);
        }
    }

}
