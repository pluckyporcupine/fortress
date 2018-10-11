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
 * Class StaticArg, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class StaticArg extends AbstractNode {
    private final boolean _lifted;

    /**
     * Constructs a StaticArg.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public StaticArg(ASTNodeInfo in_info, boolean in_lifted) {
        super(in_info);
        _lifted = in_lifted;
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public StaticArg(ASTNodeInfo in_info) {
        this(in_info, false);
    }

    public boolean isLifted() { return _lifted; }

    public abstract <RetType> RetType accept(StaticArgVisitor<RetType> visitor);

    public abstract void accept(StaticArgVisitor_void visitor);

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected StaticArg() {
        _lifted = false;
    }

}
