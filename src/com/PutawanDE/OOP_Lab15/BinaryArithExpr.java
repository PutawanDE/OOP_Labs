package com.PutawanDE.OOP_Lab15;

public class BinaryArithExpr implements Expr {
    private Expr left, right;
    private String op;

    public BinaryArithExpr(Expr left, String op, Expr right) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    @Override
    public double eval() throws SyntaxError {
        double lv = left.eval();
        double rv = right.eval();

        return switch (op) {
            case "+" -> lv + rv;
            case "-" -> lv - rv;
            case "*" -> lv * rv;
            case "/" -> lv / rv;
            case "%" -> lv % rv;
            default -> throw new SyntaxError();
        };
    }

    @Override
    public void prettyPrint(StringBuilder s) {
        s.append('(');
        left.prettyPrint(s);
        s.append(op);
        right.prettyPrint(s);
        s.append(')');
    }
}
