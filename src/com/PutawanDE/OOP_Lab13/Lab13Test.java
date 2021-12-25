package com.PutawanDE.OOP_Lab13;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Lab13Test {
    ExpEvaluatorLL1 expParser = new ExpEvaluatorLL1();

    @Test
    void TestExprEvaluation_ProperExpr_ShouldPass() throws SyntaxError {
        assertEquals(62.0, expParser.evaluateExprString("11+51", 1));
        assertEquals(1.0, expParser.evaluateExprString("10 % 3", 1));
        assertEquals(262443.8995957429,
                expParser.evaluateExprString("151115*21211/12121- 2331 +333 + 0", 1));
        assertEquals(640.0, expParser.evaluateExprString("(26+54)*(138-130)", 1));
        assertEquals(19.0, expParser.evaluateExprString("(64 +31)/( 80-75)", 1));
        assertEquals(1922.8653846153845, expParser.evaluateExprString("((2322-121+21)*45-1)/52", 1));
        assertEquals(3.0, expParser.evaluateExprString("3121%5*12-(30/5+3)", 1));
        assertEquals(5.0, expParser.evaluateExprString("(30 * 2) / ((28 - 26) * (19 - (13)))", 1));
        assertEquals(7.0, expParser.evaluateExprString("  1+ 6", 1));
    }

    @Test
    void TestExprEvaluation_ImproperExpr_ShouldThrowException() {
        assertThrows(ArithmeticException.class, () -> expParser.evaluateExprString("6/(10-3*3-1)", 1));
        assertThrows(ArithmeticException.class, () -> expParser.evaluateExprString("31/(10%3 *2 -(6-4))", 1));
        assertThrows(ArithmeticException.class, () -> expParser.evaluateExprString("0/0", 1));
        assertThrows(SyntaxError.class, () -> expParser.evaluateExprString("3 + 7 69", 1));
        assertThrows(SyntaxError.class, () -> expParser.evaluateExprString("151 5 +", 1));
        assertThrows(SyntaxError.class, () -> expParser.evaluateExprString("511+", 1));
        assertThrows(SyntaxError.class, () -> expParser.evaluateExprString("x^2+4x+10", 1));
        assertThrows(SyntaxError.class, () -> expParser.evaluateExprString("()", 1));
        assertThrows(SyntaxError.class, () -> expParser.evaluateExprString("51--15", 1));
        assertThrows(SyntaxError.class, () -> expParser.evaluateExprString("/15", 1));
    }

    @Test
    void TestParenthesizedExpr_ProperExpr_ShouldPass() throws SyntaxError {
        StringBuilder s = new StringBuilder();
        expParser.buildNewExprAST("1232", 1).prettyPrint(s);
        assertEquals("1232.0", s.toString());
        s.setLength(0);
        expParser.buildNewExprAST("2*4+6", 1).prettyPrint(s);
        assertEquals("((2.0*4.0)+6.0)", s.toString());
        s.setLength(0);
        expParser.buildNewExprAST("2+4*6", 1).prettyPrint(s);
        assertEquals("(2.0+(4.0*6.0))", s.toString());
        s.setLength(0);
        expParser.buildNewExprAST("2+4/6", 1).prettyPrint(s);
        assertEquals("(2.0+(4.0/6.0))", s.toString());
        s.setLength(0);
        expParser.buildNewExprAST("6/4/5", 1).prettyPrint(s);
        assertEquals("((6.0/4.0)/5.0)", s.toString());
        s.setLength(0);
        expParser.buildNewExprAST("2/4+6", 1).prettyPrint(s);
        assertEquals("((2.0/4.0)+6.0)", s.toString());
        s.setLength(0);
        expParser.buildNewExprAST("2+4%6+3+2*1+1/3", 1).prettyPrint(s);
        assertEquals("((((2.0+(4.0%6.0))+3.0)+(2.0*1.0))+(1.0/3.0))", s.toString());
        s.setLength(0);
        expParser.buildNewExprAST("1*2*3", 1).prettyPrint(s);
        assertEquals("((1.0*2.0)*3.0)", s.toString());
        s.setLength(0);
        expParser.buildNewExprAST("1/(2+4*5/2)", 1).prettyPrint(s);
        assertEquals("(1.0/(2.0+((4.0*5.0)/2.0)))", s.toString());
        s.setLength(0);
        expParser.buildNewExprAST("1/((11+2*3)/(11*2+3))", 1).prettyPrint(s);
        assertEquals("(1.0/((11.0+(2.0*3.0))/((11.0*2.0)+3.0)))", s.toString());
        s.setLength(0);
        expParser.buildNewExprAST("151115*21211/12121- 2331 +333 + 0", 1).prettyPrint(s);
        assertEquals("(((((151115.0*21211.0)/12121.0)-2331.0)+333.0)+0.0)", s.toString());
    }

    @Test
    void TestReadEvaluateWriteFile_ProperExpr_ShouldPass() throws IOException {
        Path testFile = Paths.get("src/com/PutawanDE/OOP_Lab12/lab12_test2.txt");
        Path output = Paths.get("src/com/PutawanDE/OOP_Lab12/lab12_test2_out.txt");
        Path expectedFile = Paths.get("src/com/PutawanDE/OOP_Lab12/lab12_test2_expected.txt");

        Lab13.readAndCalculate(testFile.toString(), output.toString());
        List<String> outFileLines = Files.readAllLines(output);
        List<String> expectedFileLines = Files.readAllLines(expectedFile);
        assertEquals(outFileLines, expectedFileLines);
    }
}