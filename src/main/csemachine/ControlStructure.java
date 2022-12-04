package main.csemachine;

import main.csemachine.elements.Element;

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

    public ArrayList<Element> getElementList() {
        return this.elementList;
    }

    public void print() {
        System.out.printf("$%d=", this.index);
        for (Element e : elementList) {
            System.out.printf(" %s", e.getStringRepresentation());
        }
        System.out.println();

    }
}
