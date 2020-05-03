package thread;

/**
 * 等待通知模型
 */
public class WaitNotify {


    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Wait());
        thread.setName("wwwwwwww");
        thread.start();
        Thread.sleep(100000);
        Thread thread2 = new Thread(new Notify());
        thread.setName("nnnnnnn");
        thread2.start();

    }







    static class Wait implements Runnable {

        @Override
        public void run() {

            try {
                synchronized (object) {
                    object.wait();
                    System.out.println("被唤醒");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (object) {
                object.notifyAll();
            }

        }
    }


}
