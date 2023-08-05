package com.Arrays;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args){
        System.out.println("WelCome Shubham Co Bank Of India");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Your PassWord");
        int password=sc.nextInt();
        if(password==9995){
            System.out.println("Your Account Loggin Successful");
            Scanner sc1=new Scanner(System.in);
            System.out.println("Enter Amount");
            int amount=sc1.nextInt();
            if(amount<=1000){
                System.out.println("Collect the Money And Cancel the pin number");

            }else{
                System.out.println("Please Enter The Amount Is Less Then 1000");
            }
        }else{
            System.out.println("Please Check Your Password Are Invalid");
        }

    }
}
