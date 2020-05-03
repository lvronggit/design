package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NioTCPServer {
    //缓冲区长度
    private static final int BUFSIZE = 1024;
    //接受数据的缓冲区
    private static ByteBuffer byteBuffer;

    public static void tcpServer()  throws Exception{
        System.out.println("服务器启动");
        //创建一个选择器
        Selector selector = Selector.open();
        //实例化一个通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //将通道绑定到指定端口(6789)
        serverSocketChannel.socket().bind(new InetSocketAddress(6789));
        //配置通道为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //将选择器注册到通道上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //初始化缓冲区的大小
        byteBuffer = ByteBuffer.allocateDirect(BUFSIZE);
        //不断轮询select方法，获取准备好的通道关联的key集
        while(true) {
            //一直等待，直到有通道准备好了数据的传输，在此处异步执行其他任务（3000为select方法等待信道准备好的最长时间）
            if (selector.select(3000) == 0) {
                //异步执行其他任务
                continue;
            }
            //获取准备好的通道中关联的Key集合的Iterator
            Iterator<SelectionKey> selectionKeyIter = selector.selectedKeys().iterator();
            //循环获取集合中的键值
            while(selectionKeyIter.hasNext()) {
                SelectionKey key = selectionKeyIter.next();
                //服务端对哪种信号感兴趣就执行那种操作
                if(key.isAcceptable()) {
                    System.out.println("accept");

                    //连接好了，然后将读注册到选择器中
                    readRegister(selector,key);
                }
                //上一部将读注册到选择器中之后，如果客户端发送数据，就可以读取到数据，还可以将发送到客户端
                if(key.isReadable()) {
                    readDataFromSocket(key);
                }
                if (key.isValid() && key.isWritable()) {
                    System.out.println("write");
                }
                //需要手动从键集中移除当前key
                selectionKeyIter.remove();
            }
        }
    }

    //将读注册到选择器中
    private static void readRegister(Selector selector, SelectionKey key) throws IOException {
        //从key中获取关联的通道（此处是ServerSocketChannel，因为需要将服务器的检测模式注册到选择器中）
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        //获取通道实例
        SocketChannel channel = serverSocketChannel.accept();
        //设置为非阻塞模式
        channel.configureBlocking(false);
        //将读注册到选择器中
        channel.register(selector, SelectionKey.OP_READ);
    }

    private static void readDataFromSocket(SelectionKey key) throws Exception {
        //从与key关联的通道中获取数据，首先获取关联的通道（此处是SocketChannel，因为与客户端通信是通过SocketChannel，数据都放在其中）
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int count;
        //清除缓冲区（此处清除不能实际擦出buffer中的数据，而是回归各个标志位）
        byteBuffer.clear();
        //从通道中读取数据到缓冲区中，读到最后没有数据则返回-1
        while ((count = socketChannel.read(byteBuffer)) > 0) {
            //向客户端发送数据（hasRemaining告知当前位置和限制之间是否存在任何元素）
            while (byteBuffer.hasRemaining()) {
                //将buffer切换到读状态
                byteBuffer.flip();
                //下面是将buffer转换成字符串
                CharBuffer charBuffer = null;
                Charset charset = Charset.forName("UTF-8");
                /**
                 * 使用注释会出现的问题：当客户端发送汉字，或者16进制数据时，会报异常
                 * CharsetDecoder decoder = charset.newDecoder();
                 charBuffer = decoder.decode(byteBuffer);
                 */
                //使用此方法不会出现异常，但是汉字会显示成?号（可能是编码不对应），但是发送数据的时候，发送汉字不会出现编码问题
                charBuffer = charset.decode(byteBuffer);
                //打印客户端发送的数据
                System.out.println("接受的数据:" + charBuffer.toString());
                //保存至数据库的数据
                String data = charBuffer.toString();
                //将数据保存数据库
                //ConnectionMysql.insert(data);
                //查询所有数据
                //ConnectionMysql.select();
            }
            byteBuffer.clear();
        }
        //发送数据给客户端
        //sentDataClient(socketChannel);

        if (count < 0) {
            socketChannel.close();
        }
    }

    //向客户端发送数据
    public static void sentDataClient(SocketChannel socketChannel) throws IOException {
        /**
         * 将自定义的数据发送给客户端
         */
        ByteBuffer sentBuffer = ByteBuffer.allocateDirect(20);
        sentBuffer.put("456e我".getBytes());
        sentBuffer.flip();
        //在向通道写数据的时候，需要将buffer给flip()
        socketChannel.write(sentBuffer);
    }

    public static void main(String[] args) throws Exception{
        tcpServer();
    }
}
