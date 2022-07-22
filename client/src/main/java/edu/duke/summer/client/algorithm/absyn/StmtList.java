package edu.duke.summer.client.algorithm.absyn;


import java.util.LinkedList;

public class StmtList {
    public LinkedList<Stmt> list;

    public StmtList() {list = new LinkedList<Stmt>();}
    public void addStmt(Stmt ele){
        list.add(ele);
    }


}
