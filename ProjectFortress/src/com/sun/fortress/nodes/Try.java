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
 * Class Try, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class Try extends Expr {
    private final Block _body;
    private final Option<Catch> _catchClause;
    private final List<BaseType> _forbidClause;
    private final Option<Block> _finallyClause;

    /**
     * Constructs a Try.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Try(ExprInfo in_info, Block in_body, Option<Catch> in_catchClause, List<BaseType> in_forbidClause, Option<Block> in_finallyClause) {
        super(in_info);
        if (in_body == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'body' to the Try constructor was null");
        }
        _body = in_body;
        if (in_catchClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'catchClause' to the Try constructor was null");
        }
        _catchClause = in_catchClause;
        if (in_forbidClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'forbidClause' to the Try constructor was null");
        }
        _forbidClause = in_forbidClause;
        if (in_finallyClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'finallyClause' to the Try constructor was null");
        }
        _finallyClause = in_finallyClause;
    }

    final public Block getBody() { return _body; }
    final public Option<Catch> getCatchClause() { return _catchClause; }
    final public List<BaseType> getForbidClause() { return _forbidClause; }
    final public Option<Block> getFinallyClause() { return _finallyClause; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forTry(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTry(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTry(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forTry(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTry(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTry(this);
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
            Try casted = (Try) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Block temp_body = getBody();
            Block casted_body = casted.getBody();
            if (!(temp_body == casted_body || temp_body.equals(casted_body))) return false;
            Option<Catch> temp_catchClause = getCatchClause();
            Option<Catch> casted_catchClause = casted.getCatchClause();
            if (!(temp_catchClause == casted_catchClause || temp_catchClause.equals(casted_catchClause))) return false;
            List<BaseType> temp_forbidClause = getForbidClause();
            List<BaseType> casted_forbidClause = casted.getForbidClause();
            if (!(temp_forbidClause == casted_forbidClause || temp_forbidClause.equals(casted_forbidClause))) return false;
            Option<Block> temp_finallyClause = getFinallyClause();
            Option<Block> casted_finallyClause = casted.getFinallyClause();
            if (!(temp_finallyClause == casted_finallyClause || temp_finallyClause.equals(casted_finallyClause))) return false;
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
        Block temp_body = getBody();
        code ^= temp_body.hashCode();
        Option<Catch> temp_catchClause = getCatchClause();
        code ^= temp_catchClause.hashCode();
        List<BaseType> temp_forbidClause = getForbidClause();
        code ^= temp_forbidClause.hashCode();
        Option<Block> temp_finallyClause = getFinallyClause();
        code ^= temp_finallyClause.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Try() {
        _body = null;
        _catchClause = null;
        _forbidClause = null;
        _finallyClause = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Try(ExprInfo info) {
        super(info);
        _body = null;
        _catchClause = null;
        _forbidClause = null;
        _finallyClause = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "Try", 5)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Block temp_body = getBody();
            if (w.visitNodeField("body", temp_body)) {
                temp_body.walk(w);
                w.endNodeField("body", temp_body);
            }
            Option<Catch> temp_catchClause = getCatchClause();
            if (w.visitNodeField("catchClause", temp_catchClause)) {
                if (temp_catchClause.isNone()) {
                    w.visitEmptyOption(temp_catchClause);
                }
                else if (w.visitNonEmptyOption(temp_catchClause)) {
                    Catch elt_temp_catchClause = temp_catchClause.unwrap();
                    if (elt_temp_catchClause == null) w.visitNull();
                    else {
                        elt_temp_catchClause.walk(w);
                    }
                    w.endNonEmptyOption(temp_catchClause);
                }
                w.endNodeField("catchClause", temp_catchClause);
            }
            List<BaseType> temp_forbidClause = getForbidClause();
            if (w.visitNodeField("forbidClause", temp_forbidClause)) {
                if (w.visitIterated(temp_forbidClause)) {
                    int i_temp_forbidClause = 0;
                    for (BaseType elt_temp_forbidClause : temp_forbidClause) {
                        if (w.visitIteratedElement(i_temp_forbidClause, elt_temp_forbidClause)) {
                            if (elt_temp_forbidClause == null) w.visitNull();
                            else {
                                elt_temp_forbidClause.walk(w);
                            }
                        }
                        i_temp_forbidClause++;
                    }
                    w.endIterated(temp_forbidClause, i_temp_forbidClause);
                }
                w.endNodeField("forbidClause", temp_forbidClause);
            }
            Option<Block> temp_finallyClause = getFinallyClause();
            if (w.visitNodeField("finallyClause", temp_finallyClause)) {
                if (temp_finallyClause.isNone()) {
                    w.visitEmptyOption(temp_finallyClause);
                }
                else if (w.visitNonEmptyOption(temp_finallyClause)) {
                    Block elt_temp_finallyClause = temp_finallyClause.unwrap();
                    if (elt_temp_finallyClause == null) w.visitNull();
                    else {
                        elt_temp_finallyClause.walk(w);
                    }
                    w.endNonEmptyOption(temp_finallyClause);
                }
                w.endNodeField("finallyClause", temp_finallyClause);
            }
            w.endNode(this, "Try", 5);
        }
    }

}
