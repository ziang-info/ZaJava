package info.ziang.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    public static void main(String[] args) {

        final int cycTimes = 15;
        AtomicInteger ai = new AtomicInteger();

        new Thread(() -> {
            for (int i = 0; i < cycTimes; i++) {

                System.out.print(Thread.currentThread().getName() + ":");
                System.out.println(ai.incrementAndGet());

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < cycTimes; i++) {

                System.out.print(Thread.currentThread().getName() + ":");
                System.out.println(ai.decrementAndGet());

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
