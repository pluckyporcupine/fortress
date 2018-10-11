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
 * Class ExprMI, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class ExprMI extends MathItem {
    private final Expr _expr;

    /**
     * Constructs a ExprMI.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ExprMI(ASTNodeInfo in_info, Expr in_expr) {
        super(in_info);
        if (in_expr == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'expr' to the ExprMI constructor was null");
        }
        _expr = in_expr;
    }

    public Expr getExpr() { return _expr; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ExprMI() {
        _expr = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ExprMI(ASTNodeInfo info) {
        super(info);
        _expr = null;
    }

}
