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
 * Class Effect, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class Effect extends AbstractNode {
    private final Option<List<Type>> _throwsClause;
    private final boolean _ioEffect;

    /**
     * Constructs a Effect.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Effect(ASTNodeInfo in_info, Option<List<Type>> in_throwsClause, boolean in_ioEffect) {
        super(in_info);
        if (in_throwsClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'throwsClause' to the Effect constructor was null");
        }
        _throwsClause = in_throwsClause;
        _ioEffect = in_ioEffect;
    }

    final public Option<List<Type>> getThrowsClause() { return _throwsClause; }
    final public boolean isIoEffect() { return _ioEffect; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forEffect(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forEffect(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forEffect(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forEffect(this);
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
            Effect casted = (Effect) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<List<Type>> temp_throwsClause = getThrowsClause();
            Option<List<Type>> casted_throwsClause = casted.getThrowsClause();
            if (!(temp_throwsClause == casted_throwsClause || temp_throwsClause.equals(casted_throwsClause))) return false;
            boolean temp_ioEffect = isIoEffect();
            boolean casted_ioEffect = casted.isIoEffect();
            if (!(temp_ioEffect == casted_ioEffect)) return false;
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
        Option<List<Type>> temp_throwsClause = getThrowsClause();
        code ^= temp_throwsClause.hashCode();
        boolean temp_ioEffect = isIoEffect();
        code ^= temp_ioEffect ? 1231 : 1237;
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Effect() {
        _throwsClause = null;
        _ioEffect = false;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Effect(ASTNodeInfo info) {
        super(info);
        _throwsClause = null;
        _ioEffect = false;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "Effect", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Option<List<Type>> temp_throwsClause = getThrowsClause();
            if (w.visitNodeField("throwsClause", temp_throwsClause)) {
                if (temp_throwsClause.isNone()) {
                    w.visitEmptyOption(temp_throwsClause);
                }
                else if (w.visitNonEmptyOption(temp_throwsClause)) {
                    List<Type> elt_temp_throwsClause = temp_throwsClause.unwrap();
                    if (elt_temp_throwsClause == null) w.visitNull();
                    else {
                        if (w.visitIterated(elt_temp_throwsClause)) {
                            int i_elt_temp_throwsClause = 0;
                            for (Type elt_elt_temp_throwsClause : elt_temp_throwsClause) {
                                if (w.visitIteratedElement(i_elt_temp_throwsClause, elt_elt_temp_throwsClause)) {
                                    if (elt_elt_temp_throwsClause == null) w.visitNull();
                                    else {
                                        elt_elt_temp_throwsClause.walk(w);
                                    }
                                }
                                i_elt_temp_throwsClause++;
                            }
                            w.endIterated(elt_temp_throwsClause, i_elt_temp_throwsClause);
                        }
                    }
                    w.endNonEmptyOption(temp_throwsClause);
                }
                w.endNodeField("throwsClause", temp_throwsClause);
            }
            boolean temp_ioEffect = isIoEffect();
            if (w.visitNodeField("ioEffect", temp_ioEffect)) {
                w.visitBoolean(temp_ioEffect);
                w.endNodeField("ioEffect", temp_ioEffect);
            }
            w.endNode(this, "Effect", 3);
        }
    }

}
