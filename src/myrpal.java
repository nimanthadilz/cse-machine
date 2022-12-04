import main.ast.ASTReader;
import main.csemachine.CSEMachine;
import main.node.Node;

public class myrpal {
    public static void main(String[] args) {
        String filename = args[0];
        ASTReader astReader = new ASTReader(filename);
        Node standardizedTreeRoot = astReader.getStandardizedTree();

        CSEMachine cseMachine = new CSEMachine(standardizedTreeRoot);
        System.out.println("Output of the above program is:");
        cseMachine.evaluate();
    }
}
