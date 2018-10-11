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
 * Class AbstractObjectExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class AbstractObjectExpr extends Expr {
    private final TraitTypeHeader _header;

    /**
     * Constructs a AbstractObjectExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public AbstractObjectExpr(ExprInfo in_info, TraitTypeHeader in_header) {
        super(in_info);
        if (in_header == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'header' to the AbstractObjectExpr constructor was null");
        }
        _header = in_header;
    }

    public TraitTypeHeader getHeader() { return _header; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected AbstractObjectExpr() {
        _header = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected AbstractObjectExpr(ExprInfo info) {
        super(info);
        _header = null;
    }

}
