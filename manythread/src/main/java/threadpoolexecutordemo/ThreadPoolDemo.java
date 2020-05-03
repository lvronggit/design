package threadpoolexecutordemo;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolDemo {
    public static void main(String[] args) throws Exception {
        System.out.println();
        new Thread(() -> {
            System.out.println("起来一个多线程");
        }).start();
    }
}
