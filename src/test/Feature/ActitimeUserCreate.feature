Feature: Create the user from actitime application
  @Shubham
  Scenario: Add the new customer in actitime application
    Given I set the request structure with valid name 1
      | CustomerName | archived |
      | Shubham111   | false    |
    And I hite the api
      | methodName | endpoint |
      | GET        | users    |
    Then I verify the responce with status code
      | name | Shubham111 |

    @Faker
    Scenario: Add the new customer in actitime applications
      Given I set up the request
      And I hite the api
        | methodName | endpoint  |
        | POST       | customers |
      Then I verify the exp and act result
      Given I set req
        | description | shubham |
      And I hite the api
        | methodName | endpoint |
        | POST       | projects |
      Then I verify responce status code 200
      Given Add new task in actitime application and setup the request
      And I hite the api
        | methodName | endpoint |
        | POST       | tasks    |
      Then I verify responce staus  200
      And I hite the api
        | methodName | endpoint |
        | GET        | tasks    |
      Then Verify the specific provided name