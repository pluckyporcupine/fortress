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
 * Class TypeAnnotatedExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class TypeAnnotatedExpr extends Expr {
    private final Expr _expr;
    private final Type _annType;

    /**
     * Constructs a TypeAnnotatedExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TypeAnnotatedExpr(ExprInfo in_info, Expr in_expr, Type in_annType) {
        super(in_info);
        if (in_expr == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'expr' to the TypeAnnotatedExpr constructor was null");
        }
        _expr = in_expr;
        if (in_annType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'annType' to the TypeAnnotatedExpr constructor was null");
        }
        _annType = in_annType;
    }

    public Expr getExpr() { return _expr; }
    public Type getAnnType() { return _annType; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TypeAnnotatedExpr() {
        _expr = null;
        _annType = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TypeAnnotatedExpr(ExprInfo info) {
        super(info);
        _expr = null;
        _annType = null;
    }

}
