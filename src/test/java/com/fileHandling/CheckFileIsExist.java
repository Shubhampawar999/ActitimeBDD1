package com.fileHandling;

import java.io.File;
import java.util.Scanner;

public class CheckFileIsExist {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file name");
        String fileName = sc.nextLine();
        filenam(fileName);
    }

    public static void filenam(String fileName){


        File f=new File(fileName);
        boolean b=f.exists();
            System.out.println(f.getAbsoluteFile()+"isExists?.."+" "+b);



    }
}
