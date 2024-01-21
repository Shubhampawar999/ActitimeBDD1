package com.javapractice.OOPS;

public class child extends Parent {


    public child m1(){
        System.out.println("Inside the child m1 method");
        return new child();
    }
    public static void main(String[] args) {
        child c=new child();
        c.m1();

    }
}
