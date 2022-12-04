package main.node;

public class LetNode extends Node {
    public LetNode(int level) {
        super("let", level);
    }

    @Override
    public Node getStandardizedNode() {
        int thisNodeLevel = this.getLevel();
        Node replacementNode = new OtherNode("gamma", thisNodeLevel);

        // standardize existing children
        Node equalNode = this.getChildAtIndex(0).getStandardizedNode();
        Node pNode = this.getChildAtIndex(1).getStandardizedNode();
        Node xNode = equalNode.getChildAtIndex(0).getStandardizedNode();
        Node eNode = equalNode.getChildAtIndex(1).getStandardizedNode();

        // build the standardized subtree
        Node lambdaNode = new LambdaNode(thisNodeLevel + 1);
        lambdaNode.setParent(replacementNode);
        replacementNode.addChild(lambdaNode);

        eNode.setParent(replacementNode);
        replacementNode.addChild(eNode);

        xNode.setParent(lambdaNode);
        lambdaNode.addChild(xNode);

        pNode.setParent(lambdaNode);
        lambdaNode.addChild(pNode);

        return replacementNode;
    }
}
