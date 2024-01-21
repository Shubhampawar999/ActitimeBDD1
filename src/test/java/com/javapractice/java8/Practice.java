package com.javapractice.java8;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Practice {
    String name; char gender; double age; long mobileNumber;

    Practice(String name,char gender,double age,long mobileNumber){
        this.name=name;
        this.gender=gender;
        this.age=age;
        this.mobileNumber=mobileNumber;
    }

    public static void main(String[] args) {
        String pname="shubham";
        char gender='M';
        double age=26;
        long mobileno=77439142;
        Practice p=new Practice( pname,gender,age,mobileno);
        Set<Practice> practiceSet=new HashSet<>();


    }
    public void setPractice(Set<Practice> practiceSet){

    }

}
