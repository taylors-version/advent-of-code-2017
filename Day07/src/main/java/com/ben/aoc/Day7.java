package com.ben.aoc;

import com.ben.aoc.tree.Node;

import java.util.*;


public class Day7 {
    ArrayList<String> nodes = new ArrayList<>();
    Map<Node<String>, Integer> nodeWeight = new HashMap<>();

    public String puzzle1(List<String> input) {
        nodes = new ArrayList<String>(input);
        nodes.sort(Comparator.comparingInt(String::length));

        String[] leafs = nodes.get(input.size() - 1).split(", ");
        String parent = leafs[leafs.length - 1];
        String leaf = parent;

        while(parent != null){
            leaf = parent;
            parent = getParent(leaf);
        }

        return leaf;
    }

    public long puzzle2(List<String> input) {
        int result = 0;

        String root = puzzle1(input);
        Node<String> rootNode = parseRootNode(input.stream().filter(s -> s.startsWith(root)).findFirst().get());
        Queue<Node<String>> nodesToProcess = new ArrayDeque<>(rootNode.getChildren());
        while(!nodesToProcess.isEmpty()){
            Node<String> node = nodesToProcess.remove();
            String nodeString = input.stream().filter(s -> s.startsWith(node.getData())).findFirst().get();
            nodesToProcess.addAll(parseNode(nodeString, node).getChildren());
        }

        for(Node<String> node : rootNode.getChildren()){
            System.out.println(node.getData() + ": " + nodeWeight(node));
            if(node.getData().equals("dwggjb")){
                System.out.println();
                for(Node<String> n : node.getChildren()){
                    System.out.println(n.getData() + ": " + nodeWeight(n));
                    if(n.getData().equals("wknuyhc")){
                        System.out.println();
                        for(Node<String> n1 : n.getChildren()){
                            System.out.println(n1.getData() + ": " + nodeWeight(n1));
                            if(n1.getData().equals("egbzge")){
                                System.out.println();
                                for(Node<String> n2 : n1.getChildren()){
                                    System.out.println(n2.getData() + ": " + nodeWeight(n2));

                                }
                            }
                        }
                    }
                }
            }
        }


        return result;
    }

    private String getParent(String leaf){
        for(String node: nodes){
            String[] children = node.split("->");
            if(children.length > 1 && children[1].contains(leaf)){
                return node.split(" ")[0];
            }
        }

        return null;
    }

    private Node<String> parseRootNode(String nodeString){
        String[] split = nodeString.split(" ");
        Node<String> node = new Node<>(split[0]);
        if(split.length > 2){
            for(int i = 3; i < split.length; i++){
                node.addChild(split[i].replace(",", ""));
            }
        }
        String weight = split[1];
        nodeWeight.put(node, Integer.parseInt(weight.substring(1, weight.length() - 1)));
        return node;
    }

    private Node<String> parseNode(String nodeString, Node<String> node){
        String[] split = nodeString.split(" ");
        if(split.length > 2){
            for(int i = 3; i < split.length; i++){
                node.addChild(split[i].replace(",", ""));
            }
        }
        String weight = split[1];
        nodeWeight.put(node, Integer.parseInt(weight.substring(1, weight.length() - 1)));
        return node;
    }

    private int nodeWeight(Node<String> node){
        int sum = nodeWeight.get(node);

        if(node.getChildren() != null){
            for(Node<String> child : node.getChildren()){
                sum += nodeWeight(child);
            }
        }

        return sum;
    }

}
