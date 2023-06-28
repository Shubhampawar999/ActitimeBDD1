package com.javapractice;

public class ResverseString3Approch {

    public static void main(String[] args){
        String str="SHUBHAM";
        String rev="";
        //First approch 1
//        for(int i=str.length()-1;i>=0;i--){
//            rev=rev+str.charAt(i);
//        }
//        System.out.println("Before reverse string"+str);
//        System.out.println("Reverse String:"+rev);

        //Second Approch using tocharArray() method
//       char s[]= str.toCharArray();
//       for(int i=s.length-1;i>=0;i--){
//           rev=rev+s[i];
//       }
//       System.out.println("Before reverse string"+str);
//        System.out.println(rev);


        //Third approch using StringBuffer
        StringBuffer stringBuffer=new StringBuffer(str);
       StringBuffer s= stringBuffer.reverse();
        System.out.println(str);
       System.out.println(s);

    }
}
