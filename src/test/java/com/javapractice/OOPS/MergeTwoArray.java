package com.javapractice.OOPS;

import java.io.PrintStream;
import java.util.Arrays;

public class MergeTwoArray {

    public static void main(String[] args) {
        System.out.println("Merging the two array");
        int array1[]= {10, 20, 30};
        int array2[]= {9,18,27};

        int newArray[]=new int[array1.length+array2.length];
        System.out.println(newArray.length);

        System.arraycopy(array1,0,newArray,0,array1.length);
        System.arraycopy(array2,0,newArray,array1.length,array2.length);
        System.out.println(Arrays.toString(newArray));

        Arrays.sort(newArray);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(newArray));

    }
}
