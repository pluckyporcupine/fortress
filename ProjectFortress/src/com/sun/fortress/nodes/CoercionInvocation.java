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
 * Class CoercionInvocation, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class CoercionInvocation extends Primary {
    private final Type _toType;
    private final Expr _arg;

    /**
     * Constructs a CoercionInvocation.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public CoercionInvocation(ExprInfo in_info, Type in_toType, Expr in_arg) {
        super(in_info);
        if (in_toType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'toType' to the CoercionInvocation constructor was null");
        }
        _toType = in_toType;
        if (in_arg == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'arg' to the CoercionInvocation constructor was null");
        }
        _arg = in_arg;
    }

    public Type getToType() { return _toType; }
    public Expr getArg() { return _arg; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected CoercionInvocation() {
        _toType = null;
        _arg = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected CoercionInvocation(ExprInfo info) {
        super(info);
        _toType = null;
        _arg = null;
    }

}
