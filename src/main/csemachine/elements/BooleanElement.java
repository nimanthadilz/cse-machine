package csemachine.elements;

public class BooleanElement extends Element {
    private final boolean booleanValue;

    public BooleanElement(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    @Override
    public String getStringRepresentation() {
        return String.valueOf(this.booleanValue);
    }

    public boolean getBooleanValue() {
        return this.booleanValue;
    }
}
