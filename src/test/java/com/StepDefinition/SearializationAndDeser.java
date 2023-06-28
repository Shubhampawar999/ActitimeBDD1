package com.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojo.CreatnewUsers;
import pojo.setFromJsonBody;

import java.util.*;

import static io.restassured.RestAssured.given;

public class SearializationAndDeser extends BaseClass {
    CreatnewUsers creatnewUsers;
    String name1;
    setFromJsonBody responceBody;
    String id;


    @Given("I setup the request str and hit the api")
    public void hitapi(Map<String, String> name) {
        name1 = name.get("name");
        creatnewUsers = new CreatnewUsers();
        creatnewUsers.setName(name1);
        List<String> list = new ArrayList<>();
        list.add("urs1");
        list.add("usr2");
        creatnewUsers.setPhotoUrls(list);
        List<Map<String, Object>> list1 = new ArrayList();

        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "cyber");
        list1.add(map);
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("id", 2);
        obj.put("name", "success");
        list1.add(obj);
        System.out.println(list1);
        creatnewUsers.setTags(list1);


        System.out.println(creatnewUsers);
        responce = given().baseUri("https://petstore.swagger.io/")
                .basePath("v2/pet")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(creatnewUsers)
                .log()
                .all()
                .post();
        responce.prettyPrint();
    }

    @Then("I verify responce from newly creat users")
    public void iVerifyResponceFromNewlyCreatUsers() {
        Assert.assertEquals(200, responce.getStatusCode());
        responceBody = responce.as(setFromJsonBody.class);
        Assert.assertEquals(responceBody.getPhotoUrls(), creatnewUsers.getPhotoUrls());
        Assert.assertEquals(responceBody.getTags(), creatnewUsers.getTags());
        Assert.assertEquals(responceBody.getName(), creatnewUsers.getName());

    }

    @When("I get the all users")
    public void iGetTheAllUsers() {

        responce = given().baseUri("https://petstore.swagger.io/")
                .basePath("v2/pet/")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .log()
                .all().get("123456");
        responce.prettyPrint();


    }


}