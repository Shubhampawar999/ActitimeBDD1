Feature:Create a new Custmer in actitime application

   @GetProject
     Scenario Outline: Get the specific cust in and get the all projectname
       Given I set up the request structure to featch all customer detailss
         | customerIds | 6  |
         | limit       | 10 |
       When I hit the apii
         | methodName     | <methodName>     |
         | endPoint       | <endPoint>       |
         | queryParameter | <queryParameter> |
     Then Verify i vefify status code is 200
     And Vefify project information in responce
       Examples:
         | methodName | endPoint | queryParameter |
         | GET        | projects | 6              |

  @GetOffset
  Scenario: Verify the comments of project in offset
    Given I set up the request structure to featch all project detailss
      | offset | 0    |
      | limit  | 1000 |
    When I het the api
      | methodName | endPoint | pathpara |
      | GET        | projects | 24       |
    And Verify to get output
  @CreatUser
  Scenario: User created
    Given I verify user getting created

   @CreatcustomerandUpdate
   Scenario: verify customer update feature for actitime
     Given I verify users should be created successfully
       | name   |  description |
       | random |  random      |
     When I hit a api
       | method | endPoint  |
       | POST   | customers |
     Then I verify responce and status code 200
     And I update the newly created user
       | name   | description | pathpara   |
       | random | random      | customerId |
     When I hit the api cust
       | method | endPoint  | pathpara   |
       | PATCH  | customers | customerId |
     Then I verify status cust code 200

   @CreatCustomerWithnameIsEmpty
   Scenario: verify customer update feature for actitime
     Given I verify users should be created successfully
       | name   |  description |
       | random |  random      |
     When I hit a api
       | method | endPoint  |
       | POST   | customers |
     Then I verify responce and status code 200
     And I verify customer is empty
       | name | empty |
     When I hit the api cust
       | method | endPoint  | pathpara   |
       | PATCH  | customers | customerId |
     Then verify error msg
     |String length must be between 1 and 255|

   @CreatCustomerAndAfterNameIsNull
   Scenario: verify customer update feature for actitime
     Given I verify users should be created successfully
       | name   |  description |
       | random |  random      |
     When I hit a api
       | method | endPoint  |
       | POST   | customers |
     Then I verify responce and status code 200
     And I verify customer is empty
       | name | null |
     When I hit the api cust
       | method | endPoint  | pathpara   |
       | PATCH  | customers | customerId |

     @DeletCustomer
     Scenario: verify customer delet functionality
       Given I set the request structure to ceate customer payload
         | name   | archived |
         | random |          |
       When I hit a api
         | method | endPoint  |
         | POST   | customers |
       Then I verify responcee and status code 200
       When I delet the customer
       And I set the request structure to creat project
         | name   |
         | random |
       When I hit a api
         | method | endPoint |
         | POST   | projects |

   @CreateUserInGorest
   Scenario: verify add new user in gorest
     Given I set the request structure and create user
       | name | abc |
     When I hit a api
       | method | endPoint |
       | POST   | users    |





