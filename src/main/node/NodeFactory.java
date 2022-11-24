package node;

public class NodeFactory {
    /*
    Nodes need to be standardized:
    let, lambda, where, within, and, rec, fcn_form, @

    Nodes don't need to be standardized:
    tau, aug, ->, // tuple expressions
    or, &, not, gr, ge, ls, le, eq, ne, // boolean expressions
    +, -, neg, *, /, **,  // arithmetic expressions
    gamma, true, false, nil, dummy,
    =, (), ","

     */
    public static Node createNode(String line, int level) {
        String name = line.replace(".", "");

        switch (name) {
            case "let":
                return  new LetNode(name, level);
        }
        return new OtherNode(name, level);
    }
}
