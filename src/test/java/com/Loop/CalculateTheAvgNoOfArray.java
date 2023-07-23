package com.Loop;

import java.util.Arrays;

public class CalculateTheAvgNoOfArray {


    public static void main(String[] args){
        System.out.println("Find the calculate number in array using foreach loop");

        int a[]={10,20,30,40,50};
int le=a.length;
        Arrays.stream(a).forEach(le);
    }
}
