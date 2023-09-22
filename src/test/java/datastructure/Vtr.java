package datastructure;

import java.util.Vector;

public class Vtr {

    public static void main(String[] args) {
        Vector v=new Vector();
        System.out.println(v.capacity());
        for(int i=1;i<=10;i++){
            v.addElement(i);
        }
        v.addElement('s');
        System.out.println(v.capacity());
    }
}
//capasity=currentcapasity*2
