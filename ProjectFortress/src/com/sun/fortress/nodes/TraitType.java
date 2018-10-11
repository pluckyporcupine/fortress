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
 * Class TraitType, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class TraitType extends NamedType {
    private final List<StaticArg> _args;
    private final List<StaticParam> _traitStaticParams;

    /**
     * Constructs a TraitType.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TraitType(TypeInfo in_info, Id in_name, List<StaticArg> in_args, List<StaticParam> in_traitStaticParams) {
        super(in_info, in_name);
        if (in_args == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'args' to the TraitType constructor was null");
        }
        _args = in_args;
        if (in_traitStaticParams == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'traitStaticParams' to the TraitType constructor was null");
        }
        _traitStaticParams = in_traitStaticParams;
    }

    final public List<StaticArg> getArgs() { return _args; }
    final public List<StaticParam> getTraitStaticParams() { return _traitStaticParams; }

    public <RetType> RetType accept(TypeVisitor<RetType> visitor) {
        return visitor.forTraitType(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTraitType(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTraitType(this);
    }

    public void accept(TypeVisitor_void visitor) {
        visitor.forTraitType(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTraitType(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTraitType(this);
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
            TraitType casted = (TraitType) obj;
            TypeInfo temp_info = getInfo();
            TypeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_name = getName();
            Id casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            List<StaticArg> temp_args = getArgs();
            List<StaticArg> casted_args = casted.getArgs();
            if (!(temp_args == casted_args || temp_args.equals(casted_args))) return false;
            List<StaticParam> temp_traitStaticParams = getTraitStaticParams();
            List<StaticParam> casted_traitStaticParams = casted.getTraitStaticParams();
            if (!(temp_traitStaticParams == casted_traitStaticParams || temp_traitStaticParams.equals(casted_traitStaticParams))) return false;
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
        Id temp_name = getName();
        code ^= temp_name.hashCode();
        List<StaticArg> temp_args = getArgs();
        code ^= temp_args.hashCode();
        List<StaticParam> temp_traitStaticParams = getTraitStaticParams();
        code ^= temp_traitStaticParams.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TraitType() {
        _args = null;
        _traitStaticParams = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TraitType(TypeInfo info) {
        super(info);
        _args = null;
        _traitStaticParams = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TraitType", 4)) {
            TypeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Id temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            List<StaticArg> temp_args = getArgs();
            if (w.visitNodeField("args", temp_args)) {
                if (w.visitIterated(temp_args)) {
                    int i_temp_args = 0;
                    for (StaticArg elt_temp_args : temp_args) {
                        if (w.visitIteratedElement(i_temp_args, elt_temp_args)) {
                            if (elt_temp_args == null) w.visitNull();
                            else {
                                elt_temp_args.walk(w);
                            }
                        }
                        i_temp_args++;
                    }
                    w.endIterated(temp_args, i_temp_args);
                }
                w.endNodeField("args", temp_args);
            }
            List<StaticParam> temp_traitStaticParams = getTraitStaticParams();
            if (w.visitNodeField("traitStaticParams", temp_traitStaticParams)) {
                if (w.visitIterated(temp_traitStaticParams)) {
                    int i_temp_traitStaticParams = 0;
                    for (StaticParam elt_temp_traitStaticParams : temp_traitStaticParams) {
                        if (w.visitIteratedElement(i_temp_traitStaticParams, elt_temp_traitStaticParams)) {
                            if (elt_temp_traitStaticParams == null) w.visitNull();
                            else {
                                elt_temp_traitStaticParams.walk(w);
                            }
                        }
                        i_temp_traitStaticParams++;
                    }
                    w.endIterated(temp_traitStaticParams, i_temp_traitStaticParams);
                }
                w.endNodeField("traitStaticParams", temp_traitStaticParams);
            }
            w.endNode(this, "TraitType", 4);
        }
    }

}
