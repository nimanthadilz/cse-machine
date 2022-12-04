package main.csemachine.elements;

import main.csemachine.CSEMachine;

import java.util.Stack;

public class UnaryOperatorElement extends Element {
    private final String operator;

    public UnaryOperatorElement(String operator) {
        this.operator = operator;
    }

    @Override
    public String getStringRepresentation() {
        return operator;
    }

    @Override
    public void process(CSEMachine cseMachine) {
        Stack<Element> stack = cseMachine.getStack();
        Element rand = stack.pop();

        switch (operator) {
            case "not":
                stack.push(new BooleanElement(!((BooleanElement)rand).getBooleanValue()));
            case "neg":
                stack.push(new IntElement(String.valueOf(-1 * ((IntElement)rand).getIntValue())));
        }
    }
}
