package com.sun.fortress.interpreter.evaluator.types;

import java.lang.Comparable;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class FTypeArrayList extends ArrayList<FType> implements Comparable
{

  Comparator<FType> compareElements = new Comparator<FType>() {
      public int compare(FType o1, FType o2) {
          /* Deal appropriately with null, which for convenience
           * we consider to be less than everything else. */
          if (o1 == null && o2 == null) return 0;
          if (o1 == null) return -1;
          if (o2 == null) return 1;
          return o1.compareTo(o2);
      }
  };

  public int compare(List<FType> arg0, List<FType> arg1) {
      int l0 = arg0.size();
      int l1 = arg1.size();
      if (l0 < l1) return -1;
      if (l0 > l1) return 1;
      for (int i = 0; i < l0; i++) {
          int c = compareElements.compare(arg0.get(i), arg1.get(i));
          if (c != 0) return c;
      }
      return 0;
  }

  @Override
  public int compareTo(Object o) {
    return 0;
  }

  //public final static ListComparer<String> stringListComparer = new ListComparer<String>();
}
