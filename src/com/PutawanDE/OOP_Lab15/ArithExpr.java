package com.PutawanDE.OOP_Lab15;

public interface ArithExpr {
    double eval() throws SyntaxError;

    void prettyPrint(StringBuilder s);
}
