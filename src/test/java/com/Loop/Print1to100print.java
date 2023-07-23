package com.Loop;

public class Print1to100print {

    public static void main(String[] args){
        System.out.println("Replace the num if no is multiplyby 3 replace fizz and number multiply by 5 then replce by buzz ");

        for(int i=1;i<=100;i++){
            if(i%3==0){
                System.out.println("fizz");
            }else if(i%5==0){
                System.out.println("Buzz");
            }
            System.out.println(i);
        }
    }
}
