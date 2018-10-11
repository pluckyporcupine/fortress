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
 * Class IfClause, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class IfClause extends AbstractNode {
    private final GeneratorClause _testClause;
    private final Block _body;

    /**
     * Constructs a IfClause.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public IfClause(ASTNodeInfo in_info, GeneratorClause in_testClause, Block in_body) {
        super(in_info);
        if (in_testClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'testClause' to the IfClause constructor was null");
        }
        _testClause = in_testClause;
        if (in_body == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'body' to the IfClause constructor was null");
        }
        _body = in_body;
    }

    final public GeneratorClause getTestClause() { return _testClause; }
    final public Block getBody() { return _body; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forIfClause(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forIfClause(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forIfClause(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forIfClause(this);
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
            IfClause casted = (IfClause) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            GeneratorClause temp_testClause = getTestClause();
            GeneratorClause casted_testClause = casted.getTestClause();
            if (!(temp_testClause == casted_testClause || temp_testClause.equals(casted_testClause))) return false;
            Block temp_body = getBody();
            Block casted_body = casted.getBody();
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
        ASTNodeInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        GeneratorClause temp_testClause = getTestClause();
        code ^= temp_testClause.hashCode();
        Block temp_body = getBody();
        code ^= temp_body.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected IfClause() {
        _testClause = null;
        _body = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected IfClause(ASTNodeInfo info) {
        super(info);
        _testClause = null;
        _body = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "IfClause", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            GeneratorClause temp_testClause = getTestClause();
            if (w.visitNodeField("testClause", temp_testClause)) {
                temp_testClause.walk(w);
                w.endNodeField("testClause", temp_testClause);
            }
            Block temp_body = getBody();
            if (w.visitNodeField("body", temp_body)) {
                temp_body.walk(w);
                w.endNodeField("body", temp_body);
            }
            w.endNode(this, "IfClause", 3);
        }
    }

}
