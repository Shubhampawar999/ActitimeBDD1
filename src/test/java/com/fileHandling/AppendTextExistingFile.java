package com.fileHandling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppendTextExistingFile {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter file name");
        String fileName= sc.nextLine();
    


        System.out.println("Please enter file content");
        String fileContent=sc.nextLine();

        appendText(fileName,fileContent);
    }

    public static void appendText(String fileName,String fileContent){

        String path=System.getProperty("user.dir")+"//"+fileName;
        System.out.println(path);

        try{
            FileWriter fw=new FileWriter(path,true);
            fw.write(fileContent);
            fw.close();
        }catch (IOException io){
            System.out.println("Handle exception");
        }

    }
}
