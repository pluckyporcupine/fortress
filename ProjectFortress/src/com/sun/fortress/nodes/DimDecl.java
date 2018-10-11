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
 * Class DimDecl, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class DimDecl extends DimUnitDecl {
    private final Id _dimId;
    private final Option<Type> _derived;
    private final Option<Id> _defaultId;

    /**
     * Constructs a DimDecl.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public DimDecl(ASTNodeInfo in_info, Id in_dimId, Option<Type> in_derived, Option<Id> in_defaultId) {
        super(in_info);
        if (in_dimId == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'dimId' to the DimDecl constructor was null");
        }
        _dimId = in_dimId;
        if (in_derived == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'derived' to the DimDecl constructor was null");
        }
        _derived = in_derived;
        if (in_defaultId == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'defaultId' to the DimDecl constructor was null");
        }
        _defaultId = in_defaultId;
    }

    final public Id getDimId() { return _dimId; }
    final public Option<Type> getDerived() { return _derived; }
    final public Option<Id> getDefaultId() { return _defaultId; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forDimDecl(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forDimDecl(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forDimDecl(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forDimDecl(this);
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
            DimDecl casted = (DimDecl) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_dimId = getDimId();
            Id casted_dimId = casted.getDimId();
            if (!(temp_dimId == casted_dimId || temp_dimId.equals(casted_dimId))) return false;
            Option<Type> temp_derived = getDerived();
            Option<Type> casted_derived = casted.getDerived();
            if (!(temp_derived == casted_derived || temp_derived.equals(casted_derived))) return false;
            Option<Id> temp_defaultId = getDefaultId();
            Option<Id> casted_defaultId = casted.getDefaultId();
            if (!(temp_defaultId == casted_defaultId || temp_defaultId.equals(casted_defaultId))) return false;
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
        Id temp_dimId = getDimId();
        code ^= temp_dimId.hashCode();
        Option<Type> temp_derived = getDerived();
        code ^= temp_derived.hashCode();
        Option<Id> temp_defaultId = getDefaultId();
        code ^= temp_defaultId.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected DimDecl() {
        _dimId = null;
        _derived = null;
        _defaultId = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected DimDecl(ASTNodeInfo info) {
        super(info);
        _dimId = null;
        _derived = null;
        _defaultId = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "DimDecl", 4)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Id temp_dimId = getDimId();
            if (w.visitNodeField("dimId", temp_dimId)) {
                temp_dimId.walk(w);
                w.endNodeField("dimId", temp_dimId);
            }
            Option<Type> temp_derived = getDerived();
            if (w.visitNodeField("derived", temp_derived)) {
                if (temp_derived.isNone()) {
                    w.visitEmptyOption(temp_derived);
                }
                else if (w.visitNonEmptyOption(temp_derived)) {
                    Type elt_temp_derived = temp_derived.unwrap();
                    if (elt_temp_derived == null) w.visitNull();
                    else {
                        elt_temp_derived.walk(w);
                    }
                    w.endNonEmptyOption(temp_derived);
                }
                w.endNodeField("derived", temp_derived);
            }
            Option<Id> temp_defaultId = getDefaultId();
            if (w.visitNodeField("defaultId", temp_defaultId)) {
                if (temp_defaultId.isNone()) {
                    w.visitEmptyOption(temp_defaultId);
                }
                else if (w.visitNonEmptyOption(temp_defaultId)) {
                    Id elt_temp_defaultId = temp_defaultId.unwrap();
                    if (elt_temp_defaultId == null) w.visitNull();
                    else {
                        elt_temp_defaultId.walk(w);
                    }
                    w.endNonEmptyOption(temp_defaultId);
                }
                w.endNodeField("defaultId", temp_defaultId);
            }
            w.endNode(this, "DimDecl", 4);
        }
    }

}
