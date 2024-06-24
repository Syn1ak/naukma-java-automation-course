Feature: Calculator Expressions
  This calculator evaluation scenarios.

  Background:
    Given init calculator

  Scenario: Sum of two
    Given got two numbers 23 and 31
    When I try to add
    Then I should get 54.0

  Scenario: Sum of two
    Given got two numbers 5 and 3
    When I try to add
    Then I should get 8.0

  Scenario Outline: Sum of two
    Given got two numbers <n1> and <n2>
    When I try to add
    Then I should get <result>

    Examples:
      |n1|n2|result|
      |4|5|9|
      |5|3|8|
