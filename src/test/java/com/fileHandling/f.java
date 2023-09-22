package com.fileHandling;

import java.io.File;
import java.io.IOException;

public class f{

    public static void main(String[] args) throws IOException {
String fileName="C:\\Classroom\\shubham1.txt";
        File file=new File(fileName);
        if(file.exists()){
            System.out.println("File Already exists");
        }else if(file.createNewFile()){
            System.out.println("Successfully New Created file");
        }
    }
}
