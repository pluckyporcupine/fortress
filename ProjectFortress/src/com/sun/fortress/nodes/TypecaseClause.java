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
 * Class TypecaseClause, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class TypecaseClause extends AbstractNode {
    private final Option<Id> _name;
    private final TypeOrPattern _matchType;
    private final Block _body;

    /**
     * Constructs a TypecaseClause.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TypecaseClause(ASTNodeInfo in_info, Option<Id> in_name, TypeOrPattern in_matchType, Block in_body) {
        super(in_info);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the TypecaseClause constructor was null");
        }
        _name = in_name;
        if (in_matchType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'matchType' to the TypecaseClause constructor was null");
        }
        _matchType = in_matchType;
        if (in_body == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'body' to the TypecaseClause constructor was null");
        }
        _body = in_body;
    }

    final public Option<Id> getName() { return _name; }
    final public TypeOrPattern getMatchType() { return _matchType; }
    final public Block getBody() { return _body; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTypecaseClause(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTypecaseClause(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTypecaseClause(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTypecaseClause(this);
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
            TypecaseClause casted = (TypecaseClause) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<Id> temp_name = getName();
            Option<Id> casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            TypeOrPattern temp_matchType = getMatchType();
            TypeOrPattern casted_matchType = casted.getMatchType();
            if (!(temp_matchType == casted_matchType || temp_matchType.equals(casted_matchType))) return false;
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
        Option<Id> temp_name = getName();
        code ^= temp_name.hashCode();
        TypeOrPattern temp_matchType = getMatchType();
        code ^= temp_matchType.hashCode();
        Block temp_body = getBody();
        code ^= temp_body.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TypecaseClause() {
        _name = null;
        _matchType = null;
        _body = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TypecaseClause(ASTNodeInfo info) {
        super(info);
        _name = null;
        _matchType = null;
        _body = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TypecaseClause", 4)) {
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
            TypeOrPattern temp_matchType = getMatchType();
            if (w.visitNodeField("matchType", temp_matchType)) {
                temp_matchType.walk(w);
                w.endNodeField("matchType", temp_matchType);
            }
            Block temp_body = getBody();
            if (w.visitNodeField("body", temp_body)) {
                temp_body.walk(w);
                w.endNodeField("body", temp_body);
            }
            w.endNode(this, "TypecaseClause", 4);
        }
    }

}
