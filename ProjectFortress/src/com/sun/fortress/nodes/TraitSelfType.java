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
 * Class TraitSelfType, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class TraitSelfType extends SelfType {
    private final BaseType _named;
    private final List<NamedType> _comprised;

    /**
     * Constructs a TraitSelfType.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TraitSelfType(TypeInfo in_info, BaseType in_named, List<NamedType> in_comprised) {
        super(in_info);
        if (in_named == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'named' to the TraitSelfType constructor was null");
        }
        _named = in_named;
        if (in_comprised == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'comprised' to the TraitSelfType constructor was null");
        }
        _comprised = in_comprised;
    }

    final public BaseType getNamed() { return _named; }
    final public List<NamedType> getComprised() { return _comprised; }

    public <RetType> RetType accept(TypeVisitor<RetType> visitor) {
        return visitor.forTraitSelfType(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTraitSelfType(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTraitSelfType(this);
    }

    public void accept(TypeVisitor_void visitor) {
        visitor.forTraitSelfType(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTraitSelfType(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTraitSelfType(this);
    }

    /**
     * Implementation of equals that is based on the values of the fields of the
     * object. Thus, two objects created with identical parameters will be equal.
     */
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if ((obj.getClass() != this.getClass()) || (obj.hashCode() != this.hashCode())) {
            return false;
        }
        else {
            TraitSelfType casted = (TraitSelfType) obj;
            TypeInfo temp_info = getInfo();
            TypeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            BaseType temp_named = getNamed();
            BaseType casted_named = casted.getNamed();
            if (!(temp_named == casted_named || temp_named.equals(casted_named))) return false;
            List<NamedType> temp_comprised = getComprised();
            List<NamedType> casted_comprised = casted.getComprised();
            if (!(temp_comprised == casted_comprised || temp_comprised.equals(casted_comprised))) return false;
            return true;
        }
    }


    /**
     * Implementation of hashCode that is consistent with equals.  The value of
     * the hashCode is formed by XORing the hashcode of the class object with
     * the hashcodes of all the fields of the object.
     */
    public int generateHashCode() {
        int code = getClass().hashCode();
        TypeInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        BaseType temp_named = getNamed();
        code ^= temp_named.hashCode();
        List<NamedType> temp_comprised = getComprised();
        code ^= temp_comprised.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TraitSelfType() {
        _named = null;
        _comprised = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TraitSelfType(TypeInfo info) {
        super(info);
        _named = null;
        _comprised = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TraitSelfType", 3)) {
            TypeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            BaseType temp_named = getNamed();
            if (w.visitNodeField("named", temp_named)) {
                temp_named.walk(w);
                w.endNodeField("named", temp_named);
            }
            List<NamedType> temp_comprised = getComprised();
            if (w.visitNodeField("comprised", temp_comprised)) {
                if (w.visitIterated(temp_comprised)) {
                    int i_temp_comprised = 0;
                    for (NamedType elt_temp_comprised : temp_comprised) {
                        if (w.visitIteratedElement(i_temp_comprised, elt_temp_comprised)) {
                            if (elt_temp_comprised == null) w.visitNull();
                            else {
                                elt_temp_comprised.walk(w);
                            }
                        }
                        i_temp_comprised++;
                    }
                    w.endIterated(temp_comprised, i_temp_comprised);
                }
                w.endNodeField("comprised", temp_comprised);
            }
            w.endNode(this, "TraitSelfType", 3);
        }
    }

}
