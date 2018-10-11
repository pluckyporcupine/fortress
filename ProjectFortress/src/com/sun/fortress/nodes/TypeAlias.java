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
 * Class TypeAlias, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class TypeAlias extends Decl {
    private final Id _name;
    private final List<StaticParam> _staticParams;
    private final Type _typeDef;

    /**
     * Constructs a TypeAlias.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TypeAlias(ASTNodeInfo in_info, Id in_name, List<StaticParam> in_staticParams, Type in_typeDef) {
        super(in_info);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the TypeAlias constructor was null");
        }
        _name = in_name;
        if (in_staticParams == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'staticParams' to the TypeAlias constructor was null");
        }
        _staticParams = in_staticParams;
        if (in_typeDef == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'typeDef' to the TypeAlias constructor was null");
        }
        _typeDef = in_typeDef;
    }

    final public Id getName() { return _name; }
    final public List<StaticParam> getStaticParams() { return _staticParams; }
    final public Type getTypeDef() { return _typeDef; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTypeAlias(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTypeAlias(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTypeAlias(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTypeAlias(this);
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
            TypeAlias casted = (TypeAlias) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_name = getName();
            Id casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            List<StaticParam> temp_staticParams = getStaticParams();
            List<StaticParam> casted_staticParams = casted.getStaticParams();
            if (!(temp_staticParams == casted_staticParams || temp_staticParams.equals(casted_staticParams))) return false;
            Type temp_typeDef = getTypeDef();
            Type casted_typeDef = casted.getTypeDef();
            if (!(temp_typeDef == casted_typeDef || temp_typeDef.equals(casted_typeDef))) return false;
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
        ASTNodeInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        Id temp_name = getName();
        code ^= temp_name.hashCode();
        List<StaticParam> temp_staticParams = getStaticParams();
        code ^= temp_staticParams.hashCode();
        Type temp_typeDef = getTypeDef();
        code ^= temp_typeDef.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TypeAlias() {
        _name = null;
        _staticParams = null;
        _typeDef = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TypeAlias(ASTNodeInfo info) {
        super(info);
        _name = null;
        _staticParams = null;
        _typeDef = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TypeAlias", 4)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Id temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            List<StaticParam> temp_staticParams = getStaticParams();
            if (w.visitNodeField("staticParams", temp_staticParams)) {
                if (w.visitIterated(temp_staticParams)) {
                    int i_temp_staticParams = 0;
                    for (StaticParam elt_temp_staticParams : temp_staticParams) {
                        if (w.visitIteratedElement(i_temp_staticParams, elt_temp_staticParams)) {
                            if (elt_temp_staticParams == null) w.visitNull();
                            else {
                                elt_temp_staticParams.walk(w);
                            }
                        }
                        i_temp_staticParams++;
                    }
                    w.endIterated(temp_staticParams, i_temp_staticParams);
                }
                w.endNodeField("staticParams", temp_staticParams);
            }
            Type temp_typeDef = getTypeDef();
            if (w.visitNodeField("typeDef", temp_typeDef)) {
                temp_typeDef.walk(w);
                w.endNodeField("typeDef", temp_typeDef);
            }
            w.endNode(this, "TypeAlias", 4);
        }
    }

}
