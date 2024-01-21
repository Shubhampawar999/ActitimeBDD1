package com.StepDefinition;

import com.github.javafaker.Faker;
import config.ApiRequestBuilder;
//import config.PropertyHandler;
//import entities.CustomerDetails;
//import entities.DesrCustomer;
import config.PropertyHandler;
import entities.CustomerDetails;
import entities.DesrCustomer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.json.JSONObject;
import org.junit.Assert;
import pojo.Customer;
import pojo.CustomerPayload;
import pojo.InvalidName;
import pojo.Usertype;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static io.restassured.RestAssured.given;

public class CreatCustomer extends BaseClass {
    public Map<String, String> userdata;
    public String username;
    public JSONObject creatCustomerPayload;
    public Integer projectId;

    public String name;
    public Customer custpojo;
    public CustomerPayload customerpayload;

    public CustomerDetails customerDetails;

    public String namepayload;
    public Integer custid;

    public String custName;

    ApiRequestBuilder requestBuilder = ApiRequestBuilder.getInstance();


    @Given("I set up the request structure to creat customer")
    public void setUp(DataTable table) {
        System.out.println("I set up the request structure and creat the new customer");

        String customerName = table.asMaps().get(0).get("name");

        String responceBody = "{\n" +
                "  \"name\":\"" + customerName + "\",\n" +
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
                .all()
        ;


    }

    @When("I hit a api")
    public void hitApi(DataTable table) {
        System.out.println("i hit the Api");
        String methodName = table.asMaps().get(0).get("method");
        System.out.println(methodName);

        String endpoint = table.asMaps().get(0).get("endPoint");
        if (methodName.equals("GET")) {
            if (endpoint != null) {

                responce = requestSpecification.get("/" + endpoint);
            }
        } else if (methodName.equals("POST")) {
            System.out.println(methodName);
            if (endpoint != null) {

                responce = requestSpecification.post("/" + endpoint);
            }


        }
        responce.prettyPrint();
    }


    @Then("I verify customer getting created successfully withName {string}")
    public void iVerifyCustomerGettingCreatedSuccessfullyWithName(String CustName) {
        System.out.println("verify the cust created Successfully");
        Assert.assertEquals(200, responce.getStatusCode());

        //verify customer id
        int customerId = responce.jsonPath().getInt("id");
        System.out.println(customerId);

        //verify customer name
        String custName = responce.jsonPath().getString("name");
        System.out.println(custName);


        //verify archived is false
        Assert.assertFalse(responce.jsonPath().getBoolean("archived"));

        //verify description is null or not
        boolean actualDescription = false;
        if (Objects.isNull(responce.jsonPath().get("description")))
            actualDescription = true;
        Assert.assertTrue(actualDescription);


    }

    @Then("I verify added successfully")
    public void iVerifyAddedSuccessfully() {
        Assert.assertEquals(200, responce.getStatusCode());
//       String customerId1=String.valueOf(customerId);
//       Integer allcustId= responce.jsonPath().getInt("id");
//       String csId=allcustId.toString();
//       System.out.println(allcustId);
//        boolean actualcustomerId=false;
//        if(csId.equals(customerId1))
        //actualcustomerId=true;


        // Assert.assertTrue(actualcustomerId);
    }

