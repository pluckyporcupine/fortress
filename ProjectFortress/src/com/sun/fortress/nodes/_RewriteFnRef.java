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
 * Class _RewriteFnRef, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _RewriteFnRef extends Primary {
    private final Expr _fnExpr;
    private final List<StaticArg> _staticArgs;

    /**
     * Constructs a _RewriteFnRef.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _RewriteFnRef(ExprInfo in_info, Expr in_fnExpr, List<StaticArg> in_staticArgs) {
        super(in_info);
        if (in_fnExpr == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'fnExpr' to the _RewriteFnRef constructor was null");
        }
        _fnExpr = in_fnExpr;
        if (in_staticArgs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'staticArgs' to the _RewriteFnRef constructor was null");
        }
        _staticArgs = in_staticArgs;
    }

    final public Expr getFnExpr() { return _fnExpr; }
    final public List<StaticArg> getStaticArgs() { return _staticArgs; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.for_RewriteFnRef(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_RewriteFnRef(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_RewriteFnRef(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.for_RewriteFnRef(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_RewriteFnRef(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_RewriteFnRef(this);
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
            _RewriteFnRef casted = (_RewriteFnRef) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Expr temp_fnExpr = getFnExpr();
            Expr casted_fnExpr = casted.getFnExpr();
            if (!(temp_fnExpr == casted_fnExpr || temp_fnExpr.equals(casted_fnExpr))) return false;
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
        Expr temp_fnExpr = getFnExpr();
        code ^= temp_fnExpr.hashCode();
        List<StaticArg> temp_staticArgs = getStaticArgs();
        code ^= temp_staticArgs.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected _RewriteFnRef() {
        _fnExpr = null;
        _staticArgs = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _RewriteFnRef(ExprInfo info) {
        super(info);
        _fnExpr = null;
        _staticArgs = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_RewriteFnRef", 3)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Expr temp_fnExpr = getFnExpr();
            if (w.visitNodeField("fnExpr", temp_fnExpr)) {
                temp_fnExpr.walk(w);
                w.endNodeField("fnExpr", temp_fnExpr);
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
            w.endNode(this, "_RewriteFnRef", 3);
        }
    }

}
