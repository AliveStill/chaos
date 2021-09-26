package alivestill;


//import jdk.internal.misc.Unsafe;
//
//import java.lang.reflect.Field;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;


/// note, currently we are not allowed to use Unsafe anymore.
@Deprecated
public class MyAtomicInteger {

//    private static Unsafe unsafe;
//    private static long offset;
//
//    static {
//        try {
//
//            Field field = Unsafe.class.getDeclaredField("theUnsafe"); // 设置为可存取（2.2.11）
//
//            field.setAccessible(true); // 获取该变量的值（2.2.12）
//
//            unsafe = (Unsafe) field.get(null); //获取 state 在 TestUnSafe 中的偏移量 （2.2.13）
//
//            offset = unsafe.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("value"));
//
//
//        } catch (Exception ex) {
//
//            ex.printStackTrace();
//
//        }
//    }
//
//    private volatile int value;
//
//    MyAtomicInteger(int i) {
//        value = i;
//    }
//
//    MyAtomicInteger() {
//        this(0);
//    }
//
//    public int get() {
//        return value;
//    }
//
//    public int getAndIncrement(int x) {
//        int v;
//        do {
//            v = unsafe.getIntVolatile(this, offset);
//        } while (!unsafe.compareAndSetInt(this, offset, v, v + x));
//        return v;
//    }
//
//    public int getAndDecrement(int x) {
//        int v;
//        do {
//            v = unsafe.getIntVolatile(this, offset);
//        } while (!unsafe.compareAndSetInt(this, offset, v, v - x));
//        return v;
//    }
//
//
//    public static void main(String[] args) {
//        ExecutorService pool = Executors.newFixedThreadPool(4);
//        MyAtomicInteger num = new MyAtomicInteger(0);
//        CountDownLatch cd = new CountDownLatch(1024);
//
//        for (int i = 0; i < 1024; ++ i) {
//            pool.submit(() -> {
//                for (int j = 0; j < 1024; ++ j) {
//                    num.getAndIncrement(1);
//                }
//                cd.countDown();
//            });
//        }
//        try {
//            cd.await();
//            System.out.println(num.get() + "? 1024*1024=" + (1024*1024));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        pool.shutdown();
//    }
}
