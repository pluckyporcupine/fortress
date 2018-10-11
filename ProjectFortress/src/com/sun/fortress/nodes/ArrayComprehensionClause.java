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
 * Class ArrayComprehensionClause, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ArrayComprehensionClause extends AbstractNode {
    private final List<Expr> _bind;
    private final Expr _init;
    private final List<GeneratorClause> _gens;

    /**
     * Constructs a ArrayComprehensionClause.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ArrayComprehensionClause(ASTNodeInfo in_info, List<Expr> in_bind, Expr in_init, List<GeneratorClause> in_gens) {
        super(in_info);
        if (in_bind == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'bind' to the ArrayComprehensionClause constructor was null");
        }
        _bind = in_bind;
        if (in_init == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'init' to the ArrayComprehensionClause constructor was null");
        }
        _init = in_init;
        if (in_gens == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'gens' to the ArrayComprehensionClause constructor was null");
        }
        _gens = in_gens;
    }

    final public List<Expr> getBind() { return _bind; }
    final public Expr getInit() { return _init; }
    final public List<GeneratorClause> getGens() { return _gens; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forArrayComprehensionClause(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forArrayComprehensionClause(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forArrayComprehensionClause(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forArrayComprehensionClause(this);
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
            ArrayComprehensionClause casted = (ArrayComprehensionClause) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<Expr> temp_bind = getBind();
            List<Expr> casted_bind = casted.getBind();
            if (!(temp_bind == casted_bind || temp_bind.equals(casted_bind))) return false;
            Expr temp_init = getInit();
            Expr casted_init = casted.getInit();
            if (!(temp_init == casted_init || temp_init.equals(casted_init))) return false;
            List<GeneratorClause> temp_gens = getGens();
            List<GeneratorClause> casted_gens = casted.getGens();
            if (!(temp_gens == casted_gens || temp_gens.equals(casted_gens))) return false;
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
        List<Expr> temp_bind = getBind();
        code ^= temp_bind.hashCode();
        Expr temp_init = getInit();
        code ^= temp_init.hashCode();
        List<GeneratorClause> temp_gens = getGens();
        code ^= temp_gens.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ArrayComprehensionClause() {
        _bind = null;
        _init = null;
        _gens = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ArrayComprehensionClause(ASTNodeInfo info) {
        super(info);
        _bind = null;
        _init = null;
        _gens = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ArrayComprehensionClause", 4)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<Expr> temp_bind = getBind();
            if (w.visitNodeField("bind", temp_bind)) {
                if (w.visitIterated(temp_bind)) {
                    int i_temp_bind = 0;
                    for (Expr elt_temp_bind : temp_bind) {
                        if (w.visitIteratedElement(i_temp_bind, elt_temp_bind)) {
                            if (elt_temp_bind == null) w.visitNull();
                            else {
                                elt_temp_bind.walk(w);
                            }
                        }
                        i_temp_bind++;
                    }
                    w.endIterated(temp_bind, i_temp_bind);
                }
                w.endNodeField("bind", temp_bind);
            }
            Expr temp_init = getInit();
            if (w.visitNodeField("init", temp_init)) {
                temp_init.walk(w);
                w.endNodeField("init", temp_init);
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
            w.endNode(this, "ArrayComprehensionClause", 4);
        }
    }

}
