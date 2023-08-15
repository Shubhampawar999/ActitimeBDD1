package innerclasss;

public class MMetodLocalClass {
    int a=10;
    void m1(){
        class  inner{
            void m2(){
                System.out.println(a);
            }

        }
        inner i=new inner();
        i.m2();
    }









    public static void main(String[] args){
        MMetodLocalClass m=new MMetodLocalClass();
       m.m1();
    }
}
