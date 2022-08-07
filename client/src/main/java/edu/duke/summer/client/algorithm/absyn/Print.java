package edu.duke.summer.client.algorithm.absyn;

public class Print {

  java.io.PrintStream out;

  public Print(java.io.PrintStream o) {out=o;}

  void indent(int d) {
      for(int i=0; i<d; i++)
            out.print(' ');
  }

  void say(String s) {
            out.print(s);
  }

  void say(int i) {
    Integer local = i;
    out.print(local.toString());
  }

  void say(boolean b) {
    Boolean local = b;
    out.print(local.toString());
  }

  void sayln(String s) {
	say(s); say("\n");
  }

  void prVar(SimpleVar v, int d) {
    say("SimpleVar("); say(v.name.toString()); say(")");
  }

  void prVar(FieldVar v, int d) {
    sayln("FieldVar(");
    prVar(v.var, d+1); sayln(",");
    indent(d+1); say(v.field.toString()); say(")");
  }

  void prVar(SubscriptVar v, int d) {
    sayln("SubscriptVar(");
    prVar(v.var, d+1); sayln(",");
    prExp(v.index, d+1); say(")");
  }

  /* Print A_var types. Indent d spaces. */
  void prVar(Var v, int d) {
    indent(d);
    if (v instanceof SimpleVar) prVar((SimpleVar) v, d);
    else if (v instanceof FieldVar) prVar((FieldVar) v, d);
    else if (v instanceof SubscriptVar) prVar((SubscriptVar) v, d);
    else throw new Error("Print.prVar");
  }

  void prExp(OpExp e, int d) {
    sayln("OpExp(");
    indent(d+1);
    switch(e.oper) {
    case OpExp.PLUS: say("PLUS"); break;
    case OpExp.MINUS: say("MINUS"); break;
    case OpExp.MUL: say("MUL"); break;
    case OpExp.DIV: say("DIV"); break;
    case OpExp.EQ: say("EQ"); break;
    case OpExp.NE: say("NE"); break;
    case OpExp.LT: say("LT"); break;
    case OpExp.LE: say("LE"); break;
    case OpExp.GT: say("GT"); break;
    case OpExp.GE: say("GE"); break;
    default:
      throw new Error("Print.prExp.OpExp");
    }
    sayln(",");
    prExp(e.left, d+1); sayln(",");
    prExp(e.right, d+1); say(")");
  }

  void prExp(VarExp e, int d) {
    sayln("varExp("); prVar(e.var, d+1);
    say(")");
  }

  void prExp(NilExp e, int d) {
    say("NilExp()");
  }

  void prExp(IntExp e, int d) {
    say("IntExp("); say(e.value); say(")");
  }

  void prExp(StringExp e, int d) {
    say("StringExp("); say(e.value); say(")");
  }

  void prExp(CallExp e, int d) {
    say("CallExp("); say(e.func.toString()); sayln(",");
    prExplist(e.args, d+1); say(")");
  }

  void prExp(StructExp e, int d) {
    say("StructExp("); say(e.typ.toString());  sayln(",");
    prFieldExpList(e.fields, d+1); say(")");
  }

  void prExp(SeqExp e, int d) {
    sayln("SeqExp(");
    prExplist(e.list, d+1); say(")");
  }

  void prExp(AssignExp e, int d) {
    sayln("AssignExp(");
    prVar(e.var, d+1); sayln(",");
    prExp(e.exp, d+1); say(")");
  }

  void prStmt(IfStmt e, int d) {
    sayln("IfStmt(");
    prExp(e.test, d+1); sayln(",");
    prStmt(e.thenclause, d+1);
    if (e.elseclause!=null) { /* else is optional */
      sayln(",");
      prStmt(e.elseclause, d+1);
    }
    say(")");
  }

  void prStmt(BreakStmt e, int d) {
    sayln("BreakStmt");
  }

  void prStmt(WhileStmt e, int d) {
    sayln("WhileExp(");
    prExp(e.test, d+1); sayln(",");
    prStmt(e.body, d+1); sayln(")");
  }

  void prStmt(ForStmt e, int d) {
//    sayln("ForExp(");
//    indent(d+1); prDec(e.var, d+1); sayln(",");
//    prExp(e.scope, d+1); sayln(",");
//    prStmt(e.body, d+1); say(")");
  }
  void prExp(ScopeExp e, int d) {
    say("LetExp("); sayln("");
    prDecList(e.decs, d+1); sayln(",");
    prExp(e.body, d+1); say(")");
  }

