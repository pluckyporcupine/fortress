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
 * Class _SyntaxTransformationComponent, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _SyntaxTransformationComponent extends Component implements _SyntaxTransformation {
    private final java.util.Map<String, Level> _variables;
    private final java.util.List<String> _syntaxParameters;
    private final String _syntaxTransformer;

    /**
     * Constructs a _SyntaxTransformationComponent.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _SyntaxTransformationComponent(APIName in_name, List<Import> in_imports, List<Decl> in_decls, List<APIName> in_comprises, boolean in__native, List<APIName> in_exports, ASTNodeInfo in_info, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        super(in_info, in_name, in_imports, in_decls, in_comprises, in__native, in_exports);
        if (in_variables == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'variables' to the _SyntaxTransformationComponent constructor was null");
        }
        _variables = in_variables;
        if (in_syntaxParameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxParameters' to the _SyntaxTransformationComponent constructor was null");
        }
        _syntaxParameters = in_syntaxParameters;
        if (in_syntaxTransformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'syntaxTransformer' to the _SyntaxTransformationComponent constructor was null");
        }
        _syntaxTransformer = in_syntaxTransformer.intern();
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public _SyntaxTransformationComponent(APIName in_name, List<Import> in_imports, List<Decl> in_decls, List<APIName> in_comprises, boolean in__native, List<APIName> in_exports, java.util.Map<String, Level> in_variables, java.util.List<String> in_syntaxParameters, String in_syntaxTransformer) {
        this(in_name, in_imports, in_decls, in_comprises, in__native, in_exports, NodeFactory.makeASTNodeInfo(NodeFactory.macroSpan), in_variables, in_syntaxParameters, in_syntaxTransformer);
    }

    final public java.util.Map<String, Level> getVariables() { return _variables; }
    final public java.util.List<String> getSyntaxParameters() { return _syntaxParameters; }
    final public String getSyntaxTransformer() { return _syntaxTransformer; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationComponent(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_SyntaxTransformationComponent(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationComponent(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_SyntaxTransformationComponent(this);
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
            _SyntaxTransformationComponent casted = (_SyntaxTransformationComponent) obj;
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
            boolean temp__native = is_native();
            boolean casted__native = casted.is_native();
            if (!(temp__native == casted__native)) return false;
            List<APIName> temp_exports = getExports();
            List<APIName> casted_exports = casted.getExports();
            if (!(temp_exports == casted_exports || temp_exports.equals(casted_exports))) return false;
            java.util.Map<String, Level> temp_variables = getVariables();
            java.util.Map<String, Level> casted_variables = casted.getVariables();
            if (!(temp_variables == casted_variables || temp_variables.equals(casted_variables))) return false;
            java.util.List<String> temp_syntaxParameters = getSyntaxParameters();
            java.util.List<String> casted_syntaxParameters = casted.getSyntaxParameters();
            if (!(temp_syntaxParameters == casted_syntaxParameters || temp_syntaxParameters.equals(casted_syntaxParameters))) return false;
            String temp_syntaxTransformer = getSyntaxTransformer();
            String casted_syntaxTransformer = casted.getSyntaxTransformer();
            if (!(temp_syntaxTransformer == casted_syntaxTransformer)) return false;
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
        APIName temp_name = getName();
        code ^= temp_name.hashCode();
        List<Import> temp_imports = getImports();
        code ^= temp_imports.hashCode();
        List<Decl> temp_decls = getDecls();
        code ^= temp_decls.hashCode();
        List<APIName> temp_comprises = getComprises();
        code ^= temp_comprises.hashCode();
        boolean temp__native = is_native();
        code ^= temp__native ? 1231 : 1237;
        List<APIName> temp_exports = getExports();
        code ^= temp_exports.hashCode();
        java.util.Map<String, Level> temp_variables = getVariables();
        code ^= temp_variables.hashCode();
        java.util.List<String> temp_syntaxParameters = getSyntaxParameters();
        code ^= temp_syntaxParameters.hashCode();
        String temp_syntaxTransformer = getSyntaxTransformer();
        code ^= temp_syntaxTransformer.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected _SyntaxTransformationComponent() {
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public Node accept(TemplateUpdateVisitor visitor) {
        return visitor.for_SyntaxTransformationComponent(this);
    }
    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _SyntaxTransformationComponent(ASTNodeInfo info) {
        super(info);
        _variables = null;
        _syntaxParameters = null;
        _syntaxTransformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_SyntaxTransformationComponent", 10)) {
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
            boolean temp__native = is_native();
            if (w.visitNodeField("_native", temp__native)) {
                w.visitBoolean(temp__native);
                w.endNodeField("_native", temp__native);
            }
            List<APIName> temp_exports = getExports();
            if (w.visitNodeField("exports", temp_exports)) {
                if (w.visitIterated(temp_exports)) {
                    int i_temp_exports = 0;
                    for (APIName elt_temp_exports : temp_exports) {
                        if (w.visitIteratedElement(i_temp_exports, elt_temp_exports)) {
                            if (elt_temp_exports == null) w.visitNull();
                            else {
                                elt_temp_exports.walk(w);
                            }
                        }
                        i_temp_exports++;
                    }
                    w.endIterated(temp_exports, i_temp_exports);
                }
                w.endNodeField("exports", temp_exports);
            }
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            java.util.Map<String, Level> temp_variables = getVariables();
            if (w.visitNodeField("variables", temp_variables)) {
                w.visitUnknownObject(temp_variables);
                w.endNodeField("variables", temp_variables);
            }
            java.util.List<String> temp_syntaxParameters = getSyntaxParameters();
            if (w.visitNodeField("syntaxParameters", temp_syntaxParameters)) {
                if (w.visitIterated(temp_syntaxParameters)) {
                    int i_temp_syntaxParameters = 0;
                    for (String elt_temp_syntaxParameters : temp_syntaxParameters) {
                        if (w.visitIteratedElement(i_temp_syntaxParameters, elt_temp_syntaxParameters)) {
                            if (elt_temp_syntaxParameters == null) w.visitNull();
                            else {
                                w.visitString(elt_temp_syntaxParameters);
                            }
                        }
                        i_temp_syntaxParameters++;
                    }
                    w.endIterated(temp_syntaxParameters, i_temp_syntaxParameters);
                }
                w.endNodeField("syntaxParameters", temp_syntaxParameters);
            }
            String temp_syntaxTransformer = getSyntaxTransformer();
            if (w.visitNodeField("syntaxTransformer", temp_syntaxTransformer)) {
                w.visitString(temp_syntaxTransformer);
                w.endNodeField("syntaxTransformer", temp_syntaxTransformer);
            }
            w.endNode(this, "_SyntaxTransformationComponent", 10);
        }
    }

}
