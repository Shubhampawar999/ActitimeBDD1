
Feature: xml responce verify



   @Xml
     Scenario: Get  first name from get all contacts api
      Given I get all contacts info from get all api
      Then I verify first names in the response

   @GetTheUserInAgileCRM
     Scenario: Get pic from get all users
      Given I get all users info from get all api
     Then I verify pic from responce

