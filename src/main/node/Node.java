package node;

import java.util.ArrayList;

public abstract class Node {
    private final int level;
    private final String name;
    private final ArrayList<Node> children;
    private Node parent;

    public Node(String name, int level) {
        this.name = name;
        this.level = level;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public int getChildrenCount() {
        return this.children.size();
    }

    public Node getChildAtIndex(int index) {
        return this.children.get(index);
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void traverse() {
        // prints the ast output by traversing the tree
        for (int i = 0; i < this.level; i++) {
            System.out.print(".");
        }
        System.out.println(this.name);

        // traverse the children
        for (Node child : this.children) {
            child.traverse();
        }
    }

}
