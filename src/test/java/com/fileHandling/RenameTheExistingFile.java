package com.fileHandling;

import java.io.File;

public class RenameTheExistingFile {

    public static void main(String[] args){
        String file="C:\\Users\\shubham\\IdeaProjects\\ActitimeBDD\\Hello.txt";
        String file1="C:\\Users\\shubham\\IdeaProjects\\ActitimeBDD\\Hel.txt";

        File  filee=new File(file);
        File  filee1=new File(file1);
        if(filee.exists()){
            System.out.println(filee.renameTo(filee1));
        }else{
            System.out.println("File Does not exists");
        }


    }
}
