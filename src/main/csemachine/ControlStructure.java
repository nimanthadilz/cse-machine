package csemachine;

import csemachine.elements.Element;

import java.util.ArrayList;

public class ControlStructure {
    private final int index;
    private final ArrayList<Element> elementList;

    public ControlStructure(int index) {
        this.index = index;
        this.elementList = new ArrayList<>();
    }

    public void addElement(Element element) {
        this.elementList.add(element);
    }

    public void print() {
        System.out.printf("$%d=", this.index);
        for (Element e : elementList) {
            System.out.printf(" %s", e.getStringRepresentation());
        }
        System.out.println();

    }
}
