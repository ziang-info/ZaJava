package info.ziang.java.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://blog.csdn.net/lixiangming_10010/article/details/78385638
 */
public class AttemptLocking {

    private ReentrantLock lock = new ReentrantLock();

    /**
     * @description
     */
    public void tLock() {
        lock.lock();
        try {
            System.out.println("mathod lock is not available");
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.unlock();
            System.out.println("mathod lock is available");

        }
    }

    /**
     * @description
     */
    public void tTryLock() {
        boolean captured = lock.tryLock();//
        try {
            if (captured) {
                System.out.println("mathod tryLock is not available");
                Thread.sleep(3000);
            } else {
                System.out.println("mathod tryLock is available--");
            }
        } catch (InterruptedException e) {
            System.out.println("mathod tryLock throw InterruptedExecption");
        } finally {
            if (captured) {
                lock.unlock();
                System.out.println("mathod tryLock is available");
            }
        }
    }

    /**
     * @description
     */
    public void tTryLock2() {
        boolean captured = false;
        try {
            captured = lock.tryLock(6, TimeUnit.SECONDS);
            if (captured) {
                System.out.println("mathod tryLock2 is not available");
            } else {
                System.out.println("mathod trylock2 is available++");
            }
        } catch (InterruptedException e) {
            System.out.println("mathod trylock2 throw InterruptedException");
        } finally {
            if (captured) {
                lock.unlock();
                System.out.println("mathod trylock2 is available");
            }
        }
    }

    public void tInterruptLock() {
        try {
            lock.lockInterruptibly();
            System.out.println("mathod interruptlock is not available");
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            System.out.println("mathod interruptlock throw InterruptException");
        } finally {
            if (lock.isLocked()) {
                lock.unlock();
                System.out.println("mathod interruptlock is available");
            }
        }
    }
}
