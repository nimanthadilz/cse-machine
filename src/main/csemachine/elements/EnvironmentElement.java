package main.csemachine.elements;

import main.csemachine.CSEMachine;
import main.csemachine.Environment;

import java.util.Stack;

public class EnvironmentElement extends Element {
    private final int index;
    private final Environment environment;

    public EnvironmentElement(int index, Environment environment) {
        this.index = index;
        this.environment = environment;
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

        // find the new environment
        for (int i = stack.size() - 1; i > -1; i--) {
            if (stack.get(i) instanceof EnvironmentElement environmentElement) {
                cseMachine.setEnvironment(environmentElement.getEnvironment());
                break;
            }
        }
    }

    public int getIndex() {
        return index;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
