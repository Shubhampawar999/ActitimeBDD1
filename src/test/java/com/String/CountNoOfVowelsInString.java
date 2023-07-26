package com.String;

import java.util.Scanner;

public class CountNoOfVowelsInString {

    public static void main(String[] args){
        System.out.println("Count the number of vowels in string");
        int vowel=0;
        int nonvowel=0;

        Scanner sc=new Scanner(System.in);
        System.out.println("enter name");
        String a=sc.nextLine();
        for(int i=0;i<a.length();i++){
            char c=a.charAt(i);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                vowel=vowel+1;
            }else {
                nonvowel=nonvowel+1;
            }
        }
        System.out.println("vowels count:"+vowel);
        System.out.println("nonvowels count:"+nonvowel);
    }
    }

