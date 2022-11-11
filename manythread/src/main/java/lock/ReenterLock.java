package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
public class ReenterLock {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();

        lock.lock();
        lock.unlock();

        lock.tryLock();
        lock.unlock();

        Condition condition = lock.newCondition();

        condition.await();
        condition.signal();
        condition.signalAll();


    }
}
