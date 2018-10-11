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
 * Class MatrixType, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class MatrixType extends AbbreviatedType implements OutAfterTypeChecking {
    private final List<ExtentRange> _dimensions;

    /**
     * Constructs a MatrixType.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public MatrixType(TypeInfo in_info, Type in_elemType, List<ExtentRange> in_dimensions) {
        super(in_info, in_elemType);
        if (in_dimensions == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'dimensions' to the MatrixType constructor was null");
        }
        _dimensions = in_dimensions;
    }

    final public List<ExtentRange> getDimensions() { return _dimensions; }

    public <RetType> RetType accept(TypeVisitor<RetType> visitor) {
        return visitor.forMatrixType(this);
    }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forMatrixType(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forMatrixType(this);
    }

    public void accept(TypeVisitor_void visitor) {
        visitor.forMatrixType(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forMatrixType(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forMatrixType(this);
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
            MatrixType casted = (MatrixType) obj;
            TypeInfo temp_info = getInfo();
            TypeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Type temp_elemType = getElemType();
            Type casted_elemType = casted.getElemType();
            if (!(temp_elemType == casted_elemType || temp_elemType.equals(casted_elemType))) return false;
            List<ExtentRange> temp_dimensions = getDimensions();
            List<ExtentRange> casted_dimensions = casted.getDimensions();
            if (!(temp_dimensions == casted_dimensions || temp_dimensions.equals(casted_dimensions))) return false;
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
        TypeInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        Type temp_elemType = getElemType();
        code ^= temp_elemType.hashCode();
        List<ExtentRange> temp_dimensions = getDimensions();
        code ^= temp_dimensions.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected MatrixType() {
        _dimensions = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected MatrixType(TypeInfo info) {
        super(info);
        _dimensions = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "MatrixType", 3)) {
            TypeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Type temp_elemType = getElemType();
            if (w.visitNodeField("elemType", temp_elemType)) {
                temp_elemType.walk(w);
                w.endNodeField("elemType", temp_elemType);
            }
            List<ExtentRange> temp_dimensions = getDimensions();
            if (w.visitNodeField("dimensions", temp_dimensions)) {
                if (w.visitIterated(temp_dimensions)) {
                    int i_temp_dimensions = 0;
                    for (ExtentRange elt_temp_dimensions : temp_dimensions) {
                        if (w.visitIteratedElement(i_temp_dimensions, elt_temp_dimensions)) {
                            if (elt_temp_dimensions == null) w.visitNull();
                            else {
                                elt_temp_dimensions.walk(w);
                            }
                        }
                        i_temp_dimensions++;
                    }
                    w.endIterated(temp_dimensions, i_temp_dimensions);
                }
                w.endNodeField("dimensions", temp_dimensions);
            }
            w.endNode(this, "MatrixType", 3);
        }
    }

}
