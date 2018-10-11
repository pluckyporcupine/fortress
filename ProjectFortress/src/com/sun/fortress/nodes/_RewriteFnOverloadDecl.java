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
 * Class _RewriteFnOverloadDecl, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _RewriteFnOverloadDecl extends Decl {
    private final IdOrOp _name;
    private final List<IdOrOp> _fns;
    private final Option<Type> _type;

    /**
     * Constructs a _RewriteFnOverloadDecl.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _RewriteFnOverloadDecl(ASTNodeInfo in_info, IdOrOp in_name, List<IdOrOp> in_fns, Option<Type> in_type) {
        super(in_info);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the _RewriteFnOverloadDecl constructor was null");
        }
        _name = in_name;
        if (in_fns == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'fns' to the _RewriteFnOverloadDecl constructor was null");
        }
        _fns = in_fns;
        if (in_type == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'type' to the _RewriteFnOverloadDecl constructor was null");
        }
        _type = in_type;
    }

    final public IdOrOp getName() { return _name; }
    final public List<IdOrOp> getFns() { return _fns; }
    final public Option<Type> getType() { return _type; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_RewriteFnOverloadDecl(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_RewriteFnOverloadDecl(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_RewriteFnOverloadDecl(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_RewriteFnOverloadDecl(this);
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
            _RewriteFnOverloadDecl casted = (_RewriteFnOverloadDecl) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            IdOrOp temp_name = getName();
            IdOrOp casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            List<IdOrOp> temp_fns = getFns();
            List<IdOrOp> casted_fns = casted.getFns();
            if (!(temp_fns == casted_fns || temp_fns.equals(casted_fns))) return false;
            Option<Type> temp_type = getType();
            Option<Type> casted_type = casted.getType();
            if (!(temp_type == casted_type || temp_type.equals(casted_type))) return false;
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
        IdOrOp temp_name = getName();
        code ^= temp_name.hashCode();
        List<IdOrOp> temp_fns = getFns();
        code ^= temp_fns.hashCode();
        Option<Type> temp_type = getType();
        code ^= temp_type.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected _RewriteFnOverloadDecl() {
        _name = null;
        _fns = null;
        _type = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _RewriteFnOverloadDecl(ASTNodeInfo info) {
        super(info);
        _name = null;
        _fns = null;
        _type = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_RewriteFnOverloadDecl", 4)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            IdOrOp temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            List<IdOrOp> temp_fns = getFns();
            if (w.visitNodeField("fns", temp_fns)) {
                if (w.visitIterated(temp_fns)) {
                    int i_temp_fns = 0;
                    for (IdOrOp elt_temp_fns : temp_fns) {
                        if (w.visitIteratedElement(i_temp_fns, elt_temp_fns)) {
                            if (elt_temp_fns == null) w.visitNull();
                            else {
                                elt_temp_fns.walk(w);
                            }
                        }
                        i_temp_fns++;
                    }
                    w.endIterated(temp_fns, i_temp_fns);
                }
                w.endNodeField("fns", temp_fns);
            }
            Option<Type> temp_type = getType();
            if (w.visitNodeField("type", temp_type)) {
                if (temp_type.isNone()) {
                    w.visitEmptyOption(temp_type);
                }
                else if (w.visitNonEmptyOption(temp_type)) {
                    Type elt_temp_type = temp_type.unwrap();
                    if (elt_temp_type == null) w.visitNull();
                    else {
                        elt_temp_type.walk(w);
                    }
                    w.endNonEmptyOption(temp_type);
                }
                w.endNodeField("type", temp_type);
            }
            w.endNode(this, "_RewriteFnOverloadDecl", 4);
        }
    }

}
