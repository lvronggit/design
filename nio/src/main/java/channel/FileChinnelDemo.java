package channel;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class FileChinnelDemo {
    /**
     * 读取文件数据
     * @throws IOException
     */
    @Test
    public void read() throws IOException {
        FileChannel channel = new FileInputStream("C:\\Users\\rong.lv\\Desktop\\niofile.txt").getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        while (channel.read(byteBuffer)>0){
            byteBuffer.flip();
            String str = StandardCharsets.UTF_8.decode(byteBuffer).toString();
            System.out.println(str);
            byteBuffer.clear();
        };
        channel.close();
        byteBuffer.clear();
    }

    /**
     * 复制文件数据
     * @throws IOException
     */
    @Test
    public void copy() throws IOException {
        FileChannel channel = new FileInputStream("C:\\Users\\rong.lv\\Desktop\\niofile.txt").getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        FileChannel channel2 = new FileOutputStream("C:\\Users\\rong.lv\\Desktop\\niofile - 副本.txt").getChannel();
        int len = 0;
        while ( (len = channel.read(byteBuffer))>0){
            byteBuffer.flip();
            channel2.write(byteBuffer);
            byteBuffer.flip();
        }
        channel2.close();
        channel.close();
        byteBuffer.clear();
    }

    @Test
    public void copy2() throws IOException {
        FileChannel channel = new FileInputStream("C:\\Users\\lvrong\\Desktop\\日志.txt").getChannel();
        FileChannel channel2 = new FileOutputStream("C:\\Users\\lvrong\\Desktop\\2222222.txt").getChannel();
        channel2.transferFrom(channel, 0,channel.size());

    }
    @Test
    public void copy3() throws IOException {
        FileChannel channel = new FileInputStream("C:\\Users\\lvrong\\Desktop\\日志.txt").getChannel();
        FileChannel channel2 = new FileOutputStream("C:\\Users\\lvrong\\Desktop\\222222222222.txt").getChannel();
        channel.transferTo(0, channel.size(),channel2);

    }


}
