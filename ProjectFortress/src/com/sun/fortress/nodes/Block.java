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
 * Class Block, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class Block extends Expr {
    private final Option<Expr> _loc;
    private final boolean _atomicBlock;
    private final boolean _withinDo;
    private final List<Expr> _exprs;

    /**
     * Constructs a Block.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Block(ExprInfo in_info, Option<Expr> in_loc, boolean in_atomicBlock, boolean in_withinDo, List<Expr> in_exprs) {
        super(in_info);
        if (in_loc == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'loc' to the Block constructor was null");
        }
        _loc = in_loc;
        _atomicBlock = in_atomicBlock;
        _withinDo = in_withinDo;
        if (in_exprs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'exprs' to the Block constructor was null");
        }
        _exprs = in_exprs;
    }

    final public Option<Expr> getLoc() { return _loc; }
    final public boolean isAtomicBlock() { return _atomicBlock; }
    final public boolean isWithinDo() { return _withinDo; }
    final public List<Expr> getExprs() { return _exprs; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forBlock(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forBlock(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forBlock(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forBlock(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forBlock(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forBlock(this);
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
            Block casted = (Block) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<Expr> temp_loc = getLoc();
            Option<Expr> casted_loc = casted.getLoc();
            if (!(temp_loc == casted_loc || temp_loc.equals(casted_loc))) return false;
            boolean temp_atomicBlock = isAtomicBlock();
            boolean casted_atomicBlock = casted.isAtomicBlock();
            if (!(temp_atomicBlock == casted_atomicBlock)) return false;
            boolean temp_withinDo = isWithinDo();
            boolean casted_withinDo = casted.isWithinDo();
            if (!(temp_withinDo == casted_withinDo)) return false;
            List<Expr> temp_exprs = getExprs();
            List<Expr> casted_exprs = casted.getExprs();
            if (!(temp_exprs == casted_exprs || temp_exprs.equals(casted_exprs))) return false;
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
        Option<Expr> temp_loc = getLoc();
        code ^= temp_loc.hashCode();
        boolean temp_atomicBlock = isAtomicBlock();
        code ^= temp_atomicBlock ? 1231 : 1237;
        boolean temp_withinDo = isWithinDo();
        code ^= temp_withinDo ? 1231 : 1237;
        List<Expr> temp_exprs = getExprs();
        code ^= temp_exprs.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Block() {
        _loc = null;
        _atomicBlock = false;
        _withinDo = false;
        _exprs = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Block(ExprInfo info) {
        super(info);
        _loc = null;
        _atomicBlock = false;
        _withinDo = false;
        _exprs = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "Block", 5)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Option<Expr> temp_loc = getLoc();
            if (w.visitNodeField("loc", temp_loc)) {
                if (temp_loc.isNone()) {
                    w.visitEmptyOption(temp_loc);
                }
                else if (w.visitNonEmptyOption(temp_loc)) {
                    Expr elt_temp_loc = temp_loc.unwrap();
                    if (elt_temp_loc == null) w.visitNull();
                    else {
                        elt_temp_loc.walk(w);
                    }
                    w.endNonEmptyOption(temp_loc);
                }
                w.endNodeField("loc", temp_loc);
            }
            boolean temp_atomicBlock = isAtomicBlock();
            if (w.visitNodeField("atomicBlock", temp_atomicBlock)) {
                w.visitBoolean(temp_atomicBlock);
                w.endNodeField("atomicBlock", temp_atomicBlock);
            }
            boolean temp_withinDo = isWithinDo();
            if (w.visitNodeField("withinDo", temp_withinDo)) {
                w.visitBoolean(temp_withinDo);
                w.endNodeField("withinDo", temp_withinDo);
            }
            List<Expr> temp_exprs = getExprs();
            if (w.visitNodeField("exprs", temp_exprs)) {
                if (w.visitIterated(temp_exprs)) {
                    int i_temp_exprs = 0;
                    for (Expr elt_temp_exprs : temp_exprs) {
                        if (w.visitIteratedElement(i_temp_exprs, elt_temp_exprs)) {
                            if (elt_temp_exprs == null) w.visitNull();
                            else {
                                elt_temp_exprs.walk(w);
                            }
                        }
                        i_temp_exprs++;
                    }
                    w.endIterated(temp_exprs, i_temp_exprs);
                }
                w.endNodeField("exprs", temp_exprs);
            }
            w.endNode(this, "Block", 5);
        }
    }

}
