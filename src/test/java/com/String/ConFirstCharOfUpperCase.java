package com.String;

public class ConFirstCharOfUpperCase {

    public static void main(String[] args){
        String s="i am going to school";
        String[] s1=s.split(" ");

        for(int i=0;i<s1.length;i++){
            char c=s1[i].charAt(0);
            String sh=String.valueOf(c).toUpperCase();
            String str=s1[i].substring(1);
            System.out.print(sh+str+" ");
        }







    }
}
