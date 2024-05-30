package org.example2;

import static org.example.Comparison.getPriority;
import static org.example.Comparison.isOperand;

public class RPNConvertor {
    public static String convertToRPN(String input) throws Exception {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();

        char inputChr, tempChr;
        for (int i = 0; i < input.length(); i++) {
            inputChr = input.charAt(i);
            if (isOperand(inputChr)) {
                while (!sb.isEmpty()) {
                    tempChr = sb.substring(sb.length() - 1).charAt(0);
                    if (isOperand(tempChr) && (getPriority(inputChr) <= getPriority(tempChr))) {
                        result.append(" ").append(tempChr).append(" ");
                        sb.setLength(sb.length() - 1);
                    } else {
                        result.append(" ");
                        break;
                    }
                }
                result.append(" ");
                sb.append(inputChr);
            } else if ('(' == inputChr) {
                sb.append(inputChr);
            } else if (')' == inputChr) {
                tempChr = sb.substring(sb.length() - 1).charAt(0);
                while ('(' != tempChr) {
                    if (sb.isEmpty()) throw new Exception("Parsing error. Check the correctness of the expression");
                    result.append(" ").append(tempChr);
                    sb.setLength(sb.length() - 1);
                    tempChr = sb.substring(sb.length() - 1).charAt(0);
                }
                sb.setLength(sb.length() - 1);
            } else {
                result.append(inputChr);
            }
        }

        while (!sb.isEmpty()) {
            result.append(" ").append(sb.substring(sb.length() - 1));
            sb.setLength(sb.length() - 1);
        }

        return result.toString();
    }
}
