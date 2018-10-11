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
 * Class UnitArg, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class UnitArg extends StaticArg {
    private final UnitExpr _unitArg;

    /**
     * Constructs a UnitArg.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public UnitArg(ASTNodeInfo in_info, boolean in_lifted, UnitExpr in_unitArg) {
        super(in_info, in_lifted);
        if (in_unitArg == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'unitArg' to the UnitArg constructor was null");
        }
        _unitArg = in_unitArg;
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public UnitArg(ASTNodeInfo in_info, UnitExpr in_unitArg) {
        this(in_info, false, in_unitArg);
    }

    final public UnitExpr getUnitArg() { return _unitArg; }

    public <RetType> RetType accept(StaticArgVisitor<RetType> visitor) {
        return visitor.forUnitArg(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forUnitArg(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forUnitArg(this);
    }

    public void accept(StaticArgVisitor_void visitor) {
        visitor.forUnitArg(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forUnitArg(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forUnitArg(this);
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
            UnitArg casted = (UnitArg) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            UnitExpr temp_unitArg = getUnitArg();
            UnitExpr casted_unitArg = casted.getUnitArg();
            if (!(temp_unitArg == casted_unitArg || temp_unitArg.equals(casted_unitArg))) return false;
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
        UnitExpr temp_unitArg = getUnitArg();
        code ^= temp_unitArg.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected UnitArg() {
        _unitArg = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected UnitArg(ASTNodeInfo info) {
        super(info);
        _unitArg = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "UnitArg", 3)) {
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
            UnitExpr temp_unitArg = getUnitArg();
            if (w.visitNodeField("unitArg", temp_unitArg)) {
                temp_unitArg.walk(w);
                w.endNodeField("unitArg", temp_unitArg);
            }
            w.endNode(this, "UnitArg", 3);
        }
    }

}
