package bio.client;/*
 * Copyright (C), 2002-2024, 汇付天下
 * FileName: Test.java
 * Author:   rong.lv
 * Date:     2024/9/18 16:46
 * Description: //模块目的、功能描述
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    static long count = 0;
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("left启动");
                count = new Test().batchProcess("left");
            }
        });
        thread.start();
        new Test().batchProcess("right");
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("全部结束"+count);

    }


    public long batchProcess(String name
    ) {
        /**
         * 创建线程池
         */

        long start_time = System.currentTimeMillis();
        int totalNum = 29000;
        ExecutorService poolExecutor = Executors.newFixedThreadPool(3,
                new ThreadFactory() {
                    AtomicInteger atomicInteger = new AtomicInteger(10);

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName(name+"数据清洗线程" + atomicInteger.getAndIncrement());
                        return thread;
                    }
                });
        int pageSize = 10000;
        int totalPage = (totalNum % pageSize == 0 ? (totalNum / pageSize) : (totalNum / pageSize + 1));
        try {
            final CountDownLatch cdl = new CountDownLatch(totalPage); //计数器
            for (int j = 1; j <= (totalPage); j++) {
                int start = pageSize * (j - 1);
                int pageNums = j;
                int end = start + pageSize;
                poolExecutor.submit(() -> {
                    try {
                        Thread.sleep(10000);
                        System.out.println(name+totalPage);
                      
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        cdl.countDown();
                    }
                });
            }
            cdl.await();
            poolExecutor.shutdown();
        } catch (Exception e) {

        }
        return totalNum;
    }
}
