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
 * Class Pattern, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class Pattern extends AbstractNode implements TypeOrPattern {
    private final Option<Type> _name;
    private final PatternArgs _patterns;

    /**
     * Constructs a Pattern.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Pattern(ASTNodeInfo in_info, Option<Type> in_name, PatternArgs in_patterns) {
        super(in_info);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the Pattern constructor was null");
        }
        _name = in_name;
        if (in_patterns == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'patterns' to the Pattern constructor was null");
        }
        _patterns = in_patterns;
    }

    final public Option<Type> getName() { return _name; }
    final public PatternArgs getPatterns() { return _patterns; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forPattern(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forPattern(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forPattern(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forPattern(this);
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
            Pattern casted = (Pattern) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<Type> temp_name = getName();
            Option<Type> casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            PatternArgs temp_patterns = getPatterns();
            PatternArgs casted_patterns = casted.getPatterns();
            if (!(temp_patterns == casted_patterns || temp_patterns.equals(casted_patterns))) return false;
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
        Option<Type> temp_name = getName();
        code ^= temp_name.hashCode();
        PatternArgs temp_patterns = getPatterns();
        code ^= temp_patterns.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Pattern() {
        _name = null;
        _patterns = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Pattern(ASTNodeInfo info) {
        super(info);
        _name = null;
        _patterns = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "Pattern", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Option<Type> temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                if (temp_name.isNone()) {
                    w.visitEmptyOption(temp_name);
                }
                else if (w.visitNonEmptyOption(temp_name)) {
                    Type elt_temp_name = temp_name.unwrap();
                    if (elt_temp_name == null) w.visitNull();
                    else {
                        elt_temp_name.walk(w);
                    }
                    w.endNonEmptyOption(temp_name);
                }
                w.endNodeField("name", temp_name);
            }
            PatternArgs temp_patterns = getPatterns();
            if (w.visitNodeField("patterns", temp_patterns)) {
                temp_patterns.walk(w);
                w.endNodeField("patterns", temp_patterns);
            }
            w.endNode(this, "Pattern", 3);
        }
    }

}
