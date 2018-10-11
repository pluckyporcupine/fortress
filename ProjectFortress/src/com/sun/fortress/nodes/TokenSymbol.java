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
 * Class TokenSymbol, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class TokenSymbol extends SyntaxSymbol {
    private final String _token;

    /**
     * Constructs a TokenSymbol.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TokenSymbol(ASTNodeInfo in_info, String in_token) {
        super(in_info);
        if (in_token == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'token' to the TokenSymbol constructor was null");
        }
        _token = in_token.intern();
    }

    final public String getToken() { return _token; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTokenSymbol(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTokenSymbol(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTokenSymbol(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTokenSymbol(this);
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
            TokenSymbol casted = (TokenSymbol) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            String temp_token = getToken();
            String casted_token = casted.getToken();
            if (!(temp_token == casted_token)) return false;
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
        String temp_token = getToken();
        code ^= temp_token.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TokenSymbol() {
        _token = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TokenSymbol(ASTNodeInfo info) {
        super(info);
        _token = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TokenSymbol", 2)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            String temp_token = getToken();
            if (w.visitNodeField("token", temp_token)) {
                w.visitString(temp_token);
                w.endNodeField("token", temp_token);
            }
            w.endNode(this, "TokenSymbol", 2);
        }
    }

}
