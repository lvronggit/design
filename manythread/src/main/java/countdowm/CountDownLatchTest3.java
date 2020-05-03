package countdowm;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest3 {
    static int size = 10;
    static CountDownLatch sc = new CountDownLatch(1);
    static CountDownLatch ec = new CountDownLatch(size);

    public static void main(String[] args) throws InterruptedException {

        CountDownLatchTest3 countDownLatchTest3 = new CountDownLatchTest3();
        for (int i = 0; i < 10; i++) {
            countDownLatchTest3.runn();
        }
        sc.countDown();
        ec.await();
        System.out.println("比赛结束");
    }

    void runn(){
        new Thread(new CountDownLatchTest3.Runner()).start();
    }

    class Runner implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println("都准备好");
                sc.await();
                Thread.sleep(new Random().nextInt(10000));
                System.out.println("到达终点");
                ec.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
