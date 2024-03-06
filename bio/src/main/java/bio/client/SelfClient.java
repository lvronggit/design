package bio.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.PriorityQueue;

public class SelfClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket();
        InetSocketAddress socketAddress = new InetSocketAddress("localhost",5200);
        socket.connect(socketAddress);
        int i=0;
        while (true){
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(String.valueOf(i++).getBytes());
            outputStream.flush();
            Thread.sleep(1000);
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            inputStream.read(bytes);
            String clientReq = new String(bytes);
            System.out.println(clientReq);
        }

    }

}
