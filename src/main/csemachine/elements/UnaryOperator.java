package csemachine.elements;

import csemachine.CSEMachine;

import java.util.Stack;

public class UnaryOperator extends Element {
    private final String operator;

    public UnaryOperator(String operator) {
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
