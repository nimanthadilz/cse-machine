package csemachine.elements;

import csemachine.CSEMachine;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryOperatorElement extends Element {
    private final String operator;

    public BinaryOperatorElement(String operator) {
        this.operator = operator;
    }

    @Override
    public String getStringRepresentation() {
        return operator;
    }

    @Override
    public void process(CSEMachine cseMachine) {
        Stack<Element> stack = cseMachine.getStack();
        Element rand1 = stack.pop();
        Element rand2 = stack.pop();
        Element result;

        switch (operator) {
            case "+" -> {
                result = new IntElement(
                        String.valueOf(
                                ((IntElement) rand1).getIntValue() + ((IntElement) rand2).getIntValue()
                        )
                );
                stack.push(result);
            }
            case "-" -> {
                result = new IntElement(
                        String.valueOf(
                                ((IntElement) rand1).getIntValue() - ((IntElement) rand2).getIntValue()
                        )
                );
                stack.push(result);
            }
            case "*" -> {
                result = new IntElement(
                        String.valueOf(
                                ((IntElement) rand1).getIntValue() * ((IntElement) rand2).getIntValue()
                        )
                );
                stack.push(result);
            }
            case "/" -> {
                result = new IntElement(
                        String.valueOf(
                                ((IntElement) rand1).getIntValue() / ((IntElement) rand2).getIntValue()
                        )
                );
                stack.push(result);
            }
            case "**" -> {
                result = new IntElement(
                        String.valueOf(
                                (int) Math.pow(
                                        ((IntElement) rand1).getIntValue(), ((IntElement) rand2).getIntValue()
                                )
                        )
                );
                stack.push(result);
            }
            case "or" -> {
                result = new BooleanElement(
                        ((BooleanElement) rand1).getBooleanValue()
                                || ((BooleanElement) rand2).getBooleanValue()
                );
                stack.push(result);
            }
            case "&" -> {
                result = new BooleanElement(
                        ((BooleanElement) rand1).getBooleanValue()
                                & ((BooleanElement) rand2).getBooleanValue()
                );
                stack.push(result);
            }
            case "eq" -> {
                if (rand1 instanceof BooleanElement & rand2 instanceof BooleanElement)
                    result = new BooleanElement(
                            ((BooleanElement) rand1).getBooleanValue()
                                    & ((BooleanElement) rand2).getBooleanValue()
                    );
                else {
                    result = new BooleanElement(
                            rand1.getStringRepresentation()
                                    .equals(
                                            rand2.getStringRepresentation()
                                    )
                    );
                }
                stack.push(result);
            }
            case "ne" -> {
                if (rand1 instanceof BooleanElement & rand2 instanceof BooleanElement)
                    result = new BooleanElement(
                            (!((BooleanElement) rand1).getBooleanValue()
                                    & ((BooleanElement) rand2).getBooleanValue())
                    );
                else {
                    result = new BooleanElement(
                            !rand1.getStringRepresentation()
                                    .equals(
                                            rand2.getStringRepresentation()
                                    )
                    );
                }
                stack.push(result);
            }
            case "gr" -> {
                result = new BooleanElement(
                        ((IntElement) rand1).getIntValue()
                                > ((IntElement) rand2).getIntValue()
                );
                stack.push(result);
            }
            case "ls" -> {
                result = new BooleanElement(
                        ((IntElement) rand1).getIntValue()
                                < ((IntElement) rand2).getIntValue()
                );
                stack.push(result);
            }
            case "ge" -> {
                result = new BooleanElement(
                        ((IntElement) rand1).getIntValue()
                                >= ((IntElement) rand2).getIntValue()
                );
                stack.push(result);
            }
            case "le" -> {
                result = new BooleanElement(
                        ((IntElement) rand1).getIntValue()
                                <= ((IntElement) rand2).getIntValue()
                );
                stack.push(result);
            }
            case "aug" -> {
                ArrayList<Element> tupleElements = new ArrayList<>();
                if (!(rand1 instanceof NilElement)) {
                    if (rand1 instanceof TupleElement randTuple) {
                        tupleElements.addAll(randTuple.getElements());
                    } else {
                        tupleElements.add(rand1);
                    }
                }
                if (!(rand2 instanceof NilElement)) {
                    if (rand2 instanceof TupleElement randTuple) {
                        tupleElements.addAll(randTuple.getElements());
                    } else {
                        tupleElements.add(rand2);
                    }
                }
                result = new TupleElement(tupleElements.size(), tupleElements);
                stack.push(result);
            }
        }
    }
}
