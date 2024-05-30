package com.example.example2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

import static com.example.example.Comparison.isOperand;

public class RPNEvaluator {
    public static double calculate(String sIn) throws Exception {
        double dA = 0, dB = 0;
        String sTmp;
        Deque<Double> stack = new ArrayDeque<Double>();
        StringTokenizer st = new StringTokenizer(sIn);
        while(st.hasMoreTokens()) {
            try {
                sTmp = st.nextToken().trim();
                if (1 == sTmp.length() && isOperand(sTmp.charAt(0))) {
                    if (stack.size() < 2) {
                        throw new Exception("Invalid amount of data in the stack for the operation " + sTmp);
                    }
                    dB = stack.pop();
                    dA = stack.pop();
                    switch (sTmp.charAt(0)) {
                        case '+':
                            dA += dB;
                            break;
                        case '-':
                            dA -= dB;
                            break;
                        case '/':
                            dA /= dB;
                            break;
                        case '*':
                            dA *= dB;
                            break;
                        case '%':
                            dA %= dB;
                            break;
                        case '^':
                            dA = Math.pow(dA, dB);
                            break;
                        default:
                            throw new Exception("Invalid operation " + sTmp);
                    }
                    stack.push(dA);
                } else {
                    dA = Double.parseDouble(sTmp);
                    stack.push(dA);
                }
            } catch (Exception e) {
                throw new Exception("Invalid character in expression");
            }
        }

        if (stack.size() > 1) {
            throw new Exception("The number of operators does not correspond to the number of operands");
        }

        return stack.pop();
    }
}
