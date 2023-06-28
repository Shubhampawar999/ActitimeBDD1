package com.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static io.restassured.RestAssured.given;

public class VerifyXmlResponce extends BaseClass{

    @Given("I get all contacts info from get all api")
    public void getAllContact(){
        System.out.println("Get all contact from agileCRM");

//        Header header=new Header("Accept","application/json");
//        List<Header> headerList = new ArrayList<>();
//        headerList.add(header);
//
//        Headers headers= new Headers(headerList);

            responce=  given().baseUri("https://realestateautomation.agilecrm.com")
                      .basePath("/dev/api/contacts")
                      .auth().basic("automation@yopmail.com","2rm1jfdht83gov5qjbs7nbcckr")
                      .header("Accept","application/xml")
                      .log().all()
                      .when().get();
            responce.prettyPrint();


    }


    @Then("I verify first names in the response")
    public void iVerifyFirstNamesInTheResponse() {
      String firstName= responce.xmlPath().get("collection.contact[0].properties[0].value");
      System.out.println(firstName);
        int size =responce.body().xmlPath().getList("collection.contact").size();
        System.out.println(size);

        for(int i=0; i<size;i++){
            String xpath = "collection.contact["+i+"].properties[0].value";
            String first_name  =responce.body().xmlPath().getString(xpath);
            System.out.println(first_name);
        }


    }

    @Given("I get all users info from get all api")
    public void iGetAllUsersInfoFromGetAllApi() {
        responce=  given().baseUri("https://realestateautomation.agilecrm.com")
                .basePath("/dev/api/users")
                .auth().basic("automation@yopmail.com","2rm1jfdht83gov5qjbs7nbcckr")
                .header("Accept","application/xml")
                .log().all()
                .when().get();
        responce.prettyPrint();

    }

    @Then("I verify pic from responce")
    public void iVerifyPicFromResponce() throws IOException {
      int link=  responce.xmlPath().getList("TestRunner.domainUser.pic").size();
      System.out.println(link);

      for(int i=0;i<link;i++){
      String xpath="TestRunner.domainUser["+i+"].pic";

      String first_Name=responce.xmlPath().getString(xpath);
      System.out.println(first_Name);


      InputStream io=responce.asInputStream();

          FileOutputStream fileOutputStream=new FileOutputStream("Downloads");
          fileOutputStream.write(io.readAllBytes());
          fileOutputStream.flush();
          fileOutputStream.close();


      }

    }
}
