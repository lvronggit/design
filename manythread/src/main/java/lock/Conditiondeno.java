package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 条件锁
 *
 * 使用 await和single对线程进行资源控制
 *
 * 效果  一定会第一个打出5
 *
 */
public class Conditiondeno {
    private final Lock lock = new ReentrantLock();

    // 条件变量：队列不满
    final Condition wait = lock.newCondition();


    private static Integer id = 10;


    private void print(){
        try {
            lock.lock();
            id--;
            if (id != 5) {
                wait.await();
            }

            System.out.println(id);

            wait.signalAll();
        }catch (Exception e){


        }finally {
            lock.unlock();
        }


    }

    public static void main(String[] args) {

        final Conditiondeno conditiondeno = new Conditiondeno();

        for (int i = 0; i <10 ; i++) {
            Thread    thread = new Thread(() -> conditiondeno.print());
            thread.start();
        }






    }





}
