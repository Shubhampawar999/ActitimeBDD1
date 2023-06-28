package com.javapractice.OOPS;

import java.util.function.Consumer;

public class ConsumerImpl implements Consumer<String> {

    public void accept(String input){
        System.out.println(input);
    }
}
