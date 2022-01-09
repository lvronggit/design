import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(8999);

       while (true){
           Socket accept = serverSocket.accept();

           InputStream inputStream = accept.getInputStream();
           OutputStream outputStream = accept.getOutputStream();
           byte[] bytes = new byte[1024];
           inputStream.read(bytes);
           System.out.println(Arrays.toString(bytes));
           Thread.sleep(10000);
           accept.close();
           System.out.println("结束");
       }



    }
}
