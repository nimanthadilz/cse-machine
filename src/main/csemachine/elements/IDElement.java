package csemachine.elements;

import csemachine.CSEMachine;
import csemachine.Environment;

import java.util.Stack;

public class IDElement extends Element {
    private final String id;

    public IDElement(String id) {
        this.id = id;
    }

    @Override
    public String getStringRepresentation() {
        return id;
    }

    public void process(CSEMachine cseMachine) {
        Stack<Element> stack = cseMachine.getStack();
        if (this.isReserved(this.id)) {
            stack.push(this);
            return;
        }
        Environment env = cseMachine.getEnvironment();
        Element valueFromEnvironment = env.search(this.id);
        stack.push(valueFromEnvironment);
    }

    private boolean isReserved(String id) {
        String[] reservedIDs = { "Print", "Isstring", "Isinteger", "Istruthvalue", "Istuple", "Isfunction", "Isdummy",
            "Stem", "Stern", "Conc", "Order", "Null" };
        for (String keyword: reservedIDs) {
            if (keyword.equals(id))
                    return true;
        }
        return false;
    }
}
