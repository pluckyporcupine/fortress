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
 * Class PreTransformerDef, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class PreTransformerDef extends TransformerDecl {
    private final Transformer _transformer;

    /**
     * Constructs a PreTransformerDef.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public PreTransformerDef(ASTNodeInfo in_info, Transformer in_transformer) {
        super(in_info);
        if (in_transformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'transformer' to the PreTransformerDef constructor was null");
        }
        _transformer = in_transformer;
    }

    final public Transformer getTransformer() { return _transformer; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forPreTransformerDef(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forPreTransformerDef(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forPreTransformerDef(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forPreTransformerDef(this);
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
            PreTransformerDef casted = (PreTransformerDef) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Transformer temp_transformer = getTransformer();
            Transformer casted_transformer = casted.getTransformer();
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
        Transformer temp_transformer = getTransformer();
        code ^= temp_transformer.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected PreTransformerDef() {
        _transformer = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected PreTransformerDef(ASTNodeInfo info) {
        super(info);
        _transformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "PreTransformerDef", 2)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Transformer temp_transformer = getTransformer();
            if (w.visitNodeField("transformer", temp_transformer)) {
                temp_transformer.walk(w);
                w.endNodeField("transformer", temp_transformer);
            }
            w.endNode(this, "PreTransformerDef", 2);
        }
    }

}
