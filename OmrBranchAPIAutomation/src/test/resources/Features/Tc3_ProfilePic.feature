Feature: Profile pic module for API Automation testing
@pic
  Scenario: User change the profile pic from endpoints
    When User add headers for change profile picture endpoint
    Then User add  the pay load for adding the profile pic
    And User send POST request for Change profile pic  Endpoint
    Then User verify the status code is 200 for changing profile picture
    And User verify the change profile pic response body message "profile updated succesfully"