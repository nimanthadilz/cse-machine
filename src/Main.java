import main.ast.ASTReader;
import main.csemachine.CSEMachine;
import main.csemachine.ControlStructureSet;
import main.node.Node;

public class Main {
    public static void main(String[] args) {
        String filename = args[0];
        System.out.println(filename);

        ASTReader astReader = new ASTReader(filename);
        Node standardizedTreeRoot = astReader.getStandardizedTree();

        ControlStructureSet controlStructureSet = new ControlStructureSet(standardizedTreeRoot);
        System.out.println("Control Structures:");
        controlStructureSet.printControlStructureSet();
        System.out.println("===============================");
        CSEMachine cseMachine = new CSEMachine(standardizedTreeRoot);
        cseMachine.evaluate();
    }
}
