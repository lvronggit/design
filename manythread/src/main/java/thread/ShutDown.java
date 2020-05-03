package thread;

/**
 * 利用标识位中断线程
 */
public class ShutDown {

    public static void main(String[] args) throws InterruptedException {
        CountThread countThread = new CountThread();
        Thread thread = new Thread(countThread);
        thread.start();
        Thread.sleep(1000);
        countThread.cancel();

        CountThread countThread2 = new CountThread();
        Thread thread2 = new Thread(countThread2);
        thread2.start();
        Thread.sleep(1000);
        thread2.interrupt();

    }


    /**
     * Java支持多个线程同时访问一个对象或者对象的成员变量，
     * 由于每个线程可以拥有这个 变量的拷贝（虽然对象以及成员变量分配的内存是在共享内存中的，
     * 但是每个执行的线程还是 可以拥有一份拷贝，这样做的目的是加速程序的执行，
     * 这是现代多核处理器的一个显著特 性），所以程序在执行过程中，一个线程看到的变量并不一定是最新的。
     */
    static class CountThread implements Runnable {
        private boolean on = true;
        private long i;
        private Object object = new Object();

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println(i);
        }

        public void cancel() {
            synchronized (object) {
                on = false;
            }
        }

    }
}
