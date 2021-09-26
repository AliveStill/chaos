package alivestill;

import org.junit.jupiter.api.Test;

public class InvokeRunMethod {
    public static void main(String[] args) {
        System.out.println("main thread id: " + Thread.currentThread().getId());
        Thread thread = new Thread(() -> {
            System.out.println("son thread id: " + Thread.currentThread().getId());
        });
        // thread.run();   // forbidden
        thread.start();
    }

    @Test
    public void test() {
        System.out.println("main thread id: " + Thread.currentThread().getId());
        Cls cls = new Cls();
        // thread.run();   // forbidden
        cls.run();          // forbidden
    }

    class Cls implements  Runnable {

        @Override
        public void run() {
            System.out.println("son thread id: " + Thread.currentThread().getId());
        }
    }
}
