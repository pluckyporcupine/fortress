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
 * Class ImportStar, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class ImportStar extends ImportedNames {
    private final List<IdOrOpOrAnonymousName> _exceptNames;

    /**
     * Constructs a ImportStar.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public ImportStar(ASTNodeInfo in_info, Option<String> in_foreignLanguage, APIName in_apiName, List<IdOrOpOrAnonymousName> in_exceptNames) {
        super(in_info, in_foreignLanguage, in_apiName);
        if (in_exceptNames == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'exceptNames' to the ImportStar constructor was null");
        }
        _exceptNames = in_exceptNames;
    }

    final public List<IdOrOpOrAnonymousName> getExceptNames() { return _exceptNames; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forImportStar(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forImportStar(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forImportStar(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forImportStar(this);
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
            ImportStar casted = (ImportStar) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Option<String> temp_foreignLanguage = getForeignLanguage();
            Option<String> casted_foreignLanguage = casted.getForeignLanguage();
            if (!(temp_foreignLanguage == casted_foreignLanguage || temp_foreignLanguage.equals(casted_foreignLanguage))) return false;
            APIName temp_apiName = getApiName();
            APIName casted_apiName = casted.getApiName();
            if (!(temp_apiName == casted_apiName || temp_apiName.equals(casted_apiName))) return false;
            List<IdOrOpOrAnonymousName> temp_exceptNames = getExceptNames();
            List<IdOrOpOrAnonymousName> casted_exceptNames = casted.getExceptNames();
            if (!(temp_exceptNames == casted_exceptNames || temp_exceptNames.equals(casted_exceptNames))) return false;
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
        List<IdOrOpOrAnonymousName> temp_exceptNames = getExceptNames();
        code ^= temp_exceptNames.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected ImportStar() {
        _exceptNames = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected ImportStar(ASTNodeInfo info) {
        super(info);
        _exceptNames = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "ImportStar", 4)) {
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
            List<IdOrOpOrAnonymousName> temp_exceptNames = getExceptNames();
            if (w.visitNodeField("exceptNames", temp_exceptNames)) {
                if (w.visitIterated(temp_exceptNames)) {
                    int i_temp_exceptNames = 0;
                    for (IdOrOpOrAnonymousName elt_temp_exceptNames : temp_exceptNames) {
                        if (w.visitIteratedElement(i_temp_exceptNames, elt_temp_exceptNames)) {
                            if (elt_temp_exceptNames == null) w.visitNull();
                            else {
                                elt_temp_exceptNames.walk(w);
                            }
                        }
                        i_temp_exceptNames++;
                    }
                    w.endIterated(temp_exceptNames, i_temp_exceptNames);
                }
                w.endNodeField("exceptNames", temp_exceptNames);
            }
            w.endNode(this, "ImportStar", 4);
        }
    }

}
