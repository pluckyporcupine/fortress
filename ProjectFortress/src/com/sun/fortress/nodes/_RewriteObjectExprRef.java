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
 * Class _RewriteObjectExprRef, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _RewriteObjectExprRef extends Primary {
    private final String _genSymName;
    private final List<StaticArg> _staticArgs;

    /**
     * Constructs a _RewriteObjectExprRef.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _RewriteObjectExprRef(ExprInfo in_info, String in_genSymName, List<StaticArg> in_staticArgs) {
        super(in_info);
        if (in_genSymName == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'genSymName' to the _RewriteObjectExprRef constructor was null");
        }
        _genSymName = in_genSymName.intern();
        if (in_staticArgs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'staticArgs' to the _RewriteObjectExprRef constructor was null");
        }
        _staticArgs = in_staticArgs;
    }

    final public String getGenSymName() { return _genSymName; }
    final public List<StaticArg> getStaticArgs() { return _staticArgs; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.for_RewriteObjectExprRef(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_RewriteObjectExprRef(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_RewriteObjectExprRef(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.for_RewriteObjectExprRef(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_RewriteObjectExprRef(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_RewriteObjectExprRef(this);
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
            _RewriteObjectExprRef casted = (_RewriteObjectExprRef) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            String temp_genSymName = getGenSymName();
            String casted_genSymName = casted.getGenSymName();
            if (!(temp_genSymName == casted_genSymName)) return false;
            List<StaticArg> temp_staticArgs = getStaticArgs();
            List<StaticArg> casted_staticArgs = casted.getStaticArgs();
            if (!(temp_staticArgs == casted_staticArgs || temp_staticArgs.equals(casted_staticArgs))) return false;
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
        String temp_genSymName = getGenSymName();
        code ^= temp_genSymName.hashCode();
        List<StaticArg> temp_staticArgs = getStaticArgs();
        code ^= temp_staticArgs.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected _RewriteObjectExprRef() {
        _genSymName = null;
        _staticArgs = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _RewriteObjectExprRef(ExprInfo info) {
        super(info);
        _genSymName = null;
        _staticArgs = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_RewriteObjectExprRef", 3)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            String temp_genSymName = getGenSymName();
            if (w.visitNodeField("genSymName", temp_genSymName)) {
                w.visitString(temp_genSymName);
                w.endNodeField("genSymName", temp_genSymName);
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
            w.endNode(this, "_RewriteObjectExprRef", 3);
        }
    }

}
