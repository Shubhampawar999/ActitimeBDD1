package com.String;

import java.util.Scanner;

public class Ab {

    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
        System.out.println("Enter the your name");
       String str=sc.nextLine();
       if(str.equals("Shubham")){
           System.out.println("Enter in the application");
       }else{
           System.out.println("Not allowed in the apllication");
       }
    }
}
