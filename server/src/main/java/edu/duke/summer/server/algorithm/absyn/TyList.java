package edu.duke.summer.server.algorithm.absyn;

public class TyList {
    String name;
    Ty type;
    TyList tail;

    public TyList(String n, Ty t, TyList tl){
        name = n;
        type = t;
        tail = tl;
    }
}
