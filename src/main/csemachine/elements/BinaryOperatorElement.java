package csemachine.elements;

public class BinaryOperatorElement extends Element {
    private final String operator;

    public BinaryOperatorElement(String operator) {
        this.operator = operator;
    }

    @Override
    public String getStringRepresentation() {
        return operator;
    }
}
