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

/** A parametric abstract implementation of a visitor over StaticArg that return a value.
 ** This visitor implements the visitor interface with methods that each 
 ** delegate to a case representing their superclass.  At the top of this
 ** delegation tree is the method defaultCase(), which (unless overridden)
 ** throws an exception.
 **/
@SuppressWarnings("unused")
public abstract class StaticArgAbstractVisitor<RetType>  extends StaticArgVisitorLambda<RetType> {
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, an exception is thrown; subclasses may override this behavior.
     * @throws IllegalArgumentException
    **/
    public RetType defaultCase(StaticArg that) {
        throw new IllegalArgumentException("Visitor " + getClass().getName() + " does not support visiting values of type " + that.getClass().getName());
    }

    /* Methods to visit an item. */
    public RetType forStaticArg(StaticArg that) {
        return defaultCase(that);
    }

    public RetType forTypeArg(TypeArg that) {
        return forStaticArg(that);
    }

    public RetType forIntArg(IntArg that) {
        return forStaticArg(that);
    }

    public RetType forBoolArg(BoolArg that) {
        return forStaticArg(that);
    }

    public RetType forOpArg(OpArg that) {
        return forStaticArg(that);
    }

    public RetType forDimArg(DimArg that) {
        return forStaticArg(that);
    }

    public RetType forUnitArg(UnitArg that) {
        return forStaticArg(that);
    }

    public RetType for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that) {
        return forStaticArg(that);
    }

    public RetType for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that) {
        return forTypeArg(that);
    }

    public RetType for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that) {
        return forIntArg(that);
    }

    public RetType for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that) {
        return forBoolArg(that);
    }

    public RetType for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that) {
        return forOpArg(that);
    }

    public RetType for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that) {
        return forDimArg(that);
    }

    public RetType for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that) {
        return forUnitArg(that);
    }

    public RetType for_EllipsesStaticArg(_EllipsesStaticArg that) {
        return forStaticArg(that);
    }

    public RetType for_EllipsesTypeArg(_EllipsesTypeArg that) {
        return forTypeArg(that);
    }

    public RetType for_EllipsesIntArg(_EllipsesIntArg that) {
        return forIntArg(that);
    }

    public RetType for_EllipsesBoolArg(_EllipsesBoolArg that) {
        return forBoolArg(that);
    }

    public RetType for_EllipsesOpArg(_EllipsesOpArg that) {
        return forOpArg(that);
    }

    public RetType for_EllipsesDimArg(_EllipsesDimArg that) {
        return forDimArg(that);
    }

    public RetType for_EllipsesUnitArg(_EllipsesUnitArg that) {
        return forUnitArg(that);
    }

    public RetType forTemplateGapStaticArg(TemplateGapStaticArg that) {
        return forStaticArg(that);
    }

    public RetType forTemplateGapTypeArg(TemplateGapTypeArg that) {
        return forTypeArg(that);
    }

    public RetType forTemplateGapIntArg(TemplateGapIntArg that) {
        return forIntArg(that);
    }

    public RetType forTemplateGapBoolArg(TemplateGapBoolArg that) {
        return forBoolArg(that);
    }

    public RetType forTemplateGapOpArg(TemplateGapOpArg that) {
        return forOpArg(that);
    }

    public RetType forTemplateGapDimArg(TemplateGapDimArg that) {
        return forDimArg(that);
    }

    public RetType forTemplateGapUnitArg(TemplateGapUnitArg that) {
        return forUnitArg(that);
    }


}
