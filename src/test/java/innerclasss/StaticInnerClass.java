package innerclasss;

public class StaticInnerClass {
    int a=10;
    static int bb=50;
    static class inner {
        int b = 20;

        inner() {
            System.out.println(bb);
            //All value of the outer class is directly access but only static member only we cannot access non static var and method in outer class
        }

        public static void main(String[] args) {
            StaticInnerClass staticInnerClass = new StaticInnerClass();
            System.out.println(staticInnerClass.a);
            StaticInnerClass.inner i = new StaticInnerClass.inner();
            System.out.println(i.b);

        }

    }}
