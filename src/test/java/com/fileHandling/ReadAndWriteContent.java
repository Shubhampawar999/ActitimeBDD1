package com.fileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWriteContent {

    public static void main(String[] args) throws IOException {

        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//"+"Hel.txt");
        FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"//"+"Shubham.txt");
try {
    int data;
    while ((data = fis.read()) != -1) {
        fos.write((char) data);
    }
}catch (IOException io){
    System.out.println("Handle the exception");
}finally {
    fos.close();
    fis.close();
}


    }
}
