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
 * Class DimArg, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class DimArg extends StaticArg {
    private final DimExpr _dimArg;

    /**
     * Constructs a DimArg.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public DimArg(ASTNodeInfo in_info, boolean in_lifted, DimExpr in_dimArg) {
        super(in_info, in_lifted);
        if (in_dimArg == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'dimArg' to the DimArg constructor was null");
        }
        _dimArg = in_dimArg;
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public DimArg(ASTNodeInfo in_info, DimExpr in_dimArg) {
        this(in_info, false, in_dimArg);
    }

    final public DimExpr getDimArg() { return _dimArg; }

    public <RetType> RetType accept(StaticArgVisitor<RetType> visitor) {
        return visitor.forDimArg(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forDimArg(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forDimArg(this);
    }

    public void accept(StaticArgVisitor_void visitor) {
        visitor.forDimArg(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forDimArg(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forDimArg(this);
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
            DimArg casted = (DimArg) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            DimExpr temp_dimArg = getDimArg();
            DimExpr casted_dimArg = casted.getDimArg();
            if (!(temp_dimArg == casted_dimArg || temp_dimArg.equals(casted_dimArg))) return false;
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
        DimExpr temp_dimArg = getDimArg();
        code ^= temp_dimArg.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected DimArg() {
        _dimArg = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected DimArg(ASTNodeInfo info) {
        super(info);
        _dimArg = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "DimArg", 3)) {
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
            DimExpr temp_dimArg = getDimArg();
            if (w.visitNodeField("dimArg", temp_dimArg)) {
                temp_dimArg.walk(w);
                w.endNodeField("dimArg", temp_dimArg);
            }
            w.endNode(this, "DimArg", 3);
        }
    }

}
