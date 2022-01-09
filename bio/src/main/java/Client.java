import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.Enumeration;
import java.util.concurrent.ThreadPoolExecutor;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8999);

        OutputStream outputStream = socket.getOutputStream();

        InputStream inputStream = socket.getInputStream();

        outputStream.write(new byte[]{23,23,24});

        outputStream.flush();
        socket.close();
        System.out.println("结束");

        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();




    }
}
