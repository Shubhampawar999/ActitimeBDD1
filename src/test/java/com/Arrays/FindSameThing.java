package com.Arrays;

import java.util.HashSet;
import java.util.Set;

public class FindSameThing {
    public static void main(String[] args) {

        String str[]={"Shubham","Pawar","Working","ITE"};
        String str1[]={"Shubham","Pawarr","Working","IT"};

        Set<Object> s=new HashSet<>();
        for(int i=0;i<str.length;i++){
            for(int j=0;j<str1.length;j++){
                if(str[i]==str1[j]){
                    s.add(str[i]);
                }
            }
        }
        for(Object se:s){
            System.out.println(se);
        }

    }
}
