package main.ast;

import main.node.Node;
import main.node.NodeFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ASTReader {
    private Node astRoot = null;
    private Node currentNode = null;

    public ASTReader(String filename) {
        this.buildAST(filename);
    }

    private void buildAST(String filename) {
        try {
            File fileObj = new File(filename);
            Scanner fileReader = new Scanner(fileObj);

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().strip();
                int nextLevel = this.getLevel(line);

                Node newNode = NodeFactory.createNode(line, nextLevel);
                if (this.currentNode == null && this.astRoot == null) {
                    this.astRoot = newNode;
                } else {
                    this.updateCurrentNode(nextLevel - 1);
                    this.currentNode.addChild(newNode);
                    newNode.setParent(this.currentNode);
                }
                this.currentNode = newNode;
            }

        } catch (FileNotFoundException e) {
            System.out.printf("File %s is not found.", filename);
        }
    }

    private void updateCurrentNode(int level) {
        if (this.currentNode.getLevel() == level) {
            return;
        }
        if (this.currentNode.getLevel() < level || level < 0) {
            throw new IllegalArgumentException("Invalid level while reading the AST.");
        }

        int currentLevel = this.currentNode.getLevel();
        while (currentLevel != level) {
            this.currentNode = this.currentNode.getParent();
            currentLevel--;
        }
    }

    private int getLevel(String line) {
        int level = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '.')
                level++;
            else
                return level;
        }
        return level;
    }

    public Node getStandardizedTree() {
        return this.astRoot.getStandardizedNode();
    }

    public static void main(String[] args) {
        ASTReader reader = new ASTReader("/home/nimantha/rpal_asts/nested_let");
//        reader.astRoot.traverse();
        reader.astRoot.getStandardizedNode().traverse();
    }
}
