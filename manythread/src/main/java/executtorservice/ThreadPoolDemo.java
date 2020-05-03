package executtorservice;

import java.util.concurrent.*;

/**
 * 利用线程池执行任务
 */
public class ThreadPoolDemo {
    private int corePoolSize  = 2;
    private  int maximumPoolSize = 1000;
    private long keepAliveTime =  6<< 32;
    private BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(16);
    private ThreadFactory threadFactory = new SelfThreadFactory();

    public ThreadPoolDemo() {
    }

    public ThreadPoolDemo(BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        this.workQueue = workQueue;
        this.threadFactory = threadFactory;
    }

    public ThreadPoolDemo(int corePoolSize, int maximumPoolSize, long keepAliveTime, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.workQueue = workQueue;
        this.threadFactory = threadFactory;
    }



    public ThreadPoolExecutor getThreadPoolExecutor(){
       return  new ThreadPoolExecutor(corePoolSize, maximumPoolSize,keepAliveTime,TimeUnit.SECONDS, workQueue, threadFactory);
    }





}
