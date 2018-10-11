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
 * Class Import, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class Import extends AbstractNode {
    private final Option<String> _foreignLanguage;

    /**
     * Constructs a Import.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Import(ASTNodeInfo in_info, Option<String> in_foreignLanguage) {
        super(in_info);
        if (in_foreignLanguage == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'foreignLanguage' to the Import constructor was null");
        }
        _foreignLanguage = in_foreignLanguage;
    }

    public Option<String> getForeignLanguage() { return _foreignLanguage; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Import() {
        _foreignLanguage = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Import(ASTNodeInfo info) {
        super(info);
        _foreignLanguage = null;
    }

}
