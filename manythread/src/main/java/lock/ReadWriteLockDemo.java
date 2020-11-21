package lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁，并不是 Java 语言特有的，而是一个广为使用的通用技术，所有的读写锁都遵守以下三条基本原则：
 * 允许多个线程同时读共享变量；
 * 只允许一个线程写共享变量；
 * 如果一个写线程正在执行写操作，此时禁止读线程读共享变量。
 * <p>
 * 读写锁与互斥锁的一个重要区别就是读写锁允许多个线程同时读共享变量，
 * 而互斥锁是不允许的，这是读写锁在读多写少场景下性能优于互斥锁的关键。
 * 但读写锁的写操作是互斥的，当一个线程在写共享变量的时候，是不允许其他线程执行写操作和读操作
 * <p>
 * 读写锁的缓存实现
 * <p>
 * 不加锁会导致多线程读取数据不一致问题
 * <p>
 * <p>
 * <p>
 * 设计1，加同一把锁则每个线程读取数据都要等待，缓存读多写少
 * <p>
 * 设计2  加读写锁，缓存失效的时候加写锁，缓存还在的时候家读锁，多个线程访问数据不会阻塞
 */
public class ReadWriteLockDemo<k, v> {
    final Map<k, v> map = new HashMap();

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();


    public v getCache(k key) {
        v obj;
        try {
            readLock.lock();
            obj = map.get(key);
        } finally {
            readLock.unlock();
        }

        if (obj == null) {
            try {
                writeLock.lock();
                v v = map.get(key);
                // 去判断是否其他线程已经缓存数据了，所以再去获取一次判断是不是空
                if (v == null) {
                    // 存放缓存数据
                    //  map.put(key, );
                }

            } finally {
                writeLock.unlock();
            }

        }

        return obj;
    }


    /**
     * ReadWriteLock 并不支持这种升级。在上面的代码示例中，读锁还没有释放，
     * 此时获取写锁，会导致写锁永久等待，最终导致相关线程都被阻塞，
     * 永远也没有机会被唤醒。锁的升级是不允许的，这个你一定要注意
     */

//读缓存
  /*  public demo() {
        readLock.lock();         ①
        try {
            v = m.get(key); ②
            if (v == null) {
                w.lock();
                try {
                    //再次验证并更新缓存
                    //省略详细代码
                } finally {
                    w.unlock();
                }
            }
        } finally {
            r.unlock();     ③
        }
    }*/

}
