package com.Arrays;

public class FindTheDuplicateNumberInTheArray {

    public static void main(String[] args){

        System.out.println("Find The Duplicate Name In the In This Array");

        String number[]={"java","python","c++","c","java"};

        boolean flag=false;
        for(int i=0;i<number.length;i++){
            for(int j=i+1; j<number.length; j++){
                if(number[i]==number[j]){
                    System.out.println(number[i]);
                    flag=true;
                }
            }
        }
        if(flag==false){
            System.out.println("Duplicate Element Not Found");
        }
    }
}
