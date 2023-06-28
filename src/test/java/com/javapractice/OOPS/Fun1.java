package com.javapractice.OOPS;

import java.util.function.Function;

public class Fun1 implements Function<String,Integer> {

    public Integer apply(String s){
        return s.length();
    }
}
