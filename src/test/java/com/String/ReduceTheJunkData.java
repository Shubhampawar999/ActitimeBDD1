package com.String;

import java.util.Scanner;

public class ReduceTheJunkData {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the junk data:");
        String junkData=sc.nextLine();

      String j=  junkData.replaceAll("[^a-zA-Z]","");
      //^ char operator will do is other then this char anything else in this things that will be replace
        System.out.println(j);



    }



}
