Feature: Functionalities related to the store (ordering, finding orders, removing orders etc.)

  Scenario Outline: Order a new pet from the store
    When I create a pet with name <Name> and data given in file <petFile>
    When I order a pet from the store with data given in file <storeFile>
    Then the resulting location for pet should be <Name>
    Examples:
      | Name | petFile | storeFile |
      | someNewName | pet | store |
