package csemachine.elements;

import csemachine.CSEMachine;

import java.util.Stack;

public class BetaElement extends Element {
    @Override
    public String getStringRepresentation() {
        return "beta";
    }

    @Override
    public void process(CSEMachine cseMachine) {
        Stack<Element> stack = cseMachine.getStack();
        Stack<Element> control = cseMachine.getControl();

        BooleanElement booleanElement = (BooleanElement) stack.pop();
        DeltaElement deltaElse = (DeltaElement) control.pop();
        DeltaElement deltaThen = (DeltaElement) control.pop();

        if (booleanElement.getBooleanValue()) {
            cseMachine.addControlStructureToControl(deltaThen.getIndex());
        } else {
            cseMachine.addControlStructureToControl(deltaElse.getIndex());
        }
    }
}
