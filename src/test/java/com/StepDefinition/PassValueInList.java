package com.StepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PassValueInList {


    @Given("launch the browser")
    public void launchTheBrowser(String name) {
        System.out.println("Given");
        String[] name1 = name.split(",");
        for (String empname : name1) {
            System.out.println(empname);
        }
    }


    @Then("Verify passing value")
    public void verifyPassingValue() {
        System.out.println("Then");
    }

    public void connectiing_the_url(List<String> dataTable) {
       for(String s:dataTable) {
           System.out.println(s);
       }
        throw new io.cucumber.java.PendingException();
    }



    @When("Pass in the object form")
    public void pass_in() throws Throwable {
        System.out.println("shbjaDFBHZXHNV HFX");
        throw new io.cucumber.java.PendingException();
    }


    @Given("Pass value in object form")
    public void pass_value_in_object_form(DataTable empDetails) {
        //System.out.println("Object form retrive the value");
       List<Map<String,String>> data= empDetails.asMaps();
       Map<String,String> map=data.get(0);
      String[] array=map.get("firstname").split(",");
      for (String arr:array){
          if(arr.startsWith("s")){
          System.out.println(arr);}else{
              System.out.println("empty");
          }
      }
       System.out.println(map.get("lastname"));

      System.out.println(map.get("emp"));


    }
}
