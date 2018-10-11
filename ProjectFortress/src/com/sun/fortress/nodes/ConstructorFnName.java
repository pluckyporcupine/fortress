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
 * Class ConstructorFnName, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ConstructorFnName extends AnonymousName {
    private final ObjectConstructor _constructor;

    /**
     * Constructs a ConstructorFnName.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ConstructorFnName(ASTNodeInfo in_info, Option<APIName> in_apiName, ObjectConstructor in_constructor) {
        super(in_info, in_apiName);
        if (in_constructor == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'constructor' to the ConstructorFnName constructor was null");
        }
        _constructor = in_constructor;
    }

    final public ObjectConstructor getConstructor() { return _constructor; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forConstructorFnName(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forConstructorFnName(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forConstructorFnName(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forConstructorFnName(this);
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
            ConstructorFnName casted = (ConstructorFnName) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<APIName> temp_apiName = getApiName();
            Option<APIName> casted_apiName = casted.getApiName();
            if (!(temp_apiName == casted_apiName || temp_apiName.equals(casted_apiName))) return false;
            ObjectConstructor temp_constructor = getConstructor();
            ObjectConstructor casted_constructor = casted.getConstructor();
            if (!(temp_constructor == casted_constructor || temp_constructor.equals(casted_constructor))) return false;
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
        Option<APIName> temp_apiName = getApiName();
        code ^= temp_apiName.hashCode();
        ObjectConstructor temp_constructor = getConstructor();
        code ^= temp_constructor.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ConstructorFnName() {
        _constructor = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ConstructorFnName(ASTNodeInfo info) {
        super(info);
        _constructor = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ConstructorFnName", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Option<APIName> temp_apiName = getApiName();
            if (w.visitNodeField("apiName", temp_apiName)) {
                if (temp_apiName.isNone()) {
                    w.visitEmptyOption(temp_apiName);
                }
                else if (w.visitNonEmptyOption(temp_apiName)) {
                    APIName elt_temp_apiName = temp_apiName.unwrap();
                    if (elt_temp_apiName == null) w.visitNull();
                    else {
                        elt_temp_apiName.walk(w);
                    }
                    w.endNonEmptyOption(temp_apiName);
                }
                w.endNodeField("apiName", temp_apiName);
            }
            ObjectConstructor temp_constructor = getConstructor();
            if (w.visitNodeField("constructor", temp_constructor)) {
                temp_constructor.walk(w);
                w.endNodeField("constructor", temp_constructor);
            }
            w.endNode(this, "ConstructorFnName", 3);
        }
    }

}
