package main.node;

import java.util.ArrayList;

public class AndNode extends Node {
    public AndNode(int level) {
        super("and", level);
    }

    @Override
    public Node getStandardizedNode() {
        int thisNodeLevel = this.getLevel();
        Node replacementNode = new OtherNode("=", thisNodeLevel);

        // standardize the existing child nodes
        ArrayList<Node> equalNodes = new ArrayList<>();
        for (int i = 0; i < this.getChildrenCount(); i++) {
            Node child = this.getChildAtIndex(i).getStandardizedNode();
            equalNodes.add(child.getStandardizedNode());
        }

        // build the standardized subtree
        Node commaNode = new OtherNode(",", thisNodeLevel + 1);
        commaNode.setParent(replacementNode);
        replacementNode.addChild(commaNode);
        Node tauNode = new OtherNode("tau", thisNodeLevel + 1);
        tauNode.setParent(replacementNode);
        replacementNode.addChild(tauNode);
        for (Node equalNode : equalNodes) {
            Node xNode = equalNode.getChildAtIndex(0).getStandardizedNode();
            Node eNode = equalNode.getChildAtIndex(1).getStandardizedNode();
            commaNode.addChild(xNode);
            xNode.setParent(commaNode);
            tauNode.addChild(eNode);
            eNode.setParent(tauNode);
        }

        return replacementNode;
    }
}
