package com.String;

public class CountTheString {
    public static void main(String[] args) {

        String s="My Name Is Shubham Pawar";
        int count=0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i) !=' '){
                count++;
            }
        }
        System.out.println(count);

    }
}
