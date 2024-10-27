package com.ben.aoc.tree;

import java.util.LinkedList;
import java.util.List;

public class Node<T> {
    protected T data;
    protected Node<T> parent;
    protected List<Node<T>> children;

    public Node(T data){
        this.data = data;
        this.children = new LinkedList<>();
    }

    public Node<T> addChild(T child){
        Node<T> childNode = new Node<>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }

    public Node<T> getParent(){
        return parent;
    }

    public T getData(){
        return data;
    }

}
