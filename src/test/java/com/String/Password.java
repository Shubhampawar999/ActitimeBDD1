package com.String;

import java.util.Random;
import java.util.Scanner;

public class Password {

    public static void main(String[] args){
//        System.out.println("WelCome The Paytm Bank And Bank Owner Os Shubham Pawar Application");
//
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Please enter your password");
//        String strpass=scanner.nextLine();
//        if(strpass.equals("1122")){
//            Scanner sc=new Scanner(System.in);
//            System.out.println("Please enter your amount");
//            int shubh=sc.nextInt();
//            if(shubh>500){
//            System.out.println("Congratulation your journey");}else{
//                System.out.println("Please check balance your balance is not suffeciant");
//            }
//        }else{
//            System.out.println("Password Should be does not please check and right password");
//        }

        String sd="WelCome The Paytm Bank And Bank Owner Os Shubham Pawar Application";
      String[] d= sd.split(" ");
      for(int i=0;i<d.length;i++){
         char c= d[i].charAt(0);
       String g=String.valueOf(d[i]).toLowerCase();
      //String b= d[i].substring(1);
          System.out.println(g);
      }




    }
}
