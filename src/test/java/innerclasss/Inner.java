package innerclasss;

public class Inner {
    int a=100,b=200;
    class outer{
        int x=10;float y=20;
        void m1(int p,float q){
            System.out.println(p+q);
            System.out.println(this.x+this.y);
            System.out.println(Inner.this.a+Inner.this.b);
        }
    }
}

class main{
    public  static void main(String[] args){
        new Inner().new outer().m1(99,95);

    }
}
