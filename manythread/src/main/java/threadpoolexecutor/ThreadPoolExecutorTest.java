package threadpoolexecutor;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorTest {

    //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,1000L,);

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(Integer.SIZE - 3));
        System.out.println(Integer.toBinaryString(1<<29 -1));
        System.out.println(Integer.toBinaryString(~(1<<29 -1)));
        System.out.println(Integer.toBinaryString((-1)<<29 | 0));
    }

}
