@login
Feature: Login to Intranet
  I want to use this template for my feature file

  Background: 
    Given I want to go to this website
When I complete performance to the login form as
      | Fields   | Values    |
      | username | conkhikho |
      | password | conkhikho |
  @loginFalse
  Scenario: Checking for the login
    When I complete performance to the login form with invalid information
    Then I will see the error message
    And close the browser

  @loginFalseWithDataTable
  Scenario: Checking for the login with DataTable
    
    Then I will see the error message as
      | Fields | Values                       |
      | error  | Invalid username or password |
    And close the browser

  @loginFalseWithData
  Scenario Outline: Checking for the login with data
    When I want to write a username with "<name>"
    And I want to write a password with  "<pass>"
    And I click on submit button
    Then I verify the "<status>" in step
    And close the browser

    Examples: 
      | name  | pass   | status                       |
      | name1 | 123456 | Invalid username or password |
