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
 * Class While, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class While extends Expr {
    private final GeneratorClause _testExpr;
    private final Do _body;

    /**
     * Constructs a While.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public While(ExprInfo in_info, GeneratorClause in_testExpr, Do in_body) {
        super(in_info);
        if (in_testExpr == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'testExpr' to the While constructor was null");
        }
        _testExpr = in_testExpr;
        if (in_body == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'body' to the While constructor was null");
        }
        _body = in_body;
    }

    final public GeneratorClause getTestExpr() { return _testExpr; }
    final public Do getBody() { return _body; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forWhile(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forWhile(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forWhile(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forWhile(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forWhile(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forWhile(this);
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
            While casted = (While) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            GeneratorClause temp_testExpr = getTestExpr();
            GeneratorClause casted_testExpr = casted.getTestExpr();
            if (!(temp_testExpr == casted_testExpr || temp_testExpr.equals(casted_testExpr))) return false;
            Do temp_body = getBody();
            Do casted_body = casted.getBody();
            if (!(temp_body == casted_body || temp_body.equals(casted_body))) return false;
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
        ExprInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        GeneratorClause temp_testExpr = getTestExpr();
        code ^= temp_testExpr.hashCode();
        Do temp_body = getBody();
        code ^= temp_body.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected While() {
        _testExpr = null;
        _body = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected While(ExprInfo info) {
        super(info);
        _testExpr = null;
        _body = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "While", 3)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            GeneratorClause temp_testExpr = getTestExpr();
            if (w.visitNodeField("testExpr", temp_testExpr)) {
                temp_testExpr.walk(w);
                w.endNodeField("testExpr", temp_testExpr);
            }
            Do temp_body = getBody();
            if (w.visitNodeField("body", temp_body)) {
                temp_body.walk(w);
                w.endNodeField("body", temp_body);
            }
            w.endNode(this, "While", 3);
        }
    }

}
