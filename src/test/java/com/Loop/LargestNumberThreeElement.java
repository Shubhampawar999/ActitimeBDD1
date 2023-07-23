package com.Loop;

import java.util.Scanner;

public class LargestNumberThreeElement {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First NUmber");
       int a= sc.nextInt();

        System.out.println("Enter Second NUmber");
        int b= sc.nextInt();

        System.out.println("Enter Third NUmber");
        int c= sc.nextInt();

        if(a>b && a>c){
            System.out.println(a+"a largest number");
        } else if (b>a&&b>c) {
            System.out.println(b+"b largest number");
        }else {
            System.out.println("c is largest number");
        }

    }
}
