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
 * Class Contract, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class Contract extends AbstractNode {
    private final Option<List<Expr>> _requiresClause;
    private final Option<List<EnsuresClause>> _ensuresClause;
    private final Option<List<Expr>> _invariantsClause;

    /**
     * Constructs a Contract.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Contract(ASTNodeInfo in_info, Option<List<Expr>> in_requiresClause, Option<List<EnsuresClause>> in_ensuresClause, Option<List<Expr>> in_invariantsClause) {
        super(in_info);
        if (in_requiresClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'requiresClause' to the Contract constructor was null");
        }
        _requiresClause = in_requiresClause;
        if (in_ensuresClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'ensuresClause' to the Contract constructor was null");
        }
        _ensuresClause = in_ensuresClause;
        if (in_invariantsClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'invariantsClause' to the Contract constructor was null");
        }
        _invariantsClause = in_invariantsClause;
    }

    final public Option<List<Expr>> getRequiresClause() { return _requiresClause; }
    final public Option<List<EnsuresClause>> getEnsuresClause() { return _ensuresClause; }
    final public Option<List<Expr>> getInvariantsClause() { return _invariantsClause; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forContract(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forContract(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forContract(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forContract(this);
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
            Contract casted = (Contract) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<List<Expr>> temp_requiresClause = getRequiresClause();
            Option<List<Expr>> casted_requiresClause = casted.getRequiresClause();
            if (!(temp_requiresClause == casted_requiresClause || temp_requiresClause.equals(casted_requiresClause))) return false;
            Option<List<EnsuresClause>> temp_ensuresClause = getEnsuresClause();
            Option<List<EnsuresClause>> casted_ensuresClause = casted.getEnsuresClause();
            if (!(temp_ensuresClause == casted_ensuresClause || temp_ensuresClause.equals(casted_ensuresClause))) return false;
            Option<List<Expr>> temp_invariantsClause = getInvariantsClause();
            Option<List<Expr>> casted_invariantsClause = casted.getInvariantsClause();
            if (!(temp_invariantsClause == casted_invariantsClause || temp_invariantsClause.equals(casted_invariantsClause))) return false;
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
        Option<List<Expr>> temp_requiresClause = getRequiresClause();
        code ^= temp_requiresClause.hashCode();
        Option<List<EnsuresClause>> temp_ensuresClause = getEnsuresClause();
        code ^= temp_ensuresClause.hashCode();
        Option<List<Expr>> temp_invariantsClause = getInvariantsClause();
        code ^= temp_invariantsClause.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Contract() {
        _requiresClause = null;
        _ensuresClause = null;
        _invariantsClause = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Contract(ASTNodeInfo info) {
        super(info);
        _requiresClause = null;
        _ensuresClause = null;
        _invariantsClause = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "Contract", 4)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Option<List<Expr>> temp_requiresClause = getRequiresClause();
            if (w.visitNodeField("requiresClause", temp_requiresClause)) {
                if (temp_requiresClause.isNone()) {
                    w.visitEmptyOption(temp_requiresClause);
                }
                else if (w.visitNonEmptyOption(temp_requiresClause)) {
                    List<Expr> elt_temp_requiresClause = temp_requiresClause.unwrap();
                    if (elt_temp_requiresClause == null) w.visitNull();
                    else {
                        if (w.visitIterated(elt_temp_requiresClause)) {
                            int i_elt_temp_requiresClause = 0;
                            for (Expr elt_elt_temp_requiresClause : elt_temp_requiresClause) {
                                if (w.visitIteratedElement(i_elt_temp_requiresClause, elt_elt_temp_requiresClause)) {
                                    if (elt_elt_temp_requiresClause == null) w.visitNull();
                                    else {
                                        elt_elt_temp_requiresClause.walk(w);
                                    }
                                }
                                i_elt_temp_requiresClause++;
                            }
                            w.endIterated(elt_temp_requiresClause, i_elt_temp_requiresClause);
                        }
                    }
                    w.endNonEmptyOption(temp_requiresClause);
                }
                w.endNodeField("requiresClause", temp_requiresClause);
            }
            Option<List<EnsuresClause>> temp_ensuresClause = getEnsuresClause();
            if (w.visitNodeField("ensuresClause", temp_ensuresClause)) {
                if (temp_ensuresClause.isNone()) {
                    w.visitEmptyOption(temp_ensuresClause);
                }
                else if (w.visitNonEmptyOption(temp_ensuresClause)) {
                    List<EnsuresClause> elt_temp_ensuresClause = temp_ensuresClause.unwrap();
                    if (elt_temp_ensuresClause == null) w.visitNull();
                    else {
                        if (w.visitIterated(elt_temp_ensuresClause)) {
                            int i_elt_temp_ensuresClause = 0;
                            for (EnsuresClause elt_elt_temp_ensuresClause : elt_temp_ensuresClause) {
                                if (w.visitIteratedElement(i_elt_temp_ensuresClause, elt_elt_temp_ensuresClause)) {
                                    if (elt_elt_temp_ensuresClause == null) w.visitNull();
                                    else {
                                        elt_elt_temp_ensuresClause.walk(w);
                                    }
                                }
                                i_elt_temp_ensuresClause++;
                            }
                            w.endIterated(elt_temp_ensuresClause, i_elt_temp_ensuresClause);
                        }
                    }
                    w.endNonEmptyOption(temp_ensuresClause);
                }
                w.endNodeField("ensuresClause", temp_ensuresClause);
            }
            Option<List<Expr>> temp_invariantsClause = getInvariantsClause();
            if (w.visitNodeField("invariantsClause", temp_invariantsClause)) {
                if (temp_invariantsClause.isNone()) {
                    w.visitEmptyOption(temp_invariantsClause);
                }
                else if (w.visitNonEmptyOption(temp_invariantsClause)) {
                    List<Expr> elt_temp_invariantsClause = temp_invariantsClause.unwrap();
                    if (elt_temp_invariantsClause == null) w.visitNull();
                    else {
                        if (w.visitIterated(elt_temp_invariantsClause)) {
                            int i_elt_temp_invariantsClause = 0;
                            for (Expr elt_elt_temp_invariantsClause : elt_temp_invariantsClause) {
                                if (w.visitIteratedElement(i_elt_temp_invariantsClause, elt_elt_temp_invariantsClause)) {
                                    if (elt_elt_temp_invariantsClause == null) w.visitNull();
                                    else {
                                        elt_elt_temp_invariantsClause.walk(w);
                                    }
                                }
                                i_elt_temp_invariantsClause++;
                            }
                            w.endIterated(elt_temp_invariantsClause, i_elt_temp_invariantsClause);
                        }
                    }
                    w.endNonEmptyOption(temp_invariantsClause);
                }
                w.endNodeField("invariantsClause", temp_invariantsClause);
            }
            w.endNode(this, "Contract", 4);
        }
    }

}
