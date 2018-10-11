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
 * Class BoolArg, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class BoolArg extends StaticArg {
    private final BoolExpr _boolArg;

    /**
     * Constructs a BoolArg.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public BoolArg(ASTNodeInfo in_info, boolean in_lifted, BoolExpr in_boolArg) {
        super(in_info, in_lifted);
        if (in_boolArg == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'boolArg' to the BoolArg constructor was null");
        }
        _boolArg = in_boolArg;
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public BoolArg(ASTNodeInfo in_info, BoolExpr in_boolArg) {
        this(in_info, false, in_boolArg);
    }

    final public BoolExpr getBoolArg() { return _boolArg; }

    public <RetType> RetType accept(StaticArgVisitor<RetType> visitor) {
        return visitor.forBoolArg(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forBoolArg(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forBoolArg(this);
    }

    public void accept(StaticArgVisitor_void visitor) {
        visitor.forBoolArg(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forBoolArg(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forBoolArg(this);
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
            BoolArg casted = (BoolArg) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            BoolExpr temp_boolArg = getBoolArg();
            BoolExpr casted_boolArg = casted.getBoolArg();
            if (!(temp_boolArg == casted_boolArg || temp_boolArg.equals(casted_boolArg))) return false;
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
        BoolExpr temp_boolArg = getBoolArg();
        code ^= temp_boolArg.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected BoolArg() {
        _boolArg = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected BoolArg(ASTNodeInfo info) {
        super(info);
        _boolArg = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "BoolArg", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            boolean temp_lifted = isLifted();
            if (w.visitNodeField("lifted", temp_lifted)) {
                w.visitBoolean(temp_lifted);
                w.endNodeField("lifted", temp_lifted);
            }
            BoolExpr temp_boolArg = getBoolArg();
            if (w.visitNodeField("boolArg", temp_boolArg)) {
                temp_boolArg.walk(w);
                w.endNodeField("boolArg", temp_boolArg);
            }
            w.endNode(this, "BoolArg", 3);
        }
    }

}
