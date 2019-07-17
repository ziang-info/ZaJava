package info.ziang.java.lock;

public class Test {

    public static void main(String[] args) {

        ZaNormalLock normalLock = new ZaNormalLock();
        Counter counter = new Counter(normalLock);

        ZaLock reentrantLock = new ZaReentrantLock();
        Counter counter2 = new Counter(reentrantLock);

        for (int i = 0; i < 10; i++) {
            CounterThread c = new CounterThread(counter2);
            c.start();
        }
    }
}


class CounterThread extends Thread {
    private Counter counter = null;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    /**
     * 操作100次
     */
    private int num = 100;

    public void run() {

        while (num > 0) {
            num--;

            try {
                System.out.println(this.counter.inc());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}