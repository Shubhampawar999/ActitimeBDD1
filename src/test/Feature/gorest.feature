Feature: Vefify the data in gorest application


  @Gorest
  Scenario: Verify the user of the present gorest application
    Given I set up request str and featch all data
    When I hit the ap for gorest application
      | methodname | endpoint |
      | GET        | users    |
    Then I vrify th responce of gorest application

