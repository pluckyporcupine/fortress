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
 * Class BoundType, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class BoundType extends Type {
    private final List<Type> _elements;

    /**
     * Constructs a BoundType.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public BoundType(TypeInfo in_info, List<Type> in_elements) {
        super(in_info);
        if (in_elements == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'elements' to the BoundType constructor was null");
        }
        _elements = in_elements;
    }

    public List<Type> getElements() { return _elements; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected BoundType() {
        _elements = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected BoundType(TypeInfo info) {
        super(info);
        _elements = null;
    }

}
