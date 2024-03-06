package bio.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SelfServer {
    public static final int port = 5200;

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(5200);
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
        int i = 0;

            while (true){
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                inputStream.read(bytes);
                String clientReq = new String(bytes);
                System.out.println(clientReq);

                OutputStream outputStream = socket.getOutputStream();
                Thread.sleep(1000);
                outputStream.write((String.valueOf(i++)).getBytes());
                outputStream.flush();
            }
        }


    }

}
