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
 * Class GeneratorClause, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class GeneratorClause extends AbstractNode {
    private final List<Id> _bind;
    private final Expr _init;

    /**
     * Constructs a GeneratorClause.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public GeneratorClause(ASTNodeInfo in_info, List<Id> in_bind, Expr in_init) {
        super(in_info);
        if (in_bind == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'bind' to the GeneratorClause constructor was null");
        }
        _bind = in_bind;
        if (in_init == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'init' to the GeneratorClause constructor was null");
        }
        _init = in_init;
    }

    final public List<Id> getBind() { return _bind; }
    final public Expr getInit() { return _init; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forGeneratorClause(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forGeneratorClause(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forGeneratorClause(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forGeneratorClause(this);
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
            GeneratorClause casted = (GeneratorClause) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<Id> temp_bind = getBind();
            List<Id> casted_bind = casted.getBind();
            if (!(temp_bind == casted_bind || temp_bind.equals(casted_bind))) return false;
            Expr temp_init = getInit();
            Expr casted_init = casted.getInit();
            if (!(temp_init == casted_init || temp_init.equals(casted_init))) return false;
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
        ASTNodeInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        List<Id> temp_bind = getBind();
        code ^= temp_bind.hashCode();
        Expr temp_init = getInit();
        code ^= temp_init.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected GeneratorClause() {
        _bind = null;
        _init = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected GeneratorClause(ASTNodeInfo info) {
        super(info);
        _bind = null;
        _init = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "GeneratorClause", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<Id> temp_bind = getBind();
            if (w.visitNodeField("bind", temp_bind)) {
                if (w.visitIterated(temp_bind)) {
                    int i_temp_bind = 0;
                    for (Id elt_temp_bind : temp_bind) {
                        if (w.visitIteratedElement(i_temp_bind, elt_temp_bind)) {
                            if (elt_temp_bind == null) w.visitNull();
                            else {
                                elt_temp_bind.walk(w);
                            }
                        }
                        i_temp_bind++;
                    }
                    w.endIterated(temp_bind, i_temp_bind);
                }
                w.endNodeField("bind", temp_bind);
            }
            Expr temp_init = getInit();
            if (w.visitNodeField("init", temp_init)) {
                temp_init.walk(w);
                w.endNodeField("init", temp_init);
            }
            w.endNode(this, "GeneratorClause", 3);
        }
    }

}
