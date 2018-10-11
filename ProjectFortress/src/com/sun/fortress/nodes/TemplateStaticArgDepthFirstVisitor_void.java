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

/** An abstract implementation of a visitor over StaticArg including template gaps that does not return a value.
 ** This visitor implements the visitor interface with methods that 
 ** first call forCASEDoFirst(), second visit the children, and finally 
 ** call forCASEOnly().  (CASE is replaced by the case name.)
 ** By default, each of forCASEDoFirst and forCASEOnly delegates
 ** to a more general case.  At the top of this delegation tree are
 ** defaultDoFirst() and defaultCase(), respectively, which (unless
 ** overridden) are no-ops.
 **/
@SuppressWarnings(value={"unused"})
public class TemplateStaticArgDepthFirstVisitor_void extends StaticArgVisitorRunnable1 {
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, it is a no-op; subclasses may override this behavior.
    **/
    public void defaultCase(StaticArg that) {}

    /**
     * This method is run for all DoFirst cases that are not handled elsewhere.
     * By default, it is a no-op; subclasses may override this behavior.
    **/
    public void defaultDoFirst(StaticArg that) {}

    /* Methods to handle a node before recursion. */
    public void forStaticArgDoFirst(StaticArg that) {
        defaultDoFirst(that);
    }

    public void forTypeArgDoFirst(TypeArg that) {
        forStaticArgDoFirst(that);
    }

    public void forIntArgDoFirst(IntArg that) {
        forStaticArgDoFirst(that);
    }

    public void forBoolArgDoFirst(BoolArg that) {
        forStaticArgDoFirst(that);
    }

    public void forOpArgDoFirst(OpArg that) {
        forStaticArgDoFirst(that);
    }

    public void forDimArgDoFirst(DimArg that) {
        forStaticArgDoFirst(that);
    }

    public void forUnitArgDoFirst(UnitArg that) {
        forStaticArgDoFirst(that);
    }

    public void for_SyntaxTransformationStaticArgDoFirst(_SyntaxTransformationStaticArg that) {
        forStaticArgDoFirst(that);
    }

    public void for_SyntaxTransformationTypeArgDoFirst(_SyntaxTransformationTypeArg that) {
        forTypeArgDoFirst(that);
    }

    public void for_SyntaxTransformationIntArgDoFirst(_SyntaxTransformationIntArg that) {
        forIntArgDoFirst(that);
    }

    public void for_SyntaxTransformationBoolArgDoFirst(_SyntaxTransformationBoolArg that) {
        forBoolArgDoFirst(that);
    }

    public void for_SyntaxTransformationOpArgDoFirst(_SyntaxTransformationOpArg that) {
        forOpArgDoFirst(that);
    }

    public void for_SyntaxTransformationDimArgDoFirst(_SyntaxTransformationDimArg that) {
        forDimArgDoFirst(that);
    }

    public void for_SyntaxTransformationUnitArgDoFirst(_SyntaxTransformationUnitArg that) {
        forUnitArgDoFirst(that);
    }

    public void for_EllipsesStaticArgDoFirst(_EllipsesStaticArg that) {
        forStaticArgDoFirst(that);
    }

    public void for_EllipsesTypeArgDoFirst(_EllipsesTypeArg that) {
        forTypeArgDoFirst(that);
    }

    public void for_EllipsesIntArgDoFirst(_EllipsesIntArg that) {
        forIntArgDoFirst(that);
    }

    public void for_EllipsesBoolArgDoFirst(_EllipsesBoolArg that) {
        forBoolArgDoFirst(that);
    }

    public void for_EllipsesOpArgDoFirst(_EllipsesOpArg that) {
        forOpArgDoFirst(that);
    }

    public void for_EllipsesDimArgDoFirst(_EllipsesDimArg that) {
        forDimArgDoFirst(that);
    }

    public void for_EllipsesUnitArgDoFirst(_EllipsesUnitArg that) {
        forUnitArgDoFirst(that);
    }

    public void forTemplateGapStaticArgDoFirst(TemplateGapStaticArg that) {
        forStaticArgDoFirst(that);
    }

    public void forTemplateGapTypeArgDoFirst(TemplateGapTypeArg that) {
        forTypeArgDoFirst(that);
    }

    public void forTemplateGapIntArgDoFirst(TemplateGapIntArg that) {
        forIntArgDoFirst(that);
    }

    public void forTemplateGapBoolArgDoFirst(TemplateGapBoolArg that) {
        forBoolArgDoFirst(that);
    }

    public void forTemplateGapOpArgDoFirst(TemplateGapOpArg that) {
        forOpArgDoFirst(that);
    }

