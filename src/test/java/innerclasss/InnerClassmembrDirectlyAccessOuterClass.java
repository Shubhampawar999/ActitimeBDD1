package innerclasss;

public class InnerClassmembrDirectlyAccessOuterClass {
    int a=100;

    void innerMembr(){
        Inner i=new Inner();
        System.out.println(a+i.b);
    }
    class Inner{
        float b=200;
    }
}

class main1{
    public static void main(String[] args){
       new InnerClassmembrDirectlyAccessOuterClass().innerMembr();
    }
}
