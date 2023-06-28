Feature: All scenario from regress application

  @creatUsersIsValid
  Scenario: Create new users in regress application
    Given I set up request structure and hit api
    When I hit a api
      | method | endPoint |
      | POST   | users    |
    Then I verify status code

  @CreateNewUserWithDuplicateName
    Scenario: Create duplicate user in regress application
    Given I set up request structure and hit api
    When I hit a api
      | method | endPoint |
      | POST   | users    |
    Then I verify status code 400
      | errorMsg | I verify responce code and error msg "User with specified username already exists" |

  @CreateNewUserWithnameEmpty
    Scenario: Create user with name is empty
    Given I set the request structure with name is empty
    When I hit a api
      | method | endPoint |
      | POST   | users    |
    Then I verify status code 400
      | errorMsg | String length must be between 1 and 191 |




  @GetAllUsers
    Scenario: Get all users from page1 and page2
    Given I setup req str and featch all userse
    When I hit a api
      | method | endPoint |
      | GET    | users    |
    Then I verify status code 200 and name print ascending order


  @DownLoadTheFile
  Scenario: Download the file from github
    Given I set up the request Structure to download the file
    When I hit a api
      | method | endPoint |
      | GET    | pom.xml  |
    Then I verify responce code and "pom.xml" downloaded

   @CreateUserpageIterate
   Scenario: Get all user name from all pages
     Given I set up and hit api and featch all user name from all pages
     Then I verify name

  @createNewUser
  Scenario: I creat new user from gorest application
    Given I set the request structure and hit api
      | first_name | cyber                                   |
      | last_name  | sucess                                  |
      | email      | cyber@123                               |
      | avatar     | https://reqres.in/img/faces/7-image.jpg |
    Then I verify new user created
    When I get all users and verify the new users are created
    Then I verify users getting created successfully

  @SerialisationAndDeserialisation
  Scenario: Get all user from pet swager api
    Given I setup the request str and hit the api
      | name | Will |
    When I get the all users
    Then I verify responce from newly creat users








