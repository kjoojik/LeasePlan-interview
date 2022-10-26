Feature: Functionalities related to the user

  Scenario Outline: Create new user
    When I create a user with name <Name> and data given in file <userFile>
    Then the response status should be "200"
    And the response body should contain "status" field "placed" 
    
    Examples:
      | Name | userFile |
      | NewUser | user |

  Scenario Outline: Create new user - wrong data
    When I create a user with data given in file <userFile>
    Then the response status should be "500"
    
    Examples:
      | userFile |
      | userInvalid |
