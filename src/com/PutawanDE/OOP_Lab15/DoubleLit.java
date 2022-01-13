package com.PutawanDE.OOP_Lab15;

public class DoubleLit implements Expr {
    private double val;

    public DoubleLit(Double val) {
        this.val = val;
    }

    @Override
    public double eval() {
        return val;
    }

    @Override
    public void prettyPrint(StringBuilder s) {
        s.append(val);
    }
}
