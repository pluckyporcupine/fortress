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
 * Class NonterminalDecl, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class NonterminalDecl extends GrammarMemberDecl {
    private final List<SyntaxDecl> _syntaxDecls;

    /**
     * Constructs a NonterminalDecl.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public NonterminalDecl(ASTNodeInfo in_info, Id in_name, List<SyntaxDecl> in_syntaxDecls) {
        super(in_info, in_name);
        if (in_syntaxDecls == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxDecls' to the NonterminalDecl constructor was null");
        }
        _syntaxDecls = in_syntaxDecls;
    }

    public List<SyntaxDecl> getSyntaxDecls() { return _syntaxDecls; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected NonterminalDecl() {
        _syntaxDecls = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected NonterminalDecl(ASTNodeInfo info) {
        super(info);
        _syntaxDecls = null;
    }

}
