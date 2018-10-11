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
 * Class CompilationUnit, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public abstract class CompilationUnit extends AbstractNode {
    private final APIName _name;
    private final List<Import> _imports;
    private final List<Decl> _decls;
    private final List<APIName> _comprises;

    /**
     * Constructs a CompilationUnit.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public CompilationUnit(ASTNodeInfo in_info, APIName in_name, List<Import> in_imports, List<Decl> in_decls, List<APIName> in_comprises) {
        super(in_info);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the CompilationUnit constructor was null");
        }
        _name = in_name;
        if (in_imports == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'imports' to the CompilationUnit constructor was null");
        }
        _imports = in_imports;
        if (in_decls == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'decls' to the CompilationUnit constructor was null");
        }
        _decls = in_decls;
        if (in_comprises == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'comprises' to the CompilationUnit constructor was null");
        }
        _comprises = in_comprises;
    }

    public APIName getName() { return _name; }
    public List<Import> getImports() { return _imports; }
    public List<Decl> getDecls() { return _decls; }
    public List<APIName> getComprises() { return _comprises; }

    public abstract int generateHashCode();
    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected CompilationUnit() {
        _name = null;
        _imports = null;
        _decls = null;
        _comprises = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected CompilationUnit(ASTNodeInfo info) {
        super(info);
        _name = null;
        _imports = null;
        _decls = null;
        _comprises = null;
    }

}
