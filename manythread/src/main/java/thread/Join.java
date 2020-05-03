package thread;

import java.util.Random;

/**
 * join()
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println(start);
        Thread thread = null;
        for (int i = 0; i < 10; i++) {
            thread = new Thread(new JoinInnner(thread), "mingzi" + i);
            thread.start();

        }
        thread.join();
        System.out.println(System.currentTimeMillis() - start);

    }


    static class JoinInnner implements Runnable {
        private Thread pre;

        public JoinInnner(Thread pre) {
            this.pre = pre;
        }

        @Override
        public void run() {
            long second = new Random().nextInt(10000);
            System.out.println("second" + second);


            if (pre != null) {
                try {
                    pre.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(second);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());

        }
    }


}
