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
 * Class Api, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class Api extends CompilationUnit {

    /**
     * Constructs a Api.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Api(ASTNodeInfo in_info, APIName in_name, List<Import> in_imports, List<Decl> in_decls, List<APIName> in_comprises) {
        super(in_info, in_name, in_imports, in_decls, in_comprises);
    }


    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forApi(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forApi(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forApi(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forApi(this);
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
            Api casted = (Api) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            APIName temp_name = getName();
            APIName casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            List<Import> temp_imports = getImports();
            List<Import> casted_imports = casted.getImports();
            if (!(temp_imports == casted_imports || temp_imports.equals(casted_imports))) return false;
            List<Decl> temp_decls = getDecls();
            List<Decl> casted_decls = casted.getDecls();
            if (!(temp_decls == casted_decls || temp_decls.equals(casted_decls))) return false;
            List<APIName> temp_comprises = getComprises();
            List<APIName> casted_comprises = casted.getComprises();
            if (!(temp_comprises == casted_comprises || temp_comprises.equals(casted_comprises))) return false;
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
        APIName temp_name = getName();
        code ^= temp_name.hashCode();
        List<Import> temp_imports = getImports();
        code ^= temp_imports.hashCode();
        List<Decl> temp_decls = getDecls();
        code ^= temp_decls.hashCode();
        List<APIName> temp_comprises = getComprises();
        code ^= temp_comprises.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Api() {
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected Api(ASTNodeInfo info) {
        super(info);
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "Api", 5)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            APIName temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            List<Import> temp_imports = getImports();
            if (w.visitNodeField("imports", temp_imports)) {
                if (w.visitIterated(temp_imports)) {
                    int i_temp_imports = 0;
                    for (Import elt_temp_imports : temp_imports) {
                        if (w.visitIteratedElement(i_temp_imports, elt_temp_imports)) {
                            if (elt_temp_imports == null) w.visitNull();
                            else {
                                elt_temp_imports.walk(w);
                            }
                        }
                        i_temp_imports++;
                    }
                    w.endIterated(temp_imports, i_temp_imports);
                }
                w.endNodeField("imports", temp_imports);
            }
            List<Decl> temp_decls = getDecls();
            if (w.visitNodeField("decls", temp_decls)) {
                if (w.visitIterated(temp_decls)) {
                    int i_temp_decls = 0;
                    for (Decl elt_temp_decls : temp_decls) {
                        if (w.visitIteratedElement(i_temp_decls, elt_temp_decls)) {
                            if (elt_temp_decls == null) w.visitNull();
                            else {
                                elt_temp_decls.walk(w);
                            }
                        }
                        i_temp_decls++;
                    }
                    w.endIterated(temp_decls, i_temp_decls);
                }
                w.endNodeField("decls", temp_decls);
            }
            List<APIName> temp_comprises = getComprises();
            if (w.visitNodeField("comprises", temp_comprises)) {
                if (w.visitIterated(temp_comprises)) {
                    int i_temp_comprises = 0;
                    for (APIName elt_temp_comprises : temp_comprises) {
                        if (w.visitIteratedElement(i_temp_comprises, elt_temp_comprises)) {
                            if (elt_temp_comprises == null) w.visitNull();
                            else {
                                elt_temp_comprises.walk(w);
                            }
                        }
                        i_temp_comprises++;
                    }
                    w.endIterated(temp_comprises, i_temp_comprises);
                }
                w.endNodeField("comprises", temp_comprises);
            }
            w.endNode(this, "Api", 5);
        }
    }

}
