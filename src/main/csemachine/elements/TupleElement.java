package csemachine.elements;

import java.util.ArrayList;
import java.util.StringJoiner;

public class TupleElement extends Element {
    private final int numOfElements;
    private final ArrayList<Element> elements;

    public TupleElement(int numOfElements, ArrayList<Element> elements) {
        this.numOfElements = numOfElements;
        this.elements = elements;
    }

    @Override
    public String getStringRepresentation() {
        StringJoiner sj = new StringJoiner(", ", "(", ")");
        elements.forEach(e -> sj.add(e.getStringRepresentation()));
        return sj.toString();
    }

    public Element getValueAt(int index) {
        if (index < this.numOfElements && index > -1)
            return this.elements.get(index);
        throw new IllegalArgumentException("Index " + index + " out of range.");
    }

    public ArrayList<Element> getElements() {
        return elements;
    }
}
