package com.PutawanDE.OOP_Lab09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class Lab09Test {
    @Test
    void properLineFormatTest() {
        assertEquals(62.0, Lab09.interpretAndCalculate("11+51", 1));
        assertEquals(1.0, Lab09.interpretAndCalculate("10 % 3", 1));
        assertEquals(262443.8995957429,
                Lab09.interpretAndCalculate("151115*21211/12121- 2331 +333 + 0", 1));
    }

    @Test
    void improperLineFormatTest() {
        Throwable thrownException = assertThrows(InputMismatchException.class,
                () -> Lab09.interpretAndCalculate("2+", 1));
        assertEquals("Invalid token: '+' at the end of line. [Ln:1, Col:2]",
                thrownException.getMessage());

        thrownException = assertThrows(InputMismatchException.class,
                () -> Lab09.interpretAndCalculate("/33121", 1));
        assertEquals("Operator mismatch. [Ln:1, Col:1]",
                thrownException.getMessage());

        thrownException = assertThrows(InputMismatchException.class,
                () -> Lab09.interpretAndCalculate("4 + 5 1", 1));
        assertEquals("Space between number digits is not allowed.  [Ln:1, Col:7]",
                thrownException.getMessage());

        thrownException = assertThrows(InputMismatchException.class,
                () -> Lab09.interpretAndCalculate("211135161*(1-5)", 1));
        assertEquals("Invalid token: '(' at [Ln:1, Col:11]",
                thrownException.getMessage());

        thrownException = assertThrows(InputMismatchException.class,
                () -> Lab09.interpretAndCalculate("1--5", 1));
        assertEquals("Operator mismatch. [Ln:1, Col:3]",
                thrownException.getMessage());
    }

    @Test
    void readWriteFileTest() {
        String inFileName = "src/com/PutawanDE/OOP_Lab09/lab09_test3.txt";
        String outFileName = "src/com/PutawanDE/OOP_Lab09/lab09_output.txt";

        Lab09.readAndCalculate(inFileName, outFileName);

        try (FileReader fileReader = new FileReader(outFileName);
             BufferedReader br = new BufferedReader(fileReader)) {
            String inline;
            int currentLine = 0;
            while ((inline = br.readLine()) != null) {
                if (currentLine == 0) {
                    assertEquals("631-581*20*0 = 0.0" , inline);
                } else if (currentLine == 1) {
                    assertEquals("121212 = 121212.0" , inline);
                } else {
                    Assertions.fail("Written result file is wrong - Too many lines");
                }
                currentLine++;
            }

        } catch (IOException e) {
            Assertions.fail();
            e.printStackTrace();
        }
    }
}
