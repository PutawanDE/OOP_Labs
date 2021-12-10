package com.PutawanDE.OOP_Lab09;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Stack;

public class Lab09 {
    public static void main(String[] args) {
        String inFileName = "src/com/PutawanDE/OOP_Lab09/lab09_test1.txt";
        String outFileName = "src/com/PutawanDE/OOP_Lab09/lab09_output.txt";
        String inLine = "";

        try (FileReader fileReader = new FileReader(inFileName);
             BufferedReader br = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(outFileName);
             BufferedWriter bw = new BufferedWriter(fileWriter)) {
            int lineNum = 0;

            while ((inLine = br.readLine()) != null) {
                lineNum++;
                inLine = inLine.trim();
                String outLine = inLine + " = " + interpretAndCalculate(inLine, lineNum) + "\n";
                System.out.print(outLine);
                bw.append(outLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArithmeticException | InputMismatchException e) {
            System.out.println("Invalid line: " + inLine);
            e.printStackTrace();
        }
    }

    private static double interpretAndCalculate(String line, int lineNum)
            throws InputMismatchException, ArithmeticException {
        if (line.length() == 0) throw new InputMismatchException("Line " + lineNum + " is empty. ");

        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        StringBuilder operandStr = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            boolean isEndOfLine = i == (line.length() - 1);
            String charPos = "[Ln:" + lineNum + ", Col:" + (i + 1) + "]";

            // Parse Number only
            // If End of Line and is not number, then this line is invalid
            if (isEndOfLine && !Character.isDigit(c)) {
                throw new InputMismatchException("Invalid token: '" + c + "' at the end of line. " + charPos);
            } else if (Character.isDigit(c)) {
                operandStr.append(c);
            }

            // If an operator is found, or end of line is reached,
            // then trigger the calculation of the last 2 operands
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || isEndOfLine) {
                if (operandStr.length() > 0) {
                    String str = operandStr.toString().trim();
                    double operand = Integer.parseInt(str);
                    operandStack.push(operand);
                } else {
                    throw new InputMismatchException("Operator mismatch. " + charPos);
                }

                if (operandStack.size() == 2) {
                    char operator = operatorStack.pop();
                    double op2 = operandStack.pop();
                    double op1 = operandStack.pop();
                    double res = 0;

                    switch (operator) {
                        case '+':
                            res = op1 + op2;
                            break;
                        case '-':
                            res = op1 - op2;
                            break;
                        case '*':
                            res = op1 * op2;
                            break;
                        case '/':
                            res = op1 / op2;
                            break;
                        case '%':
                            res = op1 % op2;
                            break;
                    }

                    operandStack.push(res);
                }
                operatorStack.push(c);
                operandStr.setLength(0); // Empty string builder
            } else if (!Character.isDigit(c) && c != ' ') { // Not number, space, operator, or end of line
                throw new InputMismatchException("Invalid token: '" + c + "' at " + charPos);
            }
        }

        double result = operandStack.pop();

        // Check if result is valid (Not NaN, +-Infinity)
        // From https://stackoverflow.com/questions/14137989/
        // java-division-by-zero-doesnt-throw-an-arithmeticexception-why/14138002#comment119309143_14138032
        if (!Double.isFinite(result))
            throw new ArithmeticException(" NaN, or Infinity,or -Infinity " +
                    "- may caused by division by zero. [Ln:" + lineNum + "]");

        return result;
    }
}
