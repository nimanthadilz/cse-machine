package main.node;

public class WhereNode extends Node {
    public WhereNode(int level) {
        super("where", level);
    }

    @Override
    public Node getStandardizedNode() {
        int thisNodeLevel = this.getLevel();
        Node replacementNode = new OtherNode("gamma", thisNodeLevel);

        // standardize existing children nodes
        Node pNode = this.getChildAtIndex(0).getStandardizedNode();
        Node equalNode = this.getChildAtIndex(1).getStandardizedNode();
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
