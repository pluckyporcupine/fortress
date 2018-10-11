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

@SuppressWarnings("unused")
public interface Node extends HasAt {

    public <RetType> RetType accept(NodeVisitor<RetType> visitor);

    public void accept(NodeVisitor_void visitor);

    public int generateHashCode();
    /** Generate a human-readable representation that can be deserialized. */
    public java.lang.String serialize();
    /** Generate a human-readable representation that can be deserialized. */
    public void serialize(java.io.Writer writer);
    public void walk(TreeWalker w);
}
