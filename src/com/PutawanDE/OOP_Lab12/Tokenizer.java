package com.PutawanDE.OOP_Lab12;

import java.util.LinkedList;
import java.util.Queue;

public class Tokenizer {
    private final String inputExp;
    private final int lineNum;
    private final Queue<String> tokens = new LinkedList<>();

    // based on http://ostack.cn/?qa=516507/
    private final String expRegex = "([\\s]++)|(?<=[+-\\-*/%()])|(?=[+\\-*/%()])";

    public Tokenizer(String inputExp, int lineNum) {
        this.inputExp = inputExp;
        this.lineNum = lineNum;
        tokenize();
    }

    private void tokenize() {
        String[] separated = inputExp.split(expRegex);
        for (String s : separated) {
            if (!s.trim().equals("")) { // eliminate whitespace
                tokens.add(s);
            }
        }
    }

    public String peek() {
        return tokens.peek();
    }

    public String consume() {
        return tokens.poll();
    }

    public boolean isEmpty() {
        return tokens.isEmpty();
    }

    public boolean peek(String s) {
        if (tokens.isEmpty()) return false;
        else return peek().equals(s);
    }

    public void consume(String s) throws SyntaxError {
        if (peek(s)) consume();
        else throw new SyntaxError("Invalid line[" + lineNum + "]: " + inputExp);
    }
}
