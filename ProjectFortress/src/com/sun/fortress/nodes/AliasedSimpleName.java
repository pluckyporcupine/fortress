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
 * Class AliasedSimpleName, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class AliasedSimpleName extends AbstractNode {
    private final IdOrOpOrAnonymousName _name;
    private final Option<IdOrOpOrAnonymousName> _alias;

    /**
     * Constructs a AliasedSimpleName.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public AliasedSimpleName(ASTNodeInfo in_info, IdOrOpOrAnonymousName in_name, Option<IdOrOpOrAnonymousName> in_alias) {
        super(in_info);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the AliasedSimpleName constructor was null");
        }
        _name = in_name;
        if (in_alias == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'alias' to the AliasedSimpleName constructor was null");
        }
        _alias = in_alias;
    }

    final public IdOrOpOrAnonymousName getName() { return _name; }
    final public Option<IdOrOpOrAnonymousName> getAlias() { return _alias; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forAliasedSimpleName(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forAliasedSimpleName(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forAliasedSimpleName(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forAliasedSimpleName(this);
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
            AliasedSimpleName casted = (AliasedSimpleName) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            IdOrOpOrAnonymousName temp_name = getName();
            IdOrOpOrAnonymousName casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            Option<IdOrOpOrAnonymousName> temp_alias = getAlias();
            Option<IdOrOpOrAnonymousName> casted_alias = casted.getAlias();
            if (!(temp_alias == casted_alias || temp_alias.equals(casted_alias))) return false;
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
        IdOrOpOrAnonymousName temp_name = getName();
        code ^= temp_name.hashCode();
        Option<IdOrOpOrAnonymousName> temp_alias = getAlias();
        code ^= temp_alias.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected AliasedSimpleName() {
        _name = null;
        _alias = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected AliasedSimpleName(ASTNodeInfo info) {
        super(info);
        _name = null;
        _alias = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "AliasedSimpleName", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            IdOrOpOrAnonymousName temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            Option<IdOrOpOrAnonymousName> temp_alias = getAlias();
            if (w.visitNodeField("alias", temp_alias)) {
                if (temp_alias.isNone()) {
                    w.visitEmptyOption(temp_alias);
                }
                else if (w.visitNonEmptyOption(temp_alias)) {
                    IdOrOpOrAnonymousName elt_temp_alias = temp_alias.unwrap();
                    if (elt_temp_alias == null) w.visitNull();
                    else {
                        elt_temp_alias.walk(w);
                    }
                    w.endNonEmptyOption(temp_alias);
                }
                w.endNodeField("alias", temp_alias);
            }
            w.endNode(this, "AliasedSimpleName", 3);
        }
    }

}
