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
 * Class ImportNames, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ImportNames extends ImportedNames {
    private final List<AliasedSimpleName> _aliasedNames;

    /**
     * Constructs a ImportNames.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ImportNames(ASTNodeInfo in_info, Option<String> in_foreignLanguage, APIName in_apiName, List<AliasedSimpleName> in_aliasedNames) {
        super(in_info, in_foreignLanguage, in_apiName);
        if (in_aliasedNames == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'aliasedNames' to the ImportNames constructor was null");
        }
        _aliasedNames = in_aliasedNames;
    }

    final public List<AliasedSimpleName> getAliasedNames() { return _aliasedNames; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forImportNames(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forImportNames(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forImportNames(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forImportNames(this);
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
            ImportNames casted = (ImportNames) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<String> temp_foreignLanguage = getForeignLanguage();
            Option<String> casted_foreignLanguage = casted.getForeignLanguage();
            if (!(temp_foreignLanguage == casted_foreignLanguage || temp_foreignLanguage.equals(casted_foreignLanguage))) return false;
            APIName temp_apiName = getApiName();
            APIName casted_apiName = casted.getApiName();
            if (!(temp_apiName == casted_apiName || temp_apiName.equals(casted_apiName))) return false;
            List<AliasedSimpleName> temp_aliasedNames = getAliasedNames();
            List<AliasedSimpleName> casted_aliasedNames = casted.getAliasedNames();
            if (!(temp_aliasedNames == casted_aliasedNames || temp_aliasedNames.equals(casted_aliasedNames))) return false;
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
        APIName temp_apiName = getApiName();
        code ^= temp_apiName.hashCode();
        List<AliasedSimpleName> temp_aliasedNames = getAliasedNames();
        code ^= temp_aliasedNames.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ImportNames() {
        _aliasedNames = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ImportNames(ASTNodeInfo info) {
        super(info);
        _aliasedNames = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ImportNames", 4)) {
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
            APIName temp_apiName = getApiName();
            if (w.visitNodeField("apiName", temp_apiName)) {
                temp_apiName.walk(w);
                w.endNodeField("apiName", temp_apiName);
            }
            List<AliasedSimpleName> temp_aliasedNames = getAliasedNames();
            if (w.visitNodeField("aliasedNames", temp_aliasedNames)) {
                if (w.visitIterated(temp_aliasedNames)) {
                    int i_temp_aliasedNames = 0;
                    for (AliasedSimpleName elt_temp_aliasedNames : temp_aliasedNames) {
                        if (w.visitIteratedElement(i_temp_aliasedNames, elt_temp_aliasedNames)) {
                            if (elt_temp_aliasedNames == null) w.visitNull();
                            else {
                                elt_temp_aliasedNames.walk(w);
                            }
                        }
                        i_temp_aliasedNames++;
                    }
                    w.endIterated(temp_aliasedNames, i_temp_aliasedNames);
                }
                w.endNodeField("aliasedNames", temp_aliasedNames);
            }
            w.endNode(this, "ImportNames", 4);
        }
    }

}
