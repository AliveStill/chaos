package alivestill;

public class InstanceOf {

    class A {}
    class B extends A{}
    class C extends B{}

    class Others{}

    public static void main(String[] args) {
        new InstanceOf().run();
    }

    public void run() {
        A a = new A();
        B b = new B();
        C c = new C();
        System.out.println(b instanceof A);
        System.out.println(b instanceof B);
        System.out.println(b instanceof C);
//        System.out.println(b instanceof Others); // compile error,
    }
}




