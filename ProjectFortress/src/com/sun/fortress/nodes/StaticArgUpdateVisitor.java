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
 * A depth-first visitor that makes an updated copy as it visits (by default).
 * The type of the result is generally the same as that of the argument; where
 * automatic recursion on a field of type T occurs, this must be true for T.
 * Where no changes are made to a node, a new copy is not allocated.
 * This visitor implements the visitor interface with methods that 
 * first update the children, and then call forCASEOnly(), passing in 
 * the values of the updated children. (CASE is replaced by the case name.)
 * Override forCASE or forCASEOnly if you want to transform an AST subtree.
 * There is no automatic delegation to more general cases, because each concrete
 * case has a default implementation.
 */
@SuppressWarnings("unused")
public abstract class StaticArgUpdateVisitor extends StaticArgVisitorLambda<StaticArg> {

    /* Methods to handle a node after recursion. */

    public StaticArg forTypeArgOnly(TypeArg that, ASTNodeInfo info_result, Type typeArg_result) {
        if (that.getInfo() == info_result && that.getTypeArg() == typeArg_result) return that;
        else return new TypeArg(info_result, that.isLifted(), typeArg_result);
    }

    public StaticArg forIntArgOnly(IntArg that, ASTNodeInfo info_result, IntExpr intVal_result) {
        if (that.getInfo() == info_result && that.getIntVal() == intVal_result) return that;
        else return new IntArg(info_result, that.isLifted(), intVal_result);
    }

    public StaticArg forBoolArgOnly(BoolArg that, ASTNodeInfo info_result, BoolExpr boolArg_result) {
        if (that.getInfo() == info_result && that.getBoolArg() == boolArg_result) return that;
        else return new BoolArg(info_result, that.isLifted(), boolArg_result);
    }

    public StaticArg forOpArgOnly(OpArg that, ASTNodeInfo info_result, Op id_result) {
        if (that.getInfo() == info_result && that.getId() == id_result) return that;
        else return new OpArg(info_result, that.isLifted(), id_result);
    }

    public StaticArg forDimArgOnly(DimArg that, ASTNodeInfo info_result, DimExpr dimArg_result) {
        if (that.getInfo() == info_result && that.getDimArg() == dimArg_result) return that;
        else return new DimArg(info_result, that.isLifted(), dimArg_result);
    }

    public StaticArg forUnitArgOnly(UnitArg that, ASTNodeInfo info_result, UnitExpr unitArg_result) {
        if (that.getInfo() == info_result && that.getUnitArg() == unitArg_result) return that;
        else return new UnitArg(info_result, that.isLifted(), unitArg_result);
    }

