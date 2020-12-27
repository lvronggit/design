package mqclient;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import static mqclient.Producer.QUEUE_NAME;
import static mqclient.Producer.TASK_QUEUE_NAME;

public class Consumer {
    private final Channel channel;
    private final Connection conn;

    public Consumer() throws IOException, TimeoutException {
        Common common = new Common();
        conn = common.getConnection();
        channel = conn.createChannel();
    }
    // 直接队列一对一接收
    public void receive() throws IOException {
        channel.queueDeclare(QUEUE_NAME, false , false ,false,null);
        // 接收消息的回调函数
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println("接收到消息"+consumerTag);
            System.out.println(" [x] Received '" + message + "'");
        };
        // 阻塞消费
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
    }


    public void receiveWordQueue() throws IOException {
        // 一次只接收一条消息
        channel.basicQos(1);
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);


            try {
                doWork(message);
                System.out.println(" [x] Received '" + message + "'");
                // 完成后消息确认  autoAck 为false需要
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            } finally {
                System.out.println(" [x] Done");
            }
        };
        boolean autoAck = false; // acknowledgment is covered below 消息自动确认

        channel.basicConsume(TASK_QUEUE_NAME, autoAck, deliverCallback, consumerTag -> { });
    }


    public void reciiveExchange() throws IOException {

        channel.exchangeDeclare("logs", "fanout");
        // 创建一个随机名字的队列
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, "logs", "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    }


    public void  receiveExchangeroutingKey(String queueName, String routing) throws IOException {
        //声明交换器
        String exchangeName = "routings";
        channel.exchangeDeclare(exchangeName, "direct");
        channel.queueDeclare(queueName, true, false, false,null);
        // 对联绑定交换机和路由
        channel.queueBind(queueName, exchangeName, routing);
        channel.queueBind(queueName, exchangeName, "info");
        DeliverCallback deliverCallback = ((consumerTag, delivery) -> {
            System.out.println(delivery.getEnvelope().getRoutingKey()+"=========="+new String(delivery.getBody()));
        });

        channel.basicConsume(queueName, true, deliverCallback ,(consumerTag) -> { });

    }


    private static void doWork(String task)  {
        for (char ch: task.toCharArray()) {
            if (ch == '.') {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public static void main(String[] args) throws IOException, TimeoutException {
       // Consumer consumer  = new Consumer();
        //consumer.receive();
        //consumer.receiveWordQueue();
      //  consumer.reciiveExchange();
        new Thread(new One2("error", "error")).start();
        new Thread(new One2("debugger", "debugger")).start();
    }

    //交换机内部类
    static class One implements Runnable{

        @Override
        public void run() {
            try{
                Consumer consumer  = new Consumer();
                consumer.reciiveExchange();
            }catch (Exception e){

            }
        }
    }

    // 交换机路由内部类
    static class One2 implements Runnable{

        String queueName;
        String routing;

        public One2(String queueName, String routing) {
            this.queueName = queueName;
            this.routing = routing;
        }

        @Override
        public void run() {
            try{
            Consumer consumer  = new Consumer();
            consumer.receiveExchangeroutingKey(queueName, routing);
            }catch (Exception e){

            }
        }
    }




    /*public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("123456");
        factory.setHost("172.16.128.93");
        //建立到代理服务器到连接
        Connection conn = factory.newConnection();
        //获得信道
        final Channel channel = conn.createChannel();
        //声明交换器
        String exchangeName = "hello-exchange";

        channel.exchangeDeclare(exchangeName, "direct", true);
        //声明队列
        String queueName = channel.queueDeclare().getQueue();
        System.out.println(queueName);
        String routingKey = "hola";
        //绑定队列，通过键 hola 将队列和交换器绑定起来

        channel.queueBind(queueName, exchangeName, routingKey);

        while(true) {
            //消费消息
            boolean autoAck = false;
            String consumerTag = "";
            channel.basicConsume(queueName, autoAck, consumerTag, new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag,
                                           Envelope envelope,
                                           AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {
                    String routingKey = envelope.getRoutingKey();
                    String contentType = properties.getContentType();
                    System.out.println("消费的路由键：" + routingKey);
                    System.out.println("消费的内容类型：" + contentType);
                    long deliveryTag = envelope.getDeliveryTag();
                    //确认消息
                    channel.basicAck(deliveryTag, false);
                    System.out.println("消费的消息体内容：");
                    String bodyStr = new String(body, "UTF-8");
                    System.out.println(bodyStr);

                }
            });
        }
    }*/



}
