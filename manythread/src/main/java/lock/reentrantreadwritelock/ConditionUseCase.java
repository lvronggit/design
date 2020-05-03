package lock.reentrantreadwritelock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionUseCase {
    Lock lock =  new ReentrantLock();
    Condition condition = lock.newCondition();
    public void conditionWait() throws InterruptedException {
        lock.lock();
        try {
            Thread.sleep(50000);
            condition.await();
        } finally {
            lock.unlock();
        }
    }

    public void conditionSignal() throws InterruptedException {
        lock.lock();
        try {
            condition.signal();

        } finally {
            lock.unlock();
        }
        Thread.sleep(200000);
    }



    public static void main(String[] args) {
        final ConditionUseCase conditionUseCase = new ConditionUseCase();

        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    conditionUseCase.conditionWait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("等待线程");
        thread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    conditionUseCase.conditionSignal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.setName("唤醒线程");
        thread2.start();
        try {
            Thread.sleep(10002200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
