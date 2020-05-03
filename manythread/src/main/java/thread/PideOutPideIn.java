package thread;

import oracle.jrockit.jfr.jdkevents.ThrowableTracer;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 线程管道
 */
public class PideOutPideIn {
    static PipedInputStream in = null;
    static PipedOutputStream out = null;

    public static void main(String[] args) throws IOException {

        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();
        // 流入管道和流出管道
        out.connect(in);
        Thread inThread = new Thread(new PideIn(in),"inthread");
        inThread.start();

        int receive = 0;

        while ((receive = System.in.read()) != -1){
            out.write(receive);

        }




    }


    static class PideIn implements Runnable {
        PipedInputStream in = null;

        public PideIn(PipedInputStream in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print(((char) receive));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
