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
 * Class CaseTransformerClause, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class CaseTransformerClause extends AbstractNode {
    private final Id _constructor;
    private final List<Id> _parameters;
    private final Transformer _body;

    /**
     * Constructs a CaseTransformerClause.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public CaseTransformerClause(ASTNodeInfo in_info, Id in_constructor, List<Id> in_parameters, Transformer in_body) {
        super(in_info);
        if (in_constructor == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'constructor' to the CaseTransformerClause constructor was null");
        }
        _constructor = in_constructor;
        if (in_parameters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'parameters' to the CaseTransformerClause constructor was null");
        }
        _parameters = in_parameters;
        if (in_body == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'body' to the CaseTransformerClause constructor was null");
        }
        _body = in_body;
    }

    final public Id getConstructor() { return _constructor; }
    final public List<Id> getParameters() { return _parameters; }
    final public Transformer getBody() { return _body; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forCaseTransformerClause(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forCaseTransformerClause(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forCaseTransformerClause(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forCaseTransformerClause(this);
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
            CaseTransformerClause casted = (CaseTransformerClause) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_constructor = getConstructor();
            Id casted_constructor = casted.getConstructor();
            if (!(temp_constructor == casted_constructor || temp_constructor.equals(casted_constructor))) return false;
            List<Id> temp_parameters = getParameters();
            List<Id> casted_parameters = casted.getParameters();
            if (!(temp_parameters == casted_parameters || temp_parameters.equals(casted_parameters))) return false;
            Transformer temp_body = getBody();
            Transformer casted_body = casted.getBody();
            if (!(temp_body == casted_body || temp_body.equals(casted_body))) return false;
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
        Id temp_constructor = getConstructor();
        code ^= temp_constructor.hashCode();
        List<Id> temp_parameters = getParameters();
        code ^= temp_parameters.hashCode();
        Transformer temp_body = getBody();
        code ^= temp_body.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected CaseTransformerClause() {
        _constructor = null;
        _parameters = null;
        _body = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected CaseTransformerClause(ASTNodeInfo info) {
        super(info);
        _constructor = null;
        _parameters = null;
        _body = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "CaseTransformerClause", 4)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Id temp_constructor = getConstructor();
            if (w.visitNodeField("constructor", temp_constructor)) {
                temp_constructor.walk(w);
                w.endNodeField("constructor", temp_constructor);
            }
            List<Id> temp_parameters = getParameters();
            if (w.visitNodeField("parameters", temp_parameters)) {
                if (w.visitIterated(temp_parameters)) {
                    int i_temp_parameters = 0;
                    for (Id elt_temp_parameters : temp_parameters) {
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
            Transformer temp_body = getBody();
            if (w.visitNodeField("body", temp_body)) {
                temp_body.walk(w);
                w.endNodeField("body", temp_body);
            }
            w.endNode(this, "CaseTransformerClause", 4);
        }
    }

}
