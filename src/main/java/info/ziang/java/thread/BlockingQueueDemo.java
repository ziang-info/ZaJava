package info.ziang.java.thread;

import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {

    public static void main(String[] args) {

        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

        //读线程
        new Thread(() -> {
            int i = 0;
            while (i<10) {
                try {
                    String item = queue.take();
                    System.out.print(Thread.currentThread().getName() + " take: " + i + " ");
                    System.out.println(item);
                    i++;

                    Thread.sleep(100); // Read Fast
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //写线程
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    String item = "go-" + i;
                    System.out.print(Thread.currentThread().getName() + "put: " + i + " ");
                    System.out.println(item);
                    queue.put(item);

                    Thread.sleep(500); // Write Slow
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
