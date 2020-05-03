package mode.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws InterruptedException {
        ConnectionPool connectionPool = new ConnectionPool();
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(new getConnection(connectionPool), i + ".tpm");
            thread.start();
        }
        while (1 == 1) {

        }

    }


    static class getConnection implements Runnable {
        ConnectionPool connectionPool = null;
        Connection connection = null;

        public getConnection(ConnectionPool connectionPool) {
            this.connectionPool = connectionPool;
        }

        @Override
        public void run() {
            try {
                connection = connectionPool.fetchConnection(-1);
                System.out.println("connection" + connection);
                Thread.sleep(10000);
                if (connection != null) {
                    connection.commit();
                }
                connectionPool.releaseConnection(connection);
            } catch (InterruptedException | SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
