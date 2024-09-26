Feature: ability to send message to send message endpoint
  Scenario: api user must be able to send message to certain endpoints with happy path
    Given user has telegram api token
    Then user send message to the endpoint
    And user validates status code  '200'
    Then message successfuly sent