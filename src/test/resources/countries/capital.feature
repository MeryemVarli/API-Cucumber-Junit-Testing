Feature: get capital
  Scenario: get capital of a country
    Given user performs get request
    Then user validates capital as 'London'
    And user validates currency name as 'British pound'
    Then user validates status code as '200'
