package com.oops;

public class SigletoneClass {
    private static SigletoneClass single_instance=null;

  private  SigletoneClass(){

    }
    public static SigletoneClass getInstance(){

if(single_instance==null)
    single_instance=new SigletoneClass();

return single_instance;
    }




}
