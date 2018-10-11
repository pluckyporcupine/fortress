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
 * Class IdOrOp, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class IdOrOp extends IdOrOpOrAnonymousName {
    private final String _text;

    /**
     * Constructs a IdOrOp.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public IdOrOp(ASTNodeInfo in_info, Option<APIName> in_apiName, String in_text) {
        super(in_info, in_apiName);
        if (in_text == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'text' to the IdOrOp constructor was null");
        }
        _text = in_text.intern();
    }

    public String getText() { return _text; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected IdOrOp() {
        _text = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected IdOrOp(ASTNodeInfo info) {
        super(info);
        _text = null;
    }

}
