package com.PutawanDE.OOP_Lab15;

import java.io.*;

public class Lab14 {
    public static void main(String[] args) {
        String inFileName = "src/com/PutawanDE/OOP_Lab12/lab12_test2.txt";
        String outFileName = "src/com/PutawanDE/OOP_Lab12/lab12_output.txt";

        readAndCalculate(inFileName, outFileName);
    }

    public static void readAndCalculate(String inFileName, String outFileName) {
        String inLine;
        ExpEvaluatorLL1 expParser = new ExpEvaluatorLL1();

        try (FileReader fileReader = new FileReader(inFileName);
             BufferedReader br = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(outFileName);
             BufferedWriter bw = new BufferedWriter(fileWriter)) {
            int lineNum = 0;

            while ((inLine = br.readLine()) != null) {
                lineNum++;
                inLine = inLine.trim();
                if (inLine.length() == 0) continue;

                try {
                    double result = expParser.evaluateExprString(inLine, lineNum);
                    String outLine = inLine + " = " + result + "\n";
                    System.out.print(outLine);
                    bw.append(outLine);
                } catch (SyntaxError | ArithmeticException e) {
                    System.out.println("Invalid line: " + inLine);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
