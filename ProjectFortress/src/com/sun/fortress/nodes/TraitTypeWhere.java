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
 * Class TraitTypeWhere, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class TraitTypeWhere extends AbstractNode {
    private final BaseType _baseType;
    private final Option<WhereClause> _whereClause;

    /**
     * Constructs a TraitTypeWhere.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TraitTypeWhere(ASTNodeInfo in_info, BaseType in_baseType, Option<WhereClause> in_whereClause) {
        super(in_info);
        if (in_baseType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'baseType' to the TraitTypeWhere constructor was null");
        }
        _baseType = in_baseType;
        if (in_whereClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'whereClause' to the TraitTypeWhere constructor was null");
        }
        _whereClause = in_whereClause;
    }

    final public BaseType getBaseType() { return _baseType; }
    final public Option<WhereClause> getWhereClause() { return _whereClause; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTraitTypeWhere(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTraitTypeWhere(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTraitTypeWhere(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTraitTypeWhere(this);
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
            TraitTypeWhere casted = (TraitTypeWhere) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            BaseType temp_baseType = getBaseType();
            BaseType casted_baseType = casted.getBaseType();
            if (!(temp_baseType == casted_baseType || temp_baseType.equals(casted_baseType))) return false;
            Option<WhereClause> temp_whereClause = getWhereClause();
            Option<WhereClause> casted_whereClause = casted.getWhereClause();
            if (!(temp_whereClause == casted_whereClause || temp_whereClause.equals(casted_whereClause))) return false;
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
        BaseType temp_baseType = getBaseType();
        code ^= temp_baseType.hashCode();
        Option<WhereClause> temp_whereClause = getWhereClause();
        code ^= temp_whereClause.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TraitTypeWhere() {
        _baseType = null;
        _whereClause = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TraitTypeWhere(ASTNodeInfo info) {
        super(info);
        _baseType = null;
        _whereClause = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TraitTypeWhere", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            BaseType temp_baseType = getBaseType();
            if (w.visitNodeField("baseType", temp_baseType)) {
                temp_baseType.walk(w);
                w.endNodeField("baseType", temp_baseType);
            }
            Option<WhereClause> temp_whereClause = getWhereClause();
            if (w.visitNodeField("whereClause", temp_whereClause)) {
                if (temp_whereClause.isNone()) {
                    w.visitEmptyOption(temp_whereClause);
                }
                else if (w.visitNonEmptyOption(temp_whereClause)) {
                    WhereClause elt_temp_whereClause = temp_whereClause.unwrap();
                    if (elt_temp_whereClause == null) w.visitNull();
                    else {
                        elt_temp_whereClause.walk(w);
                    }
                    w.endNonEmptyOption(temp_whereClause);
                }
                w.endNodeField("whereClause", temp_whereClause);
            }
            w.endNode(this, "TraitTypeWhere", 3);
        }
    }

}
