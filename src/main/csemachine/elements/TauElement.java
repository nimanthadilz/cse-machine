package csemachine.elements;

import csemachine.CSEMachine;

import java.util.ArrayList;
import java.util.Stack;

public class TauElement extends Element {
    private final int numOfElements;

    public TauElement(int numOfElements) {
        this.numOfElements = numOfElements;
    }

    @Override
    public String getStringRepresentation() {
        return "tau" + this.numOfElements;
    }

    @Override
    public void process(CSEMachine cseMachine) {
        // CSE Rule 9
        ArrayList<Element> elements = new ArrayList<>();
        Stack<Element> stack = cseMachine.getStack();
        for (int i = 0; i < this.numOfElements; i++) {
            elements.add(stack.pop());
        }

        TupleElement tupleElement = new TupleElement(numOfElements, elements);
        stack.push(tupleElement);
    }
}
