package com.Arrays;

public class Switch {
    public static void main(String[] args){
        System.out.println("Inside the main method");
        int score=35;
        switch (score){
            case 90:
                System.out.println("It is very good");
                break;
            case 70:
                System.out.println("It is good");
                break;
            case 60:
                System.out.println("It is second layer");
                break;
            default:
                System.out.println("It is fail");
                break;
        }


    }

    public  void mySelf() {
        System.out.println("Shubham");
    }
}
