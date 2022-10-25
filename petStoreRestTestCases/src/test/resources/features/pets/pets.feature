Feature: CRUD for pets

  Scenario Outline: Looking up pet by petId
    When I look up a pet by <PetId>
    Then the resulting location for pet should be <Name>
    Examples:
      | PetId | Name |
      | 1548 | valueimplcat |

  Scenario Outline: Add a new pet to the store
    When I create a pet with name <Name> and data given in file <File>
    Then the resulting location for pet should be <Name>
    Examples:
      | Name | File |
      | someNewName | pet |

  Scenario Outline: Remove a pet from the store
    When I create a pet with name <Name> and data given in file <File>
    Then the resulting location for pet should be <Name>
    Examples:
      | Name | File |
      | someNewName | pet |
