package com.BasicJava;

import java.util.Arrays;

public class SortingArrayInAscendingOrder {


    public static void main(String[] args){

        System.out.println("Bubble sort");

        int a[]={1,8,6,3,4};

        System.out.println("Before sorting arrays"+ Arrays.toString(a));
      int a1=  a.length;
      for(int i=0;i<a1-1;i++){
          for(int j=0;j<a1-1;j++){
              if(a[j]>a[j+1]){
                  int temp=a[j+1];
                  a[j+1]=a[j];
                  a[j]=temp;

              }
          }
      }
        System.out.println("After Sorting"+Arrays.toString(a));

      int var[]={10,80,42,65,80};

      System.out.println("Before Sorting Arrays"+Arrays.toString(var));

      int number=var.length;
      for(int i=0;i<number-1;i++){
          for(int j=0;j<number-1;j++){
              if(var[j]>var[j+1]){
                  int temp=var[j];
                  var[j]=var[j+1];
                  var[j+1]=temp;
              }
          }
      }
      System.out.println("After the sorting bubble sorting arrays0"+Arrays.toString(var));




    }


}
