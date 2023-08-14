package com.fileHandling;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class ReadTheDataFromFile {
    public static void main(String[] args){
        String filePath="C:\\Classroom\\shubham.txt";
        try {

                FileReader fr = new FileReader(filePath);
                try{
                    int i;
                    while ((i=fr.read())!=-1){
                        System.out.println((char)i);
                    }
            }finally {
                fr.close();
            }
        }catch (IOException exception){
            System.out.println("Handle the exception");
        }


    }
}