    public void forTemplateGapDimArgDoFirst(TemplateGapDimArg that) {
        forDimArgDoFirst(that);
    }

    public void forTemplateGapUnitArgDoFirst(TemplateGapUnitArg that) {
        forUnitArgDoFirst(that);
    }

    /* Methods to handle a node after recursion. */
    public void forStaticArgOnly(StaticArg that) {
        defaultCase(that);
    }

    public void forTypeArgOnly(TypeArg that) {
        forStaticArgOnly(that);
    }

    public void forIntArgOnly(IntArg that) {
        forStaticArgOnly(that);
    }

    public void forBoolArgOnly(BoolArg that) {
        forStaticArgOnly(that);
    }

    public void forOpArgOnly(OpArg that) {
        forStaticArgOnly(that);
    }

    public void forDimArgOnly(DimArg that) {
        forStaticArgOnly(that);
    }

    public void forUnitArgOnly(UnitArg that) {
        forStaticArgOnly(that);
    }

    public void for_SyntaxTransformationStaticArgOnly(_SyntaxTransformationStaticArg that) {
        forStaticArgOnly(that);
    }

    public void for_SyntaxTransformationTypeArgOnly(_SyntaxTransformationTypeArg that) {
        forTypeArgOnly(that);
    }

    public void for_SyntaxTransformationIntArgOnly(_SyntaxTransformationIntArg that) {
        forIntArgOnly(that);
    }

    public void for_SyntaxTransformationBoolArgOnly(_SyntaxTransformationBoolArg that) {
        forBoolArgOnly(that);
    }

    public void for_SyntaxTransformationOpArgOnly(_SyntaxTransformationOpArg that) {
        forOpArgOnly(that);
    }

    public void for_SyntaxTransformationDimArgOnly(_SyntaxTransformationDimArg that) {
        forDimArgOnly(that);
    }

    public void for_SyntaxTransformationUnitArgOnly(_SyntaxTransformationUnitArg that) {
        forUnitArgOnly(that);
    }

    public void for_EllipsesStaticArgOnly(_EllipsesStaticArg that) {
        forStaticArgOnly(that);
    }

    public void for_EllipsesTypeArgOnly(_EllipsesTypeArg that) {
        forTypeArgOnly(that);
    }

    public void for_EllipsesIntArgOnly(_EllipsesIntArg that) {
        forIntArgOnly(that);
    }

    public void for_EllipsesBoolArgOnly(_EllipsesBoolArg that) {
        forBoolArgOnly(that);
    }

    public void for_EllipsesOpArgOnly(_EllipsesOpArg that) {
        forOpArgOnly(that);
    }

    public void for_EllipsesDimArgOnly(_EllipsesDimArg that) {
        forDimArgOnly(that);
    }

    public void for_EllipsesUnitArgOnly(_EllipsesUnitArg that) {
        forUnitArgOnly(that);
    }

    public void forTemplateGapStaticArgOnly(TemplateGapStaticArg that) {
        forStaticArgOnly(that);
    }

    public void forTemplateGapTypeArgOnly(TemplateGapTypeArg that) {
        forTypeArgOnly(that);
    }

    public void forTemplateGapIntArgOnly(TemplateGapIntArg that) {
        forIntArgOnly(that);
    }

    public void forTemplateGapBoolArgOnly(TemplateGapBoolArg that) {
        forBoolArgOnly(that);
    }

    public void forTemplateGapOpArgOnly(TemplateGapOpArg that) {
        forOpArgOnly(that);
    }

    public void forTemplateGapDimArgOnly(TemplateGapDimArg that) {
        forDimArgOnly(that);
    }

    public void forTemplateGapUnitArgOnly(TemplateGapUnitArg that) {
        forUnitArgOnly(that);
    }

    /* Methods to recur on each child. */
    public void forTypeArg(TypeArg that) {
        forTypeArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnType(that.getTypeArg());
        forTypeArgOnly(that);
    }

    public void forIntArg(IntArg that) {
        forIntArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnIntExpr(that.getIntVal());
        forIntArgOnly(that);
    }

    public void forBoolArg(BoolArg that) {
        forBoolArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnBoolExpr(that.getBoolArg());
        forBoolArgOnly(that);
    }

    public void forOpArg(OpArg that) {
        forOpArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnOp(that.getId());
        forOpArgOnly(that);
    }

    public void forDimArg(DimArg that) {
        forDimArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnDimExpr(that.getDimArg());
        forDimArgOnly(that);
    }

