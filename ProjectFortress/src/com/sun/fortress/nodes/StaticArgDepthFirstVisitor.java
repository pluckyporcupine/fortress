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

/** A parametric abstract implementation of a visitor over StaticArg that returns a value.
 ** This visitor implements the visitor interface with methods that
 ** first visit children, and then call forCASEOnly(), passing in
 ** the values of the visits of the children. (CASE is replaced by the case name.)
 ** By default, each of forCASEOnly delegates to a more general case; at the
 ** top of this delegation tree is defaultCase(), which (unless overridden)
 ** throws an exception.
 **/
@SuppressWarnings({"unused", "unchecked"})
public abstract class StaticArgDepthFirstVisitor<RetType> extends StaticArgVisitorLambda<RetType> {
    private String templateErrorMessage = "Please use TemplateDepthFirstVisitor if you intend to visit template gaps, if not then a template gap survived longer than its expected life time.";
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, an exception is thrown; subclasses may override this behavior.
     * @throws IllegalArgumentException
    **/
    public RetType defaultCase(StaticArg that) {
        throw new IllegalArgumentException("Visitor " + getClass().getName() + " does not support visiting values of type " + that.getClass().getName());
    }

    public RetType defaultTemplateGap(TemplateGap t){
        throw new RuntimeException(this.templateErrorMessage);
    }

    public RetType defaultTransformationNode(_SyntaxTransformation that){
        throw new RuntimeException("Override defaultTransformationNode to support syntax transformations");
    }

    public RetType defaultEllipsesNode(_Ellipses that){
        throw new RuntimeException("Override defaultEllipsesNode to support ellipses");
    }

    /* Methods to handle a node after recursion. */
    public RetType forStaticArgOnly(StaticArg that) {
        return defaultCase(that);
    }

    public RetType forTypeArgOnly(TypeArg that) {
        return forStaticArgOnly(that);
    }

    public RetType forIntArgOnly(IntArg that) {
        return forStaticArgOnly(that);
    }

    public RetType forBoolArgOnly(BoolArg that) {
        return forStaticArgOnly(that);
    }

    public RetType forOpArgOnly(OpArg that) {
        return forStaticArgOnly(that);
    }

    public RetType forDimArgOnly(DimArg that) {
        return forStaticArgOnly(that);
    }

    public RetType forUnitArgOnly(UnitArg that) {
        return forStaticArgOnly(that);
    }

    public RetType for_SyntaxTransformationStaticArgOnly(_SyntaxTransformationStaticArg that) {
        return forStaticArgOnly(that);
    }

    public RetType for_SyntaxTransformationTypeArgOnly(_SyntaxTransformationTypeArg that) {
        return forTypeArgOnly(that);
    }

    public RetType for_SyntaxTransformationIntArgOnly(_SyntaxTransformationIntArg that) {
        return forIntArgOnly(that);
    }

    public RetType for_SyntaxTransformationBoolArgOnly(_SyntaxTransformationBoolArg that) {
        return forBoolArgOnly(that);
    }

    public RetType for_SyntaxTransformationOpArgOnly(_SyntaxTransformationOpArg that) {
        return forOpArgOnly(that);
    }

    public RetType for_SyntaxTransformationDimArgOnly(_SyntaxTransformationDimArg that) {
        return forDimArgOnly(that);
    }

    public RetType for_SyntaxTransformationUnitArgOnly(_SyntaxTransformationUnitArg that) {
        return forUnitArgOnly(that);
    }


    /** Methods to recur on each child. */
    public RetType forTypeArg(TypeArg that) {
        return forTypeArgOnly(that);
    }

    public RetType forIntArg(IntArg that) {
        return forIntArgOnly(that);
    }

    public RetType forBoolArg(BoolArg that) {
        return forBoolArgOnly(that);
    }

    public RetType forOpArg(OpArg that) {
        return forOpArgOnly(that);
    }

    public RetType forDimArg(DimArg that) {
        return forDimArgOnly(that);
    }

    public RetType forUnitArg(UnitArg that) {
        return forUnitArgOnly(that);
    }

    public RetType for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that) {
        return for_SyntaxTransformationStaticArgOnly(that);
    }

    public RetType for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that) {
        return for_SyntaxTransformationTypeArgOnly(that);
    }

    public RetType for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that) {
        return for_SyntaxTransformationIntArgOnly(that);
    }

    public RetType for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that) {
        return for_SyntaxTransformationBoolArgOnly(that);
    }

    public RetType for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that) {
        return for_SyntaxTransformationOpArgOnly(that);
    }

    public RetType for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that) {
        return for_SyntaxTransformationDimArgOnly(that);
    }

    public RetType for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that) {
        return for_SyntaxTransformationUnitArgOnly(that);
    }

    public RetType for_EllipsesStaticArg(_EllipsesStaticArg that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesTypeArg(_EllipsesTypeArg that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesIntArg(_EllipsesIntArg that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesBoolArg(_EllipsesBoolArg that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesOpArg(_EllipsesOpArg that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesDimArg(_EllipsesDimArg that) {
        return defaultEllipsesNode(that);
    }

    public RetType for_EllipsesUnitArg(_EllipsesUnitArg that) {
        return defaultEllipsesNode(that);
    }

    public RetType forTemplateGapStaticArg(TemplateGapStaticArg that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapTypeArg(TemplateGapTypeArg that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapIntArg(TemplateGapIntArg that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapBoolArg(TemplateGapBoolArg that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapOpArg(TemplateGapOpArg that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapDimArg(TemplateGapDimArg that) {
        return defaultTemplateGap(that);
    }

    public RetType forTemplateGapUnitArg(TemplateGapUnitArg that) {
        return defaultTemplateGap(that);
    }


    public RetType recur(StaticArg that) {
        return that.accept(this);
    }

}
