package main.csemachine.elements;

import java.util.Arrays;

public class ControlStructureElementFactory {
    public static Element createElement(String nodeName) {
        if (nodeName.equals("gamma")) {
            return new GammaElement();
        }
        if (nodeName.startsWith("<ID:")) {
            return new IDElement(nodeName.substring(4, nodeName.length() - 1));
        }
        if (nodeName.startsWith("<INT:")) {
            return new IntElement(nodeName.substring(5, nodeName.length() - 1));
        }
        if (nodeName.startsWith("<STR:")) {
            return new StrElement(nodeName.substring(6, nodeName.length() - 2));
        }
        if (isBinaryOperator(nodeName)) {
            return new BinaryOperatorElement(nodeName);
        }
        if (isUnaryOperator(nodeName)) {
            return new UnaryOperator(nodeName);
        }
        if (nodeName.equals("Y")) {
            return new YElement();
        }
        if (nodeName.equals("<true>")) {
            return new BooleanElement(true);
        }
        if (nodeName.equals("<false>")) {
            return new BooleanElement(false);
        }
        if (nodeName.equals("<nil>")) {
            return new NilElement();
        }
        if (nodeName.equals("<dummy>")) {
            return new DummyElement();
        }

        throw new IllegalArgumentException("Incompatible type '" + nodeName + "'");
    }

    private static boolean isBinaryOperator(String nodeName) {
        String[] binaryOperators = { "aug", "or", "&", "eq", "ne", "+", "-", "*", "/", "**", "gr", "ls", "ge", "le" };
        return Arrays.asList(binaryOperators).contains(nodeName);
    }

    private static boolean isUnaryOperator(String nodeName) {
        String[] unaryOperators = { "not", "neg" };
        return Arrays.asList(unaryOperators).contains(nodeName);
    }
}
