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
 * Class TraitDecl, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class TraitDecl extends TraitObjectDecl {
    private final List<BaseType> _excludesClause;
    private final Option<List<NamedType>> _comprisesClause;
    private final boolean _comprisesEllipses;

    /**
     * Constructs a TraitDecl.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TraitDecl(ASTNodeInfo in_info, TraitTypeHeader in_header, Option<SelfType> in_selfType, List<BaseType> in_excludesClause, Option<List<NamedType>> in_comprisesClause, boolean in_comprisesEllipses) {
        super(in_info, in_header, in_selfType);
        if (in_excludesClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'excludesClause' to the TraitDecl constructor was null");
        }
        _excludesClause = in_excludesClause;
        if (in_comprisesClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'comprisesClause' to the TraitDecl constructor was null");
        }
        _comprisesClause = in_comprisesClause;
        _comprisesEllipses = in_comprisesEllipses;
    }

    final public List<BaseType> getExcludesClause() { return _excludesClause; }
    final public Option<List<NamedType>> getComprisesClause() { return _comprisesClause; }
    final public boolean isComprisesEllipses() { return _comprisesEllipses; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTraitDecl(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTraitDecl(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTraitDecl(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTraitDecl(this);
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
            TraitDecl casted = (TraitDecl) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            TraitTypeHeader temp_header = getHeader();
            TraitTypeHeader casted_header = casted.getHeader();
            if (!(temp_header == casted_header || temp_header.equals(casted_header))) return false;
            Option<SelfType> temp_selfType = getSelfType();
            Option<SelfType> casted_selfType = casted.getSelfType();
            if (!(temp_selfType == casted_selfType || temp_selfType.equals(casted_selfType))) return false;
            List<BaseType> temp_excludesClause = getExcludesClause();
            List<BaseType> casted_excludesClause = casted.getExcludesClause();
            if (!(temp_excludesClause == casted_excludesClause || temp_excludesClause.equals(casted_excludesClause))) return false;
            Option<List<NamedType>> temp_comprisesClause = getComprisesClause();
            Option<List<NamedType>> casted_comprisesClause = casted.getComprisesClause();
            if (!(temp_comprisesClause == casted_comprisesClause || temp_comprisesClause.equals(casted_comprisesClause))) return false;
            boolean temp_comprisesEllipses = isComprisesEllipses();
            boolean casted_comprisesEllipses = casted.isComprisesEllipses();
            if (!(temp_comprisesEllipses == casted_comprisesEllipses)) return false;
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
        TraitTypeHeader temp_header = getHeader();
        code ^= temp_header.hashCode();
        Option<SelfType> temp_selfType = getSelfType();
        code ^= temp_selfType.hashCode();
        List<BaseType> temp_excludesClause = getExcludesClause();
        code ^= temp_excludesClause.hashCode();
        Option<List<NamedType>> temp_comprisesClause = getComprisesClause();
        code ^= temp_comprisesClause.hashCode();
        boolean temp_comprisesEllipses = isComprisesEllipses();
        code ^= temp_comprisesEllipses ? 1231 : 1237;
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TraitDecl() {
        _excludesClause = null;
        _comprisesClause = null;
        _comprisesEllipses = false;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TraitDecl(ASTNodeInfo info) {
        super(info);
        _excludesClause = null;
        _comprisesClause = null;
        _comprisesEllipses = false;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TraitDecl", 6)) {
            ASTNodeInfo temp_info = getInfo();
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
            List<BaseType> temp_excludesClause = getExcludesClause();
            if (w.visitNodeField("excludesClause", temp_excludesClause)) {
                if (w.visitIterated(temp_excludesClause)) {
                    int i_temp_excludesClause = 0;
                    for (BaseType elt_temp_excludesClause : temp_excludesClause) {
                        if (w.visitIteratedElement(i_temp_excludesClause, elt_temp_excludesClause)) {
                            if (elt_temp_excludesClause == null) w.visitNull();
                            else {
                                elt_temp_excludesClause.walk(w);
                            }
                        }
                        i_temp_excludesClause++;
                    }
                    w.endIterated(temp_excludesClause, i_temp_excludesClause);
                }
                w.endNodeField("excludesClause", temp_excludesClause);
            }
            Option<List<NamedType>> temp_comprisesClause = getComprisesClause();
            if (w.visitNodeField("comprisesClause", temp_comprisesClause)) {
                if (temp_comprisesClause.isNone()) {
                    w.visitEmptyOption(temp_comprisesClause);
                }
                else if (w.visitNonEmptyOption(temp_comprisesClause)) {
                    List<NamedType> elt_temp_comprisesClause = temp_comprisesClause.unwrap();
                    if (elt_temp_comprisesClause == null) w.visitNull();
                    else {
                        if (w.visitIterated(elt_temp_comprisesClause)) {
                            int i_elt_temp_comprisesClause = 0;
                            for (NamedType elt_elt_temp_comprisesClause : elt_temp_comprisesClause) {
                                if (w.visitIteratedElement(i_elt_temp_comprisesClause, elt_elt_temp_comprisesClause)) {
                                    if (elt_elt_temp_comprisesClause == null) w.visitNull();
                                    else {
                                        elt_elt_temp_comprisesClause.walk(w);
                                    }
                                }
                                i_elt_temp_comprisesClause++;
                            }
                            w.endIterated(elt_temp_comprisesClause, i_elt_temp_comprisesClause);
                        }
                    }
                    w.endNonEmptyOption(temp_comprisesClause);
                }
                w.endNodeField("comprisesClause", temp_comprisesClause);
            }
            boolean temp_comprisesEllipses = isComprisesEllipses();
            if (w.visitNodeField("comprisesEllipses", temp_comprisesEllipses)) {
                w.visitBoolean(temp_comprisesEllipses);
                w.endNodeField("comprisesEllipses", temp_comprisesEllipses);
            }
            w.endNode(this, "TraitDecl", 6);
        }
    }

}
