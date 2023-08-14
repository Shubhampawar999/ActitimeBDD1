package com.String;

public class SwappingWithoutUsingFun {

    public static void main(String[] args){
     int oddCount=0;
     int evenCount=0;
             int num=1235;
     while (num>0){
         int rem=num%10;
if(rem%2==0){
    evenCount++;
}else {
    oddCount++;
}
         System.out.println(evenCount);

     }


        }


    }

