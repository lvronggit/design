package lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 线程一起执行的方法
 *
 * 1  使用join
 *
 */
public class ThreadCountDown {

    /**
     * jion 实现线程顺序执行
     * @throws InterruptedException
     */
    public void check() throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                //执行a业务
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                //执行B业务
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        threadB.start();
        // 等待Ab执行完之后再继续执行下去

        threadA.join();
        threadB.join();


        System.out.println("a"+"和"+"b都执行完了");


    }

    /**
     * CountDownLatch 实现线程等待
     */
    public void countdownCheck() throws InterruptedException {
        Executor executorService = Executors.newFixedThreadPool(2);

        CountDownLatch countDownLatch = new CountDownLatch(2);

        executorService.execute(() -> {
            System.out.println("执行a业务");
            countDownLatch.countDown();
        });


        executorService.execute(() -> {
            System.out.println("执行b业务");
            countDownLatch.countDown();
        });

        countDownLatch.await();

        System.out.println("都执行完了");

        //


    }




    public static void main(String[] args) throws InterruptedException {
        ThreadCountDown t = new ThreadCountDown();
        t.check();


    }



}
