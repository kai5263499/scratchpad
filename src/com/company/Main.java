package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {

    public static ArrayList walkGraph(GNode gnode) {
        ArrayList<GNode> nodes = new ArrayList<GNode>();
        nodes.add(gnode);

        GNode[] children = gnode.getChildren();
        for (int i = 0; i < children.length; i++) {
            nodes.addAll(walkGraph(children[i]));
        }

        return nodes;
    }

    private static GNode testTree = new GNode("A", new GNode[]{
                    new GNode("B", new GNode[]{
                        new GNode("E", new GNode[]{}),
                        new GNode("F", new GNode[]{})
                    }),
                    new GNode("C", new GNode[] {
                            new GNode("G", new GNode[]{}),
                            new GNode("H", new GNode[]{}),
                            new GNode("I", new GNode[]{})
                    }),
                    new GNode("D", new GNode[] {
                        new GNode("J", new GNode[]{})
                    })
    });

    public static HashMap<String,GNode> treeMap = new HashMap<String,GNode>();

    public static ArrayList<String> leaves = new ArrayList<String>();

    public static HashMap<String,String> leafParents = new HashMap<String,String>();

    public static void listToMap(GNode gnode) {
        treeMap.put(gnode.getName(), gnode);

        GNode[] children = gnode.getChildren();

        if(children.length > 0) {
            for (int i = 0; i < children.length; i++) {
                leafParents.put(children[i].getName(), gnode.getName());
                listToMap(children[i]);
            }
        } else {
            leaves.add(gnode.getName());
        }
    }

    public static ArrayList<GNode> nameToPath(String name) {
        ArrayList<GNode> segment = new ArrayList<GNode>();

        GNode gnode = treeMap.get(name);
        segment.add(gnode);

        String parent = leafParents.get(name);
        if(parent != null) {
            segment.addAll(nameToPath(parent));
        }

        return segment;
    }

    public static ArrayList<ArrayList<GNode>> paths(GNode gnode) {
        ArrayList<ArrayList<GNode>> tree = new ArrayList<ArrayList<GNode>>();

        listToMap(gnode);

        for(String leafName: leaves) {
            ArrayList<GNode> segment = nameToPath(leafName);
            Collections.reverse(segment);
            tree.add(segment);
        }

        return tree;
    }

    public static void main(String[] args) {
        System.out.println("walkGraph");
        System.out.println(walkGraph(testTree));

        System.out.println("paths");
        System.out.println(paths(testTree));
    }
}
