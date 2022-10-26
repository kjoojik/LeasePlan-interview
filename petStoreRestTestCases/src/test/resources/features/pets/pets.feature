Feature: CRUD for pets

  Scenario Outline: Looking up pet by petId
    When I create a pet with name <Name> and data given in file <File>
    When I look up a pet by <PetId>
    Then the resulting location for pet should be <Name>
    Examples:
      | PetId | Name | File |
      | 12131411 | valueimplcat | pet |

  Scenario Outline: Add a new pet to the store
    When I create a pet with name <Name> and data given in file <File>
    Then the resulting location for pet should be <Name>
    Examples:
      | Name | File |
      | someNewName | pet |

    Scenario Outline: Add a new pet to the store
    When I create a pet with name <Name> and data given in file <File>
    Then the resulting location for pet should be <Name>
    Examples:
      | Name | File |
      | someNewName | pet |   

  Scenario: Update a pet in the store
    When I update a pet with name <Name> and data given in file <File>
    Then the resulting location for pet should be <Name>
    Examples:
      | Name | File |
      | UpdateName | pet |

  Scenario: Upload image for a pet in the store
    When I upload image for a pet with pet Id <Id> and data given in file <File>
   Then the response status should be '200'
    Examples:
      | Id | File |
      | 12131411 | pet |


  Scenario Outline: Remove not existing pet from the store - not possible
    When I create a pet with name <Name> and data given in file <File>
    When I delete a pet with id <PetId>
    When I delete a pet with id <PetId>
    Then the response status should be '404'
    Examples:
      | Name | File | PetId |
      | someNewName | pet | 12131411    | 
