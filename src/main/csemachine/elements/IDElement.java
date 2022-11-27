package csemachine.elements;

public class IDElement extends Element {
    private final String id;

    public IDElement(String id) {
        this.id = id;
    }

    @Override
    public String getStringRepresentation() {
        return id;
    }
}
