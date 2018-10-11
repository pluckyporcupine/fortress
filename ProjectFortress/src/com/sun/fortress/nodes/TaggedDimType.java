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
 * Class TaggedDimType, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class TaggedDimType extends AbbreviatedType {
    private final DimExpr _dimExpr;
    private final Option<Expr> _unitExpr;

    /**
     * Constructs a TaggedDimType.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TaggedDimType(TypeInfo in_info, Type in_elemType, DimExpr in_dimExpr, Option<Expr> in_unitExpr) {
        super(in_info, in_elemType);
        if (in_dimExpr == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'dimExpr' to the TaggedDimType constructor was null");
        }
        _dimExpr = in_dimExpr;
        if (in_unitExpr == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'unitExpr' to the TaggedDimType constructor was null");
        }
        _unitExpr = in_unitExpr;
    }

    final public DimExpr getDimExpr() { return _dimExpr; }
    final public Option<Expr> getUnitExpr() { return _unitExpr; }

    public <RetType> RetType accept(TypeVisitor<RetType> visitor) {
        return visitor.forTaggedDimType(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTaggedDimType(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTaggedDimType(this);
    }

    public void accept(TypeVisitor_void visitor) {
        visitor.forTaggedDimType(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTaggedDimType(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTaggedDimType(this);
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
            TaggedDimType casted = (TaggedDimType) obj;
            TypeInfo temp_info = getInfo();
            TypeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Type temp_elemType = getElemType();
            Type casted_elemType = casted.getElemType();
            if (!(temp_elemType == casted_elemType || temp_elemType.equals(casted_elemType))) return false;
            DimExpr temp_dimExpr = getDimExpr();
            DimExpr casted_dimExpr = casted.getDimExpr();
            if (!(temp_dimExpr == casted_dimExpr || temp_dimExpr.equals(casted_dimExpr))) return false;
            Option<Expr> temp_unitExpr = getUnitExpr();
            Option<Expr> casted_unitExpr = casted.getUnitExpr();
            if (!(temp_unitExpr == casted_unitExpr || temp_unitExpr.equals(casted_unitExpr))) return false;
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
        TypeInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        Type temp_elemType = getElemType();
        code ^= temp_elemType.hashCode();
        DimExpr temp_dimExpr = getDimExpr();
        code ^= temp_dimExpr.hashCode();
        Option<Expr> temp_unitExpr = getUnitExpr();
        code ^= temp_unitExpr.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TaggedDimType() {
        _dimExpr = null;
        _unitExpr = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TaggedDimType(TypeInfo info) {
        super(info);
        _dimExpr = null;
        _unitExpr = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TaggedDimType", 4)) {
            TypeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Type temp_elemType = getElemType();
            if (w.visitNodeField("elemType", temp_elemType)) {
                temp_elemType.walk(w);
                w.endNodeField("elemType", temp_elemType);
            }
            DimExpr temp_dimExpr = getDimExpr();
            if (w.visitNodeField("dimExpr", temp_dimExpr)) {
                temp_dimExpr.walk(w);
                w.endNodeField("dimExpr", temp_dimExpr);
            }
            Option<Expr> temp_unitExpr = getUnitExpr();
            if (w.visitNodeField("unitExpr", temp_unitExpr)) {
                if (temp_unitExpr.isNone()) {
                    w.visitEmptyOption(temp_unitExpr);
                }
                else if (w.visitNonEmptyOption(temp_unitExpr)) {
                    Expr elt_temp_unitExpr = temp_unitExpr.unwrap();
                    if (elt_temp_unitExpr == null) w.visitNull();
                    else {
                        elt_temp_unitExpr.walk(w);
                    }
                    w.endNonEmptyOption(temp_unitExpr);
                }
                w.endNodeField("unitExpr", temp_unitExpr);
            }
            w.endNode(this, "TaggedDimType", 4);
        }
    }

}
