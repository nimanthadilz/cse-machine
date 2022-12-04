package main.node;

public class LambdaNode extends Node {
    public LambdaNode(int level) {
        super("lambda", level);
    }

    @Override
    public Node getStandardizedNode() {
        int thisNodeLevel = this.getLevel();
        Node replacementNode = new LambdaNode(thisNodeLevel);
        int childrenCount = this.getChildrenCount();
        Node currentNode = replacementNode;
        if (childrenCount > 2) {
            for (int i = 0; i < childrenCount - 2; i++) {
                Node child = this.getChildAtIndex(i).getStandardizedNode();
                child.setParent(currentNode);
                currentNode.addChild(child);

                Node lambdaNode = new LambdaNode(currentNode.getLevel() + i + 1);
                lambdaNode.setParent(currentNode);
                currentNode.addChild(lambdaNode);

                currentNode = lambdaNode;
            }
        }

        Node vNode = this.getChildAtIndex(childrenCount - 2).getStandardizedNode();
        vNode.setParent(currentNode);
        currentNode.addChild(vNode);
        Node eNode = this.getChildAtIndex(childrenCount - 1).getStandardizedNode();
        eNode.setParent(currentNode);
        currentNode.addChild(eNode);

        return replacementNode;
    }
}
