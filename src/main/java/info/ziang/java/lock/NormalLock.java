package info.ziang.java.lock;

/**
 * 不可重入锁
 */
public class NormalLock implements Lock{
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}