  void prExp(ArrayExp e, int d) {
    say("ArrayExp("); say(e.typ.toString()); sayln(",");
    prExp(e.size, d+1); sayln(",");
    prExp(e.init, d+1); say(")");
  }
  public void prStmt(Stmt e, int d) {
    if (e instanceof IfStmt) prStmt((IfStmt) e, d);
    else if (e instanceof WhileStmt) prStmt((WhileStmt) e, d);
    else if (e instanceof ForStmt) prStmt((ForStmt) e, d);
    else if (e instanceof BreakStmt) prStmt((BreakStmt) e, d);
  }
  /* Print Exp class types. Indent d spaces. */
  public void prExp(Exp e, int d) {
    indent(d);
    if (e instanceof OpExp) prExp((OpExp)e, d);
    else if (e instanceof VarExp) prExp((VarExp) e, d);
    else if (e instanceof NilExp) prExp((NilExp) e, d);
    else if (e instanceof IntExp) prExp((IntExp) e, d);
    else if (e instanceof StringExp) prExp((StringExp) e, d);
    else if (e instanceof CallExp) prExp((CallExp) e, d);
    else if (e instanceof StructExp) prExp((StructExp) e, d);
    else if (e instanceof SeqExp) prExp((SeqExp) e, d);
    else if (e instanceof AssignExp) prExp((AssignExp) e, d);
    else if (e instanceof ScopeExp) prExp((ScopeExp) e, d);
    else if (e instanceof ArrayExp) prExp((ArrayExp) e, d);
    else throw new Error("Print.prExp");
  }

  void prDec(FunctionDec d, int i) {
    say("FunctionDec(");
    if (d!=null) {
      sayln(d.name.toString());
      prFieldlist(d.params, i+1); sayln(",");
      if (d.result!=null) {
	indent(i+1); sayln(d.result.toString());
      }
      prStmt(d.body, i+1); sayln(",");
      indent(i+1);
    }
    say(")");
  }

  void prDec(VarDec d, int i) {
    say("VarDec("); say(d.name.toString()); sayln(",");
    if (d.typ!=null) {
      indent(i+1); say(d.typ.toString());  sayln(",");
    }
    prExp(d.init, i+1); sayln(",");
    indent(i+1); say(d.escape); say(")");
  }

  void prDec(TypeDec d, int i) {
    if (d!=null) {
      say("TypeDec("); say(d.typeId.toString()); sayln(",");
      //d.printTypeInfo();
//      if (d.next!=null) {
//	say(","); prDec(d.next, i+1);
//      }
      say(")");
    }
  }

  void prDec(Dec d, int i) {
    indent(i);
    if (d instanceof FunctionDec) prDec((FunctionDec) d, i);
    else if (d instanceof VarDec) prDec((VarDec) d, i);
    else if (d instanceof TypeDec) prDec((TypeDec) d, i);
    else throw new Error("Print.prDec");
  }

  void prTy(NameTy t, int i) {
    say("NameTy("); say(t.name.toString()); say(")");
  }

  void prTy(FieldsTy t, int i) {
    sayln("RecordTy(");
    prFieldlist(t.fields, i+1); say(")");
  }

  void prTy(ArrayTy t, int i) {
    say("ArrayTy("); say(t.getName().toString()); say(")");
  }

  void prTy(Ty t, int i) {
    if (t!=null) {
      indent(i);
      if (t instanceof NameTy) prTy((NameTy) t, i);
      else if (t instanceof FieldsTy) prTy((FieldsTy) t, i);
      else if (t instanceof ArrayTy) prTy((ArrayTy) t, i);
      else throw new Error("Print.prTy");
    }
  }

  void prFieldlist(FieldList f, int d) {
    indent(d);
    say("Fieldlist(");
    if (f!=null) {
      sayln("");
      indent(d+1); say(f.name.toString()); sayln("");
      indent(d+1); say(f.typ.toString()); sayln(",");
      indent(d+1); say(f.escape);
      sayln(",");
      prFieldlist(f.tail, d+1);
    }
    say(")");
  }

  void prExplist(ExpList e, int d) {
    indent(d);
    say("ExpList(");
    if (e!=null) {
      sayln("");
      prExp(e.head, d+1);
      if (e.tail != null) {
	sayln(","); prExplist(e.tail, d+1);
      }
    }
    say(")");
  }

  void prDecList(DecList v, int d) {
    indent(d);
    say("DecList(");
    if (v!=null) {
      sayln("");
      prDec(v.head, d+1); sayln(",");
      prDecList(v.tail, d+1);
    }
    say(")");
  }

  void prFieldExpList(FieldExpList f, int d) {
    indent(d);
    say("FieldExpList(");
    if (f!=null) {
      sayln("");
      say(f.name.toString()); sayln(",");
      prExp(f.init, d+1); sayln(",");
      prFieldExpList(f.tail, d+1);
    }
    say(")");
  }
}



