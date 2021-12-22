package com.PutawanDE.OOP_Lab12;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Lab12Test {
    ExpEvaluatorLL1 expParser = new ExpEvaluatorLL1();

    @Test
    void properLineFormatTest() throws SyntaxError {
        assertEquals(62.0, expParser.evaluateExp("11+51", 1));
        assertEquals(1.0, expParser.evaluateExp("10 % 3", 1));
        assertEquals(262443.8995957429,
                expParser.evaluateExp("151115*21211/12121- 2331 +333 + 0", 1));
        assertEquals(640.0, expParser.evaluateExp("(26+54)*(138-130)", 1));
        assertEquals(19.0, expParser.evaluateExp("(64 +31)/( 80-75)", 1));
        assertEquals(1922.8653846153845, expParser.evaluateExp("((2322-121+21)*45-1)/52", 1));
        assertEquals(3.0, expParser.evaluateExp("3121%5*12-(30/5+3)", 1));
        assertEquals(5.0, expParser.evaluateExp("(30 * 2) / ((28 - 26) * (19 - (13)))", 1));
        assertEquals(7.0, expParser.evaluateExp("  1+ 6", 1));
    }

    @Test
    void improperLineFormatTest() {
        assertThrows(ArithmeticException.class, () -> expParser.evaluateExp("6/(10-3*3-1)", 1));
        assertThrows(ArithmeticException.class, () -> expParser.evaluateExp("31/(10%3 *2 -(6-4))", 1));
        assertThrows(ArithmeticException.class, () -> expParser.evaluateExp("0/0", 1));
        assertThrows(SyntaxError.class, () -> expParser.evaluateExp("3 + 7 69", 1));
        assertThrows(SyntaxError.class, () -> expParser.evaluateExp("151 5 +", 1));
        assertThrows(SyntaxError.class, () -> expParser.evaluateExp("511+", 1));
        assertThrows(SyntaxError.class, () -> expParser.evaluateExp("x^2+4x+10", 1));
        assertThrows(SyntaxError.class, () -> expParser.evaluateExp("()", 1));
        assertThrows(SyntaxError.class, () -> expParser.evaluateExp("51--15", 1));
        assertThrows(SyntaxError.class, () -> expParser.evaluateExp("/15", 1));
    }

    @Test
    void readWriteFileTest() throws IOException {
        Path testFile = Paths.get("src/com/PutawanDE/OOP_Lab12/lab12_test2.txt");
        Path output = Paths.get("src/com/PutawanDE/OOP_Lab12/lab12_test2_out.txt");
        Path expectedFile = Paths.get("src/com/PutawanDE/OOP_Lab12/lab12_test2_expected.txt");

        Lab12.readAndCalculate(testFile.toString(), output.toString());
        List<String> outFileLines = Files.readAllLines(output);
        List<String> expectedFileLines = Files.readAllLines(expectedFile);
        assertEquals(outFileLines, expectedFileLines);
    }
}