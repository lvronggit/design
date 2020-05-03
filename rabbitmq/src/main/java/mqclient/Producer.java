package mqclient;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeoutException;

public class Producer {
    public final static String QUEUE_NAME = "hello";
    public final static String TASK_QUEUE_NAME = "workqueue";

    public final static String EXCHANGEQUEUE = "equeue";
    public final static String EXCHANGEQUEUE2 = "equeue2";


    Channel channel;
    Connection conn;

    public Producer() throws IOException, TimeoutException {
        Common common = new Common();
        // 获取信道
        conn = common.getConnection();
        channel = conn.createChannel();

    }

    /**
     * 直接通过队列发送消息
     */

    public void sendqueue() throws IOException, TimeoutException {
        boolean durable = false;
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
        //发布消息
        byte[] messageBodyBytes = "helloword".getBytes();

        channel.basicPublish("", QUEUE_NAME, null, messageBodyBytes);

        channel.close();
        conn.close();
    }

    //消息确认
    public void sendWorkQueue() throws IOException, TimeoutException {
        // 声明一个交换机
        channel.exchangeDeclare("logs", "fanout");

        boolean durable = false;
        channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);
        //发布消息
        byte[] messageBodyBytes = "等待.确认".getBytes();
        channel.basicPublish("", TASK_QUEUE_NAME, null, messageBodyBytes);
        channel.close();
        conn.close();

    }


    // 交换机发送消息
    public void sendExchange() throws IOException, TimeoutException {
        //声明交换器
        String exchangeName = "logs";
        // 声明交换机名称为logs,类型为fanout
        channel.exchangeDeclare(exchangeName, "fanout");

        String routingKey = "hola";
        // 队列绑定交换机

        //发布消息
        byte[] messageBodyBytes = "exchange".getBytes();

        channel.basicPublish(exchangeName, "", null, messageBodyBytes);

        channel.close();
        conn.close();
    }

    // 队列绑定路由发送消息
    public void sendExchangeroutingKey() throws IOException, TimeoutException, InterruptedException {
        //声明交换器
        String exchangeName = "routings";

        // 声明交换机名称为logs,类型为direct 通过路由发送
        channel.exchangeDeclare(exchangeName, "direct");
     //   channel.queueBind("routingqueue", exchangeName, "error");

        channel.basicPublish(exchangeName, "error", null, "错误日志".getBytes());
        Thread.sleep(10000);
        channel.basicPublish(exchangeName, "info", null, "s输出日志".getBytes());
        Thread.sleep(10000);
        channel.basicPublish(exchangeName, "debugger", null, "s输出日志".getBytes());
        channel.close();
        conn.close();
    }

    // 等待消息返回
    public void conformsend() throws IOException {
        // 信道需要连接
        channel.confirmSelect();
        channel.addConfirmListener((sequenceNumber, multiple) -> {
            // code when message is confirmed
        }, (sequenceNumber, multiple) -> {
            // code when message is nack-ed
        });

    }




    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Producer producer = new Producer();
        //   producer.sendqueue();
       // producer.sendWorkQueue();
     //  producer.sendExchange();
        producer.sendExchangeroutingKey();
    }

}
