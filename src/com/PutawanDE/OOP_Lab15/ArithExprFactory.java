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

    public BinaryArithExpr newBinArithExpr(ArithExpr left, String op, ArithExpr right) {
        return new BinaryArithExpr(left, op, right);
    }

    public DoubleLit newDoubleLit(Double val) {
        return new DoubleLit(val);
    }
}
