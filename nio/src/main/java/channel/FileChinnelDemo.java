package channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChinnelDemo {

    public void copy() throws IOException {

        FileChannel channel = new FileInputStream("C:\\Users\\lvrong\\Desktop\\日志.txt").getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
        int len = channel.read(byteBuffer);
        System.out.println(len);
        FileChannel channel2 = new FileOutputStream("C:\\Users\\lvrong\\Desktop\\llllllll.txt").getChannel();
        byteBuffer.flip();
        System.out.println((char) byteBuffer.get());
        channel2.write(byteBuffer);
        channel2.close();
        byteBuffer.clear();
    }


    public void copy2() throws IOException {
        FileChannel channel = new FileInputStream("C:\\Users\\lvrong\\Desktop\\日志.txt").getChannel();
        FileChannel channel2 = new FileOutputStream("C:\\Users\\lvrong\\Desktop\\2222222.txt").getChannel();
        channel2.transferFrom(channel, 0,channel.size());

    }

    public void copy3() throws IOException {
        FileChannel channel = new FileInputStream("C:\\Users\\lvrong\\Desktop\\日志.txt").getChannel();
        FileChannel channel2 = new FileOutputStream("C:\\Users\\lvrong\\Desktop\\222222222222.txt").getChannel();
        channel.transferTo(0, channel.size(),channel2);

    }


    public static void main(String[] args) throws IOException {
        FileChinnelDemo fileChinnelDemo = new FileChinnelDemo();
        fileChinnelDemo.copy2();
        fileChinnelDemo.copy3();
    }
}
