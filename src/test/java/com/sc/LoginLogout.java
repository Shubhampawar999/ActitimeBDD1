package com.sc;

import java.util.Scanner;

public class LoginLogout {

    public static void main(String[] args) {
        System.out.println("Welcome to AUM bank");

        Scanner sc=new Scanner(System.in);
        System.out.println("enter username of emp");
        String username=sc.nextLine();
        if(username.equalsIgnoreCase("shubham")){
            System.out.println("Username login successful");
            Scanner sc1=new Scanner(System.in);
            System.out.println("Plz enter your password");
            int password=sc1.nextInt();
            if(password==1234){
                System.out.println("Welcome to AUM bank Login successfully");
            }else {
                System.out.println("Plz enter valid password");
            }
        }else {
            System.out.println("Invalid Username Plz enter right username");

        }

    }
}
