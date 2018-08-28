#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Title of your scenario
    Given Navigate to expedia.com
    And Click on Flight button
    When Perform flight form
    Then Verify message

  @tag2
  Scenario: Perform test by Datatable
    Given Navigate to expedia.com
    And Click on Flight button
    When Perform flight form with datatable
      | Field     | Value       | ValueClick                |
      | From      | Ho Chi Minh | Ho Chi Minh City, Vietnam |
      | To        | Ha Noi      | Hanoi, Vietnam            |
      | Departing |          30 |                        30 |
      | Return    |          02 |                        02 |
    Then Verify message with datatable
      | From                      | To             | Departing  | Returning  |
      | Ho Chi Minh City, Vietnam | Hanoi, Vietnam | 08/30/2018 | 09/02/2018 |
