package com.StepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.junit.Assert;
import pojo.SamplePojo;

import java.util.*;

import static io.restassured.RestAssured.given;

public class Projcet extends BaseClass{
    Integer cuid;
    Map<String,String> queryParam;


    @Given("I set up the request structure to featch all project detailss")
    public void iSetUpTheRequestStructureToFeatchAllProjectDetailss(Map<String,Object> data1) {
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization","Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept","application/json")
                .log()
                .all();
        //check query parameter is not null
        if(Objects.nonNull(data1)){
            requestSpecification.queryParams(data1);
        }

    }

    @When("I het the api")
    public void iHetTheApi(DataTable map) {
        Map<String,String>map1=map.asMaps().get(0);
        String httpMethod=  map1.get("methodName");
       String endpoint=map1.get("endPoint");
       String querypara=map1.get("queryParameter");
       // System.out.println(querypara);

        if(httpMethod.equals("GET")){
            if(map1.get("pathpara") !=null ){
                requestSpecification.pathParam("projectId",map1.get("pathpara"));
                responce=requestSpecification.get("/"+endpoint+"/"+"{projectId}"+"/"+"comments");
            }else{
                responce=requestSpecification.get("/"+endpoint);
            }
            responce.prettyPrint();

        }


    }

    @And("Verify to get output")
    public void verifyToGetOutput() {
       int o=responce.jsonPath().get("offset");
        System.out.println(o);
        Assert.assertEquals(0,o);
    }


    @When("I hit a apii")
    public void hit(Map<String,String> custDet){

        String methodname=custDet.get("MethodName");
        if(methodname.equals("GET")){
            if(custDet.get("EndPoint") !=null){
                String endpoint=custDet.get("EndPoint");
             responce=   requestSpecification.get("/"+endpoint);


            }

            responce.prettyPrint();
        }


    }

    @Then("Verify all custname")
    public void verifyAllCustname() {
      List<Map<String,String>> str= responce.jsonPath().getList("items");

        str.forEach(custdetail->Assert.assertTrue(Objects.nonNull(custdetail.get("name")))


        );

    }

    @When("I pass custId and hit api")
    public void iPassCustIdAndHitApi(Map<String,Object> obj) {
      Object methodName = obj.get("Method");
      String method=(String)methodName;
      if(method.equals("GET")){
          if(Objects.nonNull(obj.get("CustId"))){
           Object  CustID=obj.get("CustId");
          Object endpoint=obj.get("EndPoint");
              requestSpecification.pathParam("CustometId",CustID);
              responce=requestSpecification.get("/"+endpoint+"/"+"{CustometId}");
          }
      }
      responce.prettyPrint();
    }

    @Then("verify custId")
    public void verifyCustId() {
        Assert.assertEquals(200,responce.getStatusCode());

    }

   @Given("I set up the request structure to ceate customer payload")
    public void setup(DataTable table) {
       String CustomerName = table.asMaps().get(0).get("name");
       String responceBody;
       String name = new Faker().name().firstName();
       if (Objects.isNull(CustomerName)) {
           responceBody = "{" + " \"name\": \""+null+"\"" + "}";
       } else if (CustomerName.equals("empty")) {
           responceBody = "{\n" +
                   "\"name\": \"\"" + "}";
       } else if (CustomerName.equals("random")) {
           responceBody = "{\n" +
                   "  \"name\":\"" + name + "\",\n" +
                   "         \"archived\": false\n"
                   + "}";


           RestAssured.useRelaxedHTTPSValidation();
           requestSpecification = given();
           requestSpecification.baseUri("https://demo.actitime.com/")
                   .basePath("/api/v1")
                   .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                   .header("Accept", "application/json")
                   .header("Content-Type", "application/json")
                   .body(responceBody)
                   .log()

                   .all();


       }

   }

    @Then("I verify responce from customer")
    public void iVerifyResponceFromCustomer() {
        Assert.assertEquals(200,responce.getStatusCode());
       cuid=  responce.jsonPath().get("id");
       Comparator<String> comparator = new Comparator<String>() {

            public int compare(String s1, String s2) {

                return s1.compareToIgnoreCase(s2);
            }
        };

    }


    @Given("I get the response from rick and morty api")
    public void iGetTheResponseFromRickAndMortyApi(Map<String,String> map) {

String status=map.get("status");
String species=map.get("species");
        queryParam = new HashMap<>();

        map.forEach((k, v) -> {
            //check if the value fo any key is not null
            // if it is not null then add that key and value in the queryParam object
            if (Objects.nonNull(v)) {
                queryParam.put(k, v);
            }
        });
        RestAssured.useRelaxedHTTPSValidation();
        responce = given()
                .baseUri("https://rickandmortyapi.com")
                .basePath("/api/character")
                .header("Accept", "application/json")
                .queryParams(queryParam)
                .log().all()
                .when().get();
        responce.prettyPrint();




    }

    @Then("I verify the response with status code {int}")
    public void iVerifyTheResponseWithStatusCode(int expectedStstusCode) {
        Assert.assertEquals(expectedStstusCode, responce.getStatusCode());

        int totalPages = responce.jsonPath().getInt("info.pages");
        for (int i = 1; i <= totalPages; i++) {
            queryParam.put("page", String.valueOf(i));
            responce = given()
                    .baseUri("https://rickandmortyapi.com")
                    .basePath("/api/character")
                    .header("Accept", "application/json")
                    .queryParams(queryParam)
                    .log().all()
                    .when().get();
            responce.prettyPrint();
            //deserialize the response into SamplePojo class
            SamplePojo samplePojo = responce.as(SamplePojo.class);

            //get the value from result
            List<Map<String, Object>> results = samplePojo.getResults();

            //iterate result list and check query params value in each object (Map<String, Object>)
            for (Map<String, Object> obj : results) {
                Set<String> keys = queryParam.keySet();
                queryParam.remove("page");
                for (String key : keys) {
                    String actualValue = obj.get(key).toString();
                    String expectedValue = queryParam.get(key);
                    if(key.equals("name")){
                        Assert.assertTrue(
                                actualValue.toLowerCase().contains(expectedValue.toLowerCase()));
                    }else{
                        Assert.assertEquals(expectedValue, actualValue);
                    }

                }
            }



        }
    }}




