package com.fileHandling;

import java.io.File;
import java.util.Scanner;

public class FileDelet {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter File Name");
        String filename=sc.nextLine();
        deletFile(filename);
    }
    public static void deletFile(String fileName){
        File file=new File(fileName);
        if(file.exists()){
            if(file.delete()){
                System.out.println("Delet folder successfully");
            }else {
                System.out.println("Not delet Successfully");
            }
        }else{
            System.out.println("File Does not exists");
        }

    }
}
