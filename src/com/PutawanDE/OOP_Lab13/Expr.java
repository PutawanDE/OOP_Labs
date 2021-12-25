package com.PutawanDE.OOP_Lab13;

public interface Expr {
    double eval() throws SyntaxError;

    void prettyPrint(StringBuilder s);
}
