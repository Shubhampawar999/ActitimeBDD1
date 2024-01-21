package com.Arrays;

public class BubbleSortingOfArray {

    public static void main(String[] wx){

        System.out.println("Inside the main method");
        //Sorting the arrray using bubble sorting
        int a[]={1,5,9,6,3};

        System.out.println("Before Sorting array"+String.valueOf(a));
        for(int i=1;i<=a.length;i++){
            for(int j=1;j<=a.length;j++){
                if(a[j]>a[j+1]){
                    int temp;
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }

        }
        System.out.println("After sorting array"+a);


    }


}
