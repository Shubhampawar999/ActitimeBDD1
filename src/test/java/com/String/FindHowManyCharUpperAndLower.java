package com.String;

public class FindHowManyCharUpperAndLower {

    public static void main(String[] args){
        System.out.println("Find the count the maximum and minimum character");

        String str="Wel Come To Java";
        int upper=0;
        int lower=0;

        for(int i=0;i<str.length();i++) {

            char c = str.charAt(i);
            if (c > 65 && c < 90) {
                upper++;

            } else {
                lower++;
            }

        }
        System.out.println(upper);
        System.out.println(lower);


    }
}
