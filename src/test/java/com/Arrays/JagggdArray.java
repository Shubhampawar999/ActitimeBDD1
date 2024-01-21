package com.Arrays;

public class JagggdArray {



    public static void main(String[] args){
//        int [][][] a;
//        a=new int[3][][];
//        a[0]=new int[2][];
//        a[1]=new int[2][];
//        a[2]=new int[2][];
//        a[0][0]=new int[2];
//        a[0][1]=new int[2];
//        System.out.println(a[0][1]);

        int a[]={20,50,60,70};
        System.out.println(a.length);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1;j++){
                System.out.println(a[j]);
            }
        }
    }
}
