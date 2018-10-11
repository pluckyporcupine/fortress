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

/** A parametric interface for visitors over StaticArg that return a value. */
@SuppressWarnings("unused")
public interface StaticArgVisitor<RetType> {

    /** Process an instance of TypeArg. */
    public RetType forTypeArg(TypeArg that);

    /** Process an instance of IntArg. */
    public RetType forIntArg(IntArg that);

    /** Process an instance of BoolArg. */
    public RetType forBoolArg(BoolArg that);

    /** Process an instance of OpArg. */
    public RetType forOpArg(OpArg that);

    /** Process an instance of DimArg. */
    public RetType forDimArg(DimArg that);

    /** Process an instance of UnitArg. */
    public RetType forUnitArg(UnitArg that);

    /** Process an instance of _SyntaxTransformationStaticArg. */
    public RetType for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that);

    /** Process an instance of _SyntaxTransformationTypeArg. */
    public RetType for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that);

    /** Process an instance of _SyntaxTransformationIntArg. */
    public RetType for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that);

    /** Process an instance of _SyntaxTransformationBoolArg. */
    public RetType for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that);

    /** Process an instance of _SyntaxTransformationOpArg. */
    public RetType for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that);

    /** Process an instance of _SyntaxTransformationDimArg. */
    public RetType for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that);

    /** Process an instance of _SyntaxTransformationUnitArg. */
    public RetType for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that);

    /** Process an instance of _EllipsesStaticArg. */
    public RetType for_EllipsesStaticArg(_EllipsesStaticArg that);

    /** Process an instance of _EllipsesTypeArg. */
    public RetType for_EllipsesTypeArg(_EllipsesTypeArg that);

    /** Process an instance of _EllipsesIntArg. */
    public RetType for_EllipsesIntArg(_EllipsesIntArg that);

    /** Process an instance of _EllipsesBoolArg. */
    public RetType for_EllipsesBoolArg(_EllipsesBoolArg that);

    /** Process an instance of _EllipsesOpArg. */
    public RetType for_EllipsesOpArg(_EllipsesOpArg that);

    /** Process an instance of _EllipsesDimArg. */
    public RetType for_EllipsesDimArg(_EllipsesDimArg that);

    /** Process an instance of _EllipsesUnitArg. */
    public RetType for_EllipsesUnitArg(_EllipsesUnitArg that);

    /** Process an instance of TemplateGapStaticArg. */
    public RetType forTemplateGapStaticArg(TemplateGapStaticArg that);

    /** Process an instance of TemplateGapTypeArg. */
    public RetType forTemplateGapTypeArg(TemplateGapTypeArg that);

    /** Process an instance of TemplateGapIntArg. */
    public RetType forTemplateGapIntArg(TemplateGapIntArg that);

    /** Process an instance of TemplateGapBoolArg. */
    public RetType forTemplateGapBoolArg(TemplateGapBoolArg that);

    /** Process an instance of TemplateGapOpArg. */
    public RetType forTemplateGapOpArg(TemplateGapOpArg that);

    /** Process an instance of TemplateGapDimArg. */
    public RetType forTemplateGapDimArg(TemplateGapDimArg that);

    /** Process an instance of TemplateGapUnitArg. */
    public RetType forTemplateGapUnitArg(TemplateGapUnitArg that);
}
