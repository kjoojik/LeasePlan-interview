Feature: Looking up pets

  Scenario Outline: Looking up pet by petId
    When I look up a pet by <PetId>
    Then the resulting location for pet should be <Name>
    Examples:
      | PetId | Name |
      | 1548 | valueimplcat |
