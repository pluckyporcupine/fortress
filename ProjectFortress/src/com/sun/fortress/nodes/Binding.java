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
 * Class Binding, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class Binding extends AbstractNode implements Lhs {
    private final Id _name;
    private final Modifiers _mods;
    private final Option<TypeOrPattern> _idType;

    /**
     * Constructs a Binding.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Binding(ASTNodeInfo in_info, Id in_name, Modifiers in_mods, Option<TypeOrPattern> in_idType) {
        super(in_info);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the Binding constructor was null");
        }
        _name = in_name;
        if (in_mods == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'mods' to the Binding constructor was null");
        }
        _mods = in_mods;
        if (in_idType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'idType' to the Binding constructor was null");
        }
        _idType = in_idType;
    }

    public Id getName() { return _name; }
    public Modifiers getMods() { return _mods; }
    public Option<TypeOrPattern> getIdType() { return _idType; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Binding() {
        _name = null;
        _mods = null;
        _idType = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Binding(ASTNodeInfo info) {
        super(info);
        _name = null;
        _mods = null;
        _idType = null;
    }

}
