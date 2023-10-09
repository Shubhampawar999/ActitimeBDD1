package com.StepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;


public class GetAllCustomer extends BaseClass{

    String endpoint="";
    String querypara;
    String pathPara;

    Response response;


    @Given("I set up the request structure to featch all customer details")
    public void setUp(){
        System.out.println("Set  up");
         requestSpecification= given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization","Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept","application/json")
                .log()
                .all();
    }
    @When("I hit the api")
    public  void iHitTheApi(DataTable data) {
        System.out.println("get cust");
       List<Map<String,String>> str= data.asMaps();
       Map<String,String> cust=str.get(0);
      String method= cust.get("method");
         endpoint=cust.get("endPoint");
      if(method.equals("GET")){
          if(endpoint !=null){
       responce=  requestSpecification.get("/"+endpoint);}}
       responce.prettyPrint();
    }

    @Then("I verify all customer {string} details")
    public void iVerifyAllCustomerDetails(String name) {
        System.out.println("Verify");
        int statusCode=responce.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode,200);
       System.out.println("Responce Time"+responce.getTime());
      System.out.println("Responce time in seconds"+responce.getTimeIn(TimeUnit.SECONDS));
      Assert.assertEquals(responce.getTime(),response);

        //I verify name is "veera129" present or not in json object
    List<Map<String,String>> name1= responce.jsonPath().get("items");
       System.out.println(name1);
       boolean actualarchiv=false;
       boolean actualResult=false;
       for(Map<String,String> usersName:name1){
          String nameuser= usersName.get("name").toString();
          System.out.println(nameuser);
          if(nameuser.equals(name)){
              System.out.println("verify the customer is present");

            actualResult=true;
            break;}




          }










Assert.assertTrue(actualResult);
       }


    @Given("I set up the request structure to featch all project details")
    public void iSetUpTheRequestStructureToFeatchAllProjectDetails() {
        System.out.println("All setup the request str details");
        System.out.println("Set  up");
        requestSpecification= given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization","Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept","application/json")
                .log()
                .all();
    }

    @When("I hit the api in allproject details")
    public void iHitTheApiInAllprojectDetails(DataTable data1) {
        System.out.println("all project details");
        List<Map<String,String>> list=data1.asMaps();
        Map<String,String> map=list.get(0);
       String httpmethod= map.get("method");
       System.out.println(httpmethod);
       String endpoint=map.get("endPoint");
       System.out.println(endpoint);
       if(httpmethod.equals("GET")){
           if(endpoint !=null){
               responce=requestSpecification.get("/"+endpoint);
           }
       responce.prettyPrint();}
    }

    @Then("I verify all projectname {string}")
    public void iVerifyAllProjectname(String projName) {
        System.out.println("verify the all cust present");
       List<Map<String,String>> allOjectInPresentProject= responce.jsonPath().get("items");
       boolean flag=false;
       //to retrive the total project are present
       int totalproject= allOjectInPresentProject.size();
       System.out.println(totalproject);
       //To retriver the total all project name in consol
        for(Map<String,String>projectName:allOjectInPresentProject){
            //To get the one by one project name and return type is String
          String projectnam=  projectName.get("name");
       System.out.println(projectnam);
       if(projectnam.equals(projName)){
          Object id= projectName.get("id");
          System.out.println(id);
          String projectid="21";
          if(id.equals(projectid)) {

          }
              flag = true;
              break;

       }
        }

Assert.assertTrue(flag);
    }


@Given("I set up the request structure to featch all customer detailss")
public void iSetUpTheRequestStructureToFeatchAllCustomerDetailss(Map<String,Object> data) {
    System.out.println("All setup the request str details");
    System.out.println("Set  up");
    requestSpecification= given();
    requestSpecification.baseUri("https://demo.actitime.com/")
            .basePath("/api/v1")
            .header("Authorization","Basic YWRtaW46bWFuYWdlcg==")
            .header("Accept","application/json")
            .log()
            .all();
    //check query parameter is not null
    if(Objects.nonNull(data)){
        requestSpecification.queryParams(data);
    }

}
    @When("I hit the apii")
    public void iHitTheApii(Map<String,String> map) {
        System.out.println("Query parameter");
          String httpMethod=  map.get("methodName");
           endpoint=map.get("endPoint");
           querypara=map.get("queryParameter");

          if(httpMethod.equals("GET")){
              if(endpoint !=null ){
                  responce=requestSpecification.get("/"+endpoint);
              }
              responce.prettyPrint();
          }
    }

    @Then("I verify cust responce is getting sorted in {} order")
    public void iVerifyCustResponceIsGettingSortedInOrder(String order) {
        Assert.assertEquals(200,responce.getStatusCode());

       List<String> name= responce.jsonPath().getList("items.name");
      // System.out.println("unsortedList"+name);
       //create the object list and add previous list
        List<String> actualSortedList=new ArrayList<>();
        actualSortedList.addAll(name);

        if(order.equals("desc")){

        } else if (order.equals("asc")) {
        Collections .sort(name);



        }
        List<String> name1= responce.jsonPath().getList("items.allowedActions.canModify");
        List<String> name2= responce.jsonPath().getList("items.allowedActions.canDelete");

        if(name1.equals("true") || name2.equals("true")) {

            System.out.println(name1);
        }
    }



    }

