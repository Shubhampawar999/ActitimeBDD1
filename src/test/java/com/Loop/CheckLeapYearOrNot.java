package com.Loop;

public class CheckLeapYearOrNot {

    public static void main(String[] args){
        System.out.println("Check leap year or not ");

        int year=2020;

        if((year%400==0)|| (year%4==0 && year%100!=0)){
                System.out.println("This is leap years");
        }else{
            System.out.println("This is not leap years");
        }


    }
}
