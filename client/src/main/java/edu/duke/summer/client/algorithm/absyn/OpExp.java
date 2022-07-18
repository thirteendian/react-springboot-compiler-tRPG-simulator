package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.value.*;

import java.util.HashMap;
import java.util.Random;

public class OpExp extends Exp {
   public Exp left, right;
   public int oper;
   public OpExp(int p, Exp l, int o, Exp r) {pos=p; left=l; oper=o; right=r;}
   public final static int PLUS=0, MINUS=1, MUL=2, DIV=3,
		    EQ=4, NE=5, LT=6, LE=7, GT=8, GE=9;

    public void setLeft(Exp left) {
        this.left = left;
    }

    public void setRight(Exp right) {
        this.right = right;
    }


    public Value getValue(Value left, Value right) {
        if((left instanceof IntValue) && (right instanceof IntValue)) {
            Integer value = 1;
            if(oper == 0){
                value = ((IntValue) left).getValue() + ((IntValue) right).getValue();
            }else if (oper == 1) {
                value = ((IntValue) left).getValue() - ((IntValue) right).getValue();
            }else if (oper == 2) {
                value = ((IntValue) left).getValue() * ((IntValue) right).getValue();
            }else if (oper == 3) {
                value = ((IntValue) left).getValue() / ((IntValue) right).getValue();
            }else if (oper == 4) {
                if((((IntValue) left).getValue() == ((IntValue) right).getValue())){
                    value = 1;
                }else{
                    value = 0;
                }
            }else if (oper == 5) {
                if ((((IntValue) left).getValue() != ((IntValue) right).getValue())) {
                    value = 1;
                } else {
                    value = 0;
                }
            }else if (oper == 6) {
                if ((((IntValue) left).getValue() < ((IntValue) right).getValue())) {
                    value = 1;
                } else {
                    value = 0;
                }
            }else if (oper == 7) {
                if ((((IntValue) left).getValue() <= ((IntValue) right).getValue())) {
                    value = 1;
                } else {
                    value = 0;
                }
            }else if (oper == 8) {
                if ((((IntValue) left).getValue() > ((IntValue) right).getValue())) {
                    value = 1;
                } else {
                    value = 0;
                }
            }else if (oper == 9) {
                if ((((IntValue) left).getValue() >= ((IntValue) right).getValue())) {
                    value = 1;
                } else {
                    value = 0;
                }
            }
            IntValue res = new IntValue(value);
            return res;
        } else if((left instanceof StringValue) && (right instanceof StringValue)){
            if(oper == 0){
                StringBuilder res = new StringBuilder();
                res.append(((StringValue) left).getValue() + ((StringValue) right).getValue());
            }
        }
        throw new IllegalArgumentException("Require Integer or String type for Addition");
    }

    @Override
    public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
        Value left = this.left.eval(vars, randNumGen, info, state);
        Value right = this.right.eval(vars, randNumGen, info, state);
        return getValue(left, right);
    }
}
