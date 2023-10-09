package com.StepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.NewTask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AddNewCustomerInActitimeApplication extends BaseClass {
    Response responce;

    String custName;
    int cusId;
    String name;
    int projectId;
    String desc;
    String tname;

    @Given("I set the request structure with valid name 1")
    public void setTheRequest(DataTable table) {
        System.out.println("Inside the actitime request body");
        String customerName = table.asMaps().get(0).get("CustomerName");
        String responceBody = "{\n" +
                "  \"name\":\"" + customerName + "\",\n" +
                "         \"archived\": false\n"
                + "}";
        System.out.println(responceBody);

        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(responceBody)
                .log()
                .all();
    }

    @And("I hite the api")
    public void hitapi(DataTable table) {
        String methodName = table.asMaps().get(0).get("methodName");
        System.out.println(methodName);
        String endpoint = table.asMaps().get(0).get("endpoint");
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

    @Then("I verify the responce with status code")
    public void iVerifyTheResponceWithStatusCode(Map<String, String> custName) {

        Assert.assertEquals(200, responce.getStatusCode());
        Assert.assertEquals(custName.get("name"), responce.jsonPath().getString("name"));
        Assert.assertFalse(responce.jsonPath().getBoolean("archived"));
    }

    @Given("I set up the request")
    public void iSetUpTheRequest() {
        Faker faker = new Faker();
         custName = faker.name().firstName();
        System.out.println(custName);

        String responcebody = "{\n" +
                "  \"name\":\"" + custName + "\",\n" +
                "         \"archived\": false\n"
                + "}";

        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(responcebody)
                .log()
                .all();

    }

    @Then("I verify the exp and act result")
    public void iVerifyTheExpAndActResult() {
        
Assert.assertEquals(200,responce.getStatusCode());
String custNameact=responce.jsonPath().getString("name");

boolean assertTrue=false;
if(custName.equals(custNameact)){
    assertTrue=true;
}
Assert.assertTrue(assertTrue);

Assert.assertFalse(responce.jsonPath().getBoolean("archived"));
Assert.assertTrue(responce.jsonPath().getBoolean("allowedActions.canModify"));
Assert.assertTrue(responce.jsonPath().getBoolean("allowedActions.canDelete"));

 cusId=responce.jsonPath().getInt("id");
 System.out.println(cusId);
    }


    //Pass the data from request body using mapObject
    @Given("I set req")
    public void iSetReq(Map<String,Object> projectData) {
        Faker fakr=new Faker();
        System.out.println(projectData);
         name=fakr.programmingLanguage().name();
        Map<String,Object> archiv=new HashMap<>();
        archiv.put("name",name);
        archiv.put("archived",false);
        archiv.put("customerId",cusId);
        archiv.putAll(projectData);
        System.out.println(archiv);

        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(archiv)
                .log()
                .all();
    }

    @Then("I verify responce status code {int}")
    public void iVerifyResponceStatusCode(int statuscode) {
        Assert.assertEquals(statuscode,responce.getStatusCode());
        String projectName=responce.jsonPath().getString("name");
        //Verify actual and expected project name
        boolean asserttrue=false;
        if(name.equals(projectName)){
            asserttrue=true;
        }
        Assert.assertTrue(asserttrue);


     projectId=responce.jsonPath().getInt("id");
    System.out.println(projectId);

    Assert.assertFalse(responce.jsonPath().getBoolean("archived"));

    }

    @Given("Add new task in actitime application and setup the request")
    public void addNewTaskInActitimeApplicationAndSetupTheRequest() {
        Faker f=new Faker();
        NewTask task=new NewTask();
        tname=f.app().name();
        task.setName(tname);
        task.setStatus("Open");
        task.setProjectId(projectId);
        task.setEstimatedTime(1234);
         desc=new Faker().nation().capitalCity();
        task.setDescription(desc);
        System.out.println(task);

        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(task)
                .log()
                .all();

    }

    @Then("I verify responce staus  {int}")
    public void iVerifyResponceStaus(int sts) {

        Assert.assertEquals(sts,responce.getStatusCode());
        Assert.assertEquals(projectId,responce.jsonPath().getInt("projectId"));
        String taskName=responce.jsonPath().getString("name");
        boolean asserttrue=false;
        if(tname.equals(taskName)){
            asserttrue=true;
        }
        Assert.assertTrue(asserttrue);
    }
}
