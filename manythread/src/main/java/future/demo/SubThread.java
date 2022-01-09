package future.demo;

import java.util.UUID;

public class SubThread extends Thread{

    private Requestfuture requestfuture;

    @Override
    public void run(){
        try {
            Thread.sleep(20000);
            requestfuture.receive(Thread.currentThread().getName(), UUID.randomUUID().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public SubThread(Requestfuture requestfuture) {
        this.requestfuture = requestfuture;
    }
}
