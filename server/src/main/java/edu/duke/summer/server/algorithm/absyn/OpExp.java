package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.*;

import java.util.HashMap;
import java.util.Random;

public class OpExp extends Exp {
   public Exp left, right;
   public int oper;
   public OpExp(int p, Exp l, int o, Exp r) {pos=p; left=l; oper=o; right=r;}
   public final static int PLUS=0, MINUS=1, MUL=2, DIV=3,
		    EQ=4, NE=5, LT=6, LE=7, GT=8, GE=9, AND=10, OR=11, MOD=12;

    public void setLeft(Exp left) {
        this.left = left;
    }

    public void setRight(Exp right) {
        this.right = right;
    }


    public Value getValue(Value left, Value right) {
        if((left instanceof IntValue) && (right instanceof IntValue)) {
            Value value;
            if(oper == 0){
                int i = ((IntValue) left).getValue() + ((IntValue) right).getValue();
                value = new IntValue(i);
            }else if (oper == 1) {
                int i  = ((IntValue) left).getValue() - ((IntValue) right).getValue();
                value = new IntValue(i);
            }else if (oper == 2) {
                int i = ((IntValue) left).getValue() * ((IntValue) right).getValue();
                value = new IntValue(i);
            }else if (oper == 3) {
                int i = ((IntValue) left).getValue() / ((IntValue) right).getValue();
                value = new IntValue(i);
            }else if (oper == 4) {
                if((((IntValue) left).getValue() == ((IntValue) right).getValue())){
                    value = new BooleanValue(true);
                }else{
                    value = new BooleanValue(false);
                }
            }else if (oper == 5) {
                if ((((IntValue) left).getValue() != ((IntValue) right).getValue())) {
                    value = new BooleanValue(true);
                } else {
                    value = new BooleanValue(false);
                }
            }else if (oper == 6) {
                if ((((IntValue) left).getValue() < ((IntValue) right).getValue())) {
                    value = new BooleanValue(true);
                } else {
                    value = new BooleanValue(false);
                }
            }else if (oper == 7) {
                if ((((IntValue) left).getValue() <= ((IntValue) right).getValue())) {
                    value = new BooleanValue(true);
                } else {
                    value = new BooleanValue(false);
                }
            }else if (oper == 8) {
                if ((((IntValue) left).getValue() > ((IntValue) right).getValue())) {
                    value = new BooleanValue(true);
                } else {
                    value = new BooleanValue(false);
                }
            }else if (oper == 9) {
                if ((((IntValue) left).getValue() >= ((IntValue) right).getValue())) {
                    value = new BooleanValue(true);
                } else {
                    value = new BooleanValue(false);
                }
            }else if (oper == 12) {
                Integer res = (((IntValue) left).getValue() % ((IntValue) right).getValue());
                value = new IntValue(res);
            }else{
                throw new IllegalArgumentException("Invalid OpExp operation!");
            }
            return value;
        } else if((left instanceof StringValue) && (right instanceof StringValue)){
            if(oper == 0){
                StringBuilder res = new StringBuilder();
                res.append(((StringValue) left).getValue() + ((StringValue) right).getValue());
                return new StringValue(res.toString());
            }
        }else if((left instanceof StringValue) || (right instanceof StringValue)) {
            if ((oper == 0) && (left instanceof StringValue)) {
                StringBuilder res = new StringBuilder();
                res.append(((StringValue) left).getValue() + right.getPrintInfo());
                return new StringValue(res.toString());
            }else if ((oper == 0) && (right instanceof StringValue)) {
                StringBuilder res = new StringBuilder();
                res.append((left).getPrintInfo() + ((StringValue) right).getValue());
                return new StringValue(res.toString());
            }
        }else if((left instanceof BooleanValue) || (right instanceof BooleanValue)){
            if(oper == 10){
                return new BooleanValue(((BooleanValue)left).getValue() && ((BooleanValue)right).getValue());
            }else if (oper == 11){
                return new BooleanValue(((BooleanValue)left).getValue() || ((BooleanValue)right).getValue());
            }
        }
        throw new IllegalArgumentException("Require Integer or String type for Addition");
    }

    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        Value left = this.left.eval(varEntry, randNumGen, info, state);
        Value right = this.right.eval(varEntry, randNumGen, info, state);
        return getValue(left, right);
    }
}
