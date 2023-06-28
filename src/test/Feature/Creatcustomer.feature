Feature: Creat a new customer in actitime application

@GetAllCustomer
  Scenario: Add new customer in actitime application
    Given I set up the request structure to featch all customer details
    When I hit the api
      | method | endPoint  |
      | GET    | customers |
  Then I verify all customer "Galaxy Corporation" details

@ProjectNameVerify
 Scenario: Verify total number of project name present in their get all api
  Given I set up the request structure to featch all project details
  When I hit the api in allproject details
    | method | endPoint |
    | GET    | projects |
  Then I verify all projectname "Training"

@CreatCustomer
 Scenario: Verify creat customer using valid details
  Given I set up the request structure to creat customer
    | name                |
    | Cyber Success Api12 |
  When I hit a api
    | method | endPoint  |
    | POST   | customers |
  Then I verify customer getting created successfully withName "Cvber Sucess"
  When I set up the request structure to featch all customer details
  And I hit the api
    | method | endPoint  |
    | GET    | customers |
  Then I verify added successfully
   Given I set up the request structure to creat project
     | description     | projectName |
     | MI VS CSK MATCH | Match1      |
   When I hit a api
     | method | endPoint  |
     | POST   | projects |
  Then I verify project getting created successfully withName "Match1"

  @ErrorMessage
  Scenario: Verify customer should be created with duplicate name
    Given I set up the request structure to create customer
      | name   | archived |
      | cyber1 |          |
    When I hit a api
      | method | endPoint  |
      | POST   | customers |
    Then I verify statuscode as 400 and verify error message
      | message | Customer with specified name already exists|

  @MissingCust
  Scenario Outline: I verify the customer should not be created when missing name
    Given I verify customer should not be created when missing name
    | name   | archived   |
    | <name> | <archived> |
    When I hit a api
      | method | endPoint  |
      | POST   | customers |
    Then I verify status code 400
      | errormsg   |
      | <errormsg> |
    Examples:
      | name  | archived | errormsg                                |
      | empty |          | String length must be between 1 and 255 |
      |       |          | Mandatory field is not specified        |


 @MissingArchived
 Scenario: Verify the archived should be blank when creat customer
   Given I verify customer should be created when archived should be blank
     | name     | archived |
     | abcd3452 |          |
   When I hit a api
     | method | endPoint  |
     | POST   | customers |
   Then I verify the archive value
   |false|

 @MissingendPoint
 Scenario: Verify customer should not be created when misssing endPoint
   Given I verify customer should be created when archived should be blank
     | name     | archived |
     | abcd3452 |          |
   When I hit a api
     | method | endPoint |
     | PO     | customer |
   Then I verify errormsg and status code 404
     | errorMsg | HTTP 404 Not Found |

@PayLoadMissing
Scenario: Verify customer are created payload are missing
  Given I verify customer should be created when archived should be blank
    | name | archived |
    |      |          |
  When I hit a api
    | method | endPoint  |
    | POST   | customers |
  Then I verify error massage and statusCode 400
    |errorMsg  | Mandatory field is not specified |


@HeaderareMisiing
Scenario: Verify customer should be created when header are missing
  Given I verify customer should be created when archived should be blank
    | name     | archived |
    | abcd3452 |          |
  When I hit a api
    | method | endPoint  |
    | POST   | customers |
  Then I verify error massage and statusCode 415
    |errorMsg  | HTTP 415 Unsupported Media Type |

  @HttpMethodMissing
  Scenario: Verify customer should be created when header are missing
    Given I verify customer should be created when archived should be blank
      | name     | archived |
      | abcd3452 |          |
    When I hit a api
      | method | endPoint  |
      | PO     | customers |


  @ProjectNameMissing
  Scenario: Verify project should be created when projectname are empty
    Given I verify project should be created when projectname should be empty
      | customerId  | 80               |
      | name        | empty            |
      | description | Meetings & Calls |
    When I hit a api
      | method | endPoint  |
      | POST   | projects |
    Then I verify the errormsg and status code 400
    |String length must be between 1 and 255|


  @DuplicateProjectName
  Scenario: Verify project should be created when customerId is missing
    Given I verify project should be created when projectName should be duplicate
      | customerId  | 6        |
      | name        | 123      |
      | description | meething |
    When I hit a api
      | method | endPoint |
      | POST   | projects |
    Then I verify the errormsg and status code 400
      |Project with specified name already exists|

  @EndPointmissing
  Scenario: I verify project should not be created when endpint is invalid
    Given I verify project should be created when projectName should be duplicate
      | customerId  | 6        |
      | name        | 12@12    |
      | description | meething |
    When I hit a api
      | method             | endPoint |
      | POST               | project  |
    Then I verify the errormsg and status code 404
      | HTTP 404 Not Found |

  @CreatNewuser
  Scenario: verify new user created successfully
   Given I verify user should be created successfully
     | email     | firstName | lastName | password |
     | cyber@123 | cyber     | success  | 12349995 |
     When I hit a api
      | method | endPoint |
      | POST   | users    |
    Then I verify user should be created successfullye
    And I verify get all user featch successfully
    When I hit a api
      | method | endPoint |
      | GET    | users    |
    Then I verify user add to be successfully

 @FilterEmailAndFullname
 Scenario: Verify the filterout email and fullname retrive the data succefully
   Given I set up the request structure to featch all user detailss
     | active | true |
   When I hit a api
     | method | endPoint |
     | GET    | users    |
   Then I verify filtering the data successfully

  @CustomerUsingJsonObject
  Scenario: Verify user in json format
    Given I add new user using json object
    When I hit a api
      | method | endPoint  |
      | POST   | customers |
    Then I verify cust id
    And I add new project
    When I hit a api
      | method | endPoint  |
      | POST   | projects |
    Then I verify proj id
    And I creat new task
    When I hit a api
      | method | endPoint |
      | POST   | tasks    |

  @CreatUserUsingpojo
  Scenario: Verify user getting created
    Given I verify user getting created using pojo successfully
    When I hit a api
      | method | endPoint |
      | POST   | users    |

  @VerifyObjects
  Scenario: Verify total object in responce
    Given I set up the request structure and verrify total object
    When I hit a api
      | method | endPoint    |
      | GET    | schema.json |
    Then I verify object

  @CreatUserInActitime
  Scenario: I creat new user n actitime
    Given I set up the request structuree
      | firstName | email  | password  | username | lastName | fullName |
      | random    | random | Cyber@123 | random   | random   | random   |
    When I hit a api
      | method | endPoint |
      | POST   | users    |
    Then I get the apii
    When I hit a api
      | method | endPoint |
      | GET      | users    |
    Then I verify the name and

    @CrtCustmr
    Scenario: create new customer
    Given I setUp the req str
      | data | customers |
    Then I get the all user
      | sort | name |
    And I verify all users

   @CreatCust
   Scenario: Create new Cust
     Given I setUp req structure









