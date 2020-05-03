package mqjar.mqconnect;

import mqjar.CaseReceive;
import mqjar.ReceiveContent;
import mqjar.UserService;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class TestDemo {

    public static void main(String[] args) throws IOException, TimeoutException {
        RabbitMQConnectUtil rabbitMQConnectUtil = RabbitMQConnectUtil.getInstance();
        CaseReceive caseReceive = new CaseReceive();
        UserService userService = new UserService();
        Map<String, ReceiveContent> map = new HashMap<>();
        map.put("user", userService);
        map.put("case", caseReceive);
        List<String> keys = new LinkedList<>();
        keys.add("user");
        keys.add("case");
        rabbitMQConnectUtil.init("172.16.128.93", "admin", "123456","oooo",keys,map);




        MQsend mQsend = new MQsend();
        mQsend.send("案卷信息","case");
        mQsend.send("用户信息","user");
        new Thread(() -> {
            MQreceive mQreceive = new MQreceive();
            mQreceive.mqreceive();
        }).start();

    }

}
