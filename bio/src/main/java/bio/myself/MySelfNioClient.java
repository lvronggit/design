package nio.myself;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class MySelfNioClient {
    public static final int port = 9991;
    private Selector selector;

    public void init() throws IOException {
        selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress(port));

        socketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE | SelectionKey.OP_READ );

        while (true){
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isConnectable()){
                    doConnect(key);
                }else if (key.isReadable()){
                    doRead(key);
                }
            }
        }
    }
    public void doConnect(SelectionKey key) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        SocketChannel clientChannel = (SocketChannel) key.channel();
        if (clientChannel.isConnectionPending()){
            clientChannel.finishConnect();
        }
        clientChannel.configureBlocking(false);
        String info = "ssss!!";
        byteBuffer.clear();
        byteBuffer.put(info.getBytes("UTF-8"));
        byteBuffer.flip();
        clientChannel.write(byteBuffer);
        clientChannel.register(key.selector(),SelectionKey.OP_READ);
       // clientChannel.close();
    }

    public void doRead(SelectionKey key) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        SocketChannel clientChannel = (SocketChannel) key.channel();
        clientChannel.read(byteBuffer);
        byte[] data = byteBuffer.array();
        String msg = new String(data).trim();
        System.out.println("服务端发送消息："+msg);
        clientChannel.close();
      //  key.selector().close();
    }

    public static void main(String[] args) throws IOException {
        MySelfNioClient mySelfNioClient = new MySelfNioClient();
        mySelfNioClient.init();
    }
}
