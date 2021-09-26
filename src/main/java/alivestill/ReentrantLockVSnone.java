package alivestill;

import org.junit.jupiter.api.Test;

public class ReentrantLockVSnone {

    Object lock;

    public void chaos1() {
        synchronized (lock) {
            System.out.println("enter chaos 1");
            chaos2();
        }
    }

    public void chaos2() {
        synchronized (lock) {
            System.out.println("enter chaos 2");
        }
    }

    // note, Sorry, synchronized is reentrant, I forgot about that
}
