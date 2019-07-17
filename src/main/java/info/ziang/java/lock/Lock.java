package info.ziang.java.lock;

public interface Lock {
    void lock() throws InterruptedException;

    void unlock();
}
