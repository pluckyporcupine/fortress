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
 * Class ArrowType, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ArrowType extends Type {
    private final Type _domain;
    private final Type _range;
    private final Effect _effect;
    private final boolean _io;
    private final Option<MethodInfo> _methodInfo;

    /**
     * Constructs a ArrowType.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ArrowType(TypeInfo in_info, Type in_domain, Type in_range, Effect in_effect, boolean in_io, Option<MethodInfo> in_methodInfo) {
        super(in_info);
        if (in_domain == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'domain' to the ArrowType constructor was null");
        }
        _domain = in_domain;
        if (in_range == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'range' to the ArrowType constructor was null");
        }
        _range = in_range;
        if (in_effect == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'effect' to the ArrowType constructor was null");
        }
        _effect = in_effect;
        _io = in_io;
        if (in_methodInfo == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'methodInfo' to the ArrowType constructor was null");
        }
        _methodInfo = in_methodInfo;
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public ArrowType(TypeInfo in_info, Type in_domain, Type in_range, Effect in_effect, boolean in_io) {
        this(in_info, in_domain, in_range, in_effect, in_io, Option.<MethodInfo>none());
    }

    final public Type getDomain() { return _domain; }
    final public Type getRange() { return _range; }
    final public Effect getEffect() { return _effect; }
    final public boolean isIo() { return _io; }
    final public Option<MethodInfo> getMethodInfo() { return _methodInfo; }

    public <RetType> RetType accept(TypeVisitor<RetType> visitor) {
        return visitor.forArrowType(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forArrowType(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forArrowType(this);
    }

    public void accept(TypeVisitor_void visitor) {
        visitor.forArrowType(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forArrowType(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forArrowType(this);
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
            ArrowType casted = (ArrowType) obj;
            TypeInfo temp_info = getInfo();
            TypeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Type temp_domain = getDomain();
            Type casted_domain = casted.getDomain();
            if (!(temp_domain == casted_domain || temp_domain.equals(casted_domain))) return false;
            Type temp_range = getRange();
            Type casted_range = casted.getRange();
            if (!(temp_range == casted_range || temp_range.equals(casted_range))) return false;
            Effect temp_effect = getEffect();
            Effect casted_effect = casted.getEffect();
            if (!(temp_effect == casted_effect || temp_effect.equals(casted_effect))) return false;
            boolean temp_io = isIo();
            boolean casted_io = casted.isIo();
            if (!(temp_io == casted_io)) return false;
            Option<MethodInfo> temp_methodInfo = getMethodInfo();
            Option<MethodInfo> casted_methodInfo = casted.getMethodInfo();
            if (!(temp_methodInfo == casted_methodInfo || temp_methodInfo.equals(casted_methodInfo))) return false;
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
        Type temp_domain = getDomain();
        code ^= temp_domain.hashCode();
        Type temp_range = getRange();
        code ^= temp_range.hashCode();
        Effect temp_effect = getEffect();
        code ^= temp_effect.hashCode();
        boolean temp_io = isIo();
        code ^= temp_io ? 1231 : 1237;
        Option<MethodInfo> temp_methodInfo = getMethodInfo();
        code ^= temp_methodInfo.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ArrowType() {
        _domain = null;
        _range = null;
        _effect = null;
        _io = false;
        _methodInfo = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ArrowType(TypeInfo info) {
        super(info);
        _domain = null;
        _range = null;
        _effect = null;
        _io = false;
        _methodInfo = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ArrowType", 6)) {
            TypeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Type temp_domain = getDomain();
            if (w.visitNodeField("domain", temp_domain)) {
                temp_domain.walk(w);
                w.endNodeField("domain", temp_domain);
            }
            Type temp_range = getRange();
            if (w.visitNodeField("range", temp_range)) {
                temp_range.walk(w);
                w.endNodeField("range", temp_range);
            }
            Effect temp_effect = getEffect();
            if (w.visitNodeField("effect", temp_effect)) {
                temp_effect.walk(w);
                w.endNodeField("effect", temp_effect);
            }
            boolean temp_io = isIo();
            if (w.visitNodeField("io", temp_io)) {
                w.visitBoolean(temp_io);
                w.endNodeField("io", temp_io);
            }
            Option<MethodInfo> temp_methodInfo = getMethodInfo();
            if (w.visitNodeField("methodInfo", temp_methodInfo)) {
                if (temp_methodInfo.isNone()) {
                    w.visitEmptyOption(temp_methodInfo);
                }
                else if (w.visitNonEmptyOption(temp_methodInfo)) {
                    MethodInfo elt_temp_methodInfo = temp_methodInfo.unwrap();
                    if (elt_temp_methodInfo == null) w.visitNull();
                    else {
                        elt_temp_methodInfo.walk(w);
                    }
                    w.endNonEmptyOption(temp_methodInfo);
                }
                w.endNodeField("methodInfo", temp_methodInfo);
            }
            w.endNode(this, "ArrowType", 6);
        }
    }

}
