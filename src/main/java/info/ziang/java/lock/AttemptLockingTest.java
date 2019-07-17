package info.ziang.java.lock;

public class AttemptLockingTest {

    static Thread A = null;
    static Thread B = null;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        final AttemptLocking al = new AttemptLocking();

        A = new Thread(new Runnable() {
            public void run() {
                //case1,2,3,4
                al.tLock();
            }
        });

        B = new Thread(new Runnable() {
            @Override
            public void run() {
                // case1
                al.tLock();//等待的过程中调用中断不会中断，当进入时候调用中断会抛出中断异常的

                // case2
                //           al.tTryLock();//可以修改睡眠时间为4s和6s，立即返回不用测试中断

                // case3
                //         al.tTryLock2();//可以修改睡眠时间为4s和6s，等待的时候可以中断

                // case4
                //          al.tInterruptLock();//抛出中断异常
            }
        });

        A.setName("a");
        B.setName("b");
        A.start();
        B.start();
        //case1，3,4
//        B.interrupt();
    }
}
