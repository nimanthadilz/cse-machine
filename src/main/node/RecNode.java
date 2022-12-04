package main.node;

public class RecNode extends Node {
    public RecNode(int level) {
        super("rec", level);
    }

    @Override
    public Node getStandardizedNode() {
        int thisNodeLevel = this.getLevel();
        Node replacementNode = new OtherNode("=", thisNodeLevel);

        // Standardize existing nodes
        Node equalNode = this.getChildAtIndex(0).getStandardizedNode();
        Node xNode1 = equalNode.getChildAtIndex(0).getStandardizedNode();
        Node xNode2 = new OtherNode(xNode1.getName(), thisNodeLevel + 3);
        Node eNode = equalNode.getChildAtIndex(1).getStandardizedNode();

        // build the standardized subtree
        xNode1.setParent(replacementNode);
        replacementNode.addChild(xNode1);

        Node gammaNode = new OtherNode("gamma", thisNodeLevel + 1);
        gammaNode.setParent(replacementNode);
        replacementNode.addChild(gammaNode);

        Node yStarNode = new OtherNode("Y", thisNodeLevel + 2);
        yStarNode.setParent(gammaNode);
        gammaNode.addChild(yStarNode);

        Node lambdaNode = new LambdaNode(thisNodeLevel + 2);
        lambdaNode.setParent(gammaNode);
        gammaNode.addChild(lambdaNode);

        xNode2.setParent(lambdaNode);
        lambdaNode.addChild(xNode2);

        eNode.setParent(lambdaNode);
        lambdaNode.addChild(eNode);

        return replacementNode;
    }
}
