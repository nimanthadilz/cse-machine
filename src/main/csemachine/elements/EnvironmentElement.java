package csemachine.elements;

import csemachine.CSEMachine;

import java.util.Stack;

public class EnvironmentElement extends Element {
    private final int index;

    public EnvironmentElement(int index) {
        this.index = index;
    }

    @Override
    public String getStringRepresentation() {
        return "e" + this.index;
    }

    @Override
    public void process(CSEMachine cseMachine) {
        // CSE Rule 5
        Stack<Element> stack = cseMachine.getStack();
        Element value = stack.pop();
        if (value instanceof EnvironmentElement environmentElement) {
            if (environmentElement.getIndex() == this.index)
                return;
        } else {
            stack.pop(); // remove other environment marker from stack
            stack.push(value);
        }
        cseMachine.setEnvironment(cseMachine.getEnvironment().getParent());
    }

    public int getIndex() {
        return index;
    }
}
