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
 * Class MethodInvocation, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class MethodInvocation extends Primary {
    private final Expr _obj;
    private final IdOrOp _method;
    private final List<StaticArg> _staticArgs;
    private final Expr _arg;
    private final Option<Type> _overloadingType;
    private final Option<Type> _overloadingSchema;

    /**
     * Constructs a MethodInvocation.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public MethodInvocation(ExprInfo in_info, Expr in_obj, IdOrOp in_method, List<StaticArg> in_staticArgs, Expr in_arg, Option<Type> in_overloadingType, Option<Type> in_overloadingSchema) {
        super(in_info);
        if (in_obj == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'obj' to the MethodInvocation constructor was null");
        }
        _obj = in_obj;
        if (in_method == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'method' to the MethodInvocation constructor was null");
        }
        _method = in_method;
        if (in_staticArgs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'staticArgs' to the MethodInvocation constructor was null");
        }
        _staticArgs = in_staticArgs;
        if (in_arg == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'arg' to the MethodInvocation constructor was null");
        }
        _arg = in_arg;
        if (in_overloadingType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'overloadingType' to the MethodInvocation constructor was null");
        }
        _overloadingType = in_overloadingType;
        if (in_overloadingSchema == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'overloadingSchema' to the MethodInvocation constructor was null");
        }
        _overloadingSchema = in_overloadingSchema;
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public MethodInvocation(ExprInfo in_info, Expr in_obj, IdOrOp in_method, List<StaticArg> in_staticArgs, Expr in_arg, Option<Type> in_overloadingType) {
        this(in_info, in_obj, in_method, in_staticArgs, in_arg, in_overloadingType, Option.<Type>none());
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public MethodInvocation(ExprInfo in_info, Expr in_obj, IdOrOp in_method, List<StaticArg> in_staticArgs, Expr in_arg) {
        this(in_info, in_obj, in_method, in_staticArgs, in_arg, Option.<Type>none(), Option.<Type>none());
    }

    final public Expr getObj() { return _obj; }
    final public IdOrOp getMethod() { return _method; }
    final public List<StaticArg> getStaticArgs() { return _staticArgs; }
    final public Expr getArg() { return _arg; }
    final public Option<Type> getOverloadingType() { return _overloadingType; }
    final public Option<Type> getOverloadingSchema() { return _overloadingSchema; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forMethodInvocation(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forMethodInvocation(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forMethodInvocation(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forMethodInvocation(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forMethodInvocation(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forMethodInvocation(this);
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
            MethodInvocation casted = (MethodInvocation) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Expr temp_obj = getObj();
            Expr casted_obj = casted.getObj();
            if (!(temp_obj == casted_obj || temp_obj.equals(casted_obj))) return false;
            IdOrOp temp_method = getMethod();
            IdOrOp casted_method = casted.getMethod();
            if (!(temp_method == casted_method || temp_method.equals(casted_method))) return false;
            List<StaticArg> temp_staticArgs = getStaticArgs();
            List<StaticArg> casted_staticArgs = casted.getStaticArgs();
            if (!(temp_staticArgs == casted_staticArgs || temp_staticArgs.equals(casted_staticArgs))) return false;
            Expr temp_arg = getArg();
            Expr casted_arg = casted.getArg();
            if (!(temp_arg == casted_arg || temp_arg.equals(casted_arg))) return false;
            Option<Type> temp_overloadingType = getOverloadingType();
            Option<Type> casted_overloadingType = casted.getOverloadingType();
            if (!(temp_overloadingType == casted_overloadingType || temp_overloadingType.equals(casted_overloadingType))) return false;
            Option<Type> temp_overloadingSchema = getOverloadingSchema();
            Option<Type> casted_overloadingSchema = casted.getOverloadingSchema();
            if (!(temp_overloadingSchema == casted_overloadingSchema || temp_overloadingSchema.equals(casted_overloadingSchema))) return false;
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
        Expr temp_obj = getObj();
        code ^= temp_obj.hashCode();
        IdOrOp temp_method = getMethod();
        code ^= temp_method.hashCode();
        List<StaticArg> temp_staticArgs = getStaticArgs();
        code ^= temp_staticArgs.hashCode();
        Expr temp_arg = getArg();
        code ^= temp_arg.hashCode();
        Option<Type> temp_overloadingType = getOverloadingType();
        code ^= temp_overloadingType.hashCode();
        Option<Type> temp_overloadingSchema = getOverloadingSchema();
        code ^= temp_overloadingSchema.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected MethodInvocation() {
        _obj = null;
        _method = null;
        _staticArgs = null;
        _arg = null;
        _overloadingType = null;
        _overloadingSchema = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected MethodInvocation(ExprInfo info) {
        super(info);
        _obj = null;
        _method = null;
        _staticArgs = null;
        _arg = null;
        _overloadingType = null;
        _overloadingSchema = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "MethodInvocation", 7)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Expr temp_obj = getObj();
            if (w.visitNodeField("obj", temp_obj)) {
                temp_obj.walk(w);
                w.endNodeField("obj", temp_obj);
            }
            IdOrOp temp_method = getMethod();
            if (w.visitNodeField("method", temp_method)) {
                temp_method.walk(w);
                w.endNodeField("method", temp_method);
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
            Expr temp_arg = getArg();
            if (w.visitNodeField("arg", temp_arg)) {
                temp_arg.walk(w);
                w.endNodeField("arg", temp_arg);
            }
            Option<Type> temp_overloadingType = getOverloadingType();
            if (w.visitNodeField("overloadingType", temp_overloadingType)) {
                if (temp_overloadingType.isNone()) {
                    w.visitEmptyOption(temp_overloadingType);
                }
                else if (w.visitNonEmptyOption(temp_overloadingType)) {
                    Type elt_temp_overloadingType = temp_overloadingType.unwrap();
                    if (elt_temp_overloadingType == null) w.visitNull();
                    else {
                        elt_temp_overloadingType.walk(w);
                    }
                    w.endNonEmptyOption(temp_overloadingType);
                }
                w.endNodeField("overloadingType", temp_overloadingType);
            }
            Option<Type> temp_overloadingSchema = getOverloadingSchema();
            if (w.visitNodeField("overloadingSchema", temp_overloadingSchema)) {
                if (temp_overloadingSchema.isNone()) {
                    w.visitEmptyOption(temp_overloadingSchema);
                }
                else if (w.visitNonEmptyOption(temp_overloadingSchema)) {
                    Type elt_temp_overloadingSchema = temp_overloadingSchema.unwrap();
                    if (elt_temp_overloadingSchema == null) w.visitNull();
                    else {
                        elt_temp_overloadingSchema.walk(w);
                    }
                    w.endNonEmptyOption(temp_overloadingSchema);
                }
                w.endNodeField("overloadingSchema", temp_overloadingSchema);
            }
            w.endNode(this, "MethodInvocation", 7);
        }
    }

}
