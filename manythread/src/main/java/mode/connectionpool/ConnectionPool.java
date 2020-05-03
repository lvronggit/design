package mode.connectionpool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 数据库连接池
 */
public class ConnectionPool {
    private LinkedList<Connection> connections = new LinkedList<>();


    public ConnectionPool() {
        createConnection();
    }

    /**
     * 获取连接 超时则返回空
     *
     * @param mills
     * @return
     */
    public Connection fetchConnection(long mills) throws InterruptedException {
        // 取出第一个
        synchronized (connections) {
            System.out.println(Thread.currentThread().getName()+"获取连接");
            // 没有数据则根据时间等待
            if (connections.isEmpty()) {
                if (mills <= 0) {
                    while (connections.isEmpty()) {
                        connections.wait();
                    }
                } else {
                    connections.wait(mills);
                    if (connections.isEmpty()) {
                        return null;
                    }
                }
            }
            System.out.println(Thread.currentThread().getName()+"获取成功");
            return connections.removeFirst();


        }

    }

    /**
     * 释放连接
     *
     * @param connection
     */

    public void releaseConnection(Connection connection) {
        if(connection == null){
            return;
        }
        synchronized (connections) {
            connections.add(connection);
            connections.notifyAll();
        }
        System.out.println(Thread.currentThread().getName()+"释放连接");

    }

    /**
     * 创建连接
     * @return
     */
    public void createConnection(){

        for (int i = 0; i <10 ; i++) {
            // 代理类生成连接
            Connection connection = ConnectionDriver.createConnection();
            connections.add(connection);

        }

    }


}
