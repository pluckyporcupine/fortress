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
 * Class Op, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class Op extends IdOrOp {
    private final Fixity _fixity;
    private final boolean _enclosing;

    /**
     * Constructs a Op.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Op(ASTNodeInfo in_info, Option<APIName> in_apiName, String in_text, Fixity in_fixity, boolean in_enclosing) {
        super(in_info, in_apiName, in_text);
        if (in_fixity == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'fixity' to the Op constructor was null");
        }
        _fixity = in_fixity;
        _enclosing = in_enclosing;
    }

    public Fixity getFixity() { return _fixity; }
    public boolean isEnclosing() { return _enclosing; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Op() {
        _fixity = null;
        _enclosing = false;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Op(ASTNodeInfo info) {
        super(info);
        _fixity = null;
        _enclosing = false;
    }

}
