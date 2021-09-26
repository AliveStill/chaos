package alivestill;

public class NotExplicitOverride {

    public static void main(String[] args) {
        C obj = new D();
        obj.method();
    }
}

class C {
    public void method() {
        System.out.println("C");
    }
}

class D extends C{
    // note, implicit overridden
    public void method() {
        System.out.println("D");
    }
}
