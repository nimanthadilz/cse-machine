package main.node;

public class InfixNode extends Node {
    public InfixNode(int level) {
        super("@", level);
    }

    @Override
    public Node getStandardizedNode() {
        int thisNodeLevel = this.getLevel();
        Node replacementNode = new OtherNode("gamma", thisNodeLevel);

        // Standardize the existing nodes
        Node e1 = this.getChildAtIndex(0).getStandardizedNode();
        Node n = this.getChildAtIndex(1).getStandardizedNode();
        Node e2 = this.getChildAtIndex(2).getStandardizedNode();

        // build the standardized subtree
        Node gammaNode = new OtherNode("gamma", thisNodeLevel + 1);
        gammaNode.setParent(replacementNode);
        replacementNode.addChild(gammaNode);

        e2.setParent(replacementNode);
        replacementNode.addChild(e2);

        n.setParent(gammaNode);
        gammaNode.addChild(n);

        e1.setParent(gammaNode);
        gammaNode.addChild(e1);

        return replacementNode;
    }
}
