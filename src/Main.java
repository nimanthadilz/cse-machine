import ast.ASTReader;
import csemachine.ControlStructureSet;
import node.Node;

public class Main {
    public static void main(String[] args) {
        String filename = args[0];
        System.out.println(filename);

        ASTReader astReader = new ASTReader(filename);
        Node standardizedTreeRoot = astReader.getStandardizedTree();

        ControlStructureSet controlStructureSet = new ControlStructureSet(standardizedTreeRoot);
        controlStructureSet.printControlStructureSet();
    }
}
