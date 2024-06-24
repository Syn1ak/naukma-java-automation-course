import org.example.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorJunit5Tests {
    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.addition(1, 1));
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "5,    5,   10",
            "4,    2,   6",
            "49,  51, 100",
            "11,  100, 111"
    })
    void add(int val1, int val2, int res) {
        Calculator calculator = new Calculator();
        assumeTrue(val1 >= 5);
        assertEquals(res, calculator.addition(val1, val2),
                () -> val1 + " + " + val2 + " should equal " + res);
    }

    @Test
    void assertJTest() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.addition(1, -2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Not allowed to add negative numbers");
    }
}
