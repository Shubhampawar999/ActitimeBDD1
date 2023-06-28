package com.StepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.junit.Assert;

import java.util.*;

public class Task extends BaseClass {
    String  name;

    @Then("I verify the all taskName is {string}")
    public void verifyName(String taskName) {
        Assert.assertEquals("Verify the status code is 200", 200, responce.getStatusCode());

        List<Map<String, Object>> name = responce.jsonPath().getList("items");


        boolean actualname = false;
        for (Map<String, Object> tasName : name) {
            Object name11 = tasName.get("name");
            System.out.println(name11);
            if (name11.equals(taskName)) {
                actualname = true;
                break;
            }
        }
        Assert.assertTrue(actualname);


        List<Map<String, Object>> name1 = responce.jsonPath().getList("items.name");
        Object description = name.get(0).get("items.description");
        if (Objects.isNull(description)) {
            System.out.println(name1);
        }
    }

    @Then("I verify the task {string}")
    public void verifyTheSpecificTask(String taskName) {
        System.out.println("Verify The filter task");


        boolean actualname = false;
        String taskName1 = responce.jsonPath().get("name");
        String nameTask = (String) taskName1;
        if (nameTask.equals(taskName)) {
            actualname = true;
        }
        Assert.assertTrue(actualname);

        boolean actualProjectId = false;
        Integer projectId = responce.jsonPath().get("projectId");
        if (Objects.nonNull(projectId)) {

            System.out.println(projectId);
            actualProjectId = true;
        }
        Assert.assertTrue(actualProjectId);

        //verify the custId
        boolean actualCustId = false;
        Integer custId = responce.jsonPath().get("customerId");
        if (Objects.nonNull(custId)) {
            System.out.println(custId);
            actualCustId = true;
        }
        Assert.assertTrue(actualCustId);
    }


    @Given("I set up the request structure and featch all the taskDetails")
    public void iSetUpTheRequestStructureAndFeatchAllTheTaskDetails(Map<String, Object> projectId) {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .log()
                .all();

        if (Objects.nonNull(projectId)) {
            requestSpecification.queryParams(projectId);
        }
        System.out.println();
    }

    @Then("I verify the projectId is {int}")
    public void iVerifyTheProjectIdIs(int projId) {
        System.out.println(projId);
    }

    @When("I hit the api pathpara")
    public void iHitTheApiPathpara(DataTable obj) {
        Map<String, String> name = obj.asMaps().get(0);
        String methodName = name.get("method");

        String endPoint = name.get("endPoint");
        String httpmethod = methodName.toString();
        if (httpmethod.equals("GET")) {
            System.out.println(methodName);
            if (Objects.nonNull(endPoint)) {
                System.out.println(endPoint);
                String pathpara = name.get("pathPara");
                if (Objects.nonNull(pathpara)) {
                    requestSpecification.pathParam("taskId", pathpara);
                    requestSpecification.get("/" + endPoint + "/" + "{taskId}" + "/" + "comments");
                } else {

                    requestSpecification.get("/" + endPoint);
                }

                System.out.println(pathpara);
            }
        }

    }

    @Then("I verify the responce the {} sorting")
    public void iVerifyTheResponceTheSorting(String order,String statusinfo) {
        System.out.println(order);

        List<String> name = responce.jsonPath().getList("items.name");
        System.out.println("Unsorted List" + name);

        List<String> al = new ArrayList<>();
        al.addAll(name);

        Comparator<String> comparator = new Comparator<String>() {

            public int compare(String s1, String s2) {

                return s1.compareToIgnoreCase(s2);
            }
        };


        if (order.equals("asc"))
            Collections.sort(name, comparator);
        name.sort(comparator);
        System.out.println("Asc order" + name);

        if (order.equals("desc"))
            Collections.sort(name, Collections.reverseOrder(comparator));
        System.out.println("Desc Order" + name);

        Assert.assertTrue(name.equals(al));





    }

    @Then("I verufy the status is {string}")
    public void iVerufyTheStatusIs(String status) {
     String name=  responce.jsonPath().getString("items[0].name");
     System.out.println("Name Of 0 th index"+name);

      Long createdValue=  responce.jsonPath().getLong("items[0].created");
      System.out.println("createdValue"+createdValue);

     Boolean canModifyValue= responce.jsonPath().getBoolean("items[0].allowedAction.canModify");
     System.out.println("value Of CanModify"+canModifyValue);

}

    @Given("I set up the request structure")
    public void iSetUpTheRequestStructure1() {
        name=  new Faker().animal().name();
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .body(name)
                .log()
                .all();
        Comparator<String> com=new Comparator<String>(){
             public int compare(String s1,String s2){
                 return s1.compareToIgnoreCase(s2);
             }
        };
    }

    @Given("I set up the request structure and verrify total object")
    public void iSetUpTheRequestStructureAndVerrifyTotalObject() {

        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://gorest.co.in/")
                .basePath("graphql/")
                .header("Authorization", "Basic QmVhcmVyOjdlYzkxNWQzMzY3MjZiMWVmM2MxMjMzMzViOTg5MjZkNzI5M2FiMTk0NmY0Yjg3OGNkOTA1NWU4M2E4ZGJjMWM=")
                .header("Accept", "application/json")
                .log()
                .all();

    }

    @Then("I verify object")
    public void iVerifyObject() {
        Assert.assertEquals(200, responce.getStatusCode());

        List<Map<String, Object>> obj = responce.jsonPath().getList("data.__schema.types");
        System.out.println(obj.size());

        List<Map<String, Object>> name = responce.jsonPath().getList("data.__schema.types.name");
        System.out.println(name);

        if (Objects.nonNull(name)) {
            System.out.println(name);


        }


    }}

