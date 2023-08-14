package com.fileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCopy {


    public static void main(String[] args) throws FileNotFoundException {
        String pathFile=System.getProperty("user.dir")+"//"+"Hello.txt";
        System.out.println(pathFile);

        FileInputStream inputStream=new FileInputStream(pathFile);
        try {
            int data;
            while ((data = inputStream.read()) !=-1){
                System.out.println(data);


            }
        }catch(Exception e){

        }


    }
}
