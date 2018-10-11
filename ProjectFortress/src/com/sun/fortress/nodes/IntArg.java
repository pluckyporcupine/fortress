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
 * Class IntArg, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class IntArg extends StaticArg {
    private final IntExpr _intVal;

    /**
     * Constructs a IntArg.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public IntArg(ASTNodeInfo in_info, boolean in_lifted, IntExpr in_intVal) {
        super(in_info, in_lifted);
        if (in_intVal == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'intVal' to the IntArg constructor was null");
        }
        _intVal = in_intVal;
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public IntArg(ASTNodeInfo in_info, IntExpr in_intVal) {
        this(in_info, false, in_intVal);
    }

    final public IntExpr getIntVal() { return _intVal; }

    public <RetType> RetType accept(StaticArgVisitor<RetType> visitor) {
        return visitor.forIntArg(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forIntArg(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forIntArg(this);
    }

    public void accept(StaticArgVisitor_void visitor) {
        visitor.forIntArg(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forIntArg(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forIntArg(this);
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
            IntArg casted = (IntArg) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            IntExpr temp_intVal = getIntVal();
            IntExpr casted_intVal = casted.getIntVal();
            if (!(temp_intVal == casted_intVal || temp_intVal.equals(casted_intVal))) return false;
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
        IntExpr temp_intVal = getIntVal();
        code ^= temp_intVal.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected IntArg() {
        _intVal = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected IntArg(ASTNodeInfo info) {
        super(info);
        _intVal = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "IntArg", 3)) {
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
            IntExpr temp_intVal = getIntVal();
            if (w.visitNodeField("intVal", temp_intVal)) {
                temp_intVal.walk(w);
                w.endNodeField("intVal", temp_intVal);
            }
            w.endNode(this, "IntArg", 3);
        }
    }

}
