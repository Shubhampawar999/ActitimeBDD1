package com.javapractice;

public class Recursion {


    public static void printNum(int n){
        //Base condition if do no declare baseconditions then memory is full
        //To raise the exception stack overflow
        if(n==0){
            return;
        }
        System.out.println(n);
        //Recursion-A function that call itself
        //Every recursion create layer from stack  and check the if condition
        printNum(n-1);
    }

    public static void main(String[] args){
     int n=5;int a=1;
        printNum(n);
        printNum1(a);
        printno(n);
    }
    //To print the number 1 to 5
  public static void printNum1(int a){
        if(a==6){
            return;
        }
        System.out.println(a);
        printNum1(a+1);
  }

  public static void printno(int b){
        if(b==10){
            return;
        }
        System.out.println(b);
      printno(b+1);
  }
}
