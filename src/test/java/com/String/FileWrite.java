package com.String;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("C:\\Classroom\\shubham.txt1");
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write("Welcome shubham pawar file extention");
        bw.write("After commin alll getting break ");
        bw.write("Thank you");
        bw.close();

    }
}
