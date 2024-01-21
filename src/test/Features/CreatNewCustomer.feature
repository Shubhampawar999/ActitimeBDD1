Feature:Create a new Custmer in actitime application


   @GetProject
     Scenario Outline: Get the specific cust in and get the all projectname
       Given I set up the request structure to featch all customer detailss
       When I hit the apii
         | methodName     | <methodName>     |
         | endPoint       | <endPoint>       |
         | queryParameter | <queryParameter> |
       Examples:
         | methodName | endPoint | queryParameter |
         | GET        | projects | 6              |

   @AddNewUser
   Scenario: Add new user in actitime application
     Given I set up request str to add new users
     When I hit the restful api and passing the data using dataTable
       | methodName | POST  |
       | endPoint   | users |
     Then I verify successfully add new user name or  not

     Given I set up the request structure to featch all customer detils
     When I hit the restul api and getting all uses
       | methodName | GET   |
       | endpoint   | users |
     Then I verify added successfully newly user or not
     And I deleted the newly created customer
     When I hit the apiii
       | methodName | endPoint  |
       | POST       | customers |
     Then I verifying newly created user deleted or not
     And I updationg the newly created user
     When I set up the request and verifying the responce
       | methodName | endPoint  |
       | PATCH      | customers |



     @DownFile
     Scenario: Idown file
       Given I down the file in innerclass folder
       Then I verify the responce file downlad successfully or not


