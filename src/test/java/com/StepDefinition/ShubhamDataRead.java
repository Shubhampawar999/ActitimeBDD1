package com.StepDefinition;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ShubhamDataRead {

    public static void main(String[] args) throws IOException {

        ObjectMapper obj=new ObjectMapper();
        String shubhamData="{\"name\":\"Shubham\",\"city\":\"Satara\",\"department\":\"IT\",\"desc\":\"Project Manager\"}";

        Shubham shubham=obj.readValue(shubhamData,Shubham.class);

        JsonNode jn=obj.readTree(shubhamData);

        String empname=jn.get("name").asText();
        String empcity=jn.get("city").asText();
        String empdepartment=jn.get("department").asText();
        String empdesc=jn.get("desc").asText();

        obj.writeValue(new File("target/empdata.txt"),empname+","+empcity+","+empdepartment+","+empdesc);



    }
}
