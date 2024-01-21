package com.searialisationanddesc;

import com.StepDefinition.Shubham;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class EmpData {


    public static void main(String[] args) throws IOException {

        ObjectMapper obj=new ObjectMapper();

        emp e=new emp("Shubham","Pawar","Satara","It");

        obj.writeValue(new File("target/data.json"),e);

        String empData="{\"name\":\"Shubham\",\"lastname\":\"Pawar\",\"city\":\"Satara\",\"dept\":\"It\"}";

        emp shubham=obj.readValue(empData,emp.class);


        JsonNode jn=obj.readTree(empData);
        String empname=jn.get("name").asText();
        String empcity=jn.get("lastname").asText();
        String empdepartment=jn.get("city").asText();
        String empdesc=jn.get("dept").asText();

        obj.writeValue(new File("target/empdata2.txt"),empname+","+empcity+","+empdepartment+","+empdesc);


    }
}
