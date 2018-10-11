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
 * Class CaseClause, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class CaseClause extends AbstractNode {
    private final Expr _matchClause;
    private final Block _body;
    private final Option<FunctionalRef> _op;

    /**
     * Constructs a CaseClause.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public CaseClause(ASTNodeInfo in_info, Expr in_matchClause, Block in_body, Option<FunctionalRef> in_op) {
        super(in_info);
        if (in_matchClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'matchClause' to the CaseClause constructor was null");
        }
        _matchClause = in_matchClause;
        if (in_body == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'body' to the CaseClause constructor was null");
        }
        _body = in_body;
        if (in_op == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'op' to the CaseClause constructor was null");
        }
        _op = in_op;
    }

    final public Expr getMatchClause() { return _matchClause; }
    final public Block getBody() { return _body; }
    final public Option<FunctionalRef> getOp() { return _op; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forCaseClause(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forCaseClause(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forCaseClause(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forCaseClause(this);
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
            CaseClause casted = (CaseClause) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Expr temp_matchClause = getMatchClause();
            Expr casted_matchClause = casted.getMatchClause();
            if (!(temp_matchClause == casted_matchClause || temp_matchClause.equals(casted_matchClause))) return false;
            Block temp_body = getBody();
            Block casted_body = casted.getBody();
            if (!(temp_body == casted_body || temp_body.equals(casted_body))) return false;
            Option<FunctionalRef> temp_op = getOp();
            Option<FunctionalRef> casted_op = casted.getOp();
            if (!(temp_op == casted_op || temp_op.equals(casted_op))) return false;
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
        Expr temp_matchClause = getMatchClause();
        code ^= temp_matchClause.hashCode();
        Block temp_body = getBody();
        code ^= temp_body.hashCode();
        Option<FunctionalRef> temp_op = getOp();
        code ^= temp_op.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected CaseClause() {
        _matchClause = null;
        _body = null;
        _op = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected CaseClause(ASTNodeInfo info) {
        super(info);
        _matchClause = null;
        _body = null;
        _op = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "CaseClause", 4)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Expr temp_matchClause = getMatchClause();
            if (w.visitNodeField("matchClause", temp_matchClause)) {
                temp_matchClause.walk(w);
                w.endNodeField("matchClause", temp_matchClause);
            }
            Block temp_body = getBody();
            if (w.visitNodeField("body", temp_body)) {
                temp_body.walk(w);
                w.endNodeField("body", temp_body);
            }
            Option<FunctionalRef> temp_op = getOp();
            if (w.visitNodeField("op", temp_op)) {
                if (temp_op.isNone()) {
                    w.visitEmptyOption(temp_op);
                }
                else if (w.visitNonEmptyOption(temp_op)) {
                    FunctionalRef elt_temp_op = temp_op.unwrap();
                    if (elt_temp_op == null) w.visitNull();
                    else {
                        elt_temp_op.walk(w);
                    }
                    w.endNonEmptyOption(temp_op);
                }
                w.endNodeField("op", temp_op);
            }
            w.endNode(this, "CaseClause", 4);
        }
    }

}
