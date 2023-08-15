package innerclasss;

public class Shubhm {
    int  a = 10;

    class pawar {
int b=20;
    }

public static void main(String[] args){
    Shubhm s=new Shubhm();
        System.out.println(s.a);
        System.out.println(s.new pawar().b);
}
}

