package com.PutawanDE.OOP_Lab15;

public class ExpEvaluatorLL1 {
    private Tokenizer tokenizer;
    private final ArithExprFactory arithExprFactory;

    public ExpEvaluatorLL1() {
        arithExprFactory = ArithExprFactory.getInstance();
    }

    public double evaluateExprString(String exp, int lineNum) throws ArithmeticException, SyntaxError {
        ArithExpr resultExpr = buildNewExprAST(exp, lineNum);

        if (!tokenizer.isEmpty()) throw new SyntaxError("Invalid line[" + lineNum + "]: " + exp);

        double answer = resultExpr.eval();

        if (!Double.isFinite(answer))
            throw new ArithmeticException(" NaN, or Infinity, or -Infinity " +
                    "- may caused by division by zero. Ln[" + lineNum + "]: " + exp);

        return answer;
    }

    public ArithExpr buildNewExprAST(String exp, int lineNum) throws SyntaxError {
        tokenizer = new Tokenizer(exp, lineNum);
        return parseE();
    }

    private ArithExpr parseE() throws SyntaxError {
        ArithExpr e = parseT();

        while (tokenizer.peek("+") || tokenizer.peek("-")) {
            String operator = tokenizer.consume();

            if (operator.equals("+")) e = arithExprFactory.newArithExpr(e, "+", parseT());
            else if (operator.equals("-")) e = arithExprFactory.newArithExpr(e, "-", parseT());
        }
        return e;
    }

    private ArithExpr parseT() throws SyntaxError {
        ArithExpr e = parseF();
        while (tokenizer.peek("*") || tokenizer.peek("/") || tokenizer.peek("%")) {
            String operator = tokenizer.consume();

            switch (operator) {
                case "*" -> e = arithExprFactory.newArithExpr(e, "*", parseF());
                case "/" -> e = arithExprFactory.newArithExpr(e, "/", parseF());
                case "%" -> e = arithExprFactory.newArithExpr(e, "%", parseF());
            }
        }
        return e;
    }

    private ArithExpr parseF() throws SyntaxError {
        if (isNumber(tokenizer.peek())) {
            return arithExprFactory.newArithExpr(Double.parseDouble(tokenizer.consume()));
        } else {
            tokenizer.consume("(");
            ArithExpr e = parseE();
            tokenizer.consume(")");
            return e;
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
