package com.fileHandling;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class LastModifiedDate {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the file name");
       String fileName= sc.nextLine();
       lastModifyDate(fileName);

    }

    public static void lastModifyDate(String fileName){

        File file=new File(fileName);
       long lastdate= file.lastModified();
        SimpleDateFormat sd=new SimpleDateFormat(String.valueOf("MM/dd/yyyy ,HH:mm:ss"));
        System.out.println(sd.format(lastdate));
    }
}
