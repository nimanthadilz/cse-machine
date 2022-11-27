package csemachine.elements;

public class UnaryOperator extends Element {
    private final String operator;

    public UnaryOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String getStringRepresentation() {
        return operator;
    }
}
