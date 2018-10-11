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

/** An abstract implementation of a visitor over StaticArg that does not return a value.
 ** This visitor implements the visitor interface with methods that each 
 ** delegate to a case representing their superclass.  At the top of this
 ** delegation tree is the method defaultCase(), which (unless overridden)
 ** is a no-op.
 **/
@SuppressWarnings("unused")
public class StaticArgAbstractVisitor_void extends StaticArgVisitorRunnable1 {
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, it is a no-op; subclasses may override this behavior.
    **/
    public void defaultCase(StaticArg that) {}

    /* Methods to visit an item. */
    public void forStaticArg(StaticArg that) {
        defaultCase(that);
    }

    public void forTypeArg(TypeArg that) {
        forStaticArg(that);
    }

    public void forIntArg(IntArg that) {
        forStaticArg(that);
    }

    public void forBoolArg(BoolArg that) {
        forStaticArg(that);
    }

    public void forOpArg(OpArg that) {
        forStaticArg(that);
    }

    public void forDimArg(DimArg that) {
        forStaticArg(that);
    }

    public void forUnitArg(UnitArg that) {
        forStaticArg(that);
    }

    public void for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that) {
        forStaticArg(that);
    }

    public void for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that) {
        forTypeArg(that);
    }

    public void for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that) {
        forIntArg(that);
    }

    public void for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that) {
        forBoolArg(that);
    }

    public void for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that) {
        forOpArg(that);
    }

    public void for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that) {
        forDimArg(that);
    }

    public void for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that) {
        forUnitArg(that);
    }

    public void for_EllipsesStaticArg(_EllipsesStaticArg that) {
        forStaticArg(that);
    }

    public void for_EllipsesTypeArg(_EllipsesTypeArg that) {
        forTypeArg(that);
    }

    public void for_EllipsesIntArg(_EllipsesIntArg that) {
        forIntArg(that);
    }

    public void for_EllipsesBoolArg(_EllipsesBoolArg that) {
        forBoolArg(that);
    }

    public void for_EllipsesOpArg(_EllipsesOpArg that) {
        forOpArg(that);
    }

    public void for_EllipsesDimArg(_EllipsesDimArg that) {
        forDimArg(that);
    }

    public void for_EllipsesUnitArg(_EllipsesUnitArg that) {
        forUnitArg(that);
    }

    public void forTemplateGapStaticArg(TemplateGapStaticArg that) {
        forStaticArg(that);
    }

    public void forTemplateGapTypeArg(TemplateGapTypeArg that) {
        forTypeArg(that);
    }

    public void forTemplateGapIntArg(TemplateGapIntArg that) {
        forIntArg(that);
    }

    public void forTemplateGapBoolArg(TemplateGapBoolArg that) {
        forBoolArg(that);
    }

    public void forTemplateGapOpArg(TemplateGapOpArg that) {
        forOpArg(that);
    }

    public void forTemplateGapDimArg(TemplateGapDimArg that) {
        forDimArg(that);
    }

    public void forTemplateGapUnitArg(TemplateGapUnitArg that) {
        forUnitArg(that);
    }

}
