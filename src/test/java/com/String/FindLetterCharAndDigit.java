package com.String;

import java.util.StringTokenizer;

public class FindLetterCharAndDigit {

    public static void main(String[] args) {

        int letter = 0;
        int space = 0, number = 0;
        String str = "s1hu2bha3 m";

        char c[] = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isSpaceChar(c[i])) {
                space++;
            } else if (Character.isDigit(c[i])) {
                number++;
            } else if (Character.isAlphabetic(c[i])) {
                letter++;
            }
        }
        System.out.println("space:-"+space);
        System.out.println("number:-"+number);
        System.out.println("lettter:-"+space);


    }

}