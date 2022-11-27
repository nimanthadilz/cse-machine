package csemachine.elements;

public class StrElement extends Element {
    private final String string;

    public StrElement(String string) {
        this.string = string;
    }

    @Override
    public String getStringRepresentation() {
        return string;
    }
}
