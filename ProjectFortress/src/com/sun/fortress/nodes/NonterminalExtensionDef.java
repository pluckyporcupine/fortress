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
 * Class NonterminalExtensionDef, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class NonterminalExtensionDef extends NonterminalDecl {

    /**
     * Constructs a NonterminalExtensionDef.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public NonterminalExtensionDef(ASTNodeInfo in_info, Id in_name, List<SyntaxDecl> in_syntaxDecls) {
        super(in_info, in_name, in_syntaxDecls);
    }


    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forNonterminalExtensionDef(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forNonterminalExtensionDef(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forNonterminalExtensionDef(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forNonterminalExtensionDef(this);
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
            NonterminalExtensionDef casted = (NonterminalExtensionDef) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_name = getName();
            Id casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            List<SyntaxDecl> temp_syntaxDecls = getSyntaxDecls();
            List<SyntaxDecl> casted_syntaxDecls = casted.getSyntaxDecls();
            if (!(temp_syntaxDecls == casted_syntaxDecls || temp_syntaxDecls.equals(casted_syntaxDecls))) return false;
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
        Id temp_name = getName();
        code ^= temp_name.hashCode();
        List<SyntaxDecl> temp_syntaxDecls = getSyntaxDecls();
        code ^= temp_syntaxDecls.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected NonterminalExtensionDef() {
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected NonterminalExtensionDef(ASTNodeInfo info) {
        super(info);
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "NonterminalExtensionDef", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Id temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            List<SyntaxDecl> temp_syntaxDecls = getSyntaxDecls();
            if (w.visitNodeField("syntaxDecls", temp_syntaxDecls)) {
                if (w.visitIterated(temp_syntaxDecls)) {
                    int i_temp_syntaxDecls = 0;
                    for (SyntaxDecl elt_temp_syntaxDecls : temp_syntaxDecls) {
                        if (w.visitIteratedElement(i_temp_syntaxDecls, elt_temp_syntaxDecls)) {
                            if (elt_temp_syntaxDecls == null) w.visitNull();
                            else {
                                elt_temp_syntaxDecls.walk(w);
                            }
                        }
                        i_temp_syntaxDecls++;
                    }
                    w.endIterated(temp_syntaxDecls, i_temp_syntaxDecls);
                }
                w.endNodeField("syntaxDecls", temp_syntaxDecls);
            }
            w.endNode(this, "NonterminalExtensionDef", 3);
        }
    }

}
