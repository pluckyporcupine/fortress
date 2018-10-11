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
 * Class Type, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class Type extends AbstractNode implements TypeOrPattern {

    /**
     * Constructs a Type.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Type(TypeInfo in_info) {
        super(in_info);
    }

    public TypeInfo getInfo() { return (TypeInfo) super.getInfo(); }

    public abstract <RetType> RetType accept(TypeVisitor<RetType> visitor);

    public abstract void accept(TypeVisitor_void visitor);

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Type() {
    }

}