    public void forUnitArg(UnitArg that) {
        forUnitArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnUnitExpr(that.getUnitArg());
        forUnitArgOnly(that);
    }

    public void for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that) {
        for_SyntaxTransformationStaticArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationStaticArgOnly(that);
    }

    public void for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that) {
        for_SyntaxTransformationTypeArgDoFirst(that);
        recurOnType(that.getTypeArg());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationTypeArgOnly(that);
    }

    public void for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that) {
        for_SyntaxTransformationIntArgDoFirst(that);
        recurOnIntExpr(that.getIntVal());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationIntArgOnly(that);
    }

    public void for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that) {
        for_SyntaxTransformationBoolArgDoFirst(that);
        recurOnBoolExpr(that.getBoolArg());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationBoolArgOnly(that);
    }

    public void for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that) {
        for_SyntaxTransformationOpArgDoFirst(that);
        recurOnOp(that.getId());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationOpArgOnly(that);
    }

    public void for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that) {
        for_SyntaxTransformationDimArgDoFirst(that);
        recurOnDimExpr(that.getDimArg());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationDimArgOnly(that);
    }

    public void for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that) {
        for_SyntaxTransformationUnitArgDoFirst(that);
        recurOnUnitExpr(that.getUnitArg());
        recurOnASTNodeInfo(that.getInfo());
        for_SyntaxTransformationUnitArgOnly(that);
    }

    public void for_EllipsesStaticArg(_EllipsesStaticArg that) {
        for_EllipsesStaticArgDoFirst(that);
        for_EllipsesStaticArgOnly(that);
    }

    public void for_EllipsesTypeArg(_EllipsesTypeArg that) {
        for_EllipsesTypeArgDoFirst(that);
        for_EllipsesTypeArgOnly(that);
    }

    public void for_EllipsesIntArg(_EllipsesIntArg that) {
        for_EllipsesIntArgDoFirst(that);
        for_EllipsesIntArgOnly(that);
    }

    public void for_EllipsesBoolArg(_EllipsesBoolArg that) {
        for_EllipsesBoolArgDoFirst(that);
        for_EllipsesBoolArgOnly(that);
    }

    public void for_EllipsesOpArg(_EllipsesOpArg that) {
        for_EllipsesOpArgDoFirst(that);
        for_EllipsesOpArgOnly(that);
    }

    public void for_EllipsesDimArg(_EllipsesDimArg that) {
        for_EllipsesDimArgDoFirst(that);
        for_EllipsesDimArgOnly(that);
    }

    public void for_EllipsesUnitArg(_EllipsesUnitArg that) {
        for_EllipsesUnitArgDoFirst(that);
        for_EllipsesUnitArgOnly(that);
    }

    public void forTemplateGapStaticArg(TemplateGapStaticArg that) {
        forTemplateGapStaticArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapStaticArgOnly(that);
    }

    public void forTemplateGapTypeArg(TemplateGapTypeArg that) {
        forTemplateGapTypeArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapTypeArgOnly(that);
    }

    public void forTemplateGapIntArg(TemplateGapIntArg that) {
        forTemplateGapIntArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapIntArgOnly(that);
    }

    public void forTemplateGapBoolArg(TemplateGapBoolArg that) {
        forTemplateGapBoolArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapBoolArgOnly(that);
    }

    public void forTemplateGapOpArg(TemplateGapOpArg that) {
        forTemplateGapOpArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapOpArgOnly(that);
    }

    public void forTemplateGapDimArg(TemplateGapDimArg that) {
        forTemplateGapDimArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapDimArgOnly(that);
    }

    public void forTemplateGapUnitArg(TemplateGapUnitArg that) {
        forTemplateGapUnitArgDoFirst(that);
        recurOnASTNodeInfo(that.getInfo());
        recurOnId(that.getGapId());
        recurOnListOfId(that.getTemplateParams());
        forTemplateGapUnitArgOnly(that);
    }


    public void recur(StaticArg that) {
        that.accept(this);
    }

    public void recurOnASTNodeInfo(ASTNodeInfo that) {
    }

    public void recurOnType(Type that) {
    }

    public void recurOnIntExpr(IntExpr that) {
    }

    public void recurOnBoolExpr(BoolExpr that) {
    }

    public void recurOnOp(Op that) {
    }

    public void recurOnDimExpr(DimExpr that) {
    }

    public void recurOnUnitExpr(UnitExpr that) {
    }

    public void recurOnId(Id that) {
    }

    public void recurOnListOfId(List<Id> that) {
        for (Id elt : that) {
            recurOnId(elt);
        }
    }
}
