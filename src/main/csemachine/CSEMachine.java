package csemachine;

import csemachine.elements.Element;
import csemachine.elements.EnvironmentElement;
import node.Node;

import java.util.Stack;
import java.util.StringJoiner;


public class CSEMachine {
    private ControlStructureSet controlStructureSet;
    private Stack<Element> control;
    private Stack<Element> stack;
    private Environment environment;
    private int lastEnvIndex = 0;

    public CSEMachine(Node root) {
        try {
            controlStructureSet = new ControlStructureSet(root);
            this.control = new Stack<>();
            this.stack = new Stack<>();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void evaluate() {
        // add initial environment marker to the control and stack
        this.environment = new Environment(0);
        Element envZero = new EnvironmentElement(0, this.environment);
        this.control.push(envZero);
        this.stack.push(envZero);

        // add the first control structure to the control
        ControlStructure firstControlStructure = this.controlStructureSet.getControlStructureAt(0);
        for (Element e : firstControlStructure.getElementList()) {
            control.push(e);
        }

        while (!this.control.isEmpty()) {
            // call a method to display the control and stack
            this.displayControl();
            this.displayStack();
            Element poppedElementFromControl = this.control.pop();
            poppedElementFromControl.process(this);
        }
        this.displayStack();

    }

    public Stack<Element> getStack() {
        return this.stack;
    }

    public Stack<Element> getControl() {
        return this.control;
    }

    public void displayControl() {
        // display the elements of the control
        StringJoiner sj = new StringJoiner(" ");
        this.control.forEach(item -> sj.add(item.getStringRepresentation()));
        System.out.println("Control: " + sj);
    }

    public void displayStack() {
        // display the elements of the stack
        StringJoiner sj = new StringJoiner(" ");
        this.stack.forEach(item -> sj.add(item.getStringRepresentation()));
        System.out.println("Stack: " + sj);
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void addControlStructureToControl(int index) {
        ControlStructure controlStructure = this.controlStructureSet.getControlStructureAt(index);
        for (Element e : controlStructure.getElementList()) {
            control.push(e);
        }
    }

    public int getLastEnvIndex() {
        return lastEnvIndex;
    }

    public void setLastEnvIndex(int lastEnvIndex) {
        this.lastEnvIndex = lastEnvIndex;
    }
}
