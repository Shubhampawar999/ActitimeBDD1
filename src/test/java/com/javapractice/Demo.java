package com.javapractice;


import java.util.Arrays;

public class Demo {


    public static void main(String[] args){
        String s="shubham,pawar,gondi,   ,    ,";
        String[] str=s.split(",");
        for(String s1:str){
            if(s1.startsWith("s")){
                System.out.println(s1);
            }

        }
        Arrays.stream(str).forEach(var->System.out.println(var));


    }
}
