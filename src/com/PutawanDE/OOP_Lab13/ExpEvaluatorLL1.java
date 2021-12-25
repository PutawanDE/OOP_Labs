package com.PutawanDE.OOP_Lab13;

public class ExpEvaluatorLL1 {
    private Tokenizer tokenizer;

    public double evaluateExprString(String exp, int lineNum) throws ArithmeticException, SyntaxError {
        Expr resultExpr = buildNewExprAST(exp, lineNum);

        if (!tokenizer.isEmpty()) throw new SyntaxError("Invalid line[" + lineNum + "]: " + exp);

        double answer = resultExpr.eval();

        if (!Double.isFinite(answer))
            throw new ArithmeticException(" NaN, or Infinity, or -Infinity " +
                    "- may caused by division by zero. Ln[" + lineNum + "]: " + exp);

        return answer;
    }

    public Expr buildNewExprAST(String exp, int lineNum) throws SyntaxError {
        tokenizer = new Tokenizer(exp, lineNum);
        return parseE();
    }

    private Expr parseE() throws SyntaxError {
        Expr e = parseT();

        while (tokenizer.peek("+") || tokenizer.peek("-")) {
            String operator = tokenizer.consume();

            if (operator.equals("+")) e = new BinaryArithExpr(e, "+", parseT());
            else if (operator.equals("-")) e = new BinaryArithExpr(e, "-", parseT());
        }
        return e;
    }

    private Expr parseT() throws SyntaxError {
        Expr e = parseF();
        while (tokenizer.peek("*") || tokenizer.peek("/") || tokenizer.peek("%")) {
            String operator = tokenizer.consume();

            switch (operator) {
                case "*" -> e = new BinaryArithExpr(e, "*", parseF());
                case "/" -> e = new BinaryArithExpr(e, "/", parseF());
                case "%" -> e = new BinaryArithExpr(e, "%", parseF());
            }
        }
        return e;
    }

    private Expr parseF() throws SyntaxError {
        if (isNumber(tokenizer.peek())) {
            return new DoubleLit(Double.parseDouble(tokenizer.consume()));
        } else {
            tokenizer.consume("(");
            Expr e = parseE();
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
