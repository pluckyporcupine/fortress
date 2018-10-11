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
 * Class NonterminalDef, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class NonterminalDef extends NonterminalDecl {
    private final NonterminalHeader _header;
    private final Option<BaseType> _astType;

    /**
     * Constructs a NonterminalDef.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public NonterminalDef(ASTNodeInfo in_info, Id in_name, List<SyntaxDecl> in_syntaxDecls, NonterminalHeader in_header, Option<BaseType> in_astType) {
        super(in_info, in_name, in_syntaxDecls);
        if (in_header == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'header' to the NonterminalDef constructor was null");
        }
        _header = in_header;
        if (in_astType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'astType' to the NonterminalDef constructor was null");
        }
        _astType = in_astType;
    }

    final public NonterminalHeader getHeader() { return _header; }
    final public Option<BaseType> getAstType() { return _astType; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forNonterminalDef(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forNonterminalDef(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forNonterminalDef(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forNonterminalDef(this);
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
            NonterminalDef casted = (NonterminalDef) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_name = getName();
            Id casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            List<SyntaxDecl> temp_syntaxDecls = getSyntaxDecls();
            List<SyntaxDecl> casted_syntaxDecls = casted.getSyntaxDecls();
            if (!(temp_syntaxDecls == casted_syntaxDecls || temp_syntaxDecls.equals(casted_syntaxDecls))) return false;
            NonterminalHeader temp_header = getHeader();
            NonterminalHeader casted_header = casted.getHeader();
            if (!(temp_header == casted_header || temp_header.equals(casted_header))) return false;
            Option<BaseType> temp_astType = getAstType();
            Option<BaseType> casted_astType = casted.getAstType();
            if (!(temp_astType == casted_astType || temp_astType.equals(casted_astType))) return false;
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
        NonterminalHeader temp_header = getHeader();
        code ^= temp_header.hashCode();
        Option<BaseType> temp_astType = getAstType();
        code ^= temp_astType.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected NonterminalDef() {
        _header = null;
        _astType = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected NonterminalDef(ASTNodeInfo info) {
        super(info);
        _header = null;
        _astType = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "NonterminalDef", 5)) {
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
            NonterminalHeader temp_header = getHeader();
            if (w.visitNodeField("header", temp_header)) {
                temp_header.walk(w);
                w.endNodeField("header", temp_header);
            }
            Option<BaseType> temp_astType = getAstType();
            if (w.visitNodeField("astType", temp_astType)) {
                if (temp_astType.isNone()) {
                    w.visitEmptyOption(temp_astType);
                }
                else if (w.visitNonEmptyOption(temp_astType)) {
                    BaseType elt_temp_astType = temp_astType.unwrap();
                    if (elt_temp_astType == null) w.visitNull();
                    else {
                        elt_temp_astType.walk(w);
                    }
                    w.endNonEmptyOption(temp_astType);
                }
                w.endNodeField("astType", temp_astType);
            }
            w.endNode(this, "NonterminalDef", 5);
        }
    }

}
