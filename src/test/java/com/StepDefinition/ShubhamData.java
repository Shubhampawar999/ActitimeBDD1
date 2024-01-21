package com.StepDefinition;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ShubhamData {

    public static void main(String[] args) {
        ObjectMapper mapper=new ObjectMapper();

        Shubham sh=new Shubham("Shubham","Satara","IT","Project Manager");

        try {

            mapper.writeValue(new File("target/shubham.json"),sh);

        }catch (final Exception e){
e.printStackTrace();
        }





    }
}
