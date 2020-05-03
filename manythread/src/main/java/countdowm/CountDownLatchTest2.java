package countdowm;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest2 {

    static CountDownLatch c = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {

        for(int i = 0; i<3 ; i++){
           new Thread(new Inner()).start();
        }
        Thread.sleep(20000);
        c.countDown();
    }




    static class Inner implements Runnable{
        @Override
        public void run() {
            try {
                int namiao = new Random().nextInt(10000);
                Thread.sleep(namiao);
                System.out.println(Thread.currentThread().getName()+"等待");
                c.await();
                System.out.println(namiao);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
