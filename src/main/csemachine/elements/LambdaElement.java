package csemachine.elements;

import java.util.ArrayList;

public class LambdaElement extends Element {
    private final int index;
    private final ArrayList<String> bindingVars;
    
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
}
