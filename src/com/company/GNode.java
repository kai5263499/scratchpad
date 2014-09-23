package com.company;

/**
 * Created by wes on 9/23/14.
 */
public class GNode {
    public String name;
    public GNode[] children;

    public String getName() {
        return name;
    }
    public GNode[] getChildren() {
        return children;
    }

    public GNode(String name, GNode[] children) {
        this.name = name;
        this.children = children;
    }

    public String toString()  {
        return getName();
    }
}
