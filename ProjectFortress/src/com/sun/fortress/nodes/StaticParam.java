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
 * Class StaticParam, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class StaticParam extends AbstractNode {
    private final int _variance;
    private final IdOrOp _name;
    private final List<BaseType> _extendsClause;
    private final List<BaseType> _dominatesClause;
    private final Option<Type> _dimParam;
    private final boolean _absorbsParam;
    private final StaticParamKind _kind;
    private final boolean _lifted;

    /**
     * Constructs a StaticParam.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public StaticParam(ASTNodeInfo in_info, int in_variance, IdOrOp in_name, List<BaseType> in_extendsClause, List<BaseType> in_dominatesClause, Option<Type> in_dimParam, boolean in_absorbsParam, StaticParamKind in_kind, boolean in_lifted) {
        super(in_info);
        _variance = in_variance;
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the StaticParam constructor was null");
        }
        _name = in_name;
        if (in_extendsClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'extendsClause' to the StaticParam constructor was null");
        }
        _extendsClause = in_extendsClause;
        if (in_dominatesClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'dominatesClause' to the StaticParam constructor was null");
        }
        _dominatesClause = in_dominatesClause;
        if (in_dimParam == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'dimParam' to the StaticParam constructor was null");
        }
        _dimParam = in_dimParam;
        _absorbsParam = in_absorbsParam;
        if (in_kind == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'kind' to the StaticParam constructor was null");
        }
        _kind = in_kind;
        _lifted = in_lifted;
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public StaticParam(ASTNodeInfo in_info, int in_variance, IdOrOp in_name, List<BaseType> in_extendsClause, List<BaseType> in_dominatesClause, Option<Type> in_dimParam, boolean in_absorbsParam, StaticParamKind in_kind) {
        this(in_info, in_variance, in_name, in_extendsClause, in_dominatesClause, in_dimParam, in_absorbsParam, in_kind, false);
    }

    final public int getVariance() { return _variance; }
    final public IdOrOp getName() { return _name; }
    final public List<BaseType> getExtendsClause() { return _extendsClause; }
    final public List<BaseType> getDominatesClause() { return _dominatesClause; }
    final public Option<Type> getDimParam() { return _dimParam; }
    final public boolean isAbsorbsParam() { return _absorbsParam; }
    final public StaticParamKind getKind() { return _kind; }
    final public boolean isLifted() { return _lifted; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forStaticParam(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forStaticParam(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forStaticParam(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forStaticParam(this);
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
            StaticParam casted = (StaticParam) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            int temp_variance = getVariance();
            int casted_variance = casted.getVariance();
            if (!(temp_variance == casted_variance)) return false;
            IdOrOp temp_name = getName();
            IdOrOp casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            List<BaseType> temp_extendsClause = getExtendsClause();
            List<BaseType> casted_extendsClause = casted.getExtendsClause();
            if (!(temp_extendsClause == casted_extendsClause || temp_extendsClause.equals(casted_extendsClause))) return false;
            List<BaseType> temp_dominatesClause = getDominatesClause();
            List<BaseType> casted_dominatesClause = casted.getDominatesClause();
            if (!(temp_dominatesClause == casted_dominatesClause || temp_dominatesClause.equals(casted_dominatesClause))) return false;
            Option<Type> temp_dimParam = getDimParam();
            Option<Type> casted_dimParam = casted.getDimParam();
            if (!(temp_dimParam == casted_dimParam || temp_dimParam.equals(casted_dimParam))) return false;
            boolean temp_absorbsParam = isAbsorbsParam();
            boolean casted_absorbsParam = casted.isAbsorbsParam();
            if (!(temp_absorbsParam == casted_absorbsParam)) return false;
            StaticParamKind temp_kind = getKind();
            StaticParamKind casted_kind = casted.getKind();
            if (!(temp_kind == casted_kind || temp_kind.equals(casted_kind))) return false;
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
        int temp_variance = getVariance();
        code ^= temp_variance;
        IdOrOp temp_name = getName();
        code ^= temp_name.hashCode();
        List<BaseType> temp_extendsClause = getExtendsClause();
        code ^= temp_extendsClause.hashCode();
        List<BaseType> temp_dominatesClause = getDominatesClause();
        code ^= temp_dominatesClause.hashCode();
        Option<Type> temp_dimParam = getDimParam();
        code ^= temp_dimParam.hashCode();
        boolean temp_absorbsParam = isAbsorbsParam();
        code ^= temp_absorbsParam ? 1231 : 1237;
        StaticParamKind temp_kind = getKind();
        code ^= temp_kind.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected StaticParam() {
        _variance = 0;
        _name = null;
        _extendsClause = null;
        _dominatesClause = null;
        _dimParam = null;
        _absorbsParam = false;
        _kind = null;
        _lifted = false;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected StaticParam(ASTNodeInfo info) {
        super(info);
        _variance = 0;
        _name = null;
        _extendsClause = null;
        _dominatesClause = null;
        _dimParam = null;
        _absorbsParam = false;
        _kind = null;
        _lifted = false;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "StaticParam", 9)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            int temp_variance = getVariance();
            if (w.visitNodeField("variance", temp_variance)) {
                w.visitInt(temp_variance);
                w.endNodeField("variance", temp_variance);
            }
            IdOrOp temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            List<BaseType> temp_extendsClause = getExtendsClause();
            if (w.visitNodeField("extendsClause", temp_extendsClause)) {
                if (w.visitIterated(temp_extendsClause)) {
                    int i_temp_extendsClause = 0;
                    for (BaseType elt_temp_extendsClause : temp_extendsClause) {
                        if (w.visitIteratedElement(i_temp_extendsClause, elt_temp_extendsClause)) {
                            if (elt_temp_extendsClause == null) w.visitNull();
                            else {
                                elt_temp_extendsClause.walk(w);
                            }
                        }
                        i_temp_extendsClause++;
                    }
                    w.endIterated(temp_extendsClause, i_temp_extendsClause);
                }
                w.endNodeField("extendsClause", temp_extendsClause);
            }
            List<BaseType> temp_dominatesClause = getDominatesClause();
            if (w.visitNodeField("dominatesClause", temp_dominatesClause)) {
                if (w.visitIterated(temp_dominatesClause)) {
                    int i_temp_dominatesClause = 0;
                    for (BaseType elt_temp_dominatesClause : temp_dominatesClause) {
                        if (w.visitIteratedElement(i_temp_dominatesClause, elt_temp_dominatesClause)) {
                            if (elt_temp_dominatesClause == null) w.visitNull();
                            else {
                                elt_temp_dominatesClause.walk(w);
                            }
                        }
                        i_temp_dominatesClause++;
                    }
                    w.endIterated(temp_dominatesClause, i_temp_dominatesClause);
                }
                w.endNodeField("dominatesClause", temp_dominatesClause);
            }
            Option<Type> temp_dimParam = getDimParam();
            if (w.visitNodeField("dimParam", temp_dimParam)) {
                if (temp_dimParam.isNone()) {
                    w.visitEmptyOption(temp_dimParam);
                }
                else if (w.visitNonEmptyOption(temp_dimParam)) {
                    Type elt_temp_dimParam = temp_dimParam.unwrap();
                    if (elt_temp_dimParam == null) w.visitNull();
                    else {
                        elt_temp_dimParam.walk(w);
                    }
                    w.endNonEmptyOption(temp_dimParam);
                }
                w.endNodeField("dimParam", temp_dimParam);
            }
            boolean temp_absorbsParam = isAbsorbsParam();
            if (w.visitNodeField("absorbsParam", temp_absorbsParam)) {
                w.visitBoolean(temp_absorbsParam);
                w.endNodeField("absorbsParam", temp_absorbsParam);
            }
            StaticParamKind temp_kind = getKind();
            if (w.visitNodeField("kind", temp_kind)) {
                temp_kind.walk(w);
                w.endNodeField("kind", temp_kind);
            }
            boolean temp_lifted = isLifted();
            if (w.visitNodeField("lifted", temp_lifted)) {
                w.visitBoolean(temp_lifted);
                w.endNodeField("lifted", temp_lifted);
            }
            w.endNode(this, "StaticParam", 9);
        }
    }

}
