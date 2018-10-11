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
 * Class _RewriteFnApp, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _RewriteFnApp extends Primary implements InAfterTypeChecking {
    private final Expr _function;
    private final Expr _argument;

    /**
     * Constructs a _RewriteFnApp.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _RewriteFnApp(ExprInfo in_info, Expr in_function, Expr in_argument) {
        super(in_info);
        if (in_function == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'function' to the _RewriteFnApp constructor was null");
        }
        _function = in_function;
        if (in_argument == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'argument' to the _RewriteFnApp constructor was null");
        }
        _argument = in_argument;
    }

    final public Expr getFunction() { return _function; }
    final public Expr getArgument() { return _argument; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.for_RewriteFnApp(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_RewriteFnApp(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_RewriteFnApp(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.for_RewriteFnApp(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_RewriteFnApp(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_RewriteFnApp(this);
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
            _RewriteFnApp casted = (_RewriteFnApp) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Expr temp_function = getFunction();
            Expr casted_function = casted.getFunction();
            if (!(temp_function == casted_function || temp_function.equals(casted_function))) return false;
            Expr temp_argument = getArgument();
            Expr casted_argument = casted.getArgument();
            if (!(temp_argument == casted_argument || temp_argument.equals(casted_argument))) return false;
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
        Expr temp_function = getFunction();
        code ^= temp_function.hashCode();
        Expr temp_argument = getArgument();
        code ^= temp_argument.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected _RewriteFnApp() {
        _function = null;
        _argument = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _RewriteFnApp(ExprInfo info) {
        super(info);
        _function = null;
        _argument = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_RewriteFnApp", 3)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Expr temp_function = getFunction();
            if (w.visitNodeField("function", temp_function)) {
                temp_function.walk(w);
                w.endNodeField("function", temp_function);
            }
            Expr temp_argument = getArgument();
            if (w.visitNodeField("argument", temp_argument)) {
                temp_argument.walk(w);
                w.endNodeField("argument", temp_argument);
            }
            w.endNode(this, "_RewriteFnApp", 3);
        }
    }

}
