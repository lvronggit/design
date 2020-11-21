package lock;

import java.util.concurrent.locks.StampedLock;

/**
 * 如果执行乐观读操作的期间，存在写操作，会把乐观读升级为悲观读锁。这个做法挺合理的，否则你就需要在一个循环里反复执行乐观读，
 * 直到执行乐观读操作的期间没有写操作（只有这样才能保证 x 和 y 的正确性和一致性），而循环读会浪费大量的 CPU。升级为悲观读锁，
 * 代码简练且不易出错，建议你在具体实践时也采用这样的方法。
 *
 * StampedLock 使用注意事项对于读多写少的场景 StampedLock 性能很好，
 * 简单的应用场景基本上可以替代 ReadWriteLock，
 * 但是 StampedLock 的功能仅仅是 ReadWriteLock 的子集，在使用的时候，
 * 还是有几个地方需要注意一下。
 * StampedLock 在命名上并没有增加 Reentrant，想必你已经猜测到 StampedLock 应该是不可重入的。
 * 事实上，的确是这样的，StampedLock 不支持重入。这个是在使用中必须要特别注意的。
 * 另外，StampedLock 的悲观读锁、写锁都不支持条件变量，这个也需要你注意。
 * 还有一点需要特别注意，那就是：如果线程阻塞在 StampedLock 的 readLock() 或者 writeLock() 上时，
 * 此时调用该阻塞线程的 interrupt() 方法，会导致 CPU 飙升。例如下面的代码中，
 * 线程 T1 获取写锁之后将自己阻塞，线程 T2 尝试获取悲观读锁，也会阻塞；
 * 如果此时调用线程 T2 的 interrupt() 方法来中断线程 T2 的话，
 * 你会发现线程 T2 所在 CPU 会飙升到 100%。
 * final StampedLock lock  = new StampedLock();Thread T1 = new Thread(()->{  // 获取写锁  lock.writeLock();
 * // 永远阻塞在此处，不释放写锁
 * LockSupport.park();});T1.start();
 * // 保证T1获取写锁Thread.sleep(100);Thread T2 = new Thread(()->
 * //阻塞在悲观读锁  lock.readLock());T2.start();
 * // 保证T2阻塞在读锁Thread.sleep(100);
 * //中断线程T2
 * //会导致线程T2所在CPU飙升T2.interrupt();T2.join();
 * 所以，使用 StampedLock 一定不要调用中断操作，如果需要支持中断功能，
 * 一定使用可中断的悲观读锁 readLockInterruptibly() 和写锁 writeLockInterruptibly()。这个规则一定要记清楚。
 *
 */
class Point {
    private int x, y;
    final StampedLock sl =
            new StampedLock();

    //计算到原点的距离
    int distanceFromOrigin() {
        // 乐观读
        long stamp =
                sl.tryOptimisticRead();
        // 读入局部变量，
        // 读的过程数据可能被修改
        int curX = x, curY = y;
        //判断执行读操作期间，
        //是否存在写操作，如果存在，
        //则sl.validate返回false
        if (!sl.validate(stamp)) {
            // 升级为悲观读锁
            stamp = sl.readLock();
            try {
                curX = x;
                curY = y;
            } finally {
                //释放悲观读锁
                sl.unlockRead(stamp);
            }
        }
        return (int) Math.sqrt(curX * curX + curY * curY);
    }
}