package info.ziang.java.lock;

public class Counter {
    private Lock lock = null;
    private int count = 0;

    public Counter(Lock lock) {
        this.lock = lock;
    }

    public int inc() throws InterruptedException {
        lock.lock();
        this.count++;

        /**
         * 添加该方法后，如果是不可重入锁，则多线程会出现死锁情况。
         */
        doOtherThing();

        lock.unlock();
        return count;
    }

    public int doOtherThing() throws InterruptedException {
        lock.lock();
        System.out.println("可重入锁能够打印此句。");
        lock.unlock();
        return count;
    }
}