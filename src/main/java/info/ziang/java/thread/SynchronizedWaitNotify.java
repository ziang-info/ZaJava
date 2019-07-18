package info.ziang.java.thread;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedWaitNotify {

    private final List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        SynchronizedWaitNotify demo = new SynchronizedWaitNotify();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (demo.list) {
                    if (demo.list.size() % 2 == 1) {
                        try {
                            demo.list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    demo.list.add(i);
                    System.out.print(Thread.currentThread().getName());
                    System.out.println(demo.list);

                    try {
                        Thread.sleep(550);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    demo.list.notify();
                }
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (demo.list) {
                    if (demo.list.size() % 2 == 0) {
                        try {
                            demo.list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    demo.list.add(i);
                    System.out.print(Thread.currentThread().getName());
                    System.out.println(demo.list);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    demo.list.notify();
                }
            }
        }).start();
    }
}
