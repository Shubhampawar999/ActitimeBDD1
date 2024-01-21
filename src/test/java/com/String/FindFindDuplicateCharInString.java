package com.String;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class FindFindDuplicateCharInString {


    public static void main(String[] args) {
        String name="Shubham";
        char[] lenname=name.toCharArray();
        int n=lenname.length;
        System.out.println(lenname);
        System.out.println(n);
        duplicatechar(lenname,n);
    }

    static void duplicatechar(char[] lenname,int n){
        HashSet<Character> ch=new LinkedHashSet<>(n-1);
        for(char x:lenname){
            ch.add(x);
        }

        for(char x1:ch){
            System.out.print(x1);
        }

    }
}
