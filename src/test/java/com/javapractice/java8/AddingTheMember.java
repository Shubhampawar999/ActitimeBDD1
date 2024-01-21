package com.javapractice.java8;

import java.util.*;

public class AddingTheMember {

    public static void main(String[] args) {
//        List<Map<String,String>> list=new ArrayList<>();
//        Map<String,String> map=new HashMap<>();
//        map.put("name","Shubham");
//        map.put("mobNo","7743914263");
//        list.add(map);
//        System.out.println(list);
//        list.forEach(val->val.forEach((k,v)->System.out.println(v)));
//
        List<Map<String,Map<Integer,String>>> list1=new ArrayList<>();
        Map<Integer,String> map1=new HashMap<>();
        map1.put(1,"shubham");
        map1.put(2,"");

        Map<String,Map<Integer,String>> map2=new HashMap<>();
        map2.put("ShubhamData",map1);

        list1.add(map2);
        System.out.println(list1);

        //Iterate the value in the map using for ech method introduce in java 8 version


        list1.forEach(val->val.forEach((k,v)->v.forEach((key,value)->Optional.ofNullable(value))));


    }
}
