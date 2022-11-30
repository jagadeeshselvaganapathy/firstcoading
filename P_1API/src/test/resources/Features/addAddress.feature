Feature: Address Module for API Automation

  @POST
  Scenario Outline: User add the address from endpoints
    When User add headers for add address endpoint
    When User add the payload"<id>","<name>","<email>","<gender>","<status>" for adding address
    And User send POST request for Addaddress Endpoint
    Then User verify the status code is 200 for adding address
    And User verify the address response body message "Address added succesfully" and save the address id

    Examples: 
      | id   | name   | email            | gender | status |
      | 1339 | sofie | sofie@gmail.com | female   | active |

  @GET
  Scenario: User get the address from endpoints
    When User add headers for get address endpoint
    And user sent GET request for GET endpoints
    Then User verify the status code is 200 for get address
    And User verify the get address response body message

  @PUT
  Scenario Outline: User update the address from endpoints
    When User add headers for update address endpoint
    When User update the payload"<id>","<name>","<email>","<gender>","<status>" for adding address
    And user sent PUT request for Update endpoints
    Then User verify the status code is 200 for update address
    And User verify the update address response body message

    Examples: 
      | id | name           | email                    | gender | status |
      | 20 | nizamAhamadshz | nizamAhamadshz@gmail.com | male   | active |

  @DELETE
  Scenario Outline: User delete the address from endpoints
    When User add headers for delete address
    When User add the payload for deleting the address with "<Address_Id>"
    And user sent DELETE request for delete endpoints
    Then User verify the status code is 200 for deleting address
    And User verify the delete address response body message

    Examples: 
      | Address_id |
      |         20 |
