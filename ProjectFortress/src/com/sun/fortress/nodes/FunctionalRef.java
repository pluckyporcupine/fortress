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
 * Class FunctionalRef, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class FunctionalRef extends Primary {
    private final List<StaticArg> _staticArgs;
    private final int _lexicalDepth;
    private final IdOrOp _originalName;
    private final List<IdOrOp> _names;
    private final List<Overloading> _interpOverloadings;
    private final List<Overloading> _newOverloadings;
    private final Option<Type> _overloadingType;
    private final Option<Type> _overloadingSchema;

    /**
     * Constructs a FunctionalRef.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public FunctionalRef(ExprInfo in_info, List<StaticArg> in_staticArgs, int in_lexicalDepth, IdOrOp in_originalName, List<IdOrOp> in_names, List<Overloading> in_interpOverloadings, List<Overloading> in_newOverloadings, Option<Type> in_overloadingType, Option<Type> in_overloadingSchema) {
        super(in_info);
        if (in_staticArgs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'staticArgs' to the FunctionalRef constructor was null");
        }
        _staticArgs = in_staticArgs;
        _lexicalDepth = in_lexicalDepth;
        if (in_originalName == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'originalName' to the FunctionalRef constructor was null");
        }
        _originalName = in_originalName;
        if (in_names == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'names' to the FunctionalRef constructor was null");
        }
        _names = in_names;
        if (in_interpOverloadings == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'interpOverloadings' to the FunctionalRef constructor was null");
        }
        _interpOverloadings = in_interpOverloadings;
        if (in_newOverloadings == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'newOverloadings' to the FunctionalRef constructor was null");
        }
        _newOverloadings = in_newOverloadings;
        if (in_overloadingType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'overloadingType' to the FunctionalRef constructor was null");
        }
        _overloadingType = in_overloadingType;
        if (in_overloadingSchema == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'overloadingSchema' to the FunctionalRef constructor was null");
        }
        _overloadingSchema = in_overloadingSchema;
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public FunctionalRef(ExprInfo in_info, List<StaticArg> in_staticArgs, int in_lexicalDepth, IdOrOp in_originalName, List<IdOrOp> in_names, List<Overloading> in_interpOverloadings, List<Overloading> in_newOverloadings, Option<Type> in_overloadingType) {
        this(in_info, in_staticArgs, in_lexicalDepth, in_originalName, in_names, in_interpOverloadings, in_newOverloadings, in_overloadingType, Option.<Type>none());
    }

    public List<StaticArg> getStaticArgs() { return _staticArgs; }
    public int getLexicalDepth() { return _lexicalDepth; }
    public IdOrOp getOriginalName() { return _originalName; }
    public List<IdOrOp> getNames() { return _names; }
    public List<Overloading> getInterpOverloadings() { return _interpOverloadings; }
    public List<Overloading> getNewOverloadings() { return _newOverloadings; }
    public Option<Type> getOverloadingType() { return _overloadingType; }
    public Option<Type> getOverloadingSchema() { return _overloadingSchema; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected FunctionalRef() {
        _staticArgs = null;
        _lexicalDepth = 0;
        _originalName = null;
        _names = null;
        _interpOverloadings = null;
        _newOverloadings = null;
        _overloadingType = null;
        _overloadingSchema = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected FunctionalRef(ExprInfo info) {
        super(info);
        _staticArgs = null;
        _lexicalDepth = 0;
        _originalName = null;
        _names = null;
        _interpOverloadings = null;
        _newOverloadings = null;
        _overloadingType = null;
        _overloadingSchema = null;
    }

}
