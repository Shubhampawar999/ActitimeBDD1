package com.String;

public class CheckBalanceParanthesisInString {

    public static boolean isValid(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        int count=0;
        int i=0;
        while(i<str.length()){
         char c= str.charAt(i);
         if(c=='('){
             count++;
         }else if(c==')'){
             if(count==0)
             {
                 return false;
             }else {
                 count--;
             }
         }i++;

        }
        if(count!=0) {
            return false;
        }
        return true;
    }
      public static void main(String[] args){
        System.out.println(isValid(""));
          System.out.println(isValid("(shubhma)"));
          System.out.println(isValid(")shubham)"));
      }
}
