package com.sun.fortress.nodes;


public class LosslessStringWalker extends TreeWalker {
  
  protected final TabPrintWriter _out;
  
  public LosslessStringWalker(java.io.Writer writer, int tabSize) {
    _out = new TabPrintWriter(writer, tabSize);
  }
  
  protected void openingDelim(char c) {
    _out.print(c);
    _out.indent();
  }

  protected void closingDelim(char c) {
    _out.unindent();
    _out.startLine(""+c);
  }

  public boolean visitNode(Object node, java.lang.String type, int fields) {
    _out.print(type);
    openingDelim(':');
    return true;
  }
  public boolean visitNodeField(java.lang.String name, Object value) {
    // Consider special case eliding single field
    _out.startLine(name);
    _out.print(" = ");
    return true;
  }
  public void endNode(Object node, java.lang.String type, int fields) {
    _out.unindent();
  }
  
  public boolean visitIterated(Object iterable) {
    openingDelim('{');
    return true;
  }
  public boolean visitIteratedElement(int index, Object element) {
    _out.startLine("* ");
    return true;
  }
  public void endIterated(Object iterable, int size) {
    if (size > 0) { _out.startLine(); }
    _out.unindent();
    _out.print("}");
  }

  public boolean visitNonEmptyOption(Object option) {
    openingDelim('(');
    _out.startLine();
    return true;
  }
  public void endNonEmptyOption(Object option) {
    closingDelim(')');
  }
  public void visitEmptyOption(Object option) { _out.print('~'); }
  
  public boolean visitTuple(Object tuple, int arity) {
    openingDelim('(');
    return true;
  }
  public boolean visitTupleElement(int index, Object element) {
    if (index > 0) { _out.startLine(", "); }
    return true;
  }
  public void endTuple(Object tuple, int arity) { closingDelim(')'); }
  
  public void visitString(java.lang.String s) {
    _out.print('"');
    _out.printEscaped(s);
    _out.print('"');
  }
  
  public void visitUnknownObject(Object o) {
    printSerialized(o);
    _out.print(' ');
    _out.printEscaped(o);
  }
  
  public void visitNull() { _out.print('_'); }
  
  public void visitBoolean(boolean b) { _out.print(b); }
  public void visitByte(byte b) { _out.print(b); }
  public void visitShort(short s) { _out.print(s); }
  public void visitInt(int i) { _out.print(i); }
  public void visitLong(long l) { _out.print(l); }

  public void visitChar(char c) {
    _out.print('\'');
    _out.printEscaped(java.lang.Character.valueOf(c));
    _out.print('\'');
  }
  
  public void visitFloat(float f) { _out.print(java.lang.Float.toHexString(f)); }
  public void visitDouble(double d) { _out.print(java.lang.Double.toHexString(d)); }

  /**
   * Print the serialized form of the given object as a hexadecimal number.
   * @throws RuntimeException  If the object is not serializable.
   */
  protected void printSerialized(Object o) {
    java.io.ByteArrayOutputStream bs = new java.io.ByteArrayOutputStream();
    try {
      java.io.ObjectOutputStream objOut = new java.io.ObjectOutputStream(bs);
      try { objOut.writeObject(o); }
      finally { objOut.close(); }
    }
    catch (java.io.IOException e) { throw new java.lang.RuntimeException(e); }

    for (byte b : bs.toByteArray()) {
      int unsigned = ((int)b) & 0xff;
      java.lang.String num = java.lang.Integer.toHexString(unsigned);
      if (num.length() == 1) _out.print("0");
      _out.print(num);
    }
  }

}