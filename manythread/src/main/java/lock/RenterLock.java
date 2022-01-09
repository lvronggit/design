package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
public class RenterLock {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            condition.signal();
            lock.unlock();
            System.out.println("唤醒111");
        }).start();

        if (lock.tryLock()) {
        try {
            System.out.println("阻塞");
            condition.await();
            System.out.println("唤醒");
          // manipulate protected state
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
          lock.unlock();
        }
      } else {
        // perform alternative actions
          System.out.println("未获取到锁");
      }




    }




}
