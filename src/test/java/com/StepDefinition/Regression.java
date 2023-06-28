package com.StepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import pojo.PageIterate;
import pojo.PagePojo;
import pojo.newUserRegress;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static io.restassured.RestAssured.given;

public class Regression extends BaseClass {
    Map<String, String> map;
    int id;
    Map<String, Object> queryPara;
    List<PageIterate> list;
    org.json.JSONObject creatTaskPayLOad;


    @Given("I set up request structure and hit api")
    public void setup() throws IOException, ParseException {
//        System.out.println("Set UP");
//
//        String jsonFIlePath="src/test/resources/UsersData.json";
//        //code to read json content
//        JSONParser parser=new JSONParser();
//
//        //Read to json file
//        FileReader reader=new FileReader(jsonFIlePath);
//        //Parse the json file content
//       Object obj= parser.parse(reader);
//
//       JSONObject json=(JSONObject)obj;
//       System.out.println(json);
//
//
//        byte[] payload;
//        try {
//            payload = Files.readAllBytes(Path.of(jsonFIlePath)); // access the content from json file convert into byte array
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        map = new HashMap<>();
        map.put("name", "morpheus1");
        map.put("job", "leader1");
        System.out.println(map);

        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .basePath("/api/")
                .body(map)
                .log()
                .all();
    }

    @Then("I verify status code")
    public void iVerifyStatusCode() {
        Assert.assertEquals(201, responce.getStatusCode());
        Assert.assertEquals(map.get("name"), responce.jsonPath().getString("name"));
        Assert.assertEquals(map.get("job"), responce.jsonPath().getString("job"));

    }

    @Given("I set the request structure with name is empty")
    public void emptyName() throws IOException, ParseException {
        String jsonFIlePath = "src/test/resources/UsersData.json";
        //code to read json content
        JSONParser parser = new JSONParser();

        //Read to json file
        FileReader reader = new FileReader(jsonFIlePath);
        //Parse the json file content
        Object obj = parser.parse(reader);

        JSONObject json = (JSONObject) obj;
        System.out.println(json);


        byte[] payload;
        try {
            payload = Files.readAllBytes(Path.of(jsonFIlePath)); // access the content from json file convert into byte array
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .basePath("/api/")
                .body(payload)
                .log()
                .all();
    }


    @Given("I setup req str and featch all userse")
    public void setupthereq() {
//        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .basePath("/api/")
                .queryParams("page", 1)

                .log()
                .all();

    }

    @Then("I verify status code 200 and name print ascending order")
    public void verify() {
        Assert.assertEquals(200, responce.getStatusCode());

        String nameList = responce.jsonPath().getString("data.first_name");
        System.out.println(nameList);

        int totalPage = responce.jsonPath().getInt("total_pages");
        System.out.println(totalPage);

        for (int i = 0; i < totalPage; i++) {
            // Object query = queryPara.put("page", String.valueOf(i));

            requestSpecification = RestAssured.given();
            requestSpecification.baseUri("https://reqres.in")
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .basePath("/api/")
                    .queryParams("page", String.valueOf(i))

                    .log()
                    .all();
        }
//        Map<String,Object> obj = responce.jsonPath().get("data");

        PagePojo pageItr = responce.as(PagePojo.class);
        PageIterate page=responce.as(PageIterate.class);
      List< Map<String,Object>> obj= pageItr.getData();
      Object name=obj.get(0).get("name");
      System.out.println(name);







    }


    @Given("I set up the request Structure to download the file")
    public void iSetUpTheRequestStructureToDownloadTheFile() {
        requestSpecification = given();
        requestSpecification.baseUri("https://github.com/")
                .basePath("Harshad-Dange/actitime_apiautomation/raw/main/")
                .header("Accept", ContentType.ANY)
                .log()
                .all();


    }

    @Then("I verify responce code and {string} downloaded")
    public void iVerifyResponceCode(String fileName) throws IOException {
        InputStream inputStream=  responce.asInputStream();
        FileOutputStream outputStream = new FileOutputStream("/Users/shubham/OneDrive/Documents/Desktop/shubham all cyber notes/"+ fileName);
        outputStream.write(inputStream.readAllBytes());
        outputStream.flush();
        outputStream.close();

    }

    @Given("I set up req str and hit api")
    public void iSetUpReqStrAndHitApi() {
    }

    @Given("I setup req str and featch all users")
    public void iSetupReqStrAndFeatchAllUsers() {
    }

    @Given("I set up and hit api and featch all user name from all pages")
    public void iSetUpAndHitApiAndFeatchAllUserNameFromAllPages() {
        RestAssured.useRelaxedHTTPSValidation();
        responce = given()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .log().all()
                .when().get();
        responce.prettyPrint();


    }
////////////////////////////////verify dange sir////////////////////////////////////////////
    @Then("I verify name")
    public void iVerifyName() {
        Assert.assertEquals(200,responce.getStatusCode());
       int totalPage= responce.jsonPath().getInt("total_pages");
       //to find the total pagees from the responce
       System.out.println(totalPage);
       //Iterate the each page and get first name
        for(int i=1;i<=totalPage;i++) {
             list = responce.jsonPath().getList("data", PageIterate.class);
            responce = given()
                    .baseUri("https://reqres.in")
                    .basePath("/api/users")
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .queryParams("page",String.valueOf(i))
                    .log().all()
                    .when().get();
            responce.prettyPrint();}

            //Iterate form each object from PageIterate class
            for (PageIterate obj : list) {
                String Name1 = obj.getFirst_name();
                //get the first name from each object
                System.out.println(Name1);

        }

    }

    @Given("I set the request structure and hit api")
    public void iSetTheRequestStructureAndHitApi(Map<String,String> map) {
        String firstname=(map.get("first_name").equals("random")?new Faker().name().firstName():map.get("first_name"));
        String lastName=(map.get("last_name").equals("random")?new Faker().name().firstName():map.get("last_name"));
        String email=(map.get("email").equals("random")?firstname+"@gmail.com":map.get("email"));


        creatTaskPayLOad=new org.json.JSONObject();

        creatTaskPayLOad.put("firstname",firstname);
        creatTaskPayLOad.put("last_name",lastName);
        creatTaskPayLOad.put("email",email);
        creatTaskPayLOad.put("avatar",map.get("avatar"));

        responce = given()
                .baseUri("https://reqres.in")
                .basePath("/api")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(creatTaskPayLOad.toString())
                .log().all()
                .when().post("/users");
        responce.prettyPrint();
    }

    @Then("I verify new user created")
    public void iVerifyNewUserCreated() {
        Assert.assertEquals(201,responce.getStatusCode());
        newUserRegress newUserRegress= responce.as(newUserRegress.class);
       Assert.assertEquals(newUserRegress.getFirstname(),creatTaskPayLOad.get("firstname"));
       Assert.assertEquals(newUserRegress.getLast_name(),creatTaskPayLOad.get("last_name"));
        id=newUserRegress.getId();
    }

    @When("I get all users and verify the new users are created")
    public void iGetAllUsersAndVerifyTheNewUsersAreCreated() {
        responce = given()
                .baseUri("https://reqres.in")
                .basePath("/api")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .log().all()
                .queryParams("page",2)
                .when().get("/users");
        responce.prettyPrint();
    }

    @Then("I verify users getting created successfully")
    public void iVerifyUsersGettingCreatedSuccessfully() {

    }
}
// https://regress.in/img/faces/7-image.jpg