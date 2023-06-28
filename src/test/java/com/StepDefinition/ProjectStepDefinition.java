package com.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pojo.CustomerPayload;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class ProjectStepDefinition extends BaseClass{

    String endpoint="";
    String querypara;
    String pathPara;
   public CustomerPayload customerPayload;


    @Then("Verify i vefify status code is {int}")
    public void statusCode(int expectedStatusCode){

        int actualStatusCode=responce.getStatusCode();
        Assert.assertEquals(actualStatusCode,expectedStatusCode);

    }

    @And("Vefify project information in responce")
    public void vefifyProjectInformationInResponce() {
       List<Map<String,Object>> itemsList= responce.jsonPath().getList("items");
        itemsList.forEach(map->{
            Assert.assertEquals(6,map.get("customerId"));
            Object name1=map.get("name");
            Assert.assertTrue(Objects.nonNull(name1));
            Assert.assertTrue(Objects.nonNull(map.get("archived")));
        });
    }



}
