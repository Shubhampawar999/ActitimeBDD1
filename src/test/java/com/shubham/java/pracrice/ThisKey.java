package com.shubham.java.pracrice;

import java.util.Scanner;

public class ThisKey {
    int a;
    public void password(){
         a=10;
        System.out.println("9995");
    }
    public void users(){
        password();
        System.out.println(a);
    }
    public static void main(String[] args) {
        ThisKey K=new ThisKey();
        K.users();
    }
}
