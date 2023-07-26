package com.Loop;

import java.util.Arrays;
import java.util.List;

public class MethodRef {
    public static void main(String[] args){

//        List<String> list= Arrays.asList("Shubham","Pawar","Pursiving");
//        list.forEach(System.out::println);
        String str="shubhampawar";
        String c=str.substring(0,3).toUpperCase();
        String c1=str.substring(3);
        System.out.println(c+c1);


    }
}
