package channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class ChannelDemo {

    /**
     * Channel为管道，是双向的，在NIO中，有4中Channel，分别为：
     *
     * FileChannel 文件
     * DatagramChannel UDP
     * SocketChannel TCP client
     * ServerSocketChannel TCP Server
     * @param args
     */
    public static void main(String[] args) throws IOException {
        FileChannel fc = null;
        fc= new RandomAccessFile("C:\\Users\\lvrong\\Desktop\\新建文本文档.txt", "rw").getChannel();
        ByteBuffer bf = ByteBuffer.allocate(1024);
      //  bf.put("放进来一些数据".getBytes());
        fc.read(bf);
        bf.flip();
        byte[] b = new byte[1024];
        int i = 0;
        while(bf.hasRemaining()){
            b[i] = bf.get();
            i++;
        }
        String mess = new String(b);
        System.out.println(mess.trim());
        // 打开一个通道
        SocketChannel socketChannel = SocketChannel.open();
        // 发起连接
       // socketChannel.connect(new InetSocketAddress("https://www.javadoop.com", 80));

    }



}
