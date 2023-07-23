package com.BasicJava;

public class VerifyThePrimeNo {


    public static void main(String[] args){
        int num=1;
        int count=0;

        if(num>1){

            for(int i=1;i<=num;i++){
                if(num%i==0)
                    count++;

                if(count==2){
                    System.out.println("It is a prime number");
                }else{
                    System.out.println("This is a not prime number");
                }
            }

        }else{
            System.out.println("This is palindrom number");
        }

    }
}
