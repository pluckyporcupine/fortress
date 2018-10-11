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
 * Class CaseTransformer, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class CaseTransformer extends Transformer {
    private final Id _gapName;
    private final List<CaseTransformerClause> _clauses;

    /**
     * Constructs a CaseTransformer.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public CaseTransformer(ASTNodeInfo in_info, Id in_gapName, List<CaseTransformerClause> in_clauses) {
        super(in_info);
        if (in_gapName == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'gapName' to the CaseTransformer constructor was null");
        }
        _gapName = in_gapName;
        if (in_clauses == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'clauses' to the CaseTransformer constructor was null");
        }
        _clauses = in_clauses;
    }

    final public Id getGapName() { return _gapName; }
    final public List<CaseTransformerClause> getClauses() { return _clauses; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forCaseTransformer(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forCaseTransformer(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forCaseTransformer(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forCaseTransformer(this);
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
            CaseTransformer casted = (CaseTransformer) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_gapName = getGapName();
            Id casted_gapName = casted.getGapName();
            if (!(temp_gapName == casted_gapName || temp_gapName.equals(casted_gapName))) return false;
            List<CaseTransformerClause> temp_clauses = getClauses();
            List<CaseTransformerClause> casted_clauses = casted.getClauses();
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
        Id temp_gapName = getGapName();
        code ^= temp_gapName.hashCode();
        List<CaseTransformerClause> temp_clauses = getClauses();
        code ^= temp_clauses.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected CaseTransformer() {
        _gapName = null;
        _clauses = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected CaseTransformer(ASTNodeInfo info) {
        super(info);
        _gapName = null;
        _clauses = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "CaseTransformer", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Id temp_gapName = getGapName();
            if (w.visitNodeField("gapName", temp_gapName)) {
                temp_gapName.walk(w);
                w.endNodeField("gapName", temp_gapName);
            }
            List<CaseTransformerClause> temp_clauses = getClauses();
            if (w.visitNodeField("clauses", temp_clauses)) {
                if (w.visitIterated(temp_clauses)) {
                    int i_temp_clauses = 0;
                    for (CaseTransformerClause elt_temp_clauses : temp_clauses) {
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
            w.endNode(this, "CaseTransformer", 3);
        }
    }

}
