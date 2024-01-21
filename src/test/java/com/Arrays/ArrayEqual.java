package com.Arrays;

import java.util.Arrays;

public class ArrayEqual {

    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        int b[]={1,2,3,4,5};
      boolean status= Arrays.equals(a,b);
      System.out.println(status);
      if(status==true){
          System.out.println("This two array is equal");
      }else{
          System.out.println("This two array is not equal");
      }
    }
}
