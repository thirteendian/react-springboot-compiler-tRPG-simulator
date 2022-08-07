package edu.duke.summer.server.algorithm.absyn;


abstract public class Ty extends Absyn {
    public abstract String getKey();
    public abstract String getName();
    public abstract Ty getElem();

}
