@Flights
Feature: Aveluation Flghts function
  I want to avuelation this function on https://www.expedia.com/

  Background: 
    Given I want to go to this "https://www.expedia.com/"

  @Flights_Basic
  Scenario: Checking for the login
    When I complete performance form with valid information
    Then I will see the message
    And close the browser

  @Flights_DataTable
  Scenario: Checking the form with DataTable
    When I complete performance form as
      | Fields            | Values                    |
      | Flying_from       | Ho Chi Minh               |
      | Flying_from_click | Ho Chi Minh City, Vietnam |
      | Flying_to         | Ha noi                    |
      | Flying_to_click   | Hanoi, Vietnam            |
      | Departing         |                        28 |
      | Departing_click   |                        28 |
      | Returning         |                         2 |
      | Returning_click   |                         2 |
    Then I will see the message as
      | Fields      | Values                          |
      | Flying_from | Ho Chi Minh City, Vietnam (SGN) |
      | Flying_to   | Hanoi, Vietnam (HAN)            |
      | Departing   | 08/28/2018                      |
      | Returning   | 09/02/2018                      |
    And close the browser

  @Flights_Data
  Scenario Outline: Checking for form with data
    When I want to write a flying from with "<Flying_from>" and i click on "<Flying_from_click>"
    And I want to write a flying to with "<Flying_to>" and i click on "<Flying_to_click>"
    And I choise departing day "<Departing>" and select Departing with  "<Departing_click>"
    And I choise returning day "<Returning>" and select Returning with  "<Returning_click>"
    And I click on search button
    Then I verify the massage as
      | Fields      | Values                          |
      | Flying_from | Ho Chi Minh City, Vietnam (SGN) |
      | Flying_to   | Hanoi, Vietnam (HAN)            |
      | Departing   | 08/28/2018                      |
      | Returning   | 09/02/2018                      |
    And close the browser

    Examples: 
      | Flying_from | Flying_from_click         | Flying_to | Flying_to_click      | Departing | Departing_click | Returning | Returning_click |
      | Ho Chi Minh | Ho Chi Minh City, Vietnam | Ha noi    | Hanoi, Vietnam (HAN) |        28 |              28 |         2 |               2 |
