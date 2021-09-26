package alivestill.ThreadDemo;

@Deprecated
public class RatioRunning {

    Object lock = new Object();
    int mainCount = 0;
    boolean turnOfMain = true;
    boolean turnOfSub = false;

    public void run() {
        while (true) {
            try {
                Thread.sleep(35);
                synchronized(lock) {
                    if (!turnOfMain) {
                        lock.notify();
                        continue;
                    }
                    if (mainCount >= 100) {
                        mainCount = 0;
                        turnOfMain = false;
                        turnOfSub = true;
                        lock.notify();
                    }
                    ++ mainCount;
                    System.out.println("main run " + mainCount + " times");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class SubThread extends Thread {
        int subCount = 0;

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(35);
                    synchronized (lock) {
                        if (!turnOfSub) {
                            lock.notify();
                            continue;
                        }
                        if (subCount >= 10) {
                            subCount = 0;
                            turnOfSub = false;
                            turnOfMain = true;
                            lock.notify();
                        }
                        ++ subCount;
                        System.out.println("sub run " + subCount + " times");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        RatioRunning rr = new RatioRunning();
        rr.wrap();
    }

    public void wrap() {
        Thread t = new SubThread();
        t.start();
        run();
    }


}



class WaitNotifyVersion {

    public static void main(String[] args) throws Exception{
        WaitNotifyVersion wnv = new WaitNotifyVersion();
        wnv.wrap();
    }

    public void wrap() {
        Thread t = new ThreadA();
        t.start();
        run();
    }


    Object lock = new Object();
    boolean mainThreadShouldRun = true;
    int count = 0;


    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
                synchronized (lock) {
                    if (!mainThreadShouldRun) {
                        lock.wait();
                    }
                    ++ count;
                    System.out.println("main: " + count);
                    if (count >= 100) {
                        mainThreadShouldRun = false;
                        count = 0;
                        lock.notify();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class ThreadA extends Thread {
        int count = 0;

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(20);
                    synchronized (lock) {
                        if (mainThreadShouldRun) {
                            lock.wait();
                        }
                        ++ this.count;
                        System.out.println("sub: " + count);
                        if (this.count >= 10) {
                            mainThreadShouldRun = true;
                            this.count = 0;
                            lock.notify();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
