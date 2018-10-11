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
 * Class Level, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class Level extends InfoNode {
    private final int _level;
    private final Object __object;

    /**
     * Constructs a Level.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public Level(int in_level, Object in__object) {
        super();
        _level = in_level;
        if (in__object == null) {
            throw new java.lang.IllegalArgumentException("Parameter '_object' to the Level constructor was null");
        }
        __object = in__object;
    }

    final public int getLevel() { return _level; }
    final public Object get_object() { return __object; }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forLevel(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forLevel(this);
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
            Level casted = (Level) obj;
            int temp_level = getLevel();
            int casted_level = casted.getLevel();
            if (!(temp_level == casted_level)) return false;
            Object temp__object = get_object();
            Object casted__object = casted.get_object();
            if (!(temp__object == casted__object || temp__object.equals(casted__object))) return false;
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
        int temp_level = getLevel();
        code ^= temp_level;
        Object temp__object = get_object();
        code ^= temp__object.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected Level() {
        _level = 0;
        __object = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "Level", 2)) {
            int temp_level = getLevel();
            if (w.visitNodeField("level", temp_level)) {
                w.visitInt(temp_level);
                w.endNodeField("level", temp_level);
            }
            Object temp__object = get_object();
            if (w.visitNodeField("_object", temp__object)) {
                w.visitUnknownObject(temp__object);
                w.endNodeField("_object", temp__object);
            }
            w.endNode(this, "Level", 2);
        }
    }

}
