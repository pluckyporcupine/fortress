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
 * Class GrammarMemberDecl, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class GrammarMemberDecl extends Decl {
    private final Id _name;

    /**
     * Constructs a GrammarMemberDecl.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public GrammarMemberDecl(ASTNodeInfo in_info, Id in_name) {
        super(in_info);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the GrammarMemberDecl constructor was null");
        }
        _name = in_name;
    }

    public Id getName() { return _name; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected GrammarMemberDecl() {
        _name = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected GrammarMemberDecl(ASTNodeInfo info) {
        super(info);
        _name = null;
    }

}
