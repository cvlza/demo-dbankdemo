Feature: Login Functionality

  @Test
  Scenario: Successful login
    Given User is in Login Page
    When User enters "alexsmith@gmail.com" and "Password_1"
    Then User is login successfully
    And User closes browser

  @Negative
  Scenario: Unsuccessful login
    Given User is in Login Page
    When User enters "standard_users" and "secret_sauce"
    Then User login unsuccessful
    And User closes browser