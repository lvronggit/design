package mqjar.mqconnect;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MQsend {


    public void send(String message, String routingkey) throws IOException, TimeoutException {

        RabbitMQConnectUtil rabbitMQConnectUtil = RabbitMQConnectUtil.getInstance();
        Connection connection =rabbitMQConnectUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(rabbitMQConnectUtil.getQueueName(), false ,false ,false  ,null);
        channel.exchangeDeclare(rabbitMQConnectUtil.getExchangeName(), "topic");
        channel.basicPublish(rabbitMQConnectUtil.getExchangeName(), routingkey, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
    }

}
