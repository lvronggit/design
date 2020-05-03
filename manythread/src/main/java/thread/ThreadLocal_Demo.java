package thread;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal demo
 */
public class ThreadLocal_Demo {


    // 第一次get()方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        ThreadLocal_Demo.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + ThreadLocal_Demo.end() + " mills");
        Thread thread = new Thread(new ThreadInner());
        thread.start();
        Thread.sleep(1100);
    }


    static class  ThreadInner implements Runnable{



        public static final void begin() {
            TIME_THREADLOCAL.set(100L);
        }

        public static final long end() {
            return  TIME_THREADLOCAL.get();
        }


        @Override
        public void run() {
            ThreadInner.begin();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Cost: " + ThreadInner.end() + " mills");
        }
    }


}
