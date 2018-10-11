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
 * Class WhereTypeAlias, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class WhereTypeAlias extends WhereConstraint {
    private final TypeAlias _alias;

    /**
     * Constructs a WhereTypeAlias.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public WhereTypeAlias(ASTNodeInfo in_info, TypeAlias in_alias) {
        super(in_info);
        if (in_alias == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'alias' to the WhereTypeAlias constructor was null");
        }
        _alias = in_alias;
    }

    final public TypeAlias getAlias() { return _alias; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forWhereTypeAlias(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forWhereTypeAlias(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forWhereTypeAlias(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forWhereTypeAlias(this);
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
            WhereTypeAlias casted = (WhereTypeAlias) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            TypeAlias temp_alias = getAlias();
            TypeAlias casted_alias = casted.getAlias();
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
        TypeAlias temp_alias = getAlias();
        code ^= temp_alias.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected WhereTypeAlias() {
        _alias = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected WhereTypeAlias(ASTNodeInfo info) {
        super(info);
        _alias = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "WhereTypeAlias", 2)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            TypeAlias temp_alias = getAlias();
            if (w.visitNodeField("alias", temp_alias)) {
                temp_alias.walk(w);
                w.endNodeField("alias", temp_alias);
            }
            w.endNode(this, "WhereTypeAlias", 2);
        }
    }

}
