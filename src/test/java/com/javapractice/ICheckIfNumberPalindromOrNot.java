package com.javapractice;

import java.util.Scanner;

public class ICheckIfNumberPalindromOrNot{

    public static void main(String[] args){
        Scanner scenner=new Scanner(System.in);
        System.out.println("Enter number1");

       int num= scenner.nextInt();

       //Whatever input put into user store the value in orgno variable and after compile it
       int orgno=num;

       int rev=0;
       while(num!=0){
           rev=rev*10+num%10;
           num=num/10;

       }
       if(orgno==rev){
           System.out.println("palindrom");
       }else{
           System.out.println("Not Palindrom");
       }


    }
    
}
