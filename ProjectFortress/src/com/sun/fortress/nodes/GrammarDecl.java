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
 * Class GrammarDecl, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class GrammarDecl extends Decl {
    private final Id _name;
    private final List<Id> _extendsClause;
    private final List<GrammarMemberDecl> _members;
    private final List<TransformerDecl> _transformers;
    private final boolean _nativeDef;

    /**
     * Constructs a GrammarDecl.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public GrammarDecl(ASTNodeInfo in_info, Id in_name, List<Id> in_extendsClause, List<GrammarMemberDecl> in_members, List<TransformerDecl> in_transformers, boolean in_nativeDef) {
        super(in_info);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the GrammarDecl constructor was null");
        }
        _name = in_name;
        if (in_extendsClause == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'extendsClause' to the GrammarDecl constructor was null");
        }
        _extendsClause = in_extendsClause;
        if (in_members == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'members' to the GrammarDecl constructor was null");
        }
        _members = in_members;
        if (in_transformers == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'transformers' to the GrammarDecl constructor was null");
        }
        _transformers = in_transformers;
        _nativeDef = in_nativeDef;
    }

    final public Id getName() { return _name; }
    final public List<Id> getExtendsClause() { return _extendsClause; }
    final public List<GrammarMemberDecl> getMembers() { return _members; }
    final public List<TransformerDecl> getTransformers() { return _transformers; }
    final public boolean isNativeDef() { return _nativeDef; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forGrammarDecl(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forGrammarDecl(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forGrammarDecl(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forGrammarDecl(this);
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
            GrammarDecl casted = (GrammarDecl) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_name = getName();
            Id casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            List<Id> temp_extendsClause = getExtendsClause();
            List<Id> casted_extendsClause = casted.getExtendsClause();
            if (!(temp_extendsClause == casted_extendsClause || temp_extendsClause.equals(casted_extendsClause))) return false;
            List<GrammarMemberDecl> temp_members = getMembers();
            List<GrammarMemberDecl> casted_members = casted.getMembers();
            if (!(temp_members == casted_members || temp_members.equals(casted_members))) return false;
            List<TransformerDecl> temp_transformers = getTransformers();
            List<TransformerDecl> casted_transformers = casted.getTransformers();
            if (!(temp_transformers == casted_transformers || temp_transformers.equals(casted_transformers))) return false;
            boolean temp_nativeDef = isNativeDef();
            boolean casted_nativeDef = casted.isNativeDef();
            if (!(temp_nativeDef == casted_nativeDef)) return false;
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
        List<Id> temp_extendsClause = getExtendsClause();
        code ^= temp_extendsClause.hashCode();
        List<GrammarMemberDecl> temp_members = getMembers();
        code ^= temp_members.hashCode();
        List<TransformerDecl> temp_transformers = getTransformers();
        code ^= temp_transformers.hashCode();
        boolean temp_nativeDef = isNativeDef();
        code ^= temp_nativeDef ? 1231 : 1237;
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected GrammarDecl() {
        _name = null;
        _extendsClause = null;
        _members = null;
        _transformers = null;
        _nativeDef = false;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected GrammarDecl(ASTNodeInfo info) {
        super(info);
        _name = null;
        _extendsClause = null;
        _members = null;
        _transformers = null;
        _nativeDef = false;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "GrammarDecl", 6)) {
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
            List<Id> temp_extendsClause = getExtendsClause();
            if (w.visitNodeField("extendsClause", temp_extendsClause)) {
                if (w.visitIterated(temp_extendsClause)) {
                    int i_temp_extendsClause = 0;
                    for (Id elt_temp_extendsClause : temp_extendsClause) {
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
            List<GrammarMemberDecl> temp_members = getMembers();
            if (w.visitNodeField("members", temp_members)) {
                if (w.visitIterated(temp_members)) {
                    int i_temp_members = 0;
                    for (GrammarMemberDecl elt_temp_members : temp_members) {
                        if (w.visitIteratedElement(i_temp_members, elt_temp_members)) {
                            if (elt_temp_members == null) w.visitNull();
                            else {
                                elt_temp_members.walk(w);
                            }
                        }
                        i_temp_members++;
                    }
                    w.endIterated(temp_members, i_temp_members);
                }
                w.endNodeField("members", temp_members);
            }
            List<TransformerDecl> temp_transformers = getTransformers();
            if (w.visitNodeField("transformers", temp_transformers)) {
                if (w.visitIterated(temp_transformers)) {
                    int i_temp_transformers = 0;
                    for (TransformerDecl elt_temp_transformers : temp_transformers) {
                        if (w.visitIteratedElement(i_temp_transformers, elt_temp_transformers)) {
                            if (elt_temp_transformers == null) w.visitNull();
                            else {
                                elt_temp_transformers.walk(w);
                            }
                        }
                        i_temp_transformers++;
                    }
                    w.endIterated(temp_transformers, i_temp_transformers);
                }
                w.endNodeField("transformers", temp_transformers);
            }
            boolean temp_nativeDef = isNativeDef();
            if (w.visitNodeField("nativeDef", temp_nativeDef)) {
                w.visitBoolean(temp_nativeDef);
                w.endNodeField("nativeDef", temp_nativeDef);
            }
            w.endNode(this, "GrammarDecl", 6);
        }
    }

}
