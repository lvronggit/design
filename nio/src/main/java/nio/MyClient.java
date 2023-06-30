package nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class MyClient {

    private final static int port = 8989;
    private final static String ip = "172.16.130.191";
    public void init() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
       // socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("localhost",port));
        ByteBuffer buffer = ByteBuffer.allocate(100);
        CharBuffer charBuffer = CharBuffer.allocate(100);
        CharsetDecoder decoder = Charset.defaultCharset().newDecoder();
        socketChannel.read(buffer);
        buffer.flip();
        decoder.decode(buffer,charBuffer,false);
        charBuffer.flip();
        while (charBuffer.hasRemaining()){
            System.out.println(charBuffer.get());
        }
        socketChannel.close();


    }

    public static void main(String[] args) throws IOException {
        MyClient myClient = new MyClient();
        myClient.init();
    }
}
