package alivestill;

import java.util.Objects;

interface UnaryFunction<T, R> {

    R apply(T t);

    default <V> UnaryFunction<V, R> compose(UnaryFunction<
//             ? super
            V,
//             ? extends
            T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    default <V> UnaryFunction<T, V> andThen(UnaryFunction<
//             ? super
            R,
//             ? extends
            V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    static <T> UnaryFunction<T, T> identity() {
        return t -> t;
    }
}

class Impl<T, R> implements UnaryFunction<T, R> {
    @Override
    public R apply(T t) {
        // done nothing
        return null;
    }
}

class xBase{}
class xDerived extends xBase{}
class mBase{}
class mDerived extends mBase{}

class Chain0{} class Chain01 extends Chain0{}
class Chain1{} class Chain11 extends Chain1{}
class Chain2{} class Chain21 extends Chain2{}
class Chain3{} class Chain31 extends Chain3{}


@Deprecated /* didn't how to continue doing this */
class Cls {
    public static void main(String[] args) {
        UnaryFunction<Chain0, Chain1> ts1 = new Impl<>();
        UnaryFunction<Chain1, Chain2> ts2 = new Impl<>();
        UnaryFunction<Chain2, Chain3> ts3 = new Impl<>();
        UnaryFunction<Chain0, Chain3> compose = ts3.compose(ts2).compose(ts1);
//        ts3.compose(ts2).compose(ts1);
    }
}
