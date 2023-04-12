package org.jakub;

public class Node {
    public Node(int value) {
        this.value = value;
    }
    public Node(int value, Node left, Node right) {
        this(value);
        this.left = left;
        this.right = right;
    }
    final private int value;
    private Node left;
    private Node right;

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public boolean checkSameness(Node other){
        if(other == null || getValue() != other.getValue()) {
            return false;
        }
        if(getLeft() == null){
            return other.getLeft() == null;
        }
        if(getRight() == null) {
            return other.getRight() == null;
        }
        return getLeft().checkSameness(other.getLeft()) && getRight().checkSameness(other.getRight());
    }

    public int maxEdgeLength(){
        if(getLeft() == null && getRight() == null) {
            return 0;
        }
        if(getLeft() == null) {
            return getRight().maxEdgeLength() + 1;
        }
        if(getRight() == null) {
            return getLeft().maxEdgeLength() + 1;
        }
        return Math.max(getLeft().maxEdgeLength(), getRight().maxEdgeLength()) + 1;
    }

    public int numberOfLeafs() {
        if(getLeft() == null && getRight() == null) {
            return 1;
        }
        if(getLeft() == null) {
            return getRight().numberOfLeafs();
        }
        if(getRight() == null) {
            return getLeft().numberOfLeafs();
        }
        return getLeft().numberOfLeafs() + getRight().numberOfLeafs();
    }
}
