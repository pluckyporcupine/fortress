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
 * Class PropertyDecl, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class PropertyDecl extends Decl {
    private final Option<Id> _name;
    private final List<Param> _params;
    private final Expr _expr;

    /**
     * Constructs a PropertyDecl.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public PropertyDecl(ASTNodeInfo in_info, Option<Id> in_name, List<Param> in_params, Expr in_expr) {
        super(in_info);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the PropertyDecl constructor was null");
        }
        _name = in_name;
        if (in_params == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'params' to the PropertyDecl constructor was null");
        }
        _params = in_params;
        if (in_expr == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'expr' to the PropertyDecl constructor was null");
        }
        _expr = in_expr;
    }

    final public Option<Id> getName() { return _name; }
    final public List<Param> getParams() { return _params; }
    final public Expr getExpr() { return _expr; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forPropertyDecl(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forPropertyDecl(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forPropertyDecl(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forPropertyDecl(this);
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
            PropertyDecl casted = (PropertyDecl) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<Id> temp_name = getName();
            Option<Id> casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            List<Param> temp_params = getParams();
            List<Param> casted_params = casted.getParams();
            if (!(temp_params == casted_params || temp_params.equals(casted_params))) return false;
            Expr temp_expr = getExpr();
            Expr casted_expr = casted.getExpr();
            if (!(temp_expr == casted_expr || temp_expr.equals(casted_expr))) return false;
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
        Option<Id> temp_name = getName();
        code ^= temp_name.hashCode();
        List<Param> temp_params = getParams();
        code ^= temp_params.hashCode();
        Expr temp_expr = getExpr();
        code ^= temp_expr.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected PropertyDecl() {
        _name = null;
        _params = null;
        _expr = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected PropertyDecl(ASTNodeInfo info) {
        super(info);
        _name = null;
        _params = null;
        _expr = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "PropertyDecl", 4)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Option<Id> temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                if (temp_name.isNone()) {
                    w.visitEmptyOption(temp_name);
                }
                else if (w.visitNonEmptyOption(temp_name)) {
                    Id elt_temp_name = temp_name.unwrap();
                    if (elt_temp_name == null) w.visitNull();
                    else {
                        elt_temp_name.walk(w);
                    }
                    w.endNonEmptyOption(temp_name);
                }
                w.endNodeField("name", temp_name);
            }
            List<Param> temp_params = getParams();
            if (w.visitNodeField("params", temp_params)) {
                if (w.visitIterated(temp_params)) {
                    int i_temp_params = 0;
                    for (Param elt_temp_params : temp_params) {
                        if (w.visitIteratedElement(i_temp_params, elt_temp_params)) {
                            if (elt_temp_params == null) w.visitNull();
                            else {
                                elt_temp_params.walk(w);
                            }
                        }
                        i_temp_params++;
                    }
                    w.endIterated(temp_params, i_temp_params);
                }
                w.endNodeField("params", temp_params);
            }
            Expr temp_expr = getExpr();
            if (w.visitNodeField("expr", temp_expr)) {
                temp_expr.walk(w);
                w.endNodeField("expr", temp_expr);
            }
            w.endNode(this, "PropertyDecl", 4);
        }
    }

}
