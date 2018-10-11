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
 * Class SuperSyntaxDef, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class SuperSyntaxDef extends SyntaxDecl {
    private final Id _nonterminal;
    private final Id _grammarId;

    /**
     * Constructs a SuperSyntaxDef.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public SuperSyntaxDef(ASTNodeInfo in_info, Option<String> in_modifier, Id in_nonterminal, Id in_grammarId) {
        super(in_info, in_modifier);
        if (in_nonterminal == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'nonterminal' to the SuperSyntaxDef constructor was null");
        }
        _nonterminal = in_nonterminal;
        if (in_grammarId == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'grammarId' to the SuperSyntaxDef constructor was null");
        }
        _grammarId = in_grammarId;
    }

    final public Id getNonterminal() { return _nonterminal; }
    final public Id getGrammarId() { return _grammarId; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forSuperSyntaxDef(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forSuperSyntaxDef(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forSuperSyntaxDef(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forSuperSyntaxDef(this);
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
            SuperSyntaxDef casted = (SuperSyntaxDef) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<String> temp_modifier = getModifier();
            Option<String> casted_modifier = casted.getModifier();
            if (!(temp_modifier == casted_modifier || temp_modifier.equals(casted_modifier))) return false;
            Id temp_nonterminal = getNonterminal();
            Id casted_nonterminal = casted.getNonterminal();
            if (!(temp_nonterminal == casted_nonterminal || temp_nonterminal.equals(casted_nonterminal))) return false;
            Id temp_grammarId = getGrammarId();
            Id casted_grammarId = casted.getGrammarId();
            if (!(temp_grammarId == casted_grammarId || temp_grammarId.equals(casted_grammarId))) return false;
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
        Option<String> temp_modifier = getModifier();
        code ^= temp_modifier.hashCode();
        Id temp_nonterminal = getNonterminal();
        code ^= temp_nonterminal.hashCode();
        Id temp_grammarId = getGrammarId();
        code ^= temp_grammarId.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected SuperSyntaxDef() {
        _nonterminal = null;
        _grammarId = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected SuperSyntaxDef(ASTNodeInfo info) {
        super(info);
        _nonterminal = null;
        _grammarId = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "SuperSyntaxDef", 4)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Option<String> temp_modifier = getModifier();
            if (w.visitNodeField("modifier", temp_modifier)) {
                if (temp_modifier.isNone()) {
                    w.visitEmptyOption(temp_modifier);
                }
                else if (w.visitNonEmptyOption(temp_modifier)) {
                    String elt_temp_modifier = temp_modifier.unwrap();
                    if (elt_temp_modifier == null) w.visitNull();
                    else {
                        w.visitString(elt_temp_modifier);
                    }
                    w.endNonEmptyOption(temp_modifier);
                }
                w.endNodeField("modifier", temp_modifier);
            }
            Id temp_nonterminal = getNonterminal();
            if (w.visitNodeField("nonterminal", temp_nonterminal)) {
                temp_nonterminal.walk(w);
                w.endNodeField("nonterminal", temp_nonterminal);
            }
            Id temp_grammarId = getGrammarId();
            if (w.visitNodeField("grammarId", temp_grammarId)) {
                temp_grammarId.walk(w);
                w.endNodeField("grammarId", temp_grammarId);
            }
            w.endNode(this, "SuperSyntaxDef", 4);
        }
    }

}
