package com.fileHandling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static com.fileHandling.AppendTextExistingFile.appendText;

public class FileAppend2 {

    public static void main(String[] args) throws IOException {

        System.out.println("Inside the main method and append file");

        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the file name");
        String filename=sc.nextLine();
        System.out.println("Please enter the file content");
        String fileContent=sc.nextLine();
        appendText(filename,fileContent);
    }
    public static void appendText(String filename,String fileContent) throws IOException {
        String path=System.getProperty("user.dir")+"//"+filename;
        System.out.println(path);

        FileWriter Fw=new FileWriter(path,true);
        Fw.write(fileContent);
        Fw.close();
    }
}
