package bio.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SelfClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        InetSocketAddress socketAddress = new InetSocketAddress("localhost",5200);
        socket.connect(socketAddress);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello".getBytes());
        outputStream.flush();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        inputStream.read(bytes);
        String clientReq = new String(bytes);
        System.out.println(clientReq);

    }

}
