package lock.reentrantreadwritelock;

public class ReentrantReadWriteLockTest {

    static class WriteInner implements Runnable{
        private void put(){
            int i = 0;
            i++;
            Cache.put(i+"",i);
            System.out.println(Thread.currentThread().getName()+"放进一个数据");
        }

        @Override
        public void run() {
            while(true){
            put();
            }
        }
    }

    static class ReadInner implements Runnable{
        private void get(){
            int i = 1;

            if(!Cache.map.isEmpty() && Cache.map.containsKey(i+"")){
             i++;
             Object object =  Cache.get(i+"");
             System.out.println(Thread.currentThread().getName()+"取得一个数据");
             System.out.println(object);
            }

        }

        @Override
        public void run() {
           while (true){
               get();
           }
        }
    }


    public static void main(String[] args) {

        Thread t =  new Thread(new WriteInner());
        t.setName("第一个写锁");
        t.start();
       Thread t1   = new Thread(new ReadInner());
        t1.setName("第一个读锁");
        t1.start();
       Thread t2 =  new Thread(new ReadInner());
        t2.setName("第二个读锁");
        t2.start();
    }
}
