package com.javapractice;

import java.util.*;


public class StrBulderRev {
    public static void main(String[] a) {

//        StringBuilder s = new StringBuilder("Shubham");
//
//        for (int i = 0; i < s.length()/2;i++){
//            int front=i;
//            int back=s.length()-1-i;
//
//            char front1=s.charAt(front);
//            char back1=  s.charAt(back);
//
//            s.setCharAt(front,back1);
//            s.setCharAt(back,front1);
//
//
//        }
//        System.out.println(s);
//
//        String str="aba";
//        String rev="";
//        for(int i=str.length()-1;i>=0;i--){
//            rev=rev+str.charAt(i);
//        }
//        if(str.equals(rev)){
//            System.out.println("String palindrom");
//        }else{
//            System.out.println("Not Palindrom");
//        }



    String s="abbccc";

        HashMap<Character,Integer> hm=new HashMap<>();
        char[] c=s.toCharArray();

        for(char ch:c){
            if(hm.containsKey(ch)){// to check  hashmap this char present or not
                hm.put(ch,hm.get(ch+1));
            }else{
                hm.put(ch,1);
            }
            System.out.println(hm);
        }


//int maxCount=0;
//char maxchar=' ';
//for(Map.Entry me=hm.entrySet()){

}


   }



