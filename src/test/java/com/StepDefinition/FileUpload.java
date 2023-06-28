package com.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class FileUpload extends BaseClass{
    File file1;

    @Given("I prepare request Structure to upload file")
    public void setUpRequestStucture(){
        String fileName="C:/Users/shubham/OneDrive/Documents/shubham resume.docx";
        file1=new File(fileName);
responce=given().baseUri("https://postman-echo.com")
        .header("Content-Type", ContentType.MULTIPART.toString())
        .multiPart("file1",file1)
        .log()
        .all()
        .post("/post");
responce.prettyPrint();
    }

    @Then("I verify file is uploaded successfully")
    public void iVerifyFileIsUploadedSuccessfully() {
        Assert.assertEquals(200,responce.getStatusCode());

       Map<String,String> fileObjet= responce.jsonPath().getMap("files");
      Set<String> keys=  fileObjet.keySet();
     Object fileName =keys.toArray()[0];
        String actualkeys=String.valueOf(keys);
//To get the name of file and verify the actual result
       String expectedName= file1.getName();
       List<String> list=new ArrayList<>();
        list.add(expectedName);
        System.out.println(list);
       System.out.println(expectedName);

       Assert.assertEquals(actualkeys,expectedName);



    }
}
