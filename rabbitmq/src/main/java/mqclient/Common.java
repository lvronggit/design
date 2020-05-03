package mqclient;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Common {
    private Connection conn;

    public Connection getConnection() throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("123456");
        //设置 RabbitMQ 地址
        factory.setHost("172.16.128.93");
        //建立到代理服务器到连接
        conn = factory.newConnection();
        return conn;
    }


}
