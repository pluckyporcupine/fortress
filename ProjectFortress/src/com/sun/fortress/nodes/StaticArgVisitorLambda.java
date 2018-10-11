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

/** An abstract visitor over StaticArg that provides a lambda value method;
  * all visit methods are left unimplemented. */
@SuppressWarnings("unused")
public abstract class StaticArgVisitorLambda<RetType> implements edu.rice.cs.plt.lambda.Lambda<StaticArg, RetType>, StaticArgVisitor<RetType> {

    public RetType value(StaticArg that) {
        return that.accept(this);
    }


    /** Process an instance of TypeArg. */
    public abstract RetType forTypeArg(TypeArg that);

    /** Process an instance of IntArg. */
    public abstract RetType forIntArg(IntArg that);

    /** Process an instance of BoolArg. */
    public abstract RetType forBoolArg(BoolArg that);

    /** Process an instance of OpArg. */
    public abstract RetType forOpArg(OpArg that);

    /** Process an instance of DimArg. */
    public abstract RetType forDimArg(DimArg that);

    /** Process an instance of UnitArg. */
    public abstract RetType forUnitArg(UnitArg that);

    /** Process an instance of _SyntaxTransformationStaticArg. */
    public abstract RetType for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that);

    /** Process an instance of _SyntaxTransformationTypeArg. */
    public abstract RetType for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that);

    /** Process an instance of _SyntaxTransformationIntArg. */
    public abstract RetType for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that);

    /** Process an instance of _SyntaxTransformationBoolArg. */
    public abstract RetType for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that);

    /** Process an instance of _SyntaxTransformationOpArg. */
    public abstract RetType for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that);

    /** Process an instance of _SyntaxTransformationDimArg. */
    public abstract RetType for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that);

    /** Process an instance of _SyntaxTransformationUnitArg. */
    public abstract RetType for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that);

    /** Process an instance of _EllipsesStaticArg. */
    public abstract RetType for_EllipsesStaticArg(_EllipsesStaticArg that);

    /** Process an instance of _EllipsesTypeArg. */
    public abstract RetType for_EllipsesTypeArg(_EllipsesTypeArg that);

    /** Process an instance of _EllipsesIntArg. */
    public abstract RetType for_EllipsesIntArg(_EllipsesIntArg that);

    /** Process an instance of _EllipsesBoolArg. */
    public abstract RetType for_EllipsesBoolArg(_EllipsesBoolArg that);

    /** Process an instance of _EllipsesOpArg. */
    public abstract RetType for_EllipsesOpArg(_EllipsesOpArg that);

    /** Process an instance of _EllipsesDimArg. */
    public abstract RetType for_EllipsesDimArg(_EllipsesDimArg that);

    /** Process an instance of _EllipsesUnitArg. */
    public abstract RetType for_EllipsesUnitArg(_EllipsesUnitArg that);

    /** Process an instance of TemplateGapStaticArg. */
    public abstract RetType forTemplateGapStaticArg(TemplateGapStaticArg that);

    /** Process an instance of TemplateGapTypeArg. */
    public abstract RetType forTemplateGapTypeArg(TemplateGapTypeArg that);

    /** Process an instance of TemplateGapIntArg. */
    public abstract RetType forTemplateGapIntArg(TemplateGapIntArg that);

    /** Process an instance of TemplateGapBoolArg. */
    public abstract RetType forTemplateGapBoolArg(TemplateGapBoolArg that);

    /** Process an instance of TemplateGapOpArg. */
    public abstract RetType forTemplateGapOpArg(TemplateGapOpArg that);

    /** Process an instance of TemplateGapDimArg. */
    public abstract RetType forTemplateGapDimArg(TemplateGapDimArg that);

    /** Process an instance of TemplateGapUnitArg. */
    public abstract RetType forTemplateGapUnitArg(TemplateGapUnitArg that);
}
