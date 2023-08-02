Feature: Create Account

  Background: User is Logged In
    Given User is in Login Page
    When User enters "alexsmith@gmail.com" and "Password_1"
    Then User is login successfully

  @Test
  Scenario: User creates new Checking Account
    Given User has no Checking Account
    When User creates new Checking Account
    Then New Checking Account created

  Scenario: User creates new Savings Account
    Given User has no Savings Account
    When User creates new Savings Account
    Then New Savings Account created
