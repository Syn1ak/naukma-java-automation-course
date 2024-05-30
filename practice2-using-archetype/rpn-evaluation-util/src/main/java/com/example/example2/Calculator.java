package com.example.example2;

import com.example.apache.logging.log4j.LogManager;
import com.example.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.example.example2.RPNConvertor.convertToRPN;
import static com.example.example2.RPNEvaluator.calculate;

public class Calculator {
    private static final Logger logger = LogManager.getLogger();

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
        logger.info("done execution");
    }
}
