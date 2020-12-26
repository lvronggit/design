package volatitle;

public class VolatitleTest {

    private  static volatile int count  = 0;


    public static void main(String[] args) {

 for (int i = 0;i<20;i++){
     Thread thread = new Thread(() -> {
       for (int j = 0;j<1000;j++){

               count++;
           System.out.println(count);
       }
     });

     thread.start();
 }

    while (Thread.activeCount()>1){
        Thread.yield();
    }

        System.out.println("==============="+count);
    }



}
