package csemachine;

import node.Node;


public class CSEMachine {
    private ControlStructureSet controlStructureSet;

    public CSEMachine(Node root) {
        try {
            controlStructureSet = new ControlStructureSet(root);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
