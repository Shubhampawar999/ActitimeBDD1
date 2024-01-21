package com.fileHandling;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileR {

    public static void main(String[] args) throws IOException {

        PrintWriter pw=new PrintWriter(String.valueOf(new FileReader(new File("xyz.txt"))));
        pw.print("My name is shubham");
        pw.println("I am belongs to satara");
        pw.flush();


    }
}
