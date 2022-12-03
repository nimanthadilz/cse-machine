package csemachine.elements;

import csemachine.CSEMachine;
import csemachine.Environment;

import java.util.ArrayList;
import java.util.Stack;

public class GammaElement extends Element {
    @Override
    public String getStringRepresentation() {
        return "gamma";
    }

    @Override
    public void process(CSEMachine cseMachine) {
        Stack<Element> stack = cseMachine.getStack();
        Stack<Element> control = cseMachine.getControl();
        Element elementOnStack = cseMachine.getStack().peek();

        // CSE rule 4
        if (elementOnStack instanceof LambdaElement) {
            LambdaElement lambdaElement = (LambdaElement) stack.pop();

            // increment the environment index
            cseMachine.setLastEnvIndex(cseMachine.getLastEnvIndex() + 1);
            int newEnvironmentIndex = cseMachine.getLastEnvIndex();

            Environment newEnvironment = new Environment(newEnvironmentIndex);
            newEnvironment.setParent(lambdaElement.getEnvironment());
            cseMachine.setEnvironment(newEnvironment);

            // bind vars to rands
            ArrayList<String> bindingVars = lambdaElement.getBindingVars();
            if (stack.peek() instanceof TupleElement && bindingVars.size() > 1) {
                TupleElement tupleElement = (TupleElement) stack.pop();
                ArrayList<Element> tupleElements = tupleElement.getElements();
                for (int i = 0; i < tupleElements.size(); i++) {
                    newEnvironment.addDefinition(bindingVars.get(i), tupleElements.get(i));
                }
            } else {
                for (String var : bindingVars) {
                    newEnvironment.addDefinition(var, stack.pop());
                }
            }

            // put environment markers in the control and stack
            Element envMarker = new EnvironmentElement(newEnvironmentIndex, newEnvironment);
            control.push(envMarker);
            stack.push(envMarker);

            // Add new control structure to the control
            cseMachine.addControlStructureToControl(lambdaElement.getIndex());
        }
        // CSE Rule 3
        else {
            Element rator = stack.pop();
            Element rand = stack.pop();

            if (rator instanceof IDElement) {
                String id = rator.getStringRepresentation();

                switch (id) {
                    case "Print" -> System.out.println(rand.getStringRepresentation());
                    case "Stem" -> stack.push(new StrElement(rand.getStringRepresentation().substring(0, 1)));
                    case "Stern" -> stack.push(new StrElement(rand.getStringRepresentation().substring(1)));
                    case "Conc" -> {
                        Element next = stack.pop();
                        stack.push(new StrElement(rand.getStringRepresentation() + next.getStringRepresentation()));
                        // remove additional gamma from control
                        control.pop();
                    }
                    case "Isinteger" -> stack.push(new BooleanElement(rand instanceof IntElement));
                    case "Isstring" -> stack.push(new BooleanElement(rand instanceof StrElement));
                    case "Istruthvalue" -> stack.push(new BooleanElement(rand instanceof BooleanElement));
                    case "Istuple" -> stack.push(new BooleanElement(rand instanceof TupleElement));
                }
                // CSE Rule 10
            } else if (rator instanceof TupleElement tupleElement) {
                IntElement index = (IntElement) rand;
                stack.push(tupleElement.getValueAt(index.getIntValue() - 1));
            } else if (rator instanceof YElement) {
                LambdaElement lambdaElement = (LambdaElement) rand;
                EtaElement etaElement = new EtaElement(
                        lambdaElement.getIndex(),
                        lambdaElement.getBindingVars(),
                        lambdaElement.getEnvironment()
                );
                stack.push(etaElement);
            } else if (rator instanceof EtaElement etaElement) {
                control.push(new GammaElement());
                control.push(new GammaElement());
                stack.push(rand);
                stack.push(rator);

                LambdaElement newLambda = new LambdaElement(
                        etaElement.getIndex(),
                        etaElement.getBindingVars()
                        );
                newLambda.setEnvironment(etaElement.getEnvironment());
                stack.push(newLambda);
            }
        }
    }
}
