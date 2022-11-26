package node;

import java.util.ArrayList;

public class FunctionFormNode extends Node {
    public FunctionFormNode(int level) {
        super("function_form", level);
    }

    @Override
    public Node getStandardizedNode() {
        int thisNodeLevel = this.getLevel();
        Node replacementNode = new OtherNode("=", thisNodeLevel);

        // standardize the existing nodes
        Node pNode = this.getChildAtIndex(0).getStandardizedNode();
        ArrayList<Node> vNodes = new ArrayList<>();
        for (int i = 1; i < this.getChildrenCount() - 1; i++) {
            vNodes.add(this.getChildAtIndex(i).getStandardizedNode());
        }
        Node eNode = this.getChildAtIndex(this.getChildrenCount() - 1).getStandardizedNode();

        // build the standardized subtree
        pNode.setParent(replacementNode);
        replacementNode.addChild(pNode);

        Node previousNode = replacementNode;
        for (int i = 1; i <= vNodes.size(); i++) {
            Node lambdaNode = new LambdaNode(thisNodeLevel + i);
            lambdaNode.setParent(previousNode);
            previousNode.addChild(lambdaNode);

            Node vNode = vNodes.get(i - 1);
            vNode.setParent(lambdaNode);
            lambdaNode.addChild(vNode);

            if (i == vNodes.size()) {
                eNode.setParent(lambdaNode);
                lambdaNode.addChild(eNode);
            } else {
                previousNode = lambdaNode;
            }
        }

        return replacementNode;
    }
}
