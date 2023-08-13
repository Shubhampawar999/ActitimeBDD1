package com.Arrays;

import java.util.Arrays;

public class FindTheSecondHighestNumberromJava {

    public static void main(String[] args){

        int num[]={1,4,7,-4,9,10,15};

        int n=num.length;

        Arrays.sort(num);

        System.out.println("Second Highest Slary"+" "+num[n-2]);

    }
}
