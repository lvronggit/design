package mqjar.mqconnect;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import mqjar.ReceiveContent;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class MQreceive {

    private ReceiveContent receiveContent;
    private String queueName;
    private Map<String, ReceiveContent> receiveContentMap;
    private String exchangeName;

    public void mqreceive() {
        try {
            RabbitMQConnectUtil rabbitMQConnectUtil = RabbitMQConnectUtil.getInstance();

            Connection connection = rabbitMQConnectUtil.getConnection();
            Channel channel = connection.createChannel();

            queueName = rabbitMQConnectUtil.getQueueName();
            exchangeName = rabbitMQConnectUtil.getExchangeName();
            receiveContentMap = rabbitMQConnectUtil.getReceiveContentMap();
            channel.queueDeclare(queueName, false ,false ,false  ,null);

            channel.exchangeDeclare(exchangeName, "topic");

            for (String key: rabbitMQConnectUtil.getRoutingkeys() ) {
                channel.queueBind(queueName, exchangeName, key);
            }

            DeliverCallback deliverCallback = (( var1,  var2) -> {
                byte[] body = var2.getBody();
                String key = var2.getEnvelope().getRoutingKey();
                receiveContent =  receiveContentMap.get(key);
                receiveContent.receive(body);
                channel.basicAck(var2.getEnvelope().getDeliveryTag(),false);
            });

            channel.basicConsume(queueName, deliverCallback, (var1, var2)->{});


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }


}
