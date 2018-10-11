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
 * Class TraitObjectDecl, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class TraitObjectDecl extends Decl implements Generic {
    private final TraitTypeHeader _header;
    private final Option<SelfType> _selfType;

    /**
     * Constructs a TraitObjectDecl.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TraitObjectDecl(ASTNodeInfo in_info, TraitTypeHeader in_header, Option<SelfType> in_selfType) {
        super(in_info);
        if (in_header == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'header' to the TraitObjectDecl constructor was null");
        }
        _header = in_header;
        if (in_selfType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'selfType' to the TraitObjectDecl constructor was null");
        }
        _selfType = in_selfType;
    }

    public TraitTypeHeader getHeader() { return _header; }
    public Option<SelfType> getSelfType() { return _selfType; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TraitObjectDecl() {
        _header = null;
        _selfType = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TraitObjectDecl(ASTNodeInfo info) {
        super(info);
        _header = null;
        _selfType = null;
    }

}
