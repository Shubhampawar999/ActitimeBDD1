package com.BasicJava;

public class CheckTheGivenNumberPrimeOrNot {


    public static void main(String[] args){

        System.out.println("The given number 1 to 100 prime or not write the logic");

        for(int i=1;i<=100;i++){
           boolean isPrime=true;

           if(i>1){
               for(int j=2;j<i;j++){
                   if(i%j==0){
                       isPrime=false;
                   }
               }
           }else {
               isPrime=false;
           }
           if(isPrime){
               System.out.println(i);
           }
        }



    }
}
