package edu.duke.summer.client.algorithm.astnode;

import java.util.HashMap;
import java.util.Random;

public class AssignTypeNode extends ExpNode{
    String newTypeId;
    String referTypeId;

    public AssignTypeNode(String setNewTypeId, String setReferTypeId){
        this.newTypeId = setNewTypeId;
        this.referTypeId = setReferTypeId;
    }

    @Override
    public Integer eval(HashMap<String, Integer> vars, Random randNumGen) {
        return null;
    }

    @Override
    public void save(RuleInfo info) {
        HashMap<String, TypeDefNode> types = info.getTypes();
        if(types.containsKey(referTypeId)){
            TypeDefNode referTypeNode = types.get(referTypeId);
            TypeDefNode newTypeNode = new TypeDefNode();
            newTypeNode.setTypeId(newTypeId);
            newTypeNode.assignType(referTypeNode);
            types.put(newTypeId, newTypeNode);
            info.setTypes(types);
        }else{
            throw new IllegalArgumentException("Using non-existent type");
        }
    }
}
