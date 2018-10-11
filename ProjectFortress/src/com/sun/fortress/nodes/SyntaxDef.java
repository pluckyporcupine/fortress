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
 * Class SyntaxDef, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class SyntaxDef extends SyntaxDecl {
    private final List<SyntaxSymbol> _syntaxSymbols;
    private final TransformerDecl _transformer;

    /**
     * Constructs a SyntaxDef.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public SyntaxDef(ASTNodeInfo in_info, Option<String> in_modifier, List<SyntaxSymbol> in_syntaxSymbols, TransformerDecl in_transformer) {
        super(in_info, in_modifier);
        if (in_syntaxSymbols == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxSymbols' to the SyntaxDef constructor was null");
        }
        _syntaxSymbols = in_syntaxSymbols;
        if (in_transformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'transformer' to the SyntaxDef constructor was null");
        }
        _transformer = in_transformer;
    }

    final public List<SyntaxSymbol> getSyntaxSymbols() { return _syntaxSymbols; }
    final public TransformerDecl getTransformer() { return _transformer; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forSyntaxDef(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forSyntaxDef(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forSyntaxDef(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forSyntaxDef(this);
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
            SyntaxDef casted = (SyntaxDef) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<String> temp_modifier = getModifier();
            Option<String> casted_modifier = casted.getModifier();
            if (!(temp_modifier == casted_modifier || temp_modifier.equals(casted_modifier))) return false;
            List<SyntaxSymbol> temp_syntaxSymbols = getSyntaxSymbols();
            List<SyntaxSymbol> casted_syntaxSymbols = casted.getSyntaxSymbols();
            if (!(temp_syntaxSymbols == casted_syntaxSymbols || temp_syntaxSymbols.equals(casted_syntaxSymbols))) return false;
            TransformerDecl temp_transformer = getTransformer();
            TransformerDecl casted_transformer = casted.getTransformer();
            if (!(temp_transformer == casted_transformer || temp_transformer.equals(casted_transformer))) return false;
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
        List<SyntaxSymbol> temp_syntaxSymbols = getSyntaxSymbols();
        code ^= temp_syntaxSymbols.hashCode();
        TransformerDecl temp_transformer = getTransformer();
        code ^= temp_transformer.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected SyntaxDef() {
        _syntaxSymbols = null;
        _transformer = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected SyntaxDef(ASTNodeInfo info) {
        super(info);
        _syntaxSymbols = null;
        _transformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "SyntaxDef", 4)) {
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
            List<SyntaxSymbol> temp_syntaxSymbols = getSyntaxSymbols();
            if (w.visitNodeField("syntaxSymbols", temp_syntaxSymbols)) {
                if (w.visitIterated(temp_syntaxSymbols)) {
                    int i_temp_syntaxSymbols = 0;
                    for (SyntaxSymbol elt_temp_syntaxSymbols : temp_syntaxSymbols) {
                        if (w.visitIteratedElement(i_temp_syntaxSymbols, elt_temp_syntaxSymbols)) {
                            if (elt_temp_syntaxSymbols == null) w.visitNull();
                            else {
                                elt_temp_syntaxSymbols.walk(w);
                            }
                        }
                        i_temp_syntaxSymbols++;
                    }
                    w.endIterated(temp_syntaxSymbols, i_temp_syntaxSymbols);
                }
                w.endNodeField("syntaxSymbols", temp_syntaxSymbols);
            }
            TransformerDecl temp_transformer = getTransformer();
            if (w.visitNodeField("transformer", temp_transformer)) {
                temp_transformer.walk(w);
                w.endNodeField("transformer", temp_transformer);
            }
            w.endNode(this, "SyntaxDef", 4);
        }
    }

}
