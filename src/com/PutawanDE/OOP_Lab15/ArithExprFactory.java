package com.PutawanDE.OOP_Lab15;

public class ArithExprFactory {
    private static ArithExprFactory instance;

    private ArithExprFactory() {
    }

    public static ArithExprFactory getInstance() {
        if (instance == null) {
            instance = new ArithExprFactory();
        }
        return instance;
    }

    public ArithExpr newArithExpr(ArithExpr left, String op, ArithExpr right) {
        return new BinaryArithExpr(left, op, right);
    }

    public ArithExpr newArithExpr(Double val) {
        return new DoubleLit(val);
    }
}
