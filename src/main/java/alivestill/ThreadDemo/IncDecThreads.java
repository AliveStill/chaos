package alivestill.ThreadDemo;

public class IncDecThreads {

    Object lock = new Object();
    int num = 0;

    class IncThread extends Thread {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getId() + " inc num");
                ++ num;
            }
        }

    }
    class DecThread extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getId() + " dec num");

                -- num;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        IncDecThreads t = new IncDecThreads();
        t.test();
        Thread.sleep(500);
        System.out.println(t.num);
    }

    public void test() {
        Thread t1 = new IncThread();
        Thread t2 = new DecThread();
        Thread t3 = new IncThread();
        Thread t4 = new DecThread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
