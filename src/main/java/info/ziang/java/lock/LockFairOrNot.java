package info.ziang.java.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockFairOrNot {

    /**
     * Use fair or non-fair
     */
    public static ReentrantLock lock = new ReentrantLock(false);

    public static void main(String[] args) throws Exception {
        Thread t1 = new TestThread();
        Thread t2 = new TestThread();
        t1.start();
        t2.start();
    }
}

class TestThread extends Thread {
    @Override
    public void run() {
        /**
         * 循环次数
         */
        int num = 1000;
        while (num-- > 0)
            try {
                LockFairOrNot.lock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                LockFairOrNot.lock.unlock();
            }
    }
}