package com.BasicJava;

public class ReverseStringWithoutInbildFunction {

    public static void main(String[] args){

        String name="SHUBHAM";
       char  c[] = name.toCharArray();

        for(int i=c.length-1;i>=0;i--){
            System.out.println(c[i]);
        }

        String str="CYBER";
        for(int i=str.length()-1;i>=0;i--){
            System.out.println(str.charAt(i));
        }



    }

}
