package future;

import java.util.concurrent.*;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class tst {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<String> submit = executorService.submit(new tst().new print());
        Future<Integer> submit1 = executorService.submit(new tst().new comput());

        System.out.println(submit.get());
        System.out.println(submit1.get());

        System.out.println("执行结束");
        AbstractQueuedSynchronizer
    }


    /**
     * 计算数据
     */
    class  print implements Callable<String> {

        private String  result;

        @Override
        public String call() throws Exception {
            System.out.println("执行打印任务===================");
            for (int i=0;i<10;i++){
                Thread.sleep(1000);
                System.out.println(i);
            }
            result = "ok";
            System.out.println("执行打印任务结束===================");
            return result;
        }
    }

    class comput implements Callable<Integer>{
        private Integer  result;

        @Override
        public Integer call() throws Exception {
            System.out.println("执行计算任务===================");
            Thread.sleep(15000);
            int j = 0;
            for (int i=0;i<10;i++){
                j = j+i;
            }
            result = j;
            System.out.println("执行计算任务结束===================");
            return result;
        }
    }


}
