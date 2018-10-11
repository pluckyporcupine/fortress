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
 * Class CompoundAssignmentInfo, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class CompoundAssignmentInfo extends DataNode {
    private final FunctionalRef _opForLhs;
    private final Option<CoercionInvocation> _compoundCoercionOuter;
    private final Option<CoercionInvocation> _compoundCoercionInner;

    /**
     * Constructs a CompoundAssignmentInfo.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public CompoundAssignmentInfo(FunctionalRef in_opForLhs, Option<CoercionInvocation> in_compoundCoercionOuter, Option<CoercionInvocation> in_compoundCoercionInner) {
        super();
        if (in_opForLhs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'opForLhs' to the CompoundAssignmentInfo constructor was null");
        }
        _opForLhs = in_opForLhs;
        if (in_compoundCoercionOuter == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'compoundCoercionOuter' to the CompoundAssignmentInfo constructor was null");
        }
        _compoundCoercionOuter = in_compoundCoercionOuter;
        if (in_compoundCoercionInner == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'compoundCoercionInner' to the CompoundAssignmentInfo constructor was null");
        }
        _compoundCoercionInner = in_compoundCoercionInner;
    }

    final public FunctionalRef getOpForLhs() { return _opForLhs; }
    final public Option<CoercionInvocation> getCompoundCoercionOuter() { return _compoundCoercionOuter; }
    final public Option<CoercionInvocation> getCompoundCoercionInner() { return _compoundCoercionInner; }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forCompoundAssignmentInfo(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forCompoundAssignmentInfo(this);
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
            CompoundAssignmentInfo casted = (CompoundAssignmentInfo) obj;
            FunctionalRef temp_opForLhs = getOpForLhs();
            FunctionalRef casted_opForLhs = casted.getOpForLhs();
            if (!(temp_opForLhs == casted_opForLhs || temp_opForLhs.equals(casted_opForLhs))) return false;
            Option<CoercionInvocation> temp_compoundCoercionOuter = getCompoundCoercionOuter();
            Option<CoercionInvocation> casted_compoundCoercionOuter = casted.getCompoundCoercionOuter();
            if (!(temp_compoundCoercionOuter == casted_compoundCoercionOuter || temp_compoundCoercionOuter.equals(casted_compoundCoercionOuter))) return false;
            Option<CoercionInvocation> temp_compoundCoercionInner = getCompoundCoercionInner();
            Option<CoercionInvocation> casted_compoundCoercionInner = casted.getCompoundCoercionInner();
            if (!(temp_compoundCoercionInner == casted_compoundCoercionInner || temp_compoundCoercionInner.equals(casted_compoundCoercionInner))) return false;
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
        FunctionalRef temp_opForLhs = getOpForLhs();
        code ^= temp_opForLhs.hashCode();
        Option<CoercionInvocation> temp_compoundCoercionOuter = getCompoundCoercionOuter();
        code ^= temp_compoundCoercionOuter.hashCode();
        Option<CoercionInvocation> temp_compoundCoercionInner = getCompoundCoercionInner();
        code ^= temp_compoundCoercionInner.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected CompoundAssignmentInfo() {
        _opForLhs = null;
        _compoundCoercionOuter = null;
        _compoundCoercionInner = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "CompoundAssignmentInfo", 3)) {
            FunctionalRef temp_opForLhs = getOpForLhs();
            if (w.visitNodeField("opForLhs", temp_opForLhs)) {
                temp_opForLhs.walk(w);
                w.endNodeField("opForLhs", temp_opForLhs);
            }
            Option<CoercionInvocation> temp_compoundCoercionOuter = getCompoundCoercionOuter();
            if (w.visitNodeField("compoundCoercionOuter", temp_compoundCoercionOuter)) {
                if (temp_compoundCoercionOuter.isNone()) {
                    w.visitEmptyOption(temp_compoundCoercionOuter);
                }
                else if (w.visitNonEmptyOption(temp_compoundCoercionOuter)) {
                    CoercionInvocation elt_temp_compoundCoercionOuter = temp_compoundCoercionOuter.unwrap();
                    if (elt_temp_compoundCoercionOuter == null) w.visitNull();
                    else {
                        elt_temp_compoundCoercionOuter.walk(w);
                    }
                    w.endNonEmptyOption(temp_compoundCoercionOuter);
                }
                w.endNodeField("compoundCoercionOuter", temp_compoundCoercionOuter);
            }
            Option<CoercionInvocation> temp_compoundCoercionInner = getCompoundCoercionInner();
            if (w.visitNodeField("compoundCoercionInner", temp_compoundCoercionInner)) {
                if (temp_compoundCoercionInner.isNone()) {
                    w.visitEmptyOption(temp_compoundCoercionInner);
                }
                else if (w.visitNonEmptyOption(temp_compoundCoercionInner)) {
                    CoercionInvocation elt_temp_compoundCoercionInner = temp_compoundCoercionInner.unwrap();
                    if (elt_temp_compoundCoercionInner == null) w.visitNull();
                    else {
                        elt_temp_compoundCoercionInner.walk(w);
                    }
                    w.endNonEmptyOption(temp_compoundCoercionInner);
                }
                w.endNodeField("compoundCoercionInner", temp_compoundCoercionInner);
            }
            w.endNode(this, "CompoundAssignmentInfo", 3);
        }
    }

}
