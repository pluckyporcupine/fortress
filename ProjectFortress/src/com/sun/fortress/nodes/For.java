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
 * Class For, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class For extends Expr {
    private final List<GeneratorClause> _gens;
    private final Block _body;

    /**
     * Constructs a For.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public For(ExprInfo in_info, List<GeneratorClause> in_gens, Block in_body) {
        super(in_info);
        if (in_gens == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'gens' to the For constructor was null");
        }
        _gens = in_gens;
        if (in_body == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'body' to the For constructor was null");
        }
        _body = in_body;
    }

    final public List<GeneratorClause> getGens() { return _gens; }
    final public Block getBody() { return _body; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forFor(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forFor(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forFor(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forFor(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forFor(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forFor(this);
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
            For casted = (For) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<GeneratorClause> temp_gens = getGens();
            List<GeneratorClause> casted_gens = casted.getGens();
            if (!(temp_gens == casted_gens || temp_gens.equals(casted_gens))) return false;
            Block temp_body = getBody();
            Block casted_body = casted.getBody();
            if (!(temp_body == casted_body || temp_body.equals(casted_body))) return false;
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
        List<GeneratorClause> temp_gens = getGens();
        code ^= temp_gens.hashCode();
        Block temp_body = getBody();
        code ^= temp_body.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected For() {
        _gens = null;
        _body = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected For(ExprInfo info) {
        super(info);
        _gens = null;
        _body = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "For", 3)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<GeneratorClause> temp_gens = getGens();
            if (w.visitNodeField("gens", temp_gens)) {
                if (w.visitIterated(temp_gens)) {
                    int i_temp_gens = 0;
                    for (GeneratorClause elt_temp_gens : temp_gens) {
                        if (w.visitIteratedElement(i_temp_gens, elt_temp_gens)) {
                            if (elt_temp_gens == null) w.visitNull();
                            else {
                                elt_temp_gens.walk(w);
                            }
                        }
                        i_temp_gens++;
                    }
                    w.endIterated(temp_gens, i_temp_gens);
                }
                w.endNodeField("gens", temp_gens);
            }
            Block temp_body = getBody();
            if (w.visitNodeField("body", temp_body)) {
                temp_body.walk(w);
                w.endNodeField("body", temp_body);
            }
            w.endNode(this, "For", 3);
        }
    }

}
