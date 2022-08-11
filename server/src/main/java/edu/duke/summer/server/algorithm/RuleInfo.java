package edu.duke.summer.server.algorithm;

import edu.duke.summer.server.algorithm.Symbol.Symbol;
import edu.duke.summer.server.algorithm.absyn.FieldList;

import java.util.ArrayList;
import java.util.HashMap;

public class RuleInfo {
    HashMap<String, TypeInfo> types = new HashMap<>();
    HashMap<String, FuncInfo> funcs = new HashMap<>();



    public RuleInfo(){
        TypeInfo i = new TypeInfo(Symbol.symbol("int"));
        TypeInfo s = new TypeInfo(Symbol.symbol("string"));
        TypeInfo b = new TypeInfo(Symbol.symbol("boolean"));
        TypeInfo v = new TypeInfo(Symbol.symbol("void"));
        types.put("int", i);
        types.put("string", s);
        types.put("boolean", b);
        types.put("void", v);
        FieldList outputParams = new FieldList(-1, Symbol.symbol("msg"), Symbol.symbol("string"), null);
        FuncInfo outputInfo = new FuncInfo("output", outputParams);
        funcs.put("output", outputInfo);
        FieldList rollStr =  new FieldList(-1, Symbol.symbol("rollStr"), Symbol.symbol("string"), null);
        FuncInfo rollInfo = new FuncInfo("roll", rollStr);
        funcs.put("roll", rollInfo);
        FieldList secondParam =  new FieldList(-1, Symbol.symbol("msg"), Symbol.symbol("string"), null);
        FieldList firstParam =  new FieldList(-1, Symbol.symbol("object"), Symbol.symbol("object"), secondParam);
        FuncInfo oneUserOptionInfo = new FuncInfo("oneUserOption", firstParam);
        funcs.put("oneUserOption", oneUserOptionInfo);
        FieldList msg =  new FieldList(-1, Symbol.symbol("msg"), Symbol.symbol("string"), null);
        FuncInfo userOptionInfo = new FuncInfo("userOption", msg);
        funcs.put("userOption", userOptionInfo);

    }
    public void setTypes(HashMap<String, TypeInfo> types) {
        this.types = types;
    }

    public HashMap<String, TypeInfo> getTypes() {
        return types;
    }

    public HashMap<String, FuncInfo> getFuncs() {
        return funcs;
    }

    public void addTypes(TypeInfo newType){
        types.put(newType.getTypeId().toString(), newType);
    }
    public void addFuncs(FuncInfo funcInfo){funcs.put(funcInfo.getFuncName(), funcInfo);}
    public void printInfo(){
        System.out.println("-------printInfo-------");
        for(String s : types.keySet()){
            TypeInfo info = types.get(s);
            info.printTyInfo();
        }
    }
}
