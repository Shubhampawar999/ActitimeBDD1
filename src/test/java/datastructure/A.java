package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class A {



    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"Shubham");
        map.put(2,"Pawar");
        map.put(3,"svp");
        System.out.println(map)
        ;


        System.out.println(map.get(1));
      System.out.println(map.keySet());
      System.out.println(map.values());
      for(Map.Entry s:map.entrySet()){
          System.out.println("Key:"+s.getKey()+"Value:"+s.getValue());
          if(s.getKey().equals(1)){
              break;
          }
      }




    }
}
