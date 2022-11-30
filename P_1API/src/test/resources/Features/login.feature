@tag1
Feature: Login Module API automation

  Scenario: Get user logToken from login endpoint
    Given user add header
    And user add basic authentication for login
    When user sent POST request for login request
    Then user verify the status code is 200
    And user verify the login respose body type is "unknown" and get logtok+en should saved
