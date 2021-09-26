package alivestill;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Volatile {

    static volatile int number = 0;

    static final int COUNT = 1 << 20;

    static final int THREAD_COUNT = 1 << 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0;i < THREAD_COUNT; ++ i) {
            executor.submit(() -> {
                for (int j = 0; j < COUNT / THREAD_COUNT; ++ j) {
                    synchronized (Volatile.class) {
                        number = number + 1;
                    }
                }
            });
        }
        executor.shutdown();
        System.out.printf("number = %d", number);
    }

}
