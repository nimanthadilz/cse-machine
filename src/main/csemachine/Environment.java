package main.csemachine;

import main.csemachine.elements.Element;

import java.util.HashMap;

public class Environment {
    private final int index;
    private Environment parent = null;
    private final HashMap<String, Element> table;

    public Environment(int index) {
        this.index = index;
        this.table = new HashMap<>();
    }

    public void setParent(Environment parent) {
        this.parent = parent;
    }

    public Element search(String id) {
        if (this.table.containsKey(id)) {
            return this.table.get(id);
        } else if (this.parent != null)
            return this.parent.search(id);
        throw new IllegalArgumentException("Id " + id + " not found in the env tree.");
    }

    public void addDefinition(String id, Element element) {
        this.table.put(id, element);
    }

    public int getIndex() {
        return index;
    }
}

