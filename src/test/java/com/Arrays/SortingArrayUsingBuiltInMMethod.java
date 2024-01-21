package com.Arrays;

import java.util.Arrays;

public class SortingArrayUsingBuiltInMMethod {

    public static void main(String[] args){
        int a[]={10,80,50,60,30};
        System.out.println(Arrays.toString(a));
        Arrays.parallelSort(a);
        System.out.println(Arrays.toString(a));
    }
}
