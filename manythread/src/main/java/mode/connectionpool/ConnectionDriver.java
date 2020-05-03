package mode.connectionpool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * 创建连接类
 */
public class ConnectionDriver {

    static class ConnectionHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 提交的时候睡眠10秒
            if (method.getName().equals("commit")) {
                TimeUnit.SECONDS.sleep(10);
            }

            return null;
        }
    }


    public static Connection createConnection() {
       return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class[]{Connection.class},
                new ConnectionHandler());
    }


}
