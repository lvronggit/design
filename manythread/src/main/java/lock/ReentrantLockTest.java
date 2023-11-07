package lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static int count = 0;

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        reentrantLock.lock();
        countDis();
        reentrantLock.unlock();


    }



    public  static void  countDis(){
        if(count>0){
            count--;
        }
        System.out.println(count);
    }
}
