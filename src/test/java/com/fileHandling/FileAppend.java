package com.fileHandling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileAppend {
    public static void main(String[] a) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the file name");
       String fileName= sc.nextLine();
       System.out.println("Enter the file content");
       String fileContent=sc.nextLine();
       file(fileName,fileContent);
    }

    public static void  file(String fileName,String fileContent) throws IOException {
        FileWriter fw=new FileWriter(fileName,true);
        try{
            fw.write(fileContent);
        }catch (Exception e){
            System.out.println("Handling the exception");
        }finally {
            fw.close();
        }
    }
}
