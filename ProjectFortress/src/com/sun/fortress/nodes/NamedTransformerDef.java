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
 * Class NamedTransformerDef, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class NamedTransformerDef extends TransformerDecl {
    private final String _name;
    private final List<NonterminalParameter> _parameters;
    private final Transformer _transformer;

    /**
     * Constructs a NamedTransformerDef.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public NamedTransformerDef(ASTNodeInfo in_info, String in_name, List<NonterminalParameter> in_parameters, Transformer in_transformer) {
        super(in_info);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the NamedTransformerDef constructor was null");
        }
        _name = in_name.intern();
        if (in_parameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'parameters' to the NamedTransformerDef constructor was null");
        }
        _parameters = in_parameters;
        if (in_transformer == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'transformer' to the NamedTransformerDef constructor was null");
        }
        _transformer = in_transformer;
    }

    final public String getName() { return _name; }
    final public List<NonterminalParameter> getParameters() { return _parameters; }
    final public Transformer getTransformer() { return _transformer; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forNamedTransformerDef(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forNamedTransformerDef(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forNamedTransformerDef(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forNamedTransformerDef(this);
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
            NamedTransformerDef casted = (NamedTransformerDef) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            String temp_name = getName();
            String casted_name = casted.getName();
            if (!(temp_name == casted_name)) return false;
            List<NonterminalParameter> temp_parameters = getParameters();
            List<NonterminalParameter> casted_parameters = casted.getParameters();
            if (!(temp_parameters == casted_parameters || temp_parameters.equals(casted_parameters))) return false;
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
        String temp_name = getName();
        code ^= temp_name.hashCode();
        List<NonterminalParameter> temp_parameters = getParameters();
        code ^= temp_parameters.hashCode();
        Transformer temp_transformer = getTransformer();
        code ^= temp_transformer.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected NamedTransformerDef() {
        _name = null;
        _parameters = null;
        _transformer = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected NamedTransformerDef(ASTNodeInfo info) {
        super(info);
        _name = null;
        _parameters = null;
        _transformer = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "NamedTransformerDef", 4)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            String temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                w.visitString(temp_name);
                w.endNodeField("name", temp_name);
            }
            List<NonterminalParameter> temp_parameters = getParameters();
            if (w.visitNodeField("parameters", temp_parameters)) {
                if (w.visitIterated(temp_parameters)) {
                    int i_temp_parameters = 0;
                    for (NonterminalParameter elt_temp_parameters : temp_parameters) {
                        if (w.visitIteratedElement(i_temp_parameters, elt_temp_parameters)) {
                            if (elt_temp_parameters == null) w.visitNull();
                            else {
                                elt_temp_parameters.walk(w);
                            }
                        }
                        i_temp_parameters++;
                    }
                    w.endIterated(temp_parameters, i_temp_parameters);
                }
                w.endNodeField("parameters", temp_parameters);
            }
            Transformer temp_transformer = getTransformer();
            if (w.visitNodeField("transformer", temp_transformer)) {
                temp_transformer.walk(w);
                w.endNodeField("transformer", temp_transformer);
            }
            w.endNode(this, "NamedTransformerDef", 4);
        }
    }

}
