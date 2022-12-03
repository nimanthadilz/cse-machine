package csemachine.elements;

public class DeltaElement extends Element {
    private final int index;

    public DeltaElement(int index) {
        this.index = index;
    }

    @Override
    public String getStringRepresentation() {
        return "delta" + index;
    }

    public int getIndex() {
        return index;
    }
}
