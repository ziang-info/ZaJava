package info.ziang.java.thread;

import java.util.ArrayList;
import java.util.List;

public class VolatileDemo {
    private volatile List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        VolatileDemo demo = new VolatileDemo();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo.list.add(i);
                System.out.print(Thread.currentThread().getName());
                System.out.println(demo.list);

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo.list.add(i);
                System.out.print(Thread.currentThread().getName());
                System.out.println(demo.list);

                try {
                    Thread.sleep(330);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
