Feature: Project valid and invalid scenario


  @ProjectRelated
Scenario: Creat project with valid username and alid password
Given I set up the request structure to ceate customer payload
  | name   |
  | random |
    When I hit a api
      | method | endPoint  |
      | POST   | customers |
    Then I verify responce from customer
    When I hit a api
      | method | endPoint  |
      | GET    | customers |
    Then I creat the new project with valid credentials

    @Ecxr
    Scenario:verify responce
   Given I get the response from rick and morty api
    Then I verify the response with status code {int}
