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
 * Class VarRef, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class VarRef extends Primary implements Lhs {
    private final Id _varId;
    private final List<StaticArg> _staticArgs;
    private final int _lexicalDepth;

    /**
     * Constructs a VarRef.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public VarRef(ExprInfo in_info, Id in_varId, List<StaticArg> in_staticArgs, int in_lexicalDepth) {
        super(in_info);
        if (in_varId == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'varId' to the VarRef constructor was null");
        }
        _varId = in_varId;
        if (in_staticArgs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'staticArgs' to the VarRef constructor was null");
        }
        _staticArgs = in_staticArgs;
        _lexicalDepth = in_lexicalDepth;
    }

    final public Id getVarId() { return _varId; }
    final public List<StaticArg> getStaticArgs() { return _staticArgs; }
    final public int getLexicalDepth() { return _lexicalDepth; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forVarRef(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forVarRef(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forVarRef(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forVarRef(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forVarRef(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forVarRef(this);
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
            VarRef casted = (VarRef) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_varId = getVarId();
            Id casted_varId = casted.getVarId();
            if (!(temp_varId == casted_varId || temp_varId.equals(casted_varId))) return false;
            List<StaticArg> temp_staticArgs = getStaticArgs();
            List<StaticArg> casted_staticArgs = casted.getStaticArgs();
            if (!(temp_staticArgs == casted_staticArgs || temp_staticArgs.equals(casted_staticArgs))) return false;
            int temp_lexicalDepth = getLexicalDepth();
            int casted_lexicalDepth = casted.getLexicalDepth();
            if (!(temp_lexicalDepth == casted_lexicalDepth)) return false;
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
        Id temp_varId = getVarId();
        code ^= temp_varId.hashCode();
        List<StaticArg> temp_staticArgs = getStaticArgs();
        code ^= temp_staticArgs.hashCode();
        int temp_lexicalDepth = getLexicalDepth();
        code ^= temp_lexicalDepth;
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected VarRef() {
        _varId = null;
        _staticArgs = null;
        _lexicalDepth = 0;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected VarRef(ExprInfo info) {
        super(info);
        _varId = null;
        _staticArgs = null;
        _lexicalDepth = 0;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "VarRef", 4)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Id temp_varId = getVarId();
            if (w.visitNodeField("varId", temp_varId)) {
                temp_varId.walk(w);
                w.endNodeField("varId", temp_varId);
            }
            List<StaticArg> temp_staticArgs = getStaticArgs();
            if (w.visitNodeField("staticArgs", temp_staticArgs)) {
                if (w.visitIterated(temp_staticArgs)) {
                    int i_temp_staticArgs = 0;
                    for (StaticArg elt_temp_staticArgs : temp_staticArgs) {
                        if (w.visitIteratedElement(i_temp_staticArgs, elt_temp_staticArgs)) {
                            if (elt_temp_staticArgs == null) w.visitNull();
                            else {
                                elt_temp_staticArgs.walk(w);
                            }
                        }
                        i_temp_staticArgs++;
                    }
                    w.endIterated(temp_staticArgs, i_temp_staticArgs);
                }
                w.endNodeField("staticArgs", temp_staticArgs);
            }
            int temp_lexicalDepth = getLexicalDepth();
            if (w.visitNodeField("lexicalDepth", temp_lexicalDepth)) {
                w.visitInt(temp_lexicalDepth);
                w.endNodeField("lexicalDepth", temp_lexicalDepth);
            }
            w.endNode(this, "VarRef", 4);
        }
    }

}
