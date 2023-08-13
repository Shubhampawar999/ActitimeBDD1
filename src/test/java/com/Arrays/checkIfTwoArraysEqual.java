package com.Arrays;

import java.util.Arrays;

public class checkIfTwoArraysEqual {

    public static void main(String[] args){
        int a1[]={1,2,3,4,5};
        int a2[]={1,2,3,4,5};

        boolean status=Arrays.equals(a1,a2);
        if(status==true){
            System.out.println("Arrays Equal");
        }else {
            System.out.println("Arrays Not Equal");
        }

    }
}
