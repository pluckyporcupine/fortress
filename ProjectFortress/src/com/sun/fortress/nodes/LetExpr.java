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
 * Class LetExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class LetExpr extends Expr {
    private final Block _body;

    /**
     * Constructs a LetExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public LetExpr(ExprInfo in_info, Block in_body) {
        super(in_info);
        if (in_body == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'body' to the LetExpr constructor was null");
        }
        _body = in_body;
    }

    public Block getBody() { return _body; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected LetExpr() {
        _body = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected LetExpr(ExprInfo info) {
        super(info);
        _body = null;
    }

}
