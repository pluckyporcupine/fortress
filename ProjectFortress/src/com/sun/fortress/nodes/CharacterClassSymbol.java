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
 * Class CharacterClassSymbol, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class CharacterClassSymbol extends SyntaxSymbol {
    private final List<CharacterSymbol> _characters;

    /**
     * Constructs a CharacterClassSymbol.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public CharacterClassSymbol(ASTNodeInfo in_info, List<CharacterSymbol> in_characters) {
        super(in_info);
        if (in_characters == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'characters' to the CharacterClassSymbol constructor was null");
        }
        _characters = in_characters;
    }

    final public List<CharacterSymbol> getCharacters() { return _characters; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forCharacterClassSymbol(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forCharacterClassSymbol(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forCharacterClassSymbol(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forCharacterClassSymbol(this);
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
            CharacterClassSymbol casted = (CharacterClassSymbol) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            List<CharacterSymbol> temp_characters = getCharacters();
            List<CharacterSymbol> casted_characters = casted.getCharacters();
            if (!(temp_characters == casted_characters || temp_characters.equals(casted_characters))) return false;
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
        List<CharacterSymbol> temp_characters = getCharacters();
        code ^= temp_characters.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected CharacterClassSymbol() {
        _characters = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected CharacterClassSymbol(ASTNodeInfo info) {
        super(info);
        _characters = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "CharacterClassSymbol", 2)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            List<CharacterSymbol> temp_characters = getCharacters();
            if (w.visitNodeField("characters", temp_characters)) {
                if (w.visitIterated(temp_characters)) {
                    int i_temp_characters = 0;
                    for (CharacterSymbol elt_temp_characters : temp_characters) {
                        if (w.visitIteratedElement(i_temp_characters, elt_temp_characters)) {
                            if (elt_temp_characters == null) w.visitNull();
                            else {
                                elt_temp_characters.walk(w);
                            }
                        }
                        i_temp_characters++;
                    }
                    w.endIterated(temp_characters, i_temp_characters);
                }
                w.endNodeField("characters", temp_characters);
            }
            w.endNode(this, "CharacterClassSymbol", 2);
        }
    }

}
