package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.value.Value;

abstract public class Ty extends Absyn {
    public abstract String getKey();
    public abstract String getName();
    public abstract Ty getElem();
    public abstract Value getInitValue();

}
