package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.example.RPNConvertor.convertToRPN;
import static org.example.RPNEvaluator.calculate;

public class Calculator {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString;
        try {
            System.out.println("Enter a simple expression for calculation: ");
            inputString = br.readLine();
            String rpnStr = convertToRPN(inputString);
            System.out.println("Result: " + calculate(rpnStr));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
