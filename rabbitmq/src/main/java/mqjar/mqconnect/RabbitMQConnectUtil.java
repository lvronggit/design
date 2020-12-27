package mqjar.mqconnect;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import mqjar.ReceiveContent;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * mq连接服务器工具类
 */
public class RabbitMQConnectUtil {

    private String queueName;
    private String exchangeName = "lvrong";
    private List<String> routingkeys;
    private Map<String, ReceiveContent> receiveContentMap;
    // 单例锁
    private static final Object object = new Object();

    private volatile static RabbitMQConnectUtil rabbitMQConnectUtil;
    private ConnectionFactory connectionFactory ;

    // 获取到单例模式
    public static RabbitMQConnectUtil getInstance() {
        if (rabbitMQConnectUtil == null) {
            synchronized (object) {
                if (rabbitMQConnectUtil == null) {
                    rabbitMQConnectUtil = new RabbitMQConnectUtil();
                }
            }
        }
        return rabbitMQConnectUtil;
    }

    // 初始化mq连接
    public void init(String servIp, String userName, String password,String queueName,List<String> routingkeys ,Map<String, ReceiveContent> receiveContentMap ) {
        // 获取mq连接
        this.connectionFactory = new ConnectionFactory();
        this.connectionFactory.setHost(servIp);
        this.connectionFactory.setUsername(userName);
        this.connectionFactory.setPassword(password);
        this.queueName = queueName;
        this.routingkeys = routingkeys;
        this.receiveContentMap = receiveContentMap;
    }

    // 获取连接
    public Connection getConnection() throws IOException, TimeoutException {
        if(connectionFactory == null){
            throw new RuntimeException("请先初始化");
        }
        return connectionFactory.newConnection();
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public List<String> getRoutingkeys() {
        return routingkeys;
    }

    public void setRoutingkeys(List<String> routingkeys) {
        this.routingkeys = routingkeys;
    }

    public Map<String, ReceiveContent> getReceiveContentMap() {
        return receiveContentMap;
    }

    public void setReceiveContentMap(Map<String, ReceiveContent> receiveContentMap) {
        this.receiveContentMap = receiveContentMap;
    }
}
