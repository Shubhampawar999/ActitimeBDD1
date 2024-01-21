package com.String;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FindTheAllCharRepeated {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String:");
       String str=sc.nextLine();
Map<Character,Integer> map=new TreeMap<>();
      String s=str.replaceAll(" ","");

      char c[]=s.toCharArray();
      int count=0;
      for(int i=0;i<c.length;i++){
          count=0;
          for(int j=0;j<c.length;j++){
              if(c[i]==c[j]){
                  count++;
              }
          }
          map.put(c[i],count);
      }
      System.out.println(map);



    }
}
