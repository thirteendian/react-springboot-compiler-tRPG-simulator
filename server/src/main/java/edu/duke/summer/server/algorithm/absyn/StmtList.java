package edu.duke.summer.server.algorithm.absyn;


import java.util.LinkedList;

public class StmtList {
    public LinkedList<Stmt> list;

    public StmtList() {list = new LinkedList<Stmt>();}
    public void addStmt(Stmt ele){
        list.add(ele);
    }


}
