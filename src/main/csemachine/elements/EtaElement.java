package main.csemachine.elements;

import main.csemachine.Environment;

import java.util.ArrayList;

public class EtaElement extends Element {
    private final int index;
    private final ArrayList<String> bindingVars;
    private final Environment environment;

    public EtaElement(int index, ArrayList<String> bindingVars, Environment environment) {
        this.index = index;
        this.bindingVars = bindingVars;
        this.environment = environment;
    }

    @Override
    public String getStringRepresentation() {
        StringBuilder repr = new StringBuilder("eta" + index);
        for (String var : bindingVars) {
            repr.append("/").append(var);
        }
        return repr.toString();
    }

    public int getIndex() {
        return index;
    }

    public ArrayList<String> getBindingVars() {
        return bindingVars;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
