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
 * Class TestDecl, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class TestDecl extends Decl {
    private final Id _name;
    private final List<GeneratorClause> _gens;
    private final Expr _expr;

    /**
     * Constructs a TestDecl.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TestDecl(ASTNodeInfo in_info, Id in_name, List<GeneratorClause> in_gens, Expr in_expr) {
        super(in_info);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the TestDecl constructor was null");
        }
        _name = in_name;
        if (in_gens == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'gens' to the TestDecl constructor was null");
        }
        _gens = in_gens;
        if (in_expr == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'expr' to the TestDecl constructor was null");
        }
        _expr = in_expr;
    }

    final public Id getName() { return _name; }
    final public List<GeneratorClause> getGens() { return _gens; }
    final public Expr getExpr() { return _expr; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTestDecl(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTestDecl(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTestDecl(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTestDecl(this);
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
            TestDecl casted = (TestDecl) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_name = getName();
            Id casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            List<GeneratorClause> temp_gens = getGens();
            List<GeneratorClause> casted_gens = casted.getGens();
            if (!(temp_gens == casted_gens || temp_gens.equals(casted_gens))) return false;
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
        Id temp_name = getName();
        code ^= temp_name.hashCode();
        List<GeneratorClause> temp_gens = getGens();
        code ^= temp_gens.hashCode();
        Expr temp_expr = getExpr();
        code ^= temp_expr.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TestDecl() {
        _name = null;
        _gens = null;
        _expr = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TestDecl(ASTNodeInfo info) {
        super(info);
        _name = null;
        _gens = null;
        _expr = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TestDecl", 4)) {
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
            List<GeneratorClause> temp_gens = getGens();
            if (w.visitNodeField("gens", temp_gens)) {
                if (w.visitIterated(temp_gens)) {
                    int i_temp_gens = 0;
                    for (GeneratorClause elt_temp_gens : temp_gens) {
                        if (w.visitIteratedElement(i_temp_gens, elt_temp_gens)) {
                            if (elt_temp_gens == null) w.visitNull();
                            else {
                                elt_temp_gens.walk(w);
                            }
                        }
                        i_temp_gens++;
                    }
                    w.endIterated(temp_gens, i_temp_gens);
                }
                w.endNodeField("gens", temp_gens);
            }
            Expr temp_expr = getExpr();
            if (w.visitNodeField("expr", temp_expr)) {
                temp_expr.walk(w);
                w.endNodeField("expr", temp_expr);
            }
            w.endNode(this, "TestDecl", 4);
        }
    }

}
