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
 * Class TupleType, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class TupleType extends Type {
    private final List<Type> _elements;
    private final Option<Type> _varargs;
    private final List<KeywordType> _keywords;

    /**
     * Constructs a TupleType.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public TupleType(TypeInfo in_info, List<Type> in_elements, Option<Type> in_varargs, List<KeywordType> in_keywords) {
        super(in_info);
        if (in_elements == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'elements' to the TupleType constructor was null");
        }
        _elements = in_elements;
        if (in_varargs == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'varargs' to the TupleType constructor was null");
        }
        _varargs = in_varargs;
        if (in_keywords == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'keywords' to the TupleType constructor was null");
        }
        _keywords = in_keywords;
    }

    final public List<Type> getElements() { return _elements; }
    final public Option<Type> getVarargs() { return _varargs; }
    final public List<KeywordType> getKeywords() { return _keywords; }

    public <RetType> RetType accept(TypeVisitor<RetType> visitor) {
        return visitor.forTupleType(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forTupleType(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forTupleType(this);
    }

    public void accept(TypeVisitor_void visitor) {
        visitor.forTupleType(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forTupleType(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forTupleType(this);
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
            TupleType casted = (TupleType) obj;
            TypeInfo temp_info = getInfo();
            TypeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<Type> temp_elements = getElements();
            List<Type> casted_elements = casted.getElements();
            if (!(temp_elements == casted_elements || temp_elements.equals(casted_elements))) return false;
            Option<Type> temp_varargs = getVarargs();
            Option<Type> casted_varargs = casted.getVarargs();
            if (!(temp_varargs == casted_varargs || temp_varargs.equals(casted_varargs))) return false;
            List<KeywordType> temp_keywords = getKeywords();
            List<KeywordType> casted_keywords = casted.getKeywords();
            if (!(temp_keywords == casted_keywords || temp_keywords.equals(casted_keywords))) return false;
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
        List<Type> temp_elements = getElements();
        code ^= temp_elements.hashCode();
        Option<Type> temp_varargs = getVarargs();
        code ^= temp_varargs.hashCode();
        List<KeywordType> temp_keywords = getKeywords();
        code ^= temp_keywords.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected TupleType() {
        _elements = null;
        _varargs = null;
        _keywords = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected TupleType(TypeInfo info) {
        super(info);
        _elements = null;
        _varargs = null;
        _keywords = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "TupleType", 4)) {
            TypeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<Type> temp_elements = getElements();
            if (w.visitNodeField("elements", temp_elements)) {
                if (w.visitIterated(temp_elements)) {
                    int i_temp_elements = 0;
                    for (Type elt_temp_elements : temp_elements) {
                        if (w.visitIteratedElement(i_temp_elements, elt_temp_elements)) {
                            if (elt_temp_elements == null) w.visitNull();
                            else {
                                elt_temp_elements.walk(w);
                            }
                        }
                        i_temp_elements++;
                    }
                    w.endIterated(temp_elements, i_temp_elements);
                }
                w.endNodeField("elements", temp_elements);
            }
            Option<Type> temp_varargs = getVarargs();
            if (w.visitNodeField("varargs", temp_varargs)) {
                if (temp_varargs.isNone()) {
                    w.visitEmptyOption(temp_varargs);
                }
                else if (w.visitNonEmptyOption(temp_varargs)) {
                    Type elt_temp_varargs = temp_varargs.unwrap();
                    if (elt_temp_varargs == null) w.visitNull();
                    else {
                        elt_temp_varargs.walk(w);
                    }
                    w.endNonEmptyOption(temp_varargs);
                }
                w.endNodeField("varargs", temp_varargs);
            }
            List<KeywordType> temp_keywords = getKeywords();
            if (w.visitNodeField("keywords", temp_keywords)) {
                if (w.visitIterated(temp_keywords)) {
                    int i_temp_keywords = 0;
                    for (KeywordType elt_temp_keywords : temp_keywords) {
                        if (w.visitIteratedElement(i_temp_keywords, elt_temp_keywords)) {
                            if (elt_temp_keywords == null) w.visitNull();
                            else {
                                elt_temp_keywords.walk(w);
                            }
                        }
                        i_temp_keywords++;
                    }
                    w.endIterated(temp_keywords, i_temp_keywords);
                }
                w.endNodeField("keywords", temp_keywords);
            }
            w.endNode(this, "TupleType", 4);
        }
    }

}
