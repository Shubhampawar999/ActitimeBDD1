package com.oops;

public class Encapsulation {
    private int number=1000;

     int getBal(){
        System.out.println("get the balance"+number);
        return number;
    }

    public void setNumber(int number){
         number=number+this.number;
         System.out.println(number);

    }




    public  static void main(String[] args){
        System.out.println("Inside the main method");
        Encapsulation encapsulation=new Encapsulation();
                 int currentBal=encapsulation.getBal();
                 System.out.println(currentBal);
                 encapsulation.setNumber(1000);
    }
}
