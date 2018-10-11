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
 * Class ASTNodeInfo, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class ASTNodeInfo extends DataNode {
    private final Span _span;

    /**
     * Constructs a ASTNodeInfo.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ASTNodeInfo(Span in_span) {
        super();
        if (in_span == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'span' to the ASTNodeInfo constructor was null");
        }
        _span = in_span;
    }

    public Span getSpan() { return _span; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ASTNodeInfo() {
        _span = null;
    }

}
