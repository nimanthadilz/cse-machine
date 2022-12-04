package main.node;

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

        return switch (name) {
            case "let" -> new LetNode(level);
            case "where" -> new WhereNode(level);
            case "within" -> new WithinNode(level);
            case "rec" -> new RecNode(level);
            case "@" -> new InfixNode(level);
            case "and" -> new AndNode(level);
            case "function_form" -> new FunctionFormNode(level);
            case "lambda" -> new LambdaNode(level);
            default -> new OtherNode(name, level);
        };
    }
}
