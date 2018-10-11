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
 * Class ObjectExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ObjectExpr extends AbstractObjectExpr {
    private final Option<SelfType> _selfType;

    /**
     * Constructs a ObjectExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ObjectExpr(ExprInfo in_info, TraitTypeHeader in_header, Option<SelfType> in_selfType) {
        super(in_info, in_header);
        if (in_selfType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'selfType' to the ObjectExpr constructor was null");
        }
        _selfType = in_selfType;
    }

    final public Option<SelfType> getSelfType() { return _selfType; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forObjectExpr(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forObjectExpr(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forObjectExpr(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forObjectExpr(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forObjectExpr(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forObjectExpr(this);
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
            ObjectExpr casted = (ObjectExpr) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            TraitTypeHeader temp_header = getHeader();
            TraitTypeHeader casted_header = casted.getHeader();
            if (!(temp_header == casted_header || temp_header.equals(casted_header))) return false;
            Option<SelfType> temp_selfType = getSelfType();
            Option<SelfType> casted_selfType = casted.getSelfType();
            if (!(temp_selfType == casted_selfType || temp_selfType.equals(casted_selfType))) return false;
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
        TraitTypeHeader temp_header = getHeader();
        code ^= temp_header.hashCode();
        Option<SelfType> temp_selfType = getSelfType();
        code ^= temp_selfType.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ObjectExpr() {
        _selfType = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ObjectExpr(ExprInfo info) {
        super(info);
        _selfType = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ObjectExpr", 3)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            TraitTypeHeader temp_header = getHeader();
            if (w.visitNodeField("header", temp_header)) {
                temp_header.walk(w);
                w.endNodeField("header", temp_header);
            }
            Option<SelfType> temp_selfType = getSelfType();
            if (w.visitNodeField("selfType", temp_selfType)) {
                if (temp_selfType.isNone()) {
                    w.visitEmptyOption(temp_selfType);
                }
                else if (w.visitNonEmptyOption(temp_selfType)) {
                    SelfType elt_temp_selfType = temp_selfType.unwrap();
                    if (elt_temp_selfType == null) w.visitNull();
                    else {
                        elt_temp_selfType.walk(w);
                    }
                    w.endNonEmptyOption(temp_selfType);
                }
                w.endNodeField("selfType", temp_selfType);
            }
            w.endNode(this, "ObjectExpr", 3);
        }
    }

}
