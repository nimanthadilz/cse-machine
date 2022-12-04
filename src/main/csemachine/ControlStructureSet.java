package main.csemachine;

import main.csemachine.elements.*;
import main.node.Node;

import java.util.ArrayList;

public class ControlStructureSet {
    private final ArrayList<ControlStructure> controlStructureList;
    private int currentControlStructureIndex = 0;

    public ControlStructureSet(Node root) {
        this.controlStructureList = new ArrayList<>();

        ControlStructure initialControlStructure = new ControlStructure(currentControlStructureIndex);
        this.controlStructureList.add(initialControlStructure);
        this.addToControlStructure(initialControlStructure, root);
    }

    private void addToControlStructure(ControlStructure controlStructure, Node node) {
        String nodeName = node.getName();
        switch (nodeName) {
            case "lambda" -> {
                Node leftNode = node.getChildAtIndex(0);
                ArrayList<String> bindingVars = new ArrayList<>();
                // single variable
                if (leftNode.getName().startsWith("<ID:")) {
                    bindingVars.add(leftNode.getName().substring(4, leftNode.getName().length() - 1));
                }
                // n-ary function
                else if (leftNode.getName().equals(",")) {
                    for (int i = 0; i < leftNode.getChildrenCount(); i++) {
                        Node idNode = leftNode.getChildAtIndex(i);
                        bindingVars.add(leftNode.getChildAtIndex(i).getName().substring(4, idNode.getName().length() - 1));
                    }
                }
                controlStructure.addElement(new LambdaElement(++this.currentControlStructureIndex, bindingVars));

                // add right subtree of lambda node to a new control structure
                ControlStructure newControlStructure = new ControlStructure(this.currentControlStructureIndex);
                this.controlStructureList.add(newControlStructure);
                this.addToControlStructure(newControlStructure, node.getChildAtIndex(1));
            }
            case "->" -> {
                // add two delta elements to the control structure
                ControlStructure thenDeltaStructure = new ControlStructure(++this.currentControlStructureIndex);
                this.controlStructureList.add(thenDeltaStructure);
                controlStructure.addElement(new DeltaElement(this.currentControlStructureIndex));

                ControlStructure elseDeltaStructure = new ControlStructure(++this.currentControlStructureIndex);
                this.controlStructureList.add(elseDeltaStructure);
                controlStructure.addElement(new DeltaElement(this.currentControlStructureIndex));

                this.addToControlStructure(thenDeltaStructure, node.getChildAtIndex(1));
                this.addToControlStructure(elseDeltaStructure, node.getChildAtIndex(2));

                // add a beta element to the structure
                controlStructure.addElement(new BetaElement());

                // add the boolean operator branch to the structure
                this.addToControlStructure(controlStructure, node.getChildAtIndex(0));
            }
            case "tau" -> {
                int childrenCount = node.getChildrenCount();
                controlStructure.addElement(new TauElement(childrenCount));
                for (int i = 0; i < childrenCount; i++) {
                    this.addToControlStructure(controlStructure, node.getChildAtIndex(i));
                }
            }
            default -> {
                controlStructure.addElement(ControlStructureElementFactory.createElement(nodeName));
                for (int i = 0; i < node.getChildrenCount(); i++) {
                    this.addToControlStructure(controlStructure, node.getChildAtIndex(i));
                }
            }
        }
    }

    public ControlStructure getControlStructureAt(int index) {
        return this.controlStructureList.get(index);
    }

    public void printControlStructureSet() {
        // Used to print control structures for debugging purposes
        for (ControlStructure cs : controlStructureList) {
            cs.print();
        }
    }
}
