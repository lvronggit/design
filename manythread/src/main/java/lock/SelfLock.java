package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SelfLock implements Lock {

    private static final class Sync extends AbstractQueuedSynchronizer{
        protected boolean isHeldExclusively() { return getState() == 1; }

        // 重写获取锁的方法
      protected   boolean tryAcquire(int arg){
          if(getState() == 0){
            if(compareAndSetState(0,arg)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
          }
            return false;
        }

      protected  boolean tryRelease(int arg){
          if (getState() == 0) throw new IllegalMonitorStateException();
          setState(arg);
          setExclusiveOwnerThread(null);
          return true;
      }

        Condition newCondition() { return new ConditionObject(); }

    }


    // 仅需要将操作代理到Sync上即可
    private final Sync sync = new Sync();
    public void lock() { sync.acquire(1); }
    public boolean tryLock() { return sync.tryAcquire(1); }
    public void unlock() { sync.release(1); }
    public Condition newCondition() { return sync.newCondition(); }
    public boolean isLocked() { return sync.isHeldExclusively(); }
    public boolean hasQueuedThreads() { return sync.hasQueuedThreads(); }
    public void lockInterruptibly() throws InterruptedException { sync.acquireInterruptibly(1); }public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException { return sync.tryAcquireNanos(1, unit.toNanos(timeout)); }
}
