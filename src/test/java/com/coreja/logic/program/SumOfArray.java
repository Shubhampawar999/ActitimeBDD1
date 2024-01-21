package com.coreja.logic.program;

public class SumOfArray {

    public static void main(String[] args) {
        int arr[]={10,51,86,42,47};
        int sum=0;

        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }
        System.out.println(sum);


    }
}
