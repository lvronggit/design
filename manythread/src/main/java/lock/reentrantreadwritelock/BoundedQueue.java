package lock.reentrantreadwritelock;

import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
// 阻塞队列
public class BoundedQueue<T> {
    private Object[] items;
    // 添加索引，移除索引，总数
    private int addIndex,removeIndex,count;

    private Lock lock = new ReentrantLock();

    private Condition notEmpty = lock.newCondition();

    private Condition notFull = lock.newCondition();

    // 添加数据进队列
    public boolean addItem(T t) throws InterruptedException {
        lock.lock();
        try {
        while(count == items.length){
                notFull.await();
        }
        items[addIndex] = t;
            System.out.println("放进一个数据");
        if (++addIndex == items.length)
        addIndex = 0;
        count++;
        notEmpty.signal();
        }finally {
            lock.unlock();
        }
        return true;
    }


    public T removeItem() throws InterruptedException {
        lock.lock();
        T t = null;
        try {
        while(count == 0){
            notEmpty.await();
        }
            System.out.println("取出一个数据");
        t = (T)items[removeIndex];
        if (++removeIndex == items.length){
            removeIndex = 0;
        }
        count--;
        notFull.signal();
        }finally {
            lock.unlock();
        }

        return t;
    }

    public BoundedQueue() {
        this.items = new Object[8];
    }
    public BoundedQueue(int size) {
        this.items = new Object[size];
    }

    public static void main(String[] args) {
       final BoundedQueue<String> boundedQueue = new BoundedQueue<String>(10);

        final Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                   while (true){
                       Thread.sleep(500);
                       boundedQueue.addItem(UUID.randomUUID().toString());
                   }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("放进队列====");
        thread.start();
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                 while (true){
                     Thread.sleep(1000);
                    String s = boundedQueue.removeItem();
                    System.out.println(s);
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.setName("取出队列====");
        thread2.start();


    }

}
