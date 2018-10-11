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
 * Class TypeArg, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class TypeArg extends StaticArg {
    private final Type _typeArg;

    /**
     * Constructs a TypeArg.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TypeArg(ASTNodeInfo in_info, boolean in_lifted, Type in_typeArg) {
        super(in_info, in_lifted);
        if (in_typeArg == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'typeArg' to the TypeArg constructor was null");
        }
        _typeArg = in_typeArg;
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public TypeArg(ASTNodeInfo in_info, Type in_typeArg) {
        this(in_info, false, in_typeArg);
    }

    final public Type getTypeArg() { return _typeArg; }

    public <RetType> RetType accept(StaticArgVisitor<RetType> visitor) {
        return visitor.forTypeArg(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTypeArg(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTypeArg(this);
    }

    public void accept(StaticArgVisitor_void visitor) {
        visitor.forTypeArg(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTypeArg(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTypeArg(this);
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
            TypeArg casted = (TypeArg) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Type temp_typeArg = getTypeArg();
            Type casted_typeArg = casted.getTypeArg();
            if (!(temp_typeArg == casted_typeArg || temp_typeArg.equals(casted_typeArg))) return false;
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
        Type temp_typeArg = getTypeArg();
        code ^= temp_typeArg.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TypeArg() {
        _typeArg = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TypeArg(ASTNodeInfo info) {
        super(info);
        _typeArg = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TypeArg", 3)) {
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
            Type temp_typeArg = getTypeArg();
            if (w.visitNodeField("typeArg", temp_typeArg)) {
                temp_typeArg.walk(w);
                w.endNodeField("typeArg", temp_typeArg);
            }
            w.endNode(this, "TypeArg", 3);
        }
    }

}
