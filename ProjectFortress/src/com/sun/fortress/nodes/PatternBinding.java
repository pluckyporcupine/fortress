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
 * Class PatternBinding, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class PatternBinding extends AbstractNode {
    private final Option<Id> _field;

    /**
     * Constructs a PatternBinding.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public PatternBinding(ASTNodeInfo in_info, Option<Id> in_field) {
        super(in_info);
        if (in_field == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'field' to the PatternBinding constructor was null");
        }
        _field = in_field;
    }

    public Option<Id> getField() { return _field; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected PatternBinding() {
        _field = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected PatternBinding(ASTNodeInfo info) {
        super(info);
        _field = null;
    }

}
