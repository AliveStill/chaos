package alivestill;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VectorEfficiency {

    private final static int COUNT = 1 << 24;   // 16M

    private final static int THREAD_COUNT = 4096;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(COUNT);
        Vector<Integer> vec = new Vector<>(COUNT);
        long begin = System.currentTimeMillis();
        for (int i = 0; i < COUNT; ++ i) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.printf("%d elements in total\n", COUNT);
        System.out.printf("%d threads in total\n", THREAD_COUNT);
        System.out.printf("list takes %dms\n", end - begin);
        begin = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < THREAD_COUNT; ++ i) {
            int finalI = i;
            long finalBegin = begin;
            executor.submit(() -> {
                for (int j = 0; j < COUNT / THREAD_COUNT; ++ j) {
                    vec.add(finalI * (COUNT / THREAD_COUNT) + j);
                }
                long endTime = System.currentTimeMillis();
                System.out.printf("Thread %d takes %dms\n", Thread.currentThread().getId(), endTime - finalBegin);
            });
        }
        executor.shutdown();
    }
}
