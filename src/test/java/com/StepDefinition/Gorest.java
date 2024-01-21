package com.StepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Gorest extends BaseClass {
    Response responce;


    @Given("I set up request str and featch all data")
    public void setUp() {
        requestSpecification = given();
        requestSpecification.baseUri("https://gorest.co.in/")
                .basePath("public/v2/")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .log()
                .all();
    }
    @When("I hit the ap for gorest application")
    public void hitreq(DataTable table) {
         String methodName=table.asMaps().get(0).get("methodname");
         System.out.println(methodName);
         String endpoint=table.asMaps().get(0).get("endpoint");
        System.out.println(endpoint);
        if (methodName.equals("GET")) {
            if (endpoint != null) {
                responce = requestSpecification.get("/" + endpoint);
            }
        } else if (methodName.equals("POST")) {
            if (endpoint != null) {
                responce = requestSpecification.post("/" + endpoint);
            }
        }
        responce.prettyPrint();
    }

    @Then("I vrify th responce of gorest application")
    public void verifyTheResponce(){
        String nameOfUser="Bhagvan Menon";
        boolean flag=false;
        Assert.assertEquals(200,responce.getStatusCode());
      List<String> usersname1= responce.jsonPath().getList("name");
      System.out.println(usersname1);
         for(String name:usersname1){
             if(name.equals(nameOfUser)){
                 System.out.println("Users name is verify");
             }else{
                 System.out.println("Users is not verify");
             }

             }
         }
    }


