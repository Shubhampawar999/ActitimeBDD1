package com.String;

import io.cucumber.plugin.event.Node;

public class HowMayJwelsAndStones {


    ///Example:
    //input jwels="aA",stones="aAABBB";
    //output=3

    public static void main(String[] args) {
        String jwels="aA";
        String stones="aAABBB";

       int toaljwels=HowMayJwelsAndStones.countJwels(jwels,stones);
       System.out.println(toaljwels);
    }
        public static int countJwels(String jwels,String stones){
            int count=0;

            for(char c:stones.toCharArray()){
                if(jwels.contains(c+"")){
                    count++;
                }
            }
            return count;

    }
}
