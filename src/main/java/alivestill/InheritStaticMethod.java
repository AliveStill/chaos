package alivestill;

public class InheritStaticMethod {

    public static void main(String[] args) {
        A obj = new B();
        obj.method();   // print A
    }
}

class A {
    public static void method() {
        System.out.println("A");
    }
}

class B extends A {
    /* @Override */
    public static void method() {
        System.out.println("B");
    }
}


