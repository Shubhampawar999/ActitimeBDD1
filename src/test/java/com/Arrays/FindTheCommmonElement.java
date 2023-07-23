package com.Arrays;

import java.util.HashSet;
import java.util.Set;

public class FindTheCommmonElement {

    public static void main(String[] args){
        String arr1[]={"java","python","interview","question","experiance"};

        String arr2[]={"java","C#","interview","question","fresher"};

        Set<String> output=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(arr1[i]==arr2[j]){
                    output.add(arr1[i]);
                }
            }
        }
        for(String s:output){
            System.out.println(s);
        }
    }
}
