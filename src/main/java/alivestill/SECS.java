package alivestill;

// supplier extends, consumer super
public class SECS {


}

class CLS<T> {

    T t = null;

    CLS(T t) {
        this.t = t;
    }

    public void transfer(Supplier<? extends T> s,
                         Consumer<? super T> c) {
        // c.consume(s.supply(t));
    }
}

class Supplier<T> {
    public T supply(T t) {
        return t;
    }
}

class Consumer<T> {
    public void consume(T t) {
        System.out.println(t);
    }
}

class GenericTypeMethod<T> {

    public <R> T method(R r) {
        return (T)r;
    }

    public static void main(String[] args) {
        GenericTypeMethod<Object> gt = new GenericTypeMethod<>();
        Object obj = gt.method(new Integer(12));
        System.out.println(obj);
    }
}

