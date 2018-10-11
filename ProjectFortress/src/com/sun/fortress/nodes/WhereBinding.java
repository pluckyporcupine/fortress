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
 * Class WhereBinding, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class WhereBinding extends AbstractNode {
    private final Id _name;
    private final List<BaseType> _supers;
    private final StaticParamKind _kind;

    /**
     * Constructs a WhereBinding.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public WhereBinding(ASTNodeInfo in_info, Id in_name, List<BaseType> in_supers, StaticParamKind in_kind) {
        super(in_info);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the WhereBinding constructor was null");
        }
        _name = in_name;
        if (in_supers == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'supers' to the WhereBinding constructor was null");
        }
        _supers = in_supers;
        if (in_kind == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'kind' to the WhereBinding constructor was null");
        }
        _kind = in_kind;
    }

    final public Id getName() { return _name; }
    final public List<BaseType> getSupers() { return _supers; }
    final public StaticParamKind getKind() { return _kind; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forWhereBinding(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forWhereBinding(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forWhereBinding(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forWhereBinding(this);
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
            WhereBinding casted = (WhereBinding) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_name = getName();
            Id casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            List<BaseType> temp_supers = getSupers();
            List<BaseType> casted_supers = casted.getSupers();
            if (!(temp_supers == casted_supers || temp_supers.equals(casted_supers))) return false;
            StaticParamKind temp_kind = getKind();
            StaticParamKind casted_kind = casted.getKind();
            if (!(temp_kind == casted_kind || temp_kind.equals(casted_kind))) return false;
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
        List<BaseType> temp_supers = getSupers();
        code ^= temp_supers.hashCode();
        StaticParamKind temp_kind = getKind();
        code ^= temp_kind.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected WhereBinding() {
        _name = null;
        _supers = null;
        _kind = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected WhereBinding(ASTNodeInfo info) {
        super(info);
        _name = null;
        _supers = null;
        _kind = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "WhereBinding", 4)) {
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
            List<BaseType> temp_supers = getSupers();
            if (w.visitNodeField("supers", temp_supers)) {
                if (w.visitIterated(temp_supers)) {
                    int i_temp_supers = 0;
                    for (BaseType elt_temp_supers : temp_supers) {
                        if (w.visitIteratedElement(i_temp_supers, elt_temp_supers)) {
                            if (elt_temp_supers == null) w.visitNull();
                            else {
                                elt_temp_supers.walk(w);
                            }
                        }
                        i_temp_supers++;
                    }
                    w.endIterated(temp_supers, i_temp_supers);
                }
                w.endNodeField("supers", temp_supers);
            }
            StaticParamKind temp_kind = getKind();
            if (w.visitNodeField("kind", temp_kind)) {
                temp_kind.walk(w);
                w.endNodeField("kind", temp_kind);
            }
            w.endNode(this, "WhereBinding", 4);
        }
    }

}
