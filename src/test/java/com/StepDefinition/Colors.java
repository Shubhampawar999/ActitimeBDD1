package com.StepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;

public class Colors {




    @Given("I give a input in list format")
    public void i_give_a_input_in_list_format() {
System.out.println("clor");

    }

    @Given("I give the name in list format")
    public void iGiveTheNameInListFormat(DataTable name) {
       List<String> list= name.asList();
       for(String s:list){
           System.out.println(s);
       }

    }
}
