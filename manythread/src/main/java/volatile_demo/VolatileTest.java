package volatile_demo;

public class VolatileTest {

    private static volatile int count;

    public static void main(String[] args) {
         new Thread(new Innner()).start();
        new Thread(new Innner()).start();
        new Thread(new Innner()).start();


    }



    static class Innner implements Runnable{

        @Override
        public void run() {

            while (count != 100){
                count++;
                System.out.println(count);
            }
            System.out.println("结束");

        }
    }

}
