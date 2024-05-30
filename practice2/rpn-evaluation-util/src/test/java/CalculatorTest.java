import org.junit.Test;

import static org.example2.RPNConvertor.convertToRPN;
import static org.example2.RPNEvaluator.calculate;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {
    @Test
    public void test1() {
        try {
            String input = "(34 + 34) * 2 / 1";
            double result = calculate(convertToRPN(input));
            assertTrue(result == 136);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test2() {
        try {
            String input = "(34 + 34) * 2 / 0";
            double result = calculate(convertToRPN(input));
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
