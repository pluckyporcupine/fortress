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
 * Class DeclHeader, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class DeclHeader extends GenericHeader {
    private final Modifiers _mods;
    private final IdOrOpOrAnonymousName _name;
    private final Option<WhereClause> _whereClause;
    private final Option<List<Type>> _throwsClause;
    private final Option<Contract> _contract;

    /**
     * Constructs a DeclHeader.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public DeclHeader(List<StaticParam> in_staticParams, Modifiers in_mods, IdOrOpOrAnonymousName in_name, Option<WhereClause> in_whereClause, Option<List<Type>> in_throwsClause, Option<Contract> in_contract) {
        super(in_staticParams);
        if (in_mods == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'mods' to the DeclHeader constructor was null");
        }
        _mods = in_mods;
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the DeclHeader constructor was null");
        }
        _name = in_name;
        if (in_whereClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'whereClause' to the DeclHeader constructor was null");
        }
        _whereClause = in_whereClause;
        if (in_throwsClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'throwsClause' to the DeclHeader constructor was null");
        }
        _throwsClause = in_throwsClause;
        if (in_contract == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'contract' to the DeclHeader constructor was null");
        }
        _contract = in_contract;
    }

    public Modifiers getMods() { return _mods; }
    public IdOrOpOrAnonymousName getName() { return _name; }
    public Option<WhereClause> getWhereClause() { return _whereClause; }
    public Option<List<Type>> getThrowsClause() { return _throwsClause; }
    public Option<Contract> getContract() { return _contract; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected DeclHeader() {
        _mods = null;
        _name = null;
        _whereClause = null;
        _throwsClause = null;
        _contract = null;
    }

}
