package com.PutawanDE.OOP_Lab13;

public class ExpEvaluatorLL1 {
    private Tokenizer tokenizer;

    public double evaluateExp(String exp, int lineNum) throws SyntaxError, ArithmeticException {
        tokenizer = new Tokenizer(exp, lineNum);
        double result = parseE();

        if (!tokenizer.isEmpty()) throw new SyntaxError("Invalid line[" + lineNum + "]: " + exp);

        if (!Double.isFinite(result))
            throw new ArithmeticException(" NaN, or Infinity, or -Infinity " +
                    "- may caused by division by zero. Ln[" + lineNum + "]: " + exp);

        return result;
    }

    private double parseE() throws SyntaxError {
        double v = parseT();

        while (tokenizer.peek("+") || tokenizer.peek("-")) {
            String operator = tokenizer.consume();

            if (operator.equals("+")) v += parseT();
            else if (operator.equals("-")) v -= parseT();
        }
        return v;
    }

    private double parseT() throws SyntaxError {
        double v = parseF();
        while (tokenizer.peek("*") || tokenizer.peek("/") || tokenizer.peek("%")) {
            String operator = tokenizer.consume();

            switch (operator) {
                case "*" -> v *= parseF();
                case "/" -> v /= parseF();
                case "%" -> v %= parseF();
            }
        }
        return v;
    }

    private double parseF() throws SyntaxError {
        if (isNumber(tokenizer.peek())) {
            return Double.parseDouble(tokenizer.consume());
        } else {
            tokenizer.consume("(");
            double v = parseE();
            tokenizer.consume(")");
            return v;
        }
    }

    private static boolean isNumber(String str) {
        if (str == null) return false;

        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
