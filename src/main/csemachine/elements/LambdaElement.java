package csemachine.elements;

import csemachine.CSEMachine;
import csemachine.Environment;

import java.util.ArrayList;

public class LambdaElement extends Element {

    private final int index;
    private final ArrayList<String> bindingVars;
    private Environment environment;

    public LambdaElement(int index, ArrayList<String> bindingVars) {
        this.index = index;
        this.bindingVars = bindingVars;
    }

    @Override
    public String getStringRepresentation() {
        StringBuilder repr = new StringBuilder("lambda" + index);
        for (String var : bindingVars) {
            repr.append("/").append(var);
        }
        return repr.toString();
    }

    @Override
    public void process(CSEMachine cseMachine) {
        this.environment = cseMachine.getEnvironment();
        cseMachine.getStack().push(this);
    }

    public Environment getEnvironment() {
        return this.environment;
    }

    public int getIndex() {
        return index;
    }

    public ArrayList<String> getBindingVars() {
        return bindingVars;
    }
}
