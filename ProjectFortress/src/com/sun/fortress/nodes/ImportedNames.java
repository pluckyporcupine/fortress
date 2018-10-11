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
 * Class ImportedNames, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class ImportedNames extends Import {
    private final APIName _apiName;

    /**
     * Constructs a ImportedNames.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ImportedNames(ASTNodeInfo in_info, Option<String> in_foreignLanguage, APIName in_apiName) {
        super(in_info, in_foreignLanguage);
        if (in_apiName == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'apiName' to the ImportedNames constructor was null");
        }
        _apiName = in_apiName;
    }

    public APIName getApiName() { return _apiName; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ImportedNames() {
        _apiName = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ImportedNames(ASTNodeInfo info) {
        super(info);
        _apiName = null;
    }

}
