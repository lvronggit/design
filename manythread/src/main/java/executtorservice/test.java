package executtorservice;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class test {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;
    private static final AtomicInteger ctl = new AtomicInteger(RUNNING | 0);

    private static int count  = 0;


    public static void main(String[] args) throws InterruptedException {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
        ThreadPoolExecutor threadPoolExecutor = threadPoolDemo.getThreadPoolExecutor();

//        System.out.println(Integer.toBinaryString(COUNT_BITS));
//        System.out.println(Integer.toBinaryString(RUNNING));
//        System.out.println(Integer.toBinaryString(SHUTDOWN));
//        System.out.println(Integer.toBinaryString(STOP));
//        System.out.println(Integer.toBinaryString(TIDYING));
//        System.out.println(Integer.toBinaryString(TERMINATED));
//        System.out.println(Integer.toBinaryString(CAPACITY));
//        System.out.println(Integer.toBinaryString(ctl.get()));


        while(1==1){
            threadPoolExecutor.execute(new Sleep());
        }

    }


    private static class Sleep implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            try {
                count++;
                System.out.println(count);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
