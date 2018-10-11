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
 * Class _RewriteFunctionalMethodDecl, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class _RewriteFunctionalMethodDecl extends Decl {
    private final List<String> _functionalMethodNames;

    /**
     * Constructs a _RewriteFunctionalMethodDecl.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public _RewriteFunctionalMethodDecl(ASTNodeInfo in_info, List<String> in_functionalMethodNames) {
        super(in_info);
        if (in_functionalMethodNames == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'functionalMethodNames' to the _RewriteFunctionalMethodDecl constructor was null");
        }
        _functionalMethodNames = in_functionalMethodNames;
    }

    final public List<String> getFunctionalMethodNames() { return _functionalMethodNames; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.for_RewriteFunctionalMethodDecl(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.for_RewriteFunctionalMethodDecl(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.for_RewriteFunctionalMethodDecl(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.for_RewriteFunctionalMethodDecl(this);
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
            _RewriteFunctionalMethodDecl casted = (_RewriteFunctionalMethodDecl) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<String> temp_functionalMethodNames = getFunctionalMethodNames();
            List<String> casted_functionalMethodNames = casted.getFunctionalMethodNames();
            if (!(temp_functionalMethodNames == casted_functionalMethodNames || temp_functionalMethodNames.equals(casted_functionalMethodNames))) return false;
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
        List<String> temp_functionalMethodNames = getFunctionalMethodNames();
        code ^= temp_functionalMethodNames.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected _RewriteFunctionalMethodDecl() {
        _functionalMethodNames = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected _RewriteFunctionalMethodDecl(ASTNodeInfo info) {
        super(info);
        _functionalMethodNames = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "_RewriteFunctionalMethodDecl", 2)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<String> temp_functionalMethodNames = getFunctionalMethodNames();
            if (w.visitNodeField("functionalMethodNames", temp_functionalMethodNames)) {
                if (w.visitIterated(temp_functionalMethodNames)) {
                    int i_temp_functionalMethodNames = 0;
                    for (String elt_temp_functionalMethodNames : temp_functionalMethodNames) {
                        if (w.visitIteratedElement(i_temp_functionalMethodNames, elt_temp_functionalMethodNames)) {
                            if (elt_temp_functionalMethodNames == null) w.visitNull();
                            else {
                                w.visitString(elt_temp_functionalMethodNames);
                            }
                        }
                        i_temp_functionalMethodNames++;
                    }
                    w.endIterated(temp_functionalMethodNames, i_temp_functionalMethodNames);
                }
                w.endNodeField("functionalMethodNames", temp_functionalMethodNames);
            }
            w.endNode(this, "_RewriteFunctionalMethodDecl", 2);
        }
    }

}
