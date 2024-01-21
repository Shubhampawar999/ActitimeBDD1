package com.StepDefinition;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
import pojo.UserPayloadinActitime;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;


public class GetAllCustomer extends BaseClass{

    String endpoint="";
    String querypara;
    String pathPara;

    Response response;
    String username;
    String usernam;
    String firstName;
    Faker faker;
    String custName;
    int custId;


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
    requestSpecification.baseUri("https://online.actitime.com/cyber/timetrack/enter.do")
            .basePath("/api/v1")
            .header("Authorization","Basic YWRtaW46bWFuYWdlcg==")
            .header("Accept","application/json")
            .log()
            .all();
    //check query parameter is not null
    if(Objects.nonNull(data)){
        requestSpecification.queryParams(data);
        //Actitime applicaton new reg url="https://online.actitime.com/cyber/timetrack/enter.do"
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
    @Given("I set up request str to add new users")
    public void iSetUpRequestStrToAddNewUsers() {
        System.out.println("Adding newly user in actitime application and verify it");
      Map<String,String> body=new HashMap<>();
       faker=new Faker();
      //Write the name using Faker Dependencies
       usernam=faker.name().firstName();
       System.out.println(usernam);
        firstName=faker.name().firstName();
      String emaile=faker.name().firstName();
      String email=emaile+"@gmail.com";
      String username=usernam+"@12345";
      body.put("firstName",firstName);
      body.put("lastName","Pawar");
        body.put("email",email);
        body.put("username",username);
        body.put("password","pawar@1234");

        System.out.println(body);
      //  RequestSpecification is an interface that allows you to specify how the request will look like. This
        //  interface has readymade methods to define base URL, base path, headers, etc. We need to use given ()
        //  method of RestAssured class to get a reference for RequestSpecification.
        requestSpecification = given();
        requestSpecification.baseUri("https://online.actitime.com/cyber/login.do/api/v1/")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .contentType("application/json")
                .header("Authorization","Basic c2h1YmhhbXBhd2FyNzE5M0BnbWFpbC5jb206U2h1YmhhbUAxMjM0")
                .body(body)
                .log()
                .all();

    }
    @When("I hit the restful api and passing the data using dataTable")
    public void iHitTheRestfulApiAndPassingTheDataUsingDataTable(Map<String,String> methodNam) {
        String methodName = methodNam.get("methodName");
        String endpoint = methodNam.get("endPoint");
        if (methodName.equals("GET")) {
            if (endpoint != null) {
                responce = requestSpecification.get("/" + endpoint);
            }
        } else if (methodName.equals("POST")) {
            if (endpoint != null) {
                responce = requestSpecification.post("/" + endpoint );
            }
        }
        responce.prettyPrint();
    }
    @Then("I verify successfully add new user name or  not")
    public void iVerifySuccessfullyAddNewUserNameOrNot() {
        System.out.println("Verify the user added successfully or not");
        Assert.assertEquals(200,responce.getStatusCode());
       long time= responce.getTime();
       System.out.println(time);
    }
    //Verify newly added users success fully or not using get http method
    @Given("I set up the request structure to featch all customer detils")
    public void iSetUpTheRequestStructureToFeatchAllCustomerDetils() {
        requestSpecification = given();
        requestSpecification.baseUri("https://online.actitime.com/cyber/login.do/api/v1/")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .contentType("application/json")
                .header("Authorization","Basic c2h1YmhhbXBhd2FyNzE5M0BnbWFpbC5jb206U2h1YmhhbUAxMjM0")
                .log()
                .all();
    }
    @When("I hit the restul api and getting all uses")
    public void iHitTheRestulApiAndGettingAllUses(Map<String,String> methodNam) {
       String methodName=methodNam.get("methodName");
       String endpoint=methodNam.get("endpoint");
       if(methodName.equals("GET")){
           if(endpoint!=null){
               responce = requestSpecification.get("/" + endpoint);
           }
       } else if (methodName.equals("POST")) {
           if(endpoint!=null){
               responce = requestSpecification.post("/" + endpoint);
           }
       }
          responce.prettyPrint();
       System.out.println("Print the responce using pretty print method this is static method for responce class");
    }
    @Then("I verify added successfully newly user or not")
    public void iVerifyAddedSuccessfullyNewlyUserOrNot() {

        System.out.println("How to write verify logic using java 8 features");
        Assert.assertEquals(200,responce.getStatusCode());
       List<Map<String,String>> usernam= responce.jsonPath().get("items");
       System.out.println(usernam);
       //Declare one flage variable and assign default value is false and write the logic and check user added successsfully or not
       boolean actualValue=false;
        for(Map<String,String> name:usernam){
         String usName=name.get("username");
         System.out.println(usName);
         usName.equals(usernam);
            actualValue=true;
       }
        Assert.assertTrue(actualValue);
        System.out.println("Added users successfully");
        System.out.println(usernam);
//Verifyng added newly firstname or not using enhance for loop
        boolean actualfirstName=false;
      List<Map<String,String>> firstNameData= responce.jsonPath().get("items");
        for(Map<String,String> firstNameList:firstNameData){
           String firstNamel= firstNameList.get("firstName");
//           System.out.println(firstName);
            firstNamel.equals(firstName);
            actualfirstName=true;
        }
        Assert.assertTrue(actualfirstName);
        System.out.println("Added successfully users firstname");
    }

    @And("I deleted the newly created customer")
    public void iDeletedTheNewlyCreatedUser() {
        String custName=faker.name().firstName();
        boolean archive=false;
        String description=faker.name().title();
        ObjectMapper obj=new ObjectMapper();
        JSONObject js=new JSONObject();
        js.put("name",custName);
        js.put("archived",archive);
        js.put("description",description);
        System.out.println(js);

        requestSpecification = given();
        requestSpecification.baseUri("https://online.actitime.com/cyber/login.do/api/v1/")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .contentType("application/json")
                .header("Authorization","Basic c2h1YmhhbXBhd2FyNzE5M0BnbWFpbC5jb206U2h1YmhhbUAxMjM0")
                .body(js.toString())
                .log()
                .all();
    }
    @When("I hit the apiii")
    public void iHitTheApiii(DataTable table) {
Map<String,String> methodName=table.asMaps().get(0);
        String MethodName=methodName.get("methodName");
        String endPoint=methodName.get("endPoint");

        if(MethodName.equals("GET")){
            if(endPoint!=null){
               responce=requestSpecification.get("/"+endPoint);
            }
        } else if (MethodName.equals("POST")) {
            if(endPoint!=null){
               responce= requestSpecification.post("/"+endPoint);
            }
        }
        responce.prettyPrint();
    }
    @Then("I verifying newly created user deleted or not")
    public void iVerifyingNewlyCreatedUserDeletedOrNot() {
        Assert.assertEquals(200,responce.getStatusCode());
     long responceTime=  responce.getTime();
     System.out.println(responceTime);
      custId=responce.jsonPath().getInt("items.id");
     System.out.println(custId);

    }

    @And("I updationg the newly created user")
    public void iUpdationgTheNewlyCreatedUser() {
        String name="Shubham";
        requestSpecification=given();

        requestSpecification.baseUri("https://online.actitime.com/cyber/login.do/api/v1/")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .contentType("application/json")
                .header("Authorization","Basic c2h1YmhhbXBhd2FyNzE5M0BnbWFpbC5jb206U2h1YmhhbUAxMjM0")
                .body(name)
                .log()
                .all();
    }
    @When("I set up the request and verifying the responce")
    public void iSetUpTheRequestAndVerifyingTheResponce(DataTable table) {
      Map<String,String> map= table.asMaps().get(0);
      String methodName=map.get("methodName");
      String endPoint=map.get("endPoint");
      if(methodName.equals("GET")){
          if(endPoint!=null){
            responce= requestSpecification.get("/"+endPoint);
          }
      } else if (methodName.equals("POST")) {
          if(endPoint!=null){
              responce=requestSpecification.post("/"+endPoint);
          }
      } else if (methodName.equals("PATCH")) {
          if(endPoint!=null){
              responce=requestSpecification.patch("/"+endPoint);
          }
      }
      responce.prettyPrint();
    }


    @Given("I down the file in innerclass folder")
    public void iDownTheFileInInnerclassFolder() {
        response = given()
                .baseUri("https://reqres.in")
                .basePath("/img/faces")
                .header("Accept", ContentType.ANY)
                .log().all()
                .when().get("/7-image.jpg");
        response.prettyPrint();
    }

    @Then("I verify the responce file downlad successfully or not")
    public void iVerifyTheResponceFileDownladSuccessfullyOrNot() {
        byte[] inputByteArray=  response.asByteArray();
try{
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\shubham\\IdeaProjects\\ActitimeBDD\\src\\test\\java\\innerclasss.jpg");
        outputStream.write(inputByteArray);
        outputStream.flush();
        outputStream.close();}catch(IOException c){
    c.printStackTrace();
        }
    }
}


