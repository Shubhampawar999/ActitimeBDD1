package com.String;

import java.util.Arrays;
import java.util.Scanner;

public class GivenStringAnagramorNot {
    public static void main(String[] args){
        System.out.println("Given String anagram or not");
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.nextLine();
        System.out.println("enter String");
        String str2=scanner.nextLine();
        System.out.println("enter String");
        scanner.close();

       if(isAnagram( str1,str2)){
           System.out.println("isAnagram");
       }else{
           System.out.println("isAnagram not");
       }
    }

    public static boolean isAnagram(String str1,String str2){
     char[] c1= str1.toCharArray();
     char[] c2= str1.toCharArray();
       return Arrays.equals(c1,c2);
    }

}
