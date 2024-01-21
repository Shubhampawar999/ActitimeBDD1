package com.javapractice.OOPS;

public class Parent {

 private Parent m1(){
     System.out.println("Inside the parent m1 method");
     return new Parent();
 }
}
