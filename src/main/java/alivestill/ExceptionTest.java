package alivestill;

public class ExceptionTest {
    public static void main(String[] args) {
        Base obj = new Derived();
        obj.run();
    }
}

abstract class Base {
    public abstract void run();
}

class Derived extends Base {
    @Override
    public void run() {
        throw new UnsupportedOperationException("this is not supported");
    }
}