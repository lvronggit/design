package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class MyServer {
    private final static int port = 8989;


    public void init() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
      //  serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        String hello_string = "hello rudy!";
        ByteBuffer buffer = ByteBuffer.wrap(hello_string.getBytes());
        while (true){
            System.out.println("wait for connections");
            SocketChannel clientSocket = serverSocketChannel.accept();
            if (null == clientSocket){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println(String.format("incomimg connection from: %s",clientSocket.getRemoteAddress()));
                buffer.rewind();
                clientSocket.write(buffer);
                clientSocket.close();
            }

        }

    }

    public static void main(String[] args) throws IOException {

        MyServer mu = new MyServer();
        mu.init();
    }
}
