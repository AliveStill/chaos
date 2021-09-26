package alivestill;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* still in mystery */
@Deprecated
public class PVOperation {

    class PVSupport {

        ReentrantLock rLock = new ReentrantLock();
        Condition cond = rLock.newCondition();


        int counter;

        public void p() throws InterruptedException {
            rLock.lock();
            -- counter;
            if (counter < 0) {
                cond.await();
            }
            rLock.unlock();
        }

        public void v() {
            rLock.lock();
            ++ counter;
            if (counter > 0) {
                cond.signal();
            }
            rLock.unlock();
        }
    }
}
