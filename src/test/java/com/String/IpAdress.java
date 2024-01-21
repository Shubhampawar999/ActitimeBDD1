package com.String;

public class IpAdress {

    public static void main(String[] args) {
        String adress="1.1.1.1";
//        adress=adress.replace(".","[.]");
//        System.out.println(adress);

          StringBuffer sf=new StringBuffer(adress);
            char[] c= adress.toCharArray();
            for(char c1:c){
                if(c1=='.'){
                    sf.append("[.]");
                }else{
                    sf.append(c1);
                }
            }
            System.out.println(sf.toString());


    }

}
