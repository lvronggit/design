package nio.myself;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class MyselfNioServer {

    public static final int port = 9991;
    private Selector selector;

    private void init() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设备为非阻塞
        serverSocketChannel.configureBlocking(false);
        //注册服务器
        serverSocketChannel.bind(new InetSocketAddress(port));
        // 创建一个选择器
        this.selector = Selector.open();
        // 服务通道注册到选择器并且注册接收事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(true){
            // 获取准备好的事件,阻塞
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                // 处理事件
                if(key.isAcceptable()){
                    doConnect(key);
                }else if(key.isReadable()){
                    doRead(key);
                }else if(key.isWritable()){
                    doWrite(key);
                }

            }

        }

    }

    public void doConnect(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
        //获取到客户端通道
        SocketChannel socketChannel = channel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.finishConnect();
        // 注册到读
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    public void  doRead(SelectionKey selectionKey) throws IOException {
        String http ="";
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while(socketChannel.read(byteBuffer)>0){
            byteBuffer.flip();
            http = new String(byteBuffer.array()).trim();
            byteBuffer.clear();
        }
        System.out.println(http);
        //判断给客户端响应
        responseClient(http, socketChannel);
      //  socketChannel.register(selector, SelectionKey.OP_WRITE);
        //  socketChannel.close();
    }

    public void doWrite(SelectionKey selectionKey) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("你想知道啥".getBytes());
        byteBuffer.flip();
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
       if(byteBuffer.hasRemaining()){
           socketChannel.write(byteBuffer);
       }
        byteBuffer.compact();
        socketChannel.close();
    }

    private void responseClient(String http, SocketChannel socketChannel) throws IOException {
        if(http.indexOf("需要")>=0){
            // 需要响应则给客户端响应
            socketChannel.register(selector, SelectionKey.OP_WRITE);
            return;
        }
        socketChannel.close();
    }

    public static void main(String[] args) throws IOException {
        MyselfNioServer server = new MyselfNioServer();
        server.init();
    }


}
