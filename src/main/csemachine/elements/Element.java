package main.csemachine.elements;

import main.csemachine.CSEMachine;

public abstract class Element {
    public abstract String getStringRepresentation();

    public void process(CSEMachine cseMachine) {
        cseMachine.getStack().push(this);
    }
}
