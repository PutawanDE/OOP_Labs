package com.PutawanDE.OOP_Lab15;

public interface Expr {
    double eval() throws SyntaxError;

    void prettyPrint(StringBuilder s);
}
