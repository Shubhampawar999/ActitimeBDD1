package com.javapractice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Str {
   public  String str1;
    public  void shubham(){
        str1="shubham";
    }


    public static void main(String[] args){
        String str="cyber,success,technology,pune";


        //Split the string
        String[] s=str.split(",");
        for(String s1:s){
            System.out.println(s1);


        }
        Arrays.stream(s).forEach(var->System.out.println(var));
       Arrays.stream(s).forEachOrdered(v->System.out.println(v));










    }





}
