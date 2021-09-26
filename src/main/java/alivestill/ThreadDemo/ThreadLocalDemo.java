package alivestill.ThreadDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalDemo {

    static ThreadLocal<Integer> tl = new ThreadLocal<>();
    static CountDownLatch cdl = new CountDownLatch(1024);
    static AtomicInteger ai = new AtomicInteger(0);

    public static void main(String[] args) throws Exception{
        ExecutorService pool = Executors.newFixedThreadPool(4); // 4 living threads
        for (int i = 0; i < 1024; ++ i) {
            pool.submit(() -> {
                tl.set((int)Thread.currentThread().getId());
                if (tl.get() != (int)Thread.currentThread().getId()) {
                    System.err.println("Error");
                } else {
                    ai.incrementAndGet();
                }
                cdl.countDown();
            });
        }
        cdl.await();
        System.out.println(ai.get());   // 1024, no problem
        pool.shutdown();
    }
}
