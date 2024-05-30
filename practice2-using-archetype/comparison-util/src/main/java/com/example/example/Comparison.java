package com.example.example;

public class Comparison {
    public static boolean isOperand(char c) {
        return switch (c) {
            case '-', '+', '*', '/', '^' -> true;
            default -> false;
        };
    }

    public static int getPriority(char op) {
        return switch (op) {
            case '^' -> 3;
            case '*', '/', '%' -> 2;
            default -> 1;
        };
    }
}
