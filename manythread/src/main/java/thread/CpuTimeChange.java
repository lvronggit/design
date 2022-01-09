package thread;

/**
 * 测试多线程和单线程的时间
 */
public class CpuTimeChange {
    public static final int times = 1000000000;

    public static void main(String[] args) {
        new OneThread().count();
        new Manythread().cont();


    }

    static class Manythread {
        int b = 0;

        public void cont() {
            long start = System.currentTimeMillis();
            Thread thread = new Thread(() -> {

                for (int i = 0; i <= times; i++) {
                    b++;
                }
            });

            thread.start();
            int a = 0;
            for (int i = 0; i <= times; i++) {
                a++;
            }

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start + "a" + a + "b" + b);
        }
    }

    static class OneThread {

        public void count() {
            long start = System.currentTimeMillis();
            int b = 0;
            for (int i = 0; i <= times; i++) {
                b++;
            }
            int a = 0;
            for (int i = 0; i <= times; i++) {
                a++;
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start + "a" + a + "b" + b);
        }

    }


}