    public StaticArg for_SyntaxTransformationStaticArgOnly(_SyntaxTransformationStaticArg that, ASTNodeInfo info_result) {
        if (that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationStaticArg(that.isLifted(), info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public StaticArg for_SyntaxTransformationTypeArgOnly(_SyntaxTransformationTypeArg that, Type typeArg_result, ASTNodeInfo info_result) {
        if (that.getTypeArg() == typeArg_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationTypeArg(that.isLifted(), typeArg_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public StaticArg for_SyntaxTransformationIntArgOnly(_SyntaxTransformationIntArg that, IntExpr intVal_result, ASTNodeInfo info_result) {
        if (that.getIntVal() == intVal_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationIntArg(that.isLifted(), intVal_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public StaticArg for_SyntaxTransformationBoolArgOnly(_SyntaxTransformationBoolArg that, BoolExpr boolArg_result, ASTNodeInfo info_result) {
        if (that.getBoolArg() == boolArg_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationBoolArg(that.isLifted(), boolArg_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public StaticArg for_SyntaxTransformationOpArgOnly(_SyntaxTransformationOpArg that, Op id_result, ASTNodeInfo info_result) {
        if (that.getId() == id_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationOpArg(that.isLifted(), id_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public StaticArg for_SyntaxTransformationDimArgOnly(_SyntaxTransformationDimArg that, DimExpr dimArg_result, ASTNodeInfo info_result) {
        if (that.getDimArg() == dimArg_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationDimArg(that.isLifted(), dimArg_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public StaticArg for_SyntaxTransformationUnitArgOnly(_SyntaxTransformationUnitArg that, UnitExpr unitArg_result, ASTNodeInfo info_result) {
        if (that.getUnitArg() == unitArg_result && that.getInfo() == info_result) return that;
        else return new _SyntaxTransformationUnitArg(that.isLifted(), unitArg_result, info_result, that.getVariables(), that.getSyntaxParameters(), that.getSyntaxTransformer());
    }

    public StaticArg for_EllipsesStaticArgOnly(_EllipsesStaticArg that) {
        return that;
    }

    public StaticArg for_EllipsesTypeArgOnly(_EllipsesTypeArg that) {
        return that;
    }

    public StaticArg for_EllipsesIntArgOnly(_EllipsesIntArg that) {
        return that;
    }

    public StaticArg for_EllipsesBoolArgOnly(_EllipsesBoolArg that) {
        return that;
    }

    public StaticArg for_EllipsesOpArgOnly(_EllipsesOpArg that) {
        return that;
    }

    public StaticArg for_EllipsesDimArgOnly(_EllipsesDimArg that) {
        return that;
    }

    public StaticArg for_EllipsesUnitArgOnly(_EllipsesUnitArg that) {
        return that;
    }

    public StaticArg forTemplateGapStaticArgOnly(TemplateGapStaticArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapStaticArg(info_result, gapId_result, templateParams_result);
    }

    public StaticArg forTemplateGapTypeArgOnly(TemplateGapTypeArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapTypeArg(info_result, gapId_result, templateParams_result);
    }

    public StaticArg forTemplateGapIntArgOnly(TemplateGapIntArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapIntArg(info_result, gapId_result, templateParams_result);
    }

    public StaticArg forTemplateGapBoolArgOnly(TemplateGapBoolArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapBoolArg(info_result, gapId_result, templateParams_result);
    }

    public StaticArg forTemplateGapOpArgOnly(TemplateGapOpArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapOpArg(info_result, gapId_result, templateParams_result);
    }

    public StaticArg forTemplateGapDimArgOnly(TemplateGapDimArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapDimArg(info_result, gapId_result, templateParams_result);
    }

    public StaticArg forTemplateGapUnitArgOnly(TemplateGapUnitArg that, ASTNodeInfo info_result, Id gapId_result, List<Id> templateParams_result) {
        if (that.getInfo() == info_result && that.getGapId() == gapId_result && that.getTemplateParams() == templateParams_result) return that;
        else return new TemplateGapUnitArg(info_result, gapId_result, templateParams_result);
    }

    /** Methods to recur on each child. */

    public StaticArg forTypeArg(TypeArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Type typeArg_result = recurOnType(that.getTypeArg());
        return forTypeArgOnly(that, info_result, typeArg_result);
    }


    public StaticArg forIntArg(IntArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        IntExpr intVal_result = recurOnIntExpr(that.getIntVal());
        return forIntArgOnly(that, info_result, intVal_result);
    }


    public StaticArg forBoolArg(BoolArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        BoolExpr boolArg_result = recurOnBoolExpr(that.getBoolArg());
        return forBoolArgOnly(that, info_result, boolArg_result);
    }


    public StaticArg forOpArg(OpArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Op id_result = recurOnOp(that.getId());
        return forOpArgOnly(that, info_result, id_result);
    }


    public StaticArg forDimArg(DimArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        DimExpr dimArg_result = recurOnDimExpr(that.getDimArg());
        return forDimArgOnly(that, info_result, dimArg_result);
    }


    public StaticArg forUnitArg(UnitArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        UnitExpr unitArg_result = recurOnUnitExpr(that.getUnitArg());
        return forUnitArgOnly(that, info_result, unitArg_result);
    }


    public StaticArg for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationStaticArgOnly(that, info_result);
    }


    public StaticArg for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that) {
        Type typeArg_result = recurOnType(that.getTypeArg());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationTypeArgOnly(that, typeArg_result, info_result);
    }


    public StaticArg for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that) {
        IntExpr intVal_result = recurOnIntExpr(that.getIntVal());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationIntArgOnly(that, intVal_result, info_result);
    }


    public StaticArg for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that) {
        BoolExpr boolArg_result = recurOnBoolExpr(that.getBoolArg());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationBoolArgOnly(that, boolArg_result, info_result);
    }


    public StaticArg for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that) {
        Op id_result = recurOnOp(that.getId());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationOpArgOnly(that, id_result, info_result);
    }


    public StaticArg for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that) {
        DimExpr dimArg_result = recurOnDimExpr(that.getDimArg());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationDimArgOnly(that, dimArg_result, info_result);
    }


    public StaticArg for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that) {
        UnitExpr unitArg_result = recurOnUnitExpr(that.getUnitArg());
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        return for_SyntaxTransformationUnitArgOnly(that, unitArg_result, info_result);
    }


    public StaticArg for_EllipsesStaticArg(_EllipsesStaticArg that) {
        return for_EllipsesStaticArgOnly(that);
    }


    public StaticArg for_EllipsesTypeArg(_EllipsesTypeArg that) {
        return for_EllipsesTypeArgOnly(that);
    }


    public StaticArg for_EllipsesIntArg(_EllipsesIntArg that) {
        return for_EllipsesIntArgOnly(that);
    }


    public StaticArg for_EllipsesBoolArg(_EllipsesBoolArg that) {
        return for_EllipsesBoolArgOnly(that);
    }


    public StaticArg for_EllipsesOpArg(_EllipsesOpArg that) {
        return for_EllipsesOpArgOnly(that);
    }


    public StaticArg for_EllipsesDimArg(_EllipsesDimArg that) {
        return for_EllipsesDimArgOnly(that);
    }


    public StaticArg for_EllipsesUnitArg(_EllipsesUnitArg that) {
        return for_EllipsesUnitArgOnly(that);
    }


    public StaticArg forTemplateGapStaticArg(TemplateGapStaticArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapStaticArgOnly(that, info_result, gapId_result, templateParams_result);
    }


    public StaticArg forTemplateGapTypeArg(TemplateGapTypeArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapTypeArgOnly(that, info_result, gapId_result, templateParams_result);
    }


    public StaticArg forTemplateGapIntArg(TemplateGapIntArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapIntArgOnly(that, info_result, gapId_result, templateParams_result);
    }


    public StaticArg forTemplateGapBoolArg(TemplateGapBoolArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapBoolArgOnly(that, info_result, gapId_result, templateParams_result);
    }


    public StaticArg forTemplateGapOpArg(TemplateGapOpArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapOpArgOnly(that, info_result, gapId_result, templateParams_result);
    }


    public StaticArg forTemplateGapDimArg(TemplateGapDimArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapDimArgOnly(that, info_result, gapId_result, templateParams_result);
    }


    public StaticArg forTemplateGapUnitArg(TemplateGapUnitArg that) {
        ASTNodeInfo info_result = recurOnASTNodeInfo(that.getInfo());
        Id gapId_result = recurOnId(that.getGapId());
        List<Id> templateParams_result = recurOnListOfId(that.getTemplateParams());
        return forTemplateGapUnitArgOnly(that, info_result, gapId_result, templateParams_result);
    }


    public StaticArg recur(StaticArg that) {
        return that.accept(this);
    }

    public ASTNodeInfo recurOnASTNodeInfo(ASTNodeInfo that) {
        return that;
    }

    public Type recurOnType(Type that) {
        return that;
    }

    public IntExpr recurOnIntExpr(IntExpr that) {
        return that;
    }

    public BoolExpr recurOnBoolExpr(BoolExpr that) {
        return that;
    }

    public Op recurOnOp(Op that) {
        return that;
    }

    public DimExpr recurOnDimExpr(DimExpr that) {
        return that;
    }

    public UnitExpr recurOnUnitExpr(UnitExpr that) {
        return that;
    }

    public Id recurOnId(Id that) {
        return that;
    }

    public List<Id> recurOnListOfId(List<Id> that) {
        java.util.ArrayList<Id> accum = new java.util.ArrayList<Id>();
        boolean unchanged = true;
        for (Id elt : that) {
            Id update_elt = recurOnId(elt);
            unchanged &= (elt == update_elt);
            accum.add(update_elt);
        }
        return unchanged ? that : accum;
    }
}
