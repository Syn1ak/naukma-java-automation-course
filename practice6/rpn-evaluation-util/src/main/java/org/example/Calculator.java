package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.example.RPNConvertor.convertToRPN;
import static org.example.RPNEvaluator.calculate;

public class Calculator {
    private int val1;
    private int val2;

    public void setValues(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public double add() {
        return this.addition(val1, val2);
    }

    public double addition(int val1, int val2) {
        if(val1 < 0 || val2 < 0) throw new IllegalArgumentException("Not allowed to add negative numbers");
        String operation = val1 + "+" + val2;
        String rpnStr = null;
        try {
            rpnStr = convertToRPN(operation);
            return calculate(rpnStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
