package info.ziang.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditonDemo {

    private final Lock lock = new ReentrantLock(false);

    private final Condition addConditon = lock.newCondition();
    private final Condition subConditon = lock.newCondition();

    private volatile int num = 0;
    private List<String> list = new ArrayList<>();

    public void add() {
        for (int i = 0; i < 10; i++) {
            lock.lock();

            try {

                // 数据>3时候，停止增加
                if (list.size() > 3) {

                    //subConditon.signal();

                    addConditon.await();
                }

                num++;

                Thread.sleep(300);

                list.add("add " + num);

                System.out.println("The list size is " + list.size());
                System.out.println("The add thread is " + Thread.currentThread().getName());
                System.out.println("-------------");

                subConditon.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void sub() {
        for (int i = 0; i < 10; i++) {
            lock.lock();

            try {

                // 数据空的时候，停止减除
                if (list.size() == 0) {
                    //addConditon.signal();

                    subConditon.await();
                }

                num--;
                Thread.sleep(300);
                list.remove(0);

                System.out.println("The list size is " + list.size());
                System.out.println("The sub thread is " + Thread.currentThread().getName());
                System.out.println("-------------");

                addConditon.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        LockConditonDemo task = new LockConditonDemo();
        new Thread(task::add).start();
        new Thread(task::sub).start();
    }
}
