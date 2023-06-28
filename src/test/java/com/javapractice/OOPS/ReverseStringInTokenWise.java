package com.javapractice.OOPS;

public class ReverseStringInTokenWise {

    public static void main(String[] args){
        String str="WELCOME TO CYBER SUCCESS";
        String wordsString =" ";

        //Firstly we need o split the String and extract the each String

      String[] w=  str.split(" ");

      String oneString="";
      for(String word:w) {
          wordsString = "";
          for (int i = word.length() - 1; i >= 0; i--) {
              wordsString = wordsString + word.charAt(i);

              //System.out.println(wordsString);y
          }
          oneString = oneString + wordsString + " ";

      }
      System.out.println(oneString);

}}
