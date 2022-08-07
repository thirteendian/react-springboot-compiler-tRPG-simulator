package edu.duke.summer.server.algorithm.Types;

import edu.duke.summer.server.algorithm.Symbol.Symbol;

public class STRUCT extends Type {
   public Symbol fieldName;
   public Type fieldType;
   public STRUCT tail;
   public STRUCT(Symbol n, Type t, STRUCT x) {
       fieldName=n; fieldType=t; tail=x;
   }
   public boolean coerceTo(Type t) {
	return this==t.actual();
   }
}
   

