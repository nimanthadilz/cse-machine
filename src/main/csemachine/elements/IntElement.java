package csemachine.elements;

public class IntElement extends Element {
    private final int integer;

    public IntElement(String integer) {
        this.integer = Integer.parseInt(integer);
    }

    @Override
    public String getStringRepresentation() {
        return String.valueOf(this.integer);
    }

    public int getIntValue() {
        return this.integer;
    }
}
