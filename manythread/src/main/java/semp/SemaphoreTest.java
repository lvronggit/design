package semp;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 */
public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);

        semaphore.acquire();

        System.out.println("leave");

    }

}
