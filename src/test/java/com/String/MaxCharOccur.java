package com.String;

public class MaxCharOccur {

    public static void main(String[] args){

        String s="abbccc";

        int[] arr=new int[127];

        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)]= arr[s.charAt(i)]+1;
            //0             =0+1

        }
    }
}
