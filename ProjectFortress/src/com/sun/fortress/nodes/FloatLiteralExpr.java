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
 * Class FloatLiteralExpr, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class FloatLiteralExpr extends NumberLiteralExpr {
    private final BigInteger _intPart;
    private final BigInteger _numerator;
    private final int _denomBase;
    private final int _denomPower;

    /**
     * Constructs a FloatLiteralExpr.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public FloatLiteralExpr(ExprInfo in_info, String in_text, BigInteger in_intPart, BigInteger in_numerator, int in_denomBase, int in_denomPower) {
        super(in_info, in_text);
        if (in_intPart == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'intPart' to the FloatLiteralExpr constructor was null");
        }
        _intPart = in_intPart;
        if (in_numerator == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'numerator' to the FloatLiteralExpr constructor was null");
        }
        _numerator = in_numerator;
        _denomBase = in_denomBase;
        _denomPower = in_denomPower;
    }

    final public BigInteger getIntPart() { return _intPart; }
    final public BigInteger getNumerator() { return _numerator; }
    final public int getDenomBase() { return _denomBase; }
    final public int getDenomPower() { return _denomPower; }

    public <RetType> RetType accept(ExprVisitor<RetType> visitor) {
        return visitor.forFloatLiteralExpr(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forFloatLiteralExpr(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forFloatLiteralExpr(this);
    }

    public void accept(ExprVisitor_void visitor) {
        visitor.forFloatLiteralExpr(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forFloatLiteralExpr(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forFloatLiteralExpr(this);
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
            FloatLiteralExpr casted = (FloatLiteralExpr) obj;
            ExprInfo temp_info = getInfo();
            ExprInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            BigInteger temp_intPart = getIntPart();
            BigInteger casted_intPart = casted.getIntPart();
            if (!(temp_intPart == casted_intPart || temp_intPart.equals(casted_intPart))) return false;
            BigInteger temp_numerator = getNumerator();
            BigInteger casted_numerator = casted.getNumerator();
            if (!(temp_numerator == casted_numerator || temp_numerator.equals(casted_numerator))) return false;
            int temp_denomBase = getDenomBase();
            int casted_denomBase = casted.getDenomBase();
            if (!(temp_denomBase == casted_denomBase)) return false;
            int temp_denomPower = getDenomPower();
            int casted_denomPower = casted.getDenomPower();
            if (!(temp_denomPower == casted_denomPower)) return false;
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
        BigInteger temp_intPart = getIntPart();
        code ^= temp_intPart.hashCode();
        BigInteger temp_numerator = getNumerator();
        code ^= temp_numerator.hashCode();
        int temp_denomBase = getDenomBase();
        code ^= temp_denomBase;
        int temp_denomPower = getDenomPower();
        code ^= temp_denomPower;
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected FloatLiteralExpr() {
        _intPart = null;
        _numerator = null;
        _denomBase = 0;
        _denomPower = 0;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected FloatLiteralExpr(ExprInfo info) {
        super(info);
        _intPart = null;
        _numerator = null;
        _denomBase = 0;
        _denomPower = 0;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "FloatLiteralExpr", 6)) {
            ExprInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            String temp_text = getText();
            if (w.visitNodeField("text", temp_text)) {
                w.visitString(temp_text);
                w.endNodeField("text", temp_text);
            }
            BigInteger temp_intPart = getIntPart();
            if (w.visitNodeField("intPart", temp_intPart)) {
                w.visitUnknownObject(temp_intPart);
                w.endNodeField("intPart", temp_intPart);
            }
            BigInteger temp_numerator = getNumerator();
            if (w.visitNodeField("numerator", temp_numerator)) {
                w.visitUnknownObject(temp_numerator);
                w.endNodeField("numerator", temp_numerator);
            }
            int temp_denomBase = getDenomBase();
            if (w.visitNodeField("denomBase", temp_denomBase)) {
                w.visitInt(temp_denomBase);
                w.endNodeField("denomBase", temp_denomBase);
            }
            int temp_denomPower = getDenomPower();
            if (w.visitNodeField("denomPower", temp_denomPower)) {
                w.visitInt(temp_denomPower);
                w.endNodeField("denomPower", temp_denomPower);
            }
            w.endNode(this, "FloatLiteralExpr", 6);
        }
    }

}
