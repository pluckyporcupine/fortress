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

/** An interface for visitors over StaticArg that do not return a value. */
@SuppressWarnings("unused")
public interface StaticArgVisitor_void {

    /** Process an instance of TypeArg. */
    public void forTypeArg(TypeArg that);

    /** Process an instance of IntArg. */
    public void forIntArg(IntArg that);

    /** Process an instance of BoolArg. */
    public void forBoolArg(BoolArg that);

    /** Process an instance of OpArg. */
    public void forOpArg(OpArg that);

    /** Process an instance of DimArg. */
    public void forDimArg(DimArg that);

    /** Process an instance of UnitArg. */
    public void forUnitArg(UnitArg that);

    /** Process an instance of _SyntaxTransformationStaticArg. */
    public void for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that);

    /** Process an instance of _SyntaxTransformationTypeArg. */
    public void for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that);

    /** Process an instance of _SyntaxTransformationIntArg. */
    public void for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that);

    /** Process an instance of _SyntaxTransformationBoolArg. */
    public void for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that);

    /** Process an instance of _SyntaxTransformationOpArg. */
    public void for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that);

    /** Process an instance of _SyntaxTransformationDimArg. */
    public void for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that);

    /** Process an instance of _SyntaxTransformationUnitArg. */
    public void for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that);

    /** Process an instance of _EllipsesStaticArg. */
    public void for_EllipsesStaticArg(_EllipsesStaticArg that);

    /** Process an instance of _EllipsesTypeArg. */
    public void for_EllipsesTypeArg(_EllipsesTypeArg that);

    /** Process an instance of _EllipsesIntArg. */
    public void for_EllipsesIntArg(_EllipsesIntArg that);

    /** Process an instance of _EllipsesBoolArg. */
    public void for_EllipsesBoolArg(_EllipsesBoolArg that);

    /** Process an instance of _EllipsesOpArg. */
    public void for_EllipsesOpArg(_EllipsesOpArg that);

    /** Process an instance of _EllipsesDimArg. */
    public void for_EllipsesDimArg(_EllipsesDimArg that);

    /** Process an instance of _EllipsesUnitArg. */
    public void for_EllipsesUnitArg(_EllipsesUnitArg that);

    /** Process an instance of TemplateGapStaticArg. */
    public void forTemplateGapStaticArg(TemplateGapStaticArg that);

    /** Process an instance of TemplateGapTypeArg. */
    public void forTemplateGapTypeArg(TemplateGapTypeArg that);

    /** Process an instance of TemplateGapIntArg. */
    public void forTemplateGapIntArg(TemplateGapIntArg that);

    /** Process an instance of TemplateGapBoolArg. */
    public void forTemplateGapBoolArg(TemplateGapBoolArg that);

    /** Process an instance of TemplateGapOpArg. */
    public void forTemplateGapOpArg(TemplateGapOpArg that);

    /** Process an instance of TemplateGapDimArg. */
    public void forTemplateGapDimArg(TemplateGapDimArg that);

    /** Process an instance of TemplateGapUnitArg. */
    public void forTemplateGapUnitArg(TemplateGapUnitArg that);
}
