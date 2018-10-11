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
 * Class ImportApi, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ImportApi extends Import {
    private final List<AliasedAPIName> _apis;

    /**
     * Constructs a ImportApi.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ImportApi(ASTNodeInfo in_info, Option<String> in_foreignLanguage, List<AliasedAPIName> in_apis) {
        super(in_info, in_foreignLanguage);
        if (in_apis == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'apis' to the ImportApi constructor was null");
        }
        _apis = in_apis;
    }

    final public List<AliasedAPIName> getApis() { return _apis; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forImportApi(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forImportApi(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forImportApi(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forImportApi(this);
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
            ImportApi casted = (ImportApi) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<String> temp_foreignLanguage = getForeignLanguage();
            Option<String> casted_foreignLanguage = casted.getForeignLanguage();
            if (!(temp_foreignLanguage == casted_foreignLanguage || temp_foreignLanguage.equals(casted_foreignLanguage))) return false;
            List<AliasedAPIName> temp_apis = getApis();
            List<AliasedAPIName> casted_apis = casted.getApis();
            if (!(temp_apis == casted_apis || temp_apis.equals(casted_apis))) return false;
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
        Option<String> temp_foreignLanguage = getForeignLanguage();
        code ^= temp_foreignLanguage.hashCode();
        List<AliasedAPIName> temp_apis = getApis();
        code ^= temp_apis.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ImportApi() {
        _apis = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ImportApi(ASTNodeInfo info) {
        super(info);
        _apis = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ImportApi", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Option<String> temp_foreignLanguage = getForeignLanguage();
            if (w.visitNodeField("foreignLanguage", temp_foreignLanguage)) {
                if (temp_foreignLanguage.isNone()) {
                    w.visitEmptyOption(temp_foreignLanguage);
                }
                else if (w.visitNonEmptyOption(temp_foreignLanguage)) {
                    String elt_temp_foreignLanguage = temp_foreignLanguage.unwrap();
                    if (elt_temp_foreignLanguage == null) w.visitNull();
                    else {
                        w.visitString(elt_temp_foreignLanguage);
                    }
                    w.endNonEmptyOption(temp_foreignLanguage);
                }
                w.endNodeField("foreignLanguage", temp_foreignLanguage);
            }
            List<AliasedAPIName> temp_apis = getApis();
            if (w.visitNodeField("apis", temp_apis)) {
                if (w.visitIterated(temp_apis)) {
                    int i_temp_apis = 0;
                    for (AliasedAPIName elt_temp_apis : temp_apis) {
                        if (w.visitIteratedElement(i_temp_apis, elt_temp_apis)) {
                            if (elt_temp_apis == null) w.visitNull();
                            else {
                                elt_temp_apis.walk(w);
                            }
                        }
                        i_temp_apis++;
                    }
                    w.endIterated(temp_apis, i_temp_apis);
                }
                w.endNodeField("apis", temp_apis);
            }
            w.endNode(this, "ImportApi", 3);
        }
    }

}
