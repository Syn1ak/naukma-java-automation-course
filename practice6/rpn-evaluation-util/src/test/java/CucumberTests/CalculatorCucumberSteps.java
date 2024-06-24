package CucumberTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Calculator;

import static junit.framework.TestCase.assertEquals;


public class CalculatorCucumberSteps {
    private Calculator calculator;
    private double res;

    @Given("init calculator")
    public void initializeCalc() {
        calculator = new Calculator();
    }

    @Given("got two numbers {int} and {int}")
    public void sumOfTwoNumbers(int val1, int val2) {
        calculator.setValues(val1, val2);
    }

    @When("I try to add")
    public void tryToAdd() {
        res = calculator.add();
    }

    @Then("I should get {double}")
    public void shouldGet(double expected) {
        assertEquals(res, expected);
    }

}
