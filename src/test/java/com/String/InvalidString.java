package com.String;

public class InvalidString {
    public static void main(String[] args){
        System.out.println("INSIDE THE MAIN METHOD");
        String shubhma="";
        valid(shubhma);
    }
    public static String valid(String shubhma) {
        if (shubhma.isEmpty() || shubhma.isBlank() || shubhma.equals(null)) {

        }

        return "shubhma";
    }
}
