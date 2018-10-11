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
 * Class ArrayExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class ArrayExpr extends Primary {
    private final List<StaticArg> _staticArgs;

    /**
     * Constructs a ArrayExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ArrayExpr(ExprInfo in_info, List<StaticArg> in_staticArgs) {
        super(in_info);
        if (in_staticArgs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'staticArgs' to the ArrayExpr constructor was null");
        }
        _staticArgs = in_staticArgs;
    }

    public List<StaticArg> getStaticArgs() { return _staticArgs; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ArrayExpr() {
        _staticArgs = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ArrayExpr(ExprInfo info) {
        super(info);
        _staticArgs = null;
    }

}
