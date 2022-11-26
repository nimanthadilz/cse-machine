package node;

public class OtherNode extends Node {
    public OtherNode(String name, int level) {
        super(name, level);
    }

    @Override
    public Node getStandardizedNode() {
        Node replacement = new OtherNode(this.getName(), this.getLevel());
        for (int i = 0; i < this.getChildrenCount(); i++) {
            Node child = this.getChildAtIndex(i).getStandardizedNode();
            child.setParent(replacement);
            replacement.addChild(child);
        }
        return replacement;
    }
}