    @Given("I set up the request structure to creat project")
    public void iSetUpTheRequestStructureToCreatProject(DataTable table) {
        String projectName = table.asMaps().get(0).get("projectName");
        System.out.println(customerId);
        String custId = String.valueOf(customerId);
        System.out.println(custId);
        String responceBody = "{" + "\n" +
                "      \"customerId\":\"" + custId + "\",\n" +
                "         \"name\": \"" + projectName + "\",\n" +
                "       \"archived\":\"" + false + "\",\n" +
                "       \"description\": null\n"
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

    @Then("I verify project getting created successfully withName {string}")
    public void iVerifyProjectGettingCreatedSuccessfullyWithName(String projectName) {
        Assert.assertEquals(200, responce.getStatusCode());
        String projName = responce.jsonPath().getString("name");
        //System.out.println(projName);
        // String pn=projName.toString();
        boolean actualprojName = false;
        if (projName.equals(projectName)) {
            System.out.println(projName);

            actualprojName = true;
        }
        Assert.assertTrue(actualprojName);

        Integer cuId = responce.jsonPath().getInt("customerId");

        boolean ActualCustId = false;
        if (cuId.equals(customerId)) {
            System.out.println(cuId);
            ActualCustId = true;
        }
        Assert.assertTrue(ActualCustId);
        Assert.assertFalse(responce.jsonPath().getBoolean("archived"));

        Assert.assertTrue(Objects.isNull(responce.jsonPath().get("description")));

    }


    @Given("I set up the request structure to create customer")
    public void iSetUpTheRequestStructureToCreateCustomer(DataTable table) {

        String data = table.asMaps().get(0).get("name");

        String responceBody = "{\n" +
                "  \"name\":\"" + data + "\",\n" +
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

    @Then("I verify statuscode as {int} and verify error message")
    public void iVerifyStatuscodeAsAndVerifyErrorMessage(int statusCode, Map<String, String> data) {
//verify status code
        Assert.assertEquals(statusCode, responce.getStatusCode());

        String msg = data.get("message");

//verify erro msg
        Assert.assertEquals(msg, responce.jsonPath().get("message"));


    }

    @Given("I verify customer should not be created when missing name")
    public void iVerifyCustomerShouldNotBeCreatedWhenMissingName(DataTable data) {
        String cusData = data.asMaps().get(0).get("name");
        String responceBody;
        if (Objects.isNull(cusData)) {
            responceBody = "{\n" +
                    "    \"name\": null\n" +
                    "}";
        } else if (cusData.equals("empty")) {
            responceBody = "{\n" +
                    "    \"name\": \"\"\n" +
                    "\n" +
                    "}";
        } else {
            responceBody = "{\n" +
                    "  \"name\":\"" + cusData + "\",\n" +
                    "         \"archived\": false\n"
                    + "}";
        }


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

    @Then("I verify status code {int}")
    public void iVerifyStatusCode(int statusCode, DataTable errorMsg) {
        Assert.assertEquals(statusCode, responce.getStatusCode());
        Map<String, String> errorMsg1 = errorMsg.asMaps().get(0);
        String errName = errorMsg1.get("errormsg");
        Assert.assertEquals(errName, responce.jsonPath().get("message"));

    }

    @Given("I verify customer should be created when archived should be blank")
    public void iVerifyCustomerShouldBeCreatedWhenArchivedShouldBeBlank(DataTable custData) {
        Map<String, String> data = custData.asMaps().get(0);
        // System.out.println(data);
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                //.header("Authorization","Basic YWRtaW46bWFuYWdlcg==")
                //.header("Accept","application/json")
                //.header("Content-Type","application/json")
                .body(data)
                .log()
                .all();
    }

    @Then("I verify the archive value")
    public void iVerifyTheArchiveValue(Boolean archiveValue) {
        Assert.assertFalse(responce.jsonPath().getBoolean("archived"));
        Assert.assertEquals(200, responce.getStatusCode());
    }


    @Then("I verify errormsg and status code {int}")
    public void iVerifyErrormsgAndStatusCode(int statusCode, Map<String, String> endPointerrorMsg) {
        Assert.assertEquals(statusCode, responce.getStatusCode());
        String errorMsg = endPointerrorMsg.get("errorMsg");

        Assert.assertEquals(errorMsg, responce.jsonPath().get("message"));
    }

    @Then("I verify error massage and statusCode {int}")
    public void iVerifyErrorMassageAndStatusCode(int statusCode, Map<String, String> payLoaderrorMsg) {
        String reqBodyerrormsg = payLoaderrorMsg.get("errorMsg");
        //Verify status code
        Assert.assertEquals(statusCode, responce.getStatusCode());

        Assert.assertEquals(reqBodyerrormsg, responce.jsonPath().get("message"));

        System.out.println(customerId);


    }

    @Given("I verify project should be created when projectname should be empty")
    public void iVerifyProjectShouldBeCreatedWhenProjectnameShouldBeDuplicate(Map<String, String> projdata) {

        String projName = projdata.get("name");
        String CustomerId = projdata.get("customerId");
        String description = projdata.get("description");
        String reqbody1;
        if (Objects.isNull(CustomerId)) {
            reqbody1 = "{\n" +
                    "    \"customerId\": \"\",\n" +
                    "    \"name\": \"" + projName + "\",\n" +
                    "    \"description\": \"" + description + "\"\n" +
                    "}";
        } else if (projName.equals("empty")) {
            reqbody1 = "{\n" +
                    "    \"customerId\": \"" + CustomerId + "\",\n" +
                    "    \"name\": \"\",\n" +
                    "    \"description\": \"" + description + "\"\n" +
                    "}";


            RestAssured.useRelaxedHTTPSValidation();
            requestSpecification = given();
            requestSpecification.baseUri("https://demo.actitime.com/")
                    .basePath("/api/v1")
                    .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(reqbody1)
                    .log()
                    .all();

        }
    }

    @Then("I verify the errormsg and status code {int}")
    public void iVerifyTheErrormsgAndStatusCode(int statusCode, String errormsg) {
        Assert.assertEquals(statusCode, responce.getStatusCode());

        Assert.assertEquals(errormsg, responce.jsonPath().get("message"));
      long time= responce.getTime();
      System.out.println(time);
    }

    @Given("I verify project should be created when projectName should be duplicate")
    public void iVerifyProjectShouldBeCreatedWhenCustIdShouldBeEmpty(Map<String, Object> projectData) {
        System.out.println(projectData);
        Map<String,Object> archiv=new HashMap<>();
        archiv.put("archived",false);
        archiv.putAll(projectData);
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(projectData)
                .log()
                .all();
//        Map<String,String> randomusname=new HashMap<>();
//        randomusname.put("username",username);
//        userdata.putAll(randomusname);
//        System.out.println(userdata);

    }

    @Given("I verify user should be created successfully")
    public void iVerifyUserShouldBeCreatedSuccessfully(DataTable data) {
        System.out.println("creat user");
        userdata = data.asMaps().get(0);
        System.out.println(userdata);
        username = new Faker().company().name();
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.putAll(userdata);
        System.out.println(map);

        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(map)
                .log()
                .all();

    }

    @Then("I verify user should be created successfullye")
    public void iVerifyUserShouldBeCreatedSuccessfullye() {
        //veerify the status code
        Assert.assertEquals(200, responce.getStatusCode());
        //verify first name
        Assert.assertEquals(userdata.get("firstName"), responce.jsonPath().getString("firstName"));
        //verify last name
        Assert.assertEquals(userdata.get("lastName"), responce.jsonPath().getString("lastName"));
        //verify emailid
        Assert.assertEquals(userdata.get("email"), responce.jsonPath().getString("email"));
        //verify username
        Assert.assertEquals(username, responce.jsonPath().getString("username"));
        //verify allowedActions
        Assert.assertTrue(responce.jsonPath().getBoolean("allowedActions.canSubmitTimetrack"));


    }

    @And("I verify get all user featch successfully")
    public void iVerifyGetAllUserFeatchSuccessfully() {

        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .log()
                .all();

    }

    @Then("I verify user add to be successfully")
    public void iVerifyUserAddToBeSuccessfully() {
        Assert.assertEquals(200, responce.getStatusCode());

        List<String> usName = responce.jsonPath().getList("items.username");
        boolean actualusernameres = false;

        for (String username1 : usName) {
            if (username1.equals(username)) {
                System.out.println(username1);
                actualusernameres = true;
            }
        }

        Assert.assertTrue(actualusernameres);
    }

    @Given("I set up the request structure to featch all user detailss")
    public void iSetUpTheRequestStructureToFeatchAllUserDetailss(Map<String, String> data1) {

        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .log()
                .all();
        //check query parameter is not null
        if (Objects.nonNull(data1)) {
            requestSpecification.queryParams(data1);
        }
    }

    @Then("I verify filtering the data successfully")
    public void iVerifyFilteringTheDataSuccessfully() {
        List<Boolean> activeval = responce.jsonPath().get("items.active");
        System.out.println(activeval);


    }

    @Given("I add new user using json object")
    public void iAddNewUserUsingJsonObject(Map<String,Boolean> archiivedName) {
        creatCustomerPayload = new JSONObject();
        creatCustomerPayload.put("name", new Faker().name().firstName());
        creatCustomerPayload.put("archived",archiivedName.get("archived"));
        System.out.println(creatCustomerPayload);


        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(creatCustomerPayload.toString())
                .log()
                .all();
    }

    @Then("I verify cust id")
    public void iVerifyCustId() {

        Assert.assertEquals(200, responce.getStatusCode());
        customerId = responce.jsonPath().get("id");
    }

    @And("I add new project")
    public void iAddNewProject() {
        JSONObject creatProjectPayload = new JSONObject();
        creatProjectPayload.put("customerId", customerId);
        creatProjectPayload.put("name", new Faker().name().firstName());

        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(creatProjectPayload.toString())
                .log()
                .all();

    }

    @Then("I verify proj id")
    public void iVerifyProjId() {
        Assert.assertEquals(200, responce.getStatusCode());
        projectId = responce.jsonPath().get("id");
    }

    @And("I creat new task")
    public void iCreatNewTask() {
        JSONObject creatTaskPayLOad = new JSONObject();
        creatTaskPayLOad.put("projectId", projectId);
        creatTaskPayLOad.put("name", new Faker().company().name());

        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(creatTaskPayLOad.toString())
                .log()
                .all();
    }

    @Given("I verify user getting created using pojo successfully")
    public void iVerifyUserGettingCreatedUsingPojoSuccessfully() {

        Usertype payload = new Usertype();
        String firstName = new Faker().name().firstName();
        payload.setfirstName(firstName);
        payload.setLastName(new Faker().name().lastName());
        payload.setEmail(firstName + "@yogmail.com");
        payload.setUsername(firstName);
        payload.setPassword("12345678");
        System.out.println(payload);
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(payload)
                .log()
                .all();
    }

    @Given("I verify user getting created")
    public void iVerifyUserGettingCreated() throws IOException {

        String jsonFilePath = "src/test/resources/createcustomerpayload.json";
        FileReader reader = new FileReader(new File(jsonFilePath));

        byte[] payload = Files.readAllBytes(Path.of(jsonFilePath));
        System.out.println(payload);


    }

    @Given("I verify users should be created successfully")
    public void iVerifyUsersShouldBeCreatedSuccessfully(DataTable table) {

        Map<String, String> datatable = table.asMaps().get(0);
        custpojo = new Customer();
        name = new Faker().name().firstName();
        custpojo.setName(name);
        custpojo.setDescription(name);
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(custpojo)
                .log()
                .all();


    }

    @Then("I verify responce and status code {int}")
    public void iVerifyResponceAndStatusCode(int expectedStatusCode) {
        Assert.assertEquals(200, responce.getStatusCode());
        Assert.assertEquals(custpojo.getName(), responce.jsonPath().getString("name"));
        Assert.assertEquals(custpojo.getDescription(), responce.jsonPath().getString("description"));
        customerId = responce.jsonPath().getInt("id");
        System.out.println(customerId);
    }

    @And("I update the newly created user")
    public void iUpdateTheNewlyCreatedUser1(DataTable table) {
        Map<String, String> datatable = table.asMaps().get(0);
        String name1 = new Faker().name().title();

        if (datatable.get("name").equals("random")) {
            custpojo.setName(new Faker().name().bloodGroup());
        } else if (datatable.get("description").equals("random")) {
            custpojo.setDescription(name1);
        }
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(custpojo)
                .log()
                .all();

//           if(datatable.get("pathpara").equals("customerId")){
//               requestSpecification.pathParam("goRestCustomerId", customerId);
//           }
    }


    @When("I hit the api cust")
    public void iUpdateTheNewlyCreatedUser(DataTable table) {
        System.out.println("i hit the Api");
        String methodName = table.asMaps().get(0).get("method");
        System.out.println(methodName);//pathpara
        String pathpara = table.asMaps().get(0).get("pathpara");

        String endpoint = table.asMaps().get(0).get("endPoint");
        if (methodName.equals("GET")) {
            if (endpoint != null) {

                responce = requestSpecification.get("/" + endpoint);
            }
        } else if (methodName.equals("POST")) {
            System.out.println(methodName);
            if (endpoint != null) {

                responce = requestSpecification.post("/" + endpoint);
            }


        } else if (methodName.equals("PATCH")) {
            System.out.println(methodName);
            if (endpoint != null) {
                if (Objects.isNull(pathpara)) {
                    responce = requestSpecification.patch("/" + endpoint);
                } else {
                    requestSpecification.pathParam("goRestCustomerId", customerId);
                    responce = requestSpecification.patch("/" + endpoint + "/" + "{goRestCustomerId}");

                }
            }
            responce.prettyPrint();
        }
    }


    @Then("I verify status cust code {int}")
    public void iVerifyStatusCustCode(int arg) {

        Assert.assertEquals(arg, responce.getStatusCode());
    }

    @And("I verify customer is empty")
    public void iVerifyCustomerIsEmpty(Map<String, String> map) {
        System.out.println(map.get("name"));
        InvalidName invalidpogo = new InvalidName();
        if (Objects.isNull(map.get("name"))) {
            invalidpogo.setName(null);
        }
        System.out.println(invalidpogo);
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(invalidpogo)
                .log()
                .all();
    }

    @Then("verify error msg")
    public void verifyErrorMsg(String errorMsg) {
        Assert.assertEquals(400, responce.getStatusCode());
        Assert.assertEquals(errorMsg, responce.jsonPath().getString("message"));
    }

    @Given("I set the request structure to ceate customer payload")
    public void iSetTheRequestStructureToCeateCustomerPayload(DataTable table) {
        Map<String, String> datatable = table.asMaps().get(0);
        customerpayload = new CustomerPayload();
        String name = (datatable.get("name").equals("random") ? new Faker().name().firstName() : datatable.get("name"));
        customerpayload.setName(name);

        Optional.ofNullable(datatable.get("archived"))
                .ifPresentOrElse(val -> {
                    boolean archived = Boolean.parseBoolean(val);
                    customerpayload.setArchive(archived);
                }, () -> System.out.println("Empty value of archived"));
        System.out.println(custpojo);
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(customerpayload)
                .log()
                .all();
    }
    @Then("I verify responcee and status code {int}")
    public void iVerifyResponceeAndStatusCode(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, responce.getStatusCode());
        Assert.assertEquals(customerpayload.getName(), responce.jsonPath().getString("name"));
        customerId = responce.jsonPath().getInt("id");
        System.out.println(customerId);
    }
    @When("I delet the customer")
    public void iDeletTheCustomer() {
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        given().baseUri("https://demo.actitime.com/")
                .basePath("/api/v1/customers")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(customerpayload)
                .pathParam("customerId", customerId)
                .log()
                .all()
                .delete("{customerId}")
                .then().assertThat().statusCode(204);

    }

    @And("I set the request structure to creat project")
    public void iSetTheRequestStructureToCreatProject(DataTable table) {
        Map<String, String> datatable = table.asMaps().get(0);
        String name = datatable.get("name").equals("random") ? new Faker().name().title() : datatable.get("name");
        CustomerPayload customerPayload = new CustomerPayload();
        customerPayload.setName(name);


        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("graphql/")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(customerPayload)
                .body(customerPayload)
                .log()
                .all();


    }

    @Given("I setUp the req str")
    public void iSetUpTheReqStr(Map<String, String> data) throws IOException {
        PropertyHandler property = new PropertyHandler("endpoint.properties");
        String endpoint = property.getProperty(data.get("data"));
        //Builder Pattern
        customerDetails = CustomerDetails.builder()
                .name(new Faker().company().name())
                .description("Sample Desc")
                .build();
        requestBuilder.postRequest(customerDetails, endpoint);
        requestBuilder.response.prettyPrint();
        customerId = requestBuilder.response.jsonPath().getInt("id");
    }


    @Then("I get the all user")
    public void iGetTheAllUser(Map<String, Object> query) throws IOException {
        PropertyHandler property = new PropertyHandler("endpoint.properties");
        String endpoint = property.getProperty("customers");
        System.out.println(endpoint);

        requestBuilder.getRequestWithQueryParam(query, endpoint);
    }
    @And("I verify all users")
    public void iVerifyAllUsers() {
        requestBuilder.response.prettyPrint();
        DesrCustomer desrCustomer = DesrCustomer.builder().build();
        List<DesrCustomer> d = requestBuilder.response.jsonPath().getList("items", DesrCustomer.class);
        List<DesrCustomer> expectedList = new ArrayList<>();
        expectedList.addAll(d);
        Comparator<DesrCustomer> comparator = new Comparator<>() {
            @Override
            public int compare(DesrCustomer o1, DesrCustomer o2) {
                return o1.getId() - o2.getId();
            }
        };
        Collections.sort(expectedList, comparator);
        System.out.println(expectedList);

        Assert.assertEquals("Verify sortingList or not", d, expectedList);
    }
    @Given("I setUp req structure")
    public void iSetUpReqStructure() throws IOException {
        PropertyHandler property = new PropertyHandler("endpoint.properties");
        String endpoint = property.getProperty("customers");

        String filepath = System.getProperty("user.dir") + "/src/test/resources/UsersData.json";
        System.out.println(filepath);
        requestBuilder.setFile(filepath, endpoint);
        requestBuilder.response.prettyPrint();
        namepayload = requestBuilder.response.jsonPath().getString("name");
        custid = requestBuilder.response.jsonPath().getInt("id");
    }
    @When("Verify the newly creat user successfully")
    public void verifyTheNewlyCreatUserSuccessfully() throws IOException {
        PropertyHandler propertyHandler = new PropertyHandler("endpoint.properties");
        String endpoint = propertyHandler.getProperty("customers");
        requestBuilder.getAll(endpoint);
        requestBuilder.response.prettyPrint();
        List<String> str = requestBuilder.response.jsonPath().getList("items.name");

        boolean flag = false;
        for (String name : str) {
            if (name.equals(namepayload)) {
                flag = true;
            }
        }
        Assert.assertTrue(flag);
        System.out.println(custid);
        List<Integer> id = requestBuilder.response.jsonPath().getList("items.id");
        System.out.println(id);

        //Verify newly created ids is verifying or not
        boolean actualResult = false;
        for (Integer ids : id) {
            if (ids.equals(custid)) {
                actualResult = true;
            }
        }
        Assert.assertTrue(actualResult);
    }

    @Given("I setUp newly creat request")
    public void iSetUpNewlyCreatRequest() throws IOException {
        PropertyHandler propertyHandler = new PropertyHandler("endpoint.properties");
        String endpoint = propertyHandler.getProperty("customers");
        String customerName = new Faker().name().firstName();
        String responceBody = "{\n" +
                "  \"name\":\"" + customerName + "\",\n" +
                "         \"archived\": false\n"
                + "}";

        requestBuilder.setStringBody(responceBody, endpoint);
        requestBuilder.response.prettyPrint();
    }

    @Then("I verify the newly created customer")
    public void iVerifyTheNewlyCreatedCustomer() {
        Assert.assertEquals(200, requestBuilder.response.getStatusCode());
        custName = requestBuilder.response.jsonPath().getString("name");
        System.out.println(custName);
        custid = requestBuilder.response.jsonPath().getInt("id");
    }

    @And("I verify newly created customer")
    public void iVerifyNewlyCreatedCustomer() throws IOException {
        PropertyHandler propertyHandler = new PropertyHandler("endpoint.properties");
        String endpoint = propertyHandler.getProperty("customers");
        requestBuilder.getAll(endpoint);
        requestBuilder.response.prettyPrint();
    }

    @Then("I verify")
    public void iVerify() {
        Assert.assertEquals(200, requestBuilder.response.getStatusCode());
        List<String> nameList = requestBuilder.response.jsonPath().getList("items.name");
        boolean actualName = false;
        for (String namecu : nameList) {
            if (namecu.equals(custName)) {
                actualName = true;
            }
        }
        Assert.assertTrue(actualName);

        List<Integer> ids = requestBuilder.response.jsonPath().getList("items.id");
        boolean actualid = false;
        for (Integer ide : ids) {
       if(ide.equals(custid)){
           actualid=true;
           }
        }
        Assert.assertTrue(actualid);
        System.out.println("Verify the test cases for name and ides");
    }

}