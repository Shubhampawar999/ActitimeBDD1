package com.javapractice.OOPS;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Fun1Demo {

    public static int addition(int a,int b){
        return a+b;
    }

    public static void main(String[] args) {

//        Function<String,Integer> fun=new Fun1() {
//
//        }
//
//        Function<String,Integer> fun=(String s)->s.length();
//        fun.apply("shubham");


        Consumer<String> consumer = (input) -> System.out.println(input);
        consumer.accept("This is the consumer interface");

//Using lambda expression
        Function<Integer, Double> math = (input) -> Math.sqrt(input);
                                 System.out.println( math.apply(4));

  //Using method Refrence
  Function<Integer,Double> methodRef=Math::sqrt;
       System.out.println( methodRef.apply(4));

      //  BiFunction<Integer,Integer,Integer> biFunctionlambda=(a,b)->Fun1::

//      System.out.println( addition(10,20));

    }
}