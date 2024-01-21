package com.basic;

public class palindromeString {
    public static void main(String[] args) {
        String str = "java";
        String Rev = "";

        for(int i = str.length()-1; i>=0; i--)
        {
            Rev = Rev + str.charAt(i);
        }
        //System.out.println(Rev);

        if(str.equals(Rev))
        {
            System.out.println("String is Palindrome");
        }
        else {
            System.out.println("String is Not Palindrome");
        }
    }
}
