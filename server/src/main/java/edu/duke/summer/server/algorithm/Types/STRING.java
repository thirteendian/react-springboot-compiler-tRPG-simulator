package edu.duke.summer.server.algorithm.Types;

public class STRING extends Type {
	public STRING(){}
	public boolean coerceTo(Type t) {return (t.actual() instanceof STRING);}
}

