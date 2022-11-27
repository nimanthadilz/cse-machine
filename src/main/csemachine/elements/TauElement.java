package csemachine.elements;

public class TauElement extends Element {
    private final int numOfElements;

    public TauElement(int numOfElements) {
        this.numOfElements = numOfElements;
    }

    @Override
    public String getStringRepresentation() {
        return "tau" + this.numOfElements;
    }
}
