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
 * Class OpRef, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class OpRef extends FunctionalRef {

    /**
     * Constructs a OpRef.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public OpRef(ExprInfo in_info, List<StaticArg> in_staticArgs, int in_lexicalDepth, IdOrOp in_originalName, List<IdOrOp> in_names, List<Overloading> in_interpOverloadings, List<Overloading> in_newOverloadings, Option<Type> in_overloadingType, Option<Type> in_overloadingSchema) {
        super(in_info, in_staticArgs, in_lexicalDepth, in_originalName, in_names, in_interpOverloadings, in_newOverloadings, in_overloadingType, in_overloadingSchema);
    }

    /**
     * A constructor with some fields provided by default values.
     */
    public OpRef(ExprInfo in_info, List<StaticArg> in_staticArgs, int in_lexicalDepth, IdOrOp in_originalName, List<IdOrOp> in_names, List<Overloading> in_interpOverloadings, List<Overloading> in_newOverloadings, Option<Type> in_overloadingType) {
        this(in_info, in_staticArgs, in_lexicalDepth, in_originalName, in_names, in_interpOverloadings, in_newOverloadings, in_overloadingType, Option.<Type>none());
    }


    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forOpRef(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forOpRef(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forOpRef(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forOpRef(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forOpRef(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forOpRef(this);
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
            OpRef casted = (OpRef) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<StaticArg> temp_staticArgs = getStaticArgs();
            List<StaticArg> casted_staticArgs = casted.getStaticArgs();
            if (!(temp_staticArgs == casted_staticArgs || temp_staticArgs.equals(casted_staticArgs))) return false;
            int temp_lexicalDepth = getLexicalDepth();
            int casted_lexicalDepth = casted.getLexicalDepth();
            if (!(temp_lexicalDepth == casted_lexicalDepth)) return false;
            IdOrOp temp_originalName = getOriginalName();
            IdOrOp casted_originalName = casted.getOriginalName();
            if (!(temp_originalName == casted_originalName || temp_originalName.equals(casted_originalName))) return false;
            List<IdOrOp> temp_names = getNames();
            List<IdOrOp> casted_names = casted.getNames();
            if (!(temp_names == casted_names || temp_names.equals(casted_names))) return false;
            List<Overloading> temp_interpOverloadings = getInterpOverloadings();
            List<Overloading> casted_interpOverloadings = casted.getInterpOverloadings();
            if (!(temp_interpOverloadings == casted_interpOverloadings || temp_interpOverloadings.equals(casted_interpOverloadings))) return false;
            List<Overloading> temp_newOverloadings = getNewOverloadings();
            List<Overloading> casted_newOverloadings = casted.getNewOverloadings();
            if (!(temp_newOverloadings == casted_newOverloadings || temp_newOverloadings.equals(casted_newOverloadings))) return false;
            Option<Type> temp_overloadingType = getOverloadingType();
            Option<Type> casted_overloadingType = casted.getOverloadingType();
            if (!(temp_overloadingType == casted_overloadingType || temp_overloadingType.equals(casted_overloadingType))) return false;
            Option<Type> temp_overloadingSchema = getOverloadingSchema();
            Option<Type> casted_overloadingSchema = casted.getOverloadingSchema();
            if (!(temp_overloadingSchema == casted_overloadingSchema || temp_overloadingSchema.equals(casted_overloadingSchema))) return false;
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
        ExprInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        List<StaticArg> temp_staticArgs = getStaticArgs();
        code ^= temp_staticArgs.hashCode();
        int temp_lexicalDepth = getLexicalDepth();
        code ^= temp_lexicalDepth;
        IdOrOp temp_originalName = getOriginalName();
        code ^= temp_originalName.hashCode();
        List<IdOrOp> temp_names = getNames();
        code ^= temp_names.hashCode();
        List<Overloading> temp_interpOverloadings = getInterpOverloadings();
        code ^= temp_interpOverloadings.hashCode();
        List<Overloading> temp_newOverloadings = getNewOverloadings();
        code ^= temp_newOverloadings.hashCode();
        Option<Type> temp_overloadingType = getOverloadingType();
        code ^= temp_overloadingType.hashCode();
        Option<Type> temp_overloadingSchema = getOverloadingSchema();
        code ^= temp_overloadingSchema.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected OpRef() {
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected OpRef(ExprInfo info) {
        super(info);
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "OpRef", 9)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<StaticArg> temp_staticArgs = getStaticArgs();
            if (w.visitNodeField("staticArgs", temp_staticArgs)) {
                if (w.visitIterated(temp_staticArgs)) {
                    int i_temp_staticArgs = 0;
                    for (StaticArg elt_temp_staticArgs : temp_staticArgs) {
                        if (w.visitIteratedElement(i_temp_staticArgs, elt_temp_staticArgs)) {
                            if (elt_temp_staticArgs == null) w.visitNull();
                            else {
                                elt_temp_staticArgs.walk(w);
                            }
                        }
                        i_temp_staticArgs++;
                    }
                    w.endIterated(temp_staticArgs, i_temp_staticArgs);
                }
                w.endNodeField("staticArgs", temp_staticArgs);
            }
            int temp_lexicalDepth = getLexicalDepth();
            if (w.visitNodeField("lexicalDepth", temp_lexicalDepth)) {
                w.visitInt(temp_lexicalDepth);
                w.endNodeField("lexicalDepth", temp_lexicalDepth);
            }
            IdOrOp temp_originalName = getOriginalName();
            if (w.visitNodeField("originalName", temp_originalName)) {
                temp_originalName.walk(w);
                w.endNodeField("originalName", temp_originalName);
            }
            List<IdOrOp> temp_names = getNames();
            if (w.visitNodeField("names", temp_names)) {
                if (w.visitIterated(temp_names)) {
                    int i_temp_names = 0;
                    for (IdOrOp elt_temp_names : temp_names) {
                        if (w.visitIteratedElement(i_temp_names, elt_temp_names)) {
                            if (elt_temp_names == null) w.visitNull();
                            else {
                                elt_temp_names.walk(w);
                            }
                        }
                        i_temp_names++;
                    }
                    w.endIterated(temp_names, i_temp_names);
                }
                w.endNodeField("names", temp_names);
            }
            List<Overloading> temp_interpOverloadings = getInterpOverloadings();
            if (w.visitNodeField("interpOverloadings", temp_interpOverloadings)) {
                if (w.visitIterated(temp_interpOverloadings)) {
                    int i_temp_interpOverloadings = 0;
                    for (Overloading elt_temp_interpOverloadings : temp_interpOverloadings) {
                        if (w.visitIteratedElement(i_temp_interpOverloadings, elt_temp_interpOverloadings)) {
                            if (elt_temp_interpOverloadings == null) w.visitNull();
                            else {
                                elt_temp_interpOverloadings.walk(w);
                            }
                        }
                        i_temp_interpOverloadings++;
                    }
                    w.endIterated(temp_interpOverloadings, i_temp_interpOverloadings);
                }
                w.endNodeField("interpOverloadings", temp_interpOverloadings);
            }
            List<Overloading> temp_newOverloadings = getNewOverloadings();
            if (w.visitNodeField("newOverloadings", temp_newOverloadings)) {
                if (w.visitIterated(temp_newOverloadings)) {
                    int i_temp_newOverloadings = 0;
                    for (Overloading elt_temp_newOverloadings : temp_newOverloadings) {
                        if (w.visitIteratedElement(i_temp_newOverloadings, elt_temp_newOverloadings)) {
                            if (elt_temp_newOverloadings == null) w.visitNull();
                            else {
                                elt_temp_newOverloadings.walk(w);
                            }
                        }
                        i_temp_newOverloadings++;
                    }
                    w.endIterated(temp_newOverloadings, i_temp_newOverloadings);
                }
                w.endNodeField("newOverloadings", temp_newOverloadings);
            }
            Option<Type> temp_overloadingType = getOverloadingType();
            if (w.visitNodeField("overloadingType", temp_overloadingType)) {
                if (temp_overloadingType.isNone()) {
                    w.visitEmptyOption(temp_overloadingType);
                }
                else if (w.visitNonEmptyOption(temp_overloadingType)) {
                    Type elt_temp_overloadingType = temp_overloadingType.unwrap();
                    if (elt_temp_overloadingType == null) w.visitNull();
                    else {
                        elt_temp_overloadingType.walk(w);
                    }
                    w.endNonEmptyOption(temp_overloadingType);
                }
                w.endNodeField("overloadingType", temp_overloadingType);
            }
            Option<Type> temp_overloadingSchema = getOverloadingSchema();
            if (w.visitNodeField("overloadingSchema", temp_overloadingSchema)) {
                if (temp_overloadingSchema.isNone()) {
                    w.visitEmptyOption(temp_overloadingSchema);
                }
                else if (w.visitNonEmptyOption(temp_overloadingSchema)) {
                    Type elt_temp_overloadingSchema = temp_overloadingSchema.unwrap();
                    if (elt_temp_overloadingSchema == null) w.visitNull();
                    else {
                        elt_temp_overloadingSchema.walk(w);
                    }
                    w.endNonEmptyOption(temp_overloadingSchema);
                }
                w.endNodeField("overloadingSchema", temp_overloadingSchema);
            }
            w.endNode(this, "OpRef", 9);
        }
    }

}
