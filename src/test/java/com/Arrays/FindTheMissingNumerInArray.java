package com.Arrays;

public class FindTheMissingNumerInArray {

    public static void main(String[] args){
        System.out.println("Find The Sum Of Missing Number In Array");

        int a[]={1,2,3,5};
        int sum1=0;
        for(int i=0;i<a.length;i++){
            sum1=sum1+a[i];
        }
        System.out.println("Sum of array "+sum1);

        int sum2=0;
        for(int i=1;i<=5;i++){
            sum2=sum2+i;
        }
        System.out.println("Sum of all range of array"+sum2);

        System.out.println("Find the missing number of array"+(sum2-sum1));


    }
}
