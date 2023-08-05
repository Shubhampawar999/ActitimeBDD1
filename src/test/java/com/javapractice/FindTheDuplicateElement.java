package com.javapractice;

import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateElement {

    public static void main(String[] args){
        System.out.println("Inside the main method");
        String str[]={"java","c++","c#","rubby","Cyber","Tech"};
        String str1[]={"java","c++","c#","rubby","Shubham","Pawra"};

        Set<String> set=new HashSet<String>();
        //Using for loop
        for(int i=0;i<str.length;i++){
            for(int j=0;j<str1.length;j++){
                if(str[i]==str1[j]){
                    set.add(str[i]);
                }
            }
        }
        System.out.println(set);



    }
}
