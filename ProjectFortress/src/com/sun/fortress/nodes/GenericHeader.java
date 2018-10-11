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
 * Class GenericHeader, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class GenericHeader extends DataNode {
    private final List<StaticParam> _staticParams;

    /**
     * Constructs a GenericHeader.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public GenericHeader(List<StaticParam> in_staticParams) {
        super();
        if (in_staticParams == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'staticParams' to the GenericHeader constructor was null");
        }
        _staticParams = in_staticParams;
    }

    public List<StaticParam> getStaticParams() { return _staticParams; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected GenericHeader() {
        _staticParams = null;
    }

}
