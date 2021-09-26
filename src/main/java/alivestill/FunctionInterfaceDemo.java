package alivestill;

public class FunctionInterfaceDemo {

    public static void main(String[] args) {
        SomeMove sm = new OtherMove(() -> {
            System.out.println("this is what we want");
        });
        sm.move();
    }
}

// note, Means Can be replaced by a lambda expression
@FunctionalInterface
interface SomeMove {
    void move();
}

class OtherMove implements SomeMove {

    SomeMove sm = null;

    OtherMove(SomeMove sm) {
        this.sm = sm;
    }
    @Override
    public void move() {
        if (sm != null) {
            sm.move();
        } else {
            System.out.println("OtherMove");
        }
    }
}
