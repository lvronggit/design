package scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedExcutePoolDemo {
    private static ScheduledExecutorService scheduledExecutorService;

    public static void main(String[] args) throws InterruptedException {

        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor((r) -> {
            Thread thread = new Thread(r, "SchedExcutePoolDemo");
            return thread;
        });
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "定时任务执行" + System.currentTimeMillis());
                } catch (Throwable e) {

                }
            }
        };
        scheduledExecutorService.scheduleAtFixedRate(runnable, 1000 * 3, 1000, TimeUnit.MILLISECONDS);

        Thread.sleep(60000L);
    }

}
