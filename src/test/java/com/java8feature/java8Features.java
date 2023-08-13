package com.java8feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class java8Features {

    public static void main(String[] args){


        List<Integer> number= Arrays.asList(10,15,20,25,30);
        ArrayList<Integer> evennumlist=new ArrayList<>();

        System.out.println(number);

        for(int n:number){
            if(n%2==0)
                evennumlist.add(n);
        }
        System.out.println("Even numberList"+evennumlist);

number.stream().filter(n->n%2==0).collect(Collectors.toList());

List<String> listNmae=Arrays.asList("SHUBHAM","PAWAR","TI IS ","PURSUVING","CYBER");

List<String> sortedList=new ArrayList<>();

sortedList=listNmae.stream().filter(n->n.length()>=6&&n.length()<=8).collect(Collectors.toList());
System.out.println(sortedList);

    }





}
