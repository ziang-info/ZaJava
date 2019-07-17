package info.ziang.java.lock;

public interface ZaLock {
    void lock() throws InterruptedException;

    void unlock();
}
