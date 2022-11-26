package node;

public class WithinNode extends Node {
    public WithinNode(int level) {
        super("within", level);
    }

    @Override
    public Node getStandardizedNode() {
        int thisNodeLevel = this.getLevel();
        Node replacementNode = new OtherNode("=", thisNodeLevel);

        // standardize the existing children
        Node leftEqualNode = this.getChildAtIndex(0).getStandardizedNode();
        Node rightEqualNode = this.getChildAtIndex(1).getStandardizedNode();
        Node x1 = leftEqualNode.getChildAtIndex(0).getStandardizedNode();
        Node e1 = leftEqualNode.getChildAtIndex(1).getStandardizedNode();
        Node x2 = rightEqualNode.getChildAtIndex(0).getStandardizedNode();
        Node e2 = rightEqualNode.getChildAtIndex(1).getStandardizedNode();

        // build the standardized subtree
        x2.setParent(replacementNode);
        replacementNode.addChild(x2);

        Node gammaNode = new OtherNode("gamma", thisNodeLevel + 1);
        gammaNode.setParent(replacementNode);
        replacementNode.addChild(gammaNode);

        Node lambdaNode = new LambdaNode(thisNodeLevel + 2);
        lambdaNode.setParent(gammaNode);
        gammaNode.addChild(lambdaNode);

        e1.setParent(gammaNode);
        gammaNode.addChild(e1);

        x1.setParent(lambdaNode);
        lambdaNode.addChild(x1);

        e2.setParent(lambdaNode);
        lambdaNode.addChild(e2);

        return replacementNode;
    }
}
