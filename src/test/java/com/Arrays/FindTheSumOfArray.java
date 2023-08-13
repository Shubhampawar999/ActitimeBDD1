package com.Arrays;

public class FindTheSumOfArray {

    public static void main(String[] args){

        int sum=0;
        int number[]={1,2,3,4,5,6};
        for(int value:number){
            sum=sum+value;
        }
        System.out.println(sum);

        //Second approch
        for(int i=0;i<=number.length-1;i++){
            sum=sum+number[i];
        }
        System.out.println(sum);
    }
}
